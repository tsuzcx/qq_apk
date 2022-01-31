package com.tencent.wcdb.database;

import android.util.Printer;
import com.tencent.wcdb.support.Log;
import java.util.ArrayList;

final class SQLiteConnection$OperationLog
{
  private static final int COOKIE_GENERATION_SHIFT = 8;
  private static final int COOKIE_INDEX_MASK = 255;
  private static final int MAX_RECENT_OPERATIONS = 20;
  private int mGeneration;
  private int mIndex;
  private final SQLiteConnection.Operation[] mOperations = new SQLiteConnection.Operation[20];
  
  private SQLiteConnection$OperationLog(SQLiteConnection paramSQLiteConnection) {}
  
  private boolean endOperationDeferLogLocked(SQLiteConnection.Operation paramOperation)
  {
    if (paramOperation != null)
    {
      paramOperation.mEndTime = System.currentTimeMillis();
      paramOperation.mFinished = true;
      if ((paramOperation.mException != null) && (paramOperation.mException.getMessage() != null)) {
        return true;
      }
      return SQLiteDebug.shouldLogSlowQuery(paramOperation.mEndTime - paramOperation.mStartTime);
    }
    return false;
  }
  
  private SQLiteConnection.Operation getOperationLocked(int paramInt)
  {
    SQLiteConnection.Operation localOperation = this.mOperations[(paramInt & 0xFF)];
    if (localOperation.mCookie == paramInt) {
      return localOperation;
    }
    return null;
  }
  
  private void logOperationLocked(SQLiteConnection.Operation paramOperation, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramOperation.describe(localStringBuilder, false);
    if (paramString != null) {
      localStringBuilder.append(", ").append(paramString);
    }
    Log.i("WCDB.SQLiteConnection", localStringBuilder.toString());
  }
  
  private int newOperationCookieLocked(int paramInt)
  {
    int i = this.mGeneration;
    this.mGeneration = (i + 1);
    return i << 8 | paramInt;
  }
  
  public SQLiteConnection.Operation beginOperation(String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    int i = 0;
    for (;;)
    {
      int j;
      SQLiteConnection.Operation localOperation1;
      synchronized (this.mOperations)
      {
        j = (this.mIndex + 1) % 20;
        SQLiteConnection.Operation localOperation2 = this.mOperations[j];
        if (localOperation2 == null)
        {
          localOperation1 = new SQLiteConnection.Operation(null);
          this.mOperations[j] = localOperation1;
          localOperation1.mStartTime = System.currentTimeMillis();
          localOperation1.mKind = paramString1;
          localOperation1.mSql = paramString2;
          if (paramArrayOfObject == null) {
            break label207;
          }
          if (localOperation1.mBindArgs == null)
          {
            localOperation1.mBindArgs = new ArrayList();
            if (i >= paramArrayOfObject.length) {
              break label207;
            }
            paramString1 = paramArrayOfObject[i];
            if ((paramString1 == null) || (!(paramString1 instanceof byte[]))) {
              break label194;
            }
            localOperation1.mBindArgs.add(SQLiteConnection.access$1700());
            break label242;
          }
        }
        else
        {
          localOperation2.mFinished = false;
          localOperation2.mException = null;
          localOperation1 = localOperation2;
          if (localOperation2.mBindArgs == null) {
            continue;
          }
          localOperation2.mBindArgs.clear();
          localOperation1 = localOperation2;
        }
      }
      localOperation1.mBindArgs.clear();
      continue;
      label194:
      localOperation1.mBindArgs.add(paramString1);
      break label242;
      label207:
      localOperation1.mCookie = newOperationCookieLocked(j);
      localOperation1.mTid = SQLiteConnection.access$1800(this.this$0);
      this.mIndex = j;
      return localOperation1;
      label242:
      i += 1;
    }
  }
  
  public String describeCurrentOperation()
  {
    synchronized (this.mOperations)
    {
      Object localObject1 = this.mOperations[this.mIndex];
      if ((localObject1 != null) && (!((SQLiteConnection.Operation)localObject1).mFinished))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        ((SQLiteConnection.Operation)localObject1).describe(localStringBuilder, false);
        localObject1 = localStringBuilder.toString();
        return localObject1;
      }
      return null;
    }
  }
  
  public void dump(Printer paramPrinter, boolean paramBoolean)
  {
    for (;;)
    {
      synchronized (this.mOperations)
      {
        paramPrinter.println("  Most recently executed operations:");
        i = this.mIndex;
        SQLiteConnection.Operation localOperation = this.mOperations[i];
        if (localOperation != null)
        {
          int j = 0;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("    ").append(j).append(": [");
          localStringBuilder.append(SQLiteConnection.Operation.access$2000(localOperation));
          localStringBuilder.append("] ");
          localOperation.describe(localStringBuilder, paramBoolean);
          paramPrinter.println(localStringBuilder.toString());
          if (i <= 0) {
            break label161;
          }
          i -= 1;
          j += 1;
          localOperation = this.mOperations[i];
          if ((localOperation != null) && (j < 20)) {}
        }
        else
        {
          paramPrinter.println("    <none>");
        }
      }
      continue;
      label161:
      int i = 19;
    }
  }
  
  public void endOperation(int paramInt)
  {
    synchronized (this.mOperations)
    {
      SQLiteConnection.Operation localOperation = getOperationLocked(paramInt);
      if (endOperationDeferLogLocked(localOperation)) {
        logOperationLocked(localOperation, null);
      }
      String str1 = localOperation.mSql;
      String str2 = localOperation.mKind;
      paramInt = localOperation.mType;
      long l1 = localOperation.mEndTime;
      long l2 = localOperation.mStartTime;
      if (!"prepare".equals(str2)) {
        SQLiteConnection.access$1900(this.this$0).traceExecute(str1, paramInt, l1 - l2);
      }
      return;
    }
  }
  
  public boolean endOperationDeferLog(int paramInt)
  {
    boolean bool;
    synchronized (this.mOperations)
    {
      SQLiteConnection.Operation localOperation = getOperationLocked(paramInt);
      if (localOperation == null) {
        return false;
      }
      bool = endOperationDeferLogLocked(localOperation);
      String str1 = localOperation.mSql;
      String str2 = localOperation.mKind;
      paramInt = localOperation.mType;
      long l1 = localOperation.mEndTime;
      long l2 = localOperation.mStartTime;
      if (!"prepare".equals(str2))
      {
        SQLiteConnection.access$1900(this.this$0).traceExecute(str1, paramInt, l1 - l2);
        return bool;
      }
    }
    return bool;
  }
  
  public void failOperation(int paramInt, Exception paramException)
  {
    synchronized (this.mOperations)
    {
      SQLiteConnection.Operation localOperation = getOperationLocked(paramInt);
      if (localOperation != null) {
        localOperation.mException = paramException;
      }
      return;
    }
  }
  
  public void logOperation(int paramInt, String paramString)
  {
    synchronized (this.mOperations)
    {
      SQLiteConnection.Operation localOperation = getOperationLocked(paramInt);
      if (localOperation != null) {
        logOperationLocked(localOperation, paramString);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteConnection.OperationLog
 * JD-Core Version:    0.7.0.1
 */