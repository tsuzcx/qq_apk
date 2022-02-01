package com.tencent.qapmsdk.resource;

import android.app.Activity;
import android.os.Handler;
import android.support.annotation.NonNull;
import com.tencent.qapmsdk.common.activty.IForeBackInterface;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.resource.runnable.DumpSampleFileRunnable;

class ResourceMonitor$1
  implements IForeBackInterface
{
  ResourceMonitor$1(ResourceMonitor paramResourceMonitor) {}
  
  public void onBackground(@NonNull Activity paramActivity)
  {
    paramActivity = new Handler(ThreadManager.getMonitorThreadLooper());
    DumpSampleFileRunnable localDumpSampleFileRunnable = DumpSampleFileRunnable.getInstance();
    localDumpSampleFileRunnable.setCanReport(true);
    paramActivity.post(localDumpSampleFileRunnable);
  }
  
  public void onCreate(@NonNull Activity paramActivity) {}
  
  public void onDestroy(@NonNull Activity paramActivity) {}
  
  public void onForeground(@NonNull Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.resource.ResourceMonitor.1
 * JD-Core Version:    0.7.0.1
 */