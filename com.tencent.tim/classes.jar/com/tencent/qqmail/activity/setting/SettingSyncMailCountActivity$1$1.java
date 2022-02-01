package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.model.protocol.QMSyncManager;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup;

class SettingSyncMailCountActivity$1$1
  implements QMUIDialogAction.ActionListener
{
  SettingSyncMailCountActivity$1$1(SettingSyncMailCountActivity.1 param1, int paramInt) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    SettingSyncMailCountActivity.access$000(this.this$1.this$0).setSelectedItem(this.val$id);
    QMSyncManager.sharedInstance().setSyncMailCountOrDay(SettingSyncMailCountActivity.access$100(this.this$1.this$0), this.val$id);
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingSyncMailCountActivity.1.1
 * JD-Core Version:    0.7.0.1
 */