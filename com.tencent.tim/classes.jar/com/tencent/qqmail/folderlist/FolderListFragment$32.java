package com.tencent.qqmail.folderlist;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.mail.QMMailManager;

class FolderListFragment$32
  implements View.OnClickListener
{
  FolderListFragment$32(FolderListFragment paramFolderListFragment) {}
  
  public void onClick(View paramView)
  {
    FolderListFragment.access$2100(this.this$0);
    QMMailManager.sharedInstance().initSync(FolderListFragment.access$2000(this.this$0));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.32
 * JD-Core Version:    0.7.0.1
 */