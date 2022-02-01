package com.tencent.token;

public abstract class anx
  implements aoi
{
  private final aoi a;
  
  public anx(aoi paramaoi)
  {
    if (paramaoi != null)
    {
      this.a = paramaoi;
      return;
    }
    throw new IllegalArgumentException("delegate == null");
  }
  
  public final aok a()
  {
    return this.a.a();
  }
  
  public void a_(ant paramant, long paramLong)
  {
    this.a.a_(paramant, paramLong);
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
 * Qualified Name:     com.tencent.token.anx
 * JD-Core Version:    0.7.0.1
 */