package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RemoteViews.RemoteView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.SkinnableView;
import com.tencent.util.VersionUtils;
import hzp;
import hzz;
import ibb;
import ibc;
import ibd;
import ibe;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

@RemoteViews.RemoteView
public class ListView
  extends AbsListView
  implements SkinnableView
{
  private static final float jdField_a_of_type_Float = 0.33F;
  private static final int jdField_a_of_type_Int = a("ListView_footerDividersEnabled");
  static final int aF = -1;
  public static final int aH = 0;
  public static final int aI = 1;
  public static final int aJ = 2;
  public static final int aK = 3;
  private static final int jdField_b_of_type_Int = a("ListView_headerDividersEnabled");
  private static final int jdField_c_of_type_Int = a("ListView_dividerHeight");
  private static final int jdField_d_of_type_Int = a("ListView_overScrollFooter");
  private static final int jdField_e_of_type_Int = a("ListView_overScrollHeader");
  private static final int jdField_f_of_type_Int = a("ListView_divider");
  private static final int jdField_g_of_type_Int = a("ListView_entries");
  private static final int h = 2;
  private static final int i = 2131230829;
  private static final int j = 350;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener;
  private final ibb jdField_a_of_type_Ibb = new ibb(null);
  private ibc jdField_a_of_type_Ibc;
  private ibe jdField_a_of_type_Ibe;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = null;
  public int aG;
  protected int aL = 0;
  protected int aM = 0;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  Drawable jdField_d_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_d_of_type_Boolean;
  Drawable jdField_e_of_type_AndroidGraphicsDrawableDrawable;
  Drawable jdField_f_of_type_AndroidGraphicsDrawableDrawable;
  private long jdField_g_of_type_Long;
  protected boolean r = false;
  private boolean s = true;
  private boolean t = false;
  private boolean u = false;
  private boolean v = true;
  
  public ListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public ListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new TypedArrayWarpper(paramContext.obtainStyledAttributes(paramAttributeSet, a("ListView"), paramInt, 0));
    CharSequence[] arrayOfCharSequence = paramAttributeSet.a(jdField_g_of_type_Int);
    if (arrayOfCharSequence != null) {
      setAdapter(new ArrayAdapter(paramContext, 17367043, arrayOfCharSequence));
    }
    paramContext = paramAttributeSet.a(jdField_f_of_type_Int);
    if (paramContext != null) {
      setDivider(paramContext);
    }
    paramContext = paramAttributeSet.a(jdField_e_of_type_Int);
    if (paramContext != null) {
      setOverscrollHeader(paramContext);
    }
    paramContext = paramAttributeSet.a(jdField_d_of_type_Int);
    if (paramContext != null) {
      setOverscrollFooter(paramContext);
    }
    paramInt = paramAttributeSet.e(jdField_c_of_type_Int, 0);
    if (paramInt != 0) {
      setDividerHeight(paramInt);
    }
    this.jdField_c_of_type_Boolean = paramAttributeSet.a(jdField_b_of_type_Int, true);
    this.jdField_d_of_type_Boolean = paramAttributeSet.a(jdField_a_of_type_Int, true);
    paramAttributeSet.a();
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int k = paramInt1;
    if (paramInt3 != this.aB - 1) {
      k = paramInt1 - paramInt2;
    }
    return k;
  }
  
  private int a(int paramInt1, View paramView, int paramInt2)
  {
    int k = 0;
    paramView.getDrawingRect(this.jdField_a_of_type_AndroidGraphicsRect);
    offsetDescendantRectToMyCoords(paramView, this.jdField_a_of_type_AndroidGraphicsRect);
    if (paramInt1 == 33)
    {
      paramInt1 = k;
      if (this.jdField_a_of_type_AndroidGraphicsRect.top < this.jdField_c_of_type_AndroidGraphicsRect.top)
      {
        k = this.jdField_c_of_type_AndroidGraphicsRect.top - this.jdField_a_of_type_AndroidGraphicsRect.top;
        paramInt1 = k;
        if (paramInt2 > 0) {
          paramInt1 = k + b();
        }
      }
    }
    do
    {
      int m;
      do
      {
        return paramInt1;
        m = getHeight() - this.jdField_c_of_type_AndroidGraphicsRect.bottom;
        paramInt1 = k;
      } while (this.jdField_a_of_type_AndroidGraphicsRect.bottom <= m);
      k = this.jdField_a_of_type_AndroidGraphicsRect.bottom - m;
      paramInt1 = k;
    } while (paramInt2 >= this.aB - 1);
    return k + b();
  }
  
  private int a(View paramView)
  {
    int m = getChildCount();
    int k = 0;
    while (k < m)
    {
      if (a(paramView, getChildAt(k))) {
        return k + this.ap;
      }
      k += 1;
    }
    throw new IllegalArgumentException("newFocus is not a child of any of the children of the list!");
  }
  
  @TargetApi(11)
  private int a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    int k = paramView.getHeight();
    int m = ((AbsListView.LayoutParams)paramView.getLayoutParams()).jdField_a_of_type_Int;
    int n = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemViewType(paramInt1);
    View localView;
    AbsListView.LayoutParams localLayoutParams;
    if (m == n)
    {
      localView = this.jdField_a_of_type_AndroidWidgetListAdapter.getView(paramInt1, paramView, this);
      localLayoutParams = (AbsListView.LayoutParams)localView.getLayoutParams();
      if (localLayoutParams != null) {
        break label506;
      }
      localLayoutParams = new AbsListView.LayoutParams(-1, -2, 0);
    }
    label221:
    label478:
    label506:
    for (;;)
    {
      localLayoutParams.jdField_a_of_type_Int = n;
      if (localView != paramView)
      {
        bool1 = paramView.isSelected();
        boolean bool2 = paramView.isPressed();
        this.jdField_a_of_type_Hzz.a(paramView, paramInt1);
        if (this.ai != 0) {
          localView.setDrawingCacheBackgroundColor(this.ai);
        }
        detachViewFromParent(paramInt4);
        addViewInLayout(localView, paramInt4, localLayoutParams, true);
        if (localView.isSelected() != bool1) {
          localView.setSelected(bool1);
        }
        if (localView.isPressed() != bool2) {
          localView.setPressed(bool2);
        }
        if ((this.N != 0) && (this.jdField_a_of_type_AndroidUtilSparseBooleanArray != null))
        {
          if (!(localView instanceof Checkable)) {
            break label414;
          }
          ((Checkable)localView).setChecked(this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(paramInt1));
        }
      }
      boolean bool1 = localView.isLayoutRequested();
      if (bool1)
      {
        m = ViewGroup.getChildMeasureSpec(this.V, this.jdField_c_of_type_AndroidGraphicsRect.left + this.jdField_c_of_type_AndroidGraphicsRect.right, localLayoutParams.width);
        paramInt4 = localLayoutParams.height;
        if (paramInt4 > 0)
        {
          paramInt4 = View.MeasureSpec.makeMeasureSpec(paramInt4, 1073741824);
          localView.measure(m, paramInt4);
          paramInt4 = localView.getMeasuredWidth();
          m = localView.getMeasuredHeight();
          if (!paramBoolean) {
            break label470;
          }
          if (!bool1) {
            break label478;
          }
          localView.layout(paramInt3, paramInt2, paramInt4 + paramInt3, m + paramInt2);
        }
      }
      for (;;)
      {
        if ((this.jdField_f_of_type_Boolean) && (!localView.isDrawingCacheEnabled())) {
          localView.setDrawingCacheEnabled(true);
        }
        if ((VersionUtils.e()) && (((AbsListView.LayoutParams)localView.getLayoutParams()).jdField_b_of_type_Int != paramInt1)) {
          localView.jumpDrawablesToCurrentState();
        }
        return localView.getHeight() - k;
        localView = this.jdField_a_of_type_AndroidWidgetListAdapter.getView(paramInt1, this.jdField_a_of_type_Hzz.b(paramInt1), this);
        break;
        if ((getContext().getApplicationInfo().targetSdkVersion < 11) || (!VersionUtils.e())) {
          break label221;
        }
        localView.setActivated(this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(paramInt1));
        break label221;
        paramInt4 = View.MeasureSpec.makeMeasureSpec(0, 0);
        break label284;
        cleanupLayoutState(localView);
        break label293;
        paramInt2 -= m;
        break label312;
        localView.offsetLeftAndRight(paramInt3 - localView.getLeft());
        localView.offsetTopAndBottom(paramInt2 - localView.getTop());
      }
    }
  }
  
  private View a(int paramInt)
  {
    this.ap = Math.min(this.ap, this.aA);
    this.ap = Math.min(this.ap, this.aB - 1);
    if (this.ap < 0) {
      this.ap = 0;
    }
    return a(this.ap, paramInt);
  }
  
  private View a(int paramInt1, int paramInt2)
  {
    Object localObject = null;
    int k = this.mBottom - this.mTop;
    if ((this.mGroupFlags & 0x22) == 34) {
      k -= this.jdField_c_of_type_AndroidGraphicsRect.bottom;
    }
    for (;;)
    {
      boolean bool;
      label59:
      int m;
      if ((paramInt2 < k) && (paramInt1 < this.aB)) {
        if (paramInt1 == this.aA)
        {
          bool = true;
          View localView = a(paramInt1, paramInt2, true, this.jdField_c_of_type_AndroidGraphicsRect.left, bool);
          paramInt2 = localView.getBottom();
          m = this.aG;
          if (!bool) {
            break label119;
          }
          localObject = localView;
        }
      }
      label119:
      for (;;)
      {
        paramInt2 += m;
        paramInt1 += 1;
        break;
        bool = false;
        break label59;
        return localObject;
      }
    }
  }
  
  private View a(int paramInt1, int paramInt2, int paramInt3)
  {
    int m = getVerticalFadingEdgeLength();
    int k = this.aA;
    paramInt2 = b(paramInt2, m, k);
    paramInt3 = a(paramInt3, m, k);
    View localView = a(k, paramInt1, true, this.jdField_c_of_type_AndroidGraphicsRect.left, true);
    if (localView.getBottom() > paramInt3) {
      localView.offsetTopAndBottom(-Math.min(localView.getTop() - paramInt2, localView.getBottom() - paramInt3));
    }
    for (;;)
    {
      a(localView, k);
      if (this.h) {
        break;
      }
      g(getChildCount());
      return localView;
      if (localView.getTop() < paramInt2) {
        localView.offsetTopAndBottom(Math.min(paramInt2 - localView.getTop(), paramInt3 - localView.getBottom()));
      }
    }
    h(getChildCount());
    return localView;
  }
  
  private View a(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2)
  {
    a("ListView.makeAndAddView");
    try
    {
      if (!this.p)
      {
        localView = this.jdField_a_of_type_Hzz.a(paramInt1);
        if (localView != null)
        {
          a(localView, paramInt1, paramInt2, paramBoolean1, paramInt3, paramBoolean2, true);
          return localView;
        }
      }
      View localView = a(paramInt1, this.jdField_a_of_type_ArrayOfBoolean);
      a(localView, paramInt1, paramInt2, paramBoolean1, paramInt3, paramBoolean2, this.jdField_a_of_type_ArrayOfBoolean[0]);
      return localView;
    }
    finally
    {
      A();
    }
  }
  
  private View a(View paramView, int paramInt)
  {
    paramInt -= 1;
    View localView = a(paramInt, this.jdField_a_of_type_ArrayOfBoolean);
    a(localView, paramInt, paramView.getTop() - this.aG, false, this.jdField_c_of_type_AndroidGraphicsRect.left, false, this.jdField_a_of_type_ArrayOfBoolean[0]);
    return localView;
  }
  
  private View a(View paramView1, View paramView2, int paramInt1, int paramInt2, int paramInt3)
  {
    int m = getVerticalFadingEdgeLength();
    int n = this.aA;
    int k = b(paramInt2, m, n);
    m = a(paramInt2, m, n);
    int i1;
    if (paramInt1 > 0)
    {
      paramView1 = a(n - 1, paramView1.getTop(), true, this.jdField_c_of_type_AndroidGraphicsRect.left, false);
      paramInt1 = this.aG;
      paramView2 = a(n, paramView1.getBottom() + paramInt1, true, this.jdField_c_of_type_AndroidGraphicsRect.left, true);
      if (paramView2.getBottom() > m)
      {
        n = paramView2.getTop();
        i1 = paramView2.getBottom();
        paramInt2 = (paramInt3 - paramInt2) / 2;
        paramInt2 = Math.min(Math.min(n - k, i1 - m), paramInt2);
        paramView1.offsetTopAndBottom(-paramInt2);
        paramView2.offsetTopAndBottom(-paramInt2);
      }
      if (!this.h)
      {
        b(this.aA - 2, paramView2.getTop() - paramInt1);
        c();
        a(this.aA + 1, paramView2.getBottom() + paramInt1);
        return paramView2;
      }
      a(this.aA + 1, paramView2.getBottom() + paramInt1);
      c();
      b(this.aA - 2, paramView2.getTop() - paramInt1);
      return paramView2;
    }
    if (paramInt1 < 0)
    {
      if (paramView2 != null) {}
      for (paramView1 = a(n, paramView2.getTop(), true, this.jdField_c_of_type_AndroidGraphicsRect.left, true);; paramView1 = a(n, paramView1.getTop(), false, this.jdField_c_of_type_AndroidGraphicsRect.left, true))
      {
        if (paramView1.getTop() < k)
        {
          paramInt1 = paramView1.getTop();
          i1 = paramView1.getBottom();
          paramInt2 = (paramInt3 - paramInt2) / 2;
          paramView1.offsetTopAndBottom(Math.min(Math.min(k - paramInt1, m - i1), paramInt2));
        }
        a(paramView1, n);
        return paramView1;
      }
    }
    paramInt1 = paramView1.getTop();
    paramView1 = a(n, paramInt1, true, this.jdField_c_of_type_AndroidGraphicsRect.left, true);
    if ((paramInt1 < paramInt2) && (paramView1.getBottom() < paramInt2 + 20)) {
      paramView1.offsetTopAndBottom(paramInt2 - paramView1.getTop());
    }
    a(paramView1, n);
    return paramView1;
  }
  
  private ibb a(int paramInt)
  {
    int m = 1;
    int k = 1;
    View localView = a();
    if ((localView != null) && (localView.hasFocus()))
    {
      localView = localView.findFocus();
      localView = FocusFinder.getInstance().findNextFocus(this, localView, paramInt);
      if (localView == null) {
        break label376;
      }
      k = a(localView);
      if ((this.aA != -1) && (k != this.aA))
      {
        m = c(paramInt);
        if ((m != -1) && (((paramInt == 130) && (m < k)) || ((paramInt == 33) && (m > k)))) {
          return null;
        }
      }
    }
    else
    {
      if (paramInt == 130)
      {
        if (this.ap > 0)
        {
          label120:
          m = this.jdField_c_of_type_AndroidGraphicsRect.top;
          if (k == 0) {
            break label198;
          }
        }
        label198:
        for (k = b();; k = 0)
        {
          m = k + m;
          k = m;
          if (localView != null)
          {
            k = m;
            if (localView.getTop() > m) {
              k = localView.getTop();
            }
          }
          this.jdField_a_of_type_AndroidGraphicsRect.set(0, k, 0, k);
          localView = FocusFinder.getInstance().findNextFocusFromRect(this, this.jdField_a_of_type_AndroidGraphicsRect, paramInt);
          break;
          k = 0;
          break label120;
        }
      }
      if (this.ap + getChildCount() - 1 < this.aB)
      {
        k = m;
        label223:
        m = getHeight();
        n = this.jdField_c_of_type_AndroidGraphicsRect.bottom;
        if (k == 0) {
          break label296;
        }
      }
      label296:
      for (k = b();; k = 0)
      {
        m = m - n - k;
        k = m;
        if (localView != null)
        {
          k = m;
          if (localView.getBottom() < m) {
            k = localView.getBottom();
          }
        }
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, k, 0, k);
        break;
        k = 0;
        break label223;
      }
    }
    m = a(paramInt, localView, k);
    int n = u();
    if (m < n)
    {
      localView.requestFocus(paramInt);
      this.jdField_a_of_type_Ibb.a(k, m);
      return this.jdField_a_of_type_Ibb;
    }
    if (b(localView) < n)
    {
      localView.requestFocus(paramInt);
      this.jdField_a_of_type_Ibb.a(k, n);
      return this.jdField_a_of_type_Ibb;
    }
    label376:
    return null;
  }
  
  private void a(Rect paramRect)
  {
    try
    {
      Field localField = View.class.getDeclaredField("mPrivateFlags");
      localField.setAccessible(true);
      localField.set(this, Integer.valueOf(localField.getInt(this) | 0x80000000));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("XListView", 2, localException.getMessage(), localException);
      }
      postInvalidate(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    int k = this.aG;
    if (!this.h)
    {
      b(paramInt - 1, paramView.getTop() - k);
      c();
      a(paramInt + 1, k + paramView.getBottom());
      return;
    }
    a(paramInt + 1, paramView.getBottom() + k);
    c();
    b(paramInt - 1, paramView.getTop() - k);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    AbsListView.LayoutParams localLayoutParams2 = (AbsListView.LayoutParams)paramView.getLayoutParams();
    AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null)
    {
      localLayoutParams1 = new AbsListView.LayoutParams(-1, -2, 0);
      paramView.setLayoutParams(localLayoutParams1);
    }
    localLayoutParams1.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemViewType(paramInt1);
    localLayoutParams1.jdField_b_of_type_Boolean = true;
    paramInt2 = ViewGroup.getChildMeasureSpec(paramInt2, this.jdField_c_of_type_AndroidGraphicsRect.left + this.jdField_c_of_type_AndroidGraphicsRect.right, localLayoutParams1.width);
    paramInt1 = localLayoutParams1.height;
    if (paramInt1 > 0) {}
    for (paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);; paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(paramInt2, paramInt1);
      return;
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool2 = true;
    if (paramInt2 == -1) {
      throw new IllegalArgumentException("newSelectedPosition needs to be valid");
    }
    int k = this.aA - this.ap;
    paramInt2 -= this.ap;
    int m;
    View localView1;
    boolean bool1;
    if (paramInt1 == 33)
    {
      View localView2 = getChildAt(paramInt2);
      paramInt1 = k;
      m = 1;
      localView1 = paramView;
      paramView = localView2;
      k = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = m;
      m = getChildCount();
      if (paramView != null)
      {
        if ((paramBoolean) || (paramInt1 == 0)) {
          break label154;
        }
        bool1 = true;
        label92:
        paramView.setSelected(bool1);
        b(paramView, k, m);
      }
      if (localView1 != null) {
        if ((paramBoolean) || (paramInt1 != 0)) {
          break label160;
        }
      }
    }
    label154:
    label160:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      localView1.setSelected(paramBoolean);
      b(localView1, paramInt2, m);
      return;
      localView1 = getChildAt(paramInt2);
      paramInt1 = 0;
      break;
      bool1 = false;
      break label92;
    }
  }
  
  @TargetApi(11)
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1) {}
    for (int k = -1;; k = 0)
    {
      a(paramView, paramInt1, paramInt2, paramBoolean1, paramInt3, paramBoolean2, paramBoolean3, k);
      return;
    }
  }
  
  @TargetApi(11)
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3, int paramInt4)
  {
    a("ListView.setupChild");
    int m;
    label33:
    int k;
    boolean bool;
    label61:
    int n;
    label73:
    label93:
    AbsListView.LayoutParams localLayoutParams;
    if ((paramBoolean2) && (j()))
    {
      paramBoolean2 = true;
      if (paramBoolean2 == paramView.isSelected()) {
        break label413;
      }
      m = 1;
      k = this.ab;
      if ((k <= 0) || (k >= 3) || (this.W != paramInt1)) {
        break label419;
      }
      bool = true;
      if (bool == paramView.isPressed()) {
        break label425;
      }
      n = 1;
      if ((paramBoolean3) && (m == 0) && (!paramView.isLayoutRequested())) {
        break label431;
      }
      k = 1;
      localLayoutParams = (AbsListView.LayoutParams)paramView.getLayoutParams();
      if (localLayoutParams != null) {
        break label559;
      }
      localLayoutParams = new AbsListView.LayoutParams(-1, -2, 0);
    }
    label291:
    label425:
    label559:
    for (;;)
    {
      localLayoutParams.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemViewType(paramInt1);
      if (((paramBoolean3) && (!localLayoutParams.jdField_b_of_type_Boolean)) || ((localLayoutParams.jdField_a_of_type_Boolean) && (localLayoutParams.jdField_a_of_type_Int == -2)))
      {
        attachViewToParent(paramView, paramInt4, localLayoutParams);
        label175:
        if (m != 0) {
          paramView.setSelected(paramBoolean2);
        }
        if (n != 0) {
          paramView.setPressed(bool);
        }
        if ((this.N != 0) && (this.jdField_a_of_type_AndroidUtilSparseBooleanArray != null))
        {
          if (!(paramView instanceof Checkable)) {
            break label473;
          }
          ((Checkable)paramView).setChecked(this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(paramInt1));
        }
        label235:
        if (k == 0) {
          break label519;
        }
        m = ViewGroup.getChildMeasureSpec(this.V, this.jdField_c_of_type_AndroidGraphicsRect.left + this.jdField_c_of_type_AndroidGraphicsRect.right, localLayoutParams.width);
        paramInt4 = localLayoutParams.height;
        if (paramInt4 <= 0) {
          break label509;
        }
        paramInt4 = View.MeasureSpec.makeMeasureSpec(paramInt4, 1073741824);
        a("ListView.childMeasure");
        paramView.measure(m, paramInt4);
        A();
        label308:
        paramInt4 = paramView.getMeasuredWidth();
        m = paramView.getMeasuredHeight();
        if (!paramBoolean1) {
          break label527;
        }
        label325:
        if (k == 0) {
          break label535;
        }
        a("ListView.childLayout");
        paramView.layout(paramInt3, paramInt2, paramInt4 + paramInt3, m + paramInt2);
        A();
      }
      for (;;)
      {
        if ((this.jdField_f_of_type_Boolean) && (!paramView.isDrawingCacheEnabled())) {
          paramView.setDrawingCacheEnabled(true);
        }
        if ((VersionUtils.e()) && (paramBoolean3) && (((AbsListView.LayoutParams)paramView.getLayoutParams()).jdField_b_of_type_Int != paramInt1)) {
          paramView.jumpDrawablesToCurrentState();
        }
        A();
        return;
        paramBoolean2 = false;
        break;
        m = 0;
        break label33;
        bool = false;
        break label61;
        n = 0;
        break label73;
        label431:
        k = 0;
        break label93;
        localLayoutParams.jdField_b_of_type_Boolean = false;
        if (localLayoutParams.jdField_a_of_type_Int == -2) {
          localLayoutParams.jdField_a_of_type_Boolean = true;
        }
        addViewInLayout(paramView, paramInt4, localLayoutParams, true);
        break label175;
        label473:
        if ((getContext().getApplicationInfo().targetSdkVersion < 11) || (!VersionUtils.e())) {
          break label235;
        }
        paramView.setActivated(this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(paramInt1));
        break label235;
        label509:
        paramInt4 = View.MeasureSpec.makeMeasureSpec(0, 0);
        break label291;
        cleanupLayoutState(paramView);
        break label308;
        paramInt2 -= m;
        break label325;
        paramView.offsetLeftAndRight(paramInt3 - paramView.getLeft());
        paramView.offsetTopAndBottom(paramInt2 - paramView.getTop());
      }
    }
  }
  
  private void a(View paramView, ArrayList paramArrayList)
  {
    int m = paramArrayList.size();
    int k = 0;
    for (;;)
    {
      if (k < m)
      {
        if (((ListView.FixedViewInfo)paramArrayList.get(k)).jdField_a_of_type_AndroidViewView == paramView) {
          paramArrayList.remove(k);
        }
      }
      else {
        return;
      }
      k += 1;
    }
  }
  
  private void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null)
    {
      int m = paramArrayList.size();
      int k = 0;
      while (k < m)
      {
        AbsListView.LayoutParams localLayoutParams = (AbsListView.LayoutParams)((ListView.FixedViewInfo)paramArrayList.get(k)).jdField_a_of_type_AndroidViewView.getLayoutParams();
        if (localLayoutParams != null) {
          localLayoutParams.jdField_a_of_type_Boolean = false;
        }
        k += 1;
      }
    }
  }
  
  private boolean a(View paramView1, View paramView2)
  {
    if (paramView1 == paramView2) {
      return true;
    }
    paramView1 = paramView1.getParent();
    if (((paramView1 instanceof ViewGroup)) && (a((View)paramView1, paramView2))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private int b()
  {
    return Math.max(2, getVerticalFadingEdgeLength());
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    int k = getHeight() - this.jdField_c_of_type_AndroidGraphicsRect.bottom;
    int m = this.jdField_c_of_type_AndroidGraphicsRect.top;
    int n = getChildCount();
    View localView;
    if (paramInt1 == 130)
    {
      paramInt1 = n - 1;
      if (paramInt2 != -1) {
        paramInt1 = paramInt2 - this.ap;
      }
      m = this.ap;
      localView = getChildAt(paramInt1);
      if (m + paramInt1 >= this.aB - 1) {
        break label285;
      }
    }
    label285:
    for (paramInt1 = k - b();; paramInt1 = k)
    {
      if (localView.getBottom() <= paramInt1) {}
      while ((paramInt2 != -1) && (paramInt1 - localView.getTop() >= u())) {
        return 0;
      }
      paramInt2 = localView.getBottom() - paramInt1;
      paramInt1 = paramInt2;
      if (this.ap + n == this.aB) {
        paramInt1 = Math.min(paramInt2, getChildAt(n - 1).getBottom() - k);
      }
      return Math.min(paramInt1, u());
      if (paramInt2 != -1) {}
      for (paramInt1 = paramInt2 - this.ap;; paramInt1 = 0)
      {
        k = this.ap;
        localView = getChildAt(paramInt1);
        if (k + paramInt1 > 0) {}
        for (paramInt1 = b() + m; (localView.getTop() < paramInt1) && ((paramInt2 == -1) || (localView.getBottom() - paramInt1 < u())); paramInt1 = m)
        {
          paramInt2 = paramInt1 - localView.getTop();
          paramInt1 = paramInt2;
          if (this.ap == 0) {
            paramInt1 = Math.min(paramInt2, m - getChildAt(0).getTop());
          }
          return Math.min(paramInt1, u());
        }
        break;
      }
    }
  }
  
  private int b(int paramInt1, int paramInt2, int paramInt3)
  {
    int k = paramInt1;
    if (paramInt3 > 0) {
      k = paramInt1 + paramInt2;
    }
    return k;
  }
  
  private int b(View paramView)
  {
    int k = 0;
    paramView.getDrawingRect(this.jdField_a_of_type_AndroidGraphicsRect);
    offsetDescendantRectToMyCoords(paramView, this.jdField_a_of_type_AndroidGraphicsRect);
    int m = this.mBottom - this.mTop - this.jdField_c_of_type_AndroidGraphicsRect.bottom;
    if (this.jdField_a_of_type_AndroidGraphicsRect.bottom < this.jdField_c_of_type_AndroidGraphicsRect.top) {
      k = this.jdField_c_of_type_AndroidGraphicsRect.top - this.jdField_a_of_type_AndroidGraphicsRect.bottom;
    }
    while (this.jdField_a_of_type_AndroidGraphicsRect.top <= m) {
      return k;
    }
    return this.jdField_a_of_type_AndroidGraphicsRect.top - m;
  }
  
  private View b(int paramInt1, int paramInt2)
  {
    Object localObject = null;
    int k;
    if ((this.mGroupFlags & 0x22) == 34) {
      k = this.jdField_c_of_type_AndroidGraphicsRect.top;
    }
    for (;;)
    {
      boolean bool;
      label43:
      int m;
      if ((paramInt2 > k) && (paramInt1 >= 0)) {
        if (paramInt1 == this.aA)
        {
          bool = true;
          View localView = a(paramInt1, paramInt2, false, this.jdField_c_of_type_AndroidGraphicsRect.left, bool);
          paramInt2 = localView.getTop();
          m = this.aG;
          if (!bool) {
            break label110;
          }
          localObject = localView;
        }
      }
      label110:
      for (;;)
      {
        paramInt2 -= m;
        paramInt1 -= 1;
        break;
        bool = false;
        break label43;
        this.ap = (paramInt1 + 1);
        return localObject;
      }
      k = 0;
    }
  }
  
  private View b(View paramView, int paramInt)
  {
    paramInt += 1;
    View localView = a(paramInt, this.jdField_a_of_type_ArrayOfBoolean);
    int k = paramView.getBottom();
    a(localView, paramInt, this.aG + k, true, this.jdField_c_of_type_AndroidGraphicsRect.left, false, this.jdField_a_of_type_ArrayOfBoolean[0]);
    return localView;
  }
  
  private void b()
  {
    if ((this.h) && (this.ap == 0) && (getChildCount() > 0))
    {
      int k = getChildAt(0).getTop() - this.jdField_c_of_type_AndroidGraphicsRect.top;
      if (k > 0) {
        offsetChildrenTopAndBottom(-k);
      }
    }
  }
  
  private void b(View paramView, int paramInt1, int paramInt2)
  {
    int k = paramView.getHeight();
    c(paramView);
    if (paramView.getMeasuredHeight() != k)
    {
      d(paramView);
      int m = paramView.getMeasuredHeight();
      paramInt1 += 1;
      while (paramInt1 < paramInt2)
      {
        getChildAt(paramInt1).offsetTopAndBottom(m - k);
        paramInt1 += 1;
      }
    }
  }
  
  @TargetApi(11)
  private boolean b(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    boolean bool3 = true;
    boolean bool2;
    if ((this.jdField_a_of_type_AndroidWidgetListAdapter == null) || (!this.l))
    {
      bool2 = false;
      return bool2;
    }
    if (this.p) {
      i();
    }
    int n = paramKeyEvent.getAction();
    if (n != 1) {}
    label144:
    boolean bool1;
    int k;
    switch (paramInt1)
    {
    default: 
      bool1 = false;
      k = paramInt2;
    }
    for (;;)
    {
      bool2 = bool3;
      if (bool1) {
        break;
      }
      bool2 = bool3;
      if (a(paramInt1, k, paramKeyEvent)) {
        break;
      }
      switch (n)
      {
      default: 
        return false;
        int m;
        if ((VersionUtils.e()) && (paramKeyEvent.hasNoModifiers()))
        {
          bool2 = k();
          bool1 = bool2;
          k = paramInt2;
          if (!bool2) {
            for (;;)
            {
              m = paramInt2 - 1;
              bool1 = bool2;
              k = m;
              if (paramInt2 <= 0) {
                break;
              }
              bool1 = bool2;
              k = m;
              if (!h(33)) {
                break;
              }
              bool2 = true;
              paramInt2 = m;
            }
          }
        }
        else
        {
          if ((!VersionUtils.e()) || (!paramKeyEvent.hasModifiers(2))) {
            break label144;
          }
          if ((k()) || (g(33)))
          {
            bool1 = true;
            k = paramInt2;
          }
          else
          {
            bool1 = false;
            k = paramInt2;
            continue;
            if ((VersionUtils.e()) && (paramKeyEvent.hasNoModifiers()))
            {
              bool2 = k();
              bool1 = bool2;
              k = paramInt2;
              if (!bool2) {
                for (;;)
                {
                  m = paramInt2 - 1;
                  bool1 = bool2;
                  k = m;
                  if (paramInt2 <= 0) {
                    break;
                  }
                  bool1 = bool2;
                  k = m;
                  if (!h(130)) {
                    break;
                  }
                  bool2 = true;
                  paramInt2 = m;
                }
              }
            }
            else
            {
              if ((!VersionUtils.e()) || (!paramKeyEvent.hasModifiers(2))) {
                break label144;
              }
              if ((k()) || (g(130)))
              {
                bool1 = true;
                k = paramInt2;
              }
              else
              {
                bool1 = false;
                k = paramInt2;
                continue;
                if ((!VersionUtils.e()) || (!paramKeyEvent.hasNoModifiers())) {
                  break label144;
                }
                bool1 = c(17);
                k = paramInt2;
                continue;
                if ((!VersionUtils.e()) || (!paramKeyEvent.hasNoModifiers())) {
                  break label144;
                }
                bool1 = c(66);
                k = paramInt2;
                continue;
                if ((!VersionUtils.e()) || (!paramKeyEvent.hasNoModifiers())) {
                  break label144;
                }
                bool2 = k();
                bool1 = bool2;
                k = paramInt2;
                if (!bool2)
                {
                  bool1 = bool2;
                  k = paramInt2;
                  if (paramKeyEvent.getRepeatCount() == 0)
                  {
                    bool1 = bool2;
                    k = paramInt2;
                    if (getChildCount() > 0)
                    {
                      k();
                      bool1 = true;
                      k = paramInt2;
                      continue;
                      if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
                        break label144;
                      }
                      if ((VersionUtils.e()) && (paramKeyEvent.hasNoModifiers())) {
                        if ((k()) || (!f(130))) {}
                      }
                      for (;;)
                      {
                        bool1 = true;
                        k = paramInt2;
                        break;
                        if ((!VersionUtils.e()) || (!paramKeyEvent.hasModifiers(1)) || (k()) || (!f(33))) {}
                      }
                      if ((VersionUtils.e()) && (paramKeyEvent.hasNoModifiers()))
                      {
                        if ((k()) || (f(33)))
                        {
                          bool1 = true;
                          k = paramInt2;
                        }
                        else
                        {
                          bool1 = false;
                          k = paramInt2;
                        }
                      }
                      else
                      {
                        if ((!VersionUtils.e()) || (!paramKeyEvent.hasModifiers(2))) {
                          break label144;
                        }
                        if ((k()) || (g(33)))
                        {
                          bool1 = true;
                          k = paramInt2;
                        }
                        else
                        {
                          bool1 = false;
                          k = paramInt2;
                          continue;
                          if ((VersionUtils.e()) && (paramKeyEvent.hasNoModifiers()))
                          {
                            if ((k()) || (f(130)))
                            {
                              bool1 = true;
                              k = paramInt2;
                            }
                            else
                            {
                              bool1 = false;
                              k = paramInt2;
                            }
                          }
                          else
                          {
                            if ((!VersionUtils.e()) || (!paramKeyEvent.hasModifiers(2))) {
                              break label144;
                            }
                            if ((k()) || (g(130)))
                            {
                              bool1 = true;
                              k = paramInt2;
                            }
                            else
                            {
                              bool1 = false;
                              k = paramInt2;
                              continue;
                              if ((!VersionUtils.e()) || (!paramKeyEvent.hasNoModifiers())) {
                                break label144;
                              }
                              if ((k()) || (g(33)))
                              {
                                bool1 = true;
                                k = paramInt2;
                              }
                              else
                              {
                                bool1 = false;
                                k = paramInt2;
                                continue;
                                if ((!VersionUtils.e()) || (!paramKeyEvent.hasNoModifiers())) {
                                  break label144;
                                }
                                if ((k()) || (g(130)))
                                {
                                  bool1 = true;
                                  k = paramInt2;
                                }
                                else
                                {
                                  bool1 = false;
                                  k = paramInt2;
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
        break;
      }
    }
    return super.onKeyDown(paramInt1, paramKeyEvent);
    return super.onKeyUp(paramInt1, paramKeyEvent);
    return super.onKeyMultiple(paramInt1, k, paramKeyEvent);
  }
  
  private int c(int paramInt)
  {
    int m = this.ap;
    ListAdapter localListAdapter;
    if (paramInt == 130)
    {
      if (this.aA != -1) {}
      for (k = this.aA + 1; k >= this.jdField_a_of_type_AndroidWidgetListAdapter.getCount(); k = m)
      {
        paramInt = -1;
        return paramInt;
      }
      paramInt = k;
      if (k < m) {
        paramInt = m;
      }
      int n = r();
      localListAdapter = a();
      k = paramInt;
      for (;;)
      {
        if (k > n) {
          break label215;
        }
        if (localListAdapter.isEnabled(k))
        {
          paramInt = k;
          if (getChildAt(k - m).getVisibility() == 0) {
            break;
          }
        }
        k += 1;
      }
    }
    int k = getChildCount() + m - 1;
    if (this.aA != -1) {}
    for (paramInt = this.aA - 1; (paramInt < 0) || (paramInt >= this.jdField_a_of_type_AndroidWidgetListAdapter.getCount()); paramInt = getChildCount() + m - 1) {
      return -1;
    }
    if (paramInt > k) {}
    for (;;)
    {
      localListAdapter = a();
      for (;;)
      {
        if (k < m) {
          break label215;
        }
        if (localListAdapter.isEnabled(k))
        {
          paramInt = k;
          if (getChildAt(k - m).getVisibility() == 0) {
            break;
          }
        }
        k -= 1;
      }
      label215:
      return -1;
      k = paramInt;
    }
  }
  
  private View c(int paramInt1, int paramInt2)
  {
    paramInt2 -= paramInt1;
    int k = m();
    View localView = a(k, paramInt1, true, this.jdField_c_of_type_AndroidGraphicsRect.left, true);
    this.ap = k;
    paramInt1 = localView.getMeasuredHeight();
    if (paramInt1 <= paramInt2) {
      localView.offsetTopAndBottom((paramInt2 - paramInt1) / 2);
    }
    a(localView, k);
    if (!this.h)
    {
      g(getChildCount());
      return localView;
    }
    h(getChildCount());
    return localView;
  }
  
  private void c()
  {
    int n = 0;
    int i1 = getChildCount();
    int m;
    int k;
    if (i1 > 0)
    {
      if (this.h) {
        break label72;
      }
      m = getChildAt(0).getTop() - this.jdField_c_of_type_AndroidGraphicsRect.top;
      k = m;
      if (this.ap != 0) {
        k = m - this.aG;
      }
      m = k;
      if (k >= 0) {
        break label128;
      }
      m = n;
    }
    label128:
    for (;;)
    {
      if (m != 0) {
        offsetChildrenTopAndBottom(-m);
      }
      return;
      label72:
      m = getChildAt(i1 - 1).getBottom() - (getHeight() - this.jdField_c_of_type_AndroidGraphicsRect.bottom);
      k = m;
      if (i1 + this.ap < this.aB) {
        k = m + this.aG;
      }
      m = n;
      if (k <= 0) {
        m = k;
      }
    }
  }
  
  private void c(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-1, -2);
    }
    int m = ViewGroup.getChildMeasureSpec(this.V, this.jdField_c_of_type_AndroidGraphicsRect.left + this.jdField_c_of_type_AndroidGraphicsRect.right, localLayoutParams1.width);
    int k = localLayoutParams1.height;
    if (k > 0) {}
    for (k = View.MeasureSpec.makeMeasureSpec(k, 1073741824);; k = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(m, k);
      return;
    }
  }
  
  private boolean c(int paramInt)
  {
    if ((paramInt != 17) && (paramInt != 66)) {
      throw new IllegalArgumentException("direction must be one of {View.FOCUS_LEFT, View.FOCUS_RIGHT}");
    }
    int k = getChildCount();
    if ((this.t) && (k > 0) && (this.aA != -1))
    {
      View localView2 = a();
      if ((localView2 != null) && (localView2.hasFocus()) && ((localView2 instanceof ViewGroup)))
      {
        View localView1 = localView2.findFocus();
        localView2 = FocusFinder.getInstance().findNextFocus((ViewGroup)localView2, localView1, paramInt);
        if (localView2 != null)
        {
          localView1.getFocusedRect(this.jdField_a_of_type_AndroidGraphicsRect);
          offsetDescendantRectToMyCoords(localView1, this.jdField_a_of_type_AndroidGraphicsRect);
          offsetRectIntoDescendantCoords(localView2, this.jdField_a_of_type_AndroidGraphicsRect);
          if (localView2.requestFocus(paramInt, this.jdField_a_of_type_AndroidGraphicsRect)) {
            return true;
          }
        }
        localView1 = FocusFinder.getInstance().findNextFocus((ViewGroup)getRootView(), localView1, paramInt);
        if (localView1 != null) {
          return a(localView1, this);
        }
      }
    }
    return false;
  }
  
  private boolean c(View paramView)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int m = localArrayList.size();
    int k = 0;
    while (k < m)
    {
      if (paramView == ((ListView.FixedViewInfo)localArrayList.get(k)).jdField_a_of_type_AndroidViewView) {
        return true;
      }
      k += 1;
    }
    localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
    m = localArrayList.size();
    k = 0;
    while (k < m)
    {
      if (paramView == ((ListView.FixedViewInfo)localArrayList.get(k)).jdField_a_of_type_AndroidViewView) {
        return true;
      }
      k += 1;
    }
    return false;
  }
  
  private View d(int paramInt1, int paramInt2)
  {
    boolean bool;
    View localView5;
    View localView3;
    View localView4;
    View localView1;
    View localView2;
    if (paramInt1 == this.aA)
    {
      bool = true;
      localView5 = a(paramInt1, paramInt2, false, this.jdField_c_of_type_AndroidGraphicsRect.left, bool);
      this.ap = paramInt1;
      paramInt2 = this.aG;
      if (this.h) {
        break label122;
      }
      localView3 = b(paramInt1 - 1, localView5.getTop() - paramInt2);
      c();
      localView4 = a(paramInt1 + 1, paramInt2 + localView5.getBottom());
      paramInt1 = getChildCount();
      localView1 = localView3;
      localView2 = localView4;
      if (paramInt1 > 0)
      {
        g(paramInt1);
        localView2 = localView4;
        localView1 = localView3;
      }
    }
    for (;;)
    {
      if (!bool) {
        break label191;
      }
      return localView5;
      bool = false;
      break;
      label122:
      localView3 = a(paramInt1 + 1, localView5.getBottom() + paramInt2);
      c();
      localView4 = b(paramInt1 - 1, localView5.getTop() - paramInt2);
      paramInt1 = getChildCount();
      localView1 = localView4;
      localView2 = localView3;
      if (paramInt1 > 0)
      {
        h(paramInt1);
        localView1 = localView4;
        localView2 = localView3;
      }
    }
    label191:
    if (localView1 != null) {
      return localView1;
    }
    return localView2;
  }
  
  private void d()
  {
    if ((this.ab == 5) && (getScrollY() != 0))
    {
      int k = getScrollY();
      if ((k < 0) && (this.jdField_a_of_type_Ibe != null) && (k > -t()) && ((this.aL == 0) || (this.aL == 2)))
      {
        if (this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener != null) {
          this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener.a(0, this.jdField_a_of_type_Ibe.getChildAt(0), this);
        }
        this.aL = 1;
      }
    }
  }
  
  private void d(View paramView)
  {
    int k = paramView.getMeasuredWidth();
    int m = paramView.getMeasuredHeight();
    int n = this.jdField_c_of_type_AndroidGraphicsRect.left;
    int i1 = paramView.getTop();
    paramView.layout(n, i1, k + n, m + i1);
  }
  
  private boolean d(int paramInt)
  {
    if (getChildCount() <= 0) {
      return false;
    }
    View localView1 = a();
    int i1 = this.aA;
    int k = c(paramInt);
    int m = b(paramInt, k);
    Object localObject;
    int n;
    label73:
    boolean bool;
    if (this.t)
    {
      localObject = a(paramInt);
      if (localObject != null)
      {
        k = ((ibb)localObject).a();
        m = ((ibb)localObject).b();
      }
      if (localObject == null) {
        break label306;
      }
      n = 1;
      if (k == -1) {
        break label327;
      }
      if (localObject == null) {
        break label312;
      }
      bool = true;
      label86:
      a(localView1, paramInt, k, bool);
      e(k);
      f(k);
      localView1 = a();
      if ((this.t) && (localObject == null))
      {
        View localView2 = getFocusedChild();
        if (localView2 != null) {
          localView2.clearFocus();
        }
      }
      x();
      n = 1;
      i1 = k;
    }
    label160:
    label306:
    label312:
    label324:
    label325:
    label327:
    for (;;)
    {
      if (m > 0)
      {
        if (paramInt == 33)
        {
          i(m);
          n = 1;
        }
      }
      else
      {
        if ((this.t) && (localObject == null) && (localView1 != null) && (localView1.hasFocus()))
        {
          localObject = localView1.findFocus();
          if ((!a((View)localObject, this)) || (b((View)localObject) > 0)) {
            ((View)localObject).clearFocus();
          }
        }
        if ((k != -1) || (localView1 == null) || (a(localView1, this))) {
          break label324;
        }
        m();
        this.af = -1;
        localView1 = null;
      }
      for (;;)
      {
        if (n == 0) {
          break label325;
        }
        if (localView1 != null)
        {
          a(i1, localView1);
          this.ae = localView1.getTop();
        }
        if (!awakenScrollBars()) {
          invalidate();
        }
        f();
        return true;
        localObject = null;
        break;
        n = 0;
        break label73;
        bool = false;
        break label86;
        m = -m;
        break label160;
      }
      break;
    }
  }
  
  private View e(int paramInt1, int paramInt2)
  {
    boolean bool;
    View localView5;
    View localView3;
    View localView4;
    View localView1;
    View localView2;
    if (paramInt1 == this.aA)
    {
      bool = true;
      localView5 = a(paramInt1, paramInt2, true, this.jdField_c_of_type_AndroidGraphicsRect.left, bool);
      this.ap = paramInt1;
      paramInt2 = this.aG;
      if (this.h) {
        break label122;
      }
      localView3 = b(paramInt1 - 1, localView5.getTop() - paramInt2);
      c();
      localView4 = a(paramInt1 + 1, paramInt2 + localView5.getBottom());
      paramInt1 = getChildCount();
      localView1 = localView3;
      localView2 = localView4;
      if (paramInt1 > 0)
      {
        g(paramInt1);
        localView2 = localView4;
        localView1 = localView3;
      }
    }
    for (;;)
    {
      if (!bool) {
        break label191;
      }
      return localView5;
      bool = false;
      break;
      label122:
      localView3 = a(paramInt1 + 1, localView5.getBottom() + paramInt2);
      c();
      localView4 = b(paramInt1 - 1, localView5.getTop() - paramInt2);
      paramInt1 = getChildCount();
      localView1 = localView4;
      localView2 = localView3;
      if (paramInt1 > 0)
      {
        h(paramInt1);
        localView1 = localView4;
        localView2 = localView3;
      }
    }
    label191:
    if (localView1 != null) {
      return localView1;
    }
    return localView2;
  }
  
  private void e(View paramView)
  {
    int k = getScrollY();
    paramView.getHeight();
    if ((paramView == this.jdField_a_of_type_Ibe) && (this.aL == 1) && (k <= -t()))
    {
      this.aL = 2;
      if (this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener != null) {
        this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener.b(0, this.jdField_a_of_type_Ibe.getChildAt(0), this);
      }
    }
  }
  
  private void f(View paramView)
  {
    try
    {
      Object localObject = View.class.getDeclaredField("mAttachInfo");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(this);
      if (localObject != null)
      {
        Method localMethod = View.class.getDeclaredMethod("dispatchAttachedToWindow", new Class[] { localObject.getClass(), Integer.TYPE });
        localMethod.setAccessible(true);
        localMethod.invoke(paramView, new Object[] { localObject, Integer.valueOf(getVisibility()) });
      }
      return;
    }
    catch (Exception paramView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("XListView", 2, paramView.getMessage(), paramView);
    }
  }
  
  private void g(int paramInt)
  {
    if ((this.ap + paramInt - 1 == this.aB - 1) && (paramInt > 0))
    {
      paramInt = getChildAt(paramInt - 1).getBottom();
      int k = getBottom() - this.mTop - this.jdField_c_of_type_AndroidGraphicsRect.bottom - paramInt;
      View localView = getChildAt(0);
      int m = localView.getTop();
      if ((k > 0) && ((this.ap > 0) || (m < this.jdField_c_of_type_AndroidGraphicsRect.top)))
      {
        paramInt = k;
        if (this.ap == 0) {
          paramInt = Math.min(k, this.jdField_c_of_type_AndroidGraphicsRect.top - m);
        }
        offsetChildrenTopAndBottom(paramInt);
        if (this.ap > 0)
        {
          b(this.ap - 1, localView.getTop() - this.aG);
          c();
        }
      }
    }
  }
  
  private void g(View paramView)
  {
    try
    {
      Object localObject = View.class.getDeclaredField("mAttachInfo");
      ((Field)localObject).setAccessible(true);
      if (((Field)localObject).get(paramView) != null)
      {
        localObject = View.class.getDeclaredMethod("dispatchDetachedFromWindow", new Class[0]);
        ((Method)localObject).setAccessible(true);
        ((Method)localObject).invoke(paramView, new Object[0]);
      }
      return;
    }
    catch (Exception paramView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("XListView", 2, paramView.getMessage(), paramView);
    }
  }
  
  private void h(int paramInt)
  {
    int i1;
    if ((this.ap == 0) && (paramInt > 0))
    {
      int k = getChildAt(0).getTop();
      int n = this.jdField_c_of_type_AndroidGraphicsRect.top;
      int m = getBottom() - this.mTop - this.jdField_c_of_type_AndroidGraphicsRect.bottom;
      k -= n;
      View localView = getChildAt(paramInt - 1);
      n = localView.getBottom();
      i1 = this.ap + paramInt - 1;
      if (k > 0)
      {
        if ((i1 >= this.aB - 1) && (n <= m)) {
          break label162;
        }
        paramInt = k;
        if (i1 == this.aB - 1) {
          paramInt = Math.min(k, n - m);
        }
        offsetChildrenTopAndBottom(-paramInt);
        if (i1 < this.aB - 1)
        {
          a(i1 + 1, localView.getBottom() + this.aG);
          c();
        }
      }
    }
    label162:
    while (i1 != this.aB - 1) {
      return;
    }
    c();
  }
  
  private void i(int paramInt)
  {
    offsetChildrenTopAndBottom(paramInt);
    int k = getHeight() - this.jdField_c_of_type_AndroidGraphicsRect.bottom;
    int m = this.jdField_c_of_type_AndroidGraphicsRect.top;
    hzz localhzz = this.jdField_a_of_type_Hzz;
    View localView;
    if (paramInt < 0)
    {
      paramInt = getChildCount();
      localView = getChildAt(paramInt - 1);
      while (localView.getBottom() < k)
      {
        int n = this.ap + paramInt - 1;
        if (n >= this.aB - 1) {
          break;
        }
        localView = b(localView, n);
        paramInt += 1;
      }
      if (localView.getBottom() < k) {
        offsetChildrenTopAndBottom(k - localView.getBottom());
      }
      localView = getChildAt(0);
      if (localView.getBottom() < m)
      {
        if (localhzz.a(((AbsListView.LayoutParams)localView.getLayoutParams()).jdField_a_of_type_Int))
        {
          detachViewFromParent(localView);
          localhzz.a(localView, this.ap);
        }
        for (;;)
        {
          localView = getChildAt(0);
          this.ap += 1;
          break;
          removeViewInLayout(localView);
        }
      }
    }
    else
    {
      localView = getChildAt(0);
      while ((localView.getTop() > m) && (this.ap > 0))
      {
        localView = a(localView, this.ap);
        this.ap -= 1;
      }
      if (localView.getTop() > m) {
        offsetChildrenTopAndBottom(m - localView.getTop());
      }
      paramInt = getChildCount() - 1;
      localView = getChildAt(paramInt);
      if (localView.getTop() > k)
      {
        if (localhzz.a(((AbsListView.LayoutParams)localView.getLayoutParams()).jdField_a_of_type_Int))
        {
          detachViewFromParent(localView);
          localhzz.a(localView, this.ap + paramInt);
        }
        for (;;)
        {
          paramInt -= 1;
          localView = getChildAt(paramInt);
          break;
          removeViewInLayout(localView);
        }
      }
    }
  }
  
  private boolean r()
  {
    boolean bool = false;
    int k = this.mScrollY;
    int m = this.jdField_c_of_type_AndroidGraphicsRect.top;
    if ((this.ap > 0) || (getChildAt(0).getTop() > k + m)) {
      bool = true;
    }
    return bool;
  }
  
  private boolean s()
  {
    int k = getChildCount();
    int m = getChildAt(k - 1).getBottom();
    int n = this.ap;
    int i1 = getScrollY();
    int i2 = getHeight();
    int i3 = this.jdField_c_of_type_AndroidGraphicsRect.bottom;
    return (k + n - 1 < this.aB - 1) || (m < i1 + i2 - i3);
  }
  
  public void B()
  {
    if ((getScrollY() < 0) && (!this.u)) {
      u();
    }
    this.aL = 0;
  }
  
  public void C()
  {
    if (this.mScrollY < 0)
    {
      v();
      if (!this.h)
      {
        setSelectionFromTop(this.ap, this.jdField_c_of_type_AndroidGraphicsRect.top - this.mScrollY);
        onScrollChanged(0, 0, 0, this.mScrollY);
        this.mScrollY = 0;
      }
    }
    else
    {
      this.aL = 0;
      return;
    }
    this.P = 100;
    View localView = getChildAt(0);
    if (localView == null) {}
    for (int k = 0;; k = this.au - localView.getBottom() - this.jdField_c_of_type_AndroidGraphicsRect.bottom)
    {
      setSelectionFromBottom(this.ap, k + this.mScrollY);
      break;
    }
  }
  
  public void D()
  {
    int m = getChildCount();
    int k = 0;
    while (k < m)
    {
      View localView = getChildAt(k);
      if (localView.getAnimation() != null) {
        localView.clearAnimation();
      }
      k += 1;
    }
  }
  
  public void E()
  {
    scrollTo(0, -t() - 1);
    if (this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener != null)
    {
      if (!this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener.a(-t() - 1, this.jdField_a_of_type_Ibe.getChildAt(0), this)) {
        B();
      }
    }
    else {
      return;
    }
    this.aL = 3;
  }
  
  int a(int paramInt)
  {
    int m = getChildCount();
    if (m > 0)
    {
      if (!this.h)
      {
        k = 0;
        while (k < m)
        {
          if (paramInt <= getChildAt(k).getBottom()) {
            return k + this.ap;
          }
          k += 1;
        }
      }
      int k = m - 1;
      while (k >= 0)
      {
        if (paramInt >= getChildAt(k).getTop()) {
          return k + this.ap;
        }
        k -= 1;
      }
    }
    return -1;
  }
  
  final int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int n = 0;
    Object localObject = this.jdField_a_of_type_AndroidWidgetListAdapter;
    if (localObject == null)
    {
      paramInt1 = this.jdField_c_of_type_AndroidGraphicsRect.top + this.jdField_c_of_type_AndroidGraphicsRect.bottom;
      return paramInt1;
    }
    int i1 = this.jdField_c_of_type_AndroidGraphicsRect.top + this.jdField_c_of_type_AndroidGraphicsRect.bottom;
    int k;
    label69:
    boolean bool;
    label111:
    View localView;
    if ((this.aG > 0) && (this.jdField_d_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      k = this.aG;
      int m = paramInt3;
      if (paramInt3 == -1) {
        m = ((ListAdapter)localObject).getCount() - 1;
      }
      localObject = this.jdField_a_of_type_Hzz;
      bool = o();
      boolean[] arrayOfBoolean = this.jdField_a_of_type_ArrayOfBoolean;
      paramInt3 = paramInt2;
      paramInt2 = i1;
      if (paramInt3 > m) {
        break label265;
      }
      localView = a(paramInt3, arrayOfBoolean);
      a(localView, paramInt3, paramInt1);
      if (paramInt3 <= 0) {
        break label267;
      }
      paramInt2 += k;
    }
    label265:
    label267:
    for (;;)
    {
      if ((bool) && (((hzz)localObject).a(((AbsListView.LayoutParams)localView.getLayoutParams()).jdField_a_of_type_Int))) {
        ((hzz)localObject).a(localView, -1);
      }
      paramInt2 = localView.getMeasuredHeight() + paramInt2;
      if (paramInt2 >= paramInt4)
      {
        paramInt1 = paramInt4;
        if (paramInt5 < 0) {
          break;
        }
        paramInt1 = paramInt4;
        if (paramInt3 <= paramInt5) {
          break;
        }
        paramInt1 = paramInt4;
        if (n <= 0) {
          break;
        }
        paramInt1 = paramInt4;
        if (paramInt2 == paramInt4) {
          break;
        }
        return n;
        k = 0;
        break label69;
      }
      i1 = n;
      if (paramInt5 >= 0)
      {
        i1 = n;
        if (paramInt3 >= paramInt5) {
          i1 = paramInt2;
        }
      }
      paramInt3 += 1;
      n = i1;
      break label111;
      return paramInt2;
    }
  }
  
  int a(int paramInt, boolean paramBoolean)
  {
    ListAdapter localListAdapter = this.jdField_a_of_type_AndroidWidgetListAdapter;
    int k;
    if ((localListAdapter == null) || (isInTouchMode())) {
      k = -1;
    }
    int m;
    label125:
    do
    {
      do
      {
        return k;
        m = localListAdapter.getCount();
        if (this.s) {
          break label125;
        }
        if (paramBoolean)
        {
          k = Math.max(0, paramInt);
          for (;;)
          {
            paramInt = k;
            if (k >= m) {
              break;
            }
            paramInt = k;
            if (localListAdapter.isEnabled(k)) {
              break;
            }
            k += 1;
          }
        }
        k = Math.min(paramInt, m - 1);
        for (;;)
        {
          paramInt = k;
          if (k < 0) {
            break;
          }
          paramInt = k;
          if (localListAdapter.isEnabled(k)) {
            break;
          }
          k -= 1;
        }
        if (paramInt < 0) {
          break;
        }
        k = paramInt;
      } while (paramInt < m);
      return -1;
      if (paramInt < 0) {
        break;
      }
      k = paramInt;
    } while (paramInt < m);
    return -1;
  }
  
  public ListAdapter a()
  {
    return this.jdField_a_of_type_AndroidWidgetListAdapter;
  }
  
  protected hzp a()
  {
    return new ibd(this);
  }
  
  void a(Canvas paramCanvas, Rect paramRect, int paramInt)
  {
    Drawable localDrawable = this.jdField_d_of_type_AndroidGraphicsDrawableDrawable;
    localDrawable.setBounds(paramRect);
    localDrawable.draw(paramCanvas);
  }
  
  void a(Canvas paramCanvas, Drawable paramDrawable, Rect paramRect)
  {
    int k = paramDrawable.getMinimumHeight();
    paramCanvas.save();
    paramCanvas.clipRect(paramRect);
    if (paramRect.bottom - paramRect.top < k) {
      paramRect.bottom = (k + paramRect.top);
    }
    paramDrawable.setBounds(paramRect);
    paramDrawable.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  void a(Canvas paramCanvas, View paramView, Drawable paramDrawable1, Drawable paramDrawable2, Rect paramRect)
  {
    int k = paramCanvas.save();
    int m;
    if (paramDrawable1 != null)
    {
      m = paramDrawable1.getIntrinsicHeight();
      if (m >= paramRect.height()) {
        break label162;
      }
      Rect localRect = new Rect(paramRect);
      localRect.top = (localRect.top + paramRect.height() - m);
      paramDrawable1.setBounds(localRect);
    }
    for (;;)
    {
      paramDrawable1.draw(paramCanvas);
      if (paramDrawable2 != null)
      {
        m = paramDrawable2.getMinimumHeight();
        if (paramRect.bottom - paramRect.top < m) {
          paramRect.top = (paramRect.bottom - m);
        }
        paramDrawable2.setBounds(paramRect);
        paramDrawable2.draw(paramCanvas);
      }
      if (paramView != null)
      {
        e(paramView);
        paramView.offsetTopAndBottom(paramRect.bottom - paramView.getBottom());
        drawChild(paramCanvas, paramView, getDrawingTime());
      }
      paramCanvas.restoreToCount(k);
      return;
      label162:
      paramDrawable1.setBounds(paramRect);
    }
  }
  
  public void a(View paramView)
  {
    a(paramView, null, true);
  }
  
  public void a(View paramView, Object paramObject, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidWidgetListAdapter != null) && (!(this.jdField_a_of_type_AndroidWidgetListAdapter instanceof HeaderViewListAdapter))) {
      throw new IllegalStateException("Cannot add header view to list -- setAdapter has already been called.");
    }
    ListView.FixedViewInfo localFixedViewInfo = new ListView.FixedViewInfo(this);
    localFixedViewInfo.jdField_a_of_type_AndroidViewView = paramView;
    localFixedViewInfo.jdField_a_of_type_JavaLangObject = paramObject;
    localFixedViewInfo.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaUtilArrayList.add(localFixedViewInfo);
    if ((this.jdField_a_of_type_AndroidWidgetListAdapter != null) && (this.jdField_a_of_type_Hzp != null)) {
      this.jdField_a_of_type_Hzp.onChanged();
    }
  }
  
  public boolean a(View paramView)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      if ((this.jdField_a_of_type_AndroidWidgetListAdapter == null) || (!((HeaderViewListAdapter)this.jdField_a_of_type_AndroidWidgetListAdapter).a(paramView))) {
        break label60;
      }
      if (this.jdField_a_of_type_Hzp != null) {
        this.jdField_a_of_type_Hzp.onChanged();
      }
    }
    label60:
    for (boolean bool = true;; bool = false)
    {
      a(paramView, this.jdField_a_of_type_JavaUtilArrayList);
      return bool;
      return false;
    }
  }
  
  public Drawable b()
  {
    return this.jdField_d_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
  }
  
  public void b(View paramView)
  {
    b(paramView, null, true);
  }
  
  public void b(View paramView, Object paramObject, boolean paramBoolean)
  {
    ListView.FixedViewInfo localFixedViewInfo = new ListView.FixedViewInfo(this);
    localFixedViewInfo.jdField_a_of_type_AndroidViewView = paramView;
    localFixedViewInfo.jdField_a_of_type_JavaLangObject = paramObject;
    localFixedViewInfo.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_JavaUtilArrayList.add(localFixedViewInfo);
    if ((this.jdField_a_of_type_AndroidWidgetListAdapter != null) && (this.jdField_a_of_type_Hzp != null)) {
      this.jdField_a_of_type_Hzp.onChanged();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    int m = getChildCount();
    if (paramBoolean) {
      if ((this.mGroupFlags & 0x22) != 34) {
        break label138;
      }
    }
    label138:
    for (int k = f();; k = 0)
    {
      if (m > 0) {
        k = getChildAt(m - 1).getBottom() + this.aG;
      }
      a(this.ap + m, k);
      g(getChildCount());
      return;
      if ((this.mGroupFlags & 0x22) == 34) {}
      for (k = g();; k = 0)
      {
        if (m > 0) {}
        for (k = getChildAt(0).getTop() - this.aG;; k = getHeight() - k)
        {
          b(this.ap - 1, k);
          h(getChildCount());
          return;
        }
      }
    }
  }
  
  public boolean b(View paramView)
  {
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
    {
      if ((this.jdField_a_of_type_AndroidWidgetListAdapter == null) || (!((HeaderViewListAdapter)this.jdField_a_of_type_AndroidWidgetListAdapter).b(paramView))) {
        break label60;
      }
      if (this.jdField_a_of_type_Hzp != null) {
        this.jdField_a_of_type_Hzp.onChanged();
      }
    }
    label60:
    for (boolean bool = true;; bool = false)
    {
      a(paramView, this.jdField_b_of_type_JavaUtilArrayList);
      return bool;
      return false;
    }
  }
  
  @Deprecated
  public long[] b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetListAdapter != null) && (this.jdField_a_of_type_AndroidWidgetListAdapter.hasStableIds())) {
      return a();
    }
    Object localObject;
    int i1;
    long[] arrayOfLong;
    int m;
    int k;
    if ((this.N != 0) && (this.jdField_a_of_type_AndroidUtilSparseBooleanArray != null) && (this.jdField_a_of_type_AndroidWidgetListAdapter != null))
    {
      localObject = this.jdField_a_of_type_AndroidUtilSparseBooleanArray;
      i1 = ((SparseBooleanArray)localObject).size();
      arrayOfLong = new long[i1];
      ListAdapter localListAdapter = this.jdField_a_of_type_AndroidWidgetListAdapter;
      m = 0;
      k = 0;
      if (m < i1)
      {
        if (!((SparseBooleanArray)localObject).valueAt(m)) {
          break label150;
        }
        int n = k + 1;
        arrayOfLong[k] = localListAdapter.getItemId(((SparseBooleanArray)localObject).keyAt(m));
        k = n;
      }
    }
    label150:
    for (;;)
    {
      m += 1;
      break;
      if (k == i1) {
        return arrayOfLong;
      }
      localObject = new long[k];
      System.arraycopy(arrayOfLong, 0, localObject, 0, k);
      return localObject;
      return new long[0];
    }
  }
  
  public Drawable c()
  {
    return this.jdField_e_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public View c()
  {
    return this.jdField_a_of_type_Ibe;
  }
  
  public void c(int paramInt)
  {
    super.c(paramInt);
  }
  
  protected boolean canAnimate()
  {
    return (super.canAnimate()) && (this.aB > 0);
  }
  
  public long d()
  {
    if (this.jdField_g_of_type_Long > 0L) {
      return this.jdField_g_of_type_Long;
    }
    return 350L;
  }
  
  public Drawable d()
  {
    return this.jdField_f_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  void d(int paramInt)
  {
    int k = 1;
    f(paramInt);
    int m = this.aA;
    if (m >= 0) {
      if (paramInt != m - 1) {}
    }
    for (;;)
    {
      i();
      if (k != 0) {
        awakenScrollBars();
      }
      return;
      if (paramInt != m + 1) {
        k = 0;
      }
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    if (this.jdField_f_of_type_Boolean) {
      this.jdField_g_of_type_Boolean = true;
    }
    int i2 = this.aG;
    Drawable localDrawable1 = this.jdField_e_of_type_AndroidGraphicsDrawableDrawable;
    ibe localibe = this.jdField_a_of_type_Ibe;
    Drawable localDrawable2 = this.jdField_f_of_type_AndroidGraphicsDrawableDrawable;
    Drawable localDrawable3 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    int k;
    label66:
    int i1;
    label81:
    label120:
    Rect localRect;
    int i3;
    int i4;
    int i5;
    boolean bool1;
    label258:
    Paint localPaint;
    int i11;
    if ((localDrawable1 != null) || (localibe != null) || (localDrawable3 != null))
    {
      m = 1;
      if (localDrawable2 == null) {
        break label589;
      }
      k = 1;
      if ((i2 <= 0) || (this.jdField_d_of_type_AndroidGraphicsDrawableDrawable == null)) {
        break label594;
      }
      i1 = 1;
      if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        if (this.mScrollY <= 0) {
          break label600;
        }
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, this.mScrollY, getWidth(), getHeight() + this.mScrollY);
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
      if ((i1 == 0) && (m == 0) && (k == 0)) {
        break label741;
      }
      localRect = this.jdField_a_of_type_AndroidGraphicsRect;
      localRect.left = this.mPaddingLeft;
      localRect.right = (this.mRight - this.mLeft - this.mPaddingRight);
      i3 = getChildCount();
      int i6 = this.jdField_a_of_type_JavaUtilArrayList.size();
      i4 = this.aB;
      int i7 = this.jdField_b_of_type_JavaUtilArrayList.size();
      boolean bool2 = this.jdField_c_of_type_Boolean;
      boolean bool3 = this.jdField_d_of_type_Boolean;
      i5 = this.ap;
      boolean bool4 = this.s;
      ListAdapter localListAdapter = this.jdField_a_of_type_AndroidWidgetListAdapter;
      if (!VersionUtils.a()) {
        break label635;
      }
      if ((!isOpaque()) || (super.isOpaque())) {
        break label629;
      }
      bool1 = true;
      if ((bool1) && (this.jdField_a_of_type_AndroidGraphicsPaint == null) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(o());
      }
      localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
      int n = 0;
      if ((this.mGroupFlags & 0x22) == 34) {
        n = this.jdField_c_of_type_AndroidGraphicsRect.bottom;
      }
      int i8 = this.mBottom;
      int i9 = this.mTop;
      int i10 = getScrollY();
      i11 = getScrollY();
      if ((i3 > 0) && (i11 < 0))
      {
        if (m != 0)
        {
          localRect.bottom = (0 - this.aG);
          localRect.top = i11;
          a(paramCanvas, localibe, localDrawable3, localDrawable1, localRect);
        }
        if (i1 != 0)
        {
          localRect.bottom = 0;
          localRect.top = (-i2);
          a(paramCanvas, localRect, -1);
        }
      }
      if (i1 == 0) {
        break label677;
      }
      m = 0;
      label432:
      if (m >= i3) {
        break label677;
      }
      if (((bool2) || (i5 + m >= i6)) && ((bool3) || (i5 + m < i4 - i7 - 1)))
      {
        i1 = getChildAt(m).getBottom();
        if ((i1 < i10 + (i8 - i9 - n)) && ((k == 0) || (m != i3 - 1)))
        {
          if ((!bool4) && ((!localListAdapter.isEnabled(i5 + m)) || ((m != i3 - 1) && (!localListAdapter.isEnabled(i5 + m + 1))))) {
            break label644;
          }
          localRect.top = i1;
          localRect.bottom = (i1 + i2);
          a(paramCanvas, localRect, m);
        }
      }
    }
    for (;;)
    {
      m += 1;
      break label432;
      m = 0;
      break;
      label589:
      k = 0;
      break label66;
      label594:
      i1 = 0;
      break label81;
      label600:
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, -getHeight() - this.mScrollY, getWidth(), getHeight());
      break label120;
      label629:
      bool1 = false;
      break label258;
      label635:
      bool1 = isOpaque();
      break label258;
      label644:
      if (bool1)
      {
        localRect.top = i1;
        localRect.bottom = (i1 + i2);
        paramCanvas.drawRect(localRect, localPaint);
      }
    }
    label677:
    int m = this.mBottom + i11 + this.aG;
    if ((k != 0) && (i5 + i3 == i4) && (m > this.mBottom))
    {
      localRect.top = (this.mBottom + this.aG);
      localRect.bottom = m;
      a(paramCanvas, localDrawable2, localRect);
    }
    label741:
    super.dispatchDraw(paramCanvas);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool2 = super.dispatchKeyEvent(paramKeyEvent);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (getFocusedChild() != null)
      {
        bool1 = bool2;
        if (paramKeyEvent.getAction() == 0) {
          bool1 = onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent);
        }
      }
    }
    return bool1;
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    if (this.jdField_g_of_type_Boolean) {
      this.jdField_g_of_type_Boolean = false;
    }
    return bool;
  }
  
  boolean f(int paramInt)
  {
    boolean bool;
    if (paramInt == 33)
    {
      paramInt = Math.max(0, this.aA - getChildCount() - 1);
      bool = false;
    }
    for (;;)
    {
      if (paramInt >= 0)
      {
        paramInt = a(paramInt, bool);
        if (paramInt >= 0)
        {
          this.P = 4;
          this.aq = (this.mPaddingTop + getVerticalFadingEdgeLength());
          if ((bool) && (paramInt > this.aB - getChildCount())) {
            this.P = 3;
          }
          if ((!bool) && (paramInt < getChildCount())) {
            this.P = 1;
          }
          d(paramInt);
          f();
          if (!awakenScrollBars()) {
            invalidate();
          }
          return true;
          if (paramInt != 130) {
            break label153;
          }
          paramInt = Math.min(this.aB - 1, this.aA + getChildCount() - 1);
          bool = true;
          continue;
        }
      }
      return false;
      label153:
      paramInt = -1;
      bool = false;
    }
  }
  
  boolean g(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramInt == 33)
    {
      if (this.aA == 0) {
        break label123;
      }
      paramInt = a(0, true);
      bool1 = bool2;
      if (paramInt >= 0)
      {
        this.P = 1;
        d(paramInt);
        f();
        bool1 = bool2;
      }
    }
    for (;;)
    {
      if ((bool1) && (!awakenScrollBars()))
      {
        awakenScrollBars();
        invalidate();
      }
      return bool1;
      if ((paramInt == 130) && (this.aA < this.aB - 1))
      {
        paramInt = a(this.aB - 1, true);
        bool1 = bool2;
        if (paramInt >= 0)
        {
          this.P = 3;
          d(paramInt);
          f();
          bool1 = bool2;
        }
      }
      else
      {
        label123:
        bool1 = false;
      }
    }
  }
  
  void h()
  {
    a(this.jdField_a_of_type_JavaUtilArrayList);
    a(this.jdField_b_of_type_JavaUtilArrayList);
    super.h();
    this.P = 0;
  }
  
  boolean h(int paramInt)
  {
    try
    {
      this.o = true;
      boolean bool = d(paramInt);
      if (bool) {
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
      }
      return bool;
    }
    finally
    {
      this.o = false;
    }
  }
  
  protected void i()
  {
    boolean bool1 = this.q;
    if (!bool1)
    {
      this.q = true;
      a("ListView.layoutChildren");
    }
    int m;
    int i1;
    int i3;
    int i2;
    int k;
    View localView1;
    View localView3;
    Object localObject5;
    int n;
    View localView2;
    label230:
    boolean bool2;
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
      m = this.jdField_c_of_type_AndroidGraphicsRect.top;
      i1 = this.mBottom - this.mTop - this.jdField_c_of_type_AndroidGraphicsRect.bottom;
      i3 = getChildCount();
      i2 = this.ap + i3 - 1;
      k = 0;
      localView1 = null;
      localView3 = null;
      localObject5 = null;
      switch (this.P)
      {
      case 2: 
        n = this.aA - this.ap;
        Object localObject1 = localView1;
        if (n >= 0)
        {
          localObject1 = localView1;
          if (n < i3) {
            localObject1 = getChildAt(n);
          }
        }
        localView2 = getChildAt(0);
        localView1 = getChildAt(i3 - 1);
        if (this.az >= 0) {
          k = this.az - this.aA;
        }
        localView3 = getChildAt(n + k);
        for (;;)
        {
          bool2 = this.p;
          if (bool2) {
            p();
          }
          if (this.aB != 0) {
            break;
          }
          h();
          f();
          return;
          k = this.az - this.ap;
          if ((k < 0) || (k >= i3)) {
            break label1477;
          }
          localView3 = getChildAt(k);
          localView1 = null;
          localView2 = null;
          localObject1 = null;
          k = 0;
        }
        if (this.aB != this.jdField_a_of_type_AndroidWidgetListAdapter.getCount())
        {
          localObject1 = this.jdField_a_of_type_AndroidWidgetListAdapter.getClass();
          if ((this.jdField_a_of_type_AndroidWidgetListAdapter instanceof HeaderViewListAdapter)) {
            localObject1 = ((HeaderViewListAdapter)this.jdField_a_of_type_AndroidWidgetListAdapter).getWrappedAdapter().getClass();
          }
          throw new IllegalStateException("The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(" + getId() + ", " + getClass() + ") with Adapter(" + localObject1 + ")]");
        }
        break;
      }
    }
    finally
    {
      if (!bool1) {
        this.q = false;
      }
      A();
    }
    e(this.az);
    int i4 = this.ap;
    hzz localhzz = this.jdField_a_of_type_Hzz;
    Object localObject4 = null;
    if (bool2)
    {
      n = 0;
      while (n < i3)
      {
        localhzz.a(getChildAt(n), i4 + n);
        n += 1;
      }
    }
    localhzz.a(i3, i4);
    Object localObject6 = getFocusedChild();
    label554:
    label571:
    Object localObject3;
    if (localObject6 != null)
    {
      if ((!bool2) || (c((View)localObject6)))
      {
        localObject5 = findFocus();
        if (localObject5 == null) {
          break label1508;
        }
        ((View)localObject5).onStartTemporaryDetach();
        break label1508;
      }
      requestFocus();
      localObject6 = localObject4;
      localObject4 = localObject5;
      localObject5 = localObject6;
      detachAllViewsFromParent();
      switch (this.P)
      {
      case 2: 
        label644:
        if (i3 == 0) {
          if (!this.h)
          {
            e(a(0, true));
            localObject3 = a(m);
            label673:
            b();
            localhzz.c();
            if (localObject3 == null) {
              break label1368;
            }
            if ((!this.t) || (!hasFocus()) || (((View)localObject3).hasFocus())) {
              break label1358;
            }
            if ((localObject3 == localObject5) && (localObject4.requestFocus())) {
              break label1518;
            }
            if (!((View)localObject3).requestFocus()) {
              break label1530;
            }
          }
        }
        break;
      }
    }
    for (;;)
    {
      label735:
      if (k == 0)
      {
        localView1 = getFocusedChild();
        if (localView1 != null) {
          localView1.clearFocus();
        }
        a(-1, (View)localObject3);
        label762:
        this.ae = ((View)localObject3).getTop();
        if ((localObject4 != null) && (localObject4.getWindowToken() != null)) {
          localObject4.onFinishTemporaryDetach();
        }
        this.P = 0;
        this.p = false;
        this.n = false;
        f(this.aA);
        j();
        if (this.aB > 0) {
          x();
        }
        f();
        m = this.ap + getChildCount() - 1;
        if ((this.jdField_a_of_type_AndroidViewAnimationAnimation == null) || (this.jdField_a_of_type_ArrayOfInt == null) || (!bool2) || (this.aB <= 0) || (m < this.aB - 1) || (getChildAt(getChildCount() - 1).getBottom() >= i1)) {
          break label1449;
        }
        localObject3 = this.jdField_a_of_type_ArrayOfInt;
        n = localObject3.length;
        k = 0;
      }
      for (;;)
      {
        label771:
        if (k < n)
        {
          i1 = localObject3[k];
          if ((i1 < this.ap) || (i1 > m)) {
            break label1523;
          }
          getChildAt(i1 - this.ap).startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
          break label1523;
          if (localView3 != null)
          {
            localObject3 = a(localView3.getTop(), m, i1);
            break label673;
          }
          localObject3 = c(m, i1);
          break label673;
          if (!this.h)
          {
            localObject3 = e(this.as, this.aq);
            break label673;
          }
          localObject3 = d(this.as, this.au - this.ar);
          break label673;
          localObject3 = b(this.aB - 1, i1);
          c();
          break label673;
          this.ap = 0;
          localObject3 = a(m);
          c();
          break label673;
          localObject3 = e(m(), this.aq);
          break label673;
          localObject3 = d(m(), this.au - this.ar);
          break label673;
          localObject3 = a((View)localObject3, localView3, k, m, i1);
          break label673;
          e(a(this.aB - 1, false));
          localObject3 = b(this.aB - 1, i1);
          break label673;
          if ((this.aA >= 0) && (this.aA < this.aB))
          {
            k = this.aA;
            if (localObject3 == null) {}
            for (;;)
            {
              localObject3 = e(k, m);
              break;
              m = ((View)localObject3).getTop();
            }
          }
          if (((this.mScrollY == 0) && (!this.h)) || (this.mScrollY < 0))
          {
            if (this.ap < this.aB)
            {
              k = this.ap;
              if (localView2 == null) {}
              for (;;)
              {
                localObject3 = e(k, m);
                break;
                m = localView2.getTop();
              }
            }
            localObject3 = e(0, m);
            break label673;
          }
          if (i2 < this.aB)
          {
            if (localView1 == null) {}
            for (k = i1;; k = localView1.getBottom())
            {
              localObject3 = d(i2, k);
              break;
            }
          }
          localObject3 = d(this.aB - 1, this.au);
          break label673;
          ((View)localObject3).setSelected(false);
          this.jdField_b_of_type_AndroidGraphicsRect.setEmpty();
          break label762;
          label1358:
          a(-1, (View)localObject3);
          break label762;
          label1368:
          if ((this.ab > 0) && (this.ab < 3))
          {
            localObject3 = getChildAt(this.W - this.ap);
            if (localObject3 != null) {
              a(this.W, (View)localObject3);
            }
          }
          for (;;)
          {
            if ((!hasFocus()) || (localObject4 == null)) {
              break label1447;
            }
            localObject4.requestFocus();
            break;
            this.ae = 0;
            this.jdField_b_of_type_AndroidGraphicsRect.setEmpty();
          }
          label1447:
          break label771;
        }
        label1449:
        this.jdField_a_of_type_ArrayOfInt = null;
        if (!bool1) {
          this.q = false;
        }
        A();
        return;
        localObject4 = null;
        localObject5 = null;
        break label571;
        label1477:
        localView1 = null;
        localView2 = null;
        localObject3 = null;
        k = 0;
        break label230;
        break;
        localView1 = null;
        localView2 = null;
        localObject3 = null;
        k = 0;
        break label230;
        label1508:
        localObject4 = localObject6;
        break label554;
        break label644;
        label1518:
        k = 1;
        break label735;
        label1523:
        k += 1;
      }
      label1530:
      k = 0;
    }
  }
  
  public ViewParent invalidateChildInParent(int[] paramArrayOfInt, Rect paramRect)
  {
    paramArrayOfInt = super.invalidateChildInParent(paramArrayOfInt, paramRect);
    int k;
    if ((paramRect.bottom > 0) && (paramRect.top < getHeight()))
    {
      k = getScrollY();
      if ((k >= 0) || (paramRect.top + k >= 0)) {
        break label50;
      }
      a(paramRect);
    }
    label50:
    while ((k <= 0) || (paramRect.bottom <= getHeight() - k)) {
      return paramArrayOfInt;
    }
    a(paramRect);
    return paramArrayOfInt;
  }
  
  public boolean isOpaque()
  {
    return false;
  }
  
  protected int j()
  {
    int m = 0;
    int n = getScrollY();
    int k = m;
    boolean bool;
    if (this.jdField_a_of_type_Ibe != null)
    {
      k = m;
      if (n < 0)
      {
        if (n > -t()) {
          break label101;
        }
        if (this.aL != 2) {
          break label157;
        }
        if (this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener == null) {
          break label151;
        }
        bool = this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener.a(0, this.jdField_a_of_type_Ibe.getChildAt(0), this);
        this.aL = 3;
      }
    }
    for (;;)
    {
      if (bool)
      {
        k = m;
        if (this.jdField_a_of_type_Ibe != null) {
          k = -t();
        }
      }
      label101:
      do
      {
        return k;
        this.aL = 0;
        return 0;
        if (this.aL < 2) {
          break;
        }
        k = m;
      } while (!this.r);
      if (this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener != null) {
        this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener.c(0, this.jdField_a_of_type_Ibe.getChildAt(0), this);
      }
      this.aL = 0;
      return 0;
      label151:
      bool = false;
      break;
      label157:
      bool = false;
    }
  }
  
  public int k()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int l()
  {
    return this.jdField_b_of_type_JavaUtilArrayList.size();
  }
  
  @ViewDebug.ExportedProperty(category="list")
  protected boolean o()
  {
    return true;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    int m = getChildCount();
    if (m > 0)
    {
      int k = 0;
      while (k < m)
      {
        a(getChildAt(k));
        k += 1;
      }
      removeAllViews();
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    int n = 0;
    int m = 0;
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    ListAdapter localListAdapter = this.jdField_a_of_type_AndroidWidgetListAdapter;
    int k = -1;
    int i2 = n;
    int i3 = k;
    Rect localRect;
    int i1;
    if (localListAdapter != null)
    {
      i2 = n;
      i3 = k;
      if (paramBoolean)
      {
        i2 = n;
        i3 = k;
        if (paramRect != null)
        {
          paramRect.offset(getScrollX(), getScrollY());
          if (localListAdapter.getCount() < getChildCount() + this.ap)
          {
            this.P = 0;
            i();
          }
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          i1 = 2147483647;
          int i4 = getChildCount();
          int i5 = this.ap;
          n = 0;
          i2 = m;
          i3 = k;
          if (n < i4) {
            if (!localListAdapter.isEnabled(i5 + n))
            {
              i2 = m;
              m = k;
              k = i2;
            }
          }
        }
      }
    }
    for (;;)
    {
      i2 = n + 1;
      n = m;
      m = k;
      k = n;
      n = i2;
      break;
      View localView = getChildAt(n);
      localView.getDrawingRect(localRect);
      offsetDescendantRectToMyCoords(localView, localRect);
      i2 = a(paramRect, localRect, paramInt);
      if (i2 < i1)
      {
        k = localView.getTop();
        m = n;
        i1 = i2;
        continue;
        if (i3 >= 0)
        {
          setSelectionFromTop(this.ap + i3, i2);
          return;
        }
        requestLayout();
      }
      else
      {
        i2 = k;
        k = m;
        m = i2;
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    d();
    return bool;
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
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_Ibe != null)
    {
      this.jdField_a_of_type_Ibe.layout(this.jdField_c_of_type_AndroidGraphicsRect.left, this.jdField_c_of_type_AndroidGraphicsRect.top, this.jdField_c_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_Ibe.getMeasuredWidth(), this.jdField_a_of_type_Ibe.getMeasuredHeight());
      this.al = this.jdField_a_of_type_Ibe.getHeight();
    }
  }
  
  @TargetApi(11)
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i3 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getMode(paramInt2);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int n = View.MeasureSpec.getSize(paramInt2);
    int k;
    int m;
    if (this.jdField_a_of_type_AndroidWidgetListAdapter == null)
    {
      paramInt2 = 0;
      this.aB = paramInt2;
      if ((this.aB <= 0) || ((i3 != 0) && (i2 != 0))) {
        break label332;
      }
      View localView = a(0, this.jdField_a_of_type_ArrayOfBoolean);
      a(localView, 0, paramInt1);
      k = localView.getMeasuredWidth();
      m = localView.getMeasuredHeight();
      if (!VersionUtils.e()) {
        break label327;
      }
      paramInt2 = combineMeasuredStates(0, localView.getMeasuredState());
      label109:
      if ((o()) && (this.jdField_a_of_type_Hzz.a(((AbsListView.LayoutParams)localView.getLayoutParams()).jdField_a_of_type_Int))) {
        this.jdField_a_of_type_Hzz.a(localView, -1);
      }
    }
    for (;;)
    {
      if (i3 == 0) {
        paramInt2 = k + (this.jdField_c_of_type_AndroidGraphicsRect.left + this.jdField_c_of_type_AndroidGraphicsRect.right) + getVerticalScrollbarWidth();
      }
      for (;;)
      {
        k = n;
        if (i2 == 0) {
          k = this.jdField_c_of_type_AndroidGraphicsRect.top + this.jdField_c_of_type_AndroidGraphicsRect.bottom + m + getVerticalFadingEdgeLength() * 2;
        }
        m = k;
        if (i2 == -2147483648) {
          m = a(paramInt1, 0, -1, k, -1);
        }
        setMeasuredDimension(paramInt2, m);
        this.V = paramInt1;
        if (this.jdField_a_of_type_Ibe != null)
        {
          paramInt1 = ViewGroup.getChildMeasureSpec(this.V, this.jdField_c_of_type_AndroidGraphicsRect.left + this.jdField_c_of_type_AndroidGraphicsRect.right, -1);
          paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
          this.jdField_a_of_type_Ibe.measure(paramInt1, paramInt2);
        }
        return;
        paramInt2 = this.jdField_a_of_type_AndroidWidgetListAdapter.getCount();
        break;
        if (VersionUtils.e()) {
          paramInt2 = 0xFF000000 & paramInt2 | i1;
        } else {
          paramInt2 = i1;
        }
      }
      label327:
      paramInt2 = 0;
      break label109;
      label332:
      paramInt2 = 0;
      m = 0;
      k = 0;
    }
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 < 0) && (paramInt4 == 0) && (this.jdField_a_of_type_Ibe != null)) {
      f(this.jdField_a_of_type_Ibe);
    }
    while ((paramInt2 != 0) || (paramInt4 >= 0) || (this.jdField_a_of_type_Ibe == null)) {
      return;
    }
    g(this.jdField_a_of_type_Ibe);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() > 0)
    {
      View localView = getFocusedChild();
      if (localView != null)
      {
        int k = this.ap;
        int m = indexOfChild(localView);
        int n = Math.max(0, localView.getBottom() - (paramInt2 - this.mPaddingTop));
        int i1 = localView.getTop();
        if (this.jdField_a_of_type_Ibc == null) {
          this.jdField_a_of_type_Ibc = new ibc(this, null);
        }
        post(this.jdField_a_of_type_Ibc.a(k + m, i1 - n));
      }
      D();
    }
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onThemeChanged()
  {
    this.jdField_a_of_type_Hzz.b();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      SkinEngine.invalidateAll(((ListView.FixedViewInfo)localIterator.next()).jdField_a_of_type_AndroidViewView);
    }
    localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      SkinEngine.invalidateAll(((ListView.FixedViewInfo)localIterator.next()).jdField_a_of_type_AndroidViewView);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int k = paramMotionEvent.getAction() & 0xFF;
    if (k == 0) {}
    for (this.u = true;; this.u = false) {
      do
      {
        boolean bool = super.onTouchEvent(paramMotionEvent);
        d();
        return bool;
      } while ((k != 1) && (k != 3));
    }
  }
  
  public boolean p()
  {
    return this.t;
  }
  
  public boolean q()
  {
    return (this.mScrollY < 0) && (this.jdField_a_of_type_Ibe != null);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    int i2 = paramRect.top;
    paramRect.offset(paramView.getLeft(), paramView.getTop());
    paramRect.offset(-paramView.getScrollX(), -paramView.getScrollY());
    int i1 = getHeight();
    int m = getScrollY();
    int n = m + i1;
    int i3 = getVerticalFadingEdgeLength();
    int k = m;
    if (r()) {
      if (this.aA <= 0)
      {
        k = m;
        if (i2 <= i3) {}
      }
      else
      {
        k = m + i3;
      }
    }
    i2 = getChildAt(getChildCount() - 1).getBottom();
    m = n;
    if (s()) {
      if (this.aA >= this.aB - 1)
      {
        m = n;
        if (paramRect.bottom >= i2 - i3) {}
      }
      else
      {
        m = n - i3;
      }
    }
    if ((paramRect.bottom > m) && (paramRect.top > k)) {
      if (paramRect.height() > i1)
      {
        k = paramRect.top - k + 0;
        k = Math.min(k, i2 - m);
      }
    }
    for (;;)
    {
      if (k != 0) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        if (paramBoolean)
        {
          i(-k);
          a(-1, paramView);
          this.ae = paramView.getTop();
          invalidate();
        }
        return paramBoolean;
        k = paramRect.bottom - m + 0;
        break;
        if ((paramRect.top >= k) || (paramRect.bottom >= m)) {
          break label335;
        }
        if (paramRect.height() > i1) {}
        for (m = 0 - (m - paramRect.bottom);; m = 0 - (k - paramRect.top))
        {
          k = Math.max(m, getChildAt(0).getTop() - k);
          break;
        }
      }
      label335:
      k = 0;
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if ((this.jdField_a_of_type_AndroidWidgetListAdapter != null) && (this.jdField_a_of_type_Hzp != null)) {
      this.jdField_a_of_type_AndroidWidgetListAdapter.unregisterDataSetObserver(this.jdField_a_of_type_Hzp);
    }
    h();
    this.jdField_a_of_type_Hzz.b();
    int k;
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) || (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetListAdapter = new HeaderViewListAdapter(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_JavaUtilArrayList, paramListAdapter);
      this.aE = -1;
      this.jdField_f_of_type_Long = -9223372036854775808L;
      super.setAdapter(paramListAdapter);
      if (this.jdField_a_of_type_AndroidWidgetListAdapter == null) {
        break label244;
      }
      this.s = this.jdField_a_of_type_AndroidWidgetListAdapter.areAllItemsEnabled();
      this.aC = this.aB;
      this.aB = this.jdField_a_of_type_AndroidWidgetListAdapter.getCount();
      w();
      this.jdField_a_of_type_Hzp = new ibd(this);
      this.jdField_a_of_type_AndroidWidgetListAdapter.registerDataSetObserver(this.jdField_a_of_type_Hzp);
      this.jdField_a_of_type_Hzz.a(this.jdField_a_of_type_AndroidWidgetListAdapter.getViewTypeCount());
      if (!this.h) {
        break label234;
      }
      k = a(this.aB - 1, false);
      label200:
      e(k);
      f(k);
      if (this.aB == 0) {
        x();
      }
    }
    for (;;)
    {
      requestLayout();
      return;
      this.jdField_a_of_type_AndroidWidgetListAdapter = paramListAdapter;
      break;
      label234:
      k = a(0, true);
      break label200;
      label244:
      this.s = true;
      w();
      x();
    }
  }
  
  public void setCacheColorHint(int paramInt)
  {
    if (paramInt >>> 24 == 255) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (bool)
      {
        if (this.jdField_a_of_type_AndroidGraphicsPaint == null) {
          this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
        }
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
      }
      super.setCacheColorHint(paramInt);
      return;
    }
  }
  
  public void setContentBackground(int paramInt)
  {
    setContentBackground(getContext().getResources().getDrawable(paramInt));
  }
  
  public void setContentBackground(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      return;
    }
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838101);
  }
  
  public void setDelAnimationDuration(long paramLong)
  {
    if (paramLong > 0L) {
      this.jdField_g_of_type_Long = paramLong;
    }
  }
  
  public void setDivider(Drawable paramDrawable)
  {
    boolean bool = false;
    if (paramDrawable != null)
    {
      this.aG = paramDrawable.getIntrinsicHeight();
      if (this.aG >= 0) {
        break label69;
      }
    }
    label69:
    for (int k = 0;; k = this.aG)
    {
      this.aG = k;
      this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      if ((paramDrawable == null) || (paramDrawable.getOpacity() == -1)) {
        bool = true;
      }
      this.jdField_b_of_type_Boolean = bool;
      requestLayout();
      invalidate();
      return;
      this.aG = 0;
      break;
    }
  }
  
  public void setDividerHeight(int paramInt)
  {
    this.aG = paramInt;
    requestLayout();
    invalidate();
  }
  
  public void setFooterDividersEnabled(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  public void setHeaderDividersEnabled(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  public void setInsertAnimation(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidViewAnimationAnimation = paramAnimation;
  }
  
  public void setItemsCanFocus(boolean paramBoolean)
  {
    this.t = paramBoolean;
    if (!paramBoolean) {
      setDescendantFocusability(393216);
    }
  }
  
  public void setOverScrollHeader(View paramView)
  {
    this.ak = 2147483647;
    if (paramView == null) {
      if (this.jdField_a_of_type_Ibe != null)
      {
        this.jdField_a_of_type_Ibe.removeAllViewsInLayout();
        ibe.a(this.jdField_a_of_type_Ibe, null);
        this.jdField_a_of_type_Ibe = null;
      }
    }
    for (;;)
    {
      this.aL = 0;
      this.mScrollY = 0;
      return;
      if (this.jdField_a_of_type_Ibe == null)
      {
        this.jdField_a_of_type_Ibe = new ibe(getContext());
        ibe.a(this.jdField_a_of_type_Ibe, this);
      }
      this.jdField_a_of_type_Ibe.removeAllViewsInLayout();
      this.jdField_a_of_type_Ibe.addView(paramView);
    }
  }
  
  public void setOverScrollHeight(int paramInt)
  {
    this.aM = paramInt;
  }
  
  public void setOverScrollListener(OverScrollViewListener paramOverScrollViewListener)
  {
    this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener = paramOverScrollViewListener;
  }
  
  public void setOverscrollFooter(Drawable paramDrawable)
  {
    this.jdField_f_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    invalidate();
  }
  
  public void setOverscrollHeader(Drawable paramDrawable)
  {
    this.jdField_e_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (getScrollY() < 0) {
      invalidate();
    }
  }
  
  public void setSelection(int paramInt)
  {
    setSelectionFromTop(paramInt, 0);
  }
  
  public void setSelectionAfterHeaderView()
  {
    int k = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (k > 0)
    {
      this.az = 0;
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetListAdapter != null)
    {
      setSelection(k);
      return;
    }
    this.az = k;
    this.P = 2;
  }
  
  public void setSelectionFromBottom(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidWidgetListAdapter == null) {}
    for (;;)
    {
      return;
      if (!isInTouchMode())
      {
        int k = a(paramInt1, true);
        paramInt1 = k;
        if (k >= 0)
        {
          f(k);
          paramInt1 = k;
        }
      }
      while (paramInt1 >= 0)
      {
        requestLayout();
        this.P = 100;
        if (this.n)
        {
          this.as = paramInt1;
          this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(paramInt1);
        }
        this.ar = (this.jdField_c_of_type_AndroidGraphicsRect.bottom + paramInt2);
        return;
        this.af = paramInt1;
      }
    }
  }
  
  public void setSelectionFromTop(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidWidgetListAdapter == null) {}
    for (;;)
    {
      return;
      if (!isInTouchMode())
      {
        int k = a(paramInt1, true);
        paramInt1 = k;
        if (k >= 0)
        {
          f(k);
          paramInt1 = k;
        }
      }
      while (paramInt1 >= 0)
      {
        requestLayout();
        this.P = 4;
        if (this.n)
        {
          this.as = paramInt1;
          this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(paramInt1);
        }
        this.aq = (this.jdField_c_of_type_AndroidGraphicsRect.top + paramInt2);
        return;
        this.af = paramInt1;
      }
    }
  }
  
  public int t()
  {
    if ((this.aM == 0) && (this.jdField_a_of_type_Ibe != null)) {
      return this.jdField_a_of_type_Ibe.getHeight();
    }
    return this.aM;
  }
  
  public int u()
  {
    return (int)(0.33F * (getBottom() - this.mTop));
  }
  
  public int v()
  {
    return this.aG;
  }
  
  public int w()
  {
    return this.aL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.widget.ListView
 * JD-Core Version:    0.7.0.1
 */