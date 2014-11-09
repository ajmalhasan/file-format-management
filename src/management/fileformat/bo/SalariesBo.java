package management.fileformat.bo;


import java.util.List;

import management.fileformat.pojos.Salaries;


public interface SalariesBo {


	public void save(Salaries transientInstance) ;

	public void delete(Salaries persistentInstance) ;

	public Salaries findById(management.fileformat.pojos.SalariesId id);

	public List<Salaries> findByExample(Salaries instance);

	public List findByProperty(String propertyName, Object value) ;

	public List<Salaries> findBySalary(Object salary) ;

	public List findAll();

	public Salaries merge(Salaries detachedInstance);

	public void attachDirty(Salaries instance) ;

	public void attachClean(Salaries instance);
}
