import com.google.common.graph.ValueGraph;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File gridFile = new File("exampleGrid.txt");
        File jobFile = new File("job-1.txt");

        GridLoader gridLoader = new GridLoader(gridFile);
        JobLoader jobLoader = new JobLoader(jobFile);


        Grid grid = gridLoader.readGridFromInputFile();
        Job job = jobLoader.readJobFromInputFile();

        ValueGraph<String, Double> graph = GraphFromGrid.createGraph(grid);
        GraphFromGrid.findAndPrintShortestPath(graph,"0 0","2 3");

//
//        //TODO testy implemantacji klasy Module
//
//        //TEST Module Types
//        System.out.println("Modules types");
//        for (int i = 0; i < grid.getGridOfModules().length; i++) {
//            for (int j = 0; j < grid.getGridOfModules()[i].length; j++) {
//                System.out.print(grid.getGridOfModules()[i][j].type);
//            }
//            System.out.println();
//        }
//
//        //TEST JOB
//
//        System.out.println(job.toString());

    }
}
