package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;

public final class BooleanCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final BooleanCodec instance = new BooleanCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    paramType = paramDefaultJSONParser.lexer;
    int i = paramType.token();
    if (i == 6)
    {
      paramType.nextToken(16);
      return Boolean.TRUE;
    }
    if (i == 7)
    {
      paramType.nextToken(16);
      return Boolean.FALSE;
    }
    if (i == 2)
    {
      i = paramType.intValue();
      paramType.nextToken(16);
      if (i == 1) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    paramDefaultJSONParser = paramDefaultJSONParser.parse();
    if (paramDefaultJSONParser == null) {
      return null;
    }
    return TypeUtils.castToBoolean(paramDefaultJSONParser);
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
    throws IOException
  {
    paramJSONSerializer = paramJSONSerializer.out;
    paramObject1 = (Boolean)paramObject1;
    if (paramObject1 == null)
    {
      if ((paramJSONSerializer.features & SerializerFeature.WriteNullBooleanAsFalse.mask) != 0)
      {
        paramJSONSerializer.write("false");
        return;
      }
      paramJSONSerializer.writeNull();
      return;
    }
    if (paramObject1.booleanValue())
    {
      paramJSONSerializer.write("true");
      return;
    }
    paramJSONSerializer.write("false");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.BooleanCodec
 * JD-Core Version:    0.7.0.1
 */