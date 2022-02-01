package cooperation.qzone.video;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import avyo;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;

public class QZoneLiveVideoPluginScreenRecordProxyService
  extends PluginProxyService
{
  public static void startLiveVideoFloatService(Context paramContext, String paramString, Bundle paramBundle, ServiceConnection paramServiceConnection)
  {
    Intent localIntent = new Intent(paramContext, QZoneLiveVideoPluginScreenRecordProxyService.class);
    localIntent.setAction("com.qzone.LiveVideoScreenRecordPluginService");
    localIntent.putExtras(paramBundle);
    QZoneLiveVideoPluginProxyService.a(paramContext, paramString, localIntent, paramServiceConnection, avyo.GF());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.video.QZoneLiveVideoPluginScreenRecordProxyService
 * JD-Core Version:    0.7.0.1
 */