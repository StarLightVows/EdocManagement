package org.star.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.star.dao.EdocEntryMapper;
import org.star.model.EdocEntry;
import org.star.service.EdocEntryService;

@Service
public class EdocEntryServiceImpl implements EdocEntryService {
	
	@Autowired
	private EdocEntryMapper edocEntryMapper;
	
	@Override
	public List<EdocEntry> getAllEdocEntry(Integer categoryId) {
		return edocEntryMapper.getAllEdocEntry(categoryId);
	}

	@Override
	public Integer delEdocEntry(Integer id) {
		return edocEntryMapper.delEdocEntry(id);
	}
	
}
