package com.tencent.qqmail.utilities.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QMToggleView$2
  implements AdapterView.OnItemClickListener
{
  QMToggleView$2(QMToggleView paramQMToggleView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.this$0.hide();
    if (QMToggleView.access$000(this.this$0) != null) {
      if (QMToggleView.access$000(this.this$0).willSelectRow(this.this$0, paramInt, QMToggleView.access$100(this.this$0).getItem(paramInt))) {
        this.this$0.setSelectedRow(paramInt);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      this.this$0.setSelectedRow(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMToggleView.2
 * JD-Core Version:    0.7.0.1
 */