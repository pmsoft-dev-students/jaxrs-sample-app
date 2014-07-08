package ru.pmsoft.jaxrssampleapp;

import com.google.common.collect.Sets;
import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import ru.pmsoft.jaxrssampleapp.dataaccess.InMemoryBookRepository;
import ru.pmsoft.jaxrssampleapp.domain.Book;
import ru.pmsoft.jaxrssampleapp.domain.BookRepository;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@ApplicationPath("rest")
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                Book warAndPeace = new Book(UUID.randomUUID());
                warAndPeace.setTitle("War and Peace");
                warAndPeace.setAuthor("Leo Tolstoy");
                warAndPeace.setDateAdded(new Date());
                bind(InMemoryBookRepository.class).to(BookRepository.class).in(Singleton.class);
                bind(Sets.newHashSet(warAndPeace)).to(new TypeLiteral<Collection<Book>>() {}).named("baseCollection");
            }
        });
        packages(true, "ru.pmsoft.jaxrssampleapp");
    }
}
