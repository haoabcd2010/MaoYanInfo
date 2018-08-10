package com.happycode.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.happycode.pojo.Movies;
import com.happycode.pojo.MoviesVo;
import com.happycode.service.MoviesService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class MoviesAction extends ActionSupport {
	
	MoviesService moviesService = new MoviesService();
	
	// 分页
	private Integer page;
	
	// 条件
	private Integer con;
	private String str;
	
	// 多条件封装
	private MoviesVo moviesVo;
	
	// 显示全部
	public String showAll() {
		List<Movies> movies = moviesService.findTopMovies();
		ServletActionContext.getRequest().setAttribute("Movies", movies);
		if (movies == null)
			return "error";
		return "success";
	}
	
	// 根据页号显示
	public String showAllByPage() {
		if (page == null) page = 1;
		List<Movies> movies = moviesService.findTopMoviesPage((page-1)*10, 10);
		ServletActionContext.getRequest().setAttribute("Movies", movies);
		if (movies == null)
			return "error";
		return "success";
	}
	
	// 根据条件查询
	public String showAllByCondition() {
		try {
			str = new String(str.getBytes("ISO8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		} 
		List<Movies> movies = moviesService.findTopMoviesByCondition(con, str);
		ServletActionContext.getRequest().setAttribute("Movies", movies);
		if (movies == null)
			return "error";
		return "success";
	}
	
	// 获取最新的电影排行
	public String showTopMoviesToday() {
		if (page == null) page = 1;
		List<Movies> movies = moviesService.findTopMoviesToday((page-1)*10, 10);
		ServletActionContext.getRequest().setAttribute("Movies", movies);
		if (movies == null)
			return "error";
		return "success";
	}
	
	// 根据多条件搜索电影
	public String showMoviesByManyCondition() {
		System.out.println(moviesVo);
		List<Movies> movies = moviesService.findMoviesByManyCondition(moviesVo);
		ServletActionContext.getRequest().setAttribute("Movies", movies);
		if (movies == null){
			return "error";
		}
		return "success";
	}
	
	// get and set
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getCon() {
		return con;
	}

	public void setCon(Integer con) {
		this.con = con;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public MoviesVo getMoviesVo() {
		return moviesVo;
	}

	public void setMoviesVo(MoviesVo moviesVo) {
		this.moviesVo = moviesVo;
	}
}
