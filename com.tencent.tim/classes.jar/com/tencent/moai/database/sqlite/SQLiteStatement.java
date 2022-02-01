package com.tencent.moai.database.sqlite;

import android.os.ParcelFileDescriptor;

public final class SQLiteStatement
  extends SQLiteProgram
{
  SQLiteStatement(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject)
  {
    super(paramSQLiteDatabase, paramString, paramArrayOfObject, null);
  }
  
  public void execute()
  {
    acquireReference();
    try
    {
      getSession().execute(getSql(), getBindArgs(), getConnectionFlags(), null);
      return;
    }
    catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
    {
      throw localSQLiteDatabaseCorruptException;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public long executeInsert()
  {
    acquireReference();
    try
    {
      long l = getSession().executeForLastInsertedRowId(getSql(), getBindArgs(), getConnectionFlags(), null);
      return l;
    }
    catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
    {
      throw localSQLiteDatabaseCorruptException;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public int executeUpdateDelete()
  {
    acquireReference();
    try
    {
      int i = getSession().executeForChangedRowCount(getSql(), getBindArgs(), getConnectionFlags(), null);
      return i;
    }
    catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
    {
      throw localSQLiteDatabaseCorruptException;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public ParcelFileDescriptor simpleQueryForBlobFileDescriptor()
  {
    acquireReference();
    try
    {
      ParcelFileDescriptor localParcelFileDescriptor = getSession().executeForBlobFileDescriptor(getSql(), getBindArgs(), getConnectionFlags(), null);
      return localParcelFileDescriptor;
    }
    catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
    {
      throw localSQLiteDatabaseCorruptException;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public long simpleQueryForLong()
  {
    acquireReference();
    try
    {
      long l = getSession().executeForLong(getSql(), getBindArgs(), getConnectionFlags(), null);
      return l;
    }
    catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
    {
      throw localSQLiteDatabaseCorruptException;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public String simpleQueryForString()
  {
    acquireReference();
    try
    {
      String str = getSession().executeForString(getSql(), getBindArgs(), getConnectionFlags(), null);
      return str;
    }
    catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
    {
      throw localSQLiteDatabaseCorruptException;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.database.sqlite.SQLiteStatement
 * JD-Core Version:    0.7.0.1
 */