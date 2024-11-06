abstract class HashTable {
    protected int size;
    protected String[] table;
    protected int collisions;

    public HashTable(int size) {
        this.size = size;
        this.table = new String[size];
        this.collisions = 0;
    }

    public abstract int hashFunction(String key);

    public void insert(String key) {
        int hash = hashFunction(key);
        int originalHash = hash;
        int i = 1;

        while (table[hash] != null) {
            collisions++;
            hash = (originalHash + i) % size; // Sondagem linear
            i++;
        }
        table[hash] = key;
    }

    public boolean search(String key) {
        int hash = hashFunction(key);
        int originalHash = hash;
        int i = 1;

        while (table[hash] != null && !table[hash].equals(key)) {
            hash = (originalHash + i) % size;
            i++;
        }
        return table[hash] != null && table[hash].equals(key);
    }
}
