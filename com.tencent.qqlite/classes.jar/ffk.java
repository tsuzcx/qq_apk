import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.downloadnew.ControlPolicyUtil;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.MyAppDialog;

public class ffk
  implements DialogInterface.OnClickListener
{
  public ffk(MyAppApi paramMyAppApi, boolean paramBoolean1, int paramInt, Activity paramActivity, Bundle paramBundle, boolean paramBoolean2, boolean paramBoolean3, DialogInterface.OnClickListener paramOnClickListener, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    LogUtility.c("MyAppApi", "---onConfirm--onClick");
    if (!this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.b()) {}
    label169:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.c = true;
      StaticAnalyz.a("201", StaticAnalyz.a(this.jdField_a_of_type_JavaLangString, "NEWYYB"), this.jdField_b_of_type_JavaLangString);
      return;
      if ((ControlPolicyUtil.g()) || (this.jdField_a_of_type_Boolean)) {
        if (this.jdField_a_of_type_Int == 0) {
          this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_b_of_type_Boolean, this.c);
        }
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a == null) || (!this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.a())) {
          break label169;
        }
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.b();
        break;
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_b_of_type_Boolean, this.c);
        continue;
        if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
          this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ffk
 * JD-Core Version:    0.7.0.1
 */