package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public abstract class FieldDeserializer
{
  public final Class<?> clazz;
  protected long[] enumNameHashCodes;
  protected Enum[] enums;
  public final FieldInfo fieldInfo;
  
  public FieldDeserializer(Class<?> paramClass, FieldInfo paramFieldInfo, int paramInt)
  {
    this.clazz = paramClass;
    this.fieldInfo = paramFieldInfo;
    if (paramFieldInfo == null) {}
    do
    {
      return;
      paramClass = paramFieldInfo.fieldClass;
    } while (!paramClass.isEnum());
    paramClass = (Enum[])paramClass.getEnumConstants();
    paramFieldInfo = new long[paramClass.length];
    this.enumNameHashCodes = new long[paramClass.length];
    paramInt = 0;
    int i;
    while (paramInt < paramClass.length)
    {
      String str = paramClass[paramInt].name();
      long l = -2128831035L;
      i = 0;
      while (i < str.length())
      {
        l = (l ^ str.charAt(i)) * 16777619L;
        i += 1;
      }
      paramFieldInfo[paramInt] = l;
      this.enumNameHashCodes[paramInt] = l;
      paramInt += 1;
    }
    Arrays.sort(this.enumNameHashCodes);
    this.enums = new Enum[paramClass.length];
    paramInt = 0;
    label153:
    if (paramInt < this.enumNameHashCodes.length) {
      i = 0;
    }
    for (;;)
    {
      if (i < paramFieldInfo.length)
      {
        if (this.enumNameHashCodes[paramInt] == paramFieldInfo[i]) {
          this.enums[paramInt] = paramClass[i];
        }
      }
      else
      {
        paramInt += 1;
        break label153;
        break;
      }
      i += 1;
    }
  }
  
  public Enum getEnumByHashCode(long paramLong)
  {
    if (this.enums == null) {}
    int i;
    do
    {
      return null;
      i = Arrays.binarySearch(this.enumNameHashCodes, paramLong);
    } while (i == -1);
    return this.enums[i];
  }
  
  public abstract void parseField(DefaultJSONParser paramDefaultJSONParser, Object paramObject, Type paramType, Map<String, Object> paramMap);
  
  public void setValue(Object paramObject, double paramDouble)
    throws IllegalAccessException
  {
    this.fieldInfo.field.setDouble(paramObject, paramDouble);
  }
  
  public void setValue(Object paramObject, float paramFloat)
    throws IllegalAccessException
  {
    this.fieldInfo.field.setFloat(paramObject, paramFloat);
  }
  
  public void setValue(Object paramObject, int paramInt)
    throws IllegalAccessException
  {
    this.fieldInfo.field.setInt(paramObject, paramInt);
  }
  
  public void setValue(Object paramObject, long paramLong)
    throws IllegalAccessException
  {
    this.fieldInfo.field.setLong(paramObject, paramLong);
  }
  
  public void setValue(Object paramObject1, Object paramObject2)
  {
    if ((paramObject2 == null) && (this.fieldInfo.fieldClass.isPrimitive())) {}
    Method localMethod;
    label154:
    label161:
    do
    {
      do
      {
        Field localField;
        do
        {
          for (;;)
          {
            return;
            localField = this.fieldInfo.field;
            localMethod = this.fieldInfo.method;
            try
            {
              if (!this.fieldInfo.fieldAccess) {
                break label161;
              }
              if (!this.fieldInfo.getOnly) {
                break label154;
              }
              if (Map.class.isAssignableFrom(this.fieldInfo.fieldClass))
              {
                paramObject1 = (Map)localField.get(paramObject1);
                if (paramObject1 == null) {
                  continue;
                }
                paramObject1.putAll((Map)paramObject2);
              }
            }
            catch (Exception paramObject1)
            {
              throw new JSONException("set property error, " + this.fieldInfo.name, paramObject1);
            }
          }
          paramObject1 = (Collection)localField.get(paramObject1);
        } while (paramObject1 == null);
        paramObject1.addAll((Collection)paramObject2);
        return;
        localField.set(paramObject1, paramObject2);
        return;
        if (!this.fieldInfo.getOnly) {
          break label245;
        }
        if (!Map.class.isAssignableFrom(this.fieldInfo.fieldClass)) {
          break;
        }
        paramObject1 = (Map)localMethod.invoke(paramObject1, new Object[0]);
      } while (paramObject1 == null);
      paramObject1.putAll((Map)paramObject2);
      return;
      paramObject1 = (Collection)localMethod.invoke(paramObject1, new Object[0]);
    } while (paramObject1 == null);
    paramObject1.addAll((Collection)paramObject2);
    return;
    label245:
    localMethod.invoke(paramObject1, new Object[] { paramObject2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.parser.deserializer.FieldDeserializer
 * JD-Core Version:    0.7.0.1
 */