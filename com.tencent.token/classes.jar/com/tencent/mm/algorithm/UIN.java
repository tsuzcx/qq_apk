package com.tencent.mm.algorithm;

public class UIN
  extends Number
{
  private int h;
  
  public double doubleValue()
  {
    double d = this.h | 0L;
    Double.isNaN(d);
    return d + 0.0D;
  }
  
  public float floatValue()
  {
    double d = this.h | 0L;
    Double.isNaN(d);
    return (float)(d + 0.0D);
  }
  
  public int intValue()
  {
    return this.h;
  }
  
  public long longValue()
  {
    return this.h & 0xFFFFFFFF;
  }
  
  public String toString()
  {
    return String.valueOf(this.h & 0xFFFFFFFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.algorithm.UIN
 * JD-Core Version:    0.7.0.1
 */