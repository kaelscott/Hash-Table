abstract class HashTable {
    protected int size;
    protected String[] table;       // array que armazena as chaves (strings) na tabela
    protected int collisions;

    public HashTable(int size) {
        this.size = size;
        this.table = new String[size];
        this.collisions = 0;
    }

    // função hash que será implementada pelas subclasses
    public abstract int hashFunction(String key);

    public void insert(String key) {
        int hash = hashFunction(key);  // calcula o índice de hash com base na chave
        int i = 0;  // contador para a sondagem linear (para resolução de colisões)

        // loop de sondagem linear procura por uma posição vazia ou uma chave existente
        while (table[hash] != null) {
            collisions++;  // a cada colisão (posição ocupada), incrementa o contador de colisões
            hash = (hash + ++i) % size;  // calcula o próximo índice usando a sondagem linear
        }

        // qndo encontra uma posição vazia, insere a chave
        table[hash] = key;
    }

    public boolean search(String key) {
        int hash = hashFunction(key);  // calcula o índice de hash com base na chave
        int i = 0;  // contador para a sondagem linear (para resolução de colisões)

        // Loop de sondagem linear continua procurando ate encontrar a chave ou uma posição vazia
        while (table[hash] != null) {
            if (table[hash].equals(key)) {  // se encontrar a chave, retorna verdadeiro
                return true;
            }
            hash = (hash + ++i) % size;  // alcula o próximo índice usando a sondagem linear
        }

        return false;
    }
}
