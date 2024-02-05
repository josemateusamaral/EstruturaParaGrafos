import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Grafo{

    private static int quantidadeGrafos;
    private int tempo;
    private String nomeGrafo;
    private boolean ehDirigido;
    private ArrayList<Vertice> vertices = new ArrayList<Vertice>();  
    private ArrayList<Aresta> arestas = new ArrayList<Aresta>();

    //construtores e distrutores
    public Grafo( Boolean ehDirigido,String nome){
        this.ehDirigido = ehDirigido;
        this.nomeGrafo = nome;
    }
    public Grafo( Boolean ehDirigido){
        this.ehDirigido = ehDirigido;
        quantidadeGrafos++;
        this.nomeGrafo = "grafo" + quantidadeGrafos;
    }
    public Grafo(String nome){
        this.ehDirigido = false;
        this.nomeGrafo = nome;
    }
    public Grafo(){
        this.ehDirigido = false;
        quantidadeGrafos++;
        this.nomeGrafo = "grafo" + quantidadeGrafos;
    }

    public ArrayList<Vertice> getVertices(){
        return vertices;
    }

    public void setNomeGrafo(String nomeGrafo){
        this.nomeGrafo = nomeGrafo;
    }
    public String getNomeGrafo(){
        return this.nomeGrafo;
    }

    public int getTempo() {
        return tempo;
    }
    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    //pegar os dados relacionados ao tamanho do grafo
    public int getOrdem(){
        return this.vertices.size();
    }
    public int getTamanho(){
        return this.arestas.size();
    }

    //retornar as listas interativas referentes ao grafo
    public ArrayList<Vertice> vertices(){
        return this.vertices;
    }
    public ArrayList<Aresta> arestas(){
        return this.arestas;
    }

    //manipular vertices
    public void insereV(Vertice vertice){
        this.vertices.add(vertice);
    }
    public void removeV(Vertice vertice){
        
        ArrayList<Aresta> arestasDoVertice = vertice.getArestas();
        
        // tirando a aresta dos vertices
        for( Aresta aresta : arestasDoVertice ){
            this.arestas.remove(aresta);
        }
        
        for( Vertice v:this.vertices ){
            if( v == vertice ){
                this.vertices.remove(v);
            }
        }
    
    }

    //manipular arestas
    public Aresta insereA(Vertice u,Vertice v){
        Aresta aresta = new Aresta(u,v);
        u.addAresta(aresta);
        v.addAresta(aresta);
        this.arestas.add(aresta);
        return aresta;
    }
    public Aresta insereA(Vertice u,Vertice v, Integer custo){
        Aresta aresta = new Aresta(u,v,custo);
        u.addAresta(aresta);
        v.addAresta(aresta);
        this.arestas.add(aresta);
        return aresta;
    }
    public void removeA(Aresta a){
        for( Aresta aresta:this.arestas){
            if(aresta.getId() == a.getId()){
                this.arestas.remove(aresta);
            }
        }
    }

    //metodos para relacoes entre vertices
    public ArrayList<Vertice> adj(Vertice vertice){
        ArrayList<Vertice> retorno = new ArrayList<Vertice>();
        for( Aresta aresta:vertice.getArestas()){
            if(aresta.getVertice2() == vertice){
                retorno.add(aresta.getVertice1());
            }else if(!this.ehDirigido){
                retorno.add(aresta.getVertice2());
            }
        }
        return retorno;
    }
    public Aresta getA(Vertice u, Vertice v){

        if( this.ehDirigido ){
            for( Aresta aresta:this.arestas){
                if(
                    ( u == aresta.getVertice1() && v == aresta.getVertice2() )
                ){
                    return aresta;
                }
            }
        }
        else{
            for( Aresta aresta:this.arestas){
                if(
                    ( u == aresta.getVertice1() && v == aresta.getVertice2() )
                    ||
                    ( u == aresta.getVertice2() && v == aresta.getVertice1() )
                ){
                    return aresta;
                }
            }
        }        
        return null;
    }

    //metodos relativos ao grau dos vertices
    public int grauE(Vertice vertice){
        int grau = 0;
        if( this.ehDirigido ){
            for( Aresta aresta:vertice.getArestas()){
                if(aresta.getVertice2() == vertice){
                    grau++;
                }
            }
        }
        return grau;
    }
    public int grauS(Vertice vertice){
        int grau = 0;
        if( this.ehDirigido ){
            for( Aresta aresta:vertice.getArestas()){
                if(aresta.getVertice1() == vertice){
                    grau++;
                }
            }
        }
        return grau;
    }
    public int grau(Vertice vertice){
        int grau = 0;
        if( !this.ehDirigido ){
            grau = vertice.grau();
        }
        return grau;
    }

    //metodos para retornar vertices e arrestas
    public ArrayList<Vertice> verticesA( Aresta e ){
        ArrayList<Vertice> vertices = new ArrayList<Vertice>();
        vertices.add(e.getVertice1());
        vertices.add(e.getVertice2());
        return vertices;
    }
    public Vertice oposto( Vertice v, Aresta e ){
        if( e.getVertice1() == v ){
            return e.getVertice2();
        }
        else{
            return e.getVertice1();
        }
    }
    public ArrayList<Aresta> arestasE( Vertice v ){
        ArrayList<Aresta> arestasEntrando = new ArrayList<Aresta>();
        for( Aresta aresta : v.getArestas() ){
            if( aresta.getVertice2() == v ){
                arestasEntrando.add(aresta);
            }
        }
        return arestasEntrando;
    }
    public ArrayList<Aresta> arestasS( Vertice v ){
        ArrayList<Aresta> arestasEntrando = new ArrayList<Aresta>();
        for( Aresta aresta : v.getArestas() ){
            if( aresta.getVertice1() == v ){
                arestasEntrando.add(aresta);
            }
        }
        return arestasEntrando;
    }

    //metodos auxiliares da classe
    public String toString(){
        String retorno = new String();
        if(this.ehDirigido){
            retorno += "*** GRAFO DIRIGIDO ***";
        }else{
            retorno += "*** GRAFO NAO-DIRIGIDO ***";
        }
        retorno += "\n\tNome:" + this.nomeGrafo;
        retorno += "\n\tArestas:";
        for( Aresta aresta : this.arestas ){
            retorno += "\n\t\tAresta:" + aresta.getId();
            retorno += "\n\t\t\tVertices1:" + aresta.getVertice1().getId();
            retorno += "\n\t\t\tVertices2:" + aresta.getVertice2().getId();
        }
        return retorno;
    }
    public void ImprimeCaminho(Grafo grafo, Vertice raiz,Vertice vertice){
        if(vertice==raiz){
            System.out.print("--> " + raiz.getId());
        }
        else{
            if(vertice.getPai()==null){
                System.out.print("não existe caminho de " + raiz.getId() + " para " + vertice.getId());
                return;
            }else{
                ImprimeCaminho(grafo, raiz, vertice.getPai());
                System.out.print(" --> " + vertice.getId());
            }
        }
    }
    public int getCustoAresta(Vertice vertice1, Vertice vertice2){

        if(vertice1 == vertice2){
            return 0;
        }

        int custo = -1;
        for( Aresta aresta : this.arestas ){
            if( ( aresta.getVertice1() == vertice1 && aresta.getVertice2() == vertice2 )
            || 
                (aresta.getVertice1() == vertice2 && aresta.getVertice2() == vertice1)
            ){
                return aresta.getCusto();
            }
        }
        return custo;
    }

    // METODOS DE BUSCA
    
    //busca em largura.
    public void BuscaEmLargura(Grafo grafo,Vertice verticeInicial){
        
        // configurar estado, pai e distancia de todos os vertices do grafo
        for(Vertice vertice:grafo.vertices){
            vertice.setEstado("NAO_VISITADO");
            vertice.setPai(null);
            vertice.setDistancia(-1);
        }
        
        // configurar a raiz e a fila de vertices
        verticeInicial.setDistancia(0);
        verticeInicial.setEstado("VISITADO"); 
        FilaDeVertices fileDeVertices = new FilaDeVertices();
        fileDeVertices.setRaiz(verticeInicial);

        // rodar a busca em largura e armazanar os dados nos vertices
        while( fileDeVertices.getRaiz() != null ){
            Vertice v1 = fileDeVertices.remove();
            for(Vertice v2:v1.getAdjascentes(grafo.ehDirigido)){
                if( v2.getEstado() == "NAO_VISITADO" ){
                    fileDeVertices.insere(v2);
                    v2.setEstado("VISITADO");
                    v2.setPai(v1);
                    v2.setDistancia(v1.getDistancia()+1);
                }
            }
            v1.setEstado("ENCERRADO");
        }
    }

    //busca em profundidade
    public void BuscaEmProfundidade(Grafo grafo,Vertice verticeInicial){
        for(Vertice vertice:grafo.getVertices()){
            vertice.setEstado("NAO_VISITADO");
            vertice.setPai(null);
        }
        this.tempo = 0;
        VisitaVertice(verticeInicial,grafo.ehDirigido);
    }
    public void VisitaVertice(Vertice vertice,boolean ehGrafoDirigido){
        vertice.setEstado("VISITADO");
        this.tempo++;
        vertice.setTempo(this.tempo);
        for(Vertice verticeAdjascente:vertice.getAdjascentes(ehGrafoDirigido)){
            if(verticeAdjascente.getEstado()=="NAO_VISITADO"){
                verticeAdjascente.setPai(vertice);
                VisitaVertice(verticeAdjascente,ehGrafoDirigido);
            }
        }
        vertice.setEstado("ENCERRADO");
    }

    // busca bidirecional
    public void BuscaBidirecional( Grafo grafo,Vertice raiz,Vertice vertice){

        // filas para guardos vertices
        FilaDeVertices filaComeco = new FilaDeVertices();
        FilaDeVertices filaobjetivo = new FilaDeVertices();
        FilaDeVertices visitadosComeco = new FilaDeVertices();
        FilaDeVertices visitadosObjetivo = new FilaDeVertices();

        // Inicialização das buscas
        filaComeco.insere(raiz);
        filaobjetivo.insere(vertice);
        visitadosComeco.insere(raiz);
        visitadosObjetivo.insere(vertice);

        boolean on = true;
        while (!filaComeco.isEmpty() && !filaobjetivo.isEmpty() && on) {
            // Realiza a busca apartir do início
            Vertice v1Comeco = filaComeco.remove();
            for(Vertice v2comeco:v1Comeco.getAdjascentes(grafo.ehDirigido)){
                if(filaobjetivo.indexOf(v2comeco) != -1){
                    on = false;
                    break;
                }
                if( v2comeco.getEstado() == "NAO_VISITADO" ){
                    filaComeco.insere(v2comeco);
                    v2comeco.setEstado("VISITADO");
                    v2comeco.setPai(v1Comeco);
                    v2comeco.setDistancia(v1Comeco.getDistancia()+1);
                    visitadosComeco.insere(v2comeco);
                }
            }
            v1Comeco.setEstado("ENCERRADO");

            // Realiza a busca apartir do fim
            Vertice v1Objetivo = filaobjetivo.remove();
            for(Vertice v2objetivo:v1Objetivo.getAdjascentes(grafo.ehDirigido)){
                if(filaComeco.indexOf(v2objetivo) != -1){
                    on = false;
                    break;
                }
                if( v2objetivo.getEstado() == "NAO_VISITADO" ){
                    filaobjetivo.insere(v2objetivo);
                    v2objetivo.setEstado("VISITADO");
                    v2objetivo.setPai(v1Objetivo);
                    v2objetivo.setDistancia(v1Objetivo.getDistancia()+1);
                    visitadosObjetivo.insere(v2objetivo);
                }
            }
            v1Objetivo.setEstado("ENCERRADO");
        }
    }

    // algoritmo de prim
    public void AlgoritmoDePrim(Grafo grafo, Vertice raiz) {
        
        ArrayList<Vertice> Q = new ArrayList<Vertice>();
    
        for (Vertice vertice : grafo.getVertices()) {
            vertice.setPai(null);
            vertice.setTempo(Integer.MAX_VALUE);
            Q.add(vertice);
        }    
        raiz.setTempo(0);
    
        while (!Q.isEmpty()) {
            Vertice u = removeMinimo(Q);
    
            for (Vertice v : u.getAdjascentes(this.ehDirigido)) {
                int custoUV = getCustoAresta(u, v);
                if (Q.contains(v) && custoUV < v.getTempo()) {
                    v.setPai(u);
                    v.setTempo(custoUV);
                }
            }
        }
    }
    public Vertice removeMinimo(ArrayList<Vertice> Q) {
        Vertice menor = Q.get(0);
        for (Vertice vertice : Q) {
            if (vertice.getTempo() < menor.getTempo()) {
                menor = vertice;
            }
        }
        Q.remove(menor);
        return menor;
    }
    
    // algoritmo de dijkastra 
    public void InitializeSingleSource( Grafo grafo, Vertice raiz ){
        for( Vertice vertice : grafo.vertices() ){
            vertice.setTempo(Integer.MAX_VALUE);
            vertice.setPai(null);
        }
        raiz.setTempo(0);
    }
    public void Relax( Vertice u, Vertice v ){
        if( v.getTempo() > u.getTempo() + getCustoAresta(u,v) ){
            v.setTempo(u.getTempo() + getCustoAresta(u,v) );
            v.setPai(u);
        }
    }
    public void AlgoritmoDeDijkastra( Grafo grafo, Vertice raiz){
        
        InitializeSingleSource( grafo, raiz );
        ArrayList<Vertice> S = new ArrayList<Vertice>();
        ArrayList<Vertice> Q = grafo.vertices();

        while( !Q.isEmpty() ){
            Vertice u = removeMinimo(Q);
            S.add(u);
            for( Vertice v : u.getAdjascentes(this.ehDirigido)){
                if(!S.contains(v)){
                    Relax(u,v);
                }
            }
        }
    }
}