package src.test;

import actividad3.Graph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

public class GraphTest {

    @Test
    public void onePathFindsAPath() {

        // Se construye el grafo.
        Graph<Integer> g = new Graph<>();
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(1, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 4);

        List<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(1);
        expectedPath.add(5);
        expectedPath.add(6);
        expectedPath.add(4);

        assertEquals(expectedPath, g.onePath(1, 4));
    }
}
