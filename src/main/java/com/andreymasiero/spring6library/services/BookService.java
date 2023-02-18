package com.andreymasiero.spring6library.services;

import com.andreymasiero.spring6library.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
