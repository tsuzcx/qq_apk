package okio;

public abstract class g
  implements q
{
  private final q a;
  
  public g(q paramq)
  {
    if (paramq == null) {
      throw new IllegalArgumentException("delegate == null");
    }
    this.a = paramq;
  }
  
  public long a(c paramc, long paramLong)
  {
    return this.a.a(paramc, paramLong);
  }
  
  public r a()
  {
    return this.a.a();
  }
  
  public final q b()
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
 * Qualified Name:     okio.g
 * JD-Core Version:    0.7.0.1
 */