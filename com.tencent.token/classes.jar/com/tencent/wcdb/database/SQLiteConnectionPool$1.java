package com.tencent.wcdb.database;

import com.tencent.wcdb.support.CancellationSignal.OnCancelListener;

class SQLiteConnectionPool$1
  implements CancellationSignal.OnCancelListener
{
  SQLiteConnectionPool$1(SQLiteConnectionPool paramSQLiteConnectionPool, SQLiteConnectionPool.ConnectionWaiter paramConnectionWaiter, int paramInt) {}
  
  public void onCancel()
  {
    synchronized (SQLiteConnectionPool.access$000(this.this$0))
    {
      if (this.val$waiter.mNonce == this.val$nonce) {
        SQLiteConnectionPool.access$100(this.this$0, this.val$waiter);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteConnectionPool.1
 * JD-Core Version:    0.7.0.1
 */