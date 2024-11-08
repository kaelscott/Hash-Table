public class Hash2 extends HashTable {

    public Hash2(int size) {
        super(size);
    }

    @Override
    public int hashFunction(String key) {
        // a função hash retorna o índice baseado no tamanho da chave (quantidade de caracteres)
        return key.length() % size;
    }
}
