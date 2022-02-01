package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingMapEntry<K, V>
  extends ForwardingObject
  implements Map.Entry<K, V>
{
  protected abstract Map.Entry<K, V> delegate();
  
  public boolean equals(@Nullable Object paramObject)
  {
    return delegate().equals(paramObject);
  }
  
  public K getKey()
  {
    return delegate().getKey();
  }
  
  public V getValue()
  {
    return delegate().getValue();
  }
  
  public int hashCode()
  {
    return delegate().hashCode();
  }
  
  public V setValue(V paramV)
  {
    return delegate().setValue(paramV);
  }
  
  protected boolean standardEquals(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Map.Entry))
    {
      paramObject = (Map.Entry)paramObject;
      bool1 = bool2;
      if (Objects.equal(getKey(), paramObject.getKey()))
      {
        bool1 = bool2;
        if (Objects.equal(getValue(), paramObject.getValue())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected int standardHashCode()
  {
    int j = 0;
    Object localObject1 = getKey();
    Object localObject2 = getValue();
    int i;
    if (localObject1 == null)
    {
      i = 0;
      if (localObject2 != null) {
        break label36;
      }
    }
    for (;;)
    {
      return j ^ i;
      i = localObject1.hashCode();
      break;
      label36:
      j = localObject2.hashCode();
    }
  }
  
  @Beta
  protected String standardToString()
  {
    return getKey() + "=" + getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ForwardingMapEntry
 * JD-Core Version:    0.7.0.1
 */