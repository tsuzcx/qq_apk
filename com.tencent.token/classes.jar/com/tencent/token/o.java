package com.tencent.token;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.halley.common.c;
import com.tencent.halley.common.h;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

public class o
{
  public static String a = "";
  public static int b;
  private static String c = "cmwap";
  private static String d = "3gwap";
  private static String e = "uniwap";
  private static String f = "ctwap";
  private static volatile boolean g = true;
  private static int h = 0;
  private static boolean i = false;
  private static String j = "";
  private static p k;
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
    h.a().registerReceiver(l, (IntentFilter)localObject);
    localObject = (TelephonyManager)h.a().getSystemService("phone");
    if (localObject != null) {
      ((TelephonyManager)localObject).listen(new q(), 257);
    }
  }
  
  public static void a(p paramp)
  {
    k = paramp;
  }
  
  /* Error */
  public static void b()
  {
    // Byte code:
    //   0: ldc 110
    //   2: ldc 112
    //   4: invokestatic 117	com/tencent/halley/common/c:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: getstatic 61	com/tencent/token/o:m	Z
    //   10: ifeq +4 -> 14
    //   13: return
    //   14: iconst_1
    //   15: putstatic 61	com/tencent/token/o:m	Z
    //   18: ldc 2
    //   20: monitorenter
    //   21: getstatic 46	com/tencent/token/o:a	Ljava/lang/String;
    //   24: astore_1
    //   25: invokestatic 82	com/tencent/halley/common/h:a	()Landroid/content/Context;
    //   28: ldc 119
    //   30: invokevirtual 94	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   33: checkcast 121	android/net/ConnectivityManager
    //   36: astore_2
    //   37: aload_2
    //   38: ifnonnull +69 -> 107
    //   41: ldc 44
    //   43: putstatic 46	com/tencent/token/o:a	Ljava/lang/String;
    //   46: iconst_0
    //   47: putstatic 48	com/tencent/token/o:h	I
    //   50: iconst_0
    //   51: putstatic 50	com/tencent/token/o:i	Z
    //   54: ldc 44
    //   56: putstatic 52	com/tencent/token/o:j	Ljava/lang/String;
    //   59: iconst_0
    //   60: putstatic 42	com/tencent/token/o:g	Z
    //   63: aload_1
    //   64: getstatic 46	com/tencent/token/o:a	Ljava/lang/String;
    //   67: invokevirtual 127	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifne +23 -> 93
    //   73: getstatic 106	com/tencent/token/o:k	Lcom/tencent/token/p;
    //   76: ifnull +17 -> 93
    //   79: getstatic 106	com/tencent/token/o:k	Lcom/tencent/token/p;
    //   82: getstatic 48	com/tencent/token/o:h	I
    //   85: getstatic 46	com/tencent/token/o:a	Ljava/lang/String;
    //   88: invokeinterface 132 3 0
    //   93: iconst_0
    //   94: putstatic 61	com/tencent/token/o:m	Z
    //   97: ldc 2
    //   99: monitorexit
    //   100: return
    //   101: astore_1
    //   102: ldc 2
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    //   107: aload_2
    //   108: invokevirtual 136	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   111: astore_2
    //   112: aload_2
    //   113: ifnonnull +63 -> 176
    //   116: ldc 44
    //   118: putstatic 46	com/tencent/token/o:a	Ljava/lang/String;
    //   121: iconst_0
    //   122: putstatic 48	com/tencent/token/o:h	I
    //   125: iconst_0
    //   126: putstatic 50	com/tencent/token/o:i	Z
    //   129: ldc 44
    //   131: putstatic 52	com/tencent/token/o:j	Ljava/lang/String;
    //   134: iconst_0
    //   135: putstatic 42	com/tencent/token/o:g	Z
    //   138: aload_1
    //   139: getstatic 46	com/tencent/token/o:a	Ljava/lang/String;
    //   142: invokevirtual 127	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   145: ifne +23 -> 168
    //   148: getstatic 106	com/tencent/token/o:k	Lcom/tencent/token/p;
    //   151: ifnull +17 -> 168
    //   154: getstatic 106	com/tencent/token/o:k	Lcom/tencent/token/p;
    //   157: getstatic 48	com/tencent/token/o:h	I
    //   160: getstatic 46	com/tencent/token/o:a	Ljava/lang/String;
    //   163: invokeinterface 132 3 0
    //   168: iconst_0
    //   169: putstatic 61	com/tencent/token/o:m	Z
    //   172: ldc 2
    //   174: monitorexit
    //   175: return
    //   176: aload_2
    //   177: invokevirtual 142	android/net/NetworkInfo:isConnected	()Z
    //   180: ifeq +143 -> 323
    //   183: iconst_1
    //   184: putstatic 42	com/tencent/token/o:g	Z
    //   187: aload_2
    //   188: invokevirtual 146	android/net/NetworkInfo:getType	()I
    //   191: istore_0
    //   192: iload_0
    //   193: iconst_1
    //   194: if_icmpne +225 -> 419
    //   197: iconst_1
    //   198: putstatic 48	com/tencent/token/o:h	I
    //   201: iconst_0
    //   202: putstatic 50	com/tencent/token/o:i	Z
    //   205: ldc 44
    //   207: putstatic 52	com/tencent/token/o:j	Ljava/lang/String;
    //   210: invokestatic 82	com/tencent/halley/common/h:a	()Landroid/content/Context;
    //   213: ldc 148
    //   215: invokevirtual 94	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   218: checkcast 150	android/net/wifi/WifiManager
    //   221: invokevirtual 154	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   224: astore_2
    //   225: aload_2
    //   226: invokevirtual 160	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   229: ifnull +22 -> 251
    //   232: aload_2
    //   233: invokevirtual 163	android/net/wifi/WifiInfo:getRssi	()I
    //   236: istore_0
    //   237: getstatic 168	android/os/Build$VERSION:SDK_INT	I
    //   240: bipush 14
    //   242: if_icmplt +149 -> 391
    //   245: iload_0
    //   246: iconst_5
    //   247: invokestatic 172	android/net/wifi/WifiManager:calculateSignalLevel	(II)I
    //   250: pop
    //   251: new 174	java/lang/StringBuilder
    //   254: dup
    //   255: ldc 176
    //   257: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   260: aload_2
    //   261: invokevirtual 180	android/net/wifi/WifiInfo:getSSID	()Ljava/lang/String;
    //   264: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc 186
    //   269: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload_2
    //   273: invokevirtual 160	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   276: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: putstatic 46	com/tencent/token/o:a	Ljava/lang/String;
    //   285: aload_1
    //   286: getstatic 46	com/tencent/token/o:a	Ljava/lang/String;
    //   289: invokevirtual 127	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   292: ifne +23 -> 315
    //   295: getstatic 106	com/tencent/token/o:k	Lcom/tencent/token/p;
    //   298: ifnull +17 -> 315
    //   301: getstatic 106	com/tencent/token/o:k	Lcom/tencent/token/p;
    //   304: getstatic 48	com/tencent/token/o:h	I
    //   307: getstatic 46	com/tencent/token/o:a	Ljava/lang/String;
    //   310: invokeinterface 132 3 0
    //   315: iconst_0
    //   316: putstatic 61	com/tencent/token/o:m	Z
    //   319: ldc 2
    //   321: monitorexit
    //   322: return
    //   323: iconst_0
    //   324: putstatic 42	com/tencent/token/o:g	Z
    //   327: goto -140 -> 187
    //   330: astore_2
    //   331: aload_2
    //   332: invokevirtual 192	java/lang/Throwable:printStackTrace	()V
    //   335: ldc 44
    //   337: putstatic 46	com/tencent/token/o:a	Ljava/lang/String;
    //   340: iconst_0
    //   341: putstatic 48	com/tencent/token/o:h	I
    //   344: iconst_0
    //   345: putstatic 50	com/tencent/token/o:i	Z
    //   348: ldc 44
    //   350: putstatic 52	com/tencent/token/o:j	Ljava/lang/String;
    //   353: aload_1
    //   354: getstatic 46	com/tencent/token/o:a	Ljava/lang/String;
    //   357: invokevirtual 127	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   360: ifne +23 -> 383
    //   363: getstatic 106	com/tencent/token/o:k	Lcom/tencent/token/p;
    //   366: ifnull +17 -> 383
    //   369: getstatic 106	com/tencent/token/o:k	Lcom/tencent/token/p;
    //   372: getstatic 48	com/tencent/token/o:h	I
    //   375: getstatic 46	com/tencent/token/o:a	Ljava/lang/String;
    //   378: invokeinterface 132 3 0
    //   383: iconst_0
    //   384: putstatic 61	com/tencent/token/o:m	Z
    //   387: ldc 2
    //   389: monitorexit
    //   390: return
    //   391: iload_0
    //   392: bipush 156
    //   394: if_icmple -143 -> 251
    //   397: iload_0
    //   398: bipush 201
    //   400: if_icmpge -149 -> 251
    //   403: iload_0
    //   404: bipush 100
    //   406: iadd
    //   407: i2f
    //   408: ldc 193
    //   410: fmul
    //   411: ldc 194
    //   413: fdiv
    //   414: f2i
    //   415: istore_0
    //   416: goto -165 -> 251
    //   419: aload_2
    //   420: invokevirtual 197	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   423: astore_3
    //   424: aload_3
    //   425: ifnonnull +59 -> 484
    //   428: ldc 44
    //   430: putstatic 46	com/tencent/token/o:a	Ljava/lang/String;
    //   433: iconst_0
    //   434: putstatic 48	com/tencent/token/o:h	I
    //   437: iconst_0
    //   438: putstatic 50	com/tencent/token/o:i	Z
    //   441: ldc 44
    //   443: putstatic 52	com/tencent/token/o:j	Ljava/lang/String;
    //   446: aload_1
    //   447: getstatic 46	com/tencent/token/o:a	Ljava/lang/String;
    //   450: invokevirtual 127	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   453: ifne +23 -> 476
    //   456: getstatic 106	com/tencent/token/o:k	Lcom/tencent/token/p;
    //   459: ifnull +17 -> 476
    //   462: getstatic 106	com/tencent/token/o:k	Lcom/tencent/token/p;
    //   465: getstatic 48	com/tencent/token/o:h	I
    //   468: getstatic 46	com/tencent/token/o:a	Ljava/lang/String;
    //   471: invokeinterface 132 3 0
    //   476: iconst_0
    //   477: putstatic 61	com/tencent/token/o:m	Z
    //   480: ldc 2
    //   482: monitorexit
    //   483: return
    //   484: aload_3
    //   485: invokevirtual 200	java/lang/String:trim	()Ljava/lang/String;
    //   488: invokevirtual 203	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   491: putstatic 46	com/tencent/token/o:a	Ljava/lang/String;
    //   494: iload_0
    //   495: ifne +27 -> 522
    //   498: aload_2
    //   499: invokevirtual 206	android/net/NetworkInfo:getSubtype	()I
    //   502: istore_0
    //   503: iload_0
    //   504: iconst_1
    //   505: if_icmpeq +13 -> 518
    //   508: iload_0
    //   509: iconst_2
    //   510: if_icmpeq +8 -> 518
    //   513: iload_0
    //   514: iconst_4
    //   515: if_icmpne +65 -> 580
    //   518: iconst_2
    //   519: putstatic 48	com/tencent/token/o:h	I
    //   522: getstatic 46	com/tencent/token/o:a	Ljava/lang/String;
    //   525: getstatic 32	com/tencent/token/o:d	Ljava/lang/String;
    //   528: invokevirtual 210	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   531: ifeq +106 -> 637
    //   534: iconst_1
    //   535: putstatic 50	com/tencent/token/o:i	Z
    //   538: ldc 212
    //   540: putstatic 52	com/tencent/token/o:j	Ljava/lang/String;
    //   543: aload_1
    //   544: getstatic 46	com/tencent/token/o:a	Ljava/lang/String;
    //   547: invokevirtual 127	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   550: ifne +23 -> 573
    //   553: getstatic 106	com/tencent/token/o:k	Lcom/tencent/token/p;
    //   556: ifnull +17 -> 573
    //   559: getstatic 106	com/tencent/token/o:k	Lcom/tencent/token/p;
    //   562: getstatic 48	com/tencent/token/o:h	I
    //   565: getstatic 46	com/tencent/token/o:a	Ljava/lang/String;
    //   568: invokeinterface 132 3 0
    //   573: iconst_0
    //   574: putstatic 61	com/tencent/token/o:m	Z
    //   577: goto -190 -> 387
    //   580: iload_0
    //   581: bipush 13
    //   583: if_icmpne +47 -> 630
    //   586: iconst_4
    //   587: putstatic 48	com/tencent/token/o:h	I
    //   590: goto -68 -> 522
    //   593: astore_2
    //   594: aload_1
    //   595: getstatic 46	com/tencent/token/o:a	Ljava/lang/String;
    //   598: invokevirtual 127	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   601: ifne +23 -> 624
    //   604: getstatic 106	com/tencent/token/o:k	Lcom/tencent/token/p;
    //   607: ifnull +17 -> 624
    //   610: getstatic 106	com/tencent/token/o:k	Lcom/tencent/token/p;
    //   613: getstatic 48	com/tencent/token/o:h	I
    //   616: getstatic 46	com/tencent/token/o:a	Ljava/lang/String;
    //   619: invokeinterface 132 3 0
    //   624: iconst_0
    //   625: putstatic 61	com/tencent/token/o:m	Z
    //   628: aload_2
    //   629: athrow
    //   630: iconst_3
    //   631: putstatic 48	com/tencent/token/o:h	I
    //   634: goto -112 -> 522
    //   637: getstatic 46	com/tencent/token/o:a	Ljava/lang/String;
    //   640: getstatic 28	com/tencent/token/o:c	Ljava/lang/String;
    //   643: invokevirtual 210	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   646: ifeq +15 -> 661
    //   649: iconst_1
    //   650: putstatic 50	com/tencent/token/o:i	Z
    //   653: ldc 212
    //   655: putstatic 52	com/tencent/token/o:j	Ljava/lang/String;
    //   658: goto -115 -> 543
    //   661: getstatic 46	com/tencent/token/o:a	Ljava/lang/String;
    //   664: getstatic 36	com/tencent/token/o:e	Ljava/lang/String;
    //   667: invokevirtual 210	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   670: ifeq +15 -> 685
    //   673: iconst_1
    //   674: putstatic 50	com/tencent/token/o:i	Z
    //   677: ldc 212
    //   679: putstatic 52	com/tencent/token/o:j	Ljava/lang/String;
    //   682: goto -139 -> 543
    //   685: getstatic 46	com/tencent/token/o:a	Ljava/lang/String;
    //   688: getstatic 40	com/tencent/token/o:f	Ljava/lang/String;
    //   691: invokevirtual 210	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   694: ifeq +15 -> 709
    //   697: iconst_1
    //   698: putstatic 50	com/tencent/token/o:i	Z
    //   701: ldc 214
    //   703: putstatic 52	com/tencent/token/o:j	Ljava/lang/String;
    //   706: goto -163 -> 543
    //   709: iconst_0
    //   710: putstatic 50	com/tencent/token/o:i	Z
    //   713: ldc 44
    //   715: putstatic 52	com/tencent/token/o:j	Ljava/lang/String;
    //   718: goto -175 -> 543
    // Local variable table:
    //   start	length	slot	name	signature
    //   191	393	0	n	int
    //   24	40	1	str1	String
    //   101	494	1	localObject1	Object
    //   36	237	2	localObject2	Object
    //   330	169	2	localThrowable	java.lang.Throwable
    //   593	36	2	localObject3	Object
    //   423	62	3	str2	String
    // Exception table:
    //   from	to	target	type
    //   21	25	101	finally
    //   63	93	101	finally
    //   93	100	101	finally
    //   138	168	101	finally
    //   168	175	101	finally
    //   285	315	101	finally
    //   315	322	101	finally
    //   353	383	101	finally
    //   383	387	101	finally
    //   387	390	101	finally
    //   446	476	101	finally
    //   476	483	101	finally
    //   543	573	101	finally
    //   573	577	101	finally
    //   594	624	101	finally
    //   624	630	101	finally
    //   25	37	330	java/lang/Throwable
    //   41	63	330	java/lang/Throwable
    //   107	112	330	java/lang/Throwable
    //   116	138	330	java/lang/Throwable
    //   176	187	330	java/lang/Throwable
    //   187	192	330	java/lang/Throwable
    //   197	251	330	java/lang/Throwable
    //   251	285	330	java/lang/Throwable
    //   323	327	330	java/lang/Throwable
    //   419	424	330	java/lang/Throwable
    //   428	446	330	java/lang/Throwable
    //   484	494	330	java/lang/Throwable
    //   498	503	330	java/lang/Throwable
    //   518	522	330	java/lang/Throwable
    //   522	543	330	java/lang/Throwable
    //   586	590	330	java/lang/Throwable
    //   630	634	330	java/lang/Throwable
    //   637	658	330	java/lang/Throwable
    //   661	682	330	java/lang/Throwable
    //   685	706	330	java/lang/Throwable
    //   709	718	330	java/lang/Throwable
    //   25	37	593	finally
    //   41	63	593	finally
    //   107	112	593	finally
    //   116	138	593	finally
    //   176	187	593	finally
    //   187	192	593	finally
    //   197	251	593	finally
    //   251	285	593	finally
    //   323	327	593	finally
    //   331	353	593	finally
    //   419	424	593	finally
    //   428	446	593	finally
    //   484	494	593	finally
    //   498	503	593	finally
    //   518	522	593	finally
    //   522	543	593	finally
    //   586	590	593	finally
    //   630	634	593	finally
    //   637	658	593	finally
    //   661	682	593	finally
    //   685	706	593	finally
    //   709	718	593	finally
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
    c.b("DownloaderApn", "showApnInfo... Apn:" + a + ",sIsNetworkOk:" + g + ",sNetType:" + h + ",sIsProxy:" + i + ",sProxyAddress:" + j);
  }
  
  public static boolean h()
  {
    boolean bool = false;
    if ((h == 2) || (h == 3)) {}
    for (int n = 1;; n = 0)
    {
      if (n != 0) {
        bool = s.b();
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.o
 * JD-Core Version:    0.7.0.1
 */