package com.tencent.token;

import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.DefaultDatabaseErrorHandler;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class el
  implements DatabaseErrorHandler
{
  private DefaultDatabaseErrorHandler a = new DefaultDatabaseErrorHandler();
  
  public void onCorruption(SQLiteDatabase paramSQLiteDatabase)
  {
    this.a.onCorruption(paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.el
 * JD-Core Version:    0.7.0.1
 */