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
        <input type="text" name="replyText" value="샘플 댓글">
    </div>
    <div>
        <input type="text" name="replyer" value="생픔user">
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
<script>

    const bno = ${boardDTO.bno};

    document.querySelector(".addReplyBtn").addEventListener("click",(e)=>{
        const replyText = document.querySelector("input[name='replyText']").value;
        const replyer = document.querySelector("input[name ='replyer']").value;
        const reply = {bno,replyText,replyer};

        console.log(reply);
        sendPost(reply);
    },false)

    async function sendPost(reply){
        const res = await axios.post(`/replies/`,reply);
    }
    async function getReplyList(bno) {
        try {
            const res = await axios.get('/replies/list/${bno}');
            const data = res.data;
            return data;
        } catch (err) {
            return err
        }
    }

    getReplyList(bno)
        .then(arr => {
            const liStr = arr.map(replyDTO => `<li>rno : \${replyDTO.rno} <br> text : \${replyDTO.replyText} <br> \${replyDTO.replyer}</li>`).join(" ")
            document.querySelector(".replyUL").innerHTML = liStr;
        })
        .catch(err => console.log(err));


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
