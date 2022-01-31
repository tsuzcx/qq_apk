import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.MenuPopupDialog;

class aoc
  implements View.OnClickListener
{
  aoc(anz paramanz) {}
  
  public void onClick(View paramView)
  {
    if ((anz.a(this.a) != null) && ((anz.a(this.a).a instanceof String)))
    {
      this.a.a.b((String)anz.a(this.a).a);
      ReportController.b(this.a.a.app, "CliOper", "", "", "P_prof", "Prof_copy", ProfileActivity.a(this.a.a.a.a.g), 0, Integer.toString(ProfileActivity.a(this.a.a.a.a)), "", "", "");
    }
    if (anz.a(this.a) != null) {
      anz.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aoc
 * JD-Core Version:    0.7.0.1
 */