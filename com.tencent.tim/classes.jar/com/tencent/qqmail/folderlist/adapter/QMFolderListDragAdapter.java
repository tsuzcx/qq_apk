package com.tencent.qqmail.folderlist.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobeta.android.dslv.DragSortListView.DragListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.folderlist.FolderDataManager;
import com.tencent.qqmail.folderlist.FolderListItemHelper;
import com.tencent.qqmail.folderlist.model.FolderData;
import com.tencent.qqmail.folderlist.model.IListFolder;
import com.tencent.qqmail.folderlist.model.IListItem.ItemType;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.ui.HorizontalScrollItemView;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.view.keeppressed.KeepPressedRelativeLayout;
import java.util.ArrayList;
import java.util.List;

public class QMFolderListDragAdapter
  extends QMFolderListAdapter
  implements DragSortListView.DragListener
{
  public static final String TAG = QMFolderListAdapter.class.getSimpleName();
  private boolean isFolderDroped = false;
  private ArrayList<QMFolder> mAllRealFolders;
  private ArrayList<FolderData> mAllUniversalFolders;
  
  public QMFolderListDragAdapter(Context paramContext, int paramInt, List<IListFolder> paramList)
  {
    super(paramContext, paramInt, paramList);
  }
  
  public static void reorderAllRealFolders(ArrayList<QMFolder> paramArrayList, QMFolder paramQMFolder1, QMFolder paramQMFolder2)
  {
    int i = 0;
    int k = -1;
    int j = -1;
    if (i < paramArrayList.size())
    {
      QMFolder localQMFolder = (QMFolder)paramArrayList.get(i);
      int m;
      if (localQMFolder.getId() == paramQMFolder1.getId()) {
        m = i;
      }
      for (;;)
      {
        i += 1;
        j = m;
        break;
        m = j;
        if (localQMFolder.getId() == paramQMFolder2.getId())
        {
          k = i;
          m = j;
        }
      }
    }
    if ((j != -1) && (k != -1))
    {
      paramArrayList.remove(j);
      paramArrayList.add(k, paramQMFolder1);
    }
  }
  
  private void reorderAllUniversalFolders(QMFolder paramQMFolder1, QMFolder paramQMFolder2)
  {
    paramQMFolder1 = FolderDataManager.sharedInstance().getFolderDataByFolderId(paramQMFolder1.getId());
    paramQMFolder2 = FolderDataManager.sharedInstance().getFolderDataByFolderId(paramQMFolder2.getId());
    if ((paramQMFolder1 != null) && (paramQMFolder2 != null))
    {
      int i = paramQMFolder1.getSequence();
      int j = paramQMFolder2.getSequence();
      this.mAllUniversalFolders.remove(i);
      this.mAllUniversalFolders.add(j, paramQMFolder1);
    }
  }
  
  public void drop(int paramInt1, int paramInt2)
  {
    int k;
    Object localObject1;
    label102:
    Object localObject2;
    if (paramInt1 != paramInt2)
    {
      k = -1;
      int j = -1;
      int i = 0;
      if (i < this.mData.size())
      {
        localObject1 = (IListFolder)this.mData.get(i);
        int m = k;
        int n = j;
        if (((IListFolder)localObject1).getType() == IListItem.ItemType.SECTION)
        {
          if (!((IListFolder)localObject1).getSectionName().equals(this.mContext.getString(2131690444))) {
            break label102;
          }
          n = i;
          m = k;
        }
        for (;;)
        {
          i += 1;
          k = m;
          j = n;
          break;
          m = k;
          n = j;
          if (((IListFolder)localObject1).getSectionName().equals(this.mContext.getString(2131693951)))
          {
            m = i;
            n = j;
          }
        }
      }
      localObject1 = (IListFolder)this.mData.get(paramInt2);
      localObject2 = (IListFolder)this.mData.remove(paramInt1);
      this.mData.add(paramInt2, localObject2);
      localObject2 = (QMFolder)((IListFolder)localObject2).getData();
      localObject1 = (QMFolder)((IListFolder)localObject1).getData();
      if ((localObject2 != null) && (localObject1 != null))
      {
        if ((paramInt1 >= j) || (paramInt2 >= j)) {
          break label242;
        }
        reorderAllUniversalFolders((QMFolder)localObject2, (QMFolder)localObject1);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      this.isFolderDroped = true;
      return;
      label242:
      if ((paramInt1 > k) && (paramInt2 > k)) {
        reorderAllRealFolders(this.mAllRealFolders, (QMFolder)localObject2, (QMFolder)localObject1);
      }
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    IListFolder localIListFolder = getItem(paramInt);
    QMFolderListAdapter.ViewHolder localViewHolder = (QMFolderListAdapter.ViewHolder)paramView.getTag();
    int i = getItemViewType(paramInt);
    if (i == IListItem.ItemType.SECTION.ordinal()) {}
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      ((KeepPressedRelativeLayout)((HorizontalScrollItemView)paramView).getContentView()).setNeedPostPress(false);
      if (i != IListItem.ItemType.BTN.ordinal()) {
        break;
      }
      localViewHolder.checkbox.setVisibility(4);
      localViewHolder.handler.setVisibility(8);
      localViewHolder.arrow.setVisibility(8);
    }
    int j = ((QMFolder)localIListFolder.getData()).getType();
    if (((i == IListItem.ItemType.BOTTOM.ordinal()) || (i == IListItem.ItemType.SINGLE.ordinal())) && (paramInt != getCount() - 1)) {
      if (FolderListItemHelper.folderTypeIsEditable(j))
      {
        QMUIHelper.setBackgroundResource(paramView, 2130845612);
        label175:
        if (!localIListFolder.shouldDrawCheckbox()) {
          break label318;
        }
        if (localViewHolder.checkbox != null)
        {
          localViewHolder.checkbox.setVisibility(0);
          localViewHolder.checkbox.setChecked(localIListFolder.shouldShow());
        }
        label213:
        localViewHolder.arrow.setVisibility(8);
        if (localViewHolder.handler != null)
        {
          if (!isEnabled(paramInt)) {
            break label339;
          }
          localViewHolder.handler.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      localViewHolder.unread.setVisibility(8);
      break;
      QMUIHelper.setBackground(paramView, new ColorDrawable(this.mContext.getResources().getColor(2131166586)));
      break label175;
      if (FolderListItemHelper.folderTypeIsEditable(j))
      {
        QMUIHelper.setBackgroundResource(paramView, 2130845612);
        break label175;
      }
      QMUIHelper.setBackgroundResource(paramView, 2131166586);
      break label175;
      label318:
      if (localViewHolder.checkbox == null) {
        break label213;
      }
      localViewHolder.checkbox.setVisibility(8);
      break label213;
      label339:
      localViewHolder.handler.setVisibility(8);
    }
  }
  
  public boolean isEnabled(int paramInt)
  {
    IListFolder localIListFolder = getItem(paramInt);
    if (localIListFolder.getType() == IListItem.ItemType.SECTION) {
      return false;
    }
    return (localIListFolder.getData() == null) || (((QMFolder)localIListFolder.getData()).getType() != 140);
  }
  
  public boolean isFolderDroped()
  {
    return this.isFolderDroped;
  }
  
  public void setAllRealFolders(ArrayList<QMFolder> paramArrayList)
  {
    this.mAllRealFolders = paramArrayList;
  }
  
  public void setAllUniversalFolders(ArrayList<FolderData> paramArrayList)
  {
    this.mAllUniversalFolders = paramArrayList;
  }
  
  public void setFolderDroped(boolean paramBoolean)
  {
    this.isFolderDroped = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.adapter.QMFolderListDragAdapter
 * JD-Core Version:    0.7.0.1
 */