package com.tencent.feedback.proguard;

import android.content.Context;
import com.tencent.feedback.common.e;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class a
{
  protected HashMap<String, HashMap<String, byte[]>> a = new HashMap();
  protected String b;
  h c;
  private HashMap<String, Object> d;
  
  a()
  {
    new HashMap();
    this.d = new HashMap();
    this.b = "GBK";
    this.c = new h();
  }
  
  public static int a(Context paramContext, p[] paramArrayOfp)
  {
    int j = 0;
    int i;
    if ((paramContext == null) || (paramArrayOfp == null) || (paramArrayOfp.length <= 0)) {
      i = -1;
    }
    ArrayList localArrayList;
    do
    {
      return i;
      localArrayList = new ArrayList(paramArrayOfp.length);
      int k = paramArrayOfp.length;
      i = 0;
      while (i < k)
      {
        p localp = paramArrayOfp[i];
        Object localObject = a(localp);
        if (localObject != null)
        {
          localObject = new l(7, 0, 0L, (byte[])localObject);
          ((l)localObject).a(localp.a());
          localArrayList.add(localObject);
        }
        i += 1;
      }
      i = j;
    } while (localArrayList.size() <= 0);
    if (l.b(paramContext, localArrayList)) {
      return localArrayList.size();
    }
    return -1;
  }
  
  public static int a(Context paramContext, q[] paramArrayOfq)
  {
    if ((paramContext != null) && (paramArrayOfq != null)) {}
    for (;;)
    {
      int i;
      ArrayList localArrayList;
      try
      {
        if (paramArrayOfq.length <= 0)
        {
          e.c("rqdp{  args error}", new Object[0]);
          i = 0;
          return i;
        }
        localArrayList = new ArrayList(paramArrayOfq.length);
        int j = paramArrayOfq.length;
        i = 0;
        if (i < j)
        {
          q localq = paramArrayOfq[i];
          Object localObject = a(localq);
          if (localObject == null)
          {
            e.c("rqdp{ getSerData error }", new Object[0]);
          }
          else
          {
            localObject = new l(9, 0, localq.a(), (byte[])localObject);
            ((l)localObject).a(localq.c());
            localArrayList.add(localObject);
          }
        }
      }
      finally {}
      if ((localArrayList.size() > 0) && (l.a(paramContext, localArrayList)))
      {
        i = localArrayList.size();
      }
      else
      {
        i = 0;
        continue;
        i += 1;
      }
    }
  }
  
  /* Error */
  public static C a(int paramInt1, com.tencent.feedback.common.c paramc, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc 95
    //   2: iconst_0
    //   3: anewarray 4	java/lang/Object
    //   6: invokestatic 97	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   9: aload_1
    //   10: ifnonnull +14 -> 24
    //   13: ldc 99
    //   15: iconst_0
    //   16: anewarray 4	java/lang/Object
    //   19: invokestatic 101	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: aconst_null
    //   23: areturn
    //   24: new 103	com/tencent/feedback/proguard/C
    //   27: dup
    //   28: invokespecial 104	com/tencent/feedback/proguard/C:<init>	()V
    //   31: astore 5
    //   33: aload_1
    //   34: monitorenter
    //   35: aload 5
    //   37: aload_1
    //   38: invokevirtual 108	com/tencent/feedback/common/c:a	()Ljava/lang/String;
    //   41: putfield 111	com/tencent/feedback/proguard/C:h	Ljava/lang/String;
    //   44: aload 5
    //   46: aload_1
    //   47: invokevirtual 114	com/tencent/feedback/common/c:b	()B
    //   50: putfield 117	com/tencent/feedback/proguard/C:a	B
    //   53: aload 5
    //   55: aload_1
    //   56: invokevirtual 120	com/tencent/feedback/common/c:m	()Ljava/lang/String;
    //   59: putfield 121	com/tencent/feedback/proguard/C:b	Ljava/lang/String;
    //   62: aload 5
    //   64: aload_1
    //   65: invokevirtual 123	com/tencent/feedback/common/c:d	()Ljava/lang/String;
    //   68: putfield 125	com/tencent/feedback/proguard/C:c	Ljava/lang/String;
    //   71: aload 5
    //   73: aload_1
    //   74: invokevirtual 128	com/tencent/feedback/common/c:e	()Ljava/lang/String;
    //   77: putfield 130	com/tencent/feedback/proguard/C:d	Ljava/lang/String;
    //   80: aload 5
    //   82: aload_1
    //   83: invokevirtual 133	com/tencent/feedback/common/c:f	()Ljava/lang/String;
    //   86: putfield 135	com/tencent/feedback/proguard/C:e	Ljava/lang/String;
    //   89: aload 5
    //   91: aload_1
    //   92: invokevirtual 138	com/tencent/feedback/common/c:g	()Ljava/lang/String;
    //   95: putfield 141	com/tencent/feedback/proguard/C:i	Ljava/lang/String;
    //   98: aload 5
    //   100: aload_1
    //   101: invokevirtual 144	com/tencent/feedback/common/c:j	()Ljava/lang/String;
    //   104: putfield 147	com/tencent/feedback/proguard/C:l	Ljava/lang/String;
    //   107: aload 5
    //   109: aload_1
    //   110: invokevirtual 150	com/tencent/feedback/common/c:k	()Ljava/lang/String;
    //   113: putfield 152	com/tencent/feedback/proguard/C:m	Ljava/lang/String;
    //   116: aload 5
    //   118: aload_1
    //   119: invokevirtual 153	com/tencent/feedback/common/c:c	()Ljava/lang/String;
    //   122: putfield 156	com/tencent/feedback/proguard/C:n	Ljava/lang/String;
    //   125: aload 5
    //   127: new 158	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   134: aload_1
    //   135: invokevirtual 163	com/tencent/feedback/common/c:o	()Landroid/content/Context;
    //   138: invokestatic 168	com/tencent/feedback/common/h:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/h;
    //   141: invokevirtual 169	com/tencent/feedback/common/h:a	()Ljava/lang/String;
    //   144: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: putfield 178	com/tencent/feedback/proguard/C:o	Ljava/lang/String;
    //   153: ldc 180
    //   155: iconst_1
    //   156: anewarray 4	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: aload 5
    //   163: getfield 178	com/tencent/feedback/proguard/C:o	Ljava/lang/String;
    //   166: aastore
    //   167: invokestatic 97	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   170: aload_1
    //   171: monitorexit
    //   172: aload 5
    //   174: iload_0
    //   175: putfield 183	com/tencent/feedback/proguard/C:f	I
    //   178: aload 5
    //   180: iload 4
    //   182: i2b
    //   183: putfield 185	com/tencent/feedback/proguard/C:j	B
    //   186: aload 5
    //   188: iload_3
    //   189: i2b
    //   190: putfield 187	com/tencent/feedback/proguard/C:k	B
    //   193: aload_2
    //   194: astore_1
    //   195: aload_2
    //   196: ifnonnull +9 -> 205
    //   199: ldc 189
    //   201: invokevirtual 195	java/lang/String:getBytes	()[B
    //   204: astore_1
    //   205: aload 5
    //   207: aload_1
    //   208: putfield 198	com/tencent/feedback/proguard/C:g	[B
    //   211: aload 5
    //   213: areturn
    //   214: astore 6
    //   216: aload 6
    //   218: invokevirtual 201	java/lang/Exception:printStackTrace	()V
    //   221: goto -51 -> 170
    //   224: astore_2
    //   225: aload_1
    //   226: monitorexit
    //   227: aload_2
    //   228: athrow
    //   229: astore_1
    //   230: aload_1
    //   231: invokevirtual 202	java/lang/Throwable:printStackTrace	()V
    //   234: aconst_null
    //   235: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	paramInt1	int
    //   0	236	1	paramc	com.tencent.feedback.common.c
    //   0	236	2	paramArrayOfByte	byte[]
    //   0	236	3	paramInt2	int
    //   0	236	4	paramInt3	int
    //   31	181	5	localC	C
    //   214	3	6	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   125	170	214	java/lang/Exception
    //   35	125	224	finally
    //   125	170	224	finally
    //   170	172	224	finally
    //   216	221	224	finally
    //   24	35	229	java/lang/Throwable
    //   172	193	229	java/lang/Throwable
    //   199	205	229	java/lang/Throwable
    //   205	211	229	java/lang/Throwable
    //   225	229	229	java/lang/Throwable
  }
  
  /* Error */
  public static z a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnonnull +14 -> 18
    //   7: ldc 205
    //   9: iconst_0
    //   10: anewarray 4	java/lang/Object
    //   13: invokestatic 75	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   16: aconst_null
    //   17: areturn
    //   18: new 207	com/tencent/feedback/proguard/n
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 210	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   26: astore_3
    //   27: aload_3
    //   28: invokevirtual 214	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   31: astore_0
    //   32: aload_0
    //   33: ifnonnull +33 -> 66
    //   36: ldc 216
    //   38: iconst_0
    //   39: anewarray 4	java/lang/Object
    //   42: invokestatic 75	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   45: aload_0
    //   46: ifnull +14 -> 60
    //   49: aload_0
    //   50: invokevirtual 222	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   53: ifeq +7 -> 60
    //   56: aload_0
    //   57: invokevirtual 225	android/database/sqlite/SQLiteDatabase:close	()V
    //   60: aload_3
    //   61: invokevirtual 226	com/tencent/feedback/proguard/n:close	()V
    //   64: aconst_null
    //   65: areturn
    //   66: aload_0
    //   67: ldc 228
    //   69: aconst_null
    //   70: getstatic 234	java/util/Locale:US	Ljava/util/Locale;
    //   73: ldc 236
    //   75: iconst_2
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: ldc 238
    //   83: aastore
    //   84: dup
    //   85: iconst_1
    //   86: iload_1
    //   87: invokestatic 244	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   90: aastore
    //   91: invokestatic 248	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   94: aconst_null
    //   95: aconst_null
    //   96: aconst_null
    //   97: aconst_null
    //   98: invokevirtual 252	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   101: astore_2
    //   102: aload_2
    //   103: ifnull +282 -> 385
    //   106: aload_2
    //   107: invokeinterface 257 1 0
    //   112: ifeq +273 -> 385
    //   115: aload_2
    //   116: ifnull +434 -> 550
    //   119: aload_2
    //   120: invokeinterface 260 1 0
    //   125: ifne +425 -> 550
    //   128: aload_2
    //   129: invokeinterface 263 1 0
    //   134: ifeq +73 -> 207
    //   137: goto +413 -> 550
    //   140: aload 4
    //   142: ifnull +243 -> 385
    //   145: ldc_w 265
    //   148: iconst_1
    //   149: anewarray 4	java/lang/Object
    //   152: dup
    //   153: iconst_0
    //   154: aload 4
    //   156: invokevirtual 269	com/tencent/feedback/proguard/z:b	()I
    //   159: invokestatic 244	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   162: aastore
    //   163: invokestatic 271	com/tencent/feedback/common/e:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: aload_2
    //   167: ifnull +18 -> 185
    //   170: aload_2
    //   171: invokeinterface 274 1 0
    //   176: ifne +9 -> 185
    //   179: aload_2
    //   180: invokeinterface 275 1 0
    //   185: aload_0
    //   186: ifnull +14 -> 200
    //   189: aload_0
    //   190: invokevirtual 222	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   193: ifeq +7 -> 200
    //   196: aload_0
    //   197: invokevirtual 225	android/database/sqlite/SQLiteDatabase:close	()V
    //   200: aload_3
    //   201: invokevirtual 226	com/tencent/feedback/proguard/n:close	()V
    //   204: aload 4
    //   206: areturn
    //   207: ldc_w 277
    //   210: iconst_0
    //   211: anewarray 4	java/lang/Object
    //   214: invokestatic 97	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   217: new 267	com/tencent/feedback/proguard/z
    //   220: dup
    //   221: invokespecial 278	com/tencent/feedback/proguard/z:<init>	()V
    //   224: astore 4
    //   226: aload 4
    //   228: aload_2
    //   229: aload_2
    //   230: ldc_w 280
    //   233: invokeinterface 284 2 0
    //   238: invokeinterface 288 2 0
    //   243: invokevirtual 291	com/tencent/feedback/proguard/z:a	(J)V
    //   246: aload 4
    //   248: aload_2
    //   249: aload_2
    //   250: ldc 238
    //   252: invokeinterface 284 2 0
    //   257: invokeinterface 295 2 0
    //   262: invokevirtual 297	com/tencent/feedback/proguard/z:a	(I)V
    //   265: aload 4
    //   267: aload_2
    //   268: aload_2
    //   269: ldc_w 299
    //   272: invokeinterface 284 2 0
    //   277: invokeinterface 288 2 0
    //   282: invokevirtual 301	com/tencent/feedback/proguard/z:b	(J)V
    //   285: aload 4
    //   287: aload_2
    //   288: aload_2
    //   289: ldc_w 303
    //   292: invokeinterface 284 2 0
    //   297: invokeinterface 307 2 0
    //   302: invokevirtual 310	com/tencent/feedback/proguard/z:a	([B)V
    //   305: goto -165 -> 140
    //   308: astore 4
    //   310: aload_2
    //   311: astore 5
    //   313: aload_0
    //   314: astore_2
    //   315: aload 5
    //   317: astore_0
    //   318: aload 4
    //   320: invokevirtual 202	java/lang/Throwable:printStackTrace	()V
    //   323: ldc_w 312
    //   326: iconst_1
    //   327: anewarray 4	java/lang/Object
    //   330: dup
    //   331: iconst_0
    //   332: aload 4
    //   334: invokevirtual 313	java/lang/Throwable:toString	()Ljava/lang/String;
    //   337: aastore
    //   338: invokestatic 101	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   341: aload_0
    //   342: ifnull +18 -> 360
    //   345: aload_0
    //   346: invokeinterface 274 1 0
    //   351: ifne +9 -> 360
    //   354: aload_0
    //   355: invokeinterface 275 1 0
    //   360: aload_2
    //   361: ifnull +14 -> 375
    //   364: aload_2
    //   365: invokevirtual 222	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   368: ifeq +7 -> 375
    //   371: aload_2
    //   372: invokevirtual 225	android/database/sqlite/SQLiteDatabase:close	()V
    //   375: aload_3
    //   376: ifnull +7 -> 383
    //   379: aload_3
    //   380: invokevirtual 226	com/tencent/feedback/proguard/n:close	()V
    //   383: aconst_null
    //   384: areturn
    //   385: aload_2
    //   386: ifnull +18 -> 404
    //   389: aload_2
    //   390: invokeinterface 274 1 0
    //   395: ifne +9 -> 404
    //   398: aload_2
    //   399: invokeinterface 275 1 0
    //   404: aload_0
    //   405: ifnull +14 -> 419
    //   408: aload_0
    //   409: invokevirtual 222	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   412: ifeq +7 -> 419
    //   415: aload_0
    //   416: invokevirtual 225	android/database/sqlite/SQLiteDatabase:close	()V
    //   419: aload_3
    //   420: invokevirtual 226	com/tencent/feedback/proguard/n:close	()V
    //   423: goto -40 -> 383
    //   426: astore_0
    //   427: aconst_null
    //   428: astore_2
    //   429: aconst_null
    //   430: astore_3
    //   431: aload_2
    //   432: ifnull +18 -> 450
    //   435: aload_2
    //   436: invokeinterface 274 1 0
    //   441: ifne +9 -> 450
    //   444: aload_2
    //   445: invokeinterface 275 1 0
    //   450: aload 4
    //   452: ifnull +16 -> 468
    //   455: aload 4
    //   457: invokevirtual 222	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   460: ifeq +8 -> 468
    //   463: aload 4
    //   465: invokevirtual 225	android/database/sqlite/SQLiteDatabase:close	()V
    //   468: aload_3
    //   469: ifnull +7 -> 476
    //   472: aload_3
    //   473: invokevirtual 226	com/tencent/feedback/proguard/n:close	()V
    //   476: aload_0
    //   477: athrow
    //   478: astore_0
    //   479: aconst_null
    //   480: astore_2
    //   481: goto -50 -> 431
    //   484: astore 5
    //   486: aconst_null
    //   487: astore_2
    //   488: aload_0
    //   489: astore 4
    //   491: aload 5
    //   493: astore_0
    //   494: goto -63 -> 431
    //   497: astore 5
    //   499: aload_0
    //   500: astore 4
    //   502: aload 5
    //   504: astore_0
    //   505: goto -74 -> 431
    //   508: astore 5
    //   510: aload_2
    //   511: astore 4
    //   513: aload_0
    //   514: astore_2
    //   515: aload 5
    //   517: astore_0
    //   518: goto -87 -> 431
    //   521: astore 4
    //   523: aconst_null
    //   524: astore_0
    //   525: aconst_null
    //   526: astore_2
    //   527: aconst_null
    //   528: astore_3
    //   529: goto -211 -> 318
    //   532: astore 4
    //   534: aconst_null
    //   535: astore_0
    //   536: aconst_null
    //   537: astore_2
    //   538: goto -220 -> 318
    //   541: astore 4
    //   543: aload_0
    //   544: astore_2
    //   545: aconst_null
    //   546: astore_0
    //   547: goto -229 -> 318
    //   550: aconst_null
    //   551: astore 4
    //   553: goto -413 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	556	0	paramContext	Context
    //   0	556	1	paramInt	int
    //   101	444	2	localObject1	Object
    //   26	503	3	localn	n
    //   1	285	4	localz	z
    //   308	156	4	localThrowable1	Throwable
    //   489	23	4	localObject2	Object
    //   521	1	4	localThrowable2	Throwable
    //   532	1	4	localThrowable3	Throwable
    //   541	1	4	localThrowable4	Throwable
    //   551	1	4	localObject3	Object
    //   311	5	5	localObject4	Object
    //   484	8	5	localObject5	Object
    //   497	6	5	localObject6	Object
    //   508	8	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   106	115	308	java/lang/Throwable
    //   119	137	308	java/lang/Throwable
    //   145	166	308	java/lang/Throwable
    //   207	305	308	java/lang/Throwable
    //   18	27	426	finally
    //   27	32	478	finally
    //   36	45	484	finally
    //   66	102	484	finally
    //   106	115	497	finally
    //   119	137	497	finally
    //   145	166	497	finally
    //   207	305	497	finally
    //   318	341	508	finally
    //   18	27	521	java/lang/Throwable
    //   27	32	532	java/lang/Throwable
    //   36	45	541	java/lang/Throwable
    //   66	102	541	java/lang/Throwable
  }
  
  public static String a(String paramString)
  {
    int i = 0;
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    try
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      paramString = ((MessageDigest)localObject).digest();
      if (paramString == null) {
        return "";
      }
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
      e.d(paramString.getMessage(), new Object[0]);
      return null;
    }
    Object localObject = new StringBuffer();
    while (i < paramString.length)
    {
      String str = Integer.toHexString(paramString[i] & 0xFF);
      if (str.length() == 1) {
        ((StringBuffer)localObject).append("0");
      }
      ((StringBuffer)localObject).append(str);
      i += 1;
    }
    return ((StringBuffer)localObject).toString().toUpperCase();
  }
  
  public static String a(ArrayList<String> paramArrayList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    String str1;
    if (i < paramArrayList.size())
    {
      String str2 = (String)paramArrayList.get(i);
      if ((str2.equals("java.lang.Integer")) || (str2.equals("int"))) {
        str1 = "int32";
      }
      for (;;)
      {
        paramArrayList.set(i, str1);
        i += 1;
        break;
        if ((str2.equals("java.lang.Boolean")) || (str2.equals("boolean")))
        {
          str1 = "bool";
        }
        else if ((str2.equals("java.lang.Byte")) || (str2.equals("byte")))
        {
          str1 = "char";
        }
        else if ((str2.equals("java.lang.Double")) || (str2.equals("double")))
        {
          str1 = "double";
        }
        else if ((str2.equals("java.lang.Float")) || (str2.equals("float")))
        {
          str1 = "float";
        }
        else if ((str2.equals("java.lang.Long")) || (str2.equals("long")))
        {
          str1 = "int64";
        }
        else if ((str2.equals("java.lang.Short")) || (str2.equals("short")))
        {
          str1 = "short";
        }
        else
        {
          if (str2.equals("java.lang.Character")) {
            throw new IllegalArgumentException("can not support java.lang.Character");
          }
          if (str2.equals("java.lang.String"))
          {
            str1 = "string";
          }
          else if (str2.equals("java.util.List"))
          {
            str1 = "list";
          }
          else
          {
            str1 = str2;
            if (str2.equals("java.util.Map")) {
              str1 = "map";
            }
          }
        }
      }
    }
    Collections.reverse(paramArrayList);
    i = 0;
    if (i < paramArrayList.size())
    {
      str1 = (String)paramArrayList.get(i);
      if (str1.equals("list"))
      {
        paramArrayList.set(i - 1, "<" + (String)paramArrayList.get(i - 1));
        paramArrayList.set(0, (String)paramArrayList.get(0) + ">");
      }
      for (;;)
      {
        i += 1;
        break;
        if (str1.equals("map"))
        {
          paramArrayList.set(i - 1, "<" + (String)paramArrayList.get(i - 1) + ",");
          paramArrayList.set(0, (String)paramArrayList.get(0) + ">");
        }
        else if (str1.equals("Array"))
        {
          paramArrayList.set(i - 1, "<" + (String)paramArrayList.get(i - 1));
          paramArrayList.set(0, (String)paramArrayList.get(0) + ">");
        }
      }
    }
    Collections.reverse(paramArrayList);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localStringBuffer.append((String)paramArrayList.next());
    }
    return localStringBuffer.toString();
  }
  
  public static String a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    int j = paramArrayOfByte.length;
    StringBuffer localStringBuffer = new StringBuffer(j << 1);
    Formatter localFormatter = new Formatter(localStringBuffer);
    int i = 0;
    while (i < j)
    {
      localFormatter.format("%02x", new Object[] { Byte.valueOf(paramArrayOfByte[i]) });
      i += 1;
    }
    localFormatter.close();
    return localStringBuffer.toString().toLowerCase();
  }
  
  /* Error */
  public static ArrayList<String> a(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 37	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 477	java/util/ArrayList:<init>	()V
    //   9: astore 4
    //   11: invokestatic 483	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   14: aload_0
    //   15: invokevirtual 487	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   18: astore_0
    //   19: new 489	java/io/BufferedReader
    //   22: dup
    //   23: new 491	java/io/InputStreamReader
    //   26: dup
    //   27: aload_0
    //   28: invokevirtual 497	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   31: invokespecial 500	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   34: invokespecial 503	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   37: astore_1
    //   38: aload_1
    //   39: invokevirtual 506	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore_2
    //   43: aload_2
    //   44: ifnull +44 -> 88
    //   47: aload 4
    //   49: aload_2
    //   50: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   53: pop
    //   54: goto -16 -> 38
    //   57: astore 4
    //   59: aconst_null
    //   60: astore_0
    //   61: aload_0
    //   62: astore_3
    //   63: aload_1
    //   64: astore_2
    //   65: aload 4
    //   67: invokevirtual 202	java/lang/Throwable:printStackTrace	()V
    //   70: aload_1
    //   71: ifnull +7 -> 78
    //   74: aload_1
    //   75: invokevirtual 507	java/io/BufferedReader:close	()V
    //   78: aload_0
    //   79: ifnull +7 -> 86
    //   82: aload_0
    //   83: invokevirtual 507	java/io/BufferedReader:close	()V
    //   86: aconst_null
    //   87: areturn
    //   88: new 489	java/io/BufferedReader
    //   91: dup
    //   92: new 491	java/io/InputStreamReader
    //   95: dup
    //   96: aload_0
    //   97: invokevirtual 510	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   100: invokespecial 500	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   103: invokespecial 503	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   106: astore_0
    //   107: aload_0
    //   108: astore_3
    //   109: aload_1
    //   110: astore_2
    //   111: aload_0
    //   112: invokevirtual 506	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   115: astore 5
    //   117: aload 5
    //   119: ifnull +23 -> 142
    //   122: aload_0
    //   123: astore_3
    //   124: aload_1
    //   125: astore_2
    //   126: aload 4
    //   128: aload 5
    //   130: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   133: pop
    //   134: goto -27 -> 107
    //   137: astore 4
    //   139: goto -78 -> 61
    //   142: aload_1
    //   143: invokevirtual 507	java/io/BufferedReader:close	()V
    //   146: aload_0
    //   147: invokevirtual 507	java/io/BufferedReader:close	()V
    //   150: aload 4
    //   152: areturn
    //   153: astore_0
    //   154: aload_0
    //   155: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   158: aload 4
    //   160: areturn
    //   161: astore_1
    //   162: aload_1
    //   163: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   166: goto -20 -> 146
    //   169: astore_1
    //   170: aload_1
    //   171: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   174: goto -96 -> 78
    //   177: astore_0
    //   178: aload_0
    //   179: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   182: goto -96 -> 86
    //   185: astore_0
    //   186: aconst_null
    //   187: astore_1
    //   188: aload_1
    //   189: ifnull +7 -> 196
    //   192: aload_1
    //   193: invokevirtual 507	java/io/BufferedReader:close	()V
    //   196: aload_3
    //   197: ifnull +7 -> 204
    //   200: aload_3
    //   201: invokevirtual 507	java/io/BufferedReader:close	()V
    //   204: aload_0
    //   205: athrow
    //   206: astore_1
    //   207: aload_1
    //   208: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   211: goto -15 -> 196
    //   214: astore_1
    //   215: aload_1
    //   216: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   219: goto -15 -> 204
    //   222: astore_0
    //   223: goto -35 -> 188
    //   226: astore_0
    //   227: aload_2
    //   228: astore_1
    //   229: goto -41 -> 188
    //   232: astore 4
    //   234: aconst_null
    //   235: astore_0
    //   236: aconst_null
    //   237: astore_1
    //   238: goto -177 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	paramArrayOfString	String[]
    //   37	106	1	localBufferedReader	java.io.BufferedReader
    //   161	2	1	localIOException1	java.io.IOException
    //   169	2	1	localIOException2	java.io.IOException
    //   187	6	1	localObject1	Object
    //   206	2	1	localIOException3	java.io.IOException
    //   214	2	1	localIOException4	java.io.IOException
    //   228	10	1	localObject2	Object
    //   42	186	2	localObject3	Object
    //   1	200	3	arrayOfString	String[]
    //   9	39	4	localArrayList	ArrayList
    //   57	70	4	localThrowable1	Throwable
    //   137	22	4	localThrowable2	Throwable
    //   232	1	4	localThrowable3	Throwable
    //   115	14	5	str	String
    // Exception table:
    //   from	to	target	type
    //   38	43	57	java/lang/Throwable
    //   47	54	57	java/lang/Throwable
    //   88	107	57	java/lang/Throwable
    //   111	117	137	java/lang/Throwable
    //   126	134	137	java/lang/Throwable
    //   146	150	153	java/io/IOException
    //   142	146	161	java/io/IOException
    //   74	78	169	java/io/IOException
    //   82	86	177	java/io/IOException
    //   11	38	185	finally
    //   192	196	206	java/io/IOException
    //   200	204	214	java/io/IOException
    //   38	43	222	finally
    //   47	54	222	finally
    //   88	107	222	finally
    //   65	70	226	finally
    //   111	117	226	finally
    //   126	134	226	finally
    //   11	38	232	java/lang/Throwable
  }
  
  public static List<p> a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    Object localObject = l.a(paramContext, new int[] { 7 }, -1, -1, 9223372036854775807L, 5, null, -1, -1, -1, -1, -1L, 9223372036854775807L);
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      return null;
    }
    paramContext = new ArrayList(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      l locall = (l)((Iterator)localObject).next();
      try
      {
        p localp = (p)p.class.cast(b(locall.b()));
        localp.a(locall.a());
        paramContext.add(localp);
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        e.d("rqdp{  netconsume error }%s", new Object[] { localThrowable.toString() });
      }
    }
    return paramContext;
  }
  
  public static void a(Context paramContext, int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    z localz = new z();
    localz.a(paramInt);
    localz.a(paramArrayOfByte);
    localz.b(new Date().getTime());
    a(paramContext, localz);
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 554
    //   3: iconst_1
    //   4: anewarray 4	java/lang/Object
    //   7: dup
    //   8: iconst_0
    //   9: aload_0
    //   10: aastore
    //   11: invokestatic 97	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   14: aload_1
    //   15: ifnull +13 -> 28
    //   18: aload_1
    //   19: invokevirtual 557	java/lang/String:trim	()Ljava/lang/String;
    //   22: invokevirtual 319	java/lang/String:length	()I
    //   25: ifgt +4 -> 29
    //   28: return
    //   29: new 559	java/io/File
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 560	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore 6
    //   39: aload 6
    //   41: invokevirtual 563	java/io/File:exists	()Z
    //   44: ifne +26 -> 70
    //   47: aload 6
    //   49: invokevirtual 567	java/io/File:getParentFile	()Ljava/io/File;
    //   52: ifnull +12 -> 64
    //   55: aload 6
    //   57: invokevirtual 567	java/io/File:getParentFile	()Ljava/io/File;
    //   60: invokevirtual 570	java/io/File:mkdirs	()Z
    //   63: pop
    //   64: aload 6
    //   66: invokevirtual 573	java/io/File:createNewFile	()Z
    //   69: pop
    //   70: aconst_null
    //   71: astore 5
    //   73: aconst_null
    //   74: astore_0
    //   75: aload_0
    //   76: astore 4
    //   78: aload 5
    //   80: astore_3
    //   81: aload 6
    //   83: invokevirtual 575	java/io/File:length	()J
    //   86: iload_2
    //   87: i2l
    //   88: lcmp
    //   89: iflt +60 -> 149
    //   92: aload_0
    //   93: astore 4
    //   95: aload 5
    //   97: astore_3
    //   98: new 577	java/io/FileOutputStream
    //   101: dup
    //   102: aload 6
    //   104: iconst_0
    //   105: invokespecial 580	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   108: astore_0
    //   109: aload_0
    //   110: astore 4
    //   112: aload_0
    //   113: astore_3
    //   114: aload_0
    //   115: aload_1
    //   116: ldc_w 582
    //   119: invokevirtual 585	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   122: invokevirtual 588	java/io/FileOutputStream:write	([B)V
    //   125: aload_0
    //   126: astore 4
    //   128: aload_0
    //   129: astore_3
    //   130: aload_0
    //   131: invokevirtual 591	java/io/FileOutputStream:flush	()V
    //   134: aload_0
    //   135: invokevirtual 592	java/io/FileOutputStream:close	()V
    //   138: ldc_w 594
    //   141: iconst_0
    //   142: anewarray 4	java/lang/Object
    //   145: invokestatic 97	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   148: return
    //   149: aload_0
    //   150: astore 4
    //   152: aload 5
    //   154: astore_3
    //   155: new 577	java/io/FileOutputStream
    //   158: dup
    //   159: aload 6
    //   161: iconst_1
    //   162: invokespecial 580	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   165: astore_0
    //   166: goto -57 -> 109
    //   169: astore_0
    //   170: aload 4
    //   172: astore_3
    //   173: aload_0
    //   174: invokevirtual 202	java/lang/Throwable:printStackTrace	()V
    //   177: aload 4
    //   179: astore_3
    //   180: ldc_w 596
    //   183: iconst_0
    //   184: anewarray 4	java/lang/Object
    //   187: invokestatic 101	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   190: aload 4
    //   192: ifnull -54 -> 138
    //   195: aload 4
    //   197: invokevirtual 592	java/io/FileOutputStream:close	()V
    //   200: goto -62 -> 138
    //   203: astore_0
    //   204: aload_0
    //   205: invokevirtual 202	java/lang/Throwable:printStackTrace	()V
    //   208: goto -70 -> 138
    //   211: astore_0
    //   212: aload_3
    //   213: ifnull +7 -> 220
    //   216: aload_3
    //   217: invokevirtual 592	java/io/FileOutputStream:close	()V
    //   220: aload_0
    //   221: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	paramString1	String
    //   0	222	1	paramString2	String
    //   0	222	2	paramInt	int
    //   80	137	3	localObject1	Object
    //   76	120	4	str	String
    //   71	82	5	localObject2	Object
    //   37	123	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   81	92	169	java/lang/Throwable
    //   98	109	169	java/lang/Throwable
    //   114	125	169	java/lang/Throwable
    //   130	134	169	java/lang/Throwable
    //   155	166	169	java/lang/Throwable
    //   39	64	203	java/lang/Throwable
    //   64	70	203	java/lang/Throwable
    //   134	138	203	java/lang/Throwable
    //   195	200	203	java/lang/Throwable
    //   216	220	203	java/lang/Throwable
    //   220	222	203	java/lang/Throwable
    //   81	92	211	finally
    //   98	109	211	finally
    //   114	125	211	finally
    //   130	134	211	finally
    //   155	166	211	finally
    //   173	177	211	finally
    //   180	190	211	finally
  }
  
  private void a(ArrayList<String> paramArrayList, Object paramObject)
  {
    if (paramObject.getClass().isArray())
    {
      if (!paramObject.getClass().getComponentType().toString().equals("byte")) {
        throw new IllegalArgumentException("only byte[] is supported");
      }
      if (Array.getLength(paramObject) > 0)
      {
        paramArrayList.add("java.util.List");
        a(paramArrayList, Array.get(paramObject, 0));
        return;
      }
      paramArrayList.add("Array");
      paramArrayList.add("?");
      return;
    }
    if ((paramObject instanceof Array)) {
      throw new IllegalArgumentException("can not support Array, please use List");
    }
    if ((paramObject instanceof List))
    {
      paramArrayList.add("java.util.List");
      paramObject = (List)paramObject;
      if (paramObject.size() > 0)
      {
        a(paramArrayList, paramObject.get(0));
        return;
      }
      paramArrayList.add("?");
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramArrayList.add("java.util.Map");
      Object localObject = (Map)paramObject;
      if (((Map)localObject).size() > 0)
      {
        paramObject = ((Map)localObject).keySet().iterator().next();
        localObject = ((Map)localObject).get(paramObject);
        paramArrayList.add(paramObject.getClass().getName());
        a(paramArrayList, localObject);
        return;
      }
      paramArrayList.add("?");
      paramArrayList.add("?");
      return;
    }
    paramArrayList.add(paramObject.getClass().getName());
  }
  
  /* Error */
  public static boolean a(Context paramContext, z paramz)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: ifnull +7 -> 14
    //   10: aload_1
    //   11: ifnonnull +15 -> 26
    //   14: ldc_w 644
    //   17: iconst_0
    //   18: anewarray 4	java/lang/Object
    //   21: invokestatic 75	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: iconst_0
    //   25: ireturn
    //   26: new 207	com/tencent/feedback/proguard/n
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 210	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   34: astore 4
    //   36: aload 4
    //   38: invokevirtual 214	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   41: astore_0
    //   42: aload_0
    //   43: ifnonnull +35 -> 78
    //   46: ldc_w 646
    //   49: iconst_0
    //   50: anewarray 4	java/lang/Object
    //   53: invokestatic 101	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   56: aload_0
    //   57: ifnull +14 -> 71
    //   60: aload_0
    //   61: invokevirtual 222	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   64: ifeq +7 -> 71
    //   67: aload_0
    //   68: invokevirtual 225	android/database/sqlite/SQLiteDatabase:close	()V
    //   71: aload 4
    //   73: invokevirtual 226	com/tencent/feedback/proguard/n:close	()V
    //   76: iconst_0
    //   77: ireturn
    //   78: aload_1
    //   79: ifnonnull +62 -> 141
    //   82: aload 6
    //   84: astore 5
    //   86: aload 5
    //   88: ifnull +234 -> 322
    //   91: aload_0
    //   92: ldc 228
    //   94: ldc_w 280
    //   97: aload 5
    //   99: invokevirtual 650	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   102: lstore_2
    //   103: lload_2
    //   104: lconst_0
    //   105: lcmp
    //   106: ifge +169 -> 275
    //   109: ldc_w 652
    //   112: iconst_0
    //   113: anewarray 4	java/lang/Object
    //   116: invokestatic 75	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   119: aload_0
    //   120: ifnull +14 -> 134
    //   123: aload_0
    //   124: invokevirtual 222	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   127: ifeq +7 -> 134
    //   130: aload_0
    //   131: invokevirtual 225	android/database/sqlite/SQLiteDatabase:close	()V
    //   134: aload 4
    //   136: invokevirtual 226	com/tencent/feedback/proguard/n:close	()V
    //   139: iconst_0
    //   140: ireturn
    //   141: new 654	android/content/ContentValues
    //   144: dup
    //   145: invokespecial 655	android/content/ContentValues:<init>	()V
    //   148: astore 5
    //   150: aload_1
    //   151: invokevirtual 656	com/tencent/feedback/proguard/z:a	()J
    //   154: lconst_0
    //   155: lcmp
    //   156: iflt +18 -> 174
    //   159: aload 5
    //   161: ldc_w 280
    //   164: aload_1
    //   165: invokevirtual 656	com/tencent/feedback/proguard/z:a	()J
    //   168: invokestatic 661	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   171: invokevirtual 665	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   174: aload 5
    //   176: ldc 238
    //   178: aload_1
    //   179: invokevirtual 269	com/tencent/feedback/proguard/z:b	()I
    //   182: invokestatic 244	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   185: invokevirtual 668	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   188: aload 5
    //   190: ldc_w 303
    //   193: aload_1
    //   194: invokevirtual 670	com/tencent/feedback/proguard/z:c	()[B
    //   197: invokevirtual 673	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   200: aload 5
    //   202: ldc_w 299
    //   205: aload_1
    //   206: invokevirtual 675	com/tencent/feedback/proguard/z:d	()J
    //   209: invokestatic 661	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   212: invokevirtual 665	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   215: goto -129 -> 86
    //   218: astore 5
    //   220: aload 4
    //   222: astore_1
    //   223: aload 5
    //   225: astore 4
    //   227: ldc_w 677
    //   230: iconst_1
    //   231: anewarray 4	java/lang/Object
    //   234: dup
    //   235: iconst_0
    //   236: aload 4
    //   238: invokevirtual 313	java/lang/Throwable:toString	()Ljava/lang/String;
    //   241: aastore
    //   242: invokestatic 101	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   245: aload 4
    //   247: invokevirtual 202	java/lang/Throwable:printStackTrace	()V
    //   250: aload_0
    //   251: ifnull +14 -> 265
    //   254: aload_0
    //   255: invokevirtual 222	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   258: ifeq +7 -> 265
    //   261: aload_0
    //   262: invokevirtual 225	android/database/sqlite/SQLiteDatabase:close	()V
    //   265: aload_1
    //   266: ifnull -242 -> 24
    //   269: aload_1
    //   270: invokevirtual 226	com/tencent/feedback/proguard/n:close	()V
    //   273: iconst_0
    //   274: ireturn
    //   275: aload_1
    //   276: lload_2
    //   277: invokevirtual 291	com/tencent/feedback/proguard/z:a	(J)V
    //   280: ldc_w 679
    //   283: iconst_1
    //   284: anewarray 4	java/lang/Object
    //   287: dup
    //   288: iconst_0
    //   289: aload_1
    //   290: invokevirtual 269	com/tencent/feedback/proguard/z:b	()I
    //   293: invokestatic 244	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   296: aastore
    //   297: invokestatic 681	com/tencent/feedback/common/e:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: aload_0
    //   301: ifnull +14 -> 315
    //   304: aload_0
    //   305: invokevirtual 222	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   308: ifeq +7 -> 315
    //   311: aload_0
    //   312: invokevirtual 225	android/database/sqlite/SQLiteDatabase:close	()V
    //   315: aload 4
    //   317: invokevirtual 226	com/tencent/feedback/proguard/n:close	()V
    //   320: iconst_1
    //   321: ireturn
    //   322: aload_0
    //   323: ifnull +14 -> 337
    //   326: aload_0
    //   327: invokevirtual 222	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   330: ifeq +7 -> 337
    //   333: aload_0
    //   334: invokevirtual 225	android/database/sqlite/SQLiteDatabase:close	()V
    //   337: aload 4
    //   339: invokevirtual 226	com/tencent/feedback/proguard/n:close	()V
    //   342: iconst_0
    //   343: ireturn
    //   344: astore_1
    //   345: aconst_null
    //   346: astore_0
    //   347: aconst_null
    //   348: astore 4
    //   350: aload_0
    //   351: ifnull +14 -> 365
    //   354: aload_0
    //   355: invokevirtual 222	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   358: ifeq +7 -> 365
    //   361: aload_0
    //   362: invokevirtual 225	android/database/sqlite/SQLiteDatabase:close	()V
    //   365: aload 4
    //   367: ifnull +8 -> 375
    //   370: aload 4
    //   372: invokevirtual 226	com/tencent/feedback/proguard/n:close	()V
    //   375: aload_1
    //   376: athrow
    //   377: astore_1
    //   378: aconst_null
    //   379: astore_0
    //   380: goto -30 -> 350
    //   383: astore_1
    //   384: goto -34 -> 350
    //   387: astore 5
    //   389: aload_1
    //   390: astore 4
    //   392: aload 5
    //   394: astore_1
    //   395: goto -45 -> 350
    //   398: astore 4
    //   400: aconst_null
    //   401: astore_0
    //   402: aload 5
    //   404: astore_1
    //   405: goto -178 -> 227
    //   408: astore 5
    //   410: aconst_null
    //   411: astore_0
    //   412: aload 4
    //   414: astore_1
    //   415: aload 5
    //   417: astore 4
    //   419: goto -192 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	422	0	paramContext	Context
    //   0	422	1	paramz	z
    //   102	175	2	l	long
    //   34	357	4	localObject1	Object
    //   398	15	4	localThrowable1	Throwable
    //   417	1	4	localThrowable2	Throwable
    //   1	200	5	localObject2	Object
    //   218	6	5	localThrowable3	Throwable
    //   387	16	5	localObject3	Object
    //   408	8	5	localThrowable4	Throwable
    //   4	79	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   46	56	218	java/lang/Throwable
    //   91	103	218	java/lang/Throwable
    //   109	119	218	java/lang/Throwable
    //   141	174	218	java/lang/Throwable
    //   174	215	218	java/lang/Throwable
    //   275	300	218	java/lang/Throwable
    //   26	36	344	finally
    //   36	42	377	finally
    //   46	56	383	finally
    //   91	103	383	finally
    //   109	119	383	finally
    //   141	174	383	finally
    //   174	215	383	finally
    //   275	300	383	finally
    //   227	250	387	finally
    //   26	36	398	java/lang/Throwable
    //   36	42	408	java/lang/Throwable
  }
  
  /* Error */
  public static boolean a(java.io.File paramFile1, java.io.File paramFile2, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc_w 684
    //   6: iconst_0
    //   7: anewarray 4	java/lang/Object
    //   10: invokestatic 97	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   13: aload_0
    //   14: ifnull +15 -> 29
    //   17: aload_1
    //   18: ifnull +11 -> 29
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 685	java/io/File:equals	(Ljava/lang/Object;)Z
    //   26: ifeq +15 -> 41
    //   29: ldc_w 687
    //   32: iconst_0
    //   33: anewarray 4	java/lang/Object
    //   36: invokestatic 75	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   39: iconst_0
    //   40: ireturn
    //   41: aload_0
    //   42: invokevirtual 563	java/io/File:exists	()Z
    //   45: ifeq +10 -> 55
    //   48: aload_0
    //   49: invokevirtual 690	java/io/File:canRead	()Z
    //   52: ifne +15 -> 67
    //   55: ldc_w 692
    //   58: iconst_0
    //   59: anewarray 4	java/lang/Object
    //   62: invokestatic 75	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   65: iconst_0
    //   66: ireturn
    //   67: aload_1
    //   68: invokevirtual 567	java/io/File:getParentFile	()Ljava/io/File;
    //   71: ifnull +21 -> 92
    //   74: aload_1
    //   75: invokevirtual 567	java/io/File:getParentFile	()Ljava/io/File;
    //   78: invokevirtual 563	java/io/File:exists	()Z
    //   81: ifne +11 -> 92
    //   84: aload_1
    //   85: invokevirtual 567	java/io/File:getParentFile	()Ljava/io/File;
    //   88: invokevirtual 570	java/io/File:mkdirs	()Z
    //   91: pop
    //   92: aload_1
    //   93: invokevirtual 563	java/io/File:exists	()Z
    //   96: ifne +8 -> 104
    //   99: aload_1
    //   100: invokevirtual 573	java/io/File:createNewFile	()Z
    //   103: pop
    //   104: aload_1
    //   105: invokevirtual 563	java/io/File:exists	()Z
    //   108: ifeq -69 -> 39
    //   111: aload_1
    //   112: invokevirtual 690	java/io/File:canRead	()Z
    //   115: ifeq -76 -> 39
    //   118: new 694	java/io/FileInputStream
    //   121: dup
    //   122: aload_0
    //   123: invokespecial 697	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   126: astore_3
    //   127: new 699	java/util/zip/ZipOutputStream
    //   130: dup
    //   131: new 577	java/io/FileOutputStream
    //   134: dup
    //   135: aload_1
    //   136: invokespecial 700	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   139: invokespecial 703	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   142: astore 4
    //   144: aload 4
    //   146: bipush 8
    //   148: invokevirtual 706	java/util/zip/ZipOutputStream:setMethod	(I)V
    //   151: aload 4
    //   153: new 708	java/util/zip/ZipEntry
    //   156: dup
    //   157: aload_0
    //   158: invokevirtual 709	java/io/File:getName	()Ljava/lang/String;
    //   161: invokespecial 710	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   164: invokevirtual 714	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   167: sipush 5000
    //   170: newarray byte
    //   172: astore_0
    //   173: aload_3
    //   174: aload_0
    //   175: invokevirtual 718	java/io/FileInputStream:read	([B)I
    //   178: istore_2
    //   179: iload_2
    //   180: ifle +63 -> 243
    //   183: aload 4
    //   185: aload_0
    //   186: iconst_0
    //   187: iload_2
    //   188: invokevirtual 721	java/util/zip/ZipOutputStream:write	([BII)V
    //   191: goto -18 -> 173
    //   194: astore 5
    //   196: aload_3
    //   197: astore_1
    //   198: aload 4
    //   200: astore_0
    //   201: aload 5
    //   203: astore_3
    //   204: aload_3
    //   205: invokevirtual 202	java/lang/Throwable:printStackTrace	()V
    //   208: aload_1
    //   209: ifnull +7 -> 216
    //   212: aload_1
    //   213: invokevirtual 722	java/io/FileInputStream:close	()V
    //   216: aload_0
    //   217: ifnull +7 -> 224
    //   220: aload_0
    //   221: invokevirtual 723	java/util/zip/ZipOutputStream:close	()V
    //   224: ldc_w 725
    //   227: iconst_0
    //   228: anewarray 4	java/lang/Object
    //   231: invokestatic 97	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: iconst_0
    //   235: ireturn
    //   236: astore_0
    //   237: aload_0
    //   238: invokevirtual 202	java/lang/Throwable:printStackTrace	()V
    //   241: iconst_0
    //   242: ireturn
    //   243: aload 4
    //   245: invokevirtual 726	java/util/zip/ZipOutputStream:flush	()V
    //   248: aload 4
    //   250: invokevirtual 729	java/util/zip/ZipOutputStream:closeEntry	()V
    //   253: aload_3
    //   254: invokevirtual 722	java/io/FileInputStream:close	()V
    //   257: aload 4
    //   259: invokevirtual 723	java/util/zip/ZipOutputStream:close	()V
    //   262: ldc_w 725
    //   265: iconst_0
    //   266: anewarray 4	java/lang/Object
    //   269: invokestatic 97	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   272: iconst_1
    //   273: ireturn
    //   274: astore_0
    //   275: aload_0
    //   276: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   279: goto -22 -> 257
    //   282: astore_0
    //   283: aload_0
    //   284: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   287: goto -25 -> 262
    //   290: astore_1
    //   291: aload_1
    //   292: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   295: goto -79 -> 216
    //   298: astore_0
    //   299: aload_0
    //   300: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   303: goto -79 -> 224
    //   306: astore_1
    //   307: aconst_null
    //   308: astore_0
    //   309: aconst_null
    //   310: astore_3
    //   311: aload_3
    //   312: ifnull +7 -> 319
    //   315: aload_3
    //   316: invokevirtual 722	java/io/FileInputStream:close	()V
    //   319: aload_0
    //   320: ifnull +7 -> 327
    //   323: aload_0
    //   324: invokevirtual 723	java/util/zip/ZipOutputStream:close	()V
    //   327: ldc_w 725
    //   330: iconst_0
    //   331: anewarray 4	java/lang/Object
    //   334: invokestatic 97	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   337: aload_1
    //   338: athrow
    //   339: astore_3
    //   340: aload_3
    //   341: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   344: goto -25 -> 319
    //   347: astore_0
    //   348: aload_0
    //   349: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   352: goto -25 -> 327
    //   355: astore_1
    //   356: aconst_null
    //   357: astore_0
    //   358: goto -47 -> 311
    //   361: astore_1
    //   362: aload 4
    //   364: astore_0
    //   365: goto -54 -> 311
    //   368: astore 4
    //   370: aload_1
    //   371: astore_3
    //   372: aload 4
    //   374: astore_1
    //   375: goto -64 -> 311
    //   378: astore_3
    //   379: aconst_null
    //   380: astore_0
    //   381: aload 4
    //   383: astore_1
    //   384: goto -180 -> 204
    //   387: astore 4
    //   389: aconst_null
    //   390: astore_0
    //   391: aload_3
    //   392: astore_1
    //   393: aload 4
    //   395: astore_3
    //   396: goto -192 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	399	0	paramFile1	java.io.File
    //   0	399	1	paramFile2	java.io.File
    //   0	399	2	paramInt	int
    //   126	190	3	localObject1	Object
    //   339	2	3	localIOException	java.io.IOException
    //   371	1	3	localFile	java.io.File
    //   378	14	3	localThrowable1	Throwable
    //   395	1	3	localThrowable2	Throwable
    //   1	362	4	localZipOutputStream	java.util.zip.ZipOutputStream
    //   368	14	4	localObject2	Object
    //   387	7	4	localThrowable3	Throwable
    //   194	8	5	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   144	173	194	java/lang/Throwable
    //   173	179	194	java/lang/Throwable
    //   183	191	194	java/lang/Throwable
    //   243	253	194	java/lang/Throwable
    //   67	92	236	java/lang/Throwable
    //   92	104	236	java/lang/Throwable
    //   253	257	274	java/io/IOException
    //   257	262	282	java/io/IOException
    //   212	216	290	java/io/IOException
    //   220	224	298	java/io/IOException
    //   118	127	306	finally
    //   315	319	339	java/io/IOException
    //   323	327	347	java/io/IOException
    //   127	144	355	finally
    //   144	173	361	finally
    //   173	179	361	finally
    //   183	191	361	finally
    //   243	253	361	finally
    //   204	208	368	finally
    //   118	127	378	java/lang/Throwable
    //   127	144	387	java/lang/Throwable
  }
  
  /* Error */
  public static boolean a(String[] paramArrayOfString, com.tencent.feedback.eup.a<String> parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +8 -> 9
    //   4: aload_0
    //   5: arraylength
    //   6: ifgt +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: aconst_null
    //   12: astore_3
    //   13: aconst_null
    //   14: astore_2
    //   15: invokestatic 483	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   18: aload_0
    //   19: invokevirtual 487	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   22: astore_0
    //   23: aload_1
    //   24: ifnull +147 -> 171
    //   27: aload_0
    //   28: astore_2
    //   29: aload_0
    //   30: astore_3
    //   31: new 489	java/io/BufferedReader
    //   34: dup
    //   35: new 491	java/io/InputStreamReader
    //   38: dup
    //   39: aload_0
    //   40: invokevirtual 497	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   43: invokespecial 500	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   46: invokespecial 503	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   49: astore 4
    //   51: aload_0
    //   52: astore_2
    //   53: aload_0
    //   54: astore_3
    //   55: aload 4
    //   57: invokevirtual 506	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   60: astore 5
    //   62: aload 5
    //   64: ifnull +71 -> 135
    //   67: aload_0
    //   68: astore_2
    //   69: aload_0
    //   70: astore_3
    //   71: aload_1
    //   72: aload 5
    //   74: invokevirtual 733	com/tencent/feedback/eup/a:add	(Ljava/lang/Object;)Z
    //   77: pop
    //   78: goto -27 -> 51
    //   81: astore_0
    //   82: aload_2
    //   83: astore_3
    //   84: aload_0
    //   85: invokevirtual 202	java/lang/Throwable:printStackTrace	()V
    //   88: aload_2
    //   89: astore_3
    //   90: aload_0
    //   91: invokevirtual 734	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   94: iconst_0
    //   95: anewarray 4	java/lang/Object
    //   98: invokestatic 101	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: aload_2
    //   102: ifnull -93 -> 9
    //   105: aload_2
    //   106: invokevirtual 738	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   109: invokevirtual 741	java/io/OutputStream:close	()V
    //   112: aload_2
    //   113: invokevirtual 497	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   116: invokevirtual 744	java/io/InputStream:close	()V
    //   119: aload_2
    //   120: invokevirtual 510	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   123: invokevirtual 744	java/io/InputStream:close	()V
    //   126: iconst_0
    //   127: ireturn
    //   128: astore_0
    //   129: aload_0
    //   130: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   133: iconst_0
    //   134: ireturn
    //   135: aload_0
    //   136: astore_2
    //   137: aload_0
    //   138: astore_3
    //   139: aload 4
    //   141: invokevirtual 507	java/io/BufferedReader:close	()V
    //   144: aload_0
    //   145: ifnull +24 -> 169
    //   148: aload_0
    //   149: invokevirtual 738	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   152: invokevirtual 741	java/io/OutputStream:close	()V
    //   155: aload_0
    //   156: invokevirtual 497	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   159: invokevirtual 744	java/io/InputStream:close	()V
    //   162: aload_0
    //   163: invokevirtual 510	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   166: invokevirtual 744	java/io/InputStream:close	()V
    //   169: iconst_1
    //   170: ireturn
    //   171: aload_0
    //   172: astore_2
    //   173: aload_0
    //   174: astore_3
    //   175: aload_0
    //   176: invokevirtual 747	java/lang/Process:waitFor	()I
    //   179: pop
    //   180: goto -36 -> 144
    //   183: astore_0
    //   184: aload_3
    //   185: ifnull +24 -> 209
    //   188: aload_3
    //   189: invokevirtual 738	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   192: invokevirtual 741	java/io/OutputStream:close	()V
    //   195: aload_3
    //   196: invokevirtual 497	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   199: invokevirtual 744	java/io/InputStream:close	()V
    //   202: aload_3
    //   203: invokevirtual 510	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   206: invokevirtual 744	java/io/InputStream:close	()V
    //   209: aload_0
    //   210: athrow
    //   211: astore_1
    //   212: aload_1
    //   213: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   216: goto -61 -> 155
    //   219: astore_1
    //   220: aload_1
    //   221: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   224: goto -62 -> 162
    //   227: astore_0
    //   228: aload_0
    //   229: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   232: goto -63 -> 169
    //   235: astore_0
    //   236: aload_0
    //   237: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   240: goto -128 -> 112
    //   243: astore_0
    //   244: aload_0
    //   245: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   248: goto -129 -> 119
    //   251: astore_1
    //   252: aload_1
    //   253: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   256: goto -61 -> 195
    //   259: astore_1
    //   260: aload_1
    //   261: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   264: goto -62 -> 202
    //   267: astore_1
    //   268: aload_1
    //   269: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   272: goto -63 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	paramArrayOfString	String[]
    //   0	275	1	parama	com.tencent.feedback.eup.a<String>
    //   14	159	2	arrayOfString	String[]
    //   12	191	3	localObject	Object
    //   49	91	4	localBufferedReader	java.io.BufferedReader
    //   60	13	5	str	String
    // Exception table:
    //   from	to	target	type
    //   15	23	81	java/lang/Throwable
    //   31	51	81	java/lang/Throwable
    //   55	62	81	java/lang/Throwable
    //   71	78	81	java/lang/Throwable
    //   139	144	81	java/lang/Throwable
    //   175	180	81	java/lang/Throwable
    //   119	126	128	java/io/IOException
    //   15	23	183	finally
    //   31	51	183	finally
    //   55	62	183	finally
    //   71	78	183	finally
    //   84	88	183	finally
    //   90	101	183	finally
    //   139	144	183	finally
    //   175	180	183	finally
    //   148	155	211	java/io/IOException
    //   155	162	219	java/io/IOException
    //   162	169	227	java/io/IOException
    //   105	112	235	java/io/IOException
    //   112	119	243	java/io/IOException
    //   188	195	251	java/io/IOException
    //   195	202	259	java/io/IOException
    //   202	209	267	java/io/IOException
  }
  
  /* Error */
  public static byte[] a(Object paramObject)
  {
    // Byte code:
    //   0: ldc_w 750
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 97	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   10: aload_0
    //   11: ifnull +13 -> 24
    //   14: ldc_w 752
    //   17: aload_0
    //   18: invokevirtual 755	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   21: ifne +15 -> 36
    //   24: ldc_w 757
    //   27: iconst_0
    //   28: anewarray 4	java/lang/Object
    //   31: invokestatic 75	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: aconst_null
    //   35: areturn
    //   36: new 759	java/io/ByteArrayOutputStream
    //   39: dup
    //   40: invokespecial 760	java/io/ByteArrayOutputStream:<init>	()V
    //   43: astore 4
    //   45: new 762	java/io/ObjectOutputStream
    //   48: dup
    //   49: aload 4
    //   51: invokespecial 763	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   54: astore_2
    //   55: aload_2
    //   56: astore_1
    //   57: aload_2
    //   58: aload_0
    //   59: invokevirtual 767	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   62: aload_2
    //   63: astore_1
    //   64: aload_2
    //   65: invokevirtual 768	java/io/ObjectOutputStream:flush	()V
    //   68: aload_2
    //   69: astore_1
    //   70: aload 4
    //   72: invokevirtual 771	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   75: astore_0
    //   76: aload_2
    //   77: invokevirtual 772	java/io/ObjectOutputStream:close	()V
    //   80: aload 4
    //   82: invokevirtual 773	java/io/ByteArrayOutputStream:close	()V
    //   85: aload_0
    //   86: areturn
    //   87: astore_1
    //   88: aload_1
    //   89: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   92: aload_0
    //   93: areturn
    //   94: astore_1
    //   95: aload_1
    //   96: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   99: goto -19 -> 80
    //   102: astore_3
    //   103: aconst_null
    //   104: astore_0
    //   105: aload_0
    //   106: astore_1
    //   107: aload_3
    //   108: invokevirtual 202	java/lang/Throwable:printStackTrace	()V
    //   111: aload_0
    //   112: astore_1
    //   113: aload_3
    //   114: invokevirtual 734	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   117: iconst_0
    //   118: anewarray 4	java/lang/Object
    //   121: invokestatic 101	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: aload_0
    //   125: ifnull +7 -> 132
    //   128: aload_0
    //   129: invokevirtual 772	java/io/ObjectOutputStream:close	()V
    //   132: aload 4
    //   134: invokevirtual 773	java/io/ByteArrayOutputStream:close	()V
    //   137: aconst_null
    //   138: areturn
    //   139: astore_0
    //   140: aload_0
    //   141: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   144: aconst_null
    //   145: areturn
    //   146: astore_0
    //   147: aload_0
    //   148: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   151: goto -19 -> 132
    //   154: astore_0
    //   155: aconst_null
    //   156: astore_1
    //   157: aload_1
    //   158: ifnull +7 -> 165
    //   161: aload_1
    //   162: invokevirtual 772	java/io/ObjectOutputStream:close	()V
    //   165: aload 4
    //   167: invokevirtual 773	java/io/ByteArrayOutputStream:close	()V
    //   170: aload_0
    //   171: athrow
    //   172: astore_1
    //   173: aload_1
    //   174: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   177: goto -12 -> 165
    //   180: astore_1
    //   181: aload_1
    //   182: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   185: goto -15 -> 170
    //   188: astore_0
    //   189: goto -32 -> 157
    //   192: astore_3
    //   193: aload_2
    //   194: astore_0
    //   195: goto -90 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramObject	Object
    //   56	14	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   87	2	1	localIOException1	java.io.IOException
    //   94	2	1	localIOException2	java.io.IOException
    //   106	56	1	localObject	Object
    //   172	2	1	localIOException3	java.io.IOException
    //   180	2	1	localIOException4	java.io.IOException
    //   54	140	2	localObjectOutputStream2	java.io.ObjectOutputStream
    //   102	12	3	localThrowable1	Throwable
    //   192	1	3	localThrowable2	Throwable
    //   43	123	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   80	85	87	java/io/IOException
    //   76	80	94	java/io/IOException
    //   45	55	102	java/lang/Throwable
    //   132	137	139	java/io/IOException
    //   128	132	146	java/io/IOException
    //   45	55	154	finally
    //   161	165	172	java/io/IOException
    //   165	170	180	java/io/IOException
    //   57	62	188	finally
    //   64	68	188	finally
    //   70	76	188	finally
    //   107	111	188	finally
    //   113	124	188	finally
    //   57	62	192	java/lang/Throwable
    //   64	68	192	java/lang/Throwable
    //   70	76	192	java/lang/Throwable
  }
  
  /* Error */
  public static byte[] a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: new 158	java/lang/StringBuilder
    //   3: dup
    //   4: ldc_w 776
    //   7: invokespecial 431	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   10: iload_1
    //   11: invokevirtual 779	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17: iconst_0
    //   18: anewarray 4	java/lang/Object
    //   21: invokestatic 781	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: new 37	java/util/ArrayList
    //   27: dup
    //   28: invokespecial 477	java/util/ArrayList:<init>	()V
    //   31: astore_2
    //   32: aload_2
    //   33: invokevirtual 784	java/util/ArrayList:clear	()V
    //   36: aload_2
    //   37: ldc_w 786
    //   40: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   43: pop
    //   44: aload_2
    //   45: ldc_w 788
    //   48: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   51: pop
    //   52: aload_2
    //   53: ldc_w 790
    //   56: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   59: pop
    //   60: aload_2
    //   61: ldc_w 792
    //   64: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   67: pop
    //   68: aload_0
    //   69: ifnull +24 -> 93
    //   72: aload_0
    //   73: invokevirtual 319	java/lang/String:length	()I
    //   76: ifle +17 -> 93
    //   79: aload_2
    //   80: ldc_w 794
    //   83: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   86: pop
    //   87: aload_2
    //   88: aload_0
    //   89: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   92: pop
    //   93: aload_2
    //   94: invokevirtual 64	java/util/ArrayList:size	()I
    //   97: anewarray 191	java/lang/String
    //   100: astore_3
    //   101: aload_2
    //   102: aload_3
    //   103: invokevirtual 798	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   106: pop
    //   107: new 732	com/tencent/feedback/eup/a
    //   110: dup
    //   111: iload_1
    //   112: invokespecial 799	com/tencent/feedback/eup/a:<init>	(I)V
    //   115: astore_0
    //   116: aload_3
    //   117: aload_0
    //   118: invokestatic 801	com/tencent/feedback/proguard/a:a	([Ljava/lang/String;Lcom/tencent/feedback/eup/a;)Z
    //   121: pop
    //   122: aload_0
    //   123: invokevirtual 802	com/tencent/feedback/eup/a:size	()I
    //   126: ifgt +5 -> 131
    //   129: aconst_null
    //   130: areturn
    //   131: new 158	java/lang/StringBuilder
    //   134: dup
    //   135: ldc_w 804
    //   138: invokespecial 431	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   141: aload_0
    //   142: invokevirtual 802	com/tencent/feedback/eup/a:size	()I
    //   145: invokevirtual 779	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: iconst_0
    //   152: anewarray 4	java/lang/Object
    //   155: invokestatic 781	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   158: new 339	java/lang/StringBuffer
    //   161: dup
    //   162: invokespecial 340	java/lang/StringBuffer:<init>	()V
    //   165: astore_2
    //   166: aload_0
    //   167: invokevirtual 805	com/tencent/feedback/eup/a:iterator	()Ljava/util/Iterator;
    //   170: astore_3
    //   171: aload_3
    //   172: invokeinterface 446 1 0
    //   177: ifeq +66 -> 243
    //   180: aload_2
    //   181: new 158	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   188: aload_3
    //   189: invokeinterface 450 1 0
    //   194: checkcast 191	java/lang/String
    //   197: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc_w 807
    //   203: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokevirtual 349	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   212: pop
    //   213: goto -42 -> 171
    //   216: astore_0
    //   217: aload_0
    //   218: invokevirtual 202	java/lang/Throwable:printStackTrace	()V
    //   221: ldc_w 809
    //   224: iconst_0
    //   225: anewarray 4	java/lang/Object
    //   228: invokestatic 101	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   231: ldc_w 811
    //   234: iconst_0
    //   235: anewarray 4	java/lang/Object
    //   238: invokestatic 781	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   241: aconst_null
    //   242: areturn
    //   243: aload_0
    //   244: invokevirtual 812	com/tencent/feedback/eup/a:clear	()V
    //   247: aload_2
    //   248: invokevirtual 350	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   251: ldc_w 814
    //   254: invokevirtual 585	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   257: astore_0
    //   258: aload_2
    //   259: iconst_0
    //   260: invokevirtual 817	java/lang/StringBuffer:setLength	(I)V
    //   263: ldc_w 811
    //   266: iconst_0
    //   267: anewarray 4	java/lang/Object
    //   270: invokestatic 781	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   273: aload_0
    //   274: areturn
    //   275: astore_0
    //   276: ldc_w 811
    //   279: iconst_0
    //   280: anewarray 4	java/lang/Object
    //   283: invokestatic 781	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   286: aload_0
    //   287: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	paramString	String
    //   0	288	1	paramInt	int
    //   31	228	2	localObject1	Object
    //   100	89	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   158	171	216	java/lang/Throwable
    //   171	213	216	java/lang/Throwable
    //   243	263	216	java/lang/Throwable
    //   158	171	275	finally
    //   171	213	275	finally
    //   217	231	275	finally
    //   243	263	275	finally
  }
  
  /* Error */
  public static byte[] a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 319	java/lang/String:length	()I
    //   8: ifne +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 559	java/io/File
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 560	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore_0
    //   22: aload_0
    //   23: invokevirtual 563	java/io/File:exists	()Z
    //   26: ifeq -15 -> 11
    //   29: aload_0
    //   30: invokevirtual 690	java/io/File:canRead	()Z
    //   33: ifeq -22 -> 11
    //   36: new 694	java/io/FileInputStream
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 697	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   44: astore_0
    //   45: aload_1
    //   46: ifnull +154 -> 200
    //   49: aload_1
    //   50: invokevirtual 319	java/lang/String:length	()I
    //   53: ifne +55 -> 108
    //   56: goto +144 -> 200
    //   59: aload_3
    //   60: invokevirtual 353	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   63: invokestatic 327	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   66: astore_1
    //   67: sipush 4096
    //   70: newarray byte
    //   72: astore_3
    //   73: aload_0
    //   74: aload_3
    //   75: invokevirtual 718	java/io/FileInputStream:read	([B)I
    //   78: istore_2
    //   79: iload_2
    //   80: iconst_m1
    //   81: if_icmpeq +58 -> 139
    //   84: aload_1
    //   85: aload_3
    //   86: iconst_0
    //   87: iload_2
    //   88: invokevirtual 820	java/security/MessageDigest:update	([BII)V
    //   91: goto -18 -> 73
    //   94: astore_1
    //   95: aload_0
    //   96: ifnull -85 -> 11
    //   99: aload_0
    //   100: invokevirtual 722	java/io/FileInputStream:close	()V
    //   103: aconst_null
    //   104: areturn
    //   105: astore_0
    //   106: aconst_null
    //   107: areturn
    //   108: aload_1
    //   109: astore_3
    //   110: aload_1
    //   111: ldc_w 321
    //   114: invokevirtual 824	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   117: ifne -58 -> 59
    //   120: aload_1
    //   121: astore_3
    //   122: aload_1
    //   123: ldc_w 826
    //   126: invokevirtual 824	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   129: ifne -70 -> 59
    //   132: ldc_w 321
    //   135: astore_3
    //   136: goto -77 -> 59
    //   139: aload_1
    //   140: invokevirtual 333	java/security/MessageDigest:digest	()[B
    //   143: astore_1
    //   144: aload_0
    //   145: invokevirtual 722	java/io/FileInputStream:close	()V
    //   148: aload_1
    //   149: areturn
    //   150: astore_0
    //   151: aload_1
    //   152: areturn
    //   153: astore_0
    //   154: aconst_null
    //   155: astore_0
    //   156: aload_0
    //   157: ifnull -146 -> 11
    //   160: aload_0
    //   161: invokevirtual 722	java/io/FileInputStream:close	()V
    //   164: aconst_null
    //   165: areturn
    //   166: astore_0
    //   167: aconst_null
    //   168: areturn
    //   169: astore_1
    //   170: aconst_null
    //   171: astore_0
    //   172: aload_0
    //   173: ifnull +7 -> 180
    //   176: aload_0
    //   177: invokevirtual 722	java/io/FileInputStream:close	()V
    //   180: aload_1
    //   181: athrow
    //   182: astore_0
    //   183: goto -3 -> 180
    //   186: astore_1
    //   187: goto -15 -> 172
    //   190: astore_1
    //   191: goto -35 -> 156
    //   194: astore_0
    //   195: aconst_null
    //   196: astore_0
    //   197: goto -102 -> 95
    //   200: ldc_w 321
    //   203: astore_3
    //   204: goto -145 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	paramString1	String
    //   0	207	1	paramString2	String
    //   78	10	2	i	int
    //   59	145	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   49	56	94	java/io/IOException
    //   59	73	94	java/io/IOException
    //   73	79	94	java/io/IOException
    //   84	91	94	java/io/IOException
    //   110	120	94	java/io/IOException
    //   122	132	94	java/io/IOException
    //   139	144	94	java/io/IOException
    //   99	103	105	java/io/IOException
    //   144	148	150	java/io/IOException
    //   36	45	153	java/security/NoSuchAlgorithmException
    //   160	164	166	java/io/IOException
    //   36	45	169	finally
    //   176	180	182	java/io/IOException
    //   49	56	186	finally
    //   59	73	186	finally
    //   73	79	186	finally
    //   84	91	186	finally
    //   110	120	186	finally
    //   122	132	186	finally
    //   139	144	186	finally
    //   49	56	190	java/security/NoSuchAlgorithmException
    //   59	73	190	java/security/NoSuchAlgorithmException
    //   73	79	190	java/security/NoSuchAlgorithmException
    //   84	91	190	java/security/NoSuchAlgorithmException
    //   110	120	190	java/security/NoSuchAlgorithmException
    //   122	132	190	java/security/NoSuchAlgorithmException
    //   139	144	190	java/security/NoSuchAlgorithmException
    //   36	45	194	java/io/IOException
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    e.b("rqdp{  zp:} %s rqdp{  len:} %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) });
    try
    {
      N localN = M.a(paramInt);
      if (localN == null) {
        return null;
      }
      paramArrayOfByte = localN.a(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      e.d("rqdp{  err zp :} %s", new Object[] { paramArrayOfByte.toString() });
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = a(a(paramArrayOfByte, paramInt1), paramInt2, paramString);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    e.b("rqdp{  enD:} %d %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt) });
    if (paramInt == 1) {}
    Object localObject;
    try
    {
      localObject = new R();
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      e.d("rqdp{  err enD: }%s", new Object[] { paramArrayOfByte.toString() });
      return null;
    }
    if (paramInt == 3) {
      localObject = new Q();
    } else {
      localObject = null;
    }
    while (localObject != null)
    {
      ((S)localObject).a(paramString);
      paramArrayOfByte = ((S)localObject).b(paramArrayOfByte);
      return paramArrayOfByte;
    }
    return null;
  }
  
  public static q[] a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {}
    for (;;)
    {
      try
      {
        e.c("rqdp{  args error}", new Object[0]);
        paramContext = null;
        return paramContext;
      }
      finally {}
      paramString = l.a(paramContext, new int[] { 9 }, -1, -1, 10000L, -1, paramString, -1, -1, -1, -1, -1L, 9223372036854775807L);
      if ((paramString != null) && (paramString.size() > 0))
      {
        paramContext = new ArrayList(paramString.size());
        paramString = paramString.iterator();
        if (paramString.hasNext())
        {
          l locall = (l)paramString.next();
          Object localObject = b(locall.b());
          if ((localObject != null) && (q.class.isInstance(localObject)))
          {
            localObject = (q)q.class.cast(localObject);
            ((q)localObject).b(locall.a());
            paramContext.add(localObject);
          }
        }
        else if (paramContext.size() > 0)
        {
          paramContext = (q[])paramContext.toArray(new q[0]);
        }
        else
        {
          paramContext = null;
        }
      }
      else
      {
        paramContext = null;
      }
    }
  }
  
  public static Long[] a(LinkedHashMap<Long, Long> paramLinkedHashMap, long paramLong)
  {
    if ((paramLinkedHashMap == null) || (paramLinkedHashMap.size() <= 0) || (paramLong <= 0L)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramLinkedHashMap.keySet().iterator();
    long l1 = 0L;
    if ((localIterator.hasNext()) && (l1 < paramLong))
    {
      long l2 = ((Long)localIterator.next()).longValue();
      long l3 = ((Long)paramLinkedHashMap.get(Long.valueOf(l2))).longValue();
      if (l1 + l3 > paramLong) {
        break label140;
      }
      localArrayList.add(Long.valueOf(l2));
      l1 += l3;
    }
    label140:
    for (;;)
    {
      break;
      if (localArrayList.size() > 0) {
        return (Long[])localArrayList.toArray(new Long[1]);
      }
      return null;
    }
  }
  
  /* Error */
  public static int b(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_2
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore_3
    //   10: aload_0
    //   11: ifnonnull +15 -> 26
    //   14: ldc_w 884
    //   17: iconst_0
    //   18: anewarray 4	java/lang/Object
    //   21: invokestatic 75	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: iconst_0
    //   25: ireturn
    //   26: new 207	com/tencent/feedback/proguard/n
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 210	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   34: astore 4
    //   36: aload_2
    //   37: astore_0
    //   38: aload 4
    //   40: astore_2
    //   41: aload 6
    //   43: astore_3
    //   44: aload 4
    //   46: invokevirtual 214	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   49: astore 5
    //   51: aload 5
    //   53: ifnonnull +47 -> 100
    //   56: aload 5
    //   58: astore_0
    //   59: aload 4
    //   61: astore_2
    //   62: aload 5
    //   64: astore_3
    //   65: ldc_w 646
    //   68: iconst_0
    //   69: anewarray 4	java/lang/Object
    //   72: invokestatic 101	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: aload 5
    //   77: ifnull +16 -> 93
    //   80: aload 5
    //   82: invokevirtual 222	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   85: ifeq +8 -> 93
    //   88: aload 5
    //   90: invokevirtual 225	android/database/sqlite/SQLiteDatabase:close	()V
    //   93: aload 4
    //   95: invokevirtual 226	com/tencent/feedback/proguard/n:close	()V
    //   98: iconst_0
    //   99: ireturn
    //   100: aload 5
    //   102: astore_0
    //   103: aload 4
    //   105: astore_2
    //   106: aload 5
    //   108: astore_3
    //   109: aload 5
    //   111: ldc 228
    //   113: ldc_w 886
    //   116: iconst_2
    //   117: anewarray 4	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: ldc 238
    //   124: aastore
    //   125: dup
    //   126: iconst_1
    //   127: sipush 302
    //   130: invokestatic 244	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   133: aastore
    //   134: invokestatic 889	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   137: aconst_null
    //   138: invokevirtual 893	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   141: istore_1
    //   142: aload 5
    //   144: astore_0
    //   145: aload 4
    //   147: astore_2
    //   148: aload 5
    //   150: astore_3
    //   151: ldc_w 895
    //   154: iconst_2
    //   155: anewarray 4	java/lang/Object
    //   158: dup
    //   159: iconst_0
    //   160: sipush 302
    //   163: invokestatic 244	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   166: aastore
    //   167: dup
    //   168: iconst_1
    //   169: iload_1
    //   170: invokestatic 244	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   173: aastore
    //   174: invokestatic 271	com/tencent/feedback/common/e:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   177: aload 5
    //   179: ifnull +16 -> 195
    //   182: aload 5
    //   184: invokevirtual 222	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   187: ifeq +8 -> 195
    //   190: aload 5
    //   192: invokevirtual 225	android/database/sqlite/SQLiteDatabase:close	()V
    //   195: aload 4
    //   197: invokevirtual 226	com/tencent/feedback/proguard/n:close	()V
    //   200: iload_1
    //   201: ireturn
    //   202: astore 5
    //   204: aconst_null
    //   205: astore 4
    //   207: aload_3
    //   208: astore_0
    //   209: aload 4
    //   211: astore_2
    //   212: aload 5
    //   214: invokevirtual 202	java/lang/Throwable:printStackTrace	()V
    //   217: aload_3
    //   218: astore_0
    //   219: aload 4
    //   221: astore_2
    //   222: ldc_w 897
    //   225: iconst_1
    //   226: anewarray 4	java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: aload 5
    //   233: invokevirtual 313	java/lang/Throwable:toString	()Ljava/lang/String;
    //   236: aastore
    //   237: invokestatic 101	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   240: aload_3
    //   241: ifnull +14 -> 255
    //   244: aload_3
    //   245: invokevirtual 222	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   248: ifeq +7 -> 255
    //   251: aload_3
    //   252: invokevirtual 225	android/database/sqlite/SQLiteDatabase:close	()V
    //   255: aload 4
    //   257: ifnull -233 -> 24
    //   260: aload 4
    //   262: invokevirtual 226	com/tencent/feedback/proguard/n:close	()V
    //   265: iconst_0
    //   266: ireturn
    //   267: astore_3
    //   268: aconst_null
    //   269: astore_2
    //   270: aload 5
    //   272: astore_0
    //   273: aload_0
    //   274: ifnull +14 -> 288
    //   277: aload_0
    //   278: invokevirtual 222	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   281: ifeq +7 -> 288
    //   284: aload_0
    //   285: invokevirtual 225	android/database/sqlite/SQLiteDatabase:close	()V
    //   288: aload_2
    //   289: ifnull +7 -> 296
    //   292: aload_2
    //   293: invokevirtual 226	com/tencent/feedback/proguard/n:close	()V
    //   296: aload_3
    //   297: athrow
    //   298: astore_3
    //   299: goto -26 -> 273
    //   302: astore 5
    //   304: goto -97 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	paramContext	Context
    //   0	307	1	paramInt	int
    //   4	289	2	localObject1	Object
    //   9	243	3	localObject2	Object
    //   267	30	3	localObject3	Object
    //   298	1	3	localObject4	Object
    //   34	227	4	localn	n
    //   1	190	5	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   202	69	5	localThrowable1	Throwable
    //   302	1	5	localThrowable2	Throwable
    //   6	36	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   26	36	202	java/lang/Throwable
    //   26	36	267	finally
    //   44	51	298	finally
    //   65	75	298	finally
    //   109	142	298	finally
    //   151	177	298	finally
    //   212	217	298	finally
    //   222	240	298	finally
    //   44	51	302	java/lang/Throwable
    //   65	75	302	java/lang/Throwable
    //   109	142	302	java/lang/Throwable
    //   151	177	302	java/lang/Throwable
  }
  
  public static int b(Context paramContext, String paramString)
  {
    int i = 0;
    if ((paramContext == null) || (paramString == null)) {}
    for (;;)
    {
      try
      {
        e.c("rqdp{  args error}", new Object[0]);
        return i;
      }
      finally {}
      i = l.a(paramContext, new int[] { 9 }, -1L, 9223372036854775807L, paramString);
    }
  }
  
  public static int b(Context paramContext, p[] paramArrayOfp)
  {
    int j = 0;
    int i;
    if (paramContext == null) {
      i = -1;
    }
    ArrayList localArrayList;
    do
    {
      return i;
      if (paramArrayOfp == null) {
        return l.a(paramContext, new int[] { 7 }, -1L, 9223372036854775807L);
      }
      localArrayList = new ArrayList();
      int k = paramArrayOfp.length;
      i = 0;
      while (i < k)
      {
        p localp = paramArrayOfp[i];
        if (localp.a() >= 0L) {
          localArrayList.add(Long.valueOf(localp.a()));
        }
        i += 1;
      }
      i = j;
    } while (localArrayList.size() <= 0);
    return l.a(paramContext, (Long[])localArrayList.toArray(new Long[0]));
  }
  
  public static int b(Context paramContext, q[] paramArrayOfq)
  {
    int j = 0;
    if ((paramContext != null) && (paramArrayOfq != null)) {}
    for (;;)
    {
      try
      {
        if (paramArrayOfq.length <= 0)
        {
          e.c("rqdp{  args error}", new Object[0]);
          i = j;
          return i;
        }
        ArrayList localArrayList = new ArrayList(paramArrayOfq.length);
        int k = paramArrayOfq.length;
        int i = 0;
        if (i < k)
        {
          q localq = paramArrayOfq[i];
          if (localq.d() >= 0L) {
            localArrayList.add(Long.valueOf(localq.d()));
          }
        }
        else
        {
          i = j;
          if (localArrayList.size() <= 0) {
            continue;
          }
          i = l.a(paramContext, (Long[])localArrayList.toArray(new Long[0]));
          continue;
        }
        i += 1;
      }
      finally {}
    }
  }
  
  public static long b()
  {
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
      long l = localSimpleDateFormat.parse(localSimpleDateFormat.format(new Date())).getTime();
      return l;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return -1L;
  }
  
  /* Error */
  public static Object b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc_w 925
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 97	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   10: aload_0
    //   11: ifnull +8 -> 19
    //   14: aload_0
    //   15: arraylength
    //   16: ifge +5 -> 21
    //   19: aconst_null
    //   20: areturn
    //   21: new 927	java/io/ByteArrayInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 929	java/io/ByteArrayInputStream:<init>	([B)V
    //   29: astore_3
    //   30: new 931	java/io/ObjectInputStream
    //   33: dup
    //   34: aload_3
    //   35: invokespecial 932	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   38: astore_1
    //   39: aload_1
    //   40: astore_0
    //   41: aload_1
    //   42: invokevirtual 935	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   45: astore_2
    //   46: aload_1
    //   47: invokevirtual 936	java/io/ObjectInputStream:close	()V
    //   50: aload_3
    //   51: invokevirtual 937	java/io/ByteArrayInputStream:close	()V
    //   54: aload_2
    //   55: areturn
    //   56: astore_0
    //   57: aload_0
    //   58: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   61: aload_2
    //   62: areturn
    //   63: astore_0
    //   64: aload_0
    //   65: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   68: goto -18 -> 50
    //   71: astore_2
    //   72: aconst_null
    //   73: astore_1
    //   74: aload_1
    //   75: astore_0
    //   76: aload_2
    //   77: invokevirtual 202	java/lang/Throwable:printStackTrace	()V
    //   80: aload_1
    //   81: astore_0
    //   82: aload_2
    //   83: invokevirtual 734	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokestatic 101	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: aload_1
    //   94: ifnull +7 -> 101
    //   97: aload_1
    //   98: invokevirtual 936	java/io/ObjectInputStream:close	()V
    //   101: aload_3
    //   102: invokevirtual 937	java/io/ByteArrayInputStream:close	()V
    //   105: aconst_null
    //   106: areturn
    //   107: astore_0
    //   108: aload_0
    //   109: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   112: aconst_null
    //   113: areturn
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   119: goto -18 -> 101
    //   122: astore_1
    //   123: aconst_null
    //   124: astore_0
    //   125: aload_0
    //   126: ifnull +7 -> 133
    //   129: aload_0
    //   130: invokevirtual 936	java/io/ObjectInputStream:close	()V
    //   133: aload_3
    //   134: invokevirtual 937	java/io/ByteArrayInputStream:close	()V
    //   137: aload_1
    //   138: athrow
    //   139: astore_0
    //   140: aload_0
    //   141: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   144: goto -11 -> 133
    //   147: astore_0
    //   148: aload_0
    //   149: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   152: goto -15 -> 137
    //   155: astore_1
    //   156: goto -31 -> 125
    //   159: astore_2
    //   160: goto -86 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	paramArrayOfByte	byte[]
    //   38	60	1	localObjectInputStream	java.io.ObjectInputStream
    //   122	16	1	localObject1	Object
    //   155	1	1	localObject2	Object
    //   45	17	2	localObject3	Object
    //   71	12	2	localThrowable1	Throwable
    //   159	1	2	localThrowable2	Throwable
    //   29	105	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   50	54	56	java/io/IOException
    //   46	50	63	java/io/IOException
    //   30	39	71	java/lang/Throwable
    //   101	105	107	java/io/IOException
    //   97	101	114	java/io/IOException
    //   30	39	122	finally
    //   129	133	139	java/io/IOException
    //   133	137	147	java/io/IOException
    //   41	46	155	finally
    //   76	80	155	finally
    //   82	93	155	finally
    //   41	46	159	java/lang/Throwable
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    e.b("rqdp{  unzp:} %s rqdp{  len:} %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) });
    try
    {
      N localN = M.a(paramInt);
      if (localN == null) {
        return null;
      }
      paramArrayOfByte = localN.b(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      e.d("rqdp{  err unzp}" + paramArrayOfByte.toString(), new Object[0]);
    }
    return null;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      paramArrayOfByte = b(b(paramArrayOfByte, paramInt2, paramString), paramInt1);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    if (paramInt == 1) {}
    Object localObject;
    try
    {
      localObject = new R();
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      e.d("rqdp{  err unD:} %s", new Object[] { paramArrayOfByte.toString() });
      return null;
    }
    if (paramInt == 3) {
      localObject = new Q();
    } else {
      localObject = null;
    }
    while (localObject != null)
    {
      ((S)localObject).a(paramString);
      paramArrayOfByte = ((S)localObject).a(paramArrayOfByte);
      return paramArrayOfByte;
    }
    return null;
  }
  
  public static String c()
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
      return str;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return "";
  }
  
  public static String d()
  {
    try
    {
      String str = UUID.randomUUID().toString();
      return str;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public <T> void a(String paramString, T paramT)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("put key can not is null");
    }
    if (paramT == null) {
      throw new IllegalArgumentException("put value can not is null");
    }
    if ((paramT instanceof Set)) {
      throw new IllegalArgumentException("can not support Set");
    }
    Object localObject = new i();
    ((i)localObject).a(this.b);
    ((i)localObject).a(paramT, 0);
    localObject = k.a(((i)localObject).a());
    HashMap localHashMap = new HashMap(1);
    ArrayList localArrayList = new ArrayList(1);
    a(localArrayList, paramT);
    localHashMap.put(a(localArrayList), localObject);
    this.d.remove(paramString);
    this.a.put(paramString, localHashMap);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.c.a(paramArrayOfByte);
    this.c.a(this.b);
    paramArrayOfByte = new HashMap(1);
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("", new byte[0]);
    paramArrayOfByte.put("", localHashMap);
    this.a = this.c.a(paramArrayOfByte, 0, false);
  }
  
  public byte[] a()
  {
    i locali = new i(0);
    locali.a(this.b);
    locali.a(this.a, 0);
    return k.a(locali.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.a
 * JD-Core Version:    0.7.0.1
 */