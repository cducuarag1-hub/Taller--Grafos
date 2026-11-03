
import java.util.*;

public class Grafo {

    private HashMap<String, ArrayList<String>> listaAdyacencia;

    public Grafo() {
        listaAdyacencia = new HashMap<>();
    }

    // Agregar un vertice
    public void agregarVertice(String vertice) {
        if (!listaAdyacencia.containsKey(vertice)) {
            listaAdyacencia.put(vertice, new ArrayList<>());
            System.out.println("Vertice agregado: " + vertice);
        } else {
            System.out.println("El vertice ya existe.");
        }
    }

    // Agregar una arista
    public void agregarArista(String origen, String destino) {
        if (listaAdyacencia.containsKey(origen)
                && listaAdyacencia.containsKey(destino)) {

            if (!listaAdyacencia.get(origen).contains(destino)) {
                listaAdyacencia.get(origen).add(destino);
                listaAdyacencia.get(destino).add(origen);
                System.out.println("Arista agregada correctamente.");
            } else {
                System.out.println("La arista ya existe.");
            }

        } else {
            System.out.println("Uno o ambos vertices no existen.");
        }
    }

    // Eliminar una arista
    public void eliminarArista(String origen, String destino) {
        if (listaAdyacencia.containsKey(origen)
                && listaAdyacencia.containsKey(destino)) {

            listaAdyacencia.get(origen).remove(destino);
            listaAdyacencia.get(destino).remove(origen);
            System.out.println("Arista eliminada.");
        } else {
            System.out.println("Vertice no encontrado.");
        }
    }

    // Eliminar un vertice
    public void eliminarVertice(String vertice) {
        if (listaAdyacencia.containsKey(vertice)) {
            listaAdyacencia.remove(vertice);

            for (ArrayList<String> vecinos : listaAdyacencia.values()) {
                vecinos.remove(vertice);
            }

            System.out.println("Vertice eliminado: " + vertice);
        } else {
            System.out.println("El vertice no existe.");
        }
    }

    // Buscar un vertice
    public boolean buscarVertice(String vertice) {
        return listaAdyacencia.containsKey(vertice);
    }

    // Mostrar el grafo
    public void mostrarGrafo() {
        System.out.println("\nLISTA DE ADYACENCIA");

        for (String vertice : listaAdyacencia.keySet()) {
            System.out.println(vertice + " -> "
                    + listaAdyacencia.get(vertice));
        }
    }

    // Recorrido BFS
    public void BFS(String inicio) {
        if (!listaAdyacencia.containsKey(inicio)) {
            System.out.println("Vertice no encontrado.");
            return;
        }

        HashSet<String> visitados = new HashSet<>();
        Queue<String> cola = new LinkedList<>();

        visitados.add(inicio);
        cola.add(inicio);

        System.out.print("BFS: ");

        while (!cola.isEmpty()) {
            String actual = cola.poll();
            System.out.print(actual + " ");

            for (String vecino : listaAdyacencia.get(actual)) {
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }

        System.out.println();
    }

    // Recorrido DFS
    public void DFS(String inicio) {
        if (!listaAdyacencia.containsKey(inicio)) {
            System.out.println("Vertice no encontrado.");
            return;
        }

        HashSet<String> visitados = new HashSet<>();

        System.out.print("DFS: ");
        DFSRecursivo(inicio, visitados);
        System.out.println();
    }

    private void DFSRecursivo(String actual, HashSet<String> visitados) {
        visitados.add(actual);
        System.out.print(actual + " ");

        for (String vecino : listaAdyacencia.get(actual)) {
            if (!visitados.contains(vecino)) {
                DFSRecursivo(vecino, visitados);
            }
        }
    }
}