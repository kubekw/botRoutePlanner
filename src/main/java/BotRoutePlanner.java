import Dijkstra.BotPath;
import com.google.common.graph.ValueGraph;

import java.util.ArrayList;
import java.util.List;

public class BotRoutePlanner {

    public static void BotRoutePlanner(Grid grid, Job job, ValueGraph<String, Double> graph) {

        String start = job.getBotStartX()+" "+ job.getBotStartY();
        String finish = job.getBotFinishX()+" "+ job.getBotFinishY();

        BotPath fastestBotPath = null;

        for (Product p : grid.getProductsOnGrid()) {
            if (p.getName().equals(job.getProductName())) {
                String target = p.getX() + " " + p.getY();
                BotPath pathFromStartToProtuct = GraphFromGrid.findShortestPath(graph, start, target);
                BotPath pathFromProductToFinish = GraphFromGrid.findShortestPath(graph, target, finish);

                double totalTime = pathFromStartToProtuct.getTotalTime() +
                        pathFromProductToFinish.getTotalTime() + p.getAccssTime();

                int numberOfMoves = pathFromStartToProtuct.getMovesNumber() +
                        pathFromProductToFinish.getMovesNumber();

                List<String> listOfMoves = new ArrayList<>();
                listOfMoves.addAll(pathFromStartToProtuct.getMovesList());

                //usuniecie pietwszego elementu (drugiego startu)
                pathFromProductToFinish.getMovesList().remove(0);
                listOfMoves.addAll(pathFromProductToFinish.getMovesList());

                BotPath botPathFromStartToFinishWithPickUpTime = new BotPath(numberOfMoves, totalTime, listOfMoves);
                if (fastestBotPath == null || fastestBotPath.getTotalTime() > botPathFromStartToFinishWithPickUpTime.getTotalTime()) {
                    fastestBotPath = botPathFromStartToFinishWithPickUpTime;
                }
            }
        }

        //TODO poprawne wyświetlanie + Format
//        System.out.println(fastestBotPath.getMovesNumber());
//        System.out.println(fastestBotPath.getTotalTime());
//        System.out.println(fastestBotPath.getMovesList());

        System.out.println(fastestBotPath.toString());
    }

}
