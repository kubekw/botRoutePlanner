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

    public void readInputFile() throws FileNotFoundException {

        Scanner scanner = new Scanner(gridFile);

        int lineNumber=0;
        String line;

        while(scanner.hasNext()){
            line = scanner.nextLine();
            lineNumber++;

            if(lineNumber==1) {
                String[] gridSize = line.split(" ");
                gridSizeX = Integer.parseInt(gridSize[0]);
                gridSizeY = Integer.parseInt(gridSize[1]);
                gridSizeN = Integer.parseInt(gridSize[2]);

                moduleTypes = new char[gridSizeY][gridSizeX];
            }

            if(lineNumber>1 && lineNumber<=gridSizeY+1){
                int yPosOnGrid = lineNumber-2;
                char[] charArray = line.toCharArray();
                for (int xPosOnGrid = 0; xPosOnGrid < charArray.length; xPosOnGrid++) {
                    moduleTypes[yPosOnGrid][xPosOnGrid] = charArray[xPosOnGrid];
                }
            }

            if(lineNumber>gridSizeY+1){
                String[] productWithLocation = line.split(" ");

                String name = productWithLocation[0];
                int x = Integer.parseInt(productWithLocation[1]);
                int y = Integer.parseInt(productWithLocation[2]);
                int n = Integer.parseInt(productWithLocation[3]);

                productsOnGrid.add(new Product(name, x, y, n));
            }
        }






        //TESTY
        System.out.println(gridSizeX);
        System.out.println(gridSizeY);
        System.out.println(gridSizeN);

        for (int i = 0; i < moduleTypes.length; i++) {
            for (int j = 0; j < moduleTypes[i].length; j++) {
                System.out.print(moduleTypes[i][j]);
            }
            System.out.println();
        }

        for (Product p:productsOnGrid){
            System.out.println(p.getName()+" "+p.getX()+" "+p.getY()+" "+p.getN());

        }
    }

    public int getGridSizeX() {
        return gridSizeX;
    }

    public int getGridSizeY() {
        return gridSizeY;
    }

    public int getGridSizeN() {
        return gridSizeN;
    }

    public char[][] getModuleTypes() {
        return moduleTypes;
    }

    public ArrayList<Product> getProductsOnGrid() {
        return productsOnGrid;
    }

}
