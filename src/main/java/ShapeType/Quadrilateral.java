package ShapeType;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static ShapeType.ShapeType.KITE;
import static ShapeType.ShapeType.NOT_QUADRILATERAL;
import static ShapeType.ShapeType.RECTANGLE;
import static ShapeType.ShapeType.SQUARE;
import static ShapeType.ShapeType.SQUARE_WITH_ALL_DIFFERENT_SIDES_OR_CONCAVE_SQUARE;
import static ShapeType.ShapeType.TRAPEZIUM;

@Setter
@Getter
public class Quadrilateral implements Imputed, Ascertainable {
    private float sideA;
    private float sideB;
    private float sideC;
    private float sideD;

    public Quadrilateral(){}

    @Override
    public void sidesInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPlease input side A: ");
        setSideA(scanner.nextFloat());
        System.out.print("Please input side B: ");
        setSideB(scanner.nextFloat());
        System.out.print("Please input side C: ");
        setSideC(scanner.nextFloat());
        System.out.print("Please input side D: ");
        setSideD(scanner.nextFloat());
    }

    public boolean isSquare(){
        return sideA == sideB &&  sideB == sideC && sideC == sideD && sideD == sideA;
    }

    public boolean isRectangle(){
        return sideA == sideC && sideB == sideD;
    }

    public boolean isTrapezium(){
        return  sideA < sideC && sideC > sideB && sideB > sideA && sideB == sideD || sideA > sideC && sideA > sideB && sideB > sideC && sideB == sideD ||
                sideB < sideD && sideD > sideA && sideA > sideB && sideA == sideC || sideB > sideD && sideB > sideA && sideA > sideD && sideA == sideC;
    }

    public boolean isKite(){
        return sideA == sideB && sideC == sideD || sideB == sideC && sideD == sideA;
    }

    public boolean isQuadrilateral(){
        float longest = sideA;
        float sumShorterSides = 0;
        List<Float> sides = Arrays.asList(sideA,sideB,sideC,sideD);
        for (float side : sides){
            if(longest < side){
                longest = side;
            }
        }
        for (float side : sides){
            if (longest > side) {
                sumShorterSides += side;
            }
        }
        return longest < sumShorterSides;
    }

    @Override
    public ShapeType getShapeType(){
        if (isSquare()) {
            return SQUARE;
        } else if (isRectangle()) {
            return RECTANGLE;
        } else if (isKite()){
            return KITE;
        } else {
            if (isQuadrilateral()) {
                if (isTrapezium()){
                    return TRAPEZIUM;
                }
                return SQUARE_WITH_ALL_DIFFERENT_SIDES_OR_CONCAVE_SQUARE;
            } else {
                return NOT_QUADRILATERAL;
            }
        }
    }
}
