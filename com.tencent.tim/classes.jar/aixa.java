public abstract class aixa<T, P>
{
  private volatile T mInstance;
  
  protected abstract T create(P paramP);
  
  public final T get(P paramP)
  {
    if (this.mInstance == null) {}
    try
    {
      if (this.mInstance == null) {
        this.mInstance = create(paramP);
      }
      return this.mInstance;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aixa
 * JD-Core Version:    0.7.0.1
 */