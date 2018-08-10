package com.happycode.pojo;


public class MoviesVo extends Movies {
	
	private String q_ranking;
	private String q_name;
	private String q_star;
	private String q_releasetime;
	private String q_score;
	private String q_gettime;
	
	
	public String getQ_ranking() {
		return q_ranking;
	}
	public void setQ_ranking(String q_ranking) {
		this.q_ranking = q_ranking;
	}
	public String getQ_name() {
		return q_name;
	}
	public void setQ_name(String q_name) {
		this.q_name = q_name;
	}
	public String getQ_star() {
		return q_star;
	}
	public void setQ_star(String q_star) {
		this.q_star = q_star;
	}
	public String getQ_releasetime() {
		return q_releasetime;
	}
	public void setQ_releasetime(String q_releasetime) {
		this.q_releasetime = q_releasetime;
	}
	public String getQ_score() {
		return q_score;
	}
	public void setQ_score(String q_score) {
		this.q_score = q_score;
	}
	public String getQ_gettime() {
		return q_gettime;
	}
	public void setQ_gettime(String q_gettime) {
		this.q_gettime = q_gettime;
	}
	@Override
	public String toString() {
		return "MoviesVo [q_ranking=" + q_ranking + ", q_name=" + q_name + ", q_star=" + q_star + ", q_releasetime="
				+ q_releasetime + ", q_score=" + q_score + ", q_gettime=" + q_gettime + "]";
	}
}
