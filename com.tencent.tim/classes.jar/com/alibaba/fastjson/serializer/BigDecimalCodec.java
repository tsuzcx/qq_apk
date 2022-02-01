package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;

public class BigDecimalCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final BigDecimalCodec instance = new BigDecimalCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.lexer;
    int i = localJSONLexer.token();
    if (i == 2) {
      if (paramType == BigInteger.class)
      {
        paramDefaultJSONParser = localJSONLexer.numberString();
        localJSONLexer.nextToken(16);
        paramDefaultJSONParser = new BigInteger(paramDefaultJSONParser, 10);
      }
    }
    do
    {
      return paramDefaultJSONParser;
      paramDefaultJSONParser = localJSONLexer.decimalValue();
      localJSONLexer.nextToken(16);
      return paramDefaultJSONParser;
      if (i != 3) {
        break;
      }
      paramObject = localJSONLexer.decimalValue();
      localJSONLexer.nextToken(16);
      paramDefaultJSONParser = paramObject;
    } while (paramType != BigInteger.class);
    return paramObject.toBigInteger();
    paramDefaultJSONParser = paramDefaultJSONParser.parse();
    if (paramDefaultJSONParser == null) {
      return null;
    }
    if (paramType == BigInteger.class) {
      return TypeUtils.castToBigInteger(paramDefaultJSONParser);
    }
    return TypeUtils.castToBigDecimal(paramDefaultJSONParser);
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
    throws IOException
  {
    paramJSONSerializer = paramJSONSerializer.out;
    if (paramObject1 == null) {
      if ((paramJSONSerializer.features & SerializerFeature.WriteNullNumberAsZero.mask) != 0) {
        paramJSONSerializer.write(48);
      }
    }
    do
    {
      return;
      paramJSONSerializer.writeNull();
      return;
      if ((paramObject1 instanceof BigInteger))
      {
        paramJSONSerializer.write(((BigInteger)paramObject1).toString());
        return;
      }
      paramObject1 = (BigDecimal)paramObject1;
      paramJSONSerializer.write(paramObject1.toString());
    } while (((paramJSONSerializer.features & SerializerFeature.WriteClassName.mask) == 0) || (paramType == BigDecimal.class) || (paramObject1.scale() != 0));
    paramJSONSerializer.write(46);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.BigDecimalCodec
 * JD-Core Version:    0.7.0.1
 */