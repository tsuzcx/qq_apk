package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class HashBiMap<K, V>
  extends Maps.IteratorBasedAbstractMap<K, V>
  implements BiMap<K, V>, Serializable
{
  private static final double LOAD_FACTOR = 1.0D;
  @GwtIncompatible
  private static final long serialVersionUID = 0L;
  private transient BiEntry<K, V> firstInKeyInsertionOrder;
  private transient BiEntry<K, V>[] hashTableKToV;
  private transient BiEntry<K, V>[] hashTableVToK;
  @RetainedWith
  private transient BiMap<V, K> inverse;
  private transient BiEntry<K, V> lastInKeyInsertionOrder;
  private transient int mask;
  private transient int modCount;
  private transient int size;
  
  private HashBiMap(int paramInt)
  {
    init(paramInt);
  }
  
  public static <K, V> HashBiMap<K, V> create()
  {
    return create(16);
  }
  
  public static <K, V> HashBiMap<K, V> create(int paramInt)
  {
    return new HashBiMap(paramInt);
  }
  
  public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> paramMap)
  {
    HashBiMap localHashBiMap = create(paramMap.size());
    localHashBiMap.putAll(paramMap);
    return localHashBiMap;
  }
  
  private BiEntry<K, V>[] createTable(int paramInt)
  {
    return new BiEntry[paramInt];
  }
  
  private void delete(BiEntry<K, V> paramBiEntry)
  {
    BiEntry localBiEntry1 = null;
    int i = paramBiEntry.keyHash & this.mask;
    Object localObject1 = this.hashTableKToV[i];
    Object localObject2 = null;
    if (localObject1 == paramBiEntry) {
      if (localObject2 == null)
      {
        this.hashTableKToV[i] = paramBiEntry.nextInKToVBucket;
        label43:
        i = paramBiEntry.valueHash;
        i = this.mask & i;
        localObject1 = this.hashTableVToK[i];
        localObject2 = localBiEntry1;
        label66:
        if (localObject1 != paramBiEntry) {
          break label176;
        }
        if (localObject2 != null) {
          break label164;
        }
        this.hashTableVToK[i] = paramBiEntry.nextInVToKBucket;
        label86:
        if (paramBiEntry.prevInKeyInsertionOrder != null) {
          break label191;
        }
        this.firstInKeyInsertionOrder = paramBiEntry.nextInKeyInsertionOrder;
        label101:
        if (paramBiEntry.nextInKeyInsertionOrder != null) {
          break label205;
        }
        this.lastInKeyInsertionOrder = paramBiEntry.prevInKeyInsertionOrder;
      }
    }
    for (;;)
    {
      this.size -= 1;
      this.modCount += 1;
      return;
      ((BiEntry)localObject2).nextInKToVBucket = paramBiEntry.nextInKToVBucket;
      break label43;
      BiEntry localBiEntry2 = ((BiEntry)localObject1).nextInKToVBucket;
      localObject2 = localObject1;
      localObject1 = localBiEntry2;
      break;
      label164:
      ((BiEntry)localObject2).nextInVToKBucket = paramBiEntry.nextInVToKBucket;
      break label86;
      label176:
      localBiEntry1 = ((BiEntry)localObject1).nextInVToKBucket;
      localObject2 = localObject1;
      localObject1 = localBiEntry1;
      break label66;
      label191:
      paramBiEntry.prevInKeyInsertionOrder.nextInKeyInsertionOrder = paramBiEntry.nextInKeyInsertionOrder;
      break label101;
      label205:
      paramBiEntry.nextInKeyInsertionOrder.prevInKeyInsertionOrder = paramBiEntry.prevInKeyInsertionOrder;
    }
  }
  
  private void init(int paramInt)
  {
    CollectPreconditions.checkNonnegative(paramInt, "expectedSize");
    paramInt = Hashing.closedTableSize(paramInt, 1.0D);
    this.hashTableKToV = createTable(paramInt);
    this.hashTableVToK = createTable(paramInt);
    this.firstInKeyInsertionOrder = null;
    this.lastInKeyInsertionOrder = null;
    this.size = 0;
    this.mask = (paramInt - 1);
    this.modCount = 0;
  }
  
  private void insert(BiEntry<K, V> paramBiEntry1, @Nullable BiEntry<K, V> paramBiEntry2)
  {
    int i = paramBiEntry1.keyHash & this.mask;
    paramBiEntry1.nextInKToVBucket = this.hashTableKToV[i];
    this.hashTableKToV[i] = paramBiEntry1;
    i = paramBiEntry1.valueHash & this.mask;
    paramBiEntry1.nextInVToKBucket = this.hashTableVToK[i];
    this.hashTableVToK[i] = paramBiEntry1;
    if (paramBiEntry2 == null)
    {
      paramBiEntry1.prevInKeyInsertionOrder = this.lastInKeyInsertionOrder;
      paramBiEntry1.nextInKeyInsertionOrder = null;
      if (this.lastInKeyInsertionOrder == null)
      {
        this.firstInKeyInsertionOrder = paramBiEntry1;
        this.lastInKeyInsertionOrder = paramBiEntry1;
      }
    }
    for (;;)
    {
      this.size += 1;
      this.modCount += 1;
      return;
      this.lastInKeyInsertionOrder.nextInKeyInsertionOrder = paramBiEntry1;
      break;
      paramBiEntry1.prevInKeyInsertionOrder = paramBiEntry2.prevInKeyInsertionOrder;
      if (paramBiEntry1.prevInKeyInsertionOrder == null) {
        this.firstInKeyInsertionOrder = paramBiEntry1;
      }
      for (;;)
      {
        paramBiEntry1.nextInKeyInsertionOrder = paramBiEntry2.nextInKeyInsertionOrder;
        if (paramBiEntry1.nextInKeyInsertionOrder != null) {
          break label174;
        }
        this.lastInKeyInsertionOrder = paramBiEntry1;
        break;
        paramBiEntry1.prevInKeyInsertionOrder.nextInKeyInsertionOrder = paramBiEntry1;
      }
      label174:
      paramBiEntry1.nextInKeyInsertionOrder.prevInKeyInsertionOrder = paramBiEntry1;
    }
  }
  
  private V put(@Nullable K paramK, @Nullable V paramV, boolean paramBoolean)
  {
    int i = Hashing.smearedHash(paramK);
    int j = Hashing.smearedHash(paramV);
    BiEntry localBiEntry1 = seekByKey(paramK, i);
    if ((localBiEntry1 != null) && (j == localBiEntry1.valueHash) && (Objects.equal(paramV, localBiEntry1.value))) {
      return paramV;
    }
    BiEntry localBiEntry2 = seekByValue(paramV, j);
    if (localBiEntry2 != null)
    {
      if (paramBoolean) {
        delete(localBiEntry2);
      }
    }
    else
    {
      paramK = new BiEntry(paramK, i, paramV, j);
      if (localBiEntry1 == null) {
        break label155;
      }
      delete(localBiEntry1);
      insert(paramK, localBiEntry1);
      localBiEntry1.prevInKeyInsertionOrder = null;
      localBiEntry1.nextInKeyInsertionOrder = null;
      rehashIfNecessary();
      return localBiEntry1.value;
    }
    throw new IllegalArgumentException("value already present: " + paramV);
    label155:
    insert(paramK, null);
    rehashIfNecessary();
    return null;
  }
  
  @Nullable
  private K putInverse(@Nullable V paramV, @Nullable K paramK, boolean paramBoolean)
  {
    int i = Hashing.smearedHash(paramV);
    int j = Hashing.smearedHash(paramK);
    BiEntry localBiEntry1 = seekByValue(paramV, i);
    if ((localBiEntry1 != null) && (j == localBiEntry1.keyHash) && (Objects.equal(paramK, localBiEntry1.key))) {
      return paramK;
    }
    BiEntry localBiEntry2 = seekByKey(paramK, j);
    if (localBiEntry2 != null)
    {
      if (paramBoolean) {
        delete(localBiEntry2);
      }
    }
    else
    {
      if (localBiEntry1 != null) {
        delete(localBiEntry1);
      }
      insert(new BiEntry(paramK, j, paramV, i), localBiEntry2);
      if (localBiEntry2 != null)
      {
        localBiEntry2.prevInKeyInsertionOrder = null;
        localBiEntry2.nextInKeyInsertionOrder = null;
      }
      rehashIfNecessary();
      return Maps.keyOrNull(localBiEntry1);
    }
    throw new IllegalArgumentException("value already present: " + paramK);
  }
  
  @GwtIncompatible
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    init(16);
    Serialization.populateMap(this, paramObjectInputStream, Serialization.readCount(paramObjectInputStream));
  }
  
  private void rehashIfNecessary()
  {
    Object localObject = this.hashTableKToV;
    if (Hashing.needsResizing(this.size, localObject.length, 1.0D))
    {
      int i = localObject.length * 2;
      this.hashTableKToV = createTable(i);
      this.hashTableVToK = createTable(i);
      this.mask = (i - 1);
      this.size = 0;
      for (localObject = this.firstInKeyInsertionOrder; localObject != null; localObject = ((BiEntry)localObject).nextInKeyInsertionOrder) {
        insert((BiEntry)localObject, (BiEntry)localObject);
      }
      this.modCount += 1;
    }
  }
  
  private BiEntry<K, V> seekByKey(@Nullable Object paramObject, int paramInt)
  {
    for (BiEntry localBiEntry = this.hashTableKToV[(this.mask & paramInt)]; localBiEntry != null; localBiEntry = localBiEntry.nextInKToVBucket) {
      if ((paramInt == localBiEntry.keyHash) && (Objects.equal(paramObject, localBiEntry.key))) {
        return localBiEntry;
      }
    }
    return null;
  }
  
  private BiEntry<K, V> seekByValue(@Nullable Object paramObject, int paramInt)
  {
    for (BiEntry localBiEntry = this.hashTableVToK[(this.mask & paramInt)]; localBiEntry != null; localBiEntry = localBiEntry.nextInVToKBucket) {
      if ((paramInt == localBiEntry.valueHash) && (Objects.equal(paramObject, localBiEntry.value))) {
        return localBiEntry;
      }
    }
    return null;
  }
  
  @GwtIncompatible
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    Serialization.writeMap(this, paramObjectOutputStream);
  }
  
  public void clear()
  {
    this.size = 0;
    Arrays.fill(this.hashTableKToV, null);
    Arrays.fill(this.hashTableVToK, null);
    this.firstInKeyInsertionOrder = null;
    this.lastInKeyInsertionOrder = null;
    this.modCount += 1;
  }
  
  public boolean containsKey(@Nullable Object paramObject)
  {
    return seekByKey(paramObject, Hashing.smearedHash(paramObject)) != null;
  }
  
  public boolean containsValue(@Nullable Object paramObject)
  {
    return seekByValue(paramObject, Hashing.smearedHash(paramObject)) != null;
  }
  
  Iterator<Map.Entry<K, V>> entryIterator()
  {
    return new HashBiMap.1(this);
  }
  
  @CanIgnoreReturnValue
  public V forcePut(@Nullable K paramK, @Nullable V paramV)
  {
    return put(paramK, paramV, true);
  }
  
  @Nullable
  public V get(@Nullable Object paramObject)
  {
    return Maps.valueOrNull(seekByKey(paramObject, Hashing.smearedHash(paramObject)));
  }
  
  public BiMap<V, K> inverse()
  {
    if (this.inverse == null)
    {
      Inverse localInverse = new Inverse(null);
      this.inverse = localInverse;
      return localInverse;
    }
    return this.inverse;
  }
  
  public Set<K> keySet()
  {
    return new KeySet();
  }
  
  @CanIgnoreReturnValue
  public V put(@Nullable K paramK, @Nullable V paramV)
  {
    return put(paramK, paramV, false);
  }
  
  @CanIgnoreReturnValue
  public V remove(@Nullable Object paramObject)
  {
    paramObject = seekByKey(paramObject, Hashing.smearedHash(paramObject));
    if (paramObject == null) {
      return null;
    }
    delete(paramObject);
    paramObject.prevInKeyInsertionOrder = null;
    paramObject.nextInKeyInsertionOrder = null;
    return paramObject.value;
  }
  
  public int size()
  {
    return this.size;
  }
  
  public Set<V> values()
  {
    return inverse().keySet();
  }
  
  static final class BiEntry<K, V>
    extends ImmutableEntry<K, V>
  {
    final int keyHash;
    @Nullable
    BiEntry<K, V> nextInKToVBucket;
    @Nullable
    BiEntry<K, V> nextInKeyInsertionOrder;
    @Nullable
    BiEntry<K, V> nextInVToKBucket;
    @Nullable
    BiEntry<K, V> prevInKeyInsertionOrder;
    final int valueHash;
    
    BiEntry(K paramK, int paramInt1, V paramV, int paramInt2)
    {
      super(paramV);
      this.keyHash = paramInt1;
      this.valueHash = paramInt2;
    }
  }
  
  final class Inverse
    extends AbstractMap<V, K>
    implements BiMap<V, K>, Serializable
  {
    private Inverse() {}
    
    public void clear()
    {
      forward().clear();
    }
    
    public boolean containsKey(@Nullable Object paramObject)
    {
      return forward().containsValue(paramObject);
    }
    
    public Set<Map.Entry<V, K>> entrySet()
    {
      return new HashBiMap.Inverse.1(this);
    }
    
    public K forcePut(@Nullable V paramV, @Nullable K paramK)
    {
      return HashBiMap.this.putInverse(paramV, paramK, true);
    }
    
    BiMap<K, V> forward()
    {
      return HashBiMap.this;
    }
    
    public K get(@Nullable Object paramObject)
    {
      return Maps.keyOrNull(HashBiMap.this.seekByValue(paramObject, Hashing.smearedHash(paramObject)));
    }
    
    public BiMap<K, V> inverse()
    {
      return forward();
    }
    
    public Set<V> keySet()
    {
      return new InverseKeySet();
    }
    
    public K put(@Nullable V paramV, @Nullable K paramK)
    {
      return HashBiMap.this.putInverse(paramV, paramK, false);
    }
    
    public K remove(@Nullable Object paramObject)
    {
      paramObject = HashBiMap.this.seekByValue(paramObject, Hashing.smearedHash(paramObject));
      if (paramObject == null) {
        return null;
      }
      HashBiMap.this.delete(paramObject);
      paramObject.prevInKeyInsertionOrder = null;
      paramObject.nextInKeyInsertionOrder = null;
      return paramObject.key;
    }
    
    public int size()
    {
      return HashBiMap.this.size;
    }
    
    public Set<K> values()
    {
      return forward().keySet();
    }
    
    Object writeReplace()
    {
      return new HashBiMap.InverseSerializedForm(HashBiMap.this);
    }
    
    final class InverseKeySet
      extends Maps.KeySet<V, K>
    {
      InverseKeySet()
      {
        super();
      }
      
      public Iterator<V> iterator()
      {
        return new HashBiMap.Inverse.InverseKeySet.1(this);
      }
      
      public boolean remove(@Nullable Object paramObject)
      {
        paramObject = HashBiMap.this.seekByValue(paramObject, Hashing.smearedHash(paramObject));
        if (paramObject == null) {
          return false;
        }
        HashBiMap.this.delete(paramObject);
        return true;
      }
    }
  }
  
  static final class InverseSerializedForm<K, V>
    implements Serializable
  {
    private final HashBiMap<K, V> bimap;
    
    InverseSerializedForm(HashBiMap<K, V> paramHashBiMap)
    {
      this.bimap = paramHashBiMap;
    }
    
    Object readResolve()
    {
      return this.bimap.inverse();
    }
  }
  
  abstract class Itr<T>
    implements Iterator<T>
  {
    int expectedModCount = HashBiMap.this.modCount;
    HashBiMap.BiEntry<K, V> next = HashBiMap.this.firstInKeyInsertionOrder;
    HashBiMap.BiEntry<K, V> toRemove = null;
    
    Itr() {}
    
    public boolean hasNext()
    {
      if (HashBiMap.this.modCount != this.expectedModCount) {
        throw new ConcurrentModificationException();
      }
      return this.next != null;
    }
    
    public T next()
    {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      HashBiMap.BiEntry localBiEntry = this.next;
      this.next = localBiEntry.nextInKeyInsertionOrder;
      this.toRemove = localBiEntry;
      return output(localBiEntry);
    }
    
    abstract T output(HashBiMap.BiEntry<K, V> paramBiEntry);
    
    public void remove()
    {
      if (HashBiMap.this.modCount != this.expectedModCount) {
        throw new ConcurrentModificationException();
      }
      if (this.toRemove != null) {}
      for (boolean bool = true;; bool = false)
      {
        CollectPreconditions.checkRemove(bool);
        HashBiMap.this.delete(this.toRemove);
        this.expectedModCount = HashBiMap.this.modCount;
        this.toRemove = null;
        return;
      }
    }
  }
  
  final class KeySet
    extends Maps.KeySet<K, V>
  {
    KeySet()
    {
      super();
    }
    
    public Iterator<K> iterator()
    {
      return new HashBiMap.KeySet.1(this);
    }
    
    public boolean remove(@Nullable Object paramObject)
    {
      paramObject = HashBiMap.this.seekByKey(paramObject, Hashing.smearedHash(paramObject));
      if (paramObject == null) {
        return false;
      }
      HashBiMap.this.delete(paramObject);
      paramObject.prevInKeyInsertionOrder = null;
      paramObject.nextInKeyInsertionOrder = null;
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.HashBiMap
 * JD-Core Version:    0.7.0.1
 */