package com.tencent.qqmail.utilities.uitableview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class UITableItemCheckBoxView$1
  implements View.OnClickListener
{
  UITableItemCheckBoxView$1(UITableItemCheckBoxView paramUITableItemCheckBoxView, UITableItemCheckBoxView.OnCheckChangeListener paramOnCheckChangeListener) {}
  
  public void onClick(View paramView)
  {
    this.val$onChangeListener.onChange(this.this$0, this.this$0.getChecked());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.uitableview.UITableItemCheckBoxView.1
 * JD-Core Version:    0.7.0.1
 */