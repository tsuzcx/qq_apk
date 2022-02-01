package com.tencent.token;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar.a;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Spinner;
import android.widget.TextView;

public final class iz
  extends HorizontalScrollView
  implements AdapterView.OnItemSelectedListener
{
  private static final Interpolator i = new DecelerateInterpolator();
  Runnable a;
  LinearLayoutCompat b;
  int c;
  int d;
  int e;
  private Spinner f;
  private boolean g;
  private int h;
  
  private boolean a()
  {
    Spinner localSpinner = this.f;
    return (localSpinner != null) && (localSpinner.getParent() == this);
  }
  
  private boolean b()
  {
    if (!a()) {
      return false;
    }
    removeView(this.f);
    addView(this.b, new ViewGroup.LayoutParams(-2, -1));
    setTabSelected(this.f.getSelectedItemPosition());
    return false;
  }
  
  public final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Runnable localRunnable = this.a;
    if (localRunnable != null) {
      post(localRunnable);
    }
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = gw.a(getContext());
    TypedArray localTypedArray = paramConfiguration.a.obtainStyledAttributes(null, gp.j.ActionBar, gp.a.actionBarStyle, 0);
    int k = localTypedArray.getLayoutDimension(gp.j.ActionBar_height, 0);
    Resources localResources = paramConfiguration.a.getResources();
    int j = k;
    if (!paramConfiguration.b()) {
      j = Math.min(k, localResources.getDimensionPixelSize(gp.d.abc_action_bar_stacked_max_height));
    }
    localTypedArray.recycle();
    setContentHeight(j);
    this.d = paramConfiguration.a.getResources().getDimensionPixelSize(gp.d.abc_action_bar_stacked_tab_max_width);
  }
  
  public final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Runnable localRunnable = this.a;
    if (localRunnable != null) {
      removeCallbacks(localRunnable);
    }
  }
  
  public final void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    paramInt2 = 1;
    boolean bool;
    if (j == 1073741824) {
      bool = true;
    } else {
      bool = false;
    }
    setFillViewport(bool);
    int k = this.b.getChildCount();
    if ((k > 1) && ((j == 1073741824) || (j == -2147483648)))
    {
      if (k > 2) {
        this.c = ((int)(View.MeasureSpec.getSize(paramInt1) * 0.4F));
      } else {
        this.c = (View.MeasureSpec.getSize(paramInt1) / 2);
      }
      this.c = Math.min(this.c, this.d);
    }
    else
    {
      this.c = -1;
    }
    j = View.MeasureSpec.makeMeasureSpec(this.e, 1073741824);
    if ((bool) || (!this.g)) {
      paramInt2 = 0;
    }
    if (paramInt2 != 0)
    {
      this.b.measure(0, j);
      if (this.b.getMeasuredWidth() > View.MeasureSpec.getSize(paramInt1))
      {
        if (!a())
        {
          if (this.f == null)
          {
            localObject = new AppCompatSpinner(getContext(), null, gp.a.actionDropDownStyle);
            ((Spinner)localObject).setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
            ((Spinner)localObject).setOnItemSelectedListener(this);
            this.f = ((Spinner)localObject);
          }
          removeView(this.b);
          addView(this.f, new ViewGroup.LayoutParams(-2, -1));
          if (this.f.getAdapter() == null) {
            this.f.setAdapter(new a());
          }
          Object localObject = this.a;
          if (localObject != null)
          {
            removeCallbacks((Runnable)localObject);
            this.a = null;
          }
          this.f.setSelection(this.h);
        }
      }
      else {
        b();
      }
    }
    else
    {
      b();
    }
    paramInt2 = getMeasuredWidth();
    super.onMeasure(paramInt1, j);
    paramInt1 = getMeasuredWidth();
    if ((bool) && (paramInt2 != paramInt1)) {
      setTabSelected(this.h);
    }
  }
  
  public final void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public final void setAllowCollapse(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public final void setContentHeight(int paramInt)
  {
    this.e = paramInt;
    requestLayout();
  }
  
  public final void setTabSelected(int paramInt)
  {
    this.h = paramInt;
    int k = this.b.getChildCount();
    int j = 0;
    while (j < k)
    {
      localObject = this.b.getChildAt(j);
      boolean bool;
      if (j == paramInt) {
        bool = true;
      } else {
        bool = false;
      }
      ((View)localObject).setSelected(bool);
      if (bool)
      {
        localObject = this.b.getChildAt(paramInt);
        Runnable localRunnable = this.a;
        if (localRunnable != null) {
          removeCallbacks(localRunnable);
        }
        this.a = new Runnable()
        {
          public final void run()
          {
            int i = this.a.getLeft();
            int j = (iz.this.getWidth() - this.a.getWidth()) / 2;
            iz.this.smoothScrollTo(i - j, 0);
            iz.this.a = null;
          }
        };
        post(this.a);
      }
      j += 1;
    }
    Object localObject = this.f;
    if ((localObject != null) && (paramInt >= 0)) {
      ((Spinner)localObject).setSelection(paramInt);
    }
  }
  
  final class a
    extends BaseAdapter
  {
    a() {}
    
    public final int getCount()
    {
      return iz.this.b.getChildCount();
    }
    
    public final Object getItem(int paramInt)
    {
      return ((iz.b)iz.this.b.getChildAt(paramInt)).a;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = iz.this;
        paramViewGroup = (ActionBar.a)getItem(paramInt);
        paramViewGroup = new iz.b(paramView, paramView.getContext(), paramViewGroup);
        paramViewGroup.setBackgroundDrawable(null);
        paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, paramView.e));
        return paramViewGroup;
      }
      paramViewGroup = (iz.b)paramView;
      paramViewGroup.a = ((ActionBar.a)getItem(paramInt));
      paramViewGroup.a();
      return paramView;
    }
  }
  
  final class b
    extends LinearLayout
  {
    ActionBar.a a;
    private final int[] c = { 16842964 };
    private TextView d;
    private ImageView e;
    private View f;
    
    public b(Context paramContext, ActionBar.a parama)
    {
      super(null, gp.a.actionBarTabStyle);
      this.a = parama;
      this$1 = jf.a(paramContext, null, this.c, gp.a.actionBarTabStyle, 0);
      if (iz.this.f(0)) {
        setBackgroundDrawable(iz.this.a(0));
      }
      iz.this.a.recycle();
      setGravity(8388627);
      a();
    }
    
    public final void a()
    {
      ActionBar.a locala = this.a;
      Object localObject2 = locala.c();
      Object localObject1 = null;
      if (localObject2 != null)
      {
        localObject1 = ((View)localObject2).getParent();
        if (localObject1 != this)
        {
          if (localObject1 != null) {
            ((ViewGroup)localObject1).removeView((View)localObject2);
          }
          addView((View)localObject2);
        }
        this.f = ((View)localObject2);
        localObject1 = this.d;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
        localObject1 = this.e;
        if (localObject1 != null)
        {
          ((ImageView)localObject1).setVisibility(8);
          this.e.setImageDrawable(null);
        }
        return;
      }
      localObject2 = this.f;
      if (localObject2 != null)
      {
        removeView((View)localObject2);
        this.f = null;
      }
      Object localObject3 = locala.a();
      localObject2 = locala.b();
      Object localObject4;
      if (localObject3 != null)
      {
        if (this.e == null)
        {
          localObject4 = new AppCompatImageView(getContext());
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
          localLayoutParams.gravity = 16;
          ((ImageView)localObject4).setLayoutParams(localLayoutParams);
          addView((View)localObject4, 0);
          this.e = ((ImageView)localObject4);
        }
        this.e.setImageDrawable((Drawable)localObject3);
        this.e.setVisibility(0);
      }
      else
      {
        localObject3 = this.e;
        if (localObject3 != null)
        {
          ((ImageView)localObject3).setVisibility(8);
          this.e.setImageDrawable(null);
        }
      }
      boolean bool = TextUtils.isEmpty((CharSequence)localObject2) ^ true;
      if (bool)
      {
        if (this.d == null)
        {
          localObject3 = new AppCompatTextView(getContext(), null, gp.a.actionBarTabTextStyle);
          ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
          localObject4 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject4).gravity = 16;
          ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          addView((View)localObject3);
          this.d = ((TextView)localObject3);
        }
        this.d.setText((CharSequence)localObject2);
        this.d.setVisibility(0);
      }
      else
      {
        localObject2 = this.d;
        if (localObject2 != null)
        {
          ((TextView)localObject2).setVisibility(8);
          this.d.setText(null);
        }
      }
      localObject2 = this.e;
      if (localObject2 != null) {
        ((ImageView)localObject2).setContentDescription(locala.d());
      }
      if (!bool) {
        localObject1 = locala.d();
      }
      jh.a(this, (CharSequence)localObject1);
    }
    
    public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ActionBar.a.class.getName());
    }
    
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName(ActionBar.a.class.getName());
    }
    
    public final void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      if ((iz.this.c > 0) && (getMeasuredWidth() > iz.this.c)) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(iz.this.c, 1073741824), paramInt2);
      }
    }
    
    public final void setSelected(boolean paramBoolean)
    {
      int i;
      if (isSelected() != paramBoolean) {
        i = 1;
      } else {
        i = 0;
      }
      super.setSelected(paramBoolean);
      if ((i != 0) && (paramBoolean)) {
        sendAccessibilityEvent(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.iz
 * JD-Core Version:    0.7.0.1
 */