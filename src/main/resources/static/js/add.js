$(function(){
	$.get("getCompanyList", function(result){
		//alert(JSON.stringify(result));
		$.each(result, function(index, item){
			$("#company").append("<option value='" + item.companyId + "'>" + item.companyName + "</option>");
		});
	});
});