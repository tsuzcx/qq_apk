package com.tencent.kingkong.database;

import com.tencent.kingkong.DatabaseUtils;
import com.tencent.kingkong.support.CancellationSignal;
import java.util.Arrays;

public abstract class SQLiteProgram
  extends SQLiteClosable
{
  private static final String[] EMPTY_STRING_ARRAY = new String[0];
  private final Object[] mBindArgs;
  private final String[] mColumnNames;
  private final SQLiteDatabase mDatabase;
  private final int mNumParameters;
  private final boolean mReadOnly;
  private final String mSql;
  
  SQLiteProgram(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    this.mDatabase = paramSQLiteDatabase;
    this.mSql = paramString.trim();
    int i = DatabaseUtils.getSqlStatementType(this.mSql);
    switch (i)
    {
    default: 
      if (i != 1) {
        break;
      }
    }
    for (;;)
    {
      paramString = new SQLiteStatementInfo();
      paramSQLiteDatabase.getThreadSession().prepare(this.mSql, paramSQLiteDatabase.getThreadDefaultConnectionFlags(bool), paramCancellationSignal, paramString);
      this.mReadOnly = paramString.readOnly;
      this.mColumnNames = paramString.columnNames;
      for (this.mNumParameters = paramString.numParameters; (paramArrayOfObject != null) && (paramArrayOfObject.length > this.mNumParameters); this.mNumParameters = 0)
      {
        throw new IllegalArgumentException("Too many bind arguments.  " + paramArrayOfObject.length + " arguments were provided but the statement needs " + this.mNumParameters + " arguments.");
        this.mReadOnly = false;
        this.mColumnNames = EMPTY_STRING_ARRAY;
      }
      bool = false;
    }
    if (this.mNumParameters != 0)
    {
      this.mBindArgs = new Object[this.mNumParameters];
      if (paramArrayOfObject != null) {
        System.arraycopy(paramArrayOfObject, 0, this.mBindArgs, 0, paramArrayOfObject.length);
      }
      return;
    }
    this.mBindArgs = null;
  }
  
  private void bind(int paramInt, Object paramObject)
  {
    if ((paramInt < 1) || (paramInt > this.mNumParameters)) {
      throw new IllegalArgumentException("Cannot bind argument at index " + paramInt + " because the index is out of range.  " + "The statement has " + this.mNumParameters + " parameters.");
    }
    this.mBindArgs[(paramInt - 1)] = paramObject;
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
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("the bind value at index " + paramInt + " is null");
    }
    bind(paramInt, paramArrayOfByte);
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
    if (paramString == null) {
      throw new IllegalArgumentException("the bind value at index " + paramInt + " is null");
    }
    bind(paramInt, paramString);
  }
  
  public void clearBindings()
  {
    if (this.mBindArgs != null) {
      Arrays.fill(this.mBindArgs, null);
    }
  }
  
  final Object[] getBindArgs()
  {
    return this.mBindArgs;
  }
  
  final String[] getColumnNames()
  {
    return this.mColumnNames;
  }
  
  protected final int getConnectionFlags()
  {
    return this.mDatabase.getThreadDefaultConnectionFlags(this.mReadOnly);
  }
  
  final SQLiteDatabase getDatabase()
  {
    return this.mDatabase;
  }
  
  protected final SQLiteSession getSession()
  {
    return this.mDatabase.getThreadSession();
  }
  
  final String getSql()
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
    clearBindings();
  }
  
  protected final void onCorruption()
  {
    this.mDatabase.onCorruption();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.database.SQLiteProgram
 * JD-Core Version:    0.7.0.1
 */