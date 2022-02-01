package com.tencent.qqmail.folderlist;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.mobeta.android.dslv.DragSortController;
import com.mobeta.android.dslv.DragSortListView;
import com.tencent.qqmail.folderlist.adapter.QMFolderListDragAdapter;
import com.tencent.qqmail.folderlist.model.IListFolder;
import com.tencent.qqmail.folderlist.model.IListItem.ItemType;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.DataCollector;

class FolderListFragment$16
  extends DragSortController
{
  private int mBottomPos;
  private int mTopDivPos;
  
  FolderListFragment$16(FolderListFragment paramFolderListFragment, DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramDragSortListView, paramInt1, paramInt2, paramInt3);
  }
  
  private boolean isInHandlerSection(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public View onCreateFloatView(int paramInt)
  {
    View localView = super.onCreateFloatView(paramInt);
    QMFolderListDragAdapter localQMFolderListDragAdapter = FolderListFragment.access$3400(this.this$0);
    Object localObject = localQMFolderListDragAdapter.getItem(paramInt);
    if (localObject != null)
    {
      localObject = (QMFolder)((IListFolder)localObject).getData();
      if (localObject != null)
      {
        if (((QMFolder)localObject).getType() != 14) {
          break label116;
        }
        DataCollector.logEvent("Event_Move_Tag");
      }
    }
    int i = 0;
    for (;;)
    {
      if ((i >= localQMFolderListDragAdapter.getCount()) || (localQMFolderListDragAdapter.getItem(i).getType() == IListItem.ItemType.SECTION))
      {
        this.mTopDivPos = FolderListFragment.access$3400(this.this$0).getTopDivPos(paramInt);
        this.mBottomPos = FolderListFragment.access$3400(this.this$0).getBottomPos(paramInt);
        return localView;
        label116:
        DataCollector.logEvent("Event_Move_Folder");
        break;
      }
      i += 1;
    }
  }
  
  public void onDragFloatView(View paramView, Point paramPoint1, Point paramPoint2)
  {
    int i = FolderListFragment.access$3000(this.this$0).getFirstVisiblePosition();
    int j = FolderListFragment.access$3000(this.this$0).getDividerHeight();
    int k = FolderListFragment.access$3000(this.this$0).getHeaderViewsCount();
    paramPoint2 = FolderListFragment.access$3000(this.this$0).getChildAt(this.mTopDivPos - i + k);
    View localView = FolderListFragment.access$3000(this.this$0).getChildAt(this.mBottomPos - i + k);
    if (paramPoint2 != null) {}
    for (i = paramPoint2.getBottom() + j;; i = -1)
    {
      if (localView != null) {}
      for (j = localView.getTop() - j - paramView.getHeight();; j = -1)
      {
        if ((this.mTopDivPos != -1) && (paramPoint2 != null) && (paramPoint1.y <= i)) {
          paramPoint1.y = i;
        }
        if ((this.mBottomPos != -1) && (localView != null) && (paramPoint1.y >= j)) {
          paramPoint1.y = j;
        }
        return;
      }
    }
  }
  
  public int startDragPosition(MotionEvent paramMotionEvent)
  {
    int i = super.dragHandleHitPosition(paramMotionEvent);
    if (i == -1) {}
    int j;
    do
    {
      do
      {
        return -1;
        j = FolderListFragment.access$3000(this.this$0).getHeaderViewsCount();
      } while (!FolderListFragment.access$3400(this.this$0).isEnabled(i - j));
      j = FolderListFragment.access$3000(this.this$0).getHeaderViewsCount();
    } while (!isInHandlerSection((int)paramMotionEvent.getX(), j));
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.16
 * JD-Core Version:    0.7.0.1
 */