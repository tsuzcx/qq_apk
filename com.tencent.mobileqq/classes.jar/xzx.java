import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.selectmember.ContactFriendInnerFrame;
import com.tencent.mobileqq.activity.selectmember.PhoneContactTabView;
import com.tencent.mobileqq.statistics.ReportController;

class xzx
  implements DialogInterface.OnClickListener
{
  xzx(xzv paramxzv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.a.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactFriendInnerFrame.g();
    ReportController.b(this.a.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063FA", "0X80063FA", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xzx
 * JD-Core Version:    0.7.0.1
 */