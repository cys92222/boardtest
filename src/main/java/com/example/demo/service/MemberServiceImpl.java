package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDao;
import com.example.demo.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao MemberDao;
	
//	모든 회원
	@Override
	public List<MemberVo> AllMember() {
		// TODO Auto-generated method stub
		List<MemberVo> list = MemberDao.AllMember();
		return list;
	}

//	id 중복 확인
	@Override
	public int checkId(String in_id) {
		// TODO Auto-generated method stub
		int re = MemberDao.checkId(in_id);
		return re;
	}

//	로그인
	@Override
	public int login(MemberVo m) {
		// TODO Auto-generated method stub
		int re = MemberDao.login(m);
		return re;
	}

//	회원가입
	@Override
	public int insertMember(MemberVo m) {
		// TODO Auto-generated method stub
		int re = -1;
		re = MemberDao.insertMember(m);
		return re;
	}

}
