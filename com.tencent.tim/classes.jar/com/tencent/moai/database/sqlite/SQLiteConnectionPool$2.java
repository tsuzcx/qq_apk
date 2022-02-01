package com.tencent.moai.database.sqlite;

class SQLiteConnectionPool$2
  implements CancellationSignal.OnCancelListener
{
  SQLiteConnectionPool$2(SQLiteConnectionPool paramSQLiteConnectionPool, SQLiteConnectionPool.ConnectionWaiter paramConnectionWaiter, int paramInt) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.database.sqlite.SQLiteConnectionPool.2
 * JD-Core Version:    0.7.0.1
 */