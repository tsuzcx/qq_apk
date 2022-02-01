package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
final class RegularImmutableMap<K, V>
  extends ImmutableMap<K, V>
{
  private static final double MAX_LOAD_FACTOR = 1.2D;
  private static final long serialVersionUID = 0L;
  private final transient Map.Entry<K, V>[] entries;
  private final transient int mask;
  private final transient ImmutableMapEntry<K, V>[] table;
  
  private RegularImmutableMap(Map.Entry<K, V>[] paramArrayOfEntry, ImmutableMapEntry<K, V>[] paramArrayOfImmutableMapEntry, int paramInt)
  {
    this.entries = paramArrayOfEntry;
    this.table = paramArrayOfImmutableMapEntry;
    this.mask = paramInt;
  }
  
  static void checkNoConflictInKeyBucket(Object paramObject, Map.Entry<?, ?> paramEntry, @Nullable ImmutableMapEntry<?, ?> paramImmutableMapEntry)
  {
    if (paramImmutableMapEntry != null)
    {
      if (!paramObject.equals(paramImmutableMapEntry.getKey())) {}
      for (boolean bool = true;; bool = false)
      {
        checkNoConflict(bool, "key", paramEntry, paramImmutableMapEntry);
        paramImmutableMapEntry = paramImmutableMapEntry.getNextInKeyBucket();
        break;
      }
    }
  }
  
  static <K, V> RegularImmutableMap<K, V> fromEntries(Map.Entry<K, V>... paramVarArgs)
  {
    return fromEntryArray(paramVarArgs.length, paramVarArgs);
  }
  
  static <K, V> RegularImmutableMap<K, V> fromEntryArray(int paramInt, Map.Entry<K, V>[] paramArrayOfEntry)
  {
    Preconditions.checkPositionIndex(paramInt, paramArrayOfEntry.length);
    Object localObject2;
    int i;
    ImmutableMapEntry[] arrayOfImmutableMapEntry;
    int k;
    label37:
    Object localObject1;
    Object localObject3;
    Object localObject4;
    int m;
    ImmutableMapEntry localImmutableMapEntry;
    int j;
    if (paramInt == paramArrayOfEntry.length)
    {
      localObject2 = paramArrayOfEntry;
      i = Hashing.closedTableSize(paramInt, 1.2D);
      arrayOfImmutableMapEntry = ImmutableMapEntry.createEntryArray(i);
      k = i - 1;
      i = 0;
      if (i >= paramInt) {
        break label206;
      }
      localObject1 = paramArrayOfEntry[i];
      localObject3 = ((Map.Entry)localObject1).getKey();
      localObject4 = ((Map.Entry)localObject1).getValue();
      CollectPreconditions.checkEntryNotNull(localObject3, localObject4);
      m = Hashing.smear(localObject3.hashCode()) & k;
      localImmutableMapEntry = arrayOfImmutableMapEntry[m];
      if (localImmutableMapEntry != null) {
        break label188;
      }
      if ((!(localObject1 instanceof ImmutableMapEntry)) || (!((ImmutableMapEntry)localObject1).isReusable())) {
        break label167;
      }
      j = 1;
      label118:
      if (j == 0) {
        break label172;
      }
      localObject1 = (ImmutableMapEntry)localObject1;
    }
    for (;;)
    {
      arrayOfImmutableMapEntry[m] = localObject1;
      localObject2[i] = localObject1;
      checkNoConflictInKeyBucket(localObject3, (Map.Entry)localObject1, localImmutableMapEntry);
      i += 1;
      break label37;
      localObject2 = ImmutableMapEntry.createEntryArray(paramInt);
      break;
      label167:
      j = 0;
      break label118;
      label172:
      localObject1 = new ImmutableMapEntry(localObject3, localObject4);
      continue;
      label188:
      localObject1 = new ImmutableMapEntry.NonTerminalImmutableMapEntry(localObject3, localObject4, localImmutableMapEntry);
    }
    label206:
    return new RegularImmutableMap((Map.Entry[])localObject2, arrayOfImmutableMapEntry, k);
  }
  
  @Nullable
  static <V> V get(@Nullable Object paramObject, ImmutableMapEntry<?, V>[] paramArrayOfImmutableMapEntry, int paramInt)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return null;
      for (paramArrayOfImmutableMapEntry = paramArrayOfImmutableMapEntry[(Hashing.smear(paramObject.hashCode()) & paramInt)]; paramArrayOfImmutableMapEntry != null; paramArrayOfImmutableMapEntry = paramArrayOfImmutableMapEntry.getNextInKeyBucket()) {
        if (paramObject.equals(paramArrayOfImmutableMapEntry.getKey())) {
          return paramArrayOfImmutableMapEntry.getValue();
        }
      }
    }
  }
  
  ImmutableSet<Map.Entry<K, V>> createEntrySet()
  {
    return new ImmutableMapEntrySet.RegularEntrySet(this, this.entries);
  }
  
  ImmutableSet<K> createKeySet()
  {
    return new KeySet(this);
  }
  
  ImmutableCollection<V> createValues()
  {
    return new Values(this);
  }
  
  public V get(@Nullable Object paramObject)
  {
    return get(paramObject, this.table, this.mask);
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  public int size()
  {
    return this.entries.length;
  }
  
  @GwtCompatible(emulated=true)
  static final class KeySet<K, V>
    extends ImmutableSet.Indexed<K>
  {
    @Weak
    private final RegularImmutableMap<K, V> map;
    
    KeySet(RegularImmutableMap<K, V> paramRegularImmutableMap)
    {
      this.map = paramRegularImmutableMap;
    }
    
    public boolean contains(Object paramObject)
    {
      return this.map.containsKey(paramObject);
    }
    
    K get(int paramInt)
    {
      return this.map.entries[paramInt].getKey();
    }
    
    boolean isPartialView()
    {
      return true;
    }
    
    public int size()
    {
      return this.map.size();
    }
    
    @GwtIncompatible
    Object writeReplace()
    {
      return new SerializedForm(this.map);
    }
    
    @GwtIncompatible
    static class SerializedForm<K>
      implements Serializable
    {
      private static final long serialVersionUID = 0L;
      final ImmutableMap<K, ?> map;
      
      SerializedForm(ImmutableMap<K, ?> paramImmutableMap)
      {
        this.map = paramImmutableMap;
      }
      
      Object readResolve()
      {
        return this.map.keySet();
      }
    }
  }
  
  @GwtCompatible(emulated=true)
  static final class Values<K, V>
    extends ImmutableList<V>
  {
    @Weak
    final RegularImmutableMap<K, V> map;
    
    Values(RegularImmutableMap<K, V> paramRegularImmutableMap)
    {
      this.map = paramRegularImmutableMap;
    }
    
    public V get(int paramInt)
    {
      return this.map.entries[paramInt].getValue();
    }
    
    boolean isPartialView()
    {
      return true;
    }
    
    public int size()
    {
      return this.map.size();
    }
    
    @GwtIncompatible
    Object writeReplace()
    {
      return new SerializedForm(this.map);
    }
    
    @GwtIncompatible
    static class SerializedForm<V>
      implements Serializable
    {
      private static final long serialVersionUID = 0L;
      final ImmutableMap<?, V> map;
      
      SerializedForm(ImmutableMap<?, V> paramImmutableMap)
      {
        this.map = paramImmutableMap;
      }
      
      Object readResolve()
      {
        return this.map.values();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.RegularImmutableMap
 * JD-Core Version:    0.7.0.1
 */