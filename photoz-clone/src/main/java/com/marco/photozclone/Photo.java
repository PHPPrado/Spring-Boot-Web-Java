package com.marco.photozclone;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Photo {

	private String id;

	@NotEmpty
	private String filename;

	@JsonIgnore
	private  byte[] data;
	
	
	public Photo(String id, String filename) {
		super();
		this.id = id;
		this.filename = filename;
	}


	public Photo() {
		
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
}
