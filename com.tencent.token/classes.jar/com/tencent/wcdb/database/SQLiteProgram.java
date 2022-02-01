package com.tencent.wcdb.database;

import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.support.CancellationSignal;
import java.util.Arrays;

public abstract class SQLiteProgram
  extends SQLiteClosable
{
  private static final String[] EMPTY_STRING_ARRAY = new String[0];
  private static final String TAG = "WCDB.SQLiteProgram";
  private final Object[] mBindArgs;
  private SQLiteSession mBoundSession;
  private final String[] mColumnNames;
  private final SQLiteDatabase mDatabase;
  private final int mNumParameters;
  protected SQLiteConnection.PreparedStatement mPreparedStatement;
  private final boolean mReadOnly;
  private final String mSql;
  
  protected SQLiteProgram(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    this.mDatabase = paramSQLiteDatabase;
    this.mSql = paramString.trim();
    int i = DatabaseUtils.getSqlStatementType(this.mSql);
    switch (i)
    {
    default: 
      bool = true;
      if (i != 1) {
        break;
      }
      break;
    case 4: 
    case 5: 
    case 6: 
      this.mReadOnly = false;
      this.mColumnNames = EMPTY_STRING_ARRAY;
      this.mNumParameters = 0;
      break;
    }
    boolean bool = false;
    paramString = new SQLiteStatementInfo();
    paramSQLiteDatabase.getThreadSession().prepare(this.mSql, paramSQLiteDatabase.getThreadDefaultConnectionFlags(bool), paramCancellationSignal, paramString);
    this.mReadOnly = paramString.readOnly;
    this.mColumnNames = paramString.columnNames;
    this.mNumParameters = paramString.numParameters;
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > this.mNumParameters))
    {
      paramSQLiteDatabase = new StringBuilder();
      paramSQLiteDatabase.append("Too many bind arguments.  ");
      paramSQLiteDatabase.append(paramArrayOfObject.length);
      paramSQLiteDatabase.append(" arguments were provided but the statement needs ");
      paramSQLiteDatabase.append(this.mNumParameters);
      paramSQLiteDatabase.append(" arguments.");
      throw new IllegalArgumentException(paramSQLiteDatabase.toString());
    }
    i = this.mNumParameters;
    if (i != 0)
    {
      this.mBindArgs = new Object[i];
      if (paramArrayOfObject != null) {
        System.arraycopy(paramArrayOfObject, 0, this.mBindArgs, 0, paramArrayOfObject.length);
      }
    }
    else
    {
      this.mBindArgs = null;
    }
    this.mPreparedStatement = null;
    this.mBoundSession = null;
  }
  
  private void bind(int paramInt, Object paramObject)
  {
    if ((paramInt >= 1) && (paramInt <= this.mNumParameters))
    {
      this.mBindArgs[(paramInt - 1)] = paramObject;
      return;
    }
    paramObject = new StringBuilder();
    paramObject.append("Cannot bind argument at index ");
    paramObject.append(paramInt);
    paramObject.append(" because the index is out of range.  The statement has ");
    paramObject.append(this.mNumParameters);
    paramObject.append(" parameters.");
    throw new IllegalArgumentException(paramObject.toString());
  }
  
  protected boolean acquirePreparedStatement()
  {
    try
    {
      SQLiteSession localSQLiteSession1 = this.mDatabase.getThreadSession();
      SQLiteSession localSQLiteSession2 = this.mBoundSession;
      if (localSQLiteSession1 == localSQLiteSession2) {
        return false;
      }
      if (this.mBoundSession == null)
      {
        this.mBoundSession = localSQLiteSession1;
        this.mPreparedStatement = localSQLiteSession1.acquirePreparedStatement(this.mSql, this.mDatabase.getThreadDefaultConnectionFlags(this.mReadOnly));
        this.mPreparedStatement.bindArguments(this.mBindArgs);
        return true;
      }
      throw new IllegalStateException("SQLiteProgram has bound to another thread.");
    }
    finally {}
  }
  
  public void bindAllArgsAsStrings(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      int i = paramArrayOfString.length;
      while (i != 0)
      {
        bindString(i, paramArrayOfString[(i - 1)]);
        i -= 1;
      }
    }
  }
  
  public void bindBlob(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      bind(paramInt, paramArrayOfByte);
      return;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("the bind value at index ");
    paramArrayOfByte.append(paramInt);
    paramArrayOfByte.append(" is null");
    throw new IllegalArgumentException(paramArrayOfByte.toString());
  }
  
  public void bindDouble(int paramInt, double paramDouble)
  {
    bind(paramInt, Double.valueOf(paramDouble));
  }
  
  public void bindLong(int paramInt, long paramLong)
  {
    bind(paramInt, Long.valueOf(paramLong));
  }
  
  public void bindNull(int paramInt)
  {
    bind(paramInt, null);
  }
  
  public void bindString(int paramInt, String paramString)
  {
    if (paramString != null)
    {
      bind(paramInt, paramString);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("the bind value at index ");
    paramString.append(paramInt);
    paramString.append(" is null");
    throw new IllegalArgumentException(paramString.toString());
  }
  
  public void clearBindings()
  {
    Object[] arrayOfObject = this.mBindArgs;
    if (arrayOfObject != null) {
      Arrays.fill(arrayOfObject, null);
    }
  }
  
  protected void finalize()
  {
    try
    {
      if ((this.mBoundSession == null) && (this.mPreparedStatement == null))
      {
        super.finalize();
        return;
      }
      throw new SQLiteMisuseException("Acquired prepared statement is not released.");
    }
    finally {}
  }
  
  protected final Object[] getBindArgs()
  {
    return this.mBindArgs;
  }
  
  public final String[] getColumnNames()
  {
    return this.mColumnNames;
  }
  
  protected final int getConnectionFlags()
  {
    return this.mDatabase.getThreadDefaultConnectionFlags(this.mReadOnly);
  }
  
  public final SQLiteDatabase getDatabase()
  {
    return this.mDatabase;
  }
  
  protected final SQLiteSession getSession()
  {
    return this.mDatabase.getThreadSession();
  }
  
  protected final String getSql()
  {
    return this.mSql;
  }
  
  @Deprecated
  public final int getUniqueId()
  {
    return -1;
  }
  
  protected void onAllReferencesReleased()
  {
    releasePreparedStatement();
    clearBindings();
  }
  
  protected final void onCorruption()
  {
    SQLiteDebug.collectLastIOTraceStats(this.mDatabase);
    this.mDatabase.onCorruption();
  }
  
  protected void releasePreparedStatement()
  {
    try
    {
      if (this.mBoundSession == null)
      {
        SQLiteConnection.PreparedStatement localPreparedStatement = this.mPreparedStatement;
        if (localPreparedStatement == null) {
          return;
        }
      }
      if ((this.mBoundSession != null) && (this.mPreparedStatement != null))
      {
        if (this.mBoundSession == this.mDatabase.getThreadSession())
        {
          this.mBoundSession.releasePreparedStatement(this.mPreparedStatement);
          this.mPreparedStatement = null;
          this.mBoundSession = null;
          return;
        }
        throw new IllegalStateException("SQLiteProgram has bound to another thread.");
      }
      throw new IllegalStateException("Internal state error.");
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteProgram
 * JD-Core Version:    0.7.0.1
 */