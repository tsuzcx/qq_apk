package mqq.database;

import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;

class EncryptedDatabase$1$1
  extends SQLiteCursor
{
  EncryptedDatabase$1$1(EncryptedDatabase.1 param1, SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString1, SQLiteQuery paramSQLiteQuery, String paramString2)
  {
    super(paramSQLiteDatabase, paramSQLiteCursorDriver, paramString1, paramSQLiteQuery);
  }
  
  public String getString(int paramInt)
  {
    Object localObject = this.val$editTable;
    String str = super.getString(paramInt);
    localObject = str;
    if (!"sqlite_master".equals(this.val$editTable)) {}
    try
    {
      localObject = SecurityUtile.decode(str);
      return localObject;
    }
    catch (Exception localException) {}
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.database.EncryptedDatabase.1.1
 * JD-Core Version:    0.7.0.1
 */