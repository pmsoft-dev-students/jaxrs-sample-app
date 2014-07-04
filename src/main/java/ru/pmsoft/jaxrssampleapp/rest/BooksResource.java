package ru.pmsoft.jaxrssampleapp.rest;

import ru.pmsoft.jaxrssampleapp.domain.Book;
import ru.pmsoft.jaxrssampleapp.domain.BookRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("books")
public class BooksResource {

    private final BookRepository _repository;

    @Inject
    public BooksResource(BookRepository repository){
        if (repository == null)
            throw new IllegalArgumentException("Parameter 'repository' can't be null");

        _repository = repository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Book> getAll() {
        return _repository.getAll();
    }
}
