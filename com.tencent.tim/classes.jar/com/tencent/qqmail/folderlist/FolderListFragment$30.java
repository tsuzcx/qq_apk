package com.tencent.qqmail.folderlist;

import com.mobeta.android.dslv.DragSortListView;
import com.tencent.qqmail.folderlist.adapter.QMFolderListAdapter;
import com.tencent.qqmail.folderlist.adapter.QMFolderListDragAdapter;
import com.tencent.qqmail.folderlist.model.IListFolder;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import java.util.List;

class FolderListFragment$30
  implements Runnable
{
  FolderListFragment$30(FolderListFragment paramFolderListFragment) {}
  
  public void run()
  {
    Object localObject1;
    Object localObject2;
    int i;
    if ((FolderListFragment.access$500(this.this$0) != null) && (FolderListFragment.access$500(this.this$0).size() != 0))
    {
      localObject1 = this.this$0;
      localObject2 = FolderListFragment.access$500(this.this$0);
      boolean bool;
      if (FolderListFragment.access$700(this.this$0) > 1)
      {
        bool = true;
        FolderListFragment.access$4702((FolderListFragment)localObject1, FolderListItemHelper.createFolderItem((List)localObject2, bool, FolderListFragment.access$4800(this.this$0), FolderListFragment.access$2000(this.this$0)));
        localObject1 = new StringBuilder();
        if ((FolderListFragment.access$4700(this.this$0) == null) || (FolderListFragment.access$4700(this.this$0).size() <= 0)) {
          break label264;
        }
        i = 0;
        label112:
        if (i >= FolderListFragment.access$4700(this.this$0).size()) {
          break label281;
        }
        localObject2 = (IListFolder)FolderListFragment.access$4700(this.this$0).get(i);
        if ((localObject2 != null) && ((((IListFolder)localObject2).getData() instanceof QMFolder)))
        {
          QMFolder localQMFolder = (QMFolder)((IListFolder)localObject2).getData();
          if (localQMFolder.getCliUnreadCount() <= 0) {
            break label233;
          }
          ((StringBuilder)localObject1).append(((IListFolder)localObject2).getName() + "(" + localQMFolder.getCliUnreadCount() + "),");
        }
      }
      for (;;)
      {
        i += 1;
        break label112;
        bool = false;
        break;
        label233:
        ((StringBuilder)localObject1).append(((IListFolder)localObject2).getName() + ",");
      }
      label264:
      if (FolderListFragment.access$4700(this.this$0) != null) {
        break label464;
      }
      ((StringBuilder)localObject1).append("folder data null");
      label281:
      QMLog.log(4, "FolderListFragment", ((StringBuilder)localObject1).toString());
      if (!FolderListFragment.access$4800(this.this$0)) {
        break label474;
      }
      localObject1 = FolderListFragment.access$3400(this.this$0);
      label309:
      FolderListFragment.access$5800(this.this$0);
      FolderListFragment.access$3400(this.this$0).setFolderInfo(FolderListFragment.access$4700(this.this$0), 1);
      FolderListFragment.access$800(this.this$0).setFolderInfo(FolderListFragment.access$4700(this.this$0), 1);
      ((QMFolderListAdapter)localObject1).notifyDataSetChanged();
      if (FolderListFragment.access$5900(this.this$0) != 0) {
        i = ((QMFolderListAdapter)localObject1).getCount() - 1;
      }
    }
    for (;;)
    {
      if (i >= 0)
      {
        localObject2 = (QMFolder)((QMFolderListAdapter)localObject1).getItem(i).getData();
        if ((localObject2 == null) || (((QMFolder)localObject2).getId() != FolderListFragment.access$5900(this.this$0))) {
          break label522;
        }
        if (!FolderListFragment.access$4800(this.this$0)) {
          break label485;
        }
        FolderListFragment.access$3000(this.this$0).setSelectionFromTop(FolderListFragment.access$3000(this.this$0).getHeaderViewsCount() + i, FolderListFragment.access$3000(this.this$0).getMeasuredHeight() / 2);
      }
      for (;;)
      {
        FolderListFragment.access$5902(this.this$0, 0);
        return;
        label464:
        ((StringBuilder)localObject1).append("folder data empty");
        break;
        label474:
        localObject1 = FolderListFragment.access$800(this.this$0);
        break label309;
        label485:
        FolderListFragment.access$000(this.this$0).setSelectionFromTop(FolderListFragment.access$000(this.this$0).getHeaderViewsCount() + i, FolderListFragment.access$000(this.this$0).getMeasuredHeight() / 2);
      }
      label522:
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.30
 * JD-Core Version:    0.7.0.1
 */