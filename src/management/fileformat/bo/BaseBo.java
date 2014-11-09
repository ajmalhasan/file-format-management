package management.fileformat.bo;

import java.util.List;

import management.fileformat.pojos.Titles;

public interface BaseBo {
	public Titles findById(management.fileformat.pojos.TitlesId id) ;

	public List<Titles> findByExample(Titles instance) ;

	public List findByProperty(String propertyName, Object value) ;

	public List findAll();
}
