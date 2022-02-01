package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.token.ek;
import com.tencent.token.ex;
import com.tencent.token.gp.j;
import com.tencent.token.jf;
import com.tencent.token.jl;

public class LinearLayoutCompat
  extends ViewGroup
{
  private boolean a = true;
  private int b = -1;
  private int c = 0;
  private int d;
  private int e = 8388659;
  private int f;
  private float g;
  private boolean h;
  private int[] i;
  private int[] j;
  private Drawable k;
  private int l;
  private int m;
  private int n;
  private int o;
  
  public LinearLayoutCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LinearLayoutCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = jf.a(paramContext, paramAttributeSet, gp.j.LinearLayoutCompat, paramInt, 0);
    paramInt = paramContext.a(gp.j.LinearLayoutCompat_android_orientation, -1);
    if (paramInt >= 0) {
      setOrientation(paramInt);
    }
    paramInt = paramContext.a(gp.j.LinearLayoutCompat_android_gravity, -1);
    if (paramInt >= 0) {
      setGravity(paramInt);
    }
    boolean bool = paramContext.a(gp.j.LinearLayoutCompat_android_baselineAligned, true);
    if (!bool) {
      setBaselineAligned(bool);
    }
    paramInt = gp.j.LinearLayoutCompat_android_weightSum;
    this.g = paramContext.a.getFloat(paramInt, -1.0F);
    this.b = paramContext.a(gp.j.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
    this.h = paramContext.a(gp.j.LinearLayoutCompat_measureWithLargestChild, false);
    setDividerDrawable(paramContext.a(gp.j.LinearLayoutCompat_divider));
    this.n = paramContext.a(gp.j.LinearLayoutCompat_showDividers, 0);
    this.o = paramContext.e(gp.j.LinearLayoutCompat_dividerPadding, 0);
    paramContext.a.recycle();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i2 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
    int i1 = 0;
    while (i1 < paramInt1)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.width == -1)
        {
          int i3 = localLayoutParams.height;
          localLayoutParams.height = localView.getMeasuredHeight();
          measureChildWithMargins(localView, i2, 0, paramInt2, 0);
          localLayoutParams.height = i3;
        }
      }
      i1 += 1;
    }
  }
  
  private void a(Canvas paramCanvas, int paramInt)
  {
    this.k.setBounds(getPaddingLeft() + this.o, paramInt, getWidth() - getPaddingRight() - this.o, this.m + paramInt);
    this.k.draw(paramCanvas);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    this.f = 0;
    int i12 = getVirtualChildCount();
    int i17 = View.MeasureSpec.getMode(paramInt1);
    int i16 = View.MeasureSpec.getMode(paramInt2);
    if ((this.i == null) || (this.j == null))
    {
      this.i = new int[4];
      this.j = new int[4];
    }
    Object localObject2 = this.i;
    int[] arrayOfInt = this.j;
    localObject2[3] = -1;
    localObject2[2] = -1;
    localObject2[1] = -1;
    localObject2[0] = -1;
    arrayOfInt[3] = -1;
    arrayOfInt[2] = -1;
    arrayOfInt[1] = -1;
    arrayOfInt[0] = -1;
    boolean bool2 = this.a;
    boolean bool1 = this.h;
    int i11;
    if (i17 == 1073741824) {
      i11 = 1;
    } else {
      i11 = 0;
    }
    float f1 = 0.0F;
    int i9 = 0;
    int i7 = 0;
    int i6 = 0;
    int i4 = 0;
    int i5 = 0;
    int i8 = 0;
    int i2 = 0;
    int i1 = 1;
    int i3 = 0;
    Object localObject1;
    LayoutParams localLayoutParams;
    int i14;
    int i15;
    int i18;
    while (i9 < i12)
    {
      localObject1 = getChildAt(i9);
      if (localObject1 == null)
      {
        this.f += 0;
      }
      else
      {
        if (((View)localObject1).getVisibility() != 8)
        {
          if (a(i9)) {
            this.f += this.l;
          }
          localLayoutParams = (LayoutParams)((View)localObject1).getLayoutParams();
          f1 += localLayoutParams.g;
          if ((i17 == 1073741824) && (localLayoutParams.width == 0) && (localLayoutParams.g > 0.0F))
          {
            if (i11 != 0)
            {
              this.f += localLayoutParams.leftMargin + localLayoutParams.rightMargin;
            }
            else
            {
              i10 = this.f;
              this.f = Math.max(i10, localLayoutParams.leftMargin + i10 + localLayoutParams.rightMargin);
            }
            if (bool2)
            {
              i10 = View.MeasureSpec.makeMeasureSpec(0, 0);
              ((View)localObject1).measure(i10, i10);
            }
            else
            {
              i8 = 1;
            }
          }
          else
          {
            if ((localLayoutParams.width == 0) && (localLayoutParams.g > 0.0F))
            {
              localLayoutParams.width = -2;
              i10 = 0;
            }
            else
            {
              i10 = -2147483648;
            }
            if (f1 == 0.0F) {
              i13 = this.f;
            } else {
              i13 = 0;
            }
            a((View)localObject1, paramInt1, i13, paramInt2, 0);
            if (i10 != -2147483648) {
              localLayoutParams.width = i10;
            }
            i10 = ((View)localObject1).getMeasuredWidth();
            if (i11 != 0)
            {
              this.f += localLayoutParams.leftMargin + i10 + localLayoutParams.rightMargin + 0;
            }
            else
            {
              i13 = this.f;
              this.f = Math.max(i13, i13 + i10 + localLayoutParams.leftMargin + localLayoutParams.rightMargin + 0);
            }
            if (bool1) {
              i7 = Math.max(i10, i7);
            }
          }
          if ((i16 != 1073741824) && (localLayoutParams.height == -1))
          {
            i10 = 1;
            i3 = 1;
          }
          else
          {
            i10 = 0;
          }
          i13 = localLayoutParams.topMargin + localLayoutParams.bottomMargin;
          i14 = ((View)localObject1).getMeasuredHeight() + i13;
          i15 = View.combineMeasuredStates(i2, ((View)localObject1).getMeasuredState());
          if (bool2)
          {
            i18 = ((View)localObject1).getBaseline();
            if (i18 != -1)
            {
              if (localLayoutParams.h < 0) {
                i2 = this.e;
              } else {
                i2 = localLayoutParams.h;
              }
              i2 = ((i2 & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
              localObject2[i2] = Math.max(localObject2[i2], i18);
              arrayOfInt[i2] = Math.max(arrayOfInt[i2], i14 - i18);
            }
          }
          i6 = Math.max(i6, i14);
          if ((i1 != 0) && (localLayoutParams.height == -1)) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          if (localLayoutParams.g > 0.0F)
          {
            if (i10 == 0) {
              i13 = i14;
            }
            i1 = Math.max(i5, i13);
            i5 = i15;
            i10 = i2;
          }
          else
          {
            i1 = i5;
            if (i10 != 0) {
              i14 = i13;
            }
            i4 = Math.max(i4, i14);
            i5 = i15;
            i10 = i2;
          }
        }
        else
        {
          i13 = i5;
          i10 = i1;
          i5 = i2;
          i1 = i13;
        }
        i13 = i9 + 0;
        i9 = i1;
        i1 = i10;
        i2 = i5;
        i5 = i9;
        i9 = i13;
      }
      i9 += 1;
    }
    if ((this.f > 0) && (a(i12))) {
      this.f += this.l;
    }
    if ((localObject2[1] == -1) && (localObject2[0] == -1) && (localObject2[2] == -1))
    {
      i9 = i6;
      if (localObject2[3] == -1) {
        break label960;
      }
    }
    i9 = Math.max(i6, Math.max(localObject2[3], Math.max(localObject2[0], Math.max(localObject2[1], localObject2[2]))) + Math.max(arrayOfInt[3], Math.max(arrayOfInt[0], Math.max(arrayOfInt[1], arrayOfInt[2]))));
    label960:
    if ((bool1) && ((i17 == -2147483648) || (i17 == 0)))
    {
      this.f = 0;
      i6 = 0;
      while (i6 < i12)
      {
        localObject1 = getChildAt(i6);
        if (localObject1 == null)
        {
          this.f += 0;
        }
        else if (((View)localObject1).getVisibility() == 8)
        {
          i6 += 0;
        }
        else
        {
          localObject1 = (LayoutParams)((View)localObject1).getLayoutParams();
          if (i11 != 0)
          {
            this.f += ((LayoutParams)localObject1).leftMargin + i7 + ((LayoutParams)localObject1).rightMargin + 0;
          }
          else
          {
            i10 = this.f;
            this.f = Math.max(i10, i10 + i7 + ((LayoutParams)localObject1).leftMargin + ((LayoutParams)localObject1).rightMargin + 0);
          }
        }
        i6 += 1;
      }
    }
    this.f += getPaddingLeft() + getPaddingRight();
    int i10 = View.resolveSizeAndState(Math.max(this.f, getSuggestedMinimumWidth()), paramInt1, 0);
    int i13 = (0xFFFFFF & i10) - this.f;
    if ((i8 == 0) && ((i13 == 0) || (f1 <= 0.0F)))
    {
      i6 = Math.max(i4, i5);
      if ((bool1) && (i17 != 1073741824))
      {
        i4 = 0;
        while (i4 < i12)
        {
          localObject1 = getChildAt(i4);
          if ((localObject1 != null) && (((View)localObject1).getVisibility() != 8) && (((LayoutParams)((View)localObject1).getLayoutParams()).g > 0.0F)) {
            ((View)localObject1).measure(View.MeasureSpec.makeMeasureSpec(i7, 1073741824), View.MeasureSpec.makeMeasureSpec(((View)localObject1).getMeasuredHeight(), 1073741824));
          }
          i4 += 1;
        }
      }
      i4 = i12;
      i5 = i2;
      i2 = i6;
      i6 = i1;
    }
    else
    {
      float f2 = this.g;
      if (f2 > 0.0F) {
        f1 = f2;
      }
      localObject2[3] = -1;
      localObject2[2] = -1;
      localObject2[1] = -1;
      localObject2[0] = -1;
      arrayOfInt[3] = -1;
      arrayOfInt[2] = -1;
      arrayOfInt[1] = -1;
      arrayOfInt[0] = -1;
      this.f = 0;
      i8 = -1;
      i9 = 0;
      i6 = i1;
      i7 = i4;
      i4 = i12;
      i1 = i2;
      i2 = i13;
      i5 = i10;
      while (i9 < i4)
      {
        localObject1 = getChildAt(i9);
        if ((localObject1 != null) && (((View)localObject1).getVisibility() != 8))
        {
          localLayoutParams = (LayoutParams)((View)localObject1).getLayoutParams();
          f2 = localLayoutParams.g;
          if (f2 > 0.0F)
          {
            i12 = (int)(i2 * f2 / f1);
            i13 = getPaddingTop();
            i14 = getPaddingBottom();
            i15 = localLayoutParams.topMargin;
            i18 = localLayoutParams.bottomMargin;
            int i19 = localLayoutParams.height;
            i10 = i2 - i12;
            i13 = getChildMeasureSpec(paramInt2, i13 + i14 + i15 + i18, i19);
            if ((localLayoutParams.width == 0) && (i17 == 1073741824))
            {
              if (i12 > 0) {
                i2 = i12;
              } else {
                i2 = 0;
              }
            }
            else
            {
              i12 = ((View)localObject1).getMeasuredWidth() + i12;
              i2 = i12;
              if (i12 < 0) {
                i2 = 0;
              }
            }
            ((View)localObject1).measure(View.MeasureSpec.makeMeasureSpec(i2, 1073741824), i13);
            i1 = View.combineMeasuredStates(i1, ((View)localObject1).getMeasuredState() & 0xFF000000);
            f1 -= f2;
            i2 = i10;
          }
          if (i11 != 0)
          {
            this.f += ((View)localObject1).getMeasuredWidth() + localLayoutParams.leftMargin + localLayoutParams.rightMargin + 0;
          }
          else
          {
            i10 = this.f;
            this.f = Math.max(i10, ((View)localObject1).getMeasuredWidth() + i10 + localLayoutParams.leftMargin + localLayoutParams.rightMargin + 0);
          }
          if ((i16 != 1073741824) && (localLayoutParams.height == -1)) {
            i10 = 1;
          } else {
            i10 = 0;
          }
          i14 = localLayoutParams.topMargin + localLayoutParams.bottomMargin;
          i13 = ((View)localObject1).getMeasuredHeight() + i14;
          i12 = Math.max(i8, i13);
          if (i10 != 0) {
            i8 = i14;
          } else {
            i8 = i13;
          }
          i8 = Math.max(i7, i8);
          if ((i6 != 0) && (localLayoutParams.height == -1)) {
            i6 = 1;
          } else {
            i6 = 0;
          }
          if (bool2)
          {
            i10 = ((View)localObject1).getBaseline();
            if (i10 != -1)
            {
              if (localLayoutParams.h < 0) {
                i7 = this.e;
              } else {
                i7 = localLayoutParams.h;
              }
              i7 = ((i7 & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
              localObject2[i7] = Math.max(localObject2[i7], i10);
              arrayOfInt[i7] = Math.max(arrayOfInt[i7], i13 - i10);
            }
            else {}
          }
          i7 = i8;
          i8 = i12;
        }
        i9 += 1;
      }
      this.f += getPaddingLeft() + getPaddingRight();
      if ((localObject2[1] == -1) && (localObject2[0] == -1) && (localObject2[2] == -1) && (localObject2[3] == -1)) {
        break label2032;
      }
      i8 = Math.max(i8, Math.max(localObject2[3], Math.max(localObject2[0], Math.max(localObject2[1], localObject2[2]))) + Math.max(arrayOfInt[3], Math.max(arrayOfInt[0], Math.max(arrayOfInt[1], arrayOfInt[2]))));
      label2032:
      i2 = i7;
      i10 = i5;
      i9 = i8;
      i5 = i1;
    }
    i1 = i9;
    if (i6 == 0)
    {
      i1 = i9;
      if (i16 != 1073741824) {
        i1 = i2;
      }
    }
    setMeasuredDimension(i10 | 0xFF000000 & i5, View.resolveSizeAndState(Math.max(i1 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), paramInt2, i5 << 16));
    if (i3 != 0)
    {
      i1 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
      paramInt2 = 0;
      while (paramInt2 < i4)
      {
        localObject1 = getChildAt(paramInt2);
        if (((View)localObject1).getVisibility() != 8)
        {
          localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
          if (((LayoutParams)localObject2).height == -1)
          {
            i2 = ((LayoutParams)localObject2).width;
            ((LayoutParams)localObject2).width = ((View)localObject1).getMeasuredWidth();
            measureChildWithMargins((View)localObject1, paramInt1, 0, i1, 0);
            ((LayoutParams)localObject2).width = i2;
          }
          else {}
        }
        paramInt2 += 1;
      }
    }
  }
  
  private void b(Canvas paramCanvas, int paramInt)
  {
    this.k.setBounds(paramInt, getPaddingTop() + this.o, this.l + paramInt, getHeight() - getPaddingBottom() - this.o);
    this.k.draw(paramCanvas);
  }
  
  private static void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.layout(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt2);
  }
  
  private static int getChildrenSkipCount$5359dca7()
  {
    return 0;
  }
  
  private static int getLocationOffset$3c7ec8d0()
  {
    return 0;
  }
  
  private static int getNextLocationOffset$3c7ec8d0()
  {
    return 0;
  }
  
  public LayoutParams a(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected final boolean a(int paramInt)
  {
    if (paramInt == 0) {
      return (this.n & 0x1) != 0;
    }
    if (paramInt == getChildCount()) {
      return (this.n & 0x4) != 0;
    }
    if ((this.n & 0x2) != 0)
    {
      paramInt -= 1;
      while (paramInt >= 0)
      {
        if (getChildAt(paramInt).getVisibility() != 8) {
          return true;
        }
        paramInt -= 1;
      }
      return false;
    }
    return false;
  }
  
  protected LayoutParams b(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  protected LayoutParams c()
  {
    int i1 = this.d;
    if (i1 == 0) {
      return new LayoutParams(-2, -2);
    }
    if (i1 == 1) {
      return new LayoutParams(-1, -2);
    }
    return null;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public int getBaseline()
  {
    if (this.b < 0) {
      return super.getBaseline();
    }
    int i1 = getChildCount();
    int i2 = this.b;
    if (i1 > i2)
    {
      View localView = getChildAt(i2);
      int i3 = localView.getBaseline();
      if (i3 == -1)
      {
        if (this.b == 0) {
          return -1;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
      }
      i2 = this.c;
      i1 = i2;
      if (this.d == 1)
      {
        int i4 = this.e & 0x70;
        i1 = i2;
        if (i4 != 48) {
          if (i4 != 16)
          {
            if (i4 != 80) {
              i1 = i2;
            } else {
              i1 = getBottom() - getTop() - getPaddingBottom() - this.f;
            }
          }
          else {
            i1 = i2 + (getBottom() - getTop() - getPaddingTop() - getPaddingBottom() - this.f) / 2;
          }
        }
      }
      return i1 + ((LayoutParams)localView.getLayoutParams()).topMargin + i3;
    }
    throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
  }
  
  public int getBaselineAlignedChildIndex()
  {
    return this.b;
  }
  
  public Drawable getDividerDrawable()
  {
    return this.k;
  }
  
  public int getDividerPadding()
  {
    return this.o;
  }
  
  public int getDividerWidth()
  {
    return this.l;
  }
  
  public int getGravity()
  {
    return this.e;
  }
  
  public int getOrientation()
  {
    return this.d;
  }
  
  public int getShowDividers()
  {
    return this.n;
  }
  
  int getVirtualChildCount()
  {
    return getChildCount();
  }
  
  public float getWeightSum()
  {
    return this.g;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.k == null) {
      return;
    }
    int i3 = this.d;
    int i2 = 0;
    int i1 = 0;
    View localView;
    LayoutParams localLayoutParams;
    if (i3 == 1)
    {
      i2 = getVirtualChildCount();
      while (i1 < i2)
      {
        localView = getChildAt(i1);
        if ((localView != null) && (localView.getVisibility() != 8) && (a(i1)))
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          a(paramCanvas, localView.getTop() - localLayoutParams.topMargin - this.m);
        }
        i1 += 1;
      }
      if (a(i2))
      {
        localView = getChildAt(i2 - 1);
        if (localView == null)
        {
          i1 = getHeight() - getPaddingBottom() - this.m;
        }
        else
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          i1 = localView.getBottom() + localLayoutParams.bottomMargin;
        }
        a(paramCanvas, i1);
      }
      return;
    }
    i3 = getVirtualChildCount();
    boolean bool = jl.a(this);
    i1 = i2;
    while (i1 < i3)
    {
      localView = getChildAt(i1);
      if ((localView != null) && (localView.getVisibility() != 8) && (a(i1)))
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (bool) {
          i2 = localView.getRight() + localLayoutParams.rightMargin;
        } else {
          i2 = localView.getLeft() - localLayoutParams.leftMargin - this.l;
        }
        b(paramCanvas, i2);
      }
      i1 += 1;
    }
    if (a(i3))
    {
      localView = getChildAt(i3 - 1);
      if (localView == null)
      {
        if (bool) {
          i1 = getPaddingLeft();
        } else {
          i1 = getWidth() - getPaddingRight() - this.l;
        }
      }
      else
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (bool) {
          i1 = localView.getLeft() - localLayoutParams.leftMargin - this.l;
        } else {
          i1 = localView.getRight() + localLayoutParams.rightMargin;
        }
      }
      b(paramCanvas, i1);
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1;
    int i2;
    int i4;
    int i6;
    if (this.d == 1)
    {
      i1 = getPaddingLeft();
      i2 = paramInt3 - paramInt1;
      i3 = getPaddingRight();
      i4 = getPaddingRight();
      i5 = getVirtualChildCount();
      i6 = this.e;
      paramInt1 = i6 & 0x70;
      if (paramInt1 != 16)
      {
        if (paramInt1 != 80) {
          paramInt1 = getPaddingTop();
        } else {
          paramInt1 = getPaddingTop() + paramInt4 - paramInt2 - this.f;
        }
      }
      else {
        paramInt1 = getPaddingTop() + (paramInt4 - paramInt2 - this.f) / 2;
      }
      paramInt3 = 0;
      paramInt2 = paramInt1;
      paramInt1 = paramInt3;
      while (paramInt1 < i5)
      {
        localObject1 = getChildAt(paramInt1);
        if (localObject1 == null)
        {
          paramInt3 = paramInt2 + 0;
          paramInt4 = paramInt1;
        }
        else
        {
          paramInt4 = paramInt1;
          paramInt3 = paramInt2;
          if (((View)localObject1).getVisibility() != 8)
          {
            i7 = ((View)localObject1).getMeasuredWidth();
            i8 = ((View)localObject1).getMeasuredHeight();
            localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
            paramInt4 = ((LayoutParams)localObject2).h;
            paramInt3 = paramInt4;
            if (paramInt4 < 0) {
              paramInt3 = 0x800007 & i6;
            }
            paramInt3 = ek.a(paramInt3, ex.c(this)) & 0x7;
            if (paramInt3 != 1)
            {
              if (paramInt3 != 5) {
                paramInt3 = ((LayoutParams)localObject2).leftMargin + i1;
              } else {
                paramInt3 = i2 - i3 - i7 - ((LayoutParams)localObject2).rightMargin;
              }
            }
            else {
              paramInt3 = (i2 - i1 - i4 - i7) / 2 + i1 + ((LayoutParams)localObject2).leftMargin - ((LayoutParams)localObject2).rightMargin;
            }
            paramInt4 = paramInt2;
            if (a(paramInt1)) {
              paramInt4 = paramInt2 + this.m;
            }
            paramInt2 = paramInt4 + ((LayoutParams)localObject2).topMargin;
            b((View)localObject1, paramInt3, paramInt2 + 0, i7, i8);
            paramInt3 = paramInt2 + (i8 + ((LayoutParams)localObject2).bottomMargin + 0);
            paramInt4 = paramInt1 + 0;
          }
        }
        paramInt1 = paramInt4 + 1;
        paramInt2 = paramInt3;
      }
      return;
    }
    boolean bool = jl.a(this);
    int i5 = getPaddingTop();
    int i7 = paramInt4 - paramInt2;
    int i8 = getPaddingBottom();
    int i9 = getPaddingBottom();
    int i3 = getVirtualChildCount();
    paramInt4 = this.e;
    paramInt2 = paramInt4 & 0x70;
    paramBoolean = this.a;
    Object localObject1 = this.i;
    Object localObject2 = this.j;
    paramInt4 = ek.a(0x800007 & paramInt4, ex.c(this));
    if (paramInt4 != 1)
    {
      if (paramInt4 != 5) {
        paramInt1 = getPaddingLeft();
      } else {
        paramInt1 = getPaddingLeft() + paramInt3 - paramInt1 - this.f;
      }
    }
    else {
      paramInt1 = getPaddingLeft() + (paramInt3 - paramInt1 - this.f) / 2;
    }
    if (bool)
    {
      i1 = i3 - 1;
      i2 = -1;
    }
    else
    {
      i1 = 0;
      i2 = 1;
    }
    paramInt3 = 0;
    paramInt4 = paramInt1;
    while (paramInt3 < i3)
    {
      int i12 = i1 + i2 * paramInt3;
      View localView = getChildAt(i12);
      if (localView == null)
      {
        paramInt4 += 0;
      }
      else if (localView.getVisibility() != 8)
      {
        int i10 = localView.getMeasuredWidth();
        int i11 = localView.getMeasuredHeight();
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if ((paramBoolean) && (localLayoutParams.height != -1)) {
          paramInt1 = localView.getBaseline();
        } else {
          paramInt1 = -1;
        }
        i6 = localLayoutParams.h;
        i4 = i6;
        if (i6 < 0) {
          i4 = paramInt2;
        }
        i4 &= 0x70;
        if (i4 != 16)
        {
          if (i4 != 48)
          {
            if (i4 != 80)
            {
              paramInt1 = i5;
            }
            else
            {
              i4 = i7 - i8 - i11 - localLayoutParams.bottomMargin;
              if (paramInt1 != -1)
              {
                i6 = localView.getMeasuredHeight();
                paramInt1 = i4 - (localObject2[2] - (i6 - paramInt1));
              }
              else
              {
                paramInt1 = i4;
              }
            }
          }
          else
          {
            i4 = localLayoutParams.topMargin + i5;
            if (paramInt1 != -1) {
              paramInt1 = i4 + (localObject1[1] - paramInt1);
            } else {
              paramInt1 = i4;
            }
          }
        }
        else {
          paramInt1 = (i7 - i5 - i9 - i11) / 2 + i5 + localLayoutParams.topMargin - localLayoutParams.bottomMargin;
        }
        i4 = paramInt4;
        if (a(i12)) {
          i4 = paramInt4 + this.l;
        }
        paramInt4 = i4 + localLayoutParams.leftMargin;
        b(localView, paramInt4 + 0, paramInt1, i10, i11);
        paramInt4 += i10 + localLayoutParams.rightMargin + 0;
        paramInt3 += 0;
      }
      paramInt3 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.d == 1)
    {
      this.f = 0;
      int i11 = getVirtualChildCount();
      int i17 = View.MeasureSpec.getMode(paramInt1);
      int i8 = View.MeasureSpec.getMode(paramInt2);
      int i18 = this.b;
      boolean bool = this.h;
      float f1 = 0.0F;
      int i10 = 0;
      int i3 = 0;
      int i5 = 0;
      int i6 = 0;
      int i1 = 0;
      int i9 = 0;
      int i2 = 1;
      int i7 = 0;
      int i4 = 0;
      Object localObject;
      int i13;
      LayoutParams localLayoutParams;
      while (i6 < i11)
      {
        localObject = getChildAt(i6);
        if (localObject == null)
        {
          this.f += 0;
          i13 = i6;
          i12 = i1;
        }
        else
        {
          if (((View)localObject).getVisibility() != 8)
          {
            if (a(i6)) {
              this.f += this.m;
            }
            localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
            f1 += localLayoutParams.g;
            if ((i8 == 1073741824) && (localLayoutParams.height == 0) && (localLayoutParams.g > 0.0F))
            {
              i9 = this.f;
              this.f = Math.max(i9, localLayoutParams.topMargin + i9 + localLayoutParams.bottomMargin);
              i9 = 1;
            }
            else
            {
              if ((localLayoutParams.height == 0) && (localLayoutParams.g > 0.0F))
              {
                localLayoutParams.height = -2;
                i12 = 0;
              }
              else
              {
                i12 = -2147483648;
              }
              if (f1 == 0.0F) {
                i13 = this.f;
              } else {
                i13 = 0;
              }
              a((View)localObject, paramInt1, 0, paramInt2, i13);
              if (i12 != -2147483648) {
                localLayoutParams.height = i12;
              }
              i12 = ((View)localObject).getMeasuredHeight();
              i13 = this.f;
              this.f = Math.max(i13, i13 + i12 + localLayoutParams.topMargin + localLayoutParams.bottomMargin + 0);
              if (bool) {
                i3 = Math.max(i12, i3);
              }
            }
            i12 = i5;
            if ((i18 >= 0) && (i18 == i6 + 1)) {
              this.c = this.f;
            }
            i5 = i6;
            if ((i5 < i18) && (localLayoutParams.g > 0.0F)) {
              throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
            }
            if ((i17 != 1073741824) && (localLayoutParams.width == -1))
            {
              i6 = 1;
              i7 = 1;
            }
            else
            {
              i6 = 0;
            }
            i13 = localLayoutParams.leftMargin + localLayoutParams.rightMargin;
            i14 = ((View)localObject).getMeasuredWidth() + i13;
            int i16 = Math.max(i10, i14);
            int i15 = View.combineMeasuredStates(i1, ((View)localObject).getMeasuredState());
            if ((i2 != 0) && (localLayoutParams.width == -1)) {
              i2 = 1;
            } else {
              i2 = 0;
            }
            if (localLayoutParams.g > 0.0F)
            {
              if (i6 == 0) {
                i13 = i14;
              }
              i1 = Math.max(i4, i13);
              i10 = i5;
              i6 = i16;
              i5 = i15;
              i4 = i12;
            }
            else
            {
              if (i6 == 0) {
                i13 = i14;
              }
              i12 = Math.max(i12, i13);
              i10 = i5;
              i6 = i16;
              i1 = i4;
              i5 = i15;
              i4 = i12;
            }
          }
          else
          {
            i13 = i4;
            i12 = i6;
            i4 = i5;
            i6 = i10;
            i5 = i1;
            i1 = i13;
            i10 = i12;
          }
          i13 = i10 + 0;
          i10 = i4;
          i12 = i5;
          i4 = i1;
          i5 = i10;
          i10 = i6;
        }
        i6 = i13 + 1;
        i1 = i12;
      }
      int i12 = i5;
      i6 = i10;
      if ((this.f > 0) && (a(i11))) {
        this.f += this.m;
      }
      if (bool)
      {
        i5 = i8;
        if ((i5 == -2147483648) || (i5 == 0))
        {
          this.f = 0;
          i5 = 0;
          while (i5 < i11)
          {
            localObject = getChildAt(i5);
            if (localObject == null)
            {
              this.f += 0;
            }
            else if (((View)localObject).getVisibility() == 8)
            {
              i5 += 0;
            }
            else
            {
              localObject = (LayoutParams)((View)localObject).getLayoutParams();
              i10 = this.f;
              this.f = Math.max(i10, i10 + i3 + ((LayoutParams)localObject).topMargin + ((LayoutParams)localObject).bottomMargin + 0);
            }
            i5 += 1;
          }
        }
      }
      this.f += getPaddingTop() + getPaddingBottom();
      int i14 = View.resolveSizeAndState(Math.max(this.f, getSuggestedMinimumHeight()), paramInt2, 0);
      i5 = (0xFFFFFF & i14) - this.f;
      if ((i9 == 0) && ((i5 == 0) || (f1 <= 0.0F)))
      {
        i5 = Math.max(i12, i4);
        if ((bool) && (i8 != 1073741824))
        {
          i4 = 0;
          while (i4 < i11)
          {
            localObject = getChildAt(i4);
            if ((localObject != null) && (((View)localObject).getVisibility() != 8) && (((LayoutParams)((View)localObject).getLayoutParams()).g > 0.0F)) {
              ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(((View)localObject).getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
            }
            i4 += 1;
          }
        }
        i3 = i5;
      }
      else
      {
        float f2 = this.g;
        if (f2 > 0.0F) {
          f1 = f2;
        }
        this.f = 0;
        i9 = 0;
        i4 = i2;
        i2 = i5;
        i5 = i12;
        while (i9 < i11)
        {
          localObject = getChildAt(i9);
          if (((View)localObject).getVisibility() != 8)
          {
            localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
            f2 = localLayoutParams.g;
            if (f2 > 0.0F)
            {
              i10 = (int)(i2 * f2 / f1);
              i3 = getPaddingLeft();
              i12 = getPaddingRight();
              f1 -= f2;
              i13 = getChildMeasureSpec(paramInt1, i3 + i12 + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width);
              if ((localLayoutParams.height == 0) && (i8 == 1073741824))
              {
                if (i10 > 0) {
                  i3 = i10;
                } else {
                  i3 = 0;
                }
              }
              else
              {
                i12 = ((View)localObject).getMeasuredHeight() + i10;
                i3 = i12;
                if (i12 < 0) {
                  i3 = 0;
                }
              }
              ((View)localObject).measure(i13, View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
              i1 = View.combineMeasuredStates(i1, ((View)localObject).getMeasuredState() & 0xFFFFFF00);
              i2 -= i10;
            }
            i12 = localLayoutParams.leftMargin + localLayoutParams.rightMargin;
            i13 = ((View)localObject).getMeasuredWidth() + i12;
            i10 = Math.max(i6, i13);
            if ((i17 != 1073741824) && (localLayoutParams.width == -1)) {
              i3 = 1;
            } else {
              i3 = 0;
            }
            i6 = i13;
            if (i3 != 0) {
              i6 = i12;
            }
            i5 = Math.max(i5, i6);
            if ((i4 != 0) && (localLayoutParams.width == -1)) {
              i3 = 1;
            } else {
              i3 = 0;
            }
            i4 = this.f;
            this.f = Math.max(i4, ((View)localObject).getMeasuredHeight() + i4 + localLayoutParams.topMargin + localLayoutParams.bottomMargin + 0);
            i6 = i10;
            i4 = i3;
          }
          i9 += 1;
        }
        this.f += getPaddingTop() + getPaddingBottom();
        i3 = i5;
        i2 = i4;
      }
      i4 = i6;
      if (i2 == 0)
      {
        i4 = i6;
        if (i17 != 1073741824) {
          i4 = i3;
        }
      }
      setMeasuredDimension(View.resolveSizeAndState(Math.max(i4 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), paramInt1, i1), i14);
      if (i7 != 0) {
        a(i11, paramInt2);
      }
      return;
    }
    b(paramInt1, paramInt2);
  }
  
  public void setBaselineAligned(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void setBaselineAlignedChildIndex(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getChildCount()))
    {
      this.b = paramInt;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("base aligned child index out of range (0, ");
    localStringBuilder.append(getChildCount());
    localStringBuilder.append(")");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setDividerDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == this.k) {
      return;
    }
    this.k = paramDrawable;
    boolean bool = false;
    if (paramDrawable != null)
    {
      this.l = paramDrawable.getIntrinsicWidth();
      this.m = paramDrawable.getIntrinsicHeight();
    }
    else
    {
      this.l = 0;
      this.m = 0;
    }
    if (paramDrawable == null) {
      bool = true;
    }
    setWillNotDraw(bool);
    requestLayout();
  }
  
  public void setDividerPadding(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void setGravity(int paramInt)
  {
    if (this.e != paramInt)
    {
      int i1 = paramInt;
      if ((0x800007 & paramInt) == 0) {
        i1 = paramInt | 0x800003;
      }
      paramInt = i1;
      if ((i1 & 0x70) == 0) {
        paramInt = i1 | 0x30;
      }
      this.e = paramInt;
      requestLayout();
    }
  }
  
  public void setHorizontalGravity(int paramInt)
  {
    paramInt &= 0x800007;
    int i1 = this.e;
    if ((0x800007 & i1) != paramInt)
    {
      this.e = (paramInt | 0xFF7FFFF8 & i1);
      requestLayout();
    }
  }
  
  public void setMeasureWithLargestChildEnabled(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setOrientation(int paramInt)
  {
    if (this.d != paramInt)
    {
      this.d = paramInt;
      requestLayout();
    }
  }
  
  public void setShowDividers(int paramInt)
  {
    if (paramInt != this.n) {
      requestLayout();
    }
    this.n = paramInt;
  }
  
  public void setVerticalGravity(int paramInt)
  {
    paramInt &= 0x70;
    int i1 = this.e;
    if ((i1 & 0x70) != paramInt)
    {
      this.e = (paramInt | i1 & 0xFFFFFF8F);
      requestLayout();
    }
  }
  
  public void setWeightSum(float paramFloat)
  {
    this.g = Math.max(0.0F, paramFloat);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public float g;
    public int h = -1;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      this.g = 0.0F;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, gp.j.LinearLayoutCompat_Layout);
      this.g = paramContext.getFloat(gp.j.LinearLayoutCompat_Layout_android_layout_weight, 0.0F);
      this.h = paramContext.getInt(gp.j.LinearLayoutCompat_Layout_android_layout_gravity, -1);
      paramContext.recycle();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutCompat
 * JD-Core Version:    0.7.0.1
 */