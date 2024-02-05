public class Aresta{

    static int ids = 0;
    private int id;
    private Vertice vertice1;
    private Vertice vertice2;
    private int custo = 1;

    public Aresta(Vertice vertice1, Vertice vertice2){
        this.id = Aresta.ids;
        Aresta.ids++;
        setVertice1(vertice1);
        setVertice2(vertice2);
    }

    public Aresta(Vertice vertice1, Vertice vertice2, Integer custo){
        this.id = Aresta.ids;
        Aresta.ids++;
        setVertice1(vertice1);
        setVertice2(vertice2);
        setCusto(custo);
    }

    public int getId(){
        return this.id;
    }

    public void setVertice1(Vertice vertice1){
        this.vertice1 = vertice1;
    }

    public void setVertice2(Vertice vertice2){
        this.vertice2 = vertice2;
    }

    public Vertice getVertice1(){
        return this.vertice1;
    } 

    public Vertice getVertice2(){
        return this.vertice2;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

}