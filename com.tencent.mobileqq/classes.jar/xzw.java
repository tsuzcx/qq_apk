import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.PstnUtils;
import com.tencent.mobileqq.activity.selectmember.PhoneContactTabView;
import com.tencent.mobileqq.statistics.ReportController;

class xzw
  implements DialogInterface.OnClickListener
{
  xzw(xzv paramxzv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    PstnUtils.a(this.a.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a.a.jdField_a_of_type_AndroidContentContext, 2, 12);
    ReportController.b(this.a.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063F9", "0X80063F9", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xzw
 * JD-Core Version:    0.7.0.1
 */