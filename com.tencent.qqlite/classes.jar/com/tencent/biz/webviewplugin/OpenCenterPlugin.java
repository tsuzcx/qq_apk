package com.tencent.biz.webviewplugin;

import android.app.Activity;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.JsWebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.open.appcommon.js.AppInterface;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.appcommon.js.BaseJsCallBack;
import com.tencent.open.appcommon.js.DownloadInterface;
import com.tencent.open.appcommon.js.HttpInterface;
import com.tencent.open.export.js.VipDownloadInterface;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class OpenCenterPlugin
  extends JsWebViewPlugin
{
  private static final String jdField_a_of_type_JavaLangString = "opencenter";
  private Map jdField_a_of_type_JavaUtilMap;
  
  public OpenCenterPlugin()
  {
    this.a = null;
  }
  
  private void a()
  {
    this.a = new HashMap();
    Object localObject = this.mRuntime.a();
    BaseJsCallBack localBaseJsCallBack = new BaseJsCallBack((Activity)localObject);
    VipDownloadInterface localVipDownloadInterface = new VipDownloadInterface((Activity)localObject, this.mRuntime.a());
    HttpInterface localHttpInterface = new HttpInterface((Activity)localObject, this.mRuntime.a());
    AppInterface localAppInterface = new AppInterface((Activity)localObject, this.mRuntime.a());
    localObject = new DownloadInterface((Activity)localObject, this.mRuntime.a());
    this.a.put(localBaseJsCallBack.getInterfaceName(), localBaseJsCallBack);
    this.a.put(localVipDownloadInterface.getInterfaceName(), localVipDownloadInterface);
    this.a.put(localHttpInterface.getInterfaceName(), localHttpInterface);
    this.a.put(localAppInterface.getInterfaceName(), localAppInterface);
    this.a.put(((BaseInterface)localObject).getInterfaceName(), localObject);
  }
  
  protected String a()
  {
    return "opencenter";
  }
  
  protected Method a(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = (BaseInterface)this.a.get(paramString1);
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
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    Method[] arrayOfMethod = null;
    paramString1 = null;
    if (this.a == null) {
      a();
    }
    BaseInterface localBaseInterface = (BaseInterface)this.a.get(paramString2);
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
            paramJsBridgeListener.a(null);
            break label187;
          }
          if (paramJsBridgeListener == null) {
            break label187;
          }
          paramJsBridgeListener.a(paramString1);
        }
        catch (Exception paramJsBridgeListener) {}
      }
      return false;
    }
    label187:
    return true;
  }
  
  protected void onCreate() {}
  
  protected void onDestroy()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.a.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((BaseInterface)((Map.Entry)localIterator.next()).getValue()).destroy();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OpenCenterPlugin
 * JD-Core Version:    0.7.0.1
 */