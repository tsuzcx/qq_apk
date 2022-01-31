package com.qq.taf.jce.dynamic;

public class DoubleField
  extends NumberField
{
  private double data;
  
  DoubleField(double paramDouble, int paramInt)
  {
    super(paramInt);
    this.data = paramDouble;
  }
  
  public double get()
  {
    return this.data;
  }
  
  public Number getNumber()
  {
    return Double.valueOf(this.data);
  }
  
  public void set(double paramDouble)
  {
    this.data = paramDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.qq.taf.jce.dynamic.DoubleField
 * JD-Core Version:    0.7.0.1
 */