package com.alibaba.fastjson.parser.deserializer;

public abstract interface ExtraProcessor
  extends ParseProcess
{
  public abstract void processExtra(Object paramObject1, String paramString, Object paramObject2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.parser.deserializer.ExtraProcessor
 * JD-Core Version:    0.7.0.1
 */