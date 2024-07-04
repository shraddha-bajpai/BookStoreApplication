package firstproject.service;
import firstproject.domain.BookRepository;
import firstproject.domain.Book;
import firstproject.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements  BookService {

    private final BookRepository bookrepo;

    @Autowired
    public BookServiceImpl(BookRepository bookrepo)
    {
        this.bookrepo   = bookrepo;
    }

    @Override
    public List<Book>getallbooks()
    {
        return bookrepo.findAll();
    }
    @Override
    public Book addbook(Book book) {
        return bookrepo.save(book);  // Implement the addbook method
    }

    @Override
    public Book getbookbyid(Long id)
    {
        Optional<Book>optionalbook = bookrepo.findById(id);
        return optionalbook.orElse(null);
    }

    @Override
    public List<Book>searchbytitle(String title)
    {
        return  bookrepo.findByTitleIgnoreCase(title);
    }

    @Override
    public Book updatebook(Long id, Book book)
    {
        if(bookrepo.existsById(id))
        {
            book.setId(id);
            return bookrepo.save(book);
        }
        return null;
    }

    @Override
    public void deletebook(Long id)
    {
        bookrepo.deleteById(id);
    }

}
