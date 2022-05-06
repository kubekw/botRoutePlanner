import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JobLoader {

    private File jobFile;
    private int botStartX;
    private int botStartY;
    private int botFinishX;
    private int botFinishY;
    private String productName;

    public JobLoader(File jobFile) {
        this.jobFile = jobFile;
    }

    public Job readJobFromInputFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(jobFile);
        int lineNumber = 0;
        String line;

        while (scanner.hasNext()) {
            line = scanner.nextLine();
            lineNumber++;
            if (lineNumber == 1) {
                String[] botStartPosition = line.split(" ");
                botStartX = Integer.parseInt(botStartPosition[0]);
                botStartY = Integer.parseInt(botStartPosition[1]);
            }

            if (lineNumber == 2) {
                String[] botFinishPosition = line.split(" ");
                botFinishX = Integer.parseInt(botFinishPosition[0]);
                botFinishY = Integer.parseInt(botFinishPosition[1]);
            }

            if (lineNumber == 3) {
                productName = line;
            }
        }
        return new Job(botStartX, botStartY,botFinishX,botFinishY,productName);
    }
}
