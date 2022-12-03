package platform.repositories;

import org.springframework.data.repository.CrudRepository;
import platform.entities.CodeSnippet;

import java.util.List;

public interface CodeSnippetRepository extends CrudRepository<CodeSnippet, Long> {
    List<CodeSnippet> getCodeSnippetsByIdGreaterThanOrderByIdDesc(Long id);
}
