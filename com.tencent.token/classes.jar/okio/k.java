package okio;

public abstract class k
  implements y
{
  private final y a;
  
  public k(y paramy)
  {
    if (paramy == null) {
      throw new IllegalArgumentException("delegate == null");
    }
    this.a = paramy;
  }
  
  public long a(f paramf, long paramLong)
  {
    return this.a.a(paramf, paramLong);
  }
  
  public z a()
  {
    return this.a.a();
  }
  
  public final y b()
  {
    return this.a;
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + "(" + this.a.toString() + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.k
 * JD-Core Version:    0.7.0.1
 */