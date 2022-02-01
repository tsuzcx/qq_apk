import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
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

public class ywh
  implements View.OnClickListener
{
  public ywh(NotificationView paramNotificationView) {}
  
  public void onClick(View paramView)
  {
    ywa.a locala = (ywa.a)paramView.getTag();
    Object localObject;
    if (locala.a.msg.group_msg_type.get() == 80)
    {
      localObject = TroopInfoActivity.c(String.valueOf(locala.a.msg.group_code.get()), 5);
      TroopInfoActivity.i(this.this$0.getActivity(), (Bundle)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (aqiw.isNetSupport(this.this$0.getActivity())) {
        break;
      }
      QQToast.a(this.this$0.P, this.this$0.getActivity().getString(2131696270), 0).show(this.this$0.getTitleBarHeight());
    }
    ((FriendListHandler)this.this$0.app.getBusinessHandler(1)).DG(String.valueOf(locala.a.req_uin.get()));
    NotificationView.a(this.this$0, (structmsg.StructMsg)locala.a.get(), locala.uniseq);
    String str2 = locala.a.msg.group_info.msg_alert.get();
    String str3 = locala.a.msg.group_code.get() + "";
    label247:
    int i;
    label274:
    String str1;
    if (locala.mPosition < this.this$0.b.unreadMsgNum)
    {
      localObject = "1";
      i = locala.a.msg.group_inviter_role.get();
      if ((i != 2) && (i != 3)) {
        break label431;
      }
      i = 0;
      if (i == 0) {
        break label436;
      }
      str1 = "0";
      label282:
      if ((str2 != null) && (!"".equals(str2))) {
        break label776;
      }
      if (locala.bDQ != 82) {
        break label443;
      }
      anot.a(this.this$0.app, "P_CliOper", "Grp_public", "", "oper", "focus_notice", 0, 0, "", "", "", locala.a.req_uin.get() + "");
      NotificationView.a(this.this$0, locala.a.req_uin.get(), (structmsg.StructMsg)locala.a.get());
    }
    label776:
    for (;;)
    {
      NotificationView.c(this.this$0);
      this.this$0.J.setMessage(2131719519);
      this.this$0.J.show();
      break;
      localObject = "0";
      break label247;
      label431:
      i = 1;
      break label274;
      label436:
      str1 = "1";
      break label282;
      label443:
      if (locala.a.msg.group_msg_type.get() == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NotificationView", 2, "doCheckPayTroopReq start: " + str3);
        }
        TroopRequestActivity.a(this.this$0.P, this.this$0.app, str3, locala.a, this.this$0.a);
        aqfr.b("Grp_contacts_news", "notice", "agree_invite", 0, 0, new String[] { str3, localObject, str1, "1" });
      }
      else
      {
        NotificationView.a(this.this$0, 1, (structmsg.StructMsg)locala.a.get());
        if ((locala.a.msg.has()) && (locala.a.msg.req_uin_nick.has())) {
          ((TroopManager)this.this$0.app.getManager(52)).ax(str3, locala.a.req_uin.get() + "", locala.a.msg.req_uin_nick.get());
        }
        if (locala.bDQ == 1)
        {
          aqfr.b("Grp_contacts_news", "notice", "agree_ask", 0, 0, new String[] { str3, localObject, str1, "1" });
        }
        else if (locala.bDQ == 2)
        {
          aqfr.b("Grp_contacts_news", "notice", "agree_invite", 0, 0, new String[] { str3, localObject, str1, "1" });
          continue;
          NotificationView.a(this.this$0, 0, (structmsg.StructMsg)locala.a.get());
          if (locala.bDQ == 1) {
            aqfr.b("Grp_contacts_news", "notice", "refuse_ask", 0, 0, new String[] { str3, localObject, str1, "1" });
          } else if (locala.bDQ == 2) {
            aqfr.b("Grp_contacts_news", "notice", "refuse_invite", 0, 0, new String[] { str3, localObject, str1, "1" });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ywh
 * JD-Core Version:    0.7.0.1
 */