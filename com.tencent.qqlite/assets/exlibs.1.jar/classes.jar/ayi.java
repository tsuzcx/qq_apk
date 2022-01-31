import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class ayi
  implements DialogInterface.OnClickListener
{
  public ayi(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((NearbyPeopleProfileActivity.c(this.a) != null) && (NearbyPeopleProfileActivity.c(this.a).isShowing())) {
      NearbyPeopleProfileActivity.c(this.a).dismiss();
    }
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004829", "0X8004829", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ayi
 * JD-Core Version:    0.7.0.1
 */