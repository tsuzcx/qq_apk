package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import aqzv;
import aram;
import aran;
import araz;
import araz.e;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import jqo;
import org.json.JSONObject;

public class WebViewPlugin
{
  public static final String KEY_ERROR_CODE = "errorCode";
  public static final String KEY_PERFORMANCE = "performanceData";
  public static final String KEY_REQUEST = "requestData";
  public static final String KEY_RESPONSE = "responseData";
  public static final String KEY_TARGET = "target";
  public static final String KEY_URL = "url";
  public static final int RECODE_FAILED_FREQUENCY_LIMIT = 5;
  public static final int RECODE_FAILED_NATIVE_ERROR = -100;
  public static final int RECODE_FAILED_NO_SUCH_METHOD = 3;
  public static final int RECODE_FAILED_PARAMS_ERROR = 4;
  public static final int RECODE_FAILED_PERMISSION_DENIED = 1;
  public static final int RECODE_FAILED_TOKEN_VERIFY_TIME_OUT = 2;
  public static final int RECODE_SUCCESSED = 0;
  public static final int TARGET_LEFT_VIEW = 1;
  public static final int TARGET_NAV_BACK = 2;
  public static final int TARGET_SYS_BACK = 3;
  public final String TAG = getClass().getSimpleName();
  AtomicBoolean inited = new AtomicBoolean(false);
  public boolean isDestroy;
  public HashMap<String, JsBridgeListener> mOpenApiListeners;
  public String mPluginNameSpace = "";
  public a mRuntime;
  public long pluginEventFlag;
  
  public static JSONObject getJsonFromJSBridge(String paramString)
  {
    int i;
    try
    {
      i = paramString.indexOf("=");
      if ((i == -1) || (i + 1 > paramString.length() - 1)) {
        throw new Exception("illegal json");
      }
    }
    catch (Exception localException)
    {
      QLog.e("WebViewPlugin", 1, "getJsonFromJSBridge error!" + paramString, localException);
      return null;
    }
    JSONObject localJSONObject = new JSONObject(URLDecoder.decode(paramString.substring(i + 1), "UTF-8"));
    return localJSONObject;
  }
  
  public static String toJsScript(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    return "window.mqq && mqq.execEventCallback && mqq.execEventCallback(" + jqo.toJsString(paramString) + "," + String.valueOf(paramJSONObject1) + "," + String.valueOf(paramJSONObject2) + ");";
  }
  
  public void addOpenApiListenerIfNeeded(String paramString, JsBridgeListener paramJsBridgeListener)
  {
    if ((paramJsBridgeListener != null) && (paramJsBridgeListener.cXk))
    {
      if (this.mOpenApiListeners == null) {
        this.mOpenApiListeners = new HashMap();
      }
      this.mOpenApiListeners.put(paramString, paramJsBridgeListener);
    }
  }
  
  final void bindFragment(WebViewFragment paramWebViewFragment)
  {
    if (this.mRuntime != null)
    {
      this.mRuntime.a(paramWebViewFragment);
      return;
    }
    throw new IllegalArgumentException("plugin runtime must be init");
  }
  
