package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author otto = new Author("Otto", "Ottosen");
        Book aBook = new Book("aBook", "12345");
        otto.getBooks().add(aBook);
        aBook.getAuthors().add(otto);

        authorRepository.save(otto);
        bookRepository.save(aBook);

        Author heinz = new Author("Heinz", "Heinzsen");
        Book bBook = new Book("bBook", "54321");
        heinz.getBooks().add(bBook);
        bBook.getAuthors().add(heinz);

        authorRepository.save(heinz);
        bookRepository.save(bBook);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());

        Publisher antonPublisher = new Publisher("Anton", "Street 1", "Onetown", "Bla", "134245");

        publisherRepository.save(antonPublisher);
        System.out.println("Number of publishers: " + publisherRepository.count());

    }
}
