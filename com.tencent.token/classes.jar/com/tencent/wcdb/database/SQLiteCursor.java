package com.tencent.wcdb.database;

import com.tencent.wcdb.AbstractWindowedCursor;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import java.util.HashMap;
import java.util.Map;

public class SQLiteCursor
  extends AbstractWindowedCursor
{
  public static final SQLiteDatabase.CursorFactory FACTORY = new SQLiteDatabase.CursorFactory()
  {
    public Cursor newCursor(SQLiteDatabase paramAnonymousSQLiteDatabase, SQLiteCursorDriver paramAnonymousSQLiteCursorDriver, String paramAnonymousString, SQLiteProgram paramAnonymousSQLiteProgram)
    {
      return new SQLiteCursor(paramAnonymousSQLiteCursorDriver, paramAnonymousString, (SQLiteQuery)paramAnonymousSQLiteProgram);
    }
    
    public SQLiteProgram newQuery(SQLiteDatabase paramAnonymousSQLiteDatabase, String paramAnonymousString, Object[] paramAnonymousArrayOfObject, CancellationSignal paramAnonymousCancellationSignal)
    {
      return new SQLiteQuery(paramAnonymousSQLiteDatabase, paramAnonymousString, paramAnonymousArrayOfObject, paramAnonymousCancellationSignal);
    }
  };
  static final int NO_COUNT = -1;
  static final String TAG = "WCDB.SQLiteCursor";
  private Map<String, Integer> mColumnNameMap;
  private final String[] mColumns;
  private int mCount = -1;
  private int mCursorWindowCapacity;
  private final SQLiteCursorDriver mDriver;
  private final String mEditTable;
  private final SQLiteQuery mQuery;
  private final Throwable mStackTrace;
  
  public SQLiteCursor(SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
  {
    if (paramSQLiteQuery != null)
    {
      this.mStackTrace = null;
      this.mDriver = paramSQLiteCursorDriver;
      this.mEditTable = paramString;
      this.mColumnNameMap = null;
      this.mQuery = paramSQLiteQuery;
      this.mColumns = paramSQLiteQuery.getColumnNames();
      this.mRowIdColumnIndex = DatabaseUtils.findRowIdColumnIndex(this.mColumns);
      return;
    }
    throw new IllegalArgumentException("query object cannot be null");
  }
  
  @Deprecated
  public SQLiteCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
  {
    this(paramSQLiteCursorDriver, paramString, paramSQLiteQuery);
  }
  
  private void fillWindow(int paramInt)
  {
    clearOrCreateWindow(getDatabase().getPath());
    try
    {
      if (this.mCount == -1)
      {
        i = DatabaseUtils.cursorPickFillWindowStartPosition(paramInt, 0);
        this.mCount = this.mQuery.fillWindow(this.mWindow, i, paramInt, true);
        this.mCursorWindowCapacity = this.mWindow.getNumRows();
        return;
      }
      int i = DatabaseUtils.cursorPickFillWindowStartPosition(paramInt, this.mCursorWindowCapacity);
      this.mQuery.fillWindow(this.mWindow, i, paramInt, false);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      closeWindow();
      throw localRuntimeException;
    }
  }
  
  public void close()
  {
    super.close();
    try
    {
      this.mQuery.close();
      this.mDriver.cursorClosed();
      return;
    }
    finally {}
  }
  
  public void deactivate()
  {
    super.deactivate();
    this.mDriver.cursorDeactivated();
  }
  
  protected void finalize()
  {
    try
    {
      if (this.mWindow != null) {
        close();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int getColumnIndex(String paramString)
  {
    Object localObject2;
    if (this.mColumnNameMap == null)
    {
      localObject1 = this.mColumns;
      int j = localObject1.length;
      localObject2 = new HashMap(j, 1.0F);
      i = 0;
      while (i < j)
      {
        ((HashMap)localObject2).put(localObject1[i], Integer.valueOf(i));
        i += 1;
      }
      this.mColumnNameMap = ((Map)localObject2);
    }
    int i = paramString.lastIndexOf('.');
    Object localObject1 = paramString;
    if (i != -1)
    {
      localObject1 = new Exception();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("requesting column name with table name -- ");
      ((StringBuilder)localObject2).append(paramString);
      Log.e("WCDB.SQLiteCursor", ((StringBuilder)localObject2).toString(), new Object[] { localObject1 });
      localObject1 = paramString.substring(i + 1);
    }
    paramString = (Integer)this.mColumnNameMap.get(localObject1);
    if (paramString != null) {
      return paramString.intValue();
    }
    return -1;
  }
  
  public String[] getColumnNames()
  {
    return this.mColumns;
  }
  
  public int getCount()
  {
    if (this.mCount == -1) {
      fillWindow(0);
    }
    return this.mCount;
  }
  
  public SQLiteDatabase getDatabase()
  {
    return this.mQuery.getDatabase();
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    if ((this.mWindow == null) || (paramInt2 < this.mWindow.getStartPosition()) || (paramInt2 >= this.mWindow.getStartPosition() + this.mWindow.getNumRows())) {
      fillWindow(paramInt2);
    }
    return true;
  }
  
  /* Error */
  public boolean requery()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 213	com/tencent/wcdb/database/SQLiteCursor:isClosed	()Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 51	com/tencent/wcdb/database/SQLiteCursor:mQuery	Lcom/tencent/wcdb/database/SQLiteQuery;
    //   15: invokevirtual 201	com/tencent/wcdb/database/SQLiteQuery:getDatabase	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   18: invokevirtual 216	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
    //   21: ifne +7 -> 28
    //   24: aload_0
    //   25: monitorexit
    //   26: iconst_0
    //   27: ireturn
    //   28: aload_0
    //   29: getfield 105	com/tencent/wcdb/database/SQLiteCursor:mWindow	Lcom/tencent/wcdb/CursorWindow;
    //   32: ifnull +10 -> 42
    //   35: aload_0
    //   36: getfield 105	com/tencent/wcdb/database/SQLiteCursor:mWindow	Lcom/tencent/wcdb/CursorWindow;
    //   39: invokevirtual 219	com/tencent/wcdb/CursorWindow:clear	()V
    //   42: aload_0
    //   43: iconst_m1
    //   44: putfield 222	com/tencent/wcdb/database/SQLiteCursor:mPos	I
    //   47: aload_0
    //   48: iconst_m1
    //   49: putfield 41	com/tencent/wcdb/database/SQLiteCursor:mCount	I
    //   52: aload_0
    //   53: getfield 45	com/tencent/wcdb/database/SQLiteCursor:mDriver	Lcom/tencent/wcdb/database/SQLiteCursorDriver;
    //   56: aload_0
    //   57: invokeinterface 226 2 0
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_0
    //   65: invokespecial 228	com/tencent/wcdb/AbstractWindowedCursor:requery	()Z
    //   68: istore_1
    //   69: iload_1
    //   70: ireturn
    //   71: astore_2
    //   72: new 166	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   79: astore_3
    //   80: aload_3
    //   81: ldc 230
    //   83: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_3
    //   88: aload_2
    //   89: invokevirtual 233	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   92: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: ldc 15
    //   98: aload_3
    //   99: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: iconst_1
    //   103: anewarray 178	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: aload_2
    //   109: aastore
    //   110: invokestatic 236	com/tencent/wcdb/support/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   113: iconst_0
    //   114: ireturn
    //   115: astore_2
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_2
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	SQLiteCursor
    //   68	2	1	bool	boolean
    //   71	38	2	localIllegalStateException	java.lang.IllegalStateException
    //   115	4	2	localObject	Object
    //   79	20	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   64	69	71	java/lang/IllegalStateException
    //   11	26	115	finally
    //   28	42	115	finally
    //   42	64	115	finally
    //   116	118	115	finally
  }
  
  public void setSelectionArguments(String[] paramArrayOfString)
  {
    this.mDriver.setBindArguments(paramArrayOfString);
  }
  
  public void setWindow(CursorWindow paramCursorWindow)
  {
    super.setWindow(paramCursorWindow);
    this.mCount = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteCursor
 * JD-Core Version:    0.7.0.1
 */