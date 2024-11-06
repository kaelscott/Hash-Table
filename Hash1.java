public class Hash1 extends HashTable {
    public Hash1(int size) {
        super(size);
    }

    @Override
    public int hashFunction(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash += key.charAt(i); // Soma os valores ASCII dos caracteres
        }
        return hash % size; // Retorna o índice pelo módulo do tamanho
    }
}
