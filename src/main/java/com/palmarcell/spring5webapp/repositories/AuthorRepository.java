package com.palmarcell.spring5webapp.repositories;

import com.palmarcell.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by gemboly on 2018. 06. 12., 2018
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {



}
