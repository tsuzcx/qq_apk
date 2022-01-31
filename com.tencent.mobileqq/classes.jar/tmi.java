import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.RegisterChooseLoginActivity;
import com.tencent.mobileqq.activity.RegisterPersonalInfoActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class tmi
  implements DialogInterface.OnClickListener
{
  public tmi(RegisterChooseLoginActivity paramRegisterChooseLoginActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    RegisterChooseLoginActivity.a(this.a, true);
    RegisterPersonalInfoActivity.a(this.a.app, this.a, this.a.a, this.a.b, RegisterChooseLoginActivity.a(this.a), true, false);
    ReportController.a(this.a.app, "dc00898", "", "", "0X8007CC9", "0X8007CC9", 0, 0, "", "", "", "");
    ReportController.a(this.a.app, "dc00898", "", "", "0X8007CC9", "0X8007CC9", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tmi
 * JD-Core Version:    0.7.0.1
 */