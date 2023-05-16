package models.bibles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String id;
    private String name;
    private String shortName;
    private String bibleId;
    private Integer bookNumber;
    private List<Verse> verses;

}
