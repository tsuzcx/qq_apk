package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Util;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

public final class DescriptorMap
{
  private Descriptor.Host mHost;
  private boolean mIsInitializing;
  private final Map<Class<?>, Descriptor> mMap = new IdentityHashMap();
  
  @Nullable
  private Descriptor getImpl(Class<?> paramClass)
  {
    while (paramClass != null)
    {
      Descriptor localDescriptor = (Descriptor)this.mMap.get(paramClass);
      if (localDescriptor != null) {
        return localDescriptor;
      }
      paramClass = paramClass.getSuperclass();
    }
    return null;
  }
  
  public DescriptorMap beginInit()
  {
    Util.throwIf(this.mIsInitializing);
    this.mIsInitializing = true;
    return this;
  }
  
  public DescriptorMap endInit()
  {
    Util.throwIfNot(this.mIsInitializing);
    Util.throwIfNull(this.mHost);
    this.mIsInitializing = false;
    Iterator localIterator = this.mMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Class localClass = (Class)localIterator.next();
      Descriptor localDescriptor = (Descriptor)this.mMap.get(localClass);
      if ((localDescriptor instanceof ChainedDescriptor)) {
        ((ChainedDescriptor)localDescriptor).setSuper(getImpl(localClass.getSuperclass()));
      }
      localDescriptor.initialize(this.mHost);
    }
    return this;
  }
  
  @Nullable
  public Descriptor get(Class<?> paramClass)
  {
    Util.throwIfNull(paramClass);
    Util.throwIf(this.mIsInitializing);
    return getImpl(paramClass);
  }
  
  public DescriptorMap register(Class<?> paramClass, Descriptor paramDescriptor)
  {
    Util.throwIfNull(paramClass);
    Util.throwIfNull(paramDescriptor);
    Util.throwIf(paramDescriptor.isInitialized());
    Util.throwIfNot(this.mIsInitializing);
    if (this.mMap.containsKey(paramClass)) {
      throw new UnsupportedOperationException();
    }
    if (this.mMap.containsValue(paramDescriptor)) {
      throw new UnsupportedOperationException();
    }
    this.mMap.put(paramClass, paramDescriptor);
    return this;
  }
  
  public DescriptorMap setHost(Descriptor.Host paramHost)
  {
    Util.throwIfNull(paramHost);
    Util.throwIfNot(this.mIsInitializing);
    Util.throwIfNotNull(this.mHost);
    this.mHost = paramHost;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.DescriptorMap
 * JD-Core Version:    0.7.0.1
 */