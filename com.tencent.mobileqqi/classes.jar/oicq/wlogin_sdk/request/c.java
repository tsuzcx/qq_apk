package oicq.wlogin_sdk.request;

import android.content.Context;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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

public class c
{
  private static final Object e = new Object();
  private static final Object f = new Object();
  private static b g = null;
  private static b h = null;
  Context a;
  WloginLastLoginInfo b = new WloginLastLoginInfo();
  TreeMap<Long, WloginAllSigInfo> c = new TreeMap();
  TreeMap<String, UinInfo> d = new TreeMap();
  
  public c(Context paramContext)
  {
    this.a = paramContext;
    this.d = a(this.a, "name_file");
    if (this.d == null) {
      this.d = new TreeMap();
    }
  }
  
  /* Error */
  public static int a(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 58
    //   3: invokevirtual 64	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifeq +238 -> 244
    //   9: getstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   12: ifnonnull +17 -> 29
    //   15: new 66	oicq/wlogin_sdk/request/b
    //   18: dup
    //   19: aload_0
    //   20: aload_1
    //   21: aconst_null
    //   22: iconst_1
    //   23: invokespecial 69	oicq/wlogin_sdk/request/b:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   26: putstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   29: getstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   32: invokevirtual 73	oicq/wlogin_sdk/request/b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   35: astore 6
    //   37: aload 6
    //   39: new 75	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   46: ldc 78
    //   48: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_1
    //   52: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc 84
    //   57: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_1
    //   61: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc 86
    //   66: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokevirtual 96	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   75: aload 6
    //   77: aload_1
    //   78: iconst_1
    //   79: anewarray 60	java/lang/String
    //   82: dup
    //   83: iconst_0
    //   84: ldc 98
    //   86: aastore
    //   87: ldc 100
    //   89: aconst_null
    //   90: aconst_null
    //   91: aconst_null
    //   92: aconst_null
    //   93: invokevirtual 104	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   96: astore 5
    //   98: aload 5
    //   100: astore_0
    //   101: aload 5
    //   103: invokeinterface 110 1 0
    //   108: ifne +61 -> 169
    //   111: aload 5
    //   113: astore_0
    //   114: aload 6
    //   116: new 75	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   123: ldc 112
    //   125: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_1
    //   129: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc 114
    //   134: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_1
    //   138: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc 116
    //   143: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: iconst_2
    //   150: anewarray 4	java/lang/Object
    //   153: dup
    //   154: iconst_0
    //   155: iconst_0
    //   156: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: aastore
    //   160: dup
    //   161: iconst_1
    //   162: iconst_1
    //   163: newarray byte
    //   165: aastore
    //   166: invokevirtual 125	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: aload 5
    //   171: astore_0
    //   172: aload 6
    //   174: new 75	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   181: ldc 127
    //   183: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_1
    //   187: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc 129
    //   192: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_1
    //   196: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc 131
    //   201: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: iconst_1
    //   208: anewarray 4	java/lang/Object
    //   211: dup
    //   212: iconst_0
    //   213: aload_2
    //   214: aastore
    //   215: invokevirtual 125	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   218: aload 5
    //   220: ifnull +20 -> 240
    //   223: aload 5
    //   225: invokeinterface 135 1 0
    //   230: ifne +10 -> 240
    //   233: aload 5
    //   235: invokeinterface 138 1 0
    //   240: iconst_0
    //   241: istore_3
    //   242: iload_3
    //   243: ireturn
    //   244: getstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   247: ifnonnull +17 -> 264
    //   250: new 66	oicq/wlogin_sdk/request/b
    //   253: dup
    //   254: aload_0
    //   255: aload_1
    //   256: aconst_null
    //   257: iconst_1
    //   258: invokespecial 69	oicq/wlogin_sdk/request/b:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   261: putstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   264: getstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   267: invokevirtual 73	oicq/wlogin_sdk/request/b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   270: astore 6
    //   272: goto -235 -> 37
    //   275: astore_2
    //   276: aconst_null
    //   277: astore 5
    //   279: aload 5
    //   281: astore_0
    //   282: aload_1
    //   283: ldc 58
    //   285: invokevirtual 64	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   288: ifeq +56 -> 344
    //   291: aload 5
    //   293: astore_0
    //   294: aconst_null
    //   295: putstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   298: aload 5
    //   300: astore_0
    //   301: aload_2
    //   302: ldc 140
    //   304: invokestatic 146	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   307: sipush -1022
    //   310: istore 4
    //   312: iload 4
    //   314: istore_3
    //   315: aload 5
    //   317: ifnull -75 -> 242
    //   320: iload 4
    //   322: istore_3
    //   323: aload 5
    //   325: invokeinterface 135 1 0
    //   330: ifne -88 -> 242
    //   333: aload 5
    //   335: invokeinterface 138 1 0
    //   340: sipush -1022
    //   343: ireturn
    //   344: aload 5
    //   346: astore_0
    //   347: aconst_null
    //   348: putstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   351: goto -53 -> 298
    //   354: astore_2
    //   355: aload_0
    //   356: astore_1
    //   357: aload_2
    //   358: astore_0
    //   359: aload_1
    //   360: ifnull +18 -> 378
    //   363: aload_1
    //   364: invokeinterface 135 1 0
    //   369: ifne +9 -> 378
    //   372: aload_1
    //   373: invokeinterface 138 1 0
    //   378: aload_0
    //   379: athrow
    //   380: astore_0
    //   381: aconst_null
    //   382: astore_1
    //   383: goto -24 -> 359
    //   386: astore_2
    //   387: goto -108 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	paramContext	Context
    //   0	390	1	paramString	String
    //   0	390	2	paramArrayOfByte	byte[]
    //   241	82	3	i	int
    //   310	11	4	j	int
    //   96	249	5	localCursor	android.database.Cursor
    //   35	236	6	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   0	29	275	java/lang/Exception
    //   29	37	275	java/lang/Exception
    //   37	98	275	java/lang/Exception
    //   244	264	275	java/lang/Exception
    //   264	272	275	java/lang/Exception
    //   101	111	354	finally
    //   114	169	354	finally
    //   172	218	354	finally
    //   282	291	354	finally
    //   294	298	354	finally
    //   301	307	354	finally
    //   347	351	354	finally
    //   0	29	380	finally
    //   29	37	380	finally
    //   37	98	380	finally
    //   244	264	380	finally
    //   264	272	380	finally
    //   101	111	386	java/lang/Exception
    //   114	169	386	java/lang/Exception
    //   172	218	386	java/lang/Exception
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
  
  public static TreeMap a(Context paramContext, String paramString)
  {
    util.LOGI("loadTKTreeMap sigfile " + paramString, "");
    Object localObject1 = b(paramContext, paramString);
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if (localObject1 != null)
    {
      util.LOGI("loadTKTreeMap len:" + localObject1.length + " at " + t.l(), "");
      try
      {
        localObject3 = cryptor.decrypt((byte[])localObject1, 0, localObject1.length, t.z);
        if (localObject3 != null)
        {
          localObject1 = new ByteArrayInputStream((byte[])localObject3);
          localObject4 = new ObjectInputStream((InputStream)localObject1);
          localObject3 = (TreeMap)((ObjectInputStream)localObject4).readObject();
          ((ObjectInputStream)localObject4).close();
          ((ByteArrayInputStream)localObject1).close();
          if (localObject3 != null)
          {
            util.LOGI("loadTKTreeMap tree size: " + ((TreeMap)localObject3).size(), "");
            if ("tk_file".equals(paramString))
            {
              localObject4 = ((TreeMap)localObject3).keySet().iterator();
              for (;;)
              {
                localObject1 = localObject3;
                if (!((Iterator)localObject4).hasNext()) {
                  break;
                }
                localObject1 = ((Iterator)localObject4).next();
                localObject5 = (WloginAllSigInfo)((TreeMap)localObject3).get(localObject1);
                util.LOGI(localObject1 + " allsig: " + ((WloginAllSigInfo)localObject5)._tk_map, "" + localObject1);
              }
              localObject2 = c(paramContext, paramString);
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        util.printThrowable(localThrowable, "");
      }
    }
    for (;;)
    {
      return localObject2;
      localObject4 = ((TreeMap)localObject3).keySet().iterator();
      for (;;)
      {
        localObject2 = localObject3;
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localObject2 = ((Iterator)localObject4).next();
        localObject5 = (UinInfo)((TreeMap)localObject3).get(localObject2);
        if (localObject5 != null) {
          util.LOGI(localObject2 + " is uin: " + ((UinInfo)localObject5)._uin, "");
        }
      }
      util.LOGI("tree is null", "");
      return null;
      localObject4 = new SecretKeySpec(t.z, "DESede");
      localObject3 = Cipher.getInstance("DESede");
      ((Cipher)localObject3).init(2, (Key)localObject4);
      Object localObject2 = new ByteArrayInputStream((byte[])localObject2);
      localObject3 = new ObjectInputStream(new CipherInputStream((InputStream)localObject2, (Cipher)localObject3));
      localObject4 = (TreeMap)((ObjectInputStream)localObject3).readObject();
      if (localObject4 != null)
      {
        ((ObjectInputStream)localObject3).close();
        ((ByteArrayInputStream)localObject2).close();
        return localObject4;
        util.LOGI("dbdata is null", "");
      }
    }
  }
  
  /* Error */
  public static byte[] b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iconst_0
    //   4: invokestatic 278	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   7: astore 5
    //   9: aload_1
    //   10: ldc 58
    //   12: invokevirtual 64	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifeq +175 -> 190
    //   18: getstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   21: ifnonnull +17 -> 38
    //   24: new 66	oicq/wlogin_sdk/request/b
    //   27: dup
    //   28: aload_0
    //   29: aload_1
    //   30: aconst_null
    //   31: iconst_1
    //   32: invokespecial 69	oicq/wlogin_sdk/request/b:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   35: putstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   38: getstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   41: invokevirtual 281	oicq/wlogin_sdk/request/b:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   44: astore_3
    //   45: new 75	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   52: ldc_w 283
    //   55: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_3
    //   59: invokevirtual 286	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   62: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: ldc 140
    //   70: invokestatic 155	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_3
    //   74: new 75	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   81: ldc_w 288
    //   84: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_1
    //   88: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc_w 290
    //   94: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: aconst_null
    //   101: invokevirtual 294	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   104: astore_0
    //   105: aload 5
    //   107: astore 4
    //   109: aload_0
    //   110: invokeinterface 297 1 0
    //   115: ifeq +23 -> 138
    //   118: aload 5
    //   120: astore 4
    //   122: aload_0
    //   123: iconst_0
    //   124: invokeinterface 301 2 0
    //   129: ifle +9 -> 138
    //   132: iconst_1
    //   133: invokestatic 278	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   136: astore 4
    //   138: aload_0
    //   139: ifnull +18 -> 157
    //   142: aload_0
    //   143: invokeinterface 135 1 0
    //   148: ifne +9 -> 157
    //   151: aload_0
    //   152: invokeinterface 138 1 0
    //   157: aload 4
    //   159: invokevirtual 304	java/lang/Boolean:booleanValue	()Z
    //   162: istore_2
    //   163: iload_2
    //   164: ifne +56 -> 220
    //   167: aload_0
    //   168: ifnull +18 -> 186
    //   171: aload_0
    //   172: invokeinterface 135 1 0
    //   177: ifne +9 -> 186
    //   180: aload_0
    //   181: invokeinterface 138 1 0
    //   186: aconst_null
    //   187: astore_1
    //   188: aload_1
    //   189: areturn
    //   190: getstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   193: ifnonnull +17 -> 210
    //   196: new 66	oicq/wlogin_sdk/request/b
    //   199: dup
    //   200: aload_0
    //   201: aload_1
    //   202: aconst_null
    //   203: iconst_1
    //   204: invokespecial 69	oicq/wlogin_sdk/request/b:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   207: putstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   210: getstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   213: invokevirtual 281	oicq/wlogin_sdk/request/b:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   216: astore_3
    //   217: goto -172 -> 45
    //   220: aload_3
    //   221: aload_1
    //   222: iconst_1
    //   223: anewarray 60	java/lang/String
    //   226: dup
    //   227: iconst_0
    //   228: aload_1
    //   229: aastore
    //   230: ldc 100
    //   232: aconst_null
    //   233: aconst_null
    //   234: aconst_null
    //   235: aconst_null
    //   236: invokevirtual 104	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   239: astore_3
    //   240: aload_3
    //   241: astore_0
    //   242: aload_0
    //   243: ifnonnull +24 -> 267
    //   246: aload_0
    //   247: ifnull +18 -> 265
    //   250: aload_0
    //   251: invokeinterface 135 1 0
    //   256: ifne +9 -> 265
    //   259: aload_0
    //   260: invokeinterface 138 1 0
    //   265: aconst_null
    //   266: areturn
    //   267: aload_0
    //   268: astore_3
    //   269: aload_0
    //   270: invokeinterface 307 1 0
    //   275: ifeq +50 -> 325
    //   278: aload_0
    //   279: astore_3
    //   280: aload_0
    //   281: iconst_0
    //   282: invokeinterface 311 2 0
    //   287: astore 4
    //   289: aload_0
    //   290: astore_3
    //   291: aload_0
    //   292: invokeinterface 138 1 0
    //   297: aload 4
    //   299: astore_1
    //   300: aload_0
    //   301: ifnull -113 -> 188
    //   304: aload 4
    //   306: astore_1
    //   307: aload_0
    //   308: invokeinterface 135 1 0
    //   313: ifne -125 -> 188
    //   316: aload_0
    //   317: invokeinterface 138 1 0
    //   322: aload 4
    //   324: areturn
    //   325: aload_0
    //   326: astore_3
    //   327: aload_0
    //   328: invokeinterface 138 1 0
    //   333: aload_0
    //   334: ifnull +18 -> 352
    //   337: aload_0
    //   338: invokeinterface 135 1 0
    //   343: ifne +9 -> 352
    //   346: aload_0
    //   347: invokeinterface 138 1 0
    //   352: aconst_null
    //   353: areturn
    //   354: astore 4
    //   356: aconst_null
    //   357: astore_0
    //   358: aload_0
    //   359: astore_3
    //   360: aload_1
    //   361: ldc 58
    //   363: invokevirtual 64	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   366: ifeq +39 -> 405
    //   369: aload_0
    //   370: astore_3
    //   371: aconst_null
    //   372: putstatic 30	oicq/wlogin_sdk/request/c:g	Loicq/wlogin_sdk/request/b;
    //   375: aload_0
    //   376: astore_3
    //   377: aload 4
    //   379: ldc 140
    //   381: invokestatic 146	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   384: aload_0
    //   385: ifnull +18 -> 403
    //   388: aload_0
    //   389: invokeinterface 135 1 0
    //   394: ifne +9 -> 403
    //   397: aload_0
    //   398: invokeinterface 138 1 0
    //   403: aconst_null
    //   404: areturn
    //   405: aload_0
    //   406: astore_3
    //   407: aconst_null
    //   408: putstatic 32	oicq/wlogin_sdk/request/c:h	Loicq/wlogin_sdk/request/b;
    //   411: goto -36 -> 375
    //   414: astore_0
    //   415: aload_3
    //   416: astore_1
    //   417: aload_1
    //   418: ifnull +18 -> 436
    //   421: aload_1
    //   422: invokeinterface 135 1 0
    //   427: ifne +9 -> 436
    //   430: aload_1
    //   431: invokeinterface 138 1 0
    //   436: aload_0
    //   437: athrow
    //   438: astore_0
    //   439: aload 4
    //   441: astore_1
    //   442: goto -25 -> 417
    //   445: astore_3
    //   446: aload_0
    //   447: astore_1
    //   448: aload_3
    //   449: astore_0
    //   450: goto -33 -> 417
    //   453: astore 4
    //   455: goto -97 -> 358
    //   458: astore 4
    //   460: goto -102 -> 358
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	463	0	paramContext	Context
    //   0	463	1	paramString	String
    //   162	2	2	bool	boolean
    //   44	372	3	localObject1	Object
    //   445	4	3	localObject2	Object
    //   1	322	4	localObject3	Object
    //   354	86	4	localException1	Exception
    //   453	1	4	localException2	Exception
    //   458	1	4	localException3	Exception
    //   7	112	5	localBoolean	java.lang.Boolean
    // Exception table:
    //   from	to	target	type
    //   9	38	354	java/lang/Exception
    //   38	45	354	java/lang/Exception
    //   45	105	354	java/lang/Exception
    //   190	210	354	java/lang/Exception
    //   210	217	354	java/lang/Exception
    //   269	278	414	finally
    //   280	289	414	finally
    //   291	297	414	finally
    //   327	333	414	finally
    //   360	369	414	finally
    //   371	375	414	finally
    //   377	384	414	finally
    //   407	411	414	finally
    //   9	38	438	finally
    //   38	45	438	finally
    //   45	105	438	finally
    //   190	210	438	finally
    //   210	217	438	finally
    //   109	118	445	finally
    //   122	138	445	finally
    //   142	157	445	finally
    //   157	163	445	finally
    //   220	240	445	finally
    //   109	118	453	java/lang/Exception
    //   122	138	453	java/lang/Exception
    //   142	157	453	java/lang/Exception
    //   157	163	453	java/lang/Exception
    //   220	240	453	java/lang/Exception
    //   269	278	458	java/lang/Exception
    //   280	289	458	java/lang/Exception
    //   291	297	458	java/lang/Exception
    //   327	333	458	java/lang/Exception
  }
  
  private static TreeMap c(Context paramContext, String paramString)
  {
    try
    {
      localObject1 = new SecretKeySpec(t.z, "DESede");
      Object localObject3 = Cipher.getInstance("DESede");
      ((Cipher)localObject3).init(2, (Key)localObject1);
      localObject1 = new ObjectInputStream(new CipherInputStream(paramContext.openFileInput(paramString), (Cipher)localObject3));
      if ((localThrowable2 instanceof FileNotFoundException)) {
        break label131;
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
          break label1253;
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
        label131:
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
      label295:
      label330:
      try
      {
        arrayOfByte2 = new byte[256];
        int k = arrayOfByte2.length;
        paramString = paramContext.openFileInput(paramString);
        localObject5 = paramContext.openFileOutput("tmp_tk_file", 0);
        m = paramString.read(arrayOfByte2, 40, k - 40);
        if (m <= 0) {
          break label1217;
        }
        i = 40 + m;
        if (i >= arrayOfByte2.length) {
          break label1284;
        }
        arrayOfByte2[i] = 0;
        i += 1;
        continue;
        if (i < 0) {
          break label1289;
        }
        arrayOfByte3 = new String("WloginAllSigInfo").getBytes();
        i = a(arrayOfByte2, i, arrayOfByte3);
        if (i >= 0) {
          break;
        }
      }
      catch (Exception paramString) {}
      if (i < 0) {
        break label1294;
      }
      arrayOfByte3 = new String("WloginSigInfo").getBytes();
      i = a(arrayOfByte2, i, arrayOfByte3);
      if (i >= 0) {
        break label672;
      }
      break label1294;
      label365:
      if (i < 0) {
        break label1299;
      }
      arrayOfByte3 = new String("WloginSimpleInfo").getBytes();
      i = a(arrayOfByte2, i, arrayOfByte3);
      if (i >= 0) {
        break label843;
      }
      break label1299;
      label400:
      if (i >= 0)
      {
        arrayOfByte3 = new String("UinInfo").getBytes();
        i = a(arrayOfByte2, i, arrayOfByte3);
        if (i >= 0) {
          break label1030;
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
        break label295;
      }
      i = j;
      if (arrayOfByte2[(j + 0)] != -127) {
        break label295;
      }
      i = j;
      if (arrayOfByte2[(j + 1)] != 64) {
        break label295;
      }
      i = j;
      if (arrayOfByte2[(j + 2)] != 1) {
        break label295;
      }
      i = j;
      if (arrayOfByte2[(j + 3)] != 111) {
        break label295;
      }
      i = j;
      if (arrayOfByte2[(j + 4)] != -111) {
        break label295;
      }
      i = j;
      if (arrayOfByte2[(j + 5)] != -44) {
        break label295;
      }
      i = j;
      if (arrayOfByte2[(j + 6)] != 26) {
        break label295;
      }
      i = j;
      if (arrayOfByte2[(j + 7)] != -101) {
        break label295;
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
      break label295;
      label672:
      j = i + arrayOfByte3.length;
      i = j;
      if (j + 8 > arrayOfByte2.length) {
        break label330;
      }
      i = j;
      if (arrayOfByte2[(j + 0)] != 0) {
        break label330;
      }
      i = j;
      if (arrayOfByte2[(j + 1)] != 0) {
        break label330;
      }
      i = j;
      if (arrayOfByte2[(j + 2)] != 0) {
        break label330;
      }
      i = j;
      if (arrayOfByte2[(j + 3)] != 0) {
        break label330;
      }
      i = j;
      if (arrayOfByte2[(j + 4)] != 0) {
        break label330;
      }
      i = j;
      if (arrayOfByte2[(j + 5)] != 0) {
        break label330;
      }
      i = j;
      if (arrayOfByte2[(j + 6)] != 0) {
        break label330;
      }
      i = j;
      if (arrayOfByte2[(j + 7)] != 0) {
        break label330;
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
      break label330;
      label843:
      j = i + arrayOfByte3.length;
      i = j;
      if (j + 8 > arrayOfByte2.length) {
        break label365;
      }
      i = j;
      if (arrayOfByte2[(j + 0)] != 57) {
        break label365;
      }
      i = j;
      if (arrayOfByte2[(j + 1)] != -69) {
        break label365;
      }
      i = j;
      if (arrayOfByte2[(j + 2)] != -84) {
        break label365;
      }
      i = j;
      if (arrayOfByte2[(j + 3)] != 110) {
        break label365;
      }
      i = j;
      if (arrayOfByte2[(j + 4)] != -46) {
        break label365;
      }
      i = j;
      if (arrayOfByte2[(j + 5)] != 98) {
        break label365;
      }
      i = j;
      if (arrayOfByte2[(j + 6)] != -31) {
        break label365;
      }
      i = j;
      if (arrayOfByte2[(j + 7)] != -113) {
        break label365;
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
      break label365;
      label1030:
      j = i + arrayOfByte3.length;
      i = j;
      if (j + 8 > arrayOfByte2.length) {
        break label400;
      }
      i = j;
      if (arrayOfByte2[(j + 0)] != -118) {
        break label400;
      }
      i = j;
      if (arrayOfByte2[(j + 1)] != -23) {
        break label400;
      }
      i = j;
      if (arrayOfByte2[(j + 2)] != -128) {
        break label400;
      }
      i = j;
      if (arrayOfByte2[(j + 3)] != -19) {
        break label400;
      }
      i = j;
      if (arrayOfByte2[(j + 4)] != -26) {
        break label400;
      }
      i = j;
      if (arrayOfByte2[(j + 5)] != 99) {
        break label400;
      }
      i = j;
      if (arrayOfByte2[(j + 6)] != 41) {
        break label400;
      }
      i = j;
      if (arrayOfByte2[(j + 7)] != 14) {
        break label400;
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
      break label400;
      label1217:
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
          label1253:
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
  
  public int a(long paramLong1, long paramLong2)
  {
    for (;;)
    {
      try
      {
        util.LOGI("clear_da2 " + paramLong2, "" + paramLong1);
        WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)this.c.get(Long.valueOf(paramLong1));
        if (localWloginAllSigInfo == null)
        {
          i = -1;
          return i;
        }
        ??? = (WloginSigInfo)localWloginAllSigInfo._tk_map.get(Long.valueOf(paramLong2));
        if (??? != null)
        {
          if ((((WloginSigInfo)???)._DA2 == null) || (((WloginSigInfo)???)._DA2.length == 0)) {
            break label220;
          }
          ((WloginSigInfo)???)._DA2 = new byte[0];
        }
        i = localWloginAllSigInfo.put_da2(paramLong2, new byte[0]);
        if (this.a != null)
        {
          synchronized (e)
          {
            TreeMap localTreeMap = a(this.a, "tk_file");
            if (localTreeMap != null)
            {
              localTreeMap.put(Long.valueOf(paramLong1), localWloginAllSigInfo);
              i = a(localTreeMap, "tk_file");
              this.c = localTreeMap;
            }
          }
          continue;
        }
      }
      finally {}
      continue;
      label220:
      int i = 0;
    }
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)this.c.get(Long.valueOf(paramLong1));
      int i;
      if (localWloginAllSigInfo == null) {
        i = -1;
      }
      for (;;)
      {
        return i;
        i = localWloginAllSigInfo.put_siginfo(paramLong2, paramLong3, paramLong4, paramArrayOfByte1, paramArrayOfByte2);
        if (this.a != null) {
          synchronized (e)
          {
            paramArrayOfByte2 = a(this.a, "tk_file");
            paramArrayOfByte1 = paramArrayOfByte2;
            if (paramArrayOfByte2 == null) {
              paramArrayOfByte1 = new TreeMap();
            }
            paramArrayOfByte1.put(Long.valueOf(paramLong1), localWloginAllSigInfo.get_clone());
            a(paramArrayOfByte1, "tk_file");
          }
        }
      }
    }
    finally {}
  }
  
  public int a(long paramLong1, long paramLong2, byte[] arg5)
  {
    label210:
    label218:
    for (;;)
    {
      try
      {
        Object localObject3 = (WloginAllSigInfo)this.c.get(Long.valueOf(paramLong1));
        if (localObject3 == null)
        {
          i = -1;
          return i;
        }
        Object localObject1 = (WloginSigInfo)((WloginAllSigInfo)localObject3)._tk_map.get(Long.valueOf(paramLong2));
        if ((localObject1 == null) || (((WloginSigInfo)localObject1)._randseed == null)) {
          break label210;
        }
        localObject1 = (byte[])((WloginSigInfo)localObject1)._randseed.clone();
        int i = ((WloginAllSigInfo)localObject3).put_randseed(paramLong2, ???);
        if (this.a != null)
        {
          synchronized (e)
          {
            TreeMap localTreeMap = a(this.a, "tk_file");
            if (localTreeMap != null)
            {
              localTreeMap.put(Long.valueOf(paramLong1), ((WloginAllSigInfo)localObject3).get_clone());
              i = a(localTreeMap, "tk_file");
              if (i == 0) {
                break label218;
              }
              localObject3 = (WloginSigInfo)((WloginAllSigInfo)localObject3)._tk_map.get(Long.valueOf(paramLong2));
              if (localObject3 == null) {
                break label218;
              }
              ((WloginSigInfo)localObject3)._randseed = ((byte[])((byte[])localObject1).clone());
              break label218;
            }
          }
          continue;
        }
      }
      finally {}
      continue;
      byte[] arrayOfByte = new byte[0];
    }
  }
  
  public int a(long paramLong1, long paramLong2, byte[][] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[][] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, byte[] paramArrayOfByte11, byte[] paramArrayOfByte12, byte[] paramArrayOfByte13, byte[] paramArrayOfByte14, byte[] paramArrayOfByte15, byte[] paramArrayOfByte16, byte[] paramArrayOfByte17, byte[] paramArrayOfByte18, byte[][] paramArrayOfByte19, long[] paramArrayOfLong, int paramInt)
  {
    int i = 0;
    label789:
    label796:
    label829:
    label836:
    for (;;)
    {
      try
      {
        if (this.a != null) {}
        synchronized (e)
        {
          util.LOGI("before put_siginfo", "" + paramLong1);
          TreeMap localTreeMap = a(this.a, "tk_file");
          if (localTreeMap != null) {
            break label836;
          }
          localTreeMap = new TreeMap();
          localObject2 = (WloginAllSigInfo)this.c.get(Long.valueOf(paramLong1));
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label829;
          }
          localObject2 = (WloginAllSigInfo)localTreeMap.get(Long.valueOf(paramLong1));
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label829;
          }
          localObject5 = new WloginAllSigInfo();
          localObject7 = new byte[0];
          localObject6 = new byte[0];
          byte[] arrayOfByte = new byte[0];
          localObject3 = new byte[0];
          localObject4 = new byte[0];
          Object localObject9 = (WloginSigInfo)((WloginAllSigInfo)localObject5)._tk_map.get(Long.valueOf(paramLong2));
          if (localObject9 == null) {
            break label796;
          }
          localObject2 = localObject6;
          localObject1 = localObject7;
          if (((WloginSigInfo)localObject9)._en_A1 != null)
          {
            localObject1 = (byte[])((WloginSigInfo)localObject9)._en_A1.clone();
            if (((WloginSigInfo)localObject9)._noPicSig == null) {
              break label789;
            }
            localObject2 = (byte[])((WloginSigInfo)localObject9)._noPicSig.clone();
          }
          if (((WloginSigInfo)localObject9)._G != null) {
            arrayOfByte = (byte[])((WloginSigInfo)localObject9)._G.clone();
          }
          if (((WloginSigInfo)localObject9)._dpwd != null) {
            localObject3 = (byte[])((WloginSigInfo)localObject9)._dpwd.clone();
          }
          if (((WloginSigInfo)localObject9)._randseed != null)
          {
            localObject4 = (byte[])((WloginSigInfo)localObject9)._randseed.clone();
            localObject8 = ((WloginSigInfo)localObject9)._psKey;
            localObject9 = ((WloginSigInfo)localObject9)._pt4Token;
            localObject6 = localObject4;
            localObject7 = localObject3;
            localObject4 = localObject1;
            localObject3 = localObject2;
            localObject2 = localObject7;
            localObject1 = localObject6;
            localObject7 = localObject8;
            localObject6 = localObject9;
            HashMap localHashMap1;
            HashMap localHashMap2;
            if ((paramArrayOfByte19[6] != null) && (paramArrayOfByte19[6].length > 2))
            {
              localObject8 = new HashMap();
              localObject9 = new HashMap();
              localHashMap1 = new HashMap();
              localHashMap2 = new HashMap();
              Ticket.parsePsBuf((byte[])localObject7, paramLong5, (Map)localObject8, (Map)localObject9);
              Ticket.parsePsBuf((byte[])localObject6, paramLong5, localHashMap1, localHashMap2);
              Ticket.parseSvrPs(paramArrayOfByte19[6], paramLong5, (Map)localObject8, (Map)localObject9, localHashMap1, localHashMap2);
            }
            try
            {
              paramArrayOfByte19[6] = Ticket.packPsBuf((Map)localObject8, paramLong5, (Map)localObject9);
              paramArrayOfByte19[12] = Ticket.packPsBuf(localHashMap1, paramLong5, localHashMap2);
              ((WloginAllSigInfo)localObject5).put_simpleinfo(paramLong1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6);
              ((WloginAllSigInfo)localObject5).put_siginfo(paramLong3, paramLong4, paramLong5, paramLong6, paramLong7, paramArrayOfByte7, paramArrayOfByte8, paramArrayOfByte9, paramArrayOfByte10, paramArrayOfByte11, paramArrayOfByte12, paramArrayOfByte13, paramArrayOfByte14, paramArrayOfByte15, paramArrayOfByte16, paramArrayOfByte17, paramArrayOfByte18, paramArrayOfByte19, paramArrayOfLong, paramInt);
              ((WloginAllSigInfo)localObject5).put_siginfo(paramLong2, paramArrayOfByte1, paramLong5);
              localTreeMap.put(Long.valueOf(paramLong1), ((WloginAllSigInfo)localObject5).get_clone());
              i = a(localTreeMap, "tk_file");
              if (i != 0)
              {
                paramArrayOfByte1 = (WloginSigInfo)((WloginAllSigInfo)localObject5)._tk_map.get(Long.valueOf(paramLong2));
                if (paramArrayOfByte1 != null)
                {
                  paramArrayOfByte1._en_A1 = ((byte[])((byte[])localObject4).clone());
                  paramArrayOfByte1._noPicSig = ((byte[])((byte[])localObject3).clone());
                  paramArrayOfByte1._G = ((byte[])arrayOfByte.clone());
                  paramArrayOfByte1._dpwd = ((byte[])((byte[])localObject2).clone());
                  paramArrayOfByte1._randseed = ((byte[])((byte[])localObject1).clone());
                }
              }
              this.c.put(Long.valueOf(paramLong1), ((WloginAllSigInfo)localObject5).get_clone());
              util.LOGI("after put_siginfo", "" + paramLong1);
            }
            catch (BufferOverflowException paramArrayOfByte1)
            {
              util.LOGI("map size " + ((Map)localObject8).size() + "is too large", "" + paramLong1);
              a(Long.valueOf(paramLong1));
              i = -1023;
              continue;
            }
            return i;
          }
        }
        continue;
      }
      finally {}
      Object localObject2 = localObject6;
      continue;
      Object localObject8 = new byte[0];
      Object localObject1 = localObject4;
      localObject2 = localObject3;
      Object localObject3 = localObject6;
      Object localObject4 = localObject7;
      Object localObject7 = new byte[0];
      Object localObject6 = localObject8;
      continue;
      Object localObject5 = localObject1;
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
  
  public List<WloginLoginInfo> a(boolean paramBoolean)
  {
    label320:
    for (;;)
    {
      try
      {
        ArrayList localArrayList = new ArrayList();
        if (this.a == null) {
          break label320;
        }
        TreeMap localTreeMap = a(this.a, "tk_file");
        if (localTreeMap == null) {
          return localArrayList;
        }
        Iterator localIterator1 = localTreeMap.keySet().iterator();
        if (!localIterator1.hasNext()) {
          break label320;
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
            i = WloginLoginInfo.TYPE_LOACL;
            localArrayList.add(new WloginLoginInfo((String)localObject3, l1, l2, str, l3, i, localWloginSigInfo._login_bitmap));
          }
        }
        else
        {
          continue;
        }
        int i = WloginLoginInfo.TYPE_REMOTE;
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
    //   7: getfield 46	oicq/wlogin_sdk/request/c:d	Ljava/util/TreeMap;
    //   10: aload_1
    //   11: invokevirtual 223	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: checkcast 241	oicq/wlogin_sdk/request/UinInfo
    //   17: astore_3
    //   18: aload_3
    //   19: ifnull +60 -> 79
    //   22: new 75	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 538
    //   32: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc_w 540
    //   42: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_3
    //   46: getfield 247	oicq/wlogin_sdk/request/UinInfo:_uin	Ljava/lang/Long;
    //   49: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   52: ldc_w 542
    //   55: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_3
    //   59: invokevirtual 545	oicq/wlogin_sdk/request/UinInfo:getHasPassword	()Z
    //   62: invokevirtual 548	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   65: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: ldc 140
    //   70: invokestatic 155	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_3
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: areturn
    //   79: aload_0
    //   80: getfield 48	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   83: ifnonnull +8 -> 91
    //   86: aconst_null
    //   87: astore_1
    //   88: goto -13 -> 75
    //   91: aload_0
    //   92: getfield 48	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   95: ldc 50
    //   97: invokestatic 53	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/TreeMap;
    //   100: astore_3
    //   101: aload_3
    //   102: ifnonnull +8 -> 110
    //   105: aconst_null
    //   106: astore_1
    //   107: goto -32 -> 75
    //   110: aload_3
    //   111: aload_1
    //   112: invokevirtual 223	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   115: checkcast 241	oicq/wlogin_sdk/request/UinInfo
    //   118: astore_3
    //   119: aload_3
    //   120: ifnonnull +8 -> 128
    //   123: aconst_null
    //   124: astore_1
    //   125: goto -50 -> 75
    //   128: aload_0
    //   129: getfield 46	oicq/wlogin_sdk/request/c:d	Ljava/util/TreeMap;
    //   132: aload_1
    //   133: aload_3
    //   134: invokevirtual 397	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   137: pop
    //   138: new 75	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   145: ldc_w 550
    //   148: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_1
    //   152: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc_w 540
    //   158: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_3
    //   162: getfield 247	oicq/wlogin_sdk/request/UinInfo:_uin	Ljava/lang/Long;
    //   165: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   168: ldc_w 542
    //   171: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_3
    //   175: invokevirtual 545	oicq/wlogin_sdk/request/UinInfo:getHasPassword	()Z
    //   178: invokevirtual 548	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   181: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: ldc 140
    //   186: invokestatic 155	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: aload_3
    //   190: astore_1
    //   191: goto -116 -> 75
    //   194: astore_1
    //   195: aload_0
    //   196: monitorexit
    //   197: aload_1
    //   198: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	c
    //   0	199	1	paramString	String
    //   0	199	2	paramBoolean	boolean
    //   17	173	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	18	194	finally
    //   22	73	194	finally
    //   79	86	194	finally
    //   91	101	194	finally
    //   110	119	194	finally
    //   128	189	194	finally
  }
  
  /* Error */
  public WloginAllSigInfo a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 553
    //   5: new 75	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   12: ldc 140
    //   14: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: lload_1
    //   18: invokevirtual 379	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   21: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 155	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload_0
    //   28: getfield 44	oicq/wlogin_sdk/request/c:c	Ljava/util/TreeMap;
    //   31: lload_1
    //   32: invokestatic 384	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   35: invokevirtual 223	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast 225	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   41: astore_3
    //   42: aload_3
    //   43: ifnull +15 -> 58
    //   46: ldc_w 555
    //   49: ldc 140
    //   51: invokestatic 155	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_3
    //   57: areturn
    //   58: aload_0
    //   59: getfield 48	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   62: ifnonnull +8 -> 70
    //   65: aconst_null
    //   66: astore_3
    //   67: goto -13 -> 54
    //   70: aload_0
    //   71: getfield 48	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   74: ldc 58
    //   76: invokestatic 53	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/TreeMap;
    //   79: astore_3
    //   80: aload_3
    //   81: ifnonnull +8 -> 89
    //   84: aconst_null
    //   85: astore_3
    //   86: goto -32 -> 54
    //   89: aload_3
    //   90: lload_1
    //   91: invokestatic 384	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   94: invokevirtual 223	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   97: checkcast 225	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   100: astore_3
    //   101: aload_3
    //   102: ifnonnull +8 -> 110
    //   105: aconst_null
    //   106: astore_3
    //   107: goto -53 -> 54
    //   110: ldc_w 557
    //   113: ldc 140
    //   115: invokestatic 155	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload_0
    //   119: getfield 44	oicq/wlogin_sdk/request/c:c	Ljava/util/TreeMap;
    //   122: lload_1
    //   123: invokestatic 384	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   126: aload_3
    //   127: invokevirtual 397	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   130: pop
    //   131: goto -77 -> 54
    //   134: astore_3
    //   135: aload_0
    //   136: monitorexit
    //   137: aload_3
    //   138: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	c
    //   0	139	1	paramLong	long
    //   41	86	3	localObject1	Object
    //   134	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	42	134	finally
    //   46	54	134	finally
    //   58	65	134	finally
    //   70	80	134	finally
    //   89	101	134	finally
    //   110	131	134	finally
  }
  
  public void a()
  {
    try
    {
      util.LOGI("refresh_all_siginfo ...", "");
      this.c = a(this.a, "tk_file");
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
  
  /* Error */
  public void a(Long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 44	oicq/wlogin_sdk/request/c:c	Ljava/util/TreeMap;
    //   6: aload_1
    //   7: invokevirtual 562	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: pop
    //   11: aload_0
    //   12: getfield 48	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   15: ifnull +25 -> 40
    //   18: getstatic 26	oicq/wlogin_sdk/request/c:e	Ljava/lang/Object;
    //   21: astore_2
    //   22: aload_2
    //   23: monitorenter
    //   24: aload_0
    //   25: getfield 48	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   28: ldc 58
    //   30: invokestatic 53	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/TreeMap;
    //   33: astore_3
    //   34: aload_3
    //   35: ifnonnull +8 -> 43
    //   38: aload_2
    //   39: monitorexit
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    //   43: aload_3
    //   44: aload_1
    //   45: invokevirtual 562	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   48: pop
    //   49: aload_0
    //   50: aload_3
    //   51: ldc 58
    //   53: invokevirtual 400	oicq/wlogin_sdk/request/c:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   56: pop
    //   57: aload_2
    //   58: monitorexit
    //   59: goto -19 -> 40
    //   62: astore_1
    //   63: aload_2
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	c
    //   0	72	1	paramLong	Long
    //   33	18	3	localTreeMap	TreeMap
    // Exception table:
    //   from	to	target	type
    //   24	34	62	finally
    //   38	40	62	finally
    //   43	59	62	finally
    //   63	65	62	finally
    //   2	24	67	finally
    //   65	67	67	finally
  }
  
  public void a(Long paramLong1, Long paramLong2)
  {
    for (;;)
    {
      TreeMap localTreeMap;
      try
      {
        util.LOGI("clear_sig uin=" + paramLong1, "");
        ??? = (WloginAllSigInfo)this.c.get(paramLong1);
        if (??? != null)
        {
          ((WloginAllSigInfo)???)._tk_map.remove(paramLong2);
          util.LOGI("uin " + paramLong1 + " appid " + paramLong2 + " sig has been cleared");
        }
        if (this.a != null) {}
        synchronized (e)
        {
          localTreeMap = a(this.a, "tk_file");
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
    //   3: getfield 46	oicq/wlogin_sdk/request/c:d	Ljava/util/TreeMap;
    //   6: aload_1
    //   7: invokevirtual 562	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: pop
    //   11: aload_0
    //   12: getfield 48	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   15: ifnull +52 -> 67
    //   18: getstatic 28	oicq/wlogin_sdk/request/c:f	Ljava/lang/Object;
    //   21: astore 4
    //   23: aload 4
    //   25: monitorenter
    //   26: aload_0
    //   27: getfield 48	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   30: ldc 50
    //   32: invokestatic 53	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/TreeMap;
    //   35: astore_3
    //   36: aload_3
    //   37: astore_2
    //   38: aload_3
    //   39: ifnonnull +11 -> 50
    //   42: new 41	java/util/TreeMap
    //   45: dup
    //   46: invokespecial 42	java/util/TreeMap:<init>	()V
    //   49: astore_2
    //   50: aload_2
    //   51: aload_1
    //   52: invokevirtual 562	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: pop
    //   56: aload_0
    //   57: aload_2
    //   58: ldc 50
    //   60: invokevirtual 400	oicq/wlogin_sdk/request/c:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   63: pop
    //   64: aload 4
    //   66: monitorexit
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //   70: astore_1
    //   71: aload 4
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	c
    //   0	81	1	paramString	String
    //   37	21	2	localTreeMap1	TreeMap
    //   35	4	3	localTreeMap2	TreeMap
    // Exception table:
    //   from	to	target	type
    //   26	36	70	finally
    //   42	50	70	finally
    //   50	67	70	finally
    //   71	74	70	finally
    //   2	26	76	finally
    //   74	76	76	finally
  }
  
  /* Error */
  public void a(String paramString, Long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 75	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 574
    //   12: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_1
    //   16: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc_w 576
    //   22: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_2
    //   26: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: new 75	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   39: ldc 140
    //   41: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_2
    //   45: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 155	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: aload_2
    //   56: invokevirtual 492	oicq/wlogin_sdk/request/c:b	(Ljava/lang/Long;)Ljava/lang/String;
    //   59: astore 5
    //   61: aload 5
    //   63: ifnull +13 -> 76
    //   66: aload_0
    //   67: getfield 46	oicq/wlogin_sdk/request/c:d	Ljava/util/TreeMap;
    //   70: aload 5
    //   72: invokevirtual 562	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   75: pop
    //   76: new 241	oicq/wlogin_sdk/request/UinInfo
    //   79: dup
    //   80: aload_2
    //   81: iload_3
    //   82: invokespecial 579	oicq/wlogin_sdk/request/UinInfo:<init>	(Ljava/lang/Long;Z)V
    //   85: astore 7
    //   87: aload_0
    //   88: getfield 46	oicq/wlogin_sdk/request/c:d	Ljava/util/TreeMap;
    //   91: aload_1
    //   92: aload 7
    //   94: invokevirtual 397	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   97: pop
    //   98: aload_0
    //   99: getfield 48	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   102: ifnull +69 -> 171
    //   105: getstatic 28	oicq/wlogin_sdk/request/c:f	Ljava/lang/Object;
    //   108: astore 6
    //   110: aload 6
    //   112: monitorenter
    //   113: aload_0
    //   114: getfield 48	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   117: ldc 50
    //   119: invokestatic 53	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/TreeMap;
    //   122: astore 4
    //   124: aload 4
    //   126: astore_2
    //   127: aload 4
    //   129: ifnonnull +11 -> 140
    //   132: new 41	java/util/TreeMap
    //   135: dup
    //   136: invokespecial 42	java/util/TreeMap:<init>	()V
    //   139: astore_2
    //   140: aload 5
    //   142: ifnull +10 -> 152
    //   145: aload_2
    //   146: aload 5
    //   148: invokevirtual 562	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   151: pop
    //   152: aload_2
    //   153: aload_1
    //   154: aload 7
    //   156: invokevirtual 397	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   159: pop
    //   160: aload_0
    //   161: aload_2
    //   162: ldc 50
    //   164: invokevirtual 400	oicq/wlogin_sdk/request/c:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   167: pop
    //   168: aload 6
    //   170: monitorexit
    //   171: aload_0
    //   172: monitorexit
    //   173: return
    //   174: astore_1
    //   175: aload 6
    //   177: monitorexit
    //   178: aload_1
    //   179: athrow
    //   180: astore_1
    //   181: aload_0
    //   182: monitorexit
    //   183: aload_1
    //   184: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	c
    //   0	185	1	paramString	String
    //   0	185	2	paramLong	Long
    //   0	185	3	paramBoolean	boolean
    //   122	6	4	localTreeMap	TreeMap
    //   59	88	5	str	String
    //   85	70	7	localUinInfo	UinInfo
    // Exception table:
    //   from	to	target	type
    //   113	124	174	finally
    //   132	140	174	finally
    //   145	152	174	finally
    //   152	171	174	finally
    //   175	178	174	finally
    //   2	61	180	finally
    //   66	76	180	finally
    //   76	113	180	finally
    //   178	180	180	finally
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
      paramTreeMap = cryptor.encrypt(paramTreeMap, 0, paramTreeMap.length, t.z);
      i = a(this.a, paramString, paramTreeMap);
      localObjectOutputStream.close();
      localByteArrayOutputStream.close();
      return i;
    }
    catch (Throwable paramTreeMap)
    {
      for (;;)
      {
        util.printThrowable(paramTreeMap, "");
        int i = -1022;
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
    //   3: getfield 46	oicq/wlogin_sdk/request/c:d	Ljava/util/TreeMap;
    //   6: invokevirtual 205	java/util/TreeMap:keySet	()Ljava/util/Set;
    //   9: invokeinterface 211 1 0
    //   14: astore 4
    //   16: aload 4
    //   18: invokeinterface 216 1 0
    //   23: ifeq +52 -> 75
    //   26: aload 4
    //   28: invokeinterface 219 1 0
    //   33: checkcast 60	java/lang/String
    //   36: astore_3
    //   37: aload_0
    //   38: getfield 46	oicq/wlogin_sdk/request/c:d	Ljava/util/TreeMap;
    //   41: aload_3
    //   42: invokevirtual 223	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: checkcast 241	oicq/wlogin_sdk/request/UinInfo
    //   48: astore 5
    //   50: aload 5
    //   52: ifnull -36 -> 16
    //   55: aload 5
    //   57: getfield 247	oicq/wlogin_sdk/request/UinInfo:_uin	Ljava/lang/Long;
    //   60: aload_1
    //   61: invokevirtual 605	java/lang/Long:equals	(Ljava/lang/Object;)Z
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
    //   0	85	0	this	c
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
  public WloginSigInfo b(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 75	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 608
    //   12: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: lload_3
    //   16: invokevirtual 379	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: new 75	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   29: lload_1
    //   30: invokevirtual 379	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   33: ldc 140
    //   35: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 155	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_0
    //   45: lload_1
    //   46: invokevirtual 610	oicq/wlogin_sdk/request/c:a	(J)Loicq/wlogin_sdk/request/WloginAllSigInfo;
    //   49: astore 5
    //   51: aload 5
    //   53: ifnonnull +11 -> 64
    //   56: aconst_null
    //   57: astore 5
    //   59: aload_0
    //   60: monitorexit
    //   61: aload 5
    //   63: areturn
    //   64: new 75	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   71: ldc_w 612
    //   74: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload 5
    //   79: getfield 233	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   82: invokevirtual 201	java/util/TreeMap:size	()I
    //   85: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   88: ldc_w 614
    //   91: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload 5
    //   96: getfield 233	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   99: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: new 75	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   112: lload_1
    //   113: invokevirtual 379	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   116: ldc 140
    //   118: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 155	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload 5
    //   129: getfield 233	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   132: lload_3
    //   133: invokestatic 384	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   136: invokevirtual 223	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   139: checkcast 386	oicq/wlogin_sdk/sharemem/WloginSigInfo
    //   142: astore 5
    //   144: aload 5
    //   146: ifnonnull +9 -> 155
    //   149: aconst_null
    //   150: astore 5
    //   152: goto -93 -> 59
    //   155: new 75	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   162: ldc_w 616
    //   165: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: lload_3
    //   169: invokevirtual 379	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   172: ldc_w 614
    //   175: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload 5
    //   180: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: new 75	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   193: lload_1
    //   194: invokevirtual 379	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   197: ldc 140
    //   199: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 155	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: goto -149 -> 59
    //   211: astore 5
    //   213: aload_0
    //   214: monitorexit
    //   215: aload 5
    //   217: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	c
    //   0	218	1	paramLong1	long
    //   0	218	3	paramLong2	long
    //   49	130	5	localObject1	Object
    //   211	5	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	51	211	finally
    //   64	144	211	finally
    //   155	208	211	finally
  }
  
  /* Error */
  public WloginSimpleInfo b(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 619
    //   5: new 75	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 621
    //   15: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: lload_1
    //   19: invokevirtual 379	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   22: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 624	oicq/wlogin_sdk/tools/util:LOGD	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: lload_1
    //   30: invokevirtual 610	oicq/wlogin_sdk/request/c:a	(J)Loicq/wlogin_sdk/request/WloginAllSigInfo;
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
    //   45: getfield 499	oicq/wlogin_sdk/request/WloginAllSigInfo:_useInfo	Loicq/wlogin_sdk/sharemem/WloginSimpleInfo;
    //   48: invokevirtual 627	oicq/wlogin_sdk/sharemem/WloginSimpleInfo:get_clone	()Loicq/wlogin_sdk/sharemem/WloginSimpleInfo;
    //   51: astore_3
    //   52: goto -12 -> 40
    //   55: astore_3
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_3
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	c
    //   0	60	1	paramLong	long
    //   33	19	3	localObject1	Object
    //   55	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	34	55	finally
    //   44	52	55	finally
  }
  
  /* Error */
  public void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	oicq/wlogin_sdk/request/c:d	Ljava/util/TreeMap;
    //   6: aload_1
    //   7: invokevirtual 562	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: pop
    //   11: new 75	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 629
    //   21: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: ldc 140
    //   33: invokestatic 155	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: getfield 48	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   40: ifnull +25 -> 65
    //   43: getstatic 28	oicq/wlogin_sdk/request/c:f	Ljava/lang/Object;
    //   46: astore_2
    //   47: aload_2
    //   48: monitorenter
    //   49: aload_0
    //   50: getfield 48	oicq/wlogin_sdk/request/c:a	Landroid/content/Context;
    //   53: ldc 50
    //   55: invokestatic 53	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/TreeMap;
    //   58: astore_3
    //   59: aload_3
    //   60: ifnonnull +8 -> 68
    //   63: aload_2
    //   64: monitorexit
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: aload_3
    //   69: aload_1
    //   70: invokevirtual 562	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: pop
    //   74: aload_0
    //   75: aload_3
    //   76: ldc 50
    //   78: invokevirtual 400	oicq/wlogin_sdk/request/c:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   81: pop
    //   82: aload_2
    //   83: monitorexit
    //   84: goto -19 -> 65
    //   87: astore_1
    //   88: aload_2
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	c
    //   0	97	1	paramString	String
    //   58	18	3	localTreeMap	TreeMap
    // Exception table:
    //   from	to	target	type
    //   49	59	87	finally
    //   63	65	87	finally
    //   68	84	87	finally
    //   88	90	87	finally
    //   2	49	92	finally
    //   90	92	92	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.c
 * JD-Core Version:    0.7.0.1
 */