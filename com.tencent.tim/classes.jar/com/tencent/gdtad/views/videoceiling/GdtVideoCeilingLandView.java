package com.tencent.gdtad.views.videoceiling;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasView;
import com.tencent.biz.ui.TouchWebView;
import tkw;
import tmo;

public class GdtVideoCeilingLandView
  extends RelativeLayout
{
  private AdCanvasView jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView;
  private tmo jdField_a_of_type_Tmo;
  private boolean aPG;
  private boolean aPH;
  private boolean aPI;
  private int bCk;
  private TouchWebView c;
  public boolean isAnimating;
  private boolean mIgnoreTouchEvent;
  public int mState = 0;
  private float oF;
  private float oG;
  private float oH;
  private float oI;
  
  public GdtVideoCeilingLandView(Context paramContext)
  {
    super(paramContext);
    this.bCk = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  public GdtVideoCeilingLandView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bCk = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  public GdtVideoCeilingLandView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.bCk = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  private boolean Oj()
  {
    if ((!this.aPI) && (this.c != null))
    {
      tkw.i("GdtVideoCeilingView", "noCanvasViewScrollY mWebView.getWebScrollY() -> " + this.c.getWebScrollY());
      if (Math.abs(this.c.getWebScrollY()) >= 1) {}
    }
    do
    {
      return true;
      return false;
      if ((!this.aPI) || (this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView == null)) {
        break;
      }
      tkw.i("GdtVideoCeilingView", "noCanvasViewScrollY mNativeView.getPageViewScrollY() -> " + this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView.getPageViewScrollY());
    } while (Math.abs(this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView.getPageViewScrollY()) < 1);
    return false;
    return false;
  }
  
  public static boolean e(float paramFloat)
  {
    return paramFloat < 0.0F;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView != null) {
      this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView.onActivityDestroy();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1;
    if (this.aPH) {
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
    }
    float f3;
    do
    {
      float f1;
      float f2;
      do
      {
        do
        {
          return bool1;
          if ((this.isAnimating) || (this.aPG)) {
            return true;
          }
          tkw.i("GdtVideoCeilingView", "onInterceptTouchEvent mState " + this.mState);
          switch (MotionEventCompat.getActionMasked(paramMotionEvent))
          {
          default: 
            return false;
          case 0: 
            tkw.i("GdtVideoCeilingView", "onInterceptTouchEvent ACTION_DOWN mBeingDrag " + this.aPG);
            this.oG = paramMotionEvent.getRawX();
            this.oF = paramMotionEvent.getRawY();
            return false;
          case 2: 
            tkw.i("GdtVideoCeilingView", "onInterceptTouchEvent ACTION_MOVE mBeingDrag " + this.aPG);
            f1 = paramMotionEvent.getRawX();
            f3 = paramMotionEvent.getRawY();
            f2 = this.oG;
            f3 -= this.oF;
            bool1 = bool3;
          }
        } while (Math.abs(f3) <= this.bCk);
        bool1 = bool3;
      } while (Math.abs(f3) <= Math.abs(f1 - f2));
      if (this.mState == 0)
      {
        this.aPG = true;
        tkw.i("GdtVideoCeilingView", "onInterceptTouchEvent ACTION_MOVE mState -> BOTTOM_WEBVIEW_STATE ");
        return true;
      }
      bool1 = bool3;
    } while (this.mState != 2);
    if (!this.aPG)
    {
      bool1 = bool2;
      if (Oj())
      {
        bool1 = bool2;
        if (e(f3)) {}
      }
    }
    else
    {
      this.aPG = true;
      bool1 = true;
    }
    tkw.i("GdtVideoCeilingView", "onInterceptTouchEvent ACTION_MOVE mState -> TOP_WEBVIEW_STATE, result -> " + bool1 + ", noCanvasViewScrollY -> " + Oj() + ", isScrollUp -> " + e(f3));
    return bool1;
    tkw.i("GdtVideoCeilingView", "onInterceptTouchEvent  ACTION_UP");
    this.oG = 0.0F;
    this.oF = 0.0F;
    this.aPG = false;
    return false;
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView != null) {
      this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView.onActivityPause();
    }
  }
  
  public void onResume()
  {
    if (this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView != null) {
      this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView.onActivityResume();
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.mIgnoreTouchEvent) {
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    do
    {
      float f1;
      float f2;
      float f3;
      float f4;
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this.isAnimating);
        if ((this.oI == 0.0F) || (this.oH == 0.0F))
        {
          this.oI = paramMotionEvent.getRawX();
          this.oH = paramMotionEvent.getRawY();
          if (this.jdField_a_of_type_Tmo != null) {
            this.jdField_a_of_type_Tmo.onStart(this.mState);
          }
        }
        switch (MotionEventCompat.getActionMasked(paramMotionEvent))
        {
        default: 
          return true;
        case 0: 
          tkw.w("GdtVideoCeilingView", "onTouchEvent  ACTION_DOWN");
          return true;
        case 2: 
          tkw.w("GdtVideoCeilingView", "onTouchEvent  ACTION_MOVE");
          f1 = paramMotionEvent.getRawX();
          f2 = paramMotionEvent.getRawY();
          f3 = f2 - this.oH;
          f4 = this.oI;
          bool1 = bool2;
        }
      } while (Math.abs(f3) <= Math.abs(f1 - f4));
      if (this.jdField_a_of_type_Tmo != null)
      {
        tkw.w("GdtVideoCeilingView", "onTouchEvent  onDrag");
        this.jdField_a_of_type_Tmo.zw((int)f3);
      }
      this.oI = f1;
      this.oH = f2;
      return true;
      tkw.w("GdtVideoCeilingView", "onTouchEvent  ACTION_UP");
      this.oI = 0.0F;
      this.oH = 0.0F;
      bool1 = bool2;
    } while (this.jdField_a_of_type_Tmo == null);
    this.jdField_a_of_type_Tmo.zx(this.mState);
    this.aPG = false;
    return true;
  }
  
  public void setGdtVideoCeilingListeners(tmo paramtmo, TouchWebView paramTouchWebView)
  {
    this.jdField_a_of_type_Tmo = paramtmo;
    this.c = paramTouchWebView;
    this.aPI = false;
  }
  
  public void setGdtVideoCeilingNativeListeners(tmo paramtmo, AdCanvasView paramAdCanvasView)
  {
    this.jdField_a_of_type_Tmo = paramtmo;
    this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView = paramAdCanvasView;
    this.aPI = true;
  }
  
  public void setIgnoreInterceptTouchEvent(boolean paramBoolean)
  {
    this.aPH = paramBoolean;
  }
  
  public void setIgnoreTouchEvent(boolean paramBoolean)
  {
    this.mIgnoreTouchEvent = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtVideoCeilingLandView
 * JD-Core Version:    0.7.0.1
 */