package management.fileformat.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import management.fileformat.pojos.Employees;
import management.fileformat.utils.CustomHibernateDaoSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for
 * Employees entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see management.fileformat.pojos.Employees
 * @author MyEclipse Persistence Tools
 */
@Repository("EmployeesDAO")
public class EmployeesDAO extends CustomHibernateDaoSupport {
	private static final Log log = LogFactory.getLog(EmployeesDAO.class);
	// property constants
	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String GENDER = "gender";

	
	public Employees findById(java.lang.Integer id) {
		log.debug("getting Employees instance with id: " + id);
		try {
			Employees instance = (Employees) getHibernateTemplate().get(
					"management.fileformat.pojos.Employees", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Employees> findByExample(Employees instance) {
		log.debug("finding Employees instance by example");
		try {
			List<Employees> results = (List<Employees>) getSession()
					.createCriteria("management.fileformat.pojos.Employees")
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
		log.debug("finding Employees instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Employees as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List<Employees> findByFirstName(Object firstName) {
		return findByProperty(FIRST_NAME, firstName);
	}

	public List<Employees> findByLastName(Object lastName) {
		return findByProperty(LAST_NAME, lastName);
	}

	public List<Employees> findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}
	
	public List<Object[]> findByTitle(String title) {
		log.debug("finding all Employees by title");
		try {
			String queryString = " select employee.empNo, employee.firstName, employee.lastName, employee.gender, titles.id.title from Employees employee, Titles titles where employee.empNo = titles.id.empNo AND titles.id.title='"+title+"'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List<Object[]> findByDepartment(String department) {
		log.debug("finding all Employees by title");
		try {
			String queryString = " select employee.empNo, employee.firstName, employee.lastName, employee.gender from Employees employee, DeptEmp department where employee.empNo = department.id.empNo AND department.id.deptNo='"+department+"'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Employees instances");
		try {
			String queryString = " select employee.empNo, employee.firstName, employee.lastName, employee.gender from Employees employee";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}



	
}