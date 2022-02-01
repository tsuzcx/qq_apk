package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
abstract class RegularImmutableTable<R, C, V>
  extends ImmutableTable<R, C, V>
{
  static <R, C, V> RegularImmutableTable<R, C, V> forCells(Iterable<Table.Cell<R, C, V>> paramIterable)
  {
    return forCellsInternal(paramIterable, null, null);
  }
  
  static <R, C, V> RegularImmutableTable<R, C, V> forCells(List<Table.Cell<R, C, V>> paramList, @Nullable Comparator<? super R> paramComparator, @Nullable Comparator<? super C> paramComparator1)
  {
    Preconditions.checkNotNull(paramList);
    if ((paramComparator != null) || (paramComparator1 != null)) {
      Collections.sort(paramList, new RegularImmutableTable.1(paramComparator, paramComparator1));
    }
    return forCellsInternal(paramList, paramComparator, paramComparator1);
  }
  
  private static final <R, C, V> RegularImmutableTable<R, C, V> forCellsInternal(Iterable<Table.Cell<R, C, V>> paramIterable, @Nullable Comparator<? super R> paramComparator, @Nullable Comparator<? super C> paramComparator1)
  {
    LinkedHashSet localLinkedHashSet2 = new LinkedHashSet();
    LinkedHashSet localLinkedHashSet1 = new LinkedHashSet();
    ImmutableList localImmutableList = ImmutableList.copyOf(paramIterable);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Table.Cell localCell = (Table.Cell)paramIterable.next();
      localLinkedHashSet2.add(localCell.getRowKey());
      localLinkedHashSet1.add(localCell.getColumnKey());
    }
    if (paramComparator == null)
    {
      paramIterable = ImmutableSet.copyOf(localLinkedHashSet2);
      if (paramComparator1 != null) {
        break label126;
      }
    }
    label126:
    for (paramComparator = ImmutableSet.copyOf(localLinkedHashSet1);; paramComparator = ImmutableSet.copyOf(Ordering.from(paramComparator1).immutableSortedCopy(localLinkedHashSet1)))
    {
      return forOrderedComponents(localImmutableList, paramIterable, paramComparator);
      paramIterable = ImmutableSet.copyOf(Ordering.from(paramComparator).immutableSortedCopy(localLinkedHashSet2));
      break;
    }
  }
  
  static <R, C, V> RegularImmutableTable<R, C, V> forOrderedComponents(ImmutableList<Table.Cell<R, C, V>> paramImmutableList, ImmutableSet<R> paramImmutableSet, ImmutableSet<C> paramImmutableSet1)
  {
    if (paramImmutableList.size() > paramImmutableSet.size() * paramImmutableSet1.size() / 2L) {
      return new DenseImmutableTable(paramImmutableList, paramImmutableSet, paramImmutableSet1);
    }
    return new SparseImmutableTable(paramImmutableList, paramImmutableSet, paramImmutableSet1);
  }
  
  final ImmutableSet<Table.Cell<R, C, V>> createCellSet()
  {
    if (isEmpty()) {
      return ImmutableSet.of();
    }
    return new CellSet(null);
  }
  
  final ImmutableCollection<V> createValues()
  {
    if (isEmpty()) {
      return ImmutableList.of();
    }
    return new Values(null);
  }
  
  abstract Table.Cell<R, C, V> getCell(int paramInt);
  
  abstract V getValue(int paramInt);
  
  final class CellSet
    extends ImmutableSet.Indexed<Table.Cell<R, C, V>>
  {
    private CellSet() {}
    
    public boolean contains(@Nullable Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof Table.Cell))
      {
        paramObject = (Table.Cell)paramObject;
        Object localObject = RegularImmutableTable.this.get(paramObject.getRowKey(), paramObject.getColumnKey());
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
    
    Table.Cell<R, C, V> get(int paramInt)
    {
      return RegularImmutableTable.this.getCell(paramInt);
    }
    
    boolean isPartialView()
    {
      return false;
    }
    
    public int size()
    {
      return RegularImmutableTable.this.size();
    }
  }
  
  final class Values
    extends ImmutableList<V>
  {
    private Values() {}
    
    public V get(int paramInt)
    {
      return RegularImmutableTable.this.getValue(paramInt);
    }
    
    boolean isPartialView()
    {
      return true;
    }
    
    public int size()
    {
      return RegularImmutableTable.this.size();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.RegularImmutableTable
 * JD-Core Version:    0.7.0.1
 */