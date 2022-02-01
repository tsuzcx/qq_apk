package com.facebook.stetho.inspector.protocol.module;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteException;
import java.util.Arrays;
import java.util.Collections;

class Database$1
  implements Database.DatabaseDriver.ExecuteResultHandler<Database.ExecuteSQLResponse>
{
  Database$1(Database paramDatabase) {}
  
  public Database.ExecuteSQLResponse handleInsert(long paramLong)
    throws SQLiteException
  {
    Database.ExecuteSQLResponse localExecuteSQLResponse = new Database.ExecuteSQLResponse();
    localExecuteSQLResponse.columnNames = Collections.singletonList("ID of last inserted row");
    localExecuteSQLResponse.values = Collections.singletonList(String.valueOf(paramLong));
    return localExecuteSQLResponse;
  }
  
  public Database.ExecuteSQLResponse handleRawQuery()
    throws SQLiteException
  {
    Database.ExecuteSQLResponse localExecuteSQLResponse = new Database.ExecuteSQLResponse();
    localExecuteSQLResponse.columnNames = Collections.singletonList("success");
    localExecuteSQLResponse.values = Collections.singletonList("true");
    return localExecuteSQLResponse;
  }
  
  public Database.ExecuteSQLResponse handleSelect(Cursor paramCursor)
    throws SQLiteException
  {
    Database.ExecuteSQLResponse localExecuteSQLResponse = new Database.ExecuteSQLResponse();
    localExecuteSQLResponse.columnNames = Arrays.asList(paramCursor.getColumnNames());
    localExecuteSQLResponse.values = Database.access$200(paramCursor, 250);
    return localExecuteSQLResponse;
  }
  
  public Database.ExecuteSQLResponse handleUpdateDelete(int paramInt)
    throws SQLiteException
  {
    Database.ExecuteSQLResponse localExecuteSQLResponse = new Database.ExecuteSQLResponse();
    localExecuteSQLResponse.columnNames = Collections.singletonList("Modified rows");
    localExecuteSQLResponse.values = Collections.singletonList(String.valueOf(paramInt));
    return localExecuteSQLResponse;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.protocol.module.Database.1
 * JD-Core Version:    0.7.0.1
 */