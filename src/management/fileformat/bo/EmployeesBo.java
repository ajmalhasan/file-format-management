package management.fileformat.bo;


import java.util.List;

import management.fileformat.pojos.Employees;


public interface EmployeesBo {


	

	public Employees findById(java.lang.Integer id);

	public List<Employees> findByExample(Employees instance) ;

	public List findByProperty(String propertyName, Object value);

	public List<Employees> findByFirstName(Object firstName);

	public List<Employees> findByLastName(Object lastName);

	public List<Employees> findByGender(Object gender) ;

	public List findAll();
	
	public List<Object[]> findByTitle(String titleId);
	public List<Object[]> findByDepartment(String department);
	

	
}
