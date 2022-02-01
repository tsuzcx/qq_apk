package com.tencent.qqmail.activity.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.calendar.model.QMCalendarProtocolManager;
import com.tencent.qqmail.calendar.model.QMCalendarProtocolManager.LoginType;

class SettingCalendarServerFragment$1
  implements View.OnClickListener
{
  SettingCalendarServerFragment$1(SettingCalendarServerFragment paramSettingCalendarServerFragment) {}
  
  public void onClick(View paramView)
  {
    QMCalendarProtocolManager.LoginType localLoginType;
    if (paramView.getId() == 2131366567)
    {
      SettingCalendarServerFragment.access$002(this.this$0, true);
      SettingCalendarServerFragment.access$100(this.this$0).setSelected(true);
      SettingCalendarServerFragment.access$200(this.this$0).setSelected(false);
      SettingCalendarServerFragment.access$300(this.this$0).setVisibility(0);
      SettingCalendarServerFragment.access$400(this.this$0).setVisibility(8);
      localLoginType = QMCalendarProtocolManager.getLoginType(SettingCalendarServerFragment.access$500(this.this$0), 1);
      if ((localLoginType.getHost() != null) && (localLoginType.getAccountType() == 1)) {
        SettingCalendarServerFragment.access$600(this.this$0).setText(localLoginType.getHost());
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      SettingCalendarServerFragment.access$600(this.this$0).setText("");
      continue;
      SettingCalendarServerFragment.access$002(this.this$0, false);
      SettingCalendarServerFragment.access$100(this.this$0).setSelected(false);
      SettingCalendarServerFragment.access$200(this.this$0).setSelected(true);
      SettingCalendarServerFragment.access$300(this.this$0).setVisibility(8);
      SettingCalendarServerFragment.access$400(this.this$0).setVisibility(0);
      localLoginType = QMCalendarProtocolManager.getLoginType(SettingCalendarServerFragment.access$500(this.this$0), 2);
      if ((localLoginType.getHost() != null) && (localLoginType.getAccountType() == 2)) {
        SettingCalendarServerFragment.access$600(this.this$0).setText(localLoginType.getHost());
      } else {
        SettingCalendarServerFragment.access$600(this.this$0).setText("");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarServerFragment.1
 * JD-Core Version:    0.7.0.1
 */