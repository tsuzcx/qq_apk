import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GesturePWDCreateActivity;
import com.tencent.mobileqq.activity.GesturePWDGuideActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class cve
  implements View.OnClickListener
{
  public cve(GesturePWDGuideActivity paramGesturePWDGuideActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, GesturePWDCreateActivity.class);
    this.a.startActivityForResult(paramView, 999);
    this.a.overridePendingTransition(2130968598, 2130968595);
    ReportController.b(this.a.b, "CliOper", "", "", "Setting_tab", "Clk_Gesture_password", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cve
 * JD-Core Version:    0.7.0.1
 */