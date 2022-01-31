package oicq.wlogin_sdk.request;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class g
{
  private static Object e = new Object();
  private static Object f = new Object();
  private static c g = null;
  private static c h = null;
  Context a;
  WloginLastLoginInfo b = new WloginLastLoginInfo();
  TreeMap<Long, WloginAllSigInfo> c = new TreeMap();
  TreeMap<String, UinInfo> d = new TreeMap();
  
  public g(Context paramContext)
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
    //   9: getstatic 30	oicq/wlogin_sdk/request/g:g	Loicq/wlogin_sdk/request/c;
    //   12: ifnonnull +17 -> 29
    //   15: new 66	oicq/wlogin_sdk/request/c
    //   18: dup
    //   19: aload_0
    //   20: aload_1
    //   21: aconst_null
    //   22: iconst_1
    //   23: invokespecial 69	oicq/wlogin_sdk/request/c:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   26: putstatic 30	oicq/wlogin_sdk/request/g:g	Loicq/wlogin_sdk/request/c;
    //   29: getstatic 30	oicq/wlogin_sdk/request/g:g	Loicq/wlogin_sdk/request/c;
    //   32: invokevirtual 73	oicq/wlogin_sdk/request/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
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
    //   244: getstatic 32	oicq/wlogin_sdk/request/g:h	Loicq/wlogin_sdk/request/c;
    //   247: ifnonnull +17 -> 264
    //   250: new 66	oicq/wlogin_sdk/request/c
    //   253: dup
    //   254: aload_0
    //   255: aload_1
    //   256: aconst_null
    //   257: iconst_1
    //   258: invokespecial 69	oicq/wlogin_sdk/request/c:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   261: putstatic 32	oicq/wlogin_sdk/request/g:h	Loicq/wlogin_sdk/request/c;
    //   264: getstatic 32	oicq/wlogin_sdk/request/g:h	Loicq/wlogin_sdk/request/c;
    //   267: invokevirtual 73	oicq/wlogin_sdk/request/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
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
    //   295: putstatic 30	oicq/wlogin_sdk/request/g:g	Loicq/wlogin_sdk/request/c;
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
    //   348: putstatic 32	oicq/wlogin_sdk/request/g:h	Loicq/wlogin_sdk/request/c;
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
  
  /* Error */
  public static TreeMap a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: getstatic 155	oicq/wlogin_sdk/request/y:z	[B
    //   6: ifnull +10 -> 16
    //   9: getstatic 155	oicq/wlogin_sdk/request/y:z	[B
    //   12: arraylength
    //   13: ifne +10 -> 23
    //   16: aload_0
    //   17: invokestatic 159	oicq/wlogin_sdk/tools/util:get_file_imei	(Landroid/content/Context;)[B
    //   20: putstatic 155	oicq/wlogin_sdk/request/y:z	[B
    //   23: aload_0
    //   24: aload_1
    //   25: invokestatic 162	oicq/wlogin_sdk/request/g:b	(Landroid/content/Context;Ljava/lang/String;)[B
    //   28: astore 6
    //   30: aload 6
    //   32: ifnull +1579 -> 1611
    //   35: new 75	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   42: ldc 164
    //   44: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload 6
    //   49: arraylength
    //   50: invokevirtual 167	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: ldc 169
    //   55: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokestatic 172	oicq/wlogin_sdk/request/y:l	()Ljava/lang/String;
    //   61: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: ldc 140
    //   69: invokestatic 176	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload 6
    //   74: iconst_0
    //   75: aload 6
    //   77: arraylength
    //   78: getstatic 155	oicq/wlogin_sdk/request/y:z	[B
    //   81: invokestatic 182	oicq/wlogin_sdk/tools/cryptor:decrypt	([BII[B)[B
    //   84: astore 7
    //   86: aload 7
    //   88: ifnull +110 -> 198
    //   91: new 184	java/io/ByteArrayInputStream
    //   94: dup
    //   95: aload 7
    //   97: invokespecial 187	java/io/ByteArrayInputStream:<init>	([B)V
    //   100: astore 8
    //   102: new 189	java/io/ObjectInputStream
    //   105: dup
    //   106: aload 8
    //   108: invokespecial 192	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   111: astore 7
    //   113: aload 7
    //   115: astore 6
    //   117: aload 7
    //   119: invokevirtual 196	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   122: checkcast 41	java/util/TreeMap
    //   125: astore 10
    //   127: aload 7
    //   129: astore 6
    //   131: aload 7
    //   133: invokevirtual 197	java/io/ObjectInputStream:close	()V
    //   136: aload 7
    //   138: astore 6
    //   140: aload 8
    //   142: invokevirtual 198	java/io/ByteArrayInputStream:close	()V
    //   145: aload 10
    //   147: ifnull +38 -> 185
    //   150: aload 7
    //   152: astore 6
    //   154: new 75	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   161: ldc 200
    //   163: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload 10
    //   168: invokevirtual 203	java/util/TreeMap:size	()I
    //   171: invokevirtual 167	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   174: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: ldc 140
    //   179: invokestatic 176	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload 10
    //   184: areturn
    //   185: aload 7
    //   187: astore 6
    //   189: ldc 205
    //   191: ldc 140
    //   193: invokestatic 176	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: aconst_null
    //   197: areturn
    //   198: new 207	javax/crypto/spec/SecretKeySpec
    //   201: dup
    //   202: getstatic 155	oicq/wlogin_sdk/request/y:z	[B
    //   205: ldc 209
    //   207: invokespecial 212	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   210: astore 8
    //   212: ldc 209
    //   214: invokestatic 218	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   217: astore 7
    //   219: aload 7
    //   221: iconst_2
    //   222: aload 8
    //   224: invokevirtual 222	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   227: new 184	java/io/ByteArrayInputStream
    //   230: dup
    //   231: aload 6
    //   233: invokespecial 187	java/io/ByteArrayInputStream:<init>	([B)V
    //   236: astore 8
    //   238: new 189	java/io/ObjectInputStream
    //   241: dup
    //   242: new 224	javax/crypto/CipherInputStream
    //   245: dup
    //   246: aload 8
    //   248: aload 7
    //   250: invokespecial 227	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   253: invokespecial 192	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   256: astore 7
    //   258: aload 7
    //   260: astore 6
    //   262: aload 7
    //   264: invokevirtual 196	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   267: checkcast 41	java/util/TreeMap
    //   270: astore 10
    //   272: aload 10
    //   274: ifnull +107 -> 381
    //   277: aload 7
    //   279: astore 6
    //   281: aload 7
    //   283: invokevirtual 197	java/io/ObjectInputStream:close	()V
    //   286: aload 7
    //   288: astore 6
    //   290: aload 8
    //   292: invokevirtual 198	java/io/ByteArrayInputStream:close	()V
    //   295: aload 10
    //   297: areturn
    //   298: astore 7
    //   300: aload 7
    //   302: ldc 140
    //   304: invokestatic 231	oicq/wlogin_sdk/tools/util:printThrowable	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   307: new 207	javax/crypto/spec/SecretKeySpec
    //   310: dup
    //   311: getstatic 155	oicq/wlogin_sdk/request/y:z	[B
    //   314: ldc 209
    //   316: invokespecial 212	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   319: astore 7
    //   321: ldc 209
    //   323: invokestatic 218	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   326: astore 8
    //   328: aload 8
    //   330: iconst_2
    //   331: aload 7
    //   333: invokevirtual 222	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   336: new 189	java/io/ObjectInputStream
    //   339: dup
    //   340: new 224	javax/crypto/CipherInputStream
    //   343: dup
    //   344: aload_0
    //   345: aload_1
    //   346: invokevirtual 237	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   349: aload 8
    //   351: invokespecial 227	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   354: invokespecial 192	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   357: astore 7
    //   359: aload 7
    //   361: invokevirtual 196	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   364: checkcast 41	java/util/TreeMap
    //   367: astore 6
    //   369: aload 7
    //   371: astore_1
    //   372: aload 6
    //   374: astore_0
    //   375: aload_0
    //   376: ifnonnull +1187 -> 1563
    //   379: aload_0
    //   380: areturn
    //   381: aload 7
    //   383: astore 6
    //   385: goto -78 -> 307
    //   388: astore 8
    //   390: aload 8
    //   392: instanceof 239
    //   395: ifne +47 -> 442
    //   398: sipush 256
    //   401: newarray byte
    //   403: astore 7
    //   405: aload_0
    //   406: aload_1
    //   407: invokevirtual 237	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   410: astore 8
    //   412: aload 8
    //   414: aload 7
    //   416: iconst_0
    //   417: aload 7
    //   419: arraylength
    //   420: invokevirtual 245	java/io/FileInputStream:read	([BII)I
    //   423: istore_2
    //   424: iload_2
    //   425: ifle +97 -> 522
    //   428: aload 7
    //   430: iload_2
    //   431: invokestatic 249	oicq/wlogin_sdk/tools/util:buf_to_string	([BI)Ljava/lang/String;
    //   434: invokestatic 251	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;)V
    //   437: goto -25 -> 412
    //   440: astore 7
    //   442: new 207	javax/crypto/spec/SecretKeySpec
    //   445: dup
    //   446: new 60	java/lang/String
    //   449: dup
    //   450: ldc 253
    //   452: invokespecial 255	java/lang/String:<init>	(Ljava/lang/String;)V
    //   455: invokevirtual 259	java/lang/String:getBytes	()[B
    //   458: ldc 209
    //   460: invokespecial 212	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   463: astore 7
    //   465: ldc 209
    //   467: invokestatic 218	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   470: astore 8
    //   472: aload 8
    //   474: iconst_2
    //   475: aload 7
    //   477: invokevirtual 222	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   480: new 189	java/io/ObjectInputStream
    //   483: dup
    //   484: new 224	javax/crypto/CipherInputStream
    //   487: dup
    //   488: aload_0
    //   489: aload_1
    //   490: invokevirtual 237	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   493: aload 8
    //   495: invokespecial 227	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   498: invokespecial 192	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   501: astore 7
    //   503: aload 7
    //   505: invokevirtual 196	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   508: checkcast 41	java/util/TreeMap
    //   511: astore 6
    //   513: aload 7
    //   515: astore_1
    //   516: aload 6
    //   518: astore_0
    //   519: goto -144 -> 375
    //   522: aload 8
    //   524: invokevirtual 260	java/io/FileInputStream:close	()V
    //   527: goto -85 -> 442
    //   530: astore 7
    //   532: sipush 256
    //   535: newarray byte
    //   537: astore 7
    //   539: aload 7
    //   541: arraylength
    //   542: istore 4
    //   544: aload_0
    //   545: aload_1
    //   546: invokevirtual 237	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   549: astore_1
    //   550: aload_0
    //   551: ldc_w 262
    //   554: iconst_0
    //   555: invokevirtual 266	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   558: astore 8
    //   560: aload_1
    //   561: aload 7
    //   563: bipush 40
    //   565: iload 4
    //   567: bipush 40
    //   569: isub
    //   570: invokevirtual 245	java/io/FileInputStream:read	([BII)I
    //   573: istore 5
    //   575: iload 5
    //   577: ifle +950 -> 1527
    //   580: bipush 40
    //   582: iload 5
    //   584: iadd
    //   585: istore_2
    //   586: iload_2
    //   587: aload 7
    //   589: arraylength
    //   590: if_icmpge +1027 -> 1617
    //   593: aload 7
    //   595: iload_2
    //   596: iconst_0
    //   597: bastore
    //   598: iload_2
    //   599: iconst_1
    //   600: iadd
    //   601: istore_2
    //   602: goto -16 -> 586
    //   605: iload_2
    //   606: iflt +1016 -> 1622
    //   609: new 60	java/lang/String
    //   612: dup
    //   613: ldc_w 268
    //   616: invokespecial 255	java/lang/String:<init>	(Ljava/lang/String;)V
    //   619: invokevirtual 259	java/lang/String:getBytes	()[B
    //   622: astore 10
    //   624: aload 7
    //   626: iload_2
    //   627: aload 10
    //   629: invokestatic 270	oicq/wlogin_sdk/request/g:a	([BI[B)I
    //   632: istore_2
    //   633: iload_2
    //   634: ifge +162 -> 796
    //   637: goto +985 -> 1622
    //   640: iload_2
    //   641: iflt +986 -> 1627
    //   644: new 60	java/lang/String
    //   647: dup
    //   648: ldc_w 272
    //   651: invokespecial 255	java/lang/String:<init>	(Ljava/lang/String;)V
    //   654: invokevirtual 259	java/lang/String:getBytes	()[B
    //   657: astore 10
    //   659: aload 7
    //   661: iload_2
    //   662: aload 10
    //   664: invokestatic 270	oicq/wlogin_sdk/request/g:a	([BI[B)I
    //   667: istore_2
    //   668: iload_2
    //   669: ifge +313 -> 982
    //   672: goto +955 -> 1627
    //   675: iload_2
    //   676: iflt +956 -> 1632
    //   679: new 60	java/lang/String
    //   682: dup
    //   683: ldc_w 274
    //   686: invokespecial 255	java/lang/String:<init>	(Ljava/lang/String;)V
    //   689: invokevirtual 259	java/lang/String:getBytes	()[B
    //   692: astore 10
    //   694: aload 7
    //   696: iload_2
    //   697: aload 10
    //   699: invokestatic 270	oicq/wlogin_sdk/request/g:a	([BI[B)I
    //   702: istore_2
    //   703: iload_2
    //   704: ifge +449 -> 1153
    //   707: goto +925 -> 1632
    //   710: iload_2
    //   711: iflt +31 -> 742
    //   714: new 60	java/lang/String
    //   717: dup
    //   718: ldc_w 276
    //   721: invokespecial 255	java/lang/String:<init>	(Ljava/lang/String;)V
    //   724: invokevirtual 259	java/lang/String:getBytes	()[B
    //   727: astore 10
    //   729: aload 7
    //   731: iload_2
    //   732: aload 10
    //   734: invokestatic 270	oicq/wlogin_sdk/request/g:a	([BI[B)I
    //   737: istore_2
    //   738: iload_2
    //   739: ifge +601 -> 1340
    //   742: aload 8
    //   744: aload 7
    //   746: bipush 40
    //   748: iload 5
    //   750: invokevirtual 282	java/io/FileOutputStream:write	([BII)V
    //   753: iload 5
    //   755: bipush 40
    //   757: if_icmple -197 -> 560
    //   760: aload 7
    //   762: iload 5
    //   764: aload 7
    //   766: iconst_0
    //   767: bipush 40
    //   769: invokestatic 288	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   772: goto -212 -> 560
    //   775: astore_1
    //   776: aload 6
    //   778: astore_1
    //   779: aconst_null
    //   780: astore 6
    //   782: aload_0
    //   783: ldc_w 262
    //   786: invokevirtual 292	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   789: pop
    //   790: aload 6
    //   792: astore_0
    //   793: goto -418 -> 375
    //   796: iload_2
    //   797: aload 10
    //   799: arraylength
    //   800: iadd
    //   801: istore_3
    //   802: iload_3
    //   803: istore_2
    //   804: iload_3
    //   805: bipush 8
    //   807: iadd
    //   808: aload 7
    //   810: arraylength
    //   811: if_icmpgt -206 -> 605
    //   814: iload_3
    //   815: istore_2
    //   816: aload 7
    //   818: iload_3
    //   819: iconst_0
    //   820: iadd
    //   821: baload
    //   822: bipush 129
    //   824: if_icmpne -219 -> 605
    //   827: iload_3
    //   828: istore_2
    //   829: aload 7
    //   831: iload_3
    //   832: iconst_1
    //   833: iadd
    //   834: baload
    //   835: bipush 64
    //   837: if_icmpne -232 -> 605
    //   840: iload_3
    //   841: istore_2
    //   842: aload 7
    //   844: iload_3
    //   845: iconst_2
    //   846: iadd
    //   847: baload
    //   848: iconst_1
    //   849: if_icmpne -244 -> 605
    //   852: iload_3
    //   853: istore_2
    //   854: aload 7
    //   856: iload_3
    //   857: iconst_3
    //   858: iadd
    //   859: baload
    //   860: bipush 111
    //   862: if_icmpne -257 -> 605
    //   865: iload_3
    //   866: istore_2
    //   867: aload 7
    //   869: iload_3
    //   870: iconst_4
    //   871: iadd
    //   872: baload
    //   873: bipush 145
    //   875: if_icmpne -270 -> 605
    //   878: iload_3
    //   879: istore_2
    //   880: aload 7
    //   882: iload_3
    //   883: iconst_5
    //   884: iadd
    //   885: baload
    //   886: bipush 212
    //   888: if_icmpne -283 -> 605
    //   891: iload_3
    //   892: istore_2
    //   893: aload 7
    //   895: iload_3
    //   896: bipush 6
    //   898: iadd
    //   899: baload
    //   900: bipush 26
    //   902: if_icmpne -297 -> 605
    //   905: iload_3
    //   906: istore_2
    //   907: aload 7
    //   909: iload_3
    //   910: bipush 7
    //   912: iadd
    //   913: baload
    //   914: bipush 155
    //   916: if_icmpne -311 -> 605
    //   919: aload 7
    //   921: iload_3
    //   922: iconst_0
    //   923: iadd
    //   924: iconst_0
    //   925: bastore
    //   926: aload 7
    //   928: iload_3
    //   929: iconst_1
    //   930: iadd
    //   931: iconst_0
    //   932: bastore
    //   933: aload 7
    //   935: iload_3
    //   936: iconst_2
    //   937: iadd
    //   938: iconst_0
    //   939: bastore
    //   940: aload 7
    //   942: iload_3
    //   943: iconst_3
    //   944: iadd
    //   945: iconst_0
    //   946: bastore
    //   947: aload 7
    //   949: iload_3
    //   950: iconst_4
    //   951: iadd
    //   952: iconst_0
    //   953: bastore
    //   954: aload 7
    //   956: iload_3
    //   957: iconst_5
    //   958: iadd
    //   959: iconst_0
    //   960: bastore
    //   961: aload 7
    //   963: iload_3
    //   964: bipush 6
    //   966: iadd
    //   967: iconst_0
    //   968: bastore
    //   969: aload 7
    //   971: iload_3
    //   972: bipush 7
    //   974: iadd
    //   975: iconst_1
    //   976: bastore
    //   977: iload_3
    //   978: istore_2
    //   979: goto -374 -> 605
    //   982: iload_2
    //   983: aload 10
    //   985: arraylength
    //   986: iadd
    //   987: istore_3
    //   988: iload_3
    //   989: istore_2
    //   990: iload_3
    //   991: bipush 8
    //   993: iadd
    //   994: aload 7
    //   996: arraylength
    //   997: if_icmpgt -357 -> 640
    //   1000: iload_3
    //   1001: istore_2
    //   1002: aload 7
    //   1004: iload_3
    //   1005: iconst_0
    //   1006: iadd
    //   1007: baload
    //   1008: ifne -368 -> 640
    //   1011: iload_3
    //   1012: istore_2
    //   1013: aload 7
    //   1015: iload_3
    //   1016: iconst_1
    //   1017: iadd
    //   1018: baload
    //   1019: ifne -379 -> 640
    //   1022: iload_3
    //   1023: istore_2
    //   1024: aload 7
    //   1026: iload_3
    //   1027: iconst_2
    //   1028: iadd
    //   1029: baload
    //   1030: ifne -390 -> 640
    //   1033: iload_3
    //   1034: istore_2
    //   1035: aload 7
    //   1037: iload_3
    //   1038: iconst_3
    //   1039: iadd
    //   1040: baload
    //   1041: ifne -401 -> 640
    //   1044: iload_3
    //   1045: istore_2
    //   1046: aload 7
    //   1048: iload_3
    //   1049: iconst_4
    //   1050: iadd
    //   1051: baload
    //   1052: ifne -412 -> 640
    //   1055: iload_3
    //   1056: istore_2
    //   1057: aload 7
    //   1059: iload_3
    //   1060: iconst_5
    //   1061: iadd
    //   1062: baload
    //   1063: ifne -423 -> 640
    //   1066: iload_3
    //   1067: istore_2
    //   1068: aload 7
    //   1070: iload_3
    //   1071: bipush 6
    //   1073: iadd
    //   1074: baload
    //   1075: ifne -435 -> 640
    //   1078: iload_3
    //   1079: istore_2
    //   1080: aload 7
    //   1082: iload_3
    //   1083: bipush 7
    //   1085: iadd
    //   1086: baload
    //   1087: ifne -447 -> 640
    //   1090: aload 7
    //   1092: iload_3
    //   1093: iconst_0
    //   1094: iadd
    //   1095: iconst_0
    //   1096: bastore
    //   1097: aload 7
    //   1099: iload_3
    //   1100: iconst_1
    //   1101: iadd
    //   1102: iconst_0
    //   1103: bastore
    //   1104: aload 7
    //   1106: iload_3
    //   1107: iconst_2
    //   1108: iadd
    //   1109: iconst_0
    //   1110: bastore
    //   1111: aload 7
    //   1113: iload_3
    //   1114: iconst_3
    //   1115: iadd
    //   1116: iconst_0
    //   1117: bastore
    //   1118: aload 7
    //   1120: iload_3
    //   1121: iconst_4
    //   1122: iadd
    //   1123: iconst_0
    //   1124: bastore
    //   1125: aload 7
    //   1127: iload_3
    //   1128: iconst_5
    //   1129: iadd
    //   1130: iconst_0
    //   1131: bastore
    //   1132: aload 7
    //   1134: iload_3
    //   1135: bipush 6
    //   1137: iadd
    //   1138: iconst_0
    //   1139: bastore
    //   1140: aload 7
    //   1142: iload_3
    //   1143: bipush 7
    //   1145: iadd
    //   1146: iconst_1
    //   1147: bastore
    //   1148: iload_3
    //   1149: istore_2
    //   1150: goto -510 -> 640
    //   1153: iload_2
    //   1154: aload 10
    //   1156: arraylength
    //   1157: iadd
    //   1158: istore_3
    //   1159: iload_3
    //   1160: istore_2
    //   1161: iload_3
    //   1162: bipush 8
    //   1164: iadd
    //   1165: aload 7
    //   1167: arraylength
    //   1168: if_icmpgt -493 -> 675
    //   1171: iload_3
    //   1172: istore_2
    //   1173: aload 7
    //   1175: iload_3
    //   1176: iconst_0
    //   1177: iadd
    //   1178: baload
    //   1179: bipush 57
    //   1181: if_icmpne -506 -> 675
    //   1184: iload_3
    //   1185: istore_2
    //   1186: aload 7
    //   1188: iload_3
    //   1189: iconst_1
    //   1190: iadd
    //   1191: baload
    //   1192: bipush 187
    //   1194: if_icmpne -519 -> 675
    //   1197: iload_3
    //   1198: istore_2
    //   1199: aload 7
    //   1201: iload_3
    //   1202: iconst_2
    //   1203: iadd
    //   1204: baload
    //   1205: bipush 172
    //   1207: if_icmpne -532 -> 675
    //   1210: iload_3
    //   1211: istore_2
    //   1212: aload 7
    //   1214: iload_3
    //   1215: iconst_3
    //   1216: iadd
    //   1217: baload
    //   1218: bipush 110
    //   1220: if_icmpne -545 -> 675
    //   1223: iload_3
    //   1224: istore_2
    //   1225: aload 7
    //   1227: iload_3
    //   1228: iconst_4
    //   1229: iadd
    //   1230: baload
    //   1231: bipush 210
    //   1233: if_icmpne -558 -> 675
    //   1236: iload_3
    //   1237: istore_2
    //   1238: aload 7
    //   1240: iload_3
    //   1241: iconst_5
    //   1242: iadd
    //   1243: baload
    //   1244: bipush 98
    //   1246: if_icmpne -571 -> 675
    //   1249: iload_3
    //   1250: istore_2
    //   1251: aload 7
    //   1253: iload_3
    //   1254: bipush 6
    //   1256: iadd
    //   1257: baload
    //   1258: bipush 225
    //   1260: if_icmpne -585 -> 675
    //   1263: iload_3
    //   1264: istore_2
    //   1265: aload 7
    //   1267: iload_3
    //   1268: bipush 7
    //   1270: iadd
    //   1271: baload
    //   1272: bipush 143
    //   1274: if_icmpne -599 -> 675
    //   1277: aload 7
    //   1279: iload_3
    //   1280: iconst_0
    //   1281: iadd
    //   1282: iconst_0
    //   1283: bastore
    //   1284: aload 7
    //   1286: iload_3
    //   1287: iconst_1
    //   1288: iadd
    //   1289: iconst_0
    //   1290: bastore
    //   1291: aload 7
    //   1293: iload_3
    //   1294: iconst_2
    //   1295: iadd
    //   1296: iconst_0
    //   1297: bastore
    //   1298: aload 7
    //   1300: iload_3
    //   1301: iconst_3
    //   1302: iadd
    //   1303: iconst_0
    //   1304: bastore
    //   1305: aload 7
    //   1307: iload_3
    //   1308: iconst_4
    //   1309: iadd
    //   1310: iconst_0
    //   1311: bastore
    //   1312: aload 7
    //   1314: iload_3
    //   1315: iconst_5
    //   1316: iadd
    //   1317: iconst_0
    //   1318: bastore
    //   1319: aload 7
    //   1321: iload_3
    //   1322: bipush 6
    //   1324: iadd
    //   1325: iconst_0
    //   1326: bastore
    //   1327: aload 7
    //   1329: iload_3
    //   1330: bipush 7
    //   1332: iadd
    //   1333: iconst_1
    //   1334: bastore
    //   1335: iload_3
    //   1336: istore_2
    //   1337: goto -662 -> 675
    //   1340: iload_2
    //   1341: aload 10
    //   1343: arraylength
    //   1344: iadd
    //   1345: istore_3
    //   1346: iload_3
    //   1347: istore_2
    //   1348: iload_3
    //   1349: bipush 8
    //   1351: iadd
    //   1352: aload 7
    //   1354: arraylength
    //   1355: if_icmpgt -645 -> 710
    //   1358: iload_3
    //   1359: istore_2
    //   1360: aload 7
    //   1362: iload_3
    //   1363: iconst_0
    //   1364: iadd
    //   1365: baload
    //   1366: bipush 138
    //   1368: if_icmpne -658 -> 710
    //   1371: iload_3
    //   1372: istore_2
    //   1373: aload 7
    //   1375: iload_3
    //   1376: iconst_1
    //   1377: iadd
    //   1378: baload
    //   1379: bipush 233
    //   1381: if_icmpne -671 -> 710
    //   1384: iload_3
    //   1385: istore_2
    //   1386: aload 7
    //   1388: iload_3
    //   1389: iconst_2
    //   1390: iadd
    //   1391: baload
    //   1392: bipush 128
    //   1394: if_icmpne -684 -> 710
    //   1397: iload_3
    //   1398: istore_2
    //   1399: aload 7
    //   1401: iload_3
    //   1402: iconst_3
    //   1403: iadd
    //   1404: baload
    //   1405: bipush 237
    //   1407: if_icmpne -697 -> 710
    //   1410: iload_3
    //   1411: istore_2
    //   1412: aload 7
    //   1414: iload_3
    //   1415: iconst_4
    //   1416: iadd
    //   1417: baload
    //   1418: bipush 230
    //   1420: if_icmpne -710 -> 710
    //   1423: iload_3
    //   1424: istore_2
    //   1425: aload 7
    //   1427: iload_3
    //   1428: iconst_5
    //   1429: iadd
    //   1430: baload
    //   1431: bipush 99
    //   1433: if_icmpne -723 -> 710
    //   1436: iload_3
    //   1437: istore_2
    //   1438: aload 7
    //   1440: iload_3
    //   1441: bipush 6
    //   1443: iadd
    //   1444: baload
    //   1445: bipush 41
    //   1447: if_icmpne -737 -> 710
    //   1450: iload_3
    //   1451: istore_2
    //   1452: aload 7
    //   1454: iload_3
    //   1455: bipush 7
    //   1457: iadd
    //   1458: baload
    //   1459: bipush 14
    //   1461: if_icmpne -751 -> 710
    //   1464: aload 7
    //   1466: iload_3
    //   1467: iconst_0
    //   1468: iadd
    //   1469: iconst_0
    //   1470: bastore
    //   1471: aload 7
    //   1473: iload_3
    //   1474: iconst_1
    //   1475: iadd
    //   1476: iconst_0
    //   1477: bastore
    //   1478: aload 7
    //   1480: iload_3
    //   1481: iconst_2
    //   1482: iadd
    //   1483: iconst_0
    //   1484: bastore
    //   1485: aload 7
    //   1487: iload_3
    //   1488: iconst_3
    //   1489: iadd
    //   1490: iconst_0
    //   1491: bastore
    //   1492: aload 7
    //   1494: iload_3
    //   1495: iconst_4
    //   1496: iadd
    //   1497: iconst_0
    //   1498: bastore
    //   1499: aload 7
    //   1501: iload_3
    //   1502: iconst_5
    //   1503: iadd
    //   1504: iconst_0
    //   1505: bastore
    //   1506: aload 7
    //   1508: iload_3
    //   1509: bipush 6
    //   1511: iadd
    //   1512: iconst_0
    //   1513: bastore
    //   1514: aload 7
    //   1516: iload_3
    //   1517: bipush 7
    //   1519: iadd
    //   1520: iconst_1
    //   1521: bastore
    //   1522: iload_3
    //   1523: istore_2
    //   1524: goto -814 -> 710
    //   1527: aload_1
    //   1528: invokevirtual 260	java/io/FileInputStream:close	()V
    //   1531: aload 8
    //   1533: invokevirtual 293	java/io/FileOutputStream:close	()V
    //   1536: new 189	java/io/ObjectInputStream
    //   1539: dup
    //   1540: aload_0
    //   1541: ldc_w 262
    //   1544: invokevirtual 237	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   1547: invokespecial 192	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   1550: astore_1
    //   1551: aload_1
    //   1552: invokevirtual 196	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   1555: checkcast 41	java/util/TreeMap
    //   1558: astore 6
    //   1560: goto -778 -> 782
    //   1563: aload_1
    //   1564: invokevirtual 197	java/io/ObjectInputStream:close	()V
    //   1567: goto -1188 -> 379
    //   1570: astore_0
    //   1571: aload 9
    //   1573: astore_0
    //   1574: goto -1195 -> 379
    //   1577: astore 6
    //   1579: aload_1
    //   1580: astore 6
    //   1582: goto -806 -> 776
    //   1585: astore 6
    //   1587: aload 7
    //   1589: astore 6
    //   1591: goto -1059 -> 532
    //   1594: astore 8
    //   1596: aload 7
    //   1598: astore 6
    //   1600: goto -1210 -> 390
    //   1603: astore 7
    //   1605: aconst_null
    //   1606: astore 6
    //   1608: goto -1308 -> 300
    //   1611: aconst_null
    //   1612: astore 6
    //   1614: goto -1307 -> 307
    //   1617: iconst_0
    //   1618: istore_2
    //   1619: goto -1014 -> 605
    //   1622: iconst_0
    //   1623: istore_2
    //   1624: goto -984 -> 640
    //   1627: iconst_0
    //   1628: istore_2
    //   1629: goto -954 -> 675
    //   1632: iconst_0
    //   1633: istore_2
    //   1634: goto -924 -> 710
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1637	0	paramContext	Context
    //   0	1637	1	paramString	String
    //   423	1211	2	i	int
    //   801	722	3	j	int
    //   542	28	4	k	int
    //   573	190	5	m	int
    //   28	1531	6	localObject1	Object
    //   1577	1	6	localException1	java.lang.Exception
    //   1580	1	6	str	String
    //   1585	1	6	localException2	java.lang.Exception
    //   1589	24	6	localObject2	Object
    //   84	203	7	localObject3	Object
    //   298	3	7	localThrowable1	Throwable
    //   319	110	7	localObject4	Object
    //   440	1	7	localException3	java.lang.Exception
    //   463	51	7	localObject5	Object
    //   530	1	7	localException4	java.lang.Exception
    //   537	1060	7	arrayOfByte	byte[]
    //   1603	1	7	localThrowable2	Throwable
    //   100	250	8	localObject6	Object
    //   388	3	8	localException5	java.lang.Exception
    //   410	1122	8	localObject7	Object
    //   1594	1	8	localException6	java.lang.Exception
    //   1	1571	9	localObject8	Object
    //   125	1217	10	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   117	127	298	java/lang/Throwable
    //   131	136	298	java/lang/Throwable
    //   140	145	298	java/lang/Throwable
    //   154	182	298	java/lang/Throwable
    //   189	196	298	java/lang/Throwable
    //   262	272	298	java/lang/Throwable
    //   281	286	298	java/lang/Throwable
    //   290	295	298	java/lang/Throwable
    //   307	359	388	java/lang/Exception
    //   398	412	440	java/lang/Exception
    //   412	424	440	java/lang/Exception
    //   428	437	440	java/lang/Exception
    //   522	527	440	java/lang/Exception
    //   442	503	530	java/lang/Exception
    //   532	560	775	java/lang/Exception
    //   560	575	775	java/lang/Exception
    //   586	593	775	java/lang/Exception
    //   609	633	775	java/lang/Exception
    //   644	668	775	java/lang/Exception
    //   679	703	775	java/lang/Exception
    //   714	738	775	java/lang/Exception
    //   742	753	775	java/lang/Exception
    //   760	772	775	java/lang/Exception
    //   796	802	775	java/lang/Exception
    //   804	814	775	java/lang/Exception
    //   982	988	775	java/lang/Exception
    //   990	1000	775	java/lang/Exception
    //   1153	1159	775	java/lang/Exception
    //   1161	1171	775	java/lang/Exception
    //   1340	1346	775	java/lang/Exception
    //   1348	1358	775	java/lang/Exception
    //   1527	1551	775	java/lang/Exception
    //   1563	1567	1570	java/lang/Exception
    //   1551	1560	1577	java/lang/Exception
    //   503	513	1585	java/lang/Exception
    //   359	369	1594	java/lang/Exception
    //   72	86	1603	java/lang/Throwable
    //   91	113	1603	java/lang/Throwable
    //   198	258	1603	java/lang/Throwable
  }
  
  /* Error */
  public static byte[] b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iconst_0
    //   4: invokestatic 298	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   7: astore 5
    //   9: aload_1
    //   10: ldc 58
    //   12: invokevirtual 64	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifeq +147 -> 162
    //   18: getstatic 30	oicq/wlogin_sdk/request/g:g	Loicq/wlogin_sdk/request/c;
    //   21: ifnonnull +17 -> 38
    //   24: new 66	oicq/wlogin_sdk/request/c
    //   27: dup
    //   28: aload_0
    //   29: aload_1
    //   30: aconst_null
    //   31: iconst_1
    //   32: invokespecial 69	oicq/wlogin_sdk/request/c:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   35: putstatic 30	oicq/wlogin_sdk/request/g:g	Loicq/wlogin_sdk/request/c;
    //   38: getstatic 30	oicq/wlogin_sdk/request/g:g	Loicq/wlogin_sdk/request/c;
    //   41: invokevirtual 301	oicq/wlogin_sdk/request/c:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   44: astore_3
    //   45: aload_3
    //   46: new 75	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 303
    //   56: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_1
    //   60: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: ldc_w 305
    //   66: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: aconst_null
    //   73: invokevirtual 309	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   76: astore_0
    //   77: aload 5
    //   79: astore 4
    //   81: aload_0
    //   82: invokeinterface 312 1 0
    //   87: ifeq +23 -> 110
    //   90: aload 5
    //   92: astore 4
    //   94: aload_0
    //   95: iconst_0
    //   96: invokeinterface 316 2 0
    //   101: ifle +9 -> 110
    //   104: iconst_1
    //   105: invokestatic 298	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   108: astore 4
    //   110: aload_0
    //   111: ifnull +18 -> 129
    //   114: aload_0
    //   115: invokeinterface 135 1 0
    //   120: ifne +9 -> 129
    //   123: aload_0
    //   124: invokeinterface 138 1 0
    //   129: aload 4
    //   131: invokevirtual 319	java/lang/Boolean:booleanValue	()Z
    //   134: istore_2
    //   135: iload_2
    //   136: ifne +56 -> 192
    //   139: aload_0
    //   140: ifnull +18 -> 158
    //   143: aload_0
    //   144: invokeinterface 135 1 0
    //   149: ifne +9 -> 158
    //   152: aload_0
    //   153: invokeinterface 138 1 0
    //   158: aconst_null
    //   159: astore_1
    //   160: aload_1
    //   161: areturn
    //   162: getstatic 32	oicq/wlogin_sdk/request/g:h	Loicq/wlogin_sdk/request/c;
    //   165: ifnonnull +17 -> 182
    //   168: new 66	oicq/wlogin_sdk/request/c
    //   171: dup
    //   172: aload_0
    //   173: aload_1
    //   174: aconst_null
    //   175: iconst_1
    //   176: invokespecial 69	oicq/wlogin_sdk/request/c:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   179: putstatic 32	oicq/wlogin_sdk/request/g:h	Loicq/wlogin_sdk/request/c;
    //   182: getstatic 32	oicq/wlogin_sdk/request/g:h	Loicq/wlogin_sdk/request/c;
    //   185: invokevirtual 301	oicq/wlogin_sdk/request/c:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   188: astore_3
    //   189: goto -144 -> 45
    //   192: aload_3
    //   193: aload_1
    //   194: iconst_1
    //   195: anewarray 60	java/lang/String
    //   198: dup
    //   199: iconst_0
    //   200: aload_1
    //   201: aastore
    //   202: ldc 100
    //   204: aconst_null
    //   205: aconst_null
    //   206: aconst_null
    //   207: aconst_null
    //   208: invokevirtual 104	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   211: astore_3
    //   212: aload_3
    //   213: astore_0
    //   214: aload_0
    //   215: ifnonnull +24 -> 239
    //   218: aload_0
    //   219: ifnull +18 -> 237
    //   222: aload_0
    //   223: invokeinterface 135 1 0
    //   228: ifne +9 -> 237
    //   231: aload_0
    //   232: invokeinterface 138 1 0
    //   237: aconst_null
    //   238: areturn
    //   239: aload_0
    //   240: astore_3
    //   241: aload_0
    //   242: invokeinterface 322 1 0
    //   247: ifeq +50 -> 297
    //   250: aload_0
    //   251: astore_3
    //   252: aload_0
    //   253: iconst_0
    //   254: invokeinterface 326 2 0
    //   259: astore 4
    //   261: aload_0
    //   262: astore_3
    //   263: aload_0
    //   264: invokeinterface 138 1 0
    //   269: aload 4
    //   271: astore_1
    //   272: aload_0
    //   273: ifnull -113 -> 160
    //   276: aload 4
    //   278: astore_1
    //   279: aload_0
    //   280: invokeinterface 135 1 0
    //   285: ifne -125 -> 160
    //   288: aload_0
    //   289: invokeinterface 138 1 0
    //   294: aload 4
    //   296: areturn
    //   297: aload_0
    //   298: astore_3
    //   299: aload_0
    //   300: invokeinterface 138 1 0
    //   305: aload_0
    //   306: ifnull +18 -> 324
    //   309: aload_0
    //   310: invokeinterface 135 1 0
    //   315: ifne +9 -> 324
    //   318: aload_0
    //   319: invokeinterface 138 1 0
    //   324: aconst_null
    //   325: areturn
    //   326: astore 4
    //   328: aconst_null
    //   329: astore_0
    //   330: aload_0
    //   331: astore_3
    //   332: aload_1
    //   333: ldc 58
    //   335: invokevirtual 64	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   338: ifeq +39 -> 377
    //   341: aload_0
    //   342: astore_3
    //   343: aconst_null
    //   344: putstatic 30	oicq/wlogin_sdk/request/g:g	Loicq/wlogin_sdk/request/c;
    //   347: aload_0
    //   348: astore_3
    //   349: aload 4
    //   351: ldc 140
    //   353: invokestatic 146	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   356: aload_0
    //   357: ifnull +18 -> 375
    //   360: aload_0
    //   361: invokeinterface 135 1 0
    //   366: ifne +9 -> 375
    //   369: aload_0
    //   370: invokeinterface 138 1 0
    //   375: aconst_null
    //   376: areturn
    //   377: aload_0
    //   378: astore_3
    //   379: aconst_null
    //   380: putstatic 32	oicq/wlogin_sdk/request/g:h	Loicq/wlogin_sdk/request/c;
    //   383: goto -36 -> 347
    //   386: astore_0
    //   387: aload_3
    //   388: astore_1
    //   389: aload_1
    //   390: ifnull +18 -> 408
    //   393: aload_1
    //   394: invokeinterface 135 1 0
    //   399: ifne +9 -> 408
    //   402: aload_1
    //   403: invokeinterface 138 1 0
    //   408: aload_0
    //   409: athrow
    //   410: astore_0
    //   411: aload 4
    //   413: astore_1
    //   414: goto -25 -> 389
    //   417: astore_3
    //   418: aload_0
    //   419: astore_1
    //   420: aload_3
    //   421: astore_0
    //   422: goto -33 -> 389
    //   425: astore 4
    //   427: goto -97 -> 330
    //   430: astore 4
    //   432: goto -102 -> 330
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	435	0	paramContext	Context
    //   0	435	1	paramString	String
    //   134	2	2	bool	boolean
    //   44	344	3	localObject1	Object
    //   417	4	3	localObject2	Object
    //   1	294	4	localObject3	Object
    //   326	86	4	localException1	java.lang.Exception
    //   425	1	4	localException2	java.lang.Exception
    //   430	1	4	localException3	java.lang.Exception
    //   7	84	5	localBoolean	java.lang.Boolean
    // Exception table:
    //   from	to	target	type
    //   9	38	326	java/lang/Exception
    //   38	45	326	java/lang/Exception
    //   45	77	326	java/lang/Exception
    //   162	182	326	java/lang/Exception
    //   182	189	326	java/lang/Exception
    //   241	250	386	finally
    //   252	261	386	finally
    //   263	269	386	finally
    //   299	305	386	finally
    //   332	341	386	finally
    //   343	347	386	finally
    //   349	356	386	finally
    //   379	383	386	finally
    //   9	38	410	finally
    //   38	45	410	finally
    //   45	77	410	finally
    //   162	182	410	finally
    //   182	189	410	finally
    //   81	90	417	finally
    //   94	110	417	finally
    //   114	129	417	finally
    //   129	135	417	finally
    //   192	212	417	finally
    //   81	90	425	java/lang/Exception
    //   94	110	425	java/lang/Exception
    //   114	129	425	java/lang/Exception
    //   129	135	425	java/lang/Exception
    //   192	212	425	java/lang/Exception
    //   241	250	430	java/lang/Exception
    //   252	261	430	java/lang/Exception
    //   263	269	430	java/lang/Exception
    //   299	305	430	java/lang/Exception
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)this.c.get(new Long(paramLong1));
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
            paramArrayOfByte1.put(new Long(paramLong1), localWloginAllSigInfo.get_clone());
            a(paramArrayOfByte1, "tk_file");
          }
        }
      }
    }
    finally {}
  }
  
  public int a(long paramLong1, long paramLong2, byte[] arg5)
  {
    label226:
    label234:
    for (;;)
    {
      try
      {
        Object localObject3 = (WloginAllSigInfo)this.c.get(new Long(paramLong1));
        if (localObject3 == null)
        {
          i = -1;
          return i;
        }
        Object localObject1 = (WloginSigInfo)((WloginAllSigInfo)localObject3)._tk_map.get(new Long(paramLong2));
        if ((localObject1 == null) || (((WloginSigInfo)localObject1)._randseed == null)) {
          break label226;
        }
        localObject1 = (byte[])((WloginSigInfo)localObject1)._randseed.clone();
        int i = ((WloginAllSigInfo)localObject3).put_siginfo(paramLong2, ???);
        if (this.a != null)
        {
          synchronized (e)
          {
            TreeMap localTreeMap = a(this.a, "tk_file");
            if (localTreeMap != null)
            {
              localTreeMap.put(new Long(paramLong1), ((WloginAllSigInfo)localObject3).get_clone());
              i = a(localTreeMap, "tk_file");
              if (i == 0) {
                break label234;
              }
              localObject3 = (WloginSigInfo)((WloginAllSigInfo)localObject3)._tk_map.get(new Long(paramLong2));
              if (localObject3 == null) {
                break label234;
              }
              ((WloginSigInfo)localObject3)._randseed = ((byte[])((byte[])localObject1).clone());
              break label234;
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
    label650:
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
            break label650;
          }
          localTreeMap = new TreeMap();
          localObject1 = (WloginAllSigInfo)this.c.get(new Long(paramLong1));
          Object localObject4 = localObject1;
          if (localObject1 == null)
          {
            localObject1 = (WloginAllSigInfo)localTreeMap.get(new Long(paramLong1));
            localObject4 = localObject1;
            if (localObject1 == null) {
              localObject4 = new WloginAllSigInfo();
            }
          }
          localObject1 = new byte[0];
          localObject2 = new byte[0];
          byte[] arrayOfByte = new byte[0];
          localObject3 = new byte[0];
          localObject5 = new byte[0];
          localObject7 = (WloginSigInfo)((WloginAllSigInfo)localObject4)._tk_map.get(new Long(paramLong2));
          if (localObject7 == null) {
            break label623;
          }
          if (((WloginSigInfo)localObject7)._en_A1 == null) {
            break label620;
          }
          localObject6 = (byte[])((WloginSigInfo)localObject7)._en_A1.clone();
          localObject1 = localObject6;
          if (((WloginSigInfo)localObject7)._noPicSig == null) {
            break label620;
          }
          localObject2 = (byte[])((WloginSigInfo)localObject7)._noPicSig.clone();
          localObject1 = localObject6;
          if (((WloginSigInfo)localObject7)._G == null) {
            break label617;
          }
          arrayOfByte = (byte[])((WloginSigInfo)localObject7)._G.clone();
          if (((WloginSigInfo)localObject7)._dpwd == null) {
            break label614;
          }
          localObject3 = (byte[])((WloginSigInfo)localObject7)._dpwd.clone();
          if (((WloginSigInfo)localObject7)._randseed != null)
          {
            localObject7 = (byte[])((WloginSigInfo)localObject7)._randseed.clone();
            localObject6 = localObject3;
            localObject5 = localObject1;
            localObject3 = localObject2;
            localObject2 = localObject6;
            localObject1 = localObject7;
            ((WloginAllSigInfo)localObject4).put_simpleinfo(paramLong1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6);
            ((WloginAllSigInfo)localObject4).put_siginfo(paramLong3, paramLong4, paramLong5, paramLong6, paramLong7, paramArrayOfByte7, paramArrayOfByte8, paramArrayOfByte9, paramArrayOfByte10, paramArrayOfByte11, paramArrayOfByte12, paramArrayOfByte13, paramArrayOfByte14, paramArrayOfByte15, paramArrayOfByte16, paramArrayOfByte17, paramArrayOfByte18, paramArrayOfByte19, paramArrayOfLong, paramInt);
            ((WloginAllSigInfo)localObject4).put_siginfo(paramLong2, paramArrayOfByte1, paramLong5);
            localTreeMap.put(new Long(paramLong1), ((WloginAllSigInfo)localObject4).get_clone());
            i = a(localTreeMap, "tk_file");
            if (i != 0)
            {
              paramArrayOfByte1 = (WloginSigInfo)((WloginAllSigInfo)localObject4)._tk_map.get(new Long(paramLong2));
              if (paramArrayOfByte1 != null)
              {
                paramArrayOfByte1._en_A1 = ((byte[])((byte[])localObject5).clone());
                paramArrayOfByte1._noPicSig = ((byte[])((byte[])localObject3).clone());
                paramArrayOfByte1._G = ((byte[])arrayOfByte.clone());
                paramArrayOfByte1._dpwd = ((byte[])((byte[])localObject2).clone());
                paramArrayOfByte1._randseed = ((byte[])((byte[])localObject1).clone());
              }
            }
            this.c.put(new Long(paramLong1), ((WloginAllSigInfo)localObject4).get_clone());
            util.LOGI("after put_siginfo", "" + paramLong1);
            return i;
          }
        }
        localObject6 = localObject2;
      }
      finally {}
      Object localObject7 = localObject1;
      Object localObject1 = localObject5;
      Object localObject2 = localObject3;
      Object localObject3 = localObject6;
      Object localObject5 = localObject7;
      continue;
      label614:
      continue;
      label617:
      continue;
      label620:
      continue;
      label623:
      Object localObject6 = localObject2;
      localObject7 = localObject1;
      localObject1 = localObject5;
      localObject2 = localObject3;
      localObject3 = localObject6;
      localObject5 = localObject7;
    }
  }
  
  public int a(TreeMap paramTreeMap, String paramString)
  {
    int i = 0;
    if ((paramString == "tk_file") || (paramString == "name_file")) {}
    try
    {
      i = b(paramTreeMap, paramString);
      return i;
    }
    finally
    {
      paramTreeMap = finally;
      throw paramTreeMap;
    }
  }
  
  /* Error */
  public String a(Long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	oicq/wlogin_sdk/request/g:d	Ljava/util/TreeMap;
    //   6: invokevirtual 407	java/util/TreeMap:keySet	()Ljava/util/Set;
    //   9: invokeinterface 413 1 0
    //   14: astore 4
    //   16: aload 4
    //   18: invokeinterface 418 1 0
    //   23: ifeq +52 -> 75
    //   26: aload 4
    //   28: invokeinterface 421 1 0
    //   33: checkcast 60	java/lang/String
    //   36: astore_3
    //   37: aload_0
    //   38: getfield 46	oicq/wlogin_sdk/request/g:d	Ljava/util/TreeMap;
    //   41: aload_3
    //   42: invokevirtual 336	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: checkcast 423	oicq/wlogin_sdk/request/UinInfo
    //   48: astore 5
    //   50: aload 5
    //   52: ifnull -36 -> 16
    //   55: aload 5
    //   57: getfield 427	oicq/wlogin_sdk/request/UinInfo:_uin	Ljava/lang/Long;
    //   60: aload_1
    //   61: invokevirtual 428	java/lang/Long:equals	(Ljava/lang/Object;)Z
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
    //   0	85	0	this	g
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
    label350:
    for (;;)
    {
      try
      {
        ArrayList localArrayList = new ArrayList();
        if (this.a == null) {
          break label350;
        }
        TreeMap localTreeMap = a(this.a, "tk_file");
        if (localTreeMap == null) {
          return localArrayList;
        }
        Iterator localIterator1 = localTreeMap.keySet().iterator();
        if (!localIterator1.hasNext()) {
          break label350;
        }
        Long localLong1 = (Long)localIterator1.next();
        Object localObject3 = (WloginAllSigInfo)this.c.get(new Long(localLong1.longValue()));
        Object localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = (WloginAllSigInfo)localTreeMap.get(new Long(localLong1.longValue()));
          if (localObject1 == null) {
            continue;
          }
          this.c.put(new Long(localLong1.longValue()), localObject1);
        }
        Iterator localIterator2 = ((WloginAllSigInfo)localObject1)._tk_map.keySet().iterator();
        if (localIterator2.hasNext())
        {
          Long localLong2 = (Long)localIterator2.next();
          WloginSigInfo localWloginSigInfo = (WloginSigInfo)((WloginAllSigInfo)localObject1)._tk_map.get(localLong2);
          if (localWloginSigInfo == null) {
            continue;
          }
          String str = a(localLong1);
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
    //   7: getfield 46	oicq/wlogin_sdk/request/g:d	Ljava/util/TreeMap;
    //   10: aload_1
    //   11: invokevirtual 336	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: checkcast 423	oicq/wlogin_sdk/request/UinInfo
    //   17: astore_3
    //   18: aload_3
    //   19: ifnull +60 -> 79
    //   22: new 75	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 480
    //   32: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc_w 482
    //   42: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_3
    //   46: getfield 427	oicq/wlogin_sdk/request/UinInfo:_uin	Ljava/lang/Long;
    //   49: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   52: ldc_w 487
    //   55: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_3
    //   59: invokevirtual 490	oicq/wlogin_sdk/request/UinInfo:getHasPassword	()Z
    //   62: invokevirtual 493	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   65: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: ldc 140
    //   70: invokestatic 176	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_3
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: areturn
    //   79: aload_0
    //   80: getfield 48	oicq/wlogin_sdk/request/g:a	Landroid/content/Context;
    //   83: ifnonnull +8 -> 91
    //   86: aconst_null
    //   87: astore_1
    //   88: goto -13 -> 75
    //   91: aload_0
    //   92: getfield 48	oicq/wlogin_sdk/request/g:a	Landroid/content/Context;
    //   95: ldc 50
    //   97: invokestatic 53	oicq/wlogin_sdk/request/g:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/TreeMap;
    //   100: astore_3
    //   101: aload_3
    //   102: ifnonnull +8 -> 110
    //   105: aconst_null
    //   106: astore_1
    //   107: goto -32 -> 75
    //   110: aload_3
    //   111: aload_1
    //   112: invokevirtual 336	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   115: checkcast 423	oicq/wlogin_sdk/request/UinInfo
    //   118: astore_3
    //   119: aload_3
    //   120: ifnonnull +8 -> 128
    //   123: aconst_null
    //   124: astore_1
    //   125: goto -50 -> 75
    //   128: aload_0
    //   129: getfield 46	oicq/wlogin_sdk/request/g:d	Ljava/util/TreeMap;
    //   132: aload_1
    //   133: aload_3
    //   134: invokevirtual 350	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   137: pop
    //   138: new 75	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   145: ldc_w 495
    //   148: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_1
    //   152: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc_w 482
    //   158: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_3
    //   162: getfield 427	oicq/wlogin_sdk/request/UinInfo:_uin	Ljava/lang/Long;
    //   165: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   168: ldc_w 487
    //   171: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_3
    //   175: invokevirtual 490	oicq/wlogin_sdk/request/UinInfo:getHasPassword	()Z
    //   178: invokevirtual 493	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   181: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: ldc 140
    //   186: invokestatic 176	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   0	199	0	this	g
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
    //   2: ldc_w 498
    //   5: new 75	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 500
    //   15: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: lload_1
    //   19: invokevirtual 375	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   22: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 503	oicq/wlogin_sdk/tools/util:LOGD	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: getfield 44	oicq/wlogin_sdk/request/g:c	Ljava/util/TreeMap;
    //   32: lload_1
    //   33: invokestatic 506	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   36: invokevirtual 336	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast 338	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   42: astore_3
    //   43: aload_3
    //   44: ifnull +7 -> 51
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_3
    //   50: areturn
    //   51: aload_0
    //   52: getfield 48	oicq/wlogin_sdk/request/g:a	Landroid/content/Context;
    //   55: ifnonnull +8 -> 63
    //   58: aconst_null
    //   59: astore_3
    //   60: goto -13 -> 47
    //   63: aload_0
    //   64: getfield 48	oicq/wlogin_sdk/request/g:a	Landroid/content/Context;
    //   67: ldc 58
    //   69: invokestatic 53	oicq/wlogin_sdk/request/g:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/TreeMap;
    //   72: astore_3
    //   73: aload_3
    //   74: ifnonnull +8 -> 82
    //   77: aconst_null
    //   78: astore_3
    //   79: goto -32 -> 47
    //   82: aload_3
    //   83: lload_1
    //   84: invokestatic 506	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   87: invokevirtual 336	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   90: checkcast 338	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   93: astore_3
    //   94: aload_3
    //   95: ifnonnull +8 -> 103
    //   98: aconst_null
    //   99: astore_3
    //   100: goto -53 -> 47
    //   103: aload_0
    //   104: getfield 44	oicq/wlogin_sdk/request/g:c	Ljava/util/TreeMap;
    //   107: lload_1
    //   108: invokestatic 506	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   111: aload_3
    //   112: invokevirtual 350	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   115: pop
    //   116: aload_3
    //   117: invokevirtual 346	oicq/wlogin_sdk/request/WloginAllSigInfo:get_clone	()Loicq/wlogin_sdk/request/WloginAllSigInfo;
    //   120: astore_3
    //   121: goto -74 -> 47
    //   124: astore_3
    //   125: aload_0
    //   126: monitorexit
    //   127: aload_3
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	g
    //   0	129	1	paramLong	long
    //   42	79	3	localObject1	Object
    //   124	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	43	124	finally
    //   51	58	124	finally
    //   63	73	124	finally
    //   82	94	124	finally
    //   103	121	124	finally
  }
  
  /* Error */
  public WloginSigInfo a(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 509
    //   5: new 75	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 500
    //   15: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: lload_1
    //   19: invokevirtual 375	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   22: ldc_w 511
    //   25: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: lload_3
    //   29: invokevirtual 375	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   32: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 503	oicq/wlogin_sdk/tools/util:LOGD	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_0
    //   39: lload_1
    //   40: invokevirtual 513	oicq/wlogin_sdk/request/g:a	(J)Loicq/wlogin_sdk/request/WloginAllSigInfo;
    //   43: astore 5
    //   45: aload 5
    //   47: ifnonnull +11 -> 58
    //   50: aconst_null
    //   51: astore 5
    //   53: aload_0
    //   54: monitorexit
    //   55: aload 5
    //   57: areturn
    //   58: aload 5
    //   60: getfield 357	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   63: lload_3
    //   64: invokestatic 506	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   67: invokevirtual 336	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   70: checkcast 359	oicq/wlogin_sdk/sharemem/WloginSigInfo
    //   73: astore 6
    //   75: aload 6
    //   77: astore 5
    //   79: aload 6
    //   81: ifnonnull -28 -> 53
    //   84: aconst_null
    //   85: astore 5
    //   87: goto -34 -> 53
    //   90: astore 5
    //   92: aload_0
    //   93: monitorexit
    //   94: aload 5
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	g
    //   0	97	1	paramLong1	long
    //   0	97	3	paramLong2	long
    //   43	43	5	localObject1	Object
    //   90	5	5	localObject2	Object
    //   73	7	6	localWloginSigInfo	WloginSigInfo
    // Exception table:
    //   from	to	target	type
    //   2	45	90	finally
    //   58	75	90	finally
  }
  
  public void a()
  {
    try
    {
      util.LOGI("refresh_all_siginfo...", "");
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
  
  public void a(Long paramLong1, Long paramLong2)
  {
    for (;;)
    {
      TreeMap localTreeMap;
      try
      {
        util.LOGI("clear_sig uin=" + paramLong1, "");
        ??? = (WloginAllSigInfo)this.c.get(new Long(paramLong1.longValue()));
        if (??? != null) {
          ((WloginAllSigInfo)???)._tk_map.remove(new Long(paramLong2.longValue()));
        }
        if (this.a != null) {}
        synchronized (e)
        {
          localTreeMap = a(this.a, "tk_file");
          if (localTreeMap == null) {
            return;
          }
          paramLong1 = (WloginAllSigInfo)localTreeMap.get(new Long(paramLong1.longValue()));
          if (paramLong1 != null) {}
        }
        paramLong1._tk_map.remove(new Long(paramLong2.longValue()));
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
    //   3: getfield 46	oicq/wlogin_sdk/request/g:d	Ljava/util/TreeMap;
    //   6: aload_1
    //   7: invokevirtual 521	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: pop
    //   11: aload_0
    //   12: getfield 48	oicq/wlogin_sdk/request/g:a	Landroid/content/Context;
    //   15: ifnull +52 -> 67
    //   18: getstatic 28	oicq/wlogin_sdk/request/g:f	Ljava/lang/Object;
    //   21: astore 4
    //   23: aload 4
    //   25: monitorenter
    //   26: aload_0
    //   27: getfield 48	oicq/wlogin_sdk/request/g:a	Landroid/content/Context;
    //   30: ldc 50
    //   32: invokestatic 53	oicq/wlogin_sdk/request/g:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/TreeMap;
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
    //   52: invokevirtual 521	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: pop
    //   56: aload_0
    //   57: aload_2
    //   58: ldc 50
    //   60: invokevirtual 353	oicq/wlogin_sdk/request/g:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
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
    //   0	81	0	this	g
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
    //   9: ldc_w 524
    //   12: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_1
    //   16: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc_w 526
    //   22: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_2
    //   26: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: ldc 140
    //   34: invokestatic 176	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: new 423	oicq/wlogin_sdk/request/UinInfo
    //   40: dup
    //   41: aload_2
    //   42: iload_3
    //   43: invokespecial 529	oicq/wlogin_sdk/request/UinInfo:<init>	(Ljava/lang/Long;Z)V
    //   46: astore 6
    //   48: aload_0
    //   49: getfield 46	oicq/wlogin_sdk/request/g:d	Ljava/util/TreeMap;
    //   52: aload_1
    //   53: aload 6
    //   55: invokevirtual 350	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   58: pop
    //   59: aload_0
    //   60: getfield 48	oicq/wlogin_sdk/request/g:a	Landroid/content/Context;
    //   63: ifnull +57 -> 120
    //   66: getstatic 28	oicq/wlogin_sdk/request/g:f	Ljava/lang/Object;
    //   69: astore 5
    //   71: aload 5
    //   73: monitorenter
    //   74: aload_0
    //   75: getfield 48	oicq/wlogin_sdk/request/g:a	Landroid/content/Context;
    //   78: ldc 50
    //   80: invokestatic 53	oicq/wlogin_sdk/request/g:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/TreeMap;
    //   83: astore 4
    //   85: aload 4
    //   87: astore_2
    //   88: aload 4
    //   90: ifnonnull +11 -> 101
    //   93: new 41	java/util/TreeMap
    //   96: dup
    //   97: invokespecial 42	java/util/TreeMap:<init>	()V
    //   100: astore_2
    //   101: aload_2
    //   102: aload_1
    //   103: aload 6
    //   105: invokevirtual 350	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   108: pop
    //   109: aload_0
    //   110: aload_2
    //   111: ldc 50
    //   113: invokevirtual 353	oicq/wlogin_sdk/request/g:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   116: pop
    //   117: aload 5
    //   119: monitorexit
    //   120: aload_0
    //   121: monitorexit
    //   122: return
    //   123: astore_1
    //   124: aload 5
    //   126: monitorexit
    //   127: aload_1
    //   128: athrow
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	g
    //   0	134	1	paramString	String
    //   0	134	2	paramLong	Long
    //   0	134	3	paramBoolean	boolean
    //   83	6	4	localTreeMap	TreeMap
    //   46	58	6	localUinInfo	UinInfo
    // Exception table:
    //   from	to	target	type
    //   74	85	123	finally
    //   93	101	123	finally
    //   101	120	123	finally
    //   124	127	123	finally
    //   2	74	129	finally
    //   127	129	129	finally
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
      paramTreeMap = cryptor.encrypt(paramTreeMap, 0, paramTreeMap.length, y.z);
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
  public WloginSimpleInfo b(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 557
    //   5: new 75	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 500
    //   15: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: lload_1
    //   19: invokevirtual 375	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   22: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 503	oicq/wlogin_sdk/tools/util:LOGD	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: lload_1
    //   30: invokevirtual 513	oicq/wlogin_sdk/request/g:a	(J)Loicq/wlogin_sdk/request/WloginAllSigInfo;
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
    //   45: getfield 445	oicq/wlogin_sdk/request/WloginAllSigInfo:_useInfo	Loicq/wlogin_sdk/sharemem/WloginSimpleInfo;
    //   48: invokevirtual 560	oicq/wlogin_sdk/sharemem/WloginSimpleInfo:get_clone	()Loicq/wlogin_sdk/sharemem/WloginSimpleInfo;
    //   51: astore_3
    //   52: goto -12 -> 40
    //   55: astore_3
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_3
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	g
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
    //   3: getfield 46	oicq/wlogin_sdk/request/g:d	Ljava/util/TreeMap;
    //   6: aload_1
    //   7: invokevirtual 521	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: pop
    //   11: new 75	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 562
    //   21: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: ldc 140
    //   33: invokestatic 176	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: getfield 48	oicq/wlogin_sdk/request/g:a	Landroid/content/Context;
    //   40: ifnull +25 -> 65
    //   43: getstatic 28	oicq/wlogin_sdk/request/g:f	Ljava/lang/Object;
    //   46: astore_2
    //   47: aload_2
    //   48: monitorenter
    //   49: aload_0
    //   50: getfield 48	oicq/wlogin_sdk/request/g:a	Landroid/content/Context;
    //   53: ldc 50
    //   55: invokestatic 53	oicq/wlogin_sdk/request/g:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/TreeMap;
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
    //   70: invokevirtual 521	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: pop
    //   74: aload_0
    //   75: aload_3
    //   76: ldc 50
    //   78: invokevirtual 353	oicq/wlogin_sdk/request/g:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
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
    //   0	97	0	this	g
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.g
 * JD-Core Version:    0.7.0.1
 */