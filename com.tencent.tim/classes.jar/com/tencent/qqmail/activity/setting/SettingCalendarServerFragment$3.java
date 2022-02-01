package com.tencent.qqmail.activity.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.model.QMCalendarProtocolManager.LoginType;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;
import com.tencent.qqmail.view.QMTopBar;

class SettingCalendarServerFragment$3
  implements View.OnClickListener
{
  SettingCalendarServerFragment$3(SettingCalendarServerFragment paramSettingCalendarServerFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.hideKeyBoard();
    SettingCalendarServerFragment.access$1000(this.this$0).setFocusable(true);
    SettingCalendarServerFragment.access$1000(this.this$0).setFocusableInTouchMode(true);
    SettingCalendarServerFragment.access$1000(this.this$0).requestFocus();
    SettingCalendarServerFragment.access$1000(this.this$0).requestFocusFromTouch();
    Object localObject1 = SettingCalendarServerFragment.access$600(this.this$0).getText().toString();
    Object localObject2 = SettingCalendarServerFragment.access$1100(this.this$0).getText().toString();
    String str = SettingCalendarServerFragment.access$1200(this.this$0).getText().toString();
    if (!((String)localObject2).equals(SettingCalendarServerFragment.access$500(this.this$0).getEmail())) {
      SettingCalendarServerFragment.access$1300(this.this$0, 2131719691);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((!((String)localObject1).equals("")) && (!((String)localObject2).equals("")) && (!str.equals("")))
      {
        Account localAccount = SettingCalendarServerFragment.access$500(this.this$0);
        localAccount.setEmail((String)localObject2);
        localAccount.setPwd(Aes.encode(str, Aes.getPureDeviceToken()));
        localObject2 = QMCalendarProtocolManager.LoginType.UserDefine;
        ((QMCalendarProtocolManager.LoginType)localObject2).setHost((String)localObject1);
        if (SettingCalendarServerFragment.access$000(this.this$0))
        {
          ((QMCalendarProtocolManager.LoginType)localObject2).setAccountType(1);
          ((QMCalendarProtocolManager.LoginType)localObject2).setSSLSupported(SettingCalendarServerFragment.access$1400(this.this$0).isChecked());
        }
        for (;;)
        {
          SettingCalendarServerFragment.access$702(this.this$0, true);
          SettingCalendarServerFragment.access$800(this.this$0);
          SettingCalendarServerFragment.access$900(this.this$0, false);
          localObject1 = new MailManagerDelegate();
          ((MailManagerDelegate)localObject1).setOnError(new SettingCalendarServerFragment.3.1(this));
          ((MailManagerDelegate)localObject1).setOnSuccess(new SettingCalendarServerFragment.3.2(this, new int[] { 2131378056, 2131381230, 2131372895, 2131365747 }));
          QMCalendarManager.getInstance().login(localAccount, (QMCalendarProtocolManager.LoginType)localObject2, (MailManagerDelegate)localObject1);
          break;
          ((QMCalendarProtocolManager.LoginType)localObject2).setAccountType(2);
          ((QMCalendarProtocolManager.LoginType)localObject2).setSSLSupported(true);
        }
      }
      SettingCalendarServerFragment.access$1300(this.this$0, 2131719696);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarServerFragment.3
 * JD-Core Version:    0.7.0.1
 */