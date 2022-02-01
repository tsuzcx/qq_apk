package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.model.mail.watcher.LoadListWatcher;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class FolderListFragment$46
  implements LoadListWatcher
{
  FolderListFragment$46(FolderListFragment paramFolderListFragment) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError)
  {
    FolderListFragment.access$7800(this.this$0, new FolderListFragment.46.3(this, paramInt));
  }
  
  public void onPopIn(long paramLong, String paramString) {}
  
  public void onProcess(int paramInt, boolean paramBoolean) {}
  
  public void onSuccess(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == 0) {
      FolderListFragment.access$7600(this.this$0, new FolderListFragment.46.1(this, paramInt1));
    }
    QMFolder localQMFolder;
    do
    {
      return;
      localQMFolder = QMFolderManager.sharedInstance().getFolder(FolderListFragment.access$200(this.this$0), paramInt1, false);
    } while ((localQMFolder == null) || (AccountManager.shareInstance().getAccountList().getAccountById(localQMFolder.getAccountId()) == null) || (paramBoolean));
    FolderListFragment.access$7700(this.this$0, new FolderListFragment.46.2(this, paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.46
 * JD-Core Version:    0.7.0.1
 */