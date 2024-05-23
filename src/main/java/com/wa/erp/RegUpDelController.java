package com.wa.erp;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegUpDelController {
	
	@Autowired
	private RegUpDelService regUpDelService;
	
	@RequestMapping( value ="/gongGoRegForm.do")
	public ModelAndView gongGoRegForm(
			BoardSearchDTO boardSearchDTO
			) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("gongGoRegForm.jsp");
		return mav;
	}

	
	/*mmmmmmmmmmmmmm 자유게시판 등록 mmmmmmmmmmmmmmm*/
	
	@RequestMapping(value="/freedomeRegForm.do")
	public ModelAndView freedomeRegForm(   ){
		
		ModelAndView mav = new ModelAndView( );
		
		mav.setViewName( "freedomeRegForm.jsp");

		return mav;
	}
	

	/*mmmmmmmmmmmmmm 신입게시판 등록 mmmmmmmmmmmmmmm*/
	
	@RequestMapping(value="/newComerRegForm.do")
	public ModelAndView newComerRegForm(   ){
		
		ModelAndView mav = new ModelAndView( );
		
		mav.setViewName( "newComerRegForm.jsp");
		
		return mav;
	}

	
	
	/*mmmmmmmmmmmmmm QnA게시판 등록 mmmmmmmmmmmmmmm*/
	
	@RequestMapping(value="/qnaRegForm.do")
	public ModelAndView qnaRegForm(   ){
		
		ModelAndView mav = new ModelAndView( );
		
		mav.setViewName( "qnaRegForm.jsp");
		
		return mav;
	}

	
	
	/*mmmmmmmmmmmmmm 취업게시판 등록 mmmmmmmmmmmmmmm*/
	
	@RequestMapping(value="/jobReadyRegForm.do")
	public ModelAndView jobReadyRegForm(   ){
		
		ModelAndView mav = new ModelAndView( );
		
		mav.setViewName( "jobReadyRegForm.jsp");
		
		return mav;
	}

	
	
	
	/*mmmmmmmmmmmmmm 면접게시판 등록 mmmmmmmmmmmmmmm*/
	
	@RequestMapping(value="/interviewRegForm.do")
	public ModelAndView interviewRegForm(   ){
		
		ModelAndView mav = new ModelAndView( );
		
		mav.setViewName( "interviewRegForm.jsp");
		
		return mav;
	}

	
	
	
	/*mmmmmmmmmmmmmm 중고게시판 등록 mmmmmmmmmmmmmmm*/
	
	@RequestMapping(value="/joongGoRegForm.do")
	public ModelAndView joongGoRegForm(   ){
		
		ModelAndView mav = new ModelAndView( );
		
		mav.setViewName( "joongGoRegForm.jsp");
		
		return mav;
	}

	//===========================================================
	// 각 페이지에서 수정삭제 페이지 들어가기
	//===========================================================
	@RequestMapping(value="/jobReadyUpDelForm.do")
	public ModelAndView jobReadyUpDelForm( 
					@RequestParam(value="UpDel_board") String table,
					@RequestParam(value="UpDel_b_no") int b_no,
					BoardSearchDTO boardSearchDTO
			){
		
		boardSearchDTO.setB_no(b_no);
		boardSearchDTO.setTable(table);
		
		BoardDTO boardDTO = this.regUpDelService.getBoard(boardSearchDTO);
		
		ModelAndView mav = new ModelAndView( );
		
		mav.addObject("boardDTO", boardDTO);
		
		mav.setViewName( "jobReadyUpDelForm.jsp");
		
		return mav;
	}

	
	@RequestMapping(value="/freedomeUpDelForm.do")
	public ModelAndView freedomeUpDelForm( 
			@RequestParam(value="UpDel_board") String table,
			@RequestParam(value="UpDel_b_no") int b_no,
			BoardSearchDTO boardSearchDTO
			){
		System.out.println("b_no:"+b_no);
		
		boardSearchDTO.setB_no(b_no);
		boardSearchDTO.setTable(table);
		
		
		System.out.println(boardSearchDTO.getTable());
		BoardDTO boardDTO = this.regUpDelService.getBoard(boardSearchDTO);
		
		ModelAndView mav = new ModelAndView( );
		
		mav.addObject("boardDTO", boardDTO);
		
		mav.setViewName( "freedomeUpDelForm.jsp");
		
		return mav;
	}

	
	@RequestMapping(value="/newComerUpDelForm.do")
	public ModelAndView newComerUpDelForm( 
			@RequestParam(value="UpDel_board") String table,
			@RequestParam(value="UpDel_b_no") int b_no,
			BoardSearchDTO boardSearchDTO
			){
		
		boardSearchDTO.setB_no(b_no);
		boardSearchDTO.setTable(table);
		
		BoardDTO boardDTO = this.regUpDelService.getBoard(boardSearchDTO);
		
		ModelAndView mav = new ModelAndView( );
		
		mav.addObject("boardDTO", boardDTO);
		
		mav.setViewName( "newComerUpDelForm.jsp");
		
		return mav;
	}

	
	@RequestMapping(value="/qnaUpDelForm.do")
	public ModelAndView qnaUpDelForm( 
			@RequestParam(value="UpDel_board") String table,
			@RequestParam(value="UpDel_b_no") int b_no,
			BoardSearchDTO boardSearchDTO
			){
		
		boardSearchDTO.setB_no(b_no);
		boardSearchDTO.setTable(table);
		
		BoardDTO boardDTO = this.regUpDelService.getBoard(boardSearchDTO);
		
		ModelAndView mav = new ModelAndView( );
		
		mav.addObject("boardDTO", boardDTO);
		
		mav.setViewName( "qnaUpDelForm.jsp");
		
		return mav;
	}

	
	@RequestMapping(value="/interviewUpDelForm.do")
	public ModelAndView interviewUpDelForm( 
			@RequestParam(value="UpDel_board") String table,
			@RequestParam(value="UpDel_b_no") int b_no,
			BoardSearchDTO boardSearchDTO
			){
		
		boardSearchDTO.setB_no(b_no);
		boardSearchDTO.setTable(table);
		
		BoardDTO boardDTO = this.regUpDelService.getBoard(boardSearchDTO);
		
		ModelAndView mav = new ModelAndView( );
		
		mav.addObject("boardDTO", boardDTO);
		
		mav.setViewName( "interviewUpDelForm.jsp");
		
		return mav;
	}

	
	@RequestMapping(value="/joongGoUpDelForm.do")
	public ModelAndView joongGoUpDelForm( 
			@RequestParam(value="UpDel_board") String table,
			@RequestParam(value="UpDel_b_no") int b_no,
			BoardSearchDTO boardSearchDTO
			){
		
		boardSearchDTO.setB_no(b_no);
		boardSearchDTO.setTable(table);
		
		BoardDTO boardDTO = this.regUpDelService.getBoard(boardSearchDTO);
		
		ModelAndView mav = new ModelAndView( );
		
		mav.addObject("boardDTO", boardDTO);
		
		mav.setViewName( "joongGoUpDelForm.jsp");
		
		return mav;
	}
	//==================수정,삭제===================================
	
	
	
	//===========================================================
	//											수정 비동기
	//===========================================================
	@RequestMapping( 
			value="/boardUpProc.do" 
			,method=RequestMethod.POST
			,produces="application/json;charset=UTF-8"
	)
	@ResponseBody
	public Map<String,String> boardUpProc( 

			BoardDTO boardDTO	
	) {
		//------------------------------------------------
		// 게시판 수정 결과물을 저장할 HashMap 객체 생성하기.
		//------------------------------------------------
		Map<String,String> resultMap = new HashMap<String,String>();
		//-------------------------------------------
		// [BoardServiceImpl 객체]의 updatetimeShare 메소드 호출로 
		// 부업 글 수정하고 [수정 적용행의 개수] 얻기
		//-------------------------------------------
		int boardUpCnt = this.regUpDelService.updateBoard(boardDTO);
			
		//-------------------------------------------
		// HashMap 객체에 게시판 수정 행의 개수 저장하기
		//-------------------------------------------
		resultMap.put( "result", boardUpCnt+"" );

		//-------------------------------------------
		// HashMap 객체의 메위주 리턴하기
		//-------------------------------------------
		return resultMap;
	}
	//===========================================================
	//											수정 비동기
	//===========================================================
	
	
	
	
	//===========================================================
	//											삭제 비동기
	//===========================================================
	@RequestMapping( 
			value="/boardDelProc.do" 
			,method=RequestMethod.POST
			,produces="application/json;charset=UTF-8"
	)
	@ResponseBody
	public Map<String,String> boardDelProc( 
			BoardDTO boardDTO	
	) {
		Map<String,String> resultMap = new HashMap<String,String>();
		
		int boardDelCnt = this.regUpDelService.deleteBoard(boardDTO);

		resultMap.put( "result", boardDelCnt+"" );
		
		return resultMap;
	}
	//===========================================================
	//											삭제 비동기
	//===========================================================
	
	
	//===========================================================
	//											등록 비동기
	//===========================================================
	
	  @RequestMapping(
	   		value="/boardRegProc.do"
		   ,method=RequestMethod.POST
		   ,produces="application/json;chaeset=UTF-8"
	   )
	   
	  @ResponseBody
	  public Map<String, String> boardRegProc(
			  
			   BoardDTO boardDTO
			   
		){
		  
	   Map<String, String> resultMap = new HashMap<String, String>();
	   
	   int boardRegCnt = this.regUpDelService.insertBoard(boardDTO);
	   
	   
	   resultMap.put("result", boardRegCnt+"");
	   
	   return resultMap;
	   
	  }
	  	//===========================================================
		//											등록 비동기
		//===========================================================
	  
	  	//===========================================================
		//											게시판 댓글쓰기
		//===========================================================
	  @RequestMapping(
		   		value="/commentRegProc.do"
			   ,method=RequestMethod.POST
			   ,produces="application/json;chaeset=UTF-8"
		   )
		   
		  @ResponseBody
		  public Map<String, String> CommentRegProc(
				  
				   BoardDTO boardDTO
				   
			){
		  
		   Map<String, String> resultMap = new HashMap<String, String>();
		   
		   int commnetRegCnt = this.regUpDelService.insertComment(boardDTO);
		   
		   
		   resultMap.put("result", commnetRegCnt+"");
		   
		   return resultMap;
		   
		  }
	  	//===========================================================
		//											게시판 댓글쓰기
		//===========================================================
	  /*mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm*/
	
	  
	  	//공고등록 페이지
	  	@RequestMapping( 
				value="/gongGoReg.do" 
				,method=RequestMethod.POST
				,produces="application/json;charset=UTF-8"
		)
		@ResponseBody
		public Map<String,String> gongGoRegProc (  
				BoardDTO  boardDTO
		){
			
			Map<String,String> resultMap = new HashMap<String,String>();
			
			int gongGoRegCnt = this.regUpDelService.insertGongo(boardDTO);
			
			resultMap.put( "result", gongGoRegCnt+"" );
			
			return resultMap;
		}
	  	
	  //********************************************************************//
		//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
		//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
		// URL 주소 /timeShareRegForm.do 로 접근하면 호출되는 메소드 선언
		//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
		@RequestMapping( value="/timeShareRegForm.do")
		public ModelAndView timeShareRegForm(
				
		){
	    ModelAndView mav = new ModelAndView(); 
		mav.setViewName("timeShareRegForm.jsp");			
		return mav;		
		}

		//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
		//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
		// /timeShareRegForm.do 로 접근하면 호출되는 메소드 선언하기
		//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
		@RequestMapping( 
				value="/timeShareRegProc.do" 
				,method=RequestMethod.POST
				,produces="application/json;charset=UTF-8"
		)
		
		@ResponseBody
		public Map<String,String> timeShareRegProc(  		
				TimeShareDTO timeShareDTO
		){
			
			Map<String,String> resultMap = new HashMap<String,String>();	
			int timeShareRegCnt = this.regUpDelService.inserttimeShare(timeShareDTO);
			resultMap.put( "result", timeShareRegCnt+"" );
			return resultMap;
		}
		
		//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
		// URL 주소 /timeShareUpDelForm.do 로 접근하면 호출되는 메소드 선언
		//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
			@RequestMapping( value="/timeShareUpDelForm.do")
			public ModelAndView timeShareUpDelForm( 
				//--------------------------------------
				// "b_no" 라는 파라미터명에 해당하는 파라미터값을 꺼내서 
				// 매개변수 b_no 에 저장하고 들어온다.
				// 즉 게시판 고유 번호가 매개변수 b_no 로 들어온다.
				//--------------------------------------
				@RequestParam(value="b_no") int b_no
			
			   ){	
				//--------------------------------
				// BoardServiceImpl 객체의 gettimeShareForUpDel 메소드를 호출하여
				// 수정/삭제 화면에서 필요한 [1개의 게시판 글]을 가져오기
				//--------------------------------
				TimeShareDTO timeShareDTO = this.regUpDelService.gettimeShareForUpDel(b_no);
				//--------------------------------
				// [ModelAndView 객체] 생성하기
				//--------------------------------
				ModelAndView mav = new ModelAndView( );
				//--------------------------------
				// [ModelAndView 객체]에
				// 키값  "boardDTO" 에
				// 1행m열의 검색 데이터가 저장된 BoardDTO 객체 붙여 저장하기
				// ModelAndView 객체에 저장된 객체는
				// HttpServletRequest 객체에도 저장된다.
				//--------------------------------
				mav.addObject("timeShareDTO", timeShareDTO);
				//--------------------------------
				// [ModelAndView 객체]의 setViewName 메소드 호출하여  
				// [호출할 JSP 페이지명]을 문자로 저장하기
				//--------------------------------
				mav.setViewName("timeShareUpDelForm.jsp");
				//--------------------------------
				// [ModelAndView 객체] 리턴하기
				// [ModelAndView 객체]를 리턴한 후에 스프링프레임워크가 JSP 페이지를 호출한다
				//--------------------------------
				return mav;
		}


		//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
		//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
		// /timeShareUpProc.do 접속 시 호출되는 메소드 선언
		// <참고> boardUpDelForm.jsp 에서 수정 버튼 클릭했을 때 접속할 때 호출되는 메소드
		//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
			@RequestMapping( 
					value="/timeShareUpProc.do" 
					,method=RequestMethod.POST
					,produces="application/json;charset=UTF-8"
			)
			@ResponseBody
			public Map<String,String> timeShareUpProc( 
					//*******************************************
					// 파라미터값이 저장된 [BoardDTO 객체]가 들어올 매개변수 선언
					//*******************************************
					// [파라미터명]과 [BoardDTO 객체]의 [멤버변수명]이 같으면
					// setter 메소드가 작동되어 [파라미터값]이 [멤버변수]에 저장된다
					TimeShareDTO timeShareDTO
			    ){
				//------------------------------------------------
				// 게시판 수정 결과물을 저장할 HashMap 객체 생성하기.
				//------------------------------------------------
				Map<String,String> resultMap = new HashMap<String,String>();

				//-------------------------------------------
				// [BoardServiceImpl 객체]의 updatetimeShare 메소드 호출로 
				// 부업 글 수정하고 [수정 적용행의 개수] 얻기
				//-------------------------------------------
				int timeShareUpCnt = this.regUpDelService.updatetimeShare(timeShareDTO);

				//-------------------------------------------
				// HashMap 객체에 게시판 수정 행의 개수 저장하기
				//-------------------------------------------
				resultMap.put( "result", timeShareUpCnt+"" );

				//-------------------------------------------
				// HashMap 객체의 메위주 리턴하기
				//-------------------------------------------
				return resultMap;
			    }
			
			
			//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
			//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
			// /timeShareDelProc.do 접속 시 호출되는 메소드 선언
			//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
			@RequestMapping( 
					value="/timeShareDelProc.do" 
					,method=RequestMethod.POST
					,produces="application/json;charset=UTF-8"
			)
			@ResponseBody
			public Map<String,String> timeShareDelProc( 
					TimeShareDTO timeShareDTO	
			){
				Map<String,String> resultMap = new HashMap<String,String>();
				
				int timeShareDelCnt = this.regUpDelService.deletetimeShare(timeShareDTO);

				resultMap.put( "result", timeShareDelCnt+"" );
				
				return resultMap;
			}
	  
				
				//------------------------------------------------------------------- //


				//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
				// URL 주소 /buupListRegForm.do 로 접근하면 호출되는 메소드 선언
				//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
				@RequestMapping( value="/buupListRegForm.do")
				public ModelAndView buupListRegForm( 
					){
					//----------------------------------------------------
					// [ModelAndView 객체] 생성하기
					// [ModelAndView 객체]에 [호출 JSP 페이지명]을 저장하기
					//-------------------------------------------
					
					ModelAndView mav = new ModelAndView( );
					mav.setViewName( "buupListRegForm.jsp");
					//----------------------------------------------------
					// [ModelAndView 객체] 리턴하기
					//----------------------------------------------------
					return mav;
				}

				//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
				//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
				// /buupListRegProc.do 로 접근하면 호출되는 메소드 선언하기
				//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
				@RequestMapping( 
						value="/buupListRegProc.do" 
						,method=RequestMethod.POST
						,produces="application/json;charset=UTF-8"
				)
				
				@ResponseBody
				public Map<String,String> buupListRegProc(  		
						BuupDTO buupDTO
				){
					System.out.println("제목"+buupDTO.getSubject());
					System.out.println("희망업무"+buupDTO.getHope_work());
					System.out.println("시간"+buupDTO.getStart_time());
					System.out.println("시간"+buupDTO.getEnd_time());
					System.out.println("날짜"+buupDTO.getStart_date());
					System.out.println("날짜"+buupDTO.getEnd_date());
					System.out.println("내용"+buupDTO.getContent());
					System.out.println("암호"+buupDTO.getPwd());
					Map<String,String> resultMap = new HashMap<String,String>();	
					int buupRegCnt = this.regUpDelService.insertbuup(buupDTO);
					resultMap.put( "result", buupRegCnt+"" );
					return resultMap;
				}
				
				



				//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
				//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
				// /buupUpProc.do 접속 시 호출되는 메소드 선언
				// <참고> boardUpDelForm.jsp 에서 수정 버튼 클릭했을 때 접속할 때 호출되는 메소드
				//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
				@RequestMapping( 
						value="/buupUpProc.do" 
						,method=RequestMethod.POST
						,produces="application/json;charset=UTF-8"
				)
				@ResponseBody
				public Map<String,String> buupUpProc( 
						//*******************************************
						// 파라미터값이 저장된 [BoardDTO 객체]가 들어올 매개변수 선언
						//*******************************************
							// [파라미터명]과 [BoardDTO 객체]의 [멤버변수명]이 같으면
							// setter 메소드가 작동되어 [파라미터값]이 [멤버변수]에 저장된다
						BuupDTO buupDTO
				    ){
					//------------------------------------------------
					// 게시판 수정 결과물을 저장할 HashMap 객체 생성하기.
					//------------------------------------------------
					Map<String,String> resultMap = new HashMap<String,String>();

					//-------------------------------------------
					// [BoardServiceImpl 객체]의 updatebuup 메소드 호출로 
					// 부업 글 수정하고 [수정 적용행의 개수] 얻기
					//-------------------------------------------
					int buupUpCnt = this.regUpDelService.updatebuup(buupDTO);

					//-------------------------------------------
					// HashMap 객체에 게시판 수정 행의 개수 저장하기
					//-------------------------------------------
					resultMap.put( "result", buupUpCnt+"" );

					//-------------------------------------------
					// HashMap 객체의 메위주 리턴하기
					//-------------------------------------------
					return resultMap;
				}
				
				
				//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
				//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
				// /buupDelProc.do 접속 시 호출되는 메소드 선언
				//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
				@RequestMapping( 
						value="/buupDelProc.do" 
						,method=RequestMethod.POST
						,produces="application/json;charset=UTF-8"
				)
				@ResponseBody
				public Map<String,String> buupDelProc( 
						BuupDTO buupDTO
				) {
					Map<String,String> resultMap = new HashMap<String,String>();
					
					int buupDelCnt = this.regUpDelService.deletebuup(buupDTO);

					resultMap.put( "result", buupDelCnt+"" );
					
					return resultMap;
				}
				
				//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
				// URL 주소 /buupListUpDelForm.do 로 접근하면 호출되는 메소드 선언
				//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
				@RequestMapping( value="/buupListUpDelForm.do")
				public ModelAndView buupListUpDelForm( 
					//--------------------------------------
					// "b_no" 라는 파라미터명에 해당하는 파라미터값을 꺼내서 
					// 매개변수 b_no 에 저장하고 들어온다.
					// 즉 게시판 고유 번호가 매개변수 b_no 로 들어온다.
					//--------------------------------------
					@RequestParam(value="b_no") int b_no
				    ){	
					//--------------------------------
					// BoardServiceImpl 객체의 getbuupForUpDel 메소드를 호출하여
					// 수정/삭제 화면에서 필요한 [1개의 부업 글]을 가져오기
					//--------------------------------

					BuupDTO buupDTO = this.regUpDelService.getbuupForUpDel(b_no);
					//--------------------------------
					// [ModelAndView 객체] 생성하기
					//--------------------------------
					ModelAndView mav = new ModelAndView( );
					//--------------------------------
					// [ModelAndView 객체]에
					// 키값  "boardDTO" 에
					// 1행m열의 검색 데이터가 저장된 BoardDTO 객체 붙여 저장하기
					// ModelAndView 객체에 저장된 객체는
					// HttpServletRequest 객체에도 저장된다.
					//--------------------------------
					mav.addObject("buupDTO", buupDTO);
					//--------------------------------
					// [ModelAndView 객체]의 setViewName 메소드 호출하여  
					// [호출할 JSP 페이지명]을 문자로 저장하기
					//--------------------------------
					mav.setViewName("buupListUpDelForm.jsp");
					//--------------------------------
					// [ModelAndView 객체] 리턴하기
					// [ModelAndView 객체]를 리턴한 후에 스프링프레임워크가 JSP 페이지를 호출한다
					//--------------------------------
					return mav;
				    }
				
				//============================================================
				// 기업 리뷰 작성
	 			//============================================================
				@RequestMapping(
						value="/reviewUpProc.do"
						,method=RequestMethod.POST
						,produces="application/json;charset=UTF-8"
						)
					@ResponseBody
					public Map<String,String> reviewUpProc(
					BoardDTO boardDTO
						) {
					Map<String,String> resultMap = new HashMap<String,String>();

					int reviewUpList = this.regUpDelService.upReview(boardDTO);

					resultMap.put("result", reviewUpList+"");

					return resultMap;
					 }
				
				//============================================================
				// 이력서 등록
	 			//============================================================
				@RequestMapping(
						value="/resumeRegProc.do"
						,method=RequestMethod.POST
						,produces="application/json;charset=UTF-8"
						)
					@ResponseBody
					public Map<String,String> resumeRegProc(
					BoardDTO boardDTO
						) {
					
					Map<String,String> resultMap = new HashMap<String,String>();

					int resumeRegCnt = this.regUpDelService.insertResume(boardDTO);

					resultMap.put("result", resumeRegCnt+"");

					return resultMap;
					 }
				
				//============================================================
				// 추천수 업!
	 			//============================================================
				@RequestMapping(
						value="/recUpProc.do"
						,method=RequestMethod.POST
						,produces="application/json;charset=UTF-8"
						)
					@ResponseBody
					public Map<String,String> recUpProc(
					BoardDTO boardDTO
						) {
					
					Map<String,String> resultMap = new HashMap<String,String>();

					int updateRecCnt = this.regUpDelService.updateRec(boardDTO);

					resultMap.put("result", updateRecCnt+"");

					return resultMap;
					 }

				
				//============================================================
				// 추천수 다운!
				//============================================================
				@RequestMapping(
						value="/recDownProc.do"
						,method=RequestMethod.POST
						,produces="application/json;charset=UTF-8"
						)
				@ResponseBody
				public Map<String,String> recDownProc(
						BoardDTO boardDTO
						) {
					
					Map<String,String> resultMap = new HashMap<String,String>();
					
					int downdateRecCnt = this.regUpDelService.downdateRec(boardDTO);
					
					resultMap.put("result", downdateRecCnt+"");
					
					return resultMap;
				}
				
				
				
				
				
				
				//============================================================
				// 개인회원 정보수정, 삭제
				//============================================================
				@RequestMapping( value="/personalUpDelForm.do")
				public ModelAndView personalUpDelForm( 

					@RequestParam(value="p_no") int p_no
				    ){	
					MypageDTO mypageDTO = this.regUpDelService.getPrivacyForUpDel(p_no);
					
					ModelAndView mav = new ModelAndView( );
				    
					mav.addObject("mypageDTO", mypageDTO);
			
					mav.setViewName("personalUpDelForm.jsp");
				
					return mav;
				    }
				
				
				
				//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
				//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
				// /timeShareUpProc.do 접속 시 호출되는 메소드 선언
				// <참고> boardUpDelForm.jsp 에서 수정 버튼 클릭했을 때 접속할 때 호출되는 메소드
				//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
					@RequestMapping( 
							value="/PrivacyUpProc.do" 
							,method=RequestMethod.POST
							,produces="application/json;charset=UTF-8"
					)
					@ResponseBody
					public Map<String,String> PrivacyUpProc( 
						
							MypageDTO mypageDTO
					    ){
						//------------------------------------------------
						// 게시판 수정 결과물을 저장할 HashMap 객체 생성하기.
						//------------------------------------------------
						Map<String,String> resultMap = new HashMap<String,String>();

						//-------------------------------------------
						// [BoardServiceImpl 객체]의 updatetimeShare 메소드 호출로 
						// 부업 글 수정하고 [수정 적용행의 개수] 얻기
						//-------------------------------------------
						int PrivacyUpCnt = this.regUpDelService.updatePrivacy(mypageDTO);

						//-------------------------------------------
						// HashMap 객체에 게시판 수정 행의 개수 저장하기
						//-------------------------------------------
						resultMap.put( "result", PrivacyUpCnt+"" );

						//-------------------------------------------
						// HashMap 객체의 메위주 리턴하기
						//-------------------------------------------
						return resultMap;
					    }
					
					
					//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
					//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
					// /timeShareDelProc.do 접속 시 호출되는 메소드 선언
					//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
					@RequestMapping( 
							value="/PrivacyDelProc.do" 
							,method=RequestMethod.POST
							,produces="application/json;charset=UTF-8"
					)
					@ResponseBody
					public Map<String,String> PrivacyDelProc( 
							MypageDTO mypageDTO
					){
					Map<String,String> resultMap = new HashMap<String,String>();
					
					int PrivacyDelCnt = this.regUpDelService.deletePrivacy(mypageDTO);

					resultMap.put( "result", PrivacyDelCnt+"" );
					
					return resultMap;
					}
				
				
				

		
}
	





