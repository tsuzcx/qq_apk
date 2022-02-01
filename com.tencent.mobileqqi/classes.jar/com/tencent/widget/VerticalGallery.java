package com.tencent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Transformation;
import android.widget.Scroller;
import android.widget.SpinnerAdapter;
import com.tencent.mobileqqi.R.styleable;
import hvi;
import hwy;
import hwz;
import hxa;

public class VerticalGallery
  extends VerticalAbsSpinner
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener
{
  private static final String jdField_a_of_type_JavaLangString = "Gallery";
  public static final int g = 1;
  public static final int h = 2;
  private static final int jdField_i_of_type_Int = 250;
  private float jdField_a_of_type_Float;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, this);
  private AdapterView.AdapterContextMenuInfo jdField_a_of_type_ComTencentWidgetAdapterView$AdapterContextMenuInfo;
  private VerticalGallery.OnEndFlingListener jdField_a_of_type_ComTencentWidgetVerticalGallery$OnEndFlingListener = null;
  private VerticalGallery.OnEndMovementListener jdField_a_of_type_ComTencentWidgetVerticalGallery$OnEndMovementListener = null;
  private VerticalGallery.OnSelectViewDataUpdateListener jdField_a_of_type_ComTencentWidgetVerticalGallery$OnSelectViewDataUpdateListener = null;
  private hxa jdField_a_of_type_Hxa = new hxa(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new hwy(this);
  private float jdField_b_of_type_Float = 1.0F;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean = true;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h = false;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int = 0;
  private boolean jdField_j_of_type_Boolean = false;
  private int jdField_k_of_type_Int = 400;
  private boolean jdField_k_of_type_Boolean = true;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean = false;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q = 0;
  private int r = 5;
  private int s = 1;
  
  public VerticalGallery(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VerticalGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130772396);
  }
  
  public VerticalGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_d_of_type_Boolean = true;
    this.i = false;
    this.jdField_p_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewGestureDetector.setIsLongpressEnabled(true);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ag, paramInt, 0);
    paramInt = paramAttributeSet.getInt(0, -1);
    if (paramInt >= 0) {
      setGravity(paramInt);
    }
    paramInt = paramAttributeSet.getInt(1, -1);
    if (paramInt > 0) {
      setAnimationDuration(paramInt);
    }
    setSpacing(paramAttributeSet.getDimensionPixelOffset(2, 0));
    setUnselectedAlpha(paramAttributeSet.getFloat(3, 0.5F));
    paramAttributeSet.recycle();
    setChildrenDrawingOrderEnabled(true);
    setStaticTransformationsEnabled(true);
    this.r = ViewConfiguration.get(paramContext).getScaledScrollBarSize();
    if (h())
    {
      this.jdField_n_of_type_Int = 1;
      return;
    }
    this.jdField_n_of_type_Int = 16;
  }
  
  private void B()
  {
    int i3 = this.jdField_j_of_type_Int;
    int i4 = getBottom() - getTop() - getPaddingBottom();
    int i1 = getChildCount();
    int i5 = this.aB;
    View localView = getChildAt(i1 - 1);
    int i2;
    if (localView != null)
    {
      i2 = this.ap + i1;
      i1 = localView.getBottom() + i3;
    }
    while ((i1 < i4) && (i2 < i5))
    {
      i1 = b(i2, i2 - this.aA, i1, true).getBottom() + i3;
      i2 += 1;
      continue;
      i2 = this.aB - 1;
      this.ap = i2;
      i1 = getPaddingTop();
      this.jdField_b_of_type_Boolean = true;
    }
    i2 %= i5;
    while ((i1 <= i4) && (getChildCount() < this.aB))
    {
      i1 = b(i2, i2 - this.aA, i1, true).getBottom() + i3;
      i2 += 1;
    }
  }
  
  private int a(View paramView, boolean paramBoolean)
  {
    int i1;
    if (paramBoolean)
    {
      i1 = getMeasuredHeight();
      label9:
      if (!paramBoolean) {
        break label66;
      }
    }
    label66:
    for (int i2 = paramView.getMeasuredHeight();; i2 = paramView.getHeight()) {
      switch (this.jdField_n_of_type_Int)
      {
      default: 
        return 0;
        i1 = getHeight();
        break label9;
      }
    }
    return this.jdField_a_of_type_AndroidGraphicsRect.top;
    int i3 = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
    int i4 = this.jdField_a_of_type_AndroidGraphicsRect.top;
    int i5 = this.jdField_a_of_type_AndroidGraphicsRect.top;
    return (i1 - i3 - i4 - i2) / 2 + i5;
    return i1 - this.jdField_a_of_type_AndroidGraphicsRect.bottom - i2;
  }
  
  private View a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (!this.jdField_p_of_type_Boolean)
    {
      localView = this.jdField_a_of_type_Hvi.a(paramInt1);
      if (localView != null)
      {
        paramInt1 = localView.getLeft();
        this.m = Math.max(this.m, localView.getMeasuredWidth() + paramInt1);
        this.jdField_l_of_type_Int = Math.min(this.jdField_l_of_type_Int, paramInt1);
        a(localView, paramInt2, paramInt3, paramBoolean);
        return localView;
      }
    }
    View localView = this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getView(paramInt1, null, this);
    a(localView, paramInt2, paramInt3, paramBoolean);
    return localView;
  }
  
  private void a(View paramView)
  {
    if (paramView != null) {
      paramView.setPressed(true);
    }
    setPressed(true);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = false;
    VerticalGallery.LayoutParams localLayoutParams = (VerticalGallery.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null) {
      localLayoutParams = (VerticalGallery.LayoutParams)generateDefaultLayoutParams();
    }
    for (;;)
    {
      int i1;
      int i2;
      int i3;
      if (paramBoolean)
      {
        i1 = -1;
        addViewInLayout(paramView, i1, localLayoutParams);
        if (paramInt1 == 0) {
          bool = true;
        }
        paramView.setSelected(bool);
        paramInt1 = ViewGroup.getChildMeasureSpec(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect.top + this.jdField_a_of_type_AndroidGraphicsRect.bottom, localLayoutParams.height);
        paramView.measure(ViewGroup.getChildMeasureSpec(this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.right, localLayoutParams.width), paramInt1);
        i1 = a(paramView, true);
        i2 = paramView.getMeasuredHeight();
        i3 = paramView.getMeasuredWidth();
        if (!paramBoolean) {
          break label169;
        }
        paramInt1 = paramInt2;
        paramInt2 = i3 + paramInt2;
      }
      for (;;)
      {
        paramView.layout(paramInt1, i1, paramInt2, i1 + i2);
        return;
        i1 = 0;
        break;
        label169:
        paramInt1 = paramInt2 - i3;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int i2 = 0;
    int i5 = 0;
    int i6 = getChildCount();
    int i4 = this.ap;
    View localView;
    if (paramBoolean)
    {
      i3 = getPaddingLeft();
      i2 = 0;
      i1 = 0;
      for (;;)
      {
        if (i2 < i6)
        {
          localView = getChildAt(i2);
          if (localView.getRight() < i3) {}
        }
        else
        {
          i3 = i1;
          i4 = i5;
          if (i1 == i6)
          {
            i3 = i1 - 1;
            i4 = i5;
          }
          detachViewsFromParent(i4, i3);
          if (paramBoolean)
          {
            this.ap = (i3 + this.ap);
            if (g()) {
              this.ap %= this.aB;
            }
          }
          return;
        }
        this.jdField_a_of_type_Hvi.a(i4 + i2, localView);
        i2 += 1;
        i1 += 1;
      }
    }
    i5 = getWidth();
    int i7 = getPaddingRight();
    int i3 = i6 - 1;
    int i1 = 0;
    for (;;)
    {
      if (i3 >= 0)
      {
        localView = getChildAt(i3);
        if (localView.getLeft() > i5 - i7) {}
      }
      else
      {
        i3 = i1;
        i4 = i2;
        if (i2 != 0) {
          break;
        }
        i4 = i2 + 1;
        i3 = i1;
        break;
      }
      this.jdField_a_of_type_Hvi.a(i4 + i3, localView);
      i1 += 1;
      i2 = i3;
      i3 -= 1;
    }
  }
  
  private boolean a(int paramInt)
  {
    View localView = getChildAt(paramInt);
    if (localView != null)
    {
      paramInt = b();
      int i1 = d(localView);
      this.jdField_a_of_type_Hxa.b(paramInt - i1);
      return true;
    }
    return false;
  }
  
  private int b(View paramView, boolean paramBoolean)
  {
    int i1;
    if (paramBoolean)
    {
      i1 = getMeasuredWidth();
      label9:
      if (!paramBoolean) {
        break label66;
      }
    }
    label66:
    for (int i2 = paramView.getMeasuredWidth();; i2 = paramView.getWidth()) {
      switch (this.jdField_n_of_type_Int)
      {
      case 2: 
      case 4: 
      default: 
        return 0;
        i1 = getWidth();
        break label9;
      }
    }
    return this.jdField_a_of_type_AndroidGraphicsRect.left;
    int i3 = this.jdField_a_of_type_AndroidGraphicsRect.right;
    int i4 = this.jdField_a_of_type_AndroidGraphicsRect.left;
    int i5 = this.jdField_a_of_type_AndroidGraphicsRect.left;
    return (i1 - i3 - i4 - i2) / 2 + i5;
    return i1 - this.jdField_a_of_type_AndroidGraphicsRect.right - i2;
  }
  
  private View b(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (!this.jdField_p_of_type_Boolean)
    {
      localView = this.jdField_a_of_type_Hvi.a(paramInt1);
      if (localView != null)
      {
        paramInt1 = localView.getTop();
        this.m = Math.max(this.m, localView.getMeasuredHeight() + paramInt1);
        this.jdField_l_of_type_Int = Math.min(this.jdField_l_of_type_Int, paramInt1);
        b(localView, paramInt2, paramInt3, paramBoolean);
        return localView;
      }
    }
    View localView = this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getView(paramInt1, null, this);
    b(localView, paramInt2, paramInt3, paramBoolean);
    return localView;
  }
  
  private void b(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = false;
    VerticalGallery.LayoutParams localLayoutParams = (VerticalGallery.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null) {
      localLayoutParams = (VerticalGallery.LayoutParams)generateDefaultLayoutParams();
    }
    for (;;)
    {
      int i1;
      int i2;
      int i3;
      if (paramBoolean)
      {
        i1 = -1;
        addViewInLayout(paramView, i1, localLayoutParams);
        if (paramInt1 == 0) {
          bool = true;
        }
        paramView.setSelected(bool);
        paramInt1 = ViewGroup.getChildMeasureSpec(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect.top + this.jdField_a_of_type_AndroidGraphicsRect.bottom, localLayoutParams.height);
        paramView.measure(ViewGroup.getChildMeasureSpec(this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.right, localLayoutParams.width), paramInt1);
        i1 = b(paramView, true);
        i2 = paramView.getMeasuredWidth();
        i3 = paramView.getMeasuredHeight();
        if (!paramBoolean) {
          break label169;
        }
        paramInt1 = paramInt2;
        paramInt2 = i3 + paramInt2;
      }
      for (;;)
      {
        paramView.layout(i1, paramInt1, i1 + i2, paramInt2);
        return;
        i1 = 0;
        break;
        label169:
        paramInt1 = paramInt2 - i3;
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    int i2 = 0;
    int i5 = 0;
    int i6 = getChildCount();
    int i4 = this.ap;
    View localView;
    if (paramBoolean)
    {
      i3 = getPaddingTop();
      i2 = 0;
      i1 = 0;
      for (;;)
      {
        if (i2 < i6)
        {
          localView = getChildAt(i2);
          if (localView.getBottom() < i3) {}
        }
        else
        {
          i3 = i1;
          i4 = i5;
          if (i1 == i6)
          {
            i3 = i1 - 1;
            i4 = i5;
          }
          detachViewsFromParent(i4, i3);
          if (paramBoolean)
          {
            this.ap = (i3 + this.ap);
            if (g()) {
              this.ap %= this.aB;
            }
          }
          return;
        }
        this.jdField_a_of_type_Hvi.a(i4 + i2, localView);
        i2 += 1;
        i1 += 1;
      }
    }
    i5 = getHeight();
    int i7 = getPaddingBottom();
    int i3 = i6 - 1;
    int i1 = 0;
    for (;;)
    {
      if (i3 >= 0)
      {
        localView = getChildAt(i3);
        if (localView.getTop() > i5 - i7) {}
      }
      else
      {
        i3 = i1;
        i4 = i2;
        if (i2 != 0) {
          break;
        }
        i4 = i2 + 1;
        i3 = i1;
        break;
      }
      this.jdField_a_of_type_Hvi.a(i4 + i3, localView);
      i1 += 1;
      i2 = i3;
      i3 -= 1;
    }
  }
  
  private boolean b(int paramInt)
  {
    if (paramInt != this.aA)
    {
      e(paramInt);
      f(paramInt);
      x();
      return true;
    }
    return false;
  }
  
  private boolean b(View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemLongClickListener != null) {}
    for (boolean bool1 = this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemLongClickListener.a(this, this.jdField_b_of_type_AndroidViewView, this.jdField_o_of_type_Int, paramLong);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        this.jdField_a_of_type_ComTencentWidgetAdapterView$AdapterContextMenuInfo = new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
        bool2 = super.showContextMenuForChild(this);
      }
      if (bool2) {
        performHapticFeedback(0);
      }
      return bool2;
    }
  }
  
  private float d()
  {
    if (h()) {
      return (getHeight() - getPaddingTop() - getPaddingBottom()) * b() + getPaddingTop();
    }
    return (getWidth() - getPaddingLeft() - getPaddingRight()) * b() + getPaddingLeft();
  }
  
  private int d(View paramView)
  {
    if (h()) {
      return paramView.getTop() + paramView.getHeight() / 2;
    }
    return paramView.getLeft() + paramView.getWidth() / 2;
  }
  
  private boolean h()
  {
    return this.s == 2;
  }
  
  private void i()
  {
    int i2 = 0;
    if (d()) {
      if ((getChildCount() != 0) && (this.jdField_c_of_type_AndroidViewView != null)) {}
    }
    int i1;
    while (getChildCount() == 0)
    {
      return;
      i1 = d(this.jdField_c_of_type_AndroidViewView);
      i1 = b() - i1;
      if (i1 != 0)
      {
        this.jdField_a_of_type_Hxa.b(i1);
        return;
      }
      j();
      return;
    }
    View localView1;
    if (this.ap == 0)
    {
      localView1 = getChildAt(0);
      if (localView1.getTop() >= 0) {
        i1 = getPaddingTop() - localView1.getTop();
      }
    }
    while (i1 != 0)
    {
      this.jdField_a_of_type_Hxa.b(i1);
      return;
      View localView2 = getChildAt(getChildCount() - 1);
      if (localView2.getBottom() - localView1.getTop() < getBottom() - getPaddingBottom())
      {
        i1 = getPaddingLeft() - this.jdField_p_of_type_Int;
      }
      else
      {
        i1 = i2;
        if (localView2.getBottom() < getBottom() - getPaddingBottom())
        {
          i1 = getHeight() - getPaddingBottom() - localView2.getBottom();
          continue;
          i1 = i2;
          if (this.ap + getChildCount() == this.aB)
          {
            localView1 = getChildAt(getChildCount() - 1);
            i1 = i2;
            if (localView1.getBottom() < getBottom() - getPaddingBottom()) {
              i1 = getHeight() - getPaddingBottom() - localView1.getBottom();
            }
          }
        }
      }
    }
    j();
  }
  
  private void j()
  {
    if (this.e)
    {
      this.e = false;
      super.B_();
    }
    invalidate();
    if (this.jdField_a_of_type_ComTencentWidgetVerticalGallery$OnEndMovementListener != null) {
      this.jdField_a_of_type_ComTencentWidgetVerticalGallery$OnEndMovementListener.a(this);
    }
  }
  
  private void k()
  {
    View localView = this.jdField_c_of_type_AndroidViewView;
    if (this.jdField_c_of_type_AndroidViewView == null) {}
    int i5;
    do
    {
      return;
      i5 = b();
    } while ((localView.getLeft() <= i5) && (localView.getRight() >= i5));
    int i3 = 2147483647;
    int i2 = 0;
    int i1 = getChildCount() - 1;
    if (i1 >= 0)
    {
      localView = getChildAt(i1);
      if ((localView.getLeft() > i5) || (localView.getRight() < i5)) {}
    }
    for (;;)
    {
      i2 = this.ap + i1;
      i1 = i2;
      if (g()) {
        i1 = i2 % this.aB;
      }
      if (i1 == this.aA) {
        break;
      }
      e(i1);
      f(i1);
      x();
      return;
      int i4 = Math.min(Math.abs(localView.getLeft() - i5), Math.abs(localView.getRight() - i5));
      if (i4 < i3) {
        i3 = i1;
      }
      for (i2 = i4;; i2 = i4)
      {
        i1 -= 1;
        i4 = i2;
        i2 = i3;
        i3 = i4;
        break;
        i4 = i3;
        i3 = i2;
      }
      i1 = i2;
    }
  }
  
  private void l()
  {
    View localView = this.jdField_c_of_type_AndroidViewView;
    if (this.jdField_c_of_type_AndroidViewView == null) {}
    int i5;
    do
    {
      return;
      i5 = b();
    } while ((localView != null) && (localView.getTop() <= i5) && (localView.getBottom() >= i5));
    int i3 = 2147483647;
    int i2 = 0;
    int i1 = getChildCount() - 1;
    if (i1 >= 0)
    {
      localView = getChildAt(i1);
      if ((localView.getTop() > i5) || (localView.getBottom() < i5)) {}
    }
    for (;;)
    {
      i2 = this.ap + i1;
      i1 = i2;
      if (g()) {
        i1 = i2 % this.aB;
      }
      if (i1 == this.aA) {
        break;
      }
      e(i1);
      f(i1);
      x();
      return;
      int i4 = Math.min(Math.abs(localView.getTop() - i5), Math.abs(localView.getBottom() - i5));
      if (i4 < i3) {
        i3 = i1;
      }
      for (i2 = i4;; i2 = i4)
      {
        i1 -= 1;
        i4 = i2;
        i2 = i3;
        i3 = i4;
        break;
        i4 = i3;
        i3 = i2;
      }
      i1 = i2;
    }
  }
  
  private void m()
  {
    if (g()) {
      t();
    }
    for (;;)
    {
      return;
      int i3 = this.jdField_j_of_type_Int;
      int i4 = getPaddingLeft();
      View localView = getChildAt(0);
      int i2;
      int i1;
      if (localView != null)
      {
        i2 = this.ap - 1;
        i1 = localView.getLeft() - i3;
      }
      while ((i1 > i4) && (i2 >= 0))
      {
        localView = a(i2, i2 - this.aA, i1, false);
        this.ap = i2;
        i1 = localView.getLeft() - i3;
        i2 -= 1;
        continue;
        i1 = getRight() - getLeft() - getPaddingRight();
        this.jdField_b_of_type_Boolean = true;
        i2 = 0;
      }
    }
  }
  
  private void n()
  {
    if (g()) {
      u();
    }
    for (;;)
    {
      return;
      int i3 = this.jdField_j_of_type_Int;
      int i4 = getPaddingTop();
      View localView = getChildAt(0);
      int i2;
      int i1;
      if (localView != null)
      {
        i2 = this.ap - 1;
        i1 = localView.getTop() - i3;
      }
      while ((i1 > i4) && (i2 >= 0))
      {
        localView = b(i2, i2 - this.aA, i1, false);
        this.ap = i2;
        i1 = localView.getTop() - i3;
        i2 -= 1;
        continue;
        i1 = getBottom() - getTop() - getPaddingBottom();
        this.jdField_b_of_type_Boolean = true;
        i2 = 0;
      }
    }
  }
  
  private void o()
  {
    if (g()) {
      v();
    }
    for (;;)
    {
      return;
      int i3 = this.jdField_j_of_type_Int;
      int i4 = getRight();
      int i5 = getLeft();
      int i6 = getPaddingRight();
      int i1 = getChildCount();
      int i7 = this.aB;
      View localView = getChildAt(i1 - 1);
      int i2;
      if (localView != null)
      {
        i2 = this.ap + i1;
        i1 = localView.getRight() + i3;
      }
      while ((i1 < i4 - i5 - i6) && (i2 < i7))
      {
        i1 = a(i2, i2 - this.aA, i1, true).getRight() + i3;
        i2 += 1;
        continue;
        i2 = this.aB - 1;
        this.ap = i2;
        i1 = getPaddingLeft();
        this.jdField_b_of_type_Boolean = true;
      }
    }
  }
  
  private void r()
  {
    if (g()) {
      B();
    }
    for (;;)
    {
      return;
      int i3 = this.jdField_j_of_type_Int;
      int i4 = getBottom();
      int i5 = getTop();
      int i6 = getPaddingRight();
      int i1 = getChildCount();
      int i7 = this.aB;
      View localView = getChildAt(i1 - 1);
      int i2;
      if (localView != null)
      {
        i2 = this.ap + i1;
        i1 = localView.getBottom() + i3;
      }
      while ((i1 < i4 - i5 - i6) && (i2 < i7))
      {
        i1 = b(i2, i2 - this.aA, i1, true).getBottom() + i3;
        i2 += 1;
        continue;
        i2 = this.aB - 1;
        this.ap = i2;
        i1 = getPaddingTop();
        this.jdField_b_of_type_Boolean = true;
      }
    }
  }
  
  private void s()
  {
    View localView1 = this.jdField_c_of_type_AndroidViewView;
    int i2 = this.aA - this.ap;
    int i1 = i2;
    if (g())
    {
      i1 = i2;
      if (this.ap > this.aA) {
        i1 = this.aB - this.ap + this.aA;
      }
    }
    View localView2 = getChildAt(i1);
    this.jdField_c_of_type_AndroidViewView = localView2;
    if (localView2 == null) {}
    do
    {
      return;
      localView2.setSelected(true);
      localView2.setFocusable(true);
      if (hasFocus()) {
        localView2.requestFocus();
      }
      if (this.jdField_a_of_type_ComTencentWidgetVerticalGallery$OnSelectViewDataUpdateListener != null) {
        this.jdField_a_of_type_ComTencentWidgetVerticalGallery$OnSelectViewDataUpdateListener.a(localView2, i1);
      }
    } while (localView1 == null);
    localView1.setSelected(false);
    localView1.setFocusable(false);
  }
  
  private void t()
  {
    int i3 = this.jdField_j_of_type_Int;
    int i4 = getPaddingLeft();
    View localView = getChildAt(0);
    int i1;
    if (localView != null)
    {
      i2 = this.ap - 1;
      i1 = localView.getLeft() - i3;
    }
    while ((i1 > i4) && (i2 >= 0))
    {
      localView = a(i2, i2 - this.aA, i1, false);
      this.ap = i2;
      i1 = localView.getLeft() - i3;
      i2 -= 1;
      continue;
      i1 = getRight() - getLeft() - getPaddingRight();
      this.jdField_b_of_type_Boolean = true;
      i2 = 0;
    }
    int i2 = this.aB - 1;
    while ((i1 > i4) && (getChildCount() < this.aB))
    {
      localView = a(i2, i2 - this.aA, i1, false);
      this.ap = i2;
      i1 = localView.getLeft() - i3;
      i2 -= 1;
    }
  }
  
  private void u()
  {
    int i3 = this.jdField_j_of_type_Int;
    int i4 = getPaddingTop();
    View localView = getChildAt(0);
    int i1;
    if (localView != null)
    {
      i2 = this.ap - 1;
      i1 = localView.getTop() - i3;
    }
    while ((i1 > i4) && (i2 >= 0))
    {
      localView = b(i2, i2 - this.aA, i1, false);
      this.ap = i2;
      i1 = localView.getTop() - i3;
      i2 -= 1;
      continue;
      i1 = getBottom() - getTop() - getPaddingBottom();
      this.jdField_b_of_type_Boolean = true;
      i2 = 0;
    }
    int i2 = this.aB - 1;
    while ((i1 > i4) && (getChildCount() < this.aB))
    {
      localView = b(i2, i2 - this.aA, i1, false);
      this.ap = i2;
      i1 = localView.getTop() - i3;
      i2 -= 1;
    }
  }
  
  private void v()
  {
    int i3 = this.jdField_j_of_type_Int;
    int i4 = getRight() - getLeft() - getPaddingRight();
    int i1 = getChildCount();
    int i5 = this.aB;
    View localView = getChildAt(i1 - 1);
    int i2;
    if (localView != null)
    {
      i2 = this.ap + i1;
      i1 = localView.getRight() + i3;
    }
    while ((i1 < i4) && (i2 < i5))
    {
      i1 = a(i2, i2 - this.aA, i1, true).getRight() + i3;
      i2 += 1;
      continue;
      i2 = this.aB - 1;
      this.ap = i2;
      i1 = getPaddingLeft();
      this.jdField_b_of_type_Boolean = true;
    }
    i2 %= i5;
    while ((i1 <= i4) && (getChildCount() < this.aB))
    {
      i1 = a(i2, i2 - this.aA, i1, true).getRight() + i3;
      i2 += 1;
    }
  }
  
  public void B_()
  {
    if (!this.e) {
      super.B_();
    }
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_Hxa != null) {
      this.jdField_a_of_type_Hxa.b(paramInt * -1);
    }
    return paramInt * -1;
  }
  
  public int a(Point paramPoint)
  {
    int i2 = -1;
    int i3 = getChildCount();
    Rect localRect = new Rect();
    getDrawingRect(localRect);
    int i1;
    if (localRect.contains(paramPoint.x, paramPoint.y))
    {
      i1 = 0;
      if (i1 < i3)
      {
        getChildAt(i1).getHitRect(localRect);
        if (!localRect.contains(paramPoint.x, paramPoint.y)) {}
      }
    }
    for (;;)
    {
      if (i1 >= 0) {
        i2 = this.ap + i1;
      }
      return i2;
      i1 += 1;
      break;
      i1 = -1;
    }
  }
  
  int a(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  public int a(boolean paramBoolean)
  {
    int i4 = 0;
    int i3 = 0;
    if (getChildCount() == 0) {
      return 0;
    }
    View localView;
    int i2;
    int i1;
    if (paramBoolean)
    {
      localView = getChildAt(getChildCount() - 1);
      i2 = Math.max(localView.getRight() - getRight() + getPaddingRight(), 0);
      i1 = i2;
      if (i2 != 0) {
        break label176;
      }
      i1 = i2;
      if (this.ap + getChildCount() == this.aB) {
        break label176;
      }
      i1 = i3;
      if (localView != null) {
        i1 = localView.getWidth();
      }
      i1 += i2;
    }
    label176:
    for (;;)
    {
      if ((i1 != 0) && (this.jdField_a_of_type_Hxa != null)) {
        this.jdField_a_of_type_Hxa.b(i1 * -1);
      }
      return i1 * -1;
      localView = getChildAt(0);
      i2 = Math.min(localView.getLeft() - getPaddingLeft(), 0);
      i1 = i2;
      if (i2 == 0)
      {
        i1 = i2;
        if (this.ap != 0)
        {
          i1 = i4;
          if (localView != null) {
            i1 = localView.getWidth();
          }
          i1 = i2 - i1;
        }
      }
    }
  }
  
  int a(boolean paramBoolean, int paramInt)
  {
    int i2 = 0;
    View localView;
    if (paramBoolean)
    {
      i1 = this.aB - 1;
      localView = getChildAt(i1 - this.ap);
      if (localView != null) {
        break label40;
      }
      i1 = paramInt;
    }
    label40:
    int i3;
    int i4;
    do
    {
      return i1;
      i1 = 0;
      break;
      i3 = d(localView);
      i4 = b();
      if (!paramBoolean) {
        break label86;
      }
      i1 = i2;
    } while (i3 <= i4);
    int i1 = i4 - i3;
    if (paramBoolean) {}
    for (paramInt = Math.max(i1, paramInt);; paramInt = Math.min(i1, paramInt))
    {
      return paramInt;
      label86:
      if (i3 < i4) {
        break;
      }
      return 0;
    }
  }
  
  public void a(int paramInt)
  {
    int i1 = 0;
    if (getChildCount() == 0) {
      return;
    }
    boolean bool;
    if (paramInt < 0)
    {
      bool = true;
      if (!d()) {
        break label109;
      }
      if (((!g()) || (getChildCount() >= this.aB)) && (a(bool, paramInt) != paramInt))
      {
        hxa.a(this.jdField_a_of_type_Hxa, false);
        j();
      }
      c(paramInt);
      a(bool);
      if (!bool) {
        break label102;
      }
      o();
    }
    for (;;)
    {
      this.jdField_a_of_type_Hvi.a();
      k();
      invalidate();
      return;
      bool = false;
      break;
      label102:
      m();
    }
    label109:
    View localView;
    if (bool)
    {
      localView = getChildAt(getChildCount() - 1);
      if ((localView == null) || (localView.getRight() >= d())) {
        break label263;
      }
      paramInt = i1;
      if (this.jdField_a_of_type_Hxa != null)
      {
        this.jdField_a_of_type_Hxa.a(false);
        paramInt = i1;
      }
    }
    label263:
    for (;;)
    {
      c(paramInt);
      a(bool);
      if (bool) {
        o();
      }
      for (;;)
      {
        this.jdField_a_of_type_Hvi.a();
        k();
        awakenScrollBars();
        invalidate();
        return;
        localView = getChildAt(0);
        if ((localView == null) || (localView.getLeft() <= getWidth() - d())) {
          break label263;
        }
        paramInt = i1;
        if (this.jdField_a_of_type_Hxa == null) {
          break;
        }
        this.jdField_a_of_type_Hxa.a(false);
        paramInt = i1;
        break;
        m();
      }
    }
  }
  
  protected void a(Canvas paramCanvas, Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = this.q;
    paramInt2 = paramInt4 - this.q;
    paramDrawable.setBounds(paramInt1, paramInt2 - this.r, paramInt3, paramInt2);
    paramDrawable.draw(paramCanvas);
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    boolean bool2 = false;
    int i2 = getChildCount();
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < i2)
      {
        View localView = getChildAt(i1);
        if ((paramFloat1 >= localView.getLeft()) && (paramFloat1 <= localView.getRight()) && (paramFloat2 >= localView.getTop()) && (paramFloat2 <= localView.getBottom())) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  protected float b()
  {
    return 0.0F;
  }
  
  public int b()
  {
    if (h()) {
      return (getHeight() - getPaddingTop() - getPaddingBottom()) / 2 + getPaddingTop();
    }
    return (getWidth() - getPaddingLeft() - getPaddingRight()) / 2 + getPaddingLeft();
  }
  
  public void b(int paramInt)
  {
    int i1 = 0;
    if (getChildCount() == 0) {
      return;
    }
    boolean bool;
    if (paramInt < 0)
    {
      bool = true;
      if (!d()) {
        break label109;
      }
      if (((!g()) || (getChildCount() >= this.aB)) && (a(bool, paramInt) != paramInt))
      {
        hxa.a(this.jdField_a_of_type_Hxa, false);
        j();
      }
      d(paramInt);
      b(bool);
      if (!bool) {
        break label102;
      }
      r();
    }
    for (;;)
    {
      this.jdField_a_of_type_Hvi.a();
      l();
      invalidate();
      return;
      bool = false;
      break;
      label102:
      n();
    }
    label109:
    View localView;
    if (bool)
    {
      localView = getChildAt(getChildCount() - 1);
      if ((localView == null) || (localView.getRight() >= d())) {
        break label263;
      }
      paramInt = i1;
      if (this.jdField_a_of_type_Hxa != null)
      {
        this.jdField_a_of_type_Hxa.a(false);
        paramInt = i1;
      }
    }
    label263:
    for (;;)
    {
      d(paramInt);
      b(bool);
      if (bool) {
        r();
      }
      for (;;)
      {
        this.jdField_a_of_type_Hvi.a();
        k();
        awakenScrollBars();
        invalidate();
        return;
        localView = getChildAt(0);
        if ((localView == null) || (localView.getLeft() <= getWidth() - d())) {
          break label263;
        }
        paramInt = i1;
        if (this.jdField_a_of_type_Hxa == null) {
          break;
        }
        this.jdField_a_of_type_Hxa.a(false);
        paramInt = i1;
        break;
        n();
      }
    }
  }
  
  void b(int paramInt, boolean paramBoolean)
  {
    if (h())
    {
      c(paramInt, paramBoolean);
      return;
    }
    paramInt = this.jdField_a_of_type_AndroidGraphicsRect.left;
    int i1 = this.jdField_p_of_type_Int + paramInt;
    if (this.jdField_p_of_type_Boolean) {
      p();
    }
    if (this.aB == 0)
    {
      b();
      return;
    }
    if (this.az >= 0) {
      e(this.az);
    }
    c();
    detachAllViewsFromParent();
    this.m = 0;
    this.jdField_l_of_type_Int = 0;
    this.ap = this.aA;
    View localView = a(this.ap, 0, 0, true);
    paramInt = this.jdField_j_of_type_Int + i1;
    if (d()) {
      paramInt = (getRight() - getLeft() - this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_a_of_type_AndroidGraphicsRect.right) / 2 + i1 - localView.getWidth() / 2;
    }
    localView.offsetLeftAndRight(paramInt);
    o();
    m();
    this.jdField_a_of_type_Hvi.a();
    invalidate();
    this.jdField_p_of_type_Boolean = false;
    this.jdField_n_of_type_Boolean = false;
    f(this.aA);
    s();
    if (getChildCount() < this.aB) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_k_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  boolean b()
  {
    return (this.aB > 0) && (this.aA > 0);
  }
  
  public float c()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public int c()
  {
    return this.s;
  }
  
  public void c(int paramInt)
  {
    int i1 = getChildCount() - 1;
    while (i1 >= 0)
    {
      getChildAt(i1).offsetLeftAndRight(paramInt);
      if (Build.VERSION.SDK_INT >= 11) {
        getChildAt(i1).invalidate();
      }
      i1 -= 1;
    }
  }
  
  void c(int paramInt, boolean paramBoolean)
  {
    paramInt = this.jdField_a_of_type_AndroidGraphicsRect.top;
    int i1 = this.jdField_p_of_type_Int + paramInt;
    if (this.jdField_p_of_type_Boolean) {
      p();
    }
    if (this.aB == 0)
    {
      b();
      return;
    }
    if (this.az >= 0) {
      e(this.az);
    }
    c();
    detachAllViewsFromParent();
    this.m = 0;
    this.jdField_l_of_type_Int = 0;
    this.ap = this.aA;
    View localView = b(this.ap, 0, 0, true);
    paramInt = this.jdField_j_of_type_Int + i1;
    if (d()) {
      paramInt = (getBottom() - getTop() - this.jdField_a_of_type_AndroidGraphicsRect.top - this.jdField_a_of_type_AndroidGraphicsRect.bottom) / 2 + i1 - localView.getHeight() / 2;
    }
    localView.offsetTopAndBottom(paramInt);
    r();
    n();
    this.jdField_a_of_type_Hvi.a();
    invalidate();
    this.jdField_p_of_type_Boolean = false;
    this.jdField_n_of_type_Boolean = false;
    f(this.aA);
    s();
    if (getChildCount() < this.aB) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_k_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  boolean c()
  {
    return (this.aB > 0) && (this.aA < this.aB - 1);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof VerticalGallery.LayoutParams;
  }
  
  protected int computeHorizontalScrollExtent()
  {
    int i3 = 0;
    int i4 = getChildCount();
    if (i4 > 0)
    {
      int i2 = i4 * 100;
      View localView = getChildAt(0);
      int i5 = localView.getLeft();
      int i6 = localView.getWidth();
      int i1 = i2;
      if (i6 > 0) {
        if (this.ap != 0) {
          break label160;
        }
      }
      label160:
      for (i1 = 1;; i1 = 0)
      {
        if (i1 != 0)
        {
          i1 = i2;
          if (i5 > 0) {}
        }
        else
        {
          i1 = i2 + i5 * 100 / i6;
        }
        localView = getChildAt(i4 - 1);
        i5 = localView.getRight();
        i6 = localView.getWidth();
        i2 = i1;
        if (i6 > 0)
        {
          i2 = i3;
          if (i4 + this.ap == this.aB) {
            i2 = 1;
          }
          if (i2 != 0)
          {
            i2 = i1;
            if (i5 < getWidth()) {}
          }
          else
          {
            i2 = i1 - (i5 - getWidth()) * 100 / i6;
          }
        }
        return i2;
      }
    }
    return 0;
  }
  
  protected int computeHorizontalScrollOffset()
  {
    if ((this.ap >= 0) && (getChildCount() > 0))
    {
      View localView = getChildAt(0);
      int i1 = localView.getLeft();
      int i2 = localView.getWidth();
      if (i2 > 0) {
        return Math.max(this.ap / 1 * 100 - i1 * 100 / i2, 0);
      }
    }
    return this.aA;
  }
  
  protected int computeHorizontalScrollRange()
  {
    return Math.max((this.aB + 1 - 1) / 1 * 100, 0);
  }
  
  public int d()
  {
    return this.ap;
  }
  
  public void d()
  {
    int i2 = 0;
    if (h()) {
      i();
    }
    int i1;
    do
    {
      do
      {
        return;
        if (!d()) {
          break;
        }
      } while ((getChildCount() == 0) || (this.jdField_c_of_type_AndroidViewView == null));
      i1 = d(this.jdField_c_of_type_AndroidViewView);
      i1 = b() - i1;
      if (i1 != 0)
      {
        this.jdField_a_of_type_Hxa.b(i1);
        return;
      }
      j();
      return;
    } while (getChildCount() == 0);
    View localView1;
    if (this.ap == 0)
    {
      localView1 = getChildAt(0);
      if (localView1.getLeft() >= 0) {
        i1 = getPaddingLeft() - localView1.getLeft();
      }
    }
    while (i1 != 0)
    {
      this.jdField_a_of_type_Hxa.b(i1);
      return;
      View localView2 = getChildAt(getChildCount() - 1);
      if (localView2.getRight() - localView1.getLeft() < getRight() - getPaddingRight())
      {
        i1 = getPaddingLeft() - this.jdField_p_of_type_Int;
      }
      else
      {
        i1 = i2;
        if (localView2.getRight() < getRight() - getPaddingRight())
        {
          i1 = getWidth() - getPaddingRight() - localView2.getRight();
          continue;
          i1 = i2;
          if (this.ap + getChildCount() == this.aB)
          {
            localView1 = getChildAt(getChildCount() - 1);
            i1 = i2;
            if (localView1.getRight() < getRight() - getPaddingRight()) {
              i1 = getWidth() - getPaddingRight() - localView1.getRight();
            }
          }
        }
      }
    }
    j();
  }
  
  public void d(int paramInt)
  {
    int i1 = getChildCount() - 1;
    while (i1 >= 0)
    {
      getChildAt(i1).offsetTopAndBottom(paramInt);
      if (Build.VERSION.SDK_INT >= 11) {
        getChildAt(i1).invalidate();
      }
      i1 -= 1;
    }
  }
  
  public boolean d()
  {
    return this.jdField_l_of_type_Boolean;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return paramKeyEvent.dispatch(this);
  }
  
  protected void dispatchSetPressed(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.setPressed(paramBoolean);
    }
  }
  
  public void dispatchSetSelected(boolean paramBoolean) {}
  
  public int e()
  {
    return this.jdField_j_of_type_Int;
  }
  
  protected void e()
  {
    if (hxa.a(this.jdField_a_of_type_Hxa).isFinished()) {
      d();
    }
    g();
  }
  
  protected void e(int paramInt)
  {
    super.e(paramInt);
    s();
  }
  
  public boolean e()
  {
    return this.i;
  }
  
  void f()
  {
    e();
  }
  
  protected boolean f()
  {
    if ((!this.h) || (getChildCount() < this.aB)) {}
    View localView;
    do
    {
      do
      {
        return false;
        localView = getChildAt(0);
      } while ((localView != null) && (localView.getLeft() < getLeft()));
      localView = getChildAt(getChildCount() - 1);
    } while ((localView != null) && (localView.getRight() > getRight()));
    return true;
  }
  
  public void g()
  {
    int i1 = getChildCount() - 1;
    while (i1 >= 0)
    {
      getChildAt(i1).setPressed(false);
      i1 -= 1;
    }
    setPressed(false);
  }
  
  public boolean g()
  {
    return (this.jdField_j_of_type_Boolean) && (this.jdField_k_of_type_Boolean);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new VerticalGallery.LayoutParams(-2, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new VerticalGallery.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new VerticalGallery.LayoutParams(paramLayoutParams);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i1 = this.aA - this.ap;
    if (i1 < 0) {}
    do
    {
      return paramInt2;
      if (paramInt2 == paramInt1 - 1) {
        return i1;
      }
    } while (paramInt2 < i1);
    return paramInt2 + 1;
  }
  
  public boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    paramTransformation.clear();
    if (paramView == this.jdField_c_of_type_AndroidViewView) {}
    for (float f1 = 1.0F;; f1 = this.jdField_a_of_type_Float)
    {
      paramTransformation.setAlpha(f1);
      return true;
    }
  }
  
  protected ContextMenu.ContextMenuInfo getContextMenuInfo()
  {
    return this.jdField_a_of_type_ComTencentWidgetAdapterView$AdapterContextMenuInfo;
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentWidgetVerticalGallery$OnEndFlingListener != null) {
      this.jdField_a_of_type_ComTencentWidgetVerticalGallery$OnEndFlingListener.a(this);
    }
  }
  
  public void invalidate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.invalidate(paramInt1, paramInt2 - (this.r + this.q), paramInt3, paramInt4);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    if ((1 == paramMotionEvent.getAction()) && (this.jdField_o_of_type_Int >= 0))
    {
      if ((!this.jdField_d_of_type_Boolean) && (this.jdField_o_of_type_Int == this.aA)) {}
      return true;
    }
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Hxa.a(false);
    this.jdField_o_of_type_Int = a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    if (this.jdField_o_of_type_Int >= 0)
    {
      this.jdField_b_of_type_AndroidViewView = getChildAt(this.jdField_o_of_type_Int - this.ap);
      this.jdField_b_of_type_AndroidViewView.setPressed(true);
    }
    this.g = true;
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (f()) {
      return true;
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      if (!this.e) {
        this.e = true;
      }
    }
    if (h())
    {
      paramFloat1 = c();
      this.jdField_a_of_type_Hxa.a((int)-(paramFloat1 * paramFloat2));
      return true;
    }
    paramFloat2 = c();
    this.jdField_a_of_type_Hxa.a((int)-(paramFloat2 * paramFloat1));
    return true;
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if ((paramBoolean) && (this.jdField_c_of_type_AndroidViewView != null)) {
      this.jdField_c_of_type_AndroidViewView.requestFocus(paramInt);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      bool = super.onKeyDown(paramInt, paramKeyEvent);
      do
      {
        do
        {
          return bool;
        } while (!b());
        playSoundEffect(1);
        return true;
      } while (!c());
      playSoundEffect(3);
      return true;
      this.f = true;
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyUp(paramInt, paramKeyEvent);
    }
    if ((this.f) && (this.aB > 0))
    {
      a(this.jdField_c_of_type_AndroidViewView);
      postDelayed(new hwz(this), ViewConfiguration.getPressedStateDuration());
      a(getChildAt(this.aA - this.ap), this.aA, this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getItemId(this.aA));
    }
    this.f = false;
    return true;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_o_of_type_Boolean = true;
    b(0, false);
    this.jdField_o_of_type_Boolean = false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (this.jdField_o_of_type_Int < 0) {
      return;
    }
    performHapticFeedback(0);
    long l1 = a(this.jdField_o_of_type_Int);
    b(this.jdField_b_of_type_AndroidViewView, this.jdField_o_of_type_Int, l1);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (f()) {
      return true;
    }
    this.i = true;
    getParent().requestDisallowInterceptTouchEvent(true);
    if (!this.jdField_c_of_type_Boolean)
    {
      if (this.g)
      {
        if (!this.e) {
          this.e = true;
        }
        postDelayed(this.jdField_a_of_type_JavaLangRunnable, 250L);
      }
      if (!h()) {
        break label100;
      }
      b((int)paramFloat2 * -1);
    }
    for (;;)
    {
      this.g = false;
      return true;
      if (!this.e) {
        break;
      }
      this.e = false;
      break;
      label100:
      a((int)paramFloat1 * -1);
    }
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (this.jdField_o_of_type_Int >= 0)
    {
      if (g()) {
        this.jdField_o_of_type_Int %= a();
      }
      if (d()) {
        a(this.jdField_o_of_type_Int - this.ap);
      }
      b(this.jdField_o_of_type_Int);
      if ((this.jdField_d_of_type_Boolean) || (this.jdField_o_of_type_Int == this.aA)) {
        a(this.jdField_b_of_type_AndroidViewView, this.jdField_o_of_type_Int, this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getItemId(this.jdField_o_of_type_Int));
      }
      return true;
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    int i1 = paramMotionEvent.getAction();
    if (i1 == 1) {
      e();
    }
    while (i1 != 3) {
      return bool;
    }
    f();
    return bool;
  }
  
  public void setAnimationDuration(int paramInt)
  {
    this.jdField_k_of_type_Int = paramInt;
  }
  
  public void setCallbackDuringFling(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setCallbackOnUnselectedItemClick(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setDisableScroll(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setFirstChildOffset(int paramInt)
  {
    this.jdField_p_of_type_Int = paramInt;
  }
  
  public void setFirstPosition(int paramInt)
  {
    this.ap = paramInt;
  }
  
  public void setGravity(int paramInt)
  {
    if (this.jdField_n_of_type_Int != paramInt)
    {
      this.jdField_n_of_type_Int = paramInt;
      requestLayout();
    }
  }
  
  public void setOnEndFlingListener(VerticalGallery.OnEndFlingListener paramOnEndFlingListener)
  {
    this.jdField_a_of_type_ComTencentWidgetVerticalGallery$OnEndFlingListener = paramOnEndFlingListener;
  }
  
  public void setOnEndMovementListener(VerticalGallery.OnEndMovementListener paramOnEndMovementListener)
  {
    this.jdField_a_of_type_ComTencentWidgetVerticalGallery$OnEndMovementListener = paramOnEndMovementListener;
  }
  
  public void setOnSelectViewDataUpdateListener(VerticalGallery.OnSelectViewDataUpdateListener paramOnSelectViewDataUpdateListener)
  {
    this.jdField_a_of_type_ComTencentWidgetVerticalGallery$OnSelectViewDataUpdateListener = paramOnSelectViewDataUpdateListener;
  }
  
  public void setOrientation(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void setScrollBarBottomMargin(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void setScrollBarSize(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void setScrollCycle(boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = paramBoolean;
  }
  
  public void setSlotInCenter(boolean paramBoolean)
  {
    this.jdField_l_of_type_Boolean = paramBoolean;
  }
  
  public void setSpacing(int paramInt)
  {
    this.jdField_j_of_type_Int = paramInt;
  }
  
  public void setUnselectedAlpha(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void setVelocityRatio(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
    if (this.jdField_b_of_type_Float < 0.5F) {
      this.jdField_b_of_type_Float = 0.5F;
    }
    while (this.jdField_b_of_type_Float <= 1.5F) {
      return;
    }
    this.jdField_b_of_type_Float = 1.5F;
  }
  
  public boolean showContextMenu()
  {
    if ((isPressed()) && (this.aA >= 0)) {
      return b(getChildAt(this.aA - this.ap), this.aA, this.jdField_d_of_type_Long);
    }
    return false;
  }
  
  public boolean showContextMenuForChild(View paramView)
  {
    int i1 = c(paramView);
    if (i1 < 0) {
      return false;
    }
    return b(paramView, i1, this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getItemId(i1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.widget.VerticalGallery
 * JD-Core Version:    0.7.0.1
 */