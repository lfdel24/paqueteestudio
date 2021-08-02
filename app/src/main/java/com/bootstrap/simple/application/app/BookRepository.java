package com.bootstrap.simple.application.app;

import com.bootstrap.simple.application.app.persistence.model.Book;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author leo
 */
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByTitle(String title);

}
