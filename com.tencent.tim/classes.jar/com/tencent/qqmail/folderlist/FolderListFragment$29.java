package com.tencent.qqmail.folderlist;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.folderlist.adapter.QMFolderListAdapter;
import com.tencent.qqmail.folderlist.model.IListFolder;
import com.tencent.qqmail.maillist.ListViewHelper;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class FolderListFragment$29
  implements View.OnClickListener
{
  FolderListFragment$29(FolderListFragment paramFolderListFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = FolderListFragment.access$800(this.this$0).getData();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      QMFolder localQMFolder = (QMFolder)((IListFolder)((Iterator)localObject).next()).getData();
      if (QMFolderManager.sharedInstance().getDisplayUnreadCount(localQMFolder) > 0) {
        localArrayList.add(Integer.valueOf(i));
      }
      i += 1;
    }
    ListViewHelper.getNextUnread(FolderListFragment.access$000(this.this$0), localArrayList, new FolderListFragment.29.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.29
 * JD-Core Version:    0.7.0.1
 */