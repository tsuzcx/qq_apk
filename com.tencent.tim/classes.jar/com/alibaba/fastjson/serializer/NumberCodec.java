package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class NumberCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final NumberCodec instance = new NumberCodec();
  private DecimalFormat decimalFormat = null;
  
  private NumberCodec() {}
  
  public NumberCodec(String paramString)
  {
    this(new DecimalFormat(paramString));
  }
  
  public NumberCodec(DecimalFormat paramDecimalFormat)
  {
    this.decimalFormat = paramDecimalFormat;
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.lexer;
    int i = localJSONLexer.token();
    if (i == 2) {
      if ((paramType == Double.TYPE) || (paramType == Double.class))
      {
        paramDefaultJSONParser = localJSONLexer.numberString();
        localJSONLexer.nextToken(16);
        paramDefaultJSONParser = Double.valueOf(Double.parseDouble(paramDefaultJSONParser));
      }
    }
    do
    {
      return paramDefaultJSONParser;
      if ((paramType == Float.TYPE) || (paramType == Float.class))
      {
        paramDefaultJSONParser = localJSONLexer.numberString();
        localJSONLexer.nextToken(16);
        return Float.valueOf(Float.parseFloat(paramDefaultJSONParser));
      }
      long l = localJSONLexer.longValue();
      localJSONLexer.nextToken(16);
      if ((paramType == Short.TYPE) || (paramType == Short.class)) {
        return Short.valueOf((short)(int)l);
      }
      if ((paramType == Byte.TYPE) || (paramType == Byte.class)) {
        return Byte.valueOf((byte)(int)l);
      }
      if ((l >= -2147483648L) && (l <= 2147483647L)) {
        return Integer.valueOf((int)l);
      }
      return Long.valueOf(l);
      if (i != 3) {
        break label307;
      }
      if ((paramType == Double.TYPE) || (paramType == Double.class))
      {
        paramDefaultJSONParser = localJSONLexer.numberString();
        localJSONLexer.nextToken(16);
        return Double.valueOf(Double.parseDouble(paramDefaultJSONParser));
      }
      if ((paramType == Float.TYPE) || (paramType == Float.class))
      {
        paramDefaultJSONParser = localJSONLexer.numberString();
        localJSONLexer.nextToken(16);
        return Float.valueOf(Float.parseFloat(paramDefaultJSONParser));
      }
      paramObject = localJSONLexer.decimalValue();
      localJSONLexer.nextToken(16);
      if ((paramType == Short.TYPE) || (paramType == Short.class)) {
        return Short.valueOf(paramObject.shortValue());
      }
      if (paramType == Byte.TYPE) {
        break;
      }
      paramDefaultJSONParser = paramObject;
    } while (paramType != Byte.class);
    return Byte.valueOf(paramObject.byteValue());
    label307:
    paramDefaultJSONParser = paramDefaultJSONParser.parse();
    if (paramDefaultJSONParser == null) {
      return null;
    }
    if ((paramType == Double.TYPE) || (paramType == Double.class)) {
      return TypeUtils.castToDouble(paramDefaultJSONParser);
    }
    if ((paramType == Float.TYPE) || (paramType == Float.class)) {
      return TypeUtils.castToFloat(paramDefaultJSONParser);
    }
    if ((paramType == Short.TYPE) || (paramType == Short.class)) {
      return TypeUtils.castToShort(paramDefaultJSONParser);
    }
    if ((paramType == Byte.TYPE) || (paramType == Byte.class)) {
      return TypeUtils.castToByte(paramDefaultJSONParser);
    }
    return TypeUtils.castToBigDecimal(paramDefaultJSONParser);
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
    throws IOException
  {
    paramObject2 = paramJSONSerializer.out;
    if (paramObject1 == null) {
      if ((paramObject2.features & SerializerFeature.WriteNullNumberAsZero.mask) != 0) {
        paramObject2.write(48);
      }
    }
    do
    {
      return;
      paramObject2.writeNull();
      return;
      if (!(paramObject1 instanceof Float)) {
        break;
      }
      float f = ((Float)paramObject1).floatValue();
      if (Float.isNaN(f))
      {
        paramObject2.writeNull();
        return;
      }
      if (Float.isInfinite(f))
      {
        paramObject2.writeNull();
        return;
      }
      paramObject1 = Float.toString(f);
      paramJSONSerializer = paramObject1;
      if (paramObject1.endsWith(".0")) {
        paramJSONSerializer = paramObject1.substring(0, paramObject1.length() - 2);
      }
      paramObject2.write(paramJSONSerializer);
    } while ((paramObject2.features & SerializerFeature.WriteClassName.mask) == 0);
    paramObject2.write(70);
    return;
    double d = ((Double)paramObject1).doubleValue();
    if (Double.isNaN(d))
    {
      paramObject2.writeNull();
      return;
    }
    if (Double.isInfinite(d))
    {
      paramObject2.writeNull();
      return;
    }
    if (this.decimalFormat == null)
    {
      paramObject1 = Double.toString(d);
      paramJSONSerializer = paramObject1;
      if (!paramObject1.endsWith(".0")) {}
    }
    for (paramJSONSerializer = paramObject1.substring(0, paramObject1.length() - 2);; paramJSONSerializer = this.decimalFormat.format(d))
    {
      paramObject2.append(paramJSONSerializer);
      if ((paramObject2.features & SerializerFeature.WriteClassName.mask) == 0) {
        break;
      }
      paramObject2.write(68);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.NumberCodec
 * JD-Core Version:    0.7.0.1
 */