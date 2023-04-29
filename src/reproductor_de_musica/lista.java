package reproductor_de_musica;

public class lista {

    nodo primer;
    nodo ultimo;
    int tam;

    public lista() {
        primer = ultimo = null;
        tam = 0;
    }

    public boolean vacio() {
        return primer == null;
    }

    public void limpio() {
        while (!vacio()) {
            borrar(primer);
        }
    }

    public void insertar(String nom, String dir) {
        nodo nuevo = new nodo(nom, dir);
        if (vacio()) {
            primer = nuevo;
            ultimo = nuevo;
        } else {
            nuevo.anterior = ultimo;
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
        tam++;
    }

    public int index(nodo b) {
        nodo aux = primer;
        int con = 0;

        while (aux != null) {
            if (aux == b) {
                return con;
            }
            aux = aux.siguiente;
            con++;
        }
        return -1;
    }
    
    public nodo get_cancion(int index){
        if (index < 0 || index >= tam) {
            return null;
        }
        
        int n = 0;
        nodo aux = primer;
        while (n != index) {            
            aux = aux.siguiente;
            n++;
        }
        
        return aux;
    }

    public void borrar(nodo b) {
        if (b == primer) {
            if (tam == 1) {
                primer = null;
                tam--;
                return;
            }
            primer.siguiente.anterior = null;
            primer = primer.siguiente;
            tam--;
            return;
        }
        tam--;
        if (b == ultimo) {
            ultimo.anterior.siguiente = null;
            ultimo = ultimo.anterior;
            return;
        }
        b.siguiente.anterior = b.anterior;
        b.siguiente.anterior.siguiente = b.siguiente;
    }
    
    public boolean buscar(String nombre, String ruta){
        nodo aux = primer;

        while (aux != null) {
            if (aux.nombre.equals(nombre) && aux.direccion.equals(ruta)) {
                return true;
            }
            aux = aux.siguiente;
        }
        return false;
    }
}
