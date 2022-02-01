import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.1;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.2;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.3;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.4;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.5;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class arbz
  extends araz.a
{
  public static volatile boolean aeo;
  public static long auH;
  public static long auI;
  public static long auJ;
  public static long auK;
  public static long avb;
  public static long avc;
  public static long avd;
  public static long ave;
  public static long avf;
  public static long avh;
  public static long avi;
  public static boolean cXK;
  public static volatile boolean cXW;
  public static volatile boolean cXX;
  public static boolean cYa = arca.t(1, false);
  public static boolean cYb = arca.t(2, false);
  public static boolean cYc = arca.t(4, false);
  public static int mSampleRate = 10;
  public static HashMap<String, arbz.a> pD = new HashMap();
  public long Gw;
  public List<String> Jl = new ArrayList();
  public arbz.b a;
  public long auA;
  public long auB;
  public long auC;
  public long auD;
  public long auE;
  public long auF;
  public long auG;
  public long auL;
  public long auM;
  public long auN;
  public long auO;
  public long auP;
  public long auQ;
  public long auR;
  public long auS;
  public long auT;
  public long auU;
  public long auV;
  public long auW;
  public long auX;
  public long auY;
  public long auZ;
  public long aup;
  public long auq;
  public long aur;
  public long aus;
  public long aut;
  public long auu;
  public long auv;
  public long auw;
  public long aux;
  public long auy;
  public long auz;
  public long ava;
  public long avj;
  public long avk;
  public long avl;
  public long avm;
  public boolean buI;
  public boolean cXJ;
  public boolean cXL;
  public boolean cXM;
  public boolean cXN;
  public boolean cXO;
  private boolean cXP;
  public boolean cXQ;
  public boolean cXR = true;
  public boolean cXS;
  public boolean cXT;
  boolean cXU;
  public boolean cXV;
  public boolean cXY;
  public boolean cXZ;
  public boolean cYd;
  public boolean cYe;
  public String czm;
  private String czn;
  private String czo;
  public String czp;
  public String czq;
  public String czr = "";
  private SparseArray<String> dO = new SparseArray(8);
  private int dnv;
  private int dnw;
  private int dnx;
  public boolean dw;
  public int eef = -1;
  public int eeg;
  public int eeh;
  public int flag;
  public Runnable hV;
  public long initTime;
  public boolean isDestroyed;
  public boolean isWebViewCache;
  public long mClickTime;
  public boolean mIsFirstOnPageStart = true;
  public String mNetworkType;
  public long mOnCreateMilliTimeStamp;
  public String mOpType;
  public boolean mPerfFirstLoadTag = true;
  public long mRedirect302Time = -1L;
  public long mStartLoadUrlMilliTimeStamp;
  private String mState = "state_activity_init";
  public long mTimeBeforeLoadUrl = -1L;
  public JSONObject mX5PerformanceJson;
  public long onCreateTime;
  private HashMap<String, Long> pC = new HashMap(7);
  public String pageId = "";
  Activity s;
  public boolean zh;
  
  public arbz()
  {
    this.jdField_a_of_type_Arbz$b = new arbz.b();
  }
  
  public static void U(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      skj localskj = skj.a();
      localskj.bzj();
      Bundle localBundle = i(paramString2);
      localBundle.putString("uin", paramString4);
      if (!TextUtils.isEmpty(paramString3)) {
        localBundle.putString("title", paramString3);
      }
      localskj.a(2, paramString2, paramString1, localBundle);
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("SwiftBrowserStatistics", 1, paramString1, new Object[0]);
    }
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +22 -> 29
    //   10: invokestatic 258	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13: ifeq +16 -> 29
    //   16: ldc 241
    //   18: iconst_2
    //   19: ldc_w 260
    //   22: invokestatic 264	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: ldc 2
    //   27: monitorexit
    //   28: return
    //   29: getstatic 160	arbz:pD	Ljava/util/HashMap;
    //   32: aload_1
    //   33: invokevirtual 268	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   36: ifne +18 -> 54
    //   39: getstatic 160	arbz:pD	Ljava/util/HashMap;
    //   42: aload_1
    //   43: new 6	arbz$a
    //   46: dup
    //   47: invokespecial 269	arbz$a:<init>	()V
    //   50: invokevirtual 273	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   53: pop
    //   54: getstatic 160	arbz:pD	Ljava/util/HashMap;
    //   57: aload_1
    //   58: invokevirtual 277	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   61: checkcast 6	arbz$a
    //   64: astore 7
    //   66: aload 7
    //   68: aload_1
    //   69: putfield 280	arbz$a:czs	Ljava/lang/String;
    //   72: aload_0
    //   73: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   76: ifne +9 -> 85
    //   79: aload 7
    //   81: aload_0
    //   82: putfield 283	arbz$a:originUrl	Ljava/lang/String;
    //   85: aload_2
    //   86: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   89: ifne +9 -> 98
    //   92: aload 7
    //   94: aload_2
    //   95: putfield 286	arbz$a:czt	Ljava/lang/String;
    //   98: aload_3
    //   99: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   102: ifne +9 -> 111
    //   105: aload 7
    //   107: aload_3
    //   108: putfield 289	arbz$a:inputText	Ljava/lang/String;
    //   111: iload 4
    //   113: ifeq +10 -> 123
    //   116: aload 7
    //   118: iload 4
    //   120: putfield 292	arbz$a:cYf	Z
    //   123: iload 5
    //   125: ifeq +10 -> 135
    //   128: aload 7
    //   130: iload 5
    //   132: putfield 295	arbz$a:cYg	Z
    //   135: aload 7
    //   137: iload 6
    //   139: putfield 298	arbz$a:cYh	Z
    //   142: getstatic 160	arbz:pD	Ljava/util/HashMap;
    //   145: aload_1
    //   146: aload 7
    //   148: invokevirtual 273	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   151: pop
    //   152: goto -127 -> 25
    //   155: astore_0
    //   156: ldc 2
    //   158: monitorexit
    //   159: aload_0
    //   160: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramString1	String
    //   0	161	1	paramString2	String
    //   0	161	2	paramString3	String
    //   0	161	3	paramString4	String
    //   0	161	4	paramBoolean1	boolean
    //   0	161	5	paramBoolean2	boolean
    //   0	161	6	paramBoolean3	boolean
    //   64	83	7	locala	arbz.a
    // Exception table:
    //   from	to	target	type
    //   3	25	155	finally
    //   29	54	155	finally
    //   54	85	155	finally
    //   85	98	155	finally
    //   98	111	155	finally
    //   116	123	155	finally
    //   128	135	155	finally
    //   135	152	155	finally
  }
  
  public static void ad(String paramString1, String paramString2, int paramInt)
  {
    String str = arcp.getSchemeFromUrl(paramString1);
    if (("http".equals(str)) || ("https".equals(str))) {
      break label28;
    }
    label28:
    while (!cYc) {
      return;
    }
    if (paramString2 == null)
    {
      localObject = null;
      label41:
      if (localObject != null) {
        break label132;
      }
      paramString2 = "";
      label48:
      if (localObject != null) {
        break label140;
      }
    }
    label132:
    label140:
    for (Object localObject = "";; localObject = ((Uri)localObject).getPath())
    {
      anot.a(null, "dc00899", "WV_Analysis", "", "scheme_call", "total", paramInt, 0, paramString2, (String)localObject, str, arcp.qd(paramString1));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SwiftBrowserStatistics", 2, new Object[] { "reportScheme ", str, " method:", arcp.qd(paramString1) });
      return;
      localObject = Uri.parse(paramString2);
      break label41;
      paramString2 = ((Uri)localObject).getHost();
      break label48;
    }
  }
  
  private void ehc()
  {
    if (!anop.cIU)
    {
      anop.a locala = new anop.a();
      locala.Ur = "0X8009242";
      locala.Uq = "离开点击Push";
      anop.a(this.czp, locala);
      anop.a(null, locala);
      anop.cIU = true;
    }
  }
  
  private void ehd()
  {
    if (!anop.cIU) {
      aizd.a(null, this.czn, this.czo, this.czp, "0X8009242", "离开点击Push");
    }
  }
  
  public static void ehe()
  {
    for (;;)
    {
      try
      {
        Object localObject = pD;
        pD = new HashMap();
        localObject = ((HashMap)localObject).values();
        if (localObject != null)
        {
          Iterator localIterator = ((Collection)localObject).iterator();
          if (localIterator.hasNext())
          {
            arbz.a locala = (arbz.a)localIterator.next();
            HashMap localHashMap = new HashMap();
            localHashMap.put("originUrl", locala.originUrl);
            localHashMap.put("curUrl", locala.czs);
            if (!TextUtils.isEmpty(locala.czt)) {
              localHashMap.put("recognisedText", locala.czt);
            }
            if (locala.cYf)
            {
              localObject = "1";
              localHashMap.put("passwdTyped", localObject);
              if (!locala.cYg) {
                break label202;
              }
              localObject = "1";
              localHashMap.put("showPasswd", localObject);
              anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "wvAntiPasswd", true, 0L, 0L, localHashMap, "");
            }
          }
          else
          {
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("SwiftBrowserStatistics", 2, localThrowable, new Object[0]);
      }
      do
      {
        str = "0";
        break;
      } while (!QLog.isColorLevel());
      QLog.d("SwiftBrowserStatistics", 2, "nothing to report");
      return;
      label202:
      String str = "0";
    }
  }
  
  /* Error */
  public static Bundle i(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 224	android/os/Bundle
    //   6: dup
    //   7: invokespecial 445	android/os/Bundle:<init>	()V
    //   10: astore 4
    //   12: aload_0
    //   13: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: istore_3
    //   17: iload_3
    //   18: ifeq +9 -> 27
    //   21: ldc 2
    //   23: monitorexit
    //   24: aload 4
    //   26: areturn
    //   27: getstatic 160	arbz:pD	Ljava/util/HashMap;
    //   30: aload_0
    //   31: invokevirtual 268	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   34: ifeq +159 -> 193
    //   37: getstatic 160	arbz:pD	Ljava/util/HashMap;
    //   40: aload_0
    //   41: invokevirtual 277	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 6	arbz$a
    //   47: astore_0
    //   48: aload_0
    //   49: getfield 286	arbz$a:czt	Ljava/lang/String;
    //   52: ifnull +65 -> 117
    //   55: aload_0
    //   56: getfield 286	arbz$a:czt	Ljava/lang/String;
    //   59: ldc_w 447
    //   62: invokevirtual 451	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   65: astore 5
    //   67: new 196	java/util/ArrayList
    //   70: dup
    //   71: aload 5
    //   73: arraylength
    //   74: invokespecial 452	java/util/ArrayList:<init>	(I)V
    //   77: astore 6
    //   79: aload 5
    //   81: arraylength
    //   82: istore_2
    //   83: iconst_0
    //   84: istore_1
    //   85: iload_1
    //   86: iload_2
    //   87: if_icmpge +20 -> 107
    //   90: aload 6
    //   92: aload 5
    //   94: iload_1
    //   95: aaload
    //   96: invokevirtual 455	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   99: pop
    //   100: iload_1
    //   101: iconst_1
    //   102: iadd
    //   103: istore_1
    //   104: goto -19 -> 85
    //   107: aload 4
    //   109: ldc_w 457
    //   112: aload 6
    //   114: invokevirtual 461	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   117: aload_0
    //   118: getfield 289	arbz$a:inputText	Ljava/lang/String;
    //   121: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   124: ifeq +15 -> 139
    //   127: aload 4
    //   129: ldc_w 462
    //   132: aload_0
    //   133: getfield 289	arbz$a:inputText	Ljava/lang/String;
    //   136: invokevirtual 228	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload_0
    //   140: getfield 295	arbz$a:cYg	Z
    //   143: ifeq +53 -> 196
    //   146: iconst_1
    //   147: istore_1
    //   148: aload 4
    //   150: ldc_w 464
    //   153: iload_1
    //   154: invokevirtual 468	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   157: aload_0
    //   158: getfield 292	arbz$a:cYf	Z
    //   161: ifeq +40 -> 201
    //   164: iconst_1
    //   165: istore_1
    //   166: aload 4
    //   168: ldc_w 470
    //   171: iload_1
    //   172: invokevirtual 468	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   175: aload_0
    //   176: getfield 298	arbz$a:cYh	Z
    //   179: ifeq +27 -> 206
    //   182: iconst_1
    //   183: istore_1
    //   184: aload 4
    //   186: ldc_w 472
    //   189: iload_1
    //   190: invokevirtual 468	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   193: goto -172 -> 21
    //   196: iconst_0
    //   197: istore_1
    //   198: goto -50 -> 148
    //   201: iconst_0
    //   202: istore_1
    //   203: goto -37 -> 166
    //   206: iconst_0
    //   207: istore_1
    //   208: goto -24 -> 184
    //   211: astore_0
    //   212: ldc 241
    //   214: iconst_1
    //   215: aload_0
    //   216: iconst_0
    //   217: anewarray 243	java/lang/Object
    //   220: invokestatic 249	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   223: goto -30 -> 193
    //   226: astore_0
    //   227: ldc 2
    //   229: monitorexit
    //   230: aload_0
    //   231: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	paramString	String
    //   84	124	1	i	int
    //   82	6	2	j	int
    //   16	2	3	bool	boolean
    //   10	175	4	localBundle	Bundle
    //   65	28	5	arrayOfString	String[]
    //   77	36	6	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   12	17	211	java/lang/Throwable
    //   27	83	211	java/lang/Throwable
    //   90	100	211	java/lang/Throwable
    //   107	117	211	java/lang/Throwable
    //   117	139	211	java/lang/Throwable
    //   139	146	211	java/lang/Throwable
    //   148	164	211	java/lang/Throwable
    //   166	182	211	java/lang/Throwable
    //   184	193	211	java/lang/Throwable
    //   3	12	226	finally
    //   12	17	226	finally
    //   27	83	226	finally
    //   90	100	226	finally
    //   107	117	226	finally
    //   117	139	226	finally
    //   139	146	226	finally
    //   148	164	226	finally
    //   166	182	226	finally
    //   184	193	226	finally
    //   212	223	226	finally
  }
  
  public static String qa(String paramString)
  {
    if (paramString == null) {
      return "null";
    }
    int i = paramString.indexOf('?');
    int j = paramString.indexOf('#');
    if (i == -1)
    {
      i = j;
      if (j == -1) {
        i = paramString.length();
      }
    }
    while (i == 0)
    {
      return "null";
      if (j != -1) {
        i = Math.min(i, j);
      }
    }
    return paramString.substring(0, i);
  }
  
  public static boolean rR(String paramString)
  {
    boolean bool2 = true;
    String str = arcp.getSchemeFromUrl(paramString);
    boolean bool1;
    if ((!"null".equals(paramString)) && (paramString.length() <= 1024))
    {
      bool1 = bool2;
      if (!"http".equals(str))
      {
        bool1 = bool2;
        if ("https".equals(str)) {}
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserStatistics", 2, new Object[] { "not report url:", paramString });
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public void P(int paramInt, Bundle paramBundle)
  {
    super.P(paramInt, paramBundle);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      label73:
      long l1;
      long l2;
      int i;
      if (this.auw > 0L)
      {
        paramInt = (int)((this.auu - this.auw) / 1000000L);
        if (this.cXQ)
        {
          paramBundle = jqc.getNetWorkType() + "";
          l1 = System.currentTimeMillis();
          l2 = this.aux;
          if (!WebProcessManager.aFR()) {
            break label280;
          }
          i = 1;
          label121:
          if (!this.isWebViewCache) {
            break label285;
          }
        }
      }
      label280:
      label285:
      for (int j = 1;; j = 0)
      {
        anot.b(null, "P_CliOper", "Vip_SummaryCard", "", "0X8004FFD", "0X8004FFD", 0, 1, 0, paramBundle, String.valueOf(l1 - l2), String.valueOf(i), String.valueOf(j));
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("web_report", 4, "web_before_create, cost = " + paramInt + ", url = " + jqo.filterKeyForLog(this.czp, new String[0]) + ", isFromLeba = " + this.cXN + ", hasRedDot = " + this.dw + ", isProgressCreate = " + aeo + ", flag=" + this.flag);
        return;
        paramInt = 0;
        break label73;
        i = 0;
        break label121;
      }
      if (QLog.isColorLevel()) {
        QLog.i("GOTOWEB", 2, "onQQBrowserResume() time = " + System.currentTimeMillis());
      }
      this.auq = System.currentTimeMillis();
      return;
      doOnPause();
      return;
      if ((paramBundle != null) && (paramBundle.containsKey("url")))
      {
        Wh(paramBundle.getString("url"));
        return;
        if ((paramBundle != null) && (paramBundle.containsKey("url")))
        {
          We(paramBundle.getString("url"));
          return;
          if ((paramBundle != null) && (paramBundle.containsKey("url"))) {}
          for (paramBundle = paramBundle.getString("url"); !TextUtils.isEmpty(paramBundle); paramBundle = "")
          {
            b((TouchWebView)this.jdField_a_of_type_Araz$b.getWebView(), paramBundle);
            return;
          }
        }
      }
    }
  }
  
  public void We(String paramString)
  {
    if ("about:blank".equalsIgnoreCase(paramString)) {
      break label10;
    }
    label10:
    while (!this.mIsFirstOnPageStart) {
      return;
    }
    this.auv = System.nanoTime();
    this.jdField_a_of_type_Arbz$b.mCurrentStep = 2;
    this.jdField_a_of_type_Arbz$b.aiB = System.currentTimeMillis();
    this.avj = (this.jdField_a_of_type_Arbz$b.aiB - this.mClickTime);
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser_report", 2, "try report web status, onPageStarted,  step: " + this.jdField_a_of_type_Arbz$b.mCurrentStep + ", asyncMode: " + this.eeg + ", stepTime: " + this.avj + ", totalTime: " + (System.currentTimeMillis() - this.mClickTime) + "\n" + paramString);
    }
    int k;
    String str1;
    String str2;
    int i;
    if ((this.cXQ) && (!this.isDestroyed))
    {
      k = (int)((this.auv - this.auu) / 1000000L);
      str1 = jqc.getNetWorkType() + "";
      str2 = "" + k;
      if (!WebProcessManager.aFR()) {
        break label448;
      }
      i = 1;
      label234:
      if (!this.isWebViewCache) {
        break label453;
      }
    }
    label448:
    label453:
    for (int j = 1;; j = 0)
    {
      anot.b(null, "P_CliOper", "Vip_SummaryCard", "", "0X8004F62", "0X8004F62", 0, 1, 0, str1, str2, String.valueOf(i), String.valueOf(j));
      if (QLog.isDevelopLevel()) {
        QLog.d("web_report", 4, "web_before_load_url, cost = " + k + ", url = " + jqo.filterKeyForLog(this.czp, new String[0]) + ", isFromLeba = " + this.cXN + ", hasRedDot = " + this.dw);
      }
      if (!this.isDestroyed) {
        this.Jl.add(paramString);
      }
      if ((this.cXU) && (this.hV == null))
      {
        this.hV = new SwiftBrowserStatistics.1(this);
        ThreadManager.getUIHandler().postDelayed(this.hV, 3000L);
      }
      this.mStartLoadUrlMilliTimeStamp = System.currentTimeMillis();
      if (!aodb.pS(paramString)) {
        break;
      }
      aodb.aX("SwiftBrowserStatistics", "onPageStarted_url", paramString);
      aodb.fy(String.valueOf(this.auv));
      return;
      i = 0;
      break label234;
    }
  }
  
  public void Wf(String paramString)
  {
    if (!cYa) {}
    HashMap localHashMap;
    do
    {
      return;
      localHashMap = new HashMap();
      paramString = qa(paramString);
    } while (!rR(paramString));
    localHashMap.put("url", paramString);
    localHashMap.put("source_activity", this.czm);
    localHashMap.put("process_start_spending_time", String.valueOf(this.auO));
    localHashMap.put("init_tbs_time", String.valueOf(this.auF));
    localHashMap.put("init_x5_core_time", String.valueOf(this.auC));
    localHashMap.put("init_x5_webview_time", String.valueOf(this.auD));
    localHashMap.put("init_tbs_so_time", String.valueOf(this.auE));
    localHashMap.put("init_all_time", String.valueOf(this.auG));
    localHashMap.put("activity_on_create_time", String.valueOf(this.auM - this.auL));
    localHashMap.put("is_cold_launch", "" + this.cXL);
    localHashMap.put("network_type", this.mNetworkType);
    localHashMap.put("system_os", Build.MODEL + Build.VERSION.SDK_INT);
    localHashMap.put("QQ_version", AppSetting.getRevision());
    localHashMap.put("use_offline_package", cXK + "");
    localHashMap.put("use_sonic", this.cXM + "");
    localHashMap.put("use_pre_load", "" + aeo);
    paramString = new StringBuilder();
    if (auK > this.auL) {}
    for (boolean bool = false;; bool = true)
    {
      localHashMap.put("is_x5_init", bool + "");
      localHashMap.put("webview_create_time", String.valueOf(this.auP));
      localHashMap.put("core_type", String.valueOf(this.eeh));
      localHashMap.put("fragment_create_final", String.valueOf(this.auN - this.auM));
      localHashMap.put("browser_act_create_cost", String.valueOf(this.auN - auI));
      if (this.Jl.size() > 0)
      {
        localHashMap.put("redirect_time", "" + this.Jl.size());
        localHashMap.put("first_url", this.Jl.get(0));
      }
      localHashMap.put("int_tbs_env", String.valueOf(arcn.a.avr));
      localHashMap.put("init_plugin", String.valueOf(auJ));
      localHashMap.put("fragment_create_time", String.valueOf(this.auM - auI));
      localHashMap.put("step_initUIFrame", String.valueOf(this.auQ));
      localHashMap.put("step_initUIContent", String.valueOf(this.auS));
      localHashMap.put("step_initTitleBar", String.valueOf(this.auR));
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserStatistics", 4, "webviewSpendingTimeCollection: " + localHashMap);
      }
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "webviewSpendingTimeCollection", true, 0L, 0L, localHashMap, "");
      akld.aU(this.dnv, this.dnw, this.dnx);
      return;
    }
  }
  
  public void Wg(String paramString)
  {
    if (paramString.equals("state_back")) {
      if (!this.mState.equals("state_final")) {
        this.pC.put("state_back", Long.valueOf(SystemClock.elapsedRealtime()));
      }
    }
    int i;
    int j;
    do
    {
      return;
      if (this.dO.size() == 0)
      {
        this.dO.put(0, "state_activity_init");
        this.dO.put(1, "state_activity_create");
        this.dO.put(2, "state_webview_create");
        this.dO.put(3, "state_load_url");
        this.dO.put(4, "state_activity_first_line");
        this.dO.put(5, "state_first_screen");
        this.dO.put(6, "state_page_finished");
        this.dO.put(7, "state_final");
      }
      i = this.dO.indexOfValue(paramString);
      j = this.dO.indexOfValue(this.mState);
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserStatistics", 4, "setBounceRateState state=" + paramString + " mCurr=" + this.mState);
      }
    } while (i <= j);
    this.mState = paramString;
    this.pC.put(this.mState, Long.valueOf(SystemClock.elapsedRealtime()));
  }
  
  public void Wh(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (this.cXS) {
        anot.b(null, "P_CliOper", "Grp_open", "", "time", "wide_time", 0, 1, 0, "", paramString.getQueryParameter("appid"), (int)((System.nanoTime() - this.auu) / 1000000L) + "", paramString.getQueryParameter("group_openid"));
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("web_report", 4, "web_stay_in_url, cost = " + (System.nanoTime() - this.auu) / 1000000L + ", url = " + jqo.filterKeyForLog(this.czp, new String[0]) + ", isFromLeba = " + this.cXN + ", hasRedDot = " + this.dw);
    }
    if (this.hV != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.hV);
    }
    if ((this.cXO) && (!this.cXR)) {
      ehc();
    }
  }
  
  public void Wi(String paramString)
  {
    QLog.i("SwiftBrowserStatistics", 1, "shouldOverrideUrlLoading detect 302, url: " + paramString);
    this.mRedirect302Time = System.currentTimeMillis();
    this.mPerfFirstLoadTag = true;
    this.Jl.add(paramString);
  }
  
  public BusinessInfoCheckUpdate.TimeRspBody a(AppInterface paramAppInterface)
  {
    if ((paramAppInterface == null) || (paramAppInterface.getApplication() == null)) {}
    for (;;)
    {
      return null;
      Object localObject = paramAppInterface.getApplication().getFilesDir();
      paramAppInterface = paramAppInterface.getCurrentAccountUin();
      paramAppInterface = new File((File)localObject, "BusinessInfoCheckUpdateItem_new_1_" + paramAppInterface);
      if (!paramAppInterface.exists()) {}
      try
      {
        paramAppInterface.createNewFile();
        paramAppInterface = aqhq.fileToBytes(paramAppInterface);
        if (paramAppInterface != null) {
          localObject = new BusinessInfoCheckUpdate.TimeRspBody();
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          try
          {
            ((BusinessInfoCheckUpdate.TimeRspBody)localObject).mergeFrom(paramAppInterface);
            return localObject;
          }
          catch (Exception paramAppInterface)
          {
            paramAppInterface.printStackTrace();
          }
          localIOException = localIOException;
          localIOException.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public String a(boolean paramBoolean, AppRuntime paramAppRuntime)
  {
    if (!paramBoolean) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramAppRuntime instanceof AppInterface)) {}
    for (paramAppRuntime = (AppInterface)paramAppRuntime;; paramAppRuntime = null)
    {
      if (paramAppRuntime == null) {
        return "";
      }
      String str = paramAppRuntime.getApp().getSharedPreferences("redTouchPref", 4).getString("lastClickPath", "");
      if (!"".equals(str))
      {
        paramAppRuntime = a(paramAppRuntime);
        if (paramAppRuntime == null) {
          break label212;
        }
        paramAppRuntime = paramAppRuntime.rptMsgAppInfo.get();
        if (paramAppRuntime == null) {
          break label212;
        }
        Iterator localIterator = paramAppRuntime.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          paramAppRuntime = (BusinessInfoCheckUpdate.AppInfo)localIterator.next();
        } while (!paramAppRuntime.path.get().equals(str));
      }
      for (;;)
      {
        if (paramAppRuntime != null)
        {
          paramAppRuntime = paramAppRuntime.missions.get();
          if (paramAppRuntime != null)
          {
            int i = 0;
            while (i < paramAppRuntime.size())
            {
              localStringBuilder.append((String)paramAppRuntime.get(i));
              if (i != paramAppRuntime.size() - 1) {
                localStringBuilder.append("_");
              }
              i += 1;
            }
          }
        }
        return localStringBuilder.toString();
        label212:
        paramAppRuntime = null;
      }
    }
  }
  
  public void a(Context paramContext, arbz.b paramb)
  {
    paramContext = new File(paramContext.getFilesDir(), aqpi.e.cuN);
    if (!paramContext.exists()) {}
    do
    {
      do
      {
        return;
        paramContext = aqhq.readFileContent(paramContext);
      } while (TextUtils.isEmpty(paramContext));
      try
      {
        paramContext = new JSONObject(paramContext);
        int i = paramContext.getInt("sample_rate");
        arbz.b.pE.put("sample_rate", Integer.valueOf(i));
        JSONArray localJSONArray = paramContext.getJSONArray("rules");
        int j = localJSONArray.length();
        i = 0;
        while (i < j)
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          arbz.b.pE.put(localJSONObject.getString("distUrl"), Integer.valueOf(localJSONObject.getInt("rate")));
          i += 1;
        }
        paramb.eep = paramContext.getInt("tail_number");
        return;
      }
      catch (Throwable paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.d("QQBrowser", 2, "" + paramContext);
  }
  
  public void a(TouchWebView paramTouchWebView, int paramInt, String paramString1, String paramString2)
  {
    Object localObject = paramTouchWebView.getPluginEngine();
    if (localObject != null)
    {
      localObject = ((WebViewPluginEngine)localObject).b("offline");
      if ((localObject == null) || (!(localObject instanceof stw))) {}
    }
    for (localObject = (stw)localObject;; localObject = null)
    {
      if ((localObject != null) && (((stw)localObject).aZ() != null)) {}
      for (localObject = ((stw)localObject).aZ();; localObject = "")
      {
        int i;
        int j;
        label74:
        String str2;
        if (paramTouchWebView.getX5WebViewExtension() != null)
        {
          i = 3;
          j = 0;
          if (j >= this.Jl.size()) {
            break label249;
          }
          str2 = (String)this.Jl.get(j);
          if (j != this.Jl.size() - 1) {
            break label234;
          }
          paramTouchWebView = String.valueOf(paramInt);
          label125:
          if (str2 == null) {
            break label241;
          }
        }
        label234:
        label241:
        for (String str1 = str2;; str1 = "unknown")
        {
          VasWebviewUtil.reportQBWebInfo((String)localObject, "qbweb_load_redirect", "", str1.replace("|", "%7C"), i, 0, "0", String.valueOf(this.flag), jqc.hS(), 0, 0, "", paramTouchWebView);
          if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserStatistics", 2, "url=" + str2 + ", rlt=" + paramTouchWebView);
          }
          j += 1;
          break label74;
          i = 1;
          break;
          paramTouchWebView = "10001";
          break label125;
        }
        label249:
        this.Jl.clear();
        if (aodb.pS(paramString2)) {
          aodb.b(null, aodb.oa(paramString2), "0X8009E9F", "fail", aodb.ob(paramString2), "err=" + paramInt);
        }
        aodb.R(paramString2, "SwiftBrowserStatistics", "web_loaded_url_err", "errorCode = " + paramInt + " description = " + paramString1);
        aodb.R(paramString2, "SwiftBrowserStatistics", "failingUrl", paramString2);
        aodb.aY(paramString2, "SwiftBrowserStatistics", "cookie");
        return;
      }
    }
  }
  
  public void a(TouchWebView paramTouchWebView, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String... paramVarArgs)
  {
    ThreadManager.post(new SwiftBrowserStatistics.5(this, paramTouchWebView, paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramVarArgs), 5, null, false);
  }
  
  public void b(TouchWebView paramTouchWebView, String paramString)
  {
    if (paramTouchWebView == null) {
      return;
    }
    Object localObject1 = paramTouchWebView.getPluginEngine();
    if (localObject1 != null)
    {
      localObject1 = ((WebViewPluginEngine)localObject1).b("offline");
      if ((localObject1 == null) || (!(localObject1 instanceof stw))) {}
    }
    for (localObject1 = (stw)localObject1;; localObject1 = null)
    {
      if ((localObject1 != null) && (((stw)localObject1).aZ() != null)) {}
      for (localObject1 = ((stw)localObject1).aZ();; localObject1 = "")
      {
        long l;
        try
        {
          if ((this.czp.startsWith("http://")) || (paramString.startsWith("http://")))
          {
            localObject2 = new HashMap(2);
            ((HashMap)localObject2).put("url", paramString);
            ((HashMap)localObject2).put("first_url", this.czp);
            if ((this.s != null) && (this.s.getIntent() != null))
            {
              localObject3 = this.s.getIntent();
              i = ((Intent)localObject3).getIntExtra("articalChannelId", 100);
              boolean bool = ((Intent)localObject3).getBooleanExtra("fromAio", false);
              ((HashMap)localObject2).put("fromChannel", Integer.valueOf(i));
              ((HashMap)localObject2).put("fromAIO", Boolean.valueOf(bool));
            }
            anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "actWVHttpReport", true, 0L, 0L, (HashMap)localObject2, "");
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Object localObject2;
            Object localObject3;
            QLog.e("SwiftBrowserStatistics", 1, localThrowable, new Object[0]);
            continue;
            int i = 0;
            continue;
            int j = 0;
            continue;
            i = 1;
            continue;
            paramTouchWebView = "unknown";
          }
          this.Jl.clear();
          if ((!this.mIsFirstOnPageStart) || (!this.zh) || (this.cXT)) {
            break label758;
          }
          this.cXT = true;
          if (paramString == null) {
            break label845;
          }
          paramTouchWebView = paramString;
          anot.b(null, "P_CliOper", "Pb_account_lifeservice", "", "msg_webview_url", "msg_webview_pvqq", 0, 1, 0, jqo.filterKeyForLog(URLEncoder.encode(paramTouchWebView), new String[0]), "", "", "" + this.flag);
        }
        if ((this.cXQ) && (this.cXR) && (!this.isDestroyed))
        {
          localObject2 = jqc.getNetWorkType() + "";
          l = (System.nanoTime() - this.auv) / 1000000L;
          if (!WebProcessManager.aFR()) {
            break label636;
          }
          i = 1;
          localObject3 = new StringBuilder();
          if (!this.isWebViewCache) {
            break label641;
          }
          j = 1;
          anot.b(null, "P_CliOper", "Vip_SummaryCard", "", "0X8004FFE", "0X8004FFE", 0, 1, 0, (String)localObject2, String.valueOf(l), String.valueOf(i), String.valueOf(j) + ", " + (String)localObject1);
          if (QLog.isDevelopLevel()) {
            QLog.d("web_report", 4, "web_load_url, cost = " + (System.nanoTime() - this.auv) / 1000000L + ", url = " + jqo.filterKeyForLog(this.czp, new String[0]) + ", isFromLeba = " + this.cXN + ", hasRedDot = " + this.dw + ", " + (String)localObject1);
          }
        }
        if ((this.cXR) && (!this.isDestroyed))
        {
          Wf(paramString);
          if (paramTouchWebView.getX5WebViewExtension() != null)
          {
            i = 3;
            localObject3 = this.Jl.iterator();
            for (;;)
            {
              if (!((Iterator)localObject3).hasNext()) {
                break label659;
              }
              localObject2 = (String)((Iterator)localObject3).next();
              if (localObject2 == null) {
                break;
              }
              paramTouchWebView = (TouchWebView)localObject2;
              VasWebviewUtil.reportQBWebInfo((String)localObject1, "qbweb_load_redirect", "", paramTouchWebView.replace("|", "%7C"), i, 0, "0", String.valueOf(this.flag), jqc.hS(), 0, 0, "", "10000");
              if (QLog.isColorLevel()) {
                QLog.d("SwiftBrowserStatistics", 2, "url=" + (String)localObject2 + ", rlt=" + "10000");
              }
            }
          }
        }
        label636:
        while (aodb.pS(paramString))
        {
          l = aodb.aO(String.valueOf(this.auv));
          paramTouchWebView = aodb.ob(paramString);
          paramString = aodb.oa(paramString);
          if (l != 0L)
          {
            aodb.b(null, paramString, "0X8009E9F", "success", paramTouchWebView, "");
            aodb.b(null, paramString, "0X8009E9E", String.valueOf(l), paramTouchWebView, "");
          }
          if (!TextUtils.isEmpty(paramString)) {
            break label852;
          }
          aodb.aX("SwiftBrowserStatistics", "url_load_time", String.valueOf(l));
          return;
          paramTouchWebView = "unknown";
        }
        label641:
        label659:
        label758:
        break;
        label845:
        label852:
        aodb.Q("SwiftBrowserStatistics", "url_load_time", String.valueOf(l), paramString);
        return;
      }
    }
  }
  
  public void bW(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      try
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject("DETAIL");
        boolean bool = localJSONObject.optBoolean("is_first_init_tbs");
        long l1 = localJSONObject.optLong("init_x5_core_begin");
        long l2 = localJSONObject.optLong("init_x5_core_end");
        long l3 = localJSONObject.optLong("webview_init_begin");
        long l4 = localJSONObject.optLong("webview_init_end");
        long l5 = localJSONObject.optLong("tbslog_init_begin");
        long l6 = localJSONObject.optLong("tbslog_init_end");
        long l7 = localJSONObject.optLong("init_all_begin");
        long l8 = localJSONObject.optLong("init_all_end");
        long l9 = localJSONObject.optLong("tbs_load_so_begin");
        long l10 = localJSONObject.optLong("tbs_load_so_end");
        this.auC = (l2 - l1);
        this.auD = (l4 - l3);
        this.auE = (l10 - l9);
        this.auF = (l6 - l5);
        this.auG = (l8 - l7);
        if (QLog.isColorLevel())
        {
          QLog.d("SwiftBrowserStatistics", 2, new Object[] { "performance: ", paramJSONObject.toString() });
          QLog.d("SwiftBrowserStatistics", 2, new Object[] { "firstInitTbs: ", Boolean.valueOf(bool), " x5core: ", Long.valueOf(this.auC), " webview: ", Long.valueOf(this.auD), " loadSo:", Long.valueOf(this.auE), " tbsLog:", Long.valueOf(this.auF), " initAll:", Long.valueOf(this.auG) });
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("SwiftBrowserStatistics", 1, new Object[] { "exception ", paramJSONObject.toString() });
      }
    }
  }
  
  public void bo(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      paramString1 = qa(paramString1);
      if (!rR(paramString1)) {
        return;
      }
      localHashMap.put("url", paramString1);
      localHashMap.put(paramString2, paramString3);
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserStatistics", 4, "reportErrorScene: " + localHashMap);
      }
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "actWvReportError", true, 0L, 0L, localHashMap, "");
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("SwiftBrowserStatistics", 2, paramString1, new Object[0]);
    }
  }
  
  public void d(Context paramContext, String paramString, Intent paramIntent)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.jdField_a_of_type_Arbz$b.G == null) {
      this.jdField_a_of_type_Arbz$b.G = paramContext.getSharedPreferences("WebView_Report_Step", 0);
    }
    String str = "UNKNOWN";
    try
    {
      int i = aqiw.getSystemNetwork(paramContext);
      paramIntent = str;
      if (i != -1)
      {
        paramIntent = str;
        if (i < acbn.dQ.length) {
          paramIntent = acbn.dQ[i];
        }
      }
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        paramIntent = "UNKNOWN";
      }
    }
    ThreadManager.post(new SwiftBrowserStatistics.4(this, paramString, paramContext, System.currentTimeMillis(), paramIntent), 5, null, false);
  }
  
  public void doOnPause()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + localAppRuntime.getLongAccountUin(), 4);
    if ((localSharedPreferences != null) && (!TextUtils.isEmpty(this.mOpType)))
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.auq;
      anot.b(null, "dc00899", "grp_lbs", "", this.mOpType, "visit_time", 0, 1, 0, "" + localSharedPreferences.getInt("charm_level", 0), "" + localSharedPreferences.getInt("gender", 0), "" + (l1 - l2), "");
    }
    if (((this.cXO) || (this.cXP)) && (!this.cXR) && (!anop.cIU)) {
      ThreadManager.getFileThreadHandler().postDelayed(new SwiftBrowserStatistics.2(this, localAppRuntime), 1000L);
    }
  }
  
  public void egS()
  {
    super.egS();
    this.s = this.jdField_a_of_type_Araz$b.getActivity();
  }
  
  public void i(String paramString1, long paramLong, String paramString2)
  {
    if ((aodb.pS(this.czp)) && (TextUtils.equals(paramString1, "webview_init"))) {
      aodb.b(null, aodb.oa(this.czp), "0X8009E9D", String.valueOf(paramLong), aodb.ob(this.czp), "err=" + paramString2);
    }
    aodb.R(this.czp, "SwiftBrowserStatistics", paramString1, String.valueOf(paramLong));
    String str = this.czq;
    int i;
    int j;
    if (this.buI)
    {
      i = 1;
      if (!this.cYd) {
        break label165;
      }
      j = 2;
      label106:
      if (!this.cYe) {
        break label171;
      }
    }
    label165:
    label171:
    for (int k = 4;; k = 0)
    {
      anot.a(null, "dc00899", "WV_Analysis", "", paramString1, str, j | i | k, (int)paramLong, String.valueOf(this.eeh), this.czr, this.mNetworkType, paramString2);
      return;
      i = 0;
      break;
      j = 0;
      break label106;
    }
  }
  
  public void onDetectedBlankScreen(String paramString, int paramInt)
  {
    if (paramInt == 0) {}
    while ((!this.cXQ) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    ThreadManager.post(new SwiftBrowserStatistics.3(this, paramString, paramInt), 5, null, false);
  }
  
  public void u(Intent paramIntent, String paramString)
  {
    this.auu = System.nanoTime();
    this.mOnCreateMilliTimeStamp = paramIntent.getLongExtra("qqBrowserActivityCreateTime", -1L);
    if (this.mOnCreateMilliTimeStamp <= 0L) {
      this.mOnCreateMilliTimeStamp = System.currentTimeMillis();
    }
    this.auM = SystemClock.elapsedRealtime();
    QLog.e("SwiftBrowserStatistics", 1, "onCreate mOnCreateMilliTimeStamp = " + this.mOnCreateMilliTimeStamp);
    this.jdField_a_of_type_Arbz$b.mCurrentStep = 1;
    this.jdField_a_of_type_Arbz$b.aiB = this.mOnCreateMilliTimeStamp;
    this.mClickTime = paramIntent.getLongExtra("startOpenPageTime", -1L);
    QLog.e("SwiftBrowserStatistics", 1, "onCreate mClickTime = " + this.mClickTime);
    this.mOpType = paramIntent.getStringExtra("op_type");
    this.cXU = paramIntent.getBooleanExtra("reportMsfLog", false);
    this.zh = paramIntent.getBooleanExtra("fromAio", false);
    paramIntent.getBooleanExtra("fromPublicAccount", false);
    if (this.mClickTime == -1L) {
      this.mClickTime = this.mOnCreateMilliTimeStamp;
    }
    this.auw = paramIntent.getLongExtra("plugin_start_time", 0L);
    this.aux = paramIntent.getLongExtra("click_start_time", 0L);
    this.cXV = paramIntent.getBooleanExtra("FORCE_BLANK_SCREEN_REPORTE", false);
    if (this.auw > 0L) {
      paramIntent.putExtra("plugin_start_time", 0L);
    }
    if (this.aux > 0L) {
      paramIntent.putExtra("click_start_time", 0L);
    }
    this.cXN = paramIntent.getBooleanExtra("is_from_leba", false);
    this.dw = paramIntent.getBooleanExtra("has_red_dot", false);
    boolean bool;
    label334:
    int i;
    label487:
    int j;
    label497:
    int k;
    label507:
    long l;
    if (paramIntent.getIntExtra("uintype", -1) == 1030)
    {
      bool = true;
      this.cXO = bool;
      if (paramIntent.getIntExtra("uintype", -1) != 1035) {
        break label899;
      }
      bool = true;
      this.cXP = bool;
      this.czn = paramIntent.getStringExtra("push_notice_service_id");
      this.czo = paramIntent.getStringExtra("push_notice_content_id");
      this.dnv = paramIntent.getIntExtra("KEY_MAIN_BUSINESS_ID", -1);
      this.dnw = paramIntent.getIntExtra("KEY_SUB_BUSINESS_ID", 0);
      this.dnx = paramIntent.getIntExtra("KEY_PUSH_ID", 0);
      if ((this.cXO) || (this.cXP)) {
        anop.cIU = false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("GOTOWEB", 2, "onQQBrowserCreate() time = " + this.auu);
      }
      if (WebAccelerateHelper.isWebViewCache)
      {
        this.isWebViewCache = true;
        QLog.d("SwiftBrowserStatistics", 1, "onCreate, isWebViewCache = true");
      }
      this.auT = System.currentTimeMillis();
      if (!aeo) {
        break label905;
      }
      i = 1;
      if (!this.cXN) {
        break label910;
      }
      j = 1;
      if (!this.dw) {
        break label916;
      }
      k = 1;
      this.flag = (k + ((i << 2) + (j << 1)));
      this.czq = qa(paramString);
      this.mNetworkType = jqc.hS();
      if (cYa)
      {
        if (this.aux <= 0L) {
          break label922;
        }
        l = this.mOnCreateMilliTimeStamp - this.aux;
        label563:
        i("process_init", l, "0");
      }
      this.auL = paramIntent.getLongExtra("StartClickTime", 0L);
      paramIntent.removeExtra("StartClickTime");
      if ((this.s != null) && (this.s.getIntent() != null)) {
        this.s.getIntent().removeExtra("StartClickTime");
      }
      this.czm = paramIntent.getStringExtra("SourceActivityName");
      if (this.auL <= 0L)
      {
        this.auL = this.auM;
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserStatistics", 4, "reportTime mClickUrlMilliTime=" + this.auL);
        }
        bo(paramString, "ClickTime", this.auL + "");
      }
      if (this.auM - this.auL > 10000L) {
        bo(paramString, "CreateActivity", this.auM - this.auL + "");
      }
      if (auH <= this.auL) {
        break label928;
      }
      bool = true;
      label782:
      this.cXL = bool;
      if (!this.cXL) {
        break label934;
      }
    }
    label899:
    label905:
    label910:
    label916:
    label922:
    label928:
    label934:
    for (this.auO = (auH - this.auL);; this.auO = 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserStatistics", 2, new Object[] { "mClickUrlMilliTime: ", Long.valueOf(this.auL), " mSourceActivityClassName:", this.czm, " mProcessLaunchMilliTime:", Long.valueOf(auH), " mIsColdLaunch:", Boolean.valueOf(this.cXL) });
      }
      pD.clear();
      return;
      bool = false;
      break;
      bool = false;
      break label334;
      i = 0;
      break label487;
      j = 0;
      break label497;
      k = 0;
      break label507;
      l = 0L;
      break label563;
      bool = false;
      break label782;
    }
  }
  
  public void v(Intent paramIntent, String paramString)
  {
    if (!cYa) {}
    HashMap localHashMap;
    do
    {
      return;
      localHashMap = new HashMap();
      paramString = qa(paramString);
    } while (!rR(paramString));
    localHashMap.put("url", paramString);
    localHashMap.put("source_activity", paramIntent.getStringExtra("SourceActivityName"));
    if (auH > this.auL) {}
    for (boolean bool = true;; bool = false)
    {
      paramIntent = this.pC.keySet().iterator();
      while (paramIntent.hasNext())
      {
        paramString = (String)paramIntent.next();
        localHashMap.put(paramString, ((Long)this.pC.get(paramString)).longValue() - this.auL + "");
      }
    }
    localHashMap.put("bounce_rate_state", this.mState);
    localHashMap.put("is_cold_launch", "" + bool);
    localHashMap.put("network_type", jqc.hS());
    localHashMap.put("system_os", Build.MODEL + Build.VERSION.SDK_INT);
    localHashMap.put("QQ_version", AppSetting.getRevision());
    localHashMap.put("use_offline_package", cXK + "");
    localHashMap.put("use_sonic", this.cXM + "");
    localHashMap.put("use_pre_load", "" + aeo);
    paramIntent = new StringBuilder();
    if (auK > this.auL) {}
    for (bool = false;; bool = true)
    {
      localHashMap.put("is_x5_init", bool + "");
      localHashMap.put("core_type", this.eeh + "");
      localHashMap.put("activity_create_final", String.valueOf(this.auN - this.auM));
      localHashMap.put("origin_url", this.czq);
      if (this.Jl.size() > 0)
      {
        localHashMap.put("redirect_time", "" + this.Jl.size());
        localHashMap.put("first_url", this.Jl.get(0));
      }
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserStatistics", 4, "reportBounceRate: " + localHashMap);
      }
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "webviewBounceRateCollection", true, 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  public static class a
  {
    boolean cYf;
    boolean cYg;
    boolean cYh;
    String czs;
    String czt;
    String inputText;
    String originUrl;
  }
  
  public static class b
  {
    public static int eeq = -1;
    public static HashMap<String, Integer> pE = new HashMap(10);
    public SharedPreferences G;
    public long aiB;
    public boolean dw;
    public int eeo;
    public int eep = 6;
    public int mCurrentStep = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arbz
 * JD-Core Version:    0.7.0.1
 */