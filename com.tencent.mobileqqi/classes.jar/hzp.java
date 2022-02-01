import android.app.Activity;
import com.tencent.mobileqq.pluginsdk.SplashDialogWrapper;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

public final class hzp
  implements Runnable
{
  public hzp(IPluginManager.PluginParams paramPluginParams, Activity paramActivity1, Activity paramActivity2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.jdField_a_of_type_AndroidAppDialog != null) {
      new SplashDialogWrapper(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.jdField_a_of_type_AndroidAppDialog, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.d, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.b, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.jdField_a_of_type_Boolean, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.c).show();
    }
    IPluginManager.b(this.b, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hzp
 * JD-Core Version:    0.7.0.1
 */