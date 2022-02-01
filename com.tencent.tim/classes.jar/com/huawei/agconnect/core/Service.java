package com.huawei.agconnect.core;

import com.huawei.agconnect.annotation.Singleton;
import java.lang.reflect.Modifier;

public class Service
{
  private Class<?> mClass;
  private Class<?> mInterface;
  private boolean mIsSingleton;
  
  private Service(Class<?> paramClass1, Class<?> paramClass2)
  {
    this.mInterface = paramClass1;
    this.mClass = paramClass2;
  }
  
  public static Builder builder(Class<?> paramClass)
  {
    return new Builder(paramClass, paramClass, null);
  }
  
  public static Builder builder(Class<?> paramClass1, Class<?> paramClass2)
  {
    return new Builder(paramClass1, paramClass2, null);
  }
  
  public Class<?> getInterface()
  {
    return this.mInterface;
  }
  
  public Class<?> getType()
  {
    return this.mClass;
  }
  
  public boolean isSingleton()
  {
    return this.mIsSingleton;
  }
  
  public static class Builder
  {
    Class<?> mClass;
    Class<?> mInterface;
    private boolean mIsSingleton;
    
    private Builder(Class<?> paramClass1, Class<?> paramClass2)
    {
      if (paramClass1 == null) {
        throw new IllegalArgumentException("the interface parameter cannot be NULL");
      }
      if (paramClass2 == null) {
        throw new IllegalArgumentException("the clazz parameter cannot be NULL");
      }
      if ((paramClass2.isInterface()) || (!Modifier.isPublic(paramClass2.getModifiers()))) {
        throw new IllegalArgumentException("the clazz parameter must be interface type and public");
      }
      this.mInterface = paramClass1;
      this.mClass = paramClass2;
      this.mIsSingleton = paramClass2.isAnnotationPresent(Singleton.class);
    }
    
    public Service build()
    {
      Service localService = new Service(this.mInterface, this.mClass, null);
      Service.access$202(localService, this.mIsSingleton);
      return localService;
    }
    
    public Builder isSingleton(boolean paramBoolean)
    {
      this.mIsSingleton = paramBoolean;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.agconnect.core.Service
 * JD-Core Version:    0.7.0.1
 */