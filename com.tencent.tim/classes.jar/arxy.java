import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.open.business.cgireport.ReportManager.1;
import java.util.ArrayList;
import java.util.Random;

public class arxy
{
  public static final String TAG = arxy.class.getName();
  protected static arxy a;
  protected volatile ArrayList<arxz> DA = new ArrayList();
  public volatile ArrayList<arxz> Dz = new ArrayList();
  public arxx b = new arxx();
  protected Random h = new Random();
  protected long ib = 0L;
  public int mReportRetryCount = 3;
  public boolean mUploading = false;
  
  public static arxy a()
  {
    try
    {
      if (a == null) {
        a = new arxy();
      }
      arxy localarxy = a;
      return localarxy;
    }
    finally {}
  }
  
  public void a(String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, String paramString2, String paramString3)
  {
    b(paramString1, paramLong1, paramLong2, paramLong3, paramInt, paramLong4, paramString2, paramString3, false);
  }
  
  protected boolean aHf()
  {
    long l2 = arxs.a(aroi.a().getContext(), null).getLong("Common_CGIReportTimeinterval");
    arwt.d("OpenConfig_agent", "config 5:Common_CGIReportTimeinterval     config_value:" + l2);
    long l1 = l2;
    if (l2 == 0L) {
      l1 = 1200L;
    }
    arwt.d("OpenConfig_agent", "config 5:Common_CGIReportTimeinterval     result_value:" + l1);
    l2 = System.currentTimeMillis() / 1000L;
    if ((this.ib == 0L) || (l1 + this.ib <= l2))
    {
      this.ib = l2;
      arwt.i("cgi_report_debug", "ReportManager availableForTime = ture");
      return true;
    }
    arwt.i("cgi_report_debug", "ReportManager availableForTime = false");
    return false;
  }
  
