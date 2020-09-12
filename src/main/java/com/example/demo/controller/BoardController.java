package com.example.demo.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.BoardService;
import com.example.demo.vo.BoardVo;
import com.example.demo.vo.Board_commentVo;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
//	모든 게시물
	@RequestMapping("/board/AllBoard")
	public String AllBoard(Model model) {
		List<BoardVo> list = boardService.AllBoard();
		model.addAttribute("AllBoard", list);
		return "/board/AllBoard";
	}
	
//	게시물 작성 폼
	@RequestMapping("/board/insertBoardForm")
	public String insertBoardForm() {
		return "/board/insertBoard";
	}
	
//	게시물 작성
	@RequestMapping("/board/insertBoard")
	public String insertBoard(BoardVo b, MultipartFile mf, HttpServletRequest request) {
//		게시물 등록후 등록한 게시물 상세페이지로 이동하기위한 셋팅
		int b_no = boardService.searchBoard_no();
		b.setBoard_no(b_no);
		
//		System.out.println(mf);
		String up = mf.getOriginalFilename();
		
//		파일을 업로드했다면
		if(up != null && !up.equals("")) {
			String filename = mf.getOriginalFilename();
			b.setFilename(filename);
			System.out.println("파일 첨부");
			
//			저장 경로
			String path = request.getRealPath("/file/img");
//			System.out.println(path);
//			파일저장
			try {
				byte[] data = mf.getBytes();
//				저장경로, 파일 이름
				FileOutputStream fos = new FileOutputStream(path + "/" + filename);
				fos.write(data);
//				fos는 사용후 클로즈 해야됨
				fos.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			
			
		//파일을 업로드하지 않았다면
		}else {
			b.setFilename("");
		}
		
		
		
		boardService.insertBoard(b);
		
		return "redirect:/board/detailBoard?board_no="+b.getBoard_no();
	}
	
//	게시물 상세보기
	@RequestMapping("/board/detailBoard")
	public String detailBoard(BoardVo b, Model model) {
		BoardVo detail = boardService.detailBoard(b);
		boardService.hit(b);
		model.addAttribute("detail", detail);
		model.addAttribute("comment", boardService.AllBoardComment(b));
		return "/board/detailBoard";
	}
	
//	게시물 삭제
	@RequestMapping("/board/deleteBoard")
	public String deleteBoard(BoardVo b, HttpServletRequest request) {
		Board_commentVo bc = new Board_commentVo();
		bc.setBoard_no(b.getBoard_no());
		boardService.deleteAllComment(bc);
		boardService.deleteBoard(b);
		
//		업로드한 파일이 있으면
		if(b.getFilename() != null && !b.getFilename().equals("")) {
//			파일 삭제
			String path = request.getRealPath("/file/img");
			try {
				File file = new File(path + "/" + b.getFilename());
//				System.out.println("삭제할 파일 경로 파일 이름" + path + "/" + b.getFilename());
				file.delete();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		

		return "redirect:/board/AllBoard";
	}
	
//	게시물 수정폼
	@RequestMapping("/board/updateBoardForm")
	public String updateBoardForm(BoardVo b, Model model) {
		BoardVo detail = boardService.detailBoard(b);
		model.addAttribute("detail", detail);
		return "/board/updateBoard";
	}

//	게시물 수정
	@RequestMapping("/board/updateBoard")
	public String updateBoard(BoardVo b, MultipartFile mf, HttpServletRequest request, String oldfilename) {
		
		String up = mf.getOriginalFilename();
		System.out.println("업로드 파일 이름" + up);
//		새로 업로드한 파일이 있는지
		if(up != null && !up.equals("")) {
			System.out.println("새로 업로드한 파일 있음");
			String path = request.getRealPath("/file/img");
//			기존 업로드한 파일이 있는지, 기존 파일이 있으면 기존 파일 삭제 후 새로 업로드한 파일 저장
			if( b.getFilename() != null && !b.getFilename().equals("")) {
				System.out.println("기존 업로드한 파일 있음");
				File file = new File(path + "/" + b.getFilename());
				file.delete();
				
				try {
					byte[] data = mf.getBytes();
					FileOutputStream fos = new FileOutputStream(path + "/" + up);
					fos.write(data);
					fos.close();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				b.setFilename(up);
//				기존 파일이 없으면 새로 업로드한 파일 저장
			}else {
				System.out.println("기존 업로드한 파일 없음");
				try {
					byte[] data = mf.getBytes();
					FileOutputStream fos = new FileOutputStream(path + "/" + up);
					fos.write(data);
					fos.close();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				b.setFilename(up);
			}
//			새로 업로드한 파일이 없으면
		}else {
			System.out.println("새로 업로드한 파일 없음");
			b.setFilename(b.getFilename());
//			System.out.println("1111111111" + oldfilename);
//			System.out.println("2222222222" + b.getFilename());
//			수정 페이지에서 사진 삭제버튼 눌렀을때
			if(!b.getFilename().equals(oldfilename)) {
//				System.out.println("수정 페이지에서 삭제버튼 누름");
				String path = request.getRealPath("/file/img");
				File file = new File(path + "/" + oldfilename);
				file.delete();
			}
			
		}
		
		

		
//		System.out.println(b);
		boardService.updateBoard(b);
		return "redirect:/board/detailBoard?board_no="+b.getBoard_no();
	}
	
//	댓글 등록
	@RequestMapping("/board/insertBoardComment")
	public String insertBoardComment(Board_commentVo bc) {
		boardService.insertComment(bc);
		
		return "redirect:/board/detailBoard?board_no="+bc.getBoard_no();
	}
	
//	댓글 삭제
	@RequestMapping("/board/deleteComment")
	public String deleteComment(Board_commentVo bc) {
		boardService.deleteComment(bc);
		
		return "redirect:/board/detailBoard?board_no="+bc.getBoard_no();
	}
}
