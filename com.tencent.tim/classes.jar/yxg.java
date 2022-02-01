import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class yxg
  implements View.OnClickListener
{
  public yxg(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onClick(View paramView)
  {
    if (!(paramView.getTag() instanceof ywa.a)) {}
    ywa.a locala;
    Object localObject;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      locala = (ywa.a)paramView.getTag();
      if (locala.a.msg.group_msg_type.get() != 80) {
        break;
      }
      localObject = TroopInfoActivity.c(String.valueOf(locala.a.msg.group_code.get()), 5);
      TroopInfoActivity.i(this.this$0.getActivity(), (Bundle)localObject);
    }
    if (this.this$0.mType == 1) {
      anot.a(this.this$0.app, "dc00899", "Grp_contacts_news", "", "notice", "todotab_notice_confirm", 2, 0, String.valueOf(locala.a.msg.group_code.get()), String.valueOf(locala.a.msg.group_msg_type.get()), "", "");
    }
    for (;;)
    {
      if (aqiw.isNetSupport(this.this$0.getActivity())) {
        break label266;
      }
      QQToast.a(this.this$0.P, this.this$0.getActivity().getString(2131696270), 0).show(this.this$0.getTitleBarHeight());
      break;
      anot.a(this.this$0.app, "dc00899", "Grp_contacts_news", "", "notice", "todotab_notice_confirm", 1, 0, String.valueOf(locala.a.msg.group_code.get()), String.valueOf(locala.a.msg.group_msg_type.get()), "", "");
    }
    label266:
    ((FriendListHandler)this.this$0.app.getBusinessHandler(1)).DG(String.valueOf(locala.a.req_uin.get()));
    TroopNotifyAndRecommendView.a(this.this$0, (structmsg.StructMsg)locala.a.get(), locala.uniseq);
    String str2 = locala.a.msg.group_info.msg_alert.get();
    String str3 = locala.a.msg.group_code.get() + "";
    label404:
    int i;
    label431:
    String str1;
    if ((this.this$0.b != null) && (locala.mPosition < this.this$0.b.unreadMsgNum))
    {
      localObject = "1";
      i = locala.a.msg.group_inviter_role.get();
      if ((i != 2) && (i != 3)) {
        break label531;
      }
      i = 0;
      if (i == 0) {
        break label536;
      }
      str1 = "0";
      label439:
      if ((str2 != null) && (!"".equals(str2))) {
        break label870;
      }
      if (locala.bDQ != 82) {
        break label543;
      }
      TroopNotifyAndRecommendView.a(this.this$0, locala.a.req_uin.get(), (structmsg.StructMsg)locala.a.get());
    }
    for (;;)
    {
      TroopNotifyAndRecommendView.d(this.this$0);
      this.this$0.J.setMessage(2131719519);
      this.this$0.J.show();
      break;
      localObject = "0";
      break label404;
      label531:
      i = 1;
      break label431;
      label536:
      str1 = "1";
      break label439;
      label543:
      if (locala.a.msg.group_msg_type.get() == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotifyAndRecommendView", 2, "doCheckPayTroopReq start: " + str3);
        }
        TroopRequestActivity.a(this.this$0.P, this.this$0.app, str3, locala.a, this.this$0.a);
        aqfr.b("Grp_contacts_news", "notice", "agree_invite", 0, 0, new String[] { str3, localObject, str1, "0" });
      }
      else
      {
        TroopNotifyAndRecommendView.a(this.this$0, 1, (structmsg.StructMsg)locala.a.get());
        if ((locala.a.msg.has()) && (locala.a.msg.req_uin_nick.has())) {
          ((TroopManager)this.this$0.app.getManager(52)).ax(str3, locala.a.req_uin.get() + "", locala.a.msg.req_uin_nick.get());
        }
        if (locala.bDQ == 1)
        {
          aqfr.b("Grp_contacts_news", "notice", "agree_ask", 0, 0, new String[] { str3, localObject, str1, "0" });
        }
        else if (locala.bDQ == 2)
        {
          aqfr.b("Grp_contacts_news", "notice", "agree_invite", 0, 0, new String[] { str3, localObject, str1, "0" });
          continue;
          label870:
          TroopNotifyAndRecommendView.a(this.this$0, 0, (structmsg.StructMsg)locala.a.get());
          if (locala.bDQ == 1) {
            aqfr.b("Grp_contacts_news", "notice", "refuse_ask", 0, 0, new String[] { str3, localObject, str1, "0" });
          } else if (locala.bDQ == 2) {
            aqfr.b("Grp_contacts_news", "notice", "refuse_invite", 0, 0, new String[] { str3, localObject, str1, "0" });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yxg
 * JD-Core Version:    0.7.0.1
 */