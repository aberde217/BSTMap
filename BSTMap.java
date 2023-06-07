public class BSTMap<K extends Comparable, V> implements Map61B {

    private class BSTNode {
        private K key;
        private V val;
        private BSTNode left, right;
        private BSTNode(K k, V v) {
            key = k;
            val = v;
        }
    }

    private int size;
    private BSTNode root;
    public BSTMap() {}

    @Override
    public void clear() {
        size = 0;
        root = null;
    }
    private boolean containsKeyHelper(K key, BSTNode T) {
        if (T == null)
            return false;
        if (T.key.compareTo(key) == 0)
            return true;
        else if (T.key.compareTo(key) > 0)
            return containsKeyHelper(key, T.right);
        else
            return containsKeyHelper(key, T.left);

    }
    @Override
    public boolean containsKey(Object key) {
        return containsKeyHelper((K) key, root);
    }

    private V getHelper(K key, BSTNode T) {
        if (T == null)
            return null;
        else if (T.key.compareTo(key) == 0)
            return T.val;
        else if (T.key.compareTo(key) > 0)
            return getHelper(key, T.right);
        else
            return getHelper(key, T.left);
    }
    @Override
    public V get(Object key) {
        return getHelper((K)key, root);
    }

    @Override
    public int size() {
        return size;
    }

    private BSTNode put(K key, V value, BSTNode T) {
        if (T == null)
            T = new BSTNode(key, value);
        else if (T.key.compareTo(key) > 0)
            T.right = put(key, value, T.right);
        else if (T.key.compareTo(key) < 0)
            T.left = put(key, value, T.left);
        return T;
    }
    @Override
    public void put(Object key, Object value) {
        root = put((K) key, (V) value, root);
        size += 1;
    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public V remove(Object key, Object value) {
        return null;
    }


    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Action not supported");
    }
    
}

