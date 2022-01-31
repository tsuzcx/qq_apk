package com.tencent.wcdb.database;

import android.os.Process;
import android.util.Pair;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.support.CancellationSignal;

public final class SQLiteSession
{
  public static final int TRANSACTION_MODE_DEFERRED = 0;
  public static final int TRANSACTION_MODE_EXCLUSIVE = 2;
  public static final int TRANSACTION_MODE_IMMEDIATE = 1;
  private SQLiteConnection mConnection;
  private int mConnectionFlags;
  private final SQLiteConnectionPool mConnectionPool;
  private int mConnectionUseCount;
  private SQLiteSession.Transaction mTransactionPool;
  private SQLiteSession.Transaction mTransactionStack;
  
  static
  {
    if (!SQLiteSession.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SQLiteSession(SQLiteConnectionPool paramSQLiteConnectionPool)
  {
    if (paramSQLiteConnectionPool == null) {
      throw new IllegalArgumentException("connectionPool must not be null");
    }
    this.mConnectionPool = paramSQLiteConnectionPool;
  }
  
  private void acquireConnection(String paramString, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (this.mConnection == null)
    {
      this.mConnection = this.mConnectionPool.acquireConnection(paramString, paramInt, paramCancellationSignal);
      this.mConnectionFlags = paramInt;
      this.mConnection.setAcquisitionState(Thread.currentThread(), Process.myTid());
    }
    this.mConnectionUseCount += 1;
  }
  
  /* Error */
  private void beginTransactionUnchecked(int paramInt1, SQLiteTransactionListener paramSQLiteTransactionListener, int paramInt2, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload 4
    //   2: ifnull +8 -> 10
    //   5: aload 4
    //   7: invokevirtual 86	com/tencent/wcdb/support/CancellationSignal:throwIfCanceled	()V
    //   10: aload_0
    //   11: getfield 88	com/tencent/wcdb/database/SQLiteSession:mTransactionStack	Lcom/tencent/wcdb/database/SQLiteSession$Transaction;
    //   14: ifnonnull +11 -> 25
    //   17: aload_0
    //   18: aconst_null
    //   19: iload_3
    //   20: aload 4
    //   22: invokespecial 90	com/tencent/wcdb/database/SQLiteSession:acquireConnection	(Ljava/lang/String;ILcom/tencent/wcdb/support/CancellationSignal;)V
    //   25: aload_0
    //   26: getfield 88	com/tencent/wcdb/database/SQLiteSession:mTransactionStack	Lcom/tencent/wcdb/database/SQLiteSession$Transaction;
    //   29: ifnonnull +39 -> 68
    //   32: iload_1
    //   33: tableswitch	default:+143 -> 176, 1:+77->110, 2:+106->139
    //   57: getfield 50	com/tencent/wcdb/database/SQLiteSession:mConnection	Lcom/tencent/wcdb/database/SQLiteConnection;
    //   60: ldc 92
    //   62: aconst_null
    //   63: aload 4
    //   65: invokevirtual 96	com/tencent/wcdb/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   68: aload_2
    //   69: ifnull +9 -> 78
    //   72: aload_2
    //   73: invokeinterface 101 1 0
    //   78: aload_0
    //   79: iload_1
    //   80: aload_2
    //   81: invokespecial 105	com/tencent/wcdb/database/SQLiteSession:obtainTransaction	(ILcom/tencent/wcdb/database/SQLiteTransactionListener;)Lcom/tencent/wcdb/database/SQLiteSession$Transaction;
    //   84: astore_2
    //   85: aload_2
    //   86: aload_0
    //   87: getfield 88	com/tencent/wcdb/database/SQLiteSession:mTransactionStack	Lcom/tencent/wcdb/database/SQLiteSession$Transaction;
    //   90: putfield 110	com/tencent/wcdb/database/SQLiteSession$Transaction:mParent	Lcom/tencent/wcdb/database/SQLiteSession$Transaction;
    //   93: aload_0
    //   94: aload_2
    //   95: putfield 88	com/tencent/wcdb/database/SQLiteSession:mTransactionStack	Lcom/tencent/wcdb/database/SQLiteSession$Transaction;
    //   98: aload_0
    //   99: getfield 88	com/tencent/wcdb/database/SQLiteSession:mTransactionStack	Lcom/tencent/wcdb/database/SQLiteSession$Transaction;
    //   102: ifnonnull +7 -> 109
    //   105: aload_0
    //   106: invokespecial 113	com/tencent/wcdb/database/SQLiteSession:releaseConnection	()V
    //   109: return
    //   110: aload_0
    //   111: getfield 50	com/tencent/wcdb/database/SQLiteSession:mConnection	Lcom/tencent/wcdb/database/SQLiteConnection;
    //   114: ldc 115
    //   116: aconst_null
    //   117: aload 4
    //   119: invokevirtual 96	com/tencent/wcdb/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   122: goto -54 -> 68
    //   125: astore_2
    //   126: aload_0
    //   127: getfield 88	com/tencent/wcdb/database/SQLiteSession:mTransactionStack	Lcom/tencent/wcdb/database/SQLiteSession$Transaction;
    //   130: ifnonnull +7 -> 137
    //   133: aload_0
    //   134: invokespecial 113	com/tencent/wcdb/database/SQLiteSession:releaseConnection	()V
    //   137: aload_2
    //   138: athrow
    //   139: aload_0
    //   140: getfield 50	com/tencent/wcdb/database/SQLiteSession:mConnection	Lcom/tencent/wcdb/database/SQLiteConnection;
    //   143: ldc 117
    //   145: aconst_null
    //   146: aload 4
    //   148: invokevirtual 96	com/tencent/wcdb/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   151: goto -83 -> 68
    //   154: astore_2
    //   155: aload_0
    //   156: getfield 88	com/tencent/wcdb/database/SQLiteSession:mTransactionStack	Lcom/tencent/wcdb/database/SQLiteSession$Transaction;
    //   159: ifnonnull +15 -> 174
    //   162: aload_0
    //   163: getfield 50	com/tencent/wcdb/database/SQLiteSession:mConnection	Lcom/tencent/wcdb/database/SQLiteConnection;
    //   166: ldc 119
    //   168: aconst_null
    //   169: aload 4
    //   171: invokevirtual 96	com/tencent/wcdb/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   174: aload_2
    //   175: athrow
    //   176: goto -120 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	SQLiteSession
    //   0	179	1	paramInt1	int
    //   0	179	2	paramSQLiteTransactionListener	SQLiteTransactionListener
    //   0	179	3	paramInt2	int
    //   0	179	4	paramCancellationSignal	CancellationSignal
    // Exception table:
    //   from	to	target	type
    //   25	32	125	finally
    //   56	68	125	finally
    //   72	78	125	finally
    //   78	98	125	finally
    //   110	122	125	finally
    //   139	151	125	finally
    //   155	174	125	finally
    //   174	176	125	finally
    //   72	78	154	java/lang/RuntimeException
  }
  
  private void endTransactionUnchecked(CancellationSignal paramCancellationSignal, boolean paramBoolean)
  {
    int j = 0;
    if (paramCancellationSignal != null) {
      paramCancellationSignal.throwIfCanceled();
    }
    SQLiteSession.Transaction localTransaction = this.mTransactionStack;
    int i;
    SQLiteTransactionListener localSQLiteTransactionListener;
    if (((localTransaction.mMarkedSuccessful) || (paramBoolean)) && (!localTransaction.mChildFailed))
    {
      i = 1;
      localSQLiteTransactionListener = localTransaction.mListener;
      if (localSQLiteTransactionListener == null) {
        break label174;
      }
      if (i == 0) {
        break label112;
      }
    }
    for (;;)
    {
      try
      {
        localSQLiteTransactionListener.onCommit();
        localSQLiteTransactionListener = null;
      }
      catch (RuntimeException localRuntimeException)
      {
        label112:
        i = j;
        continue;
        if (i == 0) {
          continue;
        }
        try
        {
          this.mConnection.execute("COMMIT;", null, paramCancellationSignal);
          releaseConnection();
          continue;
        }
        finally
        {
          releaseConnection();
        }
        this.mConnection.execute("ROLLBACK;", null, paramCancellationSignal);
        continue;
      }
      this.mTransactionStack = localTransaction.mParent;
      recycleTransaction(localTransaction);
      if (this.mTransactionStack != null)
      {
        if (i == 0) {
          this.mTransactionStack.mChildFailed = true;
        }
        if (localSQLiteTransactionListener == null) {
          break label173;
        }
        throw localSQLiteTransactionListener;
        i = 0;
        break;
        localSQLiteTransactionListener.onRollback();
        continue;
      }
      label173:
      return;
      label174:
      Object localObject = null;
    }
  }
  
  private boolean executeSpecial(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramCancellationSignal != null) {
      paramCancellationSignal.throwIfCanceled();
    }
    switch (DatabaseUtils.getSqlStatementType(paramString))
    {
    default: 
      return false;
    case 4: 
      beginTransaction(2, null, paramInt, paramCancellationSignal);
      return true;
    case 5: 
      setTransactionSuccessful();
      endTransaction(paramCancellationSignal);
      return true;
    }
    endTransaction(paramCancellationSignal);
    return true;
  }
  
  private SQLiteSession.Transaction obtainTransaction(int paramInt, SQLiteTransactionListener paramSQLiteTransactionListener)
  {
    SQLiteSession.Transaction localTransaction = this.mTransactionPool;
    if (localTransaction != null)
    {
      this.mTransactionPool = localTransaction.mParent;
      localTransaction.mParent = null;
      localTransaction.mMarkedSuccessful = false;
      localTransaction.mChildFailed = false;
    }
    for (;;)
    {
      localTransaction.mMode = paramInt;
      localTransaction.mListener = paramSQLiteTransactionListener;
      return localTransaction;
      localTransaction = new SQLiteSession.Transaction(null);
    }
  }
  
  private void recycleTransaction(SQLiteSession.Transaction paramTransaction)
  {
    paramTransaction.mParent = this.mTransactionPool;
    paramTransaction.mListener = null;
    this.mTransactionPool = paramTransaction;
  }
  
  private void releaseConnection()
  {
    int i = this.mConnectionUseCount - 1;
    this.mConnectionUseCount = i;
    if (i == 0) {}
    try
    {
      this.mConnection.setAcquisitionState(null, 0);
      this.mConnectionPool.releaseConnection(this.mConnection);
      return;
    }
    finally
    {
      this.mConnection = null;
    }
  }
  
  private void throwIfNestedTransaction()
  {
    if (hasNestedTransaction()) {
      throw new IllegalStateException("Cannot perform this operation because a nested transaction is in progress.");
    }
  }
  
  private void throwIfNoTransaction()
  {
    if (this.mTransactionStack == null) {
      throw new IllegalStateException("Cannot perform this operation because there is no current transaction.");
    }
  }
  
  private void throwIfTransactionMarkedSuccessful()
  {
    if ((this.mTransactionStack != null) && (this.mTransactionStack.mMarkedSuccessful)) {
      throw new IllegalStateException("Cannot perform this operation because the transaction has already been marked successful.  The only thing you can do now is call endTransaction().");
    }
  }
  
  private boolean yieldTransactionUnchecked(long paramLong, CancellationSignal paramCancellationSignal)
  {
    if (paramCancellationSignal != null) {
      paramCancellationSignal.throwIfCanceled();
    }
    if (!this.mConnectionPool.shouldYieldConnection(this.mConnection, this.mConnectionFlags)) {
      return false;
    }
    int i = this.mTransactionStack.mMode;
    SQLiteTransactionListener localSQLiteTransactionListener = this.mTransactionStack.mListener;
    int j = this.mConnectionFlags;
    endTransactionUnchecked(paramCancellationSignal, true);
    if (paramLong > 0L) {}
    try
    {
      Thread.sleep(paramLong);
      label68:
      beginTransactionUnchecked(i, localSQLiteTransactionListener, j, paramCancellationSignal);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label68;
    }
  }
  
  SQLiteConnection acquireConnectionForNativeHandle(int paramInt)
  {
    acquireConnection(null, paramInt, null);
    return this.mConnection;
  }
  
  SQLiteConnection.PreparedStatement acquirePreparedStatement(String paramString, int paramInt)
  {
    acquireConnection(paramString, paramInt, null);
    return this.mConnection.acquirePreparedStatement(paramString);
  }
  
  public void beginTransaction(int paramInt1, SQLiteTransactionListener paramSQLiteTransactionListener, int paramInt2, CancellationSignal paramCancellationSignal)
  {
    throwIfTransactionMarkedSuccessful();
    beginTransactionUnchecked(paramInt1, paramSQLiteTransactionListener, paramInt2, paramCancellationSignal);
  }
  
  public void endTransaction(CancellationSignal paramCancellationSignal)
  {
    throwIfNoTransaction();
    assert (this.mConnection != null);
    endTransactionUnchecked(paramCancellationSignal, false);
  }
  
  public void execute(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("sql must not be null.");
    }
    if (executeSpecial(paramString, paramArrayOfObject, paramInt, paramCancellationSignal)) {
      return;
    }
    acquireConnection(paramString, paramInt, paramCancellationSignal);
    try
    {
      this.mConnection.execute(paramString, paramArrayOfObject, paramCancellationSignal);
      return;
    }
    finally
    {
      releaseConnection();
    }
  }
  
