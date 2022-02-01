package cooperation.qlink;

import android.content.Intent;
import android.content.ServiceConnection;
import avfw;
import avfw.d;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;

public class QlinkPluginProxyService
  extends PluginProxyService
{
  public static void c(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection)
  {
    Intent localIntent = new Intent(paramAppRuntime.getApplication(), QlinkPluginProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    localIntent.putExtra("userQqResources", 2);
    avfw.d locald = new avfw.d(0);
    locald.mPluginID = QlinkPluginProxyActivity.FQ();
    locald.mPluginName = PluginInfo.cKA;
    locald.mUin = paramAppRuntime.getAccount();
    locald.cKu = "com.tencent.qlink.service.QlinkService";
    locald.mIntent = localIntent;
    locald.mServiceConnection = paramServiceConnection;
    QLog.d("QLinkLog", 4, "Bind Qlink Service");
    avfw.c(paramAppRuntime.getApplication(), locald);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qlink.QlinkPluginProxyService
 * JD-Core Version:    0.7.0.1
 */