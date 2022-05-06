import Dijkstra.BotPath;
import com.google.common.graph.ValueGraph;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import static org.junit.Assert.*;

public class GridLoaderAndBotRoutePlannerTest {
    GridLoader gridLoader = new GridLoader(new File("grid-1.txt"));
    Grid grid = gridLoader.readGridFromInputFile();

    public GridLoaderAndBotRoutePlannerTest() throws FileNotFoundException {
    }

    @Test
    public void GridLoaderTest()  {

        assertEquals(4,grid.getGridSizeX());
        assertEquals(3,grid.getGridSizeY());
        assertEquals(3,grid.getGridSizeN());
        assertEquals(ModuleType.S,grid.getGridOfModules()[2][3].type);
    }


    @Test
    public void BotRoutePlannerTest() throws FileNotFoundException {
        ValueGraph<String, Double> graph = GraphFromGrid.createGraph(grid);
        JobLoader jobLoader = new JobLoader(new File("job-1.txt"));
        Job job = jobLoader.readJobFromInputFile();
        BotPath result = BotRoutePlanner.BotRoutePlanner(grid, job, graph);
        assertEquals(8,result.getMovesNumber());
        assertEquals(10.5,result.getTotalTime(),0);
        assertEquals("1 1",result.getMovesList().get(0));
        assertEquals("0 0",result.getMovesList().get(result.getMovesList().size()-1));
    }
}