package com.essilor.demo.caffeinecache.controller;

import com.essilor.demo.caffeinecache.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by RANGAREJ on 4/6/2018.
 */
@RestController
public class MusicController {
    @Autowired
    MusicService musicServiceIml;

    @GetMapping("/play/{instrument}")
    public String play(@PathVariable("instrument") String instrument) {
        return musicServiceIml.play(instrument);
    }
    @GetMapping("/play/clear")
    public void  clearAllCaches() {
          musicServiceIml.clearAllCaches();
    }
}
