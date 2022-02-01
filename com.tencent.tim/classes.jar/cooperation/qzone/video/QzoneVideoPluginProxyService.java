package cooperation.qzone.video;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import avfw;
import avfw.d;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;

public class QzoneVideoPluginProxyService
  extends PluginProxyService
{
  public static void a(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection)
  {
    paramIntent.putExtra("useSkinEngine", 1);
    avfw.d locald = new avfw.d(0);
    locald.mPluginID = "qzone_plugin.apk";
    locald.mPluginName = "QZone";
    locald.mUin = paramString;
    locald.cKu = "com.qzone.video.service.QzoneVideoPluginService";
    locald.mIntent = paramIntent;
    locald.mServiceConnection = paramServiceConnection;
    avfw.c(paramContext, locald);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVideoPluginProxyService
 * JD-Core Version:    0.7.0.1
 */