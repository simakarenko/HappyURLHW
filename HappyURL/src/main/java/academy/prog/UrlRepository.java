package academy.prog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface UrlRepository extends JpaRepository<UrlRecord, Long> {
    UrlRecord findByUrl(String url);

    UrlRecord deleteById(long id);//TODO: пошук URL за id

    @Query("SELECT c FROM UrlRecord c WHERE c.lastAccess < :runtime")//TODO: вибірка застарілиз url
    List<UrlRecord> findUrlToDelete(@Param("runtime") Date runtime);
}
