package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
public final class LinkedHashMultimap<K, V>
  extends AbstractSetMultimap<K, V>
{
  private static final int DEFAULT_KEY_CAPACITY = 16;
  private static final int DEFAULT_VALUE_SET_CAPACITY = 2;
  @VisibleForTesting
  static final double VALUE_SET_LOAD_FACTOR = 1.0D;
  @GwtIncompatible
  private static final long serialVersionUID = 1L;
  private transient ValueEntry<K, V> multimapHeaderEntry;
  @VisibleForTesting
  transient int valueSetCapacity = 2;
  
  private LinkedHashMultimap(int paramInt1, int paramInt2)
  {
    super(new LinkedHashMap(paramInt1));
    CollectPreconditions.checkNonnegative(paramInt2, "expectedValuesPerKey");
    this.valueSetCapacity = paramInt2;
    this.multimapHeaderEntry = new ValueEntry(null, null, 0, null);
    succeedsInMultimap(this.multimapHeaderEntry, this.multimapHeaderEntry);
  }
  
  public static <K, V> LinkedHashMultimap<K, V> create()
  {
    return new LinkedHashMultimap(16, 2);
  }
  
  public static <K, V> LinkedHashMultimap<K, V> create(int paramInt1, int paramInt2)
  {
    return new LinkedHashMultimap(Maps.capacity(paramInt1), Maps.capacity(paramInt2));
  }
  
  public static <K, V> LinkedHashMultimap<K, V> create(Multimap<? extends K, ? extends V> paramMultimap)
  {
    LinkedHashMultimap localLinkedHashMultimap = create(paramMultimap.keySet().size(), 2);
    localLinkedHashMultimap.putAll(paramMultimap);
    return localLinkedHashMultimap;
  }
  
  private static <K, V> void deleteFromMultimap(ValueEntry<K, V> paramValueEntry)
  {
    succeedsInMultimap(paramValueEntry.getPredecessorInMultimap(), paramValueEntry.getSuccessorInMultimap());
  }
  
  private static <K, V> void deleteFromValueSet(ValueSetLink<K, V> paramValueSetLink)
  {
    succeedsInValueSet(paramValueSetLink.getPredecessorInValueSet(), paramValueSetLink.getSuccessorInValueSet());
  }
  
  @GwtIncompatible
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this.multimapHeaderEntry = new ValueEntry(null, null, 0, null);
    succeedsInMultimap(this.multimapHeaderEntry, this.multimapHeaderEntry);
    this.valueSetCapacity = 2;
    int j = paramObjectInputStream.readInt();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    int i = 0;
    Object localObject1;
    while (i < j)
    {
      localObject1 = paramObjectInputStream.readObject();
      localLinkedHashMap.put(localObject1, createCollection(localObject1));
      i += 1;
    }
    j = paramObjectInputStream.readInt();
    i = 0;
    while (i < j)
    {
      localObject1 = paramObjectInputStream.readObject();
      Object localObject2 = paramObjectInputStream.readObject();
      ((Collection)localLinkedHashMap.get(localObject1)).add(localObject2);
      i += 1;
    }
    setMap(localLinkedHashMap);
  }
  
  private static <K, V> void succeedsInMultimap(ValueEntry<K, V> paramValueEntry1, ValueEntry<K, V> paramValueEntry2)
  {
    paramValueEntry1.setSuccessorInMultimap(paramValueEntry2);
    paramValueEntry2.setPredecessorInMultimap(paramValueEntry1);
  }
  
  private static <K, V> void succeedsInValueSet(ValueSetLink<K, V> paramValueSetLink1, ValueSetLink<K, V> paramValueSetLink2)
  {
    paramValueSetLink1.setSuccessorInValueSet(paramValueSetLink2);
    paramValueSetLink2.setPredecessorInValueSet(paramValueSetLink1);
  }
  
  @GwtIncompatible
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeInt(keySet().size());
    Iterator localIterator = keySet().iterator();
    while (localIterator.hasNext()) {
      paramObjectOutputStream.writeObject(localIterator.next());
    }
    paramObjectOutputStream.writeInt(size());
    localIterator = entries().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramObjectOutputStream.writeObject(localEntry.getKey());
      paramObjectOutputStream.writeObject(localEntry.getValue());
    }
  }
  
  public void clear()
  {
    super.clear();
    succeedsInMultimap(this.multimapHeaderEntry, this.multimapHeaderEntry);
  }
  
  Collection<V> createCollection(K paramK)
  {
    return new ValueSet(paramK, this.valueSetCapacity);
  }
  
  Set<V> createCollection()
  {
    return new LinkedHashSet(this.valueSetCapacity);
  }
  
  public Set<Map.Entry<K, V>> entries()
  {
    return super.entries();
  }
  
  Iterator<Map.Entry<K, V>> entryIterator()
  {
    return new LinkedHashMultimap.1(this);
  }
  
  public Set<K> keySet()
  {
    return super.keySet();
  }
  
  @CanIgnoreReturnValue
  public Set<V> replaceValues(@Nullable K paramK, Iterable<? extends V> paramIterable)
  {
    return super.replaceValues(paramK, paramIterable);
  }
  
  Iterator<V> valueIterator()
  {
    return Maps.valueIterator(entryIterator());
  }
  
  public Collection<V> values()
  {
    return super.values();
  }
  
  @VisibleForTesting
  static final class ValueEntry<K, V>
    extends ImmutableEntry<K, V>
    implements LinkedHashMultimap.ValueSetLink<K, V>
  {
    @Nullable
    ValueEntry<K, V> nextInValueBucket;
    ValueEntry<K, V> predecessorInMultimap;
    LinkedHashMultimap.ValueSetLink<K, V> predecessorInValueSet;
    final int smearedValueHash;
    ValueEntry<K, V> successorInMultimap;
    LinkedHashMultimap.ValueSetLink<K, V> successorInValueSet;
    
    ValueEntry(@Nullable K paramK, @Nullable V paramV, int paramInt, @Nullable ValueEntry<K, V> paramValueEntry)
    {
      super(paramV);
      this.smearedValueHash = paramInt;
      this.nextInValueBucket = paramValueEntry;
    }
    
    public ValueEntry<K, V> getPredecessorInMultimap()
    {
      return this.predecessorInMultimap;
    }
    
    public LinkedHashMultimap.ValueSetLink<K, V> getPredecessorInValueSet()
    {
      return this.predecessorInValueSet;
    }
    
    public ValueEntry<K, V> getSuccessorInMultimap()
    {
      return this.successorInMultimap;
    }
    
    public LinkedHashMultimap.ValueSetLink<K, V> getSuccessorInValueSet()
    {
      return this.successorInValueSet;
    }
    
    boolean matchesValue(@Nullable Object paramObject, int paramInt)
    {
      return (this.smearedValueHash == paramInt) && (Objects.equal(getValue(), paramObject));
    }
    
    public void setPredecessorInMultimap(ValueEntry<K, V> paramValueEntry)
    {
      this.predecessorInMultimap = paramValueEntry;
    }
    
    public void setPredecessorInValueSet(LinkedHashMultimap.ValueSetLink<K, V> paramValueSetLink)
    {
      this.predecessorInValueSet = paramValueSetLink;
    }
    
    public void setSuccessorInMultimap(ValueEntry<K, V> paramValueEntry)
    {
      this.successorInMultimap = paramValueEntry;
    }
    
    public void setSuccessorInValueSet(LinkedHashMultimap.ValueSetLink<K, V> paramValueSetLink)
    {
      this.successorInValueSet = paramValueSetLink;
    }
  }
  
  @VisibleForTesting
  final class ValueSet
    extends Sets.ImprovedAbstractSet<V>
    implements LinkedHashMultimap.ValueSetLink<K, V>
  {
    private LinkedHashMultimap.ValueSetLink<K, V> firstEntry;
    @VisibleForTesting
    LinkedHashMultimap.ValueEntry<K, V>[] hashTable;
    private final K key;
    private LinkedHashMultimap.ValueSetLink<K, V> lastEntry;
    private int modCount = 0;
    private int size = 0;
    
    ValueSet(int paramInt)
    {
      this.key = paramInt;
      this.firstEntry = this;
      this.lastEntry = this;
      int i;
      this.hashTable = new LinkedHashMultimap.ValueEntry[Hashing.closedTableSize(i, 1.0D)];
    }
    
    private int mask()
    {
      return this.hashTable.length - 1;
    }
    
    private void rehashIfNecessary()
    {
      if (Hashing.needsResizing(this.size, this.hashTable.length, 1.0D))
      {
        LinkedHashMultimap.ValueEntry[] arrayOfValueEntry = new LinkedHashMultimap.ValueEntry[this.hashTable.length * 2];
        this.hashTable = arrayOfValueEntry;
        int i = arrayOfValueEntry.length;
        for (LinkedHashMultimap.ValueSetLink localValueSetLink = this.firstEntry; localValueSetLink != this; localValueSetLink = localValueSetLink.getSuccessorInValueSet())
        {
          LinkedHashMultimap.ValueEntry localValueEntry = (LinkedHashMultimap.ValueEntry)localValueSetLink;
          int j = localValueEntry.smearedValueHash & i - 1;
          localValueEntry.nextInValueBucket = arrayOfValueEntry[j];
          arrayOfValueEntry[j] = localValueEntry;
        }
      }
    }
    
    public boolean add(@Nullable V paramV)
    {
      int i = Hashing.smearedHash(paramV);
      int j = i & mask();
      LinkedHashMultimap.ValueEntry localValueEntry2 = this.hashTable[j];
      for (LinkedHashMultimap.ValueEntry localValueEntry1 = localValueEntry2; localValueEntry1 != null; localValueEntry1 = localValueEntry1.nextInValueBucket) {
        if (localValueEntry1.matchesValue(paramV, i)) {
          return false;
        }
      }
      paramV = new LinkedHashMultimap.ValueEntry(this.key, paramV, i, localValueEntry2);
      LinkedHashMultimap.succeedsInValueSet(this.lastEntry, paramV);
      LinkedHashMultimap.succeedsInValueSet(paramV, this);
      LinkedHashMultimap.succeedsInMultimap(LinkedHashMultimap.this.multimapHeaderEntry.getPredecessorInMultimap(), paramV);
      LinkedHashMultimap.succeedsInMultimap(paramV, LinkedHashMultimap.this.multimapHeaderEntry);
      this.hashTable[j] = paramV;
      this.size += 1;
      this.modCount += 1;
      rehashIfNecessary();
      return true;
    }
    
    public void clear()
    {
      Arrays.fill(this.hashTable, null);
      this.size = 0;
      for (LinkedHashMultimap.ValueSetLink localValueSetLink = this.firstEntry; localValueSetLink != this; localValueSetLink = localValueSetLink.getSuccessorInValueSet()) {
        LinkedHashMultimap.deleteFromMultimap((LinkedHashMultimap.ValueEntry)localValueSetLink);
      }
      LinkedHashMultimap.succeedsInValueSet(this, this);
      this.modCount += 1;
    }
    
    public boolean contains(@Nullable Object paramObject)
    {
      int i = Hashing.smearedHash(paramObject);
      for (LinkedHashMultimap.ValueEntry localValueEntry = this.hashTable[(mask() & i)]; localValueEntry != null; localValueEntry = localValueEntry.nextInValueBucket) {
        if (localValueEntry.matchesValue(paramObject, i)) {
          return true;
        }
      }
      return false;
    }
    
    public LinkedHashMultimap.ValueSetLink<K, V> getPredecessorInValueSet()
    {
      return this.lastEntry;
    }
    
    public LinkedHashMultimap.ValueSetLink<K, V> getSuccessorInValueSet()
    {
      return this.firstEntry;
    }
    
    public Iterator<V> iterator()
    {
      return new LinkedHashMultimap.ValueSet.1(this);
    }
    
    @CanIgnoreReturnValue
    public boolean remove(@Nullable Object paramObject)
    {
      int i = Hashing.smearedHash(paramObject);
      int j = i & mask();
      Object localObject2 = null;
      LinkedHashMultimap.ValueEntry localValueEntry;
      for (Object localObject1 = this.hashTable[j]; localObject1 != null; localObject1 = localValueEntry)
      {
        if (((LinkedHashMultimap.ValueEntry)localObject1).matchesValue(paramObject, i))
        {
          if (localObject2 == null) {
            this.hashTable[j] = ((LinkedHashMultimap.ValueEntry)localObject1).nextInValueBucket;
          }
          for (;;)
          {
            LinkedHashMultimap.deleteFromValueSet((LinkedHashMultimap.ValueSetLink)localObject1);
            LinkedHashMultimap.deleteFromMultimap((LinkedHashMultimap.ValueEntry)localObject1);
            this.size -= 1;
            this.modCount += 1;
            return true;
            localObject2.nextInValueBucket = ((LinkedHashMultimap.ValueEntry)localObject1).nextInValueBucket;
          }
        }
        localValueEntry = ((LinkedHashMultimap.ValueEntry)localObject1).nextInValueBucket;
        localObject2 = localObject1;
      }
      return false;
    }
    
    public void setPredecessorInValueSet(LinkedHashMultimap.ValueSetLink<K, V> paramValueSetLink)
    {
      this.lastEntry = paramValueSetLink;
    }
    
    public void setSuccessorInValueSet(LinkedHashMultimap.ValueSetLink<K, V> paramValueSetLink)
    {
      this.firstEntry = paramValueSetLink;
    }
    
    public int size()
    {
      return this.size;
    }
  }
  
  static abstract interface ValueSetLink<K, V>
  {
    public abstract ValueSetLink<K, V> getPredecessorInValueSet();
    
    public abstract ValueSetLink<K, V> getSuccessorInValueSet();
    
    public abstract void setPredecessorInValueSet(ValueSetLink<K, V> paramValueSetLink);
    
    public abstract void setSuccessorInValueSet(ValueSetLink<K, V> paramValueSetLink);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.LinkedHashMultimap
 * JD-Core Version:    0.7.0.1
 */