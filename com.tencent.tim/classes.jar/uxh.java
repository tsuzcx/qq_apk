import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity.10.1;
import com.tencent.mobileqq.activity.ForwardTroopListFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import eipc.EIPCClient;
import java.util.ArrayList;
import java.util.Map;

public class uxh
  implements View.OnClickListener
{
  public uxh(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131366542)
    {
      ForwardRecentActivity.a(this.this$0, 10);
      anot.a(this.this$0.app, "CliOper", "", "", "friendchoose", "0X8009D91", ForwardRecentActivity.a(this.this$0), 0, "", "", "", "");
    }
    label400:
    label1583:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 2131369612)
      {
        if (this.this$0.aWi)
        {
          if (this.this$0.a != null)
          {
            this.this$0.a.Kp(false);
            com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.boN = false;
          }
          if (this.this$0.aWj) {
            QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_fail", null, null);
          }
          ForwardRecentActivity.b(this.this$0);
          this.this$0.finish();
          anot.a(this.this$0.app, "CliOper", "", "", "friendchoose", "0X8009D8F", ForwardRecentActivity.a(this.this$0), 0, "", "", "", "");
          if (this.this$0.getIntent().getBooleanExtra("forward_mini_program_ark_from_sdk", false)) {
            anot.a(this.this$0.app, "dc00898", "", "", "0X8009F7A", "0X8009F7A", 0, 0, "2", "", "", "");
          }
        }
        for (;;)
        {
          break;
          if (ForwardRecentActivity.a(this.this$0))
          {
            ForwardRecentActivity.c(this.this$0);
            anot.a(this.this$0.app, "CliOper", "", "", "friendchoose", "0X8009D98", ForwardRecentActivity.a(this.this$0), 0, "", "", "", ForwardRecentActivity.a(this.this$0));
          }
          else
          {
            ForwardRecentActivity.d(this.this$0);
            anot.a(this.this$0.app, "CliOper", "", "", "friendchoose", "0X8009D93", ForwardRecentActivity.a(this.this$0), 0, "", "", "", ForwardRecentActivity.a(this.this$0));
          }
        }
      }
      if (i == 2131369581)
      {
        if (ForwardRecentActivity.a(this.this$0))
        {
          ForwardRecentActivity.e(this.this$0);
          anot.a(this.this$0.app, "CliOper", "", "", "friendchoose", "0X8009D94", ForwardRecentActivity.a(this.this$0), 0, "", "", "", "");
        }
      }
      else
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("call_by_forward", true);
        if (this.this$0.w != null) {
          ((Intent)localObject1).setData(this.this$0.w);
        }
        localObject2 = this.this$0.a.getExtras();
        if (!((Bundle)localObject2).getBoolean("sendMultiple", false)) {
          break label947;
        }
        ((Intent)localObject1).putStringArrayListExtra("foward_key_m_p_l", ((Bundle)localObject2).getStringArrayList("foward_key_m_p_l"));
        label475:
        ((Intent)localObject1).putExtras(this.this$0.a.getExtras());
        if (!this.this$0.getIntent().getBooleanExtra("isFromShare", false)) {
          break label966;
        }
        ((Intent)localObject1).putExtras(this.this$0.a.getExtras());
        ((Intent)localObject1).setAction(this.this$0.getIntent().getAction());
      }
      for (;;)
      {
        switch (paramView.getId())
        {
        case 2131367506: 
        case 2131367509: 
        case 2131367510: 
        case 2131367511: 
        default: 
          break;
        case 2131367505: 
          this.this$0.vw("0X8007824");
          ForwardRecentActivity.a(this.this$0, (Intent)localObject1);
          anot.a(this.this$0.app, "CliOper", "", "", "0X800665F", "0X800665F", 0, 0, "", "", "", "");
          ((Intent)localObject1).setClass(this.this$0, ForwardFriendListActivity.class);
          ((Intent)localObject1).putExtra("extra_choose_friend", 5);
          ((Intent)localObject1).putExtra("only_single_selection", this.this$0.aWi);
          ((Intent)localObject1).putParcelableArrayListExtra("selected_target_list", new ArrayList(ForwardRecentActivity.a(this.this$0).values()));
          this.this$0.startActivityForResult((Intent)localObject1, 20000);
          anot.a(this.this$0.app, "CliOper", "", "", "Two_call", "Tc_msg_cate", 0, 0, "0", "", "", "");
          anot.a(this.this$0.app, "CliOper", "", "", "friendchoose", "0X8009D95", ForwardRecentActivity.a(this.this$0), 0, "", "", "", "");
          if (!this.this$0.aWc) {
            break;
          }
          if ((this.this$0.EP != 1) || (this.this$0.bGQ != 1)) {
            break label1086;
          }
          anot.a(this.this$0.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.buyerselectpage.select", 0, 0, "", "", "", "");
          break;
          if (this.this$0.a != null)
          {
            this.this$0.a.Kp(false);
            com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.boN = false;
          }
          this.this$0.finish();
          anot.a(this.this$0.app, "CliOper", "", "", "friendchoose", "0X8009D8F", ForwardRecentActivity.a(this.this$0), 0, "", "", "", "");
          if (!"caller_aecamera".equals(this.this$0.aNa)) {
            break label400;
          }
          QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", "ae_camera_get_info_client", "action_get_cancle_send_info", null, null);
          break label400;
          label947:
          ((Intent)localObject1).putExtra("forward_filepath", ((Bundle)localObject2).getString("forward_filepath"));
          break label475;
          label966:
          ((Intent)localObject1).putExtras(this.this$0.getIntent().getExtras());
        }
      }
      Object localObject1 = new ForwardRecentActivity.10.1(this, (Intent)localObject1);
      Object localObject2 = new DenyRunnable(this.this$0, 6);
      yuw.a(this.this$0, this.this$0.app, (Runnable)localObject1, (Runnable)localObject2);
      localObject2 = this.this$0.app;
      if (this.this$0.aWe) {}
      for (localObject1 = "2";; localObject1 = "1")
      {
        anot.a((QQAppInterface)localObject2, "dc00899", "Share", "", "select_friend", "clk_addressbook", 0, 0, (String)localObject1, "", "", "");
        break;
      }
      label1086:
      if ((this.this$0.EP == 1) && (this.this$0.bGQ == 2))
      {
        anot.a(this.this$0.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.payerselectpage.select", 0, 0, "", "", "", "");
        continue;
        this.this$0.vw("0X8007826");
        i = 1;
        if (!this.this$0.a.e(ahgg.a.S)) {
          i = 2;
        }
        localObject1 = new Intent(this.this$0, SelectMemberActivity.class);
        ((Intent)localObject1).putExtra("param_type", 3000);
        ((Intent)localObject1).putExtra("param_subtype", 0);
        ((Intent)localObject1).putExtra("param_done_button_wording", this.this$0.getString(2131719439));
        ((Intent)localObject1).putExtra("param_done_button_highlight_wording", this.this$0.getString(2131719440));
        ((Intent)localObject1).putExtra("param_min", i);
        ((Intent)localObject1).putExtra("param_max", 99);
        ((Intent)localObject1).putExtra("param_donot_need_contacts", true);
        ((Intent)localObject1).putExtra("param_entrance", 12);
        this.this$0.startActivityForResult((Intent)localObject1, 20003);
        anot.a(this.this$0.app, "CliOper", "", "", "friendchoose", "0X8009D92", ForwardRecentActivity.a(this.this$0), 0, "", "", "", "");
        continue;
        ForwardRecentActivity.a(this.this$0, (Intent)localObject1);
        if (this.this$0.aWi)
        {
          this.this$0.vw("0X8007825");
          ((Intent)localObject1).setClass(this.this$0, TroopActivity.class);
          if (!this.this$0.a.e(ahgg.a.U))
          {
            ((Intent)localObject1).putExtra("onlyOneSegement", true);
            ((Intent)localObject1).putExtra("_key_mode", 0);
            ((Intent)localObject1).putExtra("key_tab_mode", 1);
            ((Intent)localObject1).putExtra("only_single_selection", this.this$0.aWi);
            this.this$0.startActivityForResult((Intent)localObject1, 20000);
            localObject2 = this.this$0.app;
            if (!this.this$0.aWe) {
              break label1583;
            }
          }
          for (localObject1 = "2";; localObject1 = "1")
          {
            anot.a((QQAppInterface)localObject2, "dc00899", "Share", "", "select_friend", "clk_group", 0, 0, (String)localObject1, "", "", "");
            new anov(this.this$0.app).a("dc00899").b("Grp_listNew").c("send_to").d("clk_grpList").report();
            break;
            if (this.this$0.a.e(ahgg.a.T)) {
              break label1418;
            }
            ((Intent)localObject1).putExtra("onlyOneSegement", true);
            ((Intent)localObject1).putExtra("_key_mode", 1);
            ((Intent)localObject1).putExtra("key_tab_mode", 1);
            break label1418;
          }
        }
        ((Intent)localObject1).putParcelableArrayListExtra("selected_target_list", new ArrayList(ForwardRecentActivity.a(this.this$0).values()));
        ((Intent)localObject1).putExtra("public_fragment_window_feature", 1);
        PublicFragmentActivity.b.startForResult(this.this$0, (Intent)localObject1, PublicTransFragmentActivity.class, ForwardTroopListFragment.class, 20000);
        anot.a(this.this$0.app, "CliOper", "", "", "friendchoose", "0X8009D96", ForwardRecentActivity.a(this.this$0), 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     uxh
 * JD-Core Version:    0.7.0.1
 */