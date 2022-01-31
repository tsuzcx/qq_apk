package com.tencent.tmassistantsdk.e.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.tmassistantsdk.e.a.c;
import com.tencent.tmassistantsdk.f.j;
import java.util.ArrayList;

public class d
  implements g
{
  private static int a(com.tencent.tmassistantsdk.downloadservice.d paramd, SQLiteDatabase paramSQLiteDatabase)
  {
    int i;
    if (paramd == null) {
      i = -1;
    }
    for (;;)
    {
      return i;
      try
      {
        ContentValues localContentValues = new ContentValues();
        com.tencent.tmassistantsdk.downloadservice.d.a(localContentValues, paramd);
        int j = paramSQLiteDatabase.update("downloadInfo", localContentValues, "taskUrl = ?", new String[] { paramd.b });
        i = j;
        if (j <= 0) {
          return 0;
        }
      }
      catch (Exception paramd)
      {
        paramd.printStackTrace();
      }
    }
    return -2;
  }
  
  public static void a(com.tencent.tmassistantsdk.downloadservice.d paramd)
  {
    if (paramd != null) {}
    try
    {
      SQLiteDatabase localSQLiteDatabase = com.tencent.tmassistantsdk.e.a.b.a().getWritableDatabase();
      if (a(paramd, localSQLiteDatabase) <= 0)
      {
        ContentValues localContentValues = new ContentValues();
        com.tencent.tmassistantsdk.downloadservice.d.a(localContentValues, paramd);
        localSQLiteDatabase.insert("downloadInfo", null, localContentValues);
      }
      return;
    }
    catch (Exception paramd)
    {
      paramd.printStackTrace();
    }
  }
  
  public static void a(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {}
    try
    {
      com.tencent.tmassistantsdk.e.a.b.a().getWritableDatabase().delete("downloadInfo", "taskUrl = ?", new String[] { paramString });
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  /* Error */
  public static void a(ArrayList paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +80 -> 81
    //   4: invokestatic 48	com/tencent/tmassistantsdk/e/a/b:a	()Lcom/tencent/tmassistantsdk/e/a/c;
    //   7: invokevirtual 54	com/tencent/tmassistantsdk/e/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   10: astore_1
    //   11: aload_1
    //   12: invokevirtual 73	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   15: aload_0
    //   16: invokevirtual 79	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   19: astore_0
    //   20: aload_0
    //   21: invokeinterface 85 1 0
    //   26: ifeq +56 -> 82
    //   29: aload_0
    //   30: invokeinterface 89 1 0
    //   35: checkcast 20	com/tencent/tmassistantsdk/downloadservice/d
    //   38: astore_2
    //   39: aload_2
    //   40: aload_1
    //   41: invokestatic 56	com/tencent/tmassistantsdk/e/c/d:a	(Lcom/tencent/tmassistantsdk/downloadservice/d;Landroid/database/sqlite/SQLiteDatabase;)I
    //   44: ifgt -24 -> 20
    //   47: new 17	android/content/ContentValues
    //   50: dup
    //   51: invokespecial 18	android/content/ContentValues:<init>	()V
    //   54: astore_3
    //   55: aload_3
    //   56: aload_2
    //   57: invokestatic 23	com/tencent/tmassistantsdk/downloadservice/d:a	(Landroid/content/ContentValues;Lcom/tencent/tmassistantsdk/downloadservice/d;)V
    //   60: aload_1
    //   61: ldc 25
    //   63: aconst_null
    //   64: aload_3
    //   65: invokevirtual 60	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   68: pop2
    //   69: goto -49 -> 20
    //   72: astore_0
    //   73: aload_0
    //   74: invokevirtual 42	java/lang/Exception:printStackTrace	()V
    //   77: aload_1
    //   78: invokevirtual 92	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   81: return
    //   82: aload_1
    //   83: invokevirtual 95	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   86: goto -9 -> 77
    //   89: astore_0
    //   90: aload_1
    //   91: invokevirtual 92	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   94: aload_0
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramArrayList	ArrayList
    //   10	81	1	localSQLiteDatabase	SQLiteDatabase
    //   38	19	2	locald	com.tencent.tmassistantsdk.downloadservice.d
    //   54	11	3	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   11	20	72	java/lang/Exception
    //   20	69	72	java/lang/Exception
    //   82	86	72	java/lang/Exception
    //   11	20	89	finally
    //   20	69	89	finally
    //   73	77	89	finally
    //   82	86	89	finally
  }
  
  /* Error */
  public static com.tencent.tmassistantsdk.downloadservice.d b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload 4
    //   7: astore_1
    //   8: aload_0
    //   9: ifnull +69 -> 78
    //   12: aload 4
    //   14: astore_1
    //   15: aload_0
    //   16: invokevirtual 65	java/lang/String:length	()I
    //   19: ifle +59 -> 78
    //   22: invokestatic 48	com/tencent/tmassistantsdk/e/a/b:a	()Lcom/tencent/tmassistantsdk/e/a/c;
    //   25: invokevirtual 99	com/tencent/tmassistantsdk/e/a/c:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   28: ldc 101
    //   30: iconst_1
    //   31: anewarray 29	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: aload_0
    //   37: aastore
    //   38: invokevirtual 105	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   41: astore_0
    //   42: aload_0
    //   43: ifnull +73 -> 116
    //   46: aload_0
    //   47: astore_1
    //   48: aload_0
    //   49: invokeinterface 110 1 0
    //   54: ifeq +62 -> 116
    //   57: aload_0
    //   58: astore_1
    //   59: aload_0
    //   60: invokestatic 113	com/tencent/tmassistantsdk/downloadservice/d:a	(Landroid/database/Cursor;)Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   63: astore_2
    //   64: aload_2
    //   65: astore_1
    //   66: aload_0
    //   67: ifnull +11 -> 78
    //   70: aload_2
    //   71: astore_1
    //   72: aload_0
    //   73: invokeinterface 116 1 0
    //   78: aload_1
    //   79: areturn
    //   80: astore_2
    //   81: aconst_null
    //   82: astore_0
    //   83: aload_0
    //   84: astore_1
    //   85: aload_2
    //   86: invokevirtual 42	java/lang/Exception:printStackTrace	()V
    //   89: aload 4
    //   91: astore_1
    //   92: aload_0
    //   93: ifnull -15 -> 78
    //   96: aload_3
    //   97: astore_1
    //   98: goto -26 -> 72
    //   101: astore_0
    //   102: aconst_null
    //   103: astore_1
    //   104: aload_1
    //   105: ifnull +9 -> 114
    //   108: aload_1
    //   109: invokeinterface 116 1 0
    //   114: aload_0
    //   115: athrow
    //   116: aload 4
    //   118: astore_1
    //   119: aload_0
    //   120: ifnull -42 -> 78
    //   123: aload_3
    //   124: astore_1
    //   125: goto -53 -> 72
    //   128: astore_0
    //   129: goto -25 -> 104
    //   132: astore_2
    //   133: goto -50 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramString	String
    //   7	118	1	localObject1	Object
    //   63	8	2	locald	com.tencent.tmassistantsdk.downloadservice.d
    //   80	6	2	localException1	Exception
    //   132	1	2	localException2	Exception
    //   4	120	3	localObject2	Object
    //   1	116	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   22	42	80	java/lang/Exception
    //   22	42	101	finally
    //   48	57	128	finally
    //   59	64	128	finally
    //   85	89	128	finally
    //   48	57	132	java/lang/Exception
    //   59	64	132	java/lang/Exception
  }
  
  public static ArrayList c()
  {
    localObject3 = null;
    localObject1 = null;
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = com.tencent.tmassistantsdk.e.a.b.a().getReadableDatabase();
    try
    {
      localObject4 = ((SQLiteDatabase)localObject4).rawQuery("select * from downloadInfo", null);
      if (localObject4 != null)
      {
        localObject1 = localObject4;
        localObject3 = localObject4;
        if (((Cursor)localObject4).moveToFirst())
        {
          boolean bool;
          do
          {
            localObject1 = localObject4;
            localObject3 = localObject4;
            localArrayList.add(com.tencent.tmassistantsdk.downloadservice.d.a((Cursor)localObject4));
            localObject1 = localObject4;
            localObject3 = localObject4;
            bool = ((Cursor)localObject4).moveToNext();
          } while (bool);
        }
      }
      if (localObject4 == null) {
        break label86;
      }
      localObject1 = localObject4;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject3 = localObject1;
        localException.printStackTrace();
        if (localObject1 == null) {}
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label114;
      }
      localObject3.close();
    }
    localObject1.close();
    label86:
    return localArrayList;
  }
  
  public static ArrayList d()
  {
    localObject3 = null;
    localObject1 = null;
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = com.tencent.tmassistantsdk.e.a.b.a().getReadableDatabase();
    try
    {
      localObject4 = ((SQLiteDatabase)localObject4).rawQuery("select a.taskUrl,a.status,b.clientId from downloadInfo as a left outer join clientinfo as b on a.taskUrl = b.taskUrl where b.clientId is not null and (a.status = 2 or a.status = 1)", null);
      if (localObject4 != null)
      {
        localObject1 = localObject4;
        localObject3 = localObject4;
        if (((Cursor)localObject4).moveToFirst())
        {
          boolean bool;
          do
          {
            localObject1 = localObject4;
            localObject3 = localObject4;
            Object localObject5 = ((Cursor)localObject4).getString(((Cursor)localObject4).getColumnIndex("clientId"));
            localObject1 = localObject4;
            localObject3 = localObject4;
            String str = ((Cursor)localObject4).getString(((Cursor)localObject4).getColumnIndex("taskUrl"));
            localObject1 = localObject4;
            localObject3 = localObject4;
            int i = ((Cursor)localObject4).getInt(((Cursor)localObject4).getColumnIndex("status"));
            localObject1 = localObject4;
            localObject3 = localObject4;
            localObject5 = new com.tencent.tmassistantsdk.downloadservice.a.b((String)localObject5, str);
            localObject1 = localObject4;
            localObject3 = localObject4;
            ((com.tencent.tmassistantsdk.downloadservice.a.b)localObject5).c = i;
            localObject1 = localObject4;
            localObject3 = localObject4;
            localArrayList.add(localObject5);
            localObject1 = localObject4;
            localObject3 = localObject4;
            bool = ((Cursor)localObject4).moveToNext();
          } while (bool);
        }
      }
      if (localObject4 == null) {
        break label200;
      }
      localObject1 = localObject4;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject3 = localObject1;
        localException.printStackTrace();
        if (localObject1 == null) {}
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label230;
      }
      localObject3.close();
    }
    localObject1.close();
    label200:
    return localArrayList;
  }
  
  public final String a()
  {
    return "downloadInfo";
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
      paramSQLiteDatabase1 = paramSQLiteDatabase1.rawQuery("select * from downloadInfo", null);
      if (paramSQLiteDatabase1 != null)
      {
        localSQLiteDatabase = paramSQLiteDatabase1;
        localObject = paramSQLiteDatabase1;
        if (paramSQLiteDatabase1.moveToFirst())
        {
          localSQLiteDatabase = paramSQLiteDatabase1;
          localObject = paramSQLiteDatabase1;
          j.b("downloadInfo", "start move data!");
          boolean bool;
          do
          {
            localSQLiteDatabase = paramSQLiteDatabase1;
            localObject = paramSQLiteDatabase1;
            ContentValues localContentValues = new ContentValues();
            localSQLiteDatabase = paramSQLiteDatabase1;
            localObject = paramSQLiteDatabase1;
            com.tencent.tmassistantsdk.downloadservice.d.a(localContentValues, com.tencent.tmassistantsdk.downloadservice.d.b(paramSQLiteDatabase1));
            localSQLiteDatabase = paramSQLiteDatabase1;
            localObject = paramSQLiteDatabase1;
            paramSQLiteDatabase2.insert("downloadInfo", null, localContentValues);
            localSQLiteDatabase = paramSQLiteDatabase1;
            localObject = paramSQLiteDatabase1;
            bool = paramSQLiteDatabase1.moveToNext();
          } while (bool);
        }
      }
      if (paramSQLiteDatabase1 == null) {
        break label131;
      }
    }
    catch (Exception paramSQLiteDatabase1)
    {
      for (;;)
      {
        label131:
        localObject = localSQLiteDatabase;
        paramSQLiteDatabase1.printStackTrace();
        localObject = localSQLiteDatabase;
        j.b("downloadInfo", "move data exception!");
        if (localSQLiteDatabase != null) {
          paramSQLiteDatabase1 = localSQLiteDatabase;
        }
      }
    }
    finally
    {
      if (localObject == null) {
        break label184;
      }
      ((Cursor)localObject).close();
    }
    paramSQLiteDatabase1.close();
    paramSQLiteDatabase2.setTransactionSuccessful();
    paramSQLiteDatabase2.endTransaction();
  }
  
  public final String[] a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) && (paramInt2 == 2)) {
      return new String[] { "alter table downloadInfo add column headerParams TEXT;" };
    }
    return new String[] { "alter table downloadInfo add column netType TEXT;", "alter table downloadInfo add column downloadFailedErrCode INTEGER;", "alter table downloadInfo add column downloadFailedTime INTEGER;" };
  }
  
  public final String b()
  {
    return "CREATE TABLE if not exists downloadInfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, taskId INTEGER , uId TEXT, taskUrl TEXT, finalUrl TEXT, fileName TEXT, contentType TEXT, redirectCnt INTEGER, retryCnt INTEGER, totalBytes INTEGER,status INTEGER,receivedBytes INTEGER,priority INTEGER,netType TEXT,downloadFailedErrCode INTEGER,downloadFailedTime INTEGER,headerParams TEXT);";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.e.c.d
 * JD-Core Version:    0.7.0.1
 */