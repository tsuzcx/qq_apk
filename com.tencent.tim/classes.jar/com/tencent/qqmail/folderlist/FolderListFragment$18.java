package com.tencent.qqmail.folderlist;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;

class FolderListFragment$18
  implements View.OnClickListener
{
  FolderListFragment$18(FolderListFragment paramFolderListFragment) {}
  
  public void onClick(View paramView)
  {
    FolderListFragment.access$000(this.this$0).scrollTo(0, 0);
    FolderListFragment.access$000(this.this$0).post(new FolderListFragment.18.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.18
 * JD-Core Version:    0.7.0.1
 */