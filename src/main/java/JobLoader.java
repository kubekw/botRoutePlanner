import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class JobLoader {

    private File jobFile;

    static int botStartX;
    static int botStartY;
    static int botFinishX;
    static int botFinishY;
    static String productName;

    public JobLoader(File jobFile) {
        this.jobFile = jobFile;
    }

    public void readJobFile() throws FileNotFoundException {

        Scanner scanner = new Scanner(jobFile);

        int lineNumber=0;
        String line;

        while(scanner.hasNext()){
            line = scanner.nextLine();
            lineNumber++;

            System.out.println(line);

            if(lineNumber==1) {
                String[] botStartPosition = line.split(" ");
                botStartX = Integer.parseInt(botStartPosition[0]);
                botStartY = Integer.parseInt(botStartPosition[1]);
            }

            if(lineNumber==2) {
                String[] botFinishPosition = line.split(" ");
                botFinishX = Integer.parseInt(botFinishPosition[0]);
                botFinishY = Integer.parseInt(botFinishPosition[1]);
            }

            if(lineNumber==3) {
                productName = line;
            }
        }


        //TESTY
        System.out.println("Bot start position: "+ botStartX+" "+ botStartY);
        System.out.println("Bot finish position: "+ botFinishX+" "+ botFinishY);
        System.out.println("Product to pickUp: "+ productName);

    }

}
