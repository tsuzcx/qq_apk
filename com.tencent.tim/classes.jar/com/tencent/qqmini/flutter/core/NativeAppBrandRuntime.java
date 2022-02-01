package com.tencent.qqmini.flutter.core;

import android.content.Context;
import com.tencent.qqmini.flutter.core.page.tissue.TissuePageContainer;
import com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime;
import com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer;
import com.tencent.qqmini.miniapp.core.service.IAppBrandService;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine;
import io.flutter.view.FlutterNativeView;

public class NativeAppBrandRuntime
  extends BaseAppBrandRuntime
{
  private static final String TAG = "AppBrandRuntime";
  private BaselibLoader.BaselibContent mBaselibContent;
  private FlutterNativeView nativeView;
  
  public NativeAppBrandRuntime(Context paramContext)
  {
    super(paramContext);
    this.mEventListener = new NativeEventListener(this);
  }
  
  public BaselibLoader.BaselibContent getBaselibContent()
  {
    return this.mBaselibContent;
  }
  
  public void init(IAppBrandService paramIAppBrandService)
  {
    super.init(paramIAppBrandService);
    paramIAppBrandService = new TissuePageContainer(this, this.mEventListener);
    paramIAppBrandService.init(null);
    this.pageContainer = paramIAppBrandService;
    paramIAppBrandService.setNativeView(this.nativeView);
  }
  
  public void onLoadMiniAppInfo(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, String paramString)
  {
    QMLog.i("AppBrandRuntime", " [MiniLifecycle] onLoadMiniAppInfo");
    QMLog.i("AppBrandRuntime", "onLoadMiniAppInfo miniAppInfo=" + paramMiniAppInfo + ",fromReload=" + paramBoolean);
    this.mMiniAppInfo = paramMiniAppInfo;
    this.jsPluginEngine.onCreate(this);
    this.appBrandService.setApkgInfo((ApkgInfo)paramMiniAppInfo.apkgInfo);
    this.pageContainer.setMiniAppInfo(paramMiniAppInfo);
    launchPage(paramMiniAppInfo, paramBoolean, paramString);
  }
  
  public void onRuntimeDestroy() {}
  
  public void setBaselibContent(BaselibLoader.BaselibContent paramBaselibContent)
  {
    this.mBaselibContent = paramBaselibContent;
  }
  
  public void setFlutterNativeView(FlutterNativeView paramFlutterNativeView)
  {
    this.nativeView = paramFlutterNativeView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.NativeAppBrandRuntime
 * JD-Core Version:    0.7.0.1
 */