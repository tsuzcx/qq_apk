import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.statistics.ReportController;

public class ueq
  implements View.OnClickListener
{
  public ueq(VisitorsActivity paramVisitorsActivity) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof ufl))
    {
      paramView = (ufl)paramView.getTag();
      ReportController.a(this.a.app, "CliOper", "", "", "0X8004447", "0X8004447", 0, 0, "", "", "", "");
      VisitorsActivity.a(this.a, (CardProfile)paramView.a);
    }
    while (!(paramView.getTag() instanceof ufn)) {
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ueq
 * JD-Core Version:    0.7.0.1
 */