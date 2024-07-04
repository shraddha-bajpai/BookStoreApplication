package firstproject.service;
import firstproject.domain.Book;

import java.util.List;
public interface BookService {
    List<Book> getallbooks();
    Book getbookbyid(Long id);
    List<Book> searchbytitle(String title);
    Book updatebook(Long id, Book book);
    void deletebook(Long id);
    Book addbook(Book book);
}
