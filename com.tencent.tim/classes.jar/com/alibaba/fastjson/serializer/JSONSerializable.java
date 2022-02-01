package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

public abstract interface JSONSerializable
{
  public abstract void write(JSONSerializer paramJSONSerializer, Object paramObject, Type paramType)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.JSONSerializable
 * JD-Core Version:    0.7.0.1
 */