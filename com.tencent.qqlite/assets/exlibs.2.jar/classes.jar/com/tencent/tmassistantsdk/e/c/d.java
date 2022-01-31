package com.tencent.tmassistantsdk.e.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.tmassistantsdk.e.a.c;
import com.tencent.tmassistantsdk.f.k;
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
      if ((localSQLiteDatabase != null) && (a(paramd, localSQLiteDatabase) <= 0))
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
      SQLiteDatabase localSQLiteDatabase = com.tencent.tmassistantsdk.e.a.b.a().getWritableDatabase();
      if (localSQLiteDatabase != null) {
        localSQLiteDatabase.delete("downloadInfo", "taskUrl = ?", new String[] { paramString });
      }
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
    //   1: ifnull +84 -> 85
    //   4: invokestatic 48	com/tencent/tmassistantsdk/e/a/b:a	()Lcom/tencent/tmassistantsdk/e/a/c;
    //   7: invokevirtual 54	com/tencent/tmassistantsdk/e/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnull +73 -> 85
    //   15: aload_1
    //   16: invokevirtual 73	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   19: aload_0
    //   20: invokevirtual 79	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   23: astore_0
    //   24: aload_0
    //   25: invokeinterface 85 1 0
    //   30: ifeq +56 -> 86
    //   33: aload_0
    //   34: invokeinterface 89 1 0
    //   39: checkcast 20	com/tencent/tmassistantsdk/downloadservice/d
    //   42: astore_2
    //   43: aload_2
    //   44: aload_1
    //   45: invokestatic 56	com/tencent/tmassistantsdk/e/c/d:a	(Lcom/tencent/tmassistantsdk/downloadservice/d;Landroid/database/sqlite/SQLiteDatabase;)I
    //   48: ifgt -24 -> 24
    //   51: new 17	android/content/ContentValues
    //   54: dup
    //   55: invokespecial 18	android/content/ContentValues:<init>	()V
    //   58: astore_3
    //   59: aload_3
    //   60: aload_2
    //   61: invokestatic 23	com/tencent/tmassistantsdk/downloadservice/d:a	(Landroid/content/ContentValues;Lcom/tencent/tmassistantsdk/downloadservice/d;)V
    //   64: aload_1
    //   65: ldc 25
    //   67: aconst_null
    //   68: aload_3
    //   69: invokevirtual 60	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   72: pop2
    //   73: goto -49 -> 24
    //   76: astore_0
    //   77: aload_0
    //   78: invokevirtual 42	java/lang/Exception:printStackTrace	()V
    //   81: aload_1
    //   82: invokevirtual 92	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   85: return
    //   86: aload_1
    //   87: invokevirtual 95	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   90: goto -9 -> 81
    //   93: astore_0
    //   94: aload_1
    //   95: invokevirtual 92	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   98: aload_0
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramArrayList	ArrayList
    //   10	85	1	localSQLiteDatabase	SQLiteDatabase
    //   42	19	2	locald	com.tencent.tmassistantsdk.downloadservice.d
    //   58	11	3	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   15	24	76	java/lang/Exception
    //   24	73	76	java/lang/Exception
    //   86	90	76	java/lang/Exception
    //   15	24	93	finally
    //   24	73	93	finally
    //   77	81	93	finally
    //   86	90	93	finally
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
    //   9: ifnull +78 -> 87
    //   12: aload 4
    //   14: astore_1
    //   15: aload_0
    //   16: invokevirtual 65	java/lang/String:length	()I
    //   19: ifle +68 -> 87
    //   22: invokestatic 48	com/tencent/tmassistantsdk/e/a/b:a	()Lcom/tencent/tmassistantsdk/e/a/c;
    //   25: invokevirtual 99	com/tencent/tmassistantsdk/e/a/c:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   28: astore_2
    //   29: aload 4
    //   31: astore_1
    //   32: aload_2
    //   33: ifnull +54 -> 87
    //   36: aload_2
    //   37: ldc 101
    //   39: iconst_1
    //   40: anewarray 29	java/lang/String
    //   43: dup
    //   44: iconst_0
    //   45: aload_0
    //   46: aastore
    //   47: invokevirtual 105	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   50: astore_0
    //   51: aload_0
    //   52: ifnull +73 -> 125
    //   55: aload_0
    //   56: astore_1
    //   57: aload_0
    //   58: invokeinterface 110 1 0
    //   63: ifeq +62 -> 125
    //   66: aload_0
    //   67: astore_1
    //   68: aload_0
    //   69: invokestatic 113	com/tencent/tmassistantsdk/downloadservice/d:a	(Landroid/database/Cursor;)Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   72: astore_2
    //   73: aload_2
    //   74: astore_1
    //   75: aload_0
    //   76: ifnull +11 -> 87
    //   79: aload_2
    //   80: astore_1
    //   81: aload_0
    //   82: invokeinterface 116 1 0
    //   87: aload_1
    //   88: areturn
    //   89: astore_2
    //   90: aconst_null
    //   91: astore_0
    //   92: aload_0
    //   93: astore_1
    //   94: aload_2
    //   95: invokevirtual 42	java/lang/Exception:printStackTrace	()V
    //   98: aload 4
    //   100: astore_1
    //   101: aload_0
    //   102: ifnull -15 -> 87
    //   105: aload_3
    //   106: astore_1
    //   107: goto -26 -> 81
    //   110: astore_0
    //   111: aconst_null
    //   112: astore_1
    //   113: aload_1
    //   114: ifnull +9 -> 123
    //   117: aload_1
    //   118: invokeinterface 116 1 0
    //   123: aload_0
    //   124: athrow
    //   125: aload 4
    //   127: astore_1
    //   128: aload_0
    //   129: ifnull -42 -> 87
    //   132: aload_3
    //   133: astore_1
    //   134: goto -53 -> 81
    //   137: astore_0
    //   138: goto -25 -> 113
    //   141: astore_2
    //   142: goto -50 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramString	String
    //   7	127	1	localObject1	Object
    //   28	52	2	localObject2	Object
    //   89	6	2	localException1	Exception
    //   141	1	2	localException2	Exception
    //   4	129	3	localObject3	Object
    //   1	125	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   36	51	89	java/lang/Exception
    //   36	51	110	finally
    //   57	66	137	finally
    //   68	73	137	finally
    //   94	98	137	finally
    //   57	66	141	java/lang/Exception
    //   68	73	141	java/lang/Exception
  }
  
  public static ArrayList c()
  {
    localObject3 = null;
    localObject1 = null;
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = com.tencent.tmassistantsdk.e.a.b.a().getReadableDatabase();
    if (localObject4 != null) {}
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
        break label90;
      }
      localObject1 = localObject4;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label90:
        localObject3 = localObject1;
        localException.printStackTrace();
        if (localObject1 == null) {}
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label118;
      }
      localObject3.close();
    }
    localObject1.close();
    return localArrayList;
  }
  
  public static ArrayList d()
  {
    localObject3 = null;
    localObject1 = null;
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = com.tencent.tmassistantsdk.e.a.b.a().getReadableDatabase();
    if (localObject4 != null) {}
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
        break label205;
      }
      localObject1 = localObject4;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label205:
        localObject3 = localObject1;
        localException.printStackTrace();
        if (localObject1 == null) {}
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label235;
      }
      localObject3.close();
    }
    localObject1.close();
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
          k.b("downloadInfo", "start move data!");
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
        k.b("downloadInfo", "move data exception!");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.e.c.d
 * JD-Core Version:    0.7.0.1
 */