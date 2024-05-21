<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/WEB-INF/views/common.jsp"%>  

<!DOCTYPE html>
<html>

<head>
	<!-- 버튼만 오른쪽으로 보내기 CSS  -->
	<style>
        .button-right {
            float: right;
        }
     
    .hidden-row {
        display: none;
  		}
	</style>
    
    <script>
    
    function goGongMoDetailForm(comp_pk){
		// 		name='boardDetailForm' 을 간 form 태그 후손 중에
		// 		name='b_no' 가진 태그에 매개변수로 들어온 게시판의 고유번호를 삽입하기
		//		location.replace("/boardDetailForm.do?b_no="+b_no);		>> get 방식.
	 		$("[name='gongMoDetailForm']").find("[name='comp_pk']").val(comp_pk);
	 		//----------------------------------
	 		// name='boardDetailForm' 을 가진 
	 		// form 태그의 action 에 설정된 URL 주소로 WAS 접속해서 
	 		// 얻은 새 HTML 를 웹브라우저 열기.
	 		// 즉 화면 이동하기.
	 		//----------------------------------
	 		document.gongMoDetailForm.submit();
		}
    
    function goGongGoDetailForm(c_no){
		// 		name='boardDetailForm' 을 간 form 태그 후손 중에
		// 		name='b_no' 가진 태그에 매개변수로 들어온 게시판의 고유번호를 삽입하기
		//		location.replace("/boardDetailForm.do?b_no="+b_no);		>> get 방식.
	 		$("[name='gongGoDetailForm']").find("[name='c_no']").val(c_no);
	 		//----------------------------------
	 		// name='boardDetailForm' 을 가진 
	 		// form 태그의 action 에 설정된 URL 주소로 WAS 접속해서 
	 		// 얻은 새 HTML 를 웹브라우저 열기.
	 		// 즉 화면 이동하기.
	 		//----------------------------------
	 		document.gongGoDetailForm.submit();
		}
    
    </script>
  
</head>
<body>
    <div id="container">    
  <%@ include file="header.jsp" %>

<center>
 <div class="container">
 		<br>
        <h1 style="text-align: center; font-size:2em;">기업 마이페이지</h1>
        <table>
            <thead>
            <div class="right-align">
   </div>
   			<br>
                <tr>
                    <th colspan="2">기업 정보
                    <input type="button"  value=" 정보 수정 "  class="button-right" onClick="location.replace('/companySujungForm.do')">
                    </th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th style="width: 20%;">기업명</th>
                    <td>ABC 주식회사</td>
                </tr>
                <tr>
                    <th style="width: 20%;">업종</th>
                    <td>IT</td>
                </tr>
                <tr>
                    <th style="width: 20%;">주소</th>
                    <td>서울시 강남구</td>
                </tr>
            </tbody>
        </table>
</center>

<br>

<center>
        <table>
        	<div class="right-align">
		   </div>
            <thead>
                <tr>
                    <th colspan="2">이력서
                    <input type="button" value=" 이력서 보기 " class="button-right"  onClick="location.replace('/.do')">
                    </th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th style="width: 20%;">지원자명</th>
                    <td>홍길동</td>
                </tr>
                <tr>
                    <th style="width: 20%;">직무</th>
                    <td>개발자</td>
                </tr>
                <tr>
                    <th style="width: 20%;">이메일</th>
                    <td>example@example.com</td>
                </tr>
            </tbody>
        </table>
</center>

<br>

<center>
        <table>
        	<div class="right-align">
		   </div>
            <thead>
                <tr>
                    <th  colspan="4">등록한 공고
                    <input type="button" value=" 전체공고 "  class="button-right" onClick="location.replace('/gongGoList.do')">
                    </th>
                </tr>
            </thead>
            <tbody>
                <tr>
                	<th style="width: 5%;">번호</th>
                    <th style="width: 20%;">내용</th>
            		<th style="width: 10%;">작성일</th>
                    <th style="width: 15%;">공고 기간</th>
                </tr>
                <c:forEach var="gongGo" items="${requestScope.gongGoList}"  varStatus="status">
		              <tr style="cursor:pointer" onClick= "goGongGoDetailForm(${gongGo.g_no})"
		              class="<c:if test="${status.index >= 5}">hidden-row</c:if>">
		              	<td align="center"> ${status.index+1}</td>
		              	<td align="center"> ${gongGo.content}</td>
		              	<td align="center"> ${gongGo.gonggoreg_date}</td>
		              	<td align="center"> ${gongGo.opendate} ~ ${gongGo.closedate}</td>
		              </tr>
              </c:forEach>
               <tr id="showMoreBtn" <c:if test="${requestScope.gongMoList.size() <= 5}">style="display: none;"</c:if>>
			    	<td colspan="4" style="text-align: center;" onclick="showMoreComments()">
			        	더보기
			    	</td>
				</tr> 
            </tbody>
        </table>
</center>

<br>


<center>
        <table>
		     <div class="right-align">
		   </div>
            <thead>
                <tr>
				    <th colspan="4">
				        등록한 공모전
				        <input type="button" value=" 전체공모전 "  class="button-right"  onClick="location.replace('/gongMo.do')">
				    </th>
				</tr>
            </thead>
            <tbody>
            	<tr>
            		<th style="width: 5%;">번호</th>
            		<th style="width: 20%;">공모전 제목</th>
            		<th style="width: 10%;">작성일</th>
            		<th style="width: 15%;">공모전 기간</th>
            	</tr>
            	<c:forEach var="gongMo" items="${requestScope.gongMoList}"  varStatus="status">
		              <tr style="cursor:pointer" onClick= "goGongMoDetailForm(${gongMo.comp_pk})"
		              class="<c:if test="${status.index >= 5}">hidden-row</c:if>">
		              	<td align="center"> ${status.index+1}</td>
		              	<td align="center"> ${gongMo.subject}</td>
		              	<td align="center"> ${gongMo.reg_date}</td>
		              	<td align="center"> ${gongMo.start_time} ~ ${gongMo.end_time}</td>
		              </tr>
              </c:forEach>
              <tr id="showMoreBtn" <c:if test="${requestScope.gongMoList.size() <= 5}">style="display: none;"</c:if>>
			    	<td colspan="4" style="text-align: center;" onclick="showMoreComments()">
			        	더보기
			    	</td>
				</tr>
            </tbody>
        </table>
</center>

		
		
</form>        

		<form name="gongMoDetailForm" action="/gongMoDetailForm.do" method="post">
		<input type="hidden" name="comp_pk">
		<input type="hidden" name="g_no">
		</form>

<br>
    </div>
      
</body>
<%@ include file="footer.jsp" %> 
</html>
