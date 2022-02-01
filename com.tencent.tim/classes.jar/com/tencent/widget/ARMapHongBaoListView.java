package com.tencent.widget;

import adud;
import adue;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import ausd;
import com.tencent.qphone.base.util.QLog;
import ram;

public class ARMapHongBaoListView
  extends HongBaoListView
{
  private a jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$a;
  private b jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$b;
  private c jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$c;
  public adud b;
  public adue b;
  public volatile adud c;
  private Handler dX = new Handler(Looper.getMainLooper(), new ausd(this));
  private boolean djK = true;
  public boolean djL;
  public boolean djM = true;
  boolean djN = true;
  boolean djO = true;
  boolean djP;
  private int mScrollState;
  
  public ARMapHongBaoListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ARMapHongBaoListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void aba(int paramInt)
  {
    if ((this.jdField_b_of_type_Adue != null) && (!this.jdField_b_of_type_Adue.afB()))
    {
      this.jdField_b_of_type_Adue.Lx(0);
      this.jdField_b_of_type_Adue.Ly(paramInt);
    }
  }
  
  public void a(adud paramadud)
  {
    this.djP = true;
    this.c = paramadud;
    if (QLog.isColorLevel()) {
      QLog.i("ARMapHongBaoListView", 2, "showBreathLight:");
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$b != null) {
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$b.onFlingScrollHeader(this.mScrollState, getScrollY());
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int k = 0;
    super.draw(paramCanvas);
    int j;
    if (((this.mActive) && (this.djL) && (this.dkv) && (this.djN)) || (this.dkx))
    {
      j = getListViewScrollY();
      i = j;
      if (j < 0) {
        i = 0;
      }
      if (this.jdField_b_of_type_Adud == null) {
        break label181;
      }
      this.jdField_b_of_type_Adud.offsetY = (-i);
      if (!this.jdField_b_of_type_Adud.draw(paramCanvas)) {
        break label181;
      }
    }
    label181:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        invalidate();
      }
      if ((this.djP) && (this.c != null) && (this.djO))
      {
        j = getListViewScrollY();
        i = j;
        if (j < 0) {
          i = 0;
        }
        j = k;
        if (this.djP)
        {
          j = k;
          if (this.c != null)
          {
            this.c.offsetY = (-i);
            j = k;
            if (this.c.draw(paramCanvas)) {
              j = 1;
            }
          }
        }
        if (j != 0) {
          invalidate();
        }
      }
      return;
    }
  }
  
  public void ewC()
  {
    this.dX.removeMessages(1);
    this.dX.removeMessages(2);
    setIsShowingPreguide(false);
  }
  
  public void ewD()
  {
    this.djP = false;
    this.c = null;
    if (QLog.isColorLevel()) {
      QLog.i("ARMapHongBaoListView", 2, "dismissBreathLight:");
    }
  }
  
  protected int getSpringbackOffset()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "story getSpringbackOffset, scrollY:" + getScrollY());
    }
    if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$b == null) {
      return super.getSpringbackOffset();
    }
    int i = getScrollY();
    if ((this.mEnableStory) && (this.mOverscrollHeaderViewContainer != null) && (i <= 0))
    {
      if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$b.getMode() == 2)
      {
        ram.d("ARMapHongBaoListView", "story node start refresh getSpringbackOffset.");
        this.mOverscrollHeadState = 2;
        super.getSpringbackOffset();
      }
      return this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$b.getSpringbackOffset(this);
    }
    return super.getSpringbackOffset();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((!this.mActive) || (!this.dkv)) && (!this.dkx)) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    if (((this.jdField_b_of_type_Adue != null) && (!this.jdField_b_of_type_Adue.aTW)) || (!this.djK)) {
      return true;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$a != null) {
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$a.a(this);
    }
    int i;
    if ((this.djL) && (this.jdField_b_of_type_Adud != null))
    {
      i = getListViewScrollY();
      int j = getScrollY();
      if (j >= 0) {
        break label185;
      }
      i = j;
    }
    label185:
    for (;;)
    {
      float f = paramMotionEvent.getY();
      if (!this.jdField_b_of_type_Adud.a(i).contains(paramMotionEvent.getX(), f)) {
        break;
      }
      this.dky = true;
      super.onInterceptTouchEvent(paramMotionEvent);
      return true;
      this.dky = false;
      ewC();
      break;
    }
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    if (!this.dkv) {}
    while (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$a == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$a.onOverScroll(paramInt1, paramInt2);
  }
  
  public boolean onRequestSendAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "onRequestSendAccessibilityEvent() called with: child = [" + paramView + "], event = [" + paramAccessibilityEvent + "]");
    }
    boolean bool = super.onRequestSendAccessibilityEvent(paramView, paramAccessibilityEvent);
    if (paramAccessibilityEvent.getEventType() == 32768)
    {
      int i = paramView.getBottom() - (getHeight() - getListPaddingBottom());
      if (i > 0) {
        smoothScrollBy(i, 200);
      }
    }
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    boolean bool1;
    if ((this.mEnableStory) && (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$b != null))
    {
      b localb = this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$b;
      if ((this.mTouchMode == 3) || (this.mTouchMode == 5))
      {
        bool1 = true;
        localb.onTouchMoving(this, bool1, paramMotionEvent);
      }
    }
    else
    {
      if (((this.mActive) && (this.dkv)) || (this.dkx)) {
        break label93;
      }
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    label93:
    label114:
    do
    {
      do
      {
        return bool1;
        bool1 = false;
        break;
        if (this.jdField_b_of_type_Adue == null) {
          break label114;
        }
        bool1 = bool3;
      } while (!this.jdField_b_of_type_Adue.aTW);
      bool1 = bool3;
    } while (!this.djK);
    int i = paramMotionEvent.getAction();
    bool3 = super.onTouchEvent(paramMotionEvent);
    switch (i & 0xFF)
    {
    case 0: 
    default: 
    case 2: 
      for (;;)
      {
        return bool3;
        if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$a != null)
        {
          paramMotionEvent = this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$a;
          if (this.mTouchMode != 3)
          {
            bool1 = bool2;
            if (this.mTouchMode != 5) {}
          }
          else
          {
            bool1 = true;
          }
          paramMotionEvent.a(this, bool1);
        }
      }
    case 1: 
      if ((this.dky) && ((this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$a != null) || (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$c != null)) && (this.jdField_b_of_type_Adud != null))
      {
        i = getListViewScrollY();
        int j = getScrollY();
        if (j >= 0) {
          break label370;
        }
        i = j;
      }
      break;
    }
    label370:
    for (;;)
    {
      float f = paramMotionEvent.getY();
      if ((this.jdField_b_of_type_Adud.a(i).contains(paramMotionEvent.getX(), f)) && (this.djN))
      {
        if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$a != null) {
          this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$a.ewE();
        }
        if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$c != null) {
          this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$c.aa(paramMotionEvent.getX(), f);
        }
      }
      if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$a != null) {
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$a.c(this);
      }
      this.dky = false;
      break;
      this.dky = false;
      break;
    }
  }
  
  public void setActiveListViewListener(a parama)
  {
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$a = parama;
  }
  
  public void setEnableTouch(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "setEnableTouch, enableTouch:" + paramBoolean);
    }
    this.djK = paramBoolean;
  }
  
  public void setOnPendentClickListener(c paramc)
  {
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$c = paramc;
  }
  
  public void setPendantHolder(adud paramadud)
  {
    boolean bool = true;
    this.jdField_b_of_type_Adud = paramadud;
    this.dkx = true;
    if (this.jdField_b_of_type_Adud != null) {}
    for (;;)
    {
      this.djL = bool;
      invalidate();
      return;
      bool = false;
    }
  }
  
  public void setQQStoryListViewListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$b = paramb;
  }
  
  public void setScrollState(int paramInt)
  {
    this.mScrollState = paramInt;
  }
  
  public void setShowLightByUser(boolean paramBoolean)
  {
    this.djO = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.i("ARMapHongBaoListView", 2, "setShowLightByUser:" + this.djO);
    }
  }
  
  public void springBackOverScrollHeaderView()
  {
    if ((this.mEnableStory) && (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$b != null))
    {
      this.mOverscrollHeadState = 0;
      super.springBackOverScrollHeaderView(this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$b.onViewCompleteAfterRefresh(this));
      return;
    }
    super.springBackOverScrollHeaderView();
  }
  
  public static abstract interface a
  {
    public abstract void GJ(boolean paramBoolean);
    
    public abstract void Nx(boolean paramBoolean);
    
    public abstract void a(HongBaoListView paramHongBaoListView);
    
    public abstract void a(HongBaoListView paramHongBaoListView, boolean paramBoolean);
    
    public abstract void c(HongBaoListView paramHongBaoListView);
    
    public abstract void ewE();
    
    public abstract void onOverScroll(int paramInt1, int paramInt2);
  }
  
  public static abstract interface b
  {
    public abstract int getMode();
    
    public abstract int getSpringbackOffset(ARMapHongBaoListView paramARMapHongBaoListView);
    
    public abstract void onFlingScrollHeader(int paramInt1, int paramInt2);
    
    public abstract void onTouchMoving(ARMapHongBaoListView paramARMapHongBaoListView, boolean paramBoolean, MotionEvent paramMotionEvent);
    
    public abstract int onViewCompleteAfterRefresh(ARMapHongBaoListView paramARMapHongBaoListView);
  }
  
  public static abstract interface c
  {
    public abstract void aa(float paramFloat1, float paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.ARMapHongBaoListView
 * JD-Core Version:    0.7.0.1
 */