package com.tencent.mobileqq.mini.appbrand.page;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.OnLoadServiceWebvieJsListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.utils.TbsLog;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class ServiceRemoteRuntime
  extends AbstactJsRuntime
{
  public static final String DEBUG_URL_TERNIMAL = "wss://q.qq.com/ws/terminal";
  public static final String TAG = "ServiceRemoteRuntime";
  public AppBrandServiceEventInterface appBrandEventInterface;
  private String appId;
  private ServiceWebview.Callback mCallback;
  private MiniAppWebSocket miniAppWebSocket;
  public int pageWebviewId;
  private String roomId;
  private String wsUrl;
  
  public ServiceRemoteRuntime(Context paramContext, String paramString1, ServiceWebview.Callback paramCallback, String paramString2, String paramString3, String paramString4)
  {
    super(paramContext, paramString1);
    this.appId = paramString2;
    this.wsUrl = paramString4;
    this.roomId = paramString3;
    Log.e("ServiceRemoteRuntime", "ServiceWebview init in thread --> " + paramString1);
    setCallback(paramCallback);
    if (shouldInitFramework()) {
      initFramework(paramContext, paramString2, paramString3, paramString4);
    }
  }
  
  private static String getA2Key()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null) {
      return "";
    }
    TicketManager localTicketManager = (TicketManager)localAppRuntime.getManager(2);
    if (localTicketManager != null) {
      return localTicketManager.getA2(localAppRuntime.getAccount());
    }
    return "";
  }
  
  private static Message obtainMessage(int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    return localMessage;
  }
  
  public void clearUp()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceRemoteRuntime", 2, "[setAppBrandEventInterface ] ");
    }
  }
  
  public void evaluateCallbackJs(int paramInt, String paramString)
  {
    QLog.i("miniapp-JS", 2, "evaluateCallbackJs");
    paramString = String.format("WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(paramInt), paramString });
    if (QLog.isColorLevel()) {
      QLog.d("miniapp-JS", 2, "[evaluateCallbackJs] callbackStr=" + paramString);
    }
    evaluteJs(paramString, null);
  }
  
  public void evaluateSubcribeJS(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceRemoteRuntime", 2, "[evaluateSubcribeJS ] 1");
    }
    this.mThreadHandler.post(new ServiceRemoteRuntime.2(this, paramString1, paramString2, paramInt));
  }
  
  public void evaluteJs(String paramString, ValueCallback paramValueCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceRemoteRuntime", 2, "[evaluteJs] ");
    }
    this.mThreadHandler.post(new ServiceRemoteRuntime.1(this, paramString, paramValueCallback));
  }
  
  public ApkgInfo getApkgInfo()
  {
    return null;
  }
  
  public MiniAppWebSocket getMiniAppWebSocket()
  {
    return this.miniAppWebSocket;
  }
  
  public int getPageWebViewId()
  {
    return 0;
  }
  
  public void initFramework(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    TbsLog.initIfNeed(paramContext);
    paramContext = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str = getA2Key();
    this.miniAppWebSocket = new MiniAppWebSocket(this.mThreadHandler, this);
    paramContext = paramString3 + "?appId=" + paramString1 + "&roomId=" + paramString2 + "&uin=" + paramContext + "&bytesSig=" + str;
    this.miniAppWebSocket.connect(paramContext);
    QLog.e("ServiceRemoteRuntime", 4, " connect: " + paramContext);
    onInitOver();
  }
  
  public void initService(ApkgInfo paramApkgInfo, AppBrandRuntime.OnLoadServiceWebvieJsListener paramOnLoadServiceWebvieJsListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceRemoteRuntime", 2, "[initService ] ");
    }
    this.miniAppWebSocket.setApkgInfo(paramApkgInfo);
    this.miniAppWebSocket.sendSetupContextCmd(paramOnLoadServiceWebvieJsListener);
  }
  
  public void initService(ApkgInfo paramApkgInfo, String paramString, AppBrandRuntime.OnLoadServiceWebvieJsListener paramOnLoadServiceWebvieJsListener) {}
  
  public void initWAServiceJS(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceRemoteRuntime", 2, "[initWAServiceJS ] ");
    }
    this.appServiceJsCallback.onReceiveValue("");
  }
  
  public boolean isDestroyed()
  {
    return false;
  }
  
  public void loadAppServiceJs(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceRemoteRuntime", 2, "[loadAppServiceJs ]");
    }
  }
  
  protected void onInitOver()
  {
    AppLoaderFactory.getAppLoaderManager().notifyMessage(obtainMessage(320));
    if (this.mCallback != null) {
      this.mCallback.onJscoreInited();
    }
  }
  
  public void postMessageToMainThread(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceRemoteRuntime", 2, "[postMessageToMainThread ] ");
    }
  }
  
  public void setApkgInfo(ApkgInfo paramApkgInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceRemoteRuntime", 2, "[setApkgInfo ] ");
    }
  }
  
  public void setAppBrandEventInterface(AppBrandServiceEventInterface paramAppBrandServiceEventInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceRemoteRuntime", 2, "[setAppBrandEventInterface ] ");
    }
    this.appBrandEventInterface = paramAppBrandServiceEventInterface;
    this.miniAppWebSocket.setAppBrandEventInterface(paramAppBrandServiceEventInterface);
  }
  
  public void setCallback(ServiceWebview.Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }
  
  protected boolean shouldInitFramework()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ServiceRemoteRuntime
 * JD-Core Version:    0.7.0.1
 */