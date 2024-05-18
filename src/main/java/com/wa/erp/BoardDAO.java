package com.wa.erp;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardDAO {
	// mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
	// n행m열의 게시판 검색을 위한 getBoardList 메소드 선언하기
	// mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
	List<BoardDTO> getboardList(BoardSearchDTO boardSearchDTO);

	List<BoardDTO> getcompanyList(BoardSearchDTO boardSearchDTO);
	
	BoardDTO getcompanyDetail(int c_no);
	
	List<BoardDTO> getReview(int c_no);
	
	List<BoardReviewDTO> getreviewContent(int c_no);

	List<BoardDTO> getgongGoList();

	List<BoardDTO> gettimeShareList();

	List<BoardDTO> getbuupList();

	List<BoardDTO> getprjList();

	List<BoardDTO> getgongMoList();
	
	BoardDTO getBoard(Map<String,Object> paramMap);

	List<BoardDTO> getComment(Map<String,Object> paramMap);
	
	int updateReadCount(Map<String,Object> paramMap);

	// (부업)
	BoardDTO getbuup(int b_no);
	
	// (프리랜서)	
	BoardDTO gettimeShare(int b_no);
	
	
//	게시판 검색 개수 구하는 getBoardListCnt 메소드 선언하기
	int getboardListCnt(BoardSearchDTO boardSearchDTO);

	//게시판 총 개수 구하기
	int getboardListAllCnt(BoardSearchDTO boardSearchDTO);
	
	int getReviewListAllCnt();

	int getReviewListCnt(BoardReviewDTO boardReviewDTO);

	List<BoardReviewDTO> getreviewContent(BoardReviewDTO boardReviewDTO);

	BoardDTO getcompanyListDetail(int c_no);
	
		//프로젝트 게시판 관련
		List<BoardDTO> getPrjList(BoardSearchDTO boardSearchDTO);
		
		int getPrjListCnt(BoardSearchDTO boardSearchDTO);
		
		int getPrjListAllCnt();
		
		BoardDTO getPrj(int prj_no);
		
		int prjUpdateReadcount(int prj_no);
		
		int getPrjPwdCnt( BoardDTO boardDTO );
		
		int updatePrj( BoardDTO boardDTO );

		int deldatePrj(BoardDTO boardDTO);
		
		int getPrjCnt(int prj_no);
		
		int insertPrj(BoardDTO boardDTO);
			

		//공모전 관련
		int insertGongMo(BoardDTO boardDTO);

		BoardDTO getGongMo(int comp_pk);

		int updateGongMo(BoardDTO boardDTO);

		int getGongMoPwdCnt(BoardDTO boardDTO);

		int deldateGongMo(BoardDTO boardDTO);

		int gongMoUpdateReadcount(int comp_pk);

		List<BoardDTO> getGongMoList(BoardSearchDTO boardSearchDTO);

		int getGongMoListAllCnt();

		int getGongMoListCnt(BoardSearchDTO boardSearchDTO);
	
}
