package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.BoardVo;
import com.example.demo.vo.Board_commentVo;

public interface BoardService {
//	모든 게시물
	List<BoardVo> AllBoard();
	
//	게시물 등록후 등록한 게시물 상세페이지로 이동하기위한 쿼리
	int searchBoard_no();	
	
//	게시물 등록
	int insertBoard(BoardVo b);
	
//	게시물 상세보기
	BoardVo detailBoard(BoardVo b);
	
//	게시물 삭제
	int deleteBoard(BoardVo b);
	
//	조회수
	int hit(BoardVo b);
	
//	게시물 수정
	int updateBoard(BoardVo b);
	
//	댓글 목록
	List<Board_commentVo> AllBoardComment(BoardVo b);
	
//	댓글 등록
	int insertComment(Board_commentVo bc);
	
//	댓글 삭제
	int deleteComment(Board_commentVo bc);

//	게시물 삭제시 그 게시물의 모든 댓글 삭제
	int deleteAllComment(Board_commentVo bc);
}
