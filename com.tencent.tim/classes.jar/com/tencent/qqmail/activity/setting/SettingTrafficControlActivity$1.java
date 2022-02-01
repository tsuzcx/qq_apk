package com.tencent.qqmail.activity.setting;

import android.widget.Toast;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLogStream;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingTrafficControlActivity$1
  implements UITableView.ClickListener
{
  SettingTrafficControlActivity$1(SettingTrafficControlActivity paramSettingTrafficControlActivity, UITableItemView paramUITableItemView1, UITableItemView paramUITableItemView2, UITableItemView paramUITableItemView3, UITableItemView paramUITableItemView4) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    boolean bool3 = true;
    boolean bool2 = true;
    boolean bool4 = paramUITableItemView.isChecked();
    if (!bool4)
    {
      bool1 = true;
      paramUITableItemView.setChecked(bool1);
      if (paramUITableItemView != this.val$osslogItem) {
        break label55;
      }
    }
    label55:
    do
    {
      do
      {
        Toast.makeText(this.this$0.getApplicationContext(), "请点击重启使配置生效", 0).show();
        return;
        bool1 = false;
        break;
      } while (paramUITableItemView == this.val$beaconItem);
      if (paramUITableItemView == this.val$logstreamItem)
      {
        if (!bool4) {}
        for (bool1 = bool2;; bool1 = false)
        {
          QMLogStream.setEnable(bool1);
          break;
        }
      }
    } while (paramUITableItemView != this.val$umaItem);
    if (!bool4) {}
    for (boolean bool1 = bool3;; bool1 = false)
    {
      DataCollector.setEnable(bool1);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingTrafficControlActivity.1
 * JD-Core Version:    0.7.0.1
 */