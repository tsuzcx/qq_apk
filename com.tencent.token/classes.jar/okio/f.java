package okio;

public abstract class f
  implements p
{
  private final p a;
  
  public f(p paramp)
  {
    if (paramp == null) {
      throw new IllegalArgumentException("delegate == null");
    }
    this.a = paramp;
  }
  
  public r a()
  {
    return this.a.a();
  }
  
  public void a_(c paramc, long paramLong)
  {
    this.a.a_(paramc, paramLong);
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
 * Qualified Name:     okio.f
 * JD-Core Version:    0.7.0.1
 */