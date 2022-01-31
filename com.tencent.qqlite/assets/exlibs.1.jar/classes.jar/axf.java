import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

class axf
  implements DialogInterface.OnClickListener
{
  axf(axd paramaxd, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    NearbyPeopleProfileActivity.e(this.jdField_a_of_type_Axd.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     axf
 * JD-Core Version:    0.7.0.1
 */