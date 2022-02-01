import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.PluginProcessService;
import com.tencent.shadow.dynamic.host.PpsController;
import java.util.concurrent.CountDownLatch;

class aidh
  implements ServiceConnection
{
  aidh(aidf paramaidf, CountDownLatch paramCountDownLatch) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    QLog.i("HuayangPluginNewDownloader", 2, "onServiceConnected ");
    aidf.a(this.b).unbindService(this);
    paramComponentName = PluginProcessService.wrapBinder(paramIBinder);
    try
    {
      paramComponentName.exit();
      this.val$countDownLatch.countDown();
      return;
    }
    catch (Exception paramComponentName)
    {
      for (;;)
      {
        QLog.d("HuayangPluginNewDownloader", 2, "exit over", paramComponentName);
      }
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aidh
 * JD-Core Version:    0.7.0.1
 */