package com.tencent.mobileqq.vaswebviewplugin;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public abstract class VasWebviewJsPluginV2
  extends VasWebviewJsPlugin
{
  private static final String TAG = "VasWebviewJsPluginV2";
  protected static final int THREADMODE_DEFAULT = 0;
  protected static final int THREADMODE_FILE = 2;
  protected static final int THREADMODE_UI = 1;
  private Map<String, SubscriberMethod> mMethodCache;
  
  public VasWebviewJsPluginV2(String paramString)
  {
    this.mPluginNameSpace = paramString;
  }
  
  private List<SubscriberMethod> findJSBMethod(Class<?> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    paramClass = paramClass.getDeclaredMethods();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramClass[i];
      if (QLog.isColorLevel())
      {
        QLog.e("VasWebviewJsPluginV2", 1, "method : " + ((Method)localObject).toString());
        QLog.e("VasWebviewJsPluginV2", 1, "annotations : " + Arrays.toString(((Method)localObject).getAnnotations()));
      }
      JsbridgeSubscribe localJsbridgeSubscribe = (JsbridgeSubscribe)((Method)localObject).getAnnotation(JsbridgeSubscribe.class);
      if ((localJsbridgeSubscribe != null) && (!TextUtils.isEmpty(localJsbridgeSubscribe.method())))
      {
        localObject = new SubscriberMethod((Method)localObject, localJsbridgeSubscribe.method(), localJsbridgeSubscribe.threadMode(), localJsbridgeSubscribe.args());
        if (QLog.isColorLevel()) {
          QLog.e("VasWebviewJsPluginV2", 1, "register : " + ((SubscriberMethod)localObject).toString());
        }
        localArrayList.add(localObject);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public final boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasWebviewJsPluginV2", 2, "handleJsRequest, url=" + paramString1 + ", nameSpace=" + paramString2 + ", method=" + paramString3);
    }
    if ((paramString1 == null) || (!this.mPluginNameSpace.equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    paramString2 = WebViewPlugin.getJsonFromJSBridge(paramString1);
    if (paramString2 == null) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VasWebviewJsPluginV2", 2, "handleJsRequest JSON = " + paramString2.toString());
    }
    String str = paramString2.optString("callback");
    if (this.mMethodCache == null)
    {
      Object localObject = findJSBMethod(getClass());
      try
      {
        if (this.mMethodCache == null)
        {
          this.mMethodCache = new HashMap(((List)localObject).size() * 2);
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            SubscriberMethod localSubscriberMethod = (SubscriberMethod)((Iterator)localObject).next();
            this.mMethodCache.put(localSubscriberMethod.scheme, localSubscriberMethod);
          }
        }
      }
      finally {}
    }
    paramString3 = (SubscriberMethod)this.mMethodCache.get(paramString3);
    if (paramString3 != null)
    {
      paramJsBridgeListener = paramString3.buildSafeRunnable(this, new JsData(str, paramJsBridgeListener, paramString1, paramVarArgs), paramString2);
      if (paramString3.threadMode == 0) {
        paramJsBridgeListener.run();
      }
      for (;;)
      {
        return true;
        if (paramString3.threadMode == 1) {
          ThreadManager.getUIHandler().post(paramJsBridgeListener);
        } else if (paramString3.threadMode == 2) {
          ThreadManager.getFileThreadHandler().post(paramJsBridgeListener);
        }
      }
    }
    QLog.e("VasWebviewJsPluginV2", 1, "not find jsbridge");
    return false;
  }
  
  public static class JsData
  {
    String[] args;
    String callbackId;
    JsBridgeListener listener;
    String url;
    
    public JsData(String paramString1, JsBridgeListener paramJsBridgeListener, String paramString2, String[] paramArrayOfString)
    {
      this.listener = paramJsBridgeListener;
      this.url = paramString2;
      this.args = paramArrayOfString;
      this.callbackId = paramString1;
    }
  }
  
  @Documented
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.METHOD})
  public static @interface JsbridgeSubscribe
  {
    String args() default "";
    
    String method();
    
    int threadMode() default 0;
  }
  
  static class SubscriberMethod
  {
    final String args;
    final Method method;
    final String scheme;
    final int threadMode;
    
    public SubscriberMethod(Method paramMethod, String paramString1, int paramInt, String paramString2)
    {
      this.method = paramMethod;
      this.threadMode = paramInt;
      this.scheme = paramString1;
      this.args = paramString2;
    }
    
    public Runnable buildSafeRunnable(VasWebviewJsPluginV2 paramVasWebviewJsPluginV2, VasWebviewJsPluginV2.JsData paramJsData, JSONObject paramJSONObject)
    {
      return new VasWebviewJsPluginV2.SubscriberMethod.1(this, new WeakReference(paramVasWebviewJsPluginV2), paramJsData, paramJSONObject);
    }
    
    public String toString()
    {
      return "SubscriberMethod{method=" + this.method + ", threadMode=" + this.threadMode + ", scheme='" + this.scheme + '\'' + ", args='" + this.args + '\'' + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPluginV2
 * JD-Core Version:    0.7.0.1
 */