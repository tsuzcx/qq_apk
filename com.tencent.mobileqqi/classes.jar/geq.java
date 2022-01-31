import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.profile.ProfileCardBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class geq
  implements DialogInterface.OnClickListener
{
  public geq(ProfileCardBrowserActivity paramProfileCardBrowserActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.g();
    this.a.h();
    ReportController.b(this.a.b, "P_CliOper", "Vip_SummaryCard", "", "SummaryCard", "CLICK_VIPOPENSERVICE", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     geq
 * JD-Core Version:    0.7.0.1
 */