package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.lang.reflect.Type;

public abstract interface ObjectDeserializer
{
  public abstract <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
 * JD-Core Version:    0.7.0.1
 */