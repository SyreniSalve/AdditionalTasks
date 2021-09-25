package ShapeType;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

import static ShapeType.ShapeType.EQUILATERAL_TRIANGLE;
import static ShapeType.ShapeType.ISOSCELES_TRIANGLE;
import static ShapeType.ShapeType.NOT_TRIANGLE;
import static ShapeType.ShapeType.SCALENE_TRIANGLE;

@Setter
@Getter
public class Triangle implements Imputed, Ascertainable {
    private float sideA;
    private float sideB;
    private float sideC;

    public Triangle() {
    }

    @Override
    public void sidesInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPlease input side A: ");
        setSideA(scanner.nextFloat());
        System.out.print("Please input side B: ");
        setSideB(scanner.nextFloat());
        System.out.print("Please input side C: ");
        setSideC(scanner.nextFloat());
    }

    public boolean isTriangle() {
        return sideA + sideB > sideC && sideA + sideC > sideB && sideC + sideB > sideA;
    }

    public boolean isEquilateralTriangle() {
        return sideA == sideB && sideB == sideC && sideC == sideA;
    }

    public boolean isScaleneTriangle() {
        return sideA != sideB && sideB != sideC && sideC != sideA;
    }

    @Override
    public ShapeType getShapeType() {
        if (isTriangle()) {
            if (isEquilateralTriangle()) {
                return EQUILATERAL_TRIANGLE;
            } else if (isScaleneTriangle()) {
                return SCALENE_TRIANGLE;
            } else {
                return ISOSCELES_TRIANGLE;
            }
        } else {
            return NOT_TRIANGLE;
        }
    }
}
