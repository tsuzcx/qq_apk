package com.tencent.qqmini.flutter.core.page.tissue;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.qflutter.log.qflutter_log.QflutterLogPlugin;
import com.tencent.qqmini.flutter.Registry;
import com.tencent.qqmini.miniapp.core.EventListener;
import com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer;
import com.tencent.qqmini.miniapp.util.URL;
import com.tencent.qqmini.sdk.core.Preloadable;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.tissue.TissueEnv;
import com.tencent.qqmini.sdk.core.tissue.TissueGlobal;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo;
import com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo.Builder;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.qqmini.sdk.widget.CapsuleButton;
import com.tencent.qqmini.sdk.widget.ToastView;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryCodec;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterRunArguments;
import io.flutter.view.FlutterView;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class TissuePageContainer
  implements IAppBrandPageContainer, Preloadable
{
  private static final String TAG = "TissueRenderer";
  private FlutterRunArguments arguments;
  private boolean firstPageShown = false;
  private FlutterView flutterView;
  private boolean isV8AfterFlutter = false;
  private ApkgInfo mApkgInfo;
  private EventListener mEventListener;
  private boolean mFromReload = false;
  private IMiniAppContext mMiniAppContext;
  private MiniAppInfo mMiniAppInfo;
  private FlutterNativeView mNativeView;
  private URL mStartUpURL;
  BasicMessageChannel messageChannel;
  MethodChannel methodChannel;
  private int pageCount = 0;
  private ToastView toastView;
  
  public TissuePageContainer(IMiniAppContext paramIMiniAppContext, EventListener paramEventListener)
  {
    this.mMiniAppContext = paramIMiniAppContext;
    this.mEventListener = paramEventListener;
  }
  
  private void flutterLaunch()
  {
    if (this.mApkgInfo != null) {
      if (!this.isV8AfterFlutter) {
        break label232;
      }
    }
    label232:
    for (Object localObject = "1";; localObject = "0")
    {
      MiniAppReportManager2.reportLaunchPiecewise(215, (String)localObject, this.mMiniAppContext.getMiniAppInfo());
      localObject = new HashMap();
      ((Map)localObject).put("apkgUnpackPath", this.mApkgInfo.apkgFolderPath);
      ((Map)localObject).put("appName", this.mApkgInfo.apkgName);
      ((Map)localObject).put("pagePath", this.mStartUpURL.getPath());
      ((Map)localObject).put("query", this.mStartUpURL.getQueryParam());
      ((Map)localObject).put("logLevel", Integer.valueOf(6 - QMLog.getLogLevel()));
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (this.mMiniAppContext != null)
      {
        bool1 = bool2;
        if (this.mMiniAppContext.getMiniAppInfo() != null)
        {
          bool1 = bool2;
          if (this.mMiniAppContext.getMiniAppInfo().appMode != null) {
            bool1 = this.mMiniAppContext.getMiniAppInfo().appMode.closeTopRightCapsule;
          }
        }
      }
      ((Map)localObject).put("topRightBtnHidden", Boolean.valueOf(bool1));
      QMLog.w("miniapp-start-TISSUE", " miniapp launch" + this.mApkgInfo.appId);
      sendMsgToFlutter("appLaunch", (Map)localObject);
      return;
    }
  }
  
  private void flutterLoadData(String paramString)
  {
    paramString = JSONUtil.toMap(JSONUtil.parse(paramString));
    if (paramString != null)
    {
      sendMsgToFlutter("appLoadData", paramString);
      return;
    }
    QMLog.e("TissueRenderer", "null load params");
  }
  
  private void sendMsgToFlutter(String paramString)
  {
    sendMsgToFlutter(paramString, new HashMap());
  }
  
  private void sendMsgToFlutter(String paramString, Map<String, Object> paramMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appPtr", Integer.valueOf(2333));
    localHashMap.put("method", paramString);
    localHashMap.put("data", paramMap);
    if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId())
    {
      this.messageChannel.send(localHashMap);
      return;
    }
    ThreadManager.getUIHandler().post(new TissuePageContainer.8(this, localHashMap));
  }
  
  public void cleanup(boolean paramBoolean) {}
  
  public String dispatchEventToNativeView(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    QMLog.d("miniapp-TISSUE", paramNativeViewRequestEvent.event + ": " + paramNativeViewRequestEvent.jsonParams);
    return null;
  }
  
  public void dispatchEventToWebView(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    if ("flutter_launch".equals(paramString1))
    {
      QMLog.d("miniapp-TISSUE", " app service load done");
      flutterLoadData(paramString2);
      return;
    }
    if ("operateVideoPlayer".equals(paramString1))
    {
      QMLog.d("QFV", " from app-service operateVideoPlayer:" + paramString2);
      sendMsgToFlutter("operateVideoPlayer", JSONUtil.toMap(JSONUtil.parse(paramString2)));
      return;
    }
    for (;;)
    {
      try
      {
        localObject = JSONUtil.parse(paramString2);
        HashMap localHashMap = new HashMap();
        localHashMap.put("event", paramString1);
        if (localObject != null) {
          continue;
        }
        localObject = new HashMap();
        localHashMap.put("data", localObject);
        if (paramArrayOfInt != null) {
          localHashMap.put("pageIDs", paramArrayOfInt);
        }
        if (this.messageChannel != null) {
          sendMsgToFlutter("publishHandler", localHashMap);
        }
      }
      catch (Exception paramArrayOfInt)
      {
        Object localObject;
        QMLog.e("miniapp-TISSUE", "", paramArrayOfInt);
        continue;
      }
      QMLog.d("miniapp-TISSUE", paramString1 + ": " + paramString2);
      return;
      localObject = JSONUtil.toMap((JSONObject)localObject);
    }
  }
  
  public boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public CapsuleButton getCapsuleButton()
  {
    return null;
  }
  
  public View getContentView()
  {
    return this.flutterView;
  }
  
  public int getNaviBarTextStyle()
  {
    return -1;
  }
  
  public int getNaviBarVisibility()
  {
    return 0;
  }
  
  public AppPageInfo getPageInfo(int paramInt)
  {
    AppPageInfo.Builder localBuilder = new AppPageInfo.Builder();
    Object localObject;
    if (this.mStartUpURL != null)
    {
      localObject = this.mStartUpURL.getFullUrl();
      localObject = localBuilder.setPageUrl((String)localObject);
      if (this.flutterView == null) {
        break label58;
      }
    }
    label58:
    for (paramInt = this.flutterView.getHeight();; paramInt = 0)
    {
      return ((AppPageInfo.Builder)localObject).setWindowHeight(paramInt).build();
      localObject = null;
      break;
    }
  }
  
  public String getPageOrientation()
  {
    return "";
  }
  
  public int getTabBarVisibility()
  {
    return 0;
  }
  
  public boolean hasToastView()
  {
    return (this.toastView != null) && (this.toastView.shown());
  }
  
  public void hideToastView()
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("TissueRenderer", "hideToastView toastView=" + this.toastView);
    }
    if (this.toastView != null)
    {
      this.toastView.hide();
      this.toastView = null;
    }
  }
  
  public void init(Object paramObject) {}
  
  public void launch(String paramString1, String paramString2)
  {
    this.mStartUpURL = new URL(paramString1);
  }
  
  public boolean navigateBack(int paramInt1, int paramInt2)
  {
    if (this.pageCount == 0) {
      return false;
    }
    sendMsgToFlutter("navigateBack", new TissuePageContainer.7(this, paramInt1, paramInt2));
    this.pageCount = Math.max(this.pageCount - paramInt1, 0);
    return true;
  }
  
  public void navigateTo(String paramString, int paramInt)
  {
    Object localObject = new URL(paramString);
    paramString = ((URL)localObject).getPath();
    localObject = ((URL)localObject).getQueryParam();
    this.pageCount += 1;
    sendMsgToFlutter("navigateTo", new TissuePageContainer.5(this, paramString, (Map)localObject, paramInt));
  }
  
  public void onAttachedToActivity(Activity paramActivity)
  {
    QMLog.w("miniapp-start-TISSUE", "flutterView start run" + System.currentTimeMillis());
    MiniAppReportManager2.reportLaunchPiecewise(212, "", this.mMiniAppContext.getMiniAppInfo());
    FlutterMain.setNativeLibDir(TissueGlobal.tissueEnv.getNativeLibDir());
    if (this.flutterView != null) {
      return;
    }
    QMLog.w("miniapp-start-TISSUE", "start create flutterView " + System.currentTimeMillis());
    this.flutterView = Flutter.createView(paramActivity, "", this.mNativeView);
    this.methodChannel = new MethodChannel(this.flutterView, "flutter_method_channel");
    this.methodChannel.setMethodCallHandler(new TissuePageContainer.1(this));
    this.messageChannel = new BasicMessageChannel(this.flutterView, "com.tencent.tissue/basic_channel", StandardMessageCodec.INSTANCE);
    this.messageChannel.setMessageHandler(new TissuePageContainer.2(this));
    new BasicMessageChannel(this.flutterView, "com.tencent.tissue/log_channel", BinaryCodec.INSTANCE).setMessageHandler(new TissuePageContainer.3(this));
    this.arguments = new FlutterRunArguments();
    this.arguments.bundlePath = FlutterMain.findAppBundlePath();
    this.arguments.entrypoint = "main";
    this.flutterView.runFromBundle(this.arguments);
    QflutterLogPlugin.setLog(new TissuePageContainer.4(this));
    Registry.registerWith(this.flutterView.getPluginRegistry());
    this.flutterView.onStart();
    this.flutterView.onPostResume();
    QMLog.w("miniapp-start-TISSUE", "flutterView run end" + System.currentTimeMillis());
    MiniAppReportManager2.reportLaunchPiecewise(213, "", this.mMiniAppContext.getMiniAppInfo());
  }
  
  public void onDestroy() {}
  
  public void onPause()
  {
    if (this.messageChannel != null) {
      sendMsgToFlutter("appDidDisappear");
    }
    if (this.mEventListener != null) {
      this.mEventListener.onWebViewEvent("onAppEnterBackground", "{}", 0);
    }
    if (this.flutterView != null) {
      this.flutterView.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.flutterView != null) {
      this.flutterView.onPostResume();
    }
    Object localObject = null;
    boolean bool;
    if ((this.mFromReload) && (this.mEventListener != null) && (this.mEventListener.isFirstDomReady()) && (!TextUtils.isEmpty(this.mMiniAppInfo.launchParam.entryPath)))
    {
      bool = true;
      localObject = this.mMiniAppInfo.launchParam.entryPath;
      this.mEventListener.reload(this.mMiniAppInfo.launchParam.entryPath);
    }
    for (;;)
    {
      if ((this.mEventListener != null) && (this.mEventListener.isFirstDomReady()) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        localObject = AppBrandUtil.getAppLaunchInfo((String)localObject, this.mMiniAppInfo);
      }
      try
      {
        ((JSONObject)localObject).put("reLaunch", bool);
        QMLog.i("TissueRenderer", "appLaunchInfo : " + ((JSONObject)localObject).toString());
        this.mEventListener.onWebViewEvent("onAppEnterForeground", ((JSONObject)localObject).toString(), 0);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QMLog.e("TissueRenderer", "appLaunchInfo error.", localThrowable);
        }
      }
      bool = false;
    }
  }
  
  public void onStop()
  {
    if (this.flutterView != null) {
      this.flutterView.onStop();
    }
  }
  
  public boolean operateCustomButton(String paramString, long paramLong, JSONObject paramJSONObject, View.OnClickListener paramOnClickListener)
  {
    return false;
  }
  
  public void redirectTo(String paramString, int paramInt)
  {
    paramString = new URL(paramString);
    sendMsgToFlutter("redirectTo", new TissuePageContainer.6(this, paramString.getPath(), paramString.getQueryParam(), paramInt));
  }
  
  public void setFromReload(boolean paramBoolean)
  {
    this.mFromReload = paramBoolean;
  }
  
  public boolean setMiniAIOEntranceVisible(boolean paramBoolean, JSONObject paramJSONObject)
  {
    return false;
  }
  
  public void setMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    this.mMiniAppInfo = paramMiniAppInfo;
    this.mApkgInfo = ((ApkgInfo)paramMiniAppInfo.apkgInfo);
  }
  
  public void setNativeView(FlutterNativeView paramFlutterNativeView)
  {
    this.mNativeView = paramFlutterNativeView;
  }
  
  public void setNaviVisibility(int paramInt) {}
  
  public void setTabBarVisibility(int paramInt) {}
  
  public void showToastView(int paramInt1, String paramString1, String paramString2, CharSequence paramCharSequence, int paramInt2, boolean paramBoolean)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("TissueRenderer", "showToastView toastView=" + this.toastView);
    }
    if (this.mMiniAppContext.getAttachedActivity() == null)
    {
      QMLog.w("TissueRenderer", "Failed to showToastView, activity is null");
      return;
    }
    if (this.toastView == null) {
      this.toastView = new ToastView(this.mMiniAppContext.getContext(), (ViewGroup)this.mMiniAppContext.getAttachedActivity().findViewById(16908290));
    }
    this.toastView.show(paramInt1, paramString1, paramString2, paramCharSequence, paramInt2, paramBoolean);
  }
  
  public void switchTab(String paramString) {}
  
  public boolean toggleDebugPanel()
  {
    MiniAppInfo localMiniAppInfo;
    if (this.mMiniAppContext != null)
    {
      localMiniAppInfo = this.mMiniAppContext.getMiniAppInfo();
      if (DebugUtil.getDebugEnabled(localMiniAppInfo)) {
        break label38;
      }
    }
    label38:
    for (boolean bool = true;; bool = false)
    {
      DebugUtil.setDebugEnabled(localMiniAppInfo, bool);
      return bool;
      localMiniAppInfo = null;
      break;
    }
  }
  
  public boolean toggleMonitorPanel()
  {
    return false;
  }
  
  public void updateToastMsg(String paramString)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("TissueRenderer", "updateToastMsg toastView=" + this.toastView);
    }
    if (this.toastView == null) {
      return;
    }
    this.toastView.updateMsg(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.page.tissue.TissuePageContainer
 * JD-Core Version:    0.7.0.1
 */