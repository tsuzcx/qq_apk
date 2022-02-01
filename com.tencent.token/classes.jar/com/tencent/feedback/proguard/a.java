package com.tencent.feedback.proguard;

import android.content.Context;
import com.tencent.feedback.common.c;
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
    if ((paramContext != null) && (paramArrayOfp != null))
    {
      if (paramArrayOfp.length <= 0) {
        return -1;
      }
      ArrayList localArrayList = new ArrayList(paramArrayOfp.length);
      int j = paramArrayOfp.length;
      int i = 0;
      while (i < j)
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
      if (localArrayList.size() > 0)
      {
        if (l.b(paramContext, localArrayList)) {
          return localArrayList.size();
        }
        return -1;
      }
      return 0;
    }
    return -1;
  }
  
  public static int a(Context paramContext, q[] paramArrayOfq)
  {
    if ((paramContext != null) && (paramArrayOfq != null)) {}
    for (;;)
    {
      int i;
      try
      {
        if (paramArrayOfq.length > 0)
        {
          ArrayList localArrayList = new ArrayList(paramArrayOfq.length);
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
          else
          {
            if ((localArrayList.size() > 0) && (l.a(paramContext, localArrayList)))
            {
              i = localArrayList.size();
              return i;
            }
            return 0;
          }
        }
        else
        {
          e.c("rqdp{  args error}", new Object[0]);
          return 0;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public static N a(int paramInt, c paramc, byte[] paramArrayOfByte, byte paramByte1, byte paramByte2, String paramString)
  {
    e.b("rqdp{  en2Req }", new Object[0]);
    if (paramc == null)
    {
      e.d("rqdp{  error no com info!}", new Object[0]);
      return null;
    }
    N localN;
    for (;;)
    {
      try
      {
        localN = new N();
        try
        {
          localN.a = paramc.a();
          localN.b = paramc.n();
          localN.c = paramc.b();
          localN.d = paramc.B();
          localN.e = "";
          localN.f = paramc.c();
          localN.g = paramInt;
          if (paramArrayOfByte == null)
          {
            arrayOfByte = "".getBytes();
            localN.h = arrayOfByte;
            localN.i = paramc.e();
            localN.j = paramc.f();
            if (paramArrayOfByte == null) {
              break;
            }
            localN.h = a(localN.h, paramByte1, paramByte2, paramString);
            if (localN.h != null) {
              break;
            }
            e.d("reqPkg sbuffer error!", new Object[0]);
            return null;
          }
        }
        finally {}
        byte[] arrayOfByte = paramArrayOfByte;
      }
      catch (Throwable paramc)
      {
        if (!e.a(paramc)) {
          paramc.printStackTrace();
        }
        return null;
      }
    }
    return localN;
  }
  
  /* Error */
  public static z a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +15 -> 16
    //   4: ldc 169
    //   6: iconst_0
    //   7: anewarray 4	java/lang/Object
    //   10: invokestatic 75	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   13: pop
    //   14: aconst_null
    //   15: areturn
    //   16: new 171	com/tencent/feedback/proguard/n
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 174	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   24: astore_2
    //   25: aload_2
    //   26: invokevirtual 178	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   29: astore_3
    //   30: aload_3
    //   31: ifnonnull +34 -> 65
    //   34: ldc 180
    //   36: iconst_0
    //   37: anewarray 4	java/lang/Object
    //   40: invokestatic 75	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   43: pop
    //   44: aload_3
    //   45: ifnull +14 -> 59
    //   48: aload_3
    //   49: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   52: ifeq +7 -> 59
    //   55: aload_3
    //   56: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   59: aload_2
    //   60: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   63: aconst_null
    //   64: areturn
    //   65: aload_3
    //   66: ldc 192
    //   68: aconst_null
    //   69: getstatic 198	java/util/Locale:US	Ljava/util/Locale;
    //   72: ldc 200
    //   74: iconst_2
    //   75: anewarray 4	java/lang/Object
    //   78: dup
    //   79: iconst_0
    //   80: ldc 202
    //   82: aastore
    //   83: dup
    //   84: iconst_1
    //   85: iload_1
    //   86: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   89: aastore
    //   90: invokestatic 212	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   93: aconst_null
    //   94: aconst_null
    //   95: aconst_null
    //   96: aconst_null
    //   97: invokevirtual 216	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   100: astore_0
    //   101: aload_0
    //   102: ifnull +305 -> 407
    //   105: aload_2
    //   106: astore 5
    //   108: aload_3
    //   109: astore 6
    //   111: aload_0
    //   112: astore 7
    //   114: aload_0
    //   115: invokeinterface 221 1 0
    //   120: ifeq +287 -> 407
    //   123: aload_0
    //   124: ifnull +561 -> 685
    //   127: aload_2
    //   128: astore 5
    //   130: aload_3
    //   131: astore 6
    //   133: aload_0
    //   134: astore 7
    //   136: aload_0
    //   137: invokeinterface 224 1 0
    //   142: ifne +543 -> 685
    //   145: aload_2
    //   146: astore 5
    //   148: aload_3
    //   149: astore 6
    //   151: aload_0
    //   152: astore 7
    //   154: aload_0
    //   155: invokeinterface 227 1 0
    //   160: ifeq +6 -> 166
    //   163: goto +522 -> 685
    //   166: aload_2
    //   167: astore 5
    //   169: aload_3
    //   170: astore 6
    //   172: aload_0
    //   173: astore 7
    //   175: ldc 229
    //   177: iconst_0
    //   178: anewarray 4	java/lang/Object
    //   181: invokestatic 95	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   184: pop
    //   185: aload_2
    //   186: astore 5
    //   188: aload_3
    //   189: astore 6
    //   191: aload_0
    //   192: astore 7
    //   194: new 231	com/tencent/feedback/proguard/z
    //   197: dup
    //   198: invokespecial 232	com/tencent/feedback/proguard/z:<init>	()V
    //   201: astore 4
    //   203: aload_2
    //   204: astore 5
    //   206: aload_3
    //   207: astore 6
    //   209: aload_0
    //   210: astore 7
    //   212: aload 4
    //   214: aload_0
    //   215: aload_0
    //   216: ldc 234
    //   218: invokeinterface 238 2 0
    //   223: invokeinterface 242 2 0
    //   228: invokevirtual 245	com/tencent/feedback/proguard/z:a	(J)V
    //   231: aload_2
    //   232: astore 5
    //   234: aload_3
    //   235: astore 6
    //   237: aload_0
    //   238: astore 7
    //   240: aload 4
    //   242: aload_0
    //   243: aload_0
    //   244: ldc 202
    //   246: invokeinterface 238 2 0
    //   251: invokeinterface 249 2 0
    //   256: invokevirtual 251	com/tencent/feedback/proguard/z:a	(I)V
    //   259: aload_2
    //   260: astore 5
    //   262: aload_3
    //   263: astore 6
    //   265: aload_0
    //   266: astore 7
    //   268: aload 4
    //   270: aload_0
    //   271: aload_0
    //   272: ldc 253
    //   274: invokeinterface 238 2 0
    //   279: invokeinterface 242 2 0
    //   284: invokevirtual 255	com/tencent/feedback/proguard/z:b	(J)V
    //   287: aload_2
    //   288: astore 5
    //   290: aload_3
    //   291: astore 6
    //   293: aload_0
    //   294: astore 7
    //   296: aload 4
    //   298: aload_0
    //   299: aload_0
    //   300: ldc_w 257
    //   303: invokeinterface 238 2 0
    //   308: invokeinterface 261 2 0
    //   313: invokevirtual 264	com/tencent/feedback/proguard/z:a	([B)V
    //   316: goto +3 -> 319
    //   319: aload 4
    //   321: ifnull +86 -> 407
    //   324: aload_2
    //   325: astore 5
    //   327: aload_3
    //   328: astore 6
    //   330: aload_0
    //   331: astore 7
    //   333: ldc_w 266
    //   336: iconst_1
    //   337: anewarray 4	java/lang/Object
    //   340: dup
    //   341: iconst_0
    //   342: aload 4
    //   344: invokevirtual 268	com/tencent/feedback/proguard/z:b	()I
    //   347: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   350: aastore
    //   351: invokestatic 95	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   354: pop
    //   355: aload_0
    //   356: ifnull +18 -> 374
    //   359: aload_0
    //   360: invokeinterface 271 1 0
    //   365: ifne +9 -> 374
    //   368: aload_0
    //   369: invokeinterface 272 1 0
    //   374: aload_3
    //   375: ifnull +14 -> 389
    //   378: aload_3
    //   379: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   382: ifeq +7 -> 389
    //   385: aload_3
    //   386: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   389: aload_2
    //   390: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   393: aload 4
    //   395: areturn
    //   396: astore 5
    //   398: aload_2
    //   399: astore 4
    //   401: aload 5
    //   403: astore_2
    //   404: goto +123 -> 527
    //   407: aload_0
    //   408: ifnull +18 -> 426
    //   411: aload_0
    //   412: invokeinterface 271 1 0
    //   417: ifne +9 -> 426
    //   420: aload_0
    //   421: invokeinterface 272 1 0
    //   426: aload_3
    //   427: ifnull +14 -> 441
    //   430: aload_3
    //   431: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   434: ifeq +7 -> 441
    //   437: aload_3
    //   438: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   441: aload_2
    //   442: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   445: aconst_null
    //   446: areturn
    //   447: astore_0
    //   448: aconst_null
    //   449: astore 4
    //   451: aload_2
    //   452: astore 5
    //   454: aload_3
    //   455: astore_2
    //   456: aload 4
    //   458: astore_3
    //   459: goto +180 -> 639
    //   462: astore_0
    //   463: aconst_null
    //   464: astore 5
    //   466: aload_2
    //   467: astore 4
    //   469: aload_0
    //   470: astore_2
    //   471: aload 5
    //   473: astore_0
    //   474: goto +53 -> 527
    //   477: astore_0
    //   478: aconst_null
    //   479: astore 4
    //   481: aload 4
    //   483: astore_3
    //   484: aload_2
    //   485: astore 5
    //   487: aload 4
    //   489: astore_2
    //   490: goto +149 -> 639
    //   493: astore 5
    //   495: aconst_null
    //   496: astore_3
    //   497: aload_3
    //   498: astore_0
    //   499: aload_2
    //   500: astore 4
    //   502: aload 5
    //   504: astore_2
    //   505: goto +22 -> 527
    //   508: astore_0
    //   509: aconst_null
    //   510: astore_2
    //   511: aload_2
    //   512: astore_3
    //   513: aload_3
    //   514: astore 5
    //   516: goto +123 -> 639
    //   519: astore_2
    //   520: aconst_null
    //   521: astore_3
    //   522: aload_3
    //   523: astore_0
    //   524: aload_0
    //   525: astore 4
    //   527: aload 4
    //   529: astore 5
    //   531: aload_3
    //   532: astore 6
    //   534: aload_0
    //   535: astore 7
    //   537: aload_2
    //   538: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   541: ifne +17 -> 558
    //   544: aload 4
    //   546: astore 5
    //   548: aload_3
    //   549: astore 6
    //   551: aload_0
    //   552: astore 7
    //   554: aload_2
    //   555: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
    //   558: aload 4
    //   560: astore 5
    //   562: aload_3
    //   563: astore 6
    //   565: aload_0
    //   566: astore 7
    //   568: ldc_w 274
    //   571: iconst_1
    //   572: anewarray 4	java/lang/Object
    //   575: dup
    //   576: iconst_0
    //   577: aload_2
    //   578: invokevirtual 277	java/lang/Throwable:toString	()Ljava/lang/String;
    //   581: aastore
    //   582: invokestatic 99	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   585: pop
    //   586: aload_0
    //   587: ifnull +18 -> 605
    //   590: aload_0
    //   591: invokeinterface 271 1 0
    //   596: ifne +9 -> 605
    //   599: aload_0
    //   600: invokeinterface 272 1 0
    //   605: aload_3
    //   606: ifnull +14 -> 620
    //   609: aload_3
    //   610: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   613: ifeq +7 -> 620
    //   616: aload_3
    //   617: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   620: aload 4
    //   622: ifnull +8 -> 630
    //   625: aload 4
    //   627: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   630: aconst_null
    //   631: areturn
    //   632: astore_0
    //   633: aload 7
    //   635: astore_3
    //   636: aload 6
    //   638: astore_2
    //   639: aload_3
    //   640: ifnull +18 -> 658
    //   643: aload_3
    //   644: invokeinterface 271 1 0
    //   649: ifne +9 -> 658
    //   652: aload_3
    //   653: invokeinterface 272 1 0
    //   658: aload_2
    //   659: ifnull +14 -> 673
    //   662: aload_2
    //   663: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   666: ifeq +7 -> 673
    //   669: aload_2
    //   670: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   673: aload 5
    //   675: ifnull +8 -> 683
    //   678: aload 5
    //   680: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   683: aload_0
    //   684: athrow
    //   685: aconst_null
    //   686: astore 4
    //   688: goto -369 -> 319
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	691	0	paramContext	Context
    //   0	691	1	paramInt	int
    //   24	488	2	localObject1	Object
    //   519	59	2	localThrowable1	Throwable
    //   638	32	2	localObject2	Object
    //   29	624	3	localObject3	Object
    //   201	486	4	localObject4	Object
    //   106	220	5	localObject5	Object
    //   396	6	5	localThrowable2	Throwable
    //   452	34	5	localObject6	Object
    //   493	10	5	localThrowable3	Throwable
    //   514	165	5	localObject7	Object
    //   109	528	6	localObject8	Object
    //   112	522	7	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   114	123	396	java/lang/Throwable
    //   136	145	396	java/lang/Throwable
    //   154	163	396	java/lang/Throwable
    //   175	185	396	java/lang/Throwable
    //   194	203	396	java/lang/Throwable
    //   212	231	396	java/lang/Throwable
    //   240	259	396	java/lang/Throwable
    //   268	287	396	java/lang/Throwable
    //   296	316	396	java/lang/Throwable
    //   333	355	396	java/lang/Throwable
    //   34	44	447	finally
    //   65	101	447	finally
    //   34	44	462	java/lang/Throwable
    //   65	101	462	java/lang/Throwable
    //   25	30	477	finally
    //   25	30	493	java/lang/Throwable
    //   16	25	508	finally
    //   16	25	519	java/lang/Throwable
    //   114	123	632	finally
    //   136	145	632	finally
    //   154	163	632	finally
    //   175	185	632	finally
    //   194	203	632	finally
    //   212	231	632	finally
    //   240	259	632	finally
    //   268	287	632	finally
    //   296	316	632	finally
    //   333	355	632	finally
    //   537	544	632	finally
    //   554	558	632	finally
    //   568	586	632	finally
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if ((paramString != null) && (!paramString.trim().equals("")))
    {
      paramContext = a(paramContext, new String[] { "/system/bin/sh", "-c", "getprop ".concat(String.valueOf(paramString)) });
      if ((paramContext != null) && (paramContext.size() > 0)) {
        return (String)paramContext.get(0);
      }
      return "fail";
    }
    return "";
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
    Object localObject;
    while (i < paramArrayList.size())
    {
      String str = (String)paramArrayList.get(i);
      if ((!str.equals("java.lang.Integer")) && (!str.equals("int")))
      {
        if ((!str.equals("java.lang.Boolean")) && (!str.equals("boolean")))
        {
          if ((!str.equals("java.lang.Byte")) && (!str.equals("byte")))
          {
            if ((!str.equals("java.lang.Double")) && (!str.equals("double")))
            {
              if ((!str.equals("java.lang.Float")) && (!str.equals("float")))
              {
                if ((!str.equals("java.lang.Long")) && (!str.equals("long")))
                {
                  if ((!str.equals("java.lang.Short")) && (!str.equals("short")))
                  {
                    if (!str.equals("java.lang.Character"))
                    {
                      if (str.equals("java.lang.String"))
                      {
                        localObject = "string";
                      }
                      else if (str.equals("java.util.List"))
                      {
                        localObject = "list";
                      }
                      else
                      {
                        localObject = str;
                        if (str.equals("java.util.Map")) {
                          localObject = "map";
                        }
                      }
                    }
                    else {
                      throw new IllegalArgumentException("can not support java.lang.Character");
                    }
                  }
                  else {
                    localObject = "short";
                  }
                }
                else {
                  localObject = "int64";
                }
              }
              else {
                localObject = "float";
              }
            }
            else {
              localObject = "double";
            }
          }
          else {
            localObject = "char";
          }
        }
        else {
          localObject = "bool";
        }
      }
      else {
        localObject = "int32";
      }
      paramArrayList.set(i, localObject);
      i += 1;
    }
    Collections.reverse(paramArrayList);
    i = 0;
    while (i < paramArrayList.size())
    {
      localObject = (String)paramArrayList.get(i);
      int j;
      if (((String)localObject).equals("list"))
      {
        j = i - 1;
        localObject = new StringBuilder("<");
        ((StringBuilder)localObject).append((String)paramArrayList.get(j));
        paramArrayList.set(j, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append((String)paramArrayList.get(0));
        ((StringBuilder)localObject).append(">");
        paramArrayList.set(0, ((StringBuilder)localObject).toString());
      }
      else if (((String)localObject).equals("map"))
      {
        j = i - 1;
        localObject = new StringBuilder("<");
        ((StringBuilder)localObject).append((String)paramArrayList.get(j));
        ((StringBuilder)localObject).append(",");
        paramArrayList.set(j, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append((String)paramArrayList.get(0));
        ((StringBuilder)localObject).append(">");
        paramArrayList.set(0, ((StringBuilder)localObject).toString());
      }
      else if (((String)localObject).equals("Array"))
      {
        j = i - 1;
        localObject = new StringBuilder("<");
        ((StringBuilder)localObject).append((String)paramArrayList.get(j));
        paramArrayList.set(j, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append((String)paramArrayList.get(0));
        ((StringBuilder)localObject).append(">");
        paramArrayList.set(0, ((StringBuilder)localObject).toString());
      }
      i += 1;
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
    //   0: new 37	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 436	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: invokestatic 439	com/tencent/feedback/common/c:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/c;
    //   12: invokevirtual 442	com/tencent/feedback/common/c:N	()Z
    //   15: ifeq +28 -> 43
    //   18: new 37	java/util/ArrayList
    //   21: dup
    //   22: invokespecial 436	java/util/ArrayList:<init>	()V
    //   25: astore_0
    //   26: aload_0
    //   27: new 137	java/lang/String
    //   30: dup
    //   31: ldc_w 444
    //   34: invokespecial 445	java/lang/String:<init>	(Ljava/lang/String;)V
    //   37: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   40: pop
    //   41: aload_0
    //   42: areturn
    //   43: aconst_null
    //   44: astore_2
    //   45: invokestatic 451	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   48: aload_1
    //   49: invokevirtual 455	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   52: astore_1
    //   53: new 457	java/io/BufferedReader
    //   56: dup
    //   57: new 459	java/io/InputStreamReader
    //   60: dup
    //   61: aload_1
    //   62: invokevirtual 465	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   65: invokespecial 468	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   68: invokespecial 471	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   71: astore_0
    //   72: aload_0
    //   73: invokevirtual 474	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   76: astore 4
    //   78: aload 4
    //   80: ifnull +13 -> 93
    //   83: aload_3
    //   84: aload 4
    //   86: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   89: pop
    //   90: goto -18 -> 72
    //   93: new 457	java/io/BufferedReader
    //   96: dup
    //   97: new 459	java/io/InputStreamReader
    //   100: dup
    //   101: aload_1
    //   102: invokevirtual 477	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   105: invokespecial 468	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   108: invokespecial 471	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   111: astore 4
    //   113: aload_0
    //   114: astore_1
    //   115: aload 4
    //   117: astore_2
    //   118: aload 4
    //   120: invokevirtual 474	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   123: astore 5
    //   125: aload 5
    //   127: ifnull +18 -> 145
    //   130: aload_0
    //   131: astore_1
    //   132: aload 4
    //   134: astore_2
    //   135: aload_3
    //   136: aload 5
    //   138: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   141: pop
    //   142: goto -29 -> 113
    //   145: aload_0
    //   146: invokevirtual 478	java/io/BufferedReader:close	()V
    //   149: goto +15 -> 164
    //   152: astore_0
    //   153: aload_0
    //   154: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   157: ifne +7 -> 164
    //   160: aload_0
    //   161: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   164: aload 4
    //   166: invokevirtual 478	java/io/BufferedReader:close	()V
    //   169: aload_3
    //   170: areturn
    //   171: astore_0
    //   172: aload_0
    //   173: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   176: ifne +7 -> 183
    //   179: aload_0
    //   180: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   183: aload_3
    //   184: areturn
    //   185: astore_1
    //   186: aload_0
    //   187: astore_3
    //   188: aload 4
    //   190: astore_0
    //   191: aload_1
    //   192: astore 4
    //   194: goto +34 -> 228
    //   197: astore_3
    //   198: aload_0
    //   199: astore_1
    //   200: aload_3
    //   201: astore_0
    //   202: goto +95 -> 297
    //   205: astore 4
    //   207: aconst_null
    //   208: astore_1
    //   209: aload_0
    //   210: astore_3
    //   211: aload_1
    //   212: astore_0
    //   213: goto +15 -> 228
    //   216: astore_0
    //   217: aconst_null
    //   218: astore_1
    //   219: goto +78 -> 297
    //   222: astore 4
    //   224: aconst_null
    //   225: astore_3
    //   226: aload_3
    //   227: astore_0
    //   228: aload_3
    //   229: astore_1
    //   230: aload_0
    //   231: astore_2
    //   232: aload 4
    //   234: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   237: ifne +12 -> 249
    //   240: aload_3
    //   241: astore_1
    //   242: aload_0
    //   243: astore_2
    //   244: aload 4
    //   246: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
    //   249: aload_3
    //   250: ifnull +22 -> 272
    //   253: aload_3
    //   254: invokevirtual 478	java/io/BufferedReader:close	()V
    //   257: goto +15 -> 272
    //   260: astore_1
    //   261: aload_1
    //   262: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   265: ifne +7 -> 272
    //   268: aload_1
    //   269: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   272: aload_0
    //   273: ifnull +21 -> 294
    //   276: aload_0
    //   277: invokevirtual 478	java/io/BufferedReader:close	()V
    //   280: aconst_null
    //   281: areturn
    //   282: astore_0
    //   283: aload_0
    //   284: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   287: ifne +7 -> 294
    //   290: aload_0
    //   291: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   294: aconst_null
    //   295: areturn
    //   296: astore_0
    //   297: aload_1
    //   298: ifnull +22 -> 320
    //   301: aload_1
    //   302: invokevirtual 478	java/io/BufferedReader:close	()V
    //   305: goto +15 -> 320
    //   308: astore_1
    //   309: aload_1
    //   310: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   313: ifne +7 -> 320
    //   316: aload_1
    //   317: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   320: aload_2
    //   321: ifnull +22 -> 343
    //   324: aload_2
    //   325: invokevirtual 478	java/io/BufferedReader:close	()V
    //   328: goto +15 -> 343
    //   331: astore_1
    //   332: aload_1
    //   333: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   336: ifne +7 -> 343
    //   339: aload_1
    //   340: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   343: aload_0
    //   344: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	paramContext	Context
    //   0	345	1	paramArrayOfString	String[]
    //   44	281	2	localObject1	Object
    //   7	181	3	localObject2	Object
    //   197	4	3	localObject3	Object
    //   210	44	3	localContext	Context
    //   76	117	4	localObject4	Object
    //   205	1	4	localThrowable1	Throwable
    //   222	23	4	localThrowable2	Throwable
    //   123	14	5	str	String
    // Exception table:
    //   from	to	target	type
    //   145	149	152	java/io/IOException
    //   164	169	171	java/io/IOException
    //   118	125	185	java/lang/Throwable
    //   135	142	185	java/lang/Throwable
    //   72	78	197	finally
    //   83	90	197	finally
    //   93	113	197	finally
    //   72	78	205	java/lang/Throwable
    //   83	90	205	java/lang/Throwable
    //   93	113	205	java/lang/Throwable
    //   45	72	216	finally
    //   45	72	222	java/lang/Throwable
    //   253	257	260	java/io/IOException
    //   276	280	282	java/io/IOException
    //   118	125	296	finally
    //   135	142	296	finally
    //   232	240	296	finally
    //   244	249	296	finally
    //   301	305	308	java/io/IOException
    //   324	328	331	java/io/IOException
  }
  
  public static List<p> a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    Object localObject = l.a(paramContext, new int[] { 7 }, -1, -1, 9223372036854775807L, 5, null, -1, -1, -1, -1, -1L, 9223372036854775807L);
    if (localObject != null)
    {
      if (((List)localObject).size() <= 0) {
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
    return null;
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
    //   0: ldc_w 519
    //   3: iconst_1
    //   4: anewarray 4	java/lang/Object
    //   7: dup
    //   8: iconst_0
    //   9: aload_0
    //   10: aastore
    //   11: invokestatic 95	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   14: pop
    //   15: aload_1
    //   16: ifnull +229 -> 245
    //   19: aload_1
    //   20: invokevirtual 281	java/lang/String:trim	()Ljava/lang/String;
    //   23: invokevirtual 522	java/lang/String:length	()I
    //   26: ifgt +4 -> 30
    //   29: return
    //   30: new 524	java/io/File
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 525	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore 6
    //   40: aload 6
    //   42: invokevirtual 528	java/io/File:exists	()Z
    //   45: ifne +26 -> 71
    //   48: aload 6
    //   50: invokevirtual 532	java/io/File:getParentFile	()Ljava/io/File;
    //   53: ifnull +12 -> 65
    //   56: aload 6
    //   58: invokevirtual 532	java/io/File:getParentFile	()Ljava/io/File;
    //   61: invokevirtual 535	java/io/File:mkdirs	()Z
    //   64: pop
    //   65: aload 6
    //   67: invokevirtual 538	java/io/File:createNewFile	()Z
    //   70: pop
    //   71: aconst_null
    //   72: astore 5
    //   74: aconst_null
    //   75: astore_0
    //   76: aload_0
    //   77: astore_3
    //   78: aload 5
    //   80: astore 4
    //   82: aload 6
    //   84: invokevirtual 540	java/io/File:length	()J
    //   87: iload_2
    //   88: i2l
    //   89: lcmp
    //   90: iflt +23 -> 113
    //   93: aload_0
    //   94: astore_3
    //   95: aload 5
    //   97: astore 4
    //   99: new 542	java/io/FileOutputStream
    //   102: dup
    //   103: aload 6
    //   105: iconst_0
    //   106: invokespecial 545	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   109: astore_0
    //   110: goto +20 -> 130
    //   113: aload_0
    //   114: astore_3
    //   115: aload 5
    //   117: astore 4
    //   119: new 542	java/io/FileOutputStream
    //   122: dup
    //   123: aload 6
    //   125: iconst_1
    //   126: invokespecial 545	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   129: astore_0
    //   130: aload_0
    //   131: astore_3
    //   132: aload_0
    //   133: astore 4
    //   135: aload_0
    //   136: aload_1
    //   137: ldc_w 547
    //   140: invokevirtual 550	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   143: invokevirtual 553	java/io/FileOutputStream:write	([B)V
    //   146: aload_0
    //   147: astore_3
    //   148: aload_0
    //   149: astore 4
    //   151: aload_0
    //   152: invokevirtual 556	java/io/FileOutputStream:flush	()V
    //   155: aload_0
    //   156: invokevirtual 557	java/io/FileOutputStream:close	()V
    //   159: goto +74 -> 233
    //   162: astore_0
    //   163: goto +48 -> 211
    //   166: astore_0
    //   167: aload 4
    //   169: astore_3
    //   170: aload_0
    //   171: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   174: ifne +10 -> 184
    //   177: aload 4
    //   179: astore_3
    //   180: aload_0
    //   181: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
    //   184: aload 4
    //   186: astore_3
    //   187: ldc_w 559
    //   190: iconst_0
    //   191: anewarray 4	java/lang/Object
    //   194: invokestatic 99	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   197: pop
    //   198: aload 4
    //   200: ifnull +33 -> 233
    //   203: aload 4
    //   205: invokevirtual 557	java/io/FileOutputStream:close	()V
    //   208: goto +25 -> 233
    //   211: aload_3
    //   212: ifnull +7 -> 219
    //   215: aload_3
    //   216: invokevirtual 557	java/io/FileOutputStream:close	()V
    //   219: aload_0
    //   220: athrow
    //   221: astore_0
    //   222: aload_0
    //   223: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   226: ifne +7 -> 233
    //   229: aload_0
    //   230: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
    //   233: ldc_w 561
    //   236: iconst_0
    //   237: anewarray 4	java/lang/Object
    //   240: invokestatic 95	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   243: pop
    //   244: return
    //   245: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	paramString1	String
    //   0	246	1	paramString2	String
    //   0	246	2	paramInt	int
    //   77	139	3	localObject1	Object
    //   80	124	4	localObject2	Object
    //   72	44	5	localObject3	Object
    //   38	86	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   82	93	162	finally
    //   99	110	162	finally
    //   119	130	162	finally
    //   135	146	162	finally
    //   151	155	162	finally
    //   170	177	162	finally
    //   180	184	162	finally
    //   187	198	162	finally
    //   82	93	166	java/lang/Throwable
    //   99	110	166	java/lang/Throwable
    //   119	130	166	java/lang/Throwable
    //   135	146	166	java/lang/Throwable
    //   151	155	166	java/lang/Throwable
    //   40	65	221	java/lang/Throwable
    //   65	71	221	java/lang/Throwable
    //   155	159	221	java/lang/Throwable
    //   203	208	221	java/lang/Throwable
    //   215	219	221	java/lang/Throwable
    //   219	221	221	java/lang/Throwable
  }
  
  private void a(ArrayList<String> paramArrayList, Object paramObject)
  {
    for (;;)
    {
      if (paramObject.getClass().isArray())
      {
        if (paramObject.getClass().getComponentType().toString().equals("byte"))
        {
          if (Array.getLength(paramObject) > 0)
          {
            paramArrayList.add("java.util.List");
            paramObject = Array.get(paramObject, 0);
          }
          else
          {
            paramArrayList.add("Array");
            paramArrayList.add("?");
          }
        }
        else {
          throw new IllegalArgumentException("only byte[] is supported");
        }
      }
      else
      {
        if ((paramObject instanceof Array)) {
          break label236;
        }
        if ((paramObject instanceof List))
        {
          paramArrayList.add("java.util.List");
          paramObject = (List)paramObject;
          if (paramObject.size() > 0) {
            paramObject = paramObject.get(0);
          } else {
            paramArrayList.add("?");
          }
        }
        else
        {
          if (!(paramObject instanceof Map)) {
            break label223;
          }
          paramArrayList.add("java.util.Map");
          paramObject = (Map)paramObject;
          if (paramObject.size() <= 0) {
            break;
          }
          Object localObject = paramObject.keySet().iterator().next();
          paramObject = paramObject.get(localObject);
          paramArrayList.add(localObject.getClass().getName());
        }
      }
    }
    paramArrayList.add("?");
    paramArrayList.add("?");
    return;
    label223:
    paramArrayList.add(paramObject.getClass().getName());
    return;
    label236:
    throw new IllegalArgumentException("can not support Array, please use List");
  }
  
  /* Error */
  public static boolean a(Context paramContext, z paramz)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +447 -> 448
    //   4: aload_1
    //   5: ifnonnull +6 -> 11
    //   8: goto +440 -> 448
    //   11: aconst_null
    //   12: astore 7
    //   14: aconst_null
    //   15: astore 5
    //   17: aconst_null
    //   18: astore 8
    //   20: new 171	com/tencent/feedback/proguard/n
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 174	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   28: astore_0
    //   29: aload_0
    //   30: astore 4
    //   32: aload_0
    //   33: invokevirtual 178	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   36: astore 6
    //   38: aload 6
    //   40: ifnonnull +58 -> 98
    //   43: ldc_w 606
    //   46: iconst_0
    //   47: anewarray 4	java/lang/Object
    //   50: invokestatic 99	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   53: pop
    //   54: aload 6
    //   56: ifnull +16 -> 72
    //   59: aload 6
    //   61: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   64: ifeq +8 -> 72
    //   67: aload 6
    //   69: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   72: aload_0
    //   73: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   76: iconst_0
    //   77: ireturn
    //   78: astore 5
    //   80: aload 6
    //   82: astore_1
    //   83: goto +339 -> 422
    //   86: astore 4
    //   88: aload 6
    //   90: astore_1
    //   91: aload 4
    //   93: astore 6
    //   95: goto +242 -> 337
    //   98: aload_1
    //   99: ifnonnull +10 -> 109
    //   102: aload 8
    //   104: astore 4
    //   106: goto +75 -> 181
    //   109: new 608	android/content/ContentValues
    //   112: dup
    //   113: invokespecial 609	android/content/ContentValues:<init>	()V
    //   116: astore 4
    //   118: aload_1
    //   119: invokevirtual 610	com/tencent/feedback/proguard/z:a	()J
    //   122: lconst_0
    //   123: lcmp
    //   124: iflt +17 -> 141
    //   127: aload 4
    //   129: ldc 234
    //   131: aload_1
    //   132: invokevirtual 610	com/tencent/feedback/proguard/z:a	()J
    //   135: invokestatic 615	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   138: invokevirtual 619	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   141: aload 4
    //   143: ldc 202
    //   145: aload_1
    //   146: invokevirtual 268	com/tencent/feedback/proguard/z:b	()I
    //   149: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   152: invokevirtual 622	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   155: aload 4
    //   157: ldc_w 257
    //   160: aload_1
    //   161: invokevirtual 624	com/tencent/feedback/proguard/z:c	()[B
    //   164: invokevirtual 627	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   167: aload 4
    //   169: ldc 253
    //   171: aload_1
    //   172: invokevirtual 629	com/tencent/feedback/proguard/z:d	()J
    //   175: invokestatic 615	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   178: invokevirtual 619	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   181: aload 4
    //   183: ifnull +106 -> 289
    //   186: aload 6
    //   188: ldc 192
    //   190: ldc 234
    //   192: aload 4
    //   194: invokevirtual 633	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   197: lstore_2
    //   198: lload_2
    //   199: lconst_0
    //   200: lcmp
    //   201: ifge +38 -> 239
    //   204: ldc_w 635
    //   207: iconst_0
    //   208: anewarray 4	java/lang/Object
    //   211: invokestatic 75	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   214: pop
    //   215: aload 6
    //   217: ifnull +16 -> 233
    //   220: aload 6
    //   222: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   225: ifeq +8 -> 233
    //   228: aload 6
    //   230: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   233: aload_0
    //   234: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   237: iconst_0
    //   238: ireturn
    //   239: aload_1
    //   240: lload_2
    //   241: invokevirtual 245	com/tencent/feedback/proguard/z:a	(J)V
    //   244: ldc_w 637
    //   247: iconst_1
    //   248: anewarray 4	java/lang/Object
    //   251: dup
    //   252: iconst_0
    //   253: aload_1
    //   254: invokevirtual 268	com/tencent/feedback/proguard/z:b	()I
    //   257: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   260: aastore
    //   261: invokestatic 95	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   264: pop
    //   265: aload 6
    //   267: ifnull +16 -> 283
    //   270: aload 6
    //   272: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   275: ifeq +8 -> 283
    //   278: aload 6
    //   280: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   283: aload_0
    //   284: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   287: iconst_1
    //   288: ireturn
    //   289: aload 6
    //   291: ifnull +16 -> 307
    //   294: aload 6
    //   296: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   299: ifeq +8 -> 307
    //   302: aload 6
    //   304: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   307: aload_0
    //   308: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   311: iconst_0
    //   312: ireturn
    //   313: astore 6
    //   315: aload 7
    //   317: astore_1
    //   318: goto +19 -> 337
    //   321: astore 5
    //   323: aconst_null
    //   324: astore_1
    //   325: aload_1
    //   326: astore_0
    //   327: goto +95 -> 422
    //   330: astore 6
    //   332: aconst_null
    //   333: astore_0
    //   334: aload 7
    //   336: astore_1
    //   337: aload_1
    //   338: astore 5
    //   340: aload_0
    //   341: astore 4
    //   343: ldc_w 639
    //   346: iconst_1
    //   347: anewarray 4	java/lang/Object
    //   350: dup
    //   351: iconst_0
    //   352: aload 6
    //   354: invokevirtual 277	java/lang/Throwable:toString	()Ljava/lang/String;
    //   357: aastore
    //   358: invokestatic 99	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   361: pop
    //   362: aload_1
    //   363: astore 5
    //   365: aload_0
    //   366: astore 4
    //   368: aload 6
    //   370: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   373: ifne +14 -> 387
    //   376: aload_1
    //   377: astore 5
    //   379: aload_0
    //   380: astore 4
    //   382: aload 6
    //   384: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
    //   387: aload_1
    //   388: ifnull +14 -> 402
    //   391: aload_1
    //   392: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   395: ifeq +7 -> 402
    //   398: aload_1
    //   399: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   402: aload_0
    //   403: ifnull +7 -> 410
    //   406: aload_0
    //   407: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   410: iconst_0
    //   411: ireturn
    //   412: astore_0
    //   413: aload 5
    //   415: astore_1
    //   416: aload_0
    //   417: astore 5
    //   419: aload 4
    //   421: astore_0
    //   422: aload_1
    //   423: ifnull +14 -> 437
    //   426: aload_1
    //   427: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   430: ifeq +7 -> 437
    //   433: aload_1
    //   434: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   437: aload_0
    //   438: ifnull +7 -> 445
    //   441: aload_0
    //   442: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   445: aload 5
    //   447: athrow
    //   448: ldc_w 641
    //   451: iconst_0
    //   452: anewarray 4	java/lang/Object
    //   455: invokestatic 75	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   458: pop
    //   459: iconst_0
    //   460: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	461	0	paramContext	Context
    //   0	461	1	paramz	z
    //   197	44	2	l	long
    //   30	1	4	localContext	Context
    //   86	6	4	localThrowable1	Throwable
    //   104	316	4	localObject1	Object
    //   15	1	5	localObject2	Object
    //   78	1	5	localObject3	Object
    //   321	1	5	localObject4	Object
    //   338	108	5	localObject5	Object
    //   36	267	6	localObject6	Object
    //   313	1	6	localThrowable2	Throwable
    //   330	53	6	localThrowable3	Throwable
    //   12	323	7	localObject7	Object
    //   18	85	8	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   43	54	78	finally
    //   109	141	78	finally
    //   141	181	78	finally
    //   186	198	78	finally
    //   204	215	78	finally
    //   239	265	78	finally
    //   43	54	86	java/lang/Throwable
    //   109	141	86	java/lang/Throwable
    //   141	181	86	java/lang/Throwable
    //   186	198	86	java/lang/Throwable
    //   204	215	86	java/lang/Throwable
    //   239	265	86	java/lang/Throwable
    //   32	38	313	java/lang/Throwable
    //   20	29	321	finally
    //   20	29	330	java/lang/Throwable
    //   32	38	412	finally
    //   343	362	412	finally
    //   368	376	412	finally
    //   382	387	412	finally
  }
  
  /* Error */
  public static boolean a(java.io.File paramFile1, java.io.File paramFile2, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 644
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 95	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: ifnull +443 -> 455
    //   15: aload_1
    //   16: ifnull +439 -> 455
    //   19: aload_0
    //   20: aload_1
    //   21: invokevirtual 645	java/io/File:equals	(Ljava/lang/Object;)Z
    //   24: ifeq +6 -> 30
    //   27: goto +428 -> 455
    //   30: aload_0
    //   31: invokevirtual 528	java/io/File:exists	()Z
    //   34: ifeq +408 -> 442
    //   37: aload_0
    //   38: invokevirtual 648	java/io/File:canRead	()Z
    //   41: ifne +6 -> 47
    //   44: goto +398 -> 442
    //   47: aload_1
    //   48: invokevirtual 532	java/io/File:getParentFile	()Ljava/io/File;
    //   51: ifnull +21 -> 72
    //   54: aload_1
    //   55: invokevirtual 532	java/io/File:getParentFile	()Ljava/io/File;
    //   58: invokevirtual 528	java/io/File:exists	()Z
    //   61: ifne +11 -> 72
    //   64: aload_1
    //   65: invokevirtual 532	java/io/File:getParentFile	()Ljava/io/File;
    //   68: invokevirtual 535	java/io/File:mkdirs	()Z
    //   71: pop
    //   72: aload_1
    //   73: invokevirtual 528	java/io/File:exists	()Z
    //   76: ifne +8 -> 84
    //   79: aload_1
    //   80: invokevirtual 538	java/io/File:createNewFile	()Z
    //   83: pop
    //   84: aload_1
    //   85: invokevirtual 528	java/io/File:exists	()Z
    //   88: ifeq +338 -> 426
    //   91: aload_1
    //   92: invokevirtual 648	java/io/File:canRead	()Z
    //   95: ifne +5 -> 100
    //   98: iconst_0
    //   99: ireturn
    //   100: aconst_null
    //   101: astore 4
    //   103: new 650	java/io/FileInputStream
    //   106: dup
    //   107: aload_0
    //   108: invokespecial 653	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   111: astore_3
    //   112: new 655	java/util/zip/ZipOutputStream
    //   115: dup
    //   116: new 542	java/io/FileOutputStream
    //   119: dup
    //   120: aload_1
    //   121: invokespecial 656	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   124: invokespecial 659	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   127: astore_1
    //   128: aload_1
    //   129: bipush 8
    //   131: invokevirtual 662	java/util/zip/ZipOutputStream:setMethod	(I)V
    //   134: aload_1
    //   135: new 664	java/util/zip/ZipEntry
    //   138: dup
    //   139: aload_0
    //   140: invokevirtual 665	java/io/File:getName	()Ljava/lang/String;
    //   143: invokespecial 666	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   146: invokevirtual 670	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   149: sipush 5000
    //   152: newarray byte
    //   154: astore_0
    //   155: aload_3
    //   156: aload_0
    //   157: invokevirtual 674	java/io/FileInputStream:read	([B)I
    //   160: istore_2
    //   161: iload_2
    //   162: ifle +13 -> 175
    //   165: aload_1
    //   166: aload_0
    //   167: iconst_0
    //   168: iload_2
    //   169: invokevirtual 677	java/util/zip/ZipOutputStream:write	([BII)V
    //   172: goto -17 -> 155
    //   175: aload_1
    //   176: invokevirtual 678	java/util/zip/ZipOutputStream:flush	()V
    //   179: aload_1
    //   180: invokevirtual 681	java/util/zip/ZipOutputStream:closeEntry	()V
    //   183: aload_3
    //   184: invokevirtual 682	java/io/FileInputStream:close	()V
    //   187: goto +15 -> 202
    //   190: astore_0
    //   191: aload_0
    //   192: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   195: ifne +7 -> 202
    //   198: aload_0
    //   199: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   202: aload_1
    //   203: invokevirtual 683	java/util/zip/ZipOutputStream:close	()V
    //   206: goto +15 -> 221
    //   209: astore_0
    //   210: aload_0
    //   211: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   214: ifne +7 -> 221
    //   217: aload_0
    //   218: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   221: ldc_w 685
    //   224: iconst_0
    //   225: anewarray 4	java/lang/Object
    //   228: invokestatic 95	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   231: pop
    //   232: iconst_1
    //   233: ireturn
    //   234: astore 4
    //   236: aload_1
    //   237: astore_0
    //   238: aload 4
    //   240: astore_1
    //   241: goto +126 -> 367
    //   244: astore 4
    //   246: aload_1
    //   247: astore_0
    //   248: aload 4
    //   250: astore_1
    //   251: goto +12 -> 263
    //   254: astore_1
    //   255: aconst_null
    //   256: astore_0
    //   257: goto +110 -> 367
    //   260: astore_1
    //   261: aconst_null
    //   262: astore_0
    //   263: aload_1
    //   264: astore 4
    //   266: aload_3
    //   267: astore_1
    //   268: goto +20 -> 288
    //   271: astore_1
    //   272: aconst_null
    //   273: astore_3
    //   274: aload_3
    //   275: astore_0
    //   276: goto +91 -> 367
    //   279: astore_3
    //   280: aconst_null
    //   281: astore_0
    //   282: aload 4
    //   284: astore_1
    //   285: aload_3
    //   286: astore 4
    //   288: aload 4
    //   290: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   293: ifne +8 -> 301
    //   296: aload 4
    //   298: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
    //   301: aload_1
    //   302: ifnull +22 -> 324
    //   305: aload_1
    //   306: invokevirtual 682	java/io/FileInputStream:close	()V
    //   309: goto +15 -> 324
    //   312: astore_1
    //   313: aload_1
    //   314: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   317: ifne +7 -> 324
    //   320: aload_1
    //   321: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   324: aload_0
    //   325: ifnull +22 -> 347
    //   328: aload_0
    //   329: invokevirtual 683	java/util/zip/ZipOutputStream:close	()V
    //   332: goto +15 -> 347
    //   335: astore_0
    //   336: aload_0
    //   337: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   340: ifne +7 -> 347
    //   343: aload_0
    //   344: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   347: ldc_w 685
    //   350: iconst_0
    //   351: anewarray 4	java/lang/Object
    //   354: invokestatic 95	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   357: pop
    //   358: iconst_0
    //   359: ireturn
    //   360: astore 4
    //   362: aload_1
    //   363: astore_3
    //   364: aload 4
    //   366: astore_1
    //   367: aload_3
    //   368: ifnull +22 -> 390
    //   371: aload_3
    //   372: invokevirtual 682	java/io/FileInputStream:close	()V
    //   375: goto +15 -> 390
    //   378: astore_3
    //   379: aload_3
    //   380: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   383: ifne +7 -> 390
    //   386: aload_3
    //   387: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   390: aload_0
    //   391: ifnull +22 -> 413
    //   394: aload_0
    //   395: invokevirtual 683	java/util/zip/ZipOutputStream:close	()V
    //   398: goto +15 -> 413
    //   401: astore_0
    //   402: aload_0
    //   403: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   406: ifne +7 -> 413
    //   409: aload_0
    //   410: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   413: ldc_w 685
    //   416: iconst_0
    //   417: anewarray 4	java/lang/Object
    //   420: invokestatic 95	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   423: pop
    //   424: aload_1
    //   425: athrow
    //   426: iconst_0
    //   427: ireturn
    //   428: astore_0
    //   429: aload_0
    //   430: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   433: ifne +7 -> 440
    //   436: aload_0
    //   437: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
    //   440: iconst_0
    //   441: ireturn
    //   442: ldc_w 687
    //   445: iconst_0
    //   446: anewarray 4	java/lang/Object
    //   449: invokestatic 75	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   452: pop
    //   453: iconst_0
    //   454: ireturn
    //   455: ldc_w 689
    //   458: iconst_0
    //   459: anewarray 4	java/lang/Object
    //   462: invokestatic 75	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   465: pop
    //   466: iconst_0
    //   467: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	paramFile1	java.io.File
    //   0	468	1	paramFile2	java.io.File
    //   0	468	2	paramInt	int
    //   111	164	3	localFileInputStream	java.io.FileInputStream
    //   279	7	3	localThrowable1	Throwable
    //   363	9	3	localFile	java.io.File
    //   378	9	3	localIOException	java.io.IOException
    //   101	1	4	localObject1	Object
    //   234	5	4	localObject2	Object
    //   244	5	4	localThrowable2	Throwable
    //   264	33	4	localObject3	Object
    //   360	5	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   183	187	190	java/io/IOException
    //   202	206	209	java/io/IOException
    //   128	155	234	finally
    //   155	161	234	finally
    //   165	172	234	finally
    //   175	183	234	finally
    //   128	155	244	java/lang/Throwable
    //   155	161	244	java/lang/Throwable
    //   165	172	244	java/lang/Throwable
    //   175	183	244	java/lang/Throwable
    //   112	128	254	finally
    //   112	128	260	java/lang/Throwable
    //   103	112	271	finally
    //   103	112	279	java/lang/Throwable
    //   305	309	312	java/io/IOException
    //   328	332	335	java/io/IOException
    //   288	301	360	finally
    //   371	375	378	java/io/IOException
    //   394	398	401	java/io/IOException
    //   47	72	428	java/lang/Throwable
    //   72	84	428	java/lang/Throwable
  }
  
  /* Error */
  public static boolean a(String[] paramArrayOfString, com.tencent.feedback.eup.a<String> parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +350 -> 351
    //   4: aload_0
    //   5: arraylength
    //   6: ifgt +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: aconst_null
    //   12: astore_3
    //   13: aconst_null
    //   14: astore_2
    //   15: invokestatic 451	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   18: aload_0
    //   19: invokevirtual 455	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   22: astore_0
    //   23: aload_1
    //   24: ifnull +69 -> 93
    //   27: aload_0
    //   28: astore_2
    //   29: aload_0
    //   30: astore_3
    //   31: new 457	java/io/BufferedReader
    //   34: dup
    //   35: new 459	java/io/InputStreamReader
    //   38: dup
    //   39: aload_0
    //   40: invokevirtual 465	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   43: invokespecial 468	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   46: invokespecial 471	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   49: astore 4
    //   51: aload_0
    //   52: astore_2
    //   53: aload_0
    //   54: astore_3
    //   55: aload 4
    //   57: invokevirtual 474	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   60: astore 5
    //   62: aload 5
    //   64: ifnull +17 -> 81
    //   67: aload_0
    //   68: astore_2
    //   69: aload_0
    //   70: astore_3
    //   71: aload_1
    //   72: aload 5
    //   74: invokevirtual 693	com/tencent/feedback/eup/a:add	(Ljava/lang/Object;)Z
    //   77: pop
    //   78: goto -27 -> 51
    //   81: aload_0
    //   82: astore_2
    //   83: aload_0
    //   84: astore_3
    //   85: aload 4
    //   87: invokevirtual 478	java/io/BufferedReader:close	()V
    //   90: goto +12 -> 102
    //   93: aload_0
    //   94: astore_2
    //   95: aload_0
    //   96: astore_3
    //   97: aload_0
    //   98: invokevirtual 696	java/lang/Process:waitFor	()I
    //   101: pop
    //   102: aload_0
    //   103: ifnull +69 -> 172
    //   106: aload_0
    //   107: invokevirtual 700	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   110: invokevirtual 703	java/io/OutputStream:close	()V
    //   113: goto +15 -> 128
    //   116: astore_1
    //   117: aload_1
    //   118: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   121: ifne +7 -> 128
    //   124: aload_1
    //   125: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   128: aload_0
    //   129: invokevirtual 465	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   132: invokevirtual 706	java/io/InputStream:close	()V
    //   135: goto +15 -> 150
    //   138: astore_1
    //   139: aload_1
    //   140: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   143: ifne +7 -> 150
    //   146: aload_1
    //   147: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   150: aload_0
    //   151: invokevirtual 477	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   154: invokevirtual 706	java/io/InputStream:close	()V
    //   157: goto +15 -> 172
    //   160: astore_0
    //   161: aload_0
    //   162: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   165: ifne +7 -> 172
    //   168: aload_0
    //   169: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   172: iconst_1
    //   173: ireturn
    //   174: astore_0
    //   175: goto +104 -> 279
    //   178: astore_0
    //   179: aload_3
    //   180: astore_2
    //   181: aload_0
    //   182: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   185: ifne +9 -> 194
    //   188: aload_3
    //   189: astore_2
    //   190: aload_0
    //   191: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
    //   194: aload_3
    //   195: astore_2
    //   196: aload_0
    //   197: invokevirtual 709	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   200: iconst_0
    //   201: anewarray 4	java/lang/Object
    //   204: invokestatic 99	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   207: pop
    //   208: aload_3
    //   209: ifnull +68 -> 277
    //   212: aload_3
    //   213: invokevirtual 700	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   216: invokevirtual 703	java/io/OutputStream:close	()V
    //   219: goto +15 -> 234
    //   222: astore_0
    //   223: aload_0
    //   224: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   227: ifne +7 -> 234
    //   230: aload_0
    //   231: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   234: aload_3
    //   235: invokevirtual 465	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   238: invokevirtual 706	java/io/InputStream:close	()V
    //   241: goto +15 -> 256
    //   244: astore_0
    //   245: aload_0
    //   246: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   249: ifne +7 -> 256
    //   252: aload_0
    //   253: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   256: aload_3
    //   257: invokevirtual 477	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   260: invokevirtual 706	java/io/InputStream:close	()V
    //   263: iconst_0
    //   264: ireturn
    //   265: astore_0
    //   266: aload_0
    //   267: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   270: ifne +7 -> 277
    //   273: aload_0
    //   274: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   277: iconst_0
    //   278: ireturn
    //   279: aload_2
    //   280: ifnull +69 -> 349
    //   283: aload_2
    //   284: invokevirtual 700	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   287: invokevirtual 703	java/io/OutputStream:close	()V
    //   290: goto +15 -> 305
    //   293: astore_1
    //   294: aload_1
    //   295: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   298: ifne +7 -> 305
    //   301: aload_1
    //   302: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   305: aload_2
    //   306: invokevirtual 465	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   309: invokevirtual 706	java/io/InputStream:close	()V
    //   312: goto +15 -> 327
    //   315: astore_1
    //   316: aload_1
    //   317: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   320: ifne +7 -> 327
    //   323: aload_1
    //   324: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   327: aload_2
    //   328: invokevirtual 477	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   331: invokevirtual 706	java/io/InputStream:close	()V
    //   334: goto +15 -> 349
    //   337: astore_1
    //   338: aload_1
    //   339: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   342: ifne +7 -> 349
    //   345: aload_1
    //   346: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   349: aload_0
    //   350: athrow
    //   351: iconst_0
    //   352: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	353	0	paramArrayOfString	String[]
    //   0	353	1	parama	com.tencent.feedback.eup.a<String>
    //   14	314	2	arrayOfString1	String[]
    //   12	245	3	arrayOfString2	String[]
    //   49	37	4	localBufferedReader	java.io.BufferedReader
    //   60	13	5	str	String
    // Exception table:
    //   from	to	target	type
    //   106	113	116	java/io/IOException
    //   128	135	138	java/io/IOException
    //   150	157	160	java/io/IOException
    //   15	23	174	finally
    //   31	51	174	finally
    //   55	62	174	finally
    //   71	78	174	finally
    //   85	90	174	finally
    //   97	102	174	finally
    //   181	188	174	finally
    //   190	194	174	finally
    //   196	208	174	finally
    //   15	23	178	java/lang/Throwable
    //   31	51	178	java/lang/Throwable
    //   55	62	178	java/lang/Throwable
    //   71	78	178	java/lang/Throwable
    //   85	90	178	java/lang/Throwable
    //   97	102	178	java/lang/Throwable
    //   212	219	222	java/io/IOException
    //   234	241	244	java/io/IOException
    //   256	263	265	java/io/IOException
    //   283	290	293	java/io/IOException
    //   305	312	315	java/io/IOException
    //   327	334	337	java/io/IOException
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
    //   0: ldc_w 728
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 95	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: ifnull +226 -> 238
    //   15: ldc_w 730
    //   18: aload_0
    //   19: invokevirtual 733	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   22: ifne +6 -> 28
    //   25: goto +213 -> 238
    //   28: new 735	java/io/ByteArrayOutputStream
    //   31: dup
    //   32: invokespecial 736	java/io/ByteArrayOutputStream:<init>	()V
    //   35: astore_3
    //   36: new 738	java/io/ObjectOutputStream
    //   39: dup
    //   40: aload_3
    //   41: invokespecial 739	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   44: astore_2
    //   45: aload_2
    //   46: astore_1
    //   47: aload_2
    //   48: aload_0
    //   49: invokevirtual 743	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   52: aload_2
    //   53: astore_1
    //   54: aload_2
    //   55: invokevirtual 744	java/io/ObjectOutputStream:flush	()V
    //   58: aload_2
    //   59: astore_1
    //   60: aload_3
    //   61: invokevirtual 747	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   64: astore_0
    //   65: aload_2
    //   66: invokevirtual 748	java/io/ObjectOutputStream:close	()V
    //   69: goto +15 -> 84
    //   72: astore_1
    //   73: aload_1
    //   74: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   77: ifne +7 -> 84
    //   80: aload_1
    //   81: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   84: aload_3
    //   85: invokevirtual 749	java/io/ByteArrayOutputStream:close	()V
    //   88: aload_0
    //   89: areturn
    //   90: astore_1
    //   91: aload_1
    //   92: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   95: ifne +7 -> 102
    //   98: aload_1
    //   99: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   102: aload_0
    //   103: areturn
    //   104: astore_1
    //   105: aload_2
    //   106: astore_0
    //   107: aload_1
    //   108: astore_2
    //   109: goto +12 -> 121
    //   112: astore_0
    //   113: aconst_null
    //   114: astore_1
    //   115: goto +79 -> 194
    //   118: astore_2
    //   119: aconst_null
    //   120: astore_0
    //   121: aload_0
    //   122: astore_1
    //   123: aload_2
    //   124: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   127: ifne +9 -> 136
    //   130: aload_0
    //   131: astore_1
    //   132: aload_2
    //   133: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
    //   136: aload_0
    //   137: astore_1
    //   138: aload_2
    //   139: invokevirtual 709	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   142: iconst_0
    //   143: anewarray 4	java/lang/Object
    //   146: invokestatic 99	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   149: pop
    //   150: aload_0
    //   151: ifnull +22 -> 173
    //   154: aload_0
    //   155: invokevirtual 748	java/io/ObjectOutputStream:close	()V
    //   158: goto +15 -> 173
    //   161: astore_0
    //   162: aload_0
    //   163: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   166: ifne +7 -> 173
    //   169: aload_0
    //   170: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   173: aload_3
    //   174: invokevirtual 749	java/io/ByteArrayOutputStream:close	()V
    //   177: aconst_null
    //   178: areturn
    //   179: astore_0
    //   180: aload_0
    //   181: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   184: ifne +7 -> 191
    //   187: aload_0
    //   188: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   191: aconst_null
    //   192: areturn
    //   193: astore_0
    //   194: aload_1
    //   195: ifnull +22 -> 217
    //   198: aload_1
    //   199: invokevirtual 748	java/io/ObjectOutputStream:close	()V
    //   202: goto +15 -> 217
    //   205: astore_1
    //   206: aload_1
    //   207: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   210: ifne +7 -> 217
    //   213: aload_1
    //   214: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   217: aload_3
    //   218: invokevirtual 749	java/io/ByteArrayOutputStream:close	()V
    //   221: goto +15 -> 236
    //   224: astore_1
    //   225: aload_1
    //   226: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   229: ifne +7 -> 236
    //   232: aload_1
    //   233: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   236: aload_0
    //   237: athrow
    //   238: ldc_w 751
    //   241: iconst_0
    //   242: anewarray 4	java/lang/Object
    //   245: invokestatic 75	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   248: pop
    //   249: aconst_null
    //   250: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	paramObject	Object
    //   46	14	1	localObject1	Object
    //   72	9	1	localIOException1	java.io.IOException
    //   90	9	1	localIOException2	java.io.IOException
    //   104	4	1	localThrowable1	Throwable
    //   114	85	1	localObject2	Object
    //   205	9	1	localIOException3	java.io.IOException
    //   224	9	1	localIOException4	java.io.IOException
    //   44	65	2	localObject3	Object
    //   118	21	2	localThrowable2	Throwable
    //   35	183	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   65	69	72	java/io/IOException
    //   84	88	90	java/io/IOException
    //   47	52	104	java/lang/Throwable
    //   54	58	104	java/lang/Throwable
    //   60	65	104	java/lang/Throwable
    //   36	45	112	finally
    //   36	45	118	java/lang/Throwable
    //   154	158	161	java/io/IOException
    //   173	177	179	java/io/IOException
    //   47	52	193	finally
    //   54	58	193	finally
    //   60	65	193	finally
    //   123	130	193	finally
    //   132	136	193	finally
    //   138	150	193	finally
    //   198	202	205	java/io/IOException
    //   217	221	224	java/io/IOException
  }
  
  /* Error */
  public static byte[] a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 754
    //   3: iload_1
    //   4: invokestatic 757	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   7: invokevirtual 297	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   10: iconst_0
    //   11: anewarray 4	java/lang/Object
    //   14: invokestatic 759	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   17: pop
    //   18: new 37	java/util/ArrayList
    //   21: dup
    //   22: invokespecial 436	java/util/ArrayList:<init>	()V
    //   25: astore_2
    //   26: aload_2
    //   27: invokevirtual 762	java/util/ArrayList:clear	()V
    //   30: aload_2
    //   31: ldc_w 764
    //   34: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   37: pop
    //   38: aload_2
    //   39: ldc_w 766
    //   42: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   45: pop
    //   46: aload_2
    //   47: ldc_w 768
    //   50: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   53: pop
    //   54: aload_2
    //   55: ldc_w 770
    //   58: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   61: pop
    //   62: aload_0
    //   63: ifnull +24 -> 87
    //   66: aload_0
    //   67: invokevirtual 522	java/lang/String:length	()I
    //   70: ifle +17 -> 87
    //   73: aload_2
    //   74: ldc_w 772
    //   77: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   80: pop
    //   81: aload_2
    //   82: aload_0
    //   83: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   86: pop
    //   87: aload_2
    //   88: invokevirtual 64	java/util/ArrayList:size	()I
    //   91: anewarray 137	java/lang/String
    //   94: astore_3
    //   95: aload_2
    //   96: aload_3
    //   97: invokevirtual 776	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   100: pop
    //   101: new 692	com/tencent/feedback/eup/a
    //   104: dup
    //   105: iload_1
    //   106: invokespecial 777	com/tencent/feedback/eup/a:<init>	(I)V
    //   109: astore_0
    //   110: aload_3
    //   111: aload_0
    //   112: invokestatic 779	com/tencent/feedback/proguard/a:a	([Ljava/lang/String;Lcom/tencent/feedback/eup/a;)Z
    //   115: pop
    //   116: aload_0
    //   117: invokevirtual 780	com/tencent/feedback/eup/a:size	()I
    //   120: ifgt +5 -> 125
    //   123: aconst_null
    //   124: areturn
    //   125: new 400	java/lang/StringBuilder
    //   128: dup
    //   129: ldc_w 782
    //   132: invokespecial 403	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   135: astore_2
    //   136: aload_2
    //   137: aload_0
    //   138: invokevirtual 780	com/tencent/feedback/eup/a:size	()I
    //   141: invokevirtual 785	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload_2
    //   146: invokevirtual 408	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: iconst_0
    //   150: anewarray 4	java/lang/Object
    //   153: invokestatic 759	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   156: pop
    //   157: new 327	java/lang/StringBuffer
    //   160: dup
    //   161: invokespecial 330	java/lang/StringBuffer:<init>	()V
    //   164: astore_2
    //   165: aload_0
    //   166: invokevirtual 786	com/tencent/feedback/eup/a:iterator	()Ljava/util/Iterator;
    //   169: astore_3
    //   170: aload_3
    //   171: invokeinterface 424 1 0
    //   176: ifeq +49 -> 225
    //   179: new 400	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 409	java/lang/StringBuilder:<init>	()V
    //   186: astore 4
    //   188: aload 4
    //   190: aload_3
    //   191: invokeinterface 428 1 0
    //   196: checkcast 137	java/lang/String
    //   199: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload 4
    //   205: ldc_w 788
    //   208: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload_2
    //   213: aload 4
    //   215: invokevirtual 408	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokevirtual 431	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   221: pop
    //   222: goto -52 -> 170
    //   225: aload_0
    //   226: invokevirtual 789	com/tencent/feedback/eup/a:clear	()V
    //   229: aload_2
    //   230: invokevirtual 328	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   233: ldc_w 716
    //   236: invokevirtual 550	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   239: astore_0
    //   240: aload_2
    //   241: iconst_0
    //   242: invokevirtual 792	java/lang/StringBuffer:setLength	(I)V
    //   245: ldc_w 794
    //   248: iconst_0
    //   249: anewarray 4	java/lang/Object
    //   252: invokestatic 759	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   255: pop
    //   256: aload_0
    //   257: areturn
    //   258: astore_0
    //   259: goto +39 -> 298
    //   262: astore_0
    //   263: aload_0
    //   264: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   267: ifne +7 -> 274
    //   270: aload_0
    //   271: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
    //   274: ldc_w 796
    //   277: iconst_0
    //   278: anewarray 4	java/lang/Object
    //   281: invokestatic 99	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   284: pop
    //   285: ldc_w 794
    //   288: iconst_0
    //   289: anewarray 4	java/lang/Object
    //   292: invokestatic 759	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   295: pop
    //   296: aconst_null
    //   297: areturn
    //   298: ldc_w 794
    //   301: iconst_0
    //   302: anewarray 4	java/lang/Object
    //   305: invokestatic 759	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   308: pop
    //   309: aload_0
    //   310: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	paramString	String
    //   0	311	1	paramInt	int
    //   25	216	2	localObject1	Object
    //   94	97	3	localObject2	Object
    //   186	28	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   157	170	258	finally
    //   170	222	258	finally
    //   225	245	258	finally
    //   263	274	258	finally
    //   274	285	258	finally
    //   157	170	262	java/lang/Throwable
    //   170	222	262	java/lang/Throwable
    //   225	245	262	java/lang/Throwable
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte != null)
    {
      if (paramInt == -1) {
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
        return null;
      }
    }
    return paramArrayOfByte;
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
      if (!e.a(paramArrayOfByte)) {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    if (paramArrayOfByte != null)
    {
      if (paramInt == -1) {
        return paramArrayOfByte;
      }
      e.b("rqdp{  enD:} %d %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt) });
      if (paramInt != 1) {}
    }
    try
    {
      localObject = new G();
    }
    catch (Throwable paramArrayOfByte)
    {
      Object localObject;
      label86:
      label125:
      do
      {
        break label86;
        localObject = null;
      } while (localObject != null);
    }
    if (paramInt == 3)
    {
      localObject = new F();
      break label125;
      ((H)localObject).a(paramString);
      paramArrayOfByte = ((H)localObject).b(paramArrayOfByte);
      return paramArrayOfByte;
      if (!e.a(paramArrayOfByte)) {
        paramArrayOfByte.printStackTrace();
      }
      e.d("rqdp{  err enD: }%s", new Object[] { paramArrayOfByte.toString() });
      return null;
      return paramArrayOfByte;
    }
    return null;
  }
  
  public static Long[] a(LinkedHashMap<Long, Long> paramLinkedHashMap, long paramLong)
  {
    if ((paramLinkedHashMap != null) && (paramLinkedHashMap.size() > 0))
    {
      long l1 = 0L;
      if (paramLong <= 0L) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramLinkedHashMap.keySet().iterator();
      while ((localIterator.hasNext()) && (l1 < paramLong))
      {
        long l3 = ((Long)localIterator.next()).longValue();
        long l2 = ((Long)paramLinkedHashMap.get(Long.valueOf(l3))).longValue() + l1;
        if (l2 <= paramLong)
        {
          localArrayList.add(Long.valueOf(l3));
          l1 = l2;
        }
      }
      if (localArrayList.size() > 0) {
        return (Long[])localArrayList.toArray(new Long[1]);
      }
      return null;
    }
    return null;
  }
  
  /* Error */
  public static int b(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +16 -> 17
    //   4: ldc_w 847
    //   7: iconst_0
    //   8: anewarray 4	java/lang/Object
    //   11: invokestatic 75	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   14: pop
    //   15: iconst_0
    //   16: ireturn
    //   17: new 171	com/tencent/feedback/proguard/n
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 174	com/tencent/feedback/proguard/n:<init>	(Landroid/content/Context;)V
    //   25: astore_0
    //   26: aload_0
    //   27: invokevirtual 178	com/tencent/feedback/proguard/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   30: astore 6
    //   32: aload 6
    //   34: ifnonnull +43 -> 77
    //   37: aload_0
    //   38: astore_2
    //   39: aload 6
    //   41: astore_3
    //   42: ldc_w 606
    //   45: iconst_0
    //   46: anewarray 4	java/lang/Object
    //   49: invokestatic 99	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   52: pop
    //   53: aload 6
    //   55: ifnull +16 -> 71
    //   58: aload 6
    //   60: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   63: ifeq +8 -> 71
    //   66: aload 6
    //   68: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   71: aload_0
    //   72: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   75: iconst_0
    //   76: ireturn
    //   77: aload_0
    //   78: astore_2
    //   79: aload 6
    //   81: astore_3
    //   82: aload 6
    //   84: ldc 192
    //   86: ldc_w 849
    //   89: iconst_2
    //   90: anewarray 4	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: ldc 202
    //   97: aastore
    //   98: dup
    //   99: iconst_1
    //   100: sipush 510
    //   103: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   106: aastore
    //   107: invokestatic 852	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   110: aconst_null
    //   111: invokevirtual 856	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   114: istore_1
    //   115: aload_0
    //   116: astore_2
    //   117: aload 6
    //   119: astore_3
    //   120: ldc_w 858
    //   123: iconst_2
    //   124: anewarray 4	java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: sipush 510
    //   132: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   135: aastore
    //   136: dup
    //   137: iconst_1
    //   138: iload_1
    //   139: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   142: aastore
    //   143: invokestatic 95	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   146: pop
    //   147: aload 6
    //   149: ifnull +16 -> 165
    //   152: aload 6
    //   154: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   157: ifeq +8 -> 165
    //   160: aload 6
    //   162: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   165: aload_0
    //   166: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   169: iload_1
    //   170: ireturn
    //   171: astore 4
    //   173: aload_0
    //   174: astore 5
    //   176: aload 6
    //   178: astore_0
    //   179: goto +39 -> 218
    //   182: astore 4
    //   184: aconst_null
    //   185: astore_3
    //   186: goto +110 -> 296
    //   189: astore 4
    //   191: aconst_null
    //   192: astore_2
    //   193: aload_0
    //   194: astore 5
    //   196: aload_2
    //   197: astore_0
    //   198: goto +20 -> 218
    //   201: astore 4
    //   203: aconst_null
    //   204: astore_3
    //   205: aload_3
    //   206: astore_0
    //   207: goto +89 -> 296
    //   210: astore 4
    //   212: aconst_null
    //   213: astore 5
    //   215: aload 5
    //   217: astore_0
    //   218: aload 5
    //   220: astore_2
    //   221: aload_0
    //   222: astore_3
    //   223: aload 4
    //   225: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   228: ifne +13 -> 241
    //   231: aload 5
    //   233: astore_2
    //   234: aload_0
    //   235: astore_3
    //   236: aload 4
    //   238: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
    //   241: aload 5
    //   243: astore_2
    //   244: aload_0
    //   245: astore_3
    //   246: ldc_w 860
    //   249: iconst_1
    //   250: anewarray 4	java/lang/Object
    //   253: dup
    //   254: iconst_0
    //   255: aload 4
    //   257: invokevirtual 277	java/lang/Throwable:toString	()Ljava/lang/String;
    //   260: aastore
    //   261: invokestatic 99	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   264: pop
    //   265: aload_0
    //   266: ifnull +14 -> 280
    //   269: aload_0
    //   270: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   273: ifeq +7 -> 280
    //   276: aload_0
    //   277: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   280: aload 5
    //   282: ifnull +8 -> 290
    //   285: aload 5
    //   287: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   290: iconst_0
    //   291: ireturn
    //   292: astore 4
    //   294: aload_2
    //   295: astore_0
    //   296: aload_3
    //   297: ifnull +14 -> 311
    //   300: aload_3
    //   301: invokevirtual 186	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   304: ifeq +7 -> 311
    //   307: aload_3
    //   308: invokevirtual 189	android/database/sqlite/SQLiteDatabase:close	()V
    //   311: aload_0
    //   312: ifnull +7 -> 319
    //   315: aload_0
    //   316: invokevirtual 190	com/tencent/feedback/proguard/n:close	()V
    //   319: aload 4
    //   321: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	paramContext	Context
    //   0	322	1	paramInt	int
    //   38	257	2	localObject1	Object
    //   41	267	3	localObject2	Object
    //   171	1	4	localThrowable1	Throwable
    //   182	1	4	localObject3	Object
    //   189	1	4	localThrowable2	Throwable
    //   201	1	4	localObject4	Object
    //   210	46	4	localThrowable3	Throwable
    //   292	28	4	localObject5	Object
    //   174	112	5	localContext	Context
    //   30	147	6	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   42	53	171	java/lang/Throwable
    //   82	115	171	java/lang/Throwable
    //   120	147	171	java/lang/Throwable
    //   26	32	182	finally
    //   26	32	189	java/lang/Throwable
    //   17	26	201	finally
    //   17	26	210	java/lang/Throwable
    //   42	53	292	finally
    //   82	115	292	finally
    //   120	147	292	finally
    //   223	231	292	finally
    //   236	241	292	finally
    //   246	265	292	finally
  }
  
  public static int b(Context paramContext, p[] paramArrayOfp)
  {
    if (paramContext == null) {
      return -1;
    }
    if (paramArrayOfp == null) {
      return l.a(paramContext, new int[] { 7 }, -1L, 9223372036854775807L);
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfp.length;
    int i = 0;
    while (i < j)
    {
      p localp = paramArrayOfp[i];
      if (localp.a() >= 0L) {
        localArrayList.add(Long.valueOf(localp.a()));
      }
      i += 1;
    }
    if (localArrayList.size() > 0) {
      return l.a(paramContext, (Long[])localArrayList.toArray(new Long[0]));
    }
    return 0;
  }
  
  public static int b(Context paramContext, q[] paramArrayOfq)
  {
    if ((paramContext != null) && (paramArrayOfq != null)) {}
    for (;;)
    {
      int i;
      try
      {
        if (paramArrayOfq.length > 0)
        {
          ArrayList localArrayList = new ArrayList(paramArrayOfq.length);
          int j = paramArrayOfq.length;
          i = 0;
          if (i < j)
          {
            q localq = paramArrayOfq[i];
            if (localq.d() >= 0L) {
              localArrayList.add(Long.valueOf(localq.d()));
            }
          }
          else
          {
            if (localArrayList.size() > 0)
            {
              i = l.a(paramContext, (Long[])localArrayList.toArray(new Long[0]));
              return i;
            }
            return 0;
          }
        }
        else
        {
          e.c("rqdp{  args error}", new Object[0]);
          return 0;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  /* Error */
  public static Object b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc_w 870
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 95	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: ifnull +208 -> 220
    //   15: aload_0
    //   16: arraylength
    //   17: ifge +5 -> 22
    //   20: aconst_null
    //   21: areturn
    //   22: new 872	java/io/ByteArrayInputStream
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 874	java/io/ByteArrayInputStream:<init>	([B)V
    //   30: astore_3
    //   31: new 876	java/io/ObjectInputStream
    //   34: dup
    //   35: aload_3
    //   36: invokespecial 877	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   39: astore_1
    //   40: aload_1
    //   41: astore_0
    //   42: aload_1
    //   43: invokevirtual 880	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   46: astore_2
    //   47: aload_1
    //   48: invokevirtual 881	java/io/ObjectInputStream:close	()V
    //   51: goto +15 -> 66
    //   54: astore_0
    //   55: aload_0
    //   56: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   59: ifne +7 -> 66
    //   62: aload_0
    //   63: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   66: aload_3
    //   67: invokevirtual 882	java/io/ByteArrayInputStream:close	()V
    //   70: aload_2
    //   71: areturn
    //   72: astore_0
    //   73: aload_0
    //   74: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   77: ifne +7 -> 84
    //   80: aload_0
    //   81: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   84: aload_2
    //   85: areturn
    //   86: astore_2
    //   87: goto +12 -> 99
    //   90: astore_0
    //   91: aconst_null
    //   92: astore_1
    //   93: goto +83 -> 176
    //   96: astore_2
    //   97: aconst_null
    //   98: astore_1
    //   99: aload_1
    //   100: astore_0
    //   101: aload_2
    //   102: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   105: ifne +9 -> 114
    //   108: aload_1
    //   109: astore_0
    //   110: aload_2
    //   111: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
    //   114: aload_1
    //   115: astore_0
    //   116: aload_2
    //   117: invokevirtual 709	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   120: iconst_0
    //   121: anewarray 4	java/lang/Object
    //   124: invokestatic 99	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   127: pop
    //   128: aload_1
    //   129: ifnull +22 -> 151
    //   132: aload_1
    //   133: invokevirtual 881	java/io/ObjectInputStream:close	()V
    //   136: goto +15 -> 151
    //   139: astore_0
    //   140: aload_0
    //   141: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   144: ifne +7 -> 151
    //   147: aload_0
    //   148: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   151: aload_3
    //   152: invokevirtual 882	java/io/ByteArrayInputStream:close	()V
    //   155: aconst_null
    //   156: areturn
    //   157: astore_0
    //   158: aload_0
    //   159: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   162: ifne +7 -> 169
    //   165: aload_0
    //   166: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   169: aconst_null
    //   170: areturn
    //   171: astore_2
    //   172: aload_0
    //   173: astore_1
    //   174: aload_2
    //   175: astore_0
    //   176: aload_1
    //   177: ifnull +22 -> 199
    //   180: aload_1
    //   181: invokevirtual 881	java/io/ObjectInputStream:close	()V
    //   184: goto +15 -> 199
    //   187: astore_1
    //   188: aload_1
    //   189: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   192: ifne +7 -> 199
    //   195: aload_1
    //   196: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   199: aload_3
    //   200: invokevirtual 882	java/io/ByteArrayInputStream:close	()V
    //   203: goto +15 -> 218
    //   206: astore_1
    //   207: aload_1
    //   208: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   211: ifne +7 -> 218
    //   214: aload_1
    //   215: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   218: aload_0
    //   219: athrow
    //   220: aconst_null
    //   221: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	paramArrayOfByte	byte[]
    //   39	142	1	localObject1	Object
    //   187	9	1	localIOException1	java.io.IOException
    //   206	9	1	localIOException2	java.io.IOException
    //   46	39	2	localObject2	Object
    //   86	1	2	localThrowable1	Throwable
    //   96	21	2	localThrowable2	Throwable
    //   171	4	2	localObject3	Object
    //   30	170	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   47	51	54	java/io/IOException
    //   66	70	72	java/io/IOException
    //   42	47	86	java/lang/Throwable
    //   31	40	90	finally
    //   31	40	96	java/lang/Throwable
    //   132	136	139	java/io/IOException
    //   151	155	157	java/io/IOException
    //   42	47	171	finally
    //   101	108	171	finally
    //   110	114	171	finally
    //   116	128	171	finally
    //   180	184	187	java/io/IOException
    //   199	203	206	java/io/IOException
  }
  
  /* Error */
  public static String b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +274 -> 275
    //   4: aload_0
    //   5: invokevirtual 522	java/lang/String:length	()I
    //   8: ifne +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 524	java/io/File
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 525	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore_0
    //   22: aload_0
    //   23: invokevirtual 528	java/io/File:exists	()Z
    //   26: ifeq +247 -> 273
    //   29: aload_0
    //   30: invokevirtual 648	java/io/File:canRead	()Z
    //   33: ifne +5 -> 38
    //   36: aconst_null
    //   37: areturn
    //   38: new 650	java/io/FileInputStream
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 653	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   46: astore_2
    //   47: aload_2
    //   48: astore_0
    //   49: ldc_w 886
    //   52: invokestatic 892	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   55: astore_3
    //   56: aload_2
    //   57: astore_0
    //   58: sipush 4096
    //   61: newarray byte
    //   63: astore 4
    //   65: aload_2
    //   66: astore_0
    //   67: aload_2
    //   68: aload 4
    //   70: invokevirtual 674	java/io/FileInputStream:read	([B)I
    //   73: istore_1
    //   74: iload_1
    //   75: iconst_m1
    //   76: if_icmpeq +16 -> 92
    //   79: aload_2
    //   80: astore_0
    //   81: aload_3
    //   82: aload 4
    //   84: iconst_0
    //   85: iload_1
    //   86: invokevirtual 895	java/security/MessageDigest:update	([BII)V
    //   89: goto -24 -> 65
    //   92: aload_2
    //   93: astore_0
    //   94: aload_3
    //   95: invokevirtual 898	java/security/MessageDigest:digest	()[B
    //   98: invokestatic 901	com/tencent/feedback/proguard/a:e	([B)Ljava/lang/String;
    //   101: astore_3
    //   102: aload_2
    //   103: invokevirtual 682	java/io/FileInputStream:close	()V
    //   106: aload_3
    //   107: areturn
    //   108: astore_0
    //   109: aload_0
    //   110: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   113: ifne +7 -> 120
    //   116: aload_0
    //   117: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   120: aload_3
    //   121: areturn
    //   122: astore_3
    //   123: goto +16 -> 139
    //   126: astore_3
    //   127: goto +68 -> 195
    //   130: astore_2
    //   131: aconst_null
    //   132: astore_0
    //   133: goto +115 -> 248
    //   136: astore_3
    //   137: aconst_null
    //   138: astore_2
    //   139: aload_2
    //   140: astore_0
    //   141: aload_3
    //   142: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   145: ifne +9 -> 154
    //   148: aload_2
    //   149: astore_0
    //   150: aload_3
    //   151: invokevirtual 902	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   154: aload_2
    //   155: astore_0
    //   156: aload_3
    //   157: invokevirtual 903	java/security/NoSuchAlgorithmException:getMessage	()Ljava/lang/String;
    //   160: iconst_0
    //   161: anewarray 4	java/lang/Object
    //   164: invokestatic 99	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   167: pop
    //   168: aload_2
    //   169: ifnull +76 -> 245
    //   172: aload_2
    //   173: invokevirtual 682	java/io/FileInputStream:close	()V
    //   176: aconst_null
    //   177: areturn
    //   178: astore_0
    //   179: aload_0
    //   180: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   183: ifne +62 -> 245
    //   186: aload_0
    //   187: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   190: aconst_null
    //   191: areturn
    //   192: astore_3
    //   193: aconst_null
    //   194: astore_2
    //   195: aload_2
    //   196: astore_0
    //   197: aload_3
    //   198: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   201: ifne +9 -> 210
    //   204: aload_2
    //   205: astore_0
    //   206: aload_3
    //   207: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   210: aload_2
    //   211: astore_0
    //   212: aload_3
    //   213: invokevirtual 904	java/io/IOException:getMessage	()Ljava/lang/String;
    //   216: iconst_0
    //   217: anewarray 4	java/lang/Object
    //   220: invokestatic 99	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   223: pop
    //   224: aload_2
    //   225: ifnull +20 -> 245
    //   228: aload_2
    //   229: invokevirtual 682	java/io/FileInputStream:close	()V
    //   232: aconst_null
    //   233: areturn
    //   234: astore_0
    //   235: aload_0
    //   236: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   239: ifne +6 -> 245
    //   242: goto -56 -> 186
    //   245: aconst_null
    //   246: areturn
    //   247: astore_2
    //   248: aload_0
    //   249: ifnull +22 -> 271
    //   252: aload_0
    //   253: invokevirtual 682	java/io/FileInputStream:close	()V
    //   256: goto +15 -> 271
    //   259: astore_0
    //   260: aload_0
    //   261: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   264: ifne +7 -> 271
    //   267: aload_0
    //   268: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   271: aload_2
    //   272: athrow
    //   273: aconst_null
    //   274: areturn
    //   275: aconst_null
    //   276: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	paramString	String
    //   73	13	1	i	int
    //   46	57	2	localFileInputStream	java.io.FileInputStream
    //   130	1	2	localObject1	Object
    //   138	91	2	localObject2	Object
    //   247	25	2	localObject3	Object
    //   55	66	3	localObject4	Object
    //   122	1	3	localNoSuchAlgorithmException1	NoSuchAlgorithmException
    //   126	1	3	localIOException1	java.io.IOException
    //   136	21	3	localNoSuchAlgorithmException2	NoSuchAlgorithmException
    //   192	21	3	localIOException2	java.io.IOException
    //   63	20	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   102	106	108	java/io/IOException
    //   49	56	122	java/security/NoSuchAlgorithmException
    //   58	65	122	java/security/NoSuchAlgorithmException
    //   67	74	122	java/security/NoSuchAlgorithmException
    //   81	89	122	java/security/NoSuchAlgorithmException
    //   94	102	122	java/security/NoSuchAlgorithmException
    //   49	56	126	java/io/IOException
    //   58	65	126	java/io/IOException
    //   67	74	126	java/io/IOException
    //   81	89	126	java/io/IOException
    //   94	102	126	java/io/IOException
    //   38	47	130	finally
    //   38	47	136	java/security/NoSuchAlgorithmException
    //   172	176	178	java/io/IOException
    //   38	47	192	java/io/IOException
    //   228	232	234	java/io/IOException
    //   49	56	247	finally
    //   58	65	247	finally
    //   67	74	247	finally
    //   81	89	247	finally
    //   94	102	247	finally
    //   141	148	247	finally
    //   150	154	247	finally
    //   156	168	247	finally
    //   197	204	247	finally
    //   206	210	247	finally
    //   212	224	247	finally
    //   252	256	259	java/io/IOException
  }
  
  public static Map<String, String> b()
  {
    Object localObject = Thread.getAllStackTraces();
    HashMap localHashMap;
    if (localObject != null)
    {
      localHashMap = new HashMap();
      StringBuilder localStringBuilder1 = new StringBuilder();
      try
      {
        localObject = ((Map)localObject).entrySet().iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
            localStringBuilder1.setLength(0);
            try
            {
              StackTraceElement[] arrayOfStackTraceElement = (StackTraceElement[])localEntry.getValue();
              int j = arrayOfStackTraceElement.length;
              int i = 0;
              while (i < j)
              {
                localStringBuilder1.append(arrayOfStackTraceElement[i].toString());
                localStringBuilder1.append("\n");
                i += 1;
              }
            }
            catch (Throwable localThrowable2)
            {
              StringBuilder localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append(localThrowable2.getClass().getName());
              localStringBuilder2.append(":");
              localStringBuilder2.append(localThrowable2.getMessage());
              e.d("add frame error %s", new Object[] { localStringBuilder2.toString() });
              localHashMap.put(((Thread)localEntry.getKey()).getName(), localStringBuilder1.toString());
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
    if (paramArrayOfByte != null)
    {
      if (paramInt == -1) {
        return paramArrayOfByte;
      }
      e.b("rqdp{  unzp:} %s rqdp{  len:} %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) });
      try
      {
        localObject = B.a(paramInt);
        if (localObject == null) {
          return null;
        }
        paramArrayOfByte = ((C)localObject).b(paramArrayOfByte);
        return paramArrayOfByte;
      }
      catch (Throwable paramArrayOfByte)
      {
        if (!e.a(paramArrayOfByte)) {
          paramArrayOfByte.printStackTrace();
        }
        Object localObject = new StringBuilder("rqdp{  err unzp}");
        ((StringBuilder)localObject).append(paramArrayOfByte.toString());
        e.d(((StringBuilder)localObject).toString(), new Object[0]);
        return null;
      }
    }
    return paramArrayOfByte;
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
    if (paramArrayOfByte != null)
    {
      if (paramInt == -1) {
        return paramArrayOfByte;
      }
      if (paramInt != 1) {}
    }
    try
    {
      localObject = new G();
    }
    catch (Throwable paramArrayOfByte)
    {
      Object localObject;
      label60:
      label99:
      do
      {
        break label60;
        localObject = null;
      } while (localObject != null);
    }
    if (paramInt == 3)
    {
      localObject = new F();
      break label99;
      ((H)localObject).a(paramString);
      paramArrayOfByte = ((H)localObject).a(paramArrayOfByte);
      return paramArrayOfByte;
      if (!e.a(paramArrayOfByte)) {
        paramArrayOfByte.printStackTrace();
      }
      e.d("rqdp{  err unD:} %s", new Object[] { paramArrayOfByte.toString() });
      return null;
      return paramArrayOfByte;
    }
    return null;
  }
  
  public static q[] b(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null)) {}
    try
    {
      paramString = l.a(paramContext, new int[] { 9 }, -1, -1, 10000L, -1, paramString, -1, -1, -1, -1, -1L, 9223372036854775807L);
      if ((paramString != null) && (paramString.size() > 0))
      {
        paramContext = new ArrayList(paramString.size());
        paramString = paramString.iterator();
        while (paramString.hasNext())
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
        if (paramContext.size() > 0)
        {
          paramContext = (q[])paramContext.toArray(new q[0]);
          return paramContext;
        }
        return null;
      }
      return null;
    }
    finally {}
    e.c("rqdp{  args error}", new Object[0]);
    return null;
  }
  
  public static int c(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null)) {}
    try
    {
      int i = l.a(paramContext, new int[] { 9 }, -1L, 9223372036854775807L, paramString);
      return i;
    }
    finally {}
    e.c("rqdp{  args error}", new Object[0]);
    return 0;
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
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
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
        return null;
      }
    }
    return "NULL";
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
    if (paramString != null)
    {
      if (paramT != null)
      {
        if (!(paramT instanceof Set))
        {
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
          return;
        }
        throw new IllegalArgumentException("can not support Set");
      }
      throw new IllegalArgumentException("put value can not is null");
    }
    throw new IllegalArgumentException("put key can not is null");
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