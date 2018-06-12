package com.palmarcell.spring5webapp.bootstrap;

import com.palmarcell.spring5webapp.model.Author;
import com.palmarcell.spring5webapp.model.Book;
import com.palmarcell.spring5webapp.model.Publisher;
import com.palmarcell.spring5webapp.repositories.AuthorRepository;
import com.palmarcell.spring5webapp.repositories.BookRepository;
import com.palmarcell.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by gemboly on 2018. 06. 12., 2018
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData() {

        Publisher publisher = new Publisher();
        publisher.setName("Harper Collins");
        publisherRepository.save(publisher);

        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Publisher publisher2 = new Publisher();
        publisher2.setName("Worx");
        publisherRepository.save(publisher2);

        Author rod = new Author("Red","Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisher2);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);


    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
