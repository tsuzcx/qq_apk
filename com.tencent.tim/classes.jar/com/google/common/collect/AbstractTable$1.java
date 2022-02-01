package com.google.common.collect;

import java.util.Iterator;

class AbstractTable$1
  extends TransformedIterator<Table.Cell<R, C, V>, V>
{
  AbstractTable$1(AbstractTable paramAbstractTable, Iterator paramIterator)
  {
    super(paramIterator);
  }
  
  V transform(Table.Cell<R, C, V> paramCell)
  {
    return paramCell.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.AbstractTable.1
 * JD-Core Version:    0.7.0.1
 */