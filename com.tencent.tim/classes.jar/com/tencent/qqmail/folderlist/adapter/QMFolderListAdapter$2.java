package com.tencent.qqmail.folderlist.adapter;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.qqmail.folderlist.model.IListItem.ItemType;
import com.tencent.qqmail.view.keeppressed.KeepPressedRelativeLayout;

class QMFolderListAdapter$2
  implements View.OnLayoutChangeListener
{
  QMFolderListAdapter$2(QMFolderListAdapter paramQMFolderListAdapter, int paramInt, KeepPressedRelativeLayout paramKeepPressedRelativeLayout, QMFolderListAdapter.ViewHolder paramViewHolder) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (paramInt3 - paramInt1 != paramInt7 - paramInt5)
    {
      if ((this.val$itemViewType == IListItem.ItemType.SINGLE.ordinal()) || (this.val$itemViewType == IListItem.ItemType.BOTTOM.ordinal())) {
        this.val$layout.updateDividerInsetLeft(0, 0);
      }
    }
    else {
      return;
    }
    this.val$layout.updateDividerInsetLeft(0, this.val$fHolder.getInsetLeft(this.this$0.mContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.adapter.QMFolderListAdapter.2
 * JD-Core Version:    0.7.0.1
 */