package com.tencent.feedback.eup;

import android.content.Context;
import com.tencent.feedback.common.g;
import com.tencent.feedback.proguard.C;
import com.tencent.feedback.proguard.E;
import com.tencent.feedback.proguard.F;
import com.tencent.feedback.proguard.H;
import com.tencent.feedback.proguard.I;
import com.tencent.feedback.proguard.a;
import com.tencent.feedback.proguard.l;
import com.tencent.feedback.proguard.o;
import com.tencent.feedback.upload.AbstractUploadDatas;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
  extends AbstractUploadDatas
{
  private static f d = null;
  private byte[] e = null;
  private C f = null;
  private List<d> g = null;
  
  private f(Context paramContext)
  {
    super(paramContext, 3, 206);
  }
  
  public static f a(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      if (d == null) {
        d = new f(paramContext);
      }
      paramContext = d;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  private static F a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_0
    //   5: ifnonnull +14 -> 19
    //   8: ldc 40
    //   10: iconst_0
    //   11: anewarray 42	java/lang/Object
    //   14: invokestatic 48	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   17: aconst_null
    //   18: areturn
    //   19: ldc 50
    //   21: iconst_1
    //   22: anewarray 42	java/lang/Object
    //   25: dup
    //   26: iconst_0
    //   27: aload_1
    //   28: aastore
    //   29: invokestatic 52	com/tencent/feedback/common/e:f	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   32: new 54	java/io/File
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;)V
    //   40: astore_1
    //   41: new 54	java/io/File
    //   44: dup
    //   45: aload_0
    //   46: invokevirtual 63	android/content/Context:getCacheDir	()Ljava/io/File;
    //   49: ldc 65
    //   51: invokespecial 68	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   54: astore 4
    //   56: aload_1
    //   57: aload 4
    //   59: sipush 5000
    //   62: invokestatic 73	com/tencent/feedback/proguard/a:a	(Ljava/io/File;Ljava/io/File;I)Z
    //   65: ifne +14 -> 79
    //   68: ldc 75
    //   70: iconst_0
    //   71: anewarray 42	java/lang/Object
    //   74: invokestatic 48	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   77: aconst_null
    //   78: areturn
    //   79: new 77	java/io/ByteArrayOutputStream
    //   82: dup
    //   83: invokespecial 79	java/io/ByteArrayOutputStream:<init>	()V
    //   86: astore_3
    //   87: new 81	java/io/FileInputStream
    //   90: dup
    //   91: aload 4
    //   93: invokespecial 84	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   96: astore_1
    //   97: aload_1
    //   98: astore_0
    //   99: sipush 1000
    //   102: newarray byte
    //   104: astore 5
    //   106: aload_1
    //   107: astore_0
    //   108: aload_1
    //   109: aload 5
    //   111: invokevirtual 88	java/io/FileInputStream:read	([B)I
    //   114: istore_2
    //   115: iload_2
    //   116: ifle +62 -> 178
    //   119: aload_1
    //   120: astore_0
    //   121: aload_3
    //   122: aload 5
    //   124: iconst_0
    //   125: iload_2
    //   126: invokevirtual 92	java/io/ByteArrayOutputStream:write	([BII)V
    //   129: aload_1
    //   130: astore_0
    //   131: aload_3
    //   132: invokevirtual 95	java/io/ByteArrayOutputStream:flush	()V
    //   135: goto -29 -> 106
    //   138: astore_3
    //   139: aload_1
    //   140: astore_0
    //   141: aload_3
    //   142: invokevirtual 98	java/lang/Throwable:printStackTrace	()V
    //   145: aload_1
    //   146: ifnull +7 -> 153
    //   149: aload_1
    //   150: invokevirtual 101	java/io/FileInputStream:close	()V
    //   153: aload 4
    //   155: invokevirtual 105	java/io/File:exists	()Z
    //   158: ifeq -141 -> 17
    //   161: ldc 107
    //   163: iconst_0
    //   164: anewarray 42	java/lang/Object
    //   167: invokestatic 52	com/tencent/feedback/common/e:f	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   170: aload 4
    //   172: invokevirtual 110	java/io/File:delete	()Z
    //   175: pop
    //   176: aconst_null
    //   177: areturn
    //   178: aload_1
    //   179: astore_0
    //   180: aload_3
    //   181: invokevirtual 114	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   184: astore_3
    //   185: aload_1
    //   186: astore_0
    //   187: ldc 116
    //   189: iconst_1
    //   190: anewarray 42	java/lang/Object
    //   193: dup
    //   194: iconst_0
    //   195: aload_3
    //   196: arraylength
    //   197: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   200: aastore
    //   201: invokestatic 52	com/tencent/feedback/common/e:f	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: aload_1
    //   205: astore_0
    //   206: new 124	com/tencent/feedback/proguard/F
    //   209: dup
    //   210: iconst_2
    //   211: aload 4
    //   213: invokevirtual 128	java/io/File:getName	()Ljava/lang/String;
    //   216: aload_3
    //   217: invokespecial 131	com/tencent/feedback/proguard/F:<init>	(BLjava/lang/String;[B)V
    //   220: astore_3
    //   221: aload_1
    //   222: invokevirtual 101	java/io/FileInputStream:close	()V
    //   225: aload 4
    //   227: invokevirtual 105	java/io/File:exists	()Z
    //   230: ifeq +18 -> 248
    //   233: ldc 107
    //   235: iconst_0
    //   236: anewarray 42	java/lang/Object
    //   239: invokestatic 52	com/tencent/feedback/common/e:f	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   242: aload 4
    //   244: invokevirtual 110	java/io/File:delete	()Z
    //   247: pop
    //   248: aload_3
    //   249: areturn
    //   250: astore_0
    //   251: aload_0
    //   252: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   255: goto -30 -> 225
    //   258: astore_0
    //   259: aload_0
    //   260: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   263: goto -110 -> 153
    //   266: astore_1
    //   267: aconst_null
    //   268: astore_0
    //   269: aload_0
    //   270: ifnull +7 -> 277
    //   273: aload_0
    //   274: invokevirtual 101	java/io/FileInputStream:close	()V
    //   277: aload 4
    //   279: invokevirtual 105	java/io/File:exists	()Z
    //   282: ifeq +18 -> 300
    //   285: ldc 107
    //   287: iconst_0
    //   288: anewarray 42	java/lang/Object
    //   291: invokestatic 52	com/tencent/feedback/common/e:f	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   294: aload 4
    //   296: invokevirtual 110	java/io/File:delete	()Z
    //   299: pop
    //   300: aload_1
    //   301: athrow
    //   302: astore_0
    //   303: aload_0
    //   304: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   307: goto -30 -> 277
    //   310: astore_1
    //   311: goto -42 -> 269
    //   314: astore_3
    //   315: aconst_null
    //   316: astore_1
    //   317: goto -178 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	paramContext	Context
    //   0	320	1	paramString	String
    //   114	12	2	i	int
    //   86	46	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   138	43	3	localThrowable1	Throwable
    //   184	65	3	localObject	Object
    //   314	1	3	localThrowable2	Throwable
    //   54	241	4	localFile	java.io.File
    //   104	19	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   99	106	138	java/lang/Throwable
    //   108	115	138	java/lang/Throwable
    //   121	129	138	java/lang/Throwable
    //   131	135	138	java/lang/Throwable
    //   180	185	138	java/lang/Throwable
    //   187	204	138	java/lang/Throwable
    //   206	221	138	java/lang/Throwable
    //   221	225	250	java/io/IOException
    //   149	153	258	java/io/IOException
    //   87	97	266	finally
    //   273	277	302	java/io/IOException
    //   99	106	310	finally
    //   108	115	310	finally
    //   121	129	310	finally
    //   131	135	310	finally
    //   141	145	310	finally
    //   180	185	310	finally
    //   187	204	310	finally
    //   206	221	310	finally
    //   87	97	314	java/lang/Throwable
  }
  
  private static F a(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0) || (paramString == null) || (paramString.trim().length() <= 0)) {
      return null;
    }
    try
    {
      F localF = new F();
      localF.a = 1;
      localF.b = paramString;
      localF.c = paramArrayOfByte;
      return localF;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  private H a(Context paramContext, d paramd)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +14 -> 15
    //   4: ldc 155
    //   6: iconst_0
    //   7: anewarray 42	java/lang/Object
    //   10: invokestatic 48	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   13: aconst_null
    //   14: areturn
    //   15: ldc 157
    //   17: iconst_3
    //   18: anewarray 42	java/lang/Object
    //   21: dup
    //   22: iconst_0
    //   23: aload_2
    //   24: invokevirtual 161	com/tencent/feedback/eup/d:f	()Ljava/lang/String;
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: aload_2
    //   31: invokevirtual 163	com/tencent/feedback/eup/d:c	()Z
    //   34: invokestatic 168	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   37: aastore
    //   38: dup
    //   39: iconst_2
    //   40: aload_2
    //   41: invokevirtual 170	com/tencent/feedback/eup/d:d	()Z
    //   44: invokestatic 168	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   47: aastore
    //   48: invokestatic 52	com/tencent/feedback/common/e:f	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   51: aload_2
    //   52: invokevirtual 170	com/tencent/feedback/eup/d:d	()Z
    //   55: ifeq +1490 -> 1545
    //   58: aload_2
    //   59: invokevirtual 163	com/tencent/feedback/eup/d:c	()Z
    //   62: ifeq +1475 -> 1537
    //   65: ldc 172
    //   67: astore 4
    //   69: new 174	com/tencent/feedback/proguard/H
    //   72: dup
    //   73: invokespecial 175	com/tencent/feedback/proguard/H:<init>	()V
    //   76: astore 5
    //   78: aload 5
    //   80: aload_2
    //   81: invokevirtual 178	com/tencent/feedback/eup/d:A	()Ljava/lang/String;
    //   84: putfield 181	com/tencent/feedback/proguard/H:t	Ljava/lang/String;
    //   87: aload 5
    //   89: aload 4
    //   91: putfield 184	com/tencent/feedback/proguard/H:r	Ljava/lang/String;
    //   94: aload 5
    //   96: aload_2
    //   97: invokevirtual 188	com/tencent/feedback/eup/d:i	()J
    //   100: putfield 191	com/tencent/feedback/proguard/H:d	J
    //   103: aload 5
    //   105: new 193	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   112: aload_2
    //   113: invokevirtual 196	com/tencent/feedback/eup/d:e	()Ljava/lang/String;
    //   116: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: putfield 205	com/tencent/feedback/proguard/H:a	Ljava/lang/String;
    //   125: aload 5
    //   127: new 193	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   134: aload_2
    //   135: invokevirtual 207	com/tencent/feedback/eup/d:g	()Ljava/lang/String;
    //   138: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: putfield 208	com/tencent/feedback/proguard/H:b	Ljava/lang/String;
    //   147: aload 5
    //   149: new 193	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   156: aload_2
    //   157: invokevirtual 211	com/tencent/feedback/eup/d:w	()Ljava/lang/String;
    //   160: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: putfield 213	com/tencent/feedback/proguard/H:f	Ljava/lang/String;
    //   169: aload 5
    //   171: aload_2
    //   172: invokevirtual 215	com/tencent/feedback/eup/d:t	()Ljava/lang/String;
    //   175: putfield 217	com/tencent/feedback/proguard/H:c	Ljava/lang/String;
    //   178: aload 5
    //   180: new 193	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   187: aload_2
    //   188: invokevirtual 196	com/tencent/feedback/eup/d:e	()Ljava/lang/String;
    //   191: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: ldc 219
    //   196: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload_2
    //   200: invokevirtual 161	com/tencent/feedback/eup/d:f	()Ljava/lang/String;
    //   203: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc 221
    //   208: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload_2
    //   212: invokevirtual 224	com/tencent/feedback/eup/d:h	()Ljava/lang/String;
    //   215: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: putfield 226	com/tencent/feedback/proguard/H:g	Ljava/lang/String;
    //   224: aload 5
    //   226: ldc 228
    //   228: putfield 230	com/tencent/feedback/proguard/H:h	Ljava/lang/String;
    //   231: aload 5
    //   233: new 193	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   240: aload_2
    //   241: invokevirtual 233	com/tencent/feedback/eup/d:v	()Ljava/lang/String;
    //   244: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: putfield 236	com/tencent/feedback/proguard/H:p	Ljava/lang/String;
    //   253: aload 5
    //   255: aload_2
    //   256: invokevirtual 238	com/tencent/feedback/eup/d:r	()I
    //   259: i2l
    //   260: putfield 241	com/tencent/feedback/proguard/H:m	J
    //   263: aload_1
    //   264: invokestatic 246	com/tencent/feedback/common/d:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/d;
    //   267: pop
    //   268: aload 5
    //   270: invokestatic 248	com/tencent/feedback/common/d:d	()Ljava/lang/String;
    //   273: putfield 251	com/tencent/feedback/proguard/H:o	Ljava/lang/String;
    //   276: new 253	java/util/ArrayList
    //   279: dup
    //   280: invokespecial 254	java/util/ArrayList:<init>	()V
    //   283: astore 4
    //   285: aload_2
    //   286: invokevirtual 257	com/tencent/feedback/eup/d:s	()[B
    //   289: ldc_w 259
    //   292: invokestatic 261	com/tencent/feedback/eup/f:a	([BLjava/lang/String;)Lcom/tencent/feedback/proguard/F;
    //   295: astore 6
    //   297: aload 6
    //   299: ifnull +21 -> 320
    //   302: ldc_w 263
    //   305: iconst_0
    //   306: anewarray 42	java/lang/Object
    //   309: invokestatic 52	com/tencent/feedback/common/e:f	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   312: aload 4
    //   314: aload 6
    //   316: invokevirtual 267	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   319: pop
    //   320: aload_2
    //   321: invokevirtual 163	com/tencent/feedback/eup/d:c	()Z
    //   324: ifeq +52 -> 376
    //   327: aload_2
    //   328: invokevirtual 238	com/tencent/feedback/eup/d:r	()I
    //   331: iconst_1
    //   332: if_icmple +44 -> 376
    //   335: aload_2
    //   336: invokevirtual 270	com/tencent/feedback/eup/d:q	()Ljava/lang/String;
    //   339: ldc_w 272
    //   342: invokevirtual 276	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   345: ldc_w 278
    //   348: invokestatic 261	com/tencent/feedback/eup/f:a	([BLjava/lang/String;)Lcom/tencent/feedback/proguard/F;
    //   351: astore 6
    //   353: aload 6
    //   355: ifnull +21 -> 376
    //   358: ldc_w 280
    //   361: iconst_0
    //   362: anewarray 42	java/lang/Object
    //   365: invokestatic 52	com/tencent/feedback/common/e:f	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   368: aload 4
    //   370: aload 6
    //   372: invokevirtual 267	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   375: pop
    //   376: aload_2
    //   377: invokevirtual 170	com/tencent/feedback/eup/d:d	()Z
    //   380: ifeq +43 -> 423
    //   383: aload_2
    //   384: invokevirtual 283	com/tencent/feedback/eup/d:u	()Ljava/lang/String;
    //   387: ifnull +36 -> 423
    //   390: aload_1
    //   391: aload_2
    //   392: invokevirtual 283	com/tencent/feedback/eup/d:u	()Ljava/lang/String;
    //   395: invokestatic 285	com/tencent/feedback/eup/f:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/feedback/proguard/F;
    //   398: astore 6
    //   400: aload 6
    //   402: ifnull +21 -> 423
    //   405: ldc_w 287
    //   408: iconst_0
    //   409: anewarray 42	java/lang/Object
    //   412: invokestatic 52	com/tencent/feedback/common/e:f	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   415: aload 4
    //   417: aload 6
    //   419: invokevirtual 267	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   422: pop
    //   423: aload_2
    //   424: invokevirtual 170	com/tencent/feedback/eup/d:d	()Z
    //   427: ifeq +64 -> 491
    //   430: aload_0
    //   431: getfield 25	com/tencent/feedback/eup/f:e	[B
    //   434: ifnonnull +15 -> 449
    //   437: aload_1
    //   438: invokestatic 246	com/tencent/feedback/common/d:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/d;
    //   441: pop
    //   442: aload_0
    //   443: invokestatic 289	com/tencent/feedback/common/d:e	()[B
    //   446: putfield 25	com/tencent/feedback/eup/f:e	[B
    //   449: aload_0
    //   450: getfield 25	com/tencent/feedback/eup/f:e	[B
    //   453: ifnull +38 -> 491
    //   456: aload_0
    //   457: getfield 25	com/tencent/feedback/eup/f:e	[B
    //   460: ldc_w 291
    //   463: invokestatic 261	com/tencent/feedback/eup/f:a	([BLjava/lang/String;)Lcom/tencent/feedback/proguard/F;
    //   466: astore 6
    //   468: aload 6
    //   470: ifnull +21 -> 491
    //   473: ldc_w 293
    //   476: iconst_0
    //   477: anewarray 42	java/lang/Object
    //   480: invokestatic 52	com/tencent/feedback/common/e:f	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   483: aload 4
    //   485: aload 6
    //   487: invokevirtual 267	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   490: pop
    //   491: aload_2
    //   492: invokevirtual 296	com/tencent/feedback/eup/d:x	()Ljava/lang/String;
    //   495: ifnull +44 -> 539
    //   498: aload_2
    //   499: invokevirtual 296	com/tencent/feedback/eup/d:x	()Ljava/lang/String;
    //   502: ldc_w 272
    //   505: invokevirtual 276	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   508: ldc_w 298
    //   511: invokestatic 261	com/tencent/feedback/eup/f:a	([BLjava/lang/String;)Lcom/tencent/feedback/proguard/F;
    //   514: astore 6
    //   516: aload 6
    //   518: ifnull +21 -> 539
    //   521: ldc_w 300
    //   524: iconst_0
    //   525: anewarray 42	java/lang/Object
    //   528: invokestatic 52	com/tencent/feedback/common/e:f	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   531: aload 4
    //   533: aload 6
    //   535: invokevirtual 267	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   538: pop
    //   539: aload_2
    //   540: invokevirtual 303	com/tencent/feedback/eup/d:y	()[B
    //   543: ifnull +38 -> 581
    //   546: aload_2
    //   547: invokevirtual 303	com/tencent/feedback/eup/d:y	()[B
    //   550: ldc_w 305
    //   553: invokestatic 261	com/tencent/feedback/eup/f:a	([BLjava/lang/String;)Lcom/tencent/feedback/proguard/F;
    //   556: astore 6
    //   558: aload 6
    //   560: ifnull +21 -> 581
    //   563: ldc_w 307
    //   566: iconst_0
    //   567: anewarray 42	java/lang/Object
    //   570: invokestatic 52	com/tencent/feedback/common/e:f	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   573: aload 4
    //   575: aload 6
    //   577: invokevirtual 267	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   580: pop
    //   581: aload_2
    //   582: invokevirtual 311	com/tencent/feedback/eup/d:I	()Ljava/util/Map;
    //   585: ifnull +179 -> 764
    //   588: aload_2
    //   589: invokevirtual 311	com/tencent/feedback/eup/d:I	()Ljava/util/Map;
    //   592: invokeinterface 316 1 0
    //   597: ifle +167 -> 764
    //   600: new 193	java/lang/StringBuilder
    //   603: dup
    //   604: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   607: astore 6
    //   609: aload_2
    //   610: invokevirtual 311	com/tencent/feedback/eup/d:I	()Ljava/util/Map;
    //   613: invokeinterface 320 1 0
    //   618: invokeinterface 326 1 0
    //   623: astore 7
    //   625: aload 7
    //   627: invokeinterface 331 1 0
    //   632: ifeq +87 -> 719
    //   635: aload 7
    //   637: invokeinterface 335 1 0
    //   642: checkcast 337	java/util/Map$Entry
    //   645: astore 8
    //   647: aload 6
    //   649: ldc_w 339
    //   652: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: aload 8
    //   657: invokeinterface 342 1 0
    //   662: checkcast 135	java/lang/String
    //   665: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: ldc_w 344
    //   671: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: pop
    //   675: aload 6
    //   677: aload 8
    //   679: invokeinterface 347 1 0
    //   684: checkcast 135	java/lang/String
    //   687: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: pop
    //   691: aload 6
    //   693: ldc 221
    //   695: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: pop
    //   699: goto -74 -> 625
    //   702: astore 7
    //   704: ldc_w 349
    //   707: iconst_0
    //   708: anewarray 42	java/lang/Object
    //   711: invokestatic 351	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   714: aload 7
    //   716: invokevirtual 98	java/lang/Throwable:printStackTrace	()V
    //   719: aload 6
    //   721: invokevirtual 352	java/lang/StringBuilder:length	()I
    //   724: ifle +40 -> 764
    //   727: aload 6
    //   729: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   732: ldc_w 272
    //   735: invokevirtual 276	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   738: ldc_w 354
    //   741: invokestatic 261	com/tencent/feedback/eup/f:a	([BLjava/lang/String;)Lcom/tencent/feedback/proguard/F;
    //   744: astore 6
    //   746: ldc_w 356
    //   749: iconst_0
    //   750: anewarray 42	java/lang/Object
    //   753: invokestatic 52	com/tencent/feedback/common/e:f	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   756: aload 4
    //   758: aload 6
    //   760: invokevirtual 267	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   763: pop
    //   764: aload 4
    //   766: invokevirtual 357	java/util/ArrayList:size	()I
    //   769: ifle +10 -> 779
    //   772: aload 5
    //   774: aload 4
    //   776: putfield 360	com/tencent/feedback/proguard/H:e	Ljava/util/ArrayList;
    //   779: new 362	com/tencent/feedback/proguard/L
    //   782: dup
    //   783: invokespecial 363	com/tencent/feedback/proguard/L:<init>	()V
    //   786: astore 4
    //   788: aload 4
    //   790: aload_2
    //   791: invokevirtual 367	com/tencent/feedback/eup/d:j	()F
    //   794: putfield 370	com/tencent/feedback/proguard/L:a	F
    //   797: aload 4
    //   799: aload_2
    //   800: invokevirtual 373	com/tencent/feedback/eup/d:k	()F
    //   803: putfield 375	com/tencent/feedback/proguard/L:b	F
    //   806: aload 4
    //   808: aload_2
    //   809: invokevirtual 378	com/tencent/feedback/eup/d:l	()J
    //   812: putfield 380	com/tencent/feedback/proguard/L:c	J
    //   815: aload 4
    //   817: aload_2
    //   818: invokevirtual 382	com/tencent/feedback/eup/d:m	()J
    //   821: putfield 383	com/tencent/feedback/proguard/L:d	J
    //   824: aload 4
    //   826: aload_2
    //   827: invokevirtual 386	com/tencent/feedback/eup/d:n	()J
    //   830: putfield 388	com/tencent/feedback/proguard/L:e	J
    //   833: ldc_w 390
    //   836: iconst_3
    //   837: anewarray 42	java/lang/Object
    //   840: dup
    //   841: iconst_0
    //   842: aload 4
    //   844: getfield 380	com/tencent/feedback/proguard/L:c	J
    //   847: invokestatic 395	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   850: aastore
    //   851: dup
    //   852: iconst_1
    //   853: aload 4
    //   855: getfield 383	com/tencent/feedback/proguard/L:d	J
    //   858: invokestatic 395	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   861: aastore
    //   862: dup
    //   863: iconst_2
    //   864: aload 4
    //   866: getfield 388	com/tencent/feedback/proguard/L:e	J
    //   869: invokestatic 395	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   872: aastore
    //   873: invokestatic 397	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   876: aload 5
    //   878: aload 4
    //   880: putfield 400	com/tencent/feedback/proguard/H:j	Lcom/tencent/feedback/proguard/L;
    //   883: invokestatic 405	com/tencent/feedback/common/c:p	()Lcom/tencent/feedback/common/c;
    //   886: astore 6
    //   888: new 407	com/tencent/feedback/proguard/J
    //   891: dup
    //   892: invokespecial 408	com/tencent/feedback/proguard/J:<init>	()V
    //   895: astore 7
    //   897: new 193	java/lang/StringBuilder
    //   900: dup
    //   901: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   904: aload 6
    //   906: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   909: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   912: ifnull +1237 -> 2149
    //   915: aload 6
    //   917: invokevirtual 413	com/tencent/feedback/common/c:l	()Ljava/lang/String;
    //   920: astore 4
    //   922: aload 7
    //   924: aload 4
    //   926: putfield 414	com/tencent/feedback/proguard/J:a	Ljava/lang/String;
    //   929: aload_2
    //   930: invokevirtual 417	com/tencent/feedback/eup/d:D	()Ljava/lang/String;
    //   933: ldc_w 419
    //   936: invokestatic 425	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   939: astore 4
    //   941: new 193	java/lang/StringBuilder
    //   944: dup
    //   945: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   948: astore 8
    //   950: aload 8
    //   952: ldc_w 427
    //   955: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: invokestatic 432	com/tencent/feedback/common/i:a	()Lcom/tencent/feedback/common/i;
    //   961: invokevirtual 434	com/tencent/feedback/common/i:b	()Z
    //   964: invokevirtual 437	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   967: pop
    //   968: aload 8
    //   970: ldc_w 439
    //   973: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: ldc_w 441
    //   979: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   982: aload 4
    //   984: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: pop
    //   988: aload_2
    //   989: invokevirtual 170	com/tencent/feedback/eup/d:d	()Z
    //   992: ifeq +142 -> 1134
    //   995: aload_2
    //   996: invokevirtual 444	com/tencent/feedback/eup/d:E	()Ljava/lang/String;
    //   999: ifnull +35 -> 1034
    //   1002: aload_2
    //   1003: invokevirtual 444	com/tencent/feedback/eup/d:E	()Ljava/lang/String;
    //   1006: invokevirtual 447	java/lang/String:isEmpty	()Z
    //   1009: ifne +25 -> 1034
    //   1012: aload 8
    //   1014: ldc_w 449
    //   1017: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: ldc_w 441
    //   1023: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1026: aload_2
    //   1027: invokevirtual 444	com/tencent/feedback/eup/d:E	()Ljava/lang/String;
    //   1030: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1033: pop
    //   1034: aload_2
    //   1035: invokevirtual 452	com/tencent/feedback/eup/d:G	()Ljava/lang/String;
    //   1038: ifnull +35 -> 1073
    //   1041: aload_2
    //   1042: invokevirtual 452	com/tencent/feedback/eup/d:G	()Ljava/lang/String;
    //   1045: invokevirtual 447	java/lang/String:isEmpty	()Z
    //   1048: ifne +25 -> 1073
    //   1051: aload 8
    //   1053: ldc_w 454
    //   1056: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: ldc_w 441
    //   1062: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: aload_2
    //   1066: invokevirtual 452	com/tencent/feedback/eup/d:G	()Ljava/lang/String;
    //   1069: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1072: pop
    //   1073: aload_2
    //   1074: invokevirtual 456	com/tencent/feedback/eup/d:F	()Ljava/lang/String;
    //   1077: ifnull +35 -> 1112
    //   1080: aload_2
    //   1081: invokevirtual 456	com/tencent/feedback/eup/d:F	()Ljava/lang/String;
    //   1084: invokevirtual 447	java/lang/String:isEmpty	()Z
    //   1087: ifne +25 -> 1112
    //   1090: aload 8
    //   1092: ldc_w 458
    //   1095: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1098: ldc_w 441
    //   1101: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1104: aload_2
    //   1105: invokevirtual 456	com/tencent/feedback/eup/d:F	()Ljava/lang/String;
    //   1108: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1111: pop
    //   1112: aload 8
    //   1114: ldc_w 460
    //   1117: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1120: ldc_w 441
    //   1123: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: aload_2
    //   1127: invokevirtual 463	com/tencent/feedback/eup/d:H	()Ljava/lang/String;
    //   1130: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1133: pop
    //   1134: aload 7
    //   1136: aload 8
    //   1138: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1141: putfield 464	com/tencent/feedback/proguard/J:b	Ljava/lang/String;
    //   1144: aload 5
    //   1146: aload 7
    //   1148: putfield 467	com/tencent/feedback/proguard/H:i	Lcom/tencent/feedback/proguard/J;
    //   1151: aload 8
    //   1153: iconst_0
    //   1154: invokevirtual 471	java/lang/StringBuilder:setLength	(I)V
    //   1157: ldc_w 473
    //   1160: iconst_1
    //   1161: anewarray 42	java/lang/Object
    //   1164: dup
    //   1165: iconst_0
    //   1166: aload 7
    //   1168: getfield 464	com/tencent/feedback/proguard/J:b	Ljava/lang/String;
    //   1171: aastore
    //   1172: invokestatic 397	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1175: new 475	com/tencent/feedback/proguard/G
    //   1178: dup
    //   1179: invokespecial 476	com/tencent/feedback/proguard/G:<init>	()V
    //   1182: astore 4
    //   1184: aload 4
    //   1186: new 193	java/lang/StringBuilder
    //   1189: dup
    //   1190: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   1193: aload_2
    //   1194: invokevirtual 478	com/tencent/feedback/eup/d:p	()Ljava/lang/String;
    //   1197: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1200: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1203: putfield 479	com/tencent/feedback/proguard/G:a	Ljava/lang/String;
    //   1206: aload 4
    //   1208: new 193	java/lang/StringBuilder
    //   1211: dup
    //   1212: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   1215: aload_2
    //   1216: invokevirtual 478	com/tencent/feedback/eup/d:p	()Ljava/lang/String;
    //   1219: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1222: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1225: putfield 480	com/tencent/feedback/proguard/G:b	Ljava/lang/String;
    //   1228: aload 5
    //   1230: aload 4
    //   1232: putfield 483	com/tencent/feedback/proguard/H:k	Lcom/tencent/feedback/proguard/G;
    //   1235: aload_2
    //   1236: invokevirtual 170	com/tencent/feedback/eup/d:d	()Z
    //   1239: ifeq +40 -> 1279
    //   1242: aload_1
    //   1243: invokestatic 486	com/tencent/feedback/eup/f:b	(Landroid/content/Context;)Ljava/util/ArrayList;
    //   1246: astore 4
    //   1248: aload 5
    //   1250: aload 4
    //   1252: putfield 488	com/tencent/feedback/proguard/H:l	Ljava/util/ArrayList;
    //   1255: aload 4
    //   1257: ifnonnull +372 -> 1629
    //   1260: iconst_0
    //   1261: istore_3
    //   1262: ldc_w 490
    //   1265: iconst_1
    //   1266: anewarray 42	java/lang/Object
    //   1269: dup
    //   1270: iconst_0
    //   1271: iload_3
    //   1272: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1275: aastore
    //   1276: invokestatic 52	com/tencent/feedback/common/e:f	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1279: aload 6
    //   1281: ifnull +876 -> 2157
    //   1284: aload 6
    //   1286: invokevirtual 492	com/tencent/feedback/common/c:j	()Ljava/lang/String;
    //   1289: astore 4
    //   1291: aload 5
    //   1293: aload 4
    //   1295: putfield 494	com/tencent/feedback/proguard/H:q	Ljava/lang/String;
    //   1298: aload_2
    //   1299: invokevirtual 497	com/tencent/feedback/eup/d:z	()Ljava/util/Map;
    //   1302: astore 4
    //   1304: aload 4
    //   1306: ifnonnull +332 -> 1638
    //   1309: iconst_0
    //   1310: istore_3
    //   1311: ldc_w 499
    //   1314: iconst_1
    //   1315: anewarray 42	java/lang/Object
    //   1318: dup
    //   1319: iconst_0
    //   1320: iload_3
    //   1321: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1324: aastore
    //   1325: invokestatic 397	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1328: aload 4
    //   1330: ifnull +325 -> 1655
    //   1333: aload 4
    //   1335: invokeinterface 316 1 0
    //   1340: ifle +315 -> 1655
    //   1343: new 253	java/util/ArrayList
    //   1346: dup
    //   1347: invokespecial 254	java/util/ArrayList:<init>	()V
    //   1350: astore_2
    //   1351: aload 4
    //   1353: invokeinterface 320 1 0
    //   1358: invokeinterface 326 1 0
    //   1363: astore 4
    //   1365: aload 4
    //   1367: invokeinterface 331 1 0
    //   1372: ifeq +277 -> 1649
    //   1375: aload 4
    //   1377: invokeinterface 335 1 0
    //   1382: checkcast 337	java/util/Map$Entry
    //   1385: astore 6
    //   1387: new 501	com/tencent/feedback/proguard/K
    //   1390: dup
    //   1391: invokespecial 502	com/tencent/feedback/proguard/K:<init>	()V
    //   1394: astore 7
    //   1396: aload 7
    //   1398: aload 6
    //   1400: invokeinterface 342 1 0
    //   1405: checkcast 135	java/lang/String
    //   1408: putfield 503	com/tencent/feedback/proguard/K:a	Ljava/lang/String;
    //   1411: aload 7
    //   1413: aload 6
    //   1415: invokeinterface 347 1 0
    //   1420: checkcast 505	com/tencent/feedback/common/PlugInInfo
    //   1423: getfield 508	com/tencent/feedback/common/PlugInInfo:plugInVersion	Ljava/lang/String;
    //   1426: putfield 509	com/tencent/feedback/proguard/K:b	Ljava/lang/String;
    //   1429: aload 7
    //   1431: aload 6
    //   1433: invokeinterface 347 1 0
    //   1438: checkcast 505	com/tencent/feedback/common/PlugInInfo
    //   1441: getfield 512	com/tencent/feedback/common/PlugInInfo:plugInUUID	Ljava/lang/String;
    //   1444: putfield 513	com/tencent/feedback/proguard/K:c	Ljava/lang/String;
    //   1447: ldc_w 515
    //   1450: iconst_3
    //   1451: anewarray 42	java/lang/Object
    //   1454: dup
    //   1455: iconst_0
    //   1456: new 193	java/lang/StringBuilder
    //   1459: dup
    //   1460: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   1463: aload 7
    //   1465: getfield 503	com/tencent/feedback/proguard/K:a	Ljava/lang/String;
    //   1468: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1471: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1474: aastore
    //   1475: dup
    //   1476: iconst_1
    //   1477: new 193	java/lang/StringBuilder
    //   1480: dup
    //   1481: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   1484: aload 7
    //   1486: getfield 509	com/tencent/feedback/proguard/K:b	Ljava/lang/String;
    //   1489: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1492: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1495: aastore
    //   1496: dup
    //   1497: iconst_2
    //   1498: new 193	java/lang/StringBuilder
    //   1501: dup
    //   1502: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   1505: aload 7
    //   1507: getfield 513	com/tencent/feedback/proguard/K:c	Ljava/lang/String;
    //   1510: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1513: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1516: aastore
    //   1517: invokestatic 397	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1520: aload_2
    //   1521: aload 7
    //   1523: invokevirtual 267	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1526: pop
    //   1527: goto -162 -> 1365
    //   1530: astore_1
    //   1531: aload_1
    //   1532: invokevirtual 98	java/lang/Throwable:printStackTrace	()V
    //   1535: aconst_null
    //   1536: areturn
    //   1537: ldc_w 517
    //   1540: astore 4
    //   1542: goto -1473 -> 69
    //   1545: aload_2
    //   1546: invokevirtual 518	com/tencent/feedback/eup/d:b	()Z
    //   1549: ifeq +18 -> 1567
    //   1552: aload_2
    //   1553: invokevirtual 163	com/tencent/feedback/eup/d:c	()Z
    //   1556: ifeq +569 -> 2125
    //   1559: ldc_w 520
    //   1562: astore 4
    //   1564: goto -1495 -> 69
    //   1567: aload_2
    //   1568: invokevirtual 523	com/tencent/feedback/eup/d:C	()Z
    //   1571: ifeq +18 -> 1589
    //   1574: aload_2
    //   1575: invokevirtual 163	com/tencent/feedback/eup/d:c	()Z
    //   1578: ifeq +555 -> 2133
    //   1581: ldc_w 525
    //   1584: astore 4
    //   1586: goto -1517 -> 69
    //   1589: aload_2
    //   1590: invokevirtual 163	com/tencent/feedback/eup/d:c	()Z
    //   1593: ifeq +548 -> 2141
    //   1596: ldc_w 527
    //   1599: astore 4
    //   1601: goto -1532 -> 69
    //   1604: astore 6
    //   1606: aload 6
    //   1608: invokevirtual 98	java/lang/Throwable:printStackTrace	()V
    //   1611: goto -847 -> 764
    //   1614: astore 4
    //   1616: aload 4
    //   1618: invokevirtual 98	java/lang/Throwable:printStackTrace	()V
    //   1621: ldc_w 529
    //   1624: astore 4
    //   1626: goto -685 -> 941
    //   1629: aload 4
    //   1631: invokevirtual 357	java/util/ArrayList:size	()I
    //   1634: istore_3
    //   1635: goto -373 -> 1262
    //   1638: aload 4
    //   1640: invokeinterface 316 1 0
    //   1645: istore_3
    //   1646: goto -335 -> 1311
    //   1649: aload 5
    //   1651: aload_2
    //   1652: putfield 531	com/tencent/feedback/proguard/H:s	Ljava/util/ArrayList;
    //   1655: invokestatic 405	com/tencent/feedback/common/c:p	()Lcom/tencent/feedback/common/c;
    //   1658: astore 4
    //   1660: aload 4
    //   1662: ifnonnull +36 -> 1698
    //   1665: ldc_w 533
    //   1668: iconst_0
    //   1669: anewarray 42	java/lang/Object
    //   1672: invokestatic 48	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1675: aconst_null
    //   1676: astore_1
    //   1677: aload_1
    //   1678: ifnull +487 -> 2165
    //   1681: aload 5
    //   1683: aload_1
    //   1684: putfield 535	com/tencent/feedback/proguard/H:n	Ljava/lang/String;
    //   1687: aload_1
    //   1688: iconst_0
    //   1689: anewarray 42	java/lang/Object
    //   1692: invokestatic 397	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1695: goto +470 -> 2165
    //   1698: aload_1
    //   1699: invokestatic 246	com/tencent/feedback/common/d:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/d;
    //   1702: pop
    //   1703: new 537	java/lang/StringBuffer
    //   1706: dup
    //   1707: invokespecial 538	java/lang/StringBuffer:<init>	()V
    //   1710: astore_2
    //   1711: aload_2
    //   1712: invokestatic 540	com/tencent/feedback/common/d:b	()Ljava/lang/String;
    //   1715: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1718: ldc_w 545
    //   1721: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1724: pop
    //   1725: aload_2
    //   1726: invokestatic 547	com/tencent/feedback/common/d:c	()Ljava/lang/String;
    //   1729: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1732: ldc_w 545
    //   1735: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1738: pop
    //   1739: aload_2
    //   1740: ldc 228
    //   1742: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1745: ldc_w 545
    //   1748: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1751: pop
    //   1752: aload_2
    //   1753: ldc 228
    //   1755: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1758: ldc_w 545
    //   1761: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1764: pop
    //   1765: aload_2
    //   1766: aload 4
    //   1768: invokevirtual 548	com/tencent/feedback/common/c:h	()Ljava/lang/String;
    //   1771: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1774: ldc_w 545
    //   1777: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1780: pop
    //   1781: aload_2
    //   1782: aload_1
    //   1783: invokestatic 551	com/tencent/feedback/common/d:c	(Landroid/content/Context;)Ljava/lang/String;
    //   1786: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1789: ldc_w 545
    //   1792: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1795: pop
    //   1796: aload_2
    //   1797: ldc 228
    //   1799: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1802: ldc_w 545
    //   1805: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1808: pop
    //   1809: aload_2
    //   1810: aload_1
    //   1811: invokestatic 553	com/tencent/feedback/common/d:f	(Landroid/content/Context;)Ljava/lang/String;
    //   1814: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1817: ldc_w 545
    //   1820: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1823: pop
    //   1824: aload_2
    //   1825: aload_1
    //   1826: invokestatic 558	com/tencent/feedback/common/h:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/h;
    //   1829: invokevirtual 560	com/tencent/feedback/common/h:a	()Ljava/lang/String;
    //   1832: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1835: ldc_w 545
    //   1838: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1841: pop
    //   1842: aload_2
    //   1843: aload_1
    //   1844: invokestatic 562	com/tencent/feedback/common/d:d	(Landroid/content/Context;)Ljava/lang/String;
    //   1847: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1850: ldc_w 545
    //   1853: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1856: pop
    //   1857: aload_2
    //   1858: ldc 228
    //   1860: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1863: ldc_w 545
    //   1866: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1869: pop
    //   1870: aload_2
    //   1871: invokestatic 564	com/tencent/feedback/common/d:m	()Ljava/lang/String;
    //   1874: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1877: ldc_w 545
    //   1880: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1883: pop
    //   1884: aload_2
    //   1885: invokestatic 565	com/tencent/feedback/common/d:a	()Ljava/lang/String;
    //   1888: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1891: ldc_w 545
    //   1894: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1897: pop
    //   1898: aload_2
    //   1899: ldc 228
    //   1901: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1904: ldc_w 545
    //   1907: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1910: pop
    //   1911: aload_2
    //   1912: ldc 228
    //   1914: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1917: ldc_w 545
    //   1920: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1923: pop
    //   1924: aload_2
    //   1925: ldc 228
    //   1927: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1930: ldc_w 545
    //   1933: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1936: pop
    //   1937: aload_2
    //   1938: ldc 228
    //   1940: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1943: ldc_w 545
    //   1946: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1949: pop
    //   1950: aload_2
    //   1951: invokestatic 566	com/tencent/feedback/common/d:g	()Ljava/lang/String;
    //   1954: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1957: ldc_w 545
    //   1960: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1963: pop
    //   1964: aload_2
    //   1965: invokestatic 567	com/tencent/feedback/common/d:h	()Ljava/lang/String;
    //   1968: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1971: ldc_w 545
    //   1974: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1977: pop
    //   1978: aload_2
    //   1979: invokestatic 568	com/tencent/feedback/common/d:f	()Ljava/lang/String;
    //   1982: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1985: ldc_w 545
    //   1988: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1991: pop
    //   1992: aload_2
    //   1993: ldc 228
    //   1995: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1998: ldc_w 545
    //   2001: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2004: pop
    //   2005: aload_2
    //   2006: invokestatic 566	com/tencent/feedback/common/d:g	()Ljava/lang/String;
    //   2009: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2012: ldc_w 545
    //   2015: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2018: pop
    //   2019: aload_2
    //   2020: aload_1
    //   2021: invokestatic 571	com/tencent/feedback/common/d:g	(Landroid/content/Context;)Landroid/util/DisplayMetrics;
    //   2024: invokevirtual 574	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   2027: ldc_w 545
    //   2030: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2033: pop
    //   2034: aload_2
    //   2035: aload_1
    //   2036: invokestatic 577	com/tencent/feedback/common/g:c	(Landroid/content/Context;)Ljava/lang/String;
    //   2039: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2042: ldc_w 545
    //   2045: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2048: pop
    //   2049: aload_1
    //   2050: invokestatic 246	com/tencent/feedback/common/d:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/d;
    //   2053: pop
    //   2054: aload_2
    //   2055: aload_1
    //   2056: invokestatic 579	com/tencent/feedback/common/d:i	(Landroid/content/Context;)Ljava/lang/String;
    //   2059: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2062: ldc_w 545
    //   2065: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2068: pop
    //   2069: aload_2
    //   2070: ldc 228
    //   2072: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2075: ldc_w 545
    //   2078: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2081: pop
    //   2082: aload_2
    //   2083: invokestatic 581	com/tencent/feedback/common/d:k	()Ljava/lang/String;
    //   2086: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2089: ldc_w 545
    //   2092: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2095: pop
    //   2096: aload_2
    //   2097: invokestatic 582	com/tencent/feedback/common/d:l	()Ljava/lang/String;
    //   2100: invokevirtual 543	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2103: pop
    //   2104: aload_2
    //   2105: invokevirtual 583	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   2108: astore_1
    //   2109: aload_2
    //   2110: iconst_0
    //   2111: invokevirtual 584	java/lang/StringBuffer:setLength	(I)V
    //   2114: goto -437 -> 1677
    //   2117: astore_1
    //   2118: aload_1
    //   2119: invokevirtual 98	java/lang/Throwable:printStackTrace	()V
    //   2122: goto +43 -> 2165
    //   2125: ldc_w 586
    //   2128: astore 4
    //   2130: goto -2061 -> 69
    //   2133: ldc_w 588
    //   2136: astore 4
    //   2138: goto -2069 -> 69
    //   2141: ldc_w 590
    //   2144: astore 4
    //   2146: goto -2077 -> 69
    //   2149: ldc_w 592
    //   2152: astore 4
    //   2154: goto -1232 -> 922
    //   2157: ldc_w 592
    //   2160: astore 4
    //   2162: goto -871 -> 1291
    //   2165: aload 5
    //   2167: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2168	0	this	f
    //   0	2168	1	paramContext	Context
    //   0	2168	2	paramd	d
    //   1261	385	3	i	int
    //   67	1533	4	localObject1	Object
    //   1614	3	4	localThrowable1	Throwable
    //   1624	537	4	localObject2	Object
    //   76	2090	5	localH	H
    //   295	1137	6	localObject3	Object
    //   1604	3	6	localThrowable2	Throwable
    //   623	13	7	localIterator	Iterator
    //   702	13	7	localThrowable3	Throwable
    //   895	627	7	localObject4	Object
    //   645	507	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   609	625	702	java/lang/Throwable
    //   625	699	702	java/lang/Throwable
    //   51	65	1530	java/lang/Throwable
    //   69	285	1530	java/lang/Throwable
    //   764	779	1530	java/lang/Throwable
    //   779	922	1530	java/lang/Throwable
    //   922	929	1530	java/lang/Throwable
    //   941	1034	1530	java/lang/Throwable
    //   1034	1073	1530	java/lang/Throwable
    //   1073	1112	1530	java/lang/Throwable
    //   1112	1134	1530	java/lang/Throwable
    //   1134	1255	1530	java/lang/Throwable
    //   1262	1279	1530	java/lang/Throwable
    //   1284	1291	1530	java/lang/Throwable
    //   1291	1304	1530	java/lang/Throwable
    //   1311	1328	1530	java/lang/Throwable
    //   1333	1365	1530	java/lang/Throwable
    //   1365	1527	1530	java/lang/Throwable
    //   1545	1559	1530	java/lang/Throwable
    //   1567	1581	1530	java/lang/Throwable
    //   1589	1596	1530	java/lang/Throwable
    //   1606	1611	1530	java/lang/Throwable
    //   1616	1621	1530	java/lang/Throwable
    //   1629	1635	1530	java/lang/Throwable
    //   1638	1646	1530	java/lang/Throwable
    //   1649	1655	1530	java/lang/Throwable
    //   2118	2122	1530	java/lang/Throwable
    //   285	297	1604	java/lang/Throwable
    //   302	320	1604	java/lang/Throwable
    //   320	353	1604	java/lang/Throwable
    //   358	376	1604	java/lang/Throwable
    //   376	400	1604	java/lang/Throwable
    //   405	423	1604	java/lang/Throwable
    //   423	449	1604	java/lang/Throwable
    //   449	468	1604	java/lang/Throwable
    //   473	491	1604	java/lang/Throwable
    //   491	516	1604	java/lang/Throwable
    //   521	539	1604	java/lang/Throwable
    //   539	558	1604	java/lang/Throwable
    //   563	581	1604	java/lang/Throwable
    //   581	609	1604	java/lang/Throwable
    //   704	719	1604	java/lang/Throwable
    //   719	764	1604	java/lang/Throwable
    //   929	941	1614	java/lang/Throwable
    //   1655	1660	2117	java/lang/Throwable
    //   1665	1675	2117	java/lang/Throwable
    //   1681	1695	2117	java/lang/Throwable
    //   1698	2114	2117	java/lang/Throwable
  }
  
  private I a(Context paramContext, List<d> paramList, String paramString)
  {
    if ((paramContext == null) || (paramList == null) || (paramList.size() <= 0))
    {
      com.tencent.feedback.common.e.c("rqdp{  params!}", new Object[0]);
      paramString = null;
    }
    ArrayList localArrayList;
    Object localObject;
    do
    {
      return paramString;
      for (;;)
      {
        try
        {
          paramString = new ArrayList();
          localArrayList = new ArrayList();
          localObject = paramList.iterator();
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          d locald = (d)((Iterator)localObject).next();
          H localH = a(paramContext, locald);
          if (localH != null) {
            paramString.add(localH);
          } else {
            localArrayList.add(locald);
          }
        }
        catch (Throwable paramContext)
        {
          paramContext.printStackTrace();
          return null;
        }
      }
      localObject = new I();
      ((I)localObject).a = paramString;
      paramString = (String)localObject;
    } while (localArrayList.size() <= 0);
    com.tencent.feedback.common.e.c("rqdp{ delete error eup} %d", new Object[] { Integer.valueOf(c.a(paramContext, localArrayList)) });
    paramList.removeAll(localArrayList);
    return localObject;
  }
  
  private static void a(List<d> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        d locald = (d)paramList.next();
        locald.a(locald.o() + 1);
      }
    }
  }
  
  private static ArrayList<E> b(Context paramContext)
  {
    try
    {
      Object localObject = l.a(paramContext, null, 1, 50);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramContext = new ArrayList();
        localObject = ((List)localObject).iterator();
      }
      while (((Iterator)localObject).hasNext())
      {
        o localo = (o)((Iterator)localObject).next();
        E localE = new E();
        localE.b = localo.f();
        localE.a = localo.a();
        localE.c = localo.d();
        paramContext.add(localE);
        continue;
        return null;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      com.tencent.feedback.common.e.d("rqdp{  Error: lb pack fail!}", new Object[0]);
    }
    return paramContext;
  }
  
  private List<d> b(Context paramContext, int paramInt)
  {
    com.tencent.feedback.common.e.e("rqdp{  get MN:}%d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramContext == null) || (paramInt <= 0))
    {
      com.tencent.feedback.common.e.c("rqdp{  params!}", new Object[0]);
      return null;
    }
    try
    {
      List localList = c.a(paramContext, paramInt, "desc", 1, null, -1, -1, -1, 3, -1L, -1L, null);
      Object localObject = localList;
      if (localList == null) {
        localObject = new ArrayList();
      }
      if (((List)localObject).size() < paramInt)
      {
        localList = c.a(paramContext, paramInt - ((List)localObject).size(), "desc", 2, null, -1, -1, -1, 3, -1L, -1L, null);
        if ((localList != null) && (localList.size() > 0)) {
          ((List)localObject).addAll(localList);
        }
      }
      a((List)localObject);
      c.b(paramContext, (List)localObject);
      return localObject;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public final C a()
  {
    Object localObject5 = null;
    for (;;)
    {
      boolean bool;
      try
      {
        if (this.f != null)
        {
          localObject1 = this.f;
          return localObject1;
        }
        localObject6 = e.k();
        localObject1 = localObject5;
        if (localObject6 == null) {
          continue;
        }
        bool = ((e)localObject6).a();
        localObject1 = localObject5;
        if (!bool) {
          continue;
        }
      }
      finally
      {
        try
        {
          Object localObject1 = e.k().q();
          this.g = null;
          try
          {
            bool = ((CrashStrategyBean)localObject1).isMerged();
            if (!g.a(this.c)) {
              break label242;
            }
            i = ((CrashStrategyBean)localObject1).getMaxUploadNum_Wifi();
            if (bool) {
              break label250;
            }
            com.tencent.feedback.common.e.f("rqdp{  not merge:}", new Object[0]);
            this.g = b(this.c, i);
            if ((this.g != null) && (this.g.size() > 0)) {
              break label276;
            }
            com.tencent.feedback.common.e.c("rqdp{  empty eup!}", new Object[0]);
            localObject1 = localObject5;
          }
          catch (Throwable localThrowable1)
          {
            localThrowable1.printStackTrace();
            localObject2 = localObject5;
          }
          if (this.g == null) {
            continue;
          }
          Object localObject2 = localObject5;
          if (this.g.size() <= 0) {
            continue;
          }
          com.tencent.feedback.common.e.c("rqdp{ eup error remove} %d", new Object[] { Integer.valueOf(c.a(this.c, this.g)) });
          this.g = null;
          localObject2 = localObject5;
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2.printStackTrace();
          com.tencent.feedback.common.e.d("rqdp{  imposiable} %s", new Object[] { localThrowable2.toString() });
          localObject4 = localObject5;
        }
        localObject3 = finally;
      }
      continue;
      label242:
      int i = ((CrashStrategyBean)localObject4).getMaxUploadNum_GPRS();
      continue;
      label250:
      com.tencent.feedback.common.e.f("rqdp{  in merge:}", new Object[0]);
      this.g = a(this.c, i);
      continue;
      label276:
      com.tencent.feedback.common.e.f("rqdp{  pack n:}%d ,isM:%b", new Object[] { Integer.valueOf(this.g.size()), Boolean.valueOf(bool) });
      Object localObject6 = a(this.c, this.g, null);
      Object localObject4 = localObject5;
      if (localObject6 != null)
      {
        localObject4 = ((I)localObject6).a();
        if (localObject4 == null)
        {
          com.tencent.feedback.common.e.c("rqdp{  empty edatas!}", new Object[0]);
          localObject4 = localObject5;
        }
        else
        {
          this.f = a(this.c, this.a, (byte[])localObject4);
          localObject4 = this.f;
        }
      }
    }
  }
  
  protected final List<d> a(Context paramContext, int paramInt)
  {
    com.tencent.feedback.common.e.e("rqdp{  getEupInMe}", new Object[0]);
    if ((paramContext == null) || (paramInt <= 0))
    {
      com.tencent.feedback.common.e.d("rqdp{  params!}", new Object[0]);
      return null;
    }
    try
    {
      long l = a.b();
      ArrayList localArrayList = new ArrayList();
      List localList = c.a(paramContext, paramInt, "desc", -1, null, -1, -1, -1, 3, l, -1L, Boolean.valueOf(false));
      if ((localList != null) && (localList.size() > 0))
      {
        com.tencent.feedback.common.e.b("rqdp{  tdeup ge c=1, n:}%d", new Object[] { Integer.valueOf(localList.size()) });
        localArrayList.addAll(localList);
        localList.clear();
      }
      if (localArrayList.size() < paramInt)
      {
        localList = c.a(paramContext, paramInt, "desc", -1, null, 2, -1, -1, 3, -1L, l, null);
        if ((localList != null) && (localList.size() > 0))
        {
          com.tencent.feedback.common.e.b("rqdp{  yeseup c>=2,n:}%d" + localList.size(), new Object[0]);
          localArrayList.addAll(localList);
          localList.clear();
        }
      }
      if (localArrayList.size() < paramInt)
      {
        localList = c.a(paramContext, paramInt, "desc", -1, null, 0, 1, -1, -1, 3L, l, Boolean.valueOf(false));
        if ((localList != null) && (localList.size() > 0))
        {
          com.tencent.feedback.common.e.b("rqdp{  yeseup c>=2,n:}%d" + localList.size(), new Object[0]);
          localArrayList.addAll(localList);
          localList.clear();
        }
      }
      a(localArrayList);
      c.b(paramContext, localArrayList);
      return localArrayList;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public final void done(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: ifeq +147 -> 150
    //   6: ldc_w 740
    //   9: astore 5
    //   11: ldc_w 742
    //   14: iconst_1
    //   15: anewarray 42	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: aload 5
    //   22: aastore
    //   23: invokestatic 647	com/tencent/feedback/common/e:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: aload_0
    //   27: getfield 29	com/tencent/feedback/eup/f:g	Ljava/util/List;
    //   30: astore 5
    //   32: aload 5
    //   34: ifnull +205 -> 239
    //   37: iload_1
    //   38: ifeq +201 -> 239
    //   41: invokestatic 669	com/tencent/feedback/eup/e:k	()Lcom/tencent/feedback/eup/e;
    //   44: invokevirtual 674	com/tencent/feedback/eup/e:q	()Lcom/tencent/feedback/eup/CrashStrategyBean;
    //   47: invokevirtual 679	com/tencent/feedback/eup/CrashStrategyBean:isMerged	()Z
    //   50: istore_1
    //   51: iload_1
    //   52: ifeq +200 -> 252
    //   55: invokestatic 723	com/tencent/feedback/proguard/a:b	()J
    //   58: lstore_3
    //   59: aload_0
    //   60: getfield 29	com/tencent/feedback/eup/f:g	Ljava/util/List;
    //   63: invokeinterface 597 1 0
    //   68: astore 5
    //   70: new 253	java/util/ArrayList
    //   73: dup
    //   74: invokespecial 254	java/util/ArrayList:<init>	()V
    //   77: astore 6
    //   79: aload 5
    //   81: invokeinterface 331 1 0
    //   86: ifeq +84 -> 170
    //   89: aload 5
    //   91: invokeinterface 335 1 0
    //   96: checkcast 159	com/tencent/feedback/eup/d
    //   99: astore 7
    //   101: aload 7
    //   103: invokevirtual 188	com/tencent/feedback/eup/d:i	()J
    //   106: lload_3
    //   107: lcmp
    //   108: ifle -29 -> 79
    //   111: aload 7
    //   113: iconst_1
    //   114: invokevirtual 744	com/tencent/feedback/eup/d:d	(Z)V
    //   117: aload 7
    //   119: iconst_0
    //   120: invokevirtual 622	com/tencent/feedback/eup/d:a	(I)V
    //   123: aload 6
    //   125: aload 7
    //   127: invokeinterface 745 2 0
    //   132: pop
    //   133: aload 5
    //   135: invokeinterface 748 1 0
    //   140: goto -61 -> 79
    //   143: astore 5
    //   145: aload_0
    //   146: monitorexit
    //   147: aload 5
    //   149: athrow
    //   150: ldc_w 750
    //   153: astore 5
    //   155: goto -144 -> 11
    //   158: astore 5
    //   160: aload 5
    //   162: invokevirtual 98	java/lang/Throwable:printStackTrace	()V
    //   165: iconst_0
    //   166: istore_1
    //   167: goto -116 -> 51
    //   170: aload_0
    //   171: getfield 682	com/tencent/feedback/eup/f:c	Landroid/content/Context;
    //   174: aload 6
    //   176: invokestatic 662	com/tencent/feedback/eup/c:b	(Landroid/content/Context;Ljava/util/List;)Z
    //   179: istore_1
    //   180: ldc_w 752
    //   183: iconst_2
    //   184: anewarray 42	java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: aload_0
    //   190: getfield 29	com/tencent/feedback/eup/f:g	Ljava/util/List;
    //   193: invokeinterface 596 1 0
    //   198: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   201: aastore
    //   202: dup
    //   203: iconst_1
    //   204: iload_1
    //   205: invokestatic 168	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   208: aastore
    //   209: invokestatic 397	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: ldc_w 754
    //   215: iconst_1
    //   216: anewarray 42	java/lang/Object
    //   219: dup
    //   220: iconst_0
    //   221: aload_0
    //   222: getfield 682	com/tencent/feedback/eup/f:c	Landroid/content/Context;
    //   225: aload_0
    //   226: getfield 29	com/tencent/feedback/eup/f:g	Ljava/util/List;
    //   229: invokestatic 611	com/tencent/feedback/eup/c:a	(Landroid/content/Context;Ljava/util/List;)I
    //   232: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   235: aastore
    //   236: invokestatic 397	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   239: aload_0
    //   240: aconst_null
    //   241: putfield 27	com/tencent/feedback/eup/f:f	Lcom/tencent/feedback/proguard/C;
    //   244: aload_0
    //   245: aconst_null
    //   246: putfield 29	com/tencent/feedback/eup/f:g	Ljava/util/List;
    //   249: aload_0
    //   250: monitorexit
    //   251: return
    //   252: aload_0
    //   253: getfield 682	com/tencent/feedback/eup/f:c	Landroid/content/Context;
    //   256: aload_0
    //   257: getfield 29	com/tencent/feedback/eup/f:g	Ljava/util/List;
    //   260: invokestatic 611	com/tencent/feedback/eup/c:a	(Landroid/content/Context;Ljava/util/List;)I
    //   263: istore_2
    //   264: new 193	java/lang/StringBuilder
    //   267: dup
    //   268: ldc_w 756
    //   271: invokespecial 731	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   274: iload_2
    //   275: invokevirtual 734	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   278: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: iconst_0
    //   282: anewarray 42	java/lang/Object
    //   285: invokestatic 397	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   288: goto -49 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	this	f
    //   0	291	1	paramBoolean	boolean
    //   263	12	2	i	int
    //   58	49	3	l	long
    //   9	125	5	localObject1	Object
    //   143	5	5	localObject2	Object
    //   153	1	5	str	String
    //   158	3	5	localThrowable	Throwable
    //   77	98	6	localArrayList	ArrayList
    //   99	27	7	locald	d
    // Exception table:
    //   from	to	target	type
    //   11	32	143	finally
    //   41	51	143	finally
    //   55	79	143	finally
    //   79	140	143	finally
    //   160	165	143	finally
    //   170	239	143	finally
    //   239	249	143	finally
    //   252	288	143	finally
    //   41	51	158	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.f
 * JD-Core Version:    0.7.0.1
 */