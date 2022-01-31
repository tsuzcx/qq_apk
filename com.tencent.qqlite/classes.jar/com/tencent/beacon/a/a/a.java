package com.tencent.beacon.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

public class a
{
  private long a = -1L;
  private int b = -1;
  private int c = -1;
  private long d = -1L;
  private byte[] e = null;
  private long f = 0L;
  
  public a() {}
  
  public a(int paramInt1, int paramInt2, long paramLong, byte[] paramArrayOfByte)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramLong;
    this.e = paramArrayOfByte;
    if (paramArrayOfByte != null) {
      this.f = paramArrayOfByte.length;
    }
  }
  
  /* Error */
  public static int a(android.content.Context paramContext, int[] paramArrayOfInt, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: iconst_0
    //   4: istore 6
    //   6: ldc 38
    //   8: iconst_0
    //   9: anewarray 4	java/lang/Object
    //   12: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   15: aload_0
    //   16: ifnonnull +18 -> 34
    //   19: ldc 45
    //   21: iconst_0
    //   22: anewarray 4	java/lang/Object
    //   25: invokestatic 47	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: iconst_m1
    //   29: istore 6
    //   31: iload 6
    //   33: ireturn
    //   34: lload_2
    //   35: lload 4
    //   37: lcmp
    //   38: ifgt -7 -> 31
    //   41: new 49	java/lang/StringBuilder
    //   44: dup
    //   45: ldc 51
    //   47: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: lload_2
    //   51: invokevirtual 58	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   54: ldc 60
    //   56: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 65
    //   61: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: lload 4
    //   66: invokevirtual 58	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   69: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore 9
    //   74: aload_1
    //   75: ifnull +355 -> 430
    //   78: aload_1
    //   79: arraylength
    //   80: ifle +350 -> 430
    //   83: ldc 71
    //   85: astore 7
    //   87: iconst_0
    //   88: istore 6
    //   90: iload 6
    //   92: aload_1
    //   93: arraylength
    //   94: if_icmpge +41 -> 135
    //   97: new 49	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   104: aload 7
    //   106: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 74
    //   111: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_1
    //   115: iload 6
    //   117: iaload
    //   118: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: astore 7
    //   126: iload 6
    //   128: iconst_1
    //   129: iadd
    //   130: istore 6
    //   132: goto -42 -> 90
    //   135: aload 7
    //   137: iconst_4
    //   138: invokevirtual 83	java/lang/String:substring	(I)Ljava/lang/String;
    //   141: astore_1
    //   142: new 49	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   149: aload 9
    //   151: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc 85
    //   156: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_1
    //   160: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: ldc 87
    //   165: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: astore_1
    //   172: new 49	java/lang/StringBuilder
    //   175: dup
    //   176: ldc 89
    //   178: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   181: aload_1
    //   182: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: iconst_0
    //   189: anewarray 4	java/lang/Object
    //   192: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: aload_0
    //   196: invokestatic 94	com/tencent/beacon/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/c;
    //   199: astore_0
    //   200: aload_0
    //   201: invokevirtual 98	com/tencent/beacon/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   204: astore 7
    //   206: aload 7
    //   208: ldc 100
    //   210: aload_1
    //   211: aconst_null
    //   212: invokevirtual 106	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   215: istore 6
    //   217: new 49	java/lang/StringBuilder
    //   220: dup
    //   221: ldc 108
    //   223: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   226: iload 6
    //   228: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   231: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: iconst_0
    //   235: anewarray 4	java/lang/Object
    //   238: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   241: aload 7
    //   243: ifnull +16 -> 259
    //   246: aload 7
    //   248: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   251: ifeq +8 -> 259
    //   254: aload 7
    //   256: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   259: aload_0
    //   260: ifnull +7 -> 267
    //   263: aload_0
    //   264: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   267: ldc 118
    //   269: iconst_0
    //   270: anewarray 4	java/lang/Object
    //   273: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   276: iload 6
    //   278: ireturn
    //   279: astore 7
    //   281: aconst_null
    //   282: astore_0
    //   283: aload 8
    //   285: astore_1
    //   286: aload 7
    //   288: astore 8
    //   290: aload 8
    //   292: invokevirtual 121	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   295: iconst_0
    //   296: anewarray 4	java/lang/Object
    //   299: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   302: aload_0
    //   303: ifnull +14 -> 317
    //   306: aload_0
    //   307: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   310: ifeq +7 -> 317
    //   313: aload_0
    //   314: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   317: aload_1
    //   318: ifnull +7 -> 325
    //   321: aload_1
    //   322: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   325: ldc 118
    //   327: iconst_0
    //   328: anewarray 4	java/lang/Object
    //   331: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   334: iconst_m1
    //   335: ireturn
    //   336: astore_1
    //   337: aconst_null
    //   338: astore 7
    //   340: aconst_null
    //   341: astore_0
    //   342: aload 7
    //   344: ifnull +16 -> 360
    //   347: aload 7
    //   349: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   352: ifeq +8 -> 360
    //   355: aload 7
    //   357: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   360: aload_0
    //   361: ifnull +7 -> 368
    //   364: aload_0
    //   365: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   368: ldc 118
    //   370: iconst_0
    //   371: anewarray 4	java/lang/Object
    //   374: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   377: aload_1
    //   378: athrow
    //   379: astore_1
    //   380: aconst_null
    //   381: astore 7
    //   383: goto -41 -> 342
    //   386: astore_1
    //   387: goto -45 -> 342
    //   390: astore 7
    //   392: aload_1
    //   393: astore 8
    //   395: aload 7
    //   397: astore_1
    //   398: aload_0
    //   399: astore 7
    //   401: aload 8
    //   403: astore_0
    //   404: goto -62 -> 342
    //   407: astore 8
    //   409: aconst_null
    //   410: astore 7
    //   412: aload_0
    //   413: astore_1
    //   414: aload 7
    //   416: astore_0
    //   417: goto -127 -> 290
    //   420: astore 8
    //   422: aload_0
    //   423: astore_1
    //   424: aload 7
    //   426: astore_0
    //   427: goto -137 -> 290
    //   430: aload 9
    //   432: astore_1
    //   433: goto -261 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	436	0	paramContext	android.content.Context
    //   0	436	1	paramArrayOfInt	int[]
    //   0	436	2	paramLong1	long
    //   0	436	4	paramLong2	long
    //   4	273	6	i	int
    //   85	170	7	localObject1	Object
    //   279	8	7	localThrowable1	java.lang.Throwable
    //   338	44	7	localObject2	Object
    //   390	6	7	localObject3	Object
    //   399	26	7	localContext	android.content.Context
    //   1	401	8	localObject4	Object
    //   407	1	8	localThrowable2	java.lang.Throwable
    //   420	1	8	localThrowable3	java.lang.Throwable
    //   72	359	9	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   195	200	279	java/lang/Throwable
    //   195	200	336	finally
    //   200	206	379	finally
    //   206	241	386	finally
    //   290	302	390	finally
    //   200	206	407	java/lang/Throwable
    //   206	241	420	java/lang/Throwable
  }
  
  /* Error */
  public static int a(android.content.Context paramContext, Long[] paramArrayOfLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 10
    //   9: aconst_null
    //   10: astore 9
    //   12: ldc 124
    //   14: iconst_0
    //   15: anewarray 4	java/lang/Object
    //   18: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   21: aload_0
    //   22: ifnonnull +14 -> 36
    //   25: ldc 126
    //   27: iconst_0
    //   28: anewarray 4	java/lang/Object
    //   31: invokestatic 128	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: iconst_m1
    //   35: ireturn
    //   36: aload_1
    //   37: ifnull +8 -> 45
    //   40: aload_1
    //   41: arraylength
    //   42: ifgt +5 -> 47
    //   45: iconst_0
    //   46: ireturn
    //   47: aload_0
    //   48: invokestatic 94	com/tencent/beacon/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/c;
    //   51: astore_0
    //   52: aload_0
    //   53: astore 8
    //   55: aload 7
    //   57: astore_0
    //   58: aload 8
    //   60: astore 7
    //   62: aload 10
    //   64: astore 9
    //   66: aload 8
    //   68: invokevirtual 98	com/tencent/beacon/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   71: astore 10
    //   73: aload 10
    //   75: astore_0
    //   76: aload 8
    //   78: astore 7
    //   80: aload 10
    //   82: astore 9
    //   84: new 130	java/lang/StringBuffer
    //   87: dup
    //   88: invokespecial 131	java/lang/StringBuffer:<init>	()V
    //   91: astore 11
    //   93: iconst_0
    //   94: istore_2
    //   95: iconst_0
    //   96: istore_3
    //   97: aload 10
    //   99: astore_0
    //   100: aload 8
    //   102: astore 7
    //   104: aload 10
    //   106: astore 9
    //   108: iload_3
    //   109: aload_1
    //   110: arraylength
    //   111: if_icmpge +191 -> 302
    //   114: aload 10
    //   116: astore_0
    //   117: aload 8
    //   119: astore 7
    //   121: aload 10
    //   123: astore 9
    //   125: aload_1
    //   126: iload_3
    //   127: aaload
    //   128: invokevirtual 137	java/lang/Long:longValue	()J
    //   131: lstore 5
    //   133: aload 10
    //   135: astore_0
    //   136: aload 8
    //   138: astore 7
    //   140: aload 10
    //   142: astore 9
    //   144: aload 11
    //   146: new 49	java/lang/StringBuilder
    //   149: dup
    //   150: ldc 139
    //   152: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   155: lload 5
    //   157: invokevirtual 58	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   160: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokevirtual 142	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   166: pop
    //   167: iload_2
    //   168: istore 4
    //   170: iload_3
    //   171: ifle +382 -> 553
    //   174: iload_2
    //   175: istore 4
    //   177: iload_3
    //   178: bipush 25
    //   180: irem
    //   181: ifne +372 -> 553
    //   184: aload 10
    //   186: astore_0
    //   187: aload 8
    //   189: astore 7
    //   191: aload 10
    //   193: astore 9
    //   195: new 49	java/lang/StringBuilder
    //   198: dup
    //   199: ldc 144
    //   201: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   204: iload_3
    //   205: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   208: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: iconst_0
    //   212: anewarray 4	java/lang/Object
    //   215: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   218: aload 10
    //   220: astore_0
    //   221: aload 8
    //   223: astore 7
    //   225: aload 10
    //   227: astore 9
    //   229: iload_2
    //   230: aload 10
    //   232: ldc 100
    //   234: aload 11
    //   236: iconst_4
    //   237: invokevirtual 145	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   240: aconst_null
    //   241: invokevirtual 106	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   244: iadd
    //   245: istore 4
    //   247: aload 10
    //   249: astore_0
    //   250: aload 8
    //   252: astore 7
    //   254: aload 10
    //   256: astore 9
    //   258: aload 11
    //   260: iconst_0
    //   261: invokevirtual 149	java/lang/StringBuffer:setLength	(I)V
    //   264: aload 10
    //   266: astore_0
    //   267: aload 8
    //   269: astore 7
    //   271: aload 10
    //   273: astore 9
    //   275: new 49	java/lang/StringBuilder
    //   278: dup
    //   279: ldc 151
    //   281: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   284: iload 4
    //   286: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   289: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: iconst_0
    //   293: anewarray 4	java/lang/Object
    //   296: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   299: goto +254 -> 553
    //   302: iload_2
    //   303: istore_3
    //   304: aload 10
    //   306: astore_0
    //   307: aload 8
    //   309: astore 7
    //   311: aload 10
    //   313: astore 9
    //   315: aload 11
    //   317: invokevirtual 155	java/lang/StringBuffer:length	()I
    //   320: ifle +48 -> 368
    //   323: aload 10
    //   325: astore_0
    //   326: aload 8
    //   328: astore 7
    //   330: aload 10
    //   332: astore 9
    //   334: iload_2
    //   335: aload 10
    //   337: ldc 100
    //   339: aload 11
    //   341: iconst_4
    //   342: invokevirtual 145	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   345: aconst_null
    //   346: invokevirtual 106	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   349: iadd
    //   350: istore_3
    //   351: aload 10
    //   353: astore_0
    //   354: aload 8
    //   356: astore 7
    //   358: aload 10
    //   360: astore 9
    //   362: aload 11
    //   364: iconst_0
    //   365: invokevirtual 149	java/lang/StringBuffer:setLength	(I)V
    //   368: aload 10
    //   370: astore_0
    //   371: aload 8
    //   373: astore 7
    //   375: aload 10
    //   377: astore 9
    //   379: new 49	java/lang/StringBuilder
    //   382: dup
    //   383: ldc 157
    //   385: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   388: iload_3
    //   389: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   392: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: iconst_0
    //   396: anewarray 4	java/lang/Object
    //   399: invokestatic 47	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   402: aload 10
    //   404: ifnull +16 -> 420
    //   407: aload 10
    //   409: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   412: ifeq +8 -> 420
    //   415: aload 10
    //   417: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   420: aload 8
    //   422: ifnull +8 -> 430
    //   425: aload 8
    //   427: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   430: ldc 159
    //   432: iconst_0
    //   433: anewarray 4	java/lang/Object
    //   436: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   439: iload_3
    //   440: ireturn
    //   441: astore_1
    //   442: aconst_null
    //   443: astore 8
    //   445: aload 9
    //   447: astore_0
    //   448: aload 8
    //   450: astore 7
    //   452: aload_1
    //   453: invokevirtual 121	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   456: iconst_0
    //   457: anewarray 4	java/lang/Object
    //   460: invokestatic 128	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   463: aload 9
    //   465: ifnull +16 -> 481
    //   468: aload 9
    //   470: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   473: ifeq +8 -> 481
    //   476: aload 9
    //   478: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   481: aload 8
    //   483: ifnull +8 -> 491
    //   486: aload 8
    //   488: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   491: ldc 159
    //   493: iconst_0
    //   494: anewarray 4	java/lang/Object
    //   497: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   500: iconst_m1
    //   501: ireturn
    //   502: astore_1
    //   503: aconst_null
    //   504: astore 7
    //   506: aload 8
    //   508: astore_0
    //   509: aload_0
    //   510: ifnull +14 -> 524
    //   513: aload_0
    //   514: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   517: ifeq +7 -> 524
    //   520: aload_0
    //   521: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   524: aload 7
    //   526: ifnull +8 -> 534
    //   529: aload 7
    //   531: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   534: ldc 159
    //   536: iconst_0
    //   537: anewarray 4	java/lang/Object
    //   540: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   543: aload_1
    //   544: athrow
    //   545: astore_1
    //   546: goto -37 -> 509
    //   549: astore_1
    //   550: goto -105 -> 445
    //   553: iload_3
    //   554: iconst_1
    //   555: iadd
    //   556: istore_3
    //   557: iload 4
    //   559: istore_2
    //   560: goto -463 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	563	0	paramContext	android.content.Context
    //   0	563	1	paramArrayOfLong	Long[]
    //   94	466	2	i	int
    //   96	461	3	j	int
    //   168	390	4	k	int
    //   131	25	5	l	long
    //   4	526	7	localContext1	android.content.Context
    //   1	506	8	localContext2	android.content.Context
    //   10	467	9	localSQLiteDatabase1	android.database.sqlite.SQLiteDatabase
    //   7	409	10	localSQLiteDatabase2	android.database.sqlite.SQLiteDatabase
    //   91	272	11	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   47	52	441	java/lang/Throwable
    //   47	52	502	finally
    //   66	73	545	finally
    //   84	93	545	finally
    //   108	114	545	finally
    //   125	133	545	finally
    //   144	167	545	finally
    //   195	218	545	finally
    //   229	247	545	finally
    //   258	264	545	finally
    //   275	299	545	finally
    //   315	323	545	finally
    //   334	351	545	finally
    //   362	368	545	finally
    //   379	402	545	finally
    //   452	463	545	finally
    //   66	73	549	java/lang/Throwable
    //   84	93	549	java/lang/Throwable
    //   108	114	549	java/lang/Throwable
    //   125	133	549	java/lang/Throwable
    //   144	167	549	java/lang/Throwable
    //   195	218	549	java/lang/Throwable
    //   229	247	549	java/lang/Throwable
    //   258	264	549	java/lang/Throwable
    //   275	299	549	java/lang/Throwable
    //   315	323	549	java/lang/Throwable
    //   334	351	549	java/lang/Throwable
    //   362	368	549	java/lang/Throwable
    //   379	402	549	java/lang/Throwable
  }
  
  public static ContentValues a(a parama)
  {
    ContentValues localContentValues = new ContentValues();
    if (parama.a > 0L) {
      localContentValues.put("_id", Long.valueOf(parama.a));
    }
    localContentValues.put("_prority", Integer.valueOf(parama.c));
    localContentValues.put("_time", Long.valueOf(parama.d));
    localContentValues.put("_type", Integer.valueOf(parama.b));
    localContentValues.put("_datas", parama.e);
    localContentValues.put("_length", Long.valueOf(parama.f));
    return localContentValues;
  }
  
  /* Error */
  public static List<a> a(android.content.Context paramContext, int[] paramArrayOfInt, int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong2, long paramLong3)
  {
    // Byte code:
    //   0: ldc 197
    //   2: iconst_0
    //   3: anewarray 4	java/lang/Object
    //   6: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   9: aload_0
    //   10: ifnull +49 -> 59
    //   13: lload 4
    //   15: lconst_0
    //   16: lcmp
    //   17: ifeq +42 -> 59
    //   20: lload 13
    //   22: lconst_0
    //   23: lcmp
    //   24: ifle +11 -> 35
    //   27: lload 11
    //   29: lload 13
    //   31: lcmp
    //   32: ifgt +27 -> 59
    //   35: iload 8
    //   37: ifle +10 -> 47
    //   40: iload 7
    //   42: iload 8
    //   44: if_icmpgt +15 -> 59
    //   47: iload 10
    //   49: ifle +21 -> 70
    //   52: iload 9
    //   54: iload 10
    //   56: if_icmple +14 -> 70
    //   59: ldc 199
    //   61: iconst_0
    //   62: anewarray 4	java/lang/Object
    //   65: invokestatic 128	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   68: aconst_null
    //   69: areturn
    //   70: lload 4
    //   72: lstore 15
    //   74: lload 4
    //   76: lconst_0
    //   77: lcmp
    //   78: ifge +8 -> 86
    //   81: ldc2_w 200
    //   84: lstore 15
    //   86: aload_1
    //   87: ifnull +1722 -> 1809
    //   90: aload_1
    //   91: arraylength
    //   92: ifle +1717 -> 1809
    //   95: ldc 71
    //   97: astore 17
    //   99: iconst_0
    //   100: istore 7
    //   102: iload 7
    //   104: aload_1
    //   105: arraylength
    //   106: if_icmpge +41 -> 147
    //   109: new 49	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   116: aload 17
    //   118: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc 74
    //   123: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_1
    //   127: iload 7
    //   129: iaload
    //   130: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   133: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: astore 17
    //   138: iload 7
    //   140: iconst_1
    //   141: iadd
    //   142: istore 7
    //   144: goto -42 -> 102
    //   147: new 49	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   154: ldc 71
    //   156: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload 17
    //   161: iconst_4
    //   162: invokevirtual 83	java/lang/String:substring	(I)Ljava/lang/String;
    //   165: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: astore_1
    //   172: aload_1
    //   173: invokevirtual 202	java/lang/String:length	()I
    //   176: ifle +565 -> 741
    //   179: new 49	java/lang/StringBuilder
    //   182: dup
    //   183: ldc 204
    //   185: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   188: aload_1
    //   189: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: ldc 206
    //   194: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: astore 17
    //   202: aload 17
    //   204: astore_1
    //   205: lload 11
    //   207: lconst_0
    //   208: lcmp
    //   209: iflt +53 -> 262
    //   212: new 49	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   219: aload 17
    //   221: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: astore 18
    //   226: aload 17
    //   228: invokevirtual 202	java/lang/String:length	()I
    //   231: ifle +517 -> 748
    //   234: ldc 208
    //   236: astore_1
    //   237: aload 18
    //   239: aload_1
    //   240: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: ldc 51
    //   245: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: lload 11
    //   250: invokevirtual 58	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   253: ldc 210
    //   255: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: astore_1
    //   262: aload_1
    //   263: astore 18
    //   265: lload 13
    //   267: lconst_0
    //   268: lcmp
    //   269: iflt +52 -> 321
    //   272: new 49	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   279: aload_1
    //   280: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: astore 17
    //   285: aload_1
    //   286: invokevirtual 202	java/lang/String:length	()I
    //   289: ifle +465 -> 754
    //   292: ldc 208
    //   294: astore_1
    //   295: aload 17
    //   297: aload_1
    //   298: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: ldc 212
    //   303: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: lload 13
    //   308: invokevirtual 58	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   311: ldc 210
    //   313: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: astore 18
    //   321: ldc 71
    //   323: astore_1
    //   324: iload_2
    //   325: tableswitch	default:+23 -> 348, 1:+435->760, 2:+460->785
    //   349: tableswitch	default:+23 -> 372, 1:+461->810, 2:+485->834
    //   373: ldc 214
    //   375: invokevirtual 218	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   378: ifeq +1425 -> 1803
    //   381: aload_1
    //   382: iconst_0
    //   383: aload_1
    //   384: invokevirtual 202	java/lang/String:length	()I
    //   387: iconst_3
    //   388: isub
    //   389: invokevirtual 221	java/lang/String:substring	(II)Ljava/lang/String;
    //   392: astore 17
    //   394: ldc 223
    //   396: iconst_1
    //   397: anewarray 4	java/lang/Object
    //   400: dup
    //   401: iconst_0
    //   402: aload 18
    //   404: aastore
    //   405: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   408: aconst_null
    //   409: astore 21
    //   411: aconst_null
    //   412: astore 19
    //   414: aconst_null
    //   415: astore 20
    //   417: new 225	java/util/ArrayList
    //   420: dup
    //   421: invokespecial 226	java/util/ArrayList:<init>	()V
    //   424: astore 22
    //   426: aload_0
    //   427: invokestatic 94	com/tencent/beacon/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/c;
    //   430: astore_0
    //   431: aload_0
    //   432: invokevirtual 98	com/tencent/beacon/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   435: astore_1
    //   436: lload 15
    //   438: lconst_0
    //   439: lcmp
    //   440: ifle +1092 -> 1532
    //   443: aload 17
    //   445: astore 19
    //   447: aload 17
    //   449: invokevirtual 202	java/lang/String:length	()I
    //   452: ifle +25 -> 477
    //   455: new 49	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   462: aload 17
    //   464: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: ldc 214
    //   469: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: astore 19
    //   477: new 49	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   484: aload 19
    //   486: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: ldc 228
    //   491: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: astore 21
    //   499: iload 6
    //   501: iflt +357 -> 858
    //   504: new 49	java/lang/StringBuilder
    //   507: dup
    //   508: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   511: iload 6
    //   513: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   516: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: astore 17
    //   521: aload_1
    //   522: ldc 100
    //   524: iconst_2
    //   525: anewarray 79	java/lang/String
    //   528: dup
    //   529: iconst_0
    //   530: ldc 165
    //   532: aastore
    //   533: dup
    //   534: iconst_1
    //   535: ldc 194
    //   537: aastore
    //   538: aload 18
    //   540: aconst_null
    //   541: aconst_null
    //   542: aconst_null
    //   543: aload 21
    //   545: aload 17
    //   547: invokevirtual 232	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   550: astore 19
    //   552: aload 19
    //   554: astore 18
    //   556: aload 19
    //   558: astore 17
    //   560: aload 19
    //   562: ldc 165
    //   564: invokeinterface 238 2 0
    //   569: istore_2
    //   570: aload 19
    //   572: astore 18
    //   574: aload 19
    //   576: astore 17
    //   578: aload 19
    //   580: ldc 194
    //   582: invokeinterface 238 2 0
    //   587: istore_3
    //   588: aload 19
    //   590: astore 18
    //   592: aload 19
    //   594: astore 17
    //   596: new 240	java/util/LinkedHashMap
    //   599: dup
    //   600: invokespecial 241	java/util/LinkedHashMap:<init>	()V
    //   603: astore 20
    //   605: aload 19
    //   607: astore 18
    //   609: aload 19
    //   611: astore 17
    //   613: aload 19
    //   615: invokeinterface 244 1 0
    //   620: ifeq +244 -> 864
    //   623: aload 19
    //   625: astore 18
    //   627: aload 19
    //   629: astore 17
    //   631: aload 20
    //   633: aload 19
    //   635: iload_2
    //   636: invokeinterface 248 2 0
    //   641: invokestatic 169	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   644: aload 19
    //   646: iload_3
    //   647: invokeinterface 248 2 0
    //   652: invokestatic 169	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   655: invokevirtual 251	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   658: pop
    //   659: goto -54 -> 605
    //   662: astore 19
    //   664: aload_1
    //   665: astore 17
    //   667: aload 19
    //   669: astore_1
    //   670: aload_1
    //   671: invokevirtual 121	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   674: iconst_0
    //   675: anewarray 4	java/lang/Object
    //   678: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   681: aload 18
    //   683: ifnull +20 -> 703
    //   686: aload 18
    //   688: invokeinterface 254 1 0
    //   693: ifne +10 -> 703
    //   696: aload 18
    //   698: invokeinterface 255 1 0
    //   703: aload 17
    //   705: ifnull +16 -> 721
    //   708: aload 17
    //   710: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   713: ifeq +8 -> 721
    //   716: aload 17
    //   718: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   721: aload_0
    //   722: ifnull +7 -> 729
    //   725: aload_0
    //   726: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   729: ldc_w 257
    //   732: iconst_0
    //   733: anewarray 4	java/lang/Object
    //   736: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   739: aconst_null
    //   740: areturn
    //   741: ldc 71
    //   743: astore 17
    //   745: goto -543 -> 202
    //   748: ldc 71
    //   750: astore_1
    //   751: goto -514 -> 237
    //   754: ldc 71
    //   756: astore_1
    //   757: goto -462 -> 295
    //   760: new 49	java/lang/StringBuilder
    //   763: dup
    //   764: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   767: ldc 71
    //   769: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: ldc_w 259
    //   775: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   781: astore_1
    //   782: goto -434 -> 348
    //   785: new 49	java/lang/StringBuilder
    //   788: dup
    //   789: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   792: ldc 71
    //   794: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: ldc_w 261
    //   800: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   806: astore_1
    //   807: goto -459 -> 348
    //   810: new 49	java/lang/StringBuilder
    //   813: dup
    //   814: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   817: aload_1
    //   818: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: ldc_w 263
    //   824: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   830: astore_1
    //   831: goto -459 -> 372
    //   834: new 49	java/lang/StringBuilder
    //   837: dup
    //   838: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   841: aload_1
    //   842: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: ldc_w 265
    //   848: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   854: astore_1
    //   855: goto -483 -> 372
    //   858: aconst_null
    //   859: astore 17
    //   861: goto -340 -> 521
    //   864: aload 19
    //   866: astore 18
    //   868: aload 19
    //   870: astore 17
    //   872: aload 19
    //   874: invokeinterface 255 1 0
    //   879: aload 19
    //   881: astore 18
    //   883: aload 19
    //   885: astore 17
    //   887: aload 20
    //   889: lload 15
    //   891: invokestatic 270	com/tencent/beacon/b/a:a	(Ljava/util/LinkedHashMap;J)[Ljava/lang/Long;
    //   894: astore 20
    //   896: aload 20
    //   898: ifnull +577 -> 1475
    //   901: aload 19
    //   903: astore 18
    //   905: aload 19
    //   907: astore 17
    //   909: aload 20
    //   911: arraylength
    //   912: ifle +563 -> 1475
    //   915: aload 19
    //   917: astore 18
    //   919: aload 19
    //   921: astore 17
    //   923: new 49	java/lang/StringBuilder
    //   926: dup
    //   927: ldc_w 272
    //   930: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   933: aload 20
    //   935: arraylength
    //   936: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   939: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   942: iconst_0
    //   943: anewarray 4	java/lang/Object
    //   946: invokestatic 47	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   949: aload 19
    //   951: astore 18
    //   953: aload 19
    //   955: astore 17
    //   957: new 130	java/lang/StringBuffer
    //   960: dup
    //   961: invokespecial 131	java/lang/StringBuffer:<init>	()V
    //   964: astore 23
    //   966: iconst_0
    //   967: istore_2
    //   968: aload 19
    //   970: astore 18
    //   972: aload 19
    //   974: astore 17
    //   976: iload_2
    //   977: aload 20
    //   979: arraylength
    //   980: if_icmpge +225 -> 1205
    //   983: aload 19
    //   985: astore 18
    //   987: aload 19
    //   989: astore 17
    //   991: aload 20
    //   993: iload_2
    //   994: aaload
    //   995: invokevirtual 137	java/lang/Long:longValue	()J
    //   998: lstore 4
    //   1000: aload 19
    //   1002: astore 18
    //   1004: aload 19
    //   1006: astore 17
    //   1008: aload 23
    //   1010: new 49	java/lang/StringBuilder
    //   1013: dup
    //   1014: ldc 139
    //   1016: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1019: lload 4
    //   1021: invokevirtual 58	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1024: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1027: invokevirtual 142	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1030: pop
    //   1031: iload_2
    //   1032: ifle +764 -> 1796
    //   1035: iload_2
    //   1036: bipush 25
    //   1038: irem
    //   1039: ifne +757 -> 1796
    //   1042: aload 19
    //   1044: astore 18
    //   1046: aload 19
    //   1048: astore 17
    //   1050: new 49	java/lang/StringBuilder
    //   1053: dup
    //   1054: ldc 144
    //   1056: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1059: iload_2
    //   1060: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1063: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1066: iconst_0
    //   1067: anewarray 4	java/lang/Object
    //   1070: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1073: aload 19
    //   1075: astore 18
    //   1077: aload 19
    //   1079: astore 17
    //   1081: aload 23
    //   1083: iconst_4
    //   1084: invokevirtual 145	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   1087: astore 24
    //   1089: aload 19
    //   1091: astore 18
    //   1093: aload 19
    //   1095: astore 17
    //   1097: aload 23
    //   1099: iconst_0
    //   1100: invokevirtual 149	java/lang/StringBuffer:setLength	(I)V
    //   1103: aload 19
    //   1105: astore 18
    //   1107: aload 19
    //   1109: astore 17
    //   1111: aload_1
    //   1112: ldc 100
    //   1114: aconst_null
    //   1115: aload 24
    //   1117: aconst_null
    //   1118: aconst_null
    //   1119: aconst_null
    //   1120: aload 21
    //   1122: invokevirtual 275	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1125: astore 19
    //   1127: aload 19
    //   1129: astore 17
    //   1131: aload 17
    //   1133: invokestatic 278	com/tencent/beacon/a/a/a:a	(Landroid/database/Cursor;)Ljava/util/List;
    //   1136: astore 18
    //   1138: aload 18
    //   1140: ifnull +47 -> 1187
    //   1143: aload 18
    //   1145: invokeinterface 283 1 0
    //   1150: ifle +37 -> 1187
    //   1153: aload 22
    //   1155: aload 18
    //   1157: invokeinterface 287 2 0
    //   1162: pop
    //   1163: new 49	java/lang/StringBuilder
    //   1166: dup
    //   1167: ldc_w 289
    //   1170: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1173: iconst_0
    //   1174: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1177: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1180: iconst_0
    //   1181: anewarray 4	java/lang/Object
    //   1184: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1187: aload 17
    //   1189: invokeinterface 255 1 0
    //   1194: iload_2
    //   1195: iconst_1
    //   1196: iadd
    //   1197: istore_2
    //   1198: aload 17
    //   1200: astore 19
    //   1202: goto -234 -> 968
    //   1205: aload 19
    //   1207: astore 18
    //   1209: aload 19
    //   1211: astore 20
    //   1213: aload 19
    //   1215: astore 17
    //   1217: aload 23
    //   1219: invokevirtual 155	java/lang/StringBuffer:length	()I
    //   1222: ifle +157 -> 1379
    //   1225: aload 19
    //   1227: astore 18
    //   1229: aload 19
    //   1231: astore 17
    //   1233: aload 23
    //   1235: iconst_4
    //   1236: invokevirtual 145	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   1239: astore 20
    //   1241: aload 19
    //   1243: astore 18
    //   1245: aload 19
    //   1247: astore 17
    //   1249: aload 23
    //   1251: iconst_0
    //   1252: invokevirtual 149	java/lang/StringBuffer:setLength	(I)V
    //   1255: aload 19
    //   1257: astore 18
    //   1259: aload 19
    //   1261: astore 17
    //   1263: aload_1
    //   1264: ldc 100
    //   1266: aconst_null
    //   1267: aload 20
    //   1269: aconst_null
    //   1270: aconst_null
    //   1271: aconst_null
    //   1272: aload 21
    //   1274: invokevirtual 275	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1277: astore 19
    //   1279: aload 19
    //   1281: astore 18
    //   1283: aload 19
    //   1285: astore 17
    //   1287: aload 19
    //   1289: invokestatic 278	com/tencent/beacon/a/a/a:a	(Landroid/database/Cursor;)Ljava/util/List;
    //   1292: astore 21
    //   1294: aload 19
    //   1296: astore 20
    //   1298: aload 21
    //   1300: ifnull +79 -> 1379
    //   1303: aload 19
    //   1305: astore 18
    //   1307: aload 19
    //   1309: astore 20
    //   1311: aload 19
    //   1313: astore 17
    //   1315: aload 21
    //   1317: invokeinterface 283 1 0
    //   1322: ifle +57 -> 1379
    //   1325: aload 19
    //   1327: astore 18
    //   1329: aload 19
    //   1331: astore 17
    //   1333: aload 22
    //   1335: aload 21
    //   1337: invokeinterface 287 2 0
    //   1342: pop
    //   1343: aload 19
    //   1345: astore 18
    //   1347: aload 19
    //   1349: astore 17
    //   1351: new 49	java/lang/StringBuilder
    //   1354: dup
    //   1355: ldc_w 289
    //   1358: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1361: iconst_0
    //   1362: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1365: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1368: iconst_0
    //   1369: anewarray 4	java/lang/Object
    //   1372: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1375: aload 19
    //   1377: astore 20
    //   1379: aload 20
    //   1381: astore 18
    //   1383: aload 20
    //   1385: astore 17
    //   1387: new 49	java/lang/StringBuilder
    //   1390: dup
    //   1391: ldc_w 291
    //   1394: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1397: aload 22
    //   1399: invokeinterface 283 1 0
    //   1404: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1407: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1410: iconst_0
    //   1411: anewarray 4	java/lang/Object
    //   1414: invokestatic 47	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1417: aload 20
    //   1419: ifnull +20 -> 1439
    //   1422: aload 20
    //   1424: invokeinterface 254 1 0
    //   1429: ifne +10 -> 1439
    //   1432: aload 20
    //   1434: invokeinterface 255 1 0
    //   1439: aload_1
    //   1440: ifnull +14 -> 1454
    //   1443: aload_1
    //   1444: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   1447: ifeq +7 -> 1454
    //   1450: aload_1
    //   1451: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   1454: aload_0
    //   1455: ifnull +7 -> 1462
    //   1458: aload_0
    //   1459: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   1462: ldc_w 257
    //   1465: iconst_0
    //   1466: anewarray 4	java/lang/Object
    //   1469: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1472: aload 22
    //   1474: areturn
    //   1475: aload 19
    //   1477: ifnull +20 -> 1497
    //   1480: aload 19
    //   1482: invokeinterface 254 1 0
    //   1487: ifne +10 -> 1497
    //   1490: aload 19
    //   1492: invokeinterface 255 1 0
    //   1497: aload_1
    //   1498: ifnull +14 -> 1512
    //   1501: aload_1
    //   1502: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   1505: ifeq +7 -> 1512
    //   1508: aload_1
    //   1509: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   1512: aload_0
    //   1513: ifnull +7 -> 1520
    //   1516: aload_0
    //   1517: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   1520: ldc_w 257
    //   1523: iconst_0
    //   1524: anewarray 4	java/lang/Object
    //   1527: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1530: aconst_null
    //   1531: areturn
    //   1532: aload_1
    //   1533: ldc 100
    //   1535: aconst_null
    //   1536: aload 18
    //   1538: aconst_null
    //   1539: aconst_null
    //   1540: aconst_null
    //   1541: aload 17
    //   1543: invokevirtual 275	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1546: astore 19
    //   1548: aload 19
    //   1550: astore 18
    //   1552: aload 19
    //   1554: astore 17
    //   1556: aload 19
    //   1558: invokestatic 278	com/tencent/beacon/a/a/a:a	(Landroid/database/Cursor;)Ljava/util/List;
    //   1561: astore 20
    //   1563: aload 19
    //   1565: ifnull +20 -> 1585
    //   1568: aload 19
    //   1570: invokeinterface 254 1 0
    //   1575: ifne +10 -> 1585
    //   1578: aload 19
    //   1580: invokeinterface 255 1 0
    //   1585: aload_1
    //   1586: ifnull +14 -> 1600
    //   1589: aload_1
    //   1590: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   1593: ifeq +7 -> 1600
    //   1596: aload_1
    //   1597: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   1600: aload_0
    //   1601: ifnull +7 -> 1608
    //   1604: aload_0
    //   1605: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   1608: ldc_w 257
    //   1611: iconst_0
    //   1612: anewarray 4	java/lang/Object
    //   1615: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1618: aload 20
    //   1620: areturn
    //   1621: astore_1
    //   1622: aconst_null
    //   1623: astore_0
    //   1624: aconst_null
    //   1625: astore 17
    //   1627: aload 17
    //   1629: ifnull +20 -> 1649
    //   1632: aload 17
    //   1634: invokeinterface 254 1 0
    //   1639: ifne +10 -> 1649
    //   1642: aload 17
    //   1644: invokeinterface 255 1 0
    //   1649: aload 19
    //   1651: ifnull +16 -> 1667
    //   1654: aload 19
    //   1656: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   1659: ifeq +8 -> 1667
    //   1662: aload 19
    //   1664: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   1667: aload_0
    //   1668: ifnull +7 -> 1675
    //   1671: aload_0
    //   1672: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   1675: ldc_w 257
    //   1678: iconst_0
    //   1679: anewarray 4	java/lang/Object
    //   1682: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1685: aload_1
    //   1686: athrow
    //   1687: astore_1
    //   1688: aconst_null
    //   1689: astore 17
    //   1691: goto -64 -> 1627
    //   1694: astore 18
    //   1696: aconst_null
    //   1697: astore 17
    //   1699: aload_1
    //   1700: astore 19
    //   1702: aload 18
    //   1704: astore_1
    //   1705: goto -78 -> 1627
    //   1708: astore 18
    //   1710: aload_1
    //   1711: astore 19
    //   1713: aload 18
    //   1715: astore_1
    //   1716: goto -89 -> 1627
    //   1719: astore 18
    //   1721: aload_1
    //   1722: astore 19
    //   1724: aload 18
    //   1726: astore_1
    //   1727: goto -100 -> 1627
    //   1730: astore_1
    //   1731: aload 17
    //   1733: astore 19
    //   1735: aload 18
    //   1737: astore 17
    //   1739: goto -112 -> 1627
    //   1742: astore_1
    //   1743: aconst_null
    //   1744: astore 18
    //   1746: aload 21
    //   1748: astore_0
    //   1749: aload 20
    //   1751: astore 17
    //   1753: goto -1083 -> 670
    //   1756: astore_1
    //   1757: aconst_null
    //   1758: astore 18
    //   1760: aload 20
    //   1762: astore 17
    //   1764: goto -1094 -> 670
    //   1767: astore 19
    //   1769: aconst_null
    //   1770: astore 18
    //   1772: aload_1
    //   1773: astore 17
    //   1775: aload 19
    //   1777: astore_1
    //   1778: goto -1108 -> 670
    //   1781: astore 19
    //   1783: aload 17
    //   1785: astore 18
    //   1787: aload_1
    //   1788: astore 17
    //   1790: aload 19
    //   1792: astore_1
    //   1793: goto -1123 -> 670
    //   1796: aload 19
    //   1798: astore 17
    //   1800: goto -606 -> 1194
    //   1803: aload_1
    //   1804: astore 17
    //   1806: goto -1412 -> 394
    //   1809: ldc 71
    //   1811: astore_1
    //   1812: goto -1640 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1815	0	paramContext	android.content.Context
    //   0	1815	1	paramArrayOfInt	int[]
    //   0	1815	2	paramInt1	int
    //   0	1815	3	paramInt2	int
    //   0	1815	4	paramLong1	long
    //   0	1815	6	paramInt3	int
    //   0	1815	7	paramInt4	int
    //   0	1815	8	paramInt5	int
    //   0	1815	9	paramInt6	int
    //   0	1815	10	paramInt7	int
    //   0	1815	11	paramLong2	long
    //   0	1815	13	paramLong3	long
    //   72	818	15	l	long
    //   97	1708	17	localObject1	Object
    //   224	1327	18	localObject2	Object
    //   1694	9	18	localObject3	Object
    //   1708	6	18	localObject4	Object
    //   1719	17	18	localObject5	Object
    //   1744	42	18	localObject6	Object
    //   412	233	19	localObject7	Object
    //   662	446	19	localThrowable1	java.lang.Throwable
    //   1125	609	19	localObject8	Object
    //   1767	9	19	localThrowable2	java.lang.Throwable
    //   1781	16	19	localThrowable3	java.lang.Throwable
    //   415	1346	20	localObject9	Object
    //   409	1338	21	localObject10	Object
    //   424	1049	22	localArrayList	ArrayList
    //   964	286	23	localStringBuffer	java.lang.StringBuffer
    //   1087	29	24	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   560	570	662	java/lang/Throwable
    //   578	588	662	java/lang/Throwable
    //   596	605	662	java/lang/Throwable
    //   613	623	662	java/lang/Throwable
    //   631	659	662	java/lang/Throwable
    //   872	879	662	java/lang/Throwable
    //   887	896	662	java/lang/Throwable
    //   909	915	662	java/lang/Throwable
    //   923	949	662	java/lang/Throwable
    //   957	966	662	java/lang/Throwable
    //   976	983	662	java/lang/Throwable
    //   991	1000	662	java/lang/Throwable
    //   1008	1031	662	java/lang/Throwable
    //   1050	1073	662	java/lang/Throwable
    //   1081	1089	662	java/lang/Throwable
    //   1097	1103	662	java/lang/Throwable
    //   1111	1127	662	java/lang/Throwable
    //   1217	1225	662	java/lang/Throwable
    //   1233	1241	662	java/lang/Throwable
    //   1249	1255	662	java/lang/Throwable
    //   1263	1279	662	java/lang/Throwable
    //   1287	1294	662	java/lang/Throwable
    //   1315	1325	662	java/lang/Throwable
    //   1333	1343	662	java/lang/Throwable
    //   1351	1375	662	java/lang/Throwable
    //   1387	1417	662	java/lang/Throwable
    //   1556	1563	662	java/lang/Throwable
    //   426	431	1621	finally
    //   431	436	1687	finally
    //   447	477	1694	finally
    //   477	499	1694	finally
    //   504	521	1694	finally
    //   521	552	1694	finally
    //   1532	1548	1694	finally
    //   560	570	1708	finally
    //   578	588	1708	finally
    //   596	605	1708	finally
    //   613	623	1708	finally
    //   631	659	1708	finally
    //   872	879	1708	finally
    //   887	896	1708	finally
    //   909	915	1708	finally
    //   923	949	1708	finally
    //   957	966	1708	finally
    //   976	983	1708	finally
    //   991	1000	1708	finally
    //   1008	1031	1708	finally
    //   1050	1073	1708	finally
    //   1081	1089	1708	finally
    //   1097	1103	1708	finally
    //   1111	1127	1708	finally
    //   1217	1225	1708	finally
    //   1233	1241	1708	finally
    //   1249	1255	1708	finally
    //   1263	1279	1708	finally
    //   1287	1294	1708	finally
    //   1315	1325	1708	finally
    //   1333	1343	1708	finally
    //   1351	1375	1708	finally
    //   1387	1417	1708	finally
    //   1556	1563	1708	finally
    //   1131	1138	1719	finally
    //   1143	1187	1719	finally
    //   1187	1194	1719	finally
    //   670	681	1730	finally
    //   426	431	1742	java/lang/Throwable
    //   431	436	1756	java/lang/Throwable
    //   447	477	1767	java/lang/Throwable
    //   477	499	1767	java/lang/Throwable
    //   504	521	1767	java/lang/Throwable
    //   521	552	1767	java/lang/Throwable
    //   1532	1548	1767	java/lang/Throwable
    //   1131	1138	1781	java/lang/Throwable
    //   1143	1187	1781	java/lang/Throwable
    //   1187	1194	1781	java/lang/Throwable
  }
  
  protected static List<a> a(Cursor paramCursor)
  {
    com.tencent.beacon.d.a.b(" in AnalyticsDAO.paserCursor() start", new Object[0]);
    if (paramCursor == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = paramCursor.getColumnIndex("_id");
    int j = paramCursor.getColumnIndex("_prority");
    int k = paramCursor.getColumnIndex("_time");
    int m = paramCursor.getColumnIndex("_type");
    int n = paramCursor.getColumnIndex("_datas");
    int i1 = paramCursor.getColumnIndex("_length");
    while (paramCursor.moveToNext())
    {
      a locala = new a();
      locala.a = paramCursor.getLong(i);
      locala.e = paramCursor.getBlob(n);
      locala.c = paramCursor.getInt(j);
      locala.d = paramCursor.getLong(k);
      locala.b = paramCursor.getInt(m);
      locala.f = paramCursor.getLong(i1);
      localArrayList.add(locala);
    }
    com.tencent.beacon.d.a.b(" in AnalyticsDAO.paserCursor() end", new Object[0]);
    return localArrayList;
  }
  
  /* Error */
  public static boolean a(android.content.Context paramContext, List<a> paramList)
  {
    // Byte code:
    //   0: ldc_w 314
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   10: aload_0
    //   11: ifnull +7 -> 18
    //   14: aload_1
    //   15: ifnonnull +15 -> 30
    //   18: ldc_w 316
    //   21: iconst_0
    //   22: anewarray 4	java/lang/Object
    //   25: invokestatic 128	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: iconst_0
    //   29: ireturn
    //   30: aload_1
    //   31: invokeinterface 283 1 0
    //   36: ifgt +15 -> 51
    //   39: ldc_w 318
    //   42: iconst_0
    //   43: anewarray 4	java/lang/Object
    //   46: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   49: iconst_1
    //   50: ireturn
    //   51: aconst_null
    //   52: astore 5
    //   54: aload_0
    //   55: invokestatic 94	com/tencent/beacon/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/c;
    //   58: invokevirtual 98	com/tencent/beacon/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   61: astore_0
    //   62: aload_0
    //   63: invokevirtual 321	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   66: iconst_0
    //   67: istore_2
    //   68: iload_2
    //   69: aload_1
    //   70: invokeinterface 283 1 0
    //   75: if_icmpge +58 -> 133
    //   78: aload_1
    //   79: iload_2
    //   80: invokeinterface 325 2 0
    //   85: checkcast 2	com/tencent/beacon/a/a/a
    //   88: astore 5
    //   90: aload_0
    //   91: ldc 100
    //   93: ldc 165
    //   95: aload 5
    //   97: invokestatic 327	com/tencent/beacon/a/a/a:a	(Lcom/tencent/beacon/a/a/a;)Landroid/content/ContentValues;
    //   100: invokevirtual 331	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   103: lstore_3
    //   104: lload_3
    //   105: lconst_0
    //   106: lcmp
    //   107: ifge +13 -> 120
    //   110: ldc_w 333
    //   113: iconst_0
    //   114: anewarray 4	java/lang/Object
    //   117: invokestatic 128	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: aload 5
    //   122: lload_3
    //   123: putfield 21	com/tencent/beacon/a/a/a:a	J
    //   126: iload_2
    //   127: iconst_1
    //   128: iadd
    //   129: istore_2
    //   130: goto -62 -> 68
    //   133: aload_0
    //   134: invokevirtual 336	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   137: aload_0
    //   138: ifnull +18 -> 156
    //   141: aload_0
    //   142: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   145: ifeq +11 -> 156
    //   148: aload_0
    //   149: invokevirtual 339	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   152: aload_0
    //   153: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   156: ldc_w 341
    //   159: iconst_0
    //   160: anewarray 4	java/lang/Object
    //   163: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: iconst_1
    //   167: ireturn
    //   168: astore_0
    //   169: aload 5
    //   171: astore_0
    //   172: ldc_w 343
    //   175: iconst_0
    //   176: anewarray 4	java/lang/Object
    //   179: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: aload_0
    //   183: ifnull +18 -> 201
    //   186: aload_0
    //   187: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   190: ifeq +11 -> 201
    //   193: aload_0
    //   194: invokevirtual 339	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   197: aload_0
    //   198: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   201: ldc_w 341
    //   204: iconst_0
    //   205: anewarray 4	java/lang/Object
    //   208: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   211: iconst_0
    //   212: ireturn
    //   213: astore_1
    //   214: aconst_null
    //   215: astore_0
    //   216: aload_0
    //   217: ifnull +18 -> 235
    //   220: aload_0
    //   221: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   224: ifeq +11 -> 235
    //   227: aload_0
    //   228: invokevirtual 339	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   231: aload_0
    //   232: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   235: ldc_w 341
    //   238: iconst_0
    //   239: anewarray 4	java/lang/Object
    //   242: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   245: aload_1
    //   246: athrow
    //   247: astore_1
    //   248: goto -32 -> 216
    //   251: astore_1
    //   252: goto -36 -> 216
    //   255: astore_1
    //   256: goto -84 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	paramContext	android.content.Context
    //   0	259	1	paramList	List<a>
    //   67	63	2	i	int
    //   103	20	3	l	long
    //   52	118	5	locala	a
    // Exception table:
    //   from	to	target	type
    //   54	62	168	java/lang/Throwable
    //   54	62	213	finally
    //   62	66	247	finally
    //   68	104	247	finally
    //   110	120	247	finally
    //   120	126	247	finally
    //   133	137	247	finally
    //   172	182	251	finally
    //   62	66	255	java/lang/Throwable
    //   68	104	255	java/lang/Throwable
    //   110	120	255	java/lang/Throwable
    //   120	126	255	java/lang/Throwable
    //   133	137	255	java/lang/Throwable
  }
  
  /* Error */
  public static int b(android.content.Context paramContext, int[] paramArrayOfInt, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc_w 346
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   10: aload_0
    //   11: ifnonnull +15 -> 26
    //   14: ldc_w 348
    //   17: iconst_0
    //   18: anewarray 4	java/lang/Object
    //   21: invokestatic 47	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: iconst_m1
    //   25: ireturn
    //   26: ldc2_w 18
    //   29: ldc2_w 200
    //   32: lcmp
    //   33: ifle +5 -> 38
    //   36: iconst_0
    //   37: ireturn
    //   38: new 49	java/lang/StringBuilder
    //   41: dup
    //   42: ldc 51
    //   44: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   47: ldc2_w 18
    //   50: invokevirtual 58	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   53: ldc 60
    //   55: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc_w 350
    //   61: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore 8
    //   69: aload 8
    //   71: astore 7
    //   73: aload_1
    //   74: ifnull +102 -> 176
    //   77: aload 8
    //   79: astore 7
    //   81: aload_1
    //   82: arraylength
    //   83: ifle +93 -> 176
    //   86: ldc 71
    //   88: astore 7
    //   90: iconst_0
    //   91: istore 6
    //   93: iload 6
    //   95: aload_1
    //   96: arraylength
    //   97: if_icmpge +41 -> 138
    //   100: new 49	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   107: aload 7
    //   109: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: ldc 74
    //   114: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_1
    //   118: iload 6
    //   120: iaload
    //   121: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   124: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: astore 7
    //   129: iload 6
    //   131: iconst_1
    //   132: iadd
    //   133: istore 6
    //   135: goto -42 -> 93
    //   138: aload 7
    //   140: iconst_4
    //   141: invokevirtual 83	java/lang/String:substring	(I)Ljava/lang/String;
    //   144: astore_1
    //   145: new 49	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   152: aload 8
    //   154: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: ldc 85
    //   159: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_1
    //   163: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc 87
    //   168: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: astore 7
    //   176: new 49	java/lang/StringBuilder
    //   179: dup
    //   180: ldc_w 352
    //   183: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   186: aload 7
    //   188: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: iconst_0
    //   195: anewarray 4	java/lang/Object
    //   198: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   201: aconst_null
    //   202: astore 10
    //   204: aconst_null
    //   205: astore 8
    //   207: aconst_null
    //   208: astore 9
    //   210: aload_0
    //   211: invokestatic 94	com/tencent/beacon/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/c;
    //   214: astore_0
    //   215: aload_0
    //   216: invokevirtual 98	com/tencent/beacon/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   219: astore_1
    //   220: aload_1
    //   221: ldc 100
    //   223: iconst_1
    //   224: anewarray 79	java/lang/String
    //   227: dup
    //   228: iconst_0
    //   229: ldc_w 354
    //   232: aastore
    //   233: aload 7
    //   235: aconst_null
    //   236: aconst_null
    //   237: aconst_null
    //   238: aconst_null
    //   239: invokevirtual 275	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   242: astore 7
    //   244: aload 7
    //   246: invokeinterface 244 1 0
    //   251: pop
    //   252: aload 7
    //   254: aload 7
    //   256: ldc_w 356
    //   259: invokeinterface 238 2 0
    //   264: invokeinterface 304 2 0
    //   269: istore 6
    //   271: new 49	java/lang/StringBuilder
    //   274: dup
    //   275: ldc_w 358
    //   278: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   281: iload 6
    //   283: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   286: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: iconst_0
    //   290: anewarray 4	java/lang/Object
    //   293: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   296: aload 7
    //   298: ifnull +20 -> 318
    //   301: aload 7
    //   303: invokeinterface 254 1 0
    //   308: ifne +10 -> 318
    //   311: aload 7
    //   313: invokeinterface 255 1 0
    //   318: aload_1
    //   319: ifnull +14 -> 333
    //   322: aload_1
    //   323: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   326: ifeq +7 -> 333
    //   329: aload_1
    //   330: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   333: aload_0
    //   334: ifnull +7 -> 341
    //   337: aload_0
    //   338: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   341: ldc_w 360
    //   344: iconst_0
    //   345: anewarray 4	java/lang/Object
    //   348: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   351: iload 6
    //   353: ireturn
    //   354: astore 8
    //   356: aconst_null
    //   357: astore_1
    //   358: aload 10
    //   360: astore_0
    //   361: aload 9
    //   363: astore 7
    //   365: aload 8
    //   367: invokevirtual 121	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   370: iconst_0
    //   371: anewarray 4	java/lang/Object
    //   374: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   377: aload_1
    //   378: ifnull +18 -> 396
    //   381: aload_1
    //   382: invokeinterface 254 1 0
    //   387: ifne +9 -> 396
    //   390: aload_1
    //   391: invokeinterface 255 1 0
    //   396: aload 7
    //   398: ifnull +16 -> 414
    //   401: aload 7
    //   403: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   406: ifeq +8 -> 414
    //   409: aload 7
    //   411: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   414: aload_0
    //   415: ifnull +7 -> 422
    //   418: aload_0
    //   419: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   422: ldc_w 360
    //   425: iconst_0
    //   426: anewarray 4	java/lang/Object
    //   429: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   432: iconst_m1
    //   433: ireturn
    //   434: astore_1
    //   435: aconst_null
    //   436: astore_0
    //   437: aconst_null
    //   438: astore 7
    //   440: aload 7
    //   442: ifnull +20 -> 462
    //   445: aload 7
    //   447: invokeinterface 254 1 0
    //   452: ifne +10 -> 462
    //   455: aload 7
    //   457: invokeinterface 255 1 0
    //   462: aload 8
    //   464: ifnull +16 -> 480
    //   467: aload 8
    //   469: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   472: ifeq +8 -> 480
    //   475: aload 8
    //   477: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   480: aload_0
    //   481: ifnull +7 -> 488
    //   484: aload_0
    //   485: invokevirtual 116	com/tencent/beacon/a/a/c:close	()V
    //   488: ldc_w 360
    //   491: iconst_0
    //   492: anewarray 4	java/lang/Object
    //   495: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   498: aload_1
    //   499: athrow
    //   500: astore_1
    //   501: aconst_null
    //   502: astore 7
    //   504: goto -64 -> 440
    //   507: astore 7
    //   509: aconst_null
    //   510: astore 9
    //   512: aload_1
    //   513: astore 8
    //   515: aload 7
    //   517: astore_1
    //   518: aload 9
    //   520: astore 7
    //   522: goto -82 -> 440
    //   525: astore 9
    //   527: aload_1
    //   528: astore 8
    //   530: aload 9
    //   532: astore_1
    //   533: goto -93 -> 440
    //   536: astore 8
    //   538: aload_1
    //   539: astore 9
    //   541: aload 8
    //   543: astore_1
    //   544: aload 7
    //   546: astore 8
    //   548: aload 9
    //   550: astore 7
    //   552: goto -112 -> 440
    //   555: astore 8
    //   557: aconst_null
    //   558: astore_1
    //   559: aload 9
    //   561: astore 7
    //   563: goto -198 -> 365
    //   566: astore 8
    //   568: aconst_null
    //   569: astore 9
    //   571: aload_1
    //   572: astore 7
    //   574: aload 9
    //   576: astore_1
    //   577: goto -212 -> 365
    //   580: astore 8
    //   582: aload 7
    //   584: astore 9
    //   586: aload_1
    //   587: astore 7
    //   589: aload 9
    //   591: astore_1
    //   592: goto -227 -> 365
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	595	0	paramContext	android.content.Context
    //   0	595	1	paramArrayOfInt	int[]
    //   0	595	2	paramLong1	long
    //   0	595	4	paramLong2	long
    //   91	261	6	i	int
    //   71	432	7	localObject1	Object
    //   507	9	7	localObject2	Object
    //   520	68	7	localObject3	Object
    //   67	139	8	str	java.lang.String
    //   354	122	8	localThrowable1	java.lang.Throwable
    //   513	16	8	arrayOfInt	int[]
    //   536	6	8	localObject4	Object
    //   546	1	8	localObject5	Object
    //   555	1	8	localThrowable2	java.lang.Throwable
    //   566	1	8	localThrowable3	java.lang.Throwable
    //   580	1	8	localThrowable4	java.lang.Throwable
    //   208	311	9	localObject6	Object
    //   525	6	9	localObject7	Object
    //   539	51	9	localObject8	Object
    //   202	157	10	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   210	215	354	java/lang/Throwable
    //   210	215	434	finally
    //   215	220	500	finally
    //   220	244	507	finally
    //   244	296	525	finally
    //   365	377	536	finally
    //   215	220	555	java/lang/Throwable
    //   220	244	566	java/lang/Throwable
    //   244	296	580	java/lang/Throwable
  }
  
  /* Error */
  public static boolean b(android.content.Context paramContext, List<a> paramList)
  {
    // Byte code:
    //   0: ldc_w 362
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   10: aload_0
    //   11: ifnull +16 -> 27
    //   14: aload_1
    //   15: ifnull +12 -> 27
    //   18: aload_1
    //   19: invokeinterface 283 1 0
    //   24: ifgt +15 -> 39
    //   27: ldc_w 364
    //   30: iconst_0
    //   31: anewarray 4	java/lang/Object
    //   34: invokestatic 128	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   37: iconst_0
    //   38: ireturn
    //   39: aconst_null
    //   40: astore 5
    //   42: aconst_null
    //   43: astore 4
    //   45: aload_0
    //   46: invokestatic 94	com/tencent/beacon/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/c;
    //   49: invokevirtual 98	com/tencent/beacon/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   52: astore_0
    //   53: aload_0
    //   54: astore 4
    //   56: aload_0
    //   57: astore 5
    //   59: aload_1
    //   60: invokeinterface 368 1 0
    //   65: astore_1
    //   66: aload_0
    //   67: astore 4
    //   69: aload_0
    //   70: astore 5
    //   72: aload_1
    //   73: invokeinterface 373 1 0
    //   78: ifeq +269 -> 347
    //   81: aload_0
    //   82: astore 4
    //   84: aload_0
    //   85: astore 5
    //   87: aload_1
    //   88: invokeinterface 377 1 0
    //   93: checkcast 2	com/tencent/beacon/a/a/a
    //   96: astore 6
    //   98: aload_0
    //   99: astore 4
    //   101: aload_0
    //   102: astore 5
    //   104: aload 6
    //   106: invokestatic 327	com/tencent/beacon/a/a/a:a	(Lcom/tencent/beacon/a/a/a;)Landroid/content/ContentValues;
    //   109: astore 7
    //   111: aload 7
    //   113: ifnonnull +57 -> 170
    //   116: aload_0
    //   117: ifnull +26 -> 143
    //   120: aload_0
    //   121: astore 4
    //   123: aload_0
    //   124: astore 5
    //   126: aload_0
    //   127: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   130: ifeq +13 -> 143
    //   133: aload_0
    //   134: astore 4
    //   136: aload_0
    //   137: astore 5
    //   139: aload_0
    //   140: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   143: aload_0
    //   144: ifnull +14 -> 158
    //   147: aload_0
    //   148: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   151: ifeq +7 -> 158
    //   154: aload_0
    //   155: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   158: ldc_w 379
    //   161: iconst_0
    //   162: anewarray 4	java/lang/Object
    //   165: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: iconst_0
    //   169: ireturn
    //   170: aload_0
    //   171: astore 4
    //   173: aload_0
    //   174: astore 5
    //   176: aload_0
    //   177: ldc 100
    //   179: ldc 165
    //   181: aload 7
    //   183: invokevirtual 382	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   186: lstore_2
    //   187: lload_2
    //   188: lconst_0
    //   189: lcmp
    //   190: ifge +73 -> 263
    //   193: aload_0
    //   194: astore 4
    //   196: aload_0
    //   197: astore 5
    //   199: ldc_w 384
    //   202: iconst_0
    //   203: anewarray 4	java/lang/Object
    //   206: invokestatic 128	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   209: aload_0
    //   210: ifnull +26 -> 236
    //   213: aload_0
    //   214: astore 4
    //   216: aload_0
    //   217: astore 5
    //   219: aload_0
    //   220: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   223: ifeq +13 -> 236
    //   226: aload_0
    //   227: astore 4
    //   229: aload_0
    //   230: astore 5
    //   232: aload_0
    //   233: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   236: aload_0
    //   237: ifnull +14 -> 251
    //   240: aload_0
    //   241: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   244: ifeq +7 -> 251
    //   247: aload_0
    //   248: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   251: ldc_w 379
    //   254: iconst_0
    //   255: anewarray 4	java/lang/Object
    //   258: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   261: iconst_0
    //   262: ireturn
    //   263: aload_0
    //   264: astore 4
    //   266: aload_0
    //   267: astore 5
    //   269: new 49	java/lang/StringBuilder
    //   272: dup
    //   273: ldc_w 386
    //   276: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   279: lload_2
    //   280: invokevirtual 58	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   283: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: iconst_0
    //   287: anewarray 4	java/lang/Object
    //   290: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   293: aload_0
    //   294: astore 4
    //   296: aload_0
    //   297: astore 5
    //   299: aload 6
    //   301: lload_2
    //   302: putfield 21	com/tencent/beacon/a/a/a:a	J
    //   305: goto -239 -> 66
    //   308: astore_0
    //   309: aload 4
    //   311: astore 5
    //   313: aload_0
    //   314: invokevirtual 389	java/lang/Throwable:printStackTrace	()V
    //   317: aload 4
    //   319: ifnull +16 -> 335
    //   322: aload 4
    //   324: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   327: ifeq +8 -> 335
    //   330: aload 4
    //   332: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   335: ldc_w 379
    //   338: iconst_0
    //   339: anewarray 4	java/lang/Object
    //   342: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   345: iconst_0
    //   346: ireturn
    //   347: aload_0
    //   348: ifnull +14 -> 362
    //   351: aload_0
    //   352: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   355: ifeq +7 -> 362
    //   358: aload_0
    //   359: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   362: ldc_w 379
    //   365: iconst_0
    //   366: anewarray 4	java/lang/Object
    //   369: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   372: iconst_1
    //   373: ireturn
    //   374: astore_0
    //   375: aload 5
    //   377: ifnull +16 -> 393
    //   380: aload 5
    //   382: invokevirtual 112	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   385: ifeq +8 -> 393
    //   388: aload 5
    //   390: invokevirtual 115	android/database/sqlite/SQLiteDatabase:close	()V
    //   393: ldc_w 379
    //   396: iconst_0
    //   397: anewarray 4	java/lang/Object
    //   400: invokestatic 43	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   403: aload_0
    //   404: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	405	0	paramContext	android.content.Context
    //   0	405	1	paramList	List<a>
    //   186	116	2	l	long
    //   43	288	4	localContext	android.content.Context
    //   40	349	5	localObject	Object
    //   96	204	6	locala	a
    //   109	73	7	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   45	53	308	java/lang/Throwable
    //   59	66	308	java/lang/Throwable
    //   72	81	308	java/lang/Throwable
    //   87	98	308	java/lang/Throwable
    //   104	111	308	java/lang/Throwable
    //   126	133	308	java/lang/Throwable
    //   139	143	308	java/lang/Throwable
    //   176	187	308	java/lang/Throwable
    //   199	209	308	java/lang/Throwable
    //   219	226	308	java/lang/Throwable
    //   232	236	308	java/lang/Throwable
    //   269	293	308	java/lang/Throwable
    //   299	305	308	java/lang/Throwable
    //   45	53	374	finally
    //   59	66	374	finally
    //   72	81	374	finally
    //   87	98	374	finally
    //   104	111	374	finally
    //   126	133	374	finally
    //   139	143	374	finally
    //   176	187	374	finally
    //   199	209	374	finally
    //   219	226	374	finally
    //   232	236	374	finally
    //   269	293	374	finally
    //   299	305	374	finally
    //   313	317	374	finally
  }
  
  public final long a()
  {
    return this.a;
  }
  
  public final a a(long paramLong)
  {
    this.a = paramLong;
    return this;
  }
  
  public final byte[] b()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.beacon.a.a.a
 * JD-Core Version:    0.7.0.1
 */