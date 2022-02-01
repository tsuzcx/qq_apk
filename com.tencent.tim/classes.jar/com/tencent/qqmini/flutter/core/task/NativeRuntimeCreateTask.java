package com.tencent.qqmini.flutter.core.task;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.qqmini.flutter.core.NativeAppBrandRuntime;
import com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.core.tissue.TissueEnv;
import com.tencent.qqmini.sdk.core.tissue.TissueGlobal;
import com.tencent.qqmini.sdk.launcher.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.proxy.IFlutterProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.task.MainThreadTask;
import io.flutter.view.FlutterNativeView;
import java.io.File;
import java.lang.reflect.Method;

@ClassTag(tag="NativeRuntimeCreateTask")
public class NativeRuntimeCreateTask
  extends MainThreadTask
{
  public static final String FLUTTER_LOG_TAG = "miniapp-start-TISSUE";
  private static volatile String mLoadedAssetResPath;
  private IFlutterProxy flutterProxy = null;
  
  public NativeRuntimeCreateTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    super(paramContext, paramBaseRuntimeLoader);
  }
  
  private static boolean isFileExists(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length() <= 0) {}
    }
    try
    {
      bool1 = new File(paramString).exists();
      return bool1;
    }
    catch (Exception paramString)
    {
      QMLog.e("Tools.isFileExists", "" + paramString.getMessage());
    }
    return false;
  }
  
  private boolean loadAssetRes(String paramString)
  {
    paramString = paramString + "/res.apk";
    if ((mLoadedAssetResPath != null) && (mLoadedAssetResPath.equals(paramString))) {
      bool = true;
    }
    for (;;)
    {
      if (QMLog.isColorLevel()) {
        QMLog.d("miniapp-start-TISSUE", String.format("loadAssetRes, isSuccess: %s", new Object[] { Boolean.valueOf(bool) }));
      }
      return bool;
      if (isFileExists(paramString))
      {
        try
        {
          l1 = System.currentTimeMillis();
          AssetManager localAssetManager = getContext().getAssets();
          Method localMethod = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class });
          localMethod.setAccessible(true);
          localMethod.invoke(localAssetManager, new Object[] { paramString });
          l2 = System.currentTimeMillis();
        }
        catch (Exception paramString)
        {
          try
          {
            long l1;
            long l2;
            mLoadedAssetResPath = paramString;
            QMLog.d("miniapp-start-TISSUE", String.format("load asset file %s cost %s ms", new Object[] { paramString, Long.valueOf(l2 - l1) }));
            bool = true;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              bool = true;
            }
          }
          paramString = paramString;
          bool = false;
        }
        QMLog.e("miniapp-start-TISSUE", "loadAsset", paramString);
      }
      else
      {
        QMLog.e("miniapp-start-TISSUE", String.format("assetsPath: %s not exist", new Object[] { paramString }));
        bool = true;
      }
    }
  }
  
  public void executeInMainThread()
  {
    MiniAppReportManager2.reportLaunchPiecewise(200, "", getRuntimeLoader().getMiniAppInfoForReport());
    if (TissueGlobal.tissueEnv != null) {
      if (!loadAssetRes(TissueGlobal.tissueEnv.getNativeLibDir())) {
        QMLog.e("miniapp-start-TISSUE", "flutter loadAssetRes failed!!! enableFlutter=false");
      }
    }
    for (;;)
    {
      if (this.flutterProxy == null) {
        QMLog.e("miniapp-start-TISSUE", "enableFlutter=false, flutterProxy is null");
      }
      try
      {
        BaseRuntime localBaseRuntime = getRuntimeLoader().getRuntime();
        if (localBaseRuntime == null)
        {
          onTaskFailed();
          return;
          QMLog.e("miniapp-start-TISSUE", "enableFlutter=false, tissueEnv is null");
        }
        else
        {
          localBaseRuntime.onRuntimeCreate();
          this.flutterProxy.initFlutterRuntime(localBaseRuntime, getContext());
          FlutterNativeView localFlutterNativeView = new FlutterNativeView(this.mContext.getApplicationContext());
          ((NativeAppBrandRuntime)localBaseRuntime).setFlutterNativeView(localFlutterNativeView);
          onTaskSucceed();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("minisdk-start", "RuntimeCreateTask exception!", localThrowable);
        onTaskFailed();
      }
    }
  }
  
  public void executeStartTime()
  {
    MiniAppReportManager2.reportLaunchPiecewise(221, "", getRuntimeLoader().getMiniAppInfoForReport());
  }
  
  public BaseAppBrandRuntime getAppBrandRuntime()
  {
    return (BaseAppBrandRuntime)getRuntimeLoader().getRuntime();
  }
  
  public void onTaskSucceed()
  {
    super.onTaskSucceed();
    MiniAppReportManager2.reportLaunchPiecewise(201, "", getRuntimeLoader().getMiniAppInfoForReport());
  }
  
  public void reset()
  {
    super.reset();
  }
  
  public void setFlutterProxy(IFlutterProxy paramIFlutterProxy)
  {
    this.flutterProxy = paramIFlutterProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.task.NativeRuntimeCreateTask
 * JD-Core Version:    0.7.0.1
 */