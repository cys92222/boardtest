package com.example.demo.dao;

import java.util.List;

import com.example.demo.vo.MemberVo;

public interface MemberDao {
//	모든회원
	List<MemberVo> AllMember();
	
//	id 중복확인
	int checkId(String in_id);
	
//	로그인
	int login(MemberVo m);
	
//	회원가입
	int insertMember(MemberVo m);
}
