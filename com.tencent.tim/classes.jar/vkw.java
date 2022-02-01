import android.app.Application;
import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity.14.1;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity.14.2;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import mqq.app.MobileQQ;

public class vkw
  implements CompoundButton.OnCheckedChangeListener
{
  public vkw(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool;
    if (((paramCompoundButton == this.this$0.al.a()) || (paramCompoundButton == PermisionPrivacyActivity.b(this.this$0)) || (paramCompoundButton == PermisionPrivacyActivity.a(this.this$0)) || (paramCompoundButton == this.this$0.am.a()) || (paramCompoundButton == this.this$0.an.a()) || (paramCompoundButton == this.this$0.ap.a())) && (!aqiw.isNetSupport(this.this$0.getActivity())))
    {
      this.this$0.cf(2131696346, 1);
      localObject1 = this.this$0;
      if (!paramBoolean)
      {
        bool = true;
        PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject1, paramCompoundButton, bool);
      }
    }
    int i;
    label402:
    label449:
    label578:
    Object localObject2;
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool = false;
      break;
      if (paramCompoundButton == this.this$0.al.a())
      {
        if (AppSetting.enableTalkBack) {
          this.this$0.al.setContentDescription(this.this$0.getResources().getString(2131696269));
        }
        if (paramBoolean) {}
        for (i = 1;; i = 0)
        {
          anot.a(this.this$0.app, "CliOper", "", "", "Setting_tab", "Nearby_likeme", 0, i, String.valueOf(i), "", "", "");
          this.this$0.app.bD(true, paramBoolean);
          break;
        }
      }
      if (paramCompoundButton == this.this$0.ap.a())
      {
        ((CardHandler)this.this$0.app.getBusinessHandler(2)).EE(paramBoolean);
        if (paramBoolean) {
          anot.a(this.this$0.app, "dc00898", "", "", "0X8009E81", "0X8009E81", 0, 0, "", "", "", "");
        } else {
          anot.a(this.this$0.app, "dc00898", "", "", "0X8009E80", "0X8009E80", 0, 0, "", "", "", "");
        }
      }
      else
      {
        if (paramCompoundButton == this.this$0.at.a())
        {
          if (!aqiw.isNetSupport(this.this$0.app.getApplication().getApplicationContext()))
          {
            QQToast.a(this.this$0.getApplicationContext(), 2131719890, 1).show();
            localObject1 = this.this$0;
            if (!paramBoolean)
            {
              bool = true;
              PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject1, paramCompoundButton, bool);
            }
          }
          else
          {
            localObject1 = (CardHandler)this.this$0.app.getBusinessHandler(2);
            if (paramBoolean) {
              break label449;
            }
          }
          for (bool = true;; bool = false)
          {
            ((CardHandler)localObject1).EA(bool);
            break;
            bool = false;
            break label402;
          }
        }
        if (paramCompoundButton == this.this$0.b)
        {
          if (!aqiw.isNetSupport(this.this$0.app.getApplication().getApplicationContext()))
          {
            QQToast.a(this.this$0.getApplicationContext(), 2131696272, 1).show();
            this.this$0.b.setOnCheckedChangeListener(null);
            localObject1 = this.this$0.b;
            if (this.this$0.app.AK() == 1) {}
            for (bool = true;; bool = false)
            {
              ((CompoundButton)localObject1).setChecked(bool);
              this.this$0.b.setOnCheckedChangeListener(this.this$0.a);
              break;
            }
          }
          if (paramBoolean)
          {
            i = 1;
            anot.a(this.this$0.app, "CliOper", "", "", "Setting_tab", "Latest_chatlog_syn", 0, i, String.valueOf(i), "", "", "");
            this.this$0.vl(this.this$0.getApplication().getResources().getString(2131719578));
            if (!paramBoolean) {
              break label657;
            }
          }
          label657:
          for (i = 1;; i = 0)
          {
            this.this$0.app.JD(i);
            break;
            i = 0;
            break label578;
          }
        }
        if (paramCompoundButton == PermisionPrivacyActivity.b(this.this$0))
        {
          if (paramBoolean) {}
          for (i = 1;; i = 0)
          {
            anot.a(this.this$0.app, "CliOper", "", "", "Setting_tab", "Visible_same", 0, i, String.valueOf(i), "", "", "");
            this.this$0.app.setVisibilityForStatus(paramBoolean, false);
            this.this$0.xL(paramBoolean);
            break;
          }
        }
        if (paramCompoundButton == PermisionPrivacyActivity.a(this.this$0))
        {
          if (paramBoolean) {}
          for (i = 1;; i = 0)
          {
            anot.a(this.this$0.app, "CliOper", "", "", "Setting_tab", "Same_likeme", 0, i, String.valueOf(i), "", "", "");
            this.this$0.app.bD(false, paramBoolean);
            break;
          }
        }
        if (paramCompoundButton == this.this$0.as.a())
        {
          if (paramBoolean) {}
          for (i = 1;; i = 0)
          {
            anot.a(this.this$0.app, "CliOper", "", "", "Setting_tab", "Clk_signature_qzone", 0, i, String.valueOf(i), "", "", "");
            if ((!aqiw.isNetSupport(this.this$0.getActivity())) || (PermisionPrivacyActivity.a(this.this$0) == null)) {
              break label924;
            }
            if (AppSetting.enableTalkBack) {
              this.this$0.as.setContentDescription(acfp.m(2131709428));
            }
            PermisionPrivacyActivity.a(this.this$0).E(paramBoolean);
            break;
          }
          label924:
          localObject1 = this.this$0;
          if (PermisionPrivacyActivity.a(this.this$0) != null)
          {
            i = 2131696346;
            label943:
            PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject1, i);
            localObject1 = this.this$0;
            localObject2 = this.this$0.as.a();
            if (paramBoolean) {
              break label992;
            }
          }
          label992:
          for (bool = true;; bool = false)
          {
            PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject1, (CompoundButton)localObject2, bool);
            break;
            i = 2131719890;
            break label943;
          }
        }
        if (paramCompoundButton == this.this$0.ar.a())
        {
          if (AppSetting.enableTalkBack) {
            this.this$0.ar.setContentDescription("可通过系统通讯录发起QQ聊天");
          }
          localObject1 = new PermisionPrivacyActivity.14.1(this, (aevy)this.this$0.app.getManager(41), paramBoolean);
          localObject2 = new PermisionPrivacyActivity.14.2(this);
          if (paramBoolean)
          {
            if ((yuw.UB()) && (VersionUtils.isM()))
            {
              PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.this$0.app.getManager(11);
              yuy localyuy = new yuy();
              localyuy.eP = ((Runnable)localObject1);
              localyuy.eQ = ((Runnable)localObject2);
              localyuy.mask = 7;
              localPhoneContactManagerImp.a().a(this.this$0, localyuy, this.this$0, new String[] { "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS" });
            }
            else
            {
              ((Runnable)localObject1).run();
            }
          }
          else {
            ((Runnable)localObject1).run();
          }
        }
        else if (paramCompoundButton == this.this$0.am.a())
        {
          if (AppSetting.enableTalkBack) {
            this.this$0.am.setContentDescription(acfp.m(2131709430));
          }
          PermisionPrivacyActivity.a(this.this$0, this.this$0.am.a(), paramBoolean);
          this.this$0.app.bB(paramBoolean, true);
          if (paramBoolean) {
            anot.a(this.this$0.app, "CliOper", "", "", "0X8009C08", "0X8009C08", 0, 0, "", "", "", "");
          } else {
            anot.a(this.this$0.app, "CliOper", "", "", "0X8009C09", "0X8009C09", 0, 0, "", "", "", "");
          }
        }
        else if (paramCompoundButton == this.this$0.an.a())
        {
          if (AppSetting.enableTalkBack) {
            this.this$0.an.setContentDescription(acfp.m(2131709421));
          }
          PermisionPrivacyActivity.a(this.this$0, this.this$0.an.a(), paramBoolean);
          this.this$0.app.bC(paramBoolean, true);
        }
        else
        {
          if (paramCompoundButton == this.this$0.ao.a())
          {
            localObject1 = this.this$0.app;
            if (paramBoolean) {}
            for (i = 1;; i = 0)
            {
              anot.a((QQAppInterface)localObject1, "CliOper", "", "", "0X800487E", "0X800487E", 0, 0, String.valueOf(i), "", "", "");
              if (!aqiw.isNetSupport(this.this$0.getActivity())) {
                break label1520;
              }
              if (AppSetting.enableTalkBack) {
                this.this$0.ao.setContentDescription(acfp.m(2131709431));
              }
              ((CardHandler)this.this$0.app.getBusinessHandler(2)).Ey(paramBoolean);
              break;
            }
            label1520:
            localObject1 = this.this$0;
            if (PermisionPrivacyActivity.a(this.this$0) != null)
            {
              i = 2131696346;
              label1539:
              PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject1, i);
              localObject1 = this.this$0;
              localObject2 = this.this$0.ao.a();
              if (paramBoolean) {
                break label1588;
              }
            }
            label1588:
            for (bool = true;; bool = false)
            {
              PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject1, (CompoundButton)localObject2, bool);
              break;
              i = 2131719890;
              break label1539;
            }
          }
          if (paramCompoundButton == this.this$0.aq.a())
          {
            if ((paramCompoundButton.getTag() == null) || (!((Boolean)paramCompoundButton.getTag()).booleanValue())) {
              break label1638;
            }
            paramCompoundButton.setTag(Boolean.FALSE);
          }
        }
      }
    }
    label1638:
    this.this$0.c.FI(paramBoolean);
    Object localObject1 = this.this$0.Ey;
    if (paramBoolean)
    {
      i = 2131694507;
      label1666:
      ((TextView)localObject1).setText(i);
      localObject2 = this.this$0.app;
      if (!paramBoolean) {
        break label1728;
      }
    }
    label1728:
    for (localObject1 = "open_autopass";; localObject1 = "close_autopass")
    {
      anot.a((QQAppInterface)localObject2, "dc00899", "Grp_invite_friend", "", "auto_pass", (String)localObject1, 0, 0, "", "", "", "");
      break;
      i = 2131694508;
      break label1666;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vkw
 * JD-Core Version:    0.7.0.1
 */