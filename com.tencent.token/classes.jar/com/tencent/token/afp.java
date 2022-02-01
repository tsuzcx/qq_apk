package com.tencent.token;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Base64;
import com.tencent.turingfd.sdk.qps.Sorgo;
import java.util.concurrent.atomic.AtomicReference;

public final class afp
{
  public static final String a = agg.a(agg.aI);
  
  /* Error */
  public static afl a()
  {
    // Byte code:
    //   0: invokestatic 58	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: getstatic 61	com/tencent/token/agg:aJ	[I
    //   7: invokestatic 24	com/tencent/token/agg:a	([I)Ljava/lang/String;
    //   10: invokestatic 67	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   13: getstatic 70	com/tencent/token/agg:aK	[I
    //   16: invokestatic 24	com/tencent/token/agg:a	([I)Ljava/lang/String;
    //   19: iconst_0
    //   20: anewarray 63	java/lang/Class
    //   23: invokevirtual 74	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   26: astore 5
    //   28: aload 5
    //   30: iconst_1
    //   31: invokevirtual 80	java/lang/reflect/Method:setAccessible	(Z)V
    //   34: aload 5
    //   36: aconst_null
    //   37: iconst_0
    //   38: anewarray 4	java/lang/Object
    //   41: invokevirtual 84	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   44: pop
    //   45: invokestatic 90	java/security/Security:getProviders	()[Ljava/security/Provider;
    //   48: astore 7
    //   50: aload 7
    //   52: ifnonnull +10 -> 62
    //   55: sipush -1201
    //   58: invokestatic 95	com/tencent/token/afl:a	(I)Lcom/tencent/token/afl;
    //   61: areturn
    //   62: aload 7
    //   64: arraylength
    //   65: istore_1
    //   66: iconst_0
    //   67: istore_0
    //   68: iload_0
    //   69: iload_1
    //   70: if_icmpge +39 -> 109
    //   73: aload 7
    //   75: iload_0
    //   76: aaload
    //   77: invokevirtual 101	java/security/Provider:getName	()Ljava/lang/String;
    //   80: astore 6
    //   82: aload 6
    //   84: ifnull +18 -> 102
    //   87: aload 6
    //   89: astore 5
    //   91: aload 6
    //   93: getstatic 26	com/tencent/token/afp:a	Ljava/lang/String;
    //   96: invokevirtual 107	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   99: ifne +13 -> 112
    //   102: iload_0
    //   103: iconst_1
    //   104: iadd
    //   105: istore_0
    //   106: goto -38 -> 68
    //   109: aconst_null
    //   110: astore 5
    //   112: aload 5
    //   114: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   117: ifeq +10 -> 127
    //   120: sipush -1202
    //   123: invokestatic 95	com/tencent/token/afl:a	(I)Lcom/tencent/token/afl;
    //   126: areturn
    //   127: aload 5
    //   129: ldc 115
    //   131: invokevirtual 119	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   134: arraylength
    //   135: iconst_1
    //   136: if_icmple +8 -> 144
    //   139: iconst_1
    //   140: istore_0
    //   141: goto +5 -> 146
    //   144: iconst_0
    //   145: istore_0
    //   146: aload 5
    //   148: invokestatic 125	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   151: astore 6
    //   153: aload 6
    //   155: aconst_null
    //   156: invokevirtual 129	java/security/KeyStore:load	(Ljava/security/KeyStore$LoadStoreParameter;)V
    //   159: invokestatic 135	android/os/Process:myUid	()I
    //   162: istore_2
    //   163: aload 6
    //   165: ldc 137
    //   167: iload_2
    //   168: invokestatic 141	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   171: invokevirtual 145	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   174: invokevirtual 149	java/security/KeyStore:getCertificate	(Ljava/lang/String;)Ljava/security/cert/Certificate;
    //   177: astore 7
    //   179: aload 7
    //   181: ifnull +8 -> 189
    //   184: iconst_1
    //   185: istore_1
    //   186: goto +5 -> 191
    //   189: iconst_0
    //   190: istore_1
    //   191: iload_1
    //   192: ifne +200 -> 392
    //   195: ldc 151
    //   197: aload 5
    //   199: invokestatic 156	java/security/KeyPairGenerator:getInstance	(Ljava/lang/String;Ljava/lang/String;)Ljava/security/KeyPairGenerator;
    //   202: astore 7
    //   204: new 158	java/lang/StringBuilder
    //   207: dup
    //   208: ldc 137
    //   210: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   213: astore 5
    //   215: aload 5
    //   217: iload_2
    //   218: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload 5
    //   224: getstatic 169	com/tencent/token/agg:aL	[I
    //   227: invokestatic 24	com/tencent/token/agg:a	([I)Ljava/lang/String;
    //   230: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload 5
    //   236: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: astore 5
    //   241: iload_0
    //   242: ifeq +507 -> 749
    //   245: bipush 16
    //   247: istore_1
    //   248: goto +3 -> 251
    //   251: getstatic 181	android/os/Build$VERSION:SDK_INT	I
    //   254: bipush 23
    //   256: if_icmplt +18 -> 274
    //   259: new 183	com/tencent/token/afj$a
    //   262: dup
    //   263: aload 5
    //   265: iload_1
    //   266: invokespecial 186	com/tencent/token/afj$a:<init>	(Ljava/lang/String;I)V
    //   269: astore 5
    //   271: goto +15 -> 286
    //   274: new 188	com/tencent/token/afj$b
    //   277: dup
    //   278: aload 5
    //   280: iload_1
    //   281: invokespecial 189	com/tencent/token/afj$b:<init>	(Ljava/lang/String;I)V
    //   284: astore 5
    //   286: aload 5
    //   288: iconst_1
    //   289: anewarray 103	java/lang/String
    //   292: dup
    //   293: iconst_0
    //   294: ldc 191
    //   296: aastore
    //   297: invokevirtual 196	com/tencent/token/afj:a	([Ljava/lang/String;)Lcom/tencent/token/afj;
    //   300: iconst_1
    //   301: anewarray 103	java/lang/String
    //   304: dup
    //   305: iconst_0
    //   306: ldc 198
    //   308: aastore
    //   309: invokevirtual 200	com/tencent/token/afj:b	([Ljava/lang/String;)Lcom/tencent/token/afj;
    //   312: invokevirtual 203	com/tencent/token/afj:a	()Ljava/security/spec/AlgorithmParameterSpec;
    //   315: astore 5
    //   317: aload 7
    //   319: aload 5
    //   321: invokevirtual 207	java/security/KeyPairGenerator:initialize	(Ljava/security/spec/AlgorithmParameterSpec;)V
    //   324: aload 7
    //   326: invokevirtual 211	java/security/KeyPairGenerator:generateKeyPair	()Ljava/security/KeyPair;
    //   329: pop
    //   330: goto +62 -> 392
    //   333: goto +59 -> 392
    //   336: sipush -1701
    //   339: invokestatic 95	com/tencent/token/afl:a	(I)Lcom/tencent/token/afl;
    //   342: areturn
    //   343: sipush -1605
    //   346: invokestatic 95	com/tencent/token/afl:a	(I)Lcom/tencent/token/afl;
    //   349: areturn
    //   350: sipush -1604
    //   353: invokestatic 95	com/tencent/token/afl:a	(I)Lcom/tencent/token/afl;
    //   356: areturn
    //   357: sipush -1603
    //   360: invokestatic 95	com/tencent/token/afl:a	(I)Lcom/tencent/token/afl;
    //   363: areturn
    //   364: sipush -1602
    //   367: invokestatic 95	com/tencent/token/afl:a	(I)Lcom/tencent/token/afl;
    //   370: areturn
    //   371: sipush -1601
    //   374: invokestatic 95	com/tencent/token/afl:a	(I)Lcom/tencent/token/afl;
    //   377: areturn
    //   378: sipush -1502
    //   381: invokestatic 95	com/tencent/token/afl:a	(I)Lcom/tencent/token/afl;
    //   384: areturn
    //   385: sipush -1501
    //   388: invokestatic 95	com/tencent/token/afl:a	(I)Lcom/tencent/token/afl;
    //   391: areturn
    //   392: iload_0
    //   393: ifeq +62 -> 455
    //   396: new 213	com/tencent/token/afo
    //   399: dup
    //   400: aload 6
    //   402: ldc 137
    //   404: iload_2
    //   405: invokestatic 141	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   408: invokevirtual 145	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   411: invokevirtual 217	java/security/KeyStore:getCertificateChain	(Ljava/lang/String;)[Ljava/security/cert/Certificate;
    //   414: invokespecial 220	com/tencent/token/afo:<init>	([Ljava/security/cert/Certificate;)V
    //   417: astore 5
    //   419: new 92	com/tencent/token/afl
    //   422: dup
    //   423: iconst_0
    //   424: bipush 100
    //   426: invokestatic 58	java/lang/System:currentTimeMillis	()J
    //   429: lload_3
    //   430: lsub
    //   431: aload 5
    //   433: getfield 223	com/tencent/token/afo:h	Ljava/lang/String;
    //   436: iconst_m1
    //   437: invokespecial 226	com/tencent/token/afl:<init>	(IIJLjava/lang/String;I)V
    //   440: astore 5
    //   442: aload 5
    //   444: areturn
    //   445: astore 5
    //   447: aload 5
    //   449: invokevirtual 229	java/security/KeyStoreException:printStackTrace	()V
    //   452: goto +103 -> 555
    //   455: aload 6
    //   457: ldc 137
    //   459: iload_2
    //   460: invokestatic 141	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   463: invokevirtual 145	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   466: getstatic 232	com/tencent/token/agg:aM	[I
    //   469: invokestatic 24	com/tencent/token/agg:a	([I)Ljava/lang/String;
    //   472: invokevirtual 236	java/lang/String:toCharArray	()[C
    //   475: invokevirtual 240	java/security/KeyStore:getKey	(Ljava/lang/String;[C)Ljava/security/Key;
    //   478: astore 5
    //   480: aload 5
    //   482: ifnull +73 -> 555
    //   485: aload 5
    //   487: invokeinterface 246 1 0
    //   492: invokestatic 249	com/tencent/token/afp:a	([B)Lcom/tencent/token/afp$b;
    //   495: astore 5
    //   497: aload 5
    //   499: getfield 251	com/tencent/token/afp$b:a	I
    //   502: istore_0
    //   503: iload_0
    //   504: ifeq +8 -> 512
    //   507: iload_0
    //   508: invokestatic 95	com/tencent/token/afl:a	(I)Lcom/tencent/token/afl;
    //   511: areturn
    //   512: aload 5
    //   514: getfield 254	com/tencent/token/afp$b:b	Lcom/tencent/token/afo;
    //   517: astore 5
    //   519: aload 6
    //   521: ldc 137
    //   523: iload_2
    //   524: invokestatic 141	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   527: invokevirtual 145	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   530: invokevirtual 257	java/security/KeyStore:deleteEntry	(Ljava/lang/String;)V
    //   533: new 92	com/tencent/token/afl
    //   536: dup
    //   537: iconst_0
    //   538: bipush 100
    //   540: invokestatic 58	java/lang/System:currentTimeMillis	()J
    //   543: lload_3
    //   544: lsub
    //   545: aload 5
    //   547: getfield 223	com/tencent/token/afo:h	Ljava/lang/String;
    //   550: iconst_m1
    //   551: invokespecial 226	com/tencent/token/afl:<init>	(IIJLjava/lang/String;I)V
    //   554: areturn
    //   555: sipush -1901
    //   558: invokestatic 95	com/tencent/token/afl:a	(I)Lcom/tencent/token/afl;
    //   561: areturn
    //   562: sipush -1803
    //   565: invokestatic 95	com/tencent/token/afl:a	(I)Lcom/tencent/token/afl;
    //   568: areturn
    //   569: sipush -1802
    //   572: invokestatic 95	com/tencent/token/afl:a	(I)Lcom/tencent/token/afl;
    //   575: areturn
    //   576: sipush -1801
    //   579: invokestatic 95	com/tencent/token/afl:a	(I)Lcom/tencent/token/afl;
    //   582: areturn
    //   583: sipush -1304
    //   586: invokestatic 95	com/tencent/token/afl:a	(I)Lcom/tencent/token/afl;
    //   589: areturn
    //   590: sipush -1303
    //   593: invokestatic 95	com/tencent/token/afl:a	(I)Lcom/tencent/token/afl;
    //   596: areturn
    //   597: sipush -1302
    //   600: invokestatic 95	com/tencent/token/afl:a	(I)Lcom/tencent/token/afl;
    //   603: areturn
    //   604: sipush -1301
    //   607: invokestatic 95	com/tencent/token/afl:a	(I)Lcom/tencent/token/afl;
    //   610: areturn
    //   611: sipush -1104
    //   614: invokestatic 95	com/tencent/token/afl:a	(I)Lcom/tencent/token/afl;
    //   617: areturn
    //   618: sipush -1103
    //   621: invokestatic 95	com/tencent/token/afl:a	(I)Lcom/tencent/token/afl;
    //   624: areturn
    //   625: sipush -1102
    //   628: invokestatic 95	com/tencent/token/afl:a	(I)Lcom/tencent/token/afl;
    //   631: areturn
    //   632: sipush -1101
    //   635: invokestatic 95	com/tencent/token/afl:a	(I)Lcom/tencent/token/afl;
    //   638: areturn
    //   639: astore 5
    //   641: goto -9 -> 632
    //   644: astore 5
    //   646: goto -21 -> 625
    //   649: astore 5
    //   651: goto -33 -> 618
    //   654: astore 5
    //   656: goto -45 -> 611
    //   659: astore 5
    //   661: goto -57 -> 604
    //   664: astore 5
    //   666: goto -69 -> 597
    //   669: astore 5
    //   671: goto -81 -> 590
    //   674: astore 5
    //   676: goto -93 -> 583
    //   679: astore 7
    //   681: goto -492 -> 189
    //   684: astore 5
    //   686: goto -301 -> 385
    //   689: astore 5
    //   691: goto -313 -> 378
    //   694: astore 5
    //   696: goto -325 -> 371
    //   699: astore 5
    //   701: goto -337 -> 364
    //   704: astore 5
    //   706: goto -349 -> 357
    //   709: astore 5
    //   711: goto -361 -> 350
    //   714: astore 5
    //   716: goto -373 -> 343
    //   719: astore 5
    //   721: goto -385 -> 336
    //   724: astore 5
    //   726: goto -393 -> 333
    //   729: astore 5
    //   731: goto -155 -> 576
    //   734: astore 5
    //   736: goto -167 -> 569
    //   739: astore 5
    //   741: goto -179 -> 562
    //   744: astore 6
    //   746: goto -213 -> 533
    //   749: iconst_4
    //   750: istore_1
    //   751: goto -500 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   67	441	0	i	int
    //   65	686	1	j	int
    //   162	362	2	k	int
    //   3	541	3	l	long
    //   26	417	5	localObject1	Object
    //   445	3	5	localKeyStoreException1	java.security.KeyStoreException
    //   478	68	5	localObject2	Object
    //   639	1	5	localInvocationTargetException1	java.lang.reflect.InvocationTargetException
    //   644	1	5	localNoSuchMethodException1	java.lang.NoSuchMethodException
    //   649	1	5	localIllegalAccessException1	java.lang.IllegalAccessException
    //   654	1	5	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   659	1	5	localKeyStoreException2	java.security.KeyStoreException
    //   664	1	5	localCertificateException	java.security.cert.CertificateException
    //   669	1	5	localIOException	java.io.IOException
    //   674	1	5	localNoSuchAlgorithmException1	java.security.NoSuchAlgorithmException
    //   684	1	5	localNoSuchAlgorithmException2	java.security.NoSuchAlgorithmException
    //   689	1	5	localNoSuchProviderException	java.security.NoSuchProviderException
    //   694	1	5	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   699	1	5	localNoSuchMethodException2	java.lang.NoSuchMethodException
    //   704	1	5	localIllegalAccessException2	java.lang.IllegalAccessException
    //   709	1	5	localInvocationTargetException2	java.lang.reflect.InvocationTargetException
    //   714	1	5	localInstantiationException	java.lang.InstantiationException
    //   719	1	5	localInvalidAlgorithmParameterException	java.security.InvalidAlgorithmParameterException
    //   724	1	5	localObject3	Object
    //   729	1	5	localKeyStoreException3	java.security.KeyStoreException
    //   734	1	5	localNoSuchAlgorithmException3	java.security.NoSuchAlgorithmException
    //   739	1	5	localUnrecoverableKeyException	java.security.UnrecoverableKeyException
    //   80	440	6	localObject4	Object
    //   744	1	6	localObject5	Object
    //   48	277	7	localObject6	Object
    //   679	1	7	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   396	442	445	java/security/KeyStoreException
    //   4	45	639	java/lang/reflect/InvocationTargetException
    //   4	45	644	java/lang/NoSuchMethodException
    //   4	45	649	java/lang/IllegalAccessException
    //   4	45	654	java/lang/ClassNotFoundException
    //   146	159	659	java/security/KeyStoreException
    //   146	159	664	java/security/cert/CertificateException
    //   146	159	669	java/io/IOException
    //   146	159	674	java/security/NoSuchAlgorithmException
    //   163	179	679	finally
    //   195	204	684	java/security/NoSuchAlgorithmException
    //   195	204	689	java/security/NoSuchProviderException
    //   204	241	694	java/lang/ClassNotFoundException
    //   251	271	694	java/lang/ClassNotFoundException
    //   274	286	694	java/lang/ClassNotFoundException
    //   286	317	694	java/lang/ClassNotFoundException
    //   204	241	699	java/lang/NoSuchMethodException
    //   251	271	699	java/lang/NoSuchMethodException
    //   274	286	699	java/lang/NoSuchMethodException
    //   286	317	699	java/lang/NoSuchMethodException
    //   204	241	704	java/lang/IllegalAccessException
    //   251	271	704	java/lang/IllegalAccessException
    //   274	286	704	java/lang/IllegalAccessException
    //   286	317	704	java/lang/IllegalAccessException
    //   204	241	709	java/lang/reflect/InvocationTargetException
    //   251	271	709	java/lang/reflect/InvocationTargetException
    //   274	286	709	java/lang/reflect/InvocationTargetException
    //   286	317	709	java/lang/reflect/InvocationTargetException
    //   204	241	714	java/lang/InstantiationException
    //   251	271	714	java/lang/InstantiationException
    //   274	286	714	java/lang/InstantiationException
    //   286	317	714	java/lang/InstantiationException
    //   317	324	719	java/security/InvalidAlgorithmParameterException
    //   324	330	724	finally
    //   455	480	729	java/security/KeyStoreException
    //   455	480	734	java/security/NoSuchAlgorithmException
    //   455	480	739	java/security/UnrecoverableKeyException
    //   519	533	744	finally
  }
  
