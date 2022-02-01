package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
public class ImmutableSetMultimap<K, V>
  extends ImmutableMultimap<K, V>
  implements SetMultimap<K, V>
{
  @GwtIncompatible
  private static final long serialVersionUID = 0L;
  private final transient ImmutableSet<V> emptySet;
  private transient ImmutableSet<Map.Entry<K, V>> entries;
  @LazyInit
  @RetainedWith
  private transient ImmutableSetMultimap<V, K> inverse;
  
  ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> paramImmutableMap, int paramInt, @Nullable Comparator<? super V> paramComparator)
  {
    super(paramImmutableMap, paramInt);
    this.emptySet = emptySet(paramComparator);
  }
  
  public static <K, V> Builder<K, V> builder()
  {
    return new Builder();
  }
  
  public static <K, V> ImmutableSetMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> paramMultimap)
  {
    return copyOf(paramMultimap, null);
  }
  
  private static <K, V> ImmutableSetMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> paramMultimap, Comparator<? super V> paramComparator)
  {
    Preconditions.checkNotNull(paramMultimap);
    if ((paramMultimap.isEmpty()) && (paramComparator == null)) {
      localObject1 = of();
    }
    Object localObject2;
    do
    {
      return localObject1;
      if (!(paramMultimap instanceof ImmutableSetMultimap)) {
        break;
      }
      localObject2 = (ImmutableSetMultimap)paramMultimap;
      localObject1 = localObject2;
    } while (!((ImmutableSetMultimap)localObject2).isPartialView());
    Object localObject1 = new ImmutableMap.Builder(paramMultimap.asMap().size());
    paramMultimap = paramMultimap.asMap().entrySet().iterator();
    int i = 0;
    if (paramMultimap.hasNext())
    {
      Object localObject3 = (Map.Entry)paramMultimap.next();
      localObject2 = ((Map.Entry)localObject3).getKey();
      localObject3 = valueSet(paramComparator, (Collection)((Map.Entry)localObject3).getValue());
      if (((ImmutableSet)localObject3).isEmpty()) {
        break label173;
      }
      ((ImmutableMap.Builder)localObject1).put(localObject2, localObject3);
      i = ((ImmutableSet)localObject3).size() + i;
    }
    label173:
    for (;;)
    {
      break;
      return new ImmutableSetMultimap(((ImmutableMap.Builder)localObject1).build(), i, paramComparator);
    }
  }
  
  @Beta
  public static <K, V> ImmutableSetMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable)
  {
    return new Builder().putAll(paramIterable).build();
  }
  
  private static <V> ImmutableSet<V> emptySet(@Nullable Comparator<? super V> paramComparator)
  {
    if (paramComparator == null) {
      return ImmutableSet.of();
    }
    return ImmutableSortedSet.emptySet(paramComparator);
  }
  
  private ImmutableSetMultimap<V, K> invert()
  {
    Object localObject = builder();
    Iterator localIterator = entries().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((Builder)localObject).put(localEntry.getValue(), localEntry.getKey());
    }
    localObject = ((Builder)localObject).build();
    ((ImmutableSetMultimap)localObject).inverse = this;
    return localObject;
  }
  
  public static <K, V> ImmutableSetMultimap<K, V> of()
  {
    return EmptyImmutableSetMultimap.INSTANCE;
  }
  
  public static <K, V> ImmutableSetMultimap<K, V> of(K paramK, V paramV)
  {
    Builder localBuilder = builder();
    localBuilder.put(paramK, paramV);
    return localBuilder.build();
  }
  
  public static <K, V> ImmutableSetMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2)
  {
    Builder localBuilder = builder();
    localBuilder.put(paramK1, paramV1);
    localBuilder.put(paramK2, paramV2);
    return localBuilder.build();
  }
  
  public static <K, V> ImmutableSetMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    Builder localBuilder = builder();
    localBuilder.put(paramK1, paramV1);
    localBuilder.put(paramK2, paramV2);
    localBuilder.put(paramK3, paramV3);
    return localBuilder.build();
  }
  
  public static <K, V> ImmutableSetMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4)
  {
    Builder localBuilder = builder();
    localBuilder.put(paramK1, paramV1);
    localBuilder.put(paramK2, paramV2);
    localBuilder.put(paramK3, paramV3);
    localBuilder.put(paramK4, paramV4);
    return localBuilder.build();
  }
  
  public static <K, V> ImmutableSetMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5)
  {
    Builder localBuilder = builder();
    localBuilder.put(paramK1, paramV1);
    localBuilder.put(paramK2, paramV2);
    localBuilder.put(paramK3, paramV3);
    localBuilder.put(paramK4, paramV4);
    localBuilder.put(paramK5, paramV5);
    return localBuilder.build();
  }
  
  @GwtIncompatible
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    Comparator localComparator = (Comparator)paramObjectInputStream.readObject();
    int m = paramObjectInputStream.readInt();
    if (m < 0) {
      throw new InvalidObjectException("Invalid key count " + m);
    }
    ImmutableMap.Builder localBuilder = ImmutableMap.builder();
    int i = 0;
    int j = 0;
    while (i < m)
    {
      Object localObject1 = paramObjectInputStream.readObject();
      int n = paramObjectInputStream.readInt();
      if (n <= 0) {
        throw new InvalidObjectException("Invalid value count " + n);
      }
      Object localObject2 = valuesBuilder(localComparator);
      int k = 0;
      while (k < n)
      {
        ((ImmutableSet.Builder)localObject2).add(paramObjectInputStream.readObject());
        k += 1;
      }
      localObject2 = ((ImmutableSet.Builder)localObject2).build();
      if (((ImmutableSet)localObject2).size() != n) {
        throw new InvalidObjectException("Duplicate key-value pairs exist for key " + localObject1);
      }
      localBuilder.put(localObject1, localObject2);
      j += n;
      i += 1;
    }
    try
    {
      paramObjectInputStream = localBuilder.build();
      ImmutableMultimap.FieldSettersHolder.MAP_FIELD_SETTER.set(this, paramObjectInputStream);
      ImmutableMultimap.FieldSettersHolder.SIZE_FIELD_SETTER.set(this, j);
      ImmutableMultimap.FieldSettersHolder.EMPTY_SET_FIELD_SETTER.set(this, emptySet(localComparator));
      return;
    }
    catch (IllegalArgumentException paramObjectInputStream)
    {
      throw ((InvalidObjectException)new InvalidObjectException(paramObjectInputStream.getMessage()).initCause(paramObjectInputStream));
    }
  }
  
  private static <V> ImmutableSet<V> valueSet(@Nullable Comparator<? super V> paramComparator, Collection<? extends V> paramCollection)
  {
    if (paramComparator == null) {
      return ImmutableSet.copyOf(paramCollection);
    }
    return ImmutableSortedSet.copyOf(paramComparator, paramCollection);
  }
  
  private static <V> ImmutableSet.Builder<V> valuesBuilder(@Nullable Comparator<? super V> paramComparator)
  {
    if (paramComparator == null) {
      return new ImmutableSet.Builder();
    }
    return new ImmutableSortedSet.Builder(paramComparator);
  }
  
  @GwtIncompatible
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(valueComparator());
    Serialization.writeMultimap(this, paramObjectOutputStream);
  }
  
  public ImmutableSet<Map.Entry<K, V>> entries()
  {
    ImmutableSet localImmutableSet = this.entries;
    Object localObject = localImmutableSet;
    if (localImmutableSet == null)
    {
      localObject = new EntrySet(this);
      this.entries = ((ImmutableSet)localObject);
    }
    return localObject;
  }
  
  public ImmutableSet<V> get(@Nullable K paramK)
  {
    return (ImmutableSet)MoreObjects.firstNonNull((ImmutableSet)this.map.get(paramK), this.emptySet);
  }
  
  public ImmutableSetMultimap<V, K> inverse()
  {
    ImmutableSetMultimap localImmutableSetMultimap2 = this.inverse;
    ImmutableSetMultimap localImmutableSetMultimap1 = localImmutableSetMultimap2;
    if (localImmutableSetMultimap2 == null)
    {
      localImmutableSetMultimap1 = invert();
      this.inverse = localImmutableSetMultimap1;
    }
    return localImmutableSetMultimap1;
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public ImmutableSet<V> removeAll(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public ImmutableSet<V> replaceValues(K paramK, Iterable<? extends V> paramIterable)
  {
    throw new UnsupportedOperationException();
  }
  
  @Nullable
  Comparator<? super V> valueComparator()
  {
    if ((this.emptySet instanceof ImmutableSortedSet)) {
      return ((ImmutableSortedSet)this.emptySet).comparator();
    }
    return null;
  }
  
  public static final class Builder<K, V>
    extends ImmutableMultimap.Builder<K, V>
  {
    public Builder()
    {
      super();
    }
    
    public ImmutableSetMultimap<K, V> build()
    {
      if (this.keyComparator != null)
      {
        SetMultimap localSetMultimap = MultimapBuilder.linkedHashKeys().linkedHashSetValues().build();
        Iterator localIterator = Ordering.from(this.keyComparator).onKeys().immutableSortedCopy(this.builderMultimap.asMap().entrySet()).iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localSetMultimap.putAll(localEntry.getKey(), (Iterable)localEntry.getValue());
        }
        this.builderMultimap = localSetMultimap;
      }
      return ImmutableSetMultimap.copyOf(this.builderMultimap, this.valueComparator);
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> orderKeysBy(Comparator<? super K> paramComparator)
    {
      this.keyComparator = ((Comparator)Preconditions.checkNotNull(paramComparator));
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> orderValuesBy(Comparator<? super V> paramComparator)
    {
      super.orderValuesBy(paramComparator);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> put(K paramK, V paramV)
    {
      this.builderMultimap.put(Preconditions.checkNotNull(paramK), Preconditions.checkNotNull(paramV));
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> put(Map.Entry<? extends K, ? extends V> paramEntry)
    {
      this.builderMultimap.put(Preconditions.checkNotNull(paramEntry.getKey()), Preconditions.checkNotNull(paramEntry.getValue()));
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> putAll(Multimap<? extends K, ? extends V> paramMultimap)
    {
      paramMultimap = paramMultimap.asMap().entrySet().iterator();
      while (paramMultimap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMultimap.next();
        putAll(localEntry.getKey(), (Iterable)localEntry.getValue());
      }
      return this;
    }
    
    @Beta
    @CanIgnoreReturnValue
    public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable)
    {
      super.putAll(paramIterable);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> putAll(K paramK, Iterable<? extends V> paramIterable)
    {
      paramK = this.builderMultimap.get(Preconditions.checkNotNull(paramK));
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        paramK.add(Preconditions.checkNotNull(paramIterable.next()));
      }
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> putAll(K paramK, V... paramVarArgs)
    {
      return putAll(paramK, Arrays.asList(paramVarArgs));
    }
  }
  
  static final class EntrySet<K, V>
    extends ImmutableSet<Map.Entry<K, V>>
  {
    @Weak
    private final transient ImmutableSetMultimap<K, V> multimap;
    
    EntrySet(ImmutableSetMultimap<K, V> paramImmutableSetMultimap)
    {
      this.multimap = paramImmutableSetMultimap;
    }
    
    public boolean contains(@Nullable Object paramObject)
    {
      if ((paramObject instanceof Map.Entry))
      {
        paramObject = (Map.Entry)paramObject;
        return this.multimap.containsEntry(paramObject.getKey(), paramObject.getValue());
      }
      return false;
    }
    
    boolean isPartialView()
    {
      return false;
    }
    
    public UnmodifiableIterator<Map.Entry<K, V>> iterator()
    {
      return this.multimap.entryIterator();
    }
    
    public int size()
    {
      return this.multimap.size();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ImmutableSetMultimap
 * JD-Core Version:    0.7.0.1
 */