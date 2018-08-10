package test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.happycode.dao.MoviesDao;
import com.happycode.pojo.Movies;
import com.happycode.pojo.MoviesVo;
import com.happycode.service.MoviesService;

public class DaoTest {

	@Test
	public void fun1() throws SQLException{
		MoviesDao moviesDao = new MoviesDao();
		System.out.println(moviesDao.findTopMovies());
	}
	
	@Test
	public void fun2() throws SQLException{
		MoviesService moviesService = new MoviesService();
		System.out.println(moviesService.findTopMoviesByCondition(3, "1"));
	}
	
	@Test
	public void func3() throws SQLException {
		MoviesDao moviesDao = new MoviesDao();
		List<Movies> list = moviesDao.findTopMoviesToday(5, 6);
		for (Movies i : list) {
			System.out.println(i);
		}
	}
	
	// 测试多条件查询
	@Test
	public void func4() throws SQLException {
		MoviesDao moviesDao = new MoviesDao();
		MoviesVo mVo = new MoviesVo();
		mVo.setQ_ranking("1");
		mVo.setQ_name("霸王");
		mVo.setQ_star("张");
		mVo.setQ_releasetime("1993");
		mVo.setQ_score("9");
		mVo.setQ_gettime("8-09");
		
		List<Movies> list = moviesDao.findMoviesByManyCondition(mVo);
		for (Movies i : list) {
			System.out.println(i);
		}
	}
}
