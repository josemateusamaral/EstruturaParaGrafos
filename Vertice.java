import java.util.ArrayList;

public class Vertice{

    public static int ids = 0;
    private int id;
    private Vertice pai;
    private int distancia;
    private Vertice proximoDaFila;
    private String estado;
    private int tempo;
    public ArrayList<Aresta> arestas = new ArrayList<Aresta>();

    public Vertice( int id ){
        this.id = id;
    }
    public Vertice(){
        Vertice.ids++;
        this.id = Vertice.ids;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getTempo() {
        return tempo;
    }
    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public Vertice getProximoDaFila() {
        return proximoDaFila;
    }
    public void setProximoDaFila(Vertice proximoDaFila) {
        this.proximoDaFila = proximoDaFila;
    }

    public Vertice getPai() {
        return this.pai;
    }
    public void setPai(Vertice pai) {
        this.pai = pai;
    }

    public int getDistancia() {
        return distancia;
    }
    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public ArrayList<Aresta> getArestas(){
        return this.arestas;
    }
    public int getId(){
        return this.id;
    }

    public void addAresta(Aresta aresta){
        this.arestas.add(aresta);
    }
    public void removeAresta(Aresta aresta){
        this.arestas.remove(aresta);
    }

    public ArrayList<Vertice> getAdjascentes(boolean dirigo){
        ArrayList<Vertice> adjascentes = new ArrayList<Vertice>();
        for(Aresta aresta:this.arestas){
            if(dirigo){
                if(aresta.getVertice1()==this){
                    adjascentes.add(aresta.getVertice2());
                }
            }else{
                if(aresta.getVertice1()==this){
                    adjascentes.add(aresta.getVertice2());
                }else{
                    adjascentes.add(aresta.getVertice1());
                }
            }
            
        }
        return adjascentes;
    }
    public int grau(){
        return this.getArestas().size();
    }
}