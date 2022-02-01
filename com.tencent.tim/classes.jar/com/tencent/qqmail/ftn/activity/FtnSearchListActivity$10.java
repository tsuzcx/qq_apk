package com.tencent.qqmail.ftn.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.ui.QMSearchBar;

class FtnSearchListActivity$10
  implements View.OnClickListener
{
  FtnSearchListActivity$10(FtnSearchListActivity paramFtnSearchListActivity) {}
  
  public void onClick(View paramView)
  {
    FtnSearchListActivity.access$1100(this.this$0);
    FtnSearchListActivity.access$1800(this.this$0).searchInput.setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnSearchListActivity.10
 * JD-Core Version:    0.7.0.1
 */