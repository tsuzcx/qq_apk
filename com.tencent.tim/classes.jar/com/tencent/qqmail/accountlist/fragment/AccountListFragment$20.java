package com.tencent.qqmail.accountlist.fragment;

import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import java.util.HashMap;

class AccountListFragment$20
  implements QMUIDialogAction.ActionListener
{
  AccountListFragment$20(AccountListFragment paramAccountListFragment) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    DataCollector.logEvent("Event_Accountlist_Hide_Inbox_Dialog_Show_Click_Sure");
    AccountListFragment.access$2100(this.this$0).clear();
    AccountListFragment.access$1900(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.20
 * JD-Core Version:    0.7.0.1
 */