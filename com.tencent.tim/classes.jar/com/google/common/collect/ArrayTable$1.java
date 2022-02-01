package com.google.common.collect;

class ArrayTable$1
  extends AbstractIndexedListIterator<Table.Cell<R, C, V>>
{
  ArrayTable$1(ArrayTable paramArrayTable, int paramInt)
  {
    super(paramInt);
  }
  
  protected Table.Cell<R, C, V> get(int paramInt)
  {
    return new ArrayTable.1.1(this, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ArrayTable.1
 * JD-Core Version:    0.7.0.1
 */