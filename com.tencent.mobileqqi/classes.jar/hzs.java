import android.app.Dialog;
import android.widget.Toast;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

class hzs
  extends OnPluginInstallListener.Stub
{
  hzs(hzr paramhzr) {}
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if ((this.a.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.a != null) && (this.a.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.a.isShowing())) {
      this.a.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.a.dismiss();
    }
    Toast.makeText(this.a.jdField_a_of_type_AndroidAppActivity, "加载失败", 0).show();
  }
  
  public void onInstallFinish(String paramString)
  {
    IPluginManager.d(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hzs
 * JD-Core Version:    0.7.0.1
 */