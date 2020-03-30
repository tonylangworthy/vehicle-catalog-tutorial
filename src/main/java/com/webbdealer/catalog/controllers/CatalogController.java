package com.webbdealer.catalog.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogController {

    @RequestMapping(method = RequestMethod.GET, path = "/test")
    public ResponseEntity<String> testEndpoint() {

        return ResponseEntity.ok("Hello World!");
    }
}
