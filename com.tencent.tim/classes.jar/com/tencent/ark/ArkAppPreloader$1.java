package com.tencent.ark;

import java.lang.ref.WeakReference;
import java.util.HashMap;

final class ArkAppPreloader$1
  implements Runnable
{
  ArkAppPreloader$1(WeakReference paramWeakReference, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    ArkAppPreloader.PreloadAppCallback localPreloadAppCallback;
    if (this.val$callbackRef != null)
    {
      localPreloadAppCallback = (ArkAppPreloader.PreloadAppCallback)this.val$callbackRef.get();
      if (localPreloadAppCallback != null) {
        localPreloadAppCallback.beginAppload(this.val$appName, this.val$condition);
      }
    }
    for (;;)
    {
      synchronized (ArkAppPreloader.access$000())
      {
        if (!ArkAppPreloader.access$000().containsKey(this.val$appName)) {
          break label496;
        }
        i = 1;
        if (i != 0)
        {
          ArkAppPreloader.access$100().logE("ArkApp.ArkAppPreloader", String.format("profiling.preloadApp allready preload appName=%s", new Object[] { this.val$appName }));
          if (localPreloadAppCallback != null) {
            localPreloadAppCallback.onAppLoaded(true, this.val$appName, this.val$condition);
          }
          return;
          localPreloadAppCallback = null;
        }
      }
      ark.Application localApplication = ark.Application.Create(this.val$appName, this.val$path);
      if (localApplication == null)
      {
        if (localObject1 != null) {
          localObject1.onAppLoaded(false, this.val$appName, this.val$condition);
        }
        ArkAppPreloader.access$100().logE("ArkApp.ArkAppPreloader", String.format("profiling.preloadApp failed!appName=%s,path=%s", new Object[] { this.val$appName, this.val$path }));
        return;
      }
      ArkAppPreloader.PreloadAppInfo localPreloadAppInfo = new ArkAppPreloader.PreloadAppInfo();
      localPreloadAppInfo.application = localApplication;
      localPreloadAppInfo.appName = this.val$appName;
      localPreloadAppInfo.appPath = this.val$path;
      localPreloadAppInfo.storagePath = this.val$storagePath;
      localPreloadAppInfo.cachePath = this.val$cachePath;
      localPreloadAppInfo.resPath = this.val$resPath;
      localPreloadAppInfo.callbackRef = new WeakReference(localObject1);
      synchronized (ArkAppPreloader.access$000())
      {
        if (!ArkAppPreloader.access$000().containsKey(this.val$appName)) {
          ArkAppPreloader.access$000().put(this.val$appName, localPreloadAppInfo);
        }
        ArkAppPreloader.access$100().logI("ArkApp.ArkAppPreloader", String.format("profiling.preloadApp load application, appName=%s,path=%s,application=%h", new Object[] { this.val$appName, this.val$path, localApplication }));
        if (!localApplication.Load(this.val$storagePath, this.val$resPath, this.val$cachePath))
        {
          ArkAppPreloader.access$100().logE("ArkApp.ArkAppPreloader", String.format("profiling.preloadApp load application failed!appName=%s,path=%s,application=%h", new Object[] { this.val$appName, this.val$path, localApplication }));
          localApplication.Release();
          if (localObject1 != null) {
            localObject1.onAppLoaded(false, this.val$appName, this.val$condition);
          }
          synchronized (ArkAppPreloader.access$000())
          {
            ArkAppPreloader.access$000().remove(this.val$appName);
            return;
          }
        }
      }
      if (localObject2 != null) {
        localObject2.onAppLoaded(true, this.val$appName, this.val$condition);
      }
      ArkAppPreloader.access$100().logI("ArkApp.ArkAppPreloader", String.format("profiling.preloadApp load application success! appName=%s,path=%s,application=%h", new Object[] { this.val$appName, this.val$path, localApplication }));
      return;
      label496:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkAppPreloader.1
 * JD-Core Version:    0.7.0.1
 */