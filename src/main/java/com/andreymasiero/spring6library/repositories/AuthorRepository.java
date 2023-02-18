package com.andreymasiero.spring6library.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.andreymasiero.spring6library.domain.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
