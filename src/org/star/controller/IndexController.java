package org.star.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.star.model.EdocCategory;
import org.star.model.EdocEntry;
import org.star.service.EdocCategoryService;
import org.star.service.EdocEntryService;

import java.util.List;

@RestController
@RequestMapping("/index")
public class IndexController {
	@Autowired
	private EdocCategoryService edocCategoryService;
	
	@Autowired
	private EdocEntryService edocEntryService;
	
	@GetMapping("initEdocCategoryData")
	public String initEdocCategoryData() {
		List<EdocCategory> allEdocCategory = edocCategoryService.getAllEdocCategory();
		return JSON.toJSONString(allEdocCategory);
	}
	
	@GetMapping("initEdocEntryData/{categoryId}/{currentPage}")
	public String initEdocEntryData(@PathVariable("categoryId")Integer categoryId,@PathVariable("currentPage")Integer currentPage) {
//		PageHelper.offsetPage(currentPage, 5);	  //该方法就是一个拦截器，将下面执行的sql语句拼接上limit关键字，从哪条数据开始显示，limit ?,?
		PageHelper.startPage(currentPage,5);	//分页方法，通过页码分页，可以通过日志查看两者的sql语句
		List<EdocEntry> allEdocEntry = edocEntryService.getAllEdocEntry(categoryId);
		PageInfo<EdocEntry> pageInfo = new PageInfo<EdocEntry>(allEdocEntry);
		System.err.println(pageInfo.getNavigateFirstPage());
		return JSON.toJSONString(pageInfo);
	}
	
	@PostMapping("delEdocEntry/{id}")
	public String delEdocEntry(@PathVariable("id")Integer id) {
		Integer integer = edocEntryService.delEdocEntry(id);
		String msg = "删除失败";
		if (integer>0) {
			msg = "删除成功";
		}
		return JSON.toJSONString(msg);
	}
}
