package com.tencent.qqmail.folderlist;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import com.mobeta.android.dslv.DragSortListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.folderlist.adapter.QMFolderListDragAdapter;
import com.tencent.qqmail.folderlist.model.IListFolder;
import com.tencent.qqmail.folderlist.model.IListItem.ItemType;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.HashMap;
import java.util.List;

class FolderListFragment$17
  implements AdapterView.OnItemClickListener
{
  FolderListFragment$17(FolderListFragment paramFolderListFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool2 = false;
    IListFolder localIListFolder = (IListFolder)FolderListFragment.access$3000(this.this$0).getAdapter().getItem(paramInt);
    if (localIListFolder == null) {}
    QMFolder localQMFolder;
    do
    {
      do
      {
        do
        {
          EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
          return;
          localQMFolder = (QMFolder)localIListFolder.getData();
          if (localIListFolder.getType() == IListItem.ItemType.BTN)
          {
            FolderListFragment.access$3500(this.this$0);
            throw new IllegalStateException("btn not supported");
          }
        } while (localQMFolder == null);
        FolderListFragment.access$3600(this.this$0, localQMFolder);
      } while (localIListFolder.getType() != IListItem.ItemType.ITEM);
      localObject = FolderListFragment.access$3400(this.this$0).getShouldShowFoldersInTopArea();
    } while ((((List)localObject).size() == 1) && (((QMFolder)((IListFolder)((List)localObject).get(0)).getData()).getId() == localQMFolder.getId()));
    Object localObject = new StringBuilder().append("FolderList edit onclick folder: ").append(localIListFolder.getName()).append(" should show: ");
    boolean bool1;
    if (!localIListFolder.shouldShow())
    {
      bool1 = true;
      label193:
      QMLog.log(4, "FolderListFragment", bool1 + ", pos: " + paramInt);
      if (!FolderListFragment.access$3700(this.this$0).containsKey(Integer.valueOf(((QMFolder)localIListFolder.getData()).getId()))) {
        FolderListFragment.access$3700(this.this$0).put(Integer.valueOf(((QMFolder)localIListFolder.getData()).getId()), Boolean.valueOf(localIListFolder.shouldShow()));
      }
      bool1 = bool2;
      if (!localIListFolder.shouldShow()) {
        bool1 = true;
      }
      localIListFolder.setShouldShow(bool1);
      if (localQMFolder.getId() == -19)
      {
        if (!localIListFolder.shouldShow()) {
          break label377;
        }
        QMSettingManager.sharedInstance().setStarAttachDisplay(1);
        FolderListFragment.access$3808(this.this$0);
      }
      label333:
      if (localQMFolder.getId() == -3)
      {
        if (!localIListFolder.shouldShow()) {
          break label395;
        }
        QMSettingManager.sharedInstance().setAddrVipDisplay(1);
      }
    }
    for (;;)
    {
      FolderListFragment.access$3400(this.this$0).notifyDataSetChanged();
      break;
      bool1 = false;
      break label193;
      label377:
      QMSettingManager.sharedInstance().setStarAttachDisplay(2);
      FolderListFragment.access$3810(this.this$0);
      break label333;
      label395:
      QMSettingManager.sharedInstance().setAddrVipDisplay(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.17
 * JD-Core Version:    0.7.0.1
 */