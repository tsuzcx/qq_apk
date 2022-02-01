package oicq.wlogin_sdk.request;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;
import oicq.wlogin_sdk.report.event.b;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class d
{
  private static final Object e = new Object();
  private static final Object f = new Object();
  private static c g = null;
  private static c h = null;
  Context a;
  TreeMap<Long, WloginAllSigInfo> b = new TreeMap();
  TreeMap<String, UinInfo> c = new TreeMap();
  public int d;
  
  public d(Context paramContext)
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
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: new 53	java/lang/StringBuffer
    //   9: dup
    //   10: invokespecial 54	java/lang/StringBuffer:<init>	()V
    //   13: astore 10
    //   15: aload_0
    //   16: aload_1
    //   17: aload 10
    //   19: invokestatic 57	oicq/wlogin_sdk/request/d:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   22: aload_1
    //   23: ldc 59
    //   25: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   28: ifeq +257 -> 285
    //   31: getstatic 30	oicq/wlogin_sdk/request/d:g	Loicq/wlogin_sdk/request/c;
    //   34: ifnonnull +17 -> 51
    //   37: new 67	oicq/wlogin_sdk/request/c
    //   40: dup
    //   41: aload_0
    //   42: aload_1
    //   43: aconst_null
    //   44: iconst_1
    //   45: invokespecial 70	oicq/wlogin_sdk/request/c:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   48: putstatic 30	oicq/wlogin_sdk/request/d:g	Loicq/wlogin_sdk/request/c;
    //   51: getstatic 30	oicq/wlogin_sdk/request/d:g	Loicq/wlogin_sdk/request/c;
    //   54: invokevirtual 74	oicq/wlogin_sdk/request/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   57: astore 6
    //   59: aload 6
    //   61: invokevirtual 80	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   64: iconst_1
    //   65: invokestatic 83	oicq/wlogin_sdk/request/d:b	(Ljava/lang/String;Z)V
    //   68: aload 6
    //   70: new 85	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   77: ldc 88
    //   79: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_1
    //   83: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc 94
    //   88: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_1
    //   92: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc 96
    //   97: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokevirtual 103	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   106: aload 6
    //   108: aload_1
    //   109: iconst_1
    //   110: anewarray 61	java/lang/String
    //   113: dup
    //   114: iconst_0
    //   115: ldc 105
    //   117: aastore
    //   118: ldc 107
    //   120: aconst_null
    //   121: aconst_null
    //   122: aconst_null
    //   123: aconst_null
    //   124: invokevirtual 111	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   127: astore 7
    //   129: aload 7
    //   131: invokeinterface 117 1 0
    //   136: ifne +58 -> 194
    //   139: aload 6
    //   141: new 85	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   148: ldc 119
    //   150: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_1
    //   154: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: ldc 121
    //   159: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_1
    //   163: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc 123
    //   168: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: iconst_2
    //   175: anewarray 4	java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: iconst_0
    //   181: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: aastore
    //   185: dup
    //   186: iconst_1
    //   187: iconst_1
    //   188: newarray byte
    //   190: aastore
    //   191: invokevirtual 132	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   194: aload 6
    //   196: new 85	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   203: ldc 134
    //   205: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_1
    //   209: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: ldc 136
    //   214: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload_1
    //   218: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc 138
    //   223: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: iconst_1
    //   230: anewarray 4	java/lang/Object
    //   233: dup
    //   234: iconst_0
    //   235: aload_2
    //   236: aastore
    //   237: invokevirtual 132	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   240: aload 7
    //   242: ifnull +20 -> 262
    //   245: aload 7
    //   247: invokeinterface 142 1 0
    //   252: ifne +10 -> 262
    //   255: aload 7
    //   257: invokeinterface 145 1 0
    //   262: aload 6
    //   264: ifnull +12 -> 276
    //   267: iconst_1
    //   268: aload 6
    //   270: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   273: if_icmpne +3 -> 276
    //   276: aload_0
    //   277: aload_1
    //   278: invokestatic 151	oicq/wlogin_sdk/request/d:b	(Landroid/content/Context;Ljava/lang/String;)V
    //   281: iconst_0
    //   282: istore_3
    //   283: iload_3
    //   284: ireturn
    //   285: getstatic 32	oicq/wlogin_sdk/request/d:h	Loicq/wlogin_sdk/request/c;
    //   288: ifnonnull +17 -> 305
    //   291: new 67	oicq/wlogin_sdk/request/c
    //   294: dup
    //   295: aload_0
    //   296: aload_1
    //   297: aconst_null
    //   298: iconst_1
    //   299: invokespecial 70	oicq/wlogin_sdk/request/c:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   302: putstatic 32	oicq/wlogin_sdk/request/d:h	Loicq/wlogin_sdk/request/c;
    //   305: getstatic 32	oicq/wlogin_sdk/request/d:h	Loicq/wlogin_sdk/request/c;
    //   308: invokevirtual 74	oicq/wlogin_sdk/request/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   311: astore 6
    //   313: goto -254 -> 59
    //   316: astore 8
    //   318: aconst_null
    //   319: astore 6
    //   321: aload_1
    //   322: ldc 59
    //   324: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   327: ifeq +127 -> 454
    //   330: aconst_null
    //   331: putstatic 30	oicq/wlogin_sdk/request/d:g	Loicq/wlogin_sdk/request/c;
    //   334: aload 10
    //   336: ldc 153
    //   338: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   341: aload 8
    //   343: invokestatic 162	oicq/wlogin_sdk/tools/util:getThrowableInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   346: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   349: pop
    //   350: aload_0
    //   351: aload_1
    //   352: aload_2
    //   353: aload 10
    //   355: invokestatic 165	oicq/wlogin_sdk/request/d:a	(Landroid/content/Context;Ljava/lang/String;[BLjava/lang/StringBuffer;)Z
    //   358: istore 5
    //   360: iload 5
    //   362: ifeq +161 -> 523
    //   365: ldc 167
    //   367: astore_2
    //   368: aload_0
    //   369: aload_1
    //   370: aload 10
    //   372: aload_2
    //   373: invokestatic 170	oicq/wlogin_sdk/request/d:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/StringBuffer;Ljava/lang/String;)V
    //   376: aload 8
    //   378: ldc 172
    //   380: invokestatic 176	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   383: new 85	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   390: ldc 178
    //   392: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: aload 8
    //   397: invokevirtual 181	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   400: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: ldc 172
    //   408: invokestatic 185	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   411: iload 5
    //   413: ifeq +116 -> 529
    //   416: aload 6
    //   418: ifnull +20 -> 438
    //   421: aload 6
    //   423: invokeinterface 142 1 0
    //   428: ifne +10 -> 438
    //   431: aload 6
    //   433: invokeinterface 145 1 0
    //   438: aload 7
    //   440: ifnull +12 -> 452
    //   443: iconst_1
    //   444: aload 7
    //   446: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   449: if_icmpne +3 -> 452
    //   452: iconst_0
    //   453: ireturn
    //   454: aconst_null
    //   455: putstatic 32	oicq/wlogin_sdk/request/d:h	Loicq/wlogin_sdk/request/c;
    //   458: goto -124 -> 334
    //   461: astore_0
    //   462: aload 7
    //   464: astore_1
    //   465: aload 6
    //   467: astore_2
    //   468: aload_2
    //   469: ifnull +18 -> 487
    //   472: aload_2
    //   473: invokeinterface 142 1 0
    //   478: ifne +9 -> 487
    //   481: aload_2
    //   482: invokeinterface 145 1 0
    //   487: aload_1
    //   488: ifnull +11 -> 499
    //   491: iconst_1
    //   492: aload_1
    //   493: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   496: if_icmpne +3 -> 499
    //   499: aload_0
    //   500: athrow
    //   501: astore_2
    //   502: aload 10
    //   504: ldc 187
    //   506: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   509: aload_2
    //   510: invokestatic 162	oicq/wlogin_sdk/tools/util:getThrowableInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   513: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   516: pop
    //   517: iconst_0
    //   518: istore 5
    //   520: goto -160 -> 360
    //   523: ldc 189
    //   525: astore_2
    //   526: goto -158 -> 368
    //   529: sipush -1022
    //   532: istore 4
    //   534: aload 6
    //   536: ifnull +20 -> 556
    //   539: aload 6
    //   541: invokeinterface 142 1 0
    //   546: ifne +10 -> 556
    //   549: aload 6
    //   551: invokeinterface 145 1 0
    //   556: iload 4
    //   558: istore_3
    //   559: aload 7
    //   561: ifnull -278 -> 283
    //   564: iload 4
    //   566: istore_3
    //   567: iconst_1
    //   568: aload 7
    //   570: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   573: if_icmpne -290 -> 283
    //   576: sipush -1022
    //   579: ireturn
    //   580: astore_0
    //   581: aload_0
    //   582: ldc 172
    //   584: invokestatic 176	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   587: goto -306 -> 281
    //   590: astore_0
    //   591: aconst_null
    //   592: astore_1
    //   593: aload 8
    //   595: astore_2
    //   596: goto -128 -> 468
    //   599: astore_0
    //   600: aload 6
    //   602: astore_1
    //   603: aload 8
    //   605: astore_2
    //   606: goto -138 -> 468
    //   609: astore_0
    //   610: aload 7
    //   612: astore_2
    //   613: aload 6
    //   615: astore_1
    //   616: goto -148 -> 468
    //   619: astore 8
    //   621: aconst_null
    //   622: astore 9
    //   624: aload 6
    //   626: astore 7
    //   628: aload 9
    //   630: astore 6
    //   632: goto -311 -> 321
    //   635: astore 8
    //   637: aload 6
    //   639: astore 9
    //   641: aload 7
    //   643: astore 6
    //   645: aload 9
    //   647: astore 7
    //   649: goto -328 -> 321
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	652	0	paramContext	Context
    //   0	652	1	paramString	String
    //   0	652	2	paramArrayOfByte	byte[]
    //   282	285	3	i	int
    //   532	33	4	j	int
    //   358	161	5	bool	boolean
    //   57	587	6	localObject1	Object
    //   4	644	7	localObject2	Object
    //   1	1	8	localObject3	Object
    //   316	288	8	localException1	Exception
    //   619	1	8	localException2	Exception
    //   635	1	8	localException3	Exception
    //   622	24	9	localObject4	Object
    //   13	490	10	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   15	51	316	java/lang/Exception
    //   51	59	316	java/lang/Exception
    //   285	305	316	java/lang/Exception
    //   305	313	316	java/lang/Exception
    //   321	334	461	finally
    //   334	350	461	finally
    //   350	360	461	finally
    //   368	411	461	finally
    //   454	458	461	finally
    //   502	517	461	finally
    //   350	360	501	java/lang/Exception
    //   276	281	580	java/lang/Exception
    //   15	51	590	finally
    //   51	59	590	finally
    //   285	305	590	finally
    //   305	313	590	finally
    //   59	129	599	finally
    //   129	194	609	finally
    //   194	240	609	finally
    //   59	129	619	java/lang/Exception
    //   129	194	635	java/lang/Exception
    //   194	240	635	java/lang/Exception
  }
  
  public static int a(Context paramContext, TreeMap paramTreeMap, String paramString, byte[] paramArrayOfByte)
  {
    util.LOGI("saveTKTreeMap start fileName=" + paramString, "");
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
      util.LOGI("saveTKTreeMap end=" + paramString, "");
      return i;
    }
    catch (Throwable paramContext)
    {
      util.LOGI("saveTKTreeMap failed " + paramContext.getStackTrace().toString(), "");
      util.printThrowable(paramContext, "");
    }
    return -1022;
  }
  
  public static int a(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    int i = paramInt;
    if (i < paramArrayOfByte1.length - paramArrayOfByte2.length - paramInt)
    {
      j = 0;
      label16:
      if (j >= paramArrayOfByte2.length) {
        break label64;
      }
      if (paramArrayOfByte1[(i + j)] == paramArrayOfByte2[j]) {}
    }
    label64:
    for (int j = 0;; j = 1)
    {
      if (j != 0)
      {
        return i;
        j += 1;
        break label16;
      }
      i += 1;
      break;
      return -1;
    }
  }
  
  public static TreeMap a(Context paramContext, String paramString, long paramLong)
  {
    util.LOGI("loadTKTreeMap sigfile start " + paramString, "");
    Object localObject1 = a(paramContext, paramString);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (localObject1 != null)
    {
      util.LOGI("loadTKTreeMap len:" + localObject1.length + " at " + u.m(), "");
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
            util.LOGI("loadTKTreeMap tree size: " + ((TreeMap)localObject1).size(), "");
            boolean bool = "tk_file".equals(paramString);
            if (bool)
            {
              if (0L == paramLong) {}
              return d(paramContext, paramString);
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
      localObject3 = new SecretKeySpec(u.C, "DESede");
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
        util.LOGI("loadTKTreeMap dbdata is null at " + u.m(), "");
      }
    }
    return localByteArrayInputStream;
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
    Object localObject3;
    if (localObject1 != null) {
      try
      {
        localObject1 = cryptor.decrypt((byte[])localObject1, 0, localObject1.length, paramArrayOfByte1);
        if (localObject1 != null)
        {
          localObject3 = new ByteArrayInputStream((byte[])localObject1);
          Object localObject4 = new ObjectInputStream((InputStream)localObject3);
          localObject1 = (TreeMap)((ObjectInputStream)localObject4).readObject();
          ((ObjectInputStream)localObject4).close();
          ((ByteArrayInputStream)localObject3).close();
          if (localObject1 != null)
          {
            localObject3 = ((TreeMap)localObject1).keySet().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = ((Iterator)localObject3).next();
              WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)((TreeMap)localObject1).get(localObject4);
              util.LOGI(localObject4 + " change guid allsig: " + localWloginAllSigInfo._tk_map, "" + localObject4);
            }
          }
        }
        localObject2 = a(paramContext, "name_file");
      }
      catch (Throwable localThrowable) {}
    }
    for (;;)
    {
      Object localObject2;
      if (localObject2 != null) {}
      try
      {
        paramArrayOfByte1 = cryptor.decrypt((byte[])localObject2, 0, localObject2.length, paramArrayOfByte1);
        if (paramArrayOfByte1 != null)
        {
          paramArrayOfByte1 = new ByteArrayInputStream(paramArrayOfByte1);
          localObject2 = new ObjectInputStream(paramArrayOfByte1);
          localObject3 = (TreeMap)((ObjectInputStream)localObject2).readObject();
          ((ObjectInputStream)localObject2).close();
          paramArrayOfByte1.close();
          if (localObject3 != null) {
            a(paramContext, (TreeMap)localObject3, "name_file", paramArrayOfByte2);
          }
        }
        return;
      }
      catch (Throwable paramContext) {}
      a(paramContext, (TreeMap)localObject2, "tk_file", paramArrayOfByte2);
    }
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString, byte[] paramArrayOfByte, StringBuffer paramStringBuffer)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic 391	oicq/wlogin_sdk/request/d:c	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   5: astore_0
    //   6: aload_3
    //   7: ldc_w 393
    //   10: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   13: aload_0
    //   14: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   17: pop
    //   18: aload_0
    //   19: invokestatic 399	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   22: ifeq +13 -> 35
    //   25: aload_3
    //   26: ldc_w 400
    //   29: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   32: pop
    //   33: iconst_0
    //   34: ireturn
    //   35: new 402	java/io/File
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 404	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore_0
    //   44: aload_0
    //   45: invokevirtual 407	java/io/File:exists	()Z
    //   48: ifne +62 -> 110
    //   51: aload_0
    //   52: invokevirtual 411	java/io/File:getParentFile	()Ljava/io/File;
    //   55: astore_1
    //   56: aload_1
    //   57: ifnull +34 -> 91
    //   60: aload_1
    //   61: invokevirtual 407	java/io/File:exists	()Z
    //   64: ifne +27 -> 91
    //   67: aload_1
    //   68: invokevirtual 414	java/io/File:mkdirs	()Z
    //   71: istore 4
    //   73: aload_3
    //   74: ldc_w 416
    //   77: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   80: iload 4
    //   82: invokevirtual 419	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   85: pop
    //   86: iload 4
    //   88: ifeq -55 -> 33
    //   91: aload_0
    //   92: invokevirtual 422	java/io/File:createNewFile	()Z
    //   95: istore 4
    //   97: aload_3
    //   98: ldc_w 424
    //   101: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   104: iload 4
    //   106: invokevirtual 419	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   109: pop
    //   110: aload_0
    //   111: invokevirtual 407	java/io/File:exists	()Z
    //   114: ifeq +10 -> 124
    //   117: aload_0
    //   118: invokevirtual 427	java/io/File:canWrite	()Z
    //   121: ifne +35 -> 156
    //   124: aload_3
    //   125: ldc_w 429
    //   128: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   131: aload_0
    //   132: invokevirtual 407	java/io/File:exists	()Z
    //   135: invokevirtual 419	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   138: pop
    //   139: aload_3
    //   140: ldc_w 431
    //   143: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   146: aload_0
    //   147: invokevirtual 427	java/io/File:canWrite	()Z
    //   150: invokevirtual 419	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   153: pop
    //   154: iconst_0
    //   155: ireturn
    //   156: new 433	java/io/FileOutputStream
    //   159: dup
    //   160: aload_0
    //   161: iconst_0
    //   162: invokespecial 436	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   165: astore 5
    //   167: aconst_null
    //   168: astore_0
    //   169: aload 5
    //   171: aload_2
    //   172: invokevirtual 439	java/io/FileOutputStream:write	([B)V
    //   175: aload 5
    //   177: ifnull +12 -> 189
    //   180: iconst_0
    //   181: ifeq +50 -> 231
    //   184: aload 5
    //   186: invokevirtual 440	java/io/FileOutputStream:close	()V
    //   189: aload_3
    //   190: ldc_w 442
    //   193: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   196: aload_2
    //   197: arraylength
    //   198: invokevirtual 445	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   201: pop
    //   202: iconst_1
    //   203: ireturn
    //   204: astore_0
    //   205: new 447	java/lang/NullPointerException
    //   208: dup
    //   209: invokespecial 448	java/lang/NullPointerException:<init>	()V
    //   212: athrow
    //   213: astore_0
    //   214: aload_3
    //   215: ldc_w 450
    //   218: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   221: aload_0
    //   222: invokestatic 162	oicq/wlogin_sdk/tools/util:getThrowableInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   225: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   228: pop
    //   229: iconst_0
    //   230: ireturn
    //   231: aload 5
    //   233: invokevirtual 440	java/io/FileOutputStream:close	()V
    //   236: goto -47 -> 189
    //   239: astore_1
    //   240: aload_1
    //   241: astore_0
    //   242: aload_1
    //   243: athrow
    //   244: astore_1
    //   245: aload 5
    //   247: ifnull +12 -> 259
    //   250: aload_0
    //   251: ifnull +19 -> 270
    //   254: aload 5
    //   256: invokevirtual 440	java/io/FileOutputStream:close	()V
    //   259: aload_1
    //   260: athrow
    //   261: astore_2
    //   262: aload_0
    //   263: aload_2
    //   264: invokevirtual 454	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   267: goto -8 -> 259
    //   270: aload 5
    //   272: invokevirtual 440	java/io/FileOutputStream:close	()V
    //   275: goto -16 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	paramContext	Context
    //   0	278	1	paramString	String
    //   0	278	2	paramArrayOfByte	byte[]
    //   0	278	3	paramStringBuffer	StringBuffer
    //   71	34	4	bool	boolean
    //   165	106	5	localFileOutputStream	FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   184	189	204	java/lang/Throwable
    //   156	167	213	java/lang/Exception
    //   184	189	213	java/lang/Exception
    //   205	213	213	java/lang/Exception
    //   231	236	213	java/lang/Exception
    //   254	259	213	java/lang/Exception
    //   259	261	213	java/lang/Exception
    //   262	267	213	java/lang/Exception
    //   270	275	213	java/lang/Exception
    //   169	175	239	java/lang/Throwable
    //   169	175	244	finally
    //   242	244	244	finally
    //   254	259	261	java/lang/Throwable
  }
  
  /* Error */
  public static byte[] a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iconst_0
    //   4: invokestatic 459	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   7: astore 6
    //   9: new 53	java/lang/StringBuffer
    //   12: dup
    //   13: invokespecial 54	java/lang/StringBuffer:<init>	()V
    //   16: astore 8
    //   18: aload_0
    //   19: aload_1
    //   20: aload 8
    //   22: invokestatic 57	oicq/wlogin_sdk/request/d:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   25: aload_1
    //   26: ldc 59
    //   28: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   31: ifeq +176 -> 207
    //   34: getstatic 30	oicq/wlogin_sdk/request/d:g	Loicq/wlogin_sdk/request/c;
    //   37: ifnonnull +17 -> 54
    //   40: new 67	oicq/wlogin_sdk/request/c
    //   43: dup
    //   44: aload_0
    //   45: aload_1
    //   46: aconst_null
    //   47: iconst_1
    //   48: invokespecial 70	oicq/wlogin_sdk/request/c:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   51: putstatic 30	oicq/wlogin_sdk/request/d:g	Loicq/wlogin_sdk/request/c;
    //   54: getstatic 30	oicq/wlogin_sdk/request/d:g	Loicq/wlogin_sdk/request/c;
    //   57: invokevirtual 462	oicq/wlogin_sdk/request/c:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   60: astore_3
    //   61: aload_3
    //   62: invokevirtual 80	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   65: iconst_0
    //   66: invokestatic 83	oicq/wlogin_sdk/request/d:b	(Ljava/lang/String;Z)V
    //   69: aload_3
    //   70: new 85	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   77: ldc_w 464
    //   80: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_1
    //   84: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc_w 466
    //   90: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: aconst_null
    //   97: invokevirtual 470	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   100: astore 4
    //   102: aload 6
    //   104: astore 5
    //   106: aload 4
    //   108: invokeinterface 473 1 0
    //   113: ifeq +24 -> 137
    //   116: aload 6
    //   118: astore 5
    //   120: aload 4
    //   122: iconst_0
    //   123: invokeinterface 477 2 0
    //   128: ifle +9 -> 137
    //   131: iconst_1
    //   132: invokestatic 459	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   135: astore 5
    //   137: aload 4
    //   139: ifnull +20 -> 159
    //   142: aload 4
    //   144: invokeinterface 142 1 0
    //   149: ifne +10 -> 159
    //   152: aload 4
    //   154: invokeinterface 145 1 0
    //   159: aload 5
    //   161: invokevirtual 480	java/lang/Boolean:booleanValue	()Z
    //   164: istore_2
    //   165: iload_2
    //   166: ifne +71 -> 237
    //   169: aload 4
    //   171: ifnull +20 -> 191
    //   174: aload 4
    //   176: invokeinterface 142 1 0
    //   181: ifne +10 -> 191
    //   184: aload 4
    //   186: invokeinterface 145 1 0
    //   191: aload_3
    //   192: ifnull +11 -> 203
    //   195: iconst_1
    //   196: aload_3
    //   197: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   200: if_icmpne +3 -> 203
    //   203: aconst_null
    //   204: astore_0
    //   205: aload_0
    //   206: areturn
    //   207: getstatic 32	oicq/wlogin_sdk/request/d:h	Loicq/wlogin_sdk/request/c;
    //   210: ifnonnull +17 -> 227
    //   213: new 67	oicq/wlogin_sdk/request/c
    //   216: dup
    //   217: aload_0
    //   218: aload_1
    //   219: aconst_null
    //   220: iconst_1
    //   221: invokespecial 70	oicq/wlogin_sdk/request/c:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   224: putstatic 32	oicq/wlogin_sdk/request/d:h	Loicq/wlogin_sdk/request/c;
    //   227: getstatic 32	oicq/wlogin_sdk/request/d:h	Loicq/wlogin_sdk/request/c;
    //   230: invokevirtual 462	oicq/wlogin_sdk/request/c:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   233: astore_3
    //   234: goto -173 -> 61
    //   237: aload_3
    //   238: aload_1
    //   239: iconst_1
    //   240: anewarray 61	java/lang/String
    //   243: dup
    //   244: iconst_0
    //   245: aload_1
    //   246: aastore
    //   247: ldc 107
    //   249: aconst_null
    //   250: aconst_null
    //   251: aconst_null
    //   252: aconst_null
    //   253: invokevirtual 111	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   256: astore 5
    //   258: aload 5
    //   260: astore 4
    //   262: aload 4
    //   264: ifnonnull +39 -> 303
    //   267: aload 4
    //   269: ifnull +20 -> 289
    //   272: aload 4
    //   274: invokeinterface 142 1 0
    //   279: ifne +10 -> 289
    //   282: aload 4
    //   284: invokeinterface 145 1 0
    //   289: aload_3
    //   290: ifnull +11 -> 301
    //   293: iconst_1
    //   294: aload_3
    //   295: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   298: if_icmpne +3 -> 301
    //   301: aconst_null
    //   302: areturn
    //   303: aload 4
    //   305: invokeinterface 483 1 0
    //   310: ifeq +57 -> 367
    //   313: aload 4
    //   315: iconst_0
    //   316: invokeinterface 487 2 0
    //   321: astore 5
    //   323: aload 4
    //   325: invokeinterface 145 1 0
    //   330: aload 4
    //   332: ifnull +20 -> 352
    //   335: aload 4
    //   337: invokeinterface 142 1 0
    //   342: ifne +10 -> 352
    //   345: aload 4
    //   347: invokeinterface 145 1 0
    //   352: aload_3
    //   353: ifnull +11 -> 364
    //   356: iconst_1
    //   357: aload_3
    //   358: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   361: if_icmpne +3 -> 364
    //   364: aload 5
    //   366: areturn
    //   367: aload 4
    //   369: invokeinterface 145 1 0
    //   374: aload 4
    //   376: ifnull +20 -> 396
    //   379: aload 4
    //   381: invokeinterface 142 1 0
    //   386: ifne +10 -> 396
    //   389: aload 4
    //   391: invokeinterface 145 1 0
    //   396: aload_3
    //   397: ifnull +11 -> 408
    //   400: iconst_1
    //   401: aload_3
    //   402: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   405: if_icmpne +3 -> 408
    //   408: aconst_null
    //   409: areturn
    //   410: astore 5
    //   412: aconst_null
    //   413: astore 4
    //   415: aconst_null
    //   416: astore_3
    //   417: aload_1
    //   418: ldc 59
    //   420: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   423: ifeq +101 -> 524
    //   426: aconst_null
    //   427: putstatic 30	oicq/wlogin_sdk/request/d:g	Loicq/wlogin_sdk/request/c;
    //   430: aload 8
    //   432: ldc 153
    //   434: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   437: aload 5
    //   439: invokestatic 162	oicq/wlogin_sdk/tools/util:getThrowableInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   442: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   445: pop
    //   446: aload_0
    //   447: aload_1
    //   448: aload 8
    //   450: invokestatic 490	oicq/wlogin_sdk/request/d:c	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/StringBuffer;)[B
    //   453: astore 6
    //   455: aload 6
    //   457: ifnull +135 -> 592
    //   460: ldc_w 492
    //   463: astore 7
    //   465: aload_0
    //   466: aload_1
    //   467: aload 8
    //   469: aload 7
    //   471: invokestatic 170	oicq/wlogin_sdk/request/d:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/StringBuffer;Ljava/lang/String;)V
    //   474: aload 5
    //   476: ldc 172
    //   478: invokestatic 176	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   481: aload 4
    //   483: ifnull +20 -> 503
    //   486: aload 4
    //   488: invokeinterface 142 1 0
    //   493: ifne +10 -> 503
    //   496: aload 4
    //   498: invokeinterface 145 1 0
    //   503: aload 6
    //   505: astore_0
    //   506: aload_3
    //   507: ifnull -302 -> 205
    //   510: aload 6
    //   512: astore_0
    //   513: iconst_1
    //   514: aload_3
    //   515: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   518: if_icmpne -313 -> 205
    //   521: aload 6
    //   523: areturn
    //   524: aconst_null
    //   525: putstatic 32	oicq/wlogin_sdk/request/d:h	Loicq/wlogin_sdk/request/c;
    //   528: goto -98 -> 430
    //   531: astore_0
    //   532: aload 4
    //   534: astore_1
    //   535: aload_1
    //   536: ifnull +18 -> 554
    //   539: aload_1
    //   540: invokeinterface 142 1 0
    //   545: ifne +9 -> 554
    //   548: aload_1
    //   549: invokeinterface 145 1 0
    //   554: aload_3
    //   555: ifnull +11 -> 566
    //   558: iconst_1
    //   559: aload_3
    //   560: invokevirtual 148	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   563: if_icmpne +3 -> 566
    //   566: aload_0
    //   567: athrow
    //   568: astore 6
    //   570: aload 8
    //   572: ldc 187
    //   574: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   577: aload 6
    //   579: invokestatic 162	oicq/wlogin_sdk/tools/util:getThrowableInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   582: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   585: pop
    //   586: aconst_null
    //   587: astore 6
    //   589: goto -134 -> 455
    //   592: ldc_w 494
    //   595: astore 7
    //   597: goto -132 -> 465
    //   600: astore_0
    //   601: aconst_null
    //   602: astore_3
    //   603: aload 5
    //   605: astore_1
    //   606: goto -71 -> 535
    //   609: astore_0
    //   610: aload 5
    //   612: astore_1
    //   613: goto -78 -> 535
    //   616: astore_0
    //   617: aload 4
    //   619: astore_1
    //   620: goto -85 -> 535
    //   623: astore_0
    //   624: aload 4
    //   626: astore_1
    //   627: goto -92 -> 535
    //   630: astore 5
    //   632: aconst_null
    //   633: astore 4
    //   635: goto -218 -> 417
    //   638: astore 5
    //   640: goto -223 -> 417
    //   643: astore 5
    //   645: goto -228 -> 417
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	648	0	paramContext	Context
    //   0	648	1	paramString	String
    //   164	2	2	bool	boolean
    //   60	543	3	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   100	534	4	localObject1	Object
    //   1	364	5	localObject2	Object
    //   410	201	5	localException1	Exception
    //   630	1	5	localException2	Exception
    //   638	1	5	localException3	Exception
    //   643	1	5	localException4	Exception
    //   7	515	6	localObject3	Object
    //   568	10	6	localException5	Exception
    //   587	1	6	localObject4	Object
    //   463	133	7	str	String
    //   16	555	8	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   18	54	410	java/lang/Exception
    //   54	61	410	java/lang/Exception
    //   207	227	410	java/lang/Exception
    //   227	234	410	java/lang/Exception
    //   417	430	531	finally
    //   430	446	531	finally
    //   446	455	531	finally
    //   465	481	531	finally
    //   524	528	531	finally
    //   570	586	531	finally
    //   446	455	568	java/lang/Exception
    //   18	54	600	finally
    //   54	61	600	finally
    //   207	227	600	finally
    //   227	234	600	finally
    //   61	102	609	finally
    //   106	116	616	finally
    //   120	137	616	finally
    //   142	159	616	finally
    //   159	165	616	finally
    //   237	258	616	finally
    //   303	330	623	finally
    //   367	374	623	finally
    //   61	102	630	java/lang/Exception
    //   106	116	638	java/lang/Exception
    //   120	137	638	java/lang/Exception
    //   142	159	638	java/lang/Exception
    //   159	165	638	java/lang/Exception
    //   237	258	638	java/lang/Exception
    //   303	330	643	java/lang/Exception
    //   367	374	643	java/lang/Exception
  }
  
  public static void b(Context paramContext, String paramString)
  {
    paramContext = c(paramContext, paramString);
    if (TextUtils.isEmpty(paramContext)) {}
    do
    {
      return;
      paramContext = new File(paramContext);
    } while (!paramContext.exists());
    boolean bool = paramContext.delete();
    util.LOGI("delSigFile result = " + bool, "");
  }
  
  public static void b(Context paramContext, String paramString, StringBuffer paramStringBuffer)
  {
    try
    {
      paramStringBuffer.append(",table=").append(paramString);
      paramContext = paramContext.getDatabasePath(paramString);
      paramStringBuffer.append(",file=").append(paramContext.getAbsolutePath());
      paramStringBuffer.append(",isExists=").append(paramContext.exists());
      paramStringBuffer.append(",canRead=").append(paramContext.canRead());
      paramStringBuffer.append(",canWrite=").append(paramContext.canWrite());
      paramStringBuffer.append(",canExecute=").append(paramContext.canExecute());
      paramStringBuffer.append(",lastModified=").append(paramContext.lastModified());
      paramContext = paramContext.getParentFile();
      paramStringBuffer.append(",isParentExists=").append(paramContext.exists());
      return;
    }
    catch (Exception paramContext)
    {
      paramStringBuffer.append(",exception=").append(util.getThrowableInfo(paramContext));
    }
  }
  
  private static void b(String paramString, boolean paramBoolean)
  {
    long l = new File(paramString).lastModified();
    util.LOGI("file " + paramString + " last update time " + l + ",beforeWrite=" + paramBoolean, "");
  }
  
  public static String c(Context paramContext, String paramString)
  {
    paramContext = paramContext.getFilesDir();
    if (paramContext == null) {
      return "";
    }
    return paramContext.getAbsolutePath() + File.separator + "wtlogin" + File.separator + paramString;
  }
  
  /* Error */
  public static byte[] c(Context paramContext, String paramString, StringBuffer paramStringBuffer)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic 391	oicq/wlogin_sdk/request/d:c	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   5: astore_0
    //   6: aload_2
    //   7: ldc_w 559
    //   10: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   13: aload_0
    //   14: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   17: pop
    //   18: aload_0
    //   19: invokestatic 399	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   22: ifeq +13 -> 35
    //   25: aload_2
    //   26: ldc_w 400
    //   29: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   32: pop
    //   33: aconst_null
    //   34: areturn
    //   35: new 402	java/io/File
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 404	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore_1
    //   44: aload_1
    //   45: invokevirtual 407	java/io/File:exists	()Z
    //   48: ifeq +10 -> 58
    //   51: aload_1
    //   52: invokevirtual 522	java/io/File:canRead	()Z
    //   55: ifne +35 -> 90
    //   58: aload_2
    //   59: ldc_w 429
    //   62: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   65: aload_1
    //   66: invokevirtual 407	java/io/File:exists	()Z
    //   69: invokevirtual 419	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   72: pop
    //   73: aload_2
    //   74: ldc_w 561
    //   77: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   80: aload_1
    //   81: invokevirtual 522	java/io/File:canRead	()Z
    //   84: invokevirtual 419	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   87: pop
    //   88: aconst_null
    //   89: areturn
    //   90: new 563	java/io/FileInputStream
    //   93: dup
    //   94: aload_1
    //   95: invokespecial 566	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   98: astore_3
    //   99: aload_3
    //   100: invokevirtual 569	java/io/FileInputStream:available	()I
    //   103: newarray byte
    //   105: astore_0
    //   106: aload_3
    //   107: aload_0
    //   108: invokevirtual 573	java/io/FileInputStream:read	([B)I
    //   111: pop
    //   112: aload_3
    //   113: ifnull +11 -> 124
    //   116: iconst_0
    //   117: ifeq +64 -> 181
    //   120: aload_3
    //   121: invokevirtual 574	java/io/FileInputStream:close	()V
    //   124: aload_2
    //   125: ldc_w 576
    //   128: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   131: aload_0
    //   132: arraylength
    //   133: invokevirtual 445	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   136: pop
    //   137: aload_2
    //   138: ldc_w 531
    //   141: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   144: aload_1
    //   145: invokevirtual 535	java/io/File:lastModified	()J
    //   148: invokevirtual 538	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
    //   151: pop
    //   152: aload_0
    //   153: areturn
    //   154: astore_0
    //   155: new 447	java/lang/NullPointerException
    //   158: dup
    //   159: invokespecial 448	java/lang/NullPointerException:<init>	()V
    //   162: athrow
    //   163: astore_0
    //   164: aload_2
    //   165: ldc_w 578
    //   168: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   171: aload_0
    //   172: invokestatic 162	oicq/wlogin_sdk/tools/util:getThrowableInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   175: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   178: pop
    //   179: aconst_null
    //   180: areturn
    //   181: aload_3
    //   182: invokevirtual 574	java/io/FileInputStream:close	()V
    //   185: goto -61 -> 124
    //   188: astore_1
    //   189: aload_1
    //   190: athrow
    //   191: astore_0
    //   192: aload_3
    //   193: ifnull +11 -> 204
    //   196: aload_1
    //   197: ifnull +18 -> 215
    //   200: aload_3
    //   201: invokevirtual 574	java/io/FileInputStream:close	()V
    //   204: aload_0
    //   205: athrow
    //   206: astore_3
    //   207: aload_1
    //   208: aload_3
    //   209: invokevirtual 454	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   212: goto -8 -> 204
    //   215: aload_3
    //   216: invokevirtual 574	java/io/FileInputStream:close	()V
    //   219: goto -15 -> 204
    //   222: astore_0
    //   223: aconst_null
    //   224: astore_1
    //   225: goto -33 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	paramContext	Context
    //   0	228	1	paramString	String
    //   0	228	2	paramStringBuffer	StringBuffer
    //   98	103	3	localFileInputStream	FileInputStream
    //   206	10	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   120	124	154	java/lang/Throwable
    //   90	99	163	java/lang/Exception
    //   120	124	163	java/lang/Exception
    //   155	163	163	java/lang/Exception
    //   181	185	163	java/lang/Exception
    //   200	204	163	java/lang/Exception
    //   204	206	163	java/lang/Exception
    //   207	212	163	java/lang/Exception
    //   215	219	163	java/lang/Exception
    //   99	112	188	java/lang/Throwable
    //   189	191	191	finally
    //   200	204	206	java/lang/Throwable
    //   99	112	222	finally
  }
  
  private static TreeMap d(Context paramContext, String paramString)
  {
    try
    {
      localObject1 = new SecretKeySpec(u.C, "DESede");
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
          int i = 0;
          continue;
          i = 0;
          continue;
          i = 0;
          continue;
          i = 0;
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
        i = ((FileInputStream)localObject5).read(arrayOfByte1, 0, arrayOfByte1.length);
        if (i <= 0) {
          break;
        }
        util.LOGI(util.buf_to_string(arrayOfByte1, i));
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
      int m;
      label299:
      label334:
      try
      {
        arrayOfByte2 = new byte[256];
        int k = arrayOfByte2.length;
        paramString = paramContext.openFileInput(paramString);
        localObject5 = paramContext.openFileOutput("tmp_tk_file", 0);
        m = paramString.read(arrayOfByte2, 40, k - 40);
        if (m <= 0) {
          break label1221;
        }
        i = 40 + m;
        if (i >= arrayOfByte2.length) {
          break label1288;
        }
        arrayOfByte2[i] = 0;
        i += 1;
        continue;
        if (i < 0) {
          break label1293;
        }
        arrayOfByte3 = new String("WloginAllSigInfo").getBytes();
        i = a(arrayOfByte2, i, arrayOfByte3);
        if (i >= 0) {
          break;
        }
      }
      catch (Exception paramString) {}
      if (i < 0) {
        break label1298;
      }
      arrayOfByte3 = new String("WloginSigInfo").getBytes();
      i = a(arrayOfByte2, i, arrayOfByte3);
      if (i >= 0) {
        break label676;
      }
      break label1298;
      label369:
      if (i < 0) {
        break label1303;
      }
      arrayOfByte3 = new String("WloginSimpleInfo").getBytes();
      i = a(arrayOfByte2, i, arrayOfByte3);
      if (i >= 0) {
        break label847;
      }
      break label1303;
      label404:
      if (i >= 0)
      {
        arrayOfByte3 = new String("UinInfo").getBytes();
        i = a(arrayOfByte2, i, arrayOfByte3);
        if (i >= 0) {
          break label1034;
        }
      }
      ((FileOutputStream)localObject5).write(arrayOfByte2, 40, m);
      if (m > 40) {
        System.arraycopy(arrayOfByte2, m, arrayOfByte2, 0, 40);
      }
    }
    for (;;)
    {
      paramString = (String)localObject1;
      localObject1 = null;
      paramContext.deleteFile("tmp_tk_file");
      paramContext = (Context)localObject1;
      break;
      int j = i + arrayOfByte3.length;
      i = j;
      if (j + 8 > arrayOfByte2.length) {
        break label299;
      }
      i = j;
      if (arrayOfByte2[(j + 0)] != -127) {
        break label299;
      }
      i = j;
      if (arrayOfByte2[(j + 1)] != 64) {
        break label299;
      }
      i = j;
      if (arrayOfByte2[(j + 2)] != 1) {
        break label299;
      }
      i = j;
      if (arrayOfByte2[(j + 3)] != 111) {
        break label299;
      }
      i = j;
      if (arrayOfByte2[(j + 4)] != -111) {
        break label299;
      }
      i = j;
      if (arrayOfByte2[(j + 5)] != -44) {
        break label299;
      }
      i = j;
      if (arrayOfByte2[(j + 6)] != 26) {
        break label299;
      }
      i = j;
      if (arrayOfByte2[(j + 7)] != -101) {
        break label299;
      }
      arrayOfByte2[(j + 0)] = 0;
      arrayOfByte2[(j + 1)] = 0;
      arrayOfByte2[(j + 2)] = 0;
      arrayOfByte2[(j + 3)] = 0;
      arrayOfByte2[(j + 4)] = 0;
      arrayOfByte2[(j + 5)] = 0;
      arrayOfByte2[(j + 6)] = 0;
      arrayOfByte2[(j + 7)] = 1;
      i = j;
      break label299;
      label676:
      j = i + arrayOfByte3.length;
      i = j;
      if (j + 8 > arrayOfByte2.length) {
        break label334;
      }
      i = j;
      if (arrayOfByte2[(j + 0)] != 0) {
        break label334;
      }
      i = j;
      if (arrayOfByte2[(j + 1)] != 0) {
        break label334;
      }
      i = j;
      if (arrayOfByte2[(j + 2)] != 0) {
        break label334;
      }
      i = j;
      if (arrayOfByte2[(j + 3)] != 0) {
        break label334;
      }
      i = j;
      if (arrayOfByte2[(j + 4)] != 0) {
        break label334;
      }
      i = j;
      if (arrayOfByte2[(j + 5)] != 0) {
        break label334;
      }
      i = j;
      if (arrayOfByte2[(j + 6)] != 0) {
        break label334;
      }
      i = j;
      if (arrayOfByte2[(j + 7)] != 0) {
        break label334;
      }
      arrayOfByte2[(j + 0)] = 0;
      arrayOfByte2[(j + 1)] = 0;
      arrayOfByte2[(j + 2)] = 0;
      arrayOfByte2[(j + 3)] = 0;
      arrayOfByte2[(j + 4)] = 0;
      arrayOfByte2[(j + 5)] = 0;
      arrayOfByte2[(j + 6)] = 0;
      arrayOfByte2[(j + 7)] = 1;
      i = j;
      break label334;
      label847:
      j = i + arrayOfByte3.length;
      i = j;
      if (j + 8 > arrayOfByte2.length) {
        break label369;
      }
      i = j;
      if (arrayOfByte2[(j + 0)] != 57) {
        break label369;
      }
      i = j;
      if (arrayOfByte2[(j + 1)] != -69) {
        break label369;
      }
      i = j;
      if (arrayOfByte2[(j + 2)] != -84) {
        break label369;
      }
      i = j;
      if (arrayOfByte2[(j + 3)] != 110) {
        break label369;
      }
      i = j;
      if (arrayOfByte2[(j + 4)] != -46) {
        break label369;
      }
      i = j;
      if (arrayOfByte2[(j + 5)] != 98) {
        break label369;
      }
      i = j;
      if (arrayOfByte2[(j + 6)] != -31) {
        break label369;
      }
      i = j;
      if (arrayOfByte2[(j + 7)] != -113) {
        break label369;
      }
      arrayOfByte2[(j + 0)] = 0;
      arrayOfByte2[(j + 1)] = 0;
      arrayOfByte2[(j + 2)] = 0;
      arrayOfByte2[(j + 3)] = 0;
      arrayOfByte2[(j + 4)] = 0;
      arrayOfByte2[(j + 5)] = 0;
      arrayOfByte2[(j + 6)] = 0;
      arrayOfByte2[(j + 7)] = 1;
      i = j;
      break label369;
      label1034:
      j = i + arrayOfByte3.length;
      i = j;
      if (j + 8 > arrayOfByte2.length) {
        break label404;
      }
      i = j;
      if (arrayOfByte2[(j + 0)] != -118) {
        break label404;
      }
      i = j;
      if (arrayOfByte2[(j + 1)] != -23) {
        break label404;
      }
      i = j;
      if (arrayOfByte2[(j + 2)] != -128) {
        break label404;
      }
      i = j;
      if (arrayOfByte2[(j + 3)] != -19) {
        break label404;
      }
      i = j;
      if (arrayOfByte2[(j + 4)] != -26) {
        break label404;
      }
      i = j;
      if (arrayOfByte2[(j + 5)] != 99) {
        break label404;
      }
      i = j;
      if (arrayOfByte2[(j + 6)] != 41) {
        break label404;
      }
      i = j;
      if (arrayOfByte2[(j + 7)] != 14) {
        break label404;
      }
      arrayOfByte2[(j + 0)] = 0;
      arrayOfByte2[(j + 1)] = 0;
      arrayOfByte2[(j + 2)] = 0;
      arrayOfByte2[(j + 3)] = 0;
      arrayOfByte2[(j + 4)] = 0;
      arrayOfByte2[(j + 5)] = 0;
      arrayOfByte2[(j + 6)] = 0;
      arrayOfByte2[(j + 7)] = 1;
      i = j;
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
    //   8: new 85	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 631
    //   18: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: lload_3
    //   22: invokevirtual 322	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   25: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: new 85	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   35: ldc 172
    //   37: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: lload_1
    //   41: invokevirtual 322	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   44: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 185	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_0
    //   51: getfield 43	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   54: ifnull +116 -> 170
    //   57: getstatic 26	oicq/wlogin_sdk/request/d:e	Ljava/lang/Object;
    //   60: astore 7
    //   62: aload 7
    //   64: monitorenter
    //   65: aload_0
    //   66: getfield 43	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   69: ldc 59
    //   71: lload_1
    //   72: invokestatic 48	oicq/wlogin_sdk/request/d:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   75: astore 8
    //   77: iload 6
    //   79: istore 5
    //   81: aload 8
    //   83: ifnull +84 -> 167
    //   86: aload 8
    //   88: lload_1
    //   89: invokestatic 319	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   92: invokevirtual 304	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   95: checkcast 306	oicq/wlogin_sdk/request/WloginAllSigInfo
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
    //   116: ldc_w 633
    //   119: new 85	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   126: ldc 172
    //   128: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: lload_1
    //   132: invokevirtual 322	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   135: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 185	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload 9
    //   143: lload_3
    //   144: iconst_0
    //   145: newarray byte
    //   147: invokevirtual 637	oicq/wlogin_sdk/request/WloginAllSigInfo:put_da2	(J[B)I
    //   150: pop
    //   151: aload_0
    //   152: aload 8
    //   154: ldc 59
    //   156: invokevirtual 640	oicq/wlogin_sdk/request/d:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   159: istore 5
    //   161: aload_0
    //   162: aload 8
    //   164: putfield 39	oicq/wlogin_sdk/request/d:b	Ljava/util/TreeMap;
    //   167: aload 7
    //   169: monitorexit
    //   170: new 85	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   177: ldc_w 642
    //   180: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: iload 5
    //   185: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   188: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: new 85	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   198: ldc 172
    //   200: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: lload_1
    //   204: invokevirtual 322	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   207: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 185	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   1	183	5	i	int
    //   4	74	6	j	int
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
    //   2: new 85	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 645
    //   12: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: lload_3
    //   16: invokevirtual 322	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: new 85	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   29: ldc 172
    //   31: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: lload_1
    //   35: invokevirtual 322	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   38: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 185	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_0
    //   45: getfield 39	oicq/wlogin_sdk/request/d:b	Ljava/util/TreeMap;
    //   48: lload_1
    //   49: invokestatic 319	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   52: invokevirtual 304	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: checkcast 306	oicq/wlogin_sdk/request/WloginAllSigInfo
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
    //   84: invokevirtual 649	oicq/wlogin_sdk/request/WloginAllSigInfo:put_siginfo	(JJJ[B[B)I
    //   87: istore 12
    //   89: iload 12
    //   91: istore 11
    //   93: aload_0
    //   94: getfield 43	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   97: ifnull -29 -> 68
    //   100: getstatic 26	oicq/wlogin_sdk/request/d:e	Ljava/lang/Object;
    //   103: astore 14
    //   105: aload 14
    //   107: monitorenter
    //   108: aload_0
    //   109: getfield 43	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   112: ldc 59
    //   114: lload_1
    //   115: invokestatic 48	oicq/wlogin_sdk/request/d:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   118: astore 10
    //   120: aload 10
    //   122: astore 9
    //   124: aload 10
    //   126: ifnonnull +12 -> 138
    //   129: new 36	java/util/TreeMap
    //   132: dup
    //   133: invokespecial 37	java/util/TreeMap:<init>	()V
    //   136: astore 9
    //   138: aload 9
    //   140: lload_1
    //   141: invokestatic 319	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   144: aload 13
    //   146: invokevirtual 653	oicq/wlogin_sdk/request/WloginAllSigInfo:get_clone	()Loicq/wlogin_sdk/request/WloginAllSigInfo;
    //   149: invokevirtual 657	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   152: pop
    //   153: aload_0
    //   154: aload 9
    //   156: ldc 59
    //   158: invokevirtual 640	oicq/wlogin_sdk/request/d:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
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
    //   66	102	11	i	int
    //   87	79	12	j	int
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
  
  /* Error */
  public int a(long paramLong1, long paramLong2, byte[][] arg5, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, WloginSimpleInfo paramWloginSimpleInfo, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, byte[] paramArrayOfByte11, byte[] paramArrayOfByte12, byte[] paramArrayOfByte13, byte[][] paramArrayOfByte14, long[] paramArrayOfLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 85	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 662
    //   12: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload 25
    //   17: iconst_2
    //   18: iconst_2
    //   19: invokestatic 666	oicq/wlogin_sdk/tools/util:getMaskBytes	([BII)Ljava/lang/String;
    //   22: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: new 85	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   35: ldc 172
    //   37: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: lload_1
    //   41: invokevirtual 322	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   44: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 185	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_0
    //   51: getfield 43	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   54: ifnull +1410 -> 1464
    //   57: getstatic 26	oicq/wlogin_sdk/request/d:e	Ljava/lang/Object;
    //   60: astore 44
    //   62: aload 44
    //   64: monitorenter
    //   65: ldc_w 668
    //   68: new 85	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   75: ldc 172
    //   77: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: lload_1
    //   81: invokevirtual 322	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   84: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 185	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_0
    //   91: getfield 43	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   94: ldc 59
    //   96: lload_1
    //   97: invokestatic 48	oicq/wlogin_sdk/request/d:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   100: astore 39
    //   102: aload 39
    //   104: ifnonnull +1357 -> 1461
    //   107: new 36	java/util/TreeMap
    //   110: dup
    //   111: invokespecial 37	java/util/TreeMap:<init>	()V
    //   114: astore 39
    //   116: aload_0
    //   117: getfield 39	oicq/wlogin_sdk/request/d:b	Ljava/util/TreeMap;
    //   120: lload_1
    //   121: invokestatic 319	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   124: invokevirtual 304	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   127: checkcast 306	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   130: astore 33
    //   132: aload 33
    //   134: astore 35
    //   136: aload 33
    //   138: ifnonnull +35 -> 173
    //   141: aload 39
    //   143: lload_1
    //   144: invokestatic 319	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   147: invokevirtual 304	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   150: checkcast 306	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   153: astore 33
    //   155: aload 33
    //   157: astore 35
    //   159: aload 33
    //   161: ifnonnull +12 -> 173
    //   164: new 306	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   167: dup
    //   168: invokespecial 669	oicq/wlogin_sdk/request/WloginAllSigInfo:<init>	()V
    //   171: astore 35
    //   173: new 85	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   180: ldc_w 671
    //   183: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_0
    //   187: getfield 673	oicq/wlogin_sdk/request/d:d	I
    //   190: invokestatic 677	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   193: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: new 85	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   206: ldc 172
    //   208: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: lload_1
    //   212: invokevirtual 322	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   215: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 185	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   221: aload 35
    //   223: aload_0
    //   224: getfield 673	oicq/wlogin_sdk/request/d:d	I
    //   227: putfield 680	oicq/wlogin_sdk/request/WloginAllSigInfo:mainSigMap	I
    //   230: iconst_0
    //   231: newarray byte
    //   233: astore 42
    //   235: iconst_0
    //   236: newarray byte
    //   238: astore 33
    //   240: iconst_0
    //   241: newarray byte
    //   243: astore 36
    //   245: iconst_0
    //   246: newarray byte
    //   248: astore 37
    //   250: iconst_0
    //   251: newarray byte
    //   253: astore 38
    //   255: iconst_0
    //   256: newarray byte
    //   258: astore 41
    //   260: aload 35
    //   262: getfield 314	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   265: lload_3
    //   266: invokestatic 319	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   269: invokevirtual 304	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   272: checkcast 682	oicq/wlogin_sdk/sharemem/WloginSigInfo
    //   275: astore 43
    //   277: aload 43
    //   279: ifnull +1158 -> 1437
    //   282: aload 43
    //   284: getfield 685	oicq/wlogin_sdk/sharemem/WloginSigInfo:_en_A1	[B
    //   287: ifnull +1143 -> 1430
    //   290: aload 43
    //   292: getfield 685	oicq/wlogin_sdk/sharemem/WloginSigInfo:_en_A1	[B
    //   295: invokevirtual 689	[B:clone	()Ljava/lang/Object;
    //   298: checkcast 686	[B
    //   301: astore 34
    //   303: aload 43
    //   305: getfield 692	oicq/wlogin_sdk/sharemem/WloginSigInfo:_noPicSig	[B
    //   308: ifnull +1119 -> 1427
    //   311: aload 43
    //   313: getfield 692	oicq/wlogin_sdk/sharemem/WloginSigInfo:_noPicSig	[B
    //   316: invokevirtual 689	[B:clone	()Ljava/lang/Object;
    //   319: checkcast 686	[B
    //   322: astore 33
    //   324: aload 43
    //   326: getfield 695	oicq/wlogin_sdk/sharemem/WloginSigInfo:_G	[B
    //   329: ifnull +16 -> 345
    //   332: aload 43
    //   334: getfield 695	oicq/wlogin_sdk/sharemem/WloginSigInfo:_G	[B
    //   337: invokevirtual 689	[B:clone	()Ljava/lang/Object;
    //   340: checkcast 686	[B
    //   343: astore 36
    //   345: aload 43
    //   347: getfield 698	oicq/wlogin_sdk/sharemem/WloginSigInfo:_dpwd	[B
    //   350: ifnull +16 -> 366
    //   353: aload 43
    //   355: getfield 698	oicq/wlogin_sdk/sharemem/WloginSigInfo:_dpwd	[B
    //   358: invokevirtual 689	[B:clone	()Ljava/lang/Object;
    //   361: checkcast 686	[B
    //   364: astore 37
    //   366: aload 43
    //   368: getfield 701	oicq/wlogin_sdk/sharemem/WloginSigInfo:_randseed	[B
    //   371: ifnull +1053 -> 1424
    //   374: aload 43
    //   376: getfield 701	oicq/wlogin_sdk/sharemem/WloginSigInfo:_randseed	[B
    //   379: invokevirtual 689	[B:clone	()Ljava/lang/Object;
    //   382: checkcast 686	[B
    //   385: astore 38
    //   387: aload 43
    //   389: getfield 704	oicq/wlogin_sdk/sharemem/WloginSigInfo:_psKey	[B
    //   392: astore 40
    //   394: aload 43
    //   396: getfield 707	oicq/wlogin_sdk/sharemem/WloginSigInfo:_pt4Token	[B
    //   399: astore 43
    //   401: aload 38
    //   403: astore 41
    //   405: aload 37
    //   407: astore 42
    //   409: aload 34
    //   411: astore 38
    //   413: aload 33
    //   415: astore 37
    //   417: aload 42
    //   419: astore 34
    //   421: aload 41
    //   423: astore 33
    //   425: aload 43
    //   427: astore 41
    //   429: aload 29
    //   431: bipush 6
    //   433: aaload
    //   434: ifnull +454 -> 888
    //   437: aload 29
    //   439: bipush 6
    //   441: aaload
    //   442: arraylength
    //   443: iconst_2
    //   444: if_icmple +444 -> 888
    //   447: new 709	java/util/HashMap
    //   450: dup
    //   451: invokespecial 710	java/util/HashMap:<init>	()V
    //   454: astore 42
    //   456: new 709	java/util/HashMap
    //   459: dup
    //   460: invokespecial 710	java/util/HashMap:<init>	()V
    //   463: astore 43
    //   465: new 709	java/util/HashMap
    //   468: dup
    //   469: invokespecial 710	java/util/HashMap:<init>	()V
    //   472: astore 45
    //   474: new 709	java/util/HashMap
    //   477: dup
    //   478: invokespecial 710	java/util/HashMap:<init>	()V
    //   481: astore 46
    //   483: aload 40
    //   485: lload 10
    //   487: aload 42
    //   489: aload 43
    //   491: iconst_1
    //   492: invokestatic 716	oicq/wlogin_sdk/request/Ticket:parsePsBuf	([BJLjava/util/Map;Ljava/util/Map;Z)V
    //   495: aload 41
    //   497: lload 10
    //   499: aload 45
    //   501: aload 46
    //   503: iconst_0
    //   504: invokestatic 716	oicq/wlogin_sdk/request/Ticket:parsePsBuf	([BJLjava/util/Map;Ljava/util/Map;Z)V
    //   507: new 85	java/lang/StringBuilder
    //   510: dup
    //   511: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   514: ldc_w 718
    //   517: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: aload 42
    //   522: invokeinterface 721 1 0
    //   527: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   530: ldc_w 723
    //   533: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: aload 43
    //   538: invokeinterface 721 1 0
    //   543: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   546: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: ldc 172
    //   551: invokestatic 185	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   554: aload 43
    //   556: invokeinterface 726 1 0
    //   561: invokeinterface 292 1 0
    //   566: astore 40
    //   568: aload 40
    //   570: invokeinterface 297 1 0
    //   575: ifeq +107 -> 682
    //   578: aload 40
    //   580: invokeinterface 300 1 0
    //   585: checkcast 728	java/util/Map$Entry
    //   588: astore 41
    //   590: aload 41
    //   592: invokeinterface 731 1 0
    //   597: checkcast 61	java/lang/String
    //   600: astore 47
    //   602: aload 41
    //   604: invokeinterface 734 1 0
    //   609: checkcast 316	java/lang/Long
    //   612: invokevirtual 737	java/lang/Long:longValue	()J
    //   615: invokestatic 741	oicq/wlogin_sdk/request/Ticket:isPskeyStorageExpired	(J)Z
    //   618: ifeq -50 -> 568
    //   621: aload 40
    //   623: invokeinterface 744 1 0
    //   628: aload 42
    //   630: aload 47
    //   632: invokeinterface 746 2 0
    //   637: pop
    //   638: new 85	java/lang/StringBuilder
    //   641: dup
    //   642: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   645: ldc_w 748
    //   648: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: aload 47
    //   653: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   659: ldc 172
    //   661: invokestatic 185	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   664: goto -96 -> 568
    //   667: astore 5
    //   669: aload 44
    //   671: monitorexit
    //   672: aload 5
    //   674: athrow
    //   675: astore 5
    //   677: aload_0
    //   678: monitorexit
    //   679: aload 5
    //   681: athrow
    //   682: aload 46
    //   684: invokeinterface 726 1 0
    //   689: invokeinterface 292 1 0
    //   694: astore 40
    //   696: new 85	java/lang/StringBuilder
    //   699: dup
    //   700: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   703: ldc_w 750
    //   706: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: aload 45
    //   711: invokeinterface 721 1 0
    //   716: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   719: ldc_w 723
    //   722: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: aload 46
    //   727: invokeinterface 721 1 0
    //   732: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   735: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   738: ldc 172
    //   740: invokestatic 185	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   743: aload 40
    //   745: invokeinterface 297 1 0
    //   750: ifeq +92 -> 842
    //   753: aload 40
    //   755: invokeinterface 300 1 0
    //   760: checkcast 728	java/util/Map$Entry
    //   763: astore 41
    //   765: aload 41
    //   767: invokeinterface 731 1 0
    //   772: checkcast 61	java/lang/String
    //   775: astore 47
    //   777: aload 41
    //   779: invokeinterface 734 1 0
    //   784: checkcast 316	java/lang/Long
    //   787: invokevirtual 737	java/lang/Long:longValue	()J
    //   790: invokestatic 741	oicq/wlogin_sdk/request/Ticket:isPskeyStorageExpired	(J)Z
    //   793: ifeq -50 -> 743
    //   796: aload 40
    //   798: invokeinterface 744 1 0
    //   803: aload 45
    //   805: aload 47
    //   807: invokeinterface 746 2 0
    //   812: pop
    //   813: new 85	java/lang/StringBuilder
    //   816: dup
    //   817: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   820: ldc_w 752
    //   823: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: aload 47
    //   828: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   834: ldc 172
    //   836: invokestatic 185	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   839: goto -96 -> 743
    //   842: aload 29
    //   844: bipush 6
    //   846: aaload
    //   847: lload 10
    //   849: aload 42
    //   851: aload 43
    //   853: aload 45
    //   855: aload 46
    //   857: invokestatic 756	oicq/wlogin_sdk/request/Ticket:parseSvrPs	([BJLjava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V
    //   860: aload 29
    //   862: bipush 6
    //   864: aload 42
    //   866: lload 10
    //   868: aload 43
    //   870: invokestatic 760	oicq/wlogin_sdk/request/Ticket:packPsBuf	(Ljava/util/Map;JLjava/util/Map;)[B
    //   873: aastore
    //   874: aload 29
    //   876: bipush 12
    //   878: aload 45
    //   880: lload 10
    //   882: aload 46
    //   884: invokestatic 760	oicq/wlogin_sdk/request/Ticket:packPsBuf	(Ljava/util/Map;JLjava/util/Map;)[B
    //   887: aastore
    //   888: aload 35
    //   890: aload 16
    //   892: invokevirtual 764	oicq/wlogin_sdk/request/WloginAllSigInfo:put_simpleinfo	(Loicq/wlogin_sdk/sharemem/WloginSimpleInfo;)I
    //   895: pop
    //   896: aload 35
    //   898: lload 6
    //   900: lload 8
    //   902: lload 10
    //   904: lload 12
    //   906: lload 14
    //   908: aload 17
    //   910: aload 18
    //   912: aload 19
    //   914: aload 20
    //   916: aload 21
    //   918: aload 22
    //   920: aload 23
    //   922: aload 24
    //   924: aload 25
    //   926: aload 26
    //   928: aload 27
    //   930: aload 28
    //   932: aload 29
    //   934: aload 30
    //   936: iload 31
    //   938: invokevirtual 767	oicq/wlogin_sdk/request/WloginAllSigInfo:put_siginfo	(JJJJJ[B[B[B[B[B[B[B[B[B[B[B[B[[B[JI)I
    //   941: pop
    //   942: aload 5
    //   944: ifnull +66 -> 1010
    //   947: aload 5
    //   949: iconst_0
    //   950: aaload
    //   951: ifnull +59 -> 1010
    //   954: aload 5
    //   956: iconst_0
    //   957: aaload
    //   958: arraylength
    //   959: ifle +51 -> 1010
    //   962: new 85	java/lang/StringBuilder
    //   965: dup
    //   966: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   969: ldc_w 769
    //   972: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   975: aload 5
    //   977: iconst_0
    //   978: aaload
    //   979: invokestatic 775	oicq/wlogin_sdk/tools/MD5:getMD5String	([B)Ljava/lang/String;
    //   982: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   985: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   988: new 85	java/lang/StringBuilder
    //   991: dup
    //   992: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   995: ldc 172
    //   997: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1000: lload_1
    //   1001: invokevirtual 322	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1004: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1007: invokestatic 185	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1010: aload 35
    //   1012: lload_3
    //   1013: aload 5
    //   1015: lload 10
    //   1017: invokevirtual 778	oicq/wlogin_sdk/request/WloginAllSigInfo:put_siginfo	(J[[BJ)I
    //   1020: pop
    //   1021: aload 39
    //   1023: lload_1
    //   1024: invokestatic 319	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1027: aload 35
    //   1029: invokevirtual 653	oicq/wlogin_sdk/request/WloginAllSigInfo:get_clone	()Loicq/wlogin_sdk/request/WloginAllSigInfo;
    //   1032: invokevirtual 657	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1035: pop
    //   1036: getstatic 26	oicq/wlogin_sdk/request/d:e	Ljava/lang/Object;
    //   1039: astore 5
    //   1041: aload 5
    //   1043: monitorenter
    //   1044: aload_0
    //   1045: aload 39
    //   1047: ldc 59
    //   1049: invokevirtual 640	oicq/wlogin_sdk/request/d:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   1052: istore 31
    //   1054: new 85	java/lang/StringBuilder
    //   1057: dup
    //   1058: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1061: ldc_w 780
    //   1064: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1067: iload 31
    //   1069: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1072: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1075: ldc 172
    //   1077: invokestatic 185	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1080: aload 5
    //   1082: monitorexit
    //   1083: iload 31
    //   1085: ifeq +90 -> 1175
    //   1088: aload 35
    //   1090: getfield 314	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   1093: lload_3
    //   1094: invokestatic 319	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1097: invokevirtual 304	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1100: checkcast 682	oicq/wlogin_sdk/sharemem/WloginSigInfo
    //   1103: astore 5
    //   1105: aload 5
    //   1107: ifnull +68 -> 1175
    //   1110: aload 5
    //   1112: aload 38
    //   1114: invokevirtual 689	[B:clone	()Ljava/lang/Object;
    //   1117: checkcast 686	[B
    //   1120: putfield 685	oicq/wlogin_sdk/sharemem/WloginSigInfo:_en_A1	[B
    //   1123: aload 5
    //   1125: aload 37
    //   1127: invokevirtual 689	[B:clone	()Ljava/lang/Object;
    //   1130: checkcast 686	[B
    //   1133: putfield 692	oicq/wlogin_sdk/sharemem/WloginSigInfo:_noPicSig	[B
    //   1136: aload 5
    //   1138: aload 36
    //   1140: invokevirtual 689	[B:clone	()Ljava/lang/Object;
    //   1143: checkcast 686	[B
    //   1146: putfield 695	oicq/wlogin_sdk/sharemem/WloginSigInfo:_G	[B
    //   1149: aload 5
    //   1151: aload 34
    //   1153: invokevirtual 689	[B:clone	()Ljava/lang/Object;
    //   1156: checkcast 686	[B
    //   1159: putfield 698	oicq/wlogin_sdk/sharemem/WloginSigInfo:_dpwd	[B
    //   1162: aload 5
    //   1164: aload 33
    //   1166: invokevirtual 689	[B:clone	()Ljava/lang/Object;
    //   1169: checkcast 686	[B
    //   1172: putfield 701	oicq/wlogin_sdk/sharemem/WloginSigInfo:_randseed	[B
    //   1175: aload_0
    //   1176: aload 35
    //   1178: getfield 314	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   1181: lload_3
    //   1182: invokestatic 319	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1185: invokevirtual 304	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1188: checkcast 682	oicq/wlogin_sdk/sharemem/WloginSigInfo
    //   1191: iload 31
    //   1193: aload 38
    //   1195: lload_1
    //   1196: lload_3
    //   1197: invokevirtual 783	oicq/wlogin_sdk/request/d:a	(Loicq/wlogin_sdk/sharemem/WloginSigInfo;I[BJJ)Loicq/wlogin_sdk/report/event/b;
    //   1200: astore 5
    //   1202: ldc_w 785
    //   1205: new 85	java/lang/StringBuilder
    //   1208: dup
    //   1209: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1212: ldc 172
    //   1214: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1217: lload_1
    //   1218: invokevirtual 322	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1221: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1224: invokestatic 185	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1227: aload_0
    //   1228: getfield 39	oicq/wlogin_sdk/request/d:b	Ljava/util/TreeMap;
    //   1231: lload_1
    //   1232: invokestatic 319	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1235: aload 35
    //   1237: invokevirtual 653	oicq/wlogin_sdk/request/WloginAllSigInfo:get_clone	()Loicq/wlogin_sdk/request/WloginAllSigInfo;
    //   1240: invokevirtual 657	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1243: pop
    //   1244: aload 44
    //   1246: monitorexit
    //   1247: iload 31
    //   1249: istore 32
    //   1251: aload 5
    //   1253: ifnull +12 -> 1265
    //   1256: aload 5
    //   1258: invokestatic 383	oicq/wlogin_sdk/report/event/c:a	(Loicq/wlogin_sdk/report/event/b;)V
    //   1261: iload 31
    //   1263: istore 32
    //   1265: aload_0
    //   1266: monitorexit
    //   1267: iload 32
    //   1269: ireturn
    //   1270: astore 5
    //   1272: new 85	java/lang/StringBuilder
    //   1275: dup
    //   1276: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1279: ldc_w 787
    //   1282: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1285: aload 42
    //   1287: invokeinterface 721 1 0
    //   1292: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1295: ldc_w 789
    //   1298: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1301: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1304: lload_1
    //   1305: invokestatic 792	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1308: invokestatic 185	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1311: new 368	oicq/wlogin_sdk/report/event/b
    //   1314: dup
    //   1315: ldc_w 794
    //   1318: ldc_w 796
    //   1321: aload 5
    //   1323: invokestatic 801	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1326: invokespecial 373	oicq/wlogin_sdk/report/event/b:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1329: lload_1
    //   1330: invokestatic 792	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1333: invokevirtual 804	oicq/wlogin_sdk/report/event/b:a	(Ljava/lang/String;)Loicq/wlogin_sdk/report/event/b;
    //   1336: iconst_1
    //   1337: invokevirtual 376	oicq/wlogin_sdk/report/event/b:a	(Z)Loicq/wlogin_sdk/report/event/b;
    //   1340: iconst_1
    //   1341: invokevirtual 378	oicq/wlogin_sdk/report/event/b:b	(Z)Loicq/wlogin_sdk/report/event/b;
    //   1344: invokestatic 383	oicq/wlogin_sdk/report/event/c:a	(Loicq/wlogin_sdk/report/event/b;)V
    //   1347: sipush -1023
    //   1350: istore 32
    //   1352: aload 44
    //   1354: monitorexit
    //   1355: goto -90 -> 1265
    //   1358: astore 5
    //   1360: aload 5
    //   1362: lload_1
    //   1363: invokestatic 792	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1366: invokestatic 176	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   1369: new 368	oicq/wlogin_sdk/report/event/b
    //   1372: dup
    //   1373: ldc_w 794
    //   1376: ldc_w 806
    //   1379: aload 5
    //   1381: invokestatic 801	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1384: invokespecial 373	oicq/wlogin_sdk/report/event/b:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1387: lload_1
    //   1388: invokestatic 792	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1391: invokevirtual 804	oicq/wlogin_sdk/report/event/b:a	(Ljava/lang/String;)Loicq/wlogin_sdk/report/event/b;
    //   1394: iconst_1
    //   1395: invokevirtual 376	oicq/wlogin_sdk/report/event/b:a	(Z)Loicq/wlogin_sdk/report/event/b;
    //   1398: iconst_1
    //   1399: invokevirtual 378	oicq/wlogin_sdk/report/event/b:b	(Z)Loicq/wlogin_sdk/report/event/b;
    //   1402: invokestatic 383	oicq/wlogin_sdk/report/event/c:a	(Loicq/wlogin_sdk/report/event/b;)V
    //   1405: sipush -2006
    //   1408: istore 32
    //   1410: aload 44
    //   1412: monitorexit
    //   1413: goto -148 -> 1265
    //   1416: astore 16
    //   1418: aload 5
    //   1420: monitorexit
    //   1421: aload 16
    //   1423: athrow
    //   1424: goto -1037 -> 387
    //   1427: goto -1103 -> 324
    //   1430: aload 42
    //   1432: astore 34
    //   1434: goto -1110 -> 324
    //   1437: iconst_0
    //   1438: newarray byte
    //   1440: astore 40
    //   1442: aload 37
    //   1444: astore 34
    //   1446: aload 33
    //   1448: astore 37
    //   1450: aload 38
    //   1452: astore 33
    //   1454: aload 42
    //   1456: astore 38
    //   1458: goto -1029 -> 429
    //   1461: goto -1345 -> 116
    //   1464: aconst_null
    //   1465: astore 5
    //   1467: iconst_0
    //   1468: istore 31
    //   1470: goto -223 -> 1247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1473	0	this	d
    //   0	1473	1	paramLong1	long
    //   0	1473	3	paramLong2	long
    //   0	1473	6	paramLong3	long
    //   0	1473	8	paramLong4	long
    //   0	1473	10	paramLong5	long
    //   0	1473	12	paramLong6	long
    //   0	1473	14	paramLong7	long
    //   0	1473	16	paramWloginSimpleInfo	WloginSimpleInfo
    //   0	1473	17	paramArrayOfByte2	byte[]
    //   0	1473	18	paramArrayOfByte3	byte[]
    //   0	1473	19	paramArrayOfByte4	byte[]
    //   0	1473	20	paramArrayOfByte5	byte[]
    //   0	1473	21	paramArrayOfByte6	byte[]
    //   0	1473	22	paramArrayOfByte7	byte[]
    //   0	1473	23	paramArrayOfByte8	byte[]
    //   0	1473	24	paramArrayOfByte9	byte[]
    //   0	1473	25	paramArrayOfByte10	byte[]
    //   0	1473	26	paramArrayOfByte11	byte[]
    //   0	1473	27	paramArrayOfByte12	byte[]
    //   0	1473	28	paramArrayOfByte13	byte[]
    //   0	1473	29	paramArrayOfByte14	byte[][]
    //   0	1473	30	paramArrayOfLong	long[]
    //   0	1473	31	paramInt	int
    //   1249	160	32	i	int
    //   130	1323	33	localObject1	Object
    //   301	1144	34	localObject2	Object
    //   134	1102	35	localObject3	Object
    //   243	896	36	arrayOfByte	byte[]
    //   248	1201	37	localObject4	Object
    //   253	1204	38	localObject5	Object
    //   100	946	39	localTreeMap	TreeMap
    //   392	1049	40	localObject6	Object
    //   258	520	41	localObject7	Object
    //   233	1222	42	localObject8	Object
    //   275	594	43	localObject9	Object
    //   60	1351	44	localObject10	Object
    //   472	407	45	localHashMap1	java.util.HashMap
    //   481	402	46	localHashMap2	java.util.HashMap
    //   600	227	47	str	String
    // Exception table:
    //   from	to	target	type
    //   65	102	667	finally
    //   107	116	667	finally
    //   116	132	667	finally
    //   141	155	667	finally
    //   164	173	667	finally
    //   173	277	667	finally
    //   282	324	667	finally
    //   324	345	667	finally
    //   345	366	667	finally
    //   366	387	667	finally
    //   387	401	667	finally
    //   437	568	667	finally
    //   568	664	667	finally
    //   669	672	667	finally
    //   682	743	667	finally
    //   743	839	667	finally
    //   842	860	667	finally
    //   860	888	667	finally
    //   888	942	667	finally
    //   954	1010	667	finally
    //   1010	1044	667	finally
    //   1088	1105	667	finally
    //   1110	1175	667	finally
    //   1175	1247	667	finally
    //   1272	1347	667	finally
    //   1352	1355	667	finally
    //   1360	1405	667	finally
    //   1410	1413	667	finally
    //   1421	1424	667	finally
    //   2	65	675	finally
    //   672	675	675	finally
    //   1256	1261	675	finally
    //   860	888	1270	java/nio/BufferOverflowException
    //   860	888	1358	java/lang/Exception
    //   1044	1083	1416	finally
    //   1418	1421	1416	finally
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
  
  /* Error */
  public String a(Long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	oicq/wlogin_sdk/request/d:c	Ljava/util/TreeMap;
    //   6: invokevirtual 286	java/util/TreeMap:keySet	()Ljava/util/Set;
    //   9: invokeinterface 292 1 0
    //   14: astore 4
    //   16: aload 4
    //   18: invokeinterface 297 1 0
    //   23: ifeq +52 -> 75
    //   26: aload 4
    //   28: invokeinterface 300 1 0
    //   33: checkcast 61	java/lang/String
    //   36: astore_3
    //   37: aload_0
    //   38: getfield 41	oicq/wlogin_sdk/request/d:c	Ljava/util/TreeMap;
    //   41: aload_3
    //   42: invokevirtual 304	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: checkcast 327	oicq/wlogin_sdk/request/UinInfo
    //   48: astore 5
    //   50: aload 5
    //   52: ifnull -36 -> 16
    //   55: aload 5
    //   57: getfield 333	oicq/wlogin_sdk/request/UinInfo:_uin	Ljava/lang/Long;
    //   60: aload_1
    //   61: invokevirtual 810	java/lang/Long:equals	(Ljava/lang/Object;)Z
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
  
  public List<WloginLoginInfo> a(boolean paramBoolean)
  {
    label338:
    for (;;)
    {
      ArrayList localArrayList;
      Long localLong1;
      Object localObject3;
      Long localLong2;
      WloginSigInfo localWloginSigInfo;
      try
      {
        localArrayList = new ArrayList();
        if (this.a == null) {
          break label338;
        }
        TreeMap localTreeMap = a(this.a, "tk_file", 0L);
        if (localTreeMap == null) {
          return localArrayList;
        }
        Iterator localIterator1 = localTreeMap.keySet().iterator();
        if (!localIterator1.hasNext()) {
          break label338;
        }
        localLong1 = (Long)localIterator1.next();
        localObject3 = (WloginAllSigInfo)this.b.get(localLong1);
        Object localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = (WloginAllSigInfo)localTreeMap.get(localLong1);
          if (localObject1 == null) {
            continue;
          }
          this.b.put(localLong1, localObject1);
        }
        Iterator localIterator2 = ((WloginAllSigInfo)localObject1)._tk_map.keySet().iterator();
        if (localIterator2.hasNext())
        {
          localLong2 = (Long)localIterator2.next();
          localWloginSigInfo = (WloginSigInfo)((WloginAllSigInfo)localObject1)._tk_map.get(localLong2);
          if (localWloginSigInfo == null) {
            continue;
          }
          str = a(localLong1);
          localObject3 = str;
          if (str == null) {
            localObject3 = String.valueOf(localLong1);
          }
          if (((WloginAllSigInfo)localObject1)._useInfo == null) {
            util.LOGI("get_all_logined_account useInfo is null");
          }
        }
        else
        {
          continue;
        }
        if (localObject2._useInfo._img_url != null) {
          break label253;
        }
      }
      finally {}
      localObject2._useInfo._img_url = new byte[0];
      label253:
      long l1 = localLong1.longValue();
      long l2 = localLong2.longValue();
      String str = new String(localObject2._useInfo._img_url);
      long l3 = localWloginSigInfo._create_time;
      if (paramBoolean) {}
      for (int i = WloginLoginInfo.TYPE_LOACL;; i = WloginLoginInfo.TYPE_REMOTE)
      {
        localArrayList.add(new WloginLoginInfo((String)localObject3, l1, l2, str, l3, i, localWloginSigInfo._login_bitmap));
        break;
      }
    }
  }
  
  public b a(WloginSigInfo paramWloginSigInfo, int paramInt, byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    boolean bool2 = false;
    if (paramLong2 != 16L) {
      return null;
    }
    int i;
    if ((paramWloginSigInfo == null) || (paramWloginSigInfo._en_A1 == null) || (paramWloginSigInfo._en_A1.length == 0))
    {
      i = 1;
      if (i == 0) {
        break label128;
      }
      if (paramWloginSigInfo != null) {
        break label122;
      }
    }
    label122:
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
        bool2 = true;
      }
      return new b("wtlogin_alarm", "a1_empty", "").a(String.valueOf(paramLong1)).a("isSigInfoEmpty", String.valueOf(bool1)).a("isOldA1Empty", String.valueOf(bool2)).a("ret", String.valueOf(paramInt));
      i = 0;
      break;
    }
    label128:
    return null;
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
    //   7: getfield 41	oicq/wlogin_sdk/request/d:c	Ljava/util/TreeMap;
    //   10: aload_1
    //   11: invokevirtual 304	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: checkcast 327	oicq/wlogin_sdk/request/UinInfo
    //   17: astore_3
    //   18: aload_3
    //   19: ifnull +60 -> 79
    //   22: new 85	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 877
    //   32: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc_w 879
    //   42: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_3
    //   46: getfield 333	oicq/wlogin_sdk/request/UinInfo:_uin	Ljava/lang/Long;
    //   49: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   52: ldc_w 881
    //   55: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_3
    //   59: invokevirtual 884	oicq/wlogin_sdk/request/UinInfo:getHasPassword	()Z
    //   62: invokevirtual 502	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   65: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: ldc 172
    //   70: invokestatic 185	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_3
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: areturn
    //   79: aload_0
    //   80: getfield 43	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   83: ifnonnull +8 -> 91
    //   86: aconst_null
    //   87: astore_1
    //   88: goto -13 -> 75
    //   91: aload_0
    //   92: getfield 43	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   95: ldc 45
    //   97: lconst_0
    //   98: invokestatic 48	oicq/wlogin_sdk/request/d:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   101: astore_3
    //   102: aload_3
    //   103: ifnonnull +8 -> 111
    //   106: aconst_null
    //   107: astore_1
    //   108: goto -33 -> 75
    //   111: aload_3
    //   112: aload_1
    //   113: invokevirtual 304	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   116: checkcast 327	oicq/wlogin_sdk/request/UinInfo
    //   119: astore_3
    //   120: aload_3
    //   121: ifnonnull +8 -> 129
    //   124: aconst_null
    //   125: astore_1
    //   126: goto -51 -> 75
    //   129: aload_0
    //   130: getfield 41	oicq/wlogin_sdk/request/d:c	Ljava/util/TreeMap;
    //   133: aload_1
    //   134: aload_3
    //   135: invokevirtual 657	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   138: pop
    //   139: new 85	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   146: ldc_w 886
    //   149: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_1
    //   153: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc_w 879
    //   159: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_3
    //   163: getfield 333	oicq/wlogin_sdk/request/UinInfo:_uin	Ljava/lang/Long;
    //   166: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   169: ldc_w 881
    //   172: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_3
    //   176: invokevirtual 884	oicq/wlogin_sdk/request/UinInfo:getHasPassword	()Z
    //   179: invokevirtual 502	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   182: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: ldc 172
    //   187: invokestatic 185	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   3: getfield 39	oicq/wlogin_sdk/request/d:b	Ljava/util/TreeMap;
    //   6: lload_1
    //   7: invokestatic 319	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   10: invokevirtual 304	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   13: checkcast 306	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   16: astore_3
    //   17: aload_3
    //   18: ifnull +15 -> 33
    //   21: ldc_w 889
    //   24: ldc 172
    //   26: invokestatic 185	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_3
    //   32: areturn
    //   33: aload_0
    //   34: getfield 43	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   37: ifnonnull +8 -> 45
    //   40: aconst_null
    //   41: astore_3
    //   42: goto -13 -> 29
    //   45: aload_0
    //   46: getfield 43	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   49: ldc 59
    //   51: lload_1
    //   52: invokestatic 48	oicq/wlogin_sdk/request/d:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   55: astore_3
    //   56: aload_3
    //   57: ifnonnull +8 -> 65
    //   60: aconst_null
    //   61: astore_3
    //   62: goto -33 -> 29
    //   65: aload_3
    //   66: lload_1
    //   67: invokestatic 319	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   70: invokevirtual 304	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: checkcast 306	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   76: astore_3
    //   77: aload_3
    //   78: ifnonnull +8 -> 86
    //   81: aconst_null
    //   82: astore_3
    //   83: goto -54 -> 29
    //   86: ldc_w 891
    //   89: ldc 172
    //   91: invokestatic 185	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_0
    //   95: getfield 39	oicq/wlogin_sdk/request/d:b	Ljava/util/TreeMap;
    //   98: lload_1
    //   99: invokestatic 319	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   102: aload_3
    //   103: invokevirtual 657	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
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
    label272:
    for (;;)
    {
      try
      {
        util.LOGI("start put_randseed " + paramLong2, "" + paramLong1);
        if (this.a != null) {}
        TreeMap localTreeMap;
        synchronized (e)
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
          int i = a(localTreeMap, "tk_file");
          if (i != 0) {
            util.LOGI("put_randseed refreshTKTreeMap failed ret " + i + " appid " + paramLong2, "" + paramLong1);
          }
        }
        this.b = localTreeMap;
      }
      finally {}
      util.LOGI("end put_randseed", "" + paramLong1);
    }
  }
  
  public void a(Long paramLong1, Long paramLong2)
  {
    for (;;)
    {
      TreeMap localTreeMap;
      try
      {
        util.LOGI("start clear_sig", "" + paramLong1);
        ??? = (WloginAllSigInfo)this.b.get(paramLong1);
        if (??? != null)
        {
          ((WloginAllSigInfo)???)._tk_map.remove(paramLong2);
          util.LOGI("uin " + paramLong1 + " appid " + paramLong2 + " sig has been cleared");
        }
        if (this.a != null) {}
        synchronized (e)
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
    //   3: getfield 41	oicq/wlogin_sdk/request/d:c	Ljava/util/TreeMap;
    //   6: aload_1
    //   7: invokevirtual 911	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: pop
    //   11: aload_0
    //   12: getfield 43	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   15: ifnull +53 -> 68
    //   18: getstatic 28	oicq/wlogin_sdk/request/d:f	Ljava/lang/Object;
    //   21: astore 4
    //   23: aload 4
    //   25: monitorenter
    //   26: aload_0
    //   27: getfield 43	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   30: ldc 45
    //   32: lconst_0
    //   33: invokestatic 48	oicq/wlogin_sdk/request/d:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   36: astore_3
    //   37: aload_3
    //   38: astore_2
    //   39: aload_3
    //   40: ifnonnull +11 -> 51
    //   43: new 36	java/util/TreeMap
    //   46: dup
    //   47: invokespecial 37	java/util/TreeMap:<init>	()V
    //   50: astore_2
    //   51: aload_2
    //   52: aload_1
    //   53: invokevirtual 911	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   56: pop
    //   57: aload_0
    //   58: aload_2
    //   59: ldc 45
    //   61: invokevirtual 640	oicq/wlogin_sdk/request/d:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
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
    //   2: new 85	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 918
    //   12: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_1
    //   16: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: new 85	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   29: ldc 172
    //   31: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_2
    //   35: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 185	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_0
    //   45: aload_2
    //   46: invokevirtual 816	oicq/wlogin_sdk/request/d:a	(Ljava/lang/Long;)Ljava/lang/String;
    //   49: astore 5
    //   51: aload 5
    //   53: ifnull +13 -> 66
    //   56: aload_0
    //   57: getfield 41	oicq/wlogin_sdk/request/d:c	Ljava/util/TreeMap;
    //   60: aload 5
    //   62: invokevirtual 911	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   65: pop
    //   66: new 327	oicq/wlogin_sdk/request/UinInfo
    //   69: dup
    //   70: aload_2
    //   71: iload_3
    //   72: invokespecial 921	oicq/wlogin_sdk/request/UinInfo:<init>	(Ljava/lang/Long;Z)V
    //   75: astore 7
    //   77: aload_0
    //   78: getfield 41	oicq/wlogin_sdk/request/d:c	Ljava/util/TreeMap;
    //   81: aload_1
    //   82: aload 7
    //   84: invokevirtual 657	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   87: pop
    //   88: aload_0
    //   89: getfield 43	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   92: ifnull +70 -> 162
    //   95: getstatic 28	oicq/wlogin_sdk/request/d:f	Ljava/lang/Object;
    //   98: astore 6
    //   100: aload 6
    //   102: monitorenter
    //   103: aload_0
    //   104: getfield 43	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   107: ldc 45
    //   109: lconst_0
    //   110: invokestatic 48	oicq/wlogin_sdk/request/d:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   113: astore 4
    //   115: aload 4
    //   117: astore_2
    //   118: aload 4
    //   120: ifnonnull +11 -> 131
    //   123: new 36	java/util/TreeMap
    //   126: dup
    //   127: invokespecial 37	java/util/TreeMap:<init>	()V
    //   130: astore_2
    //   131: aload 5
    //   133: ifnull +10 -> 143
    //   136: aload_2
    //   137: aload 5
    //   139: invokevirtual 911	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   142: pop
    //   143: aload_2
    //   144: aload_1
    //   145: aload 7
    //   147: invokevirtual 657	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   150: pop
    //   151: aload_0
    //   152: aload_2
    //   153: ldc 45
    //   155: invokevirtual 640	oicq/wlogin_sdk/request/d:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
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
    return a(this.a, paramTreeMap, paramString, u.C);
  }
  
  /* Error */
  public WloginSimpleInfo b(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 924
    //   5: new 85	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 926
    //   15: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: lload_1
    //   19: invokevirtual 322	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   22: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 185	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: lload_1
    //   30: invokevirtual 928	oicq/wlogin_sdk/request/d:a	(J)Loicq/wlogin_sdk/request/WloginAllSigInfo;
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
    //   45: getfield 823	oicq/wlogin_sdk/request/WloginAllSigInfo:_useInfo	Loicq/wlogin_sdk/sharemem/WloginSimpleInfo;
    //   48: invokevirtual 931	oicq/wlogin_sdk/sharemem/WloginSimpleInfo:get_clone	()Loicq/wlogin_sdk/sharemem/WloginSimpleInfo;
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
    //   8: new 85	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 934
    //   18: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: lload_3
    //   22: invokevirtual 322	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   25: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: new 85	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   35: ldc 172
    //   37: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: lload_1
    //   41: invokevirtual 322	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   44: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 185	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_0
    //   51: getfield 43	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   54: ifnull +113 -> 167
    //   57: getstatic 26	oicq/wlogin_sdk/request/d:e	Ljava/lang/Object;
    //   60: astore 7
    //   62: aload 7
    //   64: monitorenter
    //   65: aload_0
    //   66: getfield 43	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   69: ldc 59
    //   71: lload_1
    //   72: invokestatic 48	oicq/wlogin_sdk/request/d:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   75: astore 8
    //   77: iload 6
    //   79: istore 5
    //   81: aload 8
    //   83: ifnull +81 -> 164
    //   86: aload 8
    //   88: lload_1
    //   89: invokestatic 319	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   92: invokevirtual 304	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   95: checkcast 306	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   98: astore 9
    //   100: aload 9
    //   102: ifnonnull +9 -> 111
    //   105: aload 7
    //   107: monitorexit
    //   108: aload_0
    //   109: monitorexit
    //   110: return
    //   111: ldc_w 936
    //   114: new 85	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   121: ldc 172
    //   123: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: lload_1
    //   127: invokevirtual 322	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   130: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 185	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload 9
    //   138: lload_3
    //   139: iconst_0
    //   140: newarray byte
    //   142: iconst_0
    //   143: newarray byte
    //   145: invokevirtual 940	oicq/wlogin_sdk/request/WloginAllSigInfo:putNewST	(J[B[B)V
    //   148: aload_0
    //   149: aload 8
    //   151: ldc 59
    //   153: invokevirtual 640	oicq/wlogin_sdk/request/d:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   156: istore 5
    //   158: aload_0
    //   159: aload 8
    //   161: putfield 39	oicq/wlogin_sdk/request/d:b	Ljava/util/TreeMap;
    //   164: aload 7
    //   166: monitorexit
    //   167: new 85	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   174: ldc_w 942
    //   177: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: iload 5
    //   182: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   185: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: new 85	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   195: ldc 172
    //   197: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: lload_1
    //   201: invokevirtual 322	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   204: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 185	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   1	180	5	i	int
    //   4	74	6	j	int
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
    //   3: getfield 41	oicq/wlogin_sdk/request/d:c	Ljava/util/TreeMap;
    //   6: aload_1
    //   7: invokevirtual 911	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: pop
    //   11: new 85	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 944
    //   21: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: ldc 172
    //   33: invokestatic 185	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: getfield 43	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   40: ifnull +26 -> 66
    //   43: getstatic 28	oicq/wlogin_sdk/request/d:f	Ljava/lang/Object;
    //   46: astore_2
    //   47: aload_2
    //   48: monitorenter
    //   49: aload_0
    //   50: getfield 43	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   53: ldc 45
    //   55: lconst_0
    //   56: invokestatic 48	oicq/wlogin_sdk/request/d:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
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
    //   71: invokevirtual 911	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: aload_0
    //   76: aload_3
    //   77: ldc 45
    //   79: invokevirtual 640	oicq/wlogin_sdk/request/d:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
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
    //   2: new 85	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 946
    //   12: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: lload_3
    //   16: invokevirtual 322	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: new 85	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   29: ldc 172
    //   31: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: lload_1
    //   35: invokevirtual 322	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   38: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 185	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_0
    //   45: getfield 39	oicq/wlogin_sdk/request/d:b	Ljava/util/TreeMap;
    //   48: lload_1
    //   49: invokestatic 319	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   52: invokevirtual 304	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: checkcast 306	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   58: astore 5
    //   60: aload 5
    //   62: ifnonnull +6 -> 68
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: aload 5
    //   70: getfield 314	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   73: lload_3
    //   74: invokestatic 319	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   77: invokevirtual 304	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   80: checkcast 682	oicq/wlogin_sdk/sharemem/WloginSigInfo
    //   83: astore 6
    //   85: aload 6
    //   87: ifnull -22 -> 65
    //   90: aload 6
    //   92: iconst_0
    //   93: newarray byte
    //   95: putfield 707	oicq/wlogin_sdk/sharemem/WloginSigInfo:_pt4Token	[B
    //   98: aload 6
    //   100: iconst_0
    //   101: newarray byte
    //   103: putfield 704	oicq/wlogin_sdk/sharemem/WloginSigInfo:_psKey	[B
    //   106: aload 6
    //   108: aconst_null
    //   109: putfield 950	oicq/wlogin_sdk/sharemem/WloginSigInfo:cacheTickets	Ljava/util/List;
    //   112: aload 6
    //   114: lconst_0
    //   115: putfield 953	oicq/wlogin_sdk/sharemem/WloginSigInfo:cacheUpdateStamp	J
    //   118: aload 5
    //   120: getfield 314	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   123: lload_1
    //   124: invokestatic 319	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   127: aload 6
    //   129: invokevirtual 657	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   132: pop
    //   133: aload_0
    //   134: getfield 43	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   137: ifnull -72 -> 65
    //   140: getstatic 26	oicq/wlogin_sdk/request/d:e	Ljava/lang/Object;
    //   143: astore 6
    //   145: aload 6
    //   147: monitorenter
    //   148: aload_0
    //   149: getfield 43	oicq/wlogin_sdk/request/d:a	Landroid/content/Context;
    //   152: ldc 59
    //   154: lload_1
    //   155: invokestatic 48	oicq/wlogin_sdk/request/d:a	(Landroid/content/Context;Ljava/lang/String;J)Ljava/util/TreeMap;
    //   158: astore 7
    //   160: aload 7
    //   162: ifnull +30 -> 192
    //   165: aload 7
    //   167: lload_1
    //   168: invokestatic 319	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   171: aload 5
    //   173: invokevirtual 657	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   176: pop
    //   177: aload_0
    //   178: aload 7
    //   180: ldc 59
    //   182: invokevirtual 640	oicq/wlogin_sdk/request/d:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   185: pop
    //   186: aload_0
    //   187: aload 7
    //   189: putfield 39	oicq/wlogin_sdk/request/d:b	Ljava/util/TreeMap;
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
    //   4: invokevirtual 928	oicq/wlogin_sdk/request/d:a	(J)Loicq/wlogin_sdk/request/WloginAllSigInfo;
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
    //   24: getfield 314	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   27: lload_3
    //   28: invokestatic 319	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   31: invokevirtual 304	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   34: checkcast 682	oicq/wlogin_sdk/sharemem/WloginSigInfo
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.d
 * JD-Core Version:    0.7.0.1
 */