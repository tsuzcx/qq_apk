package com.tencent.qqmail.activity.setting;

import android.widget.Toast;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingTrafficControlActivity$2
  implements UITableView.ClickListener
{
  SettingTrafficControlActivity$2(SettingTrafficControlActivity paramSettingTrafficControlActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    Toast.makeText(this.this$0.getApplicationContext(), "正在重启，请稍安勿躁...", 1).show();
    Threads.runInBackground(new SettingTrafficControlActivity.2.1(this), 5000L);
    paramUITableItemView.setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingTrafficControlActivity.2
 * JD-Core Version:    0.7.0.1
 */