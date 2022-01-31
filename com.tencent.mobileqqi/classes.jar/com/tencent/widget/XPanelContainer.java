package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.util.AnimateUtils;
import com.tencent.util.VersionUtils;

public class XPanelContainer
  extends FrameLayout
  implements Runnable
{
  public static final int a = 0;
  private static final String jdField_a_of_type_JavaLangString = XPanelContainer.class.getSimpleName();
  public static final int b = 1;
  private static final long b = 1L;
  private static final int e = -1;
  private static final int l = 0;
  private static int m = 0;
  private long jdField_a_of_type_Long = -1L;
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(4);
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private XPanelContainer.PanelCallback jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback;
  private int c;
  private int d = 0;
  private int f = -1;
  private int g = -1;
  private int h = -1;
  private int i = -1;
  private int j = -1;
  private int k = 0;
  
  public XPanelContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    int n = getResources().getConfiguration().orientation;
    if (n == 1) {
      this.c = ((int)(paramContext.getResources().getDisplayMetrics().density * 200.0F));
    }
    while (n != 2) {
      return;
    }
    this.c = ((int)(paramContext.getResources().getDisplayMetrics().density * 200.0F));
  }
  
  private void b()
  {
    if (AnimationUtils.currentAnimationTimeMillis() >= this.jdField_a_of_type_Long + 0L)
    {
      this.k = 0;
      return;
    }
    float f1 = (float)(AnimationUtils.currentAnimationTimeMillis() - this.jdField_a_of_type_Long) / 0.0F;
    this.k = ((int)(this.c - AnimateUtils.a(f1) * this.c));
  }
  
  private void c(int paramInt)
  {
    if (paramInt != this.d)
    {
      int n = this.d;
      this.d = paramInt;
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback != null) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback.a(n, this.d);
      }
      URLDrawable.resume();
      if ((this.jdField_a_of_type_AndroidViewView != null) && (paramInt <= 1))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView = null;
      }
    }
  }
  
  public int a()
  {
    return this.d;
  }
  
  public void a()
  {
    this.f = -1;
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    c(0);
    requestLayout();
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.requestFocus();
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this.jdField_a_of_type_AndroidWidgetTextView, 0);
    }
    do
    {
      do
      {
        return;
        if (paramInt <= 1) {
          break label208;
        }
        View localView2 = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        View localView1 = localView2;
        if (localView2 == null)
        {
          localView1 = this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback.a(paramInt);
          addView(localView1);
          this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localView1);
        }
        if (localView1 != this.jdField_a_of_type_AndroidViewView)
        {
          if (this.jdField_a_of_type_AndroidViewView != null) {
            this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          }
          localView1.setVisibility(0);
          this.jdField_a_of_type_AndroidViewView = localView1;
        }
        if (this.d != 0) {
          break;
        }
      } while (this.k > 0);
      this.f = paramInt;
      URLDrawable.pause();
      this.k = this.c;
      this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
      requestLayout();
      return;
      if (this.d == 1)
      {
        this.f = paramInt;
        ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
        return;
      }
    } while (this.d == paramInt);
    c(paramInt);
    return;
    label208:
    throw new IllegalArgumentException("wrong argument..must be SOFT_INPUT,EXTERNAL_EMOTICON,EXTERNAL_INPUT");
  }
  
  public void a(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public boolean a()
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.d > 0)
    {
      bool1 = true;
      if (this.d != 1) {
        break label49;
      }
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    }
    for (;;)
    {
      label40:
      bool2 = bool1;
      label49:
      do
      {
        return bool2;
        bool1 = false;
        break;
        if (this.d <= 1) {
          break label40;
        }
      } while (this.k > 0);
      this.f = 0;
      this.k = this.c;
      this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
      requestLayout();
    }
  }
  
  public void b(int paramInt)
  {
    int n = 0;
    while (n < getChildCount())
    {
      getChildAt(n).offsetTopAndBottom(paramInt);
      n += 1;
    }
    invalidate();
  }
  
  @TargetApi(13)
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (VersionUtils.f()) {
      if ((paramConfiguration.orientation != this.h) && ((this.i != paramConfiguration.screenWidthDp) || (this.j != paramConfiguration.screenHeightDp)))
      {
        this.h = -1;
        this.j = -1;
        this.j = -1;
        this.g = -1;
        a();
      }
    }
    while (paramConfiguration.orientation == this.h) {
      return;
    }
    this.h = -1;
    this.g = -1;
    a();
  }
  
  @TargetApi(13)
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int n = paramInt4 - paramInt2;
    int i1 = this.d;
    Object localObject;
    if ((this.g < 0) && (paramBoolean) && (n > 0))
    {
      localObject = getResources().getConfiguration();
      this.h = ((Configuration)localObject).orientation;
      if (VersionUtils.f())
      {
        this.i = ((Configuration)localObject).screenWidthDp;
        this.j = ((Configuration)localObject).screenHeightDp;
      }
      this.g = n;
      if ((this.g <= n) || (this.g - n <= 0.2F * this.g)) {
        break label238;
      }
      n = 1;
      label108:
      paramInt1 = paramInt3 - paramInt1 - this.mPaddingRight;
      paramInt3 = this.mPaddingLeft;
      paramInt2 = paramInt4 - paramInt2 - this.mPaddingBottom;
      paramInt4 = this.mPaddingTop;
      localObject = getChildAt(0);
      if ((n == 0) || (this.d == 1)) {
        break label244;
      }
      ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt1 - paramInt3, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - paramInt4, 1073741824));
      ((View)localObject).layout(paramInt3, paramInt4, paramInt1, paramInt2);
      m = paramInt2;
      label198:
      if ((!paramBoolean) || (n == 0)) {
        break label775;
      }
      paramInt1 = 1;
      this.f = -1;
    }
    for (;;)
    {
      c(paramInt1);
      return;
      if (n <= this.g) {
        break;
      }
      this.g = n;
      break;
      label238:
      n = 0;
      break label108;
      label244:
      if ((this.f > 1) && ((n == 0) || (paramBoolean)))
      {
        n = getResources().getConfiguration().orientation;
        if (n == 1) {
          if (m != 0) {
            this.c = ((int)(200.0F * this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density));
          }
        }
        for (;;)
        {
          b();
          n = this.c - this.k;
          this.jdField_a_of_type_AndroidViewView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 - paramInt3, 1073741824), View.MeasureSpec.makeMeasureSpec(this.c, 1073741824));
          this.jdField_a_of_type_AndroidViewView.layout(paramInt3, paramInt2 - n, paramInt1, paramInt2 - n + this.c);
          ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt1 - paramInt3, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - paramInt4 - n, 1073741824));
          ((View)localObject).layout(paramInt3, paramInt4, paramInt1, paramInt2 - n);
          if (this.k != 0) {
            break;
          }
          c(this.f);
          this.f = -1;
          return;
          this.c = ((int)(200.0F * this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density));
          continue;
          if (n == 2) {
            this.c = ((int)(200.0F * this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density));
          }
        }
        postDelayed(this, 1L);
        return;
      }
      if ((this.f == 0) && (this.d > 1))
      {
        b();
        this.jdField_a_of_type_AndroidViewView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 - paramInt3, 1073741824), View.MeasureSpec.makeMeasureSpec(this.c, 1073741824));
        this.jdField_a_of_type_AndroidViewView.layout(paramInt3, paramInt2 - this.k, paramInt1, paramInt2 - this.k + this.c);
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt1 - paramInt3, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - paramInt4 - this.k, 1073741824));
        ((View)localObject).layout(paramInt3, paramInt4, paramInt1, paramInt2 - this.k);
        if (this.k == 0)
        {
          c(this.f);
          this.f = -1;
          return;
        }
        postDelayed(this, 1L);
        return;
      }
      if ((this.d > 1) && (n == 0))
      {
        this.jdField_a_of_type_AndroidViewView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 - paramInt3, 1073741824), View.MeasureSpec.makeMeasureSpec(this.c, 1073741824));
        this.jdField_a_of_type_AndroidViewView.layout(paramInt3, paramInt2 - this.c, paramInt1, paramInt2);
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt1 - paramInt3, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - paramInt4 - this.c, 1073741824));
        ((View)localObject).layout(paramInt3, paramInt4, paramInt1, paramInt2 - this.c);
        break label198;
      }
      ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt1 - paramInt3, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - paramInt4, 1073741824));
      ((View)localObject).layout(paramInt3, paramInt4, paramInt1, paramInt2);
      break label198;
      label775:
      if ((this.f == 0) || ((paramBoolean) && (n == 0)))
      {
        paramInt1 = 0;
        this.f = -1;
      }
      else
      {
        paramInt1 = i1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), paramInt1), getDefaultSize(getSuggestedMinimumHeight(), paramInt2));
  }
  
  public void run()
  {
    requestLayout();
  }
  
  public void setOnPanelChangeListener(XPanelContainer.PanelCallback paramPanelCallback)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback = paramPanelCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.widget.XPanelContainer
 * JD-Core Version:    0.7.0.1
 */