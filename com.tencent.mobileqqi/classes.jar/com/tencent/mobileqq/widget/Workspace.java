package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.Scroller;
import java.util.ArrayList;

public class Workspace
  extends FrameLayout
{
  protected static final double a;
  protected static final int a = -1;
  protected static final int f = 0;
  protected static final int g = 1;
  private static final int l = 350;
  protected float a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  protected Scroller a;
  private Workspace.OnScreenChangeListener jdField_a_of_type_ComTencentMobileqqWidgetWorkspace$OnScreenChangeListener;
  protected boolean a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  protected float b;
  protected int b;
  final Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  protected int c;
  private Rect jdField_c_of_type_AndroidGraphicsRect = new Rect();
  private boolean jdField_c_of_type_Boolean = true;
  protected int d;
  private boolean d;
  protected int e;
  private boolean e;
  protected int h = 0;
  protected int i;
  int j;
  int k;
  private int m;
  private int n;
  
  static
  {
    jdField_a_of_type_Double = Math.tan(Math.toRadians(30.0D));
  }
  
  public Workspace(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public Workspace(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_e_of_type_Int = -1;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 0;
    g();
    setDrawingCacheEnabled(true);
    setAlwaysDrawnWithCacheEnabled(true);
    setBackgroundDrawable(getResources().getDrawable(2130837729));
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext());
    this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(false);
    this.i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  private void h()
  {
    int i1 = getWidth();
    b((getScrollX() + i1 / 2) / i1);
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int a(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getParent();
      int i2 = getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        if (paramView == getChildAt(i1)) {
          return i1;
        }
        i1 += 1;
      }
    }
    return -1;
  }
  
  public Workspace.OnScreenChangeListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetWorkspace$OnScreenChangeListener;
  }
  
  void a()
  {
    setCurrentScreen(this.jdField_b_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    b();
    int i1 = Math.max(0, Math.min(paramInt1, getChildCount() - 1));
    if (i1 != this.jdField_c_of_type_Int) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (this.jdField_d_of_type_Int != i1)
      {
        this.jdField_d_of_type_Int = i1;
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetWorkspace$OnScreenChangeListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetWorkspace$OnScreenChangeListener.b(i1);
        }
      }
      this.jdField_e_of_type_Int = i1;
      View localView = getFocusedChild();
      if ((localView != null) && (paramInt1 != 0) && (localView == getChildAt(this.jdField_c_of_type_Int))) {
        localView.clearFocus();
      }
      paramInt1 = getWidth();
      int i2 = getScrollX();
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(getScrollX(), 0, paramInt1 * i1 - i2, 0, paramInt2);
      invalidate();
      return;
    }
  }
  
  void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_b_of_type_Boolean = true;
    requestLayout();
    invalidate();
  }
  
  boolean a()
  {
    return this.jdField_c_of_type_Int == this.jdField_b_of_type_Int;
  }
  
  protected boolean a(View paramView, boolean paramBoolean, MotionEvent paramMotionEvent)
  {
    int i1;
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      i1 = 0;
    }
    for (;;)
    {
      View localView;
      Workspace localWorkspace;
      if (i1 < paramView.getChildCount())
      {
        localView = paramView.getChildAt(i1);
        if (!(localView instanceof Workspace)) {
          break label130;
        }
        localWorkspace = (Workspace)localView;
        localWorkspace.getGlobalVisibleRect(this.jdField_c_of_type_AndroidGraphicsRect);
        if ((localWorkspace.isShown()) && (this.jdField_c_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))) {}
      }
      else
      {
        return false;
      }
      if (paramBoolean)
      {
        if ((localWorkspace.a() > 0) || (a() == 0)) {
          return true;
        }
        if (localWorkspace.jdField_d_of_type_Int != this.jdField_c_of_type_Int) {
          localWorkspace.setCurrentScreen(localWorkspace.jdField_d_of_type_Int);
        }
      }
      label130:
      while (((localView instanceof ViewGroup)) && (a((ViewGroup)localView, paramBoolean, paramMotionEvent)))
      {
        return true;
        if ((localWorkspace.a() < localWorkspace.getChildCount() - 1) || (a() == getChildCount() - 1)) {
          return true;
        }
        if (localWorkspace.jdField_d_of_type_Int != this.jdField_c_of_type_Int) {
          localWorkspace.setCurrentScreen(localWorkspace.jdField_d_of_type_Int);
        }
      }
      i1 += 1;
    }
  }
  
  public void addFocusables(ArrayList paramArrayList, int paramInt)
  {
    getChildAt(this.jdField_c_of_type_Int).addFocusables(paramArrayList, paramInt);
    if (paramInt == 17) {
      if (this.jdField_c_of_type_Int > 0) {
        getChildAt(this.jdField_c_of_type_Int - 1).addFocusables(paramArrayList, paramInt);
      }
    }
    while ((paramInt != 66) || (this.jdField_c_of_type_Int >= getChildCount() - 1)) {
      return;
    }
    getChildAt(this.jdField_c_of_type_Int + 1).addFocusables(paramArrayList, paramInt);
  }
  
  public int b()
  {
    return this.jdField_d_of_type_Int;
  }
  
  void b() {}
  
  public void b(int paramInt)
  {
    b();
    int i1 = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    if (i1 != this.jdField_c_of_type_Int) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (this.jdField_d_of_type_Int != i1)
      {
        this.jdField_d_of_type_Int = i1;
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetWorkspace$OnScreenChangeListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetWorkspace$OnScreenChangeListener.b(i1);
        }
      }
      this.jdField_e_of_type_Int = i1;
      View localView = getFocusedChild();
      if ((localView != null) && (paramInt != 0) && (localView == getChildAt(this.jdField_c_of_type_Int))) {
        localView.clearFocus();
      }
      paramInt = getWidth() * i1 - getScrollX();
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(getScrollX(), 0, paramInt, 0, Math.abs(paramInt));
      invalidate();
      return;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  void c() {}
  
  void c(String paramString) {}
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      postInvalidate();
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_e_of_type_Int == -1);
      int i1 = this.jdField_c_of_type_Int;
      this.jdField_c_of_type_Int = Math.max(0, Math.min(this.jdField_e_of_type_Int, getChildCount() - 1));
      this.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
      this.jdField_e_of_type_Int = -1;
      c();
    } while (this.jdField_a_of_type_ComTencentMobileqqWidgetWorkspace$OnScreenChangeListener == null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetWorkspace$OnScreenChangeListener.c(this.jdField_c_of_type_Int);
  }
  
  public void d()
  {
    if ((this.jdField_e_of_type_Int == -1) && (this.jdField_c_of_type_Int > 0) && (this.jdField_a_of_type_AndroidWidgetScroller.isFinished())) {
      b(this.jdField_c_of_type_Int - 1);
    }
  }
  
  void d(String paramString) {}
  
  public boolean dispatchUnhandledMove(View paramView, int paramInt)
  {
    if (paramInt == 17)
    {
      if (a() > 0)
      {
        b(a() - 1);
        return true;
      }
    }
    else if ((paramInt == 66) && (a() < getChildCount() - 1))
    {
      b(a() + 1);
      return true;
    }
    return super.dispatchUnhandledMove(paramView, paramInt);
  }
  
  public void e()
  {
    if ((this.jdField_e_of_type_Int == -1) && (this.jdField_c_of_type_Int < getChildCount() - 1) && (this.jdField_a_of_type_AndroidWidgetScroller.isFinished())) {
      b(this.jdField_c_of_type_Int + 1);
    }
  }
  
  void f()
  {
    b(this.jdField_b_of_type_Int);
    getChildAt(this.jdField_b_of_type_Int).requestFocus();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramMotionEvent.getAction() == 2) {
      if (paramMotionEvent.getX() - this.jdField_a_of_type_Float > 0.0F)
      {
        bool1 = true;
        if (!a(getChildAt(this.jdField_d_of_type_Int), bool1, paramMotionEvent)) {
          break label58;
        }
        bool1 = false;
      }
    }
    label58:
    int i1;
    do
    {
      return bool1;
      bool1 = false;
      break;
      i1 = paramMotionEvent.getAction();
      if (i1 != 2) {
        break label81;
      }
      bool1 = bool2;
    } while (this.h != 0);
    label81:
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i1)
    {
    }
    for (;;)
    {
      Object localObject = getChildAt(this.jdField_d_of_type_Int);
      if ((this.h != 0) && (!a((View)localObject, true, paramMotionEvent)))
      {
        bool1 = bool2;
        if (!a((View)localObject, false, paramMotionEvent)) {
          break;
        }
      }
      return false;
      int i3 = (int)Math.abs(f1 - this.jdField_a_of_type_Float);
      int i4 = (int)Math.abs(f2 - this.jdField_b_of_type_Float);
      int i2 = this.i;
      if (i3 > i2)
      {
        i1 = 1;
        label211:
        if (i4 <= i2) {
          break label318;
        }
      }
      label318:
      for (i2 = 1;; i2 = 0)
      {
        double d1 = i4 / i3;
        if (((i1 == 0) && (i2 == 0)) || (d1 >= jdField_a_of_type_Double)) {
          break;
        }
        if (i1 != 0)
        {
          localObject = getParent();
          if (localObject != null) {
            ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
          }
          this.h = 1;
          this.jdField_a_of_type_Float = f1;
          b();
        }
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_Boolean = false;
        getChildAt(this.jdField_c_of_type_Int).cancelLongPress();
        break;
        i1 = 0;
        break label211;
      }
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {}
      for (i1 = 0;; i1 = 1)
      {
        this.h = i1;
        break;
      }
      c();
      this.h = 0;
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt4 = getChildCount();
    paramInt1 = 0;
    for (paramInt2 = 0; paramInt1 < paramInt4; paramInt2 = paramInt3)
    {
      View localView = getChildAt(paramInt1);
      paramInt3 = paramInt2;
      if (localView.getVisibility() != 8)
      {
        paramInt3 = localView.getMeasuredWidth();
        if ((!this.jdField_e_of_type_Boolean) || (paramInt1 == this.jdField_c_of_type_Int)) {
          localView.layout(paramInt2, 0, paramInt2 + paramInt3, localView.getMeasuredHeight());
        }
        paramInt3 = paramInt2 + paramInt3;
      }
      paramInt1 += 1;
    }
    this.jdField_e_of_type_Boolean = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i2 = View.MeasureSpec.getSize(paramInt1);
    int i3 = getChildCount();
    int i1 = 0;
    while (i1 < i3)
    {
      getChildAt(i1).measure(paramInt1, paramInt2);
      i1 += 1;
    }
    paramInt1 = this.m;
    if (paramInt1 > i2) {}
    for (float f1 = (i3 * i2 - paramInt1) / ((i3 - 1) * i2);; f1 = 1.0F)
    {
      this.jdField_c_of_type_Float = f1;
      if (this.jdField_c_of_type_Boolean)
      {
        scrollTo(this.jdField_c_of_type_Int * i2, 0);
        this.jdField_c_of_type_Boolean = false;
      }
      return;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    if (this.jdField_e_of_type_Int != -1) {}
    for (int i1 = this.jdField_e_of_type_Int;; i1 = this.jdField_c_of_type_Int)
    {
      int i2 = i1;
      if (i1 >= getChildCount()) {
        i2 = getChildCount() - 1;
      }
      if (getChildAt(i2) != null) {
        getChildAt(i2).requestFocus(paramInt, paramRect);
      }
      return false;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (Workspace.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable.currentScreen != -1) {
      this.jdField_c_of_type_Int = paramParcelable.currentScreen;
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Workspace.SavedState localSavedState = new Workspace.SavedState(super.onSaveInstanceState());
    localSavedState.currentScreen = this.jdField_c_of_type_Int;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 < paramInt4) && (paramInt1 == paramInt3)) {}
    for (this.jdField_e_of_type_Boolean = true;; this.jdField_e_of_type_Boolean = false)
    {
      if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
        this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
      }
      scrollTo(this.jdField_d_of_type_Int * paramInt1, 0);
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (getChildCount() < 0) {}
    int i1;
    do
    {
      do
      {
        do
        {
          float f1;
          do
          {
            return true;
            if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
              this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
            }
            this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
            i1 = paramMotionEvent.getAction();
            f1 = paramMotionEvent.getX();
            switch (i1)
            {
            default: 
              return true;
            case 0: 
              if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
                this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
              }
              paramMotionEvent = getParent();
              if (paramMotionEvent != null) {
                paramMotionEvent.requestDisallowInterceptTouchEvent(true);
              }
              this.jdField_a_of_type_Float = f1;
              return true;
            }
          } while (this.h != 1);
          i1 = (int)(this.jdField_a_of_type_Float - f1);
          if ((i1 > 0) && (!this.jdField_d_of_type_Boolean) && (this.jdField_c_of_type_Int == getChildCount() - 1))
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetWorkspace$OnScreenChangeListener.c(getChildCount());
            return true;
          }
          this.jdField_a_of_type_Float = f1;
          paramMotionEvent = getParent();
          if (paramMotionEvent != null) {
            paramMotionEvent.requestDisallowInterceptTouchEvent(true);
          }
          if (i1 >= 0) {
            break;
          }
          if (getScrollX() > 0)
          {
            scrollBy(Math.max(-getScrollX(), i1), 0);
            return true;
          }
        } while (!this.jdField_d_of_type_Boolean);
        scrollBy(i1 / 3, 0);
        return true;
      } while (i1 <= 0);
      int i2 = getChildAt(getChildCount() - 1).getRight() - getScrollX() - getWidth();
      if (i2 > 0)
      {
        scrollBy(Math.min(i2, i1), 0);
        return true;
      }
    } while (!this.jdField_d_of_type_Boolean);
    scrollBy(i1 / 3, 0);
    return true;
    if (this.h == 1)
    {
      paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
      paramMotionEvent.computeCurrentVelocity(1000);
      i1 = (int)paramMotionEvent.getXVelocity();
      if ((i1 <= 350) || (this.jdField_c_of_type_Int <= 0)) {
        break label374;
      }
      b(this.jdField_c_of_type_Int - 1);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
      {
        this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
        this.jdField_a_of_type_AndroidViewVelocityTracker = null;
      }
      this.h = 0;
      return true;
      label374:
      if ((i1 < -350) && (this.jdField_c_of_type_Int < getChildCount() - 1)) {
        b(this.jdField_c_of_type_Int + 1);
      } else {
        h();
      }
    }
    this.h = 0;
    return true;
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    paramView1 = new Rect();
    paramView2.getDrawingRect(paramView1);
    paramView2.requestRectangleOnScreen(paramView1);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    int i1 = indexOfChild(paramView);
    if ((i1 != this.jdField_c_of_type_Int) || (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()))
    {
      b(i1);
      return true;
    }
    return false;
  }
  
  public void setAllowLongPress(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setAlloweffect(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setCurrentScreen(int paramInt)
  {
    this.jdField_c_of_type_Int = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    this.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
    scrollTo(this.jdField_c_of_type_Int * getWidth(), 0);
  }
  
  public void setDefaultScreen(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      getChildAt(i1).setOnLongClickListener(paramOnLongClickListener);
      i1 += 1;
    }
  }
  
  public void setOnScreenChangeListener(Workspace.OnScreenChangeListener paramOnScreenChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetWorkspace$OnScreenChangeListener = paramOnScreenChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.Workspace
 * JD-Core Version:    0.7.0.1
 */