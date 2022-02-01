package com.tencent.token;

public abstract class ald
  implements alo
{
  private final alo a;
  
  public ald(alo paramalo)
  {
    if (paramalo != null)
    {
      this.a = paramalo;
      return;
    }
    throw new IllegalArgumentException("delegate == null");
  }
  
  public final alq a()
  {
    return this.a.a();
  }
  
  public void a_(akz paramakz, long paramLong)
  {
    this.a.a_(paramakz, paramLong);
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
 * Qualified Name:     com.tencent.token.ald
 * JD-Core Version:    0.7.0.1
 */