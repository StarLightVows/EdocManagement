package org.star.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.star.model.EdocEntry;

public interface EdocEntryMapper {
	List<EdocEntry> getAllEdocEntry(@Param("categoryId")Integer categoryId);
	
	Integer delEdocEntry(@Param("id")Integer id);
}