package Library;

import java.util.Arrays;
import java.util.List;

import static Library.Library.getBookByAuthorAndBookCode;
import static Library.Library.getAuthorsBookNumberAndAverageNumberOfPages;
import static Library.Library.getBookByAuthorBookCodePublishingHouseAndYearsOfRelease;
import static Library.Library.getAuthorsAndYearsOfReleaseListByPublishingHouse;
public class Main {
    public static void main(String[] args) {
        List<Book> library = Arrays.asList(
                new Book("Levas Tolstojus", "Anna Karenina", 1990,"KL525","Auras",1000),
                new Book("Levas Tolstojus", "Karas ir Taika",1995, "KL496","Obuolys",2000),
                new Book("Šarlota Bronte", "Džeinė Eir",2000,"KL897","Obuolys",800),
                new Book("Džoana Rouling","Haris Poteris ir išminties akmuo",2020, "KL474","Varpas",200),
                new Book("Džoana Rouling", "Haris Poter ir paslapčių kambarys",2020,"KL475","Varpas",300),
                new Book("Džoana Rouling", "Haris Poteris ir Azkabano kalinys",2020,"KL476","Varpas",350),
                new Book("Džoana Rouling", "Haris Poteris ir ugnies taurė",2020,"KL477","Varpas",400),
                new Book("Džoana Rouling", "Haris Poteris ir fenikso brolija",2020,"KL478","Varpas",500),
                new Book("Džoana Rouling", "Haris Poteris ir purvakraujis princas",2020,"KL479","Varpas",450),
                new Book("Džoana Rouling", "Haris Poteris ir mirteis relikvijos",2020,"KL450","Varpas",600));

        System.out.println(getBookByAuthorAndBookCode(library, "Levas Tolstojus","KL525"));
        System.out.println(getAuthorsBookNumberAndAverageNumberOfPages(library,"Levas Tolstojus"));
        System.out.println(getAuthorsBookNumberAndAverageNumberOfPages(library, "Džoana Rouling"));
        System.out.println(getBookByAuthorBookCodePublishingHouseAndYearsOfRelease(library,"Šarlota Bronte","KL897","Obuolys",2000));
        System.out.println(getAuthorsAndYearsOfReleaseListByPublishingHouse(library, "Obuolys"));
        System.out.println(getAuthorsAndYearsOfReleaseListByPublishingHouse(library, "Varpas"));
    }
}
