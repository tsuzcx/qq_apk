package oicq.wlogin_sdk.request;

import android.content.Context;
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
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_1
    //   7: ldc 60
    //   9: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12: ifeq +254 -> 266
    //   15: getstatic 32	oicq/wlogin_sdk/request/d:h	Loicq/wlogin_sdk/request/b;
    //   18: ifnonnull +17 -> 35
    //   21: new 68	oicq/wlogin_sdk/request/b
    //   24: dup
    //   25: aload_0
    //   26: aload_1
    //   27: aconst_null
    //   28: iconst_1
    //   29: invokespecial 71	oicq/wlogin_sdk/request/b:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   32: putstatic 32	oicq/wlogin_sdk/request/d:h	Loicq/wlogin_sdk/request/b;
    //   35: getstatic 32	oicq/wlogin_sdk/request/d:h	Loicq/wlogin_sdk/request/b;
    //   38: invokevirtual 75	oicq/wlogin_sdk/request/b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   41: astore_0
    //   42: aload_0
    //   43: invokevirtual 81	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   46: invokestatic 84	oicq/wlogin_sdk/request/d:c	(Ljava/lang/String;)V
    //   49: aload_0
    //   50: new 86	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   57: ldc 89
    //   59: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_1
    //   63: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc 95
    //   68: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_1
    //   72: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc 97
    //   77: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokevirtual 103	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   86: aload_0
    //   87: aload_1
    //   88: iconst_1
    //   89: anewarray 62	java/lang/String
    //   92: dup
    //   93: iconst_0
    //   94: ldc 105
    //   96: aastore
    //   97: ldc 107
    //   99: aconst_null
    //   100: aconst_null
    //   101: aconst_null
    //   102: aconst_null
    //   103: invokevirtual 111	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   106: astore 5
    //   108: aload 5
    //   110: invokeinterface 117 1 0
    //   115: ifne +57 -> 172
    //   118: aload_0
    //   119: new 86	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   126: ldc 119
    //   128: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_1
    //   132: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: ldc 121
    //   137: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_1
    //   141: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc 123
    //   146: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: iconst_2
    //   153: anewarray 4	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: iconst_0
    //   159: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   162: aastore
    //   163: dup
    //   164: iconst_1
    //   165: iconst_1
    //   166: newarray byte
    //   168: aastore
    //   169: invokevirtual 132	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: aload_0
    //   173: new 86	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   180: ldc 134
    //   182: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload_1
    //   186: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: ldc 136
    //   191: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_1
    //   195: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc 138
    //   200: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: iconst_1
    //   207: anewarray 4	java/lang/Object
    //   210: dup
    //   211: iconst_0
    //   212: aload_2
    //   213: aastore
    //   214: invokevirtual 132	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   217: aload 5
    //   219: ifnull +20 -> 239
    //   222: aload 5
    //   224: invokeinterface 142 1 0
    //   229: ifne +10 -> 239
    //   232: aload 5
    //   234: invokeinterface 145 1 0
    //   239: aload_0
    //   240: ifnull +22 -> 262
    //   243: iconst_1
    //   244: aload_0
    //   245: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   248: if_icmpne +14 -> 262
    //   251: ldc 150
    //   253: ldc 152
    //   255: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: aload_0
    //   259: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   262: iconst_0
    //   263: istore_3
    //   264: iload_3
    //   265: ireturn
    //   266: getstatic 34	oicq/wlogin_sdk/request/d:i	Loicq/wlogin_sdk/request/b;
    //   269: ifnonnull +17 -> 286
    //   272: new 68	oicq/wlogin_sdk/request/b
    //   275: dup
    //   276: aload_0
    //   277: aload_1
    //   278: aconst_null
    //   279: iconst_1
    //   280: invokespecial 71	oicq/wlogin_sdk/request/b:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   283: putstatic 34	oicq/wlogin_sdk/request/d:i	Loicq/wlogin_sdk/request/b;
    //   286: getstatic 34	oicq/wlogin_sdk/request/d:i	Loicq/wlogin_sdk/request/b;
    //   289: invokevirtual 75	oicq/wlogin_sdk/request/b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   292: astore_0
    //   293: goto -251 -> 42
    //   296: astore 6
    //   298: aconst_null
    //   299: astore_0
    //   300: aload 5
    //   302: astore_2
    //   303: aload 6
    //   305: astore 5
    //   307: aload_1
    //   308: ldc 60
    //   310: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   313: ifeq +99 -> 412
    //   316: aconst_null
    //   317: putstatic 32	oicq/wlogin_sdk/request/d:h	Loicq/wlogin_sdk/request/b;
    //   320: aload 5
    //   322: ldc 152
    //   324: invokestatic 163	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   327: new 86	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   334: ldc 165
    //   336: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: aload 5
    //   341: invokevirtual 168	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   344: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: ldc 152
    //   352: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   355: sipush -1022
    //   358: istore 4
    //   360: aload_0
    //   361: ifnull +18 -> 379
    //   364: aload_0
    //   365: invokeinterface 142 1 0
    //   370: ifne +9 -> 379
    //   373: aload_0
    //   374: invokeinterface 145 1 0
    //   379: iload 4
    //   381: istore_3
    //   382: aload_2
    //   383: ifnull -119 -> 264
    //   386: iload 4
    //   388: istore_3
    //   389: iconst_1
    //   390: aload_2
    //   391: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   394: if_icmpne -130 -> 264
    //   397: ldc 150
    //   399: ldc 152
    //   401: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   404: aload_2
    //   405: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   408: sipush -1022
    //   411: ireturn
    //   412: aconst_null
    //   413: putstatic 34	oicq/wlogin_sdk/request/d:i	Loicq/wlogin_sdk/request/b;
    //   416: goto -96 -> 320
    //   419: astore 5
    //   421: aload_2
    //   422: astore_1
    //   423: aload_0
    //   424: astore_2
    //   425: aload 5
    //   427: astore_0
    //   428: aload_2
    //   429: ifnull +18 -> 447
    //   432: aload_2
    //   433: invokeinterface 142 1 0
    //   438: ifne +9 -> 447
    //   441: aload_2
    //   442: invokeinterface 145 1 0
    //   447: aload_1
    //   448: ifnull +22 -> 470
    //   451: iconst_1
    //   452: aload_1
    //   453: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   456: if_icmpne +14 -> 470
    //   459: ldc 150
    //   461: ldc 152
    //   463: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   466: aload_1
    //   467: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   470: aload_0
    //   471: athrow
    //   472: astore_0
    //   473: aconst_null
    //   474: astore_1
    //   475: aload 6
    //   477: astore_2
    //   478: goto -50 -> 428
    //   481: astore_2
    //   482: aload_0
    //   483: astore_1
    //   484: aload_2
    //   485: astore_0
    //   486: aload 6
    //   488: astore_2
    //   489: goto -61 -> 428
    //   492: astore 6
    //   494: aload 5
    //   496: astore_2
    //   497: aload_0
    //   498: astore_1
    //   499: aload 6
    //   501: astore_0
    //   502: goto -74 -> 428
    //   505: astore 5
    //   507: aconst_null
    //   508: astore 6
    //   510: aload_0
    //   511: astore_2
    //   512: aload 6
    //   514: astore_0
    //   515: goto -208 -> 307
    //   518: astore 6
    //   520: aload_0
    //   521: astore_2
    //   522: aload 6
    //   524: astore_0
    //   525: aload 5
    //   527: astore 6
    //   529: aload_0
    //   530: astore 5
    //   532: aload 6
    //   534: astore_0
    //   535: goto -228 -> 307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	538	0	paramContext	Context
    //   0	538	1	paramString	String
    //   0	538	2	paramArrayOfByte	byte[]
    //   263	126	3	j	int
    //   358	29	4	k	int
    //   4	336	5	localObject1	Object
    //   419	76	5	localObject2	Object
    //   505	21	5	localException1	Exception
    //   530	1	5	localContext	Context
    //   1	1	6	localObject3	Object
    //   296	191	6	localException2	Exception
    //   492	8	6	localObject4	Object
    //   508	5	6	localObject5	Object
    //   518	5	6	localException3	Exception
    //   527	6	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   6	35	296	java/lang/Exception
    //   35	42	296	java/lang/Exception
    //   266	286	296	java/lang/Exception
    //   286	293	296	java/lang/Exception
    //   307	320	419	finally
    //   320	355	419	finally
    //   412	416	419	finally
    //   6	35	472	finally
    //   35	42	472	finally
    //   266	286	472	finally
    //   286	293	472	finally
    //   42	108	481	finally
    //   108	172	492	finally
    //   172	217	492	finally
    //   42	108	505	java/lang/Exception
    //   108	172	518	java/lang/Exception
    //   172	217	518	java/lang/Exception
  }
  
  public static int a(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    int j = paramInt;
    if (j < paramArrayOfByte1.length - paramArrayOfByte2.length - paramInt)
    {
      k = 0;
      label16:
      if (k >= paramArrayOfByte2.length) {
        break label64;
      }
      if (paramArrayOfByte1[(j + k)] == paramArrayOfByte2[k]) {}
    }
    label64:
    for (int k = 0;; k = 1)
    {
      if (k != 0)
      {
        return j;
        k += 1;
        break label16;
      }
      j += 1;
      break;
      return -1;
    }
  }
  
  public static TreeMap a(Context paramContext, String paramString, long paramLong)
  {
    util.LOGI("loadTKTreeMap sigfile " + paramString, "");
    Object localObject1 = a(paramContext, paramString);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (localObject1 != null)
    {
      util.LOGI("loadTKTreeMap len:" + localObject1.length + " at " + t.l(), "");
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
            util.LOGI("loadTKTreeMap tree size: " + ((TreeMap)localObject1).size(), "");
            boolean bool = "tk_file".equals(paramString);
            if (bool)
            {
              if (0L == paramLong) {}
              return b(paramContext, paramString);
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        try
        {
          localObject2 = ((TreeMap)localObject1).keySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((Iterator)localObject2).next();
            localObject4 = (WloginAllSigInfo)((TreeMap)localObject1).get(localObject3);
            util.LOGI(localObject3 + " allsig: " + ((WloginAllSigInfo)localObject4)._tk_map, "" + localObject3);
          }
          localObject2 = (WloginAllSigInfo)((TreeMap)localObject1).get(Long.valueOf(paramLong));
          util.LOGI(paramLong + " allsig: " + ((WloginAllSigInfo)localObject2)._tk_map, "" + paramLong);
          return localObject1;
        }
        catch (Exception paramContext) {}
        localThrowable = localThrowable;
        util.printThrowable(localThrowable, "");
      }
    }
    ByteArrayInputStream localByteArrayInputStream;
    for (;;)
    {
      localObject2 = localThrowable.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        localObject4 = (UinInfo)localThrowable.get(localObject3);
        if (localObject4 != null) {
          util.LOGI(localObject3 + " is uin: " + ((UinInfo)localObject4)._uin, "");
        }
      }
      util.LOGI("tree is null", "");
      return null;
      localObject3 = new SecretKeySpec(t.B, "DESede");
      localObject2 = Cipher.getInstance("DESede");
      ((Cipher)localObject2).init(2, (Key)localObject3);
      localByteArrayInputStream = new ByteArrayInputStream(localThrowable);
      localObject2 = new ObjectInputStream(new CipherInputStream(localByteArrayInputStream, (Cipher)localObject2));
      localObject3 = (TreeMap)((ObjectInputStream)localObject2).readObject();
      if (localObject3 != null)
      {
        ((ObjectInputStream)localObject2).close();
        localByteArrayInputStream.close();
        return localObject3;
        util.LOGI("dbdata is null", "");
      }
    }
    return localByteArrayInputStream;
  }
  
  /* Error */
  public static byte[] a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iconst_0
    //   4: invokestatic 305	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   7: astore 5
    //   9: aload_1
    //   10: ldc 60
    //   12: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifeq +176 -> 191
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
    //   45: aload_0
    //   46: invokevirtual 81	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   49: invokestatic 84	oicq/wlogin_sdk/request/d:c	(Ljava/lang/String;)V
    //   52: aload_0
    //   53: new 86	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   60: ldc_w 310
    //   63: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc_w 312
    //   73: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: aconst_null
    //   80: invokevirtual 316	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   83: astore_3
    //   84: aload 5
    //   86: astore 4
    //   88: aload_3
    //   89: invokeinterface 319 1 0
    //   94: ifeq +23 -> 117
    //   97: aload 5
    //   99: astore 4
    //   101: aload_3
    //   102: iconst_0
    //   103: invokeinterface 323 2 0
    //   108: ifle +9 -> 117
    //   111: iconst_1
    //   112: invokestatic 305	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   115: astore 4
    //   117: aload_3
    //   118: ifnull +18 -> 136
    //   121: aload_3
    //   122: invokeinterface 142 1 0
    //   127: ifne +9 -> 136
    //   130: aload_3
    //   131: invokeinterface 145 1 0
    //   136: aload 4
    //   138: invokevirtual 326	java/lang/Boolean:booleanValue	()Z
    //   141: istore_2
    //   142: iload_2
    //   143: ifne +78 -> 221
    //   146: aload_3
    //   147: ifnull +18 -> 165
    //   150: aload_3
    //   151: invokeinterface 142 1 0
    //   156: ifne +9 -> 165
    //   159: aload_3
    //   160: invokeinterface 145 1 0
    //   165: aload_0
    //   166: ifnull +23 -> 189
    //   169: iconst_1
    //   170: aload_0
    //   171: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   174: if_icmpne +15 -> 189
    //   177: ldc_w 328
    //   180: ldc 152
    //   182: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: aload_0
    //   186: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   189: aconst_null
    //   190: areturn
    //   191: getstatic 34	oicq/wlogin_sdk/request/d:i	Loicq/wlogin_sdk/request/b;
    //   194: ifnonnull +17 -> 211
    //   197: new 68	oicq/wlogin_sdk/request/b
    //   200: dup
    //   201: aload_0
    //   202: aload_1
    //   203: aconst_null
    //   204: iconst_1
    //   205: invokespecial 71	oicq/wlogin_sdk/request/b:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   208: putstatic 34	oicq/wlogin_sdk/request/d:i	Loicq/wlogin_sdk/request/b;
    //   211: getstatic 34	oicq/wlogin_sdk/request/d:i	Loicq/wlogin_sdk/request/b;
    //   214: invokevirtual 308	oicq/wlogin_sdk/request/b:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   217: astore_0
    //   218: goto -173 -> 45
    //   221: aload_0
    //   222: aload_1
    //   223: iconst_1
    //   224: anewarray 62	java/lang/String
    //   227: dup
    //   228: iconst_0
    //   229: aload_1
    //   230: aastore
    //   231: ldc 107
    //   233: aconst_null
    //   234: aconst_null
    //   235: aconst_null
    //   236: aconst_null
    //   237: invokevirtual 111	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   240: astore 4
    //   242: aload 4
    //   244: ifnonnull +51 -> 295
    //   247: aload 4
    //   249: ifnull +20 -> 269
    //   252: aload 4
    //   254: invokeinterface 142 1 0
    //   259: ifne +10 -> 269
    //   262: aload 4
    //   264: invokeinterface 145 1 0
    //   269: aload_0
    //   270: ifnull +23 -> 293
    //   273: iconst_1
    //   274: aload_0
    //   275: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   278: if_icmpne +15 -> 293
    //   281: ldc_w 328
    //   284: ldc 152
    //   286: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   289: aload_0
    //   290: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   293: aconst_null
    //   294: areturn
    //   295: aload 4
    //   297: invokeinterface 331 1 0
    //   302: ifeq +67 -> 369
    //   305: aload 4
    //   307: iconst_0
    //   308: invokeinterface 335 2 0
    //   313: astore_3
    //   314: aload 4
    //   316: invokeinterface 145 1 0
    //   321: aload 4
    //   323: ifnull +20 -> 343
    //   326: aload 4
    //   328: invokeinterface 142 1 0
    //   333: ifne +10 -> 343
    //   336: aload 4
    //   338: invokeinterface 145 1 0
    //   343: aload_0
    //   344: ifnull +23 -> 367
    //   347: iconst_1
    //   348: aload_0
    //   349: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   352: if_icmpne +15 -> 367
    //   355: ldc_w 328
    //   358: ldc 152
    //   360: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   363: aload_0
    //   364: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   367: aload_3
    //   368: areturn
    //   369: aload 4
    //   371: invokeinterface 145 1 0
    //   376: aload 4
    //   378: ifnull +20 -> 398
    //   381: aload 4
    //   383: invokeinterface 142 1 0
    //   388: ifne +10 -> 398
    //   391: aload 4
    //   393: invokeinterface 145 1 0
    //   398: aload_0
    //   399: ifnull +23 -> 422
    //   402: iconst_1
    //   403: aload_0
    //   404: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   407: if_icmpne +15 -> 422
    //   410: ldc_w 328
    //   413: ldc 152
    //   415: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   418: aload_0
    //   419: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   422: aconst_null
    //   423: areturn
    //   424: astore 4
    //   426: aconst_null
    //   427: astore_0
    //   428: aconst_null
    //   429: astore_3
    //   430: aload_1
    //   431: ldc 60
    //   433: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   436: ifeq +59 -> 495
    //   439: aconst_null
    //   440: putstatic 32	oicq/wlogin_sdk/request/d:h	Loicq/wlogin_sdk/request/b;
    //   443: aload 4
    //   445: ldc 152
    //   447: invokestatic 163	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   450: aload_0
    //   451: ifnull +18 -> 469
    //   454: aload_0
    //   455: invokeinterface 142 1 0
    //   460: ifne +9 -> 469
    //   463: aload_0
    //   464: invokeinterface 145 1 0
    //   469: aload_3
    //   470: ifnull +23 -> 493
    //   473: iconst_1
    //   474: aload_3
    //   475: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   478: if_icmpne +15 -> 493
    //   481: ldc_w 328
    //   484: ldc 152
    //   486: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   489: aload_3
    //   490: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   493: aconst_null
    //   494: areturn
    //   495: aconst_null
    //   496: putstatic 34	oicq/wlogin_sdk/request/d:i	Loicq/wlogin_sdk/request/b;
    //   499: goto -56 -> 443
    //   502: astore 4
    //   504: aload_0
    //   505: astore_1
    //   506: aload 4
    //   508: astore_0
    //   509: aload_1
    //   510: ifnull +18 -> 528
    //   513: aload_1
    //   514: invokeinterface 142 1 0
    //   519: ifne +9 -> 528
    //   522: aload_1
    //   523: invokeinterface 145 1 0
    //   528: aload_3
    //   529: ifnull +23 -> 552
    //   532: iconst_1
    //   533: aload_3
    //   534: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   537: if_icmpne +15 -> 552
    //   540: ldc_w 328
    //   543: ldc 152
    //   545: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   548: aload_3
    //   549: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   552: aload_0
    //   553: athrow
    //   554: astore_0
    //   555: aconst_null
    //   556: astore_3
    //   557: aload 4
    //   559: astore_1
    //   560: goto -51 -> 509
    //   563: astore_1
    //   564: aload_0
    //   565: astore_3
    //   566: aload_1
    //   567: astore_0
    //   568: aload 4
    //   570: astore_1
    //   571: goto -62 -> 509
    //   574: astore 4
    //   576: aload_3
    //   577: astore_1
    //   578: aload_0
    //   579: astore_3
    //   580: aload 4
    //   582: astore_0
    //   583: goto -74 -> 509
    //   586: astore 5
    //   588: aload 4
    //   590: astore_1
    //   591: aload_0
    //   592: astore_3
    //   593: aload 5
    //   595: astore_0
    //   596: goto -87 -> 509
    //   599: astore 4
    //   601: aload_0
    //   602: astore_3
    //   603: aconst_null
    //   604: astore_0
    //   605: goto -175 -> 430
    //   608: astore 4
    //   610: aload_0
    //   611: astore 5
    //   613: aload_3
    //   614: astore_0
    //   615: aload 5
    //   617: astore_3
    //   618: goto -188 -> 430
    //   621: astore 6
    //   623: aload 4
    //   625: astore_3
    //   626: aload_0
    //   627: astore 5
    //   629: aload 6
    //   631: astore 4
    //   633: aload_3
    //   634: astore_0
    //   635: aload 5
    //   637: astore_3
    //   638: goto -208 -> 430
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	641	0	paramContext	Context
    //   0	641	1	paramString	String
    //   141	2	2	bool	boolean
    //   83	555	3	localObject1	Object
    //   1	391	4	localObject2	Object
    //   424	20	4	localException1	Exception
    //   502	67	4	localObject3	Object
    //   574	15	4	localObject4	Object
    //   599	1	4	localException2	Exception
    //   608	16	4	localException3	Exception
    //   631	1	4	localObject5	Object
    //   7	91	5	localBoolean	java.lang.Boolean
    //   586	8	5	localObject6	Object
    //   611	25	5	localContext	Context
    //   621	9	6	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   9	38	424	java/lang/Exception
    //   38	45	424	java/lang/Exception
    //   191	211	424	java/lang/Exception
    //   211	218	424	java/lang/Exception
    //   430	443	502	finally
    //   443	450	502	finally
    //   495	499	502	finally
    //   9	38	554	finally
    //   38	45	554	finally
    //   191	211	554	finally
    //   211	218	554	finally
    //   45	84	563	finally
    //   88	97	574	finally
    //   101	117	574	finally
    //   121	136	574	finally
    //   136	142	574	finally
    //   221	242	574	finally
    //   295	321	586	finally
    //   369	376	586	finally
    //   45	84	599	java/lang/Exception
    //   88	97	608	java/lang/Exception
    //   101	117	608	java/lang/Exception
    //   121	136	608	java/lang/Exception
    //   136	142	608	java/lang/Exception
    //   221	242	608	java/lang/Exception
    //   295	321	621	java/lang/Exception
    //   369	376	621	java/lang/Exception
  }
  
  private static TreeMap b(Context paramContext, String paramString)
  {
    try
    {
      localObject1 = new SecretKeySpec(t.B, "DESede");
      Object localObject3 = Cipher.getInstance("DESede");
      ((Cipher)localObject3).init(2, (Key)localObject1);
      localObject1 = new ObjectInputStream(new CipherInputStream(paramContext.openFileInput(paramString), (Cipher)localObject3));
      if ((localThrowable2 instanceof FileNotFoundException)) {
        break label133;
      }
    }
    catch (Throwable localThrowable2)
    {
      try
      {
        localObject3 = (TreeMap)((ObjectInputStream)localObject1).readObject();
        paramString = (String)localObject1;
        paramContext = (Context)localObject3;
        if (paramContext != null) {
          break label1257;
        }
        return paramContext;
      }
      catch (Throwable localThrowable4)
      {
        for (;;)
        {
          Object localObject1;
          Object localObject5;
          continue;
          int j = 0;
          continue;
          j = 0;
          continue;
          j = 0;
          continue;
          j = 0;
        }
      }
      localThrowable2 = localThrowable2;
      localObject1 = null;
    }
    try
    {
      byte[] arrayOfByte1 = new byte[256];
      localObject5 = paramContext.openFileInput(paramString);
      for (;;)
      {
        j = ((FileInputStream)localObject5).read(arrayOfByte1, 0, arrayOfByte1.length);
        if (j <= 0) {
          break;
        }
        util.LOGI(util.buf_to_string(arrayOfByte1, j));
      }
      try
      {
        localObject4 = new SecretKeySpec(new String("%4;7t>;28<fc.5*6").getBytes(), "DESede");
        localObject5 = Cipher.getInstance("DESede");
        ((Cipher)localObject5).init(2, (Key)localObject4);
        localObject4 = new ObjectInputStream(new CipherInputStream(paramContext.openFileInput(paramString), (Cipher)localObject5));
      }
      catch (Throwable localThrowable3) {}
    }
    catch (Exception localException2) {}
    for (;;)
    {
      try
      {
        label133:
        Object localObject4;
        localObject1 = (TreeMap)((ObjectInputStream)localObject4).readObject();
        paramString = (String)localObject4;
        paramContext = (Context)localObject1;
      }
      catch (Throwable localThrowable1)
      {
        byte[] arrayOfByte2;
        byte[] arrayOfByte3;
        Object localObject2 = arrayOfByte2;
        continue;
      }
      ((FileInputStream)localObject5).close();
    }
    for (;;)
    {
      int n;
      label299:
      label334:
      try
      {
        arrayOfByte2 = new byte[256];
        int m = arrayOfByte2.length;
        paramString = paramContext.openFileInput(paramString);
        localObject5 = paramContext.openFileOutput("tmp_tk_file", 0);
        n = paramString.read(arrayOfByte2, 40, m - 40);
        if (n <= 0) {
          break label1221;
        }
        j = 40 + n;
        if (j >= arrayOfByte2.length) {
          break label1288;
        }
        arrayOfByte2[j] = 0;
        j += 1;
        continue;
        if (j < 0) {
          break label1293;
        }
        arrayOfByte3 = new String("WloginAllSigInfo").getBytes();
        j = a(arrayOfByte2, j, arrayOfByte3);
        if (j >= 0) {
          break;
        }
      }
      catch (Exception paramString) {}
      if (j < 0) {
        break label1298;
      }
      arrayOfByte3 = new String("WloginSigInfo").getBytes();
      j = a(arrayOfByte2, j, arrayOfByte3);
      if (j >= 0) {
        break label676;
      }
      break label1298;
      label369:
      if (j < 0) {
        break label1303;
      }
      arrayOfByte3 = new String("WloginSimpleInfo").getBytes();
      j = a(arrayOfByte2, j, arrayOfByte3);
      if (j >= 0) {
        break label847;
      }
      break label1303;
      label404:
      if (j >= 0)
      {
        arrayOfByte3 = new String("UinInfo").getBytes();
        j = a(arrayOfByte2, j, arrayOfByte3);
        if (j >= 0) {
          break label1034;
        }
      }
      ((FileOutputStream)localObject5).write(arrayOfByte2, 40, n);
      if (n > 40) {
        System.arraycopy(arrayOfByte2, n, arrayOfByte2, 0, 40);
      }
    }
    for (;;)
    {
      paramString = (String)localObject1;
      localObject1 = null;
      paramContext.deleteFile("tmp_tk_file");
      paramContext = (Context)localObject1;
      break;
      int k = j + arrayOfByte3.length;
      j = k;
      if (k + 8 > arrayOfByte2.length) {
        break label299;
      }
      j = k;
      if (arrayOfByte2[(k + 0)] != -127) {
        break label299;
      }
      j = k;
      if (arrayOfByte2[(k + 1)] != 64) {
        break label299;
      }
      j = k;
      if (arrayOfByte2[(k + 2)] != 1) {
        break label299;
      }
      j = k;
      if (arrayOfByte2[(k + 3)] != 111) {
        break label299;
      }
      j = k;
      if (arrayOfByte2[(k + 4)] != -111) {
        break label299;
      }
      j = k;
      if (arrayOfByte2[(k + 5)] != -44) {
        break label299;
      }
      j = k;
      if (arrayOfByte2[(k + 6)] != 26) {
        break label299;
      }
      j = k;
      if (arrayOfByte2[(k + 7)] != -101) {
        break label299;
      }
      arrayOfByte2[(k + 0)] = 0;
      arrayOfByte2[(k + 1)] = 0;
      arrayOfByte2[(k + 2)] = 0;
      arrayOfByte2[(k + 3)] = 0;
      arrayOfByte2[(k + 4)] = 0;
      arrayOfByte2[(k + 5)] = 0;
      arrayOfByte2[(k + 6)] = 0;
      arrayOfByte2[(k + 7)] = 1;
      j = k;
      break label299;
      label676:
      k = j + arrayOfByte3.length;
      j = k;
      if (k + 8 > arrayOfByte2.length) {
        break label334;
      }
      j = k;
      if (arrayOfByte2[(k + 0)] != 0) {
        break label334;
      }
      j = k;
      if (arrayOfByte2[(k + 1)] != 0) {
        break label334;
      }
      j = k;
      if (arrayOfByte2[(k + 2)] != 0) {
        break label334;
      }
      j = k;
      if (arrayOfByte2[(k + 3)] != 0) {
        break label334;
      }
      j = k;
      if (arrayOfByte2[(k + 4)] != 0) {
        break label334;
      }
      j = k;
      if (arrayOfByte2[(k + 5)] != 0) {
        break label334;
      }
      j = k;
      if (arrayOfByte2[(k + 6)] != 0) {
        break label334;
      }
      j = k;
      if (arrayOfByte2[(k + 7)] != 0) {
        break label334;
      }
      arrayOfByte2[(k + 0)] = 0;
      arrayOfByte2[(k + 1)] = 0;
      arrayOfByte2[(k + 2)] = 0;
      arrayOfByte2[(k + 3)] = 0;
      arrayOfByte2[(k + 4)] = 0;
      arrayOfByte2[(k + 5)] = 0;
      arrayOfByte2[(k + 6)] = 0;
      arrayOfByte2[(k + 7)] = 1;
      j = k;
      break label334;
      label847:
      k = j + arrayOfByte3.length;
      j = k;
      if (k + 8 > arrayOfByte2.length) {
        break label369;
      }
      j = k;
      if (arrayOfByte2[(k + 0)] != 57) {
        break label369;
      }
      j = k;
      if (arrayOfByte2[(k + 1)] != -69) {
        break label369;
      }
      j = k;
      if (arrayOfByte2[(k + 2)] != -84) {
        break label369;
      }
      j = k;
      if (arrayOfByte2[(k + 3)] != 110) {
        break label369;
      }
      j = k;
      if (arrayOfByte2[(k + 4)] != -46) {
        break label369;
      }
      j = k;
      if (arrayOfByte2[(k + 5)] != 98) {
        break label369;
      }
      j = k;
      if (arrayOfByte2[(k + 6)] != -31) {
        break label369;
      }
      j = k;
      if (arrayOfByte2[(k + 7)] != -113) {
        break label369;
      }
      arrayOfByte2[(k + 0)] = 0;
      arrayOfByte2[(k + 1)] = 0;
      arrayOfByte2[(k + 2)] = 0;
      arrayOfByte2[(k + 3)] = 0;
      arrayOfByte2[(k + 4)] = 0;
      arrayOfByte2[(k + 5)] = 0;
      arrayOfByte2[(k + 6)] = 0;
      arrayOfByte2[(k + 7)] = 1;
      j = k;
      break label369;
      label1034:
      k = j + arrayOfByte3.length;
      j = k;
      if (k + 8 > arrayOfByte2.length) {
        break label404;
      }
      j = k;
      if (arrayOfByte2[(k + 0)] != -118) {
        break label404;
      }
      j = k;
      if (arrayOfByte2[(k + 1)] != -23) {
        break label404;
      }
      j = k;
      if (arrayOfByte2[(k + 2)] != -128) {
        break label404;
      }
      j = k;
      if (arrayOfByte2[(k + 3)] != -19) {
        break label404;
      }
      j = k;
      if (arrayOfByte2[(k + 4)] != -26) {
        break label404;
      }
      j = k;
      if (arrayOfByte2[(k + 5)] != 99) {
        break label404;
      }
      j = k;
      if (arrayOfByte2[(k + 6)] != 41) {
        break label404;
      }
      j = k;
      if (arrayOfByte2[(k + 7)] != 14) {
        break label404;
      }
      arrayOfByte2[(k + 0)] = 0;
      arrayOfByte2[(k + 1)] = 0;
      arrayOfByte2[(k + 2)] = 0;
      arrayOfByte2[(k + 3)] = 0;
      arrayOfByte2[(k + 4)] = 0;
      arrayOfByte2[(k + 5)] = 0;
      arrayOfByte2[(k + 6)] = 0;
      arrayOfByte2[(k + 7)] = 1;
      j = k;
      break label404;
      label1221:
      paramString.close();
      ((FileOutputStream)localObject5).close();
      paramString = new ObjectInputStream(paramContext.openFileInput("tmp_tk_file"));
      for (;;)
      {
        try
        {
          localObject1 = (TreeMap)paramString.readObject();
        }
        catch (Exception localException1)
        {
          label1257:
          String str = paramString;
        }
        try
        {
          paramString.close();
          return paramContext;
        }
        catch (Exception paramContext)
        {
          return null;
        }
      }
    }
  }
  
  private static void c(String paramString)
  {
    long l = new File(paramString).lastModified();
    util.LOGI("file " + paramString + " last update stample " + l, "");
  }
  
  /* Error */
  public int a(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: aload_0
    //   7: monitorenter
    //   8: new 86	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 411
    //   18: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: lload_3
    //   22: invokevirtual 259	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   25: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: new 86	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   35: ldc 152
    //   37: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: lload_1
    //   41: invokevirtual 259	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   44: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_0
    //   51: getfield 50	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   54: ifnull +116 -> 170
    //   57: getstatic 28	oicq/wlogin_sdk/request/d:f	Ljava/lang/Object;
    //   60: astore 7
    //   62: aload 7
    //   64: monitorenter
    //   65: aload_0
    //   66: getfield 50	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   69: ldc 60
    //   71: lload_1
    //   72: invokestatic 55	oicq/wlogin_sdk/request/d:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   75: astore 8
    //   77: iload 6
    //   79: istore 5
    //   81: aload 8
    //   83: ifnull +84 -> 167
    //   86: aload 8
    //   88: lload_1
    //   89: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   92: invokevirtual 241	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   95: checkcast 243	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   98: astore 9
    //   100: aload 9
    //   102: ifnonnull +14 -> 116
    //   105: iconst_m1
    //   106: istore 5
    //   108: aload 7
    //   110: monitorexit
    //   111: aload_0
    //   112: monitorexit
    //   113: iload 5
    //   115: ireturn
    //   116: ldc_w 413
    //   119: new 86	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   126: ldc 152
    //   128: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: lload_1
    //   132: invokevirtual 259	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   135: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload 9
    //   143: lload_3
    //   144: iconst_0
    //   145: newarray byte
    //   147: invokevirtual 417	oicq/wlogin_sdk/request/WloginAllSigInfo:put_da2	(J[B)I
    //   150: pop
    //   151: aload_0
    //   152: aload 8
    //   154: ldc 60
    //   156: invokevirtual 420	oicq/wlogin_sdk/request/d:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   159: istore 5
    //   161: aload_0
    //   162: aload 8
    //   164: putfield 46	oicq/wlogin_sdk/request/d:c	Ljava/util/TreeMap;
    //   167: aload 7
    //   169: monitorexit
    //   170: new 86	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   177: ldc_w 422
    //   180: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: iload 5
    //   185: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   188: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: new 86	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   198: ldc 152
    //   200: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: lload_1
    //   204: invokevirtual 259	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   207: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: goto -102 -> 111
    //   216: astore 7
    //   218: aload_0
    //   219: monitorexit
    //   220: aload 7
    //   222: athrow
    //   223: astore 8
    //   225: aload 7
    //   227: monitorexit
    //   228: aload 8
    //   230: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	this	d
    //   0	231	1	paramLong1	long
    //   0	231	3	paramLong2	long
    //   1	183	5	j	int
    //   4	74	6	k	int
    //   216	10	7	localObject2	Object
    //   75	88	8	localTreeMap	TreeMap
    //   223	6	8	localObject3	Object
    //   98	44	9	localWloginAllSigInfo	WloginAllSigInfo
    // Exception table:
    //   from	to	target	type
    //   8	50	216	finally
    //   50	65	216	finally
    //   170	213	216	finally
    //   228	231	216	finally
    //   65	77	223	finally
    //   86	100	223	finally
    //   108	111	223	finally
    //   116	167	223	finally
    //   167	170	223	finally
    //   225	228	223	finally
  }
  
  /* Error */
  public int a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 86	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 425
    //   12: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: lload_3
    //   16: invokevirtual 259	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: new 86	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   29: ldc 152
    //   31: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: lload_1
    //   35: invokevirtual 259	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   38: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_0
    //   45: getfield 46	oicq/wlogin_sdk/request/d:c	Ljava/util/TreeMap;
    //   48: lload_1
    //   49: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   52: invokevirtual 241	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: checkcast 243	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   58: astore 13
    //   60: aload 13
    //   62: ifnonnull +11 -> 73
    //   65: iconst_m1
    //   66: istore 11
    //   68: aload_0
    //   69: monitorexit
    //   70: iload 11
    //   72: ireturn
    //   73: aload 13
    //   75: lload_3
    //   76: lload 5
    //   78: lload 7
    //   80: aload 9
    //   82: aload 10
    //   84: invokevirtual 429	oicq/wlogin_sdk/request/WloginAllSigInfo:put_siginfo	(JJJ[B[B)I
    //   87: istore 12
    //   89: iload 12
    //   91: istore 11
    //   93: aload_0
    //   94: getfield 50	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   97: ifnull -29 -> 68
    //   100: getstatic 28	oicq/wlogin_sdk/request/d:f	Ljava/lang/Object;
    //   103: astore 14
    //   105: aload 14
    //   107: monitorenter
    //   108: aload_0
    //   109: getfield 50	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   112: ldc 60
    //   114: lload_1
    //   115: invokestatic 55	oicq/wlogin_sdk/request/d:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   118: astore 10
    //   120: aload 10
    //   122: astore 9
    //   124: aload 10
    //   126: ifnonnull +12 -> 138
    //   129: new 43	java/util/TreeMap
    //   132: dup
    //   133: invokespecial 44	java/util/TreeMap:<init>	()V
    //   136: astore 9
    //   138: aload 9
    //   140: lload_1
    //   141: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   144: aload 13
    //   146: invokevirtual 433	oicq/wlogin_sdk/request/WloginAllSigInfo:get_clone	()Loicq/wlogin_sdk/request/WloginAllSigInfo;
    //   149: invokevirtual 437	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   152: pop
    //   153: aload_0
    //   154: aload 9
    //   156: ldc 60
    //   158: invokevirtual 420	oicq/wlogin_sdk/request/d:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   161: pop
    //   162: aload 14
    //   164: monitorexit
    //   165: iload 12
    //   167: istore 11
    //   169: goto -101 -> 68
    //   172: astore 9
    //   174: aload 14
    //   176: monitorexit
    //   177: aload 9
    //   179: athrow
    //   180: astore 9
    //   182: aload_0
    //   183: monitorexit
    //   184: aload 9
    //   186: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	d
    //   0	187	1	paramLong1	long
    //   0	187	3	paramLong2	long
    //   0	187	5	paramLong3	long
    //   0	187	7	paramLong4	long
    //   0	187	9	paramArrayOfByte1	byte[]
    //   0	187	10	paramArrayOfByte2	byte[]
    //   66	102	11	j	int
    //   87	79	12	k	int
    //   58	87	13	localWloginAllSigInfo	WloginAllSigInfo
    // Exception table:
    //   from	to	target	type
    //   108	120	172	finally
    //   129	138	172	finally
    //   138	165	172	finally
    //   174	177	172	finally
    //   2	60	180	finally
    //   73	89	180	finally
    //   93	108	180	finally
    //   177	180	180	finally
  }
  
  public int a(long paramLong1, long paramLong2, byte[][] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, WloginSimpleInfo paramWloginSimpleInfo, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, byte[] paramArrayOfByte11, byte[] paramArrayOfByte12, byte[] paramArrayOfByte13, byte[][] paramArrayOfByte14, long[] paramArrayOfLong, int paramInt)
  {
    label896:
    label1229:
    label1232:
    label1239:
    label1272:
    for (;;)
    {
      int j;
      TreeMap localTreeMap;
      Object localObject2;
      byte[] arrayOfByte;
      Object localObject9;
      HashMap localHashMap1;
      HashMap localHashMap2;
      String str;
      try
      {
        util.LOGI("start put_siginfo skey " + util.getMaskBytes(paramArrayOfByte10, 2, 2), "" + paramLong1);
        j = 0;
        if (this.a == null) {
          break label1149;
        }
        synchronized (f)
        {
          util.LOGI("put_siginfo load file", "" + paramLong1);
          localTreeMap = a(this.a, "tk_file", paramLong1);
          if (localTreeMap != null) {
            break label1272;
          }
          localTreeMap = new TreeMap();
          localObject1 = (WloginAllSigInfo)this.c.get(Long.valueOf(paramLong1));
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject1 = (WloginAllSigInfo)localTreeMap.get(Long.valueOf(paramLong1));
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new WloginAllSigInfo();
            }
          }
          util.LOGI("mainSigMap 0x" + Integer.toHexString(this.e), "" + paramLong1);
          ((WloginAllSigInfo)localObject2).mainSigMap = this.e;
          localObject7 = new byte[0];
          localObject6 = new byte[0];
          arrayOfByte = new byte[0];
          localObject4 = new byte[0];
          localObject5 = new byte[0];
          localObject9 = (WloginSigInfo)((WloginAllSigInfo)localObject2)._tk_map.get(Long.valueOf(paramLong2));
          if (localObject9 == null) {
            break label1239;
          }
          localObject3 = localObject6;
          localObject1 = localObject7;
          if (((WloginSigInfo)localObject9)._en_A1 != null)
          {
            localObject1 = (byte[])((WloginSigInfo)localObject9)._en_A1.clone();
            if (((WloginSigInfo)localObject9)._noPicSig == null) {
              break label1232;
            }
            localObject3 = (byte[])((WloginSigInfo)localObject9)._noPicSig.clone();
          }
          if (((WloginSigInfo)localObject9)._G != null) {
            arrayOfByte = (byte[])((WloginSigInfo)localObject9)._G.clone();
          }
          if (((WloginSigInfo)localObject9)._dpwd != null) {
            localObject4 = (byte[])((WloginSigInfo)localObject9)._dpwd.clone();
          }
          if (((WloginSigInfo)localObject9)._randseed == null) {
            break label1229;
          }
          localObject5 = (byte[])((WloginSigInfo)localObject9)._randseed.clone();
          localObject8 = ((WloginSigInfo)localObject9)._psKey;
          localObject9 = ((WloginSigInfo)localObject9)._pt4Token;
          localObject6 = localObject5;
          localObject7 = localObject4;
          localObject5 = localObject1;
          localObject4 = localObject3;
          localObject3 = localObject7;
          localObject1 = localObject6;
          localObject7 = localObject8;
          localObject6 = localObject9;
          if ((paramArrayOfByte14[6] == null) || (paramArrayOfByte14[6].length <= 2)) {
            break label896;
          }
          localObject8 = new HashMap();
          localObject9 = new HashMap();
          localHashMap1 = new HashMap();
          localHashMap2 = new HashMap();
          Ticket.parsePsBuf((byte[])localObject7, paramLong5, (Map)localObject8, (Map)localObject9);
          Ticket.parsePsBuf((byte[])localObject6, paramLong5, localHashMap1, localHashMap2);
          util.LOGI("current pskey size:" + ((Map)localObject8).size() + ":" + ((Map)localObject9).size(), "");
          localObject6 = ((Map)localObject9).entrySet().iterator();
          if (((Iterator)localObject6).hasNext())
          {
            localObject7 = (Map.Entry)((Iterator)localObject6).next();
            str = (String)((Map.Entry)localObject7).getKey();
            if (!Ticket.isPskeyStorageExpired(((Long)((Map.Entry)localObject7).getValue()).longValue())) {
              continue;
            }
            ((Iterator)localObject6).remove();
            ((Map)localObject8).remove(str);
            util.LOGI("delete expired pskey from file,key:" + str, "");
          }
        }
        localObject6 = localHashMap2.entrySet().iterator();
      }
      finally {}
      util.LOGI("current pt4token size:" + localHashMap1.size() + ":" + localHashMap2.size(), "");
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (Map.Entry)((Iterator)localObject6).next();
        str = (String)((Map.Entry)localObject7).getKey();
        if (Ticket.isPskeyStorageExpired(((Long)((Map.Entry)localObject7).getValue()).longValue()))
        {
          ((Iterator)localObject6).remove();
          localHashMap1.remove(str);
          util.LOGI("delete expired pt4token from file,key:" + str, "");
        }
      }
      Ticket.parseSvrPs(paramArrayOfByte14[6], paramLong5, (Map)localObject8, (Map)localObject9, localHashMap1, localHashMap2);
      try
      {
        paramArrayOfByte14[6] = Ticket.packPsBuf((Map)localObject8, paramLong5, (Map)localObject9);
        paramArrayOfByte14[12] = Ticket.packPsBuf(localHashMap1, paramLong5, localHashMap2);
        ((WloginAllSigInfo)localObject2).put_simpleinfo(paramWloginSimpleInfo);
        ((WloginAllSigInfo)localObject2).put_siginfo(paramLong3, paramLong4, paramLong5, paramLong6, paramLong7, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6, paramArrayOfByte7, paramArrayOfByte8, paramArrayOfByte9, paramArrayOfByte10, paramArrayOfByte11, paramArrayOfByte12, paramArrayOfByte13, paramArrayOfByte14, paramArrayOfLong, paramInt);
        ((WloginAllSigInfo)localObject2).put_siginfo(paramLong2, paramArrayOfByte1, paramLong5);
        localTreeMap.put(Long.valueOf(paramLong1), ((WloginAllSigInfo)localObject2).get_clone());
        j = a(localTreeMap, "tk_file");
        util.LOGI("save key result:tk_file:" + j, "");
        if (j != 0)
        {
          paramArrayOfByte1 = (WloginSigInfo)((WloginAllSigInfo)localObject2)._tk_map.get(Long.valueOf(paramLong2));
          if (paramArrayOfByte1 != null)
          {
            paramArrayOfByte1._en_A1 = ((byte[])((byte[])localObject5).clone());
            paramArrayOfByte1._noPicSig = ((byte[])((byte[])localObject4).clone());
            paramArrayOfByte1._G = ((byte[])arrayOfByte.clone());
            paramArrayOfByte1._dpwd = ((byte[])((byte[])localObject3).clone());
            paramArrayOfByte1._randseed = ((byte[])((byte[])localObject1).clone());
          }
        }
        util.LOGI("sig in memory changed", "" + paramLong1);
        this.c.put(Long.valueOf(paramLong1), ((WloginAllSigInfo)localObject2).get_clone());
      }
      catch (BufferOverflowException paramArrayOfByte1)
      {
        for (;;)
        {
          label1149:
          util.LOGI("map size " + ((Map)localObject8).size() + "is too large", "" + paramLong1);
          a(Long.valueOf(paramLong1));
          j = -1023;
        }
      }
      return j;
      continue;
      Object localObject3 = localObject6;
      continue;
      Object localObject8 = new byte[0];
      Object localObject1 = localObject5;
      localObject3 = localObject4;
      Object localObject4 = localObject6;
      Object localObject5 = localObject7;
      Object localObject7 = new byte[0];
      Object localObject6 = localObject8;
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
    label321:
    for (;;)
    {
      try
      {
        ArrayList localArrayList = new ArrayList();
        if (this.a == null) {
          break label321;
        }
        TreeMap localTreeMap = a(this.a, "tk_file", 0L);
        if (localTreeMap == null) {
          return localArrayList;
        }
        Iterator localIterator1 = localTreeMap.keySet().iterator();
        if (!localIterator1.hasNext()) {
          break label321;
        }
        Long localLong1 = (Long)localIterator1.next();
        Object localObject3 = (WloginAllSigInfo)this.c.get(localLong1);
        Object localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = (WloginAllSigInfo)localTreeMap.get(localLong1);
          if (localObject1 == null) {
            continue;
          }
          this.c.put(localLong1, localObject1);
        }
        Iterator localIterator2 = ((WloginAllSigInfo)localObject1)._tk_map.keySet().iterator();
        if (localIterator2.hasNext())
        {
          Long localLong2 = (Long)localIterator2.next();
          WloginSigInfo localWloginSigInfo = (WloginSigInfo)((WloginAllSigInfo)localObject1)._tk_map.get(localLong2);
          if (localWloginSigInfo == null) {
            continue;
          }
          String str = b(localLong1);
          localObject3 = str;
          if (str == null) {
            localObject3 = String.valueOf(localLong1);
          }
          if (((WloginAllSigInfo)localObject1)._useInfo._img_url == null) {
            ((WloginAllSigInfo)localObject1)._useInfo._img_url = new byte[0];
          }
          long l1 = localLong1.longValue();
          long l2 = localLong2.longValue();
          str = new String(((WloginAllSigInfo)localObject1)._useInfo._img_url);
          long l3 = localWloginSigInfo._create_time;
          if (paramBoolean)
          {
            j = WloginLoginInfo.TYPE_LOACL;
            localArrayList.add(new WloginLoginInfo((String)localObject3, l1, l2, str, l3, j, localWloginSigInfo._login_bitmap));
          }
        }
        else
        {
          continue;
        }
        int j = WloginLoginInfo.TYPE_REMOTE;
      }
      finally {}
    }
  }
  
  /* Error */
  public UinInfo a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_2
    //   3: ifeq +76 -> 79
    //   6: aload_0
    //   7: getfield 48	oicq/wlogin_sdk/request/d:d	Ljava/util/TreeMap;
    //   10: aload_1
    //   11: invokevirtual 241	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: checkcast 268	oicq/wlogin_sdk/request/UinInfo
    //   17: astore_3
    //   18: aload_3
    //   19: ifnull +60 -> 79
    //   22: new 86	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 611
    //   32: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc_w 613
    //   42: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_3
    //   46: getfield 274	oicq/wlogin_sdk/request/UinInfo:_uin	Ljava/lang/Long;
    //   49: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   52: ldc_w 615
    //   55: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_3
    //   59: invokevirtual 618	oicq/wlogin_sdk/request/UinInfo:getHasPassword	()Z
    //   62: invokevirtual 621	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   65: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: ldc 152
    //   70: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_3
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: areturn
    //   79: aload_0
    //   80: getfield 50	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   83: ifnonnull +8 -> 91
    //   86: aconst_null
    //   87: astore_1
    //   88: goto -13 -> 75
    //   91: aload_0
    //   92: getfield 50	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   95: ldc 52
    //   97: lconst_0
    //   98: invokestatic 55	oicq/wlogin_sdk/request/d:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   101: astore_3
    //   102: aload_3
    //   103: ifnonnull +8 -> 111
    //   106: aconst_null
    //   107: astore_1
    //   108: goto -33 -> 75
    //   111: aload_3
    //   112: aload_1
    //   113: invokevirtual 241	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   116: checkcast 268	oicq/wlogin_sdk/request/UinInfo
    //   119: astore_3
    //   120: aload_3
    //   121: ifnonnull +8 -> 129
    //   124: aconst_null
    //   125: astore_1
    //   126: goto -51 -> 75
    //   129: aload_0
    //   130: getfield 48	oicq/wlogin_sdk/request/d:d	Ljava/util/TreeMap;
    //   133: aload_1
    //   134: aload_3
    //   135: invokevirtual 437	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   138: pop
    //   139: new 86	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   146: ldc_w 623
    //   149: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_1
    //   153: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc_w 613
    //   159: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_3
    //   163: getfield 274	oicq/wlogin_sdk/request/UinInfo:_uin	Ljava/lang/Long;
    //   166: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   169: ldc_w 615
    //   172: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_3
    //   176: invokevirtual 618	oicq/wlogin_sdk/request/UinInfo:getHasPassword	()Z
    //   179: invokevirtual 621	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   182: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: ldc 152
    //   187: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: aload_3
    //   191: astore_1
    //   192: goto -117 -> 75
    //   195: astore_1
    //   196: aload_0
    //   197: monitorexit
    //   198: aload_1
    //   199: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	d
    //   0	200	1	paramString	String
    //   0	200	2	paramBoolean	boolean
    //   17	174	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	18	195	finally
    //   22	73	195	finally
    //   79	86	195	finally
    //   91	102	195	finally
    //   111	120	195	finally
    //   129	190	195	finally
  }
  
  /* Error */
  public WloginAllSigInfo a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	oicq/wlogin_sdk/request/d:c	Ljava/util/TreeMap;
    //   6: lload_1
    //   7: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   10: invokevirtual 241	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   13: checkcast 243	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   16: astore_3
    //   17: aload_3
    //   18: ifnull +15 -> 33
    //   21: ldc_w 626
    //   24: ldc 152
    //   26: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_3
    //   32: areturn
    //   33: aload_0
    //   34: getfield 50	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   37: ifnonnull +8 -> 45
    //   40: aconst_null
    //   41: astore_3
    //   42: goto -13 -> 29
    //   45: aload_0
    //   46: getfield 50	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   49: ldc 60
    //   51: lload_1
    //   52: invokestatic 55	oicq/wlogin_sdk/request/d:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   55: astore_3
    //   56: aload_3
    //   57: ifnonnull +8 -> 65
    //   60: aconst_null
    //   61: astore_3
    //   62: goto -33 -> 29
    //   65: aload_3
    //   66: lload_1
    //   67: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   70: invokevirtual 241	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: checkcast 243	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   76: astore_3
    //   77: aload_3
    //   78: ifnonnull +8 -> 86
    //   81: aconst_null
    //   82: astore_3
    //   83: goto -54 -> 29
    //   86: ldc_w 628
    //   89: ldc 152
    //   91: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_0
    //   95: getfield 46	oicq/wlogin_sdk/request/d:c	Ljava/util/TreeMap;
    //   98: lload_1
    //   99: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   102: aload_3
    //   103: invokevirtual 437	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   106: pop
    //   107: goto -78 -> 29
    //   110: astore_3
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_3
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	d
    //   0	115	1	paramLong	long
    //   16	87	3	localObject1	Object
    //   110	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	110	finally
    //   21	29	110	finally
    //   33	40	110	finally
    //   45	56	110	finally
    //   65	77	110	finally
    //   86	107	110	finally
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
    label272:
    for (;;)
    {
      try
      {
        util.LOGI("start put_randseed " + paramLong2, "" + paramLong1);
        if (this.a != null) {}
        TreeMap localTreeMap;
        synchronized (f)
        {
          localTreeMap = a(this.a, "tk_file", paramLong1);
          if (localTreeMap == null) {
            break label272;
          }
          WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)localTreeMap.get(Long.valueOf(paramLong1));
          if (localWloginAllSigInfo == null)
          {
            util.LOGI("fileInfo is null " + paramLong2, "" + paramLong1);
            return;
          }
          localWloginAllSigInfo.put_randseed(paramLong2, paramArrayOfByte);
          int j = a(localTreeMap, "tk_file");
          if (j != 0) {
            util.LOGI("put_randseed refreshTKTreeMap failed ret " + j + " appid " + paramLong2, "" + paramLong1);
          }
        }
        this.c = localTreeMap;
      }
      finally {}
      util.LOGI("end put_randseed", "" + paramLong1);
    }
  }
  
  /* Error */
  public void a(Long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 646
    //   5: new 86	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   12: ldc 152
    //   14: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_1
    //   18: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload_0
    //   28: getfield 46	oicq/wlogin_sdk/request/d:c	Ljava/util/TreeMap;
    //   31: aload_1
    //   32: invokevirtual 647	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   35: pop
    //   36: aload_0
    //   37: getfield 50	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   40: ifnull +29 -> 69
    //   43: getstatic 28	oicq/wlogin_sdk/request/d:f	Ljava/lang/Object;
    //   46: astore_2
    //   47: aload_2
    //   48: monitorenter
    //   49: aload_0
    //   50: getfield 50	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   53: ldc 60
    //   55: aload_1
    //   56: invokevirtual 517	java/lang/Long:longValue	()J
    //   59: invokestatic 55	oicq/wlogin_sdk/request/d:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   62: astore_3
    //   63: aload_3
    //   64: ifnonnull +8 -> 72
    //   67: aload_2
    //   68: monitorexit
    //   69: aload_0
    //   70: monitorexit
    //   71: return
    //   72: aload_3
    //   73: aload_1
    //   74: invokevirtual 647	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   77: pop
    //   78: aload_0
    //   79: aload_3
    //   80: ldc 60
    //   82: invokevirtual 420	oicq/wlogin_sdk/request/d:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   85: pop
    //   86: aload_2
    //   87: monitorexit
    //   88: goto -19 -> 69
    //   91: astore_1
    //   92: aload_2
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	d
    //   0	101	1	paramLong	Long
    //   62	18	3	localTreeMap	TreeMap
    // Exception table:
    //   from	to	target	type
    //   49	63	91	finally
    //   67	69	91	finally
    //   72	88	91	finally
    //   92	94	91	finally
    //   2	49	96	finally
    //   94	96	96	finally
  }
  
  public void a(Long paramLong1, Long paramLong2)
  {
    for (;;)
    {
      TreeMap localTreeMap;
      try
      {
        util.LOGI("start clear_sig", "" + paramLong1);
        ??? = (WloginAllSigInfo)this.c.get(paramLong1);
        if (??? != null)
        {
          ((WloginAllSigInfo)???)._tk_map.remove(paramLong2);
          util.LOGI("uin " + paramLong1 + " appid " + paramLong2 + " sig has been cleared");
        }
        if (this.a != null) {}
        synchronized (f)
        {
          localTreeMap = a(this.a, "tk_file", paramLong1.longValue());
          if (localTreeMap == null) {
            return;
          }
          paramLong1 = (WloginAllSigInfo)localTreeMap.get(paramLong1);
          if (paramLong1 != null) {}
        }
        paramLong1._tk_map.remove(paramLong2);
      }
      finally {}
      a(localTreeMap, "tk_file");
    }
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 48	oicq/wlogin_sdk/request/d:d	Ljava/util/TreeMap;
    //   6: aload_1
    //   7: invokevirtual 647	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: pop
    //   11: aload_0
    //   12: getfield 50	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   15: ifnull +53 -> 68
    //   18: getstatic 30	oicq/wlogin_sdk/request/d:g	Ljava/lang/Object;
    //   21: astore 4
    //   23: aload 4
    //   25: monitorenter
    //   26: aload_0
    //   27: getfield 50	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   30: ldc 52
    //   32: lconst_0
    //   33: invokestatic 55	oicq/wlogin_sdk/request/d:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   36: astore_3
    //   37: aload_3
    //   38: astore_2
    //   39: aload_3
    //   40: ifnonnull +11 -> 51
    //   43: new 43	java/util/TreeMap
    //   46: dup
    //   47: invokespecial 44	java/util/TreeMap:<init>	()V
    //   50: astore_2
    //   51: aload_2
    //   52: aload_1
    //   53: invokevirtual 647	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   56: pop
    //   57: aload_0
    //   58: aload_2
    //   59: ldc 52
    //   61: invokevirtual 420	oicq/wlogin_sdk/request/d:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   64: pop
    //   65: aload 4
    //   67: monitorexit
    //   68: aload_0
    //   69: monitorexit
    //   70: return
    //   71: astore_1
    //   72: aload 4
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	d
    //   0	82	1	paramString	String
    //   38	21	2	localTreeMap1	TreeMap
    //   36	4	3	localTreeMap2	TreeMap
    // Exception table:
    //   from	to	target	type
    //   26	37	71	finally
    //   43	51	71	finally
    //   51	68	71	finally
    //   72	75	71	finally
    //   2	26	77	finally
    //   75	77	77	finally
  }
  
  /* Error */
  public void a(String paramString, Long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 86	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 655
    //   12: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_1
    //   16: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: new 86	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   29: ldc 152
    //   31: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_2
    //   35: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_0
    //   45: aload_2
    //   46: invokevirtual 570	oicq/wlogin_sdk/request/d:b	(Ljava/lang/Long;)Ljava/lang/String;
    //   49: astore 5
    //   51: aload 5
    //   53: ifnull +13 -> 66
    //   56: aload_0
    //   57: getfield 48	oicq/wlogin_sdk/request/d:d	Ljava/util/TreeMap;
    //   60: aload 5
    //   62: invokevirtual 647	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   65: pop
    //   66: new 268	oicq/wlogin_sdk/request/UinInfo
    //   69: dup
    //   70: aload_2
    //   71: iload_3
    //   72: invokespecial 658	oicq/wlogin_sdk/request/UinInfo:<init>	(Ljava/lang/Long;Z)V
    //   75: astore 7
    //   77: aload_0
    //   78: getfield 48	oicq/wlogin_sdk/request/d:d	Ljava/util/TreeMap;
    //   81: aload_1
    //   82: aload 7
    //   84: invokevirtual 437	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   87: pop
    //   88: aload_0
    //   89: getfield 50	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   92: ifnull +70 -> 162
    //   95: getstatic 30	oicq/wlogin_sdk/request/d:g	Ljava/lang/Object;
    //   98: astore 6
    //   100: aload 6
    //   102: monitorenter
    //   103: aload_0
    //   104: getfield 50	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   107: ldc 52
    //   109: lconst_0
    //   110: invokestatic 55	oicq/wlogin_sdk/request/d:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   113: astore 4
    //   115: aload 4
    //   117: astore_2
    //   118: aload 4
    //   120: ifnonnull +11 -> 131
    //   123: new 43	java/util/TreeMap
    //   126: dup
    //   127: invokespecial 44	java/util/TreeMap:<init>	()V
    //   130: astore_2
    //   131: aload 5
    //   133: ifnull +10 -> 143
    //   136: aload_2
    //   137: aload 5
    //   139: invokevirtual 647	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   142: pop
    //   143: aload_2
    //   144: aload_1
    //   145: aload 7
    //   147: invokevirtual 437	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   150: pop
    //   151: aload_0
    //   152: aload_2
    //   153: ldc 52
    //   155: invokevirtual 420	oicq/wlogin_sdk/request/d:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   158: pop
    //   159: aload 6
    //   161: monitorexit
    //   162: aload_0
    //   163: monitorexit
    //   164: return
    //   165: astore_1
    //   166: aload 6
    //   168: monitorexit
    //   169: aload_1
    //   170: athrow
    //   171: astore_1
    //   172: aload_0
    //   173: monitorexit
    //   174: aload_1
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	d
    //   0	176	1	paramString	String
    //   0	176	2	paramLong	Long
    //   0	176	3	paramBoolean	boolean
    //   113	6	4	localTreeMap	TreeMap
    //   49	89	5	str	String
    //   75	71	7	localUinInfo	UinInfo
    // Exception table:
    //   from	to	target	type
    //   103	115	165	finally
    //   123	131	165	finally
    //   136	143	165	finally
    //   143	162	165	finally
    //   166	169	165	finally
    //   2	51	171	finally
    //   56	66	171	finally
    //   66	103	171	finally
    //   169	171	171	finally
  }
  
  public int b(TreeMap paramTreeMap, String paramString)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramTreeMap);
      localObjectOutputStream.flush();
      paramTreeMap = localByteArrayOutputStream.toByteArray();
      paramTreeMap = cryptor.encrypt(paramTreeMap, 0, paramTreeMap.length, t.B);
      j = a(this.a, paramString, paramTreeMap);
      localObjectOutputStream.close();
      localByteArrayOutputStream.close();
      return j;
    }
    catch (Throwable paramTreeMap)
    {
      for (;;)
      {
        util.LOGI("saveTKTreeMap failed " + paramTreeMap.getStackTrace().toString(), "");
        util.printThrowable(paramTreeMap, "");
        int j = -1022;
      }
    }
    finally {}
  }
  
  /* Error */
  public String b(Long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 48	oicq/wlogin_sdk/request/d:d	Ljava/util/TreeMap;
    //   6: invokevirtual 223	java/util/TreeMap:keySet	()Ljava/util/Set;
    //   9: invokeinterface 229 1 0
    //   14: astore 4
    //   16: aload 4
    //   18: invokeinterface 234 1 0
    //   23: ifeq +52 -> 75
    //   26: aload 4
    //   28: invokeinterface 237 1 0
    //   33: checkcast 62	java/lang/String
    //   36: astore_3
    //   37: aload_0
    //   38: getfield 48	oicq/wlogin_sdk/request/d:d	Ljava/util/TreeMap;
    //   41: aload_3
    //   42: invokevirtual 241	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: checkcast 268	oicq/wlogin_sdk/request/UinInfo
    //   48: astore 5
    //   50: aload 5
    //   52: ifnull -36 -> 16
    //   55: aload 5
    //   57: getfield 274	oicq/wlogin_sdk/request/UinInfo:_uin	Ljava/lang/Long;
    //   60: aload_1
    //   61: invokevirtual 691	java/lang/Long:equals	(Ljava/lang/Object;)Z
    //   64: istore_2
    //   65: iload_2
    //   66: ifeq -50 -> 16
    //   69: aload_3
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: areturn
    //   75: aconst_null
    //   76: astore_1
    //   77: goto -6 -> 71
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	d
    //   0	85	1	paramLong	Long
    //   64	2	2	bool	boolean
    //   36	34	3	str	String
    //   14	13	4	localIterator	Iterator
    //   48	8	5	localUinInfo	UinInfo
    // Exception table:
    //   from	to	target	type
    //   2	16	80	finally
    //   16	50	80	finally
    //   55	65	80	finally
  }
  
  /* Error */
  public WloginSimpleInfo b(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 694
    //   5: new 86	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 696
    //   15: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: lload_1
    //   19: invokevirtual 259	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   22: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: lload_1
    //   30: invokevirtual 698	oicq/wlogin_sdk/request/d:a	(J)Loicq/wlogin_sdk/request/WloginAllSigInfo;
    //   33: astore_3
    //   34: aload_3
    //   35: ifnonnull +9 -> 44
    //   38: aconst_null
    //   39: astore_3
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_3
    //   43: areturn
    //   44: aload_3
    //   45: getfield 577	oicq/wlogin_sdk/request/WloginAllSigInfo:_useInfo	Loicq/wlogin_sdk/sharemem/WloginSimpleInfo;
    //   48: invokevirtual 701	oicq/wlogin_sdk/sharemem/WloginSimpleInfo:get_clone	()Loicq/wlogin_sdk/sharemem/WloginSimpleInfo;
    //   51: astore_3
    //   52: goto -12 -> 40
    //   55: astore_3
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_3
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	d
    //   0	60	1	paramLong	long
    //   33	19	3	localObject1	Object
    //   55	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	34	55	finally
    //   44	52	55	finally
  }
  
  /* Error */
  public void b(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: aload_0
    //   7: monitorenter
    //   8: new 86	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 704
    //   18: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: lload_3
    //   22: invokevirtual 259	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   25: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: new 86	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   35: ldc 152
    //   37: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: lload_1
    //   41: invokevirtual 259	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   44: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_0
    //   51: getfield 50	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   54: ifnull +113 -> 167
    //   57: getstatic 28	oicq/wlogin_sdk/request/d:f	Ljava/lang/Object;
    //   60: astore 7
    //   62: aload 7
    //   64: monitorenter
    //   65: aload_0
    //   66: getfield 50	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   69: ldc 60
    //   71: lload_1
    //   72: invokestatic 55	oicq/wlogin_sdk/request/d:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   75: astore 8
    //   77: iload 6
    //   79: istore 5
    //   81: aload 8
    //   83: ifnull +81 -> 164
    //   86: aload 8
    //   88: lload_1
    //   89: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   92: invokevirtual 241	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   95: checkcast 243	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   98: astore 9
    //   100: aload 9
    //   102: ifnonnull +9 -> 111
    //   105: aload 7
    //   107: monitorexit
    //   108: aload_0
    //   109: monitorexit
    //   110: return
    //   111: ldc_w 706
    //   114: new 86	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   121: ldc 152
    //   123: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: lload_1
    //   127: invokevirtual 259	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   130: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload 9
    //   138: lload_3
    //   139: iconst_0
    //   140: newarray byte
    //   142: iconst_0
    //   143: newarray byte
    //   145: invokevirtual 710	oicq/wlogin_sdk/request/WloginAllSigInfo:putNewST	(J[B[B)V
    //   148: aload_0
    //   149: aload 8
    //   151: ldc 60
    //   153: invokevirtual 420	oicq/wlogin_sdk/request/d:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   156: istore 5
    //   158: aload_0
    //   159: aload 8
    //   161: putfield 46	oicq/wlogin_sdk/request/d:c	Ljava/util/TreeMap;
    //   164: aload 7
    //   166: monitorexit
    //   167: new 86	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   174: ldc_w 712
    //   177: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: iload 5
    //   182: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   185: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: new 86	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   195: ldc 152
    //   197: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: lload_1
    //   201: invokevirtual 259	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   204: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: goto -102 -> 108
    //   213: astore 7
    //   215: aload_0
    //   216: monitorexit
    //   217: aload 7
    //   219: athrow
    //   220: astore 8
    //   222: aload 7
    //   224: monitorexit
    //   225: aload 8
    //   227: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	d
    //   0	228	1	paramLong1	long
    //   0	228	3	paramLong2	long
    //   1	180	5	j	int
    //   4	74	6	k	int
    //   213	10	7	localObject2	Object
    //   75	85	8	localTreeMap	TreeMap
    //   220	6	8	localObject3	Object
    //   98	39	9	localWloginAllSigInfo	WloginAllSigInfo
    // Exception table:
    //   from	to	target	type
    //   8	50	213	finally
    //   50	65	213	finally
    //   167	210	213	finally
    //   225	228	213	finally
    //   65	77	220	finally
    //   86	100	220	finally
    //   105	108	220	finally
    //   111	164	220	finally
    //   164	167	220	finally
    //   222	225	220	finally
  }
  
  /* Error */
  public void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 48	oicq/wlogin_sdk/request/d:d	Ljava/util/TreeMap;
    //   6: aload_1
    //   7: invokevirtual 647	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: pop
    //   11: new 86	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 714
    //   21: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: ldc 152
    //   33: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: getfield 50	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   40: ifnull +26 -> 66
    //   43: getstatic 30	oicq/wlogin_sdk/request/d:g	Ljava/lang/Object;
    //   46: astore_2
    //   47: aload_2
    //   48: monitorenter
    //   49: aload_0
    //   50: getfield 50	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   53: ldc 52
    //   55: lconst_0
    //   56: invokestatic 55	oicq/wlogin_sdk/request/d:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   59: astore_3
    //   60: aload_3
    //   61: ifnonnull +8 -> 69
    //   64: aload_2
    //   65: monitorexit
    //   66: aload_0
    //   67: monitorexit
    //   68: return
    //   69: aload_3
    //   70: aload_1
    //   71: invokevirtual 647	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: aload_0
    //   76: aload_3
    //   77: ldc 52
    //   79: invokevirtual 420	oicq/wlogin_sdk/request/d:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   82: pop
    //   83: aload_2
    //   84: monitorexit
    //   85: goto -19 -> 66
    //   88: astore_1
    //   89: aload_2
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	d
    //   0	98	1	paramString	String
    //   59	18	3	localTreeMap	TreeMap
    // Exception table:
    //   from	to	target	type
    //   49	60	88	finally
    //   64	66	88	finally
    //   69	85	88	finally
    //   89	91	88	finally
    //   2	49	93	finally
    //   91	93	93	finally
  }
  
  /* Error */
  public void c(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 86	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 716
    //   12: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: lload_3
    //   16: invokevirtual 259	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: new 86	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   29: ldc 152
    //   31: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: lload_1
    //   35: invokevirtual 259	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   38: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 158	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_0
    //   45: getfield 46	oicq/wlogin_sdk/request/d:c	Ljava/util/TreeMap;
    //   48: lload_1
    //   49: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   52: invokevirtual 241	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: checkcast 243	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   58: astore 5
    //   60: aload 5
    //   62: ifnonnull +6 -> 68
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: aload 5
    //   70: getfield 251	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   73: lload_3
    //   74: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   77: invokevirtual 241	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   80: checkcast 462	oicq/wlogin_sdk/sharemem/WloginSigInfo
    //   83: astore 6
    //   85: aload 6
    //   87: ifnull -22 -> 65
    //   90: aload 6
    //   92: iconst_0
    //   93: newarray byte
    //   95: putfield 487	oicq/wlogin_sdk/sharemem/WloginSigInfo:_pt4Token	[B
    //   98: aload 6
    //   100: iconst_0
    //   101: newarray byte
    //   103: putfield 484	oicq/wlogin_sdk/sharemem/WloginSigInfo:_psKey	[B
    //   106: aload 6
    //   108: aconst_null
    //   109: putfield 720	oicq/wlogin_sdk/sharemem/WloginSigInfo:cacheTickets	Ljava/util/List;
    //   112: aload 6
    //   114: lconst_0
    //   115: putfield 723	oicq/wlogin_sdk/sharemem/WloginSigInfo:cacheUpdateStamp	J
    //   118: aload 5
    //   120: getfield 251	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   123: lload_1
    //   124: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   127: aload 6
    //   129: invokevirtual 437	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   132: pop
    //   133: aload_0
    //   134: getfield 50	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   137: ifnull -72 -> 65
    //   140: getstatic 28	oicq/wlogin_sdk/request/d:f	Ljava/lang/Object;
    //   143: astore 6
    //   145: aload 6
    //   147: monitorenter
    //   148: aload_0
    //   149: getfield 50	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   152: ldc 60
    //   154: lload_1
    //   155: invokestatic 55	oicq/wlogin_sdk/request/d:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   158: astore 7
    //   160: aload 7
    //   162: ifnull +30 -> 192
    //   165: aload 7
    //   167: lload_1
    //   168: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   171: aload 5
    //   173: invokevirtual 437	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   176: pop
    //   177: aload_0
    //   178: aload 7
    //   180: ldc 60
    //   182: invokevirtual 420	oicq/wlogin_sdk/request/d:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   185: pop
    //   186: aload_0
    //   187: aload 7
    //   189: putfield 46	oicq/wlogin_sdk/request/d:c	Ljava/util/TreeMap;
    //   192: aload 6
    //   194: monitorexit
    //   195: goto -130 -> 65
    //   198: astore 5
    //   200: aload 6
    //   202: monitorexit
    //   203: aload 5
    //   205: athrow
    //   206: astore 5
    //   208: aload_0
    //   209: monitorexit
    //   210: aload 5
    //   212: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	d
    //   0	213	1	paramLong1	long
    //   0	213	3	paramLong2	long
    //   58	114	5	localWloginAllSigInfo	WloginAllSigInfo
    //   198	6	5	localObject1	Object
    //   206	5	5	localObject2	Object
    //   158	30	7	localTreeMap	TreeMap
    // Exception table:
    //   from	to	target	type
    //   148	160	198	finally
    //   165	192	198	finally
    //   192	195	198	finally
    //   200	203	198	finally
    //   2	60	206	finally
    //   68	85	206	finally
    //   90	148	206	finally
    //   203	206	206	finally
  }
  
  /* Error */
  public WloginSigInfo d(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: lload_1
    //   4: invokevirtual 698	oicq/wlogin_sdk/request/d:a	(J)Loicq/wlogin_sdk/request/WloginAllSigInfo;
    //   7: astore 5
    //   9: aload 5
    //   11: ifnonnull +11 -> 22
    //   14: aconst_null
    //   15: astore 5
    //   17: aload_0
    //   18: monitorexit
    //   19: aload 5
    //   21: areturn
    //   22: aload 5
    //   24: getfield 251	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   27: lload_3
    //   28: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   31: invokevirtual 241	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   34: checkcast 462	oicq/wlogin_sdk/sharemem/WloginSigInfo
    //   37: astore 6
    //   39: aload 6
    //   41: astore 5
    //   43: aload 6
    //   45: ifnonnull -28 -> 17
    //   48: aconst_null
    //   49: astore 5
    //   51: goto -34 -> 17
    //   54: astore 5
    //   56: aload_0
    //   57: monitorexit
    //   58: aload 5
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	d
    //   0	61	1	paramLong1	long
    //   0	61	3	paramLong2	long
    //   7	43	5	localObject1	Object
    //   54	5	5	localObject2	Object
    //   37	7	6	localWloginSigInfo	WloginSigInfo
    // Exception table:
    //   from	to	target	type
    //   2	9	54	finally
    //   22	39	54	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.d
 * JD-Core Version:    0.7.0.1
 */