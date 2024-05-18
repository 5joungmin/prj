<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/WEB-INF/views/common.jsp"%>  

<!DOCTYPE html>
<html>

<head>
<script>
function search(){
   var reviewUpFormObj = $("[name='reviewUpForm']");
   $.ajax(
         {
            //-------------------------------
            // WAS 로 접속할 주소 설정
            //-------------------------------
            url      : "/companyListDetail.do"
            //-------------------------------
            // WAS 로 접속하는 방법 설정. get 또는 post
            //-------------------------------
            ,type    : "post"
            //--------------------------------------
            // WAS 에 보낼 파명과 파값을 설정하기. "파명=파값&파명=파값~"
            //--------------------------------------
            ,data    : reviewUpFormObj.serialize()
            //----------------------------------------------------------
            // WAS 의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정.
            // 이때 익명함수의 매개변수로 WAS 의 응답물이 들어 온다.
            // "/boardList.do" 주소의 응답물은  boardList.jsp 페이지의
            // 실행결과인 HTML 문서 문자열이이다.
            //----------------------------------------------------------
            ,success : function(responseHtml){
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
               $(".reviewListDiv").html( 
                     obj.find(".reviewListDiv").html() 
               );
            

               /*$(".xxx").remove();
               $("body").prepend(
                  "<textarea class=xxx cols=100 rows=100>"
                  + obj.filter(".boardListDiv").html()
                  +"</textarea>"
               )*/
               
            }
            ,error   : function(){
               alert("정렬 실패! 관리자에게 문의 바람니다.");
            }
         }
      );

}
function searchWithSort(sort){
   $("[name='reviewUpForm']").find("[name='reviewSort']").val(sort);
   search();
}

</script>

<script>
function upReview(){
    var formObj = $("[name='reviewUpForm']");
    var starObj =  formObj.find(".rating");
    if( starObj == null ){ starObj = 0 };
    var contentObj = formObj.find(".content");

    if( 
          contentObj.val().trim().length==0 
          ||
          contentObj.val().trim().length>20 
    ){
       alert("내용은 임의 문자 1~20자 입력해야합니다.");
       return;
    }
    if( confirm("리뷰를 입력하시겠습니까?")==false ){ return; }
   $.ajax(
         { 
            //--------------------------------------
            // WAS 에 접속할 URL 주소 지정
            //--------------------------------------
            url    : "/reviewUpProc.do"
            //--------------------------------------
            // 파라미터값을 보내는 방법 지정
            //--------------------------------------
            ,type  : "post"
            //--------------------------------------
            // WAS 에 보낼 파명과 파값을 설정하기. "파명=파값&파명=파값~"
            //--------------------------------------
            ,data  : formObj.serialize( )
            //----------------------------------------------------------
            // WAS 의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정.
            // 이때 익명함수의 매개변수로 WAS 의 응답물이 들어 온다.
            //----------------------------------------------------------
            ,success : function(json){
               var result = json["result"];
               if(result==1){
                  alert("리뷰 입력 성공입니다.");
                  location.reload(); 
               }
               
               else{
                  alert("리뷰 입력 실패입니다. 관리자에게 문의 바람!");
               }
            }
            //----------------------------------------------------------
            // WAS 의 응답이 실패했을 실행할 익명함수 설정.
            //----------------------------------------------------------
            ,error : function(){
               alert("입력 실패! 관리자에게 문의 바람니다.");
            }
         }
      );
}

