<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>12Wa~</title>
<style>
        .button-right {
            float: right;
        }
     
    .hidden-row {
        display: none;
  		}
	</style>
<script>
				
				//복리후생 체크박스를 받아온 리스트를 , 단위로 나누고 리스트에 담고 뺴오기
				function checkWelfareCodes() {
				    // 서버에서 가져온 데이터를 JavaScript 변수에 할당
				    var welfareCodes = "${boardDTO.welfare_code2}"; // 예를 들어, "1, 3, 5"와 같은 형식으로 데이터가 있을 것으로 가정
				    var welfareCodeArray = welfareCodes.split(",").map(function(code) {
				        return code.trim(); // 쉼표 뒤의 공백 제거
				    });
				
				    // 각 체크박스에 대해 반복하면서 선택합니다.
				    welfareCodeArray.forEach(function(code) {
				        var checkbox = document.getElementById("welfare_code" + code);
				        if (checkbox) {
				            checkbox.checked = true; // 해당 ID를 가진 체크박스를 체크합니다.
				        }
				    });
				}
				
				// 페이지 로드 시 실행되는 함수
				window.onload = function() {
				    checkWelfareCodes();
				};
					
			
				
			function showSelect(){
				 $(".hidden-row").css("display", "table-row");
				 $("#showMoreBtn").hide();
				 $("#addr1").removeAttr("name");
				 $("#addr2").removeAttr("name");
				 $("#addr3").removeAttr("name");
				 $("#addr1").val("");
				 $("#addr2").val("");
				 $("#addr3").val("");
			}	
			
		function checkComInfoUpForm(){
			
			if($("#addr1").val()!=""){				
		    	$("select#sido1").removeAttr("name"); 	
		    	$("select#gugun1").removeAttr("name"); 	
		    	$("#addr").removeAttr("name"); 	
				
			}
			
		  var formObj = $("[name='companyInfoUpForm']");
		  	if(confirm("정말 수정 하시겠습니까?")==false) {return;}
			//-----------------------------------------------------
			// JQuery 객체의 [ajax 메소드]를 호출하여
			// 페이지 이동없이(=현 화면 고정) 
			// WAS 와 비동기 방식으로 통신하고 얻은 데이터를 현재 화면에 반영한다.
			//-----------------------------------------------------
			//-----------------------------------------------------
			// JQuery 객체의 [ajax 메소드]를 호출하여
			// WAS 에 "/boardUpProc.do" 주소로 접속하고 
			// 게시판 수정 결과를 받아서
			// 성공했으면 경고하고 게시판 목록화면으로 이동하고
			// 실패했으면 경고하기
			//-----------------------------------------------------
			$.ajax(
				{ 
					//--------------------------------------
					// WAS 에 접속할 URL 주소 지정
					//--------------------------------------
					url	: "/comInfoUpProc.do"
					//--------------------------------------
					// 파라미터값을 보내는 방법 지정
					//--------------------------------------
					,type : "post"
					//--------------------------------------
					// WAS 에 보낼 파명과 파값을 설정하기. "파명=파값&파명=파값~"
					//--------------------------------------
					,data : formObj.serialize()
					//----------------------------------------------------------
					// WAS 의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정.
					// 이때 익명함수의 매개변수로 WAS 의 응답물이 들어 온다.
					//----------------------------------------------------------
					,success : function(json){
						var result = json["result"];
						if(result==-1){
							alert("암호가 틀립니다.")
							pwdObj.val("")
						}
						else if(result==0){
							alert("수정에 실패했습니다.")
						}
						else{
<<<<<<< HEAD
							alert("수정 성공입니다.")
						    document.forms['MyCompanyForm'].submit();
=======
							alert("수정 성공입니다.");
							document.forms['MyCompanyForm'].submit();
>>>>>>> refs/heads/develop
						}
					}
					//----------------------------------------------------------
					// WAS 의 응답이 실패했을 실행할 익명함수 설정.
					//----------------------------------------------------------
					,error : function(){
							alert("수정 실패! 관리자에게 문의 바랍니다.");
					}
				}
			);
		}
		</script>

</head>

