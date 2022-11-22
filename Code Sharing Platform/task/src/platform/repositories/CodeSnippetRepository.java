package platform.repositories;

import org.springframework.data.repository.CrudRepository;
import platform.entities.CodeSnippet;

public interface CodeSnippetRepository extends CrudRepository<CodeSnippet, Long> {

}
