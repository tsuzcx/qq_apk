import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.StrangerManageActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class dqo
  implements View.OnClickListener
{
  public dqo(StrangerManageActivity paramStrangerManageActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.b(true);
    ReportController.b(this.a.b, "CliOper", "", "", "Setting_tab", "Manage_stranger_edit", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dqo
 * JD-Core Version:    0.7.0.1
 */