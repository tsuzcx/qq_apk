package com.tencent.wcdb.database;

import android.annotation.SuppressLint;
import android.util.Pair;
import android.util.Printer;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.CancellationSignal.OnCancelListener;
import com.tencent.wcdb.support.Log;
import com.tencent.wcdb.support.LruCache;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SQLiteConnection
  implements CancellationSignal.OnCancelListener
{
  private static final boolean DEBUG = false;
  private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
  private static final String[] EMPTY_STRING_ARRAY = new String[0];
  private static final String TAG = "WCDB.SQLiteConnection";
  private static final Pattern TRIM_SQL_PATTERN = Pattern.compile("[\\s]*\\n+[\\s]*");
  private Thread mAcquiredThread;
  private int mAcquiredTid;
  private int mCancellationSignalAttachCount;
  private SQLiteCipherSpec mCipher;
  private final SQLiteDatabaseConfiguration mConfiguration;
  private final int mConnectionId;
  private long mConnectionPtr;
  private final boolean mIsPrimaryConnection;
  private final boolean mIsReadOnlyConnection;
  private int mNativeHandleCount;
  private Operation mNativeOperation;
  private boolean mOnlyAllowReadOnlyOperations;
  private byte[] mPassword;
  private final SQLiteConnectionPool mPool;
  private final PreparedStatementCache mPreparedStatementCache;
  private PreparedStatement mPreparedStatementPool;
  private final OperationLog mRecentOperations;
  
  private SQLiteConnection(SQLiteConnectionPool paramSQLiteConnectionPool, SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration, int paramInt, boolean paramBoolean, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec)
  {
    Object localObject = null;
    this.mRecentOperations = new OperationLog(null);
    this.mPassword = paramArrayOfByte;
    if (paramSQLiteCipherSpec == null) {
      paramArrayOfByte = localObject;
    } else {
      paramArrayOfByte = new SQLiteCipherSpec(paramSQLiteCipherSpec);
    }
    this.mCipher = paramArrayOfByte;
    this.mPool = paramSQLiteConnectionPool;
    this.mConfiguration = new SQLiteDatabaseConfiguration(paramSQLiteDatabaseConfiguration);
    this.mConnectionId = paramInt;
    this.mIsPrimaryConnection = paramBoolean;
    paramInt = paramSQLiteDatabaseConfiguration.openFlags;
    paramBoolean = true;
    if ((paramInt & 0x1) == 0) {
      paramBoolean = false;
    }
    this.mIsReadOnlyConnection = paramBoolean;
    this.mPreparedStatementCache = new PreparedStatementCache(this.mConfiguration.maxSqlCacheSize);
  }
  
  private void applyBlockGuardPolicy(PreparedStatement paramPreparedStatement) {}
  
  private void attachCancellationSignal(CancellationSignal paramCancellationSignal)
  {
    if (paramCancellationSignal != null)
    {
      paramCancellationSignal.throwIfCanceled();
      this.mCancellationSignalAttachCount += 1;
      if (this.mCancellationSignalAttachCount == 1)
      {
        nativeResetCancel(this.mConnectionPtr, true);
        paramCancellationSignal.setOnCancelListener(this);
      }
    }
  }
  
  private void bindArguments(PreparedStatement paramPreparedStatement, Object[] paramArrayOfObject)
  {
    int j = 0;
    int i;
    if (paramArrayOfObject != null) {
      i = paramArrayOfObject.length;
    } else {
      i = 0;
    }
    if (i == paramPreparedStatement.mNumParameters)
    {
      if (i == 0) {
        return;
      }
      long l2 = paramPreparedStatement.getPtr();
      while (j < i)
      {
        paramPreparedStatement = paramArrayOfObject[j];
        int k = DatabaseUtils.getTypeOfObject(paramPreparedStatement);
        if (k != 4) {
          switch (k)
          {
          default: 
            if ((paramPreparedStatement instanceof Boolean))
            {
              long l3 = this.mConnectionPtr;
              long l1;
              if (((Boolean)paramPreparedStatement).booleanValue()) {
                l1 = 1L;
              } else {
                l1 = 0L;
              }
              nativeBindLong(l3, l2, j + 1, l1);
            }
            else
            {
              nativeBindString(this.mConnectionPtr, l2, j + 1, paramPreparedStatement.toString());
            }
            break;
          case 2: 
            nativeBindDouble(this.mConnectionPtr, l2, j + 1, ((Number)paramPreparedStatement).doubleValue());
            break;
          case 1: 
            nativeBindLong(this.mConnectionPtr, l2, j + 1, ((Number)paramPreparedStatement).longValue());
            break;
          case 0: 
            nativeBindNull(this.mConnectionPtr, l2, j + 1);
            break;
          }
        } else {
          nativeBindBlob(this.mConnectionPtr, l2, j + 1, (byte[])paramPreparedStatement);
        }
        j += 1;
      }
      return;
    }
    paramArrayOfObject = new StringBuilder();
    paramArrayOfObject.append("Expected ");
    paramArrayOfObject.append(paramPreparedStatement.mNumParameters);
    paramArrayOfObject.append(" bind arguments but ");
    paramArrayOfObject.append(i);
    paramArrayOfObject.append(" were provided.");
    throw new SQLiteBindOrColumnIndexOutOfRangeException(paramArrayOfObject.toString());
  }
  
  private void detachCancellationSignal(CancellationSignal paramCancellationSignal)
  {
    if (paramCancellationSignal != null)
    {
      this.mCancellationSignalAttachCount -= 1;
      if (this.mCancellationSignalAttachCount == 0)
      {
        paramCancellationSignal.setOnCancelListener(null);
        nativeResetCancel(this.mConnectionPtr, false);
      }
    }
  }
  
  private void dispose(boolean paramBoolean)
  {
    if (this.mConnectionPtr != 0L)
    {
      int i = this.mRecentOperations.beginOperation("close", null, null).mCookie;
      try
      {
        this.mPreparedStatementCache.evictAll();
        nativeClose(this.mConnectionPtr);
        this.mConnectionPtr = 0L;
        return;
      }
      finally
      {
        this.mRecentOperations.endOperation(i);
      }
    }
  }
  
  private void finalizePreparedStatement(PreparedStatement paramPreparedStatement)
  {
    nativeFinalizeStatement(this.mConnectionPtr, paramPreparedStatement.getPtr());
    recyclePreparedStatement(paramPreparedStatement);
  }
  
  private SQLiteDebug.DbStats getMainDbStatsUnsafe(int paramInt, long paramLong1, long paramLong2)
  {
    String str = this.mConfiguration.path;
    if (!this.mIsPrimaryConnection)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(" (");
      localStringBuilder.append(this.mConnectionId);
      localStringBuilder.append(")");
      str = localStringBuilder.toString();
    }
    return new SQLiteDebug.DbStats(str, paramLong1, paramLong2, paramInt, this.mPreparedStatementCache.hitCount(), this.mPreparedStatementCache.missCount(), this.mPreparedStatementCache.size());
  }
  
  private static boolean isCacheable(int paramInt)
  {
    if (paramInt != 2) {
      return paramInt == 1;
    }
    return true;
  }
  
  private static native void nativeBindBlob(long paramLong1, long paramLong2, int paramInt, byte[] paramArrayOfByte);
  
  private static native void nativeBindDouble(long paramLong1, long paramLong2, int paramInt, double paramDouble);
  
  private static native void nativeBindLong(long paramLong1, long paramLong2, int paramInt, long paramLong3);
  
  private static native void nativeBindNull(long paramLong1, long paramLong2, int paramInt);
  
  private static native void nativeBindString(long paramLong1, long paramLong2, int paramInt, String paramString);
  
  private static native void nativeCancel(long paramLong);
  
  private static native void nativeClose(long paramLong);
  
  private static native void nativeExecute(long paramLong1, long paramLong2);
  
  private static native int nativeExecuteForChangedRowCount(long paramLong1, long paramLong2);
  
  private static native long nativeExecuteForCursorWindow(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, boolean paramBoolean);
  
  private static native long nativeExecuteForLastInsertedRowId(long paramLong1, long paramLong2);
  
  private static native long nativeExecuteForLong(long paramLong1, long paramLong2);
  
  private static native String nativeExecuteForString(long paramLong1, long paramLong2);
  
  private static native void nativeFinalizeStatement(long paramLong1, long paramLong2);
  
  private static native int nativeGetColumnCount(long paramLong1, long paramLong2);
  
  private static native String nativeGetColumnName(long paramLong1, long paramLong2, int paramInt);
  
  private static native int nativeGetDbLookaside(long paramLong);
  
  private static native int nativeGetParameterCount(long paramLong1, long paramLong2);
  
  private static native boolean nativeIsReadOnly(long paramLong1, long paramLong2);
  
  private native long nativeOpen(String paramString1, int paramInt, String paramString2);
  
  private static native long nativePrepareStatement(long paramLong, String paramString);
  
  private static native void nativeRegisterCustomFunction(long paramLong, SQLiteCustomFunction paramSQLiteCustomFunction);
  
  private static native void nativeRegisterLocalizedCollators(long paramLong, String paramString);
  
  private static native void nativeResetCancel(long paramLong, boolean paramBoolean);
  
  private static native void nativeResetStatement(long paramLong1, long paramLong2, boolean paramBoolean);
  
  private static native long nativeSQLiteHandle(long paramLong, boolean paramBoolean);
  
  private static native void nativeSetKey(long paramLong, byte[] paramArrayOfByte);
  
  private static native void nativeSetUpdateNotification(long paramLong, boolean paramBoolean1, boolean paramBoolean2);
  
  private static native void nativeSetWalHook(long paramLong);
  
  private static native long nativeWalCheckpoint(long paramLong, String paramString);
  
  private void notifyChange(String paramString1, String paramString2, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    this.mPool.notifyChanges(paramString1, paramString2, paramArrayOfLong1, paramArrayOfLong2, paramArrayOfLong3);
  }
  
  private void notifyCheckpoint(String paramString, int paramInt)
  {
    this.mPool.notifyCheckpoint(paramString, paramInt);
  }
  
  private PreparedStatement obtainPreparedStatement(String paramString, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    PreparedStatement localPreparedStatement = this.mPreparedStatementPool;
    if (localPreparedStatement != null)
    {
      this.mPreparedStatementPool = localPreparedStatement.mPoolNext;
      PreparedStatement.access$702(localPreparedStatement, null);
      PreparedStatement.access$502(localPreparedStatement, false);
    }
    else
    {
      localPreparedStatement = new PreparedStatement(this);
    }
    PreparedStatement.access$602(localPreparedStatement, paramString);
    PreparedStatement.access$802(localPreparedStatement, paramLong);
    PreparedStatement.access$202(localPreparedStatement, paramInt1);
    PreparedStatement.access$102(localPreparedStatement, paramInt2);
    PreparedStatement.access$302(localPreparedStatement, paramBoolean);
    return localPreparedStatement;
  }
  
  static SQLiteConnection open(SQLiteConnectionPool paramSQLiteConnectionPool, SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration, int paramInt, boolean paramBoolean, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec)
  {
    paramSQLiteConnectionPool = new SQLiteConnection(paramSQLiteConnectionPool, paramSQLiteDatabaseConfiguration, paramInt, paramBoolean, paramArrayOfByte, paramSQLiteCipherSpec);
    try
    {
      paramSQLiteConnectionPool.open();
      return paramSQLiteConnectionPool;
    }
    catch (SQLiteException paramSQLiteDatabaseConfiguration)
    {
      SQLiteDebug.collectLastIOTraceStats(paramSQLiteConnectionPool);
      paramSQLiteConnectionPool.dispose(false);
      throw paramSQLiteDatabaseConfiguration;
    }
  }
  
  private void open()
  {
    this.mConnectionPtr = nativeOpen(this.mConfiguration.path, this.mConfiguration.openFlags, this.mConfiguration.vfsName);
    Object localObject = this.mPassword;
    if ((localObject != null) && (localObject.length == 0)) {
      this.mPassword = null;
    }
    localObject = this.mPassword;
    if (localObject != null)
    {
      nativeSetKey(this.mConnectionPtr, (byte[])localObject);
      setCipherSpec();
    }
    setPageSize();
    setReadOnlyFromConfiguration();
    setForeignKeyModeFromConfiguration();
    setWalModeFromConfiguration();
    setSyncModeFromConfiguration();
    setJournalSizeLimit();
    setCheckpointStrategy();
    setLocaleFromConfiguration();
    setUpdateNotificationFromConfiguration();
    int j = this.mConfiguration.customFunctions.size();
    int i = 0;
    while (i < j)
    {
      localObject = (SQLiteCustomFunction)this.mConfiguration.customFunctions.get(i);
      nativeRegisterCustomFunction(this.mConnectionPtr, (SQLiteCustomFunction)localObject);
      i += 1;
    }
  }
  
  private void recyclePreparedStatement(PreparedStatement paramPreparedStatement)
  {
    PreparedStatement.access$602(paramPreparedStatement, null);
    PreparedStatement.access$702(paramPreparedStatement, this.mPreparedStatementPool);
    this.mPreparedStatementPool = paramPreparedStatement;
  }
  
  private void resetStatement(PreparedStatement paramPreparedStatement, boolean paramBoolean)
  {
    nativeResetStatement(this.mConnectionPtr, paramPreparedStatement.getPtr(), paramBoolean);
  }
  
  private void setCheckpointStrategy()
  {
    if ((!this.mConfiguration.isInMemoryDb()) && (!this.mIsReadOnlyConnection))
    {
      if (this.mConfiguration.customWALHookEnabled)
      {
        nativeSetWalHook(this.mConnectionPtr);
        return;
      }
      if (executeForLong("PRAGMA wal_autocheckpoint", null, null) != 100L) {
        executeForLong("PRAGMA wal_autocheckpoint=100", null, null);
      }
    }
  }
  
  private void setCipherSpec()
  {
    Object localObject = this.mCipher;
    if (localObject != null)
    {
      if (((SQLiteCipherSpec)localObject).cipher != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("PRAGMA cipher=");
        ((StringBuilder)localObject).append(DatabaseUtils.sqlEscapeString(this.mCipher.cipher));
        execute(((StringBuilder)localObject).toString(), null, null);
      }
      if (this.mCipher.kdfIteration != 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("PRAGMA kdf_iter=");
        ((StringBuilder)localObject).append(this.mCipher.kdfIteration);
        execute(((StringBuilder)localObject).toString(), null, null);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PRAGMA cipher_use_hmac=");
      ((StringBuilder)localObject).append(this.mCipher.hmacEnabled);
      execute(((StringBuilder)localObject).toString(), null, null);
    }
  }
  
  private void setForeignKeyModeFromConfiguration()
  {
    if (!this.mIsReadOnlyConnection)
    {
      long l;
      if (this.mConfiguration.foreignKeyConstraintsEnabled) {
        l = 1L;
      } else {
        l = 0L;
      }
      if (executeForLong("PRAGMA foreign_keys", null, null) != l)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PRAGMA foreign_keys=");
        localStringBuilder.append(l);
        execute(localStringBuilder.toString(), null, null);
      }
    }
  }
  
  private void setJournalMode(String paramString)
  {
    String str = executeForString("PRAGMA journal_mode", null, null);
    if (!str.equalsIgnoreCase(paramString)) {}
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("PRAGMA journal_mode=");
      localStringBuilder.append(paramString);
      boolean bool = executeForString(localStringBuilder.toString(), null, null).equalsIgnoreCase(paramString);
      if (bool) {
        return;
      }
    }
    catch (SQLiteDatabaseLockedException localSQLiteDatabaseLockedException)
    {
      StringBuilder localStringBuilder;
      label64:
      break label64;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Could not change the database journal mode of '");
    localStringBuilder.append(this.mConfiguration.label);
    localStringBuilder.append("' from '");
    localStringBuilder.append(str);
    localStringBuilder.append("' to '");
    localStringBuilder.append(paramString);
    localStringBuilder.append("' because the database is locked.  This usually means that there are other open connections to the database which prevents the database from enabling or disabling write-ahead logging mode.  Proceeding without changing the journal mode.");
    Log.w("WCDB.SQLiteConnection", localStringBuilder.toString());
  }
  
  private void setJournalSizeLimit()
  {
    if ((!this.mConfiguration.isInMemoryDb()) && (!this.mIsReadOnlyConnection) && (executeForLong("PRAGMA journal_size_limit", null, null) != 524288L)) {
      executeForLong("PRAGMA journal_size_limit=524288", null, null);
    }
  }
  
  /* Error */
  private void setLocaleFromConfiguration()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 106	com/tencent/wcdb/database/SQLiteConnection:mConfiguration	Lcom/tencent/wcdb/database/SQLiteDatabaseConfiguration;
    //   4: astore_1
    //   5: aload_1
    //   6: aload_1
    //   7: getfield 113	com/tencent/wcdb/database/SQLiteDatabaseConfiguration:openFlags	I
    //   10: bipush 16
    //   12: ior
    //   13: putfield 113	com/tencent/wcdb/database/SQLiteDatabaseConfiguration:openFlags	I
    //   16: aload_0
    //   17: getfield 106	com/tencent/wcdb/database/SQLiteConnection:mConfiguration	Lcom/tencent/wcdb/database/SQLiteDatabaseConfiguration;
    //   20: getfield 113	com/tencent/wcdb/database/SQLiteDatabaseConfiguration:openFlags	I
    //   23: bipush 16
    //   25: iand
    //   26: ifeq +4 -> 30
    //   29: return
    //   30: aload_0
    //   31: getfield 106	com/tencent/wcdb/database/SQLiteConnection:mConfiguration	Lcom/tencent/wcdb/database/SQLiteDatabaseConfiguration;
    //   34: getfield 566	com/tencent/wcdb/database/SQLiteDatabaseConfiguration:locale	Ljava/util/Locale;
    //   37: invokevirtual 569	java/util/Locale:toString	()Ljava/lang/String;
    //   40: astore_1
    //   41: aload_0
    //   42: getfield 176	com/tencent/wcdb/database/SQLiteConnection:mConnectionPtr	J
    //   45: aload_1
    //   46: invokestatic 571	com/tencent/wcdb/database/SQLiteConnection:nativeRegisterLocalizedCollators	(JLjava/lang/String;)V
    //   49: aload_0
    //   50: getfield 115	com/tencent/wcdb/database/SQLiteConnection:mIsReadOnlyConnection	Z
    //   53: ifeq +4 -> 57
    //   56: return
    //   57: aload_0
    //   58: ldc_w 573
    //   61: aconst_null
    //   62: aconst_null
    //   63: invokevirtual 499	com/tencent/wcdb/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   66: aload_0
    //   67: ldc_w 575
    //   70: aconst_null
    //   71: aconst_null
    //   72: invokevirtual 531	com/tencent/wcdb/database/SQLiteConnection:executeForString	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)Ljava/lang/String;
    //   75: astore_2
    //   76: aload_2
    //   77: ifnull +12 -> 89
    //   80: aload_2
    //   81: aload_1
    //   82: invokevirtual 579	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: ifeq +4 -> 89
    //   88: return
    //   89: aload_0
    //   90: ldc_w 581
    //   93: aconst_null
    //   94: aconst_null
    //   95: invokevirtual 499	com/tencent/wcdb/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   98: aload_0
    //   99: ldc_w 583
    //   102: aconst_null
    //   103: aconst_null
    //   104: invokevirtual 499	com/tencent/wcdb/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   107: aload_0
    //   108: ldc_w 585
    //   111: iconst_1
    //   112: anewarray 4	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: aload_1
    //   118: aastore
    //   119: aconst_null
    //   120: invokevirtual 499	com/tencent/wcdb/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   123: aload_0
    //   124: ldc_w 587
    //   127: aconst_null
    //   128: aconst_null
    //   129: invokevirtual 499	com/tencent/wcdb/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   132: aload_0
    //   133: ldc_w 589
    //   136: aconst_null
    //   137: aconst_null
    //   138: invokevirtual 499	com/tencent/wcdb/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   141: return
    //   142: astore_2
    //   143: aload_0
    //   144: ldc_w 591
    //   147: aconst_null
    //   148: aconst_null
    //   149: invokevirtual 499	com/tencent/wcdb/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   152: aload_2
    //   153: athrow
    //   154: astore_2
    //   155: new 240	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   162: astore_3
    //   163: aload_3
    //   164: ldc_w 593
    //   167: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_3
    //   172: aload_0
    //   173: getfield 106	com/tencent/wcdb/database/SQLiteConnection:mConfiguration	Lcom/tencent/wcdb/database/SQLiteDatabaseConfiguration;
    //   176: getfield 542	com/tencent/wcdb/database/SQLiteDatabaseConfiguration:label	Ljava/lang/String;
    //   179: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload_3
    //   184: ldc_w 546
    //   187: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_3
    //   192: aload_1
    //   193: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload_3
    //   198: ldc_w 595
    //   201: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: new 404	com/tencent/wcdb/database/SQLiteException
    //   208: dup
    //   209: aload_3
    //   210: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: aload_2
    //   214: invokespecial 598	com/tencent/wcdb/database/SQLiteException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   217: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	SQLiteConnection
    //   4	189	1	localObject1	Object
    //   75	6	2	str	String
    //   142	11	2	localObject2	Object
    //   154	60	2	localRuntimeException	RuntimeException
    //   162	48	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   98	132	142	finally
    //   57	76	154	java/lang/RuntimeException
    //   80	88	154	java/lang/RuntimeException
    //   89	98	154	java/lang/RuntimeException
    //   132	141	154	java/lang/RuntimeException
    //   143	154	154	java/lang/RuntimeException
  }
  
  private void setPageSize()
  {
    if (!this.mConfiguration.isInMemoryDb())
    {
      String str;
      Object localObject;
      long l;
      if (this.mPassword != null)
      {
        str = "PRAGMA cipher_page_size";
        localObject = this.mCipher;
        int i;
        if ((localObject != null) && (((SQLiteCipherSpec)localObject).pageSize > 0)) {
          i = this.mCipher.pageSize;
        } else {
          i = SQLiteGlobal.defaultPageSize;
        }
        l = i;
      }
      else
      {
        str = "PRAGMA page_size";
        l = SQLiteGlobal.defaultPageSize;
      }
      if (executeForLong(str, null, null) != l)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("=");
        ((StringBuilder)localObject).append(l);
        execute(((StringBuilder)localObject).toString(), null, null);
      }
    }
  }
  
  private void setReadOnlyFromConfiguration()
  {
    if (this.mIsReadOnlyConnection) {
      execute("PRAGMA query_only = 1", null, null);
    }
  }
  
  private void setSyncModeFromConfiguration()
  {
    int i = this.mConfiguration.synchronousMode;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PRAGMA synchronous=");
    localStringBuilder.append(i);
    execute(localStringBuilder.toString(), null, null);
  }
  
  private void setUpdateNotificationFromConfiguration()
  {
    nativeSetUpdateNotification(this.mConnectionPtr, this.mConfiguration.updateNotificationEnabled, this.mConfiguration.updateNotificationRowID);
  }
  
  private void setWalModeFromConfiguration()
  {
    if ((!this.mConfiguration.isInMemoryDb()) && (!this.mIsReadOnlyConnection))
    {
      String str;
      if ((this.mConfiguration.openFlags & 0x20000000) != 0) {
        str = "WAL";
      } else {
        str = "PERSIST";
      }
      setJournalMode(str);
    }
  }
  
  private void throwIfStatementForbidden(PreparedStatement paramPreparedStatement)
  {
    if (this.mOnlyAllowReadOnlyOperations)
    {
      if (paramPreparedStatement.mReadOnly) {
        return;
      }
      throw new SQLiteException("Cannot execute this statement because it might modify the database but the connection is read-only.");
    }
  }
  
  private static String trimSqlForDisplay(String paramString)
  {
    return TRIM_SQL_PATTERN.matcher(paramString).replaceAll(" ");
  }
  
  PreparedStatement acquirePreparedStatement(String paramString)
  {
    PreparedStatement localPreparedStatement2 = (PreparedStatement)this.mPreparedStatementCache.get(paramString);
    int i;
    if (localPreparedStatement2 != null)
    {
      if (!localPreparedStatement2.mInUse)
      {
        PreparedStatement.access$402(localPreparedStatement2, true);
        return localPreparedStatement2;
      }
      i = 1;
    }
    else
    {
      i = 0;
    }
    long l = nativePrepareStatement(this.mConnectionPtr, paramString);
    PreparedStatement localPreparedStatement1 = localPreparedStatement2;
    try
    {
      int j = nativeGetParameterCount(this.mConnectionPtr, l);
      localPreparedStatement1 = localPreparedStatement2;
      int k = DatabaseUtils.getSqlStatementType(paramString);
      localPreparedStatement1 = localPreparedStatement2;
      localPreparedStatement2 = obtainPreparedStatement(paramString, l, j, k, nativeIsReadOnly(this.mConnectionPtr, l));
      if (i == 0)
      {
        localPreparedStatement1 = localPreparedStatement2;
        if (isCacheable(k))
        {
          localPreparedStatement1 = localPreparedStatement2;
          this.mPreparedStatementCache.put(paramString, localPreparedStatement2);
          localPreparedStatement1 = localPreparedStatement2;
          PreparedStatement.access$502(localPreparedStatement2, true);
        }
      }
      PreparedStatement.access$402(localPreparedStatement2, true);
      return localPreparedStatement2;
    }
    catch (RuntimeException paramString)
    {
      if ((localPreparedStatement1 == null) || (!localPreparedStatement1.mInCache)) {
        nativeFinalizeStatement(this.mConnectionPtr, l);
      }
      throw paramString;
    }
  }
  
  void close()
  {
    dispose(false);
  }
  
  /* Error */
  void collectDbStats(ArrayList<SQLiteDebug.DbStats> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 176	com/tencent/wcdb/database/SQLiteConnection:mConnectionPtr	J
    //   4: invokestatic 691	com/tencent/wcdb/database/SQLiteConnection:nativeGetDbLookaside	(J)I
    //   7: istore_2
    //   8: aload_0
    //   9: ldc_w 693
    //   12: aconst_null
    //   13: aconst_null
    //   14: invokevirtual 483	com/tencent/wcdb/database/SQLiteConnection:executeForLong	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)J
    //   17: lstore_3
    //   18: aload_0
    //   19: ldc_w 695
    //   22: aconst_null
    //   23: aconst_null
    //   24: invokevirtual 483	com/tencent/wcdb/database/SQLiteConnection:executeForLong	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)J
    //   27: lstore 5
    //   29: goto +8 -> 37
    //   32: lconst_0
    //   33: lstore_3
    //   34: lconst_0
    //   35: lstore 5
    //   37: aload_1
    //   38: aload_0
    //   39: iload_2
    //   40: lload_3
    //   41: lload 5
    //   43: invokespecial 697	com/tencent/wcdb/database/SQLiteConnection:getMainDbStatsUnsafe	(IJJ)Lcom/tencent/wcdb/database/SQLiteDebug$DbStats;
    //   46: invokevirtual 700	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   49: pop
    //   50: new 702	com/tencent/wcdb/CursorWindow
    //   53: dup
    //   54: ldc_w 703
    //   57: invokespecial 704	com/tencent/wcdb/CursorWindow:<init>	(Ljava/lang/String;)V
    //   60: astore 8
    //   62: aload_0
    //   63: ldc_w 706
    //   66: aconst_null
    //   67: aload 8
    //   69: iconst_0
    //   70: iconst_0
    //   71: iconst_0
    //   72: aconst_null
    //   73: invokevirtual 710	com/tencent/wcdb/database/SQLiteConnection:executeForCursorWindow	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/CursorWindow;IIZLcom/tencent/wcdb/support/CancellationSignal;)I
    //   76: pop
    //   77: iconst_1
    //   78: istore_2
    //   79: iload_2
    //   80: aload 8
    //   82: invokevirtual 713	com/tencent/wcdb/CursorWindow:getNumRows	()I
    //   85: if_icmpge +245 -> 330
    //   88: aload 8
    //   90: iload_2
    //   91: iconst_1
    //   92: invokevirtual 717	com/tencent/wcdb/CursorWindow:getString	(II)Ljava/lang/String;
    //   95: astore 7
    //   97: aload 8
    //   99: iload_2
    //   100: iconst_2
    //   101: invokevirtual 717	com/tencent/wcdb/CursorWindow:getString	(II)Ljava/lang/String;
    //   104: astore 9
    //   106: new 240	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   113: astore 10
    //   115: aload 10
    //   117: ldc_w 719
    //   120: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 10
    //   126: aload 7
    //   128: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 10
    //   134: ldc_w 721
    //   137: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_0
    //   142: aload 10
    //   144: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: aconst_null
    //   148: aconst_null
    //   149: invokevirtual 483	com/tencent/wcdb/database/SQLiteConnection:executeForLong	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)J
    //   152: lstore_3
    //   153: new 240	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   160: astore 10
    //   162: aload 10
    //   164: ldc_w 719
    //   167: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload 10
    //   173: aload 7
    //   175: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 10
    //   181: ldc_w 723
    //   184: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload_0
    //   189: aload 10
    //   191: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: aconst_null
    //   195: aconst_null
    //   196: invokevirtual 483	com/tencent/wcdb/database/SQLiteConnection:executeForLong	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)J
    //   199: lstore 5
    //   201: goto +8 -> 209
    //   204: lconst_0
    //   205: lstore_3
    //   206: lconst_0
    //   207: lstore 5
    //   209: new 240	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   216: astore 10
    //   218: aload 10
    //   220: ldc_w 725
    //   223: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 10
    //   229: aload 7
    //   231: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 10
    //   237: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: astore 7
    //   242: aload 9
    //   244: invokevirtual 728	java/lang/String:length	()I
    //   247: ifeq +113 -> 360
    //   250: new 240	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   257: astore 10
    //   259: aload 10
    //   261: aload 7
    //   263: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload 10
    //   269: ldc_w 730
    //   272: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload 10
    //   278: aload 9
    //   280: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload 10
    //   286: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: astore 7
    //   291: goto +3 -> 294
    //   294: aload_1
    //   295: new 300	com/tencent/wcdb/database/SQLiteDebug$DbStats
    //   298: dup
    //   299: aload 7
    //   301: lload_3
    //   302: lload 5
    //   304: iconst_0
    //   305: iconst_0
    //   306: iconst_0
    //   307: iconst_0
    //   308: invokespecial 313	com/tencent/wcdb/database/SQLiteDebug$DbStats:<init>	(Ljava/lang/String;JJIIII)V
    //   311: invokevirtual 700	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   314: pop
    //   315: iload_2
    //   316: iconst_1
    //   317: iadd
    //   318: istore_2
    //   319: goto -240 -> 79
    //   322: astore_1
    //   323: aload 8
    //   325: invokevirtual 732	com/tencent/wcdb/CursorWindow:close	()V
    //   328: aload_1
    //   329: athrow
    //   330: aload 8
    //   332: invokevirtual 732	com/tencent/wcdb/CursorWindow:close	()V
    //   335: return
    //   336: astore 7
    //   338: goto -306 -> 32
    //   341: astore 7
    //   343: goto -309 -> 34
    //   346: astore_1
    //   347: goto -17 -> 330
    //   350: astore 10
    //   352: goto -148 -> 204
    //   355: astore 10
    //   357: goto -151 -> 206
    //   360: goto -66 -> 294
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	this	SQLiteConnection
    //   0	363	1	paramArrayList	ArrayList<SQLiteDebug.DbStats>
    //   7	312	2	i	int
    //   17	285	3	l1	long
    //   27	276	5	l2	long
    //   95	205	7	str1	String
    //   336	1	7	localSQLiteException1	SQLiteException
    //   341	1	7	localSQLiteException2	SQLiteException
    //   60	271	8	localCursorWindow	com.tencent.wcdb.CursorWindow
    //   104	175	9	str2	String
    //   113	172	10	localStringBuilder	StringBuilder
    //   350	1	10	localSQLiteException3	SQLiteException
    //   355	1	10	localSQLiteException4	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   62	77	322	finally
    //   79	106	322	finally
    //   106	153	322	finally
    //   153	201	322	finally
    //   209	291	322	finally
    //   294	315	322	finally
    //   8	18	336	com/tencent/wcdb/database/SQLiteException
    //   18	29	341	com/tencent/wcdb/database/SQLiteException
    //   62	77	346	com/tencent/wcdb/database/SQLiteException
    //   79	106	346	com/tencent/wcdb/database/SQLiteException
    //   209	291	346	com/tencent/wcdb/database/SQLiteException
    //   294	315	346	com/tencent/wcdb/database/SQLiteException
    //   106	153	350	com/tencent/wcdb/database/SQLiteException
    //   153	201	355	com/tencent/wcdb/database/SQLiteException
  }
  
  void collectDbStatsUnsafe(ArrayList<SQLiteDebug.DbStats> paramArrayList)
  {
    paramArrayList.add(getMainDbStatsUnsafe(0, 0L, 0L));
  }
  
  String describeCurrentOperationUnsafe()
  {
    return this.mRecentOperations.describeCurrentOperation();
  }
  
  public void dump(Printer paramPrinter, boolean paramBoolean)
  {
    dumpUnsafe(paramPrinter, paramBoolean);
  }
  
  void dumpUnsafe(Printer paramPrinter, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Connection #");
    localStringBuilder.append(this.mConnectionId);
    localStringBuilder.append(":");
    paramPrinter.println(localStringBuilder.toString());
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("  connectionPtr: 0x");
      localStringBuilder.append(Long.toHexString(this.mConnectionPtr));
      paramPrinter.println(localStringBuilder.toString());
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("  isPrimaryConnection: ");
    localStringBuilder.append(this.mIsPrimaryConnection);
    paramPrinter.println(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("  onlyAllowReadOnlyOperations: ");
    localStringBuilder.append(this.mOnlyAllowReadOnlyOperations);
    paramPrinter.println(localStringBuilder.toString());
    if (this.mAcquiredThread != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("  acquiredThread: ");
      localStringBuilder.append(this.mAcquiredThread);
      localStringBuilder.append(" (tid: ");
      localStringBuilder.append(this.mAcquiredTid);
      localStringBuilder.append(")");
      paramPrinter.println(localStringBuilder.toString());
    }
    this.mRecentOperations.dump(paramPrinter, paramBoolean);
    if (paramBoolean) {
      this.mPreparedStatementCache.dump(paramPrinter);
    }
  }
  
  void endNativeHandle(Exception paramException)
  {
    int i = this.mNativeHandleCount - 1;
    this.mNativeHandleCount = i;
    if ((i == 0) && (this.mNativeOperation != null))
    {
      nativeSQLiteHandle(this.mConnectionPtr, false);
      if (paramException == null) {
        this.mRecentOperations.endOperationDeferLog(this.mNativeOperation.mCookie);
      } else {
        this.mRecentOperations.failOperation(this.mNativeOperation.mCookie, paramException);
      }
      this.mNativeOperation = null;
    }
  }
  
  /* Error */
  public void execute(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +172 -> 173
    //   4: aload_0
    //   5: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   8: ldc_w 795
    //   11: aload_1
    //   12: aload_2
    //   13: invokevirtual 268	com/tencent/wcdb/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$Operation;
    //   16: astore 6
    //   18: aload 6
    //   20: getfield 271	com/tencent/wcdb/database/SQLiteConnection$Operation:mCookie	I
    //   23: istore 4
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 797	com/tencent/wcdb/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   30: astore 5
    //   32: aload 6
    //   34: aload 5
    //   36: invokestatic 800	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:access$100	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   39: putfield 803	com/tencent/wcdb/database/SQLiteConnection$Operation:mType	I
    //   42: aload_0
    //   43: aload 5
    //   45: invokespecial 805	com/tencent/wcdb/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   48: aload_0
    //   49: aload 5
    //   51: aload_2
    //   52: invokespecial 166	com/tencent/wcdb/database/SQLiteConnection:bindArguments	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   55: aload_0
    //   56: aload 5
    //   58: invokespecial 807	com/tencent/wcdb/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   61: aload_0
    //   62: aload_3
    //   63: invokespecial 135	com/tencent/wcdb/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   66: aload_0
    //   67: getfield 176	com/tencent/wcdb/database/SQLiteConnection:mConnectionPtr	J
    //   70: aload 5
    //   72: invokevirtual 192	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:getPtr	()J
    //   75: invokestatic 809	com/tencent/wcdb/database/SQLiteConnection:nativeExecute	(JJ)V
    //   78: aload_0
    //   79: aload_3
    //   80: invokespecial 139	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   83: aload_0
    //   84: aload 5
    //   86: invokevirtual 812	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   89: aload_0
    //   90: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   93: iload 4
    //   95: invokevirtual 282	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   98: return
    //   99: astore_2
    //   100: aload_0
    //   101: aload_3
    //   102: invokespecial 139	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   105: aload_2
    //   106: athrow
    //   107: astore_2
    //   108: aload_0
    //   109: aload 5
    //   111: invokevirtual 812	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   114: aload_2
    //   115: athrow
    //   116: astore_1
    //   117: goto +45 -> 162
    //   120: astore_2
    //   121: aload_2
    //   122: instanceof 525
    //   125: ifne +10 -> 135
    //   128: aload_2
    //   129: instanceof 814
    //   132: ifeq +18 -> 150
    //   135: aload_0
    //   136: getfield 99	com/tencent/wcdb/database/SQLiteConnection:mPool	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   139: ifnull +11 -> 150
    //   142: aload_0
    //   143: getfield 99	com/tencent/wcdb/database/SQLiteConnection:mPool	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   146: aload_1
    //   147: invokevirtual 817	com/tencent/wcdb/database/SQLiteConnectionPool:logConnectionPoolBusy	(Ljava/lang/String;)V
    //   150: aload_0
    //   151: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   154: iload 4
    //   156: aload_2
    //   157: invokevirtual 794	com/tencent/wcdb/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   160: aload_2
    //   161: athrow
    //   162: aload_0
    //   163: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   166: iload 4
    //   168: invokevirtual 282	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   171: aload_1
    //   172: athrow
    //   173: new 819	java/lang/IllegalArgumentException
    //   176: dup
    //   177: ldc_w 821
    //   180: invokespecial 822	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	SQLiteConnection
    //   0	184	1	paramString	String
    //   0	184	2	paramArrayOfObject	Object[]
    //   0	184	3	paramCancellationSignal	CancellationSignal
    //   23	144	4	i	int
    //   30	80	5	localPreparedStatement	PreparedStatement
    //   16	17	6	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   66	78	99	finally
    //   42	66	107	finally
    //   78	83	107	finally
    //   100	107	107	finally
    //   25	42	116	finally
    //   83	89	116	finally
    //   108	116	116	finally
    //   121	135	116	finally
    //   135	150	116	finally
    //   150	162	116	finally
    //   25	42	120	java/lang/RuntimeException
    //   83	89	120	java/lang/RuntimeException
    //   108	116	120	java/lang/RuntimeException
  }
  
  /* Error */
  public int executeForChangedRowCount(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +359 -> 360
    //   4: iconst_0
    //   5: istore 6
    //   7: iconst_0
    //   8: istore 7
    //   10: iconst_0
    //   11: istore 8
    //   13: aload_0
    //   14: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   17: ldc_w 825
    //   20: aload_1
    //   21: aload_2
    //   22: invokevirtual 268	com/tencent/wcdb/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$Operation;
    //   25: astore 11
    //   27: aload 11
    //   29: getfield 271	com/tencent/wcdb/database/SQLiteConnection$Operation:mCookie	I
    //   32: istore 9
    //   34: iload 6
    //   36: istore 4
    //   38: iload 7
    //   40: istore 5
    //   42: aload_0
    //   43: aload_1
    //   44: invokevirtual 797	com/tencent/wcdb/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   47: astore 10
    //   49: iload 6
    //   51: istore 4
    //   53: iload 7
    //   55: istore 5
    //   57: aload 11
    //   59: aload 10
    //   61: invokestatic 800	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:access$100	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   64: putfield 803	com/tencent/wcdb/database/SQLiteConnection$Operation:mType	I
    //   67: iload 8
    //   69: istore 6
    //   71: aload_0
    //   72: aload 10
    //   74: invokespecial 805	com/tencent/wcdb/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   77: iload 8
    //   79: istore 6
    //   81: aload_0
    //   82: aload 10
    //   84: aload_2
    //   85: invokespecial 166	com/tencent/wcdb/database/SQLiteConnection:bindArguments	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   88: iload 8
    //   90: istore 6
    //   92: aload_0
    //   93: aload 10
    //   95: invokespecial 807	com/tencent/wcdb/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   98: iload 8
    //   100: istore 6
    //   102: aload_0
    //   103: aload_3
    //   104: invokespecial 135	com/tencent/wcdb/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   107: aload_0
    //   108: getfield 176	com/tencent/wcdb/database/SQLiteConnection:mConnectionPtr	J
    //   111: aload 10
    //   113: invokevirtual 192	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:getPtr	()J
    //   116: invokestatic 827	com/tencent/wcdb/database/SQLiteConnection:nativeExecuteForChangedRowCount	(JJ)I
    //   119: istore 7
    //   121: iload 7
    //   123: istore 6
    //   125: aload_0
    //   126: aload_3
    //   127: invokespecial 139	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   130: iload 7
    //   132: istore 4
    //   134: iload 7
    //   136: istore 5
    //   138: aload_0
    //   139: aload 10
    //   141: invokevirtual 812	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   144: aload_0
    //   145: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   148: iload 9
    //   150: invokevirtual 790	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperationDeferLog	(I)Z
    //   153: ifeq +41 -> 194
    //   156: aload_0
    //   157: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   160: astore_1
    //   161: new 240	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   168: astore_2
    //   169: aload_2
    //   170: ldc_w 829
    //   173: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_2
    //   178: iload 7
    //   180: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_1
    //   185: iload 9
    //   187: aload_2
    //   188: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokevirtual 833	com/tencent/wcdb/database/SQLiteConnection$OperationLog:logOperation	(ILjava/lang/String;)V
    //   194: iload 7
    //   196: ireturn
    //   197: astore_2
    //   198: iload 8
    //   200: istore 6
    //   202: aload_0
    //   203: aload_3
    //   204: invokespecial 139	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   207: iload 8
    //   209: istore 6
    //   211: aload_2
    //   212: athrow
    //   213: astore_2
    //   214: iload 6
    //   216: istore 4
    //   218: iload 6
    //   220: istore 5
    //   222: aload_0
    //   223: aload 10
    //   225: invokevirtual 812	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   228: iload 6
    //   230: istore 4
    //   232: iload 6
    //   234: istore 5
    //   236: aload_2
    //   237: athrow
    //   238: astore_1
    //   239: goto +69 -> 308
    //   242: astore_2
    //   243: iload 5
    //   245: istore 4
    //   247: aload_2
    //   248: instanceof 525
    //   251: ifne +14 -> 265
    //   254: iload 5
    //   256: istore 4
    //   258: aload_2
    //   259: instanceof 814
    //   262: ifeq +26 -> 288
    //   265: iload 5
    //   267: istore 4
    //   269: aload_0
    //   270: getfield 99	com/tencent/wcdb/database/SQLiteConnection:mPool	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   273: ifnull +15 -> 288
    //   276: iload 5
    //   278: istore 4
    //   280: aload_0
    //   281: getfield 99	com/tencent/wcdb/database/SQLiteConnection:mPool	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   284: aload_1
    //   285: invokevirtual 817	com/tencent/wcdb/database/SQLiteConnectionPool:logConnectionPoolBusy	(Ljava/lang/String;)V
    //   288: iload 5
    //   290: istore 4
    //   292: aload_0
    //   293: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   296: iload 9
    //   298: aload_2
    //   299: invokevirtual 794	com/tencent/wcdb/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   302: iload 5
    //   304: istore 4
    //   306: aload_2
    //   307: athrow
    //   308: aload_0
    //   309: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   312: iload 9
    //   314: invokevirtual 790	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperationDeferLog	(I)Z
    //   317: ifeq +41 -> 358
    //   320: aload_0
    //   321: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   324: astore_2
    //   325: new 240	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   332: astore_3
    //   333: aload_3
    //   334: ldc_w 829
    //   337: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload_3
    //   342: iload 4
    //   344: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload_2
    //   349: iload 9
    //   351: aload_3
    //   352: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: invokevirtual 833	com/tencent/wcdb/database/SQLiteConnection$OperationLog:logOperation	(ILjava/lang/String;)V
    //   358: aload_1
    //   359: athrow
    //   360: new 819	java/lang/IllegalArgumentException
    //   363: dup
    //   364: ldc_w 821
    //   367: invokespecial 822	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   370: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	371	0	this	SQLiteConnection
    //   0	371	1	paramString	String
    //   0	371	2	paramArrayOfObject	Object[]
    //   0	371	3	paramCancellationSignal	CancellationSignal
    //   36	307	4	i	int
    //   40	263	5	j	int
    //   5	228	6	k	int
    //   8	187	7	m	int
    //   11	197	8	n	int
    //   32	318	9	i1	int
    //   47	177	10	localPreparedStatement	PreparedStatement
    //   25	33	11	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   107	121	197	finally
    //   71	77	213	finally
    //   81	88	213	finally
    //   92	98	213	finally
    //   102	107	213	finally
    //   125	130	213	finally
    //   202	207	213	finally
    //   211	213	213	finally
    //   42	49	238	finally
    //   57	67	238	finally
    //   138	144	238	finally
    //   222	228	238	finally
    //   236	238	238	finally
    //   247	254	238	finally
    //   258	265	238	finally
    //   269	276	238	finally
    //   280	288	238	finally
    //   292	302	238	finally
    //   306	308	238	finally
    //   42	49	242	java/lang/RuntimeException
    //   57	67	242	java/lang/RuntimeException
    //   138	144	242	java/lang/RuntimeException
    //   222	228	242	java/lang/RuntimeException
    //   236	238	242	java/lang/RuntimeException
  }
  
  /* Error */
  public int executeForCursorWindow(String paramString, Object[] paramArrayOfObject, com.tencent.wcdb.CursorWindow paramCursorWindow, int paramInt1, int paramInt2, boolean paramBoolean, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +682 -> 683
    //   4: aload_3
    //   5: ifnull +667 -> 672
    //   8: aload_3
    //   9: invokevirtual 836	com/tencent/wcdb/CursorWindow:acquireReference	()V
    //   12: aload_0
    //   13: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   16: ldc_w 837
    //   19: aload_1
    //   20: aload_2
    //   21: invokevirtual 268	com/tencent/wcdb/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$Operation;
    //   24: astore 21
    //   26: aload 21
    //   28: getfield 271	com/tencent/wcdb/database/SQLiteConnection$Operation:mCookie	I
    //   31: istore 13
    //   33: iconst_m1
    //   34: istore 9
    //   36: aload_0
    //   37: aload_1
    //   38: invokevirtual 797	com/tencent/wcdb/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   41: astore 20
    //   43: aload 21
    //   45: aload 20
    //   47: invokestatic 800	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:access$100	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   50: putfield 803	com/tencent/wcdb/database/SQLiteConnection$Operation:mType	I
    //   53: aload_0
    //   54: aload 20
    //   56: invokespecial 805	com/tencent/wcdb/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   59: aload_0
    //   60: aload 20
    //   62: aload_2
    //   63: invokespecial 166	com/tencent/wcdb/database/SQLiteConnection:bindArguments	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   66: aload_0
    //   67: aload 20
    //   69: invokespecial 807	com/tencent/wcdb/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   72: aload_0
    //   73: aload 7
    //   75: invokespecial 135	com/tencent/wcdb/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   78: aload_0
    //   79: getfield 176	com/tencent/wcdb/database/SQLiteConnection:mConnectionPtr	J
    //   82: lstore 14
    //   84: aload 20
    //   86: invokevirtual 192	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:getPtr	()J
    //   89: lstore 16
    //   91: aload_3
    //   92: getfield 840	com/tencent/wcdb/CursorWindow:mWindowPtr	J
    //   95: lstore 18
    //   97: lload 14
    //   99: lload 16
    //   101: lload 18
    //   103: iload 4
    //   105: iload 5
    //   107: iload 6
    //   109: invokestatic 842	com/tencent/wcdb/database/SQLiteConnection:nativeExecuteForCursorWindow	(JJJIIZ)J
    //   112: lstore 14
    //   114: lload 14
    //   116: bipush 32
    //   118: lshr
    //   119: l2i
    //   120: istore 5
    //   122: lload 14
    //   124: l2i
    //   125: istore 8
    //   127: aload_3
    //   128: invokevirtual 713	com/tencent/wcdb/CursorWindow:getNumRows	()I
    //   131: istore 9
    //   133: aload_3
    //   134: iload 5
    //   136: invokevirtual 845	com/tencent/wcdb/CursorWindow:setStartPosition	(I)V
    //   139: aload_0
    //   140: aload 7
    //   142: invokespecial 139	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   145: aload_0
    //   146: aload 20
    //   148: invokevirtual 812	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   151: aload_0
    //   152: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   155: iload 13
    //   157: invokevirtual 790	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperationDeferLog	(I)Z
    //   160: ifeq +100 -> 260
    //   163: aload_0
    //   164: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   167: astore_1
    //   168: new 240	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   175: astore_2
    //   176: aload_2
    //   177: ldc_w 847
    //   180: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_2
    //   185: aload_3
    //   186: invokevirtual 772	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload_2
    //   191: ldc_w 849
    //   194: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_2
    //   199: iload 4
    //   201: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload_2
    //   206: ldc_w 851
    //   209: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload_2
    //   214: iload 5
    //   216: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload_2
    //   221: ldc_w 853
    //   224: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload_2
    //   229: iload 9
    //   231: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload_2
    //   236: ldc_w 855
    //   239: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload_2
    //   244: iload 8
    //   246: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_1
    //   251: iload 13
    //   253: aload_2
    //   254: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokevirtual 833	com/tencent/wcdb/database/SQLiteConnection$OperationLog:logOperation	(ILjava/lang/String;)V
    //   260: aload_3
    //   261: invokevirtual 858	com/tencent/wcdb/CursorWindow:releaseReference	()V
    //   264: iload 8
    //   266: ireturn
    //   267: astore_1
    //   268: goto +274 -> 542
    //   271: astore_2
    //   272: iload 5
    //   274: istore 10
    //   276: iload 9
    //   278: istore 5
    //   280: iload 10
    //   282: istore 9
    //   284: goto +132 -> 416
    //   287: astore_2
    //   288: iload 5
    //   290: istore 10
    //   292: iload 9
    //   294: istore 5
    //   296: iload 10
    //   298: istore 9
    //   300: goto +60 -> 360
    //   303: astore_2
    //   304: iload 5
    //   306: istore 10
    //   308: iload 9
    //   310: istore 5
    //   312: iload 10
    //   314: istore 9
    //   316: goto +25 -> 341
    //   319: astore_2
    //   320: iload 5
    //   322: istore 9
    //   324: iconst_m1
    //   325: istore 5
    //   327: goto +14 -> 341
    //   330: astore_2
    //   331: goto +4 -> 335
    //   334: astore_2
    //   335: iconst_m1
    //   336: istore 5
    //   338: iconst_m1
    //   339: istore 8
    //   341: aload_0
    //   342: aload 7
    //   344: invokespecial 139	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   347: aload_2
    //   348: athrow
    //   349: astore_2
    //   350: goto +10 -> 360
    //   353: astore_2
    //   354: iconst_m1
    //   355: istore 5
    //   357: iconst_m1
    //   358: istore 8
    //   360: iload 5
    //   362: istore 10
    //   364: iload 8
    //   366: istore 11
    //   368: iload 9
    //   370: istore 12
    //   372: aload_0
    //   373: aload 20
    //   375: invokevirtual 812	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   378: iload 5
    //   380: istore 10
    //   382: iload 8
    //   384: istore 11
    //   386: iload 9
    //   388: istore 12
    //   390: aload_2
    //   391: athrow
    //   392: astore_2
    //   393: goto +23 -> 416
    //   396: astore_1
    //   397: iconst_m1
    //   398: istore 9
    //   400: iconst_m1
    //   401: istore 8
    //   403: iconst_m1
    //   404: istore 5
    //   406: goto +136 -> 542
    //   409: astore_2
    //   410: iconst_m1
    //   411: istore 5
    //   413: iconst_m1
    //   414: istore 8
    //   416: iload 5
    //   418: istore 10
    //   420: iload 8
    //   422: istore 11
    //   424: iload 9
    //   426: istore 12
    //   428: aload_2
    //   429: instanceof 525
    //   432: ifne +22 -> 454
    //   435: iload 5
    //   437: istore 10
    //   439: iload 8
    //   441: istore 11
    //   443: iload 9
    //   445: istore 12
    //   447: aload_2
    //   448: instanceof 814
    //   451: ifeq +42 -> 493
    //   454: iload 5
    //   456: istore 10
    //   458: iload 8
    //   460: istore 11
    //   462: iload 9
    //   464: istore 12
    //   466: aload_0
    //   467: getfield 99	com/tencent/wcdb/database/SQLiteConnection:mPool	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   470: ifnull +23 -> 493
    //   473: iload 5
    //   475: istore 10
    //   477: iload 8
    //   479: istore 11
    //   481: iload 9
    //   483: istore 12
    //   485: aload_0
    //   486: getfield 99	com/tencent/wcdb/database/SQLiteConnection:mPool	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   489: aload_1
    //   490: invokevirtual 817	com/tencent/wcdb/database/SQLiteConnectionPool:logConnectionPoolBusy	(Ljava/lang/String;)V
    //   493: iload 5
    //   495: istore 10
    //   497: iload 8
    //   499: istore 11
    //   501: iload 9
    //   503: istore 12
    //   505: aload_0
    //   506: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   509: iload 13
    //   511: aload_2
    //   512: invokevirtual 794	com/tencent/wcdb/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   515: iload 5
    //   517: istore 10
    //   519: iload 8
    //   521: istore 11
    //   523: iload 9
    //   525: istore 12
    //   527: aload_2
    //   528: athrow
    //   529: astore_1
    //   530: iload 12
    //   532: istore 5
    //   534: iload 11
    //   536: istore 8
    //   538: iload 10
    //   540: istore 9
    //   542: aload_0
    //   543: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   546: iload 13
    //   548: invokevirtual 790	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperationDeferLog	(I)Z
    //   551: ifeq +112 -> 663
    //   554: aload_0
    //   555: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   558: astore_2
    //   559: new 240	java/lang/StringBuilder
    //   562: dup
    //   563: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   566: astore 7
    //   568: aload 7
    //   570: ldc_w 847
    //   573: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: aload 7
    //   579: aload_3
    //   580: invokevirtual 772	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: aload 7
    //   586: ldc_w 849
    //   589: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: aload 7
    //   595: iload 4
    //   597: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   600: pop
    //   601: aload 7
    //   603: ldc_w 851
    //   606: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: pop
    //   610: aload 7
    //   612: iload 5
    //   614: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   617: pop
    //   618: aload 7
    //   620: ldc_w 853
    //   623: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: pop
    //   627: aload 7
    //   629: iload 9
    //   631: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   634: pop
    //   635: aload 7
    //   637: ldc_w 855
    //   640: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: pop
    //   644: aload 7
    //   646: iload 8
    //   648: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   651: pop
    //   652: aload_2
    //   653: iload 13
    //   655: aload 7
    //   657: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   660: invokevirtual 833	com/tencent/wcdb/database/SQLiteConnection$OperationLog:logOperation	(ILjava/lang/String;)V
    //   663: aload_1
    //   664: athrow
    //   665: astore_1
    //   666: aload_3
    //   667: invokevirtual 858	com/tencent/wcdb/CursorWindow:releaseReference	()V
    //   670: aload_1
    //   671: athrow
    //   672: new 819	java/lang/IllegalArgumentException
    //   675: dup
    //   676: ldc_w 860
    //   679: invokespecial 822	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   682: athrow
    //   683: new 819	java/lang/IllegalArgumentException
    //   686: dup
    //   687: ldc_w 821
    //   690: invokespecial 822	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   693: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	694	0	this	SQLiteConnection
    //   0	694	1	paramString	String
    //   0	694	2	paramArrayOfObject	Object[]
    //   0	694	3	paramCursorWindow	com.tencent.wcdb.CursorWindow
    //   0	694	4	paramInt1	int
    //   0	694	5	paramInt2	int
    //   0	694	6	paramBoolean	boolean
    //   0	694	7	paramCancellationSignal	CancellationSignal
    //   125	522	8	i	int
    //   34	596	9	j	int
    //   274	265	10	k	int
    //   366	169	11	m	int
    //   370	161	12	n	int
    //   31	623	13	i1	int
    //   82	41	14	l1	long
    //   89	11	16	l2	long
    //   95	7	18	l3	long
    //   41	333	20	localPreparedStatement	PreparedStatement
    //   24	20	21	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   145	151	267	finally
    //   145	151	271	java/lang/RuntimeException
    //   139	145	287	finally
    //   133	139	303	finally
    //   127	133	319	finally
    //   97	114	330	finally
    //   78	97	334	finally
    //   341	349	349	finally
    //   53	78	353	finally
    //   372	378	392	java/lang/RuntimeException
    //   390	392	392	java/lang/RuntimeException
    //   36	53	396	finally
    //   36	53	409	java/lang/RuntimeException
    //   372	378	529	finally
    //   390	392	529	finally
    //   428	435	529	finally
    //   447	454	529	finally
    //   466	473	529	finally
    //   485	493	529	finally
    //   505	515	529	finally
    //   527	529	529	finally
    //   12	33	665	finally
    //   151	260	665	finally
    //   542	663	665	finally
    //   663	665	665	finally
  }
  
  /* Error */
  public long executeForLastInsertedRowId(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +176 -> 177
    //   4: aload_0
    //   5: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   8: ldc_w 862
    //   11: aload_1
    //   12: aload_2
    //   13: invokevirtual 268	com/tencent/wcdb/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$Operation;
    //   16: astore 8
    //   18: aload 8
    //   20: getfield 271	com/tencent/wcdb/database/SQLiteConnection$Operation:mCookie	I
    //   23: istore 4
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 797	com/tencent/wcdb/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   30: astore 7
    //   32: aload 8
    //   34: aload 7
    //   36: invokestatic 800	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:access$100	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   39: putfield 803	com/tencent/wcdb/database/SQLiteConnection$Operation:mType	I
    //   42: aload_0
    //   43: aload 7
    //   45: invokespecial 805	com/tencent/wcdb/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   48: aload_0
    //   49: aload 7
    //   51: aload_2
    //   52: invokespecial 166	com/tencent/wcdb/database/SQLiteConnection:bindArguments	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   55: aload_0
    //   56: aload 7
    //   58: invokespecial 807	com/tencent/wcdb/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   61: aload_0
    //   62: aload_3
    //   63: invokespecial 135	com/tencent/wcdb/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   66: aload_0
    //   67: getfield 176	com/tencent/wcdb/database/SQLiteConnection:mConnectionPtr	J
    //   70: aload 7
    //   72: invokevirtual 192	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:getPtr	()J
    //   75: invokestatic 864	com/tencent/wcdb/database/SQLiteConnection:nativeExecuteForLastInsertedRowId	(JJ)J
    //   78: lstore 5
    //   80: aload_0
    //   81: aload_3
    //   82: invokespecial 139	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   85: aload_0
    //   86: aload 7
    //   88: invokevirtual 812	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   91: aload_0
    //   92: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   95: iload 4
    //   97: invokevirtual 282	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   100: lload 5
    //   102: lreturn
    //   103: astore_2
    //   104: aload_0
    //   105: aload_3
    //   106: invokespecial 139	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   109: aload_2
    //   110: athrow
    //   111: astore_2
    //   112: aload_0
    //   113: aload 7
    //   115: invokevirtual 812	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   118: aload_2
    //   119: athrow
    //   120: astore_1
    //   121: goto +45 -> 166
    //   124: astore_2
    //   125: aload_2
    //   126: instanceof 525
    //   129: ifne +10 -> 139
    //   132: aload_2
    //   133: instanceof 814
    //   136: ifeq +18 -> 154
    //   139: aload_0
    //   140: getfield 99	com/tencent/wcdb/database/SQLiteConnection:mPool	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   143: ifnull +11 -> 154
    //   146: aload_0
    //   147: getfield 99	com/tencent/wcdb/database/SQLiteConnection:mPool	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   150: aload_1
    //   151: invokevirtual 817	com/tencent/wcdb/database/SQLiteConnectionPool:logConnectionPoolBusy	(Ljava/lang/String;)V
    //   154: aload_0
    //   155: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   158: iload 4
    //   160: aload_2
    //   161: invokevirtual 794	com/tencent/wcdb/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   164: aload_2
    //   165: athrow
    //   166: aload_0
    //   167: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   170: iload 4
    //   172: invokevirtual 282	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   175: aload_1
    //   176: athrow
    //   177: new 819	java/lang/IllegalArgumentException
    //   180: dup
    //   181: ldc_w 821
    //   184: invokespecial 822	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   187: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	SQLiteConnection
    //   0	188	1	paramString	String
    //   0	188	2	paramArrayOfObject	Object[]
    //   0	188	3	paramCancellationSignal	CancellationSignal
    //   23	148	4	i	int
    //   78	23	5	l	long
    //   30	84	7	localPreparedStatement	PreparedStatement
    //   16	17	8	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   66	80	103	finally
    //   42	66	111	finally
    //   80	85	111	finally
    //   104	111	111	finally
    //   25	42	120	finally
    //   85	91	120	finally
    //   112	120	120	finally
    //   125	139	120	finally
    //   139	154	120	finally
    //   154	166	120	finally
    //   25	42	124	java/lang/RuntimeException
    //   85	91	124	java/lang/RuntimeException
    //   112	120	124	java/lang/RuntimeException
  }
  
  /* Error */
  public long executeForLong(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +176 -> 177
    //   4: aload_0
    //   5: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   8: ldc_w 865
    //   11: aload_1
    //   12: aload_2
    //   13: invokevirtual 268	com/tencent/wcdb/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$Operation;
    //   16: astore 8
    //   18: aload 8
    //   20: getfield 271	com/tencent/wcdb/database/SQLiteConnection$Operation:mCookie	I
    //   23: istore 4
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 797	com/tencent/wcdb/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   30: astore 7
    //   32: aload 8
    //   34: aload 7
    //   36: invokestatic 800	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:access$100	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   39: putfield 803	com/tencent/wcdb/database/SQLiteConnection$Operation:mType	I
    //   42: aload_0
    //   43: aload 7
    //   45: invokespecial 805	com/tencent/wcdb/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   48: aload_0
    //   49: aload 7
    //   51: aload_2
    //   52: invokespecial 166	com/tencent/wcdb/database/SQLiteConnection:bindArguments	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   55: aload_0
    //   56: aload 7
    //   58: invokespecial 807	com/tencent/wcdb/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   61: aload_0
    //   62: aload_3
    //   63: invokespecial 135	com/tencent/wcdb/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   66: aload_0
    //   67: getfield 176	com/tencent/wcdb/database/SQLiteConnection:mConnectionPtr	J
    //   70: aload 7
    //   72: invokevirtual 192	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:getPtr	()J
    //   75: invokestatic 867	com/tencent/wcdb/database/SQLiteConnection:nativeExecuteForLong	(JJ)J
    //   78: lstore 5
    //   80: aload_0
    //   81: aload_3
    //   82: invokespecial 139	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   85: aload_0
    //   86: aload 7
    //   88: invokevirtual 812	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   91: aload_0
    //   92: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   95: iload 4
    //   97: invokevirtual 282	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   100: lload 5
    //   102: lreturn
    //   103: astore_2
    //   104: aload_0
    //   105: aload_3
    //   106: invokespecial 139	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   109: aload_2
    //   110: athrow
    //   111: astore_2
    //   112: aload_0
    //   113: aload 7
    //   115: invokevirtual 812	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   118: aload_2
    //   119: athrow
    //   120: astore_1
    //   121: goto +45 -> 166
    //   124: astore_2
    //   125: aload_2
    //   126: instanceof 525
    //   129: ifne +10 -> 139
    //   132: aload_2
    //   133: instanceof 814
    //   136: ifeq +18 -> 154
    //   139: aload_0
    //   140: getfield 99	com/tencent/wcdb/database/SQLiteConnection:mPool	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   143: ifnull +11 -> 154
    //   146: aload_0
    //   147: getfield 99	com/tencent/wcdb/database/SQLiteConnection:mPool	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   150: aload_1
    //   151: invokevirtual 817	com/tencent/wcdb/database/SQLiteConnectionPool:logConnectionPoolBusy	(Ljava/lang/String;)V
    //   154: aload_0
    //   155: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   158: iload 4
    //   160: aload_2
    //   161: invokevirtual 794	com/tencent/wcdb/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   164: aload_2
    //   165: athrow
    //   166: aload_0
    //   167: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   170: iload 4
    //   172: invokevirtual 282	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   175: aload_1
    //   176: athrow
    //   177: new 819	java/lang/IllegalArgumentException
    //   180: dup
    //   181: ldc_w 821
    //   184: invokespecial 822	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   187: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	SQLiteConnection
    //   0	188	1	paramString	String
    //   0	188	2	paramArrayOfObject	Object[]
    //   0	188	3	paramCancellationSignal	CancellationSignal
    //   23	148	4	i	int
    //   78	23	5	l	long
    //   30	84	7	localPreparedStatement	PreparedStatement
    //   16	17	8	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   66	80	103	finally
    //   42	66	111	finally
    //   80	85	111	finally
    //   104	111	111	finally
    //   25	42	120	finally
    //   85	91	120	finally
    //   112	120	120	finally
    //   125	139	120	finally
    //   139	154	120	finally
    //   154	166	120	finally
    //   25	42	124	java/lang/RuntimeException
    //   85	91	124	java/lang/RuntimeException
    //   112	120	124	java/lang/RuntimeException
  }
  
  /* Error */
  public String executeForString(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +174 -> 175
    //   4: aload_0
    //   5: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   8: ldc_w 868
    //   11: aload_1
    //   12: aload_2
    //   13: invokevirtual 268	com/tencent/wcdb/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$Operation;
    //   16: astore 6
    //   18: aload 6
    //   20: getfield 271	com/tencent/wcdb/database/SQLiteConnection$Operation:mCookie	I
    //   23: istore 4
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 797	com/tencent/wcdb/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   30: astore 5
    //   32: aload 6
    //   34: aload 5
    //   36: invokestatic 800	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:access$100	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   39: putfield 803	com/tencent/wcdb/database/SQLiteConnection$Operation:mType	I
    //   42: aload_0
    //   43: aload 5
    //   45: invokespecial 805	com/tencent/wcdb/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   48: aload_0
    //   49: aload 5
    //   51: aload_2
    //   52: invokespecial 166	com/tencent/wcdb/database/SQLiteConnection:bindArguments	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   55: aload_0
    //   56: aload 5
    //   58: invokespecial 807	com/tencent/wcdb/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   61: aload_0
    //   62: aload_3
    //   63: invokespecial 135	com/tencent/wcdb/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   66: aload_0
    //   67: getfield 176	com/tencent/wcdb/database/SQLiteConnection:mConnectionPtr	J
    //   70: aload 5
    //   72: invokevirtual 192	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:getPtr	()J
    //   75: invokestatic 870	com/tencent/wcdb/database/SQLiteConnection:nativeExecuteForString	(JJ)Ljava/lang/String;
    //   78: astore_2
    //   79: aload_0
    //   80: aload_3
    //   81: invokespecial 139	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   84: aload_0
    //   85: aload 5
    //   87: invokevirtual 812	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   90: aload_0
    //   91: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   94: iload 4
    //   96: invokevirtual 282	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   99: aload_2
    //   100: areturn
    //   101: astore_2
    //   102: aload_0
    //   103: aload_3
    //   104: invokespecial 139	com/tencent/wcdb/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   107: aload_2
    //   108: athrow
    //   109: astore_2
    //   110: aload_0
    //   111: aload 5
    //   113: invokevirtual 812	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   116: aload_2
    //   117: athrow
    //   118: astore_1
    //   119: goto +45 -> 164
    //   122: astore_2
    //   123: aload_2
    //   124: instanceof 525
    //   127: ifne +10 -> 137
    //   130: aload_2
    //   131: instanceof 814
    //   134: ifeq +18 -> 152
    //   137: aload_0
    //   138: getfield 99	com/tencent/wcdb/database/SQLiteConnection:mPool	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   141: ifnull +11 -> 152
    //   144: aload_0
    //   145: getfield 99	com/tencent/wcdb/database/SQLiteConnection:mPool	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   148: aload_1
    //   149: invokevirtual 817	com/tencent/wcdb/database/SQLiteConnectionPool:logConnectionPoolBusy	(Ljava/lang/String;)V
    //   152: aload_0
    //   153: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   156: iload 4
    //   158: aload_2
    //   159: invokevirtual 794	com/tencent/wcdb/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   162: aload_2
    //   163: athrow
    //   164: aload_0
    //   165: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   168: iload 4
    //   170: invokevirtual 282	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   173: aload_1
    //   174: athrow
    //   175: new 819	java/lang/IllegalArgumentException
    //   178: dup
    //   179: ldc_w 821
    //   182: invokespecial 822	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   185: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	SQLiteConnection
    //   0	186	1	paramString	String
    //   0	186	2	paramArrayOfObject	Object[]
    //   0	186	3	paramCancellationSignal	CancellationSignal
    //   23	146	4	i	int
    //   30	82	5	localPreparedStatement	PreparedStatement
    //   16	17	6	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   66	79	101	finally
    //   42	66	109	finally
    //   79	84	109	finally
    //   102	109	109	finally
    //   25	42	118	finally
    //   84	90	118	finally
    //   110	118	118	finally
    //   123	137	118	finally
    //   137	152	118	finally
    //   152	164	118	finally
    //   25	42	122	java/lang/RuntimeException
    //   84	90	122	java/lang/RuntimeException
    //   110	118	122	java/lang/RuntimeException
  }
  
  protected void finalize()
  {
    try
    {
      if ((this.mPool != null) && (this.mConnectionPtr != 0L)) {
        this.mPool.onConnectionLeaked();
      }
      dispose(true);
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int getConnectionId()
  {
    return this.mConnectionId;
  }
  
  long getNativeHandle(String paramString)
  {
    if (this.mConnectionPtr == 0L) {
      return 0L;
    }
    if ((paramString != null) && (this.mNativeOperation == null))
    {
      this.mNativeOperation = this.mRecentOperations.beginOperation(paramString, null, null);
      this.mNativeOperation.mType = 99;
    }
    this.mNativeHandleCount += 1;
    return nativeSQLiteHandle(this.mConnectionPtr, true);
  }
  
  boolean isPreparedStatementInCache(String paramString)
  {
    return this.mPreparedStatementCache.get(paramString) != null;
  }
  
  public boolean isPrimaryConnection()
  {
    return this.mIsPrimaryConnection;
  }
  
  public void onCancel()
  {
    nativeCancel(this.mConnectionPtr);
  }
  
  /* Error */
  public void prepare(String paramString, SQLiteStatementInfo paramSQLiteStatementInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +217 -> 218
    //   4: aload_0
    //   5: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   8: ldc_w 887
    //   11: aload_1
    //   12: aconst_null
    //   13: invokevirtual 268	com/tencent/wcdb/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$Operation;
    //   16: astore 7
    //   18: aload 7
    //   20: getfield 271	com/tencent/wcdb/database/SQLiteConnection$Operation:mCookie	I
    //   23: istore 4
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 797	com/tencent/wcdb/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   30: astore 6
    //   32: aload 7
    //   34: aload 6
    //   36: invokestatic 800	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:access$100	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   39: putfield 803	com/tencent/wcdb/database/SQLiteConnection$Operation:mType	I
    //   42: aload_2
    //   43: ifnull +102 -> 145
    //   46: aload_2
    //   47: aload 6
    //   49: invokestatic 188	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:access$200	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   52: putfield 892	com/tencent/wcdb/database/SQLiteStatementInfo:numParameters	I
    //   55: aload_2
    //   56: aload 6
    //   58: invokestatic 641	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:access$300	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)Z
    //   61: putfield 895	com/tencent/wcdb/database/SQLiteStatementInfo:readOnly	Z
    //   64: aload_0
    //   65: getfield 176	com/tencent/wcdb/database/SQLiteConnection:mConnectionPtr	J
    //   68: aload 6
    //   70: invokevirtual 192	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:getPtr	()J
    //   73: invokestatic 897	com/tencent/wcdb/database/SQLiteConnection:nativeGetColumnCount	(JJ)I
    //   76: istore 5
    //   78: iload 5
    //   80: ifne +13 -> 93
    //   83: aload_2
    //   84: getstatic 66	com/tencent/wcdb/database/SQLiteConnection:EMPTY_STRING_ARRAY	[Ljava/lang/String;
    //   87: putfield 900	com/tencent/wcdb/database/SQLiteStatementInfo:columnNames	[Ljava/lang/String;
    //   90: goto +55 -> 145
    //   93: aload_2
    //   94: iload 5
    //   96: anewarray 64	java/lang/String
    //   99: putfield 900	com/tencent/wcdb/database/SQLiteStatementInfo:columnNames	[Ljava/lang/String;
    //   102: iconst_0
    //   103: istore_3
    //   104: iload_3
    //   105: iload 5
    //   107: if_icmpge +38 -> 145
    //   110: aload_2
    //   111: getfield 900	com/tencent/wcdb/database/SQLiteStatementInfo:columnNames	[Ljava/lang/String;
    //   114: iload_3
    //   115: aload_0
    //   116: getfield 176	com/tencent/wcdb/database/SQLiteConnection:mConnectionPtr	J
    //   119: aload 6
    //   121: invokevirtual 192	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:getPtr	()J
    //   124: iload_3
    //   125: invokestatic 902	com/tencent/wcdb/database/SQLiteConnection:nativeGetColumnName	(JJI)Ljava/lang/String;
    //   128: aastore
    //   129: iload_3
    //   130: iconst_1
    //   131: iadd
    //   132: istore_3
    //   133: goto -29 -> 104
    //   136: astore_2
    //   137: aload_0
    //   138: aload 6
    //   140: invokevirtual 812	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   143: aload_2
    //   144: athrow
    //   145: aload_0
    //   146: aload 6
    //   148: invokevirtual 812	com/tencent/wcdb/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   151: aload_0
    //   152: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   155: iload 4
    //   157: invokevirtual 282	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   160: return
    //   161: astore_1
    //   162: goto +45 -> 207
    //   165: astore_2
    //   166: aload_2
    //   167: instanceof 525
    //   170: ifne +10 -> 180
    //   173: aload_2
    //   174: instanceof 814
    //   177: ifeq +18 -> 195
    //   180: aload_0
    //   181: getfield 99	com/tencent/wcdb/database/SQLiteConnection:mPool	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   184: ifnull +11 -> 195
    //   187: aload_0
    //   188: getfield 99	com/tencent/wcdb/database/SQLiteConnection:mPool	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   191: aload_1
    //   192: invokevirtual 817	com/tencent/wcdb/database/SQLiteConnectionPool:logConnectionPoolBusy	(Ljava/lang/String;)V
    //   195: aload_0
    //   196: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   199: iload 4
    //   201: aload_2
    //   202: invokevirtual 794	com/tencent/wcdb/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   205: aload_2
    //   206: athrow
    //   207: aload_0
    //   208: getfield 88	com/tencent/wcdb/database/SQLiteConnection:mRecentOperations	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   211: iload 4
    //   213: invokevirtual 282	com/tencent/wcdb/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   216: aload_1
    //   217: athrow
    //   218: new 819	java/lang/IllegalArgumentException
    //   221: dup
    //   222: ldc_w 821
    //   225: invokespecial 822	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   228: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	SQLiteConnection
    //   0	229	1	paramString	String
    //   0	229	2	paramSQLiteStatementInfo	SQLiteStatementInfo
    //   103	30	3	i	int
    //   23	189	4	j	int
    //   76	32	5	k	int
    //   30	117	6	localPreparedStatement	PreparedStatement
    //   16	17	7	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   46	78	136	finally
    //   83	90	136	finally
    //   93	102	136	finally
    //   110	129	136	finally
    //   25	42	161	finally
    //   137	145	161	finally
    //   145	151	161	finally
    //   166	180	161	finally
    //   180	195	161	finally
    //   195	207	161	finally
    //   25	42	165	java/lang/RuntimeException
    //   137	145	165	java/lang/RuntimeException
    //   145	151	165	java/lang/RuntimeException
  }
  
  void reconfigure(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration)
  {
    int n = 0;
    this.mOnlyAllowReadOnlyOperations = false;
    int j = paramSQLiteDatabaseConfiguration.customFunctions.size();
    int i = 0;
    while (i < j)
    {
      SQLiteCustomFunction localSQLiteCustomFunction = (SQLiteCustomFunction)paramSQLiteDatabaseConfiguration.customFunctions.get(i);
      if (!this.mConfiguration.customFunctions.contains(localSQLiteCustomFunction)) {
        nativeRegisterCustomFunction(this.mConnectionPtr, localSQLiteCustomFunction);
      }
      i += 1;
    }
    if (((paramSQLiteDatabaseConfiguration.openFlags ^ this.mConfiguration.openFlags) & 0x20000000) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramSQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled != this.mConfiguration.foreignKeyConstraintsEnabled) {
      j = 1;
    } else {
      j = 0;
    }
    boolean bool = paramSQLiteDatabaseConfiguration.locale.equals(this.mConfiguration.locale);
    int k;
    if (paramSQLiteDatabaseConfiguration.customWALHookEnabled != this.mConfiguration.customWALHookEnabled) {
      k = 1;
    } else {
      k = 0;
    }
    int m;
    if (paramSQLiteDatabaseConfiguration.synchronousMode != this.mConfiguration.synchronousMode) {
      m = 1;
    } else {
      m = 0;
    }
    if ((paramSQLiteDatabaseConfiguration.updateNotificationEnabled != this.mConfiguration.updateNotificationEnabled) || (paramSQLiteDatabaseConfiguration.updateNotificationRowID != this.mConfiguration.updateNotificationRowID)) {
      n = 1;
    }
    this.mConfiguration.updateParametersFrom(paramSQLiteDatabaseConfiguration);
    this.mPreparedStatementCache.resize(paramSQLiteDatabaseConfiguration.maxSqlCacheSize);
    if (j != 0) {
      setForeignKeyModeFromConfiguration();
    }
    if (i != 0) {
      setWalModeFromConfiguration();
    }
    if (m != 0) {
      setSyncModeFromConfiguration();
    }
    if (k != 0) {
      setCheckpointStrategy();
    }
    if ((bool ^ true)) {
      setLocaleFromConfiguration();
    }
    if (n != 0) {
      setUpdateNotificationFromConfiguration();
    }
  }
  
  void releasePreparedStatement(PreparedStatement paramPreparedStatement)
  {
    PreparedStatement.access$402(paramPreparedStatement, false);
    if (paramPreparedStatement.mInCache) {}
    try
    {
      resetStatement(paramPreparedStatement, true);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      label20:
      break label20;
    }
    this.mPreparedStatementCache.remove(paramPreparedStatement.mSql);
    return;
    finalizePreparedStatement(paramPreparedStatement);
  }
  
  void setAcquisitionState(Thread paramThread, int paramInt)
  {
    this.mAcquiredThread = paramThread;
    this.mAcquiredTid = paramInt;
  }
  
  void setOnlyAllowReadOnlyOperations(boolean paramBoolean)
  {
    this.mOnlyAllowReadOnlyOperations = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SQLiteConnection: ");
    localStringBuilder.append(this.mConfiguration.path);
    localStringBuilder.append(" (");
    localStringBuilder.append(this.mConnectionId);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public Pair<Integer, Integer> walCheckpoint(String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (!paramString.isEmpty()) {}
    }
    else
    {
      str = "main";
    }
    long l = nativeWalCheckpoint(this.mConnectionPtr, str);
    return new Pair(Integer.valueOf((int)(l >> 32)), Integer.valueOf((int)(l & 0xFFFFFFFF)));
  }
  
  @SuppressLint({"SimpleDateFormat"})
  private static final class Operation
  {
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    public ArrayList<Object> mBindArgs;
    public int mCookie;
    public long mEndTime;
    public Exception mException;
    public boolean mFinished;
    public String mKind;
    public String mSql;
    public long mStartTime;
    public int mTid;
    public int mType;
    
    private String getFormattedStartTime()
    {
      return sDateFormat.format(new Date(this.mStartTime));
    }
    
    private String getStatus()
    {
      if (!this.mFinished) {
        return "running";
      }
      if (this.mException != null) {
        return "failed";
      }
      return "succeeded";
    }
    
    public void describe(StringBuilder paramStringBuilder, boolean paramBoolean)
    {
      paramStringBuilder.append(this.mKind);
      if (this.mFinished)
      {
        paramStringBuilder.append(" took ");
        paramStringBuilder.append(this.mEndTime - this.mStartTime);
        paramStringBuilder.append("ms");
      }
      else
      {
        paramStringBuilder.append(" started ");
        paramStringBuilder.append(System.currentTimeMillis() - this.mStartTime);
        paramStringBuilder.append("ms ago");
      }
      paramStringBuilder.append(" - ");
      paramStringBuilder.append(getStatus());
      if (this.mSql != null)
      {
        paramStringBuilder.append(", sql=\"");
        paramStringBuilder.append(SQLiteConnection.trimSqlForDisplay(this.mSql));
        paramStringBuilder.append("\"");
      }
      if (this.mTid > 0)
      {
        paramStringBuilder.append(", tid=");
        paramStringBuilder.append(this.mTid);
      }
      if (paramBoolean)
      {
        localObject = this.mBindArgs;
        if ((localObject != null) && (((ArrayList)localObject).size() != 0))
        {
          paramStringBuilder.append(", bindArgs=[");
          int j = this.mBindArgs.size();
          int i = 0;
          while (i < j)
          {
            localObject = this.mBindArgs.get(i);
            if (i != 0) {
              paramStringBuilder.append(", ");
            }
            if (localObject == null)
            {
              paramStringBuilder.append("null");
            }
            else if ((localObject instanceof byte[]))
            {
              paramStringBuilder.append("<byte[]>");
            }
            else if ((localObject instanceof String))
            {
              paramStringBuilder.append("\"");
              paramStringBuilder.append((String)localObject);
              paramStringBuilder.append("\"");
            }
            else
            {
              paramStringBuilder.append(localObject);
            }
            i += 1;
          }
          paramStringBuilder.append("]");
        }
      }
      Object localObject = this.mException;
      if ((localObject != null) && (((Exception)localObject).getMessage() != null))
      {
        paramStringBuilder.append(", exception=\"");
        paramStringBuilder.append(this.mException.getMessage());
        paramStringBuilder.append("\"");
      }
    }
  }
  
  private final class OperationLog
  {
    private static final int COOKIE_GENERATION_SHIFT = 8;
    private static final int COOKIE_INDEX_MASK = 255;
    private static final int MAX_RECENT_OPERATIONS = 20;
    private int mGeneration;
    private int mIndex;
    private final SQLiteConnection.Operation[] mOperations = new SQLiteConnection.Operation[20];
    
    private OperationLog() {}
    
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
      if (paramString != null)
      {
        localStringBuilder.append(", ");
        localStringBuilder.append(paramString);
      }
      Log.i("WCDB.SQLiteConnection", localStringBuilder.toString());
    }
    
    private int newOperationCookieLocked(int paramInt)
    {
      int i = this.mGeneration;
      this.mGeneration = (i + 1);
      return paramInt | i << 8;
    }
    
    public SQLiteConnection.Operation beginOperation(String paramString1, String paramString2, Object[] paramArrayOfObject)
    {
      for (;;)
      {
        int i;
        synchronized (this.mOperations)
        {
          int j = (this.mIndex + 1) % 20;
          SQLiteConnection.Operation localOperation2 = this.mOperations[j];
          i = 0;
          SQLiteConnection.Operation localOperation1;
          if (localOperation2 == null)
          {
            localOperation1 = new SQLiteConnection.Operation(null);
            this.mOperations[j] = localOperation1;
          }
          else
          {
            localOperation2.mFinished = false;
            localOperation2.mException = null;
            localOperation1 = localOperation2;
            if (localOperation2.mBindArgs != null)
            {
              localOperation2.mBindArgs.clear();
              localOperation1 = localOperation2;
            }
          }
          localOperation1.mStartTime = System.currentTimeMillis();
          localOperation1.mKind = paramString1;
          localOperation1.mSql = paramString2;
          if (paramArrayOfObject != null)
          {
            if (localOperation1.mBindArgs == null) {
              localOperation1.mBindArgs = new ArrayList();
            } else {
              localOperation1.mBindArgs.clear();
            }
            if (i < paramArrayOfObject.length)
            {
              paramString1 = paramArrayOfObject[i];
              if ((paramString1 != null) && ((paramString1 instanceof byte[])))
              {
                localOperation1.mBindArgs.add(SQLiteConnection.EMPTY_BYTE_ARRAY);
                break label242;
              }
              localOperation1.mBindArgs.add(paramString1);
              break label242;
            }
          }
          localOperation1.mCookie = newOperationCookieLocked(j);
          localOperation1.mTid = SQLiteConnection.this.mAcquiredTid;
          this.mIndex = j;
          return localOperation1;
        }
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
            localStringBuilder.append("    ");
            localStringBuilder.append(j);
            localStringBuilder.append(": [");
            localStringBuilder.append(localOperation.getFormattedStartTime());
            localStringBuilder.append("] ");
            localOperation.describe(localStringBuilder, paramBoolean);
            paramPrinter.println(localStringBuilder.toString());
            if (i <= 0) {
              break label171;
            }
            i -= 1;
            int k = j + 1;
            localOperation = this.mOperations[i];
            if (localOperation != null)
            {
              j = k;
              if (k < 20) {
                continue;
              }
            }
          }
          else
          {
            paramPrinter.println("    <none>");
          }
          return;
        }
        label171:
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
          SQLiteConnection.this.mPool.traceExecute(str1, paramInt, l1 - l2);
        }
        return;
      }
    }
    
    public boolean endOperationDeferLog(int paramInt)
    {
      synchronized (this.mOperations)
      {
        SQLiteConnection.Operation localOperation = getOperationLocked(paramInt);
        if (localOperation == null) {
          return false;
        }
        boolean bool = endOperationDeferLogLocked(localOperation);
        String str1 = localOperation.mSql;
        String str2 = localOperation.mKind;
        paramInt = localOperation.mType;
        long l1 = localOperation.mEndTime;
        long l2 = localOperation.mStartTime;
        if (!"prepare".equals(str2)) {
          SQLiteConnection.this.mPool.traceExecute(str1, paramInt, l1 - l2);
        }
        return bool;
      }
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
  
  static final class PreparedStatement
  {
    private WeakReference<SQLiteConnection> mConnection;
    private boolean mInCache;
    private boolean mInUse;
    private int mNumParameters;
    private SQLiteConnection.Operation mOperation;
    private PreparedStatement mPoolNext;
    private boolean mReadOnly;
    private String mSql;
    private long mStatementPtr;
    private int mType;
    
    PreparedStatement(SQLiteConnection paramSQLiteConnection)
    {
      this.mConnection = new WeakReference(paramSQLiteConnection);
    }
    
    public void attachCancellationSignal(CancellationSignal paramCancellationSignal)
    {
      SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.mConnection.get();
      if (localSQLiteConnection == null) {
        return;
      }
      localSQLiteConnection.attachCancellationSignal(paramCancellationSignal);
    }
    
    public void beginOperation(String paramString, Object[] paramArrayOfObject)
    {
      SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.mConnection.get();
      if (localSQLiteConnection == null) {
        return;
      }
      this.mOperation = localSQLiteConnection.mRecentOperations.beginOperation(paramString, this.mSql, paramArrayOfObject);
      this.mOperation.mType = this.mType;
    }
    
    public void bindArguments(Object[] paramArrayOfObject)
    {
      SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.mConnection.get();
      if (localSQLiteConnection == null) {
        return;
      }
      localSQLiteConnection.bindArguments(this, paramArrayOfObject);
    }
    
    public void detachCancellationSignal(CancellationSignal paramCancellationSignal)
    {
      SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.mConnection.get();
      if (localSQLiteConnection == null) {
        return;
      }
      localSQLiteConnection.detachCancellationSignal(paramCancellationSignal);
    }
    
    public void endOperation(String paramString)
    {
      if (this.mOperation == null) {
        return;
      }
      SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.mConnection.get();
      if (localSQLiteConnection == null) {
        return;
      }
      if (localSQLiteConnection.mRecentOperations.endOperationDeferLog(this.mOperation.mCookie)) {
        localSQLiteConnection.mRecentOperations.logOperation(this.mOperation.mCookie, paramString);
      }
      this.mOperation = null;
    }
    
    public void failOperation(Exception paramException)
    {
      if (this.mOperation == null) {
        return;
      }
      SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.mConnection.get();
      if (localSQLiteConnection == null) {
        return;
      }
      localSQLiteConnection.mRecentOperations.failOperation(this.mOperation.mCookie, paramException);
    }
    
    public long getPtr()
    {
      return this.mStatementPtr;
    }
    
    public String getSQL()
    {
      return this.mSql;
    }
    
    public int getType()
    {
      return this.mType;
    }
    
    public boolean isReadOnly()
    {
      return this.mReadOnly;
    }
    
    public void reset(boolean paramBoolean)
    {
      SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.mConnection.get();
      if (localSQLiteConnection == null) {
        return;
      }
      localSQLiteConnection.resetStatement(this, paramBoolean);
    }
  }
  
  private final class PreparedStatementCache
    extends LruCache<String, SQLiteConnection.PreparedStatement>
  {
    public PreparedStatementCache(int paramInt)
    {
      super();
    }
    
    public void dump(Printer paramPrinter)
    {
      paramPrinter.println("  Prepared statement cache:");
      Object localObject1 = snapshot();
      if (!((Map)localObject1).isEmpty())
      {
        int i = 0;
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          SQLiteConnection.PreparedStatement localPreparedStatement = (SQLiteConnection.PreparedStatement)((Map.Entry)localObject2).getValue();
          if (localPreparedStatement.mInCache)
          {
            localObject2 = (String)((Map.Entry)localObject2).getKey();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("    ");
            localStringBuilder.append(i);
            localStringBuilder.append(": statementPtr=0x");
            localStringBuilder.append(Long.toHexString(localPreparedStatement.getPtr()));
            localStringBuilder.append(", numParameters=");
            localStringBuilder.append(localPreparedStatement.mNumParameters);
            localStringBuilder.append(", type=");
            localStringBuilder.append(localPreparedStatement.mType);
            localStringBuilder.append(", readOnly=");
            localStringBuilder.append(localPreparedStatement.mReadOnly);
            localStringBuilder.append(", sql=\"");
            localStringBuilder.append(SQLiteConnection.trimSqlForDisplay((String)localObject2));
            localStringBuilder.append("\"");
            paramPrinter.println(localStringBuilder.toString());
          }
          i += 1;
        }
      }
      paramPrinter.println("    <none>");
    }
    
    protected void entryRemoved(boolean paramBoolean, String paramString, SQLiteConnection.PreparedStatement paramPreparedStatement1, SQLiteConnection.PreparedStatement paramPreparedStatement2)
    {
      SQLiteConnection.PreparedStatement.access$502(paramPreparedStatement1, false);
      if (!paramPreparedStatement1.mInUse) {
        SQLiteConnection.this.finalizePreparedStatement(paramPreparedStatement1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteConnection
 * JD-Core Version:    0.7.0.1
 */