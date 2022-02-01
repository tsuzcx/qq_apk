package com.tencent.mobileqq.ocr.view.gesture.control;

import akpc;
import akpd;
import akpe;
import akpg;
import akph;
import akpi;
import akpm;
import akpn;
import akpp;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.OverScroller;
import com.tencent.mobileqq.ocr.view.gesture.GestureProxy.StateSource;
import com.tencent.mobileqq.ocr.view.gesture.GestureProxy.a;
import com.tencent.mobileqq.ocr.view.gesture.GestureProxy.b;
import com.tencent.mobileqq.ocr.view.gesture.Settings;
import com.tencent.mobileqq.ocr.view.gesture.animation.AnimationEngine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GestureController
{
  private static final PointF Z = new PointF();
  private static final RectF aI = new RectF();
  private static final float[] cS = new float[2];
  protected final List<GestureProxy.a> El = new ArrayList();
  private final akpc jdField_a_of_type_Akpc;
  protected akpe a;
  private final akph jdField_a_of_type_Akph;
  private final akpi jdField_a_of_type_Akpi;
  protected final akpm a;
  protected final akpn a;
  private GestureProxy.StateSource jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureProxy$StateSource = GestureProxy.StateSource.NONE;
  protected GestureProxy.b a;
  protected final Settings a;
  private final AnimationEngine jdField_a_of_type_ComTencentMobileqqOcrViewGestureAnimationAnimationEngine;
  protected final akpm b;
  private final ScaleGestureDetector jdField_b_of_type_AndroidViewScaleGestureDetector;
  private final OverScroller jdField_b_of_type_AndroidWidgetOverScroller;
  protected final akpm c = new akpm();
  private boolean ctI;
  private boolean ctJ;
  private boolean ctK;
  private boolean ctL;
  private boolean ctM;
  private boolean ctN;
  private boolean ctO;
  private boolean ctP;
  private boolean ctQ;
  protected final akpm d = new akpm();
  private final int doI;
  private final int doJ;
  private final GestureDetector gestureDetector;
  protected final View targetView;
  private final int touchSlop;
  protected float xS = (0.0F / 0.0F);
  protected float xT = (0.0F / 0.0F);
  private float xU = (0.0F / 0.0F);
  private float xV = (0.0F / 0.0F);
  
  public GestureController(View paramView)
  {
    this.jdField_a_of_type_Akpm = new akpm();
    this.jdField_b_of_type_Akpm = new akpm();
    Context localContext = paramView.getContext();
    this.targetView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings = new Settings();
    this.jdField_a_of_type_Akpn = new akpn(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureAnimationAnimationEngine = new LocalAnimationEngine(paramView);
    paramView = new akpd(this);
    this.gestureDetector = new GestureDetector(localContext, paramView);
    this.jdField_b_of_type_AndroidViewScaleGestureDetector = new akpg(localContext, paramView);
    this.jdField_a_of_type_Akph = new akph(localContext, paramView);
    this.jdField_b_of_type_AndroidWidgetOverScroller = new OverScroller(localContext);
    this.jdField_a_of_type_Akpc = new akpc();
    this.jdField_a_of_type_Akpi = new akpi(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings);
    paramView = ViewConfiguration.get(localContext);
    this.touchSlop = paramView.getScaledTouchSlop();
    this.doI = paramView.getScaledMinimumFlingVelocity();
    this.doJ = paramView.getScaledMaximumFlingVelocity();
  }
  
  private boolean a(akpm paramakpm, boolean paramBoolean)
  {
    if (paramakpm == null) {}
    for (;;)
    {
      return false;
      akpm localakpm = null;
      if (paramBoolean) {
        localakpm = this.jdField_a_of_type_Akpn.a(paramakpm, this.d, this.xS, this.xT, false, false, true);
      }
      if (localakpm == null) {}
      while (!paramakpm.equals(this.c))
      {
        dCB();
        this.ctQ = paramBoolean;
        this.jdField_a_of_type_Akpm.c(this.c);
        this.jdField_b_of_type_Akpm.c(paramakpm);
        if ((!Float.isNaN(this.xS)) && (!Float.isNaN(this.xT)))
        {
          cS[0] = this.xS;
          cS[1] = this.xT;
          akpp.a(cS, this.jdField_a_of_type_Akpm, this.jdField_b_of_type_Akpm);
          this.xU = cS[0];
          this.xV = cS[1];
        }
        this.jdField_a_of_type_Akpc.setDuration(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.gv());
        this.jdField_a_of_type_Akpc.T(0.0F, 1.0F);
        this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureAnimationAnimationEngine.start(2);
        dCE();
        return true;
        paramakpm = localakpm;
      }
    }
  }
  
  private void dCE()
  {
    GestureProxy.StateSource localStateSource = GestureProxy.StateSource.NONE;
    if (isAnimating()) {}
    for (localStateSource = GestureProxy.StateSource.ANIMATION;; localStateSource = GestureProxy.StateSource.USER) {
      do
      {
        if (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureProxy$StateSource != localStateSource)
        {
          this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureProxy$StateSource = localStateSource;
          if (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureProxy$b != null) {
            this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureProxy$b.a(localStateSource);
          }
        }
        return;
      } while ((!this.ctK) && (!this.ctL) && (!this.ctM));
    }
  }
  
  private int u(float paramFloat)
  {
    if (Math.abs(paramFloat) < this.doI) {
      return 0;
    }
    if (Math.abs(paramFloat) >= this.doJ) {
      return (int)Math.signum(paramFloat) * this.doJ;
    }
    return Math.round(paramFloat);
  }
  
  protected void MZ(boolean paramBoolean)
  {
    this.ctQ = false;
    this.xS = (0.0F / 0.0F);
    this.xT = (0.0F / 0.0F);
    dCE();
  }
  
  protected void Na(boolean paramBoolean)
  {
    if (!paramBoolean) {
      asu();
    }
    dCE();
  }
  
  public void a(akph paramakph)
  {
    this.ctM = false;
    this.ctP = true;
  }
  
  public boolean a(akph paramakph)
  {
    this.ctM = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.ask();
    return this.ctM;
  }
  
  public boolean a(akpm paramakpm)
  {
    return a(paramakpm, true);
  }
  
  protected void ab(MotionEvent paramMotionEvent)
  {
    this.ctK = false;
    this.ctL = false;
    this.ctM = false;
    if ((!asw()) && (!this.ctQ)) {
      asu();
    }
    if (this.jdField_a_of_type_Akpe != null) {
      this.jdField_a_of_type_Akpe.ab(paramMotionEvent);
    }
  }
  
  protected boolean am(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    }
    do
    {
      return false;
      this.jdField_a_of_type_Akpn.a(this.c, aI);
      if ((akpm.compare(aI.width(), 0.0F) > 0) || (akpm.compare(aI.height(), 0.0F) > 0)) {}
      for (int i = 1; (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.ash()) && ((i != 0) || (!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.asp())); i = 0) {
        return true;
      }
    } while ((!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.asj()) && (!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.ask()));
    return true;
  }
  
  public boolean asu()
  {
    return a(this.c, true);
  }
  
  public boolean asv()
  {
    return !this.jdField_a_of_type_Akpc.isFinished();
  }
  
  public boolean asw()
  {
    return !this.jdField_b_of_type_AndroidWidgetOverScroller.isFinished();
  }
  
  public boolean b(akph paramakph)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.ask()) || (asv())) {
      return false;
    }
    this.xS = paramakph.getFocusX();
    this.xT = paramakph.getFocusY();
    this.c.l(paramakph.bn(), this.xS, this.xT);
    this.ctN = true;
    return true;
  }
  
  protected boolean bb(int paramInt1, int paramInt2)
  {
    float f5 = this.c.getX();
    float f6 = this.c.getY();
    float f3 = f5 + paramInt1;
    float f4 = paramInt2 + f6;
    float f2 = f4;
    float f1 = f3;
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.asp())
    {
      this.jdField_a_of_type_Akpi.a(f3, f4, Z);
      f1 = Z.x;
      f2 = Z.y;
    }
    this.c.W(f1, f2);
    return (!akpm.equals(f5, f1)) || (!akpm.equals(f6, f2));
  }
  
  public void dCA()
  {
    if (asw())
    {
      this.jdField_b_of_type_AndroidWidgetOverScroller.forceFinished(true);
      Na(true);
    }
  }
  
  public void dCB()
  {
    dCz();
    dCA();
  }
  
  protected void dCC()
  {
    this.d.c(this.c);
    Iterator localIterator = this.El.iterator();
    while (localIterator.hasNext()) {
      ((GestureProxy.a)localIterator.next()).b(this.c);
    }
  }
  
  protected void dCD()
  {
    Iterator localIterator = this.El.iterator();
    while (localIterator.hasNext()) {
      ((GestureProxy.a)localIterator.next()).a(this.d, this.c);
    }
    dCC();
  }
  
  public void dCz()
  {
    if (asv())
    {
      this.jdField_a_of_type_Akpc.apC();
      MZ(true);
    }
  }
  
  public boolean isAnimating()
  {
    return (asv()) || (asw());
  }
  
  protected boolean m(View paramView, MotionEvent paramMotionEvent)
  {
    this.ctI = true;
    return n(paramView, paramMotionEvent);
  }
  
  protected boolean n(View paramView, MotionEvent paramMotionEvent)
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    localMotionEvent.offsetLocation(-paramView.getPaddingLeft(), -paramView.getPaddingTop());
    this.gestureDetector.setIsLongpressEnabled(paramView.isLongClickable());
    boolean bool = this.gestureDetector.onTouchEvent(localMotionEvent);
    if (paramMotionEvent.getPointerCount() > 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.asj()) {
        this.jdField_b_of_type_AndroidViewScaleGestureDetector.onTouchEvent(localMotionEvent);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.ask()) {
        this.jdField_a_of_type_Akph.onTouchEvent(localMotionEvent);
      }
      if ((bool) || (this.ctL) || (this.ctM)) {
        bool = true;
      }
    }
    for (;;)
    {
      dCE();
      if (this.ctN)
      {
        this.ctN = false;
        this.jdField_a_of_type_Akpn.a(this.c, this.d, this.xS, this.xT, true, true, false);
        if (!this.c.equals(this.d)) {
          dCC();
        }
      }
      if ((this.ctO) || (this.ctP))
      {
        this.ctO = false;
        this.ctP = false;
        a(this.jdField_a_of_type_Akpn.a(this.c, this.d, this.xS, this.xT, true, false, true), false);
      }
      if ((localMotionEvent.getActionMasked() == 1) || (localMotionEvent.getActionMasked() == 3))
      {
        ab(localMotionEvent);
        dCE();
      }
      if ((!this.ctJ) && (am(localMotionEvent)))
      {
        this.ctJ = true;
        paramView = paramView.getParent();
        if (paramView != null) {
          paramView.requestDisallowInterceptTouchEvent(true);
        }
      }
      localMotionEvent.recycle();
      return bool;
      bool = false;
    }
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.asn()) {}
    while ((paramMotionEvent.getActionMasked() != 1) || (this.ctL)) {
      return false;
    }
    if ((this.jdField_a_of_type_Akpe != null) && (this.jdField_a_of_type_Akpe.onDoubleTap(paramMotionEvent))) {
      return true;
    }
    a(this.jdField_a_of_type_Akpn.a(this.c, paramMotionEvent.getX(), paramMotionEvent.getY()));
    return true;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    this.ctJ = false;
    dCA();
    if (this.jdField_a_of_type_Akpe != null) {
      this.jdField_a_of_type_Akpe.onDown(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.ash()) || (!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.asi()) || (asv())) {
      return false;
    }
    if ((this.jdField_a_of_type_Akpe != null) && (this.jdField_a_of_type_Akpe.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2))) {
      return true;
    }
    dCA();
    this.jdField_a_of_type_Akpi.a(this.c).U(this.c.getX(), this.c.getY());
    this.jdField_b_of_type_AndroidWidgetOverScroller.fling(Math.round(this.c.getX()), Math.round(this.c.getY()), u(paramFloat1 * 0.9F), u(0.9F * paramFloat2), -2147483648, 2147483647, -2147483648, 2147483647);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureAnimationAnimationEngine.start(3);
    dCE();
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.isEnabled())
    {
      this.targetView.performLongClick();
      if (this.jdField_a_of_type_Akpe != null) {
        this.jdField_a_of_type_Akpe.onLongPress(paramMotionEvent);
      }
    }
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    boolean bool = true;
    if ((!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.asj()) || (asv())) {
      bool = false;
    }
    do
    {
      return bool;
      float f = paramScaleGestureDetector.getScaleFactor();
      this.xS = paramScaleGestureDetector.getFocusX();
      this.xT = paramScaleGestureDetector.getFocusY();
      this.c.k(f, this.xS, this.xT);
      this.ctN = true;
    } while (this.jdField_a_of_type_Akpe == null);
    this.jdField_a_of_type_Akpe.onScale(paramScaleGestureDetector);
    return true;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.ctL = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.asj();
    if (this.jdField_a_of_type_Akpe != null) {
      this.jdField_a_of_type_Akpe.onScaleBegin(paramScaleGestureDetector);
    }
    return this.ctL;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.ctL = false;
    this.ctO = true;
    if (this.jdField_a_of_type_Akpe != null) {
      this.jdField_a_of_type_Akpe.onScaleEnd(paramScaleGestureDetector);
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.ash()) || (asv())) {
      return false;
    }
    if (!this.ctK) {
      if ((Math.abs(paramMotionEvent2.getX() - paramMotionEvent1.getX()) <= this.touchSlop) && (Math.abs(paramMotionEvent2.getY() - paramMotionEvent1.getY()) <= this.touchSlop)) {
        break label117;
      }
    }
    label117:
    for (boolean bool = true;; bool = false)
    {
      this.ctK = bool;
      if (this.ctK) {
        break;
      }
      if (!this.ctK) {
        break label140;
      }
      if ((this.jdField_a_of_type_Akpe == null) || (!this.jdField_a_of_type_Akpe.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2))) {
        break label123;
      }
      return true;
    }
    label123:
    this.c.V(-paramFloat1, -paramFloat2);
    this.ctN = true;
    label140:
    return this.ctK;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.asn()) {
      this.targetView.performClick();
    }
    return (this.jdField_a_of_type_Akpe != null) && (this.jdField_a_of_type_Akpe.onSingleTapConfirmed(paramMotionEvent));
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.asn()) {
      this.targetView.performClick();
    }
    return (this.jdField_a_of_type_Akpe != null) && (this.jdField_a_of_type_Akpe.onSingleTapUp(paramMotionEvent));
  }
  
  protected boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.ctI) {
      n(paramView, paramMotionEvent);
    }
    this.ctI = false;
    return this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.isEnabled();
  }
  
  class LocalAnimationEngine
    extends AnimationEngine
  {
    LocalAnimationEngine(View paramView)
    {
      super();
    }
    
    public boolean Aj()
    {
      boolean bool3 = true;
      boolean bool1;
      if (GestureController.this.asw())
      {
        int i = GestureController.a(GestureController.this).getCurrX();
        int j = GestureController.a(GestureController.this).getCurrY();
        if (GestureController.a(GestureController.this).computeScrollOffset())
        {
          int k = GestureController.a(GestureController.this).getCurrX();
          int m = GestureController.a(GestureController.this).getCurrY();
          if (!GestureController.this.bb(k - i, m - j)) {
            GestureController.this.dCA();
          }
          bool1 = true;
          bool2 = bool1;
          if (!GestureController.this.asw()) {
            GestureController.this.Na(false);
          }
        }
      }
      for (boolean bool2 = bool1;; bool2 = false)
      {
        float f;
        if (GestureController.this.asv())
        {
          GestureController.a(GestureController.this).ast();
          f = GestureController.a(GestureController.this).bm();
          if ((Float.isNaN(GestureController.this.xS)) || (Float.isNaN(GestureController.this.xT)) || (Float.isNaN(GestureController.a(GestureController.this))) || (Float.isNaN(GestureController.b(GestureController.this))))
          {
            akpp.a(GestureController.this.c, GestureController.this.a, GestureController.this.b, f);
            bool1 = bool3;
            if (!GestureController.this.asv()) {
              GestureController.this.MZ(false);
            }
          }
        }
        for (bool1 = bool3;; bool1 = bool2)
        {
          if (bool1) {
            GestureController.this.dCC();
          }
          return bool1;
          akpp.a(GestureController.this.c, GestureController.this.a, GestureController.this.xS, GestureController.this.xT, GestureController.this.b, GestureController.a(GestureController.this), GestureController.b(GestureController.this), f);
          break;
        }
        bool1 = false;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.control.GestureController
 * JD-Core Version:    0.7.0.1
 */