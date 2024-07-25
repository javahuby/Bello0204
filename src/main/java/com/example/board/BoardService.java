package com.example.board;

import java.util.List;

public interface BoardService {
	List<BoardVo> getBoardList(BoardVo vo);
	BoardVo boardEdit(BoardVo vo);
	
	void delete(BoardVo vo);
	void update(BoardVo vo);
	int insert(BoardVo vo);

}
