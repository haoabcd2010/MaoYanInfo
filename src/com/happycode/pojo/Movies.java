package com.happycode.pojo;

import java.sql.Date;

public class Movies {
	// id, ranking, picture, name, star, releasetime, score, gettime
	private Integer id;
	private String ranking;
	private String picture;
	private String name;
	private String star;
	private String releasetime;
	private String score;
	private Date gettime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRanking() {
		return ranking;
	}
	public void setRanking(String ranking) {
		this.ranking = ranking;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public String getReleasetime() {
		return releasetime;
	}
	public void setReleasetime(String releasetime) {
		this.releasetime = releasetime;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public Date getGettime() {
		return gettime;
	}
	public void setGettime(Date gettime) {
		this.gettime = gettime;
	}
	@Override
	public String toString() {
		return "Movies [id=" + id + ", ranking=" + ranking + ", picture=" + picture + ", name=" + name + ", star="
				+ star + ", releasetime=" + releasetime + ", score=" + score + ", gettime=" + gettime + "]";
	}
}
