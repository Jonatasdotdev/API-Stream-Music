package com.example.music.controller;

import com.example.music.model.Music;
import com.example.music.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @GetMapping
    public ResponseEntity<List<Music>> getAll() {
        List<Music> musicList = musicService.getAll();
        return new ResponseEntity<>(musicList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Music> getById(@PathVariable Long id) {
        return musicService.getById(id)
                .map(music -> new ResponseEntity<>(music, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Music> add(@RequestBody Music music) {
        Music newMusic = musicService.save(music);
        return new ResponseEntity<>(newMusic, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Music> update(@PathVariable Long id, @RequestBody Music music) {
        Music updatedMusic = musicService.update(id, music);
        return new ResponseEntity<>(updatedMusic, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        musicService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
