<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/WEB-INF/views/common.jsp"%>  

<!DOCTYPE html>
<html>

<head>
<script>
	//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
	// 등록 버튼을 클릭하면 호출되는 함수
	//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
		function checktimeShareReg() {

		var formObj    = $("[name='timeShareRegForm']");
		
		var subjectObj     = $("[name='subject']").val();
		var pwdObj         = $("[name='pwd']").val();
		var contentObj     = $("[name='content']").val();
		var PreferredObj    = $("[name='Preferred_work']").val();
		var startTimeObj   = $("[name='start_time']").val();
		var endTimeObj     = $("[name='end_time']").val();
		var startDateObj   = $("[name='start_date']").val();
		var endDateObj     = $("[name='end_date']").val();

		//----------------------------------------------
		// 제목의 문자 패턴 검사하기
		//----------------------------------------------
		if (!/^.{2,30}$/.test(subjectObj)) {
			alert("제목은 임의 문자 2~30자 입력해야 합니다.");
			$("[name='subject']").val("").focus();
			return;
		}

		
		//----------------------------------------------
		// 선호 업무 문자 패턴 검사하기
		//----------------------------------------------
		if (PreferredObj.trim().length < 10) {
			alert("선호 업무는 최소 10자 이상 입력해야 합니다.");
			return;
		}

		//----------------------------------------------
		// 희망 근무 시간 선택 여부 검사하기
		//----------------------------------------------
		if (!startTimeObj || !endTimeObj) {
			alert("희망 근무 시간을 선택해 주세요.");
			return;
		}

		//----------------------------------------------
		// 지원 기간 선택 여부 검사하기
		//----------------------------------------------
		if (!startDateObj || !endDateObj) {
			alert("지원 기간을 선택해 주세요.");
			return;
		}
		//----------------------------------------------
		// 내용 문자 패턴 검사하기
		//----------------------------------------------
		if (contentObj.trim().length == 0 || contentObj.trim().length > 500) {
			alert("내용은 임의 문자 1~500자 입력해야 합니다.");
			return;
		}
		
		//----------------------------------------------
		// 암호 패턴 검사하기
		//----------------------------------------------
		if (!/^\d{4}$/.test(pwdObj.trim())) {
			alert("암호는 공백 없이 4자리 숫자여야 합니다.");
			$("[name='pwd']").val("").focus();
			return;
		}
		
		if( confirm("정말 등록하시겠습니까?")==false ){ return; }
	
		$.ajax(
			{ 
			
				url    : "/timeShareRegProc.do"
				,type  : "post"				
				,data  : formObj.serialize( )
					
				,success : function(json){
					var result = json["result"];
					if(result==1){
						alert("프리랜서 등록 성공입니다.");
						
						location.replace('/timeShare.do');
					}
					else{
						alert("프리랜서 등록 실패입니다. 관리자에게 문의 바람!");
					}
				}
				
				,error : function(){
					alert("입력 실패! 관리자에게 문의 바람니다.");
				}
			}
		);
	}	
</script>
  
</head>
<body>
    <div id="container">    
  <%@ include file="header.jsp" %>


    <center>
   <table align="center"border="1"cellpadding="7"style="border-collapse:collapse"><table align="center"border="1"cellpadding="7"style="border-collapse:collapse">
        <h1 style="text-align: center;">프리랜서 등록</h1> 
         <form name= "timeShareRegForm">
         
      <tr>
          <td>제목</td>
        <td>
            <input type="text" id="subject" name="subject" placeholder="제목을 입력해주세요">
        </td>
     </tr>
     

    <tr>
        <td>선호업무</td>
        <td><textarea id="Preferred_work" name="Preferred_work" style="width:300px;height:100px;"></textarea></td>		    
    </tr>
        
       <tr> 
	        <td>희망근무시간</td>   
	         <td>        
                <select name="start_time" class="start_time">
				    <% for (int i = 1; i <= 24; i++) { %>
				        <option value="<%= i %>"><%= String.format("%02d", i) %></option>
				    <% } %>
			      
				</select>
				시~
				<select name="end_time" class="end_time">
				     <% for (int i = 1; i <= 24; i++) { %>
				        <option value="<%= i %>"><%= String.format("%02d", i) %></option>
				    <% } %>
				</select>
				시
                </td>
             </tr> 
               
        <tr>
            <td>지원 기간</td>
           <td><label for="start_date">시작일:</label> 
       <input type="date" id="start_date" name="start_date" value="${requestScope.timeShareDTO.start_date}" min="2024-01-01" max="2030-12-31" />
           ~
           <label for="end_date">마감일:</label> 
       <input type="date" id="end_date" name="end_date" value="${requestScope.timeShareDTO.end_date}"  min="2024-01-01" max="2030-12-31" />
            </td>
       </tr>

     <tr>
        <td>내용</td>
        <td>
           <textarea name="content" textarea style="width:100%; height:100%;" rows="4" placeholder="최대 500자까지 입력가능합니다."></textarea>
        </td>
     <tr>  
    
     <tr>
        <td>암호</td>
        <td>
            <input type="password" id="pwd" name="pwd" maxlength="4" placeholder="최대 4자리">
        </td>
     </tr>
     
         <input type="hidden" name="p_no" value="${sessionScope.p_no}">   
</table>

		     <span onClick="location.replace('/timeShare.do')">[목록으로]</span>
	         <input type="button" onClick="checktimeShareReg()" value="등록">
	         
        </center>
   </form>       
</body>
<%@ include file="footer.jsp" %>
</html>
