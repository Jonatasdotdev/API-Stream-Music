package com.example.demo.music.mapper;



import com.example.demo.music.domain.Music;
import com.example.demo.music.dto.MusicCreateRequest;
import com.example.demo.music.dto.MusicResponse;
import com.example.demo.music.dto.MusicUpdateRequest;

public class MusicMapper {
    public static Music toEntity(MusicCreateRequest request) {
        Music music = new Music();
        music.setTitle(request.getTitle());
        music.setArtist(request.getArtist());
        music.setGenre(request.getGenre());
        music.setDurationInSeconds(request.getDurationInSeconds());
        return music;
    }

    public static Music toEntity(MusicUpdateRequest request, Long id) {
        Music music = new Music();
        music.setId(id);
        music.setTitle(request.getTitle());
        music.setArtist(request.getArtist());
        music.setGenre(request.getGenre());
        music.setDurationInSeconds(request.getDurationInSeconds());
        return music;
    }

    public static MusicResponse toResponse(Music music) {
        MusicResponse response = new MusicResponse();
        response.setId(music.getId());
        response.setTitle(music.getTitle());
        response.setArtist(music.getArtist());
        response.setGenre(music.getGenre());
        response.setDurationInSeconds(music.getDurationInSeconds());
        return response;
    }
}
