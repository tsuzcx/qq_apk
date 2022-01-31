package com.tencent.kingkong.database;

import android.util.Log;
import android.util.Printer;
import com.tencent.kingkong.DatabaseUtils;
import com.tencent.kingkong.support.CancellationSignal;
import com.tencent.kingkong.support.CancellationSignal.OnCancelListener;
import com.tencent.kingkong.support.LruCache;
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
  private static final byte[] EMPTY_BYTE_ARRAY;
  private static final String[] EMPTY_STRING_ARRAY;
  private static final String TAG = "SQLiteConnection";
  private static final Pattern TRIM_SQL_PATTERN;
  private int mArithmetic;
  private int mCancellationSignalAttachCount;
  private final SQLiteDatabaseConfiguration mConfiguration;
  private final int mConnectionId;
  private int mConnectionPtr;
  private boolean mIsInitWaited;
  private final boolean mIsPrimaryConnection;
  private final boolean mIsReadOnlyConnection;
  private boolean mOnlyAllowReadOnlyOperations;
  private String mPassword;
  private final SQLiteConnectionPool mPool;
  private final PreparedStatementCache mPreparedStatementCache;
  private PreparedStatement mPreparedStatementPool;
  private final OperationLog mRecentOperations = new OperationLog(null);
  private int mlockedDevice;
  
  static
  {
    if (!SQLiteConnection.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      EMPTY_STRING_ARRAY = new String[0];
      EMPTY_BYTE_ARRAY = new byte[0];
      TRIM_SQL_PATTERN = Pattern.compile("[\\s]*\\n+[\\s]*");
      return;
    }
  }
  
  private SQLiteConnection(SQLiteConnectionPool paramSQLiteConnectionPool, SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration, int paramInt1, boolean paramBoolean1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean2)
  {
    this.mIsInitWaited = paramBoolean2;
    this.mPassword = paramString;
    this.mArithmetic = paramInt3;
    this.mlockedDevice = paramInt2;
    this.mPool = paramSQLiteConnectionPool;
    this.mConfiguration = new SQLiteDatabaseConfiguration(paramSQLiteDatabaseConfiguration);
    this.mConnectionId = paramInt1;
    this.mIsPrimaryConnection = paramBoolean1;
    if ((paramSQLiteDatabaseConfiguration.openFlags & 0x1) != 0) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.mIsReadOnlyConnection = paramBoolean1;
      this.mPreparedStatementCache = new PreparedStatementCache(this.mConfiguration.maxSqlCacheSize);
      return;
    }
  }
  
  private PreparedStatement acquirePreparedStatement(String paramString)
  {
    PreparedStatement localPreparedStatement2 = (PreparedStatement)this.mPreparedStatementCache.get(paramString);
    int i = 0;
    if (localPreparedStatement2 != null)
    {
      if (!localPreparedStatement2.mInUse) {
        return localPreparedStatement2;
      }
      i = 1;
    }
    int j = nativePrepareStatement(this.mConnectionPtr, paramString);
    PreparedStatement localPreparedStatement1 = localPreparedStatement2;
    try
    {
      int k = nativeGetParameterCount(this.mConnectionPtr, j);
      localPreparedStatement1 = localPreparedStatement2;
      int m = DatabaseUtils.getSqlStatementType(paramString);
      localPreparedStatement1 = localPreparedStatement2;
      localPreparedStatement2 = obtainPreparedStatement(paramString, j, k, m, nativeIsReadOnly(this.mConnectionPtr, j));
      if (i == 0)
      {
        localPreparedStatement1 = localPreparedStatement2;
        if (isCacheable(m))
        {
          localPreparedStatement1 = localPreparedStatement2;
          this.mPreparedStatementCache.put(paramString, localPreparedStatement2);
          localPreparedStatement1 = localPreparedStatement2;
          localPreparedStatement2.mInCache = true;
        }
      }
      localPreparedStatement2.mInUse = true;
      return localPreparedStatement2;
    }
    catch (RuntimeException paramString)
    {
      if ((localPreparedStatement1 == null) || (!localPreparedStatement1.mInCache)) {
        nativeFinalizeStatement(this.mConnectionPtr, j);
      }
      throw paramString;
    }
  }
  
  private void applyBlockGuardPolicy(PreparedStatement paramPreparedStatement)
  {
    if (!this.mConfiguration.isInMemoryDb()) {}
  }
  
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
    if (paramArrayOfObject != null) {}
    for (int i = paramArrayOfObject.length; i != paramPreparedStatement.mNumParameters; i = 0) {
      throw new SQLiteBindOrColumnIndexOutOfRangeException("Expected " + paramPreparedStatement.mNumParameters + " bind arguments but " + i + " were provided.");
    }
    if (i == 0) {}
    int k;
    int j;
    do
    {
      return;
      k = paramPreparedStatement.mStatementPtr;
      j = 0;
    } while (j >= i);
    paramPreparedStatement = paramArrayOfObject[j];
    long l;
    switch (DatabaseUtils.getTypeOfObject(paramPreparedStatement))
    {
    case 3: 
    default: 
      if ((paramPreparedStatement instanceof Boolean))
      {
        int m = this.mConnectionPtr;
        if (((Boolean)paramPreparedStatement).booleanValue())
        {
          l = 1L;
          label154:
          nativeBindLong(m, k, j + 1, l);
        }
      }
      break;
    }
    for (;;)
    {
      j += 1;
      break;
      nativeBindNull(this.mConnectionPtr, k, j + 1);
      continue;
      nativeBindLong(this.mConnectionPtr, k, j + 1, ((Number)paramPreparedStatement).longValue());
      continue;
      nativeBindDouble(this.mConnectionPtr, k, j + 1, ((Number)paramPreparedStatement).doubleValue());
      continue;
      nativeBindBlob(this.mConnectionPtr, k, j + 1, (byte[])paramPreparedStatement);
      continue;
      l = 0L;
      break label154;
      nativeBindString(this.mConnectionPtr, k, j + 1, paramPreparedStatement.toString());
    }
  }
  
  private static String canonicalizeSyncMode(String paramString)
  {
    String str;
    if (paramString.equals("0")) {
      str = "OFF";
    }
    do
    {
      return str;
      if (paramString.equals("1")) {
        return "NORMAL";
      }
      str = paramString;
    } while (!paramString.equals("2"));
    return "FULL";
  }
  
  private void detachCancellationSignal(CancellationSignal paramCancellationSignal)
  {
    if (paramCancellationSignal != null)
    {
      assert (this.mCancellationSignalAttachCount > 0);
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
    int i;
    if (this.mConnectionPtr != 0) {
      i = this.mRecentOperations.beginOperation("close", null, null);
    }
    try
    {
      this.mPreparedStatementCache.evictAll();
      nativeClose(this.mConnectionPtr);
      this.mConnectionPtr = 0;
      return;
    }
    finally
    {
      this.mRecentOperations.endOperation(i);
    }
  }
  
  private void finalizePreparedStatement(PreparedStatement paramPreparedStatement)
  {
    nativeFinalizeStatement(this.mConnectionPtr, paramPreparedStatement.mStatementPtr);
    recyclePreparedStatement(paramPreparedStatement);
  }
  
  private SQLiteDebug.DbStats getMainDbStatsUnsafe(int paramInt, long paramLong1, long paramLong2)
  {
    String str2 = this.mConfiguration.path;
    String str1 = str2;
    if (!this.mIsPrimaryConnection) {
      str1 = str2 + " (" + this.mConnectionId + ")";
    }
    return new SQLiteDebug.DbStats(str1, paramLong1, paramLong2, paramInt, this.mPreparedStatementCache.hitCount(), this.mPreparedStatementCache.missCount(), this.mPreparedStatementCache.size());
  }
  
  private void initDb()
  {
    setForeignKeyModeFromConfiguration();
    setWalModeFromConfiguration();
    setJournalSizeLimit();
    setAutoCheckpointInterval();
    setLocaleFromConfiguration();
    int j = this.mConfiguration.customFunctions.size();
    int i = 0;
    while (i < j)
    {
      SQLiteCustomFunction localSQLiteCustomFunction = (SQLiteCustomFunction)this.mConfiguration.customFunctions.get(i);
      nativeRegisterCustomFunction(this.mConnectionPtr, localSQLiteCustomFunction);
      i += 1;
    }
  }
  
  private static boolean isCacheable(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 1);
  }
  
  private static native void nativeBindBlob(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte);
  
  private static native void nativeBindDouble(int paramInt1, int paramInt2, int paramInt3, double paramDouble);
  
  private static native void nativeBindLong(int paramInt1, int paramInt2, int paramInt3, long paramLong);
  
  private static native void nativeBindNull(int paramInt1, int paramInt2, int paramInt3);
  
  private static native void nativeBindString(int paramInt1, int paramInt2, int paramInt3, String paramString);
  
  private static native void nativeCancel(int paramInt);
  
  private static native void nativeClose(int paramInt);
  
  private static native void nativeExecute(int paramInt1, int paramInt2);
  
  private static native int nativeExecuteForBlobFileDescriptor(int paramInt1, int paramInt2);
  
  private static native int nativeExecuteForChangedRowCount(int paramInt1, int paramInt2);
  
  private static native long nativeExecuteForCursorWindow(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean);
  
  private static native long nativeExecuteForLastInsertedRowId(int paramInt1, int paramInt2);
  
  private static native long nativeExecuteForLong(int paramInt1, int paramInt2);
  
  private static native String nativeExecuteForString(int paramInt1, int paramInt2);
  
  private static native void nativeFinalizeStatement(int paramInt1, int paramInt2);
  
  private static native int nativeGetColumnCount(int paramInt1, int paramInt2);
  
  private static native String nativeGetColumnName(int paramInt1, int paramInt2, int paramInt3);
  
  private static native int nativeGetDbLookaside(int paramInt);
  
  private static native int nativeGetParameterCount(int paramInt1, int paramInt2);
  
  private static native boolean nativeIsReadOnly(int paramInt1, int paramInt2);
  
  private static native int nativeOpen(String paramString1, int paramInt, String paramString2, boolean paramBoolean1, boolean paramBoolean2);
  
  private static native int nativePrepareStatement(int paramInt, String paramString);
  
  private static native void nativeRegisterCustomFunction(int paramInt, SQLiteCustomFunction paramSQLiteCustomFunction);
  
  private static native void nativeRegisterLocalizedCollators(int paramInt, String paramString);
  
  private static native void nativeResetCancel(int paramInt, boolean paramBoolean);
  
  private static native void nativeResetStatementAndClearBindings(int paramInt1, int paramInt2);
  
  private static native void nativeSetKey(int paramInt1, int paramInt2, String paramString, int paramInt3);
  
  private PreparedStatement obtainPreparedStatement(String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    PreparedStatement localPreparedStatement = this.mPreparedStatementPool;
    if (localPreparedStatement != null)
    {
      this.mPreparedStatementPool = localPreparedStatement.mPoolNext;
      localPreparedStatement.mPoolNext = null;
      localPreparedStatement.mInCache = false;
    }
    for (;;)
    {
      localPreparedStatement.mSql = paramString;
      localPreparedStatement.mStatementPtr = paramInt1;
      localPreparedStatement.mNumParameters = paramInt2;
      localPreparedStatement.mType = paramInt3;
      localPreparedStatement.mReadOnly = paramBoolean;
      return localPreparedStatement;
      localPreparedStatement = new PreparedStatement(null);
    }
  }
  
  static SQLiteConnection open(SQLiteConnectionPool paramSQLiteConnectionPool, SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration, int paramInt1, boolean paramBoolean1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean2)
  {
    paramSQLiteConnectionPool = new SQLiteConnection(paramSQLiteConnectionPool, paramSQLiteDatabaseConfiguration, paramInt1, paramBoolean1, paramInt2, paramString, paramInt3, paramBoolean2);
    try
    {
      paramSQLiteConnectionPool.open();
      return paramSQLiteConnectionPool;
    }
    catch (SQLiteException paramSQLiteDatabaseConfiguration)
    {
      paramSQLiteConnectionPool.dispose(false);
      throw paramSQLiteDatabaseConfiguration;
    }
  }
  
  private void open()
  {
    this.mConnectionPtr = nativeOpen(this.mConfiguration.path, this.mConfiguration.openFlags, this.mConfiguration.label, SQLiteDebug.DEBUG_SQL_STATEMENTS, SQLiteDebug.DEBUG_SQL_TIME);
    setPageSize();
    nativeSetKey(this.mConnectionPtr, this.mlockedDevice, this.mPassword, this.mArithmetic);
    if (!this.mIsInitWaited) {
      initDb();
    }
  }
  
  private void recyclePreparedStatement(PreparedStatement paramPreparedStatement)
  {
    paramPreparedStatement.mSql = null;
    paramPreparedStatement.mPoolNext = this.mPreparedStatementPool;
    this.mPreparedStatementPool = paramPreparedStatement;
  }
  
  private void releasePreparedStatement(PreparedStatement paramPreparedStatement)
  {
    paramPreparedStatement.mInUse = false;
    if (paramPreparedStatement.mInCache) {
      try
      {
        nativeResetStatementAndClearBindings(this.mConnectionPtr, paramPreparedStatement.mStatementPtr);
        return;
      }
      catch (SQLiteException localSQLiteException)
      {
        this.mPreparedStatementCache.remove(paramPreparedStatement.mSql);
        return;
      }
    }
    finalizePreparedStatement(paramPreparedStatement);
  }
  
  private void setAutoCheckpointInterval()
  {
    if ((!this.mConfiguration.isInMemoryDb()) && (!this.mIsReadOnlyConnection))
    {
      long l = SQLiteGlobal.getWALAutoCheckpoint();
      if (executeForLong("PRAGMA wal_autocheckpoint", null, null) != l) {
        executeForLong("PRAGMA wal_autocheckpoint=" + l, null, null);
      }
    }
  }
  
  private void setForeignKeyModeFromConfiguration()
  {
    if (!this.mIsReadOnlyConnection) {
      if (!this.mConfiguration.foreignKeyConstraintsEnabled) {
        break label60;
      }
    }
    label60:
    for (long l = 1L;; l = 0L)
    {
      if (executeForLong("PRAGMA foreign_keys", null, null) != l) {
        execute("PRAGMA foreign_keys=" + l, null, null);
      }
      return;
    }
  }
  
  private void setJournalMode(String paramString)
  {
    String str = executeForString("PRAGMA journal_mode", null, null);
    if (!str.equalsIgnoreCase(paramString)) {}
    try
    {
      boolean bool = executeForString("PRAGMA journal_mode=" + paramString, null, null).equalsIgnoreCase(paramString);
      if (bool) {
        return;
      }
    }
    catch (SQLiteDatabaseLockedException localSQLiteDatabaseLockedException)
    {
      Log.w("SQLiteConnection", "Could not change the database journal mode of '" + this.mConfiguration.label + "' from '" + str + "' to '" + paramString + "' because the database is locked.  This usually means that " + "there are other open connections to the database which prevents " + "the database from enabling or disabling write-ahead logging mode.  " + "Proceeding without changing the journal mode.");
    }
  }
  
  private void setJournalSizeLimit()
  {
    if ((!this.mConfiguration.isInMemoryDb()) && (!this.mIsReadOnlyConnection))
    {
      long l = SQLiteGlobal.getJournalSizeLimit();
      if (executeForLong("PRAGMA journal_size_limit", null, null) != l) {
        executeForLong("PRAGMA journal_size_limit=" + l, null, null);
      }
    }
  }
  
  /* Error */
  private void setLocaleFromConfiguration()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 108	com/tencent/kingkong/database/SQLiteConnection:mConfiguration	Lcom/tencent/kingkong/database/SQLiteDatabaseConfiguration;
    //   4: astore_1
    //   5: aload_1
    //   6: aload_1
    //   7: getfield 115	com/tencent/kingkong/database/SQLiteDatabaseConfiguration:openFlags	I
    //   10: bipush 16
    //   12: ior
    //   13: putfield 115	com/tencent/kingkong/database/SQLiteDatabaseConfiguration:openFlags	I
    //   16: aload_0
    //   17: getfield 108	com/tencent/kingkong/database/SQLiteConnection:mConfiguration	Lcom/tencent/kingkong/database/SQLiteDatabaseConfiguration;
    //   20: getfield 115	com/tencent/kingkong/database/SQLiteDatabaseConfiguration:openFlags	I
    //   23: bipush 16
    //   25: iand
    //   26: ifeq +4 -> 30
    //   29: return
    //   30: aload_0
    //   31: getfield 108	com/tencent/kingkong/database/SQLiteConnection:mConfiguration	Lcom/tencent/kingkong/database/SQLiteDatabaseConfiguration;
    //   34: getfield 528	com/tencent/kingkong/database/SQLiteDatabaseConfiguration:locale	Ljava/util/Locale;
    //   37: invokevirtual 531	java/util/Locale:toString	()Ljava/lang/String;
    //   40: astore_2
    //   41: aload_0
    //   42: getfield 151	com/tencent/kingkong/database/SQLiteConnection:mConnectionPtr	I
    //   45: aload_2
    //   46: invokestatic 533	com/tencent/kingkong/database/SQLiteConnection:nativeRegisterLocalizedCollators	(ILjava/lang/String;)V
    //   49: aload_0
    //   50: getfield 117	com/tencent/kingkong/database/SQLiteConnection:mIsReadOnlyConnection	Z
    //   53: ifne -24 -> 29
    //   56: aload_0
    //   57: ldc_w 535
    //   60: aconst_null
    //   61: aconst_null
    //   62: invokevirtual 482	com/tencent/kingkong/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   65: aload_0
    //   66: ldc_w 537
    //   69: aconst_null
    //   70: aconst_null
    //   71: invokevirtual 491	com/tencent/kingkong/database/SQLiteConnection:executeForString	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/kingkong/support/CancellationSignal;)Ljava/lang/String;
    //   74: astore_1
    //   75: aload_1
    //   76: ifnull +11 -> 87
    //   79: aload_1
    //   80: aload_2
    //   81: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifne -55 -> 29
    //   87: aload_0
    //   88: ldc_w 539
    //   91: aconst_null
    //   92: aconst_null
    //   93: invokevirtual 482	com/tencent/kingkong/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   96: aload_0
    //   97: ldc_w 541
    //   100: aconst_null
    //   101: aconst_null
    //   102: invokevirtual 482	com/tencent/kingkong/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   105: aload_0
    //   106: ldc_w 543
    //   109: iconst_1
    //   110: anewarray 4	java/lang/Object
    //   113: dup
    //   114: iconst_0
    //   115: aload_2
    //   116: aastore
    //   117: aconst_null
    //   118: invokevirtual 482	com/tencent/kingkong/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   121: aload_0
    //   122: ldc_w 545
    //   125: aconst_null
    //   126: aconst_null
    //   127: invokevirtual 482	com/tencent/kingkong/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   130: iconst_1
    //   131: ifeq +67 -> 198
    //   134: ldc_w 547
    //   137: astore_1
    //   138: aload_0
    //   139: aload_1
    //   140: aconst_null
    //   141: aconst_null
    //   142: invokevirtual 482	com/tencent/kingkong/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   145: return
    //   146: astore_1
    //   147: new 423	com/tencent/kingkong/database/SQLiteException
    //   150: dup
    //   151: new 218	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   158: ldc_w 549
    //   161: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_0
    //   165: getfield 108	com/tencent/kingkong/database/SQLiteConnection:mConfiguration	Lcom/tencent/kingkong/database/SQLiteDatabaseConfiguration;
    //   168: getfield 432	com/tencent/kingkong/database/SQLiteDatabaseConfiguration:label	Ljava/lang/String;
    //   171: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: ldc_w 503
    //   177: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_2
    //   181: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: ldc_w 551
    //   187: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: aload_1
    //   194: invokespecial 554	com/tencent/kingkong/database/SQLiteException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   197: athrow
    //   198: ldc_w 556
    //   201: astore_1
    //   202: goto -64 -> 138
    //   205: aload_0
    //   206: aload_1
    //   207: aconst_null
    //   208: aconst_null
    //   209: invokevirtual 482	com/tencent/kingkong/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   212: aload_3
    //   213: athrow
    //   214: ldc_w 556
    //   217: astore_1
    //   218: goto -13 -> 205
    //   221: astore_3
    //   222: iconst_0
    //   223: ifeq -9 -> 214
    //   226: ldc_w 547
    //   229: astore_1
    //   230: goto -25 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	SQLiteConnection
    //   4	136	1	localObject1	Object
    //   146	48	1	localRuntimeException	RuntimeException
    //   201	29	1	str1	String
    //   40	141	2	str2	String
    //   212	1	3	localObject2	Object
    //   221	1	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   56	75	146	java/lang/RuntimeException
    //   79	87	146	java/lang/RuntimeException
    //   87	96	146	java/lang/RuntimeException
    //   138	145	146	java/lang/RuntimeException
    //   205	214	146	java/lang/RuntimeException
    //   96	130	221	finally
  }
  
  private void setPageSize()
  {
    if ((!this.mConfiguration.isInMemoryDb()) && (!this.mIsReadOnlyConnection))
    {
      long l = SQLiteGlobal.getDefaultPageSize();
      if (executeForLong("PRAGMA page_size", null, null) != l) {
        execute("PRAGMA page_size=" + l, null, null);
      }
    }
  }
  
  private void setSyncMode(String paramString)
  {
    if (!canonicalizeSyncMode(executeForString("PRAGMA synchronous", null, null)).equalsIgnoreCase(canonicalizeSyncMode(paramString))) {
      execute("PRAGMA synchronous=" + paramString, null, null);
    }
  }
  
  private void setWalModeFromConfiguration()
  {
    if ((!this.mConfiguration.isInMemoryDb()) && (!this.mIsReadOnlyConnection))
    {
      if ((this.mConfiguration.openFlags & 0x20000000) != 0)
      {
        setJournalMode("WAL");
        setSyncMode(SQLiteGlobal.getWALSyncMode());
      }
    }
    else {
      return;
    }
    setJournalMode(SQLiteGlobal.getDefaultJournalMode());
    setSyncMode(SQLiteGlobal.getDefaultSyncMode());
  }
  
  private void throwIfStatementForbidden(PreparedStatement paramPreparedStatement)
  {
    if ((this.mOnlyAllowReadOnlyOperations) && (!paramPreparedStatement.mReadOnly)) {
      throw new SQLiteException("Cannot execute this statement because it might modify the database but the connection is read-only.");
    }
  }
  
  private static String trimSqlForDisplay(String paramString)
  {
    return TRIM_SQL_PATTERN.matcher(paramString).replaceAll(" ");
  }
  
  void OverInitWaitedDefault()
  {
    if (this.mIsInitWaited)
    {
      boolean bool = this.mOnlyAllowReadOnlyOperations;
      if (bool) {
        this.mOnlyAllowReadOnlyOperations = false;
      }
      initDb();
      if (bool) {
        this.mOnlyAllowReadOnlyOperations = bool;
      }
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
    //   1: getfield 151	com/tencent/kingkong/database/SQLiteConnection:mConnectionPtr	I
    //   4: invokestatic 608	com/tencent/kingkong/database/SQLiteConnection:nativeGetDbLookaside	(I)I
    //   7: istore_2
    //   8: lconst_0
    //   9: lstore_3
    //   10: lconst_0
    //   11: lstore 7
    //   13: aload_0
    //   14: ldc_w 610
    //   17: aconst_null
    //   18: aconst_null
    //   19: invokevirtual 466	com/tencent/kingkong/database/SQLiteConnection:executeForLong	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/kingkong/support/CancellationSignal;)J
    //   22: lstore 5
    //   24: lload 5
    //   26: lstore_3
    //   27: aload_0
    //   28: ldc_w 612
    //   31: aconst_null
    //   32: aconst_null
    //   33: invokevirtual 466	com/tencent/kingkong/database/SQLiteConnection:executeForLong	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/kingkong/support/CancellationSignal;)J
    //   36: lstore 9
    //   38: lload 9
    //   40: lstore 7
    //   42: lload 5
    //   44: lstore_3
    //   45: aload_1
    //   46: aload_0
    //   47: iload_2
    //   48: lload_3
    //   49: lload 7
    //   51: invokespecial 614	com/tencent/kingkong/database/SQLiteConnection:getMainDbStatsUnsafe	(IJJ)Lcom/tencent/kingkong/database/SQLiteDebug$DbStats;
    //   54: invokevirtual 617	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   57: pop
    //   58: new 619	com/tencent/kingkong/CursorWindow
    //   61: dup
    //   62: ldc_w 620
    //   65: invokespecial 621	com/tencent/kingkong/CursorWindow:<init>	(Ljava/lang/String;)V
    //   68: astore 13
    //   70: aload_0
    //   71: ldc_w 623
    //   74: aconst_null
    //   75: aload 13
    //   77: iconst_0
    //   78: iconst_0
    //   79: iconst_0
    //   80: aconst_null
    //   81: invokevirtual 627	com/tencent/kingkong/database/SQLiteConnection:executeForCursorWindow	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/kingkong/CursorWindow;IIZLcom/tencent/kingkong/support/CancellationSignal;)I
    //   84: pop
    //   85: iconst_1
    //   86: istore_2
    //   87: iload_2
    //   88: aload 13
    //   90: invokevirtual 630	com/tencent/kingkong/CursorWindow:getNumRows	()I
    //   93: if_icmpge +197 -> 290
    //   96: aload 13
    //   98: iload_2
    //   99: iconst_1
    //   100: invokevirtual 633	com/tencent/kingkong/CursorWindow:getString	(II)Ljava/lang/String;
    //   103: astore 11
    //   105: aload 13
    //   107: iload_2
    //   108: iconst_2
    //   109: invokevirtual 633	com/tencent/kingkong/CursorWindow:getString	(II)Ljava/lang/String;
    //   112: astore 14
    //   114: lconst_0
    //   115: lstore_3
    //   116: lconst_0
    //   117: lstore 7
    //   119: aload_0
    //   120: new 218	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   127: ldc_w 635
    //   130: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload 11
    //   135: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc_w 637
    //   141: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: aconst_null
    //   148: aconst_null
    //   149: invokevirtual 466	com/tencent/kingkong/database/SQLiteConnection:executeForLong	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/kingkong/support/CancellationSignal;)J
    //   152: lstore 5
    //   154: lload 5
    //   156: lstore_3
    //   157: aload_0
    //   158: new 218	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   165: ldc_w 635
    //   168: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload 11
    //   173: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: ldc_w 639
    //   179: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: aconst_null
    //   186: aconst_null
    //   187: invokevirtual 466	com/tencent/kingkong/database/SQLiteConnection:executeForLong	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/kingkong/support/CancellationSignal;)J
    //   190: lstore 9
    //   192: lload 9
    //   194: lstore 7
    //   196: lload 5
    //   198: lstore_3
    //   199: new 218	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   206: ldc_w 641
    //   209: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload 11
    //   214: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: astore 12
    //   222: aload 12
    //   224: astore 11
    //   226: aload 14
    //   228: invokevirtual 644	java/lang/String:length	()I
    //   231: ifeq +31 -> 262
    //   234: new 218	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   241: aload 12
    //   243: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: ldc_w 646
    //   249: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload 14
    //   254: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: astore 11
    //   262: aload_1
    //   263: new 336	com/tencent/kingkong/database/SQLiteDebug$DbStats
    //   266: dup
    //   267: aload 11
    //   269: lload_3
    //   270: lload 7
    //   272: iconst_0
    //   273: iconst_0
    //   274: iconst_0
    //   275: iconst_0
    //   276: invokespecial 349	com/tencent/kingkong/database/SQLiteDebug$DbStats:<init>	(Ljava/lang/String;JJIIII)V
    //   279: invokevirtual 617	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   282: pop
    //   283: iload_2
    //   284: iconst_1
    //   285: iadd
    //   286: istore_2
    //   287: goto -200 -> 87
    //   290: aload 13
    //   292: invokevirtual 648	com/tencent/kingkong/CursorWindow:close	()V
    //   295: return
    //   296: astore_1
    //   297: aload 13
    //   299: invokevirtual 648	com/tencent/kingkong/CursorWindow:close	()V
    //   302: return
    //   303: astore_1
    //   304: aload 13
    //   306: invokevirtual 648	com/tencent/kingkong/CursorWindow:close	()V
    //   309: aload_1
    //   310: athrow
    //   311: astore 12
    //   313: goto -114 -> 199
    //   316: astore 11
    //   318: goto -273 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	this	SQLiteConnection
    //   0	321	1	paramArrayList	ArrayList<SQLiteDebug.DbStats>
    //   7	280	2	i	int
    //   9	261	3	l1	long
    //   22	175	5	l2	long
    //   11	260	7	l3	long
    //   36	157	9	l4	long
    //   103	165	11	localObject	Object
    //   316	1	11	localSQLiteException1	SQLiteException
    //   220	22	12	str1	String
    //   311	1	12	localSQLiteException2	SQLiteException
    //   68	237	13	localCursorWindow	com.tencent.kingkong.CursorWindow
    //   112	141	14	str2	String
    // Exception table:
    //   from	to	target	type
    //   70	85	296	com/tencent/kingkong/database/SQLiteException
    //   87	114	296	com/tencent/kingkong/database/SQLiteException
    //   199	222	296	com/tencent/kingkong/database/SQLiteException
    //   226	262	296	com/tencent/kingkong/database/SQLiteException
    //   262	283	296	com/tencent/kingkong/database/SQLiteException
    //   70	85	303	finally
    //   87	114	303	finally
    //   119	154	303	finally
    //   157	192	303	finally
    //   199	222	303	finally
    //   226	262	303	finally
    //   262	283	303	finally
    //   119	154	311	com/tencent/kingkong/database/SQLiteException
    //   157	192	311	com/tencent/kingkong/database/SQLiteException
    //   13	24	316	com/tencent/kingkong/database/SQLiteException
    //   27	38	316	com/tencent/kingkong/database/SQLiteException
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
    paramPrinter.println("Connection #" + this.mConnectionId + ":");
    if (paramBoolean) {
      paramPrinter.println("  connectionPtr: 0x" + Integer.toHexString(this.mConnectionPtr));
    }
    paramPrinter.println("  isPrimaryConnection: " + this.mIsPrimaryConnection);
    paramPrinter.println("  onlyAllowReadOnlyOperations: " + this.mOnlyAllowReadOnlyOperations);
    this.mRecentOperations.dump(paramPrinter, paramBoolean);
    if (paramBoolean) {
      this.mPreparedStatementCache.dump(paramPrinter);
    }
  }
  
  /* Error */
  public void execute(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: new 691	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 693
    //   11: invokespecial 694	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aload_0
    //   16: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   19: ldc_w 695
    //   22: aload_1
    //   23: aload_2
    //   24: invokevirtual 312	com/tencent/kingkong/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   27: istore 4
    //   29: aload_0
    //   30: aload_1
    //   31: invokespecial 697	com/tencent/kingkong/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;
    //   34: astore_1
    //   35: aload_0
    //   36: aload_1
    //   37: invokespecial 699	com/tencent/kingkong/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   40: aload_0
    //   41: aload_1
    //   42: aload_2
    //   43: invokespecial 701	com/tencent/kingkong/database/SQLiteConnection:bindArguments	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   46: aload_0
    //   47: aload_1
    //   48: invokespecial 703	com/tencent/kingkong/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   51: aload_0
    //   52: aload_3
    //   53: invokespecial 705	com/tencent/kingkong/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   56: aload_0
    //   57: getfield 151	com/tencent/kingkong/database/SQLiteConnection:mConnectionPtr	I
    //   60: aload_1
    //   61: getfield 242	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   64: invokestatic 707	com/tencent/kingkong/database/SQLiteConnection:nativeExecute	(II)V
    //   67: aload_0
    //   68: aload_3
    //   69: invokespecial 709	com/tencent/kingkong/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   72: aload_0
    //   73: aload_1
    //   74: invokespecial 711	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   77: aload_0
    //   78: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   81: iload 4
    //   83: invokevirtual 322	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   86: return
    //   87: astore_2
    //   88: aload_0
    //   89: aload_3
    //   90: invokespecial 709	com/tencent/kingkong/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   93: aload_2
    //   94: athrow
    //   95: astore_2
    //   96: aload_0
    //   97: aload_1
    //   98: invokespecial 711	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   101: aload_2
    //   102: athrow
    //   103: astore_1
    //   104: aload_0
    //   105: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   108: iload 4
    //   110: aload_1
    //   111: invokevirtual 715	com/tencent/kingkong/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   114: aload_1
    //   115: athrow
    //   116: astore_1
    //   117: aload_0
    //   118: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   121: iload 4
    //   123: invokevirtual 322	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   126: aload_1
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	SQLiteConnection
    //   0	128	1	paramString	String
    //   0	128	2	paramArrayOfObject	Object[]
    //   0	128	3	paramCancellationSignal	CancellationSignal
    //   27	95	4	i	int
    // Exception table:
    //   from	to	target	type
    //   56	67	87	finally
    //   35	56	95	finally
    //   67	72	95	finally
    //   88	95	95	finally
    //   29	35	103	java/lang/RuntimeException
    //   72	77	103	java/lang/RuntimeException
    //   96	103	103	java/lang/RuntimeException
    //   29	35	116	finally
    //   72	77	116	finally
    //   96	103	116	finally
    //   104	116	116	finally
  }
  
  /* Error */
  public com.tencent.kingkong.ParcelFileDescriptor executeForBlobFileDescriptor(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: new 691	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 693
    //   11: invokespecial 694	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aload_0
    //   16: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   19: ldc_w 718
    //   22: aload_1
    //   23: aload_2
    //   24: invokevirtual 312	com/tencent/kingkong/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   27: istore 4
    //   29: aload_0
    //   30: aload_1
    //   31: invokespecial 697	com/tencent/kingkong/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;
    //   34: astore 6
    //   36: aload_0
    //   37: aload 6
    //   39: invokespecial 699	com/tencent/kingkong/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   42: aload_0
    //   43: aload 6
    //   45: aload_2
    //   46: invokespecial 701	com/tencent/kingkong/database/SQLiteConnection:bindArguments	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   49: aload_0
    //   50: aload 6
    //   52: invokespecial 703	com/tencent/kingkong/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   55: aload_0
    //   56: aload_3
    //   57: invokespecial 705	com/tencent/kingkong/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   60: aload_0
    //   61: getfield 151	com/tencent/kingkong/database/SQLiteConnection:mConnectionPtr	I
    //   64: aload 6
    //   66: getfield 242	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   69: invokestatic 720	com/tencent/kingkong/database/SQLiteConnection:nativeExecuteForBlobFileDescriptor	(II)I
    //   72: istore 5
    //   74: iload 5
    //   76: iflt +31 -> 107
    //   79: iload 5
    //   81: invokestatic 726	com/tencent/kingkong/ParcelFileDescriptor:adoptFd	(I)Lcom/tencent/kingkong/ParcelFileDescriptor;
    //   84: astore_1
    //   85: aload_0
    //   86: aload_3
    //   87: invokespecial 709	com/tencent/kingkong/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   90: aload_0
    //   91: aload 6
    //   93: invokespecial 711	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   96: aload_0
    //   97: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   100: iload 4
    //   102: invokevirtual 322	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   105: aload_1
    //   106: areturn
    //   107: aconst_null
    //   108: astore_1
    //   109: goto -24 -> 85
    //   112: astore_1
    //   113: aload_0
    //   114: aload_3
    //   115: invokespecial 709	com/tencent/kingkong/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   118: aload_1
    //   119: athrow
    //   120: astore_1
    //   121: aload_0
    //   122: aload 6
    //   124: invokespecial 711	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   127: aload_1
    //   128: athrow
    //   129: astore_1
    //   130: aload_0
    //   131: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   134: iload 4
    //   136: aload_1
    //   137: invokevirtual 715	com/tencent/kingkong/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   140: aload_1
    //   141: athrow
    //   142: astore_1
    //   143: aload_0
    //   144: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   147: iload 4
    //   149: invokevirtual 322	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   152: aload_1
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	SQLiteConnection
    //   0	154	1	paramString	String
    //   0	154	2	paramArrayOfObject	Object[]
    //   0	154	3	paramCancellationSignal	CancellationSignal
    //   27	121	4	i	int
    //   72	8	5	j	int
    //   34	89	6	localPreparedStatement	PreparedStatement
    // Exception table:
    //   from	to	target	type
    //   60	74	112	finally
    //   79	85	112	finally
    //   36	60	120	finally
    //   85	90	120	finally
    //   113	120	120	finally
    //   29	36	129	java/lang/RuntimeException
    //   90	96	129	java/lang/RuntimeException
    //   121	129	129	java/lang/RuntimeException
    //   29	36	142	finally
    //   90	96	142	finally
    //   121	129	142	finally
    //   130	142	142	finally
  }
  
  /* Error */
  public int executeForChangedRowCount(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: new 691	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 693
    //   11: invokespecial 694	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: iconst_0
    //   16: istore 4
    //   18: iconst_0
    //   19: istore 6
    //   21: iconst_0
    //   22: istore 7
    //   24: aload_0
    //   25: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   28: ldc_w 729
    //   31: aload_1
    //   32: aload_2
    //   33: invokevirtual 312	com/tencent/kingkong/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   36: istore 8
    //   38: aload_0
    //   39: aload_1
    //   40: invokespecial 697	com/tencent/kingkong/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;
    //   43: astore_1
    //   44: iload 7
    //   46: istore 5
    //   48: aload_0
    //   49: aload_1
    //   50: invokespecial 699	com/tencent/kingkong/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   53: iload 7
    //   55: istore 5
    //   57: aload_0
    //   58: aload_1
    //   59: aload_2
    //   60: invokespecial 701	com/tencent/kingkong/database/SQLiteConnection:bindArguments	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   63: iload 7
    //   65: istore 5
    //   67: aload_0
    //   68: aload_1
    //   69: invokespecial 703	com/tencent/kingkong/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   72: iload 7
    //   74: istore 5
    //   76: aload_0
    //   77: aload_3
    //   78: invokespecial 705	com/tencent/kingkong/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   81: aload_0
    //   82: getfield 151	com/tencent/kingkong/database/SQLiteConnection:mConnectionPtr	I
    //   85: aload_1
    //   86: getfield 242	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   89: invokestatic 731	com/tencent/kingkong/database/SQLiteConnection:nativeExecuteForChangedRowCount	(II)I
    //   92: istore 4
    //   94: iload 4
    //   96: istore 7
    //   98: iload 7
    //   100: istore 5
    //   102: aload_0
    //   103: aload_3
    //   104: invokespecial 709	com/tencent/kingkong/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   107: iload 7
    //   109: istore 4
    //   111: iload 7
    //   113: istore 6
    //   115: aload_0
    //   116: aload_1
    //   117: invokespecial 711	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   120: aload_0
    //   121: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   124: iload 8
    //   126: invokevirtual 734	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperationDeferLog	(I)Z
    //   129: ifeq +33 -> 162
    //   132: aload_0
    //   133: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   136: iload 8
    //   138: new 218	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   145: ldc_w 736
    //   148: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: iload 7
    //   153: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokevirtual 739	com/tencent/kingkong/database/SQLiteConnection$OperationLog:logOperation	(ILjava/lang/String;)V
    //   162: iload 7
    //   164: ireturn
    //   165: astore_2
    //   166: iload 7
    //   168: istore 5
    //   170: aload_0
    //   171: aload_3
    //   172: invokespecial 709	com/tencent/kingkong/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   175: iload 7
    //   177: istore 5
    //   179: aload_2
    //   180: athrow
    //   181: astore_2
    //   182: iload 5
    //   184: istore 4
    //   186: iload 5
    //   188: istore 6
    //   190: aload_0
    //   191: aload_1
    //   192: invokespecial 711	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   195: iload 5
    //   197: istore 4
    //   199: iload 5
    //   201: istore 6
    //   203: aload_2
    //   204: athrow
    //   205: astore_1
    //   206: iload 4
    //   208: istore 6
    //   210: aload_0
    //   211: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   214: iload 8
    //   216: aload_1
    //   217: invokevirtual 715	com/tencent/kingkong/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   220: iload 4
    //   222: istore 6
    //   224: aload_1
    //   225: athrow
    //   226: astore_1
    //   227: aload_0
    //   228: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   231: iload 8
    //   233: invokevirtual 734	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperationDeferLog	(I)Z
    //   236: ifeq +33 -> 269
    //   239: aload_0
    //   240: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   243: iload 8
    //   245: new 218	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   252: ldc_w 736
    //   255: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: iload 6
    //   260: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   263: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokevirtual 739	com/tencent/kingkong/database/SQLiteConnection$OperationLog:logOperation	(ILjava/lang/String;)V
    //   269: aload_1
    //   270: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	SQLiteConnection
    //   0	271	1	paramString	String
    //   0	271	2	paramArrayOfObject	Object[]
    //   0	271	3	paramCancellationSignal	CancellationSignal
    //   16	205	4	i	int
    //   46	154	5	j	int
    //   19	240	6	k	int
    //   22	154	7	m	int
    //   36	208	8	n	int
    // Exception table:
    //   from	to	target	type
    //   81	94	165	finally
    //   48	53	181	finally
    //   57	63	181	finally
    //   67	72	181	finally
    //   76	81	181	finally
    //   102	107	181	finally
    //   170	175	181	finally
    //   179	181	181	finally
    //   38	44	205	java/lang/RuntimeException
    //   115	120	205	java/lang/RuntimeException
    //   190	195	205	java/lang/RuntimeException
    //   203	205	205	java/lang/RuntimeException
    //   38	44	226	finally
    //   115	120	226	finally
    //   190	195	226	finally
    //   203	205	226	finally
    //   210	220	226	finally
    //   224	226	226	finally
  }
  
  /* Error */
  public int executeForCursorWindow(String paramString, Object[] paramArrayOfObject, com.tencent.kingkong.CursorWindow paramCursorWindow, int paramInt1, int paramInt2, boolean paramBoolean, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: new 691	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 693
    //   11: invokespecial 694	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aload_3
    //   16: ifnonnull +14 -> 30
    //   19: new 691	java/lang/IllegalArgumentException
    //   22: dup
    //   23: ldc_w 741
    //   26: invokespecial 694	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   29: athrow
    //   30: aload_3
    //   31: invokevirtual 744	com/tencent/kingkong/CursorWindow:acquireReference	()V
    //   34: iconst_m1
    //   35: istore 19
    //   37: iconst_m1
    //   38: istore 12
    //   40: iconst_m1
    //   41: istore 11
    //   43: aload_0
    //   44: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   47: ldc_w 745
    //   50: aload_1
    //   51: aload_2
    //   52: invokevirtual 312	com/tencent/kingkong/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   55: istore 20
    //   57: iload 19
    //   59: istore 13
    //   61: iload 12
    //   63: istore 14
    //   65: iload 11
    //   67: istore 15
    //   69: iload 19
    //   71: istore 16
    //   73: iload 12
    //   75: istore 17
    //   77: iload 11
    //   79: istore 18
    //   81: aload_0
    //   82: aload_1
    //   83: invokespecial 697	com/tencent/kingkong/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;
    //   86: astore_1
    //   87: iload 19
    //   89: istore 8
    //   91: iload 12
    //   93: istore 9
    //   95: iload 11
    //   97: istore 10
    //   99: aload_0
    //   100: aload_1
    //   101: invokespecial 699	com/tencent/kingkong/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   104: iload 19
    //   106: istore 8
    //   108: iload 12
    //   110: istore 9
    //   112: iload 11
    //   114: istore 10
    //   116: aload_0
    //   117: aload_1
    //   118: aload_2
    //   119: invokespecial 701	com/tencent/kingkong/database/SQLiteConnection:bindArguments	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   122: iload 19
    //   124: istore 8
    //   126: iload 12
    //   128: istore 9
    //   130: iload 11
    //   132: istore 10
    //   134: aload_0
    //   135: aload_1
    //   136: invokespecial 703	com/tencent/kingkong/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   139: iload 19
    //   141: istore 8
    //   143: iload 12
    //   145: istore 9
    //   147: iload 11
    //   149: istore 10
    //   151: aload_0
    //   152: aload 7
    //   154: invokespecial 705	com/tencent/kingkong/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   157: iload 12
    //   159: istore 13
    //   161: iload 11
    //   163: istore 14
    //   165: aload_0
    //   166: getfield 151	com/tencent/kingkong/database/SQLiteConnection:mConnectionPtr	I
    //   169: aload_1
    //   170: getfield 242	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   173: aload_3
    //   174: getfield 748	com/tencent/kingkong/CursorWindow:mWindowPtr	I
    //   177: iload 4
    //   179: iload 5
    //   181: iload 6
    //   183: invokestatic 750	com/tencent/kingkong/database/SQLiteConnection:nativeExecuteForCursorWindow	(IIIIIZ)J
    //   186: lstore 21
    //   188: lload 21
    //   190: bipush 32
    //   192: lshr
    //   193: l2i
    //   194: istore 5
    //   196: lload 21
    //   198: l2i
    //   199: istore 12
    //   201: iload 5
    //   203: istore 19
    //   205: iload 12
    //   207: istore 13
    //   209: iload 11
    //   211: istore 14
    //   213: aload_3
    //   214: invokevirtual 630	com/tencent/kingkong/CursorWindow:getNumRows	()I
    //   217: istore 11
    //   219: iload 5
    //   221: istore 19
    //   223: iload 12
    //   225: istore 13
    //   227: iload 11
    //   229: istore 14
    //   231: aload_3
    //   232: iload 5
    //   234: invokevirtual 753	com/tencent/kingkong/CursorWindow:setStartPosition	(I)V
    //   237: iload 5
    //   239: istore 8
    //   241: iload 12
    //   243: istore 9
    //   245: iload 11
    //   247: istore 10
    //   249: aload_0
    //   250: aload 7
    //   252: invokespecial 709	com/tencent/kingkong/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   255: iload 5
    //   257: istore 13
    //   259: iload 12
    //   261: istore 14
    //   263: iload 11
    //   265: istore 15
    //   267: iload 5
    //   269: istore 16
    //   271: iload 12
    //   273: istore 17
    //   275: iload 11
    //   277: istore 18
    //   279: aload_0
    //   280: aload_1
    //   281: invokespecial 711	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   284: aload_0
    //   285: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   288: iload 20
    //   290: invokevirtual 734	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperationDeferLog	(I)Z
    //   293: ifeq +76 -> 369
    //   296: aload_0
    //   297: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   300: iload 20
    //   302: new 218	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   309: ldc_w 755
    //   312: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload_3
    //   316: invokevirtual 758	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   319: ldc_w 760
    //   322: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: iload 4
    //   327: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   330: ldc_w 762
    //   333: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: iload 5
    //   338: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   341: ldc_w 764
    //   344: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: iload 11
    //   349: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   352: ldc_w 766
    //   355: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: iload 12
    //   360: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   363: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokevirtual 739	com/tencent/kingkong/database/SQLiteConnection$OperationLog:logOperation	(ILjava/lang/String;)V
    //   369: aload_3
    //   370: invokevirtual 769	com/tencent/kingkong/CursorWindow:releaseReference	()V
    //   373: iload 12
    //   375: ireturn
    //   376: astore_2
    //   377: iload 19
    //   379: istore 8
    //   381: iload 13
    //   383: istore 9
    //   385: iload 14
    //   387: istore 10
    //   389: aload_0
    //   390: aload 7
    //   392: invokespecial 709	com/tencent/kingkong/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   395: iload 19
    //   397: istore 8
    //   399: iload 13
    //   401: istore 9
    //   403: iload 14
    //   405: istore 10
    //   407: aload_2
    //   408: athrow
    //   409: astore_2
    //   410: iload 8
    //   412: istore 13
    //   414: iload 9
    //   416: istore 14
    //   418: iload 10
    //   420: istore 15
    //   422: iload 8
    //   424: istore 16
    //   426: iload 9
    //   428: istore 17
    //   430: iload 10
    //   432: istore 18
    //   434: aload_0
    //   435: aload_1
    //   436: invokespecial 711	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   439: iload 8
    //   441: istore 13
    //   443: iload 9
    //   445: istore 14
    //   447: iload 10
    //   449: istore 15
    //   451: iload 8
    //   453: istore 16
    //   455: iload 9
    //   457: istore 17
    //   459: iload 10
    //   461: istore 18
    //   463: aload_2
    //   464: athrow
    //   465: astore_1
    //   466: iload 13
    //   468: istore 16
    //   470: iload 14
    //   472: istore 17
    //   474: iload 15
    //   476: istore 18
    //   478: aload_0
    //   479: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   482: iload 20
    //   484: aload_1
    //   485: invokevirtual 715	com/tencent/kingkong/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   488: iload 13
    //   490: istore 16
    //   492: iload 14
    //   494: istore 17
    //   496: iload 15
    //   498: istore 18
    //   500: aload_1
    //   501: athrow
    //   502: astore_1
    //   503: aload_0
    //   504: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   507: iload 20
    //   509: invokevirtual 734	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperationDeferLog	(I)Z
    //   512: ifeq +76 -> 588
    //   515: aload_0
    //   516: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   519: iload 20
    //   521: new 218	java/lang/StringBuilder
    //   524: dup
    //   525: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   528: ldc_w 755
    //   531: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload_3
    //   535: invokevirtual 758	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   538: ldc_w 760
    //   541: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: iload 4
    //   546: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   549: ldc_w 762
    //   552: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: iload 16
    //   557: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   560: ldc_w 764
    //   563: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: iload 18
    //   568: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   571: ldc_w 766
    //   574: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: iload 17
    //   579: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   582: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   585: invokevirtual 739	com/tencent/kingkong/database/SQLiteConnection$OperationLog:logOperation	(ILjava/lang/String;)V
    //   588: aload_1
    //   589: athrow
    //   590: astore_1
    //   591: aload_3
    //   592: invokevirtual 769	com/tencent/kingkong/CursorWindow:releaseReference	()V
    //   595: aload_1
    //   596: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	597	0	this	SQLiteConnection
    //   0	597	1	paramString	String
    //   0	597	2	paramArrayOfObject	Object[]
    //   0	597	3	paramCursorWindow	com.tencent.kingkong.CursorWindow
    //   0	597	4	paramInt1	int
    //   0	597	5	paramInt2	int
    //   0	597	6	paramBoolean	boolean
    //   0	597	7	paramCancellationSignal	CancellationSignal
    //   89	363	8	i	int
    //   93	363	9	j	int
    //   97	363	10	k	int
    //   41	307	11	m	int
    //   38	336	12	n	int
    //   59	430	13	i1	int
    //   63	430	14	i2	int
    //   67	430	15	i3	int
    //   71	485	16	i4	int
    //   75	503	17	i5	int
    //   79	488	18	i6	int
    //   35	361	19	i7	int
    //   55	465	20	i8	int
    //   186	11	21	l	long
    // Exception table:
    //   from	to	target	type
    //   165	188	376	finally
    //   213	219	376	finally
    //   231	237	376	finally
    //   99	104	409	finally
    //   116	122	409	finally
    //   134	139	409	finally
    //   151	157	409	finally
    //   249	255	409	finally
    //   389	395	409	finally
    //   407	409	409	finally
    //   81	87	465	java/lang/RuntimeException
    //   279	284	465	java/lang/RuntimeException
    //   434	439	465	java/lang/RuntimeException
    //   463	465	465	java/lang/RuntimeException
    //   81	87	502	finally
    //   279	284	502	finally
    //   434	439	502	finally
    //   463	465	502	finally
    //   478	488	502	finally
    //   500	502	502	finally
    //   43	57	590	finally
    //   284	369	590	finally
    //   503	588	590	finally
    //   588	590	590	finally
  }
  
  /* Error */
  public long executeForLastInsertedRowId(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: new 691	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 693
    //   11: invokespecial 694	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aload_0
    //   16: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   19: ldc_w 771
    //   22: aload_1
    //   23: aload_2
    //   24: invokevirtual 312	com/tencent/kingkong/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   27: istore 4
    //   29: aload_0
    //   30: aload_1
    //   31: invokespecial 697	com/tencent/kingkong/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;
    //   34: astore_1
    //   35: aload_0
    //   36: aload_1
    //   37: invokespecial 699	com/tencent/kingkong/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   40: aload_0
    //   41: aload_1
    //   42: aload_2
    //   43: invokespecial 701	com/tencent/kingkong/database/SQLiteConnection:bindArguments	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   46: aload_0
    //   47: aload_1
    //   48: invokespecial 703	com/tencent/kingkong/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   51: aload_0
    //   52: aload_3
    //   53: invokespecial 705	com/tencent/kingkong/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   56: aload_0
    //   57: getfield 151	com/tencent/kingkong/database/SQLiteConnection:mConnectionPtr	I
    //   60: aload_1
    //   61: getfield 242	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   64: invokestatic 773	com/tencent/kingkong/database/SQLiteConnection:nativeExecuteForLastInsertedRowId	(II)J
    //   67: lstore 5
    //   69: aload_0
    //   70: aload_3
    //   71: invokespecial 709	com/tencent/kingkong/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   74: aload_0
    //   75: aload_1
    //   76: invokespecial 711	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   79: aload_0
    //   80: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   83: iload 4
    //   85: invokevirtual 322	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   88: lload 5
    //   90: lreturn
    //   91: astore_2
    //   92: aload_0
    //   93: aload_3
    //   94: invokespecial 709	com/tencent/kingkong/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   97: aload_2
    //   98: athrow
    //   99: astore_2
    //   100: aload_0
    //   101: aload_1
    //   102: invokespecial 711	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   105: aload_2
    //   106: athrow
    //   107: astore_1
    //   108: aload_0
    //   109: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   112: iload 4
    //   114: aload_1
    //   115: invokevirtual 715	com/tencent/kingkong/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   118: aload_1
    //   119: athrow
    //   120: astore_1
    //   121: aload_0
    //   122: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   125: iload 4
    //   127: invokevirtual 322	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   130: aload_1
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	SQLiteConnection
    //   0	132	1	paramString	String
    //   0	132	2	paramArrayOfObject	Object[]
    //   0	132	3	paramCancellationSignal	CancellationSignal
    //   27	99	4	i	int
    //   67	22	5	l	long
    // Exception table:
    //   from	to	target	type
    //   56	69	91	finally
    //   35	56	99	finally
    //   69	74	99	finally
    //   92	99	99	finally
    //   29	35	107	java/lang/RuntimeException
    //   74	79	107	java/lang/RuntimeException
    //   100	107	107	java/lang/RuntimeException
    //   29	35	120	finally
    //   74	79	120	finally
    //   100	107	120	finally
    //   108	120	120	finally
  }
  
  /* Error */
  public long executeForLong(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: new 691	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 693
    //   11: invokespecial 694	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aload_0
    //   16: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   19: ldc_w 774
    //   22: aload_1
    //   23: aload_2
    //   24: invokevirtual 312	com/tencent/kingkong/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   27: istore 4
    //   29: aload_0
    //   30: aload_1
    //   31: invokespecial 697	com/tencent/kingkong/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;
    //   34: astore_1
    //   35: aload_0
    //   36: aload_1
    //   37: invokespecial 699	com/tencent/kingkong/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   40: aload_0
    //   41: aload_1
    //   42: aload_2
    //   43: invokespecial 701	com/tencent/kingkong/database/SQLiteConnection:bindArguments	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   46: aload_0
    //   47: aload_1
    //   48: invokespecial 703	com/tencent/kingkong/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   51: aload_0
    //   52: aload_3
    //   53: invokespecial 705	com/tencent/kingkong/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   56: aload_0
    //   57: getfield 151	com/tencent/kingkong/database/SQLiteConnection:mConnectionPtr	I
    //   60: aload_1
    //   61: getfield 242	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   64: invokestatic 776	com/tencent/kingkong/database/SQLiteConnection:nativeExecuteForLong	(II)J
    //   67: lstore 5
    //   69: aload_0
    //   70: aload_3
    //   71: invokespecial 709	com/tencent/kingkong/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   74: aload_0
    //   75: aload_1
    //   76: invokespecial 711	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   79: aload_0
    //   80: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   83: iload 4
    //   85: invokevirtual 322	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   88: lload 5
    //   90: lreturn
    //   91: astore_2
    //   92: aload_0
    //   93: aload_3
    //   94: invokespecial 709	com/tencent/kingkong/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   97: aload_2
    //   98: athrow
    //   99: astore_2
    //   100: aload_0
    //   101: aload_1
    //   102: invokespecial 711	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   105: aload_2
    //   106: athrow
    //   107: astore_1
    //   108: aload_0
    //   109: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   112: iload 4
    //   114: aload_1
    //   115: invokevirtual 715	com/tencent/kingkong/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   118: aload_1
    //   119: athrow
    //   120: astore_1
    //   121: aload_0
    //   122: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   125: iload 4
    //   127: invokevirtual 322	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   130: aload_1
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	SQLiteConnection
    //   0	132	1	paramString	String
    //   0	132	2	paramArrayOfObject	Object[]
    //   0	132	3	paramCancellationSignal	CancellationSignal
    //   27	99	4	i	int
    //   67	22	5	l	long
    // Exception table:
    //   from	to	target	type
    //   56	69	91	finally
    //   35	56	99	finally
    //   69	74	99	finally
    //   92	99	99	finally
    //   29	35	107	java/lang/RuntimeException
    //   74	79	107	java/lang/RuntimeException
    //   100	107	107	java/lang/RuntimeException
    //   29	35	120	finally
    //   74	79	120	finally
    //   100	107	120	finally
    //   108	120	120	finally
  }
  
  /* Error */
  public String executeForString(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: new 691	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 693
    //   11: invokespecial 694	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aload_0
    //   16: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   19: ldc_w 777
    //   22: aload_1
    //   23: aload_2
    //   24: invokevirtual 312	com/tencent/kingkong/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   27: istore 4
    //   29: aload_0
    //   30: aload_1
    //   31: invokespecial 697	com/tencent/kingkong/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;
    //   34: astore_1
    //   35: aload_0
    //   36: aload_1
    //   37: invokespecial 699	com/tencent/kingkong/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   40: aload_0
    //   41: aload_1
    //   42: aload_2
    //   43: invokespecial 701	com/tencent/kingkong/database/SQLiteConnection:bindArguments	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   46: aload_0
    //   47: aload_1
    //   48: invokespecial 703	com/tencent/kingkong/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   51: aload_0
    //   52: aload_3
    //   53: invokespecial 705	com/tencent/kingkong/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   56: aload_0
    //   57: getfield 151	com/tencent/kingkong/database/SQLiteConnection:mConnectionPtr	I
    //   60: aload_1
    //   61: getfield 242	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   64: invokestatic 779	com/tencent/kingkong/database/SQLiteConnection:nativeExecuteForString	(II)Ljava/lang/String;
    //   67: astore_2
    //   68: aload_0
    //   69: aload_3
    //   70: invokespecial 709	com/tencent/kingkong/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   73: aload_0
    //   74: aload_1
    //   75: invokespecial 711	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   78: aload_0
    //   79: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   82: iload 4
    //   84: invokevirtual 322	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   87: aload_2
    //   88: areturn
    //   89: astore_2
    //   90: aload_0
    //   91: aload_3
    //   92: invokespecial 709	com/tencent/kingkong/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   95: aload_2
    //   96: athrow
    //   97: astore_2
    //   98: aload_0
    //   99: aload_1
    //   100: invokespecial 711	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   103: aload_2
    //   104: athrow
    //   105: astore_1
    //   106: aload_0
    //   107: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   110: iload 4
    //   112: aload_1
    //   113: invokevirtual 715	com/tencent/kingkong/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   116: aload_1
    //   117: athrow
    //   118: astore_1
    //   119: aload_0
    //   120: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   123: iload 4
    //   125: invokevirtual 322	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   128: aload_1
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	SQLiteConnection
    //   0	130	1	paramString	String
    //   0	130	2	paramArrayOfObject	Object[]
    //   0	130	3	paramCancellationSignal	CancellationSignal
    //   27	97	4	i	int
    // Exception table:
    //   from	to	target	type
    //   56	68	89	finally
    //   35	56	97	finally
    //   68	73	97	finally
    //   90	97	97	finally
    //   29	35	105	java/lang/RuntimeException
    //   73	78	105	java/lang/RuntimeException
    //   98	105	105	java/lang/RuntimeException
    //   29	35	118	finally
    //   73	78	118	finally
    //   98	105	118	finally
    //   106	118	118	finally
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      if ((this.mPool != null) && (this.mConnectionPtr != 0)) {
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
    //   1: ifnonnull +14 -> 15
    //   4: new 691	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 693
    //   11: invokespecial 694	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aload_0
    //   16: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   19: ldc_w 799
    //   22: aload_1
    //   23: aconst_null
    //   24: invokevirtual 312	com/tencent/kingkong/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   27: istore 4
    //   29: aload_0
    //   30: aload_1
    //   31: invokespecial 697	com/tencent/kingkong/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;
    //   34: astore_1
    //   35: aload_2
    //   36: ifnull +44 -> 80
    //   39: aload_2
    //   40: aload_1
    //   41: getfield 214	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mNumParameters	I
    //   44: putfield 804	com/tencent/kingkong/database/SQLiteStatementInfo:numParameters	I
    //   47: aload_2
    //   48: aload_1
    //   49: getfield 418	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mReadOnly	Z
    //   52: putfield 807	com/tencent/kingkong/database/SQLiteStatementInfo:readOnly	Z
    //   55: aload_0
    //   56: getfield 151	com/tencent/kingkong/database/SQLiteConnection:mConnectionPtr	I
    //   59: aload_1
    //   60: getfield 242	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   63: invokestatic 809	com/tencent/kingkong/database/SQLiteConnection:nativeGetColumnCount	(II)I
    //   66: istore 5
    //   68: iload 5
    //   70: ifne +25 -> 95
    //   73: aload_2
    //   74: getstatic 69	com/tencent/kingkong/database/SQLiteConnection:EMPTY_STRING_ARRAY	[Ljava/lang/String;
    //   77: putfield 812	com/tencent/kingkong/database/SQLiteStatementInfo:columnNames	[Ljava/lang/String;
    //   80: aload_0
    //   81: aload_1
    //   82: invokespecial 711	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   85: aload_0
    //   86: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   89: iload 4
    //   91: invokevirtual 322	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   94: return
    //   95: aload_2
    //   96: iload 5
    //   98: anewarray 67	java/lang/String
    //   101: putfield 812	com/tencent/kingkong/database/SQLiteStatementInfo:columnNames	[Ljava/lang/String;
    //   104: iconst_0
    //   105: istore_3
    //   106: iload_3
    //   107: iload 5
    //   109: if_icmpge -29 -> 80
    //   112: aload_2
    //   113: getfield 812	com/tencent/kingkong/database/SQLiteStatementInfo:columnNames	[Ljava/lang/String;
    //   116: iload_3
    //   117: aload_0
    //   118: getfield 151	com/tencent/kingkong/database/SQLiteConnection:mConnectionPtr	I
    //   121: aload_1
    //   122: getfield 242	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   125: iload_3
    //   126: invokestatic 814	com/tencent/kingkong/database/SQLiteConnection:nativeGetColumnName	(III)Ljava/lang/String;
    //   129: aastore
    //   130: iload_3
    //   131: iconst_1
    //   132: iadd
    //   133: istore_3
    //   134: goto -28 -> 106
    //   137: astore_2
    //   138: aload_0
    //   139: aload_1
    //   140: invokespecial 711	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   143: aload_2
    //   144: athrow
    //   145: astore_1
    //   146: aload_0
    //   147: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   150: iload 4
    //   152: aload_1
    //   153: invokevirtual 715	com/tencent/kingkong/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   156: aload_1
    //   157: athrow
    //   158: astore_1
    //   159: aload_0
    //   160: getfield 91	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   163: iload 4
    //   165: invokevirtual 322	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperation	(I)V
    //   168: aload_1
    //   169: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	SQLiteConnection
    //   0	170	1	paramString	String
    //   0	170	2	paramSQLiteStatementInfo	SQLiteStatementInfo
    //   105	29	3	i	int
    //   27	137	4	j	int
    //   66	44	5	k	int
    // Exception table:
    //   from	to	target	type
    //   39	68	137	finally
    //   73	80	137	finally
    //   95	104	137	finally
    //   112	130	137	finally
    //   29	35	145	java/lang/RuntimeException
    //   80	85	145	java/lang/RuntimeException
    //   138	145	145	java/lang/RuntimeException
    //   29	35	158	finally
    //   80	85	158	finally
    //   138	145	158	finally
    //   146	158	158	finally
  }
  
  void reconfigure(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration)
  {
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
    if (paramSQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled != this.mConfiguration.foreignKeyConstraintsEnabled)
    {
      i = 1;
      if (((paramSQLiteDatabaseConfiguration.openFlags ^ this.mConfiguration.openFlags) & 0x20000000) == 0) {
        break label171;
      }
      j = 1;
      label101:
      if (paramSQLiteDatabaseConfiguration.locale.equals(this.mConfiguration.locale)) {
        break label176;
      }
    }
    label171:
    label176:
    for (int k = 1;; k = 0)
    {
      this.mConfiguration.updateParametersFrom(paramSQLiteDatabaseConfiguration);
      this.mPreparedStatementCache.resize(paramSQLiteDatabaseConfiguration.maxSqlCacheSize);
      if (i != 0) {
        setForeignKeyModeFromConfiguration();
      }
      if (j != 0) {
        setWalModeFromConfiguration();
      }
      if (k != 0) {
        setLocaleFromConfiguration();
      }
      return;
      i = 0;
      break;
      j = 0;
      break label101;
    }
  }
  
  void setOnlyAllowReadOnlyOperations(boolean paramBoolean)
  {
    this.mOnlyAllowReadOnlyOperations = paramBoolean;
  }
  
  public String toString()
  {
    return "SQLiteConnection: " + this.mConfiguration.path + " (" + this.mConnectionId + ")";
  }
  
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
      int i;
      label122:
      Object localObject;
      if (this.mFinished)
      {
        paramStringBuilder.append(" took ").append(this.mEndTime - this.mStartTime).append("ms");
        paramStringBuilder.append(" - ").append(getStatus());
        if (this.mSql != null) {
          paramStringBuilder.append(", sql=\"").append(SQLiteConnection.trimSqlForDisplay(this.mSql)).append("\"");
        }
        if ((!paramBoolean) || (this.mBindArgs == null) || (this.mBindArgs.size() == 0)) {
          break label260;
        }
        paramStringBuilder.append(", bindArgs=[");
        int j = this.mBindArgs.size();
        i = 0;
        if (i >= j) {
          break label253;
        }
        localObject = this.mBindArgs.get(i);
        if (i != 0) {
          paramStringBuilder.append(", ");
        }
        if (localObject != null) {
          break label194;
        }
        paramStringBuilder.append("null");
      }
      for (;;)
      {
        i += 1;
        break label122;
        paramStringBuilder.append(" started ").append(System.currentTimeMillis() - this.mStartTime).append("ms ago");
        break;
        label194:
        if ((localObject instanceof byte[])) {
          paramStringBuilder.append("<byte[]>");
        } else if ((localObject instanceof String)) {
          paramStringBuilder.append("\"").append((String)localObject).append("\"");
        } else {
          paramStringBuilder.append(localObject);
        }
      }
      label253:
      paramStringBuilder.append("]");
      label260:
      if (this.mException != null) {
        paramStringBuilder.append(", exception=\"").append(this.mException.getMessage()).append("\"");
      }
    }
  }
  
  private static final class OperationLog
  {
    private static final int COOKIE_GENERATION_SHIFT = 8;
    private static final int COOKIE_INDEX_MASK = 255;
    private static final int MAX_RECENT_OPERATIONS = 20;
    private int mGeneration;
    private int mIndex;
    private final SQLiteConnection.Operation[] mOperations = new SQLiteConnection.Operation[20];
    
    private boolean endOperationDeferLogLocked(int paramInt)
    {
      SQLiteConnection.Operation localOperation = getOperationLocked(paramInt);
      if (localOperation != null)
      {
        localOperation.mEndTime = System.currentTimeMillis();
        localOperation.mFinished = true;
        return (SQLiteDebug.DEBUG_LOG_SLOW_QUERIES) && (SQLiteDebug.shouldLogSlowQuery(localOperation.mEndTime - localOperation.mStartTime));
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
    
    private void logOperationLocked(int paramInt, String paramString)
    {
      SQLiteConnection.Operation localOperation = getOperationLocked(paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localOperation.describe(localStringBuilder, false);
      if (paramString != null) {
        localStringBuilder.append(", ").append(paramString);
      }
      Log.d("SQLiteConnection", localStringBuilder.toString());
    }
    
    private int newOperationCookieLocked(int paramInt)
    {
      int i = this.mGeneration;
      this.mGeneration = (i + 1);
      return i << 8 | paramInt;
    }
    
    public int beginOperation(String paramString1, String paramString2, Object[] paramArrayOfObject)
    {
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
              break label237;
              if (i >= paramArrayOfObject.length) {
                break label207;
              }
              paramString1 = paramArrayOfObject[i];
              if ((paramString1 == null) || (!(paramString1 instanceof byte[]))) {
                break label194;
              }
              localOperation1.mBindArgs.add(SQLiteConnection.EMPTY_BYTE_ARRAY);
              break label243;
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
        break label237;
        label194:
        localOperation1.mBindArgs.add(paramString1);
        break label243;
        label207:
        localOperation1.mCookie = newOperationCookieLocked(j);
        this.mIndex = j;
        int i = localOperation1.mCookie;
        return i;
        label237:
        i = 0;
        continue;
        label243:
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
            localStringBuilder.append(localOperation.getFormattedStartTime());
            localStringBuilder.append("] ");
            localOperation.describe(localStringBuilder, paramBoolean);
            paramPrinter.println(localStringBuilder.toString());
            if (i > 0)
            {
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
          }
          else
          {
            paramPrinter.println("    <none>");
          }
        }
        int i = 19;
      }
    }
    
    public void endOperation(int paramInt)
    {
      synchronized (this.mOperations)
      {
        if (endOperationDeferLogLocked(paramInt)) {
          logOperationLocked(paramInt, null);
        }
        return;
      }
    }
    
    public boolean endOperationDeferLog(int paramInt)
    {
      synchronized (this.mOperations)
      {
        boolean bool = endOperationDeferLogLocked(paramInt);
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
        logOperationLocked(paramInt, paramString);
        return;
      }
    }
  }
  
  private static final class PreparedStatement
  {
    public boolean mInCache;
    public boolean mInUse;
    public int mNumParameters;
    public PreparedStatement mPoolNext;
    public boolean mReadOnly;
    public String mSql;
    public int mStatementPtr;
    public int mType;
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
            paramPrinter.println("    " + i + ": statementPtr=0x" + Integer.toHexString(localPreparedStatement.mStatementPtr) + ", numParameters=" + localPreparedStatement.mNumParameters + ", type=" + localPreparedStatement.mType + ", readOnly=" + localPreparedStatement.mReadOnly + ", sql=\"" + SQLiteConnection.trimSqlForDisplay((String)localObject2) + "\"");
          }
          i += 1;
        }
      }
      paramPrinter.println("    <none>");
    }
    
    protected void entryRemoved(boolean paramBoolean, String paramString, SQLiteConnection.PreparedStatement paramPreparedStatement1, SQLiteConnection.PreparedStatement paramPreparedStatement2)
    {
      paramPreparedStatement1.mInCache = false;
      if (!paramPreparedStatement1.mInUse) {
        SQLiteConnection.this.finalizePreparedStatement(paramPreparedStatement1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.database.SQLiteConnection
 * JD-Core Version:    0.7.0.1
 */