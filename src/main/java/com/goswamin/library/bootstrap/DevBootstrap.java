package com.goswamin.library.bootstrap;

import com.goswamin.library.model.Author;
import com.goswamin.library.model.Book;
import com.goswamin.library.model.Publisher;
import com.goswamin.library.repositories.AuthorRepository;
import com.goswamin.library.repositories.BookRepository;
import com.goswamin.library.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Author au=new Author("Gayle","Laakmann");
        Publisher p=new Publisher("6th edition","6th edition");
        publisherRepository.save(p);
        Book bk = new Book("Cracking the coding interview","23",p);
        au.getBooks().add(bk);
        bk.getAuthors().add(au);

        authorRepository.save(au);
        bookRepository.save(bk);


        Author au1=new Author("Kathy","Sierra");
        Publisher p1=new Publisher("4th edition","not available");
        publisherRepository.save(p1);
        Book bk1 = new Book("SCJP6","24",p1);
        au1.getBooks().add(bk1);
        bk1.getAuthors().add(au1);

        authorRepository.save(au1);
        bookRepository.save(bk1);

    }
}
