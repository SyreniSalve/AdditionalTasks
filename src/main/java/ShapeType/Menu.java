package ShapeType;

import lombok.Getter;
import lombok.Setter;


import java.util.Scanner;

import static ShapeType.ShapeType.*;
import static ShapeType.ShapeType.SQUARE_WITH_ALL_DIFFERENT_SIDES;

@Getter
@Setter
public class Menu {
    private boolean exit;
    private int equilateralTriangleCounter;
    private int scaleneTriangleCounter;
    private int isoscelesTriangleCounter;
    private int squareCounter;
    private int rectangleCounter;
    private int trapeziumCounter;
    private int kiteCounter;
    private int squareWithAllDifferentSidesCounter;

    private void printHeader(){
        System.out.println("_______________________________________");
        System.out.println("|           Welcome to our            |");
        System.out.println("|          Menu Application!          |");
        System.out.println("_______________________________________");
    }

    private void printMenu(){
        System.out.println("\nPlease make a shape selection:");
        System.out.println("1) - triangles.");
        System.out.println("2) - quadrilaterals.");
        System.out.println("3) - exit the application.\n");
    }

    public void runMenu(){
        printHeader();
        while (!exit){
            printMenu();
            int choice = getInput();
            performAction(choice);
        }
    }
    private int getInput(){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while(choice <= 0 || choice > 3) {
            System.out.print("Enter your selection: ");
            choice = Integer.parseInt(scanner.nextLine());
            if (choice <= 0 || choice > 3){
                System.out.println("Invalid selection. Please try again.\n");
            }
        }
        return choice;
    }

    private void performAction(int choice){
        switch (choice){
            case 1:
                Triangle triangle = new Triangle();
                triangle.sidesInput();
                triangleCounter(triangle);
                break;
            case 2:
                Quadrilateral quadrilateral = new Quadrilateral();
                quadrilateral.sidesInput();
                quadrilateralCounter(quadrilateral);
                break;
            case 3:
                exit = true;
                System.out.println(getTheNumberOfTrianglesOfEachType());
                System.out.println(getTheNumberOfQuadrilateralOfEachType());
                System.out.println("\nThank you for using our application.");
                break;
            default:
                System.out.println("An unknown error has occurred");
        }
    }
    public void triangleCounter(Triangle triangle) {
        System.out.print("\nShape form is: ");
        if (triangle.getShapeType().equals(EQUILATERAL_TRIANGLE)){
            equilateralTriangleCounter += 1;
            System.out.print(EQUILATERAL_TRIANGLE + "\n");
        } else if (triangle.getShapeType().equals(SCALENE_TRIANGLE)){
            scaleneTriangleCounter += 1;
            System.out.print(SCALENE_TRIANGLE + "\n");
        } else if (triangle.getShapeType().equals(ISOSCELES_TRIANGLE)){
            isoscelesTriangleCounter += 1;
            System.out.println(ISOSCELES_TRIANGLE + "\n");
        } else {
            System.out.println("It's not a triangle.");

        }
    }
    public void quadrilateralCounter(Quadrilateral quadrilateral) {
        System.out.print("\nShape form is: ");
        if (quadrilateral.getShapeType().equals(SQUARE)){
            squareCounter += 1;
            System.out.print(SQUARE + "\n");
        } else if (quadrilateral.getShapeType().equals(RECTANGLE)){
            rectangleCounter += 1;
            System.out.print(RECTANGLE + "\n");
        } else if (quadrilateral.getShapeType().equals(TRAPEZIUM)){
            trapeziumCounter += 1;
            System.out.println(TRAPEZIUM + "\n");
        } else if (quadrilateral.getShapeType().equals(KITE)){
            kiteCounter += 1;
            System.out.println(KITE + "\n");
        } else if (quadrilateral.getShapeType().equals(SQUARE_WITH_ALL_DIFFERENT_SIDES)){
            squareWithAllDifferentSidesCounter += 1;
            System.out.println(SQUARE_WITH_ALL_DIFFERENT_SIDES + "\n");
        } else {
            System.out.println("It's not a quadrilateral.");
        }
    }
    public String getTheNumberOfTrianglesOfEachType(){
        return "\nCreated triangles: \n" +
                EQUILATERAL_TRIANGLE + " - " + equilateralTriangleCounter + ".\n" +
                ISOSCELES_TRIANGLE + " - " + isoscelesTriangleCounter + ".\n" +
                SCALENE_TRIANGLE + " - " + scaleneTriangleCounter + ".";
    }
    public String getTheNumberOfQuadrilateralOfEachType(){
        return "\nCreated quadrilateral: \n" +
                SQUARE + " - " + squareCounter + ".\n" +
                RECTANGLE + " - " + rectangleCounter + ".\n" +
                TRAPEZIUM + " - " + trapeziumCounter + ".\n" +
                KITE + " - " + kiteCounter + ".\n" +
                SQUARE_WITH_ALL_DIFFERENT_SIDES + " - " + squareWithAllDifferentSidesCounter + ".";
    }
}
