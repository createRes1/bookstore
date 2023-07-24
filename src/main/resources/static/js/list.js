$(function(){
    // 全选按钮
    $("input[name=selectAll]").on("click", function () {
        if ($("input[name=selectAll]").prop("checked") == true) {
            $("input[name=sel]").prop("checked", true);
        } else {
            $("input[name=sel]").prop("checked", false);
        }
    });
    $("input[value=添加图书]").on("click",function(){
        location.href="toAdd";
    });

    $("input[value=删除]").on("click",function(){
        if(window.confirm("确定删除该条记录吗?")){
            location.href="remove?id="+$(this).attr("id");
        }
    });

    $("input[value=更新]").on("click",function(){
        location.href="toModify?id="+$(this).attr("id");
    });

    $("input[value=删除所选]").on("click", function () {
        var id = "";
        $.each($("input[name=sel]:checked"), function (index, item) {
            id = id + $(this).parents("tr").attr("id") + ",";// 循环取到所选的id，以","隔开
        });
//		 $("input[name=sel]").each(function() {
// 			if ($(this).is(":checked")) {
// 				id = id + $(this).parents("tr").attr("id") + ",";
// 			}
// 		});
//		alert(id);
        if (id == "") {
            alert("请选择要删除图书信息");
        } else {
            if (confirm("确定删除所选图书信息")) {
                id = id.substring(0, id.length - 1);// 最后会多一个"," ，所以要去掉
                location.href = "remove?id=" + id;// 将id传给控制器
            }
        }
    });

});
