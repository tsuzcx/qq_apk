package com.tencent.qqmail.folderlist;

import java.util.List;

class FolderListFragment$5$1
  implements Runnable
{
  FolderListFragment$5$1(FolderListFragment.5 param5) {}
  
  public void run()
  {
    if ((FolderListFragment.access$500(this.this$1.this$0) == null) || (FolderListFragment.access$500(this.this$1.this$0).size() <= 0))
    {
      FolderListFragment.access$1600(this.this$1.this$0);
      return;
    }
    this.this$1.this$0.render(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.5.1
 * JD-Core Version:    0.7.0.1
 */