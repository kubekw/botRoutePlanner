import com.google.common.graph.ValueGraph;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //TODO Argumenty Metody main

        File gridFile = new File("grid-2.txt");
        File jobFile = new File("job-2.txt");

        GridLoader gridLoader = new GridLoader(gridFile);
        JobLoader jobLoader = new JobLoader(jobFile);

        Grid grid = gridLoader.readGridFromInputFile();
        Job job = jobLoader.readJobFromInputFile();

        ValueGraph<String, Double> graph = GraphFromGrid.createGraph(grid);
        BotRoutePlanner.BotRoutePlanner(grid, job, graph);

        //TODO testy implemantacji klasy Module
    }
}
