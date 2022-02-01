package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import hhw;
import hhx;

public class TabBarView
  extends LinearLayout
{
  private static final int jdField_a_of_type_Int;
  public static final String a;
  private static final int b;
  private static final int c;
  private static final int d;
  private static final int g = 10;
  private static final int h = 0;
  private static final int i = 1;
  private static final int j = 2;
  private float jdField_a_of_type_Float;
  public final Paint a;
  private Handler jdField_a_of_type_AndroidOsHandler = new hhw(this);
  private LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
  public TabBarView.OnTabChangeListener a;
  private int e = -1;
  private int f = -1;
  
  static
  {
    jdField_a_of_type_JavaLangString = TabBarView.class.getSimpleName();
    Context localContext = BaseApplicationImpl.getContext();
    jdField_a_of_type_Int = localContext.getResources().getColor(2131362083);
    b = localContext.getResources().getColor(2131362107);
    c = (int)(46.0F * localContext.getResources().getDisplayMetrics().density + 0.5F);
    d = (int)(localContext.getResources().getDisplayMetrics().density * 3.0F + 0.5F);
  }
  
  public TabBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(0, -1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.weight = 1.0F;
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.gravity = 17;
    setBackgroundDrawable(getResources().getDrawable(2130840205));
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener.a(paramInt1, paramInt2);
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    View localView = getChildAt(paramInt1);
    if ((localView != null) && ((localView instanceof TextView))) {
      ((TextView)localView).setTextColor(b);
    }
    localView = getChildAt(paramInt2);
    if ((localView != null) && ((localView instanceof TextView))) {
      ((TextView)localView).setTextColor(jdField_a_of_type_Int);
    }
  }
  
  public int a()
  {
    return this.f;
  }
  
  public RedDotTextView a(int paramInt)
  {
    View localView = getChildAt(paramInt);
    if ((localView instanceof RedDotTextView)) {
      return (RedDotTextView)localView;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getChildCount())) {
      throw new IllegalArgumentException("index is not legal, please check!");
    }
    removeViewAt(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt < 0) || (paramInt > getChildCount())) {
      throw new IllegalArgumentException("position is not legal, please check!");
    }
    RedDotTextView localRedDotTextView = new RedDotTextView(getContext());
    localRedDotTextView.setText(paramString);
    localRedDotTextView.setTextSize(2, 15.0F);
    localRedDotTextView.setTextColor(b);
    localRedDotTextView.setSingleLine();
    localRedDotTextView.setFocusable(true);
    localRedDotTextView.setContentDescription(paramString);
    localRedDotTextView.setGravity(17);
    localRedDotTextView.setOnClickListener(new hhx(this, paramInt));
    addView(localRedDotTextView, paramInt, this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
  }
  
  public void a(String paramString)
  {
    a(getChildCount(), paramString);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    View localView1 = getChildAt(this.f);
    if (localView1 != null)
    {
      int n = localView1.getLeft();
      int i1 = localView1.getRight();
      int m = i1;
      int k = n;
      if (this.jdField_a_of_type_Float > 0.0F)
      {
        View localView2 = getChildAt(this.e);
        m = i1;
        k = n;
        if (localView2 != null)
        {
          k = (int)(localView1.getLeft() + this.jdField_a_of_type_Float * (localView2.getLeft() - localView1.getLeft()));
          float f1 = localView1.getRight();
          float f2 = this.jdField_a_of_type_Float;
          m = (int)(f1 + (localView2.getRight() - localView1.getRight()) * f2);
        }
      }
      paramCanvas.drawRect(k, getHeight() - d, m, getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(c, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), c);
  }
  
  public void setOnTabChangeListener(TabBarView.OnTabChangeListener paramOnTabChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = paramOnTabChangeListener;
  }
  
  public void setSelectedTab(int paramInt, boolean paramBoolean)
  {
    int k = paramInt;
    if (paramInt < 0) {
      k = 0;
    }
    int m = getChildCount();
    paramInt = k;
    if (k >= m) {
      paramInt = m - 1;
    }
    if (this.f != paramInt)
    {
      a(this.f, paramInt);
      if (paramBoolean)
      {
        this.e = paramInt;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      }
    }
    else
    {
      return;
    }
    b(this.f, paramInt);
    this.f = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabBarView
 * JD-Core Version:    0.7.0.1
 */