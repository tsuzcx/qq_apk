package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
public class TreeBasedTable<R, C, V>
  extends StandardRowSortedTable<R, C, V>
{
  private static final long serialVersionUID = 0L;
  private final Comparator<? super C> columnComparator;
  
  TreeBasedTable(Comparator<? super R> paramComparator, Comparator<? super C> paramComparator1)
  {
    super(new TreeMap(paramComparator), new Factory(paramComparator1));
    this.columnComparator = paramComparator1;
  }
  
  public static <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> create()
  {
    return new TreeBasedTable(Ordering.natural(), Ordering.natural());
  }
  
  public static <R, C, V> TreeBasedTable<R, C, V> create(TreeBasedTable<R, C, ? extends V> paramTreeBasedTable)
  {
    TreeBasedTable localTreeBasedTable = new TreeBasedTable(paramTreeBasedTable.rowComparator(), paramTreeBasedTable.columnComparator());
    localTreeBasedTable.putAll(paramTreeBasedTable);
    return localTreeBasedTable;
  }
  
  public static <R, C, V> TreeBasedTable<R, C, V> create(Comparator<? super R> paramComparator, Comparator<? super C> paramComparator1)
  {
    Preconditions.checkNotNull(paramComparator);
    Preconditions.checkNotNull(paramComparator1);
    return new TreeBasedTable(paramComparator, paramComparator1);
  }
  
  public Comparator<? super C> columnComparator()
  {
    return this.columnComparator;
  }
  
  Iterator<C> createColumnKeyIterator()
  {
    Comparator localComparator = columnComparator();
    return new TreeBasedTable.2(this, Iterators.mergeSorted(Iterables.transform(this.backingMap.values(), new TreeBasedTable.1(this)), localComparator), localComparator);
  }
  
  public SortedMap<C, V> row(R paramR)
  {
    return new TreeRow(paramR);
  }
  
  public Comparator<? super R> rowComparator()
  {
    return rowKeySet().comparator();
  }
  
  public SortedSet<R> rowKeySet()
  {
    return super.rowKeySet();
  }
  
  public SortedMap<R, Map<C, V>> rowMap()
  {
    return super.rowMap();
  }
  
  static class Factory<C, V>
    implements Supplier<TreeMap<C, V>>, Serializable
  {
    private static final long serialVersionUID = 0L;
    final Comparator<? super C> comparator;
    
    Factory(Comparator<? super C> paramComparator)
    {
      this.comparator = paramComparator;
    }
    
    public TreeMap<C, V> get()
    {
      return new TreeMap(this.comparator);
    }
  }
  
  class TreeRow
    extends StandardTable<R, C, V>.Row
    implements SortedMap<C, V>
  {
    @Nullable
    final C lowerBound;
    @Nullable
    final C upperBound;
    transient SortedMap<C, V> wholeRow;
    
    TreeRow()
    {
      this(localObject, null, null);
    }
    
    TreeRow(C paramC1, @Nullable C paramC2)
    {
      super(paramC1);
      this.lowerBound = paramC2;
      Object localObject;
      this.upperBound = localObject;
      if ((paramC2 == null) || (localObject == null) || (compare(paramC2, localObject) <= 0)) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool);
        return;
      }
    }
    
    SortedMap<C, V> backingRowMap()
    {
      return (SortedMap)super.backingRowMap();
    }
    
    public Comparator<? super C> comparator()
    {
      return TreeBasedTable.this.columnComparator();
    }
    
    int compare(Object paramObject1, Object paramObject2)
    {
      return comparator().compare(paramObject1, paramObject2);
    }
    
    SortedMap<C, V> computeBackingRowMap()
    {
      Object localObject2 = wholeRow();
      if (localObject2 != null)
      {
        Object localObject1 = localObject2;
        if (this.lowerBound != null) {
          localObject1 = ((SortedMap)localObject2).tailMap(this.lowerBound);
        }
        localObject2 = localObject1;
        if (this.upperBound != null) {
          localObject2 = ((SortedMap)localObject1).headMap(this.upperBound);
        }
        return localObject2;
      }
      return null;
    }
    
    public boolean containsKey(Object paramObject)
    {
      return (rangeContains(paramObject)) && (super.containsKey(paramObject));
    }
    
    public C firstKey()
    {
      if (backingRowMap() == null) {
        throw new NoSuchElementException();
      }
      return backingRowMap().firstKey();
    }
    
    public SortedMap<C, V> headMap(C paramC)
    {
      Preconditions.checkArgument(rangeContains(Preconditions.checkNotNull(paramC)));
      return new TreeRow(TreeBasedTable.this, this.rowKey, this.lowerBound, paramC);
    }
    
    public SortedSet<C> keySet()
    {
      return new Maps.SortedKeySet(this);
    }
    
    public C lastKey()
    {
      if (backingRowMap() == null) {
        throw new NoSuchElementException();
      }
      return backingRowMap().lastKey();
    }
    
    void maintainEmptyInvariant()
    {
      if ((wholeRow() != null) && (this.wholeRow.isEmpty()))
      {
        TreeBasedTable.this.backingMap.remove(this.rowKey);
        this.wholeRow = null;
        this.backingRowMap = null;
      }
    }
    
    public V put(C paramC, V paramV)
    {
      Preconditions.checkArgument(rangeContains(Preconditions.checkNotNull(paramC)));
      return super.put(paramC, paramV);
    }
    
    boolean rangeContains(@Nullable Object paramObject)
    {
      return (paramObject != null) && ((this.lowerBound == null) || (compare(this.lowerBound, paramObject) <= 0)) && ((this.upperBound == null) || (compare(this.upperBound, paramObject) > 0));
    }
    
    public SortedMap<C, V> subMap(C paramC1, C paramC2)
    {
      if ((rangeContains(Preconditions.checkNotNull(paramC1))) && (rangeContains(Preconditions.checkNotNull(paramC2)))) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool);
        return new TreeRow(TreeBasedTable.this, this.rowKey, paramC1, paramC2);
      }
    }
    
    public SortedMap<C, V> tailMap(C paramC)
    {
      Preconditions.checkArgument(rangeContains(Preconditions.checkNotNull(paramC)));
      return new TreeRow(TreeBasedTable.this, this.rowKey, paramC, this.upperBound);
    }
    
    SortedMap<C, V> wholeRow()
    {
      if ((this.wholeRow == null) || ((this.wholeRow.isEmpty()) && (TreeBasedTable.this.backingMap.containsKey(this.rowKey)))) {
        this.wholeRow = ((SortedMap)TreeBasedTable.this.backingMap.get(this.rowKey));
      }
      return this.wholeRow;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.TreeBasedTable
 * JD-Core Version:    0.7.0.1
 */