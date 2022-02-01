package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.accountlist.QMAccountHelper;
import com.tencent.qqmail.folderlist.adapter.QMFolderListAdapter;
import com.tencent.qqmail.folderlist.adapter.QMFolderListDragAdapter;
import java.util.List;

class FolderListFragment$23
  implements Runnable
{
  FolderListFragment$23(FolderListFragment paramFolderListFragment) {}
  
  public void run()
  {
    FolderListFragment.access$502(this.this$0, QMFolderManager.sharedInstance().getFoldersByAccountId(FolderListFragment.access$200(this.this$0)));
    FolderListFragment.access$4402(this.this$0, QMFolderManager.sharedInstance().getAllFoldersByAccountId(FolderListFragment.access$200(this.this$0)));
    FolderListFragment.access$4502(this.this$0, QMAccountHelper.getUniversalFolders(FolderListFragment.access$4600(this.this$0).getAccountList()));
    FolderListFragment localFolderListFragment;
    List localList;
    if ((FolderListFragment.access$500(this.this$0) != null) && (FolderListFragment.access$500(this.this$0).size() != 0))
    {
      localFolderListFragment = this.this$0;
      localList = FolderListFragment.access$500(this.this$0);
      if (FolderListFragment.access$700(this.this$0) <= 1) {
        break label211;
      }
    }
    label211:
    for (boolean bool = true;; bool = false)
    {
      FolderListFragment.access$4702(localFolderListFragment, FolderListItemHelper.createFolderItem(localList, bool, FolderListFragment.access$4800(this.this$0), FolderListFragment.access$2000(this.this$0)));
      if (!FolderListFragment.access$4800(this.this$0)) {
        break;
      }
      FolderListFragment.access$3400(this.this$0).setFolderInfo(FolderListFragment.access$4700(this.this$0), 1);
      FolderListFragment.access$3400(this.this$0).setAllUniversalFolders(FolderListFragment.access$4500(this.this$0));
      FolderListFragment.access$3400(this.this$0).setAllRealFolders(FolderListFragment.access$4400(this.this$0));
      FolderListFragment.access$3400(this.this$0).notifyDataSetChanged();
      return;
    }
    FolderListFragment.access$800(this.this$0).setFolderInfo(FolderListFragment.access$4700(this.this$0), 1);
    FolderListFragment.access$800(this.this$0).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.23
 * JD-Core Version:    0.7.0.1
 */