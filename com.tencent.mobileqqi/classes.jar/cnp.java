import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class cnp
  implements DialogInterface.OnClickListener
{
  public cnp(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.a.b, "P_CliOper", "Grp_discuss", "", "0X80040ED", "0X80040ED", 0, 0, "", "", "", "");
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cnp
 * JD-Core Version:    0.7.0.1
 */