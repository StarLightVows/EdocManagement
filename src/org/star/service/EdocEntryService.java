package org.star.service;

import java.util.List;

import org.star.model.EdocEntry;

public interface EdocEntryService {
	List<EdocEntry> getAllEdocEntry(Integer categoryId);
	
	Integer delEdocEntry(Integer id);
}
