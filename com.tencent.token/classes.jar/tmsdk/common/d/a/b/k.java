package tmsdk.common.d.a.b;

import android.content.Context;
import android.text.TextUtils;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;
import tmsdk.common.c.a.e;
import tmsdk.common.e.a;

public class k
{
  private final String a = "RsaKeyCertifier";
  private o b;
  private Object c = new Object();
  private l d;
  private volatile long e;
  
  public k(Context paramContext, o paramo)
  {
    this.b = paramo;
    this.d = new l();
    e();
  }
  
  private String a(int paramInt)
  {
    Random localRandom = new Random();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramInt)
    {
      localStringBuffer.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(localRandom.nextInt(62)));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (this.c)
    {
      this.d.a = paramString;
      return;
    }
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (this.c)
    {
      this.d.b = paramString;
      return;
    }
  }
  
  private String c()
  {
    synchronized (this.c)
    {
      if (this.d.a == null) {
        return "";
      }
      String str = this.d.a;
      return str;
    }
  }
  
  private void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    b(paramString);
    this.b.a().a(d());
  }
  
  private String d()
  {
    synchronized (this.c)
    {
      if (this.d.b == null) {
        return "";
      }
      String str = this.d.b;
      return str;
    }
  }
  
  private void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a(paramString);
    this.b.a().b(c());
  }
  
  private void e()
  {
    synchronized (this.c)
    {
      b(this.b.a().d());
      a(this.b.a().e());
      this.e = this.b.a().q();
      new StringBuilder().append("load() mEncodeKey: ").append(d()).append(" mSessionId: ").append(c()).toString();
      new StringBuilder().append("[ocean]info: Refh: sessionId|").append(c()).append("|encodeKey|").append(d()).toString();
      return;
    }
  }
  
  private byte[] e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      Object localObject = a.a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDb49jFnNqMDLdl87UtY5jOMqqdMuvQg65Zuva3Qm1tORQGBuM04u7fqygA64XbOx9e/KPNkDNDmqS8SlsAPL1fV2lqM/phgV0NY62TJqSR+PLngwJd2rhYR8wQ1N0JE+R59a5c08EGsd6axStjHsVu2+evCf/SWU9Y/oQpEtOjGwIDAQAB", 0);
      localObject = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec((byte[])localObject));
      Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      localCipher.init(1, (Key)localObject);
      paramString = localCipher.doFinal(paramString.getBytes());
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void f()
  {
    b(a(16));
  }
  
  public l a()
  {
    l locall = new l();
    locall.a = this.d.a;
    locall.b = this.d.b;
    return locall;
  }
  
  /* Error */
  public boolean a(java.util.concurrent.atomic.AtomicReference arg1)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +32 -> 33
    //   4: new 29	tmsdk/common/d/a/b/l
    //   7: dup
    //   8: invokespecial 30	tmsdk/common/d/a/b/l:<init>	()V
    //   11: astore_3
    //   12: aload_3
    //   13: aload_0
    //   14: invokespecial 90	tmsdk/common/d/a/b/k:c	()Ljava/lang/String;
    //   17: putfield 70	tmsdk/common/d/a/b/l:a	Ljava/lang/String;
    //   20: aload_3
    //   21: aload_0
    //   22: invokespecial 83	tmsdk/common/d/a/b/k:d	()Ljava/lang/String;
    //   25: putfield 72	tmsdk/common/d/a/b/l:b	Ljava/lang/String;
    //   28: aload_1
    //   29: aload_3
    //   30: invokevirtual 175	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   33: aload_0
    //   34: invokespecial 177	tmsdk/common/d/a/b/k:f	()V
    //   37: new 179	a/d/a
    //   40: dup
    //   41: invokespecial 180	a/d/a:<init>	()V
    //   44: astore_1
    //   45: aload_0
    //   46: aload_0
    //   47: invokespecial 83	tmsdk/common/d/a/b/k:d	()Ljava/lang/String;
    //   50: invokespecial 182	tmsdk/common/d/a/b/k:e	(Ljava/lang/String;)[B
    //   53: astore_3
    //   54: aload_3
    //   55: ifnonnull +13 -> 68
    //   58: new 184	java/lang/RuntimeException
    //   61: dup
    //   62: ldc 186
    //   64: invokespecial 188	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   67: athrow
    //   68: aload_1
    //   69: aload_3
    //   70: putfield 191	a/d/a:a	[B
    //   73: new 102	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   80: ldc 193
    //   82: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_1
    //   86: getfield 191	a/d/a:a	[B
    //   89: invokestatic 198	tmsdk/common/c/a/d:a	([B)Ljava/lang/String;
    //   92: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: pop
    //   99: new 200	a/e/c
    //   102: dup
    //   103: invokespecial 201	a/e/c:<init>	()V
    //   106: astore_3
    //   107: aload_3
    //   108: aload_0
    //   109: getfield 27	tmsdk/common/d/a/b/k:b	Ltmsdk/common/d/a/b/o;
    //   112: invokevirtual 204	tmsdk/common/d/a/b/o:c	()Ltmsdk/common/d/a/b/f;
    //   115: invokeinterface 209 1 0
    //   120: putfield 212	a/e/c:b	I
    //   123: aload_3
    //   124: sipush 152
    //   127: putfield 214	a/e/c:a	I
    //   130: aload_3
    //   131: aload_1
    //   132: invokestatic 219	tmsdk/common/d/a/b/b:a	(Lcom/qq/taf/jce/JceStruct;)[B
    //   135: putfield 221	a/e/c:d	[B
    //   138: new 223	java/util/ArrayList
    //   141: dup
    //   142: invokespecial 224	java/util/ArrayList:<init>	()V
    //   145: astore_1
    //   146: aload_1
    //   147: aload_3
    //   148: invokevirtual 228	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   151: pop
    //   152: new 171	java/util/concurrent/atomic/AtomicReference
    //   155: dup
    //   156: invokespecial 229	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   159: astore_3
    //   160: aload_0
    //   161: getfield 27	tmsdk/common/d/a/b/k:b	Ltmsdk/common/d/a/b/o;
    //   164: iconst_1
    //   165: iconst_0
    //   166: iconst_0
    //   167: aconst_null
    //   168: aload_1
    //   169: aload_3
    //   170: invokevirtual 232	tmsdk/common/d/a/b/o:a	(ZZZLtmsdk/common/d/a/b/l;Ljava/util/ArrayList;Ljava/util/concurrent/atomic/AtomicReference;)I
    //   173: istore_2
    //   174: iload_2
    //   175: ifeq +25 -> 200
    //   178: new 102	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   185: ldc 234
    //   187: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: iload_2
    //   191: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: pop
    //   198: iconst_0
    //   199: ireturn
    //   200: aload_3
    //   201: invokevirtual 241	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   204: checkcast 223	java/util/ArrayList
    //   207: astore_1
    //   208: aload_1
    //   209: ifnull -11 -> 198
    //   212: aload_1
    //   213: invokevirtual 244	java/util/ArrayList:size	()I
    //   216: ifle -18 -> 198
    //   219: aload_1
    //   220: iconst_0
    //   221: invokevirtual 247	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   224: checkcast 249	a/e/f
    //   227: astore_3
    //   228: aload_3
    //   229: ifnull -31 -> 198
    //   232: new 102	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   239: ldc 251
    //   241: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload_3
    //   245: getfield 252	a/e/f:b	I
    //   248: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   251: ldc 254
    //   253: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload_3
    //   257: getfield 255	a/e/f:a	I
    //   260: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   263: ldc_w 257
    //   266: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload_3
    //   270: getfield 259	a/e/f:d	I
    //   273: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   276: ldc_w 261
    //   279: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload_3
    //   283: getfield 263	a/e/f:e	I
    //   286: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   289: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: pop
    //   293: iconst_1
    //   294: aload_3
    //   295: getfield 259	a/e/f:d	I
    //   298: if_icmpeq -100 -> 198
    //   301: aload_3
    //   302: getfield 263	a/e/f:e	I
    //   305: ifeq +29 -> 334
    //   308: new 102	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   315: ldc_w 265
    //   318: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload_3
    //   322: getfield 263	a/e/f:e	I
    //   325: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   328: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: pop
    //   332: iconst_0
    //   333: ireturn
    //   334: aload_3
    //   335: getfield 267	a/e/f:f	[B
    //   338: astore_1
    //   339: aload_1
    //   340: ifnull -142 -> 198
    //   343: new 102	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   350: ldc_w 269
    //   353: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload_3
    //   357: getfield 267	a/e/f:f	[B
    //   360: arraylength
    //   361: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   364: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: pop
    //   368: new 271	a/d/b
    //   371: dup
    //   372: invokespecial 272	a/d/b:<init>	()V
    //   375: astore_3
    //   376: aload_1
    //   377: aload_3
    //   378: invokestatic 275	tmsdk/common/d/a/b/b:a	([BLcom/qq/taf/jce/JceStruct;)Lcom/qq/taf/jce/JceStruct;
    //   381: astore_1
    //   382: aload_1
    //   383: ifnull -185 -> 198
    //   386: aload_1
    //   387: checkcast 271	a/d/b
    //   390: astore_3
    //   391: aload_0
    //   392: invokespecial 83	tmsdk/common/d/a/b/k:d	()Ljava/lang/String;
    //   395: invokestatic 69	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   398: ifne +13 -> 411
    //   401: aload_3
    //   402: getfield 276	a/d/b:a	Ljava/lang/String;
    //   405: invokestatic 69	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   408: ifeq +144 -> 552
    //   411: iconst_1
    //   412: istore_2
    //   413: iload_2
    //   414: ifne -216 -> 198
    //   417: new 102	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   424: ldc_w 278
    //   427: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: aload_0
    //   431: invokespecial 90	tmsdk/common/d/a/b/k:c	()Ljava/lang/String;
    //   434: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: ldc 115
    //   439: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: aload_0
    //   443: invokespecial 83	tmsdk/common/d/a/b/k:d	()Ljava/lang/String;
    //   446: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: pop
    //   453: aload_0
    //   454: getfield 25	tmsdk/common/d/a/b/k:c	Ljava/lang/Object;
    //   457: astore_1
    //   458: aload_1
    //   459: monitorenter
    //   460: aload_0
    //   461: aload_0
    //   462: invokespecial 83	tmsdk/common/d/a/b/k:d	()Ljava/lang/String;
    //   465: invokespecial 280	tmsdk/common/d/a/b/k:c	(Ljava/lang/String;)V
    //   468: aload_0
    //   469: aload_3
    //   470: getfield 276	a/d/b:a	Ljava/lang/String;
    //   473: invokespecial 282	tmsdk/common/d/a/b/k:d	(Ljava/lang/String;)V
    //   476: aload_1
    //   477: monitorexit
    //   478: new 102	java/lang/StringBuilder
    //   481: dup
    //   482: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   485: ldc_w 284
    //   488: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: aload_0
    //   492: invokespecial 83	tmsdk/common/d/a/b/k:d	()Ljava/lang/String;
    //   495: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: ldc 110
    //   500: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: aload_3
    //   504: getfield 276	a/d/b:a	Ljava/lang/String;
    //   507: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: pop
    //   514: new 102	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   521: ldc_w 286
    //   524: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: aload_3
    //   528: getfield 276	a/d/b:a	Ljava/lang/String;
    //   531: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: ldc 115
    //   536: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: aload_0
    //   540: invokespecial 83	tmsdk/common/d/a/b/k:d	()Ljava/lang/String;
    //   543: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: pop
    //   550: iconst_1
    //   551: ireturn
    //   552: iconst_0
    //   553: istore_2
    //   554: goto -141 -> 413
    //   557: astore_3
    //   558: aload_1
    //   559: monitorexit
    //   560: aload_3
    //   561: athrow
    //   562: astore_1
    //   563: iconst_0
    //   564: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	565	0	this	k
    //   173	381	2	i	int
    //   11	517	3	localObject1	Object
    //   557	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   460	478	557	finally
    //   376	382	562	java/lang/Exception
  }
  
  public int b()
  {
    int i;
    if ((TextUtils.isEmpty(d())) || (TextUtils.isEmpty(c())))
    {
      i = 1;
      if (i != 0) {
        break label33;
      }
    }
    label33:
    boolean bool;
    do
    {
      return 0;
      i = 0;
      break;
      long l = System.currentTimeMillis();
      if (!e.b(l, this.e, 10)) {
        return -700;
      }
      this.e = l;
      this.b.a();
      l = this.e;
      bool = a(null);
      new StringBuilder().append("checkRsaKey() 首次交换密钥是否成功：").append(bool).toString();
    } while (bool);
    return -100;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.b.k
 * JD-Core Version:    0.7.0.1
 */