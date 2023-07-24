$(function () {
    $("input[value=返回首页]").on("click", function () {
        location.href = "toList";
    });
});

/*
 * 提交分页请求
 * @param pageNo 页码
 */
function turnOverPage(pageNo) {
    if (!pageNo) {
        pageNo = parseInt(document.getElementById("jump").value);
    }
    if (isNaN(pageNo)) {
        alert("页码为空或输入错误！");
        return;
    }
    var pageCount = document.getElementById("pageCount").value;
    if (pageNo > pageCount) {
        pageNo = pageCount;
    } else if (pageNo < 1) {
        pageNo = 1;
    }
    var pageForm = document.getElementById('pageForm');
    document.getElementById("pageNo").value = pageNo;
    document.getElementById("pageSize").value = document.getElementById("currSize").value;
    pageForm.submit();
}