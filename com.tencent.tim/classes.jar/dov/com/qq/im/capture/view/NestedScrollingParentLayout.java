package dov.com.qq.im.capture.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import axwo;
import axxc;
import axxd;
import com.tencent.qphone.base.util.QLog;

public class NestedScrollingParentLayout
  extends FrameLayout
{
  private int Kd = -1;
  private RecyclerView Q;
  private RecyclerView R;
  private RecyclerView S;
  private axwo b;
  private RecyclerView.OnScrollListener jdField_c_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new axxc(this);
  private axwo jdField_c_of_type_Axwo;
  private RecyclerView.OnScrollListener d = new axxd(this);
  private double dw;
  private boolean dwX;
  private int eIx = -1;
  
  public NestedScrollingParentLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public NestedScrollingParentLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NestedScrollingParentLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean q(View paramView, MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = paramView.getMeasuredWidth();
    int m = paramView.getMeasuredHeight();
    int n = (int)paramMotionEvent.getRawX();
    int i1 = (int)paramMotionEvent.getRawY();
    return (n >= i) && (n <= k + i) && (i1 >= j) && (i1 <= m + j);
  }
  
  private void reset(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NestedScrollingParentLayout", 2, "onStartNestedScroll target += " + paramView);
    }
    this.Q = ((RecyclerView)paramView);
    if (this.Q == this.R) {
      this.Kd = -1;
    }
    while (this.Q != this.S) {
      return;
    }
    this.eIx = -1;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.dwX) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      if (QLog.isColorLevel()) {
        QLog.d("NestedScrollingParentLayout", 2, "onTouchEvent event += ");
      }
      if (q(this.R, paramMotionEvent)) {
        reset(this.R);
      } else if (q(this.S, paramMotionEvent)) {
        reset(this.S);
      }
    }
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    if (!this.dwX) {
      return super.onStartNestedScroll(paramView1, paramView2, paramInt);
    }
    reset(paramView2);
    return true;
  }
  
  public void setItemPosition(int paramInt)
  {
    this.Kd = paramInt;
  }
  
  public void setOnResume(boolean paramBoolean)
  {
    this.dwX = paramBoolean;
  }
  
  public void setTwoRecyclerView(RecyclerView paramRecyclerView1, RecyclerView paramRecyclerView2, axwo paramaxwo1, axwo paramaxwo2)
  {
    this.R = paramRecyclerView1;
    this.S = paramRecyclerView2;
    this.b = paramaxwo1;
    this.jdField_c_of_type_Axwo = paramaxwo2;
    this.R.addOnScrollListener(this.d);
    this.S.addOnScrollListener(this.jdField_c_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.NestedScrollingParentLayout
 * JD-Core Version:    0.7.0.1
 */