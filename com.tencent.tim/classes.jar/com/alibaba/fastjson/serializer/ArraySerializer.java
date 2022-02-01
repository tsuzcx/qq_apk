package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

final class ArraySerializer
  implements ObjectSerializer
{
  private final ObjectSerializer compObjectSerializer;
  private final Class<?> componentType;
  
  ArraySerializer(Class<?> paramClass, ObjectSerializer paramObjectSerializer)
  {
    this.componentType = paramClass;
    this.compObjectSerializer = paramObjectSerializer;
  }
  
  public final void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
    throws IOException
  {
    int j = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int k = 0;
    int i = 0;
    paramType = paramJSONSerializer.out;
    if (paramObject1 == null)
    {
      if ((paramType.features & SerializerFeature.WriteNullListAsEmpty.mask) != 0)
      {
        paramType.write("[]");
        return;
      }
      paramType.writeNull();
      return;
    }
    if ((paramObject1 instanceof boolean[]))
    {
      paramJSONSerializer = (boolean[])paramObject1;
      paramType.write(91);
      i = 0;
      while (i < paramJSONSerializer.length)
      {
        if (i != 0) {
          paramType.write(44);
        }
        paramType.write(paramJSONSerializer[i]);
        i += 1;
      }
      paramType.write(93);
      return;
    }
    if ((paramObject1 instanceof byte[]))
    {
      paramType.writeByteArray((byte[])paramObject1);
      return;
    }
    if ((paramObject1 instanceof char[]))
    {
      paramType.writeString(new String((char[])paramObject1));
      return;
    }
    if ((paramObject1 instanceof double[]))
    {
      paramJSONSerializer = (double[])paramObject1;
      j = paramJSONSerializer.length - 1;
      if (j == -1)
      {
        paramType.append("[]");
        return;
      }
      paramType.write(91);
      if (i < j)
      {
        d = paramJSONSerializer[i];
        if (Double.isNaN(d)) {
          paramType.writeNull();
        }
        for (;;)
        {
          paramType.write(44);
          i += 1;
          break;
          paramType.append(Double.toString(d));
        }
      }
      double d = paramJSONSerializer[j];
      if (Double.isNaN(d)) {
        paramType.writeNull();
      }
      for (;;)
      {
        paramType.write(93);
        return;
        paramType.append(Double.toString(d));
      }
    }
    if ((paramObject1 instanceof float[]))
    {
      paramJSONSerializer = (float[])paramObject1;
      k = paramJSONSerializer.length - 1;
      if (k == -1)
      {
        paramType.append("[]");
        return;
      }
      paramType.write(91);
      i = j;
      if (i < k)
      {
        f = paramJSONSerializer[i];
        if (Float.isNaN(f)) {
          paramType.writeNull();
        }
        for (;;)
        {
          paramType.write(44);
          i += 1;
          break;
          paramType.append(Float.toString(f));
        }
      }
      float f = paramJSONSerializer[k];
      if (Float.isNaN(f)) {
        paramType.writeNull();
      }
      for (;;)
      {
        paramType.write(93);
        return;
        paramType.append(Float.toString(f));
      }
    }
    if ((paramObject1 instanceof int[]))
    {
      paramJSONSerializer = (int[])paramObject1;
      paramType.write(91);
      i = m;
      while (i < paramJSONSerializer.length)
      {
        if (i != 0) {
          paramType.write(44);
        }
        paramType.writeInt(paramJSONSerializer[i]);
        i += 1;
      }
      paramType.write(93);
      return;
    }
    if ((paramObject1 instanceof long[]))
    {
      paramJSONSerializer = (long[])paramObject1;
      paramType.write(91);
      i = n;
      while (i < paramJSONSerializer.length)
      {
        if (i != 0) {
          paramType.write(44);
        }
        paramType.writeLong(paramJSONSerializer[i]);
        i += 1;
      }
      paramType.write(93);
      return;
    }
    if ((paramObject1 instanceof short[]))
    {
      paramJSONSerializer = (short[])paramObject1;
      paramType.write(91);
      i = i1;
      while (i < paramJSONSerializer.length)
      {
        if (i != 0) {
          paramType.write(44);
        }
        paramType.writeInt(paramJSONSerializer[i]);
        i += 1;
      }
      paramType.write(93);
      return;
    }
    Object[] arrayOfObject = (Object[])paramObject1;
    j = arrayOfObject.length;
    SerialContext localSerialContext = paramJSONSerializer.context;
    paramJSONSerializer.setContext(localSerialContext, paramObject1, paramObject2, 0);
    for (;;)
    {
      try
      {
        paramType.write(91);
        i = k;
        if (i >= j) {
          break label818;
        }
        if (i != 0) {
          paramType.write(44);
        }
        paramObject1 = arrayOfObject[i];
        if (paramObject1 == null) {
          paramType.append("null");
        } else if (paramObject1.getClass() == this.componentType) {
          this.compObjectSerializer.write(paramJSONSerializer, paramObject1, Integer.valueOf(i), null);
        }
      }
      finally
      {
        paramJSONSerializer.context = localSerialContext;
      }
      paramJSONSerializer.config.get(paramObject1.getClass()).write(paramJSONSerializer, paramObject1, Integer.valueOf(i), null);
      break label832;
      label818:
      paramType.write(93);
      paramJSONSerializer.context = localSerialContext;
      return;
      label832:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.ArraySerializer
 * JD-Core Version:    0.7.0.1
 */