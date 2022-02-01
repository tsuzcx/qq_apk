package com.tencent.qqmini.miniapp.core.page.swipe;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ScrollerCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public class ViewDragHelper
{
  private static final int BASE_SETTLE_DURATION = 256;
  public static final int DIRECTION_ALL = 3;
  public static final int DIRECTION_HORIZONTAL = 1;
  public static final int DIRECTION_VERTICAL = 2;
  public static final int EDGE_ALL = 15;
  public static final int EDGE_BOTTOM = 8;
  public static final int EDGE_LEFT = 1;
  public static final int EDGE_RIGHT = 2;
  private static final int EDGE_SIZE = 20;
  public static final int EDGE_TOP = 4;
  public static final int INVALID_POINTER = -1;
  private static final int MAX_SETTLE_DURATION = 600;
  public static final int SCROLL_LEFT_TO_RIGHT = 1;
  public static final int SCROLL_TOP_TO_BOTTOM = 2;
  public static final int STATE_DRAGGING = 1;
  public static final int STATE_IDLE = 0;
  public static final int STATE_SETTLING = 2;
  private static final String TAG = "ViewDragHelper";
  private static final Interpolator sInterpolator = new ViewDragHelper.1();
  private int mActivePointerId = -1;
  private final Callback mCallback;
  private View mCapturedView;
  private int mDragState;
  private int[] mEdgeDragsInProgress;
  private int[] mEdgeDragsLocked;
  private int mEdgeSize;
  private int[] mInitialEdgesTouched;
  private float[] mInitialMotionX;
  private float[] mInitialMotionY;
  private float[] mLastMotionX;
  private float[] mLastMotionY;
  private float mMaxVelocity;
  private float mMinVelocity;
  private final ViewGroup mParentView;
  private int mPointersDown;
  private boolean mReleaseInProgress;
  private ScrollerCompat mScroller;
  private final Runnable mSetIdleRunnable = new ViewDragHelper.2(this);
  private int mTouchSlop;
  private int mTrackingEdges;
  private VelocityTracker mVelocityTracker;
  private int scrollDirction = 1;
  
  private ViewDragHelper(Context paramContext, ViewGroup paramViewGroup, Callback paramCallback)
  {
    if (paramViewGroup == null) {
      throw new IllegalArgumentException("Parent view may not be null");
    }
    if (paramCallback == null) {
      throw new IllegalArgumentException("Callback may not be null");
    }
    this.mParentView = paramViewGroup;
    this.mCallback = paramCallback;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.mEdgeSize = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.mTouchSlop = paramViewGroup.getScaledTouchSlop();
    this.mMaxVelocity = paramViewGroup.getScaledMaximumFlingVelocity();
    this.mMinVelocity = paramViewGroup.getScaledMinimumFlingVelocity();
    this.mScroller = ScrollerCompat.create(paramContext, sInterpolator);
  }
  
  private boolean checkNewEdgeDrag(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (((this.mInitialEdgesTouched[paramInt1] & paramInt2) != paramInt2) || ((this.mTrackingEdges & paramInt2) == 0) || ((this.mEdgeDragsLocked[paramInt1] & paramInt2) == paramInt2) || ((this.mEdgeDragsInProgress[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.mTouchSlop) && (paramFloat2 <= this.mTouchSlop))) {}
    do
    {
      return false;
      if ((paramFloat1 < paramFloat2 * 0.5F) && (this.mCallback.onEdgeLock(paramInt2)))
      {
        int[] arrayOfInt = this.mEdgeDragsLocked;
        arrayOfInt[paramInt1] |= paramInt2;
        return false;
      }
    } while (((this.mEdgeDragsInProgress[paramInt1] & paramInt2) != 0) || (paramFloat1 <= this.mTouchSlop));
    return true;
  }
  
  private boolean checkTouchSlop(View paramView, float paramFloat1, float paramFloat2)
  {
    boolean bool = true;
    if (paramView == null) {
      bool = false;
    }
    label27:
    label80:
    label86:
    do
    {
      int j;
      do
      {
        return bool;
        int i;
        if (this.mCallback.getViewHorizontalDragRange(paramView) > 0)
        {
          i = 1;
          if (this.mCallback.getViewVerticalDragRange(paramView) <= 0) {
            break label80;
          }
        }
        for (j = 1;; j = 0)
        {
          if ((i == 0) || (j == 0)) {
            break label86;
          }
          if (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 > this.mTouchSlop * this.mTouchSlop) {
            break;
          }
          return false;
          i = 0;
          break label27;
        }
        if (i == 0) {
          break;
        }
      } while (Math.abs(paramFloat1) > this.mTouchSlop);
      return false;
      if (j == 0) {
        break;
      }
    } while (Math.abs(paramFloat2) > this.mTouchSlop);
    return false;
    return false;
  }
  
  private float clampMag(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f = Math.abs(paramFloat1);
    if (f < paramFloat2) {
      paramFloat2 = 0.0F;
    }
    do
    {
      return paramFloat2;
      if (f <= paramFloat3) {
        break;
      }
      paramFloat2 = paramFloat3;
    } while (paramFloat1 > 0.0F);
    return -paramFloat3;
    return paramFloat1;
  }
  
  private int clampMag(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = Math.abs(paramInt1);
    if (i < paramInt2) {
      paramInt2 = 0;
    }
    do
    {
      return paramInt2;
      if (i <= paramInt3) {
        break;
      }
      paramInt2 = paramInt3;
    } while (paramInt1 > 0);
    return -paramInt3;
    return paramInt1;
  }
  
  private void clearMotionHistory()
  {
    if (this.mInitialMotionX == null) {
      return;
    }
    Arrays.fill(this.mInitialMotionX, 0.0F);
    Arrays.fill(this.mInitialMotionY, 0.0F);
    Arrays.fill(this.mLastMotionX, 0.0F);
    Arrays.fill(this.mLastMotionY, 0.0F);
    Arrays.fill(this.mInitialEdgesTouched, 0);
    Arrays.fill(this.mEdgeDragsInProgress, 0);
    Arrays.fill(this.mEdgeDragsLocked, 0);
    this.mPointersDown = 0;
  }
  
  private void clearMotionHistory(int paramInt)
  {
    if ((this.mInitialMotionX == null) || (!isPointerDown(paramInt))) {
      return;
    }
    this.mInitialMotionX[paramInt] = 0.0F;
    this.mInitialMotionY[paramInt] = 0.0F;
    this.mLastMotionX[paramInt] = 0.0F;
    this.mLastMotionY[paramInt] = 0.0F;
    this.mInitialEdgesTouched[paramInt] = 0;
    this.mEdgeDragsInProgress[paramInt] = 0;
    this.mEdgeDragsLocked[paramInt] = 0;
    this.mPointersDown &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  private int computeAxisDuration(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return 0;
    }
    int i = this.mParentView.getWidth();
    int j = i / 2;
    float f3 = Math.min(1.0F, Math.abs(paramInt1) / i);
    float f1 = j;
    float f2 = j;
    f3 = distanceInfluenceForSnapDuration(f3);
    paramInt2 = Math.abs(paramInt2);
    if (paramInt2 > 0) {}
    for (paramInt1 = Math.round(Math.abs((f3 * f2 + f1) / paramInt2) * 1000.0F) * 4;; paramInt1 = (int)((Math.abs(paramInt1) / paramInt3 + 1.0F) * 256.0F)) {
      return Math.min(paramInt1, 600);
    }
  }
  
  private int computeSettleDuration(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = clampMag(paramInt3, (int)this.mMinVelocity, (int)this.mMaxVelocity);
    paramInt4 = clampMag(paramInt4, (int)this.mMinVelocity, (int)this.mMaxVelocity);
    int i = Math.abs(paramInt1);
    int j = Math.abs(paramInt2);
    int k = Math.abs(paramInt3);
    int m = Math.abs(paramInt4);
    int n = k + m;
    int i1 = i + j;
    float f1;
    if (paramInt3 != 0)
    {
      f1 = k / n;
      if (paramInt4 == 0) {
        break label165;
      }
    }
    label165:
    for (float f2 = m / n;; f2 = j / i1)
    {
      paramInt1 = computeAxisDuration(paramInt1, paramInt3, this.mCallback.getViewHorizontalDragRange(paramView));
      paramInt2 = computeAxisDuration(paramInt2, paramInt4, this.mCallback.getViewVerticalDragRange(paramView));
      float f3 = paramInt1;
      return (int)(f2 * paramInt2 + f1 * f3);
      f1 = i / i1;
      break;
    }
  }
  
  public static ViewDragHelper create(ViewGroup paramViewGroup, float paramFloat, Callback paramCallback)
  {
    paramViewGroup = create(paramViewGroup, paramCallback);
    paramViewGroup.mTouchSlop = ((int)(paramViewGroup.mTouchSlop * (1.0F / paramFloat)));
    return paramViewGroup;
  }
  
  public static ViewDragHelper create(ViewGroup paramViewGroup, Callback paramCallback)
  {
    return new ViewDragHelper(paramViewGroup.getContext(), paramViewGroup, paramCallback);
  }
  
  private void dispatchViewReleased(float paramFloat1, float paramFloat2, MotionEvent paramMotionEvent)
  {
    this.mReleaseInProgress = true;
    this.mCallback.onViewReleased(this.mCapturedView, paramFloat1, paramFloat2, paramMotionEvent);
    this.mReleaseInProgress = false;
    if (this.mDragState == 1) {
      setDragState(0);
    }
  }
  
  private float distanceInfluenceForSnapDuration(float paramFloat)
  {
    return (float)Math.sin((float)((paramFloat - 0.5F) * 0.47123891676382D));
  }
  
  private void dragTo(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = this.mCapturedView.getLeft();
    int j = this.mCapturedView.getTop();
    if (paramInt3 != 0)
    {
      paramInt1 = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, paramInt1, paramInt3);
      this.mCapturedView.offsetLeftAndRight(paramInt1 - i);
    }
    for (;;)
    {
      if (paramInt4 != 0)
      {
        paramInt2 = this.mCallback.clampViewPositionVertical(this.mCapturedView, paramInt2, paramInt4);
        this.mCapturedView.offsetTopAndBottom(paramInt2 - j);
      }
      for (;;)
      {
        if ((paramInt3 != 0) || (paramInt4 != 0)) {
          this.mCallback.onViewPositionChanged(this.mCapturedView, paramInt1, paramInt2, paramInt1 - i, paramInt2 - j);
        }
        return;
      }
    }
  }
  
  private void ensureMotionHistorySizeForId(int paramInt)
  {
    if ((this.mInitialMotionX == null) || (this.mInitialMotionX.length <= paramInt))
    {
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      float[] arrayOfFloat4 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.mInitialMotionX != null)
      {
        System.arraycopy(this.mInitialMotionX, 0, arrayOfFloat1, 0, this.mInitialMotionX.length);
        System.arraycopy(this.mInitialMotionY, 0, arrayOfFloat2, 0, this.mInitialMotionY.length);
        System.arraycopy(this.mLastMotionX, 0, arrayOfFloat3, 0, this.mLastMotionX.length);
        System.arraycopy(this.mLastMotionY, 0, arrayOfFloat4, 0, this.mLastMotionY.length);
        System.arraycopy(this.mInitialEdgesTouched, 0, arrayOfInt1, 0, this.mInitialEdgesTouched.length);
        System.arraycopy(this.mEdgeDragsInProgress, 0, arrayOfInt2, 0, this.mEdgeDragsInProgress.length);
        System.arraycopy(this.mEdgeDragsLocked, 0, arrayOfInt3, 0, this.mEdgeDragsLocked.length);
      }
      this.mInitialMotionX = arrayOfFloat1;
      this.mInitialMotionY = arrayOfFloat2;
      this.mLastMotionX = arrayOfFloat3;
      this.mLastMotionY = arrayOfFloat4;
      this.mInitialEdgesTouched = arrayOfInt1;
      this.mEdgeDragsInProgress = arrayOfInt2;
      this.mEdgeDragsLocked = arrayOfInt3;
    }
  }
  
  private boolean forceSettleCapturedViewAt(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = this.mCapturedView.getLeft();
    int j = this.mCapturedView.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.mScroller.abortAnimation();
      setDragState(0);
      return false;
    }
    paramInt3 = computeSettleDuration(this.mCapturedView, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mScroller.startScroll(i, j, paramInt1, paramInt2, paramInt3);
    setDragState(2);
    return true;
  }
  
  private int getEdgesTouched(int paramInt1, int paramInt2)
  {
    int j = 0;
    if (paramInt1 < this.mParentView.getLeft() + this.mEdgeSize) {
      j = 1;
    }
    int i = j;
    if (paramInt2 < this.mParentView.getTop() + this.mEdgeSize) {
      i = j | 0x4;
    }
    j = i;
    if (paramInt1 > this.mParentView.getRight() - this.mEdgeSize) {
      j = i | 0x2;
    }
    paramInt1 = j;
    if (paramInt2 > this.mParentView.getBottom() - this.mEdgeSize) {
      paramInt1 = j | 0x8;
    }
    return paramInt1;
  }
  
  private void handleProcessDownEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = paramMotionEvent.getPointerId(0);
    paramMotionEvent = findTopChildUnder((int)f1, (int)f2);
    saveInitialMotion(f1, f2, i);
    tryCaptureViewForDrag(paramMotionEvent, i);
    int j = this.mInitialEdgesTouched[i];
    if ((this.mTrackingEdges & j) != 0) {
      this.mCallback.onEdgeTouched(j & this.mTrackingEdges, i);
    }
  }
  
  private void handleProcessMoveEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    float f1;
    float f2;
    if (this.mDragState == 1)
    {
      if (!isValidPointerForActionMove(this.mActivePointerId)) {
        return;
      }
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      f1 = paramMotionEvent.getX(i);
      f2 = paramMotionEvent.getY(i);
      i = (int)(f1 - this.mLastMotionX[this.mActivePointerId]);
      j = (int)(f2 - this.mLastMotionY[this.mActivePointerId]);
      if (this.scrollDirction == 2)
      {
        f1 = this.mCapturedView.getHeight();
        f2 = i;
        i = (int)(f1 / this.mCapturedView.getWidth() * f2);
        dragTo(this.mCapturedView.getLeft(), this.mCapturedView.getTop() + i, 0, i);
      }
      for (;;)
      {
        saveLastMotion(paramMotionEvent);
        return;
        dragTo(this.mCapturedView.getLeft() + i, this.mCapturedView.getTop() + j, i, j);
      }
    }
    int j = paramMotionEvent.getPointerCount();
    int k;
    float f3;
    float f4;
    while (i < j)
    {
      k = paramMotionEvent.getPointerId(i);
      if (!isValidPointerForActionMove(k))
      {
        i += 1;
      }
      else
      {
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        f3 = f1 - this.mInitialMotionX[k];
        f4 = f2 - this.mInitialMotionY[k];
        reportNewEdgeDrags(f3, f4, k);
        if (this.mDragState != 1) {
          break label271;
        }
      }
    }
    for (;;)
    {
      saveLastMotion(paramMotionEvent);
      return;
      label271:
      View localView = findTopChildUnder((int)f1, (int)f2);
      if ((!checkTouchSlop(localView, f3, f4)) || (!tryCaptureViewForDrag(localView, k))) {
        break;
      }
    }
  }
  
  private void handleProcessPointerDownEvent(MotionEvent paramMotionEvent, int paramInt)
  {
    int i = paramMotionEvent.getPointerId(paramInt);
    float f1 = paramMotionEvent.getX(paramInt);
    float f2 = paramMotionEvent.getY(paramInt);
    saveInitialMotion(f1, f2, i);
    if (this.mDragState == 0)
    {
      tryCaptureViewForDrag(findTopChildUnder((int)f1, (int)f2), i);
      paramInt = this.mInitialEdgesTouched[i];
      if ((this.mTrackingEdges & paramInt) != 0) {
        this.mCallback.onEdgeTouched(paramInt & this.mTrackingEdges, i);
      }
    }
    while (!isCapturedViewUnder((int)f1, (int)f2)) {
      return;
    }
    tryCaptureViewForDrag(this.mCapturedView, i);
  }
  
  private void handleProcessPointerUpEvent(MotionEvent paramMotionEvent, int paramInt)
  {
    int i = paramMotionEvent.getPointerId(paramInt);
    if ((this.mDragState == 1) && (i == this.mActivePointerId))
    {
      int j = paramMotionEvent.getPointerCount();
      paramInt = 0;
      if (paramInt >= j) {
        break label125;
      }
      int k = paramMotionEvent.getPointerId(paramInt);
      if (k == this.mActivePointerId) {}
      float f1;
      float f2;
      do
      {
        paramInt += 1;
        break;
        f1 = paramMotionEvent.getX(paramInt);
        f2 = paramMotionEvent.getY(paramInt);
      } while ((findTopChildUnder((int)f1, (int)f2) != this.mCapturedView) || (!tryCaptureViewForDrag(this.mCapturedView, k)));
    }
    label125:
    for (paramInt = this.mActivePointerId;; paramInt = -1)
    {
      if (paramInt == -1) {
        releaseViewForPointerUp(paramMotionEvent);
      }
      clearMotionHistory(i);
      return;
    }
  }
  
  private void handleShouldInterceptDownEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = paramMotionEvent.getPointerId(0);
    saveInitialMotion(f1, f2, i);
    paramMotionEvent = findTopChildUnder((int)f1, (int)f2);
    if ((paramMotionEvent == this.mCapturedView) && (this.mDragState == 2)) {
      tryCaptureViewForDrag(paramMotionEvent, i);
    }
    int j = this.mInitialEdgesTouched[i];
    if ((this.mTrackingEdges & j) != 0) {
      this.mCallback.onEdgeTouched(j & this.mTrackingEdges, i);
    }
  }
  
  private void handleShouldInterceptMoveEvent(MotionEvent paramMotionEvent)
  {
    if ((this.mInitialMotionX == null) || (this.mInitialMotionY == null)) {
      return;
    }
    int k = paramMotionEvent.getPointerCount();
    int i = 0;
    int m;
    float f3;
    float f4;
    View localView;
    int j;
    while (i < k)
    {
      m = paramMotionEvent.getPointerId(i);
      if (!isValidPointerForActionMove(m))
      {
        i += 1;
      }
      else
      {
        float f1 = paramMotionEvent.getX(i);
        float f2 = paramMotionEvent.getY(i);
        f3 = f1 - this.mInitialMotionX[m];
        f4 = f2 - this.mInitialMotionY[m];
        localView = findTopChildUnder((int)f1, (int)f2);
        if ((localView == null) || (!checkTouchSlop(localView, f3, f4))) {
          break label253;
        }
        j = 1;
        label124:
        if (j == 0) {
          break label259;
        }
        int n = localView.getLeft();
        int i1 = (int)f3;
        i1 = this.mCallback.clampViewPositionHorizontal(localView, i1 + n, (int)f3);
        int i2 = localView.getTop();
        int i3 = (int)f4;
        i3 = this.mCallback.clampViewPositionVertical(localView, i3 + i2, (int)f4);
        int i4 = this.mCallback.getViewHorizontalDragRange(localView);
        int i5 = this.mCallback.getViewVerticalDragRange(localView);
        if (((i4 != 0) && ((i4 <= 0) || (i1 != n))) || ((i5 != 0) && ((i5 <= 0) || (i3 != i2)))) {
          break label259;
        }
      }
    }
    for (;;)
    {
      saveLastMotion(paramMotionEvent);
      return;
      label253:
      j = 0;
      break label124;
      label259:
      reportNewEdgeDrags(f3, f4, m);
      if (this.mDragState != 1) {
        if ((j == 0) || (!tryCaptureViewForDrag(localView, m))) {
          break;
        }
      }
    }
  }
  
  private void handleShouldInterceptPointerDownEvent(MotionEvent paramMotionEvent, int paramInt)
  {
    int i = paramMotionEvent.getPointerId(paramInt);
    float f1 = paramMotionEvent.getX(paramInt);
    float f2 = paramMotionEvent.getY(paramInt);
    saveInitialMotion(f1, f2, i);
    if (this.mDragState == 0)
    {
      paramInt = this.mInitialEdgesTouched[i];
      if ((this.mTrackingEdges & paramInt) != 0) {
        this.mCallback.onEdgeTouched(paramInt & this.mTrackingEdges, i);
      }
    }
    do
    {
      do
      {
        return;
      } while (this.mDragState != 2);
      paramMotionEvent = findTopChildUnder((int)f1, (int)f2);
    } while (paramMotionEvent != this.mCapturedView);
    tryCaptureViewForDrag(paramMotionEvent, i);
  }
  
  private boolean isValidPointerForActionMove(int paramInt)
  {
    return isPointerDown(paramInt);
  }
  
  private void releaseViewForPointerUp(MotionEvent paramMotionEvent)
  {
    this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
    dispatchViewReleased(clampMag(VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), clampMag(VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), paramMotionEvent);
  }
  
  private void reportNewEdgeDrags(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 1;
    if (checkNewEdgeDrag(paramFloat1, paramFloat2, paramInt, 1)) {}
    for (;;)
    {
      int i = j;
      if (checkNewEdgeDrag(paramFloat2, paramFloat1, paramInt, 4)) {
        i = j | 0x4;
      }
      j = i;
      if (checkNewEdgeDrag(paramFloat1, paramFloat2, paramInt, 2)) {
        j = i | 0x2;
      }
      i = j;
      if (checkNewEdgeDrag(paramFloat2, paramFloat1, paramInt, 8)) {
        i = j | 0x8;
      }
      if (i != 0)
      {
        int[] arrayOfInt = this.mEdgeDragsInProgress;
        arrayOfInt[paramInt] |= i;
        this.mCallback.onEdgeDragStarted(i, paramInt);
      }
      return;
      j = 0;
    }
  }
  
  private void saveInitialMotion(float paramFloat1, float paramFloat2, int paramInt)
  {
    ensureMotionHistorySizeForId(paramInt);
    float[] arrayOfFloat = this.mInitialMotionX;
    this.mLastMotionX[paramInt] = paramFloat1;
    arrayOfFloat[paramInt] = paramFloat1;
    arrayOfFloat = this.mInitialMotionY;
    this.mLastMotionY[paramInt] = paramFloat2;
    arrayOfFloat[paramInt] = paramFloat2;
    this.mInitialEdgesTouched[paramInt] = getEdgesTouched((int)paramFloat1, (int)paramFloat2);
    this.mPointersDown |= 1 << paramInt;
  }
  
  private void saveLastMotion(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    if (i < j)
    {
      int k = paramMotionEvent.getPointerId(i);
      if (!isValidPointerForActionMove(k)) {}
      for (;;)
      {
        i += 1;
        break;
        float f1 = paramMotionEvent.getX(i);
        float f2 = paramMotionEvent.getY(i);
        this.mLastMotionX[k] = f1;
        this.mLastMotionY[k] = f2;
      }
    }
  }
  
  public void abort()
  {
    cancel();
    if (this.mDragState == 2)
    {
      int i = this.mScroller.getCurrX();
      int j = this.mScroller.getCurrY();
      this.mScroller.abortAnimation();
      int k = this.mScroller.getCurrX();
      int m = this.mScroller.getCurrY();
      this.mCallback.onViewPositionChanged(this.mCapturedView, k, m, k - i, m - j);
    }
    setDragState(0);
  }
  
  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = paramView.getScrollX();
      int k = paramView.getScrollY();
      int i = localViewGroup.getChildCount() - 1;
      while (i >= 0)
      {
        View localView = localViewGroup.getChildAt(i);
        if ((paramInt3 + j >= localView.getLeft()) && (paramInt3 + j < localView.getRight()) && (paramInt4 + k >= localView.getTop()) && (paramInt4 + k < localView.getBottom()) && (canScroll(localView, true, paramInt1, paramInt2, paramInt3 + j - localView.getLeft(), paramInt4 + k - localView.getTop()))) {
          return true;
        }
        i -= 1;
      }
    }
    return (paramBoolean) && ((ViewCompat.canScrollHorizontally(paramView, -paramInt1)) || (ViewCompat.canScrollVertically(paramView, -paramInt2)));
  }
  
  public void cancel()
  {
    this.mActivePointerId = -1;
    clearMotionHistory();
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  public void captureChildView(View paramView, int paramInt)
  {
    if (paramView.getParent() != this.mParentView) {
      throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.mParentView + ")");
    }
    this.mCapturedView = paramView;
    this.mActivePointerId = paramInt;
    this.mCallback.onViewCaptured(paramView, paramInt);
    setDragState(1);
  }
  
  public boolean checkTouchSlop(int paramInt)
  {
    boolean bool2 = false;
    int j = this.mInitialMotionX.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (checkTouchSlop(paramInt, i)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean checkTouchSlop(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (!isPointerDown(paramInt2)) {
      bool = false;
    }
    label27:
    float f2;
    label105:
    label110:
    do
    {
      float f1;
      do
      {
        return bool;
        int i;
        if ((paramInt1 & 0x1) == 1)
        {
          i = 1;
          if ((paramInt1 & 0x2) != 2) {
            break label105;
          }
        }
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          f1 = this.mLastMotionX[paramInt2] - this.mInitialMotionX[paramInt2];
          f2 = this.mLastMotionY[paramInt2] - this.mInitialMotionY[paramInt2];
          if ((i == 0) || (paramInt1 == 0)) {
            break label110;
          }
          if (f1 * f1 + f2 * f2 > this.mTouchSlop * this.mTouchSlop) {
            break;
          }
          return false;
          i = 0;
          break label27;
        }
        if (i == 0) {
          break;
        }
      } while (Math.abs(f1) > this.mTouchSlop);
      return false;
      if (paramInt1 == 0) {
        break;
      }
    } while (Math.abs(f2) > this.mTouchSlop);
    return false;
    return false;
  }
  
  public boolean continueSettling(boolean paramBoolean)
  {
    boolean bool;
    if (this.mDragState == 2)
    {
      bool = this.mScroller.computeScrollOffset();
      int i = this.mScroller.getCurrX();
      int j = this.mScroller.getCurrY();
      int k = i - this.mCapturedView.getLeft();
      int m = j - this.mCapturedView.getTop();
      if (k != 0) {
        this.mCapturedView.offsetLeftAndRight(k);
      }
      if (m != 0) {
        this.mCapturedView.offsetTopAndBottom(m);
      }
      if ((k != 0) || (m != 0)) {
        this.mCallback.onViewPositionChanged(this.mCapturedView, i, j, k, m);
      }
      if ((!bool) || (i != this.mScroller.getFinalX()) || (j != this.mScroller.getFinalY())) {
        break label188;
      }
      this.mScroller.abortAnimation();
      bool = false;
    }
    label178:
    label188:
    for (;;)
    {
      if (!bool)
      {
        if (!paramBoolean) {
          break label178;
        }
        this.mParentView.post(this.mSetIdleRunnable);
      }
      while (this.mDragState == 2)
      {
        return true;
        setDragState(0);
      }
      return false;
    }
  }
  
  public View findTopChildUnder(int paramInt1, int paramInt2)
  {
    int i = this.mParentView.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(i));
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom())) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  public void flingCapturedView(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.mReleaseInProgress) {
      throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    }
    this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int)VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int)VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), paramInt1, paramInt3, paramInt2, paramInt4);
    setDragState(2);
  }
  
  public int getActivePointerId()
  {
    return this.mActivePointerId;
  }
  
  public View getCapturedView()
  {
    return this.mCapturedView;
  }
  
  public int getEdgeSize()
  {
    return this.mEdgeSize;
  }
  
  public float getMinVelocity()
  {
    return this.mMinVelocity;
  }
  
  public int getScrollDirction()
  {
    return this.scrollDirction;
  }
  
  public int getTouchSlop()
  {
    return this.mTouchSlop;
  }
  
  public int getViewDragState()
  {
    return this.mDragState;
  }
  
  public boolean isCapturedViewUnder(int paramInt1, int paramInt2)
  {
    return isViewUnder(this.mCapturedView, paramInt1, paramInt2);
  }
  
  public boolean isEdgeTouched(int paramInt)
  {
    boolean bool2 = false;
    int j = this.mInitialEdgesTouched.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (isEdgeTouched(paramInt, i)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean isEdgeTouched(int paramInt1, int paramInt2)
  {
    return (isPointerDown(paramInt2)) && ((this.mInitialEdgesTouched[paramInt2] & paramInt1) != 0);
  }
  
  public boolean isPointerDown(int paramInt)
  {
    return (this.mPointersDown & 1 << paramInt) != 0;
  }
  
  public boolean isViewUnder(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {}
    while ((paramInt1 < paramView.getLeft()) || (paramInt1 >= paramView.getRight()) || (paramInt2 < paramView.getTop()) || (paramInt2 >= paramView.getBottom())) {
      return false;
    }
    return true;
  }
  
  public void processTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    int j = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (i == 0) {
      cancel();
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    switch (i)
    {
    case 4: 
    default: 
      return;
    case 0: 
      handleProcessDownEvent(paramMotionEvent);
      return;
    case 5: 
      handleProcessPointerDownEvent(paramMotionEvent, j);
      return;
    case 2: 
      handleProcessMoveEvent(paramMotionEvent);
      return;
    case 6: 
      handleProcessPointerUpEvent(paramMotionEvent, j);
      return;
    case 1: 
      if (this.mDragState == 1) {
        releaseViewForPointerUp(paramMotionEvent);
      }
      cancel();
      return;
    }
    if (this.mDragState == 1) {
      dispatchViewReleased(0.0F, 0.0F, paramMotionEvent);
    }
    cancel();
  }
  
  void setDragState(int paramInt)
  {
    this.mParentView.removeCallbacks(this.mSetIdleRunnable);
    if (this.mDragState != paramInt)
    {
      this.mDragState = paramInt;
      this.mCallback.onViewDragStateChanged(paramInt);
      if (this.mDragState == 0) {
        this.mCapturedView = null;
      }
    }
  }
  
  public void setEdgeTrackingEnabled(int paramInt)
  {
    this.mTrackingEdges = paramInt;
  }
  
  public void setMinVelocity(float paramFloat)
  {
    this.mMinVelocity = paramFloat;
  }
  
  public void setScrollDirection(int paramInt)
  {
    this.scrollDirction = paramInt;
  }
  
  public boolean settleCapturedViewAt(int paramInt1, int paramInt2)
  {
    if (!this.mReleaseInProgress) {
      throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }
    return forceSettleCapturedViewAt(paramInt1, paramInt2, (int)VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int)VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId));
  }
  
  public void settleCapturedViewImmediately(View paramView, int paramInt1, int paramInt2)
  {
    this.mCapturedView = paramView;
    int i = paramView.getLeft();
    int j = paramView.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.mScroller.abortAnimation();
      return;
    }
    this.mScroller.startScroll(i, j, paramInt1, paramInt2, 0);
    setDragState(2);
  }
  
  public boolean shouldInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    int j = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (i == 0) {
      cancel();
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    switch (i)
    {
    }
    while (this.mDragState == 1)
    {
      return true;
      handleShouldInterceptDownEvent(paramMotionEvent);
      continue;
      handleShouldInterceptPointerDownEvent(paramMotionEvent, j);
      continue;
      handleShouldInterceptMoveEvent(paramMotionEvent);
      continue;
      clearMotionHistory(paramMotionEvent.getPointerId(j));
      continue;
      cancel();
    }
    return false;
  }
  
  public boolean smoothSlideViewTo(View paramView, int paramInt1, int paramInt2)
  {
    this.mCapturedView = paramView;
    this.mActivePointerId = -1;
    boolean bool = forceSettleCapturedViewAt(paramInt1, paramInt2, 0, 0);
    if ((!bool) && (this.mDragState == 0) && (this.mCapturedView != null)) {
      this.mCapturedView = null;
    }
    return bool;
  }
  
  boolean tryCaptureViewForDrag(View paramView, int paramInt)
  {
    if ((paramView == this.mCapturedView) && (this.mActivePointerId == paramInt)) {
      return true;
    }
    if ((paramView != null) && (this.mCallback.tryCaptureView(paramView, paramInt)))
    {
      this.mActivePointerId = paramInt;
      captureChildView(paramView, paramInt);
      return true;
    }
    return false;
  }
  
  public static abstract class Callback
  {
    public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
    {
      return 0;
    }
    
    public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
    {
      return 0;
    }
    
    public int getOrderedChildIndex(int paramInt)
    {
      return paramInt;
    }
    
    public int getViewHorizontalDragRange(View paramView)
    {
      return 0;
    }
    
    public int getViewVerticalDragRange(View paramView)
    {
      return 0;
    }
    
    public void onEdgeDragStarted(int paramInt1, int paramInt2) {}
    
    public boolean onEdgeLock(int paramInt)
    {
      return false;
    }
    
    public void onEdgeTouched(int paramInt1, int paramInt2) {}
    
    public void onViewCaptured(View paramView, int paramInt) {}
    
    public void onViewDragStateChanged(int paramInt) {}
    
    public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public void onViewReleased(View paramView, float paramFloat1, float paramFloat2, MotionEvent paramMotionEvent) {}
    
    public abstract boolean tryCaptureView(View paramView, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.swipe.ViewDragHelper
 * JD-Core Version:    0.7.0.1
 */