package models.bibles;

import lombok.*;

@Data
@Builder
@EqualsAndHashCode(of = {"bookNumber", "chapterNumber", "verseNumber"})
@NoArgsConstructor
@AllArgsConstructor
public class Verse {
    private String id;
    private Integer bookNumber;
    private Integer chapterNumber;
    private Integer verseNumber;
    private String text;
    private String bookId;
    private Book book;
    private Float similarity;
}