  @Deprecated
  public void callJs(String paramString)
  {
    if (this.isDestroy) {}
    for (;;)
    {
      return;
      if (this.mRuntime != null) {}
      for (CustomWebView localCustomWebView = this.mRuntime.getWebView(); localCustomWebView != null; localCustomWebView = null)
      {
        localCustomWebView.callJs(paramString);
        return;
      }
    }
  }
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    if (this.isDestroy) {}
    for (;;)
    {
      return;
      if (this.mRuntime != null) {}
      for (CustomWebView localCustomWebView = this.mRuntime.getWebView(); localCustomWebView != null; localCustomWebView = null)
      {
        localCustomWebView.callJs(paramString, paramVarArgs);
        return;
      }
    }
  }
  
  public void callJs4OpenApi(JsBridgeListener paramJsBridgeListener, int paramInt, String paramString)
  {
    if (this.isDestroy) {}
    for (;;)
    {
      return;
      if (this.mRuntime != null) {}
      for (CustomWebView localCustomWebView = this.mRuntime.getWebView(); localCustomWebView != null; localCustomWebView = null)
      {
        localCustomWebView.callJs4OpenApi(paramJsBridgeListener, paramInt, new String[] { paramString });
        return;
      }
    }
  }
  
  public void callJs4OpenApiIfNeeded(String paramString, int paramInt, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mOpenApiListeners != null)
    {
      bool1 = bool2;
      if (this.mOpenApiListeners.containsKey(paramString))
      {
        callJs4OpenApi((JsBridgeListener)this.mOpenApiListeners.remove(paramString), paramInt, JsBridgeListener.a(paramInt, paramObject, null));
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG + ".troop.openapi", 2, "callJs4OpenApiIfNeeded, methodName:" + paramString + "| callJs4OpenApi:" + bool1);
    }
  }
  
  public void callJs4OpenApiIfNeeded(String paramString1, int paramInt, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mOpenApiListeners != null)
    {
      bool1 = bool2;
      if (this.mOpenApiListeners.containsKey(paramString1))
      {
        callJs4OpenApi((JsBridgeListener)this.mOpenApiListeners.remove(paramString1), paramInt, JsBridgeListener.a(paramInt, null, paramString2));
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG + ".troop.openapi", 2, "callJs4OpenApiIfNeeded, methodName:" + paramString1 + "| callJs4OpenApi:" + bool1);
    }
  }
  
  public void dispatchJsEvent(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    callJs(toJsScript(paramString, paramJSONObject1, paramJSONObject2));
  }
  
  public final <T> T getBrowserComponent(int paramInt)
  {
    if (this.mRuntime != null)
    {
      WebViewFragment localWebViewFragment = this.mRuntime.b();
      if (localWebViewFragment != null) {
        return localWebViewFragment.b().q(paramInt);
      }
      if ((this.mRuntime.getActivity() instanceof araz.e)) {
        return ((araz.e)this.mRuntime.getActivity()).b().q(paramInt);
      }
    }
    return null;
  }
  
  public int getRequestCode(byte paramByte)
  {
    if (this.mRuntime != null) {}
    for (aqzv localaqzv = this.mRuntime.a(this.mRuntime.getActivity()); (localaqzv instanceof aran); localaqzv = null) {
      return ((aran)localaqzv).switchRequestCode(this, paramByte);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(this.TAG, 4, "startActivityForResult not called, activity need implement Interface WebViewPluginContainer");
    }
    return -1;
  }
  
  protected Object handleEvent(String paramString, long paramLong)
  {
    return null;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    return false;
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    return false;
  }
  
  final void initRuntime(Activity paramActivity, AppInterface paramAppInterface)
  {
    if (this.inited.compareAndSet(false, true)) {
      this.mRuntime = new a(paramActivity, paramAppInterface);
    }
  }
  
  protected void onActivityReady() {}
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt) {}
  
  public void onAppRuntimeReady(AppInterface paramAppInterface) {}
  
  protected void onCreate() {}
  
  protected void onDestroy()
  {
    this.isDestroy = true;
    if (this.mOpenApiListeners != null) {
      this.mOpenApiListeners.clear();
    }
  }
  
  public void onPostPluginAsyncTask() {}
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    if ((paramCustomWebView != null) && (this.mRuntime != null)) {
      this.mRuntime.mWebView = new WeakReference(paramCustomWebView);
    }
  }
  
  public void postPluginAsyncTask(Runnable paramRunnable)
  {
    ThreadManager.post(paramRunnable, 5, new aram(this), false);
  }
  
  public WebViewPlugin setHandler(Handler paramHandler)
  {
    return this;
  }
  
  public void setWebUiInterface(aqzv paramaqzv)
  {
    if (paramaqzv != null) {
      this.mRuntime.setUiInterface(paramaqzv);
    }
  }
  
  public void startActivityForResult(Intent paramIntent, byte paramByte)
  {
    Activity localActivity = null;
    aqzv localaqzv;
    if (this.mRuntime != null)
    {
      localaqzv = this.mRuntime.a(this.mRuntime.getActivity());
      if (this.mRuntime != null) {
        localActivity = this.mRuntime.getActivity();
      }
      if (!(localaqzv instanceof aran)) {
        break label67;
      }
      ((aran)localaqzv).pluginStartActivityForResult(this, paramIntent, paramByte);
    }
    label67:
    do
    {
      return;
      localaqzv = null;
      break;
      if ((localActivity instanceof aran))
      {
        ((aran)localActivity).pluginStartActivityForResult(this, paramIntent, paramByte);
        return;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d(this.TAG, 4, "startActivityForResult not called, activity need implement Interface WebViewPluginContainer");
  }
  
  public static class a
  {
    WeakReference<aqzv> ds = null;
    WeakReference<Activity> mActivity;
    WeakReference<WebViewFragment> mFragment = null;
    WeakReference<CustomWebView> mWebView;
    WeakReference<AppInterface> n;
    
    public a(Activity paramActivity, AppInterface paramAppInterface)
    {
      this.mActivity = new WeakReference(paramActivity);
      this.n = new WeakReference(paramAppInterface);
      if ((paramActivity instanceof aqzv)) {
        this.ds = new WeakReference((aqzv)paramActivity);
      }
    }
    
    public aqzv a(Activity paramActivity)
    {
      if (this.ds != null) {
        return (aqzv)this.ds.get();
      }
      return null;
    }
    
    public AppInterface a()
    {
      return (AppInterface)this.n.get();
    }
    
    public void a(WebViewFragment paramWebViewFragment)
    {
      if (paramWebViewFragment != null)
      {
        this.mFragment = new WeakReference(paramWebViewFragment);
        this.ds = new WeakReference(paramWebViewFragment);
      }
    }
    
    public WebViewFragment b()
    {
      if (this.mFragment != null) {
        return (WebViewFragment)this.mFragment.get();
      }
      return null;
    }
    
    public Activity getActivity()
    {
      return (Activity)this.mActivity.get();
    }
    
    public CustomWebView getWebView()
    {
      if (this.mWebView != null) {
        return (CustomWebView)this.mWebView.get();
      }
      return null;
    }
    
    public void setUiInterface(aqzv paramaqzv)
    {
      if (paramaqzv != null) {
        this.ds = new WeakReference(paramaqzv);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewPlugin
 * JD-Core Version:    0.7.0.1
 */