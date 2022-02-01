package taiji;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class bf
  extends bb
{
  private Context f;
  private Method g;
  private Method h;
  private Method i;
  private Object j;
  private int k;
  private int l;
  private boolean m;
  
  bf(Context paramContext)
  {
    super(paramContext);
    if (Build.VERSION.SDK_INT < 19) {}
    for (;;)
    {
      return;
      this.f = paramContext;
      try
      {
        Class localClass1 = Class.forName("com.vivo.services.security.client.VivoPermissionManager");
        Class localClass2 = Class.forName("com.vivo.services.security.client.VivoPermissionType");
        Class localClass3 = Class.forName("com.vivo.services.security.client.VivoPermissionInfo");
        Object localObject = Class.forName("android.os.SystemProperties");
        Method localMethod = localClass1.getMethod("getVPM", new Class[] { Context.class });
        localObject = ((Class)localObject).getMethod("get", new Class[] { String.class, String.class });
        Field localField1 = localClass3.getField("DENIED");
        Field localField2 = localClass3.getField("WARNING");
        localField1.setAccessible(true);
        localField2.setAccessible(true);
        this.g = localClass1.getMethod("getAppPermission", new Class[] { String.class });
        this.h = localClass2.getMethod("getVPType", new Class[] { String.class });
        this.i = localClass2.getMethod("getVPTypeId", new Class[0]);
        this.j = localMethod.invoke(null, new Object[] { paramContext });
        this.k = localField1.getInt(localClass3);
        this.l = localField2.getInt(localClass3);
        paramContext = (String)((Method)localObject).invoke(null, new Object[] { "ro.vivo.rom.version", null });
        if ((!TextUtils.isEmpty(paramContext)) && (Float.parseFloat(paramContext.substring(4)) >= 2.5F))
        {
          this.m = true;
          return;
        }
      }
      catch (Throwable paramContext) {}
    }
  }
  
  /* Error */
  private int a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: iconst_5
    //   5: invokespecial 128	taiji/bb:checkPermission	(I)I
    //   8: istore_1
    //   9: iload_1
    //   10: ifne +217 -> 227
    //   13: iconst_2
    //   14: anewarray 130	android/net/Uri
    //   17: astore 6
    //   19: aload 6
    //   21: iconst_0
    //   22: ldc 132
    //   24: invokestatic 136	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   27: aastore
    //   28: aload 6
    //   30: iconst_1
    //   31: ldc 138
    //   33: invokestatic 136	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   36: aastore
    //   37: iconst_0
    //   38: istore_3
    //   39: iload_3
    //   40: aload 6
    //   42: arraylength
    //   43: if_icmpge +165 -> 208
    //   46: aload_0
    //   47: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   50: invokevirtual 142	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   53: aload 6
    //   55: iload_3
    //   56: aaload
    //   57: aconst_null
    //   58: ldc 144
    //   60: iconst_1
    //   61: anewarray 56	java/lang/String
    //   64: dup
    //   65: iconst_0
    //   66: aload_0
    //   67: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   70: invokevirtual 148	android/content/Context:getPackageName	()Ljava/lang/String;
    //   73: aastore
    //   74: aconst_null
    //   75: invokevirtual 154	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   78: astore 4
    //   80: aload 4
    //   82: ifnull +177 -> 259
    //   85: aload 4
    //   87: invokeinterface 160 1 0
    //   92: ifeq +162 -> 254
    //   95: aload 4
    //   97: aload 4
    //   99: iconst_2
    //   100: anewarray 56	java/lang/String
    //   103: dup
    //   104: iconst_0
    //   105: ldc 162
    //   107: aastore
    //   108: dup
    //   109: iconst_1
    //   110: ldc 164
    //   112: aastore
    //   113: iload_3
    //   114: aaload
    //   115: invokeinterface 168 2 0
    //   120: invokeinterface 170 2 0
    //   125: istore_2
    //   126: iload_2
    //   127: ifeq +127 -> 254
    //   130: iconst_m1
    //   131: istore_1
    //   132: iconst_1
    //   133: istore_2
    //   134: aload 4
    //   136: ifnull +10 -> 146
    //   139: aload 4
    //   141: invokeinterface 174 1 0
    //   146: iload_2
    //   147: ifeq +54 -> 201
    //   150: iload_1
    //   151: ireturn
    //   152: astore 4
    //   154: goto -8 -> 146
    //   157: astore 4
    //   159: aconst_null
    //   160: astore 4
    //   162: iconst_0
    //   163: istore_2
    //   164: aload 4
    //   166: ifnull +10 -> 176
    //   169: aload 4
    //   171: invokeinterface 174 1 0
    //   176: goto -30 -> 146
    //   179: astore 4
    //   181: goto -35 -> 146
    //   184: astore 4
    //   186: aload 5
    //   188: ifnull +10 -> 198
    //   191: aload 5
    //   193: invokeinterface 174 1 0
    //   198: aload 4
    //   200: athrow
    //   201: iload_3
    //   202: iconst_1
    //   203: iadd
    //   204: istore_3
    //   205: goto -166 -> 39
    //   208: getstatic 179	taiji/ba:a	Ltmsdk/common/module/pgsdk/IPermissionChecker;
    //   211: astore 4
    //   213: aload 4
    //   215: ifnull +12 -> 227
    //   218: aload 4
    //   220: iconst_5
    //   221: invokeinterface 182 2 0
    //   226: ireturn
    //   227: iload_1
    //   228: ireturn
    //   229: astore 5
    //   231: goto -33 -> 198
    //   234: astore 6
    //   236: aload 4
    //   238: astore 5
    //   240: aload 6
    //   242: astore 4
    //   244: goto -58 -> 186
    //   247: astore 7
    //   249: iconst_1
    //   250: istore_2
    //   251: goto -87 -> 164
    //   254: iconst_1
    //   255: istore_2
    //   256: goto -122 -> 134
    //   259: iconst_0
    //   260: istore_2
    //   261: goto -127 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	bf
    //   8	220	1	n	int
    //   125	136	2	i1	int
    //   38	167	3	i2	int
    //   78	62	4	localCursor	Cursor
    //   152	1	4	localThrowable1	Throwable
    //   157	1	4	localThrowable2	Throwable
    //   160	10	4	localObject1	Object
    //   179	1	4	localThrowable3	Throwable
    //   184	15	4	localObject2	Object
    //   211	32	4	localObject3	Object
    //   1	191	5	localObject4	Object
    //   229	1	5	localThrowable4	Throwable
    //   238	1	5	localObject5	Object
    //   17	37	6	arrayOfUri	Uri[]
    //   234	7	6	localObject6	Object
    //   247	1	7	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   139	146	152	java/lang/Throwable
    //   46	80	157	java/lang/Throwable
    //   169	176	179	java/lang/Throwable
    //   46	80	184	finally
    //   191	198	229	java/lang/Throwable
    //   85	126	234	finally
    //   85	126	247	java/lang/Throwable
  }
  
  /* Error */
  private int a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   4: ifnull +31 -> 35
    //   7: aload_0
    //   8: getfield 74	taiji/bf:g	Ljava/lang/reflect/Method;
    //   11: ifnull +24 -> 35
    //   14: aload_0
    //   15: getfield 78	taiji/bf:h	Ljava/lang/reflect/Method;
    //   18: ifnull +17 -> 35
    //   21: aload_0
    //   22: getfield 82	taiji/bf:i	Ljava/lang/reflect/Method;
    //   25: ifnull +10 -> 35
    //   28: aload_0
    //   29: getfield 92	taiji/bf:j	Ljava/lang/Object;
    //   32: ifnonnull +5 -> 37
    //   35: iconst_0
    //   36: ireturn
    //   37: aload_0
    //   38: getfield 74	taiji/bf:g	Ljava/lang/reflect/Method;
    //   41: aload_0
    //   42: getfield 92	taiji/bf:j	Ljava/lang/Object;
    //   45: iconst_1
    //   46: anewarray 84	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: aload_0
    //   52: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   55: invokevirtual 148	android/content/Context:getPackageName	()Ljava/lang/String;
    //   58: aastore
    //   59: invokevirtual 90	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   62: astore 5
    //   64: aload 5
    //   66: invokevirtual 187	java/lang/Object:getClass	()Ljava/lang/Class;
    //   69: ldc 189
    //   71: invokevirtual 192	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   74: astore 6
    //   76: aload 6
    //   78: iconst_1
    //   79: invokevirtual 70	java/lang/reflect/Field:setAccessible	(Z)V
    //   82: aload 6
    //   84: aload 5
    //   86: invokevirtual 195	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   89: checkcast 197	[I
    //   92: checkcast 197	[I
    //   95: astore 5
    //   97: aload_0
    //   98: getfield 78	taiji/bf:h	Ljava/lang/reflect/Method;
    //   101: aconst_null
    //   102: iconst_1
    //   103: anewarray 84	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: aload_2
    //   109: aastore
    //   110: invokevirtual 90	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   113: astore_2
    //   114: aload_0
    //   115: getfield 82	taiji/bf:i	Ljava/lang/reflect/Method;
    //   118: aload_2
    //   119: iconst_0
    //   120: anewarray 84	java/lang/Object
    //   123: invokevirtual 90	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   126: astore_2
    //   127: aload_2
    //   128: checkcast 199	java/lang/Integer
    //   131: invokevirtual 202	java/lang/Integer:intValue	()I
    //   134: istore_3
    //   135: iload_3
    //   136: iflt +89 -> 225
    //   139: iload_3
    //   140: aload 5
    //   142: arraylength
    //   143: if_icmpge +82 -> 225
    //   146: aload 5
    //   148: aload_2
    //   149: checkcast 199	java/lang/Integer
    //   152: invokevirtual 202	java/lang/Integer:intValue	()I
    //   155: iaload
    //   156: istore 4
    //   158: iload 4
    //   160: istore_3
    //   161: aload_0
    //   162: getfield 98	taiji/bf:k	I
    //   165: iconst_m1
    //   166: if_icmpeq +8 -> 174
    //   169: iload 4
    //   171: iconst_3
    //   172: iand
    //   173: istore_3
    //   174: iload_3
    //   175: aload_0
    //   176: getfield 98	taiji/bf:k	I
    //   179: if_icmpne +5 -> 184
    //   182: iconst_m1
    //   183: ireturn
    //   184: aload_0
    //   185: getfield 100	taiji/bf:l	I
    //   188: istore 4
    //   190: iload_3
    //   191: iload 4
    //   193: if_icmpne +32 -> 225
    //   196: getstatic 28	android/os/Build$VERSION:SDK_INT	I
    //   199: bipush 26
    //   201: if_icmple +22 -> 223
    //   204: aload_0
    //   205: iload_1
    //   206: invokespecial 128	taiji/bb:checkPermission	(I)I
    //   209: istore_1
    //   210: iload_1
    //   211: iconst_m1
    //   212: if_icmpne +11 -> 223
    //   215: iconst_m1
    //   216: ireturn
    //   217: astore_2
    //   218: iconst_0
    //   219: ireturn
    //   220: astore_2
    //   221: iconst_1
    //   222: ireturn
    //   223: iconst_1
    //   224: ireturn
    //   225: iconst_0
    //   226: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	bf
    //   0	227	1	paramInt	int
    //   0	227	2	paramString	String
    //   134	60	3	n	int
    //   156	38	4	i1	int
    //   62	85	5	localObject	Object
    //   74	9	6	localField	Field
    // Exception table:
    //   from	to	target	type
    //   37	135	217	java/lang/Throwable
    //   139	158	217	java/lang/Throwable
    //   161	169	217	java/lang/Throwable
    //   174	182	217	java/lang/Throwable
    //   184	190	217	java/lang/Throwable
    //   196	210	220	java/lang/Throwable
  }
  
  private String a(String paramString)
  {
    return d(a(paramString.getBytes()));
  }
  
  private void a(StringBuffer paramStringBuffer, byte paramByte)
  {
    paramStringBuffer.append("0123456789ABCDEF".charAt(paramByte >> 4 & 0xF)).append("0123456789ABCDEF".charAt(paramByte & 0xF));
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(b("yyKyeaGqD+iHxz3Vq+Of/Q==".getBytes()), "AES");
    Cipher localCipher = Cipher.getInstance("AES");
    localCipher.init(1, localSecretKeySpec, new IvParameterSpec(new byte[localCipher.getBlockSize()]));
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  /* Error */
  private int b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   7: invokevirtual 142	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   10: ldc_w 262
    //   13: invokestatic 136	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   16: aconst_null
    //   17: ldc 144
    //   19: iconst_1
    //   20: anewarray 56	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: aload_0
    //   26: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   29: invokevirtual 148	android/content/Context:getPackageName	()Ljava/lang/String;
    //   32: aastore
    //   33: aconst_null
    //   34: invokevirtual 154	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   37: astore 5
    //   39: aload 5
    //   41: astore 6
    //   43: aload_0
    //   44: getfield 121	taiji/bf:m	Z
    //   47: istore 4
    //   49: iload 4
    //   51: ifeq +51 -> 102
    //   54: aload 5
    //   56: ifnonnull +25 -> 81
    //   59: iconst_0
    //   60: istore_2
    //   61: iconst_0
    //   62: istore_1
    //   63: aload 5
    //   65: ifnull +10 -> 75
    //   68: aload 5
    //   70: invokeinterface 174 1 0
    //   75: iload_2
    //   76: ifeq +149 -> 225
    //   79: iload_1
    //   80: ireturn
    //   81: aload 5
    //   83: astore 6
    //   85: aload 5
    //   87: invokeinterface 265 1 0
    //   92: ifne +349 -> 441
    //   95: iconst_1
    //   96: istore_2
    //   97: iconst_m1
    //   98: istore_1
    //   99: goto -36 -> 63
    //   102: aload 5
    //   104: ifnull +337 -> 441
    //   107: aload 5
    //   109: astore 6
    //   111: aload 5
    //   113: invokeinterface 265 1 0
    //   118: istore_1
    //   119: iload_1
    //   120: ifle +321 -> 441
    //   123: iconst_1
    //   124: istore_2
    //   125: iconst_m1
    //   126: istore_1
    //   127: goto -64 -> 63
    //   130: astore 6
    //   132: goto -57 -> 75
    //   135: astore 7
    //   137: aconst_null
    //   138: astore 5
    //   140: aload 5
    //   142: astore 6
    //   144: aload 7
    //   146: instanceof 267
    //   149: ifeq +287 -> 436
    //   152: aload 5
    //   154: astore 6
    //   156: aload 7
    //   158: invokevirtual 270	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   161: ldc_w 272
    //   164: invokevirtual 276	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   167: istore 4
    //   169: iload 4
    //   171: ifeq +265 -> 436
    //   174: iconst_0
    //   175: istore_1
    //   176: aload 5
    //   178: ifnull +10 -> 188
    //   181: aload 5
    //   183: invokeinterface 174 1 0
    //   188: iconst_0
    //   189: istore_3
    //   190: iload_1
    //   191: istore_2
    //   192: iload_3
    //   193: istore_1
    //   194: goto -119 -> 75
    //   197: astore 6
    //   199: iconst_0
    //   200: istore_3
    //   201: iload_1
    //   202: istore_2
    //   203: iload_3
    //   204: istore_1
    //   205: goto -130 -> 75
    //   208: astore 5
    //   210: aload 6
    //   212: ifnull +10 -> 222
    //   215: aload 6
    //   217: invokeinterface 174 1 0
    //   222: aload 5
    //   224: athrow
    //   225: aload_0
    //   226: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   229: invokevirtual 142	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   232: astore 6
    //   234: ldc_w 278
    //   237: invokestatic 136	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   240: astore 7
    //   242: aload_0
    //   243: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   246: invokevirtual 148	android/content/Context:getPackageName	()Ljava/lang/String;
    //   249: astore 8
    //   251: aload 6
    //   253: aload 7
    //   255: iconst_1
    //   256: anewarray 56	java/lang/String
    //   259: dup
    //   260: iconst_0
    //   261: ldc_w 280
    //   264: aastore
    //   265: ldc 144
    //   267: iconst_1
    //   268: anewarray 56	java/lang/String
    //   271: dup
    //   272: iconst_0
    //   273: aload 8
    //   275: aastore
    //   276: aconst_null
    //   277: invokevirtual 154	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   280: astore 6
    //   282: aload 6
    //   284: ifnull +149 -> 433
    //   287: aload 6
    //   289: invokeinterface 265 1 0
    //   294: ifle +139 -> 433
    //   297: aload 6
    //   299: invokeinterface 160 1 0
    //   304: ifeq +129 -> 433
    //   307: aload 6
    //   309: iconst_0
    //   310: invokeinterface 170 2 0
    //   315: istore_2
    //   316: iload_2
    //   317: iconst_1
    //   318: if_icmpne +115 -> 433
    //   321: iconst_m1
    //   322: istore_1
    //   323: iload_1
    //   324: istore_2
    //   325: aload 6
    //   327: ifnull +12 -> 339
    //   330: aload 6
    //   332: invokeinterface 174 1 0
    //   337: iload_1
    //   338: istore_2
    //   339: iload_2
    //   340: ireturn
    //   341: astore 6
    //   343: aload 5
    //   345: ifnull +10 -> 355
    //   348: aload 5
    //   350: invokeinterface 174 1 0
    //   355: iload_1
    //   356: istore_2
    //   357: goto -18 -> 339
    //   360: astore 5
    //   362: iload_1
    //   363: istore_2
    //   364: goto -25 -> 339
    //   367: astore 7
    //   369: aload 5
    //   371: astore 6
    //   373: aload 7
    //   375: astore 5
    //   377: aload 6
    //   379: ifnull +10 -> 389
    //   382: aload 6
    //   384: invokeinterface 174 1 0
    //   389: aload 5
    //   391: athrow
    //   392: astore 6
    //   394: goto -172 -> 222
    //   397: astore 5
    //   399: iload_1
    //   400: istore_2
    //   401: goto -62 -> 339
    //   404: astore 6
    //   406: goto -17 -> 389
    //   409: astore 5
    //   411: goto -34 -> 377
    //   414: astore 5
    //   416: aload 6
    //   418: astore 5
    //   420: goto -77 -> 343
    //   423: astore 5
    //   425: goto -215 -> 210
    //   428: astore 7
    //   430: goto -290 -> 140
    //   433: goto -110 -> 323
    //   436: iconst_1
    //   437: istore_1
    //   438: goto -262 -> 176
    //   441: iconst_1
    //   442: istore_2
    //   443: iconst_0
    //   444: istore_1
    //   445: goto -382 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	448	0	this	bf
    //   62	383	1	n	int
    //   60	383	2	i1	int
    //   189	15	3	i2	int
    //   47	123	4	bool	boolean
    //   37	145	5	localCursor	Cursor
    //   208	141	5	localObject1	Object
    //   360	10	5	localThrowable1	Throwable
    //   375	15	5	localObject2	Object
    //   397	1	5	localThrowable2	Throwable
    //   409	1	5	localObject3	Object
    //   414	1	5	localThrowable3	Throwable
    //   418	1	5	localThrowable4	Throwable
    //   423	1	5	localObject4	Object
    //   1	109	6	localObject5	Object
    //   130	1	6	localThrowable5	Throwable
    //   142	13	6	localObject6	Object
    //   197	19	6	localThrowable6	Throwable
    //   232	99	6	localObject7	Object
    //   341	1	6	localThrowable7	Throwable
    //   371	12	6	localObject8	Object
    //   392	1	6	localThrowable8	Throwable
    //   404	13	6	localThrowable9	Throwable
    //   135	22	7	localThrowable10	Throwable
    //   240	14	7	localUri	Uri
    //   367	7	7	localObject9	Object
    //   428	1	7	localThrowable11	Throwable
    //   249	25	8	str	String
    // Exception table:
    //   from	to	target	type
    //   68	75	130	java/lang/Throwable
    //   3	39	135	java/lang/Throwable
    //   181	188	197	java/lang/Throwable
    //   3	39	208	finally
    //   225	282	341	java/lang/Throwable
    //   348	355	360	java/lang/Throwable
    //   225	282	367	finally
    //   215	222	392	java/lang/Throwable
    //   330	337	397	java/lang/Throwable
    //   382	389	404	java/lang/Throwable
    //   287	316	409	finally
    //   287	316	414	java/lang/Throwable
    //   43	49	423	finally
    //   85	95	423	finally
    //   111	119	423	finally
    //   144	152	423	finally
    //   156	169	423	finally
    //   43	49	428	java/lang/Throwable
    //   85	95	428	java/lang/Throwable
    //   111	119	428	java/lang/Throwable
  }
  
  private String b(String paramString)
  {
    return d(c(paramString.getBytes()));
  }
  
  private byte[] b(byte[] paramArrayOfByte)
  {
    KeyGenerator localKeyGenerator = KeyGenerator.getInstance("AES");
    SecureRandom localSecureRandom = SecureRandom.getInstance("SHA1PRNG", "Crypto");
    localSecureRandom.setSeed(paramArrayOfByte);
    localKeyGenerator.init(128, localSecureRandom);
    return localKeyGenerator.generateKey().getEncoded();
  }
  
  /* Error */
  private int c()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_1
    //   4: aconst_null
    //   5: astore 5
    //   7: aload 5
    //   9: astore 4
    //   11: aload_0
    //   12: aload_0
    //   13: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   16: invokevirtual 148	android/content/Context:getPackageName	()Ljava/lang/String;
    //   19: invokespecial 314	taiji/bf:a	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 6
    //   24: aload 5
    //   26: astore 4
    //   28: aload_0
    //   29: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   32: invokevirtual 142	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   35: ldc_w 316
    //   38: invokestatic 136	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   41: aconst_null
    //   42: ldc_w 318
    //   45: iconst_1
    //   46: anewarray 56	java/lang/String
    //   49: dup
    //   50: iconst_0
    //   51: aload 6
    //   53: aastore
    //   54: aconst_null
    //   55: invokevirtual 154	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   58: astore 6
    //   60: aload 6
    //   62: ifnonnull +19 -> 81
    //   65: aload 6
    //   67: ifnull +10 -> 77
    //   70: aload 6
    //   72: invokeinterface 174 1 0
    //   77: iconst_2
    //   78: istore_2
    //   79: iload_2
    //   80: ireturn
    //   81: aload 6
    //   83: astore 4
    //   85: aload 6
    //   87: astore 5
    //   89: aload 6
    //   91: invokeinterface 265 1 0
    //   96: ifle +72 -> 168
    //   99: aload 6
    //   101: astore 4
    //   103: aload 6
    //   105: astore 5
    //   107: aload 6
    //   109: invokeinterface 160 1 0
    //   114: ifeq +54 -> 168
    //   117: aload 6
    //   119: astore 4
    //   121: aload 6
    //   123: astore 5
    //   125: aload 6
    //   127: aload 6
    //   129: ldc_w 320
    //   132: invokeinterface 168 2 0
    //   137: invokeinterface 170 2 0
    //   142: istore_1
    //   143: iload_1
    //   144: ifne +19 -> 163
    //   147: iconst_0
    //   148: istore_1
    //   149: aload 6
    //   151: ifnull +10 -> 161
    //   154: aload 6
    //   156: invokeinterface 174 1 0
    //   161: iload_1
    //   162: ireturn
    //   163: iconst_m1
    //   164: istore_1
    //   165: goto -16 -> 149
    //   168: aload 6
    //   170: astore 4
    //   172: aload 6
    //   174: astore 5
    //   176: aload_0
    //   177: aload_0
    //   178: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   181: invokevirtual 148	android/content/Context:getPackageName	()Ljava/lang/String;
    //   184: invokespecial 322	taiji/bf:b	(Ljava/lang/String;)Ljava/lang/String;
    //   187: astore 7
    //   189: aload 6
    //   191: astore 4
    //   193: aload 6
    //   195: astore 5
    //   197: aload_0
    //   198: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   201: invokevirtual 142	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   204: ldc_w 316
    //   207: invokestatic 136	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   210: aconst_null
    //   211: ldc_w 318
    //   214: iconst_1
    //   215: anewarray 56	java/lang/String
    //   218: dup
    //   219: iconst_0
    //   220: aload 7
    //   222: aastore
    //   223: aconst_null
    //   224: invokevirtual 154	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   227: astore 6
    //   229: aload 6
    //   231: ifnonnull +17 -> 248
    //   234: aload 6
    //   236: ifnull +10 -> 246
    //   239: aload 6
    //   241: invokeinterface 174 1 0
    //   246: iconst_2
    //   247: ireturn
    //   248: aload 6
    //   250: astore 4
    //   252: aload 6
    //   254: astore 5
    //   256: aload 6
    //   258: invokeinterface 265 1 0
    //   263: ifle +76 -> 339
    //   266: aload 6
    //   268: astore 4
    //   270: aload 6
    //   272: astore 5
    //   274: aload 6
    //   276: invokeinterface 160 1 0
    //   281: ifeq +58 -> 339
    //   284: aload 6
    //   286: astore 4
    //   288: aload 6
    //   290: astore 5
    //   292: aload 6
    //   294: aload 6
    //   296: ldc_w 320
    //   299: invokeinterface 168 2 0
    //   304: invokeinterface 170 2 0
    //   309: istore_2
    //   310: iload_2
    //   311: ifne +23 -> 334
    //   314: iload_1
    //   315: istore_2
    //   316: aload 6
    //   318: ifnull -239 -> 79
    //   321: aload 6
    //   323: invokeinterface 174 1 0
    //   328: iload_1
    //   329: ireturn
    //   330: astore 4
    //   332: iload_1
    //   333: ireturn
    //   334: iconst_m1
    //   335: istore_1
    //   336: goto -22 -> 314
    //   339: aload 6
    //   341: astore 4
    //   343: aload 6
    //   345: astore 5
    //   347: aload_0
    //   348: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   351: invokevirtual 142	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   354: ldc_w 316
    //   357: invokestatic 136	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   360: iconst_2
    //   361: anewarray 56	java/lang/String
    //   364: dup
    //   365: iconst_0
    //   366: ldc_w 324
    //   369: aastore
    //   370: dup
    //   371: iconst_1
    //   372: ldc_w 320
    //   375: aastore
    //   376: aconst_null
    //   377: aconst_null
    //   378: aconst_null
    //   379: invokevirtual 154	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   382: astore 6
    //   384: aload 6
    //   386: astore 4
    //   388: aload 4
    //   390: ifnonnull +17 -> 407
    //   393: aload 4
    //   395: ifnull +10 -> 405
    //   398: aload 4
    //   400: invokeinterface 174 1 0
    //   405: iconst_2
    //   406: ireturn
    //   407: aload 4
    //   409: invokeinterface 160 1 0
    //   414: ifeq +189 -> 603
    //   417: aload 4
    //   419: aload 4
    //   421: ldc_w 324
    //   424: invokeinterface 168 2 0
    //   429: invokeinterface 327 2 0
    //   434: astore 5
    //   436: aload 4
    //   438: aload 4
    //   440: ldc_w 320
    //   443: invokeinterface 168 2 0
    //   448: invokeinterface 170 2 0
    //   453: istore_1
    //   454: aload 5
    //   456: aload_0
    //   457: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   460: invokevirtual 148	android/content/Context:getPackageName	()Ljava/lang/String;
    //   463: invokestatic 331	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   466: istore_3
    //   467: iload_3
    //   468: ifeq -61 -> 407
    //   471: iload_1
    //   472: ifne +25 -> 497
    //   475: iload_2
    //   476: istore_1
    //   477: iload_1
    //   478: istore_2
    //   479: aload 4
    //   481: ifnull -402 -> 79
    //   484: aload 4
    //   486: invokeinterface 174 1 0
    //   491: iload_1
    //   492: ireturn
    //   493: astore 4
    //   495: iload_1
    //   496: ireturn
    //   497: iconst_m1
    //   498: istore_1
    //   499: goto -22 -> 477
    //   502: astore 4
    //   504: aconst_null
    //   505: astore 4
    //   507: aload 4
    //   509: ifnull +10 -> 519
    //   512: aload 4
    //   514: invokeinterface 174 1 0
    //   519: iconst_2
    //   520: ireturn
    //   521: astore 6
    //   523: aload 4
    //   525: astore 5
    //   527: aload 6
    //   529: astore 4
    //   531: aload 5
    //   533: ifnull +10 -> 543
    //   536: aload 5
    //   538: invokeinterface 174 1 0
    //   543: aload 4
    //   545: athrow
    //   546: astore 4
    //   548: goto -471 -> 77
    //   551: astore 4
    //   553: goto -392 -> 161
    //   556: astore 4
    //   558: goto -312 -> 246
    //   561: astore 4
    //   563: goto -158 -> 405
    //   566: astore 4
    //   568: goto -49 -> 519
    //   571: astore 5
    //   573: goto -30 -> 543
    //   576: astore 6
    //   578: aload 4
    //   580: astore 5
    //   582: aload 6
    //   584: astore 4
    //   586: goto -55 -> 531
    //   589: astore 4
    //   591: aload 5
    //   593: astore 4
    //   595: goto -88 -> 507
    //   598: astore 5
    //   600: goto -93 -> 507
    //   603: iconst_m1
    //   604: istore_1
    //   605: goto -128 -> 477
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	608	0	this	bf
    //   3	602	1	n	int
    //   1	478	2	i1	int
    //   466	2	3	bool	boolean
    //   9	278	4	localObject1	Object
    //   330	1	4	localThrowable1	Throwable
    //   341	144	4	localObject2	Object
    //   493	1	4	localThrowable2	Throwable
    //   502	1	4	localThrowable3	Throwable
    //   505	39	4	localObject3	Object
    //   546	1	4	localThrowable4	Throwable
    //   551	1	4	localThrowable5	Throwable
    //   556	1	4	localThrowable6	Throwable
    //   561	1	4	localThrowable7	Throwable
    //   566	13	4	localThrowable8	Throwable
    //   584	1	4	localObject4	Object
    //   589	1	4	localThrowable9	Throwable
    //   593	1	4	localObject5	Object
    //   5	532	5	localObject6	Object
    //   571	1	5	localThrowable10	Throwable
    //   580	12	5	localObject7	Object
    //   598	1	5	localThrowable11	Throwable
    //   22	363	6	localObject8	Object
    //   521	7	6	localObject9	Object
    //   576	7	6	localObject10	Object
    //   187	34	7	str	String
    // Exception table:
    //   from	to	target	type
    //   321	328	330	java/lang/Throwable
    //   484	491	493	java/lang/Throwable
    //   11	24	502	java/lang/Throwable
    //   28	60	502	java/lang/Throwable
    //   11	24	521	finally
    //   28	60	521	finally
    //   89	99	521	finally
    //   107	117	521	finally
    //   125	143	521	finally
    //   176	189	521	finally
    //   197	229	521	finally
    //   256	266	521	finally
    //   274	284	521	finally
    //   292	310	521	finally
    //   347	384	521	finally
    //   70	77	546	java/lang/Throwable
    //   154	161	551	java/lang/Throwable
    //   239	246	556	java/lang/Throwable
    //   398	405	561	java/lang/Throwable
    //   512	519	566	java/lang/Throwable
    //   536	543	571	java/lang/Throwable
    //   407	467	576	finally
    //   89	99	589	java/lang/Throwable
    //   107	117	589	java/lang/Throwable
    //   125	143	589	java/lang/Throwable
    //   176	189	589	java/lang/Throwable
    //   197	229	589	java/lang/Throwable
    //   256	266	589	java/lang/Throwable
    //   274	284	589	java/lang/Throwable
    //   292	310	589	java/lang/Throwable
    //   347	384	589	java/lang/Throwable
    //   407	467	598	java/lang/Throwable
  }
  
  private byte[] c(byte[] paramArrayOfByte)
  {
    SecretKeySpec localSecretKeySpec = new SecretKeySpec("yyKyeaGqD+iHxz3V".getBytes(), "AES");
    Cipher localCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    localCipher.init(1, localSecretKeySpec);
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  private int d()
  {
    String str = this.f.getPackageName();
    do
    {
      for (;;)
      {
        try
        {
          localObject3 = this.f.getContentResolver();
          localObject1 = ((ContentResolver)localObject3).query(Uri.parse("content://com.vivo.upslide.speedup.provider/speedupwhitelist"), new String[] { "pkgname" }, "pkgname=?", new String[] { str }, null);
          if (localObject1 != null) {
            continue;
          }
        }
        catch (Throwable localThrowable2)
        {
          Object localObject3;
          Object localObject1;
          int i1;
          boolean bool;
          Object localObject2 = null;
          int n = 2;
          continue;
          continue;
        }
        try
        {
          localObject3 = ((ContentResolver)localObject3).query(Uri.parse("content://com.iqoo.secure.provider.secureprovider/speedupwhitelist"), new String[] { "pkgname" }, "pkgname=?", new String[] { str }, null);
          localObject1 = localObject3;
          if (localObject1 == null)
          {
            i1 = 2;
            return i1;
          }
        }
        catch (Throwable localThrowable3)
        {
          continue;
        }
        try
        {
          if (!((Cursor)localObject1).moveToNext()) {
            continue;
          }
          bool = TextUtils.equals(((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("pkgname")), str);
          if (bool) {
            n = 0;
          }
        }
        catch (Throwable localThrowable4)
        {
          continue;
          n = -1;
        }
      }
      i1 = n;
    } while (localObject1 == null);
    try
    {
      ((Cursor)localObject1).close();
      return n;
    }
    catch (Throwable localThrowable1)
    {
      return n;
    }
  }
  
  private String d(byte[] paramArrayOfByte)
  {
    Object localObject = "";
    if (paramArrayOfByte != null)
    {
      localObject = new StringBuffer(paramArrayOfByte.length * 2);
      int n = 0;
      while (n < paramArrayOfByte.length)
      {
        a((StringBuffer)localObject, paramArrayOfByte[n]);
        n += 1;
      }
      localObject = ((StringBuffer)localObject).toString();
    }
    return localObject;
  }
  
  /* Error */
  private int e()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 28	android/os/Build$VERSION:SDK_INT	I
    //   5: bipush 24
    //   7: if_icmplt +163 -> 170
    //   10: aload_0
    //   11: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   14: invokevirtual 142	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   17: astore_2
    //   18: ldc_w 357
    //   21: invokestatic 136	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   24: astore 4
    //   26: aload_0
    //   27: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   30: invokevirtual 148	android/content/Context:getPackageName	()Ljava/lang/String;
    //   33: astore 5
    //   35: aload_2
    //   36: aload 4
    //   38: iconst_1
    //   39: anewarray 56	java/lang/String
    //   42: dup
    //   43: iconst_0
    //   44: ldc_w 280
    //   47: aastore
    //   48: ldc 144
    //   50: iconst_1
    //   51: anewarray 56	java/lang/String
    //   54: dup
    //   55: iconst_0
    //   56: aload 5
    //   58: aastore
    //   59: aconst_null
    //   60: invokevirtual 154	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   63: astore_2
    //   64: aload_2
    //   65: ifnull +100 -> 165
    //   68: aload_2
    //   69: invokeinterface 265 1 0
    //   74: ifle +91 -> 165
    //   77: aload_2
    //   78: invokeinterface 160 1 0
    //   83: ifeq +82 -> 165
    //   86: aload_2
    //   87: iconst_0
    //   88: invokeinterface 170 2 0
    //   93: istore_1
    //   94: iload_1
    //   95: iconst_1
    //   96: if_icmpne +69 -> 165
    //   99: iconst_m1
    //   100: istore_1
    //   101: aload_2
    //   102: ifnull +9 -> 111
    //   105: aload_2
    //   106: invokeinterface 174 1 0
    //   111: iload_1
    //   112: ireturn
    //   113: astore_2
    //   114: aconst_null
    //   115: astore_2
    //   116: aload_2
    //   117: ifnull +9 -> 126
    //   120: aload_2
    //   121: invokeinterface 174 1 0
    //   126: iconst_0
    //   127: ireturn
    //   128: astore_2
    //   129: iconst_0
    //   130: ireturn
    //   131: astore_2
    //   132: aload_3
    //   133: ifnull +9 -> 142
    //   136: aload_3
    //   137: invokeinterface 174 1 0
    //   142: aload_2
    //   143: athrow
    //   144: astore_2
    //   145: iload_1
    //   146: ireturn
    //   147: astore_3
    //   148: goto -6 -> 142
    //   151: astore 4
    //   153: aload_2
    //   154: astore_3
    //   155: aload 4
    //   157: astore_2
    //   158: goto -26 -> 132
    //   161: astore_3
    //   162: goto -46 -> 116
    //   165: iconst_0
    //   166: istore_1
    //   167: goto -66 -> 101
    //   170: iconst_0
    //   171: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	bf
    //   93	74	1	n	int
    //   17	89	2	localObject1	Object
    //   113	1	2	localThrowable1	Throwable
    //   115	6	2	localObject2	Object
    //   128	1	2	localThrowable2	Throwable
    //   131	12	2	localObject3	Object
    //   144	10	2	localThrowable3	Throwable
    //   157	1	2	localObject4	Object
    //   1	136	3	localObject5	Object
    //   147	1	3	localThrowable4	Throwable
    //   154	1	3	localObject6	Object
    //   161	1	3	localThrowable5	Throwable
    //   24	13	4	localUri	Uri
    //   151	5	4	localObject7	Object
    //   33	24	5	str	String
    // Exception table:
    //   from	to	target	type
    //   10	64	113	java/lang/Throwable
    //   120	126	128	java/lang/Throwable
    //   10	64	131	finally
    //   105	111	144	java/lang/Throwable
    //   136	142	147	java/lang/Throwable
    //   68	94	151	finally
    //   68	94	161	java/lang/Throwable
  }
  
  /* Error */
  private int f()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 28	android/os/Build$VERSION:SDK_INT	I
    //   5: bipush 24
    //   7: if_icmplt +163 -> 170
    //   10: aload_0
    //   11: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   14: invokevirtual 142	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   17: astore_2
    //   18: ldc_w 359
    //   21: invokestatic 136	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   24: astore 4
    //   26: aload_0
    //   27: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   30: invokevirtual 148	android/content/Context:getPackageName	()Ljava/lang/String;
    //   33: astore 5
    //   35: aload_2
    //   36: aload 4
    //   38: iconst_1
    //   39: anewarray 56	java/lang/String
    //   42: dup
    //   43: iconst_0
    //   44: ldc_w 280
    //   47: aastore
    //   48: ldc 144
    //   50: iconst_1
    //   51: anewarray 56	java/lang/String
    //   54: dup
    //   55: iconst_0
    //   56: aload 5
    //   58: aastore
    //   59: aconst_null
    //   60: invokevirtual 154	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   63: astore_2
    //   64: aload_2
    //   65: ifnull +100 -> 165
    //   68: aload_2
    //   69: invokeinterface 265 1 0
    //   74: ifle +91 -> 165
    //   77: aload_2
    //   78: invokeinterface 160 1 0
    //   83: ifeq +82 -> 165
    //   86: aload_2
    //   87: iconst_0
    //   88: invokeinterface 170 2 0
    //   93: istore_1
    //   94: iload_1
    //   95: iconst_1
    //   96: if_icmpne +69 -> 165
    //   99: iconst_m1
    //   100: istore_1
    //   101: aload_2
    //   102: ifnull +9 -> 111
    //   105: aload_2
    //   106: invokeinterface 174 1 0
    //   111: iload_1
    //   112: ireturn
    //   113: astore_2
    //   114: aconst_null
    //   115: astore_2
    //   116: aload_2
    //   117: ifnull +9 -> 126
    //   120: aload_2
    //   121: invokeinterface 174 1 0
    //   126: iconst_0
    //   127: ireturn
    //   128: astore_2
    //   129: iconst_0
    //   130: ireturn
    //   131: astore_2
    //   132: aload_3
    //   133: ifnull +9 -> 142
    //   136: aload_3
    //   137: invokeinterface 174 1 0
    //   142: aload_2
    //   143: athrow
    //   144: astore_2
    //   145: iload_1
    //   146: ireturn
    //   147: astore_3
    //   148: goto -6 -> 142
    //   151: astore 4
    //   153: aload_2
    //   154: astore_3
    //   155: aload 4
    //   157: astore_2
    //   158: goto -26 -> 132
    //   161: astore_3
    //   162: goto -46 -> 116
    //   165: iconst_0
    //   166: istore_1
    //   167: goto -66 -> 101
    //   170: iconst_0
    //   171: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	bf
    //   93	74	1	n	int
    //   17	89	2	localObject1	Object
    //   113	1	2	localThrowable1	Throwable
    //   115	6	2	localObject2	Object
    //   128	1	2	localThrowable2	Throwable
    //   131	12	2	localObject3	Object
    //   144	10	2	localThrowable3	Throwable
    //   157	1	2	localObject4	Object
    //   1	136	3	localObject5	Object
    //   147	1	3	localThrowable4	Throwable
    //   154	1	3	localObject6	Object
    //   161	1	3	localThrowable5	Throwable
    //   24	13	4	localUri	Uri
    //   151	5	4	localObject7	Object
    //   33	24	5	str	String
    // Exception table:
    //   from	to	target	type
    //   10	64	113	java/lang/Throwable
    //   120	126	128	java/lang/Throwable
    //   10	64	131	finally
    //   105	111	144	java/lang/Throwable
    //   136	142	147	java/lang/Throwable
    //   68	94	151	finally
    //   68	94	161	java/lang/Throwable
  }
  
  private boolean g()
  {
    try
    {
      RingtoneManager.setActualDefaultRingtoneUri(this.f, 1, RingtoneManager.getActualDefaultRingtoneUri(this.f, 1));
      return true;
    }
    catch (SecurityException localSecurityException)
    {
      return false;
    }
    catch (Throwable localThrowable) {}
    return true;
  }
  
  public int checkPermission(int paramInt)
  {
    int n = 0;
    if (Build.VERSION.SDK_INT < 19) {
      paramInt = n;
    }
    do
    {
      do
      {
        return paramInt;
        switch (paramInt)
        {
        case 7: 
        case 17: 
        case 33: 
        case 44: 
        case 45: 
        case 47: 
        default: 
          return 0;
        case 1: 
          return a(paramInt, "android.permission.READ_PHONE_STATE");
        case 2: 
          return a(paramInt, "android.permission.WRITE_EXTERNAL_STORAGE");
        case 9: 
          return a(paramInt, "android.permission.PROCESS_OUTGOING_CALLS");
        case 10: 
          return a(paramInt, "android.permission.CALL_PHONE");
        case 11: 
          return a(paramInt, "android.permission.READ_CALL_LOG");
        case 12: 
        case 13: 
          return a(paramInt, "android.permission.WRITE_CALL_LOG");
        case 14: 
        case 18: 
          return a(paramInt, "android.permission.READ_SMS");
        case 15: 
          return a(paramInt, "android.permission.WRITE_SMS");
        case 16: 
          return a(paramInt, "android.permission.SEND_SMS");
        case 19: 
          return a(paramInt, "android.permission.WRITE_MMS");
        case 20: 
          return a(paramInt, "android.permission.SEND_MMS");
        case 21: 
          return a(paramInt, "android.permission.READ_CONTACTS");
        case 22: 
        case 23: 
          return a(paramInt, "android.permission.WRITE_CONTACTS");
        case 24: 
          return a(paramInt, "android.permission.ACCESS_FINE_LOCATION");
        case 26: 
          return a(paramInt, "com.android.launcher.permission.INSTALL_SHORTCUT");
        case 27: 
          return a(paramInt, "android.permission.READ_CALENDAR");
        case 28: 
          return a(paramInt, "android.permission.WRITE_CALENDAR");
        case 29: 
          return a(paramInt, "android.permission.CAMERA");
        case 30: 
          return a(paramInt, "android.permission.RECORD_AUDIO");
        case 31: 
          n = a(paramInt, "android.permission.WRITE_SETTINGS");
          paramInt = n;
        }
      } while (n != 0);
      paramInt = n;
    } while (g());
    return -1;
    return a(paramInt, "android.permission.GET_ACCOUNTS");
    return a(paramInt, "android.permission.CHANGE_WIFI_STATE");
    return a(paramInt, "android.permission.BLUETOOTH");
    return a();
    return b();
    return e();
    return c();
    return d();
    return f();
    return super.checkPermission(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.bf
 * JD-Core Version:    0.7.0.1
 */