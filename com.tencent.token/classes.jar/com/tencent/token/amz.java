package com.tencent.token;

public abstract class amz
  implements ank
{
  private final ank a;
  
  public amz(ank paramank)
  {
    if (paramank != null)
    {
      this.a = paramank;
      return;
    }
    throw new IllegalArgumentException("delegate == null");
  }
  
  public final anm a()
  {
    return this.a.a();
  }
  
  public void a_(amv paramamv, long paramLong)
  {
    this.a.a_(paramamv, paramLong);
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
 * Qualified Name:     com.tencent.token.amz
 * JD-Core Version:    0.7.0.1
 */