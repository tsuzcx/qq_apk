package cooperation.liveroom;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import jqc;

final class LiveRoomHelper$1
  implements Runnable
{
  LiveRoomHelper$1(String paramString) {}
  
  public void run()
  {
    try
    {
      String str = "https://lme.gamefeeds.qq.com/LmeProxyCgi?data=" + URLEncoder.encode(new StringBuilder().append("{\"module\":\"LME.ReportChannelSvr.ReportChannelObj\",\"method\":\"SdkPluginReport\",\"param\":{\"req\":{\"report\":").append(this.val$reportStr).append("}}}").toString());
      jqc.a(BaseApplicationImpl.getApplication(), str, "GET", null, null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("LiveRoomHelper", 1, "LiveRoomPlugin report fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomHelper.1
 * JD-Core Version:    0.7.0.1
 */