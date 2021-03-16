package com.harunice.makeEvent.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harunice.makeEvent.dao.MemberDao;
import com.harunice.makeEvent.dto.Member;
import com.harunice.makeEvent.util.CUtil;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;

	@Override
	public Map<String, Object> join(Map<String, Object> param){
		Map<String, Object> rs = new HashMap<String, Object>();
		String loginId = (String)param.get("loginId");
		Member member = memberDao.getMemberByLoginId(loginId);		
		
		if (member == null) {
			memberDao.join(param);
			
			long id = CUtil.getAsLong(param.get("id"));
			
			rs.put("resultCode", "S-1");
			rs.put("id", id);
			rs.put("msg", "회원가입이 완료되었습니다.");
		} else {
			rs.put("resultCode", "F-1");
			rs.put("msg", "이미 존재하는 아이디 입니다.");
		}
		
		
		return rs;
	}

}
