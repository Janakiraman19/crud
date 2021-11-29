package com.demo.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	private String id;
	private String actor;
	private String actress;
	private String music_director;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getActress() {
		return actress;
	}

	public void setActress(String actress) {
		this.actress = actress;
	}

	public String getMusic_director() {
		return music_director;
	}

	public void setMusic_director(String music_director) {
		this.music_director = music_director;
	}




	
}