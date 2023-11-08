package com.marco.photozclone;

import java.io.IOException;
import java.util.*;

import jakarta.validation.Valid;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Data
public class PhotozController {

	private final PhotozService photozService;

	private PhotozController(PhotozService photozService){
		this.photozService = photozService;
	}

	@GetMapping("/photoz")
	public Collection<Photo> get() {
		return photozService.get();
	}
	
	@GetMapping("/photoz/{id}")
	public Photo get(@PathVariable String id) {
        Photo photo = photozService.get(id);
        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

	@DeleteMapping("/photoz/{id}")
	public void delete(String id) {
		Photo photo = photozService.remove(id);
		if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/photoz")
	public Photo create(@RequestPart("data") MultipartFile file) throws IOException {

		photozService.save(photo.getId(), photo);
		return photo;
	}
}
