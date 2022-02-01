package com.alibaba.fastjson;

import java.lang.reflect.Type;

public class TypeReference<T>
{
  protected final Type type = ((java.lang.reflect.ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
  
  public Type getType()
  {
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.TypeReference
 * JD-Core Version:    0.7.0.1
 */