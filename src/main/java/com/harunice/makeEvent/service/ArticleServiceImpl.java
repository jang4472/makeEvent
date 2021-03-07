package com.harunice.makeEvent.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harunice.makeEvent.controller.ArticleController;
import com.harunice.makeEvent.dao.ArticleDao;
import com.harunice.makeEvent.dto.Article;
import com.harunice.makeEvent.util.CUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	ArticleDao articleDao;
	// 이제 ArticleService는 데이터 관련해서는 모두 Dao에게 위임
	@Override
	public List<Article> getList() {
		return articleDao.getList();
	}

	@Override
	public long add(Map<String, Object> param) {
		articleDao.add(param);
		
		return CUtil.getAsLong(param.get("id"));
	}

	@Override
	public int getTotalCount() {
		return articleDao.getTotalCount();
	}

	@Override
	public Article getOne(long id) {
		
		return articleDao.getOne(id);
	}	
}