package com.example.music.controller;

import com.example.music.domain.Music;
import com.example.music.dto.MusicCreateRequest;
import com.example.music.dto.MusicResponse;
import com.example.music.dto.MusicUpdateRequest;
import com.example.music.mapper.MusicMapper;
import com.example.music.service.IMusicCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/music")
public class MusicController {
    private final IMusicCommandService musicService;

    @Autowired
    public MusicController(IMusicCommandService musicService) {
        this.musicService = musicService;
    }

    @PostMapping
    public ResponseEntity<MusicResponse> createmusicsync(@RequestBody MusicCreateRequest request) {
        Music music = MusicMapper.toEntity(request);
        Music createdMusic = musicService.createMusic(music);
        MusicResponse response = MusicMapper.toResponse(createdMusic);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PatchMapping("/{music_identifier}")
    public ResponseEntity<MusicResponse> updatemusicsync(
            @PathVariable("music_identifier") Long id,
            @RequestBody MusicUpdateRequest request) {
        Music music = MusicMapper.toEntity(request, id);
        Music updatedMusic = musicService.updateMusic(music);
        MusicResponse response = MusicMapper.toResponse(updatedMusic);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MusicResponse>> getmusicsync() {
        List<Music> musicList = musicService.getMusic();
        List<MusicResponse> responseList = musicList.stream()
                .map(MusicMapper::toResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @GetMapping("/{music_identifier}")
    public ResponseEntity<MusicResponse> getmusicsync(@PathVariable("music_identifier") Long id) {
        Music music = musicService.getMusic(id);
        MusicResponse response = MusicMapper.toResponse(music);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{music_identifier}")
    public ResponseEntity<Void> deletemusicsync(@PathVariable("music_identifier") Long id) {
        musicService.deleteMusic(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}