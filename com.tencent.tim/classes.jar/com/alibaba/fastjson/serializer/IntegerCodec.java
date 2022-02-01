package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;

public final class IntegerCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static IntegerCodec instance = new IntegerCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.lexer;
    int i = localJSONLexer.token();
    if (i == 8)
    {
      localJSONLexer.nextToken(16);
      return null;
    }
    if (i == 2)
    {
      if ((paramType == Long.TYPE) || (paramType == Long.class)) {
        paramDefaultJSONParser = Long.valueOf(localJSONLexer.longValue());
      }
      for (;;)
      {
        localJSONLexer.nextToken(16);
        return paramDefaultJSONParser;
        try
        {
          i = localJSONLexer.intValue();
          paramDefaultJSONParser = Integer.valueOf(i);
        }
        catch (NumberFormatException paramDefaultJSONParser)
        {
          throw new JSONException("int value overflow, field : " + paramObject, paramDefaultJSONParser);
        }
      }
    }
    if (i == 3)
    {
      paramDefaultJSONParser = localJSONLexer.decimalValue();
      localJSONLexer.nextToken(16);
      if ((paramType == Long.TYPE) || (paramType == Long.class)) {
        return Long.valueOf(paramDefaultJSONParser.longValue());
      }
      return Integer.valueOf(paramDefaultJSONParser.intValue());
    }
    paramDefaultJSONParser = paramDefaultJSONParser.parse();
    try
    {
      if ((paramType == Long.TYPE) || (paramType == Long.class)) {
        return TypeUtils.castToLong(paramDefaultJSONParser);
      }
      paramType = TypeUtils.castToInt(paramDefaultJSONParser);
      return paramType;
    }
    catch (Exception paramType)
    {
      throw new JSONException("cast error, field : " + paramObject + ", value " + paramDefaultJSONParser, paramType);
    }
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
    throws IOException
  {
    paramJSONSerializer = paramJSONSerializer.out;
    paramObject2 = (Number)paramObject1;
    if (paramObject2 == null) {
      if ((paramJSONSerializer.features & SerializerFeature.WriteNullNumberAsZero.mask) != 0) {
        paramJSONSerializer.write(48);
      }
    }
    label98:
    long l;
    do
    {
      do
      {
        for (;;)
        {
          return;
          paramJSONSerializer.writeNull();
          return;
          if ((paramObject1 instanceof Long)) {
            paramJSONSerializer.writeLong(paramObject2.longValue());
          }
          while ((paramJSONSerializer.features & SerializerFeature.WriteClassName.mask) != 0)
          {
            paramObject1 = paramObject2.getClass();
            if (paramObject1 != Byte.class) {
              break label98;
            }
            paramJSONSerializer.write(66);
            return;
            paramJSONSerializer.writeInt(paramObject2.intValue());
          }
        }
        if (paramObject1 == Short.class)
        {
          paramJSONSerializer.write(83);
          return;
        }
      } while (paramObject1 != Long.class);
      l = paramObject2.longValue();
    } while ((l > 2147483647L) || (l < -2147483648L) || (paramType == Long.class));
    paramJSONSerializer.write(76);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.IntegerCodec
 * JD-Core Version:    0.7.0.1
 */