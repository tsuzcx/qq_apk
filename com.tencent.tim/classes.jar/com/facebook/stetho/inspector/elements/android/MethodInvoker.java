package com.facebook.stetho.inspector.elements.android;

import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class MethodInvoker
{
  private static final List<TypedMethodInvoker<?>> invokers = Arrays.asList(new TypedMethodInvoker[] { new StringMethodInvoker(), new CharSequenceMethodInvoker(), new IntegerMethodInvoker(), new FloatMethodInvoker(), new BooleanMethodInvoker() });
  
  public void invoke(Object paramObject, String paramString1, String paramString2)
  {
    Util.throwIfNull(paramObject, paramString1, paramString2);
    int j = invokers.size();
    int i = 0;
    while (i < j)
    {
      if (((TypedMethodInvoker)invokers.get(i)).invoke(paramObject, paramString1, paramString2)) {
        return;
      }
      i += 1;
    }
    LogUtil.w("Method with name " + paramString1 + " not found for any of the MethodInvoker supported argument types.");
  }
  
  static class BooleanMethodInvoker
    extends MethodInvoker.TypedMethodInvoker<Boolean>
  {
    BooleanMethodInvoker()
    {
      super();
    }
    
    Boolean convertArgument(String paramString)
    {
      return Boolean.valueOf(Boolean.parseBoolean(paramString));
    }
  }
  
  static class CharSequenceMethodInvoker
    extends MethodInvoker.TypedMethodInvoker<CharSequence>
  {
    CharSequenceMethodInvoker()
    {
      super();
    }
    
    CharSequence convertArgument(String paramString)
    {
      return paramString;
    }
  }
  
  static class FloatMethodInvoker
    extends MethodInvoker.TypedMethodInvoker<Float>
  {
    FloatMethodInvoker()
    {
      super();
    }
    
    Float convertArgument(String paramString)
    {
      return Float.valueOf(Float.parseFloat(paramString));
    }
  }
  
  static class IntegerMethodInvoker
    extends MethodInvoker.TypedMethodInvoker<Integer>
  {
    IntegerMethodInvoker()
    {
      super();
    }
    
    Integer convertArgument(String paramString)
    {
      return Integer.valueOf(Integer.parseInt(paramString));
    }
  }
  
  static class StringMethodInvoker
    extends MethodInvoker.TypedMethodInvoker<String>
  {
    StringMethodInvoker()
    {
      super();
    }
    
    String convertArgument(String paramString)
    {
      return paramString;
    }
  }
  
  static abstract class TypedMethodInvoker<T>
  {
    private final Class<T> mArgType;
    
    TypedMethodInvoker(Class<T> paramClass)
    {
      this.mArgType = paramClass;
    }
    
    abstract T convertArgument(String paramString);
    
    boolean invoke(Object paramObject, String paramString1, String paramString2)
    {
      try
      {
        paramObject.getClass().getMethod(paramString1, new Class[] { this.mArgType }).invoke(paramObject, new Object[] { convertArgument(paramString2) });
        return true;
      }
      catch (InvocationTargetException paramObject)
      {
        LogUtil.w("InvocationTargetException: " + paramObject.getMessage());
        return false;
      }
      catch (IllegalAccessException paramObject)
      {
        for (;;)
        {
          LogUtil.w("IllegalAccessException: " + paramObject.getMessage());
        }
      }
      catch (IllegalArgumentException paramObject)
      {
        for (;;)
        {
          LogUtil.w("IllegalArgumentException: " + paramObject.getMessage());
        }
      }
      catch (NoSuchMethodException paramObject)
      {
        label64:
        break label64;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.android.MethodInvoker
 * JD-Core Version:    0.7.0.1
 */