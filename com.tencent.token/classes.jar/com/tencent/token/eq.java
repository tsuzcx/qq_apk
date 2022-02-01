package com.tencent.token;

import android.content.ContentValues;
import android.content.Context;
import com.tencent.token.global.g;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class eq
{
  private static en a;
  private static Context b;
  private static String c = "token";
  
  public static int a(es parames, String paramString)
  {
    try
    {
      a(parames);
      parames = a().query(paramString, new String[] { "count(*)" }, null, null, null, null, null, null);
      if (parames.getCount() > 0)
      {
        parames.moveToFirst();
        i = parames.getInt(0);
        parames.close();
        g.c("test database, tablecount=" + i);
        return i;
      }
    }
    catch (Exception parames)
    {
      g.c("status_kk" + parames.toString() + parames.getMessage());
      return 0;
    }
    catch (Throwable parames)
    {
      for (;;)
      {
        g.c("status_kk" + parames.toString() + parames.getMessage());
        continue;
        int i = 0;
      }
    }
  }
  
  public static int a(es parames, String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      a(parames);
      int i = a().update(paramString1, paramContentValues, paramString2, paramArrayOfString);
      return i;
    }
    catch (Exception parames)
    {
      g.c("status_kk" + parames.toString() + parames.getMessage());
      return 0;
    }
    catch (Throwable parames)
    {
      for (;;)
      {
        g.c("status_kk" + parames.toString() + parames.getMessage());
      }
    }
  }
  
  public static int a(es parames, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      a(parames);
      int i = a().delete(paramString1, paramString2, paramArrayOfString);
      g.c("test database, del=" + i);
      return i;
    }
    catch (Exception parames)
    {
      g.c("status_kk" + parames.toString() + parames.getMessage());
      return 0;
    }
    catch (Throwable parames)
    {
      for (;;)
      {
        g.c("status_kk" + parames.toString() + parames.getMessage());
      }
    }
  }
  
  /* Error */
  public static long a(es parames, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 25	com/tencent/token/eq:a	(Lcom/tencent/token/es;)V
    //   4: invokestatic 28	com/tencent/token/eq:a	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   7: aload_1
    //   8: aload_2
    //   9: aload_3
    //   10: aload 4
    //   12: aload 5
    //   14: aload 6
    //   16: aload 7
    //   18: aload 8
    //   20: invokevirtual 38	com/tencent/wcdb/database/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   23: astore_0
    //   24: lconst_0
    //   25: lstore 10
    //   27: aload_0
    //   28: invokeinterface 44 1 0
    //   33: ifle +24 -> 57
    //   36: iload 9
    //   38: ifeq +51 -> 89
    //   41: aload_0
    //   42: invokeinterface 48 1 0
    //   47: pop
    //   48: aload_0
    //   49: iconst_0
    //   50: invokeinterface 103 2 0
    //   55: lstore 10
    //   57: aload_0
    //   58: invokeinterface 55 1 0
    //   63: new 57	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   70: ldc 105
    //   72: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: lload 10
    //   77: invokevirtual 108	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   80: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 78	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   86: lload 10
    //   88: lreturn
    //   89: aload_0
    //   90: invokeinterface 111 1 0
    //   95: pop
    //   96: aload_0
    //   97: iconst_0
    //   98: invokeinterface 103 2 0
    //   103: lstore 10
    //   105: goto -48 -> 57
    //   108: astore_0
    //   109: new 57	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   116: ldc 80
    //   118: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_0
    //   122: invokevirtual 81	java/lang/Exception:toString	()Ljava/lang/String;
    //   125: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_0
    //   129: invokevirtual 84	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   132: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 78	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   141: lconst_0
    //   142: lreturn
    //   143: astore_0
    //   144: new 57	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   151: ldc 80
    //   153: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_0
    //   157: invokevirtual 85	java/lang/Throwable:toString	()Ljava/lang/String;
    //   160: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_0
    //   164: invokevirtual 86	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   167: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 78	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   176: goto -35 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	parames	es
    //   0	179	1	paramString1	String
    //   0	179	2	paramArrayOfString1	String[]
    //   0	179	3	paramString2	String
    //   0	179	4	paramArrayOfString2	String[]
    //   0	179	5	paramString3	String
    //   0	179	6	paramString4	String
    //   0	179	7	paramString5	String
    //   0	179	8	paramString6	String
    //   0	179	9	paramBoolean	boolean
    //   25	79	10	l	long
    // Exception table:
    //   from	to	target	type
    //   0	24	108	java/lang/Exception
    //   27	36	108	java/lang/Exception
    //   41	57	108	java/lang/Exception
    //   57	86	108	java/lang/Exception
    //   89	105	108	java/lang/Exception
    //   0	24	143	java/lang/Throwable
    //   27	36	143	java/lang/Throwable
    //   41	57	143	java/lang/Throwable
    //   57	86	143	java/lang/Throwable
    //   89	105	143	java/lang/Throwable
  }
  
  public static es a(es parames, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2)
  {
    return b(parames, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, null, null, null, null);
  }
  
  /* Error */
  public static SQLiteDatabase a()
  {
    // Byte code:
    //   0: getstatic 117	com/tencent/token/eq:a	Lcom/tencent/token/en;
    //   3: ifnonnull +181 -> 184
    //   6: getstatic 119	com/tencent/token/eq:b	Landroid/content/Context;
    //   9: ifnonnull +9 -> 18
    //   12: invokestatic 125	com/tencent/token/global/RqdApplication:l	()Landroid/content/Context;
    //   15: putstatic 119	com/tencent/token/eq:b	Landroid/content/Context;
    //   18: getstatic 119	com/tencent/token/eq:b	Landroid/content/Context;
    //   21: ldc 127
    //   23: invokevirtual 133	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   26: astore_0
    //   27: aload_0
    //   28: ifnull +15 -> 43
    //   31: aload_0
    //   32: invokevirtual 138	java/io/File:exists	()Z
    //   35: ifeq +8 -> 43
    //   38: aload_0
    //   39: invokevirtual 140	java/io/File:delete	()Z
    //   42: pop
    //   43: new 142	com/tencent/wcdb/database/SQLiteCipherSpec
    //   46: dup
    //   47: invokespecial 143	com/tencent/wcdb/database/SQLiteCipherSpec:<init>	()V
    //   50: sipush 1024
    //   53: invokevirtual 147	com/tencent/wcdb/database/SQLiteCipherSpec:setPageSize	(I)Lcom/tencent/wcdb/database/SQLiteCipherSpec;
    //   56: iconst_2
    //   57: invokevirtual 150	com/tencent/wcdb/database/SQLiteCipherSpec:setSQLCipherVersion	(I)Lcom/tencent/wcdb/database/SQLiteCipherSpec;
    //   60: ldc 152
    //   62: invokevirtual 156	com/tencent/wcdb/database/SQLiteCipherSpec:setCipher	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteCipherSpec;
    //   65: astore 5
    //   67: getstatic 119	com/tencent/token/eq:b	Landroid/content/Context;
    //   70: ldc 158
    //   72: invokevirtual 133	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   75: astore_1
    //   76: aload_1
    //   77: invokevirtual 138	java/io/File:exists	()Z
    //   80: ifne +199 -> 279
    //   83: getstatic 119	com/tencent/token/eq:b	Landroid/content/Context;
    //   86: ldc 160
    //   88: invokevirtual 133	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   91: astore_0
    //   92: aload_0
    //   93: invokevirtual 138	java/io/File:exists	()Z
    //   96: ifeq +67 -> 163
    //   99: aload_0
    //   100: invokevirtual 163	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   103: aconst_null
    //   104: iconst_1
    //   105: new 165	com/tencent/token/el
    //   108: dup
    //   109: invokespecial 166	com/tencent/token/el:<init>	()V
    //   112: invokestatic 170	com/tencent/wcdb/database/SQLiteDatabase:openDatabase	(Ljava/lang/String;Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;ILcom/tencent/wcdb/DatabaseErrorHandler;)Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   115: astore_0
    //   116: aload_1
    //   117: getstatic 16	com/tencent/token/eq:c	Ljava/lang/String;
    //   120: invokevirtual 174	java/lang/String:getBytes	()[B
    //   123: aload 5
    //   125: aconst_null
    //   126: new 165	com/tencent/token/el
    //   129: dup
    //   130: invokespecial 166	com/tencent/token/el:<init>	()V
    //   133: invokestatic 178	com/tencent/wcdb/database/SQLiteDatabase:openOrCreateDatabase	(Ljava/io/File;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Lcom/tencent/wcdb/DatabaseErrorHandler;)Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   136: astore_1
    //   137: aload_1
    //   138: astore_3
    //   139: aload_0
    //   140: astore_2
    //   141: aload_0
    //   142: aload_1
    //   143: invokestatic 181	com/tencent/token/eq:a	(Lcom/tencent/wcdb/database/SQLiteDatabase;Lcom/tencent/wcdb/database/SQLiteDatabase;)Z
    //   146: pop
    //   147: aload_0
    //   148: ifnull +7 -> 155
    //   151: aload_0
    //   152: invokevirtual 182	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   155: aload_1
    //   156: ifnull +7 -> 163
    //   159: aload_1
    //   160: invokevirtual 182	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   163: new 184	com/tencent/token/en
    //   166: dup
    //   167: getstatic 119	com/tencent/token/eq:b	Landroid/content/Context;
    //   170: getstatic 16	com/tencent/token/eq:c	Ljava/lang/String;
    //   173: invokestatic 188	com/tencent/token/global/c:a	()I
    //   176: aload 5
    //   178: invokespecial 191	com/tencent/token/en:<init>	(Landroid/content/Context;Ljava/lang/String;ILcom/tencent/wcdb/database/SQLiteCipherSpec;)V
    //   181: putstatic 117	com/tencent/token/eq:a	Lcom/tencent/token/en;
    //   184: getstatic 117	com/tencent/token/eq:a	Lcom/tencent/token/en;
    //   187: invokevirtual 194	com/tencent/token/en:getWritableDatabase	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   190: astore_0
    //   191: aload_0
    //   192: areturn
    //   193: astore 4
    //   195: aconst_null
    //   196: astore_1
    //   197: aconst_null
    //   198: astore_0
    //   199: aload_1
    //   200: astore_3
    //   201: aload_0
    //   202: astore_2
    //   203: new 57	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   210: ldc 80
    //   212: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload 4
    //   217: invokevirtual 81	java/lang/Exception:toString	()Ljava/lang/String;
    //   220: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload 4
    //   225: invokevirtual 84	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   228: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 78	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   237: aload_0
    //   238: ifnull +7 -> 245
    //   241: aload_0
    //   242: invokevirtual 182	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   245: aload_1
    //   246: ifnull -83 -> 163
    //   249: aload_1
    //   250: invokevirtual 182	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   253: goto -90 -> 163
    //   256: astore_1
    //   257: aconst_null
    //   258: astore_3
    //   259: aconst_null
    //   260: astore_0
    //   261: aload_0
    //   262: ifnull +7 -> 269
    //   265: aload_0
    //   266: invokevirtual 182	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   269: aload_3
    //   270: ifnull +7 -> 277
    //   273: aload_3
    //   274: invokevirtual 182	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   277: aload_1
    //   278: athrow
    //   279: getstatic 119	com/tencent/token/eq:b	Landroid/content/Context;
    //   282: ldc 160
    //   284: invokevirtual 133	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   287: pop
    //   288: goto -125 -> 163
    //   291: astore_0
    //   292: aload_0
    //   293: invokevirtual 84	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   296: invokestatic 78	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   299: new 57	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   306: ldc 80
    //   308: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload_0
    //   312: invokevirtual 81	java/lang/Exception:toString	()Ljava/lang/String;
    //   315: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_0
    //   319: invokevirtual 84	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   322: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 78	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   331: goto -147 -> 184
    //   334: astore_0
    //   335: aload_0
    //   336: invokevirtual 84	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   339: invokestatic 78	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   342: new 57	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   349: ldc 80
    //   351: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload_0
    //   355: invokevirtual 81	java/lang/Exception:toString	()Ljava/lang/String;
    //   358: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: aload_0
    //   362: invokevirtual 84	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   365: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokestatic 78	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   374: aconst_null
    //   375: areturn
    //   376: astore_0
    //   377: new 57	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   384: ldc 80
    //   386: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload_0
    //   390: invokevirtual 85	java/lang/Throwable:toString	()Ljava/lang/String;
    //   393: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: aload_0
    //   397: invokevirtual 86	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   400: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokestatic 78	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   409: aconst_null
    //   410: areturn
    //   411: astore_1
    //   412: aconst_null
    //   413: astore_3
    //   414: goto -153 -> 261
    //   417: astore_1
    //   418: aload_2
    //   419: astore_0
    //   420: goto -159 -> 261
    //   423: astore 4
    //   425: aconst_null
    //   426: astore_1
    //   427: goto -228 -> 199
    //   430: astore 4
    //   432: goto -233 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   26	240	0	localObject1	Object
    //   291	28	0	localException1	Exception
    //   334	28	0	localException2	Exception
    //   376	21	0	localThrowable	Throwable
    //   419	1	0	localObject2	Object
    //   75	175	1	localObject3	Object
    //   256	22	1	localObject4	Object
    //   411	1	1	localObject5	Object
    //   417	1	1	localObject6	Object
    //   426	1	1	localObject7	Object
    //   140	279	2	localObject8	Object
    //   138	276	3	localObject9	Object
    //   193	31	4	localException3	Exception
    //   423	1	4	localException4	Exception
    //   430	1	4	localException5	Exception
    //   65	112	5	localSQLiteCipherSpec	com.tencent.wcdb.database.SQLiteCipherSpec
    // Exception table:
    //   from	to	target	type
    //   99	116	193	java/lang/Exception
    //   99	116	256	finally
    //   163	184	291	java/lang/Exception
    //   184	191	334	java/lang/Exception
    //   184	191	376	java/lang/Throwable
    //   116	137	411	finally
    //   141	147	417	finally
    //   203	237	417	finally
    //   116	137	423	java/lang/Exception
    //   141	147	430	java/lang/Exception
  }
  
  public static List<es> a(es parames, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      a(parames);
      paramString1 = a().query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
      if (paramString1.getCount() > 0)
      {
        paramString1.moveToFirst();
        do
        {
          localArrayList.add(parames.a(paramString1));
        } while (paramString1.moveToNext());
      }
      paramString1.close();
      return localArrayList;
    }
    catch (Exception parames)
    {
      g.c("status_kk" + parames.toString() + parames.getMessage());
      return localArrayList;
    }
    catch (Throwable parames)
    {
      g.c("status_kk" + parames.toString() + parames.getMessage());
    }
    return localArrayList;
  }
  
  public static void a(Context paramContext)
  {
    b = paramContext;
  }
  
  public static void a(es parames)
  {
    try
    {
      parames.a(a());
      return;
    }
    catch (Exception parames)
    {
      g.c("status_kk" + parames.toString() + parames.getMessage());
      return;
    }
    catch (Throwable parames)
    {
      g.c("status_kk" + parames.toString() + parames.getMessage());
    }
  }
  
  public static void a(String paramString)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = a();
      localSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + paramString);
      localSQLiteDatabase.close();
      return;
    }
    catch (Exception paramString)
    {
      g.c("status_kk" + paramString.toString() + paramString.getMessage());
      return;
    }
    catch (Throwable paramString)
    {
      g.c("status_kk" + paramString.toString() + paramString.getMessage());
    }
  }
  
  private static boolean a(SQLiteDatabase paramSQLiteDatabase1, SQLiteDatabase paramSQLiteDatabase2)
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("sqlite_sequence");
    StringBuilder localStringBuilder = new StringBuilder("select DISTINCT  tbl_name from sqlite_master");
    com.tencent.wcdb.Cursor localCursor1 = paramSQLiteDatabase1.rawQuery(localStringBuilder.toString(), null);
    if (localCursor1 != null)
    {
      int i = localCursor1.getCount();
      while (localCursor1.moveToNext())
      {
        int j = i - 1;
        Object localObject1 = localCursor1.getString(0);
        localStringBuilder.setLength(0);
        localStringBuilder.append("select sql from sqlite_master where tbl_name = '").append((String)localObject1).append("'");
        com.tencent.wcdb.Cursor localCursor2 = paramSQLiteDatabase1.rawQuery(localStringBuilder.toString(), null);
        i = j;
        if (localCursor2 != null)
        {
          if (localCursor2.moveToNext())
          {
            if (localHashSet.contains(localObject1))
            {
              localCursor2.close();
              i = j;
              continue;
            }
            paramSQLiteDatabase2.execSQL(localCursor2.getString(0));
            com.tencent.wcdb.Cursor localCursor3 = paramSQLiteDatabase1.rawQuery("select * from " + (String)localObject1, null);
            if ((localCursor3 != null) && (localCursor3.getCount() > 0))
            {
              localStringBuilder.setLength(0);
              localStringBuilder.append("insert into ").append((String)localObject1).append("(");
              if (localCursor3.getColumnCount() > 0)
              {
                localObject1 = new StringBuilder(" values(");
                localObject2 = localCursor3.getColumnNames();
                k = localObject2.length;
                i = 0;
                while (i < k)
                {
                  localStringBuilder.append(localObject2[i]).append(",");
                  ((StringBuilder)localObject1).append("?,");
                  i += 1;
                }
                ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
                localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
                localStringBuilder.append(")").append((CharSequence)localObject1).append(")");
              }
              localObject1 = paramSQLiteDatabase2.compileStatement(localStringBuilder.toString());
              paramSQLiteDatabase2.beginTransaction();
              int k = localCursor3.getColumnCount();
              Object localObject2 = new int[k];
              localCursor3.moveToFirst();
              i = 0;
              while (i < k)
              {
                localObject2[i] = localCursor3.getType(i);
                i += 1;
              }
              do
              {
                i = 0;
                if (i < k)
                {
                  switch (localObject2[i])
                  {
                  }
                  for (;;)
                  {
                    i += 1;
                    break;
                    Object localObject3 = localCursor3.getString(i);
                    if (localObject3 != null)
                    {
                      ((SQLiteStatement)localObject1).bindString(i + 1, (String)localObject3);
                    }
                    else
                    {
                      ((SQLiteStatement)localObject1).bindNull(i + 1);
                      continue;
                      ((SQLiteStatement)localObject1).bindLong(i + 1, localCursor3.getLong(i));
                      continue;
                      localObject3 = localCursor3.getBlob(i);
                      if (localObject3 != null)
                      {
                        ((SQLiteStatement)localObject1).bindBlob(i + 1, (byte[])localObject3);
                      }
                      else
                      {
                        ((SQLiteStatement)localObject1).bindNull(i + 1);
                        continue;
                        ((SQLiteStatement)localObject1).bindDouble(i + 1, localCursor3.getDouble(i));
                        continue;
                        ((SQLiteStatement)localObject1).bindNull(i + 1);
                      }
                    }
                  }
                }
                ((SQLiteStatement)localObject1).executeInsert();
              } while (localCursor3.moveToNext());
              paramSQLiteDatabase2.setTransactionSuccessful();
              paramSQLiteDatabase2.endTransaction();
              localCursor3.close();
            }
          }
          localCursor2.close();
          i = j;
        }
      }
      localCursor1.close();
      if (i == 0) {
        return true;
      }
    }
    return false;
  }
  
  public static long b(es parames)
  {
    try
    {
      a(parames);
      long l = parames.b(a());
      return l;
    }
    catch (Exception parames)
    {
      g.c("status_kk" + parames.toString() + parames.getMessage());
      return 0L;
    }
    catch (Throwable parames)
    {
      for (;;)
      {
        g.c("status_kk" + parames.toString() + parames.getMessage());
      }
    }
  }
  
  public static es b(es parames, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    parames = a(parames, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
    if ((parames != null) && (parames.size() > 0)) {
      return (es)parames.get(0);
    }
    return null;
  }
  
  public static void b()
  {
    if (a != null) {}
    try
    {
      a.close();
      a = null;
      return;
    }
    catch (Exception localException)
    {
      g.c("status_kk" + localException.toString() + localException.getMessage());
      return;
    }
    catch (Throwable localThrowable)
    {
      g.c("status_kk" + localThrowable.toString() + localThrowable.getMessage());
    }
  }
  
  public static long c(es parames)
  {
    try
    {
      a(parames);
      long l = a().replace(parames.b(), null, parames.c());
      return l;
    }
    catch (Exception parames)
    {
      g.c("status_kk" + parames.toString() + parames.getMessage());
      return 0L;
    }
    catch (Throwable parames)
    {
      for (;;)
      {
        g.c("status_kk" + parames.toString() + parames.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.eq
 * JD-Core Version:    0.7.0.1
 */