package management.fileformat.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import management.fileformat.pojos.Departments;
import management.fileformat.utils.CustomHibernateDaoSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for
 * Departments entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see management.fileformat.pojos.Departments
 * @author MyEclipse Persistence Tools
 */
@Repository("DepartmentsDAO")
public class DepartmentsDAO extends CustomHibernateDaoSupport  /*BaseHibernateDAO*/ {
	private static final Log log = LogFactory.getLog(DepartmentsDAO.class);
	// property constants
	public static final String DEPT_NAME = "deptName";

	
	public Departments findById(java.lang.String id) {
		log.debug("getting Departments instance with id: " + id);
		try {
			Departments instance = (Departments) getHibernateTemplate().get(
					"management.fileformat.pojos.Departments", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Departments> findByExample(Departments instance) {
		log.debug("finding Departments instance by example");
		try {
			List<Departments> results = (List<Departments>) getSession()
					.createCriteria("management.fileformat.pojos.Departments")
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
		log.debug("finding Departments instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Departments as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Departments> findByDeptName(Object deptName) {
		return findByProperty(DEPT_NAME, deptName);
	}

	public List findAll() {
		log.debug("finding all Departments instances");
		try {
			String queryString = "select dept.deptNo, dept.deptName from Departments dept";
			/*Query queryObject = getHibernateTemplate().createQuery(queryString);
			return queryObject.list();*/
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findAllDistinct() {
		log.debug("finding all Departments instances");
		try {
			String queryString = " DISTINCT from Departments";
			/*Query queryObject = getHibernateTemplate().createQuery(queryString);
			return queryObject.list();*/
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	
}