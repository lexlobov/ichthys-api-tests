package models.bibles;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
public class Book {
    private String id;
    private String name;
    private String shortName;
    private String bibleId;
    private int bookNumber;
    private List<Verse> verses;

}
