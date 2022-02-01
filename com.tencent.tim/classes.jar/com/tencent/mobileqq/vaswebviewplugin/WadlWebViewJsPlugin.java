package com.tencent.mobileqq.vaswebviewplugin;

import aqzd;
import asbt;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.wadl.WadlJsBridge;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WadlWebViewJsPlugin
  extends aqzd
{
  public static final String PLUGIN_NAMESPACE = "wadl_download";
  public static final String TAG = "WadlWebViewJsPlugin";
  private Map<String, BaseInterface> apiMap;
  
  private void initMap()
  {
    this.apiMap = new HashMap();
    WadlJsBridge localWadlJsBridge = new WadlJsBridge(this.mRuntime.getActivity(), this.mRuntime.getWebView());
    this.apiMap.put(localWadlJsBridge.getInterfaceName(), localWadlJsBridge);
  }
  
  public Method getJsMethod(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = (BaseInterface)this.apiMap.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.getClass().getDeclaredMethods();
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        Method localMethod = paramString1[i];
        if ((localMethod.getName().equals(paramString2)) && (localMethod.getParameterTypes().length == paramInt)) {
          return localMethod;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public String getNameSpace()
  {
    return "wadl_download";
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934593L) {}
    return false;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    String str = null;
    paramString1 = null;
    if (this.apiMap == null) {
      initMap();
    }
    BaseInterface localBaseInterface = (BaseInterface)this.apiMap.get(paramString2);
    int i;
    if (localBaseInterface != null)
    {
      asbt.i("WadlWebViewJsPlugin", "handleJsRequest pkgName=" + paramString2 + ",methodName=" + paramString3);
      Method[] arrayOfMethod = localBaseInterface.getClass().getDeclaredMethods();
      int j = arrayOfMethod.length;
      i = 0;
      str = paramString1;
      if (i < j)
      {
        paramString2 = arrayOfMethod[i];
        if ((!paramString2.getName().equals(paramString3)) || (paramString2.getParameterTypes().length != paramVarArgs.length)) {
          break label220;
        }
        paramString1 = paramString2;
      }
    }
    label220:
    for (;;)
    {
      i += 1;
      break;
      if (str != null) {
        try
        {
          if (paramVarArgs.length == 0) {}
          for (paramString1 = str.invoke(localBaseInterface, new Object[0]);; paramString1 = str.invoke(localBaseInterface, paramVarArgs))
          {
            paramString2 = str.getReturnType();
            if ((paramString2 != Void.TYPE) && (paramString2 != Void.class)) {
              break;
            }
            if (paramJsBridgeListener == null) {
              break label223;
            }
            paramJsBridgeListener.onComplete(null);
            break label223;
          }
          if (paramJsBridgeListener == null) {
            break label223;
          }
          paramJsBridgeListener.onComplete(paramString1);
        }
        catch (Exception paramJsBridgeListener) {}
      }
      return false;
    }
    label223:
    return true;
  }
  
  public void onAppRuntimeReady(AppInterface paramAppInterface) {}
  
  public void onCreate() {}
  
  public void onDestroy()
  {
    if (this.apiMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.apiMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        try
        {
          ((BaseInterface)((Map.Entry)localIterator.next()).getValue()).destroy();
        }
        catch (Exception localException) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.WadlWebViewJsPlugin
 * JD-Core Version:    0.7.0.1
 */