import android.content.Context;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import cooperation.plugin.IPluginManager.OnPluginReadyListener;
import cooperation.plugin.IPluginManager.PluginParams;

public final class fke
  extends OnPluginInstallListener.Stub
{
  public fke(IPluginManager.OnPluginReadyListener paramOnPluginReadyListener, Context paramContext, IPluginManager.PluginParams paramPluginParams) {}
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener != null) {
      this.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    if (this.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener != null) {
      this.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener.a(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fke
 * JD-Core Version:    0.7.0.1
 */