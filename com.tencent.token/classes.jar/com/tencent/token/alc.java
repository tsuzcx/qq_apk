package com.tencent.token;

public abstract class alc
  implements aln
{
  private final aln a;
  
  public alc(aln paramaln)
  {
    if (paramaln != null)
    {
      this.a = paramaln;
      return;
    }
    throw new IllegalArgumentException("delegate == null");
  }
  
  public final alp a()
  {
    return this.a.a();
  }
  
  public void a_(aky paramaky, long paramLong)
  {
    this.a.a_(paramaky, paramLong);
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
 * Qualified Name:     com.tencent.token.alc
 * JD-Core Version:    0.7.0.1
 */