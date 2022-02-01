package com.tencent.feedback.proguard;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.feedback.common.d;
import com.tencent.feedback.common.e;
import java.io.File;

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
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 4
    //   8: aload 4
    //   10: astore_2
    //   11: aload 5
    //   13: astore_3
    //   14: new 21	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 24	java/util/ArrayList:<init>	()V
    //   21: astore 6
    //   23: aload 4
    //   25: astore_2
    //   26: aload 5
    //   28: astore_3
    //   29: aload_1
    //   30: ldc 26
    //   32: iconst_1
    //   33: anewarray 28	java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: ldc 30
    //   40: aastore
    //   41: ldc 32
    //   43: aconst_null
    //   44: aconst_null
    //   45: aconst_null
    //   46: aconst_null
    //   47: invokevirtual 38	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   50: astore 4
    //   52: aload 4
    //   54: ifnull +44 -> 98
    //   57: aload 4
    //   59: astore_2
    //   60: aload 4
    //   62: astore_3
    //   63: aload 4
    //   65: invokeinterface 44 1 0
    //   70: ifeq +28 -> 98
    //   73: aload 4
    //   75: astore_2
    //   76: aload 4
    //   78: astore_3
    //   79: aload 6
    //   81: aload 4
    //   83: iconst_0
    //   84: invokeinterface 48 2 0
    //   89: invokeinterface 54 2 0
    //   94: pop
    //   95: goto -38 -> 57
    //   98: aload 4
    //   100: astore_2
    //   101: aload 4
    //   103: astore_3
    //   104: aload 6
    //   106: invokeinterface 58 1 0
    //   111: ifle +103 -> 214
    //   114: aload 4
    //   116: astore_2
    //   117: aload 4
    //   119: astore_3
    //   120: aload 6
    //   122: invokeinterface 62 1 0
    //   127: astore 5
    //   129: aload 4
    //   131: astore_2
    //   132: aload 4
    //   134: astore_3
    //   135: aload 5
    //   137: invokeinterface 67 1 0
    //   142: ifeq +72 -> 214
    //   145: aload 4
    //   147: astore_2
    //   148: aload 4
    //   150: astore_3
    //   151: aload 5
    //   153: invokeinterface 71 1 0
    //   158: checkcast 28	java/lang/String
    //   161: astore 6
    //   163: aload 4
    //   165: astore_2
    //   166: aload 4
    //   168: astore_3
    //   169: aload_1
    //   170: getstatic 77	java/util/Locale:US	Ljava/util/Locale;
    //   173: ldc 79
    //   175: iconst_1
    //   176: anewarray 81	java/lang/Object
    //   179: dup
    //   180: iconst_0
    //   181: aload 6
    //   183: aastore
    //   184: invokestatic 85	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   187: invokevirtual 89	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   190: aload 4
    //   192: astore_2
    //   193: aload 4
    //   195: astore_3
    //   196: ldc 91
    //   198: iconst_1
    //   199: anewarray 81	java/lang/Object
    //   202: dup
    //   203: iconst_0
    //   204: aload 6
    //   206: aastore
    //   207: invokestatic 97	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   210: pop
    //   211: goto -82 -> 129
    //   214: aload 4
    //   216: ifnull +20 -> 236
    //   219: aload 4
    //   221: invokeinterface 100 1 0
    //   226: ifne +10 -> 236
    //   229: aload 4
    //   231: invokeinterface 103 1 0
    //   236: aload_0
    //   237: monitorexit
    //   238: iconst_1
    //   239: ireturn
    //   240: astore_1
    //   241: goto +42 -> 283
    //   244: astore_1
    //   245: aload_3
    //   246: astore_2
    //   247: aload_1
    //   248: invokestatic 106	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   251: ifne +9 -> 260
    //   254: aload_3
    //   255: astore_2
    //   256: aload_1
    //   257: invokevirtual 109	java/lang/Throwable:printStackTrace	()V
    //   260: aload_3
    //   261: ifnull +18 -> 279
    //   264: aload_3
    //   265: invokeinterface 100 1 0
    //   270: ifne +9 -> 279
    //   273: aload_3
    //   274: invokeinterface 103 1 0
    //   279: aload_0
    //   280: monitorexit
    //   281: iconst_0
    //   282: ireturn
    //   283: aload_2
    //   284: ifnull +18 -> 302
    //   287: aload_2
    //   288: invokeinterface 100 1 0
    //   293: ifne +9 -> 302
    //   296: aload_2
    //   297: invokeinterface 103 1 0
    //   302: aload_1
    //   303: athrow
    //   304: astore_1
    //   305: aload_0
    //   306: monitorexit
    //   307: aload_1
    //   308: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	n
    //   0	309	1	paramSQLiteDatabase	SQLiteDatabase
    //   10	287	2	localObject1	Object
    //   13	261	3	localObject2	Object
    //   6	224	4	localCursor	android.database.Cursor
    //   3	149	5	localIterator	java.util.Iterator
    //   21	184	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   14	23	240	finally
    //   29	52	240	finally
    //   63	73	240	finally
    //   79	95	240	finally
    //   104	114	240	finally
    //   120	129	240	finally
    //   135	145	240	finally
    //   151	163	240	finally
    //   169	190	240	finally
    //   196	211	240	finally
    //   247	254	240	finally
    //   256	260	240	finally
    //   14	23	244	java/lang/Throwable
    //   29	52	244	java/lang/Throwable
    //   63	73	244	java/lang/Throwable
    //   79	95	244	java/lang/Throwable
    //   104	114	244	java/lang/Throwable
    //   120	129	244	java/lang/Throwable
    //   135	145	244	java/lang/Throwable
    //   151	163	244	java/lang/Throwable
    //   169	190	244	java/lang/Throwable
    //   196	211	244	java/lang/Throwable
    //   219	236	304	finally
    //   264	279	304	finally
    //   287	302	304	finally
    //   302	304	304	finally
  }
  
  /* Error */
  public final SQLiteDatabase getReadableDatabase()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_3
    //   4: iconst_0
    //   5: istore_1
    //   6: aload_3
    //   7: astore 4
    //   9: aload 4
    //   11: ifnonnull +104 -> 115
    //   14: iload_1
    //   15: iconst_5
    //   16: if_icmpge +99 -> 115
    //   19: iload_1
    //   20: iconst_1
    //   21: iadd
    //   22: istore_2
    //   23: aload_0
    //   24: invokespecial 115	android/database/sqlite/SQLiteOpenHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   27: astore_3
    //   28: iload_2
    //   29: istore_1
    //   30: goto -24 -> 6
    //   33: astore_3
    //   34: goto +77 -> 111
    //   37: astore 5
    //   39: ldc 117
    //   41: iconst_1
    //   42: anewarray 81	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: iload_2
    //   48: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   51: aastore
    //   52: invokestatic 126	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   55: pop
    //   56: iload_2
    //   57: iconst_5
    //   58: if_icmpne +13 -> 71
    //   61: ldc 128
    //   63: iconst_0
    //   64: anewarray 81	java/lang/Object
    //   67: invokestatic 131	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   70: pop
    //   71: ldc2_w 132
    //   74: invokestatic 139	java/lang/Thread:sleep	(J)V
    //   77: aload 4
    //   79: astore_3
    //   80: iload_2
    //   81: istore_1
    //   82: goto -76 -> 6
    //   85: aload 4
    //   87: astore_3
    //   88: iload_2
    //   89: istore_1
    //   90: aload 5
    //   92: invokestatic 106	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   95: ifne -89 -> 6
    //   98: aload 5
    //   100: invokevirtual 109	java/lang/Throwable:printStackTrace	()V
    //   103: aload 4
    //   105: astore_3
    //   106: iload_2
    //   107: istore_1
    //   108: goto -102 -> 6
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_3
    //   114: athrow
    //   115: aload_0
    //   116: monitorexit
    //   117: aload 4
    //   119: areturn
    //   120: astore_3
    //   121: goto -36 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	n
    //   5	103	1	i	int
    //   22	85	2	j	int
    //   3	25	3	localSQLiteDatabase1	SQLiteDatabase
    //   33	1	3	localObject1	Object
    //   79	35	3	localObject2	Object
    //   120	1	3	localInterruptedException	java.lang.InterruptedException
    //   7	111	4	localSQLiteDatabase2	SQLiteDatabase
    //   37	62	5	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   23	28	33	finally
    //   39	56	33	finally
    //   61	71	33	finally
    //   71	77	33	finally
    //   90	103	33	finally
    //   23	28	37	java/lang/Throwable
    //   71	77	120	java/lang/InterruptedException
  }
  
  /* Error */
  public final SQLiteDatabase getWritableDatabase()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_3
    //   4: iconst_0
    //   5: istore_1
    //   6: aload_3
    //   7: astore 4
    //   9: aload 4
    //   11: ifnonnull +104 -> 115
    //   14: iload_1
    //   15: iconst_5
    //   16: if_icmpge +99 -> 115
    //   19: iload_1
    //   20: iconst_1
    //   21: iadd
    //   22: istore_2
    //   23: aload_0
    //   24: invokespecial 144	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   27: astore_3
    //   28: iload_2
    //   29: istore_1
    //   30: goto -24 -> 6
    //   33: astore_3
    //   34: goto +77 -> 111
    //   37: astore 5
    //   39: ldc 146
    //   41: iconst_1
    //   42: anewarray 81	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: iload_2
    //   48: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   51: aastore
    //   52: invokestatic 126	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   55: pop
    //   56: iload_2
    //   57: iconst_5
    //   58: if_icmpne +13 -> 71
    //   61: ldc 128
    //   63: iconst_0
    //   64: anewarray 81	java/lang/Object
    //   67: invokestatic 131	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   70: pop
    //   71: ldc2_w 132
    //   74: invokestatic 139	java/lang/Thread:sleep	(J)V
    //   77: aload 4
    //   79: astore_3
    //   80: iload_2
    //   81: istore_1
    //   82: goto -76 -> 6
    //   85: aload 4
    //   87: astore_3
    //   88: iload_2
    //   89: istore_1
    //   90: aload 5
    //   92: invokestatic 106	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   95: ifne -89 -> 6
    //   98: aload 5
    //   100: invokevirtual 147	java/lang/Exception:printStackTrace	()V
    //   103: aload 4
    //   105: astore_3
    //   106: iload_2
    //   107: istore_1
    //   108: goto -102 -> 6
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_3
    //   114: athrow
    //   115: aload_0
    //   116: monitorexit
    //   117: aload 4
    //   119: areturn
    //   120: astore_3
    //   121: goto -36 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	n
    //   5	103	1	i	int
    //   22	85	2	j	int
    //   3	25	3	localSQLiteDatabase1	SQLiteDatabase
    //   33	1	3	localObject1	Object
    //   79	35	3	localObject2	Object
    //   120	1	3	localInterruptedException	java.lang.InterruptedException
    //   7	111	4	localSQLiteDatabase2	SQLiteDatabase
    //   37	62	5	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   23	28	33	finally
    //   39	56	33	finally
    //   61	71	33	finally
    //   71	77	33	finally
    //   90	103	33	finally
    //   23	28	37	java/lang/Exception
    //   71	77	120	java/lang/InterruptedException
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramSQLiteDatabase != null) {
      try
      {
        if (m.a != null)
        {
          String[][] arrayOfString = m.a;
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            String[] arrayOfString1 = arrayOfString[i];
            e.b("rqdp{  table:}%s %s", new Object[] { arrayOfString1[0], arrayOfString1[1] });
            paramSQLiteDatabase.execSQL(arrayOfString1[1]);
            i += 1;
          }
        }
      }
      finally {}
    }
  }
  
  @TargetApi(11)
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      d.a(this.a);
      if (Integer.parseInt(d.c()) >= 11)
      {
        e.b("rqdp{  downgrade a db} [%s] rqdp{  from v}%d rqdp{  to} v%d rqdp{  , deleted all tables!}", new Object[] { "eup_db", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (a(paramSQLiteDatabase))
        {
          e.b("rqdp{  drop all success recreate!}", new Object[0]);
          onCreate(paramSQLiteDatabase);
          return;
        }
        e.d("rqdp{  drop all fail try deleted file,may next time will success!}", new Object[0]);
        paramSQLiteDatabase = this.a.getDatabasePath("eup_db");
        if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.canWrite())) {
          paramSQLiteDatabase.delete();
        }
      }
      return;
    }
    finally {}
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      e.b("rqdp{  upgrade a db }[%s]rqdp{   from v}%d rqdp{  to v}%d rqdp{  , deleted all tables!}", new Object[] { "eup_db", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (a(paramSQLiteDatabase))
      {
        e.b("rqdp{  drop all success recreate!}", new Object[0]);
        onCreate(paramSQLiteDatabase);
        return;
      }
      e.d("rqdp{  drop all fail try deleted file,may next time will success!}", new Object[0]);
      paramSQLiteDatabase = this.a.getDatabasePath("eup_db");
      if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.canWrite())) {
        paramSQLiteDatabase.delete();
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.n
 * JD-Core Version:    0.7.0.1
 */