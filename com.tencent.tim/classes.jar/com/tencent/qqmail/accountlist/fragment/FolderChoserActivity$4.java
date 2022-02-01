package com.tencent.qqmail.accountlist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FolderChoserActivity$4
  implements View.OnClickListener
{
  FolderChoserActivity$4(FolderChoserActivity paramFolderChoserActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.setResult(-1, null);
    this.this$0.finish();
    this.this$0.overridePendingTransition(2130772423, 2130772402);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.FolderChoserActivity.4
 * JD-Core Version:    0.7.0.1
 */