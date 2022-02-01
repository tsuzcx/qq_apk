package com.tencent.qqmail.folderlist;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.qqmail.utilities.log.QMLog;

class FolderListFragment$21
  implements AdapterView.OnItemLongClickListener
{
  FolderListFragment$21(FolderListFragment paramFolderListFragment) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    QMLog.log(4, "FolderListFragment", "onLongClick enterEditMode");
    FolderListFragment.access$4300(this.this$0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.21
 * JD-Core Version:    0.7.0.1
 */