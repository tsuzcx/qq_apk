package com.tencent.qapmsdk.socket.util;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.text.TextUtils;
import com.tencent.qapmsdk.common.logger.Logger;
import java.io.FileDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class ReflectionHelper
{
  private static final int MAGIC_NUMBER = 11259375;
  private static final String TAG = "QAPM_Socket_ReflectionHelper";
  private static Map<String, Class<?>> classMap = new ConcurrentHashMap();
  private static String openSslPackageName;
  private static Map<Class<?>, Cache> reflectClassCacheMap = new ConcurrentHashMap();
  
  public static Object fieldValue(Object paramObject, String paramString)
    throws NoSuchFieldException, IllegalAccessException
  {
    return of(paramObject.getClass()).field(paramString).get(paramObject);
  }
  
  public static String getOpenSslPackageName()
  {
    int i = 0;
    String[] arrayOfString;
    int j;
    if (openSslPackageName == null)
    {
      arrayOfString = new String[3];
      arrayOfString[0] = "com.android.org.conscrypt";
      arrayOfString[1] = "org.conscrypt";
      arrayOfString[2] = "org.apache.harmony.xnet.provider.jsse";
      j = arrayOfString.length;
    }
    for (;;)
    {
      String str;
      if (i < j) {
        str = arrayOfString[i];
      }
      try
      {
        of(str + ".OpenSSLContextImpl");
        openSslPackageName = str;
        if (TextUtils.isEmpty(openSslPackageName)) {
          processException(new RuntimeException("cannot find OpenSSLContextImpl"));
        }
        return openSslPackageName;
      }
      catch (Exception localException)
      {
        i += 1;
      }
    }
  }
  
  public static RetrofitCache instance(Object paramObject)
  {
    return new RetrofitCache(paramObject);
  }
  
  @NonNull
  public static Cache of(Class<?> paramClass)
  {
    Object localObject = (Cache)reflectClassCacheMap.get(paramClass);
    if (localObject == null) {
      try
      {
        Cache localCache2 = (Cache)reflectClassCacheMap.get(paramClass);
        localObject = localCache2;
        if (localCache2 == null)
        {
          localObject = new Cache(paramClass);
          reflectClassCacheMap.put(paramClass, localObject);
        }
        return localObject;
      }
      finally {}
    }
    return localCache1;
  }
  
  public static Cache of(String paramString)
    throws ClassNotFoundException
  {
    Class localClass2 = (Class)classMap.get(paramString);
    Class localClass1 = localClass2;
    if (localClass2 == null)
    {
      localClass1 = Class.forName(paramString);
      classMap.put(paramString, localClass1);
    }
    return of(localClass1);
  }
  
  public static String printFd(Object paramObject)
  {
    if ((paramObject instanceof FileDescriptor)) {
      try
      {
        String str = "fd[" + of(FileDescriptor.class).field("descriptor").get(paramObject) + "]";
        return str;
      }
      catch (Exception localException) {}
    }
    return String.valueOf(paramObject);
  }
  
  public static void processException(Throwable paramThrowable)
  {
    Logger.INSTANCE.exception("QAPM_Socket_ReflectionHelper", paramThrowable);
  }
  
  public static class Cache
  {
    private Class<?> clz;
    private Map<ReflectionHelper.ConstructorKey, Constructor<?>> constructorMap = new ConcurrentHashMap();
    private Map<String, Field> fieldMap = new ConcurrentHashMap();
    private Map<ReflectionHelper.MethodKey, Method> methodMap = new ConcurrentHashMap();
    
    Cache(Class<?> paramClass)
    {
      this.clz = paramClass;
    }
    
    public Constructor<?> constructor(Class<?>... paramVarArgs)
      throws NoSuchMethodException
    {
      ReflectionHelper.ConstructorKey localConstructorKey = new ReflectionHelper.ConstructorKey(paramVarArgs);
      Constructor localConstructor2 = (Constructor)this.constructorMap.get(localConstructorKey);
      Constructor localConstructor1 = localConstructor2;
      if (localConstructor2 == null)
      {
        localConstructor1 = this.clz.getDeclaredConstructor(paramVarArgs);
        localConstructor1.setAccessible(true);
        this.constructorMap.put(localConstructorKey, localConstructor1);
      }
      return localConstructor1;
    }
    
    public Field field(String paramString)
      throws NoSuchFieldException
    {
      Field localField = (Field)this.fieldMap.get(paramString);
      Object localObject = localField;
      if (localField == null) {
        localObject = this.clz;
      }
      while (localObject != null) {
        try
        {
          localField = ((Class)localObject).getDeclaredField(paramString);
          localObject = localField;
          ((Field)localObject).setAccessible(true);
          this.fieldMap.put(paramString, localObject);
          return localObject;
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          localObject = ((Class)localObject).getSuperclass();
        }
      }
      throw new NoSuchFieldException("class: " + this.clz + ", field: " + paramString);
    }
    
    @NonNull
    public Method method(String paramString, Class<?>... paramVarArgs)
      throws NoSuchMethodException
    {
      ReflectionHelper.MethodKey localMethodKey = new ReflectionHelper.MethodKey(paramString, paramVarArgs);
      Method localMethod = (Method)this.methodMap.get(localMethodKey);
      Object localObject = localMethod;
      if (localMethod == null) {
        localObject = this.clz;
      }
      while (localObject != null) {
        try
        {
          localMethod = ((Class)localObject).getDeclaredMethod(paramString, paramVarArgs);
          localObject = localMethod;
          ((Method)localObject).setAccessible(true);
          this.methodMap.put(localMethodKey, localObject);
          return localObject;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          localObject = ((Class)localObject).getSuperclass();
        }
      }
      throw new NoSuchMethodException("class: " + this.clz + ", method: " + paramString + ", args: " + Arrays.toString(paramVarArgs));
    }
  }
  
  static class ConstructorKey
  {
    Class<?>[] types;
    
    ConstructorKey(Class<?>[] paramArrayOfClass)
    {
      this.types = paramArrayOfClass;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if ((paramObject instanceof ConstructorKey)) {
        return Arrays.equals(((ConstructorKey)paramObject).types, this.types);
      }
      return false;
    }
    
    public int hashCode()
    {
      int k = 0;
      int j = 0;
      int i = k;
      if (this.types != null)
      {
        i = k;
        if (this.types.length > 0)
        {
          i = 0;
          while (j < this.types.length)
          {
            i += (j + 1) * this.types[j].hashCode() * this.types[j].getName().hashCode() * 11259375;
            j += 1;
          }
        }
      }
      return i;
    }
  }
  
  static class MethodKey
  {
    String name;
    Class<?>[] types;
    
    MethodKey(String paramString, Class<?>[] paramArrayOfClass)
    {
      this.name = paramString;
      this.types = paramArrayOfClass;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof MethodKey)) {
          break;
        }
        paramObject = (MethodKey)paramObject;
      } while ((paramObject.name.equals(this.name)) && (Arrays.equals(paramObject.types, this.types)));
      return false;
      return false;
    }
    
    public int hashCode()
    {
      int k = 0;
      int j = 0;
      int i = k;
      if (this.types != null)
      {
        i = k;
        if (this.types.length > 0)
        {
          i = 0;
          while (j < this.types.length)
          {
            i += (j + 1) * this.types[j].hashCode() * this.types[j].getName().hashCode() * 11259375;
            j += 1;
          }
        }
      }
      return i + this.name.hashCode();
    }
  }
  
  public static class RetrofitCache
  {
    private Object cacheInstance;
    
    RetrofitCache(Object paramObject)
    {
      this.cacheInstance = paramObject;
    }
    
    public ReflectionHelper.RetrofitField field(String paramString)
      throws NoSuchFieldException, IllegalAccessException
    {
      return new ReflectionHelper.RetrofitField(ReflectionHelper.fieldValue(this.cacheInstance, paramString));
    }
    
    public ReflectionHelper.RetrofitMethod method(String paramString, Class<?>... paramVarArgs)
      throws NoSuchMethodException
    {
      return new ReflectionHelper.RetrofitMethod(this.cacheInstance, ReflectionHelper.of(this.cacheInstance.getClass()).method(paramString, paramVarArgs));
    }
  }
  
  public static class RetrofitField
  {
    private Object fieldValue;
    
    RetrofitField(Object paramObject)
    {
      this.fieldValue = paramObject;
    }
    
    public RetrofitField field(String paramString)
      throws IllegalAccessException, NoSuchFieldException
    {
      return new RetrofitField(ReflectionHelper.fieldValue(this.fieldValue, paramString));
    }
    
    public Object get()
      throws IllegalAccessException
    {
      return this.fieldValue;
    }
    
    public ReflectionHelper.RetrofitMethod method(String paramString, Class<?>... paramVarArgs)
      throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException
    {
      return new ReflectionHelper.RetrofitMethod(this.fieldValue, ReflectionHelper.of(this.fieldValue.getClass()).method(paramString, paramVarArgs));
    }
  }
  
  public static class RetrofitMethod
  {
    List<Object> argList;
    private Method method;
    private Object methodInstance;
    
    RetrofitMethod(Object paramObject, Method paramMethod)
    {
      this.methodInstance = paramObject;
      this.method = paramMethod;
    }
    
    public RetrofitMethod args(Object... paramVarArgs)
      throws InvocationTargetException, IllegalAccessException
    {
      if (this.argList == null) {
        this.argList = new ArrayList();
      }
      Collections.addAll(this.argList, paramVarArgs);
      return this;
    }
    
    public Object invoke()
      throws InvocationTargetException, IllegalAccessException
    {
      Method localMethod = this.method;
      Object localObject = this.methodInstance;
      if (this.argList != null) {}
      for (Object[] arrayOfObject = this.argList.toArray(new Object[this.argList.size()]);; arrayOfObject = null) {
        return localMethod.invoke(localObject, arrayOfObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.util.ReflectionHelper
 * JD-Core Version:    0.7.0.1
 */