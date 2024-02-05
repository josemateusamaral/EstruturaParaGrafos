class Main {
    public static void main(String[] args) {
        
        /* instanciando o objeto grafo configurado para ser nao direcional
               OBS: O grafo criado a baixo é uma representação do grafo contido no
           arquivo grafo.png. O grafo utilizadp na representação pode ser alterado mudando o argumento ehDirigido na função abaixo.*/
        Grafo grafoDeTeste = new Grafo(true,"grafoDigidoDeTeste");

        // criando os vertices para colocar no grafo
        Vertice vertice1 = new Vertice(1);
        grafoDeTeste.insereV(vertice1);
        Vertice vertice2 = new Vertice(2);
        grafoDeTeste.insereV(vertice2);
        Vertice vertice3 = new Vertice(3);
        grafoDeTeste.insereV(vertice3);
        Vertice vertice4 = new Vertice(4);
        grafoDeTeste.insereV(vertice4);
        Vertice vertice5 = new Vertice(5);
        grafoDeTeste.insereV(vertice5);
        Vertice vertice6 = new Vertice(6);
        grafoDeTeste.insereV(vertice6);
        Vertice vertice7 = new Vertice(7);
        grafoDeTeste.insereV(vertice7);
        Vertice vertice8 = new Vertice(8);
        grafoDeTeste.insereV(vertice8);
        Vertice vertice9 = new Vertice(9);
        grafoDeTeste.insereV(vertice9);
        Vertice vertice10 = new Vertice(10);
        grafoDeTeste.insereV(vertice10);

        //adicionando arestas ao grafo
        Aresta aresta0 = grafoDeTeste.insereA(vertice8,vertice2,20);
        Aresta aresta1 = grafoDeTeste.insereA(vertice1,vertice2,10);
        Aresta aresta2 = grafoDeTeste.insereA(vertice1,vertice4,20);
        Aresta aresta3 = grafoDeTeste.insereA(vertice4,vertice5,10);
        Aresta aresta4 = grafoDeTeste.insereA(vertice9,vertice8,20);
        Aresta aresta5 = grafoDeTeste.insereA(vertice2,vertice4,15);
        Aresta aresta6 = grafoDeTeste.insereA(vertice2,vertice3,5);
        Aresta aresta7 = grafoDeTeste.insereA(vertice3,vertice2,15);
        Aresta aresta8 = grafoDeTeste.insereA(vertice10,vertice3,15);
        Aresta aresta9 = grafoDeTeste.insereA(vertice10,vertice2,5);
        Aresta aresta10 = grafoDeTeste.insereA(vertice9,vertice2,15);
        Aresta aresta11 = grafoDeTeste.insereA(vertice9,vertice10,10);
        Aresta aresta12 = grafoDeTeste.insereA(vertice3,vertice4,5);
        Aresta aresta13 = grafoDeTeste.insereA(vertice8,vertice7,5);
        Aresta aresta14 = grafoDeTeste.insereA(vertice1,vertice6,5);
        Aresta aresta15 = grafoDeTeste.insereA(vertice5,vertice6,5);
        Aresta aresta16 = grafoDeTeste.insereA(vertice7,vertice6,10);
        Aresta aresta17 = grafoDeTeste.insereA(vertice1,vertice7,15);
        Aresta aresta18 = grafoDeTeste.insereA(vertice8,vertice1,5);
        
        System.out.println(grafoDeTeste);

        //caminho escolhido
        Vertice verticeDePartida = vertice8;
        Vertice verticeAlvo = vertice4;

        // Busca Em Largura
        grafoDeTeste.BuscaEmLargura(grafoDeTeste,verticeDePartida);
        System.out.println("\n\nCaminho do vertice de partida até o vertice alvo usando Busca Em Largura");
        grafoDeTeste.ImprimeCaminho(grafoDeTeste, verticeDePartida, verticeAlvo);

        // Busca Em Profundida 
        grafoDeTeste.BuscaEmProfundidade(grafoDeTeste,verticeDePartida);
        System.out.println("\n\nCaminho do vertice de partida até o vertice alvo usando Busca Em Profundidade");
        grafoDeTeste.ImprimeCaminho(grafoDeTeste, verticeDePartida, verticeAlvo);

        // Busca Bidirecional
        grafoDeTeste.BuscaBidirecional(grafoDeTeste,verticeDePartida,verticeAlvo);
        System.out.println("\n\nCaminho do vertice de partida até o vertice alvo usando Busca Bidirecional");
        grafoDeTeste.ImprimeCaminho(grafoDeTeste, verticeDePartida, verticeAlvo);

        // Busca Usando Algoritmo De Prim
        grafoDeTeste.AlgoritmoDePrim(grafoDeTeste,verticeDePartida);
        System.out.println("\n\nCaminho do vertice de partida até o vertice alvo usando Algoritmo de PRIM");
        grafoDeTeste.ImprimeCaminho(grafoDeTeste, verticeDePartida, verticeAlvo);

        // Busca usando Algoritmo De Dijkastra
        grafoDeTeste.AlgoritmoDeDijkastra(grafoDeTeste, verticeDePartida);
        System.out.println("\n\nCaminho do vertice de partida até o vertice alvo usando Algoritmo de Dijkastra");
        grafoDeTeste.ImprimeCaminho(grafoDeTeste, verticeDePartida, verticeAlvo);

    }
}