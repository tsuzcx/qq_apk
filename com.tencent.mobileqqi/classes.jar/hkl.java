import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.preference.PreferenceManager;
import com.tencent.open.appcommon.js.AppInterface;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.downloadnew.MyAppDialog;

public class hkl
  implements DialogInterface.OnClickListener
{
  public hkl(AppInterface paramAppInterface, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = "";
    if (paramInt == 2131560009)
    {
      StaticAnalyz.a("200", "ANDROIDQQ.STORE.UPDATECHECKBOX", "");
      paramDialogInterface = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.activity).edit();
      paramDialogInterface.putBoolean("qqsetting_package_scan_flag", false);
      paramDialogInterface.commit();
      if ((this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.tipDialog != null) && (this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.tipDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.tipDialog.dismiss();
      }
      paramDialogInterface = "javascript:QzoneApp.fire('interface.gSetPackageScanSetting',{'guid':'" + this.jdField_a_of_type_JavaLangString + "','r':'0','data':'0'});void(0);";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.mHandler.post(new hkm(this, paramDialogInterface));
      return;
      if (paramInt == 2131560008)
      {
        if ((this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.tipDialog != null) && (this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.tipDialog.isShowing())) {
          this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.tipDialog.dismiss();
        }
        paramDialogInterface = "javascript:QzoneApp.fire('interface.gSetPackageScanSetting',{'guid':'" + this.jdField_a_of_type_JavaLangString + "','r':'0','data':'1'});void(0);";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hkl
 * JD-Core Version:    0.7.0.1
 */