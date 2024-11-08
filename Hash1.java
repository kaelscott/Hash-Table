public class Hash1 extends HashTable {

    public Hash1(int size) {
        super(size);  // chama o construtor da classe HashTable passando o tamanho
    }


    @Override
    public int hashFunction(String key) {
        int hash = 0;

        // percorre cada caractere da chave (String)
        for (int i = 0; i < key.length(); i++) {
            hash += key.charAt(i);  // soma os valores ASCII dos caracteres da chave
        }

        // retorna o índice final da tabela utilizando o módulo do tamanho da tabela
        return hash % size;
    }
}
