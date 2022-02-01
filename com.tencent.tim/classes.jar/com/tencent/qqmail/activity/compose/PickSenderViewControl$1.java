package com.tencent.qqmail.activity.compose;

import android.widget.EditText;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class PickSenderViewControl$1
  implements QMUIDialogAction.ActionListener
{
  PickSenderViewControl$1(PickSenderViewControl paramPickSenderViewControl) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    this.this$0.checkNick(PickSenderViewControl.access$000(this.this$0).getText().toString());
    PickSenderViewControl.access$102(this.this$0, PickSenderViewControl.access$000(this.this$0).getText().toString());
    if (this.this$0.isNickChange)
    {
      DataCollector.logEvent("Event_Compose_Set_Nick");
      PickSenderViewControl.access$200(this.this$0, PickSenderViewControl.access$000(this.this$0).getContext(), PickSenderViewControl.access$000(this.this$0).getText().toString(), this.this$0.getChooseName(), this.this$0.getChooseAccountId());
    }
    this.this$0.dismissPickerView();
    PickSenderViewControl.access$302(this.this$0, false);
    PickSenderViewControl.access$500(this.this$0).didSelectRow(this.this$0, PickSenderViewControl.access$400(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.PickSenderViewControl.1
 * JD-Core Version:    0.7.0.1
 */