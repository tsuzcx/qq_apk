import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.startup.step.CheckPermission.a;
import mqq.app.AppActivity;

public final class anmr
  implements DialogInterface.OnClickListener
{
  public anmr(AppActivity paramAppActivity, CheckPermission.a parama) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      paramDialogInterface.setData(Uri.fromParts("package", this.jdField_a_of_type_MqqAppAppActivity.getPackageName(), null));
      this.jdField_a_of_type_MqqAppAppActivity.startActivity(paramDialogInterface);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqStartupStepCheckPermission$a == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqStartupStepCheckPermission$a.reject();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     anmr
 * JD-Core Version:    0.7.0.1
 */