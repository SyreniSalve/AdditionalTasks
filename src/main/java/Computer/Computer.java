package Computer;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Computer {
    private String itemCode;
    private String manufacturer;
    private double price;
    private double weight;
    private int warrantyByYears;

    public Computer(String itemCode, String manufacturer, double price, double weight, int warrantyByYears) {
        this.itemCode = itemCode;
        this.manufacturer = manufacturer;
        this.price = price;
        this.weight = weight;
        this.warrantyByYears = warrantyByYears;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "itemCode='" + itemCode + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", warrantyByYears=" + warrantyByYears +
                '}';
    }

    public static String getManufacturerComputersQuantityAndAveragePrice(List<Computer> computerList, String manufacturer){
        int countComputersQuantity = 0;
        int averagePrice = 0;
        for (Computer computer : computerList){
            if (computer.getManufacturer().equals(manufacturer)){
                countComputersQuantity += 1;
                averagePrice += computer.getPrice();
            }
        }
        if (countComputersQuantity == 0 && averagePrice == 0){
            throw new ComputerException("We don't have computers from this manufacturer.");
        } else {
            return "Manufacturer: " + manufacturer + ", computers quantity: " + countComputersQuantity + ", average computers price: " + (averagePrice / countComputersQuantity) + " Eur.";
        }
    }

    public static Computer getComputerByItemCodeAndByManufacturer(List<Computer> computerList, String itemCode, String manufacturer){
        Computer requiredComputer = null;
        for (Computer computer : computerList){
            if (computer.getItemCode().equals(itemCode) && computer.getManufacturer().equals(manufacturer)){
                requiredComputer = computer;
            }
        }
        if (requiredComputer == null){
            throw new ComputerException("We can't find this computer in our system.");
        }
        return requiredComputer;
    }
    public static Computer getComputerByItemCodeByManufacturerByPriceAndByWarranty(List<Computer> computerList, String itemCode, String manufacturer, double price, int warrantyByYears) {
        Computer requiredComputer = null;
        for (Computer computer : computerList) {
            if (computer.getItemCode().equals(itemCode) && computer.getManufacturer().equals(manufacturer) && computer.getPrice() == price && computer.getWarrantyByYears() == warrantyByYears) {
                requiredComputer = computer;
            }
        }
        if (requiredComputer == null) {
            throw new ComputerException("We can't find this computer in our system.");
        }
        return requiredComputer;
    }
    public static List<Computer> getItemsListByManufacturer(List<Computer> computerList, String manufacturer){
        List<Computer> computers = new ArrayList<>();
        for (Computer computer : computerList){
            if (computer.getManufacturer().equals(manufacturer)){
                computers.add(computer);
            }
        }
        return computers;
    }
}
