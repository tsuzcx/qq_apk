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

public class xce
  extends WebViewPlugin
{
  static final int jdField_a_of_type_Int = Build.VERSION.SDK_INT;
  private static Context jdField_a_of_type_AndroidContentContext;
  public static HashMap<String, rrs> a;
  public static ConcurrentHashMap<String, ArrayList<String>> a;
  public static HashMap<String, String> b;
  private static boolean f;
  public volatile long a;
  Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new xcj(this);
  public LinearLayout a;
  public ProgressBar a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public Runnable a;
  public String a;
  public HashSet<String> a;
  public CopyOnWriteArrayList<String> a;
  protected CopyOnWriteArraySet<String> a;
  public AtomicBoolean a;
  public AtomicInteger a;
  private mkw jdField_a_of_type_Mkw;
  private mpp jdField_a_of_type_Mpp = new xck(this);
  public xcl a;
  boolean jdField_a_of_type_Boolean = false;
  public volatile int b;
  public volatile long b;
  public String b;
  boolean b;
  public volatile int c;
  private String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  private String d;
  public volatile boolean d;
  public boolean e;
  private boolean g;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public xce()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet(6);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangRunnable = new OfflinePlugin.9(this);
    this.mPluginNameSpace = "offline";
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5)
  {
    if (jdField_a_of_type_AndroidContentContext == null) {
      jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
    }
    if (jdField_a_of_type_AndroidContentContext != null) {}
    for (int i = mpq.a(jdField_a_of_type_AndroidContentContext);; i = -1)
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
        awqx.b(null, "P_CliOper", "OfflineStatusReport", "", paramString2, paramString1, paramInt1, 1, paramInt2, str1, paramString4, paramString5, String.valueOf(i));
        return;
      }
    }
  }
  
  public static boolean a()
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
  
  private WebResourceResponse b(String paramString1, String paramString2)
  {
    String str = mof.d(paramString1);
    if ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || (!paramString2.equals(this.jdField_c_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet == null) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
      }
      if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.contains(paramString2))
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramString2);
        if (QLog.isColorLevel()) {
          QLog.i("OfflinePluginQQ", 2, "now begin check ex bid : " + paramString2);
        }
        mpw.a("OfflinePlugin_verifySign_" + paramString2);
        if (!mof.c(paramString2)) {}
        for (i = 1;; i = 0)
        {
          mpw.b("OfflinePlugin_verifySign_" + paramString2);
          if (i == 0) {
            break;
          }
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramString2);
          if (QLog.isColorLevel()) {
            QLog.d("OfflinePluginQQ", 2, "verfySign fail to reload");
          }
          return null;
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((this.jdField_b_of_type_Int == 3) || (i != 0))
      {
        mpw.a("OfflinePlugin_verifySingleFile_" + str);
        if (!mof.a(paramString2, paramString1)) {}
        for (int j = 1;; j = 0)
        {
          mpw.b("OfflinePlugin_verifySingleFile_" + str);
          if (j == 0) {
            break label312;
          }
          if (i == 0)
          {
            this.jdField_d_of_type_Boolean = true;
            c();
          }
          a(paramString2, "Offline_InterceptRequest", 0, 3, paramString1, "", "");
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("OfflinePluginQQ", 2, "shouldInterceptRequest verfy single fail to reload");
          return null;
        }
      }
      label312:
      mpw.a("OfflinePlugin_offlineGetResponse_" + str);
      paramString1 = mof.a(paramString2, paramString1);
      if (paramString1 == null) {}
      for (paramString1 = null;; paramString1 = new WebResourceResponse(paramString1.jdField_a_of_type_JavaLangString, "utf-8", paramString1.jdField_a_of_type_JavaIoInputStream))
      {
        mpw.b("OfflinePlugin_offlineGetResponse_" + str);
        if (paramString1 != null)
        {
          this.g = true;
          if (i == 0) {
            this.e = true;
          }
        }
        return paramString1;
      }
    }
  }
  
  private boolean b(String paramString)
  {
    paramString = bbbk.a(paramString);
    if (paramString != null)
    {
      paramString.b();
      if (bbbk.c.get() == 4)
      {
        this.jdField_c_of_type_JavaLangString = null;
        this.jdField_c_of_type_Boolean = true;
        return true;
      }
    }
    return false;
  }
  
  public static void c(String paramString)
  {
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new OfflinePlugin.10(paramString));
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidOsHandler = new xcg(this, Looper.getMainLooper());
  }
  
  public static void d(String paramString)
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    paramString = bbbk.b(paramString);
    if (paramString != null) {
      paramString.c();
    }
  }
  
  private void e()
  {
    if (this.mRuntime.a() == null) {}
    do
    {
      ViewStub localViewStub;
      do
      {
        return;
        localViewStub = (ViewStub)this.mRuntime.a().findViewById(2131297875);
      } while (localViewStub == null);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localViewStub.inflate());
    } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131301812));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131301813));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131301805));
  }
  
  private void e(String paramString)
  {
    Object localObject;
    if (this.jdField_b_of_type_Long == -1L)
    {
      localObject = this.mRuntime.a();
      WebViewFragment localWebViewFragment = this.mRuntime.a();
      if (localWebViewFragment == null) {
        break label117;
      }
      localObject = localWebViewFragment.c();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.jdField_b_of_type_JavaLangString = ((String)localObject);
      }
      localObject = mof.d(this.jdField_b_of_type_JavaLangString);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        if (!((String)localObject).equalsIgnoreCase(paramString)) {
          break label154;
        }
      }
    }
    label154:
    for (long l = System.currentTimeMillis();; l = -1L)
    {
      this.jdField_b_of_type_Long = l;
      if ((QLog.isColorLevel()) && (this.jdField_b_of_type_Long != -1L)) {
        QLog.d("OfflinePluginQQ", 2, "read index offline res!");
      }
      return;
      label117:
      if (!(localObject instanceof bbei)) {
        break;
      }
      localObject = ((bbei)localObject).c();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      this.jdField_b_of_type_JavaLangString = ((String)localObject);
      break;
    }
  }
  
  public WebResourceResponse a(String paramString)
  {
    if (AppSetting.f) {
      return null;
    }
    if ((this.jdField_c_of_type_Boolean) || (TextUtils.isEmpty(paramString)) || (!paramString.startsWith("http"))) {
      return null;
    }
    String str1 = Uri.parse(paramString).getQueryParameter("_bid");
    if (TextUtils.isEmpty(str1)) {
      str1 = this.jdField_c_of_type_JavaLangString;
    }
    for (;;)
    {
      Object localObject1 = bbcx.a(paramString);
      if ((localObject1 != null) && (!TextUtils.isEmpty(((bbcy)localObject1).jdField_b_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("OfflinePluginQQ", 2, "load offline data cache on loadRes");
        }
        this.jdField_a_of_type_JavaUtilHashSet.add(str1);
        return new WebResourceResponse(((bbcy)localObject1).jdField_a_of_type_JavaLangString, ((bbcy)localObject1).jdField_c_of_type_JavaLangString, new BufferedInputStream(new ByteArrayInputStream(((bbcy)localObject1).jdField_b_of_type_JavaLangString.getBytes())));
      }
      try
      {
        if (TextUtils.isEmpty(str1)) {
          return null;
        }
        if (!str1.equals(this.jdField_c_of_type_JavaLangString))
        {
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            break label218;
          }
          if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) {
            this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
          }
          if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramString)) {
            this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramString);
          }
        }
        for (;;)
        {
          localObject1 = mol.a(str1);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          return null;
          label218:
          b(paramString);
        }
        localObject1 = (String)localObject1 + str1 + File.separator;
      }
      catch (Exception paramString)
      {
        QLog.e("OfflinePluginQQ", 1, "OfflinePlugin shouldInterceptRequest got Exception", paramString);
        return null;
      }
      String str2 = mof.d(paramString);
      if (str1.equals(this.jdField_c_of_type_JavaLangString))
      {
        localObject2 = (ArrayList)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str1);
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
        if (str1.equals(this.jdField_c_of_type_JavaLangString)) {
          this.e = true;
        }
        Map localMap = ((WebResourceResponse)localObject1).getResponseHeaders();
        localObject2 = localMap;
        if (localMap == null) {
          localObject2 = new HashMap();
        }
        ((Map)localObject2).put("Access-Control-Allow-Origin", "*");
        ((WebResourceResponse)localObject1).setResponseHeaders((Map)localObject2);
        xcl.a(paramString);
        e(str2);
      }
      if (localObject1 != null)
      {
        QLog.d("OfflinePluginQQ", 2, "Url(" + paramString + ") uses the offline res");
        this.jdField_a_of_type_JavaUtilHashSet.add(str1);
        return localObject1;
      }
      QLog.d("OfflinePluginQQ", 2, "Url(" + paramString + ") does not  use the offline res");
      return localObject1;
    }
    return null;
  }
  
  /* Error */
  public WebResourceResponse a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 408	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: getstatic 524	mof:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   7: ifnull +40 -> 47
    //   10: getstatic 524	mof:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   13: aload_2
    //   14: invokevirtual 527	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   17: ifeq +30 -> 47
    //   20: getstatic 524	mof:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   23: aload_2
    //   24: invokevirtual 484	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 148	java/lang/String
    //   30: astore 12
    //   32: invokestatic 408	java/lang/System:currentTimeMillis	()J
    //   35: lstore 5
    //   37: aload 12
    //   39: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   42: ifeq +185 -> 227
    //   45: aconst_null
    //   46: areturn
    //   47: new 236	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   54: aload_2
    //   55: invokestatic 471	mol:a	(Ljava/lang/String;)Ljava/lang/String;
    //   58: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_2
    //   62: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc_w 529
    //   68: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore 12
    //   76: new 479	java/io/File
    //   79: dup
    //   80: aload 12
    //   82: invokespecial 530	java/io/File:<init>	(Ljava/lang/String;)V
    //   85: invokevirtual 533	java/io/File:exists	()Z
    //   88: istore 11
    //   90: iload 11
    //   92: ifne +5 -> 97
    //   95: aconst_null
    //   96: areturn
    //   97: new 446	java/io/BufferedInputStream
    //   100: dup
    //   101: new 535	java/io/FileInputStream
    //   104: dup
    //   105: aload 12
    //   107: invokespecial 536	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   110: invokespecial 458	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   113: astore 14
    //   115: aload 14
    //   117: astore 12
    //   119: aload 14
    //   121: invokestatic 541	mpr:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   124: astore 13
    //   126: aload 14
    //   128: astore 12
    //   130: getstatic 524	mof:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   133: aload_2
    //   134: aload 13
    //   136: invokevirtual 542	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   139: pop
    //   140: aload 13
    //   142: astore 12
    //   144: aload 14
    //   146: ifnull -114 -> 32
    //   149: aload 14
    //   151: invokevirtual 545	java/io/BufferedInputStream:close	()V
    //   154: aload 13
    //   156: astore 12
    //   158: goto -126 -> 32
    //   161: astore_1
    //   162: ldc 201
    //   164: iconst_1
    //   165: ldc_w 547
    //   168: aload_1
    //   169: invokestatic 477	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   172: aconst_null
    //   173: areturn
    //   174: astore 15
    //   176: aconst_null
    //   177: astore 14
    //   179: aconst_null
    //   180: astore_2
    //   181: aload 14
    //   183: astore 12
    //   185: ldc 201
    //   187: iconst_1
    //   188: aload 15
    //   190: invokevirtual 550	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   193: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aload_2
    //   197: astore 12
    //   199: aload 14
    //   201: ifnull -169 -> 32
    //   204: aload 14
    //   206: invokevirtual 545	java/io/BufferedInputStream:close	()V
    //   209: aload_2
    //   210: astore 12
    //   212: goto -180 -> 32
    //   215: aload 12
    //   217: ifnull +8 -> 225
    //   220: aload 12
    //   222: invokevirtual 545	java/io/BufferedInputStream:close	()V
    //   225: aload_1
    //   226: athrow
    //   227: new 552	org/json/JSONObject
    //   230: dup
    //   231: aload 12
    //   233: invokespecial 553	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   236: astore 12
    //   238: aload_1
    //   239: invokestatic 217	mof:d	(Ljava/lang/String;)Ljava/lang/String;
    //   242: astore_2
    //   243: aload 12
    //   245: aload_2
    //   246: invokevirtual 556	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   249: astore 12
    //   251: invokestatic 408	java/lang/System:currentTimeMillis	()J
    //   254: lstore 7
    //   256: invokestatic 560	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   259: invokevirtual 564	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   262: astore 13
    //   264: aload 13
    //   266: instanceof 566
    //   269: ifeq +46 -> 315
    //   272: aload 13
    //   274: ldc_w 568
    //   277: invokevirtual 574	mqq/app/AppRuntime:getAppRuntime	(Ljava/lang/String;)Lmqq/app/AppRuntime;
    //   280: astore 13
    //   282: aload 13
    //   284: instanceof 576
    //   287: ifeq +19 -> 306
    //   290: aload_0
    //   291: new 514	xcl
    //   294: dup
    //   295: aload 13
    //   297: checkcast 576	com/tencent/common/app/AppInterface
    //   300: invokespecial 579	xcl:<init>	(Lcom/tencent/common/app/AppInterface;)V
    //   303: putfield 581	xce:jdField_a_of_type_Xcl	Lxcl;
    //   306: aload_0
    //   307: getfield 581	xce:jdField_a_of_type_Xcl	Lxcl;
    //   310: ifnonnull +32 -> 342
    //   313: aconst_null
    //   314: areturn
    //   315: aload 13
    //   317: instanceof 576
    //   320: ifeq -14 -> 306
    //   323: aload_0
    //   324: new 514	xcl
    //   327: dup
    //   328: aload 13
    //   330: checkcast 576	com/tencent/common/app/AppInterface
    //   333: invokespecial 579	xcl:<init>	(Lcom/tencent/common/app/AppInterface;)V
    //   336: putfield 581	xce:jdField_a_of_type_Xcl	Lxcl;
    //   339: goto -33 -> 306
    //   342: aload_0
    //   343: getfield 581	xce:jdField_a_of_type_Xcl	Lxcl;
    //   346: aload 12
    //   348: invokevirtual 584	xcl:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/OfflineWebRes;
    //   351: astore 12
    //   353: invokestatic 408	java/lang/System:currentTimeMillis	()J
    //   356: lstore 9
    //   358: aload 12
    //   360: ifnonnull +5 -> 365
    //   363: aconst_null
    //   364: areturn
    //   365: new 479	java/io/File
    //   368: dup
    //   369: invokestatic 133	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   372: invokevirtual 590	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   375: ldc_w 592
    //   378: invokespecial 595	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   381: astore 13
    //   383: aload 13
    //   385: invokevirtual 533	java/io/File:exists	()Z
    //   388: ifne +13 -> 401
    //   391: aload 13
    //   393: invokevirtual 598	java/io/File:mkdirs	()Z
    //   396: ifne +5 -> 401
    //   399: aconst_null
    //   400: areturn
    //   401: aload_2
    //   402: ldc_w 600
    //   405: invokevirtual 602	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   408: ifeq +155 -> 563
    //   411: ldc_w 604
    //   414: astore_2
    //   415: new 479	java/io/File
    //   418: dup
    //   419: aload 13
    //   421: aload 12
    //   423: getfield 609	com/tencent/mobileqq/data/OfflineWebRes:hashName	Ljava/lang/String;
    //   426: invokespecial 595	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   429: astore 12
    //   431: aload 12
    //   433: invokevirtual 533	java/io/File:exists	()Z
    //   436: ifeq -264 -> 172
    //   439: new 291	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   442: dup
    //   443: aload_2
    //   444: ldc_w 297
    //   447: new 446	java/io/BufferedInputStream
    //   450: dup
    //   451: new 535	java/io/FileInputStream
    //   454: dup
    //   455: aload 12
    //   457: invokespecial 612	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   460: invokespecial 458	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   463: invokespecial 303	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   466: astore_2
    //   467: aload_2
    //   468: ifnull +185 -> 653
    //   471: invokestatic 199	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   474: ifeq +179 -> 653
    //   477: ldc 201
    //   479: iconst_2
    //   480: new 236	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   487: ldc_w 614
    //   490: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: lload 5
    //   495: lload_3
    //   496: lsub
    //   497: invokevirtual 617	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   500: ldc_w 619
    //   503: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: lload 7
    //   508: lload 5
    //   510: lsub
    //   511: invokevirtual 617	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   514: ldc_w 621
    //   517: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: lload 9
    //   522: lload 7
    //   524: lsub
    //   525: invokevirtual 617	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   528: ldc_w 623
    //   531: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: invokestatic 408	java/lang/System:currentTimeMillis	()J
    //   537: lload_3
    //   538: lsub
    //   539: invokevirtual 617	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   542: ldc_w 625
    //   545: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: aload_1
    //   549: invokestatic 217	mof:d	(Ljava/lang/String;)Ljava/lang/String;
    //   552: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   561: aload_2
    //   562: areturn
    //   563: aload_2
    //   564: ldc_w 627
    //   567: invokevirtual 602	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   570: ifeq +10 -> 580
    //   573: ldc_w 629
    //   576: astore_2
    //   577: goto -162 -> 415
    //   580: aload_2
    //   581: ldc_w 631
    //   584: invokevirtual 602	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   587: ifne +33 -> 620
    //   590: aload_2
    //   591: ldc_w 633
    //   594: invokevirtual 602	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   597: ifne +23 -> 620
    //   600: aload_2
    //   601: ldc_w 635
    //   604: invokevirtual 602	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   607: ifne +13 -> 620
    //   610: aload_2
    //   611: ldc_w 637
    //   614: invokevirtual 602	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   617: ifeq +29 -> 646
    //   620: ldc_w 639
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
    //   646: ldc_w 641
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
    //   0	662	0	this	xce
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
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  protected String a(String paramString)
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
        this.jdField_c_of_type_JavaLangString = Uri.parse(paramString).getQueryParameter("_bid");
        if (this.jdField_d_of_type_JavaLangString == null) {
          this.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        }
        if ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_Mkw != null))
        {
          this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Mkw.b(paramString);
          if (this.jdField_d_of_type_JavaLangString == null) {
            this.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
          }
          if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
          {
            String str1 = mof.a(paramString, "_bid=" + this.jdField_c_of_type_JavaLangString);
            if (b(str1)) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.i("OfflinePluginQQ", 2, "-->offline:checkOfflineUrl:" + mpw.b(str1, new String[0]));
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
  
  @TargetApi(11)
  public void a()
  {
    CustomWebView localCustomWebView = this.mRuntime.a();
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
      QLog.i("OfflinePluginQQ", 2, "url doesn't support ServiceWorker! " + mpw.b(str1, new String[0]));
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
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflinePluginQQ", 2, "-->offline:checkOfflineUp,url=" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    while (!a(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("OfflinePluginQQ", 2, "-->offline:checkOfflineUp.");
    }
    mof.a(paramString, this.mRuntime.a(), new xcf(this));
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    Object localObject = this.mRuntime.a();
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
      ((bbca)localObject).A = bool;
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.i("OfflinePluginQQ", 2, "OfflinePlugin handleSchemaRequest loadMode: " + this.jdField_b_of_type_Int + ", bid: " + this.jdField_c_of_type_JavaLangString + ", cost: " + this.jdField_c_of_type_Int);
        }
        a(paramString);
        a(this.jdField_c_of_type_JavaLangString, "Offline_Check", this.jdField_c_of_type_Int, 2, paramString, String.valueOf(this.jdField_b_of_type_Int), "");
      }
      return;
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {}
    do
    {
      rrs localrrs;
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
              localObject1 = this.mRuntime.a();
            } while (localObject1 == null);
            if (jdField_a_of_type_JavaUtilHashMap == null) {
              jdField_a_of_type_JavaUtilHashMap = new HashMap();
            }
          } while ((rrs)jdField_a_of_type_JavaUtilHashMap.get(this.jdField_d_of_type_JavaLangString) != null);
          localrrs = new rrs(this.jdField_d_of_type_JavaLangString);
          localrrs.a(this.jdField_a_of_type_Mpp);
          localObject2 = paramJSONObject.optJSONObject("wording");
          if (localObject2 != null)
          {
            localrrs.jdField_c_of_type_JavaLangString = ((JSONObject)localObject2).optString("nonWifiUpdatingText");
            localrrs.jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).optString("wifiUpdatingText");
            localrrs.jdField_d_of_type_JavaLangString = ((JSONObject)localObject2).optString("updateCompletedText");
          }
          localrrs.e = ((Activity)localObject1).getResources().getString(2131630689);
          jdField_a_of_type_JavaUtilHashMap.put(this.jdField_d_of_type_JavaLangString, localrrs);
          localObject2 = paramJSONObject.optString("url");
          localrrs.f = ((String)localObject2);
          i = paramJSONObject.optInt("filesize");
          localrrs.jdField_a_of_type_Int = i;
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          }
          if (!badq.h(((Activity)localObject1).getApplicationContext())) {
            break;
          }
          localrrs.e = localrrs.jdField_b_of_type_JavaLangString;
          paramJSONObject = localrrs.e;
        } while ((TextUtils.isEmpty((CharSequence)localObject2)) || (i <= 0));
        e();
        localrrs.a(1);
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramJSONObject + "0%");
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
        if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
        }
        if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        }
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        }
        mof.a(((Activity)localObject1).getApplicationContext(), this.jdField_d_of_type_JavaLangString, (String)localObject2, i, localrrs);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
        return;
        paramJSONObject = localrrs.jdField_c_of_type_JavaLangString;
      } while ((TextUtils.isEmpty((CharSequence)localObject2)) || (i <= 0));
      e();
      localrrs.a(0);
      Object localObject1 = ((Activity)localObject1).getResources().getDrawable(2130844149);
      ((Drawable)localObject1).setBounds(0, 0, 40, 40);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject1, null, null, null);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramJSONObject);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    } while (this.jdField_a_of_type_AndroidWidgetProgressBar == null);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
  }
  
  protected boolean a(String paramString)
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
            str1 = this.jdField_a_of_type_Mkw.c(paramString);
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
            QLog.e("QQBrowserActivity", 2, "checkOfflineUpr:url parse exception:" + mpw.b(paramString, new String[0]));
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
            QLog.e("QQBrowserActivity", 2, "checkOfflineUpr:url parse exception:" + mpw.b(paramString, new String[0]));
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
  
  public String b(String paramString)
  {
    String str = mol.a(paramString);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return str + paramString + "/";
  }
  
  public void b()
  {
    if ((jdField_a_of_type_JavaUtilHashMap != null) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)))
    {
      rrs localrrs = (rrs)jdField_a_of_type_JavaUtilHashMap.get(this.jdField_d_of_type_JavaLangString);
      if (localrrs != null) {
        localrrs.a();
      }
    }
    c();
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!a(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("OfflinePluginQQ", 2, "checkOfflineUpNotCallback.");
    }
    mof.a(paramString, this.mRuntime.a());
  }
  
  protected void c()
  {
    if (this.mRuntime.a() == null) {}
    do
    {
      bazo localbazo;
      CustomWebView localCustomWebView;
      do
      {
        do
        {
          return;
          localbazo = this.mRuntime.a(this.mRuntime.a());
        } while ((localbazo == null) || (!(localbazo instanceof bbev)));
        localCustomWebView = this.mRuntime.a();
      } while (localCustomWebView == null);
      localCustomWebView.loadUrl(((bbev)localbazo).b());
    } while (!QLog.isColorLevel());
    QLog.i("OfflinePluginQQ", 2, "reloadCurrentUrl");
  }
  
  public Object handleEvent(String paramString, long paramLong)
  {
    if (paramLong == 8L) {
      return a(paramString);
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
      paramString = this.mRuntime.a();
      paramMap = this.mRuntime.a(this.mRuntime.a());
      if ((paramMap == null) || (!(paramMap instanceof bbej))) {
        return false;
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      if ((jdField_a_of_type_JavaUtilHashMap != null) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)))
      {
        paramMap = (rrs)jdField_a_of_type_JavaUtilHashMap.get(this.jdField_d_of_type_JavaLangString);
        if (paramMap != null)
        {
          e();
          paramMap.a(this.jdField_a_of_type_Mpp);
          if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          }
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          }
          switch (paramMap.b())
          {
          }
        }
      }
    }
    bbcy localbbcy;
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return false;
            if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
              this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMap.e + paramMap.c() + "%");
            }
            if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
              this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
            }
            if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
            {
              this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              continue;
              if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
                this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramMap.c());
              }
              if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
                this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
              }
              if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
              {
                this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
                continue;
                if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
                  this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMap.jdField_d_of_type_JavaLangString);
                }
                if (paramString == null) {
                  return false;
                }
                paramString = paramString.getResources().getDrawable(2130839088);
                paramString.setBounds(0, 0, paramString.getMinimumWidth(), paramString.getMinimumHeight());
                if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
                  this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramString, null, null, null);
                }
                if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
                  this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
                }
                if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
                {
                  this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                  continue;
                  if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
                  {
                    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
                    continue;
                    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
                      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMap.jdField_c_of_type_JavaLangString);
                    }
                    if (paramString == null) {
                      return false;
                    }
                    paramString = paramString.getResources().getDrawable(2130844149);
                    paramString.setBounds(0, 0, 40, 40);
                    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
                      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramString, null, null, null);
                    }
                    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
                      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
                    }
                    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
                    {
                      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                      continue;
                      if (paramLong == 8589934594L)
                      {
                        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
                        ThreadManager.post(new OfflinePlugin.5(this), 5, null, false);
                        if (this.jdField_a_of_type_Xcl != null) {
                          this.jdField_a_of_type_Xcl.a(5);
                        }
                      }
                      else
                      {
                        if (paramLong != 8589934601L) {
                          break;
                        }
                        if (this.jdField_a_of_type_Xcl != null) {
                          this.jdField_a_of_type_Xcl.a(0);
                        }
                        a();
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
        paramMap = this.mRuntime.a();
      } while (paramMap.getX5WebViewExtension() == null);
      localbbcy = bbcx.a(paramString);
    } while ((localbbcy == null) || (TextUtils.isEmpty(localbbcy.jdField_b_of_type_JavaLangString)));
    handleSchemaRequest(paramString, bbdc.a(paramString));
    paramMap.loadDataWithBaseURL(paramString, localbbcy.jdField_b_of_type_JavaLangString, "text/html", "utf-8", paramString);
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
              mof.a(this.mRuntime.a(), paramString2, 1);
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
              f = true;
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
          this.jdField_a_of_type_JavaLangString = paramString2.optString("callback");
          int j = paramString1.length();
          paramString2 = new ArrayList(j);
          while (i < j)
          {
            paramString2.add(paramString1.optString(i));
            i += 1;
          }
          mof.a(paramString2, this.mRuntime.a(), new xch(this, paramJsBridgeListener), true, false);
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
            callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramJsBridgeListener.toString() });
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
    paramString1 = a(paramString1);
    long l = System.currentTimeMillis();
    paramString2 = bbbk.a(paramString1);
    if ((paramString2 != null) && (!paramString2.a()))
    {
      paramString2.a(new xci(this, l, paramString1), paramString1);
      return true;
    }
    if (paramString2 != null) {}
    for (int i = paramString2.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();; i = 0)
    {
      a(paramString1, i);
      return false;
    }
  }
  
  public void onAppRuntimeReady(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Mkw = mkw.a();
    d();
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Boolean = true;
    if ((jdField_a_of_type_JavaUtilHashMap != null) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)))
    {
      rrs localrrs = (rrs)jdField_a_of_type_JavaUtilHashMap.get(this.jdField_d_of_type_JavaLangString);
      if (localrrs != null)
      {
        localrrs.b(this.jdField_a_of_type_Mpp);
        if (localrrs.a() == 0) {
          jdField_a_of_type_JavaUtilHashMap.remove(this.jdField_d_of_type_JavaLangString);
        }
      }
      if (jdField_a_of_type_JavaUtilHashMap.size() == 0) {
        jdField_a_of_type_JavaUtilHashMap = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xce
 * JD-Core Version:    0.7.0.1
 */