package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Scroller;
import arfm;
import auru;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DrawerFrame
  extends FrameLayout
  implements Handler.Callback
{
  private View Jy;
  private a a;
  private boolean bvL;
  private boolean bvM;
  private boolean bvN;
  private boolean bvO;
  private Rect cS;
  private boolean cZZ = true;
  private int cgS;
  private int cgT;
  private int cgU;
  private int cgV;
  private int cgW;
  private int cgX;
  private int cgY;
  private int chd = -1;
  private ViewGroup dJ;
  private boolean daa = true;
  private Set<c> dj = new HashSet();
  public boolean isTouchable = true;
  private auru j;
  private View mContentView;
  private int mHeight;
  private Scroller mScroller;
  private VelocityTracker mVelocityTracker;
  private int mWidth;
  private View zv;
  
  public DrawerFrame(Context paramContext, ViewGroup paramViewGroup)
    throws NullPointerException
  {
    super(paramContext);
    if (paramContext == null) {
      throw new NullPointerException("context is null");
    }
    this.j = new auru(Looper.getMainLooper(), this);
    this.mScroller = new Scroller(paramContext, new b());
    addContentView(paramViewGroup);
  }
  
  private void Yp(int paramInt)
  {
    if ((this.chd == 0) && (this.cgS + paramInt > this.cgT)) {
      if (this.cgS != this.cgT)
      {
        this.bvM = true;
        this.mContentView.offsetLeftAndRight(this.cgT - this.cgS);
        this.cgS = this.cgT;
        go(this.chd, this.cgS);
        invalidate();
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((this.chd != 0) || (this.cgS + paramInt >= 0)) {
            break;
          }
        } while (this.cgS == 0);
        this.bvM = false;
        this.mContentView.offsetLeftAndRight(0 - this.mContentView.getLeft());
        this.cgS = 0;
        go(this.chd, this.cgS);
        invalidate();
        return;
        if ((this.chd != 1) || (this.cgS + paramInt >= -this.cgU)) {
          break;
        }
      } while (this.cgS == -this.cgU);
      this.bvM = true;
      this.mContentView.offsetLeftAndRight(-this.cgU - this.cgS);
      this.cgS = (-this.cgU);
      go(this.chd, this.cgS);
      invalidate();
      return;
      if ((this.chd != 1) || (this.cgS + paramInt <= 0)) {
        break;
      }
    } while (this.cgS == 0);
    this.bvM = false;
    this.mContentView.offsetLeftAndRight(0 - this.mContentView.getLeft());
    this.cgS = 0;
    go(this.chd, this.cgS);
    invalidate();
    return;
    this.mContentView.offsetLeftAndRight(paramInt);
    this.cgS += paramInt;
    go(this.chd, this.cgS);
    invalidate();
  }
  
  private void Yq(int paramInt)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.bvO = false;
    this.bvN = false;
    this.mVelocityTracker.computeCurrentVelocity(1000);
    if (Math.abs(this.mVelocityTracker.getXVelocity()) > localViewConfiguration.getScaledMinimumFlingVelocity())
    {
      if (this.chd == 0)
      {
        if (this.mVelocityTracker.getXVelocity() > 0.0F)
        {
          this.bvM = false;
          cux();
          return;
        }
        this.bvM = true;
        cuA();
        return;
      }
      if (this.mVelocityTracker.getXVelocity() < 0.0F)
      {
        this.bvM = false;
        cuy();
        return;
      }
      this.bvM = true;
      cuA();
      return;
    }
    if (this.chd == 0)
    {
      if ((this.cgS > this.mWidth / 3.0D * 2.0D) || ((this.cgS > this.mWidth / 3.0D) && (paramInt <= 0)))
      {
        this.bvM = false;
        cux();
        return;
      }
      this.bvM = true;
      cuA();
      return;
    }
    if (this.cgS < -(this.cgU / 3.0D * 1.0D))
    {
      this.bvM = false;
      cuy();
      return;
    }
    this.bvM = true;
    cuA();
  }
  
  private boolean aGs()
  {
    return (this.Jy != null) || (this.zv != null);
  }
  
  private void addContentView(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.mContentView = paramView;
    paramView = this.mContentView.getParent();
    if ((paramView instanceof ViewGroup))
    {
      this.dJ = ((ViewGroup)paramView);
      this.dJ.removeView(this.mContentView);
      paramView = new FrameLayout.LayoutParams(-1, -1);
      addView(this.mContentView, paramView);
      this.dJ.addView(this);
      this.dJ.setOnClickListener(new arfm(this));
      return;
    }
    this.dJ = null;
  }
  
  private boolean as(MotionEvent paramMotionEvent)
  {
    if (this.dj.size() > 0)
    {
      Iterator localIterator = this.dj.iterator();
      while (localIterator.hasNext()) {
        if (((c)localIterator.next()).onInterceptTouchEvent(paramMotionEvent)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean bw(int paramInt1, int paramInt2)
  {
    return (this.cS != null) && (this.cS.contains(paramInt1, paramInt2));
  }
  
  private void gp(int paramInt1, int paramInt2)
  {
    int k = 0;
    if ((paramInt2 == 1) || (paramInt1 == 1)) {}
    for (int i = 8;; i = 0)
    {
      if ((this.Jy != null) && (this.Jy.getVisibility() != i)) {
        this.Jy.setVisibility(i);
      }
      if (paramInt2 != 1)
      {
        paramInt2 = k;
        if (paramInt1 != 0) {}
      }
      else
      {
        paramInt2 = 8;
      }
      if ((this.zv != null) && (this.zv.getVisibility() != paramInt2)) {
        this.zv.setVisibility(paramInt2);
      }
      return;
    }
  }
  
  private boolean isDraggable()
  {
    if (!this.bvL) {}
    while (this.mContentView == null) {
      return false;
    }
    return true;
  }
  
  public void Cn(boolean paramBoolean)
  {
    if ((!isDraggable()) || (!aGs())) {
      return;
    }
    Scroller localScroller;
    int k;
    int m;
    if (this.bvN)
    {
      this.j.removeMessages(1);
      this.j.removeMessages(2);
      this.j.removeMessages(4);
      this.j.removeMessages(3);
      this.bvN = true;
      if (this.a != null) {
        this.a.AD(this.chd);
      }
      if (this.a != null) {
        this.a.cbC();
      }
      localScroller = this.mScroller;
      k = this.cgS;
      m = -this.cgS;
      if (!paramBoolean) {
        break label150;
      }
    }
    label150:
    for (int i = 300;; i = 0)
    {
      localScroller.startScroll(k, 0, m, 0, i);
      this.j.sendEmptyMessage(2);
      return;
      if (this.bvM) {
        break;
      }
      return;
    }
  }
  
  public boolean Wt()
  {
    return this.bvM;
  }
  
  public void a(c paramc)
  {
    if (paramc != null) {
      this.dj.add(paramc);
    }
  }
  
  public void ay(View paramView, int paramInt)
  {
    if ((paramView == null) || (this.Jy != null) || (this.zv != null)) {
      QLog.d("DrawerFrame", 1, "drawer view has exist");
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DrawerFrame", 2, "addDrawerView, side: " + paramInt);
      }
      if (paramInt == 0)
      {
        this.Jy = paramView;
        this.Jy.setVisibility(8);
        paramView = new FrameLayout.LayoutParams(-1, -1, 19);
        addView(this.Jy, paramView);
        this.chd = 0;
        this.cZZ = false;
        this.daa = false;
        return;
      }
    } while (paramInt != 1);
    this.zv = paramView;
    this.zv.setVisibility(8);
    paramView = new FrameLayout.LayoutParams(-2, -1, 21);
    addView(this.zv, paramView);
    this.chd = 1;
    this.cZZ = false;
    this.daa = false;
  }
  
  public void b(c paramc)
  {
    if (paramc != null) {
      this.dj.remove(paramc);
    }
  }
  
  public void cuA()
  {
    Cn(true);
  }
  
  public void cux()
  {
    openDrawer(0, true);
  }
  
  public void cuy()
  {
    openDrawer(1, true);
  }
  
  public void cuz()
  {
    this.j.removeMessages(1);
    this.j.removeMessages(2);
    this.j.removeMessages(4);
    this.j.removeMessages(3);
    this.bvN = false;
    this.cgS = 0;
    this.a = null;
    this.cZZ = true;
    this.daa = true;
    if (this.Jy != null) {}
    for (this.chd = 0;; this.chd = 1)
    {
      if (this.mContentView != null) {
        this.mContentView.offsetLeftAndRight(0 - this.mContentView.getLeft());
      }
      go(this.chd, this.cgS);
      postInvalidate();
      if (this.bvM)
      {
        this.bvM = false;
        this.j.sendEmptyMessage(4);
      }
      gp(this.chd, 1);
      return;
    }
  }
  
  public void ehR()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DrawerFrame", 2, "removeDrawerView");
    }
    if ((this.Jy == null) && (this.zv == null)) {
      QLog.d("DrawerFrame", 1, "drawer view is empty!");
    }
    do
    {
      do
      {
        return;
        cuz();
        if (this.Jy != null)
        {
          removeView(this.Jy);
          this.Jy = null;
          if (QLog.isColorLevel()) {
            QLog.d("DrawerFrame", 2, "remove left drawer");
          }
        }
      } while (this.zv == null);
      removeView(this.zv);
      this.zv = null;
    } while (!QLog.isColorLevel());
    QLog.d("DrawerFrame", 2, "remove right drawer");
  }
  
  @TargetApi(11)
  protected void go(int paramInt1, int paramInt2)
  {
    gp(paramInt1, 2);
    float f1;
    float f2;
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (paramInt1 != 0) {
        break label86;
      }
      f1 = paramInt2 / this.cgT;
      if (paramInt1 != 0) {
        break label99;
      }
      f2 = this.mWidth * (f1 - 1.0F);
      label42:
      if (paramInt1 != 0) {
        break label114;
      }
    }
    label86:
    label99:
    label114:
    for (View localView = this.Jy;; localView = this.zv)
    {
      if (localView != null) {
        localView.setTranslationX(f2);
      }
      if (this.a != null) {
        this.a.m(this.chd, f1);
      }
      return;
      f1 = -paramInt2 / this.cgU;
      break;
      f2 = -this.mWidth * (f1 - 1.0F);
      break label42;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 0;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      boolean bool = this.mScroller.computeScrollOffset();
      i = this.mScroller.getCurrX();
      int k = this.cgS;
      this.cgS = this.mScroller.getCurrX();
      if (this.mContentView != null)
      {
        this.mContentView.offsetLeftAndRight(i - k);
        go(this.chd, this.cgS);
      }
      postInvalidate();
      if (!bool)
      {
        this.bvN = false;
        this.bvM = true;
        this.j.sendEmptyMessage(3);
        return true;
      }
      this.j.sendEmptyMessage(1);
      return true;
      bool = this.mScroller.computeScrollOffset();
      i = this.mScroller.getCurrX();
      k = this.cgS;
      this.cgS = this.mScroller.getCurrX();
      if (this.mContentView != null)
      {
        this.mContentView.offsetLeftAndRight(i - k);
        go(this.chd, this.cgS);
      }
      postInvalidate();
      if (!bool)
      {
        this.bvN = false;
        this.bvM = false;
        if (this.Jy != null) {
          this.Jy.setVisibility(8);
        }
        if (this.zv != null) {
          this.zv.setVisibility(8);
        }
        this.j.sendEmptyMessage(4);
        return true;
      }
      this.j.sendEmptyMessage(2);
      return true;
      if (!this.bvN)
      {
        if (this.a != null) {
          this.a.onDrawerClosed();
        }
        if (this.Jy != null) {}
        for (this.chd = 0;; this.chd = 1)
        {
          gp(this.chd, 1);
          return true;
        }
        if (!this.bvN)
        {
          gp(this.chd, 0);
          if (this.a != null)
          {
            this.a.onDrawerOpened();
            return true;
            if (Wt())
            {
              if (this.chd == 0)
              {
                i = this.cgT - this.cgS;
                this.cgS = this.cgT;
              }
              while ((this.mContentView != null) && (i != 0))
              {
                this.mContentView.offsetLeftAndRight(i);
                go(this.chd, this.cgS);
                postInvalidate();
                return true;
                if (this.chd == 1)
                {
                  i = -this.cgU - this.cgS;
                  this.cgS = (-this.cgU);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (!isDraggable()) {}
    int i;
    do
    {
      do
      {
        do
        {
          return false;
        } while (as(paramMotionEvent));
        i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        k = (int)(paramMotionEvent.getX() + 0.5F);
        m = (int)(paramMotionEvent.getY() + 0.5F);
        switch (paramMotionEvent.getAction() & 0xFF)
        {
        default: 
          return false;
        case 0: 
          this.cgW = k;
          this.cgV = k;
          this.cgY = m;
          this.cgX = m;
          if (bw(k, m)) {
            this.bvO = true;
          }
          break;
        }
      } while ((!this.bvN) || (((this.chd != 0) || (this.cgV <= this.cgS)) && ((this.chd != 1) || (this.cgV >= this.mWidth + this.cgS))));
      this.bvO = true;
      return true;
    } while (!this.bvO);
    if ((!this.bvM) && ((k > this.cgW) || (k > this.cgV)))
    {
      this.bvO = false;
      return false;
    }
    this.cgW = k;
    this.cgY = m;
    int k = Math.abs(this.cgW - this.cgV);
    int m = Math.abs(this.cgY - this.cgX);
    if ((k > i) && ((m + 0.0F) / k < 0.6F))
    {
      i = 1;
      if (i != 0)
      {
        if (!this.bvN) {
          break label342;
        }
        this.j.removeMessages(1);
        this.j.removeMessages(2);
        this.j.removeMessages(4);
        this.j.removeMessages(3);
      }
      label323:
      if ((i == 0) || (!aGs())) {
        break label428;
      }
    }
    for (;;)
    {
      return bool;
      i = 0;
      break;
      label342:
      if ((aGs()) || (this.a == null)) {
        break label323;
      }
      if ((this.cgW > this.cgV) && (this.daa))
      {
        this.daa = false;
        this.a.CN(0);
        break label323;
      }
      if ((this.cgW >= this.cgV) || (!this.cZZ)) {
        break label323;
      }
      this.cZZ = false;
      this.a.CN(1);
      break label323;
      label428:
      bool = false;
    }
    this.bvO = false;
    this.cgW = -1;
    this.cgV = -1;
    this.cgY = -1;
    this.cgX = -1;
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = this.mWidth;
    this.mWidth = (paramInt3 - paramInt1);
    this.mHeight = (paramInt4 - paramInt2);
    this.cgT = this.mWidth;
    this.cgU = this.mWidth;
    if ((this.cS == null) && (this.mWidth > 0) && (this.mHeight > 0)) {
      setTouchableBound(0, 0, this.mWidth, this.mHeight);
    }
    FrameLayout.LayoutParams localLayoutParams;
    if ((this.Jy != null) && (this.Jy.getVisibility() != 8))
    {
      localLayoutParams = (FrameLayout.LayoutParams)this.Jy.getLayoutParams();
      this.Jy.layout(localLayoutParams.leftMargin + paramInt1, localLayoutParams.topMargin + paramInt2, paramInt3 - localLayoutParams.rightMargin, paramInt4 - localLayoutParams.bottomMargin);
    }
    if ((this.zv != null) && (this.zv.getVisibility() != 8))
    {
      localLayoutParams = (FrameLayout.LayoutParams)this.zv.getLayoutParams();
      this.zv.layout(localLayoutParams.leftMargin + paramInt1, localLayoutParams.topMargin + paramInt2, paramInt3 - localLayoutParams.rightMargin, paramInt4 - localLayoutParams.bottomMargin);
    }
    if ((this.mContentView != null) && (this.mContentView.getVisibility() != 8)) {
      this.mContentView.layout(this.mContentView.getLeft(), this.mContentView.getTop(), this.mContentView.getLeft() + paramInt3, this.mContentView.getTop() + paramInt4);
    }
    if ((i != this.mWidth) && (i != 0))
    {
      this.j.removeMessages(5);
      this.j.sendEmptyMessage(5);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isDraggable()) {
      return false;
    }
    int i = (int)(paramMotionEvent.getX() + 0.5F);
    int k = (int)(paramMotionEvent.getY() + 0.5F);
    int m = i - this.cgW;
    int n = this.cgY;
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    this.cgW = i;
    this.cgY = k;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      return false;
    case 0: 
      if (this.bvN)
      {
        this.j.removeMessages(1);
        this.j.removeMessages(2);
        this.j.removeMessages(4);
        this.j.removeMessages(3);
      }
    case 2: 
      boolean bool = this.bvN;
      this.bvN = true;
      if ((!bool) && (this.a != null)) {
        this.a.AD(this.chd);
      }
      Yp(m);
      return true;
    }
    Yq(m);
    return true;
  }
  
  public void openDrawer(int paramInt, boolean paramBoolean)
  {
    int i = 300;
    if ((!isDraggable()) || (!aGs())) {
      return;
    }
    this.chd = paramInt;
    if (this.bvN)
    {
      this.j.removeMessages(1);
      this.j.removeMessages(2);
      this.j.removeMessages(4);
      this.j.removeMessages(3);
      label63:
      if (this.chd != 0) {
        break label162;
      }
      this.Jy.setVisibility(0);
    }
    for (;;)
    {
      this.bvN = true;
      if (this.a != null) {
        this.a.AD(this.chd);
      }
      switch (paramInt)
      {
      default: 
        if (this.a != null) {
          this.a.cbB();
        }
        this.j.sendEmptyMessage(1);
        return;
        if (!this.bvM) {
          break label63;
        }
        return;
        label162:
        if (this.chd == 1) {
          this.zv.setVisibility(0);
        }
        break;
      }
    }
    Scroller localScroller = this.mScroller;
    paramInt = this.cgS;
    int k = this.cgT;
    int m = this.cgS;
    if (paramBoolean) {}
    for (;;)
    {
      localScroller.startScroll(paramInt, 0, k - m, 0, i);
      break;
      i = 1;
    }
    localScroller = this.mScroller;
    paramInt = this.cgS;
    k = -this.cgU;
    m = this.cgS;
    if (paramBoolean) {}
    for (;;)
    {
      localScroller.startScroll(paramInt, 0, k - m, 0, i);
      break;
      i = 1;
    }
  }
  
  public void setDrawerCallbacks(a parama)
  {
    this.a = parama;
  }
  
  public void setDrawerEnabled(boolean paramBoolean)
  {
    this.bvL = paramBoolean;
  }
  
  public void setTouchableBound(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.cS == null) {
      this.cS = new Rect();
    }
    this.cS.left = paramInt1;
    this.cS.top = paramInt2;
    this.cS.right = paramInt3;
    this.cS.bottom = paramInt4;
  }
  
  public static abstract interface a
  {
    public abstract void AD(int paramInt);
    
    public abstract void CN(int paramInt);
    
    public abstract void cbB();
    
    public abstract void cbC();
    
    public abstract void m(int paramInt, float paramFloat);
    
    public abstract void onDrawerClosed();
    
    public abstract void onDrawerOpened();
  }
  
  public static class b
    implements Interpolator
  {
    public float getInterpolation(float paramFloat)
    {
      return (float)(Math.pow(paramFloat - 1.0D, 3.0D) + 1.0D);
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean onInterceptTouchEvent(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DrawerFrame
 * JD-Core Version:    0.7.0.1
 */