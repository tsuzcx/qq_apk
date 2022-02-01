package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.view.QMWebView;

class VoteViewExplorer$1
  implements View.OnClickListener
{
  VoteViewExplorer$1(VoteViewExplorer paramVoteViewExplorer) {}
  
  public void onClick(View paramView)
  {
    paramView.setSelected(true);
    VoteViewExplorer.access$000(this.this$0).stopLoading();
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.VoteViewExplorer.1
 * JD-Core Version:    0.7.0.1
 */