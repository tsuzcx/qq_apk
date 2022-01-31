package com.tencent.tmassistantsdk.e.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.tmassistantsdk.e.c.g;
import com.tencent.tmassistantsdk.f.e;
import com.tencent.tmassistantsdk.f.j;

public abstract class c
  extends SQLiteOpenHelper
{
  public c(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    j.b("sqliteHelper", "tables count:" + c().length);
    Class[] arrayOfClass = c();
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label164;
      }
      Object localObject = arrayOfClass[i];
      try
      {
        localObject = (g)((Class)localObject).newInstance();
        String str = ((g)localObject).b();
        if ((str != null) && (str.length() > 0)) {
          paramSQLiteDatabase.execSQL(str);
        }
        j.b("sqliteHelper", "sql=" + str);
        if (e.f("tmassistant_sdk.db"))
        {
          j.b("sqliteHelper", "dataMovement");
          ((g)localObject).a(a.a().getReadableDatabase(), paramSQLiteDatabase);
        }
      }
      catch (InstantiationException localInstantiationException)
      {
        for (;;)
        {
          localInstantiationException.printStackTrace();
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          localIllegalAccessException.printStackTrace();
        }
      }
      i += 1;
    }
    label164:
    e.g("tmassistant_sdk.db");
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    Class[] arrayOfClass = c();
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Class localClass = arrayOfClass[i];
        try
        {
          paramSQLiteDatabase.delete(((g)localClass.newInstance()).a(), null, null);
          i += 1;
        }
        catch (InstantiationException localInstantiationException)
        {
          for (;;)
          {
            localInstantiationException.printStackTrace();
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          for (;;)
          {
            localIllegalAccessException.printStackTrace();
          }
        }
      }
    }
  }
  
  public abstract int b();
  
  public abstract Class[] c();
  
  /* Error */
  public SQLiteDatabase getReadableDatabase()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: invokespecial 107	android/database/sqlite/SQLiteOpenHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: aload_1
    //   12: invokevirtual 111	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   15: ifne +10 -> 25
    //   18: aload_1
    //   19: invokevirtual 114	android/database/sqlite/SQLiteDatabase:isDbLockedByOtherThreads	()Z
    //   22: ifeq +25 -> 47
    //   25: ldc2_w 115
    //   28: invokestatic 122	android/os/SystemClock:sleep	(J)V
    //   31: goto -20 -> 11
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    //   39: astore_2
    //   40: aload_2
    //   41: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   44: goto -33 -> 11
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	c
    //   3	16	1	localObject	Object
    //   34	16	1	localSQLiteDatabase1	SQLiteDatabase
    //   8	2	2	localSQLiteDatabase2	SQLiteDatabase
    //   39	2	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   4	9	34	finally
    //   11	25	34	finally
    //   25	31	34	finally
    //   40	44	34	finally
    //   4	9	39	java/lang/Exception
  }
  
  /* Error */
  public SQLiteDatabase getWritableDatabase()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: invokespecial 126	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: aload_1
    //   12: invokevirtual 111	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   15: ifne +10 -> 25
    //   18: aload_1
    //   19: invokevirtual 114	android/database/sqlite/SQLiteDatabase:isDbLockedByOtherThreads	()Z
    //   22: ifeq +25 -> 47
    //   25: ldc2_w 115
    //   28: invokestatic 122	android/os/SystemClock:sleep	(J)V
    //   31: goto -20 -> 11
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    //   39: astore_2
    //   40: aload_2
    //   41: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   44: goto -33 -> 11
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	c
    //   3	16	1	localObject	Object
    //   34	16	1	localSQLiteDatabase1	SQLiteDatabase
    //   8	2	2	localSQLiteDatabase2	SQLiteDatabase
    //   39	2	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   4	9	34	finally
    //   11	25	34	finally
    //   25	31	34	finally
    //   40	44	34	finally
    //   4	9	39	java/lang/Exception
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    a(paramSQLiteDatabase);
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onOpen(paramSQLiteDatabase);
    int i = paramSQLiteDatabase.getVersion();
    j.b("sqliteHelper", " dbversion:" + i + " newVersion:" + b());
    if (i != 0)
    {
      if (i >= b()) {
        break label66;
      }
      onUpgrade(paramSQLiteDatabase, i, b());
    }
    label66:
    while (i <= b()) {
      return;
    }
    b(paramSQLiteDatabase);
    a(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      Class[] arrayOfClass = c();
      int k = arrayOfClass.length;
      int i = 0;
      for (;;)
      {
        if (i < k)
        {
          Object localObject = arrayOfClass[i];
          try
          {
            localObject = ((g)((Class)localObject).newInstance()).a(paramInt1, paramInt1 + 1);
            j.b("sqliteHelper", " upgrade:" + localObject);
            if (localObject != null)
            {
              int j = 0;
              while (j < localObject.length)
              {
                paramSQLiteDatabase.execSQL(localObject[j]);
                j += 1;
              }
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            i += 1;
          }
        }
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.e.a.c
 * JD-Core Version:    0.7.0.1
 */