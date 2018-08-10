package com.happycode.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.happycode.pojo.Movies;
import com.happycode.pojo.MoviesVo;
import com.happycode.utils.TxQueryRunner;

public class MoviesDao {
	
	private TxQueryRunner txqr = new TxQueryRunner();
	
	/*
	 * 所有的榜单
	 */
	public List<Movies> findTopMovies() throws SQLException {
		String sql ="select * from tops";
		
		return txqr.query(sql, new BeanListHandler<Movies>(Movies.class));
	}
	
	/*
	 * 分页查询榜单
	 */
	public List<Movies> findTopMoviesPage(int x, int y) throws SQLException {
		String sql ="select * from tops limit ?, ?";
		
		return txqr.query(sql, new BeanListHandler<Movies>(Movies.class), x, y);
	}
	
	/*
	 * 根据条件查询
	 */
	public List<Movies> findTopMoviesByCondition(int con, String str) throws SQLException  {
		String sql ="select * from tops where ";
		switch (con) {
			case 1:
				sql = sql + "name like ?"; break;
			case 2:
				sql = sql + "star like ?"; break;
			case 3:
				sql = sql + "releasetime like ?"; break;
			case 4:
				sql = sql + "gettime like ?"; break;
		}
		str = "%" + str + "%";
		
		return txqr.query(sql, new BeanListHandler<Movies>(Movies.class), str);
	}
	
	// 根据gettime搜索，就是搜索最新的排行
	public List<Movies> findTopMoviesToday(int x, int y) throws SQLException {
		
		Calendar calendar = Calendar.getInstance(); 
		int h = calendar.get(Calendar.HOUR_OF_DAY);
		int m = calendar.get(Calendar.MINUTE);
		
		String sql = "select * from tops where gettime like ?";
		
		String tpsql = "";
		// 大于10:10查今天数据，否则查昨天的
		if (h > 10 || (h == 10 && m>=10)) {
			tpsql = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()) + "%";
		} else {
			calendar.add(Calendar.DATE,-1);
			tpsql = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()) + "%";
		}
		
		sql = sql + " limit ?, ?";
		return txqr.query(sql, new BeanListHandler<Movies>(Movies.class), tpsql, x, y);
	}
	
	
	// 根据gettime搜索，就是搜索最新的排行
	public List<Movies> findMoviesByManyCondition(MoviesVo mVo) throws SQLException {
		StringBuilder sql = new StringBuilder("select * from tops where gettime like ?");
		
		String q_ranking = mVo.getQ_ranking().trim();
		String q_name = mVo.getQ_name().trim();
		String q_star = mVo.getQ_star().trim();
		String q_releasetime = mVo.getQ_releasetime().trim();
		String q_score = mVo.getQ_score().trim();
		String q_gettime = mVo.getQ_gettime().trim().trim();
		
		List<Object> params = new ArrayList<Object>();
		
		// 先确定爬取时间
		String tpsql = "";
		if (q_gettime == null || q_gettime.equals("")) {
			Calendar cal = Calendar.getInstance();
			int h = cal.get(Calendar.HOUR_OF_DAY);
			int m = cal.get(Calendar.MINUTE);
			// 大于10:10查今天数据，否则查昨天的
			if (h > 10 || (h == 10 && m>=10)) {
				tpsql = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()) + "%";
			} else {
				cal.add(Calendar.DATE,-1);
				tpsql = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()) + "%";
			}
		} else {
			tpsql = "%" + q_gettime + "%";
		}
		params.add(tpsql);
		
		if (q_ranking != null && !q_ranking.equals("")) {
			sql = sql.append(" and ranking like ?");
			params.add( "%" + q_ranking + "%" );
		}
		if (q_name != null && !q_name.equals("")) {
			sql = sql.append(" and name like ?");
			params.add("%" + q_name + "%");
		}
		if (q_star != null && !q_star.equals("")) {
			sql = sql.append(" and star like ?");
			params.add("%" + q_star + "%");
		}
		if (q_releasetime != null && !q_releasetime.equals("")) {
			sql = sql.append(" and releasetime like ?");
			params.add("%" + q_releasetime + "%");
		}
		if (q_score != null && !q_score.equals("")) {
			sql = sql.append(" and score like ?");
			params.add("%" + q_score + "%");
		}
		
		System.out.println(sql);
		
		return txqr.query(sql.toString(), new BeanListHandler<Movies>(Movies.class), params.toArray());
	}
}
