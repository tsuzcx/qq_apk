package com.tencent.wcdb.database;

import com.tencent.wcdb.support.CancellationSignal;

public final class SQLiteStatement
  extends SQLiteProgram
{
  SQLiteStatement(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject)
  {
    super(paramSQLiteDatabase, paramString, paramArrayOfObject, null);
  }
  
  public void execute()
  {
    execute(null);
  }
  
  public void execute(CancellationSignal paramCancellationSignal)
  {
    acquireReference();
    try
    {
      getSession().execute(getSql(), getBindArgs(), getConnectionFlags(), paramCancellationSignal);
      return;
    }
    catch (SQLiteDatabaseCorruptException paramCancellationSignal)
    {
      throw paramCancellationSignal;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public long executeInsert()
  {
    return executeInsert(null);
  }
  
  public long executeInsert(CancellationSignal paramCancellationSignal)
  {
    acquireReference();
    try
    {
      long l = getSession().executeForLastInsertedRowId(getSql(), getBindArgs(), getConnectionFlags(), paramCancellationSignal);
      return l;
    }
    catch (SQLiteDatabaseCorruptException paramCancellationSignal)
    {
      throw paramCancellationSignal;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public int executeUpdateDelete()
  {
    return executeUpdateDelete(null);
  }
  
  public int executeUpdateDelete(CancellationSignal paramCancellationSignal)
  {
    acquireReference();
    try
    {
      int i = getSession().executeForChangedRowCount(getSql(), getBindArgs(), getConnectionFlags(), paramCancellationSignal);
      return i;
    }
    catch (SQLiteDatabaseCorruptException paramCancellationSignal)
    {
      throw paramCancellationSignal;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public long simpleQueryForLong()
  {
    return simpleQueryForLong(null);
  }
  
  public long simpleQueryForLong(CancellationSignal paramCancellationSignal)
  {
    acquireReference();
    try
    {
      long l = getSession().executeForLong(getSql(), getBindArgs(), getConnectionFlags(), paramCancellationSignal);
      return l;
    }
    catch (SQLiteDatabaseCorruptException paramCancellationSignal)
    {
      throw paramCancellationSignal;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public String simpleQueryForString()
  {
    return simpleQueryForString(null);
  }
  
  public String simpleQueryForString(CancellationSignal paramCancellationSignal)
  {
    acquireReference();
    try
    {
      paramCancellationSignal = getSession().executeForString(getSql(), getBindArgs(), getConnectionFlags(), paramCancellationSignal);
      return paramCancellationSignal;
    }
    catch (SQLiteDatabaseCorruptException paramCancellationSignal)
    {
      throw paramCancellationSignal;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public String toString()
  {
    return "SQLiteProgram: " + getSql();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteStatement
 * JD-Core Version:    0.7.0.1
 */