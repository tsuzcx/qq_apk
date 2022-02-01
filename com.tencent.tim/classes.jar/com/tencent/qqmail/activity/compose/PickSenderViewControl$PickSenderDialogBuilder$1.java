package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;

class PickSenderViewControl$PickSenderDialogBuilder$1
  implements AdapterView.OnItemClickListener
{
  PickSenderViewControl$PickSenderDialogBuilder$1(PickSenderViewControl.PickSenderDialogBuilder paramPickSenderDialogBuilder, QMUIDialog paramQMUIDialog) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    PickSenderViewControl.access$1500(this.this$1.this$0, this.val$dialog, paramInt, paramView);
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.PickSenderViewControl.PickSenderDialogBuilder.1
 * JD-Core Version:    0.7.0.1
 */