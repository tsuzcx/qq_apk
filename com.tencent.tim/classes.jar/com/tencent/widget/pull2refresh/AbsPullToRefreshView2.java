package com.tencent.widget.pull2refresh;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import auwy;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoySkinAnimManager;
import com.tencent.qphone.base.util.QLog;
import npy;
import nqb;
import rpq;

public abstract class AbsPullToRefreshView2
  extends LinearLayout
  implements Handler.Callback
{
  private auwy a;
  protected npy a;
  private int aVz;
  private int aXm;
  private int aXn;
  private int aXo = 10;
  private int aXp;
  private Drawable cI;
  private float kg = -1.0F;
  private float kh = -1.0F;
  protected View mFooterView;
  private Handler mHandler;
  protected View mHeaderView;
  private int mState = 0;
  protected boolean ob;
  
  public AbsPullToRefreshView2(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public AbsPullToRefreshView2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  @TargetApi(11)
  public AbsPullToRefreshView2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void aVu()
  {
    this.mHandler.removeMessages(1);
    this.mHandler.removeMessages(3);
  }
  
  private void cY(View paramView)
  {
    if (paramView == null) {
      return;
    }
    cZ(paramView);
    this.aXm = qr();
    this.aVz = paramView.getMeasuredHeight();
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, this.aVz);
    localLayoutParams.topMargin = (-this.aVz);
    super.addView(paramView, localLayoutParams);
  }
  
  private void cZ(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-1, -2);
    }
    int j = ViewGroup.getChildMeasureSpec(0, 0, localLayoutParams1.width);
    int i = localLayoutParams1.height;
    if (i > 0) {}
    for (i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);; i = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(j, i);
      return;
    }
  }
  
  private void de(int paramInt1, int paramInt2)
  {
    log("moveHeaderTo:" + paramInt1 + ",duration=" + paramInt2 + ",getHeaderCurPos()=" + qs());
    if (paramInt1 == qs()) {
      return;
    }
    this.mHandler.removeMessages(1);
    this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramInt1, paramInt2));
  }
  
  private void eO(long paramLong)
  {
    if (this.ob)
    {
      this.jdField_a_of_type_Auwy.q(this.mHeaderView, true);
      this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), paramLong);
      this.ob = false;
      this.mHandler.removeMessages(2);
    }
  }
  
  private void init()
  {
    a();
    super.setOrientation(1);
    this.mState = 0;
    this.mHandler = new Handler(Looper.getMainLooper(), this);
    this.mHeaderView = an();
    this.mFooterView = ao();
    this.aXp = rpq.dip2px(getContext(), 15.0F);
    this.aXn = ViewConfiguration.get(getContext()).getScaledMaximumFlingVelocity();
    cY(this.mHeaderView);
    setWillNotDraw(false);
  }
  
  private void log(String paramString)
  {
    Log.d("AbsPullToRefreshView2", paramString);
  }
  
  private void po(boolean paramBoolean)
  {
    pp(paramBoolean);
    getParent().requestDisallowInterceptTouchEvent(true);
  }
  
  private int qs()
  {
    return ((LinearLayout.LayoutParams)this.mHeaderView.getLayoutParams()).topMargin;
  }
  
  private void tm(int paramInt)
  {
    int i = 0;
    if (this.jdField_a_of_type_Auwy == null) {}
    do
    {
      return;
      switch (paramInt)
      {
      default: 
        return;
      }
    } while (this.ob);
    this.ob = true;
    this.jdField_a_of_type_Auwy.B(this.mHeaderView);
    return;
    paramInt = 100 - Math.abs((int)(qs() * 1.0F / -this.aVz * 100.0F));
    if (paramInt < 0) {
      paramInt = i;
    }
    while (!this.ob)
    {
      this.jdField_a_of_type_Auwy.M(this.mHeaderView, paramInt);
      return;
      if (this.ob) {
        break;
      }
      this.jdField_a_of_type_Auwy.dd(this.mHeaderView);
      return;
      if (this.ob)
      {
        this.jdField_a_of_type_Auwy.q(this.mHeaderView, false);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), 1000L);
      }
      this.ob = false;
      this.mHandler.removeMessages(2);
      return;
      if (this.ob)
      {
        this.jdField_a_of_type_Auwy.q(this.mHeaderView, true);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), 0L);
      }
      this.ob = false;
      this.mHandler.removeMessages(2);
      return;
    }
  }
  
  private void tn(int paramInt)
  {
    log("moveHeaderSmoothlyBy dy=" + paramInt);
    if (Math.abs(paramInt) > this.aXp * 2) {
      return;
    }
    to(paramInt);
  }
  
  private void to(int paramInt)
  {
    log("moveHeaderBy dy=" + paramInt);
    if (paramInt == 0) {
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mHeaderView.getLayoutParams();
    localLayoutParams.topMargin -= paramInt;
    this.mHeaderView.setLayoutParams(localLayoutParams);
    invalidate();
  }
  
  protected abstract boolean Fi();
  
  protected abstract boolean Fj();
  
  protected npy a()
  {
    return a(1);
  }
  
  public npy a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsPullToRefreshView2", 1, "setAnimType animType = " + paramInt);
    }
    if ((this.jdField_a_of_type_Npy != null) && ((this.jdField_a_of_type_Npy instanceof ReadInJoySkinAnimManager))) {
      this.jdField_a_of_type_Npy.onDestroy();
    }
    this.jdField_a_of_type_Npy = nqb.a(getContext(), paramInt);
    return this.jdField_a_of_type_Npy;
  }
  
  protected void a(auwy paramauwy)
  {
    this.jdField_a_of_type_Auwy = paramauwy;
  }
  
  public void aVt()
  {
    if (Fi())
    {
      this.mHandler.removeMessages(3);
      de(this.aXm / 2 - this.aVz, 100);
      this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), 100L);
    }
    while (!Fj()) {
      return;
    }
    this.mHandler.removeMessages(3);
    de(-this.aVz - this.aXm, 100);
    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), 100L);
  }
  
  protected abstract View an();
  
  protected abstract View ao();
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      log("dispatchTouchEvent: ------down------ getY=" + paramMotionEvent.getY());
      aVu();
      this.kh = paramMotionEvent.getX();
      this.kg = paramMotionEvent.getY();
      continue;
      float f2 = this.kh - paramMotionEvent.getX();
      float f1 = this.kg - paramMotionEvent.getY();
      int i = qs();
      log("dispatchTouchEvent: move getY=" + paramMotionEvent.getY() + ",isScroll2Top()()=" + Fi() + ",mHeaderHeight=" + this.aVz + ",currentHeaderPos=" + i + ",dy=" + f1 + ",dx=" + f2);
      this.kh = paramMotionEvent.getX();
      this.kg = paramMotionEvent.getY();
      if (Math.abs(f1) / Math.abs(f2) < 5.0F)
      {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
      else
      {
        if ((Fi()) && (f1 < 0.0F))
        {
          tn((int)f1 / 2);
          po(true);
        }
        for (;;)
        {
          i = qs();
          if (i <= this.aXm - this.aVz) {
            break label463;
          }
          tl(4);
          break;
          if (i > -this.aVz)
          {
            if (paramMotionEvent.getPointerCount() > 1)
            {
              po(true);
            }
            else if (Math.abs(f1) > 0.0F)
            {
              f2 = f1;
              if (i - f1 < -this.aVz) {
                f2 = this.aVz + i;
              }
              tn((int)f2);
              po(true);
            }
          }
          else if (i < -this.aVz)
          {
            if (paramMotionEvent.getPointerCount() > 1)
            {
              po(true);
            }
            else if (Math.abs(f1) > 0.0F)
            {
              f2 = f1;
              if (i - f1 > -this.aVz) {
                f2 = this.aVz + i;
              }
              tn((int)f2);
              po(true);
            }
          }
          else {
            po(false);
          }
        }
        label463:
        if (i > -this.aVz)
        {
          tl(5);
        }
        else if (i < -this.aVz)
        {
          tl(6);
          continue;
          log("dispatchTouchEvent: *******up****** mState=" + this.mState);
          getParent().requestDisallowInterceptTouchEvent(false);
          this.kg = -1.0F;
          this.kh = -1.0F;
          if (this.mState == 4) {
            tl(1);
          } else if (this.mState == 5) {
            tl(0);
          } else if (this.mState == 6) {
            tl(0);
          } else if (qs() != -this.aVz) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
          }
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 0: 
      tl(0);
      return true;
    case 3: 
      de(-this.aVz, 100);
      this.mHandler.removeMessages(2);
      return true;
    case 2: 
      tl(3);
      return true;
    }
    int i = paramMessage.arg1;
    int k = paramMessage.arg2;
    int j = (i - qs()) * this.aXo / k;
    k -= this.aXo;
    if ((k <= 0) || ((j == 0) && (qs() - i > 0)))
    {
      to(qs() - i);
      return true;
    }
    to(-j);
    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, i, k), this.aXo);
    return true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = qs() + this.aVz;
    if ((i > 0) && (this.cI != null))
    {
      this.cI.setBounds(0, 0, getWidth(), i);
      this.cI.draw(paramCanvas);
    }
    super.onDraw(paramCanvas);
  }
  
  public void pn(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      tl(2);
      return;
    }
    tl(3);
  }
  
  protected abstract void pp(boolean paramBoolean);
  
  protected int qr()
  {
    return rpq.dip2px(getContext(), 60.0F);
  }
  
  public void setPullHeaderBgDrawable(Drawable paramDrawable)
  {
    this.cI = paramDrawable;
  }
  
  public void t(boolean paramBoolean, String paramString)
  {
    if ((this.jdField_a_of_type_Npy != null) && (this.ob))
    {
      eO(1500L);
      this.jdField_a_of_type_Npy.t(paramBoolean, paramString);
    }
  }
  
  protected void tl(int paramInt)
  {
    if ((this.mState == paramInt) && (paramInt != 5)) {
      return;
    }
    log("change to state:" + paramInt);
    this.mState = paramInt;
    switch (this.mState)
    {
    }
    for (;;)
    {
      tm(this.mState);
      return;
      de(-this.aVz, 200);
      this.mHandler.removeMessages(2);
      continue;
      de(this.aXm - this.aVz, 200);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.AbsPullToRefreshView2
 * JD-Core Version:    0.7.0.1
 */