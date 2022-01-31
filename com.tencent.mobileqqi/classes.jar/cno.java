import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;

class cno
  implements View.OnClickListener
{
  cno(cnn paramcnn) {}
  
  public void onClick(View paramView)
  {
    if ((FriendProfileCardActivity.a(this.a.a) != null) && (FriendProfileCardActivity.a(this.a.a).isShowing())) {
      FriendProfileCardActivity.a(this.a.a).dismiss();
    }
    if ((cnn.a(this.a) != null) && ((cnn.a(this.a).a instanceof String)))
    {
      this.a.a.a((String)cnn.a(this.a).a);
      ReportController.b(this.a.a.b, "CliOper", "", "", "P_prof", "Prof_copy", ProfileActivity.a(this.a.a.a.a.f), 0, Integer.toString(ProfileActivity.a(this.a.a.a.a)), "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cno
 * JD-Core Version:    0.7.0.1
 */