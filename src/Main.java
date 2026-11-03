
public class Main {

    public static void main(String[] args) {

        Grafo grafo = new Grafo();

        // Crear vertices
        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");
        grafo.agregarVertice("E");

        // Crear aristas
        grafo.agregarArista("A", "B");
        grafo.agregarArista("A", "C");
        grafo.agregarArista("B", "D");
        grafo.agregarArista("C", "E");

        // Mostrar el grafo
        grafo.mostrarGrafo();

        // Buscar un vertice
        System.out.println("\n¿Existe C? "
                + grafo.buscarVertice("C"));

        // Recorridos
        grafo.BFS("A");
        grafo.DFS("A");

        // Eliminar una arista
        grafo.eliminarArista("A", "B");

        // Eliminar un vertice
        grafo.eliminarVertice("E");

        // Mostrar el grafo actualizado
        grafo.mostrarGrafo();
    }
}