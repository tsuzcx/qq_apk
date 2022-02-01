package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.IdentityHashMap;

public final class ArrayCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final ArrayCodec instance = new ArrayCodec();
  
  private <T> T toObjectArray(DefaultJSONParser paramDefaultJSONParser, Class<?> paramClass, JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return null;
    }
    int j = paramJSONArray.size();
    Object localObject2 = Array.newInstance(paramClass, j);
    int i = 0;
    while (i < j)
    {
      Object localObject1 = paramJSONArray.get(i);
      if (localObject1 == paramJSONArray)
      {
        Array.set(localObject2, i, localObject2);
        i += 1;
      }
      else
      {
        if (paramClass.isArray()) {
          if (!paramClass.isInstance(localObject1)) {}
        }
        for (;;)
        {
          Array.set(localObject2, i, localObject1);
          break;
          localObject1 = toObjectArray(paramDefaultJSONParser, paramClass, (JSONArray)localObject1);
          continue;
          localObject1 = TypeUtils.cast(localObject1, paramClass, paramDefaultJSONParser.config);
        }
      }
    }
    paramJSONArray.setRelatedArray(localObject2);
    paramJSONArray.setComponentType(paramClass);
    return localObject2;
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    Object localObject = paramDefaultJSONParser.lexer;
    int i = ((JSONLexer)localObject).token();
    if (i == 8)
    {
      ((JSONLexer)localObject).nextToken(16);
      return null;
    }
    if (paramType == [C.class)
    {
      if (i == 4)
      {
        paramDefaultJSONParser = ((JSONLexer)localObject).stringVal();
        ((JSONLexer)localObject).nextToken(16);
        return paramDefaultJSONParser.toCharArray();
      }
      if (i == 2)
      {
        paramDefaultJSONParser = ((JSONLexer)localObject).integerValue();
        ((JSONLexer)localObject).nextToken(16);
        return paramDefaultJSONParser.toString().toCharArray();
      }
      return JSON.toJSONString(paramDefaultJSONParser.parse()).toCharArray();
    }
    if (i == 4)
    {
      paramDefaultJSONParser = ((JSONLexer)localObject).bytesValue();
      ((JSONLexer)localObject).nextToken(16);
      return paramDefaultJSONParser;
    }
    paramType = ((Class)paramType).getComponentType();
    localObject = new JSONArray();
    paramDefaultJSONParser.parseArray(paramType, (Collection)localObject, paramObject);
    return toObjectArray(paramDefaultJSONParser, paramType, (JSONArray)localObject);
  }
  
  public final void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
    throws IOException
  {
    int i = 0;
    paramType = null;
    SerializeWriter localSerializeWriter = paramJSONSerializer.out;
    Object[] arrayOfObject = (Object[])paramObject1;
    if (paramObject1 == null)
    {
      if ((localSerializeWriter.features & SerializerFeature.WriteNullListAsEmpty.mask) != 0)
      {
        localSerializeWriter.write("[]");
        return;
      }
      localSerializeWriter.writeNull();
      return;
    }
    int k = arrayOfObject.length;
    int j = k - 1;
    if (j == -1)
    {
      localSerializeWriter.append("[]");
      return;
    }
    SerialContext localSerialContext = paramJSONSerializer.context;
    paramJSONSerializer.setContext(localSerialContext, paramObject1, paramObject2, 0);
    for (;;)
    {
      Object localObject;
      try
      {
        localSerializeWriter.write(91);
        if ((localSerializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0)
        {
          paramJSONSerializer.incrementIndent();
          paramJSONSerializer.println();
          if (i < k)
          {
            if (i != 0)
            {
              localSerializeWriter.write(44);
              paramJSONSerializer.println();
            }
            paramJSONSerializer.write(arrayOfObject[i]);
            i += 1;
            continue;
          }
          paramJSONSerializer.decrementIdent();
          paramJSONSerializer.println();
          localSerializeWriter.write(93);
          return;
        }
        i = 0;
        paramObject2 = null;
        paramObject1 = paramType;
        if (i >= j) {
          break label324;
        }
        localObject = arrayOfObject[i];
        if (localObject == null)
        {
          localSerializeWriter.append("null,");
        }
        else if ((paramJSONSerializer.references != null) && (paramJSONSerializer.references.containsKey(localObject)))
        {
          paramJSONSerializer.writeReference(localObject);
          localSerializeWriter.write(44);
        }
      }
      finally
      {
        paramJSONSerializer.context = localSerialContext;
      }
      paramType = localObject.getClass();
      if (paramType == paramObject1)
      {
        paramObject2.write(paramJSONSerializer, localObject, null, null);
      }
      else
      {
        paramObject2 = paramJSONSerializer.config.get(paramType);
        paramObject2.write(paramJSONSerializer, localObject, null, null);
        paramObject1 = paramType;
        continue;
        label324:
        paramObject1 = arrayOfObject[j];
        if (paramObject1 == null)
        {
          localSerializeWriter.append("null]");
          paramJSONSerializer.context = localSerialContext;
          return;
        }
        if ((paramJSONSerializer.references != null) && (paramJSONSerializer.references.containsKey(paramObject1))) {
          paramJSONSerializer.writeReference(paramObject1);
        }
        for (;;)
        {
          localSerializeWriter.write(93);
          break;
          paramJSONSerializer.writeWithFieldName(paramObject1, Integer.valueOf(j));
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.ArrayCodec
 * JD-Core Version:    0.7.0.1
 */