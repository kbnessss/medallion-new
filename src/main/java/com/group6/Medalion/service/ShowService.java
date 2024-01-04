package com.group6.Medalion.service;

import com.group6.Medalion.entity.Show;
import java.util.List;
import java.util.Optional;

public interface ShowService {
    Show addShow(Show show);
    Optional<Show> getShowById(Long id);
    Show updateShow(Long id, Show show);
    void deleteShow(Long id);
    List<Show> getAllShows();
}
