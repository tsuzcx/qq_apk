package cooperation.qqdataline.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import avfw;
import avfw.d;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;

public class DatalineProxyService
  extends PluginProxyService
{
  public static void d(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection)
  {
    Intent localIntent = new Intent(paramAppRuntime.getApplication(), DatalineProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    avfw.d locald = new avfw.d(0);
    locald.mPluginID = "qqdataline.apk";
    locald.mPluginName = PluginInfo.cKB;
    locald.mUin = paramAppRuntime.getAccount();
    locald.cKu = "com.qqdataline.ipc.QQDatalineService";
    locald.mIntent = localIntent;
    locald.mServiceConnection = paramServiceConnection;
    avfw.c(paramAppRuntime.getApplication(), locald);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqdataline.ipc.DatalineProxyService
 * JD-Core Version:    0.7.0.1
 */