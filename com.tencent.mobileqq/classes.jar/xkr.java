import com.tencent.biz.webviewplugin.NewerGuidePlugin;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

public class xkr
  implements QQPermissionCallback
{
  public xkr(NewerGuidePlugin paramNewerGuidePlugin, BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, "handleSetAvatar deny permissions");
    }
    bbgu.showPermissionSettingDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ajya.a(2131707438));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, "handleSetAvatar grant permissions");
    }
    NewerGuidePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xkr
 * JD-Core Version:    0.7.0.1
 */