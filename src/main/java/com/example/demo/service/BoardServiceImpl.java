package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BoardDao;
import com.example.demo.vo.BoardVo;
import com.example.demo.vo.Board_commentVo;
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao BoardDao;
	
//	모든 게시물
	@Override
	public List<BoardVo> AllBoard() {
		// TODO Auto-generated method stub
		List<BoardVo> list = BoardDao.AllBoard();
		return list;
	}
	
//	게시물 등록후 등록한 게시물 상세페이지로 이동하기위한 쿼리
	@Override
	public int searchBoard_no() {
		// TODO Auto-generated method stub
		int re = -1;
		re = BoardDao.searchBoard_no();
		return re;
	}
	

//	게시물 등록
	@Override
	public int insertBoard(BoardVo b) {
		// TODO Auto-generated method stub
		int re = -1;
		re = BoardDao.insertBoard(b);
		return re;
	}

//	게시물 상세보기
	@Override
	public BoardVo detailBoard(BoardVo b) {
		// TODO Auto-generated method stub
		BoardVo detail = BoardDao.detailBoard(b);
		return detail;
	}

//	게시물 삭제
	@Override
	public int deleteBoard(BoardVo b) {
		// TODO Auto-generated method stub
		int re = -1;
		re = BoardDao.deleteBoard(b);
		return re;
	}

//	조회수
	@Override
	public int hit(BoardVo b) {
		// TODO Auto-generated method stub
		int re = -1;
		re = BoardDao.hit(b);
		return re;
	}

//	게시물 수정
	@Override
	public int updateBoard(BoardVo b) {
		// TODO Auto-generated method stub
		int re = -1;
		re = BoardDao.updateBoard(b);
		return re;
	}

//	댓글 목록
	@Override
	public List<Board_commentVo> AllBoardComment(BoardVo b) {
		// TODO Auto-generated method stub
		List<Board_commentVo> AllBoardComment = BoardDao.AllBoardComment(b);
		return AllBoardComment;
	}

//	댓글 등록
	@Override
	public int insertComment(Board_commentVo bc) {
		// TODO Auto-generated method stub
		int re = -1;
		re = BoardDao.insertComment(bc);
		return re;
	}
	
//	댓글 삭제
	@Override
	public int deleteComment(Board_commentVo bc) {
		// TODO Auto-generated method stub
		int re = -1;
		re = BoardDao.deleteComment(bc);
		return re;
	}
	
//	게시물 삭제시 그 게시물의 모든 댓글 삭제
	@Override
	public int deleteAllComment(Board_commentVo bc) {
		// TODO Auto-generated method stub
		int re = -1;
		re = BoardDao.deleteAllComment(bc);
		return re;
	}

	
}
