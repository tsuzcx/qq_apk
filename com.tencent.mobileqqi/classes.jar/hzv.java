import android.app.Activity;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

class hzv
  extends hzw
{
  public Activity a;
  
  public hzv(hzu paramhzu, Activity paramActivity, IPluginManager.PluginParams paramPluginParams)
  {
    super(paramhzu);
    this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = paramPluginParams;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a()
  {
    IPluginManager.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hzv
 * JD-Core Version:    0.7.0.1
 */