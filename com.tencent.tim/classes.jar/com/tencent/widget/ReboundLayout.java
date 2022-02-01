package com.tencent.widget;

import android.content.Context;
import android.support.annotation.RequiresApi;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class ReboundLayout
  extends LinearLayout
  implements NestedScrollingParent
{
  private boolean dkS;
  private int eus = 3;
  private View mChildView;
  private View mFooterView;
  private View mHeaderView;
  
  public ReboundLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReboundLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReboundLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
  }
  
  @RequiresApi(api=21)
  public ReboundLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setOrientation(0);
  }
  
  public int getNestedScrollAxes()
  {
    return 0;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.mChildView = getChildAt(0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(400, -1);
    this.mHeaderView = new View(this.mChildView.getContext());
    this.mFooterView = new View(this.mChildView.getContext());
    addView(this.mHeaderView, 0, localLayoutParams);
    addView(this.mFooterView, getChildCount(), localLayoutParams);
    scrollBy(400, 0);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.mChildView.getLayoutParams().width = getMeasuredWidth();
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return getScrollX() != 400;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    int i;
    label49:
    int j;
    if ((paramInt1 > 0) && (getScrollX() < 400) && (!ViewCompat.canScrollHorizontally(paramView, -1)))
    {
      paramInt2 = 1;
      if ((paramInt1 >= 0) || (ViewCompat.canScrollHorizontally(paramView, -1))) {
        break label190;
      }
      i = 1;
      if ((paramInt1 >= 0) || (getScrollX() <= 400) || (ViewCompat.canScrollHorizontally(paramView, 1))) {
        break label196;
      }
      j = 1;
      label74:
      if ((paramInt1 <= 0) || (ViewCompat.canScrollHorizontally(paramView, 1))) {
        break label202;
      }
    }
    label190:
    label196:
    label202:
    for (int k = 1;; k = 0)
    {
      if ((paramInt2 != 0) || (i != 0) || (j != 0) || (k != 0))
      {
        scrollBy(paramInt1 / this.eus, 0);
        paramArrayOfInt[0] = paramInt1;
      }
      if ((paramInt1 > 0) && (getScrollX() > 400) && (!ViewCompat.canScrollHorizontally(paramView, -1))) {
        scrollTo(400, 0);
      }
      if ((paramInt1 < 0) && (getScrollX() < 400) && (!ViewCompat.canScrollHorizontally(paramView, 1))) {
        scrollTo(400, 0);
      }
      return;
      paramInt2 = 0;
      break;
      i = 0;
      break label49;
      j = 0;
      break label74;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt) {}
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return ((paramView2 instanceof RecyclerView)) && (!this.dkS);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    startAnimation(new a(null));
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 < 0) {
      i = 0;
    }
    for (;;)
    {
      super.scrollTo(i, paramInt2);
      return;
      i = paramInt1;
      if (paramInt1 > 800) {
        i = 800;
      }
    }
  }
  
  class a
    extends Animation
  {
    private float endProgress = 1.0F;
    private float startProgress;
    
    private a()
    {
      ReboundLayout.a(ReboundLayout.this, true);
    }
    
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      paramFloat = (this.endProgress - this.startProgress) * paramFloat + this.startProgress;
      ReboundLayout.this.scrollBy((int)((400 - ReboundLayout.this.getScrollX()) * paramFloat), 0);
      if (paramFloat == 1.0F) {
        ReboundLayout.a(ReboundLayout.this, false);
      }
    }
    
    public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
      setDuration(260L);
      setInterpolator(new AccelerateInterpolator());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.ReboundLayout
 * JD-Core Version:    0.7.0.1
 */