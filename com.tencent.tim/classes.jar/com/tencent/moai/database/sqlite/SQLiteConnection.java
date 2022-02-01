package com.tencent.moai.database.sqlite;

import android.util.Log;
import android.util.Printer;
import com.tencent.moai.database.ExtraUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SQLiteConnection
  implements CancellationSignal.OnCancelListener
{
  private static final boolean DEBUG = false;
  private static final byte[] EMPTY_BYTE_ARRAY;
  private static final String[] EMPTY_STRING_ARRAY;
  private static final AtomicBoolean GLOBAL_SET;
  private static final String TAG = "SQLiteConnection";
  private static final Pattern TRIM_SQL_PATTERN;
  private HashMap<String, String> mAttachedDataBases = new HashMap();
  private int mCancellationSignalAttachCount;
  private final CloseGuard mCloseGuard = CloseGuard.get();
  private final SQLiteDatabaseConfiguration mConfiguration;
  private final int mConnectionId;
  private int mConnectionPtr;
  private boolean mInterrupted;
  private final boolean mIsPrimaryConnection;
  private final boolean mIsReadOnlyConnection;
  private boolean mOnlyAllowReadOnlyOperations;
  private final SQLiteConnectionPool mPool;
  private final PreparedStatementCache mPreparedStatementCache;
  private PreparedStatement mPreparedStatementPool;
  private final OperationLog mRecentOperations = new OperationLog(null);
  public int priority;
  
  static
  {
    if (!SQLiteConnection.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      EMPTY_STRING_ARRAY = new String[0];
      EMPTY_BYTE_ARRAY = new byte[0];
      TRIM_SQL_PATTERN = Pattern.compile("[\\s]*\\n+[\\s]*");
      GLOBAL_SET = new AtomicBoolean();
      return;
    }
  }
  
  private SQLiteConnection(SQLiteConnectionPool paramSQLiteConnectionPool, SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration, int paramInt, boolean paramBoolean)
  {
    this.mPool = paramSQLiteConnectionPool;
    this.mConfiguration = new SQLiteDatabaseConfiguration(paramSQLiteDatabaseConfiguration);
    this.mConnectionId = paramInt;
    this.mIsPrimaryConnection = paramBoolean;
    if ((paramSQLiteDatabaseConfiguration.openFlags & 0x1) != 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.mIsReadOnlyConnection = paramBoolean;
      this.mPreparedStatementCache = new PreparedStatementCache(this.mConfiguration.maxSqlCacheSize);
      this.mCloseGuard.open("close");
      return;
    }
  }
  
  private PreparedStatement acquirePreparedStatement(String paramString)
  {
    PreparedStatement localPreparedStatement2 = (PreparedStatement)this.mPreparedStatementCache.get(paramString);
    if (localPreparedStatement2 != null) {
      if (!localPreparedStatement2.mInUse) {
        return localPreparedStatement2;
      }
    }
    for (int i = 1;; i = 0)
    {
      int j = nativePrepareStatement(this.mConnectionPtr, paramString);
      PreparedStatement localPreparedStatement1 = localPreparedStatement2;
      try
      {
        int k = nativeGetParameterCount(this.mConnectionPtr, j);
        localPreparedStatement1 = localPreparedStatement2;
        int m = ExtraUtils.getSqlStatementType(paramString);
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
  }
  
  private void applyBlockGuardPolicy(PreparedStatement paramPreparedStatement)
  {
    if ((!this.mConfiguration.isInMemoryDb()) && (paramPreparedStatement.mReadOnly)) {}
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
    switch (ExtraUtils.getTypeOfObject(paramPreparedStatement))
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
    if (this.mCloseGuard != null)
    {
      if (paramBoolean) {
        this.mCloseGuard.warnIfOpen();
      }
      this.mCloseGuard.close();
    }
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
  
  public static boolean hasCodec()
  {
    return nativeHasCodec();
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
  
  private static native void nativeCloseBlob(int paramInt1, int paramInt2);
  
  public static native void nativeEnableSharedCache();
  
  private static native void nativeExecute(int paramInt1, int paramInt2);
  
  private static native int nativeExecuteForBlobFileDescriptor(int paramInt1, int paramInt2);
  
  private static native int nativeExecuteForChangedRowCount(int paramInt1, int paramInt2);
  
  private static native long nativeExecuteForCursorWindow(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  private static native long nativeExecuteForCursorWindow(int paramInt1, int paramInt2, SparseParcelWindow paramSparseParcelWindow, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  private static native long nativeExecuteForLastInsertedRowId(int paramInt1, int paramInt2);
  
  private static native long nativeExecuteForLong(int paramInt1, int paramInt2);
  
  private static native String nativeExecuteForString(int paramInt1, int paramInt2);
  
  private static native void nativeFinalizeStatement(int paramInt1, int paramInt2);
  
  private static native int nativeGetBlobSize(int paramInt);
  
  private static native int nativeGetColumnCount(int paramInt1, int paramInt2);
  
  private static native String nativeGetColumnName(int paramInt1, int paramInt2, int paramInt3);
  
  private static native int nativeGetDbLookaside(int paramInt);
  
  private static native int nativeGetParameterCount(int paramInt1, int paramInt2);
  
  private static native boolean nativeHasCodec();
  
  private static native void nativeInterrupt(int paramInt);
  
  private static native boolean nativeIsReadOnly(int paramInt1, int paramInt2);
  
  private static native int nativeOpen(String paramString1, int paramInt, String paramString2, boolean paramBoolean1, boolean paramBoolean2);
  
  private static native int nativeOpenBlob(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3);
  
  private static native int nativePrepareStatement(int paramInt, String paramString);
  
  private static native int nativeReadBlob(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4);
  
  private static native void nativeRegisterCustomFunction(int paramInt, SQLiteCustomFunction paramSQLiteCustomFunction);
  
  private static native void nativeRegisterProfile(int paramInt, SQLiteDatabase.SQLiteProfile paramSQLiteProfile);
  
  private static native void nativeRegisterUpdateHook(int paramInt, SQLiteDatabase.UpdateHookWrapper paramUpdateHookWrapper);
  
  private static native void nativeResetCancel(int paramInt, boolean paramBoolean);
  
  private static native void nativeResetStatementAndClearBindings(int paramInt1, int paramInt2);
  
  public static native int nativeRestore(String paramString);
  
  private static native int nativeWriteBlob(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4);
  
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
  
  static SQLiteConnection open(SQLiteConnectionPool paramSQLiteConnectionPool, SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration, int paramInt, boolean paramBoolean)
  {
    paramSQLiteConnectionPool = new SQLiteConnection(paramSQLiteConnectionPool, paramSQLiteDatabaseConfiguration, paramInt, paramBoolean);
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
    if (!GLOBAL_SET.getAndSet(true))
    {
      setTempDirectory();
      setPageSize();
      setForeignKeyModeFromConfiguration();
      setJournalSizeLimit();
      setAutoCheckpointInterval();
      if (!nativeHasCodec()) {
        setWalModeFromConfiguration();
      }
      int j = this.mConfiguration.customFunctions.size();
      int i = 0;
      while (i < j)
      {
        localObject = (SQLiteCustomFunction)this.mConfiguration.customFunctions.get(i);
        nativeRegisterCustomFunction(this.mConnectionPtr, (SQLiteCustomFunction)localObject);
        i += 1;
      }
      Object localObject = this.mConfiguration.updateHooks.iterator();
      while (((Iterator)localObject).hasNext())
      {
        SQLiteDatabase.UpdateHookWrapper localUpdateHookWrapper = (SQLiteDatabase.UpdateHookWrapper)((Iterator)localObject).next();
        nativeRegisterUpdateHook(this.mConnectionPtr, localUpdateHookWrapper);
      }
      if (this.mConfiguration.profile != null) {
        nativeRegisterProfile(this.mConnectionPtr, this.mConfiguration.profile);
      }
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
  
  private void setTempDirectory()
  {
    if ((!this.mConfiguration.isInMemoryDb()) && (!this.mIsReadOnlyConnection)) {
      execute("PRAGMA temp_store_directory='" + new File(this.mConfiguration.path).getParent() + "'", null, null);
    }
  }
  
  private void setWalModeFromConfiguration()
  {
    if ((!this.mConfiguration.isInMemoryDb()) && (!this.mIsReadOnlyConnection) && ((this.mConfiguration.openFlags & 0x20000000) != 0))
    {
      setJournalMode("WAL");
      setSyncMode(SQLiteGlobal.getWALSyncMode());
    }
  }
  
  private void throwIfSqlIsNull(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("sql must not be null.");
    }
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
  
  public void addAttachedDataBase(String paramString1, String paramString2)
  {
    this.mAttachedDataBases.put(paramString1, paramString2);
  }
  
  public void alignAttachState(HashMap<String, String> paramHashMap)
  {
    Iterator localIterator = paramHashMap.keySet().iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if ((!str.equals("main")) && (!this.mAttachedDataBases.containsKey(str))) {
        attachDataBase(str, (String)paramHashMap.get(str));
      }
    }
    localIterator = this.mAttachedDataBases.keySet().iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if ((!str.equals("main")) && (!paramHashMap.containsKey(str))) {
        detachDataBase(str);
      }
    }
  }
  
  public void attachDataBase(String paramString1, String paramString2)
  {
    String str = "ATTACH '" + paramString2 + "' AS " + paramString1;
    try
    {
      execute(str, null, null);
      addAttachedDataBase(paramString1, paramString2);
      return;
    }
    catch (Exception localException)
    {
      if (((localException instanceof SQLiteException)) && (localException.getMessage() != null) && (localException.getMessage().endsWith("is already in use")))
      {
        addAttachedDataBase(paramString1, paramString2);
        return;
      }
      throw localException;
    }
  }
  
  void close()
  {
    dispose(false);
  }
  
  void collectDbStats(ArrayList<SQLiteDebug.DbStats> paramArrayList)
  {
    int i = nativeGetDbLookaside(this.mConnectionPtr);
    long l1 = 0L;
    long l3 = 0L;
    try
    {
      l2 = executeForLong("PRAGMA page_count;", null, null);
      l1 = l2;
      l4 = executeForLong("PRAGMA page_size;", null, null);
      l3 = l4;
      l1 = l2;
    }
    catch (SQLiteException localSQLiteException1)
    {
      long l2;
      long l4;
      label45:
      CursorWindow localCursorWindow;
      label301:
      break label45;
    }
    paramArrayList.add(getMainDbStatsUnsafe(i, l1, l3));
    localCursorWindow = new CursorWindow(this.mConfiguration.path);
    try
    {
      executeForCursorWindow("PRAGMA database_list;", null, localCursorWindow, 0, 0, 0, null);
      i = 1;
      for (;;)
      {
        if (i >= localCursorWindow.getNumRows()) {
          break label301;
        }
        Object localObject = localCursorWindow.getString(i, 1);
        String str2 = localCursorWindow.getString(i, 2);
        l1 = 0L;
        l3 = 0L;
        try
        {
          l2 = executeForLong("PRAGMA " + (String)localObject + ".page_count;", null, null);
          l1 = l2;
          l4 = executeForLong("PRAGMA " + (String)localObject + ".page_size;", null, null);
          l1 = l4;
        }
        catch (SQLiteException localSQLiteException2)
        {
          for (;;)
          {
            String str1;
            l2 = l1;
            l1 = l3;
          }
        }
        str1 = "  (attached) " + (String)localObject;
        localObject = str1;
        if (!str2.isEmpty()) {
          localObject = str1 + ": " + str2;
        }
        paramArrayList.add(new SQLiteDebug.DbStats((String)localObject, l2, l1, 0, 0, 0, 0));
        i += 1;
      }
      return;
    }
    catch (SQLiteException paramArrayList) {}finally
    {
      localCursorWindow.close();
    }
  }
  
  void collectDbStatsUnsafe(ArrayList<SQLiteDebug.DbStats> paramArrayList)
  {
    paramArrayList.add(getMainDbStatsUnsafe(0, 0L, 0L));
  }
  
  String describeCurrentOperationUnsafe()
  {
    return this.mRecentOperations.describeCurrentOperation();
  }
  
  public void detachDataBase(String paramString)
  {
    String str = "DETACH " + paramString;
    try
    {
      execute(str, null, null);
      return;
    }
    catch (Exception localException)
    {
      if (((localException instanceof SQLiteException)) && (localException.getMessage() != null) && (localException.getMessage().contains("no such database:")))
      {
        removeAttachedDataBase(paramString);
        return;
      }
      throw localException;
    }
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
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 777	com/tencent/moai/database/sqlite/SQLiteConnection:throwIfSqlIsNull	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   9: ldc_w 778
    //   12: aload_1
    //   13: aload_2
    //   14: invokevirtual 335	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   17: istore 4
    //   19: aload_0
    //   20: aload_1
    //   21: invokespecial 780	com/tencent/moai/database/sqlite/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;
    //   24: astore_1
    //   25: aload_0
    //   26: aload_1
    //   27: invokespecial 782	com/tencent/moai/database/sqlite/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   30: aload_0
    //   31: aload_1
    //   32: aload_2
    //   33: invokespecial 784	com/tencent/moai/database/sqlite/SQLiteConnection:bindArguments	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   36: aload_0
    //   37: aload_1
    //   38: invokespecial 786	com/tencent/moai/database/sqlite/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   41: aload_0
    //   42: aload_3
    //   43: invokespecial 788	com/tencent/moai/database/sqlite/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/moai/database/sqlite/CancellationSignal;)V
    //   46: aload_0
    //   47: getfield 169	com/tencent/moai/database/sqlite/SQLiteConnection:mConnectionPtr	I
    //   50: aload_1
    //   51: getfield 262	com/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   54: invokestatic 790	com/tencent/moai/database/sqlite/SQLiteConnection:nativeExecute	(II)V
    //   57: aload_0
    //   58: aload_3
    //   59: invokespecial 792	com/tencent/moai/database/sqlite/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/moai/database/sqlite/CancellationSignal;)V
    //   62: aload_0
    //   63: aload_1
    //   64: invokespecial 794	com/tencent/moai/database/sqlite/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   67: aload_0
    //   68: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   71: iload 4
    //   73: invokevirtual 345	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:endOperation	(I)V
    //   76: return
    //   77: astore_2
    //   78: aload_0
    //   79: aload_3
    //   80: invokespecial 792	com/tencent/moai/database/sqlite/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/moai/database/sqlite/CancellationSignal;)V
    //   83: aload_2
    //   84: athrow
    //   85: astore_2
    //   86: aload_0
    //   87: aload_1
    //   88: invokespecial 794	com/tencent/moai/database/sqlite/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   91: aload_2
    //   92: athrow
    //   93: astore_1
    //   94: aload_0
    //   95: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   98: iload 4
    //   100: aload_1
    //   101: invokevirtual 798	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   104: aload_1
    //   105: athrow
    //   106: astore_1
    //   107: aload_0
    //   108: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   111: iload 4
    //   113: invokevirtual 345	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:endOperation	(I)V
    //   116: aload_1
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	SQLiteConnection
    //   0	118	1	paramString	String
    //   0	118	2	paramArrayOfObject	Object[]
    //   0	118	3	paramCancellationSignal	CancellationSignal
    //   17	95	4	i	int
    // Exception table:
    //   from	to	target	type
    //   46	57	77	finally
    //   25	46	85	finally
    //   57	62	85	finally
    //   78	85	85	finally
    //   19	25	93	java/lang/RuntimeException
    //   62	67	93	java/lang/RuntimeException
    //   86	93	93	java/lang/RuntimeException
    //   19	25	106	finally
    //   62	67	106	finally
    //   86	93	106	finally
    //   94	106	106	finally
  }
  
  public void executeCloseBlob(SQLiteBlob paramSQLiteBlob)
  {
    int i = this.mRecentOperations.beginOperation("executeForSQLiteBlob", String.format("sqlite3_close_blob <= table=%s.%s column=%s flags=%d row=%d", new Object[] { paramSQLiteBlob.getDbName(), paramSQLiteBlob.getTableName(), paramSQLiteBlob.getColumnName(), Integer.valueOf(paramSQLiteBlob.getFlags()), Integer.valueOf(paramSQLiteBlob.getRowId()) }), null);
    try
    {
      nativeCloseBlob(paramSQLiteBlob.getBlobPtr(), paramSQLiteBlob.getNativeBufferPtr());
      return;
    }
    catch (RuntimeException paramSQLiteBlob)
    {
      this.mRecentOperations.failOperation(i, paramSQLiteBlob);
      throw paramSQLiteBlob;
    }
    finally
    {
      this.mRecentOperations.endOperation(i);
    }
  }
  
  /* Error */
  public android.os.ParcelFileDescriptor executeForBlobFileDescriptor(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 777	com/tencent/moai/database/sqlite/SQLiteConnection:throwIfSqlIsNull	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   9: ldc_w 840
    //   12: aload_1
    //   13: aload_2
    //   14: invokevirtual 335	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   17: istore 4
    //   19: aload_0
    //   20: aload_1
    //   21: invokespecial 780	com/tencent/moai/database/sqlite/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;
    //   24: astore_1
    //   25: aload_0
    //   26: aload_1
    //   27: invokespecial 782	com/tencent/moai/database/sqlite/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   30: aload_0
    //   31: aload_1
    //   32: aload_2
    //   33: invokespecial 784	com/tencent/moai/database/sqlite/SQLiteConnection:bindArguments	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   36: aload_0
    //   37: aload_1
    //   38: invokespecial 786	com/tencent/moai/database/sqlite/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   41: aload_0
    //   42: aload_3
    //   43: invokespecial 788	com/tencent/moai/database/sqlite/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/moai/database/sqlite/CancellationSignal;)V
    //   46: aload_0
    //   47: getfield 169	com/tencent/moai/database/sqlite/SQLiteConnection:mConnectionPtr	I
    //   50: aload_1
    //   51: getfield 262	com/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   54: invokestatic 842	com/tencent/moai/database/sqlite/SQLiteConnection:nativeExecuteForBlobFileDescriptor	(II)I
    //   57: pop
    //   58: aload_0
    //   59: aload_3
    //   60: invokespecial 792	com/tencent/moai/database/sqlite/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/moai/database/sqlite/CancellationSignal;)V
    //   63: aload_0
    //   64: aload_1
    //   65: invokespecial 794	com/tencent/moai/database/sqlite/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   68: aload_0
    //   69: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   72: iload 4
    //   74: invokevirtual 345	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:endOperation	(I)V
    //   77: aconst_null
    //   78: areturn
    //   79: astore_2
    //   80: aload_0
    //   81: aload_3
    //   82: invokespecial 792	com/tencent/moai/database/sqlite/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/moai/database/sqlite/CancellationSignal;)V
    //   85: aload_2
    //   86: athrow
    //   87: astore_2
    //   88: aload_0
    //   89: aload_1
    //   90: invokespecial 794	com/tencent/moai/database/sqlite/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   93: aload_2
    //   94: athrow
    //   95: astore_1
    //   96: aload_0
    //   97: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   100: iload 4
    //   102: aload_1
    //   103: invokevirtual 798	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   106: aload_1
    //   107: athrow
    //   108: astore_1
    //   109: aload_0
    //   110: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   113: iload 4
    //   115: invokevirtual 345	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:endOperation	(I)V
    //   118: aload_1
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	SQLiteConnection
    //   0	120	1	paramString	String
    //   0	120	2	paramArrayOfObject	Object[]
    //   0	120	3	paramCancellationSignal	CancellationSignal
    //   17	97	4	i	int
    // Exception table:
    //   from	to	target	type
    //   46	58	79	finally
    //   25	46	87	finally
    //   58	63	87	finally
    //   80	87	87	finally
    //   19	25	95	java/lang/RuntimeException
    //   63	68	95	java/lang/RuntimeException
    //   88	95	95	java/lang/RuntimeException
    //   19	25	108	finally
    //   63	68	108	finally
    //   88	95	108	finally
    //   96	108	108	finally
  }
  
  /* Error */
  public int executeForChangedRowCount(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 777	com/tencent/moai/database/sqlite/SQLiteConnection:throwIfSqlIsNull	(Ljava/lang/String;)V
    //   5: iconst_0
    //   6: istore 4
    //   8: iconst_0
    //   9: istore 6
    //   11: iconst_0
    //   12: istore 7
    //   14: aload_0
    //   15: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   18: ldc_w 845
    //   21: aload_1
    //   22: aload_2
    //   23: invokevirtual 335	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   26: istore 8
    //   28: aload_0
    //   29: aload_1
    //   30: invokespecial 780	com/tencent/moai/database/sqlite/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;
    //   33: astore_1
    //   34: iload 7
    //   36: istore 5
    //   38: aload_0
    //   39: aload_1
    //   40: invokespecial 782	com/tencent/moai/database/sqlite/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   43: iload 7
    //   45: istore 5
    //   47: aload_0
    //   48: aload_1
    //   49: aload_2
    //   50: invokespecial 784	com/tencent/moai/database/sqlite/SQLiteConnection:bindArguments	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   53: iload 7
    //   55: istore 5
    //   57: aload_0
    //   58: aload_1
    //   59: invokespecial 786	com/tencent/moai/database/sqlite/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   62: iload 7
    //   64: istore 5
    //   66: aload_0
    //   67: aload_3
    //   68: invokespecial 788	com/tencent/moai/database/sqlite/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/moai/database/sqlite/CancellationSignal;)V
    //   71: aload_0
    //   72: getfield 169	com/tencent/moai/database/sqlite/SQLiteConnection:mConnectionPtr	I
    //   75: aload_1
    //   76: getfield 262	com/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   79: invokestatic 847	com/tencent/moai/database/sqlite/SQLiteConnection:nativeExecuteForChangedRowCount	(II)I
    //   82: istore 4
    //   84: iload 4
    //   86: istore 7
    //   88: iload 7
    //   90: istore 5
    //   92: aload_0
    //   93: aload_3
    //   94: invokespecial 792	com/tencent/moai/database/sqlite/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/moai/database/sqlite/CancellationSignal;)V
    //   97: iload 7
    //   99: istore 4
    //   101: iload 7
    //   103: istore 6
    //   105: aload_0
    //   106: aload_1
    //   107: invokespecial 794	com/tencent/moai/database/sqlite/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   110: aload_0
    //   111: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   114: iload 8
    //   116: invokevirtual 850	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:endOperationDeferLog	(I)Z
    //   119: ifeq +33 -> 152
    //   122: aload_0
    //   123: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   126: iload 8
    //   128: new 239	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   135: ldc_w 852
    //   138: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: iload 7
    //   143: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   146: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokevirtual 856	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:logOperation	(ILjava/lang/String;)V
    //   152: iload 7
    //   154: ireturn
    //   155: astore_2
    //   156: iload 7
    //   158: istore 5
    //   160: aload_0
    //   161: aload_3
    //   162: invokespecial 792	com/tencent/moai/database/sqlite/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/moai/database/sqlite/CancellationSignal;)V
    //   165: iload 7
    //   167: istore 5
    //   169: aload_2
    //   170: athrow
    //   171: astore_2
    //   172: iload 5
    //   174: istore 4
    //   176: iload 5
    //   178: istore 6
    //   180: aload_0
    //   181: aload_1
    //   182: invokespecial 794	com/tencent/moai/database/sqlite/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   185: iload 5
    //   187: istore 4
    //   189: iload 5
    //   191: istore 6
    //   193: aload_2
    //   194: athrow
    //   195: astore_1
    //   196: iload 4
    //   198: istore 6
    //   200: aload_0
    //   201: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   204: iload 8
    //   206: aload_1
    //   207: invokevirtual 798	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   210: iload 4
    //   212: istore 6
    //   214: aload_1
    //   215: athrow
    //   216: astore_1
    //   217: aload_0
    //   218: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   221: iload 8
    //   223: invokevirtual 850	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:endOperationDeferLog	(I)Z
    //   226: ifeq +33 -> 259
    //   229: aload_0
    //   230: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   233: iload 8
    //   235: new 239	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   242: ldc_w 852
    //   245: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: iload 6
    //   250: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   253: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokevirtual 856	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:logOperation	(ILjava/lang/String;)V
    //   259: aload_1
    //   260: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	SQLiteConnection
    //   0	261	1	paramString	String
    //   0	261	2	paramArrayOfObject	Object[]
    //   0	261	3	paramCancellationSignal	CancellationSignal
    //   6	205	4	i	int
    //   36	154	5	j	int
    //   9	240	6	k	int
    //   12	154	7	m	int
    //   26	208	8	n	int
    // Exception table:
    //   from	to	target	type
    //   71	84	155	finally
    //   38	43	171	finally
    //   47	53	171	finally
    //   57	62	171	finally
    //   66	71	171	finally
    //   92	97	171	finally
    //   160	165	171	finally
    //   169	171	171	finally
    //   28	34	195	java/lang/RuntimeException
    //   105	110	195	java/lang/RuntimeException
    //   180	185	195	java/lang/RuntimeException
    //   193	195	195	java/lang/RuntimeException
    //   28	34	216	finally
    //   105	110	216	finally
    //   180	185	216	finally
    //   193	195	216	finally
    //   200	210	216	finally
    //   214	216	216	finally
  }
  
  /* Error */
  public int executeForCursorWindow(String paramString, Object[] paramArrayOfObject, CursorWindow paramCursorWindow, int paramInt1, int paramInt2, int paramInt3, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 777	com/tencent/moai/database/sqlite/SQLiteConnection:throwIfSqlIsNull	(Ljava/lang/String;)V
    //   5: aload_3
    //   6: ifnonnull +14 -> 20
    //   9: new 620	java/lang/IllegalArgumentException
    //   12: dup
    //   13: ldc_w 858
    //   16: invokespecial 623	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   19: athrow
    //   20: aload_3
    //   21: invokevirtual 861	com/tencent/moai/database/sqlite/CursorWindow:acquireReference	()V
    //   24: iconst_m1
    //   25: istore 11
    //   27: iconst_m1
    //   28: istore 15
    //   30: iconst_m1
    //   31: istore 16
    //   33: aload_0
    //   34: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   37: ldc_w 862
    //   40: aload_1
    //   41: aload_2
    //   42: invokevirtual 335	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   45: istore 17
    //   47: iload 16
    //   49: istore 12
    //   51: iload 15
    //   53: istore 13
    //   55: iload 11
    //   57: istore 14
    //   59: iload 16
    //   61: istore 8
    //   63: iload 15
    //   65: istore 9
    //   67: iload 11
    //   69: istore 10
    //   71: aload_0
    //   72: aload_1
    //   73: invokespecial 780	com/tencent/moai/database/sqlite/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;
    //   76: astore 20
    //   78: aload_0
    //   79: aload 20
    //   81: invokespecial 782	com/tencent/moai/database/sqlite/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   84: aload_0
    //   85: aload 20
    //   87: aload_2
    //   88: invokespecial 784	com/tencent/moai/database/sqlite/SQLiteConnection:bindArguments	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   91: aload_0
    //   92: aload 20
    //   94: invokespecial 786	com/tencent/moai/database/sqlite/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   97: aload_0
    //   98: aload 7
    //   100: invokespecial 788	com/tencent/moai/database/sqlite/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/moai/database/sqlite/CancellationSignal;)V
    //   103: aload_0
    //   104: getfield 169	com/tencent/moai/database/sqlite/SQLiteConnection:mConnectionPtr	I
    //   107: aload 20
    //   109: getfield 262	com/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   112: aload_3
    //   113: getfield 865	com/tencent/moai/database/sqlite/CursorWindow:mWindowPtr	I
    //   116: iload 4
    //   118: iload 5
    //   120: iload 6
    //   122: invokestatic 867	com/tencent/moai/database/sqlite/SQLiteConnection:nativeExecuteForCursorWindow	(IIIIII)J
    //   125: lstore 18
    //   127: lload 18
    //   129: bipush 32
    //   131: lshr
    //   132: l2i
    //   133: istore 6
    //   135: lload 18
    //   137: l2i
    //   138: istore 8
    //   140: aload_3
    //   141: invokevirtual 707	com/tencent/moai/database/sqlite/CursorWindow:getNumRows	()I
    //   144: istore 5
    //   146: aload_3
    //   147: iload 6
    //   149: invokevirtual 870	com/tencent/moai/database/sqlite/CursorWindow:setStartPosition	(I)V
    //   152: iload 5
    //   154: istore 11
    //   156: iload 8
    //   158: istore 10
    //   160: iload 6
    //   162: istore 9
    //   164: aload_0
    //   165: aload 7
    //   167: invokespecial 792	com/tencent/moai/database/sqlite/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/moai/database/sqlite/CancellationSignal;)V
    //   170: aload_0
    //   171: aload 20
    //   173: invokespecial 794	com/tencent/moai/database/sqlite/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   176: aload_0
    //   177: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   180: iload 17
    //   182: invokevirtual 850	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:endOperationDeferLog	(I)Z
    //   185: ifeq +76 -> 261
    //   188: aload_0
    //   189: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   192: iload 17
    //   194: new 239	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   201: ldc_w 872
    //   204: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_3
    //   208: invokevirtual 875	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   211: ldc_w 877
    //   214: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: iload 4
    //   219: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: ldc_w 879
    //   225: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: iload 6
    //   230: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   233: ldc_w 881
    //   236: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: iload 5
    //   241: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   244: ldc_w 883
    //   247: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: iload 8
    //   252: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   255: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokevirtual 856	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:logOperation	(ILjava/lang/String;)V
    //   261: aload_3
    //   262: invokevirtual 886	com/tencent/moai/database/sqlite/CursorWindow:releaseReference	()V
    //   265: iload 8
    //   267: ireturn
    //   268: astore_1
    //   269: iconst_m1
    //   270: istore 5
    //   272: iconst_m1
    //   273: istore 8
    //   275: iconst_m1
    //   276: istore 6
    //   278: iload 5
    //   280: istore 11
    //   282: iload 8
    //   284: istore 10
    //   286: iload 6
    //   288: istore 9
    //   290: aload_0
    //   291: aload 7
    //   293: invokespecial 792	com/tencent/moai/database/sqlite/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/moai/database/sqlite/CancellationSignal;)V
    //   296: iload 5
    //   298: istore 11
    //   300: iload 8
    //   302: istore 10
    //   304: iload 6
    //   306: istore 9
    //   308: aload_1
    //   309: athrow
    //   310: astore_1
    //   311: iload 11
    //   313: istore 5
    //   315: iload 10
    //   317: istore 6
    //   319: iload 9
    //   321: istore 11
    //   323: iload 5
    //   325: istore 12
    //   327: iload 6
    //   329: istore 13
    //   331: iload 11
    //   333: istore 14
    //   335: iload 5
    //   337: istore 8
    //   339: iload 6
    //   341: istore 9
    //   343: iload 11
    //   345: istore 10
    //   347: aload_0
    //   348: aload 20
    //   350: invokespecial 794	com/tencent/moai/database/sqlite/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   353: iload 5
    //   355: istore 12
    //   357: iload 6
    //   359: istore 13
    //   361: iload 11
    //   363: istore 14
    //   365: iload 5
    //   367: istore 8
    //   369: iload 6
    //   371: istore 9
    //   373: iload 11
    //   375: istore 10
    //   377: aload_1
    //   378: athrow
    //   379: astore_1
    //   380: iload 12
    //   382: istore 8
    //   384: iload 13
    //   386: istore 9
    //   388: iload 14
    //   390: istore 10
    //   392: aload_0
    //   393: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   396: iload 17
    //   398: aload_1
    //   399: invokevirtual 798	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   402: iload 12
    //   404: istore 8
    //   406: iload 13
    //   408: istore 9
    //   410: iload 14
    //   412: istore 10
    //   414: aload_1
    //   415: athrow
    //   416: astore_1
    //   417: aload_0
    //   418: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   421: iload 17
    //   423: invokevirtual 850	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:endOperationDeferLog	(I)Z
    //   426: ifeq +76 -> 502
    //   429: aload_0
    //   430: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   433: iload 17
    //   435: new 239	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   442: ldc_w 872
    //   445: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload_3
    //   449: invokevirtual 875	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   452: ldc_w 877
    //   455: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: iload 4
    //   460: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   463: ldc_w 879
    //   466: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: iload 10
    //   471: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   474: ldc_w 881
    //   477: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: iload 8
    //   482: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   485: ldc_w 883
    //   488: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: iload 9
    //   493: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   496: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: invokevirtual 856	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:logOperation	(ILjava/lang/String;)V
    //   502: aload_1
    //   503: athrow
    //   504: astore_1
    //   505: aload_3
    //   506: invokevirtual 886	com/tencent/moai/database/sqlite/CursorWindow:releaseReference	()V
    //   509: aload_1
    //   510: athrow
    //   511: astore_1
    //   512: iload 8
    //   514: istore 9
    //   516: iload 5
    //   518: istore 8
    //   520: iload 6
    //   522: istore 10
    //   524: goto -107 -> 417
    //   527: astore_1
    //   528: iload 5
    //   530: istore 12
    //   532: iload 8
    //   534: istore 13
    //   536: iload 6
    //   538: istore 14
    //   540: goto -160 -> 380
    //   543: astore_1
    //   544: iload 16
    //   546: istore 5
    //   548: iload 15
    //   550: istore 6
    //   552: goto -229 -> 323
    //   555: astore_1
    //   556: iconst_m1
    //   557: istore 5
    //   559: goto -281 -> 278
    //   562: astore_1
    //   563: goto -285 -> 278
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	566	0	this	SQLiteConnection
    //   0	566	1	paramString	String
    //   0	566	2	paramArrayOfObject	Object[]
    //   0	566	3	paramCursorWindow	CursorWindow
    //   0	566	4	paramInt1	int
    //   0	566	5	paramInt2	int
    //   0	566	6	paramInt3	int
    //   0	566	7	paramCancellationSignal	CancellationSignal
    //   61	472	8	i	int
    //   65	450	9	j	int
    //   69	454	10	k	int
    //   25	349	11	m	int
    //   49	482	12	n	int
    //   53	482	13	i1	int
    //   57	482	14	i2	int
    //   28	521	15	i3	int
    //   31	514	16	i4	int
    //   45	389	17	i5	int
    //   125	11	18	l	long
    //   76	273	20	localPreparedStatement	PreparedStatement
    // Exception table:
    //   from	to	target	type
    //   103	127	268	finally
    //   164	170	310	finally
    //   290	296	310	finally
    //   308	310	310	finally
    //   71	78	379	java/lang/RuntimeException
    //   347	353	379	java/lang/RuntimeException
    //   377	379	379	java/lang/RuntimeException
    //   71	78	416	finally
    //   347	353	416	finally
    //   377	379	416	finally
    //   392	402	416	finally
    //   414	416	416	finally
    //   33	47	504	finally
    //   176	261	504	finally
    //   417	502	504	finally
    //   502	504	504	finally
    //   170	176	511	finally
    //   170	176	527	java/lang/RuntimeException
    //   78	103	543	finally
    //   140	146	555	finally
    //   146	152	562	finally
  }
  
  /* Error */
  public int executeForCursorWindow(String paramString, Object[] paramArrayOfObject, SparseParcelWindow paramSparseParcelWindow, int paramInt1, int paramInt2, int paramInt3, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 777	com/tencent/moai/database/sqlite/SQLiteConnection:throwIfSqlIsNull	(Ljava/lang/String;)V
    //   5: aload_3
    //   6: ifnonnull +14 -> 20
    //   9: new 620	java/lang/IllegalArgumentException
    //   12: dup
    //   13: ldc_w 858
    //   16: invokespecial 623	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   19: athrow
    //   20: aload_3
    //   21: invokevirtual 890	com/tencent/moai/database/sqlite/SparseParcelWindow:acquireReference	()V
    //   24: aload_0
    //   25: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   28: ldc_w 862
    //   31: aload_1
    //   32: aload_2
    //   33: invokevirtual 335	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   36: istore 11
    //   38: aload_0
    //   39: aload_1
    //   40: invokespecial 780	com/tencent/moai/database/sqlite/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;
    //   43: astore 14
    //   45: aload_0
    //   46: aload 14
    //   48: invokespecial 782	com/tencent/moai/database/sqlite/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   51: aload_0
    //   52: aload 14
    //   54: aload_2
    //   55: invokespecial 784	com/tencent/moai/database/sqlite/SQLiteConnection:bindArguments	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   58: aload_0
    //   59: aload 14
    //   61: invokespecial 786	com/tencent/moai/database/sqlite/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   64: aload_0
    //   65: aload 7
    //   67: invokespecial 788	com/tencent/moai/database/sqlite/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/moai/database/sqlite/CancellationSignal;)V
    //   70: aload_0
    //   71: getfield 169	com/tencent/moai/database/sqlite/SQLiteConnection:mConnectionPtr	I
    //   74: aload 14
    //   76: getfield 262	com/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   79: aload_3
    //   80: iload 4
    //   82: iload 5
    //   84: iload 6
    //   86: aload_3
    //   87: invokevirtual 893	com/tencent/moai/database/sqlite/SparseParcelWindow:getStatementStep	()I
    //   90: invokestatic 895	com/tencent/moai/database/sqlite/SQLiteConnection:nativeExecuteForCursorWindow	(IILcom/tencent/moai/database/sqlite/SparseParcelWindow;IIII)J
    //   93: lstore 12
    //   95: lload 12
    //   97: l2i
    //   98: istore 9
    //   100: aload_0
    //   101: aload 7
    //   103: invokespecial 792	com/tencent/moai/database/sqlite/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/moai/database/sqlite/CancellationSignal;)V
    //   106: iload 9
    //   108: istore 10
    //   110: iload 9
    //   112: istore 8
    //   114: aload_0
    //   115: aload 14
    //   117: invokespecial 794	com/tencent/moai/database/sqlite/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   120: aload_0
    //   121: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   124: iload 11
    //   126: invokevirtual 850	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:endOperationDeferLog	(I)Z
    //   129: ifeq +89 -> 218
    //   132: aload_0
    //   133: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   136: iload 11
    //   138: new 239	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   145: ldc_w 872
    //   148: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_3
    //   152: invokevirtual 875	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   155: ldc_w 897
    //   158: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: iload 4
    //   163: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: ldc_w 899
    //   169: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: iload 6
    //   174: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   177: ldc_w 901
    //   180: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: iload 5
    //   185: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   188: ldc_w 903
    //   191: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: iload 9
    //   196: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   199: ldc_w 905
    //   202: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_3
    //   206: invokevirtual 893	com/tencent/moai/database/sqlite/SparseParcelWindow:getStatementStep	()I
    //   209: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   212: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokevirtual 856	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:logOperation	(ILjava/lang/String;)V
    //   218: aload_3
    //   219: invokevirtual 906	com/tencent/moai/database/sqlite/SparseParcelWindow:releaseReference	()V
    //   222: iload 9
    //   224: ireturn
    //   225: astore_1
    //   226: aload_0
    //   227: aload 7
    //   229: invokespecial 792	com/tencent/moai/database/sqlite/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/moai/database/sqlite/CancellationSignal;)V
    //   232: aload_1
    //   233: athrow
    //   234: astore_1
    //   235: iconst_m1
    //   236: istore 9
    //   238: iload 9
    //   240: istore 10
    //   242: iload 9
    //   244: istore 8
    //   246: aload_0
    //   247: aload 14
    //   249: invokespecial 794	com/tencent/moai/database/sqlite/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   252: iload 9
    //   254: istore 10
    //   256: iload 9
    //   258: istore 8
    //   260: aload_1
    //   261: athrow
    //   262: astore_1
    //   263: iload 10
    //   265: istore 8
    //   267: aload_0
    //   268: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   271: iload 11
    //   273: aload_1
    //   274: invokevirtual 798	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   277: iload 10
    //   279: istore 8
    //   281: aload_1
    //   282: athrow
    //   283: astore_1
    //   284: aload_0
    //   285: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   288: iload 11
    //   290: invokevirtual 850	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:endOperationDeferLog	(I)Z
    //   293: ifeq +89 -> 382
    //   296: aload_0
    //   297: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   300: iload 11
    //   302: new 239	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   309: ldc_w 872
    //   312: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload_3
    //   316: invokevirtual 875	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   319: ldc_w 897
    //   322: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: iload 4
    //   327: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   330: ldc_w 899
    //   333: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: iload 6
    //   338: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   341: ldc_w 901
    //   344: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: iload 5
    //   349: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   352: ldc_w 903
    //   355: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: iload 8
    //   360: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   363: ldc_w 905
    //   366: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: aload_3
    //   370: invokevirtual 893	com/tencent/moai/database/sqlite/SparseParcelWindow:getStatementStep	()I
    //   373: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokevirtual 856	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:logOperation	(ILjava/lang/String;)V
    //   382: aload_1
    //   383: athrow
    //   384: astore_1
    //   385: aload_3
    //   386: invokevirtual 906	com/tencent/moai/database/sqlite/SparseParcelWindow:releaseReference	()V
    //   389: aload_1
    //   390: athrow
    //   391: astore_1
    //   392: iconst_m1
    //   393: istore 8
    //   395: goto -111 -> 284
    //   398: astore_1
    //   399: iconst_m1
    //   400: istore 10
    //   402: goto -139 -> 263
    //   405: astore_1
    //   406: goto -168 -> 238
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	409	0	this	SQLiteConnection
    //   0	409	1	paramString	String
    //   0	409	2	paramArrayOfObject	Object[]
    //   0	409	3	paramSparseParcelWindow	SparseParcelWindow
    //   0	409	4	paramInt1	int
    //   0	409	5	paramInt2	int
    //   0	409	6	paramInt3	int
    //   0	409	7	paramCancellationSignal	CancellationSignal
    //   112	282	8	i	int
    //   98	159	9	j	int
    //   108	293	10	k	int
    //   36	265	11	m	int
    //   93	3	12	l	long
    //   43	205	14	localPreparedStatement	PreparedStatement
    // Exception table:
    //   from	to	target	type
    //   70	95	225	finally
    //   45	70	234	finally
    //   226	234	234	finally
    //   114	120	262	java/lang/RuntimeException
    //   246	252	262	java/lang/RuntimeException
    //   260	262	262	java/lang/RuntimeException
    //   114	120	283	finally
    //   246	252	283	finally
    //   260	262	283	finally
    //   267	277	283	finally
    //   281	283	283	finally
    //   24	38	384	finally
    //   120	218	384	finally
    //   284	382	384	finally
    //   382	384	384	finally
    //   38	45	391	finally
    //   38	45	398	java/lang/RuntimeException
    //   100	106	405	finally
  }
  
  /* Error */
  public long executeForLastInsertedRowId(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 777	com/tencent/moai/database/sqlite/SQLiteConnection:throwIfSqlIsNull	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   9: ldc_w 908
    //   12: aload_1
    //   13: aload_2
    //   14: invokevirtual 335	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   17: istore 4
    //   19: aload_0
    //   20: aload_1
    //   21: invokespecial 780	com/tencent/moai/database/sqlite/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;
    //   24: astore_1
    //   25: aload_0
    //   26: aload_1
    //   27: invokespecial 782	com/tencent/moai/database/sqlite/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   30: aload_0
    //   31: aload_1
    //   32: aload_2
    //   33: invokespecial 784	com/tencent/moai/database/sqlite/SQLiteConnection:bindArguments	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   36: aload_0
    //   37: aload_1
    //   38: invokespecial 786	com/tencent/moai/database/sqlite/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   41: aload_0
    //   42: aload_3
    //   43: invokespecial 788	com/tencent/moai/database/sqlite/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/moai/database/sqlite/CancellationSignal;)V
    //   46: aload_0
    //   47: getfield 169	com/tencent/moai/database/sqlite/SQLiteConnection:mConnectionPtr	I
    //   50: aload_1
    //   51: getfield 262	com/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   54: invokestatic 910	com/tencent/moai/database/sqlite/SQLiteConnection:nativeExecuteForLastInsertedRowId	(II)J
    //   57: lstore 5
    //   59: aload_0
    //   60: aload_3
    //   61: invokespecial 792	com/tencent/moai/database/sqlite/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/moai/database/sqlite/CancellationSignal;)V
    //   64: aload_0
    //   65: aload_1
    //   66: invokespecial 794	com/tencent/moai/database/sqlite/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   69: aload_0
    //   70: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   73: iload 4
    //   75: invokevirtual 345	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:endOperation	(I)V
    //   78: lload 5
    //   80: lreturn
    //   81: astore_2
    //   82: aload_0
    //   83: aload_3
    //   84: invokespecial 792	com/tencent/moai/database/sqlite/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/moai/database/sqlite/CancellationSignal;)V
    //   87: aload_2
    //   88: athrow
    //   89: astore_2
    //   90: aload_0
    //   91: aload_1
    //   92: invokespecial 794	com/tencent/moai/database/sqlite/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   95: aload_2
    //   96: athrow
    //   97: astore_1
    //   98: aload_0
    //   99: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   102: iload 4
    //   104: aload_1
    //   105: invokevirtual 798	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   108: aload_1
    //   109: athrow
    //   110: astore_1
    //   111: aload_0
    //   112: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   115: iload 4
    //   117: invokevirtual 345	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:endOperation	(I)V
    //   120: aload_1
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	SQLiteConnection
    //   0	122	1	paramString	String
    //   0	122	2	paramArrayOfObject	Object[]
    //   0	122	3	paramCancellationSignal	CancellationSignal
    //   17	99	4	i	int
    //   57	22	5	l	long
    // Exception table:
    //   from	to	target	type
    //   46	59	81	finally
    //   25	46	89	finally
    //   59	64	89	finally
    //   82	89	89	finally
    //   19	25	97	java/lang/RuntimeException
    //   64	69	97	java/lang/RuntimeException
    //   90	97	97	java/lang/RuntimeException
    //   19	25	110	finally
    //   64	69	110	finally
    //   90	97	110	finally
    //   98	110	110	finally
  }
  
  /* Error */
  public long executeForLong(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 777	com/tencent/moai/database/sqlite/SQLiteConnection:throwIfSqlIsNull	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   9: ldc_w 911
    //   12: aload_1
    //   13: aload_2
    //   14: invokevirtual 335	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   17: istore 4
    //   19: aload_0
    //   20: aload_1
    //   21: invokespecial 780	com/tencent/moai/database/sqlite/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;
    //   24: astore_1
    //   25: aload_0
    //   26: aload_1
    //   27: invokespecial 782	com/tencent/moai/database/sqlite/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   30: aload_0
    //   31: aload_1
    //   32: aload_2
    //   33: invokespecial 784	com/tencent/moai/database/sqlite/SQLiteConnection:bindArguments	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   36: aload_0
    //   37: aload_1
    //   38: invokespecial 786	com/tencent/moai/database/sqlite/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   41: aload_0
    //   42: aload_3
    //   43: invokespecial 788	com/tencent/moai/database/sqlite/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/moai/database/sqlite/CancellationSignal;)V
    //   46: aload_0
    //   47: getfield 169	com/tencent/moai/database/sqlite/SQLiteConnection:mConnectionPtr	I
    //   50: aload_1
    //   51: getfield 262	com/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   54: invokestatic 913	com/tencent/moai/database/sqlite/SQLiteConnection:nativeExecuteForLong	(II)J
    //   57: lstore 5
    //   59: aload_0
    //   60: aload_3
    //   61: invokespecial 792	com/tencent/moai/database/sqlite/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/moai/database/sqlite/CancellationSignal;)V
    //   64: aload_0
    //   65: aload_1
    //   66: invokespecial 794	com/tencent/moai/database/sqlite/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   69: aload_0
    //   70: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   73: iload 4
    //   75: invokevirtual 345	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:endOperation	(I)V
    //   78: lload 5
    //   80: lreturn
    //   81: astore_2
    //   82: aload_0
    //   83: aload_3
    //   84: invokespecial 792	com/tencent/moai/database/sqlite/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/moai/database/sqlite/CancellationSignal;)V
    //   87: aload_2
    //   88: athrow
    //   89: astore_2
    //   90: aload_0
    //   91: aload_1
    //   92: invokespecial 794	com/tencent/moai/database/sqlite/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   95: aload_2
    //   96: athrow
    //   97: astore_1
    //   98: aload_0
    //   99: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   102: iload 4
    //   104: aload_1
    //   105: invokevirtual 798	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   108: aload_1
    //   109: athrow
    //   110: astore_1
    //   111: aload_0
    //   112: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   115: iload 4
    //   117: invokevirtual 345	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:endOperation	(I)V
    //   120: aload_1
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	SQLiteConnection
    //   0	122	1	paramString	String
    //   0	122	2	paramArrayOfObject	Object[]
    //   0	122	3	paramCancellationSignal	CancellationSignal
    //   17	99	4	i	int
    //   57	22	5	l	long
    // Exception table:
    //   from	to	target	type
    //   46	59	81	finally
    //   25	46	89	finally
    //   59	64	89	finally
    //   82	89	89	finally
    //   19	25	97	java/lang/RuntimeException
    //   64	69	97	java/lang/RuntimeException
    //   90	97	97	java/lang/RuntimeException
    //   19	25	110	finally
    //   64	69	110	finally
    //   90	97	110	finally
    //   98	110	110	finally
  }
  
  /* Error */
  public String executeForString(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 777	com/tencent/moai/database/sqlite/SQLiteConnection:throwIfSqlIsNull	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   9: ldc_w 914
    //   12: aload_1
    //   13: aload_2
    //   14: invokevirtual 335	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   17: istore 4
    //   19: aload_0
    //   20: aload_1
    //   21: invokespecial 780	com/tencent/moai/database/sqlite/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;
    //   24: astore_1
    //   25: aload_0
    //   26: aload_1
    //   27: invokespecial 782	com/tencent/moai/database/sqlite/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   30: aload_0
    //   31: aload_1
    //   32: aload_2
    //   33: invokespecial 784	com/tencent/moai/database/sqlite/SQLiteConnection:bindArguments	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   36: aload_0
    //   37: aload_1
    //   38: invokespecial 786	com/tencent/moai/database/sqlite/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   41: aload_0
    //   42: aload_3
    //   43: invokespecial 788	com/tencent/moai/database/sqlite/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/moai/database/sqlite/CancellationSignal;)V
    //   46: aload_0
    //   47: getfield 169	com/tencent/moai/database/sqlite/SQLiteConnection:mConnectionPtr	I
    //   50: aload_1
    //   51: getfield 262	com/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   54: invokestatic 916	com/tencent/moai/database/sqlite/SQLiteConnection:nativeExecuteForString	(II)Ljava/lang/String;
    //   57: astore_2
    //   58: aload_0
    //   59: aload_3
    //   60: invokespecial 792	com/tencent/moai/database/sqlite/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/moai/database/sqlite/CancellationSignal;)V
    //   63: aload_0
    //   64: aload_1
    //   65: invokespecial 794	com/tencent/moai/database/sqlite/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   68: aload_0
    //   69: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   72: iload 4
    //   74: invokevirtual 345	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:endOperation	(I)V
    //   77: aload_2
    //   78: areturn
    //   79: astore_2
    //   80: aload_0
    //   81: aload_3
    //   82: invokespecial 792	com/tencent/moai/database/sqlite/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/moai/database/sqlite/CancellationSignal;)V
    //   85: aload_2
    //   86: athrow
    //   87: astore_2
    //   88: aload_0
    //   89: aload_1
    //   90: invokespecial 794	com/tencent/moai/database/sqlite/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   93: aload_2
    //   94: athrow
    //   95: astore_1
    //   96: aload_0
    //   97: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   100: iload 4
    //   102: aload_1
    //   103: invokevirtual 798	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   106: aload_1
    //   107: athrow
    //   108: astore_1
    //   109: aload_0
    //   110: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   113: iload 4
    //   115: invokevirtual 345	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:endOperation	(I)V
    //   118: aload_1
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	SQLiteConnection
    //   0	120	1	paramString	String
    //   0	120	2	paramArrayOfObject	Object[]
    //   0	120	3	paramCancellationSignal	CancellationSignal
    //   17	97	4	i	int
    // Exception table:
    //   from	to	target	type
    //   46	58	79	finally
    //   25	46	87	finally
    //   58	63	87	finally
    //   80	87	87	finally
    //   19	25	95	java/lang/RuntimeException
    //   63	68	95	java/lang/RuntimeException
    //   88	95	95	java/lang/RuntimeException
    //   19	25	108	finally
    //   63	68	108	finally
    //   88	95	108	finally
    //   96	108	108	finally
  }
  
  public SQLiteBlob executeOpenBlob(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    int i = this.mRecentOperations.beginOperation("executeForSQLiteBlob", String.format("sqlite3_open_blob <= table=%s.%s column=%s flags=%d row=%d", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), null);
    try
    {
      int j = nativeOpenBlob(this.mConnectionPtr, paramInt1, paramString1, paramString2, paramString3, paramInt2);
      paramString1 = new SQLiteBlob(j, paramInt1, paramString1, paramString2, paramString3, paramInt2, nativeGetBlobSize(j));
      return paramString1;
    }
    catch (RuntimeException paramString1)
    {
      this.mRecentOperations.failOperation(i, paramString1);
      throw paramString1;
    }
    finally
    {
      this.mRecentOperations.endOperation(i);
    }
  }
  
  public void executeReadBlob(SQLiteBlob paramSQLiteBlob, int paramInt)
  {
    int i = this.mRecentOperations.beginOperation("executeForSQLiteBlob", String.format("sqlite3_read_blob <= table=%s.%s column=%s flags=%d row=%d offset=%d", new Object[] { paramSQLiteBlob.getDbName(), paramSQLiteBlob.getTableName(), paramSQLiteBlob.getColumnName(), Integer.valueOf(paramSQLiteBlob.getFlags()), Integer.valueOf(paramSQLiteBlob.getRowId()), Integer.valueOf(paramInt) }), null);
    try
    {
      Log.v("SQLiteConnection", String.format("sqlite3_read_blob <= table=%s.%s column=%s flags=%d row=%d offset=%d length=%d", new Object[] { paramSQLiteBlob.getDbName(), paramSQLiteBlob.getTableName(), paramSQLiteBlob.getColumnName(), Integer.valueOf(paramSQLiteBlob.getFlags()), Integer.valueOf(paramSQLiteBlob.getRowId()), Integer.valueOf(paramInt), Integer.valueOf(paramSQLiteBlob.getBufferSize()) }));
      paramSQLiteBlob.setNativeBufferPtr(nativeReadBlob(paramSQLiteBlob.getBlobPtr(), paramSQLiteBlob.getBuffer(), paramSQLiteBlob.getNativeBufferPtr(), paramSQLiteBlob.getBufferSize(), paramInt));
      return;
    }
    catch (RuntimeException paramSQLiteBlob)
    {
      this.mRecentOperations.failOperation(i, paramSQLiteBlob);
      throw paramSQLiteBlob;
    }
    finally
    {
      this.mRecentOperations.endOperation(i);
    }
  }
  
  public void executeWriteBlob(SQLiteBlob paramSQLiteBlob)
  {
    int i = this.mRecentOperations.beginOperation("executeForSQLiteBlob", String.format("sqlite3_write_blob <= table=%s.%s column=%s flags=%d row=%d", new Object[] { paramSQLiteBlob.getDbName(), paramSQLiteBlob.getTableName(), paramSQLiteBlob.getColumnName(), Integer.valueOf(paramSQLiteBlob.getFlags()), Integer.valueOf(paramSQLiteBlob.getRowId()) }), null);
    try
    {
      paramSQLiteBlob.setNativeBufferPtr(nativeWriteBlob(paramSQLiteBlob.getBlobPtr(), paramSQLiteBlob.getBuffer(), paramSQLiteBlob.getNativeBufferPtr(), paramSQLiteBlob.getBufferSize(), paramSQLiteBlob.getWriteOffset()));
      return;
    }
    catch (RuntimeException paramSQLiteBlob)
    {
      this.mRecentOperations.failOperation(i, paramSQLiteBlob);
      throw paramSQLiteBlob;
    }
    finally
    {
      this.mRecentOperations.endOperation(i);
    }
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
  
  public void interrupt()
  {
    nativeInterrupt(this.mConnectionPtr);
    this.mInterrupted = true;
  }
  
  public SQLiteConnection interrupted()
  {
    this.mInterrupted = false;
    return this;
  }
  
  public boolean isInterrupted()
  {
    return this.mInterrupted;
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
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 777	com/tencent/moai/database/sqlite/SQLiteConnection:throwIfSqlIsNull	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   9: ldc_w 983
    //   12: aload_1
    //   13: aconst_null
    //   14: invokevirtual 335	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   17: istore 4
    //   19: aload_0
    //   20: aload_1
    //   21: invokespecial 780	com/tencent/moai/database/sqlite/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;
    //   24: astore_1
    //   25: aload_2
    //   26: ifnull +44 -> 70
    //   29: aload_2
    //   30: aload_1
    //   31: getfield 235	com/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement:mNumParameters	I
    //   34: putfield 988	com/tencent/moai/database/sqlite/SQLiteStatementInfo:numParameters	I
    //   37: aload_2
    //   38: aload_1
    //   39: getfield 213	com/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement:mReadOnly	Z
    //   42: putfield 991	com/tencent/moai/database/sqlite/SQLiteStatementInfo:readOnly	Z
    //   45: aload_0
    //   46: getfield 169	com/tencent/moai/database/sqlite/SQLiteConnection:mConnectionPtr	I
    //   49: aload_1
    //   50: getfield 262	com/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   53: invokestatic 993	com/tencent/moai/database/sqlite/SQLiteConnection:nativeGetColumnCount	(II)I
    //   56: istore 5
    //   58: iload 5
    //   60: ifne +25 -> 85
    //   63: aload_2
    //   64: getstatic 72	com/tencent/moai/database/sqlite/SQLiteConnection:EMPTY_STRING_ARRAY	[Ljava/lang/String;
    //   67: putfield 996	com/tencent/moai/database/sqlite/SQLiteStatementInfo:columnNames	[Ljava/lang/String;
    //   70: aload_0
    //   71: aload_1
    //   72: invokespecial 794	com/tencent/moai/database/sqlite/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   75: aload_0
    //   76: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   79: iload 4
    //   81: invokevirtual 345	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:endOperation	(I)V
    //   84: return
    //   85: aload_2
    //   86: iload 5
    //   88: anewarray 70	java/lang/String
    //   91: putfield 996	com/tencent/moai/database/sqlite/SQLiteStatementInfo:columnNames	[Ljava/lang/String;
    //   94: iconst_0
    //   95: istore_3
    //   96: iload_3
    //   97: iload 5
    //   99: if_icmpge -29 -> 70
    //   102: aload_2
    //   103: getfield 996	com/tencent/moai/database/sqlite/SQLiteStatementInfo:columnNames	[Ljava/lang/String;
    //   106: iload_3
    //   107: aload_0
    //   108: getfield 169	com/tencent/moai/database/sqlite/SQLiteConnection:mConnectionPtr	I
    //   111: aload_1
    //   112: getfield 262	com/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   115: iload_3
    //   116: invokestatic 998	com/tencent/moai/database/sqlite/SQLiteConnection:nativeGetColumnName	(III)Ljava/lang/String;
    //   119: aastore
    //   120: iload_3
    //   121: iconst_1
    //   122: iadd
    //   123: istore_3
    //   124: goto -28 -> 96
    //   127: astore_2
    //   128: aload_0
    //   129: aload_1
    //   130: invokespecial 794	com/tencent/moai/database/sqlite/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/moai/database/sqlite/SQLiteConnection$PreparedStatement;)V
    //   133: aload_2
    //   134: athrow
    //   135: astore_1
    //   136: aload_0
    //   137: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   140: iload 4
    //   142: aload_1
    //   143: invokevirtual 798	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   146: aload_1
    //   147: athrow
    //   148: astore_1
    //   149: aload_0
    //   150: getfield 107	com/tencent/moai/database/sqlite/SQLiteConnection:mRecentOperations	Lcom/tencent/moai/database/sqlite/SQLiteConnection$OperationLog;
    //   153: iload 4
    //   155: invokevirtual 345	com/tencent/moai/database/sqlite/SQLiteConnection$OperationLog:endOperation	(I)V
    //   158: aload_1
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	SQLiteConnection
    //   0	160	1	paramString	String
    //   0	160	2	paramSQLiteStatementInfo	SQLiteStatementInfo
    //   95	29	3	i	int
    //   17	137	4	j	int
    //   56	44	5	k	int
    // Exception table:
    //   from	to	target	type
    //   29	58	127	finally
    //   63	70	127	finally
    //   85	94	127	finally
    //   102	120	127	finally
    //   19	25	135	java/lang/RuntimeException
    //   70	75	135	java/lang/RuntimeException
    //   128	135	135	java/lang/RuntimeException
    //   19	25	148	finally
    //   70	75	148	finally
    //   128	135	148	finally
    //   136	148	148	finally
  }
  
  void reconfigure(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration)
  {
    int j = 1;
    this.mOnlyAllowReadOnlyOperations = false;
    int k = paramSQLiteDatabaseConfiguration.customFunctions.size();
    int i = 0;
    while (i < k)
    {
      localObject = (SQLiteCustomFunction)paramSQLiteDatabaseConfiguration.customFunctions.get(i);
      if (!this.mConfiguration.customFunctions.contains(localObject)) {
        nativeRegisterCustomFunction(this.mConnectionPtr, (SQLiteCustomFunction)localObject);
      }
      i += 1;
    }
    Object localObject = paramSQLiteDatabaseConfiguration.updateHooks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      SQLiteDatabase.UpdateHookWrapper localUpdateHookWrapper = (SQLiteDatabase.UpdateHookWrapper)((Iterator)localObject).next();
      if (!this.mConfiguration.updateHooks.contains(localUpdateHookWrapper)) {
        nativeRegisterUpdateHook(this.mConnectionPtr, localUpdateHookWrapper);
      }
    }
    if ((paramSQLiteDatabaseConfiguration.profile != null) && (this.mConfiguration.profile != paramSQLiteDatabaseConfiguration.profile)) {
      nativeRegisterProfile(this.mConnectionPtr, paramSQLiteDatabaseConfiguration.profile);
    }
    if (paramSQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled != this.mConfiguration.foreignKeyConstraintsEnabled)
    {
      i = 1;
      if (((paramSQLiteDatabaseConfiguration.openFlags ^ this.mConfiguration.openFlags) & 0x20000000) == 0) {
        break label223;
      }
    }
    for (;;)
    {
      this.mConfiguration.updateParametersFrom(paramSQLiteDatabaseConfiguration);
      if (i != 0) {
        setForeignKeyModeFromConfiguration();
      }
      if (j != 0) {
        setWalModeFromConfiguration();
      }
      return;
      i = 0;
      break;
      label223:
      j = 0;
    }
  }
  
  public void removeAttachedDataBase(String paramString)
  {
    if (this.mAttachedDataBases.containsKey(paramString))
    {
      this.mAttachedDataBases.remove(paramString);
      return;
    }
    throw new IllegalStateException("alias " + paramString);
  }
  
  void setOnlyAllowReadOnlyOperations(boolean paramBoolean)
  {
    this.mOnlyAllowReadOnlyOperations = paramBoolean;
  }
  
  public String toString()
  {
    return "SQLiteConnection: " + this.mConfiguration.path + " (" + this.mConnectionId + ", " + this.priority + ")";
  }
  
  static final class Operation
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
  
  static final class OperationLog
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
              localOperation1.mBindArgs.add(SQLiteConnection.EMPTY_BYTE_ARRAY);
              break label237;
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
        break label237;
        label207:
        localOperation1.mCookie = newOperationCookieLocked(j);
        this.mIndex = j;
        i = localOperation1.mCookie;
        return i;
        label237:
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
  
  static final class PreparedStatement
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
  
  final class PreparedStatementCache
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
        localObject1 = ((Map)localObject1).entrySet().iterator();
        int i = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.database.sqlite.SQLiteConnection
 * JD-Core Version:    0.7.0.1
 */