package actividad3;

import java.util.*;

public class Graph<V> {

    private Map<V, Set<V>> adjacencyList = new HashMap<>();

    public boolean addVertex(V vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new HashSet<>());
            return true;
        }

        return false;
    }

    public boolean addEdge(V v1, V v2) {

        if (!adjacencyList.containsKey(v1)) {
            addVertex(v1);
        }
        if (!adjacencyList.containsKey(v2)) {
            addVertex(v2);
        }

        return adjacencyList.get(v1).add(v2);

    }

    public Set<V> obtainAdjacents(V v) throws Exception {
        if (!adjacencyList.containsKey(v)) {
            throw new Exception("El Vértice no existe en el grafo");
        }

        return new HashSet<>(adjacencyList.get(v));
    }

    public boolean containsVertex(V v) {
        return adjacencyList.containsKey(v);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<V, Set<V>> entry : adjacencyList.entrySet()) {
            sb.append(entry.getKey()).append(" -> ");
            sb.append(entry.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }

    private boolean dfs(V current, V target, Set<V> visited, List<V> path) {
        visited.add(current);
        path.add(current);

        if (current.equals(target)) {
            return true;
        }

        Set<V> neighbors = adjacencyList.get(current);
        if (neighbors != null) {
            for (V neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    if (dfs(neighbor, target, visited, path)) {
                        return true;
                    }
                }
            }
        }
        path.remove(path.size() - 1);
        return false;
    }

    public List<V> onePath(V v1, V v2) {
        Set<V> visited = new HashSet<>();
        List<V> path = new ArrayList<>();
        if (dfs(v1, v2, visited, path)) {
            return path;
        }
        return null;
    }


}
