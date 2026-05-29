public class Pilha {
    private int capacidade;
    private int indTop;
    private int[] pilha;

    public Pilha(int capacidade) {
        // TODO
        this.capacidade = capacidade;
        this.indTop = -1;
        this.pilha = new int[capacidade];
    }

    public boolean isEmpty() {
        // TODO
        return indTop == -1;
    }

    public boolean isFull() {
        // TODO
        return indTop == capacidade - 1;
    }

    // deve lançar exceção caso a pilha esteja cheia.
    public void push(int valor) {
        // TODO
        if (this.isFull()) {
            throw new RuntimeException("Pilha cheia");
        }
        this.indTop++;
        this.pilha[indTop] = valor;
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int pop() {
        // TODO 
        if (this.isEmpty()) {
            throw new RuntimeException("Pilha vazia");
        }
        int popped = this.top();
        this.indTop--;
        return popped;
    }

     public int peek() {
        // TODO 
        return top();
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int top() {
        // TODO
        if (this.isEmpty()) {
            throw new RuntimeException("Pilha vazia");
        }
        return pilha[indTop];
    }


    // deve retornar uma string representando a pilha. Veja os testes para a especificação
    // detalhada. Não é permitido iterar diretamente sobre o array ou criar arrays. Crie outra pilha, se preciso. Use as operações push, pop,
    // isEmpty etc. 
    public String toString() {
        String saida = "";
        if (this.isEmpty()) {
            return saida;
        }
        Pilha pilhAux = new Pilha(capacidade);
        while(!this.isEmpty()) {
            pilhAux.push(this.pop());
        }
        while (!pilhAux.isEmpty()) {
            if (!saida.equals("")) {
                saida += ", ";
                int valor = pilhAux.pop();
                this.push(valor);
            } else {
            int valor = pilhAux.pop();
            saida += valor;
            this.push(valor);
            }
        }
        return saida;
    }
    
    // Deve retornar o índice da primeira ocorrência do elemento passado como parâmetro. 
    // Não é permitido iterar diretamente sobre o array. Use as operações push, pop,
    // isEmpty etc.
    public int indexOf(int valor) {
        if (this.isEmpty()) {
            throw new RuntimeException("Pilha vazia");
        }
        Pilha pilhAux = new Pilha(capacidade);
        int index = 0;
        boolean found = false;
        while (!this.isEmpty()) {
            pilhAux.push(this.pop());
        }
        if (pilhAux.top() == valor) {
            while (!pilhAux.isEmpty()) {
                this.push(pilhAux.pop());
            }
            found = true;
        }
        else {
            this.push(pilhAux.pop());
            index++;
        }
        if (!found) {
            return -1;
        }
        return index;
    }

    public int size() {
        // TODO
        return indTop + 1;
    }
}