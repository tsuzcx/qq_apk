package com.tencent.token;

public final class j
{
  public long a = 0L;
  public long b = 0L;
  
  public j(long paramLong1, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof j))
    {
      paramObject = (j)paramObject;
      if ((this.a == paramObject.a) && (this.b == paramObject.b)) {
        return true;
      }
    }
    return false;
  }
  
  public final String toString()
  {
    return "[" + this.a + "," + this.b + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.j
 * JD-Core Version:    0.7.0.1
 */