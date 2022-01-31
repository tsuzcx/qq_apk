import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import com.tencent.mobileqq.utils.SecurityUtile;

class ddx
  extends SQLiteCursor
{
  ddx(ddw paramddw, SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
  {
    super(paramSQLiteDatabase, paramSQLiteCursorDriver, paramString, paramSQLiteQuery);
  }
  
  public byte[] getBlob(int paramInt)
  {
    return SecurityUtile.a(super.getBlob(paramInt));
  }
  
  public String getString(int paramInt)
  {
    String str1 = super.getString(paramInt);
    try
    {
      String str2 = SecurityUtile.a(str1);
      return str2;
    }
    catch (Exception localException) {}
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ddx
 * JD-Core Version:    0.7.0.1
 */