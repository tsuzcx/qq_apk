package com.tencent.qqmail.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadMailDetailInformationView$2
  implements View.OnClickListener
{
  ReadMailDetailInformationView$2(ReadMailDetailInformationView paramReadMailDetailInformationView) {}
  
  public void onClick(View paramView)
  {
    this.this$0.onMailContactClick(paramView, ReadMailDetailInformationView.access$100(this.this$0), 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.ReadMailDetailInformationView.2
 * JD-Core Version:    0.7.0.1
 */