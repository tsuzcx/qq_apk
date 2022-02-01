package com.tencent.biz.webviewplugin;

import android.app.Activity;
import aqzd;
import aqze;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.appcommon.js.BaseJsCallBack;
import com.tencent.open.appcommon.js.DownloadInterface;
import com.tencent.open.appcommon.js.HttpInterface;
import com.tencent.open.appcommon.now.download.js.DownloadWebInterface;
import com.tencent.open.appstore.js.DINewForCommonWebView;
import com.tencent.open.export.js.VipDownloadInterface;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class OpenCenterPlugin
  extends aqzd
  implements aqze
{
  private Map<String, BaseInterface> apiMap;
  
  private void initMap()
  {
    this.apiMap = new HashMap();
    Object localObject = this.mRuntime.getActivity();
    BaseJsCallBack localBaseJsCallBack = new BaseJsCallBack((Activity)localObject);
    VipDownloadInterface localVipDownloadInterface = new VipDownloadInterface((Activity)localObject, this.mRuntime.getWebView());
    HttpInterface localHttpInterface = new HttpInterface((Activity)localObject, this.mRuntime.getWebView());
    com.tencent.open.appcommon.js.AppInterface localAppInterface = new com.tencent.open.appcommon.js.AppInterface((Activity)localObject, this.mRuntime.getWebView());
    DownloadInterface localDownloadInterface = new DownloadInterface((Activity)localObject, this.mRuntime.getWebView());
    DINewForCommonWebView localDINewForCommonWebView = new DINewForCommonWebView((Activity)localObject, this.mRuntime.getWebView());
    localObject = new DownloadWebInterface((Activity)localObject, this.mRuntime.getWebView());
    this.apiMap.put(localBaseJsCallBack.getInterfaceName(), localBaseJsCallBack);
    this.apiMap.put(localVipDownloadInterface.getInterfaceName(), localVipDownloadInterface);
    this.apiMap.put(localHttpInterface.getInterfaceName(), localHttpInterface);
    this.apiMap.put(localAppInterface.getInterfaceName(), localAppInterface);
    this.apiMap.put(localDownloadInterface.getInterfaceName(), localDownloadInterface);
    this.apiMap.put(localDINewForCommonWebView.getInterfaceName(), localDINewForCommonWebView);
    this.apiMap.put(((BaseInterface)localObject).getInterfaceName(), localObject);
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
  
  public String[] getMultiNameSpace()
  {
    return new String[] { "opencenter", "qqZoneAppList", "q_download_vip", "qzone_http", "qzone_app", "q_download", "q_download_now", "q_download_v2" };
  }
  
  public String getNameSpace()
  {
    return "opencenter";
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934593L) {
      OpenAppClient.J(this.mRuntime.a());
    }
    return false;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    Method[] arrayOfMethod = null;
    paramString1 = null;
    if (this.apiMap == null) {
      initMap();
    }
    BaseInterface localBaseInterface = (BaseInterface)this.apiMap.get(paramString2);
    paramString2 = arrayOfMethod;
    int i;
    if (localBaseInterface != null)
    {
      arrayOfMethod = localBaseInterface.getClass().getDeclaredMethods();
      int j = arrayOfMethod.length;
      i = 0;
      paramString2 = paramString1;
      if (i < j)
      {
        paramString2 = arrayOfMethod[i];
        if ((!paramString2.getName().equals(paramString3)) || (paramString2.getParameterTypes().length != paramVarArgs.length)) {
          break label184;
        }
        paramString1 = paramString2;
      }
    }
    label184:
    for (;;)
    {
      i += 1;
      break;
      if (paramString2 != null) {
        try
        {
          if (paramVarArgs.length == 0) {}
          for (paramString1 = paramString2.invoke(localBaseInterface, new Object[0]);; paramString1 = paramString2.invoke(localBaseInterface, paramVarArgs))
          {
            paramString2 = paramString2.getReturnType();
            if ((paramString2 != Void.TYPE) && (paramString2 != Void.class)) {
              break;
            }
            if (paramJsBridgeListener == null) {
              break label187;
            }
            paramJsBridgeListener.onComplete(null);
            break label187;
          }
          if (paramJsBridgeListener == null) {
            break label187;
          }
          paramJsBridgeListener.onComplete(paramString1);
        }
        catch (Exception paramJsBridgeListener) {}
      }
      return false;
    }
    label187:
    return true;
  }
  
  public void onAppRuntimeReady(com.tencent.common.app.AppInterface paramAppInterface) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OpenCenterPlugin
 * JD-Core Version:    0.7.0.1
 */