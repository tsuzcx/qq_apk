package com.tencent.qqmail.utilities.uitableview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class UITableView$1
  implements View.OnClickListener
{
  UITableView$1(UITableView paramUITableView) {}
  
  public void onClick(View paramView)
  {
    UITableView.access$100(this.this$0).onClick(UITableView.access$000(this.this$0, paramView), (UITableItemView)paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.uitableview.UITableView.1
 * JD-Core Version:    0.7.0.1
 */