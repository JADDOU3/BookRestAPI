package com.example.demo.Service;

import com.example.demo.Entity.Book;
import com.example.demo.Repository.BookRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class BookService {
    private final BookRepo repo;

    public List<Book> getAllBooks(){
       return repo.findAll();
    }

    public Book getBookById(long id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Book Not Found!"));
    }

    public Book saveBook(Book book){
        return repo.save(book);
    }


}
