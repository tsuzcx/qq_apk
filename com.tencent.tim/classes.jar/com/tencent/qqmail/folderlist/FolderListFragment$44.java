package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.model.FtnExpireInfo;
import com.tencent.qqmail.model.mail.watcher.FtnQueryExpireUnreadWatcher;
import com.tencent.qqmail.utilities.log.QMLog;

class FolderListFragment$44
  implements FtnQueryExpireUnreadWatcher
{
  FolderListFragment$44(FolderListFragment paramFolderListFragment) {}
  
  public void onSuccess(long paramLong, FtnExpireInfo paramFtnExpireInfo, boolean paramBoolean)
  {
    QMLog.log(4, "FolderListFragment", "Ftn-expunread called folderlist trigger-watcher");
    Object localObject = AccountManager.shareInstance().getAccountList().getDefaultFtnAccount();
    if ((FolderListFragment.access$800(this.this$0) == null) || (localObject == null) || (paramLong != ((Account)localObject).getId())) {}
    do
    {
      return;
      QMLog.log(4, "FolderListFragment", "Ftn-expunread folderlist query expire time isupdate: " + paramBoolean + " expirecnt: " + paramFtnExpireInfo.getLstExpireCnt());
    } while (paramFtnExpireInfo == null);
    localObject = FtnManager.sharedInstance();
    if (localObject != null)
    {
      ((FtnManager)localObject).setFtnExpUnreadUpdate(paramBoolean);
      ((FtnManager)localObject).setFtnExpireInfo(paramFtnExpireInfo);
      if (((FtnManager)localObject).isFtnExpUnreadNeedShow()) {
        FolderDataManager.sharedInstance().setInnerFtnUnreadCount(0);
      }
    }
    FolderListFragment.access$7100(this.this$0, new FolderListFragment.44.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.44
 * JD-Core Version:    0.7.0.1
 */