
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
    <title>Title</title>
</head>
<style>
    .pagination {
        display: flex;
    }
    .pagination .page-item {
        margin: 0.3em;
        list-style: none;
    }
</style>
<body>
<h1>${listDTO}</h1>
<hr/>
<h3>${listDTO.link}</h3>
<div class="searchDiv">
    <select class="type">
        <option value="">---</option>
        <option value="t" ${listDTO.type =="t" ? "selected" : ""}>제목</option>
        <option value="tc" ${listDTO.type == "tc" ? "selected" : ""}>제목 내용</option>
        <option value="tcw" ${listDTO.type == "tcw" ? selected : ""}>제목 내용 작성자</option>
    </select>
    <input type="text" name="keyword" value="${listDTO.keyword}">
    <button class="searchBtn">search</button>
</div>
<ul class="dtoList">
    <c:forEach items="${dtoList}" var="board">
        <li>
            <span> ${board.bno} </span>
            <span><a href='/board/read/${board.bno}' class="pageLink"> ${board.title}</a>
                [ ${board.replyCount} ]
            </span>
        </li>
    </c:forEach>
</ul>

<ul class="pagination">
    <c:if test="${pageMaker.prev}">
    <li class="page-item">
        <a class="page-link" href="${pageMaker.start - 1}" aria-label="Previous">
            <<
        </a>
    </li>
    </c:if>
    <c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="num">
        <li class="page-item"><a class="page-link" href="${num}">${num}</a></li>
    </c:forEach>

    <c:if test="${pageMaker.next}">
    <li class="page-item">
        <a class="page-link" href="${pageMaker.end + 1}" aria-label="Next">
           >>
        </a>
    </li>
    </c:if>
</ul>

<form class="actionForm" action="/board/list">
    <input type="text" hidden name="page" value="${listDTO.page}">
    <input type="text" hidden name="type" value="${listDTO.type}">
    <input type="text" hidden name="keyword" value="${listDTO.keyword}">
</form>

<script>

    const pageLinks = document.querySelectorAll(".page-link");
    const actionForm = document.querySelector(".actionForm");
    const serachBtn = document.querySelector(".searchBtn");
    const pageInput = actionForm.querySelector("input[name='page']")
    const searchDiv = document.querySelector(".searchDiv");
    const paginationDiv = document.querySelector(".pagination");
    const dtoListUL = document.querySelector(".dtoList");

    serachBtn.addEventListener("click",(e)=> {

        const type = searchDiv.querySelector(".type").value;
        const keyword = searchDiv.querySelector("input[name='keyword']").value;

        pageInput.value = 1;
        actionForm.querySelector("input[name='type']").value = type;
        actionForm.querySelector("input[name='keyword']").value = keyword;
        actionForm.submit();
    },false)

    paginationDiv.addEventListener("click",(e)=>{
        e.preventDefault();
        e.stopPropagation();

        if(e.target.getAttribute("class") != "page-link")
                return;

        const num = e.target.getAttribute("href");
        pageInput.value = num;
        actionForm.setAttribute("action","/board/list");
        actionForm.submit();


    },false)

    dtoListUL.addEventListener("click",(e) =>{
        e.preventDefault();
        e.stopPropagation();

        if(e.target.getAttribute("class").indexOf("pageLink") < 0 )
            return;

        const url =  e.target.getAttribute("href");
        console.log(url);
        actionForm.setAttribute("action",url);
        actionForm.submit();

        // console.log("안녕하세요");

    },false)

    const result = '${result}';

    if(result !== '')
        alert("처리 되었습니다.");

</script>
</body>
</html>
