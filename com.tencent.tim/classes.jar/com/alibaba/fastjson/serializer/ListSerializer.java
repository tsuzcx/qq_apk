package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.IdentityHashMap;
import java.util.List;

public final class ListSerializer
  implements ObjectSerializer
{
  public final void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
    throws IOException
  {
    SerializeWriter localSerializeWriter = paramJSONSerializer.out;
    int i;
    if ((localSerializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
      i = 1;
    }
    List localList;
    int j;
    SerialContext localSerialContext;
    label214:
    Object localObject1;
    Object localObject2;
    label350:
    label372:
    int k;
    for (;;)
    {
      if ((i != 0) && ((paramType instanceof ParameterizedType)))
      {
        paramType = ((ParameterizedType)paramType).getActualTypeArguments()[0];
        if (paramObject1 == null)
        {
          if ((localSerializeWriter.features & SerializerFeature.WriteNullListAsEmpty.mask) != 0)
          {
            localSerializeWriter.write("[]");
            return;
            i = 0;
          }
          else
          {
            localSerializeWriter.writeNull();
          }
        }
        else
        {
          localList = (List)paramObject1;
          j = localList.size();
          if (j == 0)
          {
            localSerializeWriter.append("[]");
            return;
          }
          localSerialContext = paramJSONSerializer.context;
          if ((localSerializeWriter.features & SerializerFeature.DisableCircularReferenceDetect.mask) == 0)
          {
            paramJSONSerializer.context = new SerialContext(localSerialContext, paramObject1, paramObject2, 0);
            if (paramJSONSerializer.references == null) {
              paramJSONSerializer.references = new IdentityHashMap();
            }
            paramJSONSerializer.references.put(paramObject1, localSerialContext);
          }
          try
          {
            if ((localSerializeWriter.features & SerializerFeature.PrettyFormat.mask) == 0) {
              break label372;
            }
            localSerializeWriter.write(91);
            paramJSONSerializer.incrementIndent();
            i = 0;
            if (i >= j) {
              break label350;
            }
            localObject1 = localList.get(i);
            if (i != 0) {
              localSerializeWriter.write(44);
            }
            paramJSONSerializer.println();
            if (localObject1 != null) {
              if ((paramJSONSerializer.references != null) && (paramJSONSerializer.references.containsKey(localObject1)))
              {
                paramJSONSerializer.writeReference(localObject1);
              }
              else
              {
                localObject2 = paramJSONSerializer.config.get(localObject1.getClass());
                paramJSONSerializer.context = new SerialContext(localSerialContext, paramObject1, paramObject2, 0);
                ((ObjectSerializer)localObject2).write(paramJSONSerializer, localObject1, Integer.valueOf(i), paramType);
              }
            }
          }
          finally
          {
            paramJSONSerializer.context = localSerialContext;
          }
          paramJSONSerializer.out.writeNull();
          break label873;
          paramJSONSerializer.decrementIdent();
          paramJSONSerializer.println();
          localSerializeWriter.write(93);
          paramJSONSerializer.context = localSerialContext;
          return;
          k = localSerializeWriter.count + 1;
          j = k;
          if (k > localSerializeWriter.buf.length)
          {
            if (localSerializeWriter.writer == null)
            {
              localSerializeWriter.expandCapacity(k);
              j = k;
            }
          }
          else
          {
            localSerializeWriter.buf[localSerializeWriter.count] = '[';
            localSerializeWriter.count = j;
            j = 0;
          }
        }
      }
    }
    for (;;)
    {
      if (j < localList.size())
      {
        localObject1 = localList.get(j);
        int m;
        if (j != 0)
        {
          m = localSerializeWriter.count + 1;
          k = m;
          if (m > localSerializeWriter.buf.length)
          {
            if (localSerializeWriter.writer != null) {
              break label556;
            }
            localSerializeWriter.expandCapacity(m);
          }
        }
        for (k = m;; k = 1)
        {
          localSerializeWriter.buf[localSerializeWriter.count] = ',';
          localSerializeWriter.count = k;
          if (localObject1 != null) {
            break label567;
          }
          localSerializeWriter.append("null");
          break label882;
          localSerializeWriter.flush();
          j = 1;
          break;
          label556:
          localSerializeWriter.flush();
        }
        label567:
        localObject2 = localObject1.getClass();
        if (localObject2 == Integer.class)
        {
          localSerializeWriter.writeInt(((Integer)localObject1).intValue());
        }
        else if (localObject2 == Long.class)
        {
          long l = ((Long)localObject1).longValue();
          if (i != 0)
          {
            localSerializeWriter.writeLong(l);
            localSerializeWriter.write(76);
          }
          else
          {
            localSerializeWriter.writeLong(l);
          }
        }
        else if (localObject2 == String.class)
        {
          localObject1 = (String)localObject1;
          if ((localSerializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
            localSerializeWriter.writeStringWithSingleQuote((String)localObject1);
          } else {
            localSerializeWriter.writeStringWithDoubleQuote((String)localObject1, '\000', true);
          }
        }
        else
        {
          if ((localSerializeWriter.features & SerializerFeature.DisableCircularReferenceDetect.mask) == 0) {
            paramJSONSerializer.context = new SerialContext(localSerialContext, paramObject1, paramObject2, 0);
          }
          if ((paramJSONSerializer.references != null) && (paramJSONSerializer.references.containsKey(localObject1))) {
            paramJSONSerializer.writeReference(localObject1);
          } else {
            paramJSONSerializer.config.get(localObject1.getClass()).write(paramJSONSerializer, localObject1, Integer.valueOf(j), paramType);
          }
        }
      }
      else
      {
        j = localSerializeWriter.count + 1;
        i = j;
        if (j > localSerializeWriter.buf.length)
        {
          if (localSerializeWriter.writer != null) {
            break label856;
          }
          localSerializeWriter.expandCapacity(j);
        }
        for (i = j;; i = 1)
        {
          localSerializeWriter.buf[localSerializeWriter.count] = ']';
          localSerializeWriter.count = i;
          paramJSONSerializer.context = localSerialContext;
          return;
          label856:
          localSerializeWriter.flush();
        }
        paramType = null;
        break;
        label873:
        i += 1;
        break label214;
      }
      label882:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.ListSerializer
 * JD-Core Version:    0.7.0.1
 */