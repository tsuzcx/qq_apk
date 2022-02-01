import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class yyi
  implements View.OnClickListener
{
  public yyi(TroopSuspiciousFragment paramTroopSuspiciousFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject2;
    if ((paramView.getTag() instanceof ywu))
    {
      localObject2 = (ywu)paramView.getTag();
      if (localObject2 != null) {
        break label32;
      }
    }
    label32:
    Object localObject3;
    int i;
    Object localObject1;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject3 = ((ywu)localObject2).a;
      i = ((ywu)localObject2).bDQ;
      if (yxe.fx(i) == 0)
      {
        localObject1 = TroopInfoActivity.c(String.valueOf(((ywu)localObject2).a.msg.group_code.get()), 4);
        ((Bundle)localObject1).putInt("t_s_f", 1001);
        apuh.a(this.this$0.getActivity(), (Bundle)localObject1, 2);
        if ((i == 2) || (i == 10) || (i == 12))
        {
          i = 1;
          label117:
          localObject3 = TroopSuspiciousFragment.a(this.this$0);
          localObject2 = ((ywu)localObject2).a.msg.group_code.get() + "";
          if (i == 0) {
            break label201;
          }
        }
        label201:
        for (localObject1 = "0";; localObject1 = "1")
        {
          anot.a((QQAppInterface)localObject3, "P_CliOper", "Grp_contacts", "", "notice", "see_data", 0, 0, (String)localObject2, (String)localObject1, "", "");
          break;
          i = 0;
          break label117;
        }
      }
      if ((((ywu)localObject2).bDQ != 2) || (!TroopInfo.isQidianPrivateTroop(((ywu)localObject2).a.msg.uint32_group_flagext3.get())))
      {
        if (((ywu)localObject2).bDQ != 82) {
          break;
        }
        localObject1 = new Intent(this.this$0.k, AccountDetailActivity.class);
        ((Intent)localObject1).putExtra("uin", ((ywu)localObject2).a.req_uin.get() + "");
        ((Intent)localObject1).putExtra("source", 112);
        this.this$0.startActivity((Intent)localObject1);
      }
    }
    long l = ((structmsg.StructMsg)localObject3).req_uin.get();
    switch (yxe.fx(i))
    {
    default: 
      localObject1 = String.valueOf(l);
      label370:
      if (((acff)TroopSuspiciousFragment.a(this.this$0).getManager(51)).isFriend((String)localObject1)) {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 1);
      }
      break;
    }
    for (;;)
    {
      l = ((structmsg.StructMsg)localObject3).msg.uint32_group_flagext3.get();
      boolean bool = TroopInfo.isQidianPrivateTroop(l);
      i = ((structmsg.StructMsg)localObject3).msg.group_msg_type.get();
      if (QLog.isColorLevel()) {
        QLog.d(".troop.qidian_private_troop", 2, "notification headView onClick: msgType=" + i + ", isQidianPrivateTroop=" + bool + ", flagExt3=" + l);
      }
      if ((bool) && (i == 2)) {
        break;
      }
      ProfileActivity.b(this.this$0.getActivity(), (ProfileActivity.AllInOne)localObject1);
      anot.a(TroopSuspiciousFragment.a(this.this$0), "P_CliOper", "Grp_contacts", "", "notice", "see_fromdata", 0, 0, ((ywu)localObject2).a.msg.group_code.get() + "", "3", "", "");
      break;
      localObject1 = ((ywu)localObject2).senderUin;
      break label370;
      localObject1 = String.valueOf(((ywu)localObject2).a.msg.action_uin.get());
      break label370;
      if ((((structmsg.StructMsg)localObject3).msg.group_msg_type.get() == 2) && (((structmsg.StructMsg)localObject3).msg.sub_type.get() == 3))
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 26);
        ((ProfileActivity.AllInOne)localObject1).bIW = 1;
      }
      else
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 24);
        apuh.a((structmsg.StructMsg)localObject3, (ProfileActivity.AllInOne)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yyi
 * JD-Core Version:    0.7.0.1
 */