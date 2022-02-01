import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class dsp
  implements View.OnClickListener
{
  public dsp(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    if (((FriendManager)this.a.b.getManager(8)).b(TroopRequestActivity.b(this.a))) {}
    for (paramView = new ProfileActivity.AllInOne(TroopRequestActivity.b(this.a), 1);; paramView = new ProfileActivity.AllInOne(TroopRequestActivity.b(this.a), 19))
    {
      ReportController.b(this.a.b, "P_CliOper", "Grp_contacts", "", "notice", "see_fromdata", 0, 0, TroopRequestActivity.a(this.a).msg.group_code.get() + "", "3", "", "");
      ProfileActivity.a(this.a, paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dsp
 * JD-Core Version:    0.7.0.1
 */