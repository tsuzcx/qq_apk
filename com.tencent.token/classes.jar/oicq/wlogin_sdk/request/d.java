package oicq.wlogin_sdk.request;

import android.content.Context;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.BufferOverflowException;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class d
{
  private static final Object f = new Object();
  private static final Object g = new Object();
  private static b h = null;
  private static b i = null;
  Context a;
  WloginLastLoginInfo b = new WloginLastLoginInfo();
  TreeMap<Long, WloginAllSigInfo> c = new TreeMap();
  TreeMap<String, UinInfo> d = new TreeMap();
  public int e;
  
  public d(Context paramContext)
  {
    this.a = paramContext;
    this.d = a(this.a, "name_file", 0L);
    if (this.d == null) {
      this.d = new TreeMap();
    }
  }
  
  /* Error */
  public static int a(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 60
    //   3: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifeq +33 -> 39
    //   9: getstatic 32	oicq/wlogin_sdk/request/d:h	Loicq/wlogin_sdk/request/b;
    //   12: ifnonnull +17 -> 29
    //   15: new 68	oicq/wlogin_sdk/request/b
    //   18: dup
    //   19: aload_0
    //   20: aload_1
    //   21: aconst_null
    //   22: iconst_1
    //   23: invokespecial 71	oicq/wlogin_sdk/request/b:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   26: putstatic 32	oicq/wlogin_sdk/request/d:h	Loicq/wlogin_sdk/request/b;
    //   29: getstatic 32	oicq/wlogin_sdk/request/d:h	Loicq/wlogin_sdk/request/b;
    //   32: invokevirtual 75	oicq/wlogin_sdk/request/b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   35: astore_0
    //   36: goto +30 -> 66
    //   39: getstatic 34	oicq/wlogin_sdk/request/d:i	Loicq/wlogin_sdk/request/b;
    //   42: ifnonnull +17 -> 59
    //   45: new 68	oicq/wlogin_sdk/request/b
    //   48: dup
    //   49: aload_0
    //   50: aload_1
    //   51: aconst_null
    //   52: iconst_1
    //   53: invokespecial 71	oicq/wlogin_sdk/request/b:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   56: putstatic 34	oicq/wlogin_sdk/request/d:i	Loicq/wlogin_sdk/request/b;
    //   59: getstatic 34	oicq/wlogin_sdk/request/d:i	Loicq/wlogin_sdk/request/b;
    //   62: invokevirtual 75	oicq/wlogin_sdk/request/b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   65: astore_0
    //   66: aload_0
    //   67: invokevirtual 81	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   70: invokestatic 84	oicq/wlogin_sdk/request/d:c	(Ljava/lang/String;)V
    //   73: new 86	java/lang/StringBuilder
    //   76: dup
    //   77: ldc 88
    //   79: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   82: astore_3
    //   83: aload_3
    //   84: aload_1
    //   85: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload_3
    //   90: ldc 96
    //   92: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_3
    //   97: aload_1
    //   98: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_3
    //   103: ldc 98
    //   105: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload_0
    //   110: aload_3
    //   111: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokevirtual 104	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   117: aload_0
    //   118: aload_1
    //   119: iconst_1
    //   120: anewarray 62	java/lang/String
    //   123: dup
    //   124: iconst_0
    //   125: ldc 106
    //   127: aastore
    //   128: ldc 108
    //   130: aconst_null
    //   131: aconst_null
    //   132: aconst_null
    //   133: aconst_null
    //   134: invokevirtual 112	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   137: astore 5
    //   139: aload 5
    //   141: astore_3
    //   142: aload_0
    //   143: astore 4
    //   145: aload 5
    //   147: invokeinterface 118 1 0
    //   152: ifne +106 -> 258
    //   155: aload 5
    //   157: astore_3
    //   158: aload_0
    //   159: astore 4
    //   161: new 86	java/lang/StringBuilder
    //   164: dup
    //   165: ldc 120
    //   167: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   170: astore 6
    //   172: aload 5
    //   174: astore_3
    //   175: aload_0
    //   176: astore 4
    //   178: aload 6
    //   180: aload_1
    //   181: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 5
    //   187: astore_3
    //   188: aload_0
    //   189: astore 4
    //   191: aload 6
    //   193: ldc 122
    //   195: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload 5
    //   201: astore_3
    //   202: aload_0
    //   203: astore 4
    //   205: aload 6
    //   207: aload_1
    //   208: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload 5
    //   214: astore_3
    //   215: aload_0
    //   216: astore 4
    //   218: aload 6
    //   220: ldc 124
    //   222: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 5
    //   228: astore_3
    //   229: aload_0
    //   230: astore 4
    //   232: aload_0
    //   233: aload 6
    //   235: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: iconst_2
    //   239: anewarray 4	java/lang/Object
    //   242: dup
    //   243: iconst_0
    //   244: iconst_0
    //   245: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   248: aastore
    //   249: dup
    //   250: iconst_1
    //   251: iconst_1
    //   252: newarray byte
    //   254: aastore
    //   255: invokevirtual 133	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   258: aload 5
    //   260: astore_3
    //   261: aload_0
    //   262: astore 4
    //   264: new 86	java/lang/StringBuilder
    //   267: dup
    //   268: ldc 135
    //   270: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   273: astore 6
    //   275: aload 5
    //   277: astore_3
    //   278: aload_0
    //   279: astore 4
    //   281: aload 6
    //   283: aload_1
    //   284: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 5
    //   290: astore_3
    //   291: aload_0
    //   292: astore 4
    //   294: aload 6
    //   296: ldc 137
    //   298: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload 5
    //   304: astore_3
    //   305: aload_0
    //   306: astore 4
    //   308: aload 6
    //   310: aload_1
    //   311: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload 5
    //   317: astore_3
    //   318: aload_0
    //   319: astore 4
    //   321: aload 6
    //   323: ldc 139
    //   325: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload 5
    //   331: astore_3
    //   332: aload_0
    //   333: astore 4
    //   335: aload_0
    //   336: aload 6
    //   338: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: iconst_1
    //   342: anewarray 4	java/lang/Object
    //   345: dup
    //   346: iconst_0
    //   347: aload_2
    //   348: aastore
    //   349: invokevirtual 133	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   352: aload 5
    //   354: ifnull +20 -> 374
    //   357: aload 5
    //   359: invokeinterface 143 1 0
    //   364: ifne +10 -> 374
    //   367: aload 5
    //   369: invokeinterface 146 1 0
    //   374: aload_0
    //   375: ifnull +22 -> 397
    //   378: iconst_1
    //   379: aload_0
    //   380: invokevirtual 149	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   383: if_icmpne +14 -> 397
    //   386: ldc 151
    //   388: ldc 153
    //   390: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   393: aload_0
    //   394: invokevirtual 160	android/database/sqlite/SQLiteDatabase:close	()V
    //   397: iconst_0
    //   398: ireturn
    //   399: astore_3
    //   400: aload 5
    //   402: astore_2
    //   403: aload_3
    //   404: astore 5
    //   406: goto +30 -> 436
    //   409: astore_1
    //   410: aconst_null
    //   411: astore_3
    //   412: goto +165 -> 577
    //   415: astore 5
    //   417: aconst_null
    //   418: astore_2
    //   419: goto +17 -> 436
    //   422: astore_1
    //   423: aconst_null
    //   424: astore_0
    //   425: aload_0
    //   426: astore_3
    //   427: goto +150 -> 577
    //   430: astore 5
    //   432: aconst_null
    //   433: astore_0
    //   434: aload_0
    //   435: astore_2
    //   436: aload_2
    //   437: astore_3
    //   438: aload_0
    //   439: astore 4
    //   441: aload_1
    //   442: ldc 60
    //   444: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   447: ifeq +15 -> 462
    //   450: aload_2
    //   451: astore_3
    //   452: aload_0
    //   453: astore 4
    //   455: aconst_null
    //   456: putstatic 32	oicq/wlogin_sdk/request/d:h	Loicq/wlogin_sdk/request/b;
    //   459: goto +12 -> 471
    //   462: aload_2
    //   463: astore_3
    //   464: aload_0
    //   465: astore 4
    //   467: aconst_null
    //   468: putstatic 34	oicq/wlogin_sdk/request/d:i	Loicq/wlogin_sdk/request/b;
    //   471: aload_2
    //   472: astore_3
    //   473: aload_0
    //   474: astore 4
    //   476: aload 5
    //   478: ldc 153
    //   480: invokestatic 164	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   483: aload_2
    //   484: astore_3
    //   485: aload_0
    //   486: astore 4
    //   488: new 86	java/lang/StringBuilder
    //   491: dup
    //   492: ldc 166
    //   494: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   497: astore_1
    //   498: aload_2
    //   499: astore_3
    //   500: aload_0
    //   501: astore 4
    //   503: aload_1
    //   504: aload 5
    //   506: invokevirtual 169	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   509: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: pop
    //   513: aload_2
    //   514: astore_3
    //   515: aload_0
    //   516: astore 4
    //   518: aload_1
    //   519: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: ldc 153
    //   524: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   527: aload_2
    //   528: ifnull +18 -> 546
    //   531: aload_2
    //   532: invokeinterface 143 1 0
    //   537: ifne +9 -> 546
    //   540: aload_2
    //   541: invokeinterface 146 1 0
    //   546: aload_0
    //   547: ifnull +22 -> 569
    //   550: iconst_1
    //   551: aload_0
    //   552: invokevirtual 149	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   555: if_icmpne +14 -> 569
    //   558: ldc 151
    //   560: ldc 153
    //   562: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   565: aload_0
    //   566: invokevirtual 160	android/database/sqlite/SQLiteDatabase:close	()V
    //   569: sipush -1022
    //   572: ireturn
    //   573: astore_1
    //   574: aload 4
    //   576: astore_0
    //   577: aload_3
    //   578: ifnull +18 -> 596
    //   581: aload_3
    //   582: invokeinterface 143 1 0
    //   587: ifne +9 -> 596
    //   590: aload_3
    //   591: invokeinterface 146 1 0
    //   596: aload_0
    //   597: ifnull +22 -> 619
    //   600: iconst_1
    //   601: aload_0
    //   602: invokevirtual 149	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   605: if_icmpne +14 -> 619
    //   608: ldc 151
    //   610: ldc 153
    //   612: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   615: aload_0
    //   616: invokevirtual 160	android/database/sqlite/SQLiteDatabase:close	()V
    //   619: aload_1
    //   620: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	621	0	paramContext	Context
    //   0	621	1	paramString	String
    //   0	621	2	paramArrayOfByte	byte[]
    //   82	250	3	localObject1	Object
    //   399	5	3	localException1	Exception
    //   411	180	3	localObject2	Object
    //   143	432	4	localContext	Context
    //   137	268	5	localObject3	Object
    //   415	1	5	localException2	Exception
    //   430	75	5	localException3	Exception
    //   170	167	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   145	155	399	java/lang/Exception
    //   161	172	399	java/lang/Exception
    //   178	185	399	java/lang/Exception
    //   191	199	399	java/lang/Exception
    //   205	212	399	java/lang/Exception
    //   218	226	399	java/lang/Exception
    //   232	258	399	java/lang/Exception
    //   264	275	399	java/lang/Exception
    //   281	288	399	java/lang/Exception
    //   294	302	399	java/lang/Exception
    //   308	315	399	java/lang/Exception
    //   321	329	399	java/lang/Exception
    //   335	352	399	java/lang/Exception
    //   66	139	409	finally
    //   66	139	415	java/lang/Exception
    //   0	29	422	finally
    //   29	36	422	finally
    //   39	59	422	finally
    //   59	66	422	finally
    //   0	29	430	java/lang/Exception
    //   29	36	430	java/lang/Exception
    //   39	59	430	java/lang/Exception
    //   59	66	430	java/lang/Exception
    //   145	155	573	finally
    //   161	172	573	finally
    //   178	185	573	finally
    //   191	199	573	finally
    //   205	212	573	finally
    //   218	226	573	finally
    //   232	258	573	finally
    //   264	275	573	finally
    //   281	288	573	finally
    //   294	302	573	finally
    //   308	315	573	finally
    //   321	329	573	finally
    //   335	352	573	finally
    //   441	450	573	finally
    //   455	459	573	finally
    //   467	471	573	finally
    //   476	483	573	finally
    //   488	498	573	finally
    //   503	513	573	finally
    //   518	527	573	finally
  }
  
  public static int a(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    int j = paramInt;
    while (j < paramArrayOfByte1.length - paramArrayOfByte2.length - paramInt)
    {
      int m = 0;
      int k = 0;
      while (k < paramArrayOfByte2.length)
      {
        if (paramArrayOfByte1[(j + k)] != paramArrayOfByte2[k])
        {
          k = m;
          break label58;
        }
        k += 1;
      }
      k = 1;
      label58:
      if (k != 0) {
        return j;
      }
      j += 1;
    }
    return -1;
  }
  
  public static TreeMap a(Context paramContext, String paramString, long paramLong)
  {
    util.LOGI("loadTKTreeMap sigfile ".concat(String.valueOf(paramString)), "");
    Object localObject1 = a(paramContext, paramString);
    if (localObject1 != null)
    {
      Object localObject2 = new StringBuilder("loadTKTreeMap len:");
      ((StringBuilder)localObject2).append(localObject1.length);
      ((StringBuilder)localObject2).append(" at ");
      ((StringBuilder)localObject2).append(t.l());
      util.LOGI(((StringBuilder)localObject2).toString(), "");
      try
      {
        localObject2 = cryptor.decrypt((byte[])localObject1, 0, localObject1.length, t.B);
        if (localObject2 != null)
        {
          localObject2 = new ByteArrayInputStream((byte[])localObject2);
          localObject3 = new ObjectInputStream((InputStream)localObject2);
          localObject1 = (TreeMap)((ObjectInputStream)localObject3).readObject();
          ((ObjectInputStream)localObject3).close();
          ((ByteArrayInputStream)localObject2).close();
          if (localObject1 != null)
          {
            localObject2 = new StringBuilder("loadTKTreeMap tree size: ");
            ((StringBuilder)localObject2).append(((TreeMap)localObject1).size());
            util.LOGI(((StringBuilder)localObject2).toString(), "");
            boolean bool = "tk_file".equals(paramString);
            if (bool) {
              if (0L != paramLong) {}
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject3;
        label202:
        Object localObject4;
        StringBuilder localStringBuilder;
        util.printThrowable(localThrowable, "");
      }
    }
    try
    {
      localObject2 = ((TreeMap)localObject1).keySet().iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label576;
      }
      localObject3 = ((Iterator)localObject2).next();
      localObject4 = (WloginAllSigInfo)((TreeMap)localObject1).get(localObject3);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(localObject3);
      localStringBuilder.append(" allsig: ");
      localStringBuilder.append(((WloginAllSigInfo)localObject4)._tk_map);
      util.LOGI(localStringBuilder.toString(), String.valueOf(localObject3));
      break label202;
      localObject2 = (WloginAllSigInfo)((TreeMap)localObject1).get(Long.valueOf(paramLong));
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramLong);
      ((StringBuilder)localObject3).append(" allsig: ");
      ((StringBuilder)localObject3).append(((WloginAllSigInfo)localObject2)._tk_map);
      util.LOGI(((StringBuilder)localObject3).toString(), String.valueOf(paramLong));
      return localObject1;
    }
    catch (Exception paramContext) {}
    localObject2 = ((TreeMap)localObject1).keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      localObject4 = (UinInfo)((TreeMap)localObject1).get(localObject3);
      if (localObject4 != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localObject3);
        localStringBuilder.append(" is uin: ");
        localStringBuilder.append(((UinInfo)localObject4)._uin);
        util.LOGI(localStringBuilder.toString(), "");
      }
    }
    util.LOGI("tree is null", "");
    return null;
    localObject3 = new SecretKeySpec(t.B, "DESede");
    localObject2 = Cipher.getInstance("DESede");
    ((Cipher)localObject2).init(2, (Key)localObject3);
    localObject1 = new ByteArrayInputStream((byte[])localObject1);
    localObject2 = new ObjectInputStream(new CipherInputStream((InputStream)localObject1, (Cipher)localObject2));
    localObject3 = (TreeMap)((ObjectInputStream)localObject2).readObject();
    if (localObject3 != null)
    {
      ((ObjectInputStream)localObject2).close();
      ((ByteArrayInputStream)localObject1).close();
      return localObject3;
      util.LOGI("dbdata is null", "");
    }
    return b(paramContext, paramString);
    label576:
    return localThrowable;
  }
  
  /* Error */
  public static byte[] a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 318	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3: astore 7
    //   5: aconst_null
    //   6: astore 4
    //   8: aload_1
    //   9: ldc 60
    //   11: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: ifeq +33 -> 47
    //   17: getstatic 32	oicq/wlogin_sdk/request/d:h	Loicq/wlogin_sdk/request/b;
    //   20: ifnonnull +17 -> 37
    //   23: new 68	oicq/wlogin_sdk/request/b
    //   26: dup
    //   27: aload_0
    //   28: aload_1
    //   29: aconst_null
    //   30: iconst_1
    //   31: invokespecial 71	oicq/wlogin_sdk/request/b:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   34: putstatic 32	oicq/wlogin_sdk/request/d:h	Loicq/wlogin_sdk/request/b;
    //   37: getstatic 32	oicq/wlogin_sdk/request/d:h	Loicq/wlogin_sdk/request/b;
    //   40: invokevirtual 321	oicq/wlogin_sdk/request/b:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   43: astore_0
    //   44: goto +30 -> 74
    //   47: getstatic 34	oicq/wlogin_sdk/request/d:i	Loicq/wlogin_sdk/request/b;
    //   50: ifnonnull +17 -> 67
    //   53: new 68	oicq/wlogin_sdk/request/b
    //   56: dup
    //   57: aload_0
    //   58: aload_1
    //   59: aconst_null
    //   60: iconst_1
    //   61: invokespecial 71	oicq/wlogin_sdk/request/b:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   64: putstatic 34	oicq/wlogin_sdk/request/d:i	Loicq/wlogin_sdk/request/b;
    //   67: getstatic 34	oicq/wlogin_sdk/request/d:i	Loicq/wlogin_sdk/request/b;
    //   70: invokevirtual 321	oicq/wlogin_sdk/request/b:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 81	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   78: invokestatic 84	oicq/wlogin_sdk/request/d:c	(Ljava/lang/String;)V
    //   81: new 86	java/lang/StringBuilder
    //   84: dup
    //   85: ldc_w 323
    //   88: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: astore_3
    //   92: aload_3
    //   93: aload_1
    //   94: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload_3
    //   99: ldc_w 325
    //   102: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload_0
    //   107: aload_3
    //   108: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: aconst_null
    //   112: invokevirtual 329	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   115: astore_3
    //   116: aload 7
    //   118: astore 4
    //   120: aload_3
    //   121: astore 6
    //   123: aload_0
    //   124: astore 5
    //   126: aload_3
    //   127: invokeinterface 332 1 0
    //   132: ifeq +34 -> 166
    //   135: aload 7
    //   137: astore 4
    //   139: aload_3
    //   140: astore 6
    //   142: aload_0
    //   143: astore 5
    //   145: aload_3
    //   146: iconst_0
    //   147: invokeinterface 336 2 0
    //   152: ifle +14 -> 166
    //   155: aload_3
    //   156: astore 6
    //   158: aload_0
    //   159: astore 5
    //   161: getstatic 339	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   164: astore 4
    //   166: aload_3
    //   167: ifnull +30 -> 197
    //   170: aload_3
    //   171: astore 6
    //   173: aload_0
    //   174: astore 5
    //   176: aload_3
    //   177: invokeinterface 143 1 0
    //   182: ifne +15 -> 197
    //   185: aload_3
    //   186: astore 6
    //   188: aload_0
    //   189: astore 5
    //   191: aload_3
    //   192: invokeinterface 146 1 0
    //   197: aload_3
    //   198: astore 6
    //   200: aload_0
    //   201: astore 5
    //   203: aload 4
    //   205: invokevirtual 342	java/lang/Boolean:booleanValue	()Z
    //   208: istore_2
    //   209: iload_2
    //   210: ifne +48 -> 258
    //   213: aload_3
    //   214: ifnull +18 -> 232
    //   217: aload_3
    //   218: invokeinterface 143 1 0
    //   223: ifne +9 -> 232
    //   226: aload_3
    //   227: invokeinterface 146 1 0
    //   232: aload_0
    //   233: ifnull +23 -> 256
    //   236: iconst_1
    //   237: aload_0
    //   238: invokevirtual 149	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   241: if_icmpne +15 -> 256
    //   244: ldc_w 344
    //   247: ldc 153
    //   249: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: aload_0
    //   253: invokevirtual 160	android/database/sqlite/SQLiteDatabase:close	()V
    //   256: aconst_null
    //   257: areturn
    //   258: aload_3
    //   259: astore 6
    //   261: aload_0
    //   262: astore 5
    //   264: aload_0
    //   265: aload_1
    //   266: iconst_1
    //   267: anewarray 62	java/lang/String
    //   270: dup
    //   271: iconst_0
    //   272: aload_1
    //   273: aastore
    //   274: ldc 108
    //   276: aconst_null
    //   277: aconst_null
    //   278: aconst_null
    //   279: aconst_null
    //   280: invokevirtual 112	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   283: astore 4
    //   285: aload 4
    //   287: ifnonnull +51 -> 338
    //   290: aload 4
    //   292: ifnull +20 -> 312
    //   295: aload 4
    //   297: invokeinterface 143 1 0
    //   302: ifne +10 -> 312
    //   305: aload 4
    //   307: invokeinterface 146 1 0
    //   312: aload_0
    //   313: ifnull +23 -> 336
    //   316: iconst_1
    //   317: aload_0
    //   318: invokevirtual 149	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   321: if_icmpne +15 -> 336
    //   324: ldc_w 344
    //   327: ldc 153
    //   329: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   332: aload_0
    //   333: invokevirtual 160	android/database/sqlite/SQLiteDatabase:close	()V
    //   336: aconst_null
    //   337: areturn
    //   338: aload 4
    //   340: invokeinterface 347 1 0
    //   345: ifeq +67 -> 412
    //   348: aload 4
    //   350: iconst_0
    //   351: invokeinterface 351 2 0
    //   356: astore_3
    //   357: aload 4
    //   359: invokeinterface 146 1 0
    //   364: aload 4
    //   366: ifnull +20 -> 386
    //   369: aload 4
    //   371: invokeinterface 143 1 0
    //   376: ifne +10 -> 386
    //   379: aload 4
    //   381: invokeinterface 146 1 0
    //   386: aload_0
    //   387: ifnull +23 -> 410
    //   390: iconst_1
    //   391: aload_0
    //   392: invokevirtual 149	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   395: if_icmpne +15 -> 410
    //   398: ldc_w 344
    //   401: ldc 153
    //   403: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   406: aload_0
    //   407: invokevirtual 160	android/database/sqlite/SQLiteDatabase:close	()V
    //   410: aload_3
    //   411: areturn
    //   412: aload 4
    //   414: invokeinterface 146 1 0
    //   419: aload 4
    //   421: ifnull +20 -> 441
    //   424: aload 4
    //   426: invokeinterface 143 1 0
    //   431: ifne +10 -> 441
    //   434: aload 4
    //   436: invokeinterface 146 1 0
    //   441: aload_0
    //   442: ifnull +23 -> 465
    //   445: iconst_1
    //   446: aload_0
    //   447: invokevirtual 149	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   450: if_icmpne +15 -> 465
    //   453: ldc_w 344
    //   456: ldc 153
    //   458: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   461: aload_0
    //   462: invokevirtual 160	android/database/sqlite/SQLiteDatabase:close	()V
    //   465: aconst_null
    //   466: areturn
    //   467: astore_3
    //   468: aload 4
    //   470: astore_1
    //   471: aload_0
    //   472: astore 5
    //   474: aload_3
    //   475: astore_0
    //   476: goto +155 -> 631
    //   479: astore 5
    //   481: aload 4
    //   483: astore_3
    //   484: aload 5
    //   486: astore 4
    //   488: goto +43 -> 531
    //   491: astore 4
    //   493: goto +38 -> 531
    //   496: astore_3
    //   497: aload 4
    //   499: astore_1
    //   500: aload_0
    //   501: astore 5
    //   503: aload_3
    //   504: astore_0
    //   505: goto +126 -> 631
    //   508: astore 4
    //   510: aconst_null
    //   511: astore_3
    //   512: goto +19 -> 531
    //   515: astore_0
    //   516: aconst_null
    //   517: astore 5
    //   519: aload 4
    //   521: astore_1
    //   522: goto +109 -> 631
    //   525: astore 4
    //   527: aconst_null
    //   528: astore_0
    //   529: aload_0
    //   530: astore_3
    //   531: aload_3
    //   532: astore 6
    //   534: aload_0
    //   535: astore 5
    //   537: aload_1
    //   538: ldc 60
    //   540: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   543: ifeq +16 -> 559
    //   546: aload_3
    //   547: astore 6
    //   549: aload_0
    //   550: astore 5
    //   552: aconst_null
    //   553: putstatic 32	oicq/wlogin_sdk/request/d:h	Loicq/wlogin_sdk/request/b;
    //   556: goto +13 -> 569
    //   559: aload_3
    //   560: astore 6
    //   562: aload_0
    //   563: astore 5
    //   565: aconst_null
    //   566: putstatic 34	oicq/wlogin_sdk/request/d:i	Loicq/wlogin_sdk/request/b;
    //   569: aload_3
    //   570: astore 6
    //   572: aload_0
    //   573: astore 5
    //   575: aload 4
    //   577: ldc 153
    //   579: invokestatic 164	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   582: aload_3
    //   583: ifnull +18 -> 601
    //   586: aload_3
    //   587: invokeinterface 143 1 0
    //   592: ifne +9 -> 601
    //   595: aload_3
    //   596: invokeinterface 146 1 0
    //   601: aload_0
    //   602: ifnull +23 -> 625
    //   605: iconst_1
    //   606: aload_0
    //   607: invokevirtual 149	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   610: if_icmpne +15 -> 625
    //   613: ldc_w 344
    //   616: ldc 153
    //   618: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   621: aload_0
    //   622: invokevirtual 160	android/database/sqlite/SQLiteDatabase:close	()V
    //   625: aconst_null
    //   626: areturn
    //   627: astore_0
    //   628: aload 6
    //   630: astore_1
    //   631: aload_1
    //   632: ifnull +18 -> 650
    //   635: aload_1
    //   636: invokeinterface 143 1 0
    //   641: ifne +9 -> 650
    //   644: aload_1
    //   645: invokeinterface 146 1 0
    //   650: aload 5
    //   652: ifnull +25 -> 677
    //   655: iconst_1
    //   656: aload 5
    //   658: invokevirtual 149	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   661: if_icmpne +16 -> 677
    //   664: ldc_w 344
    //   667: ldc 153
    //   669: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   672: aload 5
    //   674: invokevirtual 160	android/database/sqlite/SQLiteDatabase:close	()V
    //   677: aload_0
    //   678: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	679	0	paramContext	Context
    //   0	679	1	paramString	String
    //   208	2	2	bool	boolean
    //   91	320	3	localObject1	Object
    //   467	8	3	localObject2	Object
    //   483	1	3	localObject3	Object
    //   496	8	3	localObject4	Object
    //   511	85	3	localContext1	Context
    //   6	481	4	localObject5	Object
    //   491	7	4	localException1	Exception
    //   508	12	4	localException2	Exception
    //   525	51	4	localException3	Exception
    //   124	349	5	localContext2	Context
    //   479	6	5	localException4	Exception
    //   501	172	5	localContext3	Context
    //   121	508	6	localObject6	Object
    //   3	133	7	localBoolean	java.lang.Boolean
    // Exception table:
    //   from	to	target	type
    //   338	364	467	finally
    //   412	419	467	finally
    //   338	364	479	java/lang/Exception
    //   412	419	479	java/lang/Exception
    //   126	135	491	java/lang/Exception
    //   145	155	491	java/lang/Exception
    //   161	166	491	java/lang/Exception
    //   176	185	491	java/lang/Exception
    //   191	197	491	java/lang/Exception
    //   203	209	491	java/lang/Exception
    //   264	285	491	java/lang/Exception
    //   74	116	496	finally
    //   74	116	508	java/lang/Exception
    //   8	37	515	finally
    //   37	44	515	finally
    //   47	67	515	finally
    //   67	74	515	finally
    //   8	37	525	java/lang/Exception
    //   37	44	525	java/lang/Exception
    //   47	67	525	java/lang/Exception
    //   67	74	525	java/lang/Exception
    //   126	135	627	finally
    //   145	155	627	finally
    //   161	166	627	finally
    //   176	185	627	finally
    //   191	197	627	finally
    //   203	209	627	finally
    //   264	285	627	finally
    //   537	546	627	finally
    //   552	556	627	finally
    //   565	569	627	finally
    //   575	582	627	finally
  }
  
  private static TreeMap b(Context paramContext, String paramString)
  {
    try
    {
      localObject1 = new SecretKeySpec(t.B, "DESede");
      Object localObject2 = Cipher.getInstance("DESede");
      ((Cipher)localObject2).init(2, (Key)localObject1);
      localObject1 = new ObjectInputStream(new CipherInputStream(paramContext.openFileInput(paramString), (Cipher)localObject2));
      try
      {
        localObject2 = (TreeMap)((ObjectInputStream)localObject1).readObject();
        paramContext = (Context)localObject2;
        paramString = (String)localObject1;
      }
      catch (Throwable localThrowable2) {}
      if ((localThrowable3 instanceof FileNotFoundException)) {}
    }
    catch (Throwable localThrowable3)
    {
      localObject1 = null;
    }
    try
    {
      localObject3 = new byte[256];
      localObject4 = paramContext.openFileInput(paramString);
      for (;;)
      {
        j = ((FileInputStream)localObject4).read((byte[])localObject3, 0, 256);
        if (j <= 0) {
          break;
        }
        util.LOGI(util.buf_to_string((byte[])localObject3, j));
      }
      ((FileInputStream)localObject4).close();
    }
    catch (Exception localException2)
    {
      Object localObject3;
      label138:
      label221:
      break label138;
    }
    try
    {
      localObject3 = new SecretKeySpec(new String("%4;7t>;28<fc.5*6").getBytes(), "DESede");
      localObject4 = Cipher.getInstance("DESede");
      ((Cipher)localObject4).init(2, (Key)localObject3);
      localObject3 = new ObjectInputStream(new CipherInputStream(paramContext.openFileInput(paramString), (Cipher)localObject4));
    }
    catch (Throwable localThrowable4)
    {
      break label221;
    }
    try
    {
      localObject1 = (TreeMap)((ObjectInputStream)localObject3).readObject();
      paramString = (String)localObject3;
      paramContext = (Context)localObject1;
    }
    catch (Throwable localThrowable1)
    {
      break label225;
    }
    localObject3 = localObject1;
    label225:
    Object localObject1 = localObject3;
    for (;;)
    {
      try
      {
        localObject4 = new byte[256];
        localObject1 = localObject3;
        localFileInputStream = paramContext.openFileInput(paramString);
        localObject1 = localObject3;
        localFileOutputStream = paramContext.openFileOutput("tmp_tk_file", 0);
        paramString = (String)localObject3;
      }
      catch (Exception paramString)
      {
        FileInputStream localFileInputStream;
        FileOutputStream localFileOutputStream;
        int m;
        int k;
        int n;
        int i1;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        continue;
        if (j >= 256) {
          continue;
        }
        localObject4[j] = 0;
        j += 1;
        continue;
        j = 0;
        continue;
        continue;
        j = 0;
        continue;
        j = 0;
        continue;
        j = 0;
        continue;
        continue;
        continue;
        continue;
        continue;
      }
      localObject1 = paramString;
      m = localFileInputStream.read((byte[])localObject4, 40, 216);
      if (m <= 0) {
        continue;
      }
      j = m + 40;
      continue;
      if (j < 0) {
        continue;
      }
      localObject1 = paramString;
      localObject3 = new String("WloginAllSigInfo").getBytes();
      localObject1 = paramString;
      j = a((byte[])localObject4, j, (byte[])localObject3);
      if (j < 0) {
        continue;
      }
      localObject1 = paramString;
      j += localObject3.length;
      if (j + 8 > 256) {
        continue;
      }
      k = j + 0;
      if (localObject4[k] != -127) {
        continue;
      }
      n = j + 1;
      if (localObject4[n] != 64) {
        continue;
      }
      i1 = j + 2;
      if (localObject4[i1] != 1) {
        continue;
      }
      i2 = j + 3;
      if (localObject4[i2] != 111) {
        continue;
      }
      i3 = j + 4;
      if (localObject4[i3] != -111) {
        continue;
      }
      i4 = j + 5;
      if (localObject4[i4] != -44) {
        continue;
      }
      i5 = j + 6;
      if (localObject4[i5] != 26) {
        continue;
      }
      i6 = j + 7;
      i7 = localObject4[i6];
      if (i7 != -101) {
        continue;
      }
      localObject4[k] = 0;
      localObject4[n] = 0;
      localObject4[i1] = 0;
      localObject4[i2] = 0;
      localObject4[i3] = 0;
      localObject4[i4] = 0;
      localObject4[i5] = 0;
      localObject4[i6] = 1;
      continue;
      if (j < 0) {
        continue;
      }
      localObject1 = paramString;
      try
      {
        localObject3 = new String("WloginSigInfo").getBytes();
        localObject1 = paramString;
        j = a((byte[])localObject4, j, (byte[])localObject3);
        if (j < 0) {
          continue;
        }
        localObject1 = paramString;
        k = j + localObject3.length;
        j = k;
        if (k + 8 > 256) {
          continue;
        }
        n = k + 0;
        j = k;
        if (localObject4[n] != 0) {
          continue;
        }
        i1 = k + 1;
        j = k;
        if (localObject4[i1] != 0) {
          continue;
        }
        i2 = k + 2;
        j = k;
        if (localObject4[i2] != 0) {
          continue;
        }
        i3 = k + 3;
        j = k;
        if (localObject4[i3] != 0) {
          continue;
        }
        i4 = k + 4;
        j = k;
        if (localObject4[i4] != 0) {
          continue;
        }
        i5 = k + 5;
        j = k;
        if (localObject4[i5] != 0) {
          continue;
        }
        i6 = k + 6;
        j = k;
        if (localObject4[i6] != 0) {
          continue;
        }
        i7 = k + 7;
        j = k;
        if (localObject4[i7] != 0) {
          continue;
        }
        localObject4[n] = 0;
        localObject4[i1] = 0;
        localObject4[i2] = 0;
        localObject4[i3] = 0;
        localObject4[i4] = 0;
        localObject4[i5] = 0;
        localObject4[i6] = 0;
        localObject4[i7] = 1;
        j = k;
      }
      catch (Exception paramString)
      {
        continue;
      }
      if (j < 0) {
        continue;
      }
      localObject1 = paramString;
      localObject3 = new String("WloginSimpleInfo").getBytes();
      localObject1 = paramString;
      j = a((byte[])localObject4, j, (byte[])localObject3);
      if (j < 0) {
        continue;
      }
      localObject1 = paramString;
      k = j + localObject3.length;
      j = k;
      if (k + 8 <= 256)
      {
        n = k + 0;
        j = k;
        if (localObject4[n] == 57)
        {
          i1 = k + 1;
          j = k;
          if (localObject4[i1] == -69)
          {
            i2 = k + 2;
            j = k;
            if (localObject4[i2] == -84)
            {
              i3 = k + 3;
              j = k;
              if (localObject4[i3] == 110)
              {
                i4 = k + 4;
                j = k;
                if (localObject4[i4] == -46)
                {
                  i5 = k + 5;
                  j = k;
                  if (localObject4[i5] == 98)
                  {
                    i6 = k + 6;
                    j = k;
                    if (localObject4[i6] == -31)
                    {
                      i7 = k + 7;
                      j = k;
                      if (localObject4[i7] == -113)
                      {
                        localObject4[n] = 0;
                        localObject4[i1] = 0;
                        localObject4[i2] = 0;
                        localObject4[i3] = 0;
                        localObject4[i4] = 0;
                        localObject4[i5] = 0;
                        localObject4[i6] = 0;
                        localObject4[i7] = 1;
                        j = k;
                        continue;
                        if (j < 0) {
                          continue;
                        }
                        localObject1 = paramString;
                        localObject3 = new String("UinInfo").getBytes();
                        localObject1 = paramString;
                        j = a((byte[])localObject4, j, (byte[])localObject3);
                        if (j < 0) {
                          continue;
                        }
                        localObject1 = paramString;
                        j += localObject3.length;
                        if (j + 8 > 256) {
                          continue;
                        }
                        k = j + 0;
                        if (localObject4[k] != -118) {
                          continue;
                        }
                        n = j + 1;
                        if (localObject4[n] != -23) {
                          continue;
                        }
                        i1 = j + 2;
                        if (localObject4[i1] != -128) {
                          continue;
                        }
                        i2 = j + 3;
                        if (localObject4[i2] != -19) {
                          continue;
                        }
                        i3 = j + 4;
                        if (localObject4[i3] != -26) {
                          continue;
                        }
                        i4 = j + 5;
                        if (localObject4[i4] != 99) {
                          continue;
                        }
                        i5 = j + 6;
                        if (localObject4[i5] != 41) {
                          continue;
                        }
                        i6 = j + 7;
                        if (localObject4[i6] != 14) {
                          continue;
                        }
                        localObject4[k] = 0;
                        localObject4[n] = 0;
                        localObject4[i1] = 0;
                        localObject4[i2] = 0;
                        localObject4[i3] = 0;
                        localObject4[i4] = 0;
                        localObject4[i5] = 0;
                        localObject4[i6] = 1;
                        continue;
                        localObject1 = paramString;
                        localFileOutputStream.write((byte[])localObject4, 40, m);
                        if (m <= 40) {
                          continue;
                        }
                        localObject1 = paramString;
                        System.arraycopy(localObject4, m, localObject4, 0, 40);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    localObject1 = paramString;
    localFileInputStream.close();
    localObject1 = paramString;
    localFileOutputStream.close();
    localObject1 = paramString;
    paramString = new ObjectInputStream(paramContext.openFileInput("tmp_tk_file"));
    try
    {
      localObject1 = (TreeMap)paramString.readObject();
    }
    catch (Exception localException1)
    {
      label1324:
      break label1324;
    }
    paramString = (String)localObject1;
    localObject1 = null;
    paramContext.deleteFile("tmp_tk_file");
    paramContext = (Context)localObject1;
    if (paramContext != null) {}
    try
    {
      paramString.close();
    }
    catch (Exception paramContext)
    {
      label1349:
      break label1349;
    }
    return null;
    return paramContext;
  }
  
  private static void c(String paramString)
  {
    long l = new File(paramString).lastModified();
    StringBuilder localStringBuilder = new StringBuilder("file ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" last update stample ");
    localStringBuilder.append(l);
    util.LOGI(localStringBuilder.toString(), "");
  }
  
  public int a(long paramLong1, long paramLong2)
  {
    try
    {
      util.LOGI("start clear_da2 ".concat(String.valueOf(paramLong2)), String.valueOf(paramLong1));
      ??? = this.a;
      int j = 0;
      int k = 0;
      if (??? != null) {
        synchronized (f)
        {
          TreeMap localTreeMap = a(this.a, "tk_file", paramLong1);
          j = k;
          if (localTreeMap != null)
          {
            WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)localTreeMap.get(Long.valueOf(paramLong1));
            if (localWloginAllSigInfo == null) {
              return -1;
            }
            util.LOGI("clear_da2 clear DA2 in file", String.valueOf(paramLong1));
            localWloginAllSigInfo.put_da2(paramLong2, new byte[0]);
            j = a(localTreeMap, "tk_file");
            this.c = localTreeMap;
          }
        }
      }
      util.LOGI("end clear_da2 ret ".concat(String.valueOf(j)), String.valueOf(paramLong1));
      return j;
    }
    finally {}
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      util.LOGI("start put_siginfo ".concat(String.valueOf(paramLong2)), String.valueOf(paramLong1));
      WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)this.c.get(Long.valueOf(paramLong1));
      if (localWloginAllSigInfo == null) {
        return -1;
      }
      int j = localWloginAllSigInfo.put_siginfo(paramLong2, paramLong3, paramLong4, paramArrayOfByte1, paramArrayOfByte2);
      if (this.a != null) {
        synchronized (f)
        {
          paramArrayOfByte2 = a(this.a, "tk_file", paramLong1);
          paramArrayOfByte1 = paramArrayOfByte2;
          if (paramArrayOfByte2 == null) {
            paramArrayOfByte1 = new TreeMap();
          }
          paramArrayOfByte1.put(Long.valueOf(paramLong1), localWloginAllSigInfo.get_clone());
          a(paramArrayOfByte1, "tk_file");
        }
      }
      return j;
    }
    finally {}
  }
  
  public int a(long paramLong1, long paramLong2, byte[][] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, WloginSimpleInfo paramWloginSimpleInfo, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, byte[] paramArrayOfByte11, byte[] paramArrayOfByte12, byte[] paramArrayOfByte13, byte[][] paramArrayOfByte14, long[] paramArrayOfLong, int paramInt)
  {
    label1192:
    label1195:
    label1198:
    label1230:
    for (;;)
    {
      Object localObject10;
      try
      {
        Object localObject1 = new StringBuilder("start put_siginfo skey ");
        ((StringBuilder)localObject1).append(util.getMaskBytes(paramArrayOfByte10, 2, 2));
        util.LOGI(((StringBuilder)localObject1).toString(), String.valueOf(paramLong1));
        localObject1 = this.a;
        int j = 0;
        if (localObject1 != null) {
          synchronized (f)
          {
            util.LOGI("put_siginfo load file", String.valueOf(paramLong1));
            localObject1 = a(this.a, "tk_file", paramLong1);
            Object localObject6 = localObject1;
            if (localObject1 == null) {
              localObject6 = new TreeMap();
            }
            localObject1 = (WloginAllSigInfo)this.c.get(Long.valueOf(paramLong1));
            if (localObject1 != null) {
              break label1195;
            }
            localObject1 = (WloginAllSigInfo)((TreeMap)localObject6).get(Long.valueOf(paramLong1));
            if (localObject1 != null) {
              break label1192;
            }
            localObject1 = new WloginAllSigInfo();
            Object localObject2 = new StringBuilder("mainSigMap 0x");
            ((StringBuilder)localObject2).append(Integer.toHexString(this.e));
            util.LOGI(((StringBuilder)localObject2).toString(), String.valueOf(paramLong1));
            ((WloginAllSigInfo)localObject1).mainSigMap = this.e;
            localObject2 = new byte[0];
            localObject7 = new byte[0];
            byte[] arrayOfByte = new byte[0];
            localObject4 = new byte[0];
            localObject5 = new byte[0];
            localObject10 = new byte[0];
            localObject9 = (WloginSigInfo)((WloginAllSigInfo)localObject1)._tk_map.get(Long.valueOf(paramLong2));
            if (localObject9 == null) {
              break label1198;
            }
            localObject3 = localObject2;
            localObject2 = localObject7;
            if (((WloginSigInfo)localObject9)._en_A1 != null)
            {
              localObject8 = (byte[])((WloginSigInfo)localObject9)._en_A1.clone();
              localObject3 = localObject8;
              localObject2 = localObject7;
              if (((WloginSigInfo)localObject9)._noPicSig != null)
              {
                localObject2 = (byte[])((WloginSigInfo)localObject9)._noPicSig.clone();
                localObject3 = localObject8;
              }
            }
            if (((WloginSigInfo)localObject9)._G != null) {
              arrayOfByte = (byte[])((WloginSigInfo)localObject9)._G.clone();
            }
            if (((WloginSigInfo)localObject9)._dpwd != null) {
              localObject4 = (byte[])((WloginSigInfo)localObject9)._dpwd.clone();
            }
            if (((WloginSigInfo)localObject9)._randseed != null) {
              localObject5 = (byte[])((WloginSigInfo)localObject9)._randseed.clone();
            }
            localObject7 = ((WloginSigInfo)localObject9)._psKey;
            Object localObject11 = ((WloginSigInfo)localObject9)._pt4Token;
            localObject8 = localObject2;
            localObject9 = localObject4;
            localObject10 = localObject5;
            localObject4 = localObject11;
            localObject2 = localObject3;
            localObject3 = localObject8;
            localObject5 = localObject9;
            localObject8 = localObject10;
            HashMap localHashMap;
            if ((paramArrayOfByte14[6] != null) && (paramArrayOfByte14[6].length > 2))
            {
              localObject9 = new HashMap();
              localObject10 = new HashMap();
              localObject11 = new HashMap();
              localHashMap = new HashMap();
              Ticket.parsePsBuf((byte[])localObject7, paramLong5, (Map)localObject9, (Map)localObject10);
              Ticket.parsePsBuf((byte[])localObject4, paramLong5, (Map)localObject11, localHashMap);
              localObject4 = new StringBuilder("current pskey size:");
              ((StringBuilder)localObject4).append(((Map)localObject9).size());
              ((StringBuilder)localObject4).append(":");
              ((StringBuilder)localObject4).append(((Map)localObject10).size());
              util.LOGI(((StringBuilder)localObject4).toString(), "");
              localObject4 = ((Map)localObject10).entrySet().iterator();
              String str;
              if (((Iterator)localObject4).hasNext())
              {
                localObject7 = (Map.Entry)((Iterator)localObject4).next();
                str = (String)((Map.Entry)localObject7).getKey();
                if (!Ticket.isPskeyStorageExpired(((Long)((Map.Entry)localObject7).getValue()).longValue())) {
                  continue;
                }
                ((Iterator)localObject4).remove();
                ((Map)localObject9).remove(str);
                util.LOGI("delete expired pskey from file,key:".concat(String.valueOf(str)), "");
                continue;
              }
              localObject4 = localHashMap.entrySet().iterator();
              localObject7 = new StringBuilder("current pt4token size:");
              ((StringBuilder)localObject7).append(((Map)localObject11).size());
              ((StringBuilder)localObject7).append(":");
              ((StringBuilder)localObject7).append(localHashMap.size());
              util.LOGI(((StringBuilder)localObject7).toString(), "");
              if (((Iterator)localObject4).hasNext())
              {
                localObject7 = (Map.Entry)((Iterator)localObject4).next();
                str = (String)((Map.Entry)localObject7).getKey();
                if (!Ticket.isPskeyStorageExpired(((Long)((Map.Entry)localObject7).getValue()).longValue())) {
                  continue;
                }
                ((Iterator)localObject4).remove();
                ((Map)localObject11).remove(str);
                util.LOGI("delete expired pt4token from file,key:".concat(String.valueOf(str)), "");
                continue;
              }
              Ticket.parseSvrPs(paramArrayOfByte14[6], paramLong5, (Map)localObject9, (Map)localObject10, (Map)localObject11, localHashMap);
            }
            try
            {
              paramArrayOfByte14[6] = Ticket.packPsBuf((Map)localObject9, paramLong5, (Map)localObject10);
              paramArrayOfByte14[12] = Ticket.packPsBuf((Map)localObject11, paramLong5, localHashMap);
            }
            catch (BufferOverflowException paramArrayOfByte1)
            {
              continue;
            }
            paramArrayOfByte1 = new StringBuilder("map size ");
            paramArrayOfByte1.append(((Map)localObject9).size());
            paramArrayOfByte1.append("is too large");
            util.LOGI(paramArrayOfByte1.toString(), String.valueOf(paramLong1));
            a(Long.valueOf(paramLong1));
            return -1023;
            ((WloginAllSigInfo)localObject1).put_simpleinfo(paramWloginSimpleInfo);
            ((WloginAllSigInfo)localObject1).put_siginfo(paramLong3, paramLong4, paramLong5, paramLong6, paramLong7, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6, paramArrayOfByte7, paramArrayOfByte8, paramArrayOfByte9, paramArrayOfByte10, paramArrayOfByte11, paramArrayOfByte12, paramArrayOfByte13, paramArrayOfByte14, paramArrayOfLong, paramInt);
            ((WloginAllSigInfo)localObject1).put_siginfo(paramLong2, paramArrayOfByte1, paramLong5);
            ((TreeMap)localObject6).put(Long.valueOf(paramLong1), ((WloginAllSigInfo)localObject1).get_clone());
            j = a((TreeMap)localObject6, "tk_file");
            util.LOGI("save key result:tk_file:".concat(String.valueOf(j)), "");
            if (j == 0) {
              break label1230;
            }
            paramArrayOfByte1 = (WloginSigInfo)((WloginAllSigInfo)localObject1)._tk_map.get(Long.valueOf(paramLong2));
            if (paramArrayOfByte1 != null)
            {
              paramArrayOfByte1._en_A1 = ((byte[])((byte[])localObject2).clone());
              paramArrayOfByte1._noPicSig = ((byte[])localObject3.clone());
              paramArrayOfByte1._G = ((byte[])arrayOfByte.clone());
              paramArrayOfByte1._dpwd = ((byte[])((byte[])localObject5).clone());
              paramArrayOfByte1._randseed = ((byte[])((byte[])localObject8).clone());
            }
            util.LOGI("sig in memory changed", String.valueOf(paramLong1));
            this.c.put(Long.valueOf(paramLong1), ((WloginAllSigInfo)localObject1).get_clone());
          }
        } else {
          return j;
        }
      }
      finally {}
      continue;
      continue;
      Object localObject3 = localObject7;
      Object localObject8 = localObject4;
      Object localObject9 = localObject5;
      Object localObject4 = new byte[0];
      Object localObject7 = localObject10;
      Object localObject5 = localObject8;
      localObject8 = localObject9;
    }
  }
  
  public int a(TreeMap paramTreeMap, String paramString)
  {
    int j = 0;
    try
    {
      if (("tk_file".equals(paramString)) || ("name_file".equals(paramString))) {
        j = b(paramTreeMap, paramString);
      }
      return j;
    }
    finally {}
  }
  
  public List<WloginLoginInfo> a(boolean paramBoolean)
  {
    label341:
    for (;;)
    {
      try
      {
        ArrayList localArrayList = new ArrayList();
        if (this.a != null)
        {
          Object localObject6 = a(this.a, "tk_file", 0L);
          if (localObject6 == null) {
            return localArrayList;
          }
          Object localObject5 = ((TreeMap)localObject6).keySet().iterator();
          if (((Iterator)localObject5).hasNext())
          {
            Long localLong = (Long)((Iterator)localObject5).next();
            Object localObject3 = (WloginAllSigInfo)this.c.get(localLong);
            Object localObject1 = localObject3;
            if (localObject3 == null)
            {
              localObject1 = (WloginAllSigInfo)((TreeMap)localObject6).get(localLong);
              if (localObject1 == null) {
                continue;
              }
              this.c.put(localLong, localObject1);
            }
            Iterator localIterator = ((WloginAllSigInfo)localObject1)._tk_map.keySet().iterator();
            Object localObject4 = localObject5;
            localObject3 = localObject6;
            localObject6 = localObject3;
            localObject5 = localObject4;
            if (!localIterator.hasNext()) {
              continue;
            }
            Object localObject7 = (Long)localIterator.next();
            localObject6 = (WloginSigInfo)((WloginAllSigInfo)localObject1)._tk_map.get(localObject7);
            if (localObject6 == null) {
              continue;
            }
            localObject5 = b(localLong);
            if (localObject5 != null) {
              break label341;
            }
            localObject5 = String.valueOf(localLong);
            if (((WloginAllSigInfo)localObject1)._useInfo._img_url == null) {
              ((WloginAllSigInfo)localObject1)._useInfo._img_url = new byte[0];
            }
            long l1 = localLong.longValue();
            long l2 = ((Long)localObject7).longValue();
            localObject7 = new String(((WloginAllSigInfo)localObject1)._useInfo._img_url);
            long l3 = ((WloginSigInfo)localObject6)._create_time;
            int j;
            if (paramBoolean) {
              j = WloginLoginInfo.TYPE_LOACL;
            } else {
              j = WloginLoginInfo.TYPE_REMOTE;
            }
            localArrayList.add(new WloginLoginInfo((String)localObject5, l1, l2, (String)localObject7, l3, j, ((WloginSigInfo)localObject6)._login_bitmap));
            continue;
          }
        }
        return localArrayList;
      }
      finally {}
    }
  }
  
  public UinInfo a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      Object localObject = (UinInfo)this.d.get(paramString);
      if (localObject != null)
      {
        localStringBuilder = new StringBuilder("mem got_account name: ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" uin: ");
        localStringBuilder.append(((UinInfo)localObject)._uin);
        localStringBuilder.append(", ");
        localStringBuilder.append(((UinInfo)localObject).getHasPassword());
        util.LOGI(localStringBuilder.toString(), "");
        return localObject;
      }
      localObject = this.a;
      if (localObject == null) {
        return null;
      }
      localObject = a(this.a, "name_file", 0L);
      if (localObject == null) {
        return null;
      }
      localObject = (UinInfo)((TreeMap)localObject).get(paramString);
      if (localObject == null) {
        return null;
      }
      this.d.put(paramString, localObject);
      StringBuilder localStringBuilder = new StringBuilder("file got_account name: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" uin: ");
      localStringBuilder.append(((UinInfo)localObject)._uin);
      localStringBuilder.append(", ");
      localStringBuilder.append(((UinInfo)localObject).getHasPassword());
      util.LOGI(localStringBuilder.toString(), "");
      return localObject;
    }
    finally {}
  }
  
  public WloginAllSigInfo a(long paramLong)
  {
    try
    {
      Object localObject1 = (WloginAllSigInfo)this.c.get(Long.valueOf(paramLong));
      if (localObject1 != null)
      {
        util.LOGI("get_all_siginfo got in mem", "");
        return localObject1;
      }
      localObject1 = this.a;
      if (localObject1 == null) {
        return null;
      }
      localObject1 = a(this.a, "tk_file", paramLong);
      if (localObject1 == null) {
        return null;
      }
      localObject1 = (WloginAllSigInfo)((TreeMap)localObject1).get(Long.valueOf(paramLong));
      if (localObject1 == null) {
        return null;
      }
      util.LOGI("got in file", "");
      this.c.put(Long.valueOf(paramLong), localObject1);
      return localObject1;
    }
    finally {}
  }
  
  public void a()
  {
    try
    {
      util.LOGI("refresh_all_siginfo ...", "");
      this.c = a(this.a, "tk_file", 0L);
      if (this.c == null) {
        this.c = new TreeMap();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    try
    {
      util.LOGI("start put_randseed ".concat(String.valueOf(paramLong2)), String.valueOf(paramLong1));
      if (this.a != null) {
        synchronized (f)
        {
          TreeMap localTreeMap = a(this.a, "tk_file", paramLong1);
          if (localTreeMap != null)
          {
            WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)localTreeMap.get(Long.valueOf(paramLong1));
            if (localWloginAllSigInfo == null)
            {
              util.LOGI("fileInfo is null ".concat(String.valueOf(paramLong2)), String.valueOf(paramLong1));
              return;
            }
            localWloginAllSigInfo.put_randseed(paramLong2, paramArrayOfByte);
            int j = a(localTreeMap, "tk_file");
            if (j != 0)
            {
              paramArrayOfByte = new StringBuilder("put_randseed refreshTKTreeMap failed ret ");
              paramArrayOfByte.append(j);
              paramArrayOfByte.append(" appid ");
              paramArrayOfByte.append(paramLong2);
              util.LOGI(paramArrayOfByte.toString(), String.valueOf(paramLong1));
              return;
            }
            this.c = localTreeMap;
            util.LOGI("end put_randseed", String.valueOf(paramLong1));
          }
          return;
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(Long paramLong)
  {
    try
    {
      util.LOGI("start clear_sig", String.valueOf(paramLong));
      this.c.remove(paramLong);
      if (this.a != null) {
        synchronized (f)
        {
          TreeMap localTreeMap = a(this.a, "tk_file", paramLong.longValue());
          if (localTreeMap == null) {
            return;
          }
          localTreeMap.remove(paramLong);
          a(localTreeMap, "tk_file");
          return;
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(Long paramLong1, Long paramLong2)
  {
    try
    {
      util.LOGI("start clear_sig", String.valueOf(paramLong1));
      ??? = (WloginAllSigInfo)this.c.get(paramLong1);
      if (??? != null)
      {
        ((WloginAllSigInfo)???)._tk_map.remove(paramLong2);
        ??? = new StringBuilder("uin ");
        ((StringBuilder)???).append(paramLong1);
        ((StringBuilder)???).append(" appid ");
        ((StringBuilder)???).append(paramLong2);
        ((StringBuilder)???).append(" sig has been cleared");
        util.LOGI(((StringBuilder)???).toString());
      }
      if (this.a != null) {
        synchronized (f)
        {
          TreeMap localTreeMap = a(this.a, "tk_file", paramLong1.longValue());
          if (localTreeMap == null) {
            return;
          }
          paramLong1 = (WloginAllSigInfo)localTreeMap.get(paramLong1);
          if (paramLong1 == null) {
            return;
          }
          paramLong1._tk_map.remove(paramLong2);
          a(localTreeMap, "tk_file");
          return;
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    try
    {
      this.d.remove(paramString);
      if (this.a != null) {
        synchronized (g)
        {
          TreeMap localTreeMap2 = a(this.a, "name_file", 0L);
          TreeMap localTreeMap1 = localTreeMap2;
          if (localTreeMap2 == null) {
            localTreeMap1 = new TreeMap();
          }
          localTreeMap1.remove(paramString);
          a(localTreeMap1, "name_file");
          return;
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString, Long paramLong, boolean paramBoolean)
  {
    try
    {
      util.LOGI("put account ".concat(String.valueOf(paramString)), String.valueOf(paramLong));
      String str = b(paramLong);
      if (str != null) {
        this.d.remove(str);
      }
      UinInfo localUinInfo = new UinInfo(paramLong, paramBoolean);
      this.d.put(paramString, localUinInfo);
      if (this.a != null) {
        synchronized (g)
        {
          TreeMap localTreeMap = a(this.a, "name_file", 0L);
          paramLong = localTreeMap;
          if (localTreeMap == null) {
            paramLong = new TreeMap();
          }
          if (str != null) {
            paramLong.remove(str);
          }
          paramLong.put(paramString, localUinInfo);
          a(paramLong, "name_file");
          return;
        }
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public int b(TreeMap paramTreeMap, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 674	java/io/ByteArrayOutputStream
    //   5: dup
    //   6: invokespecial 675	java/io/ByteArrayOutputStream:<init>	()V
    //   9: astore 4
    //   11: new 677	java/io/ObjectOutputStream
    //   14: dup
    //   15: aload 4
    //   17: invokespecial 680	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   20: astore 5
    //   22: aload 5
    //   24: aload_1
    //   25: invokevirtual 684	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   28: aload 5
    //   30: invokevirtual 687	java/io/ObjectOutputStream:flush	()V
    //   33: aload 4
    //   35: invokevirtual 690	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   38: astore_1
    //   39: aload_1
    //   40: iconst_0
    //   41: aload_1
    //   42: arraylength
    //   43: getstatic 200	oicq/wlogin_sdk/request/t:B	[B
    //   46: invokestatic 693	oicq/wlogin_sdk/tools/cryptor:encrypt	([BII[B)[B
    //   49: astore_1
    //   50: aload_0
    //   51: getfield 50	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   54: aload_2
    //   55: aload_1
    //   56: invokestatic 695	oicq/wlogin_sdk/request/d:a	(Landroid/content/Context;Ljava/lang/String;[B)I
    //   59: istore_3
    //   60: aload 5
    //   62: invokevirtual 696	java/io/ObjectOutputStream:close	()V
    //   65: aload 4
    //   67: invokevirtual 697	java/io/ByteArrayOutputStream:close	()V
    //   70: goto +50 -> 120
    //   73: astore_1
    //   74: goto +50 -> 124
    //   77: astore_1
    //   78: new 86	java/lang/StringBuilder
    //   81: dup
    //   82: ldc_w 699
    //   85: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   88: astore_2
    //   89: aload_2
    //   90: aload_1
    //   91: invokevirtual 703	java/lang/Throwable:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   94: invokevirtual 704	java/lang/Object:toString	()Ljava/lang/String;
    //   97: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload_2
    //   102: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: ldc 153
    //   107: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload_1
    //   111: ldc 153
    //   113: invokestatic 307	oicq/wlogin_sdk/tools/util:printThrowable	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   116: sipush -1022
    //   119: istore_3
    //   120: aload_0
    //   121: monitorexit
    //   122: iload_3
    //   123: ireturn
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	d
    //   0	128	1	paramTreeMap	TreeMap
    //   0	128	2	paramString	String
    //   59	64	3	j	int
    //   9	57	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   20	41	5	localObjectOutputStream	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   2	70	73	finally
    //   78	116	73	finally
    //   2	70	77	java/lang/Throwable
  }
  
  public String b(Long paramLong)
  {
    try
    {
      Iterator localIterator = this.d.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        UinInfo localUinInfo = (UinInfo)this.d.get(str);
        if (localUinInfo != null)
        {
          boolean bool = localUinInfo._uin.equals(paramLong);
          if (bool) {
            return str;
          }
        }
      }
      return null;
    }
    finally {}
  }
  
  public WloginSimpleInfo b(long paramLong)
  {
    try
    {
      util.LOGI("start get_simpleinfo", "uin=".concat(String.valueOf(paramLong)));
      Object localObject1 = a(paramLong);
      if (localObject1 == null) {
        return null;
      }
      localObject1 = ((WloginAllSigInfo)localObject1)._useInfo.get_clone();
      return localObject1;
    }
    finally {}
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    try
    {
      util.LOGI("start clearNewST ".concat(String.valueOf(paramLong2)), String.valueOf(paramLong1));
      ??? = this.a;
      int j = 0;
      int k = 0;
      if (??? != null) {
        synchronized (f)
        {
          TreeMap localTreeMap = a(this.a, "tk_file", paramLong1);
          j = k;
          if (localTreeMap != null)
          {
            WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)localTreeMap.get(Long.valueOf(paramLong1));
            if (localWloginAllSigInfo == null) {
              return;
            }
            util.LOGI("clearNewST clear newST in file", String.valueOf(paramLong1));
            localWloginAllSigInfo.putNewST(paramLong2, new byte[0], new byte[0]);
            j = a(localTreeMap, "tk_file");
            this.c = localTreeMap;
          }
        }
      }
      util.LOGI("end clearNewST ret ".concat(String.valueOf(j)), String.valueOf(paramLong1));
      return;
    }
    finally {}
  }
  
  public void b(String paramString)
  {
    try
    {
      this.d.remove(paramString);
      util.LOGI("clear_account ".concat(String.valueOf(paramString)), "");
      if (this.a != null) {
        synchronized (g)
        {
          TreeMap localTreeMap = a(this.a, "name_file", 0L);
          if (localTreeMap == null) {
            return;
          }
          localTreeMap.remove(paramString);
          a(localTreeMap, "name_file");
          return;
        }
      }
      return;
    }
    finally {}
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    try
    {
      util.LOGI("clear_pskey ".concat(String.valueOf(paramLong2)), String.valueOf(paramLong1));
      WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)this.c.get(Long.valueOf(paramLong1));
      if (localWloginAllSigInfo == null) {
        return;
      }
      ??? = (WloginSigInfo)localWloginAllSigInfo._tk_map.get(Long.valueOf(paramLong2));
      if (??? == null) {
        return;
      }
      ((WloginSigInfo)???)._pt4Token = new byte[0];
      ((WloginSigInfo)???)._psKey = new byte[0];
      ((WloginSigInfo)???).cacheTickets = null;
      ((WloginSigInfo)???).cacheUpdateStamp = 0L;
      localWloginAllSigInfo._tk_map.put(Long.valueOf(paramLong1), ???);
      if (this.a != null) {
        synchronized (f)
        {
          TreeMap localTreeMap = a(this.a, "tk_file", paramLong1);
          if (localTreeMap != null)
          {
            localTreeMap.put(Long.valueOf(paramLong1), localWloginAllSigInfo);
            a(localTreeMap, "tk_file");
            this.c = localTreeMap;
          }
          return;
        }
      }
      return;
    }
    finally {}
  }
  
  public WloginSigInfo d(long paramLong1, long paramLong2)
  {
    try
    {
      Object localObject1 = a(paramLong1);
      if (localObject1 == null) {
        return null;
      }
      localObject1 = (WloginSigInfo)((WloginAllSigInfo)localObject1)._tk_map.get(Long.valueOf(paramLong2));
      if (localObject1 == null) {
        return null;
      }
      return localObject1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.d
 * JD-Core Version:    0.7.0.1
 */