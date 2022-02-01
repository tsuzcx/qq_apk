package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class PickSenderViewControl$2
  implements QMUIDialogAction.ActionListener
{
  PickSenderViewControl$2(PickSenderViewControl paramPickSenderViewControl) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    this.this$0.dismissPickerView();
    PickSenderViewControl.access$302(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.PickSenderViewControl.2
 * JD-Core Version:    0.7.0.1
 */