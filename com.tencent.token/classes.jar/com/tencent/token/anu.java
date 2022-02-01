package com.tencent.token;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class anu
  extends anq
{
  private Context f;
  private Method g;
  private Method h;
  private Method i;
  private Object j;
  private int k;
  private int l;
  private boolean m;
  
  public anu(Context paramContext)
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
    //   2: invokespecial 127	com/tencent/token/anq:a	(I)I
    //   5: istore_1
    //   6: iload_1
    //   7: istore_2
    //   8: iload_1
    //   9: ifne +260 -> 269
    //   12: ldc 129
    //   14: invokestatic 135	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   17: astore 9
    //   19: ldc 137
    //   21: invokestatic 135	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   24: astore 10
    //   26: iconst_0
    //   27: istore 5
    //   29: iload 5
    //   31: iconst_2
    //   32: if_icmpge +216 -> 248
    //   35: aconst_null
    //   36: astore 8
    //   38: aconst_null
    //   39: astore 7
    //   41: aload_0
    //   42: getfield 30	com/tencent/token/anu:f	Landroid/content/Context;
    //   45: invokevirtual 141	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   48: iconst_2
    //   49: anewarray 131	android/net/Uri
    //   52: dup
    //   53: iconst_0
    //   54: aload 9
    //   56: aastore
    //   57: dup
    //   58: iconst_1
    //   59: aload 10
    //   61: aastore
    //   62: iload 5
    //   64: aaload
    //   65: aconst_null
    //   66: ldc 143
    //   68: iconst_1
    //   69: anewarray 56	java/lang/String
    //   72: dup
    //   73: iconst_0
    //   74: aload_0
    //   75: getfield 30	com/tencent/token/anu:f	Landroid/content/Context;
    //   78: invokevirtual 147	android/content/Context:getPackageName	()Ljava/lang/String;
    //   81: aastore
    //   82: aconst_null
    //   83: invokevirtual 153	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   86: astore 6
    //   88: aload 6
    //   90: ifnull +77 -> 167
    //   93: iload_1
    //   94: istore_2
    //   95: aload 6
    //   97: astore 7
    //   99: aload 6
    //   101: invokeinterface 159 1 0
    //   106: ifeq +47 -> 153
    //   109: aload 6
    //   111: astore 7
    //   113: aload 6
    //   115: aload 6
    //   117: iconst_2
    //   118: anewarray 56	java/lang/String
    //   121: dup
    //   122: iconst_0
    //   123: ldc 161
    //   125: aastore
    //   126: dup
    //   127: iconst_1
    //   128: ldc 163
    //   130: aastore
    //   131: iload 5
    //   133: aaload
    //   134: invokeinterface 167 2 0
    //   139: invokeinterface 169 2 0
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
    //   181: invokeinterface 173 1 0
    //   186: iload_1
    //   187: istore_3
    //   188: iload_2
    //   189: istore 4
    //   191: goto +39 -> 230
    //   194: astore 6
    //   196: aload 7
    //   198: ifnull +10 -> 208
    //   201: aload 7
    //   203: invokeinterface 173 1 0
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
    //   245: goto -216 -> 29
    //   248: getstatic 178	com/tencent/token/anp:a	Lcom/tencent/token/arv;
    //   251: astore 6
    //   253: aload 6
    //   255: ifnull +12 -> 267
    //   258: aload 6
    //   260: iconst_5
    //   261: invokeinterface 181 2 0
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
    //   0	296	0	this	anu
    //   5	279	1	n	int
    //   7	279	2	i1	int
    //   144	141	3	i2	int
    //   172	115	4	i3	int
    //   27	215	5	i4	int
    //   86	94	6	localCursor	Cursor
    //   194	15	6	localObject1	Object
    //   215	44	6	localObject2	Object
    //   271	1	6	localThrowable1	Throwable
    //   281	1	6	localThrowable2	Throwable
    //   39	163	7	localObject3	Object
    //   276	1	7	localThrowable3	Throwable
    //   291	1	7	localThrowable4	Throwable
    //   36	178	8	localObject4	Object
    //   17	38	9	localUri1	Uri
    //   24	36	10	localUri2	Uri
    // Exception table:
    //   from	to	target	type
    //   41	88	194	finally
    //   99	109	194	finally
    //   113	145	194	finally
    //   41	88	271	java/lang/Throwable
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
        paramInt = super.a(paramInt);
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
  
  private static String a(byte[] paramArrayOfByte)
  {
    Object localObject = "";
    if (paramArrayOfByte != null)
    {
      localObject = new StringBuffer(paramArrayOfByte.length * 2);
      int n = 0;
      while (n < paramArrayOfByte.length)
      {
        int i1 = paramArrayOfByte[n];
        ((StringBuffer)localObject).append("0123456789ABCDEF".charAt(i1 >> 4 & 0xF));
        ((StringBuffer)localObject).append("0123456789ABCDEF".charAt(i1 & 0xF));
        n += 1;
      }
      localObject = ((StringBuffer)localObject).toString();
    }
    return localObject;
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
    //   7: getfield 30	com/tencent/token/anu:f	Landroid/content/Context;
    //   10: invokevirtual 141	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: ldc 225
    //   15: invokestatic 135	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   18: aconst_null
    //   19: ldc 143
    //   21: iconst_1
    //   22: anewarray 56	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: aload_0
    //   28: getfield 30	com/tencent/token/anu:f	Landroid/content/Context;
    //   31: invokevirtual 147	android/content/Context:getPackageName	()Ljava/lang/String;
    //   34: aastore
    //   35: aconst_null
    //   36: invokevirtual 153	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   39: astore 8
    //   41: aload 8
    //   43: astore 7
    //   45: aload 8
    //   47: astore 6
    //   49: aload_0
    //   50: getfield 121	com/tencent/token/anu:m	Z
    //   53: ifeq +36 -> 89
    //   56: aload 8
    //   58: ifnonnull +10 -> 68
    //   61: iconst_0
    //   62: istore_2
    //   63: iconst_0
    //   64: istore_3
    //   65: goto +58 -> 123
    //   68: aload 8
    //   70: astore 7
    //   72: aload 8
    //   74: astore 6
    //   76: aload 8
    //   78: invokeinterface 228 1 0
    //   83: ifne +36 -> 119
    //   86: goto +28 -> 114
    //   89: aload 8
    //   91: ifnull +28 -> 119
    //   94: aload 8
    //   96: astore 7
    //   98: aload 8
    //   100: astore 6
    //   102: aload 8
    //   104: invokeinterface 228 1 0
    //   109: istore_1
    //   110: iload_1
    //   111: ifle +8 -> 119
    //   114: iconst_m1
    //   115: istore_2
    //   116: goto +5 -> 121
    //   119: iconst_0
    //   120: istore_2
    //   121: iconst_1
    //   122: istore_3
    //   123: aload 8
    //   125: astore 6
    //   127: iload_2
    //   128: istore_1
    //   129: iload_3
    //   130: istore 4
    //   132: aload 8
    //   134: ifnull +88 -> 222
    //   137: aload 8
    //   139: invokeinterface 173 1 0
    //   144: aload 8
    //   146: astore 6
    //   148: iload_2
    //   149: istore_1
    //   150: iload_3
    //   151: istore 4
    //   153: goto +69 -> 222
    //   156: astore 6
    //   158: goto +282 -> 440
    //   161: astore 8
    //   163: aload 6
    //   165: astore 7
    //   167: aload 8
    //   169: instanceof 230
    //   172: ifeq +29 -> 201
    //   175: aload 6
    //   177: astore 7
    //   179: aload 8
    //   181: invokevirtual 233	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   184: ldc 235
    //   186: invokevirtual 239	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   189: istore 5
    //   191: iload 5
    //   193: ifeq +8 -> 201
    //   196: iconst_0
    //   197: istore_1
    //   198: goto +5 -> 203
    //   201: iconst_1
    //   202: istore_1
    //   203: aload 6
    //   205: ifnull +10 -> 215
    //   208: aload 6
    //   210: invokeinterface 173 1 0
    //   215: iconst_0
    //   216: istore_2
    //   217: iload_1
    //   218: istore 4
    //   220: iload_2
    //   221: istore_1
    //   222: iload 4
    //   224: ifeq +5 -> 229
    //   227: iload_1
    //   228: ireturn
    //   229: aload 6
    //   231: astore 8
    //   233: aload 6
    //   235: astore 7
    //   237: aload_0
    //   238: getfield 30	com/tencent/token/anu:f	Landroid/content/Context;
    //   241: invokevirtual 141	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   244: astore 9
    //   246: aload 6
    //   248: astore 8
    //   250: aload 6
    //   252: astore 7
    //   254: ldc 241
    //   256: invokestatic 135	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   259: astore 10
    //   261: aload 6
    //   263: astore 8
    //   265: aload 6
    //   267: astore 7
    //   269: aload_0
    //   270: getfield 30	com/tencent/token/anu:f	Landroid/content/Context;
    //   273: invokevirtual 147	android/content/Context:getPackageName	()Ljava/lang/String;
    //   276: astore 11
    //   278: aload 6
    //   280: astore 8
    //   282: aload 6
    //   284: astore 7
    //   286: aload 9
    //   288: aload 10
    //   290: iconst_1
    //   291: anewarray 56	java/lang/String
    //   294: dup
    //   295: iconst_0
    //   296: ldc 243
    //   298: aastore
    //   299: ldc 143
    //   301: iconst_1
    //   302: anewarray 56	java/lang/String
    //   305: dup
    //   306: iconst_0
    //   307: aload 11
    //   309: aastore
    //   310: aconst_null
    //   311: invokevirtual 153	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   314: astore 6
    //   316: iload_1
    //   317: istore_2
    //   318: aload 6
    //   320: ifnull +69 -> 389
    //   323: iload_1
    //   324: istore_2
    //   325: aload 6
    //   327: astore 8
    //   329: aload 6
    //   331: astore 7
    //   333: aload 6
    //   335: invokeinterface 228 1 0
    //   340: ifle +49 -> 389
    //   343: iload_1
    //   344: istore_2
    //   345: aload 6
    //   347: astore 8
    //   349: aload 6
    //   351: astore 7
    //   353: aload 6
    //   355: invokeinterface 159 1 0
    //   360: ifeq +29 -> 389
    //   363: aload 6
    //   365: astore 8
    //   367: aload 6
    //   369: astore 7
    //   371: aload 6
    //   373: iconst_0
    //   374: invokeinterface 169 2 0
    //   379: istore_3
    //   380: iload_1
    //   381: istore_2
    //   382: iload_3
    //   383: iconst_1
    //   384: if_icmpne +5 -> 389
    //   387: iconst_m1
    //   388: istore_2
    //   389: iload_2
    //   390: istore_3
    //   391: aload 6
    //   393: ifnull +45 -> 438
    //   396: iload_2
    //   397: istore_1
    //   398: aload 6
    //   400: invokeinterface 173 1 0
    //   405: iload_1
    //   406: ireturn
    //   407: astore 6
    //   409: aload 8
    //   411: ifnull +10 -> 421
    //   414: aload 8
    //   416: invokeinterface 173 1 0
    //   421: aload 6
    //   423: athrow
    //   424: iload_1
    //   425: istore_3
    //   426: aload 7
    //   428: ifnull +10 -> 438
    //   431: aload 7
    //   433: astore 6
    //   435: goto -37 -> 398
    //   438: iload_3
    //   439: ireturn
    //   440: aload 7
    //   442: ifnull +10 -> 452
    //   445: aload 7
    //   447: invokeinterface 173 1 0
    //   452: aload 6
    //   454: athrow
    //   455: astore 6
    //   457: aload 8
    //   459: astore 6
    //   461: iload_2
    //   462: istore_1
    //   463: iload_3
    //   464: istore 4
    //   466: goto -244 -> 222
    //   469: astore 7
    //   471: goto -256 -> 215
    //   474: astore 6
    //   476: goto -52 -> 424
    //   479: astore 6
    //   481: iload_1
    //   482: ireturn
    //   483: astore 7
    //   485: goto -64 -> 421
    //   488: astore 7
    //   490: goto -38 -> 452
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	493	0	this	anu
    //   109	373	1	n	int
    //   62	400	2	i1	int
    //   64	400	3	i2	int
    //   130	335	4	i3	int
    //   189	3	5	bool	boolean
    //   1	146	6	localObject1	Object
    //   156	127	6	localObject2	Object
    //   314	85	6	localCursor1	Cursor
    //   407	15	6	localObject3	Object
    //   433	20	6	localObject4	Object
    //   455	1	6	localThrowable1	Throwable
    //   459	1	6	localObject5	Object
    //   474	1	6	localThrowable2	Throwable
    //   479	1	6	localThrowable3	Throwable
    //   4	442	7	localObject6	Object
    //   469	1	7	localThrowable4	Throwable
    //   483	1	7	localThrowable5	Throwable
    //   488	1	7	localThrowable6	Throwable
    //   39	106	8	localCursor2	Cursor
    //   161	19	8	localThrowable7	Throwable
    //   231	227	8	localObject7	Object
    //   244	43	9	localContentResolver	ContentResolver
    //   259	30	10	localUri	Uri
    //   276	32	11	str	String
    // Exception table:
    //   from	to	target	type
    //   6	41	156	finally
    //   49	56	156	finally
    //   76	86	156	finally
    //   102	110	156	finally
    //   167	175	156	finally
    //   179	191	156	finally
    //   6	41	161	java/lang/Throwable
    //   49	56	161	java/lang/Throwable
    //   76	86	161	java/lang/Throwable
    //   102	110	161	java/lang/Throwable
    //   237	246	407	finally
    //   254	261	407	finally
    //   269	278	407	finally
    //   286	316	407	finally
    //   333	343	407	finally
    //   353	363	407	finally
    //   371	380	407	finally
    //   137	144	455	java/lang/Throwable
    //   208	215	469	java/lang/Throwable
    //   237	246	474	java/lang/Throwable
    //   254	261	474	java/lang/Throwable
    //   269	278	474	java/lang/Throwable
    //   286	316	474	java/lang/Throwable
    //   333	343	474	java/lang/Throwable
    //   353	363	474	java/lang/Throwable
    //   371	380	474	java/lang/Throwable
    //   398	405	479	java/lang/Throwable
    //   414	421	483	java/lang/Throwable
    //   445	452	488	java/lang/Throwable
  }
  
  /* Error */
  private int c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: aload 8
    //   8: astore 6
    //   10: aload 9
    //   12: astore 7
    //   14: aload_0
    //   15: getfield 30	com/tencent/token/anu:f	Landroid/content/Context;
    //   18: invokevirtual 147	android/content/Context:getPackageName	()Ljava/lang/String;
    //   21: invokevirtual 248	java/lang/String:getBytes	()[B
    //   24: astore 10
    //   26: aload 8
    //   28: astore 6
    //   30: aload 9
    //   32: astore 7
    //   34: ldc 250
    //   36: invokevirtual 248	java/lang/String:getBytes	()[B
    //   39: astore 11
    //   41: aload 8
    //   43: astore 6
    //   45: aload 9
    //   47: astore 7
    //   49: ldc 252
    //   51: invokestatic 258	javax/crypto/KeyGenerator:getInstance	(Ljava/lang/String;)Ljavax/crypto/KeyGenerator;
    //   54: astore 12
    //   56: aload 8
    //   58: astore 6
    //   60: aload 9
    //   62: astore 7
    //   64: ldc_w 260
    //   67: ldc_w 262
    //   70: invokestatic 267	java/security/SecureRandom:getInstance	(Ljava/lang/String;Ljava/lang/String;)Ljava/security/SecureRandom;
    //   73: astore 13
    //   75: aload 8
    //   77: astore 6
    //   79: aload 9
    //   81: astore 7
    //   83: aload 13
    //   85: aload 11
    //   87: invokevirtual 271	java/security/SecureRandom:setSeed	([B)V
    //   90: aload 8
    //   92: astore 6
    //   94: aload 9
    //   96: astore 7
    //   98: aload 12
    //   100: sipush 128
    //   103: aload 13
    //   105: invokevirtual 275	javax/crypto/KeyGenerator:init	(ILjava/security/SecureRandom;)V
    //   108: aload 8
    //   110: astore 6
    //   112: aload 9
    //   114: astore 7
    //   116: new 277	javax/crypto/spec/SecretKeySpec
    //   119: dup
    //   120: aload 12
    //   122: invokevirtual 281	javax/crypto/KeyGenerator:generateKey	()Ljavax/crypto/SecretKey;
    //   125: invokeinterface 286 1 0
    //   130: ldc 252
    //   132: invokespecial 289	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   135: astore 11
    //   137: aload 8
    //   139: astore 6
    //   141: aload 9
    //   143: astore 7
    //   145: ldc 252
    //   147: invokestatic 294	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   150: astore 12
    //   152: aload 8
    //   154: astore 6
    //   156: aload 9
    //   158: astore 7
    //   160: aload 12
    //   162: iconst_1
    //   163: aload 11
    //   165: new 296	javax/crypto/spec/IvParameterSpec
    //   168: dup
    //   169: aload 12
    //   171: invokevirtual 299	javax/crypto/Cipher:getBlockSize	()I
    //   174: newarray byte
    //   176: invokespecial 301	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   179: invokevirtual 304	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   182: aload 8
    //   184: astore 6
    //   186: aload 9
    //   188: astore 7
    //   190: aload 12
    //   192: aload 10
    //   194: invokevirtual 308	javax/crypto/Cipher:doFinal	([B)[B
    //   197: invokestatic 310	com/tencent/token/anu:a	([B)Ljava/lang/String;
    //   200: astore 10
    //   202: aload 8
    //   204: astore 6
    //   206: aload 9
    //   208: astore 7
    //   210: aload_0
    //   211: getfield 30	com/tencent/token/anu:f	Landroid/content/Context;
    //   214: invokevirtual 141	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   217: astore 11
    //   219: aload 8
    //   221: astore 6
    //   223: aload 9
    //   225: astore 7
    //   227: ldc_w 312
    //   230: invokestatic 135	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   233: astore 12
    //   235: iconst_0
    //   236: istore_3
    //   237: iconst_0
    //   238: istore_1
    //   239: aload 8
    //   241: astore 6
    //   243: aload 9
    //   245: astore 7
    //   247: aload 11
    //   249: aload 12
    //   251: aconst_null
    //   252: ldc_w 314
    //   255: iconst_1
    //   256: anewarray 56	java/lang/String
    //   259: dup
    //   260: iconst_0
    //   261: aload 10
    //   263: aastore
    //   264: aconst_null
    //   265: invokevirtual 153	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   268: astore 8
    //   270: aload 8
    //   272: ifnonnull +17 -> 289
    //   275: aload 8
    //   277: ifnull +10 -> 287
    //   280: aload 8
    //   282: invokeinterface 173 1 0
    //   287: iconst_2
    //   288: ireturn
    //   289: aload 8
    //   291: astore 6
    //   293: aload 8
    //   295: astore 7
    //   297: aload 8
    //   299: invokeinterface 228 1 0
    //   304: istore 4
    //   306: iconst_m1
    //   307: istore_2
    //   308: iload 4
    //   310: ifle +70 -> 380
    //   313: aload 8
    //   315: astore 6
    //   317: aload 8
    //   319: astore 7
    //   321: aload 8
    //   323: invokeinterface 159 1 0
    //   328: ifeq +52 -> 380
    //   331: aload 8
    //   333: astore 6
    //   335: aload 8
    //   337: astore 7
    //   339: aload 8
    //   341: aload 8
    //   343: ldc_w 316
    //   346: invokeinterface 167 2 0
    //   351: invokeinterface 169 2 0
    //   356: istore_2
    //   357: iload_2
    //   358: ifne +6 -> 364
    //   361: goto +5 -> 366
    //   364: iconst_m1
    //   365: istore_1
    //   366: aload 8
    //   368: ifnull +10 -> 378
    //   371: aload 8
    //   373: invokeinterface 173 1 0
    //   378: iload_1
    //   379: ireturn
    //   380: aload 8
    //   382: astore 6
    //   384: aload 8
    //   386: astore 7
    //   388: aload_0
    //   389: getfield 30	com/tencent/token/anu:f	Landroid/content/Context;
    //   392: invokevirtual 147	android/content/Context:getPackageName	()Ljava/lang/String;
    //   395: invokevirtual 248	java/lang/String:getBytes	()[B
    //   398: astore 9
    //   400: aload 8
    //   402: astore 6
    //   404: aload 8
    //   406: astore 7
    //   408: new 277	javax/crypto/spec/SecretKeySpec
    //   411: dup
    //   412: ldc_w 318
    //   415: invokevirtual 248	java/lang/String:getBytes	()[B
    //   418: ldc 252
    //   420: invokespecial 289	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   423: astore 10
    //   425: aload 8
    //   427: astore 6
    //   429: aload 8
    //   431: astore 7
    //   433: ldc_w 320
    //   436: invokestatic 294	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   439: astore 11
    //   441: aload 8
    //   443: astore 6
    //   445: aload 8
    //   447: astore 7
    //   449: aload 11
    //   451: iconst_1
    //   452: aload 10
    //   454: invokevirtual 323	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   457: aload 8
    //   459: astore 6
    //   461: aload 8
    //   463: astore 7
    //   465: aload 11
    //   467: aload 9
    //   469: invokevirtual 308	javax/crypto/Cipher:doFinal	([B)[B
    //   472: invokestatic 310	com/tencent/token/anu:a	([B)Ljava/lang/String;
    //   475: astore 9
    //   477: aload 8
    //   479: astore 6
    //   481: aload 8
    //   483: astore 7
    //   485: aload_0
    //   486: getfield 30	com/tencent/token/anu:f	Landroid/content/Context;
    //   489: invokevirtual 141	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   492: ldc_w 312
    //   495: invokestatic 135	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   498: aconst_null
    //   499: ldc_w 314
    //   502: iconst_1
    //   503: anewarray 56	java/lang/String
    //   506: dup
    //   507: iconst_0
    //   508: aload 9
    //   510: aastore
    //   511: aconst_null
    //   512: invokevirtual 153	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   515: astore 8
    //   517: aload 8
    //   519: ifnonnull +17 -> 536
    //   522: aload 8
    //   524: ifnull +10 -> 534
    //   527: aload 8
    //   529: invokeinterface 173 1 0
    //   534: iconst_2
    //   535: ireturn
    //   536: aload 8
    //   538: astore 6
    //   540: aload 8
    //   542: astore 7
    //   544: aload 8
    //   546: invokeinterface 228 1 0
    //   551: ifle +72 -> 623
    //   554: aload 8
    //   556: astore 6
    //   558: aload 8
    //   560: astore 7
    //   562: aload 8
    //   564: invokeinterface 159 1 0
    //   569: ifeq +54 -> 623
    //   572: aload 8
    //   574: astore 6
    //   576: aload 8
    //   578: astore 7
    //   580: aload 8
    //   582: aload 8
    //   584: ldc_w 316
    //   587: invokeinterface 167 2 0
    //   592: invokeinterface 169 2 0
    //   597: istore_1
    //   598: iload_1
    //   599: ifne +8 -> 607
    //   602: iload_3
    //   603: istore_1
    //   604: goto +5 -> 609
    //   607: iconst_m1
    //   608: istore_1
    //   609: aload 8
    //   611: ifnull +10 -> 621
    //   614: aload 8
    //   616: invokeinterface 173 1 0
    //   621: iload_1
    //   622: ireturn
    //   623: aload 8
    //   625: astore 6
    //   627: aload 8
    //   629: astore 7
    //   631: aload_0
    //   632: getfield 30	com/tencent/token/anu:f	Landroid/content/Context;
    //   635: invokevirtual 141	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   638: ldc_w 312
    //   641: invokestatic 135	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   644: iconst_2
    //   645: anewarray 56	java/lang/String
    //   648: dup
    //   649: iconst_0
    //   650: ldc_w 325
    //   653: aastore
    //   654: dup
    //   655: iconst_1
    //   656: ldc_w 316
    //   659: aastore
    //   660: aconst_null
    //   661: aconst_null
    //   662: aconst_null
    //   663: invokevirtual 153	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   666: astore 8
    //   668: aload 8
    //   670: ifnonnull +17 -> 687
    //   673: aload 8
    //   675: ifnull +10 -> 685
    //   678: aload 8
    //   680: invokeinterface 173 1 0
    //   685: iconst_2
    //   686: ireturn
    //   687: iload_2
    //   688: istore_1
    //   689: aload 8
    //   691: astore 6
    //   693: aload 8
    //   695: astore 7
    //   697: aload 8
    //   699: invokeinterface 159 1 0
    //   704: ifeq +91 -> 795
    //   707: aload 8
    //   709: astore 6
    //   711: aload 8
    //   713: astore 7
    //   715: aload 8
    //   717: aload 8
    //   719: ldc_w 325
    //   722: invokeinterface 167 2 0
    //   727: invokeinterface 328 2 0
    //   732: astore 9
    //   734: aload 8
    //   736: astore 6
    //   738: aload 8
    //   740: astore 7
    //   742: aload 8
    //   744: aload 8
    //   746: ldc_w 316
    //   749: invokeinterface 167 2 0
    //   754: invokeinterface 169 2 0
    //   759: istore_3
    //   760: aload 8
    //   762: astore 6
    //   764: aload 8
    //   766: astore 7
    //   768: aload 9
    //   770: aload_0
    //   771: getfield 30	com/tencent/token/anu:f	Landroid/content/Context;
    //   774: invokevirtual 147	android/content/Context:getPackageName	()Ljava/lang/String;
    //   777: invokestatic 332	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   780: istore 5
    //   782: iload 5
    //   784: ifeq -97 -> 687
    //   787: iload_2
    //   788: istore_1
    //   789: iload_3
    //   790: ifne +5 -> 795
    //   793: iconst_0
    //   794: istore_1
    //   795: aload 8
    //   797: ifnull +10 -> 807
    //   800: aload 8
    //   802: invokeinterface 173 1 0
    //   807: iload_1
    //   808: ireturn
    //   809: astore 7
    //   811: aload 6
    //   813: ifnull +10 -> 823
    //   816: aload 6
    //   818: invokeinterface 173 1 0
    //   823: aload 7
    //   825: athrow
    //   826: aload 7
    //   828: ifnull +10 -> 838
    //   831: aload 7
    //   833: invokeinterface 173 1 0
    //   838: iconst_2
    //   839: ireturn
    //   840: astore 6
    //   842: goto -16 -> 826
    //   845: astore 6
    //   847: iconst_2
    //   848: ireturn
    //   849: astore 6
    //   851: iload_1
    //   852: ireturn
    //   853: astore 6
    //   855: iconst_2
    //   856: ireturn
    //   857: astore 6
    //   859: iload_1
    //   860: ireturn
    //   861: astore 6
    //   863: iconst_2
    //   864: ireturn
    //   865: astore 6
    //   867: iload_1
    //   868: ireturn
    //   869: astore 6
    //   871: goto -48 -> 823
    //   874: astore 6
    //   876: iconst_2
    //   877: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	878	0	this	anu
    //   238	630	1	n	int
    //   307	481	2	i1	int
    //   236	554	3	i2	int
    //   304	5	4	i3	int
    //   780	3	5	bool	boolean
    //   8	809	6	localCursor1	Cursor
    //   840	1	6	localThrowable1	Throwable
    //   845	1	6	localThrowable2	Throwable
    //   849	1	6	localThrowable3	Throwable
    //   853	1	6	localThrowable4	Throwable
    //   857	1	6	localThrowable5	Throwable
    //   861	1	6	localThrowable6	Throwable
    //   865	1	6	localThrowable7	Throwable
    //   869	1	6	localThrowable8	Throwable
    //   874	1	6	localThrowable9	Throwable
    //   12	755	7	localObject1	Object
    //   809	23	7	localObject2	Object
    //   4	797	8	localCursor2	Cursor
    //   1	768	9	localObject3	Object
    //   24	429	10	localObject4	Object
    //   39	427	11	localObject5	Object
    //   54	196	12	localObject6	Object
    //   73	31	13	localSecureRandom	java.security.SecureRandom
    // Exception table:
    //   from	to	target	type
    //   14	26	809	finally
    //   34	41	809	finally
    //   49	56	809	finally
    //   64	75	809	finally
    //   83	90	809	finally
    //   98	108	809	finally
    //   116	137	809	finally
    //   145	152	809	finally
    //   160	182	809	finally
    //   190	202	809	finally
    //   210	219	809	finally
    //   227	235	809	finally
    //   247	270	809	finally
    //   297	306	809	finally
    //   321	331	809	finally
    //   339	357	809	finally
    //   388	400	809	finally
    //   408	425	809	finally
    //   433	441	809	finally
    //   449	457	809	finally
    //   465	477	809	finally
    //   485	517	809	finally
    //   544	554	809	finally
    //   562	572	809	finally
    //   580	598	809	finally
    //   631	668	809	finally
    //   697	707	809	finally
    //   715	734	809	finally
    //   742	760	809	finally
    //   768	782	809	finally
    //   14	26	840	java/lang/Throwable
    //   34	41	840	java/lang/Throwable
    //   49	56	840	java/lang/Throwable
    //   64	75	840	java/lang/Throwable
    //   83	90	840	java/lang/Throwable
    //   98	108	840	java/lang/Throwable
    //   116	137	840	java/lang/Throwable
    //   145	152	840	java/lang/Throwable
    //   160	182	840	java/lang/Throwable
    //   190	202	840	java/lang/Throwable
    //   210	219	840	java/lang/Throwable
    //   227	235	840	java/lang/Throwable
    //   247	270	840	java/lang/Throwable
    //   297	306	840	java/lang/Throwable
    //   321	331	840	java/lang/Throwable
    //   339	357	840	java/lang/Throwable
    //   388	400	840	java/lang/Throwable
    //   408	425	840	java/lang/Throwable
    //   433	441	840	java/lang/Throwable
    //   449	457	840	java/lang/Throwable
    //   465	477	840	java/lang/Throwable
    //   485	517	840	java/lang/Throwable
    //   544	554	840	java/lang/Throwable
    //   562	572	840	java/lang/Throwable
    //   580	598	840	java/lang/Throwable
    //   631	668	840	java/lang/Throwable
    //   697	707	840	java/lang/Throwable
    //   715	734	840	java/lang/Throwable
    //   742	760	840	java/lang/Throwable
    //   768	782	840	java/lang/Throwable
    //   280	287	845	java/lang/Throwable
    //   371	378	849	java/lang/Throwable
    //   527	534	853	java/lang/Throwable
    //   614	621	857	java/lang/Throwable
    //   678	685	861	java/lang/Throwable
    //   800	807	865	java/lang/Throwable
    //   816	823	869	java/lang/Throwable
    //   831	838	874	java/lang/Throwable
  }
  
  private int d()
  {
    String str = this.f.getPackageName();
    int n = 2;
    for (;;)
    {
      try
      {
        localContentResolver = this.f.getContentResolver();
        localObject3 = localContentResolver.query(Uri.parse("content://com.vivo.upslide.speedup.provider/speedupwhitelist"), new String[] { "pkgname" }, "pkgname=?", new String[] { str }, null);
        localObject1 = localObject3;
        if (localObject3 != null) {
          continue;
        }
      }
      catch (Throwable localThrowable1)
      {
        Object localObject3;
        try
        {
          ContentResolver localContentResolver;
          Object localObject1;
          boolean bool;
          ((Cursor)localObject1).close();
          return n;
        }
        catch (Throwable localThrowable3)
        {
          return n;
        }
        localThrowable1 = localThrowable1;
        continue;
        Object localObject2;
        if (localObject2 != null) {
          continue;
        }
      }
      try
      {
        localObject1 = localContentResolver.query(Uri.parse("content://com.iqoo.secure.provider.secureprovider/speedupwhitelist"), new String[] { "pkgname" }, "pkgname=?", new String[] { str }, null);
      }
      catch (Throwable localThrowable2)
      {
        localObject2 = localObject3;
        continue;
      }
      localObject3 = localObject1;
      if (((Cursor)localObject1).moveToNext())
      {
        localObject3 = localObject1;
        bool = TextUtils.equals(((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("pkgname")), str);
        if (!bool) {
          continue;
        }
        n = 0;
      }
      else
      {
        n = -1;
        continue;
        localObject1 = null;
      }
      if (localObject1 == null) {
        break;
      }
    }
    return 2;
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
    //   18: if_icmplt +221 -> 239
    //   21: aconst_null
    //   22: astore 9
    //   24: aconst_null
    //   25: astore 7
    //   27: aload 7
    //   29: astore 8
    //   31: aload 9
    //   33: astore 6
    //   35: aload_0
    //   36: getfield 30	com/tencent/token/anu:f	Landroid/content/Context;
    //   39: invokevirtual 141	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   42: astore 10
    //   44: aload 7
    //   46: astore 8
    //   48: aload 9
    //   50: astore 6
    //   52: ldc_w 342
    //   55: invokestatic 135	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   58: astore 11
    //   60: aload 7
    //   62: astore 8
    //   64: aload 9
    //   66: astore 6
    //   68: aload_0
    //   69: getfield 30	com/tencent/token/anu:f	Landroid/content/Context;
    //   72: invokevirtual 147	android/content/Context:getPackageName	()Ljava/lang/String;
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
    //   95: ldc 243
    //   97: aastore
    //   98: ldc 143
    //   100: iconst_1
    //   101: anewarray 56	java/lang/String
    //   104: dup
    //   105: iconst_0
    //   106: aload 12
    //   108: aastore
    //   109: aconst_null
    //   110: invokevirtual 153	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   113: astore 7
    //   115: iload_3
    //   116: istore_1
    //   117: aload 7
    //   119: ifnull +69 -> 188
    //   122: iload_3
    //   123: istore_1
    //   124: aload 7
    //   126: astore 8
    //   128: aload 7
    //   130: astore 6
    //   132: aload 7
    //   134: invokeinterface 228 1 0
    //   139: ifle +49 -> 188
    //   142: iload_3
    //   143: istore_1
    //   144: aload 7
    //   146: astore 8
    //   148: aload 7
    //   150: astore 6
    //   152: aload 7
    //   154: invokeinterface 159 1 0
    //   159: ifeq +29 -> 188
    //   162: aload 7
    //   164: astore 8
    //   166: aload 7
    //   168: astore 6
    //   170: aload 7
    //   172: iconst_0
    //   173: invokeinterface 169 2 0
    //   178: istore_2
    //   179: iload_3
    //   180: istore_1
    //   181: iload_2
    //   182: iconst_1
    //   183: if_icmpne +5 -> 188
    //   186: iconst_m1
    //   187: istore_1
    //   188: iload_1
    //   189: istore_2
    //   190: aload 7
    //   192: ifnull +47 -> 239
    //   195: aload 7
    //   197: astore 6
    //   199: aload 6
    //   201: invokeinterface 173 1 0
    //   206: iload_1
    //   207: ireturn
    //   208: astore 6
    //   210: aload 8
    //   212: ifnull +10 -> 222
    //   215: aload 8
    //   217: invokeinterface 173 1 0
    //   222: aload 6
    //   224: athrow
    //   225: iload 5
    //   227: istore_2
    //   228: aload 6
    //   230: ifnull +9 -> 239
    //   233: iload 4
    //   235: istore_1
    //   236: goto -37 -> 199
    //   239: iload_2
    //   240: ireturn
    //   241: astore 7
    //   243: goto -18 -> 225
    //   246: astore 6
    //   248: iload_1
    //   249: ireturn
    //   250: astore 7
    //   252: goto -30 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	this	anu
    //   3	246	1	n	int
    //   14	226	2	i1	int
    //   11	169	3	i2	int
    //   5	229	4	i3	int
    //   8	218	5	i4	int
    //   33	167	6	localObject1	Object
    //   208	21	6	localObject2	Object
    //   246	1	6	localThrowable1	Throwable
    //   25	171	7	localCursor1	Cursor
    //   241	1	7	localThrowable2	Throwable
    //   250	1	7	localThrowable3	Throwable
    //   29	187	8	localCursor2	Cursor
    //   22	60	9	localObject3	Object
    //   42	44	10	localContentResolver	ContentResolver
    //   58	30	11	localUri	Uri
    //   75	32	12	str	String
    // Exception table:
    //   from	to	target	type
    //   35	44	208	finally
    //   52	60	208	finally
    //   68	77	208	finally
    //   85	115	208	finally
    //   132	142	208	finally
    //   152	162	208	finally
    //   170	179	208	finally
    //   35	44	241	java/lang/Throwable
    //   52	60	241	java/lang/Throwable
    //   68	77	241	java/lang/Throwable
    //   85	115	241	java/lang/Throwable
    //   132	142	241	java/lang/Throwable
    //   152	162	241	java/lang/Throwable
    //   170	179	241	java/lang/Throwable
    //   199	206	246	java/lang/Throwable
    //   215	222	250	java/lang/Throwable
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
    //   18: if_icmplt +221 -> 239
    //   21: aconst_null
    //   22: astore 9
    //   24: aconst_null
    //   25: astore 7
    //   27: aload 7
    //   29: astore 8
    //   31: aload 9
    //   33: astore 6
    //   35: aload_0
    //   36: getfield 30	com/tencent/token/anu:f	Landroid/content/Context;
    //   39: invokevirtual 141	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   42: astore 10
    //   44: aload 7
    //   46: astore 8
    //   48: aload 9
    //   50: astore 6
    //   52: ldc_w 344
    //   55: invokestatic 135	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   58: astore 11
    //   60: aload 7
    //   62: astore 8
    //   64: aload 9
    //   66: astore 6
    //   68: aload_0
    //   69: getfield 30	com/tencent/token/anu:f	Landroid/content/Context;
    //   72: invokevirtual 147	android/content/Context:getPackageName	()Ljava/lang/String;
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
    //   95: ldc 243
    //   97: aastore
    //   98: ldc 143
    //   100: iconst_1
    //   101: anewarray 56	java/lang/String
    //   104: dup
    //   105: iconst_0
    //   106: aload 12
    //   108: aastore
    //   109: aconst_null
    //   110: invokevirtual 153	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   113: astore 7
    //   115: iload_3
    //   116: istore_1
    //   117: aload 7
    //   119: ifnull +69 -> 188
    //   122: iload_3
    //   123: istore_1
    //   124: aload 7
    //   126: astore 8
    //   128: aload 7
    //   130: astore 6
    //   132: aload 7
    //   134: invokeinterface 228 1 0
    //   139: ifle +49 -> 188
    //   142: iload_3
    //   143: istore_1
    //   144: aload 7
    //   146: astore 8
    //   148: aload 7
    //   150: astore 6
    //   152: aload 7
    //   154: invokeinterface 159 1 0
    //   159: ifeq +29 -> 188
    //   162: aload 7
    //   164: astore 8
    //   166: aload 7
    //   168: astore 6
    //   170: aload 7
    //   172: iconst_0
    //   173: invokeinterface 169 2 0
    //   178: istore_2
    //   179: iload_3
    //   180: istore_1
    //   181: iload_2
    //   182: iconst_1
    //   183: if_icmpne +5 -> 188
    //   186: iconst_m1
    //   187: istore_1
    //   188: iload_1
    //   189: istore_2
    //   190: aload 7
    //   192: ifnull +47 -> 239
    //   195: aload 7
    //   197: astore 6
    //   199: aload 6
    //   201: invokeinterface 173 1 0
    //   206: iload_1
    //   207: ireturn
    //   208: astore 6
    //   210: aload 8
    //   212: ifnull +10 -> 222
    //   215: aload 8
    //   217: invokeinterface 173 1 0
    //   222: aload 6
    //   224: athrow
    //   225: iload 5
    //   227: istore_2
    //   228: aload 6
    //   230: ifnull +9 -> 239
    //   233: iload 4
    //   235: istore_1
    //   236: goto -37 -> 199
    //   239: iload_2
    //   240: ireturn
    //   241: astore 7
    //   243: goto -18 -> 225
    //   246: astore 6
    //   248: iload_1
    //   249: ireturn
    //   250: astore 7
    //   252: goto -30 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	this	anu
    //   3	246	1	n	int
    //   14	226	2	i1	int
    //   11	169	3	i2	int
    //   5	229	4	i3	int
    //   8	218	5	i4	int
    //   33	167	6	localObject1	Object
    //   208	21	6	localObject2	Object
    //   246	1	6	localThrowable1	Throwable
    //   25	171	7	localCursor1	Cursor
    //   241	1	7	localThrowable2	Throwable
    //   250	1	7	localThrowable3	Throwable
    //   29	187	8	localCursor2	Cursor
    //   22	60	9	localObject3	Object
    //   42	44	10	localContentResolver	ContentResolver
    //   58	30	11	localUri	Uri
    //   75	32	12	str	String
    // Exception table:
    //   from	to	target	type
    //   35	44	208	finally
    //   52	60	208	finally
    //   68	77	208	finally
    //   85	115	208	finally
    //   132	142	208	finally
    //   152	162	208	finally
    //   170	179	208	finally
    //   35	44	241	java/lang/Throwable
    //   52	60	241	java/lang/Throwable
    //   68	77	241	java/lang/Throwable
    //   85	115	241	java/lang/Throwable
    //   132	142	241	java/lang/Throwable
    //   152	162	241	java/lang/Throwable
    //   170	179	241	java/lang/Throwable
    //   199	206	246	java/lang/Throwable
    //   215	222	250	java/lang/Throwable
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
  
  public final int a(int paramInt)
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
      return super.a(paramInt);
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
 * Qualified Name:     com.tencent.token.anu
 * JD-Core Version:    0.7.0.1
 */