package com.example.music.service;

import com.example.music.domain.Music;
import java.util.List;

public interface IMusicCommandService {
    Music createMusic(Music music);
    Music updateMusic(Music music);
    void deleteMusic(Long id);
    Music getMusic(Long id);
    List<Music> getMusic();
}