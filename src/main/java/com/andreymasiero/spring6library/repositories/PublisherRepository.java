package com.andreymasiero.spring6library.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.andreymasiero.spring6library.domain.Publisher;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
