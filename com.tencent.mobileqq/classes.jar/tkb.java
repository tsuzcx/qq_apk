import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class tkb
  implements View.OnClickListener
{
  public tkb(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.u();
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "sdk_locate", "click_send", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tkb
 * JD-Core Version:    0.7.0.1
 */