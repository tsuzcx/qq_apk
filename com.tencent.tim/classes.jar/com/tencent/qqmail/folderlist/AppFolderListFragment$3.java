package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;
import com.tencent.qqmail.note.NoteListActivity;
import com.tencent.qqmail.view.FolderLockDialog;
import moai.core.watcher.Watchers;

class AppFolderListFragment$3
  implements QMUnlockFolderPwdWatcher
{
  AppFolderListFragment$3(AppFolderListFragment paramAppFolderListFragment) {}
  
  public void onCancel(int paramInt1, int paramInt2) {}
  
  public void onDismiss(int paramInt1, int paramInt2) {}
  
  public void onError(int paramInt1, int paramInt2)
  {
    AppFolderListFragment.access$600(this.this$0, new AppFolderListFragment.3.1(this));
  }
  
  public void onSuccess(int paramInt1, int paramInt2)
  {
    Watchers.bind(this.this$0.mUnlockFolderPwd, false);
    AppFolderListFragment.access$100(this.this$0).cancelDialog();
    AppFolderListFragment.access$100(this.this$0).dismissTips();
    if (paramInt2 == -4) {
      this.this$0.startActivity(NoteListActivity.createIntent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.AppFolderListFragment.3
 * JD-Core Version:    0.7.0.1
 */