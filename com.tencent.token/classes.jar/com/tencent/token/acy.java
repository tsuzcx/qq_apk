package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.turingfd.sdk.qps.Canesatici;
import com.tencent.turingfd.sdk.qps.CanisMinor;
import com.tencent.turingfd.sdk.qps.do;
import com.tencent.turingfd.sdk.qps.final;
import java.security.Key;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.crypto.Cipher;

public final class acy
{
  public static final agi<acy> a = new a();
  public b b;
  public final AtomicBoolean c = new AtomicBoolean(false);
  
  public static acy a()
  {
    return (acy)a.b();
  }
  
  public final ada a(int paramInt1, int paramInt2, int paramInt3, final paramfinal1, final paramfinal2, byte[] paramArrayOfByte, long paramLong)
  {
    final Object localObject1;
    final AtomicReference localAtomicReference;
    AtomicBoolean localAtomicBoolean;
    label167:
    label191:
    try
    {
      if (this.c.get())
      {
        localObject1 = new Object();
        localAtomicReference = new AtomicReference();
        localAtomicBoolean = new AtomicBoolean(false);
        Object localObject2 = new ada.a();
        ((ada.a)localObject2).a = -4;
        localAtomicReference.set(new ada((ada.a)localObject2));
        localObject2 = new c(localAtomicBoolean, localAtomicReference, localObject1);
        b localb = this.b;
        acz.a locala = new acz.a(paramInt1, paramInt2, paramInt3);
        locala.e = paramArrayOfByte;
        locala.f = paramfinal2;
        locala.d = paramfinal1;
        locala.a = ((acz.b)localObject2);
        Message.obtain(localb, 2, new acz(locala)).sendToTarget();
      }
    }
    finally {}
    try
    {
      try
      {
        localObject1.wait(paramLong);
      }
      finally
      {
        break label191;
      }
    }
    catch (InterruptedException paramfinal1)
    {
      break label167;
    }
    localAtomicBoolean.set(true);
    paramfinal1 = (ada)localAtomicReference.get();
    return paramfinal1;
    throw paramfinal1;
    throw new RuntimeException("Must call after initialized");
  }
  
  public final class a
    extends agi<acy>
  {
    public final Object a()
    {
      return new acy();
    }
  }
  
