import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.selectmember.ContactFriendInnerFrame;
import com.tencent.mobileqq.activity.selectmember.PhoneContactSelectActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class xwj
  implements DialogInterface.OnClickListener
{
  public xwj(PhoneContactSelectActivity paramPhoneContactSelectActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.jdField_a_of_type_AndroidWidgetEditText.setText("");
    ((ContactFriendInnerFrame)this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).g();
    paramDialogInterface.dismiss();
    ReportController.b(this.a.app, "CliOper", "", "", "0X80063FA", "0X80063FA", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xwj
 * JD-Core Version:    0.7.0.1
 */