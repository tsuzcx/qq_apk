package com.google.common.collect;

import com.google.common.base.Function;

class Tables$TransformedTable$1
  implements Function<Table.Cell<R, C, V1>, Table.Cell<R, C, V2>>
{
  Tables$TransformedTable$1(Tables.TransformedTable paramTransformedTable) {}
  
  public Table.Cell<R, C, V2> apply(Table.Cell<R, C, V1> paramCell)
  {
    return Tables.immutableCell(paramCell.getRowKey(), paramCell.getColumnKey(), this.this$0.function.apply(paramCell.getValue()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Tables.TransformedTable.1
 * JD-Core Version:    0.7.0.1
 */