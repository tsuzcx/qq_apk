package com.tencent.qqmail.view.listscroller;

import android.graphics.Canvas;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;

public class ScrollDialHandler
  implements IViewGestureListener
{
  public static final int RESET_DURATION = 500;
  public static final byte SCROLL_POS_DURATION = 20;
  public static final int SCROLL_POS_TIME = 200;
  private static ScrollDialHandler mInstance;
  private boolean mCanVibrate = true;
  private View mContainerView;
  private boolean mDealScrollChange = false;
  protected ScrollPosUtil mDealScroolPos = null;
  protected DecelerateInterpolator mDecelerateInterpolator = new DecelerateInterpolator();
  private ViewGroup.LayoutParams mDialLayoutParams = null;
  private FreeRelativeLayout mDialParent;
  protected int mHalfMaxDistance = 0;
  protected Handler mHandler = new ScrollDialHandler.1(this);
  private boolean mIsCanScrollToDial;
  private boolean mIsEnableScroll = true;
  protected boolean mIsScroll = false;
  private boolean mIsScrollSms = false;
  protected boolean mIsScrolling = false;
  private ItemScrollChangedListener mItemScrollChangedListener;
  protected int mMaxDistance = 0;
  private int mPosition;
  private Runnable mResetRun = new ScrollDialHandler.2(this);
  private float mScrollScale;
  private ScrollSendSmsTextView mScrollSmsTextView = null;
  private ScrollContacTextView mScrollTextView = null;
  protected int mScrollX;
  public int mScroll_Time_dis;
  private int mSmsHalfMaxDistance;
  private ViewGroup.LayoutParams mSmsLayoutParams = null;
  private int mSmsMaxDistance;
  private FreeRelativeLayout mSmsParent;
  
  private boolean canDial()
  {
    return this.mScrollX < this.mHalfMaxDistance;
  }
  
  private boolean canSendSms()
  {
    return this.mScrollX > this.mSmsHalfMaxDistance;
  }
  
  public static ScrollDialHandler getSingleInstance()
  {
    if (mInstance == null) {
      mInstance = new ScrollDialHandler();
    }
    return mInstance;
  }
  
  private void hideContactProgress()
  {
    setContactProgressVisibility(4);
  }
  
  private void hideSmsProgress()
  {
    setSmsProgressVisibility(4);
  }
  
  private void initLeftAndRightView()
  {
    if (this.mScrollTextView == null)
    {
      LayoutInflater localLayoutInflater = LayoutInflater.from(this.mContainerView.getContext());
      this.mDialParent = ((FreeRelativeLayout)localLayoutInflater.inflate(2131559073, null));
      this.mScrollTextView = ((ScrollContacTextView)this.mDialParent.findViewById(2131380911));
      this.mDialLayoutParams = new ViewGroup.LayoutParams(-1, -1);
      this.mScrollTextView.setScrollDialHandler(this);
      this.mSmsParent = ((FreeRelativeLayout)localLayoutInflater.inflate(2131559074, null));
      this.mScrollSmsTextView = ((ScrollSendSmsTextView)this.mSmsParent.findViewById(2131380912));
      this.mSmsLayoutParams = new ViewGroup.LayoutParams(-1, -1);
      this.mScrollSmsTextView.setScrollDialHandler(this);
    }
  }
  
  private void invokeScrollChange()
  {
    if (this.mIsScrollSms) {
      if ((this.mItemScrollChangedListener != null) && (this.mScrollX == this.mSmsMaxDistance) && (!this.mDealScrollChange))
      {
        this.mItemScrollChangedListener.itemContactScrollChanged(this.mPosition, 1);
        this.mDealScrollChange = true;
        this.mIsCanScrollToDial = false;
      }
    }
    while ((this.mItemScrollChangedListener == null) || (this.mScrollX != 0) || (this.mDealScrollChange)) {
      return;
    }
    this.mItemScrollChangedListener.itemContactScrollChanged(this.mPosition, 0);
    this.mDealScrollChange = true;
    this.mIsCanScrollToDial = false;
  }
  
  private void layoutLeftAndRightView()
  {
    int i = this.mContainerView.getLeft();
    int j = this.mContainerView.getRight();
    int k = this.mContainerView.getTop();
    int m = this.mContainerView.getBottom();
    int n = View.MeasureSpec.makeMeasureSpec(j - i, 1073741824);
    int i1 = View.MeasureSpec.makeMeasureSpec(m - k, 1073741824);
    if ((n != this.mDialLayoutParams.width) || (i1 != this.mDialLayoutParams.height))
    {
      this.mDialLayoutParams.width = n;
      this.mDialLayoutParams.height = i1;
      this.mDialParent.setLayoutParams(this.mDialLayoutParams);
      this.mSmsLayoutParams.width = n;
      this.mSmsLayoutParams.height = i1;
      this.mSmsParent.setLayoutParams(this.mSmsLayoutParams);
      this.mDialParent.measureSelf(n, i1);
      this.mDialParent.layoutSelf(true, i, k, j, m);
      this.mSmsParent.measureSelf(n, i1);
      this.mSmsParent.layoutSelf(true, i, k, j, m);
      i = this.mContainerView.getWidth();
      this.mSmsMaxDistance = (i << 1);
      this.mMaxDistance = i;
      this.mScrollX = this.mMaxDistance;
      this.mHalfMaxDistance = this.mScrollTextView.getCanScrollTextView();
      this.mSmsHalfMaxDistance = (this.mScrollSmsTextView.getCanScrollTextView() + this.mMaxDistance);
    }
  }
  
  private void scrollTo(int paramInt1, int paramInt2)
  {
    if (this.mContainerView != null) {
      this.mContainerView.scrollTo(paramInt1 - this.mMaxDistance, 0);
    }
  }
  
  public boolean IsEnableScroll()
  {
    return this.mIsEnableScroll;
  }
  
  public boolean IsUnFold()
  {
    return this.mScrollX == this.mMaxDistance;
  }
  
  protected void delayReset()
  {
    if (((this.mScrollX == 0) || (this.mScrollX == this.mSmsMaxDistance)) && (!this.mIsScroll))
    {
      this.mHandler.removeCallbacks(this.mResetRun);
      this.mHandler.postDelayed(this.mResetRun, 500L);
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.translate(this.mScrollX - this.mMaxDistance, 0.0F);
    int i = -this.mScrollX;
    if ((this.mDialParent != null) && (this.mScrollX < this.mMaxDistance))
    {
      paramCanvas.translate(i, 0.0F);
      this.mDialParent.draw(paramCanvas);
      paramCanvas.translate(-i, 0.0F);
    }
    i = this.mSmsMaxDistance - this.mScrollX;
    if ((this.mSmsParent != null) && (i < this.mMaxDistance))
    {
      paramCanvas.translate(i, 0.0F);
      this.mSmsParent.draw(paramCanvas);
      paramCanvas.translate(-i, 0.0F);
    }
    paramCanvas.translate(this.mMaxDistance - this.mScrollX, 0.0F);
  }
  
  protected void doScroll(boolean paramBoolean)
  {
    scrollTo(this.mScrollX, 0);
    if (this.mIsScrollSms)
    {
      this.mScrollSmsTextView.doScrollTextView(this.mScrollX - this.mMaxDistance, paramBoolean);
      if (canSendSms()) {
        hideSmsProgress();
      }
    }
    for (;;)
    {
      delayReset();
      return;
      setSmsProgressVisibility(0);
      this.mCanVibrate = true;
      continue;
      this.mScrollTextView.doScrollTextView(this.mScrollX, paramBoolean);
      if (canDial())
      {
        hideContactProgress();
      }
      else
      {
        setContactProgressVisibility(0);
        this.mCanVibrate = true;
      }
    }
  }
  
  public boolean doTouchUp(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (this.mIsScroll)
    {
      this.mIsScroll = false;
      unFold();
      bool = true;
    }
    return bool;
  }
  
  public boolean doTounchDown(MotionEvent paramMotionEvent)
  {
    this.mDealScrollChange = false;
    this.mIsScrollSms = false;
    this.mCanVibrate = true;
    this.mIsScroll = false;
    return false;
  }
  
  protected boolean doingScrollAnimate(int paramInt)
  {
    invokeScrollChange();
    delayReset();
    if (this.mScrollX == this.mMaxDistance) {
      reset();
    }
    return false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.translate(this.mScrollX - this.mMaxDistance, 0.0F);
    int i = -this.mScrollX;
    if ((this.mDialParent != null) && (i < this.mMaxDistance))
    {
      paramCanvas.translate(i, 0.0F);
      this.mDialParent.draw(paramCanvas);
      paramCanvas.translate(-i, 0.0F);
    }
    i = this.mSmsMaxDistance - this.mScrollX;
    if ((this.mSmsParent != null) && (i < this.mMaxDistance))
    {
      paramCanvas.translate(i, 0.0F);
      this.mSmsParent.draw(paramCanvas);
      paramCanvas.translate(-i, 0.0F);
    }
    paramCanvas.translate(this.mMaxDistance - this.mScrollX, 0.0F);
  }
  
  public int getTotalScrollX()
  {
    return this.mScrollX;
  }
  
  public void invalidate()
  {
    if (this.mContainerView != null) {
      this.mContainerView.invalidate();
    }
  }
  
  public boolean isCanReScroll()
  {
    return (this.mIsCanScrollToDial) && (!this.mIsScrolling);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (!IsEnableScroll()) {}
    do
    {
      do
      {
        return false;
        if (!this.mIsScrollSms) {
          break;
        }
      } while ((!this.mIsScroll) || (this.mScrollX == 0));
      this.mIsScroll = false;
      if (Math.abs(paramFloat1) > 700.0F)
      {
        if (paramFloat1 > 0.0F) {
          bool1 = true;
        }
        unFold(bool1);
      }
      for (;;)
      {
        return true;
        unFold();
      }
    } while ((!this.mIsScroll) || (this.mScrollX == 0));
    this.mIsScroll = false;
    if (Math.abs(paramFloat1) > 1500.0F)
    {
      bool1 = bool2;
      if (paramFloat1 > 0.0F) {
        bool1 = true;
      }
      unFold(bool1);
    }
    for (;;)
    {
      return true;
      unFold();
    }
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((this.mContainerView == null) || (!IsEnableScroll())) {}
    while (((!this.mIsScroll) && (((paramFloat1 > DeviceUtil.dip2px(-3.0F)) && (paramFloat1 < 0.0F)) || ((paramFloat1 < DeviceUtil.dip2px(2.0F)) && (paramFloat1 > 0.0F)))) || (this.mIsScrolling) || ((this.mScrollX == this.mSmsMaxDistance) && (paramFloat1 > 0.0F)) || ((this.mScrollX == 0) && (paramFloat1 < 0.0F))) {
      return false;
    }
    if (!this.mIsScroll)
    {
      if (paramFloat1 <= 0.0F) {
        break label151;
      }
      this.mIsScrollSms = true;
    }
    for (this.mScrollScale = 1.45F;; this.mScrollScale = 1.28F)
    {
      this.mScrollX = ((int)(this.mScrollScale * paramFloat1 + this.mScrollX));
      scrollDis(this.mScrollX);
      this.mIsScroll = true;
      return true;
      label151:
      this.mIsScrollSms = false;
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2, int paramInt)
  {
    if (!IsEnableScroll()) {
      return false;
    }
    this.mPosition = paramInt;
    return onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void reset()
  {
    if (!this.mIsScroll) {
      resetAll();
    }
  }
  
  public void resetAll()
  {
    if (this.mMaxDistance > 0)
    {
      this.mScrollX = this.mMaxDistance;
      scrollTo(this.mScrollX, 0);
    }
    if (this.mScrollTextView != null) {
      this.mScrollTextView.reset();
    }
    if (this.mScrollSmsTextView != null) {
      this.mScrollSmsTextView.reset();
    }
    this.mIsCanScrollToDial = true;
    this.mDealScrollChange = false;
  }
  
  public void scrollDis(int paramInt)
  {
    scrollDis(paramInt, true);
  }
  
  protected void scrollDis(int paramInt, boolean paramBoolean)
  {
    if (this.mIsScrollSms) {
      if (paramInt > this.mSmsMaxDistance) {
        this.mScrollX = this.mSmsMaxDistance;
      }
    }
    for (;;)
    {
      doScroll(paramBoolean);
      return;
      if (paramInt < this.mMaxDistance)
      {
        this.mScrollX = this.mMaxDistance;
      }
      else
      {
        this.mScrollX = paramInt;
        continue;
        if (paramInt > this.mMaxDistance) {
          this.mScrollX = this.mMaxDistance;
        } else if (paramInt < 0) {
          this.mScrollX = 0;
        } else {
          this.mScrollX = paramInt;
        }
      }
    }
  }
  
  public void setContactProgressVisibility(int paramInt) {}
  
  public void setEnableScroll(boolean paramBoolean)
  {
    this.mIsEnableScroll = paramBoolean;
    reset();
  }
  
  public void setItemScrollChangedListener(ItemScrollChangedListener paramItemScrollChangedListener)
  {
    this.mItemScrollChangedListener = paramItemScrollChangedListener;
  }
  
  public void setPosition(int paramInt)
  {
    this.mPosition = paramInt;
  }
  
  public void setSmsProgressVisibility(int paramInt) {}
  
  public void setText(int paramInt1, int paramInt2)
  {
    this.mScrollTextView.setText(paramInt1);
    this.mScrollSmsTextView.setText(paramInt2);
  }
  
  public void startScroll(View paramView)
  {
    this.mContainerView = paramView;
    initLeftAndRightView();
    layoutLeftAndRightView();
  }
  
  public void unFold()
  {
    int i = 0;
    invokeScrollChange();
    int j = this.mScrollX;
    if (this.mIsScrollSms)
    {
      if (this.mIsScrolling) {
        break label185;
      }
      hideSmsProgress();
      if (this.mScrollX == this.mSmsMaxDistance) {
        delayReset();
      }
    }
    label185:
    label188:
    for (;;)
    {
      return;
      if (this.mScrollX == this.mMaxDistance) {}
      for (;;)
      {
        if (i == 0) {
          break label188;
        }
        this.mDealScroolPos.setInterPlolator(this.mDecelerateInterpolator, i);
        this.mIsScrolling = true;
        return;
        if (canSendSms())
        {
          i = this.mSmsMaxDistance - this.mScrollX;
        }
        else
        {
          i = this.mMaxDistance - this.mScrollX;
          continue;
          hideContactProgress();
          if (IsUnFold()) {
            break;
          }
          if (!this.mIsScrolling)
          {
            if (this.mScrollX == 0)
            {
              delayReset();
              return;
            }
            if (this.mScrollX != this.mMaxDistance) {
              if (this.mScrollX < this.mHalfMaxDistance) {
                i = -this.mScrollX;
              } else {
                i = this.mMaxDistance - this.mScrollX;
              }
            }
          }
          else
          {
            i = j;
          }
        }
      }
    }
  }
  
  protected void unFold(boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    invokeScrollChange();
    if (this.mIsScrollSms) {
      if (!this.mIsScrolling)
      {
        hideSmsProgress();
        if ((this.mScrollX == this.mSmsMaxDistance) || (this.mScrollX == this.mMaxDistance)) {
          break label97;
        }
        if (!paramBoolean) {
          break label84;
        }
        i = this.mMaxDistance - this.mScrollX;
        if (i != 0)
        {
          this.mDealScroolPos.setInterPlolator(this.mDecelerateInterpolator, i);
          this.mIsScrolling = true;
        }
      }
    }
    label84:
    label97:
    do
    {
      return;
      for (;;)
      {
        i = this.mSmsMaxDistance - this.mScrollX;
        break;
        if (this.mScrollX != this.mSmsMaxDistance) {
          break;
        }
        delayReset();
        return;
        hideContactProgress();
        if (!this.mIsScrolling)
        {
          if ((this.mScrollX == 0) || (this.mScrollX == this.mMaxDistance)) {
            break label187;
          }
          if (paramBoolean) {}
          for (i = -this.mScrollX; i != 0; i = this.mMaxDistance - this.mScrollX)
          {
            this.mDealScroolPos.setInterPlolator(this.mDecelerateInterpolator, i);
            this.mIsScrolling = true;
            return;
          }
        }
      }
      i = j;
    } while (this.mScrollX != 0);
    label187:
    delayReset();
  }
  
  public static abstract interface ItemScrollChangedListener
  {
    public static final int SCROLL_CHANGE_TO_DIAL = 0;
    public static final int SCROLL_CHANGE_TO_SEND_SMS = 1;
    
    public abstract void itemContactScrollChanged(int paramInt1, int paramInt2);
  }
  
  class ScrollPosUtil
    implements Runnable
  {
    private int mDis;
    private Interpolator mPolator;
    private int mStartX;
    public int mTotalDuration = 200;
    private long startTime;
    
    ScrollPosUtil() {}
    
    public void run()
    {
      float f = (float)(System.currentTimeMillis() - this.startTime) * 1.0F / this.mTotalDuration;
      ScrollDialHandler.this.mHandler.removeCallbacks(this);
      if (f > 1.0F)
      {
        ScrollDialHandler.this.mScrollX = (this.mStartX + this.mDis);
        ScrollDialHandler.this.mIsScrolling = false;
        if (!ScrollDialHandler.this.doingScrollAnimate(ScrollDialHandler.this.mScrollX)) {
          ScrollDialHandler.this.scrollDis(ScrollDialHandler.this.mScrollX, false);
        }
      }
      do
      {
        return;
        ScrollDialHandler localScrollDialHandler = ScrollDialHandler.this;
        int i = this.mStartX;
        localScrollDialHandler.mScrollX = ((int)(this.mPolator.getInterpolation(f) * this.mDis) + i);
      } while (ScrollDialHandler.this.doingScrollAnimate(ScrollDialHandler.this.mScrollX));
      ScrollDialHandler.this.mHandler.postDelayed(this, 20L);
      ScrollDialHandler.this.scrollDis(ScrollDialHandler.this.mScrollX, false);
    }
    
    public void setInterPlolator(Interpolator paramInterpolator, int paramInt)
    {
      this.mDis = paramInt;
      this.mPolator = paramInterpolator;
      this.mStartX = ScrollDialHandler.this.mScrollX;
      if (ScrollDialHandler.this.mScroll_Time_dis == 0) {
        ScrollDialHandler.this.mScroll_Time_dis = (ScrollDialHandler.this.mMaxDistance >> 2);
      }
      if (Math.abs(paramInt) < ScrollDialHandler.this.mScroll_Time_dis) {}
      for (this.mTotalDuration = 100;; this.mTotalDuration = 200)
      {
        this.startTime = (System.currentTimeMillis() - 20L);
        ScrollDialHandler.this.mScrollX = (this.mStartX + (int)(this.mPolator.getInterpolation(20.0F / this.mTotalDuration) * this.mDis));
        ScrollDialHandler.this.scrollDis(ScrollDialHandler.this.mScrollX, false);
        ScrollDialHandler.this.mHandler.postDelayed(this, 20L);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.listscroller.ScrollDialHandler
 * JD-Core Version:    0.7.0.1
 */