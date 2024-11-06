import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        List<String> names = readNamesFromFile("female_names.txt");
        int tableSize = 5001; // Tamanho primo para melhor dispersão

        // Criar as tabelas hash
        HashTable hashTable1 = new Hash1(tableSize);
        HashTable hashTable2 = new Hash2(tableSize);

        // Análise para Hash1
        System.out.println("\n=== Análise da Hash1 ===");
        analyzeHashTable(hashTable1, names, "Hash1");

        // Análise para Hash2
        System.out.println("\n=== Análise da Hash2 ===");
        analyzeHashTable(hashTable2, names, "Hash2");

        // Comparar distribuições
        System.out.println("\n=== Comparação de Distribuições ===");
        compareDistributions(hashTable1, hashTable2);
    }

    private static void analyzeHashTable(HashTable hashTable, List<String> names, String tableName) {
        // Medir tempo de inserção
        long insertStartTime = System.nanoTime();
        for (String name : names) {
            hashTable.insert(name);
        }
        long insertEndTime = System.nanoTime();
        long insertTime = insertEndTime - insertStartTime;

        // Medir tempo de busca
        long searchStartTime = System.nanoTime();
        for (String name : names) {
            hashTable.search(name);
        }
        long searchEndTime = System.nanoTime();
        long searchTime = searchEndTime - searchStartTime;

        // Calcular distribuição
        int[] distribution = calculateDistribution(hashTable);

        // Imprimir resultados
        System.out.println(tableName + " - Estatísticas:");
        System.out.println("Número de colisões: " + hashTable.collisions);
        System.out.println("Tempo de inserção: " + insertTime / 1_000_000.0 + " ms");
        System.out.println("Tempo de busca: " + searchTime / 1_000_000.0 + " ms");

        // Análise da distribuição
        printDistributionStats(distribution);
    }

    private static int[] calculateDistribution(HashTable hashTable) {
        int[] distribution = new int[hashTable.size];
        for (int i = 0; i < hashTable.size; i++) {
            distribution[i] = (hashTable.table[i] != null) ? 1 : 0;
        }
        return distribution;
    }

    private static void printDistributionStats(int[] distribution) {
        int occupied = 0;
        int empty = 0;

        for (int count : distribution) {
            if (count > 0) occupied++;
            else empty++;
        }

        System.out.println("\nEstatísticas de Distribuição:");
        System.out.println("Posições ocupadas: " + occupied);
        System.out.println("Posições vazias: " + empty);
        System.out.printf("Taxa de ocupação: %.2f%%\n", (occupied * 100.0) / distribution.length);
    }

    private static void compareDistributions(HashTable hash1, HashTable hash2) {
        int[] dist1 = calculateDistribution(hash1);
        int[] dist2 = calculateDistribution(hash2);

        int occupied1 = Arrays.stream(dist1).sum();
        int occupied2 = Arrays.stream(dist2).sum();

        System.out.println("Comparação de ocupação:");
        System.out.println("Hash1: " + occupied1 + " elementos");
        System.out.println("Hash2: " + occupied2 + " elementos");

        if (occupied1 > occupied2) {
            System.out.println("Hash1 tem melhor distribuição de elementos");
        } else if (occupied2 > occupied1) {
            System.out.println("Hash2 tem melhor distribuição de elementos");
        } else {
            System.out.println("Ambas as funções têm distribuição similar");
        }
    }

    private static List<String> readNamesFromFile(String filename) {
        List<String> names = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                names.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;
    }
}