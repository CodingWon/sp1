<%--
  Created by IntelliJ IDEA.
  User: JIwon
  Date: 2022-04-30
  Time: 오후 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Modify page</h1>
    ${listDTO}
    ${boardDTO}

    <form class="modifyForm" action="/board/modify/${boardDTO.bno}" method="post">
            <input type="hidden" name="page" value="${listDTO.page}">
            <input type="hidden" name="size" value="${listDTO.size}">
            <input type="hidden" name="type" value="${listDTO.type}">
            <input type="hidden" name="keyword" value="${listDTO.keyword}">
        <div>
            <div>
                <input type = "text" name ="bno" value="<c:out value="${boardDTO.bno}"/>" readonly >
            </div>
            <div>
                <input type="text" name="title" value="<c:out value="${boardDTO.title}"/>">
            </div>
            <div>
                <textarea name="content"/><c:out value="${boardDTO.content}"></c:out> </textarea>
            </div>
        </div>
    </form>
    <div class="btnDiv">
        <button class="listBtn">목록</button>
        <button class="modifyPostBtn">수정</button>
        <button class="delPostBtn">삭제</button>
    </div>
    <form class="actionForm" action="/board/remove/{bno}" method="post">
    </form>
    <script>
        function sQuery(expression){
            return document.querySelector(expression);
        }


        const btnDiv = document.querySelector(".btnDiv");
        const bno = ${boardDTO.bno};
        const actionForm = sQuery(".actionForm");

        sQuery(".listBtn").addEventListener("click",(e)=>{
            e.preventDefault();
            e.stopPropagation();
            self.location = "/board/list/${listDTO.link}";
        },false);

        sQuery(".delPostBtn").addEventListener("click",(e)=>{

            actionForm.setAttribute("action",'/board/remove/${bno}');
            console.log('삭제');
            actionForm.submit();

        },false);

    sQuery(".modifyPostBtn").addEventListener("click",(e)=>{
        const modifyForm =  sQuery(".modifyForm");
        console.log(modifyForm);
        modifyForm.setAttribute("action",`/board/modify/`+bno);
        modifyForm.submit();

    },false)
    </script>
</body>
</html>
