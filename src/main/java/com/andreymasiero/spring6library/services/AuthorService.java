package com.andreymasiero.spring6library.services;

import com.andreymasiero.spring6library.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
