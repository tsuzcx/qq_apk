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
  private Transaction mTransactionPool;
  private Transaction mTransactionStack;
  
  public SQLiteSession(SQLiteConnectionPool paramSQLiteConnectionPool)
  {
    if (paramSQLiteConnectionPool != null)
    {
      this.mConnectionPool = paramSQLiteConnectionPool;
      return;
    }
    throw new IllegalArgumentException("connectionPool must not be null");
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
  
  private void beginTransactionUnchecked(int paramInt1, SQLiteTransactionListener paramSQLiteTransactionListener, int paramInt2, CancellationSignal paramCancellationSignal)
  {
    if (paramCancellationSignal != null) {
      paramCancellationSignal.throwIfCanceled();
    }
    if (this.mTransactionStack == null) {
      acquireConnection(null, paramInt2, paramCancellationSignal);
    }
    for (;;)
    {
      try
      {
        if (this.mTransactionStack == null) {}
        SQLiteConnection localSQLiteConnection;
        switch (paramInt1)
        {
        case 2: 
          localSQLiteConnection = this.mConnection;
          continue;
          this.mConnection.execute("BEGIN EXCLUSIVE;", null, paramCancellationSignal);
          break;
        case 1: 
          this.mConnection.execute("BEGIN IMMEDIATE;", null, paramCancellationSignal);
          continue;
          localSQLiteConnection.execute("BEGIN;", null, paramCancellationSignal);
          if (paramSQLiteTransactionListener != null) {
            try
            {
              paramSQLiteTransactionListener.onBegin();
            }
            catch (RuntimeException paramSQLiteTransactionListener)
            {
              if (this.mTransactionStack == null) {
                this.mConnection.execute("ROLLBACK;", null, paramCancellationSignal);
              }
              throw paramSQLiteTransactionListener;
            }
          }
          paramSQLiteTransactionListener = obtainTransaction(paramInt1, paramSQLiteTransactionListener);
          paramSQLiteTransactionListener.mParent = this.mTransactionStack;
          this.mTransactionStack = paramSQLiteTransactionListener;
          return;
        }
      }
      finally
      {
        if (this.mTransactionStack == null) {
          releaseConnection();
        }
      }
    }
  }
  
  private void endTransactionUnchecked(CancellationSignal paramCancellationSignal, boolean paramBoolean)
  {
    if (paramCancellationSignal != null) {
      paramCancellationSignal.throwIfCanceled();
    }
    Transaction localTransaction = this.mTransactionStack;
    int i;
    if (((localTransaction.mMarkedSuccessful) || (paramBoolean)) && (!localTransaction.mChildFailed)) {
      i = 1;
    } else {
      i = 0;
    }
    SQLiteTransactionListener localSQLiteTransactionListener = localTransaction.mListener;
    if (localSQLiteTransactionListener != null)
    {
      if (i != 0) {}
      try
      {
        localSQLiteTransactionListener.onCommit();
      }
      catch (RuntimeException localRuntimeException)
      {
        i = 0;
        break label87;
      }
      localSQLiteTransactionListener.onRollback();
    }
    Object localObject = null;
    label87:
    this.mTransactionStack = localTransaction.mParent;
    recycleTransaction(localTransaction);
    localTransaction = this.mTransactionStack;
    if (localTransaction != null)
    {
      if (i == 0) {
        localTransaction.mChildFailed = true;
      }
    }
    else if (i == 0) {}
    try
    {
      this.mConnection.execute("COMMIT;", null, paramCancellationSignal);
      break label155;
      this.mConnection.execute("ROLLBACK;", null, paramCancellationSignal);
      label155:
      releaseConnection();
      if (localObject == null) {
        return;
      }
      throw localObject;
    }
    finally
    {
      releaseConnection();
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
    case 6: 
      endTransaction(paramCancellationSignal);
      return true;
    case 5: 
      setTransactionSuccessful();
      endTransaction(paramCancellationSignal);
      return true;
    }
    beginTransaction(2, null, paramInt, paramCancellationSignal);
    return true;
  }
  
  private Transaction obtainTransaction(int paramInt, SQLiteTransactionListener paramSQLiteTransactionListener)
  {
    Transaction localTransaction = this.mTransactionPool;
    if (localTransaction != null)
    {
      this.mTransactionPool = localTransaction.mParent;
      localTransaction.mParent = null;
      localTransaction.mMarkedSuccessful = false;
      localTransaction.mChildFailed = false;
    }
    else
    {
      localTransaction = new Transaction(null);
    }
    localTransaction.mMode = paramInt;
    localTransaction.mListener = paramSQLiteTransactionListener;
    return localTransaction;
  }
  
  private void recycleTransaction(Transaction paramTransaction)
  {
    paramTransaction.mParent = this.mTransactionPool;
    paramTransaction.mListener = null;
    this.mTransactionPool = paramTransaction;
  }
  
  private void releaseConnection()
  {
    int i = this.mConnectionUseCount - 1;
    this.mConnectionUseCount = i;
    if (i == 0) {
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
  }
  
  private void throwIfNestedTransaction()
  {
    if (!hasNestedTransaction()) {
      return;
    }
    throw new IllegalStateException("Cannot perform this operation because a nested transaction is in progress.");
  }
  
  private void throwIfNoTransaction()
  {
    if (this.mTransactionStack != null) {
      return;
    }
    throw new IllegalStateException("Cannot perform this operation because there is no current transaction.");
  }
  
  private void throwIfTransactionMarkedSuccessful()
  {
    Transaction localTransaction = this.mTransactionStack;
    if (localTransaction != null)
    {
      if (!localTransaction.mMarkedSuccessful) {
        return;
      }
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
    endTransactionUnchecked(paramCancellationSignal, false);
  }
  
  public void execute(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramString != null)
    {
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
    throw new IllegalArgumentException("sql must not be null.");
  }
  
  public int executeForChangedRowCount(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramString != null)
    {
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
    throw new IllegalArgumentException("sql must not be null.");
  }
  
  public int executeForCursorWindow(String paramString, Object[] paramArrayOfObject, CursorWindow paramCursorWindow, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, CancellationSignal paramCancellationSignal)
  {
    if (paramString != null)
    {
      if (paramCursorWindow != null)
      {
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
      throw new IllegalArgumentException("window must not be null.");
    }
    throw new IllegalArgumentException("sql must not be null.");
  }
  
  public long executeForLastInsertedRowId(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramString != null)
    {
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
    throw new IllegalArgumentException("sql must not be null.");
  }
  
  public long executeForLong(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramString != null)
    {
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
    throw new IllegalArgumentException("sql must not be null.");
  }
  
  public String executeForString(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramString != null)
    {
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
    throw new IllegalArgumentException("sql must not be null.");
  }
  
  public boolean hasConnection()
  {
    return this.mConnection != null;
  }
  
  public boolean hasNestedTransaction()
  {
    Transaction localTransaction = this.mTransactionStack;
    return (localTransaction != null) && (localTransaction.mParent != null);
  }
  
  public boolean hasTransaction()
  {
    return this.mTransactionStack != null;
  }
  
  public void prepare(String paramString, int paramInt, CancellationSignal paramCancellationSignal, SQLiteStatementInfo paramSQLiteStatementInfo)
  {
    if (paramString != null)
    {
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
    throw new IllegalArgumentException("sql must not be null.");
  }
  
  void releaseConnectionForNativeHandle(Exception paramException)
  {
    SQLiteConnection localSQLiteConnection = this.mConnection;
    if (localSQLiteConnection != null) {
      localSQLiteConnection.endNativeHandle(paramException);
    }
    releaseConnection();
  }
  
  void releasePreparedStatement(SQLiteConnection.PreparedStatement paramPreparedStatement)
  {
    SQLiteConnection localSQLiteConnection = this.mConnection;
    if (localSQLiteConnection != null)
    {
      localSQLiteConnection.releasePreparedStatement(paramPreparedStatement);
      releaseConnection();
    }
  }
  
  public void setTransactionSuccessful()
  {
    throwIfNoTransaction();
    throwIfTransactionMarkedSuccessful();
    this.mTransactionStack.mMarkedSuccessful = true;
  }
  
  public Pair<Integer, Integer> walCheckpoint(String paramString, int paramInt)
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
    else
    {
      Transaction localTransaction = this.mTransactionStack;
      if ((localTransaction == null) || (localTransaction.mMarkedSuccessful)) {
        break label70;
      }
      if (this.mTransactionStack.mParent != null) {
        return false;
      }
    }
    if (this.mTransactionStack.mChildFailed) {
      return false;
    }
    return yieldTransactionUnchecked(paramLong, paramCancellationSignal);
    label70:
    return false;
  }
  
  private static final class Transaction
  {
    public boolean mChildFailed;
    public SQLiteTransactionListener mListener;
    public boolean mMarkedSuccessful;
    public int mMode;
    public Transaction mParent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteSession
 * JD-Core Version:    0.7.0.1
 */