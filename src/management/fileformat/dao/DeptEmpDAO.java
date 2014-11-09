package management.fileformat.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import management.fileformat.pojos.DeptEmp;
import management.fileformat.utils.CustomHibernateDaoSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for
 * DeptEmp entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see management.fileformat.pojos.DeptEmp
 * @author MyEclipse Persistence Tools
 */
@Repository("DeptEmpDAO")
public class DeptEmpDAO extends CustomHibernateDaoSupport {
	private static final Log log = LogFactory.getLog(DeptEmpDAO.class);

	// property constants

	public void save(DeptEmp transientInstance) {
		log.debug("saving DeptEmp instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(DeptEmp persistentInstance) {
		log.debug("deleting DeptEmp instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DeptEmp findById(management.fileformat.pojos.DeptEmpId id) {
		log.debug("getting DeptEmp instance with id: " + id);
		try {
			DeptEmp instance = (DeptEmp) getHibernateTemplate().get(
					"management.fileformat.pojos.DeptEmp", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<DeptEmp> findByExample(DeptEmp instance) {
		log.debug("finding DeptEmp instance by example");
		try {
			List<DeptEmp> results = (List<DeptEmp>) getSession()
					.createCriteria("management.fileformat.pojos.DeptEmp").add(
							create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding DeptEmp instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "select DISTINCT from DeptEmp as model where model.id."
					+ propertyName + "= ? ";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all DeptEmp instances");
		try {
			String queryString = "from DeptEmp";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public DeptEmp merge(DeptEmp detachedInstance) {
		log.debug("merging DeptEmp instance");
		try {
			DeptEmp result = (DeptEmp) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DeptEmp instance) {
		log.debug("attaching dirty DeptEmp instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DeptEmp instance) {
		log.debug("attaching clean DeptEmp instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}