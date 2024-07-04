package firstproject;
import firstproject.domain.Book;
import firstproject.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class dataInitializer {

    @Autowired
    private BookRepository bookrepo;


    @Bean
    public CommandLineRunner loadData()
    {
        return args->{
            bookrepo.save(new Book("Author1", "Title1", "ISBN1", 9.99));
             bookrepo.save(new Book("Author2", "Title2", "ISBN2", 19.99));
            bookrepo.save(new Book("Author3", "Title3", "ISBN3", 29.99));
        };
    }
}
