import Dijkstra.BotPath;
import com.google.common.graph.ValueGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File gridFile = new File("exampleGrid.txt");
        File jobFile = new File("job-1.txt");

        GridLoader gridLoader = new GridLoader(gridFile);
        JobLoader jobLoader = new JobLoader(jobFile);

        Grid grid = gridLoader.readGridFromInputFile();
        Job job = jobLoader.readJobFromInputFile();

        ValueGraph<String, Double> graph = GraphFromGrid.createGraph(grid);


        //TODO Metoda


        String start = "1 1";
        String finish = "0 0";


        List<BotPath> botPathsList = new ArrayList<>();

        for (Product p : grid.getProductsOnGrid()) {
            if (p.getName().equals("P1")) {
                String target = p.getY() + " " + p.getX();
                BotPath pathFromStartToProtuct = GraphFromGrid.findAndPrintShortestPath(graph, start, target);
                BotPath pathFromProductToFinish = GraphFromGrid.findAndPrintShortestPath(graph, target, finish);

                double totalTime=pathFromStartToProtuct.getTotalTime()+
                        pathFromProductToFinish.getTotalTime()+p.getAccssTime();

                int numberOfMoves = pathFromStartToProtuct.getMovesNumber()+
                        pathFromProductToFinish.getMovesNumber();

                List<String> listOfMoves = new ArrayList<>();
                listOfMoves.addAll(pathFromStartToProtuct.getMovesList());

                //usuniecie pietwszego elementu (drugiego startu)
                pathFromProductToFinish.getMovesList().remove(0);
                listOfMoves.addAll(pathFromProductToFinish.getMovesList());

                BotPath botPathFromStartToFinishWithPickUpTime = new BotPath(numberOfMoves, totalTime,listOfMoves);
                botPathsList.add(botPathFromStartToFinishWithPickUpTime);
            }
        }

        for(BotPath b : botPathsList){
            System.out.println(b.getMovesNumber());
            System.out.println(b.getTotalTime());
            System.out.println(b.getMovesList());
        }

        //TODO trasa z punktu startowego do kazdego produktu i do punktu koncowego

//        BotPath botPath = GraphFromGrid.findAndPrintShortestPath(graph,"0 0","2 3");
//
//
//
//
//        //TEST BotPath
//        System.out.println(botPath.getMovesNumber());
//        System.out.println(botPath.getTotalTime());
//        System.out.println(botPath.getMovesList());

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
