import android.app.ProgressDialog;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager.OnPluginReadyListener;
import cooperation.plugin.PluginManagerV2.LaunchState;

public class ife
  extends OnPluginInstallListener.Stub
{
  private PluginManagerV2.LaunchState a;
  
  public ife(PluginManagerV2.LaunchState paramLaunchState)
  {
    this.a = paramLaunchState;
  }
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallBegin." + paramString);
    }
    if ((!this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_AndroidAppProgressDialog != null)) {
      this.a.jdField_a_of_type_AndroidAppProgressDialog.show();
    }
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallDownloadProgress." + paramString);
    }
    if ((!this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_AndroidAppProgressDialog != null))
    {
      this.a.jdField_a_of_type_AndroidAppProgressDialog.setMax(paramInt2);
      this.a.jdField_a_of_type_AndroidAppProgressDialog.setProgress(paramInt1);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallError." + paramString + "," + paramInt);
    }
    paramString = this.a;
    IPluginManager.OnPluginReadyListener localOnPluginReadyListener;
    if ((paramString != null) && (paramString.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener != null))
    {
      localOnPluginReadyListener = paramString.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener;
      if (paramInt != 2) {
        break label86;
      }
    }
    label86:
    for (boolean bool = true;; bool = false)
    {
      localOnPluginReadyListener.a(bool, paramString.jdField_a_of_type_AndroidContentContext, paramString.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
      return;
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallFinish." + paramString);
    }
    paramString = this.a;
    if ((!paramString.jdField_a_of_type_Boolean) && (paramString.jdField_a_of_type_AndroidAppProgressDialog != null)) {
      paramString.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
    if ((paramString != null) && (paramString.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener != null)) {
      paramString.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener.a(true, paramString.jdField_a_of_type_AndroidContentContext, paramString.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ife
 * JD-Core Version:    0.7.0.1
 */