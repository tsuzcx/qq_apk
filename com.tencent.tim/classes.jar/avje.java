import android.os.RemoteException;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import cooperation.qqfav.QfavHelper.4;

public class avje
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  public avje(QfavHelper.4 param4) {}
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    try
    {
      if (!paramPluginManagerClient.isPluginInstalled("qqfav.apk"))
      {
        if (this.a.d == null)
        {
          paramPluginManagerClient.installPlugin("qqfav.apk");
          return;
        }
        paramPluginManagerClient.installPlugin("qqfav.apk", this.a.d);
        return;
      }
    }
    catch (Exception paramPluginManagerClient)
    {
      if (this.a.d != null)
      {
        try
        {
          this.a.d.onInstallError("qqfav.apk", -1);
          return;
        }
        catch (RemoteException paramPluginManagerClient)
        {
          paramPluginManagerClient.printStackTrace();
          return;
        }
        paramPluginManagerClient = this.a.d;
        if (paramPluginManagerClient != null) {
          try
          {
            this.a.d.onInstallFinish("qqfav.apk");
            return;
          }
          catch (RemoteException paramPluginManagerClient)
          {
            paramPluginManagerClient.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     avje
 * JD-Core Version:    0.7.0.1
 */