<body>

	<div id="container">
		<%@ include file="header.jsp"%>



		<div class="container">
			<br>
			<h1 style="text-align: center;">기업 정보 수정</h1><br>
			<form name="companyInfoUpForm" action="submit.php" method="POST" >
				<table
					style="border: 1px solid black; margin-left: auto; margin-right: auto;">
					<tr>
						<th>항목</th>
						<th>등록 사항</th>
					</tr>
					<tr>
						<th>기업명</th>
						<td><input type="text" id="name" name="name" class="name" 
									value="${requestScope.boardDTO.name}" required></td>
					</tr>
					<tr>
						<th>기업 로고 등록</th>
						<td></td>
					</tr>
					<tr>
						<th>홈페이지</th>
						<td><input type="text" id="url" class="url" name="url"
						 			value="${requestScope.boardDTO.url}"  ></td>
					</tr>
					<tr>
						<th>기업 이메일</th>
						<td><input type="text" id="email" name="email" class="email" 
									 value="${fn:substringBefore(requestScope.boardDTO.email, '@')}" required> @ 
							<select name="email2">
		                    <option value="@naver.com" > naver.com </option>
		                    <option value="@daum.net" > daum.net </option>
		                    <option value=""> 직접입력 </option>
		                </td>
					</tr>
					<tr>
						<th>복리후생</th>
						<td>
						    <input type="checkbox" id="welfare_code1" name="welfare_code" value="1">
						    <label for="welfare_code1">4대보험가입</label>
						    <input type="checkbox" id="welfare_code2" name="welfare_code" value="2">
						    <label for="welfare_code2">연금가입</label> 
						    <input type="checkbox" id="welfare_code3" name="welfare_code" value="3">
						    <label for="welfare_code3">보너스 및 인센티브</label>
						    <input type="checkbox" id="welfare_code4" name="welfare_code" value="4">
						    <label for="welfare_code4">수당제도</label><br>
						    <input type="checkbox" id="welfare_code5" name="welfare_code" value="5">
						    <label for="welfare_code5">사내동호회 운영</label> 
						    <input type="checkbox" id="welfare_code6" name="welfare_code" value="6">
						    <label for="welfare_code6">경조사 지원</label>
						    <input type="checkbox" id="welfare_code7" name="welfare_code" value="7">
						    <label for="welfare_code7">사무용품 지원</label>
						    <input type="checkbox" id="welfare_code8" name="welfare_code" value="8">
						    <label for="welfare_code8">출산/육아 지원제도</label><br>
						    <input type="checkbox" id="welfare_code9" name="welfare_code" value="9">
						    <label for="welfare_code9">자유복장</label>
						    <input type="checkbox" id="welfare_code10" name="welfare_code" value="10">
						    <label for="welfare_code10">식대제공</label> 
						    <input type="checkbox" id="welfare_code11" name="welfare_code" value="11">
						    <label for="welfare_code11">기숙사 및 사택 제공</label>
						    <input type="checkbox" id="welfare_code12" name="welfare_code" value="12">
						    <label for="welfare_code12">차량유류비 지급</label><br>
						    <input type="checkbox" id="welfare_code13" name="welfare_code" value="13">
						    <label for="welfare_code13">통근버스 운행</label> 
						    <input type="checkbox" id="welfare_code14" name="welfare_code" value="14">
						    <label for="welfare_code14">교통비 지급</label>
						    <input type="checkbox" id="welfare_code15" name="welfare_code" value="15">
						    <label for="welfare_code15">유연근무제</label>
						    <input type="checkbox" id="welfare_code16" name="welfare_code" value="16">
						    <label for="welfare_code16">각종 행사</label><br>
						    <input type="checkbox" id="welfare_code17" name="welfare_code" value="">
						    <label for="welfare_code17">사항 없음</label>
						</td>

					</tr>
					<tr>
						    <th>기업 형태</th>
						    <td>
						        <select id="volume" name="volume" required>
						            <option value=""></option>
						            <option value="대기업">대기업</option>
						            <option value="중견기업">중견기업</option>
						            <option value="중소기업">중소기업</option>
						        </select>
						    </td>
						</tr>
						<script>
						    document.getElementById("volume").value = "${boardDTO.volume}";
						</script>
					<tr>
						<th>대표 업종</th>
						<td><select id="business_industry" name="business_industry"
							required>
								<option value="화장품 및 뷰티 제품 제조업">화장품 및 뷰티 제품 제조업
								<option value="식품 및 음료 소매업">식품 및 음료 소매업
								<option value="건설/건축 서비스">건설/건축 서비스
								<option value="의료/보건 서비스">의료/보건 서비스
								<option value="여행/관광 업종">여행/관광 업종
								<option value="환경 보호/재활용 산업">환경 보호/재활용 산업
								<option value="생활용품/가전제품 도매업">생활용품/가전제품 도매업
								<option value="금융 및 보험 서비스">금융 및 보험 서비스
								<option value="자동차 부품 제조업">자동차 부품 제조업
								<option value="출판/인쇄 업종">출판/인쇄 업종
								<option value="교육 기술 서비스">교육 기술 서비스
								<option value="농업 및 농산물 가공 산업">농업 및 농산물 가공 산업
								<option value="전자상거래/온라인 판매">전자상거래/온라인 판매
								<option value="음악/예술 엔터테인먼트 산업">음악/예술 엔터테인먼트 산업
								<option value="생명 공학/의료 기기 산업">생명 공학/의료 기기 산업
								<option value="통신/네트워크 서비스">통신/네트워크 서비스
								<option value="스포츠/운동 기술 산업">스포츠/운동 기술 산업
								<option value="에너지/청정 기술 산업">에너지/청정 기술 산업
								<option value="인테리어 디자인/가구 제조업">인테리어 디자인/가구 제조업
								<option value="컴퓨터/소프트웨어 서비스">컴퓨터/소프트웨어 서비스
								<option value="식물/원예 관련 서비스">식물/원예 관련 서비스
								<option value="코스메틱/미용 서비스">코스메틱/미용 서비스
								<option value="공예품/수공예품 제조업">공예품/수공예품 제조업
								<option value="동물 의료 서비스">동물 의료 서비스
								<option value="부동산 개발/투자">부동산 개발/투자
								<option value="국제 무역/물류 서비스">국제 무역/물류 서비스
								<option value="자원 관리/환경 컨설팅">자원 관리/환경 컨설팅
								<option value="자료/정보 서비스">자료/정보 서비스
								<option value="패션/의류 디자인 업종">패션/의류 디자인 업종
						</select></td>
					</tr>
					<script>
						    document.getElementById("business_industry").value = "${boardDTO.business_industry}";
					</script>
					<tr>
						<th>설립일</th>
						<td><input type="date" id="birth" name="birth" 
										value="${requestScope.boardDTO.birth}" required></td>
					</tr>
					<tr>

						<th>대표자명</th>
						<td><input type="text" id="ceo_name" name="ceo_name" class="ceo_name"
										value="${requestScope.boardDTO.ceo_name}"  required></td>
					</tr>
					<tr>
						<th>회사 번호</th>
						<td><input type="text" id="call" name="call" class="call"
										value="${requestScope.boardDTO.call}"  required></td>
					</tr>
					<tr>
						<th>사업자번호</th>
						<td><input type="text" id="business_no" name="business_no" class="business_no"
										value="${requestScope.boardDTO.business_no}"  required></td>
					</tr>

					<tr>
						<th>매출 액</th>
						<td><input type="text" id="sales" name="sales" 
										value="${requestScope.boardDTO.sales}"  required></td>
					</tr>
					<tr>
						<th>회사 주소</th>
						
						<td id="showMoreBtn">${requestScope.boardDTO.addr } &nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="수정" onClick="showSelect()"></td>
						<td class="hidden-row">
							<select name="addr1" id="sido1"></select> <select
							name="addr2" id="gugun1"></select>&nbsp; <input type="text"
							name="addr3" id="addr" 
							onfocus="if(this.value=='나머지 상세주소') this.value='';">
							</td>
					</tr>


					<tr>
						<th>사원수</th>
						<td><input type="text" id="emp_no" name="emp_no" 
										value="${requestScope.boardDTO.emp_no}"  required></td>
					</tr>
					<tr>
						<th>평균연봉</th>
						<td><input type="text" id="sal_avg" name="sal_avg"
										value="${requestScope.boardDTO.sal_avg}"  required></td>
					</tr>
					
					<tr>
		                <th>패스워드</th>
		               <td><input type="password" id="pwd" name="pwd" class="pwd" required></td>
		            </tr>


				</table>
				<br>
						<input type="hidden" id="addr1" name="addr1" value="${addr1}">
						<input type="hidden" id="addr2" name="addr2" value="${addr2}">
						<input type="hidden" id="addr3" name="addr3" value="${addr3}"> 
						<input type="hidden" name="c_no"  value='${sessionScope.c_no}'>
						
				<center>
					 <input type="button" value=" 수정 " onClick="checkComInfoUpForm()">
				</center>
			</form>
				
			<br>
		</div>
		
		<form name="MyCompanyForm"  action="/myCompany.do"  method="post">
				<input type="hidden" name="c_no"  value='${sessionScope.c_no}'>
		</form>
</body>
<%@include file="/WEB-INF/views/common.jsp" %>
<%@ include file="footer.jsp"%>
</html>