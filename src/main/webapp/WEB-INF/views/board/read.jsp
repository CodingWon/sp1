<%--
  Created by IntelliJ IDEA.
  User: JIwon
  Date: 2022-04-30
  Time: 오전 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<div>
    <div>
        <input type="text" name="bno" value="<c:out value="${boardDTO.bno}"/>" disabled>
    </div>
    <div>
        <input type="text" name="title" value="<c:out value="${boardDTO.title}"/>" disabled>
    </div>
    <div>
        <textarea name="content" disabled/><c:out value="${boardDTO.content}"></c:out> </textarea>
    </div>
</div>

<div class="btnDiv">
    <button class="listBtn">목록</button>
    <button class="modifyBtn">수정/삭제</button>
</div>
<hr>
<div>
    <div>
        <input type="text" name="replyText">
    </div>
    <div>
        <input type="text" name="replyer">
    </div>
    <div>
        <button class="addReplyBtn">댓글 추가</button>
    </div>
</div>

<div>
    <ul class="replyUL">

    </ul>
</div>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="/resources/js/reply.js"></script>
<script>
    const bno = ${boardDTO.bno};
    const replyUL = sQuery(".replyUL");
    const replyCount = ${boardDTO.replyCount};
    console.log(replyCount);

    function getServerList() {
        replyService.getList(bno, (replyArr) => {
            const liArr = replyArr.map(reply => `<li>\${reply.rno}</li>`);
            replyUL.innerHTML = liArr.join(" ");
        });
    }

    function addServerReply(){
        replyService.addReply(
            {bno: bno,
            replyText: sQuery("input[name='replyText']").value,
            replyer: sQuery("input[name='replyer']").value},
            () => {
                getServerList();
            }
        );
    }

    qsAddEvent(".addReplyBtn","click",addServerReply());

    const btnDiv = document.querySelector(".btnDiv");
    btnDiv.addEventListener("click", (e) => {

        e.preventDefault();
        e.stopPropagation();

        if (e.target.getAttribute("class") == "listBtn") {
            self.location = "/board/list${listDTO.link}";
        }

        if (e.target.getAttribute("class") == "modifyBtn") {
            self.location = "/board/modify/${bno}${listDTO.link}";
        }
    }, false)


</script>
</body>
</html>
