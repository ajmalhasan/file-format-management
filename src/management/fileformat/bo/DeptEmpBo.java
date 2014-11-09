package management.fileformat.bo;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import management.fileformat.pojos.DeptEmp;


public interface DeptEmpBo {



	public DeptEmp findById(management.fileformat.pojos.DeptEmpId id);

	public List<DeptEmp> findByExample(DeptEmp instance) ;

	public List findByProperty(String propertyName, Object value);

	public List findAll();


}
