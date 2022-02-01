package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AbstractTable<R, C, V>
  implements Table<R, C, V>
{
  private transient Set<Table.Cell<R, C, V>> cellSet;
  private transient Collection<V> values;
  
  abstract Iterator<Table.Cell<R, C, V>> cellIterator();
  
  public Set<Table.Cell<R, C, V>> cellSet()
  {
    Set localSet2 = this.cellSet;
    Set localSet1 = localSet2;
    if (localSet2 == null)
    {
      localSet1 = createCellSet();
      this.cellSet = localSet1;
    }
    return localSet1;
  }
  
  public void clear()
  {
    Iterators.clear(cellSet().iterator());
  }
  
  public Set<C> columnKeySet()
  {
    return columnMap().keySet();
  }
  
  public boolean contains(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    paramObject1 = (Map)Maps.safeGet(rowMap(), paramObject1);
    return (paramObject1 != null) && (Maps.safeContainsKey(paramObject1, paramObject2));
  }
  
  public boolean containsColumn(@Nullable Object paramObject)
  {
    return Maps.safeContainsKey(columnMap(), paramObject);
  }
  
  public boolean containsRow(@Nullable Object paramObject)
  {
    return Maps.safeContainsKey(rowMap(), paramObject);
  }
  
  public boolean containsValue(@Nullable Object paramObject)
  {
    Iterator localIterator = rowMap().values().iterator();
    while (localIterator.hasNext()) {
      if (((Map)localIterator.next()).containsValue(paramObject)) {
        return true;
      }
    }
    return false;
  }
  
  Set<Table.Cell<R, C, V>> createCellSet()
  {
    return new CellSet();
  }
  
  Collection<V> createValues()
  {
    return new Values();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return Tables.equalsImpl(this, paramObject);
  }
  
  public V get(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    paramObject1 = (Map)Maps.safeGet(rowMap(), paramObject1);
    if (paramObject1 == null) {
      return null;
    }
    return Maps.safeGet(paramObject1, paramObject2);
  }
  
  public int hashCode()
  {
    return cellSet().hashCode();
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  @CanIgnoreReturnValue
  public V put(R paramR, C paramC, V paramV)
  {
    return row(paramR).put(paramC, paramV);
  }
  
  public void putAll(Table<? extends R, ? extends C, ? extends V> paramTable)
  {
    paramTable = paramTable.cellSet().iterator();
    while (paramTable.hasNext())
    {
      Table.Cell localCell = (Table.Cell)paramTable.next();
      put(localCell.getRowKey(), localCell.getColumnKey(), localCell.getValue());
    }
  }
  
  @CanIgnoreReturnValue
  public V remove(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    paramObject1 = (Map)Maps.safeGet(rowMap(), paramObject1);
    if (paramObject1 == null) {
      return null;
    }
    return Maps.safeRemove(paramObject1, paramObject2);
  }
  
  public Set<R> rowKeySet()
  {
    return rowMap().keySet();
  }
  
  public String toString()
  {
    return rowMap().toString();
  }
  
  public Collection<V> values()
  {
    Collection localCollection2 = this.values;
    Collection localCollection1 = localCollection2;
    if (localCollection2 == null)
    {
      localCollection1 = createValues();
      this.values = localCollection1;
    }
    return localCollection1;
  }
  
  Iterator<V> valuesIterator()
  {
    return new AbstractTable.1(this, cellSet().iterator());
  }
  
  class CellSet
    extends AbstractSet<Table.Cell<R, C, V>>
  {
    CellSet() {}
    
    public void clear()
    {
      AbstractTable.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      if ((paramObject instanceof Table.Cell))
      {
        paramObject = (Table.Cell)paramObject;
        Map localMap = (Map)Maps.safeGet(AbstractTable.this.rowMap(), paramObject.getRowKey());
        return (localMap != null) && (Collections2.safeContains(localMap.entrySet(), Maps.immutableEntry(paramObject.getColumnKey(), paramObject.getValue())));
      }
      return false;
    }
    
    public Iterator<Table.Cell<R, C, V>> iterator()
    {
      return AbstractTable.this.cellIterator();
    }
    
    public boolean remove(@Nullable Object paramObject)
    {
      if ((paramObject instanceof Table.Cell))
      {
        paramObject = (Table.Cell)paramObject;
        Map localMap = (Map)Maps.safeGet(AbstractTable.this.rowMap(), paramObject.getRowKey());
        return (localMap != null) && (Collections2.safeRemove(localMap.entrySet(), Maps.immutableEntry(paramObject.getColumnKey(), paramObject.getValue())));
      }
      return false;
    }
    
    public int size()
    {
      return AbstractTable.this.size();
    }
  }
  
  class Values
    extends AbstractCollection<V>
  {
    Values() {}
    
    public void clear()
    {
      AbstractTable.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return AbstractTable.this.containsValue(paramObject);
    }
    
    public Iterator<V> iterator()
    {
      return AbstractTable.this.valuesIterator();
    }
    
    public int size()
    {
      return AbstractTable.this.size();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.AbstractTable
 * JD-Core Version:    0.7.0.1
 */