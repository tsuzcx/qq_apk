package com.tencent.qqmail.activity.readmail;

import android.content.Intent;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import moai.fragment.app.FragmentActivity;

class ReadMailFragment$74
  implements QMUIDialogAction.ActionListener
{
  ReadMailFragment$74(ReadMailFragment paramReadMailFragment) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    DataCollector.logEvent("Event_Mail_Revoke_Confirm");
    if ((ReadMailFragment.access$13500(this.this$0)) || (this.this$0.getActivity().getIntent().getBooleanExtra("arg_is_cancel_fail", false))) {
      DataCollector.logEvent("Event_Send_Mail_Recall_Confirm");
    }
    ReadMailFragment.access$13600(this.this$0, 2);
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.74
 * JD-Core Version:    0.7.0.1
 */