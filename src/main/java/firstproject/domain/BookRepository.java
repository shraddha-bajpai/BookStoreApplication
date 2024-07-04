package firstproject.domain;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>{
    List<Book> findByTitleIgnoreCase(String title);


}
