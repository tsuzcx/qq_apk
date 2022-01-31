package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import fip;

public class PinnedHeaderExpandableListView
  extends XExpandableListView
  implements AbsListView.OnScrollListener
{
  private static final int jdField_a_of_type_Int = -1;
  private static final int b = 0;
  private static final int g = 1;
  private Context jdField_a_of_type_AndroidContentContext = null;
  private View jdField_a_of_type_AndroidViewView = null;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = null;
  private ExpandableListView.OnGroupClickListener jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupClickListener = null;
  private PinnedHeaderExpandableListView.ExpandableListAdapter jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter = null;
  private PinnedHeaderExpandableListView.OnLayoutListener jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$OnLayoutListener = null;
  private boolean jdField_a_of_type_Boolean = false;
  private int h = 0;
  private int i = 0;
  
  public PinnedHeaderExpandableListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public PinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public PinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    super.setOnScrollListener(this);
  }
  
  private void c(View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = 0;
      while (j < localViewGroup.getChildCount())
      {
        c(localViewGroup.getChildAt(j));
        j += 1;
      }
    }
    paramView.refreshDrawableState();
  }
  
  private void g(int paramInt)
  {
    int j = b(b(paramInt));
    if (j != 2)
    {
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter.a(this.jdField_a_of_type_AndroidViewView, c(b(paramInt)));
      if (j == 0) {
        if ((b(b(paramInt + 1)) == 0) || (b(b(paramInt + 1)) == 2))
        {
          this.h = -1;
          if (this.h == -1) {
            break label275;
          }
          if (this.h != 1) {
            break label267;
          }
          View localView = getChildAt(1);
          j = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
          if (localView == null) {
            break label262;
          }
          paramInt = localView.getTop();
        }
      }
    }
    label108:
    for (this.i = (j - paramInt);; this.i = 0)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramInt = View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), 1073741824);
      j = View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_AndroidViewView.getMeasuredHeight(), 1073741824);
      this.jdField_a_of_type_AndroidViewView.measure(paramInt, j);
      this.jdField_a_of_type_AndroidViewView.layout(0, -this.i, this.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), this.jdField_a_of_type_AndroidViewView.getMeasuredHeight() - this.i);
      return;
      this.h = 0;
      break;
      if (getChildAt(0).getBottom() > this.jdField_a_of_type_AndroidViewView.getMeasuredHeight())
      {
        this.h = 0;
        break;
      }
      if (b(b(paramInt + 1)) == 0)
      {
        this.h = 1;
        break;
      }
      this.h = 0;
      break;
      this.h = -1;
      break;
      paramInt = 0;
      break label108;
    }
    label262:
    label267:
    label275:
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      g(paramInt1);
    }
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public View d()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
      drawChild(paramCanvas, this.jdField_a_of_type_AndroidViewView, getDrawingTime());
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.dispatchTouchEvent(paramMotionEvent))) {}
      for (boolean bool = true;; bool = false)
      {
        if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
          this.jdField_a_of_type_Boolean = false;
        }
        return bool;
      }
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (f1 >= 0.0F) && (f1 <= this.jdField_a_of_type_AndroidViewView.getMeasuredWidth()) && (f2 >= 0.0F) && (f2 <= this.jdField_a_of_type_AndroidViewView.getMeasuredHeight() - this.i) && (paramMotionEvent.getAction() == 0) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_a_of_type_AndroidViewView.dispatchTouchEvent(paramMotionEvent)))
    {
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.jdField_a_of_type_AndroidViewView != null) {
      c(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      g(q());
    }
    if (this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$OnLayoutListener != null) {
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$OnLayoutListener.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      measureChild(this.jdField_a_of_type_AndroidViewView, paramInt1, paramInt2);
    }
  }
  
  public void setAdapter(ExpandableListAdapter paramExpandableListAdapter)
  {
    super.setAdapter(paramExpandableListAdapter);
    if ((paramExpandableListAdapter instanceof PinnedHeaderExpandableListView.ExpandableListAdapter))
    {
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter = ((PinnedHeaderExpandableListView.ExpandableListAdapter)paramExpandableListAdapter);
      int j = this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter.a();
      if (j != 0)
      {
        this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(j, this, false);
        if (this.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new fip(this));
        }
        requestLayout();
      }
    }
  }
  
  public void setOnGroupClickListener(ExpandableListView.OnGroupClickListener paramOnGroupClickListener)
  {
    this.jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupClickListener = paramOnGroupClickListener;
    super.setOnGroupClickListener(paramOnGroupClickListener);
  }
  
  public void setOnLayoutListener(PinnedHeaderExpandableListView.OnLayoutListener paramOnLayoutListener)
  {
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$OnLayoutListener = paramOnLayoutListener;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.widget.PinnedHeaderExpandableListView
 * JD-Core Version:    0.7.0.1
 */