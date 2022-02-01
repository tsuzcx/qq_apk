package com.tencent.token;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

public class lc
{
  public static String a = "";
  public static int b = 0;
  private static String c = "cmwap";
  private static String d = "3gwap";
  private static String e = "uniwap";
  private static String f = "ctwap";
  private static volatile boolean g = true;
  private static int h = 0;
  private static boolean i = false;
  private static String j = "";
  private static a k;
  private static BroadcastReceiver l = new ld();
  private static volatile boolean m = false;
  
  public static int a(int paramInt)
  {
    if (paramInt <= -105) {
      return 0;
    }
    if (paramInt >= -85) {
      return 5;
    }
    return (int)((paramInt + 105) * 5.0F / 20.0F);
  }
  
  public static void a()
  {
    b();
    g();
    Object localObject = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    lo.a().registerReceiver(l, (IntentFilter)localObject);
    localObject = (TelephonyManager)lo.a().getSystemService("phone");
    if (localObject != null) {
      ((TelephonyManager)localObject).listen(new b(), 257);
    }
  }
  
  public static void a(a parama)
  {
    k = parama;
  }
  
  /* Error */
  public static void b()
  {
    // Byte code:
    //   0: ldc 96
    //   2: ldc 98
    //   4: invokestatic 103	com/tencent/token/lh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: getstatic 49	com/tencent/token/lc:m	Z
    //   10: ifeq +4 -> 14
    //   13: return
    //   14: iconst_1
    //   15: putstatic 49	com/tencent/token/lc:m	Z
    //   18: ldc 2
    //   20: monitorenter
    //   21: getstatic 105	com/tencent/token/lc:a	Ljava/lang/String;
    //   24: astore_2
    //   25: invokestatic 70	com/tencent/token/lo:a	()Landroid/content/Context;
    //   28: ldc 107
    //   30: invokevirtual 82	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   33: checkcast 109	android/net/ConnectivityManager
    //   36: astore_1
    //   37: aload_1
    //   38: ifnonnull +63 -> 101
    //   41: ldc 13
    //   43: putstatic 105	com/tencent/token/lc:a	Ljava/lang/String;
    //   46: iconst_0
    //   47: putstatic 111	com/tencent/token/lc:h	I
    //   50: iconst_0
    //   51: putstatic 113	com/tencent/token/lc:i	Z
    //   54: ldc 13
    //   56: putstatic 115	com/tencent/token/lc:j	Ljava/lang/String;
    //   59: iconst_0
    //   60: putstatic 117	com/tencent/token/lc:g	Z
    //   63: aload_2
    //   64: getstatic 105	com/tencent/token/lc:a	Ljava/lang/String;
    //   67: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifne +23 -> 93
    //   73: getstatic 92	com/tencent/token/lc:k	Lcom/tencent/token/lc$a;
    //   76: ifnull +17 -> 93
    //   79: getstatic 92	com/tencent/token/lc:k	Lcom/tencent/token/lc$a;
    //   82: getstatic 111	com/tencent/token/lc:h	I
    //   85: getstatic 105	com/tencent/token/lc:a	Ljava/lang/String;
    //   88: invokeinterface 126 3 0
    //   93: iconst_0
    //   94: putstatic 49	com/tencent/token/lc:m	Z
    //   97: ldc 2
    //   99: monitorexit
    //   100: return
    //   101: aload_1
    //   102: invokevirtual 130	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   105: astore_1
    //   106: aload_1
    //   107: ifnonnull +63 -> 170
    //   110: ldc 13
    //   112: putstatic 105	com/tencent/token/lc:a	Ljava/lang/String;
    //   115: iconst_0
    //   116: putstatic 111	com/tencent/token/lc:h	I
    //   119: iconst_0
    //   120: putstatic 113	com/tencent/token/lc:i	Z
    //   123: ldc 13
    //   125: putstatic 115	com/tencent/token/lc:j	Ljava/lang/String;
    //   128: iconst_0
    //   129: putstatic 117	com/tencent/token/lc:g	Z
    //   132: aload_2
    //   133: getstatic 105	com/tencent/token/lc:a	Ljava/lang/String;
    //   136: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   139: ifne +23 -> 162
    //   142: getstatic 92	com/tencent/token/lc:k	Lcom/tencent/token/lc$a;
    //   145: ifnull +17 -> 162
    //   148: getstatic 92	com/tencent/token/lc:k	Lcom/tencent/token/lc$a;
    //   151: getstatic 111	com/tencent/token/lc:h	I
    //   154: getstatic 105	com/tencent/token/lc:a	Ljava/lang/String;
    //   157: invokeinterface 126 3 0
    //   162: iconst_0
    //   163: putstatic 49	com/tencent/token/lc:m	Z
    //   166: ldc 2
    //   168: monitorexit
    //   169: return
    //   170: aload_1
    //   171: invokevirtual 136	android/net/NetworkInfo:isConnected	()Z
    //   174: ifeq +10 -> 184
    //   177: iconst_1
    //   178: putstatic 117	com/tencent/token/lc:g	Z
    //   181: goto +7 -> 188
    //   184: iconst_0
    //   185: putstatic 117	com/tencent/token/lc:g	Z
    //   188: aload_1
    //   189: invokevirtual 140	android/net/NetworkInfo:getType	()I
    //   192: istore_0
    //   193: iload_0
    //   194: iconst_1
    //   195: if_icmpne +137 -> 332
    //   198: iconst_1
    //   199: putstatic 111	com/tencent/token/lc:h	I
    //   202: iconst_0
    //   203: putstatic 113	com/tencent/token/lc:i	Z
    //   206: ldc 13
    //   208: putstatic 115	com/tencent/token/lc:j	Ljava/lang/String;
    //   211: invokestatic 70	com/tencent/token/lo:a	()Landroid/content/Context;
    //   214: ldc 142
    //   216: invokevirtual 82	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   219: checkcast 144	android/net/wifi/WifiManager
    //   222: invokevirtual 148	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   225: astore_1
    //   226: aload_1
    //   227: invokevirtual 154	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   230: ifnull +22 -> 252
    //   233: aload_1
    //   234: invokevirtual 157	android/net/wifi/WifiInfo:getRssi	()I
    //   237: istore_0
    //   238: getstatic 162	android/os/Build$VERSION:SDK_INT	I
    //   241: bipush 14
    //   243: if_icmplt +9 -> 252
    //   246: iload_0
    //   247: iconst_5
    //   248: invokestatic 166	android/net/wifi/WifiManager:calculateSignalLevel	(II)I
    //   251: pop
    //   252: new 168	java/lang/StringBuilder
    //   255: dup
    //   256: ldc 170
    //   258: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   261: astore_3
    //   262: aload_3
    //   263: aload_1
    //   264: invokevirtual 174	android/net/wifi/WifiInfo:getSSID	()Ljava/lang/String;
    //   267: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload_3
    //   272: ldc 180
    //   274: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload_3
    //   279: aload_1
    //   280: invokevirtual 154	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   283: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload_3
    //   288: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: putstatic 105	com/tencent/token/lc:a	Ljava/lang/String;
    //   294: aload_2
    //   295: getstatic 105	com/tencent/token/lc:a	Ljava/lang/String;
    //   298: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   301: ifne +23 -> 324
    //   304: getstatic 92	com/tencent/token/lc:k	Lcom/tencent/token/lc$a;
    //   307: ifnull +17 -> 324
    //   310: getstatic 92	com/tencent/token/lc:k	Lcom/tencent/token/lc$a;
    //   313: getstatic 111	com/tencent/token/lc:h	I
    //   316: getstatic 105	com/tencent/token/lc:a	Ljava/lang/String;
    //   319: invokeinterface 126 3 0
    //   324: iconst_0
    //   325: putstatic 49	com/tencent/token/lc:m	Z
    //   328: ldc 2
    //   330: monitorexit
    //   331: return
    //   332: aload_1
    //   333: invokevirtual 186	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   336: astore_3
    //   337: aload_3
    //   338: ifnonnull +59 -> 397
    //   341: ldc 13
    //   343: putstatic 105	com/tencent/token/lc:a	Ljava/lang/String;
    //   346: iconst_0
    //   347: putstatic 111	com/tencent/token/lc:h	I
    //   350: iconst_0
    //   351: putstatic 113	com/tencent/token/lc:i	Z
    //   354: ldc 13
    //   356: putstatic 115	com/tencent/token/lc:j	Ljava/lang/String;
    //   359: aload_2
    //   360: getstatic 105	com/tencent/token/lc:a	Ljava/lang/String;
    //   363: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   366: ifne +23 -> 389
    //   369: getstatic 92	com/tencent/token/lc:k	Lcom/tencent/token/lc$a;
    //   372: ifnull +17 -> 389
    //   375: getstatic 92	com/tencent/token/lc:k	Lcom/tencent/token/lc$a;
    //   378: getstatic 111	com/tencent/token/lc:h	I
    //   381: getstatic 105	com/tencent/token/lc:a	Ljava/lang/String;
    //   384: invokeinterface 126 3 0
    //   389: iconst_0
    //   390: putstatic 49	com/tencent/token/lc:m	Z
    //   393: ldc 2
    //   395: monitorexit
    //   396: return
    //   397: aload_3
    //   398: invokevirtual 189	java/lang/String:trim	()Ljava/lang/String;
    //   401: invokevirtual 192	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   404: putstatic 105	com/tencent/token/lc:a	Ljava/lang/String;
    //   407: iload_0
    //   408: ifne +50 -> 458
    //   411: aload_1
    //   412: invokevirtual 195	android/net/NetworkInfo:getSubtype	()I
    //   415: istore_0
    //   416: iload_0
    //   417: iconst_1
    //   418: if_icmpeq +36 -> 454
    //   421: iload_0
    //   422: iconst_2
    //   423: if_icmpeq +31 -> 454
    //   426: iload_0
    //   427: iconst_4
    //   428: if_icmpne +6 -> 434
    //   431: goto +23 -> 454
    //   434: iload_0
    //   435: bipush 13
    //   437: if_icmpne +10 -> 447
    //   440: iconst_4
    //   441: putstatic 111	com/tencent/token/lc:h	I
    //   444: goto +14 -> 458
    //   447: iconst_3
    //   448: putstatic 111	com/tencent/token/lc:h	I
    //   451: goto +7 -> 458
    //   454: iconst_2
    //   455: putstatic 111	com/tencent/token/lc:h	I
    //   458: getstatic 105	com/tencent/token/lc:a	Ljava/lang/String;
    //   461: getstatic 197	com/tencent/token/lc:d	Ljava/lang/String;
    //   464: invokevirtual 201	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   467: ifeq +17 -> 484
    //   470: iconst_1
    //   471: putstatic 113	com/tencent/token/lc:i	Z
    //   474: ldc 203
    //   476: astore_1
    //   477: aload_1
    //   478: putstatic 115	com/tencent/token/lc:j	Ljava/lang/String;
    //   481: goto +79 -> 560
    //   484: getstatic 105	com/tencent/token/lc:a	Ljava/lang/String;
    //   487: getstatic 205	com/tencent/token/lc:c	Ljava/lang/String;
    //   490: invokevirtual 201	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   493: ifeq +13 -> 506
    //   496: iconst_1
    //   497: putstatic 113	com/tencent/token/lc:i	Z
    //   500: ldc 203
    //   502: astore_1
    //   503: goto -26 -> 477
    //   506: getstatic 105	com/tencent/token/lc:a	Ljava/lang/String;
    //   509: getstatic 207	com/tencent/token/lc:e	Ljava/lang/String;
    //   512: invokevirtual 201	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   515: ifeq +13 -> 528
    //   518: iconst_1
    //   519: putstatic 113	com/tencent/token/lc:i	Z
    //   522: ldc 203
    //   524: astore_1
    //   525: goto -48 -> 477
    //   528: getstatic 105	com/tencent/token/lc:a	Ljava/lang/String;
    //   531: getstatic 209	com/tencent/token/lc:f	Ljava/lang/String;
    //   534: invokevirtual 201	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   537: ifeq +13 -> 550
    //   540: iconst_1
    //   541: putstatic 113	com/tencent/token/lc:i	Z
    //   544: ldc 211
    //   546: astore_1
    //   547: goto -70 -> 477
    //   550: iconst_0
    //   551: putstatic 113	com/tencent/token/lc:i	Z
    //   554: ldc 13
    //   556: astore_1
    //   557: goto -80 -> 477
    //   560: aload_2
    //   561: getstatic 105	com/tencent/token/lc:a	Ljava/lang/String;
    //   564: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   567: ifne +23 -> 590
    //   570: getstatic 92	com/tencent/token/lc:k	Lcom/tencent/token/lc$a;
    //   573: ifnull +17 -> 590
    //   576: getstatic 92	com/tencent/token/lc:k	Lcom/tencent/token/lc$a;
    //   579: getstatic 111	com/tencent/token/lc:h	I
    //   582: getstatic 105	com/tencent/token/lc:a	Ljava/lang/String;
    //   585: invokeinterface 126 3 0
    //   590: iconst_0
    //   591: putstatic 49	com/tencent/token/lc:m	Z
    //   594: goto +63 -> 657
    //   597: astore_1
    //   598: goto +63 -> 661
    //   601: astore_1
    //   602: aload_1
    //   603: invokevirtual 214	java/lang/Throwable:printStackTrace	()V
    //   606: ldc 13
    //   608: putstatic 105	com/tencent/token/lc:a	Ljava/lang/String;
    //   611: iconst_0
    //   612: putstatic 111	com/tencent/token/lc:h	I
    //   615: iconst_0
    //   616: putstatic 113	com/tencent/token/lc:i	Z
    //   619: ldc 13
    //   621: putstatic 115	com/tencent/token/lc:j	Ljava/lang/String;
    //   624: aload_2
    //   625: getstatic 105	com/tencent/token/lc:a	Ljava/lang/String;
    //   628: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   631: ifne -41 -> 590
    //   634: getstatic 92	com/tencent/token/lc:k	Lcom/tencent/token/lc$a;
    //   637: ifnull -47 -> 590
    //   640: getstatic 92	com/tencent/token/lc:k	Lcom/tencent/token/lc$a;
    //   643: getstatic 111	com/tencent/token/lc:h	I
    //   646: getstatic 105	com/tencent/token/lc:a	Ljava/lang/String;
    //   649: invokeinterface 126 3 0
    //   654: goto -64 -> 590
    //   657: ldc 2
    //   659: monitorexit
    //   660: return
    //   661: aload_2
    //   662: getstatic 105	com/tencent/token/lc:a	Ljava/lang/String;
    //   665: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   668: ifne +23 -> 691
    //   671: getstatic 92	com/tencent/token/lc:k	Lcom/tencent/token/lc$a;
    //   674: ifnull +17 -> 691
    //   677: getstatic 92	com/tencent/token/lc:k	Lcom/tencent/token/lc$a;
    //   680: getstatic 111	com/tencent/token/lc:h	I
    //   683: getstatic 105	com/tencent/token/lc:a	Ljava/lang/String;
    //   686: invokeinterface 126 3 0
    //   691: iconst_0
    //   692: putstatic 49	com/tencent/token/lc:m	Z
    //   695: aload_1
    //   696: athrow
    //   697: astore_1
    //   698: ldc 2
    //   700: monitorexit
    //   701: aload_1
    //   702: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   192	246	0	n	int
    //   36	521	1	localObject1	Object
    //   597	1	1	localObject2	Object
    //   601	95	1	localThrowable	java.lang.Throwable
    //   697	5	1	localObject3	Object
    //   24	638	2	str	String
    //   261	137	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   25	37	597	finally
    //   41	63	597	finally
    //   101	106	597	finally
    //   110	132	597	finally
    //   170	181	597	finally
    //   184	188	597	finally
    //   188	193	597	finally
    //   198	252	597	finally
    //   252	294	597	finally
    //   332	337	597	finally
    //   341	359	597	finally
    //   397	407	597	finally
    //   411	416	597	finally
    //   440	444	597	finally
    //   447	451	597	finally
    //   454	458	597	finally
    //   458	474	597	finally
    //   477	481	597	finally
    //   484	500	597	finally
    //   506	522	597	finally
    //   528	544	597	finally
    //   550	554	597	finally
    //   602	624	597	finally
    //   25	37	601	java/lang/Throwable
    //   41	63	601	java/lang/Throwable
    //   101	106	601	java/lang/Throwable
    //   110	132	601	java/lang/Throwable
    //   170	181	601	java/lang/Throwable
    //   184	188	601	java/lang/Throwable
    //   188	193	601	java/lang/Throwable
    //   198	252	601	java/lang/Throwable
    //   252	294	601	java/lang/Throwable
    //   332	337	601	java/lang/Throwable
    //   341	359	601	java/lang/Throwable
    //   397	407	601	java/lang/Throwable
    //   411	416	601	java/lang/Throwable
    //   440	444	601	java/lang/Throwable
    //   447	451	601	java/lang/Throwable
    //   454	458	601	java/lang/Throwable
    //   458	474	601	java/lang/Throwable
    //   477	481	601	java/lang/Throwable
    //   484	500	601	java/lang/Throwable
    //   506	522	601	java/lang/Throwable
    //   528	544	601	java/lang/Throwable
    //   550	554	601	java/lang/Throwable
    //   21	25	697	finally
    //   63	93	697	finally
    //   93	100	697	finally
    //   132	162	697	finally
    //   162	169	697	finally
    //   294	324	697	finally
    //   324	331	697	finally
    //   359	389	697	finally
    //   389	396	697	finally
    //   560	590	697	finally
    //   590	594	697	finally
    //   624	654	697	finally
    //   657	660	697	finally
    //   661	691	697	finally
    //   691	697	697	finally
  }
  
