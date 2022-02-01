package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JavaBeanSerializer
  implements ObjectSerializer
{
  private static final char[] false_chars = { 102, 97, 108, 115, 101 };
  private static final char[] true_chars = { 116, 114, 117, 101 };
  protected int features = 0;
  private final FieldSerializer[] getters;
  private final FieldSerializer[] sortedGetters;
  protected String typeName;
  
  public JavaBeanSerializer(Class<?> paramClass)
  {
    this(paramClass, (PropertyNamingStrategy)null);
  }
  
  public JavaBeanSerializer(Class<?> paramClass, int paramInt, Map<String, String> paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, PropertyNamingStrategy paramPropertyNamingStrategy)
  {
    if (paramBoolean2) {}
    for (JSONType localJSONType = (JSONType)paramClass.getAnnotation(JSONType.class);; localJSONType = null)
    {
      if (localJSONType != null)
      {
        this.features = SerializerFeature.of(localJSONType.serialzeFeatures());
        this.typeName = localJSONType.typeName();
        if (this.typeName.length() == 0) {
          this.typeName = null;
        }
      }
      Object localObject2 = TypeUtils.computeGetters(paramClass, paramInt, paramBoolean1, localJSONType, paramMap, false, paramBoolean3, paramBoolean4, paramPropertyNamingStrategy);
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add(new FieldSerializer((FieldInfo)((Iterator)localObject2).next()));
      }
    }
    this.getters = ((FieldSerializer[])((List)localObject1).toArray(new FieldSerializer[((List)localObject1).size()]));
    Object localObject1 = null;
    if (localJSONType != null) {
      localObject1 = localJSONType.orders();
    }
    if ((localObject1 != null) && (localObject1.length != 0))
    {
      paramMap = TypeUtils.computeGetters(paramClass, paramInt, paramBoolean1, localJSONType, paramMap, true, paramBoolean3, paramBoolean4, paramPropertyNamingStrategy);
      paramClass = new ArrayList();
      paramMap = paramMap.iterator();
      while (paramMap.hasNext()) {
        paramClass.add(new FieldSerializer((FieldInfo)paramMap.next()));
      }
      this.sortedGetters = ((FieldSerializer[])paramClass.toArray(new FieldSerializer[paramClass.size()]));
      return;
    }
    paramClass = new FieldSerializer[this.getters.length];
    System.arraycopy(this.getters, 0, paramClass, 0, this.getters.length);
    Arrays.sort(paramClass);
    if (Arrays.equals(paramClass, this.getters))
    {
      this.sortedGetters = this.getters;
      return;
    }
    this.sortedGetters = paramClass;
  }
  
  public JavaBeanSerializer(Class<?> paramClass, PropertyNamingStrategy paramPropertyNamingStrategy)
  {
    this(paramClass, paramClass.getModifiers(), (Map)null, false, true, true, true, paramPropertyNamingStrategy);
  }
  
  public JavaBeanSerializer(Class<?> paramClass, String... paramVarArgs)
  {
    this(paramClass, paramClass.getModifiers(), map(paramVarArgs), false, true, true, true, null);
  }
  
  private static Map<String, String> map(String... paramVarArgs)
  {
    HashMap localHashMap = new HashMap();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      localHashMap.put(str, str);
      i += 1;
    }
    return localHashMap;
  }
  
  public Map<String, Object> getFieldValuesMap(Object paramObject)
    throws Exception
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(this.sortedGetters.length);
    FieldSerializer[] arrayOfFieldSerializer = this.sortedGetters;
    int j = arrayOfFieldSerializer.length;
    int i = 0;
    while (i < j)
    {
      FieldSerializer localFieldSerializer = arrayOfFieldSerializer[i];
      localLinkedHashMap.put(localFieldSerializer.fieldInfo.name, localFieldSerializer.getPropertyValue(paramObject));
      i += 1;
    }
    return localLinkedHashMap;
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
    if (((paramJSONSerializer.context == null) || ((paramJSONSerializer.context.features & SerializerFeature.DisableCircularReferenceDetect.mask) == 0)) && (paramJSONSerializer.references != null) && (paramJSONSerializer.references.containsKey(paramObject1)))
    {
      paramJSONSerializer.writeReference(paramObject1);
      return;
    }
    FieldSerializer[] arrayOfFieldSerializer;
    if ((localSerializeWriter.features & SerializerFeature.SortField.mask) != 0) {
      arrayOfFieldSerializer = this.sortedGetters;
    }
    SerialContext localSerialContext;
    int i3;
    label188:
    label197:
    int j;
    label206:
    int m;
    int k;
    int n;
    Object localObject1;
    label434:
    label503:
    label510:
    int i4;
    label517:
    label528:
    label561:
    int i5;
    label579:
    int i6;
    label597:
    int i7;
    label624:
    FieldSerializer localFieldSerializer;
    FieldInfo localFieldInfo;
    Class localClass;
    String str;
    label746:
    boolean bool;
    long l;
    int i1;
    label816:
    label993:
    Object localObject3;
    for (;;)
    {
      localSerialContext = paramJSONSerializer.context;
      if ((localSerializeWriter.features & SerializerFeature.DisableCircularReferenceDetect.mask) == 0)
      {
        paramJSONSerializer.context = new SerialContext(localSerialContext, paramObject1, paramObject2, this.features);
        if (paramJSONSerializer.references == null) {
          paramJSONSerializer.references = new IdentityHashMap();
        }
        paramJSONSerializer.references.put(paramObject1, paramJSONSerializer.context);
      }
      if (((this.features & SerializerFeature.BeanToArray.mask) != 0) || ((localSerializeWriter.features & SerializerFeature.BeanToArray.mask) != 0))
      {
        i3 = 1;
        if (i3 == 0) {
          break label503;
        }
        i = 91;
        if (i3 == 0) {
          break label510;
        }
        j = 93;
      }
      try
      {
        m = localSerializeWriter.count + 1;
        k = m;
        if (m > localSerializeWriter.buf.length)
        {
          if (localSerializeWriter.writer != null) {
            break label517;
          }
          localSerializeWriter.expandCapacity(m);
        }
        for (k = m;; k = 1)
        {
          localSerializeWriter.buf[localSerializeWriter.count] = i;
          localSerializeWriter.count = k;
          if ((arrayOfFieldSerializer.length > 0) && ((localSerializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0))
          {
            paramJSONSerializer.incrementIndent();
            paramJSONSerializer.println();
          }
          n = 0;
          if ((this.features & SerializerFeature.WriteClassName.mask) != 0) {
            break label2564;
          }
          if ((localSerializeWriter.features & SerializerFeature.WriteClassName.mask) == 0) {
            break label2582;
          }
          if ((paramType != null) || ((localSerializeWriter.features & SerializerFeature.NotWriteRootClassName.mask) == 0)) {
            break label2564;
          }
          if (paramJSONSerializer.context.parent == null) {
            break label2582;
          }
          break label2564;
          m = n;
          if (k == 0) {
            break label2570;
          }
          m = n;
          if (paramObject1.getClass() == paramType) {
            break label2570;
          }
          localSerializeWriter.writeFieldName(paramJSONSerializer.config.typeKey, false);
          localObject1 = this.typeName;
          paramType = (Type)localObject1;
          if (localObject1 == null) {
            paramType = paramObject1.getClass().getName();
          }
          paramJSONSerializer.write(paramType);
          m = 1;
          break label2570;
          k = i;
          if (paramJSONSerializer.beforeFilters == null) {
            break label2598;
          }
          paramType = paramJSONSerializer.beforeFilters.iterator();
          while (paramType.hasNext()) {
            i = ((BeforeFilter)paramType.next()).writeBefore(paramJSONSerializer, paramObject1, i);
          }
          arrayOfFieldSerializer = this.getters;
          break;
          i3 = 0;
          break label188;
          i = 123;
          break label197;
          j = 125;
          break label206;
          localSerializeWriter.flush();
        }
        if (((localSerializeWriter.features & SerializerFeature.QuoteFieldNames.mask) == 0) || ((localSerializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0)) {
          break label2626;
        }
        i4 = 1;
        if ((localSerializeWriter.features & SerializerFeature.UseSingleQuotes.mask) == 0) {
          break label2632;
        }
        i5 = 1;
        if ((localSerializeWriter.features & SerializerFeature.NotWriteDefaultValue.mask) == 0) {
          break label2638;
        }
        i6 = 1;
        localList1 = paramJSONSerializer.propertyFilters;
        localList2 = paramJSONSerializer.nameFilters;
        localList3 = paramJSONSerializer.valueFilters;
        List localList4 = paramJSONSerializer.propertyPreFilters;
        i7 = 0;
        if (i7 >= arrayOfFieldSerializer.length) {
          break label2347;
        }
        localFieldSerializer = arrayOfFieldSerializer[i7];
        localFieldInfo = localFieldSerializer.fieldInfo;
        localClass = localFieldInfo.fieldClass;
        str = localFieldInfo.name;
        if (((localSerializeWriter.features & SerializerFeature.SkipTransientField.mask) != 0) && (localFieldInfo.field != null) && (localFieldInfo.fieldTransient)) {
          break label2611;
        }
        if (localList4 == null) {
          break label2558;
        }
        paramType = localList4.iterator();
        do
        {
          if (!paramType.hasNext()) {
            break;
          }
        } while (((PropertyPreFilter)paramType.next()).apply(paramJSONSerializer, paramObject1, str));
        m = 0;
      }
      catch (Exception paramType)
      {
        List localList1;
        List localList2;
        List localList3;
        paramObject1 = "write javaBean error";
        if (paramObject2 == null) {
          break label1636;
        }
        paramObject1 = "write javaBean error" + ", fieldName : " + paramObject2;
        throw new JSONException(paramObject1, paramType);
      }
      finally
      {
        paramJSONSerializer.context = localSerialContext;
      }
    }
    if (localFieldInfo.fieldAccess) {
      if (localClass == Integer.TYPE)
      {
        n = localFieldInfo.field.getInt(paramObject1);
        bool = false;
        l = 0L;
        paramType = null;
        i1 = 1;
        m = 0;
        if (localList1 == null) {
          break label2552;
        }
        if (i1 == 0) {
          break label2549;
        }
        if (localClass != Integer.TYPE) {
          break label993;
        }
        paramType = Integer.valueOf(n);
        m = 1;
      }
    }
    int i2;
    for (;;)
    {
      localObject1 = localList1.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      } while (((PropertyFilter)((Iterator)localObject1).next()).apply(paramObject1, str, paramType));
      i2 = 0;
      break label2652;
      if (localClass == Long.TYPE)
      {
        l = localFieldInfo.field.getLong(paramObject1);
        bool = false;
        n = 0;
        paramType = null;
        i1 = 1;
        m = 0;
        break;
      }
      if (localClass == Boolean.TYPE)
      {
        bool = localFieldInfo.field.getBoolean(paramObject1);
        l = 0L;
        n = 0;
        paramType = null;
        i1 = 1;
        m = 0;
        break;
      }
      paramType = localFieldInfo.field.get(paramObject1);
      bool = false;
      l = 0L;
      n = 0;
      i1 = 0;
      m = 1;
      break;
      paramType = localFieldSerializer.getPropertyValue(paramObject1);
      bool = false;
      l = 0L;
      n = 0;
      i1 = 0;
      m = 1;
      break;
      if (localClass == Long.TYPE)
      {
        paramType = Long.valueOf(l);
        m = 1;
      }
      else
      {
        if (localClass != Boolean.TYPE) {
          break label2549;
        }
        paramType = Boolean.valueOf(bool);
        m = 1;
      }
    }
    label1035:
    label1068:
    Object localObject2;
    if (localList2 != null) {
      if ((i1 != 0) && (m == 0))
      {
        if (localClass == Integer.TYPE)
        {
          m = 1;
          paramType = Integer.valueOf(n);
        }
        for (;;)
        {
          localObject2 = localList2.iterator();
          for (localObject1 = str; ((Iterator)localObject2).hasNext(); localObject1 = ((NameFilter)((Iterator)localObject2).next()).process(paramObject1, (String)localObject1, paramType)) {}
          if (localClass == Long.TYPE)
          {
            m = 1;
            paramType = Long.valueOf(l);
          }
          else
          {
            if (localClass != Boolean.TYPE) {
              break;
            }
            m = 1;
            paramType = Boolean.valueOf(bool);
          }
        }
        label1158:
        if (localList3 != null) {
          if ((i1 != 0) && (m == 0))
          {
            if (localClass == Integer.TYPE)
            {
              paramType = Integer.valueOf(n);
              m = 1;
              localObject1 = paramType;
            }
            for (;;)
            {
              label1195:
              localObject3 = localList3.iterator();
              while (((Iterator)localObject3).hasNext()) {
                localObject1 = ((ValueFilter)((Iterator)localObject3).next()).process(paramObject1, str, localObject1);
              }
              if (localClass == Long.TYPE)
              {
                paramType = Long.valueOf(l);
                m = 1;
                localObject1 = paramType;
              }
              else
              {
                if (localClass != Boolean.TYPE) {
                  break;
                }
                paramType = Boolean.valueOf(bool);
                m = 1;
                localObject1 = paramType;
              }
            }
            label1289:
            if (((m != 0) && (paramType == null) && (i3 == 0) && (!localFieldSerializer.writeNull) && ((localSerializeWriter.features & SerializerFeature.WriteMapNullValue.mask) == 0)) || ((m != 0) && (paramType != null) && (i6 != 0) && (((localClass == Byte.TYPE) || (localClass == Short.TYPE) || (localClass == Integer.TYPE) || (localClass == Long.TYPE) || (localClass == Float.TYPE) || (localClass == Double.TYPE)) && ((((paramType instanceof Number)) && (((Number)paramType).byteValue() == 0)) || ((localClass == Boolean.TYPE) && ((paramType instanceof Boolean)) && (!((Boolean)paramType).booleanValue())))))) {
              break label2611;
            }
            if (k != 0)
            {
              i2 = localSerializeWriter.count + 1;
              k = i2;
              if (i2 > localSerializeWriter.buf.length)
              {
                if (localSerializeWriter.writer != null) {
                  break label1561;
                }
                localSerializeWriter.expandCapacity(i2);
              }
            }
            for (k = i2;; k = 1)
            {
              localSerializeWriter.buf[localSerializeWriter.count] = ',';
              localSerializeWriter.count = k;
              if ((localSerializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
                paramJSONSerializer.println();
              }
              if (localObject2 == str) {
                break;
              }
              if (i3 == 0) {
                localSerializeWriter.writeFieldName((String)localObject2, true);
              }
              paramJSONSerializer.write(paramType);
              break label2682;
              label1561:
              localSerializeWriter.flush();
            }
            if (localObject1 != paramType)
            {
              if (i3 == 0) {
                localFieldSerializer.writePrefix(paramJSONSerializer);
              }
              paramJSONSerializer.write(paramType);
              break label2682;
            }
            label1636:
            int i8;
            int i9;
            if (i3 == 0)
            {
              if (i4 == 0) {
                break label1904;
              }
              localObject1 = localFieldSerializer.name_chars;
              int i12 = 0;
              int i10 = 0;
              k = localObject1.length;
              int i11 = localSerializeWriter.count + k;
              i2 = i11;
              i8 = k;
              i9 = i10;
              if (i11 > localSerializeWriter.buf.length)
              {
                i2 = k;
                i8 = i12;
                if (localSerializeWriter.writer != null) {
                  break label1815;
                }
                localSerializeWriter.expandCapacity(i11);
                i9 = i10;
                i8 = k;
                i2 = i11;
              }
              System.arraycopy(localObject1, i9, localSerializeWriter.buf, localSerializeWriter.count, i8);
              localSerializeWriter.count = i2;
            }
            for (;;)
            {
              if ((i1 != 0) && (m == 0))
              {
                if (localClass == Integer.TYPE)
                {
                  if (n != -2147483648) {
                    break label2695;
                  }
                  localSerializeWriter.write("-2147483648");
                  break label2682;
                  label1815:
                  i9 = localSerializeWriter.buf.length - localSerializeWriter.count;
                  System.arraycopy(localObject1, i8, localSerializeWriter.buf, localSerializeWriter.count, i9);
                  localSerializeWriter.count = localSerializeWriter.buf.length;
                  localSerializeWriter.flush();
                  k = i2 - i9;
                  i8 += i9;
                  if (k > localSerializeWriter.buf.length) {
                    break label2688;
                  }
                  i9 = i8;
                  i8 = k;
                  i2 = k;
                  break;
                  label1904:
                  localFieldSerializer.writePrefix(paramJSONSerializer);
                  continue;
                  label1913:
                  if (k > SerializeWriter.sizeTable[m]) {
                    break label2718;
                  }
                  k = m + 1;
                  if (n >= 0) {
                    break label2516;
                  }
                  k += 1;
                  label1941:
                  i1 = 0;
                  i2 = localSerializeWriter.count + k;
                  m = i1;
                  if (i2 > localSerializeWriter.buf.length)
                  {
                    if (localSerializeWriter.writer != null) {
                      break label2016;
                    }
                    localSerializeWriter.expandCapacity(i2);
                  }
                  for (m = i1; m == 0; m = 1)
                  {
                    SerializeWriter.getChars(n, i2, localSerializeWriter.buf);
                    localSerializeWriter.count = i2;
                    break;
                    label2016:
                    paramType = new char[k];
                    SerializeWriter.getChars(n, k, paramType);
                    localSerializeWriter.write(paramType, 0, paramType.length);
                  }
                }
                if (localClass == Long.TYPE)
                {
                  paramJSONSerializer.out.writeLong(l);
                  break label2682;
                }
                if (localClass != Boolean.TYPE) {
                  break label2682;
                }
                if (bool)
                {
                  paramJSONSerializer.out.write(true_chars, 0, true_chars.length);
                  break label2682;
                }
                paramJSONSerializer.out.write(false_chars, 0, false_chars.length);
                break label2682;
              }
            }
            if (i3 == 0)
            {
              if (localClass == String.class)
              {
                if (paramType == null)
                {
                  if (((localSerializeWriter.features & SerializerFeature.WriteNullStringAsEmpty.mask) != 0) || ((localFieldSerializer.features & SerializerFeature.WriteNullStringAsEmpty.mask) != 0))
                  {
                    localSerializeWriter.writeString("");
                    break label2682;
                  }
                  localSerializeWriter.writeNull();
                  break label2682;
                }
                paramType = (String)paramType;
                if (i5 != 0)
                {
                  localSerializeWriter.writeStringWithSingleQuote(paramType);
                  break label2682;
                }
                localSerializeWriter.writeStringWithDoubleQuote(paramType, '\000', true);
                break label2682;
              }
              if (localFieldInfo.isEnum)
              {
                if (paramType != null)
                {
                  if ((localSerializeWriter.features & SerializerFeature.WriteEnumUsingToString.mask) != 0)
                  {
                    paramType = ((Enum)paramType).toString();
                    if ((localSerializeWriter.features & SerializerFeature.UseSingleQuotes.mask) == 0) {
                      break label2727;
                    }
                    k = 1;
                    label2274:
                    if (k != 0)
                    {
                      localSerializeWriter.writeStringWithSingleQuote(paramType);
                      break label2682;
                    }
                    localSerializeWriter.writeStringWithDoubleQuote(paramType, '\000', false);
                    break label2682;
                  }
                  localSerializeWriter.writeInt(((Enum)paramType).ordinal());
                  break label2682;
                }
                localSerializeWriter.writeNull();
                break label2682;
              }
              localFieldSerializer.writeValue(paramJSONSerializer, paramType);
              break label2682;
            }
            localFieldSerializer.writeValue(paramJSONSerializer, paramType);
            break label2682;
            label2347:
            if (paramJSONSerializer.afterFilters != null) {
              if (k == 0) {
                break label2733;
              }
            }
          }
        }
      }
    }
    label2564:
    label2570:
    label2582:
    label2598:
    label2727:
    label2733:
    for (int i = 44;; i = 0)
    {
      paramType = paramJSONSerializer.afterFilters.iterator();
      while (paramType.hasNext()) {
        i = ((AfterFilter)paramType.next()).writeAfter(paramJSONSerializer, paramObject1, i);
      }
      if ((arrayOfFieldSerializer.length > 0) && ((localSerializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0))
      {
        paramJSONSerializer.decrementIdent();
        paramJSONSerializer.println();
      }
      m = localSerializeWriter.count + 1;
      k = m;
      if (m > localSerializeWriter.buf.length)
      {
        if (localSerializeWriter.writer != null) {
          break label2505;
        }
        localSerializeWriter.expandCapacity(m);
      }
      for (k = m;; k = 1)
      {
        localSerializeWriter.buf[localSerializeWriter.count] = j;
        localSerializeWriter.count = k;
        paramJSONSerializer.context = localSerialContext;
        return;
        label2505:
        localSerializeWriter.flush();
      }
      label2516:
      break label1941;
      localObject1 = paramType;
      break label1195;
      localObject1 = paramType;
      break label1289;
      break label1068;
      localObject2 = str;
      break label1158;
      i2 = 1;
      break label2652;
      label2549:
      break label816;
      label2552:
      i2 = 1;
      break label2652;
      label2558:
      m = 1;
      break label2644;
      k = 1;
      break;
      if (m != 0)
      {
        i = 44;
        break label434;
        k = 0;
        break;
      }
      i = 0;
      break label434;
      k = i;
      if (k == 44)
      {
        k = 1;
        break label528;
      }
      for (;;)
      {
        label2611:
        i7 += 1;
        break label624;
        k = 0;
        break;
        label2626:
        i4 = 0;
        break label561;
        label2632:
        i5 = 0;
        break label579;
        label2638:
        i6 = 0;
        break label597;
        label2644:
        if (m != 0) {
          break label746;
        }
        continue;
        label2652:
        if (i2 != 0) {
          break label1035;
        }
        continue;
        localObject2 = localObject1;
        break label1158;
        localObject3 = paramType;
        paramType = (Type)localObject1;
        localObject1 = localObject3;
        break label1289;
        label2682:
        k = 1;
      }
      i2 = k;
      break label1815;
      if (n < 0) {}
      for (k = -n;; k = n)
      {
        m = 0;
        break;
      }
      m += 1;
      break label1913;
      k = 0;
      break label2274;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.JavaBeanSerializer
 * JD-Core Version:    0.7.0.1
 */