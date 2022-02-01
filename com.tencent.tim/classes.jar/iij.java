import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class iij
  implements ComponentCallbacks2
{
  iij(iii paramiii) {}
  
  private void kC(int paramInt)
  {
    VideoController localVideoController = this.a.mApp.b();
    if (localVideoController != null) {
      localVideoController.a("lowMemoryLevel", String.valueOf(paramInt));
    }
    try
    {
      ActivityManager localActivityManager = (ActivityManager)BaseApplicationImpl.getApplication().getApplicationContext().getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      localActivityManager.getMemoryInfo(localMemoryInfo);
      localVideoController = localVideoController.a("availMem", String.valueOf(localMemoryInfo.availMem / 1048576L)).a("threshold", String.valueOf(localMemoryInfo.threshold / 1048576L));
      if (localMemoryInfo.lowMemory) {}
      for (paramInt = 1;; paramInt = 0)
      {
        localVideoController.a("lowMemory", String.valueOf(paramInt));
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      igd.aL("GMemoryMonitor", localThrowable.getMessage());
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GMemoryMonitor", 2, "onConfigurationChanged called");
    }
  }
  
  public void onLowMemory()
  {
    QLog.d("GMemoryMonitor", 1, "onLowMemory called");
    this.a.z(-10, this.a.mApp.RD);
    kC(-10);
  }
  
  public void onTrimMemory(int paramInt)
  {
    if (paramInt >= 15) {
      ikp.r(41, paramInt);
    }
    if (paramInt == 15)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GMemoryMonitor", 2, "onTrimMemory called ,level = " + paramInt);
      }
      this.a.z(paramInt, this.a.mApp.RD);
      ((ikr)this.a.mApp.a(4)).r(27, paramInt);
      kC(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iij
 * JD-Core Version:    0.7.0.1
 */