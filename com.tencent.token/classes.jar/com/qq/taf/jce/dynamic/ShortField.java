package com.qq.taf.jce.dynamic;

public final class ShortField
  extends NumberField
{
  private short data;
  
  ShortField(short paramShort, int paramInt)
  {
    super(paramInt);
    this.data = paramShort;
  }
  
  public final short get()
  {
    return this.data;
  }
  
  public final Number getNumber()
  {
    return Short.valueOf(this.data);
  }
  
  public final void set(short paramShort)
  {
    this.data = paramShort;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.qq.taf.jce.dynamic.ShortField
 * JD-Core Version:    0.7.0.1
 */