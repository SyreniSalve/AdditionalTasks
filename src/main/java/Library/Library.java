package Library;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Library {
    private List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public static String getAuthorsBookNumberAndAverageNumberOfPages(List<Book> library, String author) {
        int countBooks = 0;
        int countPages = 0;
        for (Book book : library) {
            if (book.getAuthor().equals(author)) {
                countBooks += 1;
                countPages += book.getPageNumber();
            }
        }
        return "We have " + countBooks + " " + author + " books, witch average page number is: " + (countPages / countBooks) + ".";
    }

    public static String getBookByAuthorAndBookCode(List<Book> library, String author, String bookCode) {
        String bookResult = "";
        for (Book book : library) {
            if (book.getAuthor().equals(author) && book.getBookCode().equals(bookCode)) {
                bookResult = (book.getTitle());
            }
        }
        if (bookResult.equals("")){
            return "Book not found.";
        } else {
            return bookResult;
        }
    }

    public static String getBookByAuthorBookCodePublishingHouseAndYearsOfRelease(List<Book> library, String author, String bookCode, String publishingHouse, int yearsOfRelease) {
        String bookResult = "";
        for (Book book : library){
            if (book.getAuthor().equals(author) && book.getBookCode().equals(bookCode) && book.getPublishingHouse().equals(publishingHouse) && book.getYearsOfRelease() == yearsOfRelease){
                bookResult = book.getTitle();
            }
        }
        if (bookResult.equals("")){
            return "Book not found.";
        } else {
            return bookResult;
        }
    }
    public static List<String> getAuthorsAndYearsOfReleaseListByPublishingHouse(List<Book> library, String publishingHouse){
        List<String> authorsAndYearsOfReleaseList = new ArrayList<>();
        for (Book book : library){
            if (book.getPublishingHouse().equals(publishingHouse)){
                authorsAndYearsOfReleaseList.add(book.getAuthor() + " - " + book.getYearsOfRelease());
            }
        }
        return authorsAndYearsOfReleaseList;
    }
}