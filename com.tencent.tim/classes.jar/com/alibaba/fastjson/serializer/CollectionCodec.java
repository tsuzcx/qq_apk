package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class CollectionCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final CollectionCodec instance = new CollectionCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    if (paramDefaultJSONParser.lexer.token() == 8)
    {
      paramDefaultJSONParser.lexer.nextToken(16);
      return null;
    }
    if (paramType == JSONArray.class)
    {
      paramType = new JSONArray();
      paramDefaultJSONParser.parseArray(paramType);
      return paramType;
    }
    Object localObject1 = paramType;
    if ((localObject1 instanceof Class))
    {
      localObject2 = (Class)localObject1;
      if ((localObject2 != AbstractCollection.class) && (localObject2 != Collection.class)) {
        break label148;
      }
      localObject1 = new ArrayList();
    }
    for (;;)
    {
      if ((paramType instanceof ParameterizedType))
      {
        paramType = ((ParameterizedType)paramType).getActualTypeArguments()[0];
        paramDefaultJSONParser.parseArray(paramType, (Collection)localObject1, paramObject);
        return localObject1;
        if ((localObject1 instanceof ParameterizedType))
        {
          localObject1 = ((ParameterizedType)localObject1).getRawType();
          break;
        }
        throw new JSONException("TODO");
        label148:
        if (((Class)localObject2).isAssignableFrom(HashSet.class))
        {
          localObject1 = new HashSet();
          continue;
        }
        if (((Class)localObject2).isAssignableFrom(LinkedHashSet.class))
        {
          localObject1 = new LinkedHashSet();
          continue;
        }
        if (((Class)localObject2).isAssignableFrom(TreeSet.class))
        {
          localObject1 = new TreeSet();
          continue;
        }
        if (((Class)localObject2).isAssignableFrom(ArrayList.class))
        {
          localObject1 = new ArrayList();
          continue;
        }
        if (((Class)localObject2).isAssignableFrom(EnumSet.class))
        {
          if ((paramType instanceof ParameterizedType)) {}
          for (localObject1 = ((ParameterizedType)paramType).getActualTypeArguments()[0];; localObject1 = Object.class)
          {
            localObject1 = EnumSet.noneOf((Class)localObject1);
            break;
          }
        }
        try
        {
          localObject1 = (Collection)((Class)localObject2).newInstance();
        }
        catch (Exception paramDefaultJSONParser)
        {
          throw new JSONException("create instane error, class " + ((Class)localObject2).getName());
        }
      }
    }
    if ((paramType instanceof Class))
    {
      paramType = (Class)paramType;
      if (!paramType.getName().startsWith("java."))
      {
        paramType = paramType.getGenericSuperclass();
        if (!(paramType instanceof ParameterizedType)) {}
      }
    }
    for (Object localObject2 = ((ParameterizedType)paramType).getActualTypeArguments()[0];; localObject2 = null)
    {
      paramType = (Type)localObject2;
      if (localObject2 != null) {
        break;
      }
      paramType = Object.class;
      break;
    }
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
    throws IOException
  {
    int i = 0;
    SerializeWriter localSerializeWriter = paramJSONSerializer.out;
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
    if (((localSerializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) && ((paramType instanceof ParameterizedType))) {}
    for (paramType = ((ParameterizedType)paramType).getActualTypeArguments()[0];; paramType = null)
    {
      Object localObject = (Collection)paramObject1;
      SerialContext localSerialContext = paramJSONSerializer.context;
      paramJSONSerializer.setContext(localSerialContext, paramObject1, paramObject2, 0);
      if ((localSerializeWriter.features & SerializerFeature.WriteClassName.mask) != 0)
      {
        if (HashSet.class != localObject.getClass()) {
          break label198;
        }
        localSerializeWriter.append("Set");
      }
      for (;;)
      {
        int j;
        try
        {
          localSerializeWriter.write(91);
          paramObject1 = ((Collection)localObject).iterator();
          if (paramObject1.hasNext())
          {
            paramObject2 = paramObject1.next();
            j = i + 1;
            if (i != 0) {
              localSerializeWriter.write(44);
            }
            if (paramObject2 == null)
            {
              localSerializeWriter.writeNull();
              i = j;
              continue;
              label198:
              if (TreeSet.class != localObject.getClass()) {
                continue;
              }
              localSerializeWriter.append("TreeSet");
              continue;
            }
            localObject = paramObject2.getClass();
            if (localObject == Integer.class)
            {
              localSerializeWriter.writeInt(((Integer)paramObject2).intValue());
              i = j;
              continue;
            }
            if (localObject == Long.class)
            {
              localSerializeWriter.writeLong(((Long)paramObject2).longValue());
              if ((localSerializeWriter.features & SerializerFeature.WriteClassName.mask) != 0)
              {
                localSerializeWriter.write(76);
                i = j;
              }
            }
            else
            {
              paramJSONSerializer.config.get((Class)localObject).write(paramJSONSerializer, paramObject2, Integer.valueOf(j - 1), paramType);
              i = j;
              continue;
            }
          }
          else
          {
            localSerializeWriter.write(93);
            return;
          }
        }
        finally
        {
          paramJSONSerializer.context = localSerialContext;
        }
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.CollectionCodec
 * JD-Core Version:    0.7.0.1
 */