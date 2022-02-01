package com.tencent.token;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class nt
  extends SQLiteOpenHelper
  implements ns
{
  private static String a = "";
  private static nt b;
  
  private nt(Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 7);
    try
    {
      paramContext.deleteDatabase("access.db");
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static nt a()
  {
    if (b == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(lv.b());
      localStringBuilder.append("-access.db");
      a = localStringBuilder.toString();
      b = new nt(lv.a(), a);
    }
    return b;
  }
  
  private static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS access_tbl");
      return;
    }
    catch (SQLException paramSQLiteDatabase) {}
  }
  
  /* Error */
  private boolean a(String paramString, nq.a parama, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore 6
    //   5: aload_0
    //   6: invokevirtual 79	com/tencent/token/nt:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore 7
    //   11: aload 7
    //   13: invokevirtual 83	android/database/sqlite/SQLiteDatabase:isDbLockedByOtherThreads	()Z
    //   16: ifne +322 -> 338
    //   19: aload 7
    //   21: invokevirtual 86	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   24: ifeq +6 -> 30
    //   27: goto +311 -> 338
    //   30: new 88	android/content/ContentValues
    //   33: dup
    //   34: invokespecial 89	android/content/ContentValues:<init>	()V
    //   37: astore 8
    //   39: aload 8
    //   41: ldc 91
    //   43: aload_2
    //   44: invokevirtual 95	com/tencent/token/nq$a:a	()Ljava/lang/String;
    //   47: invokevirtual 99	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload 8
    //   52: ldc 101
    //   54: aload_2
    //   55: getfield 105	com/tencent/token/nq$a:d	J
    //   58: invokestatic 111	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   61: invokevirtual 114	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   64: aload 8
    //   66: ldc 116
    //   68: lload_3
    //   69: invokestatic 111	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   72: invokevirtual 114	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   75: aload 8
    //   77: ldc 118
    //   79: aload_2
    //   80: getfield 120	com/tencent/token/nq$a:b	Ljava/lang/String;
    //   83: invokevirtual 99	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aload 7
    //   88: ldc 122
    //   90: aload 8
    //   92: ldc 124
    //   94: iconst_2
    //   95: anewarray 126	java/lang/String
    //   98: dup
    //   99: iconst_0
    //   100: aload_1
    //   101: aastore
    //   102: dup
    //   103: iconst_1
    //   104: aload_2
    //   105: getfield 127	com/tencent/token/nq$a:a	Ljava/lang/String;
    //   108: aastore
    //   109: invokevirtual 131	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   112: istore 5
    //   114: iload 5
    //   116: ifne +137 -> 253
    //   119: aload 8
    //   121: ldc 133
    //   123: aload_1
    //   124: invokevirtual 99	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload 8
    //   129: ldc 135
    //   131: aload_2
    //   132: getfield 127	com/tencent/token/nq$a:a	Ljava/lang/String;
    //   135: invokevirtual 99	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: aload 8
    //   140: ldc 118
    //   142: aload_2
    //   143: getfield 120	com/tencent/token/nq$a:b	Ljava/lang/String;
    //   146: invokevirtual 99	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: aload 7
    //   151: ldc 122
    //   153: aconst_null
    //   154: aload 8
    //   156: invokevirtual 139	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   159: lstore_3
    //   160: new 38	java/lang/StringBuilder
    //   163: dup
    //   164: ldc 141
    //   166: invokespecial 143	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   169: astore 7
    //   171: aload 7
    //   173: lload_3
    //   174: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 7
    //   180: ldc 148
    //   182: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 7
    //   188: aload_1
    //   189: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 7
    //   195: ldc 150
    //   197: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 7
    //   203: aload_2
    //   204: getfield 127	com/tencent/token/nq$a:a	Ljava/lang/String;
    //   207: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 7
    //   213: ldc 152
    //   215: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload 7
    //   221: aload_2
    //   222: invokevirtual 95	com/tencent/token/nq$a:a	()Ljava/lang/String;
    //   225: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: ldc 154
    //   231: aload 7
    //   233: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 158	com/tencent/token/lo:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: ldc2_w 159
    //   242: lload_3
    //   243: lcmp
    //   244: ifeq +89 -> 333
    //   247: iconst_1
    //   248: istore 6
    //   250: goto +83 -> 333
    //   253: new 38	java/lang/StringBuilder
    //   256: dup
    //   257: ldc 162
    //   259: invokespecial 143	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   262: astore 7
    //   264: aload 7
    //   266: iload 5
    //   268: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload 7
    //   274: ldc 148
    //   276: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload 7
    //   282: aload_1
    //   283: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload 7
    //   289: ldc 150
    //   291: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload 7
    //   297: aload_2
    //   298: getfield 127	com/tencent/token/nq$a:a	Ljava/lang/String;
    //   301: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload 7
    //   307: ldc 152
    //   309: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload 7
    //   315: aload_2
    //   316: invokevirtual 95	com/tencent/token/nq$a:a	()Ljava/lang/String;
    //   319: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: ldc 154
    //   325: aload 7
    //   327: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 158	com/tencent/token/lo:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   333: aload_0
    //   334: monitorexit
    //   335: iload 6
    //   337: ireturn
    //   338: ldc2_w 166
    //   341: invokestatic 173	java/lang/Thread:sleep	(J)V
    //   344: goto -333 -> 11
    //   347: astore 8
    //   349: aload 8
    //   351: invokevirtual 174	java/lang/InterruptedException:printStackTrace	()V
    //   354: goto -343 -> 11
    //   357: astore_1
    //   358: aload_0
    //   359: monitorexit
    //   360: aload_1
    //   361: athrow
    //   362: aload_0
    //   363: monitorexit
    //   364: iconst_0
    //   365: ireturn
    //   366: astore_1
    //   367: goto -5 -> 362
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	this	nt
    //   0	370	1	paramString	String
    //   0	370	2	parama	nq.a
    //   0	370	3	paramLong	long
    //   112	155	5	i	int
    //   3	333	6	bool	boolean
    //   9	317	7	localObject	java.lang.Object
    //   37	118	8	localContentValues	android.content.ContentValues
    //   347	3	8	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   338	344	347	java/lang/InterruptedException
    //   5	11	357	finally
    //   11	27	357	finally
    //   30	114	357	finally
    //   119	239	357	finally
    //   253	333	357	finally
    //   338	344	357	finally
    //   349	354	357	finally
    //   5	11	366	java/lang/Exception
    //   11	27	366	java/lang/Exception
    //   30	114	366	java/lang/Exception
    //   119	239	366	java/lang/Exception
    //   253	333	366	java/lang/Exception
    //   338	344	366	java/lang/Exception
    //   349	354	366	java/lang/Exception
  }
  
  private static void b(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS access_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,domain TEXT,rule TEXT,iplist TEXT,last_suc_ip TEXT,apn_lasttime INTEGER,schedule_lasttime INTEGER);");
      lo.b("DataAccessDBImpl", "db created.");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      throw paramSQLiteDatabase;
    }
  }
  
  /* Error */
  public final nq a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 182	com/tencent/token/nt:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore 5
    //   8: aload 5
    //   10: invokevirtual 83	android/database/sqlite/SQLiteDatabase:isDbLockedByOtherThreads	()Z
    //   13: ifne +251 -> 264
    //   16: aload 5
    //   18: invokevirtual 86	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   21: istore_2
    //   22: iload_2
    //   23: ifeq +6 -> 29
    //   26: goto +238 -> 264
    //   29: aload 5
    //   31: ldc 122
    //   33: aconst_null
    //   34: ldc 184
    //   36: iconst_1
    //   37: anewarray 126	java/lang/String
    //   40: dup
    //   41: iconst_0
    //   42: aload_1
    //   43: aastore
    //   44: aconst_null
    //   45: aconst_null
    //   46: aconst_null
    //   47: invokevirtual 188	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   50: astore 5
    //   52: aload 5
    //   54: ifnull +175 -> 229
    //   57: aload 5
    //   59: invokeinterface 193 1 0
    //   64: ifeq +165 -> 229
    //   67: new 195	com/tencent/token/nq
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 196	com/tencent/token/nq:<init>	(Ljava/lang/String;)V
    //   75: astore_1
    //   76: aload 5
    //   78: aload 5
    //   80: ldc 135
    //   82: invokeinterface 200 2 0
    //   87: invokeinterface 204 2 0
    //   92: astore 6
    //   94: aload 5
    //   96: aload 5
    //   98: ldc 91
    //   100: invokeinterface 200 2 0
    //   105: invokeinterface 204 2 0
    //   110: astore 7
    //   112: aload 5
    //   114: aload 5
    //   116: ldc 206
    //   118: invokeinterface 200 2 0
    //   123: invokeinterface 204 2 0
    //   128: astore 8
    //   130: aload 5
    //   132: aload 5
    //   134: ldc 118
    //   136: invokeinterface 200 2 0
    //   141: invokeinterface 204 2 0
    //   146: astore 9
    //   148: aload 5
    //   150: aload 5
    //   152: ldc 101
    //   154: invokeinterface 200 2 0
    //   159: invokeinterface 210 2 0
    //   164: lstore_3
    //   165: aload 5
    //   167: aload 5
    //   169: ldc 116
    //   171: invokeinterface 200 2 0
    //   176: invokeinterface 210 2 0
    //   181: pop2
    //   182: aload_1
    //   183: new 93	com/tencent/token/nq$a
    //   186: dup
    //   187: aload 6
    //   189: lload_3
    //   190: aload 7
    //   192: aload 9
    //   194: aload 8
    //   196: invokespecial 213	com/tencent/token/nq$a:<init>	(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   199: invokevirtual 216	com/tencent/token/nq:a	(Lcom/tencent/token/nq$a;)V
    //   202: aload 5
    //   204: invokeinterface 219 1 0
    //   209: istore_2
    //   210: iload_2
    //   211: ifne -135 -> 76
    //   214: goto +17 -> 231
    //   217: astore 6
    //   219: aload 5
    //   221: astore_1
    //   222: aload 6
    //   224: astore 5
    //   226: goto +25 -> 251
    //   229: aconst_null
    //   230: astore_1
    //   231: aload 5
    //   233: ifnull +10 -> 243
    //   236: aload 5
    //   238: invokeinterface 222 1 0
    //   243: aload_0
    //   244: monitorexit
    //   245: aload_1
    //   246: areturn
    //   247: astore 5
    //   249: aconst_null
    //   250: astore_1
    //   251: aload_1
    //   252: ifnull +9 -> 261
    //   255: aload_1
    //   256: invokeinterface 222 1 0
    //   261: aload 5
    //   263: athrow
    //   264: ldc2_w 166
    //   267: invokestatic 173	java/lang/Thread:sleep	(J)V
    //   270: goto -262 -> 8
    //   273: astore 6
    //   275: aload 6
    //   277: invokevirtual 174	java/lang/InterruptedException:printStackTrace	()V
    //   280: goto -272 -> 8
    //   283: astore_1
    //   284: aload_0
    //   285: monitorexit
    //   286: aload_1
    //   287: athrow
    //   288: aload_0
    //   289: monitorexit
    //   290: aconst_null
    //   291: areturn
    //   292: astore_1
    //   293: goto -5 -> 288
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	this	nt
    //   0	296	1	paramString	String
    //   21	190	2	bool	boolean
    //   164	26	3	l	long
    //   6	231	5	localObject1	java.lang.Object
    //   247	15	5	localObject2	java.lang.Object
    //   92	96	6	str1	String
    //   217	6	6	localObject3	java.lang.Object
    //   273	3	6	localInterruptedException	java.lang.InterruptedException
    //   110	81	7	str2	String
    //   128	67	8	str3	String
    //   146	47	9	str4	String
    // Exception table:
    //   from	to	target	type
    //   57	76	217	finally
    //   76	210	217	finally
    //   29	52	247	finally
    //   264	270	273	java/lang/InterruptedException
    //   2	8	283	finally
    //   8	22	283	finally
    //   236	243	283	finally
    //   255	261	283	finally
    //   261	264	283	finally
    //   264	270	283	finally
    //   275	280	283	finally
    //   2	8	292	java/lang/Exception
    //   8	22	292	java/lang/Exception
    //   236	243	292	java/lang/Exception
    //   255	261	292	java/lang/Exception
    //   261	264	292	java/lang/Exception
    //   264	270	292	java/lang/Exception
    //   275	280	292	java/lang/Exception
  }
  
  /* Error */
  public final void a(nq paramnq)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_1
    //   10: getfield 226	com/tencent/token/nq:b	Ljava/util/Map;
    //   13: astore 6
    //   15: invokestatic 232	java/lang/System:currentTimeMillis	()J
    //   18: lstore_3
    //   19: aload 6
    //   21: invokeinterface 238 1 0
    //   26: invokeinterface 244 1 0
    //   31: astore 6
    //   33: iconst_0
    //   34: istore_2
    //   35: aload 6
    //   37: invokeinterface 249 1 0
    //   42: ifeq +38 -> 80
    //   45: aload 6
    //   47: invokeinterface 253 1 0
    //   52: checkcast 93	com/tencent/token/nq$a
    //   55: astore 7
    //   57: aload_0
    //   58: aload_1
    //   59: getfield 254	com/tencent/token/nq:a	Ljava/lang/String;
    //   62: aload 7
    //   64: lload_3
    //   65: invokespecial 256	com/tencent/token/nt:a	(Ljava/lang/String;Lcom/tencent/token/nq$a;J)Z
    //   68: istore 5
    //   70: iload 5
    //   72: ifeq -37 -> 35
    //   75: iconst_1
    //   76: istore_2
    //   77: goto -42 -> 35
    //   80: iload_2
    //   81: ifeq +284 -> 365
    //   84: ldc 154
    //   86: ldc_w 258
    //   89: invokestatic 261	com/tencent/token/lo:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload_0
    //   93: invokevirtual 79	com/tencent/token/nt:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   96: astore 8
    //   98: aload 8
    //   100: invokevirtual 83	android/database/sqlite/SQLiteDatabase:isDbLockedByOtherThreads	()Z
    //   103: ifne +245 -> 348
    //   106: aload 8
    //   108: invokevirtual 86	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   111: istore 5
    //   113: iload 5
    //   115: ifeq +6 -> 121
    //   118: goto +230 -> 348
    //   121: aconst_null
    //   122: astore_1
    //   123: aload 8
    //   125: ldc 122
    //   127: iconst_1
    //   128: anewarray 126	java/lang/String
    //   131: dup
    //   132: iconst_0
    //   133: ldc 133
    //   135: aastore
    //   136: aconst_null
    //   137: aconst_null
    //   138: ldc 133
    //   140: aconst_null
    //   141: ldc 116
    //   143: invokevirtual 188	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   146: astore 6
    //   148: aload 6
    //   150: ifnull +95 -> 245
    //   153: aload 6
    //   155: astore_1
    //   156: aload 6
    //   158: invokeinterface 265 1 0
    //   163: invokestatic 270	com/tencent/token/nu:a	()Lcom/tencent/token/nu;
    //   166: getfield 273	com/tencent/token/nu:b	Lcom/tencent/token/nx;
    //   169: getfield 278	com/tencent/token/nx:c	I
    //   172: if_icmple +73 -> 245
    //   175: aload 6
    //   177: astore_1
    //   178: aload 6
    //   180: invokeinterface 193 1 0
    //   185: ifeq +60 -> 245
    //   188: aload 6
    //   190: astore_1
    //   191: aload 6
    //   193: aload 6
    //   195: ldc 133
    //   197: invokeinterface 200 2 0
    //   202: invokeinterface 204 2 0
    //   207: astore 7
    //   209: aload 6
    //   211: astore_1
    //   212: aload 7
    //   214: invokestatic 284	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   217: ifne +28 -> 245
    //   220: aload 6
    //   222: astore_1
    //   223: ldc 154
    //   225: ldc_w 286
    //   228: aload 7
    //   230: invokestatic 289	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   233: invokevirtual 293	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   236: invokestatic 261	com/tencent/token/lo:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: aload 7
    //   241: astore_1
    //   242: goto +6 -> 248
    //   245: ldc 10
    //   247: astore_1
    //   248: aload 6
    //   250: ifnull +10 -> 260
    //   253: aload 6
    //   255: invokeinterface 222 1 0
    //   260: aload_1
    //   261: invokestatic 284	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   264: ifne +66 -> 330
    //   267: aload 8
    //   269: ldc 122
    //   271: ldc 184
    //   273: iconst_1
    //   274: anewarray 126	java/lang/String
    //   277: dup
    //   278: iconst_0
    //   279: aload_1
    //   280: aastore
    //   281: invokevirtual 297	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   284: istore_2
    //   285: new 38	java/lang/StringBuilder
    //   288: dup
    //   289: ldc_w 299
    //   292: invokespecial 143	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   295: astore 6
    //   297: aload 6
    //   299: aload_1
    //   300: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload 6
    //   306: ldc_w 301
    //   309: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload 6
    //   315: iload_2
    //   316: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: ldc 154
    //   322: aload 6
    //   324: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokestatic 261	com/tencent/token/lo:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   330: aload_0
    //   331: monitorexit
    //   332: return
    //   333: astore 6
    //   335: aload_1
    //   336: ifnull +9 -> 345
    //   339: aload_1
    //   340: invokeinterface 222 1 0
    //   345: aload 6
    //   347: athrow
    //   348: ldc2_w 166
    //   351: invokestatic 173	java/lang/Thread:sleep	(J)V
    //   354: goto -256 -> 98
    //   357: astore_1
    //   358: aload_1
    //   359: invokevirtual 174	java/lang/InterruptedException:printStackTrace	()V
    //   362: goto -264 -> 98
    //   365: aload_0
    //   366: monitorexit
    //   367: return
    //   368: astore_1
    //   369: aload_0
    //   370: monitorexit
    //   371: aload_1
    //   372: athrow
    //   373: aload_0
    //   374: monitorexit
    //   375: return
    //   376: astore_1
    //   377: goto -4 -> 373
    //   380: astore_1
    //   381: goto -16 -> 365
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	384	0	this	nt
    //   0	384	1	paramnq	nq
    //   34	282	2	i	int
    //   18	47	3	l	long
    //   68	46	5	bool	boolean
    //   13	310	6	localObject1	java.lang.Object
    //   333	13	6	localObject2	java.lang.Object
    //   55	185	7	localObject3	java.lang.Object
    //   96	172	8	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   123	148	333	finally
    //   156	175	333	finally
    //   178	188	333	finally
    //   191	209	333	finally
    //   212	220	333	finally
    //   223	239	333	finally
    //   348	354	357	java/lang/InterruptedException
    //   9	33	368	finally
    //   35	70	368	finally
    //   84	98	368	finally
    //   98	113	368	finally
    //   253	260	368	finally
    //   260	330	368	finally
    //   339	345	368	finally
    //   345	348	368	finally
    //   348	354	368	finally
    //   358	362	368	finally
    //   9	33	376	java/lang/Exception
    //   35	70	376	java/lang/Exception
    //   84	98	380	java/lang/Exception
    //   98	113	380	java/lang/Exception
    //   253	260	380	java/lang/Exception
    //   260	330	380	java/lang/Exception
    //   339	345	380	java/lang/Exception
    //   345	348	380	java/lang/Exception
    //   348	354	380	java/lang/Exception
    //   358	362	380	java/lang/Exception
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS access_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,domain TEXT,rule TEXT,iplist TEXT,last_suc_ip TEXT,apn_lasttime INTEGER,schedule_lasttime INTEGER);");
      lo.b("DataAccessDBImpl", "db created.");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
      lo.a("DataAccessDBImpl", "db create failed.", paramSQLiteDatabase);
    }
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS access_tbl");
      try
      {
        label6:
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS access_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,domain TEXT,rule TEXT,iplist TEXT,last_suc_ip TEXT,apn_lasttime INTEGER,schedule_lasttime INTEGER);");
        lo.b("DataAccessDBImpl", "db created.");
        return;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        throw paramSQLiteDatabase;
      }
    }
    catch (SQLException localSQLException)
    {
      break label6;
    }
    catch (Exception paramSQLiteDatabase) {}
  }
  
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onOpen(paramSQLiteDatabase);
    try
    {
      i = paramSQLiteDatabase.getVersion();
      if (i != 0) {
        if (i >= 7) {}
      }
    }
    catch (Exception paramSQLiteDatabase)
    {
      int i;
      return;
    }
    try
    {
      a(paramSQLiteDatabase);
      b(paramSQLiteDatabase);
      return;
    }
    catch (Exception paramSQLiteDatabase) {}
    if (i > 7)
    {
      a(paramSQLiteDatabase);
      b(paramSQLiteDatabase);
    }
    return;
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS access_tbl");
      try
      {
        label6:
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS access_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,domain TEXT,rule TEXT,iplist TEXT,last_suc_ip TEXT,apn_lasttime INTEGER,schedule_lasttime INTEGER);");
        lo.b("DataAccessDBImpl", "db created.");
        return;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        throw paramSQLiteDatabase;
      }
    }
    catch (SQLException localSQLException)
    {
      break label6;
    }
    catch (Exception paramSQLiteDatabase) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.nt
 * JD-Core Version:    0.7.0.1
 */