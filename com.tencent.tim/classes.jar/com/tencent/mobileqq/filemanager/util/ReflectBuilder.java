package com.tencent.mobileqq.filemanager.util;

import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectBuilder<T>
{
  private String bJR;
  private boolean cfY;
  private Class<?>[] h;
  private Object[] mArgs;
  private Class<?> mClazz;
  private Object mObject;
  private int mType = 12288;
  
  public ReflectBuilder<T> a(int paramInt)
  {
    this.mType = paramInt;
    return this;
  }
  
  public ReflectBuilder<T> a(Class<?> paramClass, Object paramObject)
  {
    this.mClazz = paramClass;
    this.mObject = paramObject;
    return this;
  }
  
  public ReflectBuilder<T> a(String paramString)
  {
    this.bJR = paramString;
    return this;
  }
  
  public ReflectBuilder<T> a(boolean paramBoolean)
  {
    this.cfY = paramBoolean;
    return this;
  }
  
  public ReflectBuilder<T> a(Class<?>... paramVarArgs)
  {
    this.h = new Class[paramVarArgs.length];
    System.arraycopy(paramVarArgs, 0, this.h, 0, paramVarArgs.length);
    return this;
  }
  
  public ReflectBuilder<T> a(Object... paramVarArgs)
  {
    this.mArgs = new Object[paramVarArgs.length];
    System.arraycopy(paramVarArgs, 0, this.mArgs, 0, paramVarArgs.length);
    return this;
  }
  
  public void dmh()
    throws ReflectBuilder.WrongParamException, NoSuchMethodException, InvocationTargetException, IllegalAccessException
  {
    if ((this.mType != 8192) || (this.mClazz == null) || (this.mObject == null) || (TextUtils.isEmpty(this.bJR))) {
      throw new WrongParamException();
    }
    if (this.h.length != this.mArgs.length) {
      throw new WrongParamException();
    }
    Method localMethod = this.mClazz.getDeclaredMethod(this.bJR, this.h);
    if (this.cfY) {
      localMethod.setAccessible(true);
    }
    localMethod.invoke(this.mObject, this.mArgs);
  }
  
  public static class WrongParamException
    extends Exception
  {
    WrongParamException()
    {
      Log.d("WrongParamException", "方法参数设置有问题");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.ReflectBuilder
 * JD-Core Version:    0.7.0.1
 */