function rate(rating) {
    var stars = document.getElementsByClassName('star');
    var starInput = document.getElementsByName('star')[0]; // starInput 변수에 히든 필드를 가져오는 코드

    for (var i = 0; i < stars.length; i++) {
        if (i < rating) {
            stars[i].style.color = 'gold'; // 클릭된 별까지 채우기
        } else {
            stars[i].style.color = 'black'; // 나머지 별은 비우기
        }
    }
    // 별점 값을 "star" 히든 태그에 설정
    starInput.value = rating; // starInput의 value 속성에 별점 값을 설정
}
window.onload = function() {
    // 페이지 로드 시 별점을 1점으로 디폴트 설정
    rate(1);
};
</script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div id="container">    
  
   <%@ include file="header.jsp" %>


       <br>
       <center>
      <h1 style="text-align: center;">기업 정보 상세페이지</h1><br>
     
          
            <div class="table-container">
            <table  bordercolor="gray" border="1" cellpadding="7" style="margin-left:auto%; 
    margin-right:auto%;">
      
    
                
                
                
                <tr >
                    <td> 기업명 :</td>
                   <td>${boardDTO.name}</td> 
                       
                </tr>
                <tr>
                
                    <td> 홈페이지 :</td>
                    <td>${boardDTO.url}</td> 
                    
                    
                </tr>
                <tr>
                
                    <td> 기업 이메일 :</td>
                    <td>${boardDTO.email}</td> 
                </tr>
                <tr>
                
                    <td> 기업 형태 :</td>
                    <td>${boardDTO.volume}</td> 
                </tr>
                <tr>
                
                    <td> 매출 액 :</td>
                 <td>${boardDTO.sales} 만원</td> 
                    
                </tr>
                <tr>
                    <td> 사원 수 :</td>
                 <td>${boardDTO.emp_no} 명</td> 
                </tr>

                <tr>
                    <td> 설립일 :</td>
                 <td>${boardDTO.birth}</td> 
                </tr>
                <tr>
                    <td> 대표자명 :</td>
               <td>${boardDTO.ceo_name}</td> 
                    
                </tr>
                <tr>
                    <td> 회사 연락처 :</td>
                  <td>${boardDTO.call}</td> 
                    
                </tr>
                <tr>
                    <td> 평균 연봉 :</td>
                    <td>${boardDTO.sal_avg} 만원</td> 
                    
                </tr>
                
            </table>
        </div>
        
      
    
 
    
    
    
          <input type="button" value="뒤로가기"  onClick="location.replace('/companyList.do')">
   
      <br>
      <br>
           <center> [${boardDTO.name}]에 ${requestScope.reviewListCnt}개의 리뷰가 있습니다!</center>
      
        <div class="reviewListDiv">
       <table name="review" class="review" style="display: inline-block; vertical-align: top;" >
             
             <tr>
              <th   style="width: 60%; height: 40%;  text-align: center;" >리뷰</th>
             <c:if test="${param.reviewSort!='star asc' and param.reviewSort!='star desc'}">
              <th  style="width: 10%; text-align: center; cursor:pointer; "onClick="searchWithSort('star desc')">별점</th>
              </c:if>
             
             <c:if test="${param.reviewSort=='star desc'}">
              <th  style="width: 10%; text-align: center; cursor:pointer; "onClick="searchWithSort('star asc')">별점▼</th>
              </c:if>
             
             <c:if test="${param.reviewSort=='star asc'}">
              <th  style="width: 10%; text-align: center; cursor:pointer; "onClick="searchWithSort('')">별점▲</th>
              </c:if>
             
              
               <th  style="width: 10%; text-align: center;">좋아요</th>
          </tr>
          
       <c:forEach var="review" items="${requestScope.reviewContent}">
    <tr>
       <td>${review.content}</td>        
       <td>${review.star}</td> 
        <td>
             <span class="likeButton" onclick="toggleLike(this)"><i class="far fa-heart"></i></span>
<%--           <span class="likeCount" name="rec_count">${reviewList.rec_count}</span> --%>
        </td>
   </tr>
         </c:forEach>
      </table>      
      
</div>
      <br>
 <form class="reviewUpForm" name="reviewUpForm" style="display: inline-block; vertical-align: top;">
       <br>
       <br>
       <br>
       <br>
 
 <div>
      리뷰를 작성해 주세요
    <div class="rating" name="rating" value="0">
    <span class="star" onclick="rate(1)" data-value="1">&#9733;</span>
    <span class="star" onclick="rate(2)" data-value="2">&#9733;</span>
    <span class="star" onclick="rate(3)" data-value="3">&#9733;</span>
    <span class="star" onclick="rate(4)" data-value="4">&#9733;</span>
    <span class="star" onclick="rate(5)" data-value="5">&#9733;</span>
</div>
    <textarea id="content" placeholder="20자 이내로 입력해주세요" name="content" class="content"></textarea>
    <input type="button" onclick="upReview()" value="리뷰 제출" >
</div>
                  <!-- 클릭한 행의 게시판 고유번호가 저장될 히든태그 선언 -->
                  <input type="hidden" name="c_no" value="${boardDTO.c_no}" >
                  <input type="hidden" name="star" >
                  <input type="hidden" name="reviewSort" class="reviewSort" value="">
                  
      </form>  
 
  
</body>
<%@ include file="footer.jsp" %>
</html>