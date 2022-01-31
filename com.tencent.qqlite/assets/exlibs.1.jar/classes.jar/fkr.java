import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager.OnPluginReadyListener;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.plugin.PluginManagerV2;
import cooperation.plugin.PluginManagerV2.LaunchState;
import cooperation.qqfav.QfavUtil;

public class fkr
  extends OnPluginInstallListener.Stub
{
  private Context jdField_a_of_type_AndroidContentContext;
  private PluginManagerV2.LaunchState jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState;
  
  public fkr(PluginManagerV2 paramPluginManagerV2, PluginManagerV2.LaunchState paramLaunchState, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState = paramLaunchState;
  }
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallBegin." + paramString);
    }
    if ((!this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_AndroidAppProgressDialog != null)) {
      this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_AndroidAppProgressDialog.show();
    }
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallDownloadProgress." + paramString);
    }
    if ((!this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_AndroidAppProgressDialog != null))
    {
      this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_AndroidAppProgressDialog.setMax(paramInt2);
      this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_AndroidAppProgressDialog.setProgress(paramInt1);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallError." + paramString + "," + paramInt);
    }
    paramString = this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState;
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
    paramString = this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState;
    if ((!paramString.jdField_a_of_type_Boolean) && (paramString.jdField_a_of_type_AndroidAppProgressDialog != null)) {
      paramString.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
    if ((paramString != null) && (paramString.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener != null))
    {
      paramString.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener.a(true, paramString.jdField_a_of_type_AndroidContentContext, paramString.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
      if ((!this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.e.equals("com.qqfav.activity.FavoritesListActivity")) && (!this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.e.equals("com.tencent.mobileqq.troop.activity.TroopFileBroswerActivity")) && (!this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.e.equals("com.tencent.mobileqq.troop.activity.TroopFileViewerActivity")))
      {
        QfavUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131362670, 2);
        QfavUtil.a(this.jdField_a_of_type_AndroidContentContext, PluginManagerV2.a(this.jdField_a_of_type_CooperationPluginPluginManagerV2).getAccount(), true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fkr
 * JD-Core Version:    0.7.0.1
 */