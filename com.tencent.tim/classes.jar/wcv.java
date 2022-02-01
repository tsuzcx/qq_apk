import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class wcv
  implements View.OnClickListener
{
  public wcv(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((l - TroopRequestActivity.Hw > 0L) && (l - TroopRequestActivity.Hw < 800L))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    TroopRequestActivity.Hw = l;
    if (((acff)this.this$0.app.getManager(51)).isFriend(this.this$0.aRz)) {
      localAllInOne = new ProfileActivity.AllInOne(this.this$0.aRz, 1);
    }
    for (;;)
    {
      anot.a(this.this$0.app, "P_CliOper", "Grp_contacts", "", "notice", "see_fromdata", 0, 0, this.this$0.a.msg.group_code.get() + "", "3", "", "");
      ProfileActivity.b(this.this$0, localAllInOne);
      break;
      if ((this.this$0.a.msg.group_msg_type.get() != 2) || (this.this$0.a.msg.sub_type.get() != 3)) {
        break label224;
      }
      localAllInOne = new ProfileActivity.AllInOne(this.this$0.aRz, 26);
      localAllInOne.bIW = 1;
    }
    label224:
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.this$0.aRz, 24);
    apuh.a(this.this$0.a, localAllInOne);
    switch (this.this$0.bMg)
    {
    }
    for (;;)
    {
      break;
      localAllInOne.subSourceId = 3;
      break;
      localAllInOne.subSourceId = 1;
      break;
      localAllInOne.subSourceId = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wcv
 * JD-Core Version:    0.7.0.1
 */