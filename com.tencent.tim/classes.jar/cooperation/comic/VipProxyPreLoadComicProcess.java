package cooperation.comic;

import android.content.Context;
import android.content.Intent;
import avdb;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class VipProxyPreLoadComicProcess
  extends PluginProxyBroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "onReceive start");
    }
    super.onReceive(paramContext, paramIntent);
    try
    {
      if (paramIntent.getBooleanExtra("isPreloadProcess", false))
      {
        avdb.cr.set(2);
        int i = paramIntent.getIntExtra("preloadEntry", 0);
        avdb.cs.set(i);
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "onReceive end");
      }
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        QLog.e("QQComicDebug", 1, paramContext, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.comic.VipProxyPreLoadComicProcess
 * JD-Core Version:    0.7.0.1
 */