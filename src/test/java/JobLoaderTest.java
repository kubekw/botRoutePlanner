import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class JobLoaderTest {

    @Test
    public void readJobFromInputFile() throws FileNotFoundException {
        JobLoader jobLoader = new JobLoader(new File("testJob.txt"));
        Job job = jobLoader.readJobFromInputFile();

        assertEquals(1,job.getBotStartX());
        assertEquals(2,job.getBotStartY());
        assertEquals(3,job.getBotFinishX());
        assertEquals(4,job.getBotFinishY());
        assertEquals("P1",job.getProductName());
    }
}