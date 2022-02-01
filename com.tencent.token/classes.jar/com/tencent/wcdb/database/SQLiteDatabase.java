package com.tencent.wcdb.database;

import android.content.ContentValues;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Printer;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.DefaultDatabaseErrorHandler;
import com.tencent.wcdb.SQLException;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class SQLiteDatabase
  extends SQLiteClosable
{
  public static final int CONFLICT_ABORT = 2;
  public static final int CONFLICT_FAIL = 3;
  public static final int CONFLICT_IGNORE = 4;
  public static final int CONFLICT_NONE = 0;
  public static final int CONFLICT_REPLACE = 5;
  public static final int CONFLICT_ROLLBACK = 1;
  private static final String[] CONFLICT_VALUES = { "", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE " };
  public static final int CREATE_IF_NECESSARY = 268435456;
  public static final int ENABLE_IO_TRACE = 256;
  public static final int ENABLE_WRITE_AHEAD_LOGGING = 536870912;
  public static final int MAX_SQL_CACHE_SIZE = 100;
  public static final int NO_LOCALIZED_COLLATORS = 16;
  public static final int OPEN_READONLY = 1;
  public static final int OPEN_READWRITE = 0;
  private static final int OPEN_READ_MASK = 1;
  public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
  public static final int SYNCHRONOUS_EXTRA = 3;
  public static final int SYNCHRONOUS_FULL = 2;
  public static final int SYNCHRONOUS_NORMAL = 1;
  public static final int SYNCHRONOUS_OFF = 0;
  private static final String TAG = "WCDB.SQLiteDatabase";
  private static final WeakHashMap<SQLiteDatabase, Object> sActiveDatabases;
  private final SQLiteDatabaseConfiguration mConfigurationLocked;
  private SQLiteConnectionPool mConnectionPoolLocked;
  private final CursorFactory mCursorFactory;
  private final DatabaseErrorHandler mErrorHandler;
  private boolean mHasAttachedDbsLocked;
  private final Object mLock = new Object();
  private final ThreadLocal<SQLiteSession> mThreadSession = new ThreadLocal()
  {
    protected SQLiteSession initialValue()
    {
      return SQLiteDatabase.this.createSession();
    }
  };
  
  static
  {
    SQLiteGlobal.loadLib();
    sActiveDatabases = new WeakHashMap();
  }
  
  private SQLiteDatabase(String paramString, int paramInt, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    this.mCursorFactory = paramCursorFactory;
    if (paramDatabaseErrorHandler == null) {
      paramDatabaseErrorHandler = new DefaultDatabaseErrorHandler(true);
    }
    this.mErrorHandler = paramDatabaseErrorHandler;
    this.mConfigurationLocked = new SQLiteDatabaseConfiguration(paramString, paramInt);
  }
  
  private void beginTransaction(SQLiteTransactionListener paramSQLiteTransactionListener, boolean paramBoolean)
  {
    acquireReference();
    for (;;)
    {
      try
      {
        SQLiteSession localSQLiteSession = getThreadSession();
        if (paramBoolean)
        {
          i = 2;
          localSQLiteSession.beginTransaction(i, paramSQLiteTransactionListener, getThreadDefaultConnectionFlags(false), null);
          return;
        }
      }
      finally
      {
        releaseReference();
      }
      int i = 1;
    }
  }
  
  private void collectDbStats(ArrayList<SQLiteDebug.DbStats> paramArrayList)
  {
    synchronized (this.mLock)
    {
      if (this.mConnectionPoolLocked != null) {
        this.mConnectionPoolLocked.collectDbStats(paramArrayList);
      }
      return;
    }
  }
  
  public static SQLiteDatabase create(CursorFactory paramCursorFactory)
  {
    return openDatabase(":memory:", paramCursorFactory, 268435456);
  }
  
  public static boolean deleteDatabase(File paramFile)
  {
    if (paramFile != null)
    {
      boolean bool1 = paramFile.delete();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramFile.getPath());
      ((StringBuilder)localObject).append("-journal");
      boolean bool2 = new File(((StringBuilder)localObject).toString()).delete();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramFile.getPath());
      ((StringBuilder)localObject).append("-shm");
      boolean bool3 = new File(((StringBuilder)localObject).toString()).delete();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramFile.getPath());
      ((StringBuilder)localObject).append("-wal");
      bool1 = bool1 | bool2 | bool3 | new File(((StringBuilder)localObject).toString()).delete();
      localObject = paramFile.getParentFile();
      bool2 = bool1;
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramFile.getName());
        localStringBuilder.append("-mj");
        paramFile = ((File)localObject).listFiles(new FileFilter()
        {
          public boolean accept(File paramAnonymousFile)
          {
            return paramAnonymousFile.getName().startsWith(this.val$prefix);
          }
        });
        bool2 = bool1;
        if (paramFile != null)
        {
          int j = paramFile.length;
          int i = 0;
          for (;;)
          {
            bool2 = bool1;
            if (i >= j) {
              break;
            }
            bool1 |= paramFile[i].delete();
            i += 1;
          }
        }
      }
      return bool2;
    }
    throw new IllegalArgumentException("file must not be null");
  }
  
  private void dispose(boolean paramBoolean)
  {
    synchronized (this.mLock)
    {
      SQLiteConnectionPool localSQLiteConnectionPool = this.mConnectionPoolLocked;
      this.mConnectionPoolLocked = null;
      if (!paramBoolean) {
        synchronized (sActiveDatabases)
        {
          sActiveDatabases.remove(this);
          if (localSQLiteConnectionPool != null)
          {
            localSQLiteConnectionPool.close();
            return;
          }
        }
      }
      return;
    }
  }
  
  public static void dumpAll(Printer paramPrinter, boolean paramBoolean)
  {
    Iterator localIterator = getActiveDatabases().iterator();
    while (localIterator.hasNext()) {
      ((SQLiteDatabase)localIterator.next()).dump(paramPrinter, paramBoolean);
    }
  }
  
  /* Error */
  private int executeSql(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 135	com/tencent/wcdb/database/SQLiteDatabase:acquireReference	()V
    //   4: aload_1
    //   5: invokestatic 259	com/tencent/wcdb/DatabaseUtils:getSqlStatementType	(Ljava/lang/String;)I
    //   8: iconst_3
    //   9: if_icmpne +51 -> 60
    //   12: iconst_0
    //   13: istore 4
    //   15: aload_0
    //   16: getfield 114	com/tencent/wcdb/database/SQLiteDatabase:mLock	Ljava/lang/Object;
    //   19: astore 5
    //   21: aload 5
    //   23: monitorenter
    //   24: aload_0
    //   25: getfield 261	com/tencent/wcdb/database/SQLiteDatabase:mHasAttachedDbsLocked	Z
    //   28: ifne +11 -> 39
    //   31: aload_0
    //   32: iconst_1
    //   33: putfield 261	com/tencent/wcdb/database/SQLiteDatabase:mHasAttachedDbsLocked	Z
    //   36: iconst_1
    //   37: istore 4
    //   39: aload 5
    //   41: monitorexit
    //   42: iload 4
    //   44: ifeq +16 -> 60
    //   47: aload_0
    //   48: invokevirtual 264	com/tencent/wcdb/database/SQLiteDatabase:disableWriteAheadLogging	()V
    //   51: goto +9 -> 60
    //   54: astore_1
    //   55: aload 5
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    //   60: new 266	com/tencent/wcdb/database/SQLiteStatement
    //   63: dup
    //   64: aload_0
    //   65: aload_1
    //   66: aload_2
    //   67: invokespecial 269	com/tencent/wcdb/database/SQLiteStatement:<init>	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: astore_1
    //   71: aload_1
    //   72: aload_3
    //   73: invokevirtual 273	com/tencent/wcdb/database/SQLiteStatement:executeUpdateDelete	(Lcom/tencent/wcdb/support/CancellationSignal;)I
    //   76: istore 4
    //   78: aload_1
    //   79: invokevirtual 274	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   82: aload_0
    //   83: invokevirtual 151	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   86: iload 4
    //   88: ireturn
    //   89: astore_2
    //   90: aload_1
    //   91: invokevirtual 274	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   94: aload_2
    //   95: athrow
    //   96: astore_1
    //   97: aload_0
    //   98: invokevirtual 151	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   101: aload_1
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	SQLiteDatabase
    //   0	103	1	paramString	String
    //   0	103	2	paramArrayOfObject	Object[]
    //   0	103	3	paramCancellationSignal	CancellationSignal
    //   13	74	4	i	int
    // Exception table:
    //   from	to	target	type
    //   24	36	54	finally
    //   39	42	54	finally
    //   55	58	54	finally
    //   71	78	89	finally
    //   4	12	96	finally
    //   15	24	96	finally
    //   47	51	96	finally
    //   58	60	96	finally
    //   60	71	96	finally
    //   78	82	96	finally
    //   90	96	96	finally
  }
  
  public static String findEditTable(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.indexOf(' ');
      int j = paramString.indexOf(',');
      if ((i > 0) && ((i < j) || (j < 0))) {
        return paramString.substring(0, i);
      }
      if ((j > 0) && ((j < i) || (i < 0))) {
        return paramString.substring(0, j);
      }
      return paramString;
    }
    throw new IllegalStateException("Invalid tables");
  }
  
  private static ArrayList<SQLiteDatabase> getActiveDatabases()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (sActiveDatabases)
    {
      localArrayList.addAll(sActiveDatabases.keySet());
      return localArrayList;
    }
  }
  
  static ArrayList<SQLiteDebug.DbStats> getDbStats()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getActiveDatabases().iterator();
    while (localIterator.hasNext()) {
      ((SQLiteDatabase)localIterator.next()).collectDbStats(localArrayList);
    }
    return localArrayList;
  }
  
  private static boolean isMainThread()
  {
    Looper localLooper = Looper.myLooper();
    return (localLooper != null) && (localLooper == Looper.getMainLooper());
  }
  
  private boolean isReadOnlyLocked()
  {
    return (this.mConfigurationLocked.openFlags & 0x1) == 1;
  }
  
  private Set<String> keySet(ContentValues paramContentValues)
  {
    if (Build.VERSION.SDK_INT < 11) {
      try
      {
        Field localField = Class.forName("android.content.ContentValues").getDeclaredField("mValues");
        localField.setAccessible(true);
        paramContentValues = ((HashMap)localField.get(paramContentValues)).keySet();
        return paramContentValues;
      }
      catch (Exception paramContentValues)
      {
        throw new RuntimeException(paramContentValues);
      }
    }
    return paramContentValues.keySet();
  }
  
  private void open(byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, int paramInt)
  {
    try
    {
      openInner(paramArrayOfByte, paramSQLiteCipherSpec, paramInt);
      return;
    }
    catch (SQLiteException paramArrayOfByte)
    {
      break label24;
      onCorruption();
      openInner(paramArrayOfByte, paramSQLiteCipherSpec, paramInt);
      return;
      paramSQLiteCipherSpec = new StringBuilder();
      paramSQLiteCipherSpec.append("Failed to open database '");
      paramSQLiteCipherSpec.append(getLabel());
      paramSQLiteCipherSpec.append("'.");
      Log.e("WCDB.SQLiteDatabase", paramSQLiteCipherSpec.toString(), new Object[] { paramArrayOfByte });
      close();
      throw paramArrayOfByte;
    }
    catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
    {
      label12:
      label24:
      break label12;
    }
  }
  
  public static SQLiteDatabase openDatabase(String paramString, CursorFactory paramCursorFactory, int paramInt)
  {
    return openDatabase(paramString, paramCursorFactory, paramInt, null);
  }
  
  public static SQLiteDatabase openDatabase(String paramString, CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return openDatabase(paramString, null, null, paramCursorFactory, paramInt, paramDatabaseErrorHandler, 0);
  }
  
  public static SQLiteDatabase openDatabase(String paramString, CursorFactory paramCursorFactory, int paramInt1, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt2)
  {
    return openDatabase(paramString, null, null, paramCursorFactory, paramInt1, paramDatabaseErrorHandler, paramInt2);
  }
  
  public static SQLiteDatabase openDatabase(String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return openDatabase(paramString, paramArrayOfByte, paramSQLiteCipherSpec, paramCursorFactory, paramInt, paramDatabaseErrorHandler, 0);
  }
  
  public static SQLiteDatabase openDatabase(String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, CursorFactory paramCursorFactory, int paramInt1, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt2)
  {
    paramString = new SQLiteDatabase(paramString, paramInt1, paramCursorFactory, paramDatabaseErrorHandler);
    paramString.open(paramArrayOfByte, paramSQLiteCipherSpec, paramInt2);
    return paramString;
  }
  
  private void openInner(byte[] arg1, SQLiteCipherSpec paramSQLiteCipherSpec, int paramInt)
  {
    synchronized (this.mLock)
    {
      this.mConnectionPoolLocked = SQLiteConnectionPool.open(this, this.mConfigurationLocked, ???, paramSQLiteCipherSpec, paramInt);
      synchronized (sActiveDatabases)
      {
        sActiveDatabases.put(this, null);
        return;
      }
      throw ???;
    }
  }
  
  public static SQLiteDatabase openOrCreateDatabase(File paramFile, CursorFactory paramCursorFactory)
  {
    return openOrCreateDatabase(paramFile.getPath(), paramCursorFactory);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(File paramFile, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return openOrCreateDatabase(paramFile.getPath(), paramArrayOfByte, paramSQLiteCipherSpec, paramCursorFactory, paramDatabaseErrorHandler, 0);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(File paramFile, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt)
  {
    return openOrCreateDatabase(paramFile.getPath(), paramArrayOfByte, paramSQLiteCipherSpec, paramCursorFactory, paramDatabaseErrorHandler, paramInt);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(File paramFile, byte[] paramArrayOfByte, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return openOrCreateDatabase(paramFile.getPath(), paramArrayOfByte, null, paramCursorFactory, paramDatabaseErrorHandler, 0);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(File paramFile, byte[] paramArrayOfByte, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt)
  {
    return openOrCreateDatabase(paramFile.getPath(), paramArrayOfByte, null, paramCursorFactory, paramDatabaseErrorHandler, paramInt);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, CursorFactory paramCursorFactory)
  {
    return openDatabase(paramString, null, null, paramCursorFactory, 268435456, null, 0);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, CursorFactory paramCursorFactory, int paramInt)
  {
    return openDatabase(paramString, null, null, paramCursorFactory, 268435456, null, paramInt);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return openDatabase(paramString, paramCursorFactory, 268435456, paramDatabaseErrorHandler);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, CursorFactory paramCursorFactory, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 805306368;
    } else {
      i = 268435456;
    }
    return openDatabase(paramString, null, null, paramCursorFactory, i, null, 0);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt)
  {
    return openDatabase(paramString, paramArrayOfByte, paramSQLiteCipherSpec, paramCursorFactory, 268435456, paramDatabaseErrorHandler, paramInt);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, byte[] paramArrayOfByte, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return openOrCreateDatabase(paramString, paramArrayOfByte, null, paramCursorFactory, paramDatabaseErrorHandler, 0);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, byte[] paramArrayOfByte, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt)
  {
    return openOrCreateDatabase(paramString, paramArrayOfByte, null, paramCursorFactory, paramDatabaseErrorHandler, paramInt);
  }
  
  public static SQLiteDatabase openOrCreateDatabaseInWalMode(String paramString, CursorFactory paramCursorFactory)
  {
    return openDatabase(paramString, null, null, paramCursorFactory, 805306368, null, 0);
  }
  
  public static SQLiteDatabase openOrCreateDatabaseInWalMode(String paramString, CursorFactory paramCursorFactory, int paramInt)
  {
    return openDatabase(paramString, null, null, paramCursorFactory, 805306368, null, paramInt);
  }
  
  public static SQLiteDatabase openOrCreateDatabaseInWalMode(String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, CursorFactory paramCursorFactory)
  {
    return openDatabase(paramString, paramArrayOfByte, paramSQLiteCipherSpec, paramCursorFactory, 805306368, null, 0);
  }
  
  public static SQLiteDatabase openOrCreateDatabaseInWalMode(String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt)
  {
    return openDatabase(paramString, paramArrayOfByte, paramSQLiteCipherSpec, paramCursorFactory, 805306368, paramDatabaseErrorHandler, paramInt);
  }
  
  public static SQLiteDatabase openOrCreateMemoryDatabaseInWalMode(CursorFactory paramCursorFactory)
  {
    return openDatabase(":memory:", null, null, paramCursorFactory, 805306368, null, 0);
  }
  
  public static int releaseMemory()
  {
    return SQLiteGlobal.releaseMemory();
  }
  
  private void throwIfNotOpenLocked()
  {
    if (this.mConnectionPoolLocked != null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("The database '");
    localStringBuilder.append(this.mConfigurationLocked.label);
    localStringBuilder.append("' is not open.");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private boolean yieldIfContendedHelper(boolean paramBoolean, long paramLong)
  {
    acquireReference();
    try
    {
      paramBoolean = getThreadSession().yieldTransaction(paramLong, paramBoolean, null);
      return paramBoolean;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public long acquireNativeConnectionHandle(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = paramString;
    if (paramString == null) {
      str = "unnamedNative";
    }
    int i;
    if (paramBoolean1) {
      i = 1;
    } else {
      i = 2;
    }
    int j = i;
    if (paramBoolean2) {
      j = i | 0x4;
    }
    long l = getThreadSession().acquireConnectionForNativeHandle(j).getNativeHandle(str);
    if (l != 0L) {
      return l;
    }
    throw new IllegalStateException("SQLiteConnection native handle not initialized.");
  }
  
  public void addCustomFunction(String arg1, int paramInt, CustomFunction paramCustomFunction)
  {
    paramCustomFunction = new SQLiteCustomFunction(???, paramInt, paramCustomFunction);
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      this.mConfigurationLocked.customFunctions.add(paramCustomFunction);
      try
      {
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        this.mConfigurationLocked.customFunctions.remove(paramCustomFunction);
        throw localRuntimeException;
      }
    }
  }
  
  public void beginTransaction()
  {
    beginTransaction(null, true);
  }
  
  public void beginTransactionNonExclusive()
  {
    beginTransaction(null, false);
  }
  
  public void beginTransactionWithListener(SQLiteTransactionListener paramSQLiteTransactionListener)
  {
    beginTransaction(paramSQLiteTransactionListener, true);
  }
  
  public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener paramSQLiteTransactionListener)
  {
    beginTransaction(paramSQLiteTransactionListener, false);
  }
  
  public SQLiteStatement compileStatement(String paramString)
  {
    acquireReference();
    try
    {
      paramString = new SQLiteStatement(this, paramString, null);
      return paramString;
    }
    finally
    {
      releaseReference();
    }
  }
  
  SQLiteSession createSession()
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      SQLiteConnectionPool localSQLiteConnectionPool = this.mConnectionPoolLocked;
      return new SQLiteSession(localSQLiteConnectionPool);
    }
  }
  
  public int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    acquireReference();
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("DELETE FROM ");
        localStringBuilder.append(paramString1);
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString1 = new StringBuilder();
          paramString1.append(" WHERE ");
          paramString1.append(paramString2);
          paramString1 = paramString1.toString();
          localStringBuilder.append(paramString1);
          paramString1 = new SQLiteStatement(this, localStringBuilder.toString(), paramArrayOfString);
          try
          {
            int i = paramString1.executeUpdateDelete();
            return i;
          }
          finally {}
        }
        paramString1 = "";
      }
      finally
      {
        releaseReference();
      }
    }
  }
  
  public void disableWriteAheadLogging()
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      if ((this.mConfigurationLocked.openFlags & 0x20000000) == 0) {
        return;
      }
      SQLiteDatabaseConfiguration localSQLiteDatabaseConfiguration1 = this.mConfigurationLocked;
      localSQLiteDatabaseConfiguration1.openFlags &= 0xDFFFFFFF;
      try
      {
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        SQLiteDatabaseConfiguration localSQLiteDatabaseConfiguration2 = this.mConfigurationLocked;
        localSQLiteDatabaseConfiguration2.openFlags = (0x20000000 | localSQLiteDatabaseConfiguration2.openFlags);
        throw localRuntimeException;
      }
    }
  }
  
  public void dump(Printer paramPrinter, boolean paramBoolean)
  {
    synchronized (this.mLock)
    {
      if (this.mConnectionPoolLocked != null) {
        this.mConnectionPoolLocked.dump(paramPrinter, paramBoolean);
      }
      return;
    }
  }
  
  public boolean enableWriteAheadLogging()
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      if ((this.mConfigurationLocked.openFlags & 0x20000000) != 0) {
        return true;
      }
      if (isReadOnlyLocked()) {
        return false;
      }
      if (this.mConfigurationLocked.isInMemoryDb())
      {
        Log.i("WCDB.SQLiteDatabase", "can't enable WAL for memory databases.");
        return false;
      }
      if (this.mHasAttachedDbsLocked)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("this database: ");
        ((StringBuilder)localObject2).append(this.mConfigurationLocked.label);
        ((StringBuilder)localObject2).append(" has attached databases. can't  enable WAL.");
        Log.i("WCDB.SQLiteDatabase", ((StringBuilder)localObject2).toString());
        return false;
      }
      Object localObject2 = this.mConfigurationLocked;
      ((SQLiteDatabaseConfiguration)localObject2).openFlags = (0x20000000 | ((SQLiteDatabaseConfiguration)localObject2).openFlags);
      try
      {
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
        return true;
      }
      catch (RuntimeException localRuntimeException)
      {
        SQLiteDatabaseConfiguration localSQLiteDatabaseConfiguration = this.mConfigurationLocked;
        localSQLiteDatabaseConfiguration.openFlags &= 0xDFFFFFFF;
        throw localRuntimeException;
      }
    }
  }
  
  public void endTransaction()
  {
    acquireReference();
    try
    {
      getThreadSession().endTransaction(null);
      return;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public void execSQL(String paramString)
  {
    executeSql(paramString, null, null);
  }
  
  public void execSQL(String paramString, Object[] paramArrayOfObject)
  {
    executeSql(paramString, paramArrayOfObject, null);
  }
  
  public void execSQL(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    executeSql(paramString, paramArrayOfObject, paramCancellationSignal);
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
  
  public boolean getAsyncCheckpointEnabled()
  {
    SQLiteCheckpointListener localSQLiteCheckpointListener = getCheckpointCallback();
    return (localSQLiteCheckpointListener != null) && ((localSQLiteCheckpointListener instanceof SQLiteAsyncCheckpointer));
  }
  
  /* Error */
  public java.util.List<Pair<String, String>> getAttachedDbs()
  {
    // Byte code:
    //   0: new 235	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 296	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 114	com/tencent/wcdb/database/SQLiteDatabase:mLock	Ljava/lang/Object;
    //   12: astore_2
    //   13: aload_2
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 155	com/tencent/wcdb/database/SQLiteDatabase:mConnectionPoolLocked	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   19: astore 4
    //   21: aconst_null
    //   22: astore_1
    //   23: aload 4
    //   25: ifnonnull +7 -> 32
    //   28: aload_2
    //   29: monitorexit
    //   30: aconst_null
    //   31: areturn
    //   32: aload_0
    //   33: getfield 261	com/tencent/wcdb/database/SQLiteDatabase:mHasAttachedDbsLocked	Z
    //   36: ifne +29 -> 65
    //   39: aload_3
    //   40: new 547	android/util/Pair
    //   43: dup
    //   44: ldc_w 549
    //   47: aload_0
    //   48: getfield 130	com/tencent/wcdb/database/SQLiteDatabase:mConfigurationLocked	Lcom/tencent/wcdb/database/SQLiteDatabaseConfiguration;
    //   51: getfield 552	com/tencent/wcdb/database/SQLiteDatabaseConfiguration:path	Ljava/lang/String;
    //   54: invokespecial 555	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   57: invokevirtual 479	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   60: pop
    //   61: aload_2
    //   62: monitorexit
    //   63: aload_3
    //   64: areturn
    //   65: aload_0
    //   66: invokevirtual 135	com/tencent/wcdb/database/SQLiteDatabase:acquireReference	()V
    //   69: aload_2
    //   70: monitorexit
    //   71: aload_0
    //   72: ldc_w 557
    //   75: aconst_null
    //   76: invokevirtual 561	com/tencent/wcdb/database/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   79: astore_2
    //   80: aload_2
    //   81: astore_1
    //   82: aload_2
    //   83: invokeinterface 566 1 0
    //   88: ifeq +34 -> 122
    //   91: aload_2
    //   92: astore_1
    //   93: aload_3
    //   94: new 547	android/util/Pair
    //   97: dup
    //   98: aload_2
    //   99: iconst_1
    //   100: invokeinterface 570 2 0
    //   105: aload_2
    //   106: iconst_2
    //   107: invokeinterface 570 2 0
    //   112: invokespecial 555	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   115: invokevirtual 479	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   118: pop
    //   119: goto -39 -> 80
    //   122: aload_2
    //   123: ifnull +9 -> 132
    //   126: aload_2
    //   127: invokeinterface 571 1 0
    //   132: aload_0
    //   133: invokevirtual 151	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   136: aload_3
    //   137: areturn
    //   138: astore_2
    //   139: aload_1
    //   140: ifnull +9 -> 149
    //   143: aload_1
    //   144: invokeinterface 571 1 0
    //   149: aload_2
    //   150: athrow
    //   151: astore_1
    //   152: aload_0
    //   153: invokevirtual 151	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   156: aload_1
    //   157: athrow
    //   158: astore_1
    //   159: aload_2
    //   160: monitorexit
    //   161: aload_1
    //   162: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	SQLiteDatabase
    //   22	122	1	localObject1	Object
    //   151	6	1	localObject2	Object
    //   158	4	1	localObject3	Object
    //   12	115	2	localObject4	Object
    //   138	22	2	localObject5	Object
    //   7	130	3	localArrayList	ArrayList
    //   19	5	4	localSQLiteConnectionPool	SQLiteConnectionPool
    // Exception table:
    //   from	to	target	type
    //   71	80	138	finally
    //   82	91	138	finally
    //   93	119	138	finally
    //   126	132	151	finally
    //   143	149	151	finally
    //   149	151	151	finally
    //   15	21	158	finally
    //   28	30	158	finally
    //   32	63	158	finally
    //   65	71	158	finally
    //   159	161	158	finally
  }
  
  public SQLiteChangeListener getChangeListener()
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      SQLiteChangeListener localSQLiteChangeListener = this.mConnectionPoolLocked.getChangeListener();
      return localSQLiteChangeListener;
    }
  }
  
  public SQLiteCheckpointListener getCheckpointCallback()
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      if (!this.mConfigurationLocked.customWALHookEnabled) {
        return null;
      }
      SQLiteCheckpointListener localSQLiteCheckpointListener = this.mConnectionPoolLocked.getCheckpointListener();
      return localSQLiteCheckpointListener;
    }
  }
  
  String getLabel()
  {
    synchronized (this.mLock)
    {
      String str = this.mConfigurationLocked.label;
      return str;
    }
  }
  
  public long getMaximumSize()
  {
    return DatabaseUtils.longForQuery(this, "PRAGMA max_page_count;", null) * getPageSize();
  }
  
  public long getPageSize()
  {
    return DatabaseUtils.longForQuery(this, "PRAGMA page_size;", null);
  }
  
  public final String getPath()
  {
    synchronized (this.mLock)
    {
      String str = this.mConfigurationLocked.path;
      return str;
    }
  }
  
  @Deprecated
  public Map<String, String> getSyncedTables()
  {
    return new HashMap(0);
  }
  
  public int getSynchronousMode()
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      int i = this.mConfigurationLocked.synchronousMode;
      return i;
    }
  }
  
  int getThreadDefaultConnectionFlags(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    int j = i;
    if (isMainThread()) {
      j = i | 0x4;
    }
    return j;
  }
  
  SQLiteSession getThreadSession()
  {
    return (SQLiteSession)this.mThreadSession.get();
  }
  
  public SQLiteTrace getTraceCallback()
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      SQLiteTrace localSQLiteTrace = this.mConnectionPoolLocked.getTraceCallback();
      return localSQLiteTrace;
    }
  }
  
  public int getVersion()
  {
    return Long.valueOf(DatabaseUtils.longForQuery(this, "PRAGMA user_version;", null)).intValue();
  }
  
  public boolean inTransaction()
  {
    acquireReference();
    try
    {
      boolean bool = getThreadSession().hasTransaction();
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public long insert(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    try
    {
      long l = insertWithOnConflict(paramString1, paramString2, paramContentValues, 0);
      return l;
    }
    catch (SQLException paramString1)
    {
      Log.e("WCDB.SQLiteDatabase", "Error inserting %s: %s", new Object[] { paramContentValues, paramString1 });
      return -1L;
    }
    catch (SQLiteDatabaseCorruptException paramString1)
    {
      throw paramString1;
    }
  }
  
  public long insertOrThrow(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    return insertWithOnConflict(paramString1, paramString2, paramContentValues, 0);
  }
  
  public long insertWithOnConflict(String paramString1, String paramString2, ContentValues paramContentValues, int paramInt)
  {
    acquireReference();
    for (;;)
    {
      int i;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("INSERT");
        localStringBuilder.append(CONFLICT_VALUES[paramInt]);
        localStringBuilder.append(" INTO ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append('(');
        paramString1 = null;
        int j = 0;
        if ((paramContentValues != null) && (paramContentValues.size() > 0))
        {
          paramInt = paramContentValues.size();
          if (paramInt > 0)
          {
            paramString2 = new Object[paramInt];
            Iterator localIterator = keySet(paramContentValues).iterator();
            i = 0;
            if (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              if (i <= 0) {
                break label309;
              }
              paramString1 = ",";
              localStringBuilder.append(paramString1);
              localStringBuilder.append(str);
              paramString2[i] = paramContentValues.get(str);
              i += 1;
              continue;
            }
            localStringBuilder.append(')');
            localStringBuilder.append(" VALUES (");
            i = j;
            break label315;
            localStringBuilder.append(paramString1);
            i += 1;
            break label315;
          }
          paramContentValues = new StringBuilder();
          paramContentValues.append(paramString2);
          paramContentValues.append(") VALUES (NULL");
          localStringBuilder.append(paramContentValues.toString());
          localStringBuilder.append(')');
          paramString1 = new SQLiteStatement(this, localStringBuilder.toString(), paramString1);
          try
          {
            long l = paramString1.executeInsert();
            return l;
          }
          finally {}
        }
        paramInt = 0;
      }
      finally
      {
        releaseReference();
      }
      continue;
      label309:
      paramString1 = "";
      continue;
      label315:
      paramString1 = paramString2;
      if (i < paramInt) {
        if (i > 0) {
          paramString1 = ",?";
        } else {
          paramString1 = "?";
        }
      }
    }
  }
  
  /* Error */
  public boolean isDatabaseIntegrityOk()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 135	com/tencent/wcdb/database/SQLiteDatabase:acquireReference	()V
    //   4: aload_0
    //   5: invokevirtual 680	com/tencent/wcdb/database/SQLiteDatabase:getAttachedDbs	()Ljava/util/List;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnull +6 -> 16
    //   13: goto +327 -> 340
    //   16: new 179	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   23: astore_2
    //   24: aload_2
    //   25: ldc_w 682
    //   28: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_2
    //   33: aload_0
    //   34: invokevirtual 683	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   37: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_2
    //   42: ldc_w 685
    //   45: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: new 292	java/lang/IllegalStateException
    //   52: dup
    //   53: aload_2
    //   54: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokespecial 295	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   60: athrow
    //   61: astore_2
    //   62: goto +268 -> 330
    //   65: new 235	java/util/ArrayList
    //   68: dup
    //   69: invokespecial 296	java/util/ArrayList:<init>	()V
    //   72: astore_3
    //   73: aload_3
    //   74: new 547	android/util/Pair
    //   77: dup
    //   78: ldc_w 549
    //   81: aload_0
    //   82: invokevirtual 683	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   85: invokespecial 555	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   88: invokeinterface 688 2 0
    //   93: pop
    //   94: goto +246 -> 340
    //   97: iload_1
    //   98: aload_3
    //   99: invokeinterface 689 1 0
    //   104: if_icmpge +220 -> 324
    //   107: aload_3
    //   108: iload_1
    //   109: invokeinterface 692 2 0
    //   114: checkcast 547	android/util/Pair
    //   117: astore 5
    //   119: aconst_null
    //   120: astore 4
    //   122: aload 4
    //   124: astore_2
    //   125: new 179	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   132: astore 6
    //   134: aload 4
    //   136: astore_2
    //   137: aload 6
    //   139: ldc_w 694
    //   142: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 4
    //   148: astore_2
    //   149: aload 6
    //   151: aload 5
    //   153: getfield 697	android/util/Pair:first	Ljava/lang/Object;
    //   156: checkcast 87	java/lang/String
    //   159: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload 4
    //   165: astore_2
    //   166: aload 6
    //   168: ldc_w 699
    //   171: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 4
    //   177: astore_2
    //   178: aload_0
    //   179: aload 6
    //   181: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokevirtual 701	com/tencent/wcdb/database/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteStatement;
    //   187: astore 4
    //   189: aload 4
    //   191: astore_2
    //   192: aload 4
    //   194: invokevirtual 704	com/tencent/wcdb/database/SQLiteStatement:simpleQueryForString	()Ljava/lang/String;
    //   197: astore 6
    //   199: aload 4
    //   201: astore_2
    //   202: aload 6
    //   204: ldc_w 706
    //   207: invokestatic 710	com/tencent/wcdb/DatabaseUtils:objectEquals	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   210: ifne +90 -> 300
    //   213: aload 4
    //   215: astore_2
    //   216: new 179	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   223: astore_3
    //   224: aload 4
    //   226: astore_2
    //   227: aload_3
    //   228: ldc_w 712
    //   231: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 4
    //   237: astore_2
    //   238: aload_3
    //   239: aload 5
    //   241: getfield 715	android/util/Pair:second	Ljava/lang/Object;
    //   244: checkcast 87	java/lang/String
    //   247: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload 4
    //   253: astore_2
    //   254: aload_3
    //   255: ldc_w 717
    //   258: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 4
    //   264: astore_2
    //   265: aload_3
    //   266: aload 6
    //   268: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload 4
    //   274: astore_2
    //   275: ldc 54
    //   277: aload_3
    //   278: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 719	com/tencent/wcdb/support/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: aload 4
    //   286: ifnull +8 -> 294
    //   289: aload 4
    //   291: invokevirtual 274	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   294: aload_0
    //   295: invokevirtual 151	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   298: iconst_0
    //   299: ireturn
    //   300: aload 4
    //   302: ifnull +43 -> 345
    //   305: aload 4
    //   307: invokevirtual 274	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   310: goto +35 -> 345
    //   313: astore_3
    //   314: aload_2
    //   315: ifnull +7 -> 322
    //   318: aload_2
    //   319: invokevirtual 274	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   322: aload_3
    //   323: athrow
    //   324: aload_0
    //   325: invokevirtual 151	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   328: iconst_1
    //   329: ireturn
    //   330: aload_0
    //   331: invokevirtual 151	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   334: aload_2
    //   335: athrow
    //   336: astore_2
    //   337: goto -272 -> 65
    //   340: iconst_0
    //   341: istore_1
    //   342: goto -245 -> 97
    //   345: iload_1
    //   346: iconst_1
    //   347: iadd
    //   348: istore_1
    //   349: goto -252 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	352	0	this	SQLiteDatabase
    //   97	252	1	i	int
    //   23	31	2	localStringBuilder	StringBuilder
    //   61	1	2	localObject1	Object
    //   124	211	2	localObject2	Object
    //   336	1	2	localSQLiteException	SQLiteException
    //   8	270	3	localObject3	Object
    //   313	10	3	localObject4	Object
    //   120	186	4	localSQLiteStatement	SQLiteStatement
    //   117	123	5	localPair	Pair
    //   132	135	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	61	finally
    //   16	61	61	finally
    //   65	94	61	finally
    //   97	119	61	finally
    //   289	294	61	finally
    //   305	310	61	finally
    //   318	322	61	finally
    //   322	324	61	finally
    //   125	134	313	finally
    //   137	146	313	finally
    //   149	163	313	finally
    //   166	175	313	finally
    //   178	189	313	finally
    //   192	199	313	finally
    //   202	213	313	finally
    //   216	224	313	finally
    //   227	235	313	finally
    //   238	251	313	finally
    //   254	262	313	finally
    //   265	272	313	finally
    //   275	284	313	finally
    //   4	9	336	com/tencent/wcdb/database/SQLiteException
    //   16	61	336	com/tencent/wcdb/database/SQLiteException
  }
  
  public boolean isDbLockedByCurrentThread()
  {
    acquireReference();
    try
    {
      boolean bool = getThreadSession().hasConnection();
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }
  
  @Deprecated
  public boolean isDbLockedByOtherThreads()
  {
    return false;
  }
  
  public boolean isInMemoryDatabase()
  {
    synchronized (this.mLock)
    {
      boolean bool = this.mConfigurationLocked.isInMemoryDb();
      return bool;
    }
  }
  
  public boolean isOpen()
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (this.mConnectionPoolLocked != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean isReadOnly()
  {
    synchronized (this.mLock)
    {
      boolean bool = isReadOnlyLocked();
      return bool;
    }
  }
  
  public boolean isWriteAheadLoggingEnabled()
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        throwIfNotOpenLocked();
        if ((this.mConfigurationLocked.openFlags & 0x20000000) != 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  @Deprecated
  public void markTableSyncable(String paramString1, String paramString2) {}
  
  @Deprecated
  public void markTableSyncable(String paramString1, String paramString2, String paramString3) {}
  
  public boolean needUpgrade(int paramInt)
  {
    return paramInt > getVersion();
  }
  
  protected void onAllReferencesReleased()
  {
    dispose(false);
  }
  
  void onCorruption()
  {
    this.mErrorHandler.onCorruption(this);
  }
  
  public Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
  {
    return query(false, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, null);
  }
  
  public Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return query(false, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public Cursor query(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return queryWithFactory(null, paramBoolean, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6, null);
  }
  
  public Cursor query(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6, CancellationSignal paramCancellationSignal)
  {
    return queryWithFactory(null, paramBoolean, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6, paramCancellationSignal);
  }
  
  public Cursor queryWithFactory(CursorFactory paramCursorFactory, boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return queryWithFactory(paramCursorFactory, paramBoolean, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6, null);
  }
  
  public Cursor queryWithFactory(CursorFactory paramCursorFactory, boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6, CancellationSignal paramCancellationSignal)
  {
    acquireReference();
    try
    {
      paramCursorFactory = rawQueryWithFactory(paramCursorFactory, SQLiteQueryBuilder.buildQueryString(paramBoolean, paramString1, paramArrayOfString1, paramString2, paramString3, paramString4, paramString5, paramString6), paramArrayOfString2, findEditTable(paramString1), paramCancellationSignal);
      return paramCursorFactory;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    return rawQueryWithFactory(null, paramString, paramArrayOfString, null, null);
  }
  
  public Cursor rawQuery(String paramString, String[] paramArrayOfString, CancellationSignal paramCancellationSignal)
  {
    return rawQueryWithFactory(null, paramString, paramArrayOfString, null, paramCancellationSignal);
  }
  
  public Cursor rawQueryWithFactory(CursorFactory paramCursorFactory, String paramString1, String[] paramArrayOfString, String paramString2)
  {
    return rawQueryWithFactory(paramCursorFactory, paramString1, paramArrayOfString, paramString2, null);
  }
  
  public Cursor rawQueryWithFactory(CursorFactory paramCursorFactory, String paramString1, String[] paramArrayOfString, String paramString2, CancellationSignal paramCancellationSignal)
  {
    acquireReference();
    try
    {
      paramString1 = new SQLiteDirectCursorDriver(this, paramString1, paramString2, paramCancellationSignal);
      if (paramCursorFactory == null) {
        paramCursorFactory = this.mCursorFactory;
      }
      paramCursorFactory = paramString1.query(paramCursorFactory, paramArrayOfString);
      return paramCursorFactory;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public void releaseNativeConnection(long paramLong, Exception paramException)
  {
    getThreadSession().releaseConnectionForNativeHandle(paramException);
  }
  
  public void reopenReadWrite()
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      if (!isReadOnlyLocked()) {
        return;
      }
      int i = this.mConfigurationLocked.openFlags;
      this.mConfigurationLocked.openFlags = (this.mConfigurationLocked.openFlags & 0xFFFFFFFE | 0x0);
      try
      {
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        this.mConfigurationLocked.openFlags = i;
        throw localRuntimeException;
      }
    }
  }
  
  public long replace(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    try
    {
      long l = insertWithOnConflict(paramString1, paramString2, paramContentValues, 5);
      return l;
    }
    catch (SQLException paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("Error inserting ");
      paramString2.append(paramContentValues);
      Log.e("WCDB.SQLiteDatabase", paramString2.toString(), new Object[] { paramString1 });
      return -1L;
    }
    catch (SQLiteDatabaseCorruptException paramString1)
    {
      throw paramString1;
    }
  }
  
  public long replaceOrThrow(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    return insertWithOnConflict(paramString1, paramString2, paramContentValues, 5);
  }
  
  public void setAsyncCheckpointEnabled(boolean paramBoolean)
  {
    SQLiteAsyncCheckpointer localSQLiteAsyncCheckpointer;
    if (paramBoolean) {
      localSQLiteAsyncCheckpointer = new SQLiteAsyncCheckpointer();
    } else {
      localSQLiteAsyncCheckpointer = null;
    }
    setCheckpointCallback(localSQLiteAsyncCheckpointer);
  }
  
  public void setChangeListener(SQLiteChangeListener paramSQLiteChangeListener, boolean paramBoolean)
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      this.mConnectionPoolLocked.setChangeListener(paramSQLiteChangeListener, paramBoolean);
      return;
    }
  }
  
  public void setCheckpointCallback(SQLiteCheckpointListener paramSQLiteCheckpointListener)
  {
    boolean bool2 = true;
    if (paramSQLiteCheckpointListener != null) {
      bool1 = true;
    }
    for (boolean bool1 = false;; bool1 = false) {
      synchronized (this.mLock)
      {
        throwIfNotOpenLocked();
        if (this.mConfigurationLocked.customWALHookEnabled != bool1)
        {
          this.mConfigurationLocked.customWALHookEnabled = bool1;
          SQLiteDatabaseConfiguration localSQLiteDatabaseConfiguration;
          try
          {
            this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
          }
          catch (RuntimeException paramSQLiteCheckpointListener)
          {
            localSQLiteDatabaseConfiguration = this.mConfigurationLocked;
            if (bool1) {
              continue;
            }
          }
          bool1 = bool2;
          localSQLiteDatabaseConfiguration.customWALHookEnabled = bool1;
          throw paramSQLiteCheckpointListener;
        }
        this.mConnectionPoolLocked.setCheckpointListener(paramSQLiteCheckpointListener);
        return;
      }
    }
  }
  
  public void setForeignKeyConstraintsEnabled(boolean paramBoolean)
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        throwIfNotOpenLocked();
        if (this.mConfigurationLocked.foreignKeyConstraintsEnabled == paramBoolean) {
          return;
        }
        this.mConfigurationLocked.foreignKeyConstraintsEnabled = paramBoolean;
        SQLiteDatabaseConfiguration localSQLiteDatabaseConfiguration;
        try
        {
          this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
          return;
        }
        catch (RuntimeException localRuntimeException)
        {
          localSQLiteDatabaseConfiguration = this.mConfigurationLocked;
          if (paramBoolean) {
            break label76;
          }
        }
        paramBoolean = true;
        localSQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled = paramBoolean;
        throw localRuntimeException;
      }
      label76:
      paramBoolean = false;
    }
  }
  
  public void setLocale(Locale paramLocale)
  {
    if (paramLocale != null) {
      synchronized (this.mLock)
      {
        throwIfNotOpenLocked();
        Locale localLocale = this.mConfigurationLocked.locale;
        this.mConfigurationLocked.locale = paramLocale;
        try
        {
          this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
          return;
        }
        catch (RuntimeException paramLocale)
        {
          this.mConfigurationLocked.locale = localLocale;
          throw paramLocale;
        }
      }
    }
    throw new IllegalArgumentException("locale must not be null.");
  }
  
  @Deprecated
  public void setLockingEnabled(boolean paramBoolean) {}
  
  public void setMaxSqlCacheSize(int paramInt)
  {
    if ((paramInt <= 100) && (paramInt >= 0)) {
      synchronized (this.mLock)
      {
        throwIfNotOpenLocked();
        int i = this.mConfigurationLocked.maxSqlCacheSize;
        this.mConfigurationLocked.maxSqlCacheSize = paramInt;
        try
        {
          this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
          return;
        }
        catch (RuntimeException localRuntimeException)
        {
          this.mConfigurationLocked.maxSqlCacheSize = i;
          throw localRuntimeException;
        }
      }
    }
    throw new IllegalStateException("expected value between 0 and 100");
  }
  
  public long setMaximumSize(long paramLong)
  {
    long l3 = getPageSize();
    long l2 = paramLong / l3;
    long l1 = l2;
    if (paramLong % l3 != 0L) {
      l1 = l2 + 1L;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PRAGMA max_page_count = ");
    localStringBuilder.append(l1);
    return DatabaseUtils.longForQuery(this, localStringBuilder.toString(), null) * l3;
  }
  
  public void setPageSize(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PRAGMA page_size = ");
    localStringBuilder.append(paramLong);
    execSQL(localStringBuilder.toString());
  }
  
  public void setSynchronousMode(int paramInt)
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      int i = this.mConfigurationLocked.synchronousMode;
      if (i != paramInt)
      {
        this.mConfigurationLocked.synchronousMode = paramInt;
        try
        {
          this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
        }
        catch (RuntimeException localRuntimeException)
        {
          this.mConfigurationLocked.synchronousMode = i;
          throw localRuntimeException;
        }
      }
      return;
    }
  }
  
  public void setTraceCallback(SQLiteTrace paramSQLiteTrace)
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      this.mConnectionPoolLocked.setTraceCallback(paramSQLiteTrace);
      return;
    }
  }
  
  public void setTransactionSuccessful()
  {
    acquireReference();
    try
    {
      getThreadSession().setTransactionSuccessful();
      return;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public void setVersion(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PRAGMA user_version = ");
    localStringBuilder.append(paramInt);
    execSQL(localStringBuilder.toString());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SQLiteDatabase: ");
    localStringBuilder.append(getPath());
    return localStringBuilder.toString();
  }
  
  public int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    return updateWithOnConflict(paramString1, paramContentValues, paramString2, paramArrayOfString, 0);
  }
  
  public int updateWithOnConflict(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, int paramInt)
  {
    if ((paramContentValues != null) && (paramContentValues.size() != 0)) {
      acquireReference();
    }
    for (;;)
    {
      int i;
      Object[] arrayOfObject;
      int j;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder(120);
        localStringBuilder.append("UPDATE ");
        localStringBuilder.append(CONFLICT_VALUES[paramInt]);
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" SET ");
        paramInt = paramContentValues.size();
        if (paramArrayOfString == null) {
          i = paramInt;
        } else {
          i = paramArrayOfString.length + paramInt;
        }
        arrayOfObject = new Object[i];
        j = 0;
        Iterator localIterator = keySet(paramContentValues).iterator();
        if (!localIterator.hasNext()) {
          break label276;
        }
        String str = (String)localIterator.next();
        if (j > 0)
        {
          paramString1 = ",";
          localStringBuilder.append(paramString1);
          localStringBuilder.append(str);
          arrayOfObject[j] = paramContentValues.get(str);
          localStringBuilder.append("=?");
          j += 1;
          continue;
          if (!TextUtils.isEmpty(paramString2))
          {
            localStringBuilder.append(" WHERE ");
            localStringBuilder.append(paramString2);
          }
          paramString1 = new SQLiteStatement(this, localStringBuilder.toString(), arrayOfObject);
          try
          {
            paramInt = paramString1.executeUpdateDelete();
            return paramInt;
          }
          finally {}
          throw new IllegalArgumentException("Empty values");
        }
      }
      finally
      {
        releaseReference();
      }
      paramString1 = "";
      continue;
      label276:
      if (paramArrayOfString != null)
      {
        j = paramInt;
        while (j < i)
        {
          arrayOfObject[j] = paramArrayOfString[(j - paramInt)];
          j += 1;
        }
      }
    }
  }
  
  public Pair<Integer, Integer> walCheckpoint(String paramString, boolean paramBoolean)
  {
    acquireReference();
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 0;
    }
    try
    {
      paramString = getThreadSession().walCheckpoint(paramString, i);
      return paramString;
    }
    finally
    {
      releaseReference();
    }
  }
  
  @Deprecated
  public boolean yieldIfContended()
  {
    return yieldIfContendedHelper(false, -1L);
  }
  
  public boolean yieldIfContendedSafely()
  {
    return yieldIfContendedHelper(true, -1L);
  }
  
  public boolean yieldIfContendedSafely(long paramLong)
  {
    return yieldIfContendedHelper(true, paramLong);
  }
  
  public static abstract interface CursorFactory
  {
    public abstract Cursor newCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteProgram paramSQLiteProgram);
    
    public abstract SQLiteProgram newQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal);
  }
  
  public static abstract interface CustomFunction
  {
    public abstract void callback(String[] paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDatabase
 * JD-Core Version:    0.7.0.1
 */