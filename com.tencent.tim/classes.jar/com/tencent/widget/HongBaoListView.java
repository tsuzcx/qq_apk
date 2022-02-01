package com.tencent.widget;

import akze;
import akzr;
import alad;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import autt;
import autu;
import auuo;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class HongBaoListView
  extends FPSSwipListView
{
  public boolean[] A = new boolean[10];
  View Lj;
  public boolean aUN;
  private long azc;
  public akze b;
  public akzr b;
  public autu b;
  public float[] dQ = new float[10];
  public boolean dkA;
  public boolean dkv;
  public boolean dkw;
  public boolean dkx;
  public boolean dky;
  public boolean dkz;
  public int etu = -1;
  public int etv = 1;
  public int etw;
  public int etx;
  auuo f;
  Drawable gG;
  Drawable gH;
  public Bitmap gY;
  public boolean mActive;
  public Handler mHandler = new Handler(Looper.getMainLooper(), new autt(this));
  
  public HongBaoListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public HongBaoListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int ON()
  {
    return computeVerticalScrollOffset();
  }
  
  public void abi(int paramInt)
  {
    setHongBaoAlpha(255);
    setSelection(0);
    this.mHandler.removeMessages(5);
    this.mHandler.removeMessages(6);
    this.mHandler.removeMessages(7);
    Message localMessage = Message.obtain(this.mHandler, 5, paramInt, 0);
    this.mHandler.sendMessageDelayed(localMessage, 150L);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int j = 0;
    super.draw(paramCanvas);
    if ((this.mActive) && (this.dkz) && (!this.dkv))
    {
      int k = getListViewScrollY();
      int i = k;
      if (k < 0) {
        i = 0;
      }
      this.jdField_b_of_type_Akzr.offsetY = (-i);
      i = j;
      if (this.jdField_b_of_type_Akzr.draw(paramCanvas)) {
        i = 1;
      }
      if (i != 0) {
        invalidate();
      }
    }
  }
  
  public void ewR()
  {
    super.setOverScrollListener(this.f);
    ewS();
    setComboListener(null);
    super.setOverscrollHeader(this.gH);
    super.setOverScrollHeader(this.Lj);
    super.setContentBackground(this.gG);
    setOverscrollHeaderShadowEnable(true);
    this.mActive = false;
    ewW();
    ewT();
    this.mForHongBao = false;
    this.dkv = false;
    this.dkw = false;
  }
  
  public void ewS()
  {
    if (this.mActive == true)
    {
      if (this.dkA)
      {
        auup.BOUNCE_DURANTION = 300;
        return;
      }
      auup.BOUNCE_DURANTION = 600;
      return;
    }
    auup.BOUNCE_DURANTION = 400;
  }
  
  public void ewT()
  {
    if (this.dkv) {
      return;
    }
    this.mHandler.removeMessages(1);
    this.mHandler.removeMessages(2);
    setIsShowingPreguide(false);
  }
  
  public void ewU()
  {
    ewV();
    this.jdField_b_of_type_Akzr.a(false, this.gY);
    this.jdField_b_of_type_Akzr.dEx();
    invalidate();
  }
  
  public void ewV()
  {
    this.jdField_b_of_type_Akzr.stopAnimation();
    if (this.jdField_b_of_type_Akzr.a != null) {
      this.jdField_b_of_type_Akzr.a.stopAnimation();
    }
  }
  
  public void ewW()
  {
    if (!this.dkz) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "hideHongBao ," + this.dkz);
    }
    ewV();
    this.dkz = false;
  }
  
  public void ewX()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "showHongBao ," + this.dkz);
    }
    ewV();
    this.dkz = true;
    this.jdField_b_of_type_Akzr.alpha = 255;
  }
  
  public int getListViewScrollY()
  {
    View localView = getChildAt(0);
    if (localView == null) {
      return getScrollY();
    }
    int k = getFirstVisiblePosition();
    if (k >= this.mHeaderViewInfos.size())
    {
      Iterator localIterator = this.mHeaderViewInfos.iterator();
      for (i = 0; localIterator.hasNext(); i = ((ListView.b)localIterator.next()).view.getHeight() + i) {}
      return -localView.getTop() + (k - this.mHeaderViewInfos.size()) * localView.getHeight() + i;
    }
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += ((ListView.b)this.mHeaderViewInfos.get(i)).view.getHeight();
      i += 1;
    }
    return -localView.getTop() + j;
  }
  
  protected int getSpringbackOffset()
  {
    if ((!this.mActive) || (this.dkv)) {
      return super.getSpringbackOffset();
    }
    return this.etw;
  }
  
  public boolean isOverscrollHeadVisiable()
  {
    if (this.mActive) {
      return getScrollY() < 0;
    }
    return super.isOverscrollHeadVisiable();
  }
  
  public void ny(long paramLong)
  {
    springBackOverScrollHeaderView();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((!this.mActive) || (this.dkv)) {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
    }
    while (!this.jdField_b_of_type_Akze.aTW) {
      return bool;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      this.dQ[0] = paramMotionEvent.getY();
      this.A[0] = true;
      if (this.jdField_b_of_type_Autu != null) {
        this.jdField_b_of_type_Autu.a(this);
      }
      if ((this.dkz) && (this.jdField_b_of_type_Akzr != null) && (this.jdField_b_of_type_Akzr.a(getScrollY()).contains(paramMotionEvent.getX(), paramMotionEvent.getY())))
      {
        if (getScrollY() == 0) {
          this.dky = true;
        }
        super.onInterceptTouchEvent(paramMotionEvent);
        return true;
      }
      this.dky = false;
      ewT();
    }
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      if (this.dkv) {
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      } while (this.jdField_b_of_type_Autu == null);
      this.jdField_b_of_type_Autu.onOverScroll(paramInt1, paramInt2);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_b_of_type_Akzr != null) && (this.jdField_b_of_type_Akzr.a != null)) {
      this.jdField_b_of_type_Akzr.a.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((!this.mActive) || (this.dkv)) {
      bool = super.onTouchEvent(paramMotionEvent);
    }
    while (!this.jdField_b_of_type_Akze.aTW) {
      return bool;
    }
    bool = super.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return bool;
      if (this.jdField_b_of_type_Autu != null) {
        this.jdField_b_of_type_Autu.b(this);
      }
      if (paramMotionEvent.findPointerIndex(this.etu) == -1) {}
      switch (this.mTouchMode)
      {
      case 4: 
      default: 
        break;
      case 3: 
      case 5: 
        if (this.jdField_b_of_type_Autu != null)
        {
          int i = paramMotionEvent.getPointerCount();
          if (i > this.etv) {
            this.etv = i;
          }
          float f1 = 0.0F;
          i = 0;
          while (i < paramMotionEvent.getPointerCount())
          {
            float f3 = paramMotionEvent.getY(i) - this.dQ[i];
            float f2 = f1;
            if (this.A[i] != 0)
            {
              f2 = f1;
              if (f3 > f1) {
                f2 = f3;
              }
            }
            i += 1;
            f1 = f2;
          }
          if (-getScrollY() >= this.etx / 2)
          {
            if (f1 > this.etx / 2)
            {
              setSpringbackOffset(-this.etx);
              this.jdField_b_of_type_Autu.dEq();
              i = 0;
              while (i < this.etv)
              {
                this.A[i] = false;
                i += 1;
              }
            }
            this.jdField_b_of_type_Autu.dEo();
            continue;
            if (this.dky)
            {
              long l = System.currentTimeMillis();
              if ((this.jdField_b_of_type_Akzr != null) && (l - this.azc > 800L) && (getScrollY() == 0))
              {
                this.azc = l;
                if (this.jdField_b_of_type_Akzr.a(getScrollY()).contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
                  this.jdField_b_of_type_Autu.dEp();
                }
              }
            }
            this.dky = false;
            if (this.jdField_b_of_type_Autu != null) {
              this.jdField_b_of_type_Autu.c(this);
            }
            this.etu = -1;
            continue;
            this.etu = -1;
            this.dky = false;
            continue;
            i = paramMotionEvent.getActionIndex();
            this.dQ[i] = ((int)paramMotionEvent.getY(i));
            this.A[i] = true;
            continue;
            i = paramMotionEvent.getActionIndex();
            this.A[i] = false;
          }
        }
        break;
      }
    }
  }
  
  public void onTouchUpWithYVelocity(int paramInt1, int paramInt2) {}
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.aUN) {
      this.aUN = false;
    }
  }
  
  public void setComboListener(autu paramautu)
  {
    this.jdField_b_of_type_Autu = paramautu;
  }
  
  public void setContentBackground(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.gG = paramDrawable;
    }
    if (this.mForHongBao)
    {
      super.setContentBackground(paramDrawable, false);
      return;
    }
    super.setContentBackground(paramDrawable);
  }
  
  public void setHongBaoAlpha(int paramInt) {}
  
  public void setIsShowingPreguide(boolean paramBoolean)
  {
    this.dkA = paramBoolean;
    ewS();
  }
  
  public void setLogo(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Akzr != null) {
      this.jdField_b_of_type_Akzr.a(paramBoolean, paramBitmap);
    }
    this.gY = paramBitmap;
    invalidate();
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "setLogo ," + this.dkz + ", " + this.gY);
    }
  }
  
  public void setOverScrollHeader(View paramView)
  {
    if (paramView != null) {
      this.Lj = paramView;
    }
    if (this.mForHongBao)
    {
      super.setOverScrollHeader(null);
      return;
    }
    super.setOverScrollHeader(paramView);
  }
  
  public void setOverScrollListener(auuo paramauuo)
  {
    if (paramauuo != null) {
      this.f = paramauuo;
    }
    if (this.mForHongBao)
    {
      super.setOverScrollListener(null);
      return;
    }
    super.setOverScrollListener(paramauuo);
  }
  
  public void setOverscrollHeader(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.gH = paramDrawable;
    }
    if (this.mForHongBao)
    {
      super.setOverscrollHeader(null);
      return;
    }
    super.setOverscrollHeader(paramDrawable);
  }
  
  public void setOverscrollHeaderShadowEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mOverScrollHeaderShadow = getResources().getDrawable(2130841343);
      return;
    }
    this.mOverScrollHeaderShadow = null;
  }
  
  public void setSpringbackOffset(int paramInt)
  {
    this.etw = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.HongBaoListView
 * JD-Core Version:    0.7.0.1
 */