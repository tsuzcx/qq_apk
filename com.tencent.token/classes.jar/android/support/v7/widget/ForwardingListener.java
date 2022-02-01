package android.support.v7.widget;

import android.os.SystemClock;
import android.support.annotation.RestrictTo;
import android.support.v7.view.menu.ShowableListMenu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public abstract class ForwardingListener
  implements View.OnAttachStateChangeListener, View.OnTouchListener
{
  private int mActivePointerId;
  private Runnable mDisallowIntercept;
  private boolean mForwarding;
  private final int mLongPressTimeout;
  private final float mScaledTouchSlop;
  final View mSrc;
  private final int mTapTimeout;
  private final int[] mTmpLocation = new int[2];
  private Runnable mTriggerLongPress;
  
  public ForwardingListener(View paramView)
  {
    this.mSrc = paramView;
    paramView.setLongClickable(true);
    paramView.addOnAttachStateChangeListener(this);
    this.mScaledTouchSlop = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    this.mTapTimeout = ViewConfiguration.getTapTimeout();
    this.mLongPressTimeout = ((this.mTapTimeout + ViewConfiguration.getLongPressTimeout()) / 2);
  }
  
  private void clearCallbacks()
  {
    Runnable localRunnable = this.mTriggerLongPress;
    if (localRunnable != null) {
      this.mSrc.removeCallbacks(localRunnable);
    }
    localRunnable = this.mDisallowIntercept;
    if (localRunnable != null) {
      this.mSrc.removeCallbacks(localRunnable);
    }
  }
  
  private boolean onTouchForwarded(MotionEvent paramMotionEvent)
  {
    View localView = this.mSrc;
    Object localObject = getPopup();
    if (localObject != null)
    {
      if (!((ShowableListMenu)localObject).isShowing()) {
        return false;
      }
      localObject = (DropDownListView)((ShowableListMenu)localObject).getListView();
      if (localObject != null)
      {
        if (!((DropDownListView)localObject).isShown()) {
          return false;
        }
        MotionEvent localMotionEvent = MotionEvent.obtainNoHistory(paramMotionEvent);
        toGlobalMotionEvent(localView, localMotionEvent);
        toLocalMotionEvent((View)localObject, localMotionEvent);
        boolean bool = ((DropDownListView)localObject).onForwardedEvent(localMotionEvent, this.mActivePointerId);
        localMotionEvent.recycle();
        int i = paramMotionEvent.getActionMasked();
        if ((i != 1) && (i != 3)) {
          i = 1;
        } else {
          i = 0;
        }
        return (bool) && (i != 0);
      }
      return false;
    }
    return false;
  }
  
  private boolean onTouchObserved(MotionEvent paramMotionEvent)
  {
    View localView = this.mSrc;
    if (!localView.isEnabled()) {
      return false;
    }
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      return false;
    case 2: 
      int i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      if ((i >= 0) && (!pointInView(localView, paramMotionEvent.getX(i), paramMotionEvent.getY(i), this.mScaledTouchSlop)))
      {
        clearCallbacks();
        localView.getParent().requestDisallowInterceptTouchEvent(true);
        return true;
      }
      break;
    case 1: 
    case 3: 
      clearCallbacks();
      return false;
    case 0: 
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      if (this.mDisallowIntercept == null) {
        this.mDisallowIntercept = new DisallowIntercept();
      }
      localView.postDelayed(this.mDisallowIntercept, this.mTapTimeout);
      if (this.mTriggerLongPress == null) {
        this.mTriggerLongPress = new TriggerLongPress();
      }
      localView.postDelayed(this.mTriggerLongPress, this.mLongPressTimeout);
    }
    return false;
  }
  
  private static boolean pointInView(View paramView, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f = -paramFloat3;
    return (paramFloat1 >= f) && (paramFloat2 >= f) && (paramFloat1 < paramView.getRight() - paramView.getLeft() + paramFloat3) && (paramFloat2 < paramView.getBottom() - paramView.getTop() + paramFloat3);
  }
  
  private boolean toGlobalMotionEvent(View paramView, MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = this.mTmpLocation;
    paramView.getLocationOnScreen(arrayOfInt);
    paramMotionEvent.offsetLocation(arrayOfInt[0], arrayOfInt[1]);
    return true;
  }
  
  private boolean toLocalMotionEvent(View paramView, MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = this.mTmpLocation;
    paramView.getLocationOnScreen(arrayOfInt);
    paramMotionEvent.offsetLocation(-arrayOfInt[0], -arrayOfInt[1]);
    return true;
  }
  
  public abstract ShowableListMenu getPopup();
  
  protected boolean onForwardingStarted()
  {
    ShowableListMenu localShowableListMenu = getPopup();
    if ((localShowableListMenu != null) && (!localShowableListMenu.isShowing())) {
      localShowableListMenu.show();
    }
    return true;
  }
  
  protected boolean onForwardingStopped()
  {
    ShowableListMenu localShowableListMenu = getPopup();
    if ((localShowableListMenu != null) && (localShowableListMenu.isShowing())) {
      localShowableListMenu.dismiss();
    }
    return true;
  }
  
  void onLongPress()
  {
    clearCallbacks();
    View localView = this.mSrc;
    if (localView.isEnabled())
    {
      if (localView.isLongClickable()) {
        return;
      }
      if (!onForwardingStarted()) {
        return;
      }
      localView.getParent().requestDisallowInterceptTouchEvent(true);
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      localView.onTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      this.mForwarding = true;
      return;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool4 = this.mForwarding;
    boolean bool3 = true;
    boolean bool1;
    if (bool4)
    {
      if ((!onTouchForwarded(paramMotionEvent)) && (onForwardingStopped())) {
        bool1 = false;
      } else {
        bool1 = true;
      }
    }
    else
    {
      if ((onTouchObserved(paramMotionEvent)) && (onForwardingStarted())) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      bool1 = bool2;
      if (bool2)
      {
        long l = SystemClock.uptimeMillis();
        paramView = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        this.mSrc.onTouchEvent(paramView);
        paramView.recycle();
        bool1 = bool2;
      }
    }
    this.mForwarding = bool1;
    boolean bool2 = bool3;
    if (!bool1)
    {
      if (bool4) {
        return true;
      }
      bool2 = false;
    }
    return bool2;
  }
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    this.mForwarding = false;
    this.mActivePointerId = -1;
    paramView = this.mDisallowIntercept;
    if (paramView != null) {
      this.mSrc.removeCallbacks(paramView);
    }
  }
  
  private class DisallowIntercept
    implements Runnable
  {
    DisallowIntercept() {}
    
    public void run()
    {
      ViewParent localViewParent = ForwardingListener.this.mSrc.getParent();
      if (localViewParent != null) {
        localViewParent.requestDisallowInterceptTouchEvent(true);
      }
    }
  }
  
  private class TriggerLongPress
    implements Runnable
  {
    TriggerLongPress() {}
    
    public void run()
    {
      ForwardingListener.this.onLongPress();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ForwardingListener
 * JD-Core Version:    0.7.0.1
 */