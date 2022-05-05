import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File gridFile = new File("grid-1.txt");
        File jobFile = new File("job-1.txt");

        GridLoader gridLoader = new GridLoader(gridFile);
        gridLoader.readInputFile();

        JobLoader jobLoader = new JobLoader(jobFile);
        jobLoader.readJobFile();



    }
}
