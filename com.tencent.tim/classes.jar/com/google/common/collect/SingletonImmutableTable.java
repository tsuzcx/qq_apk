package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Map;

@GwtCompatible
class SingletonImmutableTable<R, C, V>
  extends ImmutableTable<R, C, V>
{
  final C singleColumnKey;
  final R singleRowKey;
  final V singleValue;
  
  SingletonImmutableTable(Table.Cell<R, C, V> paramCell)
  {
    this(paramCell.getRowKey(), paramCell.getColumnKey(), paramCell.getValue());
  }
  
  SingletonImmutableTable(R paramR, C paramC, V paramV)
  {
    this.singleRowKey = Preconditions.checkNotNull(paramR);
    this.singleColumnKey = Preconditions.checkNotNull(paramC);
    this.singleValue = Preconditions.checkNotNull(paramV);
  }
  
  public ImmutableMap<R, V> column(C paramC)
  {
    Preconditions.checkNotNull(paramC);
    if (containsColumn(paramC)) {
      return ImmutableMap.of(this.singleRowKey, this.singleValue);
    }
    return ImmutableMap.of();
  }
  
  public ImmutableMap<C, Map<R, V>> columnMap()
  {
    return ImmutableMap.of(this.singleColumnKey, ImmutableMap.of(this.singleRowKey, this.singleValue));
  }
  
  ImmutableSet<Table.Cell<R, C, V>> createCellSet()
  {
    return ImmutableSet.of(cellOf(this.singleRowKey, this.singleColumnKey, this.singleValue));
  }
  
  ImmutableTable.SerializedForm createSerializedForm()
  {
    return ImmutableTable.SerializedForm.create(this, new int[] { 0 }, new int[] { 0 });
  }
  
  ImmutableCollection<V> createValues()
  {
    return ImmutableSet.of(this.singleValue);
  }
  
  public ImmutableMap<R, Map<C, V>> rowMap()
  {
    return ImmutableMap.of(this.singleRowKey, ImmutableMap.of(this.singleColumnKey, this.singleValue));
  }
  
  public int size()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.SingletonImmutableTable
 * JD-Core Version:    0.7.0.1
 */