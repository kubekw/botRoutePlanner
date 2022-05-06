public class Job {

    private int botStartX;
    private int botStartY;
    private int botFinishX;
    private int botFinishY;
    private String productName;

    public Job(int botStartX, int botStartY, int botFinishX, int botFinishY, String productName) {
        this.botStartX = botStartX;
        this.botStartY = botStartY;
        this.botFinishX = botFinishX;
        this.botFinishY = botFinishY;
        this.productName = productName;
    }

    public int getBotStartX() {
        return botStartX;
    }

    public int getBotStartY() {
        return botStartY;
    }

    public int getBotFinishX() {
        return botFinishX;
    }

    public int getBotFinishY() {
        return botFinishY;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return "Job{" +
                "botStartX=" + botStartX +
                ", botStartY=" + botStartY +
                ", botFinishX=" + botFinishX +
                ", botFinishY=" + botFinishY +
                ", productName='" + productName + '\'' +
                '}';
    }
}
