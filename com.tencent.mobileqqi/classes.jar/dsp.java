import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
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
    long l = System.currentTimeMillis();
    if ((l - TroopRequestActivity.d > 0L) && (l - TroopRequestActivity.d < 800L)) {
      return;
    }
    TroopRequestActivity.d = l;
    if (((FriendManager)this.a.b.getManager(8)).b(TroopRequestActivity.c(this.a))) {
      paramView = new ProfileActivity.AllInOne(TroopRequestActivity.c(this.a), 1);
    }
    for (;;)
    {
      ReportController.b(this.a.b, "P_CliOper", "Grp_contacts", "", "notice", "see_fromdata", 0, 0, TroopRequestActivity.a(this.a).msg.group_code.get() + "", "3", "", "");
      ProfileActivity.a(this.a, paramView);
      return;
      if ((TroopRequestActivity.a(this.a).msg.group_msg_type.get() == 2) && (TroopRequestActivity.a(this.a).msg.sub_type.get() == 3))
      {
        paramView = new ProfileActivity.AllInOne(TroopRequestActivity.c(this.a), 26);
        paramView.c = 1;
      }
      else
      {
        paramView = new ProfileActivity.AllInOne(TroopRequestActivity.c(this.a), 19);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dsp
 * JD-Core Version:    0.7.0.1
 */