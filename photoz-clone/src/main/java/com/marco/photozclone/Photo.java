package com.marco.photozclone;

import jakarta.validation.constraints.NotEmpty;

public class Photo {

	private String id;
	
	@NotEmpty
	private String filename;
	
	private byte[] data;
	
	public Photo(String id, String filename) {
		super();
		this.id = id;
		this.filename = filename;
	}


	public Photo() {
		
	}


	public byte[] getData(){
		return data;
	}

	public void setData(byte[] data){
		this.data = data;
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
