package com.tencent.token;

public abstract class ald
  implements alo
{
  protected final alo d;
  
  public ald(alo paramalo)
  {
    if (paramalo != null)
    {
      this.d = paramalo;
      return;
    }
    throw new IllegalArgumentException("delegate == null");
  }
  
  public long a(aky paramaky, long paramLong)
  {
    return this.d.a(paramaky, paramLong);
  }
  
  public final alp a()
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
 * Qualified Name:     com.tencent.token.ald
 * JD-Core Version:    0.7.0.1
 */