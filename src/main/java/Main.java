import Dijkstra.BotPath;
import com.google.common.graph.ValueGraph;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        if(args==null || args.length<2){
            System.out.println("You must pass 2 arguments: gridFile and jobFile");
            return;
        }

        File gridFile = new File(args[0]);
        File jobFile = new File(args[1]);

        GridLoader gridLoader = new GridLoader(gridFile);
        JobLoader jobLoader = new JobLoader(jobFile);

        Grid grid = gridLoader.readGridFromInputFile();
        Job job = jobLoader.readJobFromInputFile();

        ValueGraph<String, Double> graph = GraphFromGrid.createGraph(grid);
        BotPath result = BotRoutePlanner.BotRoutePlanner(grid, job, graph);
        System.out.println(result.toString());
    }
}
