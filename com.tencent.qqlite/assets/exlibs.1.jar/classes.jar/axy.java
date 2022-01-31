import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class axy
  implements View.OnClickListener
{
  public axy(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onClick(View paramView)
  {
    NearbyPeopleProfileActivity.l(this.a);
    ReportController.b(this.a.app, "CliOper", "", "", "0X800482D", "0X800482D", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     axy
 * JD-Core Version:    0.7.0.1
 */