  /* Error */
  protected Bundle b(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 126
    //   4: ldc 138
    //   6: invokestatic 131	arwt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 54	arxy:b	Larxx;
    //   14: aload_1
    //   15: invokevirtual 142	arxx:ai	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   18: putfield 47	arxy:Dz	Ljava/util/ArrayList;
    //   21: aload_0
    //   22: getfield 54	arxy:b	Larxx;
    //   25: aload_1
    //   26: invokevirtual 146	arxx:sv	(Ljava/lang/String;)Z
    //   29: pop
    //   30: aload_0
    //   31: getfield 47	arxy:Dz	Ljava/util/ArrayList;
    //   34: invokevirtual 150	java/util/ArrayList:size	()I
    //   37: ifgt +16 -> 53
    //   40: ldc 126
    //   42: ldc 152
    //   44: invokestatic 131	arwt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aconst_null
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: areturn
    //   53: aload_0
    //   54: aload_0
    //   55: getfield 54	arxy:b	Larxx;
    //   58: aload_1
    //   59: invokevirtual 155	arxx:aj	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   62: putfield 49	arxy:DA	Ljava/util/ArrayList;
    //   65: aload_0
    //   66: getfield 54	arxy:b	Larxx;
    //   69: aload_1
    //   70: invokevirtual 158	arxx:su	(Ljava/lang/String;)Z
    //   73: pop
    //   74: new 160	android/os/Bundle
    //   77: dup
    //   78: invokespecial 161	android/os/Bundle:<init>	()V
    //   81: astore 5
    //   83: aload 5
    //   85: ldc 163
    //   87: aload_1
    //   88: invokevirtual 166	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload 5
    //   93: ldc 168
    //   95: getstatic 173	arxw:cDd	Ljava/lang/String;
    //   98: invokevirtual 166	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload 5
    //   103: ldc 175
    //   105: getstatic 180	android/os/Build:DEVICE	Ljava/lang/String;
    //   108: invokevirtual 166	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload 5
    //   113: ldc 182
    //   115: getstatic 185	arxw:cDe	Ljava/lang/String;
    //   118: invokevirtual 166	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: aload 5
    //   123: ldc 187
    //   125: ldc 189
    //   127: invokevirtual 166	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: iconst_0
    //   131: istore_3
    //   132: iload_3
    //   133: aload_0
    //   134: getfield 47	arxy:Dz	Ljava/util/ArrayList;
    //   137: invokevirtual 150	java/util/ArrayList:size	()I
    //   140: if_icmpge +418 -> 558
    //   143: aload 5
    //   145: new 93	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   152: iload_3
    //   153: invokevirtual 192	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: ldc 194
    //   158: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: aload_0
    //   165: getfield 47	arxy:Dz	Ljava/util/ArrayList;
    //   168: iload_3
    //   169: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   172: checkcast 200	arxz
    //   175: getfield 203	arxz:cDf	Ljava/lang/String;
    //   178: invokevirtual 166	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: aload 5
    //   183: new 93	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   190: iload_3
    //   191: invokevirtual 192	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: ldc 205
    //   196: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: aload_0
    //   203: getfield 47	arxy:Dz	Ljava/util/ArrayList;
    //   206: iload_3
    //   207: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   210: checkcast 200	arxz
    //   213: getfield 208	arxz:cDg	Ljava/lang/String;
    //   216: invokevirtual 166	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload 5
    //   221: new 93	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   228: iload_3
    //   229: invokevirtual 192	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   232: ldc 210
    //   234: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: aload_0
    //   241: getfield 47	arxy:Dz	Ljava/util/ArrayList;
    //   244: iload_3
    //   245: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   248: checkcast 200	arxz
    //   251: getfield 213	arxz:cDh	Ljava/lang/String;
    //   254: invokevirtual 166	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: aload 5
    //   259: new 93	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   266: iload_3
    //   267: invokevirtual 192	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   270: ldc 215
    //   272: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: aload_0
    //   279: getfield 47	arxy:Dz	Ljava/util/ArrayList;
    //   282: iload_3
    //   283: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   286: checkcast 200	arxz
    //   289: getfield 218	arxz:cDi	Ljava/lang/String;
    //   292: invokevirtual 166	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: aload 5
    //   297: new 93	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   304: iload_3
    //   305: invokevirtual 192	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   308: ldc 220
    //   310: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: aload_0
    //   317: getfield 47	arxy:Dz	Ljava/util/ArrayList;
    //   320: iload_3
    //   321: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   324: checkcast 200	arxz
    //   327: getfield 223	arxz:cDj	Ljava/lang/String;
    //   330: invokevirtual 166	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   333: aload 5
    //   335: new 93	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   342: iload_3
    //   343: invokevirtual 192	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   346: ldc 225
    //   348: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: aload_0
    //   355: getfield 47	arxy:Dz	Ljava/util/ArrayList;
    //   358: iload_3
    //   359: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   362: checkcast 200	arxz
    //   365: getfield 228	arxz:cDk	Ljava/lang/String;
    //   368: invokevirtual 166	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   371: aload 5
    //   373: new 93	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   380: iload_3
    //   381: invokevirtual 192	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   384: ldc 230
    //   386: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: aload_0
    //   393: getfield 47	arxy:Dz	Ljava/util/ArrayList;
    //   396: iload_3
    //   397: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   400: checkcast 200	arxz
    //   403: getfield 233	arxz:cDl	Ljava/lang/String;
    //   406: invokevirtual 166	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   409: aload 5
    //   411: new 93	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   418: iload_3
    //   419: invokevirtual 192	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   422: ldc 235
    //   424: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: aload_0
    //   431: getfield 47	arxy:Dz	Ljava/util/ArrayList;
    //   434: iload_3
    //   435: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   438: checkcast 200	arxz
    //   441: getfield 238	arxz:mDetail	Ljava/lang/String;
    //   444: invokevirtual 166	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   447: aload 5
    //   449: new 93	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   456: iload_3
    //   457: invokevirtual 192	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   460: ldc 240
    //   462: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: aload_0
    //   469: getfield 47	arxy:Dz	Ljava/util/ArrayList;
    //   472: iload_3
    //   473: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   476: checkcast 200	arxz
    //   479: getfield 243	arxz:mUin	Ljava/lang/String;
    //   482: invokevirtual 166	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   485: new 93	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   492: iload_2
    //   493: invokestatic 249	arxr:A	(Z)Ljava/lang/String;
    //   496: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: ldc 251
    //   501: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: aload_0
    //   505: getfield 47	arxy:Dz	Ljava/util/ArrayList;
    //   508: iload_3
    //   509: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   512: checkcast 200	arxz
    //   515: getfield 254	arxz:mDeviceInfo	Ljava/lang/String;
    //   518: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: astore_1
    //   525: aload 5
    //   527: new 93	java/lang/StringBuilder
    //   530: dup
    //   531: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   534: iload_3
    //   535: invokevirtual 192	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   538: ldc_w 256
    //   541: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   547: aload_1
    //   548: invokevirtual 166	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   551: iload_3
    //   552: iconst_1
    //   553: iadd
    //   554: istore_3
    //   555: goto -423 -> 132
    //   558: aload_0
    //   559: getfield 47	arxy:Dz	Ljava/util/ArrayList;
    //   562: invokevirtual 150	java/util/ArrayList:size	()I
    //   565: istore_3
    //   566: iload_3
    //   567: aload_0
    //   568: getfield 49	arxy:DA	Ljava/util/ArrayList;
    //   571: invokevirtual 150	java/util/ArrayList:size	()I
    //   574: aload_0
    //   575: getfield 47	arxy:Dz	Ljava/util/ArrayList;
    //   578: invokevirtual 150	java/util/ArrayList:size	()I
    //   581: iadd
    //   582: if_icmpge +455 -> 1037
    //   585: iload_3
    //   586: aload_0
    //   587: getfield 47	arxy:Dz	Ljava/util/ArrayList;
    //   590: invokevirtual 150	java/util/ArrayList:size	()I
    //   593: isub
    //   594: istore 4
    //   596: aload 5
    //   598: new 93	java/lang/StringBuilder
    //   601: dup
    //   602: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   605: iload_3
    //   606: invokevirtual 192	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   609: ldc 194
    //   611: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   617: aload_0
    //   618: getfield 49	arxy:DA	Ljava/util/ArrayList;
    //   621: iload 4
    //   623: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   626: checkcast 200	arxz
    //   629: getfield 203	arxz:cDf	Ljava/lang/String;
    //   632: invokevirtual 166	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   635: aload 5
    //   637: new 93	java/lang/StringBuilder
    //   640: dup
    //   641: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   644: iload_3
    //   645: invokevirtual 192	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   648: ldc 205
    //   650: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   656: aload_0
    //   657: getfield 49	arxy:DA	Ljava/util/ArrayList;
    //   660: iload 4
    //   662: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   665: checkcast 200	arxz
    //   668: getfield 208	arxz:cDg	Ljava/lang/String;
    //   671: invokevirtual 166	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   674: aload 5
    //   676: new 93	java/lang/StringBuilder
    //   679: dup
    //   680: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   683: iload_3
    //   684: invokevirtual 192	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   687: ldc 210
    //   689: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   695: aload_0
    //   696: getfield 49	arxy:DA	Ljava/util/ArrayList;
    //   699: iload 4
    //   701: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   704: checkcast 200	arxz
    //   707: getfield 213	arxz:cDh	Ljava/lang/String;
    //   710: invokevirtual 166	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   713: aload 5
    //   715: new 93	java/lang/StringBuilder
    //   718: dup
    //   719: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   722: iload_3
    //   723: invokevirtual 192	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   726: ldc 215
    //   728: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   734: aload_0
    //   735: getfield 49	arxy:DA	Ljava/util/ArrayList;
    //   738: iload 4
    //   740: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   743: checkcast 200	arxz
    //   746: getfield 218	arxz:cDi	Ljava/lang/String;
    //   749: invokevirtual 166	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   752: aload 5
    //   754: new 93	java/lang/StringBuilder
    //   757: dup
    //   758: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   761: iload_3
    //   762: invokevirtual 192	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   765: ldc 220
    //   767: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   773: aload_0
    //   774: getfield 49	arxy:DA	Ljava/util/ArrayList;
    //   777: iload 4
    //   779: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   782: checkcast 200	arxz
    //   785: getfield 223	arxz:cDj	Ljava/lang/String;
    //   788: invokevirtual 166	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   791: aload 5
    //   793: new 93	java/lang/StringBuilder
    //   796: dup
    //   797: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   800: iload_3
    //   801: invokevirtual 192	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   804: ldc 225
    //   806: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   812: aload_0
    //   813: getfield 49	arxy:DA	Ljava/util/ArrayList;
    //   816: iload 4
    //   818: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   821: checkcast 200	arxz
    //   824: getfield 228	arxz:cDk	Ljava/lang/String;
    //   827: invokevirtual 166	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   830: aload 5
    //   832: new 93	java/lang/StringBuilder
    //   835: dup
    //   836: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   839: iload_3
    //   840: invokevirtual 192	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   843: ldc 230
    //   845: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   851: aload_0
    //   852: getfield 49	arxy:DA	Ljava/util/ArrayList;
    //   855: iload 4
    //   857: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   860: checkcast 200	arxz
    //   863: getfield 233	arxz:cDl	Ljava/lang/String;
    //   866: invokevirtual 166	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   869: aload 5
    //   871: new 93	java/lang/StringBuilder
    //   874: dup
    //   875: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   878: iload_3
    //   879: invokevirtual 192	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   882: ldc 235
    //   884: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   890: aload_0
    //   891: getfield 49	arxy:DA	Ljava/util/ArrayList;
    //   894: iload 4
    //   896: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   899: checkcast 200	arxz
    //   902: getfield 238	arxz:mDetail	Ljava/lang/String;
    //   905: invokevirtual 166	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   908: aload 5
    //   910: new 93	java/lang/StringBuilder
    //   913: dup
    //   914: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   917: iload_3
    //   918: invokevirtual 192	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   921: ldc 240
    //   923: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   926: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   929: aload_0
    //   930: getfield 49	arxy:DA	Ljava/util/ArrayList;
    //   933: iload 4
    //   935: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   938: checkcast 200	arxz
    //   941: getfield 243	arxz:mUin	Ljava/lang/String;
    //   944: invokevirtual 166	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   947: new 93	java/lang/StringBuilder
    //   950: dup
    //   951: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   954: iload_2
    //   955: invokestatic 249	arxr:A	(Z)Ljava/lang/String;
    //   958: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: ldc 251
    //   963: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: aload_0
    //   967: getfield 47	arxy:Dz	Ljava/util/ArrayList;
    //   970: iload 4
    //   972: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   975: checkcast 200	arxz
    //   978: getfield 254	arxz:mDeviceInfo	Ljava/lang/String;
    //   981: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   987: astore_1
    //   988: aload 5
    //   990: new 93	java/lang/StringBuilder
    //   993: dup
    //   994: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   997: iload_3
    //   998: invokevirtual 192	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1001: ldc_w 256
    //   1004: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1010: aload_1
    //   1011: invokevirtual 166	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1014: iload_3
    //   1015: iconst_1
    //   1016: iadd
    //   1017: istore_3
    //   1018: goto -452 -> 566
    //   1021: astore_1
    //   1022: getstatic 32	arxy:TAG	Ljava/lang/String;
    //   1025: ldc_w 258
    //   1028: aload_1
    //   1029: invokestatic 261	arwt:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1032: aconst_null
    //   1033: astore_1
    //   1034: goto -985 -> 49
    //   1037: ldc 126
    //   1039: ldc_w 263
    //   1042: invokestatic 131	arwt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1045: aload 5
    //   1047: astore_1
    //   1048: goto -999 -> 49
    //   1051: astore_1
    //   1052: aload_0
    //   1053: monitorexit
    //   1054: aload_1
    //   1055: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1056	0	this	arxy
    //   0	1056	1	paramString	String
    //   0	1056	2	paramBoolean	boolean
    //   131	887	3	i	int
    //   594	377	4	j	int
    //   81	965	5	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   83	130	1021	java/lang/Exception
    //   132	551	1021	java/lang/Exception
    //   558	566	1021	java/lang/Exception
    //   566	1014	1021	java/lang/Exception
    //   2	47	1051	finally
    //   53	83	1051	finally
    //   83	130	1051	finally
    //   132	551	1051	finally
    //   558	566	1051	finally
    //   566	1014	1051	finally
    //   1022	1032	1051	finally
    //   1037	1045	1051	finally
  }
  
