package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.XListView;
import java.util.LinkedList;

public class PinnedDividerListView
  extends XListView
  implements AbsListView.e
{
  private View JC;
  private a jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$a;
  private b jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$b;
  private LinkedList<View> as = new LinkedList();
  private int ehp = 0;
  private int ehq;
  private Context mContext;
  private AbsListView.e mOnScrollListener;
  
  public PinnedDividerListView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public PinnedDividerListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public PinnedDividerListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    super.setOnScrollListener(this);
  }
  
  protected a a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$a;
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
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.JC != null) && (this.JC.getVisibility() == 0)) {
      drawChild(paramCanvas, this.JC, getDrawingTime());
    }
  }
  
  @SuppressLint({"WrongCall"})
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    int i;
    if (this.JC != null)
    {
      i = getFirstVisiblePosition() - this.as.size();
      if ((i < 0) || (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$a.f(this.JC, i))) {
        break label161;
      }
      this.JC.setVisibility(0);
      this.JC.layout(0, -this.ehq, this.JC.getMeasuredWidth(), this.JC.getMeasuredHeight() - this.ehq);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$a.b(this.JC, i);
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
      label161:
      this.JC.setVisibility(4);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$b != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$b.b(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
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
      if ((paramInt1 < this.as.size()) || (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$a.f(this.JC, paramInt1 - this.as.size()))) {
        break label359;
      }
      i = paramInt1 - this.as.size();
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$a.b(this.JC, i);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$a.t(i))
      {
        this.ehp = 0;
        paramInt1 = 1;
        j = getChildCount();
        if (paramInt1 != 0)
        {
          localView = getChildAt(0);
          if ((localView != null) && (localView.getVisibility() != 4)) {
            localView.setVisibility(4);
          }
        }
        if (paramInt1 == 0) {
          break label235;
        }
        paramInt1 = 1;
      }
      for (;;)
      {
        if (paramInt1 >= j) {
          break label240;
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
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$a.t(i + 1))
        {
          this.ehp = 1;
          paramInt1 = 0;
          break;
        }
        this.ehp = 0;
        paramInt1 = 0;
        break;
        label235:
        paramInt1 = 0;
      }
      label240:
      if (this.ehp != 1) {
        break label351;
      }
      View localView = getChildAt(1);
      j = this.JC.getMeasuredHeight();
      if (localView == null) {
        break label346;
      }
      paramInt1 = localView.getTop();
      this.ehq = (j - paramInt1);
      label283:
      this.JC.setVisibility(0);
      this.JC.layout(0, -this.ehq, this.JC.getMeasuredWidth(), this.JC.getMeasuredHeight() - this.ehq);
    }
    for (;;)
    {
      if (this.mOnScrollListener != null) {
        this.mOnScrollListener.onScroll(paramAbsListView, i, paramInt2, paramInt3);
      }
      return;
      label346:
      paramInt1 = 0;
      break;
      label351:
      this.ehq = 0;
      break label283;
      label359:
      this.ehp = -1;
      this.JC.setVisibility(4);
      j = this.as.size();
      i = paramInt1;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$a.getCount() > 0)
      {
        i = paramInt1;
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$a.t(0))
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$a = ((a)paramListAdapter);
      int i = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$a.ag();
      if (i != 0)
      {
        this.JC = LayoutInflater.from(this.mContext).inflate(i, this, false);
        requestLayout();
      }
      super.setAdapter(this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$a);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$a = null;
    super.setAdapter(paramListAdapter);
  }
  
  public void setOnLayoutListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$b = paramb;
  }
  
  public void setOnScrollListener(AbsListView.e parame)
  {
    this.mOnScrollListener = parame;
  }
  
  public static abstract class a
    extends BaseAdapter
  {
    public abstract int ag();
    
    public abstract void b(View paramView, int paramInt);
    
    public boolean f(View paramView, int paramInt)
    {
      return false;
    }
    
    public abstract boolean t(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PinnedDividerListView
 * JD-Core Version:    0.7.0.1
 */