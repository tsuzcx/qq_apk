package com.tencent.qqmail.movemail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ManageFolderActivity$4
  implements View.OnClickListener
{
  ManageFolderActivity$4(ManageFolderActivity paramManageFolderActivity) {}
  
  public void onClick(View paramView)
  {
    ManageFolderActivity.access$1400(this.this$0, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movemail.ManageFolderActivity.4
 * JD-Core Version:    0.7.0.1
 */