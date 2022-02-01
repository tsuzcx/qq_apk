import android.os.Bundle;
import cooperation.plugin.PluginUpdater;
import mqq.observer.BusinessObserver;
import tencent.im.plugin.ResourceConfig.GetResourceRespV2;

public class avgp
  implements BusinessObserver
{
  public avgp(PluginUpdater paramPluginUpdater) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("data");
      ResourceConfig.GetResourceRespV2 localGetResourceRespV2 = new ResourceConfig.GetResourceRespV2();
      try
      {
        localGetResourceRespV2.mergeFrom(paramBundle);
        this.b.b(true, 128, localGetResourceRespV2);
        return;
      }
      catch (Exception paramBundle)
      {
        this.b.b(false, 128, null);
        return;
      }
    }
    this.b.b(false, 128, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avgp
 * JD-Core Version:    0.7.0.1
 */