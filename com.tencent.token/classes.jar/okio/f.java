package okio;

public abstract class f
  implements p
{
  private final p a;
  
  public f(p paramp)
  {
    if (paramp != null)
    {
      this.a = paramp;
      return;
    }
    throw new IllegalArgumentException("delegate == null");
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("(");
    localStringBuilder.append(this.a.toString());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.f
 * JD-Core Version:    0.7.0.1
 */