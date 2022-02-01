package com.tencent.feedback.eup;

import android.content.Context;
import com.tencent.feedback.common.c;
import com.tencent.feedback.proguard.I;
import com.tencent.feedback.proguard.K;
import com.tencent.feedback.proguard.L;
import com.tencent.feedback.proguard.M;
import com.tencent.feedback.proguard.N;
import com.tencent.feedback.proguard.a;
import com.tencent.feedback.proguard.j;
import com.tencent.feedback.proguard.l;
import com.tencent.feedback.proguard.o;
import com.tencent.feedback.upload.AbstractUploadDatas;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class g
  extends AbstractUploadDatas
{
  private static g d;
  private N e = null;
  private List<e> f = null;
  
  private g(Context paramContext)
  {
    super(paramContext, 3, 530);
  }
  
  public static g a(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      if (d == null) {
        d = new g(paramContext);
      }
      paramContext = d;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  private static K a(String paramString1, Context paramContext, String paramString2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +350 -> 351
    //   4: aload_1
    //   5: ifnonnull +6 -> 11
    //   8: goto +343 -> 351
    //   11: ldc 36
    //   13: iconst_1
    //   14: anewarray 38	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_2
    //   20: aastore
    //   21: invokestatic 44	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   24: pop
    //   25: new 46	java/io/File
    //   28: dup
    //   29: aload_2
    //   30: invokespecial 49	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore_2
    //   34: new 46	java/io/File
    //   37: dup
    //   38: aload_1
    //   39: invokevirtual 55	android/content/Context:getCacheDir	()Ljava/io/File;
    //   42: aload_0
    //   43: invokespecial 58	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   46: astore 4
    //   48: aload_2
    //   49: aload 4
    //   51: sipush 5000
    //   54: invokestatic 63	com/tencent/feedback/proguard/a:a	(Ljava/io/File;Ljava/io/File;I)Z
    //   57: ifne +15 -> 72
    //   60: ldc 65
    //   62: iconst_0
    //   63: anewarray 38	java/lang/Object
    //   66: invokestatic 68	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   69: pop
    //   70: aconst_null
    //   71: areturn
    //   72: new 70	java/io/ByteArrayOutputStream
    //   75: dup
    //   76: invokespecial 72	java/io/ByteArrayOutputStream:<init>	()V
    //   79: astore_2
    //   80: new 74	java/io/FileInputStream
    //   83: dup
    //   84: aload 4
    //   86: invokespecial 77	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: astore_1
    //   90: aload_1
    //   91: astore_0
    //   92: sipush 1000
    //   95: newarray byte
    //   97: astore 5
    //   99: aload_1
    //   100: astore_0
    //   101: aload_1
    //   102: aload 5
    //   104: invokevirtual 81	java/io/FileInputStream:read	([B)I
    //   107: istore_3
    //   108: iload_3
    //   109: ifle +22 -> 131
    //   112: aload_1
    //   113: astore_0
    //   114: aload_2
    //   115: aload 5
    //   117: iconst_0
    //   118: iload_3
    //   119: invokevirtual 85	java/io/ByteArrayOutputStream:write	([BII)V
    //   122: aload_1
    //   123: astore_0
    //   124: aload_2
    //   125: invokevirtual 88	java/io/ByteArrayOutputStream:flush	()V
    //   128: goto -29 -> 99
    //   131: aload_1
    //   132: astore_0
    //   133: aload_2
    //   134: invokevirtual 92	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   137: astore_2
    //   138: aload_1
    //   139: astore_0
    //   140: ldc 94
    //   142: iconst_1
    //   143: anewarray 38	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: aload_2
    //   149: arraylength
    //   150: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   153: aastore
    //   154: invokestatic 44	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   157: pop
    //   158: aload_1
    //   159: astore_0
    //   160: new 102	com/tencent/feedback/proguard/K
    //   163: dup
    //   164: iconst_2
    //   165: aload 4
    //   167: invokevirtual 106	java/io/File:getName	()Ljava/lang/String;
    //   170: aload_2
    //   171: invokespecial 109	com/tencent/feedback/proguard/K:<init>	(BLjava/lang/String;[B)V
    //   174: astore_2
    //   175: aload_1
    //   176: invokevirtual 112	java/io/FileInputStream:close	()V
    //   179: goto +15 -> 194
    //   182: astore_0
    //   183: aload_0
    //   184: invokestatic 115	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   187: ifne +7 -> 194
    //   190: aload_0
    //   191: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   194: aload 4
    //   196: invokevirtual 122	java/io/File:exists	()Z
    //   199: ifeq +19 -> 218
    //   202: ldc 124
    //   204: iconst_0
    //   205: anewarray 38	java/lang/Object
    //   208: invokestatic 44	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   211: pop
    //   212: aload 4
    //   214: invokevirtual 127	java/io/File:delete	()Z
    //   217: pop
    //   218: aload_2
    //   219: areturn
    //   220: astore_2
    //   221: goto +12 -> 233
    //   224: astore_0
    //   225: aconst_null
    //   226: astore_1
    //   227: goto +75 -> 302
    //   230: astore_2
    //   231: aconst_null
    //   232: astore_1
    //   233: aload_1
    //   234: astore_0
    //   235: aload_2
    //   236: invokestatic 115	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   239: ifne +9 -> 248
    //   242: aload_1
    //   243: astore_0
    //   244: aload_2
    //   245: invokevirtual 128	java/lang/Throwable:printStackTrace	()V
    //   248: aload_1
    //   249: ifnull +22 -> 271
    //   252: aload_1
    //   253: invokevirtual 112	java/io/FileInputStream:close	()V
    //   256: goto +15 -> 271
    //   259: astore_0
    //   260: aload_0
    //   261: invokestatic 115	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   264: ifne +7 -> 271
    //   267: aload_0
    //   268: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   271: aload 4
    //   273: invokevirtual 122	java/io/File:exists	()Z
    //   276: ifeq +19 -> 295
    //   279: ldc 124
    //   281: iconst_0
    //   282: anewarray 38	java/lang/Object
    //   285: invokestatic 44	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   288: pop
    //   289: aload 4
    //   291: invokevirtual 127	java/io/File:delete	()Z
    //   294: pop
    //   295: aconst_null
    //   296: areturn
    //   297: astore_2
    //   298: aload_0
    //   299: astore_1
    //   300: aload_2
    //   301: astore_0
    //   302: aload_1
    //   303: ifnull +22 -> 325
    //   306: aload_1
    //   307: invokevirtual 112	java/io/FileInputStream:close	()V
    //   310: goto +15 -> 325
    //   313: astore_1
    //   314: aload_1
    //   315: invokestatic 115	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   318: ifne +7 -> 325
    //   321: aload_1
    //   322: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   325: aload 4
    //   327: invokevirtual 122	java/io/File:exists	()Z
    //   330: ifeq +19 -> 349
    //   333: ldc 124
    //   335: iconst_0
    //   336: anewarray 38	java/lang/Object
    //   339: invokestatic 44	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   342: pop
    //   343: aload 4
    //   345: invokevirtual 127	java/io/File:delete	()Z
    //   348: pop
    //   349: aload_0
    //   350: athrow
    //   351: ldc 130
    //   353: iconst_0
    //   354: anewarray 38	java/lang/Object
    //   357: invokestatic 68	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   360: pop
    //   361: aconst_null
    //   362: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	paramString1	String
    //   0	363	1	paramContext	Context
    //   0	363	2	paramString2	String
    //   107	12	3	i	int
    //   46	298	4	localFile	java.io.File
    //   97	19	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   175	179	182	java/io/IOException
    //   92	99	220	java/lang/Throwable
    //   101	108	220	java/lang/Throwable
    //   114	122	220	java/lang/Throwable
    //   124	128	220	java/lang/Throwable
    //   133	138	220	java/lang/Throwable
    //   140	158	220	java/lang/Throwable
    //   160	175	220	java/lang/Throwable
    //   80	90	224	finally
    //   80	90	230	java/lang/Throwable
    //   252	256	259	java/io/IOException
    //   92	99	297	finally
    //   101	108	297	finally
    //   114	122	297	finally
    //   124	128	297	finally
    //   133	138	297	finally
    //   140	158	297	finally
    //   160	175	297	finally
    //   235	242	297	finally
    //   244	248	297	finally
    //   306	310	313	java/io/IOException
  }
  
  private static K a(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (paramString != null))
    {
      if (paramString.trim().length() <= 0) {
        return null;
      }
      try
      {
        K localK = new K();
        localK.a = 1;
        localK.b = paramString;
        localK.c = paramArrayOfByte;
        return localK;
      }
      catch (Throwable paramArrayOfByte)
      {
        if (!com.tencent.feedback.common.e.a(paramArrayOfByte)) {
          paramArrayOfByte.printStackTrace();
        }
        return null;
      }
    }
    return null;
  }
  
  /* Error */
  private L a(Context paramContext, e parame)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +15 -> 16
    //   4: ldc 155
    //   6: iconst_0
    //   7: anewarray 38	java/lang/Object
    //   10: invokestatic 68	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   13: pop
    //   14: aconst_null
    //   15: areturn
    //   16: ldc 157
    //   18: iconst_3
    //   19: anewarray 38	java/lang/Object
    //   22: dup
    //   23: iconst_0
    //   24: aload_2
    //   25: invokevirtual 161	com/tencent/feedback/eup/e:f	()Ljava/lang/String;
    //   28: aastore
    //   29: dup
    //   30: iconst_1
    //   31: aload_2
    //   32: invokevirtual 163	com/tencent/feedback/eup/e:c	()Z
    //   35: invokestatic 168	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   38: aastore
    //   39: dup
    //   40: iconst_2
    //   41: aload_2
    //   42: invokevirtual 172	com/tencent/feedback/eup/e:P	()B
    //   45: invokestatic 177	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   48: aastore
    //   49: invokestatic 44	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   52: pop
    //   53: aload_2
    //   54: invokevirtual 179	com/tencent/feedback/eup/e:d	()Z
    //   57: ifeq +17 -> 74
    //   60: aload_2
    //   61: invokevirtual 163	com/tencent/feedback/eup/e:c	()Z
    //   64: ifeq +2276 -> 2340
    //   67: ldc 181
    //   69: astore 4
    //   71: goto +59 -> 130
    //   74: aload_2
    //   75: invokevirtual 184	com/tencent/feedback/eup/e:x	()Z
    //   78: ifeq +17 -> 95
    //   81: aload_2
    //   82: invokevirtual 163	com/tencent/feedback/eup/e:c	()Z
    //   85: ifeq +2263 -> 2348
    //   88: ldc 186
    //   90: astore 4
    //   92: goto +38 -> 130
    //   95: aload_2
    //   96: invokevirtual 188	com/tencent/feedback/eup/e:b	()Z
    //   99: ifeq +17 -> 116
    //   102: aload_2
    //   103: invokevirtual 163	com/tencent/feedback/eup/e:c	()Z
    //   106: ifeq +2250 -> 2356
    //   109: ldc 190
    //   111: astore 4
    //   113: goto +17 -> 130
    //   116: aload_2
    //   117: invokevirtual 163	com/tencent/feedback/eup/e:c	()Z
    //   120: ifeq +2244 -> 2364
    //   123: ldc 192
    //   125: astore 4
    //   127: goto +3 -> 130
    //   130: new 194	com/tencent/feedback/proguard/L
    //   133: dup
    //   134: invokespecial 195	com/tencent/feedback/proguard/L:<init>	()V
    //   137: astore 5
    //   139: aload 5
    //   141: aload 4
    //   143: putfield 197	com/tencent/feedback/proguard/L:a	Ljava/lang/String;
    //   146: aload 5
    //   148: aload_2
    //   149: invokevirtual 201	com/tencent/feedback/eup/e:i	()J
    //   152: putfield 204	com/tencent/feedback/proguard/L:b	J
    //   155: new 206	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   162: astore 4
    //   164: aload 4
    //   166: aload_2
    //   167: invokevirtual 209	com/tencent/feedback/eup/e:e	()Ljava/lang/String;
    //   170: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 5
    //   176: aload 4
    //   178: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: putfield 218	com/tencent/feedback/proguard/L:c	Ljava/lang/String;
    //   184: aload 5
    //   186: aload_2
    //   187: invokevirtual 161	com/tencent/feedback/eup/e:f	()Ljava/lang/String;
    //   190: putfield 220	com/tencent/feedback/proguard/L:d	Ljava/lang/String;
    //   193: new 206	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   200: astore 4
    //   202: aload 4
    //   204: aload_2
    //   205: invokevirtual 223	com/tencent/feedback/eup/e:g	()Ljava/lang/String;
    //   208: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload 5
    //   214: aload 4
    //   216: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: putfield 225	com/tencent/feedback/proguard/L:e	Ljava/lang/String;
    //   222: aload 5
    //   224: aload_2
    //   225: invokevirtual 229	com/tencent/feedback/eup/e:C	()Ljava/util/Map;
    //   228: putfield 233	com/tencent/feedback/proguard/L:h	Ljava/util/Map;
    //   231: aload 5
    //   233: aload_2
    //   234: invokevirtual 235	com/tencent/feedback/eup/e:h	()Ljava/lang/String;
    //   237: putfield 237	com/tencent/feedback/proguard/L:g	Ljava/lang/String;
    //   240: aload 5
    //   242: aload_2
    //   243: invokevirtual 240	com/tencent/feedback/eup/e:v	()Ljava/lang/String;
    //   246: putfield 242	com/tencent/feedback/proguard/L:i	Ljava/lang/String;
    //   249: aload 5
    //   251: aload_2
    //   252: invokevirtual 245	com/tencent/feedback/eup/e:k	()Ljava/lang/String;
    //   255: putfield 247	com/tencent/feedback/proguard/L:k	Ljava/lang/String;
    //   258: aload 5
    //   260: aload_2
    //   261: invokevirtual 250	com/tencent/feedback/eup/e:D	()Ljava/lang/String;
    //   264: putfield 253	com/tencent/feedback/proguard/L:l	Ljava/lang/String;
    //   267: aload 5
    //   269: aload_2
    //   270: invokevirtual 256	com/tencent/feedback/eup/e:r	()Ljava/lang/String;
    //   273: putfield 258	com/tencent/feedback/proguard/L:f	Ljava/lang/String;
    //   276: aload_2
    //   277: invokevirtual 261	com/tencent/feedback/eup/e:u	()Ljava/util/Map;
    //   280: astore 4
    //   282: aload 4
    //   284: ifnonnull +8 -> 292
    //   287: iconst_0
    //   288: istore_3
    //   289: goto +11 -> 300
    //   292: aload 4
    //   294: invokeinterface 266 1 0
    //   299: istore_3
    //   300: ldc_w 268
    //   303: iconst_1
    //   304: anewarray 38	java/lang/Object
    //   307: dup
    //   308: iconst_0
    //   309: iload_3
    //   310: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   313: aastore
    //   314: invokestatic 44	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   317: pop
    //   318: aload 4
    //   320: ifnull +138 -> 458
    //   323: aload 4
    //   325: invokeinterface 266 1 0
    //   330: ifle +128 -> 458
    //   333: aload 5
    //   335: new 270	java/util/ArrayList
    //   338: dup
    //   339: invokespecial 271	java/util/ArrayList:<init>	()V
    //   342: putfield 275	com/tencent/feedback/proguard/L:n	Ljava/util/ArrayList;
    //   345: aload 4
    //   347: invokeinterface 279 1 0
    //   352: invokeinterface 285 1 0
    //   357: astore 4
    //   359: aload 4
    //   361: invokeinterface 290 1 0
    //   366: ifeq +92 -> 458
    //   369: aload 4
    //   371: invokeinterface 294 1 0
    //   376: checkcast 296	java/util/Map$Entry
    //   379: astore 6
    //   381: new 298	com/tencent/feedback/proguard/I
    //   384: dup
    //   385: invokespecial 299	com/tencent/feedback/proguard/I:<init>	()V
    //   388: astore 7
    //   390: aload 7
    //   392: aload 6
    //   394: invokeinterface 302 1 0
    //   399: checkcast 304	com/tencent/feedback/common/PlugInInfo
    //   402: getfield 307	com/tencent/feedback/common/PlugInInfo:plugInId	Ljava/lang/String;
    //   405: putfield 308	com/tencent/feedback/proguard/I:a	Ljava/lang/String;
    //   408: aload 7
    //   410: aload 6
    //   412: invokeinterface 302 1 0
    //   417: checkcast 304	com/tencent/feedback/common/PlugInInfo
    //   420: getfield 311	com/tencent/feedback/common/PlugInInfo:plugInUUID	Ljava/lang/String;
    //   423: putfield 312	com/tencent/feedback/proguard/I:c	Ljava/lang/String;
    //   426: aload 7
    //   428: aload 6
    //   430: invokeinterface 302 1 0
    //   435: checkcast 304	com/tencent/feedback/common/PlugInInfo
    //   438: getfield 315	com/tencent/feedback/common/PlugInInfo:plugInVersion	Ljava/lang/String;
    //   441: putfield 316	com/tencent/feedback/proguard/I:d	Ljava/lang/String;
    //   444: aload 5
    //   446: getfield 275	com/tencent/feedback/proguard/L:n	Ljava/util/ArrayList;
    //   449: aload 7
    //   451: invokevirtual 320	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   454: pop
    //   455: goto -96 -> 359
    //   458: aload_2
    //   459: invokevirtual 163	com/tencent/feedback/eup/e:c	()Z
    //   462: ifeq +87 -> 549
    //   465: aload_2
    //   466: invokevirtual 323	com/tencent/feedback/eup/e:m	()I
    //   469: iconst_1
    //   470: if_icmple +79 -> 549
    //   473: aload 5
    //   475: aload_2
    //   476: invokevirtual 323	com/tencent/feedback/eup/e:m	()I
    //   479: putfield 327	com/tencent/feedback/proguard/L:j	I
    //   482: aload_2
    //   483: invokevirtual 329	com/tencent/feedback/eup/e:l	()Ljava/lang/String;
    //   486: ifnull +63 -> 549
    //   489: aload_2
    //   490: invokevirtual 329	com/tencent/feedback/eup/e:l	()Ljava/lang/String;
    //   493: invokevirtual 140	java/lang/String:length	()I
    //   496: ifle +53 -> 549
    //   499: aload 5
    //   501: getfield 332	com/tencent/feedback/proguard/L:o	Ljava/util/ArrayList;
    //   504: ifnonnull +15 -> 519
    //   507: aload 5
    //   509: new 270	java/util/ArrayList
    //   512: dup
    //   513: invokespecial 271	java/util/ArrayList:<init>	()V
    //   516: putfield 332	com/tencent/feedback/proguard/L:o	Ljava/util/ArrayList;
    //   519: aload 5
    //   521: getfield 332	com/tencent/feedback/proguard/L:o	Ljava/util/ArrayList;
    //   524: new 102	com/tencent/feedback/proguard/K
    //   527: dup
    //   528: iconst_1
    //   529: ldc_w 334
    //   532: aload_2
    //   533: invokevirtual 329	com/tencent/feedback/eup/e:l	()Ljava/lang/String;
    //   536: ldc_w 336
    //   539: invokevirtual 340	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   542: invokespecial 109	com/tencent/feedback/proguard/K:<init>	(BLjava/lang/String;[B)V
    //   545: invokevirtual 320	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   548: pop
    //   549: aload_2
    //   550: invokevirtual 342	com/tencent/feedback/eup/e:n	()[B
    //   553: ifnull +47 -> 600
    //   556: aload 5
    //   558: getfield 332	com/tencent/feedback/proguard/L:o	Ljava/util/ArrayList;
    //   561: ifnonnull +15 -> 576
    //   564: aload 5
    //   566: new 270	java/util/ArrayList
    //   569: dup
    //   570: invokespecial 271	java/util/ArrayList:<init>	()V
    //   573: putfield 332	com/tencent/feedback/proguard/L:o	Ljava/util/ArrayList;
    //   576: aload 5
    //   578: getfield 332	com/tencent/feedback/proguard/L:o	Ljava/util/ArrayList;
    //   581: new 102	com/tencent/feedback/proguard/K
    //   584: dup
    //   585: iconst_1
    //   586: ldc_w 344
    //   589: aload_2
    //   590: invokevirtual 342	com/tencent/feedback/eup/e:n	()[B
    //   593: invokespecial 109	com/tencent/feedback/proguard/K:<init>	(BLjava/lang/String;[B)V
    //   596: invokevirtual 320	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   599: pop
    //   600: aload_2
    //   601: invokevirtual 347	com/tencent/feedback/eup/e:s	()Ljava/lang/String;
    //   604: ifnull +75 -> 679
    //   607: aload_2
    //   608: invokevirtual 184	com/tencent/feedback/eup/e:x	()Z
    //   611: ifne +68 -> 679
    //   614: aload_2
    //   615: invokevirtual 347	com/tencent/feedback/eup/e:s	()Ljava/lang/String;
    //   618: ldc_w 349
    //   621: invokevirtual 340	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   624: ldc_w 351
    //   627: invokestatic 353	com/tencent/feedback/eup/g:a	([BLjava/lang/String;)Lcom/tencent/feedback/proguard/K;
    //   630: astore 4
    //   632: aload 4
    //   634: ifnull +45 -> 679
    //   637: aload 5
    //   639: getfield 332	com/tencent/feedback/proguard/L:o	Ljava/util/ArrayList;
    //   642: ifnonnull +15 -> 657
    //   645: aload 5
    //   647: new 270	java/util/ArrayList
    //   650: dup
    //   651: invokespecial 271	java/util/ArrayList:<init>	()V
    //   654: putfield 332	com/tencent/feedback/proguard/L:o	Ljava/util/ArrayList;
    //   657: ldc_w 355
    //   660: iconst_0
    //   661: anewarray 38	java/lang/Object
    //   664: invokestatic 44	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   667: pop
    //   668: aload 5
    //   670: getfield 332	com/tencent/feedback/proguard/L:o	Ljava/util/ArrayList;
    //   673: aload 4
    //   675: invokevirtual 320	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   678: pop
    //   679: aload_2
    //   680: invokevirtual 358	com/tencent/feedback/eup/e:t	()[B
    //   683: ifnull +62 -> 745
    //   686: aload_2
    //   687: invokevirtual 358	com/tencent/feedback/eup/e:t	()[B
    //   690: ldc_w 360
    //   693: invokestatic 353	com/tencent/feedback/eup/g:a	([BLjava/lang/String;)Lcom/tencent/feedback/proguard/K;
    //   696: astore 4
    //   698: aload 4
    //   700: ifnull +45 -> 745
    //   703: ldc_w 362
    //   706: iconst_0
    //   707: anewarray 38	java/lang/Object
    //   710: invokestatic 44	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   713: pop
    //   714: aload 5
    //   716: getfield 332	com/tencent/feedback/proguard/L:o	Ljava/util/ArrayList;
    //   719: ifnonnull +15 -> 734
    //   722: aload 5
    //   724: new 270	java/util/ArrayList
    //   727: dup
    //   728: invokespecial 271	java/util/ArrayList:<init>	()V
    //   731: putfield 332	com/tencent/feedback/proguard/L:o	Ljava/util/ArrayList;
    //   734: aload 5
    //   736: getfield 332	com/tencent/feedback/proguard/L:o	Ljava/util/ArrayList;
    //   739: aload 4
    //   741: invokevirtual 320	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   744: pop
    //   745: aload_2
    //   746: invokevirtual 184	com/tencent/feedback/eup/e:x	()Z
    //   749: ifeq +127 -> 876
    //   752: aload_2
    //   753: invokevirtual 365	com/tencent/feedback/eup/e:p	()Ljava/lang/String;
    //   756: ifnull +120 -> 876
    //   759: aload 5
    //   761: getfield 332	com/tencent/feedback/proguard/L:o	Ljava/util/ArrayList;
    //   764: ifnonnull +15 -> 779
    //   767: aload 5
    //   769: new 270	java/util/ArrayList
    //   772: dup
    //   773: invokespecial 271	java/util/ArrayList:<init>	()V
    //   776: putfield 332	com/tencent/feedback/proguard/L:o	Ljava/util/ArrayList;
    //   779: aload 5
    //   781: getfield 332	com/tencent/feedback/proguard/L:o	Ljava/util/ArrayList;
    //   784: new 102	com/tencent/feedback/proguard/K
    //   787: dup
    //   788: iconst_1
    //   789: ldc_w 367
    //   792: aload_2
    //   793: invokevirtual 347	com/tencent/feedback/eup/e:s	()Ljava/lang/String;
    //   796: ldc_w 349
    //   799: invokevirtual 340	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   802: invokespecial 109	com/tencent/feedback/proguard/K:<init>	(BLjava/lang/String;[B)V
    //   805: invokevirtual 320	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   808: pop
    //   809: ldc_w 369
    //   812: iconst_0
    //   813: anewarray 38	java/lang/Object
    //   816: invokestatic 44	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   819: pop
    //   820: goto +16 -> 836
    //   823: astore 4
    //   825: aload 4
    //   827: invokevirtual 370	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   830: aload 5
    //   832: aconst_null
    //   833: putfield 332	com/tencent/feedback/proguard/L:o	Ljava/util/ArrayList;
    //   836: ldc_w 372
    //   839: aload_1
    //   840: aload_2
    //   841: invokevirtual 365	com/tencent/feedback/eup/e:p	()Ljava/lang/String;
    //   844: invokestatic 374	com/tencent/feedback/eup/g:a	(Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/feedback/proguard/K;
    //   847: astore 4
    //   849: aload 4
    //   851: ifnull +25 -> 876
    //   854: ldc_w 376
    //   857: iconst_0
    //   858: anewarray 38	java/lang/Object
    //   861: invokestatic 44	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   864: pop
    //   865: aload 5
    //   867: getfield 332	com/tencent/feedback/proguard/L:o	Ljava/util/ArrayList;
    //   870: aload 4
    //   872: invokevirtual 320	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   875: pop
    //   876: aload_1
    //   877: invokestatic 381	com/tencent/feedback/common/c:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/c;
    //   880: astore 4
    //   882: aload 5
    //   884: new 383	java/util/HashMap
    //   887: dup
    //   888: invokespecial 384	java/util/HashMap:<init>	()V
    //   891: putfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   894: aload 5
    //   896: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   899: astore 6
    //   901: new 206	java/lang/StringBuilder
    //   904: dup
    //   905: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   908: astore 7
    //   910: aload 7
    //   912: aload_2
    //   913: invokevirtual 389	com/tencent/feedback/eup/e:F	()J
    //   916: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   919: pop
    //   920: aload 6
    //   922: ldc_w 394
    //   925: aload 7
    //   927: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   930: invokeinterface 398 3 0
    //   935: pop
    //   936: aload 5
    //   938: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   941: astore 6
    //   943: new 206	java/lang/StringBuilder
    //   946: dup
    //   947: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   950: astore 7
    //   952: aload 7
    //   954: aload_2
    //   955: invokevirtual 401	com/tencent/feedback/eup/e:G	()J
    //   958: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   961: pop
    //   962: aload 6
    //   964: ldc_w 403
    //   967: aload 7
    //   969: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   972: invokeinterface 398 3 0
    //   977: pop
    //   978: aload 5
    //   980: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   983: astore 6
    //   985: new 206	java/lang/StringBuilder
    //   988: dup
    //   989: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   992: astore 7
    //   994: aload 7
    //   996: aload_2
    //   997: invokevirtual 406	com/tencent/feedback/eup/e:H	()J
    //   1000: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1003: pop
    //   1004: aload 6
    //   1006: ldc_w 408
    //   1009: aload 7
    //   1011: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1014: invokeinterface 398 3 0
    //   1019: pop
    //   1020: aload 5
    //   1022: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   1025: astore 6
    //   1027: new 206	java/lang/StringBuilder
    //   1030: dup
    //   1031: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   1034: astore 7
    //   1036: aload 7
    //   1038: aload_2
    //   1039: invokevirtual 411	com/tencent/feedback/eup/e:N	()Ljava/lang/String;
    //   1042: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: pop
    //   1046: aload 6
    //   1048: ldc_w 413
    //   1051: aload 7
    //   1053: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1056: invokeinterface 398 3 0
    //   1061: pop
    //   1062: aload 5
    //   1064: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   1067: astore 6
    //   1069: new 206	java/lang/StringBuilder
    //   1072: dup
    //   1073: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   1076: astore 7
    //   1078: aload 7
    //   1080: aload 4
    //   1082: invokevirtual 415	com/tencent/feedback/common/c:d	()Ljava/lang/String;
    //   1085: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1088: pop
    //   1089: aload 6
    //   1091: ldc_w 417
    //   1094: aload 7
    //   1096: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1099: invokeinterface 398 3 0
    //   1104: pop
    //   1105: aload 5
    //   1107: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   1110: astore 6
    //   1112: new 206	java/lang/StringBuilder
    //   1115: dup
    //   1116: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   1119: astore 7
    //   1121: aload 7
    //   1123: aload 4
    //   1125: invokevirtual 420	com/tencent/feedback/common/c:w	()Ljava/lang/String;
    //   1128: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1131: pop
    //   1132: aload 6
    //   1134: ldc_w 422
    //   1137: aload 7
    //   1139: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1142: invokeinterface 398 3 0
    //   1147: pop
    //   1148: aload 5
    //   1150: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   1153: astore 6
    //   1155: new 206	java/lang/StringBuilder
    //   1158: dup
    //   1159: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   1162: astore 7
    //   1164: aload 7
    //   1166: aload 4
    //   1168: invokevirtual 423	com/tencent/feedback/common/c:v	()Ljava/lang/String;
    //   1171: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1174: pop
    //   1175: aload 6
    //   1177: ldc_w 425
    //   1180: aload 7
    //   1182: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1185: invokeinterface 398 3 0
    //   1190: pop
    //   1191: aload 5
    //   1193: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   1196: astore 6
    //   1198: new 206	java/lang/StringBuilder
    //   1201: dup
    //   1202: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   1205: astore 7
    //   1207: aload 7
    //   1209: aload 4
    //   1211: invokevirtual 426	com/tencent/feedback/common/c:h	()Ljava/lang/String;
    //   1214: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1217: pop
    //   1218: aload 6
    //   1220: ldc_w 428
    //   1223: aload 7
    //   1225: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1228: invokeinterface 398 3 0
    //   1233: pop
    //   1234: aload 5
    //   1236: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   1239: astore 6
    //   1241: new 206	java/lang/StringBuilder
    //   1244: dup
    //   1245: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   1248: astore 7
    //   1250: aload 7
    //   1252: aload_2
    //   1253: invokevirtual 430	com/tencent/feedback/eup/e:J	()J
    //   1256: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1259: pop
    //   1260: aload 6
    //   1262: ldc_w 432
    //   1265: aload 7
    //   1267: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1270: invokeinterface 398 3 0
    //   1275: pop
    //   1276: aload 5
    //   1278: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   1281: astore 6
    //   1283: new 206	java/lang/StringBuilder
    //   1286: dup
    //   1287: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   1290: astore 7
    //   1292: aload 7
    //   1294: aload_2
    //   1295: invokevirtual 434	com/tencent/feedback/eup/e:I	()J
    //   1298: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1301: pop
    //   1302: aload 6
    //   1304: ldc_w 436
    //   1307: aload 7
    //   1309: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1312: invokeinterface 398 3 0
    //   1317: pop
    //   1318: aload 5
    //   1320: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   1323: astore 6
    //   1325: new 206	java/lang/StringBuilder
    //   1328: dup
    //   1329: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   1332: astore 7
    //   1334: aload 7
    //   1336: aload 4
    //   1338: invokevirtual 437	com/tencent/feedback/common/c:f	()Ljava/lang/String;
    //   1341: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1344: pop
    //   1345: aload 6
    //   1347: ldc_w 439
    //   1350: aload 7
    //   1352: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1355: invokeinterface 398 3 0
    //   1360: pop
    //   1361: aload 5
    //   1363: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   1366: astore 6
    //   1368: new 206	java/lang/StringBuilder
    //   1371: dup
    //   1372: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   1375: astore 7
    //   1377: aload 7
    //   1379: aload_2
    //   1380: invokevirtual 442	com/tencent/feedback/eup/e:K	()J
    //   1383: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1386: pop
    //   1387: aload 6
    //   1389: ldc_w 444
    //   1392: aload 7
    //   1394: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1397: invokeinterface 398 3 0
    //   1402: pop
    //   1403: aload 5
    //   1405: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   1408: astore 6
    //   1410: new 206	java/lang/StringBuilder
    //   1413: dup
    //   1414: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   1417: astore 7
    //   1419: aload 7
    //   1421: aload 4
    //   1423: invokevirtual 446	com/tencent/feedback/common/c:o	()Ljava/lang/String;
    //   1426: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1429: pop
    //   1430: aload 6
    //   1432: ldc_w 448
    //   1435: aload 7
    //   1437: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1440: invokeinterface 398 3 0
    //   1445: pop
    //   1446: aload 5
    //   1448: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   1451: astore 6
    //   1453: new 206	java/lang/StringBuilder
    //   1456: dup
    //   1457: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   1460: astore 7
    //   1462: aload 7
    //   1464: aload 4
    //   1466: invokevirtual 451	com/tencent/feedback/common/c:q	()Ljava/lang/String;
    //   1469: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1472: pop
    //   1473: aload 6
    //   1475: ldc_w 453
    //   1478: aload 7
    //   1480: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1483: invokeinterface 398 3 0
    //   1488: pop
    //   1489: aload 5
    //   1491: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   1494: astore 6
    //   1496: new 206	java/lang/StringBuilder
    //   1499: dup
    //   1500: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   1503: astore 7
    //   1505: aload 7
    //   1507: aload 4
    //   1509: invokevirtual 454	com/tencent/feedback/common/c:r	()Ljava/lang/String;
    //   1512: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1515: pop
    //   1516: aload 6
    //   1518: ldc_w 456
    //   1521: aload 7
    //   1523: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1526: invokeinterface 398 3 0
    //   1531: pop
    //   1532: aload 5
    //   1534: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   1537: astore 6
    //   1539: new 206	java/lang/StringBuilder
    //   1542: dup
    //   1543: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   1546: astore 7
    //   1548: aload 7
    //   1550: aload 4
    //   1552: invokevirtual 457	com/tencent/feedback/common/c:p	()Ljava/lang/String;
    //   1555: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1558: pop
    //   1559: aload 6
    //   1561: ldc_w 459
    //   1564: aload 7
    //   1566: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1569: invokeinterface 398 3 0
    //   1574: pop
    //   1575: aload 5
    //   1577: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   1580: astore 6
    //   1582: new 206	java/lang/StringBuilder
    //   1585: dup
    //   1586: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   1589: astore 7
    //   1591: aload 7
    //   1593: aload 4
    //   1595: invokevirtual 462	com/tencent/feedback/common/c:z	()Ljava/lang/String;
    //   1598: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1601: pop
    //   1602: aload 6
    //   1604: ldc_w 464
    //   1607: aload 7
    //   1609: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1612: invokeinterface 398 3 0
    //   1617: pop
    //   1618: aload 5
    //   1620: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   1623: astore 6
    //   1625: new 206	java/lang/StringBuilder
    //   1628: dup
    //   1629: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   1632: astore 7
    //   1634: aload 7
    //   1636: aload 4
    //   1638: invokevirtual 466	com/tencent/feedback/common/c:C	()Z
    //   1641: invokevirtual 469	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1644: pop
    //   1645: aload 6
    //   1647: ldc_w 471
    //   1650: aload 7
    //   1652: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1655: invokeinterface 398 3 0
    //   1660: pop
    //   1661: aload 5
    //   1663: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   1666: astore 6
    //   1668: new 206	java/lang/StringBuilder
    //   1671: dup
    //   1672: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   1675: astore 7
    //   1677: aload 7
    //   1679: aload_2
    //   1680: invokevirtual 472	com/tencent/feedback/eup/e:q	()Ljava/lang/String;
    //   1683: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1686: pop
    //   1687: aload 6
    //   1689: ldc_w 474
    //   1692: aload 7
    //   1694: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1697: invokeinterface 398 3 0
    //   1702: pop
    //   1703: aload 5
    //   1705: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   1708: astore 6
    //   1710: new 206	java/lang/StringBuilder
    //   1713: dup
    //   1714: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   1717: astore 7
    //   1719: aload 7
    //   1721: aload_2
    //   1722: invokevirtual 476	com/tencent/feedback/eup/e:B	()Ljava/lang/String;
    //   1725: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1728: pop
    //   1729: aload 6
    //   1731: ldc_w 478
    //   1734: aload 7
    //   1736: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1739: invokeinterface 398 3 0
    //   1744: pop
    //   1745: aload 5
    //   1747: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   1750: astore 6
    //   1752: aload 4
    //   1754: invokevirtual 479	com/tencent/feedback/common/c:k	()Ljava/lang/String;
    //   1757: invokevirtual 136	java/lang/String:trim	()Ljava/lang/String;
    //   1760: invokevirtual 140	java/lang/String:length	()I
    //   1763: ifle +13 -> 1776
    //   1766: aload 4
    //   1768: invokevirtual 479	com/tencent/feedback/common/c:k	()Ljava/lang/String;
    //   1771: astore 4
    //   1773: goto +10 -> 1783
    //   1776: aload 4
    //   1778: invokevirtual 480	com/tencent/feedback/common/c:l	()Ljava/lang/String;
    //   1781: astore 4
    //   1783: aload 6
    //   1785: ldc_w 482
    //   1788: aload 4
    //   1790: invokeinterface 398 3 0
    //   1795: pop
    //   1796: aload_2
    //   1797: invokevirtual 179	com/tencent/feedback/eup/e:d	()Z
    //   1800: ifeq +129 -> 1929
    //   1803: aload 5
    //   1805: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   1808: astore 4
    //   1810: new 206	java/lang/StringBuilder
    //   1813: dup
    //   1814: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   1817: astore 6
    //   1819: aload 6
    //   1821: aload_2
    //   1822: invokevirtual 485	com/tencent/feedback/eup/e:A	()Ljava/lang/String;
    //   1825: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1828: pop
    //   1829: aload 4
    //   1831: ldc_w 487
    //   1834: aload 6
    //   1836: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1839: invokeinterface 398 3 0
    //   1844: pop
    //   1845: aload 5
    //   1847: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   1850: astore 4
    //   1852: new 206	java/lang/StringBuilder
    //   1855: dup
    //   1856: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   1859: astore 6
    //   1861: aload 6
    //   1863: aload_2
    //   1864: invokevirtual 488	com/tencent/feedback/eup/e:z	()Ljava/lang/String;
    //   1867: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1870: pop
    //   1871: aload 4
    //   1873: ldc_w 490
    //   1876: aload 6
    //   1878: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1881: invokeinterface 398 3 0
    //   1886: pop
    //   1887: aload 5
    //   1889: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   1892: astore 4
    //   1894: new 206	java/lang/StringBuilder
    //   1897: dup
    //   1898: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   1901: astore 6
    //   1903: aload 6
    //   1905: aload_2
    //   1906: invokevirtual 493	com/tencent/feedback/eup/e:E	()Z
    //   1909: invokevirtual 469	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1912: pop
    //   1913: aload 4
    //   1915: ldc_w 495
    //   1918: aload 6
    //   1920: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1923: invokeinterface 398 3 0
    //   1928: pop
    //   1929: aload_1
    //   1930: invokestatic 498	com/tencent/feedback/eup/g:b	(Landroid/content/Context;)Ljava/util/ArrayList;
    //   1933: astore_1
    //   1934: aload_1
    //   1935: ifnull +16 -> 1951
    //   1938: aload_1
    //   1939: invokevirtual 499	java/util/ArrayList:size	()I
    //   1942: ifle +9 -> 1951
    //   1945: aload 5
    //   1947: aload_1
    //   1948: putfield 501	com/tencent/feedback/proguard/L:m	Ljava/util/ArrayList;
    //   1951: aload 5
    //   1953: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   1956: astore_1
    //   1957: new 206	java/lang/StringBuilder
    //   1960: dup
    //   1961: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   1964: astore 4
    //   1966: aload 4
    //   1968: aload_2
    //   1969: invokevirtual 504	com/tencent/feedback/eup/e:y	()Ljava/lang/String;
    //   1972: ldc_w 336
    //   1975: invokestatic 510	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1978: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1981: pop
    //   1982: aload_1
    //   1983: ldc_w 512
    //   1986: aload 4
    //   1988: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1991: invokeinterface 398 3 0
    //   1996: pop
    //   1997: aload_2
    //   1998: getfield 514	com/tencent/feedback/eup/e:a	I
    //   2001: iflt +43 -> 2044
    //   2004: aload 5
    //   2006: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   2009: astore_1
    //   2010: new 206	java/lang/StringBuilder
    //   2013: dup
    //   2014: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   2017: astore 4
    //   2019: aload 4
    //   2021: aload_2
    //   2022: getfield 514	com/tencent/feedback/eup/e:a	I
    //   2025: invokevirtual 517	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2028: pop
    //   2029: aload_1
    //   2030: ldc_w 519
    //   2033: aload 4
    //   2035: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2038: invokeinterface 398 3 0
    //   2043: pop
    //   2044: aload_2
    //   2045: getfield 521	com/tencent/feedback/eup/e:b	I
    //   2048: iflt +43 -> 2091
    //   2051: aload 5
    //   2053: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   2056: astore_1
    //   2057: new 206	java/lang/StringBuilder
    //   2060: dup
    //   2061: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   2064: astore 4
    //   2066: aload 4
    //   2068: aload_2
    //   2069: getfield 521	com/tencent/feedback/eup/e:b	I
    //   2072: invokevirtual 517	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2075: pop
    //   2076: aload_1
    //   2077: ldc_w 523
    //   2080: aload 4
    //   2082: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2085: invokeinterface 398 3 0
    //   2090: pop
    //   2091: aload_2
    //   2092: getfield 525	com/tencent/feedback/eup/e:c	Ljava/util/Map;
    //   2095: ifnull +108 -> 2203
    //   2098: aload_2
    //   2099: getfield 525	com/tencent/feedback/eup/e:c	Ljava/util/Map;
    //   2102: invokeinterface 266 1 0
    //   2107: ifle +96 -> 2203
    //   2110: aload_2
    //   2111: getfield 525	com/tencent/feedback/eup/e:c	Ljava/util/Map;
    //   2114: invokeinterface 279 1 0
    //   2119: invokeinterface 285 1 0
    //   2124: astore_1
    //   2125: aload_1
    //   2126: invokeinterface 290 1 0
    //   2131: ifeq +72 -> 2203
    //   2134: aload_1
    //   2135: invokeinterface 294 1 0
    //   2140: checkcast 296	java/util/Map$Entry
    //   2143: astore 4
    //   2145: aload 5
    //   2147: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   2150: astore 6
    //   2152: new 206	java/lang/StringBuilder
    //   2155: dup
    //   2156: ldc_w 527
    //   2159: invokespecial 528	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2162: astore 7
    //   2164: aload 7
    //   2166: aload 4
    //   2168: invokeinterface 531 1 0
    //   2173: checkcast 133	java/lang/String
    //   2176: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2179: pop
    //   2180: aload 6
    //   2182: aload 7
    //   2184: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2187: aload 4
    //   2189: invokeinterface 302 1 0
    //   2194: invokeinterface 398 3 0
    //   2199: pop
    //   2200: goto -75 -> 2125
    //   2203: aload_2
    //   2204: getfield 533	com/tencent/feedback/eup/e:d	Ljava/util/Map;
    //   2207: ifnull +165 -> 2372
    //   2210: aload_2
    //   2211: getfield 533	com/tencent/feedback/eup/e:d	Ljava/util/Map;
    //   2214: invokeinterface 266 1 0
    //   2219: ifle +153 -> 2372
    //   2222: aload_2
    //   2223: getfield 533	com/tencent/feedback/eup/e:d	Ljava/util/Map;
    //   2226: invokeinterface 279 1 0
    //   2231: invokeinterface 285 1 0
    //   2236: astore_1
    //   2237: aload_1
    //   2238: invokeinterface 290 1 0
    //   2243: ifeq +129 -> 2372
    //   2246: aload_1
    //   2247: invokeinterface 294 1 0
    //   2252: checkcast 296	java/util/Map$Entry
    //   2255: astore_2
    //   2256: aload 5
    //   2258: getfield 386	com/tencent/feedback/proguard/L:p	Ljava/util/Map;
    //   2261: astore 4
    //   2263: new 206	java/lang/StringBuilder
    //   2266: dup
    //   2267: ldc_w 535
    //   2270: invokespecial 528	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2273: astore 6
    //   2275: aload 6
    //   2277: aload_2
    //   2278: invokeinterface 531 1 0
    //   2283: checkcast 133	java/lang/String
    //   2286: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2289: pop
    //   2290: aload 4
    //   2292: aload 6
    //   2294: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2297: aload_2
    //   2298: invokeinterface 302 1 0
    //   2303: invokeinterface 398 3 0
    //   2308: pop
    //   2309: goto -72 -> 2237
    //   2312: astore_1
    //   2313: aload_1
    //   2314: invokestatic 115	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   2317: ifne +7 -> 2324
    //   2320: aload_1
    //   2321: invokevirtual 370	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   2324: aconst_null
    //   2325: areturn
    //   2326: astore_1
    //   2327: aload_1
    //   2328: invokestatic 115	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   2331: ifne +7 -> 2338
    //   2334: aload_1
    //   2335: invokevirtual 128	java/lang/Throwable:printStackTrace	()V
    //   2338: aconst_null
    //   2339: areturn
    //   2340: ldc_w 537
    //   2343: astore 4
    //   2345: goto -2215 -> 130
    //   2348: ldc_w 539
    //   2351: astore 4
    //   2353: goto -2223 -> 130
    //   2356: ldc_w 541
    //   2359: astore 4
    //   2361: goto -2231 -> 130
    //   2364: ldc_w 543
    //   2367: astore 4
    //   2369: goto -2239 -> 130
    //   2372: aload 5
    //   2374: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2375	0	this	g
    //   0	2375	1	paramContext	Context
    //   0	2375	2	parame	e
    //   288	22	3	i	int
    //   69	671	4	localObject1	Object
    //   823	3	4	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   847	1521	4	localObject2	Object
    //   137	2236	5	localL	L
    //   379	1914	6	localObject3	Object
    //   388	1795	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   779	820	823	java/io/UnsupportedEncodingException
    //   1951	1997	2312	java/io/UnsupportedEncodingException
    //   53	67	2326	java/lang/Throwable
    //   74	88	2326	java/lang/Throwable
    //   95	109	2326	java/lang/Throwable
    //   116	123	2326	java/lang/Throwable
    //   130	282	2326	java/lang/Throwable
    //   292	300	2326	java/lang/Throwable
    //   300	318	2326	java/lang/Throwable
    //   323	359	2326	java/lang/Throwable
    //   359	455	2326	java/lang/Throwable
    //   458	519	2326	java/lang/Throwable
    //   519	549	2326	java/lang/Throwable
    //   549	576	2326	java/lang/Throwable
    //   576	600	2326	java/lang/Throwable
    //   600	632	2326	java/lang/Throwable
    //   637	657	2326	java/lang/Throwable
    //   657	679	2326	java/lang/Throwable
    //   679	698	2326	java/lang/Throwable
    //   703	734	2326	java/lang/Throwable
    //   734	745	2326	java/lang/Throwable
    //   745	779	2326	java/lang/Throwable
    //   779	820	2326	java/lang/Throwable
    //   825	836	2326	java/lang/Throwable
    //   836	849	2326	java/lang/Throwable
    //   854	876	2326	java/lang/Throwable
    //   876	1773	2326	java/lang/Throwable
    //   1776	1783	2326	java/lang/Throwable
    //   1783	1929	2326	java/lang/Throwable
    //   1929	1934	2326	java/lang/Throwable
    //   1938	1951	2326	java/lang/Throwable
    //   1951	1997	2326	java/lang/Throwable
    //   1997	2044	2326	java/lang/Throwable
    //   2044	2091	2326	java/lang/Throwable
    //   2091	2125	2326	java/lang/Throwable
    //   2125	2200	2326	java/lang/Throwable
    //   2203	2237	2326	java/lang/Throwable
    //   2237	2309	2326	java/lang/Throwable
    //   2313	2324	2326	java/lang/Throwable
  }
  
  private M a(Context paramContext, List<e> paramList)
  {
    if ((paramContext != null) && (paramList != null) && (paramList.size() > 0)) {
      try
      {
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        Object localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          e locale = (e)((Iterator)localObject).next();
          if (!c.a(paramContext).B().equals(locale.N()))
          {
            com.tencent.feedback.common.e.c("updated drop it", new Object[0]);
            localArrayList2.add(locale);
          }
          else
          {
            L localL = a(paramContext, locale);
            if (localL != null) {
              localArrayList1.add(localL);
            } else {
              localArrayList2.add(locale);
            }
          }
        }
        localObject = new M();
        ((M)localObject).a = localArrayList1;
        if (localArrayList2.size() > 0)
        {
          com.tencent.feedback.common.e.c("rqdp{ delete error eup} %d", new Object[] { Integer.valueOf(b.a(paramContext, localArrayList2)) });
          paramList.removeAll(localArrayList2);
        }
        return localObject;
      }
      catch (Throwable paramContext)
      {
        if (!com.tencent.feedback.common.e.a(paramContext)) {
          paramContext.printStackTrace();
        }
        return null;
      }
    }
    com.tencent.feedback.common.e.c("rqdp{  params!}", new Object[0]);
    return null;
  }
  
  private static void a(List<e> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        e locale = (e)paramList.next();
        locale.a(locale.j() + 1);
      }
    }
  }
  
  private static ArrayList<I> b(Context paramContext)
  {
    try
    {
      Object localObject2 = c.a(paramContext).A();
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        com.tencent.feedback.common.e.b("no setted solist from db", new Object[0]);
        localObject1 = l.a(paramContext, null, 1, 50);
      }
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        paramContext = new ArrayList();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (o)((Iterator)localObject1).next();
          I localI = new I();
          localI.b = ((o)localObject2).f();
          localI.a = ((o)localObject2).a();
          localI.c = ((o)localObject2).d();
          paramContext.add(localI);
          com.tencent.feedback.common.e.b("up %s %s %s", new Object[] { localI.b, localI.a, localI.c });
        }
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      if (!com.tencent.feedback.common.e.a(paramContext)) {
        paramContext.printStackTrace();
      }
      com.tencent.feedback.common.e.d("rqdp{  Error: lb pack fail!}", new Object[0]);
    }
    return null;
  }
  
  private List<e> b(Context paramContext, int paramInt)
  {
    com.tencent.feedback.common.e.b("rqdp{  get MN:}%d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramContext != null) && (paramInt > 0)) {}
    label171:
    label174:
    for (;;)
    {
      try
      {
        Object localObject = b.a(paramContext, paramInt, "desc", 1, null, -1, -1, -1, 3, -1L, -1L, null);
        if (localObject != null) {
          break label171;
        }
        localObject = new ArrayList();
        if (((List)localObject).size() >= paramInt) {
          break label174;
        }
        List localList = b.a(paramContext, paramInt - ((List)localObject).size(), "desc", 2, null, -1, -1, -1, 3, -1L, -1L, null);
        if ((localList != null) && (localList.size() > 0)) {
          ((List)localObject).addAll(localList);
        }
        a((List)localObject);
        b.b(paramContext, (List)localObject);
        return localObject;
      }
      catch (Throwable paramContext)
      {
        if (!com.tencent.feedback.common.e.a(paramContext)) {
          paramContext.printStackTrace();
        }
        return null;
      }
      com.tencent.feedback.common.e.c("rqdp{  params!}", new Object[0]);
      return null;
    }
  }
  
  public final N a()
  {
    try
    {
      if (this.e != null)
      {
        localObject1 = this.e;
        return localObject1;
      }
      Object localObject1 = f.l();
      if (localObject1 != null)
      {
        boolean bool = ((f)localObject1).a();
        if (bool) {
          try
          {
            localObject1 = f.l().s();
            this.f = null;
            try
            {
              bool = ((CrashStrategyBean)localObject1).isMerged();
              int i;
              if (com.tencent.feedback.common.g.a(this.c)) {
                i = ((CrashStrategyBean)localObject1).getMaxUploadNum_Wifi();
              } else {
                i = ((CrashStrategyBean)localObject1).getMaxUploadNum_GPRS();
              }
              if (!bool)
              {
                com.tencent.feedback.common.e.b("rqdp{  not merge:}", new Object[0]);
                this.f = b(this.c, i);
              }
              else
              {
                com.tencent.feedback.common.e.b("rqdp{  in merge:}", new Object[0]);
                this.f = a(this.c, i);
              }
              if ((this.f != null) && (this.f.size() > 0))
              {
                com.tencent.feedback.common.e.b("rqdp{  pack n:}%d ,isM:%b", new Object[] { Integer.valueOf(this.f.size()), Boolean.valueOf(bool) });
                localObject1 = a(this.c, this.f);
                if (localObject1 != null)
                {
                  localObject1 = a.a((j)localObject1);
                  if (localObject1 == null)
                  {
                    com.tencent.feedback.common.e.c("rqdp{  empty edatas!}", new Object[0]);
                    return null;
                  }
                  this.e = a(this.c, this.a, (byte[])localObject1);
                  localObject1 = this.e;
                  return localObject1;
                }
              }
              else
              {
                com.tencent.feedback.common.e.c("rqdp{  empty eup!}", new Object[0]);
                return null;
              }
            }
            catch (Throwable localThrowable1)
            {
              if (!com.tencent.feedback.common.e.a(localThrowable1)) {
                localThrowable1.printStackTrace();
              }
              if ((this.f != null) && (this.f.size() > 0))
              {
                com.tencent.feedback.common.e.c("rqdp{ eup error remove} %d", new Object[] { Integer.valueOf(b.a(this.c, this.f)) });
                this.f = null;
              }
              return null;
            }
          }
          catch (Throwable localThrowable2)
          {
            if (!com.tencent.feedback.common.e.a(localThrowable2)) {
              localThrowable2.printStackTrace();
            }
            com.tencent.feedback.common.e.d("rqdp{  imposiable} %s", new Object[] { localThrowable2.toString() });
            return null;
          }
        }
      }
      return null;
    }
    finally {}
  }
  
  protected final List<e> a(Context paramContext, int paramInt)
  {
    com.tencent.feedback.common.e.b("rqdp{  getEupInMe}", new Object[0]);
    if ((paramContext != null) && (paramInt > 0)) {}
    label388:
    for (;;)
    {
      Object localObject1;
      try
      {
        long l = a.c();
        localObject1 = new ArrayList();
        localObject2 = b.a(paramContext, paramInt, "desc", -1, null, -1, -1, -1, 3, l, -1L, Boolean.FALSE);
        if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
          break label378;
        }
        com.tencent.feedback.common.e.b("rqdp{  tdeup ge c=1, n:}%d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
        ((List)localObject1).addAll((Collection)localObject2);
        ((List)localObject2).clear();
        localObject2 = localObject1;
        StringBuilder localStringBuilder;
        if (((List)localObject1).size() < paramInt)
        {
          localObject2 = b.a(paramContext, paramInt, "desc", -1, null, 2, -1, -1, 3, -1L, l, null);
          if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
            break label381;
          }
          localStringBuilder = new StringBuilder("rqdp{  yeseup c>=2,n:}%d");
          localStringBuilder.append(((List)localObject2).size());
          com.tencent.feedback.common.e.b(localStringBuilder.toString(), new Object[0]);
          ((List)localObject1).addAll((Collection)localObject2);
          ((List)localObject2).clear();
          localObject2 = localObject1;
        }
        if (((List)localObject2).size() >= paramInt) {
          break label388;
        }
        localObject1 = b.a(paramContext, paramInt, "desc", -1, null, 0, 1, -1, -1, 3L, l, Boolean.FALSE);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localStringBuilder = new StringBuilder("rqdp{  yeseup c>=2,n:}%d");
          localStringBuilder.append(((List)localObject1).size());
          com.tencent.feedback.common.e.b(localStringBuilder.toString(), new Object[0]);
          ((List)localObject2).addAll((Collection)localObject1);
          ((List)localObject1).clear();
        }
        a((List)localObject2);
        b.b(paramContext, (List)localObject2);
        return localObject2;
      }
      catch (Throwable paramContext)
      {
        if (!com.tencent.feedback.common.e.a(paramContext)) {
          paramContext.printStackTrace();
        }
        return null;
      }
      com.tencent.feedback.common.e.d("rqdp{  params!}", new Object[0]);
      return null;
      label378:
      continue;
      label381:
      Object localObject2 = localObject1;
    }
  }
  
  public final void done(boolean paramBoolean)
  {
    Object localObject1;
    if (paramBoolean) {
      localObject1 = "SUCC";
    }
    for (;;)
    {
      try
      {
        com.tencent.feedback.common.e.b("rqdp{  eupdone :} %s", new Object[] { localObject1 });
        localObject1 = this.f;
        if ((localObject1 != null) && (paramBoolean))
        {
          try
          {
            paramBoolean = f.l().s().isMerged();
          }
          catch (Throwable localThrowable)
          {
            if (com.tencent.feedback.common.e.a(localThrowable)) {
              break label298;
            }
          }
          localThrowable.printStackTrace();
          break label298;
          if (paramBoolean)
          {
            long l = a.c();
            Iterator localIterator = this.f.iterator();
            ArrayList localArrayList = new ArrayList();
            if (localIterator.hasNext())
            {
              e locale = (e)localIterator.next();
              if (locale.i() <= l) {
                continue;
              }
              locale.b(true);
              locale.a(0);
              localArrayList.add(locale);
              localIterator.remove();
              continue;
            }
            paramBoolean = b.b(this.c, localArrayList);
            com.tencent.feedback.common.e.b("rqdp{  merge update today eup n:}%d , res:%b", new Object[] { Integer.valueOf(this.f.size()), Boolean.valueOf(paramBoolean) });
            com.tencent.feedback.common.e.b("rqdp{  me rm num:}%d", new Object[] { Integer.valueOf(b.a(this.c, this.f)) });
          }
          else
          {
            com.tencent.feedback.common.e.b("rqdp{  rm n:}".concat(String.valueOf(b.a(this.c, this.f))), new Object[0]);
          }
        }
        this.e = null;
        this.f = null;
        return;
      }
      finally {}
      String str = "FAIL";
      continue;
      label298:
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.g
 * JD-Core Version:    0.7.0.1
 */