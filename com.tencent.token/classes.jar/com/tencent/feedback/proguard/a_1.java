package com.tencent.feedback.proguard;

import android.content.Context;
import com.tencent.feedback.common.e;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
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
  public static N a(int paramInt, com.tencent.feedback.common.c paramc, byte[] paramArrayOfByte, byte paramByte1, byte paramByte2, String paramString)
  {
    // Byte code:
    //   0: ldc 93
    //   2: iconst_0
    //   3: anewarray 4	java/lang/Object
    //   6: invokestatic 95	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   9: pop
    //   10: aload_1
    //   11: ifnonnull +15 -> 26
    //   14: ldc 97
    //   16: iconst_0
    //   17: anewarray 4	java/lang/Object
    //   20: invokestatic 99	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   23: pop
    //   24: aconst_null
    //   25: areturn
    //   26: new 101	com/tencent/feedback/proguard/N
    //   29: dup
    //   30: invokespecial 102	com/tencent/feedback/proguard/N:<init>	()V
    //   33: astore 7
    //   35: aload_1
    //   36: monitorenter
    //   37: aload 7
    //   39: aload_1
    //   40: invokevirtual 107	com/tencent/feedback/common/c:a	()B
    //   43: putfield 110	com/tencent/feedback/proguard/N:a	I
    //   46: aload 7
    //   48: aload_1
    //   49: invokevirtual 113	com/tencent/feedback/common/c:n	()Ljava/lang/String;
    //   52: putfield 114	com/tencent/feedback/proguard/N:b	Ljava/lang/String;
    //   55: aload 7
    //   57: aload_1
    //   58: invokevirtual 116	com/tencent/feedback/common/c:b	()Ljava/lang/String;
    //   61: putfield 118	com/tencent/feedback/proguard/N:c	Ljava/lang/String;
    //   64: aload 7
    //   66: aload_1
    //   67: invokevirtual 121	com/tencent/feedback/common/c:B	()Ljava/lang/String;
    //   70: putfield 123	com/tencent/feedback/proguard/N:d	Ljava/lang/String;
    //   73: aload 7
    //   75: ldc 125
    //   77: putfield 128	com/tencent/feedback/proguard/N:e	Ljava/lang/String;
    //   80: aload 7
    //   82: aload_1
    //   83: invokevirtual 129	com/tencent/feedback/common/c:c	()Ljava/lang/String;
    //   86: putfield 132	com/tencent/feedback/proguard/N:f	Ljava/lang/String;
    //   89: aload 7
    //   91: iload_0
    //   92: putfield 135	com/tencent/feedback/proguard/N:g	I
    //   95: aload_2
    //   96: ifnonnull +93 -> 189
    //   99: ldc 125
    //   101: invokevirtual 141	java/lang/String:getBytes	()[B
    //   104: astore 6
    //   106: aload 7
    //   108: aload 6
    //   110: putfield 145	com/tencent/feedback/proguard/N:h	[B
    //   113: aload 7
    //   115: aload_1
    //   116: invokevirtual 147	com/tencent/feedback/common/c:e	()Ljava/lang/String;
    //   119: putfield 150	com/tencent/feedback/proguard/N:i	Ljava/lang/String;
    //   122: aload 7
    //   124: aload_1
    //   125: invokevirtual 152	com/tencent/feedback/common/c:f	()Ljava/lang/String;
    //   128: putfield 155	com/tencent/feedback/proguard/N:j	Ljava/lang/String;
    //   131: aload_1
    //   132: monitorexit
    //   133: aload_2
    //   134: ifnull +66 -> 200
    //   137: aload 7
    //   139: aload 7
    //   141: getfield 145	com/tencent/feedback/proguard/N:h	[B
    //   144: iload_3
    //   145: iload 4
    //   147: aload 5
    //   149: invokestatic 158	com/tencent/feedback/proguard/a:a	([BIILjava/lang/String;)[B
    //   152: putfield 145	com/tencent/feedback/proguard/N:h	[B
    //   155: aload 7
    //   157: getfield 145	com/tencent/feedback/proguard/N:h	[B
    //   160: ifnonnull +40 -> 200
    //   163: ldc 160
    //   165: iconst_0
    //   166: anewarray 4	java/lang/Object
    //   169: invokestatic 99	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   172: pop
    //   173: aconst_null
    //   174: areturn
    //   175: astore_1
    //   176: aload_1
    //   177: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   180: ifne -156 -> 24
    //   183: aload_1
    //   184: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
    //   187: aconst_null
    //   188: areturn
    //   189: aload_2
    //   190: astore 6
    //   192: goto -86 -> 106
    //   195: astore_2
    //   196: aload_1
    //   197: monitorexit
    //   198: aload_2
    //   199: athrow
    //   200: aload 7
    //   202: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	paramInt	int
    //   0	203	1	paramc	com.tencent.feedback.common.c
    //   0	203	2	paramArrayOfByte	byte[]
    //   0	203	3	paramByte1	byte
    //   0	203	4	paramByte2	byte
    //   0	203	5	paramString	String
    //   104	87	6	arrayOfByte	byte[]
    //   33	168	7	localN	N
    // Exception table:
    //   from	to	target	type
    //   26	37	175	java/lang/Throwable
    //   137	173	175	java/lang/Throwable
    //   196	200	175	java/lang/Throwable
    //   37	95	195	finally
    //   99	106	195	finally
    //   106	133	195	finally
  }
  
  /* Error */
  public static z a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnonnull +15 -> 19
    //   7: ldc 169
    //   9: iconst_0
    //   10: anewarray 4	java/lang/Object
    //   13: invokestatic 75	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   16: pop
    //   17: aconst_null
    //   18: areturn
    //   19: new 171	com/tencent/feedback/proguard/n
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 174	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   27: astore_3
    //   28: aload_3
    //   29: invokevirtual 178	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   32: astore_0
    //   33: aload_0
    //   34: ifnonnull +34 -> 68
    //   37: ldc 180
    //   39: iconst_0
    //   40: anewarray 4	java/lang/Object
    //   43: invokestatic 75	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   46: pop
    //   47: aload_0
    //   48: ifnull +14 -> 62
    //   51: aload_0
    //   52: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   55: ifeq +7 -> 62
    //   58: aload_0
    //   59: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   62: aload_3
    //   63: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   66: aconst_null
    //   67: areturn
    //   68: aload_0
    //   69: ldc 192
    //   71: aconst_null
    //   72: getstatic 198	java/util/Locale:US	Ljava/util/Locale;
    //   75: ldc 200
    //   77: iconst_2
    //   78: anewarray 4	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: ldc 202
    //   85: aastore
    //   86: dup
    //   87: iconst_1
    //   88: iload_1
    //   89: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   92: aastore
    //   93: invokestatic 212	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   96: aconst_null
    //   97: aconst_null
    //   98: aconst_null
    //   99: aconst_null
    //   100: invokevirtual 216	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   103: astore_2
    //   104: aload_2
    //   105: ifnull +290 -> 395
    //   108: aload_2
    //   109: invokeinterface 221 1 0
    //   114: ifeq +281 -> 395
    //   117: aload_2
    //   118: ifnull +442 -> 560
    //   121: aload_2
    //   122: invokeinterface 224 1 0
    //   127: ifne +433 -> 560
    //   130: aload_2
    //   131: invokeinterface 227 1 0
    //   136: ifeq +73 -> 209
    //   139: goto +421 -> 560
    //   142: aload 4
    //   144: ifnull +251 -> 395
    //   147: ldc 229
    //   149: iconst_1
    //   150: anewarray 4	java/lang/Object
    //   153: dup
    //   154: iconst_0
    //   155: aload 4
    //   157: invokevirtual 233	com/tencent/feedback/proguard/z:b	()I
    //   160: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   163: aastore
    //   164: invokestatic 95	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   167: pop
    //   168: aload_2
    //   169: ifnull +18 -> 187
    //   172: aload_2
    //   173: invokeinterface 236 1 0
    //   178: ifne +9 -> 187
    //   181: aload_2
    //   182: invokeinterface 237 1 0
    //   187: aload_0
    //   188: ifnull +14 -> 202
    //   191: aload_0
    //   192: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   195: ifeq +7 -> 202
    //   198: aload_0
    //   199: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   202: aload_3
    //   203: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   206: aload 4
    //   208: areturn
    //   209: ldc 239
    //   211: iconst_0
    //   212: anewarray 4	java/lang/Object
    //   215: invokestatic 95	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   218: pop
    //   219: new 231	com/tencent/feedback/proguard/z
    //   222: dup
    //   223: invokespecial 240	com/tencent/feedback/proguard/z:<init>	()V
    //   226: astore 4
    //   228: aload 4
    //   230: aload_2
    //   231: aload_2
    //   232: ldc 242
    //   234: invokeinterface 246 2 0
    //   239: invokeinterface 250 2 0
    //   244: invokevirtual 253	com/tencent/feedback/proguard/z:a	(J)V
    //   247: aload 4
    //   249: aload_2
    //   250: aload_2
    //   251: ldc 202
    //   253: invokeinterface 246 2 0
    //   258: invokeinterface 257 2 0
    //   263: invokevirtual 259	com/tencent/feedback/proguard/z:a	(I)V
    //   266: aload 4
    //   268: aload_2
    //   269: aload_2
    //   270: ldc_w 261
    //   273: invokeinterface 246 2 0
    //   278: invokeinterface 250 2 0
    //   283: invokevirtual 263	com/tencent/feedback/proguard/z:b	(J)V
    //   286: aload 4
    //   288: aload_2
    //   289: aload_2
    //   290: ldc_w 265
    //   293: invokeinterface 246 2 0
    //   298: invokeinterface 269 2 0
    //   303: invokevirtual 272	com/tencent/feedback/proguard/z:a	([B)V
    //   306: goto -164 -> 142
    //   309: astore 4
    //   311: aload_2
    //   312: astore 5
    //   314: aload_0
    //   315: astore_2
    //   316: aload 5
    //   318: astore_0
    //   319: aload 4
    //   321: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   324: ifne +8 -> 332
    //   327: aload 4
    //   329: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
    //   332: ldc_w 274
    //   335: iconst_1
    //   336: anewarray 4	java/lang/Object
    //   339: dup
    //   340: iconst_0
    //   341: aload 4
    //   343: invokevirtual 277	java/lang/Throwable:toString	()Ljava/lang/String;
    //   346: aastore
    //   347: invokestatic 99	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   350: pop
    //   351: aload_0
    //   352: ifnull +18 -> 370
    //   355: aload_0
    //   356: invokeinterface 236 1 0
    //   361: ifne +9 -> 370
    //   364: aload_0
    //   365: invokeinterface 237 1 0
    //   370: aload_2
    //   371: ifnull +14 -> 385
    //   374: aload_2
    //   375: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   378: ifeq +7 -> 385
    //   381: aload_2
    //   382: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   385: aload_3
    //   386: ifnull +7 -> 393
    //   389: aload_3
    //   390: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   393: aconst_null
    //   394: areturn
    //   395: aload_2
    //   396: ifnull +18 -> 414
    //   399: aload_2
    //   400: invokeinterface 236 1 0
    //   405: ifne +9 -> 414
    //   408: aload_2
    //   409: invokeinterface 237 1 0
    //   414: aload_0
    //   415: ifnull +14 -> 429
    //   418: aload_0
    //   419: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   422: ifeq +7 -> 429
    //   425: aload_0
    //   426: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   429: aload_3
    //   430: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   433: goto -40 -> 393
    //   436: astore_0
    //   437: aconst_null
    //   438: astore_2
    //   439: aconst_null
    //   440: astore_3
    //   441: aload_2
    //   442: ifnull +18 -> 460
    //   445: aload_2
    //   446: invokeinterface 236 1 0
    //   451: ifne +9 -> 460
    //   454: aload_2
    //   455: invokeinterface 237 1 0
    //   460: aload 4
    //   462: ifnull +16 -> 478
    //   465: aload 4
    //   467: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   470: ifeq +8 -> 478
    //   473: aload 4
    //   475: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   478: aload_3
    //   479: ifnull +7 -> 486
    //   482: aload_3
    //   483: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   486: aload_0
    //   487: athrow
    //   488: astore_0
    //   489: aconst_null
    //   490: astore_2
    //   491: goto -50 -> 441
    //   494: astore 5
    //   496: aconst_null
    //   497: astore_2
    //   498: aload_0
    //   499: astore 4
    //   501: aload 5
    //   503: astore_0
    //   504: goto -63 -> 441
    //   507: astore 5
    //   509: aload_0
    //   510: astore 4
    //   512: aload 5
    //   514: astore_0
    //   515: goto -74 -> 441
    //   518: astore 5
    //   520: aload_2
    //   521: astore 4
    //   523: aload_0
    //   524: astore_2
    //   525: aload 5
    //   527: astore_0
    //   528: goto -87 -> 441
    //   531: astore 4
    //   533: aconst_null
    //   534: astore_0
    //   535: aconst_null
    //   536: astore_2
    //   537: aconst_null
    //   538: astore_3
    //   539: goto -220 -> 319
    //   542: astore 4
    //   544: aconst_null
    //   545: astore_0
    //   546: aconst_null
    //   547: astore_2
    //   548: goto -229 -> 319
    //   551: astore 4
    //   553: aload_0
    //   554: astore_2
    //   555: aconst_null
    //   556: astore_0
    //   557: goto -238 -> 319
    //   560: aconst_null
    //   561: astore 4
    //   563: goto -421 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	566	0	paramContext	Context
    //   0	566	1	paramInt	int
    //   103	452	2	localObject1	Object
    //   27	512	3	localn	n
    //   1	286	4	localz	z
    //   309	165	4	localThrowable1	Throwable
    //   499	23	4	localObject2	Object
    //   531	1	4	localThrowable2	Throwable
    //   542	1	4	localThrowable3	Throwable
    //   551	1	4	localThrowable4	Throwable
    //   561	1	4	localObject3	Object
    //   312	5	5	localObject4	Object
    //   494	8	5	localObject5	Object
    //   507	6	5	localObject6	Object
    //   518	8	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   108	117	309	java/lang/Throwable
    //   121	139	309	java/lang/Throwable
    //   147	168	309	java/lang/Throwable
    //   209	306	309	java/lang/Throwable
    //   19	28	436	finally
    //   28	33	488	finally
    //   37	47	494	finally
    //   68	104	494	finally
    //   108	117	507	finally
    //   121	139	507	finally
    //   147	168	507	finally
    //   209	306	507	finally
    //   319	332	518	finally
    //   332	351	518	finally
    //   19	28	531	java/lang/Throwable
    //   28	33	542	java/lang/Throwable
    //   37	47	551	java/lang/Throwable
    //   68	104	551	java/lang/Throwable
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.trim().equals(""))) {
      return "";
    }
    paramContext = a(paramContext, new String[] { "/system/bin/sh", "-c", "getprop " + paramString });
    if ((paramContext != null) && (paramContext.size() > 0)) {
      return (String)paramContext.get(0);
    }
    return "fail";
  }
  
  public static String a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    try
    {
      StringWriter localStringWriter = new StringWriter();
      paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
      paramThrowable = localStringWriter.getBuffer().toString();
      return paramThrowable;
    }
    catch (Throwable paramThrowable)
    {
      if ((!e.a(paramThrowable)) && (!e.a(paramThrowable))) {
        paramThrowable.printStackTrace();
      }
    }
    return "fail";
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
  
  /* Error */
  public static ArrayList<String> a(Context paramContext, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 37	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 429	java/util/ArrayList:<init>	()V
    //   9: astore 4
    //   11: aload_0
    //   12: invokestatic 432	com/tencent/feedback/common/c:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/c;
    //   15: invokevirtual 435	com/tencent/feedback/common/c:N	()Z
    //   18: ifeq +28 -> 46
    //   21: new 37	java/util/ArrayList
    //   24: dup
    //   25: invokespecial 429	java/util/ArrayList:<init>	()V
    //   28: astore_0
    //   29: aload_0
    //   30: new 137	java/lang/String
    //   33: dup
    //   34: ldc_w 437
    //   37: invokespecial 438	java/lang/String:<init>	(Ljava/lang/String;)V
    //   40: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   43: pop
    //   44: aload_0
    //   45: areturn
    //   46: invokestatic 444	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   49: aload_1
    //   50: invokevirtual 448	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   53: astore_0
    //   54: new 450	java/io/BufferedReader
    //   57: dup
    //   58: new 452	java/io/InputStreamReader
    //   61: dup
    //   62: aload_0
    //   63: invokevirtual 458	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   66: invokespecial 461	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   69: invokespecial 464	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   72: astore_1
    //   73: aload_1
    //   74: invokevirtual 467	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   77: astore_2
    //   78: aload_2
    //   79: ifnull +56 -> 135
    //   82: aload 4
    //   84: aload_2
    //   85: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   88: pop
    //   89: goto -16 -> 73
    //   92: astore 4
    //   94: aconst_null
    //   95: astore_0
    //   96: aload_0
    //   97: astore_3
    //   98: aload_1
    //   99: astore_2
    //   100: aload 4
    //   102: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   105: ifne +12 -> 117
    //   108: aload_0
    //   109: astore_3
    //   110: aload_1
    //   111: astore_2
    //   112: aload 4
    //   114: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
    //   117: aload_1
    //   118: ifnull +7 -> 125
    //   121: aload_1
    //   122: invokevirtual 468	java/io/BufferedReader:close	()V
    //   125: aload_0
    //   126: ifnull +7 -> 133
    //   129: aload_0
    //   130: invokevirtual 468	java/io/BufferedReader:close	()V
    //   133: aconst_null
    //   134: areturn
    //   135: new 450	java/io/BufferedReader
    //   138: dup
    //   139: new 452	java/io/InputStreamReader
    //   142: dup
    //   143: aload_0
    //   144: invokevirtual 471	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   147: invokespecial 461	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   150: invokespecial 464	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   153: astore_0
    //   154: aload_0
    //   155: astore_3
    //   156: aload_1
    //   157: astore_2
    //   158: aload_0
    //   159: invokevirtual 467	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   162: astore 5
    //   164: aload 5
    //   166: ifnull +23 -> 189
    //   169: aload_0
    //   170: astore_3
    //   171: aload_1
    //   172: astore_2
    //   173: aload 4
    //   175: aload 5
    //   177: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   180: pop
    //   181: goto -27 -> 154
    //   184: astore 4
    //   186: goto -90 -> 96
    //   189: aload_1
    //   190: invokevirtual 468	java/io/BufferedReader:close	()V
    //   193: aload_0
    //   194: invokevirtual 468	java/io/BufferedReader:close	()V
    //   197: aload 4
    //   199: areturn
    //   200: astore_1
    //   201: aload 4
    //   203: astore_0
    //   204: aload_1
    //   205: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   208: ifne -164 -> 44
    //   211: aload_1
    //   212: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   215: aload 4
    //   217: areturn
    //   218: astore_1
    //   219: aload_1
    //   220: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   223: ifne -30 -> 193
    //   226: aload_1
    //   227: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   230: goto -37 -> 193
    //   233: astore_1
    //   234: aload_1
    //   235: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   238: ifne -113 -> 125
    //   241: aload_1
    //   242: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   245: goto -120 -> 125
    //   248: astore_0
    //   249: aload_0
    //   250: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   253: ifne -120 -> 133
    //   256: aload_0
    //   257: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   260: goto -127 -> 133
    //   263: astore_0
    //   264: aconst_null
    //   265: astore_1
    //   266: aload_1
    //   267: ifnull +7 -> 274
    //   270: aload_1
    //   271: invokevirtual 468	java/io/BufferedReader:close	()V
    //   274: aload_3
    //   275: ifnull +7 -> 282
    //   278: aload_3
    //   279: invokevirtual 468	java/io/BufferedReader:close	()V
    //   282: aload_0
    //   283: athrow
    //   284: astore_1
    //   285: aload_1
    //   286: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   289: ifne -15 -> 274
    //   292: aload_1
    //   293: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   296: goto -22 -> 274
    //   299: astore_1
    //   300: aload_1
    //   301: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   304: ifne -22 -> 282
    //   307: aload_1
    //   308: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   311: goto -29 -> 282
    //   314: astore_0
    //   315: goto -49 -> 266
    //   318: astore_0
    //   319: aload_2
    //   320: astore_1
    //   321: goto -55 -> 266
    //   324: astore 4
    //   326: aconst_null
    //   327: astore_0
    //   328: aconst_null
    //   329: astore_1
    //   330: goto -234 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	paramContext	Context
    //   0	333	1	paramArrayOfString	String[]
    //   77	243	2	localObject	Object
    //   1	278	3	localContext	Context
    //   9	74	4	localArrayList	ArrayList
    //   92	82	4	localThrowable1	Throwable
    //   184	32	4	localThrowable2	Throwable
    //   324	1	4	localThrowable3	Throwable
    //   162	14	5	str	String
    // Exception table:
    //   from	to	target	type
    //   73	78	92	java/lang/Throwable
    //   82	89	92	java/lang/Throwable
    //   135	154	92	java/lang/Throwable
    //   158	164	184	java/lang/Throwable
    //   173	181	184	java/lang/Throwable
    //   193	197	200	java/io/IOException
    //   189	193	218	java/io/IOException
    //   121	125	233	java/io/IOException
    //   129	133	248	java/io/IOException
    //   46	73	263	finally
    //   270	274	284	java/io/IOException
    //   278	282	299	java/io/IOException
    //   73	78	314	finally
    //   82	89	314	finally
    //   135	154	314	finally
    //   100	108	318	finally
    //   112	117	318	finally
    //   158	164	318	finally
    //   173	181	318	finally
    //   46	73	324	java/lang/Throwable
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
        if (!e.a(localThrowable)) {
          localThrowable.printStackTrace();
        }
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
    //   0: ldc_w 512
    //   3: iconst_1
    //   4: anewarray 4	java/lang/Object
    //   7: dup
    //   8: iconst_0
    //   9: aload_0
    //   10: aastore
    //   11: invokestatic 95	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   14: pop
    //   15: aload_1
    //   16: ifnull +13 -> 29
    //   19: aload_1
    //   20: invokevirtual 281	java/lang/String:trim	()Ljava/lang/String;
    //   23: invokevirtual 515	java/lang/String:length	()I
    //   26: ifgt +4 -> 30
    //   29: return
    //   30: new 517	java/io/File
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 518	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore 6
    //   40: aload 6
    //   42: invokevirtual 521	java/io/File:exists	()Z
    //   45: ifne +26 -> 71
    //   48: aload 6
    //   50: invokevirtual 525	java/io/File:getParentFile	()Ljava/io/File;
    //   53: ifnull +12 -> 65
    //   56: aload 6
    //   58: invokevirtual 525	java/io/File:getParentFile	()Ljava/io/File;
    //   61: invokevirtual 528	java/io/File:mkdirs	()Z
    //   64: pop
    //   65: aload 6
    //   67: invokevirtual 531	java/io/File:createNewFile	()Z
    //   70: pop
    //   71: aconst_null
    //   72: astore 5
    //   74: aconst_null
    //   75: astore_0
    //   76: aload_0
    //   77: astore 4
    //   79: aload 5
    //   81: astore_3
    //   82: aload 6
    //   84: invokevirtual 533	java/io/File:length	()J
    //   87: iload_2
    //   88: i2l
    //   89: lcmp
    //   90: iflt +61 -> 151
    //   93: aload_0
    //   94: astore 4
    //   96: aload 5
    //   98: astore_3
    //   99: new 535	java/io/FileOutputStream
    //   102: dup
    //   103: aload 6
    //   105: iconst_0
    //   106: invokespecial 538	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   109: astore_0
    //   110: aload_0
    //   111: astore 4
    //   113: aload_0
    //   114: astore_3
    //   115: aload_0
    //   116: aload_1
    //   117: ldc_w 540
    //   120: invokevirtual 543	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   123: invokevirtual 546	java/io/FileOutputStream:write	([B)V
    //   126: aload_0
    //   127: astore 4
    //   129: aload_0
    //   130: astore_3
    //   131: aload_0
    //   132: invokevirtual 549	java/io/FileOutputStream:flush	()V
    //   135: aload_0
    //   136: invokevirtual 550	java/io/FileOutputStream:close	()V
    //   139: ldc_w 552
    //   142: iconst_0
    //   143: anewarray 4	java/lang/Object
    //   146: invokestatic 95	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   149: pop
    //   150: return
    //   151: aload_0
    //   152: astore 4
    //   154: aload 5
    //   156: astore_3
    //   157: new 535	java/io/FileOutputStream
    //   160: dup
    //   161: aload 6
    //   163: iconst_1
    //   164: invokespecial 538	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   167: astore_0
    //   168: goto -58 -> 110
    //   171: astore_0
    //   172: aload 4
    //   174: astore_3
    //   175: aload_0
    //   176: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   179: ifne +10 -> 189
    //   182: aload 4
    //   184: astore_3
    //   185: aload_0
    //   186: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
    //   189: aload 4
    //   191: astore_3
    //   192: ldc_w 554
    //   195: iconst_0
    //   196: anewarray 4	java/lang/Object
    //   199: invokestatic 99	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   202: pop
    //   203: aload 4
    //   205: ifnull -66 -> 139
    //   208: aload 4
    //   210: invokevirtual 550	java/io/FileOutputStream:close	()V
    //   213: goto -74 -> 139
    //   216: astore_0
    //   217: aload_0
    //   218: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   221: ifne -82 -> 139
    //   224: aload_0
    //   225: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
    //   228: goto -89 -> 139
    //   231: astore_0
    //   232: aload_3
    //   233: ifnull +7 -> 240
    //   236: aload_3
    //   237: invokevirtual 550	java/io/FileOutputStream:close	()V
    //   240: aload_0
    //   241: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	paramString1	String
    //   0	242	1	paramString2	String
    //   0	242	2	paramInt	int
    //   81	156	3	localObject1	Object
    //   77	132	4	str	String
    //   72	83	5	localObject2	Object
    //   38	124	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   82	93	171	java/lang/Throwable
    //   99	110	171	java/lang/Throwable
    //   115	126	171	java/lang/Throwable
    //   131	135	171	java/lang/Throwable
    //   157	168	171	java/lang/Throwable
    //   40	65	216	java/lang/Throwable
    //   65	71	216	java/lang/Throwable
    //   135	139	216	java/lang/Throwable
    //   208	213	216	java/lang/Throwable
    //   236	240	216	java/lang/Throwable
    //   240	242	216	java/lang/Throwable
    //   82	93	231	finally
    //   99	110	231	finally
    //   115	126	231	finally
    //   131	135	231	finally
    //   157	168	231	finally
    //   175	182	231	finally
    //   185	189	231	finally
    //   192	203	231	finally
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
    //   11: ifnonnull +16 -> 27
    //   14: ldc_w 601
    //   17: iconst_0
    //   18: anewarray 4	java/lang/Object
    //   21: invokestatic 75	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   24: pop
    //   25: iconst_0
    //   26: ireturn
    //   27: new 171	com/tencent/feedback/proguard/n
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 174	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   35: astore 4
    //   37: aload 4
    //   39: invokevirtual 178	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   42: astore_0
    //   43: aload_0
    //   44: ifnonnull +36 -> 80
    //   47: ldc_w 603
    //   50: iconst_0
    //   51: anewarray 4	java/lang/Object
    //   54: invokestatic 99	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   57: pop
    //   58: aload_0
    //   59: ifnull +14 -> 73
    //   62: aload_0
    //   63: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   66: ifeq +7 -> 73
    //   69: aload_0
    //   70: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   73: aload 4
    //   75: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   78: iconst_0
    //   79: ireturn
    //   80: aload_1
    //   81: ifnonnull +62 -> 143
    //   84: aload 6
    //   86: astore 5
    //   88: aload 5
    //   90: ifnull +243 -> 333
    //   93: aload_0
    //   94: ldc 192
    //   96: ldc 242
    //   98: aload 5
    //   100: invokevirtual 607	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   103: lstore_2
    //   104: lload_2
    //   105: lconst_0
    //   106: lcmp
    //   107: ifge +178 -> 285
    //   110: ldc_w 609
    //   113: iconst_0
    //   114: anewarray 4	java/lang/Object
    //   117: invokestatic 75	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   120: pop
    //   121: aload_0
    //   122: ifnull +14 -> 136
    //   125: aload_0
    //   126: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   129: ifeq +7 -> 136
    //   132: aload_0
    //   133: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   136: aload 4
    //   138: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   141: iconst_0
    //   142: ireturn
    //   143: new 611	android/content/ContentValues
    //   146: dup
    //   147: invokespecial 612	android/content/ContentValues:<init>	()V
    //   150: astore 5
    //   152: aload_1
    //   153: invokevirtual 613	com/tencent/feedback/proguard/z:a	()J
    //   156: lconst_0
    //   157: lcmp
    //   158: iflt +17 -> 175
    //   161: aload 5
    //   163: ldc 242
    //   165: aload_1
    //   166: invokevirtual 613	com/tencent/feedback/proguard/z:a	()J
    //   169: invokestatic 618	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   172: invokevirtual 622	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   175: aload 5
    //   177: ldc 202
    //   179: aload_1
    //   180: invokevirtual 233	com/tencent/feedback/proguard/z:b	()I
    //   183: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   186: invokevirtual 625	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   189: aload 5
    //   191: ldc_w 265
    //   194: aload_1
    //   195: invokevirtual 627	com/tencent/feedback/proguard/z:c	()[B
    //   198: invokevirtual 630	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   201: aload 5
    //   203: ldc_w 261
    //   206: aload_1
    //   207: invokevirtual 632	com/tencent/feedback/proguard/z:d	()J
    //   210: invokestatic 618	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   213: invokevirtual 622	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   216: goto -128 -> 88
    //   219: astore 5
    //   221: aload 4
    //   223: astore_1
    //   224: aload 5
    //   226: astore 4
    //   228: ldc_w 634
    //   231: iconst_1
    //   232: anewarray 4	java/lang/Object
    //   235: dup
    //   236: iconst_0
    //   237: aload 4
    //   239: invokevirtual 277	java/lang/Throwable:toString	()Ljava/lang/String;
    //   242: aastore
    //   243: invokestatic 99	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   246: pop
    //   247: aload 4
    //   249: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   252: ifne +8 -> 260
    //   255: aload 4
    //   257: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
    //   260: aload_0
    //   261: ifnull +14 -> 275
    //   264: aload_0
    //   265: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   268: ifeq +7 -> 275
    //   271: aload_0
    //   272: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   275: aload_1
    //   276: ifnull -251 -> 25
    //   279: aload_1
    //   280: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   283: iconst_0
    //   284: ireturn
    //   285: aload_1
    //   286: lload_2
    //   287: invokevirtual 253	com/tencent/feedback/proguard/z:a	(J)V
    //   290: ldc_w 636
    //   293: iconst_1
    //   294: anewarray 4	java/lang/Object
    //   297: dup
    //   298: iconst_0
    //   299: aload_1
    //   300: invokevirtual 233	com/tencent/feedback/proguard/z:b	()I
    //   303: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   306: aastore
    //   307: invokestatic 95	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   310: pop
    //   311: aload_0
    //   312: ifnull +14 -> 326
    //   315: aload_0
    //   316: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   319: ifeq +7 -> 326
    //   322: aload_0
    //   323: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   326: aload 4
    //   328: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   331: iconst_1
    //   332: ireturn
    //   333: aload_0
    //   334: ifnull +14 -> 348
    //   337: aload_0
    //   338: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   341: ifeq +7 -> 348
    //   344: aload_0
    //   345: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   348: aload 4
    //   350: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   353: iconst_0
    //   354: ireturn
    //   355: astore_1
    //   356: aconst_null
    //   357: astore_0
    //   358: aconst_null
    //   359: astore 4
    //   361: aload_0
    //   362: ifnull +14 -> 376
    //   365: aload_0
    //   366: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   369: ifeq +7 -> 376
    //   372: aload_0
    //   373: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   376: aload 4
    //   378: ifnull +8 -> 386
    //   381: aload 4
    //   383: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   386: aload_1
    //   387: athrow
    //   388: astore_1
    //   389: aconst_null
    //   390: astore_0
    //   391: goto -30 -> 361
    //   394: astore_1
    //   395: goto -34 -> 361
    //   398: astore 5
    //   400: aload_1
    //   401: astore 4
    //   403: aload 5
    //   405: astore_1
    //   406: goto -45 -> 361
    //   409: astore 4
    //   411: aconst_null
    //   412: astore_0
    //   413: aload 5
    //   415: astore_1
    //   416: goto -188 -> 228
    //   419: astore 5
    //   421: aconst_null
    //   422: astore_0
    //   423: aload 4
    //   425: astore_1
    //   426: aload 5
    //   428: astore 4
    //   430: goto -202 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	433	0	paramContext	Context
    //   0	433	1	paramz	z
    //   103	184	2	l	long
    //   35	367	4	localObject1	Object
    //   409	15	4	localThrowable1	Throwable
    //   428	1	4	localThrowable2	Throwable
    //   1	201	5	localObject2	Object
    //   219	6	5	localThrowable3	Throwable
    //   398	16	5	localObject3	Object
    //   419	8	5	localThrowable4	Throwable
    //   4	81	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   47	58	219	java/lang/Throwable
    //   93	104	219	java/lang/Throwable
    //   110	121	219	java/lang/Throwable
    //   143	175	219	java/lang/Throwable
    //   175	216	219	java/lang/Throwable
    //   285	311	219	java/lang/Throwable
    //   27	37	355	finally
    //   37	43	388	finally
    //   47	58	394	finally
    //   93	104	394	finally
    //   110	121	394	finally
    //   143	175	394	finally
    //   175	216	394	finally
    //   285	311	394	finally
    //   228	260	398	finally
    //   27	37	409	java/lang/Throwable
    //   37	43	419	java/lang/Throwable
  }
  
  /* Error */
  public static boolean a(java.io.File paramFile1, java.io.File paramFile2, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc_w 639
    //   6: iconst_0
    //   7: anewarray 4	java/lang/Object
    //   10: invokestatic 95	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   13: pop
    //   14: aload_0
    //   15: ifnull +15 -> 30
    //   18: aload_1
    //   19: ifnull +11 -> 30
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 640	java/io/File:equals	(Ljava/lang/Object;)Z
    //   27: ifeq +16 -> 43
    //   30: ldc_w 642
    //   33: iconst_0
    //   34: anewarray 4	java/lang/Object
    //   37: invokestatic 75	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   40: pop
    //   41: iconst_0
    //   42: ireturn
    //   43: aload_0
    //   44: invokevirtual 521	java/io/File:exists	()Z
    //   47: ifeq +10 -> 57
    //   50: aload_0
    //   51: invokevirtual 645	java/io/File:canRead	()Z
    //   54: ifne +16 -> 70
    //   57: ldc_w 647
    //   60: iconst_0
    //   61: anewarray 4	java/lang/Object
    //   64: invokestatic 75	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   67: pop
    //   68: iconst_0
    //   69: ireturn
    //   70: aload_1
    //   71: invokevirtual 525	java/io/File:getParentFile	()Ljava/io/File;
    //   74: ifnull +21 -> 95
    //   77: aload_1
    //   78: invokevirtual 525	java/io/File:getParentFile	()Ljava/io/File;
    //   81: invokevirtual 521	java/io/File:exists	()Z
    //   84: ifne +11 -> 95
    //   87: aload_1
    //   88: invokevirtual 525	java/io/File:getParentFile	()Ljava/io/File;
    //   91: invokevirtual 528	java/io/File:mkdirs	()Z
    //   94: pop
    //   95: aload_1
    //   96: invokevirtual 521	java/io/File:exists	()Z
    //   99: ifne +8 -> 107
    //   102: aload_1
    //   103: invokevirtual 531	java/io/File:createNewFile	()Z
    //   106: pop
    //   107: aload_1
    //   108: invokevirtual 521	java/io/File:exists	()Z
    //   111: ifeq -70 -> 41
    //   114: aload_1
    //   115: invokevirtual 645	java/io/File:canRead	()Z
    //   118: ifeq -77 -> 41
    //   121: new 649	java/io/FileInputStream
    //   124: dup
    //   125: aload_0
    //   126: invokespecial 652	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   129: astore_3
    //   130: new 654	java/util/zip/ZipOutputStream
    //   133: dup
    //   134: new 535	java/io/FileOutputStream
    //   137: dup
    //   138: aload_1
    //   139: invokespecial 655	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   142: invokespecial 658	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   145: astore 4
    //   147: aload 4
    //   149: bipush 8
    //   151: invokevirtual 661	java/util/zip/ZipOutputStream:setMethod	(I)V
    //   154: aload 4
    //   156: new 663	java/util/zip/ZipEntry
    //   159: dup
    //   160: aload_0
    //   161: invokevirtual 664	java/io/File:getName	()Ljava/lang/String;
    //   164: invokespecial 665	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   167: invokevirtual 669	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   170: sipush 5000
    //   173: newarray byte
    //   175: astore_0
    //   176: aload_3
    //   177: aload_0
    //   178: invokevirtual 673	java/io/FileInputStream:read	([B)I
    //   181: istore_2
    //   182: iload_2
    //   183: ifle +78 -> 261
    //   186: aload 4
    //   188: aload_0
    //   189: iconst_0
    //   190: iload_2
    //   191: invokevirtual 676	java/util/zip/ZipOutputStream:write	([BII)V
    //   194: goto -18 -> 176
    //   197: astore 5
    //   199: aload_3
    //   200: astore_1
    //   201: aload 4
    //   203: astore_0
    //   204: aload 5
    //   206: astore_3
    //   207: aload_3
    //   208: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   211: ifne +7 -> 218
    //   214: aload_3
    //   215: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
    //   218: aload_1
    //   219: ifnull +7 -> 226
    //   222: aload_1
    //   223: invokevirtual 677	java/io/FileInputStream:close	()V
    //   226: aload_0
    //   227: ifnull +7 -> 234
    //   230: aload_0
    //   231: invokevirtual 678	java/util/zip/ZipOutputStream:close	()V
    //   234: ldc_w 680
    //   237: iconst_0
    //   238: anewarray 4	java/lang/Object
    //   241: invokestatic 95	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   244: pop
    //   245: iconst_0
    //   246: ireturn
    //   247: astore_0
    //   248: aload_0
    //   249: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   252: ifne -211 -> 41
    //   255: aload_0
    //   256: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
    //   259: iconst_0
    //   260: ireturn
    //   261: aload 4
    //   263: invokevirtual 681	java/util/zip/ZipOutputStream:flush	()V
    //   266: aload 4
    //   268: invokevirtual 684	java/util/zip/ZipOutputStream:closeEntry	()V
    //   271: aload_3
    //   272: invokevirtual 677	java/io/FileInputStream:close	()V
    //   275: aload 4
    //   277: invokevirtual 678	java/util/zip/ZipOutputStream:close	()V
    //   280: ldc_w 680
    //   283: iconst_0
    //   284: anewarray 4	java/lang/Object
    //   287: invokestatic 95	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   290: pop
    //   291: iconst_1
    //   292: ireturn
    //   293: astore_0
    //   294: aload_0
    //   295: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   298: ifne -23 -> 275
    //   301: aload_0
    //   302: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   305: goto -30 -> 275
    //   308: astore_0
    //   309: aload_0
    //   310: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   313: ifne -33 -> 280
    //   316: aload_0
    //   317: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   320: goto -40 -> 280
    //   323: astore_1
    //   324: aload_1
    //   325: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   328: ifne -102 -> 226
    //   331: aload_1
    //   332: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   335: goto -109 -> 226
    //   338: astore_0
    //   339: aload_0
    //   340: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   343: ifne -109 -> 234
    //   346: aload_0
    //   347: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   350: goto -116 -> 234
    //   353: astore_1
    //   354: aconst_null
    //   355: astore_0
    //   356: aconst_null
    //   357: astore_3
    //   358: aload_3
    //   359: ifnull +7 -> 366
    //   362: aload_3
    //   363: invokevirtual 677	java/io/FileInputStream:close	()V
    //   366: aload_0
    //   367: ifnull +7 -> 374
    //   370: aload_0
    //   371: invokevirtual 678	java/util/zip/ZipOutputStream:close	()V
    //   374: ldc_w 680
    //   377: iconst_0
    //   378: anewarray 4	java/lang/Object
    //   381: invokestatic 95	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   384: pop
    //   385: aload_1
    //   386: athrow
    //   387: astore_3
    //   388: aload_3
    //   389: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   392: ifne -26 -> 366
    //   395: aload_3
    //   396: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   399: goto -33 -> 366
    //   402: astore_0
    //   403: aload_0
    //   404: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   407: ifne -33 -> 374
    //   410: aload_0
    //   411: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   414: goto -40 -> 374
    //   417: astore_1
    //   418: aconst_null
    //   419: astore_0
    //   420: goto -62 -> 358
    //   423: astore_1
    //   424: aload 4
    //   426: astore_0
    //   427: goto -69 -> 358
    //   430: astore 4
    //   432: aload_1
    //   433: astore_3
    //   434: aload 4
    //   436: astore_1
    //   437: goto -79 -> 358
    //   440: astore_3
    //   441: aconst_null
    //   442: astore_0
    //   443: aload 4
    //   445: astore_1
    //   446: goto -239 -> 207
    //   449: astore 4
    //   451: aconst_null
    //   452: astore_0
    //   453: aload_3
    //   454: astore_1
    //   455: aload 4
    //   457: astore_3
    //   458: goto -251 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	461	0	paramFile1	java.io.File
    //   0	461	1	paramFile2	java.io.File
    //   0	461	2	paramInt	int
    //   129	234	3	localObject1	Object
    //   387	9	3	localIOException	java.io.IOException
    //   433	1	3	localFile	java.io.File
    //   440	14	3	localThrowable1	Throwable
    //   457	1	3	localThrowable2	Throwable
    //   1	424	4	localZipOutputStream	java.util.zip.ZipOutputStream
    //   430	14	4	localObject2	Object
    //   449	7	4	localThrowable3	Throwable
    //   197	8	5	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   147	176	197	java/lang/Throwable
    //   176	182	197	java/lang/Throwable
    //   186	194	197	java/lang/Throwable
    //   261	271	197	java/lang/Throwable
    //   70	95	247	java/lang/Throwable
    //   95	107	247	java/lang/Throwable
    //   271	275	293	java/io/IOException
    //   275	280	308	java/io/IOException
    //   222	226	323	java/io/IOException
    //   230	234	338	java/io/IOException
    //   121	130	353	finally
    //   362	366	387	java/io/IOException
    //   370	374	402	java/io/IOException
    //   130	147	417	finally
    //   147	176	423	finally
    //   176	182	423	finally
    //   186	194	423	finally
    //   261	271	423	finally
    //   207	218	430	finally
    //   121	130	440	java/lang/Throwable
    //   130	147	449	java/lang/Throwable
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
    //   15: invokestatic 444	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   18: aload_0
    //   19: invokevirtual 448	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   22: astore_0
    //   23: aload_1
    //   24: ifnull +164 -> 188
    //   27: aload_0
    //   28: astore_2
    //   29: aload_0
    //   30: astore_3
    //   31: new 450	java/io/BufferedReader
    //   34: dup
    //   35: new 452	java/io/InputStreamReader
    //   38: dup
    //   39: aload_0
    //   40: invokevirtual 458	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   43: invokespecial 461	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   46: invokespecial 464	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   49: astore 4
    //   51: aload_0
    //   52: astore_2
    //   53: aload_0
    //   54: astore_3
    //   55: aload 4
    //   57: invokevirtual 467	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   60: astore 5
    //   62: aload 5
    //   64: ifnull +88 -> 152
    //   67: aload_0
    //   68: astore_2
    //   69: aload_0
    //   70: astore_3
    //   71: aload_1
    //   72: aload 5
    //   74: invokevirtual 688	com/tencent/feedback/eup/a:add	(Ljava/lang/Object;)Z
    //   77: pop
    //   78: goto -27 -> 51
    //   81: astore_0
    //   82: aload_2
    //   83: astore_3
    //   84: aload_0
    //   85: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   88: ifne +9 -> 97
    //   91: aload_2
    //   92: astore_3
    //   93: aload_0
    //   94: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
    //   97: aload_2
    //   98: astore_3
    //   99: aload_0
    //   100: invokevirtual 691	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   103: iconst_0
    //   104: anewarray 4	java/lang/Object
    //   107: invokestatic 99	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   110: pop
    //   111: aload_2
    //   112: ifnull -103 -> 9
    //   115: aload_2
    //   116: invokevirtual 695	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   119: invokevirtual 698	java/io/OutputStream:close	()V
    //   122: aload_2
    //   123: invokevirtual 458	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   126: invokevirtual 701	java/io/InputStream:close	()V
    //   129: aload_2
    //   130: invokevirtual 471	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   133: invokevirtual 701	java/io/InputStream:close	()V
    //   136: iconst_0
    //   137: ireturn
    //   138: astore_0
    //   139: aload_0
    //   140: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   143: ifne -134 -> 9
    //   146: aload_0
    //   147: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   150: iconst_0
    //   151: ireturn
    //   152: aload_0
    //   153: astore_2
    //   154: aload_0
    //   155: astore_3
    //   156: aload 4
    //   158: invokevirtual 468	java/io/BufferedReader:close	()V
    //   161: aload_0
    //   162: ifnull +24 -> 186
    //   165: aload_0
    //   166: invokevirtual 695	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   169: invokevirtual 698	java/io/OutputStream:close	()V
    //   172: aload_0
    //   173: invokevirtual 458	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   176: invokevirtual 701	java/io/InputStream:close	()V
    //   179: aload_0
    //   180: invokevirtual 471	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   183: invokevirtual 701	java/io/InputStream:close	()V
    //   186: iconst_1
    //   187: ireturn
    //   188: aload_0
    //   189: astore_2
    //   190: aload_0
    //   191: astore_3
    //   192: aload_0
    //   193: invokevirtual 704	java/lang/Process:waitFor	()I
    //   196: pop
    //   197: goto -36 -> 161
    //   200: astore_0
    //   201: aload_3
    //   202: ifnull +24 -> 226
    //   205: aload_3
    //   206: invokevirtual 695	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   209: invokevirtual 698	java/io/OutputStream:close	()V
    //   212: aload_3
    //   213: invokevirtual 458	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   216: invokevirtual 701	java/io/InputStream:close	()V
    //   219: aload_3
    //   220: invokevirtual 471	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   223: invokevirtual 701	java/io/InputStream:close	()V
    //   226: aload_0
    //   227: athrow
    //   228: astore_1
    //   229: aload_1
    //   230: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   233: ifne -61 -> 172
    //   236: aload_1
    //   237: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   240: goto -68 -> 172
    //   243: astore_1
    //   244: aload_1
    //   245: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   248: ifne -69 -> 179
    //   251: aload_1
    //   252: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   255: goto -76 -> 179
    //   258: astore_0
    //   259: aload_0
    //   260: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   263: ifne -77 -> 186
    //   266: aload_0
    //   267: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   270: goto -84 -> 186
    //   273: astore_0
    //   274: aload_0
    //   275: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   278: ifne -156 -> 122
    //   281: aload_0
    //   282: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   285: goto -163 -> 122
    //   288: astore_0
    //   289: aload_0
    //   290: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   293: ifne -164 -> 129
    //   296: aload_0
    //   297: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   300: goto -171 -> 129
    //   303: astore_1
    //   304: aload_1
    //   305: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   308: ifne -96 -> 212
    //   311: aload_1
    //   312: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   315: goto -103 -> 212
    //   318: astore_1
    //   319: aload_1
    //   320: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   323: ifne -104 -> 219
    //   326: aload_1
    //   327: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   330: goto -111 -> 219
    //   333: astore_1
    //   334: aload_1
    //   335: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   338: ifne -112 -> 226
    //   341: aload_1
    //   342: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   345: goto -119 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	paramArrayOfString	String[]
    //   0	348	1	parama	com.tencent.feedback.eup.a<String>
    //   14	176	2	arrayOfString	String[]
    //   12	208	3	localObject	Object
    //   49	108	4	localBufferedReader	java.io.BufferedReader
    //   60	13	5	str	String
    // Exception table:
    //   from	to	target	type
    //   15	23	81	java/lang/Throwable
    //   31	51	81	java/lang/Throwable
    //   55	62	81	java/lang/Throwable
    //   71	78	81	java/lang/Throwable
    //   156	161	81	java/lang/Throwable
    //   192	197	81	java/lang/Throwable
    //   129	136	138	java/io/IOException
    //   15	23	200	finally
    //   31	51	200	finally
    //   55	62	200	finally
    //   71	78	200	finally
    //   84	91	200	finally
    //   93	97	200	finally
    //   99	111	200	finally
    //   156	161	200	finally
    //   192	197	200	finally
    //   165	172	228	java/io/IOException
    //   172	179	243	java/io/IOException
    //   179	186	258	java/io/IOException
    //   115	122	273	java/io/IOException
    //   122	129	288	java/io/IOException
    //   205	212	303	java/io/IOException
    //   212	219	318	java/io/IOException
    //   219	226	333	java/io/IOException
  }
  
  public static byte[] a(j paramj)
  {
    try
    {
      i locali = new i();
      locali.a("utf-8");
      paramj.a(locali);
      paramj = locali.b();
      return paramj;
    }
    catch (Throwable paramj)
    {
      if (!e.b(paramj)) {
        paramj.printStackTrace();
      }
    }
    return null;
  }
  
  /* Error */
  public static byte[] a(Object paramObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc_w 723
    //   6: iconst_0
    //   7: anewarray 4	java/lang/Object
    //   10: invokestatic 95	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   13: pop
    //   14: aload_0
    //   15: ifnull +13 -> 28
    //   18: ldc_w 725
    //   21: aload_0
    //   22: invokevirtual 728	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   25: ifne +19 -> 44
    //   28: ldc_w 730
    //   31: iconst_0
    //   32: anewarray 4	java/lang/Object
    //   35: invokestatic 75	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   38: pop
    //   39: aload 4
    //   41: astore_1
    //   42: aload_1
    //   43: areturn
    //   44: new 732	java/io/ByteArrayOutputStream
    //   47: dup
    //   48: invokespecial 733	java/io/ByteArrayOutputStream:<init>	()V
    //   51: astore 5
    //   53: new 735	java/io/ObjectOutputStream
    //   56: dup
    //   57: aload 5
    //   59: invokespecial 736	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   62: astore_2
    //   63: aload_2
    //   64: astore_1
    //   65: aload_2
    //   66: aload_0
    //   67: invokevirtual 740	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   70: aload_2
    //   71: astore_1
    //   72: aload_2
    //   73: invokevirtual 741	java/io/ObjectOutputStream:flush	()V
    //   76: aload_2
    //   77: astore_1
    //   78: aload 5
    //   80: invokevirtual 744	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   83: astore_0
    //   84: aload_2
    //   85: invokevirtual 745	java/io/ObjectOutputStream:close	()V
    //   88: aload 5
    //   90: invokevirtual 746	java/io/ByteArrayOutputStream:close	()V
    //   93: aload_0
    //   94: areturn
    //   95: astore_2
    //   96: aload_0
    //   97: astore_1
    //   98: aload_2
    //   99: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   102: ifne -60 -> 42
    //   105: aload_2
    //   106: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   109: aload_0
    //   110: areturn
    //   111: astore_1
    //   112: aload_1
    //   113: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   116: ifne -28 -> 88
    //   119: aload_1
    //   120: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   123: goto -35 -> 88
    //   126: astore_3
    //   127: aconst_null
    //   128: astore_0
    //   129: aload_0
    //   130: astore_1
    //   131: aload_3
    //   132: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   135: ifne +9 -> 144
    //   138: aload_0
    //   139: astore_1
    //   140: aload_3
    //   141: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
    //   144: aload_0
    //   145: astore_1
    //   146: aload_3
    //   147: invokevirtual 691	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   150: iconst_0
    //   151: anewarray 4	java/lang/Object
    //   154: invokestatic 99	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   157: pop
    //   158: aload_0
    //   159: ifnull +7 -> 166
    //   162: aload_0
    //   163: invokevirtual 745	java/io/ObjectOutputStream:close	()V
    //   166: aload 5
    //   168: invokevirtual 746	java/io/ByteArrayOutputStream:close	()V
    //   171: aconst_null
    //   172: areturn
    //   173: astore_0
    //   174: aload 4
    //   176: astore_1
    //   177: aload_0
    //   178: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   181: ifne -139 -> 42
    //   184: aload_0
    //   185: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   188: aconst_null
    //   189: areturn
    //   190: astore_0
    //   191: aload_0
    //   192: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   195: ifne -29 -> 166
    //   198: aload_0
    //   199: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   202: goto -36 -> 166
    //   205: astore_0
    //   206: aconst_null
    //   207: astore_1
    //   208: aload_1
    //   209: ifnull +7 -> 216
    //   212: aload_1
    //   213: invokevirtual 745	java/io/ObjectOutputStream:close	()V
    //   216: aload 5
    //   218: invokevirtual 746	java/io/ByteArrayOutputStream:close	()V
    //   221: aload_0
    //   222: athrow
    //   223: astore_1
    //   224: aload_1
    //   225: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   228: ifne -12 -> 216
    //   231: aload_1
    //   232: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   235: goto -19 -> 216
    //   238: astore_1
    //   239: aload_1
    //   240: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   243: ifne -22 -> 221
    //   246: aload_1
    //   247: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   250: goto -29 -> 221
    //   253: astore_0
    //   254: goto -46 -> 208
    //   257: astore_3
    //   258: aload_2
    //   259: astore_0
    //   260: goto -131 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	paramObject	Object
    //   41	57	1	localObject1	Object
    //   111	9	1	localIOException1	java.io.IOException
    //   130	83	1	localObject2	Object
    //   223	9	1	localIOException2	java.io.IOException
    //   238	9	1	localIOException3	java.io.IOException
    //   62	23	2	localObjectOutputStream	java.io.ObjectOutputStream
    //   95	164	2	localIOException4	java.io.IOException
    //   126	21	3	localThrowable1	Throwable
    //   257	1	3	localThrowable2	Throwable
    //   1	174	4	localObject3	Object
    //   51	166	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   88	93	95	java/io/IOException
    //   84	88	111	java/io/IOException
    //   53	63	126	java/lang/Throwable
    //   166	171	173	java/io/IOException
    //   162	166	190	java/io/IOException
    //   53	63	205	finally
    //   212	216	223	java/io/IOException
    //   216	221	238	java/io/IOException
    //   65	70	253	finally
    //   72	76	253	finally
    //   78	84	253	finally
    //   131	138	253	finally
    //   140	144	253	finally
    //   146	158	253	finally
    //   65	70	257	java/lang/Throwable
    //   72	76	257	java/lang/Throwable
    //   78	84	257	java/lang/Throwable
  }
  
  /* Error */
  public static byte[] a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: new 290	java/lang/StringBuilder
    //   3: dup
    //   4: ldc_w 749
    //   7: invokespecial 295	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   10: iload_1
    //   11: invokevirtual 752	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14: invokevirtual 300	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17: iconst_0
    //   18: anewarray 4	java/lang/Object
    //   21: invokestatic 754	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   24: pop
    //   25: new 37	java/util/ArrayList
    //   28: dup
    //   29: invokespecial 429	java/util/ArrayList:<init>	()V
    //   32: astore_2
    //   33: aload_2
    //   34: invokevirtual 757	java/util/ArrayList:clear	()V
    //   37: aload_2
    //   38: ldc_w 759
    //   41: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   44: pop
    //   45: aload_2
    //   46: ldc_w 761
    //   49: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   52: pop
    //   53: aload_2
    //   54: ldc_w 763
    //   57: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   60: pop
    //   61: aload_2
    //   62: ldc_w 765
    //   65: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   68: pop
    //   69: aload_0
    //   70: ifnull +24 -> 94
    //   73: aload_0
    //   74: invokevirtual 515	java/lang/String:length	()I
    //   77: ifle +17 -> 94
    //   80: aload_2
    //   81: ldc_w 767
    //   84: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   87: pop
    //   88: aload_2
    //   89: aload_0
    //   90: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   93: pop
    //   94: aload_2
    //   95: invokevirtual 64	java/util/ArrayList:size	()I
    //   98: anewarray 137	java/lang/String
    //   101: astore_3
    //   102: aload_2
    //   103: aload_3
    //   104: invokevirtual 771	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   107: pop
    //   108: new 687	com/tencent/feedback/eup/a
    //   111: dup
    //   112: iload_1
    //   113: invokespecial 772	com/tencent/feedback/eup/a:<init>	(I)V
    //   116: astore_0
    //   117: aload_3
    //   118: aload_0
    //   119: invokestatic 774	com/tencent/feedback/proguard/a:a	([Ljava/lang/String;Lcom/tencent/feedback/eup/a;)Z
    //   122: pop
    //   123: aload_0
    //   124: invokevirtual 775	com/tencent/feedback/eup/a:size	()I
    //   127: ifgt +5 -> 132
    //   130: aconst_null
    //   131: areturn
    //   132: new 290	java/lang/StringBuilder
    //   135: dup
    //   136: ldc_w 777
    //   139: invokespecial 295	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   142: aload_0
    //   143: invokevirtual 775	com/tencent/feedback/eup/a:size	()I
    //   146: invokevirtual 752	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   149: invokevirtual 300	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: iconst_0
    //   153: anewarray 4	java/lang/Object
    //   156: invokestatic 754	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   159: pop
    //   160: new 330	java/lang/StringBuffer
    //   163: dup
    //   164: invokespecial 333	java/lang/StringBuffer:<init>	()V
    //   167: astore_2
    //   168: aload_0
    //   169: invokevirtual 778	com/tencent/feedback/eup/a:iterator	()Ljava/util/Iterator;
    //   172: astore_3
    //   173: aload_3
    //   174: invokeinterface 417 1 0
    //   179: ifeq +75 -> 254
    //   182: aload_2
    //   183: new 290	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 402	java/lang/StringBuilder:<init>	()V
    //   190: aload_3
    //   191: invokeinterface 421 1 0
    //   196: checkcast 137	java/lang/String
    //   199: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: ldc_w 780
    //   205: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 300	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokevirtual 424	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   214: pop
    //   215: goto -42 -> 173
    //   218: astore_0
    //   219: aload_0
    //   220: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   223: ifne +7 -> 230
    //   226: aload_0
    //   227: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
    //   230: ldc_w 782
    //   233: iconst_0
    //   234: anewarray 4	java/lang/Object
    //   237: invokestatic 99	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   240: pop
    //   241: ldc_w 784
    //   244: iconst_0
    //   245: anewarray 4	java/lang/Object
    //   248: invokestatic 754	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   251: pop
    //   252: aconst_null
    //   253: areturn
    //   254: aload_0
    //   255: invokevirtual 785	com/tencent/feedback/eup/a:clear	()V
    //   258: aload_2
    //   259: invokevirtual 331	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   262: ldc_w 711
    //   265: invokevirtual 543	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   268: astore_0
    //   269: aload_2
    //   270: iconst_0
    //   271: invokevirtual 788	java/lang/StringBuffer:setLength	(I)V
    //   274: ldc_w 784
    //   277: iconst_0
    //   278: anewarray 4	java/lang/Object
    //   281: invokestatic 754	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   284: pop
    //   285: aload_0
    //   286: areturn
    //   287: astore_0
    //   288: ldc_w 784
    //   291: iconst_0
    //   292: anewarray 4	java/lang/Object
    //   295: invokestatic 754	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   298: pop
    //   299: aload_0
    //   300: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	paramString	String
    //   0	301	1	paramInt	int
    //   32	238	2	localObject1	Object
    //   101	90	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   160	173	218	java/lang/Throwable
    //   173	215	218	java/lang/Throwable
    //   254	274	218	java/lang/Throwable
    //   160	173	287	finally
    //   173	215	287	finally
    //   219	230	287	finally
    //   230	241	287	finally
    //   254	274	287	finally
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    e.b("rqdp{  zp:} %s rqdp{  len:} %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) });
    try
    {
      C localC = B.a(paramInt);
      if (localC == null) {
        return null;
      }
      paramArrayOfByte = localC.a(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      if (!e.a(paramArrayOfByte)) {
        paramArrayOfByte.printStackTrace();
      }
      e.d("rqdp{  err zp :} %s", new Object[] { paramArrayOfByte.toString() });
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return null;
      try
      {
        paramArrayOfByte = a(a(paramArrayOfByte, paramInt1), paramInt2, paramString);
        return paramArrayOfByte;
      }
      catch (Throwable paramArrayOfByte) {}
    } while (e.a(paramArrayOfByte));
    paramArrayOfByte.printStackTrace();
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
      localObject = new G();
    }
    catch (Throwable paramArrayOfByte)
    {
      if (e.a(paramArrayOfByte)) {
        break label81;
      }
      paramArrayOfByte.printStackTrace();
      label81:
      e.d("rqdp{  err enD: }%s", new Object[] { paramArrayOfByte.toString() });
      return null;
    }
    if (paramInt == 3) {
      localObject = new F();
    } else {
      localObject = null;
    }
    while (localObject != null)
    {
      ((H)localObject).a(paramString);
      paramArrayOfByte = ((H)localObject).b(paramArrayOfByte);
      return paramArrayOfByte;
    }
    return null;
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
    //   11: ifnonnull +16 -> 27
    //   14: ldc_w 839
    //   17: iconst_0
    //   18: anewarray 4	java/lang/Object
    //   21: invokestatic 75	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   24: pop
    //   25: iconst_0
    //   26: ireturn
    //   27: new 171	com/tencent/feedback/proguard/n
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 174	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   35: astore 4
    //   37: aload_2
    //   38: astore_0
    //   39: aload 4
    //   41: astore_2
    //   42: aload 6
    //   44: astore_3
    //   45: aload 4
    //   47: invokevirtual 178	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   50: astore 5
    //   52: aload 5
    //   54: ifnonnull +48 -> 102
    //   57: aload 5
    //   59: astore_0
    //   60: aload 4
    //   62: astore_2
    //   63: aload 5
    //   65: astore_3
    //   66: ldc_w 603
    //   69: iconst_0
    //   70: anewarray 4	java/lang/Object
    //   73: invokestatic 99	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   76: pop
    //   77: aload 5
    //   79: ifnull +16 -> 95
    //   82: aload 5
    //   84: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   87: ifeq +8 -> 95
    //   90: aload 5
    //   92: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   95: aload 4
    //   97: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   100: iconst_0
    //   101: ireturn
    //   102: aload 5
    //   104: astore_0
    //   105: aload 4
    //   107: astore_2
    //   108: aload 5
    //   110: astore_3
    //   111: aload 5
    //   113: ldc 192
    //   115: ldc_w 841
    //   118: iconst_2
    //   119: anewarray 4	java/lang/Object
    //   122: dup
    //   123: iconst_0
    //   124: ldc 202
    //   126: aastore
    //   127: dup
    //   128: iconst_1
    //   129: sipush 510
    //   132: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   135: aastore
    //   136: invokestatic 844	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   139: aconst_null
    //   140: invokevirtual 848	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   143: istore_1
    //   144: aload 5
    //   146: astore_0
    //   147: aload 4
    //   149: astore_2
    //   150: aload 5
    //   152: astore_3
    //   153: ldc_w 850
    //   156: iconst_2
    //   157: anewarray 4	java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: sipush 510
    //   165: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   168: aastore
    //   169: dup
    //   170: iconst_1
    //   171: iload_1
    //   172: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: aastore
    //   176: invokestatic 95	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   179: pop
    //   180: aload 5
    //   182: ifnull +16 -> 198
    //   185: aload 5
    //   187: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   190: ifeq +8 -> 198
    //   193: aload 5
    //   195: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   198: aload 4
    //   200: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   203: iload_1
    //   204: ireturn
    //   205: astore 5
    //   207: aconst_null
    //   208: astore 4
    //   210: aload_3
    //   211: astore_0
    //   212: aload 4
    //   214: astore_2
    //   215: aload 5
    //   217: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   220: ifne +13 -> 233
    //   223: aload_3
    //   224: astore_0
    //   225: aload 4
    //   227: astore_2
    //   228: aload 5
    //   230: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
    //   233: aload_3
    //   234: astore_0
    //   235: aload 4
    //   237: astore_2
    //   238: ldc_w 852
    //   241: iconst_1
    //   242: anewarray 4	java/lang/Object
    //   245: dup
    //   246: iconst_0
    //   247: aload 5
    //   249: invokevirtual 277	java/lang/Throwable:toString	()Ljava/lang/String;
    //   252: aastore
    //   253: invokestatic 99	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   256: pop
    //   257: aload_3
    //   258: ifnull +14 -> 272
    //   261: aload_3
    //   262: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   265: ifeq +7 -> 272
    //   268: aload_3
    //   269: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   272: aload 4
    //   274: ifnull -249 -> 25
    //   277: aload 4
    //   279: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   282: iconst_0
    //   283: ireturn
    //   284: astore_3
    //   285: aconst_null
    //   286: astore_2
    //   287: aload 5
    //   289: astore_0
    //   290: aload_0
    //   291: ifnull +14 -> 305
    //   294: aload_0
    //   295: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   298: ifeq +7 -> 305
    //   301: aload_0
    //   302: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   305: aload_2
    //   306: ifnull +7 -> 313
    //   309: aload_2
    //   310: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   313: aload_3
    //   314: athrow
    //   315: astore_3
    //   316: goto -26 -> 290
    //   319: astore 5
    //   321: goto -111 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	paramContext	Context
    //   0	324	1	paramInt	int
    //   4	306	2	localObject1	Object
    //   9	260	3	localObject2	Object
    //   284	30	3	localObject3	Object
    //   315	1	3	localObject4	Object
    //   35	243	4	localn	n
    //   1	193	5	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   205	83	5	localThrowable1	Throwable
    //   319	1	5	localThrowable2	Throwable
    //   6	37	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   27	37	205	java/lang/Throwable
    //   27	37	284	finally
    //   45	52	315	finally
    //   66	77	315	finally
    //   111	144	315	finally
    //   153	180	315	finally
    //   215	223	315	finally
    //   228	233	315	finally
    //   238	257	315	finally
    //   45	52	319	java/lang/Throwable
    //   66	77	319	java/lang/Throwable
    //   111	144	319	java/lang/Throwable
    //   153	180	319	java/lang/Throwable
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
  
  /* Error */
  public static Object b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc_w 862
    //   5: iconst_0
    //   6: anewarray 4	java/lang/Object
    //   9: invokestatic 95	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   12: pop
    //   13: aload_3
    //   14: astore_1
    //   15: aload_0
    //   16: ifnull +10 -> 26
    //   19: aload_0
    //   20: arraylength
    //   21: ifge +7 -> 28
    //   24: aload_3
    //   25: astore_1
    //   26: aload_1
    //   27: areturn
    //   28: new 864	java/io/ByteArrayInputStream
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 866	java/io/ByteArrayInputStream:<init>	([B)V
    //   36: astore 4
    //   38: new 868	java/io/ObjectInputStream
    //   41: dup
    //   42: aload 4
    //   44: invokespecial 869	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   47: astore_1
    //   48: aload_1
    //   49: astore_0
    //   50: aload_1
    //   51: invokevirtual 872	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   54: astore_2
    //   55: aload_2
    //   56: astore_0
    //   57: aload_1
    //   58: invokevirtual 873	java/io/ObjectInputStream:close	()V
    //   61: aload 4
    //   63: invokevirtual 874	java/io/ByteArrayInputStream:close	()V
    //   66: aload_0
    //   67: areturn
    //   68: astore_2
    //   69: aload_0
    //   70: astore_1
    //   71: aload_2
    //   72: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   75: ifne -49 -> 26
    //   78: aload_2
    //   79: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   82: aload_0
    //   83: areturn
    //   84: astore_1
    //   85: aload_1
    //   86: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   89: ifne -28 -> 61
    //   92: aload_1
    //   93: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   96: goto -35 -> 61
    //   99: astore_2
    //   100: aconst_null
    //   101: astore_1
    //   102: aload_1
    //   103: astore_0
    //   104: aload_2
    //   105: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   108: ifne +9 -> 117
    //   111: aload_1
    //   112: astore_0
    //   113: aload_2
    //   114: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
    //   117: aload_1
    //   118: astore_0
    //   119: aload_2
    //   120: invokevirtual 691	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   123: iconst_0
    //   124: anewarray 4	java/lang/Object
    //   127: invokestatic 99	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   130: pop
    //   131: aload_1
    //   132: ifnull +7 -> 139
    //   135: aload_1
    //   136: invokevirtual 873	java/io/ObjectInputStream:close	()V
    //   139: aload 4
    //   141: invokevirtual 874	java/io/ByteArrayInputStream:close	()V
    //   144: aconst_null
    //   145: areturn
    //   146: astore_0
    //   147: aload_3
    //   148: astore_1
    //   149: aload_0
    //   150: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   153: ifne -127 -> 26
    //   156: aload_0
    //   157: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   160: aconst_null
    //   161: areturn
    //   162: astore_0
    //   163: aload_0
    //   164: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   167: ifne -28 -> 139
    //   170: aload_0
    //   171: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   174: goto -35 -> 139
    //   177: astore_1
    //   178: aconst_null
    //   179: astore_0
    //   180: aload_0
    //   181: ifnull +7 -> 188
    //   184: aload_0
    //   185: invokevirtual 873	java/io/ObjectInputStream:close	()V
    //   188: aload 4
    //   190: invokevirtual 874	java/io/ByteArrayInputStream:close	()V
    //   193: aload_1
    //   194: athrow
    //   195: astore_0
    //   196: aload_0
    //   197: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   200: ifne -12 -> 188
    //   203: aload_0
    //   204: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   207: goto -19 -> 188
    //   210: astore_0
    //   211: aload_0
    //   212: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   215: ifne -22 -> 193
    //   218: aload_0
    //   219: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   222: goto -29 -> 193
    //   225: astore_1
    //   226: goto -46 -> 180
    //   229: astore_2
    //   230: goto -128 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	paramArrayOfByte	byte[]
    //   14	57	1	localObject1	Object
    //   84	9	1	localIOException1	java.io.IOException
    //   101	48	1	localObject2	Object
    //   177	17	1	localObject3	Object
    //   225	1	1	localObject4	Object
    //   54	2	2	localObject5	Object
    //   68	11	2	localIOException2	java.io.IOException
    //   99	21	2	localThrowable1	Throwable
    //   229	1	2	localThrowable2	Throwable
    //   1	147	3	localObject6	Object
    //   36	153	4	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   61	66	68	java/io/IOException
    //   57	61	84	java/io/IOException
    //   38	48	99	java/lang/Throwable
    //   139	144	146	java/io/IOException
    //   135	139	162	java/io/IOException
    //   38	48	177	finally
    //   184	188	195	java/io/IOException
    //   188	193	210	java/io/IOException
    //   50	55	225	finally
    //   104	111	225	finally
    //   113	117	225	finally
    //   119	131	225	finally
    //   50	55	229	java/lang/Throwable
  }
  
  /* Error */
  public static String b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload 4
    //   5: astore_3
    //   6: aload_0
    //   7: ifnull +13 -> 20
    //   10: aload_0
    //   11: invokevirtual 515	java/lang/String:length	()I
    //   14: ifne +8 -> 22
    //   17: aload 4
    //   19: astore_3
    //   20: aload_3
    //   21: areturn
    //   22: new 517	java/io/File
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 518	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: astore_0
    //   31: aload 4
    //   33: astore_3
    //   34: aload_0
    //   35: invokevirtual 521	java/io/File:exists	()Z
    //   38: ifeq -18 -> 20
    //   41: aload 4
    //   43: astore_3
    //   44: aload_0
    //   45: invokevirtual 645	java/io/File:canRead	()Z
    //   48: ifeq -28 -> 20
    //   51: new 649	java/io/FileInputStream
    //   54: dup
    //   55: aload_0
    //   56: invokespecial 652	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   59: astore_2
    //   60: aload_2
    //   61: astore_0
    //   62: ldc_w 879
    //   65: invokestatic 885	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   68: astore_3
    //   69: aload_2
    //   70: astore_0
    //   71: sipush 4096
    //   74: newarray byte
    //   76: astore 5
    //   78: aload_2
    //   79: astore_0
    //   80: aload_2
    //   81: aload 5
    //   83: invokevirtual 673	java/io/FileInputStream:read	([B)I
    //   86: istore_1
    //   87: iload_1
    //   88: iconst_m1
    //   89: if_icmpeq +76 -> 165
    //   92: aload_2
    //   93: astore_0
    //   94: aload_3
    //   95: aload 5
    //   97: iconst_0
    //   98: iload_1
    //   99: invokevirtual 888	java/security/MessageDigest:update	([BII)V
    //   102: goto -24 -> 78
    //   105: astore_3
    //   106: aload_2
    //   107: astore_0
    //   108: aload_3
    //   109: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   112: ifne +9 -> 121
    //   115: aload_2
    //   116: astore_0
    //   117: aload_3
    //   118: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   121: aload_2
    //   122: astore_0
    //   123: aload_3
    //   124: invokevirtual 889	java/io/IOException:getMessage	()Ljava/lang/String;
    //   127: iconst_0
    //   128: anewarray 4	java/lang/Object
    //   131: invokestatic 99	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   134: pop
    //   135: aload 4
    //   137: astore_3
    //   138: aload_2
    //   139: ifnull -119 -> 20
    //   142: aload_2
    //   143: invokevirtual 677	java/io/FileInputStream:close	()V
    //   146: aconst_null
    //   147: areturn
    //   148: astore_0
    //   149: aload 4
    //   151: astore_3
    //   152: aload_0
    //   153: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   156: ifne -136 -> 20
    //   159: aload_0
    //   160: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   163: aconst_null
    //   164: areturn
    //   165: aload_2
    //   166: astore_0
    //   167: aload_3
    //   168: invokevirtual 892	java/security/MessageDigest:digest	()[B
    //   171: invokestatic 895	com/tencent/feedback/proguard/a:e	([B)Ljava/lang/String;
    //   174: astore_3
    //   175: aload_3
    //   176: astore_0
    //   177: aload_2
    //   178: invokevirtual 677	java/io/FileInputStream:close	()V
    //   181: aload_0
    //   182: areturn
    //   183: astore_2
    //   184: aload_0
    //   185: astore_3
    //   186: aload_2
    //   187: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   190: ifne -170 -> 20
    //   193: aload_2
    //   194: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   197: aload_0
    //   198: areturn
    //   199: astore_3
    //   200: aconst_null
    //   201: astore_2
    //   202: aload_2
    //   203: astore_0
    //   204: aload_3
    //   205: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   208: ifne +9 -> 217
    //   211: aload_2
    //   212: astore_0
    //   213: aload_3
    //   214: invokevirtual 896	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   217: aload_2
    //   218: astore_0
    //   219: aload_3
    //   220: invokevirtual 897	java/security/NoSuchAlgorithmException:getMessage	()Ljava/lang/String;
    //   223: iconst_0
    //   224: anewarray 4	java/lang/Object
    //   227: invokestatic 99	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   230: pop
    //   231: aload 4
    //   233: astore_3
    //   234: aload_2
    //   235: ifnull -215 -> 20
    //   238: aload_2
    //   239: invokevirtual 677	java/io/FileInputStream:close	()V
    //   242: aconst_null
    //   243: areturn
    //   244: astore_0
    //   245: aload 4
    //   247: astore_3
    //   248: aload_0
    //   249: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   252: ifne -232 -> 20
    //   255: aload_0
    //   256: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   259: aconst_null
    //   260: areturn
    //   261: astore_2
    //   262: aconst_null
    //   263: astore_0
    //   264: aload_0
    //   265: ifnull +7 -> 272
    //   268: aload_0
    //   269: invokevirtual 677	java/io/FileInputStream:close	()V
    //   272: aload_2
    //   273: athrow
    //   274: astore_0
    //   275: aload_0
    //   276: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   279: ifne -7 -> 272
    //   282: aload_0
    //   283: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   286: goto -14 -> 272
    //   289: astore_2
    //   290: goto -26 -> 264
    //   293: astore_3
    //   294: goto -92 -> 202
    //   297: astore_3
    //   298: aconst_null
    //   299: astore_2
    //   300: goto -194 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	paramString	String
    //   86	13	1	i	int
    //   59	119	2	localFileInputStream	java.io.FileInputStream
    //   183	11	2	localIOException1	java.io.IOException
    //   201	38	2	localObject1	Object
    //   261	12	2	localObject2	Object
    //   289	1	2	localObject3	Object
    //   299	1	2	localObject4	Object
    //   5	90	3	localObject5	Object
    //   105	19	3	localIOException2	java.io.IOException
    //   137	49	3	localObject6	Object
    //   199	21	3	localNoSuchAlgorithmException1	NoSuchAlgorithmException
    //   233	15	3	localObject7	Object
    //   293	1	3	localNoSuchAlgorithmException2	NoSuchAlgorithmException
    //   297	1	3	localIOException3	java.io.IOException
    //   1	245	4	localObject8	Object
    //   76	20	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   62	69	105	java/io/IOException
    //   71	78	105	java/io/IOException
    //   80	87	105	java/io/IOException
    //   94	102	105	java/io/IOException
    //   167	175	105	java/io/IOException
    //   142	146	148	java/io/IOException
    //   177	181	183	java/io/IOException
    //   51	60	199	java/security/NoSuchAlgorithmException
    //   238	242	244	java/io/IOException
    //   51	60	261	finally
    //   268	272	274	java/io/IOException
    //   62	69	289	finally
    //   71	78	289	finally
    //   80	87	289	finally
    //   94	102	289	finally
    //   108	115	289	finally
    //   117	121	289	finally
    //   123	135	289	finally
    //   167	175	289	finally
    //   204	211	289	finally
    //   213	217	289	finally
    //   219	231	289	finally
    //   62	69	293	java/security/NoSuchAlgorithmException
    //   71	78	293	java/security/NoSuchAlgorithmException
    //   80	87	293	java/security/NoSuchAlgorithmException
    //   94	102	293	java/security/NoSuchAlgorithmException
    //   167	175	293	java/security/NoSuchAlgorithmException
    //   51	60	297	java/io/IOException
  }
  
  public static Map<String, String> b()
  {
    Object localObject = Thread.getAllStackTraces();
    HashMap localHashMap;
    if (localObject != null)
    {
      localHashMap = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      try
      {
        localObject = ((Map)localObject).entrySet().iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
            localStringBuilder.setLength(0);
            try
            {
              StackTraceElement[] arrayOfStackTraceElement = (StackTraceElement[])localEntry.getValue();
              int j = arrayOfStackTraceElement.length;
              int i = 0;
              while (i < j)
              {
                localStringBuilder.append(arrayOfStackTraceElement[i].toString()).append("\n");
                i += 1;
              }
            }
            catch (Throwable localThrowable2)
            {
              e.d("add frame error %s", new Object[] { localThrowable2.getClass().getName() + ":" + localThrowable2.getMessage() });
              localHashMap.put(((Thread)localEntry.getKey()).getName(), localStringBuilder.toString());
            }
          }
        }
        return localHashMap;
      }
      catch (Throwable localThrowable1)
      {
        e.d("add all thread error", new Object[0]);
        if (!e.a(localThrowable1)) {
          localThrowable1.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    e.b("rqdp{  unzp:} %s rqdp{  len:} %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) });
    try
    {
      C localC = B.a(paramInt);
      if (localC == null) {
        return null;
      }
      paramArrayOfByte = localC.b(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      if (!e.a(paramArrayOfByte)) {
        paramArrayOfByte.printStackTrace();
      }
      e.d("rqdp{  err unzp}" + paramArrayOfByte.toString(), new Object[0]);
    }
    return null;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      paramArrayOfByte = b(b(paramArrayOfByte, 1, paramString), 2);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      if (!e.a(paramArrayOfByte)) {
        paramArrayOfByte.printStackTrace();
      }
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
      localObject = new G();
    }
    catch (Throwable paramArrayOfByte)
    {
      if (e.a(paramArrayOfByte)) {
        break label55;
      }
      paramArrayOfByte.printStackTrace();
      label55:
      e.d("rqdp{  err unD:} %s", new Object[] { paramArrayOfByte.toString() });
      return null;
    }
    if (paramInt == 3) {
      localObject = new F();
    } else {
      localObject = null;
    }
    while (localObject != null)
    {
      ((H)localObject).a(paramString);
      paramArrayOfByte = ((H)localObject).a(paramArrayOfByte);
      return paramArrayOfByte;
    }
    return null;
  }
  
  public static q[] b(Context paramContext, String paramString)
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
  
  public static int c(Context paramContext, String paramString)
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
  
  public static long c()
  {
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
      long l = localSimpleDateFormat.parse(localSimpleDateFormat.format(new Date())).getTime();
      return l;
    }
    catch (Throwable localThrowable)
    {
      if (!e.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -1L;
  }
  
  public static String c(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return "NULL";
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = e(localMessageDigest.digest());
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      if (!e.a(paramArrayOfByte)) {
        paramArrayOfByte.printStackTrace();
      }
      e.d(paramArrayOfByte.getMessage(), new Object[0]);
    }
    return null;
  }
  
  public static Q d(byte[] paramArrayOfByte)
  {
    try
    {
      Q localQ = new Q();
      paramArrayOfByte = new h(paramArrayOfByte);
      paramArrayOfByte.a("utf-8");
      localQ.a(paramArrayOfByte);
      return localQ;
    }
    catch (Throwable paramArrayOfByte)
    {
      if (!e.b(paramArrayOfByte)) {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
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
      if (!e.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return null;
  }
  
  private static String e(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuffer.append("0");
      }
      localStringBuffer.append(str);
      i += 1;
    }
    return localStringBuffer.toString().toUpperCase();
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.a
 * JD-Core Version:    0.7.0.1
 */