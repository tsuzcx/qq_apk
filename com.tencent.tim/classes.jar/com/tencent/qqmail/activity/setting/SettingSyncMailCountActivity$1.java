package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.protocol.QMSyncManager;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup.OnCheckedChangeListener;

class SettingSyncMailCountActivity$1
  implements QMRadioGroup.OnCheckedChangeListener
{
  SettingSyncMailCountActivity$1(SettingSyncMailCountActivity paramSettingSyncMailCountActivity) {}
  
  public void onCheckedChanged(QMRadioGroup paramQMRadioGroup, int paramInt)
  {
    if (paramInt == 20000) {
      ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.this$0.getActivity()).setTitle(2131696424)).setMessage(2131719987).addAction(2131691246, new SettingSyncMailCountActivity.1.2(this))).addAction(2131696547, new SettingSyncMailCountActivity.1.1(this, paramInt))).create().show();
    }
    for (;;)
    {
      QMMailManager.sharedInstance().setSyncMailCountORMailTime(SettingSyncMailCountActivity.access$100(this.this$0), QMSyncManager.sharedInstance().transformMailCountORMailTimeToServer(paramInt));
      return;
      SettingSyncMailCountActivity.access$000(this.this$0).setSelectedItem(paramInt);
      QMSyncManager.sharedInstance().setSyncMailCountOrDay(SettingSyncMailCountActivity.access$100(this.this$0), paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingSyncMailCountActivity.1
 * JD-Core Version:    0.7.0.1
 */