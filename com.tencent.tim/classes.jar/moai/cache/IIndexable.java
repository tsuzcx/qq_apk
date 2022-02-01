package moai.cache;

public abstract interface IIndexable<K, V, A>
{
  public abstract void clear();
  
  public abstract void dropIndexes(V paramV);
  
  public abstract void ensureIndexes(V paramV);
  
  public abstract A get(K paramK);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.cache.IIndexable
 * JD-Core Version:    0.7.0.1
 */