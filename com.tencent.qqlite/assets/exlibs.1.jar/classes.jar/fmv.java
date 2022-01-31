import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.plugin.PluginManagerV2;

public class fmv
  implements DialogInterface.OnClickListener
{
  private String jdField_a_of_type_JavaLangString;
  
  private fmv(PluginManagerV2 paramPluginManagerV2, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_CooperationPluginPluginManagerV2.cancelInstall(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fmv
 * JD-Core Version:    0.7.0.1
 */