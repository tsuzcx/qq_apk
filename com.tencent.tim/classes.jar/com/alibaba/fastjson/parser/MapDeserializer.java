package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class MapDeserializer
  implements ObjectDeserializer
{
  public static MapDeserializer instance = new MapDeserializer();
  
  public static Object parseMap(DefaultJSONParser paramDefaultJSONParser, Map<Object, Object> paramMap, Type paramType1, Type paramType2, Object paramObject)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.lexer;
    int i = localJSONLexer.token;
    if ((i != 12) && (i != 16)) {
      throw new JSONException("syntax error, expect {, actual " + JSONToken.name(i));
    }
    ObjectDeserializer localObjectDeserializer1 = paramDefaultJSONParser.config.getDeserializer(paramType1);
    ObjectDeserializer localObjectDeserializer2 = paramDefaultJSONParser.config.getDeserializer(paramType2);
    localJSONLexer.nextToken();
    paramObject = paramDefaultJSONParser.contex;
    for (;;)
    {
      try
      {
        i = localJSONLexer.token;
        if (i == 13)
        {
          localJSONLexer.nextToken(16);
          return paramMap;
        }
        if ((i != 4) || (localJSONLexer.sp != 4) || (!localJSONLexer.text.startsWith("$ref", localJSONLexer.np + 1)) || (localJSONLexer.isEnabled(Feature.DisableSpecialKeyDetect))) {
          break label345;
        }
        paramMap = null;
        localJSONLexer.nextTokenWithChar(':');
        if (localJSONLexer.token != 4) {
          break label299;
        }
        paramType1 = localJSONLexer.stringVal();
        if ("..".equals(paramType1))
        {
          paramMap = paramObject.parent.object;
          localJSONLexer.nextToken(13);
          if (localJSONLexer.token == 13) {
            break label330;
          }
          throw new JSONException("illegal ref");
        }
      }
      finally
      {
        paramDefaultJSONParser.setContext(paramObject);
      }
      if ("$".equals(paramType1))
      {
        for (paramMap = paramObject; paramMap.parent != null; paramMap = paramMap.parent) {}
        paramMap = paramMap.object;
      }
      else
      {
        paramDefaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(paramObject, paramType1));
        paramDefaultJSONParser.resolveStatus = 1;
        continue;
        label299:
        throw new JSONException("illegal ref, " + JSONToken.name(i));
        label330:
        localJSONLexer.nextToken(16);
        paramDefaultJSONParser.setContext(paramObject);
        return paramMap;
        label345:
        if ((paramMap.size() == 0) && (i == 4) && ("@type".equals(localJSONLexer.stringVal())) && (!localJSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)))
        {
          localJSONLexer.nextTokenWithChar(':');
          localJSONLexer.nextToken(16);
          if (localJSONLexer.token == 13)
          {
            localJSONLexer.nextToken();
            paramDefaultJSONParser.setContext(paramObject);
            return paramMap;
          }
          localJSONLexer.nextToken();
        }
        Object localObject1 = localObjectDeserializer1.deserialze(paramDefaultJSONParser, paramType1, null);
        if (localJSONLexer.token != 17) {
          throw new JSONException("syntax error, expect :, actual " + localJSONLexer.token);
        }
        localJSONLexer.nextToken();
        Object localObject2 = localObjectDeserializer2.deserialze(paramDefaultJSONParser, paramType2, localObject1);
        if (paramDefaultJSONParser.resolveStatus == 1) {
          paramDefaultJSONParser.checkMapResolve(paramMap, localObject1);
        }
        paramMap.put(localObject1, localObject2);
        if (localJSONLexer.token == 16) {
          localJSONLexer.nextToken();
        }
      }
    }
  }
  
  public static Map parseMap(DefaultJSONParser paramDefaultJSONParser, Map<String, Object> paramMap, Type paramType, Object paramObject)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.lexer;
    if (localJSONLexer.token != 12) {
      throw new JSONException("syntax error, expect {, actual " + localJSONLexer.token);
    }
    ParseContext localParseContext = paramDefaultJSONParser.contex;
    int i;
    label339:
    label505:
    do
    {
      Object localObject1;
      do
      {
        try
        {
          localJSONLexer.skipWhitespace();
          for (i = localJSONLexer.ch; i == 44; i = localJSONLexer.ch)
          {
            localJSONLexer.next();
            localJSONLexer.skipWhitespace();
          }
          if (i == 34)
          {
            localObject1 = localJSONLexer.scanSymbol(paramDefaultJSONParser.symbolTable, '"');
            localJSONLexer.skipWhitespace();
            if (localJSONLexer.ch == ':') {
              break label339;
            }
            throw new JSONException("syntax error, " + localJSONLexer.info());
          }
        }
        finally
        {
          paramDefaultJSONParser.setContext(localParseContext);
        }
        if (i == 125)
        {
          localJSONLexer.next();
          localJSONLexer.sp = 0;
          localJSONLexer.nextToken(16);
          paramDefaultJSONParser.setContext(localParseContext);
          return paramMap;
        }
        if (i == 39)
        {
          localObject1 = localJSONLexer.scanSymbol(paramDefaultJSONParser.symbolTable, '\'');
          localJSONLexer.skipWhitespace();
          if (localJSONLexer.ch != ':') {
            throw new JSONException("syntax error, " + localJSONLexer.info());
          }
        }
        else
        {
          localObject1 = localJSONLexer.scanSymbolUnQuoted(paramDefaultJSONParser.symbolTable);
          localJSONLexer.skipWhitespace();
          char c = localJSONLexer.ch;
          if (c != ':') {
            throw new JSONException("expect ':' at " + localJSONLexer.pos + ", actual " + c);
          }
        }
        localJSONLexer.next();
        localJSONLexer.skipWhitespace();
        i = localJSONLexer.ch;
        localJSONLexer.sp = 0;
        if ((localObject1 != "@type") || (localJSONLexer.isEnabled(Feature.DisableSpecialKeyDetect))) {
          break label505;
        }
        localObject1 = TypeUtils.loadClass(localJSONLexer.scanSymbol(paramDefaultJSONParser.symbolTable, '"'), paramDefaultJSONParser.config.defaultClassLoader);
        if (localObject1 != paramMap.getClass()) {
          break;
        }
        localJSONLexer.nextToken(16);
      } while (localJSONLexer.token != 13);
      localJSONLexer.nextToken(16);
      paramDefaultJSONParser.setContext(localParseContext);
      return paramMap;
      paramMap = paramDefaultJSONParser.config.getDeserializer((Type)localObject1);
      localJSONLexer.nextToken(16);
      paramDefaultJSONParser.resolveStatus = 2;
      if ((localParseContext != null) && (!(paramObject instanceof Integer))) {
        paramDefaultJSONParser.popContext();
      }
      paramMap = (Map)paramMap.deserialze(paramDefaultJSONParser, (Type)localObject1, paramObject);
      paramDefaultJSONParser.setContext(localParseContext);
      return paramMap;
      localJSONLexer.nextToken();
      paramDefaultJSONParser.setContext(localParseContext);
      Object localObject2;
      if (localJSONLexer.token == 8)
      {
        localObject2 = null;
        localJSONLexer.nextToken();
      }
      for (;;)
      {
        paramMap.put(localObject1, localObject2);
        if (paramDefaultJSONParser.resolveStatus == 1) {
          paramDefaultJSONParser.checkMapResolve(paramMap, localObject1);
        }
        paramDefaultJSONParser.setContext(localParseContext, localObject2, localObject1);
        i = localJSONLexer.token;
        if ((i != 20) && (i != 15)) {
          break;
        }
        paramDefaultJSONParser.setContext(localParseContext);
        return paramMap;
        localObject2 = paramDefaultJSONParser.parseObject(paramType, localObject1);
      }
    } while (i != 13);
    localJSONLexer.nextToken();
    paramDefaultJSONParser.setContext(localParseContext);
    return paramMap;
  }
  
  protected Map<?, ?> createMap(Type paramType)
  {
    if (paramType == Properties.class) {
      return new Properties();
    }
    if (paramType == Hashtable.class) {
      return new Hashtable();
    }
    if (paramType == IdentityHashMap.class) {
      return new IdentityHashMap();
    }
    if ((paramType == SortedMap.class) || (paramType == TreeMap.class)) {
      return new TreeMap();
    }
    if ((paramType == ConcurrentMap.class) || (paramType == ConcurrentHashMap.class)) {
      return new ConcurrentHashMap();
    }
    if ((paramType == Map.class) || (paramType == HashMap.class)) {
      return new HashMap();
    }
    if (paramType == LinkedHashMap.class) {
      return new LinkedHashMap();
    }
    if (paramType == JSONObject.class) {
      return new JSONObject();
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = (ParameterizedType)paramType;
      localObject = paramType.getRawType();
      if (EnumMap.class.equals(localObject)) {
        return new EnumMap((Class)paramType.getActualTypeArguments()[0]);
      }
      return createMap((Type)localObject);
    }
    Object localObject = (Class)paramType;
    if (((Class)localObject).isInterface()) {
      throw new JSONException("unsupport type " + paramType);
    }
    try
    {
      localObject = (Map)((Class)localObject).newInstance();
      return localObject;
    }
    catch (Exception localException)
    {
      throw new JSONException("unsupport type " + paramType, localException);
    }
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    if ((paramType == JSONObject.class) && (paramDefaultJSONParser.fieldTypeResolver == null)) {
      return paramDefaultJSONParser.parseObject();
    }
    Object localObject1 = paramDefaultJSONParser.lexer;
    if (((JSONLexer)localObject1).token == 8)
    {
      ((JSONLexer)localObject1).nextToken(16);
      return null;
    }
    Map localMap = createMap(paramType);
    localObject1 = paramDefaultJSONParser.contex;
    try
    {
      paramDefaultJSONParser.setContext((ParseContext)localObject1, localMap, paramObject);
      if ((paramType instanceof ParameterizedType))
      {
        Object localObject2 = (ParameterizedType)paramType;
        paramType = localObject2.getActualTypeArguments()[0];
        localObject2 = localObject2.getActualTypeArguments()[1];
        if (String.class == paramType)
        {
          paramType = parseMap(paramDefaultJSONParser, localMap, (Type)localObject2, paramObject);
          return paramType;
        }
        paramType = parseMap(paramDefaultJSONParser, localMap, paramType, (Type)localObject2, paramObject);
        return paramType;
      }
      paramType = paramDefaultJSONParser.parseObject(localMap, paramObject);
      return paramType;
    }
    finally
    {
      paramDefaultJSONParser.setContext((ParseContext)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.parser.MapDeserializer
 * JD-Core Version:    0.7.0.1
 */