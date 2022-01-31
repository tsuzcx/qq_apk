package com.tencent.wcdb.database;

import android.os.SystemClock;
import android.util.Printer;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import com.tencent.wcdb.support.OperationCanceledException;
import com.tencent.wcdb.support.PrefixPrinter;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

public final class SQLiteConnectionPool
  implements Closeable
{
  public static final int CONNECTION_FLAG_INTERACTIVE = 4;
  public static final int CONNECTION_FLAG_PRIMARY_CONNECTION_AFFINITY = 2;
  public static final int CONNECTION_FLAG_READ_ONLY = 1;
  private static final long CONNECTION_POOL_BUSY_MILLIS = 3000L;
  private static final int OPEN_FLAG_REOPEN_MASK = 268435473;
  private static final String TAG = "WCDB.SQLiteConnectionPool";
  private final WeakHashMap mAcquiredConnections = new WeakHashMap();
  private final ArrayList mAvailableNonPrimaryConnections = new ArrayList();
  private SQLiteConnection mAvailablePrimaryConnection;
  private volatile SQLiteChangeListener mChangeListener;
  private volatile SQLiteCheckpointListener mCheckpointListener;
  private SQLiteCipherSpec mCipher;
  private final SQLiteDatabaseConfiguration mConfiguration;
  private final AtomicBoolean mConnectionLeaked = new AtomicBoolean();
  private SQLiteConnectionPool.ConnectionWaiter mConnectionWaiterPool;
  private SQLiteConnectionPool.ConnectionWaiter mConnectionWaiterQueue;
  private final WeakReference mDB;
  private boolean mIsOpen;
  private final Object mLock = new Object();
  private int mMaxConnectionPoolSize;
  private int mNextConnectionId;
  private byte[] mPassword;
  private volatile SQLiteTrace mTraceCallback;
  
  static
  {
    if (!SQLiteConnectionPool.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private SQLiteConnectionPool(SQLiteDatabase paramSQLiteDatabase, SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration, int paramInt)
  {
    this.mDB = new WeakReference(paramSQLiteDatabase);
    this.mConfiguration = new SQLiteDatabaseConfiguration(paramSQLiteDatabaseConfiguration);
    setMaxConnectionPoolSizeLocked(paramInt);
  }
  
  private void cancelConnectionWaiterLocked(SQLiteConnectionPool.ConnectionWaiter paramConnectionWaiter)
  {
    if ((paramConnectionWaiter.mAssignedConnection != null) || (paramConnectionWaiter.mException != null)) {
      return;
    }
    Object localObject2 = null;
    SQLiteConnectionPool.ConnectionWaiter localConnectionWaiter;
    for (Object localObject1 = this.mConnectionWaiterQueue; localObject1 != paramConnectionWaiter; localObject1 = localConnectionWaiter)
    {
      assert (localObject1 != null);
      localConnectionWaiter = ((SQLiteConnectionPool.ConnectionWaiter)localObject1).mNext;
      localObject2 = localObject1;
    }
    if (localObject2 != null) {
      localObject2.mNext = paramConnectionWaiter.mNext;
    }
    for (;;)
    {
      paramConnectionWaiter.mException = new OperationCanceledException();
      LockSupport.unpark(paramConnectionWaiter.mThread);
      wakeConnectionWaitersLocked();
      return;
      this.mConnectionWaiterQueue = paramConnectionWaiter.mNext;
    }
  }
  
  private void closeAvailableConnectionsAndLogExceptionsLocked()
  {
    closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked();
    if (this.mAvailablePrimaryConnection != null)
    {
      closeConnectionAndLogExceptionsLocked(this.mAvailablePrimaryConnection);
      this.mAvailablePrimaryConnection = null;
    }
  }
  
  private void closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked()
  {
    int j = this.mAvailableNonPrimaryConnections.size();
    int i = 0;
    while (i < j)
    {
      closeConnectionAndLogExceptionsLocked((SQLiteConnection)this.mAvailableNonPrimaryConnections.get(i));
      i += 1;
    }
    this.mAvailableNonPrimaryConnections.clear();
  }
  
  private void closeConnectionAndLogExceptionsLocked(SQLiteConnection paramSQLiteConnection)
  {
    try
    {
      paramSQLiteConnection.close();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.e("WCDB.SQLiteConnectionPool", "Failed to close connection, its fate is now in the hands of the merciful GC: " + paramSQLiteConnection + localRuntimeException.getMessage());
    }
  }
  
  private void closeExcessConnectionsAndLogExceptionsLocked()
  {
    int j;
    for (int i = this.mAvailableNonPrimaryConnections.size();; i = j)
    {
      j = i - 1;
      if (i <= this.mMaxConnectionPoolSize - 1) {
        break;
      }
      closeConnectionAndLogExceptionsLocked((SQLiteConnection)this.mAvailableNonPrimaryConnections.remove(j));
    }
  }
  
  private void discardAcquiredConnectionsLocked()
  {
    markAcquiredConnectionsLocked(SQLiteConnectionPool.AcquiredConnectionStatus.DISCARD);
  }
  
  private void dispose(boolean paramBoolean)
  {
    if (!paramBoolean) {
      synchronized (this.mLock)
      {
        throwIfClosedLocked();
        this.mIsOpen = false;
        closeAvailableConnectionsAndLogExceptionsLocked();
        int i = this.mAcquiredConnections.size();
        if (i != 0) {
          Log.i("WCDB.SQLiteConnectionPool", "The connection pool for " + this.mConfiguration.label + " has been closed but there are still " + i + " connections in use.  They will be closed as they are released back to the pool.");
        }
        wakeConnectionWaitersLocked();
        return;
      }
    }
  }
  
  private void finishAcquireConnectionLocked(SQLiteConnection paramSQLiteConnection, int paramInt)
  {
    if ((paramInt & 0x1) != 0) {}
    for (boolean bool = true;; bool = false) {
      try
      {
        paramSQLiteConnection.setOnlyAllowReadOnlyOperations(bool);
        this.mAcquiredConnections.put(paramSQLiteConnection, SQLiteConnectionPool.AcquiredConnectionStatus.NORMAL);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        Log.e("WCDB.SQLiteConnectionPool", "Failed to prepare acquired connection for session, closing it: " + paramSQLiteConnection + ", connectionFlags=" + paramInt);
        closeConnectionAndLogExceptionsLocked(paramSQLiteConnection);
        throw localRuntimeException;
      }
    }
  }
  
  private static int getPriority(int paramInt)
  {
    if ((paramInt & 0x4) != 0) {
      return 1;
    }
    return 0;
  }
  
  private boolean isSessionBlockingImportantConnectionWaitersLocked(boolean paramBoolean, int paramInt)
  {
    Object localObject = this.mConnectionWaiterQueue;
    if (localObject != null)
    {
      paramInt = getPriority(paramInt);
      if (paramInt <= ((SQLiteConnectionPool.ConnectionWaiter)localObject).mPriority) {
        break label24;
      }
    }
    for (;;)
    {
      return false;
      label24:
      if ((paramBoolean) || (!((SQLiteConnectionPool.ConnectionWaiter)localObject).mWantPrimaryConnection)) {
        return true;
      }
      SQLiteConnectionPool.ConnectionWaiter localConnectionWaiter = ((SQLiteConnectionPool.ConnectionWaiter)localObject).mNext;
      localObject = localConnectionWaiter;
      if (localConnectionWaiter != null) {
        break;
      }
    }
  }
  
  private void logConnectionPoolBusyLocked(String paramString, long paramLong, int paramInt)
  {
    Object localObject2 = new StringBuilder();
    if (paramLong != 0L)
    {
      localObject1 = Thread.currentThread();
      ((StringBuilder)localObject2).append("The connection pool for database '").append(this.mConfiguration.label);
      ((StringBuilder)localObject2).append("' has been unable to grant a connection to thread ");
      ((StringBuilder)localObject2).append(((Thread)localObject1).getId()).append(" (").append(((Thread)localObject1).getName()).append(") ");
      ((StringBuilder)localObject2).append("with flags 0x").append(Integer.toHexString(paramInt));
      ((StringBuilder)localObject2).append(" for ").append((float)paramLong * 0.001F).append(" seconds.\n");
    }
    Object localObject1 = new ArrayList();
    int k;
    int j;
    String str;
    if (!this.mAcquiredConnections.isEmpty())
    {
      localObject3 = this.mAcquiredConnections.keySet().iterator();
      i = 0;
      paramInt = 0;
      k = i;
      j = paramInt;
      if (((Iterator)localObject3).hasNext())
      {
        str = ((SQLiteConnection)((Iterator)localObject3).next()).describeCurrentOperationUnsafe();
        if (str != null)
        {
          ((ArrayList)localObject1).add(str);
          j = i;
          i = paramInt + 1;
        }
        for (paramInt = j;; paramInt = j)
        {
          j = i;
          i = paramInt;
          paramInt = j;
          break;
          j = i + 1;
          i = paramInt;
        }
      }
    }
    else
    {
      k = 0;
      j = 0;
    }
    int i = this.mAvailableNonPrimaryConnections.size();
    paramInt = i;
    if (this.mAvailablePrimaryConnection != null) {
      paramInt = i + 1;
    }
    ((StringBuilder)localObject2).append("Connections: ").append(j).append(" active, ");
    ((StringBuilder)localObject2).append(k).append(" idle, ");
    ((StringBuilder)localObject2).append(paramInt).append(" available.\n");
    if (!((ArrayList)localObject1).isEmpty())
    {
      ((StringBuilder)localObject2).append("\nRequests in progress:\n");
      localObject3 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        str = (String)((Iterator)localObject3).next();
        ((StringBuilder)localObject2).append("  ").append(str).append("\n");
      }
    }
    localObject2 = ((StringBuilder)localObject2).toString();
    Log.w("WCDB.SQLiteConnectionPool", (String)localObject2);
    Object localObject3 = (SQLiteDatabase)this.mDB.get();
    if ((localObject3 != null) && (this.mTraceCallback != null)) {
      this.mTraceCallback.onConnectionPoolBusy((SQLiteDatabase)localObject3, paramString, (List)localObject1, (String)localObject2);
    }
  }
  
  private void markAcquiredConnectionsLocked(SQLiteConnectionPool.AcquiredConnectionStatus paramAcquiredConnectionStatus)
  {
    if (!this.mAcquiredConnections.isEmpty())
    {
      ArrayList localArrayList = new ArrayList(this.mAcquiredConnections.size());
      Iterator localIterator = this.mAcquiredConnections.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        SQLiteConnectionPool.AcquiredConnectionStatus localAcquiredConnectionStatus = (SQLiteConnectionPool.AcquiredConnectionStatus)localEntry.getValue();
        if ((paramAcquiredConnectionStatus != localAcquiredConnectionStatus) && (localAcquiredConnectionStatus != SQLiteConnectionPool.AcquiredConnectionStatus.DISCARD)) {
          localArrayList.add(localEntry.getKey());
        }
      }
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        this.mAcquiredConnections.put(localArrayList.get(i), paramAcquiredConnectionStatus);
        i += 1;
      }
    }
  }
  
  private SQLiteConnectionPool.ConnectionWaiter obtainConnectionWaiterLocked(Thread paramThread, long paramLong, int paramInt1, boolean paramBoolean, String paramString, int paramInt2)
  {
    SQLiteConnectionPool.ConnectionWaiter localConnectionWaiter = this.mConnectionWaiterPool;
    if (localConnectionWaiter != null)
    {
      this.mConnectionWaiterPool = localConnectionWaiter.mNext;
      localConnectionWaiter.mNext = null;
    }
    for (;;)
    {
      localConnectionWaiter.mThread = paramThread;
      localConnectionWaiter.mStartTime = paramLong;
      localConnectionWaiter.mPriority = paramInt1;
      localConnectionWaiter.mWantPrimaryConnection = paramBoolean;
      localConnectionWaiter.mSql = paramString;
      localConnectionWaiter.mConnectionFlags = paramInt2;
      return localConnectionWaiter;
      localConnectionWaiter = new SQLiteConnectionPool.ConnectionWaiter(null);
    }
  }
  
  public static SQLiteConnectionPool open(SQLiteDatabase paramSQLiteDatabase, SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec)
  {
    return open(paramSQLiteDatabase, paramSQLiteDatabaseConfiguration, paramArrayOfByte, paramSQLiteCipherSpec, 1);
  }
  
  public static SQLiteConnectionPool open(SQLiteDatabase paramSQLiteDatabase, SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, int paramInt)
  {
    if (paramSQLiteDatabaseConfiguration == null) {
      throw new IllegalArgumentException("configuration must not be null.");
    }
    paramSQLiteDatabaseConfiguration = new SQLiteConnectionPool(paramSQLiteDatabase, paramSQLiteDatabaseConfiguration, paramInt);
    paramSQLiteDatabaseConfiguration.mPassword = paramArrayOfByte;
    if (paramSQLiteCipherSpec == null) {}
    for (paramSQLiteDatabase = null;; paramSQLiteDatabase = new SQLiteCipherSpec(paramSQLiteCipherSpec))
    {
      paramSQLiteDatabaseConfiguration.mCipher = paramSQLiteDatabase;
      paramSQLiteDatabaseConfiguration.open();
      return paramSQLiteDatabaseConfiguration;
    }
  }
  
  private void open()
  {
    this.mAvailablePrimaryConnection = openConnectionLocked(this.mConfiguration, true);
    this.mIsOpen = true;
  }
  
  private SQLiteConnection openConnectionLocked(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration, boolean paramBoolean)
  {
    int i = this.mNextConnectionId;
    this.mNextConnectionId = (i + 1);
    return SQLiteConnection.open(this, paramSQLiteDatabaseConfiguration, i, paramBoolean, this.mPassword, this.mCipher);
  }
  
  private void reconfigureAllConnectionsLocked()
  {
    if (this.mAvailablePrimaryConnection != null) {}
    try
    {
      this.mAvailablePrimaryConnection.reconfigure(this.mConfiguration);
      i = this.mAvailableNonPrimaryConnections.size();
      j = 0;
      if (j < i) {
        localSQLiteConnection = (SQLiteConnection)this.mAvailableNonPrimaryConnections.get(j);
      }
    }
    catch (RuntimeException localRuntimeException1)
    {
      try
      {
        for (;;)
        {
          SQLiteConnection localSQLiteConnection;
          localSQLiteConnection.reconfigure(this.mConfiguration);
          j += 1;
        }
        localRuntimeException1 = localRuntimeException1;
        Log.e("WCDB.SQLiteConnectionPool", "Failed to reconfigure available primary connection, closing it: " + this.mAvailablePrimaryConnection, new Object[] { localRuntimeException1 });
        closeConnectionAndLogExceptionsLocked(this.mAvailablePrimaryConnection);
        this.mAvailablePrimaryConnection = null;
      }
      catch (RuntimeException localRuntimeException2)
      {
        for (;;)
        {
          int i;
          Log.e("WCDB.SQLiteConnectionPool", "Failed to reconfigure available non-primary connection, closing it: " + localRuntimeException1, new Object[] { localRuntimeException2 });
          closeConnectionAndLogExceptionsLocked(localRuntimeException1);
          ArrayList localArrayList = this.mAvailableNonPrimaryConnections;
          int k = j - 1;
          localArrayList.remove(j);
          i -= 1;
          int j = k;
        }
      }
      markAcquiredConnectionsLocked(SQLiteConnectionPool.AcquiredConnectionStatus.RECONFIGURE);
    }
  }
  
  private boolean recycleConnectionLocked(SQLiteConnection paramSQLiteConnection, SQLiteConnectionPool.AcquiredConnectionStatus paramAcquiredConnectionStatus)
  {
    SQLiteConnectionPool.AcquiredConnectionStatus localAcquiredConnectionStatus = paramAcquiredConnectionStatus;
    if (paramAcquiredConnectionStatus == SQLiteConnectionPool.AcquiredConnectionStatus.RECONFIGURE) {}
    try
    {
      paramSQLiteConnection.reconfigure(this.mConfiguration);
      localAcquiredConnectionStatus = paramAcquiredConnectionStatus;
    }
    catch (RuntimeException paramAcquiredConnectionStatus)
    {
      for (;;)
      {
        Log.e("WCDB.SQLiteConnectionPool", "Failed to reconfigure released connection, closing it: " + paramSQLiteConnection, new Object[] { paramAcquiredConnectionStatus });
        localAcquiredConnectionStatus = SQLiteConnectionPool.AcquiredConnectionStatus.DISCARD;
      }
    }
    if (localAcquiredConnectionStatus == SQLiteConnectionPool.AcquiredConnectionStatus.DISCARD)
    {
      closeConnectionAndLogExceptionsLocked(paramSQLiteConnection);
      return false;
    }
    return true;
  }
  
  private void recycleConnectionWaiterLocked(SQLiteConnectionPool.ConnectionWaiter paramConnectionWaiter)
  {
    paramConnectionWaiter.mNext = this.mConnectionWaiterPool;
    paramConnectionWaiter.mThread = null;
    paramConnectionWaiter.mSql = null;
    paramConnectionWaiter.mAssignedConnection = null;
    paramConnectionWaiter.mException = null;
    paramConnectionWaiter.mNonce += 1;
    this.mConnectionWaiterPool = paramConnectionWaiter;
  }
  
  private void setMaxConnectionPoolSizeLocked(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      if ((this.mConfiguration.openFlags & 0x20000000) == 0) {
        break label50;
      }
    }
    label50:
    for (i = 4;; i = 1)
    {
      this.mMaxConnectionPoolSize = i;
      Log.i("WCDB.SQLiteConnectionPool", "Max connection pool size is %d.", new Object[] { Integer.valueOf(this.mMaxConnectionPoolSize) });
      return;
    }
  }
  
  private void throwIfClosedLocked()
  {
    if (!this.mIsOpen) {
      throw new IllegalStateException("Cannot perform this operation because the connection pool has been closed.");
    }
  }
  
  private SQLiteConnection tryAcquireNonPrimaryConnectionLocked(String paramString, int paramInt)
  {
    int j = this.mAvailableNonPrimaryConnections.size();
    if ((j > 1) && (paramString != null))
    {
      i = 0;
      while (i < j)
      {
        SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.mAvailableNonPrimaryConnections.get(i);
        if (localSQLiteConnection.isPreparedStatementInCache(paramString))
        {
          this.mAvailableNonPrimaryConnections.remove(i);
          finishAcquireConnectionLocked(localSQLiteConnection, paramInt);
          return localSQLiteConnection;
        }
        i += 1;
      }
    }
    if (j > 0)
    {
      paramString = (SQLiteConnection)this.mAvailableNonPrimaryConnections.remove(j - 1);
      finishAcquireConnectionLocked(paramString, paramInt);
      return paramString;
    }
    j = this.mAcquiredConnections.size();
    int i = j;
    if (this.mAvailablePrimaryConnection != null) {
      i = j + 1;
    }
    if (i >= this.mMaxConnectionPoolSize) {
      return null;
    }
    paramString = openConnectionLocked(this.mConfiguration, false);
    finishAcquireConnectionLocked(paramString, paramInt);
    return paramString;
  }
  
  private SQLiteConnection tryAcquirePrimaryConnectionLocked(int paramInt)
  {
    Object localObject = this.mAvailablePrimaryConnection;
    if (localObject != null)
    {
      this.mAvailablePrimaryConnection = null;
      finishAcquireConnectionLocked((SQLiteConnection)localObject, paramInt);
      return localObject;
    }
    localObject = this.mAcquiredConnections.keySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((SQLiteConnection)((Iterator)localObject).next()).isPrimaryConnection()) {
        return null;
      }
    }
    localObject = openConnectionLocked(this.mConfiguration, true);
    finishAcquireConnectionLocked((SQLiteConnection)localObject, paramInt);
    return localObject;
  }
  
  /* Error */
  private SQLiteConnection waitForConnection(String paramString, int paramInt, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: iload_2
    //   1: iconst_2
    //   2: iand
    //   3: ifeq +414 -> 417
    //   6: iconst_1
    //   7: istore 5
    //   9: aload_0
    //   10: getfield 72	com/tencent/wcdb/database/SQLiteConnectionPool:mLock	Ljava/lang/Object;
    //   13: astore 15
    //   15: aload 15
    //   17: monitorenter
    //   18: aload_0
    //   19: invokespecial 221	com/tencent/wcdb/database/SQLiteConnectionPool:throwIfClosedLocked	()V
    //   22: aload_3
    //   23: ifnull +7 -> 30
    //   26: aload_3
    //   27: invokevirtual 495	com/tencent/wcdb/support/CancellationSignal:throwIfCanceled	()V
    //   30: aconst_null
    //   31: astore 12
    //   33: iload 5
    //   35: ifne +11 -> 46
    //   38: aload_0
    //   39: aload_1
    //   40: iload_2
    //   41: invokespecial 497	com/tencent/wcdb/database/SQLiteConnectionPool:tryAcquireNonPrimaryConnectionLocked	(Ljava/lang/String;I)Lcom/tencent/wcdb/database/SQLiteConnection;
    //   44: astore 12
    //   46: aload 12
    //   48: astore 13
    //   50: aload 12
    //   52: ifnonnull +10 -> 62
    //   55: aload_0
    //   56: iload_2
    //   57: invokespecial 499	com/tencent/wcdb/database/SQLiteConnectionPool:tryAcquirePrimaryConnectionLocked	(I)Lcom/tencent/wcdb/database/SQLiteConnection;
    //   60: astore 13
    //   62: aload 13
    //   64: ifnull +9 -> 73
    //   67: aload 15
    //   69: monitorexit
    //   70: aload 13
    //   72: areturn
    //   73: iload_2
    //   74: invokestatic 263	com/tencent/wcdb/database/SQLiteConnectionPool:getPriority	(I)I
    //   77: istore 4
    //   79: invokestatic 504	android/os/SystemClock:uptimeMillis	()J
    //   82: lstore 6
    //   84: aload_0
    //   85: invokestatic 277	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   88: lload 6
    //   90: iload 4
    //   92: iload 5
    //   94: aload_1
    //   95: iload_2
    //   96: invokespecial 506	com/tencent/wcdb/database/SQLiteConnectionPool:obtainConnectionWaiterLocked	(Ljava/lang/Thread;JIZLjava/lang/String;I)Lcom/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter;
    //   99: astore 16
    //   101: aconst_null
    //   102: astore 13
    //   104: aload_0
    //   105: getfield 124	com/tencent/wcdb/database/SQLiteConnectionPool:mConnectionWaiterQueue	Lcom/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter;
    //   108: astore 12
    //   110: aload 12
    //   112: ifnull +20 -> 132
    //   115: iload 4
    //   117: aload 12
    //   119: getfield 266	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter:mPriority	I
    //   122: if_icmple +176 -> 298
    //   125: aload 16
    //   127: aload 12
    //   129: putfield 130	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter:mNext	Lcom/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter;
    //   132: aload 13
    //   134: ifnull +182 -> 316
    //   137: aload 13
    //   139: aload 16
    //   141: putfield 130	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter:mNext	Lcom/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter;
    //   144: aload 16
    //   146: getfield 458	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter:mNonce	I
    //   149: istore 4
    //   151: aload 15
    //   153: monitorexit
    //   154: aload_3
    //   155: ifnull +19 -> 174
    //   158: aload_3
    //   159: new 508	com/tencent/wcdb/database/SQLiteConnectionPool$1
    //   162: dup
    //   163: aload_0
    //   164: aload 16
    //   166: iload 4
    //   168: invokespecial 511	com/tencent/wcdb/database/SQLiteConnectionPool$1:<init>	(Lcom/tencent/wcdb/database/SQLiteConnectionPool;Lcom/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter;I)V
    //   171: invokevirtual 515	com/tencent/wcdb/support/CancellationSignal:setOnCancelListener	(Lcom/tencent/wcdb/support/CancellationSignal$OnCancelListener;)V
    //   174: aload 16
    //   176: getfield 393	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter:mStartTime	J
    //   179: lstore 6
    //   181: ldc2_w 18
    //   184: lstore 8
    //   186: lload 6
    //   188: ldc2_w 18
    //   191: ladd
    //   192: lstore 6
    //   194: aload_0
    //   195: getfield 77	com/tencent/wcdb/database/SQLiteConnectionPool:mConnectionLeaked	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   198: iconst_1
    //   199: iconst_0
    //   200: invokevirtual 519	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   203: ifeq +19 -> 222
    //   206: aload_0
    //   207: getfield 72	com/tencent/wcdb/database/SQLiteConnectionPool:mLock	Ljava/lang/Object;
    //   210: astore 12
    //   212: aload 12
    //   214: monitorenter
    //   215: aload_0
    //   216: invokespecial 146	com/tencent/wcdb/database/SQLiteConnectionPool:wakeConnectionWaitersLocked	()V
    //   219: aload 12
    //   221: monitorexit
    //   222: lload 8
    //   224: ldc2_w 520
    //   227: lmul
    //   228: invokestatic 525	java/util/concurrent/locks/LockSupport:parkNanos	(J)V
    //   231: invokestatic 528	java/lang/Thread:interrupted	()Z
    //   234: pop
    //   235: aload_0
    //   236: getfield 72	com/tencent/wcdb/database/SQLiteConnectionPool:mLock	Ljava/lang/Object;
    //   239: astore 12
    //   241: aload 12
    //   243: monitorenter
    //   244: aload_0
    //   245: invokespecial 221	com/tencent/wcdb/database/SQLiteConnectionPool:throwIfClosedLocked	()V
    //   248: aload 16
    //   250: getfield 118	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter:mAssignedConnection	Lcom/tencent/wcdb/database/SQLiteConnection;
    //   253: astore 13
    //   255: aload 16
    //   257: getfield 122	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter:mException	Ljava/lang/RuntimeException;
    //   260: astore 14
    //   262: aload 13
    //   264: ifnonnull +8 -> 272
    //   267: aload 14
    //   269: ifnull +89 -> 358
    //   272: aload_0
    //   273: aload 16
    //   275: invokespecial 530	com/tencent/wcdb/database/SQLiteConnectionPool:recycleConnectionWaiterLocked	(Lcom/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter;)V
    //   278: aload 13
    //   280: ifnull +69 -> 349
    //   283: aload 12
    //   285: monitorexit
    //   286: aload_3
    //   287: ifnull +127 -> 414
    //   290: aload_3
    //   291: aconst_null
    //   292: invokevirtual 515	com/tencent/wcdb/support/CancellationSignal:setOnCancelListener	(Lcom/tencent/wcdb/support/CancellationSignal$OnCancelListener;)V
    //   295: aload 13
    //   297: areturn
    //   298: aload 12
    //   300: getfield 130	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter:mNext	Lcom/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter;
    //   303: astore 14
    //   305: aload 12
    //   307: astore 13
    //   309: aload 14
    //   311: astore 12
    //   313: goto -203 -> 110
    //   316: aload_0
    //   317: aload 16
    //   319: putfield 124	com/tencent/wcdb/database/SQLiteConnectionPool:mConnectionWaiterQueue	Lcom/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter;
    //   322: goto -178 -> 144
    //   325: astore_1
    //   326: aload 15
    //   328: monitorexit
    //   329: aload_1
    //   330: athrow
    //   331: astore_1
    //   332: aload 12
    //   334: monitorexit
    //   335: aload_1
    //   336: athrow
    //   337: astore_1
    //   338: aload_3
    //   339: ifnull +8 -> 347
    //   342: aload_3
    //   343: aconst_null
    //   344: invokevirtual 515	com/tencent/wcdb/support/CancellationSignal:setOnCancelListener	(Lcom/tencent/wcdb/support/CancellationSignal$OnCancelListener;)V
    //   347: aload_1
    //   348: athrow
    //   349: aload 14
    //   351: athrow
    //   352: astore_1
    //   353: aload 12
    //   355: monitorexit
    //   356: aload_1
    //   357: athrow
    //   358: invokestatic 504	android/os/SystemClock:uptimeMillis	()J
    //   361: lstore 10
    //   363: lload 10
    //   365: lload 6
    //   367: lcmp
    //   368: ifge +16 -> 384
    //   371: lload 10
    //   373: lload 6
    //   375: lsub
    //   376: lstore 8
    //   378: aload 12
    //   380: monitorexit
    //   381: goto -187 -> 194
    //   384: aload_0
    //   385: aload_1
    //   386: lload 10
    //   388: aload 16
    //   390: getfield 393	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter:mStartTime	J
    //   393: lsub
    //   394: iload_2
    //   395: invokespecial 532	com/tencent/wcdb/database/SQLiteConnectionPool:logConnectionPoolBusyLocked	(Ljava/lang/String;JI)V
    //   398: ldc2_w 18
    //   401: lstore 8
    //   403: lload 10
    //   405: ldc2_w 18
    //   408: ladd
    //   409: lstore 6
    //   411: goto -33 -> 378
    //   414: aload 13
    //   416: areturn
    //   417: iconst_0
    //   418: istore 5
    //   420: goto -411 -> 9
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	423	0	this	SQLiteConnectionPool
    //   0	423	1	paramString	String
    //   0	423	2	paramInt	int
    //   0	423	3	paramCancellationSignal	CancellationSignal
    //   77	90	4	i	int
    //   7	412	5	bool	boolean
    //   82	328	6	l1	long
    //   184	218	8	l2	long
    //   361	43	10	l3	long
    //   48	367	13	localObject2	Object
    //   260	90	14	localObject3	Object
    //   13	314	15	localObject4	Object
    //   99	290	16	localConnectionWaiter	SQLiteConnectionPool.ConnectionWaiter
    // Exception table:
    //   from	to	target	type
    //   18	22	325	finally
    //   26	30	325	finally
    //   38	46	325	finally
    //   55	62	325	finally
    //   67	70	325	finally
    //   73	101	325	finally
    //   104	110	325	finally
    //   115	132	325	finally
    //   137	144	325	finally
    //   144	154	325	finally
    //   298	305	325	finally
    //   316	322	325	finally
    //   326	329	325	finally
    //   215	222	331	finally
    //   332	335	331	finally
    //   174	181	337	finally
    //   194	215	337	finally
    //   222	244	337	finally
    //   335	337	337	finally
    //   356	358	337	finally
    //   244	262	352	finally
    //   272	278	352	finally
    //   283	286	352	finally
    //   349	352	352	finally
    //   353	356	352	finally
    //   358	363	352	finally
    //   378	381	352	finally
    //   384	398	352	finally
  }
  
  private void wakeConnectionWaitersLocked()
  {
    Object localObject3 = this.mConnectionWaiterQueue;
    int i = 0;
    int j = 0;
    Object localObject4 = null;
    int m;
    int k;
    Object localObject1;
    for (;;)
    {
      if (localObject3 == null) {
        break label194;
      }
      if (this.mIsOpen) {
        break;
      }
      m = 1;
      k = j;
      j = m;
      localObject1 = ((SQLiteConnectionPool.ConnectionWaiter)localObject3).mNext;
      if (j == 0) {
        break label220;
      }
      if (localObject4 == null) {
        break label211;
      }
      localObject4.mNext = ((SQLiteConnectionPool.ConnectionWaiter)localObject1);
      label56:
      ((SQLiteConnectionPool.ConnectionWaiter)localObject3).mNext = null;
      LockSupport.unpark(((SQLiteConnectionPool.ConnectionWaiter)localObject3).mThread);
      label70:
      localObject3 = localObject1;
      j = k;
    }
    for (;;)
    {
      try
      {
        if ((((SQLiteConnectionPool.ConnectionWaiter)localObject3).mWantPrimaryConnection) || (i != 0)) {
          break label243;
        }
        localObject1 = tryAcquireNonPrimaryConnectionLocked(((SQLiteConnectionPool.ConnectionWaiter)localObject3).mSql, ((SQLiteConnectionPool.ConnectionWaiter)localObject3).mConnectionFlags);
        if (localObject1 != null) {
          break label240;
        }
        i = 1;
        localObject5 = localObject1;
        k = j;
        if (localObject1 == null)
        {
          localObject5 = localObject1;
          k = j;
          if (j == 0) {
            m = j;
          }
        }
      }
      catch (RuntimeException localRuntimeException1)
      {
        try
        {
          localObject1 = tryAcquirePrimaryConnectionLocked(((SQLiteConnectionPool.ConnectionWaiter)localObject3).mConnectionFlags);
          Object localObject5 = localObject1;
          k = j;
          if (localObject1 == null)
          {
            k = 1;
            localObject5 = localObject1;
          }
          if (localObject5 != null)
          {
            m = k;
            ((SQLiteConnectionPool.ConnectionWaiter)localObject3).mAssignedConnection = localObject5;
            j = 1;
            break;
          }
          if ((i == 0) || (k == 0)) {
            break label235;
          }
          label194:
          return;
        }
        catch (RuntimeException localRuntimeException2)
        {
          for (;;)
          {
            j = m;
          }
          j = 0;
        }
        localRuntimeException1 = localRuntimeException1;
      }
      ((SQLiteConnectionPool.ConnectionWaiter)localObject3).mException = localRuntimeException1;
      k = j;
      j = 1;
      break;
      label211:
      this.mConnectionWaiterQueue = localRuntimeException1;
      break label56;
      label220:
      localObject4 = localObject3;
      break label70;
      label235:
      break;
      label240:
      continue;
      label243:
      Object localObject2 = null;
    }
  }
  
  public SQLiteConnection acquireConnection(String paramString, int paramInt, CancellationSignal paramCancellationSignal)
  {
    long l1 = SystemClock.uptimeMillis();
    paramCancellationSignal = waitForConnection(paramString, paramInt, paramCancellationSignal);
    long l2;
    SQLiteDatabase localSQLiteDatabase;
    if (this.mTraceCallback != null)
    {
      l2 = SystemClock.uptimeMillis();
      localSQLiteDatabase = (SQLiteDatabase)this.mDB.get();
      if (localSQLiteDatabase != null) {
        if ((paramInt & 0x2) == 0) {
          break label72;
        }
      }
    }
    label72:
    for (boolean bool = true;; bool = false)
    {
      this.mTraceCallback.onConnectionObtained(localSQLiteDatabase, paramString, l2 - l1, bool);
      return paramCancellationSignal;
    }
  }
  
  public void close()
  {
    dispose(false);
  }
  
  public void collectDbStats(ArrayList paramArrayList)
  {
    synchronized (this.mLock)
    {
      if (this.mAvailablePrimaryConnection != null) {
        this.mAvailablePrimaryConnection.collectDbStats(paramArrayList);
      }
      localIterator = this.mAvailableNonPrimaryConnections.iterator();
      if (localIterator.hasNext()) {
        ((SQLiteConnection)localIterator.next()).collectDbStats(paramArrayList);
      }
    }
    Iterator localIterator = this.mAcquiredConnections.keySet().iterator();
    while (localIterator.hasNext()) {
      ((SQLiteConnection)localIterator.next()).collectDbStatsUnsafe(paramArrayList);
    }
  }
  
  public void dump(Printer paramPrinter, boolean paramBoolean)
  {
    Printer localPrinter = PrefixPrinter.create(paramPrinter, "    ");
    int i;
    synchronized (this.mLock)
    {
      paramPrinter.println("Connection pool for " + this.mConfiguration.path + ":");
      paramPrinter.println("  Open: " + this.mIsOpen);
      paramPrinter.println("  Max connections: " + this.mMaxConnectionPoolSize);
      paramPrinter.println("  Available primary connection:");
      if (this.mAvailablePrimaryConnection != null)
      {
        this.mAvailablePrimaryConnection.dump(localPrinter, paramBoolean);
        paramPrinter.println("  Available non-primary connections:");
        if (!this.mAvailableNonPrimaryConnections.isEmpty())
        {
          int j = this.mAvailableNonPrimaryConnections.size();
          i = 0;
          while (i < j)
          {
            ((SQLiteConnection)this.mAvailableNonPrimaryConnections.get(i)).dump(localPrinter, paramBoolean);
            i += 1;
          }
        }
      }
      else
      {
        localPrinter.println("<none>");
      }
    }
    localPrinter.println("<none>");
    paramPrinter.println("  Acquired connections:");
    if (!this.mAcquiredConnections.isEmpty())
    {
      Iterator localIterator = this.mAcquiredConnections.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ((SQLiteConnection)localEntry.getKey()).dumpUnsafe(localPrinter, paramBoolean);
        localPrinter.println("  Status: " + localEntry.getValue());
      }
    }
    localPrinter.println("<none>");
    paramPrinter.println("  Connection waiters:");
    if (this.mConnectionWaiterQueue != null)
    {
      long l = SystemClock.uptimeMillis();
      paramPrinter = this.mConnectionWaiterQueue;
      i = 0;
      while (paramPrinter != null)
      {
        localPrinter.println(i + ": waited for " + (l - paramPrinter.mStartTime) + " ms - thread=" + paramPrinter.mThread + ", priority=" + paramPrinter.mPriority + ", sql='" + paramPrinter.mSql + "'");
        paramPrinter = paramPrinter.mNext;
        i += 1;
      }
    }
    localPrinter.println("<none>");
  }
  
  protected void finalize()
  {
    try
    {
      dispose(true);
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  SQLiteChangeListener getChangeListener()
  {
    return this.mChangeListener;
  }
  
  SQLiteCheckpointListener getCheckpointListener()
  {
    return this.mCheckpointListener;
  }
  
  SQLiteTrace getTraceCallback()
  {
    return this.mTraceCallback;
  }
  
  public void logConnectionPoolBusy(String paramString)
  {
    synchronized (this.mLock)
    {
      logConnectionPoolBusyLocked(paramString, 0L, 0);
      return;
    }
  }
  
  void notifyChanges(String paramString1, String paramString2, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    SQLiteDatabase localSQLiteDatabase = (SQLiteDatabase)this.mDB.get();
    SQLiteChangeListener localSQLiteChangeListener = this.mChangeListener;
    if ((localSQLiteChangeListener == null) || (localSQLiteDatabase == null)) {
      return;
    }
    localSQLiteChangeListener.onChange(localSQLiteDatabase, paramString1, paramString2, paramArrayOfLong1, paramArrayOfLong2, paramArrayOfLong3);
  }
  
  void notifyCheckpoint(String paramString, int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = (SQLiteDatabase)this.mDB.get();
    SQLiteCheckpointListener localSQLiteCheckpointListener = this.mCheckpointListener;
    if ((localSQLiteCheckpointListener == null) || (localSQLiteDatabase == null)) {
      return;
    }
    localSQLiteCheckpointListener.onWALCommit(localSQLiteDatabase, paramString, paramInt);
  }
  
  void onConnectionLeaked()
  {
    Log.w("WCDB.SQLiteConnectionPool", "A SQLiteConnection object for database '" + this.mConfiguration.label + "' was leaked!  Please fix your application to end transactions in progress properly and to close the database when it is no longer needed.");
    this.mConnectionLeaked.set(true);
  }
  
  public void reconfigure(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration)
  {
    int j = 1;
    if (paramSQLiteDatabaseConfiguration == null) {
      throw new IllegalArgumentException("configuration must not be null.");
    }
    int i;
    for (;;)
    {
      synchronized (this.mLock)
      {
        throwIfClosedLocked();
        if (((paramSQLiteDatabaseConfiguration.openFlags ^ this.mConfiguration.openFlags) & 0x20000000) != 0)
        {
          i = 1;
          if (i == 0) {
            break label91;
          }
          if (this.mAcquiredConnections.isEmpty()) {
            break;
          }
          throw new IllegalStateException("Write Ahead Logging (WAL) mode cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");
        }
      }
      i = 0;
    }
    closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked();
    label91:
    if (paramSQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled != this.mConfiguration.foreignKeyConstraintsEnabled) {}
    for (;;)
    {
      if ((j != 0) && (!this.mAcquiredConnections.isEmpty())) {
        throw new IllegalStateException("Foreign Key Constraints cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");
      }
      if ((((this.mConfiguration.openFlags ^ paramSQLiteDatabaseConfiguration.openFlags) & 0x10000011) != 0) || (!DatabaseUtils.objectEquals(this.mConfiguration.vfsName, paramSQLiteDatabaseConfiguration.vfsName)))
      {
        if (i != 0) {
          closeAvailableConnectionsAndLogExceptionsLocked();
        }
        SQLiteConnection localSQLiteConnection = openConnectionLocked(paramSQLiteDatabaseConfiguration, true);
        closeAvailableConnectionsAndLogExceptionsLocked();
        discardAcquiredConnectionsLocked();
        this.mAvailablePrimaryConnection = localSQLiteConnection;
        this.mConfiguration.updateParametersFrom(paramSQLiteDatabaseConfiguration);
        setMaxConnectionPoolSizeLocked(0);
      }
      for (;;)
      {
        wakeConnectionWaitersLocked();
        return;
        this.mConfiguration.updateParametersFrom(paramSQLiteDatabaseConfiguration);
        setMaxConnectionPoolSizeLocked(0);
        closeExcessConnectionsAndLogExceptionsLocked();
        reconfigureAllConnectionsLocked();
      }
      j = 0;
    }
  }
  
  public void releaseConnection(SQLiteConnection paramSQLiteConnection)
  {
    SQLiteConnectionPool.AcquiredConnectionStatus localAcquiredConnectionStatus;
    synchronized (this.mLock)
    {
      localAcquiredConnectionStatus = (SQLiteConnectionPool.AcquiredConnectionStatus)this.mAcquiredConnections.remove(paramSQLiteConnection);
      if (localAcquiredConnectionStatus == null) {
        throw new IllegalStateException("Cannot perform this operation because the specified connection was not acquired from this pool or has already been released.");
      }
    }
    if (!this.mIsOpen) {
      closeConnectionAndLogExceptionsLocked(paramSQLiteConnection);
    }
    for (;;)
    {
      return;
      if (paramSQLiteConnection.isPrimaryConnection())
      {
        if (recycleConnectionLocked(paramSQLiteConnection, localAcquiredConnectionStatus))
        {
          assert (this.mAvailablePrimaryConnection == null);
          this.mAvailablePrimaryConnection = paramSQLiteConnection;
        }
        wakeConnectionWaitersLocked();
      }
      else if (this.mAvailableNonPrimaryConnections.size() >= this.mMaxConnectionPoolSize - 1)
      {
        closeConnectionAndLogExceptionsLocked(paramSQLiteConnection);
      }
      else
      {
        if (recycleConnectionLocked(paramSQLiteConnection, localAcquiredConnectionStatus)) {
          this.mAvailableNonPrimaryConnections.add(paramSQLiteConnection);
        }
        wakeConnectionWaitersLocked();
      }
    }
  }
  
  void setChangeListener(SQLiteChangeListener paramSQLiteChangeListener, boolean paramBoolean)
  {
    if (paramSQLiteChangeListener != null) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        paramBoolean = false;
      }
      synchronized (this.mLock)
      {
        if ((this.mConfiguration.updateNotificationEnabled != bool) || (this.mConfiguration.updateNotificationRowID != paramBoolean))
        {
          this.mConfiguration.updateNotificationEnabled = bool;
          this.mConfiguration.updateNotificationRowID = paramBoolean;
          closeExcessConnectionsAndLogExceptionsLocked();
          reconfigureAllConnectionsLocked();
        }
        this.mChangeListener = paramSQLiteChangeListener;
        return;
      }
    }
  }
  
  void setCheckpointListener(SQLiteCheckpointListener paramSQLiteCheckpointListener)
  {
    SQLiteDatabase localSQLiteDatabase = (SQLiteDatabase)this.mDB.get();
    if (this.mCheckpointListener != null) {
      this.mCheckpointListener.onDetach(localSQLiteDatabase);
    }
    this.mCheckpointListener = paramSQLiteCheckpointListener;
    if (this.mCheckpointListener != null) {
      this.mCheckpointListener.onAttach(localSQLiteDatabase);
    }
  }
  
  void setTraceCallback(SQLiteTrace paramSQLiteTrace)
  {
    this.mTraceCallback = paramSQLiteTrace;
  }
  
  public boolean shouldYieldConnection(SQLiteConnection paramSQLiteConnection, int paramInt)
  {
    synchronized (this.mLock)
    {
      if (!this.mAcquiredConnections.containsKey(paramSQLiteConnection)) {
        throw new IllegalStateException("Cannot perform this operation because the specified connection was not acquired from this pool or has already been released.");
      }
    }
    if (!this.mIsOpen) {
      return false;
    }
    boolean bool = isSessionBlockingImportantConnectionWaitersLocked(paramSQLiteConnection.isPrimaryConnection(), paramInt);
    return bool;
  }
  
  public String toString()
  {
    return "SQLiteConnectionPool: " + this.mConfiguration.path;
  }
  
  void traceExecute(String paramString, int paramInt, long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = (SQLiteDatabase)this.mDB.get();
    SQLiteTrace localSQLiteTrace = this.mTraceCallback;
    if ((localSQLiteTrace == null) || (localSQLiteDatabase == null)) {
      return;
    }
    localSQLiteTrace.onSQLExecuted(localSQLiteDatabase, paramString, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteConnectionPool
 * JD-Core Version:    0.7.0.1
 */