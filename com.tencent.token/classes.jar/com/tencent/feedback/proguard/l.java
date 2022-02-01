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
    //   112: aload_2
    //   113: ldc 95
    //   115: ldc 97
    //   117: aconst_null
    //   118: invokevirtual 101	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   121: istore_1
    //   122: ldc 103
    //   124: iconst_2
    //   125: anewarray 4	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: iload_1
    //   131: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   134: aastore
    //   135: dup
    //   136: iconst_1
    //   137: ldc 97
    //   139: aastore
    //   140: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   143: pop
    //   144: aload_2
    //   145: ifnull +14 -> 159
    //   148: aload_2
    //   149: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   152: ifeq +7 -> 159
    //   155: aload_2
    //   156: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   159: aload_0
    //   160: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   163: ldc 93
    //   165: iconst_1
    //   166: anewarray 4	java/lang/Object
    //   169: dup
    //   170: iconst_0
    //   171: iload_1
    //   172: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: aastore
    //   176: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   179: pop
    //   180: iload_1
    //   181: ireturn
    //   182: astore 4
    //   184: aload_0
    //   185: astore_3
    //   186: goto +166 -> 352
    //   189: astore 4
    //   191: goto +74 -> 265
    //   194: astore 4
    //   196: aload_0
    //   197: astore_3
    //   198: aload 4
    //   200: astore_0
    //   201: goto +43 -> 244
    //   204: astore 4
    //   206: aload_0
    //   207: astore_3
    //   208: aload 4
    //   210: astore_0
    //   211: goto +47 -> 258
    //   214: astore 4
    //   216: aconst_null
    //   217: astore_2
    //   218: aload_0
    //   219: astore_3
    //   220: aload 4
    //   222: astore_0
    //   223: goto +21 -> 244
    //   226: astore 5
    //   228: aload 4
    //   230: astore_2
    //   231: aload_0
    //   232: astore_3
    //   233: aload 5
    //   235: astore_0
    //   236: goto +22 -> 258
    //   239: astore_0
    //   240: aconst_null
    //   241: astore_2
    //   242: aload_2
    //   243: astore_3
    //   244: iconst_0
    //   245: istore_1
    //   246: aload_0
    //   247: astore 4
    //   249: goto +103 -> 352
    //   252: astore_0
    //   253: aconst_null
    //   254: astore_3
    //   255: aload 4
    //   257: astore_2
    //   258: iconst_0
    //   259: istore_1
    //   260: aload_0
    //   261: astore 4
    //   263: aload_3
    //   264: astore_0
    //   265: ldc 105
    //   267: iconst_0
    //   268: anewarray 4	java/lang/Object
    //   271: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   274: pop
    //   275: ldc 107
    //   277: iconst_1
    //   278: anewarray 4	java/lang/Object
    //   281: dup
    //   282: iconst_0
    //   283: aload 4
    //   285: invokevirtual 111	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   288: aastore
    //   289: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   292: pop
    //   293: aload 4
    //   295: invokestatic 114	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   298: ifne +8 -> 306
    //   301: aload 4
    //   303: invokevirtual 117	java/lang/Throwable:printStackTrace	()V
    //   306: aload_2
    //   307: ifnull +14 -> 321
    //   310: aload_2
    //   311: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   314: ifeq +7 -> 321
    //   317: aload_2
    //   318: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   321: aload_0
    //   322: ifnull +7 -> 329
    //   325: aload_0
    //   326: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   329: ldc 93
    //   331: iconst_1
    //   332: anewarray 4	java/lang/Object
    //   335: dup
    //   336: iconst_0
    //   337: iload_1
    //   338: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   341: aastore
    //   342: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   345: pop
    //   346: iload_1
    //   347: ireturn
    //   348: astore 4
    //   350: aload_0
    //   351: astore_3
    //   352: aload_2
    //   353: ifnull +14 -> 367
    //   356: aload_2
    //   357: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   360: ifeq +7 -> 367
    //   363: aload_2
    //   364: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   367: aload_3
    //   368: ifnull +7 -> 375
    //   371: aload_3
    //   372: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   375: ldc 93
    //   377: iconst_1
    //   378: anewarray 4	java/lang/Object
    //   381: dup
    //   382: iconst_0
    //   383: iload_1
    //   384: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   387: aastore
    //   388: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   391: pop
    //   392: aload 4
    //   394: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	paramContext	Context
    //   0	395	1	paramInt	int
    //   49	315	2	localObject1	Object
    //   185	187	3	localObject2	Object
    //   34	1	4	localObject3	Object
    //   182	1	4	localObject4	Object
    //   189	1	4	localThrowable1	Throwable
    //   194	5	4	localObject5	Object
    //   204	5	4	localThrowable2	Throwable
    //   214	15	4	localObject6	Object
    //   247	55	4	localContext	Context
    //   348	45	4	localObject7	Object
    //   226	8	5	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   122	144	182	finally
    //   122	144	189	java/lang/Throwable
    //   54	74	194	finally
    //   112	122	194	finally
    //   54	74	204	java/lang/Throwable
    //   112	122	204	java/lang/Throwable
    //   45	50	214	finally
    //   45	50	226	java/lang/Throwable
    //   36	45	239	finally
    //   36	45	252	java/lang/Throwable
    //   265	306	348	finally
  }
  
  public static int a(Context paramContext, int[] paramArrayOfInt, long paramLong1, long paramLong2)
  {
    return a(paramContext, paramArrayOfInt, paramLong1, paramLong2, -1, -1);
  }
  
  /* Error */
  public static int a(Context paramContext, int[] paramArrayOfInt, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 123
    //   2: iconst_0
    //   3: anewarray 4	java/lang/Object
    //   6: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   9: pop
    //   10: aload_0
    //   11: ifnonnull +15 -> 26
    //   14: ldc 125
    //   16: iconst_0
    //   17: anewarray 4	java/lang/Object
    //   20: invokestatic 127	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   23: pop
    //   24: iconst_m1
    //   25: ireturn
    //   26: lload_2
    //   27: lload 4
    //   29: lcmp
    //   30: ifle +5 -> 35
    //   33: iconst_0
    //   34: ireturn
    //   35: new 129	java/lang/StringBuilder
    //   38: dup
    //   39: ldc 131
    //   41: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   44: astore 8
    //   46: aload 8
    //   48: lload_2
    //   49: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 8
    //   55: ldc 140
    //   57: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 8
    //   63: lload 4
    //   65: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 8
    //   71: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore 8
    //   76: aload 8
    //   78: astore 9
    //   80: iload 6
    //   82: iflt +43 -> 125
    //   85: new 129	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   92: astore 9
    //   94: aload 9
    //   96: aload 8
    //   98: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 9
    //   104: ldc 149
    //   106: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 9
    //   112: iload 6
    //   114: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload 9
    //   120: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: astore 9
    //   125: aload 9
    //   127: astore 8
    //   129: iload 7
    //   131: iflt +43 -> 174
    //   134: new 129	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   141: astore 8
    //   143: aload 8
    //   145: aload 9
    //   147: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 8
    //   153: ldc 154
    //   155: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload 8
    //   161: iload 7
    //   163: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 8
    //   169: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: astore 8
    //   174: aload 8
    //   176: astore 10
    //   178: aload_1
    //   179: ifnull +131 -> 310
    //   182: aload 8
    //   184: astore 10
    //   186: aload_1
    //   187: arraylength
    //   188: ifle +122 -> 310
    //   191: ldc 156
    //   193: astore 9
    //   195: iconst_0
    //   196: istore 6
    //   198: iload 6
    //   200: aload_1
    //   201: arraylength
    //   202: if_icmpge +54 -> 256
    //   205: new 129	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   212: astore 10
    //   214: aload 10
    //   216: aload 9
    //   218: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload 10
    //   224: ldc 158
    //   226: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload 10
    //   232: aload_1
    //   233: iload 6
    //   235: iaload
    //   236: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 10
    //   242: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: astore 9
    //   247: iload 6
    //   249: iconst_1
    //   250: iadd
    //   251: istore 6
    //   253: goto -55 -> 198
    //   256: aload 9
    //   258: iconst_4
    //   259: invokevirtual 164	java/lang/String:substring	(I)Ljava/lang/String;
    //   262: astore_1
    //   263: new 129	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   270: astore 9
    //   272: aload 9
    //   274: aload 8
    //   276: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload 9
    //   282: ldc 166
    //   284: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 9
    //   290: aload_1
    //   291: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload 9
    //   297: ldc 168
    //   299: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload 9
    //   305: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: astore 10
    //   310: ldc 170
    //   312: aload 10
    //   314: invokestatic 173	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   317: invokevirtual 177	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   320: iconst_0
    //   321: anewarray 4	java/lang/Object
    //   324: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   327: pop
    //   328: new 68	com/tencent/feedback/proguard/n
    //   331: dup
    //   332: aload_0
    //   333: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   336: astore_1
    //   337: aload_1
    //   338: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   341: astore_0
    //   342: aload_0
    //   343: astore 8
    //   345: aload_1
    //   346: astore 9
    //   348: aload_0
    //   349: ldc 179
    //   351: aload 10
    //   353: aconst_null
    //   354: invokevirtual 101	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   357: istore 6
    //   359: aload_0
    //   360: astore 8
    //   362: aload_1
    //   363: astore 9
    //   365: ldc 181
    //   367: iload 6
    //   369: invokestatic 183	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   372: invokevirtual 177	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   375: iconst_0
    //   376: anewarray 4	java/lang/Object
    //   379: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   382: pop
    //   383: aload_0
    //   384: ifnull +14 -> 398
    //   387: aload_0
    //   388: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   391: ifeq +7 -> 398
    //   394: aload_0
    //   395: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   398: aload_1
    //   399: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   402: ldc 185
    //   404: iconst_0
    //   405: anewarray 4	java/lang/Object
    //   408: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   411: pop
    //   412: iload 6
    //   414: ireturn
    //   415: astore 10
    //   417: goto +32 -> 449
    //   420: astore_0
    //   421: aconst_null
    //   422: astore 8
    //   424: goto +83 -> 507
    //   427: astore 10
    //   429: aconst_null
    //   430: astore_0
    //   431: goto +18 -> 449
    //   434: astore_0
    //   435: aconst_null
    //   436: astore_1
    //   437: aload_1
    //   438: astore 8
    //   440: goto +67 -> 507
    //   443: astore 10
    //   445: aconst_null
    //   446: astore_1
    //   447: aload_1
    //   448: astore_0
    //   449: aload_0
    //   450: astore 8
    //   452: aload_1
    //   453: astore 9
    //   455: aload 10
    //   457: invokevirtual 111	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   460: iconst_0
    //   461: anewarray 4	java/lang/Object
    //   464: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   467: pop
    //   468: aload_0
    //   469: ifnull +14 -> 483
    //   472: aload_0
    //   473: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   476: ifeq +7 -> 483
    //   479: aload_0
    //   480: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   483: aload_1
    //   484: ifnull +7 -> 491
    //   487: aload_1
    //   488: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   491: ldc 185
    //   493: iconst_0
    //   494: anewarray 4	java/lang/Object
    //   497: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   500: pop
    //   501: iconst_m1
    //   502: ireturn
    //   503: astore_0
    //   504: aload 9
    //   506: astore_1
    //   507: aload 8
    //   509: ifnull +16 -> 525
    //   512: aload 8
    //   514: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   517: ifeq +8 -> 525
    //   520: aload 8
    //   522: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   525: aload_1
    //   526: ifnull +7 -> 533
    //   529: aload_1
    //   530: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   533: ldc 185
    //   535: iconst_0
    //   536: anewarray 4	java/lang/Object
    //   539: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   542: pop
    //   543: aload_0
    //   544: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	545	0	paramContext	Context
    //   0	545	1	paramArrayOfInt	int[]
    //   0	545	2	paramLong1	long
    //   0	545	4	paramLong2	long
    //   0	545	6	paramInt1	int
    //   0	545	7	paramInt2	int
    //   44	477	8	localObject1	Object
    //   78	427	9	localObject2	Object
    //   176	176	10	localObject3	Object
    //   415	1	10	localThrowable1	Throwable
    //   427	1	10	localThrowable2	Throwable
    //   443	13	10	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   348	359	415	java/lang/Throwable
    //   365	383	415	java/lang/Throwable
    //   337	342	420	finally
    //   337	342	427	java/lang/Throwable
    //   328	337	434	finally
    //   328	337	443	java/lang/Throwable
    //   348	359	503	finally
    //   365	383	503	finally
    //   455	468	503	finally
  }
  
  /* Error */
  public static int a(Context paramContext, int[] paramArrayOfInt, long paramLong1, long paramLong2, String paramString)
  {
    // Byte code:
    //   0: ldc 188
    //   2: iconst_0
    //   3: anewarray 4	java/lang/Object
    //   6: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   9: pop
    //   10: aload_0
    //   11: ifnonnull +15 -> 26
    //   14: ldc 190
    //   16: iconst_0
    //   17: anewarray 4	java/lang/Object
    //   20: invokestatic 127	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   23: pop
    //   24: iconst_m1
    //   25: ireturn
    //   26: lload_2
    //   27: lload 4
    //   29: lcmp
    //   30: ifle +5 -> 35
    //   33: iconst_0
    //   34: ireturn
    //   35: new 129	java/lang/StringBuilder
    //   38: dup
    //   39: ldc 131
    //   41: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   44: astore 8
    //   46: aload 8
    //   48: lload_2
    //   49: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 8
    //   55: ldc 140
    //   57: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 8
    //   63: lload 4
    //   65: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 8
    //   71: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore 9
    //   76: aload 9
    //   78: astore 8
    //   80: aload_1
    //   81: ifnull +131 -> 212
    //   84: aload 9
    //   86: astore 8
    //   88: aload_1
    //   89: arraylength
    //   90: ifle +122 -> 212
    //   93: ldc 156
    //   95: astore 8
    //   97: iconst_0
    //   98: istore 7
    //   100: iload 7
    //   102: aload_1
    //   103: arraylength
    //   104: if_icmpge +54 -> 158
    //   107: new 129	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   114: astore 10
    //   116: aload 10
    //   118: aload 8
    //   120: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 10
    //   126: ldc 158
    //   128: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 10
    //   134: aload_1
    //   135: iload 7
    //   137: iaload
    //   138: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload 10
    //   144: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: astore 8
    //   149: iload 7
    //   151: iconst_1
    //   152: iadd
    //   153: istore 7
    //   155: goto -55 -> 100
    //   158: aload 8
    //   160: iconst_4
    //   161: invokevirtual 164	java/lang/String:substring	(I)Ljava/lang/String;
    //   164: astore_1
    //   165: new 129	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   172: astore 8
    //   174: aload 8
    //   176: aload 9
    //   178: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 8
    //   184: ldc 166
    //   186: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 8
    //   192: aload_1
    //   193: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 8
    //   199: ldc 168
    //   201: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 8
    //   207: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: astore 8
    //   212: aload 6
    //   214: ifnull +48 -> 262
    //   217: new 129	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   224: astore_1
    //   225: aload_1
    //   226: aload 8
    //   228: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload_1
    //   233: ldc 192
    //   235: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload_1
    //   240: aload 6
    //   242: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload_1
    //   247: ldc 194
    //   249: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload_1
    //   254: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: astore 9
    //   259: goto +7 -> 266
    //   262: aload 8
    //   264: astore 9
    //   266: ldc 196
    //   268: aload 9
    //   270: invokestatic 173	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   273: invokevirtual 177	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   276: iconst_0
    //   277: anewarray 4	java/lang/Object
    //   280: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   283: pop
    //   284: aconst_null
    //   285: astore 10
    //   287: aconst_null
    //   288: astore 8
    //   290: aconst_null
    //   291: astore 6
    //   293: aconst_null
    //   294: astore 11
    //   296: new 68	com/tencent/feedback/proguard/n
    //   299: dup
    //   300: aload_0
    //   301: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   304: astore_1
    //   305: aload_1
    //   306: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   309: astore 12
    //   311: aload 11
    //   313: astore 10
    //   315: aload 8
    //   317: astore_0
    //   318: aload_1
    //   319: astore 6
    //   321: aload 12
    //   323: astore 8
    //   325: aload 12
    //   327: ldc 179
    //   329: iconst_1
    //   330: anewarray 160	java/lang/String
    //   333: dup
    //   334: iconst_0
    //   335: ldc 198
    //   337: aastore
    //   338: aload 9
    //   340: aconst_null
    //   341: aconst_null
    //   342: aconst_null
    //   343: aconst_null
    //   344: invokevirtual 202	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   347: astore 9
    //   349: aload 9
    //   351: astore 10
    //   353: aload 9
    //   355: astore_0
    //   356: aload_1
    //   357: astore 6
    //   359: aload 12
    //   361: astore 8
    //   363: aload 9
    //   365: invokeinterface 207 1 0
    //   370: pop
    //   371: aload 9
    //   373: astore 10
    //   375: aload 9
    //   377: astore_0
    //   378: aload_1
    //   379: astore 6
    //   381: aload 12
    //   383: astore 8
    //   385: aload 9
    //   387: aload 9
    //   389: ldc 209
    //   391: invokeinterface 213 2 0
    //   396: invokeinterface 217 2 0
    //   401: istore 7
    //   403: aload 9
    //   405: astore 10
    //   407: aload 9
    //   409: astore_0
    //   410: aload_1
    //   411: astore 6
    //   413: aload 12
    //   415: astore 8
    //   417: ldc 219
    //   419: iload 7
    //   421: invokestatic 183	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   424: invokevirtual 177	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   427: iconst_0
    //   428: anewarray 4	java/lang/Object
    //   431: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   434: pop
    //   435: aload 9
    //   437: ifnull +20 -> 457
    //   440: aload 9
    //   442: invokeinterface 222 1 0
    //   447: ifne +10 -> 457
    //   450: aload 9
    //   452: invokeinterface 223 1 0
    //   457: aload 12
    //   459: ifnull +16 -> 475
    //   462: aload 12
    //   464: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   467: ifeq +8 -> 475
    //   470: aload 12
    //   472: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   475: aload_1
    //   476: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   479: ldc 225
    //   481: iconst_0
    //   482: anewarray 4	java/lang/Object
    //   485: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   488: pop
    //   489: iload 7
    //   491: ireturn
    //   492: astore 9
    //   494: aload_1
    //   495: astore 11
    //   497: aload 12
    //   499: astore_1
    //   500: goto +39 -> 539
    //   503: astore_0
    //   504: aconst_null
    //   505: astore 8
    //   507: goto +125 -> 632
    //   510: astore 9
    //   512: aconst_null
    //   513: astore_0
    //   514: aload_1
    //   515: astore 11
    //   517: aload_0
    //   518: astore_1
    //   519: goto +20 -> 539
    //   522: astore_0
    //   523: aconst_null
    //   524: astore_1
    //   525: aload_1
    //   526: astore 8
    //   528: goto +104 -> 632
    //   531: astore 9
    //   533: aconst_null
    //   534: astore 11
    //   536: aload 11
    //   538: astore_1
    //   539: aload 10
    //   541: astore_0
    //   542: aload 11
    //   544: astore 6
    //   546: aload_1
    //   547: astore 8
    //   549: aload 9
    //   551: invokevirtual 111	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   554: iconst_0
    //   555: anewarray 4	java/lang/Object
    //   558: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   561: pop
    //   562: aload 10
    //   564: ifnull +20 -> 584
    //   567: aload 10
    //   569: invokeinterface 222 1 0
    //   574: ifne +10 -> 584
    //   577: aload 10
    //   579: invokeinterface 223 1 0
    //   584: aload_1
    //   585: ifnull +14 -> 599
    //   588: aload_1
    //   589: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   592: ifeq +7 -> 599
    //   595: aload_1
    //   596: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   599: aload 11
    //   601: ifnull +8 -> 609
    //   604: aload 11
    //   606: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   609: ldc 225
    //   611: iconst_0
    //   612: anewarray 4	java/lang/Object
    //   615: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   618: pop
    //   619: iconst_m1
    //   620: ireturn
    //   621: astore 9
    //   623: aload 6
    //   625: astore_1
    //   626: aload_0
    //   627: astore 6
    //   629: aload 9
    //   631: astore_0
    //   632: aload 6
    //   634: ifnull +20 -> 654
    //   637: aload 6
    //   639: invokeinterface 222 1 0
    //   644: ifne +10 -> 654
    //   647: aload 6
    //   649: invokeinterface 223 1 0
    //   654: aload 8
    //   656: ifnull +16 -> 672
    //   659: aload 8
    //   661: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   664: ifeq +8 -> 672
    //   667: aload 8
    //   669: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   672: aload_1
    //   673: ifnull +7 -> 680
    //   676: aload_1
    //   677: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   680: ldc 225
    //   682: iconst_0
    //   683: anewarray 4	java/lang/Object
    //   686: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   689: pop
    //   690: aload_0
    //   691: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	692	0	paramContext	Context
    //   0	692	1	paramArrayOfInt	int[]
    //   0	692	2	paramLong1	long
    //   0	692	4	paramLong2	long
    //   0	692	6	paramString	String
    //   98	392	7	k	int
    //   44	624	8	localObject1	Object
    //   74	377	9	localObject2	Object
    //   492	1	9	localThrowable1	Throwable
    //   510	1	9	localThrowable2	Throwable
    //   531	19	9	localThrowable3	Throwable
    //   621	9	9	localObject3	Object
    //   114	464	10	localObject4	Object
    //   294	311	11	arrayOfInt	int[]
    //   309	189	12	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   325	349	492	java/lang/Throwable
    //   363	371	492	java/lang/Throwable
    //   385	403	492	java/lang/Throwable
    //   417	435	492	java/lang/Throwable
    //   305	311	503	finally
    //   305	311	510	java/lang/Throwable
    //   296	305	522	finally
    //   296	305	531	java/lang/Throwable
    //   325	349	621	finally
    //   363	371	621	finally
    //   385	403	621	finally
    //   417	435	621	finally
    //   549	562	621	finally
  }
  
  /* Error */
  public static int a(Context paramContext, Long[] paramArrayOfLong)
  {
    // Byte code:
    //   0: ldc 228
    //   2: iconst_0
    //   3: anewarray 4	java/lang/Object
    //   6: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   9: pop
    //   10: aload_0
    //   11: ifnonnull +15 -> 26
    //   14: ldc 230
    //   16: iconst_0
    //   17: anewarray 4	java/lang/Object
    //   20: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   23: pop
    //   24: iconst_m1
    //   25: ireturn
    //   26: aload_1
    //   27: ifnull +385 -> 412
    //   30: aload_1
    //   31: arraylength
    //   32: ifgt +5 -> 37
    //   35: iconst_0
    //   36: ireturn
    //   37: aconst_null
    //   38: astore 6
    //   40: aconst_null
    //   41: astore 8
    //   43: new 68	com/tencent/feedback/proguard/n
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 71	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   51: astore_0
    //   52: aload_0
    //   53: astore 5
    //   55: aload_0
    //   56: invokevirtual 75	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   59: astore 7
    //   61: new 232	java/lang/StringBuffer
    //   64: dup
    //   65: invokespecial 233	java/lang/StringBuffer:<init>	()V
    //   68: astore 5
    //   70: iconst_0
    //   71: istore_3
    //   72: iconst_0
    //   73: istore_2
    //   74: iload_3
    //   75: aload_1
    //   76: arraylength
    //   77: if_icmpge +103 -> 180
    //   80: aload 5
    //   82: ldc 235
    //   84: aload_1
    //   85: iload_3
    //   86: aaload
    //   87: invokevirtual 241	java/lang/Long:longValue	()J
    //   90: invokestatic 244	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   93: invokevirtual 177	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   96: invokevirtual 247	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   99: pop
    //   100: iload_2
    //   101: istore 4
    //   103: iload_3
    //   104: ifle +310 -> 414
    //   107: iload_2
    //   108: istore 4
    //   110: iload_3
    //   111: bipush 50
    //   113: irem
    //   114: ifne +300 -> 414
    //   117: ldc 249
    //   119: iload_3
    //   120: invokestatic 183	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   123: invokevirtual 177	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   126: iconst_0
    //   127: anewarray 4	java/lang/Object
    //   130: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   133: pop
    //   134: iload_2
    //   135: aload 7
    //   137: ldc 179
    //   139: aload 5
    //   141: iconst_4
    //   142: invokevirtual 250	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   145: aconst_null
    //   146: invokevirtual 101	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   149: iadd
    //   150: istore 4
    //   152: aload 5
    //   154: iconst_0
    //   155: invokevirtual 254	java/lang/StringBuffer:setLength	(I)V
    //   158: ldc_w 256
    //   161: iload 4
    //   163: invokestatic 183	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   166: invokevirtual 177	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   169: iconst_0
    //   170: anewarray 4	java/lang/Object
    //   173: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   176: pop
    //   177: goto +237 -> 414
    //   180: iload_2
    //   181: istore_3
    //   182: aload 5
    //   184: invokevirtual 260	java/lang/StringBuffer:length	()I
    //   187: ifle +26 -> 213
    //   190: iload_2
    //   191: aload 7
    //   193: ldc 179
    //   195: aload 5
    //   197: iconst_4
    //   198: invokevirtual 250	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   201: aconst_null
    //   202: invokevirtual 101	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   205: iadd
    //   206: istore_3
    //   207: aload 5
    //   209: iconst_0
    //   210: invokevirtual 254	java/lang/StringBuffer:setLength	(I)V
    //   213: ldc_w 262
    //   216: iload_3
    //   217: invokestatic 183	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   220: invokevirtual 177	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   223: iconst_0
    //   224: anewarray 4	java/lang/Object
    //   227: invokestatic 127	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   230: pop
    //   231: aload 7
    //   233: ifnull +16 -> 249
    //   236: aload 7
    //   238: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   241: ifeq +8 -> 249
    //   244: aload 7
    //   246: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   249: aload_0
    //   250: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   253: ldc_w 264
    //   256: iconst_0
    //   257: anewarray 4	java/lang/Object
    //   260: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   263: pop
    //   264: iload_3
    //   265: ireturn
    //   266: astore 6
    //   268: aload 7
    //   270: astore_1
    //   271: goto +104 -> 375
    //   274: astore 5
    //   276: aload 7
    //   278: astore_1
    //   279: aload 5
    //   281: astore 7
    //   283: goto +27 -> 310
    //   286: astore 7
    //   288: aload 8
    //   290: astore_1
    //   291: goto +19 -> 310
    //   294: astore 6
    //   296: aconst_null
    //   297: astore_1
    //   298: aload_1
    //   299: astore_0
    //   300: goto +75 -> 375
    //   303: astore 7
    //   305: aconst_null
    //   306: astore_0
    //   307: aload 8
    //   309: astore_1
    //   310: aload_1
    //   311: astore 6
    //   313: aload_0
    //   314: astore 5
    //   316: aload 7
    //   318: invokevirtual 111	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   321: iconst_0
    //   322: anewarray 4	java/lang/Object
    //   325: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   328: pop
    //   329: aload_1
    //   330: ifnull +14 -> 344
    //   333: aload_1
    //   334: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   337: ifeq +7 -> 344
    //   340: aload_1
    //   341: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   344: aload_0
    //   345: ifnull +7 -> 352
    //   348: aload_0
    //   349: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   352: ldc_w 264
    //   355: iconst_0
    //   356: anewarray 4	java/lang/Object
    //   359: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   362: pop
    //   363: iconst_m1
    //   364: ireturn
    //   365: astore_0
    //   366: aload 6
    //   368: astore_1
    //   369: aload_0
    //   370: astore 6
    //   372: aload 5
    //   374: astore_0
    //   375: aload_1
    //   376: ifnull +14 -> 390
    //   379: aload_1
    //   380: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   383: ifeq +7 -> 390
    //   386: aload_1
    //   387: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   390: aload_0
    //   391: ifnull +7 -> 398
    //   394: aload_0
    //   395: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   398: ldc_w 264
    //   401: iconst_0
    //   402: anewarray 4	java/lang/Object
    //   405: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   408: pop
    //   409: aload 6
    //   411: athrow
    //   412: iconst_0
    //   413: ireturn
    //   414: iload_3
    //   415: iconst_1
    //   416: iadd
    //   417: istore_3
    //   418: iload 4
    //   420: istore_2
    //   421: goto -347 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	424	0	paramContext	Context
    //   0	424	1	paramArrayOfLong	Long[]
    //   73	348	2	k	int
    //   71	347	3	m	int
    //   101	318	4	n	int
    //   53	155	5	localObject1	Object
    //   274	6	5	localThrowable1	Throwable
    //   314	59	5	localContext	Context
    //   38	1	6	localObject2	Object
    //   266	1	6	localObject3	Object
    //   294	1	6	localObject4	Object
    //   311	99	6	localObject5	Object
    //   59	223	7	localObject6	Object
    //   286	1	7	localThrowable2	Throwable
    //   303	14	7	localThrowable3	Throwable
    //   41	267	8	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   61	70	266	finally
    //   74	100	266	finally
    //   117	177	266	finally
    //   182	213	266	finally
    //   213	231	266	finally
    //   61	70	274	java/lang/Throwable
    //   74	100	274	java/lang/Throwable
    //   117	177	274	java/lang/Throwable
    //   182	213	274	java/lang/Throwable
    //   213	231	274	java/lang/Throwable
    //   55	61	286	java/lang/Throwable
    //   43	52	294	finally
    //   43	52	303	java/lang/Throwable
    //   55	61	365	finally
    //   316	329	365	finally
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
    //   7: ifnull +868 -> 875
    //   10: iload_3
    //   11: ifne +6 -> 17
    //   14: goto +861 -> 875
    //   17: aload_1
    //   18: ifnonnull +11 -> 29
    //   21: ldc_w 313
    //   24: astore 5
    //   26: goto +6 -> 32
    //   29: aload_1
    //   30: astore 5
    //   32: ldc_w 315
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
    //   87: ldc_w 317
    //   90: iconst_0
    //   91: anewarray 4	java/lang/Object
    //   94: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   97: pop
    //   98: ldc_w 319
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
    //   132: ldc_w 321
    //   135: iconst_1
    //   136: anewarray 4	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: iconst_m1
    //   142: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   145: aastore
    //   146: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   149: pop
    //   150: ldc_w 323
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
    //   170: new 232	java/lang/StringBuffer
    //   173: dup
    //   174: invokespecial 233	java/lang/StringBuffer:<init>	()V
    //   177: astore_0
    //   178: aload_1
    //   179: ifnull +48 -> 227
    //   182: aload_0
    //   183: invokevirtual 260	java/lang/StringBuffer:length	()I
    //   186: ifle +11 -> 197
    //   189: aload_0
    //   190: ldc_w 325
    //   193: invokevirtual 247	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   196: pop
    //   197: aload_0
    //   198: ldc_w 327
    //   201: invokevirtual 247	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   204: pop
    //   205: aload_0
    //   206: ldc_w 329
    //   209: invokevirtual 247	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   212: pop
    //   213: aload_0
    //   214: aload_1
    //   215: invokevirtual 247	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   218: pop
    //   219: aload_0
    //   220: ldc_w 331
    //   223: invokevirtual 247	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   226: pop
    //   227: iload_2
    //   228: iflt +40 -> 268
    //   231: aload_0
    //   232: invokevirtual 260	java/lang/StringBuffer:length	()I
    //   235: ifle +11 -> 246
    //   238: aload_0
    //   239: ldc_w 325
    //   242: invokevirtual 247	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   245: pop
    //   246: aload_0
    //   247: ldc_w 333
    //   250: invokevirtual 247	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   253: pop
    //   254: aload_0
    //   255: ldc_w 335
    //   258: invokevirtual 247	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   261: pop
    //   262: aload_0
    //   263: iload_2
    //   264: invokevirtual 338	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   267: pop
    //   268: aload_0
    //   269: invokevirtual 260	java/lang/StringBuffer:length	()I
    //   272: ifle +623 -> 895
    //   275: aload_0
    //   276: invokevirtual 339	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   279: astore_0
    //   280: goto +3 -> 283
    //   283: iload_3
    //   284: ifle +616 -> 900
    //   287: iload_3
    //   288: invokestatic 183	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   291: astore_1
    //   292: goto +3 -> 295
    //   295: aload 8
    //   297: ldc 95
    //   299: aconst_null
    //   300: aload_0
    //   301: aconst_null
    //   302: aconst_null
    //   303: aconst_null
    //   304: aconst_null
    //   305: aload_1
    //   306: invokevirtual 342	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   309: astore 6
    //   311: aload 6
    //   313: ifnull +130 -> 443
    //   316: new 344	java/util/ArrayList
    //   319: dup
    //   320: invokespecial 345	java/util/ArrayList:<init>	()V
    //   323: astore_0
    //   324: aload_0
    //   325: astore_1
    //   326: aload 6
    //   328: invokeinterface 207 1 0
    //   333: ifeq +112 -> 445
    //   336: aload 6
    //   338: invokestatic 348	com/tencent/feedback/proguard/l:b	(Landroid/database/Cursor;)Lcom/tencent/feedback/proguard/o;
    //   341: astore 5
    //   343: aload_0
    //   344: astore_1
    //   345: aload 5
    //   347: ifnull +98 -> 445
    //   350: ldc_w 350
    //   353: iconst_4
    //   354: anewarray 4	java/lang/Object
    //   357: dup
    //   358: iconst_0
    //   359: aload 5
    //   361: invokevirtual 354	com/tencent/feedback/proguard/o:a	()Ljava/lang/String;
    //   364: aastore
    //   365: dup
    //   366: iconst_1
    //   367: aload 5
    //   369: invokevirtual 356	com/tencent/feedback/proguard/o:d	()Ljava/lang/String;
    //   372: aastore
    //   373: dup
    //   374: iconst_2
    //   375: aload 5
    //   377: invokevirtual 357	com/tencent/feedback/proguard/o:e	()I
    //   380: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   383: aastore
    //   384: dup
    //   385: iconst_3
    //   386: aload 5
    //   388: invokevirtual 359	com/tencent/feedback/proguard/o:f	()Ljava/lang/String;
    //   391: aastore
    //   392: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   395: pop
    //   396: aload_0
    //   397: aload 5
    //   399: invokeinterface 365 2 0
    //   404: pop
    //   405: goto -81 -> 324
    //   408: astore 5
    //   410: aload_0
    //   411: astore_1
    //   412: goto +11 -> 423
    //   415: astore_1
    //   416: goto +20 -> 436
    //   419: astore 5
    //   421: aconst_null
    //   422: astore_1
    //   423: aload 5
    //   425: astore_0
    //   426: aload 8
    //   428: astore 5
    //   430: goto +343 -> 773
    //   433: astore_1
    //   434: aconst_null
    //   435: astore_0
    //   436: aload 8
    //   438: astore 5
    //   440: goto +182 -> 622
    //   443: aconst_null
    //   444: astore_1
    //   445: aload 6
    //   447: ifnull +20 -> 467
    //   450: aload 6
    //   452: invokeinterface 222 1 0
    //   457: ifne +10 -> 467
    //   460: aload 6
    //   462: invokeinterface 223 1 0
    //   467: aload 8
    //   469: ifnull +16 -> 485
    //   472: aload 8
    //   474: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   477: ifeq +8 -> 485
    //   480: aload 8
    //   482: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   485: aload 7
    //   487: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   490: aload_1
    //   491: ifnull +11 -> 502
    //   494: aload_1
    //   495: invokeinterface 368 1 0
    //   500: istore 4
    //   502: ldc_w 321
    //   505: iconst_1
    //   506: anewarray 4	java/lang/Object
    //   509: dup
    //   510: iconst_0
    //   511: iload 4
    //   513: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   516: aastore
    //   517: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   520: pop
    //   521: iconst_1
    //   522: anewarray 4	java/lang/Object
    //   525: astore_0
    //   526: aload_0
    //   527: iconst_0
    //   528: iload 4
    //   530: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   533: aastore
    //   534: goto +222 -> 756
    //   537: astore_0
    //   538: aconst_null
    //   539: astore_1
    //   540: aload 10
    //   542: astore 6
    //   544: aload 8
    //   546: astore 5
    //   548: goto +225 -> 773
    //   551: astore_1
    //   552: aconst_null
    //   553: astore_0
    //   554: aload 9
    //   556: astore 6
    //   558: aload 8
    //   560: astore 5
    //   562: goto +60 -> 622
    //   565: astore_0
    //   566: aconst_null
    //   567: astore_1
    //   568: aload_1
    //   569: astore 5
    //   571: aload 10
    //   573: astore 6
    //   575: goto +198 -> 773
    //   578: astore_1
    //   579: aconst_null
    //   580: astore_0
    //   581: aload_0
    //   582: astore 5
    //   584: aload 9
    //   586: astore 6
    //   588: goto +34 -> 622
    //   591: astore_0
    //   592: aconst_null
    //   593: astore_1
    //   594: aload_1
    //   595: astore 7
    //   597: aload 7
    //   599: astore 5
    //   601: aload 10
    //   603: astore 6
    //   605: goto +168 -> 773
    //   608: astore_1
    //   609: aconst_null
    //   610: astore_0
    //   611: aload_0
    //   612: astore 7
    //   614: aload 7
    //   616: astore 5
    //   618: aload 9
    //   620: astore 6
    //   622: ldc_w 370
    //   625: iconst_0
    //   626: anewarray 4	java/lang/Object
    //   629: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   632: pop
    //   633: ldc_w 319
    //   636: iconst_0
    //   637: anewarray 4	java/lang/Object
    //   640: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   643: pop
    //   644: aload_1
    //   645: invokestatic 114	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   648: ifne +7 -> 655
    //   651: aload_1
    //   652: invokevirtual 117	java/lang/Throwable:printStackTrace	()V
    //   655: aload 6
    //   657: ifnull +20 -> 677
    //   660: aload 6
    //   662: invokeinterface 222 1 0
    //   667: ifne +10 -> 677
    //   670: aload 6
    //   672: invokeinterface 223 1 0
    //   677: aload 5
    //   679: ifnull +16 -> 695
    //   682: aload 5
    //   684: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   687: ifeq +8 -> 695
    //   690: aload 5
    //   692: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   695: aload 7
    //   697: ifnull +8 -> 705
    //   700: aload 7
    //   702: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   705: aload_0
    //   706: ifnull +11 -> 717
    //   709: aload_0
    //   710: invokeinterface 368 1 0
    //   715: istore 4
    //   717: ldc_w 321
    //   720: iconst_1
    //   721: anewarray 4	java/lang/Object
    //   724: dup
    //   725: iconst_0
    //   726: iload 4
    //   728: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   731: aastore
    //   732: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   735: pop
    //   736: iconst_1
    //   737: anewarray 4	java/lang/Object
    //   740: astore 5
    //   742: aload 5
    //   744: iconst_0
    //   745: iload 4
    //   747: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   750: aastore
    //   751: aload_0
    //   752: astore_1
    //   753: aload 5
    //   755: astore_0
    //   756: ldc_w 323
    //   759: aload_0
    //   760: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   763: pop
    //   764: aload_1
    //   765: areturn
    //   766: astore 8
    //   768: aload_0
    //   769: astore_1
    //   770: aload 8
    //   772: astore_0
    //   773: aload 6
    //   775: ifnull +20 -> 795
    //   778: aload 6
    //   780: invokeinterface 222 1 0
    //   785: ifne +10 -> 795
    //   788: aload 6
    //   790: invokeinterface 223 1 0
    //   795: aload 5
    //   797: ifnull +16 -> 813
    //   800: aload 5
    //   802: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   805: ifeq +8 -> 813
    //   808: aload 5
    //   810: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   813: aload 7
    //   815: ifnull +8 -> 823
    //   818: aload 7
    //   820: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   823: aload_1
    //   824: ifnull +11 -> 835
    //   827: aload_1
    //   828: invokeinterface 368 1 0
    //   833: istore 4
    //   835: ldc_w 321
    //   838: iconst_1
    //   839: anewarray 4	java/lang/Object
    //   842: dup
    //   843: iconst_0
    //   844: iload 4
    //   846: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   849: aastore
    //   850: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   853: pop
    //   854: ldc_w 323
    //   857: iconst_1
    //   858: anewarray 4	java/lang/Object
    //   861: dup
    //   862: iconst_0
    //   863: iload 4
    //   865: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   868: aastore
    //   869: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   872: pop
    //   873: aload_0
    //   874: athrow
    //   875: ldc_w 372
    //   878: iconst_1
    //   879: anewarray 4	java/lang/Object
    //   882: dup
    //   883: iconst_0
    //   884: iload_3
    //   885: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   888: aastore
    //   889: invokestatic 56	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   892: pop
    //   893: aconst_null
    //   894: areturn
    //   895: aconst_null
    //   896: astore_0
    //   897: goto -614 -> 283
    //   900: aconst_null
    //   901: astore_1
    //   902: goto -607 -> 295
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	905	0	paramContext	Context
    //   0	905	1	paramString	String
    //   0	905	2	paramInt1	int
    //   0	905	3	paramInt2	int
    //   63	801	4	k	int
    //   24	374	5	localObject1	Object
    //   408	1	5	localObject2	Object
    //   419	5	5	localObject3	Object
    //   428	381	5	localObject4	Object
    //   309	480	6	localObject5	Object
    //   73	746	7	localObject6	Object
    //   80	479	8	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   766	5	8	localObject7	Object
    //   4	615	9	localObject8	Object
    //   1	601	10	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   326	343	408	finally
    //   350	405	408	finally
    //   326	343	415	java/lang/Throwable
    //   350	405	415	java/lang/Throwable
    //   316	324	419	finally
    //   316	324	433	java/lang/Throwable
    //   87	109	537	finally
    //   170	178	537	finally
    //   182	197	537	finally
    //   197	227	537	finally
    //   231	246	537	finally
    //   246	268	537	finally
    //   268	280	537	finally
    //   287	292	537	finally
    //   295	311	537	finally
    //   87	109	551	java/lang/Throwable
    //   170	178	551	java/lang/Throwable
    //   182	197	551	java/lang/Throwable
    //   197	227	551	java/lang/Throwable
    //   231	246	551	java/lang/Throwable
    //   246	268	551	java/lang/Throwable
    //   268	280	551	java/lang/Throwable
    //   287	292	551	java/lang/Throwable
    //   295	311	551	java/lang/Throwable
    //   75	82	565	finally
    //   75	82	578	java/lang/Throwable
    //   65	75	591	finally
    //   65	75	608	java/lang/Throwable
    //   622	655	766	finally
  }
  
  public static List<l> a(Context paramContext, int[] paramArrayOfInt, int paramInt1, int paramInt2, long paramLong1, int paramInt3, String paramString, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong2, long paramLong3)
  {
    return a(paramContext, paramArrayOfInt, -1, -1, paramLong1, paramInt3, paramString, -1, -1, -1, -1, -1L, 9223372036854775807L, -1);
  }
  
  /* Error */
  public static List<l> a(Context paramContext, int[] paramArrayOfInt, int paramInt1, int paramInt2, long paramLong1, int paramInt3, String paramString, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong2, long paramLong3, int paramInt8)
  {
    // Byte code:
    //   0: ldc_w 383
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: ifnull +2321 -> 2333
    //   15: lload 4
    //   17: lconst_0
    //   18: lcmp
    //   19: ifeq +2314 -> 2333
    //   22: lload 14
    //   24: lconst_0
    //   25: lcmp
    //   26: ifle +11 -> 37
    //   29: lload 12
    //   31: lload 14
    //   33: lcmp
    //   34: ifgt +2299 -> 2333
    //   37: iload 9
    //   39: ifle +10 -> 49
    //   42: iload 8
    //   44: iload 9
    //   46: if_icmpgt +2287 -> 2333
    //   49: iload 11
    //   51: ifle +13 -> 64
    //   54: iload 10
    //   56: iload 11
    //   58: if_icmple +6 -> 64
    //   61: goto +2272 -> 2333
    //   64: lload 4
    //   66: lconst_0
    //   67: lcmp
    //   68: ifge +11 -> 79
    //   71: ldc2_w 376
    //   74: lstore 4
    //   76: goto +3 -> 79
    //   79: ldc 156
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
    //   100: ldc 156
    //   102: astore 18
    //   104: iconst_0
    //   105: istore 17
    //   107: iload 17
    //   109: aload_1
    //   110: arraylength
    //   111: if_icmpge +54 -> 165
    //   114: new 129	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   121: astore 19
    //   123: aload 19
    //   125: aload 18
    //   127: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload 19
    //   133: ldc 158
    //   135: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload 19
    //   141: aload_1
    //   142: iload 17
    //   144: iaload
    //   145: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload 19
    //   151: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: astore 18
    //   156: iload 17
    //   158: iconst_1
    //   159: iadd
    //   160: istore 17
    //   162: goto -55 -> 107
    //   165: new 129	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   172: astore_1
    //   173: aload_1
    //   174: ldc 156
    //   176: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_1
    //   181: aload 18
    //   183: iconst_4
    //   184: invokevirtual 164	java/lang/String:substring	(I)Ljava/lang/String;
    //   187: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_1
    //   192: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: astore 18
    //   197: aload 18
    //   199: invokevirtual 384	java/lang/String:length	()I
    //   202: ifle +38 -> 240
    //   205: new 129	java/lang/StringBuilder
    //   208: dup
    //   209: ldc_w 386
    //   212: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   215: astore_1
    //   216: aload_1
    //   217: aload 18
    //   219: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload_1
    //   224: ldc_w 388
    //   227: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload_1
    //   232: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: astore 18
    //   237: goto +7 -> 244
    //   240: ldc 156
    //   242: astore 18
    //   244: aload 18
    //   246: astore_1
    //   247: aload 7
    //   249: ifnull +77 -> 326
    //   252: new 129	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   259: astore 19
    //   261: aload 19
    //   263: aload 18
    //   265: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload 18
    //   271: invokevirtual 384	java/lang/String:length	()I
    //   274: ifle +10 -> 284
    //   277: ldc_w 325
    //   280: astore_1
    //   281: goto +6 -> 287
    //   284: ldc 156
    //   286: astore_1
    //   287: aload 19
    //   289: aload_1
    //   290: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload 19
    //   296: ldc_w 390
    //   299: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload 19
    //   305: aload 7
    //   307: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload 19
    //   313: ldc_w 331
    //   316: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload 19
    //   322: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: astore_1
    //   326: aload_1
    //   327: astore 7
    //   329: iload 8
    //   331: iflt +76 -> 407
    //   334: new 129	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   341: astore 7
    //   343: aload 7
    //   345: aload_1
    //   346: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload_1
    //   351: invokevirtual 384	java/lang/String:length	()I
    //   354: ifle +10 -> 364
    //   357: ldc_w 325
    //   360: astore_1
    //   361: goto +6 -> 367
    //   364: ldc 156
    //   366: astore_1
    //   367: aload 7
    //   369: aload_1
    //   370: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload 7
    //   376: ldc_w 392
    //   379: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload 7
    //   385: iload 8
    //   387: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: aload 7
    //   393: ldc_w 394
    //   396: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload 7
    //   402: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: astore 7
    //   407: aload 7
    //   409: astore_1
    //   410: iload 9
    //   412: iflt +77 -> 489
    //   415: new 129	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   422: astore 18
    //   424: aload 18
    //   426: aload 7
    //   428: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: aload 7
    //   434: invokevirtual 384	java/lang/String:length	()I
    //   437: ifle +10 -> 447
    //   440: ldc_w 325
    //   443: astore_1
    //   444: goto +6 -> 450
    //   447: ldc 156
    //   449: astore_1
    //   450: aload 18
    //   452: aload_1
    //   453: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: aload 18
    //   459: ldc_w 396
    //   462: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload 18
    //   468: iload 9
    //   470: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   473: pop
    //   474: aload 18
    //   476: ldc_w 394
    //   479: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: aload 18
    //   485: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: astore_1
    //   489: aload_1
    //   490: astore 7
    //   492: iload 10
    //   494: iflt +76 -> 570
    //   497: new 129	java/lang/StringBuilder
    //   500: dup
    //   501: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   504: astore 7
    //   506: aload 7
    //   508: aload_1
    //   509: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: pop
    //   513: aload_1
    //   514: invokevirtual 384	java/lang/String:length	()I
    //   517: ifle +10 -> 527
    //   520: ldc_w 325
    //   523: astore_1
    //   524: goto +6 -> 530
    //   527: ldc 156
    //   529: astore_1
    //   530: aload 7
    //   532: aload_1
    //   533: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: aload 7
    //   539: ldc_w 398
    //   542: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: pop
    //   546: aload 7
    //   548: iload 10
    //   550: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: aload 7
    //   556: ldc_w 394
    //   559: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: pop
    //   563: aload 7
    //   565: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: astore 7
    //   570: iload 11
    //   572: iflt +81 -> 653
    //   575: new 129	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   582: astore 18
    //   584: aload 18
    //   586: aload 7
    //   588: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: pop
    //   592: aload 7
    //   594: invokevirtual 384	java/lang/String:length	()I
    //   597: ifle +10 -> 607
    //   600: ldc_w 325
    //   603: astore_1
    //   604: goto +6 -> 610
    //   607: ldc 156
    //   609: astore_1
    //   610: aload 18
    //   612: aload_1
    //   613: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: pop
    //   617: aload 18
    //   619: ldc_w 400
    //   622: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: pop
    //   626: aload 18
    //   628: iload 11
    //   630: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   633: pop
    //   634: aload 18
    //   636: ldc_w 394
    //   639: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: pop
    //   643: aload 18
    //   645: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: astore 7
    //   650: goto +3 -> 653
    //   653: lload 12
    //   655: lconst_0
    //   656: lcmp
    //   657: iflt +80 -> 737
    //   660: new 129	java/lang/StringBuilder
    //   663: dup
    //   664: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   667: astore 18
    //   669: aload 18
    //   671: aload 7
    //   673: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: pop
    //   677: aload 7
    //   679: invokevirtual 384	java/lang/String:length	()I
    //   682: ifle +10 -> 692
    //   685: ldc_w 325
    //   688: astore_1
    //   689: goto +6 -> 695
    //   692: ldc 156
    //   694: astore_1
    //   695: aload 18
    //   697: aload_1
    //   698: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: pop
    //   702: aload 18
    //   704: ldc 131
    //   706: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: pop
    //   710: aload 18
    //   712: lload 12
    //   714: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   717: pop
    //   718: aload 18
    //   720: ldc_w 394
    //   723: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: pop
    //   727: aload 18
    //   729: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   732: astore 7
    //   734: goto +3 -> 737
    //   737: aload 7
    //   739: astore_1
    //   740: lload 14
    //   742: lconst_0
    //   743: lcmp
    //   744: iflt +77 -> 821
    //   747: new 129	java/lang/StringBuilder
    //   750: dup
    //   751: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   754: astore 18
    //   756: aload 18
    //   758: aload 7
    //   760: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: pop
    //   764: aload 7
    //   766: invokevirtual 384	java/lang/String:length	()I
    //   769: ifle +10 -> 779
    //   772: ldc_w 325
    //   775: astore_1
    //   776: goto +6 -> 782
    //   779: ldc 156
    //   781: astore_1
    //   782: aload 18
    //   784: aload_1
    //   785: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: pop
    //   789: aload 18
    //   791: ldc_w 402
    //   794: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: pop
    //   798: aload 18
    //   800: lload 14
    //   802: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   805: pop
    //   806: aload 18
    //   808: ldc_w 394
    //   811: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: pop
    //   815: aload 18
    //   817: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   820: astore_1
    //   821: aload_1
    //   822: astore 18
    //   824: iload 16
    //   826: iflt +76 -> 902
    //   829: new 129	java/lang/StringBuilder
    //   832: dup
    //   833: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   836: astore 7
    //   838: aload 7
    //   840: aload_1
    //   841: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: pop
    //   845: aload_1
    //   846: invokevirtual 384	java/lang/String:length	()I
    //   849: ifle +10 -> 859
    //   852: ldc_w 325
    //   855: astore_1
    //   856: goto +6 -> 862
    //   859: ldc 156
    //   861: astore_1
    //   862: aload 7
    //   864: aload_1
    //   865: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: pop
    //   869: aload 7
    //   871: ldc_w 404
    //   874: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: pop
    //   878: aload 7
    //   880: iload 16
    //   882: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   885: pop
    //   886: aload 7
    //   888: ldc_w 394
    //   891: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: pop
    //   895: aload 7
    //   897: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   900: astore 18
    //   902: ldc 156
    //   904: astore_1
    //   905: iload_2
    //   906: tableswitch	default:+22 -> 928, 1:+56->962, 2:+25->931
    //   929: nop
    //   930: istore_3
    //   931: new 129	java/lang/StringBuilder
    //   934: dup
    //   935: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   938: astore_1
    //   939: aload_1
    //   940: ldc 156
    //   942: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   945: pop
    //   946: aload_1
    //   947: ldc_w 406
    //   950: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: pop
    //   954: aload_1
    //   955: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   958: astore_1
    //   959: goto +31 -> 990
    //   962: new 129	java/lang/StringBuilder
    //   965: dup
    //   966: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   969: astore_1
    //   970: aload_1
    //   971: ldc 156
    //   973: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: pop
    //   977: aload_1
    //   978: ldc_w 408
    //   981: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: pop
    //   985: aload_1
    //   986: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   989: astore_1
    //   990: iload_3
    //   991: tableswitch	default:+21 -> 1012, 1:+58->1049, 2:+24->1015
    //   1013: nop
    //   1014: fstore_1
    //   1015: new 129	java/lang/StringBuilder
    //   1018: dup
    //   1019: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   1022: astore 7
    //   1024: aload 7
    //   1026: aload_1
    //   1027: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1030: pop
    //   1031: aload 7
    //   1033: ldc_w 410
    //   1036: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: pop
    //   1040: aload 7
    //   1042: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1045: astore_1
    //   1046: goto +34 -> 1080
    //   1049: new 129	java/lang/StringBuilder
    //   1052: dup
    //   1053: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   1056: astore 7
    //   1058: aload 7
    //   1060: aload_1
    //   1061: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: pop
    //   1065: aload 7
    //   1067: ldc_w 412
    //   1070: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1073: pop
    //   1074: aload 7
    //   1076: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1079: astore_1
    //   1080: aload_1
    //   1081: ldc_w 414
    //   1084: invokevirtual 418	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1087: ifeq +18 -> 1105
    //   1090: aload_1
    //   1091: iconst_0
    //   1092: aload_1
    //   1093: invokevirtual 384	java/lang/String:length	()I
    //   1096: iconst_3
    //   1097: isub
    //   1098: invokevirtual 421	java/lang/String:substring	(II)Ljava/lang/String;
    //   1101: astore_1
    //   1102: goto +3 -> 1105
    //   1105: ldc_w 423
    //   1108: iconst_1
    //   1109: anewarray 4	java/lang/Object
    //   1112: dup
    //   1113: iconst_0
    //   1114: aload 18
    //   1116: aastore
    //   1117: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1120: pop
    //   1121: new 344	java/util/ArrayList
    //   1124: dup
    //   1125: invokespecial 345	java/util/ArrayList:<init>	()V
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
    //   1151: ifle +872 -> 2023
    //   1154: aload_1
    //   1155: astore_0
    //   1156: aload_1
    //   1157: invokevirtual 384	java/lang/String:length	()I
    //   1160: ifle +30 -> 1190
    //   1163: new 129	java/lang/StringBuilder
    //   1166: dup
    //   1167: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   1170: astore_0
    //   1171: aload_0
    //   1172: aload_1
    //   1173: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1176: pop
    //   1177: aload_0
    //   1178: ldc_w 414
    //   1181: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1184: pop
    //   1185: aload_0
    //   1186: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1189: astore_0
    //   1190: new 129	java/lang/StringBuilder
    //   1193: dup
    //   1194: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   1197: astore_1
    //   1198: aload_1
    //   1199: aload_0
    //   1200: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1203: pop
    //   1204: aload_1
    //   1205: ldc_w 425
    //   1208: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1211: pop
    //   1212: aload_1
    //   1213: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1216: astore 20
    //   1218: iload 6
    //   1220: iflt +1126 -> 2346
    //   1223: iload 6
    //   1225: invokestatic 183	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1228: astore_0
    //   1229: goto +3 -> 1232
    //   1232: aload 19
    //   1234: ldc 179
    //   1236: iconst_2
    //   1237: anewarray 160	java/lang/String
    //   1240: dup
    //   1241: iconst_0
    //   1242: ldc_w 270
    //   1245: aastore
    //   1246: dup
    //   1247: iconst_1
    //   1248: ldc_w 293
    //   1251: aastore
    //   1252: aload 18
    //   1254: aconst_null
    //   1255: aconst_null
    //   1256: aconst_null
    //   1257: aload 20
    //   1259: aload_0
    //   1260: invokevirtual 342	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1263: astore 18
    //   1265: aload 18
    //   1267: astore_1
    //   1268: aload 18
    //   1270: astore_0
    //   1271: aload 18
    //   1273: ldc_w 270
    //   1276: invokeinterface 213 2 0
    //   1281: istore_2
    //   1282: aload 18
    //   1284: astore_1
    //   1285: aload 18
    //   1287: astore_0
    //   1288: aload 18
    //   1290: ldc_w 293
    //   1293: invokeinterface 213 2 0
    //   1298: istore_3
    //   1299: aload 18
    //   1301: astore_1
    //   1302: aload 18
    //   1304: astore_0
    //   1305: new 427	java/util/LinkedHashMap
    //   1308: dup
    //   1309: invokespecial 428	java/util/LinkedHashMap:<init>	()V
    //   1312: astore 22
    //   1314: aload 18
    //   1316: astore_1
    //   1317: aload 18
    //   1319: astore_0
    //   1320: aload 18
    //   1322: invokeinterface 207 1 0
    //   1327: ifeq +40 -> 1367
    //   1330: aload 18
    //   1332: astore_1
    //   1333: aload 18
    //   1335: astore_0
    //   1336: aload 22
    //   1338: aload 18
    //   1340: iload_2
    //   1341: invokeinterface 432 2 0
    //   1346: invokestatic 273	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1349: aload 18
    //   1351: iload_3
    //   1352: invokeinterface 432 2 0
    //   1357: invokestatic 273	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1360: invokevirtual 435	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1363: pop
    //   1364: goto -50 -> 1314
    //   1367: aload 18
    //   1369: astore_1
    //   1370: aload 18
    //   1372: astore_0
    //   1373: aload 18
    //   1375: invokeinterface 223 1 0
    //   1380: aload 18
    //   1382: astore_1
    //   1383: aload 18
    //   1385: astore_0
    //   1386: aload 22
    //   1388: lload 4
    //   1390: invokestatic 440	com/tencent/feedback/proguard/a:a	(Ljava/util/LinkedHashMap;J)[Ljava/lang/Long;
    //   1393: astore 22
    //   1395: aload 22
    //   1397: ifnull +568 -> 1965
    //   1400: aload 18
    //   1402: astore_1
    //   1403: aload 18
    //   1405: astore_0
    //   1406: aload 22
    //   1408: arraylength
    //   1409: ifle +556 -> 1965
    //   1412: aload 18
    //   1414: astore_1
    //   1415: aload 18
    //   1417: astore_0
    //   1418: new 129	java/lang/StringBuilder
    //   1421: dup
    //   1422: ldc_w 442
    //   1425: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1428: astore 23
    //   1430: aload 18
    //   1432: astore_1
    //   1433: aload 18
    //   1435: astore_0
    //   1436: aload 23
    //   1438: aload 22
    //   1440: arraylength
    //   1441: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1444: pop
    //   1445: aload 18
    //   1447: astore_1
    //   1448: aload 18
    //   1450: astore_0
    //   1451: aload 23
    //   1453: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1456: iconst_0
    //   1457: anewarray 4	java/lang/Object
    //   1460: invokestatic 127	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1463: pop
    //   1464: aload 18
    //   1466: astore_1
    //   1467: aload 18
    //   1469: astore_0
    //   1470: new 232	java/lang/StringBuffer
    //   1473: dup
    //   1474: invokespecial 233	java/lang/StringBuffer:<init>	()V
    //   1477: astore 23
    //   1479: aload 18
    //   1481: astore_0
    //   1482: iconst_0
    //   1483: istore_2
    //   1484: aload_0
    //   1485: astore 18
    //   1487: aload_0
    //   1488: astore_1
    //   1489: iload_2
    //   1490: aload 22
    //   1492: arraylength
    //   1493: if_icmpge +189 -> 1682
    //   1496: aload_0
    //   1497: astore 18
    //   1499: aload_0
    //   1500: astore_1
    //   1501: aload 23
    //   1503: ldc 235
    //   1505: aload 22
    //   1507: iload_2
    //   1508: aaload
    //   1509: invokevirtual 241	java/lang/Long:longValue	()J
    //   1512: invokestatic 244	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1515: invokevirtual 177	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1518: invokevirtual 247	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1521: pop
    //   1522: aload_0
    //   1523: astore_1
    //   1524: iload_2
    //   1525: ifle +826 -> 2351
    //   1528: aload_0
    //   1529: astore_1
    //   1530: iload_2
    //   1531: bipush 50
    //   1533: irem
    //   1534: ifne +817 -> 2351
    //   1537: aload_0
    //   1538: astore 18
    //   1540: aload_0
    //   1541: astore_1
    //   1542: ldc 249
    //   1544: iload_2
    //   1545: invokestatic 183	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1548: invokevirtual 177	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1551: iconst_0
    //   1552: anewarray 4	java/lang/Object
    //   1555: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1558: pop
    //   1559: aload_0
    //   1560: astore 18
    //   1562: aload_0
    //   1563: astore_1
    //   1564: aload 23
    //   1566: iconst_4
    //   1567: invokevirtual 250	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   1570: astore 24
    //   1572: aload_0
    //   1573: astore 18
    //   1575: aload_0
    //   1576: astore_1
    //   1577: aload 23
    //   1579: iconst_0
    //   1580: invokevirtual 254	java/lang/StringBuffer:setLength	(I)V
    //   1583: aload_0
    //   1584: astore 18
    //   1586: aload_0
    //   1587: astore_1
    //   1588: aload 19
    //   1590: ldc 179
    //   1592: aconst_null
    //   1593: aload 24
    //   1595: aconst_null
    //   1596: aconst_null
    //   1597: aconst_null
    //   1598: aload 20
    //   1600: invokevirtual 202	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1603: astore_0
    //   1604: aload_0
    //   1605: astore 18
    //   1607: aload_0
    //   1608: astore_1
    //   1609: aload_0
    //   1610: invokestatic 445	com/tencent/feedback/proguard/l:a	(Landroid/database/Cursor;)Ljava/util/List;
    //   1613: astore 24
    //   1615: aload 24
    //   1617: ifnull +49 -> 1666
    //   1620: aload_0
    //   1621: astore 18
    //   1623: aload_0
    //   1624: astore_1
    //   1625: aload 24
    //   1627: invokeinterface 368 1 0
    //   1632: ifle +34 -> 1666
    //   1635: aload_0
    //   1636: astore 18
    //   1638: aload_0
    //   1639: astore_1
    //   1640: aload 21
    //   1642: aload 24
    //   1644: invokeinterface 449 2 0
    //   1649: pop
    //   1650: aload_0
    //   1651: astore 18
    //   1653: aload_0
    //   1654: astore_1
    //   1655: ldc_w 451
    //   1658: iconst_0
    //   1659: anewarray 4	java/lang/Object
    //   1662: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1665: pop
    //   1666: aload_0
    //   1667: astore 18
    //   1669: aload_0
    //   1670: astore_1
    //   1671: aload_0
    //   1672: invokeinterface 223 1 0
    //   1677: aload_0
    //   1678: astore_1
    //   1679: goto +672 -> 2351
    //   1682: aload_0
    //   1683: astore 18
    //   1685: aload_0
    //   1686: astore_1
    //   1687: aload 23
    //   1689: invokevirtual 260	java/lang/StringBuffer:length	()I
    //   1692: ifle +668 -> 2360
    //   1695: aload_0
    //   1696: astore 18
    //   1698: aload_0
    //   1699: astore_1
    //   1700: aload 23
    //   1702: iconst_4
    //   1703: invokevirtual 250	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   1706: astore 22
    //   1708: aload_0
    //   1709: astore 18
    //   1711: aload_0
    //   1712: astore_1
    //   1713: aload 23
    //   1715: iconst_0
    //   1716: invokevirtual 254	java/lang/StringBuffer:setLength	(I)V
    //   1719: aload_0
    //   1720: astore 18
    //   1722: aload_0
    //   1723: astore_1
    //   1724: aload 19
    //   1726: ldc 179
    //   1728: aconst_null
    //   1729: aload 22
    //   1731: aconst_null
    //   1732: aconst_null
    //   1733: aconst_null
    //   1734: aload 20
    //   1736: invokevirtual 202	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1739: astore 20
    //   1741: aload 20
    //   1743: astore_1
    //   1744: aload 20
    //   1746: astore_0
    //   1747: aload 20
    //   1749: invokestatic 445	com/tencent/feedback/proguard/l:a	(Landroid/database/Cursor;)Ljava/util/List;
    //   1752: astore 22
    //   1754: aload 20
    //   1756: astore 18
    //   1758: aload 22
    //   1760: ifnull +63 -> 1823
    //   1763: aload 20
    //   1765: astore 18
    //   1767: aload 20
    //   1769: astore_1
    //   1770: aload 20
    //   1772: astore_0
    //   1773: aload 22
    //   1775: invokeinterface 368 1 0
    //   1780: ifle +43 -> 1823
    //   1783: aload 20
    //   1785: astore_1
    //   1786: aload 20
    //   1788: astore_0
    //   1789: aload 21
    //   1791: aload 22
    //   1793: invokeinterface 449 2 0
    //   1798: pop
    //   1799: aload 20
    //   1801: astore_1
    //   1802: aload 20
    //   1804: astore_0
    //   1805: ldc_w 451
    //   1808: iconst_0
    //   1809: anewarray 4	java/lang/Object
    //   1812: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1815: pop
    //   1816: aload 20
    //   1818: astore 18
    //   1820: goto +3 -> 1823
    //   1823: aload 18
    //   1825: astore_1
    //   1826: aload 18
    //   1828: astore_0
    //   1829: new 129	java/lang/StringBuilder
    //   1832: dup
    //   1833: ldc_w 453
    //   1836: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1839: astore 20
    //   1841: aload 18
    //   1843: astore_1
    //   1844: aload 18
    //   1846: astore_0
    //   1847: aload 20
    //   1849: aload 21
    //   1851: invokeinterface 368 1 0
    //   1856: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1859: pop
    //   1860: aload 18
    //   1862: astore_1
    //   1863: aload 18
    //   1865: astore_0
    //   1866: aload 20
    //   1868: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1871: iconst_0
    //   1872: anewarray 4	java/lang/Object
    //   1875: invokestatic 127	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1878: pop
    //   1879: aload 18
    //   1881: ifnull +20 -> 1901
    //   1884: aload 18
    //   1886: invokeinterface 222 1 0
    //   1891: ifne +10 -> 1901
    //   1894: aload 18
    //   1896: invokeinterface 223 1 0
    //   1901: aload 19
    //   1903: ifnull +16 -> 1919
    //   1906: aload 19
    //   1908: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   1911: ifeq +8 -> 1919
    //   1914: aload 19
    //   1916: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   1919: aload 7
    //   1921: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   1924: ldc_w 455
    //   1927: iconst_0
    //   1928: anewarray 4	java/lang/Object
    //   1931: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1934: pop
    //   1935: aload 21
    //   1937: areturn
    //   1938: astore_0
    //   1939: aload 18
    //   1941: astore_1
    //   1942: aload 19
    //   1944: astore 18
    //   1946: goto +324 -> 2270
    //   1949: astore 18
    //   1951: aload 7
    //   1953: astore_0
    //   1954: aload 18
    //   1956: astore 7
    //   1958: aload 19
    //   1960: astore 18
    //   1962: goto +239 -> 2201
    //   1965: aload 18
    //   1967: ifnull +20 -> 1987
    //   1970: aload 18
    //   1972: invokeinterface 222 1 0
    //   1977: ifne +10 -> 1987
    //   1980: aload 18
    //   1982: invokeinterface 223 1 0
    //   1987: aload 19
    //   1989: ifnull +16 -> 2005
    //   1992: aload 19
    //   1994: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   1997: ifeq +8 -> 2005
    //   2000: aload 19
    //   2002: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   2005: aload 7
    //   2007: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   2010: ldc_w 455
    //   2013: iconst_0
    //   2014: anewarray 4	java/lang/Object
    //   2017: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   2020: pop
    //   2021: aconst_null
    //   2022: areturn
    //   2023: aload 19
    //   2025: ldc 179
    //   2027: aconst_null
    //   2028: aload 18
    //   2030: aconst_null
    //   2031: aconst_null
    //   2032: aconst_null
    //   2033: aload_1
    //   2034: invokevirtual 202	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2037: astore 18
    //   2039: aload 18
    //   2041: astore_1
    //   2042: aload 18
    //   2044: astore_0
    //   2045: aload 18
    //   2047: invokestatic 445	com/tencent/feedback/proguard/l:a	(Landroid/database/Cursor;)Ljava/util/List;
    //   2050: astore 20
    //   2052: aload 18
    //   2054: ifnull +20 -> 2074
    //   2057: aload 18
    //   2059: invokeinterface 222 1 0
    //   2064: ifne +10 -> 2074
    //   2067: aload 18
    //   2069: invokeinterface 223 1 0
    //   2074: aload 19
    //   2076: ifnull +16 -> 2092
    //   2079: aload 19
    //   2081: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   2084: ifeq +8 -> 2092
    //   2087: aload 19
    //   2089: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   2092: aload 7
    //   2094: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   2097: ldc_w 455
    //   2100: iconst_0
    //   2101: anewarray 4	java/lang/Object
    //   2104: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   2107: pop
    //   2108: aload 20
    //   2110: areturn
    //   2111: astore_0
    //   2112: aload 19
    //   2114: astore 18
    //   2116: goto +154 -> 2270
    //   2119: astore 18
    //   2121: aload_0
    //   2122: astore_1
    //   2123: aload 7
    //   2125: astore_0
    //   2126: aload 18
    //   2128: astore 7
    //   2130: aload 19
    //   2132: astore 18
    //   2134: goto +67 -> 2201
    //   2137: astore_0
    //   2138: aconst_null
    //   2139: astore_1
    //   2140: aload 19
    //   2142: astore 18
    //   2144: goto +126 -> 2270
    //   2147: astore_1
    //   2148: aload 7
    //   2150: astore_0
    //   2151: aload_1
    //   2152: astore 7
    //   2154: aload 19
    //   2156: astore 18
    //   2158: goto +41 -> 2199
    //   2161: astore_0
    //   2162: aconst_null
    //   2163: astore_1
    //   2164: aconst_null
    //   2165: astore 18
    //   2167: goto +103 -> 2270
    //   2170: astore_1
    //   2171: aload 7
    //   2173: astore_0
    //   2174: aload_1
    //   2175: astore 7
    //   2177: goto +19 -> 2196
    //   2180: astore_0
    //   2181: aconst_null
    //   2182: astore_1
    //   2183: aconst_null
    //   2184: astore 18
    //   2186: aconst_null
    //   2187: astore 7
    //   2189: goto +81 -> 2270
    //   2192: astore 7
    //   2194: aconst_null
    //   2195: astore_0
    //   2196: aconst_null
    //   2197: astore 18
    //   2199: aconst_null
    //   2200: astore_1
    //   2201: aload 7
    //   2203: invokevirtual 111	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   2206: iconst_0
    //   2207: anewarray 4	java/lang/Object
    //   2210: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   2213: pop
    //   2214: aload_1
    //   2215: ifnull +18 -> 2233
    //   2218: aload_1
    //   2219: invokeinterface 222 1 0
    //   2224: ifne +9 -> 2233
    //   2227: aload_1
    //   2228: invokeinterface 223 1 0
    //   2233: aload 18
    //   2235: ifnull +16 -> 2251
    //   2238: aload 18
    //   2240: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   2243: ifeq +8 -> 2251
    //   2246: aload 18
    //   2248: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   2251: aload_0
    //   2252: ifnull -242 -> 2010
    //   2255: aload_0
    //   2256: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   2259: goto -249 -> 2010
    //   2262: astore 19
    //   2264: aload_0
    //   2265: astore 7
    //   2267: aload 19
    //   2269: astore_0
    //   2270: aload_1
    //   2271: ifnull +18 -> 2289
    //   2274: aload_1
    //   2275: invokeinterface 222 1 0
    //   2280: ifne +9 -> 2289
    //   2283: aload_1
    //   2284: invokeinterface 223 1 0
    //   2289: aload 18
    //   2291: ifnull +16 -> 2307
    //   2294: aload 18
    //   2296: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   2299: ifeq +8 -> 2307
    //   2302: aload 18
    //   2304: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   2307: aload 7
    //   2309: ifnull +11 -> 2320
    //   2312: aload 7
    //   2314: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   2317: goto +3 -> 2320
    //   2320: ldc_w 455
    //   2323: iconst_0
    //   2324: anewarray 4	java/lang/Object
    //   2327: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   2330: pop
    //   2331: aload_0
    //   2332: athrow
    //   2333: ldc_w 457
    //   2336: iconst_0
    //   2337: anewarray 4	java/lang/Object
    //   2340: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   2343: pop
    //   2344: aconst_null
    //   2345: areturn
    //   2346: aconst_null
    //   2347: astore_0
    //   2348: goto -1116 -> 1232
    //   2351: iload_2
    //   2352: iconst_1
    //   2353: iadd
    //   2354: istore_2
    //   2355: aload_1
    //   2356: astore_0
    //   2357: goto -873 -> 1484
    //   2360: aload_0
    //   2361: astore 18
    //   2363: goto -540 -> 1823
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2366	0	paramContext	Context
    //   0	2366	1	paramArrayOfInt	int[]
    //   0	2366	2	paramInt1	int
    //   0	2366	3	paramInt2	int
    //   0	2366	4	paramLong1	long
    //   0	2366	6	paramInt3	int
    //   0	2366	7	paramString	String
    //   0	2366	8	paramInt4	int
    //   0	2366	9	paramInt5	int
    //   0	2366	10	paramInt6	int
    //   0	2366	11	paramInt7	int
    //   0	2366	12	paramLong2	long
    //   0	2366	14	paramLong3	long
    //   0	2366	16	paramInt8	int
    //   105	56	17	k	int
    //   85	1860	18	localObject1	Object
    //   1949	6	18	localThrowable1	Throwable
    //   1960	155	18	localObject2	Object
    //   2119	8	18	localThrowable2	Throwable
    //   2132	230	18	localObject3	Object
    //   81	2074	19	localObject4	Object
    //   2262	6	19	localObject5	Object
    //   1216	893	20	localObject6	Object
    //   1128	808	21	localArrayList	ArrayList
    //   1312	480	22	localObject7	Object
    //   1428	286	23	localObject8	Object
    //   1570	73	24	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   1489	1496	1938	finally
    //   1501	1522	1938	finally
    //   1542	1559	1938	finally
    //   1564	1572	1938	finally
    //   1577	1583	1938	finally
    //   1588	1604	1938	finally
    //   1609	1615	1938	finally
    //   1625	1635	1938	finally
    //   1640	1650	1938	finally
    //   1655	1666	1938	finally
    //   1671	1677	1938	finally
    //   1687	1695	1938	finally
    //   1700	1708	1938	finally
    //   1713	1719	1938	finally
    //   1724	1741	1938	finally
    //   1489	1496	1949	java/lang/Throwable
    //   1501	1522	1949	java/lang/Throwable
    //   1542	1559	1949	java/lang/Throwable
    //   1564	1572	1949	java/lang/Throwable
    //   1577	1583	1949	java/lang/Throwable
    //   1588	1604	1949	java/lang/Throwable
    //   1609	1615	1949	java/lang/Throwable
    //   1625	1635	1949	java/lang/Throwable
    //   1640	1650	1949	java/lang/Throwable
    //   1655	1666	1949	java/lang/Throwable
    //   1671	1677	1949	java/lang/Throwable
    //   1687	1695	1949	java/lang/Throwable
    //   1700	1708	1949	java/lang/Throwable
    //   1713	1719	1949	java/lang/Throwable
    //   1724	1741	1949	java/lang/Throwable
    //   1271	1282	2111	finally
    //   1288	1299	2111	finally
    //   1305	1314	2111	finally
    //   1320	1330	2111	finally
    //   1336	1364	2111	finally
    //   1373	1380	2111	finally
    //   1386	1395	2111	finally
    //   1406	1412	2111	finally
    //   1418	1430	2111	finally
    //   1436	1445	2111	finally
    //   1451	1464	2111	finally
    //   1470	1479	2111	finally
    //   1747	1754	2111	finally
    //   1773	1783	2111	finally
    //   1789	1799	2111	finally
    //   1805	1816	2111	finally
    //   1829	1841	2111	finally
    //   1847	1860	2111	finally
    //   1866	1879	2111	finally
    //   2045	2052	2111	finally
    //   1271	1282	2119	java/lang/Throwable
    //   1288	1299	2119	java/lang/Throwable
    //   1305	1314	2119	java/lang/Throwable
    //   1320	1330	2119	java/lang/Throwable
    //   1336	1364	2119	java/lang/Throwable
    //   1373	1380	2119	java/lang/Throwable
    //   1386	1395	2119	java/lang/Throwable
    //   1406	1412	2119	java/lang/Throwable
    //   1418	1430	2119	java/lang/Throwable
    //   1436	1445	2119	java/lang/Throwable
    //   1451	1464	2119	java/lang/Throwable
    //   1470	1479	2119	java/lang/Throwable
    //   1747	1754	2119	java/lang/Throwable
    //   1773	1783	2119	java/lang/Throwable
    //   1789	1799	2119	java/lang/Throwable
    //   1805	1816	2119	java/lang/Throwable
    //   1829	1841	2119	java/lang/Throwable
    //   1847	1860	2119	java/lang/Throwable
    //   1866	1879	2119	java/lang/Throwable
    //   2045	2052	2119	java/lang/Throwable
    //   1156	1190	2137	finally
    //   1190	1218	2137	finally
    //   1223	1229	2137	finally
    //   1232	1265	2137	finally
    //   2023	2039	2137	finally
    //   1156	1190	2147	java/lang/Throwable
    //   1190	1218	2147	java/lang/Throwable
    //   1223	1229	2147	java/lang/Throwable
    //   1232	1265	2147	java/lang/Throwable
    //   2023	2039	2147	java/lang/Throwable
    //   1140	1147	2161	finally
    //   1140	1147	2170	java/lang/Throwable
    //   1130	1140	2180	finally
    //   1130	1140	2192	java/lang/Throwable
    //   2201	2214	2262	finally
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
    //   0: ldc_w 481
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
    //   23: invokeinterface 368 1 0
    //   28: ifgt +16 -> 44
    //   31: ldc_w 483
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
    //   99: invokeinterface 368 1 0
    //   104: if_icmpge +141 -> 245
    //   107: aload 8
    //   109: astore_0
    //   110: aload 7
    //   112: astore 5
    //   114: aload 8
    //   116: astore 6
    //   118: aload_1
    //   119: iload_2
    //   120: invokeinterface 487 2 0
    //   125: checkcast 2	com/tencent/feedback/proguard/l
    //   128: astore 9
    //   130: aload 8
    //   132: astore_0
    //   133: aload 7
    //   135: astore 5
    //   137: aload 8
    //   139: astore 6
    //   141: aload 8
    //   143: ldc 179
    //   145: ldc_w 270
    //   148: aload 9
    //   150: invokestatic 489	com/tencent/feedback/proguard/l:a	(Lcom/tencent/feedback/proguard/l;)Landroid/content/ContentValues;
    //   153: invokevirtual 493	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
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
    //   174: ldc_w 495
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
    //   208: ldc_w 497
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
    //   268: ldc_w 497
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
    //   303: ldc_w 499
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
    //   369: ldc_w 497
    //   372: iconst_0
    //   373: anewarray 4	java/lang/Object
    //   376: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   379: pop
    //   380: aload_1
    //   381: athrow
    //   382: ldc_w 501
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
    //   0: ldc_w 538
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: ifnull +462 -> 474
    //   15: aload_1
    //   16: ifnull +458 -> 474
    //   19: aload_1
    //   20: invokeinterface 368 1 0
    //   25: ifgt +6 -> 31
    //   28: goto +446 -> 474
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
    //   83: invokeinterface 542 1 0
    //   88: astore_1
    //   89: aload 7
    //   91: astore 5
    //   93: aload 7
    //   95: astore_0
    //   96: aload 6
    //   98: astore 4
    //   100: aload_1
    //   101: invokeinterface 547 1 0
    //   106: ifeq +201 -> 307
    //   109: aload 7
    //   111: astore 5
    //   113: aload 7
    //   115: astore_0
    //   116: aload 6
    //   118: astore 4
    //   120: aload_1
    //   121: invokeinterface 551 1 0
    //   126: checkcast 2	com/tencent/feedback/proguard/l
    //   129: astore 8
    //   131: aload 7
    //   133: astore 5
    //   135: aload 7
    //   137: astore_0
    //   138: aload 6
    //   140: astore 4
    //   142: aload 8
    //   144: invokestatic 489	com/tencent/feedback/proguard/l:a	(Lcom/tencent/feedback/proguard/l;)Landroid/content/ContentValues;
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
    //   177: ldc_w 553
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
    //   203: ldc 179
    //   205: ldc_w 270
    //   208: aload 9
    //   210: invokevirtual 556	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
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
    //   231: ldc_w 558
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
    //   269: ldc_w 560
    //   272: lload_2
    //   273: invokestatic 244	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   276: invokevirtual 177	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   279: iconst_0
    //   280: anewarray 4	java/lang/Object
    //   283: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   286: pop
    //   287: aload 7
    //   289: astore 5
    //   291: aload 7
    //   293: astore_0
    //   294: aload 6
    //   296: astore 4
    //   298: aload 8
    //   300: lload_2
    //   301: putfield 26	com/tencent/feedback/proguard/l:a	J
    //   304: goto -215 -> 89
    //   307: aload 7
    //   309: ifnull +16 -> 325
    //   312: aload 7
    //   314: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   317: ifeq +8 -> 325
    //   320: aload 7
    //   322: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   325: aload 6
    //   327: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   330: ldc_w 553
    //   333: iconst_0
    //   334: anewarray 4	java/lang/Object
    //   337: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   340: pop
    //   341: iconst_1
    //   342: ireturn
    //   343: astore_0
    //   344: aload 6
    //   346: astore_1
    //   347: aload_0
    //   348: astore 6
    //   350: goto +21 -> 371
    //   353: astore_1
    //   354: aconst_null
    //   355: astore 5
    //   357: aload 4
    //   359: astore_0
    //   360: aload 5
    //   362: astore 4
    //   364: goto +72 -> 436
    //   367: astore 6
    //   369: aconst_null
    //   370: astore_1
    //   371: aload 5
    //   373: astore_0
    //   374: aload_1
    //   375: astore 4
    //   377: aload 6
    //   379: invokestatic 114	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   382: ifne +14 -> 396
    //   385: aload 5
    //   387: astore_0
    //   388: aload_1
    //   389: astore 4
    //   391: aload 6
    //   393: invokevirtual 117	java/lang/Throwable:printStackTrace	()V
    //   396: aload 5
    //   398: ifnull +16 -> 414
    //   401: aload 5
    //   403: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   406: ifeq +8 -> 414
    //   409: aload 5
    //   411: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   414: aload_1
    //   415: ifnull +7 -> 422
    //   418: aload_1
    //   419: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   422: ldc_w 553
    //   425: iconst_0
    //   426: anewarray 4	java/lang/Object
    //   429: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   432: pop
    //   433: iconst_0
    //   434: ireturn
    //   435: astore_1
    //   436: aload_0
    //   437: ifnull +14 -> 451
    //   440: aload_0
    //   441: invokevirtual 87	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   444: ifeq +7 -> 451
    //   447: aload_0
    //   448: invokevirtual 90	android/database/sqlite/SQLiteDatabase:close	()V
    //   451: aload 4
    //   453: ifnull +8 -> 461
    //   456: aload 4
    //   458: invokevirtual 91	com/tencent/feedback/proguard/n:close	()V
    //   461: ldc_w 553
    //   464: iconst_0
    //   465: anewarray 4	java/lang/Object
    //   468: invokestatic 66	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   471: pop
    //   472: aload_1
    //   473: athrow
    //   474: ldc_w 562
    //   477: iconst_0
    //   478: anewarray 4	java/lang/Object
    //   481: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   484: pop
    //   485: iconst_0
    //   486: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	487	0	paramContext	Context
    //   0	487	1	paramList	List<l>
    //   213	88	2	l	long
    //   38	419	4	localObject1	Object
    //   32	378	5	localObject2	Object
    //   51	298	6	localObject3	Object
    //   367	25	6	localThrowable	Throwable
    //   35	286	7	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   41	258	8	locall	l
    //   147	62	9	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   64	71	343	java/lang/Throwable
    //   82	89	343	java/lang/Throwable
    //   100	109	343	java/lang/Throwable
    //   120	131	343	java/lang/Throwable
    //   142	149	343	java/lang/Throwable
    //   201	214	343	java/lang/Throwable
    //   231	242	343	java/lang/Throwable
    //   269	287	343	java/lang/Throwable
    //   298	304	343	java/lang/Throwable
    //   43	53	353	finally
    //   43	53	367	java/lang/Throwable
    //   64	71	435	finally
    //   82	89	435	finally
    //   100	109	435	finally
    //   120	131	435	finally
    //   142	149	435	finally
    //   201	214	435	finally
    //   231	242	435	finally
    //   269	287	435	finally
    //   298	304	435	finally
    //   377	385	435	finally
    //   391	396	435	finally
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
    //   9: invokeinterface 368 1 0
    //   14: ifne +6 -> 20
    //   17: goto +642 -> 659
    //   20: ldc_w 565
    //   23: iconst_1
    //   24: anewarray 4	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: aload_1
    //   30: invokeinterface 368 1 0
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
    //   66: ldc_w 317
    //   69: iconst_0
    //   70: anewarray 4	java/lang/Object
    //   73: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   76: pop
    //   77: ldc_w 567
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
    //   110: ldc_w 569
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
    //   131: invokeinterface 542 1 0
    //   136: astore 9
    //   138: iconst_0
    //   139: istore_2
    //   140: iload_2
    //   141: istore_3
    //   142: iload_2
    //   143: istore 4
    //   145: aload 9
    //   147: invokeinterface 547 1 0
    //   152: ifeq +259 -> 411
    //   155: iload_2
    //   156: istore_3
    //   157: iload_2
    //   158: istore 4
    //   160: aload 9
    //   162: invokeinterface 551 1 0
    //   167: checkcast 352	com/tencent/feedback/proguard/o
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
    //   187: new 267	android/content/ContentValues
    //   190: dup
    //   191: invokespecial 268	android/content/ContentValues:<init>	()V
    //   194: astore_1
    //   195: iload_2
    //   196: istore_3
    //   197: iload_2
    //   198: istore 4
    //   200: aload_1
    //   201: ldc_w 327
    //   204: aload 10
    //   206: invokevirtual 354	com/tencent/feedback/proguard/o:a	()Ljava/lang/String;
    //   209: invokevirtual 298	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: iload_2
    //   213: istore_3
    //   214: iload_2
    //   215: istore 4
    //   217: aload_1
    //   218: ldc_w 513
    //   221: aload 10
    //   223: invokevirtual 356	com/tencent/feedback/proguard/o:d	()Ljava/lang/String;
    //   226: invokevirtual 298	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: iload_2
    //   230: istore_3
    //   231: iload_2
    //   232: istore 4
    //   234: aload_1
    //   235: ldc_w 522
    //   238: aload 10
    //   240: invokevirtual 571	com/tencent/feedback/proguard/o:c	()J
    //   243: invokestatic 273	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   246: invokevirtual 277	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   249: iload_2
    //   250: istore_3
    //   251: iload_2
    //   252: istore 4
    //   254: aload_1
    //   255: ldc_w 526
    //   258: aload 10
    //   260: invokevirtual 573	com/tencent/feedback/proguard/o:b	()J
    //   263: invokestatic 273	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   266: invokevirtual 277	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   269: iload_2
    //   270: istore_3
    //   271: iload_2
    //   272: istore 4
    //   274: aload_1
    //   275: ldc_w 333
    //   278: aload 10
    //   280: invokevirtual 357	com/tencent/feedback/proguard/o:e	()I
    //   283: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   286: invokevirtual 282	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   289: iload_2
    //   290: istore_3
    //   291: iload_2
    //   292: istore 4
    //   294: aload_1
    //   295: ldc_w 530
    //   298: aload 10
    //   300: invokevirtual 359	com/tencent/feedback/proguard/o:f	()Ljava/lang/String;
    //   303: invokevirtual 298	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: aload_1
    //   307: ifnull -167 -> 140
    //   310: iload_2
    //   311: istore_3
    //   312: iload_2
    //   313: istore 4
    //   315: aload 8
    //   317: ldc 95
    //   319: ldc_w 270
    //   322: aload_1
    //   323: invokevirtual 493	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   326: lstore 5
    //   328: iload_2
    //   329: istore_3
    //   330: iload_2
    //   331: istore 4
    //   333: aload 10
    //   335: lload 5
    //   337: invokevirtual 518	com/tencent/feedback/proguard/o:a	(J)V
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
    //   363: invokevirtual 354	com/tencent/feedback/proguard/o:a	()Ljava/lang/String;
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
    //   385: ldc_w 575
    //   388: iconst_2
    //   389: anewarray 4	java/lang/Object
    //   392: dup
    //   393: iconst_0
    //   394: aload_1
    //   395: aastore
    //   396: dup
    //   397: iconst_1
    //   398: iload 7
    //   400: invokestatic 580	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
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
    //   445: ldc_w 569
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
    //   527: ldc 105
    //   529: iconst_0
    //   530: anewarray 4	java/lang/Object
    //   533: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   536: pop
    //   537: ldc_w 582
    //   540: iconst_1
    //   541: anewarray 4	java/lang/Object
    //   544: dup
    //   545: iconst_0
    //   546: aload_1
    //   547: invokevirtual 111	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   550: aastore
    //   551: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   554: pop
    //   555: aload_1
    //   556: invokestatic 114	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   559: ifne +7 -> 566
    //   562: aload_1
    //   563: invokevirtual 117	java/lang/Throwable:printStackTrace	()V
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
    //   639: ldc_w 569
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
    //   663: ldc_w 584
    //   666: astore_0
    //   667: goto +27 -> 694
    //   670: new 129	java/lang/StringBuilder
    //   673: dup
    //   674: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   677: astore_0
    //   678: aload_0
    //   679: aload_1
    //   680: invokeinterface 368 1 0
    //   685: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   688: pop
    //   689: aload_0
    //   690: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   693: astore_0
    //   694: ldc_w 586
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
    //   9: invokeinterface 368 1 0
    //   14: ifne +6 -> 20
    //   17: goto +531 -> 548
    //   20: ldc_w 589
    //   23: iconst_1
    //   24: anewarray 4	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: aload_1
    //   30: invokeinterface 368 1 0
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
    //   74: ldc_w 591
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
    //   104: ldc_w 593
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
    //   124: new 232	java/lang/StringBuffer
    //   127: dup
    //   128: invokespecial 233	java/lang/StringBuffer:<init>	()V
    //   131: astore 4
    //   133: aload_1
    //   134: invokeinterface 542 1 0
    //   139: astore_1
    //   140: aload_1
    //   141: invokeinterface 547 1 0
    //   146: ifeq +102 -> 248
    //   149: aload_1
    //   150: invokeinterface 551 1 0
    //   155: checkcast 352	com/tencent/feedback/proguard/o
    //   158: astore 5
    //   160: aload 4
    //   162: ldc_w 595
    //   165: invokevirtual 247	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   168: pop
    //   169: aload 4
    //   171: ldc_w 327
    //   174: invokevirtual 247	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   177: pop
    //   178: aload 4
    //   180: ldc_w 329
    //   183: invokevirtual 247	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   186: pop
    //   187: aload 4
    //   189: aload 5
    //   191: invokevirtual 354	com/tencent/feedback/proguard/o:a	()Ljava/lang/String;
    //   194: invokevirtual 247	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   197: pop
    //   198: aload 4
    //   200: ldc_w 597
    //   203: invokevirtual 247	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   206: pop
    //   207: aload 4
    //   209: ldc_w 333
    //   212: invokevirtual 247	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   215: pop
    //   216: aload 4
    //   218: ldc_w 335
    //   221: invokevirtual 247	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   224: pop
    //   225: aload 4
    //   227: aload 5
    //   229: invokevirtual 357	com/tencent/feedback/proguard/o:e	()I
    //   232: invokevirtual 338	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   235: pop
    //   236: aload 4
    //   238: ldc_w 388
    //   241: invokevirtual 247	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   244: pop
    //   245: goto -105 -> 140
    //   248: aload 4
    //   250: iconst_2
    //   251: invokevirtual 250	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   254: astore_1
    //   255: aload_3
    //   256: ldc 95
    //   258: aload_1
    //   259: aconst_null
    //   260: invokevirtual 101	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   263: istore_2
    //   264: ldc_w 599
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
    //   305: ldc_w 593
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
    //   414: invokestatic 114	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   417: ifne +8 -> 425
    //   420: aload 4
    //   422: invokevirtual 117	java/lang/Throwable:printStackTrace	()V
    //   425: ldc_w 601
    //   428: iconst_0
    //   429: anewarray 4	java/lang/Object
    //   432: invokestatic 79	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   435: pop
    //   436: ldc_w 603
    //   439: iconst_1
    //   440: anewarray 4	java/lang/Object
    //   443: dup
    //   444: iconst_0
    //   445: aload 4
    //   447: invokevirtual 111	java/lang/Throwable:getMessage	()Ljava/lang/String;
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
    //   478: ldc_w 593
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
    //   527: ldc_w 593
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
    //   552: ldc_w 584
    //   555: astore_0
    //   556: goto +27 -> 583
    //   559: new 129	java/lang/StringBuilder
    //   562: dup
    //   563: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   566: astore_0
    //   567: aload_0
    //   568: aload_1
    //   569: invokeinterface 368 1 0
    //   574: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   577: pop
    //   578: aload_0
    //   579: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   582: astore_0
    //   583: ldc_w 605
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