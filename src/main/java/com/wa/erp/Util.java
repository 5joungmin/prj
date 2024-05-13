package com.wa.erp;

import java.util.HashMap;
import java.util.Map;

public class Util {

//	static은 객체 생성없이 호출이 가능하다.
	
//	검색 화면에서 필요한 [페이징 처리 관련 데이터를] HashMap 객체에 저장해 리턴하는 메소드
	public static Map<String, Integer> getPagingMap(
			int selectPageNo	//선택한 페이지 번호
			,int rowCntPerPage	//페이지 당 보여줄 검색 행의 개수
			,int totCnt			//검색결과 개수
			){
		
//		페이징 처리 관련 데이터 를 저장할 HashMap 객체 생성하기
		Map<String, Integer> map = new HashMap<String,Integer>();
		try {
			//-----------------------------------------------------
			//한 화면에 보여질 페이지 번호의 개수 저장하기
			//만약에 매개변수로 들어오는 한 화면에 보여줄 행의 개수가 0이하면 10로 보정하기.
			//만약에 배개변수로 들어오는 선택한 페이지번호가 0 이하면 페이지번호가 0이하면 1로 보정하기
			//-----------------------------------------------------
			int pageNoCntPerPage = 10;
			if( rowCntPerPage<=0 )     { rowCntPerPage = 10; }
			if( selectPageNo<=0 )      { selectPageNo = 1; }
			//-----------------------------------------------------
			//만약에 매개변수로 들어오는 검색행의 개수가 0개면 
			//즉 페이징 처리할 데이터가 없으면 HashMap객체에 페이징 처리 관련 데이터를 주로 0으로 세팅하기
			//-----------------------------------------------------
			if( totCnt==0 ) {
				//-----------
				map.put("selectPageNo", selectPageNo);			//선택한 페이지 번호
				map.put("rowCntPerPage", rowCntPerPage);		//한 화면에 보여주는 행의 개수
				map.put("totCnt", totCnt);						//검색한 결과의 총 개수
				map.put("pageNoCntPerPage", pageNoCntPerPage);	//한 화면에 보여지는 페이지번호의 개수 저장하기.
				//-----------
				map.put("last_pageNo", 0);						//마지막 페이지 번호
				//-----------
				map.put("begin_rowNo", 0);						// 오라클에서 검색할 시작행 번호 저장하기
				map.put("end_rowNo", 0);						// 오라클에서 검색할 끝 행 번호 저장하기
				//-----------
				map.put("begin_serialNo_asc", 0);					//화면에서 시작하는 정순 일련번호 저장하기
				map.put("begin_serialNo_desc", 0 );					//화면에서 시작하는 역순 일련번호 저장하기
				//-----------
				map.put("begin_pageNo", 0);
				map.put("end_pageNo", 0);
				//-----------
				return map;
			}
			//-----------------------------------------------------
			//마지막 페이지 번호 구하기, 선택한 페이지번호 보정하기.
			//-----------------------------------------------------
			int last_pageNo = totCnt/rowCntPerPage;
					// 아래 처럼도 가능
					// int last_pageNo = totCnt/rowCntPerPage + (totCnt%rowCntPerPage==0?0:1);
					// int last_pageNo = (int)(Math.ceil(totCnt*1.0/rowCntPerPage));
				if( totCnt%rowCntPerPage>0 ) { last_pageNo++; }
				if( last_pageNo<selectPageNo ) { selectPageNo = last_pageNo; }
			//-----------------------------------------------------
			// DB에서 사용할 마지막 행번호 구하기
			// DB에서 사용할 시작 행번호 구하기
			//-----------------------------------------------------
			int end_rowNo = selectPageNo * rowCntPerPage;
			int begin_rowNo = end_rowNo-rowCntPerPage+1;
				if( end_rowNo>totCnt ) { end_rowNo = totCnt; }
			//-----------------------------------------------------
			//화면에서 보여줄 시작 페이지 번호 구하기
			//화면에서 보여줄 마지막 페이지 번호 구하기
			//-----------------------------------------------------
			int begin_pageNo = (int)Math.floor(  (selectPageNo-1)/pageNoCntPerPage  )*pageNoCntPerPage + 1;
			int end_pageNo = begin_pageNo + pageNoCntPerPage - 1;
				if( end_pageNo>last_pageNo ) {
					end_pageNo = last_pageNo;
				}
			//-----------------------------------------------------
			// HashMap 객체에 구한 [페이징 처리 관련 데이터]를 최종 저장하기.
			//-----------------------------------------------------
			map.put("selectPageNo", selectPageNo);						//선택한 페이지 번호
			map.put("rowCntPerPage", rowCntPerPage);					//한 화면에 보여주는 행의 개수
			map.put("totCnt", totCnt);									//검색한 결과의 총 개수
			map.put("pageNoCntPerPage", pageNoCntPerPage);				//한 화면에 보여지는 페이지번호의 개수 저장하기.
			//--------------
			map.put("last_pageNo", last_pageNo);						//마지막 페이지 번호
			//--------------
			map.put("begin_rowNo", begin_rowNo);   						// 오라클에서 검색할 시작행 번호 저장하기
			map.put("end_rowNo" , end_rowNo);       					// 오라클에서 검색할 끝 행 번호 저장하기
			//-----------
			map.put("begin_serialNo_asc", begin_rowNo);					//화면에서 시작하는 정순 일련번호 저장하기
			map.put("begin_serialNo_desc", totCnt - begin_rowNo + 1 );	//화면에서 보여지는 마지막 페이지 번호 저장하기
			//-----------
			map.put("begin_pageNo", begin_pageNo);						//화면에서 필요한 시작 페이징 번호
			map.put("end_pageNo", end_pageNo);							//화면에서 필요한 마지막 페이징 번호
			//-----------------------------------------------------
			//HashMap객체 리턴하기.
			return map;
		}
		//----------------------------
		// try 영역에서 예외가 발생하면 새로운 비어있는 HashMap 객체 리턴하기
		//----------------------------
		catch(Exception ex) {
			return new HashMap<String,Integer>();
		}
		
	}
	
	
	
	
}
