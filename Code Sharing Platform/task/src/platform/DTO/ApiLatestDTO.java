package platform.DTO;

import platform.entities.CodeSnippet;

import java.util.ArrayList;
import java.util.List;

public class ApiLatestDTO {
    List<CodeResponseDTO> snippets = new ArrayList<>();

    public ApiLatestDTO(List<CodeSnippet> snippets) {
        snippets.forEach(x-> {
            this.snippets.add(new CodeResponseDTO(x.getCode(), x.getDate()));
        });
    }

    public List<CodeResponseDTO> getSnippets() {
        return snippets;
    }
}
