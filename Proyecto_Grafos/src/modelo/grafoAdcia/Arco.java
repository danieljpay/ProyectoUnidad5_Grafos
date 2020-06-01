package modelo.grafoAdcia;

public class Arco{            
    int destino;
    double peso;
    
    public Arco(int d){
        destino = d;     
    }
    
    public Arco(int d, double p){
        this(d);
        peso = p;     
    }
    
    public int getDestino(){
        return destino;
    }
    
    public void setDestino(int n){
        this.destino = n;
    }

    public boolean equals(Object n){
        Arco a = (Arco)n;
        return destino == a.destino;
    }
 }

