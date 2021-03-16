package com.harunice.makeEvent.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.harunice.makeEvent.dto.Member;

@Mapper
public interface MemberDao {

	void join(Map<String, Object> param);

	Member getMemberByLoginId(@Param("loginId") String loginId);

}
