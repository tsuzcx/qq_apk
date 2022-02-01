package com.tencent.qqmail.accountlist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FolderChoserActivity$3
  implements View.OnClickListener
{
  FolderChoserActivity$3(FolderChoserActivity paramFolderChoserActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.setResult(2, null);
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.FolderChoserActivity.3
 * JD-Core Version:    0.7.0.1
 */