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
    if (Build.VERSION.SDK_INT < 19) {
      return;
    }
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
      if ((!TextUtils.isEmpty(paramContext)) && (Float.parseFloat(paramContext.substring(4)) >= 2.5F)) {
        this.m = true;
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  /* Error */
  private int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_5
    //   2: invokespecial 128	taiji/bb:checkPermission	(I)I
    //   5: istore_1
    //   6: iload_1
    //   7: istore_2
    //   8: iload_1
    //   9: ifne +260 -> 269
    //   12: iconst_2
    //   13: anewarray 130	android/net/Uri
    //   16: astore 9
    //   18: aload 9
    //   20: iconst_0
    //   21: ldc 132
    //   23: invokestatic 136	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   26: aastore
    //   27: aload 9
    //   29: iconst_1
    //   30: ldc 138
    //   32: invokestatic 136	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   35: aastore
    //   36: iconst_0
    //   37: istore 5
    //   39: iload 5
    //   41: aload 9
    //   43: arraylength
    //   44: if_icmpge +204 -> 248
    //   47: aconst_null
    //   48: astore 8
    //   50: aconst_null
    //   51: astore 7
    //   53: aload_0
    //   54: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   57: invokevirtual 142	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   60: aload 9
    //   62: iload 5
    //   64: aaload
    //   65: aconst_null
    //   66: ldc 144
    //   68: iconst_1
    //   69: anewarray 56	java/lang/String
    //   72: dup
    //   73: iconst_0
    //   74: aload_0
    //   75: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   78: invokevirtual 148	android/content/Context:getPackageName	()Ljava/lang/String;
    //   81: aastore
    //   82: aconst_null
    //   83: invokevirtual 154	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   86: astore 6
    //   88: aload 6
    //   90: ifnull +77 -> 167
    //   93: iload_1
    //   94: istore_2
    //   95: aload 6
    //   97: astore 7
    //   99: aload 6
    //   101: invokeinterface 160 1 0
    //   106: ifeq +47 -> 153
    //   109: aload 6
    //   111: astore 7
    //   113: aload 6
    //   115: aload 6
    //   117: iconst_2
    //   118: anewarray 56	java/lang/String
    //   121: dup
    //   122: iconst_0
    //   123: ldc 162
    //   125: aastore
    //   126: dup
    //   127: iconst_1
    //   128: ldc 164
    //   130: aastore
    //   131: iload 5
    //   133: aaload
    //   134: invokeinterface 168 2 0
    //   139: invokeinterface 170 2 0
    //   144: istore_3
    //   145: iload_1
    //   146: istore_2
    //   147: iload_3
    //   148: ifeq +5 -> 153
    //   151: iconst_m1
    //   152: istore_2
    //   153: iconst_1
    //   154: istore_3
    //   155: iload_2
    //   156: istore_1
    //   157: iload_3
    //   158: istore_2
    //   159: goto +10 -> 169
    //   162: iconst_1
    //   163: istore_2
    //   164: goto +53 -> 217
    //   167: iconst_0
    //   168: istore_2
    //   169: iload_1
    //   170: istore_3
    //   171: iload_2
    //   172: istore 4
    //   174: aload 6
    //   176: ifnull +54 -> 230
    //   179: aload 6
    //   181: invokeinterface 174 1 0
    //   186: iload_1
    //   187: istore_3
    //   188: iload_2
    //   189: istore 4
    //   191: goto +39 -> 230
    //   194: astore 6
    //   196: aload 7
    //   198: ifnull +10 -> 208
    //   201: aload 7
    //   203: invokeinterface 174 1 0
    //   208: aload 6
    //   210: athrow
    //   211: iconst_0
    //   212: istore_2
    //   213: aload 8
    //   215: astore 6
    //   217: iload_1
    //   218: istore_3
    //   219: iload_2
    //   220: istore 4
    //   222: aload 6
    //   224: ifnull +6 -> 230
    //   227: goto -48 -> 179
    //   230: iload 4
    //   232: ifeq +5 -> 237
    //   235: iload_3
    //   236: ireturn
    //   237: iload 5
    //   239: iconst_1
    //   240: iadd
    //   241: istore 5
    //   243: iload_3
    //   244: istore_1
    //   245: goto -206 -> 39
    //   248: getstatic 179	taiji/ba:a	Ltmsdk/common/module/pgsdk/IPermissionChecker;
    //   251: astore 6
    //   253: aload 6
    //   255: ifnull +12 -> 267
    //   258: aload 6
    //   260: iconst_5
    //   261: invokeinterface 182 2 0
    //   266: ireturn
    //   267: iload_1
    //   268: istore_2
    //   269: iload_2
    //   270: ireturn
    //   271: astore 6
    //   273: goto -62 -> 211
    //   276: astore 7
    //   278: goto -116 -> 162
    //   281: astore 6
    //   283: iload_1
    //   284: istore_3
    //   285: iload_2
    //   286: istore 4
    //   288: goto -58 -> 230
    //   291: astore 7
    //   293: goto -85 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	this	bf
    //   5	279	1	n	int
    //   7	279	2	i1	int
    //   144	141	3	i2	int
    //   172	115	4	i3	int
    //   37	205	5	i4	int
    //   86	94	6	localCursor	Cursor
    //   194	15	6	localObject1	Object
    //   215	44	6	localObject2	Object
    //   271	1	6	localThrowable1	Throwable
    //   281	1	6	localThrowable2	Throwable
    //   51	151	7	localObject3	Object
    //   276	1	7	localThrowable3	Throwable
    //   291	1	7	localThrowable4	Throwable
    //   48	166	8	localObject4	Object
    //   16	45	9	arrayOfUri	Uri[]
    // Exception table:
    //   from	to	target	type
    //   53	88	194	finally
    //   99	109	194	finally
    //   113	145	194	finally
    //   53	88	271	java/lang/Throwable
    //   99	109	276	java/lang/Throwable
    //   113	145	276	java/lang/Throwable
    //   179	186	281	java/lang/Throwable
    //   201	208	291	java/lang/Throwable
  }
  
  private int a(int paramInt, String paramString)
  {
    Object localObject1 = this.f;
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = this.g;
      if ((localObject2 != null) && (this.h != null) && (this.i != null))
      {
        localObject3 = this.j;
        if (localObject3 == null) {
          return 0;
        }
      }
    }
    try
    {
      localObject1 = ((Method)localObject2).invoke(localObject3, new Object[] { ((Context)localObject1).getPackageName() });
      localObject2 = localObject1.getClass().getDeclaredField("mPermissionResults");
      ((Field)localObject2).setAccessible(true);
      localObject1 = (int[])((Field)localObject2).get(localObject1);
      paramString = this.h.invoke(null, new Object[] { paramString });
      paramString = this.i.invoke(paramString, new Object[0]);
      int n = ((Integer)paramString).intValue();
      if ((n >= 0) && (n < localObject1.length))
      {
        int i1 = localObject1[((Integer)paramString).intValue()];
        n = i1;
        if (this.k != -1) {
          n = i1 & 0x3;
        }
        if (n == this.k) {
          return -1;
        }
        i1 = this.l;
        if (n != i1) {}
      }
    }
    catch (Throwable paramString)
    {
      label223:
      label225:
      break label225;
    }
    try
    {
      if (Build.VERSION.SDK_INT > 26)
      {
        paramInt = super.checkPermission(paramInt);
        if (paramInt == -1) {
          return -1;
        }
      }
    }
    catch (Throwable paramString)
    {
      break label223;
    }
    return 1;
    return 0;
    return 0;
  }
  
  private String a(String paramString)
  {
    return d(a(paramString.getBytes()));
  }
  
  private void a(StringBuffer paramStringBuffer, byte paramByte)
  {
    paramStringBuffer.append("0123456789ABCDEF".charAt(paramByte >> 4 & 0xF));
    paramStringBuffer.append("0123456789ABCDEF".charAt(paramByte & 0xF));
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
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_0
    //   7: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   10: invokevirtual 142	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: ldc_w 262
    //   16: invokestatic 136	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   19: aconst_null
    //   20: ldc 144
    //   22: iconst_1
    //   23: anewarray 56	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: aload_0
    //   29: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   32: invokevirtual 148	android/content/Context:getPackageName	()Ljava/lang/String;
    //   35: aastore
    //   36: aconst_null
    //   37: invokevirtual 154	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   40: astore 8
    //   42: aload 8
    //   44: astore 7
    //   46: aload 8
    //   48: astore 6
    //   50: aload_0
    //   51: getfield 121	taiji/bf:m	Z
    //   54: ifeq +36 -> 90
    //   57: aload 8
    //   59: ifnonnull +10 -> 69
    //   62: iconst_0
    //   63: istore_2
    //   64: iconst_0
    //   65: istore_3
    //   66: goto +58 -> 124
    //   69: aload 8
    //   71: astore 7
    //   73: aload 8
    //   75: astore 6
    //   77: aload 8
    //   79: invokeinterface 265 1 0
    //   84: ifne +36 -> 120
    //   87: goto +28 -> 115
    //   90: aload 8
    //   92: ifnull +28 -> 120
    //   95: aload 8
    //   97: astore 7
    //   99: aload 8
    //   101: astore 6
    //   103: aload 8
    //   105: invokeinterface 265 1 0
    //   110: istore_1
    //   111: iload_1
    //   112: ifle +8 -> 120
    //   115: iconst_m1
    //   116: istore_2
    //   117: goto +5 -> 122
    //   120: iconst_0
    //   121: istore_2
    //   122: iconst_1
    //   123: istore_3
    //   124: aload 8
    //   126: astore 6
    //   128: iload_2
    //   129: istore_1
    //   130: iload_3
    //   131: istore 4
    //   133: aload 8
    //   135: ifnull +89 -> 224
    //   138: aload 8
    //   140: invokeinterface 174 1 0
    //   145: aload 8
    //   147: astore 6
    //   149: iload_2
    //   150: istore_1
    //   151: iload_3
    //   152: istore 4
    //   154: goto +70 -> 224
    //   157: astore 6
    //   159: goto +285 -> 444
    //   162: astore 8
    //   164: aload 6
    //   166: astore 7
    //   168: aload 8
    //   170: instanceof 267
    //   173: ifeq +30 -> 203
    //   176: aload 6
    //   178: astore 7
    //   180: aload 8
    //   182: invokevirtual 270	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   185: ldc_w 272
    //   188: invokevirtual 276	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   191: istore 5
    //   193: iload 5
    //   195: ifeq +8 -> 203
    //   198: iconst_0
    //   199: istore_1
    //   200: goto +5 -> 205
    //   203: iconst_1
    //   204: istore_1
    //   205: aload 6
    //   207: ifnull +10 -> 217
    //   210: aload 6
    //   212: invokeinterface 174 1 0
    //   217: iconst_0
    //   218: istore_2
    //   219: iload_1
    //   220: istore 4
    //   222: iload_2
    //   223: istore_1
    //   224: iload 4
    //   226: ifeq +5 -> 231
    //   229: iload_1
    //   230: ireturn
    //   231: aload 6
    //   233: astore 8
    //   235: aload 6
    //   237: astore 7
    //   239: aload_0
    //   240: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   243: invokevirtual 142	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   246: astore 9
    //   248: aload 6
    //   250: astore 8
    //   252: aload 6
    //   254: astore 7
    //   256: ldc_w 278
    //   259: invokestatic 136	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   262: astore 10
    //   264: aload 6
    //   266: astore 8
    //   268: aload 6
    //   270: astore 7
    //   272: aload_0
    //   273: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   276: invokevirtual 148	android/content/Context:getPackageName	()Ljava/lang/String;
    //   279: astore 11
    //   281: aload 6
    //   283: astore 8
    //   285: aload 6
    //   287: astore 7
    //   289: aload 9
    //   291: aload 10
    //   293: iconst_1
    //   294: anewarray 56	java/lang/String
    //   297: dup
    //   298: iconst_0
    //   299: ldc_w 280
    //   302: aastore
    //   303: ldc 144
    //   305: iconst_1
    //   306: anewarray 56	java/lang/String
    //   309: dup
    //   310: iconst_0
    //   311: aload 11
    //   313: aastore
    //   314: aconst_null
    //   315: invokevirtual 154	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   318: astore 6
    //   320: iload_1
    //   321: istore_2
    //   322: aload 6
    //   324: ifnull +69 -> 393
    //   327: iload_1
    //   328: istore_2
    //   329: aload 6
    //   331: astore 8
    //   333: aload 6
    //   335: astore 7
    //   337: aload 6
    //   339: invokeinterface 265 1 0
    //   344: ifle +49 -> 393
    //   347: iload_1
    //   348: istore_2
    //   349: aload 6
    //   351: astore 8
    //   353: aload 6
    //   355: astore 7
    //   357: aload 6
    //   359: invokeinterface 160 1 0
    //   364: ifeq +29 -> 393
    //   367: aload 6
    //   369: astore 8
    //   371: aload 6
    //   373: astore 7
    //   375: aload 6
    //   377: iconst_0
    //   378: invokeinterface 170 2 0
    //   383: istore_3
    //   384: iload_1
    //   385: istore_2
    //   386: iload_3
    //   387: iconst_1
    //   388: if_icmpne +5 -> 393
    //   391: iconst_m1
    //   392: istore_2
    //   393: iload_2
    //   394: istore_3
    //   395: aload 6
    //   397: ifnull +45 -> 442
    //   400: iload_2
    //   401: istore_1
    //   402: aload 6
    //   404: invokeinterface 174 1 0
    //   409: iload_1
    //   410: ireturn
    //   411: astore 6
    //   413: aload 8
    //   415: ifnull +10 -> 425
    //   418: aload 8
    //   420: invokeinterface 174 1 0
    //   425: aload 6
    //   427: athrow
    //   428: iload_1
    //   429: istore_3
    //   430: aload 7
    //   432: ifnull +10 -> 442
    //   435: aload 7
    //   437: astore 6
    //   439: goto -37 -> 402
    //   442: iload_3
    //   443: ireturn
    //   444: aload 7
    //   446: ifnull +10 -> 456
    //   449: aload 7
    //   451: invokeinterface 174 1 0
    //   456: aload 6
    //   458: athrow
    //   459: astore 6
    //   461: aload 8
    //   463: astore 6
    //   465: iload_2
    //   466: istore_1
    //   467: iload_3
    //   468: istore 4
    //   470: goto -246 -> 224
    //   473: astore 7
    //   475: goto -258 -> 217
    //   478: astore 6
    //   480: goto -52 -> 428
    //   483: astore 6
    //   485: iload_1
    //   486: ireturn
    //   487: astore 7
    //   489: goto -64 -> 425
    //   492: astore 7
    //   494: goto -38 -> 456
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	497	0	this	bf
    //   110	376	1	n	int
    //   63	403	2	i1	int
    //   65	403	3	i2	int
    //   131	338	4	i3	int
    //   191	3	5	bool	boolean
    //   1	147	6	localObject1	Object
    //   157	129	6	localObject2	Object
    //   318	85	6	localCursor1	Cursor
    //   411	15	6	localObject3	Object
    //   437	20	6	localObject4	Object
    //   459	1	6	localThrowable1	Throwable
    //   463	1	6	localObject5	Object
    //   478	1	6	localThrowable2	Throwable
    //   483	1	6	localThrowable3	Throwable
    //   4	446	7	localObject6	Object
    //   473	1	7	localThrowable4	Throwable
    //   487	1	7	localThrowable5	Throwable
    //   492	1	7	localThrowable6	Throwable
    //   40	106	8	localCursor2	Cursor
    //   162	19	8	localThrowable7	Throwable
    //   233	229	8	localObject7	Object
    //   246	44	9	localContentResolver	ContentResolver
    //   262	30	10	localUri	Uri
    //   279	33	11	str	String
    // Exception table:
    //   from	to	target	type
    //   6	42	157	finally
    //   50	57	157	finally
    //   77	87	157	finally
    //   103	111	157	finally
    //   168	176	157	finally
    //   180	193	157	finally
    //   6	42	162	java/lang/Throwable
    //   50	57	162	java/lang/Throwable
    //   77	87	162	java/lang/Throwable
    //   103	111	162	java/lang/Throwable
    //   239	248	411	finally
    //   256	264	411	finally
    //   272	281	411	finally
    //   289	320	411	finally
    //   337	347	411	finally
    //   357	367	411	finally
    //   375	384	411	finally
    //   138	145	459	java/lang/Throwable
    //   210	217	473	java/lang/Throwable
    //   239	248	478	java/lang/Throwable
    //   256	264	478	java/lang/Throwable
    //   272	281	478	java/lang/Throwable
    //   289	320	478	java/lang/Throwable
    //   337	347	478	java/lang/Throwable
    //   357	367	478	java/lang/Throwable
    //   375	384	478	java/lang/Throwable
    //   402	409	483	java/lang/Throwable
    //   418	425	487	java/lang/Throwable
    //   449	456	492	java/lang/Throwable
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
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: aload 7
    //   8: astore 5
    //   10: aload 8
    //   12: astore 6
    //   14: aload_0
    //   15: aload_0
    //   16: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   19: invokevirtual 148	android/content/Context:getPackageName	()Ljava/lang/String;
    //   22: invokespecial 314	taiji/bf:a	(Ljava/lang/String;)Ljava/lang/String;
    //   25: astore 9
    //   27: aload 7
    //   29: astore 5
    //   31: aload 8
    //   33: astore 6
    //   35: aload_0
    //   36: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   39: invokevirtual 142	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   42: ldc_w 316
    //   45: invokestatic 136	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   48: aconst_null
    //   49: ldc_w 318
    //   52: iconst_1
    //   53: anewarray 56	java/lang/String
    //   56: dup
    //   57: iconst_0
    //   58: aload 9
    //   60: aastore
    //   61: aconst_null
    //   62: invokevirtual 154	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   65: astore 7
    //   67: aload 7
    //   69: ifnonnull +17 -> 86
    //   72: aload 7
    //   74: ifnull +10 -> 84
    //   77: aload 7
    //   79: invokeinterface 174 1 0
    //   84: iconst_2
    //   85: ireturn
    //   86: aload 7
    //   88: astore 5
    //   90: aload 7
    //   92: astore 6
    //   94: aload 7
    //   96: invokeinterface 265 1 0
    //   101: istore_2
    //   102: iconst_m1
    //   103: istore_1
    //   104: iload_2
    //   105: ifle +67 -> 172
    //   108: aload 7
    //   110: astore 5
    //   112: aload 7
    //   114: astore 6
    //   116: aload 7
    //   118: invokeinterface 160 1 0
    //   123: ifeq +49 -> 172
    //   126: aload 7
    //   128: astore 5
    //   130: aload 7
    //   132: astore 6
    //   134: aload 7
    //   136: aload 7
    //   138: ldc_w 320
    //   141: invokeinterface 168 2 0
    //   146: invokeinterface 170 2 0
    //   151: istore_2
    //   152: iload_2
    //   153: ifne +5 -> 158
    //   156: iconst_0
    //   157: istore_1
    //   158: aload 7
    //   160: ifnull +10 -> 170
    //   163: aload 7
    //   165: invokeinterface 174 1 0
    //   170: iload_1
    //   171: ireturn
    //   172: aload 7
    //   174: astore 5
    //   176: aload 7
    //   178: astore 6
    //   180: aload_0
    //   181: aload_0
    //   182: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   185: invokevirtual 148	android/content/Context:getPackageName	()Ljava/lang/String;
    //   188: invokespecial 322	taiji/bf:b	(Ljava/lang/String;)Ljava/lang/String;
    //   191: astore 8
    //   193: aload 7
    //   195: astore 5
    //   197: aload 7
    //   199: astore 6
    //   201: aload_0
    //   202: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   205: invokevirtual 142	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   208: ldc_w 316
    //   211: invokestatic 136	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   214: aconst_null
    //   215: ldc_w 318
    //   218: iconst_1
    //   219: anewarray 56	java/lang/String
    //   222: dup
    //   223: iconst_0
    //   224: aload 8
    //   226: aastore
    //   227: aconst_null
    //   228: invokevirtual 154	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   231: astore 7
    //   233: aload 7
    //   235: ifnonnull +17 -> 252
    //   238: aload 7
    //   240: ifnull +10 -> 250
    //   243: aload 7
    //   245: invokeinterface 174 1 0
    //   250: iconst_2
    //   251: ireturn
    //   252: aload 7
    //   254: astore 5
    //   256: aload 7
    //   258: astore 6
    //   260: aload 7
    //   262: invokeinterface 265 1 0
    //   267: ifle +67 -> 334
    //   270: aload 7
    //   272: astore 5
    //   274: aload 7
    //   276: astore 6
    //   278: aload 7
    //   280: invokeinterface 160 1 0
    //   285: ifeq +49 -> 334
    //   288: aload 7
    //   290: astore 5
    //   292: aload 7
    //   294: astore 6
    //   296: aload 7
    //   298: aload 7
    //   300: ldc_w 320
    //   303: invokeinterface 168 2 0
    //   308: invokeinterface 170 2 0
    //   313: istore_2
    //   314: iload_2
    //   315: ifne +5 -> 320
    //   318: iconst_0
    //   319: istore_1
    //   320: aload 7
    //   322: ifnull +10 -> 332
    //   325: aload 7
    //   327: invokeinterface 174 1 0
    //   332: iload_1
    //   333: ireturn
    //   334: aload 7
    //   336: astore 5
    //   338: aload 7
    //   340: astore 6
    //   342: aload_0
    //   343: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   346: invokevirtual 142	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   349: ldc_w 316
    //   352: invokestatic 136	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   355: iconst_2
    //   356: anewarray 56	java/lang/String
    //   359: dup
    //   360: iconst_0
    //   361: ldc_w 324
    //   364: aastore
    //   365: dup
    //   366: iconst_1
    //   367: ldc_w 320
    //   370: aastore
    //   371: aconst_null
    //   372: aconst_null
    //   373: aconst_null
    //   374: invokevirtual 154	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   377: astore 7
    //   379: aload 7
    //   381: ifnonnull +17 -> 398
    //   384: aload 7
    //   386: ifnull +10 -> 396
    //   389: aload 7
    //   391: invokeinterface 174 1 0
    //   396: iconst_2
    //   397: ireturn
    //   398: iload_1
    //   399: istore_2
    //   400: aload 7
    //   402: astore 5
    //   404: aload 7
    //   406: astore 6
    //   408: aload 7
    //   410: invokeinterface 160 1 0
    //   415: ifeq +91 -> 506
    //   418: aload 7
    //   420: astore 5
    //   422: aload 7
    //   424: astore 6
    //   426: aload 7
    //   428: aload 7
    //   430: ldc_w 324
    //   433: invokeinterface 168 2 0
    //   438: invokeinterface 327 2 0
    //   443: astore 8
    //   445: aload 7
    //   447: astore 5
    //   449: aload 7
    //   451: astore 6
    //   453: aload 7
    //   455: aload 7
    //   457: ldc_w 320
    //   460: invokeinterface 168 2 0
    //   465: invokeinterface 170 2 0
    //   470: istore_3
    //   471: aload 7
    //   473: astore 5
    //   475: aload 7
    //   477: astore 6
    //   479: aload 8
    //   481: aload_0
    //   482: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   485: invokevirtual 148	android/content/Context:getPackageName	()Ljava/lang/String;
    //   488: invokestatic 331	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   491: istore 4
    //   493: iload 4
    //   495: ifeq -97 -> 398
    //   498: iload_1
    //   499: istore_2
    //   500: iload_3
    //   501: ifne +5 -> 506
    //   504: iconst_0
    //   505: istore_2
    //   506: aload 7
    //   508: ifnull +10 -> 518
    //   511: aload 7
    //   513: invokeinterface 174 1 0
    //   518: iload_2
    //   519: ireturn
    //   520: astore 6
    //   522: aload 5
    //   524: ifnull +10 -> 534
    //   527: aload 5
    //   529: invokeinterface 174 1 0
    //   534: aload 6
    //   536: athrow
    //   537: aload 6
    //   539: ifnull +10 -> 549
    //   542: aload 6
    //   544: invokeinterface 174 1 0
    //   549: iconst_2
    //   550: ireturn
    //   551: astore 5
    //   553: goto -16 -> 537
    //   556: astore 5
    //   558: iconst_2
    //   559: ireturn
    //   560: astore 5
    //   562: iload_1
    //   563: ireturn
    //   564: astore 5
    //   566: iconst_2
    //   567: ireturn
    //   568: astore 5
    //   570: iload_1
    //   571: ireturn
    //   572: astore 5
    //   574: iconst_2
    //   575: ireturn
    //   576: astore 5
    //   578: iload_2
    //   579: ireturn
    //   580: astore 5
    //   582: goto -48 -> 534
    //   585: astore 5
    //   587: iconst_2
    //   588: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	589	0	this	bf
    //   103	468	1	n	int
    //   101	478	2	i1	int
    //   470	31	3	i2	int
    //   491	3	4	bool	boolean
    //   8	520	5	localCursor1	Cursor
    //   551	1	5	localThrowable1	Throwable
    //   556	1	5	localThrowable2	Throwable
    //   560	1	5	localThrowable3	Throwable
    //   564	1	5	localThrowable4	Throwable
    //   568	1	5	localThrowable5	Throwable
    //   572	1	5	localThrowable6	Throwable
    //   576	1	5	localThrowable7	Throwable
    //   580	1	5	localThrowable8	Throwable
    //   585	1	5	localThrowable9	Throwable
    //   12	466	6	localObject1	Object
    //   520	23	6	localObject2	Object
    //   4	508	7	localCursor2	Cursor
    //   1	479	8	str1	String
    //   25	34	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   14	27	520	finally
    //   35	67	520	finally
    //   94	102	520	finally
    //   116	126	520	finally
    //   134	152	520	finally
    //   180	193	520	finally
    //   201	233	520	finally
    //   260	270	520	finally
    //   278	288	520	finally
    //   296	314	520	finally
    //   342	379	520	finally
    //   408	418	520	finally
    //   426	445	520	finally
    //   453	471	520	finally
    //   479	493	520	finally
    //   14	27	551	java/lang/Throwable
    //   35	67	551	java/lang/Throwable
    //   94	102	551	java/lang/Throwable
    //   116	126	551	java/lang/Throwable
    //   134	152	551	java/lang/Throwable
    //   180	193	551	java/lang/Throwable
    //   201	233	551	java/lang/Throwable
    //   260	270	551	java/lang/Throwable
    //   278	288	551	java/lang/Throwable
    //   296	314	551	java/lang/Throwable
    //   342	379	551	java/lang/Throwable
    //   408	418	551	java/lang/Throwable
    //   426	445	551	java/lang/Throwable
    //   453	471	551	java/lang/Throwable
    //   479	493	551	java/lang/Throwable
    //   77	84	556	java/lang/Throwable
    //   163	170	560	java/lang/Throwable
    //   243	250	564	java/lang/Throwable
    //   325	332	568	java/lang/Throwable
    //   389	396	572	java/lang/Throwable
    //   511	518	576	java/lang/Throwable
    //   527	534	580	java/lang/Throwable
    //   542	549	585	java/lang/Throwable
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
    int n = 2;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    label190:
    do
    {
      for (;;)
      {
        try
        {
          ContentResolver localContentResolver = this.f.getContentResolver();
          localObject1 = localObject2;
          Cursor localCursor = localContentResolver.query(Uri.parse("content://com.vivo.upslide.speedup.provider/speedupwhitelist"), new String[] { "pkgname" }, "pkgname=?", new String[] { str }, null);
          localObject2 = localCursor;
          if (localCursor != null) {
            break label190;
          }
          localObject1 = localCursor;
          localObject2 = localContentResolver.query(Uri.parse("content://com.iqoo.secure.provider.secureprovider/speedupwhitelist"), new String[] { "pkgname" }, "pkgname=?", new String[] { str }, null);
        }
        catch (Throwable localThrowable2)
        {
          try
          {
            boolean bool;
            localObject1.close();
            return n;
          }
          catch (Throwable localThrowable1)
          {
            return n;
          }
          localThrowable2 = localThrowable2;
          continue;
        }
        localObject1 = localObject2;
        if (((Cursor)localObject2).moveToNext())
        {
          localObject1 = localObject2;
          bool = TextUtils.equals(((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndex("pkgname")), str);
          if (!bool) {
            continue;
          }
          n = 0;
          localObject1 = localObject2;
        }
        else
        {
          n = -1;
          localObject1 = localObject2;
        }
      }
    } while ((localObject1 != null) && (localThrowable2 != null));
    return 2;
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
    //   0: getstatic 28	android/os/Build$VERSION:SDK_INT	I
    //   3: istore_1
    //   4: iconst_0
    //   5: istore 4
    //   7: iconst_0
    //   8: istore 5
    //   10: iconst_0
    //   11: istore_3
    //   12: iload 5
    //   14: istore_2
    //   15: iload_1
    //   16: bipush 24
    //   18: if_icmplt +222 -> 240
    //   21: aconst_null
    //   22: astore 9
    //   24: aconst_null
    //   25: astore 7
    //   27: aload 7
    //   29: astore 8
    //   31: aload 9
    //   33: astore 6
    //   35: aload_0
    //   36: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   39: invokevirtual 142	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   42: astore 10
    //   44: aload 7
    //   46: astore 8
    //   48: aload 9
    //   50: astore 6
    //   52: ldc_w 357
    //   55: invokestatic 136	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   58: astore 11
    //   60: aload 7
    //   62: astore 8
    //   64: aload 9
    //   66: astore 6
    //   68: aload_0
    //   69: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   72: invokevirtual 148	android/content/Context:getPackageName	()Ljava/lang/String;
    //   75: astore 12
    //   77: aload 7
    //   79: astore 8
    //   81: aload 9
    //   83: astore 6
    //   85: aload 10
    //   87: aload 11
    //   89: iconst_1
    //   90: anewarray 56	java/lang/String
    //   93: dup
    //   94: iconst_0
    //   95: ldc_w 280
    //   98: aastore
    //   99: ldc 144
    //   101: iconst_1
    //   102: anewarray 56	java/lang/String
    //   105: dup
    //   106: iconst_0
    //   107: aload 12
    //   109: aastore
    //   110: aconst_null
    //   111: invokevirtual 154	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   114: astore 7
    //   116: iload_3
    //   117: istore_1
    //   118: aload 7
    //   120: ifnull +69 -> 189
    //   123: iload_3
    //   124: istore_1
    //   125: aload 7
    //   127: astore 8
    //   129: aload 7
    //   131: astore 6
    //   133: aload 7
    //   135: invokeinterface 265 1 0
    //   140: ifle +49 -> 189
    //   143: iload_3
    //   144: istore_1
    //   145: aload 7
    //   147: astore 8
    //   149: aload 7
    //   151: astore 6
    //   153: aload 7
    //   155: invokeinterface 160 1 0
    //   160: ifeq +29 -> 189
    //   163: aload 7
    //   165: astore 8
    //   167: aload 7
    //   169: astore 6
    //   171: aload 7
    //   173: iconst_0
    //   174: invokeinterface 170 2 0
    //   179: istore_2
    //   180: iload_3
    //   181: istore_1
    //   182: iload_2
    //   183: iconst_1
    //   184: if_icmpne +5 -> 189
    //   187: iconst_m1
    //   188: istore_1
    //   189: iload_1
    //   190: istore_2
    //   191: aload 7
    //   193: ifnull +47 -> 240
    //   196: aload 7
    //   198: astore 6
    //   200: aload 6
    //   202: invokeinterface 174 1 0
    //   207: iload_1
    //   208: ireturn
    //   209: astore 6
    //   211: aload 8
    //   213: ifnull +10 -> 223
    //   216: aload 8
    //   218: invokeinterface 174 1 0
    //   223: aload 6
    //   225: athrow
    //   226: iload 5
    //   228: istore_2
    //   229: aload 6
    //   231: ifnull +9 -> 240
    //   234: iload 4
    //   236: istore_1
    //   237: goto -37 -> 200
    //   240: iload_2
    //   241: ireturn
    //   242: astore 7
    //   244: goto -18 -> 226
    //   247: astore 6
    //   249: iload_1
    //   250: ireturn
    //   251: astore 7
    //   253: goto -30 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	bf
    //   3	247	1	n	int
    //   14	227	2	i1	int
    //   11	170	3	i2	int
    //   5	230	4	i3	int
    //   8	219	5	i4	int
    //   33	168	6	localObject1	Object
    //   209	21	6	localObject2	Object
    //   247	1	6	localThrowable1	Throwable
    //   25	172	7	localCursor1	Cursor
    //   242	1	7	localThrowable2	Throwable
    //   251	1	7	localThrowable3	Throwable
    //   29	188	8	localCursor2	Cursor
    //   22	60	9	localObject3	Object
    //   42	44	10	localContentResolver	ContentResolver
    //   58	30	11	localUri	Uri
    //   75	33	12	str	String
    // Exception table:
    //   from	to	target	type
    //   35	44	209	finally
    //   52	60	209	finally
    //   68	77	209	finally
    //   85	116	209	finally
    //   133	143	209	finally
    //   153	163	209	finally
    //   171	180	209	finally
    //   35	44	242	java/lang/Throwable
    //   52	60	242	java/lang/Throwable
    //   68	77	242	java/lang/Throwable
    //   85	116	242	java/lang/Throwable
    //   133	143	242	java/lang/Throwable
    //   153	163	242	java/lang/Throwable
    //   171	180	242	java/lang/Throwable
    //   200	207	247	java/lang/Throwable
    //   216	223	251	java/lang/Throwable
  }
  
  /* Error */
  private int f()
  {
    // Byte code:
    //   0: getstatic 28	android/os/Build$VERSION:SDK_INT	I
    //   3: istore_1
    //   4: iconst_0
    //   5: istore 4
    //   7: iconst_0
    //   8: istore 5
    //   10: iconst_0
    //   11: istore_3
    //   12: iload 5
    //   14: istore_2
    //   15: iload_1
    //   16: bipush 24
    //   18: if_icmplt +222 -> 240
    //   21: aconst_null
    //   22: astore 9
    //   24: aconst_null
    //   25: astore 7
    //   27: aload 7
    //   29: astore 8
    //   31: aload 9
    //   33: astore 6
    //   35: aload_0
    //   36: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   39: invokevirtual 142	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   42: astore 10
    //   44: aload 7
    //   46: astore 8
    //   48: aload 9
    //   50: astore 6
    //   52: ldc_w 359
    //   55: invokestatic 136	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   58: astore 11
    //   60: aload 7
    //   62: astore 8
    //   64: aload 9
    //   66: astore 6
    //   68: aload_0
    //   69: getfield 30	taiji/bf:f	Landroid/content/Context;
    //   72: invokevirtual 148	android/content/Context:getPackageName	()Ljava/lang/String;
    //   75: astore 12
    //   77: aload 7
    //   79: astore 8
    //   81: aload 9
    //   83: astore 6
    //   85: aload 10
    //   87: aload 11
    //   89: iconst_1
    //   90: anewarray 56	java/lang/String
    //   93: dup
    //   94: iconst_0
    //   95: ldc_w 280
    //   98: aastore
    //   99: ldc 144
    //   101: iconst_1
    //   102: anewarray 56	java/lang/String
    //   105: dup
    //   106: iconst_0
    //   107: aload 12
    //   109: aastore
    //   110: aconst_null
    //   111: invokevirtual 154	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   114: astore 7
    //   116: iload_3
    //   117: istore_1
    //   118: aload 7
    //   120: ifnull +69 -> 189
    //   123: iload_3
    //   124: istore_1
    //   125: aload 7
    //   127: astore 8
    //   129: aload 7
    //   131: astore 6
    //   133: aload 7
    //   135: invokeinterface 265 1 0
    //   140: ifle +49 -> 189
    //   143: iload_3
    //   144: istore_1
    //   145: aload 7
    //   147: astore 8
    //   149: aload 7
    //   151: astore 6
    //   153: aload 7
    //   155: invokeinterface 160 1 0
    //   160: ifeq +29 -> 189
    //   163: aload 7
    //   165: astore 8
    //   167: aload 7
    //   169: astore 6
    //   171: aload 7
    //   173: iconst_0
    //   174: invokeinterface 170 2 0
    //   179: istore_2
    //   180: iload_3
    //   181: istore_1
    //   182: iload_2
    //   183: iconst_1
    //   184: if_icmpne +5 -> 189
    //   187: iconst_m1
    //   188: istore_1
    //   189: iload_1
    //   190: istore_2
    //   191: aload 7
    //   193: ifnull +47 -> 240
    //   196: aload 7
    //   198: astore 6
    //   200: aload 6
    //   202: invokeinterface 174 1 0
    //   207: iload_1
    //   208: ireturn
    //   209: astore 6
    //   211: aload 8
    //   213: ifnull +10 -> 223
    //   216: aload 8
    //   218: invokeinterface 174 1 0
    //   223: aload 6
    //   225: athrow
    //   226: iload 5
    //   228: istore_2
    //   229: aload 6
    //   231: ifnull +9 -> 240
    //   234: iload 4
    //   236: istore_1
    //   237: goto -37 -> 200
    //   240: iload_2
    //   241: ireturn
    //   242: astore 7
    //   244: goto -18 -> 226
    //   247: astore 6
    //   249: iload_1
    //   250: ireturn
    //   251: astore 7
    //   253: goto -30 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	bf
    //   3	247	1	n	int
    //   14	227	2	i1	int
    //   11	170	3	i2	int
    //   5	230	4	i3	int
    //   8	219	5	i4	int
    //   33	168	6	localObject1	Object
    //   209	21	6	localObject2	Object
    //   247	1	6	localThrowable1	Throwable
    //   25	172	7	localCursor1	Cursor
    //   242	1	7	localThrowable2	Throwable
    //   251	1	7	localThrowable3	Throwable
    //   29	188	8	localCursor2	Cursor
    //   22	60	9	localObject3	Object
    //   42	44	10	localContentResolver	ContentResolver
    //   58	30	11	localUri	Uri
    //   75	33	12	str	String
    // Exception table:
    //   from	to	target	type
    //   35	44	209	finally
    //   52	60	209	finally
    //   68	77	209	finally
    //   85	116	209	finally
    //   133	143	209	finally
    //   153	163	209	finally
    //   171	180	209	finally
    //   35	44	242	java/lang/Throwable
    //   52	60	242	java/lang/Throwable
    //   68	77	242	java/lang/Throwable
    //   85	116	242	java/lang/Throwable
    //   133	143	242	java/lang/Throwable
    //   153	163	242	java/lang/Throwable
    //   171	180	242	java/lang/Throwable
    //   200	207	247	java/lang/Throwable
    //   216	223	251	java/lang/Throwable
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
      label18:
      break label18;
    }
    catch (Throwable localThrowable) {}
    return false;
    return true;
  }
  
  public int checkPermission(int paramInt)
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 0;
    }
    String str;
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
    case 48: 
      return f();
    case 42: 
      return e();
    case 38: 
      return d();
    case 35: 
      str = "android.permission.BLUETOOTH";
    }
    for (;;)
    {
      return a(paramInt, str);
      str = "android.permission.CHANGE_WIFI_STATE";
      continue;
      str = "android.permission.GET_ACCOUNTS";
      continue;
      int n = a(paramInt, "android.permission.WRITE_SETTINGS");
      paramInt = n;
      if (n == 0)
      {
        paramInt = n;
        if (!g()) {
          paramInt = -1;
        }
      }
      return paramInt;
      str = "android.permission.RECORD_AUDIO";
      continue;
      str = "android.permission.CAMERA";
      continue;
      str = "android.permission.WRITE_CALENDAR";
      continue;
      str = "android.permission.READ_CALENDAR";
      continue;
      str = "com.android.launcher.permission.INSTALL_SHORTCUT";
      continue;
      str = "android.permission.ACCESS_FINE_LOCATION";
      continue;
      str = "android.permission.WRITE_CONTACTS";
      continue;
      str = "android.permission.READ_CONTACTS";
      continue;
      str = "android.permission.SEND_MMS";
      continue;
      str = "android.permission.WRITE_MMS";
      continue;
      str = "android.permission.SEND_SMS";
      continue;
      str = "android.permission.WRITE_SMS";
      continue;
      str = "android.permission.READ_SMS";
      continue;
      str = "android.permission.WRITE_CALL_LOG";
      continue;
      str = "android.permission.READ_CALL_LOG";
      continue;
      str = "android.permission.CALL_PHONE";
      continue;
      str = "android.permission.PROCESS_OUTGOING_CALLS";
      continue;
      return super.checkPermission(paramInt);
      return a();
      return b();
      return c();
      str = "android.permission.WRITE_EXTERNAL_STORAGE";
      continue;
      str = "android.permission.READ_PHONE_STATE";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.bf
 * JD-Core Version:    0.7.0.1
 */