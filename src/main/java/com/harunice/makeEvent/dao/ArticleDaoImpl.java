package com.harunice.makeEvent.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.harunice.makeEvent.dto.Article;

@Component // 이렇게 해야 AutoWired에 의한 연결에 적용된다.
public class ArticleDaoImpl implements ArticleDao {
	public List<Article> getList(){
		Article article1 = new Article(1L, "2021-03-07 15:35:00", "제목1", "내용1");
		Article article2 = new Article(2L, "2021-03-07 15:35:00", "제목2", "내용2");
		Article article3 = new Article(3L, "2021-03-07 15:35:00", "제목3", "내용3");
		
		List<Article> list = new ArrayList<>();
		
		list.add(article3);
		list.add(article2);
		list.add(article1);
		
		return list;
	}
}
