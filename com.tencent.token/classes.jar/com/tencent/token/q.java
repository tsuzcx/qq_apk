package com.tencent.token;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.halley.common.b;
import com.tencent.halley.common.f;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

public class q
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
  private static BroadcastReceiver l = new r();
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
    f.a().registerReceiver(l, (IntentFilter)localObject);
    localObject = (TelephonyManager)f.a().getSystemService("phone");
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
    //   4: invokestatic 103	com/tencent/halley/common/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: getstatic 49	com/tencent/token/q:m	Z
    //   10: ifeq +4 -> 14
    //   13: return
    //   14: iconst_1
    //   15: putstatic 49	com/tencent/token/q:m	Z
    //   18: ldc 2
    //   20: monitorenter
    //   21: getstatic 105	com/tencent/token/q:a	Ljava/lang/String;
    //   24: astore_2
    //   25: invokestatic 70	com/tencent/halley/common/f:a	()Landroid/content/Context;
    //   28: ldc 107
    //   30: invokevirtual 82	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   33: checkcast 109	android/net/ConnectivityManager
    //   36: astore_1
    //   37: aload_1
    //   38: ifnonnull +63 -> 101
    //   41: ldc 13
    //   43: putstatic 105	com/tencent/token/q:a	Ljava/lang/String;
    //   46: iconst_0
    //   47: putstatic 111	com/tencent/token/q:h	I
    //   50: iconst_0
    //   51: putstatic 113	com/tencent/token/q:i	Z
    //   54: ldc 13
    //   56: putstatic 115	com/tencent/token/q:j	Ljava/lang/String;
    //   59: iconst_0
    //   60: putstatic 117	com/tencent/token/q:g	Z
    //   63: aload_2
    //   64: getstatic 105	com/tencent/token/q:a	Ljava/lang/String;
    //   67: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifne +23 -> 93
    //   73: getstatic 92	com/tencent/token/q:k	Lcom/tencent/token/q$a;
    //   76: ifnull +17 -> 93
    //   79: getstatic 92	com/tencent/token/q:k	Lcom/tencent/token/q$a;
    //   82: getstatic 111	com/tencent/token/q:h	I
    //   85: getstatic 105	com/tencent/token/q:a	Ljava/lang/String;
    //   88: invokeinterface 126 3 0
    //   93: iconst_0
    //   94: putstatic 49	com/tencent/token/q:m	Z
    //   97: ldc 2
    //   99: monitorexit
    //   100: return
    //   101: aload_1
    //   102: invokevirtual 130	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   105: astore_1
    //   106: aload_1
    //   107: ifnonnull +63 -> 170
    //   110: ldc 13
    //   112: putstatic 105	com/tencent/token/q:a	Ljava/lang/String;
    //   115: iconst_0
    //   116: putstatic 111	com/tencent/token/q:h	I
    //   119: iconst_0
    //   120: putstatic 113	com/tencent/token/q:i	Z
    //   123: ldc 13
    //   125: putstatic 115	com/tencent/token/q:j	Ljava/lang/String;
    //   128: iconst_0
    //   129: putstatic 117	com/tencent/token/q:g	Z
    //   132: aload_2
    //   133: getstatic 105	com/tencent/token/q:a	Ljava/lang/String;
    //   136: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   139: ifne +23 -> 162
    //   142: getstatic 92	com/tencent/token/q:k	Lcom/tencent/token/q$a;
    //   145: ifnull +17 -> 162
    //   148: getstatic 92	com/tencent/token/q:k	Lcom/tencent/token/q$a;
    //   151: getstatic 111	com/tencent/token/q:h	I
    //   154: getstatic 105	com/tencent/token/q:a	Ljava/lang/String;
    //   157: invokeinterface 126 3 0
    //   162: iconst_0
    //   163: putstatic 49	com/tencent/token/q:m	Z
    //   166: ldc 2
    //   168: monitorexit
    //   169: return
    //   170: aload_1
    //   171: invokevirtual 136	android/net/NetworkInfo:isConnected	()Z
    //   174: ifeq +10 -> 184
    //   177: iconst_1
    //   178: putstatic 117	com/tencent/token/q:g	Z
    //   181: goto +7 -> 188
    //   184: iconst_0
    //   185: putstatic 117	com/tencent/token/q:g	Z
    //   188: aload_1
    //   189: invokevirtual 140	android/net/NetworkInfo:getType	()I
    //   192: istore_0
    //   193: iload_0
    //   194: iconst_1
    //   195: if_icmpne +140 -> 335
    //   198: iconst_1
    //   199: putstatic 111	com/tencent/token/q:h	I
    //   202: iconst_0
    //   203: putstatic 113	com/tencent/token/q:i	Z
    //   206: ldc 13
    //   208: putstatic 115	com/tencent/token/q:j	Ljava/lang/String;
    //   211: invokestatic 70	com/tencent/halley/common/f:a	()Landroid/content/Context;
    //   214: ldc 142
    //   216: invokevirtual 82	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   219: checkcast 144	android/net/wifi/WifiManager
    //   222: invokevirtual 148	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   225: astore_1
    //   226: aload_1
    //   227: invokevirtual 154	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   230: ifnull +25 -> 255
    //   233: aload_1
    //   234: invokevirtual 157	android/net/wifi/WifiInfo:getRssi	()I
    //   237: istore_0
    //   238: getstatic 162	android/os/Build$VERSION:SDK_INT	I
    //   241: bipush 14
    //   243: if_icmplt +463 -> 706
    //   246: iload_0
    //   247: iconst_5
    //   248: invokestatic 166	android/net/wifi/WifiManager:calculateSignalLevel	(II)I
    //   251: pop
    //   252: goto +3 -> 255
    //   255: new 168	java/lang/StringBuilder
    //   258: dup
    //   259: ldc 170
    //   261: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   264: astore_3
    //   265: aload_3
    //   266: aload_1
    //   267: invokevirtual 174	android/net/wifi/WifiInfo:getSSID	()Ljava/lang/String;
    //   270: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload_3
    //   275: ldc 180
    //   277: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload_3
    //   282: aload_1
    //   283: invokevirtual 154	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   286: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload_3
    //   291: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: putstatic 105	com/tencent/token/q:a	Ljava/lang/String;
    //   297: aload_2
    //   298: getstatic 105	com/tencent/token/q:a	Ljava/lang/String;
    //   301: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   304: ifne +23 -> 327
    //   307: getstatic 92	com/tencent/token/q:k	Lcom/tencent/token/q$a;
    //   310: ifnull +17 -> 327
    //   313: getstatic 92	com/tencent/token/q:k	Lcom/tencent/token/q$a;
    //   316: getstatic 111	com/tencent/token/q:h	I
    //   319: getstatic 105	com/tencent/token/q:a	Ljava/lang/String;
    //   322: invokeinterface 126 3 0
    //   327: iconst_0
    //   328: putstatic 49	com/tencent/token/q:m	Z
    //   331: ldc 2
    //   333: monitorexit
    //   334: return
    //   335: aload_1
    //   336: invokevirtual 186	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   339: astore_3
    //   340: aload_3
    //   341: ifnonnull +59 -> 400
    //   344: ldc 13
    //   346: putstatic 105	com/tencent/token/q:a	Ljava/lang/String;
    //   349: iconst_0
    //   350: putstatic 111	com/tencent/token/q:h	I
    //   353: iconst_0
    //   354: putstatic 113	com/tencent/token/q:i	Z
    //   357: ldc 13
    //   359: putstatic 115	com/tencent/token/q:j	Ljava/lang/String;
    //   362: aload_2
    //   363: getstatic 105	com/tencent/token/q:a	Ljava/lang/String;
    //   366: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   369: ifne +23 -> 392
    //   372: getstatic 92	com/tencent/token/q:k	Lcom/tencent/token/q$a;
    //   375: ifnull +17 -> 392
    //   378: getstatic 92	com/tencent/token/q:k	Lcom/tencent/token/q$a;
    //   381: getstatic 111	com/tencent/token/q:h	I
    //   384: getstatic 105	com/tencent/token/q:a	Ljava/lang/String;
    //   387: invokeinterface 126 3 0
    //   392: iconst_0
    //   393: putstatic 49	com/tencent/token/q:m	Z
    //   396: ldc 2
    //   398: monitorexit
    //   399: return
    //   400: aload_3
    //   401: invokevirtual 189	java/lang/String:trim	()Ljava/lang/String;
    //   404: invokevirtual 192	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   407: putstatic 105	com/tencent/token/q:a	Ljava/lang/String;
    //   410: iload_0
    //   411: ifne +50 -> 461
    //   414: aload_1
    //   415: invokevirtual 195	android/net/NetworkInfo:getSubtype	()I
    //   418: istore_0
    //   419: iload_0
    //   420: iconst_1
    //   421: if_icmpeq +36 -> 457
    //   424: iload_0
    //   425: iconst_2
    //   426: if_icmpeq +31 -> 457
    //   429: iload_0
    //   430: iconst_4
    //   431: if_icmpne +6 -> 437
    //   434: goto +23 -> 457
    //   437: iload_0
    //   438: bipush 13
    //   440: if_icmpne +10 -> 450
    //   443: iconst_4
    //   444: putstatic 111	com/tencent/token/q:h	I
    //   447: goto +14 -> 461
    //   450: iconst_3
    //   451: putstatic 111	com/tencent/token/q:h	I
    //   454: goto +7 -> 461
    //   457: iconst_2
    //   458: putstatic 111	com/tencent/token/q:h	I
    //   461: getstatic 105	com/tencent/token/q:a	Ljava/lang/String;
    //   464: getstatic 197	com/tencent/token/q:d	Ljava/lang/String;
    //   467: invokevirtual 201	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   470: ifeq +17 -> 487
    //   473: iconst_1
    //   474: putstatic 113	com/tencent/token/q:i	Z
    //   477: ldc 203
    //   479: astore_1
    //   480: aload_1
    //   481: putstatic 115	com/tencent/token/q:j	Ljava/lang/String;
    //   484: goto +79 -> 563
    //   487: getstatic 105	com/tencent/token/q:a	Ljava/lang/String;
    //   490: getstatic 205	com/tencent/token/q:c	Ljava/lang/String;
    //   493: invokevirtual 201	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   496: ifeq +13 -> 509
    //   499: iconst_1
    //   500: putstatic 113	com/tencent/token/q:i	Z
    //   503: ldc 203
    //   505: astore_1
    //   506: goto -26 -> 480
    //   509: getstatic 105	com/tencent/token/q:a	Ljava/lang/String;
    //   512: getstatic 207	com/tencent/token/q:e	Ljava/lang/String;
    //   515: invokevirtual 201	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   518: ifeq +13 -> 531
    //   521: iconst_1
    //   522: putstatic 113	com/tencent/token/q:i	Z
    //   525: ldc 203
    //   527: astore_1
    //   528: goto -48 -> 480
    //   531: getstatic 105	com/tencent/token/q:a	Ljava/lang/String;
    //   534: getstatic 209	com/tencent/token/q:f	Ljava/lang/String;
    //   537: invokevirtual 201	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   540: ifeq +13 -> 553
    //   543: iconst_1
    //   544: putstatic 113	com/tencent/token/q:i	Z
    //   547: ldc 211
    //   549: astore_1
    //   550: goto -70 -> 480
    //   553: iconst_0
    //   554: putstatic 113	com/tencent/token/q:i	Z
    //   557: ldc 13
    //   559: astore_1
    //   560: goto -80 -> 480
    //   563: aload_2
    //   564: getstatic 105	com/tencent/token/q:a	Ljava/lang/String;
    //   567: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   570: ifne +23 -> 593
    //   573: getstatic 92	com/tencent/token/q:k	Lcom/tencent/token/q$a;
    //   576: ifnull +17 -> 593
    //   579: getstatic 92	com/tencent/token/q:k	Lcom/tencent/token/q$a;
    //   582: getstatic 111	com/tencent/token/q:h	I
    //   585: getstatic 105	com/tencent/token/q:a	Ljava/lang/String;
    //   588: invokeinterface 126 3 0
    //   593: iconst_0
    //   594: putstatic 49	com/tencent/token/q:m	Z
    //   597: goto +63 -> 660
    //   600: astore_1
    //   601: goto +63 -> 664
    //   604: astore_1
    //   605: aload_1
    //   606: invokevirtual 214	java/lang/Throwable:printStackTrace	()V
    //   609: ldc 13
    //   611: putstatic 105	com/tencent/token/q:a	Ljava/lang/String;
    //   614: iconst_0
    //   615: putstatic 111	com/tencent/token/q:h	I
    //   618: iconst_0
    //   619: putstatic 113	com/tencent/token/q:i	Z
    //   622: ldc 13
    //   624: putstatic 115	com/tencent/token/q:j	Ljava/lang/String;
    //   627: aload_2
    //   628: getstatic 105	com/tencent/token/q:a	Ljava/lang/String;
    //   631: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   634: ifne -41 -> 593
    //   637: getstatic 92	com/tencent/token/q:k	Lcom/tencent/token/q$a;
    //   640: ifnull -47 -> 593
    //   643: getstatic 92	com/tencent/token/q:k	Lcom/tencent/token/q$a;
    //   646: getstatic 111	com/tencent/token/q:h	I
    //   649: getstatic 105	com/tencent/token/q:a	Ljava/lang/String;
    //   652: invokeinterface 126 3 0
    //   657: goto -64 -> 593
    //   660: ldc 2
    //   662: monitorexit
    //   663: return
    //   664: aload_2
    //   665: getstatic 105	com/tencent/token/q:a	Ljava/lang/String;
    //   668: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   671: ifne +23 -> 694
    //   674: getstatic 92	com/tencent/token/q:k	Lcom/tencent/token/q$a;
    //   677: ifnull +17 -> 694
    //   680: getstatic 92	com/tencent/token/q:k	Lcom/tencent/token/q$a;
    //   683: getstatic 111	com/tencent/token/q:h	I
    //   686: getstatic 105	com/tencent/token/q:a	Ljava/lang/String;
    //   689: invokeinterface 126 3 0
    //   694: iconst_0
    //   695: putstatic 49	com/tencent/token/q:m	Z
    //   698: aload_1
    //   699: athrow
    //   700: astore_1
    //   701: ldc 2
    //   703: monitorexit
    //   704: aload_1
    //   705: athrow
    //   706: iload_0
    //   707: bipush 156
    //   709: if_icmpgt +6 -> 715
    //   712: goto -457 -> 255
    //   715: goto -460 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   192	518	0	n	int
    //   36	524	1	localObject1	Object
    //   600	1	1	localObject2	Object
    //   604	95	1	localThrowable	java.lang.Throwable
    //   700	5	1	localObject3	Object
    //   24	641	2	str	String
    //   264	137	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   25	37	600	finally
    //   41	63	600	finally
    //   101	106	600	finally
    //   110	132	600	finally
    //   170	181	600	finally
    //   184	188	600	finally
    //   188	193	600	finally
    //   198	252	600	finally
    //   255	297	600	finally
    //   335	340	600	finally
    //   344	362	600	finally
    //   400	410	600	finally
    //   414	419	600	finally
    //   443	447	600	finally
    //   450	454	600	finally
    //   457	461	600	finally
    //   461	477	600	finally
    //   480	484	600	finally
    //   487	503	600	finally
    //   509	525	600	finally
    //   531	547	600	finally
    //   553	557	600	finally
    //   605	627	600	finally
    //   25	37	604	java/lang/Throwable
    //   41	63	604	java/lang/Throwable
    //   101	106	604	java/lang/Throwable
    //   110	132	604	java/lang/Throwable
    //   170	181	604	java/lang/Throwable
    //   184	188	604	java/lang/Throwable
    //   188	193	604	java/lang/Throwable
    //   198	252	604	java/lang/Throwable
    //   255	297	604	java/lang/Throwable
    //   335	340	604	java/lang/Throwable
    //   344	362	604	java/lang/Throwable
    //   400	410	604	java/lang/Throwable
    //   414	419	604	java/lang/Throwable
    //   443	447	604	java/lang/Throwable
    //   450	454	604	java/lang/Throwable
    //   457	461	604	java/lang/Throwable
    //   461	477	604	java/lang/Throwable
    //   480	484	604	java/lang/Throwable
    //   487	503	604	java/lang/Throwable
    //   509	525	604	java/lang/Throwable
    //   531	547	604	java/lang/Throwable
    //   553	557	604	java/lang/Throwable
    //   21	25	700	finally
    //   63	93	700	finally
    //   93	100	700	finally
    //   132	162	700	finally
    //   162	169	700	finally
    //   297	327	700	finally
    //   327	334	700	finally
    //   362	392	700	finally
    //   392	399	700	finally
    //   563	593	700	finally
    //   593	597	700	finally
    //   627	657	700	finally
    //   660	663	700	finally
    //   664	694	700	finally
    //   694	700	700	finally
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
    b.b("DownloaderApn", localStringBuilder.toString());
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
      return s.b();
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
      q.b = q.a(paramSignalStrength.getGsmSignalStrength() * 2 - 113);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.q
 * JD-Core Version:    0.7.0.1
 */