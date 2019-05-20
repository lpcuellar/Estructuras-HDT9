public class Matrix {
    private final int MAX_NO_OF_VERTICES;
    private int adjacency_matrix[][];

    public Matrix(int number_of_vertices) {
        MAX_NO_OF_VERTICES = number_of_vertices;
        adjacency_matrix = new int[MAX_NO_OF_VERTICES + 1][MAX_NO_OF_VERTICES + 1];
    }

    public void setEdge(int from_vertex, int to_vertex, int edge) {
        try {
            adjacency_matrix[from_vertex][to_vertex] = edge;
        } catch (ArrayIndexOutOfBoundsException indexBounce) {
            System.out.println("the vertex entered is not present");
        }
    }

    public int getEdge(int from_vertex, int to_vertex) {
        try {
            return adjacency_matrix[from_vertex][to_vertex];
        } catch (ArrayIndexOutOfBoundsException indexBounce) {
            System.out.println("the vertex entered is not present");
        }
        return -1;
    }
}