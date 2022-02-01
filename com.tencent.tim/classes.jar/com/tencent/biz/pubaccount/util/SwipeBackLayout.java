package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import odu;
import oek;

public class SwipeBackLayout
  extends RelativeLayout
{
  public WebViewFragment a;
  protected odu a;
  public volatile boolean acn;
  protected boolean awE;
  public boolean awF;
  protected boolean awG = true;
  private boolean awH;
  private boolean awg = true;
  private boolean awh;
  protected int beC;
  private GestureDetector d;
  protected int downX;
  protected int downY;
  protected boolean isFinish;
  private boolean isStopped;
  protected List<ViewPager> kX = new LinkedList();
  protected View mContentView;
  public Context mContext;
  final Handler mHandler = new oek(this);
  private Scroller mScroller;
  private Drawable mShadowDrawable;
  protected int mTouchSlop;
  protected int screenWidth;
  protected int viewWidth;
  
  public SwipeBackLayout(Context paramContext)
  {
    this(paramContext, true);
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Odu = new odu();
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.mScroller = new Scroller(paramContext);
    this.mShadowDrawable = getResources().getDrawable(2130843503);
    this.screenWidth = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
  }
  
  public SwipeBackLayout(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, null);
    this.mContext = paramContext;
    this.awG = paramBoolean;
    this.d = new GestureDetector(paramContext, new a(paramContext));
  }
  
  private void a(List<ViewPager> paramList, ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewPager)) {
        paramList.add((ViewPager)localView);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localView instanceof ViewGroup)) {
          a(paramList, (ViewGroup)localView);
        }
      }
    }
  }
  
  public boolean A(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment;
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((WebViewFragment)localObject).getWebView() != null)
        {
          localObject = ((WebViewFragment)localObject).getWebView();
          ((CustomWebView)localObject).getContentHeight();
          ((CustomWebView)localObject).getView().getHeight();
          ((CustomWebView)localObject).getWebScrollY();
          float f1 = ((CustomWebView)localObject).getScale();
          bool1 = bool2;
          if (f1 > 0.0F)
          {
            int i = (int)((paramMotionEvent.getX() + ((CustomWebView)localObject).getWebScrollX()) / f1);
            float f2 = paramMotionEvent.getY();
            int j = (int)((((CustomWebView)localObject).getWebScrollY() + f2) / f1);
            bool1 = this.jdField_a_of_type_Odu.a(new Point(i, j));
          }
        }
      }
    }
    return bool1;
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
  
  public void bdP()
  {
    if (this.awH) {
      return;
    }
    this.awH = true;
    int i = this.viewWidth + this.mContentView.getScrollX();
    int j = (int)(i * 1.0D / this.viewWidth * 700.0D);
    try
    {
      this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -i + 1, 0, Math.abs(j));
      label66:
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_SwipeBackLayout", 2, "SwipeBackLayout scrollRight viewwithd=" + this.viewWidth + "  startx+ " + this.mContentView.getScrollX() + "  left width = " + -i + "  duration=" + j);
      }
      this.mHandler.sendEmptyMessageDelayed(1, 800L);
      postInvalidate();
      return;
    }
    catch (Exception localException)
    {
      break label66;
    }
  }
  
  public void bdQ()
  {
    try
    {
      int i = this.mContentView.getScrollX();
      this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -i, 0, Math.abs(i));
      postInvalidate();
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
      if ((this.mScroller.isFinished()) && (this.isFinish) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.flingLToR();
        bdP();
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.awh) || (!this.awg)) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    ViewPager localViewPager = a(this.kX, paramMotionEvent);
    if ((localViewPager != null) && (localViewPager.getCurrentItem() != 0)) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        return this.d.onTouchEvent(paramMotionEvent);
        this.awF = false;
        int i = (int)paramMotionEvent.getRawX();
        this.beC = i;
        this.downX = i;
        this.downY = ((int)paramMotionEvent.getRawY());
        if ((this.downX < this.viewWidth / 3) && ((this.jdField_a_of_type_Odu.GE()) || (!A(paramMotionEvent))) && (this.awG)) {
          this.awF = true;
        }
      }
    } while ((!this.awF) || ((int)paramMotionEvent.getRawX() - this.downX <= this.mTouchSlop) || (Math.abs((int)paramMotionEvent.getRawY() - this.downY) >= this.mTouchSlop));
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      this.viewWidth = getWidth();
      a(this.kX, this);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.awg) || (!this.awh)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return this.d.onTouchEvent(paramMotionEvent);
      if (this.awF)
      {
        int i = (int)paramMotionEvent.getRawX();
        int j = this.beC - i;
        this.beC = i;
        if ((i - this.downX > this.mTouchSlop) && (Math.abs((int)paramMotionEvent.getRawY() - this.downY) < this.mTouchSlop)) {
          this.awE = true;
        }
        if ((i - this.downX > 0) && (this.awE))
        {
          if (QLog.isColorLevel()) {
            QLog.i("WebLog_SwipeBackLayout", 2, "moveX:" + i + "downX:" + this.downX + "deltaX:" + j);
          }
          this.mContentView.scrollBy(j, 0);
          continue;
          if (this.awF)
          {
            this.awE = false;
            if (QLog.isColorLevel()) {
              QLog.i("WebLog_SwipeBackLayout", 2, "event.getRawX():" + paramMotionEvent.getRawX() + "screenWidth:" + this.screenWidth + "viewWidth:" + this.viewWidth);
            }
            if (paramMotionEvent.getRawX() - this.downX >= this.screenWidth / 2)
            {
              this.isFinish = true;
              bdP();
            }
            else
            {
              postDelayed(new SwipeBackLayout.2(this), 100L);
              this.isFinish = false;
            }
          }
        }
      }
    }
  }
  
  public void setWebViewFragment(WebViewFragment paramWebViewFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment = paramWebViewFragment;
  }
  
  public class a
    extends GestureDetector.SimpleOnGestureListener
  {
    private float lB;
    
    public a(Context paramContext)
    {
      this.lB = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 2);
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
        return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      float f2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / f1);
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (SwipeBackLayout.b(SwipeBackLayout.this))
      {
        bool1 = bool2;
        if (SwipeBackLayout.c(SwipeBackLayout.this))
        {
          bool1 = bool2;
          if (!SwipeBackLayout.this.jdField_a_of_type_Odu.GE())
          {
            bool1 = bool2;
            if (SwipeBackLayout.this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) {
              bool1 = SwipeBackLayout.this.A(paramMotionEvent1);
            }
          }
        }
      }
      if ((!SwipeBackLayout.this.awF) || (paramFloat1 < 200.0F)) {
        return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      if ((f1 < 0.0F) && (f2 < 0.5F) && (SwipeBackLayout.b(SwipeBackLayout.this)) && (SwipeBackLayout.c(SwipeBackLayout.this)) && (!bool1))
      {
        if (!(SwipeBackLayout.this.mContext instanceof Activity)) {
          break label233;
        }
        SwipeBackLayout.this.acn = true;
        SwipeBackLayout.this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.flingLToR();
        SwipeBackLayout.this.bdP();
      }
      for (;;)
      {
        return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        label233:
        if (SwipeBackLayout.this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null)
        {
          SwipeBackLayout.this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.flingLToR();
          SwipeBackLayout.this.bdP();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.SwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */