package com.tencent.qqmail.activity.setting.tableactivity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.QMApplicationContext;

class BaseTableActivity$1
  implements View.OnClickListener
{
  BaseTableActivity$1(BaseTableActivity paramBaseTableActivity, Class paramClass) {}
  
  public void onClick(View paramView)
  {
    try
    {
      Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), this.val$activityClass);
      this.this$0.startActivity(localIntent);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.tableactivity.BaseTableActivity.1
 * JD-Core Version:    0.7.0.1
 */