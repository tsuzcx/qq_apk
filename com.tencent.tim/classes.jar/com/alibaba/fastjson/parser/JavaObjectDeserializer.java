package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

class JavaObjectDeserializer
  implements ObjectDeserializer
{
  public static final JavaObjectDeserializer instance = new JavaObjectDeserializer();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    if ((paramType instanceof GenericArrayType))
    {
      paramObject = ((GenericArrayType)paramType).getGenericComponentType();
      paramType = paramObject;
      if ((paramObject instanceof TypeVariable)) {
        paramType = ((TypeVariable)paramObject).getBounds()[0];
      }
      paramObject = new ArrayList();
      paramDefaultJSONParser.parseArray(paramType, paramObject);
      if ((paramType instanceof Class))
      {
        paramDefaultJSONParser = (Object[])Array.newInstance((Class)paramType, paramObject.size());
        paramObject.toArray(paramDefaultJSONParser);
        return paramDefaultJSONParser;
      }
      return paramObject.toArray();
    }
    return paramDefaultJSONParser.parse(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.parser.JavaObjectDeserializer
 * JD-Core Version:    0.7.0.1
 */