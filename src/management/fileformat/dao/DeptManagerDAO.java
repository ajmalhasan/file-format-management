package management.fileformat.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import management.fileformat.pojos.DeptManager;
import management.fileformat.utils.CustomHibernateDaoSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for
 * DeptManager entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see management.fileformat.pojos.DeptManager
 * @author MyEclipse Persistence Tools
 */
@Repository("DeptManagerDAO")
public class DeptManagerDAO extends CustomHibernateDaoSupport {
	private static final Log log = LogFactory.getLog(DeptManagerDAO.class);

	// property constants

	public void save(DeptManager transientInstance) {
		log.debug("saving DeptManager instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(DeptManager persistentInstance) {
		log.debug("deleting DeptManager instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DeptManager findById(management.fileformat.pojos.DeptManagerId id) {
		log.debug("getting DeptManager instance with id: " + id);
		try {
			DeptManager instance = (DeptManager) getHibernateTemplate().get(
					"management.fileformat.pojos.DeptManager", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<DeptManager> findByExample(DeptManager instance) {
		log.debug("finding DeptManager instance by example");
		try {
			List<DeptManager> results = (List<DeptManager>) getSession()
					.createCriteria("management.fileformat.pojos.DeptManager")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding DeptManager instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from DeptManager as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all DeptManager instances");
		try {
			String queryString = "from DeptManager";
			return  getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public DeptManager merge(DeptManager detachedInstance) {
		log.debug("merging DeptManager instance");
		try {
			DeptManager result = (DeptManager) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DeptManager instance) {
		log.debug("attaching dirty DeptManager instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DeptManager instance) {
		log.debug("attaching clean DeptManager instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}