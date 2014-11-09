package management.fileformat.bo;


import java.util.List;

import management.fileformat.pojos.Departments;


public interface DepartmentsBo {
	
	
	public Departments findById(java.lang.String id);
	

	public List<Departments> findByExample(Departments instance);

	public List findByProperty(String propertyName, Object value);

	public List<Departments> findByDeptName(Object deptName);

	public List findAll();
	public List findAllDistinct();

	
	
}
