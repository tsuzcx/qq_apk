import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.downloadnew.ControlPolicyUtil;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.MyAppApi.CopyAndInstallTask;
import com.tencent.open.downloadnew.MyAppApi.InstallParams;
import com.tencent.open.downloadnew.MyAppDialog;

public class hnx
  implements DialogInterface.OnClickListener
{
  public hnx(MyAppApi paramMyAppApi, boolean paramBoolean1, boolean paramBoolean2, DialogInterface.OnClickListener paramOnClickListener, Bundle paramBundle, int paramInt, boolean paramBoolean3, Activity paramActivity, String paramString1, boolean paramBoolean4, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    LogUtility.c("MyAppApi", "---onConfirm--onClick");
    if (!this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.b())
    {
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams = new MyAppApi.InstallParams(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi);
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidOsBundle;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      if (this.c) {
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString);
      }
    }
    label312:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.c = true;
      StaticAnalyz.a("201", StaticAnalyz.a(this.jdField_a_of_type_JavaLangString, "NEWYYB"), this.jdField_b_of_type_JavaLangString);
      return;
      new MyAppApi.CopyAndInstallTask(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams).execute(new Void[0]);
      continue;
      if ((ControlPolicyUtil.f()) || (this.d)) {
        if (this.jdField_a_of_type_Int == 0) {
          this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean);
        }
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog == null) || (!this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing())) {
          break label312;
        }
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.dismiss();
        break;
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean);
        continue;
        if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
          this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hnx
 * JD-Core Version:    0.7.0.1
 */