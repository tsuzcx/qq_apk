package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
abstract class AbstractBiMap<K, V>
  extends ForwardingMap<K, V>
  implements BiMap<K, V>, Serializable
{
  @GwtIncompatible
  private static final long serialVersionUID = 0L;
  private transient Map<K, V> delegate;
  private transient Set<Map.Entry<K, V>> entrySet;
  @RetainedWith
  transient AbstractBiMap<V, K> inverse;
  private transient Set<K> keySet;
  private transient Set<V> valueSet;
  
  private AbstractBiMap(Map<K, V> paramMap, AbstractBiMap<V, K> paramAbstractBiMap)
  {
    this.delegate = paramMap;
    this.inverse = paramAbstractBiMap;
  }
  
  AbstractBiMap(Map<K, V> paramMap, Map<V, K> paramMap1)
  {
    setDelegates(paramMap, paramMap1);
  }
  
  private V putInBothMaps(@Nullable K paramK, @Nullable V paramV, boolean paramBoolean)
  {
    checkKey(paramK);
    checkValue(paramV);
    boolean bool = containsKey(paramK);
    if ((bool) && (Objects.equal(paramV, get(paramK)))) {
      return paramV;
    }
    if (paramBoolean)
    {
      inverse().remove(paramV);
      Object localObject = this.delegate.put(paramK, paramV);
      updateInverseMap(paramK, bool, localObject, paramV);
      return localObject;
    }
    if (!containsValue(paramV)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Preconditions.checkArgument(paramBoolean, "value already present: %s", paramV);
      break;
    }
  }
  
  @CanIgnoreReturnValue
  private V removeFromBothMaps(Object paramObject)
  {
    paramObject = this.delegate.remove(paramObject);
    removeFromInverseMap(paramObject);
    return paramObject;
  }
  
  private void removeFromInverseMap(V paramV)
  {
    this.inverse.delegate.remove(paramV);
  }
  
  private void updateInverseMap(K paramK, boolean paramBoolean, V paramV1, V paramV2)
  {
    if (paramBoolean) {
      removeFromInverseMap(paramV1);
    }
    this.inverse.delegate.put(paramV2, paramK);
  }
  
  @CanIgnoreReturnValue
  K checkKey(@Nullable K paramK)
  {
    return paramK;
  }
  
  @CanIgnoreReturnValue
  V checkValue(@Nullable V paramV)
  {
    return paramV;
  }
  
  public void clear()
  {
    this.delegate.clear();
    this.inverse.delegate.clear();
  }
  
  public boolean containsValue(@Nullable Object paramObject)
  {
    return this.inverse.containsKey(paramObject);
  }
  
  protected Map<K, V> delegate()
  {
    return this.delegate;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    Set localSet = this.entrySet;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new EntrySet(null);
      this.entrySet = ((Set)localObject);
    }
    return localObject;
  }
  
  Iterator<Map.Entry<K, V>> entrySetIterator()
  {
    return new AbstractBiMap.1(this, this.delegate.entrySet().iterator());
  }
  
  @CanIgnoreReturnValue
  public V forcePut(@Nullable K paramK, @Nullable V paramV)
  {
    return putInBothMaps(paramK, paramV, true);
  }
  
  public BiMap<V, K> inverse()
  {
    return this.inverse;
  }
  
  public Set<K> keySet()
  {
    Set localSet = this.keySet;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new KeySet(null);
      this.keySet = ((Set)localObject);
    }
    return localObject;
  }
  
  AbstractBiMap<V, K> makeInverse(Map<V, K> paramMap)
  {
    return new Inverse(paramMap, this);
  }
  
  @CanIgnoreReturnValue
  public V put(@Nullable K paramK, @Nullable V paramV)
  {
    return putInBothMaps(paramK, paramV, false);
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
  public V remove(@Nullable Object paramObject)
  {
    if (containsKey(paramObject)) {
      return removeFromBothMaps(paramObject);
    }
    return null;
  }
  
  void setDelegates(Map<K, V> paramMap, Map<V, K> paramMap1)
  {
    boolean bool2 = true;
    if (this.delegate == null)
    {
      bool1 = true;
      Preconditions.checkState(bool1);
      if (this.inverse != null) {
        break label79;
      }
      bool1 = true;
      label25:
      Preconditions.checkState(bool1);
      Preconditions.checkArgument(paramMap.isEmpty());
      Preconditions.checkArgument(paramMap1.isEmpty());
      if (paramMap == paramMap1) {
        break label84;
      }
    }
    label79:
    label84:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1);
      this.delegate = paramMap;
      this.inverse = makeInverse(paramMap1);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label25;
    }
  }
  
  void setInverse(AbstractBiMap<V, K> paramAbstractBiMap)
  {
    this.inverse = paramAbstractBiMap;
  }
  
  public Set<V> values()
  {
    Set localSet = this.valueSet;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new ValueSet(null);
      this.valueSet = ((Set)localObject);
    }
    return localObject;
  }
  
  class BiMapEntry
    extends ForwardingMapEntry<K, V>
  {
    private final Map.Entry<K, V> delegate;
    
    BiMapEntry()
    {
      Object localObject;
      this.delegate = localObject;
    }
    
    protected Map.Entry<K, V> delegate()
    {
      return this.delegate;
    }
    
    public V setValue(V paramV)
    {
      Preconditions.checkState(AbstractBiMap.this.entrySet().contains(this), "entry no longer in map");
      if (Objects.equal(paramV, getValue())) {
        return paramV;
      }
      if (!AbstractBiMap.this.containsValue(paramV)) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "value already present: %s", paramV);
        Object localObject = this.delegate.setValue(paramV);
        Preconditions.checkState(Objects.equal(paramV, AbstractBiMap.this.get(getKey())), "entry no longer in map");
        AbstractBiMap.this.updateInverseMap(getKey(), true, localObject, paramV);
        return localObject;
      }
    }
  }
  
  class EntrySet
    extends ForwardingSet<Map.Entry<K, V>>
  {
    final Set<Map.Entry<K, V>> esDelegate = AbstractBiMap.this.delegate.entrySet();
    
    private EntrySet() {}
    
    public void clear()
    {
      AbstractBiMap.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return Maps.containsEntryImpl(delegate(), paramObject);
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      return standardContainsAll(paramCollection);
    }
    
    protected Set<Map.Entry<K, V>> delegate()
    {
      return this.esDelegate;
    }
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      return AbstractBiMap.this.entrySetIterator();
    }
    
    public boolean remove(Object paramObject)
    {
      if (!this.esDelegate.contains(paramObject)) {
        return false;
      }
      paramObject = (Map.Entry)paramObject;
      AbstractBiMap.this.inverse.delegate.remove(paramObject.getValue());
      this.esDelegate.remove(paramObject);
      return true;
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      return standardRemoveAll(paramCollection);
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      return standardRetainAll(paramCollection);
    }
    
    public Object[] toArray()
    {
      return standardToArray();
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return standardToArray(paramArrayOfT);
    }
  }
  
  static class Inverse<K, V>
    extends AbstractBiMap<K, V>
  {
    @GwtIncompatible
    private static final long serialVersionUID = 0L;
    
    Inverse(Map<K, V> paramMap, AbstractBiMap<V, K> paramAbstractBiMap)
    {
      super(paramAbstractBiMap, null);
    }
    
    @GwtIncompatible
    private void readObject(ObjectInputStream paramObjectInputStream)
      throws IOException, ClassNotFoundException
    {
      paramObjectInputStream.defaultReadObject();
      setInverse((AbstractBiMap)paramObjectInputStream.readObject());
    }
    
    @GwtIncompatible
    private void writeObject(ObjectOutputStream paramObjectOutputStream)
      throws IOException
    {
      paramObjectOutputStream.defaultWriteObject();
      paramObjectOutputStream.writeObject(inverse());
    }
    
    K checkKey(K paramK)
    {
      return this.inverse.checkValue(paramK);
    }
    
    V checkValue(V paramV)
    {
      return this.inverse.checkKey(paramV);
    }
    
    @GwtIncompatible
    Object readResolve()
    {
      return inverse().inverse();
    }
  }
  
  class KeySet
    extends ForwardingSet<K>
  {
    private KeySet() {}
    
    public void clear()
    {
      AbstractBiMap.this.clear();
    }
    
    protected Set<K> delegate()
    {
      return AbstractBiMap.this.delegate.keySet();
    }
    
    public Iterator<K> iterator()
    {
      return Maps.keyIterator(AbstractBiMap.this.entrySet().iterator());
    }
    
    public boolean remove(Object paramObject)
    {
      if (!contains(paramObject)) {
        return false;
      }
      AbstractBiMap.this.removeFromBothMaps(paramObject);
      return true;
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      return standardRemoveAll(paramCollection);
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      return standardRetainAll(paramCollection);
    }
  }
  
  class ValueSet
    extends ForwardingSet<V>
  {
    final Set<V> valuesDelegate = AbstractBiMap.this.inverse.keySet();
    
    private ValueSet() {}
    
    protected Set<V> delegate()
    {
      return this.valuesDelegate;
    }
    
    public Iterator<V> iterator()
    {
      return Maps.valueIterator(AbstractBiMap.this.entrySet().iterator());
    }
    
    public Object[] toArray()
    {
      return standardToArray();
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return standardToArray(paramArrayOfT);
    }
    
    public String toString()
    {
      return standardToString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.AbstractBiMap
 * JD-Core Version:    0.7.0.1
 */