import Dijkstra.BotPath;
import Dijkstra.DijkstraWithPriorityQueue;
import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraph;
import com.google.common.graph.ValueGraphBuilder;

public class GraphFromGrid {

    public static BotPath findShortestPath(ValueGraph<String, Double> graph, String source, String target) {
        BotPath shortestPath = DijkstraWithPriorityQueue.findShortestPath(graph, source, target);
        return shortestPath;
    }

    public static ValueGraph<String, Double> createGraph(Grid grid) {
        MutableValueGraph<String, Double> graph = ValueGraphBuilder.undirected().build();
        for (int y = 0; y < grid.getGridSizeY(); y++) {
            for (int x = 0; x < grid.getGridSizeX(); x++) {
                if (x < grid.getGridSizeX() - 1) {
                    if (modulesAreAccessible(grid.getGridOfModules()[y][x].type,
                            grid.getGridOfModules()[y][x + 1].type)) {
                        double slowerSpeed = findSlowerDriveThruSpeed(grid.getGridOfModules()[y][x].getDriveThruSpeed(),
                                grid.getGridOfModules()[y][x + 1].getDriveThruSpeed());
                        graph.putEdgeValue(createVertex(y, x), createVertex(y, x + 1), slowerSpeed);
                    }
                }
                if (y < grid.getGridSizeY() - 1) {
                    if (modulesAreAccessible(grid.getGridOfModules()[y][x].type,
                            grid.getGridOfModules()[y+1][x].type)) {
                        double slowerSpeed = findSlowerDriveThruSpeed(grid.getGridOfModules()[y][x].getDriveThruSpeed(),
                                grid.getGridOfModules()[y+1][x].getDriveThruSpeed());
                        graph.putEdgeValue(createVertex(y, x), createVertex(y + 1, x), slowerSpeed);
                    }
                }
            }
        }
        return graph;
    }

    private static String createVertex(int y, int x) {
        String vertex = x + " " + y;
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
