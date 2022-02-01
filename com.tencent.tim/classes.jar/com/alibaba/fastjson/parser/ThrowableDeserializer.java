package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class ThrowableDeserializer
  extends JavaBeanDeserializer
{
  public ThrowableDeserializer(ParserConfig paramParserConfig, Class<?> paramClass)
  {
    super(paramParserConfig, paramClass, paramClass);
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    Object localObject4 = paramDefaultJSONParser.lexer;
    if (((JSONLexer)localObject4).token == 8)
    {
      ((JSONLexer)localObject4).nextToken();
      paramDefaultJSONParser = null;
      return paramDefaultJSONParser;
    }
    label38:
    Object localObject2;
    Object localObject3;
    Object localObject5;
    Object localObject1;
    if (paramDefaultJSONParser.resolveStatus == 2)
    {
      paramDefaultJSONParser.resolveStatus = 0;
      paramObject = null;
      if ((paramType != null) && ((paramType instanceof Class)))
      {
        paramType = (Class)paramType;
        if (Throwable.class.isAssignableFrom(paramType))
        {
          localObject2 = null;
          localObject3 = null;
          localObject5 = new HashMap();
          localObject1 = paramType;
          paramType = paramObject;
          paramObject = localObject3;
        }
      }
    }
    else
    {
      for (;;)
      {
        localObject3 = ((JSONLexer)localObject4).scanSymbol(paramDefaultJSONParser.symbolTable);
        if (localObject3 == null)
        {
          if (((JSONLexer)localObject4).token == 13)
          {
            ((JSONLexer)localObject4).nextToken(16);
            paramDefaultJSONParser = (DefaultJSONParser)localObject1;
            localObject3 = paramType;
            localObject1 = paramObject;
            if (paramDefaultJSONParser != null) {
              break label484;
            }
            paramType = new Exception((String)localObject2, (Throwable)localObject3);
            label146:
            paramDefaultJSONParser = paramType;
            if (localObject1 == null) {
              break;
            }
            paramType.setStackTrace((StackTraceElement[])localObject1);
            return paramType;
            if (((JSONLexer)localObject4).token == 12) {
              break label38;
            }
            throw new JSONException("syntax error");
          }
          if (((JSONLexer)localObject4).token == 16) {
            continue;
          }
        }
        ((JSONLexer)localObject4).nextTokenWithChar(':');
        if ("@type".equals(localObject3)) {
          if (((JSONLexer)localObject4).token == 4)
          {
            localObject3 = TypeUtils.loadClass(((JSONLexer)localObject4).stringVal(), paramDefaultJSONParser.config.defaultClassLoader);
            ((JSONLexer)localObject4).nextToken(16);
            localObject1 = paramType;
            paramType = paramObject;
            paramObject = localObject2;
            localObject2 = localObject1;
            localObject1 = localObject3;
          }
        }
        for (;;)
        {
          if (((JSONLexer)localObject4).token != 13) {
            break label469;
          }
          ((JSONLexer)localObject4).nextToken(16);
          localObject3 = localObject2;
          paramDefaultJSONParser = (DefaultJSONParser)localObject1;
          localObject1 = paramType;
          localObject2 = paramObject;
          break;
          throw new JSONException("syntax error");
          if ("message".equals(localObject3))
          {
            if (((JSONLexer)localObject4).token == 8) {}
            for (localObject2 = null;; localObject2 = ((JSONLexer)localObject4).stringVal())
            {
              ((JSONLexer)localObject4).nextToken();
              localObject3 = paramType;
              paramType = paramObject;
              paramObject = localObject2;
              localObject2 = localObject3;
              break;
              if (((JSONLexer)localObject4).token != 4) {
                break label362;
              }
            }
            label362:
            throw new JSONException("syntax error");
          }
          if ("cause".equals(localObject3))
          {
            localObject3 = (Throwable)deserialze(paramDefaultJSONParser, null, "cause");
            paramType = paramObject;
            paramObject = localObject2;
            localObject2 = localObject3;
          }
          else if ("stackTrace".equals(localObject3))
          {
            localObject3 = (StackTraceElement[])paramDefaultJSONParser.parseObject([Ljava.lang.StackTraceElement.class);
            paramObject = localObject2;
            localObject2 = paramType;
            paramType = (Type)localObject3;
          }
          else
          {
            ((Map)localObject5).put(localObject3, paramDefaultJSONParser.parse());
            localObject3 = paramType;
            paramType = paramObject;
            paramObject = localObject2;
            localObject2 = localObject3;
          }
        }
        label469:
        localObject3 = localObject2;
        localObject2 = paramObject;
        paramObject = paramType;
        paramType = (Type)localObject3;
      }
      label484:
      paramObject = null;
      paramType = null;
    }
    for (;;)
    {
      int i;
      try
      {
        Constructor[] arrayOfConstructor = paramDefaultJSONParser.getConstructors();
        int j = arrayOfConstructor.length;
        i = 0;
        localObject4 = null;
        paramDefaultJSONParser = paramObject;
        if (i < j)
        {
          paramObject = arrayOfConstructor[i];
          if (paramObject.getParameterTypes().length == 0)
          {
            paramDefaultJSONParser = paramType;
            paramType = paramObject;
            break label730;
          }
          if ((paramObject.getParameterTypes().length == 1) && (paramObject.getParameterTypes()[0] == String.class))
          {
            paramType = paramDefaultJSONParser;
            paramDefaultJSONParser = paramObject;
            break label730;
          }
          if ((paramObject.getParameterTypes().length != 2) || (paramObject.getParameterTypes()[0] != String.class) || (paramObject.getParameterTypes()[1] != Throwable.class)) {
            break label716;
          }
          localObject5 = paramDefaultJSONParser;
          localObject4 = paramObject;
          paramDefaultJSONParser = paramType;
          paramType = (Type)localObject5;
          break label730;
        }
        if (localObject4 != null)
        {
          paramDefaultJSONParser = (Throwable)((Constructor)localObject4).newInstance(new Object[] { localObject2, localObject3 });
          paramType = paramDefaultJSONParser;
          if (paramDefaultJSONParser != null) {
            break label146;
          }
          paramType = new Exception((String)localObject2, (Throwable)localObject3);
        }
      }
      catch (Exception paramDefaultJSONParser)
      {
        throw new JSONException("create instance error", paramDefaultJSONParser);
      }
      if (paramType != null)
      {
        paramDefaultJSONParser = (Throwable)paramType.newInstance(new Object[] { localObject2 });
      }
      else if (paramDefaultJSONParser != null)
      {
        paramDefaultJSONParser = (Throwable)paramDefaultJSONParser.newInstance(new Object[0]);
      }
      else
      {
        paramDefaultJSONParser = null;
        continue;
        label716:
        paramObject = paramDefaultJSONParser;
        paramDefaultJSONParser = paramType;
        paramType = paramObject;
        break label730;
        paramType = null;
        break;
        label730:
        i += 1;
        paramObject = paramType;
        paramType = paramDefaultJSONParser;
        paramDefaultJSONParser = paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.parser.ThrowableDeserializer
 * JD-Core Version:    0.7.0.1
 */