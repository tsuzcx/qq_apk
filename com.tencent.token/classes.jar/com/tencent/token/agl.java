package com.tencent.token;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Base64;
import com.tencent.turingfd.sdk.qps.Pistachio;
import com.tencent.turingfd.sdk.qps.Tangerine;
import java.util.concurrent.atomic.AtomicReference;

public final class agl
{
  public static final String a = afz.a(afz.aI);
  
  /* Error */
  public static agh a(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 58	java/lang/System:currentTimeMillis	()J
    //   3: lstore 4
    //   5: getstatic 61	com/tencent/token/afz:aJ	[I
    //   8: invokestatic 24	com/tencent/token/afz:a	([I)Ljava/lang/String;
    //   11: invokestatic 67	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   14: getstatic 70	com/tencent/token/afz:aK	[I
    //   17: invokestatic 24	com/tencent/token/afz:a	([I)Ljava/lang/String;
    //   20: iconst_0
    //   21: anewarray 63	java/lang/Class
    //   24: invokevirtual 74	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   27: astore 6
    //   29: aload 6
    //   31: iconst_1
    //   32: invokevirtual 80	java/lang/reflect/Method:setAccessible	(Z)V
    //   35: aload 6
    //   37: aconst_null
    //   38: iconst_0
    //   39: anewarray 4	java/lang/Object
    //   42: invokevirtual 84	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   45: pop
    //   46: invokestatic 90	java/security/Security:getProviders	()[Ljava/security/Provider;
    //   49: astore 8
    //   51: aload 8
    //   53: ifnonnull +10 -> 63
    //   56: sipush -1201
    //   59: invokestatic 95	com/tencent/token/agh:a	(I)Lcom/tencent/token/agh;
    //   62: areturn
    //   63: aload 8
    //   65: arraylength
    //   66: istore_2
    //   67: iconst_0
    //   68: istore_1
    //   69: iload_1
    //   70: iload_2
    //   71: if_icmpge +39 -> 110
    //   74: aload 8
    //   76: iload_1
    //   77: aaload
    //   78: invokevirtual 101	java/security/Provider:getName	()Ljava/lang/String;
    //   81: astore 7
    //   83: aload 7
    //   85: ifnull +18 -> 103
    //   88: aload 7
    //   90: astore 6
    //   92: aload 7
    //   94: getstatic 26	com/tencent/token/agl:a	Ljava/lang/String;
    //   97: invokevirtual 107	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   100: ifne +13 -> 113
    //   103: iload_1
    //   104: iconst_1
    //   105: iadd
    //   106: istore_1
    //   107: goto -38 -> 69
    //   110: aconst_null
    //   111: astore 6
    //   113: aload 6
    //   115: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   118: ifeq +10 -> 128
    //   121: sipush -1202
    //   124: invokestatic 95	com/tencent/token/agh:a	(I)Lcom/tencent/token/agh;
    //   127: areturn
    //   128: aload 6
    //   130: ldc 115
    //   132: invokevirtual 119	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   135: arraylength
    //   136: iconst_1
    //   137: if_icmple +8 -> 145
    //   140: iconst_1
    //   141: istore_1
    //   142: goto +5 -> 147
    //   145: iconst_0
    //   146: istore_1
    //   147: aload 6
    //   149: invokestatic 125	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   152: astore 7
    //   154: aload 7
    //   156: aconst_null
    //   157: invokevirtual 129	java/security/KeyStore:load	(Ljava/security/KeyStore$LoadStoreParameter;)V
    //   160: invokestatic 135	android/os/Process:myUid	()I
    //   163: istore_3
    //   164: aload 7
    //   166: ldc 137
    //   168: iload_3
    //   169: invokestatic 141	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   172: invokevirtual 145	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   175: invokevirtual 149	java/security/KeyStore:getCertificate	(Ljava/lang/String;)Ljava/security/cert/Certificate;
    //   178: astore 8
    //   180: aload 8
    //   182: ifnull +8 -> 190
    //   185: iconst_1
    //   186: istore_2
    //   187: goto +5 -> 192
    //   190: iconst_0
    //   191: istore_2
    //   192: iload_2
    //   193: ifne +200 -> 393
    //   196: ldc 151
    //   198: aload 6
    //   200: invokestatic 156	java/security/KeyPairGenerator:getInstance	(Ljava/lang/String;Ljava/lang/String;)Ljava/security/KeyPairGenerator;
    //   203: astore 8
    //   205: new 158	java/lang/StringBuilder
    //   208: dup
    //   209: ldc 137
    //   211: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   214: astore 6
    //   216: aload 6
    //   218: iload_3
    //   219: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 6
    //   225: getstatic 169	com/tencent/token/afz:aL	[I
    //   228: invokestatic 24	com/tencent/token/afz:a	([I)Ljava/lang/String;
    //   231: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 6
    //   237: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: astore 6
    //   242: iload_1
    //   243: ifeq +501 -> 744
    //   246: bipush 16
    //   248: istore_2
    //   249: goto +3 -> 252
    //   252: getstatic 181	android/os/Build$VERSION:SDK_INT	I
    //   255: bipush 23
    //   257: if_icmplt +18 -> 275
    //   260: new 183	com/tencent/token/agg$a
    //   263: dup
    //   264: aload 6
    //   266: iload_2
    //   267: invokespecial 186	com/tencent/token/agg$a:<init>	(Ljava/lang/String;I)V
    //   270: astore 6
    //   272: goto +15 -> 287
    //   275: new 188	com/tencent/token/agg$b
    //   278: dup
    //   279: aload 6
    //   281: iload_2
    //   282: invokespecial 189	com/tencent/token/agg$b:<init>	(Ljava/lang/String;I)V
    //   285: astore 6
    //   287: aload 6
    //   289: iconst_1
    //   290: anewarray 103	java/lang/String
    //   293: dup
    //   294: iconst_0
    //   295: ldc 191
    //   297: aastore
    //   298: invokevirtual 196	com/tencent/token/agg:a	([Ljava/lang/String;)Lcom/tencent/token/agg;
    //   301: iconst_1
    //   302: anewarray 103	java/lang/String
    //   305: dup
    //   306: iconst_0
    //   307: ldc 198
    //   309: aastore
    //   310: invokevirtual 200	com/tencent/token/agg:b	([Ljava/lang/String;)Lcom/tencent/token/agg;
    //   313: invokevirtual 203	com/tencent/token/agg:a	()Ljava/security/spec/AlgorithmParameterSpec;
    //   316: astore 6
    //   318: aload 8
    //   320: aload 6
    //   322: invokevirtual 207	java/security/KeyPairGenerator:initialize	(Ljava/security/spec/AlgorithmParameterSpec;)V
    //   325: aload 8
    //   327: invokevirtual 211	java/security/KeyPairGenerator:generateKeyPair	()Ljava/security/KeyPair;
    //   330: pop
    //   331: goto +62 -> 393
    //   334: goto +59 -> 393
    //   337: sipush -1701
    //   340: invokestatic 95	com/tencent/token/agh:a	(I)Lcom/tencent/token/agh;
    //   343: areturn
    //   344: sipush -1605
    //   347: invokestatic 95	com/tencent/token/agh:a	(I)Lcom/tencent/token/agh;
    //   350: areturn
    //   351: sipush -1604
    //   354: invokestatic 95	com/tencent/token/agh:a	(I)Lcom/tencent/token/agh;
    //   357: areturn
    //   358: sipush -1603
    //   361: invokestatic 95	com/tencent/token/agh:a	(I)Lcom/tencent/token/agh;
    //   364: areturn
    //   365: sipush -1602
    //   368: invokestatic 95	com/tencent/token/agh:a	(I)Lcom/tencent/token/agh;
    //   371: areturn
    //   372: sipush -1601
    //   375: invokestatic 95	com/tencent/token/agh:a	(I)Lcom/tencent/token/agh;
    //   378: areturn
    //   379: sipush -1502
    //   382: invokestatic 95	com/tencent/token/agh:a	(I)Lcom/tencent/token/agh;
    //   385: areturn
    //   386: sipush -1501
    //   389: invokestatic 95	com/tencent/token/agh:a	(I)Lcom/tencent/token/agh;
    //   392: areturn
    //   393: iload_1
    //   394: ifeq +59 -> 453
    //   397: new 213	com/tencent/token/agk
    //   400: dup
    //   401: aload 7
    //   403: ldc 137
    //   405: iload_3
    //   406: invokestatic 141	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   409: invokevirtual 145	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   412: invokevirtual 217	java/security/KeyStore:getCertificateChain	(Ljava/lang/String;)[Ljava/security/cert/Certificate;
    //   415: invokespecial 220	com/tencent/token/agk:<init>	([Ljava/security/cert/Certificate;)V
    //   418: astore_0
    //   419: new 92	com/tencent/token/agh
    //   422: dup
    //   423: iconst_0
    //   424: bipush 100
    //   426: invokestatic 58	java/lang/System:currentTimeMillis	()J
    //   429: lload 4
    //   431: lsub
    //   432: aload_0
    //   433: getfield 223	com/tencent/token/agk:h	Ljava/lang/String;
    //   436: iconst_m1
    //   437: bipush 254
    //   439: invokespecial 226	com/tencent/token/agh:<init>	(IIJLjava/lang/String;II)V
    //   442: astore_0
    //   443: aload_0
    //   444: areturn
    //   445: astore_0
    //   446: aload_0
    //   447: invokevirtual 229	java/security/KeyStoreException:printStackTrace	()V
    //   450: goto +120 -> 570
    //   453: aload 7
    //   455: ldc 137
    //   457: iload_3
    //   458: invokestatic 141	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   461: invokevirtual 145	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   464: getstatic 232	com/tencent/token/afz:aM	[I
    //   467: invokestatic 24	com/tencent/token/afz:a	([I)Ljava/lang/String;
    //   470: invokevirtual 236	java/lang/String:toCharArray	()[C
    //   473: invokevirtual 240	java/security/KeyStore:getKey	(Ljava/lang/String;[C)Ljava/security/Key;
    //   476: astore 6
    //   478: aload 6
    //   480: ifnull +90 -> 570
    //   483: aload 6
    //   485: invokeinterface 246 1 0
    //   490: invokestatic 249	com/tencent/token/agl:a	([B)Lcom/tencent/token/agl$b;
    //   493: astore 6
    //   495: aload 6
    //   497: getfield 251	com/tencent/token/agl$b:a	I
    //   500: istore_1
    //   501: iload_1
    //   502: ifeq +8 -> 510
    //   505: iload_1
    //   506: invokestatic 95	com/tencent/token/agh:a	(I)Lcom/tencent/token/agh;
    //   509: areturn
    //   510: aload 6
    //   512: getfield 254	com/tencent/token/agl$b:b	Lcom/tencent/token/agk;
    //   515: astore 6
    //   517: getstatic 259	com/tencent/turingfd/sdk/qps/Pistachio:b	Lcom/tencent/turingfd/sdk/qps/Pistachio;
    //   520: aload_0
    //   521: ldc_w 261
    //   524: iconst_0
    //   525: invokevirtual 264	com/tencent/turingfd/sdk/qps/Pistachio:a	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   528: ifeq +17 -> 545
    //   531: aload 7
    //   533: ldc 137
    //   535: iload_3
    //   536: invokestatic 141	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   539: invokevirtual 145	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   542: invokevirtual 267	java/security/KeyStore:deleteEntry	(Ljava/lang/String;)V
    //   545: new 92	com/tencent/token/agh
    //   548: dup
    //   549: iconst_0
    //   550: bipush 100
    //   552: invokestatic 58	java/lang/System:currentTimeMillis	()J
    //   555: lload 4
    //   557: lsub
    //   558: aload 6
    //   560: getfield 223	com/tencent/token/agk:h	Ljava/lang/String;
    //   563: iconst_m1
    //   564: bipush 254
    //   566: invokespecial 226	com/tencent/token/agh:<init>	(IIJLjava/lang/String;II)V
    //   569: areturn
    //   570: sipush -1901
    //   573: invokestatic 95	com/tencent/token/agh:a	(I)Lcom/tencent/token/agh;
    //   576: areturn
    //   577: sipush -1803
    //   580: invokestatic 95	com/tencent/token/agh:a	(I)Lcom/tencent/token/agh;
    //   583: areturn
    //   584: sipush -1802
    //   587: invokestatic 95	com/tencent/token/agh:a	(I)Lcom/tencent/token/agh;
    //   590: areturn
    //   591: sipush -1801
    //   594: invokestatic 95	com/tencent/token/agh:a	(I)Lcom/tencent/token/agh;
    //   597: areturn
    //   598: sipush -1304
    //   601: invokestatic 95	com/tencent/token/agh:a	(I)Lcom/tencent/token/agh;
    //   604: areturn
    //   605: sipush -1303
    //   608: invokestatic 95	com/tencent/token/agh:a	(I)Lcom/tencent/token/agh;
    //   611: areturn
    //   612: sipush -1302
    //   615: invokestatic 95	com/tencent/token/agh:a	(I)Lcom/tencent/token/agh;
    //   618: areturn
    //   619: sipush -1301
    //   622: invokestatic 95	com/tencent/token/agh:a	(I)Lcom/tencent/token/agh;
    //   625: areturn
    //   626: sipush -1104
    //   629: invokestatic 95	com/tencent/token/agh:a	(I)Lcom/tencent/token/agh;
    //   632: areturn
    //   633: sipush -1103
    //   636: invokestatic 95	com/tencent/token/agh:a	(I)Lcom/tencent/token/agh;
    //   639: areturn
    //   640: sipush -1102
    //   643: invokestatic 95	com/tencent/token/agh:a	(I)Lcom/tencent/token/agh;
    //   646: areturn
    //   647: sipush -1101
    //   650: invokestatic 95	com/tencent/token/agh:a	(I)Lcom/tencent/token/agh;
    //   653: areturn
    //   654: astore_0
    //   655: goto -8 -> 647
    //   658: astore_0
    //   659: goto -19 -> 640
    //   662: astore_0
    //   663: goto -30 -> 633
    //   666: astore_0
    //   667: goto -41 -> 626
    //   670: astore_0
    //   671: goto -52 -> 619
    //   674: astore_0
    //   675: goto -63 -> 612
    //   678: astore_0
    //   679: goto -74 -> 605
    //   682: astore_0
    //   683: goto -85 -> 598
    //   686: astore 8
    //   688: goto -498 -> 190
    //   691: astore_0
    //   692: goto -306 -> 386
    //   695: astore_0
    //   696: goto -317 -> 379
    //   699: astore_0
    //   700: goto -328 -> 372
    //   703: astore_0
    //   704: goto -339 -> 365
    //   707: astore_0
    //   708: goto -350 -> 358
    //   711: astore_0
    //   712: goto -361 -> 351
    //   715: astore_0
    //   716: goto -372 -> 344
    //   719: astore_0
    //   720: goto -383 -> 337
    //   723: astore 6
    //   725: goto -391 -> 334
    //   728: astore_0
    //   729: goto -138 -> 591
    //   732: astore_0
    //   733: goto -149 -> 584
    //   736: astore_0
    //   737: goto -160 -> 577
    //   740: astore_0
    //   741: goto -196 -> 545
    //   744: iconst_4
    //   745: istore_2
    //   746: goto -494 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	749	0	paramContext	Context
    //   68	438	1	i	int
    //   66	680	2	j	int
    //   163	373	3	k	int
    //   3	553	4	l	long
    //   27	532	6	localObject1	Object
    //   723	1	6	localObject2	Object
    //   81	451	7	localObject3	Object
    //   49	277	8	localObject4	Object
    //   686	1	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   397	443	445	java/security/KeyStoreException
    //   5	46	654	java/lang/reflect/InvocationTargetException
    //   5	46	658	java/lang/NoSuchMethodException
    //   5	46	662	java/lang/IllegalAccessException
    //   5	46	666	java/lang/ClassNotFoundException
    //   147	160	670	java/security/KeyStoreException
    //   147	160	674	java/security/cert/CertificateException
    //   147	160	678	java/io/IOException
    //   147	160	682	java/security/NoSuchAlgorithmException
    //   164	180	686	finally
    //   196	205	691	java/security/NoSuchAlgorithmException
    //   196	205	695	java/security/NoSuchProviderException
    //   205	242	699	java/lang/ClassNotFoundException
    //   252	272	699	java/lang/ClassNotFoundException
    //   275	287	699	java/lang/ClassNotFoundException
    //   287	318	699	java/lang/ClassNotFoundException
    //   205	242	703	java/lang/NoSuchMethodException
    //   252	272	703	java/lang/NoSuchMethodException
    //   275	287	703	java/lang/NoSuchMethodException
    //   287	318	703	java/lang/NoSuchMethodException
    //   205	242	707	java/lang/IllegalAccessException
    //   252	272	707	java/lang/IllegalAccessException
    //   275	287	707	java/lang/IllegalAccessException
    //   287	318	707	java/lang/IllegalAccessException
    //   205	242	711	java/lang/reflect/InvocationTargetException
    //   252	272	711	java/lang/reflect/InvocationTargetException
    //   275	287	711	java/lang/reflect/InvocationTargetException
    //   287	318	711	java/lang/reflect/InvocationTargetException
    //   205	242	715	java/lang/InstantiationException
    //   252	272	715	java/lang/InstantiationException
    //   275	287	715	java/lang/InstantiationException
    //   287	318	715	java/lang/InstantiationException
    //   318	325	719	java/security/InvalidAlgorithmParameterException
    //   325	331	723	finally
    //   453	478	728	java/security/KeyStoreException
    //   453	478	732	java/security/NoSuchAlgorithmException
    //   453	478	736	java/security/UnrecoverableKeyException
    //   531	545	740	finally
  }
  
