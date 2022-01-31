package com.tencent.token;

import com.tencent.kingkong.DatabaseErrorHandler;
import com.tencent.kingkong.DefaultDatabaseErrorHandler;
import com.tencent.kingkong.database.SQLiteDatabase;

public final class gf
  implements DatabaseErrorHandler
{
  private DefaultDatabaseErrorHandler a = new DefaultDatabaseErrorHandler();
  
  public final void onCorruption(SQLiteDatabase paramSQLiteDatabase)
  {
    this.a.onCorruption(paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gf
 * JD-Core Version:    0.7.0.1
 */