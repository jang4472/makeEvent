package com.harunice.makeEvent.service;

import java.util.List;
import java.util.Map;

import com.harunice.makeEvent.dto.Article;

public interface ArticleService {
	public List<Article> getList();

	public long add(Map<String, Object> param);
	
}
