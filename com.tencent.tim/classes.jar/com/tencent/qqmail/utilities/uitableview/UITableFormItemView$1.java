package com.tencent.qqmail.utilities.uitableview;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class UITableFormItemView$1
  implements View.OnClickListener
{
  UITableFormItemView$1(UITableFormItemView paramUITableFormItemView) {}
  
  public void onClick(View paramView)
  {
    UITableFormItemView.access$000(this.this$0).setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.uitableview.UITableFormItemView.1
 * JD-Core Version:    0.7.0.1
 */