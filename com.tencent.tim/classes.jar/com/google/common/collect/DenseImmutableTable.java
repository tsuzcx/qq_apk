package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@GwtCompatible
@Immutable
final class DenseImmutableTable<R, C, V>
  extends RegularImmutableTable<R, C, V>
{
  private final int[] cellColumnIndices;
  private final int[] cellRowIndices;
  private final int[] columnCounts;
  private final ImmutableMap<C, Integer> columnKeyToIndex;
  private final ImmutableMap<C, Map<R, V>> columnMap;
  private final int[] rowCounts;
  private final ImmutableMap<R, Integer> rowKeyToIndex;
  private final ImmutableMap<R, Map<C, V>> rowMap;
  private final V[][] values;
  
  DenseImmutableTable(ImmutableList<Table.Cell<R, C, V>> paramImmutableList, ImmutableSet<R> paramImmutableSet, ImmutableSet<C> paramImmutableSet1)
  {
    this.values = ((Object[][])Array.newInstance(Object.class, new int[] { paramImmutableSet.size(), paramImmutableSet1.size() }));
    this.rowKeyToIndex = Maps.indexMap(paramImmutableSet);
    this.columnKeyToIndex = Maps.indexMap(paramImmutableSet1);
    this.rowCounts = new int[this.rowKeyToIndex.size()];
    this.columnCounts = new int[this.columnKeyToIndex.size()];
    paramImmutableSet = new int[paramImmutableList.size()];
    paramImmutableSet1 = new int[paramImmutableList.size()];
    int i = 0;
    if (i < paramImmutableList.size())
    {
      Object localObject1 = (Table.Cell)paramImmutableList.get(i);
      Object localObject2 = ((Table.Cell)localObject1).getRowKey();
      Object localObject3 = ((Table.Cell)localObject1).getColumnKey();
      int j = ((Integer)this.rowKeyToIndex.get(localObject2)).intValue();
      int k = ((Integer)this.columnKeyToIndex.get(localObject3)).intValue();
      if (this.values[j][k] == null) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "duplicate key: (%s, %s)", localObject2, localObject3);
        this.values[j][k] = ((Table.Cell)localObject1).getValue();
        localObject1 = this.rowCounts;
        localObject1[j] += 1;
        localObject1 = this.columnCounts;
        localObject1[k] += 1;
        paramImmutableSet[i] = j;
        paramImmutableSet1[i] = k;
        i += 1;
        break;
      }
    }
    this.cellRowIndices = paramImmutableSet;
    this.cellColumnIndices = paramImmutableSet1;
    this.rowMap = new RowMap(null);
    this.columnMap = new ColumnMap(null);
  }
  
  public ImmutableMap<C, Map<R, V>> columnMap()
  {
    return this.columnMap;
  }
  
  ImmutableTable.SerializedForm createSerializedForm()
  {
    return ImmutableTable.SerializedForm.create(this, this.cellRowIndices, this.cellColumnIndices);
  }
  
  public V get(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    paramObject1 = (Integer)this.rowKeyToIndex.get(paramObject1);
    paramObject2 = (Integer)this.columnKeyToIndex.get(paramObject2);
    if ((paramObject1 == null) || (paramObject2 == null)) {
      return null;
    }
    return this.values[paramObject1.intValue()][paramObject2.intValue()];
  }
  
  Table.Cell<R, C, V> getCell(int paramInt)
  {
    int i = this.cellRowIndices[paramInt];
    paramInt = this.cellColumnIndices[paramInt];
    return cellOf(rowKeySet().asList().get(i), columnKeySet().asList().get(paramInt), this.values[i][paramInt]);
  }
  
  V getValue(int paramInt)
  {
    return this.values[this.cellRowIndices[paramInt]][this.cellColumnIndices[paramInt]];
  }
  
  public ImmutableMap<R, Map<C, V>> rowMap()
  {
    return this.rowMap;
  }
  
  public int size()
  {
    return this.cellRowIndices.length;
  }
  
  final class Column
    extends DenseImmutableTable.ImmutableArrayMap<R, V>
  {
    private final int columnIndex;
    
    Column(int paramInt)
    {
      super();
      this.columnIndex = paramInt;
    }
    
    V getValue(int paramInt)
    {
      return DenseImmutableTable.this.values[paramInt][this.columnIndex];
    }
    
    boolean isPartialView()
    {
      return true;
    }
    
    ImmutableMap<R, Integer> keyToIndex()
    {
      return DenseImmutableTable.this.rowKeyToIndex;
    }
  }
  
  final class ColumnMap
    extends DenseImmutableTable.ImmutableArrayMap<C, Map<R, V>>
  {
    private ColumnMap()
    {
      super();
    }
    
    Map<R, V> getValue(int paramInt)
    {
      return new DenseImmutableTable.Column(DenseImmutableTable.this, paramInt);
    }
    
    boolean isPartialView()
    {
      return false;
    }
    
    ImmutableMap<C, Integer> keyToIndex()
    {
      return DenseImmutableTable.this.columnKeyToIndex;
    }
  }
  
  static abstract class ImmutableArrayMap<K, V>
    extends ImmutableMap.IteratorBasedImmutableMap<K, V>
  {
    private final int size;
    
    ImmutableArrayMap(int paramInt)
    {
      this.size = paramInt;
    }
    
    private boolean isFull()
    {
      return this.size == keyToIndex().size();
    }
    
    ImmutableSet<K> createKeySet()
    {
      if (isFull()) {
        return keyToIndex().keySet();
      }
      return super.createKeySet();
    }
    
    UnmodifiableIterator<Map.Entry<K, V>> entryIterator()
    {
      return new DenseImmutableTable.ImmutableArrayMap.1(this);
    }
    
    public V get(@Nullable Object paramObject)
    {
      paramObject = (Integer)keyToIndex().get(paramObject);
      if (paramObject == null) {
        return null;
      }
      return getValue(paramObject.intValue());
    }
    
    K getKey(int paramInt)
    {
      return keyToIndex().keySet().asList().get(paramInt);
    }
    
    @Nullable
    abstract V getValue(int paramInt);
    
    abstract ImmutableMap<K, Integer> keyToIndex();
    
    public int size()
    {
      return this.size;
    }
  }
  
  final class Row
    extends DenseImmutableTable.ImmutableArrayMap<C, V>
  {
    private final int rowIndex;
    
    Row(int paramInt)
    {
      super();
      this.rowIndex = paramInt;
    }
    
    V getValue(int paramInt)
    {
      return DenseImmutableTable.this.values[this.rowIndex][paramInt];
    }
    
    boolean isPartialView()
    {
      return true;
    }
    
    ImmutableMap<C, Integer> keyToIndex()
    {
      return DenseImmutableTable.this.columnKeyToIndex;
    }
  }
  
  final class RowMap
    extends DenseImmutableTable.ImmutableArrayMap<R, Map<C, V>>
  {
    private RowMap()
    {
      super();
    }
    
    Map<C, V> getValue(int paramInt)
    {
      return new DenseImmutableTable.Row(DenseImmutableTable.this, paramInt);
    }
    
    boolean isPartialView()
    {
      return false;
    }
    
    ImmutableMap<R, Integer> keyToIndex()
    {
      return DenseImmutableTable.this.rowKeyToIndex;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.DenseImmutableTable
 * JD-Core Version:    0.7.0.1
 */