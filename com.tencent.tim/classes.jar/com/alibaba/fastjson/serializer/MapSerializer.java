package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public final class MapSerializer
  implements ObjectSerializer
{
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
    throws IOException
  {
    SerializeWriter localSerializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null)
    {
      localSerializeWriter.writeNull();
      return;
    }
    paramType = (Map)paramObject1;
    Object localObject1 = paramType.getClass();
    if (((localObject1 == JSONObject.class) || (localObject1 == HashMap.class) || (localObject1 == LinkedHashMap.class)) && (paramType.containsKey("@type"))) {}
    for (int j = 1;; j = 0)
    {
      if (((localSerializeWriter.features & SerializerFeature.SortField.mask) == 0) || ((paramType instanceof SortedMap)) || ((paramType instanceof LinkedHashMap))) {
        break label618;
      }
      try
      {
        localObject1 = new TreeMap(paramType);
        paramType = (Type)localObject1;
      }
      catch (Exception localException)
      {
        label111:
        break label111;
        localSerialContext = paramJSONSerializer.context;
        paramJSONSerializer.setContext(localSerialContext, paramObject1, paramObject2, 0);
      }
      if ((paramJSONSerializer.references == null) || (!paramJSONSerializer.references.containsKey(paramObject1))) {
        break;
      }
      paramJSONSerializer.writeReference(paramObject1);
      return;
    }
    for (;;)
    {
      SerialContext localSerialContext;
      Object localObject4;
      Object localObject5;
      try
      {
        localSerializeWriter.write(123);
        paramJSONSerializer.incrementIndent();
        paramObject2 = null;
        localObject2 = null;
        int k = 1;
        i = k;
        if ((localSerializeWriter.features & SerializerFeature.WriteClassName.mask) != 0)
        {
          i = k;
          if (j == 0)
          {
            localSerializeWriter.writeFieldName(paramJSONSerializer.config.typeKey, false);
            localSerializeWriter.writeString(paramObject1.getClass().getName());
            i = 0;
          }
        }
        Iterator localIterator = paramType.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break label571;
        }
        localObject4 = (Map.Entry)localIterator.next();
        localObject3 = ((Map.Entry)localObject4).getValue();
        localObject4 = ((Map.Entry)localObject4).getKey();
        if ((!paramJSONSerializer.applyName(paramObject1, localObject4)) || (!paramJSONSerializer.apply(paramObject1, localObject4, localObject3))) {
          continue;
        }
        localObject4 = paramJSONSerializer.processKey(paramObject1, localObject4, localObject3);
        localObject5 = JSONSerializer.processValue(paramJSONSerializer, paramObject1, localObject4, localObject3);
        if ((localObject5 == null) && ((localSerializeWriter.features & SerializerFeature.WriteMapNullValue.mask) == 0)) {
          continue;
        }
        if ((localObject4 instanceof String))
        {
          localObject3 = (String)localObject4;
          if (i == 0) {
            localSerializeWriter.write(44);
          }
          if ((localSerializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
            paramJSONSerializer.println();
          }
          localSerializeWriter.writeFieldName((String)localObject3, true);
          if (localObject5 != null) {
            break label503;
          }
          localSerializeWriter.writeNull();
          i = 0;
          continue;
        }
        if (i == 0) {
          localSerializeWriter.write(44);
        }
        if (((localSerializeWriter.features & SerializerFeature.BrowserCompatible.mask) != 0) || ((localSerializeWriter.features & SerializerFeature.WriteNonStringKeyAsString.mask) != 0))
        {
          paramJSONSerializer.write(JSON.toJSONString(localObject4));
          localSerializeWriter.write(58);
          continue;
        }
        paramJSONSerializer.write(localObject4);
      }
      finally
      {
        paramJSONSerializer.context = localSerialContext;
      }
      continue;
      label503:
      Object localObject3 = localObject5.getClass();
      if (localObject3 == paramObject2)
      {
        localObject2.write(paramJSONSerializer, localObject5, localObject4, null);
        localObject3 = paramObject2;
        paramObject2 = localObject2;
        localObject2 = localObject3;
      }
      else
      {
        paramObject2 = paramJSONSerializer.config.get((Class)localObject3);
        paramObject2.write(paramJSONSerializer, localObject5, localObject4, null);
        localObject2 = localObject3;
        break label621;
        label571:
        paramJSONSerializer.context = localSerialContext;
        paramJSONSerializer.decrementIdent();
        if (((localSerializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) && (paramType.size() > 0)) {
          paramJSONSerializer.println();
        }
        localSerializeWriter.write(125);
        return;
        label618:
        break;
      }
      label621:
      int i = 0;
      localObject3 = localObject2;
      Object localObject2 = paramObject2;
      paramObject2 = localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.MapSerializer
 * JD-Core Version:    0.7.0.1
 */