  protected void b(String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, String paramString2, String paramString3)
  {
    paramLong1 = SystemClock.elapsedRealtime() - paramLong1;
    arwt.i("cgi_report_debug", "ReportManager updateDB url=" + paramString1 + ",resultCode=" + paramInt + ",timeCost=" + paramLong1 + ",reqSize=" + paramLong2 + ",rspSize=" + paramLong3);
    int i = 100 / kP(paramInt);
    if (i <= 0) {
      i = 1;
    }
    for (;;)
    {
      String str = getAPN();
      this.b.a(str, i + "", paramString1, paramInt + "", paramLong1 + "", paramLong2 + "", paramLong3 + "", paramLong4 + "", paramString3, paramString2);
      return;
      if (i > 100) {
        i = 100;
      }
    }
  }
  
  public void b(String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (mO(paramInt))
    {
      b(paramString1, paramLong1, paramLong2, paramLong3, paramInt, paramLong4, paramString2, paramString3);
      if (!this.mUploading) {
        break label35;
      }
    }
    label35:
    while ((!aHf()) && (!sw(paramString2))) {
      return;
    }
    dB(paramString2, paramBoolean);
  }
  
  protected void dB(String paramString, boolean paramBoolean)
  {
    arwt.i("cgi_report_debug", "ReportManager doUpload start");
    paramString = b(paramString, paramBoolean);
    if (paramString == null) {
      return;
    }
    this.mUploading = true;
    f("https://wspeed.qq.com/w.cgi", "POST", paramString);
  }
  