  public static final class b
    extends Handler
  {
    public int a = 1;
    public do b;
    public acx c;
    public abx d;
    
    public b(Looper paramLooper, abx paramabx)
    {
      super();
      paramLooper = new do();
      this.b = paramLooper;
      paramLooper.f = 61;
      this.c = new acx();
      this.d = paramabx;
    }
    
    private ada a()
    {
      System.currentTimeMillis();
      Object localObject1 = this.c;
      localObject1.getClass();
      Object localObject3 = new SecureRandom();
      Object localObject5 = new StringBuilder();
      int i = 0;
      while (i < 16)
      {
        ((StringBuilder)localObject5).append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(((SecureRandom)localObject3).nextInt(62)));
        i += 1;
      }
      localObject3 = ((StringBuilder)localObject5).toString();
      ((acx)localObject1).b = ((String)localObject3);
      boolean bool = TextUtils.isEmpty((CharSequence)localObject3);
      localObject1 = null;
      if (!bool) {
        try
        {
          localObject5 = afq.a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDb49jFnNqMDLdl87UtY5jOMqqdMuvQg65Zuva3Qm1tORQGBuM04u7fqygA64XbOx9e/KPNkDNDmqS8SlsAPL1fV2lqM/phgV0NY62TJqSR+PLngwJd2rhYR8wQ1N0JE+R59a5c08EGsd6axStjHsVu2+evCf/SWU9Y/oQpEtOjGwIDAQAB");
          localObject5 = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec((byte[])localObject5));
          Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
          localCipher.init(1, (Key)localObject5);
          localObject3 = localCipher.doFinal(((String)localObject3).getBytes());
          localObject1 = localObject3;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      Object localObject4 = new Canesatici();
      ((Canesatici)localObject4).b = ((byte[])localObject1);
      localObject1 = new acz.a(152, 10152, 0);
      ((acz.a)localObject1).d = ((final)localObject4);
      ((acz.a)localObject1).f = new CanisMinor();
      localObject4 = new acz((acz.a)localObject1);
      try
      {
        localObject1 = agn.a;
        localObject1 = a((Context)localObject1, (acz)localObject4);
        if (!((ada)localObject1).a()) {
          return localObject1;
        }
        localObject4 = agn.a(((ada)localObject1).b, ((acz)localObject4).g);
        if ((localObject4 instanceof CanisMinor))
        {
          localObject4 = (CanisMinor)localObject4;
          localObject5 = this.c;
          localObject5.getClass();
          ((acx)localObject5).c = System.currentTimeMillis();
          ((acx)localObject5).d = (((CanisMinor)localObject4).b * 1000 / 10);
          ((acx)localObject5).a = ((CanisMinor)localObject4).a;
          return localObject1;
        }
        return ada.a(-10);
      }
      finally {}
    }
    
    /* Error */
    private ada a(Context paramContext)
    {
      // Byte code:
      //   0: invokestatic 48	java/lang/System:currentTimeMillis	()J
      //   3: pop2
      //   4: getstatic 198	com/tencent/token/acs:a	Ljava/lang/String;
      //   7: astore 13
      //   9: iconst_m1
      //   10: istore_3
      //   11: aload_1
      //   12: ldc 200
      //   14: invokevirtual 206	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
      //   17: checkcast 208	android/view/WindowManager
      //   20: astore 13
      //   22: new 210	android/util/DisplayMetrics
      //   25: dup
      //   26: invokespecial 211	android/util/DisplayMetrics:<init>	()V
      //   29: astore 14
      //   31: aload 13
      //   33: invokeinterface 215 1 0
      //   38: aload 14
      //   40: invokevirtual 221	android/view/Display:getMetrics	(Landroid/util/DisplayMetrics;)V
      //   43: aload 14
      //   45: getfield 224	android/util/DisplayMetrics:widthPixels	I
      //   48: istore_2
      //   49: goto +5 -> 54
      //   52: iconst_m1
      //   53: istore_2
      //   54: aload_1
      //   55: ldc 200
      //   57: invokevirtual 206	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
      //   60: checkcast 208	android/view/WindowManager
      //   63: astore 13
      //   65: new 210	android/util/DisplayMetrics
      //   68: dup
      //   69: invokespecial 211	android/util/DisplayMetrics:<init>	()V
      //   72: astore 14
      //   74: aload 13
      //   76: invokeinterface 215 1 0
      //   81: aload 14
      //   83: invokevirtual 221	android/view/Display:getMetrics	(Landroid/util/DisplayMetrics;)V
      //   86: aload 14
      //   88: getfield 227	android/util/DisplayMetrics:heightPixels	I
      //   91: istore 4
      //   93: iload 4
      //   95: istore_3
      //   96: iload_2
      //   97: iload_3
      //   98: if_icmplt +6 -> 104
      //   101: goto +11 -> 112
      //   104: iload_2
      //   105: istore 4
      //   107: iload_3
      //   108: istore_2
      //   109: iload 4
      //   111: istore_3
      //   112: new 229	com/tencent/turingfd/sdk/qps/if
      //   115: dup
      //   116: invokespecial 230	com/tencent/turingfd/sdk/qps/if:<init>	()V
      //   119: astore 16
      //   121: aload 16
      //   123: ldc 232
      //   125: putfield 235	com/tencent/turingfd/sdk/qps/if:L	Ljava/lang/String;
      //   128: aload 16
      //   130: ldc 237
      //   132: putfield 239	com/tencent/turingfd/sdk/qps/if:d	Ljava/lang/String;
      //   135: aload 16
      //   137: ldc 237
      //   139: putfield 242	com/tencent/turingfd/sdk/qps/if:e	Ljava/lang/String;
      //   142: aload 16
      //   144: bipush 92
      //   146: putfield 243	com/tencent/turingfd/sdk/qps/if:f	I
      //   149: aload 16
      //   151: ldc 245
      //   153: putfield 247	com/tencent/turingfd/sdk/qps/if:g	Ljava/lang/String;
      //   156: aload 16
      //   158: bipush 61
      //   160: putfield 250	com/tencent/turingfd/sdk/qps/if:h	I
      //   163: new 59	java/lang/StringBuilder
      //   166: dup
      //   167: invokespecial 60	java/lang/StringBuilder:<init>	()V
      //   170: astore 13
      //   172: aload 13
      //   174: getstatic 253	com/tencent/token/agh:a	I
      //   177: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   180: pop
      //   181: aload 16
      //   183: aload 13
      //   185: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   188: putfield 259	com/tencent/turingfd/sdk/qps/if:i	Ljava/lang/String;
      //   191: aload 16
      //   193: iconst_2
      //   194: putfield 262	com/tencent/turingfd/sdk/qps/if:j	I
      //   197: aload 16
      //   199: sipush 201
      //   202: putfield 265	com/tencent/turingfd/sdk/qps/if:k	I
      //   205: aload 16
      //   207: iconst_0
      //   208: putfield 269	com/tencent/turingfd/sdk/qps/if:l	Z
      //   211: aload 16
      //   213: aload_1
      //   214: invokevirtual 272	android/content/Context:getPackageName	()Ljava/lang/String;
      //   217: putfield 275	com/tencent/turingfd/sdk/qps/if:m	Ljava/lang/String;
      //   220: getstatic 280	android/os/Build:MODEL	Ljava/lang/String;
      //   223: astore 14
      //   225: aload 14
      //   227: astore 13
      //   229: aload 14
      //   231: ifnonnull +7 -> 238
      //   234: ldc 232
      //   236: astore 13
      //   238: aload 16
      //   240: aload 13
      //   242: putfield 283	com/tencent/turingfd/sdk/qps/if:n	Ljava/lang/String;
      //   245: aload 16
      //   247: getstatic 288	android/os/Build$VERSION:SDK_INT	I
      //   250: putfield 291	com/tencent/turingfd/sdk/qps/if:o	I
      //   253: aload 16
      //   255: sipush 2052
      //   258: putfield 295	com/tencent/turingfd/sdk/qps/if:q	S
      //   261: aload 16
      //   263: iconst_1
      //   264: putfield 298	com/tencent/turingfd/sdk/qps/if:r	I
      //   267: invokestatic 302	com/tencent/token/ade:a	()Ljava/lang/String;
      //   270: pop
      //   271: aload 16
      //   273: ldc 232
      //   275: putfield 305	com/tencent/turingfd/sdk/qps/if:V	Ljava/lang/String;
      //   278: new 59	java/lang/StringBuilder
      //   281: dup
      //   282: invokespecial 60	java/lang/StringBuilder:<init>	()V
      //   285: astore 17
      //   287: getstatic 307	com/tencent/token/ade:a	J
      //   290: lstore 5
      //   292: lconst_0
      //   293: lstore 9
      //   295: aconst_null
      //   296: astore 15
      //   298: ldc2_w 308
      //   301: lload 5
      //   303: lcmp
      //   304: ifne +238 -> 542
      //   307: new 311	java/io/InputStreamReader
      //   310: dup
      //   311: new 313	java/io/FileInputStream
      //   314: dup
      //   315: ldc_w 315
      //   318: invokespecial 318	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
      //   321: ldc_w 320
      //   324: invokespecial 323	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
      //   327: astore 14
      //   329: new 325	java/io/BufferedReader
      //   332: dup
      //   333: aload 14
      //   335: invokespecial 328	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   338: astore 13
      //   340: aload 13
      //   342: invokevirtual 331	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   345: astore 18
      //   347: aload 18
      //   349: ifnonnull +44 -> 393
      //   352: aload 14
      //   354: invokevirtual 334	java/io/InputStreamReader:close	()V
      //   357: aload 13
      //   359: invokevirtual 335	java/io/BufferedReader:close	()V
      //   362: aload 14
      //   364: invokevirtual 334	java/io/InputStreamReader:close	()V
      //   367: aload 13
      //   369: invokevirtual 335	java/io/BufferedReader:close	()V
      //   372: goto +15 -> 387
      //   375: astore 13
      //   377: aload 13
      //   379: invokevirtual 338	java/io/IOException:getMessage	()Ljava/lang/String;
      //   382: aload 13
      //   384: invokestatic 343	com/tencent/token/afr:a	(Ljava/lang/Object;Ljava/lang/Throwable;)V
      //   387: lconst_0
      //   388: lstore 5
      //   390: goto +152 -> 542
      //   393: aload 18
      //   395: invokevirtual 346	java/lang/String:trim	()Ljava/lang/String;
      //   398: astore 18
      //   400: aload 18
      //   402: invokevirtual 350	java/lang/String:length	()I
      //   405: ifle +13 -> 418
      //   408: aload 18
      //   410: invokestatic 356	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   413: lstore 5
      //   415: goto +6 -> 421
      //   418: lconst_0
      //   419: lstore 5
      //   421: lload 5
      //   423: lstore 7
      //   425: aload 14
      //   427: invokevirtual 334	java/io/InputStreamReader:close	()V
      //   430: goto +70 -> 500
      //   433: goto +25 -> 458
      //   436: goto +35 -> 471
      //   439: aconst_null
      //   440: astore 13
      //   442: goto +16 -> 458
      //   445: aconst_null
      //   446: astore 13
      //   448: goto +23 -> 471
      //   451: aconst_null
      //   452: astore 13
      //   454: aload 13
      //   456: astore 14
      //   458: aload 14
      //   460: ifnull +1555 -> 2015
      //   463: aload 14
      //   465: invokevirtual 334	java/io/InputStreamReader:close	()V
      //   468: goto +1547 -> 2015
      //   471: aload 14
      //   473: ifnull +19 -> 492
      //   476: aload 14
      //   478: invokevirtual 334	java/io/InputStreamReader:close	()V
      //   481: goto +11 -> 492
      //   484: astore 13
      //   486: lconst_0
      //   487: lstore 5
      //   489: goto +29 -> 518
      //   492: aload 13
      //   494: ifnull +37 -> 531
      //   497: lconst_0
      //   498: lstore 5
      //   500: lload 5
      //   502: lstore 7
      //   504: aload 13
      //   506: invokevirtual 335	java/io/BufferedReader:close	()V
      //   509: goto +25 -> 534
      //   512: astore 13
      //   514: lload 7
      //   516: lstore 5
      //   518: aload 13
      //   520: invokevirtual 338	java/io/IOException:getMessage	()Ljava/lang/String;
      //   523: aload 13
      //   525: invokestatic 343	com/tencent/token/afr:a	(Ljava/lang/Object;Ljava/lang/Throwable;)V
      //   528: goto +6 -> 534
      //   531: lconst_0
      //   532: lstore 5
      //   534: lload 5
      //   536: putstatic 307	com/tencent/token/ade:a	J
      //   539: goto +3 -> 542
      //   542: aload 17
      //   544: lload 5
      //   546: invokevirtual 359	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   549: pop
      //   550: aload 17
      //   552: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   555: astore 14
      //   557: aload 14
      //   559: astore 13
      //   561: aload 14
      //   563: ifnonnull +7 -> 570
      //   566: ldc 232
      //   568: astore 13
      //   570: aload 16
      //   572: aload 13
      //   574: putfield 362	com/tencent/turingfd/sdk/qps/if:t	Ljava/lang/String;
      //   577: getstatic 365	com/tencent/token/ade:b	Ljava/lang/Integer;
      //   580: ifnonnull +52 -> 632
      //   583: new 367	com/tencent/token/add
      //   586: dup
      //   587: invokespecial 368	com/tencent/token/add:<init>	()V
      //   590: astore 13
      //   592: new 370	java/io/File
      //   595: dup
      //   596: ldc_w 372
      //   599: invokespecial 373	java/io/File:<init>	(Ljava/lang/String;)V
      //   602: aload 13
      //   604: invokevirtual 377	java/io/File:listFiles	(Ljava/io/FileFilter;)[Ljava/io/File;
      //   607: astore 13
      //   609: aload 13
      //   611: ifnull +15 -> 626
      //   614: aload 13
      //   616: arraylength
      //   617: invokestatic 383	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   620: putstatic 365	com/tencent/token/ade:b	Ljava/lang/Integer;
      //   623: goto +9 -> 632
      //   626: iconst_1
      //   627: istore 4
      //   629: goto +11 -> 640
      //   632: getstatic 365	com/tencent/token/ade:b	Ljava/lang/Integer;
      //   635: invokevirtual 386	java/lang/Integer:intValue	()I
      //   638: istore 4
      //   640: aload 16
      //   642: iload 4
      //   644: putfield 389	com/tencent/turingfd/sdk/qps/if:u	I
      //   647: new 59	java/lang/StringBuilder
      //   650: dup
      //   651: invokespecial 60	java/lang/StringBuilder:<init>	()V
      //   654: astore 13
      //   656: aload 13
      //   658: iload_2
      //   659: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   662: pop
      //   663: aload 13
      //   665: ldc_w 391
      //   668: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   671: pop
      //   672: aload 13
      //   674: iload_3
      //   675: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   678: pop
      //   679: aload 16
      //   681: aload 13
      //   683: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   686: putfield 397	com/tencent/turingfd/sdk/qps/if:v	Ljava/lang/String;
      //   689: invokestatic 403	android/os/Environment:getRootDirectory	()Ljava/io/File;
      //   692: astore 14
      //   694: aload 14
      //   696: astore 13
      //   698: aload 14
      //   700: invokevirtual 406	java/io/File:exists	()Z
      //   703: ifne +15 -> 718
      //   706: new 370	java/io/File
      //   709: dup
      //   710: ldc_w 408
      //   713: invokespecial 373	java/io/File:<init>	(Ljava/lang/String;)V
      //   716: astore 13
      //   718: new 410	android/os/StatFs
      //   721: dup
      //   722: aload 13
      //   724: invokevirtual 413	java/io/File:getPath	()Ljava/lang/String;
      //   727: invokespecial 414	android/os/StatFs:<init>	(Ljava/lang/String;)V
      //   730: astore 13
      //   732: aload 13
      //   734: invokevirtual 417	android/os/StatFs:getBlockSize	()I
      //   737: i2l
      //   738: lstore 5
      //   740: aload 13
      //   742: invokevirtual 420	android/os/StatFs:getBlockCount	()I
      //   745: istore_2
      //   746: iload_2
      //   747: i2l
      //   748: lstore 7
      //   750: invokestatic 423	android/os/Environment:getDataDirectory	()Ljava/io/File;
      //   753: astore 14
      //   755: aload 14
      //   757: astore 13
      //   759: aload 14
      //   761: invokevirtual 406	java/io/File:exists	()Z
      //   764: ifne +15 -> 779
      //   767: new 370	java/io/File
      //   770: dup
      //   771: ldc_w 425
      //   774: invokespecial 373	java/io/File:<init>	(Ljava/lang/String;)V
      //   777: astore 13
      //   779: new 410	android/os/StatFs
      //   782: dup
      //   783: aload 13
      //   785: invokevirtual 413	java/io/File:getPath	()Ljava/lang/String;
      //   788: invokespecial 414	android/os/StatFs:<init>	(Ljava/lang/String;)V
      //   791: astore 13
      //   793: aload 13
      //   795: invokevirtual 417	android/os/StatFs:getBlockSize	()I
      //   798: i2l
      //   799: lstore 11
      //   801: aload 13
      //   803: invokevirtual 420	android/os/StatFs:getBlockCount	()I
      //   806: istore_2
      //   807: lload 11
      //   809: iload_2
      //   810: i2l
      //   811: lmul
      //   812: lstore 9
      //   814: lload 9
      //   816: lload 5
      //   818: lload 7
      //   820: lmul
      //   821: ladd
      //   822: lstore 9
      //   824: aload 16
      //   826: lload 9
      //   828: putfield 428	com/tencent/turingfd/sdk/qps/if:x	J
      //   831: getstatic 431	android/os/Build:BRAND	Ljava/lang/String;
      //   834: astore 14
      //   836: aload 14
      //   838: astore 13
      //   840: aload 14
      //   842: ifnonnull +7 -> 849
      //   845: ldc 232
      //   847: astore 13
      //   849: aload 16
      //   851: aload 13
      //   853: putfield 434	com/tencent/turingfd/sdk/qps/if:z	Ljava/lang/String;
      //   856: getstatic 437	android/os/Build$VERSION:INCREMENTAL	Ljava/lang/String;
      //   859: astore 14
      //   861: aload 14
      //   863: astore 13
      //   865: aload 14
      //   867: ifnonnull +7 -> 874
      //   870: ldc 232
      //   872: astore 13
      //   874: aload 16
      //   876: aload 13
      //   878: putfield 440	com/tencent/turingfd/sdk/qps/if:A	Ljava/lang/String;
      //   881: getstatic 443	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
      //   884: astore 14
      //   886: aload 14
      //   888: astore 13
      //   890: aload 14
      //   892: ifnonnull +7 -> 899
      //   895: ldc 232
      //   897: astore 13
      //   899: aload 16
      //   901: aload 13
      //   903: putfield 446	com/tencent/turingfd/sdk/qps/if:B	Ljava/lang/String;
      //   906: aload 16
      //   908: ldc_w 448
      //   911: putfield 451	com/tencent/turingfd/sdk/qps/if:P	Ljava/lang/String;
      //   914: aload 16
      //   916: iconst_1
      //   917: putfield 454	com/tencent/turingfd/sdk/qps/if:Q	I
      //   920: aload 16
      //   922: ldc 232
      //   924: putfield 457	com/tencent/turingfd/sdk/qps/if:R	Ljava/lang/String;
      //   927: getstatic 460	android/os/Build:MANUFACTURER	Ljava/lang/String;
      //   930: astore 14
      //   932: aload 14
      //   934: astore 13
      //   936: aload 14
      //   938: ifnonnull +8 -> 946
      //   941: ldc_w 462
      //   944: astore 13
      //   946: aload 16
      //   948: aload 13
      //   950: putfield 465	com/tencent/turingfd/sdk/qps/if:E	Ljava/lang/String;
      //   953: aload 16
      //   955: iconst_0
      //   956: putfield 468	com/tencent/turingfd/sdk/qps/if:H	I
      //   959: aload 16
      //   961: iconst_0
      //   962: putfield 470	com/tencent/turingfd/sdk/qps/if:I	I
      //   965: getstatic 473	android/os/Build:DEVICE	Ljava/lang/String;
      //   968: astore 14
      //   970: aload 14
      //   972: astore 13
      //   974: aload 14
      //   976: ifnonnull +7 -> 983
      //   979: ldc 232
      //   981: astore 13
      //   983: aload 16
      //   985: aload 13
      //   987: putfield 475	com/tencent/turingfd/sdk/qps/if:S	Ljava/lang/String;
      //   990: getstatic 478	android/os/Build:BOARD	Ljava/lang/String;
      //   993: astore 14
      //   995: aload 14
      //   997: astore 13
      //   999: aload 14
      //   1001: ifnonnull +7 -> 1008
      //   1004: ldc 232
      //   1006: astore 13
      //   1008: aload 16
      //   1010: aload 13
      //   1012: putfield 481	com/tencent/turingfd/sdk/qps/if:T	Ljava/lang/String;
      //   1015: invokestatic 302	com/tencent/token/ade:a	()Ljava/lang/String;
      //   1018: pop
      //   1019: aload 16
      //   1021: ldc 232
      //   1023: putfield 484	com/tencent/turingfd/sdk/qps/if:U	Ljava/lang/String;
      //   1026: invokestatic 302	com/tencent/token/ade:a	()Ljava/lang/String;
      //   1029: pop
      //   1030: aload 16
      //   1032: ldc 232
      //   1034: putfield 487	com/tencent/turingfd/sdk/qps/if:W	Ljava/lang/String;
      //   1037: invokestatic 302	com/tencent/token/ade:a	()Ljava/lang/String;
      //   1040: pop
      //   1041: aload 16
      //   1043: ldc 232
      //   1045: putfield 490	com/tencent/turingfd/sdk/qps/if:X	Ljava/lang/String;
      //   1048: invokestatic 302	com/tencent/token/ade:a	()Ljava/lang/String;
      //   1051: pop
      //   1052: aload 16
      //   1054: ldc 232
      //   1056: putfield 493	com/tencent/turingfd/sdk/qps/if:Y	Ljava/lang/String;
      //   1059: ldc_w 495
      //   1062: invokestatic 501	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
      //   1065: astore 13
      //   1067: aload 13
      //   1069: ldc_w 503
      //   1072: iconst_0
      //   1073: anewarray 497	java/lang/Class
      //   1076: invokevirtual 507	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   1079: aconst_null
      //   1080: iconst_0
      //   1081: anewarray 50	java/lang/Object
      //   1084: invokevirtual 513	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   1087: checkcast 68	java/lang/String
      //   1090: astore 13
      //   1092: goto +15 -> 1107
      //   1095: astore 13
      //   1097: aload 13
      //   1099: invokestatic 516	com/tencent/token/afr:a	(Ljava/lang/Object;)Ljava/lang/String;
      //   1102: pop
      //   1103: ldc 232
      //   1105: astore 13
      //   1107: aload 13
      //   1109: astore 14
      //   1111: aload 13
      //   1113: ifnonnull +7 -> 1120
      //   1116: ldc 232
      //   1118: astore 14
      //   1120: aload 16
      //   1122: aload 14
      //   1124: putfield 518	com/tencent/turingfd/sdk/qps/if:Z	Ljava/lang/String;
      //   1127: invokestatic 302	com/tencent/token/ade:a	()Ljava/lang/String;
      //   1130: pop
      //   1131: aload 16
      //   1133: ldc 232
      //   1135: putfield 521	com/tencent/turingfd/sdk/qps/if:F	Ljava/lang/String;
      //   1138: invokestatic 302	com/tencent/token/ade:a	()Ljava/lang/String;
      //   1141: pop
      //   1142: aload 16
      //   1144: ldc 232
      //   1146: putfield 524	com/tencent/turingfd/sdk/qps/if:b0	Ljava/lang/String;
      //   1149: invokestatic 302	com/tencent/token/ade:a	()Ljava/lang/String;
      //   1152: pop
      //   1153: aload 16
      //   1155: ldc 232
      //   1157: putfield 527	com/tencent/turingfd/sdk/qps/if:G	Ljava/lang/String;
      //   1160: invokestatic 302	com/tencent/token/ade:a	()Ljava/lang/String;
      //   1163: pop
      //   1164: aload 16
      //   1166: ldc 232
      //   1168: putfield 530	com/tencent/turingfd/sdk/qps/if:C	Ljava/lang/String;
      //   1171: invokestatic 302	com/tencent/token/ade:a	()Ljava/lang/String;
      //   1174: pop
      //   1175: aload 16
      //   1177: ldc 232
      //   1179: putfield 533	com/tencent/turingfd/sdk/qps/if:D	Ljava/lang/String;
      //   1182: ldc 232
      //   1184: astore 13
      //   1186: new 313	java/io/FileInputStream
      //   1189: dup
      //   1190: ldc_w 535
      //   1193: invokespecial 318	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
      //   1196: astore 14
      //   1198: new 325	java/io/BufferedReader
      //   1201: dup
      //   1202: new 311	java/io/InputStreamReader
      //   1205: dup
      //   1206: aload 14
      //   1208: invokespecial 538	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
      //   1211: sipush 8192
      //   1214: invokespecial 541	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
      //   1217: astore 17
      //   1219: new 59	java/lang/StringBuilder
      //   1222: dup
      //   1223: ldc 232
      //   1225: invokespecial 542	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1228: astore 13
      //   1230: aload 17
      //   1232: invokevirtual 331	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   1235: astore 18
      //   1237: aload 18
      //   1239: ifnull +14 -> 1253
      //   1242: aload 13
      //   1244: aload 18
      //   1246: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1249: pop
      //   1250: goto -20 -> 1230
      //   1253: aload 17
      //   1255: invokevirtual 335	java/io/BufferedReader:close	()V
      //   1258: goto +30 -> 1288
      //   1261: astore 17
      //   1263: goto +19 -> 1282
      //   1266: astore 18
      //   1268: aload 18
      //   1270: invokestatic 516	com/tencent/token/afr:a	(Ljava/lang/Object;)Ljava/lang/String;
      //   1273: pop
      //   1274: aload 17
      //   1276: invokevirtual 335	java/io/BufferedReader:close	()V
      //   1279: goto +9 -> 1288
      //   1282: aload 17
      //   1284: invokestatic 516	com/tencent/token/afr:a	(Ljava/lang/Object;)Ljava/lang/String;
      //   1287: pop
      //   1288: aload 14
      //   1290: invokevirtual 545	java/io/InputStream:close	()V
      //   1293: goto +11 -> 1304
      //   1296: astore 14
      //   1298: aload 14
      //   1300: invokestatic 516	com/tencent/token/afr:a	(Ljava/lang/Object;)Ljava/lang/String;
      //   1303: pop
      //   1304: aload 13
      //   1306: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1309: astore 13
      //   1311: goto +46 -> 1357
      //   1314: astore_1
      //   1315: aload 17
      //   1317: invokevirtual 335	java/io/BufferedReader:close	()V
      //   1320: goto +11 -> 1331
      //   1323: astore 13
      //   1325: aload 13
      //   1327: invokestatic 516	com/tencent/token/afr:a	(Ljava/lang/Object;)Ljava/lang/String;
      //   1330: pop
      //   1331: aload 14
      //   1333: invokevirtual 545	java/io/InputStream:close	()V
      //   1336: goto +11 -> 1347
      //   1339: astore 13
      //   1341: aload 13
      //   1343: invokestatic 516	com/tencent/token/afr:a	(Ljava/lang/Object;)Ljava/lang/String;
      //   1346: pop
      //   1347: aload_1
      //   1348: athrow
      //   1349: astore 14
      //   1351: aload 14
      //   1353: invokestatic 516	com/tencent/token/afr:a	(Ljava/lang/Object;)Ljava/lang/String;
      //   1356: pop
      //   1357: aload 13
      //   1359: astore 14
      //   1361: aload 13
      //   1363: ifnonnull +7 -> 1370
      //   1366: ldc 232
      //   1368: astore 14
      //   1370: aload 16
      //   1372: aload 14
      //   1374: putfield 548	com/tencent/turingfd/sdk/qps/if:c0	Ljava/lang/String;
      //   1377: aload 16
      //   1379: iconst_0
      //   1380: putfield 550	com/tencent/turingfd/sdk/qps/if:J	Z
      //   1383: aload 16
      //   1385: iconst_0
      //   1386: putfield 553	com/tencent/turingfd/sdk/qps/if:d0	I
      //   1389: getstatic 460	android/os/Build:MANUFACTURER	Ljava/lang/String;
      //   1392: astore 14
      //   1394: aload 15
      //   1396: astore 13
      //   1398: aload 14
      //   1400: invokestatic 89	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   1403: ifne +289 -> 1692
      //   1406: aload 14
      //   1408: getstatic 559	java/util/Locale:ENGLISH	Ljava/util/Locale;
      //   1411: invokevirtual 563	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
      //   1414: astore 14
      //   1416: aload 14
      //   1418: ldc_w 565
      //   1421: invokevirtual 568	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   1424: ifeq +10 -> 1434
      //   1427: invokestatic 571	com/tencent/token/aft:a	()Ljava/lang/String;
      //   1430: pop
      //   1431: goto +242 -> 1673
      //   1434: aload 14
      //   1436: ldc_w 573
      //   1439: invokevirtual 568	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   1442: ifeq +10 -> 1452
      //   1445: invokestatic 571	com/tencent/token/aft:a	()Ljava/lang/String;
      //   1448: pop
      //   1449: goto +224 -> 1673
      //   1452: aload 14
      //   1454: ldc_w 575
      //   1457: invokevirtual 568	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   1460: ifeq +22 -> 1482
      //   1463: invokestatic 571	com/tencent/token/aft:a	()Ljava/lang/String;
      //   1466: pop
      //   1467: ldc 232
      //   1469: invokestatic 89	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   1472: ifeq +561 -> 2033
      //   1475: invokestatic 571	com/tencent/token/aft:a	()Ljava/lang/String;
      //   1478: pop
      //   1479: goto +194 -> 1673
      //   1482: aload 14
      //   1484: ldc_w 577
      //   1487: invokevirtual 568	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   1490: ifeq +78 -> 1568
      //   1493: invokestatic 571	com/tencent/token/aft:a	()Ljava/lang/String;
      //   1496: pop
      //   1497: invokestatic 571	com/tencent/token/aft:a	()Ljava/lang/String;
      //   1500: pop
      //   1501: ldc 232
      //   1503: invokestatic 89	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   1506: ifne +55 -> 1561
      //   1509: ldc 232
      //   1511: invokestatic 89	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   1514: ifne +47 -> 1561
      //   1517: new 59	java/lang/StringBuilder
      //   1520: dup
      //   1521: invokespecial 60	java/lang/StringBuilder:<init>	()V
      //   1524: astore 13
      //   1526: aload 13
      //   1528: ldc 232
      //   1530: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1533: pop
      //   1534: aload 13
      //   1536: ldc_w 579
      //   1539: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1542: pop
      //   1543: aload 13
      //   1545: ldc 232
      //   1547: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1550: pop
      //   1551: aload 13
      //   1553: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1556: astore 13
      //   1558: goto +134 -> 1692
      //   1561: invokestatic 571	com/tencent/token/aft:a	()Ljava/lang/String;
      //   1564: pop
      //   1565: goto +108 -> 1673
      //   1568: aload 14
      //   1570: ldc_w 581
      //   1573: invokevirtual 568	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   1576: ifeq +10 -> 1586
      //   1579: invokestatic 571	com/tencent/token/aft:a	()Ljava/lang/String;
      //   1582: pop
      //   1583: goto +90 -> 1673
      //   1586: aload 14
      //   1588: ldc_w 583
      //   1591: invokevirtual 568	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   1594: ifeq +60 -> 1654
      //   1597: invokestatic 571	com/tencent/token/aft:a	()Ljava/lang/String;
      //   1600: pop
      //   1601: ldc 232
      //   1603: invokestatic 89	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   1606: ifne +434 -> 2040
      //   1609: ldc 232
      //   1611: ldc_w 579
      //   1614: invokevirtual 587	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   1617: astore 13
      //   1619: aload 13
      //   1621: ifnull +419 -> 2040
      //   1624: aload 13
      //   1626: arraylength
      //   1627: ifle +413 -> 2040
      //   1630: aload 13
      //   1632: iconst_0
      //   1633: aaload
      //   1634: astore 13
      //   1636: goto +3 -> 1639
      //   1639: aload 13
      //   1641: invokestatic 89	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   1644: ifeq +402 -> 2046
      //   1647: invokestatic 571	com/tencent/token/aft:a	()Ljava/lang/String;
      //   1650: pop
      //   1651: goto +22 -> 1673
      //   1654: aload 15
      //   1656: astore 13
      //   1658: aload 14
      //   1660: ldc_w 589
      //   1663: invokevirtual 568	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   1666: ifeq +26 -> 1692
      //   1669: invokestatic 571	com/tencent/token/aft:a	()Ljava/lang/String;
      //   1672: pop
      //   1673: ldc 232
      //   1675: astore 13
      //   1677: goto +15 -> 1692
      //   1680: astore 13
      //   1682: aload 13
      //   1684: invokestatic 516	com/tencent/token/afr:a	(Ljava/lang/Object;)Ljava/lang/String;
      //   1687: pop
      //   1688: aload 15
      //   1690: astore 13
      //   1692: aload 13
      //   1694: astore 14
      //   1696: aload 13
      //   1698: ifnonnull +7 -> 1705
      //   1701: ldc 232
      //   1703: astore 14
      //   1705: aload 16
      //   1707: aload 14
      //   1709: putfield 592	com/tencent/turingfd/sdk/qps/if:e0	Ljava/lang/String;
      //   1712: iconst_1
      //   1713: invokestatic 597	com/tencent/token/adf:a	(Z)Ljava/lang/String;
      //   1716: astore 14
      //   1718: aload 14
      //   1720: astore 13
      //   1722: aload 14
      //   1724: ifnonnull +7 -> 1731
      //   1727: ldc 232
      //   1729: astore 13
      //   1731: aload 16
      //   1733: aload 13
      //   1735: putfield 600	com/tencent/turingfd/sdk/qps/if:f0	Ljava/lang/String;
      //   1738: iconst_0
      //   1739: invokestatic 597	com/tencent/token/adf:a	(Z)Ljava/lang/String;
      //   1742: astore 14
      //   1744: aload 14
      //   1746: astore 13
      //   1748: aload 14
      //   1750: ifnonnull +7 -> 1757
      //   1753: ldc 232
      //   1755: astore 13
      //   1757: aload 16
      //   1759: aload 13
      //   1761: putfield 603	com/tencent/turingfd/sdk/qps/if:g0	Ljava/lang/String;
      //   1764: new 143	com/tencent/token/acz$a
      //   1767: dup
      //   1768: iconst_1
      //   1769: sipush 10001
      //   1772: iconst_0
      //   1773: invokespecial 146	com/tencent/token/acz$a:<init>	(III)V
      //   1776: astore 13
      //   1778: aload 13
      //   1780: aload 16
      //   1782: putfield 149	com/tencent/token/acz$a:d	Lcom/tencent/turingfd/sdk/qps/final;
      //   1785: aload 13
      //   1787: new 605	com/tencent/turingfd/sdk/qps/case
      //   1790: dup
      //   1791: invokespecial 606	com/tencent/turingfd/sdk/qps/case:<init>	()V
      //   1794: putfield 154	com/tencent/token/acz$a:f	Lcom/tencent/turingfd/sdk/qps/final;
      //   1797: new 156	com/tencent/token/acz
      //   1800: dup
      //   1801: aload 13
      //   1803: invokespecial 159	com/tencent/token/acz:<init>	(Lcom/tencent/token/acz$a;)V
      //   1806: astore 14
      //   1808: ldc 161
      //   1810: monitorenter
      //   1811: getstatic 164	com/tencent/token/agn:a	Landroid/content/Context;
      //   1814: astore 13
      //   1816: ldc 161
      //   1818: monitorexit
      //   1819: aload_0
      //   1820: aload 13
      //   1822: aload 14
      //   1824: invokespecial 167	com/tencent/token/acy$b:a	(Landroid/content/Context;Lcom/tencent/token/acz;)Lcom/tencent/token/ada;
      //   1827: astore 13
      //   1829: aload 13
      //   1831: invokevirtual 172	com/tencent/token/ada:a	()Z
      //   1834: ifne +6 -> 1840
      //   1837: aload 13
      //   1839: areturn
      //   1840: aload 13
      //   1842: getfield 173	com/tencent/token/ada:b	[B
      //   1845: aload 14
      //   1847: getfield 176	com/tencent/token/acz:g	Lcom/tencent/turingfd/sdk/qps/final;
      //   1850: invokestatic 179	com/tencent/token/agn:a	([BLcom/tencent/turingfd/sdk/qps/final;)Lcom/tencent/turingfd/sdk/qps/final;
      //   1853: astore 14
      //   1855: aload 14
      //   1857: instanceof 605
      //   1860: ifeq +79 -> 1939
      //   1863: aload 14
      //   1865: checkcast 605	com/tencent/turingfd/sdk/qps/case
      //   1868: getfield 607	com/tencent/turingfd/sdk/qps/case:a	Ljava/lang/String;
      //   1871: astore 14
      //   1873: aload 14
      //   1875: putstatic 609	com/tencent/token/acs:c	Ljava/lang/String;
      //   1878: new 59	java/lang/StringBuilder
      //   1881: dup
      //   1882: invokespecial 60	java/lang/StringBuilder:<init>	()V
      //   1885: astore 15
      //   1887: aload 15
      //   1889: getstatic 610	com/tencent/token/acs:b	Ljava/lang/String;
      //   1892: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1895: pop
      //   1896: aload 15
      //   1898: getstatic 198	com/tencent/token/acs:a	Ljava/lang/String;
      //   1901: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1904: pop
      //   1905: aload_1
      //   1906: aload 15
      //   1908: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1911: iconst_0
      //   1912: invokevirtual 614	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
      //   1915: invokeinterface 620 1 0
      //   1920: ldc_w 621
      //   1923: aload 14
      //   1925: invokeinterface 627 3 0
      //   1930: invokeinterface 630 1 0
      //   1935: pop
      //   1936: aload 13
      //   1938: areturn
      //   1939: bipush 245
      //   1941: invokestatic 192	com/tencent/token/ada:a	(I)Lcom/tencent/token/ada;
      //   1944: areturn
      //   1945: astore_1
      //   1946: ldc 161
      //   1948: monitorexit
      //   1949: aload_1
      //   1950: athrow
      //   1951: astore 13
      //   1953: goto -1901 -> 52
      //   1956: astore 13
      //   1958: goto -1862 -> 96
      //   1961: astore 13
      //   1963: goto -1743 -> 220
      //   1966: astore 13
      //   1968: goto +55 -> 2023
      //   1971: astore 13
      //   1973: goto -1522 -> 451
      //   1976: astore 13
      //   1978: goto -1533 -> 445
      //   1981: astore 13
      //   1983: goto -1544 -> 439
      //   1986: astore 18
      //   1988: goto -1552 -> 436
      //   1991: astore 18
      //   1993: goto -1560 -> 433
      //   1996: astore 13
      //   1998: goto -1372 -> 626
      //   2001: astore 13
      //   2003: goto -1179 -> 824
      //   2006: astore 13
      //   2008: goto -1194 -> 814
      //   2011: astore_1
      //   2012: aload 13
      //   2014: areturn
      //   2015: aload 13
      //   2017: ifnull -1486 -> 531
      //   2020: goto -1523 -> 497
      //   2023: aconst_null
      //   2024: astore 13
      //   2026: aload 13
      //   2028: astore 14
      //   2030: goto -1559 -> 471
      //   2033: ldc 232
      //   2035: astore 13
      //   2037: goto -345 -> 1692
      //   2040: aconst_null
      //   2041: astore 13
      //   2043: goto -404 -> 1639
      //   2046: goto -354 -> 1692
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	2049	0	this	b
      //   0	2049	1	paramContext	Context
      //   48	762	2	i	int
      //   10	665	3	j	int
      //   91	552	4	k	int
      //   290	527	5	l1	long
      //   423	396	7	l2	long
      //   293	534	9	l3	long
      //   799	9	11	l4	long
      //   7	361	13	localObject1	Object
      //   375	8	13	localIOException1	java.io.IOException
      //   440	15	13	localObject2	Object
      //   484	21	13	localIOException2	java.io.IOException
      //   512	12	13	localIOException3	java.io.IOException
      //   559	532	13	localObject3	Object
      //   1095	3	13	localObject4	Object
      //   1105	205	13	localObject5	Object
      //   1323	3	13	localObject6	Object
      //   1339	23	13	localObject7	Object
      //   1396	280	13	localObject8	Object
      //   1680	3	13	localException	Exception
      //   1690	247	13	localObject9	Object
      //   1951	1	13	localObject10	Object
      //   1956	1	13	localObject11	Object
      //   1961	1	13	localObject12	Object
      //   1966	1	13	localIOException4	java.io.IOException
      //   1971	1	13	localObject13	Object
      //   1976	1	13	localIOException5	java.io.IOException
      //   1981	1	13	localObject14	Object
      //   1996	1	13	localObject15	Object
      //   2001	1	13	localObject16	Object
      //   2006	10	13	localada	ada
      //   2024	18	13	str1	String
      //   29	1260	14	localObject17	Object
      //   1296	36	14	localObject18	Object
      //   1349	3	14	localObject19	Object
      //   1359	670	14	localObject20	Object
      //   296	1611	15	localStringBuilder	StringBuilder
      //   119	1662	16	localif	com.tencent.turingfd.sdk.qps.if
      //   285	969	17	localObject21	Object
      //   1261	55	17	localObject22	Object
      //   345	900	18	str2	String
      //   1266	3	18	localObject23	Object
      //   1986	1	18	localIOException6	java.io.IOException
      //   1991	1	18	localObject24	Object
      // Exception table:
      //   from	to	target	type
      //   362	372	375	java/io/IOException
      //   463	468	484	java/io/IOException
      //   476	481	484	java/io/IOException
      //   425	430	512	java/io/IOException
      //   504	509	512	java/io/IOException
      //   1059	1067	1095	finally
      //   1067	1092	1095	finally
      //   1253	1258	1261	finally
      //   1274	1279	1261	finally
      //   1230	1237	1266	finally
      //   1242	1250	1266	finally
      //   1288	1293	1296	finally
      //   1268	1274	1314	finally
      //   1315	1320	1323	finally
      //   1331	1336	1339	finally
      //   1186	1198	1349	finally
      //   1389	1394	1680	java/lang/Exception
      //   1398	1431	1680	java/lang/Exception
      //   1434	1449	1680	java/lang/Exception
      //   1452	1467	1680	java/lang/Exception
      //   1467	1479	1680	java/lang/Exception
      //   1482	1497	1680	java/lang/Exception
      //   1497	1501	1680	java/lang/Exception
      //   1501	1558	1680	java/lang/Exception
      //   1561	1565	1680	java/lang/Exception
      //   1568	1583	1680	java/lang/Exception
      //   1586	1601	1680	java/lang/Exception
      //   1601	1619	1680	java/lang/Exception
      //   1624	1630	1680	java/lang/Exception
      //   1639	1651	1680	java/lang/Exception
      //   1658	1673	1680	java/lang/Exception
      //   1811	1816	1945	finally
      //   11	49	1951	finally
      //   54	93	1956	finally
      //   211	220	1961	finally
      //   307	329	1966	java/io/IOException
      //   307	329	1971	finally
      //   329	340	1976	java/io/IOException
      //   329	340	1981	finally
      //   340	347	1986	java/io/IOException
      //   352	362	1986	java/io/IOException
      //   393	415	1986	java/io/IOException
      //   340	347	1991	finally
      //   352	362	1991	finally
      //   393	415	1991	finally
      //   583	609	1996	finally
      //   614	623	1996	finally
      //   689	694	2001	finally
      //   698	718	2001	finally
      //   718	746	2001	finally
      //   750	755	2006	finally
      //   759	779	2006	finally
      //   779	807	2006	finally
      //   1873	1936	2011	finally
    }
    
    /* Error */
    private ada a(Context paramContext, acz paramacz)
    {
      // Byte code:
      //   0: aload_2
      //   1: getfield 631	com/tencent/token/acz:a	I
      //   4: istore_3
      //   5: aload_2
      //   6: getfield 633	com/tencent/token/acz:f	[B
      //   9: astore 4
      //   11: aload 4
      //   13: astore 5
      //   15: aload 4
      //   17: ifnonnull +40 -> 57
      //   20: aload_2
      //   21: getfield 635	com/tencent/token/acz:e	Lcom/tencent/turingfd/sdk/qps/final;
      //   24: astore 4
      //   26: new 637	com/tencent/token/age
      //   29: dup
      //   30: invokespecial 638	com/tencent/token/age:<init>	()V
      //   33: astore 5
      //   35: aload 5
      //   37: ldc_w 320
      //   40: putfield 639	com/tencent/token/age:b	Ljava/lang/String;
      //   43: aload 4
      //   45: aload 5
      //   47: invokevirtual 644	com/tencent/turingfd/sdk/qps/final:a	(Lcom/tencent/token/age;)V
      //   50: aload 5
      //   52: invokevirtual 646	com/tencent/token/age:a	()[B
      //   55: astore 5
      //   57: aload_0
      //   58: getfield 36	com/tencent/token/acy$b:c	Lcom/tencent/token/acx;
      //   61: astore 4
      //   63: aload 4
      //   65: getfield 189	com/tencent/token/acx:a	Ljava/lang/String;
      //   68: invokestatic 89	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   71: ifeq +13 -> 84
      //   74: aload 4
      //   76: getfield 647	com/tencent/token/acx:e	Ljava/lang/String;
      //   79: astore 4
      //   81: goto +10 -> 91
      //   84: aload 4
      //   86: getfield 83	com/tencent/token/acx:b	Ljava/lang/String;
      //   89: astore 4
      //   91: new 649	com/tencent/turingfd/sdk/qps/new
      //   94: dup
      //   95: invokespecial 650	com/tencent/turingfd/sdk/qps/new:<init>	()V
      //   98: astore 7
      //   100: aload 7
      //   102: iconst_0
      //   103: putfield 652	com/tencent/turingfd/sdk/qps/new:d	I
      //   106: aload 7
      //   108: iload_3
      //   109: putfield 654	com/tencent/turingfd/sdk/qps/new:c	I
      //   112: aload 5
      //   114: invokestatic 656	com/tencent/token/agn:a	([B)[B
      //   117: astore 5
      //   119: aconst_null
      //   120: astore 6
      //   122: new 658	java/io/ByteArrayOutputStream
      //   125: dup
      //   126: invokespecial 659	java/io/ByteArrayOutputStream:<init>	()V
      //   129: astore 8
      //   131: new 661	java/io/DataOutputStream
      //   134: dup
      //   135: aload 8
      //   137: invokespecial 664	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   140: astore 9
      //   142: aload 9
      //   144: iload_3
      //   145: invokevirtual 668	java/io/DataOutputStream:writeInt	(I)V
      //   148: aload 5
      //   150: ifnull +16 -> 166
      //   153: aload 5
      //   155: arraylength
      //   156: ifle +10 -> 166
      //   159: aload 9
      //   161: aload 5
      //   163: invokevirtual 671	java/io/DataOutputStream:write	([B)V
      //   166: aload 8
      //   168: invokevirtual 674	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   171: astore 5
      //   173: goto +6 -> 179
      //   176: aconst_null
      //   177: astore 5
      //   179: iload_3
      //   180: sipush 152
      //   183: if_icmpne +25 -> 208
      //   186: aload 7
      //   188: aload 7
      //   190: getfield 675	com/tencent/turingfd/sdk/qps/new:k	I
      //   193: iconst_2
      //   194: ior
      //   195: putfield 675	com/tencent/turingfd/sdk/qps/new:k	I
      //   198: aload 7
      //   200: aload 5
      //   202: putfield 676	com/tencent/turingfd/sdk/qps/new:f	[B
      //   205: goto +18 -> 223
      //   208: aload 7
      //   210: aload 5
      //   212: aload 4
      //   214: invokevirtual 128	java/lang/String:getBytes	()[B
      //   217: invokestatic 679	com/tencent/token/agn:a	([B[B)[B
      //   220: putfield 676	com/tencent/turingfd/sdk/qps/new:f	[B
      //   223: aload_0
      //   224: getfield 28	com/tencent/token/acy$b:b	Lcom/tencent/turingfd/sdk/qps/do;
      //   227: astore 5
      //   229: aload_2
      //   230: getfield 631	com/tencent/token/acz:a	I
      //   233: sipush 152
      //   236: if_icmpne +10 -> 246
      //   239: ldc 232
      //   241: astore 4
      //   243: goto +12 -> 255
      //   246: aload_0
      //   247: getfield 36	com/tencent/token/acy$b:c	Lcom/tencent/token/acx;
      //   250: getfield 189	com/tencent/token/acx:a	Ljava/lang/String;
      //   253: astore 4
      //   255: aload 5
      //   257: aload 4
      //   259: putfield 680	com/tencent/turingfd/sdk/qps/do:e	Ljava/lang/String;
      //   262: aload 5
      //   264: aload_1
      //   265: invokestatic 683	com/tencent/token/acs:a	(Landroid/content/Context;)Ljava/lang/String;
      //   268: putfield 684	com/tencent/turingfd/sdk/qps/do:c	Ljava/lang/String;
      //   271: aload_0
      //   272: getfield 21	com/tencent/token/acy$b:a	I
      //   275: istore_3
      //   276: aload_0
      //   277: getfield 28	com/tencent/token/acy$b:b	Lcom/tencent/turingfd/sdk/qps/do;
      //   280: astore 4
      //   282: new 686	com/tencent/turingfd/sdk/qps/try
      //   285: dup
      //   286: invokespecial 687	com/tencent/turingfd/sdk/qps/try:<init>	()V
      //   289: astore_1
      //   290: new 689	java/util/ArrayList
      //   293: dup
      //   294: invokespecial 690	java/util/ArrayList:<init>	()V
      //   297: astore 5
      //   299: aload 5
      //   301: aload 7
      //   303: invokevirtual 694	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   306: pop
      //   307: aload_1
      //   308: aload 5
      //   310: putfield 697	com/tencent/turingfd/sdk/qps/try:g	Ljava/util/ArrayList;
      //   313: aload_1
      //   314: iload_3
      //   315: putfield 698	com/tencent/turingfd/sdk/qps/try:c	I
      //   318: aload_1
      //   319: aload 4
      //   321: putfield 700	com/tencent/turingfd/sdk/qps/try:f	Lcom/tencent/turingfd/sdk/qps/do;
      //   324: new 637	com/tencent/token/age
      //   327: dup
      //   328: invokespecial 638	com/tencent/token/age:<init>	()V
      //   331: astore 4
      //   333: aload 4
      //   335: ldc_w 320
      //   338: putfield 639	com/tencent/token/age:b	Ljava/lang/String;
      //   341: aload_1
      //   342: aload 4
      //   344: invokevirtual 701	com/tencent/turingfd/sdk/qps/try:a	(Lcom/tencent/token/age;)V
      //   347: aload 4
      //   349: invokevirtual 646	com/tencent/token/age:a	()[B
      //   352: astore_1
      //   353: aload_0
      //   354: getfield 38	com/tencent/token/acy$b:d	Lcom/tencent/token/abx;
      //   357: astore 4
      //   359: aload 4
      //   361: ifnonnull +12 -> 373
      //   364: bipush 251
      //   366: invokestatic 192	com/tencent/token/ada:a	(I)Lcom/tencent/token/ada;
      //   369: astore_1
      //   370: goto +58 -> 428
      //   373: aload 4
      //   375: aload_1
      //   376: invokeinterface 706 2 0
      //   381: astore_1
      //   382: new 708	com/tencent/token/ada$a
      //   385: dup
      //   386: invokespecial 709	com/tencent/token/ada$a:<init>	()V
      //   389: astore 4
      //   391: aload 4
      //   393: aload_1
      //   394: getfield 712	com/tencent/token/abx$a:a	I
      //   397: putfield 713	com/tencent/token/ada$a:a	I
      //   400: aload 4
      //   402: aload_1
      //   403: getfield 714	com/tencent/token/abx$a:b	[B
      //   406: putfield 716	com/tencent/token/ada$a:c	[B
      //   409: new 169	com/tencent/token/ada
      //   412: dup
      //   413: aload 4
      //   415: invokespecial 719	com/tencent/token/ada:<init>	(Lcom/tencent/token/ada$a;)V
      //   418: astore_1
      //   419: goto +9 -> 428
      //   422: bipush 250
      //   424: invokestatic 192	com/tencent/token/ada:a	(I)Lcom/tencent/token/ada;
      //   427: astore_1
      //   428: aload_1
      //   429: getfield 720	com/tencent/token/ada:a	I
      //   432: ifeq +5 -> 437
      //   435: aload_1
      //   436: areturn
      //   437: aload_1
      //   438: getfield 173	com/tencent/token/ada:b	[B
      //   441: new 722	com/tencent/turingfd/sdk/qps/this
      //   444: dup
      //   445: invokespecial 723	com/tencent/turingfd/sdk/qps/this:<init>	()V
      //   448: invokestatic 179	com/tencent/token/agn:a	([BLcom/tencent/turingfd/sdk/qps/final;)Lcom/tencent/turingfd/sdk/qps/final;
      //   451: astore_1
      //   452: aload_1
      //   453: ifnonnull +8 -> 461
      //   456: aconst_null
      //   457: astore_1
      //   458: goto +8 -> 466
      //   461: aload_1
      //   462: checkcast 722	com/tencent/turingfd/sdk/qps/this
      //   465: astore_1
      //   466: aload_1
      //   467: ifnonnull +9 -> 476
      //   470: bipush 249
      //   472: invokestatic 192	com/tencent/token/ada:a	(I)Lcom/tencent/token/ada;
      //   475: areturn
      //   476: aload_0
      //   477: getfield 21	com/tencent/token/acy$b:a	I
      //   480: istore_3
      //   481: aload_0
      //   482: iload_3
      //   483: iconst_1
      //   484: iadd
      //   485: putfield 21	com/tencent/token/acy$b:a	I
      //   488: iload_3
      //   489: ldc_w 724
      //   492: if_icmplt +8 -> 500
      //   495: aload_0
      //   496: iconst_1
      //   497: putfield 21	com/tencent/token/acy$b:a	I
      //   500: aload_2
      //   501: getfield 725	com/tencent/token/acz:b	I
      //   504: istore_3
      //   505: aload_1
      //   506: getfield 727	com/tencent/turingfd/sdk/qps/this:d	Ljava/util/ArrayList;
      //   509: astore_1
      //   510: aload_1
      //   511: ifnull +38 -> 549
      //   514: aload_1
      //   515: invokevirtual 731	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   518: astore_1
      //   519: aload_1
      //   520: invokeinterface 736 1 0
      //   525: ifeq +24 -> 549
      //   528: aload_1
      //   529: invokeinterface 740 1 0
      //   534: checkcast 742	com/tencent/turingfd/sdk/qps/goto
      //   537: astore_2
      //   538: aload_2
      //   539: getfield 743	com/tencent/turingfd/sdk/qps/goto:c	I
      //   542: iload_3
      //   543: if_icmpne -24 -> 519
      //   546: goto +5 -> 551
      //   549: aconst_null
      //   550: astore_2
      //   551: aload_2
      //   552: ifnonnull +9 -> 561
      //   555: bipush 248
      //   557: invokestatic 192	com/tencent/token/ada:a	(I)Lcom/tencent/token/ada;
      //   560: areturn
      //   561: aload_2
      //   562: getfield 744	com/tencent/turingfd/sdk/qps/goto:f	I
      //   565: istore_3
      //   566: iload_3
      //   567: iconst_2
      //   568: if_icmpne +25 -> 593
      //   571: aload_0
      //   572: getfield 36	com/tencent/token/acy$b:c	Lcom/tencent/token/acx;
      //   575: astore_1
      //   576: aload_1
      //   577: lconst_0
      //   578: putfield 182	com/tencent/token/acx:c	J
      //   581: aload_1
      //   582: ldc 232
      //   584: putfield 189	com/tencent/token/acx:a	Ljava/lang/String;
      //   587: bipush 247
      //   589: invokestatic 192	com/tencent/token/ada:a	(I)Lcom/tencent/token/ada;
      //   592: areturn
      //   593: iload_3
      //   594: ifne +171 -> 765
      //   597: aload_2
      //   598: getfield 746	com/tencent/turingfd/sdk/qps/goto:g	I
      //   601: ifne +164 -> 765
      //   604: aload_0
      //   605: getfield 36	com/tencent/token/acy$b:c	Lcom/tencent/token/acx;
      //   608: astore_1
      //   609: aload_1
      //   610: getfield 189	com/tencent/token/acx:a	Ljava/lang/String;
      //   613: invokestatic 89	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   616: ifeq +12 -> 628
      //   619: aload_1
      //   620: getfield 647	com/tencent/token/acx:e	Ljava/lang/String;
      //   623: astore 4
      //   625: goto +9 -> 634
      //   628: aload_1
      //   629: getfield 83	com/tencent/token/acx:b	Ljava/lang/String;
      //   632: astore 4
      //   634: aload_2
      //   635: getfield 748	com/tencent/turingfd/sdk/qps/goto:h	[B
      //   638: astore 5
      //   640: aload 5
      //   642: astore_1
      //   643: aload_2
      //   644: getfield 749	com/tencent/turingfd/sdk/qps/goto:j	I
      //   647: iconst_2
      //   648: iand
      //   649: ifne +14 -> 663
      //   652: aload 5
      //   654: aload 4
      //   656: invokevirtual 128	java/lang/String:getBytes	()[B
      //   659: invokestatic 751	com/tencent/token/agn:b	([B[B)[B
      //   662: astore_1
      //   663: aload_1
      //   664: ifnull +147 -> 811
      //   667: aload_1
      //   668: arraylength
      //   669: iconst_4
      //   670: if_icmplt +141 -> 811
      //   673: aload_1
      //   674: arraylength
      //   675: iconst_4
      //   676: isub
      //   677: newarray byte
      //   679: astore 4
      //   681: aload_1
      //   682: iconst_4
      //   683: aload 4
      //   685: iconst_0
      //   686: aload_1
      //   687: arraylength
      //   688: iconst_4
      //   689: isub
      //   690: invokestatic 755	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   693: aload 4
      //   695: astore_1
      //   696: goto +3 -> 699
      //   699: aload_2
      //   700: getfield 749	com/tencent/turingfd/sdk/qps/goto:j	I
      //   703: iconst_1
      //   704: iand
      //   705: ifne +11 -> 716
      //   708: aload_1
      //   709: invokestatic 757	com/tencent/token/agn:b	([B)[B
      //   712: astore_1
      //   713: goto +3 -> 716
      //   716: new 708	com/tencent/token/ada$a
      //   719: dup
      //   720: invokespecial 709	com/tencent/token/ada$a:<init>	()V
      //   723: astore 4
      //   725: aload 4
      //   727: iconst_0
      //   728: putfield 713	com/tencent/token/ada$a:a	I
      //   731: aload 4
      //   733: aload_1
      //   734: putfield 716	com/tencent/token/ada$a:c	[B
      //   737: aload 4
      //   739: aload_2
      //   740: getfield 744	com/tencent/turingfd/sdk/qps/goto:f	I
      //   743: putfield 758	com/tencent/token/ada$a:b	I
      //   746: aload 4
      //   748: aload_2
      //   749: getfield 746	com/tencent/turingfd/sdk/qps/goto:g	I
      //   752: putfield 758	com/tencent/token/ada$a:b	I
      //   755: new 169	com/tencent/token/ada
      //   758: dup
      //   759: aload 4
      //   761: invokespecial 719	com/tencent/token/ada:<init>	(Lcom/tencent/token/ada$a;)V
      //   764: areturn
      //   765: new 708	com/tencent/token/ada$a
      //   768: dup
      //   769: invokespecial 709	com/tencent/token/ada$a:<init>	()V
      //   772: astore_1
      //   773: aload_1
      //   774: iload_3
      //   775: putfield 758	com/tencent/token/ada$a:b	I
      //   778: aload_1
      //   779: aload_2
      //   780: getfield 746	com/tencent/turingfd/sdk/qps/goto:g	I
      //   783: putfield 758	com/tencent/token/ada$a:b	I
      //   786: new 169	com/tencent/token/ada
      //   789: dup
      //   790: aload_1
      //   791: invokespecial 719	com/tencent/token/ada:<init>	(Lcom/tencent/token/ada$a;)V
      //   794: areturn
      //   795: astore 5
      //   797: goto -621 -> 176
      //   800: astore_1
      //   801: goto -379 -> 422
      //   804: astore_1
      //   805: aload 6
      //   807: astore_1
      //   808: goto -92 -> 716
      //   811: aconst_null
      //   812: astore_1
      //   813: goto -114 -> 699
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	816	0	this	b
      //   0	816	1	paramContext	Context
      //   0	816	2	paramacz	acz
      //   4	771	3	i	int
      //   9	751	4	localObject1	Object
      //   13	640	5	localObject2	Object
      //   795	1	5	localException	Exception
      //   120	686	6	localObject3	Object
      //   98	204	7	localnew	com.tencent.turingfd.sdk.qps.new
      //   129	38	8	localByteArrayOutputStream	java.io.ByteArrayOutputStream
      //   140	20	9	localDataOutputStream	java.io.DataOutputStream
      // Exception table:
      //   from	to	target	type
      //   122	148	795	java/lang/Exception
      //   153	166	795	java/lang/Exception
      //   166	173	795	java/lang/Exception
      //   373	419	800	finally
      //   634	640	804	finally
      //   643	663	804	finally
      //   667	693	804	finally
      //   699	713	804	finally
    }
    
    public final void handleMessage(Message paramMessage)
    {
      int i = paramMessage.what;
      int j = 1;
      if (i != 1)
      {
        if (i != 2) {
          break label266;
        }
        paramMessage = (acz)paramMessage.obj;
        Object localObject1 = paramMessage.d;
        Object localObject2 = this.c;
        localObject2.getClass();
        long l1 = System.currentTimeMillis();
        long l2 = ((acx)localObject2).c;
        i = j;
        if (l2 != 0L) {
          if (Math.abs(l1 - l2) >= ((acx)localObject2).d) {
            i = j;
          } else {
            i = 0;
          }
        }
        if (i != 0)
        {
          localObject2 = a();
          if ((!((ada)localObject2).a()) && (!TextUtils.isEmpty(this.c.a)))
          {
            ((acy.c)localObject1).a((ada)localObject2);
            return;
          }
        }
        try
        {
          localObject2 = agn.a;
          if (TextUtils.isEmpty(acs.a((Context)localObject2)))
          {
            ada localada = a((Context)localObject2);
            if (!localada.a())
            {
              ((acy.c)localObject1).a(localada);
              return;
            }
          }
          localObject1 = a((Context)localObject2, paramMessage);
          localObject2 = paramMessage.g;
          if (localObject2 != null) {
            ((ada)localObject1).c = ((final)localObject2);
          }
          ((acy.c)paramMessage.d).a((ada)localObject1);
          return;
        }
        finally {}
      }
      System.currentTimeMillis();
      if (!a().a()) {
        return;
      }
      try
      {
        paramMessage = agn.a;
        if (TextUtils.isEmpty(acs.a(paramMessage))) {
          a(paramMessage);
        }
        label266:
        return;
      }
      finally {}
    }
  }
  
  public final class c
    implements acz.b
  {
    public c(AtomicReference paramAtomicReference, Object paramObject) {}
    
    public final void a(ada arg1)
    {
      if (acy.this.get()) {
        return;
      }
      localAtomicReference.set(???);
      synchronized (localObject1)
      {
        localObject1.notify();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.acy
 * JD-Core Version:    0.7.0.1
 */