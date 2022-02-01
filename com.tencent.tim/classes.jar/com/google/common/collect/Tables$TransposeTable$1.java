package com.google.common.collect;

import com.google.common.base.Function;

final class Tables$TransposeTable$1
  implements Function<Table.Cell<?, ?, ?>, Table.Cell<?, ?, ?>>
{
  public Table.Cell<?, ?, ?> apply(Table.Cell<?, ?, ?> paramCell)
  {
    return Tables.immutableCell(paramCell.getColumnKey(), paramCell.getRowKey(), paramCell.getValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Tables.TransposeTable.1
 * JD-Core Version:    0.7.0.1
 */