<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="static/js/jquery-3.3.1.min.js"></script>
<link href="static/css/bootstrap.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div>
		<strong>文档分类:</strong>
		<select id="select">
			<option value="0">全部</option>
		</select>
		<input type="button" value="查询"/>	
	</div>
	<table border="1">
		<tr>
			<td colspan="6">
				<h1>电子文档列表</h1>
			</td>
		</tr>
		<tr id="tr">
			<td>文档编号</td>
			<td>文档名称</td>
			<td>文档摘要</td>
			<td>上传人</td>
			<td>上传日期</td>
			<td>操作</td>
		</tr>
	</table>
	<div>
		<p>

		</p>
	</div>
	<script type="text/javascript">
		$(function(){
			Date.prototype.Format = function (fmt) { //author: meizz
				var o = {
				"M+": this.getMonth() + 1, //月份
				"d+": this.getDate(), //日
				"H+": this.getHours(), //小时
				"m+": this.getMinutes(), //分
				"s+": this.getSeconds(), //秒
				"q+": Math.floor((this.getMonth() + 3) / 3), //季度
				"S": this.getMilliseconds() //毫秒
				};
				if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
				for (var k in o)
				if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
				return fmt;
			}
			
			
			var initEdocCategoryDataUrl = "/EdocManagement/index/initEdocCategoryData";
			$.get(initEdocCategoryDataUrl,function(data){
				var htm = "";
				$(data).each(function(){
					htm +="<option value="+this.id+">"+this.name+"</option>";
				});
				$("#select").append(htm);
			},"json");
			////////////////////////////////////////////
			initEdocEntryData(1);
			////////////////////////
			$("#select").change(function(){
				initEdocEntryData(1);
			});

		});
		function initEdocEntryData(currentPage){
		    var categoryId = $("#select").find("option:selected").val();
			var initEdocEntryDataUrl = "/EdocManagement/index/initEdocEntryData/"+categoryId+"/"+currentPage;
			$.get(initEdocEntryDataUrl,function(data){
				var htm = "";
				var htm2 = "";
				$("#tr").nextAll().remove();
				$("#a").nextAll().remove();
				$(data.list).each(function(){
					htm +="<tr>";
					htm +="<td>"+this.id+"</td>";
					htm +="<td>"+this.title+"</td>";
					htm +="<td>"+this.summary+"</td>";
					htm +="<td>"+this.uoloaduser+"</td>";
					htm +="<td>"+new Date(this.createdate).Format("yyyy-MM-dd HH:mm:ss")+"</td>";
					htm +="<td><a href='javascript:void(0);' class='del' val="+this.id+">删除</a></td>";
					htm +="</tr>";
				});
				$("table").append(htm);

                $("p").html("");
                htm2 +='<a href="javascript:void(0);" onclick="initEdocEntryData(0)">首页</a>  ';
                htm2 +='<a href="javascript:void(0);" onclick="initEdocEntryData('+(data.pageNum-1)+')">上一页</a>  ';
                htm2 +='<a href="javascript:void(0);" onclick="initEdocEntryData('+data.nextPage+')">下一页</a>  ';
                htm2 +='<a href="javascript:void(0);" onclick="initEdocEntryData('+data.pages+')" id="a">末页</a>  ';
				htm2 +='<span>第'+data.pageNum+'页/共'+data.pages+'页</span>';
				$("p").append(htm2);
				
				$("#tr").nextAll("tr:odd").attr("bgColor","#EECBAD");
				
				$(".del").on("click",function(){
					var r=confirm("确定删除该文档吗");
					if(!r){
						return ;
					}
					var id = $(this).attr("val");
					var del = $(this);
					var delEdocEntryUrl = "/EdocManagement/index/delEdocEntry/"+id;
					$.post(delEdocEntryUrl,function(data){
						alert(data);
						$(del).parents("tr").remove();
					},"json");
				});
				
			},"json");
		}
		

	</script>	
</body>
<style>
	h1{text-align:center;}
	#tr{background-color:#C0C0C0;}
</style>
</html>