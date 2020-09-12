package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.MemberService;
import com.example.demo.vo.MemberVo;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	//모든회원
	@RequestMapping("/member/AllMember")
	public String AllMember(Model model) {
		List<MemberVo> list = memberService.AllMember();
		model.addAttribute("AllMember", list);
		
		return "/member/AllMember";
	}
	
	//회원가입폼
	@RequestMapping("/member/insertMemberForm")
	public String insertMemberForm() {
		return "/member/insertMember";
	}
	
	//회원가입
	@RequestMapping("/member/insertMember")
	public String insertMember(MemberVo m) {
		memberService.insertMember(m);
		return "/main";
	}
	
	//id중복 확인
	@RequestMapping("/member/checkId")
	@ResponseBody
	public String checkId(String in_id) {
		
		String re = "사용 가능한 id입니다";
		
		int chk = memberService.checkId(in_id);
		
		if(chk == 1) {
			re = "이미 사용중인 id입니다";
		}
		
		return re;
	}
}
