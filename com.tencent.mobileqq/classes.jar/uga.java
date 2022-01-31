import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeActivity;
import com.tencent.mobileqq.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.utils.NewUpgradeDialog;
import com.tencent.mobileqq.utils.SPSettings;

public class uga
  implements DialogInterface.OnClickListener
{
  public uga(UpgradeActivity paramUpgradeActivity, NewUpgradeDialog paramNewUpgradeDialog, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsNewUpgradeDialog.d();
    SPSettings.c(true);
    SPSettings.c(this.jdField_a_of_type_Int);
    UpgradeDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeActivity, UpgradeController.a().a(), false, true, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uga
 * JD-Core Version:    0.7.0.1
 */