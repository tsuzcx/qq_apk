package com.alibaba.fastjson.serializer;

public abstract interface ValueFilter
  extends SerializeFilter
{
  public abstract Object process(Object paramObject1, String paramString, Object paramObject2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.ValueFilter
 * JD-Core Version:    0.7.0.1
 */