import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class axo
  implements View.OnClickListener
{
  public axo(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onClick(View paramView)
  {
    if ((NearbyPeopleProfileActivity.b(this.a) != null) && (!this.a.isFinishing()))
    {
      NearbyPeopleProfileActivity.b(this.a).dismiss();
      NearbyPeopleProfileActivity.b(this.a, null);
    }
    NearbyPeopleProfileActivity.h(this.a);
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004BB0", "0X8004BB0", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     axo
 * JD-Core Version:    0.7.0.1
 */