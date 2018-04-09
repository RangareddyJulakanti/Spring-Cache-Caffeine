package com.essilor.demo.caffinecache.service;

public interface MusicService {

    String play(final String instrument);
    String remove(String  instrument);
    void clearAllCaches();
}

