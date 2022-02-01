package com.tencent.qqmail.accountlist.fragment;

import android.content.Intent;
import com.tencent.qqmail.activity.compose.ComposeNoteActivity;
import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;
import com.tencent.qqmail.note.NoteListActivity;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.view.FolderLockDialog;
import moai.core.watcher.Watchers;

class AccountListFragment$34
  implements QMUnlockFolderPwdWatcher
{
  AccountListFragment$34(AccountListFragment paramAccountListFragment) {}
  
  public void onCancel(int paramInt1, int paramInt2) {}
  
  public void onDismiss(int paramInt1, int paramInt2) {}
  
  public void onError(int paramInt1, int paramInt2)
  {
    AccountListFragment.access$4000(this.this$0, new AccountListFragment.34.1(this));
  }
  
  public void onSuccess(int paramInt1, int paramInt2)
  {
    Watchers.bind(this.this$0.mUnlockFolderPwd, false);
    AccountListFragment.access$2500(this.this$0).cancelDialog();
    AccountListFragment.access$2500(this.this$0).dismissTips();
    if (paramInt2 == -4)
    {
      if (this.this$0.mIsGoingToComposeNote) {}
      for (Intent localIntent = ComposeNoteActivity.createIntentFromAccountList();; localIntent = NoteListActivity.createIntent())
      {
        this.this$0.startActivity(localIntent);
        return;
      }
    }
    DataCollector.logPerformanceBegin("Performance_Click_Maillist", paramInt1, "Performance_Click_Maillist" + paramInt1);
    AccountListFragment.access$2800(this.this$0, paramInt2, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.34
 * JD-Core Version:    0.7.0.1
 */