package com.tencent.tmassistantsdk.e.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.tmassistantsdk.e.a.b;
import com.tencent.tmassistantsdk.e.b.a;

public class c
  implements g
{
  private static int a(a parama, SQLiteDatabase paramSQLiteDatabase)
  {
    int i;
    if (parama == null) {
      i = -1;
    }
    for (;;)
    {
      return i;
      try
      {
        ContentValues localContentValues = new ContentValues();
        a(localContentValues, parama);
        int j = paramSQLiteDatabase.update("clientinfo", localContentValues, "clientId = ? and taskUrl = ?", new String[] { parama.a, parama.c });
        i = j;
        if (j <= 0) {
          return 0;
        }
      }
      catch (Exception parama)
      {
        parama.printStackTrace();
      }
    }
    return -2;
  }
  
  private static void a(ContentValues paramContentValues, a parama)
  {
    if (parama != null)
    {
      paramContentValues.put("clientId", parama.a);
      paramContentValues.put("taskId", Integer.valueOf(parama.b));
      paramContentValues.put("taskUrl", parama.c);
    }
  }
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      b.a().getWritableDatabase().delete("clientinfo", "taskUrl = ?", new String[] { paramString });
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a locala = new a();
    locala.a = paramString1;
    locala.c = paramString2;
    if (locala != null) {}
    try
    {
      paramString1 = b.a().getWritableDatabase();
      if (a(locala, paramString1) <= 0)
      {
        paramString2 = new ContentValues();
        a(paramString2, locala);
        paramString1.insert("clientinfo", null, paramString2);
      }
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public final String a()
  {
    return "clientinfo";
  }
  
  public final void a(SQLiteDatabase paramSQLiteDatabase1, SQLiteDatabase paramSQLiteDatabase2)
  {
    localObject = null;
    localSQLiteDatabase = null;
    if ((paramSQLiteDatabase2 != null) && (paramSQLiteDatabase1 != null)) {
      paramSQLiteDatabase2.beginTransaction();
    }
    try
    {
      paramSQLiteDatabase1 = paramSQLiteDatabase1.rawQuery("select * from clientinfo", null);
      if (paramSQLiteDatabase1 != null)
      {
        localSQLiteDatabase = paramSQLiteDatabase1;
        localObject = paramSQLiteDatabase1;
        if (paramSQLiteDatabase1.moveToFirst())
        {
          boolean bool;
          do
          {
            localSQLiteDatabase = paramSQLiteDatabase1;
            localObject = paramSQLiteDatabase1;
            ContentValues localContentValues = new ContentValues();
            localSQLiteDatabase = paramSQLiteDatabase1;
            localObject = paramSQLiteDatabase1;
            a locala = new a();
            localSQLiteDatabase = paramSQLiteDatabase1;
            localObject = paramSQLiteDatabase1;
            locala.a = paramSQLiteDatabase1.getString(paramSQLiteDatabase1.getColumnIndex("clientId"));
            localSQLiteDatabase = paramSQLiteDatabase1;
            localObject = paramSQLiteDatabase1;
            locala.b = paramSQLiteDatabase1.getInt(paramSQLiteDatabase1.getColumnIndex("taskId"));
            localSQLiteDatabase = paramSQLiteDatabase1;
            localObject = paramSQLiteDatabase1;
            locala.c = paramSQLiteDatabase1.getString(paramSQLiteDatabase1.getColumnIndex("taskUrl"));
            localSQLiteDatabase = paramSQLiteDatabase1;
            localObject = paramSQLiteDatabase1;
            a(localContentValues, locala);
            localSQLiteDatabase = paramSQLiteDatabase1;
            localObject = paramSQLiteDatabase1;
            paramSQLiteDatabase2.insert("clientinfo", null, localContentValues);
            localSQLiteDatabase = paramSQLiteDatabase1;
            localObject = paramSQLiteDatabase1;
            bool = paramSQLiteDatabase1.moveToNext();
          } while (bool);
        }
      }
      if (paramSQLiteDatabase1 == null) {
        break label206;
      }
    }
    catch (Exception paramSQLiteDatabase1)
    {
      for (;;)
      {
        label206:
        localObject = localSQLiteDatabase;
        paramSQLiteDatabase1.printStackTrace();
        if (localSQLiteDatabase != null) {
          paramSQLiteDatabase1 = localSQLiteDatabase;
        }
      }
    }
    finally
    {
      if (localObject == null) {
        break label248;
      }
      ((Cursor)localObject).close();
    }
    paramSQLiteDatabase1.close();
    paramSQLiteDatabase2.setTransactionSuccessful();
    paramSQLiteDatabase2.endTransaction();
  }
  
  public final String[] a(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public final String b()
  {
    return "CREATE TABLE if not exists clientinfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, clientId TEXT , taskId INTEGER, taskUrl TEXT);";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.e.c.c
 * JD-Core Version:    0.7.0.1
 */