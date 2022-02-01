package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;

public class EnumDeserializer
  implements ObjectDeserializer
{
  private final Class<?> enumClass;
  protected final Enum[] values;
  
  public EnumDeserializer(Class<?> paramClass)
  {
    this.enumClass = paramClass;
    this.values = ((Enum[])paramClass.getEnumConstants());
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    try
    {
      paramType = paramDefaultJSONParser.lexer;
      i = paramType.token;
      if (i == 2)
      {
        i = paramType.intValue();
        paramType.nextToken(16);
        if ((i < 0) || (i > this.values.length)) {
          throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + i);
        }
      }
    }
    catch (JSONException paramDefaultJSONParser)
    {
      int i;
      throw paramDefaultJSONParser;
      return this.values[i];
      if (i == 4)
      {
        paramDefaultJSONParser = paramType.stringVal();
        paramType.nextToken(16);
        if (paramDefaultJSONParser.length() == 0) {
          break label207;
        }
        return Enum.valueOf(this.enumClass, paramDefaultJSONParser);
      }
      if (i == 8)
      {
        paramType.nextToken(16);
        return null;
      }
    }
    catch (Exception paramDefaultJSONParser)
    {
      throw new JSONException(paramDefaultJSONParser.getMessage(), paramDefaultJSONParser);
    }
    paramDefaultJSONParser = paramDefaultJSONParser.parse();
    throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + paramDefaultJSONParser);
    label207:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.parser.EnumDeserializer
 * JD-Core Version:    0.7.0.1
 */