  public int executeForChangedRowCount(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("sql must not be null.");
    }
    if (executeSpecial(paramString, paramArrayOfObject, paramInt, paramCancellationSignal)) {
      return 0;
    }
    acquireConnection(paramString, paramInt, paramCancellationSignal);
    try
    {
      paramInt = this.mConnection.executeForChangedRowCount(paramString, paramArrayOfObject, paramCancellationSignal);
      return paramInt;
    }
    finally
    {
      releaseConnection();
    }
  }
  
  public int executeForCursorWindow(String paramString, Object[] paramArrayOfObject, CursorWindow paramCursorWindow, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("sql must not be null.");
    }
    if (paramCursorWindow == null) {
      throw new IllegalArgumentException("window must not be null.");
    }
    if (executeSpecial(paramString, paramArrayOfObject, paramInt3, paramCancellationSignal))
    {
      paramCursorWindow.clear();
      return 0;
    }
    acquireConnection(paramString, paramInt3, paramCancellationSignal);
    try
    {
      paramInt1 = this.mConnection.executeForCursorWindow(paramString, paramArrayOfObject, paramCursorWindow, paramInt1, paramInt2, paramBoolean, paramCancellationSignal);
      return paramInt1;
    }
    finally
    {
      releaseConnection();
    }
  }
  
  public long executeForLastInsertedRowId(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("sql must not be null.");
    }
    if (executeSpecial(paramString, paramArrayOfObject, paramInt, paramCancellationSignal)) {
      return 0L;
    }
    acquireConnection(paramString, paramInt, paramCancellationSignal);
    try
    {
      long l = this.mConnection.executeForLastInsertedRowId(paramString, paramArrayOfObject, paramCancellationSignal);
      return l;
    }
    finally
    {
      releaseConnection();
    }
  }
  
  public long executeForLong(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("sql must not be null.");
    }
    if (executeSpecial(paramString, paramArrayOfObject, paramInt, paramCancellationSignal)) {
      return 0L;
    }
    acquireConnection(paramString, paramInt, paramCancellationSignal);
    try
    {
      long l = this.mConnection.executeForLong(paramString, paramArrayOfObject, paramCancellationSignal);
      return l;
    }
    finally
    {
      releaseConnection();
    }
  }
  
  public String executeForString(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("sql must not be null.");
    }
    if (executeSpecial(paramString, paramArrayOfObject, paramInt, paramCancellationSignal)) {
      return null;
    }
    acquireConnection(paramString, paramInt, paramCancellationSignal);
    try
    {
      paramString = this.mConnection.executeForString(paramString, paramArrayOfObject, paramCancellationSignal);
      return paramString;
    }
    finally
    {
      releaseConnection();
    }
  }
  
  public boolean hasConnection()
  {
    return this.mConnection != null;
  }
  
  public boolean hasNestedTransaction()
  {
    return (this.mTransactionStack != null) && (this.mTransactionStack.mParent != null);
  }
  
  public boolean hasTransaction()
  {
    return this.mTransactionStack != null;
  }
  
  public void prepare(String paramString, int paramInt, CancellationSignal paramCancellationSignal, SQLiteStatementInfo paramSQLiteStatementInfo)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("sql must not be null.");
    }
    if (paramCancellationSignal != null) {
      paramCancellationSignal.throwIfCanceled();
    }
    acquireConnection(paramString, paramInt, paramCancellationSignal);
    try
    {
      this.mConnection.prepare(paramString, paramSQLiteStatementInfo);
      return;
    }
    finally
    {
      releaseConnection();
    }
  }
  
  void releaseConnectionForNativeHandle(Exception paramException)
  {
    if (this.mConnection != null) {
      this.mConnection.endNativeHandle(paramException);
    }
    releaseConnection();
  }
  
  void releasePreparedStatement(SQLiteConnection.PreparedStatement paramPreparedStatement)
  {
    if (this.mConnection != null)
    {
      this.mConnection.releasePreparedStatement(paramPreparedStatement);
      releaseConnection();
    }
  }
  
  public void setTransactionSuccessful()
  {
    throwIfNoTransaction();
    throwIfTransactionMarkedSuccessful();
    this.mTransactionStack.mMarkedSuccessful = true;
  }
  
  public Pair walCheckpoint(String paramString, int paramInt)
  {
    acquireConnection(null, paramInt, null);
    try
    {
      paramString = this.mConnection.walCheckpoint(paramString);
      return paramString;
    }
    finally
    {
      releaseConnection();
    }
  }
  
  public boolean yieldTransaction(long paramLong, boolean paramBoolean, CancellationSignal paramCancellationSignal)
  {
    if (paramBoolean)
    {
      throwIfNoTransaction();
      throwIfTransactionMarkedSuccessful();
      throwIfNestedTransaction();
    }
    while ((this.mTransactionStack != null) && (!this.mTransactionStack.mMarkedSuccessful) && (this.mTransactionStack.mParent == null))
    {
      if (($assertionsDisabled) || (this.mConnection != null)) {
        break;
      }
      throw new AssertionError();
    }
    while (this.mTransactionStack.mChildFailed) {
      return false;
    }
    return yieldTransactionUnchecked(paramLong, paramCancellationSignal);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteSession
 * JD-Core Version:    0.7.0.1
 */