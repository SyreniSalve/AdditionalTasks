package ShapeType;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static ShapeType.ShapeType.*;

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
        if (!isQuadrilateral()){
            return false;
        }
        return sideA != sideC && sideB == sideD || sideB != sideD && sideA == sideC;
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
        } else if (isTrapezium()){
            return TRAPEZIUM;
        } else if (isKite()){
            return KITE;
        } else {
            if (isQuadrilateral()) {
                return SQUARE_WITH_ALL_DIFFERENT_SIDES;
            } else {
                return NOT_QUADRILATERAL;
            }
        }
    }
}
