package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;

public abstract interface ExtraTypeProvider
  extends ParseProcess
{
  public abstract Type getExtraType(Object paramObject, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider
 * JD-Core Version:    0.7.0.1
 */