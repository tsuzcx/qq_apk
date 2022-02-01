import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.activity.TroopRequestRefuseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class wcx
  implements View.OnClickListener
{
  public wcx(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    if ((!aqiw.isNetSupport(this.this$0)) && ((paramView != this.this$0.cS) || ((this.this$0.bMg != 1) && (this.this$0.bMg != 22)))) {
      QQToast.a(this.this$0, this.this$0.getString(2131696270), 0).show(this.this$0.getTitleBarHeight());
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.bbF = this.this$0.getIntent().getExtras().getBoolean("is_unread");
      String str = this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
      Object localObject1 = "0";
      int i = this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
      if (this.this$0.bbF) {
        localObject1 = "1";
      }
      label265:
      Object localObject2;
      if (paramView == this.this$0.dH)
      {
        if (((TroopManager)this.this$0.app.getManager(52)).b(this.this$0.aKI) != null) {}
        for (;;)
        {
          if (this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 80) {
            break label265;
          }
          QLog.e("Q.systemmsg.TroopRequestActivity", 1, "TroopProxyActivity 已在725下架");
          break;
          aizr.a().n(this.this$0.aKI, this.this$0.app);
        }
        if (this.this$0.bbH) {
          yym.a(this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, "unnormal_edit_join");
        }
        if (i == 2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.systemmsg.TroopRequestActivity", 2, "doCheckPayTroopReq start: " + str);
          }
          this.this$0.atg();
          TroopRequestActivity.a(this.this$0, this.this$0.app, str, this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, this.this$0.jdField_a_of_type_Yxe$a);
          i = this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
          if ((i != 2) && (i != 3))
          {
            i = 1;
            label390:
            if (i == 0) {
              break label509;
            }
            localObject2 = "0";
            label398:
            anot.a(this.this$0.app, "P_CliOper", "Grp_contacts", "", "notice", "agree_invite", 0, 0, str, (String)localObject1, (String)localObject2, "1");
          }
        }
        for (;;)
        {
          if (this.this$0.bMo == 0)
          {
            anot.a(this.this$0.app, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_confirm", 1, 0, String.valueOf(this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), "", "");
            break;
            i = 0;
            break label390;
            label509:
            localObject2 = "1";
            break label398;
            if (i == 82)
            {
              this.this$0.atg();
              TroopRequestActivity.a(this.this$0, this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get(), this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg);
              anot.a(this.this$0.app, "P_CliOper", "Grp_public", "", "oper", "focus_invite", 0, 0, "", "", "", this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
            }
            else if (TroopRequestActivity.a(this.this$0, 1))
            {
              this.this$0.atg();
              if (i == 1)
              {
                if ((this.this$0.aRF == null) || ("".equals(this.this$0.aRF)))
                {
                  i = 1;
                  label668:
                  if (i == 0) {
                    break label714;
                  }
                }
                label714:
                for (localObject2 = "1";; localObject2 = "0")
                {
                  anot.a(this.this$0.app, "P_CliOper", "Grp_contacts", "", "notice", "agree_ask", 0, 0, str, (String)localObject1, (String)localObject2, "1");
                  break;
                  i = 0;
                  break label668;
                }
              }
            }
          }
        }
        if (this.this$0.bMo == 1) {
          anot.a(this.this$0.app, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_confirm", 2, 0, String.valueOf(this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), "", "");
        }
      }
      else if (paramView == this.this$0.cS)
      {
        if ((this.this$0.bMg == 1) || (this.this$0.bMg == 22))
        {
          localObject2 = new Intent(this.this$0, TroopRequestRefuseActivity.class);
          this.this$0.startActivityForResult((Intent)localObject2, 1005);
          if (this.this$0.bbH) {
            yym.a(this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, "unnormal_edit_reject");
          }
          anot.a(this.this$0.app, "P_CliOper", "Grp_contacts", "", "notice", "refuse_ask_has_reason", 0, 0, str, (String)localObject1, "", "1");
          if (this.this$0.bMo == 0) {
            anot.a(this.this$0.app, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_reject", 1, 0, String.valueOf(this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), "", "");
          } else if (this.this$0.bMo == 1) {
            anot.a(this.this$0.app, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_reject", 2, 0, String.valueOf(this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), "", "");
          }
        }
        else if (TroopRequestActivity.a(this.this$0, 0))
        {
          this.this$0.atg();
          if (i == 1)
          {
            if ((this.this$0.aRF == null) || ("".equals(this.this$0.aRF)))
            {
              i = 1;
              label1121:
              if (i == 0) {
                break label1167;
              }
            }
            label1167:
            for (localObject2 = "1";; localObject2 = "0")
            {
              anot.a(this.this$0.app, "P_CliOper", "Grp_contacts", "", "notice", "refuse_ask", 0, 0, str, (String)localObject1, (String)localObject2, "1");
              break;
              i = 0;
              break label1121;
            }
          }
          if (i == 2)
          {
            i = this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
            if ((i != 2) && (i != 3))
            {
              i = 1;
              label1208:
              if (i == 0) {
                break label1254;
              }
            }
            label1254:
            for (localObject2 = "0";; localObject2 = "1")
            {
              anot.a(this.this$0.app, "P_CliOper", "Grp_contacts", "", "notice", "refuse_invite", 0, 0, str, (String)localObject1, (String)localObject2, "1");
              break;
              i = 0;
              break label1208;
            }
          }
        }
      }
      else if (paramView == this.this$0.rightViewText)
      {
        if (this.this$0.bMg == 82)
        {
          if (TroopRequestActivity.a(this.this$0, 0)) {
            this.this$0.atg();
          }
          aqfr.b("Grp_contacts_news", "notice", "ignore_invite", 0, 0, new String[] { str, localObject1 });
        }
        if (TroopRequestActivity.a(this.this$0, 2))
        {
          this.this$0.atg();
          if (i != 1) {
            break label1453;
          }
          aqfr.b("Grp_contacts_news", "notice", "ignore_ask", 0, 0, new String[] { str, localObject1 });
        }
        for (;;)
        {
          if (this.this$0.bMo == 0)
          {
            anot.a(this.this$0.app, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_ignore", 1, 0, String.valueOf(this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), "", "");
            break;
            label1453:
            if (i == 2)
            {
              i = this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
              if ((i != 2) && (i != 3))
              {
                i = 1;
                label1487:
                if (i == 0) {
                  break label1533;
                }
              }
              label1533:
              for (localObject2 = "0";; localObject2 = "1")
              {
                aqfr.b("Grp_contacts_news", "notice", "ignore_invite", 0, 0, new String[] { str, localObject1, localObject2 });
                break;
                i = 0;
                break label1487;
              }
            }
          }
        }
        if (this.this$0.bMo == 1) {
          anot.a(this.this$0.app, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_ignore", 2, 0, String.valueOf(this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), "", "");
        }
      }
      else if (paramView == this.this$0.Gz)
      {
        if (this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 80)
        {
          localObject1 = TroopInfoActivity.c(this.this$0.aKI, 5);
          TroopInfoActivity.i(this.this$0.getActivity(), (Bundle)localObject1);
        }
        else
        {
          if (((TroopManager)this.this$0.app.getManager(52)).b(this.this$0.aKI) != null) {}
          for (;;)
          {
            if (((this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 11) || (this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 3)) && (this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 7)) {
              break label1851;
            }
            this.this$0.atg();
            TroopRequestActivity.a(this.this$0, this.this$0.app, str, this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, this.this$0.jdField_a_of_type_Yxe$a);
            aqfr.b("Grp_contacts_news", "notice", "again_join", 0, 0, new String[] { str });
            break;
            aizr.a().n(this.this$0.aKI, this.this$0.app);
          }
          label1851:
          if ((this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 10) && (this.this$0.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() == 3))
          {
            this.this$0.atg();
            localObject1 = new ArrayList();
            ((ArrayList)localObject1).add(TroopRequestActivity.a(this.this$0));
            if ((((ArrayList)localObject1).size() > 0) && (this.this$0.aKI.length() > 0)) {
              ((acms)this.this$0.app.getBusinessHandler(20)).a(this.this$0.aKI, (ArrayList)localObject1, "");
            }
            aqfr.b("Grp_contacts_news", "notice", "again_invite", 0, 0, new String[] { str });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wcx
 * JD-Core Version:    0.7.0.1
 */