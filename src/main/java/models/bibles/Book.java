package models.bibles;

import java.util.List;

public class Book {
    private String id;
    private String name;
    private String shortName;
    private String bibleId;
    private int bookNumber;

    private List<Verse> verses;

    public List<Verse> getVerses() {
        return verses;
    }

    public void setVerses(List<Verse> verses) {
        this.verses = verses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getBibleId() {
        return bibleId;
    }

    public void setBibleId(String bibleId) {
        this.bibleId = bibleId;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }
}
