package Computer;

import java.util.Arrays;
import java.util.List;

import static Computer.Computer.*;

public class Main {
    public static void main(String[] args) {
        List<Computer> computerList = Arrays.asList(
                new Computer("KLK555", "Computer World",500,1.5,2),
                new Computer("KLK556","Computer World",999.99,2,2),
                new Computer("KLK557","Computer World", 1200,1.8,2),
                new Computer("KLK558","Technics",459.86,3,1),
                new Computer("KLK559","Technics",856.99,2.4,2),
                new Computer("KLK560","Paradise",400,2.8,1)
        );
        System.out.println(getManufacturerComputersQuantityAndAveragePrice(computerList,"Computer World"));
//        System.out.println(getManufacturerComputersQuantityAndAveragePrice(computerList, "Parma"));
        System.out.println("__________________________________________________________");
        System.out.println(getComputerByItemCodeAndByManufacturer(computerList,"KLK555","Computer World"));
//        System.out.println(getComputerByItemCodeAndByManufacturer(computerList,"ihont","Para"));
        System.out.println("___________________________________________________________");
        System.out.println(getComputerByItemCodeByManufacturerByPriceAndByWarranty(computerList,"KLK556","Computer World", 999.99, 2));
        System.out.println("___________________________________________________________");
        System.out.println(getItemsListByManufacturer(computerList, "Technics"));

    }
}
