package com.tencent.qqmini.sdk.plugins;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.cache.Storage;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.URLUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.manager.LoginManager;
import org.json.JSONObject;

@JsPlugin
public class StorageJsPlugin
  extends BaseJsPlugin
{
  private static final String DEFAULT_DATA_TPYE = "String";
  private static final String TAG = "StorageJsPlugin";
  private SharedPreferences mSharedPref;
  private Storage mStorage;
  
  public static String execStorageTask(String paramString, StorageTask paramStorageTask)
  {
    if (paramString.endsWith("Sync")) {
      return paramStorageTask.run();
    }
    ThreadManager.executeOnDiskIOThreadPool(new StorageJsPlugin.1(paramStorageTask));
    return "";
  }
  
  @JsEvent({"clearStorage", "clearStorageSync"})
  public String handleClearStorage(RequestEvent paramRequestEvent)
  {
    return execStorageTask(paramRequestEvent.event, new StorageJsPlugin.6(this, paramRequestEvent));
  }
  
  @JsEvent({"getGlobalStorage"})
  public String handleGetGlobalStorage(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      localObject = URLUtil.encodeUrl(((JSONObject)localObject).optString("key"));
      return execStorageTask(paramRequestEvent.event, new StorageJsPlugin.7(this, (String)localObject, paramRequestEvent));
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        JSONObject localJSONObject = new JSONObject();
      }
    }
  }
  
  @JsEvent({"getStorage", "getStorageSync"})
  public String handleGetStorage(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      localObject = URLUtil.encodeUrl(((JSONObject)localObject).optString("key"));
      return execStorageTask(paramRequestEvent.event, new StorageJsPlugin.3(this, (String)localObject, paramRequestEvent));
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        JSONObject localJSONObject = new JSONObject();
      }
    }
  }
  
  @JsEvent({"getStorageInfo", "getStorageInfoSync"})
  public String handleGetStorageInfo(RequestEvent paramRequestEvent)
  {
    return execStorageTask(paramRequestEvent.event, new StorageJsPlugin.4(this, paramRequestEvent));
  }
  
  @JsEvent({"removeStorage", "removeStorageSync"})
  public String handleRemoveStorage(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      localObject = URLUtil.encodeUrl(((JSONObject)localObject).optString("key"));
      return execStorageTask(paramRequestEvent.event, new StorageJsPlugin.5(this, (String)localObject, paramRequestEvent));
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        JSONObject localJSONObject = new JSONObject();
      }
    }
  }
  
  @JsEvent({"setGlobalStorage"})
  public String handleSetGlobalStorage(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = URLUtil.encodeUrl(((JSONObject)localObject).optString("key"));
      localObject = ((JSONObject)localObject).optString("data");
      return execStorageTask(paramRequestEvent.event, new StorageJsPlugin.8(this, str, (String)localObject, paramRequestEvent));
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        JSONObject localJSONObject = new JSONObject();
      }
    }
  }
  
  @JsEvent({"setStorage", "setStorageSync"})
  public String handleSetStorage(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      String str1 = ((JSONObject)localObject).optString("key");
      if (TextUtils.isEmpty(str1)) {
        return paramRequestEvent.fail("key is empty");
      }
      str1 = URLUtil.encodeUrl(str1);
      String str2 = ((JSONObject)localObject).optString("data");
      localObject = ((JSONObject)localObject).optString("dataType", "String");
      if ("setStorage".equals(paramRequestEvent.event)) {
        ThreadManager.executeOnDiskIOThreadPool(new StorageJsPlugin.2(this, str1, str2, (String)localObject, paramRequestEvent));
      }
      if ("setStorageSync".equals(paramRequestEvent.event))
      {
        if (this.mStorage.writeSync(str1, (String)localObject, str2)) {
          return paramRequestEvent.ok();
        }
        paramRequestEvent = paramRequestEvent.fail("size limit reached");
        return paramRequestEvent;
      }
    }
    catch (Exception paramRequestEvent)
    {
      QMLog.e("StorageJsPlugin", paramRequestEvent.getMessage(), paramRequestEvent);
    }
    return "";
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    this.mSharedPref = this.mContext.getSharedPreferences("miniapp", 4);
    if (LoginManager.getInstance().getAccount() != null) {}
    for (paramIMiniAppContext = LoginManager.getInstance().getAccount();; paramIMiniAppContext = "")
    {
      String str = this.mApkgInfo.appId;
      this.mStorage = Storage.open(this.mContext, paramIMiniAppContext, str);
      return;
    }
  }
  
  public void onDestroy() {}
  
  static abstract interface StorageTask
  {
    public abstract String run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.StorageJsPlugin
 * JD-Core Version:    0.7.0.1
 */