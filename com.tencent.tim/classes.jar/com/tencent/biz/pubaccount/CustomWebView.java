package com.tencent.biz.pubaccount;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityManager;
import anpc;
import arcp;
import arcp.b;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.sonic.sdk.SonicSession;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jml;
import jqo;
import jyj;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomWebView
  extends SuperWebView
{
  static final String CALLBACK_NAME_HOLDER = "((0))";
  static final String CALLBACK_PARAM_HOLDER = "((1))";
  static final String CALL_JS_DEFAULT_TPL = "(window.mqq && mqq.version > 20140616001 && mqq.execGlobalCallback || function(cb) {window[cb] && window[cb].apply(window, [].slice.call(arguments, 1));}).apply(window, [((0)), ((1))]);";
  public static final String TAG = "CustomWebView";
  public static final String TAG_WEBVIEW_CHECK = "WEBVIEWCHECK";
  public static final String TAG_WEBVIEW_LOAD = "webviewLoad";
  protected static SparseArray<String> mMsg4CallbackMap = new SparseArray(8);
  static String sCallJsTpl;
  public static String sLastContextLog;
  protected boolean attachedToWindow;
  String cookieUrl = "";
  SwiftBrowserCookieMonster.a cookiesCallback = null;
  protected boolean isDestroyed;
  protected boolean isFirstLoad = true;
  public boolean isPaused = true;
  protected b mOpenApiInfo;
  protected WebViewPluginEngine mPluginEngine;
  public boolean mWebIsInitMiniAIO;
  c mt;
  boolean needSetCookies = true;
  protected SonicClientImpl sonicSessionClient;
  
  static
  {
    mMsg4CallbackMap.put(0, "recode_successed");
    mMsg4CallbackMap.put(1, "recode_failed_permission_denied");
    mMsg4CallbackMap.put(2, "recode_failed_token_verify_time_out");
    mMsg4CallbackMap.put(3, "recode_failed_no_such_method");
    mMsg4CallbackMap.put(4, "recode_failed_params_error");
    mMsg4CallbackMap.put(5, "recode_failed_frequency_limit");
  }
  
  public CustomWebView(Context paramContext)
  {
    super(paramContext);
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
  }
  
  public CustomWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
  }
  
  public CustomWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
  }
  
  public static void addContextLog(String paramString)
  {
    if ((paramString == null) || (paramString.equals(sLastContextLog))) {
      return;
    }
    long l = System.currentTimeMillis();
    sLastContextLog = paramString;
    String str = paramString;
    if (paramString.length() > 512) {
      str = paramString.substring(0, 512);
    }
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    paramString = str;
    if (arrayOfStackTraceElement.length > 2) {
      paramString = str + " at " + arrayOfStackTraceElement[2].toString();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("webviewLoad", 4, "cost:" + (System.currentTimeMillis() - l) + " " + paramString);
    }
    anpc.a(null).hy("webviewLoad", paramString);
  }
  
  private Intent getIntent()
  {
    if (this.mIntent != null) {
      return this.mIntent;
    }
    if ((this.mPluginEngine != null) && (this.mPluginEngine.activity != null)) {
      return this.mPluginEngine.activity.getIntent();
    }
    return null;
  }
  
  private boolean isNeedSetCookies()
  {
    if (this.needSetCookies)
    {
      Intent localIntent = getIntent();
      if ((localIntent != null) && (localIntent.getBooleanExtra("ignoreLoginWeb", false)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CustomWebView", 2, "ignore login state, set key cookie abort.");
        }
        this.needSetCookies = false;
      }
    }
    return this.needSetCookies;
  }
  
  private boolean setCookiesIfNeeded(a parama)
  {
    if (!this.needSetCookies) {}
    Object localObject;
    do
    {
      do
      {
        return false;
        localObject = arcp.getSchemeFromUrl(parama.baseUrl);
      } while ((!"http".equals(localObject)) && (!"https".equals(localObject)));
      this.cookiesCallback = new jyj(this, parama);
      localObject = SwiftBrowserCookieMonster.a(parama.baseUrl);
    } while (localObject == null);
    this.needSetCookies = false;
    Intent localIntent = getIntent();
    if ((localIntent != null) && (localIntent.getBooleanExtra("avoidLoginWeb", false)))
    {
      ((SwiftBrowserCookieMonster)localObject).egW();
      return false;
    }
    this.cookieUrl = parama.baseUrl;
    ((SwiftBrowserCookieMonster)localObject).a(parama.baseUrl, this.cookiesCallback, null, localIntent);
    return true;
  }
  
  public void callJs(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CustomWebView", 2, "call js script = javascript:" + paramString);
    }
    if (this.isDestroyed) {
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper()) {
      try
      {
        super.loadUrl("javascript:" + paramString);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    ThreadManagerV2.getUIHandlerV2().post(new CustomWebView.4(this, paramString));
  }
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("CustomWebView", 2, QLog.getStackTraceString(new Throwable("func is empty")));
      }
      return;
    }
    Object localObject;
    if (sCallJsTpl == null)
    {
      localObject = jml.a().H("jscallback", null);
      if ((localObject == null) || (!((String)localObject).contains("((0))")) || (!((String)localObject).contains("((1))"))) {
        break label152;
      }
    }
    label152:
    for (sCallJsTpl = (String)localObject;; sCallJsTpl = "(window.mqq && mqq.version > 20140616001 && mqq.execGlobalCallback || function(cb) {window[cb] && window[cb].apply(window, [].slice.call(arguments, 1));}).apply(window, [((0)), ((1))]);")
    {
      localObject = new StringBuilder();
      if ((paramVarArgs == null) || (paramVarArgs.length <= 0) || ("".equals(paramVarArgs[0]))) {
        break;
      }
      ((StringBuilder)localObject).append(paramVarArgs[0]);
      int i = 1;
      int j = paramVarArgs.length;
      while (i < j)
      {
        ((StringBuilder)localObject).append(',').append(paramVarArgs[i]);
        i += 1;
      }
    }
    ((StringBuilder)localObject).append("void(0)");
    callJs(sCallJsTpl.replace("((0))", jqo.toJsString(paramString)).replace("((1))", (CharSequence)localObject));
  }
  
  public void callJs4OpenApi(JsBridgeListener paramJsBridgeListener, int paramInt, String... paramVarArgs)
  {
    if ((paramJsBridgeListener == null) || (paramJsBridgeListener.abC == -1L))
    {
      if (QLog.isColorLevel()) {
        QLog.w("CustomWebView", 2, "callJs4OpenApi, listener == null || listener.sn == -1");
      }
      return;
    }
    for (Object localObject = (String)mMsg4CallbackMap.get(paramInt);; localObject = "")
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("code", paramInt);
        if (localObject == null) {
          continue;
        }
        localJSONObject.put("msg", localObject);
        localObject = new StringBuilder();
        int i;
        if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (!"".equals(paramVarArgs[0])))
        {
          ((StringBuilder)localObject).append(paramVarArgs[0]);
          paramInt = 1;
          i = paramVarArgs.length;
        }
        while (paramInt < i)
        {
          ((StringBuilder)localObject).append(',').append(paramVarArgs[paramInt]);
          paramInt += 1;
          continue;
          ((StringBuilder)localObject).append("{}");
        }
        localJSONObject.put("data", ((StringBuilder)localObject).toString());
        paramVarArgs = localJSONObject.toString();
        if (QLog.isColorLevel()) {
          QLog.d("CustomWebView.troop.openapi", 2, "callJs4OpenApi,listener.sn" + paramJsBridgeListener.abC + " | result:" + paramVarArgs);
        }
        callJs("(window.mqq && mqq.version > 20140616001 && mqq.execGlobalCallback || function(cb) {window[cb] && window[cb].apply(window, [].slice.call(arguments, 1));}).apply(window, [((0)), ((1))]);".replace("((0))", jqo.toJsString(paramJsBridgeListener.abC + "")).replace("((1))", paramVarArgs));
        return;
      }
      catch (JSONException paramJsBridgeListener) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("CustomWebView.troop.openapi", 2, "callJs4OpenApi, JSONException");
      return;
    }
  }
  
  public boolean checkToken(CustomWebView paramCustomWebView, int paramInt, String paramString1, String paramString2, String paramString3, JsBridgeListener paramJsBridgeListener)
  {
    if (paramCustomWebView == null) {
      return false;
    }
    if ("auth.init".equals(paramString3)) {
      return true;
    }
    if (this.mOpenApiInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CustomWebView.troop.openapi", 2, "mOpenApiInfo == null");
      }
      return false;
    }
    if ((paramInt == 0) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      paramCustomWebView.callJs4OpenApi(paramJsBridgeListener, 4, new String[] { JsBridgeListener.a(4, null, "params_error") });
      if (QLog.isColorLevel()) {
        QLog.e("CustomWebView.troop.openapi", 2, "RECODE_FAILED_PARAMS_ERROR");
      }
      return false;
    }
    long l = NetConnInfoCenter.getServerTime();
    if (QLog.isColorLevel()) {
      QLog.e("CustomWebView.troop.openapi", 2, "serverTime - mOpenApiInfo.expireTime:" + (l - this.mOpenApiInfo.expireTime));
    }
    if (l > this.mOpenApiInfo.expireTime)
    {
      paramCustomWebView.callJs4OpenApi(paramJsBridgeListener, 2, new String[] { JsBridgeListener.a(2, null, "token_verify_time_out") });
      if (QLog.isColorLevel()) {
        QLog.e("CustomWebView.troop.openapi", 2, "RECODE_FAILED_TOKEN_VERIFY_TIME_OUT");
      }
      return false;
    }
    paramString2 = paramInt + "_" + paramString1 + "_" + paramString2;
    paramString3 = "mqq." + paramString3;
    paramString1 = null;
    int i;
    if ((this.mOpenApiInfo == null) || (TextUtils.isEmpty(this.mOpenApiInfo.UX)) || (!paramString2.equals(this.mOpenApiInfo.UX)))
    {
      i = 1;
      if (this.mOpenApiInfo.cW == null) {
        break label573;
      }
      Iterator localIterator = this.mOpenApiInfo.cW.keySet().iterator();
      paramString1 = null;
      while (localIterator.hasNext())
      {
        paramString2 = (String)localIterator.next();
        paramString1 = paramString2;
        if (Pattern.compile(paramString2).matcher(paramString3).find())
        {
          paramString1 = paramString2;
          paramInt = 1;
        }
      }
    }
    for (;;)
    {
      if ((i != 0) || (paramInt == 0))
      {
        paramCustomWebView.callJs4OpenApi(paramJsBridgeListener, 1, new String[] { JsBridgeListener.a(1, null, "permission_denied") });
        if (QLog.isColorLevel()) {
          QLog.e("CustomWebView.troop.openapi", 2, "permission_denied");
        }
        return false;
        i = 0;
        break;
      }
      l = ((Long)this.mOpenApiInfo.cW.get(paramString1)).longValue() + this.mOpenApiInfo.frequency;
      if (QLog.isColorLevel()) {
        QLog.e("CustomWebView.troop.openapi", 2, "expectedTime - System.currentTimeMillis():" + (l - System.currentTimeMillis()));
      }
      if (l > System.currentTimeMillis())
      {
        paramCustomWebView.callJs4OpenApi(paramJsBridgeListener, 5, new String[] { JsBridgeListener.a(5, null, "frequency_limit") });
        if (QLog.isColorLevel()) {
          QLog.e("CustomWebView.troop.openapi", 2, "frequency_limit");
        }
        return false;
      }
      this.mOpenApiInfo.cW.put(paramString1, Long.valueOf(System.currentTimeMillis()));
      return true;
      paramInt = 0;
      continue;
      label573:
      paramInt = 0;
    }
  }
  
  public void destroy()
  {
    this.isDestroyed = true;
    if ((this.cookiesCallback != null) && (!TextUtils.isEmpty(this.cookieUrl)))
    {
      SwiftBrowserCookieMonster localSwiftBrowserCookieMonster = SwiftBrowserCookieMonster.a(this.cookieUrl);
      if (localSwiftBrowserCookieMonster != null) {
        localSwiftBrowserCookieMonster.a(this.cookiesCallback);
      }
      this.cookiesCallback = null;
      this.cookieUrl = "";
    }
    if (!this.attachedToWindow) {
      ThreadManagerV2.getUIHandlerV2().postDelayed(new CustomWebView.2(this), 1000L);
    }
    if (this.mOpenApiInfo != null)
    {
      this.mOpenApiInfo.destroy();
      this.mOpenApiInfo = null;
    }
  }
  
  public void destroyWebView()
  {
    try
    {
      if ((((AccessibilityManager)getContext().getSystemService("accessibility")).isEnabled()) && (Build.VERSION.SDK_INT < 19))
      {
        Object localObject1 = com.tencent.smtt.sdk.WebView.class.getDeclaredField("isX5Core");
        ((Field)localObject1).setAccessible(true);
        if (!((Boolean)((Field)localObject1).get(this)).booleanValue())
        {
          localObject1 = com.tencent.smtt.sdk.WebView.class.getDeclaredField("mSysWebView");
          ((Field)localObject1).setAccessible(true);
          localObject1 = ((Field)localObject1).get(this);
          Object localObject2 = android.webkit.WebView.class.getDeclaredField("mProvider");
          ((Field)localObject2).setAccessible(true);
          localObject1 = ((Field)localObject2).get(localObject1);
          localObject2 = Class.forName("android.webkit.WebViewClassic").getDeclaredField("mAccessibilityInjector");
          ((Field)localObject2).setAccessible(true);
          localObject2 = ((Field)localObject2).get(localObject1);
          Field localField = Class.forName("android.webkit.AccessibilityInjector").getDeclaredField("mTextToSpeech");
          localField.setAccessible(true);
          localObject1 = localField.get(localObject2);
          if (localObject1 != null)
          {
            localField.set(localObject2, null);
            localObject2 = Class.forName("android.webkit.AccessibilityInjector.TextToSpeechWrapper").getDeclaredMethod("shutdown", new Class[0]);
            ((Method)localObject2).setAccessible(true);
            ((Method)localObject2).invoke(localObject1, new Object[0]);
          }
        }
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        localNoSuchFieldException.printStackTrace();
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        localNoSuchMethodException.printStackTrace();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    super.destroy();
  }
  
  public String getCookieUrl()
  {
    return this.cookieUrl;
  }
  
  public b getOpenApiTokenInfo()
  {
    return this.mOpenApiInfo;
  }
  
  public WebViewPluginEngine getPluginEngine()
  {
    return this.mPluginEngine;
  }
  
  public SonicClientImpl getSonicClient()
  {
    return this.sonicSessionClient;
  }
  
  public boolean goBack(Map<String, Object> paramMap)
  {
    if ((this.mPluginEngine != null) && (this.mPluginEngine.handleEvent(getUrl(), 8589934601L, paramMap))) {
      return false;
    }
    super.stopLoading();
    super.goBack();
    return true;
  }
  
  public boolean goForward(Map<String, Object> paramMap)
  {
    if ((this.mPluginEngine != null) && (this.mPluginEngine.handleEvent(getUrl(), 8589934602L, paramMap))) {
      return false;
    }
    super.stopLoading();
    super.goForward();
    return true;
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    if (this.isDestroyed) {}
    Object localObject;
    do
    {
      do
      {
        return;
        if (!isNeedSetCookies()) {
          break;
        }
        localObject = new a();
        ((a)localObject).mode = 3;
        ((a)localObject).baseUrl = paramString1;
        ((a)localObject).mimeType = paramString2;
        ((a)localObject).encoding = paramString3;
      } while (setCookiesIfNeeded((a)localObject));
      if (!this.isFirstLoad) {
        break;
      }
      this.isFirstLoad = false;
      localObject = new HashMap();
      ((Map)localObject).put("url", paramString1);
    } while ((this.mPluginEngine != null) && (this.mPluginEngine.i((Map)localObject)));
    paramString1 = (String)((Map)localObject).get("url");
    for (;;)
    {
      addContextLog(paramString1);
      super.loadData(paramString1, paramString2, paramString3);
      return;
    }
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (this.isDestroyed) {}
    Object localObject;
    do
    {
      do
      {
        return;
        if (!isNeedSetCookies()) {
          break;
        }
        localObject = new a();
        ((a)localObject).mode = 4;
        ((a)localObject).baseUrl = paramString1;
        ((a)localObject).data = paramString2;
        ((a)localObject).mimeType = paramString3;
        ((a)localObject).encoding = paramString4;
        ((a)localObject).UW = paramString5;
      } while (setCookiesIfNeeded((a)localObject));
      if (!this.isFirstLoad) {
        break;
      }
      this.isFirstLoad = false;
      localObject = new HashMap();
      ((Map)localObject).put("url", paramString1);
    } while ((this.mPluginEngine != null) && (this.mPluginEngine.i((Map)localObject)));
    paramString1 = (String)((Map)localObject).get("url");
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[").append(jqo.filterKeyForLog(paramString1, new String[0])).append("]");
      if (!TextUtils.isEmpty(paramString2)) {
        if (paramString2.length() <= 128) {
          break label228;
        }
      }
      label228:
      for (localObject = paramString2.substring(0, 128);; localObject = paramString2)
      {
        localStringBuilder.append((String)localObject);
        addContextLog(localStringBuilder.toString());
        super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
        return;
      }
    }
  }
  
  public void loadDataWithBaseURLAndHeader(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, HashMap<String, String> paramHashMap)
  {
    if ((getX5WebViewExtension() != null) && (QbSdk.getTbsVersion(BaseApplicationImpl.getContext()) >= 43304))
    {
      getX5WebViewExtension().loadDataWithBaseURLWithHeaders(paramString1, paramString2, paramString3, paramString4, paramString5, paramHashMap);
      QLog.d("CustomWebView", 1, "loadDataWithBaseURLAndHeader");
      super.readyForLoadJs();
      return;
    }
    loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadDataWithHeaders(String paramString1, String paramString2, String paramString3, HashMap<String, String> paramHashMap)
  {
    if ((getX5WebViewExtension() != null) && (QbSdk.getTbsVersion(BaseApplicationImpl.getContext()) >= 43304))
    {
      QLog.d("CustomWebView", 1, "loadDataWithHeaders");
      getX5WebViewExtension().loaddataWithHeaders(paramString1, paramString2, paramString3, paramHashMap);
      return;
    }
    loadData(paramString1, paramString2, paramString3);
  }
  
  public void loadUrl(String paramString)
  {
    boolean bool2 = true;
    QLog.d("WEBVIEWCHECK", 2, "tendocpreload CustomWebView needLoadUrl000: " + paramString + ", loadUrl url:" + jqo.filterKeyForLog(paramString, new String[0]));
    if (this.isDestroyed) {}
    HashMap localHashMap;
    do
    {
      a locala;
      do
      {
        return;
        localHashMap = new HashMap();
        localHashMap.put("url", paramString);
        if (!isNeedSetCookies()) {
          break;
        }
        locala = new a();
        locala.mode = 1;
        locala.baseUrl = paramString;
      } while (setCookiesIfNeeded(locala));
      QLog.d("WEBVIEWCHECK", 2, "tendocpreload CustomWebView needLoadUrl111: " + paramString + ", loadUrl url:" + jqo.filterKeyForLog(paramString, new String[0]));
      if ((this.sonicSessionClient != null) && (this.sonicSessionClient.getSession().isMatchCurrentUrl(paramString)) && (this.sonicSessionClient.getSession().onClientReady()))
      {
        this.isFirstLoad = true;
        QLog.d("CustomWebView", 1, "loadUrl intercept by sonic client.");
        return;
      }
      if (!this.isFirstLoad) {
        break;
      }
      this.isFirstLoad = false;
    } while ((this.mPluginEngine != null) && (this.mPluginEngine.i(localHashMap)));
    paramString = (String)localHashMap.get("url");
    WebAccelerateHelper.getInstance().checkCookie(paramString);
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        bool1 = bool2;
        if (this.mPluginEngine != null) {
          if (this.mPluginEngine.shouldOverrideUrlRequest(paramString)) {
            break label409;
          }
        }
      }
      label409:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        if ((bool1) && ((paramString.startsWith("http")) || (paramString.startsWith("data:"))) && (!paramString.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
          addContextLog(jqo.filterKeyForLog(paramString, new String[0]));
        }
        if (QLog.isColorLevel())
        {
          QLog.d("WEBVIEWCHECK", 2, "tendocpreload CustomWebView needLoadUrl222: " + bool1 + ", loadUrl url:" + jqo.filterKeyForLog(paramString, new String[0]));
          com.tencent.mobileqq.log.VipWebViewReportLog.Url = paramString;
        }
        if (arcp.b.cYT)
        {
          arcp.b(this, arcp.b.proxy);
          arcp.b.cYT = false;
        }
        if (!bool1) {
          break;
        }
        super.loadUrl(paramString);
        return;
      }
    }
  }
  
  public void loadUrlOriginal(String paramString)
  {
    QLog.d("WEBVIEWCHECK", 2, "tendocpreload CustomWebView loadUrlOriginal000 url:" + paramString);
    if (this.isDestroyed) {}
    Object localObject;
    do
    {
      do
      {
        return;
        if ("about:blank".equals(paramString))
        {
          super.loadUrl(paramString);
          return;
        }
        if (!isNeedSetCookies()) {
          break;
        }
        localObject = new a();
        ((a)localObject).mode = 2;
        ((a)localObject).baseUrl = paramString;
      } while (setCookiesIfNeeded((a)localObject));
      QLog.d("WEBVIEWCHECK", 2, "tendocpreload CustomWebView loadUrlOriginal111 url:" + paramString);
      if (!this.isFirstLoad) {
        break;
      }
      this.isFirstLoad = false;
      localObject = new HashMap();
      ((Map)localObject).put("url", paramString);
    } while ((this.mPluginEngine != null) && (this.mPluginEngine.i((Map)localObject)));
    paramString = (String)((Map)localObject).get("url");
    WebAccelerateHelper.getInstance().checkCookie(paramString);
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WEBVIEWCHECK", 2, "tendocpreload CustomWebView loadUrlOriginal222 url:" + jqo.filterKeyForLog(paramString, new String[0]));
      }
      if (((paramString.startsWith("http")) || (paramString.startsWith("data:"))) && (!paramString.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
        addContextLog(jqo.filterKeyForLog(paramString, new String[0]));
      }
      super.loadUrl(paramString);
      return;
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.attachedToWindow = true;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.attachedToWindow = false;
    if (this.isDestroyed) {
      ThreadManagerV2.getUIHandlerV2().postDelayed(new CustomWebView.3(this), 1000L);
    }
  }
  
  public void onPause()
  {
    this.isPaused = true;
    super.onPause();
  }
  
  public void onResume()
  {
    this.isPaused = false;
    super.onResume();
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mt != null) {
      this.mt.n(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void recordHttpStream(boolean paramBoolean)
  {
    try
    {
      IX5WebSettingsExtension localIX5WebSettingsExtension = getSettingsExtension();
      if (localIX5WebSettingsExtension != null) {
        localIX5WebSettingsExtension.setRecordRequestEnabled(paramBoolean);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("CustomWebView", 2, "webkit not support request record!");
    }
  }
  
  public void resetForReuse()
  {
    super.resetForReuse();
    if (this.sonicSessionClient != null) {
      this.sonicSessionClient = null;
    }
    if ((this.cookiesCallback != null) && (!TextUtils.isEmpty(this.cookieUrl)))
    {
      SwiftBrowserCookieMonster localSwiftBrowserCookieMonster = SwiftBrowserCookieMonster.a(this.cookieUrl);
      if (localSwiftBrowserCookieMonster != null) {
        localSwiftBrowserCookieMonster.a(this.cookiesCallback);
      }
      this.cookiesCallback = null;
      this.cookieUrl = "";
    }
    this.attachedToWindow = false;
    this.isPaused = true;
    this.isDestroyed = false;
    this.isFirstLoad = true;
    this.needSetCookies = true;
    if (this.mOpenApiInfo != null)
    {
      this.mOpenApiInfo.destroy();
      this.mOpenApiInfo = null;
    }
    setIntent(null);
    setWebChromeClient(null);
    setWebViewClient(null);
    setDownloadListener(null);
    setOnLongClickListener(null);
    if (getX5WebViewExtension() != null) {
      getX5WebViewExtension().setWebViewClientExtension(null);
    }
    getView().setOnTouchListener(null);
    setMask(false);
    this.mPluginEngine = null;
  }
  
  public void saveToken(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, ArrayList<String> paramArrayList)
  {
    if (this.mOpenApiInfo == null) {
      this.mOpenApiInfo = new b();
    }
    this.mOpenApiInfo.appId = paramInt1;
    this.mOpenApiInfo.token = paramString2;
    this.mOpenApiInfo.UX = (paramInt1 + "_" + paramString1 + "_" + paramString2);
    this.mOpenApiInfo.frequency = paramInt2;
    this.mOpenApiInfo.expireTime = (NetConnInfoCenter.getServerTime() + paramInt3);
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      this.mOpenApiInfo.cW = new HashMap();
      paramString1 = paramArrayList.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (String)paramString1.next();
        this.mOpenApiInfo.cW.put(paramString2, Long.valueOf(0L));
      }
    }
  }
  
  public void setMask(boolean paramBoolean)
  {
    View localView = null;
    Context localContext = getContext();
    Object localObject = localContext;
    if ((localContext instanceof MutableContextWrapper)) {
      localObject = ((MutableContextWrapper)localContext).getBaseContext();
    }
    if ((localObject instanceof Activity))
    {
      localObject = (Activity)localObject;
      localView = ((Activity)localObject).findViewById(2131372394);
    }
    for (;;)
    {
      if (localObject == null) {}
      do
      {
        return;
        if (paramBoolean)
        {
          if (localView == null)
          {
            localView = new View(getContext());
            localView.setBackgroundColor(1711276032);
            localView.setId(2131372394);
            ((Activity)localObject).addContentView(localView, new ViewGroup.LayoutParams(-1, -1));
            return;
          }
          localView.setVisibility(0);
          return;
        }
      } while (localView == null);
      localView.setVisibility(8);
      return;
      localObject = null;
    }
  }
  
  public void setOnCustomScrollChangeListener(c paramc)
  {
    this.mt = paramc;
  }
  
  public void setPluginEngine(WebViewPluginEngine paramWebViewPluginEngine)
  {
    if (paramWebViewPluginEngine != this.mPluginEngine)
    {
      this.mPluginEngine = paramWebViewPluginEngine;
      if (paramWebViewPluginEngine != null) {
        paramWebViewPluginEngine.e(this);
      }
    }
  }
  
  public void setSonicClient(SonicClientImpl paramSonicClientImpl)
  {
    this.sonicSessionClient = paramSonicClientImpl;
  }
  
  public class a
  {
    public String UW;
    String baseUrl;
    public String data;
    public String encoding;
    public String mimeType;
    public int mode = 1;
    
    a() {}
  }
  
  public static class b
  {
    public String UX;
    public int appId;
    public HashMap<String, Long> cW;
    public long expireTime;
    public int frequency;
    public String token;
    
    public void destroy()
    {
      if (this.cW != null) {
        this.cW.clear();
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void n(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.CustomWebView
 * JD-Core Version:    0.7.0.1
 */