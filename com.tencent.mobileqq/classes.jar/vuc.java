import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.statistics.ReportController;

public class vuc
  implements DialogInterface.OnDismissListener
{
  public vuc(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.ac = false;
    ReportController.b(this.a.a, "CliOper", "", "", "0X8004EFA", "0X8004EFA", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vuc
 * JD-Core Version:    0.7.0.1
 */