import android.content.Context;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

class iet
  extends ier
{
  public Context a;
  
  public iet(iep paramiep, Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    super(paramiep);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = paramPluginParams;
  }
  
  public void a()
  {
    IPluginManager.d(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     iet
 * JD-Core Version:    0.7.0.1
 */