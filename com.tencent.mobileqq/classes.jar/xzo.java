import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.PstnUtils;
import com.tencent.mobileqq.activity.selectmember.PhoneContactSelectActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class xzo
  implements DialogInterface.OnClickListener
{
  public xzo(PhoneContactSelectActivity paramPhoneContactSelectActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    PstnUtils.a(this.a.app, this.a, 2, 12);
    ReportController.b(this.a.app, "CliOper", "", "", "0X80063F9", "0X80063F9", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xzo
 * JD-Core Version:    0.7.0.1
 */