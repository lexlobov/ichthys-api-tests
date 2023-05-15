package models.bibles;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
@Data
public class Bible {

    private String id;
    private String language;
    private String translation;
    private String description;
    private String createdAt;
    private String updatedAt;
    private Integer version;
    private List<Book> books;

}
