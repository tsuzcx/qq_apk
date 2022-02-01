package moai.cache;

public abstract interface IVersionManager<E>
{
  public abstract boolean dataHasChanged(E paramE, int paramInt);
  
  public abstract int getVersion(E paramE);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.cache.IVersionManager
 * JD-Core Version:    0.7.0.1
 */