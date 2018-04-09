package com.essilor.demo.caffeinecache.controller;

import com.essilor.demo.caffeinecache.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by RANGAREJ on 4/9/2018.
 */
@RestController
public class CommonController {
    @Autowired
    CommonService commonServiceImpl;

    @GetMapping("/cache/clearAll")
    public void clearAllCache() {
        commonServiceImpl.clearAllCaches();
    }
}