  public static afl a(Context paramContext)
  {
    final long l = System.currentTimeMillis();
    Intent localIntent = new Intent();
    localIntent.setAction(agg.a(agg.aN));
    localIntent.setPackage(agg.a(agg.aO));
    Object localObject = new Object();
    AtomicReference localAtomicReference = new AtomicReference();
    localAtomicReference.set(afl.b(-2001));
    if (paramContext.getApplicationContext().bindService(localIntent, new a(localAtomicReference, l, localObject), 1)) {}
    try
    {
      try
      {
        localObject.wait(5000L);
      }
      finally
      {
        break label110;
      }
    }
    catch (InterruptedException paramContext)
    {
      label105:
      break label105;
    }
    break label125;
    label110:
    throw paramContext;
    localAtomicReference.set(afl.b(-2002));
    label125:
    return (afl)localAtomicReference.get();
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
    localObject = new afo(new String((byte[])localObject));
    i = paramArrayOfByte.length - j;
    if (i != 0)
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(paramArrayOfByte, j, arrayOfByte, 0, i);
      Base64.encodeToString(arrayOfByte, 2);
      return new b(0, (afo)localObject);
    }
    return new b(-3005, null);
  }
  
  public final class a
    implements ServiceConnection
  {
    public a(long paramLong, Object paramObject) {}
    
    public final void onServiceConnected(ComponentName paramComponentName, final IBinder paramIBinder)
    {
      new a(paramIBinder).start();
    }
    
    public final void onServiceDisconnected(ComponentName arg1)
    {
      afp.this.set(afl.b(-2004));
      synchronized (this.c)
      {
        this.c.notify();
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
        ??? = afi.a.a;
        if (localObject1 == null)
        {
          localObject1 = null;
        }
        else
        {
          ??? = ((IBinder)localObject1).queryLocalInterface(afi.a.a);
          if ((??? != null) && ((??? instanceof afi))) {
            localObject1 = (afi)???;
          } else {
            localObject1 = new afi.a.a((IBinder)localObject1);
          }
        }
        try
        {
          if (!((afi)localObject1).c()) {
            ((afi)localObject1).a();
          }
          ??? = afp.a(((afi)localObject1).b().c);
          int i = ((afp.b)???).a;
          if (i != 0)
          {
            afp.this.set(afl.b(i));
          }
          else
          {
            ??? = ((afp.b)???).b;
            i = ((afi)localObject1).e();
            afp.this.set(new afl(0, 200, System.currentTimeMillis() - afp.a.this.b, ((afo)???).h, i));
          }
        }
        finally
        {
          label163:
          break label163;
        }
        afp.this.set(afl.b(-2003));
        synchronized (afp.a.this.c)
        {
          afp.a.this.c.notify();
          try
          {
            ((afi)localObject1).d();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            localRemoteException.printStackTrace();
            return;
          }
        }
      }
    }
  }
  
  public static final class b
  {
    public int a;
    public afo b;
    
    public b(int paramInt, afo paramafo)
    {
      this.a = paramInt;
      this.b = paramafo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afp
 * JD-Core Version:    0.7.0.1
 */