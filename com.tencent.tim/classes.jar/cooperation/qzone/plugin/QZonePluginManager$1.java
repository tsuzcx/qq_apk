package cooperation.qzone.plugin;

import anol;
import avyh;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.Properties;

public class QZonePluginManager$1
  implements Runnable
{
  public QZonePluginManager$1(avyh paramavyh, String paramString, int paramInt) {}
  
  public void run()
  {
    Properties localProperties = new Properties();
    localProperties.put("plugin_id", this.val$pluginId);
    localProperties.put("refer", String.valueOf(this.val$refer));
    anol.a(BaseApplicationImpl.getContext()).reportKVEvent("QzonePluginDownloadRefer", localProperties);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginManager.1
 * JD-Core Version:    0.7.0.1
 */