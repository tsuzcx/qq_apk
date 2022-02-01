package com.tencent.mobileqq.persistence;

import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.ThreadTraceHelper;
import com.tencent.util.VersionUtils;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EntityTransaction
{
  private static final Lock lock = new ReentrantLock();
  private SQLiteDatabase db;
  private final SQLiteOpenHelper dbHelper;
  
  EntityTransaction(SQLiteOpenHelper paramSQLiteOpenHelper)
  {
    this.dbHelper = paramSQLiteOpenHelper;
  }
  
  public void begin()
  {
    Thread localThread = Thread.currentThread();
    IMCoreProxyRoute.ThreadTraceHelper.addWaitingTransThread(localThread.getId(), localThread.getName());
    lock.lock();
    this.db = this.dbHelper.getWritableDatabase();
    if ((SQLiteOpenHelper.WAL_ENABLE) && (VersionUtils.isHoneycomb())) {
      this.db.beginTransactionNonExclusive();
    }
    for (;;)
    {
      IMCoreProxyRoute.ThreadTraceHelper.removeWaitingTransThread(localThread.getId());
      IMCoreProxyRoute.ThreadTraceHelper.setCurrentTransThread(localThread.getId(), localThread.getName());
      return;
      this.db.beginTransaction();
    }
  }
  
  public void commit()
  {
    this.db.setTransactionSuccessful();
  }
  
  /* Error */
  public void end()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 57	com/tencent/mobileqq/persistence/EntityTransaction:db	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   4: invokevirtual 92	com/tencent/mobileqq/app/SQLiteDatabase:endTransaction	()V
    //   7: aload_0
    //   8: aconst_null
    //   9: putfield 57	com/tencent/mobileqq/persistence/EntityTransaction:db	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   12: getstatic 19	com/tencent/mobileqq/persistence/EntityTransaction:lock	Ljava/util/concurrent/locks/Lock;
    //   15: checkcast 14	java/util/concurrent/locks/ReentrantLock
    //   18: invokevirtual 95	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   21: ifeq +18 -> 39
    //   24: ldc2_w 96
    //   27: aconst_null
    //   28: invokestatic 79	com/tencent/mobileqq/imcore/proxy/IMCoreProxyRoute$ThreadTraceHelper:setCurrentTransThread	(JLjava/lang/String;)V
    //   31: getstatic 19	com/tencent/mobileqq/persistence/EntityTransaction:lock	Ljava/util/concurrent/locks/Lock;
    //   34: invokeinterface 100 1 0
    //   39: return
    //   40: astore_1
    //   41: getstatic 19	com/tencent/mobileqq/persistence/EntityTransaction:lock	Ljava/util/concurrent/locks/Lock;
    //   44: checkcast 14	java/util/concurrent/locks/ReentrantLock
    //   47: invokevirtual 95	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   50: ifeq -11 -> 39
    //   53: ldc2_w 96
    //   56: aconst_null
    //   57: invokestatic 79	com/tencent/mobileqq/imcore/proxy/IMCoreProxyRoute$ThreadTraceHelper:setCurrentTransThread	(JLjava/lang/String;)V
    //   60: getstatic 19	com/tencent/mobileqq/persistence/EntityTransaction:lock	Ljava/util/concurrent/locks/Lock;
    //   63: invokeinterface 100 1 0
    //   68: return
    //   69: astore_1
    //   70: getstatic 19	com/tencent/mobileqq/persistence/EntityTransaction:lock	Ljava/util/concurrent/locks/Lock;
    //   73: checkcast 14	java/util/concurrent/locks/ReentrantLock
    //   76: invokevirtual 95	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   79: ifeq +18 -> 97
    //   82: ldc2_w 96
    //   85: aconst_null
    //   86: invokestatic 79	com/tencent/mobileqq/imcore/proxy/IMCoreProxyRoute$ThreadTraceHelper:setCurrentTransThread	(JLjava/lang/String;)V
    //   89: getstatic 19	com/tencent/mobileqq/persistence/EntityTransaction:lock	Ljava/util/concurrent/locks/Lock;
    //   92: invokeinterface 100 1 0
    //   97: aload_1
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	EntityTransaction
    //   40	1	1	localException	java.lang.Exception
    //   69	29	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	12	40	java/lang/Exception
    //   0	12	69	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.EntityTransaction
 * JD-Core Version:    0.7.0.1
 */