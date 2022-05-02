const replyService = (function (){

    const addReply = async function (replyObj,callback){
        console.log("addReply....");
        const res = await axios.post('/replies/',replyObj);

        callback();
    }

    const getList = async function (bno,callback){
        console.log("getList.....");
        const res = await axios.get(`/replies/list/${bno}`)
        console.log(res.data);
        callback(res.data);
    }

    return {addReply,getList};

})();

const sQuery = function (str){
    return document.querySelector(str);
}

const qsAddEvent =function (selector, type, callback){
    const target = document.querySelector(selector);

    target.addEventListener(type,callback,false);
}