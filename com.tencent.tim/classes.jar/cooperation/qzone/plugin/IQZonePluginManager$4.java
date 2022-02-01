package cooperation.qzone.plugin;

import android.content.Context;
import avxl.b;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;

public final class IQZonePluginManager$4
  implements Runnable
{
  public IQZonePluginManager$4(Context paramContext, avxl.b paramb, String paramString) {}
  
  public void run()
  {
    PluginProxyService.openService(this.val$context, this.a.mPluginName, this.a.mPluginID, this.val$path, this.a.cKu, this.a.mIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.plugin.IQZonePluginManager.4
 * JD-Core Version:    0.7.0.1
 */