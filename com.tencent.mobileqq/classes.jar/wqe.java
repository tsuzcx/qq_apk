import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class wqe
  implements DialogInterface.OnClickListener
{
  public wqe(BindNumberActivity paramBindNumberActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    BindNumberActivity.a(this.a);
    paramDialogInterface.dismiss();
    paramDialogInterface = this.a.getIntent();
    if (paramDialogInterface.getBooleanExtra("kFPhoneChange", false)) {
      ReportController.b(this.a.app, "CliOper", "", "", "0X8005DE9", "0X8005DE9", 1, 0, "", "", "", "");
    }
    if (paramDialogInterface.getBooleanExtra("kUnityOther", false)) {
      ReportController.b(this.a.app, "CliOper", "", "", "0X8005DE9", "0X8005DE9", 2, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wqe
 * JD-Core Version:    0.7.0.1
 */