package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.MemberService;
import com.example.demo.vo.MemberVo;

@Controller
public class MainController {

	@Autowired
	MemberService MemberService;
	
	//메인
	@RequestMapping("/main")
	public String Main() {
		return "/main";
	}
	
	//로그인 폼
	@RequestMapping("/loginForm")
	public String loginForm(String url, Model model) {
		
		//로그인후 로그인 요청했던 페이지로 이동하기위해
		//jsp에서
		//<a href="/loginForm?url=/board/detailBoard?board_no=${detail.board_no }">로그인</a>
		//<a href="/loginForm?url=/board/AllBoard">로그인</a>
		//이런식으로 앙크 요청함
		
//		System.out.println("로그인 요청 url " + url);
		model.addAttribute("url", url);
		

		return "/login";
	}
	
	//로그인
	@RequestMapping("/login")
	@ResponseBody
	public String login(MemberVo m, HttpSession session, Model model, String url) {
//		String url = (String)model.getAttribute("url");
		
//		System.out.println("로그인 아이디 " + m.getId());
		int re = MemberService.login(m);
//		System.out.println("로그인 성공 여부 1이면 성공 " re);
		
		String result = "아이디 암호를 확인하세요";
		
		if(re == 1) {
//			System.out.println("로그인 성공");
			session.setAttribute("loginid", m.getId());
			HashMap<String, String> asd = new HashMap<String, String>();
			asd.put("loginid", m.getId());
			asd.put("url", url);
//			System.out.println(asd);
//			System.out.println("로그인 요청 url " + url);
			
			return url;
			
		}
		
//		System.out.println("아이디 비번 틀림");
		return result;
	}
	
	//로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginid");
		return "/main";
	}
}
