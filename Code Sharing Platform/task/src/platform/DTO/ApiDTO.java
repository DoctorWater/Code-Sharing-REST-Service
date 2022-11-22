package platform.DTO;

import java.time.LocalDate;

public class ApiDTO {
    private final String id;

    public ApiDTO(Long id) {
        this.id = id.toString();
    }

    public String getid() {
        return id;
    }
}
