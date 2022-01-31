package com.tencent.mobileqq.msf.core.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.l;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.utils.MonitorSocketStat;
import com.tencent.mobileqq.msf.sdk.utils.a;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class c
  extends BroadcastReceiver
{
  public static final String a = "MSF.C.MonitorNetFlowStore";
  static final String d = "SQQzoneSvcDev";
  public static final String e = "MONITOR_NetflowRdmReport";
  public static final String f = "MONITOR_NetflowRdmReportwithStatus";
  public static final String g = "MONITOR_NetflowRdmReport_TIME";
  public static final int h = 1;
  static SimpleDateFormat i = new SimpleDateFormat("dd HH:mm:ss");
  static final String j = "dataflow";
  private static Context l;
  private static b p;
  private static SQLiteDatabase q;
  public ConcurrentHashMap b = new ConcurrentHashMap();
  public ConcurrentHashMap c = new ConcurrentHashMap();
  private MsfCore k;
  private AlarmManager m;
  private String n = "";
  private PendingIntent o;
  
  public c(MsfCore paramMsfCore, Context paramContext)
  {
    this.k = paramMsfCore;
    l = paramContext;
  }
  
  /* Error */
  public static com.tencent.mobileqq.msf.sdk.n.a a(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc 8
    //   2: iconst_1
    //   3: ldc 80
    //   5: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8: getstatic 87	com/tencent/mobileqq/msf/core/b/c:p	Lcom/tencent/mobileqq/msf/core/b/b;
    //   11: ifnonnull +16 -> 27
    //   14: new 89	com/tencent/mobileqq/msf/core/b/b
    //   17: dup
    //   18: getstatic 75	com/tencent/mobileqq/msf/core/b/c:l	Landroid/content/Context;
    //   21: invokespecial 92	com/tencent/mobileqq/msf/core/b/b:<init>	(Landroid/content/Context;)V
    //   24: putstatic 87	com/tencent/mobileqq/msf/core/b/c:p	Lcom/tencent/mobileqq/msf/core/b/b;
    //   27: getstatic 94	com/tencent/mobileqq/msf/core/b/c:q	Landroid/database/sqlite/SQLiteDatabase;
    //   30: ifnonnull +12 -> 42
    //   33: getstatic 87	com/tencent/mobileqq/msf/core/b/c:p	Lcom/tencent/mobileqq/msf/core/b/b;
    //   36: invokevirtual 98	com/tencent/mobileqq/msf/core/b/b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   39: putstatic 94	com/tencent/mobileqq/msf/core/b/c:q	Landroid/database/sqlite/SQLiteDatabase;
    //   42: getstatic 94	com/tencent/mobileqq/msf/core/b/c:q	Landroid/database/sqlite/SQLiteDatabase;
    //   45: ldc 28
    //   47: bipush 7
    //   49: anewarray 100	java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: ldc 102
    //   56: aastore
    //   57: dup
    //   58: iconst_1
    //   59: ldc 104
    //   61: aastore
    //   62: dup
    //   63: iconst_2
    //   64: ldc 106
    //   66: aastore
    //   67: dup
    //   68: iconst_3
    //   69: ldc 108
    //   71: aastore
    //   72: dup
    //   73: iconst_4
    //   74: ldc 110
    //   76: aastore
    //   77: dup
    //   78: iconst_5
    //   79: ldc 112
    //   81: aastore
    //   82: dup
    //   83: bipush 6
    //   85: ldc 114
    //   87: aastore
    //   88: ldc 116
    //   90: iconst_2
    //   91: anewarray 100	java/lang/String
    //   94: dup
    //   95: iconst_0
    //   96: lload_0
    //   97: invokestatic 120	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   100: aastore
    //   101: dup
    //   102: iconst_1
    //   103: lload_2
    //   104: invokestatic 120	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   107: aastore
    //   108: aconst_null
    //   109: aconst_null
    //   110: aconst_null
    //   111: invokevirtual 126	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   114: astore 7
    //   116: aload 7
    //   118: ifnonnull +21 -> 139
    //   121: aload 7
    //   123: ifnull +10 -> 133
    //   126: aload 7
    //   128: invokeinterface 131 1 0
    //   133: aconst_null
    //   134: astore 6
    //   136: aload 6
    //   138: areturn
    //   139: aload 7
    //   141: astore 6
    //   143: new 133	java/io/File
    //   146: dup
    //   147: invokestatic 138	com/tencent/mobileqq/msf/sdk/n:b	()Ljava/lang/String;
    //   150: invokespecial 139	java/io/File:<init>	(Ljava/lang/String;)V
    //   153: astore 8
    //   155: aload 7
    //   157: astore 6
    //   159: aload 8
    //   161: invokevirtual 143	java/io/File:exists	()Z
    //   164: istore 5
    //   166: iload 5
    //   168: istore 4
    //   170: iload 5
    //   172: ifne +14 -> 186
    //   175: aload 7
    //   177: astore 6
    //   179: aload 8
    //   181: invokevirtual 146	java/io/File:mkdirs	()Z
    //   184: istore 4
    //   186: iload 4
    //   188: ifne +17 -> 205
    //   191: aload 7
    //   193: ifnull +10 -> 203
    //   196: aload 7
    //   198: invokeinterface 131 1 0
    //   203: aconst_null
    //   204: areturn
    //   205: aload 7
    //   207: astore 6
    //   209: new 148	com/tencent/mobileqq/msf/sdk/n$a
    //   212: dup
    //   213: aload 8
    //   215: ldc 150
    //   217: invokespecial 153	com/tencent/mobileqq/msf/sdk/n$a:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   220: astore 8
    //   222: aload 7
    //   224: astore 6
    //   226: new 155	java/io/BufferedWriter
    //   229: dup
    //   230: new 157	java/io/OutputStreamWriter
    //   233: dup
    //   234: new 159	java/io/FileOutputStream
    //   237: dup
    //   238: aload 8
    //   240: invokespecial 162	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   243: invokespecial 165	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   246: invokespecial 168	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   249: astore 9
    //   251: aload 7
    //   253: astore 6
    //   255: aload 7
    //   257: invokeinterface 171 1 0
    //   262: pop
    //   263: aload 7
    //   265: astore 6
    //   267: aload 7
    //   269: invokeinterface 174 1 0
    //   274: ifne +210 -> 484
    //   277: aload 7
    //   279: astore 6
    //   281: aload 9
    //   283: new 176	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   290: aload 7
    //   292: iconst_0
    //   293: invokeinterface 181 2 0
    //   298: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: ldc 187
    //   303: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload 7
    //   308: iconst_1
    //   309: invokeinterface 181 2 0
    //   314: invokestatic 193	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   317: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: ldc 187
    //   322: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload 7
    //   327: iconst_2
    //   328: invokeinterface 197 2 0
    //   333: invokevirtual 200	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   336: ldc 187
    //   338: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload 7
    //   343: iconst_3
    //   344: invokeinterface 204 2 0
    //   349: invokevirtual 207	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   352: ldc 187
    //   354: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: aload 7
    //   359: iconst_4
    //   360: invokeinterface 181 2 0
    //   365: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: ldc 187
    //   370: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload 7
    //   375: iconst_5
    //   376: invokeinterface 204 2 0
    //   381: invokevirtual 207	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   384: ldc 187
    //   386: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: getstatic 56	com/tencent/mobileqq/msf/core/b/c:i	Ljava/text/SimpleDateFormat;
    //   392: aload 7
    //   394: bipush 6
    //   396: invokeinterface 197 2 0
    //   401: invokestatic 212	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   404: invokevirtual 216	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   407: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: ldc 218
    //   412: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokevirtual 224	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   421: aload 7
    //   423: astore 6
    //   425: aload 7
    //   427: invokeinterface 227 1 0
    //   432: pop
    //   433: goto -170 -> 263
    //   436: astore 8
    //   438: aload 7
    //   440: astore 6
    //   442: ldc 8
    //   444: iconst_1
    //   445: new 176	java/lang/StringBuilder
    //   448: dup
    //   449: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   452: ldc 229
    //   454: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: aload 8
    //   459: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   462: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: aload 8
    //   467: invokestatic 235	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   470: aload 7
    //   472: ifnull +10 -> 482
    //   475: aload 7
    //   477: invokeinterface 131 1 0
    //   482: aconst_null
    //   483: areturn
    //   484: aload 7
    //   486: astore 6
    //   488: aload 9
    //   490: invokevirtual 238	java/io/BufferedWriter:flush	()V
    //   493: aload 7
    //   495: astore 6
    //   497: aload 9
    //   499: invokevirtual 239	java/io/BufferedWriter:close	()V
    //   502: aload 8
    //   504: astore 6
    //   506: aload 7
    //   508: ifnull -372 -> 136
    //   511: aload 7
    //   513: invokeinterface 131 1 0
    //   518: aload 8
    //   520: areturn
    //   521: astore 7
    //   523: aconst_null
    //   524: astore 6
    //   526: aload 6
    //   528: ifnull +10 -> 538
    //   531: aload 6
    //   533: invokeinterface 131 1 0
    //   538: aload 7
    //   540: athrow
    //   541: astore 7
    //   543: goto -17 -> 526
    //   546: astore 8
    //   548: aconst_null
    //   549: astore 7
    //   551: goto -113 -> 438
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	554	0	paramLong1	long
    //   0	554	2	paramLong2	long
    //   168	19	4	bool1	boolean
    //   164	7	5	bool2	boolean
    //   134	398	6	localObject1	Object
    //   114	398	7	localCursor	android.database.Cursor
    //   521	18	7	localObject2	Object
    //   541	1	7	localObject3	Object
    //   549	1	7	localObject4	Object
    //   153	86	8	localObject5	Object
    //   436	83	8	localException1	Exception
    //   546	1	8	localException2	Exception
    //   249	249	9	localBufferedWriter	java.io.BufferedWriter
    // Exception table:
    //   from	to	target	type
    //   143	155	436	java/lang/Exception
    //   159	166	436	java/lang/Exception
    //   179	186	436	java/lang/Exception
    //   209	222	436	java/lang/Exception
    //   226	251	436	java/lang/Exception
    //   255	263	436	java/lang/Exception
    //   267	277	436	java/lang/Exception
    //   281	421	436	java/lang/Exception
    //   425	433	436	java/lang/Exception
    //   488	493	436	java/lang/Exception
    //   497	502	436	java/lang/Exception
    //   8	27	521	finally
    //   27	42	521	finally
    //   42	116	521	finally
    //   143	155	541	finally
    //   159	166	541	finally
    //   179	186	541	finally
    //   209	222	541	finally
    //   226	251	541	finally
    //   255	263	541	finally
    //   267	277	541	finally
    //   281	421	541	finally
    //   425	433	541	finally
    //   442	470	541	finally
    //   488	493	541	finally
    //   497	502	541	finally
    //   8	27	546	java/lang/Exception
    //   27	42	546	java/lang/Exception
    //   42	116	546	java/lang/Exception
  }
  
  private void a(Context paramContext)
  {
    this.n = (MsfSdkUtils.getProcessName(paramContext) + "_" + getClass().hashCode());
    paramContext = new IntentFilter();
    paramContext.addAction(this.n);
    BaseApplication.getContext().registerReceiver(this, paramContext);
    if (QLog.isColorLevel())
    {
      a(System.currentTimeMillis() + 300000L);
      return;
    }
    a(System.currentTimeMillis() + 600000L);
  }
  
  public static void b(long paramLong)
  {
    try
    {
      if (p == null) {
        p = new b(l);
      }
      if (q == null) {
        q = p.getWritableDatabase();
      }
      int i1 = q.delete("dataflow", "curtime < ?", new String[] { String.valueOf(paramLong) });
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.MonitorNetFlowStore", 4, "delete netflow " + i1 + " record.");
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.MonitorNetFlowStore", 1, "delete expire data failed. " + localException, localException);
    }
  }
  
  /* Error */
  public java.util.HashMap a(long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 75	com/tencent/mobileqq/msf/core/b/c:l	Landroid/content/Context;
    //   3: invokevirtual 309	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   6: ldc_w 311
    //   9: invokevirtual 317	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   12: astore 16
    //   14: new 319	java/util/Properties
    //   17: dup
    //   18: invokespecial 320	java/util/Properties:<init>	()V
    //   21: astore 18
    //   23: aload 18
    //   25: aload 16
    //   27: invokevirtual 324	java/util/Properties:loadFromXML	(Ljava/io/InputStream;)V
    //   30: invokestatic 330	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   33: astore 12
    //   35: aload 12
    //   37: bipush 6
    //   39: aload 12
    //   41: bipush 6
    //   43: invokevirtual 333	java/util/Calendar:get	(I)I
    //   46: iconst_1
    //   47: isub
    //   48: invokevirtual 337	java/util/Calendar:set	(II)V
    //   51: aload 12
    //   53: bipush 11
    //   55: iconst_0
    //   56: invokevirtual 337	java/util/Calendar:set	(II)V
    //   59: aload 12
    //   61: bipush 12
    //   63: iconst_0
    //   64: invokevirtual 337	java/util/Calendar:set	(II)V
    //   67: aload 12
    //   69: bipush 13
    //   71: iconst_0
    //   72: invokevirtual 337	java/util/Calendar:set	(II)V
    //   75: aload 12
    //   77: bipush 14
    //   79: iconst_0
    //   80: invokevirtual 337	java/util/Calendar:set	(II)V
    //   83: aload 12
    //   85: invokevirtual 340	java/util/Calendar:getTimeInMillis	()J
    //   88: lstore_1
    //   89: lload_1
    //   90: ldc2_w 341
    //   93: ladd
    //   94: lstore 8
    //   96: getstatic 87	com/tencent/mobileqq/msf/core/b/c:p	Lcom/tencent/mobileqq/msf/core/b/b;
    //   99: ifnonnull +16 -> 115
    //   102: new 89	com/tencent/mobileqq/msf/core/b/b
    //   105: dup
    //   106: getstatic 75	com/tencent/mobileqq/msf/core/b/c:l	Landroid/content/Context;
    //   109: invokespecial 92	com/tencent/mobileqq/msf/core/b/b:<init>	(Landroid/content/Context;)V
    //   112: putstatic 87	com/tencent/mobileqq/msf/core/b/c:p	Lcom/tencent/mobileqq/msf/core/b/b;
    //   115: getstatic 94	com/tencent/mobileqq/msf/core/b/c:q	Landroid/database/sqlite/SQLiteDatabase;
    //   118: ifnonnull +12 -> 130
    //   121: getstatic 87	com/tencent/mobileqq/msf/core/b/c:p	Lcom/tencent/mobileqq/msf/core/b/b;
    //   124: invokevirtual 98	com/tencent/mobileqq/msf/core/b/b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   127: putstatic 94	com/tencent/mobileqq/msf/core/b/c:q	Landroid/database/sqlite/SQLiteDatabase;
    //   130: new 344	java/util/HashMap
    //   133: dup
    //   134: invokespecial 345	java/util/HashMap:<init>	()V
    //   137: astore 17
    //   139: iconst_0
    //   140: istore 4
    //   142: iload 4
    //   144: iconst_5
    //   145: if_icmpge +1376 -> 1521
    //   148: iload_3
    //   149: ifeq +101 -> 250
    //   152: getstatic 94	com/tencent/mobileqq/msf/core/b/c:q	Landroid/database/sqlite/SQLiteDatabase;
    //   155: ldc 28
    //   157: bipush 6
    //   159: anewarray 100	java/lang/String
    //   162: dup
    //   163: iconst_0
    //   164: ldc 102
    //   166: aastore
    //   167: dup
    //   168: iconst_1
    //   169: ldc 104
    //   171: aastore
    //   172: dup
    //   173: iconst_2
    //   174: ldc 106
    //   176: aastore
    //   177: dup
    //   178: iconst_3
    //   179: ldc 110
    //   181: aastore
    //   182: dup
    //   183: iconst_4
    //   184: ldc 112
    //   186: aastore
    //   187: dup
    //   188: iconst_5
    //   189: ldc_w 347
    //   192: aastore
    //   193: ldc_w 349
    //   196: iconst_3
    //   197: anewarray 100	java/lang/String
    //   200: dup
    //   201: iconst_0
    //   202: lload_1
    //   203: invokestatic 120	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   206: aastore
    //   207: dup
    //   208: iconst_1
    //   209: lload 8
    //   211: invokestatic 120	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   214: aastore
    //   215: dup
    //   216: iconst_2
    //   217: iload 4
    //   219: invokestatic 351	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   222: aastore
    //   223: aconst_null
    //   224: aconst_null
    //   225: aconst_null
    //   226: invokevirtual 126	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   229: astore 13
    //   231: aload 13
    //   233: ifnonnull +113 -> 346
    //   236: aload 13
    //   238: ifnull +10 -> 248
    //   241: aload 13
    //   243: invokeinterface 131 1 0
    //   248: aconst_null
    //   249: areturn
    //   250: getstatic 94	com/tencent/mobileqq/msf/core/b/c:q	Landroid/database/sqlite/SQLiteDatabase;
    //   253: ldc 28
    //   255: bipush 6
    //   257: anewarray 100	java/lang/String
    //   260: dup
    //   261: iconst_0
    //   262: ldc 102
    //   264: aastore
    //   265: dup
    //   266: iconst_1
    //   267: ldc 104
    //   269: aastore
    //   270: dup
    //   271: iconst_2
    //   272: ldc 106
    //   274: aastore
    //   275: dup
    //   276: iconst_3
    //   277: ldc 110
    //   279: aastore
    //   280: dup
    //   281: iconst_4
    //   282: ldc 112
    //   284: aastore
    //   285: dup
    //   286: iconst_5
    //   287: ldc_w 347
    //   290: aastore
    //   291: ldc_w 353
    //   294: iconst_5
    //   295: anewarray 100	java/lang/String
    //   298: dup
    //   299: iconst_0
    //   300: lload_1
    //   301: invokestatic 120	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   304: aastore
    //   305: dup
    //   306: iconst_1
    //   307: lload 8
    //   309: invokestatic 120	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   312: aastore
    //   313: dup
    //   314: iconst_2
    //   315: iconst_2
    //   316: invokestatic 351	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   319: aastore
    //   320: dup
    //   321: iconst_3
    //   322: iconst_3
    //   323: invokestatic 351	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   326: aastore
    //   327: dup
    //   328: iconst_4
    //   329: iload 4
    //   331: invokestatic 351	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   334: aastore
    //   335: aconst_null
    //   336: aconst_null
    //   337: aconst_null
    //   338: invokevirtual 126	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   341: astore 13
    //   343: goto -112 -> 231
    //   346: aload 13
    //   348: invokeinterface 171 1 0
    //   353: pop
    //   354: iload 4
    //   356: ifne +565 -> 921
    //   359: iconst_1
    //   360: istore 6
    //   362: aload 13
    //   364: invokeinterface 174 1 0
    //   369: ifne +1137 -> 1506
    //   372: aload 13
    //   374: iconst_0
    //   375: invokeinterface 181 2 0
    //   380: astore 14
    //   382: aload 13
    //   384: iconst_1
    //   385: invokeinterface 181 2 0
    //   390: astore 19
    //   392: aload 13
    //   394: iconst_2
    //   395: invokeinterface 197 2 0
    //   400: lstore 10
    //   402: aload 13
    //   404: iconst_3
    //   405: invokeinterface 181 2 0
    //   410: astore 12
    //   412: aload 13
    //   414: iconst_4
    //   415: invokeinterface 204 2 0
    //   420: istore 7
    //   422: iload 7
    //   424: iconst_3
    //   425: if_icmpeq +503 -> 928
    //   428: iload 7
    //   430: iconst_2
    //   431: if_icmpeq +497 -> 928
    //   434: iconst_1
    //   435: istore 5
    //   437: aload 14
    //   439: ldc_w 355
    //   442: invokevirtual 359	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   445: ifne +1400 -> 1845
    //   448: aload 12
    //   450: ldc_w 361
    //   453: invokevirtual 365	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   456: ifne +1389 -> 1845
    //   459: aload 12
    //   461: ldc_w 367
    //   464: invokevirtual 365	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   467: ifne +1378 -> 1845
    //   470: aload 12
    //   472: ldc_w 369
    //   475: invokevirtual 365	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   478: ifne +1367 -> 1845
    //   481: aload 14
    //   483: ldc_w 371
    //   486: invokevirtual 359	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   489: ifeq +461 -> 950
    //   492: aload 12
    //   494: ldc 11
    //   496: invokevirtual 374	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   499: ifeq +537 -> 1036
    //   502: aload 18
    //   504: new 176	java/lang/StringBuilder
    //   507: dup
    //   508: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   511: ldc 11
    //   513: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: iload 5
    //   518: invokevirtual 207	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   521: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: invokevirtual 377	java/util/Properties:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   527: checkcast 100	java/lang/String
    //   530: astore 14
    //   532: aload 17
    //   534: aload 19
    //   536: invokevirtual 380	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   539: ifeq +779 -> 1318
    //   542: aload 17
    //   544: aload 19
    //   546: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   549: checkcast 383	android/util/SparseArray
    //   552: iload 6
    //   554: invokevirtual 386	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   557: ifnonnull +29 -> 586
    //   560: new 344	java/util/HashMap
    //   563: dup
    //   564: invokespecial 345	java/util/HashMap:<init>	()V
    //   567: astore 15
    //   569: aload 17
    //   571: aload 19
    //   573: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   576: checkcast 383	android/util/SparseArray
    //   579: iload 6
    //   581: aload 15
    //   583: invokevirtual 390	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   586: aload 14
    //   588: ifnonnull +584 -> 1172
    //   591: new 176	java/lang/StringBuilder
    //   594: dup
    //   595: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   598: astore 20
    //   600: iload 5
    //   602: iconst_1
    //   603: if_icmpne +1248 -> 1851
    //   606: ldc_w 392
    //   609: astore 15
    //   611: aload 20
    //   613: aload 15
    //   615: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: aload 12
    //   620: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: ldc_w 394
    //   626: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   632: astore 12
    //   634: aload 17
    //   636: aload 19
    //   638: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   641: checkcast 383	android/util/SparseArray
    //   644: iload 6
    //   646: invokevirtual 386	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   649: checkcast 344	java/util/HashMap
    //   652: aload 12
    //   654: invokevirtual 380	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   657: ifeq +412 -> 1069
    //   660: aload 17
    //   662: aload 19
    //   664: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   667: checkcast 383	android/util/SparseArray
    //   670: iload 6
    //   672: invokevirtual 386	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   675: checkcast 344	java/util/HashMap
    //   678: astore 15
    //   680: aload 15
    //   682: aload 12
    //   684: aload 15
    //   686: aload 12
    //   688: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   691: checkcast 209	java/lang/Long
    //   694: invokevirtual 397	java/lang/Long:longValue	()J
    //   697: lload 10
    //   699: ladd
    //   700: invokestatic 212	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   703: invokevirtual 400	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   706: pop
    //   707: aload 17
    //   709: aload 19
    //   711: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   714: checkcast 383	android/util/SparseArray
    //   717: iload 6
    //   719: aload 15
    //   721: invokevirtual 390	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   724: iload_3
    //   725: ifeq +19 -> 744
    //   728: aload 14
    //   730: ifnull +14 -> 744
    //   733: aload 14
    //   735: ldc_w 392
    //   738: invokevirtual 374	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   741: ifne +18 -> 759
    //   744: iload_3
    //   745: ifeq +105 -> 850
    //   748: aload 12
    //   750: ldc_w 392
    //   753: invokevirtual 374	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   756: ifeq +94 -> 850
    //   759: aload 17
    //   761: aload 19
    //   763: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   766: checkcast 383	android/util/SparseArray
    //   769: iload 6
    //   771: invokevirtual 386	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   774: checkcast 344	java/util/HashMap
    //   777: astore 12
    //   779: aload 12
    //   781: ifnonnull +1067 -> 1848
    //   784: new 344	java/util/HashMap
    //   787: dup
    //   788: invokespecial 345	java/util/HashMap:<init>	()V
    //   791: astore 12
    //   793: aload 12
    //   795: ldc_w 402
    //   798: invokevirtual 380	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   801: ifeq +671 -> 1472
    //   804: aload 12
    //   806: ldc_w 402
    //   809: lload 10
    //   811: aload 12
    //   813: ldc_w 402
    //   816: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   819: checkcast 209	java/lang/Long
    //   822: invokevirtual 397	java/lang/Long:longValue	()J
    //   825: ladd
    //   826: invokestatic 212	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   829: invokevirtual 400	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   832: pop
    //   833: aload 17
    //   835: aload 19
    //   837: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   840: checkcast 383	android/util/SparseArray
    //   843: iload 6
    //   845: aload 12
    //   847: invokevirtual 390	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   850: aload 13
    //   852: invokeinterface 227 1 0
    //   857: pop
    //   858: goto -496 -> 362
    //   861: astore 14
    //   863: aload 13
    //   865: astore 12
    //   867: aload 14
    //   869: astore 13
    //   871: ldc 8
    //   873: iconst_1
    //   874: new 176	java/lang/StringBuilder
    //   877: dup
    //   878: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   881: ldc_w 404
    //   884: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: aload 13
    //   889: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   892: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   895: aload 13
    //   897: invokestatic 235	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   900: aload 12
    //   902: ifnull +10 -> 912
    //   905: aload 12
    //   907: invokeinterface 131 1 0
    //   912: iload 4
    //   914: iconst_1
    //   915: iadd
    //   916: istore 4
    //   918: goto -776 -> 142
    //   921: iload 4
    //   923: istore 6
    //   925: goto -563 -> 362
    //   928: iload 7
    //   930: iconst_2
    //   931: if_icmpeq +13 -> 944
    //   934: iload 7
    //   936: istore 5
    //   938: iload 7
    //   940: iconst_3
    //   941: if_icmpne -504 -> 437
    //   944: iconst_2
    //   945: istore 5
    //   947: goto -510 -> 437
    //   950: aload 14
    //   952: ldc_w 406
    //   955: invokevirtual 359	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   958: ifeq +11 -> 969
    //   961: ldc_w 408
    //   964: astore 12
    //   966: goto -474 -> 492
    //   969: aload 14
    //   971: ldc_w 410
    //   974: invokevirtual 414	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   977: ifeq +868 -> 1845
    //   980: aload 14
    //   982: ldc_w 410
    //   985: invokevirtual 418	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   988: istore 7
    //   990: new 176	java/lang/StringBuilder
    //   993: dup
    //   994: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   997: aload 14
    //   999: iload 7
    //   1001: iconst_1
    //   1002: iadd
    //   1003: iload 7
    //   1005: iconst_2
    //   1006: iadd
    //   1007: invokevirtual 422	java/lang/String:substring	(II)Ljava/lang/String;
    //   1010: invokevirtual 425	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   1013: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1016: aload 14
    //   1018: iload 7
    //   1020: iconst_2
    //   1021: iadd
    //   1022: invokevirtual 427	java/lang/String:substring	(I)Ljava/lang/String;
    //   1025: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1028: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1031: astore 12
    //   1033: goto -541 -> 492
    //   1036: aload 18
    //   1038: new 176	java/lang/StringBuilder
    //   1041: dup
    //   1042: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   1045: aload 12
    //   1047: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: iload 5
    //   1052: invokevirtual 207	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1055: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1058: invokevirtual 377	java/util/Properties:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1061: checkcast 100	java/lang/String
    //   1064: astore 14
    //   1066: goto -534 -> 532
    //   1069: aload 17
    //   1071: aload 19
    //   1073: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1076: checkcast 383	android/util/SparseArray
    //   1079: iload 6
    //   1081: invokevirtual 386	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1084: checkcast 344	java/util/HashMap
    //   1087: astore 15
    //   1089: aload 15
    //   1091: aload 12
    //   1093: lload 10
    //   1095: invokestatic 212	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1098: invokevirtual 400	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1101: pop
    //   1102: aload 17
    //   1104: aload 19
    //   1106: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1109: checkcast 383	android/util/SparseArray
    //   1112: iload 6
    //   1114: aload 15
    //   1116: invokevirtual 390	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1119: goto -395 -> 724
    //   1122: astore 12
    //   1124: aload 13
    //   1126: ifnull +10 -> 1136
    //   1129: aload 13
    //   1131: invokeinterface 131 1 0
    //   1136: aload 12
    //   1138: athrow
    //   1139: astore 12
    //   1141: ldc 8
    //   1143: iconst_1
    //   1144: new 176	java/lang/StringBuilder
    //   1147: dup
    //   1148: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   1151: ldc_w 429
    //   1154: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1157: aload 12
    //   1159: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1162: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1165: aload 12
    //   1167: invokestatic 235	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1170: aconst_null
    //   1171: areturn
    //   1172: aload 17
    //   1174: aload 19
    //   1176: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1179: checkcast 383	android/util/SparseArray
    //   1182: iload 6
    //   1184: invokevirtual 386	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1187: checkcast 344	java/util/HashMap
    //   1190: aload 14
    //   1192: invokevirtual 380	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1195: ifeq +70 -> 1265
    //   1198: aload 17
    //   1200: aload 19
    //   1202: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1205: checkcast 383	android/util/SparseArray
    //   1208: iload 6
    //   1210: invokevirtual 386	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1213: checkcast 344	java/util/HashMap
    //   1216: astore 15
    //   1218: aload 15
    //   1220: aload 14
    //   1222: aload 15
    //   1224: aload 14
    //   1226: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1229: checkcast 209	java/lang/Long
    //   1232: invokevirtual 397	java/lang/Long:longValue	()J
    //   1235: lload 10
    //   1237: ladd
    //   1238: invokestatic 212	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1241: invokevirtual 400	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1244: pop
    //   1245: aload 17
    //   1247: aload 19
    //   1249: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1252: checkcast 383	android/util/SparseArray
    //   1255: iload 6
    //   1257: aload 15
    //   1259: invokevirtual 390	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1262: goto -538 -> 724
    //   1265: aload 17
    //   1267: aload 19
    //   1269: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1272: checkcast 383	android/util/SparseArray
    //   1275: iload 6
    //   1277: invokevirtual 386	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1280: checkcast 344	java/util/HashMap
    //   1283: astore 15
    //   1285: aload 15
    //   1287: aload 14
    //   1289: lload 10
    //   1291: invokestatic 212	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1294: invokevirtual 400	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1297: pop
    //   1298: aload 17
    //   1300: aload 19
    //   1302: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1305: checkcast 383	android/util/SparseArray
    //   1308: iload 6
    //   1310: aload 15
    //   1312: invokevirtual 390	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1315: goto -591 -> 724
    //   1318: aload 14
    //   1320: ifnonnull +99 -> 1419
    //   1323: new 176	java/lang/StringBuilder
    //   1326: dup
    //   1327: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   1330: astore 20
    //   1332: iload 5
    //   1334: iconst_1
    //   1335: if_icmpne +524 -> 1859
    //   1338: ldc_w 392
    //   1341: astore 15
    //   1343: aload 20
    //   1345: aload 15
    //   1347: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1350: aload 12
    //   1352: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1355: ldc_w 394
    //   1358: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1364: astore 12
    //   1366: new 344	java/util/HashMap
    //   1369: dup
    //   1370: invokespecial 345	java/util/HashMap:<init>	()V
    //   1373: astore 15
    //   1375: aload 15
    //   1377: aload 12
    //   1379: lload 10
    //   1381: invokestatic 212	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1384: invokevirtual 400	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1387: pop
    //   1388: new 383	android/util/SparseArray
    //   1391: dup
    //   1392: invokespecial 430	android/util/SparseArray:<init>	()V
    //   1395: astore 20
    //   1397: aload 20
    //   1399: iload 6
    //   1401: aload 15
    //   1403: invokevirtual 390	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1406: aload 17
    //   1408: aload 19
    //   1410: aload 20
    //   1412: invokevirtual 400	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1415: pop
    //   1416: goto -692 -> 724
    //   1419: new 344	java/util/HashMap
    //   1422: dup
    //   1423: invokespecial 345	java/util/HashMap:<init>	()V
    //   1426: astore 15
    //   1428: aload 15
    //   1430: aload 14
    //   1432: lload 10
    //   1434: invokestatic 212	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1437: invokevirtual 400	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1440: pop
    //   1441: new 383	android/util/SparseArray
    //   1444: dup
    //   1445: invokespecial 430	android/util/SparseArray:<init>	()V
    //   1448: astore 20
    //   1450: aload 20
    //   1452: iload 6
    //   1454: aload 15
    //   1456: invokevirtual 390	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1459: aload 17
    //   1461: aload 19
    //   1463: aload 20
    //   1465: invokevirtual 400	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1468: pop
    //   1469: goto -745 -> 724
    //   1472: aload 12
    //   1474: ldc_w 402
    //   1477: lload 10
    //   1479: invokestatic 212	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1482: invokevirtual 400	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1485: pop
    //   1486: aload 17
    //   1488: aload 19
    //   1490: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1493: checkcast 383	android/util/SparseArray
    //   1496: iload 6
    //   1498: aload 12
    //   1500: invokevirtual 390	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1503: goto -653 -> 850
    //   1506: aload 13
    //   1508: ifnull -596 -> 912
    //   1511: aload 13
    //   1513: invokeinterface 131 1 0
    //   1518: goto -606 -> 912
    //   1521: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1524: ifeq +284 -> 1808
    //   1527: aload 17
    //   1529: invokevirtual 434	java/util/HashMap:keySet	()Ljava/util/Set;
    //   1532: invokeinterface 440 1 0
    //   1537: astore 12
    //   1539: aload 12
    //   1541: invokeinterface 445 1 0
    //   1546: ifeq +262 -> 1808
    //   1549: aload 12
    //   1551: invokeinterface 449 1 0
    //   1556: checkcast 100	java/lang/String
    //   1559: astore 13
    //   1561: iconst_1
    //   1562: istore 4
    //   1564: iload 4
    //   1566: iconst_5
    //   1567: if_icmpge -28 -> 1539
    //   1570: aload 17
    //   1572: aload 13
    //   1574: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1577: checkcast 383	android/util/SparseArray
    //   1580: iload 4
    //   1582: invokevirtual 386	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1585: checkcast 344	java/util/HashMap
    //   1588: astore 14
    //   1590: aload 14
    //   1592: ifnonnull +6 -> 1598
    //   1595: goto +272 -> 1867
    //   1598: aload 14
    //   1600: invokevirtual 434	java/util/HashMap:keySet	()Ljava/util/Set;
    //   1603: invokeinterface 440 1 0
    //   1608: astore 14
    //   1610: aload 14
    //   1612: invokeinterface 445 1 0
    //   1617: ifeq +250 -> 1867
    //   1620: aload 14
    //   1622: invokeinterface 449 1 0
    //   1627: checkcast 100	java/lang/String
    //   1630: astore 15
    //   1632: iload_3
    //   1633: ifeq +89 -> 1722
    //   1636: ldc 8
    //   1638: iconst_2
    //   1639: new 176	java/lang/StringBuilder
    //   1642: dup
    //   1643: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   1646: ldc_w 451
    //   1649: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1652: aload 13
    //   1654: invokestatic 193	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   1657: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1660: ldc_w 453
    //   1663: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1666: aload 15
    //   1668: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1671: ldc_w 455
    //   1674: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1677: aload 17
    //   1679: aload 13
    //   1681: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1684: checkcast 383	android/util/SparseArray
    //   1687: iload 4
    //   1689: invokevirtual 386	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1692: checkcast 344	java/util/HashMap
    //   1695: aload 15
    //   1697: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1700: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1703: ldc 187
    //   1705: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1708: iload 4
    //   1710: invokevirtual 207	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1713: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1716: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1719: goto -109 -> 1610
    //   1722: ldc 8
    //   1724: iconst_2
    //   1725: new 176	java/lang/StringBuilder
    //   1728: dup
    //   1729: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   1732: ldc_w 457
    //   1735: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1738: aload 13
    //   1740: invokestatic 193	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   1743: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1746: ldc_w 453
    //   1749: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1752: aload 15
    //   1754: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1757: ldc_w 455
    //   1760: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1763: aload 17
    //   1765: aload 13
    //   1767: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1770: checkcast 383	android/util/SparseArray
    //   1773: iload 4
    //   1775: invokevirtual 386	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1778: checkcast 344	java/util/HashMap
    //   1781: aload 15
    //   1783: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1786: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1789: ldc 187
    //   1791: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1794: iload 4
    //   1796: invokevirtual 207	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1799: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1802: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1805: goto -195 -> 1610
    //   1808: aload 16
    //   1810: invokevirtual 460	java/io/InputStream:close	()V
    //   1813: aload 17
    //   1815: areturn
    //   1816: astore 12
    //   1818: aconst_null
    //   1819: astore 13
    //   1821: goto -697 -> 1124
    //   1824: astore 14
    //   1826: aload 12
    //   1828: astore 13
    //   1830: aload 14
    //   1832: astore 12
    //   1834: goto -710 -> 1124
    //   1837: astore 13
    //   1839: aconst_null
    //   1840: astore 12
    //   1842: goto -971 -> 871
    //   1845: goto -1353 -> 492
    //   1848: goto -1055 -> 793
    //   1851: ldc_w 462
    //   1854: astore 15
    //   1856: goto -1245 -> 611
    //   1859: ldc_w 462
    //   1862: astore 15
    //   1864: goto -521 -> 1343
    //   1867: iload 4
    //   1869: iconst_1
    //   1870: iadd
    //   1871: istore 4
    //   1873: goto -309 -> 1564
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1876	0	this	c
    //   0	1876	1	paramLong	long
    //   0	1876	3	paramBoolean	boolean
    //   140	1732	4	i1	int
    //   435	901	5	i2	int
    //   360	1137	6	i3	int
    //   420	602	7	i4	int
    //   94	214	8	l1	long
    //   400	1078	10	l2	long
    //   33	1059	12	localObject1	Object
    //   1122	15	12	localObject2	Object
    //   1139	212	12	localException1	Exception
    //   1364	186	12	localObject3	Object
    //   1816	11	12	localObject4	Object
    //   1832	9	12	localObject5	Object
    //   229	1600	13	localObject6	Object
    //   1837	1	13	localException2	Exception
    //   380	354	14	str1	String
    //   861	156	14	localException3	Exception
    //   1064	557	14	localObject7	Object
    //   1824	7	14	localObject8	Object
    //   567	1296	15	localObject9	Object
    //   12	1797	16	localInputStream	java.io.InputStream
    //   137	1677	17	localHashMap	java.util.HashMap
    //   21	1016	18	localProperties	java.util.Properties
    //   390	1099	19	str2	String
    //   598	866	20	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   346	354	861	java/lang/Exception
    //   362	422	861	java/lang/Exception
    //   437	492	861	java/lang/Exception
    //   492	532	861	java/lang/Exception
    //   532	586	861	java/lang/Exception
    //   591	600	861	java/lang/Exception
    //   611	724	861	java/lang/Exception
    //   733	744	861	java/lang/Exception
    //   748	759	861	java/lang/Exception
    //   759	779	861	java/lang/Exception
    //   784	793	861	java/lang/Exception
    //   793	850	861	java/lang/Exception
    //   850	858	861	java/lang/Exception
    //   950	961	861	java/lang/Exception
    //   969	1033	861	java/lang/Exception
    //   1036	1066	861	java/lang/Exception
    //   1069	1119	861	java/lang/Exception
    //   1172	1262	861	java/lang/Exception
    //   1265	1315	861	java/lang/Exception
    //   1323	1332	861	java/lang/Exception
    //   1343	1416	861	java/lang/Exception
    //   1419	1469	861	java/lang/Exception
    //   1472	1503	861	java/lang/Exception
    //   346	354	1122	finally
    //   362	422	1122	finally
    //   437	492	1122	finally
    //   492	532	1122	finally
    //   532	586	1122	finally
    //   591	600	1122	finally
    //   611	724	1122	finally
    //   733	744	1122	finally
    //   748	759	1122	finally
    //   759	779	1122	finally
    //   784	793	1122	finally
    //   793	850	1122	finally
    //   850	858	1122	finally
    //   950	961	1122	finally
    //   969	1033	1122	finally
    //   1036	1066	1122	finally
    //   1069	1119	1122	finally
    //   1172	1262	1122	finally
    //   1265	1315	1122	finally
    //   1323	1332	1122	finally
    //   1343	1416	1122	finally
    //   1419	1469	1122	finally
    //   1472	1503	1122	finally
    //   0	89	1139	java/lang/Exception
    //   96	115	1139	java/lang/Exception
    //   115	130	1139	java/lang/Exception
    //   130	139	1139	java/lang/Exception
    //   241	248	1139	java/lang/Exception
    //   905	912	1139	java/lang/Exception
    //   1129	1136	1139	java/lang/Exception
    //   1136	1139	1139	java/lang/Exception
    //   1511	1518	1139	java/lang/Exception
    //   1521	1539	1139	java/lang/Exception
    //   1539	1561	1139	java/lang/Exception
    //   1570	1590	1139	java/lang/Exception
    //   1598	1610	1139	java/lang/Exception
    //   1610	1632	1139	java/lang/Exception
    //   1636	1719	1139	java/lang/Exception
    //   1722	1805	1139	java/lang/Exception
    //   1808	1813	1139	java/lang/Exception
    //   152	231	1816	finally
    //   250	343	1816	finally
    //   871	900	1824	finally
    //   152	231	1837	java/lang/Exception
    //   250	343	1837	java/lang/Exception
  }
  
  public void a()
  {
    int i2 = 0;
    try
    {
      if (p == null) {
        p = new b(l);
      }
      if (q == null) {
        q = p.getWritableDatabase();
      }
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.MonitorNetFlowStore", 2, "write data : " + this.b.size() + " | read data : " + this.c.size() + ", starting to store.");
      }
      Iterator localIterator = this.b.keySet().iterator();
      int i1 = 0;
      String str;
      a locala;
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        locala = (a)this.b.get(str);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.MonitorNetFlowStore", 2, "mType|" + locala.h + "|" + locala.b + "|" + locala.d + "|write|" + locala.f + "|" + locala.g + "|" + locala.i + "|" + locala.a);
        }
        q.execSQL("insert into dataflow(processName, uin, ip, refer, port, flag, buffersize, networktype, mType, curtime, status) values(?,?,?,?,?,?,?,?,?,?,?)", new Object[] { locala.a, this.k.sender.h(), locala.b, locala.c, Integer.valueOf(locala.d), Integer.valueOf(locala.e), Long.valueOf(locala.f), Integer.valueOf(locala.g), locala.h, Long.valueOf(l1), Byte.valueOf(locala.i) });
        i1 = (int)(i1 + ((a)this.b.get(str)).f);
        this.b.remove(str);
      }
      localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        locala = (a)this.c.get(str);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.MonitorNetFlowStore", 2, "mType|" + locala.h + "|" + locala.b + "|" + locala.d + "|read|" + locala.f + "|" + locala.g + "|" + locala.i + "|" + locala.a);
        }
        q.execSQL("insert into dataflow(processName, uin, ip, refer, port, flag, buffersize, networktype, mType, curtime, status) values(?,?,?,?,?,?,?,?,?,?,?)", new Object[] { locala.a, this.k.sender.h(), locala.b, locala.c, Integer.valueOf(locala.d), Integer.valueOf(locala.e), Long.valueOf(locala.f), Integer.valueOf(locala.g), locala.h, Long.valueOf(l1), Byte.valueOf(locala.i) });
        long l2 = i2;
        i2 = (int)(((a)this.c.get(str)).f + l2);
        this.c.remove(str);
      }
      QLog.d("MSF.C.MonitorNetFlowStore", 1, "write data lenth : " + i1 + " | read data lenth : " + i2 + ", has been stored.");
      i.a(System.currentTimeMillis(), 1);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.MonitorNetFlowStore", 1, "data store failed.", localException);
    }
  }
  
  public void a(long paramLong)
  {
    Intent localIntent = new Intent(this.n);
    localIntent.setAction(this.n);
    this.o = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, localIntent, 0);
    this.m = ((AlarmManager)BaseApplication.getContext().getSystemService("alarm"));
    if (QLog.isColorLevel()) {
      this.m.setRepeating(0, paramLong, 300000L, this.o);
    }
    for (;;)
    {
      QLog.d("MSF.C.MonitorNetFlowStore", 1, "register " + this.n.hashCode() + " alarm alive send at " + i.format(Long.valueOf(paramLong)));
      return;
      this.m.setRepeating(0, paramLong, 600000L, this.o);
    }
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.MonitorNetFlowStore", 2, "receive broadcast : " + paramIntent.getAction() + ", start to store socket flow at " + i.format(Long.valueOf(System.currentTimeMillis())));
    }
    try
    {
      if (p == null) {
        p = new b(paramContext);
      }
      if (q == null) {
        q = p.getWritableDatabase();
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        QLog.d("MSF.C.MonitorNetFlowStore", 1, "create DBHelper failed.", paramContext);
      }
      new d(this).start();
    }
    if ((this.b.isEmpty()) && (this.c.isEmpty())) {
      return;
    }
  }
  
  public void a(a parama)
  {
    try
    {
      switch (parama.e)
      {
      case 0: 
        locala = (a)this.b.get(parama.h + parama.g + parama.i);
        if (locala != null)
        {
          this.b.put(parama.h + parama.g + parama.i, locala.a(parama.f));
          return;
        }
        break;
      }
    }
    catch (Exception parama)
    {
      QLog.d("MSF.C.MonitorNetFlowStore", 1, "MonitorDataFlow cache failed.", parama);
      return;
    }
    this.b.put(parama.h + parama.g + parama.i, parama);
    return;
    a locala = (a)this.c.get(parama.h + parama.g + parama.i);
    if (locala != null)
    {
      this.c.put(parama.h + parama.g + parama.i, locala.a(parama.f));
      return;
    }
    this.c.put(parama.h + parama.g + parama.i, parama);
    return;
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    for (;;)
    {
      try
      {
        paramToServiceMsg = paramToServiceMsg.extraData;
        a locala = new a(paramToServiceMsg.getString("ip"), paramToServiceMsg.getString("refer"), paramToServiceMsg.getInt("port"), paramToServiceMsg.getInt("flag"), paramToServiceMsg.getLong("buffersize"), paramToServiceMsg.getInt("networktype"));
        locala.a = paramToServiceMsg.getString("processName");
        locala.i = paramToServiceMsg.getByte("status");
        if (paramToServiceMsg.getString("mType").startsWith("LongConn")) {
          locala.i = MonitorSocketStat.STATUS;
        }
        int i1 = paramToServiceMsg.getString("mType").indexOf(".");
        if (i1 != -1)
        {
          if (paramToServiceMsg.getString("mType").indexOf(".", i1 + 1) != -1)
          {
            locala.h = paramToServiceMsg.getString("mType");
            a(locala);
            return;
          }
          locala.h = paramToServiceMsg.getString("mType").substring(0, i1);
          continue;
        }
        locala.h = paramToServiceMsg.getString("mType");
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.d("MSF.C.MonitorNetFlowStore", 1, "ToServiceMsg analysis error.", paramToServiceMsg);
        return;
      }
    }
  }
  
  /* Error */
  public java.util.HashMap b(long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 75	com/tencent/mobileqq/msf/core/b/c:l	Landroid/content/Context;
    //   3: invokevirtual 309	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   6: ldc_w 311
    //   9: invokevirtual 317	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   12: astore 12
    //   14: new 319	java/util/Properties
    //   17: dup
    //   18: invokespecial 320	java/util/Properties:<init>	()V
    //   21: astore 13
    //   23: aload 13
    //   25: aload 12
    //   27: invokevirtual 324	java/util/Properties:loadFromXML	(Ljava/io/InputStream;)V
    //   30: invokestatic 330	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   33: astore 8
    //   35: aload 8
    //   37: bipush 6
    //   39: aload 8
    //   41: bipush 6
    //   43: invokevirtual 333	java/util/Calendar:get	(I)I
    //   46: iconst_1
    //   47: isub
    //   48: invokevirtual 337	java/util/Calendar:set	(II)V
    //   51: aload 8
    //   53: bipush 11
    //   55: iconst_0
    //   56: invokevirtual 337	java/util/Calendar:set	(II)V
    //   59: aload 8
    //   61: bipush 12
    //   63: iconst_0
    //   64: invokevirtual 337	java/util/Calendar:set	(II)V
    //   67: aload 8
    //   69: bipush 13
    //   71: iconst_0
    //   72: invokevirtual 337	java/util/Calendar:set	(II)V
    //   75: aload 8
    //   77: bipush 14
    //   79: iconst_0
    //   80: invokevirtual 337	java/util/Calendar:set	(II)V
    //   83: aload 8
    //   85: invokevirtual 340	java/util/Calendar:getTimeInMillis	()J
    //   88: lstore_1
    //   89: lload_1
    //   90: ldc2_w 341
    //   93: ladd
    //   94: lstore 6
    //   96: getstatic 87	com/tencent/mobileqq/msf/core/b/c:p	Lcom/tencent/mobileqq/msf/core/b/b;
    //   99: ifnonnull +16 -> 115
    //   102: new 89	com/tencent/mobileqq/msf/core/b/b
    //   105: dup
    //   106: getstatic 75	com/tencent/mobileqq/msf/core/b/c:l	Landroid/content/Context;
    //   109: invokespecial 92	com/tencent/mobileqq/msf/core/b/b:<init>	(Landroid/content/Context;)V
    //   112: putstatic 87	com/tencent/mobileqq/msf/core/b/c:p	Lcom/tencent/mobileqq/msf/core/b/b;
    //   115: getstatic 94	com/tencent/mobileqq/msf/core/b/c:q	Landroid/database/sqlite/SQLiteDatabase;
    //   118: ifnonnull +12 -> 130
    //   121: getstatic 87	com/tencent/mobileqq/msf/core/b/c:p	Lcom/tencent/mobileqq/msf/core/b/b;
    //   124: invokevirtual 98	com/tencent/mobileqq/msf/core/b/b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   127: putstatic 94	com/tencent/mobileqq/msf/core/b/c:q	Landroid/database/sqlite/SQLiteDatabase;
    //   130: iload_3
    //   131: ifeq +92 -> 223
    //   134: getstatic 94	com/tencent/mobileqq/msf/core/b/c:q	Landroid/database/sqlite/SQLiteDatabase;
    //   137: ldc 28
    //   139: bipush 6
    //   141: anewarray 100	java/lang/String
    //   144: dup
    //   145: iconst_0
    //   146: ldc 102
    //   148: aastore
    //   149: dup
    //   150: iconst_1
    //   151: ldc 104
    //   153: aastore
    //   154: dup
    //   155: iconst_2
    //   156: ldc 106
    //   158: aastore
    //   159: dup
    //   160: iconst_3
    //   161: ldc 110
    //   163: aastore
    //   164: dup
    //   165: iconst_4
    //   166: ldc 112
    //   168: aastore
    //   169: dup
    //   170: iconst_5
    //   171: ldc_w 347
    //   174: aastore
    //   175: ldc 116
    //   177: iconst_2
    //   178: anewarray 100	java/lang/String
    //   181: dup
    //   182: iconst_0
    //   183: lload_1
    //   184: invokestatic 120	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   187: aastore
    //   188: dup
    //   189: iconst_1
    //   190: lload 6
    //   192: invokestatic 120	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   195: aastore
    //   196: aconst_null
    //   197: aconst_null
    //   198: aconst_null
    //   199: invokevirtual 126	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   202: astore 9
    //   204: aload 9
    //   206: ifnonnull +105 -> 311
    //   209: aload 9
    //   211: ifnull +10 -> 221
    //   214: aload 9
    //   216: invokeinterface 131 1 0
    //   221: aconst_null
    //   222: areturn
    //   223: getstatic 94	com/tencent/mobileqq/msf/core/b/c:q	Landroid/database/sqlite/SQLiteDatabase;
    //   226: ldc 28
    //   228: bipush 6
    //   230: anewarray 100	java/lang/String
    //   233: dup
    //   234: iconst_0
    //   235: ldc 102
    //   237: aastore
    //   238: dup
    //   239: iconst_1
    //   240: ldc 104
    //   242: aastore
    //   243: dup
    //   244: iconst_2
    //   245: ldc 106
    //   247: aastore
    //   248: dup
    //   249: iconst_3
    //   250: ldc 110
    //   252: aastore
    //   253: dup
    //   254: iconst_4
    //   255: ldc 112
    //   257: aastore
    //   258: dup
    //   259: iconst_5
    //   260: ldc_w 347
    //   263: aastore
    //   264: ldc_w 652
    //   267: iconst_4
    //   268: anewarray 100	java/lang/String
    //   271: dup
    //   272: iconst_0
    //   273: lload_1
    //   274: invokestatic 120	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   277: aastore
    //   278: dup
    //   279: iconst_1
    //   280: lload 6
    //   282: invokestatic 120	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   285: aastore
    //   286: dup
    //   287: iconst_2
    //   288: iconst_2
    //   289: invokestatic 351	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   292: aastore
    //   293: dup
    //   294: iconst_3
    //   295: iconst_3
    //   296: invokestatic 351	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   299: aastore
    //   300: aconst_null
    //   301: aconst_null
    //   302: aconst_null
    //   303: invokevirtual 126	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   306: astore 9
    //   308: goto -104 -> 204
    //   311: new 344	java/util/HashMap
    //   314: dup
    //   315: invokespecial 345	java/util/HashMap:<init>	()V
    //   318: astore 14
    //   320: aload 9
    //   322: invokeinterface 171 1 0
    //   327: pop
    //   328: aload 9
    //   330: invokeinterface 174 1 0
    //   335: ifne +886 -> 1221
    //   338: aload 9
    //   340: iconst_0
    //   341: invokeinterface 181 2 0
    //   346: astore 11
    //   348: aload 9
    //   350: iconst_1
    //   351: invokeinterface 181 2 0
    //   356: astore 15
    //   358: aload 9
    //   360: iconst_2
    //   361: invokeinterface 197 2 0
    //   366: lstore_1
    //   367: aload 9
    //   369: iconst_3
    //   370: invokeinterface 181 2 0
    //   375: astore 10
    //   377: aload 9
    //   379: iconst_4
    //   380: invokeinterface 204 2 0
    //   385: istore 4
    //   387: aload 9
    //   389: iconst_5
    //   390: invokeinterface 204 2 0
    //   395: pop
    //   396: iload 4
    //   398: iconst_3
    //   399: if_icmpeq +407 -> 806
    //   402: iload 4
    //   404: iconst_2
    //   405: if_icmpeq +401 -> 806
    //   408: iconst_1
    //   409: istore 4
    //   411: aload 10
    //   413: astore 8
    //   415: aload 11
    //   417: ldc_w 355
    //   420: invokevirtual 359	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   423: ifne +63 -> 486
    //   426: aload 10
    //   428: astore 8
    //   430: aload 10
    //   432: ldc_w 361
    //   435: invokevirtual 365	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   438: ifne +48 -> 486
    //   441: aload 10
    //   443: astore 8
    //   445: aload 10
    //   447: ldc_w 367
    //   450: invokevirtual 365	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   453: ifne +33 -> 486
    //   456: aload 10
    //   458: astore 8
    //   460: aload 10
    //   462: ldc_w 369
    //   465: invokevirtual 365	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   468: ifne +18 -> 486
    //   471: aload 11
    //   473: ldc_w 371
    //   476: invokevirtual 359	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   479: ifeq +345 -> 824
    //   482: aload 10
    //   484: astore 8
    //   486: aload 8
    //   488: ldc 11
    //   490: invokevirtual 374	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   493: ifeq +421 -> 914
    //   496: aload 13
    //   498: new 176	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   505: ldc 11
    //   507: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: iload 4
    //   512: invokevirtual 207	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   515: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokevirtual 377	java/util/Properties:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   521: checkcast 100	java/lang/String
    //   524: astore 10
    //   526: aload 14
    //   528: aload 15
    //   530: invokevirtual 380	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   533: ifeq +523 -> 1056
    //   536: aload 10
    //   538: ifnonnull +432 -> 970
    //   541: new 176	java/lang/StringBuilder
    //   544: dup
    //   545: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   548: astore 16
    //   550: iload 4
    //   552: iconst_1
    //   553: if_icmpne +942 -> 1495
    //   556: ldc_w 392
    //   559: astore 11
    //   561: aload 16
    //   563: aload 11
    //   565: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: aload 8
    //   570: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: ldc_w 394
    //   576: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   582: astore 8
    //   584: aload 14
    //   586: aload 15
    //   588: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   591: checkcast 344	java/util/HashMap
    //   594: aload 8
    //   596: invokevirtual 380	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   599: ifeq +348 -> 947
    //   602: aload 14
    //   604: aload 15
    //   606: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   609: checkcast 344	java/util/HashMap
    //   612: aload 8
    //   614: aload 14
    //   616: aload 15
    //   618: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   621: checkcast 344	java/util/HashMap
    //   624: aload 8
    //   626: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   629: checkcast 209	java/lang/Long
    //   632: invokevirtual 397	java/lang/Long:longValue	()J
    //   635: lload_1
    //   636: ladd
    //   637: invokestatic 212	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   640: invokevirtual 400	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   643: pop
    //   644: iload_3
    //   645: ifeq +19 -> 664
    //   648: aload 10
    //   650: ifnull +14 -> 664
    //   653: aload 10
    //   655: ldc_w 392
    //   658: invokevirtual 374	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   661: ifne +18 -> 679
    //   664: iload_3
    //   665: ifeq +77 -> 742
    //   668: aload 8
    //   670: ldc_w 392
    //   673: invokevirtual 374	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   676: ifeq +66 -> 742
    //   679: aload 14
    //   681: aload 15
    //   683: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   686: checkcast 344	java/util/HashMap
    //   689: ldc_w 402
    //   692: invokevirtual 380	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   695: ifeq +502 -> 1197
    //   698: aload 14
    //   700: aload 15
    //   702: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   705: checkcast 344	java/util/HashMap
    //   708: ldc_w 402
    //   711: aload 14
    //   713: aload 15
    //   715: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   718: checkcast 344	java/util/HashMap
    //   721: ldc_w 402
    //   724: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   727: checkcast 209	java/lang/Long
    //   730: invokevirtual 397	java/lang/Long:longValue	()J
    //   733: lload_1
    //   734: ladd
    //   735: invokestatic 212	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   738: invokevirtual 400	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   741: pop
    //   742: aload 9
    //   744: invokeinterface 227 1 0
    //   749: pop
    //   750: goto -422 -> 328
    //   753: astore 10
    //   755: aload 9
    //   757: astore 8
    //   759: aload 10
    //   761: astore 9
    //   763: ldc 8
    //   765: iconst_1
    //   766: new 176	java/lang/StringBuilder
    //   769: dup
    //   770: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   773: ldc_w 429
    //   776: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: aload 9
    //   781: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   784: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   787: aload 9
    //   789: invokestatic 235	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   792: aload 8
    //   794: ifnull +10 -> 804
    //   797: aload 8
    //   799: invokeinterface 131 1 0
    //   804: aconst_null
    //   805: areturn
    //   806: iload 4
    //   808: iconst_2
    //   809: if_icmpeq +9 -> 818
    //   812: iload 4
    //   814: iconst_3
    //   815: if_icmpne +677 -> 1492
    //   818: iconst_2
    //   819: istore 4
    //   821: goto -410 -> 411
    //   824: aload 11
    //   826: ldc_w 406
    //   829: invokevirtual 359	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   832: ifeq +11 -> 843
    //   835: ldc_w 408
    //   838: astore 8
    //   840: goto -354 -> 486
    //   843: aload 10
    //   845: astore 8
    //   847: aload 11
    //   849: ldc_w 410
    //   852: invokevirtual 414	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   855: ifeq -369 -> 486
    //   858: aload 11
    //   860: ldc_w 410
    //   863: invokevirtual 418	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   866: istore 5
    //   868: new 176	java/lang/StringBuilder
    //   871: dup
    //   872: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   875: aload 11
    //   877: iload 5
    //   879: iconst_1
    //   880: iadd
    //   881: iload 5
    //   883: iconst_2
    //   884: iadd
    //   885: invokevirtual 422	java/lang/String:substring	(II)Ljava/lang/String;
    //   888: invokevirtual 425	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   891: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: aload 11
    //   896: iload 5
    //   898: iconst_2
    //   899: iadd
    //   900: invokevirtual 427	java/lang/String:substring	(I)Ljava/lang/String;
    //   903: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   909: astore 8
    //   911: goto -425 -> 486
    //   914: aload 13
    //   916: new 176	java/lang/StringBuilder
    //   919: dup
    //   920: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   923: aload 8
    //   925: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: iload 4
    //   930: invokevirtual 207	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   933: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   936: invokevirtual 377	java/util/Properties:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   939: checkcast 100	java/lang/String
    //   942: astore 10
    //   944: goto -418 -> 526
    //   947: aload 14
    //   949: aload 15
    //   951: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   954: checkcast 344	java/util/HashMap
    //   957: aload 8
    //   959: lload_1
    //   960: invokestatic 212	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   963: invokevirtual 400	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   966: pop
    //   967: goto -323 -> 644
    //   970: aload 14
    //   972: aload 15
    //   974: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   977: checkcast 344	java/util/HashMap
    //   980: aload 10
    //   982: invokevirtual 380	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   985: ifeq +48 -> 1033
    //   988: aload 14
    //   990: aload 15
    //   992: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   995: checkcast 344	java/util/HashMap
    //   998: aload 10
    //   1000: aload 14
    //   1002: aload 15
    //   1004: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1007: checkcast 344	java/util/HashMap
    //   1010: aload 10
    //   1012: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1015: checkcast 209	java/lang/Long
    //   1018: invokevirtual 397	java/lang/Long:longValue	()J
    //   1021: lload_1
    //   1022: ladd
    //   1023: invokestatic 212	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1026: invokevirtual 400	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1029: pop
    //   1030: goto -386 -> 644
    //   1033: aload 14
    //   1035: aload 15
    //   1037: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1040: checkcast 344	java/util/HashMap
    //   1043: aload 10
    //   1045: lload_1
    //   1046: invokestatic 212	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1049: invokevirtual 400	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1052: pop
    //   1053: goto -409 -> 644
    //   1056: aload 10
    //   1058: ifnonnull +105 -> 1163
    //   1061: new 176	java/lang/StringBuilder
    //   1064: dup
    //   1065: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   1068: astore 16
    //   1070: iload 4
    //   1072: iconst_1
    //   1073: if_icmpne +82 -> 1155
    //   1076: ldc_w 392
    //   1079: astore 11
    //   1081: aload 16
    //   1083: aload 11
    //   1085: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1088: aload 8
    //   1090: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1093: ldc_w 394
    //   1096: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1102: astore 8
    //   1104: new 344	java/util/HashMap
    //   1107: dup
    //   1108: invokespecial 345	java/util/HashMap:<init>	()V
    //   1111: astore 11
    //   1113: aload 11
    //   1115: aload 8
    //   1117: lload_1
    //   1118: invokestatic 212	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1121: invokevirtual 400	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1124: pop
    //   1125: aload 14
    //   1127: aload 15
    //   1129: aload 11
    //   1131: invokevirtual 400	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1134: pop
    //   1135: goto -491 -> 644
    //   1138: astore 8
    //   1140: aload 9
    //   1142: ifnull +10 -> 1152
    //   1145: aload 9
    //   1147: invokeinterface 131 1 0
    //   1152: aload 8
    //   1154: athrow
    //   1155: ldc_w 462
    //   1158: astore 11
    //   1160: goto -79 -> 1081
    //   1163: new 344	java/util/HashMap
    //   1166: dup
    //   1167: invokespecial 345	java/util/HashMap:<init>	()V
    //   1170: astore 11
    //   1172: aload 11
    //   1174: aload 10
    //   1176: lload_1
    //   1177: invokestatic 212	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1180: invokevirtual 400	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1183: pop
    //   1184: aload 14
    //   1186: aload 15
    //   1188: aload 11
    //   1190: invokevirtual 400	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1193: pop
    //   1194: goto -550 -> 644
    //   1197: aload 14
    //   1199: aload 15
    //   1201: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1204: checkcast 344	java/util/HashMap
    //   1207: ldc_w 402
    //   1210: lload_1
    //   1211: invokestatic 212	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1214: invokevirtual 400	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1217: pop
    //   1218: goto -476 -> 742
    //   1221: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1224: ifeq +219 -> 1443
    //   1227: aload 14
    //   1229: invokevirtual 434	java/util/HashMap:keySet	()Ljava/util/Set;
    //   1232: invokeinterface 440 1 0
    //   1237: astore 8
    //   1239: aload 8
    //   1241: invokeinterface 445 1 0
    //   1246: ifeq +197 -> 1443
    //   1249: aload 8
    //   1251: invokeinterface 449 1 0
    //   1256: checkcast 100	java/lang/String
    //   1259: astore 10
    //   1261: aload 14
    //   1263: aload 10
    //   1265: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1268: checkcast 344	java/util/HashMap
    //   1271: invokevirtual 434	java/util/HashMap:keySet	()Ljava/util/Set;
    //   1274: invokeinterface 440 1 0
    //   1279: astore 11
    //   1281: aload 11
    //   1283: invokeinterface 445 1 0
    //   1288: ifeq -49 -> 1239
    //   1291: aload 11
    //   1293: invokeinterface 449 1 0
    //   1298: checkcast 100	java/lang/String
    //   1301: astore 13
    //   1303: iload_3
    //   1304: ifeq +71 -> 1375
    //   1307: ldc 8
    //   1309: iconst_2
    //   1310: new 176	java/lang/StringBuilder
    //   1313: dup
    //   1314: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   1317: ldc_w 654
    //   1320: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1323: aload 10
    //   1325: invokestatic 193	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   1328: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1331: ldc_w 453
    //   1334: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1337: aload 13
    //   1339: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1342: ldc_w 455
    //   1345: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1348: aload 14
    //   1350: aload 10
    //   1352: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1355: checkcast 344	java/util/HashMap
    //   1358: aload 13
    //   1360: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1363: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1366: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1369: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1372: goto -91 -> 1281
    //   1375: ldc 8
    //   1377: iconst_2
    //   1378: new 176	java/lang/StringBuilder
    //   1381: dup
    //   1382: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   1385: ldc_w 457
    //   1388: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: aload 10
    //   1393: invokestatic 193	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   1396: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1399: ldc_w 453
    //   1402: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1405: aload 13
    //   1407: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1410: ldc_w 455
    //   1413: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1416: aload 14
    //   1418: aload 10
    //   1420: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1423: checkcast 344	java/util/HashMap
    //   1426: aload 13
    //   1428: invokevirtual 381	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1431: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1434: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1437: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1440: goto -159 -> 1281
    //   1443: aload 12
    //   1445: invokevirtual 460	java/io/InputStream:close	()V
    //   1448: aload 9
    //   1450: ifnull +10 -> 1460
    //   1453: aload 9
    //   1455: invokeinterface 131 1 0
    //   1460: aload 14
    //   1462: areturn
    //   1463: astore 8
    //   1465: aconst_null
    //   1466: astore 9
    //   1468: goto -328 -> 1140
    //   1471: astore 10
    //   1473: aload 8
    //   1475: astore 9
    //   1477: aload 10
    //   1479: astore 8
    //   1481: goto -341 -> 1140
    //   1484: astore 9
    //   1486: aconst_null
    //   1487: astore 8
    //   1489: goto -726 -> 763
    //   1492: goto -1081 -> 411
    //   1495: ldc_w 462
    //   1498: astore 11
    //   1500: goto -939 -> 561
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1503	0	this	c
    //   0	1503	1	paramLong	long
    //   0	1503	3	paramBoolean	boolean
    //   385	689	4	i1	int
    //   866	34	5	i2	int
    //   94	187	6	l1	long
    //   33	1083	8	localObject1	Object
    //   1138	15	8	localObject2	Object
    //   1237	13	8	localIterator	Iterator
    //   1463	11	8	localObject3	Object
    //   1479	9	8	localObject4	Object
    //   202	1274	9	localObject5	Object
    //   1484	1	9	localException1	Exception
    //   375	279	10	str1	String
    //   753	91	10	localException2	Exception
    //   942	477	10	str2	String
    //   1471	7	10	localObject6	Object
    //   346	1153	11	localObject7	Object
    //   12	1432	12	localInputStream	java.io.InputStream
    //   21	1406	13	localObject8	Object
    //   318	1143	14	localHashMap	java.util.HashMap
    //   356	844	15	str3	String
    //   548	534	16	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   311	328	753	java/lang/Exception
    //   328	396	753	java/lang/Exception
    //   415	426	753	java/lang/Exception
    //   430	441	753	java/lang/Exception
    //   445	456	753	java/lang/Exception
    //   460	482	753	java/lang/Exception
    //   486	526	753	java/lang/Exception
    //   526	536	753	java/lang/Exception
    //   541	550	753	java/lang/Exception
    //   561	644	753	java/lang/Exception
    //   653	664	753	java/lang/Exception
    //   668	679	753	java/lang/Exception
    //   679	742	753	java/lang/Exception
    //   742	750	753	java/lang/Exception
    //   824	835	753	java/lang/Exception
    //   847	911	753	java/lang/Exception
    //   914	944	753	java/lang/Exception
    //   947	967	753	java/lang/Exception
    //   970	1030	753	java/lang/Exception
    //   1033	1053	753	java/lang/Exception
    //   1061	1070	753	java/lang/Exception
    //   1081	1135	753	java/lang/Exception
    //   1163	1194	753	java/lang/Exception
    //   1197	1218	753	java/lang/Exception
    //   1221	1239	753	java/lang/Exception
    //   1239	1281	753	java/lang/Exception
    //   1281	1303	753	java/lang/Exception
    //   1307	1372	753	java/lang/Exception
    //   1375	1440	753	java/lang/Exception
    //   1443	1448	753	java/lang/Exception
    //   311	328	1138	finally
    //   328	396	1138	finally
    //   415	426	1138	finally
    //   430	441	1138	finally
    //   445	456	1138	finally
    //   460	482	1138	finally
    //   486	526	1138	finally
    //   526	536	1138	finally
    //   541	550	1138	finally
    //   561	644	1138	finally
    //   653	664	1138	finally
    //   668	679	1138	finally
    //   679	742	1138	finally
    //   742	750	1138	finally
    //   824	835	1138	finally
    //   847	911	1138	finally
    //   914	944	1138	finally
    //   947	967	1138	finally
    //   970	1030	1138	finally
    //   1033	1053	1138	finally
    //   1061	1070	1138	finally
    //   1081	1135	1138	finally
    //   1163	1194	1138	finally
    //   1197	1218	1138	finally
    //   1221	1239	1138	finally
    //   1239	1281	1138	finally
    //   1281	1303	1138	finally
    //   1307	1372	1138	finally
    //   1375	1440	1138	finally
    //   1443	1448	1138	finally
    //   0	89	1463	finally
    //   96	115	1463	finally
    //   115	130	1463	finally
    //   134	204	1463	finally
    //   223	308	1463	finally
    //   763	792	1471	finally
    //   0	89	1484	java/lang/Exception
    //   96	115	1484	java/lang/Exception
    //   115	130	1484	java/lang/Exception
    //   134	204	1484	java/lang/Exception
    //   223	308	1484	java/lang/Exception
  }
  
  public void onReceive(Context paramContext, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.b.c
 * JD-Core Version:    0.7.0.1
 */