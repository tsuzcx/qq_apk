package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

@GwtIncompatible
class MapMakerInternalMap<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>>
  extends AbstractMap<K, V>
  implements Serializable, ConcurrentMap<K, V>
{
  static final long CLEANUP_EXECUTOR_DELAY_SECS = 60L;
  static final int CONTAINS_VALUE_RETRIES = 3;
  static final int DRAIN_MAX = 16;
  static final int DRAIN_THRESHOLD = 63;
  static final int MAXIMUM_CAPACITY = 1073741824;
  static final int MAX_SEGMENTS = 65536;
  static final WeakValueReference<Object, Object, DummyInternalEntry> UNSET_WEAK_VALUE_REFERENCE = new MapMakerInternalMap.1();
  private static final long serialVersionUID = 5L;
  final int concurrencyLevel;
  final transient InternalEntryHelper<K, V, E, S> entryHelper;
  transient Set<Map.Entry<K, V>> entrySet;
  final Equivalence<Object> keyEquivalence;
  transient Set<K> keySet;
  final transient int segmentMask;
  final transient int segmentShift;
  final transient Segment<K, V, E, S>[] segments;
  transient Collection<V> values;
  
  private MapMakerInternalMap(MapMaker paramMapMaker, InternalEntryHelper<K, V, E, S> paramInternalEntryHelper)
  {
    this.concurrencyLevel = Math.min(paramMapMaker.getConcurrencyLevel(), 65536);
    this.keyEquivalence = paramMapMaker.getKeyEquivalence();
    this.entryHelper = paramInternalEntryHelper;
    int n = Math.min(paramMapMaker.getInitialCapacity(), 1073741824);
    int i = 1;
    int j = 0;
    while (i < this.concurrencyLevel)
    {
      j += 1;
      i <<= 1;
    }
    this.segmentShift = (32 - j);
    this.segmentMask = (i - 1);
    this.segments = newSegmentArray(i);
    j = n / i;
    if (i * j < n)
    {
      i = j + 1;
      j = k;
    }
    for (;;)
    {
      k = m;
      if (j < i)
      {
        j <<= 1;
      }
      else
      {
        while (k < this.segments.length)
        {
          this.segments[k] = createSegment(j, -1);
          k += 1;
        }
        return;
        i = j;
        j = k;
      }
    }
  }
  
  static <K, V> MapMakerInternalMap<K, V, ? extends InternalEntry<K, V, ?>, ?> create(MapMaker paramMapMaker)
  {
    if ((paramMapMaker.getKeyStrength() == Strength.STRONG) && (paramMapMaker.getValueStrength() == Strength.STRONG)) {
      return new MapMakerInternalMap(paramMapMaker, MapMakerInternalMap.StrongKeyStrongValueEntry.Helper.instance());
    }
    if ((paramMapMaker.getKeyStrength() == Strength.STRONG) && (paramMapMaker.getValueStrength() == Strength.WEAK)) {
      return new MapMakerInternalMap(paramMapMaker, MapMakerInternalMap.StrongKeyWeakValueEntry.Helper.instance());
    }
    if ((paramMapMaker.getKeyStrength() == Strength.WEAK) && (paramMapMaker.getValueStrength() == Strength.STRONG)) {
      return new MapMakerInternalMap(paramMapMaker, MapMakerInternalMap.WeakKeyStrongValueEntry.Helper.instance());
    }
    if ((paramMapMaker.getKeyStrength() == Strength.WEAK) && (paramMapMaker.getValueStrength() == Strength.WEAK)) {
      return new MapMakerInternalMap(paramMapMaker, MapMakerInternalMap.WeakKeyWeakValueEntry.Helper.instance());
    }
    throw new AssertionError();
  }
  
  static int rehash(int paramInt)
  {
    paramInt = (paramInt << 15 ^ 0xFFFFCD7D) + paramInt;
    paramInt ^= paramInt >>> 10;
    paramInt += (paramInt << 3);
    paramInt ^= paramInt >>> 6;
    paramInt += (paramInt << 2) + (paramInt << 14);
    return paramInt ^ paramInt >>> 16;
  }
  
  private static <E> ArrayList<E> toArrayList(Collection<E> paramCollection)
  {
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    Iterators.addAll(localArrayList, paramCollection.iterator());
    return localArrayList;
  }
  
  static <K, V, E extends InternalEntry<K, V, E>> WeakValueReference<K, V, E> unsetWeakValueReference()
  {
    return UNSET_WEAK_VALUE_REFERENCE;
  }
  
  public void clear()
  {
    Segment[] arrayOfSegment = this.segments;
    int j = arrayOfSegment.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSegment[i].clear();
      i += 1;
    }
  }
  
  public boolean containsKey(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    int i = hash(paramObject);
    return segmentFor(i).containsKey(paramObject, i);
  }
  
  public boolean containsValue(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    Segment[] arrayOfSegment = this.segments;
    int i = 0;
    long l1;
    for (long l2 = -1L;; l2 = l1)
    {
      if (i < 3)
      {
        int m = arrayOfSegment.length;
        l1 = 0L;
        int j = 0;
        while (j < m)
        {
          Segment localSegment = arrayOfSegment[j];
          int k = localSegment.count;
          AtomicReferenceArray localAtomicReferenceArray = localSegment.table;
          k = 0;
          while (k < localAtomicReferenceArray.length())
          {
            for (InternalEntry localInternalEntry = (InternalEntry)localAtomicReferenceArray.get(k); localInternalEntry != null; localInternalEntry = localInternalEntry.getNext())
            {
              Object localObject = localSegment.getLiveValue(localInternalEntry);
              if ((localObject != null) && (valueEquivalence().equivalent(paramObject, localObject))) {
                return true;
              }
            }
            k += 1;
          }
          l1 += localSegment.modCount;
          j += 1;
        }
        if (l1 != l2) {}
      }
      else
      {
        return false;
      }
      i += 1;
    }
  }
  
  @VisibleForTesting
  E copyEntry(E paramE1, E paramE2)
  {
    return segmentFor(paramE1.getHash()).copyEntry(paramE1, paramE2);
  }
  
  Segment<K, V, E, S> createSegment(int paramInt1, int paramInt2)
  {
    return this.entryHelper.newSegment(this, paramInt1, paramInt2);
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    Object localObject = this.entrySet;
    if (localObject != null) {
      return localObject;
    }
    localObject = new EntrySet();
    this.entrySet = ((Set)localObject);
    return localObject;
  }
  
  public V get(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    int i = hash(paramObject);
    return segmentFor(i).get(paramObject, i);
  }
  
  E getEntry(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    int i = hash(paramObject);
    return segmentFor(i).getEntry(paramObject, i);
  }
  
  V getLiveValue(E paramE)
  {
    if (paramE.getKey() == null) {}
    do
    {
      return null;
      paramE = paramE.getValue();
    } while (paramE == null);
    return paramE;
  }
  
  int hash(Object paramObject)
  {
    return rehash(this.keyEquivalence.hash(paramObject));
  }
  
  public boolean isEmpty()
  {
    Segment[] arrayOfSegment = this.segments;
    int i = 0;
    long l = 0L;
    if (i < arrayOfSegment.length) {
      if (arrayOfSegment[i].count == 0) {}
    }
    label90:
    do
    {
      return false;
      l += arrayOfSegment[i].modCount;
      i += 1;
      break;
      if (l == 0L) {
        break label96;
      }
      i = 0;
      for (;;)
      {
        if (i >= arrayOfSegment.length) {
          break label90;
        }
        if (arrayOfSegment[i].count != 0) {
          break;
        }
        l -= arrayOfSegment[i].modCount;
        i += 1;
      }
    } while (l != 0L);
    label96:
    return true;
  }
  
  @VisibleForTesting
  boolean isLiveForTesting(InternalEntry<K, V, ?> paramInternalEntry)
  {
    return segmentFor(paramInternalEntry.getHash()).getLiveValueForTesting(paramInternalEntry) != null;
  }
  
  public Set<K> keySet()
  {
    Object localObject = this.keySet;
    if (localObject != null) {
      return localObject;
    }
    localObject = new KeySet();
    this.keySet = ((Set)localObject);
    return localObject;
  }
  
  @VisibleForTesting
  Strength keyStrength()
  {
    return this.entryHelper.keyStrength();
  }
  
  final Segment<K, V, E, S>[] newSegmentArray(int paramInt)
  {
    return new Segment[paramInt];
  }
  
  @CanIgnoreReturnValue
  public V put(K paramK, V paramV)
  {
    Preconditions.checkNotNull(paramK);
    Preconditions.checkNotNull(paramV);
    int i = hash(paramK);
    return segmentFor(i).put(paramK, i, paramV, false);
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
  }
  
  @CanIgnoreReturnValue
  public V putIfAbsent(K paramK, V paramV)
  {
    Preconditions.checkNotNull(paramK);
    Preconditions.checkNotNull(paramV);
    int i = hash(paramK);
    return segmentFor(i).put(paramK, i, paramV, true);
  }
  
  void reclaimKey(E paramE)
  {
    int i = paramE.getHash();
    segmentFor(i).reclaimKey(paramE, i);
  }
  
  void reclaimValue(WeakValueReference<K, V, E> paramWeakValueReference)
  {
    InternalEntry localInternalEntry = paramWeakValueReference.getEntry();
    int i = localInternalEntry.getHash();
    segmentFor(i).reclaimValue(localInternalEntry.getKey(), i, paramWeakValueReference);
  }
  
  @CanIgnoreReturnValue
  public V remove(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    int i = hash(paramObject);
    return segmentFor(i).remove(paramObject, i);
  }
  
  @CanIgnoreReturnValue
  public boolean remove(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    if ((paramObject1 == null) || (paramObject2 == null)) {
      return false;
    }
    int i = hash(paramObject1);
    return segmentFor(i).remove(paramObject1, i, paramObject2);
  }
  
  @CanIgnoreReturnValue
  public V replace(K paramK, V paramV)
  {
    Preconditions.checkNotNull(paramK);
    Preconditions.checkNotNull(paramV);
    int i = hash(paramK);
    return segmentFor(i).replace(paramK, i, paramV);
  }
  
  @CanIgnoreReturnValue
  public boolean replace(K paramK, @Nullable V paramV1, V paramV2)
  {
    Preconditions.checkNotNull(paramK);
    Preconditions.checkNotNull(paramV2);
    if (paramV1 == null) {
      return false;
    }
    int i = hash(paramK);
    return segmentFor(i).replace(paramK, i, paramV1, paramV2);
  }
  
  Segment<K, V, E, S> segmentFor(int paramInt)
  {
    return this.segments[(paramInt >>> this.segmentShift & this.segmentMask)];
  }
  
  public int size()
  {
    Segment[] arrayOfSegment = this.segments;
    long l = 0L;
    int i = 0;
    while (i < arrayOfSegment.length)
    {
      l += arrayOfSegment[i].count;
      i += 1;
    }
    return Ints.saturatedCast(l);
  }
  
  @VisibleForTesting
  Equivalence<Object> valueEquivalence()
  {
    return this.entryHelper.valueStrength().defaultEquivalence();
  }
  
  @VisibleForTesting
  Strength valueStrength()
  {
    return this.entryHelper.valueStrength();
  }
  
  public Collection<V> values()
  {
    Object localObject = this.values;
    if (localObject != null) {
      return localObject;
    }
    localObject = new Values();
    this.values = ((Collection)localObject);
    return localObject;
  }
  
  Object writeReplace()
  {
    return new SerializationProxy(this.entryHelper.keyStrength(), this.entryHelper.valueStrength(), this.keyEquivalence, this.entryHelper.valueStrength().defaultEquivalence(), this.concurrencyLevel, this);
  }
  
  static abstract class AbstractSerializationProxy<K, V>
    extends ForwardingConcurrentMap<K, V>
    implements Serializable
  {
    private static final long serialVersionUID = 3L;
    final int concurrencyLevel;
    transient ConcurrentMap<K, V> delegate;
    final Equivalence<Object> keyEquivalence;
    final MapMakerInternalMap.Strength keyStrength;
    final Equivalence<Object> valueEquivalence;
    final MapMakerInternalMap.Strength valueStrength;
    
    AbstractSerializationProxy(MapMakerInternalMap.Strength paramStrength1, MapMakerInternalMap.Strength paramStrength2, Equivalence<Object> paramEquivalence1, Equivalence<Object> paramEquivalence2, int paramInt, ConcurrentMap<K, V> paramConcurrentMap)
    {
      this.keyStrength = paramStrength1;
      this.valueStrength = paramStrength2;
      this.keyEquivalence = paramEquivalence1;
      this.valueEquivalence = paramEquivalence2;
      this.concurrencyLevel = paramInt;
      this.delegate = paramConcurrentMap;
    }
    
    protected ConcurrentMap<K, V> delegate()
    {
      return this.delegate;
    }
    
    void readEntries(ObjectInputStream paramObjectInputStream)
      throws IOException, ClassNotFoundException
    {
      for (;;)
      {
        Object localObject1 = paramObjectInputStream.readObject();
        if (localObject1 == null) {
          return;
        }
        Object localObject2 = paramObjectInputStream.readObject();
        this.delegate.put(localObject1, localObject2);
      }
    }
    
    MapMaker readMapMaker(ObjectInputStream paramObjectInputStream)
      throws IOException
    {
      int i = paramObjectInputStream.readInt();
      return new MapMaker().initialCapacity(i).setKeyStrength(this.keyStrength).setValueStrength(this.valueStrength).keyEquivalence(this.keyEquivalence).concurrencyLevel(this.concurrencyLevel);
    }
    
    void writeMapTo(ObjectOutputStream paramObjectOutputStream)
      throws IOException
    {
      paramObjectOutputStream.writeInt(this.delegate.size());
      Iterator localIterator = this.delegate.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramObjectOutputStream.writeObject(localEntry.getKey());
        paramObjectOutputStream.writeObject(localEntry.getValue());
      }
      paramObjectOutputStream.writeObject(null);
    }
  }
  
  static abstract class AbstractStrongKeyEntry<K, V, E extends MapMakerInternalMap.InternalEntry<K, V, E>>
    implements MapMakerInternalMap.InternalEntry<K, V, E>
  {
    final int hash;
    final K key;
    final E next;
    
    AbstractStrongKeyEntry(K paramK, int paramInt, @Nullable E paramE)
    {
      this.key = paramK;
      this.hash = paramInt;
      this.next = paramE;
    }
    
    public int getHash()
    {
      return this.hash;
    }
    
    public K getKey()
    {
      return this.key;
    }
    
    public E getNext()
    {
      return this.next;
    }
  }
  
  static abstract class AbstractWeakKeyEntry<K, V, E extends MapMakerInternalMap.InternalEntry<K, V, E>>
    extends WeakReference<K>
    implements MapMakerInternalMap.InternalEntry<K, V, E>
  {
    final int hash;
    final E next;
    
    AbstractWeakKeyEntry(ReferenceQueue<K> paramReferenceQueue, K paramK, int paramInt, @Nullable E paramE)
    {
      super(paramReferenceQueue);
      this.hash = paramInt;
      this.next = paramE;
    }
    
    public int getHash()
    {
      return this.hash;
    }
    
    public K getKey()
    {
      return get();
    }
    
    public E getNext()
    {
      return this.next;
    }
  }
  
  static final class CleanupMapTask
    implements Runnable
  {
    final WeakReference<MapMakerInternalMap<?, ?, ?, ?>> mapReference;
    
    public CleanupMapTask(MapMakerInternalMap<?, ?, ?, ?> paramMapMakerInternalMap)
    {
      this.mapReference = new WeakReference(paramMapMakerInternalMap);
    }
    
    public void run()
    {
      Object localObject = (MapMakerInternalMap)this.mapReference.get();
      if (localObject == null) {
        throw new CancellationException();
      }
      localObject = ((MapMakerInternalMap)localObject).segments;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localObject[i].runCleanup();
        i += 1;
      }
    }
  }
  
  static final class DummyInternalEntry
    implements MapMakerInternalMap.InternalEntry<Object, Object, DummyInternalEntry>
  {
    private DummyInternalEntry()
    {
      throw new AssertionError();
    }
    
    public int getHash()
    {
      throw new AssertionError();
    }
    
    public Object getKey()
    {
      throw new AssertionError();
    }
    
    public DummyInternalEntry getNext()
    {
      throw new AssertionError();
    }
    
    public Object getValue()
    {
      throw new AssertionError();
    }
  }
  
  final class EntryIterator
    extends MapMakerInternalMap<K, V, E, S>.HashIterator<Map.Entry<K, V>>
  {
    EntryIterator()
    {
      super();
    }
    
    public Map.Entry<K, V> next()
    {
      return nextEntry();
    }
  }
  
  final class EntrySet
    extends MapMakerInternalMap.SafeToArraySet<Map.Entry<K, V>>
  {
    EntrySet()
    {
      super();
    }
    
    public void clear()
    {
      MapMakerInternalMap.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      if (!(paramObject instanceof Map.Entry)) {}
      Object localObject;
      do
      {
        do
        {
          return false;
          paramObject = (Map.Entry)paramObject;
          localObject = paramObject.getKey();
        } while (localObject == null);
        localObject = MapMakerInternalMap.this.get(localObject);
      } while ((localObject == null) || (!MapMakerInternalMap.this.valueEquivalence().equivalent(paramObject.getValue(), localObject)));
      return true;
    }
    
    public boolean isEmpty()
    {
      return MapMakerInternalMap.this.isEmpty();
    }
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      return new MapMakerInternalMap.EntryIterator(MapMakerInternalMap.this);
    }
    
    public boolean remove(Object paramObject)
    {
      if (!(paramObject instanceof Map.Entry)) {}
      Object localObject;
      do
      {
        return false;
        paramObject = (Map.Entry)paramObject;
        localObject = paramObject.getKey();
      } while ((localObject == null) || (!MapMakerInternalMap.this.remove(localObject, paramObject.getValue())));
      return true;
    }
    
    public int size()
    {
      return MapMakerInternalMap.this.size();
    }
  }
  
  abstract class HashIterator<T>
    implements Iterator<T>
  {
    MapMakerInternalMap.Segment<K, V, E, S> currentSegment;
    AtomicReferenceArray<E> currentTable;
    MapMakerInternalMap<K, V, E, S>.WriteThroughEntry lastReturned;
    E nextEntry;
    MapMakerInternalMap<K, V, E, S>.WriteThroughEntry nextExternal;
    int nextSegmentIndex = MapMakerInternalMap.this.segments.length - 1;
    int nextTableIndex = -1;
    
    HashIterator()
    {
      advance();
    }
    
    final void advance()
    {
      this.nextExternal = null;
      if (nextInChain()) {}
      do
      {
        do
        {
          do
          {
            ;;
            while (nextInTable()) {}
          } while (this.nextSegmentIndex < 0);
          MapMakerInternalMap.Segment[] arrayOfSegment = MapMakerInternalMap.this.segments;
          int i = this.nextSegmentIndex;
          this.nextSegmentIndex = (i - 1);
          this.currentSegment = arrayOfSegment[i];
        } while (this.currentSegment.count == 0);
        this.currentTable = this.currentSegment.table;
        this.nextTableIndex = (this.currentTable.length() - 1);
      } while (!nextInTable());
    }
    
    boolean advanceTo(E paramE)
    {
      try
      {
        Object localObject = paramE.getKey();
        paramE = MapMakerInternalMap.this.getLiveValue(paramE);
        if (paramE != null)
        {
          this.nextExternal = new MapMakerInternalMap.WriteThroughEntry(MapMakerInternalMap.this, localObject, paramE);
          return true;
        }
        return false;
      }
      finally
      {
        this.currentSegment.postReadCleanup();
      }
    }
    
    public boolean hasNext()
    {
      return this.nextExternal != null;
    }
    
    public abstract T next();
    
    MapMakerInternalMap<K, V, E, S>.WriteThroughEntry nextEntry()
    {
      if (this.nextExternal == null) {
        throw new NoSuchElementException();
      }
      this.lastReturned = this.nextExternal;
      advance();
      return this.lastReturned;
    }
    
    boolean nextInChain()
    {
      if (this.nextEntry != null) {
        for (this.nextEntry = this.nextEntry.getNext(); this.nextEntry != null; this.nextEntry = this.nextEntry.getNext()) {
          if (advanceTo(this.nextEntry)) {
            return true;
          }
        }
      }
      return false;
    }
    
    boolean nextInTable()
    {
      while (this.nextTableIndex >= 0)
      {
        Object localObject = this.currentTable;
        int i = this.nextTableIndex;
        this.nextTableIndex = (i - 1);
        localObject = (MapMakerInternalMap.InternalEntry)((AtomicReferenceArray)localObject).get(i);
        this.nextEntry = ((MapMakerInternalMap.InternalEntry)localObject);
        if ((localObject != null) && ((advanceTo(this.nextEntry)) || (nextInChain()))) {
          return true;
        }
      }
      return false;
    }
    
    public void remove()
    {
      if (this.lastReturned != null) {}
      for (boolean bool = true;; bool = false)
      {
        CollectPreconditions.checkRemove(bool);
        MapMakerInternalMap.this.remove(this.lastReturned.getKey());
        this.lastReturned = null;
        return;
      }
    }
  }
  
  static abstract interface InternalEntry<K, V, E extends InternalEntry<K, V, E>>
  {
    public abstract int getHash();
    
    public abstract K getKey();
    
    public abstract E getNext();
    
    public abstract V getValue();
  }
  
  static abstract interface InternalEntryHelper<K, V, E extends MapMakerInternalMap.InternalEntry<K, V, E>, S extends MapMakerInternalMap.Segment<K, V, E, S>>
  {
    public abstract E copy(S paramS, E paramE1, @Nullable E paramE2);
    
    public abstract MapMakerInternalMap.Strength keyStrength();
    
    public abstract E newEntry(S paramS, K paramK, int paramInt, @Nullable E paramE);
    
    public abstract S newSegment(MapMakerInternalMap<K, V, E, S> paramMapMakerInternalMap, int paramInt1, int paramInt2);
    
    public abstract void setValue(S paramS, E paramE, V paramV);
    
    public abstract MapMakerInternalMap.Strength valueStrength();
  }
  
  final class KeyIterator
    extends MapMakerInternalMap<K, V, E, S>.HashIterator<K>
  {
    KeyIterator()
    {
      super();
    }
    
    public K next()
    {
      return nextEntry().getKey();
    }
  }
  
  final class KeySet
    extends MapMakerInternalMap.SafeToArraySet<K>
  {
    KeySet()
    {
      super();
    }
    
    public void clear()
    {
      MapMakerInternalMap.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return MapMakerInternalMap.this.containsKey(paramObject);
    }
    
    public boolean isEmpty()
    {
      return MapMakerInternalMap.this.isEmpty();
    }
    
    public Iterator<K> iterator()
    {
      return new MapMakerInternalMap.KeyIterator(MapMakerInternalMap.this);
    }
    
    public boolean remove(Object paramObject)
    {
      return MapMakerInternalMap.this.remove(paramObject) != null;
    }
    
    public int size()
    {
      return MapMakerInternalMap.this.size();
    }
  }
  
  static abstract class SafeToArraySet<E>
    extends AbstractSet<E>
  {
    public Object[] toArray()
    {
      return MapMakerInternalMap.toArrayList(this).toArray();
    }
    
    public <E> E[] toArray(E[] paramArrayOfE)
    {
      return MapMakerInternalMap.toArrayList(this).toArray(paramArrayOfE);
    }
  }
  
  static abstract class Segment<K, V, E extends MapMakerInternalMap.InternalEntry<K, V, E>, S extends Segment<K, V, E, S>>
    extends ReentrantLock
  {
    volatile int count;
    @Weak
    final MapMakerInternalMap<K, V, E, S> map;
    final int maxSegmentSize;
    int modCount;
    final AtomicInteger readCount = new AtomicInteger();
    volatile AtomicReferenceArray<E> table;
    int threshold;
    
    Segment(MapMakerInternalMap<K, V, E, S> paramMapMakerInternalMap, int paramInt1, int paramInt2)
    {
      this.map = paramMapMakerInternalMap;
      this.maxSegmentSize = paramInt2;
      initTable(newEntryArray(paramInt1));
    }
    
    static <K, V, E extends MapMakerInternalMap.InternalEntry<K, V, E>> boolean isCollected(E paramE)
    {
      return paramE.getValue() == null;
    }
    
    abstract E castForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> paramInternalEntry);
    
    void clear()
    {
      int i = 0;
      if (this.count != 0) {
        lock();
      }
      try
      {
        AtomicReferenceArray localAtomicReferenceArray = this.table;
        while (i < localAtomicReferenceArray.length())
        {
          localAtomicReferenceArray.set(i, null);
          i += 1;
        }
        maybeClearReferenceQueues();
        this.readCount.set(0);
        this.modCount += 1;
        this.count = 0;
        return;
      }
      finally
      {
        unlock();
      }
    }
    
    <T> void clearReferenceQueue(ReferenceQueue<T> paramReferenceQueue)
    {
      while (paramReferenceQueue.poll() != null) {}
    }
    
    @CanIgnoreReturnValue
    boolean clearValueForTesting(K paramK, int paramInt, MapMakerInternalMap.WeakValueReference<K, V, ? extends MapMakerInternalMap.InternalEntry<K, V, ?>> paramWeakValueReference)
    {
      lock();
      try
      {
        AtomicReferenceArray localAtomicReferenceArray = this.table;
        int i = paramInt & localAtomicReferenceArray.length() - 1;
        MapMakerInternalMap.InternalEntry localInternalEntry2 = (MapMakerInternalMap.InternalEntry)localAtomicReferenceArray.get(i);
        for (MapMakerInternalMap.InternalEntry localInternalEntry1 = localInternalEntry2; localInternalEntry1 != null; localInternalEntry1 = localInternalEntry1.getNext())
        {
          Object localObject = localInternalEntry1.getKey();
          if ((localInternalEntry1.getHash() == paramInt) && (localObject != null) && (this.map.keyEquivalence.equivalent(paramK, localObject)))
          {
            if (((MapMakerInternalMap.WeakValueEntry)localInternalEntry1).getValueReference() == paramWeakValueReference)
            {
              localAtomicReferenceArray.set(i, removeFromChain(localInternalEntry2, localInternalEntry1));
              return true;
            }
            return false;
          }
        }
        return false;
      }
      finally
      {
        unlock();
      }
    }
    
    boolean containsKey(Object paramObject, int paramInt)
    {
      boolean bool2 = false;
      try
      {
        if (this.count != 0)
        {
          paramObject = getLiveEntry(paramObject, paramInt);
          boolean bool1 = bool2;
          if (paramObject != null)
          {
            paramObject = paramObject.getValue();
            bool1 = bool2;
            if (paramObject != null) {
              bool1 = true;
            }
          }
          return bool1;
        }
        return false;
      }
      finally
      {
        postReadCleanup();
      }
    }
    
    @VisibleForTesting
    boolean containsValue(Object paramObject)
    {
      try
      {
        if (this.count != 0)
        {
          AtomicReferenceArray localAtomicReferenceArray = this.table;
          int j = localAtomicReferenceArray.length();
          int i = 0;
          while (i < j)
          {
            MapMakerInternalMap.InternalEntry localInternalEntry = (MapMakerInternalMap.InternalEntry)localAtomicReferenceArray.get(i);
            if (localInternalEntry != null)
            {
              Object localObject = getLiveValue(localInternalEntry);
              if (localObject == null) {}
              boolean bool;
              do
              {
                localInternalEntry = localInternalEntry.getNext();
                break;
                bool = this.map.valueEquivalence().equivalent(paramObject, localObject);
              } while (!bool);
              return true;
            }
            i += 1;
          }
        }
        return false;
      }
      finally
      {
        postReadCleanup();
      }
    }
    
    E copyEntry(E paramE1, E paramE2)
    {
      return this.map.entryHelper.copy(self(), paramE1, paramE2);
    }
    
    E copyForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> paramInternalEntry1, @Nullable MapMakerInternalMap.InternalEntry<K, V, ?> paramInternalEntry2)
    {
      return this.map.entryHelper.copy(self(), castForTesting(paramInternalEntry1), castForTesting(paramInternalEntry2));
    }
    
    @GuardedBy("this")
    void drainKeyReferenceQueue(ReferenceQueue<K> paramReferenceQueue)
    {
      int i = 0;
      for (;;)
      {
        Object localObject = paramReferenceQueue.poll();
        if (localObject != null)
        {
          localObject = (MapMakerInternalMap.InternalEntry)localObject;
          this.map.reclaimKey((MapMakerInternalMap.InternalEntry)localObject);
          i += 1;
          if (i != 16) {}
        }
        else
        {
          return;
        }
      }
    }
    
    @GuardedBy("this")
    void drainValueReferenceQueue(ReferenceQueue<V> paramReferenceQueue)
    {
      int i = 0;
      for (;;)
      {
        Object localObject = paramReferenceQueue.poll();
        if (localObject != null)
        {
          localObject = (MapMakerInternalMap.WeakValueReference)localObject;
          this.map.reclaimValue((MapMakerInternalMap.WeakValueReference)localObject);
          i += 1;
          if (i != 16) {}
        }
        else
        {
          return;
        }
      }
    }
    
    @GuardedBy("this")
    void expand()
    {
      AtomicReferenceArray localAtomicReferenceArray1 = this.table;
      int n = localAtomicReferenceArray1.length();
      if (n >= 1073741824) {
        return;
      }
      int i = this.count;
      AtomicReferenceArray localAtomicReferenceArray2 = newEntryArray(n << 1);
      this.threshold = (localAtomicReferenceArray2.length() * 3 / 4);
      int i1 = localAtomicReferenceArray2.length() - 1;
      int k = 0;
      MapMakerInternalMap.InternalEntry localInternalEntry3;
      MapMakerInternalMap.InternalEntry localInternalEntry2;
      int j;
      if (k < n)
      {
        localInternalEntry3 = (MapMakerInternalMap.InternalEntry)localAtomicReferenceArray1.get(k);
        if (localInternalEntry3 == null) {
          break label270;
        }
        localInternalEntry2 = localInternalEntry3.getNext();
        j = localInternalEntry3.getHash() & i1;
        if (localInternalEntry2 == null) {
          localAtomicReferenceArray2.set(j, localInternalEntry3);
        }
      }
      label267:
      label270:
      for (;;)
      {
        k += 1;
        break;
        MapMakerInternalMap.InternalEntry localInternalEntry1 = localInternalEntry3;
        label126:
        if (localInternalEntry2 != null)
        {
          int m = localInternalEntry2.getHash() & i1;
          if (m == j) {
            break label267;
          }
          localInternalEntry1 = localInternalEntry2;
          j = m;
        }
        for (;;)
        {
          localInternalEntry2 = localInternalEntry2.getNext();
          break label126;
          localAtomicReferenceArray2.set(j, localInternalEntry1);
          localInternalEntry2 = localInternalEntry3;
          j = i;
          i = j;
          if (localInternalEntry2 == localInternalEntry1) {
            break;
          }
          i = localInternalEntry2.getHash() & i1;
          localInternalEntry3 = copyEntry(localInternalEntry2, (MapMakerInternalMap.InternalEntry)localAtomicReferenceArray2.get(i));
          if (localInternalEntry3 != null) {
            localAtomicReferenceArray2.set(i, localInternalEntry3);
          }
          for (i = j;; i = j - 1)
          {
            localInternalEntry2 = localInternalEntry2.getNext();
            j = i;
            break;
          }
          this.table = localAtomicReferenceArray2;
          this.count = i;
          return;
        }
      }
    }
    
    V get(Object paramObject, int paramInt)
    {
      try
      {
        paramObject = getLiveEntry(paramObject, paramInt);
        if (paramObject == null) {
          return null;
        }
        paramObject = paramObject.getValue();
        if (paramObject == null) {
          tryDrainReferenceQueues();
        }
        return paramObject;
      }
      finally
      {
        postReadCleanup();
      }
    }
    
    E getEntry(Object paramObject, int paramInt)
    {
      if (this.count != 0)
      {
        MapMakerInternalMap.InternalEntry localInternalEntry = getFirst(paramInt);
        if (localInternalEntry != null)
        {
          if (localInternalEntry.getHash() != paramInt) {}
          Object localObject;
          label57:
          do
          {
            for (;;)
            {
              localInternalEntry = localInternalEntry.getNext();
              break;
              localObject = localInternalEntry.getKey();
              if (localObject != null) {
                break label57;
              }
              tryDrainReferenceQueues();
            }
          } while (!this.map.keyEquivalence.equivalent(paramObject, localObject));
          return localInternalEntry;
        }
      }
      return null;
    }
    
    E getFirst(int paramInt)
    {
      AtomicReferenceArray localAtomicReferenceArray = this.table;
      return (MapMakerInternalMap.InternalEntry)localAtomicReferenceArray.get(localAtomicReferenceArray.length() - 1 & paramInt);
    }
    
    ReferenceQueue<K> getKeyReferenceQueueForTesting()
    {
      throw new AssertionError();
    }
    
    E getLiveEntry(Object paramObject, int paramInt)
    {
      return getEntry(paramObject, paramInt);
    }
    
    @Nullable
    V getLiveValue(E paramE)
    {
      if (paramE.getKey() == null)
      {
        tryDrainReferenceQueues();
        return null;
      }
      paramE = paramE.getValue();
      if (paramE == null)
      {
        tryDrainReferenceQueues();
        return null;
      }
      return paramE;
    }
    
    @Nullable
    V getLiveValueForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> paramInternalEntry)
    {
      return getLiveValue(castForTesting(paramInternalEntry));
    }
    
    ReferenceQueue<V> getValueReferenceQueueForTesting()
    {
      throw new AssertionError();
    }
    
    MapMakerInternalMap.WeakValueReference<K, V, E> getWeakValueReferenceForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> paramInternalEntry)
    {
      throw new AssertionError();
    }
    
    void initTable(AtomicReferenceArray<E> paramAtomicReferenceArray)
    {
      this.threshold = (paramAtomicReferenceArray.length() * 3 / 4);
      if (this.threshold == this.maxSegmentSize) {
        this.threshold += 1;
      }
      this.table = paramAtomicReferenceArray;
    }
    
    void maybeClearReferenceQueues() {}
    
    @GuardedBy("this")
    void maybeDrainReferenceQueues() {}
    
    AtomicReferenceArray<E> newEntryArray(int paramInt)
    {
      return new AtomicReferenceArray(paramInt);
    }
    
    E newEntryForTesting(K paramK, int paramInt, @Nullable MapMakerInternalMap.InternalEntry<K, V, ?> paramInternalEntry)
    {
      return this.map.entryHelper.newEntry(self(), paramK, paramInt, castForTesting(paramInternalEntry));
    }
    
    MapMakerInternalMap.WeakValueReference<K, V, E> newWeakValueReferenceForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> paramInternalEntry, V paramV)
    {
      throw new AssertionError();
    }
    
    void postReadCleanup()
    {
      if ((this.readCount.incrementAndGet() & 0x3F) == 0) {
        runCleanup();
      }
    }
    
    @GuardedBy("this")
    void preWriteCleanup()
    {
      runLockedCleanup();
    }
    
    V put(K paramK, int paramInt, V paramV, boolean paramBoolean)
    {
      lock();
      for (;;)
      {
        try
        {
          preWriteCleanup();
          int i = this.count + 1;
          if (i > this.threshold)
          {
            expand();
            i = this.count + 1;
            AtomicReferenceArray localAtomicReferenceArray = this.table;
            int j = paramInt & localAtomicReferenceArray.length() - 1;
            MapMakerInternalMap.InternalEntry localInternalEntry2 = (MapMakerInternalMap.InternalEntry)localAtomicReferenceArray.get(j);
            MapMakerInternalMap.InternalEntry localInternalEntry1 = localInternalEntry2;
            if (localInternalEntry1 != null)
            {
              Object localObject = localInternalEntry1.getKey();
              if ((localInternalEntry1.getHash() == paramInt) && (localObject != null) && (this.map.keyEquivalence.equivalent(paramK, localObject)))
              {
                paramK = localInternalEntry1.getValue();
                if (paramK == null)
                {
                  this.modCount += 1;
                  setValue(localInternalEntry1, paramV);
                  this.count = this.count;
                  return null;
                }
                if (paramBoolean) {
                  return paramK;
                }
                this.modCount += 1;
                setValue(localInternalEntry1, paramV);
                return paramK;
              }
              localInternalEntry1 = localInternalEntry1.getNext();
            }
            else
            {
              this.modCount += 1;
              paramK = this.map.entryHelper.newEntry(self(), paramK, paramInt, localInternalEntry2);
              setValue(paramK, paramV);
              localAtomicReferenceArray.set(j, paramK);
              this.count = i;
              return null;
            }
          }
        }
        finally
        {
          unlock();
        }
      }
    }
    
    @CanIgnoreReturnValue
    boolean reclaimKey(E paramE, int paramInt)
    {
      lock();
      try
      {
        int i = this.count;
        AtomicReferenceArray localAtomicReferenceArray = this.table;
        paramInt &= localAtomicReferenceArray.length() - 1;
        MapMakerInternalMap.InternalEntry localInternalEntry2 = (MapMakerInternalMap.InternalEntry)localAtomicReferenceArray.get(paramInt);
        for (MapMakerInternalMap.InternalEntry localInternalEntry1 = localInternalEntry2; localInternalEntry1 != null; localInternalEntry1 = localInternalEntry1.getNext()) {
          if (localInternalEntry1 == paramE)
          {
            this.modCount += 1;
            paramE = removeFromChain(localInternalEntry2, localInternalEntry1);
            i = this.count;
            localAtomicReferenceArray.set(paramInt, paramE);
            this.count = (i - 1);
            return true;
          }
        }
        return false;
      }
      finally
      {
        unlock();
      }
    }
    
    @CanIgnoreReturnValue
    boolean reclaimValue(K paramK, int paramInt, MapMakerInternalMap.WeakValueReference<K, V, E> paramWeakValueReference)
    {
      lock();
      try
      {
        int i = this.count;
        AtomicReferenceArray localAtomicReferenceArray = this.table;
        i = paramInt & localAtomicReferenceArray.length() - 1;
        MapMakerInternalMap.InternalEntry localInternalEntry2 = (MapMakerInternalMap.InternalEntry)localAtomicReferenceArray.get(i);
        for (MapMakerInternalMap.InternalEntry localInternalEntry1 = localInternalEntry2; localInternalEntry1 != null; localInternalEntry1 = localInternalEntry1.getNext())
        {
          Object localObject = localInternalEntry1.getKey();
          if ((localInternalEntry1.getHash() == paramInt) && (localObject != null) && (this.map.keyEquivalence.equivalent(paramK, localObject)))
          {
            if (((MapMakerInternalMap.WeakValueEntry)localInternalEntry1).getValueReference() == paramWeakValueReference)
            {
              this.modCount += 1;
              paramK = removeFromChain(localInternalEntry2, localInternalEntry1);
              paramInt = this.count;
              localAtomicReferenceArray.set(i, paramK);
              this.count = (paramInt - 1);
              return true;
            }
            return false;
          }
        }
        return false;
      }
      finally
      {
        unlock();
      }
    }
    
    @CanIgnoreReturnValue
    V remove(Object paramObject, int paramInt)
    {
      lock();
      try
      {
        preWriteCleanup();
        int i = this.count;
        AtomicReferenceArray localAtomicReferenceArray = this.table;
        i = paramInt & localAtomicReferenceArray.length() - 1;
        MapMakerInternalMap.InternalEntry localInternalEntry2 = (MapMakerInternalMap.InternalEntry)localAtomicReferenceArray.get(i);
        for (MapMakerInternalMap.InternalEntry localInternalEntry1 = localInternalEntry2; localInternalEntry1 != null; localInternalEntry1 = localInternalEntry1.getNext())
        {
          Object localObject = localInternalEntry1.getKey();
          if ((localInternalEntry1.getHash() == paramInt) && (localObject != null) && (this.map.keyEquivalence.equivalent(paramObject, localObject)))
          {
            paramObject = localInternalEntry1.getValue();
            if (paramObject != null) {}
            boolean bool;
            do
            {
              this.modCount += 1;
              localInternalEntry1 = removeFromChain(localInternalEntry2, localInternalEntry1);
              paramInt = this.count;
              localAtomicReferenceArray.set(i, localInternalEntry1);
              this.count = (paramInt - 1);
              return paramObject;
              bool = isCollected(localInternalEntry1);
            } while (bool);
            return null;
          }
        }
        return null;
      }
      finally
      {
        unlock();
      }
    }
    
    boolean remove(Object paramObject1, int paramInt, Object paramObject2)
    {
      boolean bool1 = false;
      lock();
      try
      {
        preWriteCleanup();
        int i = this.count;
        AtomicReferenceArray localAtomicReferenceArray = this.table;
        i = paramInt & localAtomicReferenceArray.length() - 1;
        MapMakerInternalMap.InternalEntry localInternalEntry2 = (MapMakerInternalMap.InternalEntry)localAtomicReferenceArray.get(i);
        for (MapMakerInternalMap.InternalEntry localInternalEntry1 = localInternalEntry2; localInternalEntry1 != null; localInternalEntry1 = localInternalEntry1.getNext())
        {
          Object localObject = localInternalEntry1.getKey();
          if ((localInternalEntry1.getHash() == paramInt) && (localObject != null) && (this.map.keyEquivalence.equivalent(paramObject1, localObject)))
          {
            paramObject1 = localInternalEntry1.getValue();
            if (this.map.valueEquivalence().equivalent(paramObject2, paramObject1)) {
              bool1 = true;
            }
            boolean bool2;
            do
            {
              this.modCount += 1;
              paramObject1 = removeFromChain(localInternalEntry2, localInternalEntry1);
              paramInt = this.count;
              localAtomicReferenceArray.set(i, paramObject1);
              this.count = (paramInt - 1);
              return bool1;
              bool2 = isCollected(localInternalEntry1);
            } while (bool2);
            return false;
          }
        }
        return false;
      }
      finally
      {
        unlock();
      }
    }
    
    @GuardedBy("this")
    boolean removeEntryForTesting(E paramE)
    {
      int i = paramE.getHash();
      int j = this.count;
      AtomicReferenceArray localAtomicReferenceArray = this.table;
      i &= localAtomicReferenceArray.length() - 1;
      MapMakerInternalMap.InternalEntry localInternalEntry2 = (MapMakerInternalMap.InternalEntry)localAtomicReferenceArray.get(i);
      for (MapMakerInternalMap.InternalEntry localInternalEntry1 = localInternalEntry2; localInternalEntry1 != null; localInternalEntry1 = localInternalEntry1.getNext()) {
        if (localInternalEntry1 == paramE)
        {
          this.modCount += 1;
          paramE = removeFromChain(localInternalEntry2, localInternalEntry1);
          j = this.count;
          localAtomicReferenceArray.set(i, paramE);
          this.count = (j - 1);
          return true;
        }
      }
      return false;
    }
    
    @GuardedBy("this")
    E removeFromChain(E paramE1, E paramE2)
    {
      int i = this.count;
      MapMakerInternalMap.InternalEntry localInternalEntry = paramE2.getNext();
      Object localObject = paramE1;
      paramE1 = localInternalEntry;
      if (localObject != paramE2)
      {
        localInternalEntry = copyEntry((MapMakerInternalMap.InternalEntry)localObject, paramE1);
        if (localInternalEntry != null) {
          paramE1 = localInternalEntry;
        }
        for (;;)
        {
          localObject = ((MapMakerInternalMap.InternalEntry)localObject).getNext();
          break;
          i -= 1;
        }
      }
      this.count = i;
      return paramE1;
    }
    
    E removeFromChainForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> paramInternalEntry1, MapMakerInternalMap.InternalEntry<K, V, ?> paramInternalEntry2)
    {
      return removeFromChain(castForTesting(paramInternalEntry1), castForTesting(paramInternalEntry2));
    }
    
    @CanIgnoreReturnValue
    boolean removeTableEntryForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> paramInternalEntry)
    {
      return removeEntryForTesting(castForTesting(paramInternalEntry));
    }
    
    V replace(K paramK, int paramInt, V paramV)
    {
      lock();
      try
      {
        preWriteCleanup();
        AtomicReferenceArray localAtomicReferenceArray = this.table;
        int i = paramInt & localAtomicReferenceArray.length() - 1;
        MapMakerInternalMap.InternalEntry localInternalEntry2 = (MapMakerInternalMap.InternalEntry)localAtomicReferenceArray.get(i);
        for (MapMakerInternalMap.InternalEntry localInternalEntry1 = localInternalEntry2; localInternalEntry1 != null; localInternalEntry1 = localInternalEntry1.getNext())
        {
          Object localObject = localInternalEntry1.getKey();
          if ((localInternalEntry1.getHash() == paramInt) && (localObject != null) && (this.map.keyEquivalence.equivalent(paramK, localObject)))
          {
            paramK = localInternalEntry1.getValue();
            if (paramK == null)
            {
              if (isCollected(localInternalEntry1))
              {
                paramInt = this.count;
                this.modCount += 1;
                paramK = removeFromChain(localInternalEntry2, localInternalEntry1);
                paramInt = this.count;
                localAtomicReferenceArray.set(i, paramK);
                this.count = (paramInt - 1);
              }
              return null;
            }
            this.modCount += 1;
            setValue(localInternalEntry1, paramV);
            return paramK;
          }
        }
        return null;
      }
      finally
      {
        unlock();
      }
    }
    
    boolean replace(K paramK, int paramInt, V paramV1, V paramV2)
    {
      lock();
      try
      {
        preWriteCleanup();
        AtomicReferenceArray localAtomicReferenceArray = this.table;
        int i = paramInt & localAtomicReferenceArray.length() - 1;
        MapMakerInternalMap.InternalEntry localInternalEntry2 = (MapMakerInternalMap.InternalEntry)localAtomicReferenceArray.get(i);
        for (MapMakerInternalMap.InternalEntry localInternalEntry1 = localInternalEntry2; localInternalEntry1 != null; localInternalEntry1 = localInternalEntry1.getNext())
        {
          Object localObject = localInternalEntry1.getKey();
          if ((localInternalEntry1.getHash() == paramInt) && (localObject != null) && (this.map.keyEquivalence.equivalent(paramK, localObject)))
          {
            paramK = localInternalEntry1.getValue();
            if (paramK == null)
            {
              if (isCollected(localInternalEntry1))
              {
                paramInt = this.count;
                this.modCount += 1;
                paramK = removeFromChain(localInternalEntry2, localInternalEntry1);
                paramInt = this.count;
                localAtomicReferenceArray.set(i, paramK);
                this.count = (paramInt - 1);
              }
              return false;
            }
            if (this.map.valueEquivalence().equivalent(paramV1, paramK))
            {
              this.modCount += 1;
              setValue(localInternalEntry1, paramV2);
              return true;
            }
            return false;
          }
        }
        return false;
      }
      finally
      {
        unlock();
      }
    }
    
    void runCleanup()
    {
      runLockedCleanup();
    }
    
    void runLockedCleanup()
    {
      if (tryLock()) {}
      try
      {
        maybeDrainReferenceQueues();
        this.readCount.set(0);
        return;
      }
      finally
      {
        unlock();
      }
    }
    
    abstract S self();
    
    void setTableEntryForTesting(int paramInt, MapMakerInternalMap.InternalEntry<K, V, ?> paramInternalEntry)
    {
      this.table.set(paramInt, castForTesting(paramInternalEntry));
    }
    
    void setValue(E paramE, V paramV)
    {
      this.map.entryHelper.setValue(self(), paramE, paramV);
    }
    
    void setValueForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> paramInternalEntry, V paramV)
    {
      this.map.entryHelper.setValue(self(), castForTesting(paramInternalEntry), paramV);
    }
    
    void setWeakValueReferenceForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> paramInternalEntry, MapMakerInternalMap.WeakValueReference<K, V, ? extends MapMakerInternalMap.InternalEntry<K, V, ?>> paramWeakValueReference)
    {
      throw new AssertionError();
    }
    
    void tryDrainReferenceQueues()
    {
      if (tryLock()) {}
      try
      {
        maybeDrainReferenceQueues();
        return;
      }
      finally
      {
        unlock();
      }
    }
  }
  
  static final class SerializationProxy<K, V>
    extends MapMakerInternalMap.AbstractSerializationProxy<K, V>
  {
    private static final long serialVersionUID = 3L;
    
    SerializationProxy(MapMakerInternalMap.Strength paramStrength1, MapMakerInternalMap.Strength paramStrength2, Equivalence<Object> paramEquivalence1, Equivalence<Object> paramEquivalence2, int paramInt, ConcurrentMap<K, V> paramConcurrentMap)
    {
      super(paramStrength2, paramEquivalence1, paramEquivalence2, paramInt, paramConcurrentMap);
    }
    
    private void readObject(ObjectInputStream paramObjectInputStream)
      throws IOException, ClassNotFoundException
    {
      paramObjectInputStream.defaultReadObject();
      this.delegate = readMapMaker(paramObjectInputStream).makeMap();
      readEntries(paramObjectInputStream);
    }
    
    private Object readResolve()
    {
      return this.delegate;
    }
    
    private void writeObject(ObjectOutputStream paramObjectOutputStream)
      throws IOException
    {
      paramObjectOutputStream.defaultWriteObject();
      writeMapTo(paramObjectOutputStream);
    }
  }
  
  static abstract enum Strength
  {
    STRONG,  WEAK;
    
    private Strength() {}
    
    abstract Equivalence<Object> defaultEquivalence();
  }
  
  static final class StrongKeyStrongValueEntry<K, V>
    extends MapMakerInternalMap.AbstractStrongKeyEntry<K, V, StrongKeyStrongValueEntry<K, V>>
    implements MapMakerInternalMap.StrongValueEntry<K, V, StrongKeyStrongValueEntry<K, V>>
  {
    @Nullable
    private volatile V value = null;
    
    StrongKeyStrongValueEntry(K paramK, int paramInt, @Nullable StrongKeyStrongValueEntry<K, V> paramStrongKeyStrongValueEntry)
    {
      super(paramInt, paramStrongKeyStrongValueEntry);
    }
    
    StrongKeyStrongValueEntry<K, V> copy(StrongKeyStrongValueEntry<K, V> paramStrongKeyStrongValueEntry)
    {
      paramStrongKeyStrongValueEntry = new StrongKeyStrongValueEntry(this.key, this.hash, paramStrongKeyStrongValueEntry);
      paramStrongKeyStrongValueEntry.value = this.value;
      return paramStrongKeyStrongValueEntry;
    }
    
    @Nullable
    public V getValue()
    {
      return this.value;
    }
    
    void setValue(V paramV)
    {
      this.value = paramV;
    }
    
    static final class Helper<K, V>
      implements MapMakerInternalMap.InternalEntryHelper<K, V, MapMakerInternalMap.StrongKeyStrongValueEntry<K, V>, MapMakerInternalMap.StrongKeyStrongValueSegment<K, V>>
    {
      private static final Helper<?, ?> INSTANCE = new Helper();
      
      static <K, V> Helper<K, V> instance()
      {
        return INSTANCE;
      }
      
      public MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> copy(MapMakerInternalMap.StrongKeyStrongValueSegment<K, V> paramStrongKeyStrongValueSegment, MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> paramStrongKeyStrongValueEntry1, @Nullable MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> paramStrongKeyStrongValueEntry2)
      {
        return paramStrongKeyStrongValueEntry1.copy(paramStrongKeyStrongValueEntry2);
      }
      
      public MapMakerInternalMap.Strength keyStrength()
      {
        return MapMakerInternalMap.Strength.STRONG;
      }
      
      public MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> newEntry(MapMakerInternalMap.StrongKeyStrongValueSegment<K, V> paramStrongKeyStrongValueSegment, K paramK, int paramInt, @Nullable MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> paramStrongKeyStrongValueEntry)
      {
        return new MapMakerInternalMap.StrongKeyStrongValueEntry(paramK, paramInt, paramStrongKeyStrongValueEntry);
      }
      
      public MapMakerInternalMap.StrongKeyStrongValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, MapMakerInternalMap.StrongKeyStrongValueEntry<K, V>, MapMakerInternalMap.StrongKeyStrongValueSegment<K, V>> paramMapMakerInternalMap, int paramInt1, int paramInt2)
      {
        return new MapMakerInternalMap.StrongKeyStrongValueSegment(paramMapMakerInternalMap, paramInt1, paramInt2);
      }
      
      public void setValue(MapMakerInternalMap.StrongKeyStrongValueSegment<K, V> paramStrongKeyStrongValueSegment, MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> paramStrongKeyStrongValueEntry, V paramV)
      {
        paramStrongKeyStrongValueEntry.setValue(paramV);
      }
      
      public MapMakerInternalMap.Strength valueStrength()
      {
        return MapMakerInternalMap.Strength.STRONG;
      }
    }
  }
  
  static final class StrongKeyStrongValueSegment<K, V>
    extends MapMakerInternalMap.Segment<K, V, MapMakerInternalMap.StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>>
  {
    StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, MapMakerInternalMap.StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> paramMapMakerInternalMap, int paramInt1, int paramInt2)
    {
      super(paramInt1, paramInt2);
    }
    
    public MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> castForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> paramInternalEntry)
    {
      return (MapMakerInternalMap.StrongKeyStrongValueEntry)paramInternalEntry;
    }
    
    StrongKeyStrongValueSegment<K, V> self()
    {
      return this;
    }
  }
  
  static final class StrongKeyWeakValueEntry<K, V>
    extends MapMakerInternalMap.AbstractStrongKeyEntry<K, V, StrongKeyWeakValueEntry<K, V>>
    implements MapMakerInternalMap.WeakValueEntry<K, V, StrongKeyWeakValueEntry<K, V>>
  {
    private volatile MapMakerInternalMap.WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> valueReference = MapMakerInternalMap.unsetWeakValueReference();
    
    StrongKeyWeakValueEntry(K paramK, int paramInt, @Nullable StrongKeyWeakValueEntry<K, V> paramStrongKeyWeakValueEntry)
    {
      super(paramInt, paramStrongKeyWeakValueEntry);
    }
    
    public void clearValue()
    {
      this.valueReference.clear();
    }
    
    StrongKeyWeakValueEntry<K, V> copy(ReferenceQueue<V> paramReferenceQueue, StrongKeyWeakValueEntry<K, V> paramStrongKeyWeakValueEntry)
    {
      paramStrongKeyWeakValueEntry = new StrongKeyWeakValueEntry(this.key, this.hash, paramStrongKeyWeakValueEntry);
      paramStrongKeyWeakValueEntry.valueReference = this.valueReference.copyFor(paramReferenceQueue, paramStrongKeyWeakValueEntry);
      return paramStrongKeyWeakValueEntry;
    }
    
    public V getValue()
    {
      return this.valueReference.get();
    }
    
    public MapMakerInternalMap.WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> getValueReference()
    {
      return this.valueReference;
    }
    
    void setValue(V paramV, ReferenceQueue<V> paramReferenceQueue)
    {
      MapMakerInternalMap.WeakValueReference localWeakValueReference = this.valueReference;
      this.valueReference = new MapMakerInternalMap.WeakValueReferenceImpl(paramReferenceQueue, paramV, this);
      localWeakValueReference.clear();
    }
    
    static final class Helper<K, V>
      implements MapMakerInternalMap.InternalEntryHelper<K, V, MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>, MapMakerInternalMap.StrongKeyWeakValueSegment<K, V>>
    {
      private static final Helper<?, ?> INSTANCE = new Helper();
      
      static <K, V> Helper<K, V> instance()
      {
        return INSTANCE;
      }
      
      public MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> copy(MapMakerInternalMap.StrongKeyWeakValueSegment<K, V> paramStrongKeyWeakValueSegment, MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> paramStrongKeyWeakValueEntry1, @Nullable MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> paramStrongKeyWeakValueEntry2)
      {
        if (MapMakerInternalMap.Segment.isCollected(paramStrongKeyWeakValueEntry1)) {
          return null;
        }
        return paramStrongKeyWeakValueEntry1.copy(MapMakerInternalMap.StrongKeyWeakValueSegment.access$100(paramStrongKeyWeakValueSegment), paramStrongKeyWeakValueEntry2);
      }
      
      public MapMakerInternalMap.Strength keyStrength()
      {
        return MapMakerInternalMap.Strength.STRONG;
      }
      
      public MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> newEntry(MapMakerInternalMap.StrongKeyWeakValueSegment<K, V> paramStrongKeyWeakValueSegment, K paramK, int paramInt, @Nullable MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> paramStrongKeyWeakValueEntry)
      {
        return new MapMakerInternalMap.StrongKeyWeakValueEntry(paramK, paramInt, paramStrongKeyWeakValueEntry);
      }
      
      public MapMakerInternalMap.StrongKeyWeakValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>, MapMakerInternalMap.StrongKeyWeakValueSegment<K, V>> paramMapMakerInternalMap, int paramInt1, int paramInt2)
      {
        return new MapMakerInternalMap.StrongKeyWeakValueSegment(paramMapMakerInternalMap, paramInt1, paramInt2);
      }
      
      public void setValue(MapMakerInternalMap.StrongKeyWeakValueSegment<K, V> paramStrongKeyWeakValueSegment, MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> paramStrongKeyWeakValueEntry, V paramV)
      {
        paramStrongKeyWeakValueEntry.setValue(paramV, MapMakerInternalMap.StrongKeyWeakValueSegment.access$100(paramStrongKeyWeakValueSegment));
      }
      
      public MapMakerInternalMap.Strength valueStrength()
      {
        return MapMakerInternalMap.Strength.WEAK;
      }
    }
  }
  
  static final class StrongKeyWeakValueSegment<K, V>
    extends MapMakerInternalMap.Segment<K, V, MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>>
  {
    private final ReferenceQueue<V> queueForValues = new ReferenceQueue();
    
    StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> paramMapMakerInternalMap, int paramInt1, int paramInt2)
    {
      super(paramInt1, paramInt2);
    }
    
    public MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> castForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> paramInternalEntry)
    {
      return (MapMakerInternalMap.StrongKeyWeakValueEntry)paramInternalEntry;
    }
    
    ReferenceQueue<V> getValueReferenceQueueForTesting()
    {
      return this.queueForValues;
    }
    
    public MapMakerInternalMap.WeakValueReference<K, V, MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>> getWeakValueReferenceForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> paramInternalEntry)
    {
      return castForTesting(paramInternalEntry).getValueReference();
    }
    
    void maybeClearReferenceQueues()
    {
      clearReferenceQueue(this.queueForValues);
    }
    
    void maybeDrainReferenceQueues()
    {
      drainValueReferenceQueue(this.queueForValues);
    }
    
    public MapMakerInternalMap.WeakValueReference<K, V, MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>> newWeakValueReferenceForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> paramInternalEntry, V paramV)
    {
      return new MapMakerInternalMap.WeakValueReferenceImpl(this.queueForValues, paramV, castForTesting(paramInternalEntry));
    }
    
    StrongKeyWeakValueSegment<K, V> self()
    {
      return this;
    }
    
    public void setWeakValueReferenceForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> paramInternalEntry, MapMakerInternalMap.WeakValueReference<K, V, ? extends MapMakerInternalMap.InternalEntry<K, V, ?>> paramWeakValueReference)
    {
      paramInternalEntry = castForTesting(paramInternalEntry);
      MapMakerInternalMap.WeakValueReference localWeakValueReference = paramInternalEntry.valueReference;
      MapMakerInternalMap.StrongKeyWeakValueEntry.access$502(paramInternalEntry, paramWeakValueReference);
      localWeakValueReference.clear();
    }
  }
  
  static abstract interface StrongValueEntry<K, V, E extends MapMakerInternalMap.InternalEntry<K, V, E>>
    extends MapMakerInternalMap.InternalEntry<K, V, E>
  {}
  
  final class ValueIterator
    extends MapMakerInternalMap<K, V, E, S>.HashIterator<V>
  {
    ValueIterator()
    {
      super();
    }
    
    public V next()
    {
      return nextEntry().getValue();
    }
  }
  
  final class Values
    extends AbstractCollection<V>
  {
    Values() {}
    
    public void clear()
    {
      MapMakerInternalMap.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return MapMakerInternalMap.this.containsValue(paramObject);
    }
    
    public boolean isEmpty()
    {
      return MapMakerInternalMap.this.isEmpty();
    }
    
    public Iterator<V> iterator()
    {
      return new MapMakerInternalMap.ValueIterator(MapMakerInternalMap.this);
    }
    
    public int size()
    {
      return MapMakerInternalMap.this.size();
    }
    
    public Object[] toArray()
    {
      return MapMakerInternalMap.toArrayList(this).toArray();
    }
    
    public <E> E[] toArray(E[] paramArrayOfE)
    {
      return MapMakerInternalMap.toArrayList(this).toArray(paramArrayOfE);
    }
  }
  
  static final class WeakKeyStrongValueEntry<K, V>
    extends MapMakerInternalMap.AbstractWeakKeyEntry<K, V, WeakKeyStrongValueEntry<K, V>>
    implements MapMakerInternalMap.StrongValueEntry<K, V, WeakKeyStrongValueEntry<K, V>>
  {
    @Nullable
    private volatile V value = null;
    
    WeakKeyStrongValueEntry(ReferenceQueue<K> paramReferenceQueue, K paramK, int paramInt, @Nullable WeakKeyStrongValueEntry<K, V> paramWeakKeyStrongValueEntry)
    {
      super(paramK, paramInt, paramWeakKeyStrongValueEntry);
    }
    
    WeakKeyStrongValueEntry<K, V> copy(ReferenceQueue<K> paramReferenceQueue, WeakKeyStrongValueEntry<K, V> paramWeakKeyStrongValueEntry)
    {
      paramReferenceQueue = new WeakKeyStrongValueEntry(paramReferenceQueue, getKey(), this.hash, paramWeakKeyStrongValueEntry);
      paramReferenceQueue.setValue(this.value);
      return paramReferenceQueue;
    }
    
    @Nullable
    public V getValue()
    {
      return this.value;
    }
    
    void setValue(V paramV)
    {
      this.value = paramV;
    }
    
    static final class Helper<K, V>
      implements MapMakerInternalMap.InternalEntryHelper<K, V, MapMakerInternalMap.WeakKeyStrongValueEntry<K, V>, MapMakerInternalMap.WeakKeyStrongValueSegment<K, V>>
    {
      private static final Helper<?, ?> INSTANCE = new Helper();
      
      static <K, V> Helper<K, V> instance()
      {
        return INSTANCE;
      }
      
      public MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> copy(MapMakerInternalMap.WeakKeyStrongValueSegment<K, V> paramWeakKeyStrongValueSegment, MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> paramWeakKeyStrongValueEntry1, @Nullable MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> paramWeakKeyStrongValueEntry2)
      {
        if (paramWeakKeyStrongValueEntry1.getKey() == null) {
          return null;
        }
        return paramWeakKeyStrongValueEntry1.copy(MapMakerInternalMap.WeakKeyStrongValueSegment.access$200(paramWeakKeyStrongValueSegment), paramWeakKeyStrongValueEntry2);
      }
      
      public MapMakerInternalMap.Strength keyStrength()
      {
        return MapMakerInternalMap.Strength.WEAK;
      }
      
      public MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> newEntry(MapMakerInternalMap.WeakKeyStrongValueSegment<K, V> paramWeakKeyStrongValueSegment, K paramK, int paramInt, @Nullable MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> paramWeakKeyStrongValueEntry)
      {
        return new MapMakerInternalMap.WeakKeyStrongValueEntry(MapMakerInternalMap.WeakKeyStrongValueSegment.access$200(paramWeakKeyStrongValueSegment), paramK, paramInt, paramWeakKeyStrongValueEntry);
      }
      
      public MapMakerInternalMap.WeakKeyStrongValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, MapMakerInternalMap.WeakKeyStrongValueEntry<K, V>, MapMakerInternalMap.WeakKeyStrongValueSegment<K, V>> paramMapMakerInternalMap, int paramInt1, int paramInt2)
      {
        return new MapMakerInternalMap.WeakKeyStrongValueSegment(paramMapMakerInternalMap, paramInt1, paramInt2);
      }
      
      public void setValue(MapMakerInternalMap.WeakKeyStrongValueSegment<K, V> paramWeakKeyStrongValueSegment, MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> paramWeakKeyStrongValueEntry, V paramV)
      {
        paramWeakKeyStrongValueEntry.setValue(paramV);
      }
      
      public MapMakerInternalMap.Strength valueStrength()
      {
        return MapMakerInternalMap.Strength.STRONG;
      }
    }
  }
  
  static final class WeakKeyStrongValueSegment<K, V>
    extends MapMakerInternalMap.Segment<K, V, MapMakerInternalMap.WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>>
  {
    private final ReferenceQueue<K> queueForKeys = new ReferenceQueue();
    
    WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, MapMakerInternalMap.WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> paramMapMakerInternalMap, int paramInt1, int paramInt2)
    {
      super(paramInt1, paramInt2);
    }
    
    public MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> castForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> paramInternalEntry)
    {
      return (MapMakerInternalMap.WeakKeyStrongValueEntry)paramInternalEntry;
    }
    
    ReferenceQueue<K> getKeyReferenceQueueForTesting()
    {
      return this.queueForKeys;
    }
    
    void maybeClearReferenceQueues()
    {
      clearReferenceQueue(this.queueForKeys);
    }
    
    void maybeDrainReferenceQueues()
    {
      drainKeyReferenceQueue(this.queueForKeys);
    }
    
    WeakKeyStrongValueSegment<K, V> self()
    {
      return this;
    }
  }
  
  static final class WeakKeyWeakValueEntry<K, V>
    extends MapMakerInternalMap.AbstractWeakKeyEntry<K, V, WeakKeyWeakValueEntry<K, V>>
    implements MapMakerInternalMap.WeakValueEntry<K, V, WeakKeyWeakValueEntry<K, V>>
  {
    private volatile MapMakerInternalMap.WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> valueReference = MapMakerInternalMap.unsetWeakValueReference();
    
    WeakKeyWeakValueEntry(ReferenceQueue<K> paramReferenceQueue, K paramK, int paramInt, @Nullable WeakKeyWeakValueEntry<K, V> paramWeakKeyWeakValueEntry)
    {
      super(paramK, paramInt, paramWeakKeyWeakValueEntry);
    }
    
    public void clearValue()
    {
      this.valueReference.clear();
    }
    
    WeakKeyWeakValueEntry<K, V> copy(ReferenceQueue<K> paramReferenceQueue, ReferenceQueue<V> paramReferenceQueue1, WeakKeyWeakValueEntry<K, V> paramWeakKeyWeakValueEntry)
    {
      paramReferenceQueue = new WeakKeyWeakValueEntry(paramReferenceQueue, getKey(), this.hash, paramWeakKeyWeakValueEntry);
      paramReferenceQueue.valueReference = this.valueReference.copyFor(paramReferenceQueue1, paramReferenceQueue);
      return paramReferenceQueue;
    }
    
    public V getValue()
    {
      return this.valueReference.get();
    }
    
    public MapMakerInternalMap.WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> getValueReference()
    {
      return this.valueReference;
    }
    
    void setValue(V paramV, ReferenceQueue<V> paramReferenceQueue)
    {
      MapMakerInternalMap.WeakValueReference localWeakValueReference = this.valueReference;
      this.valueReference = new MapMakerInternalMap.WeakValueReferenceImpl(paramReferenceQueue, paramV, this);
      localWeakValueReference.clear();
    }
    
    static final class Helper<K, V>
      implements MapMakerInternalMap.InternalEntryHelper<K, V, MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>, MapMakerInternalMap.WeakKeyWeakValueSegment<K, V>>
    {
      private static final Helper<?, ?> INSTANCE = new Helper();
      
      static <K, V> Helper<K, V> instance()
      {
        return INSTANCE;
      }
      
      public MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> copy(MapMakerInternalMap.WeakKeyWeakValueSegment<K, V> paramWeakKeyWeakValueSegment, MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> paramWeakKeyWeakValueEntry1, @Nullable MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> paramWeakKeyWeakValueEntry2)
      {
        if (paramWeakKeyWeakValueEntry1.getKey() == null) {}
        while (MapMakerInternalMap.Segment.isCollected(paramWeakKeyWeakValueEntry1)) {
          return null;
        }
        return paramWeakKeyWeakValueEntry1.copy(MapMakerInternalMap.WeakKeyWeakValueSegment.access$300(paramWeakKeyWeakValueSegment), MapMakerInternalMap.WeakKeyWeakValueSegment.access$400(paramWeakKeyWeakValueSegment), paramWeakKeyWeakValueEntry2);
      }
      
      public MapMakerInternalMap.Strength keyStrength()
      {
        return MapMakerInternalMap.Strength.WEAK;
      }
      
      public MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> newEntry(MapMakerInternalMap.WeakKeyWeakValueSegment<K, V> paramWeakKeyWeakValueSegment, K paramK, int paramInt, @Nullable MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> paramWeakKeyWeakValueEntry)
      {
        return new MapMakerInternalMap.WeakKeyWeakValueEntry(MapMakerInternalMap.WeakKeyWeakValueSegment.access$300(paramWeakKeyWeakValueSegment), paramK, paramInt, paramWeakKeyWeakValueEntry);
      }
      
      public MapMakerInternalMap.WeakKeyWeakValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>, MapMakerInternalMap.WeakKeyWeakValueSegment<K, V>> paramMapMakerInternalMap, int paramInt1, int paramInt2)
      {
        return new MapMakerInternalMap.WeakKeyWeakValueSegment(paramMapMakerInternalMap, paramInt1, paramInt2);
      }
      
      public void setValue(MapMakerInternalMap.WeakKeyWeakValueSegment<K, V> paramWeakKeyWeakValueSegment, MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> paramWeakKeyWeakValueEntry, V paramV)
      {
        paramWeakKeyWeakValueEntry.setValue(paramV, MapMakerInternalMap.WeakKeyWeakValueSegment.access$400(paramWeakKeyWeakValueSegment));
      }
      
      public MapMakerInternalMap.Strength valueStrength()
      {
        return MapMakerInternalMap.Strength.WEAK;
      }
    }
  }
  
  static final class WeakKeyWeakValueSegment<K, V>
    extends MapMakerInternalMap.Segment<K, V, MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>>
  {
    private final ReferenceQueue<K> queueForKeys = new ReferenceQueue();
    private final ReferenceQueue<V> queueForValues = new ReferenceQueue();
    
    WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> paramMapMakerInternalMap, int paramInt1, int paramInt2)
    {
      super(paramInt1, paramInt2);
    }
    
    public MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> castForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> paramInternalEntry)
    {
      return (MapMakerInternalMap.WeakKeyWeakValueEntry)paramInternalEntry;
    }
    
    ReferenceQueue<K> getKeyReferenceQueueForTesting()
    {
      return this.queueForKeys;
    }
    
    ReferenceQueue<V> getValueReferenceQueueForTesting()
    {
      return this.queueForValues;
    }
    
    public MapMakerInternalMap.WeakValueReference<K, V, MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>> getWeakValueReferenceForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> paramInternalEntry)
    {
      return castForTesting(paramInternalEntry).getValueReference();
    }
    
    void maybeClearReferenceQueues()
    {
      clearReferenceQueue(this.queueForKeys);
    }
    
    void maybeDrainReferenceQueues()
    {
      drainKeyReferenceQueue(this.queueForKeys);
      drainValueReferenceQueue(this.queueForValues);
    }
    
    public MapMakerInternalMap.WeakValueReference<K, V, MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>> newWeakValueReferenceForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> paramInternalEntry, V paramV)
    {
      return new MapMakerInternalMap.WeakValueReferenceImpl(this.queueForValues, paramV, castForTesting(paramInternalEntry));
    }
    
    WeakKeyWeakValueSegment<K, V> self()
    {
      return this;
    }
    
    public void setWeakValueReferenceForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> paramInternalEntry, MapMakerInternalMap.WeakValueReference<K, V, ? extends MapMakerInternalMap.InternalEntry<K, V, ?>> paramWeakValueReference)
    {
      paramInternalEntry = castForTesting(paramInternalEntry);
      MapMakerInternalMap.WeakValueReference localWeakValueReference = paramInternalEntry.valueReference;
      MapMakerInternalMap.WeakKeyWeakValueEntry.access$602(paramInternalEntry, paramWeakValueReference);
      localWeakValueReference.clear();
    }
  }
  
  static abstract interface WeakValueEntry<K, V, E extends MapMakerInternalMap.InternalEntry<K, V, E>>
    extends MapMakerInternalMap.InternalEntry<K, V, E>
  {
    public abstract void clearValue();
    
    public abstract MapMakerInternalMap.WeakValueReference<K, V, E> getValueReference();
  }
  
  static abstract interface WeakValueReference<K, V, E extends MapMakerInternalMap.InternalEntry<K, V, E>>
  {
    public abstract void clear();
    
    public abstract WeakValueReference<K, V, E> copyFor(ReferenceQueue<V> paramReferenceQueue, E paramE);
    
    @Nullable
    public abstract V get();
    
    public abstract E getEntry();
  }
  
  static final class WeakValueReferenceImpl<K, V, E extends MapMakerInternalMap.InternalEntry<K, V, E>>
    extends WeakReference<V>
    implements MapMakerInternalMap.WeakValueReference<K, V, E>
  {
    final E entry;
    
    WeakValueReferenceImpl(ReferenceQueue<V> paramReferenceQueue, V paramV, E paramE)
    {
      super(paramReferenceQueue);
      this.entry = paramE;
    }
    
    public MapMakerInternalMap.WeakValueReference<K, V, E> copyFor(ReferenceQueue<V> paramReferenceQueue, E paramE)
    {
      return new WeakValueReferenceImpl(paramReferenceQueue, get(), paramE);
    }
    
    public E getEntry()
    {
      return this.entry;
    }
  }
  
  final class WriteThroughEntry
    extends AbstractMapEntry<K, V>
  {
    final K key;
    V value;
    
    WriteThroughEntry(V paramV)
    {
      this.key = paramV;
      Object localObject;
      this.value = localObject;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof Map.Entry))
      {
        paramObject = (Map.Entry)paramObject;
        bool1 = bool2;
        if (this.key.equals(paramObject.getKey()))
        {
          bool1 = bool2;
          if (this.value.equals(paramObject.getValue())) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    
    public K getKey()
    {
      return this.key;
    }
    
    public V getValue()
    {
      return this.value;
    }
    
    public int hashCode()
    {
      return this.key.hashCode() ^ this.value.hashCode();
    }
    
    public V setValue(V paramV)
    {
      Object localObject = MapMakerInternalMap.this.put(this.key, paramV);
      this.value = paramV;
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.MapMakerInternalMap
 * JD-Core Version:    0.7.0.1
 */