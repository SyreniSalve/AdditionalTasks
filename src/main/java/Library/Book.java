package Library;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Book {
    private String author;
    private String title;
    private int yearsOfRelease;
    private String bookCode;
    private String publishingHouse;
    private int pageNumber;

    public Book(String author, String title, int yearsOfRelease, String bookCode, String publishingHouse, int pageNumber) {
        this.author = author;
        this.title = title;
        this.yearsOfRelease = yearsOfRelease;
        this.bookCode = bookCode;
        this.publishingHouse = publishingHouse;
        this.pageNumber = pageNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book library = (Book) o;

        if (yearsOfRelease != library.yearsOfRelease) return false;
        if (pageNumber != library.pageNumber) return false;
        if (!author.equals(library.author)) return false;
        if (!title.equals(library.title)) return false;
        if (!bookCode.equals(library.bookCode)) return false;
        return publishingHouse.equals(library.publishingHouse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, yearsOfRelease, bookCode, publishingHouse, pageNumber);
    }

    @Override
    public String toString() {
        return "Library{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", yearsOfRelease=" + yearsOfRelease +
                ", bookCode='" + bookCode + '\'' +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", pageNumber=" + pageNumber +
                '}';
    }
}
