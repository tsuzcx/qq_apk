package com.tencent.token;

public abstract class ale
  implements alp
{
  protected final alp d;
  
  public ale(alp paramalp)
  {
    if (paramalp != null)
    {
      this.d = paramalp;
      return;
    }
    throw new IllegalArgumentException("delegate == null");
  }
  
  public long a(akz paramakz, long paramLong)
  {
    return this.d.a(paramakz, paramLong);
  }
  
  public final alq a()
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
 * Qualified Name:     com.tencent.token.ale
 * JD-Core Version:    0.7.0.1
 */