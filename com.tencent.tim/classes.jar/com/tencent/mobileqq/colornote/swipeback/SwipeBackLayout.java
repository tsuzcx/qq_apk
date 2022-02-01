package com.tencent.mobileqq.colornote.swipeback;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Scroller;
import aqcx;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.util.WeakReference;

public class SwipeBackLayout
  extends FrameLayout
{
  public static int cMj;
  public static int cMk;
  protected int JO;
  private b a;
  protected final c a;
  protected SwipePostTableLayout.a a;
  protected volatile boolean acn;
  protected boolean allowedSliding;
  protected boolean awE;
  private boolean awH;
  private boolean bTj = true;
  protected boolean bTk = true;
  protected int beC;
  protected int downX;
  protected int downY;
  private Animator i;
  private boolean isFinish;
  private boolean isStopped;
  private List<ViewPager> kX = new LinkedList();
  private Activity mActivity;
  protected View mContentView;
  protected Context mContext;
  protected GestureDetector mGestureDetector;
  protected Scroller mScroller;
  protected int mTouchSlop;
  protected int screenWidth;
  
  public SwipeBackLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipeBackLayout$c = new c(this);
    this.mContext = paramContext;
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.mScroller = new Scroller(paramContext);
    this.screenWidth = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
    this.mGestureDetector = new GestureDetector(paramContext, new a());
    cMj = aqcx.dip2px(paramContext, 90.0F);
  }
  
  private void b(List<ViewPager> paramList, ViewGroup paramViewGroup)
  {
    int k = paramViewGroup.getChildCount();
    int j = 0;
    if (j < k)
    {
      View localView = paramViewGroup.getChildAt(j);
      if ((localView instanceof ViewPager)) {
        paramList.add((ViewPager)localView);
      }
      for (;;)
      {
        j += 1;
        break;
        if ((localView instanceof ViewGroup)) {
          b(paramList, (ViewGroup)localView);
        }
      }
    }
  }
  
  private void setContentView(View paramView)
  {
    this.mContentView = ((View)paramView.getParent());
  }
  
  protected ViewPager a(List<ViewPager> paramList, MotionEvent paramMotionEvent)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    Rect localRect = new Rect();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ViewPager localViewPager = (ViewPager)paramList.next();
      localViewPager.getHitRect(localRect);
      if (localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
        return localViewPager;
      }
    }
    return null;
  }
  
  public void attachToActivity(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    Object localObject = paramActivity.getTheme().obtainStyledAttributes(new int[] { 16842836 });
    int j = ((TypedArray)localObject).getResourceId(0, 0);
    ((TypedArray)localObject).recycle();
    paramActivity = (ViewGroup)paramActivity.getWindow().getDecorView();
    localObject = paramActivity.getChildAt(0);
    ((View)localObject).setBackgroundResource(j);
    paramActivity.removeView((View)localObject);
    addView((View)localObject);
    setContentView((View)localObject);
    paramActivity.addView(this);
  }
  
  protected void bdP()
  {
    if (this.awH) {
      return;
    }
    this.awH = true;
    int j = this.JO + this.mContentView.getScrollX();
    int k = (int)(j * 1.0D / this.JO * 700.0D);
    try
    {
      this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -j + 1, 0, Math.abs(k));
      label66:
      if (QLog.isColorLevel()) {
        QLog.i("SwipeBackLayout", 2, "SwipeBackLayout scrollRight viewwithd=" + this.JO + "  startx+ " + this.mContentView.getScrollX() + "  left width = " + -j + "  duration=" + k);
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipeBackLayout$c.sendEmptyMessageDelayed(1, 200L);
      postInvalidate();
      return;
    }
    catch (Exception localException)
    {
      break label66;
    }
  }
  
  protected void bdQ()
  {
    try
    {
      int j = this.mContentView.getScrollX();
      this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -j, 0, Math.abs(j));
      postInvalidate();
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout$a.Oo();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void cVA()
  {
    this.bTk = false;
  }
  
  public void cVB()
  {
    this.bTk = true;
  }
  
  protected void cWw()
  {
    try
    {
      int j = this.mContentView.getScrollX();
      this.mScroller.startScroll(j, 0, -j, 0, Math.abs(j) / 2);
      postInvalidate();
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout$a.Oo();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void computeScroll()
  {
    if (this.mScroller.computeScrollOffset())
    {
      this.mContentView.scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
      postInvalidate();
      if ((this.mScroller.isFinished()) && (this.isFinish)) {
        bdP();
      }
    }
  }
  
  public void onDestroy() {}
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    ViewPager localViewPager = a(this.kX, paramMotionEvent);
    if ((localViewPager != null) && (localViewPager.getCurrentItem() != 0)) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    while ((this.bTk) && (this.mGestureDetector != null))
    {
      return this.mGestureDetector.onTouchEvent(paramMotionEvent);
      this.allowedSliding = false;
      int j = (int)paramMotionEvent.getRawX();
      this.beC = j;
      this.downX = j;
      this.downY = ((int)paramMotionEvent.getRawY());
      if (this.downX < cMj)
      {
        this.allowedSliding = true;
        continue;
        if ((this.allowedSliding) && (this.bTk) && ((int)paramMotionEvent.getRawX() - this.downX > this.mTouchSlop) && (Math.abs((int)paramMotionEvent.getRawY() - this.downY) < this.mTouchSlop)) {
          return true;
        }
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      this.JO = getWidth();
      b(this.kX, this);
    }
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    while ((this.bTk) && (this.mGestureDetector != null))
    {
      return this.mGestureDetector.onTouchEvent(paramMotionEvent);
      return true;
      if ((this.allowedSliding) && (this.bTk))
      {
        int j = (int)paramMotionEvent.getRawX();
        int k = this.beC - j;
        if ((j - this.downX > this.mTouchSlop) && (Math.abs((int)paramMotionEvent.getRawY() - this.downY) < this.mTouchSlop))
        {
          if ((!this.awE) && (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipeBackLayout$b != null)) {
            this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipeBackLayout$b.GZ(true);
          }
          this.awE = true;
        }
        if (this.bTj)
        {
          this.beC = j;
          if ((j - this.downX > 0) && (this.awE))
          {
            if (QLog.isColorLevel()) {
              QLog.i("SwipeBackLayout", 2, "moveX:" + j + "downX:" + this.downX + "deltaX:" + k);
            }
            j = k;
            if (this.mContentView.getScrollX() + k > 0) {
              j = -this.mContentView.getScrollX();
            }
            this.mContentView.scrollBy(j, 0);
            continue;
            if ((this.allowedSliding) && (this.bTk) && (this.bTj))
            {
              this.awE = false;
              if (QLog.isColorLevel()) {
                QLog.i("SwipeBackLayout", 2, "event.getRawX():" + paramMotionEvent.getRawX() + "screenWidth:" + this.screenWidth + "mViewWidth:" + this.JO);
              }
              if (paramMotionEvent.getRawX() - this.downX >= this.screenWidth / 2)
              {
                this.isFinish = true;
                if (this.mContentView.getScrollX() != 0) {
                  bdP();
                }
                if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipeBackLayout$b != null) {
                  this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipeBackLayout$b.GZ(false);
                }
              }
              else
              {
                postDelayed(new SwipeBackLayout.1(this), 100L);
                this.isFinish = false;
              }
            }
          }
        }
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setGestureDetector(GestureDetector paramGestureDetector)
  {
    this.mGestureDetector = paramGestureDetector;
  }
  
  public void setOnSwipeListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipeBackLayout$b = paramb;
  }
  
  public void setReadyToSlide(boolean paramBoolean)
  {
    this.bTj = paramBoolean;
  }
  
  public void setTransitionAnim(Animator paramAnimator)
  {
    this.i = paramAnimator;
  }
  
  public class a
    extends GestureDetector.SimpleOnGestureListener
  {
    protected a() {}
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
        return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      float f2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / f1);
      if ((!SwipeBackLayout.this.allowedSliding) || (paramFloat1 < 200.0F)) {
        return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      if ((f1 < 0.0F) && (f2 < 0.5F))
      {
        if (!(SwipeBackLayout.this.mContext instanceof Activity)) {
          break label126;
        }
        SwipeBackLayout.this.acn = true;
        SwipeBackLayout.this.bdP();
      }
      for (;;)
      {
        return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        label126:
        SwipeBackLayout.this.bdP();
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void GZ(boolean paramBoolean);
  }
  
  static class c
    extends Handler
  {
    private WeakReference<SwipeBackLayout> as;
    
    c(SwipeBackLayout paramSwipeBackLayout)
    {
      this.as = new WeakReference(paramSwipeBackLayout);
    }
    
    public void handleMessage(Message paramMessage)
    {
      SwipeBackLayout localSwipeBackLayout = (SwipeBackLayout)this.as.get();
      switch (paramMessage.what)
      {
      default: 
        super.handleMessage(paramMessage);
      }
      do
      {
        do
        {
          return;
        } while (SwipeBackLayout.a(localSwipeBackLayout));
        SwipeBackLayout.a(localSwipeBackLayout, true);
      } while (!(localSwipeBackLayout.mContext instanceof Activity));
      if (QLog.isColorLevel()) {
        QLog.d("SwipeBackLayout", 2, "SwipeBackLayout finish()");
      }
      localSwipeBackLayout.acn = true;
      ((Activity)localSwipeBackLayout.mContext).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.swipeback.SwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */