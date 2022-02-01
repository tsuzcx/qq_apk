package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.ArrayCodec;
import com.alibaba.fastjson.serializer.BigDecimalCodec;
import com.alibaba.fastjson.serializer.BooleanCodec;
import com.alibaba.fastjson.serializer.CollectionCodec;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.MiscCodec;
import com.alibaba.fastjson.serializer.NumberCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IdentityHashMap;
import java.io.Closeable;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

public class ParserConfig
{
  public static ParserConfig global = new ParserConfig();
  public ClassLoader defaultClassLoader;
  private final IdentityHashMap<ObjectDeserializer> derializers = new IdentityHashMap(1024);
  public PropertyNamingStrategy propertyNamingStrategy;
  public final SymbolTable symbolTable = new SymbolTable(16384);
  
  public ParserConfig()
  {
    this.derializers.put(SimpleDateFormat.class, MiscCodec.instance);
    this.derializers.put(java.util.Date.class, DateCodec.instance);
    this.derializers.put(Calendar.class, DateCodec.instance);
    this.derializers.put(Map.class, MapDeserializer.instance);
    this.derializers.put(HashMap.class, MapDeserializer.instance);
    this.derializers.put(LinkedHashMap.class, MapDeserializer.instance);
    this.derializers.put(TreeMap.class, MapDeserializer.instance);
    this.derializers.put(ConcurrentMap.class, MapDeserializer.instance);
    this.derializers.put(ConcurrentHashMap.class, MapDeserializer.instance);
    this.derializers.put(Collection.class, CollectionCodec.instance);
    this.derializers.put(List.class, CollectionCodec.instance);
    this.derializers.put(ArrayList.class, CollectionCodec.instance);
    this.derializers.put(Object.class, JavaObjectDeserializer.instance);
    this.derializers.put(String.class, StringCodec.instance);
    this.derializers.put(Character.TYPE, MiscCodec.instance);
    this.derializers.put(Character.class, MiscCodec.instance);
    this.derializers.put(Byte.TYPE, NumberCodec.instance);
    this.derializers.put(Byte.class, NumberCodec.instance);
    this.derializers.put(Short.TYPE, NumberCodec.instance);
    this.derializers.put(Short.class, NumberCodec.instance);
    this.derializers.put(Integer.TYPE, IntegerCodec.instance);
    this.derializers.put(Integer.class, IntegerCodec.instance);
    this.derializers.put(Long.TYPE, IntegerCodec.instance);
    this.derializers.put(Long.class, IntegerCodec.instance);
    this.derializers.put(BigInteger.class, BigDecimalCodec.instance);
    this.derializers.put(BigDecimal.class, BigDecimalCodec.instance);
    this.derializers.put(Float.TYPE, NumberCodec.instance);
    this.derializers.put(Float.class, NumberCodec.instance);
    this.derializers.put(Double.TYPE, NumberCodec.instance);
    this.derializers.put(Double.class, NumberCodec.instance);
    this.derializers.put(Boolean.TYPE, BooleanCodec.instance);
    this.derializers.put(Boolean.class, BooleanCodec.instance);
    this.derializers.put(Class.class, MiscCodec.instance);
    this.derializers.put([C.class, ArrayCodec.instance);
    this.derializers.put([Ljava.lang.Object.class, ArrayCodec.instance);
    this.derializers.put(UUID.class, MiscCodec.instance);
    this.derializers.put(TimeZone.class, MiscCodec.instance);
    this.derializers.put(Locale.class, MiscCodec.instance);
    this.derializers.put(Currency.class, MiscCodec.instance);
    this.derializers.put(URI.class, MiscCodec.instance);
    this.derializers.put(URL.class, MiscCodec.instance);
    this.derializers.put(Pattern.class, MiscCodec.instance);
    this.derializers.put(Charset.class, MiscCodec.instance);
    this.derializers.put(Number.class, NumberCodec.instance);
    this.derializers.put(StackTraceElement.class, MiscCodec.instance);
    this.derializers.put(Serializable.class, JavaObjectDeserializer.instance);
    this.derializers.put(Cloneable.class, JavaObjectDeserializer.instance);
    this.derializers.put(Comparable.class, JavaObjectDeserializer.instance);
    this.derializers.put(Closeable.class, JavaObjectDeserializer.instance);
  }
  
  public static ParserConfig getGlobalInstance()
  {
    return global;
  }
  
  public static boolean isPrimitive(Class<?> paramClass)
  {
    return (paramClass.isPrimitive()) || (paramClass == Boolean.class) || (paramClass == Character.class) || (paramClass == Byte.class) || (paramClass == Short.class) || (paramClass == Integer.class) || (paramClass == Long.class) || (paramClass == Float.class) || (paramClass == Double.class) || (paramClass == BigInteger.class) || (paramClass == BigDecimal.class) || (paramClass == String.class) || (paramClass == java.util.Date.class) || (paramClass == java.sql.Date.class) || (paramClass == Time.class) || (paramClass == Timestamp.class);
  }
  
  public FieldDeserializer createFieldDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, FieldInfo paramFieldInfo)
  {
    Class localClass = paramFieldInfo.fieldClass;
    if ((localClass == List.class) || (localClass == ArrayList.class) || ((localClass.isArray()) && (!localClass.getComponentType().isPrimitive()))) {
      return new ListTypeFieldDeserializer(paramParserConfig, paramClass, paramFieldInfo);
    }
    return new DefaultFieldDeserializer(paramParserConfig, paramClass, paramFieldInfo);
  }
  
  public ObjectDeserializer getDeserializer(Class<?> paramClass, Type paramType)
  {
    ObjectDeserializer localObjectDeserializer = (ObjectDeserializer)this.derializers.get(paramType);
    if (localObjectDeserializer != null) {
      paramType = localObjectDeserializer;
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return paramType;
          localObject = paramType;
          if (paramType == null) {
            localObject = paramClass;
          }
          localObjectDeserializer = (ObjectDeserializer)this.derializers.get((Type)localObject);
          paramType = localObjectDeserializer;
        } while (localObjectDeserializer != null);
        if (!isPrimitive(paramClass))
        {
          paramType = (JSONType)paramClass.getAnnotation(JSONType.class);
          if (paramType != null)
          {
            paramType = paramType.mappingTo();
            if (paramType != Void.class) {
              return getDeserializer(paramType, paramType);
            }
          }
        }
        if (((localObject instanceof WildcardType)) || ((localObject instanceof TypeVariable)) || ((localObject instanceof ParameterizedType))) {
          localObjectDeserializer = (ObjectDeserializer)this.derializers.get(paramClass);
        }
        paramType = localObjectDeserializer;
      } while (localObjectDeserializer != null);
      localObjectDeserializer = (ObjectDeserializer)this.derializers.get((Type)localObject);
      paramType = localObjectDeserializer;
    } while (localObjectDeserializer != null);
    if (paramClass.isEnum()) {
      paramClass = new EnumDeserializer(paramClass);
    }
    for (;;)
    {
      putDeserializer((Type)localObject, paramClass);
      return paramClass;
      if (paramClass.isArray()) {
        paramClass = ArrayCodec.instance;
      } else if ((paramClass == Set.class) || (paramClass == HashSet.class) || (paramClass == Collection.class) || (paramClass == List.class) || (paramClass == ArrayList.class)) {
        paramClass = CollectionCodec.instance;
      } else if (Collection.class.isAssignableFrom(paramClass)) {
        paramClass = CollectionCodec.instance;
      } else if (Map.class.isAssignableFrom(paramClass)) {
        paramClass = MapDeserializer.instance;
      } else if (Throwable.class.isAssignableFrom(paramClass)) {
        paramClass = new ThrowableDeserializer(this, paramClass);
      } else {
        paramClass = new JavaBeanDeserializer(this, paramClass, (Type)localObject);
      }
    }
  }
  
  public ObjectDeserializer getDeserializer(Type paramType)
  {
    Object localObject = (ObjectDeserializer)this.derializers.get(paramType);
    if (localObject != null) {
      return localObject;
    }
    if ((paramType instanceof Class)) {
      return getDeserializer((Class)paramType, paramType);
    }
    if ((paramType instanceof ParameterizedType))
    {
      localObject = ((ParameterizedType)paramType).getRawType();
      if ((localObject instanceof Class)) {
        return getDeserializer((Class)localObject, paramType);
      }
      return getDeserializer((Type)localObject);
    }
    return JavaObjectDeserializer.instance;
  }
  
  public void putDeserializer(Type paramType, ObjectDeserializer paramObjectDeserializer)
  {
    this.derializers.put(paramType, paramObjectDeserializer);
  }
  
  public ObjectDeserializer registerIfNotExists(Class<?> paramClass)
  {
    return registerIfNotExists(paramClass, paramClass.getModifiers(), false, true, true, true);
  }
  
  public ObjectDeserializer registerIfNotExists(Class<?> paramClass, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    Object localObject = (ObjectDeserializer)this.derializers.get(paramClass);
    if (localObject != null) {
      return localObject;
    }
    localObject = new JavaBeanDeserializer(this, paramClass, paramClass, JavaBeanInfo.build(paramClass, paramInt, paramClass, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, this.propertyNamingStrategy));
    putDeserializer(paramClass, (ObjectDeserializer)localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.parser.ParserConfig
 * JD-Core Version:    0.7.0.1
 */