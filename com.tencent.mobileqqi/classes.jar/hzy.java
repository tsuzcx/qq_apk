import android.content.Context;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

class hzy
  extends hzw
{
  public Context a;
  
  public hzy(hzu paramhzu, Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    super(paramhzu);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = paramPluginParams;
  }
  
  public void a()
  {
    IPluginManager.d(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hzy
 * JD-Core Version:    0.7.0.1
 */