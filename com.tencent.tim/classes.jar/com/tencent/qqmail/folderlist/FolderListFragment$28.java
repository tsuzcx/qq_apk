package com.tencent.qqmail.folderlist;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.movemail.ManageFolderActivity;
import com.tencent.qqmail.view.FolderLockDialog;
import java.util.ArrayList;

class FolderListFragment$28
  implements View.OnClickListener
{
  FolderListFragment$28(FolderListFragment paramFolderListFragment) {}
  
  public void onClick(View paramView)
  {
    FolderListFragment.access$3500(this.this$0);
    ArrayList localArrayList;
    if (FolderListFragment.access$4800(this.this$0))
    {
      localArrayList = QMFolderManager.sharedInstance().getFoldersByAccountAndTypes(FolderListFragment.access$200(this.this$0), new int[] { 12, 13, 14, 0 });
      if (localArrayList.size() == 0) {
        this.this$0.startActivityForResult(ManageFolderActivity.createIntent(FolderListFragment.access$200(this.this$0), null, false, false), 0);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = ((QMFolder)localArrayList.get(0)).getId();
      if (FolderLockDialog.isFolderLock(i))
      {
        if (FolderListFragment.access$100(this.this$0) != null) {
          FolderListFragment.access$100(this.this$0).dismissTips();
        }
        FolderListFragment.access$102(this.this$0, new FolderLockDialog(this.this$0.getActivity(), i, FolderListFragment.access$200(this.this$0), new FolderListFragment.28.1(this)));
        FolderListFragment.access$100(this.this$0).createDialog(1);
        FolderListFragment.access$100(this.this$0).showDialog();
      }
      else
      {
        this.this$0.startActivityForResult(ManageFolderActivity.createIntent(FolderListFragment.access$200(this.this$0), null, false, false), 0);
        continue;
        this.this$0.onButtonBackClick();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.28
 * JD-Core Version:    0.7.0.1
 */