import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        List<String> names = readNamesFromFile("female_names.txt");

        int tableSize = 7001;

        HashTable hashTable1 = new Hash1(tableSize);
        HashTable hashTable2 = new Hash2(tableSize);

        System.out.println("\n=== Análise da Hash1 ===");
        analyzeHashTable(hashTable1, names, "Hash1");

        System.out.println("\n=== Análise da Hash2 ===");
        analyzeHashTable(hashTable2, names, "Hash2");
    }

    //  responsável por analisar uma tabela hash (inserção, busca e distribuição)
    private static void analyzeHashTable(HashTable hashTable, List<String> names, String tableName) {
        // Medir o tempo de inserção
        long insertStartTime = System.nanoTime();  // início do tempo de inserção
        for (String name : names) {
            hashTable.insert(name);  // insere cada nome na tabela hash
        }
        long insertEndTime = System.nanoTime();  // final do tempo de inserção
        long insertTime = insertEndTime - insertStartTime;  // tempo de inserção

        // Medir o tempo de busca
        long searchStartTime = System.nanoTime();  // início do tempo de busca
        for (String name : names) {
            hashTable.search(name);  // busca cada nome na tabela hash
        }
        long searchEndTime = System.nanoTime();  // final do tempo de busca
        long searchTime = searchEndTime - searchStartTime;  // tempo de busca

        // calcula a distribuição das chaves na tabela
        int[] distribution = calculateDistribution(hashTable);

        System.out.println(tableName + " - Estatísticas:");
        System.out.println("Número de colisões: " + hashTable.collisions);
        System.out.println("Tempo de inserção: " + insertTime / 1_000_000.0 + " ms");
        System.out.println("Tempo de busca: " + searchTime / 1_000_000.0 + " ms");

        printDistributionStats(distribution);
    }

    // calcula a distribuição das chaves nas posições da tabela hash
    private static int[] calculateDistribution(HashTable hashTable) {
        int[] distribution = new int[hashTable.size];  // cria um array para armazenar a distribuição
        for (int i = 0; i < hashTable.size; i++) {
            if (hashTable.table[i] != null) {
                distribution[i] = 1;  // posição ocupada
            } else {
                distribution[i] = 0;  // posição vazia
            }
        }
        return distribution;  // retorna a distribuição das posições
    }

    // imprime as estatísticas de distribuição (ocupação/vazio das posições da tabela)
    private static void printDistributionStats(int[] distribution) {
        int occupied = 0;
        int empty = 0;

        // percorre a distribuição e conta as posições ocupadas e vazias
        for (int count : distribution) {
            if (count > 0) occupied++;  // se o valor for 1, é uma posição ocupada
            else empty++;  // caso contrário, é uma posição vazia
        }

        System.out.println("\nEstatísticas de Distribuição:");
        System.out.println("Posições ocupadas: " + occupied + " de " + distribution.length);
        System.out.println("Posições vazias: " + empty + " de " + distribution.length);
    }

    // lê os nomes de um arquivo e os armazena em uma lista
    private static List<String> readNamesFromFile(String filename) {
        List<String> names = new ArrayList<>();  // cria uma lista para armazenar os nomes
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {  // abre o arquivo para leitura
            String line;
            while ((line = br.readLine()) != null) {
                names.add(line.trim());  // le cada linha do arquivo e adiciona à lista (removendo espaços extras)
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;
    }
}
