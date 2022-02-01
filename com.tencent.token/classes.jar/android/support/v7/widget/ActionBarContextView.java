package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.token.fo;
import com.tencent.token.hg.a;
import com.tencent.token.hg.f;
import com.tencent.token.hg.g;
import com.tencent.token.hg.j;
import com.tencent.token.ho;
import com.tencent.token.id;
import com.tencent.token.is;
import com.tencent.token.jw;
import com.tencent.token.kc;

public class ActionBarContextView
  extends is
{
  public boolean g;
  private CharSequence h;
  private CharSequence i;
  private View j;
  private View k;
  private LinearLayout l;
  private TextView m;
  private TextView n;
  private int o;
  private int p;
  private int q;
  
  public ActionBarContextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, hg.a.actionModeStyle);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = jw.a(paramContext, paramAttributeSet, hg.j.ActionMode, paramInt, 0);
    fo.a(this, paramContext.a(hg.j.ActionMode_background));
    this.o = paramContext.g(hg.j.ActionMode_titleTextStyle, 0);
    this.p = paramContext.g(hg.j.ActionMode_subtitleTextStyle, 0);
    this.e = paramContext.f(hg.j.ActionMode_height, 0);
    this.q = paramContext.g(hg.j.ActionMode_closeItemLayout, hg.g.abc_action_mode_close_item_material);
    paramContext.a.recycle();
  }
  
  private void d()
  {
    if (this.l == null)
    {
      LayoutInflater.from(getContext()).inflate(hg.g.abc_action_bar_title_item, this);
      this.l = ((LinearLayout)getChildAt(getChildCount() - 1));
      this.m = ((TextView)this.l.findViewById(hg.f.action_bar_title));
      this.n = ((TextView)this.l.findViewById(hg.f.action_bar_subtitle));
      if (this.o != 0) {
        this.m.setTextAppearance(getContext(), this.o);
      }
      if (this.p != 0) {
        this.n.setTextAppearance(getContext(), this.p);
      }
    }
    this.m.setText(this.h);
    this.n.setText(this.i);
    boolean bool2 = TextUtils.isEmpty(this.h);
    boolean bool1 = TextUtils.isEmpty(this.i) ^ true;
    Object localObject = this.n;
    int i2 = 0;
    if (bool1) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((TextView)localObject).setVisibility(i1);
    localObject = this.l;
    int i1 = i2;
    if (!(bool2 ^ true)) {
      if (bool1) {
        i1 = i2;
      } else {
        i1 = 8;
      }
    }
    ((LinearLayout)localObject).setVisibility(i1);
    if (this.l.getParent() == null) {
      addView(this.l);
    }
  }
  
  public final void a(final ho paramho)
  {
    Object localObject = this.j;
    if (localObject == null)
    {
      this.j = LayoutInflater.from(getContext()).inflate(this.q, this, false);
      addView(this.j);
    }
    else if (((View)localObject).getParent() == null)
    {
      addView(this.j);
    }
    this.j.findViewById(hg.f.action_mode_close_button).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramho.c();
      }
    });
    paramho = (id)paramho.b();
    if (this.d != null) {
      this.d.f();
    }
    this.d = new ActionMenuPresenter(getContext());
    this.d.c();
    localObject = new ViewGroup.LayoutParams(-2, -1);
    paramho.a(this.d, this.b);
    this.c = ((ActionMenuView)this.d.a(this));
    fo.a(this.c, null);
    addView(this.c, (ViewGroup.LayoutParams)localObject);
  }
  
  public final boolean a()
  {
    if (this.d != null) {
      return this.d.d();
    }
    return false;
  }
  
  public final void b()
  {
    if (this.j == null)
    {
      c();
      return;
    }
  }
  
  public final void c()
  {
    removeAllViews();
    this.k = null;
    this.c = null;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.MarginLayoutParams(-1, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  public CharSequence getSubtitle()
  {
    return this.i;
  }
  
  public CharSequence getTitle()
  {
    return this.h;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.d != null)
    {
      this.d.e();
      this.d.g();
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 32)
    {
      paramAccessibilityEvent.setSource(this);
      paramAccessibilityEvent.setClassName(getClass().getName());
      paramAccessibilityEvent.setPackageName(getContext().getPackageName());
      paramAccessibilityEvent.setContentDescription(this.h);
      return;
    }
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramBoolean = kc.a(this);
    int i1;
    if (paramBoolean) {
      i1 = paramInt3 - paramInt1 - getPaddingRight();
    } else {
      i1 = getPaddingLeft();
    }
    int i2 = getPaddingTop();
    int i3 = paramInt4 - paramInt2 - getPaddingTop() - getPaddingBottom();
    Object localObject = this.j;
    paramInt2 = i1;
    if (localObject != null)
    {
      paramInt2 = i1;
      if (((View)localObject).getVisibility() != 8)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.j.getLayoutParams();
        if (paramBoolean) {
          paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
        } else {
          paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
        }
        if (paramBoolean) {
          paramInt4 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
        } else {
          paramInt4 = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
        }
        paramInt2 = a(i1, paramInt2, paramBoolean);
        paramInt2 = a(paramInt2 + a(this.j, paramInt2, i2, i3, paramBoolean), paramInt4, paramBoolean);
      }
    }
    localObject = this.l;
    paramInt4 = paramInt2;
    if (localObject != null)
    {
      paramInt4 = paramInt2;
      if (this.k == null)
      {
        paramInt4 = paramInt2;
        if (((LinearLayout)localObject).getVisibility() != 8) {
          paramInt4 = paramInt2 + a(this.l, paramInt2, i2, i3, paramBoolean);
        }
      }
    }
    localObject = this.k;
    if (localObject != null) {
      a((View)localObject, paramInt4, i2, i3, paramBoolean);
    }
    if (paramBoolean) {
      paramInt1 = getPaddingLeft();
    } else {
      paramInt1 = paramInt3 - paramInt1 - getPaddingRight();
    }
    if (this.c != null) {
      a(this.c, paramInt1, i2, i3, paramBoolean ^ true);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i3 = 1073741824;
    if (i1 == 1073741824)
    {
      if (View.MeasureSpec.getMode(paramInt2) != 0)
      {
        int i6 = View.MeasureSpec.getSize(paramInt1);
        if (this.e > 0) {
          i1 = this.e;
        } else {
          i1 = View.MeasureSpec.getSize(paramInt2);
        }
        int i7 = getPaddingTop() + getPaddingBottom();
        paramInt1 = i6 - getPaddingLeft() - getPaddingRight();
        int i4 = i1 - i7;
        int i2 = View.MeasureSpec.makeMeasureSpec(i4, -2147483648);
        localObject = this.j;
        paramInt2 = paramInt1;
        if (localObject != null)
        {
          paramInt1 = a((View)localObject, paramInt1, i2);
          localObject = (ViewGroup.MarginLayoutParams)this.j.getLayoutParams();
          paramInt2 = paramInt1 - (((ViewGroup.MarginLayoutParams)localObject).leftMargin + ((ViewGroup.MarginLayoutParams)localObject).rightMargin);
        }
        paramInt1 = paramInt2;
        if (this.c != null)
        {
          paramInt1 = paramInt2;
          if (this.c.getParent() == this) {
            paramInt1 = a(this.c, paramInt2, i2);
          }
        }
        localObject = this.l;
        int i5 = 0;
        paramInt2 = paramInt1;
        if (localObject != null)
        {
          paramInt2 = paramInt1;
          if (this.k == null) {
            if (this.g)
            {
              paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
              this.l.measure(paramInt2, i2);
              int i8 = this.l.getMeasuredWidth();
              if (i8 <= paramInt1) {
                i2 = 1;
              } else {
                i2 = 0;
              }
              paramInt2 = paramInt1;
              if (i2 != 0) {
                paramInt2 = paramInt1 - i8;
              }
              localObject = this.l;
              if (i2 != 0) {
                paramInt1 = 0;
              } else {
                paramInt1 = 8;
              }
              ((LinearLayout)localObject).setVisibility(paramInt1);
            }
            else
            {
              paramInt2 = a((View)localObject, paramInt1, i2);
            }
          }
        }
        localObject = this.k;
        if (localObject != null)
        {
          localObject = ((View)localObject).getLayoutParams();
          if (((ViewGroup.LayoutParams)localObject).width != -2) {
            paramInt1 = 1073741824;
          } else {
            paramInt1 = -2147483648;
          }
          i2 = paramInt2;
          if (((ViewGroup.LayoutParams)localObject).width >= 0) {
            i2 = Math.min(((ViewGroup.LayoutParams)localObject).width, paramInt2);
          }
          if (((ViewGroup.LayoutParams)localObject).height != -2) {
            paramInt2 = i3;
          } else {
            paramInt2 = -2147483648;
          }
          i3 = i4;
          if (((ViewGroup.LayoutParams)localObject).height >= 0) {
            i3 = Math.min(((ViewGroup.LayoutParams)localObject).height, i4);
          }
          this.k.measure(View.MeasureSpec.makeMeasureSpec(i2, paramInt1), View.MeasureSpec.makeMeasureSpec(i3, paramInt2));
        }
        if (this.e <= 0)
        {
          i3 = getChildCount();
          paramInt2 = 0;
          paramInt1 = i5;
          while (paramInt1 < i3)
          {
            i2 = getChildAt(paramInt1).getMeasuredHeight() + i7;
            i1 = paramInt2;
            if (i2 > paramInt2) {
              i1 = i2;
            }
            paramInt1 += 1;
            paramInt2 = i1;
          }
          setMeasuredDimension(i6, paramInt2);
          return;
        }
        setMeasuredDimension(i6, i1);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getClass().getSimpleName());
      ((StringBuilder)localObject).append(" can only be used with android:layout_height=\"wrap_content\"");
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getClass().getSimpleName());
    ((StringBuilder)localObject).append(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void setContentHeight(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setCustomView(View paramView)
  {
    Object localObject = this.k;
    if (localObject != null) {
      removeView((View)localObject);
    }
    this.k = paramView;
    if (paramView != null)
    {
      localObject = this.l;
      if (localObject != null)
      {
        removeView((View)localObject);
        this.l = null;
      }
    }
    if (paramView != null) {
      addView(paramView);
    }
    requestLayout();
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.i = paramCharSequence;
    d();
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.h = paramCharSequence;
    d();
  }
  
  public void setTitleOptional(boolean paramBoolean)
  {
    if (paramBoolean != this.g) {
      requestLayout();
    }
    this.g = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionBarContextView
 * JD-Core Version:    0.7.0.1
 */