  public static b a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return new b(-3001, null);
    }
    if (paramArrayOfByte.length < 4) {
      return new b(-3001, null);
    }
    Object localObject = new byte[4];
    System.arraycopy(paramArrayOfByte, 0, localObject, 0, 4);
    int j = 0;
    int i = 0;
    while (j < 4)
    {
      i += ((localObject[j] & 0xFF) << j * 8);
      j += 1;
    }
    if (i > 1048576) {
      return new b(-3003, null);
    }
    localObject = new byte[i];
    int k = paramArrayOfByte.length;
    j = i + 4;
    if (k < j) {
      return new b(-3004, null);
    }
    System.arraycopy(paramArrayOfByte, 4, localObject, 0, i);
    localObject = new agk(new String((byte[])localObject));
    i = paramArrayOfByte.length - j;
    if (i != 0)
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(paramArrayOfByte, j, arrayOfByte, 0, i);
      Base64.encodeToString(arrayOfByte, 2);
      return new b(0, (agk)localObject);
    }
    return new b(-3005, null);
  }
  
  public static agh b(final Context paramContext)
  {
    final long l = System.currentTimeMillis();
    Intent localIntent = new Intent();
    localIntent.setAction(afz.a(afz.aN));
    localIntent.setPackage(afz.a(afz.aO));
    Object localObject = new Object();
    AtomicReference localAtomicReference = new AtomicReference();
    localAtomicReference.set(agh.a(-2001, -1));
    if (paramContext.getApplicationContext().bindService(localIntent, new a(localAtomicReference, l, localObject, paramContext), 1)) {}
    try
    {
      try
      {
        localObject.wait(5000L);
      }
      finally
      {
        break label112;
      }
    }
    catch (InterruptedException paramContext)
    {
      label107:
      break label107;
    }
    break label128;
    label112:
    throw paramContext;
    localAtomicReference.set(agh.a(-2002, -1));
    label128:
    return (agh)localAtomicReference.get();
  }
  
  public final class a
    implements ServiceConnection
  {
    public a(long paramLong, Object paramObject, Context paramContext) {}
    
    public final void onServiceConnected(ComponentName paramComponentName, final IBinder paramIBinder)
    {
      new a(paramIBinder).start();
    }
    
    public final void onServiceDisconnected(ComponentName arg1)
    {
      agl.this.set(agh.a(-2004, -3));
      synchronized (paramContext)
      {
        paramContext.notify();
        return;
      }
    }
    
    public final class a
      extends Thread
    {
      public a(IBinder paramIBinder) {}
      
      public final void run()
      {
        Object localObject1 = paramIBinder;
        ??? = agf.a.a;
        if (localObject1 == null)
        {
          localObject1 = null;
        }
        else
        {
          ??? = ((IBinder)localObject1).queryLocalInterface(agf.a.a);
          if ((??? != null) && ((??? instanceof agf))) {
            localObject1 = (agf)???;
          } else {
            localObject1 = new agf.a.a((IBinder)localObject1);
          }
        }
        i = -1;
        int j = i;
        try
        {
          if (((agf)localObject1).c()) {
            break label300;
          }
          j = i;
          ((agf)localObject1).a();
          i = 1;
        }
        finally
        {
          for (;;)
          {
            int k;
            label226:
            continue;
            i = 0;
          }
        }
        j = i;
        ??? = agl.a(((agf)localObject1).b().c);
        j = i;
        k = ((agl.b)???).a;
        if (k != 0)
        {
          j = i;
          agl.this.set(agh.a(k, i));
        }
        else
        {
          j = i;
          ??? = ((agl.b)???).b;
          j = i;
          k = ((agf)localObject1).e();
          j = i;
          agl.this.set(new agh(0, 200, System.currentTimeMillis() - agl.a.this.b, ((agk)???).h, k, i));
          break label226;
          agl.this.set(agh.a(-2003, j));
        }
        synchronized (agl.a.this.c)
        {
          agl.a.this.c.notify();
          if (Pistachio.b.a(agl.a.this.d, "s_t_d_ask", false)) {
            try
            {
              ((agf)localObject1).d();
              return;
            }
            catch (RemoteException localRemoteException)
            {
              localRemoteException.printStackTrace();
            }
          }
          return;
        }
      }
    }
  }
  
  public static final class b
  {
    public int a;
    public agk b;
    
    public b(int paramInt, agk paramagk)
    {
      this.a = paramInt;
      this.b = paramagk;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.agl
 * JD-Core Version:    0.7.0.1
 */