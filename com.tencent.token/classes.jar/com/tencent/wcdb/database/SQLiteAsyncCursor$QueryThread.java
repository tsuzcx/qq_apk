package com.tencent.wcdb.database;

class SQLiteAsyncCursor$QueryThread
  extends Thread
{
  private int mFetchPos = 0;
  private int mMinPos = 0;
  private volatile int mRequestPos = 0;
  
  SQLiteAsyncCursor$QueryThread(SQLiteAsyncCursor paramSQLiteAsyncCursor)
  {
    super("SQLiteAsyncCursor.QueryThread");
  }
  
  void quit()
  {
    interrupt();
  }
  
  void requestPos(int paramInt)
  {
    try
    {
      this.mRequestPos = paramInt;
      notifyAll();
      return;
    }
    finally {}
  }
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        i = SQLiteAsyncCursor.access$000(this.this$0).getCount();
        i = this.mRequestPos;
      }
      catch (InterruptedException localInterruptedException) {}finally
      {
        SQLiteAsyncCursor.access$000(this.this$0).release();
      }
      if (i < this.mMinPos)
      {
        SQLiteAsyncCursor.access$000(this.this$0).reset();
        this.mFetchPos = 0;
        SQLiteAsyncCursor.access$300(this.this$0).clear();
        this.mMinPos = 0;
      }
      if (this.mFetchPos < i + 256)
      {
        if (SQLiteAsyncCursor.access$300(this.this$0).getNumChunks() > 32)
        {
          long l = SQLiteAsyncCursor.access$300(this.this$0).removeChunk(this.mMinPos);
          if (l != -1L) {
            this.mMinPos = ((int)l);
          }
        }
        synchronized (SQLiteAsyncCursor.access$100(this.this$0))
        {
          int j = SQLiteAsyncCursor.access$000(this.this$0).fillRows(SQLiteAsyncCursor.access$300(this.this$0), this.mFetchPos, 32);
          if ((this.mFetchPos <= i) && (this.mFetchPos + j > i)) {
            SQLiteAsyncCursor.access$100(this.this$0).notifyAll();
          }
          this.mFetchPos += j;
        }
      }
    }
    SQLiteAsyncCursor.access$000(this.this$0).release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteAsyncCursor.QueryThread
 * JD-Core Version:    0.7.0.1
 */