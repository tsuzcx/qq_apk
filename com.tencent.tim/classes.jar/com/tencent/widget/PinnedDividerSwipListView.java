package com.tencent.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import auvp;
import com.tencent.mobileqq.widget.PinnedDividerListView.b;
import java.util.LinkedList;

public class PinnedDividerSwipListView
  extends SwipListView
  implements AbsListView.e
{
  private View JC;
  private PinnedDividerListView.b jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$b;
  private a jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView$a;
  private b jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView$b;
  private LinkedList<View> as = new LinkedList();
  private int ehp = 0;
  private int ehq;
  private Context mContext;
  private AbsListView.e mOnScrollListener;
  
  public PinnedDividerSwipListView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public PinnedDividerSwipListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public PinnedDividerSwipListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    super.setOnScrollListener(this);
  }
  
  public void addHeaderView(View paramView)
  {
    addHeaderView(paramView, null, false);
  }
  
  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    super.addHeaderView(paramView, paramObject, paramBoolean);
    this.as.add(paramView);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.JC != null) && (this.JC.getVisibility() == 0)) {
      drawChild(paramCanvas, this.JC, getDrawingTime());
    }
  }
  
  @SuppressLint({"WrongCall"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    int i;
    if (this.JC != null)
    {
      i = getFirstVisiblePosition() - this.as.size();
      if (i < 0) {
        break label145;
      }
      this.JC.setVisibility(0);
      this.JC.layout(0, -this.ehq, this.JC.getMeasuredWidth(), this.JC.getMeasuredHeight() - this.ehq);
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView$a.b(this.JC, i);
    }
    for (;;)
    {
      int j = getChildCount();
      i = this.as.size() + 1;
      while (i < j)
      {
        View localView = getChildAt(i);
        if (localView.getVisibility() != 0) {
          localView.setVisibility(0);
        }
        i += 1;
      }
      label145:
      this.JC.setVisibility(4);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$b != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$b.b(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.JC != null) {
      measureChild(this.JC, paramInt1, paramInt2);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    int j;
    if (this.JC != null)
    {
      if (paramInt1 < this.as.size()) {
        break label351;
      }
      i = paramInt1 - this.as.size();
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView$a.b(this.JC, i);
      if (this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView$a.t(i))
      {
        this.ehp = 0;
        paramInt1 = 1;
        j = getChildCount();
        if (paramInt1 != 0)
        {
          localView = getChildAt(0);
          if (localView.getVisibility() != 4) {
            localView.setVisibility(4);
          }
        }
        if (paramInt1 == 0) {
          break label207;
        }
        paramInt1 = 1;
      }
      for (;;)
      {
        if (paramInt1 >= j) {
          break label212;
        }
        localView = getChildAt(paramInt1);
        if (localView.getVisibility() != 0) {
          localView.setVisibility(0);
        }
        paramInt1 += 1;
        continue;
        localView = getChildAt(0);
        if ((localView != null) && (localView.getBottom() > this.JC.getMeasuredHeight()))
        {
          this.ehp = 0;
          paramInt1 = 0;
          break;
        }
        if (this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView$a.t(i + 1))
        {
          this.ehp = 1;
          paramInt1 = 0;
          break;
        }
        this.ehp = 0;
        paramInt1 = 0;
        break;
        label207:
        paramInt1 = 0;
      }
      label212:
      if (this.ehp != 1) {
        break label343;
      }
      View localView = getChildAt(1);
      j = this.JC.getMeasuredHeight();
      if (localView == null) {
        break label338;
      }
      paramInt1 = localView.getTop();
      this.ehq = (j - paramInt1);
      label255:
      this.JC.setVisibility(0);
      this.JC.layout(0, -this.ehq, this.JC.getMeasuredWidth(), this.JC.getMeasuredHeight() - this.ehq);
    }
    for (;;)
    {
      if (this.mOnScrollListener != null) {
        this.mOnScrollListener.onScroll(paramAbsListView, i, paramInt2, paramInt3);
      }
      if (this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView$b != null) {
        this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView$b.onScroll(paramAbsListView, i, paramInt2, paramInt3);
      }
      return;
      label338:
      paramInt1 = 0;
      break;
      label343:
      this.ehq = 0;
      break label255;
      label351:
      this.ehp = -1;
      this.JC.setVisibility(4);
      j = this.as.size();
      i = paramInt1;
      if (this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView$a.getCount() > 0)
      {
        i = paramInt1;
        if (this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView$a.t(0))
        {
          i = paramInt1;
          if (j >= paramInt1)
          {
            i = paramInt1;
            if (j < paramInt1 + paramInt2)
            {
              getChildAt(j - paramInt1).setVisibility(0);
              i = paramInt1;
            }
          }
        }
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.mOnScrollListener != null) {
      this.mOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
    if (this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView$b != null) {
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView$b.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public boolean removeHeaderView(View paramView)
  {
    boolean bool = super.removeHeaderView(paramView);
    if (bool) {
      this.as.remove(paramView);
    }
    return bool;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if ((paramListAdapter instanceof a))
    {
      this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView$a = ((a)paramListAdapter);
      int i = this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView$a.ag();
      if (i != 0)
      {
        this.JC = LayoutInflater.from(this.mContext).inflate(i, this, false);
        requestLayout();
      }
      super.setAdapter(this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView$a);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView$a = null;
    super.setAdapter(paramListAdapter);
  }
  
  public void setOnLayoutListener(PinnedDividerListView.b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$b = paramb;
  }
  
  public void setOnScrollListener(AbsListView.e parame)
  {
    this.mOnScrollListener = parame;
  }
  
  public void setOnScrollListenerAdapter(b paramb)
  {
    this.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView$b = paramb;
  }
  
  public static abstract class a
    extends auvp
  {
    public abstract int ag();
    
    public abstract void b(View paramView, int paramInt);
    
    public abstract boolean t(int paramInt);
  }
  
  public static class b
    implements AbsListView.e
  {
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.PinnedDividerSwipListView
 * JD-Core Version:    0.7.0.1
 */