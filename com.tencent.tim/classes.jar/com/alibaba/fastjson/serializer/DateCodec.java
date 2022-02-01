package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final DateCodec instance = new DateCodec();
  
  protected <T> T cast(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2, String paramString)
  {
    if (paramObject2 == null) {
      paramObject1 = null;
    }
    do
    {
      return paramObject1;
      paramObject1 = paramObject2;
    } while ((paramObject2 instanceof Date));
    if ((paramObject2 instanceof Number)) {
      return new Date(((Number)paramObject2).longValue());
    }
    if ((paramObject2 instanceof String))
    {
      paramObject1 = (String)paramObject2;
      if (paramObject1.length() == 0) {
        return null;
      }
      paramObject2 = new JSONLexer(paramObject1);
      for (;;)
      {
        try
        {
          if (paramObject2.scanISO8601DateIfMatch(false))
          {
            paramDefaultJSONParser = paramObject2.calendar;
            if (paramType == Calendar.class)
            {
              paramObject2.close();
              return paramDefaultJSONParser;
            }
            paramDefaultJSONParser = paramDefaultJSONParser.getTime();
            paramObject2.close();
            return paramDefaultJSONParser;
          }
          paramObject2.close();
          if (paramString != null) {
            paramDefaultJSONParser = new SimpleDateFormat(paramString);
          }
          paramDefaultJSONParser = paramDefaultJSONParser.getDateFormat();
        }
        finally
        {
          try
          {
            paramDefaultJSONParser = paramDefaultJSONParser.parse(paramObject1);
            return paramDefaultJSONParser;
          }
          catch (ParseException paramDefaultJSONParser)
          {
            return new Date(Long.parseLong(paramObject1));
          }
          paramDefaultJSONParser = finally;
          paramObject2.close();
        }
      }
    }
    throw new JSONException("parse error");
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    return deserialze(paramDefaultJSONParser, paramType, paramObject, null);
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject, String paramString)
  {
    JSONLexer localJSONLexer1 = paramDefaultJSONParser.lexer;
    int i = localJSONLexer1.token();
    Object localObject1;
    if (i == 2)
    {
      localObject1 = Long.valueOf(localJSONLexer1.longValue());
      localJSONLexer1.nextToken(16);
    }
    for (;;)
    {
      paramDefaultJSONParser = cast(paramDefaultJSONParser, paramType, paramObject, localObject1, paramString);
      if ((paramType == Calendar.class) && (!(paramDefaultJSONParser instanceof Calendar))) {
        break;
      }
      return paramDefaultJSONParser;
      Object localObject2;
      if (i == 4)
      {
        localObject2 = localJSONLexer1.stringVal();
        localJSONLexer1.nextToken(16);
        localObject1 = localObject2;
        if ((localJSONLexer1.features & Feature.AllowISO8601DateFormat.mask) != 0)
        {
          JSONLexer localJSONLexer2 = new JSONLexer((String)localObject2);
          localObject1 = localObject2;
          if (localJSONLexer2.scanISO8601DateIfMatch(true))
          {
            localObject1 = localJSONLexer2.calendar;
            if (paramType == Calendar.class)
            {
              localJSONLexer2.close();
              return localObject1;
            }
            localObject1 = ((Calendar)localObject1).getTime();
          }
          localJSONLexer2.close();
        }
      }
      else if (i == 8)
      {
        localJSONLexer1.nextToken();
        localObject1 = null;
      }
      else if (i == 12)
      {
        localJSONLexer1.nextToken();
        if (localJSONLexer1.token() == 4)
        {
          localObject1 = paramType;
          if ("@type".equals(localJSONLexer1.stringVal()))
          {
            localJSONLexer1.nextToken();
            paramDefaultJSONParser.accept(17);
            localObject1 = TypeUtils.loadClass(localJSONLexer1.stringVal(), paramDefaultJSONParser.config.defaultClassLoader);
            if (localObject1 != null) {
              paramType = (Type)localObject1;
            }
            paramDefaultJSONParser.accept(4);
            paramDefaultJSONParser.accept(16);
            localObject1 = paramType;
          }
          localJSONLexer1.nextTokenWithChar(':');
          i = localJSONLexer1.token();
          if (i == 2)
          {
            long l = localJSONLexer1.longValue();
            localJSONLexer1.nextToken();
            localObject2 = Long.valueOf(l);
            paramDefaultJSONParser.accept(13);
            paramType = (Type)localObject1;
            localObject1 = localObject2;
          }
        }
        else
        {
          throw new JSONException("syntax error");
        }
        throw new JSONException("syntax error : " + JSONToken.name(i));
      }
      else if (paramDefaultJSONParser.resolveStatus == 2)
      {
        paramDefaultJSONParser.resolveStatus = 0;
        paramDefaultJSONParser.accept(16);
        if (localJSONLexer1.token() == 4)
        {
          if (!"val".equals(localJSONLexer1.stringVal())) {
            throw new JSONException("syntax error");
          }
          localJSONLexer1.nextToken();
          paramDefaultJSONParser.accept(17);
          localObject1 = paramDefaultJSONParser.parse();
          paramDefaultJSONParser.accept(13);
        }
        else
        {
          throw new JSONException("syntax error");
        }
      }
      else
      {
        localObject1 = paramDefaultJSONParser.parse();
      }
    }
    paramDefaultJSONParser = (Date)paramDefaultJSONParser;
    if (paramDefaultJSONParser == null) {
      return null;
    }
    paramType = Calendar.getInstance(localJSONLexer1.timeZone, localJSONLexer1.locale);
    paramType.setTime(paramDefaultJSONParser);
    return paramType;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
    throws IOException
  {
    SerializeWriter localSerializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null)
    {
      localSerializeWriter.writeNull();
      return;
    }
    if (((localSerializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) && (paramObject1.getClass() != paramType))
    {
      if (paramObject1.getClass() == Date.class)
      {
        localSerializeWriter.write("new Date(");
        localSerializeWriter.writeLong(((Date)paramObject1).getTime());
        localSerializeWriter.write(41);
        return;
      }
      localSerializeWriter.write(123);
      localSerializeWriter.writeFieldName("@type", false);
      paramJSONSerializer.write(paramObject1.getClass().getName());
      localSerializeWriter.write(44);
      localSerializeWriter.writeFieldName("val", false);
      localSerializeWriter.writeLong(((Date)paramObject1).getTime());
      localSerializeWriter.write(125);
      return;
    }
    if ((paramObject1 instanceof Calendar)) {}
    for (paramObject1 = ((Calendar)paramObject1).getTime(); (localSerializeWriter.features & SerializerFeature.WriteDateUseDateFormat.mask) != 0; paramObject1 = (Date)paramObject1)
    {
      paramType = paramJSONSerializer.getDateFormat();
      paramObject2 = paramType;
      if (paramType == null)
      {
        paramObject2 = new SimpleDateFormat(JSON.DEFFAULT_DATE_FORMAT, paramJSONSerializer.locale);
        paramObject2.setTimeZone(paramJSONSerializer.timeZone);
      }
      localSerializeWriter.writeString(paramObject2.format(paramObject1));
      return;
    }
    long l = paramObject1.getTime();
    if ((localSerializeWriter.features & SerializerFeature.UseISO8601DateFormat.mask) != 0)
    {
      int i;
      int j;
      int k;
      int m;
      int n;
      int i1;
      if ((localSerializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0)
      {
        localSerializeWriter.write(39);
        paramJSONSerializer = Calendar.getInstance(paramJSONSerializer.timeZone, paramJSONSerializer.locale);
        paramJSONSerializer.setTimeInMillis(l);
        i = paramJSONSerializer.get(1);
        j = paramJSONSerializer.get(2) + 1;
        k = paramJSONSerializer.get(5);
        m = paramJSONSerializer.get(11);
        n = paramJSONSerializer.get(12);
        i1 = paramJSONSerializer.get(13);
        int i2 = paramJSONSerializer.get(14);
        if (i2 == 0) {
          break label452;
        }
        paramJSONSerializer = "0000-00-00T00:00:00.000".toCharArray();
        SerializeWriter.getChars(i2, 23, paramJSONSerializer);
        SerializeWriter.getChars(i1, 19, paramJSONSerializer);
        SerializeWriter.getChars(n, 16, paramJSONSerializer);
        SerializeWriter.getChars(m, 13, paramJSONSerializer);
        SerializeWriter.getChars(k, 10, paramJSONSerializer);
        SerializeWriter.getChars(j, 7, paramJSONSerializer);
        SerializeWriter.getChars(i, 4, paramJSONSerializer);
      }
      for (;;)
      {
        localSerializeWriter.write(paramJSONSerializer);
        if ((localSerializeWriter.features & SerializerFeature.UseSingleQuotes.mask) == 0) {
          break label566;
        }
        localSerializeWriter.write(39);
        return;
        localSerializeWriter.write(34);
        break;
        label452:
        if ((i1 == 0) && (n == 0) && (m == 0))
        {
          paramJSONSerializer = "0000-00-00".toCharArray();
          SerializeWriter.getChars(k, 10, paramJSONSerializer);
          SerializeWriter.getChars(j, 7, paramJSONSerializer);
          SerializeWriter.getChars(i, 4, paramJSONSerializer);
        }
        else
        {
          paramJSONSerializer = "0000-00-00T00:00:00".toCharArray();
          SerializeWriter.getChars(i1, 19, paramJSONSerializer);
          SerializeWriter.getChars(n, 16, paramJSONSerializer);
          SerializeWriter.getChars(m, 13, paramJSONSerializer);
          SerializeWriter.getChars(k, 10, paramJSONSerializer);
          SerializeWriter.getChars(j, 7, paramJSONSerializer);
          SerializeWriter.getChars(i, 4, paramJSONSerializer);
        }
      }
      label566:
      localSerializeWriter.write(34);
      return;
    }
    localSerializeWriter.writeLong(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.DateCodec
 * JD-Core Version:    0.7.0.1
 */