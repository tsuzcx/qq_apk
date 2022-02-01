package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;

public abstract interface FieldTypeResolver
  extends ParseProcess
{
  public abstract Type resolve(Object paramObject, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.parser.deserializer.FieldTypeResolver
 * JD-Core Version:    0.7.0.1
 */