  protected void f(String paramString1, String paramString2, Bundle paramBundle)
  {
    ThreadManager.executeOnNetWorkThread(new ReportManager.1(this, paramString1, paramBundle));
  }
  
  protected String getAPN()
  {
    return AppNetConnInfo.getCurrentAPN();
  }
  
  protected int kP(int paramInt)
  {
    if (paramInt == 0)
    {
      i = arxs.a(aroi.a().getContext(), null).getInt("Common_CGIReportFrequencySuccess");
      arwt.d("OpenConfig_agent", "config 4:Common_CGIReportFrequencySuccess     config_value:" + i);
      paramInt = i;
      if (i == 0) {
        paramInt = 10;
      }
      arwt.d("OpenConfig_agent", "config 4:Common_CGIReportFrequencySuccess     result_value:" + paramInt);
      return paramInt;
    }
    int i = arxs.a(aroi.a().getContext(), null).getInt("Common_CGIReportFrequencyFailed");
    arwt.d("OpenConfig_agent", "config 4:Common_CGIReportFrequencyFailed     config_value:" + i);
    paramInt = i;
    if (i == 0) {
      paramInt = 100;
    }
    arwt.d("OpenConfig_agent", "config 4:Common_CGIReportFrequencyFailed     result_value:" + paramInt);
    return paramInt;
  }
  
  protected boolean mO(int paramInt)
  {
    paramInt = kP(paramInt);
    if (this.h.nextInt(100) < paramInt)
    {
      arwt.i("cgi_report_debug", "ReportManager availableForFrequency = ture");
      return true;
    }
    arwt.i("cgi_report_debug", "ReportManager availableForFrequency = false");
    return false;
  }
  
  protected boolean sw(String paramString)
  {
    int j = arxs.a(aroi.a().getContext(), null).getInt("Common_CGIReportMaxcount");
    arwt.d("OpenConfig_agent", "config 6:Common_CGIReportMaxcount     config_value:" + j);
    int i = j;
    if (j == 0) {
      i = 20;
    }
    arwt.d("OpenConfig_agent", "config 6:Common_CGIReportMaxcount     result_value:" + i);
    if (this.b.fC(paramString) >= i)
    {
      arwt.i("cgi_report_debug", "ReportManager availableForCount = ture");
      return true;
    }
    arwt.i("cgi_report_debug", "ReportManager availableForCount = false");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arxy
 * JD-Core Version:    0.7.0.1
 */