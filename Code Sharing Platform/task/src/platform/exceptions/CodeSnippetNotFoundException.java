package platform.exceptions;

public class CodeSnippetNotFoundException extends Exception{
    public CodeSnippetNotFoundException(Long id) {
        super("Code snippet with this ID was not found: " + id);
    }
}
