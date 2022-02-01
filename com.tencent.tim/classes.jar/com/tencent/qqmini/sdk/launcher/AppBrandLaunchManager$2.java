package com.tencent.qqmini.sdk.launcher;

import java.util.Comparator;
import java.util.List;

class AppBrandLaunchManager$2
  implements Comparator<AppBrandLaunchManager.MiniAppSubProcessorInfo>
{
  AppBrandLaunchManager$2(AppBrandLaunchManager paramAppBrandLaunchManager) {}
  
  public int compare(AppBrandLaunchManager.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo1, AppBrandLaunchManager.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo2)
  {
    return -(paramMiniAppSubProcessorInfo1.allMiniAppInfo.size() - paramMiniAppSubProcessorInfo2.allMiniAppInfo.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppBrandLaunchManager.2
 * JD-Core Version:    0.7.0.1
 */