package jp.te4a.spring.boot.myapp9.mybootapp9;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface BookRepository extends JpaRepository<BookBean, Integer>{

    @Query("SELECT X FROM BookBean X ORDER BY X.title")
    List<BookBean> findAllOrderByTitle();

    /*
    private final ConcurrentMap<Integer, BookBean> bookMap = new ConcurrentHashMap<>();
    private int BOOK_ID = 1;
    public int getBookId() {
        return BOOK_ID++;
    }

    public default void delete(Integer bookId) {
        bookMap.remove(bookId);
    }
    public default List<BookBean> findAll() {
        return new ArrayList<>(bookMap.values());
    }
    public default BookBean findOne(Integer id) {
        return bookMap.get(id);
    }
    */
}
