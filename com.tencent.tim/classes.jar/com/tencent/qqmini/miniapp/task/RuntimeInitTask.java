package com.tencent.qqmini.miniapp.task;

import android.content.Context;
import com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime;
import com.tencent.qqmini.miniapp.core.service.IAppBrandService;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.launcher.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.task.MainThreadTask;

@ClassTag(tag="RuntimeInitTask")
public class RuntimeInitTask
  extends MainThreadTask
{
  private BaseAppBrandRuntime appBrandRuntime;
  
  public RuntimeInitTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    super(paramContext, paramBaseRuntimeLoader);
  }
  
  public void executeInMainThread()
  {
    MiniAppReportManager2.reportLaunchPiecewise(202, "", getRuntimeLoader().getMiniAppInfoForReport());
    MiniAppInfo localMiniAppInfo = getRuntimeLoader().getMiniAppInfo();
    IAppBrandService localIAppBrandService = getAppBrandService();
    this.appBrandRuntime = ((BaseAppBrandRuntime)getRuntimeLoader().getRuntime());
    if ((this.appBrandRuntime != null) && (localIAppBrandService != null) && (localMiniAppInfo != null))
    {
      this.appBrandRuntime.init(localIAppBrandService);
      this.appBrandRuntime.loadMiniApp(localMiniAppInfo);
      onTaskSucceed();
      return;
    }
    onTaskFailed();
  }
  
  public void executeStartTime()
  {
    MiniAppReportManager2.reportLaunchPiecewise(222, "", getRuntimeLoader().getMiniAppInfoForReport());
  }
  
  public BaseAppBrandRuntime getAppBrandRuntime()
  {
    return this.appBrandRuntime;
  }
  
  protected IAppBrandService getAppBrandService()
  {
    ServiceInitTask localServiceInitTask = (ServiceInitTask)getRuntimeLoader().getTask(ServiceInitTask.class);
    if (localServiceInitTask != null) {
      return localServiceInitTask.getJsService();
    }
    return null;
  }
  
  public void onTaskSucceed()
  {
    super.onTaskSucceed();
    MiniAppReportManager2.reportLaunchPiecewise(203, "", getRuntimeLoader().getMiniAppInfoForReport());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.task.RuntimeInitTask
 * JD-Core Version:    0.7.0.1
 */