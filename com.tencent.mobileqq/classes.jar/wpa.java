import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.activity.pendant.PendantTipsInfo;
import com.tencent.mobileqq.statistics.ReportController;

public class wpa
  implements DialogInterface.OnClickListener
{
  public wpa(AvatarPendantActivity paramAvatarPendantActivity, PendantTipsInfo paramPendantTipsInfo, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantPendantTipsInfo, false, this.jdField_a_of_type_Int);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "CliOper", "", "", "0X8005FD9", "0X8005FD9", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wpa
 * JD-Core Version:    0.7.0.1
 */