package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.webviewexplorer.SimpleWebViewExplorer;

class SettingAboutActivity$5
  implements View.OnClickListener
{
  SettingAboutActivity$5(SettingAboutActivity paramSettingAboutActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = SimpleWebViewExplorer.createIntent("https://mail.qq.com/cgi-bin/readtemplate?check=false&t=mail_clause", this.this$0.getString(2131719636), SimpleWebViewExplorer.TOPBAR_LEFT_BUTTON);
    this.this$0.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAboutActivity.5
 * JD-Core Version:    0.7.0.1
 */