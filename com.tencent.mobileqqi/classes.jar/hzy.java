import android.content.Context;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

class hzy
  extends hzx
{
  public Context a;
  
  public hzy(hzv paramhzv, Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    super(paramhzv);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = paramPluginParams;
  }
  
  public void a()
  {
    IPluginManager.c(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hzy
 * JD-Core Version:    0.7.0.1
 */