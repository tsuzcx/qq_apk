package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.folderlist.adapter.QMFolderListAdapter;
import com.tencent.qqmail.folderlist.model.IListFolder;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;

class AppFolderListFragment$4
  implements Runnable
{
  AppFolderListFragment$4(AppFolderListFragment paramAppFolderListFragment) {}
  
  public void run()
  {
    AppFolderListFragment.access$702(this.this$0, FolderListItemHelper.getInnerAppFolderData());
    StringBuilder localStringBuilder = new StringBuilder();
    int i;
    if ((AppFolderListFragment.access$700(this.this$0) != null) && (AppFolderListFragment.access$700(this.this$0).size() > 0)) {
      i = 0;
    }
    while (i < AppFolderListFragment.access$700(this.this$0).size())
    {
      Object localObject = (IListFolder)AppFolderListFragment.access$700(this.this$0).get(i);
      if ((localObject != null) && ((((IListFolder)localObject).getData() instanceof QMFolder)))
      {
        localObject = (QMFolder)((IListFolder)localObject).getData();
        localStringBuilder.append(((QMFolder)localObject).getName() + ",");
      }
      i += 1;
      continue;
      if (AppFolderListFragment.access$700(this.this$0) != null) {
        break label192;
      }
      localStringBuilder.append("app folder data null");
    }
    for (;;)
    {
      this.this$0.popBackStack();
      QMLog.log(4, "AppFolderListFragment", localStringBuilder.toString());
      AppFolderListFragment.access$200(this.this$0).setFolderInfo(AppFolderListFragment.access$700(this.this$0), 3);
      AppFolderListFragment.access$200(this.this$0).notifyDataSetChanged();
      return;
      label192:
      localStringBuilder.append("app folder data empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.AppFolderListFragment.4
 * JD-Core Version:    0.7.0.1
 */