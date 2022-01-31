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
  private static final String[] CONFLICT_VALUES;
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
  private static final WeakHashMap sActiveDatabases;
  private final SQLiteDatabaseConfiguration mConfigurationLocked;
  private SQLiteConnectionPool mConnectionPoolLocked;
  private final SQLiteDatabase.CursorFactory mCursorFactory;
  private final DatabaseErrorHandler mErrorHandler;
  private boolean mHasAttachedDbsLocked;
  private final Object mLock = new Object();
  private final ThreadLocal mThreadSession = new SQLiteDatabase.1(this);
  
  static
  {
    if (!SQLiteDatabase.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      SQLiteGlobal.loadLib();
      sActiveDatabases = new WeakHashMap();
      CONFLICT_VALUES = new String[] { "", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE " };
      return;
    }
  }
  
  private SQLiteDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    this.mCursorFactory = paramCursorFactory;
    if (paramDatabaseErrorHandler != null) {}
    for (;;)
    {
      this.mErrorHandler = paramDatabaseErrorHandler;
      this.mConfigurationLocked = new SQLiteDatabaseConfiguration(paramString, paramInt);
      return;
      paramDatabaseErrorHandler = new DefaultDatabaseErrorHandler(true);
    }
  }
  
  /* Error */
  private void beginTransaction(SQLiteTransactionListener paramSQLiteTransactionListener, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 133	com/tencent/wcdb/database/SQLiteDatabase:acquireReference	()V
    //   4: aload_0
    //   5: invokevirtual 137	com/tencent/wcdb/database/SQLiteDatabase:getThreadSession	()Lcom/tencent/wcdb/database/SQLiteSession;
    //   8: astore 4
    //   10: iload_2
    //   11: ifeq +23 -> 34
    //   14: iconst_2
    //   15: istore_3
    //   16: aload 4
    //   18: iload_3
    //   19: aload_1
    //   20: aload_0
    //   21: iconst_0
    //   22: invokevirtual 141	com/tencent/wcdb/database/SQLiteDatabase:getThreadDefaultConnectionFlags	(Z)I
    //   25: aconst_null
    //   26: invokevirtual 146	com/tencent/wcdb/database/SQLiteSession:beginTransaction	(ILcom/tencent/wcdb/database/SQLiteTransactionListener;ILcom/tencent/wcdb/support/CancellationSignal;)V
    //   29: aload_0
    //   30: invokevirtual 149	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   33: return
    //   34: iconst_1
    //   35: istore_3
    //   36: goto -20 -> 16
    //   39: astore_1
    //   40: aload_0
    //   41: invokevirtual 149	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	SQLiteDatabase
    //   0	46	1	paramSQLiteTransactionListener	SQLiteTransactionListener
    //   0	46	2	paramBoolean	boolean
    //   15	21	3	i	int
    //   8	9	4	localSQLiteSession	SQLiteSession
    // Exception table:
    //   from	to	target	type
    //   4	10	39	finally
    //   16	29	39	finally
  }
  
  private void collectDbStats(ArrayList paramArrayList)
  {
    synchronized (this.mLock)
    {
      if (this.mConnectionPoolLocked != null) {
        this.mConnectionPoolLocked.collectDbStats(paramArrayList);
      }
      return;
    }
  }
  
  public static SQLiteDatabase create(SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    return openDatabase(":memory:", paramCursorFactory, 268435456);
  }
  
  public static boolean deleteDatabase(File paramFile)
  {
    if (paramFile == null) {
      throw new IllegalArgumentException("file must not be null");
    }
    boolean bool1 = paramFile.delete() | new File(paramFile.getPath() + "-journal").delete() | new File(paramFile.getPath() + "-shm").delete() | new File(paramFile.getPath() + "-wal").delete();
    File localFile = paramFile.getParentFile();
    boolean bool2 = bool1;
    if (localFile != null)
    {
      paramFile = localFile.listFiles(new SQLiteDatabase.2(paramFile.getName() + "-mj"));
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
          bool2 = paramFile[i].delete();
          i += 1;
          bool1 = bool2 | bool1;
        }
      }
    }
    return bool2;
  }
  
  private void dispose(boolean paramBoolean)
  {
    SQLiteConnectionPool localSQLiteConnectionPool;
    synchronized (this.mLock)
    {
      localSQLiteConnectionPool = this.mConnectionPoolLocked;
      this.mConnectionPoolLocked = null;
      if (paramBoolean) {}
    }
    synchronized (sActiveDatabases)
    {
      sActiveDatabases.remove(this);
      if (localSQLiteConnectionPool != null) {
        localSQLiteConnectionPool.close();
      }
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public static void dumpAll(Printer paramPrinter, boolean paramBoolean)
  {
    Iterator localIterator = getActiveDatabases().iterator();
    while (localIterator.hasNext()) {
      ((SQLiteDatabase)localIterator.next()).dump(paramPrinter, paramBoolean);
    }
  }
  
  private int executeSql(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    int i = 1;
    acquireReference();
    for (;;)
    {
      try
      {
        if (DatabaseUtils.getSqlStatementType(paramString) == 3) {}
        synchronized (this.mLock)
        {
          if (!this.mHasAttachedDbsLocked)
          {
            this.mHasAttachedDbsLocked = true;
            if (i != 0) {
              disableWriteAheadLogging();
            }
            paramString = new SQLiteStatement(this, paramString, paramArrayOfObject);
          }
        }
        i = 0;
      }
      finally
      {
        releaseReference();
      }
    }
  }
  
  public static String findEditTable(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.indexOf(' ');
      int j = paramString.indexOf(',');
      String str;
      if ((i > 0) && ((i < j) || (j < 0))) {
        str = paramString.substring(0, i);
      }
      do
      {
        do
        {
          return str;
          str = paramString;
        } while (j <= 0);
        if (j < i) {
          break;
        }
        str = paramString;
      } while (i >= 0);
      return paramString.substring(0, j);
    }
    throw new IllegalStateException("Invalid tables");
  }
  
  private static ArrayList getActiveDatabases()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (sActiveDatabases)
    {
      localArrayList.addAll(sActiveDatabases.keySet());
      return localArrayList;
    }
  }
  
  static ArrayList getDbStats()
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
  
  private Set keySet(ContentValues paramContentValues)
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
    catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
    {
      onCorruption();
      openInner(paramArrayOfByte, paramSQLiteCipherSpec, paramInt);
      return;
    }
    catch (SQLiteException paramArrayOfByte)
    {
      Log.e("WCDB.SQLiteDatabase", "Failed to open database '" + getLabel() + "'.", new Object[] { paramArrayOfByte });
      close();
      throw paramArrayOfByte;
    }
  }
  
  public static SQLiteDatabase openDatabase(String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    return openDatabase(paramString, paramCursorFactory, paramInt, null);
  }
  
  public static SQLiteDatabase openDatabase(String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return openDatabase(paramString, null, null, paramCursorFactory, paramInt, paramDatabaseErrorHandler, 0);
  }
  
  public static SQLiteDatabase openDatabase(String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt1, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt2)
  {
    return openDatabase(paramString, null, null, paramCursorFactory, paramInt1, paramDatabaseErrorHandler, paramInt2);
  }
  
  public static SQLiteDatabase openDatabase(String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return openDatabase(paramString, paramArrayOfByte, paramSQLiteCipherSpec, paramCursorFactory, paramInt, paramDatabaseErrorHandler, 0);
  }
  
  public static SQLiteDatabase openDatabase(String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt1, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt2)
  {
    paramString = new SQLiteDatabase(paramString, paramInt1, paramCursorFactory, paramDatabaseErrorHandler);
    paramString.open(paramArrayOfByte, paramSQLiteCipherSpec, paramInt2);
    return paramString;
  }
  
  private void openInner(byte[] arg1, SQLiteCipherSpec paramSQLiteCipherSpec, int paramInt)
  {
    synchronized (this.mLock)
    {
      if ((!$assertionsDisabled) && (this.mConnectionPoolLocked != null)) {
        throw new AssertionError();
      }
    }
    this.mConnectionPoolLocked = SQLiteConnectionPool.open(this, this.mConfigurationLocked, ???, paramSQLiteCipherSpec, paramInt);
    synchronized (sActiveDatabases)
    {
      sActiveDatabases.put(this, null);
      return;
    }
  }
  
  public static SQLiteDatabase openOrCreateDatabase(File paramFile, SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    return openOrCreateDatabase(paramFile.getPath(), paramCursorFactory);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(File paramFile, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return openOrCreateDatabase(paramFile.getPath(), paramArrayOfByte, paramSQLiteCipherSpec, paramCursorFactory, paramDatabaseErrorHandler, 0);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(File paramFile, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt)
  {
    return openOrCreateDatabase(paramFile.getPath(), paramArrayOfByte, paramSQLiteCipherSpec, paramCursorFactory, paramDatabaseErrorHandler, paramInt);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(File paramFile, byte[] paramArrayOfByte, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return openOrCreateDatabase(paramFile.getPath(), paramArrayOfByte, null, paramCursorFactory, paramDatabaseErrorHandler, 0);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(File paramFile, byte[] paramArrayOfByte, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt)
  {
    return openOrCreateDatabase(paramFile.getPath(), paramArrayOfByte, null, paramCursorFactory, paramDatabaseErrorHandler, paramInt);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    return openDatabase(paramString, null, null, paramCursorFactory, 268435456, null, 0);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    return openDatabase(paramString, null, null, paramCursorFactory, 268435456, null, paramInt);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return openDatabase(paramString, paramCursorFactory, 268435456, paramDatabaseErrorHandler);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, boolean paramBoolean)
  {
    int i = 268435456;
    if (paramBoolean) {
      i = 805306368;
    }
    return openDatabase(paramString, null, null, paramCursorFactory, i, null, 0);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt)
  {
    return openDatabase(paramString, paramArrayOfByte, paramSQLiteCipherSpec, paramCursorFactory, 268435456, paramDatabaseErrorHandler, paramInt);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, byte[] paramArrayOfByte, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return openOrCreateDatabase(paramString, paramArrayOfByte, null, paramCursorFactory, paramDatabaseErrorHandler, 0);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, byte[] paramArrayOfByte, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt)
  {
    return openOrCreateDatabase(paramString, paramArrayOfByte, null, paramCursorFactory, paramDatabaseErrorHandler, paramInt);
  }
  
  public static SQLiteDatabase openOrCreateDatabaseInWalMode(String paramString, SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    return openDatabase(paramString, null, null, paramCursorFactory, 805306368, null, 0);
  }
  
  public static SQLiteDatabase openOrCreateDatabaseInWalMode(String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    return openDatabase(paramString, null, null, paramCursorFactory, 805306368, null, paramInt);
  }
  
  public static SQLiteDatabase openOrCreateDatabaseInWalMode(String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    return openDatabase(paramString, paramArrayOfByte, paramSQLiteCipherSpec, paramCursorFactory, 805306368, null, 0);
  }
  
  public static SQLiteDatabase openOrCreateDatabaseInWalMode(String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt)
  {
    return openDatabase(paramString, paramArrayOfByte, paramSQLiteCipherSpec, paramCursorFactory, 805306368, paramDatabaseErrorHandler, paramInt);
  }
  
  public static SQLiteDatabase openOrCreateMemoryDatabaseInWalMode(SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    return openDatabase(":memory:", null, null, paramCursorFactory, 805306368, null, 0);
  }
  
  public static int releaseMemory()
  {
    return SQLiteGlobal.releaseMemory();
  }
  
  private void throwIfNotOpenLocked()
  {
    if (this.mConnectionPoolLocked == null) {
      throw new IllegalStateException("The database '" + this.mConfigurationLocked.label + "' is not open.");
    }
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
    if (paramBoolean1) {}
    long l;
    for (int i = 1;; i = 2)
    {
      int j = i;
      if (paramBoolean2) {
        j = i | 0x4;
      }
      l = getThreadSession().acquireConnectionForNativeHandle(j).getNativeHandle(str);
      if (l != 0L) {
        break;
      }
      throw new IllegalStateException("SQLiteConnection native handle not initialized.");
    }
    return l;
  }
  
  public void addCustomFunction(String arg1, int paramInt, SQLiteDatabase.CustomFunction paramCustomFunction)
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
  
  /* Error */
  public int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 133	com/tencent/wcdb/database/SQLiteDatabase:acquireReference	()V
    //   4: new 181	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   11: ldc_w 495
    //   14: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_1
    //   18: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: astore 5
    //   23: aload_2
    //   24: invokestatic 279	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   27: ifne +60 -> 87
    //   30: new 181	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 497
    //   40: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_2
    //   44: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: astore_1
    //   51: new 263	com/tencent/wcdb/database/SQLiteStatement
    //   54: dup
    //   55: aload_0
    //   56: aload 5
    //   58: aload_1
    //   59: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: aload_3
    //   66: invokespecial 266	com/tencent/wcdb/database/SQLiteStatement:<init>	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: astore_1
    //   70: aload_1
    //   71: invokevirtual 499	com/tencent/wcdb/database/SQLiteStatement:executeUpdateDelete	()I
    //   74: istore 4
    //   76: aload_1
    //   77: invokevirtual 271	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   80: aload_0
    //   81: invokevirtual 149	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   84: iload 4
    //   86: ireturn
    //   87: ldc 85
    //   89: astore_1
    //   90: goto -39 -> 51
    //   93: astore_2
    //   94: aload_1
    //   95: invokevirtual 271	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   98: aload_2
    //   99: athrow
    //   100: astore_1
    //   101: aload_0
    //   102: invokevirtual 149	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	SQLiteDatabase
    //   0	107	1	paramString1	String
    //   0	107	2	paramString2	String
    //   0	107	3	paramArrayOfString	String[]
    //   74	11	4	i	int
    //   21	36	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   70	76	93	finally
    //   4	51	100	finally
    //   51	70	100	finally
    //   76	80	100	finally
    //   94	100	100	finally
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
        Log.i("WCDB.SQLiteDatabase", "this database: " + this.mConfigurationLocked.label + " has attached databases. can't  enable WAL.");
        return false;
      }
      SQLiteDatabaseConfiguration localSQLiteDatabaseConfiguration1 = this.mConfigurationLocked;
      localSQLiteDatabaseConfiguration1.openFlags |= 0x20000000;
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
  public java.util.List getAttachedDbs()
  {
    // Byte code:
    //   0: new 232	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 293	java/util/ArrayList:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 112	com/tencent/wcdb/database/SQLiteDatabase:mLock	Ljava/lang/Object;
    //   12: astore_2
    //   13: aload_2
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 153	com/tencent/wcdb/database/SQLiteDatabase:mConnectionPoolLocked	Lcom/tencent/wcdb/database/SQLiteConnectionPool;
    //   19: ifnonnull +7 -> 26
    //   22: aload_2
    //   23: monitorexit
    //   24: aconst_null
    //   25: areturn
    //   26: aload_0
    //   27: getfield 258	com/tencent/wcdb/database/SQLiteDatabase:mHasAttachedDbsLocked	Z
    //   30: ifne +29 -> 59
    //   33: aload_1
    //   34: new 542	android/util/Pair
    //   37: dup
    //   38: ldc_w 544
    //   41: aload_0
    //   42: getfield 123	com/tencent/wcdb/database/SQLiteDatabase:mConfigurationLocked	Lcom/tencent/wcdb/database/SQLiteDatabaseConfiguration;
    //   45: getfield 547	com/tencent/wcdb/database/SQLiteDatabaseConfiguration:path	Ljava/lang/String;
    //   48: invokespecial 550	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   51: invokevirtual 474	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   54: pop
    //   55: aload_2
    //   56: monitorexit
    //   57: aload_1
    //   58: areturn
    //   59: aload_0
    //   60: invokevirtual 133	com/tencent/wcdb/database/SQLiteDatabase:acquireReference	()V
    //   63: aload_2
    //   64: monitorexit
    //   65: aload_0
    //   66: ldc_w 552
    //   69: aconst_null
    //   70: invokevirtual 556	com/tencent/wcdb/database/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   73: astore_2
    //   74: aload_2
    //   75: invokeinterface 561 1 0
    //   80: ifeq +57 -> 137
    //   83: aload_1
    //   84: new 542	android/util/Pair
    //   87: dup
    //   88: aload_2
    //   89: iconst_1
    //   90: invokeinterface 565 2 0
    //   95: aload_2
    //   96: iconst_2
    //   97: invokeinterface 565 2 0
    //   102: invokespecial 550	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   105: invokevirtual 474	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   108: pop
    //   109: goto -35 -> 74
    //   112: astore_1
    //   113: aload_2
    //   114: ifnull +9 -> 123
    //   117: aload_2
    //   118: invokeinterface 566 1 0
    //   123: aload_1
    //   124: athrow
    //   125: astore_1
    //   126: aload_0
    //   127: invokevirtual 149	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   130: aload_1
    //   131: athrow
    //   132: astore_1
    //   133: aload_2
    //   134: monitorexit
    //   135: aload_1
    //   136: athrow
    //   137: aload_2
    //   138: ifnull +9 -> 147
    //   141: aload_2
    //   142: invokeinterface 566 1 0
    //   147: aload_0
    //   148: invokevirtual 149	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   151: aload_1
    //   152: areturn
    //   153: astore_1
    //   154: aconst_null
    //   155: astore_2
    //   156: goto -43 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	SQLiteDatabase
    //   7	77	1	localArrayList	ArrayList
    //   112	12	1	localObject1	Object
    //   125	6	1	localObject2	Object
    //   132	20	1	localList	java.util.List
    //   153	1	1	localObject3	Object
    //   12	144	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   74	109	112	finally
    //   117	123	125	finally
    //   123	125	125	finally
    //   141	147	125	finally
    //   15	24	132	finally
    //   26	57	132	finally
    //   59	65	132	finally
    //   133	135	132	finally
    //   65	74	153	finally
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
  public Map getSyncedTables()
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
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      int j = i;
      if (isMainThread()) {
        j = i | 0x4;
      }
      return j;
    }
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
    catch (SQLiteDatabaseCorruptException paramString1)
    {
      throw paramString1;
    }
    catch (SQLException paramString1)
    {
      Log.e("WCDB.SQLiteDatabase", "Error inserting %s: %s", new Object[] { paramContentValues, paramString1 });
    }
    return -1L;
  }
  
  public long insertOrThrow(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    return insertWithOnConflict(paramString1, paramString2, paramContentValues, 0);
  }
  
  public long insertWithOnConflict(String paramString1, String paramString2, ContentValues paramContentValues, int paramInt)
  {
    int j = 0;
    acquireReference();
    for (;;)
    {
      int i;
      try
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("INSERT");
        localStringBuilder.append(CONFLICT_VALUES[paramInt]);
        localStringBuilder.append(" INTO ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append('(');
        paramString1 = null;
        if ((paramContentValues == null) || (paramContentValues.size() <= 0)) {
          break label294;
        }
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
              break label300;
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
          break label306;
          localStringBuilder.append(paramString1);
          i += 1;
          break label306;
          localStringBuilder.append(')');
          paramString1 = new SQLiteStatement(this, localStringBuilder.toString(), paramString1);
        }
      }
      finally
      {
        StringBuilder localStringBuilder;
        long l;
        releaseReference();
      }
      try
      {
        l = paramString1.executeInsert();
        paramString1.close();
        releaseReference();
        return l;
      }
      finally
      {
        paramString1.close();
      }
      localStringBuilder.append(paramString2 + ") VALUES (NULL");
      continue;
      label294:
      paramInt = 0;
      continue;
      label300:
      paramString1 = "";
      continue;
      label306:
      if (i < paramInt)
      {
        if (i > 0) {
          paramString1 = ",?";
        } else {
          paramString1 = "?";
        }
      }
      else {
        paramString1 = paramString2;
      }
    }
  }
  
  /* Error */
  public boolean isDatabaseIntegrityOk()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 133	com/tencent/wcdb/database/SQLiteDatabase:acquireReference	()V
    //   4: aload_0
    //   5: invokevirtual 673	com/tencent/wcdb/database/SQLiteDatabase:getAttachedDbs	()Ljava/util/List;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnonnull +207 -> 217
    //   13: new 289	java/lang/IllegalStateException
    //   16: dup
    //   17: new 181	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 675
    //   27: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_0
    //   31: invokevirtual 676	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   34: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 678
    //   40: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokespecial 292	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   49: athrow
    //   50: astore_2
    //   51: new 232	java/util/ArrayList
    //   54: dup
    //   55: invokespecial 293	java/util/ArrayList:<init>	()V
    //   58: astore_3
    //   59: aload_3
    //   60: new 542	android/util/Pair
    //   63: dup
    //   64: ldc_w 544
    //   67: aload_0
    //   68: invokevirtual 676	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   71: invokespecial 550	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   74: invokeinterface 681 2 0
    //   79: pop
    //   80: goto +178 -> 258
    //   83: iload_1
    //   84: aload_3
    //   85: invokeinterface 682 1 0
    //   90: if_icmpge +158 -> 248
    //   93: aload_3
    //   94: iload_1
    //   95: invokeinterface 685 2 0
    //   100: checkcast 542	android/util/Pair
    //   103: astore 4
    //   105: aload_0
    //   106: new 181	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   113: ldc_w 687
    //   116: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload 4
    //   121: getfield 690	android/util/Pair:first	Ljava/lang/Object;
    //   124: checkcast 83	java/lang/String
    //   127: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc_w 692
    //   133: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokevirtual 694	com/tencent/wcdb/database/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteStatement;
    //   142: astore_2
    //   143: aload_2
    //   144: invokevirtual 697	com/tencent/wcdb/database/SQLiteStatement:simpleQueryForString	()Ljava/lang/String;
    //   147: astore 5
    //   149: aload 5
    //   151: ldc_w 699
    //   154: invokestatic 703	com/tencent/wcdb/DatabaseUtils:objectEquals	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   157: ifne +63 -> 220
    //   160: ldc 44
    //   162: new 181	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   169: ldc_w 705
    //   172: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload 4
    //   177: getfield 708	android/util/Pair:second	Ljava/lang/Object;
    //   180: checkcast 83	java/lang/String
    //   183: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: ldc_w 710
    //   189: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload 5
    //   194: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 712	com/tencent/wcdb/support/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: aload_2
    //   204: ifnull +7 -> 211
    //   207: aload_2
    //   208: invokevirtual 271	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   211: aload_0
    //   212: invokevirtual 149	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   215: iconst_0
    //   216: ireturn
    //   217: goto +41 -> 258
    //   220: aload_2
    //   221: ifnull +42 -> 263
    //   224: aload_2
    //   225: invokevirtual 271	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   228: goto +35 -> 263
    //   231: aload_2
    //   232: ifnull +7 -> 239
    //   235: aload_2
    //   236: invokevirtual 271	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   239: aload_3
    //   240: athrow
    //   241: astore_2
    //   242: aload_0
    //   243: invokevirtual 149	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   246: aload_2
    //   247: athrow
    //   248: aload_0
    //   249: invokevirtual 149	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   252: iconst_1
    //   253: ireturn
    //   254: astore_3
    //   255: goto -24 -> 231
    //   258: iconst_0
    //   259: istore_1
    //   260: goto -177 -> 83
    //   263: iload_1
    //   264: iconst_1
    //   265: iadd
    //   266: istore_1
    //   267: goto -184 -> 83
    //   270: astore_3
    //   271: aconst_null
    //   272: astore_2
    //   273: goto -42 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	this	SQLiteDatabase
    //   83	184	1	i	int
    //   50	1	2	localSQLiteException	SQLiteException
    //   142	94	2	localSQLiteStatement	SQLiteStatement
    //   241	6	2	localObject1	Object
    //   272	1	2	localObject2	Object
    //   8	232	3	localObject3	Object
    //   254	1	3	localObject4	Object
    //   270	1	3	localObject5	Object
    //   103	73	4	localPair	Pair
    //   147	46	5	str	String
    // Exception table:
    //   from	to	target	type
    //   4	9	50	com/tencent/wcdb/database/SQLiteException
    //   13	50	50	com/tencent/wcdb/database/SQLiteException
    //   4	9	241	finally
    //   13	50	241	finally
    //   51	80	241	finally
    //   83	105	241	finally
    //   207	211	241	finally
    //   224	228	241	finally
    //   235	239	241	finally
    //   239	241	241	finally
    //   143	203	254	finally
    //   105	143	270	finally
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
  
  public Cursor queryWithFactory(SQLiteDatabase.CursorFactory paramCursorFactory, boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return queryWithFactory(paramCursorFactory, paramBoolean, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6, null);
  }
  
  public Cursor queryWithFactory(SQLiteDatabase.CursorFactory paramCursorFactory, boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6, CancellationSignal paramCancellationSignal)
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
  
  public Cursor rawQueryWithFactory(SQLiteDatabase.CursorFactory paramCursorFactory, String paramString1, String[] paramArrayOfString, String paramString2)
  {
    return rawQueryWithFactory(paramCursorFactory, paramString1, paramArrayOfString, paramString2, null);
  }
  
  /* Error */
  public Cursor rawQueryWithFactory(SQLiteDatabase.CursorFactory paramCursorFactory, String paramString1, String[] paramArrayOfString, String paramString2, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 133	com/tencent/wcdb/database/SQLiteDatabase:acquireReference	()V
    //   4: new 760	com/tencent/wcdb/database/SQLiteDirectCursorDriver
    //   7: dup
    //   8: aload_0
    //   9: aload_2
    //   10: aload 4
    //   12: aload 5
    //   14: invokespecial 763	com/tencent/wcdb/database/SQLiteDirectCursorDriver:<init>	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   17: astore_2
    //   18: aload_1
    //   19: ifnull +18 -> 37
    //   22: aload_2
    //   23: aload_1
    //   24: aload_3
    //   25: invokeinterface 768 3 0
    //   30: astore_1
    //   31: aload_0
    //   32: invokevirtual 149	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   35: aload_1
    //   36: areturn
    //   37: aload_0
    //   38: getfield 114	com/tencent/wcdb/database/SQLiteDatabase:mCursorFactory	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   41: astore_1
    //   42: goto -20 -> 22
    //   45: astore_1
    //   46: aload_0
    //   47: invokevirtual 149	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	SQLiteDatabase
    //   0	52	1	paramCursorFactory	SQLiteDatabase.CursorFactory
    //   0	52	2	paramString1	String
    //   0	52	3	paramArrayOfString	String[]
    //   0	52	4	paramString2	String
    //   0	52	5	paramCancellationSignal	CancellationSignal
    // Exception table:
    //   from	to	target	type
    //   4	18	45	finally
    //   22	31	45	finally
    //   37	42	45	finally
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
      i = this.mConfigurationLocked.openFlags;
      this.mConfigurationLocked.openFlags = (this.mConfigurationLocked.openFlags & 0xFFFFFFFE | 0x0);
    }
  }
  
  public long replace(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    try
    {
      long l = insertWithOnConflict(paramString1, paramString2, paramContentValues, 5);
      return l;
    }
    catch (SQLiteDatabaseCorruptException paramString1)
    {
      throw paramString1;
    }
    catch (SQLException paramString1)
    {
      Log.e("WCDB.SQLiteDatabase", "Error inserting " + paramContentValues, new Object[] { paramString1 });
    }
    return -1L;
  }
  
  public long replaceOrThrow(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    return insertWithOnConflict(paramString1, paramString2, paramContentValues, 5);
  }
  
  public void setAsyncCheckpointEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (SQLiteAsyncCheckpointer localSQLiteAsyncCheckpointer = new SQLiteAsyncCheckpointer();; localSQLiteAsyncCheckpointer = null)
    {
      setCheckpointCallback(localSQLiteAsyncCheckpointer);
      return;
    }
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
    if (paramSQLiteCheckpointListener != null) {}
    for (boolean bool1 = true;; bool1 = false) {
      for (;;)
      {
        synchronized (this.mLock)
        {
          throwIfNotOpenLocked();
          if (this.mConfigurationLocked.customWALHookEnabled != bool1) {
            this.mConfigurationLocked.customWALHookEnabled = bool1;
          }
          SQLiteDatabaseConfiguration localSQLiteDatabaseConfiguration;
          try
          {
            this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
            this.mConnectionPoolLocked.setCheckpointListener(paramSQLiteCheckpointListener);
            return;
          }
          catch (RuntimeException paramSQLiteCheckpointListener)
          {
            localSQLiteDatabaseConfiguration = this.mConfigurationLocked;
            if (bool1) {
              break label90;
            }
          }
          bool1 = bool2;
          localSQLiteDatabaseConfiguration.customWALHookEnabled = bool1;
          throw paramSQLiteCheckpointListener;
        }
        label90:
        bool1 = false;
      }
    }
  }
  
  public void setForeignKeyConstraintsEnabled(boolean paramBoolean)
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      if (this.mConfigurationLocked.foreignKeyConstraintsEnabled == paramBoolean) {
        return;
      }
      this.mConfigurationLocked.foreignKeyConstraintsEnabled = paramBoolean;
    }
    try
    {
      this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      localSQLiteDatabaseConfiguration = this.mConfigurationLocked;
      if (paramBoolean) {
        break label73;
      }
    }
    localObject2 = finally;
    throw localObject2;
    SQLiteDatabaseConfiguration localSQLiteDatabaseConfiguration;
    label73:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localSQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled = paramBoolean;
      throw localRuntimeException;
    }
  }
  
  public void setLocale(Locale paramLocale)
  {
    if (paramLocale == null) {
      throw new IllegalArgumentException("locale must not be null.");
    }
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
  
  @Deprecated
  public void setLockingEnabled(boolean paramBoolean) {}
  
  public void setMaxSqlCacheSize(int paramInt)
  {
    if ((paramInt > 100) || (paramInt < 0)) {
      throw new IllegalStateException("expected value between 0 and 100");
    }
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
  
  public long setMaximumSize(long paramLong)
  {
    long l3 = getPageSize();
    long l2 = paramLong / l3;
    long l1 = l2;
    if (paramLong % l3 != 0L) {
      l1 = l2 + 1L;
    }
    return DatabaseUtils.longForQuery(this, "PRAGMA max_page_count = " + l1, null) * l3;
  }
  
  public void setPageSize(long paramLong)
  {
    execSQL("PRAGMA page_size = " + paramLong);
  }
  
  public void setSynchronousMode(int paramInt)
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      int i = this.mConfigurationLocked.synchronousMode;
      if (i != paramInt) {
        this.mConfigurationLocked.synchronousMode = paramInt;
      }
      try
      {
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        this.mConfigurationLocked.synchronousMode = i;
        throw localRuntimeException;
      }
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
    execSQL("PRAGMA user_version = " + paramInt);
  }
  
  public String toString()
  {
    return "SQLiteDatabase: " + getPath();
  }
  
  public int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    return updateWithOnConflict(paramString1, paramContentValues, paramString2, paramArrayOfString, 0);
  }
  
  public int updateWithOnConflict(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, int paramInt)
  {
    if ((paramContentValues == null) || (paramContentValues.size() == 0)) {
      throw new IllegalArgumentException("Empty values");
    }
    acquireReference();
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
        if (paramArrayOfString == null)
        {
          i = paramInt;
          arrayOfObject = new Object[i];
          Iterator localIterator = keySet(paramContentValues).iterator();
          j = 0;
          if (!localIterator.hasNext()) {
            break label273;
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
          }
        }
        else
        {
          i = paramArrayOfString.length + paramInt;
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
        }
        paramString1 = "";
      }
      finally
      {
        releaseReference();
      }
      continue;
      label273:
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
  
  public Pair walCheckpoint(String paramString, boolean paramBoolean)
  {
    acquireReference();
    if (paramBoolean) {}
    for (int i = 2;; i = 0) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDatabase
 * JD-Core Version:    0.7.0.1
 */