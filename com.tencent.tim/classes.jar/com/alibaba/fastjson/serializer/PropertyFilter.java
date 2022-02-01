package com.alibaba.fastjson.serializer;

public abstract interface PropertyFilter
  extends SerializeFilter
{
  public abstract boolean apply(Object paramObject1, String paramString, Object paramObject2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.PropertyFilter
 * JD-Core Version:    0.7.0.1
 */