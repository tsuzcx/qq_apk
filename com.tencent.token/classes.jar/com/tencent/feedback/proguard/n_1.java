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
    //   36: ifnull +84 -> 120
    //   39: aload 4
    //   41: astore_3
    //   42: aload 4
    //   44: invokeinterface 44 1 0
    //   49: ifeq +71 -> 120
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
    //   79: invokestatic 59	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   82: ifne +10 -> 92
    //   85: aload 4
    //   87: astore_3
    //   88: aload_1
    //   89: invokevirtual 62	java/lang/Throwable:printStackTrace	()V
    //   92: aload 4
    //   94: ifnull +20 -> 114
    //   97: aload 4
    //   99: invokeinterface 65 1 0
    //   104: ifne +10 -> 114
    //   107: aload 4
    //   109: invokeinterface 68 1 0
    //   114: iconst_0
    //   115: istore_2
    //   116: aload_0
    //   117: monitorexit
    //   118: iload_2
    //   119: ireturn
    //   120: aload 4
    //   122: astore_3
    //   123: aload 5
    //   125: invokeinterface 72 1 0
    //   130: ifle +115 -> 245
    //   133: aload 4
    //   135: astore_3
    //   136: aload 5
    //   138: invokeinterface 76 1 0
    //   143: astore 5
    //   145: aload 4
    //   147: astore_3
    //   148: aload 5
    //   150: invokeinterface 81 1 0
    //   155: ifeq +90 -> 245
    //   158: aload 4
    //   160: astore_3
    //   161: aload 5
    //   163: invokeinterface 85 1 0
    //   168: checkcast 28	java/lang/String
    //   171: astore 6
    //   173: aload 4
    //   175: astore_3
    //   176: aload_1
    //   177: getstatic 91	java/util/Locale:US	Ljava/util/Locale;
    //   180: ldc 93
    //   182: iconst_1
    //   183: anewarray 95	java/lang/Object
    //   186: dup
    //   187: iconst_0
    //   188: aload 6
    //   190: aastore
    //   191: invokestatic 99	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   194: invokevirtual 103	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   197: aload 4
    //   199: astore_3
    //   200: ldc 105
    //   202: iconst_1
    //   203: anewarray 95	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: aload 6
    //   210: aastore
    //   211: invokestatic 109	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   214: pop
    //   215: goto -70 -> 145
    //   218: astore_1
    //   219: aload_3
    //   220: ifnull +18 -> 238
    //   223: aload_3
    //   224: invokeinterface 65 1 0
    //   229: ifne +9 -> 238
    //   232: aload_3
    //   233: invokeinterface 68 1 0
    //   238: aload_1
    //   239: athrow
    //   240: astore_1
    //   241: aload_0
    //   242: monitorexit
    //   243: aload_1
    //   244: athrow
    //   245: aload 4
    //   247: ifnull +20 -> 267
    //   250: aload 4
    //   252: invokeinterface 65 1 0
    //   257: ifne +10 -> 267
    //   260: aload 4
    //   262: invokeinterface 68 1 0
    //   267: iconst_1
    //   268: istore_2
    //   269: goto -153 -> 116
    //   272: astore_1
    //   273: aconst_null
    //   274: astore_3
    //   275: goto -56 -> 219
    //   278: astore_1
    //   279: aconst_null
    //   280: astore 4
    //   282: goto -207 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	this	n
    //   0	285	1	paramSQLiteDatabase	SQLiteDatabase
    //   115	154	2	bool	boolean
    //   41	234	3	localCursor1	android.database.Cursor
    //   32	249	4	localCursor2	android.database.Cursor
    //   9	153	5	localObject	Object
    //   171	38	6	str	String
    // Exception table:
    //   from	to	target	type
    //   42	52	74	java/lang/Throwable
    //   55	71	74	java/lang/Throwable
    //   123	133	74	java/lang/Throwable
    //   136	145	74	java/lang/Throwable
    //   148	158	74	java/lang/Throwable
    //   161	173	74	java/lang/Throwable
    //   176	197	74	java/lang/Throwable
    //   200	215	74	java/lang/Throwable
    //   42	52	218	finally
    //   55	71	218	finally
    //   78	85	218	finally
    //   88	92	218	finally
    //   123	133	218	finally
    //   136	145	218	finally
    //   148	158	218	finally
    //   161	173	218	finally
    //   176	197	218	finally
    //   200	215	218	finally
    //   97	114	240	finally
    //   223	238	240	finally
    //   238	240	240	finally
    //   250	267	240	finally
    //   2	34	272	finally
    //   2	34	278	java/lang/Throwable
  }
  
  public final SQLiteDatabase getReadableDatabase()
  {
    int i = 0;
    Object localObject = null;
    while ((localObject == null) && (i < 5))
    {
      int j = i + 1;
      try
      {
        SQLiteDatabase localSQLiteDatabase2 = super.getReadableDatabase();
        localObject = localSQLiteDatabase2;
        i = j;
      }
      catch (Throwable localThrowable)
      {
        e.c("rqdp{  getReadableDatabase error count} %d", new Object[] { Integer.valueOf(j) });
        if (j == 5) {
          e.d("rqdp{  error get DB failed}", new Object[0]);
        }
        try
        {
          Thread.sleep(200L);
          i = j;
        }
        catch (InterruptedException localInterruptedException)
        {
          i = j;
        }
        if (!e.a(localThrowable))
        {
          localThrowable.printStackTrace();
          i = j;
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
      int j = i + 1;
      try
      {
        SQLiteDatabase localSQLiteDatabase2 = super.getWritableDatabase();
        localObject = localSQLiteDatabase2;
        i = j;
      }
      catch (Exception localException)
      {
        e.c("rqdp{  getWritableDatabase error count} %d", new Object[] { Integer.valueOf(j) });
        if (j == 5) {
          e.d("rqdp{  error get DB failed}", new Object[0]);
        }
        try
        {
          Thread.sleep(200L);
          i = j;
        }
        catch (InterruptedException localInterruptedException)
        {
          i = j;
        }
        if (!e.a(localException))
        {
          localException.printStackTrace();
          i = j;
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
          e.b("rqdp{  table:}%s %s", new Object[] { arrayOfString1[0], arrayOfString1[1] });
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
    //   6: invokestatic 166	com/tencent/feedback/common/d:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/d;
    //   9: pop
    //   10: invokestatic 169	com/tencent/feedback/common/d:c	()Ljava/lang/String;
    //   13: invokestatic 173	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   16: bipush 11
    //   18: if_icmplt +55 -> 73
    //   21: ldc 175
    //   23: iconst_3
    //   24: anewarray 95	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: ldc 10
    //   31: aastore
    //   32: dup
    //   33: iconst_1
    //   34: iload_2
    //   35: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   38: aastore
    //   39: dup
    //   40: iconst_2
    //   41: iload_3
    //   42: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: aastore
    //   46: invokestatic 109	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   49: pop
    //   50: aload_0
    //   51: aload_1
    //   52: invokespecial 177	com/tencent/feedback/proguard/n:a	(Landroid/database/sqlite/SQLiteDatabase;)Z
    //   55: ifeq +21 -> 76
    //   58: ldc 179
    //   60: iconst_0
    //   61: anewarray 95	java/lang/Object
    //   64: invokestatic 109	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   67: pop
    //   68: aload_0
    //   69: aload_1
    //   70: invokevirtual 181	com/tencent/feedback/proguard/n:onCreate	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   73: aload_0
    //   74: monitorexit
    //   75: return
    //   76: ldc 183
    //   78: iconst_0
    //   79: anewarray 95	java/lang/Object
    //   82: invokestatic 131	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   85: pop
    //   86: aload_0
    //   87: getfield 15	com/tencent/feedback/proguard/n:a	Landroid/content/Context;
    //   90: ldc 10
    //   92: invokevirtual 189	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   95: astore_1
    //   96: aload_1
    //   97: ifnull -24 -> 73
    //   100: aload_1
    //   101: invokevirtual 194	java/io/File:canWrite	()Z
    //   104: ifeq -31 -> 73
    //   107: aload_1
    //   108: invokevirtual 197	java/io/File:delete	()Z
    //   111: pop
    //   112: goto -39 -> 73
    //   115: astore_1
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_1
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	n
    //   0	120	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	120	2	paramInt1	int
    //   0	120	3	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   2	73	115	finally
    //   76	96	115	finally
    //   100	112	115	finally
  }
  
  /* Error */
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 201
    //   4: iconst_3
    //   5: anewarray 95	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: ldc 10
    //   12: aastore
    //   13: dup
    //   14: iconst_1
    //   15: iload_2
    //   16: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   19: aastore
    //   20: dup
    //   21: iconst_2
    //   22: iload_3
    //   23: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: aastore
    //   27: invokestatic 109	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   30: pop
    //   31: aload_0
    //   32: aload_1
    //   33: invokespecial 177	com/tencent/feedback/proguard/n:a	(Landroid/database/sqlite/SQLiteDatabase;)Z
    //   36: ifeq +21 -> 57
    //   39: ldc 179
    //   41: iconst_0
    //   42: anewarray 95	java/lang/Object
    //   45: invokestatic 109	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   48: pop
    //   49: aload_0
    //   50: aload_1
    //   51: invokevirtual 181	com/tencent/feedback/proguard/n:onCreate	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   54: aload_0
    //   55: monitorexit
    //   56: return
    //   57: ldc 183
    //   59: iconst_0
    //   60: anewarray 95	java/lang/Object
    //   63: invokestatic 131	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   66: pop
    //   67: aload_0
    //   68: getfield 15	com/tencent/feedback/proguard/n:a	Landroid/content/Context;
    //   71: ldc 10
    //   73: invokevirtual 189	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   76: astore_1
    //   77: aload_1
    //   78: ifnull -24 -> 54
    //   81: aload_1
    //   82: invokevirtual 194	java/io/File:canWrite	()Z
    //   85: ifeq -31 -> 54
    //   88: aload_1
    //   89: invokevirtual 197	java/io/File:delete	()Z
    //   92: pop
    //   93: goto -39 -> 54
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	n
    //   0	101	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	101	2	paramInt1	int
    //   0	101	3	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   2	54	96	finally
    //   57	77	96	finally
    //   81	93	96	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.n
 * JD-Core Version:    0.7.0.1
 */