import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.OfflinePlugin.10;
import com.tencent.biz.webviewplugin.OfflinePlugin.5;
import com.tencent.biz.webviewplugin.OfflinePlugin.6;
import com.tencent.biz.webviewplugin.OfflinePlugin.9;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class stw
  extends WebViewPlugin
{
  private static boolean aNc;
  static final int apiLevel = Build.VERSION.SDK_INT;
  public static ConcurrentHashMap<String, ArrayList<String>> cy = new ConcurrentHashMap();
  public static HashMap<String, obe> fZ;
  public static HashMap<String, String> ga = new HashMap();
  private static Context mApplicationContext;
  public CopyOnWriteArrayList<String> A;
  TextView AY;
  public volatile long Du = -1L;
  public volatile long Dv = -1L;
  public ProgressBar I;
  private jqh a;
  public sud a;
  public String aGF;
  public String aGG = "";
  public volatile boolean aNd;
  private boolean aNe;
  public boolean aNf;
  public HashSet<String> aq = new HashSet(6);
  private jml authConfig;
  public AtomicInteger av = new AtomicInteger(0);
  public AtomicBoolean bh = new AtomicBoolean(false);
  public volatile int bzc;
  private View.OnClickListener cP = new sub(this);
  protected CopyOnWriteArraySet<String> d;
  public Runnable dC = new OfflinePlugin.9(this);
  boolean ex = false;
  public LinearLayout fz;
  RelativeLayout gc;
  boolean isCheckModel = false;
  boolean isDestroy = false;
  private String mBid;
  private String mBusinessId;
  Handler mCheckupHandler;
  public volatile int mOfflineLoadMode = 0;
  
  public stw()
  {
    this.jdField_a_of_type_Jqh = new suc(this);
    this.mPluginNameSpace = "offline";
  }
  
  public static boolean Nl()
  {
    Integer[] arrayOfInteger = WebAccelerateHelper.getInstance().getWebViewFeatureParams();
    if ((arrayOfInteger != null) && (arrayOfInteger[13].intValue() != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("OfflinePluginQQ", 2, "now enable service worker!");
      }
      return true;
    }
    QLog.e("OfflinePluginQQ", 1, "disable service worker!");
    return false;
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5)
  {
    if (mApplicationContext == null) {
      mApplicationContext = BaseApplicationImpl.getContext();
    }
    if (mApplicationContext != null) {}
    for (int i = jqi.getNetworkType(mApplicationContext);; i = -1)
    {
      String str2 = "";
      String str1 = str2;
      int j;
      if (!TextUtils.isEmpty(paramString3)) {
        if (!paramString3.startsWith("http"))
        {
          str1 = str2;
          if (!paramString3.startsWith("https")) {}
        }
        else
        {
          j = paramString3.indexOf("?");
          if (j == -1) {
            break label118;
          }
        }
      }
      label118:
      for (str1 = paramString3.substring(0, j);; str1 = paramString3)
      {
        anot.b(null, "P_CliOper", "OfflineStatusReport", "", paramString2, paramString1, paramInt1, 1, paramInt2, str1, paramString4, paramString5, String.valueOf(i));
        return;
      }
    }
  }
  
  private WebResourceResponse b(String paramString1, String paramString2)
  {
    String str = jpa.getFilePath(paramString1);
    if ((TextUtils.isEmpty(this.mBusinessId)) || (!paramString2.equals(this.mBusinessId)))
    {
      if (this.d == null) {
        this.d = new CopyOnWriteArraySet();
      }
      if (!this.d.contains(paramString2))
      {
        this.d.add(paramString2);
        if (QLog.isColorLevel()) {
          QLog.i("OfflinePluginQQ", 2, "now begin check ex bid : " + paramString2);
        }
        jqo.le("OfflinePlugin_verifySign_" + paramString2);
        if (!jpa.di(paramString2)) {}
        for (i = 1;; i = 0)
        {
          jqo.lf("OfflinePlugin_verifySign_" + paramString2);
          if (i == 0) {
            break;
          }
          this.d.remove(paramString2);
          if (QLog.isColorLevel()) {
            QLog.d("OfflinePluginQQ", 2, "verfySign fail to reload");
          }
          return null;
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((this.mOfflineLoadMode == 3) || (i != 0))
      {
        jqo.le("OfflinePlugin_verifySingleFile_" + str);
        if (!jpa.C(paramString2, paramString1)) {}
        for (int j = 1;; j = 0)
        {
          jqo.lf("OfflinePlugin_verifySingleFile_" + str);
          if (j == 0) {
            break label315;
          }
          if (i == 0)
          {
            this.aNd = true;
            reloadCurrentUrl();
          }
          a(paramString2, "Offline_InterceptRequest", 0, 3, paramString1, "", "");
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("OfflinePluginQQ", 2, "shouldInterceptRequest verfy single fail to reload");
          return null;
        }
      }
      label315:
      jqo.le("OfflinePlugin_offlineGetResponse_" + str);
      paramString1 = jpa.a(paramString2, paramString1);
      if (paramString1 == null) {}
      for (paramString1 = null;; paramString1 = new WebResourceResponse(paramString1.mime, "utf-8", paramString1.g))
      {
        jqo.lf("OfflinePlugin_offlineGetResponse_" + str);
        if (paramString1 != null)
        {
          this.aNe = true;
          if (i == 0) {
            this.aNf = true;
          }
        }
        return paramString1;
      }
    }
  }
  
  private boolean gf(String paramString)
  {
    paramString = arbl.a(paramString);
    if (paramString != null)
    {
      paramString.egZ();
      if (arbl.ck.get() == 4)
      {
        this.mBusinessId = null;
        this.ex = true;
        return true;
      }
    }
    return false;
  }
  
  private void initHandler()
  {
    this.mCheckupHandler = new sty(this, Looper.getMainLooper());
  }
  
  public static void oy(String paramString)
  {
    cy.remove(paramString);
    paramString = arbl.b(paramString);
    if (paramString != null) {
      paramString.reset();
    }
  }
  
  private void tK(String paramString)
  {
    Object localObject;
    if (this.Dv == -1L)
    {
      localObject = this.mRuntime.getActivity();
      WebViewFragment localWebViewFragment = this.mRuntime.b();
      if (localWebViewFragment == null) {
        break label117;
      }
      localObject = localWebViewFragment.CI();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.aGG = ((String)localObject);
      }
      localObject = jpa.getFilePath(this.aGG);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        if (!((String)localObject).equalsIgnoreCase(paramString)) {
          break label154;
        }
      }
    }
    label154:
    for (long l = System.currentTimeMillis();; l = -1L)
    {
      this.Dv = l;
      if ((QLog.isColorLevel()) && (this.Dv != -1L)) {
        QLog.d("OfflinePluginQQ", 2, "read index offline res!");
      }
      return;
      label117:
      if (!(localObject instanceof ardm.b)) {
        break;
      }
      localObject = ((ardm.b)localObject).CI();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      this.aGG = ((String)localObject);
      break;
    }
  }
  
  public static void tL(String paramString)
  {
    if (cy == null) {
      cy = new ConcurrentHashMap();
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new OfflinePlugin.10(paramString));
  }
  
  private void yj()
  {
    if (this.mRuntime.getActivity() == null) {}
    do
    {
      ViewStub localViewStub;
      do
      {
        return;
        localViewStub = (ViewStub)this.mRuntime.getActivity().findViewById(2131363731);
      } while (localViewStub == null);
      this.gc = ((RelativeLayout)localViewStub.inflate());
    } while (this.gc == null);
    this.AY = ((TextView)this.gc.findViewById(2131368422));
    this.fz = ((LinearLayout)this.gc.findViewById(2131368423));
    this.I = ((ProgressBar)this.gc.findViewById(2131368416));
  }
  
  /* Error */
  public WebResourceResponse a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: getstatic 468	jpa:aR	Ljava/util/concurrent/ConcurrentHashMap;
    //   7: ifnull +40 -> 47
    //   10: getstatic 468	jpa:aR	Ljava/util/concurrent/ConcurrentHashMap;
    //   13: aload_2
    //   14: invokevirtual 471	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   17: ifeq +30 -> 47
    //   20: getstatic 468	jpa:aR	Ljava/util/concurrent/ConcurrentHashMap;
    //   23: aload_2
    //   24: invokevirtual 473	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 211	java/lang/String
    //   30: astore 12
    //   32: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   35: lstore 5
    //   37: aload 12
    //   39: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   42: ifeq +185 -> 227
    //   45: aconst_null
    //   46: areturn
    //   47: new 267	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 268	java/lang/StringBuilder:<init>	()V
    //   54: aload_2
    //   55: invokestatic 478	jpe:dO	(Ljava/lang/String;)Ljava/lang/String;
    //   58: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_2
    //   62: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc_w 480
    //   68: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore 12
    //   76: new 482	java/io/File
    //   79: dup
    //   80: aload 12
    //   82: invokespecial 483	java/io/File:<init>	(Ljava/lang/String;)V
    //   85: invokevirtual 486	java/io/File:exists	()Z
    //   88: istore 11
    //   90: iload 11
    //   92: ifne +5 -> 97
    //   95: aconst_null
    //   96: areturn
    //   97: new 488	java/io/BufferedInputStream
    //   100: dup
    //   101: new 490	java/io/FileInputStream
    //   104: dup
    //   105: aload 12
    //   107: invokespecial 491	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   110: invokespecial 494	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   113: astore 14
    //   115: aload 14
    //   117: astore 12
    //   119: aload 14
    //   121: invokestatic 499	jqj:b	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   124: astore 13
    //   126: aload 14
    //   128: astore 12
    //   130: getstatic 468	jpa:aR	Ljava/util/concurrent/ConcurrentHashMap;
    //   133: aload_2
    //   134: aload 13
    //   136: invokevirtual 503	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   139: pop
    //   140: aload 13
    //   142: astore 12
    //   144: aload 14
    //   146: ifnull -114 -> 32
    //   149: aload 14
    //   151: invokevirtual 506	java/io/BufferedInputStream:close	()V
    //   154: aload 13
    //   156: astore 12
    //   158: goto -126 -> 32
    //   161: astore_1
    //   162: ldc 172
    //   164: iconst_1
    //   165: ldc_w 508
    //   168: aload_1
    //   169: invokestatic 511	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   172: aconst_null
    //   173: areturn
    //   174: astore 15
    //   176: aconst_null
    //   177: astore 14
    //   179: aconst_null
    //   180: astore_2
    //   181: aload 14
    //   183: astore 12
    //   185: ldc 172
    //   187: iconst_1
    //   188: aload 15
    //   190: invokevirtual 514	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   193: invokestatic 183	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aload_2
    //   197: astore 12
    //   199: aload 14
    //   201: ifnull -169 -> 32
    //   204: aload 14
    //   206: invokevirtual 506	java/io/BufferedInputStream:close	()V
    //   209: aload_2
    //   210: astore 12
    //   212: goto -180 -> 32
    //   215: aload 12
    //   217: ifnull +8 -> 225
    //   220: aload 12
    //   222: invokevirtual 506	java/io/BufferedInputStream:close	()V
    //   225: aload_1
    //   226: athrow
    //   227: new 516	org/json/JSONObject
    //   230: dup
    //   231: aload 12
    //   233: invokespecial 517	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   236: astore 12
    //   238: aload_1
    //   239: invokestatic 248	jpa:getFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   242: astore_2
    //   243: aload 12
    //   245: aload_2
    //   246: invokevirtual 520	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   249: astore 12
    //   251: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   254: lstore 7
    //   256: invokestatic 524	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   259: invokevirtual 528	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   262: astore 13
    //   264: aload 13
    //   266: instanceof 530
    //   269: ifeq +46 -> 315
    //   272: aload 13
    //   274: ldc_w 532
    //   277: invokevirtual 538	mqq/app/AppRuntime:getAppRuntime	(Ljava/lang/String;)Lmqq/app/AppRuntime;
    //   280: astore 13
    //   282: aload 13
    //   284: instanceof 540
    //   287: ifeq +19 -> 306
    //   290: aload_0
    //   291: new 542	sud
    //   294: dup
    //   295: aload 13
    //   297: checkcast 540	com/tencent/common/app/AppInterface
    //   300: invokespecial 545	sud:<init>	(Lcom/tencent/common/app/AppInterface;)V
    //   303: putfield 547	stw:jdField_a_of_type_Sud	Lsud;
    //   306: aload_0
    //   307: getfield 547	stw:jdField_a_of_type_Sud	Lsud;
    //   310: ifnonnull +32 -> 342
    //   313: aconst_null
    //   314: areturn
    //   315: aload 13
    //   317: instanceof 540
    //   320: ifeq -14 -> 306
    //   323: aload_0
    //   324: new 542	sud
    //   327: dup
    //   328: aload 13
    //   330: checkcast 540	com/tencent/common/app/AppInterface
    //   333: invokespecial 545	sud:<init>	(Lcom/tencent/common/app/AppInterface;)V
    //   336: putfield 547	stw:jdField_a_of_type_Sud	Lsud;
    //   339: goto -33 -> 306
    //   342: aload_0
    //   343: getfield 547	stw:jdField_a_of_type_Sud	Lsud;
    //   346: aload 12
    //   348: invokevirtual 550	sud:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/OfflineWebRes;
    //   351: astore 12
    //   353: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   356: lstore 9
    //   358: aload 12
    //   360: ifnonnull +5 -> 365
    //   363: aconst_null
    //   364: areturn
    //   365: new 482	java/io/File
    //   368: dup
    //   369: invokestatic 195	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   372: invokevirtual 556	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   375: ldc_w 558
    //   378: invokespecial 561	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   381: astore 13
    //   383: aload 13
    //   385: invokevirtual 486	java/io/File:exists	()Z
    //   388: ifne +13 -> 401
    //   391: aload 13
    //   393: invokevirtual 564	java/io/File:mkdirs	()Z
    //   396: ifne +5 -> 401
    //   399: aconst_null
    //   400: areturn
    //   401: aload_2
    //   402: ldc_w 566
    //   405: invokevirtual 568	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   408: ifeq +155 -> 563
    //   411: ldc_w 570
    //   414: astore_2
    //   415: new 482	java/io/File
    //   418: dup
    //   419: aload 13
    //   421: aload 12
    //   423: getfield 575	com/tencent/mobileqq/data/OfflineWebRes:hashName	Ljava/lang/String;
    //   426: invokespecial 561	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   429: astore 12
    //   431: aload 12
    //   433: invokevirtual 486	java/io/File:exists	()Z
    //   436: ifeq -264 -> 172
    //   439: new 327	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   442: dup
    //   443: aload_2
    //   444: ldc_w 334
    //   447: new 488	java/io/BufferedInputStream
    //   450: dup
    //   451: new 490	java/io/FileInputStream
    //   454: dup
    //   455: aload 12
    //   457: invokespecial 578	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   460: invokespecial 494	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   463: invokespecial 341	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   466: astore_2
    //   467: aload_2
    //   468: ifnull +185 -> 653
    //   471: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   474: ifeq +179 -> 653
    //   477: ldc 172
    //   479: iconst_2
    //   480: new 267	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 268	java/lang/StringBuilder:<init>	()V
    //   487: ldc_w 580
    //   490: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: lload 5
    //   495: lload_3
    //   496: lsub
    //   497: invokevirtual 583	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   500: ldc_w 585
    //   503: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: lload 7
    //   508: lload 5
    //   510: lsub
    //   511: invokevirtual 583	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   514: ldc_w 587
    //   517: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: lload 9
    //   522: lload 7
    //   524: lsub
    //   525: invokevirtual 583	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   528: ldc_w 589
    //   531: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   537: lload_3
    //   538: lsub
    //   539: invokevirtual 583	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   542: ldc_w 591
    //   545: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: aload_1
    //   549: invokestatic 248	jpa:getFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   552: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokestatic 299	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   561: aload_2
    //   562: areturn
    //   563: aload_2
    //   564: ldc_w 593
    //   567: invokevirtual 568	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   570: ifeq +10 -> 580
    //   573: ldc_w 595
    //   576: astore_2
    //   577: goto -162 -> 415
    //   580: aload_2
    //   581: ldc_w 597
    //   584: invokevirtual 568	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   587: ifne +33 -> 620
    //   590: aload_2
    //   591: ldc_w 599
    //   594: invokevirtual 568	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   597: ifne +23 -> 620
    //   600: aload_2
    //   601: ldc_w 601
    //   604: invokevirtual 568	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   607: ifne +13 -> 620
    //   610: aload_2
    //   611: ldc_w 603
    //   614: invokevirtual 568	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   617: ifeq +29 -> 646
    //   620: ldc_w 605
    //   623: astore_2
    //   624: goto -209 -> 415
    //   627: astore_1
    //   628: goto -413 -> 215
    //   631: astore 15
    //   633: aconst_null
    //   634: astore_2
    //   635: goto -454 -> 181
    //   638: astore 15
    //   640: aload 13
    //   642: astore_2
    //   643: goto -462 -> 181
    //   646: ldc_w 607
    //   649: astore_2
    //   650: goto -235 -> 415
    //   653: aload_2
    //   654: areturn
    //   655: astore_1
    //   656: aconst_null
    //   657: astore 12
    //   659: goto -444 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	662	0	this	stw
    //   0	662	1	paramString1	String
    //   0	662	2	paramString2	String
    //   3	535	3	l1	long
    //   35	474	5	l2	long
    //   254	269	7	l3	long
    //   356	165	9	l4	long
    //   88	3	11	bool	boolean
    //   30	628	12	localObject1	Object
    //   124	517	13	localObject2	Object
    //   113	92	14	localBufferedInputStream	BufferedInputStream
    //   174	15	15	localException1	Exception
    //   631	1	15	localException2	Exception
    //   638	1	15	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   0	32	161	java/lang/Exception
    //   32	45	161	java/lang/Exception
    //   47	90	161	java/lang/Exception
    //   149	154	161	java/lang/Exception
    //   204	209	161	java/lang/Exception
    //   220	225	161	java/lang/Exception
    //   225	227	161	java/lang/Exception
    //   227	306	161	java/lang/Exception
    //   306	313	161	java/lang/Exception
    //   315	339	161	java/lang/Exception
    //   342	358	161	java/lang/Exception
    //   365	399	161	java/lang/Exception
    //   401	411	161	java/lang/Exception
    //   415	467	161	java/lang/Exception
    //   471	561	161	java/lang/Exception
    //   563	573	161	java/lang/Exception
    //   580	620	161	java/lang/Exception
    //   97	115	174	java/lang/Exception
    //   119	126	627	finally
    //   130	140	627	finally
    //   185	196	627	finally
    //   119	126	631	java/lang/Exception
    //   130	140	638	java/lang/Exception
    //   97	115	655	finally
  }
  
  public String aZ()
  {
    return this.mBusinessId;
  }
  
  public void ar(JSONObject paramJSONObject)
  {
    if (TextUtils.isEmpty(this.mBid)) {}
    do
    {
      obe localobe;
      Object localObject2;
      int i;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localObject1 = this.mRuntime.getActivity();
            } while (localObject1 == null);
            if (fZ == null) {
              fZ = new HashMap();
            }
          } while ((obe)fZ.get(this.mBid) != null);
          localobe = new obe(this.mBid);
          localobe.a(this.jdField_a_of_type_Jqh);
          localObject2 = paramJSONObject.optJSONObject("wording");
          if (localObject2 != null)
          {
            localobe.aoR = ((JSONObject)localObject2).optString("nonWifiUpdatingText");
            localobe.aoQ = ((JSONObject)localObject2).optString("wifiUpdatingText");
            localobe.aoS = ((JSONObject)localObject2).optString("updateCompletedText");
          }
          localobe.aoT = ((Activity)localObject1).getResources().getString(2131698322);
          fZ.put(this.mBid, localobe);
          localObject2 = paramJSONObject.optString("url");
          localobe.mDownloadUrl = ((String)localObject2);
          i = paramJSONObject.optInt("filesize");
          localobe.aCy = i;
          if (this.fz != null) {
            this.fz.setOnClickListener(this.cP);
          }
          if (!aqiw.isWifiConnected(((Activity)localObject1).getApplicationContext())) {
            break;
          }
          localobe.aoT = localobe.aoQ;
          paramJSONObject = localobe.aoT;
        } while ((TextUtils.isEmpty((CharSequence)localObject2)) || (i <= 0));
        yj();
        localobe.setStatus(1);
        if (this.AY != null) {
          this.AY.setText(paramJSONObject + "0%");
        }
        if (this.fz != null) {
          this.fz.setVisibility(0);
        }
        if (this.I != null) {
          this.I.setProgress(0);
        }
        if (this.I != null) {
          this.I.setVisibility(0);
        }
        if (this.gc != null) {
          this.gc.setVisibility(0);
        }
        jpa.a(((Activity)localObject1).getApplicationContext(), this.mBid, (String)localObject2, i, localobe);
        this.mCheckupHandler.postDelayed(this.dC, 2000L);
        return;
        paramJSONObject = localobe.aoR;
      } while ((TextUtils.isEmpty((CharSequence)localObject2)) || (i <= 0));
      yj();
      localobe.setStatus(0);
      Object localObject1 = ((Activity)localObject1).getResources().getDrawable(2130845944);
      ((Drawable)localObject1).setBounds(0, 0, 40, 40);
      if (this.AY != null) {
        this.AY.setCompoundDrawables((Drawable)localObject1, null, null, null);
      }
      if (this.AY != null) {
        this.AY.setText(paramJSONObject);
      }
      if (this.gc != null) {
        this.gc.setVisibility(0);
      }
      if (this.fz != null) {
        this.fz.setVisibility(0);
      }
    } while (this.I == null);
    this.I.setProgress(0);
  }
  
  @TargetApi(11)
  public void bAL()
  {
    CustomWebView localCustomWebView = this.mRuntime.getWebView();
    if (localCustomWebView == null) {}
    label14:
    String str1;
    String str2;
    do
    {
      do
      {
        do
        {
          break label14;
          do
          {
            return;
          } while (localCustomWebView.getX5WebViewExtension() == null);
          str1 = localCustomWebView.getUrl();
        } while (TextUtils.isEmpty(str1));
        localObject = Uri.parse(str1);
        if ((localObject == null) || (!((Uri)localObject).isHierarchical())) {
          break;
        }
        str2 = ((Uri)localObject).getQueryParameter("_sw");
        if (("1".equals(str2)) || ("0".equals(str2))) {
          break label156;
        }
      } while (!QLog.isColorLevel());
      QLog.i("OfflinePluginQQ", 2, "url doesn't support ServiceWorker! " + jqo.filterKeyForLog(str1, new String[0]));
      return;
    } while (!QLog.isColorLevel());
    QLog.i("OfflinePluginQQ", 2, "url is illegal! " + str1);
    return;
    label156:
    int i = str1.indexOf("?");
    Object localObject = str1;
    if (i != -1) {
      localObject = str1.substring(0, i);
    }
    ThreadManager.post(new OfflinePlugin.6(this, (String)localObject, str2, localCustomWebView), 8, null, false);
  }
  
  public void bAM()
  {
    if ((fZ != null) && (!TextUtils.isEmpty(this.mBid)))
    {
      obe localobe = (obe)fZ.get(this.mBid);
      if (localobe != null) {
        localobe.doRefresh();
      }
    }
    reloadCurrentUrl();
  }
  
  public void bE(String paramString, int paramInt)
  {
    this.mOfflineLoadMode = paramInt;
    this.Du = System.currentTimeMillis();
    Object localObject = this.mRuntime.b();
    if ((localObject != null) && (((WebViewFragment)localObject).a != null))
    {
      localObject = ((WebViewFragment)localObject).a;
      if (paramInt == 0) {
        break label155;
      }
    }
    label155:
    for (boolean bool = true;; bool = false)
    {
      ((arbz)localObject).buI = bool;
      if (!TextUtils.isEmpty(this.mBusinessId))
      {
        if (QLog.isColorLevel()) {
          QLog.i("OfflinePluginQQ", 2, "OfflinePlugin handleSchemaRequest loadMode: " + this.mOfflineLoadMode + ", bid: " + this.mBusinessId + ", cost: " + this.bzc);
        }
        checkOfflineUp(paramString);
        a(this.mBusinessId, "Offline_Check", this.bzc, 2, paramString, String.valueOf(this.mOfflineLoadMode), "");
      }
      return;
    }
  }
  
  protected void checkOfflineUp(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflinePluginQQ", 2, "-->offline:checkOfflineUp,url=" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    while (!isCheckUpByNative(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("OfflinePluginQQ", 2, "-->offline:checkOfflineUp.");
    }
    jpa.a(paramString, this.mRuntime.a(), new stx(this));
  }
  
  public void checkOfflineUpNotCallback(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!isCheckUpByNative(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("OfflinePluginQQ", 2, "checkOfflineUpNotCallback.");
    }
    jpa.a(paramString, this.mRuntime.a());
  }
  
  protected String checkOfflineUrl(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflinePluginQQ", 2, "-->offlien:checkOfflineUrl");
    }
    if ((TextUtils.isEmpty(paramString)) || (!Uri.parse(paramString).isHierarchical())) {}
    for (;;)
    {
      return paramString;
      try
      {
        this.mBusinessId = Uri.parse(paramString).getQueryParameter("_bid");
        if (this.mBid == null) {
          this.mBid = this.mBusinessId;
        }
        if ((TextUtils.isEmpty(this.mBusinessId)) && (this.authConfig != null))
        {
          this.mBusinessId = this.authConfig.dF(paramString);
          if (this.mBid == null) {
            this.mBid = this.mBusinessId;
          }
          if (!TextUtils.isEmpty(this.mBusinessId))
          {
            String str1 = jpa.r(paramString, "_bid=" + this.mBusinessId);
            if (gf(str1)) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.i("OfflinePluginQQ", 2, "-->offline:checkOfflineUrl:" + jqo.filterKeyForLog(str1, new String[0]));
            }
            return str1;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          continue;
          String str2 = paramString;
        }
      }
    }
  }
  
  public String gM(String paramString)
  {
    String str = jpe.dO(paramString);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return str + paramString + "/";
  }
  
  public Object handleEvent(String paramString, long paramLong)
  {
    if (paramLong == 8L) {
      return shouldInterceptRequest(paramString);
    }
    return null;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 2L)
    {
      if (this.mRuntime == null)
      {
        QLog.e("OfflinePluginQQ", 1, "handleEvent error mRuntime == null");
        return false;
      }
      paramString = this.mRuntime.getActivity();
      paramMap = this.mRuntime.a(this.mRuntime.getActivity());
      if ((paramMap == null) || (!(paramMap instanceof ardm.c))) {
        return false;
      }
      if (this.gc != null) {
        this.gc.setVisibility(8);
      }
      if ((fZ != null) && (!TextUtils.isEmpty(this.mBid)))
      {
        paramMap = (obe)fZ.get(this.mBid);
        if (paramMap != null)
        {
          yj();
          paramMap.a(this.jdField_a_of_type_Jqh);
          if (this.gc != null) {
            this.gc.setVisibility(0);
          }
          if (this.fz != null) {
            this.fz.setOnClickListener(this.cP);
          }
          switch (paramMap.getStatus())
          {
          }
        }
      }
    }
    arcm.a locala;
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return false;
            if (this.AY != null) {
              this.AY.setText(paramMap.aoT + paramMap.getProgress() + "%");
            }
            if (this.I != null) {
              this.I.setVisibility(0);
            }
            if (this.fz != null)
            {
              this.fz.setVisibility(0);
              continue;
              if (this.I != null) {
                this.I.setProgress(paramMap.getProgress());
              }
              if (this.I != null) {
                this.I.setVisibility(0);
              }
              if (this.fz != null)
              {
                this.fz.setVisibility(8);
                continue;
                if (this.AY != null) {
                  this.AY.setText(paramMap.aoS);
                }
                if (paramString == null) {
                  return false;
                }
                paramString = paramString.getResources().getDrawable(2130839626);
                paramString.setBounds(0, 0, paramString.getMinimumWidth(), paramString.getMinimumHeight());
                if (this.AY != null) {
                  this.AY.setCompoundDrawables(paramString, null, null, null);
                }
                if (this.I != null) {
                  this.I.setVisibility(8);
                }
                if (this.fz != null)
                {
                  this.fz.setVisibility(0);
                  continue;
                  if (this.gc != null)
                  {
                    this.gc.setVisibility(8);
                    continue;
                    if (this.AY != null) {
                      this.AY.setText(paramMap.aoR);
                    }
                    if (paramString == null) {
                      return false;
                    }
                    paramString = paramString.getResources().getDrawable(2130845944);
                    paramString.setBounds(0, 0, 40, 40);
                    if (this.AY != null) {
                      this.AY.setCompoundDrawables(paramString, null, null, null);
                    }
                    if (this.I != null) {
                      this.I.setVisibility(0);
                    }
                    if (this.fz != null)
                    {
                      this.fz.setVisibility(0);
                      continue;
                      if (paramLong == 8589934594L)
                      {
                        this.bh.set(true);
                        ThreadManager.post(new OfflinePlugin.5(this), 5, null, false);
                        if (this.jdField_a_of_type_Sud != null) {
                          this.jdField_a_of_type_Sud.yQ(5);
                        }
                      }
                      else
                      {
                        if (paramLong != 8589934601L) {
                          break;
                        }
                        if (this.jdField_a_of_type_Sud != null) {
                          this.jdField_a_of_type_Sud.yQ(0);
                        }
                        bAL();
                      }
                    }
                  }
                }
              }
            }
          }
        } while (paramLong != 32L);
        if (this.mRuntime == null) {
          return false;
        }
        paramMap = this.mRuntime.getWebView();
      } while (paramMap.getX5WebViewExtension() == null);
      locala = arcm.a(paramString);
    } while ((locala == null) || (TextUtils.isEmpty(locala.data)));
    handleSchemaRequest(paramString, arcp.getSchemeFromUrl(paramString));
    paramMap.loadDataWithBaseURL(paramString, locala.data, "text/html", "utf-8", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("OfflinePluginQQ", 2, "load offline data cache on loadUrl");
    }
    return true;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    Object localObject = null;
    paramString1 = null;
    int i = 0;
    if ("offline".equals(paramString2))
    {
      if (("clearCache".equals(paramString3)) && (paramVarArgs.length > 0)) {
        paramJsBridgeListener = paramString1;
      }
      do
      {
        do
        {
          do
          {
            try
            {
              paramString3 = new JSONObject(paramVarArgs[0]);
              paramJsBridgeListener = paramString1;
              paramString2 = paramString3.optString("bid");
              paramJsBridgeListener = paramString1;
              paramString1 = paramString3.optString("callback");
              paramJsBridgeListener = paramString1;
              jpa.e(this.mRuntime.getActivity(), paramString2, 1);
              paramJsBridgeListener = paramString1;
              paramString2 = new JSONObject();
              paramJsBridgeListener = paramString1;
              paramString2.put("retcode", 0);
              paramJsBridgeListener = paramString1;
              paramString2.put("msg", "ok");
              paramJsBridgeListener = paramString1;
              callJs(paramString1, new String[] { paramString2.toString() });
            }
            catch (JSONException paramString1)
            {
              do
              {
                if (QLog.isColorLevel()) {
                  QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, clearCache, JSONException :" + paramString1);
                }
                try
                {
                  paramString1 = new JSONObject();
                  paramString1.put("retcode", -1);
                  paramString1.put("msg", "error");
                  callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
                  return true;
                }
                catch (JSONException paramJsBridgeListener) {}
              } while (!QLog.isColorLevel());
              QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, clearCache, JSONException :" + paramJsBridgeListener);
              return true;
            }
            return true;
            if (!"disableCache".equals(paramString3)) {
              break;
            }
            paramJsBridgeListener = localObject;
            try
            {
              paramString1 = new JSONObject(paramVarArgs[0]).optString("callback");
              paramJsBridgeListener = paramString1;
              aNc = true;
              paramJsBridgeListener = paramString1;
              paramString2 = new JSONObject();
              paramJsBridgeListener = paramString1;
              paramString2.put("retcode", 0);
              paramJsBridgeListener = paramString1;
              paramString2.put("msg", "ok");
              paramJsBridgeListener = paramString1;
              callJs(paramString1, new String[] { paramString2.toString() });
              return true;
            }
            catch (JSONException paramString1)
            {
              if (QLog.isColorLevel()) {
                QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, disableCache, JSONException :" + paramString1);
              }
              try
              {
                paramString1 = new JSONObject();
                paramString1.put("retcode", -1);
                paramString1.put("msg", "error");
                callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
                return true;
              }
              catch (JSONException paramJsBridgeListener) {}
            }
          } while (!QLog.isColorLevel());
          QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, disableCache, JSONException :" + paramJsBridgeListener);
          return true;
        } while ((!"batchCheckUpdate".equals(paramString3)) || (paramVarArgs.length <= 0));
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramString1 = paramString2.optJSONArray("bids");
          this.aGF = paramString2.optString("callback");
          int j = paramString1.length();
          paramString2 = new ArrayList(j);
          while (i < j)
          {
            paramString2.add(paramString1.optString(i));
            i += 1;
          }
          jpa.a(paramString2, this.mRuntime.a(), new stz(this, paramJsBridgeListener), true, false);
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, batchCheckUpdate, JSONException :" + paramJsBridgeListener);
          }
          try
          {
            paramJsBridgeListener = new JSONObject();
            paramJsBridgeListener.put("retcode", -1);
            paramJsBridgeListener.put("msg", "error");
            callJs(this.aGF, new String[] { paramJsBridgeListener.toString() });
            return true;
          }
          catch (JSONException paramJsBridgeListener) {}
        }
      } while (!QLog.isColorLevel());
      QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, batchCheckUpdate, JSONException :" + paramJsBridgeListener);
      return true;
    }
    return false;
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if ((!paramString2.equals("http")) && (!paramString2.equals("https"))) {
      return false;
    }
    paramString1 = checkOfflineUrl(paramString1);
    long l = System.currentTimeMillis();
    paramString2 = arbl.a(paramString1);
    if ((paramString2 != null) && (!paramString2.isReady()))
    {
      paramString2.a(new sua(this, l, paramString1), paramString1);
      return true;
    }
    if (paramString2 != null) {}
    for (int i = paramString2.cj.get();; i = 0)
    {
      bE(paramString1, i);
      return false;
    }
  }
  
  protected boolean isCheckUpByNative(String paramString)
  {
    String str3 = "0";
    try
    {
      str1 = Uri.parse(paramString).getQueryParameter("_duck");
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          str3 = Uri.parse(paramString).getQueryParameter("_discheck");
          String str1 = str3;
          if (TextUtils.isEmpty(str3)) {
            str1 = this.authConfig.dG(paramString);
          }
          if ((TextUtils.isEmpty(str1)) || (!str1.equals("1"))) {
            break;
          }
          if (QLog.isDevelopLevel()) {
            QLog.e("webviewLoadUrl", 4, "1 checkOfflineUp _duck=1");
          }
          if (QLog.isColorLevel()) {
            QLog.d("OfflineCheck", 2, "has discheck " + paramString);
          }
          return false;
          localException1 = localException1;
          str2 = str3;
          if (QLog.isColorLevel())
          {
            QLog.e("QQBrowserActivity", 2, "checkOfflineUpr:url parse exception:" + jqo.filterKeyForLog(paramString, new String[0]));
            str2 = str3;
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          String str2;
          Object localObject = str2;
          if (QLog.isColorLevel())
          {
            QLog.e("QQBrowserActivity", 2, "checkOfflineUpr:url parse exception:" + jqo.filterKeyForLog(paramString, new String[0]));
            localObject = str2;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("OfflineCheck", 2, "no discheck " + paramString);
        }
      }
    }
    return true;
  }
  
  public void onAppRuntimeReady(AppInterface paramAppInterface)
  {
    this.authConfig = jml.a();
    initHandler();
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    this.isDestroy = true;
    if ((fZ != null) && (!TextUtils.isEmpty(this.mBid)))
    {
      obe localobe = (obe)fZ.get(this.mBid);
      if (localobe != null)
      {
        localobe.b(this.jdField_a_of_type_Jqh);
        if (localobe.getObserverCount() == 0) {
          fZ.remove(this.mBid);
        }
      }
      if (fZ.size() == 0) {
        fZ = null;
      }
    }
  }
  
  protected void reloadCurrentUrl()
  {
    if (this.mRuntime.getActivity() == null) {}
    do
    {
      aqzv localaqzv;
      CustomWebView localCustomWebView;
      do
      {
        do
        {
          return;
          localaqzv = this.mRuntime.a(this.mRuntime.getActivity());
        } while ((localaqzv == null) || (!(localaqzv instanceof ardm.o)));
        localCustomWebView = this.mRuntime.getWebView();
      } while (localCustomWebView == null);
      localCustomWebView.loadUrl(((ardm.o)localaqzv).getCurrentUrl());
    } while (!QLog.isColorLevel());
    QLog.i("OfflinePluginQQ", 2, "reloadCurrentUrl");
  }
  
  public WebResourceResponse shouldInterceptRequest(String paramString)
  {
    if (AppSetting.aNT) {
      return null;
    }
    if ((this.ex) || (TextUtils.isEmpty(paramString)) || (!paramString.startsWith("http"))) {
      return null;
    }
    String str1 = Uri.parse(paramString).getQueryParameter("_bid");
    if (TextUtils.isEmpty(str1)) {
      str1 = this.mBusinessId;
    }
    for (;;)
    {
      Object localObject1 = arcm.a(paramString);
      if ((localObject1 != null) && (!TextUtils.isEmpty(((arcm.a)localObject1).data)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("OfflinePluginQQ", 2, "load offline data cache on loadRes");
        }
        this.aq.add(str1);
        return new WebResourceResponse(((arcm.a)localObject1).mime, ((arcm.a)localObject1).encoding, new BufferedInputStream(new ByteArrayInputStream(((arcm.a)localObject1).data.getBytes())));
      }
      try
      {
        if (TextUtils.isEmpty(str1)) {
          return null;
        }
        if (!str1.equals(this.mBusinessId))
        {
          if (this.bh.get()) {
            break label218;
          }
          if (this.A == null) {
            this.A = new CopyOnWriteArrayList();
          }
          if (!this.A.contains(paramString)) {
            this.A.add(paramString);
          }
        }
        for (;;)
        {
          localObject1 = jpe.dO(str1);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          return null;
          label218:
          checkOfflineUpNotCallback(paramString);
        }
        localObject1 = (String)localObject1 + str1 + File.separator;
      }
      catch (Exception paramString)
      {
        QLog.e("OfflinePluginQQ", 1, "OfflinePlugin shouldInterceptRequest got Exception", paramString);
        return null;
      }
      String str2 = jpa.getFilePath(paramString);
      if (str1.equals(this.mBusinessId))
      {
        localObject2 = (ArrayList)cy.get(str1);
        if ((localObject2 == null) || (((ArrayList)localObject2).size() <= 0)) {
          break;
        }
        if (!((ArrayList)localObject2).contains((String)localObject1 + str2)) {
          return null;
        }
      }
      Object localObject2 = a(paramString, str1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = b(paramString, str1);
      }
      if (localObject1 != null)
      {
        if (str1.equals(this.mBusinessId)) {
          this.aNf = true;
        }
        Map localMap = ((WebResourceResponse)localObject1).getResponseHeaders();
        localObject2 = localMap;
        if (localMap == null) {
          localObject2 = new HashMap();
        }
        ((Map)localObject2).put("Access-Control-Allow-Origin", "*");
        ((WebResourceResponse)localObject1).setResponseHeaders((Map)localObject2);
        sud.tM(paramString);
        tK(str2);
      }
      if (localObject1 != null)
      {
        QLog.d("OfflinePluginQQ", 2, "Url(" + paramString + ") uses the offline res");
        this.aq.add(str1);
        return localObject1;
      }
      QLog.d("OfflinePluginQQ", 2, "Url(" + paramString + ") does not  use the offline res");
      return localObject1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     stw
 * JD-Core Version:    0.7.0.1
 */