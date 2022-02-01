import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.plugin.IPluginManager.OnPluginReadyListener;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.plugin.PluginManagerV2;

public class iai
  implements DialogInterface.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext;
  IPluginManager.OnPluginReadyListener jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener;
  IPluginManager.PluginParams jdField_a_of_type_CooperationPluginIPluginManager$PluginParams;
  boolean jdField_a_of_type_Boolean;
  boolean b;
  
  private iai(PluginManagerV2 paramPluginManagerV2, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener, boolean paramBoolean1, Context paramContext, IPluginManager.PluginParams paramPluginParams, boolean paramBoolean2)
  {
    this.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener = paramOnPluginReadyListener;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = paramPluginParams;
    this.b = paramBoolean2;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    int i = 0;
    switch (paramInt)
    {
    default: 
      return;
    case -1: 
      PluginManagerV2.a(this.jdField_a_of_type_CooperationPluginPluginManagerV2, 1, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams, this.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener);
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      paramInt = i;
    }
    for (;;)
    {
      PluginManagerV2.a(this.jdField_a_of_type_CooperationPluginPluginManagerV2, paramInt, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams, this.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener);
      return;
      paramInt = i;
      if (this.b) {
        paramInt = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     iai
 * JD-Core Version:    0.7.0.1
 */