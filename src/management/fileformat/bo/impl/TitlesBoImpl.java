package management.fileformat.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import management.fileformat.bo.TitlesBo;
import management.fileformat.dao.TitlesDAO;
import management.fileformat.pojos.Titles;
import management.fileformat.pojos.TitlesId;

@Service("titlesBo")
public class TitlesBoImpl implements TitlesBo {

	@Autowired
	TitlesDAO titlesDAO;
	
	public List findAll() {
		return titlesDAO.findAll();
	}

	public List<Titles> findByExample(Titles instance) {
		return titlesDAO.findByExample(instance);
	}

	public Titles findById(TitlesId id) {
		return titlesDAO.findById(id);
	}

	public List findByProperty(String propertyName, Object value) {
		return titlesDAO.findByProperty(propertyName, value);
	}


}
