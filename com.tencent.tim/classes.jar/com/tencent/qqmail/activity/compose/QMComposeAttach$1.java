package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.qmdomain.AttachInfo;

class QMComposeAttach$1
  implements AdapterView.OnItemClickListener
{
  QMComposeAttach$1(QMComposeAttach paramQMComposeAttach) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView.setTag(2131379198, (AttachInfo)this.this$0.getAdapter().getItem(paramInt));
    paramView.setTag(2131379199, Integer.valueOf(paramInt));
    if (QMComposeAttach.access$000(this.this$0) != null) {
      QMComposeAttach.access$000(this.this$0).onClickItem((QMComposeAttachItem)paramView);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMComposeAttach.1
 * JD-Core Version:    0.7.0.1
 */