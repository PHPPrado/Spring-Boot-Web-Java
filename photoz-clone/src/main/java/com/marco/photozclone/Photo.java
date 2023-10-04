package com.marco.photozclone;

public class Photo {

	private String id;
	
	private String filename;
	
	
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
