package com.marco.photozclone;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhotozController {
	
	private List<Photo> db = List.of(new Photo("1", "hello.jpg"));

	@GetMapping("/photoz")
	public List<Photo> get(){
		return db;
	}
	
	@GetMapping("/photoz/{id}")
	public List<Photo> get(@PathVariable String id){
		return db;
	}
	
}
