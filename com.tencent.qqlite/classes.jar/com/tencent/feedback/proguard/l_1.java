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
    //   1: ifnonnull +14 -> 15
    //   4: ldc 51
    //   6: iconst_0
    //   7: anewarray 4	java/lang/Object
    //   10: invokestatic 56	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   13: iconst_m1
    //   14: ireturn
    //   15: ldc 58
    //   17: iconst_1
    //   18: anewarray 4	java/lang/Object
    //   21: dup
    //   22: iconst_0
    //   23: iconst_1
    //   24: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: aastore
    //   28: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: new 68	com/tencent/feedback/proguard/n
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   39: astore 4
    //   41: aload 4
    //   43: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   46: astore_0
    //   47: aload_0
    //   48: ifnonnull +59 -> 107
    //   51: ldc 77
    //   53: iconst_0
    //   54: anewarray 4	java/lang/Object
    //   57: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: ldc 81
    //   62: iconst_0
    //   63: anewarray 4	java/lang/Object
    //   66: invokestatic 83	com/tencent/feedback/common/e:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: aload_0
    //   70: ifnull +14 -> 84
    //   73: aload_0
    //   74: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   77: ifeq +7 -> 84
    //   80: aload_0
    //   81: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   84: aload 4
    //   86: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   89: ldc 95
    //   91: iconst_1
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: iconst_0
    //   98: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   101: aastore
    //   102: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   105: iconst_m1
    //   106: ireturn
    //   107: new 97	java/lang/StringBuilder
    //   110: dup
    //   111: ldc 99
    //   113: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   116: iconst_1
    //   117: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: astore 5
    //   125: aload_0
    //   126: ldc 112
    //   128: aload 5
    //   130: aconst_null
    //   131: invokevirtual 116	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   134: istore_1
    //   135: aload 5
    //   137: astore_3
    //   138: aload 5
    //   140: ifnonnull +6 -> 146
    //   143: ldc 118
    //   145: astore_3
    //   146: iload_1
    //   147: istore_2
    //   148: aload_0
    //   149: astore 6
    //   151: aload 4
    //   153: astore 5
    //   155: ldc 120
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
    //   172: invokestatic 83	com/tencent/feedback/common/e:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   175: aload_0
    //   176: ifnull +14 -> 190
    //   179: aload_0
    //   180: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   183: ifeq +7 -> 190
    //   186: aload_0
    //   187: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   190: aload 4
    //   192: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   195: ldc 95
    //   197: iconst_1
    //   198: anewarray 4	java/lang/Object
    //   201: dup
    //   202: iconst_0
    //   203: iload_1
    //   204: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   207: aastore
    //   208: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   211: iload_1
    //   212: ireturn
    //   213: astore_3
    //   214: aconst_null
    //   215: astore_0
    //   216: aconst_null
    //   217: astore 4
    //   219: iconst_0
    //   220: istore_1
    //   221: iload_1
    //   222: istore_2
    //   223: aload_0
    //   224: astore 6
    //   226: aload 4
    //   228: astore 5
    //   230: ldc 122
    //   232: iconst_0
    //   233: anewarray 4	java/lang/Object
    //   236: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   239: iload_1
    //   240: istore_2
    //   241: aload_0
    //   242: astore 6
    //   244: aload 4
    //   246: astore 5
    //   248: ldc 124
    //   250: iconst_1
    //   251: anewarray 4	java/lang/Object
    //   254: dup
    //   255: iconst_0
    //   256: aload_3
    //   257: invokevirtual 127	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   260: aastore
    //   261: invokestatic 83	com/tencent/feedback/common/e:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   264: iload_1
    //   265: istore_2
    //   266: aload_0
    //   267: astore 6
    //   269: aload 4
    //   271: astore 5
    //   273: aload_3
    //   274: invokevirtual 130	java/lang/Throwable:printStackTrace	()V
    //   277: aload_0
    //   278: ifnull +14 -> 292
    //   281: aload_0
    //   282: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   285: ifeq +7 -> 292
    //   288: aload_0
    //   289: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   292: aload 4
    //   294: ifnull +8 -> 302
    //   297: aload 4
    //   299: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   302: ldc 95
    //   304: iconst_1
    //   305: anewarray 4	java/lang/Object
    //   308: dup
    //   309: iconst_0
    //   310: iload_1
    //   311: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   314: aastore
    //   315: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   318: iload_1
    //   319: ireturn
    //   320: astore_3
    //   321: aconst_null
    //   322: astore_0
    //   323: aconst_null
    //   324: astore 4
    //   326: iconst_0
    //   327: istore_1
    //   328: aload_0
    //   329: ifnull +14 -> 343
    //   332: aload_0
    //   333: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   336: ifeq +7 -> 343
    //   339: aload_0
    //   340: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   343: aload 4
    //   345: ifnull +8 -> 353
    //   348: aload 4
    //   350: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   353: ldc 95
    //   355: iconst_1
    //   356: anewarray 4	java/lang/Object
    //   359: dup
    //   360: iconst_0
    //   361: iload_1
    //   362: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   365: aastore
    //   366: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   369: aload_3
    //   370: athrow
    //   371: astore_3
    //   372: aconst_null
    //   373: astore_0
    //   374: iconst_0
    //   375: istore_1
    //   376: goto -48 -> 328
    //   379: astore_3
    //   380: iconst_0
    //   381: istore_1
    //   382: goto -54 -> 328
    //   385: astore_3
    //   386: iload_2
    //   387: istore_1
    //   388: aload 6
    //   390: astore_0
    //   391: aload 5
    //   393: astore 4
    //   395: goto -67 -> 328
    //   398: astore_3
    //   399: aconst_null
    //   400: astore_0
    //   401: iconst_0
    //   402: istore_1
    //   403: goto -182 -> 221
    //   406: astore_3
    //   407: iconst_0
    //   408: istore_1
    //   409: goto -188 -> 221
    //   412: astore_3
    //   413: goto -192 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	paramContext	Context
    //   0	416	1	paramInt	int
    //   147	240	2	k	int
    //   137	34	3	localObject1	Object
    //   213	61	3	localThrowable1	Throwable
    //   320	50	3	localObject2	Object
    //   371	1	3	localObject3	Object
    //   379	1	3	localObject4	Object
    //   385	1	3	localObject5	Object
    //   398	1	3	localThrowable2	Throwable
    //   406	1	3	localThrowable3	Throwable
    //   412	1	3	localThrowable4	Throwable
    //   39	355	4	localObject6	Object
    //   123	269	5	localObject7	Object
    //   149	240	6	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   31	41	213	java/lang/Throwable
    //   31	41	320	finally
    //   41	47	371	finally
    //   51	69	379	finally
    //   107	135	379	finally
    //   155	175	385	finally
    //   230	239	385	finally
    //   248	264	385	finally
    //   273	277	385	finally
    //   41	47	398	java/lang/Throwable
    //   51	69	406	java/lang/Throwable
    //   107	135	406	java/lang/Throwable
    //   155	175	412	java/lang/Throwable
  }
  
  public static int a(Context paramContext, int[] paramArrayOfInt, long paramLong1, long paramLong2)
  {
    return a(paramContext, paramArrayOfInt, paramLong1, paramLong2, -1, -1);
  }
  
  /* Error */
  public static int a(Context paramContext, int[] paramArrayOfInt, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: iconst_0
    //   4: istore 8
    //   6: ldc 136
    //   8: iconst_0
    //   9: anewarray 4	java/lang/Object
    //   12: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   15: aload_0
    //   16: ifnonnull +18 -> 34
    //   19: ldc 138
    //   21: iconst_0
    //   22: anewarray 4	java/lang/Object
    //   25: invokestatic 140	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: iconst_m1
    //   29: istore 8
    //   31: iload 8
    //   33: ireturn
    //   34: lload_2
    //   35: lload 4
    //   37: lcmp
    //   38: ifgt -7 -> 31
    //   41: new 97	java/lang/StringBuilder
    //   44: dup
    //   45: ldc 142
    //   47: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: lload_2
    //   51: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   54: ldc 147
    //   56: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 152
    //   61: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: lload 4
    //   66: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   69: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore 9
    //   74: aload 9
    //   76: astore 10
    //   78: iload 6
    //   80: iflt +30 -> 110
    //   83: new 97	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   90: aload 9
    //   92: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc 155
    //   97: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: iload 6
    //   102: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: astore 10
    //   110: aload 10
    //   112: astore 9
    //   114: iload 7
    //   116: iflt +30 -> 146
    //   119: new 97	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   126: aload 10
    //   128: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc 157
    //   133: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: iload 7
    //   138: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   141: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: astore 9
    //   146: aload_1
    //   147: ifnull +344 -> 491
    //   150: aload_1
    //   151: arraylength
    //   152: ifle +339 -> 491
    //   155: ldc 159
    //   157: astore 10
    //   159: iconst_0
    //   160: istore 6
    //   162: iload 6
    //   164: aload_1
    //   165: arraylength
    //   166: if_icmpge +41 -> 207
    //   169: new 97	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   176: aload 10
    //   178: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: ldc 161
    //   183: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_1
    //   187: iload 6
    //   189: iaload
    //   190: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   193: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: astore 10
    //   198: iload 6
    //   200: iconst_1
    //   201: iadd
    //   202: istore 6
    //   204: goto -42 -> 162
    //   207: aload 10
    //   209: iconst_4
    //   210: invokevirtual 167	java/lang/String:substring	(I)Ljava/lang/String;
    //   213: astore_1
    //   214: new 97	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   221: aload 9
    //   223: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: ldc 169
    //   228: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_1
    //   232: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc 171
    //   237: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: astore_1
    //   244: new 97	java/lang/StringBuilder
    //   247: dup
    //   248: ldc 173
    //   250: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   253: aload_1
    //   254: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: iconst_0
    //   261: anewarray 4	java/lang/Object
    //   264: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   267: new 68	com/tencent/feedback/proguard/n
    //   270: dup
    //   271: aload_0
    //   272: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   275: astore 9
    //   277: aload 9
    //   279: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   282: astore_0
    //   283: aload_0
    //   284: ldc 175
    //   286: aload_1
    //   287: aconst_null
    //   288: invokevirtual 116	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   291: istore 6
    //   293: new 97	java/lang/StringBuilder
    //   296: dup
    //   297: ldc 177
    //   299: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   302: iload 6
    //   304: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   307: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: iconst_0
    //   311: anewarray 4	java/lang/Object
    //   314: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   317: aload_0
    //   318: ifnull +14 -> 332
    //   321: aload_0
    //   322: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   325: ifeq +7 -> 332
    //   328: aload_0
    //   329: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   332: aload 9
    //   334: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   337: ldc 179
    //   339: iconst_0
    //   340: anewarray 4	java/lang/Object
    //   343: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   346: iload 6
    //   348: ireturn
    //   349: astore 9
    //   351: aconst_null
    //   352: astore_0
    //   353: aload 11
    //   355: astore_1
    //   356: aload 9
    //   358: invokevirtual 127	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   361: iconst_0
    //   362: anewarray 4	java/lang/Object
    //   365: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   368: aload_0
    //   369: ifnull +14 -> 383
    //   372: aload_0
    //   373: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   376: ifeq +7 -> 383
    //   379: aload_0
    //   380: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   383: aload_1
    //   384: ifnull +7 -> 391
    //   387: aload_1
    //   388: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   391: ldc 179
    //   393: iconst_0
    //   394: anewarray 4	java/lang/Object
    //   397: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   400: iconst_m1
    //   401: ireturn
    //   402: astore_1
    //   403: aconst_null
    //   404: astore_0
    //   405: aconst_null
    //   406: astore 9
    //   408: aload_0
    //   409: ifnull +14 -> 423
    //   412: aload_0
    //   413: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   416: ifeq +7 -> 423
    //   419: aload_0
    //   420: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   423: aload 9
    //   425: ifnull +8 -> 433
    //   428: aload 9
    //   430: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   433: ldc 179
    //   435: iconst_0
    //   436: anewarray 4	java/lang/Object
    //   439: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   442: aload_1
    //   443: athrow
    //   444: astore_1
    //   445: aconst_null
    //   446: astore_0
    //   447: goto -39 -> 408
    //   450: astore_1
    //   451: goto -43 -> 408
    //   454: astore 10
    //   456: aload_1
    //   457: astore 9
    //   459: aload 10
    //   461: astore_1
    //   462: goto -54 -> 408
    //   465: astore 10
    //   467: aconst_null
    //   468: astore_0
    //   469: aload 9
    //   471: astore_1
    //   472: aload 10
    //   474: astore 9
    //   476: goto -120 -> 356
    //   479: astore 10
    //   481: aload 9
    //   483: astore_1
    //   484: aload 10
    //   486: astore 9
    //   488: goto -132 -> 356
    //   491: aload 9
    //   493: astore_1
    //   494: goto -250 -> 244
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	497	0	paramContext	Context
    //   0	497	1	paramArrayOfInt	int[]
    //   0	497	2	paramLong1	long
    //   0	497	4	paramLong2	long
    //   0	497	6	paramInt1	int
    //   0	497	7	paramInt2	int
    //   4	28	8	k	int
    //   72	261	9	localObject1	Object
    //   349	8	9	localThrowable1	Throwable
    //   406	86	9	localObject2	Object
    //   76	132	10	localObject3	Object
    //   454	6	10	localObject4	Object
    //   465	8	10	localThrowable2	Throwable
    //   479	6	10	localThrowable3	Throwable
    //   1	353	11	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   267	277	349	java/lang/Throwable
    //   267	277	402	finally
    //   277	283	444	finally
    //   283	317	450	finally
    //   356	368	454	finally
    //   277	283	465	java/lang/Throwable
    //   283	317	479	java/lang/Throwable
  }
  
  /* Error */
  public static int a(Context paramContext, int[] paramArrayOfInt, long paramLong1, long paramLong2, String paramString)
  {
    // Byte code:
    //   0: ldc 182
    //   2: iconst_0
    //   3: anewarray 4	java/lang/Object
    //   6: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   9: aload_0
    //   10: ifnonnull +14 -> 24
    //   13: ldc 184
    //   15: iconst_0
    //   16: anewarray 4	java/lang/Object
    //   19: invokestatic 140	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: iconst_m1
    //   23: ireturn
    //   24: lload_2
    //   25: lload 4
    //   27: lcmp
    //   28: ifle +5 -> 33
    //   31: iconst_0
    //   32: ireturn
    //   33: new 97	java/lang/StringBuilder
    //   36: dup
    //   37: ldc 142
    //   39: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   42: lload_2
    //   43: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   46: ldc 147
    //   48: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc 152
    //   53: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: lload 4
    //   58: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   61: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: astore 9
    //   66: aload 9
    //   68: astore 8
    //   70: aload_1
    //   71: ifnull +102 -> 173
    //   74: aload 9
    //   76: astore 8
    //   78: aload_1
    //   79: arraylength
    //   80: ifle +93 -> 173
    //   83: ldc 159
    //   85: astore 8
    //   87: iconst_0
    //   88: istore 7
    //   90: iload 7
    //   92: aload_1
    //   93: arraylength
    //   94: if_icmpge +41 -> 135
    //   97: new 97	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   104: aload 8
    //   106: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 161
    //   111: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_1
    //   115: iload 7
    //   117: iaload
    //   118: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: astore 8
    //   126: iload 7
    //   128: iconst_1
    //   129: iadd
    //   130: istore 7
    //   132: goto -42 -> 90
    //   135: aload 8
    //   137: iconst_4
    //   138: invokevirtual 167	java/lang/String:substring	(I)Ljava/lang/String;
    //   141: astore_1
    //   142: new 97	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   149: aload 9
    //   151: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc 169
    //   156: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_1
    //   160: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: ldc 171
    //   165: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: astore 8
    //   173: aload 8
    //   175: astore_1
    //   176: aload 6
    //   178: ifnull +34 -> 212
    //   181: new 97	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   188: aload 8
    //   190: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc 186
    //   195: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload 6
    //   200: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: ldc 188
    //   205: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: astore_1
    //   212: new 97	java/lang/StringBuilder
    //   215: dup
    //   216: ldc 190
    //   218: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   221: aload_1
    //   222: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: iconst_0
    //   229: anewarray 4	java/lang/Object
    //   232: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   235: aconst_null
    //   236: astore 10
    //   238: aconst_null
    //   239: astore 8
    //   241: aconst_null
    //   242: astore 9
    //   244: new 68	com/tencent/feedback/proguard/n
    //   247: dup
    //   248: aload_0
    //   249: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   252: astore 6
    //   254: aload 6
    //   256: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   259: astore_0
    //   260: aload_0
    //   261: ldc 175
    //   263: iconst_1
    //   264: anewarray 163	java/lang/String
    //   267: dup
    //   268: iconst_0
    //   269: ldc 192
    //   271: aastore
    //   272: aload_1
    //   273: aconst_null
    //   274: aconst_null
    //   275: aconst_null
    //   276: aconst_null
    //   277: invokevirtual 196	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   280: astore_1
    //   281: aload_1
    //   282: invokeinterface 201 1 0
    //   287: pop
    //   288: aload_1
    //   289: aload_1
    //   290: ldc 203
    //   292: invokeinterface 207 2 0
    //   297: invokeinterface 211 2 0
    //   302: istore 7
    //   304: new 97	java/lang/StringBuilder
    //   307: dup
    //   308: ldc 213
    //   310: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   313: iload 7
    //   315: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   318: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: iconst_0
    //   322: anewarray 4	java/lang/Object
    //   325: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   328: aload_1
    //   329: ifnull +18 -> 347
    //   332: aload_1
    //   333: invokeinterface 216 1 0
    //   338: ifne +9 -> 347
    //   341: aload_1
    //   342: invokeinterface 217 1 0
    //   347: aload_0
    //   348: ifnull +14 -> 362
    //   351: aload_0
    //   352: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   355: ifeq +7 -> 362
    //   358: aload_0
    //   359: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   362: aload 6
    //   364: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   367: ldc 219
    //   369: iconst_0
    //   370: anewarray 4	java/lang/Object
    //   373: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   376: iload 7
    //   378: ireturn
    //   379: astore 8
    //   381: aconst_null
    //   382: astore_1
    //   383: aload 10
    //   385: astore_0
    //   386: aload 9
    //   388: astore 6
    //   390: aload 8
    //   392: invokevirtual 127	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   395: iconst_0
    //   396: anewarray 4	java/lang/Object
    //   399: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   402: aload_1
    //   403: ifnull +18 -> 421
    //   406: aload_1
    //   407: invokeinterface 216 1 0
    //   412: ifne +9 -> 421
    //   415: aload_1
    //   416: invokeinterface 217 1 0
    //   421: aload 6
    //   423: ifnull +16 -> 439
    //   426: aload 6
    //   428: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   431: ifeq +8 -> 439
    //   434: aload 6
    //   436: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   439: aload_0
    //   440: ifnull +7 -> 447
    //   443: aload_0
    //   444: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   447: ldc 219
    //   449: iconst_0
    //   450: anewarray 4	java/lang/Object
    //   453: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   456: iconst_m1
    //   457: ireturn
    //   458: astore_0
    //   459: aconst_null
    //   460: astore 6
    //   462: aconst_null
    //   463: astore_1
    //   464: aload_1
    //   465: ifnull +18 -> 483
    //   468: aload_1
    //   469: invokeinterface 216 1 0
    //   474: ifne +9 -> 483
    //   477: aload_1
    //   478: invokeinterface 217 1 0
    //   483: aload 8
    //   485: ifnull +16 -> 501
    //   488: aload 8
    //   490: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   493: ifeq +8 -> 501
    //   496: aload 8
    //   498: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   501: aload 6
    //   503: ifnull +8 -> 511
    //   506: aload 6
    //   508: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   511: ldc 219
    //   513: iconst_0
    //   514: anewarray 4	java/lang/Object
    //   517: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   520: aload_0
    //   521: athrow
    //   522: astore_0
    //   523: aconst_null
    //   524: astore_1
    //   525: goto -61 -> 464
    //   528: astore_1
    //   529: aconst_null
    //   530: astore 9
    //   532: aload_0
    //   533: astore 8
    //   535: aload_1
    //   536: astore_0
    //   537: aload 9
    //   539: astore_1
    //   540: goto -76 -> 464
    //   543: astore 9
    //   545: aload_0
    //   546: astore 8
    //   548: aload 9
    //   550: astore_0
    //   551: goto -87 -> 464
    //   554: astore 8
    //   556: aload_0
    //   557: astore 9
    //   559: aload 8
    //   561: astore_0
    //   562: aload 6
    //   564: astore 8
    //   566: aload 9
    //   568: astore 6
    //   570: goto -106 -> 464
    //   573: astore 8
    //   575: aload 6
    //   577: astore_0
    //   578: aconst_null
    //   579: astore_1
    //   580: aload 9
    //   582: astore 6
    //   584: goto -194 -> 390
    //   587: astore 8
    //   589: aload 6
    //   591: astore_1
    //   592: aconst_null
    //   593: astore 9
    //   595: aload_0
    //   596: astore 6
    //   598: aload_1
    //   599: astore_0
    //   600: aload 9
    //   602: astore_1
    //   603: goto -213 -> 390
    //   606: astore 8
    //   608: aload 6
    //   610: astore 9
    //   612: aload_0
    //   613: astore 6
    //   615: aload 9
    //   617: astore_0
    //   618: goto -228 -> 390
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	621	0	paramContext	Context
    //   0	621	1	paramArrayOfInt	int[]
    //   0	621	2	paramLong1	long
    //   0	621	4	paramLong2	long
    //   0	621	6	paramString	String
    //   88	289	7	k	int
    //   68	172	8	str1	String
    //   379	118	8	localThrowable1	Throwable
    //   533	14	8	localContext	Context
    //   554	6	8	localObject1	Object
    //   564	1	8	str2	String
    //   573	1	8	localThrowable2	Throwable
    //   587	1	8	localThrowable3	Throwable
    //   606	1	8	localThrowable4	Throwable
    //   64	474	9	str3	String
    //   543	6	9	localObject2	Object
    //   557	59	9	localObject3	Object
    //   236	148	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   244	254	379	java/lang/Throwable
    //   244	254	458	finally
    //   254	260	522	finally
    //   260	281	528	finally
    //   281	328	543	finally
    //   390	402	554	finally
    //   254	260	573	java/lang/Throwable
    //   260	281	587	java/lang/Throwable
    //   281	328	606	java/lang/Throwable
  }
  
  /* Error */
  public static int a(Context paramContext, Long[] paramArrayOfLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 11
    //   9: aconst_null
    //   10: astore 8
    //   12: ldc 222
    //   14: iconst_0
    //   15: anewarray 4	java/lang/Object
    //   18: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   21: aload_0
    //   22: ifnonnull +14 -> 36
    //   25: ldc 224
    //   27: iconst_0
    //   28: anewarray 4	java/lang/Object
    //   31: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: iconst_m1
    //   35: ireturn
    //   36: aload_1
    //   37: ifnull +8 -> 45
    //   40: aload_1
    //   41: arraylength
    //   42: ifgt +5 -> 47
    //   45: iconst_0
    //   46: ireturn
    //   47: new 68	com/tencent/feedback/proguard/n
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   55: astore 9
    //   57: aload 7
    //   59: astore_0
    //   60: aload 9
    //   62: astore 7
    //   64: aload 11
    //   66: astore 8
    //   68: aload 9
    //   70: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   73: astore 10
    //   75: aload 10
    //   77: astore_0
    //   78: aload 9
    //   80: astore 7
    //   82: aload 10
    //   84: astore 8
    //   86: new 226	java/lang/StringBuffer
    //   89: dup
    //   90: invokespecial 227	java/lang/StringBuffer:<init>	()V
    //   93: astore 11
    //   95: iconst_0
    //   96: istore_2
    //   97: iconst_0
    //   98: istore_3
    //   99: aload 10
    //   101: astore_0
    //   102: aload 9
    //   104: astore 7
    //   106: aload 10
    //   108: astore 8
    //   110: iload_3
    //   111: aload_1
    //   112: arraylength
    //   113: if_icmpge +191 -> 304
    //   116: aload 10
    //   118: astore_0
    //   119: aload 9
    //   121: astore 7
    //   123: aload 10
    //   125: astore 8
    //   127: aload_1
    //   128: iload_3
    //   129: aaload
    //   130: invokevirtual 233	java/lang/Long:longValue	()J
    //   133: lstore 5
    //   135: aload 10
    //   137: astore_0
    //   138: aload 9
    //   140: astore 7
    //   142: aload 10
    //   144: astore 8
    //   146: aload 11
    //   148: new 97	java/lang/StringBuilder
    //   151: dup
    //   152: ldc 235
    //   154: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   157: lload 5
    //   159: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   162: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokevirtual 238	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   168: pop
    //   169: iload_2
    //   170: istore 4
    //   172: iload_3
    //   173: ifle +379 -> 552
    //   176: iload_2
    //   177: istore 4
    //   179: iload_3
    //   180: bipush 50
    //   182: irem
    //   183: ifne +369 -> 552
    //   186: aload 10
    //   188: astore_0
    //   189: aload 9
    //   191: astore 7
    //   193: aload 10
    //   195: astore 8
    //   197: new 97	java/lang/StringBuilder
    //   200: dup
    //   201: ldc 240
    //   203: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   206: iload_3
    //   207: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   210: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: iconst_0
    //   214: anewarray 4	java/lang/Object
    //   217: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   220: aload 10
    //   222: astore_0
    //   223: aload 9
    //   225: astore 7
    //   227: aload 10
    //   229: astore 8
    //   231: iload_2
    //   232: aload 10
    //   234: ldc 175
    //   236: aload 11
    //   238: iconst_4
    //   239: invokevirtual 241	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   242: aconst_null
    //   243: invokevirtual 116	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   246: iadd
    //   247: istore 4
    //   249: aload 10
    //   251: astore_0
    //   252: aload 9
    //   254: astore 7
    //   256: aload 10
    //   258: astore 8
    //   260: aload 11
    //   262: iconst_0
    //   263: invokevirtual 245	java/lang/StringBuffer:setLength	(I)V
    //   266: aload 10
    //   268: astore_0
    //   269: aload 9
    //   271: astore 7
    //   273: aload 10
    //   275: astore 8
    //   277: new 97	java/lang/StringBuilder
    //   280: dup
    //   281: ldc 247
    //   283: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   286: iload 4
    //   288: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   291: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: iconst_0
    //   295: anewarray 4	java/lang/Object
    //   298: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   301: goto +251 -> 552
    //   304: iload_2
    //   305: istore_3
    //   306: aload 10
    //   308: astore_0
    //   309: aload 9
    //   311: astore 7
    //   313: aload 10
    //   315: astore 8
    //   317: aload 11
    //   319: invokevirtual 251	java/lang/StringBuffer:length	()I
    //   322: ifle +48 -> 370
    //   325: aload 10
    //   327: astore_0
    //   328: aload 9
    //   330: astore 7
    //   332: aload 10
    //   334: astore 8
    //   336: iload_2
    //   337: aload 10
    //   339: ldc 175
    //   341: aload 11
    //   343: iconst_4
    //   344: invokevirtual 241	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   347: aconst_null
    //   348: invokevirtual 116	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   351: iadd
    //   352: istore_3
    //   353: aload 10
    //   355: astore_0
    //   356: aload 9
    //   358: astore 7
    //   360: aload 10
    //   362: astore 8
    //   364: aload 11
    //   366: iconst_0
    //   367: invokevirtual 245	java/lang/StringBuffer:setLength	(I)V
    //   370: aload 10
    //   372: astore_0
    //   373: aload 9
    //   375: astore 7
    //   377: aload 10
    //   379: astore 8
    //   381: new 97	java/lang/StringBuilder
    //   384: dup
    //   385: ldc 253
    //   387: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   390: iload_3
    //   391: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   394: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: iconst_0
    //   398: anewarray 4	java/lang/Object
    //   401: invokestatic 140	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   404: aload 10
    //   406: ifnull +16 -> 422
    //   409: aload 10
    //   411: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   414: ifeq +8 -> 422
    //   417: aload 10
    //   419: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   422: aload 9
    //   424: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   427: ldc 255
    //   429: iconst_0
    //   430: anewarray 4	java/lang/Object
    //   433: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   436: iload_3
    //   437: ireturn
    //   438: astore 10
    //   440: aconst_null
    //   441: astore_1
    //   442: aload 8
    //   444: astore_0
    //   445: aload_1
    //   446: astore 7
    //   448: aload 10
    //   450: invokevirtual 127	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   453: iconst_0
    //   454: anewarray 4	java/lang/Object
    //   457: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   460: aload 8
    //   462: ifnull +16 -> 478
    //   465: aload 8
    //   467: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   470: ifeq +8 -> 478
    //   473: aload 8
    //   475: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   478: aload_1
    //   479: ifnull +7 -> 486
    //   482: aload_1
    //   483: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   486: ldc 255
    //   488: iconst_0
    //   489: anewarray 4	java/lang/Object
    //   492: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   495: iconst_m1
    //   496: ireturn
    //   497: astore_1
    //   498: aconst_null
    //   499: astore 7
    //   501: aload 10
    //   503: astore_0
    //   504: aload_0
    //   505: ifnull +14 -> 519
    //   508: aload_0
    //   509: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   512: ifeq +7 -> 519
    //   515: aload_0
    //   516: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   519: aload 7
    //   521: ifnull +8 -> 529
    //   524: aload 7
    //   526: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   529: ldc 255
    //   531: iconst_0
    //   532: anewarray 4	java/lang/Object
    //   535: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   538: aload_1
    //   539: athrow
    //   540: astore_1
    //   541: goto -37 -> 504
    //   544: astore 10
    //   546: aload 9
    //   548: astore_1
    //   549: goto -107 -> 442
    //   552: iload_3
    //   553: iconst_1
    //   554: iadd
    //   555: istore_3
    //   556: iload 4
    //   558: istore_2
    //   559: goto -460 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	562	0	paramContext	Context
    //   0	562	1	paramArrayOfLong	Long[]
    //   96	463	2	k	int
    //   98	458	3	m	int
    //   170	387	4	n	int
    //   133	25	5	l	long
    //   4	521	7	localObject1	Object
    //   10	464	8	localObject2	Object
    //   55	492	9	localn	n
    //   1	417	10	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   438	64	10	localThrowable1	Throwable
    //   544	1	10	localThrowable2	Throwable
    //   7	358	11	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   47	57	438	java/lang/Throwable
    //   47	57	497	finally
    //   68	75	540	finally
    //   86	95	540	finally
    //   110	116	540	finally
    //   127	135	540	finally
    //   146	169	540	finally
    //   197	220	540	finally
    //   231	249	540	finally
    //   260	266	540	finally
    //   277	301	540	finally
    //   317	325	540	finally
    //   336	353	540	finally
    //   364	370	540	finally
    //   381	404	540	finally
    //   448	460	540	finally
    //   68	75	544	java/lang/Throwable
    //   86	95	544	java/lang/Throwable
    //   110	116	544	java/lang/Throwable
    //   127	135	544	java/lang/Throwable
    //   146	169	544	java/lang/Throwable
    //   197	220	544	java/lang/Throwable
    //   231	249	544	java/lang/Throwable
    //   260	266	544	java/lang/Throwable
    //   277	301	544	java/lang/Throwable
    //   317	325	544	java/lang/Throwable
    //   336	353	544	java/lang/Throwable
    //   364	370	544	java/lang/Throwable
    //   381	404	544	java/lang/Throwable
  }
  
  public static ContentValues a(l paraml)
  {
    ContentValues localContentValues = new ContentValues();
    if (paraml.a > 0L) {
      localContentValues.put("_id", Long.valueOf(paraml.a));
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
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: iload_3
    //   5: ifne +22 -> 27
    //   8: ldc_w 304
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: iload_3
    //   18: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: aastore
    //   22: invokestatic 56	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: aconst_null
    //   26: areturn
    //   27: aload_1
    //   28: ifnonnull +139 -> 167
    //   31: ldc_w 306
    //   34: astore 4
    //   36: ldc_w 308
    //   39: iconst_3
    //   40: anewarray 4	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: aload 4
    //   47: aastore
    //   48: dup
    //   49: iconst_1
    //   50: iload_2
    //   51: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   54: aastore
    //   55: dup
    //   56: iconst_2
    //   57: iload_3
    //   58: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   61: aastore
    //   62: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   65: aconst_null
    //   66: astore 7
    //   68: aconst_null
    //   69: astore 8
    //   71: new 68	com/tencent/feedback/proguard/n
    //   74: dup
    //   75: aload_0
    //   76: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   79: astore 4
    //   81: aload 4
    //   83: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   86: astore_0
    //   87: aload_0
    //   88: ifnonnull +85 -> 173
    //   91: ldc_w 310
    //   94: iconst_0
    //   95: anewarray 4	java/lang/Object
    //   98: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: ldc_w 312
    //   104: iconst_0
    //   105: anewarray 4	java/lang/Object
    //   108: invokestatic 83	com/tencent/feedback/common/e:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: aload_0
    //   112: ifnull +14 -> 126
    //   115: aload_0
    //   116: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   119: ifeq +7 -> 126
    //   122: aload_0
    //   123: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   126: aload 4
    //   128: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   131: ldc_w 314
    //   134: iconst_1
    //   135: anewarray 4	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: iconst_m1
    //   141: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   144: aastore
    //   145: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   148: ldc_w 316
    //   151: iconst_1
    //   152: anewarray 4	java/lang/Object
    //   155: dup
    //   156: iconst_0
    //   157: iconst_m1
    //   158: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   161: aastore
    //   162: invokestatic 83	com/tencent/feedback/common/e:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   165: aconst_null
    //   166: areturn
    //   167: aload_1
    //   168: astore 4
    //   170: goto -134 -> 36
    //   173: new 226	java/lang/StringBuffer
    //   176: dup
    //   177: invokespecial 227	java/lang/StringBuffer:<init>	()V
    //   180: astore 5
    //   182: aload_1
    //   183: ifnull +54 -> 237
    //   186: aload 5
    //   188: invokevirtual 251	java/lang/StringBuffer:length	()I
    //   191: ifle +12 -> 203
    //   194: aload 5
    //   196: ldc_w 318
    //   199: invokevirtual 238	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   202: pop
    //   203: aload 5
    //   205: ldc_w 320
    //   208: invokevirtual 238	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   211: pop
    //   212: aload 5
    //   214: ldc_w 322
    //   217: invokevirtual 238	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   220: pop
    //   221: aload 5
    //   223: aload_1
    //   224: invokevirtual 238	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   227: pop
    //   228: aload 5
    //   230: ldc_w 324
    //   233: invokevirtual 238	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   236: pop
    //   237: iload_2
    //   238: iflt +45 -> 283
    //   241: aload 5
    //   243: invokevirtual 251	java/lang/StringBuffer:length	()I
    //   246: ifle +12 -> 258
    //   249: aload 5
    //   251: ldc_w 318
    //   254: invokevirtual 238	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   257: pop
    //   258: aload 5
    //   260: ldc_w 326
    //   263: invokevirtual 238	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   266: pop
    //   267: aload 5
    //   269: ldc_w 328
    //   272: invokevirtual 238	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   275: pop
    //   276: aload 5
    //   278: iload_2
    //   279: invokevirtual 331	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   282: pop
    //   283: aload 5
    //   285: invokevirtual 251	java/lang/StringBuffer:length	()I
    //   288: ifle +266 -> 554
    //   291: aload 5
    //   293: invokevirtual 332	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   296: astore_1
    //   297: iload_3
    //   298: ifle +261 -> 559
    //   301: new 97	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   308: iload_3
    //   309: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   312: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: astore 5
    //   317: aload_0
    //   318: ldc 112
    //   320: aconst_null
    //   321: aload_1
    //   322: aconst_null
    //   323: aconst_null
    //   324: aconst_null
    //   325: aconst_null
    //   326: aload 5
    //   328: invokevirtual 335	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   331: astore 6
    //   333: aload 6
    //   335: ifnull +574 -> 909
    //   338: new 337	java/util/ArrayList
    //   341: dup
    //   342: invokespecial 338	java/util/ArrayList:<init>	()V
    //   345: astore_1
    //   346: aload 6
    //   348: invokeinterface 201 1 0
    //   353: ifeq +212 -> 565
    //   356: aload 6
    //   358: invokestatic 341	com/tencent/feedback/proguard/l:b	(Landroid/database/Cursor;)Lcom/tencent/feedback/proguard/o;
    //   361: astore 5
    //   363: aload 5
    //   365: ifnull +200 -> 565
    //   368: ldc_w 343
    //   371: iconst_4
    //   372: anewarray 4	java/lang/Object
    //   375: dup
    //   376: iconst_0
    //   377: aload 5
    //   379: invokevirtual 347	com/tencent/feedback/proguard/o:a	()Ljava/lang/String;
    //   382: aastore
    //   383: dup
    //   384: iconst_1
    //   385: aload 5
    //   387: invokevirtual 349	com/tencent/feedback/proguard/o:d	()Ljava/lang/String;
    //   390: aastore
    //   391: dup
    //   392: iconst_2
    //   393: aload 5
    //   395: invokevirtual 350	com/tencent/feedback/proguard/o:e	()I
    //   398: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   401: aastore
    //   402: dup
    //   403: iconst_3
    //   404: aload 5
    //   406: invokevirtual 352	com/tencent/feedback/proguard/o:f	()Ljava/lang/String;
    //   409: aastore
    //   410: invokestatic 83	com/tencent/feedback/common/e:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   413: aload_1
    //   414: aload 5
    //   416: invokeinterface 358 2 0
    //   421: pop
    //   422: goto -76 -> 346
    //   425: astore 5
    //   427: aload_1
    //   428: astore 7
    //   430: aload_0
    //   431: astore_1
    //   432: aload 7
    //   434: astore_0
    //   435: ldc_w 360
    //   438: iconst_0
    //   439: anewarray 4	java/lang/Object
    //   442: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   445: ldc_w 312
    //   448: iconst_0
    //   449: anewarray 4	java/lang/Object
    //   452: invokestatic 83	com/tencent/feedback/common/e:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   455: aload 5
    //   457: invokevirtual 130	java/lang/Throwable:printStackTrace	()V
    //   460: aload 6
    //   462: ifnull +20 -> 482
    //   465: aload 6
    //   467: invokeinterface 216 1 0
    //   472: ifne +10 -> 482
    //   475: aload 6
    //   477: invokeinterface 217 1 0
    //   482: aload_1
    //   483: ifnull +14 -> 497
    //   486: aload_1
    //   487: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   490: ifeq +7 -> 497
    //   493: aload_1
    //   494: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   497: aload 4
    //   499: ifnull +8 -> 507
    //   502: aload 4
    //   504: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   507: aload_0
    //   508: ifnull +151 -> 659
    //   511: aload_0
    //   512: invokeinterface 363 1 0
    //   517: istore_2
    //   518: ldc_w 314
    //   521: iconst_1
    //   522: anewarray 4	java/lang/Object
    //   525: dup
    //   526: iconst_0
    //   527: iload_2
    //   528: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   531: aastore
    //   532: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   535: ldc_w 316
    //   538: iconst_1
    //   539: anewarray 4	java/lang/Object
    //   542: dup
    //   543: iconst_0
    //   544: iload_2
    //   545: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   548: aastore
    //   549: invokestatic 83	com/tencent/feedback/common/e:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   552: aload_0
    //   553: areturn
    //   554: aconst_null
    //   555: astore_1
    //   556: goto -259 -> 297
    //   559: aconst_null
    //   560: astore 5
    //   562: goto -245 -> 317
    //   565: aload 6
    //   567: ifnull +20 -> 587
    //   570: aload 6
    //   572: invokeinterface 216 1 0
    //   577: ifne +10 -> 587
    //   580: aload 6
    //   582: invokeinterface 217 1 0
    //   587: aload_0
    //   588: ifnull +14 -> 602
    //   591: aload_0
    //   592: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   595: ifeq +7 -> 602
    //   598: aload_0
    //   599: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   602: aload 4
    //   604: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   607: aload_1
    //   608: ifnull +46 -> 654
    //   611: aload_1
    //   612: invokeinterface 363 1 0
    //   617: istore_2
    //   618: ldc_w 314
    //   621: iconst_1
    //   622: anewarray 4	java/lang/Object
    //   625: dup
    //   626: iconst_0
    //   627: iload_2
    //   628: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   631: aastore
    //   632: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   635: ldc_w 316
    //   638: iconst_1
    //   639: anewarray 4	java/lang/Object
    //   642: dup
    //   643: iconst_0
    //   644: iload_2
    //   645: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   648: aastore
    //   649: invokestatic 83	com/tencent/feedback/common/e:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   652: aload_1
    //   653: areturn
    //   654: iconst_m1
    //   655: istore_2
    //   656: goto -38 -> 618
    //   659: iconst_m1
    //   660: istore_2
    //   661: goto -143 -> 518
    //   664: astore_0
    //   665: aconst_null
    //   666: astore 4
    //   668: aconst_null
    //   669: astore_1
    //   670: aload 7
    //   672: astore 6
    //   674: aload 8
    //   676: astore 5
    //   678: aload 5
    //   680: ifnull +20 -> 700
    //   683: aload 5
    //   685: invokeinterface 216 1 0
    //   690: ifne +10 -> 700
    //   693: aload 5
    //   695: invokeinterface 217 1 0
    //   700: aload_1
    //   701: ifnull +14 -> 715
    //   704: aload_1
    //   705: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   708: ifeq +7 -> 715
    //   711: aload_1
    //   712: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   715: aload 4
    //   717: ifnull +8 -> 725
    //   720: aload 4
    //   722: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   725: aload 6
    //   727: ifnull +47 -> 774
    //   730: aload 6
    //   732: invokeinterface 363 1 0
    //   737: istore_2
    //   738: ldc_w 314
    //   741: iconst_1
    //   742: anewarray 4	java/lang/Object
    //   745: dup
    //   746: iconst_0
    //   747: iload_2
    //   748: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   751: aastore
    //   752: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   755: ldc_w 316
    //   758: iconst_1
    //   759: anewarray 4	java/lang/Object
    //   762: dup
    //   763: iconst_0
    //   764: iload_2
    //   765: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   768: aastore
    //   769: invokestatic 83	com/tencent/feedback/common/e:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   772: aload_0
    //   773: athrow
    //   774: iconst_m1
    //   775: istore_2
    //   776: goto -38 -> 738
    //   779: astore_0
    //   780: aconst_null
    //   781: astore_1
    //   782: aload 8
    //   784: astore 5
    //   786: aload 7
    //   788: astore 6
    //   790: goto -112 -> 678
    //   793: astore 5
    //   795: aload_0
    //   796: astore_1
    //   797: aload 5
    //   799: astore_0
    //   800: aload 8
    //   802: astore 5
    //   804: aload 7
    //   806: astore 6
    //   808: goto -130 -> 678
    //   811: astore 8
    //   813: aload 6
    //   815: astore 5
    //   817: aload_0
    //   818: astore_1
    //   819: aload 8
    //   821: astore_0
    //   822: aload 7
    //   824: astore 6
    //   826: goto -148 -> 678
    //   829: astore 7
    //   831: aload 6
    //   833: astore 5
    //   835: aload_1
    //   836: astore 6
    //   838: aload_0
    //   839: astore_1
    //   840: aload 7
    //   842: astore_0
    //   843: goto -165 -> 678
    //   846: astore 7
    //   848: aload 6
    //   850: astore 5
    //   852: aload_0
    //   853: astore 6
    //   855: aload 7
    //   857: astore_0
    //   858: goto -180 -> 678
    //   861: astore 5
    //   863: aconst_null
    //   864: astore_1
    //   865: aconst_null
    //   866: astore 4
    //   868: aconst_null
    //   869: astore 6
    //   871: aconst_null
    //   872: astore_0
    //   873: goto -438 -> 435
    //   876: astore 5
    //   878: aconst_null
    //   879: astore 6
    //   881: aconst_null
    //   882: astore_1
    //   883: aconst_null
    //   884: astore_0
    //   885: goto -450 -> 435
    //   888: astore 5
    //   890: aconst_null
    //   891: astore 6
    //   893: aload_0
    //   894: astore_1
    //   895: aconst_null
    //   896: astore_0
    //   897: goto -462 -> 435
    //   900: astore 5
    //   902: aload_0
    //   903: astore_1
    //   904: aconst_null
    //   905: astore_0
    //   906: goto -471 -> 435
    //   909: aconst_null
    //   910: astore_1
    //   911: goto -346 -> 565
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	914	0	paramContext	Context
    //   0	914	1	paramString	String
    //   0	914	2	paramInt1	int
    //   0	914	3	paramInt2	int
    //   34	833	4	localObject1	Object
    //   180	235	5	localObject2	Object
    //   425	31	5	localThrowable1	Throwable
    //   560	225	5	localObject3	Object
    //   793	5	5	localObject4	Object
    //   802	49	5	localObject5	Object
    //   861	1	5	localThrowable2	Throwable
    //   876	1	5	localThrowable3	Throwable
    //   888	1	5	localThrowable4	Throwable
    //   900	1	5	localThrowable5	Throwable
    //   331	561	6	localObject6	Object
    //   66	757	7	str	String
    //   829	12	7	localObject7	Object
    //   846	10	7	localObject8	Object
    //   69	732	8	localObject9	Object
    //   811	9	8	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   346	363	425	java/lang/Throwable
    //   368	422	425	java/lang/Throwable
    //   71	81	664	finally
    //   81	87	779	finally
    //   91	111	793	finally
    //   173	182	793	finally
    //   186	203	793	finally
    //   203	237	793	finally
    //   241	258	793	finally
    //   258	283	793	finally
    //   283	297	793	finally
    //   301	317	793	finally
    //   317	333	793	finally
    //   338	346	811	finally
    //   346	363	829	finally
    //   368	422	829	finally
    //   435	460	846	finally
    //   71	81	861	java/lang/Throwable
    //   81	87	876	java/lang/Throwable
    //   91	111	888	java/lang/Throwable
    //   173	182	888	java/lang/Throwable
    //   186	203	888	java/lang/Throwable
    //   203	237	888	java/lang/Throwable
    //   241	258	888	java/lang/Throwable
    //   258	283	888	java/lang/Throwable
    //   283	297	888	java/lang/Throwable
    //   301	317	888	java/lang/Throwable
    //   317	333	888	java/lang/Throwable
    //   338	346	900	java/lang/Throwable
  }
  
  public static List<l> a(Context paramContext, int[] paramArrayOfInt, int paramInt1, int paramInt2, long paramLong1, int paramInt3, String paramString, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong2, long paramLong3)
  {
    return a(paramContext, paramArrayOfInt, -1, -1, paramLong1, paramInt3, paramString, -1, -1, -1, -1, -1L, 9223372036854775807L, -1);
  }
  
  /* Error */
  public static List<l> a(Context paramContext, int[] paramArrayOfInt, int paramInt1, int paramInt2, long paramLong1, int paramInt3, String paramString, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong2, long paramLong3, int paramInt8)
  {
    // Byte code:
    //   0: ldc_w 374
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   10: aload_0
    //   11: ifnull +49 -> 60
    //   14: lload 4
    //   16: lconst_0
    //   17: lcmp
    //   18: ifeq +42 -> 60
    //   21: lload 14
    //   23: lconst_0
    //   24: lcmp
    //   25: ifle +11 -> 36
    //   28: lload 12
    //   30: lload 14
    //   32: lcmp
    //   33: ifgt +27 -> 60
    //   36: iload 9
    //   38: ifle +10 -> 48
    //   41: iload 8
    //   43: iload 9
    //   45: if_icmpgt +15 -> 60
    //   48: iload 11
    //   50: ifle +22 -> 72
    //   53: iload 10
    //   55: iload 11
    //   57: if_icmple +15 -> 72
    //   60: ldc_w 376
    //   63: iconst_0
    //   64: anewarray 4	java/lang/Object
    //   67: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: aconst_null
    //   71: areturn
    //   72: lload 4
    //   74: lstore 18
    //   76: lload 4
    //   78: lconst_0
    //   79: lcmp
    //   80: ifge +8 -> 88
    //   83: ldc2_w 367
    //   86: lstore 18
    //   88: aload_1
    //   89: ifnull +2090 -> 2179
    //   92: aload_1
    //   93: arraylength
    //   94: ifle +2085 -> 2179
    //   97: ldc 159
    //   99: astore 20
    //   101: iconst_0
    //   102: istore 17
    //   104: iload 17
    //   106: aload_1
    //   107: arraylength
    //   108: if_icmpge +41 -> 149
    //   111: new 97	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   118: aload 20
    //   120: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc 161
    //   125: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_1
    //   129: iload 17
    //   131: iaload
    //   132: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   135: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: astore 20
    //   140: iload 17
    //   142: iconst_1
    //   143: iadd
    //   144: istore 17
    //   146: goto -42 -> 104
    //   149: new 97	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   156: ldc 159
    //   158: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload 20
    //   163: iconst_4
    //   164: invokevirtual 167	java/lang/String:substring	(I)Ljava/lang/String;
    //   167: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: astore_1
    //   174: aload_1
    //   175: invokevirtual 377	java/lang/String:length	()I
    //   178: ifle +937 -> 1115
    //   181: new 97	java/lang/StringBuilder
    //   184: dup
    //   185: ldc_w 379
    //   188: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   191: aload_1
    //   192: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: ldc_w 381
    //   198: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: astore 20
    //   206: aload 20
    //   208: astore_1
    //   209: aload 7
    //   211: ifnull +56 -> 267
    //   214: new 97	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   221: aload 20
    //   223: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: astore 21
    //   228: aload 20
    //   230: invokevirtual 377	java/lang/String:length	()I
    //   233: ifle +889 -> 1122
    //   236: ldc_w 318
    //   239: astore_1
    //   240: aload 21
    //   242: aload_1
    //   243: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: ldc_w 383
    //   249: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload 7
    //   254: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc_w 324
    //   260: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: astore_1
    //   267: aload_1
    //   268: astore 7
    //   270: iload 8
    //   272: iflt +55 -> 327
    //   275: new 97	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   282: aload_1
    //   283: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: astore 7
    //   288: aload_1
    //   289: invokevirtual 377	java/lang/String:length	()I
    //   292: ifle +836 -> 1128
    //   295: ldc_w 318
    //   298: astore_1
    //   299: aload 7
    //   301: aload_1
    //   302: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc_w 385
    //   308: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: iload 8
    //   313: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   316: ldc_w 387
    //   319: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: astore 7
    //   327: aload 7
    //   329: astore_1
    //   330: iload 9
    //   332: iflt +56 -> 388
    //   335: new 97	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   342: aload 7
    //   344: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: astore 20
    //   349: aload 7
    //   351: invokevirtual 377	java/lang/String:length	()I
    //   354: ifle +780 -> 1134
    //   357: ldc_w 318
    //   360: astore_1
    //   361: aload 20
    //   363: aload_1
    //   364: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: ldc_w 389
    //   370: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: iload 9
    //   375: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   378: ldc_w 387
    //   381: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: astore_1
    //   388: aload_1
    //   389: astore 7
    //   391: iload 10
    //   393: iflt +55 -> 448
    //   396: new 97	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   403: aload_1
    //   404: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: astore 7
    //   409: aload_1
    //   410: invokevirtual 377	java/lang/String:length	()I
    //   413: ifle +727 -> 1140
    //   416: ldc_w 318
    //   419: astore_1
    //   420: aload 7
    //   422: aload_1
    //   423: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: ldc_w 391
    //   429: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: iload 10
    //   434: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   437: ldc_w 387
    //   440: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   446: astore 7
    //   448: aload 7
    //   450: astore_1
    //   451: iload 11
    //   453: iflt +56 -> 509
    //   456: new 97	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   463: aload 7
    //   465: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: astore 20
    //   470: aload 7
    //   472: invokevirtual 377	java/lang/String:length	()I
    //   475: ifle +671 -> 1146
    //   478: ldc_w 318
    //   481: astore_1
    //   482: aload 20
    //   484: aload_1
    //   485: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: ldc_w 393
    //   491: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: iload 11
    //   496: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   499: ldc_w 387
    //   502: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: astore_1
    //   509: aload_1
    //   510: astore 7
    //   512: lload 12
    //   514: lconst_0
    //   515: lcmp
    //   516: iflt +54 -> 570
    //   519: new 97	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   526: aload_1
    //   527: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: astore 7
    //   532: aload_1
    //   533: invokevirtual 377	java/lang/String:length	()I
    //   536: ifle +616 -> 1152
    //   539: ldc_w 318
    //   542: astore_1
    //   543: aload 7
    //   545: aload_1
    //   546: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: ldc 142
    //   551: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: lload 12
    //   556: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   559: ldc_w 387
    //   562: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: astore 7
    //   570: aload 7
    //   572: astore_1
    //   573: lload 14
    //   575: lconst_0
    //   576: lcmp
    //   577: iflt +56 -> 633
    //   580: new 97	java/lang/StringBuilder
    //   583: dup
    //   584: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   587: aload 7
    //   589: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: astore 20
    //   594: aload 7
    //   596: invokevirtual 377	java/lang/String:length	()I
    //   599: ifle +559 -> 1158
    //   602: ldc_w 318
    //   605: astore_1
    //   606: aload 20
    //   608: aload_1
    //   609: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: ldc_w 395
    //   615: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: lload 14
    //   620: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   623: ldc_w 387
    //   626: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   632: astore_1
    //   633: aload_1
    //   634: astore 7
    //   636: iload 16
    //   638: iflt +55 -> 693
    //   641: new 97	java/lang/StringBuilder
    //   644: dup
    //   645: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   648: aload_1
    //   649: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: astore 7
    //   654: aload_1
    //   655: invokevirtual 377	java/lang/String:length	()I
    //   658: ifle +506 -> 1164
    //   661: ldc_w 318
    //   664: astore_1
    //   665: aload 7
    //   667: aload_1
    //   668: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: ldc_w 397
    //   674: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: iload 16
    //   679: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   682: ldc_w 387
    //   685: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   691: astore 7
    //   693: ldc 159
    //   695: astore_1
    //   696: iload_2
    //   697: tableswitch	default:+23 -> 720, 1:+473->1170, 2:+498->1195
    //   721: tableswitch	default:+23 -> 744, 1:+499->1220, 2:+523->1244
    //   745: ldc_w 399
    //   748: invokevirtual 403	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   751: ifeq +1425 -> 2176
    //   754: aload_1
    //   755: iconst_0
    //   756: aload_1
    //   757: invokevirtual 377	java/lang/String:length	()I
    //   760: iconst_3
    //   761: isub
    //   762: invokevirtual 406	java/lang/String:substring	(II)Ljava/lang/String;
    //   765: astore_1
    //   766: ldc_w 408
    //   769: iconst_1
    //   770: anewarray 4	java/lang/Object
    //   773: dup
    //   774: iconst_0
    //   775: aload 7
    //   777: aastore
    //   778: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   781: aconst_null
    //   782: astore 23
    //   784: aconst_null
    //   785: astore 20
    //   787: aconst_null
    //   788: astore 22
    //   790: new 337	java/util/ArrayList
    //   793: dup
    //   794: invokespecial 338	java/util/ArrayList:<init>	()V
    //   797: astore 24
    //   799: new 68	com/tencent/feedback/proguard/n
    //   802: dup
    //   803: aload_0
    //   804: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   807: astore 21
    //   809: aload 21
    //   811: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   814: astore_0
    //   815: lload 18
    //   817: lconst_0
    //   818: lcmp
    //   819: ifle +1091 -> 1910
    //   822: aload_1
    //   823: astore 20
    //   825: aload_1
    //   826: invokevirtual 377	java/lang/String:length	()I
    //   829: ifle +25 -> 854
    //   832: new 97	java/lang/StringBuilder
    //   835: dup
    //   836: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   839: aload_1
    //   840: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: ldc_w 399
    //   846: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   852: astore 20
    //   854: new 97	java/lang/StringBuilder
    //   857: dup
    //   858: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   861: aload 20
    //   863: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: ldc_w 410
    //   869: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   875: astore 23
    //   877: iload 6
    //   879: iflt +389 -> 1268
    //   882: new 97	java/lang/StringBuilder
    //   885: dup
    //   886: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   889: iload 6
    //   891: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   894: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   897: astore_1
    //   898: aload_0
    //   899: ldc 175
    //   901: iconst_2
    //   902: anewarray 163	java/lang/String
    //   905: dup
    //   906: iconst_0
    //   907: ldc_w 261
    //   910: aastore
    //   911: dup
    //   912: iconst_1
    //   913: ldc_w 284
    //   916: aastore
    //   917: aload 7
    //   919: aconst_null
    //   920: aconst_null
    //   921: aconst_null
    //   922: aload 23
    //   924: aload_1
    //   925: invokevirtual 335	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   928: astore 20
    //   930: aload 20
    //   932: astore 7
    //   934: aload 20
    //   936: astore_1
    //   937: aload 20
    //   939: ldc_w 261
    //   942: invokeinterface 207 2 0
    //   947: istore_2
    //   948: aload 20
    //   950: astore 7
    //   952: aload 20
    //   954: astore_1
    //   955: aload 20
    //   957: ldc_w 284
    //   960: invokeinterface 207 2 0
    //   965: istore_3
    //   966: aload 20
    //   968: astore 7
    //   970: aload 20
    //   972: astore_1
    //   973: new 412	java/util/LinkedHashMap
    //   976: dup
    //   977: invokespecial 413	java/util/LinkedHashMap:<init>	()V
    //   980: astore 22
    //   982: aload 20
    //   984: astore 7
    //   986: aload 20
    //   988: astore_1
    //   989: aload 20
    //   991: invokeinterface 201 1 0
    //   996: ifeq +277 -> 1273
    //   999: aload 20
    //   1001: astore 7
    //   1003: aload 20
    //   1005: astore_1
    //   1006: aload 22
    //   1008: aload 20
    //   1010: iload_2
    //   1011: invokeinterface 417 2 0
    //   1016: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1019: aload 20
    //   1021: iload_3
    //   1022: invokeinterface 417 2 0
    //   1027: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1030: invokevirtual 420	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1033: pop
    //   1034: goto -52 -> 982
    //   1037: astore_1
    //   1038: aload_0
    //   1039: astore 20
    //   1041: aload 21
    //   1043: astore_0
    //   1044: aload_1
    //   1045: invokevirtual 127	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1048: iconst_0
    //   1049: anewarray 4	java/lang/Object
    //   1052: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1055: aload 7
    //   1057: ifnull +20 -> 1077
    //   1060: aload 7
    //   1062: invokeinterface 216 1 0
    //   1067: ifne +10 -> 1077
    //   1070: aload 7
    //   1072: invokeinterface 217 1 0
    //   1077: aload 20
    //   1079: ifnull +16 -> 1095
    //   1082: aload 20
    //   1084: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   1087: ifeq +8 -> 1095
    //   1090: aload 20
    //   1092: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   1095: aload_0
    //   1096: ifnull +7 -> 1103
    //   1099: aload_0
    //   1100: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   1103: ldc_w 422
    //   1106: iconst_0
    //   1107: anewarray 4	java/lang/Object
    //   1110: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1113: aconst_null
    //   1114: areturn
    //   1115: ldc 159
    //   1117: astore 20
    //   1119: goto -913 -> 206
    //   1122: ldc 159
    //   1124: astore_1
    //   1125: goto -885 -> 240
    //   1128: ldc 159
    //   1130: astore_1
    //   1131: goto -832 -> 299
    //   1134: ldc 159
    //   1136: astore_1
    //   1137: goto -776 -> 361
    //   1140: ldc 159
    //   1142: astore_1
    //   1143: goto -723 -> 420
    //   1146: ldc 159
    //   1148: astore_1
    //   1149: goto -667 -> 482
    //   1152: ldc 159
    //   1154: astore_1
    //   1155: goto -612 -> 543
    //   1158: ldc 159
    //   1160: astore_1
    //   1161: goto -555 -> 606
    //   1164: ldc 159
    //   1166: astore_1
    //   1167: goto -502 -> 665
    //   1170: new 97	java/lang/StringBuilder
    //   1173: dup
    //   1174: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1177: ldc 159
    //   1179: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1182: ldc_w 424
    //   1185: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1188: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1191: astore_1
    //   1192: goto -472 -> 720
    //   1195: new 97	java/lang/StringBuilder
    //   1198: dup
    //   1199: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1202: ldc 159
    //   1204: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1207: ldc_w 426
    //   1210: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1213: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1216: astore_1
    //   1217: goto -497 -> 720
    //   1220: new 97	java/lang/StringBuilder
    //   1223: dup
    //   1224: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1227: aload_1
    //   1228: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: ldc_w 428
    //   1234: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1237: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1240: astore_1
    //   1241: goto -497 -> 744
    //   1244: new 97	java/lang/StringBuilder
    //   1247: dup
    //   1248: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1251: aload_1
    //   1252: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1255: ldc_w 430
    //   1258: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1261: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1264: astore_1
    //   1265: goto -521 -> 744
    //   1268: aconst_null
    //   1269: astore_1
    //   1270: goto -372 -> 898
    //   1273: aload 20
    //   1275: astore 7
    //   1277: aload 20
    //   1279: astore_1
    //   1280: aload 20
    //   1282: invokeinterface 217 1 0
    //   1287: aload 20
    //   1289: astore 7
    //   1291: aload 20
    //   1293: astore_1
    //   1294: aload 22
    //   1296: lload 18
    //   1298: invokestatic 435	com/tencent/feedback/proguard/a:a	(Ljava/util/LinkedHashMap;J)[Ljava/lang/Long;
    //   1301: astore 22
    //   1303: aload 22
    //   1305: ifnull +551 -> 1856
    //   1308: aload 20
    //   1310: astore 7
    //   1312: aload 20
    //   1314: astore_1
    //   1315: aload 22
    //   1317: arraylength
    //   1318: ifle +538 -> 1856
    //   1321: aload 20
    //   1323: astore 7
    //   1325: aload 20
    //   1327: astore_1
    //   1328: new 97	java/lang/StringBuilder
    //   1331: dup
    //   1332: ldc_w 437
    //   1335: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1338: aload 22
    //   1340: arraylength
    //   1341: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1344: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1347: iconst_0
    //   1348: anewarray 4	java/lang/Object
    //   1351: invokestatic 140	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1354: aload 20
    //   1356: astore 7
    //   1358: aload 20
    //   1360: astore_1
    //   1361: new 226	java/lang/StringBuffer
    //   1364: dup
    //   1365: invokespecial 227	java/lang/StringBuffer:<init>	()V
    //   1368: astore 25
    //   1370: iconst_0
    //   1371: istore_2
    //   1372: aload 20
    //   1374: astore 7
    //   1376: aload 20
    //   1378: astore_1
    //   1379: iload_2
    //   1380: aload 22
    //   1382: arraylength
    //   1383: if_icmpge +215 -> 1598
    //   1386: aload 20
    //   1388: astore 7
    //   1390: aload 20
    //   1392: astore_1
    //   1393: aload 22
    //   1395: iload_2
    //   1396: aaload
    //   1397: invokevirtual 233	java/lang/Long:longValue	()J
    //   1400: lstore 4
    //   1402: aload 20
    //   1404: astore 7
    //   1406: aload 20
    //   1408: astore_1
    //   1409: aload 25
    //   1411: new 97	java/lang/StringBuilder
    //   1414: dup
    //   1415: ldc 235
    //   1417: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1420: lload 4
    //   1422: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1425: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1428: invokevirtual 238	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1431: pop
    //   1432: iload_2
    //   1433: ifle +737 -> 2170
    //   1436: iload_2
    //   1437: bipush 50
    //   1439: irem
    //   1440: ifne +730 -> 2170
    //   1443: aload 20
    //   1445: astore 7
    //   1447: aload 20
    //   1449: astore_1
    //   1450: new 97	java/lang/StringBuilder
    //   1453: dup
    //   1454: ldc 240
    //   1456: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1459: iload_2
    //   1460: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1463: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1466: iconst_0
    //   1467: anewarray 4	java/lang/Object
    //   1470: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1473: aload 20
    //   1475: astore 7
    //   1477: aload 20
    //   1479: astore_1
    //   1480: aload 25
    //   1482: iconst_4
    //   1483: invokevirtual 241	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   1486: astore 26
    //   1488: aload 20
    //   1490: astore 7
    //   1492: aload 20
    //   1494: astore_1
    //   1495: aload 25
    //   1497: iconst_0
    //   1498: invokevirtual 245	java/lang/StringBuffer:setLength	(I)V
    //   1501: aload 20
    //   1503: astore 7
    //   1505: aload 20
    //   1507: astore_1
    //   1508: aload_0
    //   1509: ldc 175
    //   1511: aconst_null
    //   1512: aload 26
    //   1514: aconst_null
    //   1515: aconst_null
    //   1516: aconst_null
    //   1517: aload 23
    //   1519: invokevirtual 196	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1522: astore 20
    //   1524: aload 20
    //   1526: astore_1
    //   1527: aload_1
    //   1528: invokestatic 440	com/tencent/feedback/proguard/l:a	(Landroid/database/Cursor;)Ljava/util/List;
    //   1531: astore 7
    //   1533: aload 7
    //   1535: ifnull +47 -> 1582
    //   1538: aload 7
    //   1540: invokeinterface 363 1 0
    //   1545: ifle +37 -> 1582
    //   1548: aload 24
    //   1550: aload 7
    //   1552: invokeinterface 444 2 0
    //   1557: pop
    //   1558: new 97	java/lang/StringBuilder
    //   1561: dup
    //   1562: ldc_w 446
    //   1565: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1568: iconst_0
    //   1569: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1572: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1575: iconst_0
    //   1576: anewarray 4	java/lang/Object
    //   1579: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1582: aload_1
    //   1583: invokeinterface 217 1 0
    //   1588: iload_2
    //   1589: iconst_1
    //   1590: iadd
    //   1591: istore_2
    //   1592: aload_1
    //   1593: astore 20
    //   1595: goto -223 -> 1372
    //   1598: aload 20
    //   1600: astore 7
    //   1602: aload 20
    //   1604: astore 22
    //   1606: aload 20
    //   1608: astore_1
    //   1609: aload 25
    //   1611: invokevirtual 251	java/lang/StringBuffer:length	()I
    //   1614: ifle +150 -> 1764
    //   1617: aload 20
    //   1619: astore 7
    //   1621: aload 20
    //   1623: astore_1
    //   1624: aload 25
    //   1626: iconst_4
    //   1627: invokevirtual 241	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   1630: astore 22
    //   1632: aload 20
    //   1634: astore 7
    //   1636: aload 20
    //   1638: astore_1
    //   1639: aload 25
    //   1641: iconst_0
    //   1642: invokevirtual 245	java/lang/StringBuffer:setLength	(I)V
    //   1645: aload 20
    //   1647: astore 7
    //   1649: aload 20
    //   1651: astore_1
    //   1652: aload_0
    //   1653: ldc 175
    //   1655: aconst_null
    //   1656: aload 22
    //   1658: aconst_null
    //   1659: aconst_null
    //   1660: aconst_null
    //   1661: aload 23
    //   1663: invokevirtual 196	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1666: astore 20
    //   1668: aload 20
    //   1670: astore 7
    //   1672: aload 20
    //   1674: astore_1
    //   1675: aload 20
    //   1677: invokestatic 440	com/tencent/feedback/proguard/l:a	(Landroid/database/Cursor;)Ljava/util/List;
    //   1680: astore 23
    //   1682: aload 20
    //   1684: astore 22
    //   1686: aload 23
    //   1688: ifnull +76 -> 1764
    //   1691: aload 20
    //   1693: astore 7
    //   1695: aload 20
    //   1697: astore 22
    //   1699: aload 20
    //   1701: astore_1
    //   1702: aload 23
    //   1704: invokeinterface 363 1 0
    //   1709: ifle +55 -> 1764
    //   1712: aload 20
    //   1714: astore 7
    //   1716: aload 20
    //   1718: astore_1
    //   1719: aload 24
    //   1721: aload 23
    //   1723: invokeinterface 444 2 0
    //   1728: pop
    //   1729: aload 20
    //   1731: astore 7
    //   1733: aload 20
    //   1735: astore_1
    //   1736: new 97	java/lang/StringBuilder
    //   1739: dup
    //   1740: ldc_w 446
    //   1743: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1746: iconst_0
    //   1747: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1750: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1753: iconst_0
    //   1754: anewarray 4	java/lang/Object
    //   1757: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1760: aload 20
    //   1762: astore 22
    //   1764: aload 22
    //   1766: astore 7
    //   1768: aload 22
    //   1770: astore_1
    //   1771: new 97	java/lang/StringBuilder
    //   1774: dup
    //   1775: ldc_w 448
    //   1778: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1781: aload 24
    //   1783: invokeinterface 363 1 0
    //   1788: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1791: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1794: iconst_0
    //   1795: anewarray 4	java/lang/Object
    //   1798: invokestatic 140	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1801: aload 22
    //   1803: ifnull +20 -> 1823
    //   1806: aload 22
    //   1808: invokeinterface 216 1 0
    //   1813: ifne +10 -> 1823
    //   1816: aload 22
    //   1818: invokeinterface 217 1 0
    //   1823: aload_0
    //   1824: ifnull +14 -> 1838
    //   1827: aload_0
    //   1828: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   1831: ifeq +7 -> 1838
    //   1834: aload_0
    //   1835: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   1838: aload 21
    //   1840: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   1843: ldc_w 422
    //   1846: iconst_0
    //   1847: anewarray 4	java/lang/Object
    //   1850: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1853: aload 24
    //   1855: areturn
    //   1856: aload 20
    //   1858: ifnull +20 -> 1878
    //   1861: aload 20
    //   1863: invokeinterface 216 1 0
    //   1868: ifne +10 -> 1878
    //   1871: aload 20
    //   1873: invokeinterface 217 1 0
    //   1878: aload_0
    //   1879: ifnull +14 -> 1893
    //   1882: aload_0
    //   1883: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   1886: ifeq +7 -> 1893
    //   1889: aload_0
    //   1890: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   1893: aload 21
    //   1895: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   1898: ldc_w 422
    //   1901: iconst_0
    //   1902: anewarray 4	java/lang/Object
    //   1905: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1908: aconst_null
    //   1909: areturn
    //   1910: aload_0
    //   1911: ldc 175
    //   1913: aconst_null
    //   1914: aload 7
    //   1916: aconst_null
    //   1917: aconst_null
    //   1918: aconst_null
    //   1919: aload_1
    //   1920: invokevirtual 196	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1923: astore 20
    //   1925: aload 20
    //   1927: astore 7
    //   1929: aload 20
    //   1931: astore_1
    //   1932: aload 20
    //   1934: invokestatic 440	com/tencent/feedback/proguard/l:a	(Landroid/database/Cursor;)Ljava/util/List;
    //   1937: astore 22
    //   1939: aload 20
    //   1941: ifnull +20 -> 1961
    //   1944: aload 20
    //   1946: invokeinterface 216 1 0
    //   1951: ifne +10 -> 1961
    //   1954: aload 20
    //   1956: invokeinterface 217 1 0
    //   1961: aload_0
    //   1962: ifnull +14 -> 1976
    //   1965: aload_0
    //   1966: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   1969: ifeq +7 -> 1976
    //   1972: aload_0
    //   1973: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   1976: aload 21
    //   1978: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   1981: ldc_w 422
    //   1984: iconst_0
    //   1985: anewarray 4	java/lang/Object
    //   1988: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1991: aload 22
    //   1993: areturn
    //   1994: astore_0
    //   1995: aconst_null
    //   1996: astore 21
    //   1998: aconst_null
    //   1999: astore_1
    //   2000: aload_1
    //   2001: ifnull +18 -> 2019
    //   2004: aload_1
    //   2005: invokeinterface 216 1 0
    //   2010: ifne +9 -> 2019
    //   2013: aload_1
    //   2014: invokeinterface 217 1 0
    //   2019: aload 20
    //   2021: ifnull +16 -> 2037
    //   2024: aload 20
    //   2026: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   2029: ifeq +8 -> 2037
    //   2032: aload 20
    //   2034: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   2037: aload 21
    //   2039: ifnull +8 -> 2047
    //   2042: aload 21
    //   2044: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   2047: ldc_w 422
    //   2050: iconst_0
    //   2051: anewarray 4	java/lang/Object
    //   2054: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   2057: aload_0
    //   2058: athrow
    //   2059: astore_0
    //   2060: aconst_null
    //   2061: astore_1
    //   2062: goto -62 -> 2000
    //   2065: astore 7
    //   2067: aconst_null
    //   2068: astore_1
    //   2069: aload_0
    //   2070: astore 20
    //   2072: aload 7
    //   2074: astore_0
    //   2075: goto -75 -> 2000
    //   2078: astore 7
    //   2080: aload_0
    //   2081: astore 20
    //   2083: aload 7
    //   2085: astore_0
    //   2086: goto -86 -> 2000
    //   2089: astore 7
    //   2091: aload_0
    //   2092: astore 20
    //   2094: aload 7
    //   2096: astore_0
    //   2097: goto -97 -> 2000
    //   2100: astore_1
    //   2101: aload_0
    //   2102: astore 21
    //   2104: aload_1
    //   2105: astore_0
    //   2106: aload 7
    //   2108: astore_1
    //   2109: goto -109 -> 2000
    //   2112: astore_1
    //   2113: aconst_null
    //   2114: astore 7
    //   2116: aload 23
    //   2118: astore_0
    //   2119: aload 22
    //   2121: astore 20
    //   2123: goto -1079 -> 1044
    //   2126: astore_1
    //   2127: aload 21
    //   2129: astore_0
    //   2130: aconst_null
    //   2131: astore 7
    //   2133: aload 22
    //   2135: astore 20
    //   2137: goto -1093 -> 1044
    //   2140: astore_1
    //   2141: aconst_null
    //   2142: astore 7
    //   2144: aload_0
    //   2145: astore 20
    //   2147: aload 21
    //   2149: astore_0
    //   2150: goto -1106 -> 1044
    //   2153: astore 22
    //   2155: aload_1
    //   2156: astore 7
    //   2158: aload_0
    //   2159: astore 20
    //   2161: aload 22
    //   2163: astore_1
    //   2164: aload 21
    //   2166: astore_0
    //   2167: goto -1123 -> 1044
    //   2170: aload 20
    //   2172: astore_1
    //   2173: goto -585 -> 1588
    //   2176: goto -1410 -> 766
    //   2179: ldc 159
    //   2181: astore_1
    //   2182: goto -2008 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2185	0	paramContext	Context
    //   0	2185	1	paramArrayOfInt	int[]
    //   0	2185	2	paramInt1	int
    //   0	2185	3	paramInt2	int
    //   0	2185	4	paramLong1	long
    //   0	2185	6	paramInt3	int
    //   0	2185	7	paramString	String
    //   0	2185	8	paramInt4	int
    //   0	2185	9	paramInt5	int
    //   0	2185	10	paramInt6	int
    //   0	2185	11	paramInt7	int
    //   0	2185	12	paramLong2	long
    //   0	2185	14	paramLong3	long
    //   0	2185	16	paramInt8	int
    //   102	43	17	k	int
    //   74	1223	18	l	long
    //   99	2072	20	localObject1	Object
    //   226	1939	21	localObject2	Object
    //   788	1346	22	localObject3	Object
    //   2153	9	22	localThrowable	Throwable
    //   782	1335	23	localObject4	Object
    //   797	1057	24	localArrayList	ArrayList
    //   1368	272	25	localStringBuffer	java.lang.StringBuffer
    //   1486	27	26	str	String
    // Exception table:
    //   from	to	target	type
    //   937	948	1037	java/lang/Throwable
    //   955	966	1037	java/lang/Throwable
    //   973	982	1037	java/lang/Throwable
    //   989	999	1037	java/lang/Throwable
    //   1006	1034	1037	java/lang/Throwable
    //   1280	1287	1037	java/lang/Throwable
    //   1294	1303	1037	java/lang/Throwable
    //   1315	1321	1037	java/lang/Throwable
    //   1328	1354	1037	java/lang/Throwable
    //   1361	1370	1037	java/lang/Throwable
    //   1379	1386	1037	java/lang/Throwable
    //   1393	1402	1037	java/lang/Throwable
    //   1409	1432	1037	java/lang/Throwable
    //   1450	1473	1037	java/lang/Throwable
    //   1480	1488	1037	java/lang/Throwable
    //   1495	1501	1037	java/lang/Throwable
    //   1508	1524	1037	java/lang/Throwable
    //   1609	1617	1037	java/lang/Throwable
    //   1624	1632	1037	java/lang/Throwable
    //   1639	1645	1037	java/lang/Throwable
    //   1652	1668	1037	java/lang/Throwable
    //   1675	1682	1037	java/lang/Throwable
    //   1702	1712	1037	java/lang/Throwable
    //   1719	1729	1037	java/lang/Throwable
    //   1736	1760	1037	java/lang/Throwable
    //   1771	1801	1037	java/lang/Throwable
    //   1932	1939	1037	java/lang/Throwable
    //   799	809	1994	finally
    //   809	815	2059	finally
    //   825	854	2065	finally
    //   854	877	2065	finally
    //   882	898	2065	finally
    //   898	930	2065	finally
    //   1910	1925	2065	finally
    //   937	948	2078	finally
    //   955	966	2078	finally
    //   973	982	2078	finally
    //   989	999	2078	finally
    //   1006	1034	2078	finally
    //   1280	1287	2078	finally
    //   1294	1303	2078	finally
    //   1315	1321	2078	finally
    //   1328	1354	2078	finally
    //   1361	1370	2078	finally
    //   1379	1386	2078	finally
    //   1393	1402	2078	finally
    //   1409	1432	2078	finally
    //   1450	1473	2078	finally
    //   1480	1488	2078	finally
    //   1495	1501	2078	finally
    //   1508	1524	2078	finally
    //   1609	1617	2078	finally
    //   1624	1632	2078	finally
    //   1639	1645	2078	finally
    //   1652	1668	2078	finally
    //   1675	1682	2078	finally
    //   1702	1712	2078	finally
    //   1719	1729	2078	finally
    //   1736	1760	2078	finally
    //   1771	1801	2078	finally
    //   1932	1939	2078	finally
    //   1527	1533	2089	finally
    //   1538	1582	2089	finally
    //   1582	1588	2089	finally
    //   1044	1055	2100	finally
    //   799	809	2112	java/lang/Throwable
    //   809	815	2126	java/lang/Throwable
    //   825	854	2140	java/lang/Throwable
    //   854	877	2140	java/lang/Throwable
    //   882	898	2140	java/lang/Throwable
    //   898	930	2140	java/lang/Throwable
    //   1910	1925	2140	java/lang/Throwable
    //   1527	1533	2153	java/lang/Throwable
    //   1538	1582	2153	java/lang/Throwable
    //   1582	1588	2153	java/lang/Throwable
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
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc_w 472
    //   6: iconst_0
    //   7: anewarray 4	java/lang/Object
    //   10: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   13: aload_0
    //   14: ifnull +7 -> 21
    //   17: aload_1
    //   18: ifnonnull +15 -> 33
    //   21: ldc_w 474
    //   24: iconst_0
    //   25: anewarray 4	java/lang/Object
    //   28: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: iconst_0
    //   32: ireturn
    //   33: aload_1
    //   34: invokeinterface 363 1 0
    //   39: ifgt +15 -> 54
    //   42: ldc_w 476
    //   45: iconst_0
    //   46: anewarray 4	java/lang/Object
    //   49: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: iconst_1
    //   53: ireturn
    //   54: new 68	com/tencent/feedback/proguard/n
    //   57: dup
    //   58: aload_0
    //   59: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   62: astore 5
    //   64: aload 5
    //   66: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   69: astore_0
    //   70: aload_0
    //   71: astore 6
    //   73: iconst_0
    //   74: istore_2
    //   75: iload_2
    //   76: aload_1
    //   77: invokeinterface 363 1 0
    //   82: if_icmpge +92 -> 174
    //   85: aload_1
    //   86: iload_2
    //   87: invokeinterface 480 2 0
    //   92: checkcast 2	com/tencent/feedback/proguard/l
    //   95: astore_0
    //   96: aload 6
    //   98: ldc 175
    //   100: ldc_w 261
    //   103: aload_0
    //   104: invokestatic 482	com/tencent/feedback/proguard/l:a	(Lcom/tencent/feedback/proguard/l;)Landroid/content/ContentValues;
    //   107: invokevirtual 486	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   110: lstore_3
    //   111: lload_3
    //   112: lconst_0
    //   113: lcmp
    //   114: ifge +48 -> 162
    //   117: ldc_w 488
    //   120: iconst_0
    //   121: anewarray 4	java/lang/Object
    //   124: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: aload 6
    //   129: ifnull +16 -> 145
    //   132: aload 6
    //   134: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   137: ifeq +8 -> 145
    //   140: aload 6
    //   142: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   145: aload 5
    //   147: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   150: ldc_w 490
    //   153: iconst_0
    //   154: anewarray 4	java/lang/Object
    //   157: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   160: iconst_0
    //   161: ireturn
    //   162: aload_0
    //   163: lload_3
    //   164: putfield 26	com/tencent/feedback/proguard/l:a	J
    //   167: iload_2
    //   168: iconst_1
    //   169: iadd
    //   170: istore_2
    //   171: goto -96 -> 75
    //   174: aload 6
    //   176: ifnull +16 -> 192
    //   179: aload 6
    //   181: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   184: ifeq +8 -> 192
    //   187: aload 6
    //   189: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   192: aload 5
    //   194: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   197: ldc_w 490
    //   200: iconst_0
    //   201: anewarray 4	java/lang/Object
    //   204: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   207: iconst_1
    //   208: ireturn
    //   209: astore_0
    //   210: aconst_null
    //   211: astore_0
    //   212: aload 6
    //   214: astore_1
    //   215: ldc_w 492
    //   218: iconst_0
    //   219: anewarray 4	java/lang/Object
    //   222: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: aload_1
    //   226: ifnull +14 -> 240
    //   229: aload_1
    //   230: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   233: ifeq +7 -> 240
    //   236: aload_1
    //   237: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   240: aload_0
    //   241: ifnull +7 -> 248
    //   244: aload_0
    //   245: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   248: ldc_w 490
    //   251: iconst_0
    //   252: anewarray 4	java/lang/Object
    //   255: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   258: iconst_0
    //   259: ireturn
    //   260: astore_0
    //   261: aconst_null
    //   262: astore_1
    //   263: aconst_null
    //   264: astore 5
    //   266: aload_1
    //   267: ifnull +14 -> 281
    //   270: aload_1
    //   271: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   274: ifeq +7 -> 281
    //   277: aload_1
    //   278: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   281: aload 5
    //   283: ifnull +8 -> 291
    //   286: aload 5
    //   288: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   291: ldc_w 490
    //   294: iconst_0
    //   295: anewarray 4	java/lang/Object
    //   298: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   301: aload_0
    //   302: athrow
    //   303: astore_0
    //   304: aconst_null
    //   305: astore_1
    //   306: goto -40 -> 266
    //   309: astore_0
    //   310: aload 6
    //   312: astore_1
    //   313: goto -47 -> 266
    //   316: astore 6
    //   318: aload_0
    //   319: astore 5
    //   321: aload 6
    //   323: astore_0
    //   324: goto -58 -> 266
    //   327: astore_0
    //   328: aload 5
    //   330: astore_0
    //   331: aload 6
    //   333: astore_1
    //   334: goto -119 -> 215
    //   337: astore_0
    //   338: aload 6
    //   340: astore_1
    //   341: aload 5
    //   343: astore_0
    //   344: goto -129 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	paramContext	Context
    //   0	347	1	paramList	List<l>
    //   74	97	2	k	int
    //   110	54	3	l	long
    //   62	280	5	localObject1	Object
    //   1	310	6	localContext	Context
    //   316	23	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   54	64	209	java/lang/Throwable
    //   54	64	260	finally
    //   64	70	303	finally
    //   75	111	309	finally
    //   117	127	309	finally
    //   162	167	309	finally
    //   215	225	316	finally
    //   64	70	327	java/lang/Throwable
    //   75	111	337	java/lang/Throwable
    //   117	127	337	java/lang/Throwable
    //   162	167	337	java/lang/Throwable
  }
  
  protected static o b(Cursor paramCursor)
  {
    if ((paramCursor == null) || (paramCursor.isBeforeFirst()) || (paramCursor.isAfterLast())) {
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
      paramCursor.printStackTrace();
      e.d("rqdp{  Error:getFileBean fail!}", new Object[0]);
      e.g("rqdp{  Error: getFileBean fail!}", new Object[0]);
    }
    return null;
  }
  
  /* Error */
  public static boolean b(Context paramContext, List<l> paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 8
    //   12: ldc_w 529
    //   15: iconst_0
    //   16: anewarray 4	java/lang/Object
    //   19: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: aload_0
    //   23: ifnull +16 -> 39
    //   26: aload_1
    //   27: ifnull +12 -> 39
    //   30: aload_1
    //   31: invokeinterface 363 1 0
    //   36: ifgt +15 -> 51
    //   39: ldc_w 531
    //   42: iconst_0
    //   43: anewarray 4	java/lang/Object
    //   46: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   49: iconst_0
    //   50: ireturn
    //   51: new 68	com/tencent/feedback/proguard/n
    //   54: dup
    //   55: aload_0
    //   56: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   59: astore 6
    //   61: aload 8
    //   63: astore 5
    //   65: aload 4
    //   67: astore_0
    //   68: aload 6
    //   70: astore 4
    //   72: aload 6
    //   74: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   77: astore 7
    //   79: aload 7
    //   81: astore 5
    //   83: aload 7
    //   85: astore_0
    //   86: aload 6
    //   88: astore 4
    //   90: aload_1
    //   91: invokeinterface 535 1 0
    //   96: astore_1
    //   97: aload 7
    //   99: astore 5
    //   101: aload 7
    //   103: astore_0
    //   104: aload 6
    //   106: astore 4
    //   108: aload_1
    //   109: invokeinterface 540 1 0
    //   114: ifeq +280 -> 394
    //   117: aload 7
    //   119: astore 5
    //   121: aload 7
    //   123: astore_0
    //   124: aload 6
    //   126: astore 4
    //   128: aload_1
    //   129: invokeinterface 544 1 0
    //   134: checkcast 2	com/tencent/feedback/proguard/l
    //   137: astore 8
    //   139: aload 7
    //   141: astore 5
    //   143: aload 7
    //   145: astore_0
    //   146: aload 6
    //   148: astore 4
    //   150: aload 8
    //   152: invokestatic 482	com/tencent/feedback/proguard/l:a	(Lcom/tencent/feedback/proguard/l;)Landroid/content/ContentValues;
    //   155: astore 9
    //   157: aload 9
    //   159: ifnonnull +38 -> 197
    //   162: aload 7
    //   164: ifnull +16 -> 180
    //   167: aload 7
    //   169: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   172: ifeq +8 -> 180
    //   175: aload 7
    //   177: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   180: aload 6
    //   182: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   185: ldc_w 546
    //   188: iconst_0
    //   189: anewarray 4	java/lang/Object
    //   192: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: iconst_0
    //   196: ireturn
    //   197: aload 7
    //   199: astore 5
    //   201: aload 7
    //   203: astore_0
    //   204: aload 6
    //   206: astore 4
    //   208: aload 7
    //   210: ldc 175
    //   212: ldc_w 261
    //   215: aload 9
    //   217: invokevirtual 549	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   220: lstore_2
    //   221: lload_2
    //   222: lconst_0
    //   223: lcmp
    //   224: ifge +59 -> 283
    //   227: aload 7
    //   229: astore 5
    //   231: aload 7
    //   233: astore_0
    //   234: aload 6
    //   236: astore 4
    //   238: ldc_w 551
    //   241: iconst_0
    //   242: anewarray 4	java/lang/Object
    //   245: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   248: aload 7
    //   250: ifnull +16 -> 266
    //   253: aload 7
    //   255: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   258: ifeq +8 -> 266
    //   261: aload 7
    //   263: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   266: aload 6
    //   268: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   271: ldc_w 546
    //   274: iconst_0
    //   275: anewarray 4	java/lang/Object
    //   278: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   281: iconst_0
    //   282: ireturn
    //   283: aload 7
    //   285: astore 5
    //   287: aload 7
    //   289: astore_0
    //   290: aload 6
    //   292: astore 4
    //   294: new 97	java/lang/StringBuilder
    //   297: dup
    //   298: ldc_w 553
    //   301: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   304: lload_2
    //   305: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   308: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: iconst_0
    //   312: anewarray 4	java/lang/Object
    //   315: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   318: aload 7
    //   320: astore 5
    //   322: aload 7
    //   324: astore_0
    //   325: aload 6
    //   327: astore 4
    //   329: aload 8
    //   331: lload_2
    //   332: putfield 26	com/tencent/feedback/proguard/l:a	J
    //   335: goto -238 -> 97
    //   338: astore_0
    //   339: aload 6
    //   341: astore_1
    //   342: aload_0
    //   343: astore 6
    //   345: aload 5
    //   347: astore_0
    //   348: aload_1
    //   349: astore 4
    //   351: aload 6
    //   353: invokevirtual 130	java/lang/Throwable:printStackTrace	()V
    //   356: aload 5
    //   358: ifnull +16 -> 374
    //   361: aload 5
    //   363: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   366: ifeq +8 -> 374
    //   369: aload 5
    //   371: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   374: aload_1
    //   375: ifnull +7 -> 382
    //   378: aload_1
    //   379: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   382: ldc_w 546
    //   385: iconst_0
    //   386: anewarray 4	java/lang/Object
    //   389: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   392: iconst_0
    //   393: ireturn
    //   394: aload 7
    //   396: ifnull +16 -> 412
    //   399: aload 7
    //   401: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   404: ifeq +8 -> 412
    //   407: aload 7
    //   409: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   412: aload 6
    //   414: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   417: ldc_w 546
    //   420: iconst_0
    //   421: anewarray 4	java/lang/Object
    //   424: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   427: iconst_1
    //   428: ireturn
    //   429: astore_1
    //   430: aconst_null
    //   431: astore 4
    //   433: aload 7
    //   435: astore_0
    //   436: aload_0
    //   437: ifnull +14 -> 451
    //   440: aload_0
    //   441: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   444: ifeq +7 -> 451
    //   447: aload_0
    //   448: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   451: aload 4
    //   453: ifnull +8 -> 461
    //   456: aload 4
    //   458: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   461: ldc_w 546
    //   464: iconst_0
    //   465: anewarray 4	java/lang/Object
    //   468: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   471: aload_1
    //   472: athrow
    //   473: astore_1
    //   474: goto -38 -> 436
    //   477: astore 6
    //   479: aconst_null
    //   480: astore_1
    //   481: goto -136 -> 345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	484	0	paramContext	Context
    //   0	484	1	paramList	List<l>
    //   220	112	2	l	long
    //   7	450	4	localObject1	Object
    //   1	369	5	localObject2	Object
    //   59	354	6	localObject3	Object
    //   477	1	6	localThrowable	Throwable
    //   4	430	7	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   10	320	8	locall	l
    //   155	61	9	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   72	79	338	java/lang/Throwable
    //   90	97	338	java/lang/Throwable
    //   108	117	338	java/lang/Throwable
    //   128	139	338	java/lang/Throwable
    //   150	157	338	java/lang/Throwable
    //   208	221	338	java/lang/Throwable
    //   238	248	338	java/lang/Throwable
    //   294	318	338	java/lang/Throwable
    //   329	335	338	java/lang/Throwable
    //   51	61	429	finally
    //   72	79	473	finally
    //   90	97	473	finally
    //   108	117	473	finally
    //   128	139	473	finally
    //   150	157	473	finally
    //   208	221	473	finally
    //   238	248	473	finally
    //   294	318	473	finally
    //   329	335	473	finally
    //   351	356	473	finally
    //   51	61	477	java/lang/Throwable
  }
  
  /* Error */
  public static int c(Context paramContext, List<o> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +16 -> 17
    //   4: aload_1
    //   5: ifnull +12 -> 17
    //   8: aload_1
    //   9: invokeinterface 363 1 0
    //   14: ifne +50 -> 64
    //   17: aload_1
    //   18: ifnonnull +23 -> 41
    //   21: ldc_w 556
    //   24: astore_0
    //   25: ldc_w 558
    //   28: iconst_1
    //   29: anewarray 4	java/lang/Object
    //   32: dup
    //   33: iconst_0
    //   34: aload_0
    //   35: aastore
    //   36: invokestatic 56	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   39: iconst_m1
    //   40: ireturn
    //   41: new 97	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   48: aload_1
    //   49: invokeinterface 363 1 0
    //   54: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: astore_0
    //   61: goto -36 -> 25
    //   64: ldc_w 560
    //   67: iconst_1
    //   68: anewarray 4	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: aload_1
    //   74: invokeinterface 363 1 0
    //   79: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   82: aastore
    //   83: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   86: aconst_null
    //   87: astore 11
    //   89: aconst_null
    //   90: astore 13
    //   92: aconst_null
    //   93: astore 10
    //   95: aconst_null
    //   96: astore 14
    //   98: iconst_0
    //   99: istore 5
    //   101: iconst_0
    //   102: istore 4
    //   104: iconst_0
    //   105: istore_2
    //   106: iconst_0
    //   107: istore 6
    //   109: iconst_0
    //   110: istore_3
    //   111: new 68	com/tencent/feedback/proguard/n
    //   114: dup
    //   115: aload_0
    //   116: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   119: astore 12
    //   121: iload 5
    //   123: istore 4
    //   125: aload 14
    //   127: astore 11
    //   129: iload 6
    //   131: istore_2
    //   132: aload 10
    //   134: astore_0
    //   135: aload 12
    //   137: astore 10
    //   139: aload 12
    //   141: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   144: astore 13
    //   146: aload 13
    //   148: ifnonnull +101 -> 249
    //   151: iload 5
    //   153: istore 4
    //   155: aload 13
    //   157: astore 11
    //   159: iload 6
    //   161: istore_2
    //   162: aload 13
    //   164: astore_0
    //   165: aload 12
    //   167: astore 10
    //   169: ldc_w 310
    //   172: iconst_0
    //   173: anewarray 4	java/lang/Object
    //   176: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   179: iload 5
    //   181: istore 4
    //   183: aload 13
    //   185: astore 11
    //   187: iload 6
    //   189: istore_2
    //   190: aload 13
    //   192: astore_0
    //   193: aload 12
    //   195: astore 10
    //   197: ldc_w 562
    //   200: iconst_0
    //   201: anewarray 4	java/lang/Object
    //   204: invokestatic 83	com/tencent/feedback/common/e:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   207: aload 13
    //   209: ifnull +16 -> 225
    //   212: aload 13
    //   214: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   217: ifeq +8 -> 225
    //   220: aload 13
    //   222: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   225: aload 12
    //   227: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   230: ldc_w 564
    //   233: iconst_1
    //   234: anewarray 4	java/lang/Object
    //   237: dup
    //   238: iconst_0
    //   239: iconst_0
    //   240: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   243: aastore
    //   244: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: iconst_m1
    //   248: ireturn
    //   249: iload 5
    //   251: istore 4
    //   253: aload 13
    //   255: astore 11
    //   257: iload 6
    //   259: istore_2
    //   260: aload 13
    //   262: astore_0
    //   263: aload 12
    //   265: astore 10
    //   267: aload_1
    //   268: invokeinterface 535 1 0
    //   273: astore 14
    //   275: iload_3
    //   276: istore 4
    //   278: aload 13
    //   280: astore 11
    //   282: iload_3
    //   283: istore_2
    //   284: aload 13
    //   286: astore_0
    //   287: aload 12
    //   289: astore 10
    //   291: aload 14
    //   293: invokeinterface 540 1 0
    //   298: ifeq +512 -> 810
    //   301: iload_3
    //   302: istore 4
    //   304: aload 13
    //   306: astore 11
    //   308: iload_3
    //   309: istore_2
    //   310: aload 13
    //   312: astore_0
    //   313: aload 12
    //   315: astore 10
    //   317: aload 14
    //   319: invokeinterface 544 1 0
    //   324: checkcast 345	com/tencent/feedback/proguard/o
    //   327: astore 15
    //   329: aload 15
    //   331: ifnonnull +151 -> 482
    //   334: aconst_null
    //   335: astore_1
    //   336: iload_3
    //   337: istore_2
    //   338: aload_1
    //   339: ifnull +575 -> 914
    //   342: iload_3
    //   343: istore 4
    //   345: aload 13
    //   347: astore 11
    //   349: iload_3
    //   350: istore_2
    //   351: aload 13
    //   353: astore_0
    //   354: aload 12
    //   356: astore 10
    //   358: aload 13
    //   360: ldc 112
    //   362: ldc_w 261
    //   365: aload_1
    //   366: invokevirtual 486	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   369: lstore 7
    //   371: iload_3
    //   372: istore 4
    //   374: aload 13
    //   376: astore 11
    //   378: iload_3
    //   379: istore_2
    //   380: aload 13
    //   382: astore_0
    //   383: aload 12
    //   385: astore 10
    //   387: aload 15
    //   389: lload 7
    //   391: invokevirtual 509	com/tencent/feedback/proguard/o:a	(J)V
    //   394: lload 7
    //   396: lconst_0
    //   397: lcmp
    //   398: iflt +401 -> 799
    //   401: iconst_1
    //   402: istore_2
    //   403: iload_3
    //   404: iload_2
    //   405: iadd
    //   406: istore_3
    //   407: iload_3
    //   408: istore 4
    //   410: aload 13
    //   412: astore 11
    //   414: iload_3
    //   415: istore_2
    //   416: aload 13
    //   418: astore_0
    //   419: aload 12
    //   421: astore 10
    //   423: aload 15
    //   425: invokevirtual 347	com/tencent/feedback/proguard/o:a	()Ljava/lang/String;
    //   428: astore_1
    //   429: lload 7
    //   431: lconst_0
    //   432: lcmp
    //   433: iflt +371 -> 804
    //   436: iconst_1
    //   437: istore 9
    //   439: iload_3
    //   440: istore 4
    //   442: aload 13
    //   444: astore 11
    //   446: iload_3
    //   447: istore_2
    //   448: aload 13
    //   450: astore_0
    //   451: aload 12
    //   453: astore 10
    //   455: ldc_w 566
    //   458: iconst_2
    //   459: anewarray 4	java/lang/Object
    //   462: dup
    //   463: iconst_0
    //   464: aload_1
    //   465: aastore
    //   466: dup
    //   467: iconst_1
    //   468: iload 9
    //   470: invokestatic 571	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   473: aastore
    //   474: invokestatic 83	com/tencent/feedback/common/e:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   477: iload_3
    //   478: istore_2
    //   479: goto +435 -> 914
    //   482: iload_3
    //   483: istore 4
    //   485: aload 13
    //   487: astore 11
    //   489: iload_3
    //   490: istore_2
    //   491: aload 13
    //   493: astore_0
    //   494: aload 12
    //   496: astore 10
    //   498: new 258	android/content/ContentValues
    //   501: dup
    //   502: invokespecial 259	android/content/ContentValues:<init>	()V
    //   505: astore_1
    //   506: iload_3
    //   507: istore 4
    //   509: aload 13
    //   511: astore 11
    //   513: iload_3
    //   514: istore_2
    //   515: aload 13
    //   517: astore_0
    //   518: aload 12
    //   520: astore 10
    //   522: aload_1
    //   523: ldc_w 320
    //   526: aload 15
    //   528: invokevirtual 347	com/tencent/feedback/proguard/o:a	()Ljava/lang/String;
    //   531: invokevirtual 289	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   534: iload_3
    //   535: istore 4
    //   537: aload 13
    //   539: astore 11
    //   541: iload_3
    //   542: istore_2
    //   543: aload 13
    //   545: astore_0
    //   546: aload 12
    //   548: astore 10
    //   550: aload_1
    //   551: ldc_w 504
    //   554: aload 15
    //   556: invokevirtual 349	com/tencent/feedback/proguard/o:d	()Ljava/lang/String;
    //   559: invokevirtual 289	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   562: iload_3
    //   563: istore 4
    //   565: aload 13
    //   567: astore 11
    //   569: iload_3
    //   570: istore_2
    //   571: aload 13
    //   573: astore_0
    //   574: aload 12
    //   576: astore 10
    //   578: aload_1
    //   579: ldc_w 513
    //   582: aload 15
    //   584: invokevirtual 573	com/tencent/feedback/proguard/o:c	()J
    //   587: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   590: invokevirtual 268	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   593: iload_3
    //   594: istore 4
    //   596: aload 13
    //   598: astore 11
    //   600: iload_3
    //   601: istore_2
    //   602: aload 13
    //   604: astore_0
    //   605: aload 12
    //   607: astore 10
    //   609: aload_1
    //   610: ldc_w 517
    //   613: aload 15
    //   615: invokevirtual 575	com/tencent/feedback/proguard/o:b	()J
    //   618: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   621: invokevirtual 268	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   624: iload_3
    //   625: istore 4
    //   627: aload 13
    //   629: astore 11
    //   631: iload_3
    //   632: istore_2
    //   633: aload 13
    //   635: astore_0
    //   636: aload 12
    //   638: astore 10
    //   640: aload_1
    //   641: ldc_w 326
    //   644: aload 15
    //   646: invokevirtual 350	com/tencent/feedback/proguard/o:e	()I
    //   649: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   652: invokevirtual 273	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   655: iload_3
    //   656: istore 4
    //   658: aload 13
    //   660: astore 11
    //   662: iload_3
    //   663: istore_2
    //   664: aload 13
    //   666: astore_0
    //   667: aload 12
    //   669: astore 10
    //   671: aload_1
    //   672: ldc_w 521
    //   675: aload 15
    //   677: invokevirtual 352	com/tencent/feedback/proguard/o:f	()Ljava/lang/String;
    //   680: invokevirtual 289	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   683: goto -347 -> 336
    //   686: astore_0
    //   687: aload 12
    //   689: astore_1
    //   690: aload_0
    //   691: astore 12
    //   693: iload 4
    //   695: istore_2
    //   696: aload 11
    //   698: astore_0
    //   699: aload_1
    //   700: astore 10
    //   702: ldc 122
    //   704: iconst_0
    //   705: anewarray 4	java/lang/Object
    //   708: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   711: iload 4
    //   713: istore_2
    //   714: aload 11
    //   716: astore_0
    //   717: aload_1
    //   718: astore 10
    //   720: ldc_w 577
    //   723: iconst_1
    //   724: anewarray 4	java/lang/Object
    //   727: dup
    //   728: iconst_0
    //   729: aload 12
    //   731: invokevirtual 127	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   734: aastore
    //   735: invokestatic 83	com/tencent/feedback/common/e:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   738: iload 4
    //   740: istore_2
    //   741: aload 11
    //   743: astore_0
    //   744: aload_1
    //   745: astore 10
    //   747: aload 12
    //   749: invokevirtual 130	java/lang/Throwable:printStackTrace	()V
    //   752: aload 11
    //   754: ifnull +16 -> 770
    //   757: aload 11
    //   759: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   762: ifeq +8 -> 770
    //   765: aload 11
    //   767: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   770: aload_1
    //   771: ifnull +7 -> 778
    //   774: aload_1
    //   775: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   778: ldc_w 564
    //   781: iconst_1
    //   782: anewarray 4	java/lang/Object
    //   785: dup
    //   786: iconst_0
    //   787: iload 4
    //   789: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   792: aastore
    //   793: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   796: iload 4
    //   798: ireturn
    //   799: iconst_0
    //   800: istore_2
    //   801: goto -398 -> 403
    //   804: iconst_0
    //   805: istore 9
    //   807: goto -368 -> 439
    //   810: aload 13
    //   812: ifnull +16 -> 828
    //   815: aload 13
    //   817: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   820: ifeq +8 -> 828
    //   823: aload 13
    //   825: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   828: aload 12
    //   830: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   833: ldc_w 564
    //   836: iconst_1
    //   837: anewarray 4	java/lang/Object
    //   840: dup
    //   841: iconst_0
    //   842: iload_3
    //   843: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   846: aastore
    //   847: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   850: iload_3
    //   851: ireturn
    //   852: astore_1
    //   853: aconst_null
    //   854: astore 10
    //   856: aload 13
    //   858: astore_0
    //   859: aload_0
    //   860: ifnull +14 -> 874
    //   863: aload_0
    //   864: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   867: ifeq +7 -> 874
    //   870: aload_0
    //   871: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   874: aload 10
    //   876: ifnull +8 -> 884
    //   879: aload 10
    //   881: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   884: ldc_w 564
    //   887: iconst_1
    //   888: anewarray 4	java/lang/Object
    //   891: dup
    //   892: iconst_0
    //   893: iload_2
    //   894: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   897: aastore
    //   898: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   901: aload_1
    //   902: athrow
    //   903: astore_1
    //   904: goto -45 -> 859
    //   907: astore 12
    //   909: aconst_null
    //   910: astore_1
    //   911: goto -218 -> 693
    //   914: iload_2
    //   915: istore_3
    //   916: goto -641 -> 275
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	919	0	paramContext	Context
    //   0	919	1	paramList	List<o>
    //   105	810	2	k	int
    //   110	806	3	m	int
    //   102	695	4	n	int
    //   99	151	5	i1	int
    //   107	151	6	i2	int
    //   369	61	7	l	long
    //   437	369	9	bool	boolean
    //   93	787	10	localObject1	Object
    //   87	679	11	localObject2	Object
    //   119	710	12	localObject3	Object
    //   907	1	12	localThrowable	Throwable
    //   90	767	13	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   96	222	14	localIterator	java.util.Iterator
    //   327	349	15	localo	o
    // Exception table:
    //   from	to	target	type
    //   139	146	686	java/lang/Throwable
    //   169	179	686	java/lang/Throwable
    //   197	207	686	java/lang/Throwable
    //   267	275	686	java/lang/Throwable
    //   291	301	686	java/lang/Throwable
    //   317	329	686	java/lang/Throwable
    //   358	371	686	java/lang/Throwable
    //   387	394	686	java/lang/Throwable
    //   423	429	686	java/lang/Throwable
    //   455	477	686	java/lang/Throwable
    //   498	506	686	java/lang/Throwable
    //   522	534	686	java/lang/Throwable
    //   550	562	686	java/lang/Throwable
    //   578	593	686	java/lang/Throwable
    //   609	624	686	java/lang/Throwable
    //   640	655	686	java/lang/Throwable
    //   671	683	686	java/lang/Throwable
    //   111	121	852	finally
    //   139	146	903	finally
    //   169	179	903	finally
    //   197	207	903	finally
    //   267	275	903	finally
    //   291	301	903	finally
    //   317	329	903	finally
    //   358	371	903	finally
    //   387	394	903	finally
    //   423	429	903	finally
    //   455	477	903	finally
    //   498	506	903	finally
    //   522	534	903	finally
    //   550	562	903	finally
    //   578	593	903	finally
    //   609	624	903	finally
    //   640	655	903	finally
    //   671	683	903	finally
    //   702	711	903	finally
    //   720	738	903	finally
    //   747	752	903	finally
    //   111	121	907	java/lang/Throwable
  }
  
  /* Error */
  public static int d(Context paramContext, List<o> paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 8
    //   12: aload_0
    //   13: ifnull +16 -> 29
    //   16: aload_1
    //   17: ifnull +12 -> 29
    //   20: aload_1
    //   21: invokeinterface 363 1 0
    //   26: ifne +50 -> 76
    //   29: aload_1
    //   30: ifnonnull +23 -> 53
    //   33: ldc_w 556
    //   36: astore_0
    //   37: ldc_w 580
    //   40: iconst_1
    //   41: anewarray 4	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: aload_0
    //   47: aastore
    //   48: invokestatic 56	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   51: iconst_m1
    //   52: ireturn
    //   53: new 97	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   60: aload_1
    //   61: invokeinterface 363 1 0
    //   66: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   69: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore_0
    //   73: goto -36 -> 37
    //   76: ldc_w 582
    //   79: iconst_1
    //   80: anewarray 4	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: aload_1
    //   86: invokeinterface 363 1 0
    //   91: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   94: aastore
    //   95: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   98: new 68	com/tencent/feedback/proguard/n
    //   101: dup
    //   102: aload_0
    //   103: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   106: astore 4
    //   108: aload 8
    //   110: astore 5
    //   112: aload 7
    //   114: astore 6
    //   116: aload 4
    //   118: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   121: astore_0
    //   122: aload_0
    //   123: ifnonnull +73 -> 196
    //   126: aload_0
    //   127: astore 5
    //   129: aload_0
    //   130: astore 6
    //   132: ldc 77
    //   134: iconst_0
    //   135: anewarray 4	java/lang/Object
    //   138: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: aload_0
    //   142: astore 5
    //   144: aload_0
    //   145: astore 6
    //   147: ldc_w 584
    //   150: iconst_0
    //   151: anewarray 4	java/lang/Object
    //   154: invokestatic 83	com/tencent/feedback/common/e:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: aload_0
    //   158: ifnull +14 -> 172
    //   161: aload_0
    //   162: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   165: ifeq +7 -> 172
    //   168: aload_0
    //   169: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   172: aload 4
    //   174: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   177: ldc_w 586
    //   180: iconst_1
    //   181: anewarray 4	java/lang/Object
    //   184: dup
    //   185: iconst_0
    //   186: iconst_0
    //   187: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   190: aastore
    //   191: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   194: iconst_m1
    //   195: ireturn
    //   196: aload_0
    //   197: astore 5
    //   199: aload_0
    //   200: astore 6
    //   202: new 226	java/lang/StringBuffer
    //   205: dup
    //   206: invokespecial 227	java/lang/StringBuffer:<init>	()V
    //   209: astore 7
    //   211: aload_0
    //   212: astore 5
    //   214: aload_0
    //   215: astore 6
    //   217: aload_1
    //   218: invokeinterface 535 1 0
    //   223: astore_1
    //   224: aload_0
    //   225: astore 5
    //   227: aload_0
    //   228: astore 6
    //   230: aload_1
    //   231: invokeinterface 540 1 0
    //   236: ifeq +270 -> 506
    //   239: aload_0
    //   240: astore 5
    //   242: aload_0
    //   243: astore 6
    //   245: aload_1
    //   246: invokeinterface 544 1 0
    //   251: checkcast 345	com/tencent/feedback/proguard/o
    //   254: astore 8
    //   256: aload_0
    //   257: astore 5
    //   259: aload_0
    //   260: astore 6
    //   262: aload 7
    //   264: ldc_w 588
    //   267: invokevirtual 238	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   270: pop
    //   271: aload_0
    //   272: astore 5
    //   274: aload_0
    //   275: astore 6
    //   277: aload 7
    //   279: ldc_w 320
    //   282: invokevirtual 238	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   285: pop
    //   286: aload_0
    //   287: astore 5
    //   289: aload_0
    //   290: astore 6
    //   292: aload 7
    //   294: ldc_w 322
    //   297: invokevirtual 238	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   300: pop
    //   301: aload_0
    //   302: astore 5
    //   304: aload_0
    //   305: astore 6
    //   307: aload 7
    //   309: aload 8
    //   311: invokevirtual 347	com/tencent/feedback/proguard/o:a	()Ljava/lang/String;
    //   314: invokevirtual 238	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   317: pop
    //   318: aload_0
    //   319: astore 5
    //   321: aload_0
    //   322: astore 6
    //   324: aload 7
    //   326: ldc_w 590
    //   329: invokevirtual 238	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   332: pop
    //   333: aload_0
    //   334: astore 5
    //   336: aload_0
    //   337: astore 6
    //   339: aload 7
    //   341: ldc_w 326
    //   344: invokevirtual 238	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   347: pop
    //   348: aload_0
    //   349: astore 5
    //   351: aload_0
    //   352: astore 6
    //   354: aload 7
    //   356: ldc_w 328
    //   359: invokevirtual 238	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   362: pop
    //   363: aload_0
    //   364: astore 5
    //   366: aload_0
    //   367: astore 6
    //   369: aload 7
    //   371: aload 8
    //   373: invokevirtual 350	com/tencent/feedback/proguard/o:e	()I
    //   376: invokevirtual 331	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   379: pop
    //   380: aload_0
    //   381: astore 5
    //   383: aload_0
    //   384: astore 6
    //   386: aload 7
    //   388: ldc_w 381
    //   391: invokevirtual 238	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   394: pop
    //   395: goto -171 -> 224
    //   398: astore 6
    //   400: iconst_0
    //   401: istore_2
    //   402: aload 5
    //   404: astore_0
    //   405: iload_2
    //   406: istore_3
    //   407: aload_0
    //   408: astore 5
    //   410: aload 4
    //   412: astore_1
    //   413: aload 6
    //   415: invokevirtual 130	java/lang/Throwable:printStackTrace	()V
    //   418: iload_2
    //   419: istore_3
    //   420: aload_0
    //   421: astore 5
    //   423: aload 4
    //   425: astore_1
    //   426: ldc_w 592
    //   429: iconst_0
    //   430: anewarray 4	java/lang/Object
    //   433: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   436: iload_2
    //   437: istore_3
    //   438: aload_0
    //   439: astore 5
    //   441: aload 4
    //   443: astore_1
    //   444: ldc_w 594
    //   447: iconst_1
    //   448: anewarray 4	java/lang/Object
    //   451: dup
    //   452: iconst_0
    //   453: aload 6
    //   455: invokevirtual 127	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   458: aastore
    //   459: invokestatic 83	com/tencent/feedback/common/e:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   462: aload_0
    //   463: ifnull +14 -> 477
    //   466: aload_0
    //   467: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   470: ifeq +7 -> 477
    //   473: aload_0
    //   474: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   477: aload 4
    //   479: ifnull +8 -> 487
    //   482: aload 4
    //   484: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   487: ldc_w 586
    //   490: iconst_1
    //   491: anewarray 4	java/lang/Object
    //   494: dup
    //   495: iconst_0
    //   496: iload_2
    //   497: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   500: aastore
    //   501: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   504: iload_2
    //   505: ireturn
    //   506: aload_0
    //   507: astore 5
    //   509: aload_0
    //   510: astore 6
    //   512: aload 7
    //   514: iconst_2
    //   515: invokevirtual 241	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   518: astore 7
    //   520: aload_0
    //   521: astore 5
    //   523: aload_0
    //   524: astore 6
    //   526: aload_0
    //   527: ldc 112
    //   529: aload 7
    //   531: aconst_null
    //   532: invokevirtual 116	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   535: istore_2
    //   536: iload_2
    //   537: istore_3
    //   538: aload_0
    //   539: astore 5
    //   541: aload 4
    //   543: astore_1
    //   544: ldc_w 596
    //   547: iconst_2
    //   548: anewarray 4	java/lang/Object
    //   551: dup
    //   552: iconst_0
    //   553: iload_2
    //   554: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   557: aastore
    //   558: dup
    //   559: iconst_1
    //   560: aload 7
    //   562: aastore
    //   563: invokestatic 83	com/tencent/feedback/common/e:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   566: aload_0
    //   567: ifnull +14 -> 581
    //   570: aload_0
    //   571: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   574: ifeq +7 -> 581
    //   577: aload_0
    //   578: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   581: aload 4
    //   583: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   586: ldc_w 586
    //   589: iconst_1
    //   590: anewarray 4	java/lang/Object
    //   593: dup
    //   594: iconst_0
    //   595: iload_2
    //   596: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   599: aastore
    //   600: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   603: iload_2
    //   604: ireturn
    //   605: astore_0
    //   606: iconst_0
    //   607: istore_2
    //   608: aconst_null
    //   609: astore_1
    //   610: aload 6
    //   612: astore 5
    //   614: aload 5
    //   616: ifnull +16 -> 632
    //   619: aload 5
    //   621: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   624: ifeq +8 -> 632
    //   627: aload 5
    //   629: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   632: aload_1
    //   633: ifnull +7 -> 640
    //   636: aload_1
    //   637: invokevirtual 93	com/tencent/feedback/proguard/n:close	()V
    //   640: ldc_w 586
    //   643: iconst_1
    //   644: anewarray 4	java/lang/Object
    //   647: dup
    //   648: iconst_0
    //   649: iload_2
    //   650: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   653: aastore
    //   654: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   657: aload_0
    //   658: athrow
    //   659: astore_0
    //   660: iconst_0
    //   661: istore_2
    //   662: aload 6
    //   664: astore 5
    //   666: aload 4
    //   668: astore_1
    //   669: goto -55 -> 614
    //   672: astore_0
    //   673: iload_3
    //   674: istore_2
    //   675: goto -61 -> 614
    //   678: astore 6
    //   680: aconst_null
    //   681: astore 4
    //   683: iconst_0
    //   684: istore_2
    //   685: aload 5
    //   687: astore_0
    //   688: goto -283 -> 405
    //   691: astore 6
    //   693: goto -288 -> 405
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	696	0	paramContext	Context
    //   0	696	1	paramList	List<o>
    //   401	284	2	k	int
    //   406	268	3	m	int
    //   106	576	4	localn	n
    //   1	685	5	localObject1	Object
    //   4	381	6	localObject2	Object
    //   398	56	6	localThrowable1	Throwable
    //   510	153	6	localContext	Context
    //   678	1	6	localThrowable2	Throwable
    //   691	1	6	localThrowable3	Throwable
    //   7	554	7	localObject3	Object
    //   10	362	8	localo	o
    // Exception table:
    //   from	to	target	type
    //   116	122	398	java/lang/Throwable
    //   132	141	398	java/lang/Throwable
    //   147	157	398	java/lang/Throwable
    //   202	211	398	java/lang/Throwable
    //   217	224	398	java/lang/Throwable
    //   230	239	398	java/lang/Throwable
    //   245	256	398	java/lang/Throwable
    //   262	271	398	java/lang/Throwable
    //   277	286	398	java/lang/Throwable
    //   292	301	398	java/lang/Throwable
    //   307	318	398	java/lang/Throwable
    //   324	333	398	java/lang/Throwable
    //   339	348	398	java/lang/Throwable
    //   354	363	398	java/lang/Throwable
    //   369	380	398	java/lang/Throwable
    //   386	395	398	java/lang/Throwable
    //   512	520	398	java/lang/Throwable
    //   526	536	398	java/lang/Throwable
    //   98	108	605	finally
    //   116	122	659	finally
    //   132	141	659	finally
    //   147	157	659	finally
    //   202	211	659	finally
    //   217	224	659	finally
    //   230	239	659	finally
    //   245	256	659	finally
    //   262	271	659	finally
    //   277	286	659	finally
    //   292	301	659	finally
    //   307	318	659	finally
    //   324	333	659	finally
    //   339	348	659	finally
    //   354	363	659	finally
    //   369	380	659	finally
    //   386	395	659	finally
    //   512	520	659	finally
    //   526	536	659	finally
    //   413	418	672	finally
    //   426	436	672	finally
    //   444	462	672	finally
    //   544	566	672	finally
    //   98	108	678	java/lang/Throwable
    //   544	566	691	java/lang/Throwable
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.l
 * JD-Core Version:    0.7.0.1
 */