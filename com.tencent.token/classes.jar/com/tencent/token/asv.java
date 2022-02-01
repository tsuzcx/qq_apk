package com.tencent.token;

public final class asv
{
  int a;
  String b;
  private int c;
  
  public asv() {}
  
  public asv(String paramString, int paramInt1, int paramInt2)
  {
    this.c = paramInt2;
    this.b = paramString;
    this.a = paramInt1;
  }
  
  protected final Object clone()
  {
    return new asv(this.b, this.a, this.c);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (asv)paramObject;
    return (paramObject.b.equals(this.b)) && (paramObject.a == this.a);
  }
  
  public final int hashCode()
  {
    return super.hashCode();
  }
  
  public final String toString()
  {
    if (this.a >= 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append(":");
      localStringBuilder.append(this.a);
      return localStringBuilder.toString();
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.asv
 * JD-Core Version:    0.7.0.1
 */