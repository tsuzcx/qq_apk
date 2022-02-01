package cooperation.comic;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.text.TextUtils;
import aqgz;
import avcm;
import avcn;
import avco;
import avco.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public final class PluginPreloader$1
  implements Runnable
{
  public PluginPreloader$1(avcn paramavcn) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    int i = (int)(aqgz.getSystemAvaialbeMemory() >> 20);
    try
    {
      avco.a locala = new avco.a();
      Object localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          if (this.b.mProcessName.equals(localRunningAppProcessInfo.processName))
          {
            if ((this.b.dmg) && (!TextUtils.isEmpty(this.b.cJf)) && (!QIPCServerHelper.getInstance().isModuleRunning(this.b.cJf)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("PluginPreloader", 2, "pluginType:" + this.b.cdu + "  preload:ok:loadmodule " + this.b.cJf);
              }
              locala.ewq = 1;
              locala.cJg = "preload:ok:loadmodule";
              avco.a(localAppRuntime, this.b, i, locala);
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.d("PluginPreloader", 2, "pluginType:" + this.b.cdu + "  preload:fail:procexist " + this.b.mProcessName);
            }
            avcm.a(localAppRuntime, 1, this.b.cdu, this.b.ewp, 3, "preload:fail:procexist", i, new String[] { String.valueOf(this.b.mStrategyId) });
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "pluginType:" + this.b.cdu + " preload:fail:exception " + localException.getMessage());
      }
      avcm.a(localAppRuntime, 1, this.b.cdu, this.b.ewp, 3, "preload:fail:exception", i, new String[] { String.valueOf(this.b.mStrategyId), localException.getMessage() });
      return;
    }
    if (!this.b.a(localException))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, this.b.mProcessName + " is not allowed to preload.");
      }
      avcm.a(localAppRuntime, 1, this.b.cdu, this.b.ewp, localException.ewq, localException.cJg, i, new String[] { String.valueOf(this.b.mStrategyId) });
      return;
    }
    if (i < this.b.ewr)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "pluginType:" + this.b.cdu + "  preload:fail:memorylimit (" + i + "MB)");
      }
      avcm.a(localAppRuntime, 1, this.b.cdu, this.b.ewp, 3, "preload:fail:memorylimit", i, new String[] { String.valueOf(this.b.mStrategyId), String.valueOf(this.b.ewr) });
      return;
    }
    if (!this.b.b(localException))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "the plugin is inactive.");
      }
      avcm.a(localAppRuntime, 1, this.b.cdu, this.b.ewp, localException.ewq, localException.cJg, i, new String[] { String.valueOf(this.b.mStrategyId) });
      return;
    }
    avco.a(localAppRuntime, this.b, i, localException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.comic.PluginPreloader.1
 * JD-Core Version:    0.7.0.1
 */