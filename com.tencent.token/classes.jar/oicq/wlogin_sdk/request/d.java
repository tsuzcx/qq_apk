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
    //   77: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   80: astore_3
    //   81: aload_3
    //   82: ldc 89
    //   84: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_3
    //   89: aload_1
    //   90: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_3
    //   95: ldc 95
    //   97: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload_3
    //   102: aload_1
    //   103: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_3
    //   108: ldc 97
    //   110: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload_0
    //   115: aload_3
    //   116: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokevirtual 103	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   122: aload_0
    //   123: aload_1
    //   124: iconst_1
    //   125: anewarray 62	java/lang/String
    //   128: dup
    //   129: iconst_0
    //   130: ldc 105
    //   132: aastore
    //   133: ldc 107
    //   135: aconst_null
    //   136: aconst_null
    //   137: aconst_null
    //   138: aconst_null
    //   139: invokevirtual 111	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   142: astore 5
    //   144: aload 5
    //   146: astore_3
    //   147: aload_0
    //   148: astore 4
    //   150: aload 5
    //   152: invokeinterface 117 1 0
    //   157: ifne +118 -> 275
    //   160: aload 5
    //   162: astore_3
    //   163: aload_0
    //   164: astore 4
    //   166: new 86	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   173: astore 6
    //   175: aload 5
    //   177: astore_3
    //   178: aload_0
    //   179: astore 4
    //   181: aload 6
    //   183: ldc 119
    //   185: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 5
    //   191: astore_3
    //   192: aload_0
    //   193: astore 4
    //   195: aload 6
    //   197: aload_1
    //   198: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload 5
    //   204: astore_3
    //   205: aload_0
    //   206: astore 4
    //   208: aload 6
    //   210: ldc 121
    //   212: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 5
    //   218: astore_3
    //   219: aload_0
    //   220: astore 4
    //   222: aload 6
    //   224: aload_1
    //   225: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload 5
    //   231: astore_3
    //   232: aload_0
    //   233: astore 4
    //   235: aload 6
    //   237: ldc 123
    //   239: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload 5
    //   245: astore_3
    //   246: aload_0
    //   247: astore 4
    //   249: aload_0
    //   250: aload 6
    //   252: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: iconst_2
    //   256: anewarray 4	java/lang/Object
    //   259: dup
    //   260: iconst_0
    //   261: iconst_0
    //   262: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: aastore
    //   266: dup
    //   267: iconst_1
    //   268: iconst_1
    //   269: newarray byte
    //   271: aastore
    //   272: invokevirtual 132	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   275: aload 5
    //   277: astore_3
    //   278: aload_0
    //   279: astore 4
    //   281: new 86	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   288: astore 6
    //   290: aload 5
    //   292: astore_3
    //   293: aload_0
    //   294: astore 4
    //   296: aload 6
    //   298: ldc 134
    //   300: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload 5
    //   306: astore_3
    //   307: aload_0
    //   308: astore 4
    //   310: aload 6
    //   312: aload_1
    //   313: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload 5
    //   319: astore_3
    //   320: aload_0
    //   321: astore 4
    //   323: aload 6
    //   325: ldc 136
    //   327: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload 5
    //   333: astore_3
    //   334: aload_0
    //   335: astore 4
    //   337: aload 6
    //   339: aload_1
    //   340: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload 5
    //   346: astore_3
    //   347: aload_0
    //   348: astore 4
    //   350: aload 6
    //   352: ldc 138
    //   354: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload 5
    //   360: astore_3
    //   361: aload_0
    //   362: astore 4
    //   364: aload_0
    //   365: aload 6
    //   367: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: iconst_1
    //   371: anewarray 4	java/lang/Object
    //   374: dup
    //   375: iconst_0
    //   376: aload_2
    //   377: aastore
    //   378: invokevirtual 132	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   381: aload 5
    //   383: ifnull +20 -> 403
    //   386: aload 5
    //   388: invokeinterface 142 1 0
    //   393: ifne +10 -> 403
    //   396: aload 5
    //   398: invokeinterface 145 1 0
    //   403: aload_0
    //   404: ifnull +22 -> 426
    //   407: iconst_1
    //   408: aload_0
    //   409: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   412: if_icmpne +14 -> 426
    //   415: ldc 150
    //   417: ldc 152
    //   419: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   422: aload_0
    //   423: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   426: iconst_0
    //   427: ireturn
    //   428: astore_3
    //   429: aload 5
    //   431: astore_2
    //   432: aload_3
    //   433: astore 5
    //   435: goto +30 -> 465
    //   438: astore_1
    //   439: aconst_null
    //   440: astore_3
    //   441: goto +175 -> 616
    //   444: astore 5
    //   446: aconst_null
    //   447: astore_2
    //   448: goto +17 -> 465
    //   451: astore_1
    //   452: aconst_null
    //   453: astore_0
    //   454: aload_0
    //   455: astore_3
    //   456: goto +160 -> 616
    //   459: astore 5
    //   461: aconst_null
    //   462: astore_0
    //   463: aload_0
    //   464: astore_2
    //   465: aload_2
    //   466: astore_3
    //   467: aload_0
    //   468: astore 4
    //   470: aload_1
    //   471: ldc 60
    //   473: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   476: ifeq +15 -> 491
    //   479: aload_2
    //   480: astore_3
    //   481: aload_0
    //   482: astore 4
    //   484: aconst_null
    //   485: putstatic 32	oicq/wlogin_sdk/request/d:h	Loicq/wlogin_sdk/request/b;
    //   488: goto +12 -> 500
    //   491: aload_2
    //   492: astore_3
    //   493: aload_0
    //   494: astore 4
    //   496: aconst_null
    //   497: putstatic 34	oicq/wlogin_sdk/request/d:i	Loicq/wlogin_sdk/request/b;
    //   500: aload_2
    //   501: astore_3
    //   502: aload_0
    //   503: astore 4
    //   505: aload 5
    //   507: ldc 152
    //   509: invokestatic 163	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   512: aload_2
    //   513: astore_3
    //   514: aload_0
    //   515: astore 4
    //   517: new 86	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   524: astore_1
    //   525: aload_2
    //   526: astore_3
    //   527: aload_0
    //   528: astore 4
    //   530: aload_1
    //   531: ldc 165
    //   533: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: aload_2
    //   538: astore_3
    //   539: aload_0
    //   540: astore 4
    //   542: aload_1
    //   543: aload 5
    //   545: invokevirtual 168	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   548: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: pop
    //   552: aload_2
    //   553: astore_3
    //   554: aload_0
    //   555: astore 4
    //   557: aload_1
    //   558: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: ldc 152
    //   563: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   566: aload_2
    //   567: ifnull +18 -> 585
    //   570: aload_2
    //   571: invokeinterface 142 1 0
    //   576: ifne +9 -> 585
    //   579: aload_2
    //   580: invokeinterface 145 1 0
    //   585: aload_0
    //   586: ifnull +22 -> 608
    //   589: iconst_1
    //   590: aload_0
    //   591: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   594: if_icmpne +14 -> 608
    //   597: ldc 150
    //   599: ldc 152
    //   601: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   604: aload_0
    //   605: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   608: sipush -1022
    //   611: ireturn
    //   612: astore_1
    //   613: aload 4
    //   615: astore_0
    //   616: aload_3
    //   617: ifnull +18 -> 635
    //   620: aload_3
    //   621: invokeinterface 142 1 0
    //   626: ifne +9 -> 635
    //   629: aload_3
    //   630: invokeinterface 145 1 0
    //   635: aload_0
    //   636: ifnull +22 -> 658
    //   639: iconst_1
    //   640: aload_0
    //   641: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   644: if_icmpne +14 -> 658
    //   647: ldc 150
    //   649: ldc 152
    //   651: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   654: aload_0
    //   655: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   658: aload_1
    //   659: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	660	0	paramContext	Context
    //   0	660	1	paramString	String
    //   0	660	2	paramArrayOfByte	byte[]
    //   80	281	3	localObject1	Object
    //   428	5	3	localException1	Exception
    //   440	190	3	localObject2	Object
    //   148	466	4	localContext	Context
    //   142	292	5	localObject3	Object
    //   444	1	5	localException2	Exception
    //   459	85	5	localException3	Exception
    //   173	193	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   150	160	428	java/lang/Exception
    //   166	175	428	java/lang/Exception
    //   181	189	428	java/lang/Exception
    //   195	202	428	java/lang/Exception
    //   208	216	428	java/lang/Exception
    //   222	229	428	java/lang/Exception
    //   235	243	428	java/lang/Exception
    //   249	275	428	java/lang/Exception
    //   281	290	428	java/lang/Exception
    //   296	304	428	java/lang/Exception
    //   310	317	428	java/lang/Exception
    //   323	331	428	java/lang/Exception
    //   337	344	428	java/lang/Exception
    //   350	358	428	java/lang/Exception
    //   364	381	428	java/lang/Exception
    //   66	144	438	finally
    //   66	144	444	java/lang/Exception
    //   0	29	451	finally
    //   29	36	451	finally
    //   39	59	451	finally
    //   59	66	451	finally
    //   0	29	459	java/lang/Exception
    //   29	36	459	java/lang/Exception
    //   39	59	459	java/lang/Exception
    //   59	66	459	java/lang/Exception
    //   150	160	612	finally
    //   166	175	612	finally
    //   181	189	612	finally
    //   195	202	612	finally
    //   208	216	612	finally
    //   222	229	612	finally
    //   235	243	612	finally
    //   249	275	612	finally
    //   281	290	612	finally
    //   296	304	612	finally
    //   310	317	612	finally
    //   323	331	612	finally
    //   337	344	612	finally
    //   350	358	612	finally
    //   364	381	612	finally
    //   470	479	612	finally
    //   484	488	612	finally
    //   496	500	612	finally
    //   505	512	612	finally
    //   517	525	612	finally
    //   530	537	612	finally
    //   542	552	612	finally
    //   557	566	612	finally
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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("loadTKTreeMap sigfile ");
    ((StringBuilder)localObject1).append(paramString);
    util.LOGI(((StringBuilder)localObject1).toString(), "");
    localObject1 = a(paramContext, paramString);
    if (localObject1 != null)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("loadTKTreeMap len:");
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
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("loadTKTreeMap tree size: ");
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
        label234:
        Object localObject4;
        StringBuilder localStringBuilder;
        util.printThrowable(localThrowable, "");
      }
    }
    try
    {
      localObject2 = ((TreeMap)localObject1).keySet().iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label664;
      }
      localObject3 = ((Iterator)localObject2).next();
      localObject4 = (WloginAllSigInfo)((TreeMap)localObject1).get(localObject3);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(localObject3);
      localStringBuilder.append(" allsig: ");
      localStringBuilder.append(((WloginAllSigInfo)localObject4)._tk_map);
      localObject4 = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(localObject3);
      util.LOGI((String)localObject4, localStringBuilder.toString());
      break label234;
      localObject2 = (WloginAllSigInfo)((TreeMap)localObject1).get(Long.valueOf(paramLong));
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramLong);
      ((StringBuilder)localObject3).append(" allsig: ");
      ((StringBuilder)localObject3).append(((WloginAllSigInfo)localObject2)._tk_map);
      localObject2 = ((StringBuilder)localObject3).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(paramLong);
      util.LOGI((String)localObject2, ((StringBuilder)localObject3).toString());
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
    label664:
    return localThrowable;
  }
  
  /* Error */
  public static byte[] a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: invokestatic 305	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 4
    //   9: aload_1
    //   10: ldc 60
    //   12: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifeq +33 -> 48
    //   18: getstatic 32	oicq/wlogin_sdk/request/d:h	Loicq/wlogin_sdk/request/b;
    //   21: ifnonnull +17 -> 38
    //   24: new 68	oicq/wlogin_sdk/request/b
    //   27: dup
    //   28: aload_0
    //   29: aload_1
    //   30: aconst_null
    //   31: iconst_1
    //   32: invokespecial 71	oicq/wlogin_sdk/request/b:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   35: putstatic 32	oicq/wlogin_sdk/request/d:h	Loicq/wlogin_sdk/request/b;
    //   38: getstatic 32	oicq/wlogin_sdk/request/d:h	Loicq/wlogin_sdk/request/b;
    //   41: invokevirtual 308	oicq/wlogin_sdk/request/b:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   44: astore_0
    //   45: goto +30 -> 75
    //   48: getstatic 34	oicq/wlogin_sdk/request/d:i	Loicq/wlogin_sdk/request/b;
    //   51: ifnonnull +17 -> 68
    //   54: new 68	oicq/wlogin_sdk/request/b
    //   57: dup
    //   58: aload_0
    //   59: aload_1
    //   60: aconst_null
    //   61: iconst_1
    //   62: invokespecial 71	oicq/wlogin_sdk/request/b:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   65: putstatic 34	oicq/wlogin_sdk/request/d:i	Loicq/wlogin_sdk/request/b;
    //   68: getstatic 34	oicq/wlogin_sdk/request/d:i	Loicq/wlogin_sdk/request/b;
    //   71: invokevirtual 308	oicq/wlogin_sdk/request/b:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   74: astore_0
    //   75: aload_0
    //   76: invokevirtual 81	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   79: invokestatic 84	oicq/wlogin_sdk/request/d:c	(Ljava/lang/String;)V
    //   82: new 86	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   89: astore_3
    //   90: aload_3
    //   91: ldc_w 310
    //   94: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload_3
    //   99: aload_1
    //   100: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_3
    //   105: ldc_w 312
    //   108: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_0
    //   113: aload_3
    //   114: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: aconst_null
    //   118: invokevirtual 316	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   121: astore_3
    //   122: aload 7
    //   124: astore 4
    //   126: aload_3
    //   127: astore 6
    //   129: aload_0
    //   130: astore 5
    //   132: aload_3
    //   133: invokeinterface 319 1 0
    //   138: ifeq +35 -> 173
    //   141: aload 7
    //   143: astore 4
    //   145: aload_3
    //   146: astore 6
    //   148: aload_0
    //   149: astore 5
    //   151: aload_3
    //   152: iconst_0
    //   153: invokeinterface 323 2 0
    //   158: ifle +15 -> 173
    //   161: aload_3
    //   162: astore 6
    //   164: aload_0
    //   165: astore 5
    //   167: iconst_1
    //   168: invokestatic 305	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   171: astore 4
    //   173: aload_3
    //   174: ifnull +30 -> 204
    //   177: aload_3
    //   178: astore 6
    //   180: aload_0
    //   181: astore 5
    //   183: aload_3
    //   184: invokeinterface 142 1 0
    //   189: ifne +15 -> 204
    //   192: aload_3
    //   193: astore 6
    //   195: aload_0
    //   196: astore 5
    //   198: aload_3
    //   199: invokeinterface 145 1 0
    //   204: aload_3
    //   205: astore 6
    //   207: aload_0
    //   208: astore 5
    //   210: aload 4
    //   212: invokevirtual 326	java/lang/Boolean:booleanValue	()Z
    //   215: istore_2
    //   216: iload_2
    //   217: ifne +48 -> 265
    //   220: aload_3
    //   221: ifnull +18 -> 239
    //   224: aload_3
    //   225: invokeinterface 142 1 0
    //   230: ifne +9 -> 239
    //   233: aload_3
    //   234: invokeinterface 145 1 0
    //   239: aload_0
    //   240: ifnull +23 -> 263
    //   243: iconst_1
    //   244: aload_0
    //   245: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   248: if_icmpne +15 -> 263
    //   251: ldc_w 328
    //   254: ldc 152
    //   256: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload_0
    //   260: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   263: aconst_null
    //   264: areturn
    //   265: aload_3
    //   266: astore 6
    //   268: aload_0
    //   269: astore 5
    //   271: aload_0
    //   272: aload_1
    //   273: iconst_1
    //   274: anewarray 62	java/lang/String
    //   277: dup
    //   278: iconst_0
    //   279: aload_1
    //   280: aastore
    //   281: ldc 107
    //   283: aconst_null
    //   284: aconst_null
    //   285: aconst_null
    //   286: aconst_null
    //   287: invokevirtual 111	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   290: astore 4
    //   292: aload 4
    //   294: ifnonnull +51 -> 345
    //   297: aload 4
    //   299: ifnull +20 -> 319
    //   302: aload 4
    //   304: invokeinterface 142 1 0
    //   309: ifne +10 -> 319
    //   312: aload 4
    //   314: invokeinterface 145 1 0
    //   319: aload_0
    //   320: ifnull +23 -> 343
    //   323: iconst_1
    //   324: aload_0
    //   325: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   328: if_icmpne +15 -> 343
    //   331: ldc_w 328
    //   334: ldc 152
    //   336: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   339: aload_0
    //   340: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   343: aconst_null
    //   344: areturn
    //   345: aload 4
    //   347: invokeinterface 331 1 0
    //   352: ifeq +67 -> 419
    //   355: aload 4
    //   357: iconst_0
    //   358: invokeinterface 335 2 0
    //   363: astore_3
    //   364: aload 4
    //   366: invokeinterface 145 1 0
    //   371: aload 4
    //   373: ifnull +20 -> 393
    //   376: aload 4
    //   378: invokeinterface 142 1 0
    //   383: ifne +10 -> 393
    //   386: aload 4
    //   388: invokeinterface 145 1 0
    //   393: aload_0
    //   394: ifnull +23 -> 417
    //   397: iconst_1
    //   398: aload_0
    //   399: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   402: if_icmpne +15 -> 417
    //   405: ldc_w 328
    //   408: ldc 152
    //   410: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   413: aload_0
    //   414: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   417: aload_3
    //   418: areturn
    //   419: aload 4
    //   421: invokeinterface 145 1 0
    //   426: aload 4
    //   428: ifnull +20 -> 448
    //   431: aload 4
    //   433: invokeinterface 142 1 0
    //   438: ifne +10 -> 448
    //   441: aload 4
    //   443: invokeinterface 145 1 0
    //   448: aload_0
    //   449: ifnull +23 -> 472
    //   452: iconst_1
    //   453: aload_0
    //   454: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   457: if_icmpne +15 -> 472
    //   460: ldc_w 328
    //   463: ldc 152
    //   465: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   468: aload_0
    //   469: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   472: aconst_null
    //   473: areturn
    //   474: astore_3
    //   475: aload 4
    //   477: astore_1
    //   478: aload_0
    //   479: astore 5
    //   481: aload_3
    //   482: astore_0
    //   483: goto +155 -> 638
    //   486: astore 5
    //   488: aload 4
    //   490: astore_3
    //   491: aload 5
    //   493: astore 4
    //   495: goto +43 -> 538
    //   498: astore 4
    //   500: goto +38 -> 538
    //   503: astore_3
    //   504: aload 4
    //   506: astore_1
    //   507: aload_0
    //   508: astore 5
    //   510: aload_3
    //   511: astore_0
    //   512: goto +126 -> 638
    //   515: astore 4
    //   517: aconst_null
    //   518: astore_3
    //   519: goto +19 -> 538
    //   522: astore_0
    //   523: aconst_null
    //   524: astore 5
    //   526: aload 4
    //   528: astore_1
    //   529: goto +109 -> 638
    //   532: astore 4
    //   534: aconst_null
    //   535: astore_0
    //   536: aload_0
    //   537: astore_3
    //   538: aload_3
    //   539: astore 6
    //   541: aload_0
    //   542: astore 5
    //   544: aload_1
    //   545: ldc 60
    //   547: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   550: ifeq +16 -> 566
    //   553: aload_3
    //   554: astore 6
    //   556: aload_0
    //   557: astore 5
    //   559: aconst_null
    //   560: putstatic 32	oicq/wlogin_sdk/request/d:h	Loicq/wlogin_sdk/request/b;
    //   563: goto +13 -> 576
    //   566: aload_3
    //   567: astore 6
    //   569: aload_0
    //   570: astore 5
    //   572: aconst_null
    //   573: putstatic 34	oicq/wlogin_sdk/request/d:i	Loicq/wlogin_sdk/request/b;
    //   576: aload_3
    //   577: astore 6
    //   579: aload_0
    //   580: astore 5
    //   582: aload 4
    //   584: ldc 152
    //   586: invokestatic 163	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   589: aload_3
    //   590: ifnull +18 -> 608
    //   593: aload_3
    //   594: invokeinterface 142 1 0
    //   599: ifne +9 -> 608
    //   602: aload_3
    //   603: invokeinterface 145 1 0
    //   608: aload_0
    //   609: ifnull +23 -> 632
    //   612: iconst_1
    //   613: aload_0
    //   614: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   617: if_icmpne +15 -> 632
    //   620: ldc_w 328
    //   623: ldc 152
    //   625: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   628: aload_0
    //   629: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   632: aconst_null
    //   633: areturn
    //   634: astore_0
    //   635: aload 6
    //   637: astore_1
    //   638: aload_1
    //   639: ifnull +18 -> 657
    //   642: aload_1
    //   643: invokeinterface 142 1 0
    //   648: ifne +9 -> 657
    //   651: aload_1
    //   652: invokeinterface 145 1 0
    //   657: aload 5
    //   659: ifnull +25 -> 684
    //   662: iconst_1
    //   663: aload 5
    //   665: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   668: if_icmpne +16 -> 684
    //   671: ldc_w 328
    //   674: ldc 152
    //   676: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   679: aload 5
    //   681: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   684: aload_0
    //   685: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	686	0	paramContext	Context
    //   0	686	1	paramString	String
    //   215	2	2	bool	boolean
    //   89	329	3	localObject1	Object
    //   474	8	3	localObject2	Object
    //   490	1	3	localObject3	Object
    //   503	8	3	localObject4	Object
    //   518	85	3	localContext1	Context
    //   7	487	4	localObject5	Object
    //   498	7	4	localException1	Exception
    //   515	12	4	localException2	Exception
    //   532	51	4	localException3	Exception
    //   130	350	5	localContext2	Context
    //   486	6	5	localException4	Exception
    //   508	172	5	localContext3	Context
    //   127	509	6	localObject6	Object
    //   4	138	7	localBoolean	java.lang.Boolean
    // Exception table:
    //   from	to	target	type
    //   345	371	474	finally
    //   419	426	474	finally
    //   345	371	486	java/lang/Exception
    //   419	426	486	java/lang/Exception
    //   132	141	498	java/lang/Exception
    //   151	161	498	java/lang/Exception
    //   167	173	498	java/lang/Exception
    //   183	192	498	java/lang/Exception
    //   198	204	498	java/lang/Exception
    //   210	216	498	java/lang/Exception
    //   271	292	498	java/lang/Exception
    //   75	122	503	finally
    //   75	122	515	java/lang/Exception
    //   9	38	522	finally
    //   38	45	522	finally
    //   48	68	522	finally
    //   68	75	522	finally
    //   9	38	532	java/lang/Exception
    //   38	45	532	java/lang/Exception
    //   48	68	532	java/lang/Exception
    //   68	75	532	java/lang/Exception
    //   132	141	634	finally
    //   151	161	634	finally
    //   167	173	634	finally
    //   183	192	634	finally
    //   198	204	634	finally
    //   210	216	634	finally
    //   271	292	634	finally
    //   544	553	634	finally
    //   559	563	634	finally
    //   572	576	634	finally
    //   582	589	634	finally
  }
  
  private static TreeMap b(Context paramContext, String paramString)
  {
    try
    {
      localObject1 = new SecretKeySpec(t.B, "DESede");
      localObject2 = Cipher.getInstance("DESede");
      ((Cipher)localObject2).init(2, (Key)localObject1);
      localObject1 = new ObjectInputStream(new CipherInputStream(paramContext.openFileInput(paramString), (Cipher)localObject2));
      try
      {
        localObject2 = (TreeMap)((ObjectInputStream)localObject1).readObject();
        paramString = (String)localObject2;
      }
      catch (Throwable localThrowable3)
      {
        localObject2 = localObject1;
      }
      if ((localThrowable4 instanceof FileNotFoundException)) {}
    }
    catch (Throwable localThrowable4)
    {
      localObject2 = null;
    }
    try
    {
      localObject1 = new byte[256];
      localObject3 = paramContext.openFileInput(paramString);
      for (;;)
      {
        j = ((FileInputStream)localObject3).read((byte[])localObject1, 0, localObject1.length);
        if (j <= 0) {
          break;
        }
        util.LOGI(util.buf_to_string((byte[])localObject1, j));
      }
      ((FileInputStream)localObject3).close();
    }
    catch (Exception localException)
    {
      Object localObject3;
      int j;
      label139:
      label219:
      break label139;
    }
    try
    {
      localObject1 = new SecretKeySpec(new String("%4;7t>;28<fc.5*6").getBytes(), "DESede");
      localObject3 = Cipher.getInstance("DESede");
      ((Cipher)localObject3).init(2, (Key)localObject1);
      localObject1 = new ObjectInputStream(new CipherInputStream(paramContext.openFileInput(paramString), (Cipher)localObject3));
    }
    catch (Throwable localThrowable1)
    {
      break label223;
    }
    try
    {
      localObject2 = (TreeMap)((ObjectInputStream)localObject1).readObject();
      paramString = (String)localObject2;
    }
    catch (Throwable localThrowable2)
    {
      break label219;
    }
    Object localObject2 = localObject1;
    label223:
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        localObject3 = new byte[256];
        localObject1 = localObject2;
        j = localObject3.length - 40;
        localObject1 = localObject2;
        localFileInputStream = paramContext.openFileInput(paramString);
        localObject1 = localObject2;
        localFileOutputStream = paramContext.openFileOutput("tmp_tk_file", 0);
        paramString = (String)localObject2;
      }
      catch (Exception paramString)
      {
        FileInputStream localFileInputStream;
        FileOutputStream localFileOutputStream;
        int n;
        int m;
        int i1;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        continue;
        int k = 0;
        continue;
        continue;
        k = 0;
        continue;
        k = 0;
        continue;
        k = 0;
        continue;
        continue;
        continue;
        continue;
      }
      localObject1 = paramString;
      n = localFileInputStream.read((byte[])localObject3, 40, j);
      if (n <= 0) {
        continue;
      }
      k = 40 + n;
      localObject1 = paramString;
      if (k >= localObject3.length) {
        continue;
      }
      localObject3[k] = 0;
      k += 1;
      continue;
      if (k < 0) {
        continue;
      }
      localObject1 = paramString;
      localObject2 = new String("WloginAllSigInfo").getBytes();
      localObject1 = paramString;
      k = a((byte[])localObject3, k, (byte[])localObject2);
      if (k < 0) {
        continue;
      }
      localObject1 = paramString;
      k += localObject2.length;
      localObject1 = paramString;
      if (k + 8 > localObject3.length) {
        continue;
      }
      m = k + 0;
      if (localObject3[m] != -127) {
        continue;
      }
      i1 = k + 1;
      if (localObject3[i1] != 64) {
        continue;
      }
      i2 = k + 2;
      if (localObject3[i2] != 1) {
        continue;
      }
      i3 = k + 3;
      if (localObject3[i3] != 111) {
        continue;
      }
      i4 = k + 4;
      if (localObject3[i4] != -111) {
        continue;
      }
      i5 = k + 5;
      if (localObject3[i5] != -44) {
        continue;
      }
      i6 = k + 6;
      i7 = localObject3[i6];
      if (i7 != 26) {
        continue;
      }
      i7 = k + 7;
      if (localObject3[i7] != -101) {
        continue;
      }
      localObject3[m] = 0;
      localObject3[i1] = 0;
      localObject3[i2] = 0;
      localObject3[i3] = 0;
      localObject3[i4] = 0;
      localObject3[i5] = 0;
      localObject3[i6] = 0;
      localObject3[i7] = 1;
      continue;
      if (k < 0) {
        continue;
      }
      localObject1 = paramString;
      try
      {
        localObject2 = new String("WloginSigInfo").getBytes();
        localObject1 = paramString;
        k = a((byte[])localObject3, k, (byte[])localObject2);
        if (k < 0) {
          continue;
        }
        localObject1 = paramString;
        m = k + localObject2.length;
        k = m;
        localObject1 = paramString;
        if (m + 8 > localObject3.length) {
          continue;
        }
        i1 = m + 0;
        k = m;
        if (localObject3[i1] != 0) {
          continue;
        }
        i2 = m + 1;
        k = m;
        if (localObject3[i2] != 0) {
          continue;
        }
        i3 = m + 2;
        k = m;
        if (localObject3[i3] != 0) {
          continue;
        }
        i4 = m + 3;
        k = m;
        if (localObject3[i4] != 0) {
          continue;
        }
        i5 = m + 4;
        k = m;
        if (localObject3[i5] != 0) {
          continue;
        }
        i6 = m + 5;
        k = m;
        if (localObject3[i6] != 0) {
          continue;
        }
        i7 = m + 6;
        k = m;
        if (localObject3[i7] != 0) {
          continue;
        }
        i8 = m + 7;
        k = m;
        if (localObject3[i8] != 0) {
          continue;
        }
        localObject3[i1] = 0;
        localObject3[i2] = 0;
        localObject3[i3] = 0;
        localObject3[i4] = 0;
        localObject3[i5] = 0;
        localObject3[i6] = 0;
        localObject3[i7] = 0;
        localObject3[i8] = 1;
        k = m;
      }
      catch (Exception paramString)
      {
        int i8;
        continue;
      }
      if (k < 0) {
        continue;
      }
      localObject1 = paramString;
      localObject2 = new String("WloginSimpleInfo").getBytes();
      localObject1 = paramString;
      k = a((byte[])localObject3, k, (byte[])localObject2);
      if (k < 0) {
        continue;
      }
      localObject1 = paramString;
      m = k + localObject2.length;
      k = m;
      localObject1 = paramString;
      if (m + 8 <= localObject3.length)
      {
        i1 = m + 0;
        k = m;
        if (localObject3[i1] == 57)
        {
          i2 = m + 1;
          k = m;
          if (localObject3[i2] == -69)
          {
            i3 = m + 2;
            k = m;
            if (localObject3[i3] == -84)
            {
              i4 = m + 3;
              k = m;
              if (localObject3[i4] == 110)
              {
                i5 = m + 4;
                k = m;
                if (localObject3[i5] == -46)
                {
                  i6 = m + 5;
                  k = m;
                  if (localObject3[i6] == 98)
                  {
                    i7 = m + 6;
                    k = m;
                    if (localObject3[i7] == -31)
                    {
                      i8 = m + 7;
                      k = m;
                      if (localObject3[i8] == -113)
                      {
                        localObject3[i1] = 0;
                        localObject3[i2] = 0;
                        localObject3[i3] = 0;
                        localObject3[i4] = 0;
                        localObject3[i5] = 0;
                        localObject3[i6] = 0;
                        localObject3[i7] = 0;
                        localObject3[i8] = 1;
                        k = m;
                        continue;
                        if (k < 0) {
                          continue;
                        }
                        localObject1 = paramString;
                        localObject2 = new String("UinInfo").getBytes();
                        localObject1 = paramString;
                        k = a((byte[])localObject3, k, (byte[])localObject2);
                        if (k >= 0)
                        {
                          localObject1 = paramString;
                          k += localObject2.length;
                          localObject1 = paramString;
                          if (k + 8 > localObject3.length) {
                            continue;
                          }
                          m = k + 0;
                          if (localObject3[m] != -118) {
                            continue;
                          }
                          i1 = k + 1;
                          if (localObject3[i1] != -23) {
                            continue;
                          }
                          i2 = k + 2;
                          if (localObject3[i2] != -128) {
                            continue;
                          }
                          i3 = k + 3;
                          if (localObject3[i3] != -19) {
                            continue;
                          }
                          i4 = k + 4;
                          if (localObject3[i4] != -26) {
                            continue;
                          }
                          i5 = k + 5;
                          if (localObject3[i5] != 99) {
                            continue;
                          }
                          i6 = k + 6;
                          if (localObject3[i6] != 41) {
                            continue;
                          }
                          i7 = k + 7;
                          if (localObject3[i7] != 14) {
                            continue;
                          }
                          localObject3[m] = 0;
                          localObject3[i1] = 0;
                          localObject3[i2] = 0;
                          localObject3[i3] = 0;
                          localObject3[i4] = 0;
                          localObject3[i5] = 0;
                          localObject3[i6] = 0;
                          localObject3[i7] = 1;
                        }
                        else
                        {
                          localObject1 = paramString;
                          localFileOutputStream.write((byte[])localObject3, 40, n);
                          if (n <= 40) {
                            continue;
                          }
                          localObject1 = paramString;
                          System.arraycopy(localObject3, n, localObject3, 0, 40);
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
    }
    localObject1 = paramString;
    localFileInputStream.close();
    localObject1 = paramString;
    localFileOutputStream.close();
    localObject1 = paramString;
    localObject2 = new ObjectInputStream(paramContext.openFileInput("tmp_tk_file"));
    localObject1 = localObject2;
    paramString = (TreeMap)((ObjectInputStream)localObject2).readObject();
    localObject1 = localObject2;
    break label1428;
    paramString = null;
    label1428:
    paramContext.deleteFile("tmp_tk_file");
    if (paramString != null) {}
    try
    {
      ((ObjectInputStream)localObject1).close();
      return paramString;
    }
    catch (Exception paramContext)
    {
      label1450:
      break label1450;
    }
    return null;
  }
  
  private static void c(String paramString)
  {
    long l = new File(paramString).lastModified();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" last update stample ");
    localStringBuilder.append(l);
    util.LOGI(localStringBuilder.toString(), "");
  }
  
  public int a(long paramLong1, long paramLong2)
  {
    try
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("start clear_da2 ");
      ((StringBuilder)???).append(paramLong2);
      ??? = ((StringBuilder)???).toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(paramLong1);
      util.LOGI((String)???, ((StringBuilder)localObject3).toString());
      ??? = this.a;
      int j = 0;
      int k = 0;
      if (??? != null) {
        synchronized (f)
        {
          localObject3 = a(this.a, "tk_file", paramLong1);
          j = k;
          if (localObject3 != null)
          {
            WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)((TreeMap)localObject3).get(Long.valueOf(paramLong1));
            if (localWloginAllSigInfo == null) {
              return -1;
            }
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("");
            localStringBuilder2.append(paramLong1);
            util.LOGI("clear_da2 clear DA2 in file", localStringBuilder2.toString());
            localWloginAllSigInfo.put_da2(paramLong2, new byte[0]);
            j = a((TreeMap)localObject3, "tk_file");
            this.c = ((TreeMap)localObject3);
          }
        }
      }
      ??? = new StringBuilder();
      ((StringBuilder)???).append("end clear_da2 ret ");
      ((StringBuilder)???).append(j);
      ??? = ((StringBuilder)???).toString();
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("");
      localStringBuilder1.append(paramLong1);
      util.LOGI((String)???, localStringBuilder1.toString());
      return j;
    }
    finally {}
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("start put_siginfo ");
      ((StringBuilder)localObject1).append(paramLong2);
      localObject1 = ((StringBuilder)localObject1).toString();
      ??? = new StringBuilder();
      ((StringBuilder)???).append("");
      ((StringBuilder)???).append(paramLong1);
      util.LOGI((String)localObject1, ((StringBuilder)???).toString());
      localObject1 = (WloginAllSigInfo)this.c.get(Long.valueOf(paramLong1));
      if (localObject1 == null) {
        return -1;
      }
      int j = ((WloginAllSigInfo)localObject1).put_siginfo(paramLong2, paramLong3, paramLong4, paramArrayOfByte1, paramArrayOfByte2);
      if (this.a != null) {
        synchronized (f)
        {
          paramArrayOfByte2 = a(this.a, "tk_file", paramLong1);
          paramArrayOfByte1 = paramArrayOfByte2;
          if (paramArrayOfByte2 == null) {
            paramArrayOfByte1 = new TreeMap();
          }
          paramArrayOfByte1.put(Long.valueOf(paramLong1), ((WloginAllSigInfo)localObject1).get_clone());
          a(paramArrayOfByte1, "tk_file");
        }
      }
      return j;
    }
    finally {}
  }
  
  public int a(long paramLong1, long paramLong2, byte[][] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, WloginSimpleInfo paramWloginSimpleInfo, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, byte[] paramArrayOfByte11, byte[] paramArrayOfByte12, byte[] paramArrayOfByte13, byte[][] paramArrayOfByte14, long[] paramArrayOfLong, int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("start put_siginfo skey ");
        ((StringBuilder)localObject1).append(util.getMaskBytes(paramArrayOfByte10, 2, 2));
        localObject1 = ((StringBuilder)localObject1).toString();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(paramLong1);
        util.LOGI((String)localObject1, ((StringBuilder)localObject2).toString());
        localObject1 = this.a;
        int j = 0;
        if (localObject1 != null) {
          synchronized (f)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("");
            ((StringBuilder)localObject1).append(paramLong1);
            util.LOGI("put_siginfo load file", ((StringBuilder)localObject1).toString());
            localObject2 = a(this.a, "tk_file", paramLong1);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = new TreeMap();
            }
            localObject2 = (WloginAllSigInfo)this.c.get(Long.valueOf(paramLong1));
            if (localObject2 != null) {
              break label1399;
            }
            localObject2 = (WloginAllSigInfo)((TreeMap)localObject1).get(Long.valueOf(paramLong1));
            if (localObject2 != null) {
              break label1396;
            }
            localObject2 = new WloginAllSigInfo();
            Object localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("mainSigMap 0x");
            ((StringBuilder)localObject3).append(Integer.toHexString(this.e));
            localObject3 = ((StringBuilder)localObject3).toString();
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("");
            ((StringBuilder)localObject4).append(paramLong1);
            util.LOGI((String)localObject3, ((StringBuilder)localObject4).toString());
            ((WloginAllSigInfo)localObject2).mainSigMap = this.e;
            localObject3 = new byte[0];
            localObject5 = new byte[0];
            byte[] arrayOfByte1 = new byte[0];
            byte[] arrayOfByte2 = new byte[0];
            byte[] arrayOfByte3 = new byte[0];
            Object localObject6 = new byte[0];
            Object localObject7 = (WloginSigInfo)((WloginAllSigInfo)localObject2)._tk_map.get(Long.valueOf(paramLong2));
            if (localObject7 == null) {
              break label1402;
            }
            localObject4 = localObject3;
            localObject3 = localObject5;
            if (((WloginSigInfo)localObject7)._en_A1 != null)
            {
              localObject6 = (byte[])((WloginSigInfo)localObject7)._en_A1.clone();
              localObject4 = localObject6;
              localObject3 = localObject5;
              if (((WloginSigInfo)localObject7)._noPicSig != null)
              {
                localObject3 = (byte[])((WloginSigInfo)localObject7)._noPicSig.clone();
                localObject4 = localObject6;
              }
            }
            if (((WloginSigInfo)localObject7)._G != null) {
              arrayOfByte1 = (byte[])((WloginSigInfo)localObject7)._G.clone();
            }
            if (((WloginSigInfo)localObject7)._dpwd != null) {
              arrayOfByte2 = (byte[])((WloginSigInfo)localObject7)._dpwd.clone();
            }
            if (((WloginSigInfo)localObject7)._randseed != null) {
              arrayOfByte3 = (byte[])((WloginSigInfo)localObject7)._randseed.clone();
            }
            localObject6 = ((WloginSigInfo)localObject7)._psKey;
            localObject5 = ((WloginSigInfo)localObject7)._pt4Token;
            localObject7 = localObject3;
            localObject3 = localObject4;
            localObject4 = localObject7;
            HashMap localHashMap1;
            HashMap localHashMap2;
            HashMap localHashMap3;
            if ((paramArrayOfByte14[6] != null) && (paramArrayOfByte14[6].length > 2))
            {
              localObject7 = new HashMap();
              localHashMap1 = new HashMap();
              localHashMap2 = new HashMap();
              localHashMap3 = new HashMap();
              Ticket.parsePsBuf((byte[])localObject6, paramLong5, (Map)localObject7, localHashMap1);
              Ticket.parsePsBuf((byte[])localObject5, paramLong5, localHashMap2, localHashMap3);
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("current pskey size:");
              ((StringBuilder)localObject5).append(((Map)localObject7).size());
              ((StringBuilder)localObject5).append(":");
              ((StringBuilder)localObject5).append(localHashMap1.size());
              util.LOGI(((StringBuilder)localObject5).toString(), "");
              localObject5 = localHashMap1.entrySet().iterator();
              Object localObject9;
              if (((Iterator)localObject5).hasNext())
              {
                localObject9 = (Map.Entry)((Iterator)localObject5).next();
                localObject6 = (String)((Map.Entry)localObject9).getKey();
                if (!Ticket.isPskeyStorageExpired(((Long)((Map.Entry)localObject9).getValue()).longValue())) {
                  continue;
                }
                ((Iterator)localObject5).remove();
                ((Map)localObject7).remove(localObject6);
                localObject9 = new StringBuilder();
                ((StringBuilder)localObject9).append("delete expired pskey from file,key:");
                ((StringBuilder)localObject9).append((String)localObject6);
                util.LOGI(((StringBuilder)localObject9).toString(), "");
                continue;
              }
              localObject5 = localHashMap3.entrySet().iterator();
              localObject6 = new StringBuilder();
              ((StringBuilder)localObject6).append("current pt4token size:");
              ((StringBuilder)localObject6).append(localHashMap2.size());
              ((StringBuilder)localObject6).append(":");
              ((StringBuilder)localObject6).append(localHashMap3.size());
              util.LOGI(((StringBuilder)localObject6).toString(), "");
              if (((Iterator)localObject5).hasNext())
              {
                localObject9 = (Map.Entry)((Iterator)localObject5).next();
                localObject6 = (String)((Map.Entry)localObject9).getKey();
                if (!Ticket.isPskeyStorageExpired(((Long)((Map.Entry)localObject9).getValue()).longValue())) {
                  continue;
                }
                ((Iterator)localObject5).remove();
                localHashMap2.remove(localObject6);
                localObject9 = new StringBuilder();
                ((StringBuilder)localObject9).append("delete expired pt4token from file,key:");
                ((StringBuilder)localObject9).append((String)localObject6);
                util.LOGI(((StringBuilder)localObject9).toString(), "");
                continue;
              }
              Ticket.parseSvrPs(paramArrayOfByte14[6], paramLong5, (Map)localObject7, localHashMap1, localHashMap2, localHashMap3);
            }
            try
            {
              paramArrayOfByte14[6] = Ticket.packPsBuf((Map)localObject7, paramLong5, localHashMap1);
              paramArrayOfByte14[12] = Ticket.packPsBuf(localHashMap2, paramLong5, localHashMap3);
            }
            catch (BufferOverflowException paramArrayOfByte1)
            {
              continue;
            }
            paramArrayOfByte1 = new StringBuilder();
            paramArrayOfByte1.append("map size ");
            paramArrayOfByte1.append(((Map)localObject7).size());
            paramArrayOfByte1.append("is too large");
            paramArrayOfByte1 = paramArrayOfByte1.toString();
            paramWloginSimpleInfo = new StringBuilder();
            paramWloginSimpleInfo.append("");
            paramWloginSimpleInfo.append(paramLong1);
            util.LOGI(paramArrayOfByte1, paramWloginSimpleInfo.toString());
            a(Long.valueOf(paramLong1));
            return -1023;
            ((WloginAllSigInfo)localObject2).put_simpleinfo(paramWloginSimpleInfo);
            ((WloginAllSigInfo)localObject2).put_siginfo(paramLong3, paramLong4, paramLong5, paramLong6, paramLong7, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6, paramArrayOfByte7, paramArrayOfByte8, paramArrayOfByte9, paramArrayOfByte10, paramArrayOfByte11, paramArrayOfByte12, paramArrayOfByte13, paramArrayOfByte14, paramArrayOfLong, paramInt);
            ((WloginAllSigInfo)localObject2).put_siginfo(paramLong2, paramArrayOfByte1, paramLong5);
            ((TreeMap)localObject1).put(Long.valueOf(paramLong1), ((WloginAllSigInfo)localObject2).get_clone());
            j = a((TreeMap)localObject1, "tk_file");
            paramArrayOfByte1 = new StringBuilder();
            paramArrayOfByte1.append("save key result:tk_file:");
            paramArrayOfByte1.append(j);
            util.LOGI(paramArrayOfByte1.toString(), "");
            if (j != 0)
            {
              paramArrayOfByte1 = (WloginSigInfo)((WloginAllSigInfo)localObject2)._tk_map.get(Long.valueOf(paramLong2));
              if (paramArrayOfByte1 != null)
              {
                paramArrayOfByte1._en_A1 = ((byte[])((byte[])localObject3).clone());
                paramArrayOfByte1._noPicSig = ((byte[])((byte[])localObject4).clone());
                paramArrayOfByte1._G = ((byte[])arrayOfByte1.clone());
                paramArrayOfByte1._dpwd = ((byte[])arrayOfByte2.clone());
                paramArrayOfByte1._randseed = ((byte[])arrayOfByte3.clone());
              }
            }
            paramArrayOfByte1 = new StringBuilder();
            paramArrayOfByte1.append("");
            paramArrayOfByte1.append(paramLong1);
            util.LOGI("sig in memory changed", paramArrayOfByte1.toString());
            this.c.put(Long.valueOf(paramLong1), ((WloginAllSigInfo)localObject2).get_clone());
          }
        } else {
          return j;
        }
      }
      finally {}
      label1396:
      continue;
      label1399:
      continue;
      label1402:
      Object localObject4 = localObject5;
      Object localObject5 = new byte[0];
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
    label347:
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
              break label347;
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
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mem got_account name: ");
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file got_account name: ");
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
      ??? = new StringBuilder();
      ((StringBuilder)???).append("start put_randseed ");
      ((StringBuilder)???).append(paramLong2);
      ??? = ((StringBuilder)???).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(paramLong1);
      util.LOGI((String)???, ((StringBuilder)localObject2).toString());
      if (this.a != null) {
        synchronized (f)
        {
          localObject2 = a(this.a, "tk_file", paramLong1);
          if (localObject2 != null)
          {
            WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)((TreeMap)localObject2).get(Long.valueOf(paramLong1));
            if (localWloginAllSigInfo == null)
            {
              paramArrayOfByte = new StringBuilder();
              paramArrayOfByte.append("fileInfo is null ");
              paramArrayOfByte.append(paramLong2);
              paramArrayOfByte = paramArrayOfByte.toString();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("");
              ((StringBuilder)localObject2).append(paramLong1);
              util.LOGI(paramArrayOfByte, ((StringBuilder)localObject2).toString());
              return;
            }
            localWloginAllSigInfo.put_randseed(paramLong2, paramArrayOfByte);
            int j = a((TreeMap)localObject2, "tk_file");
            if (j != 0)
            {
              paramArrayOfByte = new StringBuilder();
              paramArrayOfByte.append("put_randseed refreshTKTreeMap failed ret ");
              paramArrayOfByte.append(j);
              paramArrayOfByte.append(" appid ");
              paramArrayOfByte.append(paramLong2);
              paramArrayOfByte = paramArrayOfByte.toString();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("");
              ((StringBuilder)localObject2).append(paramLong1);
              util.LOGI(paramArrayOfByte, ((StringBuilder)localObject2).toString());
              return;
            }
            this.c = ((TreeMap)localObject2);
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("");
            paramArrayOfByte.append(paramLong1);
            util.LOGI("end put_randseed", paramArrayOfByte.toString());
          }
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
      ??? = new StringBuilder();
      ((StringBuilder)???).append("");
      ((StringBuilder)???).append(paramLong);
      util.LOGI("start clear_sig", ((StringBuilder)???).toString());
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
      ??? = new StringBuilder();
      ((StringBuilder)???).append("");
      ((StringBuilder)???).append(paramLong1);
      util.LOGI("start clear_sig", ((StringBuilder)???).toString());
      ??? = (WloginAllSigInfo)this.c.get(paramLong1);
      if (??? != null)
      {
        ((WloginAllSigInfo)???)._tk_map.remove(paramLong2);
        ??? = new StringBuilder();
        ((StringBuilder)???).append("uin ");
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
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("put account ");
      ((StringBuilder)localObject1).append(paramString);
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(paramLong);
      util.LOGI((String)localObject1, ((StringBuilder)localObject2).toString());
      localObject2 = b(paramLong);
      if (localObject2 != null) {
        this.d.remove(localObject2);
      }
      UinInfo localUinInfo = new UinInfo(paramLong, paramBoolean);
      this.d.put(paramString, localUinInfo);
      if (this.a != null) {
        synchronized (g)
        {
          localObject1 = a(this.a, "name_file", 0L);
          paramLong = (Long)localObject1;
          if (localObject1 == null) {
            paramLong = new TreeMap();
          }
          if (localObject2 != null) {
            paramLong.remove(localObject2);
          }
          paramLong.put(paramString, localUinInfo);
          a(paramLong, "name_file");
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
    //   2: new 660	java/io/ByteArrayOutputStream
    //   5: dup
    //   6: invokespecial 661	java/io/ByteArrayOutputStream:<init>	()V
    //   9: astore 4
    //   11: new 663	java/io/ObjectOutputStream
    //   14: dup
    //   15: aload 4
    //   17: invokespecial 666	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   20: astore 5
    //   22: aload 5
    //   24: aload_1
    //   25: invokevirtual 670	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   28: aload 5
    //   30: invokevirtual 673	java/io/ObjectOutputStream:flush	()V
    //   33: aload 4
    //   35: invokevirtual 676	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   38: astore_1
    //   39: aload_1
    //   40: iconst_0
    //   41: aload_1
    //   42: arraylength
    //   43: getstatic 192	oicq/wlogin_sdk/request/t:B	[B
    //   46: invokestatic 679	oicq/wlogin_sdk/tools/cryptor:encrypt	([BII[B)[B
    //   49: astore_1
    //   50: aload_0
    //   51: getfield 50	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   54: aload_2
    //   55: aload_1
    //   56: invokestatic 681	oicq/wlogin_sdk/request/d:a	(Landroid/content/Context;Ljava/lang/String;[B)I
    //   59: istore_3
    //   60: aload 5
    //   62: invokevirtual 682	java/io/ObjectOutputStream:close	()V
    //   65: aload 4
    //   67: invokevirtual 683	java/io/ByteArrayOutputStream:close	()V
    //   70: goto +55 -> 125
    //   73: astore_1
    //   74: goto +55 -> 129
    //   77: astore_1
    //   78: new 86	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   85: astore_2
    //   86: aload_2
    //   87: ldc_w 685
    //   90: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_2
    //   95: aload_1
    //   96: invokevirtual 689	java/lang/Throwable:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   99: invokevirtual 690	java/lang/Object:toString	()Ljava/lang/String;
    //   102: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload_2
    //   107: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: ldc 152
    //   112: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload_1
    //   116: ldc 152
    //   118: invokestatic 295	oicq/wlogin_sdk/tools/util:printThrowable	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   121: sipush -1022
    //   124: istore_3
    //   125: aload_0
    //   126: monitorexit
    //   127: iload_3
    //   128: ireturn
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_1
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	d
    //   0	133	1	paramTreeMap	TreeMap
    //   0	133	2	paramString	String
    //   59	69	3	j	int
    //   9	57	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   20	41	5	localObjectOutputStream	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   2	70	73	finally
    //   78	121	73	finally
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
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("uin=");
      ((StringBuilder)localObject1).append(paramLong);
      util.LOGI("start get_simpleinfo", ((StringBuilder)localObject1).toString());
      localObject1 = a(paramLong);
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
      ??? = new StringBuilder();
      ((StringBuilder)???).append("start clearNewST ");
      ((StringBuilder)???).append(paramLong2);
      ??? = ((StringBuilder)???).toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(paramLong1);
      util.LOGI((String)???, ((StringBuilder)localObject3).toString());
      ??? = this.a;
      int j = 0;
      int k = 0;
      if (??? != null) {
        synchronized (f)
        {
          localObject3 = a(this.a, "tk_file", paramLong1);
          j = k;
          if (localObject3 != null)
          {
            WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)((TreeMap)localObject3).get(Long.valueOf(paramLong1));
            if (localWloginAllSigInfo == null) {
              return;
            }
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("");
            localStringBuilder2.append(paramLong1);
            util.LOGI("clearNewST clear newST in file", localStringBuilder2.toString());
            localWloginAllSigInfo.putNewST(paramLong2, new byte[0], new byte[0]);
            j = a((TreeMap)localObject3, "tk_file");
            this.c = ((TreeMap)localObject3);
          }
        }
      }
      ??? = new StringBuilder();
      ((StringBuilder)???).append("end clearNewST ret ");
      ((StringBuilder)???).append(j);
      ??? = ((StringBuilder)???).toString();
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("");
      localStringBuilder1.append(paramLong1);
      util.LOGI((String)???, localStringBuilder1.toString());
      return;
    }
    finally {}
  }
  
  public void b(String paramString)
  {
    try
    {
      this.d.remove(paramString);
      ??? = new StringBuilder();
      ((StringBuilder)???).append("clear_account ");
      ((StringBuilder)???).append(paramString);
      util.LOGI(((StringBuilder)???).toString(), "");
      if (this.a != null) {
        synchronized (g)
        {
          TreeMap localTreeMap = a(this.a, "name_file", 0L);
          if (localTreeMap == null) {
            return;
          }
          localTreeMap.remove(paramString);
          a(localTreeMap, "name_file");
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
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("clear_pskey ");
      ((StringBuilder)localObject1).append(paramLong2);
      localObject1 = ((StringBuilder)localObject1).toString();
      ??? = new StringBuilder();
      ((StringBuilder)???).append("");
      ((StringBuilder)???).append(paramLong1);
      util.LOGI((String)localObject1, ((StringBuilder)???).toString());
      localObject1 = (WloginAllSigInfo)this.c.get(Long.valueOf(paramLong1));
      if (localObject1 == null) {
        return;
      }
      ??? = (WloginSigInfo)((WloginAllSigInfo)localObject1)._tk_map.get(Long.valueOf(paramLong2));
      if (??? == null) {
        return;
      }
      ((WloginSigInfo)???)._pt4Token = new byte[0];
      ((WloginSigInfo)???)._psKey = new byte[0];
      ((WloginSigInfo)???).cacheTickets = null;
      ((WloginSigInfo)???).cacheUpdateStamp = 0L;
      ((WloginAllSigInfo)localObject1)._tk_map.put(Long.valueOf(paramLong1), ???);
      if (this.a != null) {
        synchronized (f)
        {
          TreeMap localTreeMap = a(this.a, "tk_file", paramLong1);
          if (localTreeMap != null)
          {
            localTreeMap.put(Long.valueOf(paramLong1), localObject1);
            a(localTreeMap, "tk_file");
            this.c = localTreeMap;
          }
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