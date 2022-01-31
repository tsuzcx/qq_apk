import android.app.Activity;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

public final class hzr
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  public hzr(IPluginManager.PluginParams paramPluginParams, Activity paramActivity) {}
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    if (paramPluginManagerClient.isPluginInstalled(this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.b))
    {
      IPluginManager.d(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
      IPluginManager.a(null);
      return;
    }
    paramPluginManagerClient.installPlugin(this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.b, new hzs(this));
    IPluginManager.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hzr
 * JD-Core Version:    0.7.0.1
 */