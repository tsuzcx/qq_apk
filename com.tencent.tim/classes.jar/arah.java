import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewModule.2;
import com.tencent.mobileqq.webview.swift.WebViewModule.3;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebView.HitTestResult;
import com.tencent.sonic.sdk.SonicEngine;
import com.tencent.sonic.sdk.SonicSession;
import com.tencent.sonic.sdk.SonicSessionConfig.Builder;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class arah
  implements aqzw
{
  arar a;
  protected final arci a;
  protected SonicClientImpl a;
  protected int aNf = 1;
  protected jml authConfig;
  protected boolean avR;
  public BrowserAppInterface browserApp;
  boolean cXu = true;
  private Intent intent;
  public boolean isDestroyed;
  public TouchWebView j;
  public volatile AppInterface mApp;
  private Context mContext;
  protected volatile WebViewPluginEngine mPluginEngine;
  public String mRedirect302Url = "";
  private String mUrl;
  public String uin;
  protected volatile boolean zT;
  
  public arah(@NotNull Intent paramIntent, Context paramContext)
  {
    this.jdField_a_of_type_Arci = new arci(new arai(this));
    this.mContext = paramContext;
    this.intent = paramIntent;
  }
  
  protected int A(Bundle paramBundle)
  {
    jqo.le("Web_qqbrowser_state_machine_load_url");
    System.currentTimeMillis();
    jqo.le("Web_qqbrowser_init");
    aCP();
    jqo.lf("Web_qqbrowser_init");
    jqo.lf("Web_qqbrowser_state_machine_load_url");
    this.aNf = 1024;
    return 0;
  }
  
  public String CE()
  {
    String str2 = this.intent.getStringExtra("url");
    String str1 = str2;
    if (str2 == null)
    {
      str2 = this.intent.getStringExtra("key_params_qq");
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
    }
    return str1;
  }
  
  protected int a(Bundle paramBundle)
  {
    jqo.le("Web_qqbrowser_state_machine_init_FINAL");
    jqo.le("Web_IPCSetup");
    if (!afjy.a().ajq()) {
      afjy.a().a().doBindService(BaseApplicationImpl.getApplication());
    }
    jqo.lf("Web_IPCSetup");
    arcj.a().a(new araj(this, 2));
    jqo.lf("Web_qqbrowser_state_machine_init_FINAL");
    jqo.lf("Web_qqbrowser_state_machine_all");
    this.aNf = 1;
    return -1;
  }
  
  public final arar a()
  {
    this.jdField_a_of_type_Arar = new arar(this.mApp, this, this.intent, this.mContext, false);
    this.jdField_a_of_type_Arar.setSonicClient(this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl);
    TouchWebView localTouchWebView = this.jdField_a_of_type_Arar.a();
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.bindWebView(localTouchWebView);
    }
    this.mPluginEngine.e(localTouchWebView);
    localTouchWebView.setPluginEngine(this.mPluginEngine);
    if (this.avR) {
      localTouchWebView.setMask(true);
    }
    return this.jdField_a_of_type_Arar;
  }
  
  public Object a(String paramString, Bundle paramBundle)
  {
    return null;
  }
  
  public void a(WebView paramWebView, SslError paramSslError) {}
  
  public boolean a(ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    return false;
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    return false;
  }
  
  public void aCP()
  {
    jqo.le("Web_readyToLoadUrl");
    if (this.j == null) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(this.mUrl)) {
        this.j.loadUrl(this.mUrl);
      }
      jqo.lf("Web_readyToLoadUrl");
    } while (!this.j.isPaused);
    this.j.onResume();
  }
  
  public void b(WebView paramWebView, String paramString, Bitmap paramBitmap) {}
  
  void bAF()
  {
    if (!this.zT)
    {
      this.zT = true;
      String str = this.intent.getStringExtra("url");
      if (ardk.rX(str)) {
        ThreadManager.postImmediately(new WebViewModule.3(this, str), null, false);
      }
    }
  }
  
  public boolean c(WebView paramWebView, String paramString)
  {
    if ((this.isDestroyed) || (this.j == null)) {
      return true;
    }
    jqo.le("urlInterceptManager");
    arcp.getSchemeFromUrl(paramString);
    jqo.lf("urlInterceptManager");
    return false;
  }
  
  void destroyWebView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewModule", 2, "onDestroy");
    }
    this.isDestroyed = true;
    if (this.jdField_a_of_type_Arar != null)
    {
      this.jdField_a_of_type_Arar.destroy();
      this.jdField_a_of_type_Arar = null;
      this.j = null;
    }
    this.mApp = null;
  }
  
  protected boolean dispatchPluginEvent(long paramLong, Map<String, Object> paramMap)
  {
    if (this.j != null)
    {
      WebViewPluginEngine localWebViewPluginEngine = this.j.getPluginEngine();
      if (localWebViewPluginEngine != null) {
        return localWebViewPluginEngine.handleEvent(this.j.getUrl(), paramLong, paramMap);
      }
    }
    return false;
  }
  
  public void ec(int paramInt, String paramString) {}
  
  protected void egI()
  {
    synchronized (arcn.fE)
    {
      if (WebViewPluginEngine.e != null)
      {
        this.mPluginEngine = WebViewPluginEngine.e;
        WebViewPluginEngine.e = null;
      }
      if (this.mPluginEngine != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebViewModule", 2, "-->web engine and plugin initialized at process preload!");
        }
        this.mPluginEngine.onDestroy();
        if (arak.a(this.intent) != null)
        {
          ??? = arak.a(this.intent);
          this.mPluginEngine.b(this.mApp, null, ((WebAccelerateHelper.CommonJsPluginFactory)???).getCommonJsPlugin());
          WebAccelerateHelper.getInstance().bindFragment(this.mPluginEngine, null);
        }
        return;
      }
    }
    this.mPluginEngine = WebAccelerateHelper.getInstance().createWebViewPluginEngine(this.mApp, null, null, arak.a(this.intent), null);
    WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.mPluginEngine, this.mApp, null);
    WebAccelerateHelper.getInstance().bindFragment(this.mPluginEngine, null);
  }
  
  void egM()
  {
    if (1 != this.aNf)
    {
      int i = this.aNf;
      this.jdField_a_of_type_Arci.cancel();
      this.jdField_a_of_type_Arci.cFX();
      this.jdField_a_of_type_Arci.av(null);
    }
  }
  
  public String getUAMark()
  {
    return null;
  }
  
  public View getVideoLoadingProgressView()
  {
    return null;
  }
  
  protected void initWebView()
  {
    int m = -1;
    int k = 0;
    int i;
    if (this.j == null)
    {
      this.j = a().a();
      System.currentTimeMillis();
      i = m;
      switch (this.intent.getIntExtra("reqType", -1))
      {
      default: 
        i = m;
      }
    }
    for (;;)
    {
      if (AppSetting.aNT) {
        i = 2;
      }
      this.j.getSettings().setCacheMode(i);
      if (QLog.isColorLevel()) {
        QLog.i("WebViewModule", 2, "setCacheMode=" + i);
      }
      this.j.getSettings().setAllowFileAccessFromFileURLs(false);
      this.j.getSettings().setAllowUniversalAccessFromFileURLs(false);
      System.currentTimeMillis();
      long l1 = System.currentTimeMillis();
      IX5WebViewExtension localIX5WebViewExtension = this.j.getX5WebViewExtension();
      i = k;
      if (localIX5WebViewExtension != null) {
        i = 1;
      }
      if (i != 0)
      {
        Bundle localBundle = arcp.v();
        if (localBundle != null) {
          localIX5WebViewExtension.invokeMiscMethod("setDomainsAndArgumentForImageRequest", localBundle);
        }
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("WebViewModule", 2, "setDomainsAndArgumentForImageRequest, cost=" + (l2 - l1));
      }
      this.mPluginEngine.handleEvent(this.mUrl, 8589934623L, null);
      return;
      i = 2;
      continue;
      i = 0;
    }
  }
  
  void iz(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = SwiftBrowserCookieMonster.pY(paramString1);
      String str = SwiftBrowserCookieMonster.pY(paramString2);
      if (((paramString1 != null) && (paramString1.contains("ptlogin"))) || ((str != null) && (str.contains("ptlogin")))) {
        this.cXu = false;
      }
      if (this.cXu)
      {
        paramString1 = SwiftBrowserCookieMonster.a(paramString2);
        if (paramString1 != null) {
          paramString1.a(paramString2, null, null, this.intent);
        }
      }
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("WebViewModule", 1, paramString1, new Object[0]);
    }
  }
  
  protected int n(Bundle paramBundle)
  {
    i = 1;
    jqo.le("Web_qqbrowser_state_machine_init_data");
    QbSdk.setQQBuildNumber("3058");
    paramBundle = this.intent.getStringExtra("options");
    if (paramBundle != null) {}
    try
    {
      paramBundle = new JSONObject(paramBundle);
      this.intent.putExtra("url", paramBundle.getString("url"));
      if (!this.intent.hasExtra("key_isReadModeEnabled")) {
        this.intent.putExtra("key_isReadModeEnabled", true);
      }
      this.intent.putExtra("ba_is_login", paramBundle.optBoolean("ba_is_login", true));
      this.intent.putExtra("isShowAd", paramBundle.optBoolean("isShowAd", true));
      this.intent.putExtra("avoidLoginWeb", paramBundle.optBoolean("avoidLoginWeb", false));
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        boolean bool;
        int k;
        if (QLog.isColorLevel())
        {
          QLog.d("WebViewModule", 2, paramBundle.toString());
          continue;
          i = 0;
        }
      }
    }
    new StringBuilder().append(Build.MANUFACTURER).append("_").append(Build.MODEL).toString();
    bool = this.intent.getBooleanExtra("fromNearby", false);
    paramBundle = getClass();
    k = hashCode();
    if (bool)
    {
      anpo.a(paramBundle, k, i, this.mUrl);
      jqo.lf("Web_qqbrowser_state_machine_init_data");
      this.aNf = 4;
      return 0;
    }
  }
  
  public void onCreate()
  {
    preInitData();
    bAF();
    if (!this.intent.getBooleanExtra("key_is_init_sonic_session", true)) {}
    for (boolean bool = false;; bool = rO(CE()))
    {
      if (!bool) {
        ThreadManager.post(new WebViewModule.2(this), 5, null, true);
      }
      this.avR = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
      this.authConfig = jml.a();
      this.isDestroyed = false;
      this.aNf = 2;
      if ((WebAccelerateHelper.isWebViewCache) || (SwiftReuseTouchWebView.sPoolSize > 0)) {
        this.jdField_a_of_type_Arci.cFX();
      }
      WebAccelerateHelper.isWebViewCache = true;
      this.jdField_a_of_type_Arci.av(new Bundle());
      return;
    }
  }
  
  public void onDestroy()
  {
    if (1 != this.aNf)
    {
      this.jdField_a_of_type_Arci.cancel();
      this.aNf = 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.destroy();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl = null;
    }
    if (this.j != null) {}
    for (Object localObject = this.j.getPluginEngine();; localObject = null)
    {
      if (localObject != null) {
        ((WebViewPluginEngine)localObject).handleEvent(this.j.getUrl(), 8589934596L, null);
      }
      new Bundle().putString("url", this.mUrl);
      destroyWebView();
      if (QQBrowserActivity.bJl == 0)
      {
        afjy.a().a().doUnbindService(BaseApplicationImpl.getApplication());
        arbz.b.eeq = -1;
      }
      localObject = anpo.a(getClass(), hashCode());
      if (localObject != null) {
        anot.a(null, "CliOper", "", "", ((anpo.a)localObject).cgi, ((anpo.a)localObject).cgi, ((anpo.a)localObject).arg1, 0, Long.toString(SystemClock.elapsedRealtime() - ((anpo.a)localObject).startTime), "", "", "");
      }
      arcj.a().removeIdleTask(2);
      return;
    }
  }
  
  public void onDetectedBlankScreen(String paramString, int paramInt) {}
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewModule", 2, "onGeolocationPermissionsShowPrompt:" + paramString);
    }
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.indexOf(':') == -1)
      {
        str = paramString;
        if (this.j != null)
        {
          str = paramString;
          if (this.j.getX5WebViewExtension() != null) {
            str = "https://" + paramString + "/";
          }
        }
      }
    }
    boolean bool2 = this.authConfig.z(str, "publicAccount.getLocation");
    paramString = "";
    if (this.j != null) {
      paramString = jqo.getSpecifiedLevelDomain(this.j.getUrl(), 2);
    }
    boolean bool3 = PublicAccountJavascriptInterface.getLocationPermissionGrant(this.uin, paramString);
    if ((bool3) && (bool2)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebViewModule", 2, new Object[] { "onGeolocationPermissionsShowPrompt allow:", Boolean.valueOf(bool2), " granted:", Boolean.valueOf(bool3), " hasRight:", Boolean.valueOf(bool1), " uin:", this.uin, " urlHost:", paramString });
      }
      paramGeolocationPermissionsCallback.invoke(str, bool1, false);
      return;
    }
  }
  
  public void onHideCustomView() {}
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return false;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if ((this.isDestroyed) || (this.j == null)) {}
    do
    {
      return;
      egM();
      this.cXu = false;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.pageFinish(paramString);
      }
    } while ((Build.VERSION.SDK_INT < 19) || (this.isDestroyed) || (this.jdField_a_of_type_Arar == null) || (this.jdField_a_of_type_Arar.a() == null));
    onReceivedTitle(paramWebView, paramWebView.getTitle());
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((this.isDestroyed) || (this.j == null)) {
      return;
    }
    egM();
  }
  
  public void onPause()
  {
    dispatchPluginEvent(8589934597L, null);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt) {}
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if ((this.isDestroyed) || (this.j == null)) {
      return;
    }
    egM();
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString) {}
  
  public void onResume()
  {
    if (this.j != null) {
      this.j.onResume();
    }
    dispatchPluginEvent(2L, null);
  }
  
  public void onUrlChange(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WebViewModule", 2, "X5 webkit detect 302 url: " + paramString2);
    }
    this.mRedirect302Url = paramString2;
    SwiftBrowserCookieMonster.egU();
    iz(paramString1, paramString2);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2) {}
  
  protected int p(Bundle paramBundle)
  {
    jqo.le("Web_qqbrowser_state_machine_init_webview");
    initWebView();
    jqo.lf("Web_qqbrowser_state_machine_init_webview");
    this.aNf = 32;
    return 0;
  }
  
  void preInitData()
  {
    this.mUrl = CE();
  }
  
  boolean rO(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebViewModule", 2, "initSonicSession url = :" + paramString);
    }
    for (;;)
    {
      int i;
      try
      {
        SonicSessionConfig.Builder localBuilder = new SonicSessionConfig.Builder();
        localBuilder.setSessionMode(1);
        Object localObject = Uri.parse(paramString);
        if (((Uri)localObject).isHierarchical())
        {
          localObject = ((Uri)localObject).getQueryParameter("_sonic_xv");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            HashMap localHashMap = new HashMap();
            long l = Long.parseLong((String)localObject);
            if ((0x2 & l) == 0L) {
              break label336;
            }
            bool = true;
            localBuilder.setSupportLocalServer(bool);
            if ((0x4 & l) == 0L) {
              break label342;
            }
            i = 1;
            break label324;
            label138:
            localHashMap.put("cache-offline", localObject);
            localBuilder.setCustomResponseHeaders(localHashMap);
            if ((0x8 & l) == 0L) {
              break label355;
            }
            bool = true;
            localBuilder.setSupportCacheControl(bool);
          }
        }
        localObject = WebAccelerateHelper.getSonicEngine();
        if (localObject != null)
        {
          localObject = ((SonicEngine)localObject).createSession(paramString, localBuilder.build());
          if (localObject != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl = new SonicClientImpl((SonicSession)localObject);
            ((SonicSession)localObject).bindClient(this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl);
            return true;
          }
          QLog.d("WebViewModule", 1, "initSonicSession sonicSession = null, url = " + paramString);
          return false;
        }
      }
      catch (Exception localException)
      {
        QLog.e("WebViewModule", 1, "initSonicSession exception, url = " + paramString, localException);
        return false;
      }
      QLog.d("WebViewModule", 1, "initSonicSession sonicEngine = null, url = " + paramString);
      return false;
      for (;;)
      {
        label324:
        if (i == 0) {
          break label347;
        }
        str = "store";
        break label138;
        label336:
        bool = false;
        break;
        label342:
        i = 0;
      }
      label347:
      String str = "true";
      continue;
      label355:
      boolean bool = false;
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((this.isDestroyed) || (this.j == null)) {
      return true;
    }
    if (((paramString.startsWith("http://")) || (!paramString.startsWith("https://"))) || (((paramString.startsWith("file://")) || (paramString.startsWith("data:")) || (paramString.startsWith("http://")) || (paramString.startsWith("https://"))) && (!paramString.startsWith("http://")) && (paramString.startsWith("https://")))) {}
    String str = arcp.getSchemeFromUrl(paramString);
    if (("http".equals(str)) || ("https".equals(str)))
    {
      paramWebView = paramWebView.getHitTestResult();
      if ((paramWebView != null) && (paramWebView.getType() == 0))
      {
        QLog.i("WebViewModule", 1, "shouldOverrideUrlLoading detect 302, url: " + paramString);
        paramWebView = this.mRedirect302Url;
        this.mRedirect302Url = paramString;
        SwiftBrowserCookieMonster.egU();
        iz(paramWebView, this.mRedirect302Url);
      }
    }
    return false;
  }
  
  public void showCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback) {}
  
  protected int y(Bundle paramBundle)
  {
    jqo.le("Web_qqbrowser_state_machine_init_x5_environment");
    this.aNf = 8;
    if (arcn.a.PN())
    {
      jqo.lf("Web_qqbrowser_state_machine_init_x5_environment");
      return 0;
    }
    if (arcn.a.init())
    {
      jqo.lf("Web_qqbrowser_state_machine_init_x5_environment");
      return 0;
    }
    jqo.lf("Web_qqbrowser_state_machine_init_x5_environment");
    return 0;
  }
  
  protected int z(Bundle paramBundle)
  {
    jqo.le("Web_qqbrowser_state_machine_init_app_and_webview_engine");
    this.mApp = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    if ((this.mApp instanceof BrowserAppInterface)) {
      this.browserApp = ((BrowserAppInterface)this.mApp);
    }
    if ((!WebAccelerateHelper.isWebViewCache) && (!VipWebViewReportLog.isInited())) {
      VipWebViewReportLog.a(this.mApp.getApplication(), this.mApp);
    }
    this.uin = this.mApp.getAccount();
    egI();
    if (this.mPluginEngine != null)
    {
      this.mPluginEngine.aa(this.intent.getStringArrayExtra("insertPluginsArray"));
      this.mPluginEngine.handleEvent(this.mUrl, 1L, null);
    }
    this.aNf = 16;
    jqo.lf("Web_qqbrowser_state_machine_init_app_and_webview_engine");
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arah
 * JD-Core Version:    0.7.0.1
 */