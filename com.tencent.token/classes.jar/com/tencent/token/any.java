package com.tencent.token;

public abstract class any
  implements aoj
{
  protected final aoj d;
  
  public any(aoj paramaoj)
  {
    if (paramaoj != null)
    {
      this.d = paramaoj;
      return;
    }
    throw new IllegalArgumentException("delegate == null");
  }
  
  public long a(ant paramant, long paramLong)
  {
    return this.d.a(paramant, paramLong);
  }
  
  public final aok a()
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
 * Qualified Name:     com.tencent.token.any
 * JD-Core Version:    0.7.0.1
 */