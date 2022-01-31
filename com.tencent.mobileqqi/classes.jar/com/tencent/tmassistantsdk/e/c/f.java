package com.tencent.tmassistantsdk.e.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.tmassistantsdk.e.a.b;
import com.tencent.tmassistantsdk.e.a.c;
import java.util.HashMap;

public class f
  implements g
{
  private static int a(String paramString1, String paramString2, String paramString3, SQLiteDatabase paramSQLiteDatabase)
  {
    int i;
    if ((paramString1 == null) || (paramString2 == null)) {
      i = -1;
    }
    for (;;)
    {
      return i;
      try
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("settingField", paramString1);
        localContentValues.put("value", paramString2);
        localContentValues.put("type", paramString3);
        int j = paramSQLiteDatabase.update("settingInfo", localContentValues, "settingField = ?", new String[] { paramString1 });
        i = j;
        if (j > 0) {
          continue;
        }
        return 0;
      }
      catch (Exception paramString1)
      {
        paramString1 = paramString1;
        paramString1.printStackTrace();
        return -2;
      }
      finally {}
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (paramString2 != null)) {}
    try
    {
      SQLiteDatabase localSQLiteDatabase = b.a().getWritableDatabase();
      if (a(paramString1, paramString2, paramString3, localSQLiteDatabase) <= 0)
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("settingField", paramString1);
        localContentValues.put("value", paramString2);
        localContentValues.put("type", paramString3);
        localSQLiteDatabase.insert("settingInfo", null, localContentValues);
      }
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static HashMap c()
  {
    Object localObject4 = null;
    Object localObject1 = null;
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        Cursor localCursor = b.a().getReadableDatabase().rawQuery("select * from settingInfo", null);
        if (localCursor == null) {
          break label138;
        }
        localObject1 = localCursor;
        localObject4 = localCursor;
        if (!localCursor.moveToFirst()) {
          break label138;
        }
        localObject1 = localCursor;
        localObject4 = localCursor;
        localHashMap.put(localCursor.getString(localCursor.getColumnIndex("settingField")), localCursor.getString(localCursor.getColumnIndex("value")));
        localObject1 = localCursor;
        localObject4 = localCursor;
        boolean bool = localCursor.moveToNext();
        if (bool) {
          continue;
        }
        if (localCursor == null) {
          continue;
        }
        localObject1 = localCursor;
      }
      catch (Exception localException)
      {
        localObject4 = localObject1;
        localException.printStackTrace();
        if (localObject1 == null) {
          continue;
        }
        continue;
      }
      finally
      {
        if (localObject4 == null) {
          continue;
        }
        localObject4.close();
      }
      localObject1.close();
      return localHashMap;
      label138:
      if (localException != null) {
        Object localObject3 = localException;
      }
    }
  }
  
  public final String a()
  {
    return "settingInfo";
  }
  
  public final void a(SQLiteDatabase paramSQLiteDatabase1, SQLiteDatabase paramSQLiteDatabase2) {}
  
  public final String[] a(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public final String b()
  {
    return "CREATE TABLE if not exists settingInfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, settingField TEXT , value TEXT,type TEXT);";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.e.c.f
 * JD-Core Version:    0.7.0.1
 */