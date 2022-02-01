package com.tencent.qqmini.flutter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.tissue.TissueEnv;
import com.tencent.qqmini.sdk.core.tissue.TissueGlobal;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.BaseRuntimeLoader.Creator;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.ICommonManager;

final class FlutterRuntimeLoader$1
  implements BaseRuntimeLoader.Creator<FlutterRuntimeLoader>
{
  public FlutterRuntimeLoader create(Context paramContext, Bundle paramBundle)
  {
    return new FlutterRuntimeLoader(paramContext);
  }
  
  public void doPrepareEngine(Bundle paramBundle) {}
  
  public boolean isEnginePrepared(Bundle paramBundle)
  {
    if ((TissueGlobal.tissueEnv != null) && (!TextUtils.isEmpty(TissueGlobal.tissueEnv.getNativeLibDir()))) {}
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    if (paramBundle != null) {
      try
      {
        paramBundle = (String)paramBundle.get("tissuenativelibdir");
        if (TissueGlobal.tissueEnv == null)
        {
          TissueGlobal.tissueEnv = new FlutterRuntimeLoader.1.1(this, paramBundle);
          AppLoaderFactory.g().getCommonManager().setTissueSoPath(paramBundle);
        }
        boolean bool = TextUtils.isEmpty(TissueGlobal.tissueEnv.getNativeLibDir());
        if (!bool) {}
        for (bool = true;; bool = false) {
          return bool;
        }
        return false;
      }
      catch (Throwable paramBundle) {}
    }
  }
  
  public boolean support(MiniAppInfo paramMiniAppInfo)
  {
    return (paramMiniAppInfo != null) && (paramMiniAppInfo.isEngineTypeMiniApp()) && (paramMiniAppInfo.supportNativeRenderMode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.flutter.FlutterRuntimeLoader.1
 * JD-Core Version:    0.7.0.1
 */