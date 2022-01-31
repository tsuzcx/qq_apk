import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;

class axe
  implements DialogInterface.OnClickListener
{
  axe(axd paramaxd, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    ReportController.b(this.jdField_a_of_type_Axd.a.app, "CliOper", "", "", "0X800481E", "0X800481E", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     axe
 * JD-Core Version:    0.7.0.1
 */