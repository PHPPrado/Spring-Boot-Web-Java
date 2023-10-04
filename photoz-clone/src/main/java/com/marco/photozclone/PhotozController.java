package com.marco.photozclone;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

@RestController
public class PhotozController {
	
	private Map<String, Photo> db = new HashMap<>(){{
		put("1",new Photo("1", "hello.jpg"));

	}};

	@GetMapping("/photoz")
	public Collection<Photo> get(){
		return db.values();
	}
	
	@GetMapping("/photoz/{id}")
	public Photo get(@PathVariable String id){
		Photo photo = db.get(id);
		if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return photo;
	}

	@DeleteMapping("/photoz")
	public void delete(String id){
		Photo photo = db.remove(id);
		if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/photoz")
	public Photo create(@RequestPart("data") MultipartFile file) throws IOException{
		Photo photo = new Photo();
		photo.setId(UUID.randomUUID().toString());
		photo.setFilename(file.getOriginalFilename());
		photo.setData(file.getBytes());
		db.put(photo.getId(), photo);
		return photo;
	}
	
}
 