  public static Proxy c()
  {
    if ((i) && (!TextUtils.isEmpty(j))) {
      return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(j, 80));
    }
    return null;
  }
  
  public static boolean d()
  {
    return i;
  }
  
  public static int e()
  {
    return h;
  }
  
  public static boolean f()
  {
    return g;
  }
  
  public static void g()
  {
    StringBuilder localStringBuilder = new StringBuilder("showApnInfo... Apn:");
    localStringBuilder.append(a);
    localStringBuilder.append(",sIsNetworkOk:");
    localStringBuilder.append(g);
    localStringBuilder.append(",sNetType:");
    localStringBuilder.append(h);
    localStringBuilder.append(",sIsProxy:");
    localStringBuilder.append(i);
    localStringBuilder.append(",sProxyAddress:");
    localStringBuilder.append(j);
    lh.b("DownloaderApn", localStringBuilder.toString());
  }
  
  public static boolean h()
  {
    int n = h;
    if ((n != 2) && (n != 3)) {
      n = 0;
    } else {
      n = 1;
    }
    if (n != 0) {
      return le.b();
    }
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, String paramString);
  }
  
  public static final class b
    extends PhoneStateListener
  {
    public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
    {
      super.onSignalStrengthsChanged(paramSignalStrength);
      lc.b = lc.a(paramSignalStrength.getGsmSignalStrength() * 2 - 113);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.lc
 * JD-Core Version:    0.7.0.1
 */