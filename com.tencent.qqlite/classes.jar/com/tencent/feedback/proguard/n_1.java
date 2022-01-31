package com.tencent.feedback.proguard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.feedback.common.e;

public final class n
  extends SQLiteOpenHelper
{
  private Context a;
  
  public n(Context paramContext)
  {
    super(paramContext, "eup_db", null, 14);
    this.a = paramContext;
  }
  
  /* Error */
  private boolean a(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 21	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 24	java/util/ArrayList:<init>	()V
    //   9: astore 5
    //   11: aload_1
    //   12: ldc 26
    //   14: iconst_1
    //   15: anewarray 28	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: ldc 30
    //   22: aastore
    //   23: ldc 32
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: invokevirtual 38	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore 4
    //   34: aload 4
    //   36: ifnull +74 -> 110
    //   39: aload 4
    //   41: astore_3
    //   42: aload 4
    //   44: invokeinterface 44 1 0
    //   49: ifeq +61 -> 110
    //   52: aload 4
    //   54: astore_3
    //   55: aload 5
    //   57: aload 4
    //   59: iconst_0
    //   60: invokeinterface 48 2 0
    //   65: invokeinterface 54 2 0
    //   70: pop
    //   71: goto -32 -> 39
    //   74: astore_1
    //   75: aload 4
    //   77: astore_3
    //   78: aload_1
    //   79: invokevirtual 57	java/lang/Throwable:printStackTrace	()V
    //   82: aload 4
    //   84: ifnull +20 -> 104
    //   87: aload 4
    //   89: invokeinterface 60 1 0
    //   94: ifne +10 -> 104
    //   97: aload 4
    //   99: invokeinterface 63 1 0
    //   104: iconst_0
    //   105: istore_2
    //   106: aload_0
    //   107: monitorexit
    //   108: iload_2
    //   109: ireturn
    //   110: aload 4
    //   112: astore_3
    //   113: aload 5
    //   115: invokeinterface 67 1 0
    //   120: ifle +114 -> 234
    //   123: aload 4
    //   125: astore_3
    //   126: aload 5
    //   128: invokeinterface 71 1 0
    //   133: astore 5
    //   135: aload 4
    //   137: astore_3
    //   138: aload 5
    //   140: invokeinterface 76 1 0
    //   145: ifeq +89 -> 234
    //   148: aload 4
    //   150: astore_3
    //   151: aload 5
    //   153: invokeinterface 80 1 0
    //   158: checkcast 28	java/lang/String
    //   161: astore 6
    //   163: aload 4
    //   165: astore_3
    //   166: aload_1
    //   167: getstatic 86	java/util/Locale:US	Ljava/util/Locale;
    //   170: ldc 88
    //   172: iconst_1
    //   173: anewarray 90	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: aload 6
    //   180: aastore
    //   181: invokestatic 94	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   184: invokevirtual 98	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   187: aload 4
    //   189: astore_3
    //   190: ldc 100
    //   192: iconst_1
    //   193: anewarray 90	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: aload 6
    //   200: aastore
    //   201: invokestatic 106	com/tencent/feedback/common/e:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: goto -69 -> 135
    //   207: astore_1
    //   208: aload_3
    //   209: ifnull +18 -> 227
    //   212: aload_3
    //   213: invokeinterface 60 1 0
    //   218: ifne +9 -> 227
    //   221: aload_3
    //   222: invokeinterface 63 1 0
    //   227: aload_1
    //   228: athrow
    //   229: astore_1
    //   230: aload_0
    //   231: monitorexit
    //   232: aload_1
    //   233: athrow
    //   234: aload 4
    //   236: ifnull +20 -> 256
    //   239: aload 4
    //   241: invokeinterface 60 1 0
    //   246: ifne +10 -> 256
    //   249: aload 4
    //   251: invokeinterface 63 1 0
    //   256: iconst_1
    //   257: istore_2
    //   258: goto -152 -> 106
    //   261: astore_1
    //   262: aconst_null
    //   263: astore_3
    //   264: goto -56 -> 208
    //   267: astore_1
    //   268: aconst_null
    //   269: astore 4
    //   271: goto -196 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	n
    //   0	274	1	paramSQLiteDatabase	SQLiteDatabase
    //   105	153	2	bool	boolean
    //   41	223	3	localCursor1	android.database.Cursor
    //   32	238	4	localCursor2	android.database.Cursor
    //   9	143	5	localObject	Object
    //   161	38	6	str	String
    // Exception table:
    //   from	to	target	type
    //   42	52	74	java/lang/Throwable
    //   55	71	74	java/lang/Throwable
    //   113	123	74	java/lang/Throwable
    //   126	135	74	java/lang/Throwable
    //   138	148	74	java/lang/Throwable
    //   151	163	74	java/lang/Throwable
    //   166	187	74	java/lang/Throwable
    //   190	204	74	java/lang/Throwable
    //   42	52	207	finally
    //   55	71	207	finally
    //   78	82	207	finally
    //   113	123	207	finally
    //   126	135	207	finally
    //   138	148	207	finally
    //   151	163	207	finally
    //   166	187	207	finally
    //   190	204	207	finally
    //   87	104	229	finally
    //   212	227	229	finally
    //   227	229	229	finally
    //   239	256	229	finally
    //   2	34	261	finally
    //   2	34	267	java/lang/Throwable
  }
  
  public final SQLiteDatabase getReadableDatabase()
  {
    int i = 0;
    Object localObject = null;
    while ((localObject == null) && (i < 5))
    {
      i += 1;
      try
      {
        SQLiteDatabase localSQLiteDatabase2 = super.getReadableDatabase();
        localObject = localSQLiteDatabase2;
      }
      catch (Throwable localThrowable)
      {
        e.c("rqdp{  getReadableDatabase error count} %d", new Object[] { Integer.valueOf(i) });
        if (i == 5) {
          e.d("rqdp{  error get DB failed}", new Object[0]);
        }
        try
        {
          Thread.sleep(200L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      finally {}
    }
    return localSQLiteDatabase1;
  }
  
  public final SQLiteDatabase getWritableDatabase()
  {
    int i = 0;
    Object localObject = null;
    while ((localObject == null) && (i < 5))
    {
      i += 1;
      try
      {
        SQLiteDatabase localSQLiteDatabase2 = super.getWritableDatabase();
        localObject = localSQLiteDatabase2;
      }
      catch (Exception localException)
      {
        e.c("rqdp{  getWritableDatabase error count} %d", new Object[] { Integer.valueOf(i) });
        if (i == 5) {
          e.d("rqdp{  error get DB failed}", new Object[0]);
        }
        try
        {
          Thread.sleep(200L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      finally {}
    }
    return localSQLiteDatabase1;
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = 0;
    if (paramSQLiteDatabase != null) {}
    try
    {
      if (m.a != null)
      {
        String[][] arrayOfString = m.a;
        int j = arrayOfString.length;
        while (i < j)
        {
          String[] arrayOfString1 = arrayOfString[i];
          e.g("rqdp{  table:}%s %s", new Object[] { arrayOfString1[0], arrayOfString1[1] });
          paramSQLiteDatabase.execSQL(arrayOfString1[1]);
          i += 1;
        }
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 15	com/tencent/feedback/proguard/n:a	Landroid/content/Context;
    //   6: invokestatic 163	com/tencent/feedback/common/d:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/d;
    //   9: pop
    //   10: invokestatic 166	com/tencent/feedback/common/d:c	()Ljava/lang/String;
    //   13: invokestatic 170	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   16: bipush 11
    //   18: if_icmplt +53 -> 71
    //   21: ldc 172
    //   23: iconst_3
    //   24: anewarray 90	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: ldc 10
    //   31: aastore
    //   32: dup
    //   33: iconst_1
    //   34: iload_2
    //   35: invokestatic 120	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   38: aastore
    //   39: dup
    //   40: iconst_2
    //   41: iload_3
    //   42: invokestatic 120	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: aastore
    //   46: invokestatic 106	com/tencent/feedback/common/e:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   49: aload_0
    //   50: aload_1
    //   51: invokespecial 174	com/tencent/feedback/proguard/n:a	(Landroid/database/sqlite/SQLiteDatabase;)Z
    //   54: ifeq +20 -> 74
    //   57: ldc 176
    //   59: iconst_0
    //   60: anewarray 90	java/lang/Object
    //   63: invokestatic 106	com/tencent/feedback/common/e:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: aload_0
    //   67: aload_1
    //   68: invokevirtual 178	com/tencent/feedback/proguard/n:onCreate	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   71: aload_0
    //   72: monitorexit
    //   73: return
    //   74: ldc 180
    //   76: iconst_0
    //   77: anewarray 90	java/lang/Object
    //   80: invokestatic 128	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload_0
    //   84: getfield 15	com/tencent/feedback/proguard/n:a	Landroid/content/Context;
    //   87: ldc 10
    //   89: invokevirtual 186	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull -23 -> 71
    //   97: aload_1
    //   98: invokevirtual 191	java/io/File:canWrite	()Z
    //   101: ifeq -30 -> 71
    //   104: aload_1
    //   105: invokevirtual 194	java/io/File:delete	()Z
    //   108: pop
    //   109: goto -38 -> 71
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	n
    //   0	117	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	117	2	paramInt1	int
    //   0	117	3	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   2	71	112	finally
    //   74	93	112	finally
    //   97	109	112	finally
  }
  
  /* Error */
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 198
    //   4: iconst_3
    //   5: anewarray 90	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: ldc 10
    //   12: aastore
    //   13: dup
    //   14: iconst_1
    //   15: iload_2
    //   16: invokestatic 120	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   19: aastore
    //   20: dup
    //   21: iconst_2
    //   22: iload_3
    //   23: invokestatic 120	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: aastore
    //   27: invokestatic 106	com/tencent/feedback/common/e:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aload_0
    //   31: aload_1
    //   32: invokespecial 174	com/tencent/feedback/proguard/n:a	(Landroid/database/sqlite/SQLiteDatabase;)Z
    //   35: ifeq +20 -> 55
    //   38: ldc 176
    //   40: iconst_0
    //   41: anewarray 90	java/lang/Object
    //   44: invokestatic 106	com/tencent/feedback/common/e:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: aload_0
    //   48: aload_1
    //   49: invokevirtual 178	com/tencent/feedback/proguard/n:onCreate	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: ldc 180
    //   57: iconst_0
    //   58: anewarray 90	java/lang/Object
    //   61: invokestatic 128	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: aload_0
    //   65: getfield 15	com/tencent/feedback/proguard/n:a	Landroid/content/Context;
    //   68: ldc 10
    //   70: invokevirtual 186	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   73: astore_1
    //   74: aload_1
    //   75: ifnull -23 -> 52
    //   78: aload_1
    //   79: invokevirtual 191	java/io/File:canWrite	()Z
    //   82: ifeq -30 -> 52
    //   85: aload_1
    //   86: invokevirtual 194	java/io/File:delete	()Z
    //   89: pop
    //   90: goto -38 -> 52
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	n
    //   0	98	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	98	2	paramInt1	int
    //   0	98	3	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   2	52	93	finally
    //   55	74	93	finally
    //   78	90	93	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.n
 * JD-Core Version:    0.7.0.1
 */