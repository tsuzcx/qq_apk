package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.app.Activity;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.ServiceOriginalWebview;
import com.tencent.mobileqq.mini.appbrand.page.ServiceWebview;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePluginManager;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePluginManager.PluginInfo;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class NativeFeatureJsPlugin
  extends BaseJsPlugin
{
  public static final String API_INVOKE_NATIVE_PLUGIN = "invokeNativePlugin";
  private static final String TAG = "NativeFeatureJsPlugin";
  Set<String> eventMap = new HashSet();
  Map<String, NativePlugin> plugins;
  
  public NativeFeatureJsPlugin()
  {
    this.eventMap.add("invokeNativePlugin");
  }
  
  private NativePlugin initPlugin(NativePluginManager.PluginInfo paramPluginInfo)
  {
    try
    {
      Class localClass = Class.forName(paramPluginInfo.getHandlerClass());
      if (!NativePlugin.class.isAssignableFrom(localClass))
      {
        QLog.e("NativeFeatureJsPlugin", 2, String.format("class [%s] should implements com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin", new Object[] { paramPluginInfo.getHandlerClass() }));
        return null;
      }
      QLog.i("NativeFeatureJsPlugin", 2, String.format("class [%s] initialized", new Object[] { paramPluginInfo.getHandlerClass() }));
      paramPluginInfo = (NativePlugin)NativePlugin.class.cast(localClass.newInstance());
      return paramPluginInfo;
    }
    catch (Throwable paramPluginInfo)
    {
      QLog.e("NativeFeatureJsPlugin", 2, "initPlugin err", paramPluginInfo);
    }
    return null;
  }
  
  private void initializeNativePlugins()
  {
    Object localObject = NativePluginManager.getPluginInfo();
    this.plugins = new ConcurrentHashMap(((Set)localObject).size());
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      NativePluginManager.PluginInfo localPluginInfo = (NativePluginManager.PluginInfo)((Iterator)localObject).next();
      NativePlugin localNativePlugin = initPlugin(localPluginInfo);
      if (localNativePlugin != null) {
        this.plugins.put(localPluginInfo.getApi_name(), localNativePlugin);
      }
    }
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    try
    {
      if (paramString1.equals("invokeNativePlugin"))
      {
        JSONObject localJSONObject = new JSONObject(paramString2);
        Object localObject = localJSONObject.optString("api_name", null);
        localObject = (NativePlugin)this.plugins.get(localObject);
        if (localObject != null) {
          ((NativePlugin)localObject).onInvoke(localJSONObject, new JSContextImpl(paramJsRuntime, paramString1, paramInt));
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("NativeFeatureJsPlugin", 1, "handleNativeRequest err", localThrowable);
      }
    }
    return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
    initializeNativePlugins();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.plugins != null) && (this.plugins.size() > 0))
    {
      Iterator localIterator = this.plugins.entrySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          NativePlugin localNativePlugin = (NativePlugin)((Map.Entry)localIterator.next()).getValue();
          if (localNativePlugin != null) {
            try
            {
              localNativePlugin.onDestroy();
            }
            catch (Throwable localThrowable)
            {
              QLog.e("NativeFeatureJsPlugin", 2, "destroy err", localThrowable);
            }
          }
        }
      }
    }
  }
  
  public Set<String> supportedEvents()
  {
    return this.eventMap;
  }
  
  static class JSContextImpl
    implements NativePlugin.JSContext
  {
    private int callbackId;
    private String eventName;
    private WeakReference<JsRuntime> jsRuntimeWeakReference;
    
    public JSContextImpl(JsRuntime paramJsRuntime, String paramString, int paramInt)
    {
      this.jsRuntimeWeakReference = new WeakReference(paramJsRuntime);
      this.eventName = paramString;
      this.callbackId = paramInt;
    }
    
    public void callJs(String paramString, JSONObject paramJSONObject)
    {
      JsRuntime localJsRuntime;
      String str;
      if (this.jsRuntimeWeakReference != null)
      {
        localJsRuntime = (JsRuntime)this.jsRuntimeWeakReference.get();
        if (localJsRuntime != null)
        {
          str = "custom_event_" + paramString;
          if (paramJSONObject != null) {
            break label61;
          }
        }
      }
      label61:
      for (paramString = "";; paramString = paramJSONObject.toString())
      {
        localJsRuntime.evaluateSubcribeJS(str, paramString, 0);
        return;
      }
    }
    
    public void evaluateCallback(boolean paramBoolean, JSONObject paramJSONObject, String paramString)
    {
      JsRuntime localJsRuntime;
      int i;
      if (this.jsRuntimeWeakReference != null)
      {
        localJsRuntime = (JsRuntime)this.jsRuntimeWeakReference.get();
        if (localJsRuntime != null)
        {
          i = this.callbackId;
          if (!paramBoolean) {
            break label57;
          }
        }
      }
      label57:
      for (paramJSONObject = ApiUtil.wrapCallbackOk(this.eventName, paramJSONObject).toString();; paramJSONObject = ApiUtil.wrapCallbackFail(this.eventName, paramJSONObject, paramString).toString())
      {
        localJsRuntime.evaluateCallbackJs(i, paramJSONObject);
        return;
      }
    }
    
    public Activity getActivity()
    {
      Object localObject;
      if (this.jsRuntimeWeakReference != null)
      {
        localObject = (JsRuntime)this.jsRuntimeWeakReference.get();
        if ((localObject instanceof ServiceWebview))
        {
          localObject = ((ServiceWebview)localObject).appBrandEventInterface;
          if ((localObject != null) && ((localObject instanceof AppBrandRuntime))) {
            return ((AppBrandRuntime)localObject).activity;
          }
          QLog.e("NativeFeatureJsPlugin", 1, "appBrandServiceEventInterface is null");
        }
      }
      for (;;)
      {
        return null;
        if ((localObject instanceof ServiceOriginalWebview))
        {
          localObject = ((ServiceOriginalWebview)localObject).appBrandEventInterface;
          if ((localObject != null) && ((localObject instanceof AppBrandRuntime))) {
            return ((AppBrandRuntime)localObject).activity;
          }
          QLog.e("NativeFeatureJsPlugin", 1, "appBrandServiceEventInterface is null");
        }
        else
        {
          QLog.e("NativeFeatureJsPlugin", 1, "runtime is null");
          continue;
          QLog.e("NativeFeatureJsPlugin", 1, "jsRuntimeWeakReference is null");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.NativeFeatureJsPlugin
 * JD-Core Version:    0.7.0.1
 */