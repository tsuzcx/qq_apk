package moai.cache;

public interface IIndexable<K, V, A> {
	public void ensureIndexes(V v);
	public void dropIndexes(V v);
	public void clear();
	public A get(K k);
}
