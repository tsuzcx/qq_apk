package com.google.common.collect;

import java.util.Comparator;

final class RegularImmutableTable$1
  implements Comparator<Table.Cell<R, C, V>>
{
  RegularImmutableTable$1(Comparator paramComparator1, Comparator paramComparator2) {}
  
  public int compare(Table.Cell<R, C, V> paramCell1, Table.Cell<R, C, V> paramCell2)
  {
    int j = 0;
    int i;
    if (this.val$rowComparator == null)
    {
      i = 0;
      if (i == 0) {
        break label43;
      }
    }
    label43:
    do
    {
      return i;
      i = this.val$rowComparator.compare(paramCell1.getRowKey(), paramCell2.getRowKey());
      break;
      i = j;
    } while (this.val$columnComparator == null);
    return this.val$columnComparator.compare(paramCell1.getColumnKey(), paramCell2.getColumnKey());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.RegularImmutableTable.1
 * JD-Core Version:    0.7.0.1
 */