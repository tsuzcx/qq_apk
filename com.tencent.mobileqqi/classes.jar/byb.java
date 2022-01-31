import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class byb
  implements DialogInterface.OnClickListener
{
  public byb(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.a(this.a.b, "CliOper", "", "", "0X80040A7", "0X80040A7", 0, 0, "", "", "", "");
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     byb
 * JD-Core Version:    0.7.0.1
 */