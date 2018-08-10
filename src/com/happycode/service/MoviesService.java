package com.happycode.service;

import java.sql.SQLException;
import java.util.List;

import com.happycode.dao.MoviesDao;
import com.happycode.pojo.Movies;
import com.happycode.pojo.MoviesVo;

public class MoviesService {
	
	MoviesDao moviesDao = new MoviesDao();
	
	/*
	 * 查询所有榜单
	 */
	public List<Movies> findTopMovies(){
		List<Movies> list = null;
		try {
			list = moviesDao.findTopMovies();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	/*
	 * 查询电影分页
	 */
	public List<Movies> findTopMoviesPage(int x, int y){
		List<Movies> list = null;
		try {
			list = moviesDao.findTopMoviesPage(x, y);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/*
	 * 查询电影分页,
	 * 根据条件
	 */
	public List<Movies> findTopMoviesByCondition(int con, String str) {
		List<Movies> list = null;
		try {
			list = moviesDao.findTopMoviesByCondition(con, str);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	/*
	 * 根据时间查询电影排行
	 */
	public List<Movies> findTopMoviesToday(int x, int y) {
		List<Movies> list = null;
		try {
			list =  moviesDao.findTopMoviesToday(x, y);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	/*
	 * 查询多条件下的电影
	 */
	public List<Movies> findMoviesByManyCondition(MoviesVo mVo) {
		List<Movies> list = null;
		try {
			list =  moviesDao.findMoviesByManyCondition(mVo);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
}
