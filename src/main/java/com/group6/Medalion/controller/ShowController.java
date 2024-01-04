package com.group6.Medalion.controller;

import com.group6.Medalion.entity.Show;
import com.group6.Medalion.exception.ShowNotFoundException;
import com.group6.Medalion.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {
    @Autowired
    private ShowService showService;

    @PostMapping
    public ResponseEntity<Show> createShow(@RequestBody Show show) {
        Show newShow = showService.addShow(show);
        return new ResponseEntity<>(newShow, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable Long id) {
        Show show = showService.getShowById(id)
                .orElseThrow(() -> new ShowNotFoundException("Show not found with id " + id));
        return new ResponseEntity<>(show, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Show> updateShow(@PathVariable Long id, @RequestBody Show show) {
        Show updatedShow = showService.updateShow(id, show);
        return new ResponseEntity<>(updatedShow, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShow(@PathVariable Long id) {
        showService.deleteShow(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Show>> getAllShows() {
        List<Show> shows = showService.getAllShows();
        return new ResponseEntity<>(shows, HttpStatus.OK);
    }
}
