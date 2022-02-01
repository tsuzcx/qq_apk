package com.tencent.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.ListAdapter;
import android.widget.Scroller;

public class SwipListView
  extends XListView
  implements Handler.Callback
{
  private byte A;
  private final int FA;
  private int Fx;
  private int Fy;
  private int Fz;
  private Handler V;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private c jdField_a_of_type_ComTencentWidgetSwipListView$c;
  private a c;
  private View cW;
  private View cX;
  private View cY;
  private int mMinFlingVelocity;
  private Scroller mScroller;
  private int mStartX;
  private int mStartY;
  private boolean qf;
  private boolean qg;
  
  public SwipListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwipListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public SwipListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mScroller = new Scroller(paramContext, new b());
    paramContext = ViewConfiguration.get(getContext());
    this.FA = paramContext.getScaledTouchSlop();
    this.mMinFlingVelocity = (paramContext.getScaledMinimumFlingVelocity() * 4);
    this.mStartX = -1;
    this.Fx = -1;
    this.mStartY = -1;
    this.Fy = -1;
    this.V = new Handler(Looper.getMainLooper(), this);
  }
  
  private void AN()
  {
    int i = fz();
    int j = this.cX.getScrollX();
    if (i > this.mMinFlingVelocity)
    {
      aA(this.cX);
      return;
    }
    if (i < -this.mMinFlingVelocity)
    {
      aB(this.cX);
      return;
    }
    if ((i > 0) && (j < this.Fz * 0.7F))
    {
      aA(this.cX);
      return;
    }
    if ((i < 0) && (j > this.Fz * 0.3F))
    {
      aB(this.cX);
      return;
    }
    if ((this.qg) && (j < this.Fz * 0.7F))
    {
      aA(this.cX);
      return;
    }
    if (j > this.Fz * 0.3F)
    {
      aB(this.cX);
      return;
    }
    aA(this.cX);
  }
  
  private void AO()
  {
    this.V.removeMessages(1);
    this.V.removeMessages(0);
    this.cY = null;
  }
  
  private void a(int paramInt1, int paramInt2, View paramView, int paramInt3)
  {
    paramInt2 = this.Fx;
    paramInt1 = paramView.getScrollX() - (paramInt1 - paramInt2);
    if (paramInt1 > paramInt3) {}
    for (;;)
    {
      paramView.scrollTo(paramInt3, 0);
      return;
      if (paramInt1 < 0) {
        paramInt3 = 0;
      } else {
        paramInt3 = paramInt1;
      }
    }
  }
  
  private void aA(View paramView)
  {
    if (paramView != null) {}
    for (int i = paramView.getScrollX();; i = 0)
    {
      if (this.jdField_a_of_type_ComTencentWidgetSwipListView$c != null) {
        this.jdField_a_of_type_ComTencentWidgetSwipListView$c.d(null);
      }
      if (i != 0) {
        if (!(paramView.getTag(-3) instanceof Integer)) {
          break label139;
        }
      }
      label139:
      for (int j = ((Integer)paramView.getTag(-3)).intValue();; j = 0)
      {
        if ((this.cY != paramView) && (this.cY != null)) {
          this.cY.scrollTo(0, 0);
        }
        AO();
        this.cY = paramView;
        int k = -i;
        this.mScroller.startScroll(i, 0, k, 0, x(j, k));
        this.V.sendEmptyMessage(1);
        do
        {
          return;
        } while (this.c == null);
        this.c.onRightIconMenuHide(paramView);
        return;
      }
    }
  }
  
  private void aB(View paramView)
  {
    int j;
    if (paramView != null)
    {
      j = paramView.getScrollX();
      i = j;
      if (this.jdField_a_of_type_ComTencentWidgetSwipListView$c != null) {
        this.jdField_a_of_type_ComTencentWidgetSwipListView$c.d(paramView);
      }
    }
    for (int i = j;; i = 0)
    {
      j = this.Fz;
      if ((j == 0) && (paramView != null) && ((paramView.getTag(-3) instanceof Integer))) {
        j = ((Integer)paramView.getTag(-3)).intValue();
      }
      for (;;)
      {
        if (i != j)
        {
          if ((this.cY != paramView) && (this.cY != null)) {
            this.cY.scrollTo(0, 0);
          }
          AO();
          this.cY = paramView;
          k = j - i;
          this.mScroller.startScroll(i, 0, k, 0, x(j, k));
          this.V.sendEmptyMessage(0);
        }
        while (this.c == null)
        {
          int k;
          return;
        }
        this.c.onRightIconMenuShow(paramView);
        return;
      }
    }
  }
  
  private boolean b(float paramFloat)
  {
    return paramFloat < getWidth() - this.Fz;
  }
  
  private int fz()
  {
    this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
    return (int)this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity();
  }
  
  private boolean n(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 > this.FA) || (paramFloat2 > this.FA))
    {
      if ((paramFloat1 > this.FA) && (paramFloat2 / paramFloat1 < 0.6F))
      {
        this.A = 1;
        return true;
      }
      this.A = 2;
      return true;
    }
    return false;
  }
  
  private void o(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
  }
  
  private boolean r(View paramView)
  {
    return (paramView != null) && (paramView.getScrollX() >= this.FA);
  }
  
  private void recycleVelocityTracker()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  private int x(int paramInt1, int paramInt2)
  {
    int i = 300;
    if (paramInt1 > 0) {
      i = (int)(Math.abs(paramInt2) / paramInt1 * 300.0F) + 50;
    }
    return i;
  }
  
  public void AP()
  {
    int i;
    int j;
    if (!r(this.cX))
    {
      i = getFirstVisiblePosition() - getHeaderViewsCount();
      j = getLastVisiblePosition();
    }
    for (;;)
    {
      if (i <= j)
      {
        View localView = getChildAt(i);
        if (r(localView)) {
          this.cX = localView;
        }
      }
      else
      {
        aA(this.cX);
        return;
      }
      i += 1;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (r(this.cX)) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
    }
    do
    {
      return bool;
      bool = this.mScroller.computeScrollOffset();
      float f = this.mScroller.getCurrX();
      if ((this.cY != null) && (this.cY.getScrollX() < (int)f))
      {
        this.cY.scrollTo((int)f, 0);
        invalidate();
      }
      if (bool)
      {
        this.V.sendEmptyMessage(0);
        return true;
      }
      if (this.c != null) {
        this.c.onRightIconMenuShow(this.cY);
      }
      this.cY = null;
      return true;
      bool = this.mScroller.computeScrollOffset();
      f = this.mScroller.getCurrX();
      if ((this.cY != null) && (this.cY.getScrollX() > (int)f))
      {
        this.cY.scrollTo((int)f, 0);
        invalidate();
      }
      if (bool)
      {
        this.V.sendEmptyMessage(1);
        return true;
      }
      if (this.c != null) {
        this.c.onRightIconMenuHide(this.cY);
      }
      this.cY = null;
      return true;
    } while (this.jdField_a_of_type_ComTencentWidgetSwipListView$c == null);
    this.jdField_a_of_type_ComTencentWidgetSwipListView$c.hi();
    return true;
  }
  
  public void iY(View paramView)
  {
    AP();
    aB(paramView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2;
    if (!this.qf)
    {
      bool2 = super.onInterceptTouchEvent(paramMotionEvent);
      return bool2;
    }
    int j = (int)(paramMotionEvent.getX() + 0.5F);
    int i = (int)(paramMotionEvent.getY() + 0.5F);
    int k = paramMotionEvent.getAction();
    label76:
    boolean bool1;
    switch (k)
    {
    default: 
      bool1 = false;
      label79:
      if ((k == 0) && (this.qg))
      {
        if (this.jdField_a_of_type_ComTencentWidgetSwipListView$c != null) {
          this.jdField_a_of_type_ComTencentWidgetSwipListView$c.al(true);
        }
        AO();
      }
      break;
    }
    for (;;)
    {
      bool2 = bool1;
      if (bool1) {
        break;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
      this.A = 0;
      if (this.jdField_a_of_type_ComTencentWidgetSwipListView$c != null) {
        this.jdField_a_of_type_ComTencentWidgetSwipListView$c.d(null);
      }
      this.mStartX = j;
      this.Fx = j;
      this.mStartY = i;
      this.Fy = i;
      this.cW = this.cX;
      this.qg = r(this.cW);
      int m;
      int n;
      if (!this.qg)
      {
        m = getFirstVisiblePosition();
        n = getHeaderViewsCount();
        i = getLastVisiblePosition();
      }
      for (;;)
      {
        if (i >= m - n)
        {
          View localView = getChildAt(i);
          this.qg = r(localView);
          if (this.qg) {
            this.cW = localView;
          }
        }
        else
        {
          this.Fz = 0;
          this.cX = null;
          i = this.mStartY;
          if (isOverscrollHeadVisiable()) {
            i = this.mStartY + getScrollY();
          }
          i = pointToPosition(this.mStartX, i);
          if (i >= 0)
          {
            this.cX = getChildAt(i - getFirstVisiblePosition());
            if ((this.cX != null) && ((this.cX.getTag(-3) instanceof Integer))) {
              this.Fz = ((Integer)this.cX.getTag(-3)).intValue();
            }
          }
          if ((!this.qg) || ((this.cX == this.cW) && (!b(j)))) {
            break label393;
          }
          bool1 = true;
          break;
        }
        i -= 1;
      }
      label393:
      bool1 = false;
      break label79;
      if (this.Fz <= 0) {
        break label76;
      }
      if (this.A == 0) {
        n(Math.abs(j - this.mStartX), Math.abs(i - this.mStartY));
      }
      if (this.A != 1) {
        break label76;
      }
      if (j < this.mStartX) {}
      for (bool2 = true;; bool2 = false)
      {
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        this.V.sendEmptyMessage(2);
        bool1 = bool2;
        break;
      }
      if (this.qg) {
        aA(this.cW);
      }
      this.mStartX = -1;
      this.Fx = -1;
      this.mStartY = -1;
      this.Fy = -1;
      break label76;
      if (((k == 1) || (k == 3)) && (this.jdField_a_of_type_ComTencentWidgetSwipListView$c != null)) {
        this.jdField_a_of_type_ComTencentWidgetSwipListView$c.al(false);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2;
    if (!this.qf)
    {
      bool2 = super.onTouchEvent(paramMotionEvent);
      return bool2;
    }
    o(paramMotionEvent);
    int i = (int)(paramMotionEvent.getX() + 0.5F);
    int j = (int)(paramMotionEvent.getY() + 0.5F);
    int k = paramMotionEvent.getAction();
    boolean bool1;
    switch (k)
    {
    default: 
      bool1 = false;
    case 0: 
    case 2: 
      for (;;)
      {
        if ((k == 0) && (this.qg))
        {
          if (this.jdField_a_of_type_ComTencentWidgetSwipListView$c != null) {
            this.jdField_a_of_type_ComTencentWidgetSwipListView$c.al(true);
          }
          label112:
          bool2 = bool1;
          if (bool1) {
            break;
          }
          return super.onTouchEvent(paramMotionEvent);
          if ((this.qg) && ((this.cX != this.cW) || (b(i)))) {}
          for (bool2 = true;; bool2 = false)
          {
            bool1 = bool2;
            if (!this.qg) {
              break;
            }
            bool1 = bool2;
            if (this.cW == this.cX) {
              break;
            }
            aA(this.cW);
            bool1 = bool2;
            break;
          }
          if (this.qg) {
            if ((this.cX != this.cW) || (b(i)))
            {
              bool2 = true;
              label234:
              bool1 = bool2;
              if (this.cX == this.cW)
              {
                if (this.A == 0)
                {
                  bool1 = bool2;
                  if (!n(Math.abs(i - this.mStartX), Math.abs(j - this.mStartY))) {
                    continue;
                  }
                }
                bool1 = bool2;
                if (this.A == 1)
                {
                  a(i, j, this.cX, this.Fz);
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      this.Fx = i;
      this.Fy = j;
      break;
      bool2 = false;
      break label234;
      if (this.Fz == 0)
      {
        bool1 = false;
      }
      else
      {
        if ((this.A == 0) && (!n(Math.abs(i - this.mStartX), Math.abs(j - this.mStartY))))
        {
          bool1 = false;
          break;
        }
        if (this.A == 1)
        {
          a(i, j, this.cX, this.Fz);
          bool1 = true;
          continue;
          if (this.qg) {
            if ((this.cX != this.cW) || (b(i)))
            {
              bool2 = true;
              label446:
              bool1 = bool2;
              if (this.cX == this.cW)
              {
                if (this.A != 1) {
                  break label509;
                }
                AN();
                bool1 = true;
              }
            }
          }
          for (;;)
          {
            recycleVelocityTracker();
            this.mStartX = -1;
            this.Fx = -1;
            this.mStartY = -1;
            this.Fy = -1;
            break;
            bool2 = false;
            break label446;
            label509:
            aA(this.cX);
            bool1 = bool2;
            continue;
            if (this.Fz == 0)
            {
              bool1 = false;
            }
            else
            {
              if (this.A == 1)
              {
                AN();
                bool1 = true;
                continue;
                if (((k != 1) && (k != 3)) || (this.jdField_a_of_type_ComTencentWidgetSwipListView$c == null)) {
                  break label112;
                }
                this.jdField_a_of_type_ComTencentWidgetSwipListView$c.al(false);
                break label112;
              }
              bool1 = false;
            }
          }
        }
        else
        {
          bool1 = false;
        }
      }
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    if ((paramListAdapter instanceof c)) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView$c = ((c)paramListAdapter);
    }
  }
  
  public void setDragEnable(boolean paramBoolean)
  {
    this.qf = paramBoolean;
    if (!this.qf) {
      AP();
    }
  }
  
  public void setRightIconMenuListener(a parama)
  {
    this.c = parama;
  }
  
  public void setSwipListListener(c paramc)
  {
    this.jdField_a_of_type_ComTencentWidgetSwipListView$c = paramc;
  }
  
  public static abstract interface a
  {
    public abstract void onRightIconMenuHide(View paramView);
    
    public abstract void onRightIconMenuShow(View paramView);
  }
  
  public static class b
    implements Interpolator
  {
    public float getInterpolation(float paramFloat)
    {
      return (float)(Math.pow(paramFloat - 1.0D, 5.0D) + 1.0D);
    }
  }
  
  public static abstract interface c
  {
    public abstract void al(boolean paramBoolean);
    
    public abstract void d(View paramView);
    
    public abstract void hi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.SwipListView
 * JD-Core Version:    0.7.0.1
 */