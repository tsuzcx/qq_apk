package com.alibaba.fastjson.serializer;

public class SerialContext
{
  public final int features;
  public final Object fieldName;
  public final Object object;
  public final SerialContext parent;
  
  public SerialContext(SerialContext paramSerialContext, Object paramObject1, Object paramObject2, int paramInt)
  {
    this.parent = paramSerialContext;
    this.object = paramObject1;
    this.fieldName = paramObject2;
    this.features = paramInt;
  }
  
  public String toString()
  {
    if (this.parent == null) {
      return "$";
    }
    if ((this.fieldName instanceof Integer)) {
      return this.parent.toString() + "[" + this.fieldName + "]";
    }
    return this.parent.toString() + "." + this.fieldName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.SerialContext
 * JD-Core Version:    0.7.0.1
 */