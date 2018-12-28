package org.star.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.star.dao.EdocCategoryMapper;
import org.star.model.EdocCategory;
import org.star.service.EdocCategoryService;
@Service
public class EdocCategoryServiceImpl implements EdocCategoryService {
	@Autowired
	private EdocCategoryMapper edocCategoryMapper;
	
	@Override
	public List<EdocCategory> getAllEdocCategory() {
		return edocCategoryMapper.getAllEdocCategory();
	}

}
