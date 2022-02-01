import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import cooperation.qzone.util.QZLog;
import mqq.util.WeakReference;

final class avso
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  avso(long paramLong, avsn.a parama) {}
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onPluginManagerLoaded: ");
    Object localObject;
    if (paramPluginManagerClient != null)
    {
      localObject = Boolean.valueOf(paramPluginManagerClient.isPluginInstalled("qzone_plugin.apk"));
      QZLog.i("QZoneApiProxy", localObject + " cost " + (System.nanoTime() - this.val$now));
      avsn.a(new WeakReference(paramPluginManagerClient));
      if (this.a != null)
      {
        localObject = this.a;
        if ((paramPluginManagerClient == null) || (!paramPluginManagerClient.isPluginInstalled("qzone_plugin.apk")) || (!avsn.cU(BaseApplicationImpl.getApplication()))) {
          break label120;
        }
      }
    }
    label120:
    for (boolean bool = true;; bool = false)
    {
      ((avsn.a)localObject).yA(bool);
      return;
      localObject = "null";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avso
 * JD-Core Version:    0.7.0.1
 */