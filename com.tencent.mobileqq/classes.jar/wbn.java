import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.bless.BlessActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class wbn
  implements View.OnClickListener
{
  public wbn(BlessActivity paramBlessActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.app, "CliOper", "", "", "0X800632F", "0X800632F", 0, 0, "", "", "", "");
    BlessActivity.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wbn
 * JD-Core Version:    0.7.0.1
 */