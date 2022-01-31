import android.app.Activity;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

class ieq
  extends ier
{
  public Activity a;
  
  public ieq(iep paramiep, Activity paramActivity, IPluginManager.PluginParams paramPluginParams)
  {
    super(paramiep);
    this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = paramPluginParams;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a()
  {
    IPluginManager.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ieq
 * JD-Core Version:    0.7.0.1
 */