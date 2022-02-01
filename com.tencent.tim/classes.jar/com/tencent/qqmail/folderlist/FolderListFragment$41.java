package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.folderlist.adapter.QMFolderListAdapter;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import java.util.List;

class FolderListFragment$41
  implements Runnable
{
  FolderListFragment$41(FolderListFragment paramFolderListFragment) {}
  
  public void run()
  {
    int i = FolderListFragment.access$6700(this.this$0, FolderListFragment.access$800(this.this$0).getData().size() - 1);
    FolderListFragment.access$6800(this.this$0, i + 1);
    FolderListFragment.access$000(this.this$0).expandAndFoldItemAtPosition(i + 1, 190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.41
 * JD-Core Version:    0.7.0.1
 */