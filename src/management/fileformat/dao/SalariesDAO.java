package management.fileformat.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import management.fileformat.pojos.Salaries;
import management.fileformat.utils.CustomHibernateDaoSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for
 * Salaries entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see management.fileformat.pojos.Salaries
 * @author MyEclipse Persistence Tools
 */
@Repository("SalariesDAO")
public class SalariesDAO extends CustomHibernateDaoSupport {
	private static final Log log = LogFactory.getLog(SalariesDAO.class);
	// property constants
	public static final String SALARY = "salary";

	public void save(Salaries transientInstance) {
		log.debug("saving Salaries instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Salaries persistentInstance) {
		log.debug("deleting Salaries instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Salaries findById(management.fileformat.pojos.SalariesId id) {
		log.debug("getting Salaries instance with id: " + id);
		try {
			Salaries instance = (Salaries) getHibernateTemplate().get(
					"management.fileformat.pojos.Salaries", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Salaries> findByExample(Salaries instance) {
		log.debug("finding Salaries instance by example");
		try {
			List<Salaries> results = (List<Salaries>) getSession()
					.createCriteria("management.fileformat.pojos.Salaries")
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
		log.debug("finding Salaries instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Salaries as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Salaries> findBySalary(Object salary) {
		return findByProperty(SALARY, salary);
	}

	public List findAll() {
		log.debug("finding all Salaries instances");
		try {
			String queryString = "from Salaries";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Salaries merge(Salaries detachedInstance) {
		log.debug("merging Salaries instance");
		try {
			Salaries result = (Salaries) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Salaries instance) {
		log.debug("attaching dirty Salaries instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Salaries instance) {
		log.debug("attaching clean Salaries instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}