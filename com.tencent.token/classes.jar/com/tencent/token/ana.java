package com.tencent.token;

public abstract class ana
  implements anl
{
  protected final anl d;
  
  public ana(anl paramanl)
  {
    if (paramanl != null)
    {
      this.d = paramanl;
      return;
    }
    throw new IllegalArgumentException("delegate == null");
  }
  
  public long a(amv paramamv, long paramLong)
  {
    return this.d.a(paramamv, paramLong);
  }
  
  public final anm a()
  {
    return this.d.a();
  }
  
  public void close()
  {
    this.d.close();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("(");
    localStringBuilder.append(this.d.toString());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ana
 * JD-Core Version:    0.7.0.1
 */