package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible
public abstract interface RowSortedTable<R, C, V>
  extends Table<R, C, V>
{
  public abstract SortedSet<R> rowKeySet();
  
  public abstract SortedMap<R, Map<C, V>> rowMap();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.RowSortedTable
 * JD-Core Version:    0.7.0.1
 */