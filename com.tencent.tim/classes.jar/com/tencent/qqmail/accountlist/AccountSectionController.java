package com.tencent.qqmail.accountlist;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.mobeta.android.dslv.DragSortController;
import com.mobeta.android.dslv.DragSortListView;
import com.tencent.qqmail.accountlist.adapter.AccountListDragAdapter;

public class AccountSectionController
  extends DragSortController
{
  private AccountListDragAdapter mAdapter;
  private int mBottomPos;
  private DragSortListView mList;
  private int mTopDivPos;
  
  public AccountSectionController(DragSortListView paramDragSortListView, AccountListDragAdapter paramAccountListDragAdapter)
  {
    super(paramDragSortListView, 2131367366, 2, 0);
    this.mList = paramDragSortListView;
    this.mAdapter = paramAccountListDragAdapter;
  }
  
  private boolean isInHandlerSection(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public View onCreateFloatView(int paramInt)
  {
    View localView = this.mAdapter.getView(paramInt, null, this.mList);
    this.mTopDivPos = this.mAdapter.getTopDivPos(paramInt);
    this.mBottomPos = this.mAdapter.getBottomPos(paramInt);
    return localView;
  }
  
  public void onDestroyFloatView(View paramView) {}
  
  public void onDragFloatView(View paramView, Point paramPoint1, Point paramPoint2)
  {
    int i = this.mList.getFirstVisiblePosition();
    int j = this.mList.getDividerHeight();
    int k = this.mList.getHeaderViewsCount();
    paramPoint2 = this.mList.getChildAt(this.mTopDivPos - i + k);
    View localView = this.mList.getChildAt(this.mBottomPos - i + k);
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
        j = this.mList.getHeaderViewsCount();
      } while (!this.mAdapter.isEnabled(i - j));
      j = this.mList.getWidth();
    } while (!isInHandlerSection((int)paramMotionEvent.getX(), j));
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.AccountSectionController
 * JD-Core Version:    0.7.0.1
 */