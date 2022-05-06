import java.util.ArrayList;

public class Grid {

    private int gridSizeX;
    private int gridSizeY;
    private int gridSizeN;
    private Module[][] gridOfModules;
    private ArrayList<Product> productsOnGrid;

    public Grid(int gridSizeX, int gridSizeY, int gridSizeN, char[][] moduleTypes, ArrayList<Product> productsOnGrid) {
        this.gridSizeX = gridSizeX;
        this.gridSizeY = gridSizeY;
        this.gridSizeN = gridSizeN;
        this.gridOfModules = new Module[moduleTypes.length][moduleTypes[0].length];
        for (int i = 0; i < moduleTypes.length; i++) {
            for (int j = 0; j < moduleTypes[i].length; j++) {
                gridOfModules[i][j] = new Module(moduleTypes[i][j]);
            }
        }
        this.productsOnGrid = productsOnGrid;
        setProductsAccessTime();
    }

    private void setProductsAccessTime(){
        for (Product p : productsOnGrid){
            p.setAccssTime(gridOfModules[p.getY()][p.getX()].getPickUpTime(p.getN()));
        }

        //TEST
        for (Product p: productsOnGrid){
            System.out.println(p.getName()+" x:"+ p.getX()+" "+p.getY()+" "+p.getN()+" access time: "+p.getAccssTime());
        }
    }

    public int getGridSizeX() {
        return gridSizeX;
    }

    public void setGridSizeX(int gridSizeX) {
        this.gridSizeX = gridSizeX;
    }

    public int getGridSizeY() {
        return gridSizeY;
    }

    public void setGridSizeY(int gridSizeY) {
        this.gridSizeY = gridSizeY;
    }

    public int getGridSizeN() {
        return gridSizeN;
    }

    public void setGridSizeN(int gridSizeN) {
        this.gridSizeN = gridSizeN;
    }

    public Module[][] getGridOfModules() {
        return gridOfModules;
    }

    public void setGridOfModules(Module[][] gridOfModules) {
        this.gridOfModules = gridOfModules;
    }

    public ArrayList<Product> getProductsOnGrid() {
        return productsOnGrid;
    }

    public void setProductsOnGrid(ArrayList<Product> productsOnGrid) {
        this.productsOnGrid = productsOnGrid;
    }
}
