import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.PluginPreloader.1;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;

public class avco
{
  private static final Handler dZ;
  
  static
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("PluginPreloader", 0);
    localHandlerThread.start();
    dZ = new Handler(localHandlerThread.getLooper());
  }
  
  public static void a(avcn paramavcn)
  {
    a(paramavcn, 0L);
  }
  
  public static void a(avcn paramavcn, long paramLong)
  {
    if ((paramavcn == null) || (paramavcn.mProcessName == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "the preload strategy or target process is null.");
      }
      return;
    }
    dZ.postDelayed(new PluginPreloader.1(paramavcn), paramLong);
  }
  
  public static void a(AppRuntime paramAppRuntime, avcn paramavcn, int paramInt, avco.a parama)
  {
    paramavcn.a(parama);
    if (paramavcn.mPluginID != null)
    {
      avfw localavfw = (avfw)paramAppRuntime.getManager(27);
      if (localavfw == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "pluginType:" + paramavcn.cdu + " preload:fail:nopluginmanager");
        }
        avcm.a(paramAppRuntime, 1, paramavcn.cdu, paramavcn.ewp, 3, "preload:fail:nopluginmanager", paramInt, new String[] { String.valueOf(paramavcn.mStrategyId) });
        return;
      }
      PluginInfo localPluginInfo = localavfw.b(paramavcn.mPluginID);
      if (localPluginInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "pluginType:" + paramavcn.cdu + " preload:fail:noplugininfo");
        }
        avcm.a(paramAppRuntime, 1, paramavcn.cdu, paramavcn.ewp, 3, "preload:fail:noplugininfo", paramInt, new String[] { String.valueOf(paramavcn.mStrategyId) });
        return;
      }
      if (localPluginInfo.mState == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "plugin already installed, do preload.");
        }
        avcm.a(paramAppRuntime, 0, paramavcn.cdu, paramavcn.ewp, parama.ewq, parama.cJg, paramInt, new String[] { String.valueOf(paramavcn.mStrategyId) });
        paramavcn.aBp();
        return;
      }
      if ((paramavcn.dmf) && (aqiw.isWifiConnected(BaseApplicationImpl.getContext())))
      {
        localavfw.installPlugin(paramavcn.mPluginID, new avcp(paramAppRuntime, paramavcn, parama, paramInt));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "pluginType:" + paramavcn.cdu + " preload:fail:uninstall");
      }
      avcm.a(paramAppRuntime, 1, paramavcn.cdu, paramavcn.ewp, 3, "preload:fail:uninstall", paramInt, new String[] { String.valueOf(paramavcn.mStrategyId) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloader", 2, "do preload");
    }
    avcm.a(paramAppRuntime, 0, paramavcn.cdu, paramavcn.ewp, parama.ewq, parama.cJg, paramInt, new String[] { String.valueOf(paramavcn.mStrategyId) });
    paramavcn.aBp();
  }
  
  public static class a
  {
    public String cJg;
    public int ewq = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avco
 * JD-Core Version:    0.7.0.1
 */