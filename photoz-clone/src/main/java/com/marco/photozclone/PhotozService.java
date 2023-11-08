package com.marco.photozclone;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@Service
@Data
public class PhotozService {
    private Map<String, Photo> db = new HashMap<>(){{
        put("1", new Photo("1", "hello.jpg"));
    }};

    public Collection<Photo> get(){
        return null;
    }

    public Photo get(String id) {
        return db.get(id);
    }

    public void save(String filename, byte[] data) {
        Photo photo = new Photo();
        photo.setId(UUID.randomUUID().toString());
        photo.setFilename(file.getOriginalFilename());
        photo.setData(file.getBytes());
    }

    public Photo remove(String id) {
        return db.remove(id);
    }
}
