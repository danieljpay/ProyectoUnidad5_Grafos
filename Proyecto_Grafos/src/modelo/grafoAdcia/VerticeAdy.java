package modelo.grafoAdcia;

import modelo.Lista;

public class VerticeAdy{            
    String nombre;
    int numVertice;
    Lista lad;
    
    public VerticeAdy(String x){
        nombre = x;
        numVertice = -1;
        lad = new Lista();
    }

    public Lista getLad() {
        return lad;
    }

    public int getNumVertice() {
        return numVertice;
    }
    
    public boolean equals(Object d){
        VerticeAdy dos = (VerticeAdy)d;
        return nombre.equals(dos.nombre);
    }

    public void asigVert(int n){
        numVertice = n;
    }

    public String nomVertice(){
        return nombre;
    }

    public String toString(){
        return nombre + " (" + numVertice + ")";
    }
 }

