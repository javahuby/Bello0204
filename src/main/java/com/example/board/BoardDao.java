package com.example.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardDao {
	List<BoardVo> getBoardList(BoardVo vo);
	BoardVo boardEdit(BoardVo vo);
	
	void update(BoardVo vo);
	void delete(BoardVo vo);
	void insert(BoardVo vo);
	int totalCount(BoardVo vo);
}
