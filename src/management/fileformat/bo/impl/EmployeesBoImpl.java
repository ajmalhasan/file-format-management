package management.fileformat.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import management.fileformat.bo.EmployeesBo;
import management.fileformat.dao.EmployeesDAO;
import management.fileformat.pojos.Employees;

@Service("employeesBo")
public class EmployeesBoImpl implements EmployeesBo {

	@Autowired
	EmployeesDAO employeesDAO;
	public List findAll() {
		return employeesDAO.findAll();
	}

	public List<Employees> findByExample(Employees instance) {
		return employeesDAO.findByExample(instance);
	}

	public List<Employees> findByFirstName(Object firstName) {
		return employeesDAO.findByFirstName(firstName);
	}

	public List<Employees> findByGender(Object gender) {
		return employeesDAO.findByGender(gender);
	}

	public Employees findById(Integer id) {
		return employeesDAO.findById(id);
	}

	public List<Employees> findByLastName(Object lastName) {
		return employeesDAO.findByLastName(lastName);
	}

	public List findByProperty(String propertyName, Object value) {
		return employeesDAO.findByProperty(propertyName, value);
	}

	public List<Object[]> findByTitle(String title) {
		return employeesDAO.findByTitle(title);
	}

	public List<Object[]> findByDepartment(String department) {
		return employeesDAO.findByDepartment(department);
	}
	

}
