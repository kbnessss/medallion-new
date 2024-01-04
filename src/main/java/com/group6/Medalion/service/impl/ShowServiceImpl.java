package com.group6.Medalion.service.impl;

import com.group6.Medalion.entity.Show;
import com.group6.Medalion.exception.ShowNotFoundException;
import com.group6.Medalion.repository.ShowRepository;
import com.group6.Medalion.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Override
    @Transactional
    public Show addShow(Show show) {
        validateShow(show);
        return showRepository.save(show);
    }

    @Override
    public Optional<Show> getShowById(Long id) {
        return showRepository.findById(id);
    }

    @Override
    @Transactional
    public Show updateShow(Long id, Show updatedShow) {
        return showRepository.findById(id).map(show -> {
            updateShowDetails(show, updatedShow);
            return showRepository.save(show);
        }).orElseThrow(() -> new ShowNotFoundException("Show not found with id " + id));
    }

    @Override
    public void deleteShow(Long id) {
        Show show = showRepository.findById(id)
                .orElseThrow(() -> new ShowNotFoundException("Show not found with id " + id));
        showRepository.delete(show);
    }

    @Override
    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    private void validateShow(Show show) {
        if (!StringUtils.hasText(show.getTitle())) {
            throw new IllegalArgumentException("Show title cannot be empty");
        }
        // Add other necessary validations
    }

    private void updateShowDetails(Show show, Show updatedShow) {
        show.setTitle(updatedShow.getTitle());
        show.setDescription(updatedShow.getDescription());
        show.setGenre(updatedShow.getGenre());
        show.setRatings(updatedShow.getRatings());
        show.setImageUrl(updatedShow.getImageUrl());
    }
}
