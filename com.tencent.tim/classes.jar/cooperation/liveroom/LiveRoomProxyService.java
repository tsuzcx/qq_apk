package cooperation.liveroom;

import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.qphone.base.util.QLog;

public class LiveRoomProxyService
  extends PluginProxyService
{
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LiveRoomProxyService", 2, "proxy service onCreate");
    }
    LiveRoomHelper.isSDKLoaded = true;
    super.onCreate();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomProxyService
 * JD-Core Version:    0.7.0.1
 */