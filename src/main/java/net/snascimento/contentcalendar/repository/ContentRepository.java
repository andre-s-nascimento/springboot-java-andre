package net.snascimento.contentcalendar.repository;

import java.util.List;
import net.snascimento.contentcalendar.model.Content;
import net.snascimento.contentcalendar.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {

  List<Content> findAllByTitleContains(String keyword);

  @Query("""
      SELECT * FROM Content
      WHERE status = :status
  """)
  List<Content> listByStatus(@Param("status") Status status);
}
