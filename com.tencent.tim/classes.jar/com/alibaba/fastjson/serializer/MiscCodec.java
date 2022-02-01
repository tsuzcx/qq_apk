package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Enumeration;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

public final class MiscCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final MiscCodec instance = new MiscCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    if (paramType == StackTraceElement.class) {
      return parseStackTraceElement(paramDefaultJSONParser);
    }
    paramObject = paramDefaultJSONParser.lexer;
    if (paramDefaultJSONParser.resolveStatus == 2)
    {
      paramDefaultJSONParser.resolveStatus = 0;
      paramDefaultJSONParser.accept(16);
      if (paramObject.token() == 4)
      {
        if (!"val".equals(paramObject.stringVal())) {
          throw new JSONException("syntax error");
        }
        paramObject.nextToken();
        paramDefaultJSONParser.accept(17);
        paramObject = paramDefaultJSONParser.parse();
        paramDefaultJSONParser.accept(13);
      }
    }
    while (paramObject == null)
    {
      return null;
      throw new JSONException("syntax error");
      paramObject = paramDefaultJSONParser.parse();
    }
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      if (paramObject.length() == 0) {
        return null;
      }
    }
    else
    {
      throw new JSONException("except string value");
    }
    if (paramType == UUID.class) {
      return UUID.fromString(paramObject);
    }
    if (paramType == Class.class) {
      return TypeUtils.loadClass(paramObject, paramDefaultJSONParser.config.defaultClassLoader);
    }
    if (paramType == Locale.class)
    {
      paramDefaultJSONParser = paramObject.split("_");
      if (paramDefaultJSONParser.length == 1) {
        return new Locale(paramDefaultJSONParser[0]);
      }
      if (paramDefaultJSONParser.length == 2) {
        return new Locale(paramDefaultJSONParser[0], paramDefaultJSONParser[1]);
      }
      return new Locale(paramDefaultJSONParser[0], paramDefaultJSONParser[1], paramDefaultJSONParser[2]);
    }
    if (paramType == URI.class) {
      return URI.create(paramObject);
    }
    if (paramType == URL.class) {
      try
      {
        paramDefaultJSONParser = new URL(paramObject);
        return paramDefaultJSONParser;
      }
      catch (MalformedURLException paramDefaultJSONParser)
      {
        throw new JSONException("create url error", paramDefaultJSONParser);
      }
    }
    if (paramType == Pattern.class) {
      return Pattern.compile(paramObject);
    }
    if (paramType == Charset.class) {
      return Charset.forName(paramObject);
    }
    if (paramType == Currency.class) {
      return Currency.getInstance(paramObject);
    }
    if (paramType == SimpleDateFormat.class)
    {
      paramType = new SimpleDateFormat(paramObject, paramDefaultJSONParser.lexer.locale);
      paramType.setTimeZone(paramDefaultJSONParser.lexer.timeZone);
      return paramType;
    }
    if ((paramType == Character.TYPE) || (paramType == Character.class)) {
      return TypeUtils.castToChar(paramObject);
    }
    return TimeZone.getTimeZone(paramObject);
  }
  
  protected <T> T parseStackTraceElement(DefaultJSONParser paramDefaultJSONParser)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.lexer;
    if (localJSONLexer.token() == 8)
    {
      localJSONLexer.nextToken();
      return null;
    }
    if ((localJSONLexer.token() != 12) && (localJSONLexer.token() != 16)) {
      throw new JSONException("syntax error: " + JSONToken.name(localJSONLexer.token()));
    }
    int j = 0;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject1;
    Object localObject3;
    Object localObject2;
    int i;
    label135:
    do
    {
      localObject1 = localJSONLexer.scanSymbol(paramDefaultJSONParser.symbolTable);
      if (localObject1 != null) {
        break;
      }
      if (localJSONLexer.token() == 13)
      {
        localJSONLexer.nextToken(16);
        localObject3 = localObject6;
        localObject2 = localObject5;
        localObject1 = localObject4;
        i = j;
        return new StackTraceElement((String)localObject3, (String)localObject2, (String)localObject1, i);
      }
    } while (localJSONLexer.token() == 16);
    localJSONLexer.nextTokenWithChar(':');
    if ("className".equals(localObject1)) {
      if (localJSONLexer.token() == 8)
      {
        localObject3 = null;
        localObject2 = localObject5;
        localObject1 = localObject4;
        i = j;
      }
    }
    label612:
    label622:
    do
    {
      String str;
      do
      {
        for (;;)
        {
          j = i;
          localObject4 = localObject1;
          localObject5 = localObject2;
          localObject6 = localObject3;
          if (localJSONLexer.token() != 13) {
            break;
          }
          localJSONLexer.nextToken(16);
          break label135;
          if (localJSONLexer.token() == 4)
          {
            localObject3 = localJSONLexer.stringVal();
            i = j;
            localObject1 = localObject4;
            localObject2 = localObject5;
          }
          else
          {
            throw new JSONException("syntax error");
            if ("methodName".equals(localObject1))
            {
              if (localJSONLexer.token() == 8)
              {
                localObject2 = null;
                i = j;
                localObject1 = localObject4;
                localObject3 = localObject6;
              }
              else if (localJSONLexer.token() == 4)
              {
                localObject2 = localJSONLexer.stringVal();
                i = j;
                localObject1 = localObject4;
                localObject3 = localObject6;
              }
              else
              {
                throw new JSONException("syntax error");
              }
            }
            else if ("fileName".equals(localObject1))
            {
              if (localJSONLexer.token() == 8)
              {
                localObject1 = null;
                i = j;
                localObject2 = localObject5;
                localObject3 = localObject6;
              }
              else if (localJSONLexer.token() == 4)
              {
                localObject1 = localJSONLexer.stringVal();
                i = j;
                localObject2 = localObject5;
                localObject3 = localObject6;
              }
              else
              {
                throw new JSONException("syntax error");
              }
            }
            else if ("lineNumber".equals(localObject1))
            {
              if (localJSONLexer.token() == 8)
              {
                i = 0;
                localObject1 = localObject4;
                localObject2 = localObject5;
                localObject3 = localObject6;
              }
              else if (localJSONLexer.token() == 2)
              {
                i = localJSONLexer.intValue();
                localObject1 = localObject4;
                localObject2 = localObject5;
                localObject3 = localObject6;
              }
              else
              {
                throw new JSONException("syntax error");
              }
            }
            else
            {
              if (!"nativeMethod".equals(localObject1)) {
                break label622;
              }
              if (localJSONLexer.token() == 8)
              {
                localJSONLexer.nextToken(16);
                i = j;
                localObject1 = localObject4;
                localObject2 = localObject5;
                localObject3 = localObject6;
              }
              else if (localJSONLexer.token() == 6)
              {
                localJSONLexer.nextToken(16);
                i = j;
                localObject1 = localObject4;
                localObject2 = localObject5;
                localObject3 = localObject6;
              }
              else
              {
                if (localJSONLexer.token() != 7) {
                  break label612;
                }
                localJSONLexer.nextToken(16);
                i = j;
                localObject1 = localObject4;
                localObject2 = localObject5;
                localObject3 = localObject6;
              }
            }
          }
        }
        throw new JSONException("syntax error");
        if (localObject1 != "@type") {
          break label731;
        }
        if (localJSONLexer.token() != 4) {
          break label697;
        }
        str = localJSONLexer.stringVal();
        i = j;
        localObject1 = localObject4;
        localObject2 = localObject5;
        localObject3 = localObject6;
      } while (str.equals("java.lang.StackTraceElement"));
      throw new JSONException("syntax error : " + str);
      i = j;
      localObject1 = localObject4;
      localObject2 = localObject5;
      localObject3 = localObject6;
    } while (localJSONLexer.token() == 8);
    label697:
    throw new JSONException("syntax error");
    label731:
    throw new JSONException("syntax error : " + (String)localObject1);
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
    throws IOException
  {
    int i = 0;
    SerializeWriter localSerializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null)
    {
      if ((paramType == Character.TYPE) || (paramType == Character.class))
      {
        paramJSONSerializer.write("");
        return;
      }
      if (((localSerializeWriter.features & SerializerFeature.WriteNullListAsEmpty.mask) != 0) && (Enumeration.class.isAssignableFrom(TypeUtils.getClass(paramType))))
      {
        localSerializeWriter.write("[]");
        return;
      }
      localSerializeWriter.writeNull();
      return;
    }
    if ((paramObject1 instanceof Pattern))
    {
      paramJSONSerializer.write(((Pattern)paramObject1).pattern());
      return;
    }
    if ((paramObject1 instanceof TimeZone))
    {
      paramJSONSerializer.write(((TimeZone)paramObject1).getID());
      return;
    }
    if ((paramObject1 instanceof Currency))
    {
      paramJSONSerializer.write(((Currency)paramObject1).getCurrencyCode());
      return;
    }
    if ((paramObject1 instanceof Class))
    {
      paramJSONSerializer.write(((Class)paramObject1).getName());
      return;
    }
    if ((paramObject1 instanceof Character))
    {
      paramObject1 = (Character)paramObject1;
      if (paramObject1.charValue() == 0)
      {
        paramJSONSerializer.write("");
        return;
      }
      paramJSONSerializer.write(paramObject1.toString());
      return;
    }
    if ((paramObject1 instanceof SimpleDateFormat))
    {
      paramObject2 = ((SimpleDateFormat)paramObject1).toPattern();
      if (((localSerializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) && (paramObject1.getClass() != paramType))
      {
        localSerializeWriter.write(123);
        localSerializeWriter.writeFieldName("@type", false);
        paramJSONSerializer.write(paramObject1.getClass().getName());
        localSerializeWriter.write(44);
        localSerializeWriter.writeFieldName("val", false);
        localSerializeWriter.writeString(paramObject2);
        localSerializeWriter.write(125);
        return;
      }
      localSerializeWriter.writeString(paramObject2);
      return;
    }
    if ((paramObject1 instanceof JSONStreamAware))
    {
      ((JSONStreamAware)paramObject1).writeJSONString(paramJSONSerializer.out);
      return;
    }
    if ((paramObject1 instanceof JSONAware))
    {
      localSerializeWriter.write(((JSONAware)paramObject1).toJSONString());
      return;
    }
    if ((paramObject1 instanceof JSONSerializable))
    {
      ((JSONSerializable)paramObject1).write(paramJSONSerializer, paramObject2, paramType);
      return;
    }
    if ((paramObject1 instanceof Enumeration)) {
      if (((localSerializeWriter.features & SerializerFeature.WriteClassName.mask) == 0) || (!(paramType instanceof ParameterizedType))) {
        break label548;
      }
    }
    label548:
    for (paramType = ((ParameterizedType)paramType).getActualTypeArguments()[0];; paramType = null)
    {
      Enumeration localEnumeration = (Enumeration)paramObject1;
      SerialContext localSerialContext = paramJSONSerializer.context;
      paramJSONSerializer.setContext(localSerialContext, paramObject1, paramObject2, 0);
      try
      {
        localSerializeWriter.write(91);
        while (localEnumeration.hasMoreElements())
        {
          paramObject1 = localEnumeration.nextElement();
          int j = i + 1;
          if (i != 0) {
            localSerializeWriter.write(44);
          }
          if (paramObject1 == null)
          {
            localSerializeWriter.writeNull();
            i = j;
          }
          else
          {
            paramObject2 = paramObject1.getClass();
            paramJSONSerializer.config.get(paramObject2).write(paramJSONSerializer, paramObject1, Integer.valueOf(j - 1), paramType);
            i = j;
          }
        }
        localSerializeWriter.write(93);
        return;
      }
      finally
      {
        paramJSONSerializer.context = localSerialContext;
      }
      paramJSONSerializer.write(paramObject1.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.MiscCodec
 * JD-Core Version:    0.7.0.1
 */