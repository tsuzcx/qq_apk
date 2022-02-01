package com.tencent.qqmail.ftn.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.ImageScaleDegree;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;

class FtnListActivity$40
  implements View.OnClickListener
{
  FtnListActivity$40(FtnListActivity paramFtnListActivity) {}
  
  public void onClick(View paramView)
  {
    FtnListActivity.access$6700(this.this$0).dismiss();
    FtnListActivity.access$6800(this.this$0);
    FtnListActivity.access$2602(this.this$0, ComposeMailUI.ImageScaleDegree.ImageScaleDegree_Origin);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.40
 * JD-Core Version:    0.7.0.1
 */