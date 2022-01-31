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
import fgy;
import fhh;
import fhi;

public class GridView
  extends AbsListView
{
  public static final int aE = 0;
  public static final int aF = 1;
  public static final int aG = 2;
  public static final int aH = 3;
  public static final int aI = -1;
  private int jdField_a_of_type_Int = -1;
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private View jdField_a_of_type_AndroidViewView = null;
  private int jdField_b_of_type_Int = 0;
  private View jdField_b_of_type_AndroidViewView = null;
  private int c;
  private int d = 0;
  private int e = 2;
  private int f;
  private int g;
  private int h;
  private int i;
  
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
    this.jdField_i_of_type_Int = 3;
    setEdgeEffectEnabled(false);
    this.aj = 2147483647;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = paramInt1;
    if (paramInt3 > 0) {
      j = paramInt1 + paramInt2;
    }
    return j;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = paramInt1;
    if (paramInt4 + paramInt3 - 1 < this.aA - 1) {
      j = paramInt1 - paramInt2;
    }
    return j;
  }
  
  private View a(int paramInt)
  {
    this.ao = Math.min(this.ao, this.az);
    this.ao = Math.min(this.ao, this.aA - 1);
    if (this.ao < 0) {
      this.ao = 0;
    }
    this.ao -= this.ao % this.jdField_a_of_type_Int;
    return a(this.ao, paramInt);
  }
  
  private View a(int paramInt1, int paramInt2)
  {
    Object localObject = null;
    int j = this.mBottom - this.mTop;
    if ((this.mGroupFlags & 0x22) == 34) {
      j -= this.jdField_c_of_type_AndroidGraphicsRect.bottom;
    }
    for (;;)
    {
      if ((paramInt2 < j) && (paramInt1 < this.aA))
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
        paramInt2 = this.jdField_a_of_type_AndroidViewView.getBottom() + this.d;
        paramInt1 += this.jdField_a_of_type_Int;
        break;
        return localObject;
      }
    }
  }
  
  private View a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = getVerticalFadingEdgeLength();
    int k = this.az;
    int m = this.jdField_a_of_type_Int;
    int n = this.d;
    int j = -1;
    int i2;
    if (!this.jdField_i_of_type_Boolean)
    {
      k -= k % m;
      i2 = a(paramInt2, i1, k);
      paramInt3 = a(paramInt3, i1, m, k);
      if (!this.jdField_i_of_type_Boolean) {
        break label210;
      }
    }
    View localView1;
    View localView2;
    label210:
    for (paramInt2 = j;; paramInt2 = k)
    {
      localView1 = a(paramInt2, paramInt1, true);
      this.ao = k;
      localView2 = this.jdField_a_of_type_AndroidViewView;
      b(localView2, i2, paramInt3);
      a(localView2, i2, paramInt3);
      if (this.jdField_i_of_type_Boolean) {
        break label216;
      }
      b(k - m, localView2.getTop() - n);
      b();
      a(k + m, localView2.getBottom() + n);
      return localView1;
      j = this.aA - 1 - k;
      j = this.aA - 1 - (j - j % m);
      k = Math.max(0, j - m + 1);
      break;
    }
    label216:
    a(j + m, localView2.getBottom() + n);
    b();
    b(k - 1, localView2.getTop() - n);
    return localView1;
  }
  
  private View a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i2 = this.jdField_f_of_type_Int;
    int i1 = this.jdField_b_of_type_Int;
    int k = this.jdField_c_of_type_AndroidGraphicsRect.left;
    int j;
    int m;
    if (this.e == 3)
    {
      j = i1;
      k = j + k;
      if (this.jdField_i_of_type_Boolean) {
        break label191;
      }
      m = Math.min(this.jdField_a_of_type_Int + paramInt1, this.aA);
      j = paramInt1;
      paramInt1 = m;
    }
    for (;;)
    {
      label68:
      Object localObject = null;
      boolean bool2 = j();
      boolean bool3 = i();
      int i3 = this.az;
      View localView = null;
      m = j;
      label96:
      boolean bool1;
      label112:
      int n;
      if (m < paramInt1) {
        if (m == i3)
        {
          bool1 = true;
          if (!paramBoolean) {
            break label259;
          }
          n = -1;
          label119:
          localView = a(m, paramInt2, paramBoolean, k, bool1, n);
          k += i2;
          if (m >= paramInt1 - 1) {
            break label294;
          }
          k += i1;
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
          m += 1;
          break label96;
          j = 0;
          break;
          label191:
          j = paramInt1 + 1;
          m = Math.max(0, paramInt1 - this.jdField_a_of_type_Int + 1);
          if (j - m >= this.jdField_a_of_type_Int) {
            break label297;
          }
          k += (this.jdField_a_of_type_Int - (j - m)) * (i2 + i1);
          paramInt1 = j;
          j = m;
          break label68;
          bool1 = false;
          break label112;
          n = m - j;
          break label119;
          this.jdField_a_of_type_AndroidViewView = localView;
          if (localObject != null) {
            this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView;
          }
          return localObject;
        }
      }
      label297:
      paramInt1 = j;
      j = m;
    }
  }
  
  private View a(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, int paramInt4)
  {
    if (!this.q)
    {
      localView = this.jdField_a_of_type_Fhi.a(paramInt1);
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
    int k;
    label27:
    int j;
    boolean bool;
    label55:
    int m;
    label67:
    label87:
    AbsListView.LayoutParams localLayoutParams;
    if ((paramBoolean2) && (j()))
    {
      paramBoolean2 = true;
      if (paramBoolean2 == paramView.isSelected()) {
        break label400;
      }
      k = 1;
      j = this.ab;
      if ((j <= 0) || (j >= 3) || (this.W != paramInt1)) {
        break label406;
      }
      bool = true;
      if (bool == paramView.isPressed()) {
        break label412;
      }
      m = 1;
      if ((paramBoolean3) && (k == 0) && (!paramView.isLayoutRequested())) {
        break label418;
      }
      j = 1;
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
      localLayoutParams.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemViewType(paramInt1);
      if ((paramBoolean3) && (!localLayoutParams.jdField_b_of_type_Boolean))
      {
        attachViewToParent(paramView, paramInt4, localLayoutParams);
        if (k != 0)
        {
          paramView.setSelected(paramBoolean2);
          if (paramBoolean2) {
            requestFocus();
          }
        }
        if (m != 0) {
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
        if (j == 0) {
          break label474;
        }
        paramInt4 = ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), 0, localLayoutParams.height);
        paramView.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(this.jdField_f_of_type_Int, 1073741824), 0, localLayoutParams.width), paramInt4);
        k = paramView.getMeasuredWidth();
        m = paramView.getMeasuredHeight();
        if (!paramBoolean1) {
          break label482;
        }
        paramInt4 = paramInt2;
        paramInt2 = paramInt3;
        switch (this.jdField_i_of_type_Int & 0x7)
        {
        default: 
          paramInt2 = paramInt3;
        case 2: 
        case 3: 
        case 4: 
          label331:
          if (j != 0) {
            paramView.layout(paramInt2, paramInt4, k + paramInt2, m + paramInt4);
          }
          break;
        }
      }
      for (;;)
      {
        if (this.jdField_g_of_type_Boolean) {
          paramView.setDrawingCacheEnabled(true);
        }
        if ((VersionUtils.e()) && (paramBoolean3) && (((AbsListView.LayoutParams)paramView.getLayoutParams()).jdField_b_of_type_Int != paramInt1)) {
          paramView.jumpDrawablesToCurrentState();
        }
        return;
        paramBoolean2 = false;
        break;
        k = 0;
        break label27;
        bool = false;
        break label55;
        m = 0;
        break label67;
        label418:
        j = 0;
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
        paramInt4 = paramInt2 - m;
        break label283;
        paramInt2 = paramInt3 + (this.jdField_f_of_type_Int - k) / 2;
        break label331;
        paramInt2 = this.jdField_f_of_type_Int + paramInt3 - k;
        break label331;
        paramView.offsetLeftAndRight(paramInt2 - paramView.getLeft());
        paramView.offsetTopAndBottom(paramInt4 - paramView.getTop());
      }
    }
  }
  
  private View b(int paramInt1, int paramInt2)
  {
    Object localObject = null;
    int j;
    if ((this.mGroupFlags & 0x22) == 34) {
      j = this.jdField_c_of_type_AndroidGraphicsRect.top;
    }
    for (;;)
    {
      if ((paramInt2 > j) && (paramInt1 >= 0))
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
        paramInt2 = this.jdField_a_of_type_AndroidViewView.getTop() - this.d;
        this.ao = paramInt1;
        paramInt1 -= this.jdField_a_of_type_Int;
        break;
        if (this.jdField_i_of_type_Boolean) {
          this.ao = Math.max(0, paramInt1 + 1);
        }
        return localObject;
      }
      j = 0;
    }
  }
  
  private View b(int paramInt1, int paramInt2, int paramInt3)
  {
    int m = 0;
    int i3 = getVerticalFadingEdgeLength();
    int i4 = this.az;
    int i1 = this.jdField_a_of_type_Int;
    int i2 = this.d;
    int n = -1;
    int k;
    int j;
    if (!this.jdField_i_of_type_Boolean)
    {
      k = i4 - paramInt1 - (i4 - paramInt1) % i1;
      j = i4 - i4 % i1;
      paramInt1 = n;
      i4 = j - k;
      k = a(paramInt2, i3, j);
      n = a(paramInt3, i3, i1, j);
      this.ao = j;
      if (i4 <= 0) {
        break label306;
      }
      if (this.jdField_b_of_type_AndroidViewView != null) {
        break label289;
      }
      paramInt2 = 0;
      label115:
      if (!this.jdField_i_of_type_Boolean) {
        break label300;
      }
    }
    View localView2;
    View localView1;
    label289:
    label300:
    for (paramInt3 = paramInt1;; paramInt3 = j)
    {
      localView2 = a(paramInt3, paramInt2 + i2, true);
      localView1 = this.jdField_a_of_type_AndroidViewView;
      a(localView1, k, n);
      if (this.jdField_i_of_type_Boolean) {
        break label431;
      }
      b(j - i1, localView1.getTop() - i2);
      b();
      a(j + i1, localView1.getBottom() + i2);
      return localView2;
      j = this.aA - 1 - i4;
      k = this.aA - 1 - (j - j % i1);
      j = Math.max(0, k - i1 + 1);
      paramInt1 = this.aA - 1 - (i4 - paramInt1);
      n = Math.max(0, this.aA - 1 - (paramInt1 - paramInt1 % i1) - i1 + 1);
      paramInt1 = k;
      k = n;
      break;
      paramInt2 = this.jdField_b_of_type_AndroidViewView.getBottom();
      break label115;
    }
    label306:
    if (i4 < 0)
    {
      if (this.jdField_b_of_type_AndroidViewView == null)
      {
        paramInt2 = 0;
        label320:
        if (!this.jdField_i_of_type_Boolean) {
          break label371;
        }
      }
      label371:
      for (paramInt3 = paramInt1;; paramInt3 = j)
      {
        localView2 = a(paramInt3, paramInt2 - i2, false);
        localView1 = this.jdField_a_of_type_AndroidViewView;
        b(localView1, k, n);
        break;
        paramInt2 = this.jdField_b_of_type_AndroidViewView.getTop();
        break label320;
      }
    }
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      paramInt2 = m;
      label387:
      if (!this.jdField_i_of_type_Boolean) {
        break label425;
      }
    }
    label425:
    for (paramInt3 = paramInt1;; paramInt3 = j)
    {
      localView2 = a(paramInt3, paramInt2, true);
      localView1 = this.jdField_a_of_type_AndroidViewView;
      break;
      paramInt2 = this.jdField_b_of_type_AndroidViewView.getTop();
      break label387;
    }
    label431:
    a(paramInt1 + i1, localView1.getBottom() + i2);
    b();
    b(j - 1, localView1.getTop() - i2);
    return localView2;
  }
  
  private void b()
  {
    int m = 0;
    int n = getChildCount();
    int k;
    int j;
    if (n > 0)
    {
      if (this.jdField_i_of_type_Boolean) {
        break label72;
      }
      k = getChildAt(0).getTop() - this.jdField_c_of_type_AndroidGraphicsRect.top;
      j = k;
      if (this.ao != 0) {
        j = k - this.d;
      }
      k = j;
      if (j >= 0) {
        break label128;
      }
      k = m;
    }
    label128:
    for (;;)
    {
      if (k != 0) {
        offsetChildrenTopAndBottom(-k);
      }
      return;
      label72:
      k = getChildAt(n - 1).getBottom() - (getHeight() - this.jdField_c_of_type_AndroidGraphicsRect.bottom);
      j = k;
      if (n + this.ao < this.aA) {
        j = k + this.d;
      }
      k = m;
      if (j <= 0) {
        k = j;
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.ao + paramInt3 - 1 == this.aA - 1) && (paramInt3 > 0))
    {
      paramInt3 = getChildAt(paramInt3 - 1).getBottom();
      int j = this.mBottom - this.mTop - this.jdField_c_of_type_AndroidGraphicsRect.bottom - paramInt3;
      View localView = getChildAt(0);
      int k = localView.getTop();
      if ((j > 0) && ((this.ao > 0) || (k < this.jdField_c_of_type_AndroidGraphicsRect.top)))
      {
        paramInt3 = j;
        if (this.ao == 0) {
          paramInt3 = Math.min(j, this.jdField_c_of_type_AndroidGraphicsRect.top - k);
        }
        offsetChildrenTopAndBottom(paramInt3);
        if (this.ao > 0)
        {
          paramInt3 = this.ao;
          if (this.jdField_i_of_type_Boolean) {
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
    int m = getChildCount();
    int j = m - 1 - paramInt1;
    int k;
    if (!this.jdField_i_of_type_Boolean)
    {
      k = paramInt1 - paramInt1 % this.jdField_a_of_type_Int;
      j = Math.max(this.jdField_a_of_type_Int + k - 1, m);
    }
    for (;;)
    {
      switch (paramInt2)
      {
      default: 
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
        j = m - 1 - (j - j % this.jdField_a_of_type_Int);
        k = Math.max(0, j - this.jdField_a_of_type_Int + 1);
      }
    }
    if (paramInt1 == k) {}
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
            } while (k == 0);
            return false;
          } while (paramInt1 == j);
          return false;
        } while (j == m - 1);
        return false;
      } while ((paramInt1 == k) && (k == 0));
      return false;
    } while ((paramInt1 == j) && (j == m - 1));
    return false;
  }
  
  @TargetApi(11)
  private boolean b(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_AndroidWidgetListAdapter == null) {
      return false;
    }
    if (this.q) {
      i();
    }
    int j = paramKeyEvent.getAction();
    if (j != 1) {}
    int k;
    switch (paramInt1)
    {
    default: 
      k = 0;
    }
    for (;;)
    {
      if (k == 0) {
        break label804;
      }
      return true;
      if ((!VersionUtils.e()) || (!paramKeyEvent.hasNoModifiers())) {
        break;
      }
      if ((k()) || (e(17)))
      {
        k = 1;
      }
      else
      {
        k = 0;
        continue;
        if ((!VersionUtils.e()) || (!paramKeyEvent.hasNoModifiers())) {
          break;
        }
        if ((k()) || (e(66)))
        {
          k = 1;
        }
        else
        {
          k = 0;
          continue;
          if ((VersionUtils.e()) && (paramKeyEvent.hasNoModifiers()))
          {
            if ((k()) || (e(33))) {
              k = 1;
            } else {
              k = 0;
            }
          }
          else
          {
            if ((!VersionUtils.e()) || (!paramKeyEvent.hasModifiers(2))) {
              break;
            }
            if ((k()) || (d(33)))
            {
              k = 1;
            }
            else
            {
              k = 0;
              continue;
              if ((VersionUtils.e()) && (paramKeyEvent.hasNoModifiers()))
              {
                if ((k()) || (e(130))) {
                  k = 1;
                } else {
                  k = 0;
                }
              }
              else
              {
                if ((!VersionUtils.e()) || (!paramKeyEvent.hasModifiers(2))) {
                  break;
                }
                if ((k()) || (d(130)))
                {
                  k = 1;
                }
                else
                {
                  k = 0;
                  continue;
                  if ((!VersionUtils.e()) || (!paramKeyEvent.hasNoModifiers())) {
                    break;
                  }
                  boolean bool = k();
                  k = bool;
                  if (!bool)
                  {
                    k = bool;
                    if (paramKeyEvent.getRepeatCount() == 0)
                    {
                      k = bool;
                      if (getChildCount() > 0)
                      {
                        k();
                        k = 1;
                        continue;
                        if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
                          break;
                        }
                        if ((VersionUtils.e()) && (paramKeyEvent.hasNoModifiers()))
                        {
                          if ((k()) || (c(130))) {
                            k = 1;
                          } else {
                            k = 0;
                          }
                        }
                        else
                        {
                          if ((!VersionUtils.e()) || (!paramKeyEvent.hasModifiers(1))) {
                            break;
                          }
                          if ((k()) || (c(33)))
                          {
                            k = 1;
                          }
                          else
                          {
                            k = 0;
                            continue;
                            if ((VersionUtils.e()) && (paramKeyEvent.hasNoModifiers()))
                            {
                              if ((k()) || (c(33))) {
                                k = 1;
                              } else {
                                k = 0;
                              }
                            }
                            else
                            {
                              if ((!VersionUtils.e()) || (!paramKeyEvent.hasModifiers(2))) {
                                break;
                              }
                              if ((k()) || (d(33)))
                              {
                                k = 1;
                              }
                              else
                              {
                                k = 0;
                                continue;
                                if ((VersionUtils.e()) && (paramKeyEvent.hasNoModifiers()))
                                {
                                  if ((k()) || (c(130))) {
                                    k = 1;
                                  } else {
                                    k = 0;
                                  }
                                }
                                else
                                {
                                  if ((!VersionUtils.e()) || (!paramKeyEvent.hasModifiers(2))) {
                                    break;
                                  }
                                  if ((k()) || (d(130)))
                                  {
                                    k = 1;
                                  }
                                  else
                                  {
                                    k = 0;
                                    continue;
                                    if ((!VersionUtils.e()) || (!paramKeyEvent.hasNoModifiers())) {
                                      break;
                                    }
                                    if ((k()) || (d(33)))
                                    {
                                      k = 1;
                                    }
                                    else
                                    {
                                      k = 0;
                                      continue;
                                      if ((!VersionUtils.e()) || (!paramKeyEvent.hasNoModifiers())) {
                                        break;
                                      }
                                      if ((k()) || (d(130))) {
                                        k = 1;
                                      } else {
                                        k = 0;
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
    switch (j)
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
    paramInt1 = Math.min(Math.max(paramInt1, this.az), this.aA - 1);
    paramInt1 = this.aA - 1 - paramInt1;
    return b(this.aA - 1 - (paramInt1 - paramInt1 % this.jdField_a_of_type_Int), paramInt2);
  }
  
  private void c(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.ao == 0) && (paramInt3 > 0))
    {
      int j = getChildAt(0).getTop();
      int m = this.jdField_c_of_type_AndroidGraphicsRect.top;
      int k = this.mBottom - this.mTop - this.jdField_c_of_type_AndroidGraphicsRect.bottom;
      j -= m;
      View localView = getChildAt(paramInt3 - 1);
      int n = localView.getBottom();
      m = this.ao + paramInt3 - 1;
      if ((j > 0) && ((m < this.aA - 1) || (n > k)))
      {
        paramInt3 = j;
        if (m == this.aA - 1) {
          paramInt3 = Math.min(j, n - k);
        }
        offsetChildrenTopAndBottom(-paramInt3);
        if (m < this.aA - 1)
        {
          if (!this.jdField_i_of_type_Boolean) {
            paramInt1 = 1;
          }
          a(m + paramInt1, localView.getBottom() + paramInt2);
          b();
        }
      }
    }
  }
  
  private View d(int paramInt1, int paramInt2)
  {
    int k = m();
    int n = this.jdField_a_of_type_Int;
    int i1 = this.d;
    int j = -1;
    int i2;
    int i3;
    if (!this.jdField_i_of_type_Boolean)
    {
      k -= k % n;
      i2 = getVerticalFadingEdgeLength();
      i3 = a(paramInt1, i2, k);
      if (!this.jdField_i_of_type_Boolean) {
        break label181;
      }
    }
    View localView1;
    View localView2;
    label181:
    for (int m = j;; m = k)
    {
      localView1 = a(m, i3, true);
      this.ao = k;
      localView2 = this.jdField_a_of_type_AndroidViewView;
      if (this.jdField_i_of_type_Boolean) {
        break label188;
      }
      a(k + n, localView2.getBottom() + i1);
      h(paramInt2);
      b(k - n, localView2.getTop() - i1);
      b();
      return localView1;
      j = this.aA - 1 - k;
      j = this.aA - 1 - (j - j % n);
      k = Math.max(0, j - n + 1);
      break;
    }
    label188:
    offsetChildrenTopAndBottom(a(paramInt2, i2, n, k) - localView2.getBottom());
    b(k - 1, localView2.getTop() - i1);
    g(paramInt1);
    a(j + n, localView2.getBottom() + i1);
    b();
    return localView1;
  }
  
  private View e(int paramInt1, int paramInt2)
  {
    int m = this.jdField_a_of_type_Int;
    int k = -1;
    int j;
    label36:
    View localView3;
    Object localObject1;
    Object localObject2;
    if (!this.jdField_i_of_type_Boolean)
    {
      j = paramInt1 - paramInt1 % m;
      paramInt1 = k;
      if (!this.jdField_i_of_type_Boolean) {
        break label105;
      }
      k = paramInt1;
      localView3 = a(k, paramInt2, true);
      this.ao = j;
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
      paramInt1 = this.aA - 1 - paramInt1;
      paramInt1 = this.aA - 1 - (paramInt1 - paramInt1 % m);
      j = Math.max(0, paramInt1 - m + 1);
      break;
      k = j;
      break label36;
      paramInt2 = this.d;
      if (!this.jdField_i_of_type_Boolean)
      {
        localObject2 = b(j - m, ((View)localObject1).getTop() - paramInt2);
        b();
        View localView2 = a(j + m, ((View)localObject1).getBottom() + paramInt2);
        paramInt1 = getChildCount();
        localObject1 = localObject2;
        localView1 = localView2;
        if (paramInt1 > 0)
        {
          b(m, paramInt2, paramInt1);
          localView1 = localView2;
          localObject1 = localObject2;
        }
      }
      while (localView3 != null)
      {
        return localView3;
        localView1 = a(paramInt1 + m, ((View)localObject1).getBottom() + paramInt2);
        b();
        localObject1 = b(j - 1, ((View)localObject1).getTop() - paramInt2);
        paramInt1 = getChildCount();
        if (paramInt1 > 0) {
          c(m, paramInt2, paramInt1);
        }
      }
      localObject2 = localObject1;
    } while (localObject1 != null);
    return localView1;
  }
  
  private void g(int paramInt)
  {
    if (this.ao == 0)
    {
      paramInt -= getChildAt(0).getTop();
      if (paramInt < 0) {
        offsetChildrenTopAndBottom(paramInt);
      }
    }
  }
  
  private boolean g(int paramInt)
  {
    int j = this.jdField_c_of_type_Int;
    int k = this.e;
    int m = this.jdField_g_of_type_Int;
    boolean bool = false;
    if (this.h == -1) {
      if (m > 0) {
        this.jdField_a_of_type_Int = ((paramInt + j) / (m + j));
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int <= 0) {
        this.jdField_a_of_type_Int = 1;
      }
      switch (k)
      {
      default: 
        paramInt = paramInt - this.jdField_a_of_type_Int * m - (this.jdField_a_of_type_Int - 1) * j;
        if (paramInt < 0) {
          bool = true;
        }
        switch (k)
        {
        default: 
          return bool;
          this.jdField_a_of_type_Int = 2;
          continue;
          this.jdField_a_of_type_Int = this.h;
        }
        break;
      }
    }
    this.jdField_f_of_type_Int = m;
    this.jdField_b_of_type_Int = j;
    return false;
    this.jdField_f_of_type_Int = (paramInt / this.jdField_a_of_type_Int + m);
    this.jdField_b_of_type_Int = j;
    return bool;
    this.jdField_f_of_type_Int = m;
    if (this.jdField_a_of_type_Int > 1)
    {
      this.jdField_b_of_type_Int = (paramInt / (this.jdField_a_of_type_Int - 1) + j);
      return bool;
    }
    this.jdField_b_of_type_Int = (j + paramInt);
    return bool;
    this.jdField_f_of_type_Int = m;
    if (this.jdField_a_of_type_Int > 1)
    {
      this.jdField_b_of_type_Int = (paramInt / (this.jdField_a_of_type_Int + 1) + j);
      return bool;
    }
    this.jdField_b_of_type_Int = (j + paramInt);
    return bool;
  }
  
  private void h(int paramInt)
  {
    int j = getChildCount();
    if (this.ao + j == this.aA)
    {
      paramInt -= getChildAt(j - 1).getBottom();
      if (paramInt > 0) {
        offsetChildrenTopAndBottom(paramInt);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_i_of_type_Int;
  }
  
  int a(int paramInt)
  {
    int m = getChildCount();
    if (m > 0)
    {
      int k = this.jdField_a_of_type_Int;
      if (!this.jdField_i_of_type_Boolean)
      {
        j = 0;
        while (j < m)
        {
          if (paramInt <= getChildAt(j).getBottom()) {
            return j + this.ao;
          }
          j += k;
        }
      }
      int j = m - 1;
      while (j >= 0)
      {
        if (paramInt >= getChildAt(j).getTop()) {
          return j + this.ao;
        }
        j -= k;
      }
    }
    return -1;
  }
  
  int a(int paramInt, boolean paramBoolean)
  {
    int j;
    if ((this.jdField_a_of_type_AndroidWidgetListAdapter == null) || (isInTouchMode())) {
      j = -1;
    }
    do
    {
      return j;
      if (paramInt < 0) {
        break;
      }
      j = paramInt;
    } while (paramInt < this.aA);
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
    paramView.columnsCount = this.jdField_a_of_type_Int;
    paramView.rowsCount = (paramInt2 / this.jdField_a_of_type_Int);
    if (!this.jdField_i_of_type_Boolean)
    {
      paramView.column = (paramInt1 % this.jdField_a_of_type_Int);
      paramView.row = (paramInt1 / this.jdField_a_of_type_Int);
      return;
    }
    paramInt1 = paramInt2 - 1 - paramInt1;
    paramView.column = (this.jdField_a_of_type_Int - 1 - paramInt1 % this.jdField_a_of_type_Int);
    paramView.row = (paramView.rowsCount - 1 - paramInt1 / this.jdField_a_of_type_Int);
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
  }
  
  void b(boolean paramBoolean)
  {
    int n = this.jdField_a_of_type_Int;
    int i1 = this.d;
    int k = getChildCount();
    if (paramBoolean) {
      if ((this.mGroupFlags & 0x22) != 34) {
        break label194;
      }
    }
    label182:
    label194:
    for (int j = f();; j = 0)
    {
      if (k > 0) {
        j = getChildAt(k - 1).getBottom() + i1;
      }
      int m = this.ao + k;
      k = m;
      if (this.jdField_i_of_type_Boolean) {
        k = m + (n - 1);
      }
      a(k, j);
      b(n, i1, getChildCount());
      return;
      if ((this.mGroupFlags & 0x22) == 34) {}
      for (j = g();; j = 0)
      {
        if (k > 0)
        {
          j = getChildAt(0).getTop() - i1;
          k = this.ao;
          if (this.jdField_i_of_type_Boolean) {
            break label182;
          }
          k -= n;
        }
        for (;;)
        {
          b(k, j);
          c(n, i1, getChildCount());
          return;
          j = getHeight() - j;
          break;
          k -= 1;
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
    int j = -1;
    if (paramInt == 33) {
      j = Math.max(0, this.az - getChildCount());
    }
    for (;;)
    {
      if (j >= 0)
      {
        d(j);
        f();
        awakenScrollBars();
        bool = true;
      }
      return bool;
      if (paramInt == 130) {
        j = Math.min(this.aA - 1, this.az + getChildCount());
      }
    }
  }
  
  protected int computeVerticalScrollExtent()
  {
    int m = getChildCount();
    if (m > 0)
    {
      int j = this.jdField_a_of_type_Int;
      int k = (m + j - 1) / j * 100;
      View localView = getChildAt(0);
      int n = localView.getTop();
      int i1 = localView.getHeight();
      j = k;
      if (i1 > 0) {
        j = k + n * 100 / i1;
      }
      localView = getChildAt(m - 1);
      m = localView.getBottom();
      n = localView.getHeight();
      k = j;
      if (n > 0) {
        k = j - (m - getHeight()) * 100 / n;
      }
      return k;
    }
    return 0;
  }
  
  protected int computeVerticalScrollOffset()
  {
    int k = 0;
    int j = k;
    if (this.ao >= 0)
    {
      j = k;
      if (getChildCount() > 0)
      {
        View localView = getChildAt(0);
        int m = localView.getTop();
        int n = localView.getHeight();
        j = k;
        if (n > 0)
        {
          k = this.jdField_a_of_type_Int;
          j = this.ao / k;
          k = (this.aA + k - 1) / k;
          j = Math.max(j * 100 - m * 100 / n + (int)(this.mScrollY / getHeight() * k * 100.0F), 0);
        }
      }
    }
    return j;
  }
  
  protected int computeVerticalScrollRange()
  {
    int j = this.jdField_a_of_type_Int;
    int m = (this.aA + j - 1) / j;
    int k = Math.max(m * 100, 0);
    j = k;
    if (this.mScrollY != 0)
    {
      float f1 = this.mScrollY / getHeight();
      j = k + Math.abs((int)(m * f1 * 100.0F));
    }
    return j;
  }
  
  void d(int paramInt)
  {
    int k = this.ay;
    if (this.jdField_a_of_type_Fhh != null) {
      this.jdField_a_of_type_Fhh.a();
    }
    f(paramInt);
    i();
    if (this.jdField_i_of_type_Boolean) {}
    for (paramInt = this.aA - 1 - this.ay;; paramInt = this.ay)
    {
      int j = k;
      if (this.jdField_i_of_type_Boolean) {
        j = this.aA - 1 - k;
      }
      if (paramInt / this.jdField_a_of_type_Int != j / this.jdField_a_of_type_Int) {
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
        d(this.aA - 1);
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
    int m = this.az;
    int n = this.jdField_a_of_type_Int;
    int k;
    int j;
    if (!this.jdField_i_of_type_Boolean)
    {
      k = m / n * n;
      j = Math.min(k + n - 1, this.aA - 1);
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
      j = this.aA;
      j = this.aA - 1 - (j - 1 - m) / n * n;
      k = Math.max(0, j - n + 1);
      break;
      if (k <= 0) {
        break label92;
      }
      this.P = 6;
      d(Math.max(0, m - n));
      continue;
      if (j >= this.aA - 1) {
        break label92;
      }
      this.P = 6;
      d(Math.min(m + n, this.aA - 1));
      continue;
      if (m <= k) {
        break label92;
      }
      this.P = 6;
      d(Math.max(0, m - 1));
      continue;
      if (m >= j) {
        break label92;
      }
      this.P = 6;
      d(Math.min(m + 1, this.aA - 1));
    }
  }
  
  boolean f(int paramInt)
  {
    boolean bool2 = true;
    int j = 0;
    int n = this.az;
    int i2 = this.jdField_a_of_type_Int;
    int i1 = this.aA;
    int m;
    int k;
    label80:
    boolean bool1;
    if (!this.jdField_i_of_type_Boolean)
    {
      m = n / i2 * i2;
      k = Math.min(m + i2 - 1, i1 - 1);
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
      if (j != 0) {
        awakenScrollBars();
      }
      return bool1;
      k = i1 - 1 - (i1 - 1 - n) / i2 * i2;
      m = Math.max(0, k - i2 + 1);
      break;
      if (n >= i1 - 1) {
        break label80;
      }
      this.P = 6;
      d(n + 1);
      bool1 = bool2;
      if (n == k)
      {
        j = 1;
        bool1 = bool2;
        continue;
        if (n <= 0) {
          break label80;
        }
        this.P = 6;
        d(n - 1);
        bool1 = bool2;
        if (n == m)
        {
          j = 1;
          bool1 = bool2;
        }
      }
    }
  }
  
  protected void i()
  {
    fhi localfhi = null;
    int n = -1;
    boolean bool1 = this.r;
    if (!bool1) {
      this.r = true;
    }
    int i1;
    int j;
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
        k = this.jdField_c_of_type_AndroidGraphicsRect.top;
        i1 = this.mBottom - this.mTop - this.jdField_c_of_type_AndroidGraphicsRect.bottom;
        int i2 = getChildCount();
        boolean bool2;
        switch (this.P)
        {
        case 2: 
          j = this.az - this.ao;
          if ((j < 0) || (j >= i2)) {
            break label867;
          }
          localObject1 = getChildAt(j);
          localObject4 = getChildAt(0);
          j = 0;
          localObject3 = localObject1;
          localObject1 = localObject4;
          localObject4 = localfhi;
          bool2 = this.q;
          if (bool2) {
            p();
          }
          if (this.aA == 0)
          {
            h();
            f();
            return;
            j = this.ay - this.ao;
            if ((j < 0) || (j >= i2)) {
              break label873;
            }
            localObject4 = getChildAt(j);
            localObject1 = null;
            localObject3 = null;
            j = 0;
          }
          break;
        case 6: 
          if (this.ay < 0) {
            break label873;
          }
          j = this.ay;
          int m = this.az;
          localObject1 = null;
          localObject3 = null;
          j -= m;
          localObject4 = localfhi;
          continue;
          e(this.ay);
          int i3 = this.ao;
          localfhi = this.jdField_a_of_type_Fhi;
          if (bool2)
          {
            m = 0;
            if (m < i2)
            {
              localfhi.a(getChildAt(m), i3 + m);
              m += 1;
              continue;
            }
          }
          else
          {
            localfhi.a(i2, i3);
          }
          detachAllViewsFromParent();
          switch (this.P)
          {
          case 2: 
            label404:
            if (i2 != 0) {
              break label704;
            }
            if (this.jdField_i_of_type_Boolean) {
              break label663;
            }
            j = n;
            if (this.jdField_a_of_type_AndroidWidgetListAdapter != null)
            {
              if (!isInTouchMode()) {
                break label909;
              }
              j = n;
            }
            label436:
            e(j);
            localObject1 = a(k);
            localfhi.c();
            if (localObject1 == null) {
              break label804;
            }
            a(-1, (View)localObject1);
            this.ae = ((View)localObject1).getTop();
            this.P = 0;
            this.q = false;
            this.o = false;
            f(this.az);
            j();
            if (this.aA > 0) {
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
        this.r = false;
      }
      if (localObject4 != null)
      {
        localObject1 = a(((View)localObject4).getTop(), k, i1);
      }
      else
      {
        localObject1 = d(k, i1);
        continue;
        this.ao = 0;
        localObject1 = a(k);
        b();
        continue;
        localView = b(this.aA - 1, i1);
        b();
        continue;
        localView = e(this.az, this.ap);
        continue;
        localView = e(this.ar, this.ap);
        continue;
        localView = b(j, k, i1);
      }
    }
    label663:
    int k = this.aA - 1;
    if (this.jdField_a_of_type_AndroidWidgetListAdapter != null) {
      if (!isInTouchMode()) {
        break label919;
      }
    }
    for (;;)
    {
      e(j);
      localView = c(k, i1);
      break label448;
      label704:
      if ((this.az >= 0) && (this.az < this.aA))
      {
        j = this.az;
        if (localObject3 == null) {}
        for (;;)
        {
          localView = e(j, k);
          break;
          k = localObject3.getTop();
        }
      }
      if (this.ao < this.aA)
      {
        j = this.ao;
        if (localView == null) {}
        for (;;)
        {
          localView = e(j, k);
          break;
          k = localView.getTop();
        }
      }
      localView = e(0, k);
      break label448;
      label804:
      if ((this.ab > 0) && (this.ab < 3))
      {
        localView = getChildAt(this.W - this.ao);
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
      j = 0;
      localObject4 = localfhi;
      break label180;
      break;
      localView = null;
      localObject3 = null;
      j = 0;
      localObject4 = localfhi;
      break label180;
      break label404;
      label909:
      j = 0;
      break label436;
      j = -1;
      continue;
      label919:
      j = k;
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    int j = -1;
    int n = j;
    Rect localRect;
    int m;
    int k;
    if (paramBoolean)
    {
      n = j;
      if (paramRect != null)
      {
        paramRect.offset(this.mScrollX, this.mScrollY);
        localRect = this.jdField_a_of_type_AndroidGraphicsRect;
        m = 2147483647;
        int i1 = getChildCount();
        k = 0;
        n = j;
        if (k < i1) {
          if (b(k, paramInt)) {}
        }
      }
    }
    for (;;)
    {
      k += 1;
      break;
      View localView = getChildAt(k);
      localView.getDrawingRect(localRect);
      offsetDescendantRectToMyCoords(localView, localRect);
      n = a(paramRect, localRect, paramInt);
      if (n < m)
      {
        m = n;
        j = k;
        continue;
        if (n >= 0)
        {
          setSelection(this.ao + n);
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
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt2);
    if (i2 == 0) {
      if (this.jdField_f_of_type_Int > 0)
      {
        paramInt2 = this.jdField_f_of_type_Int + this.jdField_c_of_type_AndroidGraphicsRect.left + this.jdField_c_of_type_AndroidGraphicsRect.right;
        paramInt2 += getVerticalScrollbarWidth();
      }
    }
    for (;;)
    {
      boolean bool = g(paramInt2 - this.jdField_c_of_type_AndroidGraphicsRect.left - this.jdField_c_of_type_AndroidGraphicsRect.right);
      int m = 0;
      label104:
      int i3;
      if (this.jdField_a_of_type_AndroidWidgetListAdapter == null)
      {
        j = 0;
        this.aA = j;
        i3 = this.aA;
        if (i3 > 0)
        {
          View localView = a(0, this.jdField_a_of_type_ArrayOfBoolean);
          AbsListView.LayoutParams localLayoutParams2 = (AbsListView.LayoutParams)localView.getLayoutParams();
          AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
          if (localLayoutParams2 == null)
          {
            localLayoutParams1 = (AbsListView.LayoutParams)generateDefaultLayoutParams();
            localView.setLayoutParams(localLayoutParams1);
          }
          localLayoutParams1.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemViewType(0);
          localLayoutParams1.jdField_b_of_type_Boolean = true;
          j = getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), 0, localLayoutParams1.height);
          localView.measure(getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(this.jdField_f_of_type_Int, 1073741824), 0, localLayoutParams1.width), j);
          j = localView.getMeasuredHeight();
          m = j;
          if (this.jdField_a_of_type_Fhi.a(localLayoutParams1.jdField_a_of_type_Int))
          {
            this.jdField_a_of_type_Fhi.a(localView, -1);
            m = j;
          }
        }
        if (n != 0) {
          break label518;
        }
      }
      label515:
      label518:
      for (j = this.jdField_c_of_type_AndroidGraphicsRect.top + this.jdField_c_of_type_AndroidGraphicsRect.bottom + m + getVerticalFadingEdgeLength() * 2;; j = k)
      {
        k = j;
        int i4;
        if (n == -2147483648)
        {
          k = this.jdField_c_of_type_AndroidGraphicsRect.top;
          n = this.jdField_c_of_type_AndroidGraphicsRect.bottom;
          i4 = this.jdField_a_of_type_Int;
          k = n + k;
          n = 0;
          label340:
          if (n >= i3) {
            break label515;
          }
          int i1 = k + m;
          k = i1;
          if (n + i4 < i3) {
            k = i1 + this.d;
          }
          if (k < j) {
            break label505;
          }
          k = j;
        }
        for (;;)
        {
          j = paramInt2;
          if (i2 == -2147483648)
          {
            j = paramInt2;
            if (this.h != -1) {
              if (this.h * this.jdField_f_of_type_Int + (this.h - 1) * this.jdField_b_of_type_Int + this.jdField_c_of_type_AndroidGraphicsRect.left + this.jdField_c_of_type_AndroidGraphicsRect.right <= paramInt2)
              {
                j = paramInt2;
                if (!bool) {}
              }
              else
              {
                j = paramInt2 | 0x1000000;
              }
            }
          }
          setMeasuredDimension(j, k);
          this.V = paramInt1;
          return;
          paramInt2 = this.jdField_c_of_type_AndroidGraphicsRect.left + this.jdField_c_of_type_AndroidGraphicsRect.right;
          break;
          j = this.jdField_a_of_type_AndroidWidgetListAdapter.getCount();
          break label104;
          label505:
          n += i4;
          break label340;
        }
      }
      paramInt2 = j;
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if ((this.jdField_a_of_type_AndroidWidgetListAdapter != null) && (this.jdField_a_of_type_Fgy != null)) {
      this.jdField_a_of_type_AndroidWidgetListAdapter.unregisterDataSetObserver(this.jdField_a_of_type_Fgy);
    }
    h();
    this.jdField_a_of_type_Fhi.b();
    this.jdField_a_of_type_AndroidWidgetListAdapter = paramListAdapter;
    this.aD = -1;
    this.jdField_f_of_type_Long = -9223372036854775808L;
    super.setAdapter(paramListAdapter);
    int j;
    if (this.jdField_a_of_type_AndroidWidgetListAdapter != null)
    {
      this.aB = this.aA;
      this.aA = this.jdField_a_of_type_AndroidWidgetListAdapter.getCount();
      this.q = true;
      w();
      this.jdField_a_of_type_Fgy = new fgy(this);
      this.jdField_a_of_type_AndroidWidgetListAdapter.registerDataSetObserver(this.jdField_a_of_type_Fgy);
      this.jdField_a_of_type_Fhi.a(this.jdField_a_of_type_AndroidWidgetListAdapter.getViewTypeCount());
      if (this.jdField_i_of_type_Boolean)
      {
        j = a(this.aA - 1, false);
        e(j);
        f(j);
        x();
      }
    }
    for (;;)
    {
      requestLayout();
      return;
      j = a(0, true);
      break;
      w();
      x();
    }
  }
  
  public void setColumnWidth(int paramInt)
  {
    if (paramInt != this.jdField_g_of_type_Int)
    {
      this.jdField_g_of_type_Int = paramInt;
      g();
    }
  }
  
  public void setGravity(int paramInt)
  {
    if (this.jdField_i_of_type_Int != paramInt)
    {
      this.jdField_i_of_type_Int = paramInt;
      g();
    }
  }
  
  public void setHorizontalSpacing(int paramInt)
  {
    if (paramInt != this.jdField_c_of_type_Int)
    {
      this.jdField_c_of_type_Int = paramInt;
      g();
    }
  }
  
  public void setNumColumns(int paramInt)
  {
    if (paramInt != this.h)
    {
      this.h = paramInt;
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
      if (this.jdField_a_of_type_Fhh != null) {
        this.jdField_a_of_type_Fhh.a();
      }
      requestLayout();
      return;
      this.af = paramInt;
    }
  }
  
  public void setStretchMode(int paramInt)
  {
    if (paramInt != this.e)
    {
      this.e = paramInt;
      g();
    }
  }
  
  public void setVerticalSpacing(int paramInt)
  {
    if (paramInt != this.d)
    {
      this.d = paramInt;
      g();
    }
  }
  
  public int t()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int u()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int v()
  {
    return this.d;
  }
  
  public int w()
  {
    return this.e;
  }
  
  public int x()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public int y()
  {
    return this.jdField_g_of_type_Int;
  }
  
  @ViewDebug.ExportedProperty
  public int z()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.GridView
 * JD-Core Version:    0.7.0.1
 */