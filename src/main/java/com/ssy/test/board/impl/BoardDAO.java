package com.ssy.test.board.impl;

import java.util.List;

public interface BoardDAO {
	
	//글 목록
	public List<BoardDTO> getList() throws Exception;
	
	//글 상세보기
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;
	
	//글쓰기
	public int setAdd(BoardDTO boardDTO)throws Exception;
	
	//글 수정
	public int setUpDate(BoardDTO boardDTO) throws Exception;
	
	//글 삭제
	public int setDelete(BoardDTO boardDTO) throws Exception;
}