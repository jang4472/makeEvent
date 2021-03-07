package com.harunice.makeEvent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticleController {
	@RequestMapping("/article/list")
	public String showMain() {
		return "article/list";
	}
}
