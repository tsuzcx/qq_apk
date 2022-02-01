package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Scroller;
import android.widget.TextView;

public class HorizontalScrollItemView
  extends RelativeLayout
  implements Checkable
{
  private static final String TAG = "HorizontalScrollView";
  private final View contentView;
  private OnItemScrollListener mOnItemScrollListener = new HorizontalScrollItemView.1(this);
  private final TextView[] rightViews;
  private final ScrollLayout scrollContentView;
  private View sectionView;
  
  public HorizontalScrollItemView(View paramView, TextView[] paramArrayOfTextView)
  {
    super(paramView.getContext());
    checkViews(paramArrayOfTextView);
    this.contentView = paramView;
    this.rightViews = paramArrayOfTextView;
    int j = paramArrayOfTextView.length;
    int i = 0;
    while (i < j)
    {
      addView(paramArrayOfTextView[i]);
      i += 1;
    }
    this.scrollContentView = new ScrollLayout(paramView.getContext());
    this.scrollContentView.addView(paramView);
    addView(this.scrollContentView, -1, -2);
    this.scrollContentView.setOnItemScrollListener(new HorizontalScrollItemView.2(this, paramArrayOfTextView));
  }
  
  private static void checkViews(View[] paramArrayOfView)
  {
    int i = 0;
    while (i < paramArrayOfView.length)
    {
      View localView = paramArrayOfView[i];
      if (localView == null) {
        throw new IllegalArgumentException("index: " + i + " cannot null");
      }
      if (localView.getId() == -1) {
        throw new IllegalArgumentException("index: " + i + " need id");
      }
      i += 1;
    }
  }
  
  private int getRightButtonsWidth()
  {
    int j = 0;
    TextView[] arrayOfTextView = this.rightViews;
    int m = arrayOfTextView.length;
    int i = 0;
    while (i < m)
    {
      TextView localTextView = arrayOfTextView[i];
      int k = j;
      if (localTextView != null)
      {
        k = j;
        if (localTextView.getVisibility() != 8) {
          k = j + localTextView.getMeasuredWidth();
        }
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public void addSectionView(View paramView, int paramInt)
  {
    if ((this.sectionView != null) && (this.sectionView.getParent() != null)) {
      ((ViewGroup)this.sectionView.getParent()).removeView(this.sectionView);
    }
    this.sectionView = paramView;
    addView(this.sectionView);
    this.sectionView.setLayoutParams(new RelativeLayout.LayoutParams(-1, paramInt));
    this.sectionView.setId(2131377762);
    ((RelativeLayout.LayoutParams)this.scrollContentView.getLayoutParams()).addRule(3, this.sectionView.getId());
    invalidate();
  }
  
  public boolean autoExpandOrFold(int paramInt)
  {
    this.scrollContentView.setPostion(paramInt);
    return this.scrollContentView.autoExpandOrFold();
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i = 0;
    while (i < this.rightViews.length)
    {
      if ((paramView == this.rightViews[i]) && (this.scrollContentView.getScrollX() == 0)) {
        return false;
      }
      i += 1;
    }
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  public void expand(int paramInt)
  {
    this.scrollContentView.setPostion(paramInt);
    this.scrollContentView.expand();
  }
  
  public void expandAndFoldBy(int paramInt1, int paramInt2)
  {
    this.scrollContentView.setPostion(paramInt1);
    this.scrollContentView.expandAndFoldBy(paramInt2);
  }
  
  public void fold(int paramInt)
  {
    this.scrollContentView.setPostion(paramInt);
    this.scrollContentView.fold();
  }
  
  public View getContentView()
  {
    return this.contentView;
  }
  
  public TextView getDeleteView()
  {
    return this.rightViews[0];
  }
  
  public TextView getReadView()
  {
    return this.rightViews[1];
  }
  
  public ScrollLayout getScrollContentView()
  {
    return this.scrollContentView;
  }
  
  public TextView getTopView()
  {
    return this.rightViews[2];
  }
  
  public boolean isChecked()
  {
    if ((this.contentView instanceof Checkable)) {
      ((Checkable)this.contentView).isChecked();
    }
    return false;
  }
  
  public boolean isInScrollContentView(int paramInt1, int paramInt2)
  {
    return (this.scrollContentView.getLeft() - this.scrollContentView.getScrollX() < paramInt1) && (paramInt1 < this.scrollContentView.getRight() - this.scrollContentView.getScrollX()) && (this.scrollContentView.getTop() < paramInt2) && (paramInt2 < this.scrollContentView.getBottom());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject = this.scrollContentView.getLayoutParams();
    if ((((ViewGroup.LayoutParams)localObject).width == -1) || (((ViewGroup.LayoutParams)localObject).width != View.MeasureSpec.getSize(paramInt1)))
    {
      ((ViewGroup.LayoutParams)localObject).width = View.MeasureSpec.getSize(paramInt1);
      this.scrollContentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int i = -1;
    int j = 0;
    RelativeLayout.LayoutParams localLayoutParams;
    if (j < this.rightViews.length)
    {
      localObject = this.rightViews[j];
      if (((View)localObject).getVisibility() == 8) {
        break label294;
      }
      localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
      if (this.sectionView != null) {
        localLayoutParams.addRule(3, this.sectionView.getId());
      }
      if (i == -1)
      {
        localLayoutParams.addRule(11);
        label124:
        i = ((View)localObject).getId();
      }
    }
    label294:
    for (;;)
    {
      j += 1;
      break;
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(0, i);
      break label124;
      if (Build.VERSION.SDK_INT >= 11) {
        this.scrollContentView.measure(this.scrollContentView.getMeasuredWidthAndState(), this.scrollContentView.getMeasuredHeightAndState());
      }
      for (;;)
      {
        localObject = this.rightViews;
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          localLayoutParams = localObject[i];
          localLayoutParams.getLayoutParams().height = this.scrollContentView.getMeasuredHeight();
          localLayoutParams.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.scrollContentView.getMeasuredHeight(), 1073741824));
          i += 1;
        }
        this.scrollContentView.measure(this.scrollContentView.getMeasuredWidth(), this.scrollContentView.getMeasuredHeight());
      }
      super.onMeasure(paramInt1, paramInt2);
      this.scrollContentView.setRange(getRightButtonsWidth(), 0);
      return;
    }
  }
  
  public void reset(int paramInt)
  {
    this.scrollContentView.setPostion(paramInt);
    this.scrollContentView.reset();
  }
  
  public void scrollBy(int paramInt1, int paramInt2, int paramInt3)
  {
    this.scrollContentView.setPostion(paramInt3);
    this.scrollContentView.scrollBy(paramInt1, 0);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if ((this.contentView instanceof Checkable)) {
      ((Checkable)this.contentView).setChecked(paramBoolean);
    }
  }
  
  public void setOnItemScrollListener(OnItemScrollListener paramOnItemScrollListener)
  {
    this.mOnItemScrollListener = paramOnItemScrollListener;
  }
  
  void setRightViewClickListener(View.OnClickListener paramOnClickListener)
  {
    int i = 0;
    while (i < this.rightViews.length)
    {
      this.rightViews[i].setOnClickListener(paramOnClickListener);
      this.rightViews[i].setClickable(false);
      i += 1;
    }
  }
  
  public void toggle() {}
  
  public static abstract interface OnItemScrollListener
  {
    public abstract void onExpandBegin(int paramInt);
    
    public abstract void onExpandEnd(int paramInt);
    
    public abstract void onFoldBegin(int paramInt);
    
    public abstract void onFoldEnd(int paramInt);
    
    public abstract void onScrollBegin(int paramInt);
    
    public abstract void onScrollEnd(int paramInt);
  }
  
  static class ScrollLayout
    extends FrameLayout
  {
    private static final int DURATION = 600;
    private HorizontalScrollItemView.OnItemScrollListener mOnItemScrollListener = new HorizontalScrollItemView.ScrollLayout.1(this);
    private int mPostion;
    private int maxLeft;
    private int maxRight;
    private boolean originalFolded = true;
    private final Scroller scroller = new Scroller(getContext());
    
    public ScrollLayout(Context paramContext)
    {
      super();
    }
    
    private boolean autoExpandOrFold()
    {
      int i = getScrollX();
      if ((i < this.maxLeft) && (i > this.maxRight)) {
        if (this.originalFolded) {
          if (i < this.maxLeft / 3) {
            fold();
          }
        }
      }
      while (i == 0)
      {
        return true;
        expand();
        return false;
        if (i < this.maxLeft * 2 / 3)
        {
          fold();
          return true;
        }
        expand();
        return false;
      }
      return false;
    }
    
    private void expand()
    {
      if (this.maxLeft != getScrollX())
      {
        this.scroller.startScroll(getScrollX(), getScrollY(), this.maxLeft - getScrollX(), getScrollY());
        invalidate();
      }
    }
    
    private void fold()
    {
      if (getScrollX() != 0)
      {
        this.scroller.startScroll(getScrollX(), getScrollY(), -getScrollX(), getScrollY());
        invalidate();
      }
    }
    
    private void fold(int paramInt)
    {
      if (getScrollX() != 0)
      {
        this.scroller.startScroll(getScrollX(), getScrollY(), -getScrollX(), getScrollY(), paramInt);
        invalidate();
      }
    }
    
    public void computeScroll()
    {
      if (this.scroller.computeScrollOffset())
      {
        scrollBy(getScrollX() - this.scroller.getCurrX(), this.scroller.getCurrY());
        postInvalidate();
      }
      super.computeScroll();
    }
    
    public void expandAndFoldBy(int paramInt)
    {
      paramInt = QMUIKit.dpToPx(paramInt);
      if (paramInt != getScrollX())
      {
        this.scroller.startScroll(getScrollX(), getScrollY(), paramInt - getScrollX(), getScrollY(), 600);
        postDelayed(new AutoFoldTask(null), 500L);
        invalidate();
      }
    }
    
    public CharSequence getContentDescription()
    {
      return super.getContentDescription();
    }
    
    public void reset()
    {
      scrollBy(getScrollX(), 0);
      this.scroller.forceFinished(true);
    }
    
    public void scrollBy(int paramInt1, int paramInt2)
    {
      if (Math.abs(paramInt1) > 10) {}
      paramInt1 = Math.max(Math.min(getScrollX() - paramInt1, this.maxLeft), this.maxRight);
      if (paramInt1 == getScrollX()) {
        return;
      }
      if (paramInt1 == this.maxRight)
      {
        this.originalFolded = true;
        if (paramInt1 != this.maxRight) {
          break label148;
        }
        this.mOnItemScrollListener.onFoldBegin(this.mPostion);
        label73:
        this.mOnItemScrollListener.onScrollBegin(this.mPostion);
        super.scrollTo(paramInt1, getScrollY() + paramInt2);
        if (paramInt1 != this.maxRight) {
          break label172;
        }
        this.mOnItemScrollListener.onFoldEnd(this.mPostion);
      }
      for (;;)
      {
        this.mOnItemScrollListener.onScrollEnd(this.mPostion);
        return;
        if (paramInt1 != this.maxLeft) {
          break;
        }
        this.originalFolded = false;
        break;
        label148:
        if (paramInt1 != this.maxLeft) {
          break label73;
        }
        this.mOnItemScrollListener.onExpandBegin(this.mPostion);
        break label73;
        label172:
        if (paramInt1 == this.maxLeft) {
          this.mOnItemScrollListener.onExpandEnd(this.mPostion);
        }
      }
    }
    
    public void scrollTo(int paramInt1, int paramInt2)
    {
      throw new UnsupportedOperationException();
    }
    
    public void setOnItemScrollListener(HorizontalScrollItemView.OnItemScrollListener paramOnItemScrollListener)
    {
      this.mOnItemScrollListener = paramOnItemScrollListener;
    }
    
    public void setPostion(int paramInt)
    {
      this.mPostion = paramInt;
    }
    
    void setRange(int paramInt1, int paramInt2)
    {
      this.maxLeft = paramInt1;
      this.maxRight = paramInt2;
      if (paramInt1 < paramInt2) {
        throw new IllegalArgumentException(String.format("setRange left[%d], right[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
    }
    
    class AutoFoldTask
      implements Runnable
    {
      private AutoFoldTask() {}
      
      public void run()
      {
        if (HorizontalScrollItemView.ScrollLayout.this.scroller.isFinished())
        {
          HorizontalScrollItemView.ScrollLayout.this.fold(600);
          return;
        }
        HorizontalScrollItemView.ScrollLayout.this.postDelayed(this, 50L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.HorizontalScrollItemView
 * JD-Core Version:    0.7.0.1
 */