package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import hkm;
import hkn;
import hko;

@SuppressLint({"ResourceAsColor"})
public class CustomedTabWidget
  extends LinearLayout
{
  private static final int jdField_b_of_type_Int = -1;
  private static final int jdField_c_of_type_Int = 10;
  private static final int d = 20;
  private static final int e = 4;
  public float a;
  public int a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  public Rect a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private CustomedTabWidget.OnSwitchTabListener jdField_a_of_type_ComTencentMobileqqWidgetCustomedTabWidget$OnSwitchTabListener;
  public hko a;
  public boolean a;
  private float jdField_b_of_type_Float;
  public Rect b;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  private int f = 0;
  
  public CustomedTabWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)inflate(paramContext, 2130903979, null));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidWidgetImageView.getBackground();
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130840190);
    this.c = paramContext.getResources().getDrawable(2130840189);
    this.jdField_b_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Hko = new hko(this);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == this.f) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetCustomedTabWidget$OnSwitchTabListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCustomedTabWidget$OnSwitchTabListener.a(paramInt);
      }
      getChildAt(this.f).setSelected(false);
      this.f = paramInt;
      getChildAt(this.f).setSelected(true);
      getChildAt(this.f).getHitRect(this.jdField_a_of_type_AndroidGraphicsRect);
    } while ((this.jdField_a_of_type_AndroidGraphicsRect.left == this.jdField_b_of_type_AndroidGraphicsRect.left) && (this.jdField_a_of_type_AndroidGraphicsRect.right == this.jdField_b_of_type_AndroidGraphicsRect.right));
    this.jdField_a_of_type_Float = ((this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_b_of_type_AndroidGraphicsRect.left) / 4);
    this.jdField_a_of_type_Hko.sendEmptyMessage(0);
  }
  
  private void a(View paramView)
  {
    paramView.setOnClickListener(new hkm(this));
    paramView.setOnTouchListener(new hkn(this));
    if (getChildCount() == 1) {
      paramView.setSelected(true);
    }
  }
  
  public int a()
  {
    return this.f;
  }
  
  public void addView(View paramView)
  {
    super.addView(paramView);
    a(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    super.addView(paramView, paramInt);
    a(paramView);
  }
  
  public void addView(View paramView, int paramInt1, int paramInt2)
  {
    super.addView(paramView, paramInt1, paramInt2);
    a(paramView);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    a(paramView);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramLayoutParams);
    a(paramView);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.c.setBounds(0, getHeight() - 6, getWidth(), getHeight());
    this.c.draw(paramCanvas);
    int i = getWidth() / getChildCount();
    int j = this.jdField_b_of_type_AndroidGraphicsRect.centerX() - i / 2;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(j, this.jdField_b_of_type_AndroidGraphicsRect.bottom - (int)(4.0F * this.jdField_b_of_type_Float), i + j, this.jdField_b_of_type_AndroidGraphicsRect.bottom);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    getChildAt(this.f).getHitRect(this.jdField_a_of_type_AndroidGraphicsRect);
    this.jdField_b_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    setCurrentTab(this.f);
  }
  
  public void setCurrentTab(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getChildCount())) {
      a(paramInt);
    }
  }
  
  public void setOnSwitchTabListener(CustomedTabWidget.OnSwitchTabListener paramOnSwitchTabListener)
  {
    this.jdField_a_of_type_Hko.removeMessages(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomedTabWidget$OnSwitchTabListener = paramOnSwitchTabListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CustomedTabWidget
 * JD-Core Version:    0.7.0.1
 */