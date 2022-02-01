package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
abstract class ImmutableMapEntrySet<K, V>
  extends ImmutableSet<Map.Entry<K, V>>
{
  public boolean contains(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Map.Entry))
    {
      paramObject = (Map.Entry)paramObject;
      Object localObject = map().get(paramObject.getKey());
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (localObject.equals(paramObject.getValue())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return map().hashCode();
  }
  
  @GwtIncompatible
  boolean isHashCodeFast()
  {
    return map().isHashCodeFast();
  }
  
  boolean isPartialView()
  {
    return map().isPartialView();
  }
  
  abstract ImmutableMap<K, V> map();
  
  public int size()
  {
    return map().size();
  }
  
  @GwtIncompatible
  Object writeReplace()
  {
    return new EntrySetSerializedForm(map());
  }
  
  @GwtIncompatible
  static class EntrySetSerializedForm<K, V>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final ImmutableMap<K, V> map;
    
    EntrySetSerializedForm(ImmutableMap<K, V> paramImmutableMap)
    {
      this.map = paramImmutableMap;
    }
    
    Object readResolve()
    {
      return this.map.entrySet();
    }
  }
  
  static final class RegularEntrySet<K, V>
    extends ImmutableMapEntrySet<K, V>
  {
    private final transient Map.Entry<K, V>[] entries;
    @Weak
    private final transient ImmutableMap<K, V> map;
    
    RegularEntrySet(ImmutableMap<K, V> paramImmutableMap, Map.Entry<K, V>[] paramArrayOfEntry)
    {
      this.map = paramImmutableMap;
      this.entries = paramArrayOfEntry;
    }
    
    ImmutableList<Map.Entry<K, V>> createAsList()
    {
      return new RegularImmutableAsList(this, this.entries);
    }
    
    public UnmodifiableIterator<Map.Entry<K, V>> iterator()
    {
      return Iterators.forArray(this.entries);
    }
    
    ImmutableMap<K, V> map()
    {
      return this.map;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ImmutableMapEntrySet
 * JD-Core Version:    0.7.0.1
 */