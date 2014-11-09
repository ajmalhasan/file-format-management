package management.fileformat.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import management.fileformat.bo.DeptEmpBo;
import management.fileformat.dao.DeptEmpDAO;
import management.fileformat.pojos.DeptEmp;
import management.fileformat.pojos.DeptEmpId;

@Service("deptEmpBo")
public class DeptEmpBoImpl implements DeptEmpBo {
	
	@Autowired
	DeptEmpDAO deptEmpDAO;


	public List findAll() {
		return deptEmpDAO.findAll();
	}

	public List<DeptEmp> findByExample(DeptEmp instance) {
		return deptEmpDAO.findByExample(instance);
	}

	public DeptEmp findById(DeptEmpId id) {
		return deptEmpDAO.findById(id);
	}

	public List findByProperty(String propertyName, Object value) {
		return deptEmpDAO.findByProperty(propertyName, value);
	}



}
