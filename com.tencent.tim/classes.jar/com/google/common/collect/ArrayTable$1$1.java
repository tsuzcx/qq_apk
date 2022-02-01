package com.google.common.collect;

class ArrayTable$1$1
  extends Tables.AbstractCell<R, C, V>
{
  final int columnIndex = this.val$index % ArrayTable.access$000(this.this$1.this$0).size();
  final int rowIndex = this.val$index / ArrayTable.access$000(this.this$1.this$0).size();
  
  ArrayTable$1$1(ArrayTable.1 param1, int paramInt) {}
  
  public C getColumnKey()
  {
    return ArrayTable.access$000(this.this$1.this$0).get(this.columnIndex);
  }
  
  public R getRowKey()
  {
    return ArrayTable.access$100(this.this$1.this$0).get(this.rowIndex);
  }
  
  public V getValue()
  {
    return this.this$1.this$0.at(this.rowIndex, this.columnIndex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ArrayTable.1.1
 * JD-Core Version:    0.7.0.1
 */