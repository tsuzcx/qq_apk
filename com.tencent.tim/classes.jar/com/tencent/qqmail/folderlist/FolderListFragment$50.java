package com.tencent.qqmail.folderlist;

import android.widget.PopupWindow;
import java.util.List;

class FolderListFragment$50
  implements Runnable
{
  FolderListFragment$50(FolderListFragment paramFolderListFragment) {}
  
  public void run()
  {
    Object localObject = FolderHasNewHelper.getInstance().getQMFoldersFromFolderList(FolderListFragment.access$4700(this.this$0));
    localObject = FolderHasNewHelper.getInstance().getHasNewFolderOutOfSight(FolderListFragment.access$000(this.this$0), (List)localObject);
    if ((localObject != null) && (((FolderHasNewHelper.OutOfSightHasNewHint)localObject).needToShow()))
    {
      if (FolderListFragment.access$8200(this.this$0) != null) {
        break label94;
      }
      FolderListFragment.access$8202(this.this$0, FolderHasNewHelper.getInstance().initOutOfSightHasNewPopUpWindow(true, FolderListFragment.access$000(this.this$0), (FolderHasNewHelper.OutOfSightHasNewHint)localObject));
      FolderHasNewHelper.getInstance().show(FolderListFragment.access$8200(this.this$0), FolderListFragment.access$8300(this.this$0));
    }
    label94:
    do
    {
      return;
      FolderHasNewHelper.getInstance().updateHasNewPopupWindowText(true, FolderListFragment.access$8200(this.this$0), (FolderHasNewHelper.OutOfSightHasNewHint)localObject);
    } while (FolderListFragment.access$8200(this.this$0).isShowing());
    FolderHasNewHelper.getInstance().show(FolderListFragment.access$8200(this.this$0), FolderListFragment.access$8400(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.50
 * JD-Core Version:    0.7.0.1
 */