package com.wa.erp;

import java.util.List;
import java.util.Map;

//BoardService 인터페이스 선언
public interface BoardService {

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
	
	//***************************************************************//	
		//(부업)
		BoardDTO getbuup(int b_no);

		//(프리랜서)
		BoardDTO gettimeShare(int b_no);
	//***************************************************************//	
	
	int getboardListCnt(BoardSearchDTO boardSearchDTO );

	int getboardListAllCnt(BoardSearchDTO boardSearchDTO);

	int getReviewListAllCnt();

	int getReviewListCnt(BoardReviewDTO boardReviewDTO);

	List<BoardReviewDTO> getreviewContent(BoardReviewDTO boardReviewDTO);

	BoardDTO getcompanyListDetail(int c_no);
	
		//프로젝트를 위한 선언
		List<BoardDTO> getPrjList(BoardSearchDTO boardSearchDTO);
		
		BoardDTO getPrj(int prj_no);
		
		BoardDTO getPrjForUpDel(int prj_no);
		
		int insertPrj(BoardDTO boardDTO);
		
		int updatePrj(BoardDTO boardDTO);

		int deldatePrj(BoardDTO boardDTO);

		int getPrjListAllCnt();

		int getPrjListCnt(BoardSearchDTO boardSearchDTO);

		
		
		// 공모전 관련
		List<BoardDTO> getGongMoList(BoardSearchDTO boardSearchDTO);
		
		BoardDTO getGongMo(int comp_no);

		BoardDTO gongMoForUpDel(int comp_pk);
		
		int insertGongMo(BoardDTO boardDTO);

		int updateGongMo(BoardDTO boardDTO);

		int deldateGongMo(BoardDTO boardDTO);

		int getGongMoListAllCnt();

		int getGongMoListCnt(BoardSearchDTO boardSearchDTO);
}
