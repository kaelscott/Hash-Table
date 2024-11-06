public class Hash2 extends HashTable {
    public Hash2(int size) {
        super(size);
    }

    @Override
    public int hashFunction(String key) {
        return key.length() % size;
    }
}
