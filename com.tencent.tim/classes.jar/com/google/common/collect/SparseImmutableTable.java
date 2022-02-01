package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.concurrent.Immutable;

@GwtCompatible
@Immutable
final class SparseImmutableTable<R, C, V>
  extends RegularImmutableTable<R, C, V>
{
  static final ImmutableTable<Object, Object, Object> EMPTY = new SparseImmutableTable(ImmutableList.of(), ImmutableSet.of(), ImmutableSet.of());
  private final int[] cellColumnInRowIndices;
  private final int[] cellRowIndices;
  private final ImmutableMap<C, Map<R, V>> columnMap;
  private final ImmutableMap<R, Map<C, V>> rowMap;
  
  SparseImmutableTable(ImmutableList<Table.Cell<R, C, V>> paramImmutableList, ImmutableSet<R> paramImmutableSet, ImmutableSet<C> paramImmutableSet1)
  {
    ImmutableMap localImmutableMap = Maps.indexMap(paramImmutableSet);
    Object localObject1 = Maps.newLinkedHashMap();
    paramImmutableSet = paramImmutableSet.iterator();
    while (paramImmutableSet.hasNext()) {
      ((Map)localObject1).put(paramImmutableSet.next(), new LinkedHashMap());
    }
    paramImmutableSet = Maps.newLinkedHashMap();
    paramImmutableSet1 = paramImmutableSet1.iterator();
    while (paramImmutableSet1.hasNext()) {
      paramImmutableSet.put(paramImmutableSet1.next(), new LinkedHashMap());
    }
    paramImmutableSet1 = new int[paramImmutableList.size()];
    int[] arrayOfInt = new int[paramImmutableList.size()];
    int i = 0;
    while (i < paramImmutableList.size())
    {
      Object localObject4 = (Table.Cell)paramImmutableList.get(i);
      Object localObject2 = ((Table.Cell)localObject4).getRowKey();
      Object localObject3 = ((Table.Cell)localObject4).getColumnKey();
      localObject4 = ((Table.Cell)localObject4).getValue();
      paramImmutableSet1[i] = ((Integer)localImmutableMap.get(localObject2)).intValue();
      Object localObject5 = (Map)((Map)localObject1).get(localObject2);
      arrayOfInt[i] = ((Map)localObject5).size();
      localObject5 = ((Map)localObject5).put(localObject3, localObject4);
      if (localObject5 != null) {
        throw new IllegalArgumentException("Duplicate value for row=" + localObject2 + ", column=" + localObject3 + ": " + localObject4 + ", " + localObject5);
      }
      ((Map)paramImmutableSet.get(localObject3)).put(localObject2, localObject4);
      i += 1;
    }
    this.cellRowIndices = paramImmutableSet1;
    this.cellColumnInRowIndices = arrayOfInt;
    paramImmutableList = new ImmutableMap.Builder(((Map)localObject1).size());
    paramImmutableSet1 = ((Map)localObject1).entrySet().iterator();
    while (paramImmutableSet1.hasNext())
    {
      localObject1 = (Map.Entry)paramImmutableSet1.next();
      paramImmutableList.put(((Map.Entry)localObject1).getKey(), ImmutableMap.copyOf((Map)((Map.Entry)localObject1).getValue()));
    }
    this.rowMap = paramImmutableList.build();
    paramImmutableList = new ImmutableMap.Builder(paramImmutableSet.size());
    paramImmutableSet = paramImmutableSet.entrySet().iterator();
    while (paramImmutableSet.hasNext())
    {
      paramImmutableSet1 = (Map.Entry)paramImmutableSet.next();
      paramImmutableList.put(paramImmutableSet1.getKey(), ImmutableMap.copyOf((Map)paramImmutableSet1.getValue()));
    }
    this.columnMap = paramImmutableList.build();
  }
  
  public ImmutableMap<C, Map<R, V>> columnMap()
  {
    return this.columnMap;
  }
  
  ImmutableTable.SerializedForm createSerializedForm()
  {
    ImmutableMap localImmutableMap = Maps.indexMap(columnKeySet());
    int[] arrayOfInt = new int[cellSet().size()];
    Iterator localIterator = cellSet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      arrayOfInt[i] = ((Integer)localImmutableMap.get(((Table.Cell)localIterator.next()).getColumnKey())).intValue();
      i += 1;
    }
    return ImmutableTable.SerializedForm.create(this, this.cellRowIndices, arrayOfInt);
  }
  
  Table.Cell<R, C, V> getCell(int paramInt)
  {
    int i = this.cellRowIndices[paramInt];
    Map.Entry localEntry = (Map.Entry)this.rowMap.entrySet().asList().get(i);
    Object localObject = (ImmutableMap)localEntry.getValue();
    paramInt = this.cellColumnInRowIndices[paramInt];
    localObject = (Map.Entry)((ImmutableMap)localObject).entrySet().asList().get(paramInt);
    return cellOf(localEntry.getKey(), ((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
  }
  
  V getValue(int paramInt)
  {
    int i = this.cellRowIndices[paramInt];
    ImmutableMap localImmutableMap = (ImmutableMap)this.rowMap.values().asList().get(i);
    paramInt = this.cellColumnInRowIndices[paramInt];
    return localImmutableMap.values().asList().get(paramInt);
  }
  
  public ImmutableMap<R, Map<C, V>> rowMap()
  {
    return this.rowMap;
  }
  
  public int size()
  {
    return this.cellRowIndices.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.SparseImmutableTable
 * JD-Core Version:    0.7.0.1
 */