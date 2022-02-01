package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.GridLayoutAnimationController.AnimationParameters;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import com.tencent.util.VersionUtils;
import huu;
import hvd;
import hve;

public class GridView
  extends AbsListView
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = -1;
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private View jdField_a_of_type_AndroidViewView = null;
  private View b;
  private int f;
  private int g = 0;
  private int h;
  private int i = 0;
  private int j = 2;
  private int k;
  private int l;
  private int m;
  private int n;
  
  public GridView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842865);
  }
  
  public GridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_f_of_type_Int = -1;
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_n_of_type_Int = 3;
    setEdgeEffectEnabled(false);
    this.aj = 2147483647;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = paramInt1;
    if (paramInt3 > 0) {
      i1 = paramInt1 + paramInt2;
    }
    return i1;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = paramInt1;
    if (paramInt4 + paramInt3 - 1 < this.aB - 1) {
      i1 = paramInt1 - paramInt2;
    }
    return i1;
  }
  
  private View a(int paramInt)
  {
    this.ap = Math.min(this.ap, this.aA);
    this.ap = Math.min(this.ap, this.aB - 1);
    if (this.ap < 0) {
      this.ap = 0;
    }
    this.ap -= this.ap % this.jdField_f_of_type_Int;
    return a(this.ap, paramInt);
  }
  
  private View a(int paramInt1, int paramInt2)
  {
    Object localObject = null;
    int i1 = this.mBottom - this.mTop;
    if ((this.mGroupFlags & 0x22) == 34) {
      i1 -= this.c.bottom;
    }
    for (;;)
    {
      if ((paramInt2 < i1) && (paramInt1 < this.aB))
      {
        View localView = a(paramInt1, paramInt2, true);
        if (localView == null) {
          break label92;
        }
        localObject = localView;
      }
      label92:
      for (;;)
      {
        paramInt2 = this.jdField_a_of_type_AndroidViewView.getBottom() + this.i;
        paramInt1 += this.jdField_f_of_type_Int;
        break;
        return localObject;
      }
    }
  }
  
  private View a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i5 = getVerticalFadingEdgeLength();
    int i2 = this.aA;
    int i3 = this.jdField_f_of_type_Int;
    int i4 = this.i;
    int i1 = -1;
    int i6;
    if (!this.jdField_h_of_type_Boolean)
    {
      i2 -= i2 % i3;
      i6 = a(paramInt2, i5, i2);
      paramInt3 = a(paramInt3, i5, i3, i2);
      if (!this.jdField_h_of_type_Boolean) {
        break label210;
      }
    }
    View localView1;
    View localView2;
    label210:
    for (paramInt2 = i1;; paramInt2 = i2)
    {
      localView1 = a(paramInt2, paramInt1, true);
      this.ap = i2;
      localView2 = this.jdField_a_of_type_AndroidViewView;
      b(localView2, i6, paramInt3);
      a(localView2, i6, paramInt3);
      if (this.jdField_h_of_type_Boolean) {
        break label216;
      }
      b(i2 - i3, localView2.getTop() - i4);
      b();
      a(i2 + i3, localView2.getBottom() + i4);
      return localView1;
      i1 = this.aB - 1 - i2;
      i1 = this.aB - 1 - (i1 - i1 % i3);
      i2 = Math.max(0, i1 - i3 + 1);
      break;
    }
    label216:
    a(i1 + i3, localView2.getBottom() + i4);
    b();
    b(i2 - 1, localView2.getTop() - i4);
    return localView1;
  }
  
  private View a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i6 = this.k;
    int i5 = this.g;
    int i2 = this.c.left;
    int i1;
    int i3;
    if (this.j == 3)
    {
      i1 = i5;
      i2 = i1 + i2;
      if (this.jdField_h_of_type_Boolean) {
        break label191;
      }
      i3 = Math.min(this.jdField_f_of_type_Int + paramInt1, this.aB);
      i1 = paramInt1;
      paramInt1 = i3;
    }
    for (;;)
    {
      label68:
      Object localObject = null;
      boolean bool2 = j();
      boolean bool3 = i();
      int i7 = this.aA;
      View localView = null;
      i3 = i1;
      label96:
      boolean bool1;
      label112:
      int i4;
      if (i3 < paramInt1) {
        if (i3 == i7)
        {
          bool1 = true;
          if (!paramBoolean) {
            break label259;
          }
          i4 = -1;
          label119:
          localView = a(i3, paramInt2, paramBoolean, i2, bool1, i4);
          i2 += i6;
          if (i3 >= paramInt1 - 1) {
            break label294;
          }
          i2 += i5;
        }
      }
      label259:
      label294:
      for (;;)
      {
        if ((bool1) && ((bool2) || (bool3))) {
          localObject = localView;
        }
        for (;;)
        {
          i3 += 1;
          break label96;
          i1 = 0;
          break;
          label191:
          i1 = paramInt1 + 1;
          i3 = Math.max(0, paramInt1 - this.jdField_f_of_type_Int + 1);
          if (i1 - i3 >= this.jdField_f_of_type_Int) {
            break label297;
          }
          i2 += (this.jdField_f_of_type_Int - (i1 - i3)) * (i6 + i5);
          paramInt1 = i1;
          i1 = i3;
          break label68;
          bool1 = false;
          break label112;
          i4 = i3 - i1;
          break label119;
          this.jdField_a_of_type_AndroidViewView = localView;
          if (localObject != null) {
            this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView;
          }
          return localObject;
        }
      }
      label297:
      paramInt1 = i1;
      i1 = i3;
    }
  }
  
  private View a(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, int paramInt4)
  {
    if (!this.p)
    {
      localView = this.jdField_a_of_type_Hve.a(paramInt1);
      if (localView != null)
      {
        a(localView, paramInt1, paramInt2, paramBoolean1, paramInt3, paramBoolean2, true, paramInt4);
        return localView;
      }
    }
    View localView = a(paramInt1, this.jdField_a_of_type_ArrayOfBoolean);
    a(localView, paramInt1, paramInt2, paramBoolean1, paramInt3, paramBoolean2, this.jdField_a_of_type_ArrayOfBoolean[0], paramInt4);
    return localView;
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView.getBottom() > paramInt2) {
      offsetChildrenTopAndBottom(-Math.min(paramView.getTop() - paramInt1, paramView.getBottom() - paramInt2));
    }
  }
  
  @TargetApi(11)
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3, int paramInt4)
  {
    int i2;
    label27:
    int i1;
    boolean bool;
    label55:
    int i3;
    label67:
    label87:
    AbsListView.LayoutParams localLayoutParams;
    if ((paramBoolean2) && (j()))
    {
      paramBoolean2 = true;
      if (paramBoolean2 == paramView.isSelected()) {
        break label400;
      }
      i2 = 1;
      i1 = this.ab;
      if ((i1 <= 0) || (i1 >= 3) || (this.W != paramInt1)) {
        break label406;
      }
      bool = true;
      if (bool == paramView.isPressed()) {
        break label412;
      }
      i3 = 1;
      if ((paramBoolean3) && (i2 == 0) && (!paramView.isLayoutRequested())) {
        break label418;
      }
      i1 = 1;
      localLayoutParams = (AbsListView.LayoutParams)paramView.getLayoutParams();
      if (localLayoutParams != null) {
        break label545;
      }
      localLayoutParams = (AbsListView.LayoutParams)generateDefaultLayoutParams();
    }
    label147:
    label283:
    label412:
    label545:
    for (;;)
    {
      localLayoutParams.a = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemViewType(paramInt1);
      if ((paramBoolean3) && (!localLayoutParams.jdField_b_of_type_Boolean))
      {
        attachViewToParent(paramView, paramInt4, localLayoutParams);
        if (i2 != 0)
        {
          paramView.setSelected(paramBoolean2);
          if (paramBoolean2) {
            requestFocus();
          }
        }
        if (i3 != 0) {
          paramView.setPressed(bool);
        }
        if ((this.N != 0) && (this.jdField_a_of_type_AndroidUtilSparseBooleanArray != null))
        {
          if (!(paramView instanceof Checkable)) {
            break label444;
          }
          ((Checkable)paramView).setChecked(this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(paramInt1));
        }
        label217:
        if (i1 == 0) {
          break label474;
        }
        paramInt4 = ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), 0, localLayoutParams.height);
        paramView.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(this.k, 1073741824), 0, localLayoutParams.width), paramInt4);
        i2 = paramView.getMeasuredWidth();
        i3 = paramView.getMeasuredHeight();
        if (!paramBoolean1) {
          break label482;
        }
        paramInt4 = paramInt2;
        paramInt2 = paramInt3;
        switch (this.jdField_n_of_type_Int & 0x7)
        {
        default: 
          paramInt2 = paramInt3;
        case 2: 
        case 3: 
        case 4: 
          label331:
          if (i1 != 0) {
            paramView.layout(paramInt2, paramInt4, i2 + paramInt2, i3 + paramInt4);
          }
          break;
        }
      }
      for (;;)
      {
        if (this.jdField_f_of_type_Boolean) {
          paramView.setDrawingCacheEnabled(true);
        }
        if ((VersionUtils.e()) && (paramBoolean3) && (((AbsListView.LayoutParams)paramView.getLayoutParams()).jdField_b_of_type_Int != paramInt1)) {
          paramView.jumpDrawablesToCurrentState();
        }
        return;
        paramBoolean2 = false;
        break;
        i2 = 0;
        break label27;
        bool = false;
        break label55;
        i3 = 0;
        break label67;
        label418:
        i1 = 0;
        break label87;
        localLayoutParams.jdField_b_of_type_Boolean = false;
        addViewInLayout(paramView, paramInt4, localLayoutParams, true);
        break label147;
        label444:
        if (getContext().getApplicationInfo().targetSdkVersion < 11) {
          break label217;
        }
        paramView.setActivated(this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(paramInt1));
        break label217;
        label474:
        cleanupLayoutState(paramView);
        break label263;
        label482:
        paramInt4 = paramInt2 - i3;
        break label283;
        paramInt2 = paramInt3 + (this.k - i2) / 2;
        break label331;
        paramInt2 = this.k + paramInt3 - i2;
        break label331;
        paramView.offsetLeftAndRight(paramInt2 - paramView.getLeft());
        paramView.offsetTopAndBottom(paramInt4 - paramView.getTop());
      }
    }
  }
  
  private View b(int paramInt1, int paramInt2)
  {
    Object localObject = null;
    int i1;
    if ((this.mGroupFlags & 0x22) == 34) {
      i1 = this.c.top;
    }
    for (;;)
    {
      if ((paramInt2 > i1) && (paramInt1 >= 0))
      {
        View localView = a(paramInt1, paramInt2, false);
        if (localView == null) {
          break label99;
        }
        localObject = localView;
      }
      label99:
      for (;;)
      {
        paramInt2 = this.jdField_a_of_type_AndroidViewView.getTop() - this.i;
        this.ap = paramInt1;
        paramInt1 -= this.jdField_f_of_type_Int;
        break;
        if (this.jdField_h_of_type_Boolean) {
          this.ap = Math.max(0, paramInt1 + 1);
        }
        return localObject;
      }
      i1 = 0;
    }
  }
  
  private View b(int paramInt1, int paramInt2, int paramInt3)
  {
    int i3 = 0;
    int i7 = getVerticalFadingEdgeLength();
    int i8 = this.aA;
    int i5 = this.jdField_f_of_type_Int;
    int i6 = this.i;
    int i4 = -1;
    int i2;
    int i1;
    if (!this.jdField_h_of_type_Boolean)
    {
      i2 = i8 - paramInt1 - (i8 - paramInt1) % i5;
      i1 = i8 - i8 % i5;
      paramInt1 = i4;
      i8 = i1 - i2;
      i2 = a(paramInt2, i7, i1);
      i4 = a(paramInt3, i7, i5, i1);
      this.ap = i1;
      if (i8 <= 0) {
        break label306;
      }
      if (this.jdField_b_of_type_AndroidViewView != null) {
        break label289;
      }
      paramInt2 = 0;
      label115:
      if (!this.jdField_h_of_type_Boolean) {
        break label300;
      }
    }
    View localView2;
    View localView1;
    label289:
    label300:
    for (paramInt3 = paramInt1;; paramInt3 = i1)
    {
      localView2 = a(paramInt3, paramInt2 + i6, true);
      localView1 = this.jdField_a_of_type_AndroidViewView;
      a(localView1, i2, i4);
      if (this.jdField_h_of_type_Boolean) {
        break label431;
      }
      b(i1 - i5, localView1.getTop() - i6);
      b();
      a(i1 + i5, localView1.getBottom() + i6);
      return localView2;
      i1 = this.aB - 1 - i8;
      i2 = this.aB - 1 - (i1 - i1 % i5);
      i1 = Math.max(0, i2 - i5 + 1);
      paramInt1 = this.aB - 1 - (i8 - paramInt1);
      i4 = Math.max(0, this.aB - 1 - (paramInt1 - paramInt1 % i5) - i5 + 1);
      paramInt1 = i2;
      i2 = i4;
      break;
      paramInt2 = this.jdField_b_of_type_AndroidViewView.getBottom();
      break label115;
    }
    label306:
    if (i8 < 0)
    {
      if (this.jdField_b_of_type_AndroidViewView == null)
      {
        paramInt2 = 0;
        label320:
        if (!this.jdField_h_of_type_Boolean) {
          break label371;
        }
      }
      label371:
      for (paramInt3 = paramInt1;; paramInt3 = i1)
      {
        localView2 = a(paramInt3, paramInt2 - i6, false);
        localView1 = this.jdField_a_of_type_AndroidViewView;
        b(localView1, i2, i4);
        break;
        paramInt2 = this.jdField_b_of_type_AndroidViewView.getTop();
        break label320;
      }
    }
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      paramInt2 = i3;
      label387:
      if (!this.jdField_h_of_type_Boolean) {
        break label425;
      }
    }
    label425:
    for (paramInt3 = paramInt1;; paramInt3 = i1)
    {
      localView2 = a(paramInt3, paramInt2, true);
      localView1 = this.jdField_a_of_type_AndroidViewView;
      break;
      paramInt2 = this.jdField_b_of_type_AndroidViewView.getTop();
      break label387;
    }
    label431:
    a(paramInt1 + i5, localView1.getBottom() + i6);
    b();
    b(i1 - 1, localView1.getTop() - i6);
    return localView2;
  }
  
  private void b()
  {
    int i3 = 0;
    int i4 = getChildCount();
    int i2;
    int i1;
    if (i4 > 0)
    {
      if (this.jdField_h_of_type_Boolean) {
        break label72;
      }
      i2 = getChildAt(0).getTop() - this.c.top;
      i1 = i2;
      if (this.ap != 0) {
        i1 = i2 - this.i;
      }
      i2 = i1;
      if (i1 >= 0) {
        break label128;
      }
      i2 = i3;
    }
    label128:
    for (;;)
    {
      if (i2 != 0) {
        offsetChildrenTopAndBottom(-i2);
      }
      return;
      label72:
      i2 = getChildAt(i4 - 1).getBottom() - (getHeight() - this.c.bottom);
      i1 = i2;
      if (i4 + this.ap < this.aB) {
        i1 = i2 + this.i;
      }
      i2 = i3;
      if (i1 <= 0) {
        i2 = i1;
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.ap + paramInt3 - 1 == this.aB - 1) && (paramInt3 > 0))
    {
      paramInt3 = getChildAt(paramInt3 - 1).getBottom();
      int i1 = this.mBottom - this.mTop - this.c.bottom - paramInt3;
      View localView = getChildAt(0);
      int i2 = localView.getTop();
      if ((i1 > 0) && ((this.ap > 0) || (i2 < this.c.top)))
      {
        paramInt3 = i1;
        if (this.ap == 0) {
          paramInt3 = Math.min(i1, this.c.top - i2);
        }
        offsetChildrenTopAndBottom(paramInt3);
        if (this.ap > 0)
        {
          paramInt3 = this.ap;
          if (this.jdField_h_of_type_Boolean) {
            paramInt1 = 1;
          }
          b(paramInt3 - paramInt1, localView.getTop() - paramInt2);
          b();
        }
      }
    }
  }
  
  private void b(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView.getTop() < paramInt1) {
      offsetChildrenTopAndBottom(Math.min(paramInt1 - paramView.getTop(), paramInt2 - paramView.getBottom()));
    }
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    int i3 = getChildCount();
    int i1 = i3 - 1 - paramInt1;
    int i2;
    if (!this.jdField_h_of_type_Boolean)
    {
      i2 = paramInt1 - paramInt1 % this.jdField_f_of_type_Int;
      i1 = Math.max(this.jdField_f_of_type_Int + i2 - 1, i3);
    }
    for (;;)
    {
      switch (paramInt2)
      {
      default: 
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
        i1 = i3 - 1 - (i1 - i1 % this.jdField_f_of_type_Int);
        i2 = Math.max(0, i1 - this.jdField_f_of_type_Int + 1);
      }
    }
    if (paramInt1 == i2) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return true;
              return false;
            } while (i2 == 0);
            return false;
          } while (paramInt1 == i1);
          return false;
        } while (i1 == i3 - 1);
        return false;
      } while ((paramInt1 == i2) && (i2 == 0));
      return false;
    } while ((paramInt1 == i1) && (i1 == i3 - 1));
    return false;
  }
  
  @TargetApi(11)
  private boolean b(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_AndroidWidgetListAdapter == null) {
      return false;
    }
    if (this.p) {
      i();
    }
    int i1 = paramKeyEvent.getAction();
    if (i1 != 1) {}
    int i2;
    switch (paramInt1)
    {
    default: 
      i2 = 0;
    }
    for (;;)
    {
      if (i2 == 0) {
        break label804;
      }
      return true;
      if ((!VersionUtils.e()) || (!paramKeyEvent.hasNoModifiers())) {
        break;
      }
      if ((k()) || (e(17)))
      {
        i2 = 1;
      }
      else
      {
        i2 = 0;
        continue;
        if ((!VersionUtils.e()) || (!paramKeyEvent.hasNoModifiers())) {
          break;
        }
        if ((k()) || (e(66)))
        {
          i2 = 1;
        }
        else
        {
          i2 = 0;
          continue;
          if ((VersionUtils.e()) && (paramKeyEvent.hasNoModifiers()))
          {
            if ((k()) || (e(33))) {
              i2 = 1;
            } else {
              i2 = 0;
            }
          }
          else
          {
            if ((!VersionUtils.e()) || (!paramKeyEvent.hasModifiers(2))) {
              break;
            }
            if ((k()) || (d(33)))
            {
              i2 = 1;
            }
            else
            {
              i2 = 0;
              continue;
              if ((VersionUtils.e()) && (paramKeyEvent.hasNoModifiers()))
              {
                if ((k()) || (e(130))) {
                  i2 = 1;
                } else {
                  i2 = 0;
                }
              }
              else
              {
                if ((!VersionUtils.e()) || (!paramKeyEvent.hasModifiers(2))) {
                  break;
                }
                if ((k()) || (d(130)))
                {
                  i2 = 1;
                }
                else
                {
                  i2 = 0;
                  continue;
                  if ((!VersionUtils.e()) || (!paramKeyEvent.hasNoModifiers())) {
                    break;
                  }
                  boolean bool = k();
                  i2 = bool;
                  if (!bool)
                  {
                    i2 = bool;
                    if (paramKeyEvent.getRepeatCount() == 0)
                    {
                      i2 = bool;
                      if (getChildCount() > 0)
                      {
                        k();
                        i2 = 1;
                        continue;
                        if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
                          break;
                        }
                        if ((VersionUtils.e()) && (paramKeyEvent.hasNoModifiers()))
                        {
                          if ((k()) || (c(130))) {
                            i2 = 1;
                          } else {
                            i2 = 0;
                          }
                        }
                        else
                        {
                          if ((!VersionUtils.e()) || (!paramKeyEvent.hasModifiers(1))) {
                            break;
                          }
                          if ((k()) || (c(33)))
                          {
                            i2 = 1;
                          }
                          else
                          {
                            i2 = 0;
                            continue;
                            if ((VersionUtils.e()) && (paramKeyEvent.hasNoModifiers()))
                            {
                              if ((k()) || (c(33))) {
                                i2 = 1;
                              } else {
                                i2 = 0;
                              }
                            }
                            else
                            {
                              if ((!VersionUtils.e()) || (!paramKeyEvent.hasModifiers(2))) {
                                break;
                              }
                              if ((k()) || (d(33)))
                              {
                                i2 = 1;
                              }
                              else
                              {
                                i2 = 0;
                                continue;
                                if ((VersionUtils.e()) && (paramKeyEvent.hasNoModifiers()))
                                {
                                  if ((k()) || (c(130))) {
                                    i2 = 1;
                                  } else {
                                    i2 = 0;
                                  }
                                }
                                else
                                {
                                  if ((!VersionUtils.e()) || (!paramKeyEvent.hasModifiers(2))) {
                                    break;
                                  }
                                  if ((k()) || (d(130)))
                                  {
                                    i2 = 1;
                                  }
                                  else
                                  {
                                    i2 = 0;
                                    continue;
                                    if ((!VersionUtils.e()) || (!paramKeyEvent.hasNoModifiers())) {
                                      break;
                                    }
                                    if ((k()) || (d(33)))
                                    {
                                      i2 = 1;
                                    }
                                    else
                                    {
                                      i2 = 0;
                                      continue;
                                      if ((!VersionUtils.e()) || (!paramKeyEvent.hasNoModifiers())) {
                                        break;
                                      }
                                      if ((k()) || (d(130))) {
                                        i2 = 1;
                                      } else {
                                        i2 = 0;
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label804:
    if (a(paramInt1, paramInt2, paramKeyEvent)) {
      return true;
    }
    switch (i1)
    {
    default: 
      return false;
    case 0: 
      return super.onKeyDown(paramInt1, paramKeyEvent);
    case 1: 
      return super.onKeyUp(paramInt1, paramKeyEvent);
    }
    return super.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
  }
  
  private View c(int paramInt1, int paramInt2)
  {
    paramInt1 = Math.min(Math.max(paramInt1, this.aA), this.aB - 1);
    paramInt1 = this.aB - 1 - paramInt1;
    return b(this.aB - 1 - (paramInt1 - paramInt1 % this.jdField_f_of_type_Int), paramInt2);
  }
  
  private void c(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.ap == 0) && (paramInt3 > 0))
    {
      int i1 = getChildAt(0).getTop();
      int i3 = this.c.top;
      int i2 = this.mBottom - this.mTop - this.c.bottom;
      i1 -= i3;
      View localView = getChildAt(paramInt3 - 1);
      int i4 = localView.getBottom();
      i3 = this.ap + paramInt3 - 1;
      if ((i1 > 0) && ((i3 < this.aB - 1) || (i4 > i2)))
      {
        paramInt3 = i1;
        if (i3 == this.aB - 1) {
          paramInt3 = Math.min(i1, i4 - i2);
        }
        offsetChildrenTopAndBottom(-paramInt3);
        if (i3 < this.aB - 1)
        {
          if (!this.jdField_h_of_type_Boolean) {
            paramInt1 = 1;
          }
          a(i3 + paramInt1, localView.getBottom() + paramInt2);
          b();
        }
      }
    }
  }
  
  private View d(int paramInt1, int paramInt2)
  {
    int i2 = m();
    int i4 = this.jdField_f_of_type_Int;
    int i5 = this.i;
    int i1 = -1;
    int i6;
    int i7;
    if (!this.jdField_h_of_type_Boolean)
    {
      i2 -= i2 % i4;
      i6 = getVerticalFadingEdgeLength();
      i7 = a(paramInt1, i6, i2);
      if (!this.jdField_h_of_type_Boolean) {
        break label181;
      }
    }
    View localView1;
    View localView2;
    label181:
    for (int i3 = i1;; i3 = i2)
    {
      localView1 = a(i3, i7, true);
      this.ap = i2;
      localView2 = this.jdField_a_of_type_AndroidViewView;
      if (this.jdField_h_of_type_Boolean) {
        break label188;
      }
      a(i2 + i4, localView2.getBottom() + i5);
      h(paramInt2);
      b(i2 - i4, localView2.getTop() - i5);
      b();
      return localView1;
      i1 = this.aB - 1 - i2;
      i1 = this.aB - 1 - (i1 - i1 % i4);
      i2 = Math.max(0, i1 - i4 + 1);
      break;
    }
    label188:
    offsetChildrenTopAndBottom(a(paramInt2, i6, i4, i2) - localView2.getBottom());
    b(i2 - 1, localView2.getTop() - i5);
    g(paramInt1);
    a(i1 + i4, localView2.getBottom() + i5);
    b();
    return localView1;
  }
  
  private View e(int paramInt1, int paramInt2)
  {
    int i3 = this.jdField_f_of_type_Int;
    int i2 = -1;
    int i1;
    label36:
    View localView3;
    Object localObject1;
    Object localObject2;
    if (!this.jdField_h_of_type_Boolean)
    {
      i1 = paramInt1 - paramInt1 % i3;
      paramInt1 = i2;
      if (!this.jdField_h_of_type_Boolean) {
        break label105;
      }
      i2 = paramInt1;
      localView3 = a(i2, paramInt2, true);
      this.ap = i1;
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 != null) {
        break label111;
      }
      localObject2 = null;
    }
    label105:
    label111:
    View localView1;
    do
    {
      return localObject2;
      paramInt1 = this.aB - 1 - paramInt1;
      paramInt1 = this.aB - 1 - (paramInt1 - paramInt1 % i3);
      i1 = Math.max(0, paramInt1 - i3 + 1);
      break;
      i2 = i1;
      break label36;
      paramInt2 = this.i;
      if (!this.jdField_h_of_type_Boolean)
      {
        localObject2 = b(i1 - i3, ((View)localObject1).getTop() - paramInt2);
        b();
        View localView2 = a(i1 + i3, ((View)localObject1).getBottom() + paramInt2);
        paramInt1 = getChildCount();
        localObject1 = localObject2;
        localView1 = localView2;
        if (paramInt1 > 0)
        {
          b(i3, paramInt2, paramInt1);
          localView1 = localView2;
          localObject1 = localObject2;
        }
      }
      while (localView3 != null)
      {
        return localView3;
        localView1 = a(paramInt1 + i3, ((View)localObject1).getBottom() + paramInt2);
        b();
        localObject1 = b(i1 - 1, ((View)localObject1).getTop() - paramInt2);
        paramInt1 = getChildCount();
        if (paramInt1 > 0) {
          c(i3, paramInt2, paramInt1);
        }
      }
      localObject2 = localObject1;
    } while (localObject1 != null);
    return localView1;
  }
  
  private void g(int paramInt)
  {
    if (this.ap == 0)
    {
      paramInt -= getChildAt(0).getTop();
      if (paramInt < 0) {
        offsetChildrenTopAndBottom(paramInt);
      }
    }
  }
  
  private boolean g(int paramInt)
  {
    int i1 = this.jdField_h_of_type_Int;
    int i2 = this.j;
    int i3 = this.l;
    boolean bool = false;
    if (this.m == -1) {
      if (i3 > 0) {
        this.jdField_f_of_type_Int = ((paramInt + i1) / (i3 + i1));
      }
    }
    for (;;)
    {
      if (this.jdField_f_of_type_Int <= 0) {
        this.jdField_f_of_type_Int = 1;
      }
      switch (i2)
      {
      default: 
        paramInt = paramInt - this.jdField_f_of_type_Int * i3 - (this.jdField_f_of_type_Int - 1) * i1;
        if (paramInt < 0) {
          bool = true;
        }
        switch (i2)
        {
        default: 
          return bool;
          this.jdField_f_of_type_Int = 2;
          continue;
          this.jdField_f_of_type_Int = this.m;
        }
        break;
      }
    }
    this.k = i3;
    this.g = i1;
    return false;
    this.k = (paramInt / this.jdField_f_of_type_Int + i3);
    this.g = i1;
    return bool;
    this.k = i3;
    if (this.jdField_f_of_type_Int > 1)
    {
      this.g = (paramInt / (this.jdField_f_of_type_Int - 1) + i1);
      return bool;
    }
    this.g = (i1 + paramInt);
    return bool;
    this.k = i3;
    if (this.jdField_f_of_type_Int > 1)
    {
      this.g = (paramInt / (this.jdField_f_of_type_Int + 1) + i1);
      return bool;
    }
    this.g = (i1 + paramInt);
    return bool;
  }
  
  private void h(int paramInt)
  {
    int i1 = getChildCount();
    if (this.ap + i1 == this.aB)
    {
      paramInt -= getChildAt(i1 - 1).getBottom();
      if (paramInt > 0) {
        offsetChildrenTopAndBottom(paramInt);
      }
    }
  }
  
  int a(int paramInt)
  {
    int i3 = getChildCount();
    if (i3 > 0)
    {
      int i2 = this.jdField_f_of_type_Int;
      if (!this.jdField_h_of_type_Boolean)
      {
        i1 = 0;
        while (i1 < i3)
        {
          if (paramInt <= getChildAt(i1).getBottom()) {
            return i1 + this.ap;
          }
          i1 += i2;
        }
      }
      int i1 = i3 - 1;
      while (i1 >= 0)
      {
        if (paramInt >= getChildAt(i1).getTop()) {
          return i1 + this.ap;
        }
        i1 -= i2;
      }
    }
    return -1;
  }
  
  int a(int paramInt, boolean paramBoolean)
  {
    int i1;
    if ((this.jdField_a_of_type_AndroidWidgetListAdapter == null) || (isInTouchMode())) {
      i1 = -1;
    }
    do
    {
      return i1;
      if (paramInt < 0) {
        break;
      }
      i1 = paramInt;
    } while (paramInt < this.aB);
    return -1;
  }
  
  public ListAdapter a()
  {
    return this.jdField_a_of_type_AndroidWidgetListAdapter;
  }
  
  protected void attachLayoutAnimationParameters(View paramView, ViewGroup.LayoutParams paramLayoutParams, int paramInt1, int paramInt2)
  {
    GridLayoutAnimationController.AnimationParameters localAnimationParameters = (GridLayoutAnimationController.AnimationParameters)paramLayoutParams.layoutAnimationParameters;
    paramView = localAnimationParameters;
    if (localAnimationParameters == null)
    {
      paramView = new GridLayoutAnimationController.AnimationParameters();
      paramLayoutParams.layoutAnimationParameters = paramView;
    }
    paramView.count = paramInt2;
    paramView.index = paramInt1;
    paramView.columnsCount = this.jdField_f_of_type_Int;
    paramView.rowsCount = (paramInt2 / this.jdField_f_of_type_Int);
    if (!this.jdField_h_of_type_Boolean)
    {
      paramView.column = (paramInt1 % this.jdField_f_of_type_Int);
      paramView.row = (paramInt1 / this.jdField_f_of_type_Int);
      return;
    }
    paramInt1 = paramInt2 - 1 - paramInt1;
    paramView.column = (this.jdField_f_of_type_Int - 1 - paramInt1 % this.jdField_f_of_type_Int);
    paramView.row = (paramView.rowsCount - 1 - paramInt1 / this.jdField_f_of_type_Int);
  }
  
  public int b()
  {
    return this.jdField_n_of_type_Int;
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
  }
  
  void b(boolean paramBoolean)
  {
    int i4 = this.jdField_f_of_type_Int;
    int i5 = this.i;
    int i2 = getChildCount();
    if (paramBoolean) {
      if ((this.mGroupFlags & 0x22) != 34) {
        break label194;
      }
    }
    label182:
    label194:
    for (int i1 = f();; i1 = 0)
    {
      if (i2 > 0) {
        i1 = getChildAt(i2 - 1).getBottom() + i5;
      }
      int i3 = this.ap + i2;
      i2 = i3;
      if (this.jdField_h_of_type_Boolean) {
        i2 = i3 + (i4 - 1);
      }
      a(i2, i1);
      b(i4, i5, getChildCount());
      return;
      if ((this.mGroupFlags & 0x22) == 34) {}
      for (i1 = g();; i1 = 0)
      {
        if (i2 > 0)
        {
          i1 = getChildAt(0).getTop() - i5;
          i2 = this.ap;
          if (this.jdField_h_of_type_Boolean) {
            break label182;
          }
          i2 -= i4;
        }
        for (;;)
        {
          b(i2, i1);
          c(i4, i5, getChildCount());
          return;
          i1 = getHeight() - i1;
          break;
          i2 -= 1;
        }
      }
    }
  }
  
  public void c(int paramInt)
  {
    super.c(paramInt);
  }
  
  boolean c(int paramInt)
  {
    boolean bool = false;
    int i1 = -1;
    if (paramInt == 33) {
      i1 = Math.max(0, this.aA - getChildCount());
    }
    for (;;)
    {
      if (i1 >= 0)
      {
        d(i1);
        f();
        awakenScrollBars();
        bool = true;
      }
      return bool;
      if (paramInt == 130) {
        i1 = Math.min(this.aB - 1, this.aA + getChildCount());
      }
    }
  }
  
  protected int computeVerticalScrollExtent()
  {
    int i3 = getChildCount();
    if (i3 > 0)
    {
      int i1 = this.jdField_f_of_type_Int;
      int i2 = (i3 + i1 - 1) / i1 * 100;
      View localView = getChildAt(0);
      int i4 = localView.getTop();
      int i5 = localView.getHeight();
      i1 = i2;
      if (i5 > 0) {
        i1 = i2 + i4 * 100 / i5;
      }
      localView = getChildAt(i3 - 1);
      i3 = localView.getBottom();
      i4 = localView.getHeight();
      i2 = i1;
      if (i4 > 0) {
        i2 = i1 - (i3 - getHeight()) * 100 / i4;
      }
      return i2;
    }
    return 0;
  }
  
  protected int computeVerticalScrollOffset()
  {
    int i2 = 0;
    int i1 = i2;
    if (this.ap >= 0)
    {
      i1 = i2;
      if (getChildCount() > 0)
      {
        View localView = getChildAt(0);
        int i3 = localView.getTop();
        int i4 = localView.getHeight();
        i1 = i2;
        if (i4 > 0)
        {
          i2 = this.jdField_f_of_type_Int;
          i1 = this.ap / i2;
          i2 = (this.aB + i2 - 1) / i2;
          i1 = Math.max(i1 * 100 - i3 * 100 / i4 + (int)(this.mScrollY / getHeight() * i2 * 100.0F), 0);
        }
      }
    }
    return i1;
  }
  
  protected int computeVerticalScrollRange()
  {
    int i1 = this.jdField_f_of_type_Int;
    int i3 = (this.aB + i1 - 1) / i1;
    int i2 = Math.max(i3 * 100, 0);
    i1 = i2;
    if (this.mScrollY != 0)
    {
      float f1 = this.mScrollY / getHeight();
      i1 = i2 + Math.abs((int)(i3 * f1 * 100.0F));
    }
    return i1;
  }
  
  void d(int paramInt)
  {
    int i2 = this.az;
    if (this.jdField_a_of_type_Hvd != null) {
      this.jdField_a_of_type_Hvd.a();
    }
    f(paramInt);
    i();
    if (this.jdField_h_of_type_Boolean) {}
    for (paramInt = this.aB - 1 - this.az;; paramInt = this.az)
    {
      int i1 = i2;
      if (this.jdField_h_of_type_Boolean) {
        i1 = this.aB - 1 - i2;
      }
      if (paramInt / this.jdField_f_of_type_Int != i1 / this.jdField_f_of_type_Int) {
        awakenScrollBars();
      }
      return;
    }
  }
  
  boolean d(int paramInt)
  {
    boolean bool = true;
    if (paramInt == 33)
    {
      this.P = 2;
      d(0);
      f();
    }
    for (;;)
    {
      if (bool) {
        awakenScrollBars();
      }
      return bool;
      if (paramInt == 130)
      {
        this.P = 2;
        d(this.aB - 1);
        f();
      }
      else
      {
        bool = false;
      }
    }
  }
  
  boolean e(int paramInt)
  {
    boolean bool = true;
    int i3 = this.aA;
    int i4 = this.jdField_f_of_type_Int;
    int i2;
    int i1;
    if (!this.jdField_h_of_type_Boolean)
    {
      i2 = i3 / i4 * i4;
      i1 = Math.min(i2 + i4 - 1, this.aB - 1);
      switch (paramInt)
      {
      default: 
        label92:
        bool = false;
      }
    }
    for (;;)
    {
      if (bool)
      {
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
        f();
      }
      if (bool) {
        awakenScrollBars();
      }
      return bool;
      i1 = this.aB;
      i1 = this.aB - 1 - (i1 - 1 - i3) / i4 * i4;
      i2 = Math.max(0, i1 - i4 + 1);
      break;
      if (i2 <= 0) {
        break label92;
      }
      this.P = 6;
      d(Math.max(0, i3 - i4));
      continue;
      if (i1 >= this.aB - 1) {
        break label92;
      }
      this.P = 6;
      d(Math.min(i3 + i4, this.aB - 1));
      continue;
      if (i3 <= i2) {
        break label92;
      }
      this.P = 6;
      d(Math.max(0, i3 - 1));
      continue;
      if (i3 >= i1) {
        break label92;
      }
      this.P = 6;
      d(Math.min(i3 + 1, this.aB - 1));
    }
  }
  
  boolean f(int paramInt)
  {
    boolean bool2 = true;
    int i1 = 0;
    int i4 = this.aA;
    int i6 = this.jdField_f_of_type_Int;
    int i5 = this.aB;
    int i3;
    int i2;
    label80:
    boolean bool1;
    if (!this.jdField_h_of_type_Boolean)
    {
      i3 = i4 / i6 * i6;
      i2 = Math.min(i3 + i6 - 1, i5 - 1);
      switch (paramInt)
      {
      default: 
        bool1 = false;
      }
    }
    for (;;)
    {
      if (bool1)
      {
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
        f();
      }
      if (i1 != 0) {
        awakenScrollBars();
      }
      return bool1;
      i2 = i5 - 1 - (i5 - 1 - i4) / i6 * i6;
      i3 = Math.max(0, i2 - i6 + 1);
      break;
      if (i4 >= i5 - 1) {
        break label80;
      }
      this.P = 6;
      d(i4 + 1);
      bool1 = bool2;
      if (i4 == i2)
      {
        i1 = 1;
        bool1 = bool2;
        continue;
        if (i4 <= 0) {
          break label80;
        }
        this.P = 6;
        d(i4 - 1);
        bool1 = bool2;
        if (i4 == i3)
        {
          i1 = 1;
          bool1 = bool2;
        }
      }
    }
  }
  
  protected void i()
  {
    hve localhve = null;
    int i4 = -1;
    boolean bool1 = this.q;
    if (!bool1) {
      this.q = true;
    }
    int i5;
    int i1;
    label159:
    Object localObject4;
    Object localObject3;
    label180:
    label448:
    label474:
    View localView;
    for (;;)
    {
      try
      {
        super.i();
        invalidate();
        if (this.jdField_a_of_type_AndroidWidgetListAdapter == null)
        {
          h();
          f();
          return;
        }
        i2 = this.c.top;
        i5 = this.mBottom - this.mTop - this.c.bottom;
        int i6 = getChildCount();
        boolean bool2;
        switch (this.P)
        {
        case 2: 
          i1 = this.aA - this.ap;
          if ((i1 < 0) || (i1 >= i6)) {
            break label867;
          }
          localObject1 = getChildAt(i1);
          localObject4 = getChildAt(0);
          i1 = 0;
          localObject3 = localObject1;
          localObject1 = localObject4;
          localObject4 = localhve;
          bool2 = this.p;
          if (bool2) {
            p();
          }
          if (this.aB == 0)
          {
            h();
            f();
            return;
            i1 = this.az - this.ap;
            if ((i1 < 0) || (i1 >= i6)) {
              break label873;
            }
            localObject4 = getChildAt(i1);
            localObject1 = null;
            localObject3 = null;
            i1 = 0;
          }
          break;
        case 6: 
          if (this.az < 0) {
            break label873;
          }
          i1 = this.az;
          int i3 = this.aA;
          localObject1 = null;
          localObject3 = null;
          i1 -= i3;
          localObject4 = localhve;
          continue;
          e(this.az);
          int i7 = this.ap;
          localhve = this.jdField_a_of_type_Hve;
          if (bool2)
          {
            i3 = 0;
            if (i3 < i6)
            {
              localhve.a(getChildAt(i3), i7 + i3);
              i3 += 1;
              continue;
            }
          }
          else
          {
            localhve.a(i6, i7);
          }
          detachAllViewsFromParent();
          switch (this.P)
          {
          case 2: 
            label404:
            if (i6 != 0) {
              break label704;
            }
            if (this.jdField_h_of_type_Boolean) {
              break label663;
            }
            i1 = i4;
            if (this.jdField_a_of_type_AndroidWidgetListAdapter != null)
            {
              if (!isInTouchMode()) {
                break label909;
              }
              i1 = i4;
            }
            label436:
            e(i1);
            localObject1 = a(i2);
            localhve.c();
            if (localObject1 == null) {
              break label804;
            }
            a(-1, (View)localObject1);
            this.ae = ((View)localObject1).getTop();
            this.P = 0;
            this.p = false;
            this.jdField_n_of_type_Boolean = false;
            f(this.aA);
            j();
            if (this.aB > 0) {
              x();
            }
            f();
            return;
          }
          break;
        }
      }
      finally
      {
        Object localObject1;
        if (bool1) {
          continue;
        }
        this.q = false;
      }
      if (localObject4 != null)
      {
        localObject1 = a(((View)localObject4).getTop(), i2, i5);
      }
      else
      {
        localObject1 = d(i2, i5);
        continue;
        this.ap = 0;
        localObject1 = a(i2);
        b();
        continue;
        localView = b(this.aB - 1, i5);
        b();
        continue;
        localView = e(this.aA, this.aq);
        continue;
        localView = e(this.as, this.aq);
        continue;
        localView = b(i1, i2, i5);
      }
    }
    label663:
    int i2 = this.aB - 1;
    if (this.jdField_a_of_type_AndroidWidgetListAdapter != null) {
      if (!isInTouchMode()) {
        break label919;
      }
    }
    for (;;)
    {
      e(i1);
      localView = c(i2, i5);
      break label448;
      label704:
      if ((this.aA >= 0) && (this.aA < this.aB))
      {
        i1 = this.aA;
        if (localObject3 == null) {}
        for (;;)
        {
          localView = e(i1, i2);
          break;
          i2 = localObject3.getTop();
        }
      }
      if (this.ap < this.aB)
      {
        i1 = this.ap;
        if (localView == null) {}
        for (;;)
        {
          localView = e(i1, i2);
          break;
          i2 = localView.getTop();
        }
      }
      localView = e(0, i2);
      break label448;
      label804:
      if ((this.ab > 0) && (this.ab < 3))
      {
        localView = getChildAt(this.W - this.ap);
        if (localView == null) {
          break label474;
        }
        a(this.W, localView);
        break label474;
      }
      this.ae = 0;
      this.jdField_b_of_type_AndroidGraphicsRect.setEmpty();
      break label474;
      label867:
      localView = null;
      break label159;
      label873:
      localView = null;
      localObject3 = null;
      i1 = 0;
      localObject4 = localhve;
      break label180;
      break;
      localView = null;
      localObject3 = null;
      i1 = 0;
      localObject4 = localhve;
      break label180;
      break label404;
      label909:
      i1 = 0;
      break label436;
      i1 = -1;
      continue;
      label919:
      i1 = i2;
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    int i1 = -1;
    int i4 = i1;
    Rect localRect;
    int i3;
    int i2;
    if (paramBoolean)
    {
      i4 = i1;
      if (paramRect != null)
      {
        paramRect.offset(this.mScrollX, this.mScrollY);
        localRect = this.jdField_a_of_type_AndroidGraphicsRect;
        i3 = 2147483647;
        int i5 = getChildCount();
        i2 = 0;
        i4 = i1;
        if (i2 < i5) {
          if (b(i2, paramInt)) {}
        }
      }
    }
    for (;;)
    {
      i2 += 1;
      break;
      View localView = getChildAt(i2);
      localView.getDrawingRect(localRect);
      offsetDescendantRectToMyCoords(localView, localRect);
      i4 = a(paramRect, localRect, paramInt);
      if (i4 < i3)
      {
        i3 = i4;
        i1 = i2;
        continue;
        if (i4 >= 0)
        {
          setSelection(this.ap + i4);
          return;
        }
        requestLayout();
        return;
      }
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(GridView.class.getName());
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(GridView.class.getName());
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return b(paramInt, 1, paramKeyEvent);
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    return b(paramInt1, paramInt2, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return b(paramInt, 1, paramKeyEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i6 = View.MeasureSpec.getMode(paramInt1);
    int i4 = View.MeasureSpec.getMode(paramInt2);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    if (i6 == 0) {
      if (this.k > 0)
      {
        paramInt2 = this.k + this.c.left + this.c.right;
        paramInt2 += getVerticalScrollbarWidth();
      }
    }
    for (;;)
    {
      boolean bool = g(paramInt2 - this.c.left - this.c.right);
      int i3 = 0;
      label104:
      int i7;
      if (this.jdField_a_of_type_AndroidWidgetListAdapter == null)
      {
        i1 = 0;
        this.aB = i1;
        i7 = this.aB;
        if (i7 > 0)
        {
          View localView = a(0, this.jdField_a_of_type_ArrayOfBoolean);
          AbsListView.LayoutParams localLayoutParams2 = (AbsListView.LayoutParams)localView.getLayoutParams();
          AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
          if (localLayoutParams2 == null)
          {
            localLayoutParams1 = (AbsListView.LayoutParams)generateDefaultLayoutParams();
            localView.setLayoutParams(localLayoutParams1);
          }
          localLayoutParams1.a = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemViewType(0);
          localLayoutParams1.jdField_b_of_type_Boolean = true;
          i1 = getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), 0, localLayoutParams1.height);
          localView.measure(getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(this.k, 1073741824), 0, localLayoutParams1.width), i1);
          i1 = localView.getMeasuredHeight();
          i3 = i1;
          if (this.jdField_a_of_type_Hve.a(localLayoutParams1.a))
          {
            this.jdField_a_of_type_Hve.a(localView, -1);
            i3 = i1;
          }
        }
        if (i4 != 0) {
          break label518;
        }
      }
      label515:
      label518:
      for (i1 = this.c.top + this.c.bottom + i3 + getVerticalFadingEdgeLength() * 2;; i1 = i2)
      {
        i2 = i1;
        int i8;
        if (i4 == -2147483648)
        {
          i2 = this.c.top;
          i4 = this.c.bottom;
          i8 = this.jdField_f_of_type_Int;
          i2 = i4 + i2;
          i4 = 0;
          label340:
          if (i4 >= i7) {
            break label515;
          }
          int i5 = i2 + i3;
          i2 = i5;
          if (i4 + i8 < i7) {
            i2 = i5 + this.i;
          }
          if (i2 < i1) {
            break label505;
          }
          i2 = i1;
        }
        for (;;)
        {
          i1 = paramInt2;
          if (i6 == -2147483648)
          {
            i1 = paramInt2;
            if (this.m != -1) {
              if (this.m * this.k + (this.m - 1) * this.g + this.c.left + this.c.right <= paramInt2)
              {
                i1 = paramInt2;
                if (!bool) {}
              }
              else
              {
                i1 = paramInt2 | 0x1000000;
              }
            }
          }
          setMeasuredDimension(i1, i2);
          this.V = paramInt1;
          return;
          paramInt2 = this.c.left + this.c.right;
          break;
          i1 = this.jdField_a_of_type_AndroidWidgetListAdapter.getCount();
          break label104;
          label505:
          i4 += i8;
          break label340;
        }
      }
      paramInt2 = i1;
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if ((this.jdField_a_of_type_AndroidWidgetListAdapter != null) && (this.jdField_a_of_type_Huu != null)) {
      this.jdField_a_of_type_AndroidWidgetListAdapter.unregisterDataSetObserver(this.jdField_a_of_type_Huu);
    }
    h();
    this.jdField_a_of_type_Hve.b();
    this.jdField_a_of_type_AndroidWidgetListAdapter = paramListAdapter;
    this.aE = -1;
    this.jdField_f_of_type_Long = -9223372036854775808L;
    super.setAdapter(paramListAdapter);
    int i1;
    if (this.jdField_a_of_type_AndroidWidgetListAdapter != null)
    {
      this.aC = this.aB;
      this.aB = this.jdField_a_of_type_AndroidWidgetListAdapter.getCount();
      this.p = true;
      w();
      this.jdField_a_of_type_Huu = new huu(this);
      this.jdField_a_of_type_AndroidWidgetListAdapter.registerDataSetObserver(this.jdField_a_of_type_Huu);
      this.jdField_a_of_type_Hve.a(this.jdField_a_of_type_AndroidWidgetListAdapter.getViewTypeCount());
      if (this.jdField_h_of_type_Boolean)
      {
        i1 = a(this.aB - 1, false);
        e(i1);
        f(i1);
        x();
      }
    }
    for (;;)
    {
      requestLayout();
      return;
      i1 = a(0, true);
      break;
      w();
      x();
    }
  }
  
  public void setColumnWidth(int paramInt)
  {
    if (paramInt != this.l)
    {
      this.l = paramInt;
      g();
    }
  }
  
  public void setGravity(int paramInt)
  {
    if (this.jdField_n_of_type_Int != paramInt)
    {
      this.jdField_n_of_type_Int = paramInt;
      g();
    }
  }
  
  public void setHorizontalSpacing(int paramInt)
  {
    if (paramInt != this.jdField_h_of_type_Int)
    {
      this.jdField_h_of_type_Int = paramInt;
      g();
    }
  }
  
  public void setNumColumns(int paramInt)
  {
    if (paramInt != this.m)
    {
      this.m = paramInt;
      g();
    }
  }
  
  public void setSelection(int paramInt)
  {
    if (!isInTouchMode()) {
      f(paramInt);
    }
    for (;;)
    {
      this.P = 2;
      if (this.jdField_a_of_type_Hvd != null) {
        this.jdField_a_of_type_Hvd.a();
      }
      requestLayout();
      return;
      this.af = paramInt;
    }
  }
  
  public void setStretchMode(int paramInt)
  {
    if (paramInt != this.j)
    {
      this.j = paramInt;
      g();
    }
  }
  
  public void setVerticalSpacing(int paramInt)
  {
    if (paramInt != this.i)
    {
      this.i = paramInt;
      g();
    }
  }
  
  public int t()
  {
    return this.g;
  }
  
  public int u()
  {
    return this.jdField_h_of_type_Int;
  }
  
  public int v()
  {
    return this.i;
  }
  
  public int w()
  {
    return this.j;
  }
  
  public int x()
  {
    return this.k;
  }
  
  public int y()
  {
    return this.l;
  }
  
  @ViewDebug.ExportedProperty
  public int z()
  {
    return this.jdField_f_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.widget.GridView
 * JD-Core Version:    0.7.0.1
 */