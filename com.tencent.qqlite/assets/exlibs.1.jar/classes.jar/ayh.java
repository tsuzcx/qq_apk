import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class ayh
  implements DialogInterface.OnClickListener
{
  public ayh(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((NearbyPeopleProfileActivity.c(this.a) != null) && (!NearbyPeopleProfileActivity.c(this.a).isEnabled()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dating", 2, "profile add friend return");
      }
      return;
    }
    NearbyPeopleProfileActivity.w(this.a);
    if ((NearbyPeopleProfileActivity.c(this.a) != null) && (NearbyPeopleProfileActivity.c(this.a).isShowing())) {
      NearbyPeopleProfileActivity.c(this.a).dismiss();
    }
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004829", "0X8004829", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ayh
 * JD-Core Version:    0.7.0.1
 */