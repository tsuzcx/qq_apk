package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.Scroller;
import arjx;
import java.util.ArrayList;

public class Workspace
  extends FrameLayout
{
  protected static final double bs = Math.tan(Math.toRadians(30.0D));
  private float Ci;
  private Rect Q = new Rect();
  private a a;
  protected boolean aKZ;
  protected int bww = -1;
  final Rect cX = new Rect();
  private boolean dbU = true;
  private boolean dbV;
  private int eiH;
  protected int eiI;
  final Rect mClipBounds = new Rect();
  protected int mCurrentScreen;
  protected int mDefaultScreen = 0;
  private boolean mFirstLayout = true;
  protected float mLastMotionX;
  protected float mLastMotionY;
  private View.OnLongClickListener mLongClickListener;
  private Paint mPaint;
  protected Scroller mScroller;
  protected int mTouchSlop;
  protected int mTouchState = 0;
  private VelocityTracker mVelocityTracker;
  private int[] pq = new int[2];
  
  public Workspace(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public Workspace(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ejl();
    setDrawingCacheEnabled(true);
    setAlwaysDrawnWithCacheEnabled(true);
    setBackgroundDrawable(getResources().getDrawable(2130838900));
  }
  
  private void ejl()
  {
    this.mScroller = new Scroller(getContext());
    this.mCurrentScreen = this.mDefaultScreen;
    this.mPaint = new Paint();
    this.mPaint.setDither(false);
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  private void snapToDestination()
  {
    int i = getWidth();
    snapToScreen((getScrollX() + i / 2) / i);
  }
  
  protected boolean a(View paramView, boolean paramBoolean, MotionEvent paramMotionEvent)
  {
    int i;
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      i = 0;
    }
    for (;;)
    {
      View localView;
      Workspace localWorkspace;
      if (i < paramView.getChildCount())
      {
        localView = paramView.getChildAt(i);
        if (!(localView instanceof Workspace)) {
          break label130;
        }
        localWorkspace = (Workspace)localView;
        localWorkspace.getGlobalVisibleRect(this.Q);
        if ((localWorkspace.isShown()) && (this.Q.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))) {}
      }
      else
      {
        return false;
      }
      if (paramBoolean)
      {
        if ((localWorkspace.getCurrentScreen() > 0) || (getCurrentScreen() == 0)) {
          return true;
        }
        if (localWorkspace.eiI != this.mCurrentScreen) {
          localWorkspace.setCurrentScreen(localWorkspace.eiI);
        }
      }
      label130:
      while (((localView instanceof ViewGroup)) && (a((ViewGroup)localView, paramBoolean, paramMotionEvent)))
      {
        return true;
        if ((localWorkspace.getCurrentScreen() < localWorkspace.getChildCount() - 1) || (getCurrentScreen() == getChildCount() - 1)) {
          return true;
        }
        if (localWorkspace.eiI != this.mCurrentScreen) {
          localWorkspace.setCurrentScreen(localWorkspace.eiI);
        }
      }
      i += 1;
    }
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt)
  {
    getChildAt(this.mCurrentScreen).addFocusables(paramArrayList, paramInt);
    if (paramInt == 17) {
      if (this.mCurrentScreen > 0) {
        getChildAt(this.mCurrentScreen - 1).addFocusables(paramArrayList, paramInt);
      }
    }
    while ((paramInt != 66) || (this.mCurrentScreen >= getChildCount() - 1)) {
      return;
    }
    getChildAt(this.mCurrentScreen + 1).addFocusables(paramArrayList, paramInt);
  }
  
  public void computeScroll()
  {
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
      postInvalidate();
    }
    do
    {
      do
      {
        return;
      } while (this.bww == -1);
      int i = this.mCurrentScreen;
      this.mCurrentScreen = Math.max(0, Math.min(this.bww, getChildCount() - 1));
      this.eiI = this.mCurrentScreen;
      this.bww = -1;
      ejn();
    } while (this.a == null);
    this.a.YQ(this.mCurrentScreen);
  }
  
  public boolean dispatchUnhandledMove(View paramView, int paramInt)
  {
    if (paramInt == 17)
    {
      if (getCurrentScreen() > 0)
      {
        snapToScreen(getCurrentScreen() - 1);
        return true;
      }
    }
    else if ((paramInt == 66) && (getCurrentScreen() < getChildCount() - 1))
    {
      snapToScreen(getCurrentScreen() + 1);
      return true;
    }
    return super.dispatchUnhandledMove(paramView, paramInt);
  }
  
  void ejm() {}
  
  void ejn() {}
  
  public int getCurrentScreen()
  {
    return this.mCurrentScreen;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramMotionEvent.getAction() == 2) {
      if (paramMotionEvent.getX() - this.mLastMotionX > 0.0F)
      {
        bool1 = true;
        if (!a(getChildAt(this.eiI), bool1, paramMotionEvent)) {
          break label58;
        }
        bool1 = false;
      }
    }
    label58:
    int i;
    do
    {
      return bool1;
      bool1 = false;
      break;
      i = paramMotionEvent.getAction();
      if (i != 2) {
        break label81;
      }
      bool1 = bool2;
    } while (this.mTouchState != 0);
    label81:
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i)
    {
    }
    for (;;)
    {
      Object localObject = getChildAt(this.eiI);
      if ((this.mTouchState != 0) && (!a((View)localObject, true, paramMotionEvent)))
      {
        bool1 = bool2;
        if (!a((View)localObject, false, paramMotionEvent)) {
          break;
        }
      }
      return false;
      int k = (int)Math.abs(f1 - this.mLastMotionX);
      int m = (int)Math.abs(f2 - this.mLastMotionY);
      int j = this.mTouchSlop;
      if (k > j)
      {
        i = 1;
        label211:
        if (m <= j) {
          break label318;
        }
      }
      label318:
      for (j = 1;; j = 0)
      {
        double d = m / k;
        if (((i == 0) && (j == 0)) || (d >= bs)) {
          break;
        }
        if (i != 0)
        {
          localObject = getParent();
          if (localObject != null) {
            ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
          }
          this.mTouchState = 1;
          this.mLastMotionX = f1;
          ejm();
        }
        if (!this.aKZ) {
          break;
        }
        this.aKZ = false;
        getChildAt(this.mCurrentScreen).cancelLongPress();
        break;
        i = 0;
        break label211;
      }
      this.mLastMotionX = f1;
      this.mLastMotionY = f2;
      this.aKZ = true;
      if (this.mScroller.isFinished()) {}
      for (i = 0;; i = 1)
      {
        this.mTouchState = i;
        break;
      }
      ejn();
      this.mTouchState = 0;
      this.aKZ = false;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt4 = getChildCount();
    paramInt1 = 0;
    for (paramInt2 = 0; paramInt1 < paramInt4; paramInt2 = paramInt3)
    {
      View localView = getChildAt(paramInt1);
      paramInt3 = paramInt2;
      if (localView.getVisibility() != 8)
      {
        paramInt3 = localView.getMeasuredWidth();
        if ((!this.dbV) || (paramInt1 == this.mCurrentScreen)) {
          localView.layout(paramInt2, 0, paramInt2 + paramInt3, localView.getMeasuredHeight());
        }
        paramInt3 = paramInt2 + paramInt3;
      }
      paramInt1 += 1;
    }
    this.dbV = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = getChildCount();
    int i = 0;
    while (i < k)
    {
      getChildAt(i).measure(paramInt1, paramInt2);
      i += 1;
    }
    paramInt1 = this.eiH;
    if (paramInt1 > j) {}
    for (float f = (k * j - paramInt1) / ((k - 1) * j);; f = 1.0F)
    {
      this.Ci = f;
      if (this.mFirstLayout)
      {
        scrollTo(this.mCurrentScreen * j, 0);
        this.mFirstLayout = false;
      }
      return;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    if (this.bww != -1) {}
    for (int i = this.bww;; i = this.mCurrentScreen)
    {
      int j = i;
      if (i >= getChildCount()) {
        j = getChildCount() - 1;
      }
      if (getChildAt(j) != null) {
        getChildAt(j).requestFocus(paramInt, paramRect);
      }
      return false;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable.currentScreen != -1) {
      this.mCurrentScreen = paramParcelable.currentScreen;
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.currentScreen = this.mCurrentScreen;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 < paramInt4) && (paramInt1 == paramInt3)) {}
    for (this.dbV = true;; this.dbV = false)
    {
      if (!this.mScroller.isFinished()) {
        this.mScroller.forceFinished(true);
      }
      scrollTo(this.eiI * paramInt1, 0);
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (getChildCount() < 0) {}
    int i;
    do
    {
      do
      {
        do
        {
          float f;
          do
          {
            return true;
            if (this.mVelocityTracker == null) {
              this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(paramMotionEvent);
            i = paramMotionEvent.getAction();
            f = paramMotionEvent.getX();
            switch (i)
            {
            default: 
              return true;
            case 0: 
              if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
              }
              paramMotionEvent = getParent();
              if (paramMotionEvent != null) {
                paramMotionEvent.requestDisallowInterceptTouchEvent(true);
              }
              this.mLastMotionX = f;
              return true;
            }
          } while (this.mTouchState != 1);
          i = (int)(this.mLastMotionX - f);
          if ((i > 0) && (!this.dbU) && (this.mCurrentScreen == getChildCount() - 1))
          {
            this.a.YQ(getChildCount());
            return true;
          }
          this.mLastMotionX = f;
          paramMotionEvent = getParent();
          if (paramMotionEvent != null) {
            paramMotionEvent.requestDisallowInterceptTouchEvent(true);
          }
          if (i >= 0) {
            break;
          }
          if (getScrollX() > 0)
          {
            scrollBy(Math.max(-getScrollX(), i), 0);
            return true;
          }
        } while (!this.dbU);
        scrollBy(i / 3, 0);
        return true;
      } while (i <= 0);
      int j = getChildAt(getChildCount() - 1).getRight() - getScrollX() - getWidth();
      if (j > 0)
      {
        scrollBy(Math.min(j, i), 0);
        return true;
      }
    } while (!this.dbU);
    scrollBy(i / 3, 0);
    return true;
    if (this.mTouchState == 1)
    {
      paramMotionEvent = this.mVelocityTracker;
      paramMotionEvent.computeCurrentVelocity(1000);
      i = (int)paramMotionEvent.getXVelocity();
      if ((i <= 350) || (this.mCurrentScreen <= 0)) {
        break label374;
      }
      snapToScreen(this.mCurrentScreen - 1);
    }
    for (;;)
    {
      if (this.mVelocityTracker != null)
      {
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
      }
      this.mTouchState = 0;
      return true;
      label374:
      if ((i < -350) && (this.mCurrentScreen < getChildCount() - 1)) {
        snapToScreen(this.mCurrentScreen + 1);
      } else {
        snapToDestination();
      }
    }
    this.mTouchState = 0;
    return true;
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    paramView1 = new Rect();
    paramView2.getDrawingRect(paramView1);
    paramView2.requestRectangleOnScreen(paramView1);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    int i = indexOfChild(paramView);
    if ((i != this.mCurrentScreen) || (!this.mScroller.isFinished()))
    {
      snapToScreen(i);
      return true;
    }
    return false;
  }
  
  public void setAllowLongPress(boolean paramBoolean)
  {
    this.aKZ = paramBoolean;
  }
  
  public void setAlloweffect(boolean paramBoolean)
  {
    this.dbU = paramBoolean;
  }
  
  public void setCurrentScreen(int paramInt)
  {
    this.mCurrentScreen = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    this.eiI = this.mCurrentScreen;
    scrollTo(this.mCurrentScreen * getWidth(), 0);
  }
  
  public void setDefaultScreen(int paramInt)
  {
    this.mDefaultScreen = paramInt;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.mLongClickListener = paramOnLongClickListener;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      getChildAt(i).setOnLongClickListener(paramOnLongClickListener);
      i += 1;
    }
  }
  
  public void setOnScreenChangeListener(a parama)
  {
    this.a = parama;
  }
  
  public void snapToScreen(int paramInt)
  {
    ejm();
    int i = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    if (i != this.mCurrentScreen) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (this.eiI != i)
      {
        this.eiI = i;
        if (this.a != null) {
          this.a.YP(i);
        }
      }
      this.bww = i;
      View localView = getFocusedChild();
      if ((localView != null) && (paramInt != 0) && (localView == getChildAt(this.mCurrentScreen))) {
        localView.clearFocus();
      }
      paramInt = getWidth() * i - getScrollX();
      this.mScroller.startScroll(getScrollX(), 0, paramInt, 0, Math.abs(paramInt));
      invalidate();
      return;
    }
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new arjx();
    int currentScreen = -1;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      this.currentScreen = paramParcel.readInt();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.currentScreen);
    }
  }
  
  public static abstract interface a
  {
    public abstract void YP(int paramInt);
    
    public abstract void YQ(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.Workspace
 * JD-Core Version:    0.7.0.1
 */