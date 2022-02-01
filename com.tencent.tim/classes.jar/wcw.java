import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class wcw
  implements View.OnClickListener
{
  public wcw(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    ProfileActivity.AllInOne localAllInOne;
    if (((acff)this.this$0.app.getManager(51)).isFriend(TroopRequestActivity.a(this.this$0))) {
      localAllInOne = new ProfileActivity.AllInOne(TroopRequestActivity.a(this.this$0), 1);
    }
    for (;;)
    {
      anot.a(this.this$0.app, "P_CliOper", "Grp_contacts", "", "notice", "see_fromdata", 0, 0, this.this$0.a.msg.group_code.get() + "", "3", "", "");
      ProfileActivity.b(this.this$0, localAllInOne);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localAllInOne = new ProfileActivity.AllInOne(TroopRequestActivity.a(this.this$0), 24);
      apuh.a(this.this$0.a, localAllInOne);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wcw
 * JD-Core Version:    0.7.0.1
 */