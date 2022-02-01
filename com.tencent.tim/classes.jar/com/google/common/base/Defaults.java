package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@GwtIncompatible
public final class Defaults
{
  private static final Map<Class<?>, Object> DEFAULTS;
  
  static
  {
    HashMap localHashMap = new HashMap();
    put(localHashMap, Boolean.TYPE, Boolean.valueOf(false));
    put(localHashMap, Character.TYPE, Character.valueOf('\000'));
    put(localHashMap, Byte.TYPE, Byte.valueOf((byte)0));
    put(localHashMap, Short.TYPE, Short.valueOf((short)0));
    put(localHashMap, Integer.TYPE, Integer.valueOf(0));
    put(localHashMap, Long.TYPE, Long.valueOf(0L));
    put(localHashMap, Float.TYPE, Float.valueOf(0.0F));
    put(localHashMap, Double.TYPE, Double.valueOf(0.0D));
    DEFAULTS = Collections.unmodifiableMap(localHashMap);
  }
  
  @Nullable
  public static <T> T defaultValue(Class<T> paramClass)
  {
    return DEFAULTS.get(Preconditions.checkNotNull(paramClass));
  }
  
  private static <T> void put(Map<Class<?>, Object> paramMap, Class<T> paramClass, T paramT)
  {
    paramMap.put(paramClass, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.Defaults
 * JD-Core Version:    0.7.0.1
 */