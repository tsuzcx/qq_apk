import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.statistics.ReportController;

public class cmk
  implements View.OnClickListener
{
  public cmk(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    ForwardRecentActivity.a(this.a).a(String.valueOf(AppConstants.P), -1, "", this.a.getString(2131559075));
    ReportController.b(this.a.b, "CliOper", "", "", "0X8004051", "0X8004051", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cmk
 * JD-Core Version:    0.7.0.1
 */