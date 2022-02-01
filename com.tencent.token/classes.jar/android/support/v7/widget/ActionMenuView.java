package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.ActionMenuItemView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.token.hl;
import com.tencent.token.hl.a;
import com.tencent.token.hl.b;
import com.tencent.token.hn;
import com.tencent.token.hs.a;
import com.tencent.token.ht;
import com.tencent.token.jk;

public class ActionMenuView
  extends LinearLayoutCompat
  implements hl.b, ht
{
  public hl a;
  public boolean b;
  public ActionMenuPresenter c;
  hl.a d;
  d e;
  private Context f;
  private int g;
  private hs.a h;
  private boolean i;
  private int j;
  private int k;
  private int l;
  
  public ActionMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBaselineAligned(false);
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.k = ((int)(56.0F * f1));
    this.l = ((int)(f1 * 4.0F));
    this.f = paramContext;
    this.g = 0;
  }
  
  static int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int n = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt3) - paramInt4, View.MeasureSpec.getMode(paramInt3));
    ActionMenuItemView localActionMenuItemView;
    if ((paramView instanceof ActionMenuItemView)) {
      localActionMenuItemView = (ActionMenuItemView)paramView;
    } else {
      localActionMenuItemView = null;
    }
    boolean bool = true;
    if ((localActionMenuItemView != null) && (localActionMenuItemView.b())) {
      paramInt3 = 1;
    } else {
      paramInt3 = 0;
    }
    paramInt4 = 2;
    if ((paramInt2 > 0) && ((paramInt3 == 0) || (paramInt2 >= 2)))
    {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt2 * paramInt1, -2147483648), n);
      int i1 = paramView.getMeasuredWidth();
      int m = i1 / paramInt1;
      paramInt2 = m;
      if (i1 % paramInt1 != 0) {
        paramInt2 = m + 1;
      }
      if ((paramInt3 != 0) && (paramInt2 < 2)) {
        paramInt2 = paramInt4;
      }
    }
    else
    {
      paramInt2 = 0;
    }
    if ((localLayoutParams.a) || (paramInt3 == 0)) {
      bool = false;
    }
    localLayoutParams.d = bool;
    localLayoutParams.b = paramInt2;
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 * paramInt2, 1073741824), n);
    return paramInt2;
  }
  
  public static LayoutParams a()
  {
    LayoutParams localLayoutParams = d();
    localLayoutParams.a = true;
    return localLayoutParams;
  }
  
  protected static LayoutParams a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams != null)
    {
      if ((paramLayoutParams instanceof LayoutParams)) {
        paramLayoutParams = new LayoutParams((LayoutParams)paramLayoutParams);
      } else {
        paramLayoutParams = new LayoutParams(paramLayoutParams);
      }
      if (paramLayoutParams.h <= 0) {
        paramLayoutParams.h = 16;
      }
      return paramLayoutParams;
    }
    return d();
  }
  
  private LayoutParams b(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  private boolean b(int paramInt)
  {
    boolean bool2 = false;
    if (paramInt == 0) {
      return false;
    }
    View localView1 = getChildAt(paramInt - 1);
    View localView2 = getChildAt(paramInt);
    boolean bool1 = bool2;
    if (paramInt < getChildCount())
    {
      bool1 = bool2;
      if ((localView1 instanceof a)) {
        bool1 = false | ((a)localView1).d();
      }
    }
    bool2 = bool1;
    if (paramInt > 0)
    {
      bool2 = bool1;
      if ((localView2 instanceof a)) {
        bool2 = bool1 | ((a)localView2).c();
      }
    }
    return bool2;
  }
  
  private static LayoutParams d()
  {
    LayoutParams localLayoutParams = new LayoutParams();
    localLayoutParams.h = 16;
    return localLayoutParams;
  }
  
  public final void a(hl paramhl)
  {
    this.a = paramhl;
  }
  
  public final void a(hs.a parama, hl.a parama1)
  {
    this.h = parama;
    this.d = parama1;
  }
  
  public final boolean a(hn paramhn)
  {
    return this.a.a(paramhn, null, 0);
  }
  
  public final void b()
  {
    ActionMenuPresenter localActionMenuPresenter = this.c;
    if (localActionMenuPresenter != null) {
      localActionMenuPresenter.f();
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (paramLayoutParams != null) && ((paramLayoutParams instanceof LayoutParams));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }
  
  public Menu getMenu()
  {
    if (this.a == null)
    {
      Object localObject = getContext();
      this.a = new hl((Context)localObject);
      this.a.a(new c());
      this.c = new ActionMenuPresenter((Context)localObject);
      this.c.c();
      ActionMenuPresenter localActionMenuPresenter = this.c;
      localObject = this.h;
      if (localObject == null) {
        localObject = new b();
      }
      localActionMenuPresenter.f = ((hs.a)localObject);
      this.a.a(this.c, this.f);
      this.c.a(this);
    }
    return this.a;
  }
  
  public Drawable getOverflowIcon()
  {
    getMenu();
    ActionMenuPresenter localActionMenuPresenter = this.c;
    if (localActionMenuPresenter.i != null) {
      return localActionMenuPresenter.i.getDrawable();
    }
    if (localActionMenuPresenter.k) {
      return localActionMenuPresenter.j;
    }
    return null;
  }
  
  public int getPopupTheme()
  {
    return this.g;
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = this.c;
    if (paramConfiguration != null)
    {
      paramConfiguration.b(false);
      if (this.c.h())
      {
        this.c.e();
        this.c.d();
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    b();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.i)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    int i3 = getChildCount();
    int i2 = (paramInt4 - paramInt2) / 2;
    int i4 = getDividerWidth();
    int i5 = paramInt3 - paramInt1;
    paramInt1 = getPaddingRight();
    paramInt2 = getPaddingLeft();
    paramBoolean = jk.a(this);
    paramInt4 = i5 - paramInt1 - paramInt2;
    paramInt3 = 0;
    int m = 0;
    paramInt2 = 0;
    View localView;
    int n;
    LayoutParams localLayoutParams;
    while (paramInt3 < i3)
    {
      localView = getChildAt(paramInt3);
      n = m;
      int i1 = paramInt2;
      paramInt1 = paramInt4;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.a)
        {
          m = localView.getMeasuredWidth();
          paramInt1 = m;
          if (b(paramInt3)) {
            paramInt1 = m + i4;
          }
          i1 = localView.getMeasuredHeight();
          if (paramBoolean)
          {
            n = getPaddingLeft() + localLayoutParams.leftMargin;
            m = n + paramInt1;
          }
          else
          {
            m = getWidth() - getPaddingRight() - localLayoutParams.rightMargin;
            n = m - paramInt1;
          }
          int i6 = i2 - i1 / 2;
          localView.layout(n, i6, m, i1 + i6);
          paramInt1 = paramInt4 - paramInt1;
          n = 1;
          i1 = paramInt2;
        }
        else
        {
          paramInt1 = paramInt4 - (localView.getMeasuredWidth() + localLayoutParams.leftMargin + localLayoutParams.rightMargin);
          b(paramInt3);
          i1 = paramInt2 + 1;
          n = m;
        }
      }
      paramInt3 += 1;
      m = n;
      paramInt2 = i1;
      paramInt4 = paramInt1;
    }
    if ((i3 == 1) && (m == 0))
    {
      localView = getChildAt(0);
      paramInt1 = localView.getMeasuredWidth();
      paramInt2 = localView.getMeasuredHeight();
      paramInt3 = i5 / 2 - paramInt1 / 2;
      paramInt4 = i2 - paramInt2 / 2;
      localView.layout(paramInt3, paramInt4, paramInt1 + paramInt3, paramInt2 + paramInt4);
      return;
    }
    paramInt1 = paramInt2 - (m ^ 0x1);
    if (paramInt1 > 0) {
      paramInt1 = paramInt4 / paramInt1;
    } else {
      paramInt1 = 0;
    }
    paramInt4 = 0;
    paramInt3 = 0;
    m = Math.max(0, paramInt1);
    if (paramBoolean)
    {
      paramInt2 = getWidth() - getPaddingRight();
      paramInt1 = paramInt3;
      while (paramInt1 < i3)
      {
        localView = getChildAt(paramInt1);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        paramInt3 = paramInt2;
        if (localView.getVisibility() != 8)
        {
          paramInt3 = paramInt2;
          if (!localLayoutParams.a)
          {
            paramInt2 -= localLayoutParams.rightMargin;
            paramInt3 = localView.getMeasuredWidth();
            paramInt4 = localView.getMeasuredHeight();
            n = i2 - paramInt4 / 2;
            localView.layout(paramInt2 - paramInt3, n, paramInt2, paramInt4 + n);
            paramInt3 = paramInt2 - (paramInt3 + localLayoutParams.leftMargin + m);
          }
        }
        paramInt1 += 1;
        paramInt2 = paramInt3;
      }
      return;
    }
    paramInt2 = getPaddingLeft();
    paramInt1 = paramInt4;
    while (paramInt1 < i3)
    {
      localView = getChildAt(paramInt1);
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      paramInt3 = paramInt2;
      if (localView.getVisibility() != 8)
      {
        paramInt3 = paramInt2;
        if (!localLayoutParams.a)
        {
          paramInt2 += localLayoutParams.leftMargin;
          paramInt3 = localView.getMeasuredWidth();
          paramInt4 = localView.getMeasuredHeight();
          n = i2 - paramInt4 / 2;
          localView.layout(paramInt2, n, paramInt2 + paramInt3, paramInt4 + n);
          paramInt3 = paramInt2 + (paramInt3 + localLayoutParams.rightMargin + m);
        }
      }
      paramInt1 += 1;
      paramInt2 = paramInt3;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool2 = this.i;
    boolean bool1;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.i = bool1;
    if (bool2 != this.i) {
      this.j = 0;
    }
    int m = View.MeasureSpec.getSize(paramInt1);
    Object localObject;
    if (this.i)
    {
      localObject = this.a;
      if ((localObject != null) && (m != this.j))
      {
        this.j = m;
        ((hl)localObject).b(true);
      }
    }
    int n = getChildCount();
    if ((this.i) && (n > 0))
    {
      int i5 = View.MeasureSpec.getMode(paramInt2);
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      m = View.MeasureSpec.getSize(paramInt2);
      n = getPaddingLeft();
      int i1 = getPaddingRight();
      int i8 = getPaddingTop() + getPaddingBottom();
      int i13 = getChildMeasureSpec(paramInt2, i8, -2);
      int i4 = paramInt1 - (n + i1);
      paramInt2 = this.k;
      paramInt1 = i4 / paramInt2;
      if (paramInt1 == 0)
      {
        setMeasuredDimension(i4, 0);
        return;
      }
      int i14 = paramInt2 + i4 % paramInt2 / paramInt1;
      int i15 = getChildCount();
      int i6 = 0;
      int i3 = 0;
      paramInt2 = 0;
      n = 0;
      int i7 = 0;
      i1 = 0;
      long l1 = 0L;
      LayoutParams localLayoutParams;
      int i9;
      long l2;
      while (i3 < i15)
      {
        localObject = getChildAt(i3);
        if (((View)localObject).getVisibility() != 8)
        {
          bool1 = localObject instanceof ActionMenuItemView;
          i7 += 1;
          if (bool1)
          {
            i2 = this.l;
            ((View)localObject).setPadding(i2, 0, i2, 0);
          }
          localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
          localLayoutParams.f = false;
          localLayoutParams.c = 0;
          localLayoutParams.b = 0;
          localLayoutParams.d = false;
          localLayoutParams.leftMargin = 0;
          localLayoutParams.rightMargin = 0;
          if ((bool1) && (((ActionMenuItemView)localObject).b())) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          localLayoutParams.e = bool1;
          if (localLayoutParams.a) {
            i2 = 1;
          } else {
            i2 = paramInt1;
          }
          i9 = a((View)localObject, i14, i2, i13, i8);
          i6 = Math.max(i6, i9);
          i2 = i1;
          if (localLayoutParams.d) {
            i2 = i1 + 1;
          }
          if (localLayoutParams.a) {
            n = 1;
          }
          paramInt1 -= i9;
          paramInt2 = Math.max(paramInt2, ((View)localObject).getMeasuredHeight());
          l2 = l1;
          if (i9 == 1) {
            l2 = l1 | 1 << i3;
          }
          i1 = i2;
          l1 = l2;
        }
        i3 += 1;
      }
      if ((n != 0) && (i7 == 2)) {
        i8 = 1;
      } else {
        i8 = 0;
      }
      int i2 = paramInt1;
      paramInt1 = 0;
      i3 = i5;
      while ((i1 > 0) && (i2 > 0))
      {
        i9 = 2147483647;
        int i10 = 0;
        int i11 = 0;
        for (long l3 = 0L; i10 < i15; l3 = l2)
        {
          localObject = (LayoutParams)getChildAt(i10).getLayoutParams();
          int i12 = i9;
          i5 = i11;
          l2 = l3;
          if (((LayoutParams)localObject).d) {
            if (((LayoutParams)localObject).b < i9)
            {
              i12 = ((LayoutParams)localObject).b;
              l2 = 1L << i10;
              i5 = 1;
            }
            else
            {
              i12 = i9;
              i5 = i11;
              l2 = l3;
              if (((LayoutParams)localObject).b == i9)
              {
                l2 = l3 | 1L << i10;
                i5 = i11 + 1;
                i12 = i9;
              }
            }
          }
          i10 += 1;
          i9 = i12;
          i11 = i5;
        }
        l1 |= l3;
        if (i11 <= i2)
        {
          i9 += 1;
          paramInt1 = i2;
          i5 = 0;
          i2 = i9;
          while (i5 < i15)
          {
            localObject = getChildAt(i5);
            localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
            long l4 = 1 << i5;
            if ((l3 & l4) == 0L)
            {
              l2 = l1;
              if (localLayoutParams.b == i2) {
                l2 = l1 | l4;
              }
              l1 = l2;
            }
            else
            {
              if ((i8 != 0) && (localLayoutParams.e) && (paramInt1 == 1))
              {
                i9 = this.l;
                ((View)localObject).setPadding(i9 + i14, 0, i9, 0);
              }
              localLayoutParams.b += 1;
              localLayoutParams.f = true;
              paramInt1 -= 1;
            }
            i5 += 1;
          }
          i5 = 1;
          i2 = paramInt1;
          paramInt1 = i5;
        }
        else {}
      }
      if ((n == 0) && (i7 == 1)) {
        n = 1;
      } else {
        n = 0;
      }
      i1 = paramInt1;
      if (i2 > 0)
      {
        i1 = paramInt1;
        if (l1 != 0L) {
          if ((i2 >= i7 - 1) && (n == 0))
          {
            i1 = paramInt1;
            if (i6 <= 1) {}
          }
          else
          {
            float f3 = Long.bitCount(l1);
            float f2 = f3;
            if (n == 0)
            {
              float f1 = f3;
              if ((l1 & 1L) != 0L)
              {
                f1 = f3;
                if (!((LayoutParams)getChildAt(0).getLayoutParams()).e) {
                  f1 = f3 - 0.5F;
                }
              }
              n = i15 - 1;
              f2 = f1;
              if ((l1 & 1 << n) != 0L)
              {
                f2 = f1;
                if (!((LayoutParams)getChildAt(n).getLayoutParams()).e) {
                  f2 = f1 - 0.5F;
                }
              }
            }
            if (f2 > 0.0F) {
              i1 = (int)(i2 * i14 / f2);
            } else {
              i1 = 0;
            }
            i2 = 0;
            while (i2 < i15)
            {
              if ((l1 & 1 << i2) != 0L)
              {
                localObject = getChildAt(i2);
                localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
                if ((localObject instanceof ActionMenuItemView))
                {
                  localLayoutParams.c = i1;
                  localLayoutParams.f = true;
                  if ((i2 == 0) && (!localLayoutParams.e)) {
                    localLayoutParams.leftMargin = (-i1 / 2);
                  }
                  n = 1;
                }
                else if (localLayoutParams.a)
                {
                  localLayoutParams.c = i1;
                  localLayoutParams.f = true;
                  localLayoutParams.rightMargin = (-i1 / 2);
                  n = 1;
                }
                else
                {
                  if (i2 != 0) {
                    localLayoutParams.leftMargin = (i1 / 2);
                  }
                  n = paramInt1;
                  if (i2 != i15 - 1)
                  {
                    localLayoutParams.rightMargin = (i1 / 2);
                    n = paramInt1;
                  }
                }
              }
              else
              {
                n = paramInt1;
              }
              i2 += 1;
              paramInt1 = n;
            }
            i1 = paramInt1;
          }
        }
      }
      if (i1 != 0)
      {
        paramInt1 = 0;
        while (paramInt1 < i15)
        {
          localObject = getChildAt(paramInt1);
          localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
          if (localLayoutParams.f) {
            ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(localLayoutParams.b * i14 + localLayoutParams.c, 1073741824), i13);
          }
          paramInt1 += 1;
        }
      }
      if (i3 == 1073741824) {
        paramInt2 = m;
      }
      setMeasuredDimension(i4, paramInt2);
      return;
    }
    m = 0;
    while (m < n)
    {
      localObject = (LayoutParams)getChildAt(m).getLayoutParams();
      ((LayoutParams)localObject).rightMargin = 0;
      ((LayoutParams)localObject).leftMargin = 0;
      m += 1;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setExpandedActionViewsExclusive(boolean paramBoolean)
  {
    this.c.l = paramBoolean;
  }
  
  public void setOnMenuItemClickListener(d paramd)
  {
    this.e = paramd;
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    getMenu();
    ActionMenuPresenter localActionMenuPresenter = this.c;
    if (localActionMenuPresenter.i != null)
    {
      localActionMenuPresenter.i.setImageDrawable(paramDrawable);
      return;
    }
    localActionMenuPresenter.k = true;
    localActionMenuPresenter.j = paramDrawable;
  }
  
  public void setOverflowReserved(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setPopupTheme(int paramInt)
  {
    if (this.g != paramInt)
    {
      this.g = paramInt;
      if (paramInt == 0)
      {
        this.f = getContext();
        return;
      }
      this.f = new ContextThemeWrapper(getContext(), paramInt);
    }
  }
  
  public void setPresenter(ActionMenuPresenter paramActionMenuPresenter)
  {
    this.c = paramActionMenuPresenter;
    this.c.a(this);
  }
  
  public static class LayoutParams
    extends LinearLayoutCompat.LayoutParams
  {
    @ViewDebug.ExportedProperty
    public boolean a;
    @ViewDebug.ExportedProperty
    public int b;
    @ViewDebug.ExportedProperty
    public int c;
    @ViewDebug.ExportedProperty
    public boolean d;
    @ViewDebug.ExportedProperty
    public boolean e;
    boolean f;
    
    public LayoutParams()
    {
      super(-2);
      this.a = false;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.a = paramLayoutParams.a;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean c();
    
    public abstract boolean d();
  }
  
  static final class b
    implements hs.a
  {
    public final void a(hl paramhl, boolean paramBoolean) {}
    
    public final boolean a(hl paramhl)
    {
      return false;
    }
  }
  
  final class c
    implements hl.a
  {
    c() {}
    
    public final void a(hl paramhl)
    {
      if (ActionMenuView.this.d != null) {
        ActionMenuView.this.d.a(paramhl);
      }
    }
    
    public final boolean a(hl paramhl, MenuItem paramMenuItem)
    {
      return (ActionMenuView.this.e != null) && (ActionMenuView.this.e.a(paramMenuItem));
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean a(MenuItem paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuView
 * JD-Core Version:    0.7.0.1
 */