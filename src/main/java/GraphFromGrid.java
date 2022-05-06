import Dijkstra.BotPath;
import Dijkstra.DijkstraWithPriorityQueue;
import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraph;
import com.google.common.graph.ValueGraphBuilder;

import java.util.List;

public class GraphFromGrid {

    public static BotPath findAndPrintShortestPath(ValueGraph<String, Double> graph, String source, String target) {
        BotPath shortestPath = DijkstraWithPriorityQueue.findShortestPath(graph, source, target);
        System.out.printf("shortestPath from %s to %s = %s%n", source, target, shortestPath.getMovesList());
        return shortestPath;
    }

    public static ValueGraph<String, Double> createGraph(Grid grid) {
        MutableValueGraph<String, Double> graph = ValueGraphBuilder.undirected().build();


        for (int y = 0; y < grid.getGridSizeY(); y++) {
            for (int x = 0; x < grid.getGridSizeX(); x++) {

                //polaczenia poziome
                if (x < grid.getGridSizeX() - 1) {

                    // predkość polaczenia
                    if (modulesAreAccessible(grid.getGridOfModules()[y][x].type,
                            grid.getGridOfModules()[y][x + 1].type)) {

                        double slowerSpeed = findSlowerDriveThruSpeed(grid.getGridOfModules()[y][x].getDriveThruSpeed(),
                                grid.getGridOfModules()[y][x + 1].getDriveThruSpeed());

                        System.out.println(y + "" + x + " " + y + "" + (x + 1) + " " + slowerSpeed + " " + grid.getGridOfModules()[y][x].type);
                        System.out.println(createVertex(y, x) + " " + createVertex(y, x + 1) + " " + slowerSpeed);
                        graph.putEdgeValue(createVertex(y, x), createVertex(y, x + 1), slowerSpeed);
                    }

                }

                //polaczenia pionowe
                if (y < grid.getGridSizeY() - 1) {
                    if (modulesAreAccessible(grid.getGridOfModules()[y][x].type,
                            grid.getGridOfModules()[y+1][x].type)) {

                        double slowerSpeed = findSlowerDriveThruSpeed(grid.getGridOfModules()[y][x].getDriveThruSpeed(),
                                grid.getGridOfModules()[y+1][x].getDriveThruSpeed());
                        System.out.println(y + "" + x + " " + (y + 1) + "" + x + " " + slowerSpeed + " " + grid.getGridOfModules()[y][x].type);
                        graph.putEdgeValue(createVertex(y, x), createVertex(y + 1, x), slowerSpeed);
                    }
                }
            }
        }

        return graph;
    }

    private static String createVertex(int y, int x) {
        String vertex = y + " " + x;
        return vertex;
    }

    private static boolean modulesAreAccessible(ModuleType type, ModuleType type1) {
        if (type.equals(ModuleType.O) || type1.equals(ModuleType.O)) {
            return false;
        }
        return true;
    }

    private static double findSlowerDriveThruSpeed(double speed1, double speed2) {
        if (speed1 > speed2) {
            return speed1;
        } else {
            return speed2;
        }
    }
}
