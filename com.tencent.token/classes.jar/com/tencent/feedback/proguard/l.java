package com.tencent.feedback.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.feedback.common.e;
import java.util.ArrayList;
import java.util.List;

public class l
{
  private long a = -1L;
  private int b = -1;
  private int c = -1;
  private long d = -1L;
  private byte[] e = null;
  private long f = 0L;
  private String g = null;
  private int h = 0;
  private int i = 0;
  private int j = -1;
  
  public l() {}
  
  public l(int paramInt1, int paramInt2, long paramLong, byte[] paramArrayOfByte)
  {
    this.b = paramInt1;
    this.c = 0;
    this.d = paramLong;
    this.e = paramArrayOfByte;
    if (paramArrayOfByte != null) {
      this.f = paramArrayOfByte.length;
    }
  }
  
  /* Error */
  public static int a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +15 -> 16
    //   4: ldc 51
    //   6: iconst_0
    //   7: anewarray 4	java/lang/Object
    //   10: invokestatic 56	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   13: pop
    //   14: iconst_m1
    //   15: ireturn
    //   16: ldc 58
    //   18: iconst_1
    //   19: anewarray 4	java/lang/Object
    //   22: dup
    //   23: iconst_0
    //   24: iconst_1
    //   25: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: aastore
    //   29: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   32: pop
    //   33: aconst_null
    //   34: astore 4
    //   36: new 68	com/tencent/feedback/proguard/n
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   44: astore_0
    //   45: aload_0
    //   46: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   49: astore_2
    //   50: aload_2
    //   51: ifnonnull +61 -> 112
    //   54: ldc 77
    //   56: iconst_0
    //   57: anewarray 4	java/lang/Object
    //   60: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   63: pop
    //   64: ldc 81
    //   66: iconst_0
    //   67: anewarray 4	java/lang/Object
    //   70: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   73: pop
    //   74: aload_2
    //   75: ifnull +14 -> 89
    //   78: aload_2
    //   79: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   82: ifeq +7 -> 89
    //   85: aload_2
    //   86: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   89: aload_0
    //   90: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   93: ldc 93
    //   95: iconst_1
    //   96: anewarray 4	java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: iconst_0
    //   102: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   105: aastore
    //   106: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   109: pop
    //   110: iconst_m1
    //   111: ireturn
    //   112: new 95	java/lang/StringBuilder
    //   115: dup
    //   116: ldc 97
    //   118: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   121: astore_3
    //   122: aload_3
    //   123: iconst_1
    //   124: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload_3
    //   129: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: astore 4
    //   134: aload_2
    //   135: ldc 110
    //   137: aload 4
    //   139: aconst_null
    //   140: invokevirtual 114	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   143: istore_1
    //   144: aload 4
    //   146: astore_3
    //   147: aload 4
    //   149: ifnonnull +6 -> 155
    //   152: ldc 116
    //   154: astore_3
    //   155: ldc 118
    //   157: iconst_2
    //   158: anewarray 4	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: iload_1
    //   164: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   167: aastore
    //   168: dup
    //   169: iconst_1
    //   170: aload_3
    //   171: aastore
    //   172: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   175: pop
    //   176: aload_2
    //   177: ifnull +14 -> 191
    //   180: aload_2
    //   181: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   184: ifeq +7 -> 191
    //   187: aload_2
    //   188: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   191: aload_0
    //   192: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   195: ldc 93
    //   197: iconst_1
    //   198: anewarray 4	java/lang/Object
    //   201: dup
    //   202: iconst_0
    //   203: iload_1
    //   204: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   207: aastore
    //   208: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   211: pop
    //   212: iload_1
    //   213: ireturn
    //   214: astore 4
    //   216: aload_0
    //   217: astore_3
    //   218: goto +166 -> 384
    //   221: astore 4
    //   223: goto +74 -> 297
    //   226: astore 4
    //   228: aload_0
    //   229: astore_3
    //   230: aload 4
    //   232: astore_0
    //   233: goto +43 -> 276
    //   236: astore 4
    //   238: aload_0
    //   239: astore_3
    //   240: aload 4
    //   242: astore_0
    //   243: goto +47 -> 290
    //   246: astore 4
    //   248: aconst_null
    //   249: astore_2
    //   250: aload_0
    //   251: astore_3
    //   252: aload 4
    //   254: astore_0
    //   255: goto +21 -> 276
    //   258: astore 5
    //   260: aload 4
    //   262: astore_2
    //   263: aload_0
    //   264: astore_3
    //   265: aload 5
    //   267: astore_0
    //   268: goto +22 -> 290
    //   271: astore_0
    //   272: aconst_null
    //   273: astore_2
    //   274: aload_2
    //   275: astore_3
    //   276: iconst_0
    //   277: istore_1
    //   278: aload_0
    //   279: astore 4
    //   281: goto +103 -> 384
    //   284: astore_0
    //   285: aconst_null
    //   286: astore_3
    //   287: aload 4
    //   289: astore_2
    //   290: iconst_0
    //   291: istore_1
    //   292: aload_0
    //   293: astore 4
    //   295: aload_3
    //   296: astore_0
    //   297: ldc 120
    //   299: iconst_0
    //   300: anewarray 4	java/lang/Object
    //   303: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   306: pop
    //   307: ldc 122
    //   309: iconst_1
    //   310: anewarray 4	java/lang/Object
    //   313: dup
    //   314: iconst_0
    //   315: aload 4
    //   317: invokevirtual 125	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   320: aastore
    //   321: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   324: pop
    //   325: aload 4
    //   327: invokestatic 128	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   330: ifne +8 -> 338
    //   333: aload 4
    //   335: invokevirtual 131	java/lang/Throwable:printStackTrace	()V
    //   338: aload_2
    //   339: ifnull +14 -> 353
    //   342: aload_2
    //   343: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   346: ifeq +7 -> 353
    //   349: aload_2
    //   350: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   353: aload_0
    //   354: ifnull +7 -> 361
    //   357: aload_0
    //   358: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   361: ldc 93
    //   363: iconst_1
    //   364: anewarray 4	java/lang/Object
    //   367: dup
    //   368: iconst_0
    //   369: iload_1
    //   370: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   373: aastore
    //   374: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   377: pop
    //   378: iload_1
    //   379: ireturn
    //   380: astore 4
    //   382: aload_0
    //   383: astore_3
    //   384: aload_2
    //   385: ifnull +14 -> 399
    //   388: aload_2
    //   389: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   392: ifeq +7 -> 399
    //   395: aload_2
    //   396: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   399: aload_3
    //   400: ifnull +7 -> 407
    //   403: aload_3
    //   404: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   407: ldc 93
    //   409: iconst_1
    //   410: anewarray 4	java/lang/Object
    //   413: dup
    //   414: iconst_0
    //   415: iload_1
    //   416: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   419: aastore
    //   420: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   423: pop
    //   424: aload 4
    //   426: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	427	0	paramContext	Context
    //   0	427	1	paramInt	int
    //   49	347	2	localObject1	Object
    //   121	283	3	localObject2	Object
    //   34	114	4	str	String
    //   214	1	4	localObject3	Object
    //   221	1	4	localThrowable1	Throwable
    //   226	5	4	localObject4	Object
    //   236	5	4	localThrowable2	Throwable
    //   246	15	4	localObject5	Object
    //   279	55	4	localContext	Context
    //   380	45	4	localObject6	Object
    //   258	8	5	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   155	176	214	finally
    //   155	176	221	java/lang/Throwable
    //   54	74	226	finally
    //   112	144	226	finally
    //   54	74	236	java/lang/Throwable
    //   112	144	236	java/lang/Throwable
    //   45	50	246	finally
    //   45	50	258	java/lang/Throwable
    //   36	45	271	finally
    //   36	45	284	java/lang/Throwable
    //   297	338	380	finally
  }
  
  public static int a(Context paramContext, int[] paramArrayOfInt, long paramLong1, long paramLong2)
  {
    return a(paramContext, paramArrayOfInt, paramLong1, paramLong2, -1, -1);
  }
  
  /* Error */
  public static int a(Context paramContext, int[] paramArrayOfInt, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 137
    //   2: iconst_0
    //   3: anewarray 4	java/lang/Object
    //   6: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   9: pop
    //   10: aload_0
    //   11: ifnonnull +15 -> 26
    //   14: ldc 139
    //   16: iconst_0
    //   17: anewarray 4	java/lang/Object
    //   20: invokestatic 141	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   23: pop
    //   24: iconst_m1
    //   25: ireturn
    //   26: lload_2
    //   27: lload 4
    //   29: lcmp
    //   30: ifle +5 -> 35
    //   33: iconst_0
    //   34: ireturn
    //   35: new 95	java/lang/StringBuilder
    //   38: dup
    //   39: ldc 143
    //   41: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   44: astore 8
    //   46: aload 8
    //   48: lload_2
    //   49: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 8
    //   55: ldc 148
    //   57: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 8
    //   63: ldc 153
    //   65: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 8
    //   71: lload 4
    //   73: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload 8
    //   79: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: astore 8
    //   84: aload 8
    //   86: astore 9
    //   88: iload 6
    //   90: iflt +43 -> 133
    //   93: new 95	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   100: astore 9
    //   102: aload 9
    //   104: aload 8
    //   106: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 9
    //   112: ldc 156
    //   114: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload 9
    //   120: iload 6
    //   122: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload 9
    //   128: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: astore 9
    //   133: aload 9
    //   135: astore 8
    //   137: iload 7
    //   139: iflt +43 -> 182
    //   142: new 95	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   149: astore 8
    //   151: aload 8
    //   153: aload 9
    //   155: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload 8
    //   161: ldc 158
    //   163: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 8
    //   169: iload 7
    //   171: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 8
    //   177: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: astore 8
    //   182: aload 8
    //   184: astore 10
    //   186: aload_1
    //   187: ifnull +131 -> 318
    //   190: aload 8
    //   192: astore 10
    //   194: aload_1
    //   195: arraylength
    //   196: ifle +122 -> 318
    //   199: ldc 160
    //   201: astore 9
    //   203: iconst_0
    //   204: istore 6
    //   206: iload 6
    //   208: aload_1
    //   209: arraylength
    //   210: if_icmpge +54 -> 264
    //   213: new 95	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   220: astore 10
    //   222: aload 10
    //   224: aload 9
    //   226: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload 10
    //   232: ldc 162
    //   234: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload 10
    //   240: aload_1
    //   241: iload 6
    //   243: iaload
    //   244: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload 10
    //   250: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: astore 9
    //   255: iload 6
    //   257: iconst_1
    //   258: iadd
    //   259: istore 6
    //   261: goto -55 -> 206
    //   264: aload 9
    //   266: iconst_4
    //   267: invokevirtual 168	java/lang/String:substring	(I)Ljava/lang/String;
    //   270: astore_1
    //   271: new 95	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   278: astore 9
    //   280: aload 9
    //   282: aload 8
    //   284: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 9
    //   290: ldc 170
    //   292: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload 9
    //   298: aload_1
    //   299: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload 9
    //   305: ldc 172
    //   307: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload 9
    //   313: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: astore 10
    //   318: new 95	java/lang/StringBuilder
    //   321: dup
    //   322: ldc 174
    //   324: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   327: astore_1
    //   328: aload_1
    //   329: aload 10
    //   331: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload_1
    //   336: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: iconst_0
    //   340: anewarray 4	java/lang/Object
    //   343: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   346: pop
    //   347: new 68	com/tencent/feedback/proguard/n
    //   350: dup
    //   351: aload_0
    //   352: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   355: astore_1
    //   356: aload_1
    //   357: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   360: astore_0
    //   361: aload_0
    //   362: astore 8
    //   364: aload_1
    //   365: astore 9
    //   367: aload_0
    //   368: ldc 176
    //   370: aload 10
    //   372: aconst_null
    //   373: invokevirtual 114	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   376: istore 6
    //   378: aload_0
    //   379: astore 8
    //   381: aload_1
    //   382: astore 9
    //   384: new 95	java/lang/StringBuilder
    //   387: dup
    //   388: ldc 178
    //   390: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   393: astore 10
    //   395: aload_0
    //   396: astore 8
    //   398: aload_1
    //   399: astore 9
    //   401: aload 10
    //   403: iload 6
    //   405: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload_0
    //   410: astore 8
    //   412: aload_1
    //   413: astore 9
    //   415: aload 10
    //   417: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: iconst_0
    //   421: anewarray 4	java/lang/Object
    //   424: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   427: pop
    //   428: aload_0
    //   429: ifnull +14 -> 443
    //   432: aload_0
    //   433: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   436: ifeq +7 -> 443
    //   439: aload_0
    //   440: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   443: aload_1
    //   444: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   447: ldc 180
    //   449: iconst_0
    //   450: anewarray 4	java/lang/Object
    //   453: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   456: pop
    //   457: iload 6
    //   459: ireturn
    //   460: astore 10
    //   462: goto +32 -> 494
    //   465: astore_0
    //   466: aconst_null
    //   467: astore 8
    //   469: goto +83 -> 552
    //   472: astore 10
    //   474: aconst_null
    //   475: astore_0
    //   476: goto +18 -> 494
    //   479: astore_0
    //   480: aconst_null
    //   481: astore_1
    //   482: aload_1
    //   483: astore 8
    //   485: goto +67 -> 552
    //   488: astore 10
    //   490: aconst_null
    //   491: astore_1
    //   492: aload_1
    //   493: astore_0
    //   494: aload_0
    //   495: astore 8
    //   497: aload_1
    //   498: astore 9
    //   500: aload 10
    //   502: invokevirtual 125	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   505: iconst_0
    //   506: anewarray 4	java/lang/Object
    //   509: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   512: pop
    //   513: aload_0
    //   514: ifnull +14 -> 528
    //   517: aload_0
    //   518: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   521: ifeq +7 -> 528
    //   524: aload_0
    //   525: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   528: aload_1
    //   529: ifnull +7 -> 536
    //   532: aload_1
    //   533: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   536: ldc 180
    //   538: iconst_0
    //   539: anewarray 4	java/lang/Object
    //   542: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   545: pop
    //   546: iconst_m1
    //   547: ireturn
    //   548: astore_0
    //   549: aload 9
    //   551: astore_1
    //   552: aload 8
    //   554: ifnull +16 -> 570
    //   557: aload 8
    //   559: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   562: ifeq +8 -> 570
    //   565: aload 8
    //   567: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   570: aload_1
    //   571: ifnull +7 -> 578
    //   574: aload_1
    //   575: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   578: ldc 180
    //   580: iconst_0
    //   581: anewarray 4	java/lang/Object
    //   584: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   587: pop
    //   588: aload_0
    //   589: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	590	0	paramContext	Context
    //   0	590	1	paramArrayOfInt	int[]
    //   0	590	2	paramLong1	long
    //   0	590	4	paramLong2	long
    //   0	590	6	paramInt1	int
    //   0	590	7	paramInt2	int
    //   44	522	8	localObject1	Object
    //   86	464	9	localObject2	Object
    //   184	232	10	localObject3	Object
    //   460	1	10	localThrowable1	Throwable
    //   472	1	10	localThrowable2	Throwable
    //   488	13	10	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   367	378	460	java/lang/Throwable
    //   384	395	460	java/lang/Throwable
    //   401	409	460	java/lang/Throwable
    //   415	428	460	java/lang/Throwable
    //   356	361	465	finally
    //   356	361	472	java/lang/Throwable
    //   347	356	479	finally
    //   347	356	488	java/lang/Throwable
    //   367	378	548	finally
    //   384	395	548	finally
    //   401	409	548	finally
    //   415	428	548	finally
    //   500	513	548	finally
  }
  
  /* Error */
  public static int a(Context paramContext, int[] paramArrayOfInt, long paramLong1, long paramLong2, String paramString)
  {
    // Byte code:
    //   0: ldc 183
    //   2: iconst_0
    //   3: anewarray 4	java/lang/Object
    //   6: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   9: pop
    //   10: aload_0
    //   11: ifnonnull +15 -> 26
    //   14: ldc 185
    //   16: iconst_0
    //   17: anewarray 4	java/lang/Object
    //   20: invokestatic 141	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   23: pop
    //   24: iconst_m1
    //   25: ireturn
    //   26: lload_2
    //   27: lload 4
    //   29: lcmp
    //   30: ifle +5 -> 35
    //   33: iconst_0
    //   34: ireturn
    //   35: new 95	java/lang/StringBuilder
    //   38: dup
    //   39: ldc 143
    //   41: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   44: astore 8
    //   46: aload 8
    //   48: lload_2
    //   49: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 8
    //   55: ldc 148
    //   57: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 8
    //   63: ldc 153
    //   65: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 8
    //   71: lload 4
    //   73: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload 8
    //   79: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: astore 9
    //   84: aload 9
    //   86: astore 8
    //   88: aload_1
    //   89: ifnull +131 -> 220
    //   92: aload 9
    //   94: astore 8
    //   96: aload_1
    //   97: arraylength
    //   98: ifle +122 -> 220
    //   101: ldc 160
    //   103: astore 8
    //   105: iconst_0
    //   106: istore 7
    //   108: iload 7
    //   110: aload_1
    //   111: arraylength
    //   112: if_icmpge +54 -> 166
    //   115: new 95	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   122: astore 10
    //   124: aload 10
    //   126: aload 8
    //   128: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 10
    //   134: ldc 162
    //   136: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 10
    //   142: aload_1
    //   143: iload 7
    //   145: iaload
    //   146: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 10
    //   152: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: astore 8
    //   157: iload 7
    //   159: iconst_1
    //   160: iadd
    //   161: istore 7
    //   163: goto -55 -> 108
    //   166: aload 8
    //   168: iconst_4
    //   169: invokevirtual 168	java/lang/String:substring	(I)Ljava/lang/String;
    //   172: astore_1
    //   173: new 95	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   180: astore 8
    //   182: aload 8
    //   184: aload 9
    //   186: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 8
    //   192: ldc 170
    //   194: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload 8
    //   200: aload_1
    //   201: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 8
    //   207: ldc 172
    //   209: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload 8
    //   215: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: astore 8
    //   220: aload 6
    //   222: ifnull +48 -> 270
    //   225: new 95	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   232: astore_1
    //   233: aload_1
    //   234: aload 8
    //   236: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload_1
    //   241: ldc 187
    //   243: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload_1
    //   248: aload 6
    //   250: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload_1
    //   255: ldc 189
    //   257: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload_1
    //   262: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: astore 10
    //   267: goto +7 -> 274
    //   270: aload 8
    //   272: astore 10
    //   274: new 95	java/lang/StringBuilder
    //   277: dup
    //   278: ldc 191
    //   280: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   283: astore_1
    //   284: aload_1
    //   285: aload 10
    //   287: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload_1
    //   292: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: iconst_0
    //   296: anewarray 4	java/lang/Object
    //   299: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   302: pop
    //   303: aconst_null
    //   304: astore 9
    //   306: aconst_null
    //   307: astore 8
    //   309: aconst_null
    //   310: astore 6
    //   312: aconst_null
    //   313: astore 11
    //   315: new 68	com/tencent/feedback/proguard/n
    //   318: dup
    //   319: aload_0
    //   320: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   323: astore_1
    //   324: aload_1
    //   325: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   328: astore 12
    //   330: aload 11
    //   332: astore 9
    //   334: aload 8
    //   336: astore_0
    //   337: aload_1
    //   338: astore 6
    //   340: aload 12
    //   342: astore 8
    //   344: aload 12
    //   346: ldc 176
    //   348: iconst_1
    //   349: anewarray 164	java/lang/String
    //   352: dup
    //   353: iconst_0
    //   354: ldc 193
    //   356: aastore
    //   357: aload 10
    //   359: aconst_null
    //   360: aconst_null
    //   361: aconst_null
    //   362: aconst_null
    //   363: invokevirtual 197	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   366: astore 10
    //   368: aload 10
    //   370: astore 9
    //   372: aload 10
    //   374: astore_0
    //   375: aload_1
    //   376: astore 6
    //   378: aload 12
    //   380: astore 8
    //   382: aload 10
    //   384: invokeinterface 202 1 0
    //   389: pop
    //   390: aload 10
    //   392: astore 9
    //   394: aload 10
    //   396: astore_0
    //   397: aload_1
    //   398: astore 6
    //   400: aload 12
    //   402: astore 8
    //   404: aload 10
    //   406: aload 10
    //   408: ldc 204
    //   410: invokeinterface 208 2 0
    //   415: invokeinterface 212 2 0
    //   420: istore 7
    //   422: aload 10
    //   424: astore 9
    //   426: aload 10
    //   428: astore_0
    //   429: aload_1
    //   430: astore 6
    //   432: aload 12
    //   434: astore 8
    //   436: new 95	java/lang/StringBuilder
    //   439: dup
    //   440: ldc 214
    //   442: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   445: astore 11
    //   447: aload 10
    //   449: astore 9
    //   451: aload 10
    //   453: astore_0
    //   454: aload_1
    //   455: astore 6
    //   457: aload 12
    //   459: astore 8
    //   461: aload 11
    //   463: iload 7
    //   465: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: aload 10
    //   471: astore 9
    //   473: aload 10
    //   475: astore_0
    //   476: aload_1
    //   477: astore 6
    //   479: aload 12
    //   481: astore 8
    //   483: aload 11
    //   485: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: iconst_0
    //   489: anewarray 4	java/lang/Object
    //   492: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   495: pop
    //   496: aload 10
    //   498: ifnull +20 -> 518
    //   501: aload 10
    //   503: invokeinterface 217 1 0
    //   508: ifne +10 -> 518
    //   511: aload 10
    //   513: invokeinterface 218 1 0
    //   518: aload 12
    //   520: ifnull +16 -> 536
    //   523: aload 12
    //   525: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   528: ifeq +8 -> 536
    //   531: aload 12
    //   533: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   536: aload_1
    //   537: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   540: ldc 220
    //   542: iconst_0
    //   543: anewarray 4	java/lang/Object
    //   546: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   549: pop
    //   550: iload 7
    //   552: ireturn
    //   553: astore 10
    //   555: aload_1
    //   556: astore 11
    //   558: aload 12
    //   560: astore_1
    //   561: goto +39 -> 600
    //   564: astore_0
    //   565: aconst_null
    //   566: astore 8
    //   568: goto +125 -> 693
    //   571: astore 10
    //   573: aconst_null
    //   574: astore_0
    //   575: aload_1
    //   576: astore 11
    //   578: aload_0
    //   579: astore_1
    //   580: goto +20 -> 600
    //   583: astore_0
    //   584: aconst_null
    //   585: astore_1
    //   586: aload_1
    //   587: astore 8
    //   589: goto +104 -> 693
    //   592: astore 10
    //   594: aconst_null
    //   595: astore 11
    //   597: aload 11
    //   599: astore_1
    //   600: aload 9
    //   602: astore_0
    //   603: aload 11
    //   605: astore 6
    //   607: aload_1
    //   608: astore 8
    //   610: aload 10
    //   612: invokevirtual 125	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   615: iconst_0
    //   616: anewarray 4	java/lang/Object
    //   619: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   622: pop
    //   623: aload 9
    //   625: ifnull +20 -> 645
    //   628: aload 9
    //   630: invokeinterface 217 1 0
    //   635: ifne +10 -> 645
    //   638: aload 9
    //   640: invokeinterface 218 1 0
    //   645: aload_1
    //   646: ifnull +14 -> 660
    //   649: aload_1
    //   650: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   653: ifeq +7 -> 660
    //   656: aload_1
    //   657: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   660: aload 11
    //   662: ifnull +8 -> 670
    //   665: aload 11
    //   667: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   670: ldc 220
    //   672: iconst_0
    //   673: anewarray 4	java/lang/Object
    //   676: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   679: pop
    //   680: iconst_m1
    //   681: ireturn
    //   682: astore 9
    //   684: aload 6
    //   686: astore_1
    //   687: aload_0
    //   688: astore 6
    //   690: aload 9
    //   692: astore_0
    //   693: aload 6
    //   695: ifnull +20 -> 715
    //   698: aload 6
    //   700: invokeinterface 217 1 0
    //   705: ifne +10 -> 715
    //   708: aload 6
    //   710: invokeinterface 218 1 0
    //   715: aload 8
    //   717: ifnull +16 -> 733
    //   720: aload 8
    //   722: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   725: ifeq +8 -> 733
    //   728: aload 8
    //   730: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   733: aload_1
    //   734: ifnull +7 -> 741
    //   737: aload_1
    //   738: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   741: ldc 220
    //   743: iconst_0
    //   744: anewarray 4	java/lang/Object
    //   747: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   750: pop
    //   751: aload_0
    //   752: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	753	0	paramContext	Context
    //   0	753	1	paramArrayOfInt	int[]
    //   0	753	2	paramLong1	long
    //   0	753	4	paramLong2	long
    //   0	753	6	paramString	String
    //   106	445	7	k	int
    //   44	685	8	localObject1	Object
    //   82	557	9	localObject2	Object
    //   682	9	9	localObject3	Object
    //   122	390	10	localObject4	Object
    //   553	1	10	localThrowable1	Throwable
    //   571	1	10	localThrowable2	Throwable
    //   592	19	10	localThrowable3	Throwable
    //   313	353	11	localObject5	Object
    //   328	231	12	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   344	368	553	java/lang/Throwable
    //   382	390	553	java/lang/Throwable
    //   404	422	553	java/lang/Throwable
    //   436	447	553	java/lang/Throwable
    //   461	469	553	java/lang/Throwable
    //   483	496	553	java/lang/Throwable
    //   324	330	564	finally
    //   324	330	571	java/lang/Throwable
    //   315	324	583	finally
    //   315	324	592	java/lang/Throwable
    //   344	368	682	finally
    //   382	390	682	finally
    //   404	422	682	finally
    //   436	447	682	finally
    //   461	469	682	finally
    //   483	496	682	finally
    //   610	623	682	finally
  }
  
  /* Error */
  public static int a(Context paramContext, Long[] paramArrayOfLong)
  {
    // Byte code:
    //   0: ldc 223
    //   2: iconst_0
    //   3: anewarray 4	java/lang/Object
    //   6: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   9: pop
    //   10: aload_0
    //   11: ifnonnull +15 -> 26
    //   14: ldc 225
    //   16: iconst_0
    //   17: anewarray 4	java/lang/Object
    //   20: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   23: pop
    //   24: iconst_m1
    //   25: ireturn
    //   26: aload_1
    //   27: ifnull +440 -> 467
    //   30: aload_1
    //   31: arraylength
    //   32: ifgt +5 -> 37
    //   35: iconst_0
    //   36: ireturn
    //   37: aconst_null
    //   38: astore 8
    //   40: aconst_null
    //   41: astore 10
    //   43: new 68	com/tencent/feedback/proguard/n
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   51: astore_0
    //   52: aload_0
    //   53: astore 7
    //   55: aload_0
    //   56: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   59: astore 9
    //   61: new 227	java/lang/StringBuffer
    //   64: dup
    //   65: invokespecial 228	java/lang/StringBuffer:<init>	()V
    //   68: astore 7
    //   70: iconst_0
    //   71: istore_3
    //   72: iconst_0
    //   73: istore_2
    //   74: iload_3
    //   75: aload_1
    //   76: arraylength
    //   77: if_icmpge +148 -> 225
    //   80: aload_1
    //   81: iload_3
    //   82: aaload
    //   83: invokevirtual 234	java/lang/Long:longValue	()J
    //   86: lstore 5
    //   88: new 95	java/lang/StringBuilder
    //   91: dup
    //   92: ldc 236
    //   94: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   97: astore 8
    //   99: aload 8
    //   101: lload 5
    //   103: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload 7
    //   109: aload 8
    //   111: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   117: pop
    //   118: iload_2
    //   119: istore 4
    //   121: iload_3
    //   122: ifle +347 -> 469
    //   125: iload_2
    //   126: istore 4
    //   128: iload_3
    //   129: bipush 50
    //   131: irem
    //   132: ifne +337 -> 469
    //   135: new 95	java/lang/StringBuilder
    //   138: dup
    //   139: ldc 241
    //   141: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   144: astore 8
    //   146: aload 8
    //   148: iload_3
    //   149: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 8
    //   155: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: iconst_0
    //   159: anewarray 4	java/lang/Object
    //   162: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   165: pop
    //   166: iload_2
    //   167: aload 9
    //   169: ldc 176
    //   171: aload 7
    //   173: iconst_4
    //   174: invokevirtual 242	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   177: aconst_null
    //   178: invokevirtual 114	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   181: iadd
    //   182: istore 4
    //   184: aload 7
    //   186: iconst_0
    //   187: invokevirtual 246	java/lang/StringBuffer:setLength	(I)V
    //   190: new 95	java/lang/StringBuilder
    //   193: dup
    //   194: ldc 248
    //   196: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   199: astore 8
    //   201: aload 8
    //   203: iload 4
    //   205: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 8
    //   211: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: iconst_0
    //   215: anewarray 4	java/lang/Object
    //   218: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   221: pop
    //   222: goto +247 -> 469
    //   225: iload_2
    //   226: istore_3
    //   227: aload 7
    //   229: invokevirtual 252	java/lang/StringBuffer:length	()I
    //   232: ifle +26 -> 258
    //   235: iload_2
    //   236: aload 9
    //   238: ldc 176
    //   240: aload 7
    //   242: iconst_4
    //   243: invokevirtual 242	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   246: aconst_null
    //   247: invokevirtual 114	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   250: iadd
    //   251: istore_3
    //   252: aload 7
    //   254: iconst_0
    //   255: invokevirtual 246	java/lang/StringBuffer:setLength	(I)V
    //   258: new 95	java/lang/StringBuilder
    //   261: dup
    //   262: ldc 254
    //   264: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   267: astore_1
    //   268: aload_1
    //   269: iload_3
    //   270: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload_1
    //   275: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: iconst_0
    //   279: anewarray 4	java/lang/Object
    //   282: invokestatic 141	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   285: pop
    //   286: aload 9
    //   288: ifnull +16 -> 304
    //   291: aload 9
    //   293: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   296: ifeq +8 -> 304
    //   299: aload 9
    //   301: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   304: aload_0
    //   305: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   308: ldc_w 256
    //   311: iconst_0
    //   312: anewarray 4	java/lang/Object
    //   315: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   318: pop
    //   319: iload_3
    //   320: ireturn
    //   321: astore 8
    //   323: aload 9
    //   325: astore_1
    //   326: goto +104 -> 430
    //   329: astore 7
    //   331: aload 9
    //   333: astore_1
    //   334: aload 7
    //   336: astore 9
    //   338: goto +27 -> 365
    //   341: astore 9
    //   343: aload 10
    //   345: astore_1
    //   346: goto +19 -> 365
    //   349: astore 8
    //   351: aconst_null
    //   352: astore_1
    //   353: aload_1
    //   354: astore_0
    //   355: goto +75 -> 430
    //   358: astore 9
    //   360: aconst_null
    //   361: astore_0
    //   362: aload 10
    //   364: astore_1
    //   365: aload_1
    //   366: astore 8
    //   368: aload_0
    //   369: astore 7
    //   371: aload 9
    //   373: invokevirtual 125	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   376: iconst_0
    //   377: anewarray 4	java/lang/Object
    //   380: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   383: pop
    //   384: aload_1
    //   385: ifnull +14 -> 399
    //   388: aload_1
    //   389: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   392: ifeq +7 -> 399
    //   395: aload_1
    //   396: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   399: aload_0
    //   400: ifnull +7 -> 407
    //   403: aload_0
    //   404: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   407: ldc_w 256
    //   410: iconst_0
    //   411: anewarray 4	java/lang/Object
    //   414: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   417: pop
    //   418: iconst_m1
    //   419: ireturn
    //   420: astore_0
    //   421: aload 8
    //   423: astore_1
    //   424: aload_0
    //   425: astore 8
    //   427: aload 7
    //   429: astore_0
    //   430: aload_1
    //   431: ifnull +14 -> 445
    //   434: aload_1
    //   435: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   438: ifeq +7 -> 445
    //   441: aload_1
    //   442: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   445: aload_0
    //   446: ifnull +7 -> 453
    //   449: aload_0
    //   450: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   453: ldc_w 256
    //   456: iconst_0
    //   457: anewarray 4	java/lang/Object
    //   460: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   463: pop
    //   464: aload 8
    //   466: athrow
    //   467: iconst_0
    //   468: ireturn
    //   469: iload_3
    //   470: iconst_1
    //   471: iadd
    //   472: istore_3
    //   473: iload 4
    //   475: istore_2
    //   476: goto -402 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	479	0	paramContext	Context
    //   0	479	1	paramArrayOfLong	Long[]
    //   73	403	2	k	int
    //   71	402	3	m	int
    //   119	355	4	n	int
    //   86	16	5	l	long
    //   53	200	7	localObject1	Object
    //   329	6	7	localThrowable1	Throwable
    //   369	59	7	localContext	Context
    //   38	172	8	localStringBuilder	java.lang.StringBuilder
    //   321	1	8	localObject2	Object
    //   349	1	8	localObject3	Object
    //   366	99	8	localObject4	Object
    //   59	278	9	localObject5	Object
    //   341	1	9	localThrowable2	Throwable
    //   358	14	9	localThrowable3	Throwable
    //   41	322	10	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   61	70	321	finally
    //   74	118	321	finally
    //   135	222	321	finally
    //   227	258	321	finally
    //   258	286	321	finally
    //   61	70	329	java/lang/Throwable
    //   74	118	329	java/lang/Throwable
    //   135	222	329	java/lang/Throwable
    //   227	258	329	java/lang/Throwable
    //   258	286	329	java/lang/Throwable
    //   55	61	341	java/lang/Throwable
    //   43	52	349	finally
    //   43	52	358	java/lang/Throwable
    //   55	61	420	finally
    //   371	384	420	finally
  }
  
  public static ContentValues a(l paraml)
  {
    ContentValues localContentValues = new ContentValues();
    long l = paraml.a;
    if (l > 0L) {
      localContentValues.put("_id", Long.valueOf(l));
    }
    localContentValues.put("_prority", Integer.valueOf(paraml.c));
    localContentValues.put("_time", Long.valueOf(paraml.d));
    localContentValues.put("_type", Integer.valueOf(paraml.b));
    localContentValues.put("_datas", paraml.e);
    localContentValues.put("_length", Long.valueOf(paraml.f));
    localContentValues.put("_key", paraml.g);
    localContentValues.put("_count", Integer.valueOf(paraml.c()));
    localContentValues.put("_upCounts", Integer.valueOf(paraml.d()));
    localContentValues.put("_state", Integer.valueOf(paraml.e()));
    return localContentValues;
  }
  
  /* Error */
  public static List<o> a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: aload_0
    //   7: ifnull +882 -> 889
    //   10: iload_3
    //   11: ifne +6 -> 17
    //   14: goto +875 -> 889
    //   17: aload_1
    //   18: ifnonnull +11 -> 29
    //   21: ldc_w 305
    //   24: astore 5
    //   26: goto +6 -> 32
    //   29: aload_1
    //   30: astore 5
    //   32: ldc_w 307
    //   35: iconst_3
    //   36: anewarray 4	java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: aload 5
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: iload_2
    //   47: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: aastore
    //   51: dup
    //   52: iconst_2
    //   53: iload_3
    //   54: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aastore
    //   58: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   61: pop
    //   62: iconst_m1
    //   63: istore 4
    //   65: new 68	com/tencent/feedback/proguard/n
    //   68: dup
    //   69: aload_0
    //   70: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   73: astore 7
    //   75: aload 7
    //   77: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   80: astore 8
    //   82: aload 8
    //   84: ifnonnull +86 -> 170
    //   87: ldc_w 309
    //   90: iconst_0
    //   91: anewarray 4	java/lang/Object
    //   94: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   97: pop
    //   98: ldc_w 311
    //   101: iconst_0
    //   102: anewarray 4	java/lang/Object
    //   105: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   108: pop
    //   109: aload 8
    //   111: ifnull +16 -> 127
    //   114: aload 8
    //   116: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   119: ifeq +8 -> 127
    //   122: aload 8
    //   124: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   127: aload 7
    //   129: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   132: ldc_w 313
    //   135: iconst_1
    //   136: anewarray 4	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: iconst_m1
    //   142: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   145: aastore
    //   146: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   149: pop
    //   150: ldc_w 315
    //   153: iconst_1
    //   154: anewarray 4	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: iconst_m1
    //   160: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   163: aastore
    //   164: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   167: pop
    //   168: aconst_null
    //   169: areturn
    //   170: new 227	java/lang/StringBuffer
    //   173: dup
    //   174: invokespecial 228	java/lang/StringBuffer:<init>	()V
    //   177: astore_0
    //   178: aload_1
    //   179: ifnull +48 -> 227
    //   182: aload_0
    //   183: invokevirtual 252	java/lang/StringBuffer:length	()I
    //   186: ifle +11 -> 197
    //   189: aload_0
    //   190: ldc_w 317
    //   193: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   196: pop
    //   197: aload_0
    //   198: ldc_w 319
    //   201: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   204: pop
    //   205: aload_0
    //   206: ldc_w 321
    //   209: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   212: pop
    //   213: aload_0
    //   214: aload_1
    //   215: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   218: pop
    //   219: aload_0
    //   220: ldc_w 323
    //   223: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   226: pop
    //   227: iload_2
    //   228: iflt +40 -> 268
    //   231: aload_0
    //   232: invokevirtual 252	java/lang/StringBuffer:length	()I
    //   235: ifle +11 -> 246
    //   238: aload_0
    //   239: ldc_w 317
    //   242: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   245: pop
    //   246: aload_0
    //   247: ldc_w 325
    //   250: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   253: pop
    //   254: aload_0
    //   255: ldc_w 327
    //   258: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   261: pop
    //   262: aload_0
    //   263: iload_2
    //   264: invokevirtual 330	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   267: pop
    //   268: aload_0
    //   269: invokevirtual 252	java/lang/StringBuffer:length	()I
    //   272: ifle +637 -> 909
    //   275: aload_0
    //   276: invokevirtual 331	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   279: astore_0
    //   280: goto +3 -> 283
    //   283: iload_3
    //   284: ifle +630 -> 914
    //   287: new 95	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   294: astore_1
    //   295: aload_1
    //   296: iload_3
    //   297: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload_1
    //   302: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: astore_1
    //   306: goto +3 -> 309
    //   309: aload 8
    //   311: ldc 110
    //   313: aconst_null
    //   314: aload_0
    //   315: aconst_null
    //   316: aconst_null
    //   317: aconst_null
    //   318: aconst_null
    //   319: aload_1
    //   320: invokevirtual 334	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   323: astore 6
    //   325: aload 6
    //   327: ifnull +130 -> 457
    //   330: new 336	java/util/ArrayList
    //   333: dup
    //   334: invokespecial 337	java/util/ArrayList:<init>	()V
    //   337: astore_0
    //   338: aload_0
    //   339: astore_1
    //   340: aload 6
    //   342: invokeinterface 202 1 0
    //   347: ifeq +112 -> 459
    //   350: aload 6
    //   352: invokestatic 340	com/tencent/feedback/proguard/l:b	(Landroid/database/Cursor;)Lcom/tencent/feedback/proguard/o;
    //   355: astore 5
    //   357: aload_0
    //   358: astore_1
    //   359: aload 5
    //   361: ifnull +98 -> 459
    //   364: ldc_w 342
    //   367: iconst_4
    //   368: anewarray 4	java/lang/Object
    //   371: dup
    //   372: iconst_0
    //   373: aload 5
    //   375: invokevirtual 346	com/tencent/feedback/proguard/o:a	()Ljava/lang/String;
    //   378: aastore
    //   379: dup
    //   380: iconst_1
    //   381: aload 5
    //   383: invokevirtual 348	com/tencent/feedback/proguard/o:d	()Ljava/lang/String;
    //   386: aastore
    //   387: dup
    //   388: iconst_2
    //   389: aload 5
    //   391: invokevirtual 349	com/tencent/feedback/proguard/o:e	()I
    //   394: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   397: aastore
    //   398: dup
    //   399: iconst_3
    //   400: aload 5
    //   402: invokevirtual 351	com/tencent/feedback/proguard/o:f	()Ljava/lang/String;
    //   405: aastore
    //   406: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   409: pop
    //   410: aload_0
    //   411: aload 5
    //   413: invokeinterface 357 2 0
    //   418: pop
    //   419: goto -81 -> 338
    //   422: astore 5
    //   424: aload_0
    //   425: astore_1
    //   426: goto +11 -> 437
    //   429: astore_1
    //   430: goto +20 -> 450
    //   433: astore 5
    //   435: aconst_null
    //   436: astore_1
    //   437: aload 5
    //   439: astore_0
    //   440: aload 8
    //   442: astore 5
    //   444: goto +343 -> 787
    //   447: astore_1
    //   448: aconst_null
    //   449: astore_0
    //   450: aload 8
    //   452: astore 5
    //   454: goto +182 -> 636
    //   457: aconst_null
    //   458: astore_1
    //   459: aload 6
    //   461: ifnull +20 -> 481
    //   464: aload 6
    //   466: invokeinterface 217 1 0
    //   471: ifne +10 -> 481
    //   474: aload 6
    //   476: invokeinterface 218 1 0
    //   481: aload 8
    //   483: ifnull +16 -> 499
    //   486: aload 8
    //   488: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   491: ifeq +8 -> 499
    //   494: aload 8
    //   496: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   499: aload 7
    //   501: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   504: aload_1
    //   505: ifnull +11 -> 516
    //   508: aload_1
    //   509: invokeinterface 360 1 0
    //   514: istore 4
    //   516: ldc_w 313
    //   519: iconst_1
    //   520: anewarray 4	java/lang/Object
    //   523: dup
    //   524: iconst_0
    //   525: iload 4
    //   527: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   530: aastore
    //   531: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   534: pop
    //   535: iconst_1
    //   536: anewarray 4	java/lang/Object
    //   539: astore_0
    //   540: aload_0
    //   541: iconst_0
    //   542: iload 4
    //   544: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   547: aastore
    //   548: goto +222 -> 770
    //   551: astore_0
    //   552: aconst_null
    //   553: astore_1
    //   554: aload 10
    //   556: astore 6
    //   558: aload 8
    //   560: astore 5
    //   562: goto +225 -> 787
    //   565: astore_1
    //   566: aconst_null
    //   567: astore_0
    //   568: aload 9
    //   570: astore 6
    //   572: aload 8
    //   574: astore 5
    //   576: goto +60 -> 636
    //   579: astore_0
    //   580: aconst_null
    //   581: astore_1
    //   582: aload_1
    //   583: astore 5
    //   585: aload 10
    //   587: astore 6
    //   589: goto +198 -> 787
    //   592: astore_1
    //   593: aconst_null
    //   594: astore_0
    //   595: aload_0
    //   596: astore 5
    //   598: aload 9
    //   600: astore 6
    //   602: goto +34 -> 636
    //   605: astore_0
    //   606: aconst_null
    //   607: astore_1
    //   608: aload_1
    //   609: astore 7
    //   611: aload 7
    //   613: astore 5
    //   615: aload 10
    //   617: astore 6
    //   619: goto +168 -> 787
    //   622: astore_1
    //   623: aconst_null
    //   624: astore_0
    //   625: aload_0
    //   626: astore 7
    //   628: aload 7
    //   630: astore 5
    //   632: aload 9
    //   634: astore 6
    //   636: ldc_w 362
    //   639: iconst_0
    //   640: anewarray 4	java/lang/Object
    //   643: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   646: pop
    //   647: ldc_w 311
    //   650: iconst_0
    //   651: anewarray 4	java/lang/Object
    //   654: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   657: pop
    //   658: aload_1
    //   659: invokestatic 128	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   662: ifne +7 -> 669
    //   665: aload_1
    //   666: invokevirtual 131	java/lang/Throwable:printStackTrace	()V
    //   669: aload 6
    //   671: ifnull +20 -> 691
    //   674: aload 6
    //   676: invokeinterface 217 1 0
    //   681: ifne +10 -> 691
    //   684: aload 6
    //   686: invokeinterface 218 1 0
    //   691: aload 5
    //   693: ifnull +16 -> 709
    //   696: aload 5
    //   698: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   701: ifeq +8 -> 709
    //   704: aload 5
    //   706: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   709: aload 7
    //   711: ifnull +8 -> 719
    //   714: aload 7
    //   716: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   719: aload_0
    //   720: ifnull +11 -> 731
    //   723: aload_0
    //   724: invokeinterface 360 1 0
    //   729: istore 4
    //   731: ldc_w 313
    //   734: iconst_1
    //   735: anewarray 4	java/lang/Object
    //   738: dup
    //   739: iconst_0
    //   740: iload 4
    //   742: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   745: aastore
    //   746: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   749: pop
    //   750: iconst_1
    //   751: anewarray 4	java/lang/Object
    //   754: astore 5
    //   756: aload 5
    //   758: iconst_0
    //   759: iload 4
    //   761: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   764: aastore
    //   765: aload_0
    //   766: astore_1
    //   767: aload 5
    //   769: astore_0
    //   770: ldc_w 315
    //   773: aload_0
    //   774: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   777: pop
    //   778: aload_1
    //   779: areturn
    //   780: astore 8
    //   782: aload_0
    //   783: astore_1
    //   784: aload 8
    //   786: astore_0
    //   787: aload 6
    //   789: ifnull +20 -> 809
    //   792: aload 6
    //   794: invokeinterface 217 1 0
    //   799: ifne +10 -> 809
    //   802: aload 6
    //   804: invokeinterface 218 1 0
    //   809: aload 5
    //   811: ifnull +16 -> 827
    //   814: aload 5
    //   816: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   819: ifeq +8 -> 827
    //   822: aload 5
    //   824: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   827: aload 7
    //   829: ifnull +8 -> 837
    //   832: aload 7
    //   834: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   837: aload_1
    //   838: ifnull +11 -> 849
    //   841: aload_1
    //   842: invokeinterface 360 1 0
    //   847: istore 4
    //   849: ldc_w 313
    //   852: iconst_1
    //   853: anewarray 4	java/lang/Object
    //   856: dup
    //   857: iconst_0
    //   858: iload 4
    //   860: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   863: aastore
    //   864: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   867: pop
    //   868: ldc_w 315
    //   871: iconst_1
    //   872: anewarray 4	java/lang/Object
    //   875: dup
    //   876: iconst_0
    //   877: iload 4
    //   879: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   882: aastore
    //   883: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   886: pop
    //   887: aload_0
    //   888: athrow
    //   889: ldc_w 364
    //   892: iconst_1
    //   893: anewarray 4	java/lang/Object
    //   896: dup
    //   897: iconst_0
    //   898: iload_3
    //   899: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   902: aastore
    //   903: invokestatic 56	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   906: pop
    //   907: aconst_null
    //   908: areturn
    //   909: aconst_null
    //   910: astore_0
    //   911: goto -628 -> 283
    //   914: aconst_null
    //   915: astore_1
    //   916: goto -607 -> 309
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	919	0	paramContext	Context
    //   0	919	1	paramString	String
    //   0	919	2	paramInt1	int
    //   0	919	3	paramInt2	int
    //   63	815	4	k	int
    //   24	388	5	localObject1	Object
    //   422	1	5	localObject2	Object
    //   433	5	5	localObject3	Object
    //   442	381	5	localObject4	Object
    //   323	480	6	localObject5	Object
    //   73	760	7	localObject6	Object
    //   80	493	8	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   780	5	8	localObject7	Object
    //   4	629	9	localObject8	Object
    //   1	615	10	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   340	357	422	finally
    //   364	419	422	finally
    //   340	357	429	java/lang/Throwable
    //   364	419	429	java/lang/Throwable
    //   330	338	433	finally
    //   330	338	447	java/lang/Throwable
    //   87	109	551	finally
    //   170	178	551	finally
    //   182	197	551	finally
    //   197	227	551	finally
    //   231	246	551	finally
    //   246	268	551	finally
    //   268	280	551	finally
    //   287	306	551	finally
    //   309	325	551	finally
    //   87	109	565	java/lang/Throwable
    //   170	178	565	java/lang/Throwable
    //   182	197	565	java/lang/Throwable
    //   197	227	565	java/lang/Throwable
    //   231	246	565	java/lang/Throwable
    //   246	268	565	java/lang/Throwable
    //   268	280	565	java/lang/Throwable
    //   287	306	565	java/lang/Throwable
    //   309	325	565	java/lang/Throwable
    //   75	82	579	finally
    //   75	82	592	java/lang/Throwable
    //   65	75	605	finally
    //   65	75	622	java/lang/Throwable
    //   636	669	780	finally
  }
  
  public static List<l> a(Context paramContext, int[] paramArrayOfInt, int paramInt1, int paramInt2, long paramLong1, int paramInt3, String paramString, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong2, long paramLong3)
  {
    return a(paramContext, paramArrayOfInt, -1, -1, paramLong1, paramInt3, paramString, -1, -1, -1, -1, -1L, 9223372036854775807L, -1);
  }
  
  /* Error */
  public static List<l> a(Context paramContext, int[] paramArrayOfInt, int paramInt1, int paramInt2, long paramLong1, int paramInt3, String paramString, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong2, long paramLong3, int paramInt8)
  {
    // Byte code:
    //   0: ldc_w 375
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: ifnull +2456 -> 2468
    //   15: lload 4
    //   17: lconst_0
    //   18: lcmp
    //   19: ifeq +2449 -> 2468
    //   22: lload 14
    //   24: lconst_0
    //   25: lcmp
    //   26: ifle +11 -> 37
    //   29: lload 12
    //   31: lload 14
    //   33: lcmp
    //   34: ifgt +2434 -> 2468
    //   37: iload 9
    //   39: ifle +10 -> 49
    //   42: iload 8
    //   44: iload 9
    //   46: if_icmpgt +2422 -> 2468
    //   49: iload 11
    //   51: ifle +13 -> 64
    //   54: iload 10
    //   56: iload 11
    //   58: if_icmple +6 -> 64
    //   61: goto +2407 -> 2468
    //   64: lload 4
    //   66: lconst_0
    //   67: lcmp
    //   68: ifge +11 -> 79
    //   71: ldc2_w 368
    //   74: lstore 4
    //   76: goto +3 -> 79
    //   79: ldc 160
    //   81: astore 19
    //   83: aload 19
    //   85: astore 18
    //   87: aload_1
    //   88: ifnull +109 -> 197
    //   91: aload 19
    //   93: astore 18
    //   95: aload_1
    //   96: arraylength
    //   97: ifle +100 -> 197
    //   100: ldc 160
    //   102: astore 18
    //   104: iconst_0
    //   105: istore 17
    //   107: iload 17
    //   109: aload_1
    //   110: arraylength
    //   111: if_icmpge +54 -> 165
    //   114: new 95	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   121: astore 19
    //   123: aload 19
    //   125: aload 18
    //   127: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload 19
    //   133: ldc 162
    //   135: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload 19
    //   141: aload_1
    //   142: iload 17
    //   144: iaload
    //   145: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload 19
    //   151: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: astore 18
    //   156: iload 17
    //   158: iconst_1
    //   159: iadd
    //   160: istore 17
    //   162: goto -55 -> 107
    //   165: new 95	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   172: astore_1
    //   173: aload_1
    //   174: ldc 160
    //   176: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_1
    //   181: aload 18
    //   183: iconst_4
    //   184: invokevirtual 168	java/lang/String:substring	(I)Ljava/lang/String;
    //   187: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_1
    //   192: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: astore 18
    //   197: aload 18
    //   199: invokevirtual 376	java/lang/String:length	()I
    //   202: ifle +38 -> 240
    //   205: new 95	java/lang/StringBuilder
    //   208: dup
    //   209: ldc_w 378
    //   212: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   215: astore_1
    //   216: aload_1
    //   217: aload 18
    //   219: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload_1
    //   224: ldc_w 380
    //   227: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload_1
    //   232: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: astore 18
    //   237: goto +7 -> 244
    //   240: ldc 160
    //   242: astore 18
    //   244: aload 18
    //   246: astore_1
    //   247: aload 7
    //   249: ifnull +77 -> 326
    //   252: new 95	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   259: astore 19
    //   261: aload 19
    //   263: aload 18
    //   265: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload 18
    //   271: invokevirtual 376	java/lang/String:length	()I
    //   274: ifle +10 -> 284
    //   277: ldc_w 317
    //   280: astore_1
    //   281: goto +6 -> 287
    //   284: ldc 160
    //   286: astore_1
    //   287: aload 19
    //   289: aload_1
    //   290: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload 19
    //   296: ldc_w 382
    //   299: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload 19
    //   305: aload 7
    //   307: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload 19
    //   313: ldc_w 323
    //   316: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload 19
    //   322: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: astore_1
    //   326: aload_1
    //   327: astore 7
    //   329: iload 8
    //   331: iflt +76 -> 407
    //   334: new 95	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   341: astore 7
    //   343: aload 7
    //   345: aload_1
    //   346: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload_1
    //   351: invokevirtual 376	java/lang/String:length	()I
    //   354: ifle +10 -> 364
    //   357: ldc_w 317
    //   360: astore_1
    //   361: goto +6 -> 367
    //   364: ldc 160
    //   366: astore_1
    //   367: aload 7
    //   369: aload_1
    //   370: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload 7
    //   376: ldc_w 384
    //   379: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload 7
    //   385: iload 8
    //   387: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: aload 7
    //   393: ldc_w 386
    //   396: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload 7
    //   402: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: astore 7
    //   407: aload 7
    //   409: astore_1
    //   410: iload 9
    //   412: iflt +77 -> 489
    //   415: new 95	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   422: astore 18
    //   424: aload 18
    //   426: aload 7
    //   428: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: aload 7
    //   434: invokevirtual 376	java/lang/String:length	()I
    //   437: ifle +10 -> 447
    //   440: ldc_w 317
    //   443: astore_1
    //   444: goto +6 -> 450
    //   447: ldc 160
    //   449: astore_1
    //   450: aload 18
    //   452: aload_1
    //   453: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: aload 18
    //   459: ldc_w 388
    //   462: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload 18
    //   468: iload 9
    //   470: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   473: pop
    //   474: aload 18
    //   476: ldc_w 386
    //   479: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: aload 18
    //   485: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: astore_1
    //   489: aload_1
    //   490: astore 7
    //   492: iload 10
    //   494: iflt +76 -> 570
    //   497: new 95	java/lang/StringBuilder
    //   500: dup
    //   501: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   504: astore 7
    //   506: aload 7
    //   508: aload_1
    //   509: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: pop
    //   513: aload_1
    //   514: invokevirtual 376	java/lang/String:length	()I
    //   517: ifle +10 -> 527
    //   520: ldc_w 317
    //   523: astore_1
    //   524: goto +6 -> 530
    //   527: ldc 160
    //   529: astore_1
    //   530: aload 7
    //   532: aload_1
    //   533: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: aload 7
    //   539: ldc_w 390
    //   542: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: pop
    //   546: aload 7
    //   548: iload 10
    //   550: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: aload 7
    //   556: ldc_w 386
    //   559: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: pop
    //   563: aload 7
    //   565: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: astore 7
    //   570: iload 11
    //   572: iflt +81 -> 653
    //   575: new 95	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   582: astore 18
    //   584: aload 18
    //   586: aload 7
    //   588: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: pop
    //   592: aload 7
    //   594: invokevirtual 376	java/lang/String:length	()I
    //   597: ifle +10 -> 607
    //   600: ldc_w 317
    //   603: astore_1
    //   604: goto +6 -> 610
    //   607: ldc 160
    //   609: astore_1
    //   610: aload 18
    //   612: aload_1
    //   613: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: pop
    //   617: aload 18
    //   619: ldc_w 392
    //   622: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: pop
    //   626: aload 18
    //   628: iload 11
    //   630: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   633: pop
    //   634: aload 18
    //   636: ldc_w 386
    //   639: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: pop
    //   643: aload 18
    //   645: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: astore 7
    //   650: goto +3 -> 653
    //   653: lload 12
    //   655: lconst_0
    //   656: lcmp
    //   657: iflt +80 -> 737
    //   660: new 95	java/lang/StringBuilder
    //   663: dup
    //   664: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   667: astore 18
    //   669: aload 18
    //   671: aload 7
    //   673: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: pop
    //   677: aload 7
    //   679: invokevirtual 376	java/lang/String:length	()I
    //   682: ifle +10 -> 692
    //   685: ldc_w 317
    //   688: astore_1
    //   689: goto +6 -> 695
    //   692: ldc 160
    //   694: astore_1
    //   695: aload 18
    //   697: aload_1
    //   698: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: pop
    //   702: aload 18
    //   704: ldc 143
    //   706: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: pop
    //   710: aload 18
    //   712: lload 12
    //   714: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   717: pop
    //   718: aload 18
    //   720: ldc_w 386
    //   723: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: pop
    //   727: aload 18
    //   729: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   732: astore 7
    //   734: goto +3 -> 737
    //   737: aload 7
    //   739: astore_1
    //   740: lload 14
    //   742: lconst_0
    //   743: lcmp
    //   744: iflt +77 -> 821
    //   747: new 95	java/lang/StringBuilder
    //   750: dup
    //   751: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   754: astore 18
    //   756: aload 18
    //   758: aload 7
    //   760: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: pop
    //   764: aload 7
    //   766: invokevirtual 376	java/lang/String:length	()I
    //   769: ifle +10 -> 779
    //   772: ldc_w 317
    //   775: astore_1
    //   776: goto +6 -> 782
    //   779: ldc 160
    //   781: astore_1
    //   782: aload 18
    //   784: aload_1
    //   785: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: pop
    //   789: aload 18
    //   791: ldc_w 394
    //   794: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: pop
    //   798: aload 18
    //   800: lload 14
    //   802: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   805: pop
    //   806: aload 18
    //   808: ldc_w 386
    //   811: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: pop
    //   815: aload 18
    //   817: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   820: astore_1
    //   821: aload_1
    //   822: astore 18
    //   824: iload 16
    //   826: iflt +76 -> 902
    //   829: new 95	java/lang/StringBuilder
    //   832: dup
    //   833: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   836: astore 7
    //   838: aload 7
    //   840: aload_1
    //   841: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: pop
    //   845: aload_1
    //   846: invokevirtual 376	java/lang/String:length	()I
    //   849: ifle +10 -> 859
    //   852: ldc_w 317
    //   855: astore_1
    //   856: goto +6 -> 862
    //   859: ldc 160
    //   861: astore_1
    //   862: aload 7
    //   864: aload_1
    //   865: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: pop
    //   869: aload 7
    //   871: ldc_w 396
    //   874: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: pop
    //   878: aload 7
    //   880: iload 16
    //   882: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   885: pop
    //   886: aload 7
    //   888: ldc_w 386
    //   891: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: pop
    //   895: aload 7
    //   897: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   900: astore 18
    //   902: ldc 160
    //   904: astore_1
    //   905: iload_2
    //   906: tableswitch	default:+22 -> 928, 1:+56->962, 2:+25->931
    //   929: nop
    //   930: istore_3
    //   931: new 95	java/lang/StringBuilder
    //   934: dup
    //   935: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   938: astore_1
    //   939: aload_1
    //   940: ldc 160
    //   942: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   945: pop
    //   946: aload_1
    //   947: ldc_w 398
    //   950: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: pop
    //   954: aload_1
    //   955: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   958: astore_1
    //   959: goto +31 -> 990
    //   962: new 95	java/lang/StringBuilder
    //   965: dup
    //   966: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   969: astore_1
    //   970: aload_1
    //   971: ldc 160
    //   973: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: pop
    //   977: aload_1
    //   978: ldc_w 400
    //   981: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: pop
    //   985: aload_1
    //   986: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   989: astore_1
    //   990: iload_3
    //   991: tableswitch	default:+21 -> 1012, 1:+58->1049, 2:+24->1015
    //   1013: nop
    //   1014: fstore_1
    //   1015: new 95	java/lang/StringBuilder
    //   1018: dup
    //   1019: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1022: astore 7
    //   1024: aload 7
    //   1026: aload_1
    //   1027: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1030: pop
    //   1031: aload 7
    //   1033: ldc_w 402
    //   1036: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: pop
    //   1040: aload 7
    //   1042: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1045: astore_1
    //   1046: goto +34 -> 1080
    //   1049: new 95	java/lang/StringBuilder
    //   1052: dup
    //   1053: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1056: astore 7
    //   1058: aload 7
    //   1060: aload_1
    //   1061: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: pop
    //   1065: aload 7
    //   1067: ldc_w 404
    //   1070: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1073: pop
    //   1074: aload 7
    //   1076: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1079: astore_1
    //   1080: aload_1
    //   1081: ldc_w 406
    //   1084: invokevirtual 410	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1087: ifeq +18 -> 1105
    //   1090: aload_1
    //   1091: iconst_0
    //   1092: aload_1
    //   1093: invokevirtual 376	java/lang/String:length	()I
    //   1096: iconst_3
    //   1097: isub
    //   1098: invokevirtual 413	java/lang/String:substring	(II)Ljava/lang/String;
    //   1101: astore_1
    //   1102: goto +3 -> 1105
    //   1105: ldc_w 415
    //   1108: iconst_1
    //   1109: anewarray 4	java/lang/Object
    //   1112: dup
    //   1113: iconst_0
    //   1114: aload 18
    //   1116: aastore
    //   1117: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1120: pop
    //   1121: new 336	java/util/ArrayList
    //   1124: dup
    //   1125: invokespecial 337	java/util/ArrayList:<init>	()V
    //   1128: astore 21
    //   1130: new 68	com/tencent/feedback/proguard/n
    //   1133: dup
    //   1134: aload_0
    //   1135: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   1138: astore 7
    //   1140: aload 7
    //   1142: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   1145: astore 19
    //   1147: lload 4
    //   1149: lconst_0
    //   1150: lcmp
    //   1151: ifle +1007 -> 2158
    //   1154: aload_1
    //   1155: astore_0
    //   1156: aload_1
    //   1157: invokevirtual 376	java/lang/String:length	()I
    //   1160: ifle +30 -> 1190
    //   1163: new 95	java/lang/StringBuilder
    //   1166: dup
    //   1167: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1170: astore_0
    //   1171: aload_0
    //   1172: aload_1
    //   1173: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1176: pop
    //   1177: aload_0
    //   1178: ldc_w 406
    //   1181: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1184: pop
    //   1185: aload_0
    //   1186: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1189: astore_0
    //   1190: new 95	java/lang/StringBuilder
    //   1193: dup
    //   1194: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1197: astore_1
    //   1198: aload_1
    //   1199: aload_0
    //   1200: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1203: pop
    //   1204: aload_1
    //   1205: ldc_w 417
    //   1208: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1211: pop
    //   1212: aload_1
    //   1213: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1216: astore 20
    //   1218: iload 6
    //   1220: iflt +1261 -> 2481
    //   1223: new 95	java/lang/StringBuilder
    //   1226: dup
    //   1227: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1230: astore_0
    //   1231: aload_0
    //   1232: iload 6
    //   1234: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1237: pop
    //   1238: aload_0
    //   1239: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1242: astore_0
    //   1243: goto +3 -> 1246
    //   1246: aload 19
    //   1248: ldc 176
    //   1250: iconst_2
    //   1251: anewarray 164	java/lang/String
    //   1254: dup
    //   1255: iconst_0
    //   1256: ldc_w 262
    //   1259: aastore
    //   1260: dup
    //   1261: iconst_1
    //   1262: ldc_w 285
    //   1265: aastore
    //   1266: aload 18
    //   1268: aconst_null
    //   1269: aconst_null
    //   1270: aconst_null
    //   1271: aload 20
    //   1273: aload_0
    //   1274: invokevirtual 334	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1277: astore 18
    //   1279: aload 18
    //   1281: astore_1
    //   1282: aload 18
    //   1284: astore_0
    //   1285: aload 18
    //   1287: ldc_w 262
    //   1290: invokeinterface 208 2 0
    //   1295: istore_2
    //   1296: aload 18
    //   1298: astore_1
    //   1299: aload 18
    //   1301: astore_0
    //   1302: aload 18
    //   1304: ldc_w 285
    //   1307: invokeinterface 208 2 0
    //   1312: istore_3
    //   1313: aload 18
    //   1315: astore_1
    //   1316: aload 18
    //   1318: astore_0
    //   1319: new 419	java/util/LinkedHashMap
    //   1322: dup
    //   1323: invokespecial 420	java/util/LinkedHashMap:<init>	()V
    //   1326: astore 22
    //   1328: aload 18
    //   1330: astore_1
    //   1331: aload 18
    //   1333: astore_0
    //   1334: aload 18
    //   1336: invokeinterface 202 1 0
    //   1341: ifeq +40 -> 1381
    //   1344: aload 18
    //   1346: astore_1
    //   1347: aload 18
    //   1349: astore_0
    //   1350: aload 22
    //   1352: aload 18
    //   1354: iload_2
    //   1355: invokeinterface 424 2 0
    //   1360: invokestatic 265	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1363: aload 18
    //   1365: iload_3
    //   1366: invokeinterface 424 2 0
    //   1371: invokestatic 265	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1374: invokevirtual 427	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1377: pop
    //   1378: goto -50 -> 1328
    //   1381: aload 18
    //   1383: astore_1
    //   1384: aload 18
    //   1386: astore_0
    //   1387: aload 18
    //   1389: invokeinterface 218 1 0
    //   1394: aload 18
    //   1396: astore_1
    //   1397: aload 18
    //   1399: astore_0
    //   1400: aload 22
    //   1402: lload 4
    //   1404: invokestatic 432	com/tencent/feedback/proguard/a:a	(Ljava/util/LinkedHashMap;J)[Ljava/lang/Long;
    //   1407: astore 22
    //   1409: aload 22
    //   1411: ifnull +689 -> 2100
    //   1414: aload 18
    //   1416: astore_1
    //   1417: aload 18
    //   1419: astore_0
    //   1420: aload 22
    //   1422: arraylength
    //   1423: ifle +677 -> 2100
    //   1426: aload 18
    //   1428: astore_1
    //   1429: aload 18
    //   1431: astore_0
    //   1432: new 95	java/lang/StringBuilder
    //   1435: dup
    //   1436: ldc_w 434
    //   1439: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1442: astore 23
    //   1444: aload 18
    //   1446: astore_1
    //   1447: aload 18
    //   1449: astore_0
    //   1450: aload 23
    //   1452: aload 22
    //   1454: arraylength
    //   1455: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1458: pop
    //   1459: aload 18
    //   1461: astore_1
    //   1462: aload 18
    //   1464: astore_0
    //   1465: aload 23
    //   1467: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1470: iconst_0
    //   1471: anewarray 4	java/lang/Object
    //   1474: invokestatic 141	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1477: pop
    //   1478: aload 18
    //   1480: astore_1
    //   1481: aload 18
    //   1483: astore_0
    //   1484: new 227	java/lang/StringBuffer
    //   1487: dup
    //   1488: invokespecial 228	java/lang/StringBuffer:<init>	()V
    //   1491: astore 23
    //   1493: aload 18
    //   1495: astore_0
    //   1496: iconst_0
    //   1497: istore_2
    //   1498: aload_0
    //   1499: astore 18
    //   1501: aload_0
    //   1502: astore_1
    //   1503: iload_2
    //   1504: aload 22
    //   1506: arraylength
    //   1507: if_icmpge +277 -> 1784
    //   1510: aload_0
    //   1511: astore 18
    //   1513: aload_0
    //   1514: astore_1
    //   1515: aload 22
    //   1517: iload_2
    //   1518: aaload
    //   1519: invokevirtual 234	java/lang/Long:longValue	()J
    //   1522: lstore 4
    //   1524: aload_0
    //   1525: astore 18
    //   1527: aload_0
    //   1528: astore_1
    //   1529: new 95	java/lang/StringBuilder
    //   1532: dup
    //   1533: ldc 236
    //   1535: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1538: astore 24
    //   1540: aload_0
    //   1541: astore 18
    //   1543: aload_0
    //   1544: astore_1
    //   1545: aload 24
    //   1547: lload 4
    //   1549: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1552: pop
    //   1553: aload_0
    //   1554: astore 18
    //   1556: aload_0
    //   1557: astore_1
    //   1558: aload 23
    //   1560: aload 24
    //   1562: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1565: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1568: pop
    //   1569: aload_0
    //   1570: astore_1
    //   1571: iload_2
    //   1572: ifle +914 -> 2486
    //   1575: aload_0
    //   1576: astore_1
    //   1577: iload_2
    //   1578: bipush 50
    //   1580: irem
    //   1581: ifne +905 -> 2486
    //   1584: aload_0
    //   1585: astore 18
    //   1587: aload_0
    //   1588: astore_1
    //   1589: new 95	java/lang/StringBuilder
    //   1592: dup
    //   1593: ldc 241
    //   1595: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1598: astore 24
    //   1600: aload_0
    //   1601: astore 18
    //   1603: aload_0
    //   1604: astore_1
    //   1605: aload 24
    //   1607: iload_2
    //   1608: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1611: pop
    //   1612: aload_0
    //   1613: astore 18
    //   1615: aload_0
    //   1616: astore_1
    //   1617: aload 24
    //   1619: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1622: iconst_0
    //   1623: anewarray 4	java/lang/Object
    //   1626: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1629: pop
    //   1630: aload_0
    //   1631: astore 18
    //   1633: aload_0
    //   1634: astore_1
    //   1635: aload 23
    //   1637: iconst_4
    //   1638: invokevirtual 242	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   1641: astore 24
    //   1643: aload_0
    //   1644: astore 18
    //   1646: aload_0
    //   1647: astore_1
    //   1648: aload 23
    //   1650: iconst_0
    //   1651: invokevirtual 246	java/lang/StringBuffer:setLength	(I)V
    //   1654: aload_0
    //   1655: astore 18
    //   1657: aload_0
    //   1658: astore_1
    //   1659: aload 19
    //   1661: ldc 176
    //   1663: aconst_null
    //   1664: aload 24
    //   1666: aconst_null
    //   1667: aconst_null
    //   1668: aconst_null
    //   1669: aload 20
    //   1671: invokevirtual 197	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1674: astore_0
    //   1675: aload_0
    //   1676: astore 18
    //   1678: aload_0
    //   1679: astore_1
    //   1680: aload_0
    //   1681: invokestatic 437	com/tencent/feedback/proguard/l:a	(Landroid/database/Cursor;)Ljava/util/List;
    //   1684: astore 24
    //   1686: aload 24
    //   1688: ifnull +80 -> 1768
    //   1691: aload_0
    //   1692: astore 18
    //   1694: aload_0
    //   1695: astore_1
    //   1696: aload 24
    //   1698: invokeinterface 360 1 0
    //   1703: ifle +65 -> 1768
    //   1706: aload_0
    //   1707: astore 18
    //   1709: aload_0
    //   1710: astore_1
    //   1711: aload 21
    //   1713: aload 24
    //   1715: invokeinterface 441 2 0
    //   1720: pop
    //   1721: aload_0
    //   1722: astore 18
    //   1724: aload_0
    //   1725: astore_1
    //   1726: new 95	java/lang/StringBuilder
    //   1729: dup
    //   1730: ldc_w 443
    //   1733: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1736: astore 24
    //   1738: aload_0
    //   1739: astore 18
    //   1741: aload_0
    //   1742: astore_1
    //   1743: aload 24
    //   1745: iconst_0
    //   1746: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1749: pop
    //   1750: aload_0
    //   1751: astore 18
    //   1753: aload_0
    //   1754: astore_1
    //   1755: aload 24
    //   1757: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1760: iconst_0
    //   1761: anewarray 4	java/lang/Object
    //   1764: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1767: pop
    //   1768: aload_0
    //   1769: astore 18
    //   1771: aload_0
    //   1772: astore_1
    //   1773: aload_0
    //   1774: invokeinterface 218 1 0
    //   1779: aload_0
    //   1780: astore_1
    //   1781: goto +705 -> 2486
    //   1784: aload_0
    //   1785: astore 18
    //   1787: aload_0
    //   1788: astore_1
    //   1789: aload 23
    //   1791: invokevirtual 252	java/lang/StringBuffer:length	()I
    //   1794: ifle +701 -> 2495
    //   1797: aload_0
    //   1798: astore 18
    //   1800: aload_0
    //   1801: astore_1
    //   1802: aload 23
    //   1804: iconst_4
    //   1805: invokevirtual 242	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   1808: astore 22
    //   1810: aload_0
    //   1811: astore 18
    //   1813: aload_0
    //   1814: astore_1
    //   1815: aload 23
    //   1817: iconst_0
    //   1818: invokevirtual 246	java/lang/StringBuffer:setLength	(I)V
    //   1821: aload_0
    //   1822: astore 18
    //   1824: aload_0
    //   1825: astore_1
    //   1826: aload 19
    //   1828: ldc 176
    //   1830: aconst_null
    //   1831: aload 22
    //   1833: aconst_null
    //   1834: aconst_null
    //   1835: aconst_null
    //   1836: aload 20
    //   1838: invokevirtual 197	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1841: astore 20
    //   1843: aload 20
    //   1845: astore_1
    //   1846: aload 20
    //   1848: astore_0
    //   1849: aload 20
    //   1851: invokestatic 437	com/tencent/feedback/proguard/l:a	(Landroid/database/Cursor;)Ljava/util/List;
    //   1854: astore 22
    //   1856: aload 20
    //   1858: astore 18
    //   1860: aload 22
    //   1862: ifnull +96 -> 1958
    //   1865: aload 20
    //   1867: astore 18
    //   1869: aload 20
    //   1871: astore_1
    //   1872: aload 20
    //   1874: astore_0
    //   1875: aload 22
    //   1877: invokeinterface 360 1 0
    //   1882: ifle +76 -> 1958
    //   1885: aload 20
    //   1887: astore_1
    //   1888: aload 20
    //   1890: astore_0
    //   1891: aload 21
    //   1893: aload 22
    //   1895: invokeinterface 441 2 0
    //   1900: pop
    //   1901: aload 20
    //   1903: astore_1
    //   1904: aload 20
    //   1906: astore_0
    //   1907: new 95	java/lang/StringBuilder
    //   1910: dup
    //   1911: ldc_w 443
    //   1914: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1917: astore 18
    //   1919: aload 20
    //   1921: astore_1
    //   1922: aload 20
    //   1924: astore_0
    //   1925: aload 18
    //   1927: iconst_0
    //   1928: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1931: pop
    //   1932: aload 20
    //   1934: astore_1
    //   1935: aload 20
    //   1937: astore_0
    //   1938: aload 18
    //   1940: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1943: iconst_0
    //   1944: anewarray 4	java/lang/Object
    //   1947: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1950: pop
    //   1951: aload 20
    //   1953: astore 18
    //   1955: goto +3 -> 1958
    //   1958: aload 18
    //   1960: astore_1
    //   1961: aload 18
    //   1963: astore_0
    //   1964: new 95	java/lang/StringBuilder
    //   1967: dup
    //   1968: ldc_w 445
    //   1971: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1974: astore 20
    //   1976: aload 18
    //   1978: astore_1
    //   1979: aload 18
    //   1981: astore_0
    //   1982: aload 20
    //   1984: aload 21
    //   1986: invokeinterface 360 1 0
    //   1991: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1994: pop
    //   1995: aload 18
    //   1997: astore_1
    //   1998: aload 18
    //   2000: astore_0
    //   2001: aload 20
    //   2003: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2006: iconst_0
    //   2007: anewarray 4	java/lang/Object
    //   2010: invokestatic 141	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   2013: pop
    //   2014: aload 18
    //   2016: ifnull +20 -> 2036
    //   2019: aload 18
    //   2021: invokeinterface 217 1 0
    //   2026: ifne +10 -> 2036
    //   2029: aload 18
    //   2031: invokeinterface 218 1 0
    //   2036: aload 19
    //   2038: ifnull +16 -> 2054
    //   2041: aload 19
    //   2043: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   2046: ifeq +8 -> 2054
    //   2049: aload 19
    //   2051: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   2054: aload 7
    //   2056: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   2059: ldc_w 447
    //   2062: iconst_0
    //   2063: anewarray 4	java/lang/Object
    //   2066: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   2069: pop
    //   2070: aload 21
    //   2072: areturn
    //   2073: astore_0
    //   2074: aload 18
    //   2076: astore_1
    //   2077: aload 19
    //   2079: astore 18
    //   2081: goto +324 -> 2405
    //   2084: astore 18
    //   2086: aload 7
    //   2088: astore_0
    //   2089: aload 18
    //   2091: astore 7
    //   2093: aload 19
    //   2095: astore 18
    //   2097: goto +239 -> 2336
    //   2100: aload 18
    //   2102: ifnull +20 -> 2122
    //   2105: aload 18
    //   2107: invokeinterface 217 1 0
    //   2112: ifne +10 -> 2122
    //   2115: aload 18
    //   2117: invokeinterface 218 1 0
    //   2122: aload 19
    //   2124: ifnull +16 -> 2140
    //   2127: aload 19
    //   2129: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   2132: ifeq +8 -> 2140
    //   2135: aload 19
    //   2137: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   2140: aload 7
    //   2142: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   2145: ldc_w 447
    //   2148: iconst_0
    //   2149: anewarray 4	java/lang/Object
    //   2152: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   2155: pop
    //   2156: aconst_null
    //   2157: areturn
    //   2158: aload 19
    //   2160: ldc 176
    //   2162: aconst_null
    //   2163: aload 18
    //   2165: aconst_null
    //   2166: aconst_null
    //   2167: aconst_null
    //   2168: aload_1
    //   2169: invokevirtual 197	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2172: astore 18
    //   2174: aload 18
    //   2176: astore_1
    //   2177: aload 18
    //   2179: astore_0
    //   2180: aload 18
    //   2182: invokestatic 437	com/tencent/feedback/proguard/l:a	(Landroid/database/Cursor;)Ljava/util/List;
    //   2185: astore 20
    //   2187: aload 18
    //   2189: ifnull +20 -> 2209
    //   2192: aload 18
    //   2194: invokeinterface 217 1 0
    //   2199: ifne +10 -> 2209
    //   2202: aload 18
    //   2204: invokeinterface 218 1 0
    //   2209: aload 19
    //   2211: ifnull +16 -> 2227
    //   2214: aload 19
    //   2216: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   2219: ifeq +8 -> 2227
    //   2222: aload 19
    //   2224: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   2227: aload 7
    //   2229: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   2232: ldc_w 447
    //   2235: iconst_0
    //   2236: anewarray 4	java/lang/Object
    //   2239: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   2242: pop
    //   2243: aload 20
    //   2245: areturn
    //   2246: astore_0
    //   2247: aload 19
    //   2249: astore 18
    //   2251: goto +154 -> 2405
    //   2254: astore 18
    //   2256: aload_0
    //   2257: astore_1
    //   2258: aload 7
    //   2260: astore_0
    //   2261: aload 18
    //   2263: astore 7
    //   2265: aload 19
    //   2267: astore 18
    //   2269: goto +67 -> 2336
    //   2272: astore_0
    //   2273: aconst_null
    //   2274: astore_1
    //   2275: aload 19
    //   2277: astore 18
    //   2279: goto +126 -> 2405
    //   2282: astore_1
    //   2283: aload 7
    //   2285: astore_0
    //   2286: aload_1
    //   2287: astore 7
    //   2289: aload 19
    //   2291: astore 18
    //   2293: goto +41 -> 2334
    //   2296: astore_0
    //   2297: aconst_null
    //   2298: astore_1
    //   2299: aconst_null
    //   2300: astore 18
    //   2302: goto +103 -> 2405
    //   2305: astore_1
    //   2306: aload 7
    //   2308: astore_0
    //   2309: aload_1
    //   2310: astore 7
    //   2312: goto +19 -> 2331
    //   2315: astore_0
    //   2316: aconst_null
    //   2317: astore_1
    //   2318: aconst_null
    //   2319: astore 18
    //   2321: aconst_null
    //   2322: astore 7
    //   2324: goto +81 -> 2405
    //   2327: astore 7
    //   2329: aconst_null
    //   2330: astore_0
    //   2331: aconst_null
    //   2332: astore 18
    //   2334: aconst_null
    //   2335: astore_1
    //   2336: aload 7
    //   2338: invokevirtual 125	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   2341: iconst_0
    //   2342: anewarray 4	java/lang/Object
    //   2345: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   2348: pop
    //   2349: aload_1
    //   2350: ifnull +18 -> 2368
    //   2353: aload_1
    //   2354: invokeinterface 217 1 0
    //   2359: ifne +9 -> 2368
    //   2362: aload_1
    //   2363: invokeinterface 218 1 0
    //   2368: aload 18
    //   2370: ifnull +16 -> 2386
    //   2373: aload 18
    //   2375: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   2378: ifeq +8 -> 2386
    //   2381: aload 18
    //   2383: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   2386: aload_0
    //   2387: ifnull -242 -> 2145
    //   2390: aload_0
    //   2391: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   2394: goto -249 -> 2145
    //   2397: astore 19
    //   2399: aload_0
    //   2400: astore 7
    //   2402: aload 19
    //   2404: astore_0
    //   2405: aload_1
    //   2406: ifnull +18 -> 2424
    //   2409: aload_1
    //   2410: invokeinterface 217 1 0
    //   2415: ifne +9 -> 2424
    //   2418: aload_1
    //   2419: invokeinterface 218 1 0
    //   2424: aload 18
    //   2426: ifnull +16 -> 2442
    //   2429: aload 18
    //   2431: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   2434: ifeq +8 -> 2442
    //   2437: aload 18
    //   2439: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   2442: aload 7
    //   2444: ifnull +11 -> 2455
    //   2447: aload 7
    //   2449: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   2452: goto +3 -> 2455
    //   2455: ldc_w 447
    //   2458: iconst_0
    //   2459: anewarray 4	java/lang/Object
    //   2462: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   2465: pop
    //   2466: aload_0
    //   2467: athrow
    //   2468: ldc_w 449
    //   2471: iconst_0
    //   2472: anewarray 4	java/lang/Object
    //   2475: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   2478: pop
    //   2479: aconst_null
    //   2480: areturn
    //   2481: aconst_null
    //   2482: astore_0
    //   2483: goto -1237 -> 1246
    //   2486: iload_2
    //   2487: iconst_1
    //   2488: iadd
    //   2489: istore_2
    //   2490: aload_1
    //   2491: astore_0
    //   2492: goto -994 -> 1498
    //   2495: aload_0
    //   2496: astore 18
    //   2498: goto -540 -> 1958
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2501	0	paramContext	Context
    //   0	2501	1	paramArrayOfInt	int[]
    //   0	2501	2	paramInt1	int
    //   0	2501	3	paramInt2	int
    //   0	2501	4	paramLong1	long
    //   0	2501	6	paramInt3	int
    //   0	2501	7	paramString	String
    //   0	2501	8	paramInt4	int
    //   0	2501	9	paramInt5	int
    //   0	2501	10	paramInt6	int
    //   0	2501	11	paramInt7	int
    //   0	2501	12	paramLong2	long
    //   0	2501	14	paramLong3	long
    //   0	2501	16	paramInt8	int
    //   105	56	17	k	int
    //   85	1995	18	localObject1	Object
    //   2084	6	18	localThrowable1	Throwable
    //   2095	155	18	localObject2	Object
    //   2254	8	18	localThrowable2	Throwable
    //   2267	230	18	localObject3	Object
    //   81	2209	19	localObject4	Object
    //   2397	6	19	localObject5	Object
    //   1216	1028	20	localObject6	Object
    //   1128	943	21	localArrayList	ArrayList
    //   1326	568	22	localObject7	Object
    //   1442	374	23	localObject8	Object
    //   1538	218	24	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   1503	1510	2073	finally
    //   1515	1524	2073	finally
    //   1529	1540	2073	finally
    //   1545	1553	2073	finally
    //   1558	1569	2073	finally
    //   1589	1600	2073	finally
    //   1605	1612	2073	finally
    //   1617	1630	2073	finally
    //   1635	1643	2073	finally
    //   1648	1654	2073	finally
    //   1659	1675	2073	finally
    //   1680	1686	2073	finally
    //   1696	1706	2073	finally
    //   1711	1721	2073	finally
    //   1726	1738	2073	finally
    //   1743	1750	2073	finally
    //   1755	1768	2073	finally
    //   1773	1779	2073	finally
    //   1789	1797	2073	finally
    //   1802	1810	2073	finally
    //   1815	1821	2073	finally
    //   1826	1843	2073	finally
    //   1503	1510	2084	java/lang/Throwable
    //   1515	1524	2084	java/lang/Throwable
    //   1529	1540	2084	java/lang/Throwable
    //   1545	1553	2084	java/lang/Throwable
    //   1558	1569	2084	java/lang/Throwable
    //   1589	1600	2084	java/lang/Throwable
    //   1605	1612	2084	java/lang/Throwable
    //   1617	1630	2084	java/lang/Throwable
    //   1635	1643	2084	java/lang/Throwable
    //   1648	1654	2084	java/lang/Throwable
    //   1659	1675	2084	java/lang/Throwable
    //   1680	1686	2084	java/lang/Throwable
    //   1696	1706	2084	java/lang/Throwable
    //   1711	1721	2084	java/lang/Throwable
    //   1726	1738	2084	java/lang/Throwable
    //   1743	1750	2084	java/lang/Throwable
    //   1755	1768	2084	java/lang/Throwable
    //   1773	1779	2084	java/lang/Throwable
    //   1789	1797	2084	java/lang/Throwable
    //   1802	1810	2084	java/lang/Throwable
    //   1815	1821	2084	java/lang/Throwable
    //   1826	1843	2084	java/lang/Throwable
    //   1285	1296	2246	finally
    //   1302	1313	2246	finally
    //   1319	1328	2246	finally
    //   1334	1344	2246	finally
    //   1350	1378	2246	finally
    //   1387	1394	2246	finally
    //   1400	1409	2246	finally
    //   1420	1426	2246	finally
    //   1432	1444	2246	finally
    //   1450	1459	2246	finally
    //   1465	1478	2246	finally
    //   1484	1493	2246	finally
    //   1849	1856	2246	finally
    //   1875	1885	2246	finally
    //   1891	1901	2246	finally
    //   1907	1919	2246	finally
    //   1925	1932	2246	finally
    //   1938	1951	2246	finally
    //   1964	1976	2246	finally
    //   1982	1995	2246	finally
    //   2001	2014	2246	finally
    //   2180	2187	2246	finally
    //   1285	1296	2254	java/lang/Throwable
    //   1302	1313	2254	java/lang/Throwable
    //   1319	1328	2254	java/lang/Throwable
    //   1334	1344	2254	java/lang/Throwable
    //   1350	1378	2254	java/lang/Throwable
    //   1387	1394	2254	java/lang/Throwable
    //   1400	1409	2254	java/lang/Throwable
    //   1420	1426	2254	java/lang/Throwable
    //   1432	1444	2254	java/lang/Throwable
    //   1450	1459	2254	java/lang/Throwable
    //   1465	1478	2254	java/lang/Throwable
    //   1484	1493	2254	java/lang/Throwable
    //   1849	1856	2254	java/lang/Throwable
    //   1875	1885	2254	java/lang/Throwable
    //   1891	1901	2254	java/lang/Throwable
    //   1907	1919	2254	java/lang/Throwable
    //   1925	1932	2254	java/lang/Throwable
    //   1938	1951	2254	java/lang/Throwable
    //   1964	1976	2254	java/lang/Throwable
    //   1982	1995	2254	java/lang/Throwable
    //   2001	2014	2254	java/lang/Throwable
    //   2180	2187	2254	java/lang/Throwable
    //   1156	1190	2272	finally
    //   1190	1218	2272	finally
    //   1223	1243	2272	finally
    //   1246	1279	2272	finally
    //   2158	2174	2272	finally
    //   1156	1190	2282	java/lang/Throwable
    //   1190	1218	2282	java/lang/Throwable
    //   1223	1243	2282	java/lang/Throwable
    //   1246	1279	2282	java/lang/Throwable
    //   2158	2174	2282	java/lang/Throwable
    //   1140	1147	2296	finally
    //   1140	1147	2305	java/lang/Throwable
    //   1130	1140	2315	finally
    //   1130	1140	2327	java/lang/Throwable
    //   2336	2349	2397	finally
  }
  
  protected static List<l> a(Cursor paramCursor)
  {
    e.b("rqdp{  in AnalyticsDAO.paserCursor() start}", new Object[0]);
    if (paramCursor == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int k = paramCursor.getColumnIndex("_id");
    int m = paramCursor.getColumnIndex("_prority");
    int n = paramCursor.getColumnIndex("_time");
    int i1 = paramCursor.getColumnIndex("_type");
    int i2 = paramCursor.getColumnIndex("_datas");
    int i3 = paramCursor.getColumnIndex("_length");
    int i4 = paramCursor.getColumnIndex("_key");
    int i5 = paramCursor.getColumnIndex("_count");
    int i6 = paramCursor.getColumnIndex("_upCounts");
    int i7 = paramCursor.getColumnIndex("_state");
    while (paramCursor.moveToNext())
    {
      l locall = new l();
      locall.a = paramCursor.getLong(k);
      locall.e = paramCursor.getBlob(i2);
      locall.c = paramCursor.getInt(m);
      locall.d = paramCursor.getLong(n);
      locall.b = paramCursor.getInt(i1);
      locall.f = paramCursor.getLong(i3);
      locall.g = paramCursor.getString(i4);
      locall.a(paramCursor.getInt(i5));
      locall.b(paramCursor.getInt(i6));
      locall.c(paramCursor.getInt(i7));
      localArrayList.add(locall);
    }
    e.b("rqdp{  in AnalyticsDAO.paserCursor() end}", new Object[0]);
    return localArrayList;
  }
  
  /* Error */
  public static boolean a(Context paramContext, List<l> paramList)
  {
    // Byte code:
    //   0: ldc_w 473
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: ifnull +370 -> 382
    //   15: aload_1
    //   16: ifnonnull +6 -> 22
    //   19: goto +363 -> 382
    //   22: aload_1
    //   23: invokeinterface 360 1 0
    //   28: ifgt +16 -> 44
    //   31: ldc_w 475
    //   34: iconst_0
    //   35: anewarray 4	java/lang/Object
    //   38: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   41: pop
    //   42: iconst_1
    //   43: ireturn
    //   44: aconst_null
    //   45: astore 9
    //   47: aconst_null
    //   48: astore 5
    //   50: aconst_null
    //   51: astore 8
    //   53: aconst_null
    //   54: astore 6
    //   56: new 68	com/tencent/feedback/proguard/n
    //   59: dup
    //   60: aload_0
    //   61: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   64: astore 7
    //   66: aload 9
    //   68: astore_0
    //   69: aload 7
    //   71: astore 5
    //   73: aload 8
    //   75: astore 6
    //   77: aload 7
    //   79: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   82: astore 8
    //   84: iconst_0
    //   85: istore_2
    //   86: aload 8
    //   88: astore_0
    //   89: aload 7
    //   91: astore 5
    //   93: aload 8
    //   95: astore 6
    //   97: iload_2
    //   98: aload_1
    //   99: invokeinterface 360 1 0
    //   104: if_icmpge +141 -> 245
    //   107: aload 8
    //   109: astore_0
    //   110: aload 7
    //   112: astore 5
    //   114: aload 8
    //   116: astore 6
    //   118: aload_1
    //   119: iload_2
    //   120: invokeinterface 479 2 0
    //   125: checkcast 2	com/tencent/feedback/proguard/l
    //   128: astore 9
    //   130: aload 8
    //   132: astore_0
    //   133: aload 7
    //   135: astore 5
    //   137: aload 8
    //   139: astore 6
    //   141: aload 8
    //   143: ldc 176
    //   145: ldc_w 262
    //   148: aload 9
    //   150: invokestatic 481	com/tencent/feedback/proguard/l:a	(Lcom/tencent/feedback/proguard/l;)Landroid/content/ContentValues;
    //   153: invokevirtual 485	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   156: lstore_3
    //   157: lload_3
    //   158: lconst_0
    //   159: lcmp
    //   160: ifge +61 -> 221
    //   163: aload 8
    //   165: astore_0
    //   166: aload 7
    //   168: astore 5
    //   170: aload 8
    //   172: astore 6
    //   174: ldc_w 487
    //   177: iconst_0
    //   178: anewarray 4	java/lang/Object
    //   181: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   184: pop
    //   185: aload 8
    //   187: ifnull +16 -> 203
    //   190: aload 8
    //   192: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   195: ifeq +8 -> 203
    //   198: aload 8
    //   200: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   203: aload 7
    //   205: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   208: ldc_w 489
    //   211: iconst_0
    //   212: anewarray 4	java/lang/Object
    //   215: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   218: pop
    //   219: iconst_0
    //   220: ireturn
    //   221: aload 8
    //   223: astore_0
    //   224: aload 7
    //   226: astore 5
    //   228: aload 8
    //   230: astore 6
    //   232: aload 9
    //   234: lload_3
    //   235: putfield 26	com/tencent/feedback/proguard/l:a	J
    //   238: iload_2
    //   239: iconst_1
    //   240: iadd
    //   241: istore_2
    //   242: goto -156 -> 86
    //   245: aload 8
    //   247: ifnull +16 -> 263
    //   250: aload 8
    //   252: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   255: ifeq +8 -> 263
    //   258: aload 8
    //   260: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   263: aload 7
    //   265: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   268: ldc_w 489
    //   271: iconst_0
    //   272: anewarray 4	java/lang/Object
    //   275: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   278: pop
    //   279: iconst_1
    //   280: ireturn
    //   281: astore_1
    //   282: aconst_null
    //   283: astore 6
    //   285: aload 5
    //   287: astore_0
    //   288: aload 6
    //   290: astore 5
    //   292: goto +52 -> 344
    //   295: aconst_null
    //   296: astore_1
    //   297: aload 6
    //   299: astore_0
    //   300: aload_1
    //   301: astore 5
    //   303: ldc_w 491
    //   306: iconst_0
    //   307: anewarray 4	java/lang/Object
    //   310: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   313: pop
    //   314: aload 6
    //   316: ifnull +16 -> 332
    //   319: aload 6
    //   321: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   324: ifeq +8 -> 332
    //   327: aload 6
    //   329: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   332: aload_1
    //   333: ifnull -125 -> 208
    //   336: aload_1
    //   337: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   340: goto -132 -> 208
    //   343: astore_1
    //   344: aload_0
    //   345: ifnull +14 -> 359
    //   348: aload_0
    //   349: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   352: ifeq +7 -> 359
    //   355: aload_0
    //   356: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   359: aload 5
    //   361: ifnull +8 -> 369
    //   364: aload 5
    //   366: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   369: ldc_w 489
    //   372: iconst_0
    //   373: anewarray 4	java/lang/Object
    //   376: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   379: pop
    //   380: aload_1
    //   381: athrow
    //   382: ldc_w 493
    //   385: iconst_0
    //   386: anewarray 4	java/lang/Object
    //   389: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   392: pop
    //   393: iconst_0
    //   394: ireturn
    //   395: astore_0
    //   396: goto -101 -> 295
    //   399: astore_0
    //   400: aload 7
    //   402: astore_1
    //   403: goto -106 -> 297
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	paramContext	Context
    //   0	406	1	paramList	List<l>
    //   85	157	2	k	int
    //   156	79	3	l	long
    //   48	317	5	localObject	Object
    //   54	274	6	localSQLiteDatabase1	android.database.sqlite.SQLiteDatabase
    //   64	337	7	localn	n
    //   51	208	8	localSQLiteDatabase2	android.database.sqlite.SQLiteDatabase
    //   45	188	9	locall	l
    // Exception table:
    //   from	to	target	type
    //   56	66	281	finally
    //   77	84	343	finally
    //   97	107	343	finally
    //   118	130	343	finally
    //   141	157	343	finally
    //   174	185	343	finally
    //   232	238	343	finally
    //   303	314	343	finally
    //   56	66	395	java/lang/Throwable
    //   77	84	399	java/lang/Throwable
    //   97	107	399	java/lang/Throwable
    //   118	130	399	java/lang/Throwable
    //   141	157	399	java/lang/Throwable
    //   174	185	399	java/lang/Throwable
    //   232	238	399	java/lang/Throwable
  }
  
  protected static o b(Cursor paramCursor)
  {
    if ((paramCursor != null) && (!paramCursor.isBeforeFirst()))
    {
      if (paramCursor.isAfterLast()) {
        return null;
      }
      o localo = new o();
      try
      {
        localo.a(paramCursor.getString(paramCursor.getColumnIndex("_n")));
        localo.b(paramCursor.getString(paramCursor.getColumnIndex("_sa")));
        localo.a(paramCursor.getInt(paramCursor.getColumnIndex("_id")));
        localo.a(paramCursor.getInt(paramCursor.getColumnIndex("_t")));
        localo.c(paramCursor.getLong(paramCursor.getColumnIndex("_sz")));
        localo.b(paramCursor.getLong(paramCursor.getColumnIndex("_ut")));
        localo.c(paramCursor.getString(paramCursor.getColumnIndex("_ac")));
        return localo;
      }
      catch (Throwable paramCursor)
      {
        if (!e.a(paramCursor)) {
          paramCursor.printStackTrace();
        }
        e.d("rqdp{  Error:getFileBean fail!}", new Object[0]);
        e.d("rqdp{  Error: getFileBean fail!}", new Object[0]);
        return null;
      }
    }
    return null;
  }
  
  /* Error */
  public static boolean b(Context paramContext, List<l> paramList)
  {
    // Byte code:
    //   0: ldc_w 530
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: ifnull +498 -> 510
    //   15: aload_1
    //   16: ifnull +494 -> 510
    //   19: aload_1
    //   20: invokeinterface 360 1 0
    //   25: ifgt +6 -> 31
    //   28: goto +482 -> 510
    //   31: aconst_null
    //   32: astore 5
    //   34: aconst_null
    //   35: astore 7
    //   37: aconst_null
    //   38: astore 4
    //   40: aconst_null
    //   41: astore 8
    //   43: new 68	com/tencent/feedback/proguard/n
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   51: astore 6
    //   53: aload 8
    //   55: astore 5
    //   57: aload 7
    //   59: astore_0
    //   60: aload 6
    //   62: astore 4
    //   64: aload 6
    //   66: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   69: astore 7
    //   71: aload 7
    //   73: astore 5
    //   75: aload 7
    //   77: astore_0
    //   78: aload 6
    //   80: astore 4
    //   82: aload_1
    //   83: invokeinterface 534 1 0
    //   88: astore_1
    //   89: aload 7
    //   91: astore 5
    //   93: aload 7
    //   95: astore_0
    //   96: aload 6
    //   98: astore 4
    //   100: aload_1
    //   101: invokeinterface 539 1 0
    //   106: ifeq +237 -> 343
    //   109: aload 7
    //   111: astore 5
    //   113: aload 7
    //   115: astore_0
    //   116: aload 6
    //   118: astore 4
    //   120: aload_1
    //   121: invokeinterface 543 1 0
    //   126: checkcast 2	com/tencent/feedback/proguard/l
    //   129: astore 8
    //   131: aload 7
    //   133: astore 5
    //   135: aload 7
    //   137: astore_0
    //   138: aload 6
    //   140: astore 4
    //   142: aload 8
    //   144: invokestatic 481	com/tencent/feedback/proguard/l:a	(Lcom/tencent/feedback/proguard/l;)Landroid/content/ContentValues;
    //   147: astore 9
    //   149: aload 9
    //   151: ifnonnull +39 -> 190
    //   154: aload 7
    //   156: ifnull +16 -> 172
    //   159: aload 7
    //   161: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   164: ifeq +8 -> 172
    //   167: aload 7
    //   169: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   172: aload 6
    //   174: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   177: ldc_w 545
    //   180: iconst_0
    //   181: anewarray 4	java/lang/Object
    //   184: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   187: pop
    //   188: iconst_0
    //   189: ireturn
    //   190: aload 7
    //   192: astore 5
    //   194: aload 7
    //   196: astore_0
    //   197: aload 6
    //   199: astore 4
    //   201: aload 7
    //   203: ldc 176
    //   205: ldc_w 262
    //   208: aload 9
    //   210: invokevirtual 548	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   213: lstore_2
    //   214: lload_2
    //   215: lconst_0
    //   216: lcmp
    //   217: ifge +41 -> 258
    //   220: aload 7
    //   222: astore 5
    //   224: aload 7
    //   226: astore_0
    //   227: aload 6
    //   229: astore 4
    //   231: ldc_w 550
    //   234: iconst_0
    //   235: anewarray 4	java/lang/Object
    //   238: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   241: pop
    //   242: aload 7
    //   244: ifnull -72 -> 172
    //   247: aload 7
    //   249: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   252: ifeq -80 -> 172
    //   255: goto -88 -> 167
    //   258: aload 7
    //   260: astore 5
    //   262: aload 7
    //   264: astore_0
    //   265: aload 6
    //   267: astore 4
    //   269: new 95	java/lang/StringBuilder
    //   272: dup
    //   273: ldc_w 552
    //   276: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   279: astore 9
    //   281: aload 7
    //   283: astore 5
    //   285: aload 7
    //   287: astore_0
    //   288: aload 6
    //   290: astore 4
    //   292: aload 9
    //   294: lload_2
    //   295: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 7
    //   301: astore 5
    //   303: aload 7
    //   305: astore_0
    //   306: aload 6
    //   308: astore 4
    //   310: aload 9
    //   312: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: iconst_0
    //   316: anewarray 4	java/lang/Object
    //   319: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   322: pop
    //   323: aload 7
    //   325: astore 5
    //   327: aload 7
    //   329: astore_0
    //   330: aload 6
    //   332: astore 4
    //   334: aload 8
    //   336: lload_2
    //   337: putfield 26	com/tencent/feedback/proguard/l:a	J
    //   340: goto -251 -> 89
    //   343: aload 7
    //   345: ifnull +16 -> 361
    //   348: aload 7
    //   350: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   353: ifeq +8 -> 361
    //   356: aload 7
    //   358: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   361: aload 6
    //   363: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   366: ldc_w 545
    //   369: iconst_0
    //   370: anewarray 4	java/lang/Object
    //   373: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   376: pop
    //   377: iconst_1
    //   378: ireturn
    //   379: astore_0
    //   380: aload 6
    //   382: astore_1
    //   383: aload_0
    //   384: astore 6
    //   386: goto +21 -> 407
    //   389: astore_1
    //   390: aconst_null
    //   391: astore 5
    //   393: aload 4
    //   395: astore_0
    //   396: aload 5
    //   398: astore 4
    //   400: goto +72 -> 472
    //   403: astore 6
    //   405: aconst_null
    //   406: astore_1
    //   407: aload 5
    //   409: astore_0
    //   410: aload_1
    //   411: astore 4
    //   413: aload 6
    //   415: invokestatic 128	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   418: ifne +14 -> 432
    //   421: aload 5
    //   423: astore_0
    //   424: aload_1
    //   425: astore 4
    //   427: aload 6
    //   429: invokevirtual 131	java/lang/Throwable:printStackTrace	()V
    //   432: aload 5
    //   434: ifnull +16 -> 450
    //   437: aload 5
    //   439: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   442: ifeq +8 -> 450
    //   445: aload 5
    //   447: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   450: aload_1
    //   451: ifnull +7 -> 458
    //   454: aload_1
    //   455: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   458: ldc_w 545
    //   461: iconst_0
    //   462: anewarray 4	java/lang/Object
    //   465: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   468: pop
    //   469: iconst_0
    //   470: ireturn
    //   471: astore_1
    //   472: aload_0
    //   473: ifnull +14 -> 487
    //   476: aload_0
    //   477: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   480: ifeq +7 -> 487
    //   483: aload_0
    //   484: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   487: aload 4
    //   489: ifnull +8 -> 497
    //   492: aload 4
    //   494: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   497: ldc_w 545
    //   500: iconst_0
    //   501: anewarray 4	java/lang/Object
    //   504: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   507: pop
    //   508: aload_1
    //   509: athrow
    //   510: ldc_w 554
    //   513: iconst_0
    //   514: anewarray 4	java/lang/Object
    //   517: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   520: pop
    //   521: iconst_0
    //   522: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	523	0	paramContext	Context
    //   0	523	1	paramList	List<l>
    //   213	124	2	l	long
    //   38	455	4	localObject1	Object
    //   32	414	5	localObject2	Object
    //   51	334	6	localObject3	Object
    //   403	25	6	localThrowable	Throwable
    //   35	322	7	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   41	294	8	locall	l
    //   147	164	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   64	71	379	java/lang/Throwable
    //   82	89	379	java/lang/Throwable
    //   100	109	379	java/lang/Throwable
    //   120	131	379	java/lang/Throwable
    //   142	149	379	java/lang/Throwable
    //   201	214	379	java/lang/Throwable
    //   231	242	379	java/lang/Throwable
    //   269	281	379	java/lang/Throwable
    //   292	299	379	java/lang/Throwable
    //   310	323	379	java/lang/Throwable
    //   334	340	379	java/lang/Throwable
    //   43	53	389	finally
    //   43	53	403	java/lang/Throwable
    //   64	71	471	finally
    //   82	89	471	finally
    //   100	109	471	finally
    //   120	131	471	finally
    //   142	149	471	finally
    //   201	214	471	finally
    //   231	242	471	finally
    //   269	281	471	finally
    //   292	299	471	finally
    //   310	323	471	finally
    //   334	340	471	finally
    //   413	421	471	finally
    //   427	432	471	finally
  }
  
  /* Error */
  public static int c(Context paramContext, List<o> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +658 -> 659
    //   4: aload_1
    //   5: ifnull +654 -> 659
    //   8: aload_1
    //   9: invokeinterface 360 1 0
    //   14: ifne +6 -> 20
    //   17: goto +642 -> 659
    //   20: ldc_w 557
    //   23: iconst_1
    //   24: anewarray 4	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: aload_1
    //   30: invokeinterface 360 1 0
    //   35: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   38: aastore
    //   39: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   42: pop
    //   43: aconst_null
    //   44: astore 9
    //   46: new 68	com/tencent/feedback/proguard/n
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   54: astore_0
    //   55: aload_0
    //   56: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   59: astore 8
    //   61: aload 8
    //   63: ifnonnull +67 -> 130
    //   66: ldc_w 309
    //   69: iconst_0
    //   70: anewarray 4	java/lang/Object
    //   73: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   76: pop
    //   77: ldc_w 559
    //   80: iconst_0
    //   81: anewarray 4	java/lang/Object
    //   84: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   87: pop
    //   88: aload 8
    //   90: ifnull +16 -> 106
    //   93: aload 8
    //   95: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   98: ifeq +8 -> 106
    //   101: aload 8
    //   103: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   106: aload_0
    //   107: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   110: ldc_w 561
    //   113: iconst_1
    //   114: anewarray 4	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: iconst_0
    //   120: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   123: aastore
    //   124: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   127: pop
    //   128: iconst_m1
    //   129: ireturn
    //   130: aload_1
    //   131: invokeinterface 534 1 0
    //   136: astore 9
    //   138: iconst_0
    //   139: istore_2
    //   140: iload_2
    //   141: istore_3
    //   142: iload_2
    //   143: istore 4
    //   145: aload 9
    //   147: invokeinterface 539 1 0
    //   152: ifeq +259 -> 411
    //   155: iload_2
    //   156: istore_3
    //   157: iload_2
    //   158: istore 4
    //   160: aload 9
    //   162: invokeinterface 543 1 0
    //   167: checkcast 344	com/tencent/feedback/proguard/o
    //   170: astore 10
    //   172: aload 10
    //   174: ifnonnull +8 -> 182
    //   177: aconst_null
    //   178: astore_1
    //   179: goto +127 -> 306
    //   182: iload_2
    //   183: istore_3
    //   184: iload_2
    //   185: istore 4
    //   187: new 259	android/content/ContentValues
    //   190: dup
    //   191: invokespecial 260	android/content/ContentValues:<init>	()V
    //   194: astore_1
    //   195: iload_2
    //   196: istore_3
    //   197: iload_2
    //   198: istore 4
    //   200: aload_1
    //   201: ldc_w 319
    //   204: aload 10
    //   206: invokevirtual 346	com/tencent/feedback/proguard/o:a	()Ljava/lang/String;
    //   209: invokevirtual 290	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: iload_2
    //   213: istore_3
    //   214: iload_2
    //   215: istore 4
    //   217: aload_1
    //   218: ldc_w 505
    //   221: aload 10
    //   223: invokevirtual 348	com/tencent/feedback/proguard/o:d	()Ljava/lang/String;
    //   226: invokevirtual 290	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: iload_2
    //   230: istore_3
    //   231: iload_2
    //   232: istore 4
    //   234: aload_1
    //   235: ldc_w 514
    //   238: aload 10
    //   240: invokevirtual 563	com/tencent/feedback/proguard/o:c	()J
    //   243: invokestatic 265	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   246: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   249: iload_2
    //   250: istore_3
    //   251: iload_2
    //   252: istore 4
    //   254: aload_1
    //   255: ldc_w 518
    //   258: aload 10
    //   260: invokevirtual 565	com/tencent/feedback/proguard/o:b	()J
    //   263: invokestatic 265	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   266: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   269: iload_2
    //   270: istore_3
    //   271: iload_2
    //   272: istore 4
    //   274: aload_1
    //   275: ldc_w 325
    //   278: aload 10
    //   280: invokevirtual 349	com/tencent/feedback/proguard/o:e	()I
    //   283: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   286: invokevirtual 274	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   289: iload_2
    //   290: istore_3
    //   291: iload_2
    //   292: istore 4
    //   294: aload_1
    //   295: ldc_w 522
    //   298: aload 10
    //   300: invokevirtual 351	com/tencent/feedback/proguard/o:f	()Ljava/lang/String;
    //   303: invokevirtual 290	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: aload_1
    //   307: ifnull -167 -> 140
    //   310: iload_2
    //   311: istore_3
    //   312: iload_2
    //   313: istore 4
    //   315: aload 8
    //   317: ldc 110
    //   319: ldc_w 262
    //   322: aload_1
    //   323: invokevirtual 485	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   326: lstore 5
    //   328: iload_2
    //   329: istore_3
    //   330: iload_2
    //   331: istore 4
    //   333: aload 10
    //   335: lload 5
    //   337: invokevirtual 510	com/tencent/feedback/proguard/o:a	(J)V
    //   340: lload 5
    //   342: lconst_0
    //   343: lcmp
    //   344: iflt +367 -> 711
    //   347: iconst_1
    //   348: istore_3
    //   349: goto +3 -> 352
    //   352: iload_2
    //   353: iload_3
    //   354: iadd
    //   355: istore_2
    //   356: iload_2
    //   357: istore_3
    //   358: iload_2
    //   359: istore 4
    //   361: aload 10
    //   363: invokevirtual 346	com/tencent/feedback/proguard/o:a	()Ljava/lang/String;
    //   366: astore_1
    //   367: lload 5
    //   369: lconst_0
    //   370: lcmp
    //   371: iflt +345 -> 716
    //   374: iconst_1
    //   375: istore 7
    //   377: goto +3 -> 380
    //   380: iload_2
    //   381: istore_3
    //   382: iload_2
    //   383: istore 4
    //   385: ldc_w 567
    //   388: iconst_2
    //   389: anewarray 4	java/lang/Object
    //   392: dup
    //   393: iconst_0
    //   394: aload_1
    //   395: aastore
    //   396: dup
    //   397: iconst_1
    //   398: iload 7
    //   400: invokestatic 572	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   403: aastore
    //   404: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   407: pop
    //   408: goto -268 -> 140
    //   411: aload 8
    //   413: ifnull +16 -> 429
    //   416: aload 8
    //   418: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   421: ifeq +8 -> 429
    //   424: aload 8
    //   426: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   429: aload_0
    //   430: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   433: iconst_1
    //   434: anewarray 4	java/lang/Object
    //   437: astore_0
    //   438: aload_0
    //   439: iconst_0
    //   440: iload_2
    //   441: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   444: aastore
    //   445: ldc_w 561
    //   448: aload_0
    //   449: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   452: pop
    //   453: iload_2
    //   454: ireturn
    //   455: astore_1
    //   456: iload_3
    //   457: istore_2
    //   458: aload_0
    //   459: astore 9
    //   461: goto +150 -> 611
    //   464: astore_1
    //   465: iload 4
    //   467: istore_2
    //   468: goto +16 -> 484
    //   471: astore_1
    //   472: aload_0
    //   473: astore 9
    //   475: aload 8
    //   477: astore_0
    //   478: goto +32 -> 510
    //   481: astore_1
    //   482: iconst_0
    //   483: istore_2
    //   484: goto +43 -> 527
    //   487: astore_1
    //   488: aconst_null
    //   489: astore 8
    //   491: aload_0
    //   492: astore 9
    //   494: aload 8
    //   496: astore_0
    //   497: goto +13 -> 510
    //   500: astore_1
    //   501: goto +20 -> 521
    //   504: astore_1
    //   505: aconst_null
    //   506: astore_0
    //   507: aload_0
    //   508: astore 9
    //   510: iconst_0
    //   511: istore_2
    //   512: aload_0
    //   513: astore 8
    //   515: goto +96 -> 611
    //   518: astore_1
    //   519: aconst_null
    //   520: astore_0
    //   521: iconst_0
    //   522: istore_2
    //   523: aload 9
    //   525: astore 8
    //   527: ldc 120
    //   529: iconst_0
    //   530: anewarray 4	java/lang/Object
    //   533: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   536: pop
    //   537: ldc_w 574
    //   540: iconst_1
    //   541: anewarray 4	java/lang/Object
    //   544: dup
    //   545: iconst_0
    //   546: aload_1
    //   547: invokevirtual 125	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   550: aastore
    //   551: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   554: pop
    //   555: aload_1
    //   556: invokestatic 128	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   559: ifne +7 -> 566
    //   562: aload_1
    //   563: invokevirtual 131	java/lang/Throwable:printStackTrace	()V
    //   566: aload 8
    //   568: ifnull +16 -> 584
    //   571: aload 8
    //   573: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   576: ifeq +8 -> 584
    //   579: aload 8
    //   581: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   584: aload_0
    //   585: ifnull +7 -> 592
    //   588: aload_0
    //   589: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   592: iconst_1
    //   593: anewarray 4	java/lang/Object
    //   596: astore_0
    //   597: aload_0
    //   598: iconst_0
    //   599: iload_2
    //   600: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   603: aastore
    //   604: goto -159 -> 445
    //   607: astore_1
    //   608: aload_0
    //   609: astore 9
    //   611: aload 8
    //   613: ifnull +16 -> 629
    //   616: aload 8
    //   618: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   621: ifeq +8 -> 629
    //   624: aload 8
    //   626: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   629: aload 9
    //   631: ifnull +8 -> 639
    //   634: aload 9
    //   636: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   639: ldc_w 561
    //   642: iconst_1
    //   643: anewarray 4	java/lang/Object
    //   646: dup
    //   647: iconst_0
    //   648: iload_2
    //   649: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   652: aastore
    //   653: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   656: pop
    //   657: aload_1
    //   658: athrow
    //   659: aload_1
    //   660: ifnonnull +10 -> 670
    //   663: ldc_w 576
    //   666: astore_0
    //   667: goto +27 -> 694
    //   670: new 95	java/lang/StringBuilder
    //   673: dup
    //   674: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   677: astore_0
    //   678: aload_0
    //   679: aload_1
    //   680: invokeinterface 360 1 0
    //   685: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   688: pop
    //   689: aload_0
    //   690: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   693: astore_0
    //   694: ldc_w 578
    //   697: iconst_1
    //   698: anewarray 4	java/lang/Object
    //   701: dup
    //   702: iconst_0
    //   703: aload_0
    //   704: aastore
    //   705: invokestatic 56	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   708: pop
    //   709: iconst_m1
    //   710: ireturn
    //   711: iconst_0
    //   712: istore_3
    //   713: goto -361 -> 352
    //   716: iconst_0
    //   717: istore 7
    //   719: goto -339 -> 380
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	722	0	paramContext	Context
    //   0	722	1	paramList	List<o>
    //   139	510	2	k	int
    //   141	572	3	m	int
    //   143	323	4	n	int
    //   326	42	5	l	long
    //   375	343	7	bool	boolean
    //   59	566	8	localObject1	Object
    //   44	591	9	localObject2	Object
    //   170	192	10	localo	o
    // Exception table:
    //   from	to	target	type
    //   145	155	455	finally
    //   160	172	455	finally
    //   187	195	455	finally
    //   200	212	455	finally
    //   217	229	455	finally
    //   234	249	455	finally
    //   254	269	455	finally
    //   274	289	455	finally
    //   294	306	455	finally
    //   315	328	455	finally
    //   333	340	455	finally
    //   361	367	455	finally
    //   385	408	455	finally
    //   145	155	464	java/lang/Throwable
    //   160	172	464	java/lang/Throwable
    //   187	195	464	java/lang/Throwable
    //   200	212	464	java/lang/Throwable
    //   217	229	464	java/lang/Throwable
    //   234	249	464	java/lang/Throwable
    //   254	269	464	java/lang/Throwable
    //   274	289	464	java/lang/Throwable
    //   294	306	464	java/lang/Throwable
    //   315	328	464	java/lang/Throwable
    //   333	340	464	java/lang/Throwable
    //   361	367	464	java/lang/Throwable
    //   385	408	464	java/lang/Throwable
    //   66	88	471	finally
    //   130	138	471	finally
    //   66	88	481	java/lang/Throwable
    //   130	138	481	java/lang/Throwable
    //   55	61	487	finally
    //   55	61	500	java/lang/Throwable
    //   46	55	504	finally
    //   46	55	518	java/lang/Throwable
    //   527	566	607	finally
  }
  
  /* Error */
  public static int d(Context paramContext, List<o> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +547 -> 548
    //   4: aload_1
    //   5: ifnull +543 -> 548
    //   8: aload_1
    //   9: invokeinterface 360 1 0
    //   14: ifne +6 -> 20
    //   17: goto +531 -> 548
    //   20: ldc_w 581
    //   23: iconst_1
    //   24: anewarray 4	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: aload_1
    //   30: invokeinterface 360 1 0
    //   35: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   38: aastore
    //   39: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   42: pop
    //   43: aconst_null
    //   44: astore 4
    //   46: new 68	com/tencent/feedback/proguard/n
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   54: astore_0
    //   55: aload_0
    //   56: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   59: astore_3
    //   60: aload_3
    //   61: ifnonnull +63 -> 124
    //   64: ldc 77
    //   66: iconst_0
    //   67: anewarray 4	java/lang/Object
    //   70: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   73: pop
    //   74: ldc_w 583
    //   77: iconst_0
    //   78: anewarray 4	java/lang/Object
    //   81: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   84: pop
    //   85: aload_3
    //   86: ifnull +14 -> 100
    //   89: aload_3
    //   90: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   93: ifeq +7 -> 100
    //   96: aload_3
    //   97: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   100: aload_0
    //   101: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   104: ldc_w 585
    //   107: iconst_1
    //   108: anewarray 4	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: iconst_0
    //   114: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   117: aastore
    //   118: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   121: pop
    //   122: iconst_m1
    //   123: ireturn
    //   124: new 227	java/lang/StringBuffer
    //   127: dup
    //   128: invokespecial 228	java/lang/StringBuffer:<init>	()V
    //   131: astore 4
    //   133: aload_1
    //   134: invokeinterface 534 1 0
    //   139: astore_1
    //   140: aload_1
    //   141: invokeinterface 539 1 0
    //   146: ifeq +102 -> 248
    //   149: aload_1
    //   150: invokeinterface 543 1 0
    //   155: checkcast 344	com/tencent/feedback/proguard/o
    //   158: astore 5
    //   160: aload 4
    //   162: ldc_w 587
    //   165: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   168: pop
    //   169: aload 4
    //   171: ldc_w 319
    //   174: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   177: pop
    //   178: aload 4
    //   180: ldc_w 321
    //   183: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   186: pop
    //   187: aload 4
    //   189: aload 5
    //   191: invokevirtual 346	com/tencent/feedback/proguard/o:a	()Ljava/lang/String;
    //   194: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   197: pop
    //   198: aload 4
    //   200: ldc_w 589
    //   203: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   206: pop
    //   207: aload 4
    //   209: ldc_w 325
    //   212: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   215: pop
    //   216: aload 4
    //   218: ldc_w 327
    //   221: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   224: pop
    //   225: aload 4
    //   227: aload 5
    //   229: invokevirtual 349	com/tencent/feedback/proguard/o:e	()I
    //   232: invokevirtual 330	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   235: pop
    //   236: aload 4
    //   238: ldc_w 380
    //   241: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   244: pop
    //   245: goto -105 -> 140
    //   248: aload 4
    //   250: iconst_2
    //   251: invokevirtual 242	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   254: astore_1
    //   255: aload_3
    //   256: ldc 110
    //   258: aload_1
    //   259: aconst_null
    //   260: invokevirtual 114	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   263: istore_2
    //   264: ldc_w 591
    //   267: iconst_2
    //   268: anewarray 4	java/lang/Object
    //   271: dup
    //   272: iconst_0
    //   273: iload_2
    //   274: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   277: aastore
    //   278: dup
    //   279: iconst_1
    //   280: aload_1
    //   281: aastore
    //   282: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   285: pop
    //   286: aload_3
    //   287: ifnull +14 -> 301
    //   290: aload_3
    //   291: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   294: ifeq +7 -> 301
    //   297: aload_3
    //   298: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   301: aload_0
    //   302: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   305: ldc_w 585
    //   308: iconst_1
    //   309: anewarray 4	java/lang/Object
    //   312: dup
    //   313: iconst_0
    //   314: iload_2
    //   315: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   318: aastore
    //   319: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   322: pop
    //   323: iload_2
    //   324: ireturn
    //   325: astore 4
    //   327: aload_0
    //   328: astore_1
    //   329: goto +175 -> 504
    //   332: astore 4
    //   334: aload_3
    //   335: astore_1
    //   336: goto +76 -> 412
    //   339: astore 4
    //   341: aload_0
    //   342: astore_1
    //   343: aload 4
    //   345: astore_0
    //   346: goto +45 -> 391
    //   349: astore 4
    //   351: aload_3
    //   352: astore_1
    //   353: aload_0
    //   354: astore_3
    //   355: aload 4
    //   357: astore_0
    //   358: goto +47 -> 405
    //   361: astore 4
    //   363: aconst_null
    //   364: astore_3
    //   365: aload_0
    //   366: astore_1
    //   367: aload 4
    //   369: astore_0
    //   370: goto +21 -> 391
    //   373: astore 5
    //   375: aload 4
    //   377: astore_1
    //   378: aload_0
    //   379: astore_3
    //   380: aload 5
    //   382: astore_0
    //   383: goto +22 -> 405
    //   386: astore_0
    //   387: aconst_null
    //   388: astore_3
    //   389: aload_3
    //   390: astore_1
    //   391: iconst_0
    //   392: istore_2
    //   393: aload_0
    //   394: astore 4
    //   396: goto +108 -> 504
    //   399: astore_0
    //   400: aconst_null
    //   401: astore_3
    //   402: aload 4
    //   404: astore_1
    //   405: iconst_0
    //   406: istore_2
    //   407: aload_0
    //   408: astore 4
    //   410: aload_3
    //   411: astore_0
    //   412: aload 4
    //   414: invokestatic 128	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   417: ifne +8 -> 425
    //   420: aload 4
    //   422: invokevirtual 131	java/lang/Throwable:printStackTrace	()V
    //   425: ldc_w 593
    //   428: iconst_0
    //   429: anewarray 4	java/lang/Object
    //   432: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   435: pop
    //   436: ldc_w 595
    //   439: iconst_1
    //   440: anewarray 4	java/lang/Object
    //   443: dup
    //   444: iconst_0
    //   445: aload 4
    //   447: invokevirtual 125	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   450: aastore
    //   451: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   454: pop
    //   455: aload_1
    //   456: ifnull +14 -> 470
    //   459: aload_1
    //   460: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   463: ifeq +7 -> 470
    //   466: aload_1
    //   467: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   470: aload_0
    //   471: ifnull +7 -> 478
    //   474: aload_0
    //   475: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   478: ldc_w 585
    //   481: iconst_1
    //   482: anewarray 4	java/lang/Object
    //   485: dup
    //   486: iconst_0
    //   487: iload_2
    //   488: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   491: aastore
    //   492: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   495: pop
    //   496: iload_2
    //   497: ireturn
    //   498: astore 4
    //   500: aload_1
    //   501: astore_3
    //   502: aload_0
    //   503: astore_1
    //   504: aload_3
    //   505: ifnull +14 -> 519
    //   508: aload_3
    //   509: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   512: ifeq +7 -> 519
    //   515: aload_3
    //   516: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   519: aload_1
    //   520: ifnull +7 -> 527
    //   523: aload_1
    //   524: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   527: ldc_w 585
    //   530: iconst_1
    //   531: anewarray 4	java/lang/Object
    //   534: dup
    //   535: iconst_0
    //   536: iload_2
    //   537: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   540: aastore
    //   541: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   544: pop
    //   545: aload 4
    //   547: athrow
    //   548: aload_1
    //   549: ifnonnull +10 -> 559
    //   552: ldc_w 576
    //   555: astore_0
    //   556: goto +27 -> 583
    //   559: new 95	java/lang/StringBuilder
    //   562: dup
    //   563: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   566: astore_0
    //   567: aload_0
    //   568: aload_1
    //   569: invokeinterface 360 1 0
    //   574: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   577: pop
    //   578: aload_0
    //   579: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   582: astore_0
    //   583: ldc_w 597
    //   586: iconst_1
    //   587: anewarray 4	java/lang/Object
    //   590: dup
    //   591: iconst_0
    //   592: aload_0
    //   593: aastore
    //   594: invokestatic 56	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   597: pop
    //   598: iconst_m1
    //   599: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	600	0	paramContext	Context
    //   0	600	1	paramList	List<o>
    //   263	274	2	k	int
    //   59	457	3	localObject1	Object
    //   44	205	4	localStringBuffer	java.lang.StringBuffer
    //   325	1	4	localObject2	Object
    //   332	1	4	localThrowable1	Throwable
    //   339	5	4	localObject3	Object
    //   349	7	4	localThrowable2	Throwable
    //   361	15	4	localObject4	Object
    //   394	52	4	localContext	Context
    //   498	48	4	localObject5	Object
    //   158	70	5	localo	o
    //   373	8	5	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   264	286	325	finally
    //   264	286	332	java/lang/Throwable
    //   64	85	339	finally
    //   124	140	339	finally
    //   140	245	339	finally
    //   248	264	339	finally
    //   64	85	349	java/lang/Throwable
    //   124	140	349	java/lang/Throwable
    //   140	245	349	java/lang/Throwable
    //   248	264	349	java/lang/Throwable
    //   55	60	361	finally
    //   55	60	373	java/lang/Throwable
    //   46	55	386	finally
    //   46	55	399	java/lang/Throwable
    //   412	425	498	finally
    //   425	455	498	finally
  }
  
  public final long a()
  {
    return this.a;
  }
  
  public final l a(int paramInt)
  {
    try
    {
      this.h = paramInt;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final l a(long paramLong)
  {
    this.a = paramLong;
    return this;
  }
  
  public final l a(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public final l b(int paramInt)
  {
    try
    {
      this.i = paramInt;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final byte[] b()
  {
    return this.e;
  }
  
  public final int c()
  {
    try
    {
      int k = this.h;
      return k;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final l c(int paramInt)
  {
    try
    {
      this.j = paramInt;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int d()
  {
    try
    {
      int k = this.i;
      return k;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int e()
  {
    try
    {
      int k = this.j;
      return k;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.l
 * JD-Core Version:    0.7.0.1
 */