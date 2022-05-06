import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GridLoader {

    private File gridFile;
    private int gridSizeX;
    private int gridSizeY;
    private int gridSizeN;
    private char[][] moduleTypes;
    private ArrayList<Product> productsOnGrid = new ArrayList<>();

    public GridLoader(File gridFile) {
        this.gridFile = gridFile;
    }

    public Grid readGridFromInputFile() throws FileNotFoundException {

        Scanner scanner = new Scanner(gridFile);
        int lineNumber=0;
        String line;

        while(scanner.hasNext()){
            line = scanner.nextLine();
            lineNumber++;

            if(lineNumber==1) {
                loadGridSize(line);
                createArrayWithModulesTypesInGridSize();
            }
            if(lineNumber>1 && lineNumber<=gridSizeY+1){
                loadTypesOfModules(lineNumber, line);
            }
            if(lineNumber>gridSizeY+1){
                loadProductsOnGrid(line);
            }
        }
        return new Grid(gridSizeX,gridSizeY,gridSizeN,moduleTypes,productsOnGrid);
    }

    private void loadProductsOnGrid(String line) {
        String[] productWithLocation = line.split(" ");
        String name = productWithLocation[0];
        int x = Integer.parseInt(productWithLocation[1]);
        int y = Integer.parseInt(productWithLocation[2]);
        int n = Integer.parseInt(productWithLocation[3]);
        productsOnGrid.add(new Product(name, x, y, n));
    }

    private void loadTypesOfModules(int lineNumber, String line) {
        int yPosOnGrid = lineNumber -2;
        char[] charArray = line.toCharArray();
        for (int xPosOnGrid = 0; xPosOnGrid < charArray.length; xPosOnGrid++) {
            moduleTypes[yPosOnGrid][xPosOnGrid] = charArray[xPosOnGrid];
        }
    }

    private void createArrayWithModulesTypesInGridSize() {
        moduleTypes = new char[gridSizeY][gridSizeX];
    }

    private void loadGridSize(String line) {
        String[] gridSize = line.split(" ");
        gridSizeX = Integer.parseInt(gridSize[0]);
        gridSizeY = Integer.parseInt(gridSize[1]);
        gridSizeN = Integer.parseInt(gridSize[2]);
    }
}
