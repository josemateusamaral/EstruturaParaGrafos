public class FilaDeVertices {
    
    private Vertice raiz = null;

    public void setRaiz(Vertice verticeRaiz){
        this.raiz = verticeRaiz;
    }
    public Vertice getRaiz(){
        return this.raiz;
    }

    public boolean isEmpty(){
        if( this.raiz == null ){
            return true;
        }else{
            return false;
        }
    }

    public void insere(Vertice node){
        if(this.raiz==null){
            this.raiz = node;
        }else{
            Vertice p = this.raiz;
            while( p.getProximoDaFila() != null ){
                p = p.getProximoDaFila();
            }
            p.setProximoDaFila(node);
        }
    }

    public Object remove(Vertice node){
        if(this.raiz==node){
            this.raiz = null;
        }else{
            Vertice anterior = null;
            Vertice atual = this.raiz;
            while( atual.getProximoDaFila() != null ){
                if(atual == node){
                    Vertice proximo = atual.getProximoDaFila();
                    anterior.setProximoDaFila(proximo);
                }
                anterior = atual;
                atual = atual.getProximoDaFila();
            }
        }
        return node;
    }

    public Vertice remove(){
        if(this.raiz==null){
            return null;
        }else{
            Vertice node = this.raiz;
            this.raiz = this.raiz.getProximoDaFila();
            return node;
        }        
    }

    public int indexOf(Vertice node){
        if(this.raiz==node){
            return 0;
        }
        if(this.raiz==null){
            return -1;
        }else{
            int index = 0;
            Vertice atual = this.raiz;
            while( atual.getProximoDaFila() != null ){
                if(atual == node){
                    return index;
                }
                index++;
                atual = atual.getProximoDaFila();
            }
        }
        return -1;
    }

}
