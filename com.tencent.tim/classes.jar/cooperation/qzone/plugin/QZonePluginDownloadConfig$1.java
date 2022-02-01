package cooperation.qzone.plugin;

import anol;
import avxy;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.Properties;

public class QZonePluginDownloadConfig$1
  implements Runnable
{
  public QZonePluginDownloadConfig$1(avxy paramavxy, String paramString, Properties paramProperties) {}
  
  public void run()
  {
    anol.a(BaseApplicationImpl.getContext()).reportKVEvent(this.val$s, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginDownloadConfig.1
 * JD-Core Version:    0.7.0.1
 */