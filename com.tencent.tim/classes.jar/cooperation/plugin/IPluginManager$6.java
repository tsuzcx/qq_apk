package cooperation.plugin;

import android.content.Context;
import avfw.d;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;

public final class IPluginManager$6
  implements Runnable
{
  public IPluginManager$6(Context paramContext, avfw.d paramd) {}
  
  public void run()
  {
    PluginProxyService.openService(this.val$context, this.a.mPluginName, this.a.mPluginID, this.a.mApkFilePath, this.a.cKu, this.a.mIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.plugin.IPluginManager.6
 * JD-Core Version:    0.7.0.1
 */