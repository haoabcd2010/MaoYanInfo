package com.happycode.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * JdbcUtils小工具
 * V5.0
 * 需要MysqlConnector.jar, c3p0.jar, mcchange.jar
 */
public class JdbcUtils {
	// 配置文件的默认配置，要求必须给出c3p0-config.xml
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	/*
	 * 从数据库连接池获取Connection
	 */
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	/*
	 * 获取连接池对象
	 */
	public static ComboPooledDataSource getDataSource() {
		return dataSource;
	}
	
	/*
	 * 虽然con.close()是返还给连接池Connection，并不是关闭，为了便于形容才说关闭
	 */
	public static void releaseConnetion(Connection connection) throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}
}