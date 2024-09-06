import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class DataMatrix {

    public DataMatrix() {}

    private int line;


    public int Matrixline(String filepath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filepath));
        int piece = 0;
        while (scanner.hasNextLine()) {
            piece++;
            scanner.nextLine();
        }
        this.line = piece;
        scanner.close();
        return line;
    }


    public String[][] Matrix(String filepath) throws FileNotFoundException {
        Matrixline(filepath);
        Scanner scanner = new Scanner(new File(filepath));
        String[][] matrix = new String[line][5];
        int i = 0;

        while (scanner.hasNextLine() && i < line) {
            String line = scanner.nextLine();
            String[] elements = line.split("\\s+");
            for (int j = 0; j < 5; j++) {
                if (j < elements.length) {
                    matrix[i][j] = elements[j];
                } else {
                    matrix[i][j] = "";
                }
            }
            i++;
        }
        scanner.close();
        return matrix;
    }
}
