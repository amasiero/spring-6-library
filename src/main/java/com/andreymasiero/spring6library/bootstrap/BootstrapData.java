package com.andreymasiero.spring6library.bootstrap;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.andreymasiero.spring6library.domain.Author;
import com.andreymasiero.spring6library.domain.Book;
import com.andreymasiero.spring6library.domain.Publisher;
import com.andreymasiero.spring6library.repositories.AuthorRepository;
import com.andreymasiero.spring6library.repositories.BookRepository;
import com.andreymasiero.spring6library.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @Autowired
    public BootstrapData(
            AuthorRepository authorRepository,
            BookRepository bookRepository,
            PublisherRepository publisherRepository
    ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn(String.valueOf(UUID.randomUUID()));

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEjb = new Book();
        noEjb.setTitle("J2EE Development without EJB");
        noEjb.setIsbn(String.valueOf(UUID.randomUUID()));

        Author rodSaved = authorRepository.save(rod);
        Book noEjbSaved = bookRepository.save(noEjb);

        ericSaved.getBooks().add(ddd);
        rodSaved.getBooks().add(noEjbSaved);
        dddSaved.getAuthors().add(ericSaved);
        noEjbSaved.getAuthors().add(rodSaved);

        Publisher publisher = new Publisher();
        publisher.setName("My Publisher");
        publisher.setAddress("123 Main");
        Publisher publisherSaved = publisherRepository.save(publisher);

        dddSaved.setPublisher(publisherSaved);
        noEjbSaved.setPublisher(publisherSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEjbSaved);

        System.out.println("In Bootstrap...");
        System.out.printf("Author Count: %d%n", authorRepository.count());
        System.out.printf("Book Count: %d%n", bookRepository.count());



        System.out.printf("Publisher Count: %d%n", publisherRepository.count());
    }
}
