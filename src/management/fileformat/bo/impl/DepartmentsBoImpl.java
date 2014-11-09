package management.fileformat.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import management.fileformat.bo.DepartmentsBo;
import management.fileformat.dao.DepartmentsDAO;
import management.fileformat.pojos.Departments;

@Service("departmentsBo")
public class DepartmentsBoImpl implements DepartmentsBo {

	@Autowired
	DepartmentsDAO departmentsDAO;
	
	
	public List findAll() {
		return departmentsDAO.findAll();
	}
	
	public List findAllDistinct() {
		return departmentsDAO.findAll();
	}

	public List<Departments> findByDeptName(Object deptName) {
		return departmentsDAO.findByDeptName(deptName);
	}

	public List<Departments> findByExample(Departments instance) {
		return departmentsDAO.findByExample(instance);
	}

	public Departments findById(String id) {
		return departmentsDAO.findById(id);
	}

	public List findByProperty(String propertyName, Object value) {
		return departmentsDAO.findByProperty(propertyName, value);
	}

	

}
