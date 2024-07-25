package com.example.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceimpl implements BoardService{
	
	@Autowired
	private BoardDao dao;
	
	BoardServiceimpl() {
		System.out.println("===>BoardServiceimpl 확인");
	}

	@Override
	public int insert(BoardVo vo) {
		dao.insert(vo);
		return dao.totalCount(vo);
	}

	@Override
	public List<BoardVo> getBoardList(BoardVo vo) {
		
		String ch2 ;
		
		ch2  = vo.getCh2();
		vo.setCh2("%" + ch2 +"%");
		
		System.out.println("getBoardList vo(2):" + vo);
		return dao.getBoardList(vo);
	}

	@Override
	public BoardVo boardEdit(BoardVo vo) {
		return dao.boardEdit(vo);
	}

	@Override
	public void update(BoardVo vo) {
		dao.update(vo);

	}

	@Override
	public void delete(BoardVo vo) {
		dao.delete(vo);
	}

}

