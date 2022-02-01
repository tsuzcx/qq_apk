package com.tencent.wcdb.database;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import java.util.HashSet;

public class SQLiteAsyncCheckpointer
  implements Handler.Callback, SQLiteCheckpointListener
{
  private static final int DEFAULT_BLOCKING_THRESHOLD = 300;
  private static final int DEFAULT_THRESHOLD = 100;
  private static HandlerThread gDefaultThread;
  private static final Object gDefaultThreadLock = new Object();
  private static int gDefaultThreadRefCount = 0;
  private int mBlockingThreshold;
  private Handler mHandler;
  private int mLastSyncMode;
  private Looper mLooper;
  private final HashSet<Pair<SQLiteDatabase, String>> mPendingCheckpoints;
  private int mThreshold;
  private boolean mUseDefaultLooper;
  
  public SQLiteAsyncCheckpointer()
  {
    this(null, 100, 300);
  }
  
  public SQLiteAsyncCheckpointer(Looper paramLooper)
  {
    this(paramLooper, 100, 300);
  }
  
  public SQLiteAsyncCheckpointer(Looper paramLooper, int paramInt1, int paramInt2)
  {
    this.mLooper = paramLooper;
    this.mThreshold = paramInt1;
    this.mBlockingThreshold = paramInt2;
    this.mPendingCheckpoints = new HashSet();
  }
  
  private static Looper acquireDefaultLooper()
  {
    synchronized (gDefaultThreadLock)
    {
      int i = gDefaultThreadRefCount;
      gDefaultThreadRefCount = i + 1;
      if (i == 0) {
        if (gDefaultThread == null)
        {
          gDefaultThread = new HandlerThread("WCDB.AsyncCheckpointer", 4);
          gDefaultThread.start();
        }
        else
        {
          throw new AssertionError("gDefaultThread == null");
        }
      }
      Looper localLooper = gDefaultThread.getLooper();
      return localLooper;
    }
  }
  
  private static void releaseDefaultLooper()
  {
    synchronized (gDefaultThreadLock)
    {
      int i = gDefaultThreadRefCount - 1;
      gDefaultThreadRefCount = i;
      if (i <= 0) {
        if (gDefaultThreadRefCount >= 0)
        {
          gDefaultThread.quit();
          gDefaultThread = null;
        }
        else
        {
          throw new AssertionError("gDefaultThreadRefCount == 0");
        }
      }
      return;
    }
  }
  
  /* Error */
  public boolean handleMessage(android.os.Message arg1)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 93	android/os/Message:obj	Ljava/lang/Object;
    //   4: checkcast 95	android/util/Pair
    //   7: astore 5
    //   9: aload 5
    //   11: getfield 98	android/util/Pair:first	Ljava/lang/Object;
    //   14: checkcast 100	com/tencent/wcdb/database/SQLiteDatabase
    //   17: astore 6
    //   19: aload 5
    //   21: getfield 103	android/util/Pair:second	Ljava/lang/Object;
    //   24: checkcast 105	java/lang/String
    //   27: astore 7
    //   29: aload_1
    //   30: getfield 108	android/os/Message:arg1	I
    //   33: ifeq +8 -> 41
    //   36: iconst_1
    //   37: istore_2
    //   38: goto +5 -> 43
    //   41: iconst_0
    //   42: istore_2
    //   43: invokestatic 114	android/os/SystemClock:uptimeMillis	()J
    //   46: lstore_3
    //   47: aload 6
    //   49: aload 7
    //   51: iload_2
    //   52: invokevirtual 118	com/tencent/wcdb/database/SQLiteDatabase:walCheckpoint	(Ljava/lang/String;Z)Landroid/util/Pair;
    //   55: astore_1
    //   56: aload_0
    //   57: aload 6
    //   59: aload_1
    //   60: getfield 98	android/util/Pair:first	Ljava/lang/Object;
    //   63: checkcast 120	java/lang/Integer
    //   66: invokevirtual 124	java/lang/Integer:intValue	()I
    //   69: aload_1
    //   70: getfield 103	android/util/Pair:second	Ljava/lang/Object;
    //   73: checkcast 120	java/lang/Integer
    //   76: invokevirtual 124	java/lang/Integer:intValue	()I
    //   79: invokestatic 114	android/os/SystemClock:uptimeMillis	()J
    //   82: lload_3
    //   83: lsub
    //   84: invokevirtual 128	com/tencent/wcdb/database/SQLiteAsyncCheckpointer:onCheckpointResult	(Lcom/tencent/wcdb/database/SQLiteDatabase;IIJ)V
    //   87: aload 6
    //   89: invokevirtual 131	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   92: aload_0
    //   93: getfield 55	com/tencent/wcdb/database/SQLiteAsyncCheckpointer:mPendingCheckpoints	Ljava/util/HashSet;
    //   96: astore_1
    //   97: aload_1
    //   98: monitorenter
    //   99: aload_0
    //   100: getfield 55	com/tencent/wcdb/database/SQLiteAsyncCheckpointer:mPendingCheckpoints	Ljava/util/HashSet;
    //   103: aload 5
    //   105: invokevirtual 135	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   108: ifeq +7 -> 115
    //   111: aload_1
    //   112: monitorexit
    //   113: iconst_1
    //   114: ireturn
    //   115: new 71	java/lang/AssertionError
    //   118: dup
    //   119: ldc 137
    //   121: invokespecial 76	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   124: athrow
    //   125: astore 5
    //   127: aload_1
    //   128: monitorexit
    //   129: aload 5
    //   131: athrow
    //   132: astore_1
    //   133: aload 6
    //   135: invokevirtual 131	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   138: aload_1
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	SQLiteAsyncCheckpointer
    //   37	15	2	bool	boolean
    //   46	37	3	l	long
    //   7	97	5	localPair	Pair
    //   125	5	5	localObject	Object
    //   17	117	6	localSQLiteDatabase	SQLiteDatabase
    //   27	23	7	str	String
    // Exception table:
    //   from	to	target	type
    //   99	113	125	finally
    //   115	125	125	finally
    //   127	129	125	finally
    //   43	87	132	finally
  }
  
  public void onAttach(SQLiteDatabase paramSQLiteDatabase)
  {
    if (this.mLooper == null)
    {
      this.mLooper = acquireDefaultLooper();
      this.mUseDefaultLooper = true;
    }
    this.mHandler = new Handler(this.mLooper, this);
    this.mLastSyncMode = paramSQLiteDatabase.getSynchronousMode();
    paramSQLiteDatabase.setSynchronousMode(1);
  }
  
  protected void onCheckpointResult(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2, long paramLong) {}
  
  public void onDetach(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.setSynchronousMode(this.mLastSyncMode);
    this.mHandler = null;
    if (this.mUseDefaultLooper)
    {
      this.mLooper = null;
      releaseDefaultLooper();
      this.mUseDefaultLooper = false;
    }
  }
  
  public void onWALCommit(SQLiteDatabase paramSQLiteDatabase, String arg2, int paramInt)
  {
    if (paramInt < this.mThreshold) {
      return;
    }
    if (paramInt >= this.mBlockingThreshold) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    Pair localPair = new Pair(paramSQLiteDatabase, ???);
    synchronized (this.mPendingCheckpoints)
    {
      boolean bool = this.mPendingCheckpoints.add(localPair);
      if (!bool) {
        return;
      }
      paramSQLiteDatabase.acquireReference();
      paramSQLiteDatabase = this.mHandler.obtainMessage(0, paramInt, 0, localPair);
      this.mHandler.sendMessage(paramSQLiteDatabase);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteAsyncCheckpointer
 * JD-Core Version:    0.7.0.1
 */