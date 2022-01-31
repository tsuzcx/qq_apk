package btmsdkobf;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

class fj
  extends SQLiteOpenHelper
{
  fj(bs parambs, Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    bo.k("onCreate-db:[" + paramSQLiteDatabase + "]");
    bs.a(this.a, paramSQLiteDatabase);
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    bo.k("onDowngrade-db:[" + paramSQLiteDatabase + "]oldVersion:[" + paramInt1 + "]newVersion:[" + paramInt2 + "]");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    bo.k("onUpgrade-db:[" + paramSQLiteDatabase + "]oldVersion:[" + paramInt1 + "]newVersion:[" + paramInt2 + "]");
    bs.a(this.a, paramSQLiteDatabase, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.fj
 * JD-Core Version:    0.7.0.1
 */