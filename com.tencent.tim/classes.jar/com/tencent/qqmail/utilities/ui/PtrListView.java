package com.tencent.qqmail.utilities.ui;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import com.tencent.qqmail.advertise.AdvertiseManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.view.QMRefreshingView;
import java.lang.reflect.Field;
import java.util.Date;
import moai.oss.KvHelper;

public class PtrListView
  extends InsertionListView
{
  public static final int HIT_PULL_DOWN_AD_THRESHOLD = 0;
  public static final int REFRESH_TO_ADVERTISE_THRESHOLD = 200;
  public static final int SCROLL_STATE_END_TOUCH_PULL = 101;
  public static final int SCROLL_STATE_START_TOUCH_PULL = 100;
  private static final int STATE_ANIMATING = 4;
  private static final int STATE_PULL_TO_REFRESH = 0;
  private static final int STATE_REFRESHING = 5;
  private static final int STATE_REFRESHING_PULLDOWN_AGAIN = 6;
  private static final int STATE_RELEASE_TO_ADVERTISE = 3;
  private static final int STATE_RELEASE_TO_PULL = 1;
  private static final int STATE_RELEASE_TO_REFRESH = 2;
  private static final String TAG = "PtrListView";
  private static final float howEasyToPull = 0.48F;
  private boolean advertiseMode = false;
  private boolean arrowFlag = false;
  private boolean isPopularizing = false;
  private ListAdapter mAdapter;
  private boolean mIsDelaying;
  private boolean mIsEnabledPullToRefresh = true;
  private boolean mIsRefreshCancelled;
  private boolean mIsTouchMoving = false;
  private OnRefreshCompleteListener mOnRefreshCompleteListener;
  private OnRefreshListener mOnRefreshListener;
  private AbsListView.OnScrollListener mOnScrollListener;
  private int mOriginRefreshBarHeight;
  private long mRefreshStart = 0L;
  private AbsListView.LayoutParams mRefreshViewParams;
  private QMRefreshingView mRefreshingView;
  private float mStartDownX;
  private float mStartDownY;
  private float mStartY = -1.0F;
  private int mState = 0;
  private Runnable onRefreshCompleteRunnable = null;
  
  public PtrListView(Context paramContext)
  {
    super(paramContext);
    init();
    setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -1));
  }
  
  public PtrListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PtrListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
    setDropdownView();
  }
  
  private void animateHeader(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    animateHeader(paramInt1, paramBoolean, paramInt2, 200);
  }
  
  private void animateHeader(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    if (this.mOnRefreshListener == null) {
      return;
    }
    this.mState = 4;
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.mRefreshViewParams.height, paramInt1 });
    localValueAnimator.setStartDelay(paramInt2);
    localValueAnimator.setDuration(paramInt3);
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localValueAnimator.addUpdateListener(new PtrListView.2(this));
    getHeaderViewsCount();
    localValueAnimator.addListener(new PtrListView.3(this, paramBoolean));
    localValueAnimator.start();
  }
  
  private void cancelPressed(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent != null)
    {
      paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
      paramMotionEvent.setAction(3);
      super.dispatchTouchEvent(paramMotionEvent);
    }
    int j = getHeaderViewsCount();
    int i = getFirstVisiblePosition();
    while (i < getLastVisiblePosition())
    {
      paramMotionEvent = getChildAt(i + j);
      if (paramMotionEvent != null)
      {
        paramMotionEvent.setPressed(false);
        paramMotionEvent.setSelected(false);
      }
      i += 1;
    }
    try
    {
      paramMotionEvent = AbsListView.class.getDeclaredField("mMotionPosition");
      paramMotionEvent.setAccessible(true);
      paramMotionEvent.set(this, Integer.valueOf(-1));
      return;
    }
    catch (Exception paramMotionEvent)
    {
      QMLog.log(6, "mMotionPosition:", paramMotionEvent.toString());
    }
  }
  
  private void init()
  {
    setVerticalFadingEdgeEnabled(false);
    setDividerHeight(0);
  }
  
  private void invokeOnItemScrollListener(int paramInt)
  {
    if (this.mOnScrollListener != null) {
      this.mOnScrollListener.onScrollStateChanged(this, paramInt);
    }
  }
  
  public void ariseUpListViewContent()
  {
    if (this.mRefreshingView != null) {
      this.mRefreshingView.rotate(false);
    }
    this.mState = 0;
    this.mRefreshViewParams.height = 0;
    this.mRefreshingView.setLayoutParams(this.mRefreshViewParams);
  }
  
  public Bitmap buildBodyCache()
  {
    buildDrawingCache();
    Bitmap localBitmap = getDrawingCache();
    int i = getResources().getDimensionPixelSize(2131299361);
    return Bitmap.createBitmap(localBitmap, 0, i, localBitmap.getWidth(), localBitmap.getHeight() - i);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    catch (IndexOutOfBoundsException paramCanvas) {}
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    switch (paramMotionEvent.getAction())
    {
    }
    try
    {
      label147:
      label354:
      label637:
      do
      {
        for (;;)
        {
          bool1 = super.dispatchTouchEvent(paramMotionEvent);
          int i;
          do
          {
            return bool1;
            if ((getFirstVisiblePosition() == 0) && ((getChildAt(0) == null) || (getChildAt(0).getTop() == 0))) {}
            for (i = 1;; i = 0)
            {
              if ((this.mOnRefreshListener != null) && (this.mRefreshingView != null) && (this.mIsEnabledPullToRefresh) && (this.mState != 4) && (!this.isPopularizing)) {
                break label147;
              }
              if (i != 0)
              {
                bool1 = bool3;
                if (paramMotionEvent.getRawY() - this.mStartDownY > 0.0F) {
                  break;
                }
              }
              return super.dispatchTouchEvent(paramMotionEvent);
            }
            if (Math.abs(paramMotionEvent.getRawX() - this.mStartDownX) > 200.0F) {
              cancelPressed(null);
            }
            if (this.mState != 5) {
              break label258;
            }
            if (this.mStartDownY - paramMotionEvent.getRawY() <= 0.0F) {
              break;
            }
            bool1 = bool3;
          } while (this.mStartDownY - paramMotionEvent.getRawY() < this.mRefreshViewParams.height / 2);
          this.mIsDelaying = false;
          this.mRefreshStart = 0L;
          onRefreshComplete();
          continue;
          if ((this.advertiseMode) && (i != 0))
          {
            this.mState = 6;
            continue;
            if ((this.mState == 6) || (this.mState == 1) || (this.mState == 2) || ((i != 0) && ((int)(paramMotionEvent.getRawY() - this.mStartDownY) > 15)))
            {
              if (((this.mState == 1) || (this.mState == 2)) || (this.mStartY == -1.0F))
              {
                if (this.mState == 6)
                {
                  this.mStartY = (paramMotionEvent.getRawY() - this.mOriginRefreshBarHeight / 0.48F);
                  cancelPressed(paramMotionEvent);
                }
              }
              else
              {
                f = (paramMotionEvent.getRawY() - this.mStartY) * 0.48F;
                if (this.mState == 6) {
                  this.mState = 2;
                }
                this.mRefreshViewParams.height = ((int)f);
                this.mRefreshingView.setLayoutParams(this.mRefreshViewParams);
                if (f <= 0.0F) {
                  break label684;
                }
                this.mRefreshingView.setVisibility(0);
                if (f < this.mOriginRefreshBarHeight) {
                  break label645;
                }
                if (this.mState != 2)
                {
                  this.mState = 2;
                  invokeOnItemScrollListener(100);
                }
                if (this.advertiseMode) {}
                this.mRefreshingView.updatePosition(1.0F);
                if ((!this.advertiseMode) || (!this.mRefreshingView.getAdvertiseMode()) || (f <= this.mOriginRefreshBarHeight + this.mRefreshingView.getAdvertiseBmpHeight() + 0)) {
                  break label637;
                }
                this.mState = 3;
                if (this.arrowFlag) {
                  this.mRefreshingView.playArrow();
                }
              }
              for (this.arrowFlag = false;; this.arrowFlag = true)
              {
                bool1 = bool3;
                if (!this.advertiseMode) {
                  break;
                }
                bool1 = bool3;
                if (!this.mRefreshingView.getAdvertiseMode()) {
                  break;
                }
                bool1 = bool3;
                if (f <= this.mOriginRefreshBarHeight + this.mRefreshingView.getAdvertiseBmpHeight() / 5) {
                  break;
                }
                Log.i("PtrListView", "Hit pulldown icon show-line");
                bool1 = bool3;
                if (AdvertiseManager.getInstance().isShowPullDownIcon()) {
                  break;
                }
                Log.i("PtrListView", "log pulldown icon show-line");
                DataCollector.logEvent("Event_Effect_Pull_Refresh_Loading_Show");
                KvHelper.eventPulldownIconShow(new double[0]);
                AdvertiseManager.getInstance().setShowPullDownIcon(true);
                return true;
                this.mStartY = paramMotionEvent.getRawY();
                break label354;
              }
              if (this.mState != 1)
              {
                this.mState = 1;
                invokeOnItemScrollListener(100);
              }
              float f = f * 1.0F / this.mOriginRefreshBarHeight;
              this.mRefreshingView.updatePosition(f);
              return true;
              if (this.mState != 0)
              {
                this.mState = 0;
                invokeOnItemScrollListener(101);
              }
              this.mRefreshingView.setVisibility(8);
              continue;
              this.mIsTouchMoving = true;
              this.isPopularizing = false;
              this.mStartDownX = paramMotionEvent.getRawX();
              this.mStartDownY = paramMotionEvent.getRawY();
              this.mStartY = -1.0F;
              if ((this.mState == 5) || (this.mState == 4)) {
                cancelPressed(paramMotionEvent);
              }
            }
          }
        }
        this.mIsTouchMoving = false;
        this.mStartY = -1.0F;
        AdvertiseManager.getInstance().setShowPullDownIcon(false);
      } while ((this.mState != 1) && (this.mState != 2) && (this.mState != 3));
      label258:
      label645:
      label684:
      invokeOnItemScrollListener(101);
      if (this.mState == 2)
      {
        animateHeader(this.mOriginRefreshBarHeight, true, 0);
        this.mRefreshStart = new Date().getTime();
      }
      for (;;)
      {
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        return true;
        if (this.mState == 3)
        {
          if (this.advertiseMode) {
            animateHeader(0, false, 600);
          }
          for (;;)
          {
            this.mRefreshStart = new Date().getTime();
            if (!this.advertiseMode) {
              break;
            }
            this.mOnRefreshListener.onPopulate();
            break;
            animateHeader(this.mOriginRefreshBarHeight, true, 0);
          }
        }
        this.mRefreshingView.setVisibility(4);
        animateHeader(0, false, 0);
      }
    }
    catch (Exception paramMotionEvent)
    {
      for (;;)
      {
        QMLog.log(6, "PtrListView", "dispatchTouchEvent exception : " + paramMotionEvent.getMessage());
        boolean bool1 = bool2;
      }
    }
  }
  
  public void dropDownListViewContent()
  {
    animateHeader(getHeight(), false, 0, 600);
  }
  
  public boolean getAdvertiseMode()
  {
    return this.advertiseMode;
  }
  
  public int getRefreshBarHeight()
  {
    return this.mRefreshViewParams.height;
  }
  
  public boolean isRefreshing()
  {
    return this.mState == 5;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mState == 5) {
      return;
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mIsTouchMoving)
    {
      super.onOverScrolled(0, 0, false, false);
      return;
    }
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }
  
  public boolean onRefreshComplete()
  {
    if (this.mState == 5)
    {
      if (this.onRefreshCompleteRunnable != null) {
        Threads.removeCallbackOnMain(this.onRefreshCompleteRunnable);
      }
      this.onRefreshCompleteRunnable = new PtrListView.1(this);
      Threads.runOnMainThread(this.onRefreshCompleteRunnable, 1300L);
      return true;
    }
    return false;
  }
  
  public void onRefreshCompleteWithoutAnimation()
  {
    Log.v("eamonwu", "onRefreshComplete,mState:" + this.mState);
    if ((this.mState == 5) || (this.mState == 6))
    {
      if (this.mRefreshingView != null) {
        this.mRefreshingView.rotate(false);
      }
      this.mState = 0;
      this.mRefreshViewParams.height = 0;
      this.mRefreshingView.setLayoutParams(this.mRefreshViewParams);
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    this.mAdapter = paramListAdapter;
  }
  
  public void setAdvertiseMode(boolean paramBoolean)
  {
    QMLog.log(4, "PtrListView", "setAdvertiseMode " + paramBoolean);
    this.advertiseMode = paramBoolean;
    this.mRefreshingView.setAdvertiseMode(paramBoolean);
    this.advertiseMode = this.mRefreshingView.getAdvertiseMode();
  }
  
  public void setDropdownView()
  {
    this.mRefreshingView = new QMRefreshingView(getContext());
    addHeaderView(this.mRefreshingView, null, false);
    this.mOriginRefreshBarHeight = getContext().getResources().getDimensionPixelSize(2131299306);
    this.mRefreshViewParams = ((AbsListView.LayoutParams)this.mRefreshingView.getLayoutParams());
    this.mRefreshingView.setClickable(false);
    this.mRefreshingView.setEnabled(false);
  }
  
  public void setDropdownViewBackgroundColor(int paramInt)
  {
    this.mRefreshingView.setBackgroundColor(paramInt);
  }
  
  public void setEnablePullToRefresh(boolean paramBoolean)
  {
    this.mIsEnabledPullToRefresh = paramBoolean;
  }
  
  public void setOnRefreshCompleteListener(OnRefreshCompleteListener paramOnRefreshCompleteListener)
  {
    this.mOnRefreshCompleteListener = paramOnRefreshCompleteListener;
  }
  
  public void setOnRefreshListener(OnRefreshListener paramOnRefreshListener)
  {
    this.mOnRefreshListener = paramOnRefreshListener;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.mOnScrollListener = paramOnScrollListener;
    super.setOnScrollListener(paramOnScrollListener);
  }
  
  @SuppressLint({"NewApi"})
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 11)
    {
      super.smoothScrollToPositionFromTop(paramInt1, paramInt2);
      return;
    }
    if (i >= 8)
    {
      new PositionScroller().startWithOffset(paramInt1, paramInt2);
      return;
    }
    QMLog.log(5, "PtrListView", "scrollToPosition not working, because API level is under 8, current is " + i);
    setSelectionFromTop(paramInt1, paramInt2);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 11)
    {
      super.smoothScrollToPositionFromTop(paramInt1, paramInt2, paramInt3);
      return;
    }
    if (i >= 8)
    {
      new PositionScroller().startWithOffset(paramInt1, paramInt2, paramInt3);
      return;
    }
    QMLog.log(5, "PtrListView", "scrollToPosition not working, because API level is under 8, current is " + i);
    setSelectionFromTop(paramInt1, paramInt2);
  }
  
  public static abstract interface OnRefreshCompleteListener
  {
    public abstract void onAnimationEnd();
  }
  
  public static abstract class OnRefreshListener
  {
    public void onPopulate() {}
    
    public abstract void onRefresh();
    
    public void preloadPopulate() {}
  }
  
  class PositionScroller
    implements Runnable
  {
    private static final int MOVE_DOWN_BOUND = 3;
    private static final int MOVE_DOWN_POS = 1;
    private static final int MOVE_OFFSET = 5;
    private static final int MOVE_UP_BOUND = 4;
    private static final int MOVE_UP_POS = 2;
    private static final int SCROLL_DURATION = 400;
    private int mBoundPos;
    private final int mExtraScroll = ViewConfiguration.get(PtrListView.this.getContext()).getScaledFadingEdgeLength();
    private int mLastSeenPos;
    private int mMode;
    private int mOffsetFromTop;
    private int mScrollDuration;
    private int mTargetPos;
    
    PositionScroller() {}
    
    public void run()
    {
      int i = 0;
      int k = PtrListView.this.getHeight();
      int j = PtrListView.this.getFirstVisiblePosition();
      switch (this.mMode)
      {
      default: 
      case 1: 
      case 3: 
      case 2: 
      case 4: 
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    i = PtrListView.this.getChildCount() - 1;
                    j += i;
                  } while (i < 0);
                  if (j == this.mLastSeenPos)
                  {
                    PtrListView.this.post(this);
                    return;
                  }
                  localView = PtrListView.this.getChildAt(i);
                  m = localView.getHeight();
                  n = localView.getTop();
                  if (j < PtrListView.this.getCount() - 1) {}
                  for (i = this.mExtraScroll;; i = PtrListView.this.getListPaddingBottom())
                  {
                    PtrListView.this.smoothScrollBy(i + (m - (k - n)), this.mScrollDuration);
                    this.mLastSeenPos = j;
                    if (j >= this.mTargetPos) {
                      break;
                    }
                    PtrListView.this.post(this);
                    return;
                  }
                  i = PtrListView.this.getChildCount();
                } while ((j == this.mBoundPos) || (i <= 1) || (i + j >= PtrListView.this.getCount()));
                i = j + 1;
                if (i == this.mLastSeenPos)
                {
                  PtrListView.this.post(this);
                  return;
                }
                localView = PtrListView.this.getChildAt(1);
                j = localView.getHeight();
                k = localView.getTop();
                m = this.mExtraScroll;
                if (i < this.mBoundPos)
                {
                  PtrListView.this.smoothScrollBy(Math.max(0, k + j - m), this.mScrollDuration);
                  this.mLastSeenPos = i;
                  PtrListView.this.post(this);
                  return;
                }
              } while (k <= m);
              PtrListView.this.smoothScrollBy(k - m, this.mScrollDuration);
              return;
              if (j == this.mLastSeenPos)
              {
                PtrListView.this.post(this);
                return;
              }
              localView = PtrListView.this.getChildAt(0);
            } while (localView == null);
            k = localView.getTop();
            if (j > 0) {}
            for (i = this.mExtraScroll;; i = PtrListView.this.getListPaddingTop())
            {
              PtrListView.this.smoothScrollBy(k - i, this.mScrollDuration);
              this.mLastSeenPos = j;
              if (j <= this.mTargetPos) {
                break;
              }
              PtrListView.this.post(this);
              return;
            }
            m = PtrListView.this.getChildCount() - 2;
          } while (m < 0);
          i = j + m;
          if (i == this.mLastSeenPos)
          {
            PtrListView.this.post(this);
            return;
          }
          View localView = PtrListView.this.getChildAt(m);
          j = localView.getHeight();
          m = localView.getTop();
          this.mLastSeenPos = i;
          if (i > this.mBoundPos)
          {
            PtrListView.this.smoothScrollBy(-(k - m - this.mExtraScroll), this.mScrollDuration);
            PtrListView.this.post(this);
            return;
          }
          i = k - this.mExtraScroll;
          j = m + j;
        } while (i <= j);
        PtrListView.this.smoothScrollBy(-(i - j), this.mScrollDuration);
        return;
      }
      if (this.mLastSeenPos == j)
      {
        PtrListView.this.post(this);
        return;
      }
      this.mLastSeenPos = j;
      k = PtrListView.this.getChildCount();
      int m = this.mTargetPos;
      int n = j + k - 1;
      if (m < j) {
        i = j - m + 1;
      }
      float f;
      for (;;)
      {
        f = Math.min(Math.abs(i / k), 1.0F);
        if (m >= j) {
          break;
        }
        PtrListView.this.smoothScrollBy((int)(f * -PtrListView.this.getHeight()), this.mScrollDuration);
        PtrListView.this.post(this);
        return;
        if (m > n) {
          i = m - n;
        }
      }
      if (m > n)
      {
        PtrListView.this.smoothScrollBy((int)(f * PtrListView.this.getHeight()), this.mScrollDuration);
        PtrListView.this.post(this);
        return;
      }
      i = PtrListView.this.getChildAt(m - j).getTop() - this.mOffsetFromTop;
      PtrListView.this.smoothScrollBy(i, (int)(this.mScrollDuration * (i / PtrListView.this.getHeight())));
    }
    
    void start(int paramInt)
    {
      stop();
      int i = PtrListView.this.getFirstVisiblePosition();
      int j = PtrListView.this.getChildCount() + i - 1;
      if (paramInt <= i)
      {
        i = i - paramInt + 1;
        this.mMode = 2;
        if (i <= 0) {
          break label97;
        }
      }
      label97:
      for (this.mScrollDuration = (400 / i);; this.mScrollDuration = 400)
      {
        this.mTargetPos = paramInt;
        this.mBoundPos = -1;
        this.mLastSeenPos = -1;
        PtrListView.this.post(this);
        do
        {
          return;
        } while (paramInt < j);
        i = paramInt - j + 1;
        this.mMode = 1;
        break;
      }
    }
    
    void start(int paramInt1, int paramInt2)
    {
      stop();
      if (paramInt2 == -1) {
        start(paramInt1);
      }
      int j;
      do
      {
        return;
        i = PtrListView.this.getFirstVisiblePosition();
        j = PtrListView.this.getChildCount() + i - 1;
        if (paramInt1 > i) {
          break;
        }
        j -= paramInt2;
      } while (j < 1);
      int i = i - paramInt1 + 1;
      j -= 1;
      if (j < i)
      {
        this.mMode = 4;
        i = j;
        label79:
        if (i <= 0) {
          break label180;
        }
      }
      label178:
      label180:
      for (this.mScrollDuration = (400 / i);; this.mScrollDuration = 400)
      {
        this.mTargetPos = paramInt1;
        this.mBoundPos = paramInt2;
        this.mLastSeenPos = -1;
        PtrListView.this.post(this);
        return;
        for (this.mMode = 2;; this.mMode = 1)
        {
          break label79;
          if (paramInt1 < j) {
            break label178;
          }
          int k = paramInt2 - i;
          if (k < 1) {
            break;
          }
          i = paramInt1 - j + 1;
          j = k - 1;
          if (j < i)
          {
            this.mMode = 3;
            i = j;
            break label79;
          }
        }
        break;
      }
    }
    
    void startWithOffset(int paramInt1, int paramInt2)
    {
      startWithOffset(paramInt1, paramInt2, 400);
    }
    
    void startWithOffset(int paramInt1, int paramInt2, int paramInt3)
    {
      stop();
      this.mTargetPos = paramInt1;
      this.mOffsetFromTop = paramInt2;
      this.mBoundPos = -1;
      this.mLastSeenPos = -1;
      this.mMode = 5;
      int j = PtrListView.this.getFirstVisiblePosition();
      int i = PtrListView.this.getChildCount();
      int k = j + i - 1;
      float f;
      if (paramInt1 < j)
      {
        paramInt1 = j - paramInt1;
        f = paramInt1 / i;
        if (f >= 1.0F) {
          break label150;
        }
      }
      label150:
      for (paramInt1 = (int)(f * paramInt3);; paramInt1 = (int)(paramInt3 / f))
      {
        this.mScrollDuration = paramInt1;
        this.mLastSeenPos = -1;
        PtrListView.this.post(this);
        return;
        if (paramInt1 > k)
        {
          paramInt1 -= k;
          break;
        }
        paramInt1 = PtrListView.this.getChildAt(paramInt1 - j).getTop();
        PtrListView.this.smoothScrollBy(paramInt1 - paramInt2, paramInt3);
        return;
      }
    }
    
    void stop()
    {
      PtrListView.this.removeCallbacks(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.PtrListView
 * JD-Core Version:    0.7.0.1
 */