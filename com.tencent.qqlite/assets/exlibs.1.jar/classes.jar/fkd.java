import android.app.Activity;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

class fkd
  extends fke
{
  public Activity a;
  
  public fkd(fkc paramfkc, Activity paramActivity, IPluginManager.PluginParams paramPluginParams)
  {
    super(paramfkc);
    this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = paramPluginParams;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a()
  {
    IPluginManager.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fkd
 * JD-Core Version:    0.7.0.1
 */