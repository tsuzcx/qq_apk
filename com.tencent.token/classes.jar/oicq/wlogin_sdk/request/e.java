package oicq.wlogin_sdk.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import oicq.wlogin_sdk.report.event.b;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class e
{
  private static final Object e = new Object();
  private static final Object f = new Object();
  private static c g = null;
  private static c h = null;
  Context a;
  TreeMap<Long, WloginAllSigInfo> b = new TreeMap();
  TreeMap<String, UinInfo> c = new TreeMap();
  public int d;
  
  public e(Context paramContext)
  {
    this.a = paramContext;
    this.c = a(this.a, "name_file", 0L);
    if (this.c == null) {
      this.c = new TreeMap();
    }
  }
  
  /* Error */
  public static int a(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 53	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 54	java/lang/StringBuffer:<init>	()V
    //   7: astore 10
    //   9: aload_0
    //   10: aload_1
    //   11: aload 10
    //   13: invokestatic 57	oicq/wlogin_sdk/request/e:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   16: aload_1
    //   17: ldc 59
    //   19: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   22: ifeq +34 -> 56
    //   25: getstatic 30	oicq/wlogin_sdk/request/e:g	Loicq/wlogin_sdk/request/c;
    //   28: ifnonnull +17 -> 45
    //   31: new 67	oicq/wlogin_sdk/request/c
    //   34: dup
    //   35: aload_0
    //   36: aload_1
    //   37: aconst_null
    //   38: iconst_1
    //   39: invokespecial 70	oicq/wlogin_sdk/request/c:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   42: putstatic 30	oicq/wlogin_sdk/request/e:g	Loicq/wlogin_sdk/request/c;
    //   45: getstatic 30	oicq/wlogin_sdk/request/e:g	Loicq/wlogin_sdk/request/c;
    //   48: invokevirtual 74	oicq/wlogin_sdk/request/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   51: astore 4
    //   53: goto +31 -> 84
    //   56: getstatic 32	oicq/wlogin_sdk/request/e:h	Loicq/wlogin_sdk/request/c;
    //   59: ifnonnull +17 -> 76
    //   62: new 67	oicq/wlogin_sdk/request/c
    //   65: dup
    //   66: aload_0
    //   67: aload_1
    //   68: aconst_null
    //   69: iconst_1
    //   70: invokespecial 70	oicq/wlogin_sdk/request/c:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   73: putstatic 32	oicq/wlogin_sdk/request/e:h	Loicq/wlogin_sdk/request/c;
    //   76: getstatic 32	oicq/wlogin_sdk/request/e:h	Loicq/wlogin_sdk/request/c;
    //   79: invokevirtual 74	oicq/wlogin_sdk/request/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   82: astore 4
    //   84: aload 4
    //   86: invokevirtual 80	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   89: iconst_1
    //   90: invokestatic 83	oicq/wlogin_sdk/request/e:b	(Ljava/lang/String;Z)V
    //   93: new 85	java/lang/StringBuilder
    //   96: dup
    //   97: ldc 87
    //   99: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   102: astore 5
    //   104: aload 5
    //   106: aload_1
    //   107: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 5
    //   113: ldc 96
    //   115: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 5
    //   121: aload_1
    //   122: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload 5
    //   128: ldc 98
    //   130: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 4
    //   136: aload 5
    //   138: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokevirtual 104	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   144: aload 4
    //   146: aload_1
    //   147: iconst_1
    //   148: anewarray 61	java/lang/String
    //   151: dup
    //   152: iconst_0
    //   153: ldc 106
    //   155: aastore
    //   156: ldc 108
    //   158: aconst_null
    //   159: aconst_null
    //   160: aconst_null
    //   161: aconst_null
    //   162: invokevirtual 112	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   165: astore 9
    //   167: aload 4
    //   169: astore 5
    //   171: aload 9
    //   173: astore 7
    //   175: aload 9
    //   177: invokeinterface 118 1 0
    //   182: ifne +119 -> 301
    //   185: aload 4
    //   187: astore 5
    //   189: aload 9
    //   191: astore 7
    //   193: new 85	java/lang/StringBuilder
    //   196: dup
    //   197: ldc 120
    //   199: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   202: astore 6
    //   204: aload 4
    //   206: astore 5
    //   208: aload 9
    //   210: astore 7
    //   212: aload 6
    //   214: aload_1
    //   215: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload 4
    //   221: astore 5
    //   223: aload 9
    //   225: astore 7
    //   227: aload 6
    //   229: ldc 122
    //   231: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 4
    //   237: astore 5
    //   239: aload 9
    //   241: astore 7
    //   243: aload 6
    //   245: aload_1
    //   246: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 4
    //   252: astore 5
    //   254: aload 9
    //   256: astore 7
    //   258: aload 6
    //   260: ldc 124
    //   262: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 4
    //   268: astore 5
    //   270: aload 9
    //   272: astore 7
    //   274: aload 4
    //   276: aload 6
    //   278: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: iconst_2
    //   282: anewarray 4	java/lang/Object
    //   285: dup
    //   286: iconst_0
    //   287: iconst_0
    //   288: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   291: aastore
    //   292: dup
    //   293: iconst_1
    //   294: iconst_1
    //   295: newarray byte
    //   297: aastore
    //   298: invokevirtual 133	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   301: aload 4
    //   303: astore 5
    //   305: aload 9
    //   307: astore 7
    //   309: new 85	java/lang/StringBuilder
    //   312: dup
    //   313: ldc 135
    //   315: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   318: astore 6
    //   320: aload 4
    //   322: astore 5
    //   324: aload 9
    //   326: astore 7
    //   328: aload 6
    //   330: aload_1
    //   331: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload 4
    //   337: astore 5
    //   339: aload 9
    //   341: astore 7
    //   343: aload 6
    //   345: ldc 137
    //   347: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload 4
    //   353: astore 5
    //   355: aload 9
    //   357: astore 7
    //   359: aload 6
    //   361: aload_1
    //   362: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload 4
    //   368: astore 5
    //   370: aload 9
    //   372: astore 7
    //   374: aload 6
    //   376: ldc 139
    //   378: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: aload 4
    //   384: astore 5
    //   386: aload 9
    //   388: astore 7
    //   390: aload 4
    //   392: aload 6
    //   394: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: iconst_1
    //   398: anewarray 4	java/lang/Object
    //   401: dup
    //   402: iconst_0
    //   403: aload_2
    //   404: aastore
    //   405: invokevirtual 133	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   408: aload 9
    //   410: ifnull +20 -> 430
    //   413: aload 9
    //   415: invokeinterface 143 1 0
    //   420: ifne +10 -> 430
    //   423: aload 9
    //   425: invokeinterface 146 1 0
    //   430: aload 4
    //   432: ifnull +9 -> 441
    //   435: aload 4
    //   437: invokevirtual 149	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   440: pop
    //   441: aload_0
    //   442: aload_1
    //   443: invokestatic 152	oicq/wlogin_sdk/request/e:b	(Landroid/content/Context;Ljava/lang/String;)V
    //   446: iconst_0
    //   447: ireturn
    //   448: astore_0
    //   449: aload_0
    //   450: ldc 154
    //   452: invokestatic 160	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   455: iconst_0
    //   456: ireturn
    //   457: astore 8
    //   459: aload 4
    //   461: astore 6
    //   463: aload 9
    //   465: astore 4
    //   467: goto +46 -> 513
    //   470: astore_0
    //   471: aconst_null
    //   472: astore 7
    //   474: goto +343 -> 817
    //   477: astore 8
    //   479: aconst_null
    //   480: astore 5
    //   482: aload 4
    //   484: astore 6
    //   486: aload 5
    //   488: astore 4
    //   490: goto +23 -> 513
    //   493: astore_0
    //   494: aconst_null
    //   495: astore 4
    //   497: aload 4
    //   499: astore 7
    //   501: goto +316 -> 817
    //   504: astore 8
    //   506: aconst_null
    //   507: astore 4
    //   509: aload 4
    //   511: astore 6
    //   513: aload 6
    //   515: astore 5
    //   517: aload 4
    //   519: astore 7
    //   521: aload_1
    //   522: ldc 59
    //   524: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   527: ifeq +18 -> 545
    //   530: aload 6
    //   532: astore 5
    //   534: aload 4
    //   536: astore 7
    //   538: aconst_null
    //   539: putstatic 30	oicq/wlogin_sdk/request/e:g	Loicq/wlogin_sdk/request/c;
    //   542: goto +15 -> 557
    //   545: aload 6
    //   547: astore 5
    //   549: aload 4
    //   551: astore 7
    //   553: aconst_null
    //   554: putstatic 32	oicq/wlogin_sdk/request/e:h	Loicq/wlogin_sdk/request/c;
    //   557: aload 6
    //   559: astore 5
    //   561: aload 4
    //   563: astore 7
    //   565: aload 10
    //   567: ldc 162
    //   569: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   572: pop
    //   573: aload 6
    //   575: astore 5
    //   577: aload 4
    //   579: astore 7
    //   581: aload 10
    //   583: aload 8
    //   585: invokestatic 169	oicq/wlogin_sdk/tools/util:getThrowableInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   588: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   591: pop
    //   592: aload 6
    //   594: astore 5
    //   596: aload 4
    //   598: astore 7
    //   600: aload_0
    //   601: aload_1
    //   602: aload_2
    //   603: aload 10
    //   605: invokestatic 172	oicq/wlogin_sdk/request/e:a	(Landroid/content/Context;Ljava/lang/String;[BLjava/lang/StringBuffer;)Z
    //   608: istore_3
    //   609: goto +243 -> 852
    //   612: astore_2
    //   613: aload 6
    //   615: astore 5
    //   617: aload 4
    //   619: astore 7
    //   621: aload 10
    //   623: ldc 174
    //   625: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   628: pop
    //   629: aload 6
    //   631: astore 5
    //   633: aload 4
    //   635: astore 7
    //   637: aload 10
    //   639: aload_2
    //   640: invokestatic 169	oicq/wlogin_sdk/tools/util:getThrowableInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   643: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   646: pop
    //   647: iconst_0
    //   648: istore_3
    //   649: goto +203 -> 852
    //   652: aload 6
    //   654: astore 5
    //   656: aload 4
    //   658: astore 7
    //   660: aload_0
    //   661: aload_1
    //   662: aload 10
    //   664: aload_2
    //   665: invokestatic 177	oicq/wlogin_sdk/request/e:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/StringBuffer;Ljava/lang/String;)V
    //   668: aload 6
    //   670: astore 5
    //   672: aload 4
    //   674: astore 7
    //   676: aload 8
    //   678: ldc 154
    //   680: invokestatic 160	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   683: aload 6
    //   685: astore 5
    //   687: aload 4
    //   689: astore 7
    //   691: new 85	java/lang/StringBuilder
    //   694: dup
    //   695: ldc 179
    //   697: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   700: astore_0
    //   701: aload 6
    //   703: astore 5
    //   705: aload 4
    //   707: astore 7
    //   709: aload_0
    //   710: aload 8
    //   712: invokevirtual 182	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   715: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: pop
    //   719: aload 6
    //   721: astore 5
    //   723: aload 4
    //   725: astore 7
    //   727: aload_0
    //   728: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   731: ldc 154
    //   733: invokestatic 186	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   736: iload_3
    //   737: ifeq +38 -> 775
    //   740: aload 4
    //   742: ifnull +20 -> 762
    //   745: aload 4
    //   747: invokeinterface 143 1 0
    //   752: ifne +10 -> 762
    //   755: aload 4
    //   757: invokeinterface 146 1 0
    //   762: aload 6
    //   764: ifnull +9 -> 773
    //   767: aload 6
    //   769: invokevirtual 149	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   772: pop
    //   773: iconst_0
    //   774: ireturn
    //   775: aload 4
    //   777: ifnull +20 -> 797
    //   780: aload 4
    //   782: invokeinterface 143 1 0
    //   787: ifne +10 -> 797
    //   790: aload 4
    //   792: invokeinterface 146 1 0
    //   797: aload 6
    //   799: ifnull +9 -> 808
    //   802: aload 6
    //   804: invokevirtual 149	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   807: pop
    //   808: sipush -1022
    //   811: ireturn
    //   812: astore_0
    //   813: aload 5
    //   815: astore 4
    //   817: aload 7
    //   819: ifnull +20 -> 839
    //   822: aload 7
    //   824: invokeinterface 143 1 0
    //   829: ifne +10 -> 839
    //   832: aload 7
    //   834: invokeinterface 146 1 0
    //   839: aload 4
    //   841: ifnull +9 -> 850
    //   844: aload 4
    //   846: invokevirtual 149	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   849: pop
    //   850: aload_0
    //   851: athrow
    //   852: iload_3
    //   853: ifeq +9 -> 862
    //   856: ldc 188
    //   858: astore_2
    //   859: goto -207 -> 652
    //   862: ldc 190
    //   864: astore_2
    //   865: goto -213 -> 652
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	868	0	paramContext	Context
    //   0	868	1	paramString	String
    //   0	868	2	paramArrayOfByte	byte[]
    //   608	245	3	bool	boolean
    //   51	794	4	localObject1	Object
    //   102	712	5	localObject2	Object
    //   202	601	6	localObject3	Object
    //   173	660	7	localObject4	Object
    //   457	1	8	localException1	Exception
    //   477	1	8	localException2	Exception
    //   504	207	8	localException3	Exception
    //   165	299	9	localCursor	android.database.Cursor
    //   7	656	10	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   441	446	448	java/lang/Exception
    //   175	185	457	java/lang/Exception
    //   193	204	457	java/lang/Exception
    //   212	219	457	java/lang/Exception
    //   227	235	457	java/lang/Exception
    //   243	250	457	java/lang/Exception
    //   258	266	457	java/lang/Exception
    //   274	301	457	java/lang/Exception
    //   309	320	457	java/lang/Exception
    //   328	335	457	java/lang/Exception
    //   343	351	457	java/lang/Exception
    //   359	366	457	java/lang/Exception
    //   374	382	457	java/lang/Exception
    //   390	408	457	java/lang/Exception
    //   84	167	470	finally
    //   84	167	477	java/lang/Exception
    //   9	45	493	finally
    //   45	53	493	finally
    //   56	76	493	finally
    //   76	84	493	finally
    //   9	45	504	java/lang/Exception
    //   45	53	504	java/lang/Exception
    //   56	76	504	java/lang/Exception
    //   76	84	504	java/lang/Exception
    //   600	609	612	java/lang/Exception
    //   175	185	812	finally
    //   193	204	812	finally
    //   212	219	812	finally
    //   227	235	812	finally
    //   243	250	812	finally
    //   258	266	812	finally
    //   274	301	812	finally
    //   309	320	812	finally
    //   328	335	812	finally
    //   343	351	812	finally
    //   359	366	812	finally
    //   374	382	812	finally
    //   390	408	812	finally
    //   521	530	812	finally
    //   538	542	812	finally
    //   553	557	812	finally
    //   565	573	812	finally
    //   581	592	812	finally
    //   600	609	812	finally
    //   621	629	812	finally
    //   637	647	812	finally
    //   660	668	812	finally
    //   676	683	812	finally
    //   691	701	812	finally
    //   709	719	812	finally
    //   727	736	812	finally
  }
  
  public static int a(Context paramContext, TreeMap paramTreeMap, String paramString, byte[] paramArrayOfByte)
  {
    util.LOGI("saveTKTreeMap start fileName=".concat(String.valueOf(paramString)), "");
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramTreeMap);
      localObjectOutputStream.flush();
      paramTreeMap = localByteArrayOutputStream.toByteArray();
      int i = a(paramContext, paramString, cryptor.encrypt(paramTreeMap, 0, paramTreeMap.length, paramArrayOfByte));
      localObjectOutputStream.close();
      localByteArrayOutputStream.close();
      util.LOGI("saveTKTreeMap end=".concat(String.valueOf(paramString)), "");
      return i;
    }
    catch (Throwable paramContext)
    {
      paramTreeMap = new StringBuilder("saveTKTreeMap failed ");
      paramTreeMap.append(paramContext.getStackTrace().toString());
      util.LOGI(paramTreeMap.toString(), "");
      util.printThrowable(paramContext, "");
    }
    return -1022;
  }
  
  public static int a(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    int i = paramInt;
    while (i < paramArrayOfByte1.length - paramArrayOfByte2.length - paramInt)
    {
      int k = 0;
      int j = 0;
      while (j < paramArrayOfByte2.length)
      {
        if (paramArrayOfByte1[(i + j)] != paramArrayOfByte2[j])
        {
          j = k;
          break label58;
        }
        j += 1;
      }
      j = 1;
      label58:
      if (j != 0) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static TreeMap a(Context paramContext, String paramString, long paramLong)
  {
    util.LOGI("loadTKTreeMap sigfile start ".concat(String.valueOf(paramString)), "");
    Object localObject1 = a(paramContext, paramString);
    if (localObject1 != null)
    {
      Object localObject2 = new StringBuilder("loadTKTreeMap len:");
      ((StringBuilder)localObject2).append(localObject1.length);
      ((StringBuilder)localObject2).append(" at ");
      ((StringBuilder)localObject2).append(u.m());
      util.LOGI(((StringBuilder)localObject2).toString(), "");
      try
      {
        localObject2 = cryptor.decrypt((byte[])localObject1, 0, localObject1.length, u.C);
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
        label204:
        Object localObject4;
        StringBuilder localStringBuilder2;
        util.printThrowable(localThrowable, "");
      }
    }
    try
    {
      localObject2 = ((TreeMap)localObject1).keySet().iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label601;
      }
      localObject3 = ((Iterator)localObject2).next();
      localObject4 = (WloginAllSigInfo)((TreeMap)localObject1).get(localObject3);
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(localObject3);
      localStringBuilder2.append(" allsig: ");
      localStringBuilder2.append(((WloginAllSigInfo)localObject4)._tk_map);
      util.LOGI(localStringBuilder2.toString(), String.valueOf(localObject3));
      break label204;
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
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(localObject3);
        localStringBuilder2.append(" is uin: ");
        localStringBuilder2.append(((UinInfo)localObject4)._uin);
        util.LOGI(localStringBuilder2.toString(), "");
      }
    }
    util.LOGI("tree is null", "");
    return null;
    localObject3 = new SecretKeySpec(u.C, "DESede");
    localObject2 = Cipher.getInstance("DESede");
    ((Cipher)localObject2).init(2, (Key)localObject3);
    localObject1 = new ByteArrayInputStream((byte[])localObject1);
    localObject2 = new ObjectInputStream(new CipherInputStream((InputStream)localObject1, (Cipher)localObject2));
    localObject3 = (TreeMap)((ObjectInputStream)localObject2).readObject();
    StringBuilder localStringBuilder1;
    if (localObject3 != null)
    {
      ((ObjectInputStream)localObject2).close();
      ((ByteArrayInputStream)localObject1).close();
      return localObject3;
      localStringBuilder1 = new StringBuilder("loadTKTreeMap dbdata is null at ");
      localStringBuilder1.append(u.m());
      util.LOGI(localStringBuilder1.toString(), "");
    }
    return d(paramContext, paramString);
    label601:
    return localStringBuilder1;
  }
  
  public static void a(Context paramContext, String paramString, StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append("stashDbFileBefore");
    b(paramContext, paramString, paramStringBuffer);
  }
  
  public static void a(Context paramContext, String paramString1, StringBuffer paramStringBuffer, String paramString2)
  {
    paramStringBuffer.append(",printDbFileWhenError");
    b(paramContext, paramString1, paramStringBuffer);
    paramContext = paramStringBuffer.toString();
    util.LOGI(paramContext, "");
    oicq.wlogin_sdk.report.event.c.a(new b("wtlogin_db_error", paramString2, paramContext).a(true).b(true));
  }
  
  public static void a(Context paramContext, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Object localObject1 = a(paramContext, "tk_file");
    if (localObject1 != null) {}
    try
    {
      localObject1 = cryptor.decrypt((byte[])localObject1, 0, localObject1.length, paramArrayOfByte1);
      if (localObject1 != null)
      {
        localObject2 = new ByteArrayInputStream((byte[])localObject1);
        Object localObject3 = new ObjectInputStream((InputStream)localObject2);
        localObject1 = (TreeMap)((ObjectInputStream)localObject3).readObject();
        ((ObjectInputStream)localObject3).close();
        ((ByteArrayInputStream)localObject2).close();
        if (localObject1 != null)
        {
          localObject2 = ((TreeMap)localObject1).keySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((Iterator)localObject2).next();
            WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)((TreeMap)localObject1).get(localObject3);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(localObject3);
            localStringBuilder.append(" change guid allsig: ");
            localStringBuilder.append(localWloginAllSigInfo._tk_map);
            util.LOGI(localStringBuilder.toString(), String.valueOf(localObject3));
          }
          a(paramContext, (TreeMap)localObject1, "tk_file", paramArrayOfByte2);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject2;
      label174:
      break label174;
    }
    localObject1 = a(paramContext, "name_file");
    if (localObject1 != null) {}
    try
    {
      paramArrayOfByte1 = cryptor.decrypt((byte[])localObject1, 0, localObject1.length, paramArrayOfByte1);
      if (paramArrayOfByte1 != null)
      {
        paramArrayOfByte1 = new ByteArrayInputStream(paramArrayOfByte1);
        localObject1 = new ObjectInputStream(paramArrayOfByte1);
        localObject2 = (TreeMap)((ObjectInputStream)localObject1).readObject();
        ((ObjectInputStream)localObject1).close();
        paramArrayOfByte1.close();
        if (localObject2 != null) {
          a(paramContext, (TreeMap)localObject2, "name_file", paramArrayOfByte2);
        }
      }
      return;
    }
    catch (Throwable paramContext) {}
    return;
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString, byte[] paramArrayOfByte, StringBuffer paramStringBuffer)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic 403	oicq/wlogin_sdk/request/e:c	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   5: astore_0
    //   6: aload_3
    //   7: ldc_w 405
    //   10: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   13: pop
    //   14: aload_3
    //   15: aload_0
    //   16: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   19: pop
    //   20: aload_0
    //   21: invokestatic 411	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifeq +13 -> 37
    //   27: aload_3
    //   28: ldc_w 412
    //   31: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   34: pop
    //   35: iconst_0
    //   36: ireturn
    //   37: new 414	java/io/File
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 415	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore_0
    //   46: aload_0
    //   47: invokevirtual 418	java/io/File:exists	()Z
    //   50: ifne +68 -> 118
    //   53: aload_0
    //   54: invokevirtual 422	java/io/File:getParentFile	()Ljava/io/File;
    //   57: astore_1
    //   58: aload_1
    //   59: ifnull +38 -> 97
    //   62: aload_1
    //   63: invokevirtual 418	java/io/File:exists	()Z
    //   66: ifne +31 -> 97
    //   69: aload_1
    //   70: invokevirtual 425	java/io/File:mkdirs	()Z
    //   73: istore 4
    //   75: aload_3
    //   76: ldc_w 427
    //   79: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   82: pop
    //   83: aload_3
    //   84: iload 4
    //   86: invokevirtual 430	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   89: pop
    //   90: iload 4
    //   92: ifne +5 -> 97
    //   95: iconst_0
    //   96: ireturn
    //   97: aload_0
    //   98: invokevirtual 433	java/io/File:createNewFile	()Z
    //   101: istore 4
    //   103: aload_3
    //   104: ldc_w 435
    //   107: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   110: pop
    //   111: aload_3
    //   112: iload 4
    //   114: invokevirtual 430	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   117: pop
    //   118: aload_0
    //   119: invokevirtual 418	java/io/File:exists	()Z
    //   122: ifeq +111 -> 233
    //   125: aload_0
    //   126: invokevirtual 438	java/io/File:canWrite	()Z
    //   129: ifne +6 -> 135
    //   132: goto +101 -> 233
    //   135: new 440	java/io/FileOutputStream
    //   138: dup
    //   139: aload_0
    //   140: iconst_0
    //   141: invokespecial 443	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   144: astore 5
    //   146: aconst_null
    //   147: astore_0
    //   148: aload 5
    //   150: aload_2
    //   151: invokevirtual 446	java/io/FileOutputStream:write	([B)V
    //   154: aload 5
    //   156: invokevirtual 447	java/io/FileOutputStream:close	()V
    //   159: aload_3
    //   160: ldc_w 449
    //   163: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   166: pop
    //   167: aload_3
    //   168: aload_2
    //   169: arraylength
    //   170: invokevirtual 452	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   173: pop
    //   174: iconst_1
    //   175: ireturn
    //   176: astore_1
    //   177: goto +8 -> 185
    //   180: astore_1
    //   181: aload_1
    //   182: astore_0
    //   183: aload_1
    //   184: athrow
    //   185: aload_0
    //   186: ifnull +20 -> 206
    //   189: aload 5
    //   191: invokevirtual 447	java/io/FileOutputStream:close	()V
    //   194: goto +17 -> 211
    //   197: astore_2
    //   198: aload_0
    //   199: aload_2
    //   200: invokevirtual 456	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   203: goto +8 -> 211
    //   206: aload 5
    //   208: invokevirtual 447	java/io/FileOutputStream:close	()V
    //   211: aload_1
    //   212: athrow
    //   213: astore_0
    //   214: aload_3
    //   215: ldc_w 458
    //   218: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   221: pop
    //   222: aload_3
    //   223: aload_0
    //   224: invokestatic 169	oicq/wlogin_sdk/tools/util:getThrowableInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   227: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   230: pop
    //   231: iconst_0
    //   232: ireturn
    //   233: aload_3
    //   234: ldc_w 460
    //   237: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   240: pop
    //   241: aload_3
    //   242: aload_0
    //   243: invokevirtual 418	java/io/File:exists	()Z
    //   246: invokevirtual 430	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   249: pop
    //   250: aload_3
    //   251: ldc_w 462
    //   254: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   257: pop
    //   258: aload_3
    //   259: aload_0
    //   260: invokevirtual 438	java/io/File:canWrite	()Z
    //   263: invokevirtual 430	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   266: pop
    //   267: iconst_0
    //   268: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	paramContext	Context
    //   0	269	1	paramString	String
    //   0	269	2	paramArrayOfByte	byte[]
    //   0	269	3	paramStringBuffer	StringBuffer
    //   73	40	4	bool	boolean
    //   144	63	5	localFileOutputStream	FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   148	154	176	finally
    //   183	185	176	finally
    //   148	154	180	java/lang/Throwable
    //   189	194	197	java/lang/Throwable
    //   135	146	213	java/lang/Exception
    //   154	159	213	java/lang/Exception
    //   189	194	213	java/lang/Exception
    //   198	203	213	java/lang/Exception
    //   206	211	213	java/lang/Exception
    //   211	213	213	java/lang/Exception
  }
  
  /* Error */
  public static byte[] a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 468	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3: astore 9
    //   5: new 53	java/lang/StringBuffer
    //   8: dup
    //   9: invokespecial 54	java/lang/StringBuffer:<init>	()V
    //   12: astore 10
    //   14: aconst_null
    //   15: astore 8
    //   17: aload_0
    //   18: aload_1
    //   19: aload 10
    //   21: invokestatic 57	oicq/wlogin_sdk/request/e:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   24: aload_1
    //   25: ldc 59
    //   27: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   30: ifeq +33 -> 63
    //   33: getstatic 30	oicq/wlogin_sdk/request/e:g	Loicq/wlogin_sdk/request/c;
    //   36: ifnonnull +17 -> 53
    //   39: new 67	oicq/wlogin_sdk/request/c
    //   42: dup
    //   43: aload_0
    //   44: aload_1
    //   45: aconst_null
    //   46: iconst_1
    //   47: invokespecial 70	oicq/wlogin_sdk/request/c:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   50: putstatic 30	oicq/wlogin_sdk/request/e:g	Loicq/wlogin_sdk/request/c;
    //   53: getstatic 30	oicq/wlogin_sdk/request/e:g	Loicq/wlogin_sdk/request/c;
    //   56: invokevirtual 471	oicq/wlogin_sdk/request/c:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   59: astore_3
    //   60: goto +30 -> 90
    //   63: getstatic 32	oicq/wlogin_sdk/request/e:h	Loicq/wlogin_sdk/request/c;
    //   66: ifnonnull +17 -> 83
    //   69: new 67	oicq/wlogin_sdk/request/c
    //   72: dup
    //   73: aload_0
    //   74: aload_1
    //   75: aconst_null
    //   76: iconst_1
    //   77: invokespecial 70	oicq/wlogin_sdk/request/c:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   80: putstatic 32	oicq/wlogin_sdk/request/e:h	Loicq/wlogin_sdk/request/c;
    //   83: getstatic 32	oicq/wlogin_sdk/request/e:h	Loicq/wlogin_sdk/request/c;
    //   86: invokevirtual 471	oicq/wlogin_sdk/request/c:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   89: astore_3
    //   90: aload_3
    //   91: invokevirtual 80	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   94: iconst_0
    //   95: invokestatic 83	oicq/wlogin_sdk/request/e:b	(Ljava/lang/String;Z)V
    //   98: new 85	java/lang/StringBuilder
    //   101: dup
    //   102: ldc_w 473
    //   105: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   108: astore 4
    //   110: aload 4
    //   112: aload_1
    //   113: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload 4
    //   119: ldc_w 475
    //   122: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload_3
    //   127: aload 4
    //   129: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: aconst_null
    //   133: invokevirtual 479	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   136: astore 6
    //   138: aload 9
    //   140: astore 7
    //   142: aload_3
    //   143: astore 4
    //   145: aload 6
    //   147: astore 5
    //   149: aload 6
    //   151: invokeinterface 482 1 0
    //   156: ifeq +37 -> 193
    //   159: aload 9
    //   161: astore 7
    //   163: aload_3
    //   164: astore 4
    //   166: aload 6
    //   168: astore 5
    //   170: aload 6
    //   172: iconst_0
    //   173: invokeinterface 486 2 0
    //   178: ifle +15 -> 193
    //   181: aload_3
    //   182: astore 4
    //   184: aload 6
    //   186: astore 5
    //   188: getstatic 489	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   191: astore 7
    //   193: aload 6
    //   195: ifnull +34 -> 229
    //   198: aload_3
    //   199: astore 4
    //   201: aload 6
    //   203: astore 5
    //   205: aload 6
    //   207: invokeinterface 143 1 0
    //   212: ifne +17 -> 229
    //   215: aload_3
    //   216: astore 4
    //   218: aload 6
    //   220: astore 5
    //   222: aload 6
    //   224: invokeinterface 146 1 0
    //   229: aload_3
    //   230: astore 4
    //   232: aload 6
    //   234: astore 5
    //   236: aload 7
    //   238: invokevirtual 492	java/lang/Boolean:booleanValue	()Z
    //   241: istore_2
    //   242: iload_2
    //   243: ifne +36 -> 279
    //   246: aload 6
    //   248: ifnull +20 -> 268
    //   251: aload 6
    //   253: invokeinterface 143 1 0
    //   258: ifne +10 -> 268
    //   261: aload 6
    //   263: invokeinterface 146 1 0
    //   268: aload_3
    //   269: ifnull +8 -> 277
    //   272: aload_3
    //   273: invokevirtual 149	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   276: pop
    //   277: aconst_null
    //   278: areturn
    //   279: aload_3
    //   280: astore 4
    //   282: aload 6
    //   284: astore 5
    //   286: aload_3
    //   287: aload_1
    //   288: iconst_1
    //   289: anewarray 61	java/lang/String
    //   292: dup
    //   293: iconst_0
    //   294: aload_1
    //   295: aastore
    //   296: ldc 108
    //   298: aconst_null
    //   299: aconst_null
    //   300: aconst_null
    //   301: aconst_null
    //   302: invokevirtual 112	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   305: astore 7
    //   307: aload 7
    //   309: ifnonnull +36 -> 345
    //   312: aload 7
    //   314: ifnull +20 -> 334
    //   317: aload 7
    //   319: invokeinterface 143 1 0
    //   324: ifne +10 -> 334
    //   327: aload 7
    //   329: invokeinterface 146 1 0
    //   334: aload_3
    //   335: ifnull +8 -> 343
    //   338: aload_3
    //   339: invokevirtual 149	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   342: pop
    //   343: aconst_null
    //   344: areturn
    //   345: aload 7
    //   347: invokeinterface 495 1 0
    //   352: ifeq +54 -> 406
    //   355: aload 7
    //   357: iconst_0
    //   358: invokeinterface 499 2 0
    //   363: astore 4
    //   365: aload 7
    //   367: invokeinterface 146 1 0
    //   372: aload 7
    //   374: ifnull +20 -> 394
    //   377: aload 7
    //   379: invokeinterface 143 1 0
    //   384: ifne +10 -> 394
    //   387: aload 7
    //   389: invokeinterface 146 1 0
    //   394: aload_3
    //   395: ifnull +8 -> 403
    //   398: aload_3
    //   399: invokevirtual 149	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   402: pop
    //   403: aload 4
    //   405: areturn
    //   406: aload 7
    //   408: invokeinterface 146 1 0
    //   413: aload 7
    //   415: ifnull +20 -> 435
    //   418: aload 7
    //   420: invokeinterface 143 1 0
    //   425: ifne +10 -> 435
    //   428: aload 7
    //   430: invokeinterface 146 1 0
    //   435: aload_3
    //   436: ifnull +8 -> 444
    //   439: aload_3
    //   440: invokevirtual 149	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   443: pop
    //   444: aconst_null
    //   445: areturn
    //   446: astore_0
    //   447: aload 7
    //   449: astore_1
    //   450: goto +272 -> 722
    //   453: astore 5
    //   455: aload 7
    //   457: astore 4
    //   459: goto +9 -> 468
    //   462: astore 5
    //   464: aload 6
    //   466: astore 4
    //   468: aload 5
    //   470: astore 6
    //   472: aload_3
    //   473: astore 7
    //   475: aload 4
    //   477: astore_3
    //   478: goto +39 -> 517
    //   481: astore_0
    //   482: aconst_null
    //   483: astore_1
    //   484: goto +238 -> 722
    //   487: astore 6
    //   489: aconst_null
    //   490: astore 4
    //   492: aload_3
    //   493: astore 7
    //   495: aload 4
    //   497: astore_3
    //   498: goto +19 -> 517
    //   501: astore_0
    //   502: aconst_null
    //   503: astore_3
    //   504: aload_3
    //   505: astore_1
    //   506: goto +216 -> 722
    //   509: astore 6
    //   511: aconst_null
    //   512: astore 7
    //   514: aload 7
    //   516: astore_3
    //   517: aload 7
    //   519: astore 4
    //   521: aload_3
    //   522: astore 5
    //   524: aload_1
    //   525: ldc 59
    //   527: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   530: ifeq +17 -> 547
    //   533: aload 7
    //   535: astore 4
    //   537: aload_3
    //   538: astore 5
    //   540: aconst_null
    //   541: putstatic 30	oicq/wlogin_sdk/request/e:g	Loicq/wlogin_sdk/request/c;
    //   544: goto +14 -> 558
    //   547: aload 7
    //   549: astore 4
    //   551: aload_3
    //   552: astore 5
    //   554: aconst_null
    //   555: putstatic 32	oicq/wlogin_sdk/request/e:h	Loicq/wlogin_sdk/request/c;
    //   558: aload 7
    //   560: astore 4
    //   562: aload_3
    //   563: astore 5
    //   565: aload 10
    //   567: ldc 162
    //   569: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   572: pop
    //   573: aload 7
    //   575: astore 4
    //   577: aload_3
    //   578: astore 5
    //   580: aload 10
    //   582: aload 6
    //   584: invokestatic 169	oicq/wlogin_sdk/tools/util:getThrowableInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   587: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   590: pop
    //   591: aload 7
    //   593: astore 4
    //   595: aload_3
    //   596: astore 5
    //   598: aload_0
    //   599: aload_1
    //   600: aload 10
    //   602: invokestatic 502	oicq/wlogin_sdk/request/e:c	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/StringBuffer;)[B
    //   605: astore 9
    //   607: aload 9
    //   609: astore 8
    //   611: goto +141 -> 752
    //   614: astore 9
    //   616: aload 7
    //   618: astore 4
    //   620: aload_3
    //   621: astore 5
    //   623: aload 10
    //   625: ldc 174
    //   627: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   630: pop
    //   631: aload 7
    //   633: astore 4
    //   635: aload_3
    //   636: astore 5
    //   638: aload 10
    //   640: aload 9
    //   642: invokestatic 169	oicq/wlogin_sdk/tools/util:getThrowableInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   645: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   648: pop
    //   649: goto +103 -> 752
    //   652: aload 7
    //   654: astore 4
    //   656: aload_3
    //   657: astore 5
    //   659: aload_0
    //   660: aload_1
    //   661: aload 10
    //   663: aload 9
    //   665: invokestatic 177	oicq/wlogin_sdk/request/e:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/StringBuffer;Ljava/lang/String;)V
    //   668: aload 7
    //   670: astore 4
    //   672: aload_3
    //   673: astore 5
    //   675: aload 6
    //   677: ldc 154
    //   679: invokestatic 160	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   682: aload_3
    //   683: ifnull +18 -> 701
    //   686: aload_3
    //   687: invokeinterface 143 1 0
    //   692: ifne +9 -> 701
    //   695: aload_3
    //   696: invokeinterface 146 1 0
    //   701: aload 7
    //   703: ifnull +9 -> 712
    //   706: aload 7
    //   708: invokevirtual 149	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   711: pop
    //   712: aload 8
    //   714: areturn
    //   715: astore_0
    //   716: aload 5
    //   718: astore_1
    //   719: aload 4
    //   721: astore_3
    //   722: aload_1
    //   723: ifnull +18 -> 741
    //   726: aload_1
    //   727: invokeinterface 143 1 0
    //   732: ifne +9 -> 741
    //   735: aload_1
    //   736: invokeinterface 146 1 0
    //   741: aload_3
    //   742: ifnull +8 -> 750
    //   745: aload_3
    //   746: invokevirtual 149	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   749: pop
    //   750: aload_0
    //   751: athrow
    //   752: aload 8
    //   754: ifnull +11 -> 765
    //   757: ldc_w 504
    //   760: astore 9
    //   762: goto -110 -> 652
    //   765: ldc_w 506
    //   768: astore 9
    //   770: goto -118 -> 652
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	773	0	paramContext	Context
    //   0	773	1	paramString	String
    //   241	2	2	bool	boolean
    //   59	687	3	localObject1	Object
    //   108	612	4	localObject2	Object
    //   147	138	5	localObject3	Object
    //   453	1	5	localException1	Exception
    //   462	7	5	localException2	Exception
    //   522	195	5	localObject4	Object
    //   136	335	6	localObject5	Object
    //   487	1	6	localException3	Exception
    //   509	167	6	localException4	Exception
    //   140	567	7	localObject6	Object
    //   15	738	8	localObject7	Object
    //   3	605	9	localObject8	Object
    //   614	50	9	localException5	Exception
    //   760	9	9	str	String
    //   12	650	10	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   345	372	446	finally
    //   406	413	446	finally
    //   345	372	453	java/lang/Exception
    //   406	413	453	java/lang/Exception
    //   149	159	462	java/lang/Exception
    //   170	181	462	java/lang/Exception
    //   188	193	462	java/lang/Exception
    //   205	215	462	java/lang/Exception
    //   222	229	462	java/lang/Exception
    //   236	242	462	java/lang/Exception
    //   286	307	462	java/lang/Exception
    //   90	138	481	finally
    //   90	138	487	java/lang/Exception
    //   17	53	501	finally
    //   53	60	501	finally
    //   63	83	501	finally
    //   83	90	501	finally
    //   17	53	509	java/lang/Exception
    //   53	60	509	java/lang/Exception
    //   63	83	509	java/lang/Exception
    //   83	90	509	java/lang/Exception
    //   598	607	614	java/lang/Exception
    //   149	159	715	finally
    //   170	181	715	finally
    //   188	193	715	finally
    //   205	215	715	finally
    //   222	229	715	finally
    //   236	242	715	finally
    //   286	307	715	finally
    //   524	533	715	finally
    //   540	544	715	finally
    //   554	558	715	finally
    //   565	573	715	finally
    //   580	591	715	finally
    //   598	607	715	finally
    //   623	631	715	finally
    //   638	649	715	finally
    //   659	668	715	finally
    //   675	682	715	finally
  }
  
  public static void b(Context paramContext, String paramString)
  {
    paramContext = c(paramContext, paramString);
    if (TextUtils.isEmpty(paramContext)) {
      return;
    }
    paramContext = new File(paramContext);
    if (paramContext.exists()) {
      util.LOGI("delSigFile result = ".concat(String.valueOf(paramContext.delete())), "");
    }
  }
  
  public static void b(Context paramContext, String paramString, StringBuffer paramStringBuffer)
  {
    try
    {
      paramStringBuffer.append(",table=");
      paramStringBuffer.append(paramString);
      paramContext = paramContext.getDatabasePath(paramString);
      paramStringBuffer.append(",file=");
      paramStringBuffer.append(paramContext.getAbsolutePath());
      paramStringBuffer.append(",isExists=");
      paramStringBuffer.append(paramContext.exists());
      paramStringBuffer.append(",canRead=");
      paramStringBuffer.append(paramContext.canRead());
      paramStringBuffer.append(",canWrite=");
      paramStringBuffer.append(paramContext.canWrite());
      paramStringBuffer.append(",canExecute=");
      paramStringBuffer.append(paramContext.canExecute());
      paramStringBuffer.append(",lastModified=");
      paramStringBuffer.append(paramContext.lastModified());
      paramContext = paramContext.getParentFile();
      paramStringBuffer.append(",isParentExists=");
      paramStringBuffer.append(paramContext.exists());
      return;
    }
    catch (Exception paramContext)
    {
      paramStringBuffer.append(",exception=");
      paramStringBuffer.append(util.getThrowableInfo(paramContext));
    }
  }
  
  private static void b(String paramString, boolean paramBoolean)
  {
    long l = new File(paramString).lastModified();
    StringBuilder localStringBuilder = new StringBuilder("file ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" last update time ");
    localStringBuilder.append(l);
    localStringBuilder.append(",beforeWrite=");
    localStringBuilder.append(paramBoolean);
    util.LOGI(localStringBuilder.toString(), "");
  }
  
  public static String c(Context paramContext, String paramString)
  {
    paramContext = paramContext.getFilesDir();
    if (paramContext == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("wtlogin");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static byte[] c(Context paramContext, String paramString, StringBuffer paramStringBuffer)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic 403	oicq/wlogin_sdk/request/e:c	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   5: astore_0
    //   6: aload_2
    //   7: ldc_w 574
    //   10: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   13: pop
    //   14: aload_2
    //   15: aload_0
    //   16: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   19: pop
    //   20: aload_0
    //   21: invokestatic 411	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifeq +13 -> 37
    //   27: aload_2
    //   28: ldc_w 412
    //   31: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   34: pop
    //   35: aconst_null
    //   36: areturn
    //   37: new 414	java/io/File
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 415	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore_0
    //   46: aload_0
    //   47: invokevirtual 418	java/io/File:exists	()Z
    //   50: ifeq +138 -> 188
    //   53: aload_0
    //   54: invokevirtual 534	java/io/File:canRead	()Z
    //   57: ifne +6 -> 63
    //   60: goto +128 -> 188
    //   63: new 576	java/io/FileInputStream
    //   66: dup
    //   67: aload_0
    //   68: invokespecial 579	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   71: astore 4
    //   73: aload 4
    //   75: invokevirtual 582	java/io/FileInputStream:available	()I
    //   78: istore_3
    //   79: iload_3
    //   80: newarray byte
    //   82: astore_1
    //   83: aload 4
    //   85: aload_1
    //   86: invokevirtual 586	java/io/FileInputStream:read	([B)I
    //   89: pop
    //   90: aload 4
    //   92: invokevirtual 587	java/io/FileInputStream:close	()V
    //   95: aload_2
    //   96: ldc_w 589
    //   99: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   102: pop
    //   103: aload_2
    //   104: iload_3
    //   105: invokevirtual 452	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   108: pop
    //   109: aload_2
    //   110: ldc_w 543
    //   113: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   116: pop
    //   117: aload_2
    //   118: aload_0
    //   119: invokevirtual 547	java/io/File:lastModified	()J
    //   122: invokevirtual 550	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
    //   125: pop
    //   126: aload_1
    //   127: areturn
    //   128: astore_1
    //   129: aconst_null
    //   130: astore_0
    //   131: goto +7 -> 138
    //   134: astore_0
    //   135: aload_0
    //   136: athrow
    //   137: astore_1
    //   138: aload_0
    //   139: ifnull +22 -> 161
    //   142: aload 4
    //   144: invokevirtual 587	java/io/FileInputStream:close	()V
    //   147: goto +19 -> 166
    //   150: astore 4
    //   152: aload_0
    //   153: aload 4
    //   155: invokevirtual 456	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   158: goto +8 -> 166
    //   161: aload 4
    //   163: invokevirtual 587	java/io/FileInputStream:close	()V
    //   166: aload_1
    //   167: athrow
    //   168: astore_0
    //   169: aload_2
    //   170: ldc_w 591
    //   173: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   176: pop
    //   177: aload_2
    //   178: aload_0
    //   179: invokestatic 169	oicq/wlogin_sdk/tools/util:getThrowableInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   182: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   185: pop
    //   186: aconst_null
    //   187: areturn
    //   188: aload_2
    //   189: ldc_w 460
    //   192: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   195: pop
    //   196: aload_2
    //   197: aload_0
    //   198: invokevirtual 418	java/io/File:exists	()Z
    //   201: invokevirtual 430	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   204: pop
    //   205: aload_2
    //   206: ldc_w 593
    //   209: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   212: pop
    //   213: aload_2
    //   214: aload_0
    //   215: invokevirtual 534	java/io/File:canRead	()Z
    //   218: invokevirtual 430	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   221: pop
    //   222: aconst_null
    //   223: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	paramContext	Context
    //   0	224	1	paramString	String
    //   0	224	2	paramStringBuffer	StringBuffer
    //   78	27	3	i	int
    //   71	72	4	localFileInputStream	FileInputStream
    //   150	12	4	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   73	90	128	finally
    //   73	90	134	java/lang/Throwable
    //   135	137	137	finally
    //   142	147	150	java/lang/Throwable
    //   63	73	168	java/lang/Exception
    //   90	95	168	java/lang/Exception
    //   142	147	168	java/lang/Exception
    //   152	158	168	java/lang/Exception
    //   161	166	168	java/lang/Exception
    //   166	168	168	java/lang/Exception
  }
  
  private static TreeMap d(Context paramContext, String paramString)
  {
    try
    {
      localObject1 = new SecretKeySpec(u.C, "DESede");
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
        i = ((FileInputStream)localObject4).read((byte[])localObject3, 0, 256);
        if (i <= 0) {
          break;
        }
        util.LOGI(util.buf_to_string((byte[])localObject3, i));
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
        int k;
        int j;
        int m;
        int n;
        int i1;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        continue;
        if (i >= 256) {
          continue;
        }
        localObject4[i] = 0;
        i += 1;
        continue;
        i = 0;
        continue;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
        continue;
        continue;
        continue;
        continue;
      }
      localObject1 = paramString;
      k = localFileInputStream.read((byte[])localObject4, 40, 216);
      if (k <= 0) {
        continue;
      }
      i = k + 40;
      continue;
      if (i < 0) {
        continue;
      }
      localObject1 = paramString;
      localObject3 = new String("WloginAllSigInfo").getBytes();
      localObject1 = paramString;
      i = a((byte[])localObject4, i, (byte[])localObject3);
      if (i < 0) {
        continue;
      }
      localObject1 = paramString;
      i += localObject3.length;
      if (i + 8 > 256) {
        continue;
      }
      j = i + 0;
      if (localObject4[j] != -127) {
        continue;
      }
      m = i + 1;
      if (localObject4[m] != 64) {
        continue;
      }
      n = i + 2;
      if (localObject4[n] != 1) {
        continue;
      }
      i1 = i + 3;
      if (localObject4[i1] != 111) {
        continue;
      }
      i2 = i + 4;
      if (localObject4[i2] != -111) {
        continue;
      }
      i3 = i + 5;
      if (localObject4[i3] != -44) {
        continue;
      }
      i4 = i + 6;
      if (localObject4[i4] != 26) {
        continue;
      }
      i5 = i + 7;
      i6 = localObject4[i5];
      if (i6 != -101) {
        continue;
      }
      localObject4[j] = 0;
      localObject4[m] = 0;
      localObject4[n] = 0;
      localObject4[i1] = 0;
      localObject4[i2] = 0;
      localObject4[i3] = 0;
      localObject4[i4] = 0;
      localObject4[i5] = 1;
      continue;
      if (i < 0) {
        continue;
      }
      localObject1 = paramString;
      try
      {
        localObject3 = new String("WloginSigInfo").getBytes();
        localObject1 = paramString;
        i = a((byte[])localObject4, i, (byte[])localObject3);
        if (i < 0) {
          continue;
        }
        localObject1 = paramString;
        j = i + localObject3.length;
        i = j;
        if (j + 8 > 256) {
          continue;
        }
        m = j + 0;
        i = j;
        if (localObject4[m] != 0) {
          continue;
        }
        n = j + 1;
        i = j;
        if (localObject4[n] != 0) {
          continue;
        }
        i1 = j + 2;
        i = j;
        if (localObject4[i1] != 0) {
          continue;
        }
        i2 = j + 3;
        i = j;
        if (localObject4[i2] != 0) {
          continue;
        }
        i3 = j + 4;
        i = j;
        if (localObject4[i3] != 0) {
          continue;
        }
        i4 = j + 5;
        i = j;
        if (localObject4[i4] != 0) {
          continue;
        }
        i5 = j + 6;
        i = j;
        if (localObject4[i5] != 0) {
          continue;
        }
        i6 = j + 7;
        i = j;
        if (localObject4[i6] != 0) {
          continue;
        }
        localObject4[m] = 0;
        localObject4[n] = 0;
        localObject4[i1] = 0;
        localObject4[i2] = 0;
        localObject4[i3] = 0;
        localObject4[i4] = 0;
        localObject4[i5] = 0;
        localObject4[i6] = 1;
        i = j;
      }
      catch (Exception paramString)
      {
        continue;
      }
      if (i < 0) {
        continue;
      }
      localObject1 = paramString;
      localObject3 = new String("WloginSimpleInfo").getBytes();
      localObject1 = paramString;
      i = a((byte[])localObject4, i, (byte[])localObject3);
      if (i < 0) {
        continue;
      }
      localObject1 = paramString;
      j = i + localObject3.length;
      i = j;
      if (j + 8 <= 256)
      {
        m = j + 0;
        i = j;
        if (localObject4[m] == 57)
        {
          n = j + 1;
          i = j;
          if (localObject4[n] == -69)
          {
            i1 = j + 2;
            i = j;
            if (localObject4[i1] == -84)
            {
              i2 = j + 3;
              i = j;
              if (localObject4[i2] == 110)
              {
                i3 = j + 4;
                i = j;
                if (localObject4[i3] == -46)
                {
                  i4 = j + 5;
                  i = j;
                  if (localObject4[i4] == 98)
                  {
                    i5 = j + 6;
                    i = j;
                    if (localObject4[i5] == -31)
                    {
                      i6 = j + 7;
                      i = j;
                      if (localObject4[i6] == -113)
                      {
                        localObject4[m] = 0;
                        localObject4[n] = 0;
                        localObject4[i1] = 0;
                        localObject4[i2] = 0;
                        localObject4[i3] = 0;
                        localObject4[i4] = 0;
                        localObject4[i5] = 0;
                        localObject4[i6] = 1;
                        i = j;
                        continue;
                        if (i < 0) {
                          continue;
                        }
                        localObject1 = paramString;
                        localObject3 = new String("UinInfo").getBytes();
                        localObject1 = paramString;
                        i = a((byte[])localObject4, i, (byte[])localObject3);
                        if (i < 0) {
                          continue;
                        }
                        localObject1 = paramString;
                        i += localObject3.length;
                        if (i + 8 > 256) {
                          continue;
                        }
                        j = i + 0;
                        if (localObject4[j] != -118) {
                          continue;
                        }
                        m = i + 1;
                        if (localObject4[m] != -23) {
                          continue;
                        }
                        n = i + 2;
                        if (localObject4[n] != -128) {
                          continue;
                        }
                        i1 = i + 3;
                        if (localObject4[i1] != -19) {
                          continue;
                        }
                        i2 = i + 4;
                        if (localObject4[i2] != -26) {
                          continue;
                        }
                        i3 = i + 5;
                        if (localObject4[i3] != 99) {
                          continue;
                        }
                        i4 = i + 6;
                        if (localObject4[i4] != 41) {
                          continue;
                        }
                        i5 = i + 7;
                        if (localObject4[i5] != 14) {
                          continue;
                        }
                        localObject4[j] = 0;
                        localObject4[m] = 0;
                        localObject4[n] = 0;
                        localObject4[i1] = 0;
                        localObject4[i2] = 0;
                        localObject4[i3] = 0;
                        localObject4[i4] = 0;
                        localObject4[i5] = 1;
                        continue;
                        localObject1 = paramString;
                        localFileOutputStream.write((byte[])localObject4, 40, k);
                        if (k <= 40) {
                          continue;
                        }
                        localObject1 = paramString;
                        System.arraycopy(localObject4, k, localObject4, 0, 40);
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
  
  public int a(long paramLong1, long paramLong2)
  {
    try
    {
      util.LOGI("start clear_da2 ".concat(String.valueOf(paramLong2)), String.valueOf(paramLong1));
      ??? = this.a;
      int i = 0;
      int j = 0;
      if (??? != null) {
        synchronized (e)
        {
          TreeMap localTreeMap = a(this.a, "tk_file", paramLong1);
          i = j;
          if (localTreeMap != null)
          {
            WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)localTreeMap.get(Long.valueOf(paramLong1));
            if (localWloginAllSigInfo == null) {
              return -1;
            }
            util.LOGI("clear_da2 clear DA2 in file", String.valueOf(paramLong1));
            localWloginAllSigInfo.put_da2(paramLong2, new byte[0]);
            i = a(localTreeMap, "tk_file");
            this.b = localTreeMap;
          }
        }
      }
      util.LOGI("end clear_da2 ret ".concat(String.valueOf(i)), String.valueOf(paramLong1));
      return i;
    }
    finally {}
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      util.LOGI("start put_siginfo ".concat(String.valueOf(paramLong2)), String.valueOf(paramLong1));
      WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)this.b.get(Long.valueOf(paramLong1));
      if (localWloginAllSigInfo == null) {
        return -1;
      }
      int i = localWloginAllSigInfo.put_siginfo(paramLong2, paramLong3, paramLong4, paramArrayOfByte1, paramArrayOfByte2);
      if (this.a != null) {
        synchronized (e)
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
      return i;
    }
    finally {}
  }
  
  public int a(long paramLong1, long paramLong2, byte[][] arg5, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, WloginSimpleInfo paramWloginSimpleInfo, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, byte[] paramArrayOfByte11, byte[] paramArrayOfByte12, byte[] paramArrayOfByte13, byte[][] paramArrayOfByte14, long[] paramArrayOfLong, int paramInt)
  {
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = new StringBuilder("start put_siginfo skey ");
        ((StringBuilder)localObject1).append(util.getMaskBytes(paramArrayOfByte10, 2, 2));
        util.LOGI(((StringBuilder)localObject1).toString(), String.valueOf(paramLong1));
        localObject1 = null;
        if (this.a == null) {
          break label1392;
        }
        synchronized (e)
        {
          util.LOGI("put_siginfo load file", String.valueOf(paramLong1));
          localObject1 = a(this.a, "tk_file", paramLong1);
          Object localObject4 = localObject1;
          if (localObject1 == null) {
            localObject4 = new TreeMap();
          }
          localObject1 = (WloginAllSigInfo)this.b.get(Long.valueOf(paramLong1));
          if (localObject1 != null) {
            break label1371;
          }
          localObject1 = (WloginAllSigInfo)((TreeMap)localObject4).get(Long.valueOf(paramLong1));
          if (localObject1 != null) {
            break label1368;
          }
          localObject1 = new WloginAllSigInfo();
          Object localObject2 = new StringBuilder("put_siginfo mainSigMap 0x");
          ((StringBuilder)localObject2).append(Integer.toHexString(this.d));
          util.LOGI(((StringBuilder)localObject2).toString(), String.valueOf(paramLong1));
          ((WloginAllSigInfo)localObject1).mainSigMap = this.d;
          localObject2 = new byte[0];
          localObject5 = new byte[0];
          byte[] arrayOfByte1 = new byte[0];
          byte[] arrayOfByte2 = new byte[0];
          byte[] arrayOfByte3 = new byte[0];
          localObject3 = ((WloginAllSigInfo)localObject1)._tk_map;
          Object localObject6 = new byte[0];
          Object localObject7 = (WloginSigInfo)((TreeMap)localObject3).get(Long.valueOf(paramLong2));
          if (localObject7 == null) {
            break label1374;
          }
          localObject3 = localObject2;
          localObject2 = localObject5;
          if (((WloginSigInfo)localObject7)._en_A1 != null)
          {
            localObject6 = (byte[])((WloginSigInfo)localObject7)._en_A1.clone();
            localObject3 = localObject6;
            localObject2 = localObject5;
            if (((WloginSigInfo)localObject7)._noPicSig != null)
            {
              localObject2 = (byte[])((WloginSigInfo)localObject7)._noPicSig.clone();
              localObject3 = localObject6;
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
          localObject5 = ((WloginSigInfo)localObject7)._psKey;
          localObject6 = ((WloginSigInfo)localObject7)._pt4Token;
          localObject7 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject7;
          if ((paramArrayOfByte14[6] != null) && (paramArrayOfByte14[6].length > 2))
          {
            HashMap localHashMap1 = new HashMap();
            HashMap localHashMap2 = new HashMap();
            localObject7 = new HashMap();
            HashMap localHashMap3 = new HashMap();
            Ticket.parsePsBuf((byte[])localObject5, paramLong5, localHashMap1, localHashMap2, true);
            Ticket.parsePsBuf((byte[])localObject6, paramLong5, (Map)localObject7, localHashMap3, false);
            localObject5 = new StringBuilder("put_siginfo current pskey size:");
            ((StringBuilder)localObject5).append(localHashMap1.size());
            ((StringBuilder)localObject5).append(":");
            ((StringBuilder)localObject5).append(localHashMap2.size());
            util.LOGI(((StringBuilder)localObject5).toString(), "");
            localObject5 = localHashMap2.entrySet().iterator();
            String str;
            if (((Iterator)localObject5).hasNext())
            {
              localObject6 = (Map.Entry)((Iterator)localObject5).next();
              str = (String)((Map.Entry)localObject6).getKey();
              if (!Ticket.isPskeyStorageExpired(((Long)((Map.Entry)localObject6).getValue()).longValue())) {
                continue;
              }
              ((Iterator)localObject5).remove();
              localHashMap1.remove(str);
              util.LOGI("put_siginfo delete expired pskey from file,key:".concat(String.valueOf(str)), "");
              continue;
            }
            localObject5 = localHashMap3.entrySet().iterator();
            localObject6 = new StringBuilder("put_siginfo current pt4token size:");
            ((StringBuilder)localObject6).append(((Map)localObject7).size());
            ((StringBuilder)localObject6).append(":");
            ((StringBuilder)localObject6).append(localHashMap3.size());
            util.LOGI(((StringBuilder)localObject6).toString(), "");
            if (((Iterator)localObject5).hasNext())
            {
              localObject6 = (Map.Entry)((Iterator)localObject5).next();
              str = (String)((Map.Entry)localObject6).getKey();
              if (!Ticket.isPskeyStorageExpired(((Long)((Map.Entry)localObject6).getValue()).longValue())) {
                break label1386;
              }
              ((Iterator)localObject5).remove();
              ((Map)localObject7).remove(str);
              util.LOGI("put_siginfo delete expired pt4token from file,key:".concat(String.valueOf(str)), "");
              break label1386;
            }
            Ticket.parseSvrPs(paramArrayOfByte14[6], paramLong5, localHashMap1, localHashMap2, (Map)localObject7, localHashMap3);
            try
            {
              paramArrayOfByte14[6] = Ticket.packPsBuf(localHashMap1, paramLong5, localHashMap2);
              paramArrayOfByte14[12] = Ticket.packPsBuf((Map)localObject7, paramLong5, localHashMap3);
            }
            catch (Exception ???)
            {
              util.printException(???, String.valueOf(paramLong1));
              oicq.wlogin_sdk.report.event.c.a(new b("wtlogin_alarm", "pskey_other_exception", Log.getStackTraceString(???)).a(String.valueOf(paramLong1)).a(true).b(true));
              return -2006;
            }
            catch (BufferOverflowException ???)
            {
              paramWloginSimpleInfo = new StringBuilder("map size ");
              paramWloginSimpleInfo.append(localHashMap1.size());
              paramWloginSimpleInfo.append("is too large");
              util.LOGI(paramWloginSimpleInfo.toString(), String.valueOf(paramLong1));
              oicq.wlogin_sdk.report.event.c.a(new b("wtlogin_alarm", "pskey_buffer_overflow", Log.getStackTraceString(???)).a(String.valueOf(paramLong1)).a(true).b(true));
              return -1023;
            }
          }
          ((WloginAllSigInfo)localObject1).put_simpleinfo(paramWloginSimpleInfo);
          ((WloginAllSigInfo)localObject1).put_siginfo(paramLong3, paramLong4, paramLong5, paramLong6, paramLong7, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6, paramArrayOfByte7, paramArrayOfByte8, paramArrayOfByte9, paramArrayOfByte10, paramArrayOfByte11, paramArrayOfByte12, paramArrayOfByte13, paramArrayOfByte14, paramArrayOfLong, paramInt);
          if ((??? != null) && (???[0] != null) && (???[0].length > 0))
          {
            paramWloginSimpleInfo = new StringBuilder("A1_INFO: update A1 form ser : ");
            paramWloginSimpleInfo.append(MD5.getMD5String(???[0]));
            util.LOGI(paramWloginSimpleInfo.toString(), String.valueOf(paramLong1));
          }
          ((WloginAllSigInfo)localObject1).put_siginfo(paramLong2, ???, paramLong5);
          ((TreeMap)localObject4).put(Long.valueOf(paramLong1), ((WloginAllSigInfo)localObject1).get_clone());
          synchronized (e)
          {
            paramInt = a((TreeMap)localObject4, "tk_file");
            util.LOGI("put_siginfo save key result:tk_file:".concat(String.valueOf(paramInt)), "");
            if (paramInt == 0) {
              break label1389;
            }
            ??? = (WloginSigInfo)((WloginAllSigInfo)localObject1)._tk_map.get(Long.valueOf(paramLong2));
            if (??? != null)
            {
              ???._en_A1 = ((byte[])((byte[])localObject2).clone());
              ???._noPicSig = ((byte[])((byte[])localObject3).clone());
              ???._G = ((byte[])arrayOfByte1.clone());
              ???._dpwd = ((byte[])arrayOfByte2.clone());
              ???._randseed = ((byte[])arrayOfByte3.clone());
            }
            ??? = a((WloginSigInfo)((WloginAllSigInfo)localObject1)._tk_map.get(Long.valueOf(paramLong2)), paramInt, (byte[])localObject2, paramLong1, paramLong2);
            util.LOGI("put_siginfo sig in memory changed", String.valueOf(paramLong1));
            this.b.put(Long.valueOf(paramLong1), ((WloginAllSigInfo)localObject1).get_clone());
          }
        }
        if (??? != null) {
          oicq.wlogin_sdk.report.event.c.a(???);
        }
        return paramInt;
      }
      finally {}
      label1368:
      continue;
      label1371:
      continue;
      label1374:
      Object localObject3 = localObject5;
      Object localObject5 = new byte[0];
      continue;
      label1386:
      continue;
      label1389:
      continue;
      label1392:
      paramInt = 0;
      ??? = (byte[][])localObject1;
    }
  }
  
  public int a(TreeMap paramTreeMap, String paramString)
  {
    int i = 0;
    try
    {
      if (("tk_file".equals(paramString)) || ("name_file".equals(paramString))) {
        i = b(paramTreeMap, paramString);
      }
      return i;
    }
    finally {}
  }
  
  public String a(Long paramLong)
  {
    try
    {
      Iterator localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        UinInfo localUinInfo = (UinInfo)this.c.get(str);
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
  
  public List<WloginLoginInfo> a(boolean paramBoolean)
  {
    label358:
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
            Object localObject3 = (WloginAllSigInfo)this.b.get(localLong);
            Object localObject1 = localObject3;
            if (localObject3 == null)
            {
              localObject1 = (WloginAllSigInfo)((TreeMap)localObject6).get(localLong);
              if (localObject1 == null) {
                continue;
              }
              this.b.put(localLong, localObject1);
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
            localObject5 = a(localLong);
            if (localObject5 != null) {
              break label358;
            }
            localObject5 = String.valueOf(localLong);
            if (((WloginAllSigInfo)localObject1)._useInfo == null)
            {
              util.LOGI("get_all_logined_account useInfo is null");
              continue;
            }
            if (((WloginAllSigInfo)localObject1)._useInfo._img_url == null) {
              ((WloginAllSigInfo)localObject1)._useInfo._img_url = new byte[0];
            }
            long l1 = localLong.longValue();
            long l2 = ((Long)localObject7).longValue();
            localObject7 = new String(((WloginAllSigInfo)localObject1)._useInfo._img_url);
            long l3 = ((WloginSigInfo)localObject6)._create_time;
            int i;
            if (paramBoolean) {
              i = WloginLoginInfo.TYPE_LOACL;
            } else {
              i = WloginLoginInfo.TYPE_REMOTE;
            }
            localArrayList.add(new WloginLoginInfo((String)localObject5, l1, l2, (String)localObject7, l3, i, ((WloginSigInfo)localObject6)._login_bitmap));
            continue;
          }
        }
        return localArrayList;
      }
      finally {}
    }
  }
  
  public b a(WloginSigInfo paramWloginSigInfo, int paramInt, byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    if (paramLong2 != 16L) {
      return null;
    }
    boolean bool2 = false;
    int i;
    if ((paramWloginSigInfo != null) && (paramWloginSigInfo._en_A1 != null) && (paramWloginSigInfo._en_A1.length != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      boolean bool1;
      if (paramWloginSigInfo == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
        bool2 = true;
      }
      return new b("wtlogin_alarm", "a1_empty", "").a(String.valueOf(paramLong1)).a("isSigInfoEmpty", String.valueOf(bool1)).a("isOldA1Empty", String.valueOf(bool2)).a("ret", String.valueOf(paramInt));
    }
    return null;
  }
  
  public UinInfo a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      Object localObject = (UinInfo)this.c.get(paramString);
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
      this.c.put(paramString, localObject);
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
      Object localObject1 = (WloginAllSigInfo)this.b.get(Long.valueOf(paramLong));
      if (localObject1 != null)
      {
        util.LOGI("get_all_siginfo in mem", "");
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
      this.b.put(Long.valueOf(paramLong), localObject1);
      return localObject1;
    }
    finally {}
  }
  
  public void a()
  {
    try
    {
      util.LOGI("refresh_all_siginfo ...", "");
      this.b = a(this.a, "tk_file", 0L);
      if (this.b == null) {
        this.b = new TreeMap();
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
        synchronized (e)
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
            int i = a(localTreeMap, "tk_file");
            if (i != 0)
            {
              paramArrayOfByte = new StringBuilder("put_randseed refreshTKTreeMap failed ret ");
              paramArrayOfByte.append(i);
              paramArrayOfByte.append(" appid ");
              paramArrayOfByte.append(paramLong2);
              util.LOGI(paramArrayOfByte.toString(), String.valueOf(paramLong1));
              return;
            }
            this.b = localTreeMap;
            util.LOGI("end put_randseed", String.valueOf(paramLong1));
          }
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
      ??? = (WloginAllSigInfo)this.b.get(paramLong1);
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
        synchronized (e)
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
      this.c.remove(paramString);
      if (this.a != null) {
        synchronized (f)
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
      String str = a(paramLong);
      if (str != null) {
        this.c.remove(str);
      }
      UinInfo localUinInfo = new UinInfo(paramLong, paramBoolean);
      this.c.put(paramString, localUinInfo);
      if (this.a != null) {
        synchronized (f)
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
  
  public int b(TreeMap paramTreeMap, String paramString)
  {
    return a(this.a, paramTreeMap, paramString, u.C);
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
      int i = 0;
      int j = 0;
      if (??? != null) {
        synchronized (e)
        {
          TreeMap localTreeMap = a(this.a, "tk_file", paramLong1);
          i = j;
          if (localTreeMap != null)
          {
            WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)localTreeMap.get(Long.valueOf(paramLong1));
            if (localWloginAllSigInfo == null) {
              return;
            }
            util.LOGI("clearNewST clear newST in file", String.valueOf(paramLong1));
            localWloginAllSigInfo.putNewST(paramLong2, new byte[0], new byte[0]);
            i = a(localTreeMap, "tk_file");
            this.b = localTreeMap;
          }
        }
      }
      util.LOGI("end clearNewST ret ".concat(String.valueOf(i)), String.valueOf(paramLong1));
      return;
    }
    finally {}
  }
  
  public void b(String paramString)
  {
    try
    {
      this.c.remove(paramString);
      util.LOGI("clear_account ".concat(String.valueOf(paramString)), "");
      if (this.a != null) {
        synchronized (f)
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
      WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)this.b.get(Long.valueOf(paramLong1));
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
        synchronized (e)
        {
          TreeMap localTreeMap = a(this.a, "tk_file", paramLong1);
          if (localTreeMap != null)
          {
            localTreeMap.put(Long.valueOf(paramLong1), localWloginAllSigInfo);
            a(localTreeMap, "tk_file");
            this.b = localTreeMap;
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
 * Qualified Name:     oicq.wlogin_sdk.request.e
 * JD-Core Version:    0.7.0.1
 */