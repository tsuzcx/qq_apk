package com.alibaba.fastjson.serializer;

public abstract interface PropertyPreFilter
  extends SerializeFilter
{
  public abstract boolean apply(JSONSerializer paramJSONSerializer, Object paramObject, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.PropertyPreFilter
 * JD-Core Version:    0.7.0.1
 */