import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class axl
  implements View.OnClickListener
{
  public axl(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onClick(View paramView)
  {
    if ((NearbyPeopleProfileActivity.a(this.a) != null) && (!this.a.isFinishing()))
    {
      NearbyPeopleProfileActivity.a(this.a).dismiss();
      NearbyPeopleProfileActivity.a(this.a, null);
    }
    NearbyPeopleProfileActivity.d(this.a);
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004824", "0X8004824", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     axl
 * JD-Core Version:    0.7.0.1
 */