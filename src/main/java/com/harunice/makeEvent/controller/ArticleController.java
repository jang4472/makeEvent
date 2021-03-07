package com.harunice.makeEvent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.harunice.makeEvent.dto.Article;
import com.harunice.makeEvent.service.ArticleService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j  // 이걸해야 log.info 가능
public class ArticleController {
	@Autowired
	ArticleService articleService;
	
	@RequestMapping("/article/list")
	public String showMain() {
		List<Article> list = articleService.getList();
		
		log.info("list : " + list);
		
		return "article/list";
	}
}
