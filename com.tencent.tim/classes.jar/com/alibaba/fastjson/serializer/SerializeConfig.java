package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.util.IdentityHashMap;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

public class SerializeConfig
{
  public static final SerializeConfig globalInstance = new SerializeConfig();
  public PropertyNamingStrategy propertyNamingStrategy;
  private final IdentityHashMap<ObjectSerializer> serializers = new IdentityHashMap(1024);
  protected String typeKey = "@type";
  
  public SerializeConfig()
  {
    this.serializers.put(Boolean.class, BooleanCodec.instance);
    this.serializers.put(Character.class, MiscCodec.instance);
    this.serializers.put(Byte.class, IntegerCodec.instance);
    this.serializers.put(Short.class, IntegerCodec.instance);
    this.serializers.put(Integer.class, IntegerCodec.instance);
    this.serializers.put(Long.class, IntegerCodec.instance);
    this.serializers.put(Float.class, NumberCodec.instance);
    this.serializers.put(Double.class, NumberCodec.instance);
    this.serializers.put(Number.class, NumberCodec.instance);
    this.serializers.put(BigDecimal.class, BigDecimalCodec.instance);
    this.serializers.put(BigInteger.class, BigDecimalCodec.instance);
    this.serializers.put(String.class, StringCodec.instance);
    this.serializers.put([Ljava.lang.Object.class, ArrayCodec.instance);
    this.serializers.put(Class.class, MiscCodec.instance);
    this.serializers.put(SimpleDateFormat.class, MiscCodec.instance);
    this.serializers.put(Locale.class, MiscCodec.instance);
    this.serializers.put(Currency.class, MiscCodec.instance);
    this.serializers.put(TimeZone.class, MiscCodec.instance);
    this.serializers.put(UUID.class, MiscCodec.instance);
    this.serializers.put(URI.class, MiscCodec.instance);
    this.serializers.put(URL.class, MiscCodec.instance);
    this.serializers.put(Pattern.class, MiscCodec.instance);
    this.serializers.put(Charset.class, MiscCodec.instance);
  }
  
  public static final SerializeConfig getGlobalInstance()
  {
    return globalInstance;
  }
  
  public ObjectSerializer get(Class<?> paramClass)
  {
    int j = 0;
    ObjectSerializer localObjectSerializer = (ObjectSerializer)this.serializers.get(paramClass);
    Object localObject = localObjectSerializer;
    if (localObjectSerializer == null)
    {
      if (!Map.class.isAssignableFrom(paramClass)) {
        break label65;
      }
      this.serializers.put(paramClass, new MapSerializer());
    }
    for (;;)
    {
      localObject = (ObjectSerializer)this.serializers.get(paramClass);
      return localObject;
      label65:
      if (List.class.isAssignableFrom(paramClass))
      {
        this.serializers.put(paramClass, new ListSerializer());
      }
      else if (Collection.class.isAssignableFrom(paramClass))
      {
        this.serializers.put(paramClass, CollectionCodec.instance);
      }
      else if (Date.class.isAssignableFrom(paramClass))
      {
        this.serializers.put(paramClass, DateCodec.instance);
      }
      else if (JSONAware.class.isAssignableFrom(paramClass))
      {
        this.serializers.put(paramClass, MiscCodec.instance);
      }
      else if (JSONSerializable.class.isAssignableFrom(paramClass))
      {
        this.serializers.put(paramClass, MiscCodec.instance);
      }
      else if (JSONStreamAware.class.isAssignableFrom(paramClass))
      {
        this.serializers.put(paramClass, MiscCodec.instance);
      }
      else
      {
        if (!paramClass.isEnum())
        {
          localObject = paramClass.getSuperclass();
          if ((localObject == null) || (localObject == Object.class) || (!((Class)localObject).isEnum())) {}
        }
        else
        {
          this.serializers.put(paramClass, new EnumSerializer());
          continue;
        }
        if (paramClass.isArray())
        {
          localObject = paramClass.getComponentType();
          localObjectSerializer = get((Class)localObject);
          this.serializers.put(paramClass, new ArraySerializer((Class)localObject, localObjectSerializer));
        }
        else if (Throwable.class.isAssignableFrom(paramClass))
        {
          localObject = new JavaBeanSerializer(paramClass, this.propertyNamingStrategy);
          ((JavaBeanSerializer)localObject).features |= SerializerFeature.WriteClassName.mask;
          this.serializers.put(paramClass, localObject);
        }
        else if (TimeZone.class.isAssignableFrom(paramClass))
        {
          this.serializers.put(paramClass, MiscCodec.instance);
        }
        else if (Charset.class.isAssignableFrom(paramClass))
        {
          this.serializers.put(paramClass, MiscCodec.instance);
        }
        else if (Enumeration.class.isAssignableFrom(paramClass))
        {
          this.serializers.put(paramClass, MiscCodec.instance);
        }
        else
        {
          if (!Calendar.class.isAssignableFrom(paramClass)) {
            break;
          }
          this.serializers.put(paramClass, DateCodec.instance);
        }
      }
    }
    localObject = paramClass.getInterfaces();
    int k = localObject.length;
    int i = 0;
    label472:
    if (i < k)
    {
      localObjectSerializer = localObject[i];
      if ((localObjectSerializer.getName().equals("net.sf.cglib.proxy.Factory")) || (localObjectSerializer.getName().equals("org.springframework.cglib.proxy.Factory")))
      {
        i = 0;
        j = 1;
      }
    }
    for (;;)
    {
      if ((j != 0) || (i != 0))
      {
        localObject = get(paramClass.getSuperclass());
        this.serializers.put(paramClass, localObject);
        return localObject;
        if (localObjectSerializer.getName().equals("javassist.util.proxy.ProxyObject"))
        {
          i = 1;
          continue;
        }
        i += 1;
        break label472;
      }
      this.serializers.put(paramClass, new JavaBeanSerializer(paramClass, this.propertyNamingStrategy));
      break;
      i = 0;
    }
  }
  
  public String getTypeKey()
  {
    return this.typeKey;
  }
  
  public boolean put(Type paramType, ObjectSerializer paramObjectSerializer)
  {
    return this.serializers.put(paramType, paramObjectSerializer);
  }
  
  public ObjectSerializer registerIfNotExists(Class<?> paramClass)
  {
    return registerIfNotExists(paramClass, paramClass.getModifiers(), false, true, true, true);
  }
  
  public ObjectSerializer registerIfNotExists(Class<?> paramClass, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    ObjectSerializer localObjectSerializer = (ObjectSerializer)this.serializers.get(paramClass);
    Object localObject = localObjectSerializer;
    if (localObjectSerializer == null)
    {
      localObject = new JavaBeanSerializer(paramClass, paramInt, null, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, this.propertyNamingStrategy);
      this.serializers.put(paramClass, localObject);
    }
    return localObject;
  }
  
  public void setTypeKey(String paramString)
  {
    this.typeKey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.SerializeConfig
 * JD-Core Version:    0.7.0.1
 */