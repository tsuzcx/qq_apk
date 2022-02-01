package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import auus;

public class PinnedFooterExpandableListView
  extends XExpandableListView
  implements AbsListView.e
{
  private View Lu;
  private a jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView$a;
  b jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView$b = null;
  PinnedHeaderExpandableListView.a jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$a = null;
  int aVz;
  int aWT;
  boolean dkJ;
  private boolean dkK;
  private boolean dkL;
  public int eue = -1;
  Context mContext = null;
  public View mHeaderView = null;
  AbsListView.e mOnScrollListener = null;
  
  public PinnedFooterExpandableListView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public PinnedFooterExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public PinnedFooterExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private View a(View paramView, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (!(paramView instanceof ViewGroup)) {
      localObject = paramView;
    }
    label58:
    label89:
    label101:
    for (;;)
    {
      return localObject;
      localObject = (ViewGroup)paramView;
      int k = ((ViewGroup)localObject).getChildCount();
      boolean bool = isChildrenDrawingOrderEnabled();
      int i = k - 1;
      int j;
      if (i >= 0) {
        if (bool)
        {
          j = getChildDrawingOrder(k, i);
          paramView = ((ViewGroup)localObject).getChildAt(j);
          if (!b(paramView, paramInt1, paramInt2)) {
            break label89;
          }
        }
      }
      for (;;)
      {
        if (paramView == null) {
          break label101;
        }
        return paramView;
        j = i;
        break label58;
        i -= 1;
        break;
        paramView = null;
      }
    }
  }
  
  private boolean b(View paramView, int paramInt1, int paramInt2)
  {
    return (paramView.isClickable()) && (paramInt2 >= paramView.getTop()) && (paramInt2 <= paramView.getBottom()) && (paramInt1 >= paramView.getLeft()) && (paramInt1 <= paramView.getRight());
  }
  
  private void exj()
  {
    Object localObject = getExpandableListAdapter();
    if (!(localObject instanceof PinnedHeaderExpandableListView.a)) {
      return;
    }
    localObject = (PinnedHeaderExpandableListView.a)localObject;
    int i2 = getFirstVisiblePosition();
    int k = getLastVisiblePosition();
    int i3 = getPackedPositionGroup(getExpandableListPosition(k));
    int n = this.mHeaderView.getMeasuredHeight();
    int i1 = getHeight();
    int i4 = i1 - n;
    int j = k - 2;
    int m = k - 1;
    int i5 = getPackedPositionGroup(getExpandableListPosition(j));
    int i;
    if (i3 == ((PinnedHeaderExpandableListView.a)localObject).getGroupCount() - 1)
    {
      i = 1;
      label98:
      if ((j < 0) || (i5 == i3)) {
        break label425;
      }
      if (getPackedPositionGroup(getExpandableListPosition(m)) != i3) {
        break label521;
      }
    }
    label521:
    for (j = m;; j = k)
    {
      localObject = getChildAt(j - i2);
      if ((localObject != null) && (i1 - ((View)localObject).getTop() >= n))
      {
        j = i3 + 1;
        if ((this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$a != null) && (j < this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$a.getGroupCount()))
        {
          this.eue = j;
          this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$a.j(this.mHeaderView, j);
        }
        k = ((View)localObject).getTop() + n;
        j = k;
        if (k < i1 - n) {
          j = i1 - n;
        }
        if (i != 0)
        {
          this.eue = -1;
          this.mHeaderView.layout(0, -n, this.aWT, -n);
          return;
          i = 0;
          break label98;
        }
        this.mHeaderView.layout(0, j, this.aWT, j + n);
        return;
      }
      if ((this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$a != null) && (i3 < this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$a.getGroupCount()))
      {
        this.eue = i3;
        this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$a.j(this.mHeaderView, i3);
      }
      if ((i != 0) && (j != k))
      {
        this.eue = -1;
        this.mHeaderView.layout(0, -n, this.aWT, -this.aVz);
        return;
      }
      if (getPackedPositionType(getExpandableListPosition(m)) == 0)
      {
        setFooterEnable(false);
        if (this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView$a != null) {
          this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView$a.czW();
        }
        this.eue = -1;
        this.mHeaderView.layout(0, -n, this.aWT, -this.aVz);
        return;
      }
      this.mHeaderView.layout(0, i4, this.aWT, this.aVz + i4);
      return;
      label425:
      if (i != 0)
      {
        this.eue = -1;
        this.mHeaderView.layout(0, -this.aVz, this.aWT, -this.aVz);
      }
      for (;;)
      {
        i = i3 + 1;
        if ((this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$a == null) || (i >= this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$a.getGroupCount())) {
          break;
        }
        this.eue = i;
        this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$a.j(this.mHeaderView, i);
        return;
        this.mHeaderView.layout(0, i4, this.aWT, this.aVz + i4);
      }
    }
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    super.setOnScrollListener(this);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.mHeaderView != null) && (this.mHeaderView.getVisibility() == 0)) {
      drawChild(paramCanvas, this.mHeaderView, getDrawingTime());
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = pointToPosition(i, j);
    if ((this.mHeaderView != null) && (this.mHeaderView.getVisibility() == 0) && (j >= this.mHeaderView.getTop()) && (j <= this.mHeaderView.getBottom()))
    {
      if (paramMotionEvent.getAction() == 0)
      {
        this.Lu = a(this.mHeaderView, i, j);
        this.dkK = true;
      }
      while (paramMotionEvent.getAction() != 1) {
        return true;
      }
      if ((a(this.mHeaderView, i, j) == this.Lu) && (this.Lu.isClickable()))
      {
        this.Lu.performClick();
        invalidate(new Rect(0, 0, this.aWT, this.aVz));
      }
      for (;;)
      {
        this.dkK = false;
        return true;
        if (this.dkL)
        {
          i = getPackedPositionGroup(getExpandableListPosition(k));
          if ((i != -1) && (this.dkK)) {
            if (isGroupExpanded(i)) {
              collapseGroup(i);
            } else {
              expandGroup(i);
            }
          }
        }
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.mHeaderView != null) {
      this.mHeaderView.refreshDrawableState();
    }
  }
  
  public void exi()
  {
    if (this.mHeaderView != null) {}
    int i;
    do
    {
      ExpandableListAdapter localExpandableListAdapter;
      do
      {
        do
        {
          return;
        } while (!this.dkJ);
        localExpandableListAdapter = getExpandableListAdapter();
      } while (!(localExpandableListAdapter instanceof PinnedHeaderExpandableListView.a));
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$a = ((PinnedHeaderExpandableListView.a)localExpandableListAdapter);
      i = this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$a.gj();
    } while (i == 0);
    this.mHeaderView = LayoutInflater.from(this.mContext).inflate(i, this, false);
    if (this.mHeaderView != null) {
      this.mHeaderView.setOnClickListener(new auus(this, this));
    }
    requestLayout();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView$b != null) {
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView$b.b(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.mHeaderView != null)
    {
      measureChild(this.mHeaderView, paramInt1, paramInt2);
      this.aWT = this.mHeaderView.getMeasuredWidth();
      this.aVz = this.mHeaderView.getMeasuredHeight();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mHeaderView != null) {
      exj();
    }
    if (this.mOnScrollListener != null) {
      this.mOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.mOnScrollListener != null) {
      this.mOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public void setAdapter(ExpandableListAdapter paramExpandableListAdapter)
  {
    super.setAdapter(paramExpandableListAdapter);
    exi();
  }
  
  public void setFooterEnable(boolean paramBoolean)
  {
    this.dkJ = paramBoolean;
    if (this.mHeaderView != null)
    {
      if (this.dkJ) {
        this.mHeaderView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.mHeaderView.setVisibility(8);
  }
  
  public void setListener(a parama)
  {
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView$a = parama;
  }
  
  public void setOnLayoutListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView$b = paramb;
  }
  
  public void setOnScrollListener(AbsListView.e parame)
  {
    this.mOnScrollListener = parame;
  }
  
  public static abstract interface a
  {
    public abstract void a(PinnedFooterExpandableListView paramPinnedFooterExpandableListView, View paramView, int paramInt);
    
    public abstract void czW();
  }
  
  public static abstract interface b
  {
    public abstract void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.PinnedFooterExpandableListView
 * JD-Core Version:    0.7.0.1
 */