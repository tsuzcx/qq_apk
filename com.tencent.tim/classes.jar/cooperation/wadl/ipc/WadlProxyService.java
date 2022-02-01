package cooperation.wadl.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import asbt;
import avfw;
import avfw.d;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import mqq.app.AppRuntime;

public class WadlProxyService
  extends PluginProxyService
{
  public static void b(ServiceConnection paramServiceConnection)
  {
    asbt.i("WadlProxyService", "bindWadlService proxy WadlRemoteService");
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Object localObject = localBaseApplicationImpl.getRuntime();
    Intent localIntent = new Intent(localBaseApplicationImpl, WadlProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    avfw.d locald = new avfw.d(0);
    locald.mPluginID = "qqwadl.apk";
    locald.mPluginName = "qqwadl";
    if (localObject != null) {}
    for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "")
    {
      locald.mUin = ((String)localObject);
      locald.cKu = "com.tencent.gamecenter.wadl.ipc.WadlRemoteService";
      locald.mIntent = localIntent;
      locald.mServiceConnection = paramServiceConnection;
      avfw.c(localBaseApplicationImpl, locald);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.wadl.ipc.WadlProxyService
 * JD-Core Version:    0.7.0.1
 */