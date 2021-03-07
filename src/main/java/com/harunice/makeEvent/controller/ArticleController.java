package com.harunice.makeEvent.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.harunice.makeEvent.dto.Article;
import com.harunice.makeEvent.service.ArticleService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j  // 이걸해야 log.info 가능
public class ArticleController {
	@Autowired
	ArticleService articleService;
	
	@RequestMapping("/article/list")
	public String showMain(Model aModel) {
		List<Article> list = articleService.getList();
		int totalCount = articleService.getTotalCount();
		
		//log.info("list : " + list);
		aModel.addAttribute("list", list);
		// request.setAttribute("list", list); 와 똑같은 표현!
		aModel.addAttribute("totalCount", totalCount);
		
		return "article/list";
	}
	
	@RequestMapping("/article/add")
	public String showAdd(Model aModel) {
		return "article/add";
	}
	
	@RequestMapping("/article/doAdd")
	@ResponseBody
	// HttpServletRequest req;
	public String doAdd(@RequestParam Map<String, Object> param) {
		long newId = articleService.add(param);		
		String msg = newId + "번 게시물이 추가되었습니다.";
		
		StringBuilder sb = new StringBuilder();		
		sb.append("alert('" + msg + "');");
		sb.append("location.replace('./detail?id=" + newId + "');'");
		sb.insert(0, "<script>");
		sb.append("</script>");
		return sb.toString();
	}
}
