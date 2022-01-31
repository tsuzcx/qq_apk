import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class axr
  implements View.OnClickListener
{
  public axr(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onClick(View paramView)
  {
    if (NearbyPeopleProfileActivity.a(this.a) == 0)
    {
      NearbyPeopleProfileActivity.i(this.a);
      return;
    }
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004B38", "0X8004B38", 0, 0, "", "", "", "");
    NearbyPeopleProfileActivity.h(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     axr
 * JD-Core Version:    0.7.0.1
 */