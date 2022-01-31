package com.tencent.tmassistantsdk.e.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.tmassistantsdk.e.c.g;
import com.tencent.tmassistantsdk.f.f;
import com.tencent.tmassistantsdk.f.k;

public abstract class c
  extends SQLiteOpenHelper
{
  public c(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    k.b("sqliteHelper", "tables count:" + c().length);
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
        k.b("sqliteHelper", "sql=" + str);
        if (f.f("tmassistant_sdk.db"))
        {
          k.b("sqliteHelper", "dataMovement");
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
    f.g("tmassistant_sdk.db");
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
    //   2: aload_0
    //   3: invokespecial 107	android/database/sqlite/SQLiteOpenHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore_1
    //   7: aload_1
    //   8: invokevirtual 111	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   11: ifne +12 -> 23
    //   14: aload_1
    //   15: astore_2
    //   16: aload_1
    //   17: invokevirtual 114	android/database/sqlite/SQLiteDatabase:isDbLockedByOtherThreads	()Z
    //   20: ifeq +19 -> 39
    //   23: ldc2_w 115
    //   26: invokestatic 122	android/os/SystemClock:sleep	(J)V
    //   29: goto -22 -> 7
    //   32: astore_2
    //   33: aload_2
    //   34: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   37: aload_1
    //   38: astore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_2
    //   42: areturn
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    //   48: astore_2
    //   49: aconst_null
    //   50: astore_1
    //   51: goto -18 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	c
    //   6	32	1	localSQLiteDatabase1	SQLiteDatabase
    //   43	4	1	localObject1	Object
    //   50	1	1	localObject2	Object
    //   15	1	2	localSQLiteDatabase2	SQLiteDatabase
    //   32	2	2	localException1	Exception
    //   38	4	2	localSQLiteDatabase3	SQLiteDatabase
    //   48	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   7	14	32	java/lang/Exception
    //   16	23	32	java/lang/Exception
    //   23	29	32	java/lang/Exception
    //   2	7	43	finally
    //   7	14	43	finally
    //   16	23	43	finally
    //   23	29	43	finally
    //   33	37	43	finally
    //   2	7	48	java/lang/Exception
  }
  
  /* Error */
  public SQLiteDatabase getWritableDatabase()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 126	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore_1
    //   7: aload_1
    //   8: invokevirtual 111	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   11: ifne +12 -> 23
    //   14: aload_1
    //   15: astore_2
    //   16: aload_1
    //   17: invokevirtual 114	android/database/sqlite/SQLiteDatabase:isDbLockedByOtherThreads	()Z
    //   20: ifeq +19 -> 39
    //   23: ldc2_w 115
    //   26: invokestatic 122	android/os/SystemClock:sleep	(J)V
    //   29: goto -22 -> 7
    //   32: astore_2
    //   33: aload_2
    //   34: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   37: aload_1
    //   38: astore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_2
    //   42: areturn
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    //   48: astore_2
    //   49: aconst_null
    //   50: astore_1
    //   51: goto -18 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	c
    //   6	32	1	localSQLiteDatabase1	SQLiteDatabase
    //   43	4	1	localObject1	Object
    //   50	1	1	localObject2	Object
    //   15	1	2	localSQLiteDatabase2	SQLiteDatabase
    //   32	2	2	localException1	Exception
    //   38	4	2	localSQLiteDatabase3	SQLiteDatabase
    //   48	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   7	14	32	java/lang/Exception
    //   16	23	32	java/lang/Exception
    //   23	29	32	java/lang/Exception
    //   2	7	43	finally
    //   7	14	43	finally
    //   16	23	43	finally
    //   23	29	43	finally
    //   33	37	43	finally
    //   2	7	48	java/lang/Exception
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    a(paramSQLiteDatabase);
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onOpen(paramSQLiteDatabase);
    int i = paramSQLiteDatabase.getVersion();
    k.b("sqliteHelper", " dbversion:" + i + " newVersion:" + b());
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
            k.b("sqliteHelper", " upgrade:" + localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.e.a.c
 * JD-Core Version:    0.7.0.1
 */