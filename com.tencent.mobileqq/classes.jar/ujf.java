import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.activateFriend.SendBirthdayWishesActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class ujf
  implements View.OnClickListener
{
  public ujf(SendBirthdayWishesActivity paramSendBirthdayWishesActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004E0A", "0X8004E0A", 0, 0, "", "", "", "");
    this.a.setResult(0);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ujf
 * JD-Core Version:    0.7.0.1
 */