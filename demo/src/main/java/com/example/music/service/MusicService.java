package com.example.music.service;

import com.example.music.model.Music;
import com.example.music.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;

    public List<Music> getAll() {
        return musicRepository.findAll();
    }

    public Optional<Music> getById(Long id) {
        return musicRepository.findById(id);
    }

    public Music save(Music music) {
        return musicRepository.save(music);
    }

    public void delete(Long id) {
        musicRepository.deleteById(id);
    }

    public Music update(Long id, Music updatedMusic) {
        return musicRepository.findById(id)
                .map(music -> {
                    music.setTitle(updatedMusic.getTitle());
                    music.setArtist(updatedMusic.getArtist());
                    music.setGenre(updatedMusic.getGenre());
                    music.setDuration(updatedMusic.getDuration());
                    return musicRepository.save(music);
                })
                .orElseGet(() -> {
                    updatedMusic.setId(id);
                    return musicRepository.save(updatedMusic);
                });
    }
}
