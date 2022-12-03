package platform.services;

import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import platform.entities.CodeSnippet;
import platform.exceptions.CodeSnippetNotFoundException;
import platform.repositories.CodeSnippetRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CodeSnippetService {
    final CodeSnippetRepository repository;

    public CodeSnippetService(CodeSnippetRepository repository) {
        this.repository = repository;
    }

    public CodeSnippet getCodeSnippetById(Long id) throws CodeSnippetNotFoundException {
        Optional<CodeSnippet> codeSnippet = repository.findById(id);
        if(codeSnippet.isPresent()){
            return codeSnippet.get();
        }
        throw new CodeSnippetNotFoundException(id);
    }

    public List<CodeSnippet> getAllCodeSnippets(){
        List<CodeSnippet> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result;
    }

    public void saveCodeSnippet(CodeSnippet codeSnippet){
        repository.save(codeSnippet);
    }

    public void deleteCodeSnippet(Long id){
        repository.deleteById(id);
    }

    public List<CodeSnippet> getLatest(){
        long numberOfSnippets = 10L;
        return repository.getCodeSnippetsByIdGreaterThanOrderByIdDesc(repository.count()-numberOfSnippets-1);
    }

    @Bean("nextSnippetId")
    public Long getLastID(){
        return repository.count();
    }
}
