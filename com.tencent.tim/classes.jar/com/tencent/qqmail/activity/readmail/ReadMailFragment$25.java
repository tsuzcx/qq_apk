package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.namelist.fragment.NameListFragmentActivity;
import com.tencent.qqmail.namelist.model.NameListContact.NameListContactType;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class ReadMailFragment$25
  implements QMUIDialogAction.ActionListener
{
  ReadMailFragment$25(ReadMailFragment paramReadMailFragment, String paramString) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    paramQMUIDialog = NameListFragmentActivity.createIntentToMainList(ReadMailFragment.access$200(this.this$0), NameListContact.NameListContactType.WHITE.ordinal(), true, this.val$email);
    this.this$0.startActivity(paramQMUIDialog);
    DataCollector.logEvent("Event_Black_White_Name_List_Popup_Dialog_In_Spam_Not_Click_Check_White");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.25
 * JD-Core Version:    0.7.0.1
 */