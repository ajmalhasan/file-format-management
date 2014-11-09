package management.fileformat.bo;


import java.util.List;

import management.fileformat.pojos.DeptManager;


public interface DeptManagerBo {


	public void save(DeptManager transientInstance);

	public void delete(DeptManager persistentInstance);

	public DeptManager findById(management.fileformat.pojos.DeptManagerId id);

	public List<DeptManager> findByExample(DeptManager instance);

	public List findByProperty(String propertyName, Object value);

	public List findAll();

	public DeptManager merge(DeptManager detachedInstance);

	public void attachDirty(DeptManager instance);

	public void attachClean(DeptManager instance) ;
}
