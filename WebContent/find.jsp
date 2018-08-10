<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>猫眼电影榜单</title>

    <!-- Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<script>
        function hello(con) {
            var ccc = "showAllByCondition?con=" + con + "&str="+ document.getElementById("constr").value;
            window.location.href = ccc;
        }
    </script>
  </head>
<body>
	<div class="row">
		<div class="col-md-12"><h1 style="margin-left: 16em; margin-right: auto;">多条件搜索</h1></div>
	</div>
	<div class="row">
		<div class="col-md-4">&nbsp;</div>
		<div class="col-md-4">
			<form action="showMoviesByManyCondition" method="post">
				<div class="form-group">
				  <label for="exampleInputEmail1">排名</label>
				  <input name="moviesVo.q_ranking" type="text" class="form-control" id="exampleInputEmail1" placeholder="排名">
				</div>
				<div class="form-group">
				  <label for="exampleInputEmail1">电影名</label>
				  <input name="moviesVo.q_name" type="text" class="form-control" id="exampleInputEmail1" placeholder="电影名">
				</div>
				<div class="form-group">
				  <label for="exampleInputEmail1">主演</label>
				  <input name="moviesVo.q_star" type="text" class="form-control" id="exampleInputEmail1" placeholder="主演">
				</div>
				<div class="form-group">
				  <label for="exampleInputEmail1">上映时间</label>
				  <input name="moviesVo.q_releasetime" type="text" class="form-control" id="exampleInputEmail1" placeholder="上映时间">
				</div>
				<div class="form-group">
				  <label for="exampleInputEmail1">评分</label>
				  <input name="moviesVo.q_score" type="text" class="form-control" id="exampleInputEmail1" placeholder="评分">
				</div>
				<div class="form-group">
				  <label for="exampleInputEmail1">爬取时间</label>
				  <input name="moviesVo.q_gettime" type="text" class="form-control" id="exampleInputEmail1" placeholder="爬取时间(默认为最新)">
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
		<div class="col-md-4">&nbsp;</div>
	</div>


</body>
</html>