package com.palmarcell.spring5webapp.bootstrap;

import com.palmarcell.spring5webapp.model.Author;
import com.palmarcell.spring5webapp.model.Book;

/**
 * Created by gemboly on 2018. 06. 12., 2018
 */

public class DevBootstrap {

    private void initData() {

        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        Author rod = new Author("Red","Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", "Worx");
        rod.getBooks().add(noEJB);

    }
}
