package com.tencent.qqmail.movemail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ManageFolderActivity$2
  implements View.OnClickListener
{
  ManageFolderActivity$2(ManageFolderActivity paramManageFolderActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.finishWithNoCheck();
    this.this$0.overridePendingTransition(0, 2130772402);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movemail.ManageFolderActivity.2
 * JD-Core Version:    0.7.0.1
 */