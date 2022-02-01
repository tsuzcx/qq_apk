package com.tencent.qqmail.movemail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ManageFolderActivity$5
  implements View.OnClickListener
{
  ManageFolderActivity$5(ManageFolderActivity paramManageFolderActivity) {}
  
  public void onClick(View paramView)
  {
    ManageFolderActivity.access$1400(this.this$0, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movemail.ManageFolderActivity.5
 * JD-Core Version:    0.7.0.1
 */