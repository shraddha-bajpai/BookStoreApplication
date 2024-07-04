package firstproject.domain;


//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;


//@ComponentScan(basePackages = {"firstproject.domain"})

@RestController
@RequestMapping("/books")
//@Api(value = "Book management system")
public class BookController {
    private final BookRepository bookrepo;

    @Autowired
    public BookController(BookRepository bookrepo) {
        this.bookrepo = bookrepo;
    }


    //endpoints
    //get lists of all books
    @GetMapping
//    @ApiOperation(value = "view a list",response  = List.class)
    public ResponseEntity<List<Book>> getallbooks() {
        List<Book> books = bookrepo.findAll();
        return ResponseEntity.ok(books);
    }


    @GetMapping("/{id}")
//     @ApiOperation(value = "get a book by id")
    public ResponseEntity<Book> getbookbyid(@PathVariable Long id) {
        Optional<Book> optionalbook = bookrepo.findById(id);

        if (optionalbook.isPresent()) {
            return ResponseEntity.ok(optionalbook.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/search")
//    @ApiOperation(value = "Search book by title")
    public ResponseEntity<List<Book>> searchbytitle(@RequestParam String title) {
        List<Book> books = bookrepo.findByTitleIgnoreCase(title);
        return ResponseEntity.ok(books);
    }


    //add book
    @PostMapping
//    @ApiOperation(value="Add a new book")
    public ResponseEntity<Book> addbook(@RequestBody Book book) {
        Book newbook = bookrepo.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(newbook);

    }

    //update the existing book
    @PutMapping("/{id}")
//    @ApiOperation(value = "update the book")
    public ResponseEntity<Book> updatebook(@PathVariable Long id, @RequestBody Book book) {
        if (bookrepo.existsById(id)) {
            book.setId(id);
            Book updatedbook = bookrepo.save(book);
            return ResponseEntity.ok(updatedbook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //delete book by id
    @DeleteMapping("/{id}")
//    @ApiOperation(value = "Delete any book")
    public ResponseEntity<Void> deletebook(@PathVariable Long id) {
        bookrepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
