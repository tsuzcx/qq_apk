package com.tencent.wcdb.database;

final class SQLiteConnectionPool$ConnectionWaiter
{
  public SQLiteConnection mAssignedConnection;
  public int mConnectionFlags;
  public RuntimeException mException;
  public ConnectionWaiter mNext;
  public int mNonce;
  public int mPriority;
  public String mSql;
  public long mStartTime;
  public Thread mThread;
  public boolean mWantPrimaryConnection;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteConnectionPool.ConnectionWaiter
 * JD-Core Version:    0.7.0.1
 */