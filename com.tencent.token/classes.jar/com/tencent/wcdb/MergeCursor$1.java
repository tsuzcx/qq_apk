package com.tencent.wcdb;

import android.database.DataSetObserver;

class MergeCursor$1
  extends DataSetObserver
{
  MergeCursor$1(MergeCursor paramMergeCursor) {}
  
  public void onChanged()
  {
    this.this$0.mPos = -1;
  }
  
  public void onInvalidated()
  {
    this.this$0.mPos = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.MergeCursor.1
 * JD-Core Version:    0.7.0.1
 */