package com.tencent.wcdb.database;

import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.CursorIndexOutOfBoundsException;
import com.tencent.wcdb.StaleDataException;
import com.tencent.wcdb.support.CancellationSignal;

public class SQLiteAsyncCursor
  extends AbstractCursor
{
  public static final SQLiteDatabase.CursorFactory FACTORY = new SQLiteDatabase.CursorFactory()
  {
    public Cursor newCursor(SQLiteDatabase paramAnonymousSQLiteDatabase, SQLiteCursorDriver paramAnonymousSQLiteCursorDriver, String paramAnonymousString, SQLiteProgram paramAnonymousSQLiteProgram)
    {
      return new SQLiteAsyncCursor(paramAnonymousSQLiteCursorDriver, paramAnonymousString, (SQLiteAsyncQuery)paramAnonymousSQLiteProgram);
    }
    
    public SQLiteProgram newQuery(SQLiteDatabase paramAnonymousSQLiteDatabase, String paramAnonymousString, Object[] paramAnonymousArrayOfObject, CancellationSignal paramAnonymousCancellationSignal)
    {
      return new SQLiteAsyncQuery(paramAnonymousSQLiteDatabase, paramAnonymousString, paramAnonymousArrayOfObject, paramAnonymousCancellationSignal);
    }
  };
  private static final int MAX_KEEP_CHUNKS = 32;
  private static final int MAX_PREFETCH = 256;
  private static final int MIN_FETCH_ROWS = 32;
  private static final String TAG = "WCDB.SQLiteAsyncCursor";
  private final String[] mColumns;
  private volatile int mCount;
  private long mCurrentRow;
  private final SQLiteCursorDriver mDriver;
  private final SQLiteAsyncQuery mQuery;
  private QueryThread mQueryThread;
  private final Object mWaitLock;
  private ChunkedCursorWindow mWindow;
  
  public SQLiteAsyncCursor(SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteAsyncQuery paramSQLiteAsyncQuery)
  {
    if (paramSQLiteAsyncQuery != null)
    {
      this.mQuery = paramSQLiteAsyncQuery;
      this.mDriver = paramSQLiteCursorDriver;
      this.mColumns = paramSQLiteAsyncQuery.getColumnNames();
      this.mCount = -1;
      this.mWaitLock = new Object();
      this.mWindow = new ChunkedCursorWindow(16777216);
      this.mQueryThread = new QueryThread();
      this.mQueryThread.start();
      return;
    }
    throw new IllegalArgumentException("query object cannot be null");
  }
  
  private void checkValidRow()
  {
    if (this.mCurrentRow != 0L) {
      return;
    }
    if (!isValidPosition(this.mPos)) {
      throw new CursorIndexOutOfBoundsException(this.mPos, this.mCount);
    }
    throw new StaleDataException("Cannot get valid Row object");
  }
  
  private boolean isValidPosition(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < getCount());
  }
  
  private boolean requestRow()
  {
    ChunkedCursorWindow localChunkedCursorWindow = this.mWindow;
    boolean bool = false;
    if (localChunkedCursorWindow == null) {
      return false;
    }
    if (!isValidPosition(this.mPos)) {
      return false;
    }
    this.mQueryThread.requestPos(this.mPos);
    this.mCurrentRow = this.mWindow.getRowUnsafe(this.mPos);
    if (this.mCurrentRow == 0L) {
      this.mCurrentRow = waitForRow(this.mPos);
    }
    if (this.mCurrentRow != 0L) {
      bool = true;
    }
    return bool;
  }
  
  private long waitForRow(int paramInt)
  {
    try
    {
      synchronized (this.mWaitLock)
      {
        long l;
        for (;;)
        {
          l = this.mWindow.getRowUnsafe(paramInt);
          if (l != 0L) {
            break label58;
          }
          if (!isValidPosition(paramInt)) {
            break;
          }
          this.mWaitLock.wait();
        }
        throw new CursorIndexOutOfBoundsException(this.mPos, this.mCount);
        label58:
        return l;
      }
      return 0L;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  public void close()
  {
    super.close();
    this.mQuery.close();
    this.mDriver.cursorClosed();
  }
  
  public void deactivate()
  {
    super.deactivate();
    this.mDriver.cursorDeactivated();
  }
  
  public byte[] getBlob(int paramInt)
  {
    checkValidRow();
    return this.mWindow.getBlobUnsafe(this.mCurrentRow, paramInt);
  }
  
  public String[] getColumnNames()
  {
    return this.mColumns;
  }
  
  public int getCount()
  {
    if (this.mCount >= 0) {
      return this.mCount;
    }
    if (this.mWindow == null) {
      return -1;
    }
    try
    {
      synchronized (this.mWaitLock)
      {
        while (this.mCount < 0) {
          this.mWaitLock.wait();
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      label55:
      break label55;
    }
    return this.mCount;
  }
  
  public double getDouble(int paramInt)
  {
    checkValidRow();
    return this.mWindow.getDoubleUnsafe(this.mCurrentRow, paramInt);
  }
  
  public float getFloat(int paramInt)
  {
    return (float)getDouble(paramInt);
  }
  
  public int getInt(int paramInt)
  {
    return (int)getLong(paramInt);
  }
  
  public long getLong(int paramInt)
  {
    checkValidRow();
    return this.mWindow.getLongUnsafe(this.mCurrentRow, paramInt);
  }
  
  public short getShort(int paramInt)
  {
    return (short)(int)getLong(paramInt);
  }
  
  public String getString(int paramInt)
  {
    checkValidRow();
    return this.mWindow.getStringUnsafe(this.mCurrentRow, paramInt);
  }
  
  public int getType(int paramInt)
  {
    checkValidRow();
    return this.mWindow.getTypeUnsafe(this.mCurrentRow, paramInt);
  }
  
  public boolean isNull(int paramInt)
  {
    return getType(paramInt) == 0;
  }
  
  public boolean moveToPosition(int paramInt)
  {
    int i = paramInt;
    if (paramInt < -1) {
      i = -1;
    }
    if (i != this.mPos)
    {
      this.mWindow.endRowUnsafe(this.mCurrentRow);
      this.mCurrentRow = 0L;
    }
    paramInt = getCount();
    boolean bool2 = false;
    if (i >= paramInt)
    {
      this.mPos = paramInt;
      return false;
    }
    this.mPos = i;
    boolean bool1 = bool2;
    if (i >= 0)
    {
      bool1 = bool2;
      if (requestRow()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected void onDeactivateOrClose()
  {
    long l = this.mCurrentRow;
    if (l != 0L)
    {
      this.mWindow.endRowUnsafe(l);
      this.mCurrentRow = 0L;
    }
    Object localObject = this.mQueryThread;
    if (localObject != null) {
      ((QueryThread)localObject).quit();
    }
    try
    {
      this.mQueryThread.join();
      label44:
      this.mQueryThread = null;
      localObject = this.mWindow;
      if (localObject != null)
      {
        ((ChunkedCursorWindow)localObject).close();
        this.mWindow = null;
      }
      this.mCount = -1;
      this.mPos = -1;
      super.onDeactivateOrClose();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label44;
    }
  }
  
  private class QueryThread
    extends Thread
  {
    private int mFetchPos = 0;
    private int mMinPos = 0;
    private volatile int mRequestPos = 0;
    
    QueryThread()
    {
      super();
    }
    
    void quit()
    {
      interrupt();
    }
    
    void requestPos(int paramInt)
    {
      try
      {
        this.mRequestPos = paramInt;
        notifyAll();
        return;
      }
      finally {}
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 17	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:this$0	Lcom/tencent/wcdb/database/SQLiteAsyncCursor;
      //   4: invokestatic 48	com/tencent/wcdb/database/SQLiteAsyncCursor:access$000	(Lcom/tencent/wcdb/database/SQLiteAsyncCursor;)Lcom/tencent/wcdb/database/SQLiteAsyncQuery;
      //   7: invokevirtual 54	com/tencent/wcdb/database/SQLiteAsyncQuery:getCount	()I
      //   10: istore_1
      //   11: aload_0
      //   12: getfield 17	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:this$0	Lcom/tencent/wcdb/database/SQLiteAsyncCursor;
      //   15: invokestatic 58	com/tencent/wcdb/database/SQLiteAsyncCursor:access$100	(Lcom/tencent/wcdb/database/SQLiteAsyncCursor;)Ljava/lang/Object;
      //   18: astore 5
      //   20: aload 5
      //   22: monitorenter
      //   23: aload_0
      //   24: getfield 17	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:this$0	Lcom/tencent/wcdb/database/SQLiteAsyncCursor;
      //   27: iload_1
      //   28: invokestatic 62	com/tencent/wcdb/database/SQLiteAsyncCursor:access$202	(Lcom/tencent/wcdb/database/SQLiteAsyncCursor;I)I
      //   31: pop
      //   32: aload_0
      //   33: getfield 17	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:this$0	Lcom/tencent/wcdb/database/SQLiteAsyncCursor;
      //   36: invokestatic 58	com/tencent/wcdb/database/SQLiteAsyncCursor:access$100	(Lcom/tencent/wcdb/database/SQLiteAsyncCursor;)Ljava/lang/Object;
      //   39: invokevirtual 41	java/lang/Object:notifyAll	()V
      //   42: aload 5
      //   44: monitorexit
      //   45: invokestatic 66	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:interrupted	()Z
      //   48: ifne +257 -> 305
      //   51: aload_0
      //   52: monitorenter
      //   53: aload_0
      //   54: getfield 24	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:mRequestPos	I
      //   57: sipush 256
      //   60: iadd
      //   61: aload_0
      //   62: getfield 28	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:mFetchPos	I
      //   65: if_icmpgt +21 -> 86
      //   68: aload_0
      //   69: getfield 24	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:mRequestPos	I
      //   72: aload_0
      //   73: getfield 26	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:mMinPos	I
      //   76: if_icmplt +10 -> 86
      //   79: aload_0
      //   80: invokevirtual 69	java/lang/Object:wait	()V
      //   83: goto -30 -> 53
      //   86: aload_0
      //   87: getfield 24	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:mRequestPos	I
      //   90: istore_1
      //   91: aload_0
      //   92: monitorexit
      //   93: iload_1
      //   94: aload_0
      //   95: getfield 26	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:mMinPos	I
      //   98: if_icmpge +33 -> 131
      //   101: aload_0
      //   102: getfield 17	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:this$0	Lcom/tencent/wcdb/database/SQLiteAsyncCursor;
      //   105: invokestatic 48	com/tencent/wcdb/database/SQLiteAsyncCursor:access$000	(Lcom/tencent/wcdb/database/SQLiteAsyncCursor;)Lcom/tencent/wcdb/database/SQLiteAsyncQuery;
      //   108: invokevirtual 72	com/tencent/wcdb/database/SQLiteAsyncQuery:reset	()V
      //   111: aload_0
      //   112: iconst_0
      //   113: putfield 28	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:mFetchPos	I
      //   116: aload_0
      //   117: getfield 17	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:this$0	Lcom/tencent/wcdb/database/SQLiteAsyncCursor;
      //   120: invokestatic 76	com/tencent/wcdb/database/SQLiteAsyncCursor:access$300	(Lcom/tencent/wcdb/database/SQLiteAsyncCursor;)Lcom/tencent/wcdb/database/ChunkedCursorWindow;
      //   123: invokevirtual 81	com/tencent/wcdb/database/ChunkedCursorWindow:clear	()V
      //   126: aload_0
      //   127: iconst_0
      //   128: putfield 26	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:mMinPos	I
      //   131: aload_0
      //   132: getfield 28	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:mFetchPos	I
      //   135: iload_1
      //   136: sipush 256
      //   139: iadd
      //   140: if_icmpge -95 -> 45
      //   143: aload_0
      //   144: getfield 17	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:this$0	Lcom/tencent/wcdb/database/SQLiteAsyncCursor;
      //   147: invokestatic 76	com/tencent/wcdb/database/SQLiteAsyncCursor:access$300	(Lcom/tencent/wcdb/database/SQLiteAsyncCursor;)Lcom/tencent/wcdb/database/ChunkedCursorWindow;
      //   150: invokevirtual 84	com/tencent/wcdb/database/ChunkedCursorWindow:getNumChunks	()I
      //   153: bipush 32
      //   155: if_icmple +32 -> 187
      //   158: aload_0
      //   159: getfield 17	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:this$0	Lcom/tencent/wcdb/database/SQLiteAsyncCursor;
      //   162: invokestatic 76	com/tencent/wcdb/database/SQLiteAsyncCursor:access$300	(Lcom/tencent/wcdb/database/SQLiteAsyncCursor;)Lcom/tencent/wcdb/database/ChunkedCursorWindow;
      //   165: aload_0
      //   166: getfield 26	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:mMinPos	I
      //   169: invokevirtual 88	com/tencent/wcdb/database/ChunkedCursorWindow:removeChunk	(I)J
      //   172: lstore_3
      //   173: lload_3
      //   174: ldc2_w 89
      //   177: lcmp
      //   178: ifeq +9 -> 187
      //   181: aload_0
      //   182: lload_3
      //   183: l2i
      //   184: putfield 26	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:mMinPos	I
      //   187: aload_0
      //   188: getfield 17	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:this$0	Lcom/tencent/wcdb/database/SQLiteAsyncCursor;
      //   191: invokestatic 58	com/tencent/wcdb/database/SQLiteAsyncCursor:access$100	(Lcom/tencent/wcdb/database/SQLiteAsyncCursor;)Ljava/lang/Object;
      //   194: astore 5
      //   196: aload 5
      //   198: monitorenter
      //   199: aload_0
      //   200: getfield 17	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:this$0	Lcom/tencent/wcdb/database/SQLiteAsyncCursor;
      //   203: invokestatic 48	com/tencent/wcdb/database/SQLiteAsyncCursor:access$000	(Lcom/tencent/wcdb/database/SQLiteAsyncCursor;)Lcom/tencent/wcdb/database/SQLiteAsyncQuery;
      //   206: aload_0
      //   207: getfield 17	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:this$0	Lcom/tencent/wcdb/database/SQLiteAsyncCursor;
      //   210: invokestatic 76	com/tencent/wcdb/database/SQLiteAsyncCursor:access$300	(Lcom/tencent/wcdb/database/SQLiteAsyncCursor;)Lcom/tencent/wcdb/database/ChunkedCursorWindow;
      //   213: aload_0
      //   214: getfield 28	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:mFetchPos	I
      //   217: bipush 32
      //   219: invokevirtual 94	com/tencent/wcdb/database/SQLiteAsyncQuery:fillRows	(Lcom/tencent/wcdb/database/ChunkedCursorWindow;II)I
      //   222: istore_2
      //   223: aload_0
      //   224: getfield 28	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:mFetchPos	I
      //   227: iload_1
      //   228: if_icmpgt +23 -> 251
      //   231: aload_0
      //   232: getfield 28	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:mFetchPos	I
      //   235: iload_2
      //   236: iadd
      //   237: iload_1
      //   238: if_icmple +13 -> 251
      //   241: aload_0
      //   242: getfield 17	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:this$0	Lcom/tencent/wcdb/database/SQLiteAsyncCursor;
      //   245: invokestatic 58	com/tencent/wcdb/database/SQLiteAsyncCursor:access$100	(Lcom/tencent/wcdb/database/SQLiteAsyncCursor;)Ljava/lang/Object;
      //   248: invokevirtual 41	java/lang/Object:notifyAll	()V
      //   251: aload 5
      //   253: monitorexit
      //   254: aload_0
      //   255: aload_0
      //   256: getfield 28	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:mFetchPos	I
      //   259: iload_2
      //   260: iadd
      //   261: putfield 28	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:mFetchPos	I
      //   264: goto -219 -> 45
      //   267: astore 6
      //   269: aload 5
      //   271: monitorexit
      //   272: aload 6
      //   274: athrow
      //   275: astore 5
      //   277: aload_0
      //   278: monitorexit
      //   279: aload 5
      //   281: athrow
      //   282: astore 6
      //   284: aload 5
      //   286: monitorexit
      //   287: aload 6
      //   289: athrow
      //   290: astore 5
      //   292: aload_0
      //   293: getfield 17	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:this$0	Lcom/tencent/wcdb/database/SQLiteAsyncCursor;
      //   296: invokestatic 48	com/tencent/wcdb/database/SQLiteAsyncCursor:access$000	(Lcom/tencent/wcdb/database/SQLiteAsyncCursor;)Lcom/tencent/wcdb/database/SQLiteAsyncQuery;
      //   299: invokevirtual 97	com/tencent/wcdb/database/SQLiteAsyncQuery:release	()V
      //   302: aload 5
      //   304: athrow
      //   305: aload_0
      //   306: getfield 17	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:this$0	Lcom/tencent/wcdb/database/SQLiteAsyncCursor;
      //   309: invokestatic 48	com/tencent/wcdb/database/SQLiteAsyncCursor:access$000	(Lcom/tencent/wcdb/database/SQLiteAsyncCursor;)Lcom/tencent/wcdb/database/SQLiteAsyncQuery;
      //   312: invokevirtual 97	com/tencent/wcdb/database/SQLiteAsyncQuery:release	()V
      //   315: return
      //   316: astore 5
      //   318: goto -13 -> 305
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	321	0	this	QueryThread
      //   10	229	1	i	int
      //   222	39	2	j	int
      //   172	11	3	l	long
      //   275	10	5	localObject2	Object
      //   290	13	5	localObject3	Object
      //   316	1	5	localInterruptedException	InterruptedException
      //   267	6	6	localObject4	Object
      //   282	6	6	localObject5	Object
      // Exception table:
      //   from	to	target	type
      //   199	251	267	finally
      //   251	254	267	finally
      //   269	272	267	finally
      //   53	83	275	finally
      //   86	93	275	finally
      //   277	279	275	finally
      //   23	45	282	finally
      //   284	287	282	finally
      //   0	23	290	finally
      //   45	53	290	finally
      //   93	131	290	finally
      //   131	173	290	finally
      //   181	187	290	finally
      //   187	199	290	finally
      //   254	264	290	finally
      //   272	275	290	finally
      //   279	282	290	finally
      //   287	290	290	finally
      //   0	23	316	java/lang/InterruptedException
      //   45	53	316	java/lang/InterruptedException
      //   93	131	316	java/lang/InterruptedException
      //   131	173	316	java/lang/InterruptedException
      //   181	187	316	java/lang/InterruptedException
      //   187	199	316	java/lang/InterruptedException
      //   254	264	316	java/lang/InterruptedException
      //   272	275	316	java/lang/InterruptedException
      //   279	282	316	java/lang/InterruptedException
      //   287	290	316	java/lang/InterruptedException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteAsyncCursor
 * JD-Core Version:    0.7.0.1
 */