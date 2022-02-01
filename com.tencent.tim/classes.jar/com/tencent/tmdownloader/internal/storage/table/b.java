package com.tencent.tmdownloader.internal.storage.table;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.tmassistant.common.a.c;
import com.tencent.tmassistant.common.a.d;
import com.tencent.tmassistantbase.util.ab;

public class b
  implements c
{
  private static int a(com.tencent.tmdownloader.internal.storage.b.a parama, SQLiteDatabase paramSQLiteDatabase)
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
        ab.c("ClientInfoTable", "exception: ", parama);
        parama.printStackTrace();
      }
    }
    return -2;
  }
  
  private static void a(ContentValues paramContentValues, com.tencent.tmdownloader.internal.storage.b.a parama)
  {
    if (parama != null)
    {
      paramContentValues.put("clientId", parama.a);
      paramContentValues.put("taskId", Integer.valueOf(parama.b));
      paramContentValues.put("taskUrl", parama.c);
    }
  }
  
  public static void a(com.tencent.tmdownloader.internal.storage.b.a parama)
  {
    if (parama != null) {}
    try
    {
      SQLiteDatabase localSQLiteDatabase = com.tencent.tmdownloader.internal.storage.a.a.c().getWritableDatabase();
      if ((localSQLiteDatabase != null) && (a(parama, localSQLiteDatabase) <= 0))
      {
        ContentValues localContentValues = new ContentValues();
        a(localContentValues, parama);
        localSQLiteDatabase.insert("clientinfo", null, localContentValues);
      }
      return;
    }
    catch (Exception parama)
    {
      ab.c("ClientInfoTable", "exception: ", parama);
      parama.printStackTrace();
    }
  }
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      SQLiteDatabase localSQLiteDatabase = com.tencent.tmdownloader.internal.storage.a.a.c().getWritableDatabase();
      if (localSQLiteDatabase != null) {
        localSQLiteDatabase.delete("clientinfo", "taskUrl = ?", new String[] { paramString });
      }
      return;
    }
    catch (Exception paramString)
    {
      ab.c("ClientInfoTable", "exception: ", paramString);
      paramString.printStackTrace();
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    com.tencent.tmdownloader.internal.storage.b.a locala = new com.tencent.tmdownloader.internal.storage.b.a();
    locala.a = paramString1;
    locala.c = paramString2;
    a(locala);
  }
  
  public String createTableSQL()
  {
    return "CREATE TABLE if not exists clientinfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, clientId TEXT , taskId INTEGER, taskUrl TEXT);";
  }
  
  public String[] getAlterSQL(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public String tableName()
  {
    return "clientinfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.storage.table.b
 * JD-Core Version:    0.7.0.1
 */