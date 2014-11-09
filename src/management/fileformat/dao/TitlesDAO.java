package management.fileformat.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import management.fileformat.pojos.Titles;
import management.fileformat.utils.CustomHibernateDaoSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for
 * Titles entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see management.fileformat.pojos.Titles
 * @author MyEclipse Persistence Tools
 */
@Repository("TitlesDAO")
public class TitlesDAO extends CustomHibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TitlesDAO.class);

	// property constants

	public void save(Titles transientInstance) {
		log.debug("saving Titles instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Titles persistentInstance) {
		log.debug("deleting Titles instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Titles findById(management.fileformat.pojos.TitlesId id) {
		log.debug("getting Titles instance with id: " + id);
		try {
			Titles instance = (Titles) getHibernateTemplate().get(
					"management.fileformat.pojos.Titles", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Titles> findByExample(Titles instance) {
		log.debug("finding Titles instance by example");
		try {
			List<Titles> results = (List<Titles>) getSession().createCriteria(
					"management.fileformat.pojos.Titles").add(create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Titles instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Titles as model where model.id."
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
		log.debug("finding all Titles instances");
		try {
			String queryString = "from Titles";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Titles merge(Titles detachedInstance) {
		log.debug("merging Titles instance");
		try {
			Titles result = (Titles) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Titles instance) {
		log.debug("attaching dirty Titles instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Titles instance) {
		log.debug("attaching clean Titles instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}