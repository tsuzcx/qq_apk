package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ListAdapter;
import fki;
import java.util.ArrayList;

public class ExpandableListView
  extends ListView
{
  private static final int jdField_a_of_type_Int = a("ExpandableListView_childDivider");
  private static final int[] jdField_a_of_type_ArrayOfInt;
  private static final int[][] jdField_a_of_type_Array2dOfInt = { jdField_a_of_type_ArrayOfInt, jdField_b_of_type_ArrayOfInt, c, d };
  private static final int jdField_b_of_type_Int = a("ExpandableListView_childIndicatorRight");
  private static final int[] jdField_b_of_type_ArrayOfInt;
  public static final int c = 0;
  private static final int[] c;
  public static final int d = 1;
  private static final int[] d;
  public static final int e = 2;
  private static final int[] e = { 16842918 };
  public static final int f = -1;
  private static final int jdField_g_of_type_Int = a("ExpandableListView_childIndicatorLeft");
  public static final long g = 4294967295L;
  private static final int jdField_h_of_type_Int;
  private static final long jdField_h_of_type_Long = 4294967295L;
  private static final int jdField_i_of_type_Int;
  private static final long jdField_i_of_type_Long = 9223372032559808512L;
  private static final int jdField_j_of_type_Int;
  private static final long jdField_j_of_type_Long = -9223372036854775808L;
  private static final int jdField_k_of_type_Int;
  private static final long jdField_k_of_type_Long = 32L;
  private static final long jdField_l_of_type_Long = 63L;
  private static final long jdField_m_of_type_Long = -1L;
  private static final long jdField_n_of_type_Long = 2147483647L;
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ExpandableListAdapter jdField_a_of_type_AndroidWidgetExpandableListAdapter;
  private ExpandableListConnector jdField_a_of_type_ComTencentWidgetExpandableListConnector;
  private ExpandableListView.OnChildClickListener jdField_a_of_type_ComTencentWidgetExpandableListView$OnChildClickListener;
  private ExpandableListView.OnGroupClickListener jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupClickListener;
  private ExpandableListView.OnGroupCollapseListener jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupCollapseListener;
  private ExpandableListView.OnGroupExpandListener jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupExpandListener;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private Drawable jdField_g_of_type_AndroidGraphicsDrawableDrawable;
  private int jdField_l_of_type_Int;
  private int jdField_m_of_type_Int;
  private int jdField_n_of_type_Int;
  private int o;
  
  static
  {
    h = a("ExpandableListView_indicatorRight");
    jdField_i_of_type_Int = a("ExpandableListView_indicatorLeft");
    j = a("ExpandableListView_childIndicator");
    k = a("ExpandableListView_groupIndicator");
    jdField_a_of_type_ArrayOfInt = new int[0];
    jdField_b_of_type_ArrayOfInt = new int[] { 16842920 };
    c = new int[] { 16842921 };
    d = new int[] { 16842920, 16842921 };
  }
  
  public ExpandableListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842863);
  }
  
  public ExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new TypedArrayWarpper(paramContext.obtainStyledAttributes(paramAttributeSet, a("ExpandableListView"), paramInt, 0));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.a(k);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.a(j);
    this.l = paramContext.e(jdField_i_of_type_Int, 0);
    this.m = paramContext.e(h, 0);
    if ((this.m == 0) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {
      this.m = (this.l + this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth());
    }
    this.n = paramContext.e(jdField_g_of_type_Int, -1);
    this.o = paramContext.e(jdField_b_of_type_Int, -1);
    this.jdField_g_of_type_AndroidGraphicsDrawableDrawable = paramContext.a(jdField_a_of_type_Int);
    paramContext.a();
  }
  
  private long a(fki paramfki)
  {
    if (paramfki.f == 1) {
      return this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.getChildId(paramfki.c, paramfki.d);
    }
    return this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.getGroupId(paramfki.c);
  }
  
  private Drawable a(ExpandableListConnector.PositionMetadata paramPositionMetadata)
  {
    int i2 = 1;
    int i3 = 0;
    Drawable localDrawable;
    if (paramPositionMetadata.jdField_a_of_type_Fki.f == 2)
    {
      localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if ((localDrawable != null) && (localDrawable.isStateful()))
      {
        int i1;
        if ((paramPositionMetadata.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata == null) || (paramPositionMetadata.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata.c == paramPositionMetadata.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata.jdField_b_of_type_Int))
        {
          i1 = 1;
          if (!paramPositionMetadata.a()) {
            break label97;
          }
        }
        for (;;)
        {
          if (i1 != 0) {
            i3 = 2;
          }
          localDrawable.setState(jdField_a_of_type_Array2dOfInt[(i2 | i3)]);
          return localDrawable;
          i1 = 0;
          break;
          label97:
          i2 = 0;
        }
      }
    }
    else
    {
      localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      if ((localDrawable != null) && (localDrawable.isStateful())) {
        if (paramPositionMetadata.jdField_a_of_type_Fki.e != paramPositionMetadata.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata.c) {
          break label152;
        }
      }
      label152:
      for (paramPositionMetadata = e;; paramPositionMetadata = jdField_a_of_type_ArrayOfInt)
      {
        localDrawable.setState(paramPositionMetadata);
        return localDrawable;
      }
    }
    return localDrawable;
  }
  
  public static int b(long paramLong)
  {
    if (paramLong == 4294967295L) {
      return 2;
    }
    if ((paramLong & 0x0) == -9223372036854775808L) {
      return 1;
    }
    return 0;
  }
  
  public static long b(int paramInt1, int paramInt2)
  {
    return 0x0 | (paramInt1 & 0x7FFFFFFF) << 32 | paramInt2 & 0xFFFFFFFF;
  }
  
  private int c(int paramInt)
  {
    return paramInt - k();
  }
  
  public static int c(long paramLong)
  {
    if (paramLong == 4294967295L) {
      return -1;
    }
    return (int)((0x0 & paramLong) >> 32);
  }
  
  public static long c(int paramInt)
  {
    return (paramInt & 0x7FFFFFFF) << 32;
  }
  
  private int d(int paramInt)
  {
    return k() + paramInt;
  }
  
  public static int d(long paramLong)
  {
    if (paramLong == 4294967295L) {}
    while ((paramLong & 0x0) != -9223372036854775808L) {
      return -1;
    }
    return (int)(paramLong & 0xFFFFFFFF);
  }
  
  private boolean i(int paramInt)
  {
    int i1 = this.aA;
    int i2 = l();
    return (paramInt < k()) || (paramInt >= i1 - i2);
  }
  
  public int a(long paramLong)
  {
    ExpandableListConnector.PositionMetadata localPositionMetadata = this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a(fki.a(paramLong));
    int i1 = localPositionMetadata.jdField_a_of_type_Fki.e;
    localPositionMetadata.a();
    return d(i1);
  }
  
  ContextMenu.ContextMenuInfo a(View paramView, int paramInt, long paramLong)
  {
    if (i(paramInt)) {
      return new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
    }
    paramInt = c(paramInt);
    ExpandableListConnector.PositionMetadata localPositionMetadata = this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a(paramInt);
    fki localfki = localPositionMetadata.jdField_a_of_type_Fki;
    localPositionMetadata.a();
    paramLong = a(localfki);
    long l1 = localfki.a();
    localfki.a();
    return new ExpandableListView.ExpandableListContextMenuInfo(paramView, l1, paramLong);
  }
  
  public ExpandableListAdapter a()
  {
    return this.jdField_a_of_type_AndroidWidgetExpandableListAdapter;
  }
  
  public ListAdapter a()
  {
    return super.a();
  }
  
  void a(Canvas paramCanvas, Rect paramRect, int paramInt)
  {
    paramInt = this.ao + paramInt;
    if (paramInt >= 0)
    {
      int i1 = c(paramInt);
      ExpandableListConnector.PositionMetadata localPositionMetadata = this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a(i1);
      if ((localPositionMetadata.jdField_a_of_type_Fki.f == 1) || ((localPositionMetadata.a()) && (localPositionMetadata.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata.c != localPositionMetadata.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata.jdField_b_of_type_Int)))
      {
        Drawable localDrawable = this.jdField_g_of_type_AndroidGraphicsDrawableDrawable;
        if (localDrawable != null)
        {
          localDrawable.setBounds(paramRect);
          localDrawable.draw(paramCanvas);
        }
        localPositionMetadata.a();
        return;
      }
      localPositionMetadata.a();
    }
    super.a(paramCanvas, paramRect, paramInt);
  }
  
  public boolean a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    fki localfki = fki.a(paramInt1, paramInt2);
    ExpandableListConnector.PositionMetadata localPositionMetadata2 = this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a(localfki);
    ExpandableListConnector.PositionMetadata localPositionMetadata1 = localPositionMetadata2;
    if (localPositionMetadata2 == null)
    {
      if (!paramBoolean) {
        return false;
      }
      c(paramInt1);
      localPositionMetadata2 = this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a(localfki);
      localPositionMetadata1 = localPositionMetadata2;
      if (localPositionMetadata2 == null) {
        throw new IllegalStateException("Could not find child");
      }
    }
    super.setSelection(d(localPositionMetadata1.jdField_a_of_type_Fki.e));
    localfki.a();
    localPositionMetadata1.a();
    return true;
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    ExpandableListConnector.PositionMetadata localPositionMetadata = this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a(fki.a(2, paramInt, -1, -1));
    boolean bool = this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.b(localPositionMetadata);
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupExpandListener != null) {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupExpandListener.a(paramInt);
    }
    if (paramBoolean)
    {
      int i1 = localPositionMetadata.jdField_a_of_type_Fki.e + k();
      d(this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.getChildrenCount(paramInt) + i1, i1);
    }
    localPositionMetadata.a();
    return bool;
  }
  
  public boolean a(View paramView, int paramInt, long paramLong)
  {
    if (i(paramInt)) {
      return super.a(paramView, paramInt, paramLong);
    }
    return c(paramView, c(paramInt), paramLong);
  }
  
  public long b()
  {
    return b(p());
  }
  
  public long b(int paramInt)
  {
    if (i(paramInt)) {
      return 4294967295L;
    }
    paramInt = c(paramInt);
    ExpandableListConnector.PositionMetadata localPositionMetadata = this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a(paramInt);
    long l1 = localPositionMetadata.jdField_a_of_type_Fki.a();
    localPositionMetadata.a();
    return l1;
  }
  
  public long c()
  {
    long l1 = b();
    if (l1 == 4294967295L) {
      return -1L;
    }
    int i1 = c(l1);
    if (b(l1) == 0) {
      return this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.getGroupId(i1);
    }
    return this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.getChildId(i1, d(l1));
  }
  
  public boolean c(int paramInt)
  {
    return a(paramInt, false);
  }
  
  boolean c(View paramView, int paramInt, long paramLong)
  {
    ExpandableListConnector.PositionMetadata localPositionMetadata = this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a(paramInt);
    paramLong = a(localPositionMetadata.jdField_a_of_type_Fki);
    if (localPositionMetadata.jdField_a_of_type_Fki.f == 2)
    {
      if ((this.jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupClickListener != null) && (this.jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupClickListener.a(this, paramView, localPositionMetadata.jdField_a_of_type_Fki.c, paramLong)))
      {
        localPositionMetadata.a();
        return true;
      }
      if (localPositionMetadata.a())
      {
        this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a(localPositionMetadata);
        playSoundEffect(0);
        if (this.jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupCollapseListener != null) {
          this.jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupCollapseListener.a(localPositionMetadata.jdField_a_of_type_Fki.c);
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      localPositionMetadata.a();
      return bool;
      this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.b(localPositionMetadata);
      playSoundEffect(0);
      if (this.jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupExpandListener != null) {
        this.jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupExpandListener.a(localPositionMetadata.jdField_a_of_type_Fki.c);
      }
      paramInt = localPositionMetadata.jdField_a_of_type_Fki.c;
      int i1 = localPositionMetadata.jdField_a_of_type_Fki.e + k();
      d(this.jdField_a_of_type_AndroidWidgetExpandableListAdapter.getChildrenCount(paramInt) + i1, i1);
      break;
      if (this.jdField_a_of_type_ComTencentWidgetExpandableListView$OnChildClickListener != null)
      {
        playSoundEffect(0);
        return this.jdField_a_of_type_ComTencentWidgetExpandableListView$OnChildClickListener.a(this, paramView, localPositionMetadata.jdField_a_of_type_Fki.c, localPositionMetadata.jdField_a_of_type_Fki.d, paramLong);
      }
    }
  }
  
  public boolean d(int paramInt)
  {
    boolean bool = this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a(paramInt);
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupCollapseListener != null) {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupCollapseListener.a(paramInt);
    }
    return bool;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) {
      return;
    }
    int i4 = 0;
    int i3;
    label38:
    int i1;
    int i7;
    int i8;
    int i9;
    int i10;
    Rect localRect;
    int i6;
    int i5;
    if ((this.mGroupFlags & 0x22) == 34)
    {
      i3 = 1;
      if (i3 != 0)
      {
        i4 = paramCanvas.save();
        i1 = getScrollX();
        i2 = getScrollY();
        paramCanvas.clipRect(getPaddingLeft() + i1, getPaddingTop() + i2, i1 + getRight() - getLeft() - getPaddingRight(), i2 + getBottom() - getTop() - getPaddingBottom());
      }
      i7 = k();
      i8 = this.aA;
      i9 = l();
      i10 = getBottom();
      localRect = this.jdField_a_of_type_AndroidGraphicsRect;
      int i11 = getChildCount();
      i2 = this.ao;
      i1 = -4;
      i6 = 0;
      i5 = i2 - i7;
      label161:
      if (i6 >= i11) {
        break label213;
      }
      if (i5 >= 0) {
        break label198;
      }
      i2 = i1;
    }
    label198:
    label213:
    int i12;
    int i13;
    do
    {
      do
      {
        i6 += 1;
        i5 += 1;
        i1 = i2;
        break label161;
        i3 = 0;
        break label38;
        if (i5 > i8 - i9 - i7 - 1)
        {
          if (i3 == 0) {
            break;
          }
          paramCanvas.restoreToCount(i4);
          return;
        }
        localObject = getChildAt(i6);
        i12 = ((View)localObject).getTop();
        i13 = ((View)localObject).getBottom();
        i2 = i1;
      } while (i13 < 0);
      i2 = i1;
    } while (i12 > i10);
    Object localObject = this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a(i5);
    int i2 = i1;
    if (((ExpandableListConnector.PositionMetadata)localObject).jdField_a_of_type_Fki.f != i1)
    {
      if (((ExpandableListConnector.PositionMetadata)localObject).jdField_a_of_type_Fki.f != 1) {
        break label461;
      }
      if (this.n == -1)
      {
        i1 = this.l;
        label313:
        localRect.left = i1;
        if (this.o != -1) {
          break label453;
        }
        i1 = this.m;
        label332:
        localRect.right = i1;
        label338:
        localRect.left += getPaddingLeft();
        localRect.right += getPaddingLeft();
        i2 = ((ExpandableListConnector.PositionMetadata)localObject).jdField_a_of_type_Fki.f;
      }
    }
    else if (localRect.left != localRect.right)
    {
      if (!this.jdField_i_of_type_Boolean) {
        break label482;
      }
      localRect.top = i12;
    }
    for (localRect.bottom = i13;; localRect.bottom = i13)
    {
      Drawable localDrawable = a((ExpandableListConnector.PositionMetadata)localObject);
      if (localDrawable != null)
      {
        localDrawable.setBounds(localRect);
        localDrawable.draw(paramCanvas);
      }
      ((ExpandableListConnector.PositionMetadata)localObject).a();
      break;
      i1 = this.n;
      break label313;
      label453:
      i1 = this.o;
      break label332;
      label461:
      localRect.left = this.l;
      localRect.right = this.m;
      break label338;
      label482:
      localRect.top = i12;
    }
  }
  
  public boolean e(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.c(paramInt);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ExpandableListView.SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    do
    {
      return;
      paramParcelable = (ExpandableListView.SavedState)paramParcelable;
      super.onRestoreInstanceState(ExpandableListView.SavedState.a(paramParcelable));
    } while ((this.jdField_a_of_type_ComTencentWidgetExpandableListConnector == null) || (paramParcelable.a == null));
    this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a(paramParcelable.a);
  }
  
  public Parcelable onSaveInstanceState()
  {
    Parcelable localParcelable = super.onSaveInstanceState();
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListConnector != null) {}
    for (ArrayList localArrayList = this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a();; localArrayList = null) {
      return new ExpandableListView.SavedState(localParcelable, localArrayList);
    }
  }
  
  public void setAdapter(ExpandableListAdapter paramExpandableListAdapter)
  {
    this.jdField_a_of_type_AndroidWidgetExpandableListAdapter = paramExpandableListAdapter;
    if (paramExpandableListAdapter != null) {}
    for (this.jdField_a_of_type_ComTencentWidgetExpandableListConnector = new ExpandableListConnector(paramExpandableListAdapter);; this.jdField_a_of_type_ComTencentWidgetExpandableListConnector = null)
    {
      super.setAdapter(this.jdField_a_of_type_ComTencentWidgetExpandableListConnector);
      return;
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    throw new RuntimeException("For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of setAdapter(ListAdapter)");
  }
  
  public void setChildDivider(Drawable paramDrawable)
  {
    this.jdField_g_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void setChildIndicator(Drawable paramDrawable)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void setChildIndicatorBounds(int paramInt1, int paramInt2)
  {
    this.n = paramInt1;
    this.o = paramInt2;
  }
  
  public void setGroupIndicator(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if ((this.m == 0) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {
      this.m = (this.l + this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth());
    }
  }
  
  public void setIndicatorBounds(int paramInt1, int paramInt2)
  {
    this.l = paramInt1;
    this.m = paramInt2;
  }
  
  public void setOnChildClickListener(ExpandableListView.OnChildClickListener paramOnChildClickListener)
  {
    this.jdField_a_of_type_ComTencentWidgetExpandableListView$OnChildClickListener = paramOnChildClickListener;
  }
  
  public void setOnGroupClickListener(ExpandableListView.OnGroupClickListener paramOnGroupClickListener)
  {
    this.jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupClickListener = paramOnGroupClickListener;
  }
  
  public void setOnGroupCollapseListener(ExpandableListView.OnGroupCollapseListener paramOnGroupCollapseListener)
  {
    this.jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupCollapseListener = paramOnGroupCollapseListener;
  }
  
  public void setOnGroupExpandListener(ExpandableListView.OnGroupExpandListener paramOnGroupExpandListener)
  {
    this.jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupExpandListener = paramOnGroupExpandListener;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    super.setOnItemClickListener(paramOnItemClickListener);
  }
  
  public void setSelectedGroup(int paramInt)
  {
    fki localfki = fki.a(paramInt);
    ExpandableListConnector.PositionMetadata localPositionMetadata = this.jdField_a_of_type_ComTencentWidgetExpandableListConnector.a(localfki);
    localfki.a();
    super.setSelection(d(localPositionMetadata.jdField_a_of_type_Fki.e));
    localPositionMetadata.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.widget.ExpandableListView
 * JD-Core Version:    0.7.0.1
 */