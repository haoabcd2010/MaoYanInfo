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
    	<div class="col-md-5">
    		<h1><a href="showTopMoviesToday">猫眼电影Top100</a></h1>
    	</div>
    	<div class="col-md-2">
    		<h4>爬取时间: ${Movies[0].gettime}</h4>
    	</div>
    	<div class="col-md-3">
    		<form action="">
			    <div style="padding-top: 20px">
				    <div class="input-group">
				      	<input id="constr" type="text" class="form-control" placeholder="搜索电影">
					      <div class="input-group-btn">
					        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					        	搜索方式
					        	<span class="caret"></span>
					        </button>
					        <ul class="dropdown-menu dropdown-menu-right">
					          <li><a href="javascript:hello(1)">电影名</a></li>
					          <li><a href="javascript:hello(2)">主演</a></li>
					          <li><a href="javascript:hello(3)">上映时间</a></li>
					          <li><a href="javascript:hello(4)">爬取时间</a></li>
					          <li role="separator" class="divider"></li>
          					  <li><a href="<c:url value = "/find.jsp"/>">高级搜索</a></li>
					        </ul>
					      </div><!-- /btn-group -->
					      </div><!-- /input-group -->
				  </div><!-- /.col-lg-6 -->
    		</form>
    	</div>
    </div>
    <div class="row">
	  <div class="col-md-10">
	  	<table class="table table-bordered" style="text-align:center">
	  		<tr>
	  			<td>排名</td>
	  			<td>图片</td>
	  			<td>电影名</td>
	  			<td>主演</td>
	  			<td>上映时间</td>
	  			<td>评分</td>
	  			<td>爬取时间</td>
	  		</tr>
	  		<c:forEach items="${Movies}" var="item">
	  			<tr>
		  			<td><h1>${item.ranking}</h1></td>
		  			<td><img src="${item.picture}" alt=""/></td>
		  			<td><h3>${item.name}</h3></td>
		  			<td><h3>${item.star}</h3></td>
		  			<td><h3>${item.releasetime}</h3></td>
		  			<td><h1>${item.score}</h1></td>
		  			<td><h3>${item.gettime}</h3></td>
	  			</tr>
	  		</c:forEach>
		</table>
	  </div>
	  <div class="col-md-2">
	  	<h3><span style="color: red;">广告位招租</span></h3>
	  	<h3><span style="color: red;">￥1000元 一天</span></h3>
	  </div>
	</div>
	<nav aria-label="Page navigation">
  	<ul class="pagination">
    	<li <c:if test="${page==1}">class="disabled"</c:if>>
    		<a href="showTopMoviesToday?page=${page-1}" aria-label="Previous">
    			<span aria-hidden="true">&laquo;</span>
    		</a>
    	</li>
    	<li <c:if test="${page==1}">class="active"</c:if> >
    		<a href="showTopMoviesToday?page=1">1 <span class="sr-only">(current)</span></a>
    	</li>
    	<li <c:if test="${page==2}">class="active"</c:if> >
    		<a href="sshowTopMoviesToday?page=2">2 <span class="sr-only">(current)</span></a>
    	</li>
	    <li <c:if test="${page==3}">class="active"</c:if> >
    		<a href="showTopMoviesToday?page=3">3 <span class="sr-only">(current)</span></a>
    	</li>
    	<li <c:if test="${page==4}">class="active"</c:if> >
    		<a href="showTopMoviesToday?page=4">4 <span class="sr-only">(current)</span></a>
    	</li>
    	<li <c:if test="${page==5}">class="active"</c:if> >
    		<a href="showTopMoviesToday?page=5">5 <span class="sr-only">(current)</span></a>
    	</li>
    	<li <c:if test="${page==6}">class="active"</c:if> >
    		<a href="showTopMoviesToday?page=6">6 <span class="sr-only">(current)</span></a>
    	</li>
    	<li <c:if test="${page==7}">class="active"</c:if> >
    		<a href="showTopMoviesToday?page=7">7 <span class="sr-only">(current)</span></a>
    	</li>
    	<li <c:if test="${page==8}">class="active"</c:if> >
    		<a href="showTopMoviesToday?page=8">8 <span class="sr-only">(current)</span></a>
    	</li>
    	<li <c:if test="${page==9}">class="active"</c:if> >
    		<a href="showTopMoviesToday?page=9">9 <span class="sr-only">(current)</span></a>
    	</li>
    	<li <c:if test="${page==10}">class="active"</c:if> >
    		<a href="showTopMoviesToday?page=10">10 <span class="sr-only">(current)</span></a>
    	</li>
	    <li <c:if test="${page==10}">class="disabled"</c:if>>
    		<a href="showTopMoviesToday?page=${page+1}" aria-label="Next">
    			<span aria-hidden="true">&raquo;</span>
    		</a>
    	</li>
  	</ul>
</nav>
  </body>
</html>