import Dijkstra.BotPath;
import com.google.common.graph.ValueGraph;

import java.util.ArrayList;
import java.util.List;

public class BotRoutePlanner {

    public static BotPath BotRoutePlanner(Grid grid, Job job, ValueGraph<String, Double> graph) {

        String botStartPoint = createPoint(job.getBotStartX(), job.getBotStartY());
        String botFinishPoint = createPoint(job.getBotFinishX(), job.getBotFinishY());

        BotPath fastestBotPath = null;

        for (Product product : grid.getProductsOnGrid()) {
            if (product.getName().equals(job.getProductName())) {
                String productLocation = createPoint(product.getX(), product.getY());
                BotPath pathFromStartToProduct = GraphFromGrid.findShortestPath(graph, botStartPoint, productLocation);
                BotPath pathFromProductToFinish = GraphFromGrid.findShortestPath(graph, productLocation, botFinishPoint);

                double totalTime = getTotalTime(product, pathFromStartToProduct, pathFromProductToFinish);
                int numberOfMoves = countMoves(pathFromStartToProduct, pathFromProductToFinish);
                List<String> listOfMoves = createListOfMoves(pathFromStartToProduct, pathFromProductToFinish);

                BotPath botPathFromStartToFinishWithPickUpTime = new BotPath(numberOfMoves, totalTime, listOfMoves);
                if (newPathIsFasterThenFastestBotPath(fastestBotPath, botPathFromStartToFinishWithPickUpTime)) {
                    fastestBotPath = botPathFromStartToFinishWithPickUpTime;
                }
            }
        }
        return fastestBotPath;
    }

    private static boolean newPathIsFasterThenFastestBotPath(BotPath fastestBotPath, BotPath botPathFromStartToFinishWithPickUpTime) {
        return fastestBotPath == null || fastestBotPath.getTotalTime() > botPathFromStartToFinishWithPickUpTime.getTotalTime();
    }

    private static List<String> createListOfMoves(BotPath pathFromStartToProtuct, BotPath pathFromProductToFinish) {
        List<String> listOfMoves = new ArrayList<>();
        listOfMoves.addAll(pathFromStartToProtuct.getMovesList());
        pathFromProductToFinish.getMovesList().remove(0);
        listOfMoves.addAll(pathFromProductToFinish.getMovesList());
        return listOfMoves;
    }

    private static int countMoves(BotPath pathFromStartToProtuct, BotPath pathFromProductToFinish) {
        return pathFromStartToProtuct.getMovesNumber() +
                pathFromProductToFinish.getMovesNumber();
    }

    private static double getTotalTime(Product p, BotPath pathFromStartToProtuct, BotPath pathFromProductToFinish) {
        return pathFromStartToProtuct.getTotalTime() +
                pathFromProductToFinish.getTotalTime() + p.getAccssTime();
    }

    private static String createPoint(int job, int job1) {
        return job + " " + job1;
    }
}
