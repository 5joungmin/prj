package com.wa.erp;

import java.util.List;
import java.util.Map;

public interface RegUpDelService {
	/*게시판 등록,수정,삭제을 위한 선언*/
	int insertBoard(BoardDTO boardDTO);
	int updateBoard(BoardDTO boardDTO);
	int deleteBoard(BoardDTO boardDTO);
	
	/*게시판 댓글 등록*/
	int insertComment(BoardDTO boardDTO);
	//게시판 댓글 좋아요 +
	int updateRec(BoardDTO boardDTO);
	//게시판 댓글 싫어요 +
	int downdateRec(BoardDTO boardDTO);
	/*mmmmmmmmmmmmmmmmmm*/
	BoardDTO getBoard(BoardSearchDTO boardSearchDTO);
	
	//공고//
	public int insertGongo(BoardDTO boardDTO);
	//////////////////////////////////////
	
	//(프리랜서)
		int inserttimeShare(BoardDTO boardDTO);	
		int updatetimeShare(BoardDTO boardDTO);
		int deletetimeShare(BoardDTO boardDTO);
		
		BoardDTO gettimeShareForUpDel(int b_no);
		
		//(부업)
		int insertbuup(BoardDTO boardDTO);
		int updatebuup(BoardDTO boardDTO);
		int deletebuup(BoardDTO boardDTO);
		
		BoardDTO getbuupForUpDel(int b_no);
		
		//리뷰 등록
		int upReview(BoardDTO boardDTO);
		//리뷰 삭제
		int deleteReview(BoardDTO boardDTO);
		
		//이력서 등록
		int insertResume(BoardDTO boardDTO);
		//관심기업 등록
		int insertLikeCompany(BoardDTO boardDTO);
		//관심 기업 해제
		int deleteLikeCompany(BoardDTO boardDTO);
		//댓글 수정
		int updateComment(BoardDTO boardDTO);
		//댓글 삭제
		int deleteComment(BoardDTO boardDTO);
		
		int updateReview(BoardDTO boardDTO);
		

	}
