package com.example.music.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String artist;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private int duration;
}