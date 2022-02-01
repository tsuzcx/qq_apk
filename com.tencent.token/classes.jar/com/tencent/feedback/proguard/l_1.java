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
    //   33: new 68	com/tencent/feedback/proguard/n
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   41: astore 4
    //   43: aload 4
    //   45: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   48: astore_0
    //   49: aload_0
    //   50: ifnonnull +62 -> 112
    //   53: ldc 77
    //   55: iconst_0
    //   56: anewarray 4	java/lang/Object
    //   59: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   62: pop
    //   63: ldc 81
    //   65: iconst_0
    //   66: anewarray 4	java/lang/Object
    //   69: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   72: pop
    //   73: aload_0
    //   74: ifnull +14 -> 88
    //   77: aload_0
    //   78: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   81: ifeq +7 -> 88
    //   84: aload_0
    //   85: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   88: aload 4
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
    //   121: iconst_1
    //   122: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: astore 5
    //   130: aload_0
    //   131: ldc 110
    //   133: aload 5
    //   135: aconst_null
    //   136: invokevirtual 114	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   139: istore_1
    //   140: aload 5
    //   142: astore_3
    //   143: aload 5
    //   145: ifnonnull +6 -> 151
    //   148: ldc 116
    //   150: astore_3
    //   151: iload_1
    //   152: istore_2
    //   153: aload_0
    //   154: astore 6
    //   156: aload 4
    //   158: astore 5
    //   160: ldc 118
    //   162: iconst_2
    //   163: anewarray 4	java/lang/Object
    //   166: dup
    //   167: iconst_0
    //   168: iload_1
    //   169: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   172: aastore
    //   173: dup
    //   174: iconst_1
    //   175: aload_3
    //   176: aastore
    //   177: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   180: pop
    //   181: aload_0
    //   182: ifnull +14 -> 196
    //   185: aload_0
    //   186: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   189: ifeq +7 -> 196
    //   192: aload_0
    //   193: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   196: aload 4
    //   198: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   201: ldc 93
    //   203: iconst_1
    //   204: anewarray 4	java/lang/Object
    //   207: dup
    //   208: iconst_0
    //   209: iload_1
    //   210: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   213: aastore
    //   214: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   217: pop
    //   218: iload_1
    //   219: ireturn
    //   220: astore_3
    //   221: aconst_null
    //   222: astore_0
    //   223: aconst_null
    //   224: astore 4
    //   226: iconst_0
    //   227: istore_1
    //   228: iload_1
    //   229: istore_2
    //   230: aload_0
    //   231: astore 6
    //   233: aload 4
    //   235: astore 5
    //   237: ldc 120
    //   239: iconst_0
    //   240: anewarray 4	java/lang/Object
    //   243: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   246: pop
    //   247: iload_1
    //   248: istore_2
    //   249: aload_0
    //   250: astore 6
    //   252: aload 4
    //   254: astore 5
    //   256: ldc 122
    //   258: iconst_1
    //   259: anewarray 4	java/lang/Object
    //   262: dup
    //   263: iconst_0
    //   264: aload_3
    //   265: invokevirtual 125	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   268: aastore
    //   269: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   272: pop
    //   273: iload_1
    //   274: istore_2
    //   275: aload_0
    //   276: astore 6
    //   278: aload 4
    //   280: astore 5
    //   282: aload_3
    //   283: invokestatic 128	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   286: ifne +16 -> 302
    //   289: iload_1
    //   290: istore_2
    //   291: aload_0
    //   292: astore 6
    //   294: aload 4
    //   296: astore 5
    //   298: aload_3
    //   299: invokevirtual 131	java/lang/Throwable:printStackTrace	()V
    //   302: aload_0
    //   303: ifnull +14 -> 317
    //   306: aload_0
    //   307: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   310: ifeq +7 -> 317
    //   313: aload_0
    //   314: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   317: aload 4
    //   319: ifnull +8 -> 327
    //   322: aload 4
    //   324: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   327: ldc 93
    //   329: iconst_1
    //   330: anewarray 4	java/lang/Object
    //   333: dup
    //   334: iconst_0
    //   335: iload_1
    //   336: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   339: aastore
    //   340: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   343: pop
    //   344: iload_1
    //   345: ireturn
    //   346: astore_3
    //   347: aconst_null
    //   348: astore_0
    //   349: aconst_null
    //   350: astore 4
    //   352: iconst_0
    //   353: istore_1
    //   354: aload_0
    //   355: ifnull +14 -> 369
    //   358: aload_0
    //   359: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   362: ifeq +7 -> 369
    //   365: aload_0
    //   366: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   369: aload 4
    //   371: ifnull +8 -> 379
    //   374: aload 4
    //   376: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   379: ldc 93
    //   381: iconst_1
    //   382: anewarray 4	java/lang/Object
    //   385: dup
    //   386: iconst_0
    //   387: iload_1
    //   388: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   391: aastore
    //   392: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   395: pop
    //   396: aload_3
    //   397: athrow
    //   398: astore_3
    //   399: aconst_null
    //   400: astore_0
    //   401: iconst_0
    //   402: istore_1
    //   403: goto -49 -> 354
    //   406: astore_3
    //   407: iconst_0
    //   408: istore_1
    //   409: goto -55 -> 354
    //   412: astore_3
    //   413: iload_2
    //   414: istore_1
    //   415: aload 6
    //   417: astore_0
    //   418: aload 5
    //   420: astore 4
    //   422: goto -68 -> 354
    //   425: astore_3
    //   426: aconst_null
    //   427: astore_0
    //   428: iconst_0
    //   429: istore_1
    //   430: goto -202 -> 228
    //   433: astore_3
    //   434: iconst_0
    //   435: istore_1
    //   436: goto -208 -> 228
    //   439: astore_3
    //   440: goto -212 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	443	0	paramContext	Context
    //   0	443	1	paramInt	int
    //   152	262	2	k	int
    //   142	34	3	localObject1	Object
    //   220	79	3	localThrowable1	Throwable
    //   346	51	3	localObject2	Object
    //   398	1	3	localObject3	Object
    //   406	1	3	localObject4	Object
    //   412	1	3	localObject5	Object
    //   425	1	3	localThrowable2	Throwable
    //   433	1	3	localThrowable3	Throwable
    //   439	1	3	localThrowable4	Throwable
    //   41	380	4	localObject6	Object
    //   128	291	5	localObject7	Object
    //   154	262	6	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   33	43	220	java/lang/Throwable
    //   33	43	346	finally
    //   43	49	398	finally
    //   53	73	406	finally
    //   112	140	406	finally
    //   160	181	412	finally
    //   237	247	412	finally
    //   256	273	412	finally
    //   282	289	412	finally
    //   298	302	412	finally
    //   43	49	425	java/lang/Throwable
    //   53	73	433	java/lang/Throwable
    //   112	140	433	java/lang/Throwable
    //   160	181	439	java/lang/Throwable
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
    //   6: ldc 137
    //   8: iconst_0
    //   9: anewarray 4	java/lang/Object
    //   12: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   15: pop
    //   16: aload_0
    //   17: ifnonnull +19 -> 36
    //   20: ldc 139
    //   22: iconst_0
    //   23: anewarray 4	java/lang/Object
    //   26: invokestatic 141	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   29: pop
    //   30: iconst_m1
    //   31: istore 8
    //   33: iload 8
    //   35: ireturn
    //   36: lload_2
    //   37: lload 4
    //   39: lcmp
    //   40: ifgt -7 -> 33
    //   43: new 95	java/lang/StringBuilder
    //   46: dup
    //   47: ldc 143
    //   49: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   52: lload_2
    //   53: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   56: ldc 148
    //   58: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc 153
    //   63: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: lload 4
    //   68: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   71: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore 9
    //   76: aload 9
    //   78: astore 10
    //   80: iload 6
    //   82: iflt +30 -> 112
    //   85: new 95	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   92: aload 9
    //   94: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc 156
    //   99: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: iload 6
    //   104: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   107: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: astore 10
    //   112: aload 10
    //   114: astore 9
    //   116: iload 7
    //   118: iflt +30 -> 148
    //   121: new 95	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   128: aload 10
    //   130: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc 158
    //   135: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: iload 7
    //   140: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   143: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: astore 9
    //   148: aload_1
    //   149: ifnull +350 -> 499
    //   152: aload_1
    //   153: arraylength
    //   154: ifle +345 -> 499
    //   157: ldc 160
    //   159: astore 10
    //   161: iconst_0
    //   162: istore 6
    //   164: iload 6
    //   166: aload_1
    //   167: arraylength
    //   168: if_icmpge +41 -> 209
    //   171: new 95	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   178: aload 10
    //   180: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc 162
    //   185: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_1
    //   189: iload 6
    //   191: iaload
    //   192: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: astore 10
    //   200: iload 6
    //   202: iconst_1
    //   203: iadd
    //   204: istore 6
    //   206: goto -42 -> 164
    //   209: aload 10
    //   211: iconst_4
    //   212: invokevirtual 168	java/lang/String:substring	(I)Ljava/lang/String;
    //   215: astore_1
    //   216: new 95	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   223: aload 9
    //   225: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: ldc 170
    //   230: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_1
    //   234: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: ldc 172
    //   239: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: astore_1
    //   246: new 95	java/lang/StringBuilder
    //   249: dup
    //   250: ldc 174
    //   252: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   255: aload_1
    //   256: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: iconst_0
    //   263: anewarray 4	java/lang/Object
    //   266: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   269: pop
    //   270: new 68	com/tencent/feedback/proguard/n
    //   273: dup
    //   274: aload_0
    //   275: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   278: astore 9
    //   280: aload 9
    //   282: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   285: astore_0
    //   286: aload_0
    //   287: ldc 176
    //   289: aload_1
    //   290: aconst_null
    //   291: invokevirtual 114	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   294: istore 6
    //   296: new 95	java/lang/StringBuilder
    //   299: dup
    //   300: ldc 178
    //   302: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   305: iload 6
    //   307: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   310: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: iconst_0
    //   314: anewarray 4	java/lang/Object
    //   317: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   320: pop
    //   321: aload_0
    //   322: ifnull +14 -> 336
    //   325: aload_0
    //   326: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   329: ifeq +7 -> 336
    //   332: aload_0
    //   333: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   336: aload 9
    //   338: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   341: ldc 180
    //   343: iconst_0
    //   344: anewarray 4	java/lang/Object
    //   347: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   350: pop
    //   351: iload 6
    //   353: ireturn
    //   354: astore 9
    //   356: aconst_null
    //   357: astore_0
    //   358: aload 11
    //   360: astore_1
    //   361: aload 9
    //   363: invokevirtual 125	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   366: iconst_0
    //   367: anewarray 4	java/lang/Object
    //   370: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   373: pop
    //   374: aload_0
    //   375: ifnull +14 -> 389
    //   378: aload_0
    //   379: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   382: ifeq +7 -> 389
    //   385: aload_0
    //   386: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   389: aload_1
    //   390: ifnull +7 -> 397
    //   393: aload_1
    //   394: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   397: ldc 180
    //   399: iconst_0
    //   400: anewarray 4	java/lang/Object
    //   403: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   406: pop
    //   407: iconst_m1
    //   408: ireturn
    //   409: astore_1
    //   410: aconst_null
    //   411: astore_0
    //   412: aconst_null
    //   413: astore 9
    //   415: aload_0
    //   416: ifnull +14 -> 430
    //   419: aload_0
    //   420: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   423: ifeq +7 -> 430
    //   426: aload_0
    //   427: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   430: aload 9
    //   432: ifnull +8 -> 440
    //   435: aload 9
    //   437: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   440: ldc 180
    //   442: iconst_0
    //   443: anewarray 4	java/lang/Object
    //   446: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   449: pop
    //   450: aload_1
    //   451: athrow
    //   452: astore_1
    //   453: aconst_null
    //   454: astore_0
    //   455: goto -40 -> 415
    //   458: astore_1
    //   459: goto -44 -> 415
    //   462: astore 10
    //   464: aload_1
    //   465: astore 9
    //   467: aload 10
    //   469: astore_1
    //   470: goto -55 -> 415
    //   473: astore 10
    //   475: aconst_null
    //   476: astore_0
    //   477: aload 9
    //   479: astore_1
    //   480: aload 10
    //   482: astore 9
    //   484: goto -123 -> 361
    //   487: astore 10
    //   489: aload 9
    //   491: astore_1
    //   492: aload 10
    //   494: astore 9
    //   496: goto -135 -> 361
    //   499: aload 9
    //   501: astore_1
    //   502: goto -256 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	505	0	paramContext	Context
    //   0	505	1	paramArrayOfInt	int[]
    //   0	505	2	paramLong1	long
    //   0	505	4	paramLong2	long
    //   0	505	6	paramInt1	int
    //   0	505	7	paramInt2	int
    //   4	30	8	k	int
    //   74	263	9	localObject1	Object
    //   354	8	9	localThrowable1	Throwable
    //   413	87	9	localObject2	Object
    //   78	132	10	localObject3	Object
    //   462	6	10	localObject4	Object
    //   473	8	10	localThrowable2	Throwable
    //   487	6	10	localThrowable3	Throwable
    //   1	358	11	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   270	280	354	java/lang/Throwable
    //   270	280	409	finally
    //   280	286	452	finally
    //   286	321	458	finally
    //   361	374	462	finally
    //   280	286	473	java/lang/Throwable
    //   286	321	487	java/lang/Throwable
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
    //   44: lload_2
    //   45: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   48: ldc 148
    //   50: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc 153
    //   55: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: lload 4
    //   60: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   63: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: astore 9
    //   68: aload 9
    //   70: astore 8
    //   72: aload_1
    //   73: ifnull +102 -> 175
    //   76: aload 9
    //   78: astore 8
    //   80: aload_1
    //   81: arraylength
    //   82: ifle +93 -> 175
    //   85: ldc 160
    //   87: astore 8
    //   89: iconst_0
    //   90: istore 7
    //   92: iload 7
    //   94: aload_1
    //   95: arraylength
    //   96: if_icmpge +41 -> 137
    //   99: new 95	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   106: aload 8
    //   108: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 162
    //   113: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_1
    //   117: iload 7
    //   119: iaload
    //   120: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: astore 8
    //   128: iload 7
    //   130: iconst_1
    //   131: iadd
    //   132: istore 7
    //   134: goto -42 -> 92
    //   137: aload 8
    //   139: iconst_4
    //   140: invokevirtual 168	java/lang/String:substring	(I)Ljava/lang/String;
    //   143: astore_1
    //   144: new 95	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   151: aload 9
    //   153: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc 170
    //   158: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_1
    //   162: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc 172
    //   167: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: astore 8
    //   175: aload 8
    //   177: astore_1
    //   178: aload 6
    //   180: ifnull +34 -> 214
    //   183: new 95	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   190: aload 8
    //   192: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: ldc 187
    //   197: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload 6
    //   202: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: ldc 189
    //   207: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: astore_1
    //   214: new 95	java/lang/StringBuilder
    //   217: dup
    //   218: ldc 191
    //   220: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   223: aload_1
    //   224: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: iconst_0
    //   231: anewarray 4	java/lang/Object
    //   234: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   237: pop
    //   238: aconst_null
    //   239: astore 10
    //   241: aconst_null
    //   242: astore 8
    //   244: aconst_null
    //   245: astore 9
    //   247: new 68	com/tencent/feedback/proguard/n
    //   250: dup
    //   251: aload_0
    //   252: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   255: astore 6
    //   257: aload 6
    //   259: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   262: astore_0
    //   263: aload_0
    //   264: ldc 176
    //   266: iconst_1
    //   267: anewarray 164	java/lang/String
    //   270: dup
    //   271: iconst_0
    //   272: ldc 193
    //   274: aastore
    //   275: aload_1
    //   276: aconst_null
    //   277: aconst_null
    //   278: aconst_null
    //   279: aconst_null
    //   280: invokevirtual 197	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   283: astore_1
    //   284: aload_1
    //   285: invokeinterface 202 1 0
    //   290: pop
    //   291: aload_1
    //   292: aload_1
    //   293: ldc 204
    //   295: invokeinterface 208 2 0
    //   300: invokeinterface 212 2 0
    //   305: istore 7
    //   307: new 95	java/lang/StringBuilder
    //   310: dup
    //   311: ldc 214
    //   313: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   316: iload 7
    //   318: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   321: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: iconst_0
    //   325: anewarray 4	java/lang/Object
    //   328: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   331: pop
    //   332: aload_1
    //   333: ifnull +18 -> 351
    //   336: aload_1
    //   337: invokeinterface 217 1 0
    //   342: ifne +9 -> 351
    //   345: aload_1
    //   346: invokeinterface 218 1 0
    //   351: aload_0
    //   352: ifnull +14 -> 366
    //   355: aload_0
    //   356: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   359: ifeq +7 -> 366
    //   362: aload_0
    //   363: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   366: aload 6
    //   368: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   371: ldc 220
    //   373: iconst_0
    //   374: anewarray 4	java/lang/Object
    //   377: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   380: pop
    //   381: iload 7
    //   383: ireturn
    //   384: astore 8
    //   386: aconst_null
    //   387: astore_1
    //   388: aload 10
    //   390: astore_0
    //   391: aload 9
    //   393: astore 6
    //   395: aload 8
    //   397: invokevirtual 125	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   400: iconst_0
    //   401: anewarray 4	java/lang/Object
    //   404: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   407: pop
    //   408: aload_1
    //   409: ifnull +18 -> 427
    //   412: aload_1
    //   413: invokeinterface 217 1 0
    //   418: ifne +9 -> 427
    //   421: aload_1
    //   422: invokeinterface 218 1 0
    //   427: aload 6
    //   429: ifnull +16 -> 445
    //   432: aload 6
    //   434: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   437: ifeq +8 -> 445
    //   440: aload 6
    //   442: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   445: aload_0
    //   446: ifnull +7 -> 453
    //   449: aload_0
    //   450: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   453: ldc 220
    //   455: iconst_0
    //   456: anewarray 4	java/lang/Object
    //   459: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   462: pop
    //   463: iconst_m1
    //   464: ireturn
    //   465: astore_0
    //   466: aconst_null
    //   467: astore 6
    //   469: aconst_null
    //   470: astore_1
    //   471: aload_1
    //   472: ifnull +18 -> 490
    //   475: aload_1
    //   476: invokeinterface 217 1 0
    //   481: ifne +9 -> 490
    //   484: aload_1
    //   485: invokeinterface 218 1 0
    //   490: aload 8
    //   492: ifnull +16 -> 508
    //   495: aload 8
    //   497: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   500: ifeq +8 -> 508
    //   503: aload 8
    //   505: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   508: aload 6
    //   510: ifnull +8 -> 518
    //   513: aload 6
    //   515: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   518: ldc 220
    //   520: iconst_0
    //   521: anewarray 4	java/lang/Object
    //   524: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   527: pop
    //   528: aload_0
    //   529: athrow
    //   530: astore_0
    //   531: aconst_null
    //   532: astore_1
    //   533: goto -62 -> 471
    //   536: astore_1
    //   537: aconst_null
    //   538: astore 9
    //   540: aload_0
    //   541: astore 8
    //   543: aload_1
    //   544: astore_0
    //   545: aload 9
    //   547: astore_1
    //   548: goto -77 -> 471
    //   551: astore 9
    //   553: aload_0
    //   554: astore 8
    //   556: aload 9
    //   558: astore_0
    //   559: goto -88 -> 471
    //   562: astore 8
    //   564: aload_0
    //   565: astore 9
    //   567: aload 8
    //   569: astore_0
    //   570: aload 6
    //   572: astore 8
    //   574: aload 9
    //   576: astore 6
    //   578: goto -107 -> 471
    //   581: astore 8
    //   583: aload 6
    //   585: astore_0
    //   586: aconst_null
    //   587: astore_1
    //   588: aload 9
    //   590: astore 6
    //   592: goto -197 -> 395
    //   595: astore 8
    //   597: aload 6
    //   599: astore_1
    //   600: aconst_null
    //   601: astore 9
    //   603: aload_0
    //   604: astore 6
    //   606: aload_1
    //   607: astore_0
    //   608: aload 9
    //   610: astore_1
    //   611: goto -216 -> 395
    //   614: astore 8
    //   616: aload 6
    //   618: astore 9
    //   620: aload_0
    //   621: astore 6
    //   623: aload 9
    //   625: astore_0
    //   626: goto -231 -> 395
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	629	0	paramContext	Context
    //   0	629	1	paramArrayOfInt	int[]
    //   0	629	2	paramLong1	long
    //   0	629	4	paramLong2	long
    //   0	629	6	paramString	String
    //   90	292	7	k	int
    //   70	173	8	str1	String
    //   384	120	8	localThrowable1	Throwable
    //   541	14	8	localContext	Context
    //   562	6	8	localObject1	Object
    //   572	1	8	str2	String
    //   581	1	8	localThrowable2	Throwable
    //   595	1	8	localThrowable3	Throwable
    //   614	1	8	localThrowable4	Throwable
    //   66	480	9	str3	String
    //   551	6	9	localObject2	Object
    //   565	59	9	localObject3	Object
    //   239	150	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   247	257	384	java/lang/Throwable
    //   247	257	465	finally
    //   257	263	530	finally
    //   263	284	536	finally
    //   284	332	551	finally
    //   395	408	562	finally
    //   257	263	581	java/lang/Throwable
    //   263	284	595	java/lang/Throwable
    //   284	332	614	java/lang/Throwable
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
    //   12: ldc 223
    //   14: iconst_0
    //   15: anewarray 4	java/lang/Object
    //   18: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   21: pop
    //   22: aload_0
    //   23: ifnonnull +15 -> 38
    //   26: ldc 225
    //   28: iconst_0
    //   29: anewarray 4	java/lang/Object
    //   32: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   35: pop
    //   36: iconst_m1
    //   37: ireturn
    //   38: aload_1
    //   39: ifnull +8 -> 47
    //   42: aload_1
    //   43: arraylength
    //   44: ifgt +5 -> 49
    //   47: iconst_0
    //   48: ireturn
    //   49: new 68	com/tencent/feedback/proguard/n
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   57: astore 9
    //   59: aload 7
    //   61: astore_0
    //   62: aload 9
    //   64: astore 7
    //   66: aload 11
    //   68: astore 8
    //   70: aload 9
    //   72: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   75: astore 10
    //   77: aload 10
    //   79: astore_0
    //   80: aload 9
    //   82: astore 7
    //   84: aload 10
    //   86: astore 8
    //   88: new 227	java/lang/StringBuffer
    //   91: dup
    //   92: invokespecial 228	java/lang/StringBuffer:<init>	()V
    //   95: astore 11
    //   97: iconst_0
    //   98: istore_2
    //   99: iconst_0
    //   100: istore_3
    //   101: aload 10
    //   103: astore_0
    //   104: aload 9
    //   106: astore 7
    //   108: aload 10
    //   110: astore 8
    //   112: iload_3
    //   113: aload_1
    //   114: arraylength
    //   115: if_icmpge +193 -> 308
    //   118: aload 10
    //   120: astore_0
    //   121: aload 9
    //   123: astore 7
    //   125: aload 10
    //   127: astore 8
    //   129: aload_1
    //   130: iload_3
    //   131: aaload
    //   132: invokevirtual 234	java/lang/Long:longValue	()J
    //   135: lstore 5
    //   137: aload 10
    //   139: astore_0
    //   140: aload 9
    //   142: astore 7
    //   144: aload 10
    //   146: astore 8
    //   148: aload 11
    //   150: new 95	java/lang/StringBuilder
    //   153: dup
    //   154: ldc 236
    //   156: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   159: lload 5
    //   161: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   164: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   170: pop
    //   171: iload_2
    //   172: istore 4
    //   174: iload_3
    //   175: ifle +389 -> 564
    //   178: iload_2
    //   179: istore 4
    //   181: iload_3
    //   182: bipush 50
    //   184: irem
    //   185: ifne +379 -> 564
    //   188: aload 10
    //   190: astore_0
    //   191: aload 9
    //   193: astore 7
    //   195: aload 10
    //   197: astore 8
    //   199: new 95	java/lang/StringBuilder
    //   202: dup
    //   203: ldc 241
    //   205: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   208: iload_3
    //   209: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   212: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: iconst_0
    //   216: anewarray 4	java/lang/Object
    //   219: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   222: pop
    //   223: aload 10
    //   225: astore_0
    //   226: aload 9
    //   228: astore 7
    //   230: aload 10
    //   232: astore 8
    //   234: iload_2
    //   235: aload 10
    //   237: ldc 176
    //   239: aload 11
    //   241: iconst_4
    //   242: invokevirtual 242	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   245: aconst_null
    //   246: invokevirtual 114	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   249: iadd
    //   250: istore 4
    //   252: aload 10
    //   254: astore_0
    //   255: aload 9
    //   257: astore 7
    //   259: aload 10
    //   261: astore 8
    //   263: aload 11
    //   265: iconst_0
    //   266: invokevirtual 246	java/lang/StringBuffer:setLength	(I)V
    //   269: aload 10
    //   271: astore_0
    //   272: aload 9
    //   274: astore 7
    //   276: aload 10
    //   278: astore 8
    //   280: new 95	java/lang/StringBuilder
    //   283: dup
    //   284: ldc 248
    //   286: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   289: iload 4
    //   291: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   294: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: iconst_0
    //   298: anewarray 4	java/lang/Object
    //   301: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   304: pop
    //   305: goto +259 -> 564
    //   308: iload_2
    //   309: istore_3
    //   310: aload 10
    //   312: astore_0
    //   313: aload 9
    //   315: astore 7
    //   317: aload 10
    //   319: astore 8
    //   321: aload 11
    //   323: invokevirtual 252	java/lang/StringBuffer:length	()I
    //   326: ifle +48 -> 374
    //   329: aload 10
    //   331: astore_0
    //   332: aload 9
    //   334: astore 7
    //   336: aload 10
    //   338: astore 8
    //   340: iload_2
    //   341: aload 10
    //   343: ldc 176
    //   345: aload 11
    //   347: iconst_4
    //   348: invokevirtual 242	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   351: aconst_null
    //   352: invokevirtual 114	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   355: iadd
    //   356: istore_3
    //   357: aload 10
    //   359: astore_0
    //   360: aload 9
    //   362: astore 7
    //   364: aload 10
    //   366: astore 8
    //   368: aload 11
    //   370: iconst_0
    //   371: invokevirtual 246	java/lang/StringBuffer:setLength	(I)V
    //   374: aload 10
    //   376: astore_0
    //   377: aload 9
    //   379: astore 7
    //   381: aload 10
    //   383: astore 8
    //   385: new 95	java/lang/StringBuilder
    //   388: dup
    //   389: ldc 254
    //   391: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   394: iload_3
    //   395: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   398: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: iconst_0
    //   402: anewarray 4	java/lang/Object
    //   405: invokestatic 141	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   408: pop
    //   409: aload 10
    //   411: ifnull +16 -> 427
    //   414: aload 10
    //   416: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   419: ifeq +8 -> 427
    //   422: aload 10
    //   424: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   427: aload 9
    //   429: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   432: ldc_w 256
    //   435: iconst_0
    //   436: anewarray 4	java/lang/Object
    //   439: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   442: pop
    //   443: iload_3
    //   444: ireturn
    //   445: astore 10
    //   447: aconst_null
    //   448: astore_1
    //   449: aload 8
    //   451: astore_0
    //   452: aload_1
    //   453: astore 7
    //   455: aload 10
    //   457: invokevirtual 125	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   460: iconst_0
    //   461: anewarray 4	java/lang/Object
    //   464: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   467: pop
    //   468: aload 8
    //   470: ifnull +16 -> 486
    //   473: aload 8
    //   475: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   478: ifeq +8 -> 486
    //   481: aload 8
    //   483: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   486: aload_1
    //   487: ifnull +7 -> 494
    //   490: aload_1
    //   491: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   494: ldc_w 256
    //   497: iconst_0
    //   498: anewarray 4	java/lang/Object
    //   501: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   504: pop
    //   505: iconst_m1
    //   506: ireturn
    //   507: astore_1
    //   508: aconst_null
    //   509: astore 7
    //   511: aload 10
    //   513: astore_0
    //   514: aload_0
    //   515: ifnull +14 -> 529
    //   518: aload_0
    //   519: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   522: ifeq +7 -> 529
    //   525: aload_0
    //   526: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   529: aload 7
    //   531: ifnull +8 -> 539
    //   534: aload 7
    //   536: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   539: ldc_w 256
    //   542: iconst_0
    //   543: anewarray 4	java/lang/Object
    //   546: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   549: pop
    //   550: aload_1
    //   551: athrow
    //   552: astore_1
    //   553: goto -39 -> 514
    //   556: astore 10
    //   558: aload 9
    //   560: astore_1
    //   561: goto -112 -> 449
    //   564: iload_3
    //   565: iconst_1
    //   566: iadd
    //   567: istore_3
    //   568: iload 4
    //   570: istore_2
    //   571: goto -470 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	574	0	paramContext	Context
    //   0	574	1	paramArrayOfLong	Long[]
    //   98	473	2	k	int
    //   100	468	3	m	int
    //   172	397	4	n	int
    //   135	25	5	l	long
    //   4	531	7	localObject1	Object
    //   10	472	8	localObject2	Object
    //   57	502	9	localn	n
    //   1	422	10	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   445	67	10	localThrowable1	Throwable
    //   556	1	10	localThrowable2	Throwable
    //   7	362	11	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   49	59	445	java/lang/Throwable
    //   49	59	507	finally
    //   70	77	552	finally
    //   88	97	552	finally
    //   112	118	552	finally
    //   129	137	552	finally
    //   148	171	552	finally
    //   199	223	552	finally
    //   234	252	552	finally
    //   263	269	552	finally
    //   280	305	552	finally
    //   321	329	552	finally
    //   340	357	552	finally
    //   368	374	552	finally
    //   385	409	552	finally
    //   455	468	552	finally
    //   70	77	556	java/lang/Throwable
    //   88	97	556	java/lang/Throwable
    //   112	118	556	java/lang/Throwable
    //   129	137	556	java/lang/Throwable
    //   148	171	556	java/lang/Throwable
    //   199	223	556	java/lang/Throwable
    //   234	252	556	java/lang/Throwable
    //   263	269	556	java/lang/Throwable
    //   280	305	556	java/lang/Throwable
    //   321	329	556	java/lang/Throwable
    //   340	357	556	java/lang/Throwable
    //   368	374	556	java/lang/Throwable
    //   385	409	556	java/lang/Throwable
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
    //   5: ifne +23 -> 28
    //   8: ldc_w 305
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: iload_3
    //   18: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: aastore
    //   22: invokestatic 56	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   25: pop
    //   26: aconst_null
    //   27: areturn
    //   28: aload_1
    //   29: ifnonnull +144 -> 173
    //   32: ldc_w 307
    //   35: astore 4
    //   37: ldc_w 309
    //   40: iconst_3
    //   41: anewarray 4	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: aload 4
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: iload_2
    //   52: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: aastore
    //   56: dup
    //   57: iconst_2
    //   58: iload_3
    //   59: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   62: aastore
    //   63: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   66: pop
    //   67: aconst_null
    //   68: astore 7
    //   70: aconst_null
    //   71: astore 8
    //   73: new 68	com/tencent/feedback/proguard/n
    //   76: dup
    //   77: aload_0
    //   78: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   81: astore 4
    //   83: aload 4
    //   85: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   88: astore_0
    //   89: aload_0
    //   90: ifnonnull +89 -> 179
    //   93: ldc_w 311
    //   96: iconst_0
    //   97: anewarray 4	java/lang/Object
    //   100: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   103: pop
    //   104: ldc_w 313
    //   107: iconst_0
    //   108: anewarray 4	java/lang/Object
    //   111: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   114: pop
    //   115: aload_0
    //   116: ifnull +14 -> 130
    //   119: aload_0
    //   120: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   123: ifeq +7 -> 130
    //   126: aload_0
    //   127: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   130: aload 4
    //   132: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   135: ldc_w 315
    //   138: iconst_1
    //   139: anewarray 4	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: iconst_m1
    //   145: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   148: aastore
    //   149: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   152: pop
    //   153: ldc_w 317
    //   156: iconst_1
    //   157: anewarray 4	java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: iconst_m1
    //   163: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   166: aastore
    //   167: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   170: pop
    //   171: aconst_null
    //   172: areturn
    //   173: aload_1
    //   174: astore 4
    //   176: goto -139 -> 37
    //   179: new 227	java/lang/StringBuffer
    //   182: dup
    //   183: invokespecial 228	java/lang/StringBuffer:<init>	()V
    //   186: astore 5
    //   188: aload_1
    //   189: ifnull +54 -> 243
    //   192: aload 5
    //   194: invokevirtual 252	java/lang/StringBuffer:length	()I
    //   197: ifle +12 -> 209
    //   200: aload 5
    //   202: ldc_w 319
    //   205: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   208: pop
    //   209: aload 5
    //   211: ldc_w 321
    //   214: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   217: pop
    //   218: aload 5
    //   220: ldc_w 323
    //   223: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   226: pop
    //   227: aload 5
    //   229: aload_1
    //   230: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   233: pop
    //   234: aload 5
    //   236: ldc_w 325
    //   239: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   242: pop
    //   243: iload_2
    //   244: iflt +45 -> 289
    //   247: aload 5
    //   249: invokevirtual 252	java/lang/StringBuffer:length	()I
    //   252: ifle +12 -> 264
    //   255: aload 5
    //   257: ldc_w 319
    //   260: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   263: pop
    //   264: aload 5
    //   266: ldc_w 327
    //   269: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   272: pop
    //   273: aload 5
    //   275: ldc_w 329
    //   278: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   281: pop
    //   282: aload 5
    //   284: iload_2
    //   285: invokevirtual 332	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   288: pop
    //   289: aload 5
    //   291: invokevirtual 252	java/lang/StringBuffer:length	()I
    //   294: ifle +279 -> 573
    //   297: aload 5
    //   299: invokevirtual 333	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   302: astore_1
    //   303: iload_3
    //   304: ifle +274 -> 578
    //   307: new 95	java/lang/StringBuilder
    //   310: dup
    //   311: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   314: iload_3
    //   315: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   318: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: astore 5
    //   323: aload_0
    //   324: ldc 110
    //   326: aconst_null
    //   327: aload_1
    //   328: aconst_null
    //   329: aconst_null
    //   330: aconst_null
    //   331: aconst_null
    //   332: aload 5
    //   334: invokevirtual 336	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   337: astore 6
    //   339: aload 6
    //   341: ifnull +591 -> 932
    //   344: new 338	java/util/ArrayList
    //   347: dup
    //   348: invokespecial 339	java/util/ArrayList:<init>	()V
    //   351: astore_1
    //   352: aload 6
    //   354: invokeinterface 202 1 0
    //   359: ifeq +225 -> 584
    //   362: aload 6
    //   364: invokestatic 342	com/tencent/feedback/proguard/l:b	(Landroid/database/Cursor;)Lcom/tencent/feedback/proguard/o;
    //   367: astore 5
    //   369: aload 5
    //   371: ifnull +213 -> 584
    //   374: ldc_w 344
    //   377: iconst_4
    //   378: anewarray 4	java/lang/Object
    //   381: dup
    //   382: iconst_0
    //   383: aload 5
    //   385: invokevirtual 348	com/tencent/feedback/proguard/o:a	()Ljava/lang/String;
    //   388: aastore
    //   389: dup
    //   390: iconst_1
    //   391: aload 5
    //   393: invokevirtual 350	com/tencent/feedback/proguard/o:d	()Ljava/lang/String;
    //   396: aastore
    //   397: dup
    //   398: iconst_2
    //   399: aload 5
    //   401: invokevirtual 351	com/tencent/feedback/proguard/o:e	()I
    //   404: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   407: aastore
    //   408: dup
    //   409: iconst_3
    //   410: aload 5
    //   412: invokevirtual 353	com/tencent/feedback/proguard/o:f	()Ljava/lang/String;
    //   415: aastore
    //   416: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   419: pop
    //   420: aload_1
    //   421: aload 5
    //   423: invokeinterface 359 2 0
    //   428: pop
    //   429: goto -77 -> 352
    //   432: astore 5
    //   434: aload_1
    //   435: astore 7
    //   437: aload_0
    //   438: astore_1
    //   439: aload 7
    //   441: astore_0
    //   442: ldc_w 361
    //   445: iconst_0
    //   446: anewarray 4	java/lang/Object
    //   449: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   452: pop
    //   453: ldc_w 313
    //   456: iconst_0
    //   457: anewarray 4	java/lang/Object
    //   460: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   463: pop
    //   464: aload 5
    //   466: invokestatic 128	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   469: ifne +8 -> 477
    //   472: aload 5
    //   474: invokevirtual 131	java/lang/Throwable:printStackTrace	()V
    //   477: aload 6
    //   479: ifnull +20 -> 499
    //   482: aload 6
    //   484: invokeinterface 217 1 0
    //   489: ifne +10 -> 499
    //   492: aload 6
    //   494: invokeinterface 218 1 0
    //   499: aload_1
    //   500: ifnull +14 -> 514
    //   503: aload_1
    //   504: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   507: ifeq +7 -> 514
    //   510: aload_1
    //   511: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   514: aload 4
    //   516: ifnull +8 -> 524
    //   519: aload 4
    //   521: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   524: aload_0
    //   525: ifnull +155 -> 680
    //   528: aload_0
    //   529: invokeinterface 364 1 0
    //   534: istore_2
    //   535: ldc_w 315
    //   538: iconst_1
    //   539: anewarray 4	java/lang/Object
    //   542: dup
    //   543: iconst_0
    //   544: iload_2
    //   545: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   548: aastore
    //   549: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   552: pop
    //   553: ldc_w 317
    //   556: iconst_1
    //   557: anewarray 4	java/lang/Object
    //   560: dup
    //   561: iconst_0
    //   562: iload_2
    //   563: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   566: aastore
    //   567: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   570: pop
    //   571: aload_0
    //   572: areturn
    //   573: aconst_null
    //   574: astore_1
    //   575: goto -272 -> 303
    //   578: aconst_null
    //   579: astore 5
    //   581: goto -258 -> 323
    //   584: aload 6
    //   586: ifnull +20 -> 606
    //   589: aload 6
    //   591: invokeinterface 217 1 0
    //   596: ifne +10 -> 606
    //   599: aload 6
    //   601: invokeinterface 218 1 0
    //   606: aload_0
    //   607: ifnull +14 -> 621
    //   610: aload_0
    //   611: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   614: ifeq +7 -> 621
    //   617: aload_0
    //   618: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   621: aload 4
    //   623: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   626: aload_1
    //   627: ifnull +48 -> 675
    //   630: aload_1
    //   631: invokeinterface 364 1 0
    //   636: istore_2
    //   637: ldc_w 315
    //   640: iconst_1
    //   641: anewarray 4	java/lang/Object
    //   644: dup
    //   645: iconst_0
    //   646: iload_2
    //   647: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   650: aastore
    //   651: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   654: pop
    //   655: ldc_w 317
    //   658: iconst_1
    //   659: anewarray 4	java/lang/Object
    //   662: dup
    //   663: iconst_0
    //   664: iload_2
    //   665: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   668: aastore
    //   669: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   672: pop
    //   673: aload_1
    //   674: areturn
    //   675: iconst_m1
    //   676: istore_2
    //   677: goto -40 -> 637
    //   680: iconst_m1
    //   681: istore_2
    //   682: goto -147 -> 535
    //   685: astore_0
    //   686: aconst_null
    //   687: astore 4
    //   689: aconst_null
    //   690: astore_1
    //   691: aload 7
    //   693: astore 6
    //   695: aload 8
    //   697: astore 5
    //   699: aload 5
    //   701: ifnull +20 -> 721
    //   704: aload 5
    //   706: invokeinterface 217 1 0
    //   711: ifne +10 -> 721
    //   714: aload 5
    //   716: invokeinterface 218 1 0
    //   721: aload_1
    //   722: ifnull +14 -> 736
    //   725: aload_1
    //   726: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   729: ifeq +7 -> 736
    //   732: aload_1
    //   733: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   736: aload 4
    //   738: ifnull +8 -> 746
    //   741: aload 4
    //   743: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   746: aload 6
    //   748: ifnull +49 -> 797
    //   751: aload 6
    //   753: invokeinterface 364 1 0
    //   758: istore_2
    //   759: ldc_w 315
    //   762: iconst_1
    //   763: anewarray 4	java/lang/Object
    //   766: dup
    //   767: iconst_0
    //   768: iload_2
    //   769: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   772: aastore
    //   773: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   776: pop
    //   777: ldc_w 317
    //   780: iconst_1
    //   781: anewarray 4	java/lang/Object
    //   784: dup
    //   785: iconst_0
    //   786: iload_2
    //   787: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   790: aastore
    //   791: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   794: pop
    //   795: aload_0
    //   796: athrow
    //   797: iconst_m1
    //   798: istore_2
    //   799: goto -40 -> 759
    //   802: astore_0
    //   803: aconst_null
    //   804: astore_1
    //   805: aload 8
    //   807: astore 5
    //   809: aload 7
    //   811: astore 6
    //   813: goto -114 -> 699
    //   816: astore 5
    //   818: aload_0
    //   819: astore_1
    //   820: aload 5
    //   822: astore_0
    //   823: aload 8
    //   825: astore 5
    //   827: aload 7
    //   829: astore 6
    //   831: goto -132 -> 699
    //   834: astore 8
    //   836: aload 6
    //   838: astore 5
    //   840: aload_0
    //   841: astore_1
    //   842: aload 8
    //   844: astore_0
    //   845: aload 7
    //   847: astore 6
    //   849: goto -150 -> 699
    //   852: astore 7
    //   854: aload 6
    //   856: astore 5
    //   858: aload_1
    //   859: astore 6
    //   861: aload_0
    //   862: astore_1
    //   863: aload 7
    //   865: astore_0
    //   866: goto -167 -> 699
    //   869: astore 7
    //   871: aload 6
    //   873: astore 5
    //   875: aload_0
    //   876: astore 6
    //   878: aload 7
    //   880: astore_0
    //   881: goto -182 -> 699
    //   884: astore 5
    //   886: aconst_null
    //   887: astore_1
    //   888: aconst_null
    //   889: astore 4
    //   891: aconst_null
    //   892: astore 6
    //   894: aconst_null
    //   895: astore_0
    //   896: goto -454 -> 442
    //   899: astore 5
    //   901: aconst_null
    //   902: astore 6
    //   904: aconst_null
    //   905: astore_1
    //   906: aconst_null
    //   907: astore_0
    //   908: goto -466 -> 442
    //   911: astore 5
    //   913: aconst_null
    //   914: astore 6
    //   916: aload_0
    //   917: astore_1
    //   918: aconst_null
    //   919: astore_0
    //   920: goto -478 -> 442
    //   923: astore 5
    //   925: aload_0
    //   926: astore_1
    //   927: aconst_null
    //   928: astore_0
    //   929: goto -487 -> 442
    //   932: aconst_null
    //   933: astore_1
    //   934: goto -350 -> 584
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	937	0	paramContext	Context
    //   0	937	1	paramString	String
    //   0	937	2	paramInt1	int
    //   0	937	3	paramInt2	int
    //   35	855	4	localObject1	Object
    //   186	236	5	localObject2	Object
    //   432	41	5	localThrowable1	Throwable
    //   579	229	5	localObject3	Object
    //   816	5	5	localObject4	Object
    //   825	49	5	localObject5	Object
    //   884	1	5	localThrowable2	Throwable
    //   899	1	5	localThrowable3	Throwable
    //   911	1	5	localThrowable4	Throwable
    //   923	1	5	localThrowable5	Throwable
    //   337	578	6	localObject6	Object
    //   68	778	7	str	String
    //   852	12	7	localObject7	Object
    //   869	10	7	localObject8	Object
    //   71	753	8	localObject9	Object
    //   834	9	8	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   352	369	432	java/lang/Throwable
    //   374	429	432	java/lang/Throwable
    //   73	83	685	finally
    //   83	89	802	finally
    //   93	115	816	finally
    //   179	188	816	finally
    //   192	209	816	finally
    //   209	243	816	finally
    //   247	264	816	finally
    //   264	289	816	finally
    //   289	303	816	finally
    //   307	323	816	finally
    //   323	339	816	finally
    //   344	352	834	finally
    //   352	369	852	finally
    //   374	429	852	finally
    //   442	477	869	finally
    //   73	83	884	java/lang/Throwable
    //   83	89	899	java/lang/Throwable
    //   93	115	911	java/lang/Throwable
    //   179	188	911	java/lang/Throwable
    //   192	209	911	java/lang/Throwable
    //   209	243	911	java/lang/Throwable
    //   247	264	911	java/lang/Throwable
    //   264	289	911	java/lang/Throwable
    //   289	303	911	java/lang/Throwable
    //   307	323	911	java/lang/Throwable
    //   323	339	911	java/lang/Throwable
    //   344	352	923	java/lang/Throwable
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
    //   12: ifnull +49 -> 61
    //   15: lload 4
    //   17: lconst_0
    //   18: lcmp
    //   19: ifeq +42 -> 61
    //   22: lload 14
    //   24: lconst_0
    //   25: lcmp
    //   26: ifle +11 -> 37
    //   29: lload 12
    //   31: lload 14
    //   33: lcmp
    //   34: ifgt +27 -> 61
    //   37: iload 9
    //   39: ifle +10 -> 49
    //   42: iload 8
    //   44: iload 9
    //   46: if_icmpgt +15 -> 61
    //   49: iload 11
    //   51: ifle +23 -> 74
    //   54: iload 10
    //   56: iload 11
    //   58: if_icmple +16 -> 74
    //   61: ldc_w 377
    //   64: iconst_0
    //   65: anewarray 4	java/lang/Object
    //   68: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   71: pop
    //   72: aconst_null
    //   73: areturn
    //   74: lload 4
    //   76: lstore 18
    //   78: lload 4
    //   80: lconst_0
    //   81: lcmp
    //   82: ifge +8 -> 90
    //   85: ldc2_w 368
    //   88: lstore 18
    //   90: aload_1
    //   91: ifnull +2100 -> 2191
    //   94: aload_1
    //   95: arraylength
    //   96: ifle +2095 -> 2191
    //   99: ldc 160
    //   101: astore 20
    //   103: iconst_0
    //   104: istore 17
    //   106: iload 17
    //   108: aload_1
    //   109: arraylength
    //   110: if_icmpge +41 -> 151
    //   113: new 95	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   120: aload 20
    //   122: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc 162
    //   127: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_1
    //   131: iload 17
    //   133: iaload
    //   134: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   137: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: astore 20
    //   142: iload 17
    //   144: iconst_1
    //   145: iadd
    //   146: istore 17
    //   148: goto -42 -> 106
    //   151: new 95	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   158: ldc 160
    //   160: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload 20
    //   165: iconst_4
    //   166: invokevirtual 168	java/lang/String:substring	(I)Ljava/lang/String;
    //   169: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: astore_1
    //   176: aload_1
    //   177: invokevirtual 378	java/lang/String:length	()I
    //   180: ifle +938 -> 1118
    //   183: new 95	java/lang/StringBuilder
    //   186: dup
    //   187: ldc_w 380
    //   190: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   193: aload_1
    //   194: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc_w 382
    //   200: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: astore 20
    //   208: aload 20
    //   210: astore_1
    //   211: aload 7
    //   213: ifnull +56 -> 269
    //   216: new 95	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   223: aload 20
    //   225: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: astore 21
    //   230: aload 20
    //   232: invokevirtual 378	java/lang/String:length	()I
    //   235: ifle +890 -> 1125
    //   238: ldc_w 319
    //   241: astore_1
    //   242: aload 21
    //   244: aload_1
    //   245: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: ldc_w 384
    //   251: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload 7
    //   256: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: ldc_w 325
    //   262: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: astore_1
    //   269: aload_1
    //   270: astore 7
    //   272: iload 8
    //   274: iflt +55 -> 329
    //   277: new 95	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   284: aload_1
    //   285: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: astore 7
    //   290: aload_1
    //   291: invokevirtual 378	java/lang/String:length	()I
    //   294: ifle +837 -> 1131
    //   297: ldc_w 319
    //   300: astore_1
    //   301: aload 7
    //   303: aload_1
    //   304: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: ldc_w 386
    //   310: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: iload 8
    //   315: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   318: ldc_w 388
    //   321: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: astore 7
    //   329: aload 7
    //   331: astore_1
    //   332: iload 9
    //   334: iflt +56 -> 390
    //   337: new 95	java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   344: aload 7
    //   346: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: astore 20
    //   351: aload 7
    //   353: invokevirtual 378	java/lang/String:length	()I
    //   356: ifle +781 -> 1137
    //   359: ldc_w 319
    //   362: astore_1
    //   363: aload 20
    //   365: aload_1
    //   366: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: ldc_w 390
    //   372: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: iload 9
    //   377: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   380: ldc_w 388
    //   383: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: astore_1
    //   390: aload_1
    //   391: astore 7
    //   393: iload 10
    //   395: iflt +55 -> 450
    //   398: new 95	java/lang/StringBuilder
    //   401: dup
    //   402: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   405: aload_1
    //   406: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: astore 7
    //   411: aload_1
    //   412: invokevirtual 378	java/lang/String:length	()I
    //   415: ifle +728 -> 1143
    //   418: ldc_w 319
    //   421: astore_1
    //   422: aload 7
    //   424: aload_1
    //   425: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: ldc_w 392
    //   431: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: iload 10
    //   436: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   439: ldc_w 388
    //   442: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: astore 7
    //   450: aload 7
    //   452: astore_1
    //   453: iload 11
    //   455: iflt +56 -> 511
    //   458: new 95	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   465: aload 7
    //   467: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: astore 20
    //   472: aload 7
    //   474: invokevirtual 378	java/lang/String:length	()I
    //   477: ifle +672 -> 1149
    //   480: ldc_w 319
    //   483: astore_1
    //   484: aload 20
    //   486: aload_1
    //   487: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: ldc_w 394
    //   493: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: iload 11
    //   498: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   501: ldc_w 388
    //   504: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   510: astore_1
    //   511: aload_1
    //   512: astore 7
    //   514: lload 12
    //   516: lconst_0
    //   517: lcmp
    //   518: iflt +54 -> 572
    //   521: new 95	java/lang/StringBuilder
    //   524: dup
    //   525: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   528: aload_1
    //   529: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: astore 7
    //   534: aload_1
    //   535: invokevirtual 378	java/lang/String:length	()I
    //   538: ifle +617 -> 1155
    //   541: ldc_w 319
    //   544: astore_1
    //   545: aload 7
    //   547: aload_1
    //   548: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: ldc 143
    //   553: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: lload 12
    //   558: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   561: ldc_w 388
    //   564: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: astore 7
    //   572: aload 7
    //   574: astore_1
    //   575: lload 14
    //   577: lconst_0
    //   578: lcmp
    //   579: iflt +56 -> 635
    //   582: new 95	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   589: aload 7
    //   591: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: astore 20
    //   596: aload 7
    //   598: invokevirtual 378	java/lang/String:length	()I
    //   601: ifle +560 -> 1161
    //   604: ldc_w 319
    //   607: astore_1
    //   608: aload 20
    //   610: aload_1
    //   611: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: ldc_w 396
    //   617: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: lload 14
    //   622: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   625: ldc_w 388
    //   628: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   634: astore_1
    //   635: aload_1
    //   636: astore 7
    //   638: iload 16
    //   640: iflt +55 -> 695
    //   643: new 95	java/lang/StringBuilder
    //   646: dup
    //   647: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   650: aload_1
    //   651: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: astore 7
    //   656: aload_1
    //   657: invokevirtual 378	java/lang/String:length	()I
    //   660: ifle +507 -> 1167
    //   663: ldc_w 319
    //   666: astore_1
    //   667: aload 7
    //   669: aload_1
    //   670: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: ldc_w 398
    //   676: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: iload 16
    //   681: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   684: ldc_w 388
    //   687: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   693: astore 7
    //   695: ldc 160
    //   697: astore_1
    //   698: iload_2
    //   699: tableswitch	default:+21 -> 720, 1:+474->1173, 2:+499->1198
    //   721: tableswitch	default:+23 -> 744, 1:+502->1223, 2:+526->1247
    //   745: ldc_w 400
    //   748: invokevirtual 404	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   751: ifeq +1437 -> 2188
    //   754: aload_1
    //   755: iconst_0
    //   756: aload_1
    //   757: invokevirtual 378	java/lang/String:length	()I
    //   760: iconst_3
    //   761: isub
    //   762: invokevirtual 407	java/lang/String:substring	(II)Ljava/lang/String;
    //   765: astore_1
    //   766: ldc_w 409
    //   769: iconst_1
    //   770: anewarray 4	java/lang/Object
    //   773: dup
    //   774: iconst_0
    //   775: aload 7
    //   777: aastore
    //   778: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   781: pop
    //   782: aconst_null
    //   783: astore 23
    //   785: aconst_null
    //   786: astore 20
    //   788: aconst_null
    //   789: astore 22
    //   791: new 338	java/util/ArrayList
    //   794: dup
    //   795: invokespecial 339	java/util/ArrayList:<init>	()V
    //   798: astore 24
    //   800: new 68	com/tencent/feedback/proguard/n
    //   803: dup
    //   804: aload_0
    //   805: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   808: astore 21
    //   810: aload 21
    //   812: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   815: astore_0
    //   816: lload 18
    //   818: lconst_0
    //   819: lcmp
    //   820: ifle +1100 -> 1920
    //   823: aload_1
    //   824: astore 20
    //   826: aload_1
    //   827: invokevirtual 378	java/lang/String:length	()I
    //   830: ifle +25 -> 855
    //   833: new 95	java/lang/StringBuilder
    //   836: dup
    //   837: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   840: aload_1
    //   841: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: ldc_w 400
    //   847: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   850: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   853: astore 20
    //   855: new 95	java/lang/StringBuilder
    //   858: dup
    //   859: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   862: aload 20
    //   864: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: ldc_w 411
    //   870: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   876: astore 23
    //   878: iload 6
    //   880: iflt +391 -> 1271
    //   883: new 95	java/lang/StringBuilder
    //   886: dup
    //   887: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   890: iload 6
    //   892: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   895: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   898: astore_1
    //   899: aload_0
    //   900: ldc 176
    //   902: iconst_2
    //   903: anewarray 164	java/lang/String
    //   906: dup
    //   907: iconst_0
    //   908: ldc_w 262
    //   911: aastore
    //   912: dup
    //   913: iconst_1
    //   914: ldc_w 285
    //   917: aastore
    //   918: aload 7
    //   920: aconst_null
    //   921: aconst_null
    //   922: aconst_null
    //   923: aload 23
    //   925: aload_1
    //   926: invokevirtual 336	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   929: astore 20
    //   931: aload 20
    //   933: astore 7
    //   935: aload 20
    //   937: astore_1
    //   938: aload 20
    //   940: ldc_w 262
    //   943: invokeinterface 208 2 0
    //   948: istore_2
    //   949: aload 20
    //   951: astore 7
    //   953: aload 20
    //   955: astore_1
    //   956: aload 20
    //   958: ldc_w 285
    //   961: invokeinterface 208 2 0
    //   966: istore_3
    //   967: aload 20
    //   969: astore 7
    //   971: aload 20
    //   973: astore_1
    //   974: new 413	java/util/LinkedHashMap
    //   977: dup
    //   978: invokespecial 414	java/util/LinkedHashMap:<init>	()V
    //   981: astore 22
    //   983: aload 20
    //   985: astore 7
    //   987: aload 20
    //   989: astore_1
    //   990: aload 20
    //   992: invokeinterface 202 1 0
    //   997: ifeq +279 -> 1276
    //   1000: aload 20
    //   1002: astore 7
    //   1004: aload 20
    //   1006: astore_1
    //   1007: aload 22
    //   1009: aload 20
    //   1011: iload_2
    //   1012: invokeinterface 418 2 0
    //   1017: invokestatic 265	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1020: aload 20
    //   1022: iload_3
    //   1023: invokeinterface 418 2 0
    //   1028: invokestatic 265	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1031: invokevirtual 421	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1034: pop
    //   1035: goto -52 -> 983
    //   1038: astore_1
    //   1039: aload_0
    //   1040: astore 20
    //   1042: aload 21
    //   1044: astore_0
    //   1045: aload_1
    //   1046: invokevirtual 125	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1049: iconst_0
    //   1050: anewarray 4	java/lang/Object
    //   1053: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1056: pop
    //   1057: aload 7
    //   1059: ifnull +20 -> 1079
    //   1062: aload 7
    //   1064: invokeinterface 217 1 0
    //   1069: ifne +10 -> 1079
    //   1072: aload 7
    //   1074: invokeinterface 218 1 0
    //   1079: aload 20
    //   1081: ifnull +16 -> 1097
    //   1084: aload 20
    //   1086: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   1089: ifeq +8 -> 1097
    //   1092: aload 20
    //   1094: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   1097: aload_0
    //   1098: ifnull +7 -> 1105
    //   1101: aload_0
    //   1102: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   1105: ldc_w 423
    //   1108: iconst_0
    //   1109: anewarray 4	java/lang/Object
    //   1112: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1115: pop
    //   1116: aconst_null
    //   1117: areturn
    //   1118: ldc 160
    //   1120: astore 20
    //   1122: goto -914 -> 208
    //   1125: ldc 160
    //   1127: astore_1
    //   1128: goto -886 -> 242
    //   1131: ldc 160
    //   1133: astore_1
    //   1134: goto -833 -> 301
    //   1137: ldc 160
    //   1139: astore_1
    //   1140: goto -777 -> 363
    //   1143: ldc 160
    //   1145: astore_1
    //   1146: goto -724 -> 422
    //   1149: ldc 160
    //   1151: astore_1
    //   1152: goto -668 -> 484
    //   1155: ldc 160
    //   1157: astore_1
    //   1158: goto -613 -> 545
    //   1161: ldc 160
    //   1163: astore_1
    //   1164: goto -556 -> 608
    //   1167: ldc 160
    //   1169: astore_1
    //   1170: goto -503 -> 667
    //   1173: new 95	java/lang/StringBuilder
    //   1176: dup
    //   1177: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1180: ldc 160
    //   1182: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1185: ldc_w 425
    //   1188: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1191: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1194: astore_1
    //   1195: goto -475 -> 720
    //   1198: new 95	java/lang/StringBuilder
    //   1201: dup
    //   1202: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1205: ldc 160
    //   1207: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1210: ldc_w 427
    //   1213: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1216: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1219: astore_1
    //   1220: goto -500 -> 720
    //   1223: new 95	java/lang/StringBuilder
    //   1226: dup
    //   1227: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1230: aload_1
    //   1231: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1234: ldc_w 429
    //   1237: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1243: astore_1
    //   1244: goto -500 -> 744
    //   1247: new 95	java/lang/StringBuilder
    //   1250: dup
    //   1251: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1254: aload_1
    //   1255: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1258: ldc_w 431
    //   1261: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1264: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1267: astore_1
    //   1268: goto -524 -> 744
    //   1271: aconst_null
    //   1272: astore_1
    //   1273: goto -374 -> 899
    //   1276: aload 20
    //   1278: astore 7
    //   1280: aload 20
    //   1282: astore_1
    //   1283: aload 20
    //   1285: invokeinterface 218 1 0
    //   1290: aload 20
    //   1292: astore 7
    //   1294: aload 20
    //   1296: astore_1
    //   1297: aload 22
    //   1299: lload 18
    //   1301: invokestatic 436	com/tencent/feedback/proguard/a:a	(Ljava/util/LinkedHashMap;J)[Ljava/lang/Long;
    //   1304: astore 22
    //   1306: aload 22
    //   1308: ifnull +557 -> 1865
    //   1311: aload 20
    //   1313: astore 7
    //   1315: aload 20
    //   1317: astore_1
    //   1318: aload 22
    //   1320: arraylength
    //   1321: ifle +544 -> 1865
    //   1324: aload 20
    //   1326: astore 7
    //   1328: aload 20
    //   1330: astore_1
    //   1331: new 95	java/lang/StringBuilder
    //   1334: dup
    //   1335: ldc_w 438
    //   1338: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1341: aload 22
    //   1343: arraylength
    //   1344: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1347: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1350: iconst_0
    //   1351: anewarray 4	java/lang/Object
    //   1354: invokestatic 141	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1357: pop
    //   1358: aload 20
    //   1360: astore 7
    //   1362: aload 20
    //   1364: astore_1
    //   1365: new 227	java/lang/StringBuffer
    //   1368: dup
    //   1369: invokespecial 228	java/lang/StringBuffer:<init>	()V
    //   1372: astore 25
    //   1374: iconst_0
    //   1375: istore_2
    //   1376: aload 20
    //   1378: astore 7
    //   1380: aload 20
    //   1382: astore_1
    //   1383: iload_2
    //   1384: aload 22
    //   1386: arraylength
    //   1387: if_icmpge +217 -> 1604
    //   1390: aload 20
    //   1392: astore 7
    //   1394: aload 20
    //   1396: astore_1
    //   1397: aload 22
    //   1399: iload_2
    //   1400: aaload
    //   1401: invokevirtual 234	java/lang/Long:longValue	()J
    //   1404: lstore 4
    //   1406: aload 20
    //   1408: astore 7
    //   1410: aload 20
    //   1412: astore_1
    //   1413: aload 25
    //   1415: new 95	java/lang/StringBuilder
    //   1418: dup
    //   1419: ldc 236
    //   1421: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1424: lload 4
    //   1426: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1429: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1432: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1435: pop
    //   1436: iload_2
    //   1437: ifle +745 -> 2182
    //   1440: iload_2
    //   1441: bipush 50
    //   1443: irem
    //   1444: ifne +738 -> 2182
    //   1447: aload 20
    //   1449: astore 7
    //   1451: aload 20
    //   1453: astore_1
    //   1454: new 95	java/lang/StringBuilder
    //   1457: dup
    //   1458: ldc 241
    //   1460: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1463: iload_2
    //   1464: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1467: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1470: iconst_0
    //   1471: anewarray 4	java/lang/Object
    //   1474: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1477: pop
    //   1478: aload 20
    //   1480: astore 7
    //   1482: aload 20
    //   1484: astore_1
    //   1485: aload 25
    //   1487: iconst_4
    //   1488: invokevirtual 242	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   1491: astore 26
    //   1493: aload 20
    //   1495: astore 7
    //   1497: aload 20
    //   1499: astore_1
    //   1500: aload 25
    //   1502: iconst_0
    //   1503: invokevirtual 246	java/lang/StringBuffer:setLength	(I)V
    //   1506: aload 20
    //   1508: astore 7
    //   1510: aload 20
    //   1512: astore_1
    //   1513: aload_0
    //   1514: ldc 176
    //   1516: aconst_null
    //   1517: aload 26
    //   1519: aconst_null
    //   1520: aconst_null
    //   1521: aconst_null
    //   1522: aload 23
    //   1524: invokevirtual 197	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1527: astore 20
    //   1529: aload 20
    //   1531: astore_1
    //   1532: aload_1
    //   1533: invokestatic 441	com/tencent/feedback/proguard/l:a	(Landroid/database/Cursor;)Ljava/util/List;
    //   1536: astore 7
    //   1538: aload 7
    //   1540: ifnull +48 -> 1588
    //   1543: aload 7
    //   1545: invokeinterface 364 1 0
    //   1550: ifle +38 -> 1588
    //   1553: aload 24
    //   1555: aload 7
    //   1557: invokeinterface 445 2 0
    //   1562: pop
    //   1563: new 95	java/lang/StringBuilder
    //   1566: dup
    //   1567: ldc_w 447
    //   1570: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1573: iconst_0
    //   1574: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1577: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1580: iconst_0
    //   1581: anewarray 4	java/lang/Object
    //   1584: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1587: pop
    //   1588: aload_1
    //   1589: invokeinterface 218 1 0
    //   1594: iload_2
    //   1595: iconst_1
    //   1596: iadd
    //   1597: istore_2
    //   1598: aload_1
    //   1599: astore 20
    //   1601: goto -225 -> 1376
    //   1604: aload 20
    //   1606: astore 7
    //   1608: aload 20
    //   1610: astore 22
    //   1612: aload 20
    //   1614: astore_1
    //   1615: aload 25
    //   1617: invokevirtual 252	java/lang/StringBuffer:length	()I
    //   1620: ifle +151 -> 1771
    //   1623: aload 20
    //   1625: astore 7
    //   1627: aload 20
    //   1629: astore_1
    //   1630: aload 25
    //   1632: iconst_4
    //   1633: invokevirtual 242	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   1636: astore 22
    //   1638: aload 20
    //   1640: astore 7
    //   1642: aload 20
    //   1644: astore_1
    //   1645: aload 25
    //   1647: iconst_0
    //   1648: invokevirtual 246	java/lang/StringBuffer:setLength	(I)V
    //   1651: aload 20
    //   1653: astore 7
    //   1655: aload 20
    //   1657: astore_1
    //   1658: aload_0
    //   1659: ldc 176
    //   1661: aconst_null
    //   1662: aload 22
    //   1664: aconst_null
    //   1665: aconst_null
    //   1666: aconst_null
    //   1667: aload 23
    //   1669: invokevirtual 197	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1672: astore 20
    //   1674: aload 20
    //   1676: astore 7
    //   1678: aload 20
    //   1680: astore_1
    //   1681: aload 20
    //   1683: invokestatic 441	com/tencent/feedback/proguard/l:a	(Landroid/database/Cursor;)Ljava/util/List;
    //   1686: astore 23
    //   1688: aload 20
    //   1690: astore 22
    //   1692: aload 23
    //   1694: ifnull +77 -> 1771
    //   1697: aload 20
    //   1699: astore 7
    //   1701: aload 20
    //   1703: astore 22
    //   1705: aload 20
    //   1707: astore_1
    //   1708: aload 23
    //   1710: invokeinterface 364 1 0
    //   1715: ifle +56 -> 1771
    //   1718: aload 20
    //   1720: astore 7
    //   1722: aload 20
    //   1724: astore_1
    //   1725: aload 24
    //   1727: aload 23
    //   1729: invokeinterface 445 2 0
    //   1734: pop
    //   1735: aload 20
    //   1737: astore 7
    //   1739: aload 20
    //   1741: astore_1
    //   1742: new 95	java/lang/StringBuilder
    //   1745: dup
    //   1746: ldc_w 447
    //   1749: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1752: iconst_0
    //   1753: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1756: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1759: iconst_0
    //   1760: anewarray 4	java/lang/Object
    //   1763: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1766: pop
    //   1767: aload 20
    //   1769: astore 22
    //   1771: aload 22
    //   1773: astore 7
    //   1775: aload 22
    //   1777: astore_1
    //   1778: new 95	java/lang/StringBuilder
    //   1781: dup
    //   1782: ldc_w 449
    //   1785: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1788: aload 24
    //   1790: invokeinterface 364 1 0
    //   1795: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1798: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1801: iconst_0
    //   1802: anewarray 4	java/lang/Object
    //   1805: invokestatic 141	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1808: pop
    //   1809: aload 22
    //   1811: ifnull +20 -> 1831
    //   1814: aload 22
    //   1816: invokeinterface 217 1 0
    //   1821: ifne +10 -> 1831
    //   1824: aload 22
    //   1826: invokeinterface 218 1 0
    //   1831: aload_0
    //   1832: ifnull +14 -> 1846
    //   1835: aload_0
    //   1836: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   1839: ifeq +7 -> 1846
    //   1842: aload_0
    //   1843: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   1846: aload 21
    //   1848: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   1851: ldc_w 423
    //   1854: iconst_0
    //   1855: anewarray 4	java/lang/Object
    //   1858: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1861: pop
    //   1862: aload 24
    //   1864: areturn
    //   1865: aload 20
    //   1867: ifnull +20 -> 1887
    //   1870: aload 20
    //   1872: invokeinterface 217 1 0
    //   1877: ifne +10 -> 1887
    //   1880: aload 20
    //   1882: invokeinterface 218 1 0
    //   1887: aload_0
    //   1888: ifnull +14 -> 1902
    //   1891: aload_0
    //   1892: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   1895: ifeq +7 -> 1902
    //   1898: aload_0
    //   1899: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   1902: aload 21
    //   1904: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   1907: ldc_w 423
    //   1910: iconst_0
    //   1911: anewarray 4	java/lang/Object
    //   1914: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1917: pop
    //   1918: aconst_null
    //   1919: areturn
    //   1920: aload_0
    //   1921: ldc 176
    //   1923: aconst_null
    //   1924: aload 7
    //   1926: aconst_null
    //   1927: aconst_null
    //   1928: aconst_null
    //   1929: aload_1
    //   1930: invokevirtual 197	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1933: astore 20
    //   1935: aload 20
    //   1937: astore 7
    //   1939: aload 20
    //   1941: astore_1
    //   1942: aload 20
    //   1944: invokestatic 441	com/tencent/feedback/proguard/l:a	(Landroid/database/Cursor;)Ljava/util/List;
    //   1947: astore 22
    //   1949: aload 20
    //   1951: ifnull +20 -> 1971
    //   1954: aload 20
    //   1956: invokeinterface 217 1 0
    //   1961: ifne +10 -> 1971
    //   1964: aload 20
    //   1966: invokeinterface 218 1 0
    //   1971: aload_0
    //   1972: ifnull +14 -> 1986
    //   1975: aload_0
    //   1976: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   1979: ifeq +7 -> 1986
    //   1982: aload_0
    //   1983: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   1986: aload 21
    //   1988: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   1991: ldc_w 423
    //   1994: iconst_0
    //   1995: anewarray 4	java/lang/Object
    //   1998: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   2001: pop
    //   2002: aload 22
    //   2004: areturn
    //   2005: astore_0
    //   2006: aconst_null
    //   2007: astore 21
    //   2009: aconst_null
    //   2010: astore_1
    //   2011: aload_1
    //   2012: ifnull +18 -> 2030
    //   2015: aload_1
    //   2016: invokeinterface 217 1 0
    //   2021: ifne +9 -> 2030
    //   2024: aload_1
    //   2025: invokeinterface 218 1 0
    //   2030: aload 20
    //   2032: ifnull +16 -> 2048
    //   2035: aload 20
    //   2037: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   2040: ifeq +8 -> 2048
    //   2043: aload 20
    //   2045: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   2048: aload 21
    //   2050: ifnull +8 -> 2058
    //   2053: aload 21
    //   2055: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   2058: ldc_w 423
    //   2061: iconst_0
    //   2062: anewarray 4	java/lang/Object
    //   2065: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   2068: pop
    //   2069: aload_0
    //   2070: athrow
    //   2071: astore_0
    //   2072: aconst_null
    //   2073: astore_1
    //   2074: goto -63 -> 2011
    //   2077: astore 7
    //   2079: aconst_null
    //   2080: astore_1
    //   2081: aload_0
    //   2082: astore 20
    //   2084: aload 7
    //   2086: astore_0
    //   2087: goto -76 -> 2011
    //   2090: astore 7
    //   2092: aload_0
    //   2093: astore 20
    //   2095: aload 7
    //   2097: astore_0
    //   2098: goto -87 -> 2011
    //   2101: astore 7
    //   2103: aload_0
    //   2104: astore 20
    //   2106: aload 7
    //   2108: astore_0
    //   2109: goto -98 -> 2011
    //   2112: astore_1
    //   2113: aload_0
    //   2114: astore 21
    //   2116: aload_1
    //   2117: astore_0
    //   2118: aload 7
    //   2120: astore_1
    //   2121: goto -110 -> 2011
    //   2124: astore_1
    //   2125: aconst_null
    //   2126: astore 7
    //   2128: aload 23
    //   2130: astore_0
    //   2131: aload 22
    //   2133: astore 20
    //   2135: goto -1090 -> 1045
    //   2138: astore_1
    //   2139: aload 21
    //   2141: astore_0
    //   2142: aconst_null
    //   2143: astore 7
    //   2145: aload 22
    //   2147: astore 20
    //   2149: goto -1104 -> 1045
    //   2152: astore_1
    //   2153: aconst_null
    //   2154: astore 7
    //   2156: aload_0
    //   2157: astore 20
    //   2159: aload 21
    //   2161: astore_0
    //   2162: goto -1117 -> 1045
    //   2165: astore 22
    //   2167: aload_1
    //   2168: astore 7
    //   2170: aload_0
    //   2171: astore 20
    //   2173: aload 22
    //   2175: astore_1
    //   2176: aload 21
    //   2178: astore_0
    //   2179: goto -1134 -> 1045
    //   2182: aload 20
    //   2184: astore_1
    //   2185: goto -591 -> 1594
    //   2188: goto -1422 -> 766
    //   2191: ldc 160
    //   2193: astore_1
    //   2194: goto -2018 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2197	0	paramContext	Context
    //   0	2197	1	paramArrayOfInt	int[]
    //   0	2197	2	paramInt1	int
    //   0	2197	3	paramInt2	int
    //   0	2197	4	paramLong1	long
    //   0	2197	6	paramInt3	int
    //   0	2197	7	paramString	String
    //   0	2197	8	paramInt4	int
    //   0	2197	9	paramInt5	int
    //   0	2197	10	paramInt6	int
    //   0	2197	11	paramInt7	int
    //   0	2197	12	paramLong2	long
    //   0	2197	14	paramLong3	long
    //   0	2197	16	paramInt8	int
    //   104	43	17	k	int
    //   76	1224	18	l	long
    //   101	2082	20	localObject1	Object
    //   228	1949	21	localObject2	Object
    //   789	1357	22	localObject3	Object
    //   2165	9	22	localThrowable	Throwable
    //   783	1346	23	localObject4	Object
    //   798	1065	24	localArrayList	ArrayList
    //   1372	274	25	localStringBuffer	java.lang.StringBuffer
    //   1491	27	26	str	String
    // Exception table:
    //   from	to	target	type
    //   938	949	1038	java/lang/Throwable
    //   956	967	1038	java/lang/Throwable
    //   974	983	1038	java/lang/Throwable
    //   990	1000	1038	java/lang/Throwable
    //   1007	1035	1038	java/lang/Throwable
    //   1283	1290	1038	java/lang/Throwable
    //   1297	1306	1038	java/lang/Throwable
    //   1318	1324	1038	java/lang/Throwable
    //   1331	1358	1038	java/lang/Throwable
    //   1365	1374	1038	java/lang/Throwable
    //   1383	1390	1038	java/lang/Throwable
    //   1397	1406	1038	java/lang/Throwable
    //   1413	1436	1038	java/lang/Throwable
    //   1454	1478	1038	java/lang/Throwable
    //   1485	1493	1038	java/lang/Throwable
    //   1500	1506	1038	java/lang/Throwable
    //   1513	1529	1038	java/lang/Throwable
    //   1615	1623	1038	java/lang/Throwable
    //   1630	1638	1038	java/lang/Throwable
    //   1645	1651	1038	java/lang/Throwable
    //   1658	1674	1038	java/lang/Throwable
    //   1681	1688	1038	java/lang/Throwable
    //   1708	1718	1038	java/lang/Throwable
    //   1725	1735	1038	java/lang/Throwable
    //   1742	1767	1038	java/lang/Throwable
    //   1778	1809	1038	java/lang/Throwable
    //   1942	1949	1038	java/lang/Throwable
    //   800	810	2005	finally
    //   810	816	2071	finally
    //   826	855	2077	finally
    //   855	878	2077	finally
    //   883	899	2077	finally
    //   899	931	2077	finally
    //   1920	1935	2077	finally
    //   938	949	2090	finally
    //   956	967	2090	finally
    //   974	983	2090	finally
    //   990	1000	2090	finally
    //   1007	1035	2090	finally
    //   1283	1290	2090	finally
    //   1297	1306	2090	finally
    //   1318	1324	2090	finally
    //   1331	1358	2090	finally
    //   1365	1374	2090	finally
    //   1383	1390	2090	finally
    //   1397	1406	2090	finally
    //   1413	1436	2090	finally
    //   1454	1478	2090	finally
    //   1485	1493	2090	finally
    //   1500	1506	2090	finally
    //   1513	1529	2090	finally
    //   1615	1623	2090	finally
    //   1630	1638	2090	finally
    //   1645	1651	2090	finally
    //   1658	1674	2090	finally
    //   1681	1688	2090	finally
    //   1708	1718	2090	finally
    //   1725	1735	2090	finally
    //   1742	1767	2090	finally
    //   1778	1809	2090	finally
    //   1942	1949	2090	finally
    //   1532	1538	2101	finally
    //   1543	1588	2101	finally
    //   1588	1594	2101	finally
    //   1045	1057	2112	finally
    //   800	810	2124	java/lang/Throwable
    //   810	816	2138	java/lang/Throwable
    //   826	855	2152	java/lang/Throwable
    //   855	878	2152	java/lang/Throwable
    //   883	899	2152	java/lang/Throwable
    //   899	931	2152	java/lang/Throwable
    //   1920	1935	2152	java/lang/Throwable
    //   1532	1538	2165	java/lang/Throwable
    //   1543	1588	2165	java/lang/Throwable
    //   1588	1594	2165	java/lang/Throwable
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
    //   3: ldc_w 473
    //   6: iconst_0
    //   7: anewarray 4	java/lang/Object
    //   10: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   13: pop
    //   14: aload_0
    //   15: ifnull +7 -> 22
    //   18: aload_1
    //   19: ifnonnull +16 -> 35
    //   22: ldc_w 475
    //   25: iconst_0
    //   26: anewarray 4	java/lang/Object
    //   29: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   32: pop
    //   33: iconst_0
    //   34: ireturn
    //   35: aload_1
    //   36: invokeinterface 364 1 0
    //   41: ifgt +16 -> 57
    //   44: ldc_w 477
    //   47: iconst_0
    //   48: anewarray 4	java/lang/Object
    //   51: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   54: pop
    //   55: iconst_1
    //   56: ireturn
    //   57: new 68	com/tencent/feedback/proguard/n
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   65: astore 5
    //   67: aload 5
    //   69: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   72: astore_0
    //   73: aload_0
    //   74: astore 6
    //   76: iconst_0
    //   77: istore_2
    //   78: iload_2
    //   79: aload_1
    //   80: invokeinterface 364 1 0
    //   85: if_icmpge +94 -> 179
    //   88: aload_1
    //   89: iload_2
    //   90: invokeinterface 481 2 0
    //   95: checkcast 2	com/tencent/feedback/proguard/l
    //   98: astore_0
    //   99: aload 6
    //   101: ldc 176
    //   103: ldc_w 262
    //   106: aload_0
    //   107: invokestatic 483	com/tencent/feedback/proguard/l:a	(Lcom/tencent/feedback/proguard/l;)Landroid/content/ContentValues;
    //   110: invokevirtual 487	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   113: lstore_3
    //   114: lload_3
    //   115: lconst_0
    //   116: lcmp
    //   117: ifge +50 -> 167
    //   120: ldc_w 489
    //   123: iconst_0
    //   124: anewarray 4	java/lang/Object
    //   127: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   130: pop
    //   131: aload 6
    //   133: ifnull +16 -> 149
    //   136: aload 6
    //   138: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   141: ifeq +8 -> 149
    //   144: aload 6
    //   146: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   149: aload 5
    //   151: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   154: ldc_w 491
    //   157: iconst_0
    //   158: anewarray 4	java/lang/Object
    //   161: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   164: pop
    //   165: iconst_0
    //   166: ireturn
    //   167: aload_0
    //   168: lload_3
    //   169: putfield 26	com/tencent/feedback/proguard/l:a	J
    //   172: iload_2
    //   173: iconst_1
    //   174: iadd
    //   175: istore_2
    //   176: goto -98 -> 78
    //   179: aload 6
    //   181: ifnull +16 -> 197
    //   184: aload 6
    //   186: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   189: ifeq +8 -> 197
    //   192: aload 6
    //   194: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   197: aload 5
    //   199: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   202: ldc_w 491
    //   205: iconst_0
    //   206: anewarray 4	java/lang/Object
    //   209: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   212: pop
    //   213: iconst_1
    //   214: ireturn
    //   215: astore_0
    //   216: aconst_null
    //   217: astore_0
    //   218: aload 6
    //   220: astore_1
    //   221: ldc_w 493
    //   224: iconst_0
    //   225: anewarray 4	java/lang/Object
    //   228: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   231: pop
    //   232: aload_1
    //   233: ifnull +14 -> 247
    //   236: aload_1
    //   237: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   240: ifeq +7 -> 247
    //   243: aload_1
    //   244: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   247: aload_0
    //   248: ifnull +7 -> 255
    //   251: aload_0
    //   252: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   255: ldc_w 491
    //   258: iconst_0
    //   259: anewarray 4	java/lang/Object
    //   262: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   265: pop
    //   266: iconst_0
    //   267: ireturn
    //   268: astore_0
    //   269: aconst_null
    //   270: astore_1
    //   271: aconst_null
    //   272: astore 5
    //   274: aload_1
    //   275: ifnull +14 -> 289
    //   278: aload_1
    //   279: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   282: ifeq +7 -> 289
    //   285: aload_1
    //   286: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   289: aload 5
    //   291: ifnull +8 -> 299
    //   294: aload 5
    //   296: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   299: ldc_w 491
    //   302: iconst_0
    //   303: anewarray 4	java/lang/Object
    //   306: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   309: pop
    //   310: aload_0
    //   311: athrow
    //   312: astore_0
    //   313: aconst_null
    //   314: astore_1
    //   315: goto -41 -> 274
    //   318: astore_0
    //   319: aload 6
    //   321: astore_1
    //   322: goto -48 -> 274
    //   325: astore 6
    //   327: aload_0
    //   328: astore 5
    //   330: aload 6
    //   332: astore_0
    //   333: goto -59 -> 274
    //   336: astore_0
    //   337: aload 5
    //   339: astore_0
    //   340: aload 6
    //   342: astore_1
    //   343: goto -122 -> 221
    //   346: astore_0
    //   347: aload 6
    //   349: astore_1
    //   350: aload 5
    //   352: astore_0
    //   353: goto -132 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	paramContext	Context
    //   0	356	1	paramList	List<l>
    //   77	99	2	k	int
    //   113	56	3	l	long
    //   65	286	5	localObject1	Object
    //   1	319	6	localContext	Context
    //   325	23	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   57	67	215	java/lang/Throwable
    //   57	67	268	finally
    //   67	73	312	finally
    //   78	114	318	finally
    //   120	131	318	finally
    //   167	172	318	finally
    //   221	232	325	finally
    //   67	73	336	java/lang/Throwable
    //   78	114	346	java/lang/Throwable
    //   120	131	346	java/lang/Throwable
    //   167	172	346	java/lang/Throwable
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
      if (!e.a(paramCursor)) {
        paramCursor.printStackTrace();
      }
      e.d("rqdp{  Error:getFileBean fail!}", new Object[0]);
      e.d("rqdp{  Error: getFileBean fail!}", new Object[0]);
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
    //   12: ldc_w 530
    //   15: iconst_0
    //   16: anewarray 4	java/lang/Object
    //   19: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   22: pop
    //   23: aload_0
    //   24: ifnull +16 -> 40
    //   27: aload_1
    //   28: ifnull +12 -> 40
    //   31: aload_1
    //   32: invokeinterface 364 1 0
    //   37: ifgt +16 -> 53
    //   40: ldc_w 532
    //   43: iconst_0
    //   44: anewarray 4	java/lang/Object
    //   47: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   50: pop
    //   51: iconst_0
    //   52: ireturn
    //   53: new 68	com/tencent/feedback/proguard/n
    //   56: dup
    //   57: aload_0
    //   58: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   61: astore 6
    //   63: aload 8
    //   65: astore 5
    //   67: aload 4
    //   69: astore_0
    //   70: aload 6
    //   72: astore 4
    //   74: aload 6
    //   76: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   79: astore 7
    //   81: aload 7
    //   83: astore 5
    //   85: aload 7
    //   87: astore_0
    //   88: aload 6
    //   90: astore 4
    //   92: aload_1
    //   93: invokeinterface 536 1 0
    //   98: astore_1
    //   99: aload 7
    //   101: astore 5
    //   103: aload 7
    //   105: astore_0
    //   106: aload 6
    //   108: astore 4
    //   110: aload_1
    //   111: invokeinterface 541 1 0
    //   116: ifeq +299 -> 415
    //   119: aload 7
    //   121: astore 5
    //   123: aload 7
    //   125: astore_0
    //   126: aload 6
    //   128: astore 4
    //   130: aload_1
    //   131: invokeinterface 545 1 0
    //   136: checkcast 2	com/tencent/feedback/proguard/l
    //   139: astore 8
    //   141: aload 7
    //   143: astore 5
    //   145: aload 7
    //   147: astore_0
    //   148: aload 6
    //   150: astore 4
    //   152: aload 8
    //   154: invokestatic 483	com/tencent/feedback/proguard/l:a	(Lcom/tencent/feedback/proguard/l;)Landroid/content/ContentValues;
    //   157: astore 9
    //   159: aload 9
    //   161: ifnonnull +39 -> 200
    //   164: aload 7
    //   166: ifnull +16 -> 182
    //   169: aload 7
    //   171: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   174: ifeq +8 -> 182
    //   177: aload 7
    //   179: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   182: aload 6
    //   184: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   187: ldc_w 547
    //   190: iconst_0
    //   191: anewarray 4	java/lang/Object
    //   194: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   197: pop
    //   198: iconst_0
    //   199: ireturn
    //   200: aload 7
    //   202: astore 5
    //   204: aload 7
    //   206: astore_0
    //   207: aload 6
    //   209: astore 4
    //   211: aload 7
    //   213: ldc 176
    //   215: ldc_w 262
    //   218: aload 9
    //   220: invokevirtual 550	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   223: lstore_2
    //   224: lload_2
    //   225: lconst_0
    //   226: lcmp
    //   227: ifge +61 -> 288
    //   230: aload 7
    //   232: astore 5
    //   234: aload 7
    //   236: astore_0
    //   237: aload 6
    //   239: astore 4
    //   241: ldc_w 552
    //   244: iconst_0
    //   245: anewarray 4	java/lang/Object
    //   248: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   251: pop
    //   252: aload 7
    //   254: ifnull +16 -> 270
    //   257: aload 7
    //   259: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   262: ifeq +8 -> 270
    //   265: aload 7
    //   267: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   270: aload 6
    //   272: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   275: ldc_w 547
    //   278: iconst_0
    //   279: anewarray 4	java/lang/Object
    //   282: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   285: pop
    //   286: iconst_0
    //   287: ireturn
    //   288: aload 7
    //   290: astore 5
    //   292: aload 7
    //   294: astore_0
    //   295: aload 6
    //   297: astore 4
    //   299: new 95	java/lang/StringBuilder
    //   302: dup
    //   303: ldc_w 554
    //   306: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   309: lload_2
    //   310: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   313: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: iconst_0
    //   317: anewarray 4	java/lang/Object
    //   320: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   323: pop
    //   324: aload 7
    //   326: astore 5
    //   328: aload 7
    //   330: astore_0
    //   331: aload 6
    //   333: astore 4
    //   335: aload 8
    //   337: lload_2
    //   338: putfield 26	com/tencent/feedback/proguard/l:a	J
    //   341: goto -242 -> 99
    //   344: astore_0
    //   345: aload 6
    //   347: astore_1
    //   348: aload_0
    //   349: astore 6
    //   351: aload 5
    //   353: astore_0
    //   354: aload_1
    //   355: astore 4
    //   357: aload 6
    //   359: invokestatic 128	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   362: ifne +14 -> 376
    //   365: aload 5
    //   367: astore_0
    //   368: aload_1
    //   369: astore 4
    //   371: aload 6
    //   373: invokevirtual 131	java/lang/Throwable:printStackTrace	()V
    //   376: aload 5
    //   378: ifnull +16 -> 394
    //   381: aload 5
    //   383: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   386: ifeq +8 -> 394
    //   389: aload 5
    //   391: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   394: aload_1
    //   395: ifnull +7 -> 402
    //   398: aload_1
    //   399: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   402: ldc_w 547
    //   405: iconst_0
    //   406: anewarray 4	java/lang/Object
    //   409: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   412: pop
    //   413: iconst_0
    //   414: ireturn
    //   415: aload 7
    //   417: ifnull +16 -> 433
    //   420: aload 7
    //   422: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   425: ifeq +8 -> 433
    //   428: aload 7
    //   430: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   433: aload 6
    //   435: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   438: ldc_w 547
    //   441: iconst_0
    //   442: anewarray 4	java/lang/Object
    //   445: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   448: pop
    //   449: iconst_1
    //   450: ireturn
    //   451: astore_1
    //   452: aconst_null
    //   453: astore 4
    //   455: aload 7
    //   457: astore_0
    //   458: aload_0
    //   459: ifnull +14 -> 473
    //   462: aload_0
    //   463: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   466: ifeq +7 -> 473
    //   469: aload_0
    //   470: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   473: aload 4
    //   475: ifnull +8 -> 483
    //   478: aload 4
    //   480: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   483: ldc_w 547
    //   486: iconst_0
    //   487: anewarray 4	java/lang/Object
    //   490: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   493: pop
    //   494: aload_1
    //   495: athrow
    //   496: astore_1
    //   497: goto -39 -> 458
    //   500: astore 6
    //   502: aconst_null
    //   503: astore_1
    //   504: goto -153 -> 351
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	507	0	paramContext	Context
    //   0	507	1	paramList	List<l>
    //   223	115	2	l	long
    //   7	472	4	localObject1	Object
    //   1	389	5	localObject2	Object
    //   61	373	6	localObject3	Object
    //   500	1	6	localThrowable	Throwable
    //   4	452	7	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   10	326	8	locall	l
    //   157	62	9	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   74	81	344	java/lang/Throwable
    //   92	99	344	java/lang/Throwable
    //   110	119	344	java/lang/Throwable
    //   130	141	344	java/lang/Throwable
    //   152	159	344	java/lang/Throwable
    //   211	224	344	java/lang/Throwable
    //   241	252	344	java/lang/Throwable
    //   299	324	344	java/lang/Throwable
    //   335	341	344	java/lang/Throwable
    //   53	63	451	finally
    //   74	81	496	finally
    //   92	99	496	finally
    //   110	119	496	finally
    //   130	141	496	finally
    //   152	159	496	finally
    //   211	224	496	finally
    //   241	252	496	finally
    //   299	324	496	finally
    //   335	341	496	finally
    //   357	365	496	finally
    //   371	376	496	finally
    //   53	63	500	java/lang/Throwable
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
    //   9: invokeinterface 364 1 0
    //   14: ifne +51 -> 65
    //   17: aload_1
    //   18: ifnonnull +24 -> 42
    //   21: ldc_w 557
    //   24: astore_0
    //   25: ldc_w 559
    //   28: iconst_1
    //   29: anewarray 4	java/lang/Object
    //   32: dup
    //   33: iconst_0
    //   34: aload_0
    //   35: aastore
    //   36: invokestatic 56	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   39: pop
    //   40: iconst_m1
    //   41: ireturn
    //   42: new 95	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   49: aload_1
    //   50: invokeinterface 364 1 0
    //   55: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   58: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore_0
    //   62: goto -37 -> 25
    //   65: ldc_w 561
    //   68: iconst_1
    //   69: anewarray 4	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: aload_1
    //   75: invokeinterface 364 1 0
    //   80: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   83: aastore
    //   84: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   87: pop
    //   88: aconst_null
    //   89: astore 11
    //   91: aconst_null
    //   92: astore 13
    //   94: aconst_null
    //   95: astore 10
    //   97: aconst_null
    //   98: astore 14
    //   100: iconst_0
    //   101: istore 5
    //   103: iconst_0
    //   104: istore 4
    //   106: iconst_0
    //   107: istore_2
    //   108: iconst_0
    //   109: istore 6
    //   111: iconst_0
    //   112: istore_3
    //   113: new 68	com/tencent/feedback/proguard/n
    //   116: dup
    //   117: aload_0
    //   118: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   121: astore 12
    //   123: iload 5
    //   125: istore 4
    //   127: aload 14
    //   129: astore 11
    //   131: iload 6
    //   133: istore_2
    //   134: aload 10
    //   136: astore_0
    //   137: aload 12
    //   139: astore 10
    //   141: aload 12
    //   143: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   146: astore 13
    //   148: aload 13
    //   150: ifnonnull +104 -> 254
    //   153: iload 5
    //   155: istore 4
    //   157: aload 13
    //   159: astore 11
    //   161: iload 6
    //   163: istore_2
    //   164: aload 13
    //   166: astore_0
    //   167: aload 12
    //   169: astore 10
    //   171: ldc_w 311
    //   174: iconst_0
    //   175: anewarray 4	java/lang/Object
    //   178: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   181: pop
    //   182: iload 5
    //   184: istore 4
    //   186: aload 13
    //   188: astore 11
    //   190: iload 6
    //   192: istore_2
    //   193: aload 13
    //   195: astore_0
    //   196: aload 12
    //   198: astore 10
    //   200: ldc_w 563
    //   203: iconst_0
    //   204: anewarray 4	java/lang/Object
    //   207: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   210: pop
    //   211: aload 13
    //   213: ifnull +16 -> 229
    //   216: aload 13
    //   218: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   221: ifeq +8 -> 229
    //   224: aload 13
    //   226: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   229: aload 12
    //   231: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   234: ldc_w 565
    //   237: iconst_1
    //   238: anewarray 4	java/lang/Object
    //   241: dup
    //   242: iconst_0
    //   243: iconst_0
    //   244: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   247: aastore
    //   248: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   251: pop
    //   252: iconst_m1
    //   253: ireturn
    //   254: iload 5
    //   256: istore 4
    //   258: aload 13
    //   260: astore 11
    //   262: iload 6
    //   264: istore_2
    //   265: aload 13
    //   267: astore_0
    //   268: aload 12
    //   270: astore 10
    //   272: aload_1
    //   273: invokeinterface 536 1 0
    //   278: astore 14
    //   280: iload_3
    //   281: istore 4
    //   283: aload 13
    //   285: astore 11
    //   287: iload_3
    //   288: istore_2
    //   289: aload 13
    //   291: astore_0
    //   292: aload 12
    //   294: astore 10
    //   296: aload 14
    //   298: invokeinterface 541 1 0
    //   303: ifeq +533 -> 836
    //   306: iload_3
    //   307: istore 4
    //   309: aload 13
    //   311: astore 11
    //   313: iload_3
    //   314: istore_2
    //   315: aload 13
    //   317: astore_0
    //   318: aload 12
    //   320: astore 10
    //   322: aload 14
    //   324: invokeinterface 545 1 0
    //   329: checkcast 346	com/tencent/feedback/proguard/o
    //   332: astore 15
    //   334: aload 15
    //   336: ifnonnull +152 -> 488
    //   339: aconst_null
    //   340: astore_1
    //   341: iload_3
    //   342: istore_2
    //   343: aload_1
    //   344: ifnull +598 -> 942
    //   347: iload_3
    //   348: istore 4
    //   350: aload 13
    //   352: astore 11
    //   354: iload_3
    //   355: istore_2
    //   356: aload 13
    //   358: astore_0
    //   359: aload 12
    //   361: astore 10
    //   363: aload 13
    //   365: ldc 110
    //   367: ldc_w 262
    //   370: aload_1
    //   371: invokevirtual 487	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   374: lstore 7
    //   376: iload_3
    //   377: istore 4
    //   379: aload 13
    //   381: astore 11
    //   383: iload_3
    //   384: istore_2
    //   385: aload 13
    //   387: astore_0
    //   388: aload 12
    //   390: astore 10
    //   392: aload 15
    //   394: lload 7
    //   396: invokevirtual 510	com/tencent/feedback/proguard/o:a	(J)V
    //   399: lload 7
    //   401: lconst_0
    //   402: lcmp
    //   403: iflt +422 -> 825
    //   406: iconst_1
    //   407: istore_2
    //   408: iload_3
    //   409: iload_2
    //   410: iadd
    //   411: istore_3
    //   412: iload_3
    //   413: istore 4
    //   415: aload 13
    //   417: astore 11
    //   419: iload_3
    //   420: istore_2
    //   421: aload 13
    //   423: astore_0
    //   424: aload 12
    //   426: astore 10
    //   428: aload 15
    //   430: invokevirtual 348	com/tencent/feedback/proguard/o:a	()Ljava/lang/String;
    //   433: astore_1
    //   434: lload 7
    //   436: lconst_0
    //   437: lcmp
    //   438: iflt +392 -> 830
    //   441: iconst_1
    //   442: istore 9
    //   444: iload_3
    //   445: istore 4
    //   447: aload 13
    //   449: astore 11
    //   451: iload_3
    //   452: istore_2
    //   453: aload 13
    //   455: astore_0
    //   456: aload 12
    //   458: astore 10
    //   460: ldc_w 567
    //   463: iconst_2
    //   464: anewarray 4	java/lang/Object
    //   467: dup
    //   468: iconst_0
    //   469: aload_1
    //   470: aastore
    //   471: dup
    //   472: iconst_1
    //   473: iload 9
    //   475: invokestatic 572	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   478: aastore
    //   479: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   482: pop
    //   483: iload_3
    //   484: istore_2
    //   485: goto +457 -> 942
    //   488: iload_3
    //   489: istore 4
    //   491: aload 13
    //   493: astore 11
    //   495: iload_3
    //   496: istore_2
    //   497: aload 13
    //   499: astore_0
    //   500: aload 12
    //   502: astore 10
    //   504: new 259	android/content/ContentValues
    //   507: dup
    //   508: invokespecial 260	android/content/ContentValues:<init>	()V
    //   511: astore_1
    //   512: iload_3
    //   513: istore 4
    //   515: aload 13
    //   517: astore 11
    //   519: iload_3
    //   520: istore_2
    //   521: aload 13
    //   523: astore_0
    //   524: aload 12
    //   526: astore 10
    //   528: aload_1
    //   529: ldc_w 321
    //   532: aload 15
    //   534: invokevirtual 348	com/tencent/feedback/proguard/o:a	()Ljava/lang/String;
    //   537: invokevirtual 290	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   540: iload_3
    //   541: istore 4
    //   543: aload 13
    //   545: astore 11
    //   547: iload_3
    //   548: istore_2
    //   549: aload 13
    //   551: astore_0
    //   552: aload 12
    //   554: astore 10
    //   556: aload_1
    //   557: ldc_w 505
    //   560: aload 15
    //   562: invokevirtual 350	com/tencent/feedback/proguard/o:d	()Ljava/lang/String;
    //   565: invokevirtual 290	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   568: iload_3
    //   569: istore 4
    //   571: aload 13
    //   573: astore 11
    //   575: iload_3
    //   576: istore_2
    //   577: aload 13
    //   579: astore_0
    //   580: aload 12
    //   582: astore 10
    //   584: aload_1
    //   585: ldc_w 514
    //   588: aload 15
    //   590: invokevirtual 574	com/tencent/feedback/proguard/o:c	()J
    //   593: invokestatic 265	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   596: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   599: iload_3
    //   600: istore 4
    //   602: aload 13
    //   604: astore 11
    //   606: iload_3
    //   607: istore_2
    //   608: aload 13
    //   610: astore_0
    //   611: aload 12
    //   613: astore 10
    //   615: aload_1
    //   616: ldc_w 518
    //   619: aload 15
    //   621: invokevirtual 576	com/tencent/feedback/proguard/o:b	()J
    //   624: invokestatic 265	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   627: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   630: iload_3
    //   631: istore 4
    //   633: aload 13
    //   635: astore 11
    //   637: iload_3
    //   638: istore_2
    //   639: aload 13
    //   641: astore_0
    //   642: aload 12
    //   644: astore 10
    //   646: aload_1
    //   647: ldc_w 327
    //   650: aload 15
    //   652: invokevirtual 351	com/tencent/feedback/proguard/o:e	()I
    //   655: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   658: invokevirtual 274	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   661: iload_3
    //   662: istore 4
    //   664: aload 13
    //   666: astore 11
    //   668: iload_3
    //   669: istore_2
    //   670: aload 13
    //   672: astore_0
    //   673: aload 12
    //   675: astore 10
    //   677: aload_1
    //   678: ldc_w 522
    //   681: aload 15
    //   683: invokevirtual 353	com/tencent/feedback/proguard/o:f	()Ljava/lang/String;
    //   686: invokevirtual 290	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   689: goto -348 -> 341
    //   692: astore_0
    //   693: aload 12
    //   695: astore_1
    //   696: aload_0
    //   697: astore 12
    //   699: iload 4
    //   701: istore_2
    //   702: aload 11
    //   704: astore_0
    //   705: aload_1
    //   706: astore 10
    //   708: ldc 120
    //   710: iconst_0
    //   711: anewarray 4	java/lang/Object
    //   714: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   717: pop
    //   718: iload 4
    //   720: istore_2
    //   721: aload 11
    //   723: astore_0
    //   724: aload_1
    //   725: astore 10
    //   727: ldc_w 578
    //   730: iconst_1
    //   731: anewarray 4	java/lang/Object
    //   734: dup
    //   735: iconst_0
    //   736: aload 12
    //   738: invokevirtual 125	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   741: aastore
    //   742: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   745: pop
    //   746: iload 4
    //   748: istore_2
    //   749: aload 11
    //   751: astore_0
    //   752: aload_1
    //   753: astore 10
    //   755: aload 12
    //   757: invokestatic 128	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   760: ifne +17 -> 777
    //   763: iload 4
    //   765: istore_2
    //   766: aload 11
    //   768: astore_0
    //   769: aload_1
    //   770: astore 10
    //   772: aload 12
    //   774: invokevirtual 131	java/lang/Throwable:printStackTrace	()V
    //   777: aload 11
    //   779: ifnull +16 -> 795
    //   782: aload 11
    //   784: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   787: ifeq +8 -> 795
    //   790: aload 11
    //   792: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   795: aload_1
    //   796: ifnull +7 -> 803
    //   799: aload_1
    //   800: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   803: ldc_w 565
    //   806: iconst_1
    //   807: anewarray 4	java/lang/Object
    //   810: dup
    //   811: iconst_0
    //   812: iload 4
    //   814: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   817: aastore
    //   818: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   821: pop
    //   822: iload 4
    //   824: ireturn
    //   825: iconst_0
    //   826: istore_2
    //   827: goto -419 -> 408
    //   830: iconst_0
    //   831: istore 9
    //   833: goto -389 -> 444
    //   836: aload 13
    //   838: ifnull +16 -> 854
    //   841: aload 13
    //   843: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   846: ifeq +8 -> 854
    //   849: aload 13
    //   851: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   854: aload 12
    //   856: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   859: ldc_w 565
    //   862: iconst_1
    //   863: anewarray 4	java/lang/Object
    //   866: dup
    //   867: iconst_0
    //   868: iload_3
    //   869: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   872: aastore
    //   873: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   876: pop
    //   877: iload_3
    //   878: ireturn
    //   879: astore_1
    //   880: aconst_null
    //   881: astore 10
    //   883: aload 13
    //   885: astore_0
    //   886: aload_0
    //   887: ifnull +14 -> 901
    //   890: aload_0
    //   891: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   894: ifeq +7 -> 901
    //   897: aload_0
    //   898: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   901: aload 10
    //   903: ifnull +8 -> 911
    //   906: aload 10
    //   908: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   911: ldc_w 565
    //   914: iconst_1
    //   915: anewarray 4	java/lang/Object
    //   918: dup
    //   919: iconst_0
    //   920: iload_2
    //   921: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   924: aastore
    //   925: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   928: pop
    //   929: aload_1
    //   930: athrow
    //   931: astore_1
    //   932: goto -46 -> 886
    //   935: astore 12
    //   937: aconst_null
    //   938: astore_1
    //   939: goto -240 -> 699
    //   942: iload_2
    //   943: istore_3
    //   944: goto -664 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	947	0	paramContext	Context
    //   0	947	1	paramList	List<o>
    //   107	836	2	k	int
    //   112	832	3	m	int
    //   104	719	4	n	int
    //   101	154	5	i1	int
    //   109	154	6	i2	int
    //   374	61	7	l	long
    //   442	390	9	bool	boolean
    //   95	812	10	localObject1	Object
    //   89	702	11	localObject2	Object
    //   121	734	12	localObject3	Object
    //   935	1	12	localThrowable	Throwable
    //   92	792	13	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   98	225	14	localIterator	java.util.Iterator
    //   332	350	15	localo	o
    // Exception table:
    //   from	to	target	type
    //   141	148	692	java/lang/Throwable
    //   171	182	692	java/lang/Throwable
    //   200	211	692	java/lang/Throwable
    //   272	280	692	java/lang/Throwable
    //   296	306	692	java/lang/Throwable
    //   322	334	692	java/lang/Throwable
    //   363	376	692	java/lang/Throwable
    //   392	399	692	java/lang/Throwable
    //   428	434	692	java/lang/Throwable
    //   460	483	692	java/lang/Throwable
    //   504	512	692	java/lang/Throwable
    //   528	540	692	java/lang/Throwable
    //   556	568	692	java/lang/Throwable
    //   584	599	692	java/lang/Throwable
    //   615	630	692	java/lang/Throwable
    //   646	661	692	java/lang/Throwable
    //   677	689	692	java/lang/Throwable
    //   113	123	879	finally
    //   141	148	931	finally
    //   171	182	931	finally
    //   200	211	931	finally
    //   272	280	931	finally
    //   296	306	931	finally
    //   322	334	931	finally
    //   363	376	931	finally
    //   392	399	931	finally
    //   428	434	931	finally
    //   460	483	931	finally
    //   504	512	931	finally
    //   528	540	931	finally
    //   556	568	931	finally
    //   584	599	931	finally
    //   615	630	931	finally
    //   646	661	931	finally
    //   677	689	931	finally
    //   708	718	931	finally
    //   727	746	931	finally
    //   755	763	931	finally
    //   772	777	931	finally
    //   113	123	935	java/lang/Throwable
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
    //   21: invokeinterface 364 1 0
    //   26: ifne +51 -> 77
    //   29: aload_1
    //   30: ifnonnull +24 -> 54
    //   33: ldc_w 557
    //   36: astore_0
    //   37: ldc_w 581
    //   40: iconst_1
    //   41: anewarray 4	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: aload_0
    //   47: aastore
    //   48: invokestatic 56	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   51: pop
    //   52: iconst_m1
    //   53: ireturn
    //   54: new 95	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   61: aload_1
    //   62: invokeinterface 364 1 0
    //   67: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: astore_0
    //   74: goto -37 -> 37
    //   77: ldc_w 583
    //   80: iconst_1
    //   81: anewarray 4	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: aload_1
    //   87: invokeinterface 364 1 0
    //   92: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   95: aastore
    //   96: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   99: pop
    //   100: new 68	com/tencent/feedback/proguard/n
    //   103: dup
    //   104: aload_0
    //   105: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   108: astore 4
    //   110: aload 8
    //   112: astore 5
    //   114: aload 7
    //   116: astore 6
    //   118: aload 4
    //   120: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   123: astore_0
    //   124: aload_0
    //   125: ifnonnull +76 -> 201
    //   128: aload_0
    //   129: astore 5
    //   131: aload_0
    //   132: astore 6
    //   134: ldc 77
    //   136: iconst_0
    //   137: anewarray 4	java/lang/Object
    //   140: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   143: pop
    //   144: aload_0
    //   145: astore 5
    //   147: aload_0
    //   148: astore 6
    //   150: ldc_w 585
    //   153: iconst_0
    //   154: anewarray 4	java/lang/Object
    //   157: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   160: pop
    //   161: aload_0
    //   162: ifnull +14 -> 176
    //   165: aload_0
    //   166: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   169: ifeq +7 -> 176
    //   172: aload_0
    //   173: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   176: aload 4
    //   178: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   181: ldc_w 587
    //   184: iconst_1
    //   185: anewarray 4	java/lang/Object
    //   188: dup
    //   189: iconst_0
    //   190: iconst_0
    //   191: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   194: aastore
    //   195: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   198: pop
    //   199: iconst_m1
    //   200: ireturn
    //   201: aload_0
    //   202: astore 5
    //   204: aload_0
    //   205: astore 6
    //   207: new 227	java/lang/StringBuffer
    //   210: dup
    //   211: invokespecial 228	java/lang/StringBuffer:<init>	()V
    //   214: astore 7
    //   216: aload_0
    //   217: astore 5
    //   219: aload_0
    //   220: astore 6
    //   222: aload_1
    //   223: invokeinterface 536 1 0
    //   228: astore_1
    //   229: aload_0
    //   230: astore 5
    //   232: aload_0
    //   233: astore 6
    //   235: aload_1
    //   236: invokeinterface 541 1 0
    //   241: ifeq +289 -> 530
    //   244: aload_0
    //   245: astore 5
    //   247: aload_0
    //   248: astore 6
    //   250: aload_1
    //   251: invokeinterface 545 1 0
    //   256: checkcast 346	com/tencent/feedback/proguard/o
    //   259: astore 8
    //   261: aload_0
    //   262: astore 5
    //   264: aload_0
    //   265: astore 6
    //   267: aload 7
    //   269: ldc_w 589
    //   272: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   275: pop
    //   276: aload_0
    //   277: astore 5
    //   279: aload_0
    //   280: astore 6
    //   282: aload 7
    //   284: ldc_w 321
    //   287: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   290: pop
    //   291: aload_0
    //   292: astore 5
    //   294: aload_0
    //   295: astore 6
    //   297: aload 7
    //   299: ldc_w 323
    //   302: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   305: pop
    //   306: aload_0
    //   307: astore 5
    //   309: aload_0
    //   310: astore 6
    //   312: aload 7
    //   314: aload 8
    //   316: invokevirtual 348	com/tencent/feedback/proguard/o:a	()Ljava/lang/String;
    //   319: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   322: pop
    //   323: aload_0
    //   324: astore 5
    //   326: aload_0
    //   327: astore 6
    //   329: aload 7
    //   331: ldc_w 591
    //   334: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   337: pop
    //   338: aload_0
    //   339: astore 5
    //   341: aload_0
    //   342: astore 6
    //   344: aload 7
    //   346: ldc_w 327
    //   349: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   352: pop
    //   353: aload_0
    //   354: astore 5
    //   356: aload_0
    //   357: astore 6
    //   359: aload 7
    //   361: ldc_w 329
    //   364: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   367: pop
    //   368: aload_0
    //   369: astore 5
    //   371: aload_0
    //   372: astore 6
    //   374: aload 7
    //   376: aload 8
    //   378: invokevirtual 351	com/tencent/feedback/proguard/o:e	()I
    //   381: invokevirtual 332	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   384: pop
    //   385: aload_0
    //   386: astore 5
    //   388: aload_0
    //   389: astore 6
    //   391: aload 7
    //   393: ldc_w 382
    //   396: invokevirtual 239	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   399: pop
    //   400: goto -171 -> 229
    //   403: astore 6
    //   405: iconst_0
    //   406: istore_2
    //   407: aload 5
    //   409: astore_0
    //   410: iload_2
    //   411: istore_3
    //   412: aload_0
    //   413: astore 5
    //   415: aload 4
    //   417: astore_1
    //   418: aload 6
    //   420: invokestatic 128	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   423: ifne +16 -> 439
    //   426: iload_2
    //   427: istore_3
    //   428: aload_0
    //   429: astore 5
    //   431: aload 4
    //   433: astore_1
    //   434: aload 6
    //   436: invokevirtual 131	java/lang/Throwable:printStackTrace	()V
    //   439: iload_2
    //   440: istore_3
    //   441: aload_0
    //   442: astore 5
    //   444: aload 4
    //   446: astore_1
    //   447: ldc_w 593
    //   450: iconst_0
    //   451: anewarray 4	java/lang/Object
    //   454: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   457: pop
    //   458: iload_2
    //   459: istore_3
    //   460: aload_0
    //   461: astore 5
    //   463: aload 4
    //   465: astore_1
    //   466: ldc_w 595
    //   469: iconst_1
    //   470: anewarray 4	java/lang/Object
    //   473: dup
    //   474: iconst_0
    //   475: aload 6
    //   477: invokevirtual 125	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   480: aastore
    //   481: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   484: pop
    //   485: aload_0
    //   486: ifnull +14 -> 500
    //   489: aload_0
    //   490: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   493: ifeq +7 -> 500
    //   496: aload_0
    //   497: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   500: aload 4
    //   502: ifnull +8 -> 510
    //   505: aload 4
    //   507: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   510: ldc_w 587
    //   513: iconst_1
    //   514: anewarray 4	java/lang/Object
    //   517: dup
    //   518: iconst_0
    //   519: iload_2
    //   520: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   523: aastore
    //   524: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   527: pop
    //   528: iload_2
    //   529: ireturn
    //   530: aload_0
    //   531: astore 5
    //   533: aload_0
    //   534: astore 6
    //   536: aload 7
    //   538: iconst_2
    //   539: invokevirtual 242	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   542: astore 7
    //   544: aload_0
    //   545: astore 5
    //   547: aload_0
    //   548: astore 6
    //   550: aload_0
    //   551: ldc 110
    //   553: aload 7
    //   555: aconst_null
    //   556: invokevirtual 114	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   559: istore_2
    //   560: iload_2
    //   561: istore_3
    //   562: aload_0
    //   563: astore 5
    //   565: aload 4
    //   567: astore_1
    //   568: ldc_w 597
    //   571: iconst_2
    //   572: anewarray 4	java/lang/Object
    //   575: dup
    //   576: iconst_0
    //   577: iload_2
    //   578: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   581: aastore
    //   582: dup
    //   583: iconst_1
    //   584: aload 7
    //   586: aastore
    //   587: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   590: pop
    //   591: aload_0
    //   592: ifnull +14 -> 606
    //   595: aload_0
    //   596: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   599: ifeq +7 -> 606
    //   602: aload_0
    //   603: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   606: aload 4
    //   608: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   611: ldc_w 587
    //   614: iconst_1
    //   615: anewarray 4	java/lang/Object
    //   618: dup
    //   619: iconst_0
    //   620: iload_2
    //   621: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   624: aastore
    //   625: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   628: pop
    //   629: iload_2
    //   630: ireturn
    //   631: astore_0
    //   632: iconst_0
    //   633: istore_2
    //   634: aconst_null
    //   635: astore_1
    //   636: aload 6
    //   638: astore 5
    //   640: aload 5
    //   642: ifnull +16 -> 658
    //   645: aload 5
    //   647: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   650: ifeq +8 -> 658
    //   653: aload 5
    //   655: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   658: aload_1
    //   659: ifnull +7 -> 666
    //   662: aload_1
    //   663: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   666: ldc_w 587
    //   669: iconst_1
    //   670: anewarray 4	java/lang/Object
    //   673: dup
    //   674: iconst_0
    //   675: iload_2
    //   676: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   679: aastore
    //   680: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   683: pop
    //   684: aload_0
    //   685: athrow
    //   686: astore_0
    //   687: iconst_0
    //   688: istore_2
    //   689: aload 6
    //   691: astore 5
    //   693: aload 4
    //   695: astore_1
    //   696: goto -56 -> 640
    //   699: astore_0
    //   700: iload_3
    //   701: istore_2
    //   702: goto -62 -> 640
    //   705: astore 6
    //   707: aconst_null
    //   708: astore 4
    //   710: iconst_0
    //   711: istore_2
    //   712: aload 5
    //   714: astore_0
    //   715: goto -305 -> 410
    //   718: astore 6
    //   720: goto -310 -> 410
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	723	0	paramContext	Context
    //   0	723	1	paramList	List<o>
    //   406	306	2	k	int
    //   411	290	3	m	int
    //   108	601	4	localn	n
    //   1	712	5	localObject1	Object
    //   4	386	6	localObject2	Object
    //   403	73	6	localThrowable1	Throwable
    //   534	156	6	localContext	Context
    //   705	1	6	localThrowable2	Throwable
    //   718	1	6	localThrowable3	Throwable
    //   7	578	7	localObject3	Object
    //   10	367	8	localo	o
    // Exception table:
    //   from	to	target	type
    //   118	124	403	java/lang/Throwable
    //   134	144	403	java/lang/Throwable
    //   150	161	403	java/lang/Throwable
    //   207	216	403	java/lang/Throwable
    //   222	229	403	java/lang/Throwable
    //   235	244	403	java/lang/Throwable
    //   250	261	403	java/lang/Throwable
    //   267	276	403	java/lang/Throwable
    //   282	291	403	java/lang/Throwable
    //   297	306	403	java/lang/Throwable
    //   312	323	403	java/lang/Throwable
    //   329	338	403	java/lang/Throwable
    //   344	353	403	java/lang/Throwable
    //   359	368	403	java/lang/Throwable
    //   374	385	403	java/lang/Throwable
    //   391	400	403	java/lang/Throwable
    //   536	544	403	java/lang/Throwable
    //   550	560	403	java/lang/Throwable
    //   100	110	631	finally
    //   118	124	686	finally
    //   134	144	686	finally
    //   150	161	686	finally
    //   207	216	686	finally
    //   222	229	686	finally
    //   235	244	686	finally
    //   250	261	686	finally
    //   267	276	686	finally
    //   282	291	686	finally
    //   297	306	686	finally
    //   312	323	686	finally
    //   329	338	686	finally
    //   344	353	686	finally
    //   359	368	686	finally
    //   374	385	686	finally
    //   391	400	686	finally
    //   536	544	686	finally
    //   550	560	686	finally
    //   418	426	699	finally
    //   434	439	699	finally
    //   447	458	699	finally
    //   466	485	699	finally
    //   568	591	699	finally
    //   100	110	705	java/lang/Throwable
    //   568	591	718	java/lang/Throwable
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