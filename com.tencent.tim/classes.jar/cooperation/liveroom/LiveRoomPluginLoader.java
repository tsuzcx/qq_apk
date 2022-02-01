package cooperation.liveroom;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import avfw;
import avfw.d;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class LiveRoomPluginLoader
{
  private static final String TAG = "LiveRoomPluginLoader";
  
  public static void preLoadPlugin()
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), LiveRoomProxyService.class);
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("useSkinEngine", false);
    localIntent.putExtra("params_remote_connect_at_launch", true);
    localIntent.putExtra("isPreloadProcess", true);
    localIntent.putExtra("preloadEntry", 9999);
    localIntent.putExtra("sendTime", SystemClock.elapsedRealtime());
    avfw.d locald = new avfw.d(1);
    locald.mPluginID = "LiveRoomPlugin.apk";
    locald.mPluginName = "直播SDK";
    locald.mUin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    locald.cKu = "com.tencent.gamecontent.livesdkqqplugin.plugins.QQLiveRoomPluginService";
    locald.mIntent = localIntent;
    if (QLog.isColorLevel()) {
      QLog.d("LiveRoomPluginLoader", 2, "[LiveRoomPluginLoader] launchPluginService");
    }
    avfw.c(BaseApplicationImpl.getApplication(), locald);
  }
  
  public static void stopService()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    localBaseApplication.stopService(new Intent(localBaseApplication, LiveRoomProxyService.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomPluginLoader
 * JD-Core Version:    0.7.0.1
 */