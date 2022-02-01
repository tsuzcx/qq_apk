package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.util.FieldInfo;
import java.io.IOException;
import java.lang.reflect.Member;
import java.util.Collection;

public final class FieldSerializer
  implements Comparable<FieldSerializer>
{
  protected final int features;
  public final FieldInfo fieldInfo;
  protected final String format;
  protected char[] name_chars;
  private RuntimeSerializerInfo runtimeInfo;
  protected final boolean writeNull;
  
  public FieldSerializer(FieldInfo paramFieldInfo)
  {
    this.fieldInfo = paramFieldInfo;
    JSONField localJSONField = paramFieldInfo.getAnnotation();
    int i;
    boolean bool;
    if (localJSONField != null)
    {
      localObject2 = localJSONField.serialzeFeatures();
      int j = localObject2.length;
      i = 0;
      bool = false;
      while (i < j)
      {
        if (localObject2[i] == SerializerFeature.WriteMapNullValue) {
          bool = true;
        }
        i += 1;
      }
      localObject2 = localJSONField.format().trim();
      if (((String)localObject2).length() != 0) {
        break label192;
      }
    }
    for (;;)
    {
      this.features = SerializerFeature.of(localJSONField.serialzeFeatures());
      for (;;)
      {
        this.writeNull = bool;
        this.format = localObject1;
        paramFieldInfo = paramFieldInfo.name;
        i = paramFieldInfo.length();
        this.name_chars = new char[i + 3];
        paramFieldInfo.getChars(0, paramFieldInfo.length(), this.name_chars, 1);
        this.name_chars[0] = '"';
        this.name_chars[(i + 1)] = '"';
        this.name_chars[(i + 2)] = ':';
        return;
        this.features = 0;
        bool = false;
        localObject1 = localObject2;
      }
      label192:
      localObject1 = localObject2;
    }
  }
  
  public int compareTo(FieldSerializer paramFieldSerializer)
  {
    return this.fieldInfo.compareTo(paramFieldSerializer.fieldInfo);
  }
  
  public Object getPropertyValue(Object paramObject)
    throws Exception
  {
    try
    {
      paramObject = this.fieldInfo.get(paramObject);
      return paramObject;
    }
    catch (Exception localException)
    {
      if (this.fieldInfo.method == null) {}
    }
    for (paramObject = this.fieldInfo.method;; paramObject = this.fieldInfo.field)
    {
      paramObject = (Member)paramObject;
      paramObject = paramObject.getDeclaringClass().getName() + "." + paramObject.getName();
      throw new JSONException("get property error。 " + paramObject, localException);
    }
  }
  
  public void writePrefix(JSONSerializer paramJSONSerializer)
    throws IOException
  {
    paramJSONSerializer = paramJSONSerializer.out;
    int i = paramJSONSerializer.features;
    if ((SerializerFeature.QuoteFieldNames.mask & i) != 0)
    {
      if ((i & SerializerFeature.UseSingleQuotes.mask) != 0)
      {
        paramJSONSerializer.writeFieldName(this.fieldInfo.name, true);
        return;
      }
      paramJSONSerializer.write(this.name_chars, 0, this.name_chars.length);
      return;
    }
    paramJSONSerializer.writeFieldName(this.fieldInfo.name, true);
  }
  
  public void writeValue(JSONSerializer paramJSONSerializer, Object paramObject)
    throws Exception
  {
    if (this.format != null)
    {
      paramJSONSerializer.writeWithFormat(paramObject, this.format);
      return;
    }
    if (this.runtimeInfo == null) {
      if (paramObject != null) {
        break label101;
      }
    }
    label101:
    for (Object localObject = this.fieldInfo.fieldClass;; localObject = paramObject.getClass())
    {
      this.runtimeInfo = new RuntimeSerializerInfo(paramJSONSerializer.config.get((Class)localObject), (Class)localObject);
      localObject = this.runtimeInfo;
      if (paramObject != null) {
        break label201;
      }
      if (((this.features & SerializerFeature.WriteNullNumberAsZero.mask) == 0) || (!Number.class.isAssignableFrom(((RuntimeSerializerInfo)localObject).runtimeFieldClass))) {
        break;
      }
      paramJSONSerializer.out.write(48);
      return;
    }
    if (((this.features & SerializerFeature.WriteNullBooleanAsFalse.mask) != 0) && (Boolean.class == ((RuntimeSerializerInfo)localObject).runtimeFieldClass))
    {
      paramJSONSerializer.out.write("false");
      return;
    }
    if (((this.features & SerializerFeature.WriteNullListAsEmpty.mask) != 0) && (Collection.class.isAssignableFrom(((RuntimeSerializerInfo)localObject).runtimeFieldClass)))
    {
      paramJSONSerializer.out.write("[]");
      return;
    }
    ((RuntimeSerializerInfo)localObject).fieldSerializer.write(paramJSONSerializer, null, this.fieldInfo.name, ((RuntimeSerializerInfo)localObject).runtimeFieldClass);
    return;
    label201:
    Class localClass = paramObject.getClass();
    if (localClass == ((RuntimeSerializerInfo)localObject).runtimeFieldClass)
    {
      ((RuntimeSerializerInfo)localObject).fieldSerializer.write(paramJSONSerializer, paramObject, this.fieldInfo.name, this.fieldInfo.fieldType);
      return;
    }
    paramJSONSerializer.config.get(localClass).write(paramJSONSerializer, paramObject, this.fieldInfo.name, this.fieldInfo.fieldType);
  }
  
  static class RuntimeSerializerInfo
  {
    ObjectSerializer fieldSerializer;
    Class<?> runtimeFieldClass;
    
    public RuntimeSerializerInfo(ObjectSerializer paramObjectSerializer, Class<?> paramClass)
    {
      this.fieldSerializer = paramObjectSerializer;
      this.runtimeFieldClass = paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.FieldSerializer
 * JD-Core Version:    0.7.0.1
 */