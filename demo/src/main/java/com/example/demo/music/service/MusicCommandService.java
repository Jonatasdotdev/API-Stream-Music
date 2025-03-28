package com.example.demo.music.service;

import com.example.demo.music.domain.Music;
import com.example.demo.music.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicCommandService implements IMusicCommandService {
    private final MusicRepository musicRepository;

    @Autowired
    public MusicCommandService(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public Music createMusic(Music music) {
        return musicRepository.save(music);
    }

    @Override
    public Music updateMusic(Music music) {
        return musicRepository.save(music);
    }

    @Override
    public void deleteMusic(Long id) {
        musicRepository.deleteById(id);
    }

    @Override
    public Music getMusic(Long id) {
        return musicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Música não encontrada"));
    }

    @Override
    public List<Music> getMusic() {
        return musicRepository.findAll();
    }
}