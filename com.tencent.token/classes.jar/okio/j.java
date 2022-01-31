package okio;

public abstract class j
  implements x
{
  private final x a;
  
  public j(x paramx)
  {
    if (paramx == null) {
      throw new IllegalArgumentException("delegate == null");
    }
    this.a = paramx;
  }
  
  public z a()
  {
    return this.a.a();
  }
  
  public void a_(f paramf, long paramLong)
  {
    this.a.a_(paramf, paramLong);
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public void flush()
  {
    this.a.flush();
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + "(" + this.a.toString() + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.j
 * JD-Core Version:    0.7.0.1
 */