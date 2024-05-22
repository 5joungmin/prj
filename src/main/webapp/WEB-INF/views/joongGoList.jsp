<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/views/common.jsp"%>  
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>12Wa~</title>

<script>
  function pageNoClick( clickPageNo ){

		$("[name='boardSearchForm']").find(".selectPageNo").val(clickPageNo);
		
		search("joongGo");
		
	}
// function tradeTypeSearch( tradetype ){
// 	var boardSearchFormObj = $("[name='boardSearchForm']");
// 	var tradetypeObj = $("[name='boardSearchForm']").find(".tradetype").val(tradetype);
	
	$.ajax(
			{
				//-------------------------------
				// WAS 로 접속할 주소 설정
				//-------------------------------
				url      : "/joongGo.do"
				//-------------------------------
				// WAS 로 접속하는 방법 설정. get 또는 post
				//-------------------------------
				,type    : "post"
				//--------------------------------------
				// WAS 에 보낼 파명과 파값을 설정하기. "파명=파값&파명=파값~"
				//--------------------------------------
				,data    : boardSearchFormObj.serialize( )
				//----------------------------------------------------------
				// WAS 의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정.
				// 이때 익명함수의 매개변수로 WAS 의 응답물이 들어 온다.
				// "/boardList.do" 주소의 응답물은  boardList.jsp 페이지의
				// 실행결과인 HTML 문서 문자열이이다.
				//----------------------------------------------------------
				,success : function(responseHtml){
					alert(1);
					//-----------------------------------
					// 매개변수로 들어오는 HTML 문자열을 관리하는 
					// JQuery 객체 생성하여 변수 obj 에 저장하기
					//-----------------------------------
					var obj = $(responseHtml);
					
					//-----------------------------------
					// 매개변수로 받은 HTML 문자열 중에 
					// <div class='boardListDiv'> 태그 안의 html 문자열을
					// 현 화면의 <div class='boardListDiv'> 태그 안에  덮어쓰기
					//-----------------------------------boardListDiv pagingNos
	            $(".boardListDiv").html(obj.filter(".boardListDiv").html());
	            $(".pagingNos").html(obj.filter(".pagingNos").html());
	         

				

					
					
//	 				$("body").append(
//	 					"<textarea class=xxx cols=100 rows=100>"
//	 					+ obj.filter(".pagingNos").html()
//	 					+"</textarea>"
//	 				)
					
				}
				,error   : function(){
					alert("검색 실패! 관리자에게 문의 바람니다.");
				}
			}
		);
}
  
</script>

</head>
  
<body>

 <div id="container">    
<%@ include file="header.jsp" %>

<%@ include file="boardSideCategori.jsp" %>



    <div id="wrap" class="container"  >
      <h1 style="text-align: center;">중고 게시판</h1>   
      
     <form name="boardSearchForm">
        <div style="text-align: center; margin-bottom: 20px;">
            <input type="text"   name="keyword" class="keyword">
            <input type="button" value="검색"   class="searchBtn" onclick="search('joongGo')"></input>
            <input type="hidden" name="SelectPageNo" class="SelectPageNo" value="1">
			<input type="hidden" name="rowCntPerPage" class="rowCntPerPage">
			<input type="hidden" name="boardname" class="boardname" value="tradeboard">
			<input type="radio" value="" name="tradetype" onclick="search('joongGo')">전체
       		<input type="radio" value="buy" name="tradetype"   onclick="search('joongGo')">구매 
    		<input type="radio" value="sell" name="tradetype"  onclick="search('joongGo')">판매	
        </div>
     </form>
      
      
      <form action="submit.php" method="POST">
			<div class="joongGoListDiv">
				<table
					style="border: 1px solid black; margin-left: auto; margin-right: auto;">

					<tr>
						<th>번호</th>
						<th>거래종류</th>
						<th>닉네임</th>
						<th>제목</th>
						<th>가격</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>

					<c:forEach var="board" items="${requestScope.joongGoList }"
						varStatus="status">
						
							<tr style="cursor: pointer"
								onCLick="goBoardDetailForm(${board.b_no},'joongGo', 'tradeboard', 'trade','');">
								<td align="center"> ${requestScope.boardMap.begin_serialNo_desc - status.index}</td>
								<td align="center">
										<c:choose>
										    <c:when test="${board.trade_type == 'buy'}">
										        구매
										    </c:when>
										    <c:otherwise>
										        판매
										    </c:otherwise>
										</c:choose>
									</td>
								<td align="center">${board.nickname }</td>
								<td align="center">${board.subject }</td>
								<td align="center">${board.price}원</td>
								<td align="center">${board.reg_date }</td>
								<td align="center">${board.read_count }</td>
							</tr>

					</c:forEach>
				</table>
			</div>
              
            <center>
					<span class="pagingNos"> 
				<c:if test="${ empty requestScope.joongGoList}">
              <center>
              	조회할 데이터가 없습니다.
              </center>
              </c:if>
					<span style="cursor: pointer"
						onClick="pageNoClick(1)">[처음]</span> <span style="cursor: pointer"
						onClick="pageNoClick(${requestScope.boardMap.selectPageNo}-1)">[이전]</span>&nbsp;&nbsp;


						<c:forEach var="pageNo"
							begin="${requestScope.boardMap.begin_pageNo}"
							end="${requestScope.boardMap.end_pageNo}">

							<c:if test="${requestScope.boardMap.selectPageNo==pageNo}">
				${pageNo}
			</c:if>

							<c:if test="${requestScope.boardMap.selectPageNo!=pageNo}">
								<span style="cursor: pointer" onClick="pageNoClick(${pageNo})">[${pageNo}]</span>
							</c:if>
						</c:forEach>&nbsp;&nbsp; <span style="cursor: pointer"
						onClick="pageNoClick(${requestScope.boardMap.selectPageNo}+1)">[다음]</span>
						<span style="cursor: pointer"
						onClick="pageNoClick(${requestScope.boardMap.last_pageNo})">[마지막]</span>
						&nbsp;&nbsp;&nbsp;

						[${requestScope.joongGoListCnt}/${requestScope.joongGoListAllCnt}]개

						&nbsp;&nbsp;
					</span> <select name="rowCntPerPage" class="rowCntPerPage"
						onChange="search('joongGo')">
						<option value="10">10
							<option value="15">15
						
						<option value="20">20
					
					</select>행보기 &nbsp;&nbsp;&nbsp;
				</center>

          
           <center>
     	       <input type="button" value="등록" style="font-size: 20px; margin-top: 10px;" 
     	           onClick="location.replace('/joongGoRegForm.do')">
           </center>  
      </form>
  </div>
               <form name="trade_type" action="joongGoList.do"
						method="post">
						<!-- 클릭한 행의 게시판 고유번호가 저장될 히든태그 선언 -->
						<input type="hidden" name="tradetype" value="">
						
					</form>
</body>
<%@ include file="footer.jsp" %>
</html>
