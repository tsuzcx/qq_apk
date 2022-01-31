package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import exp;

public class CharJumpAnimView
  extends TextView
{
  public static final int a = -9223146;
  private static final long jdField_a_of_type_Long = 3500L;
  public static final int b = 59;
  public static final int c = 1;
  public static final int d = 20;
  private float jdField_a_of_type_Float;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener;
  private Runnable jdField_a_of_type_JavaLangRunnable = new exp(this);
  private String jdField_a_of_type_JavaLangString;
  private CharUnit[] jdField_a_of_type_ArrayOfComTencentMobileqqWidgetCharUnit;
  private long b = 0L;
  
  public CharJumpAnimView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public CharJumpAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public CharJumpAnimView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    int i = 0;
    this.jdField_a_of_type_JavaLangString = getText().toString();
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = getResources().getString(2131364179);
    }
    this.jdField_a_of_type_Float = getTextSize();
    setBackgroundColor(0);
    float f2 = TypedValue.applyDimension(1, 59.0F, getResources().getDisplayMetrics());
    setHeight((int)f2);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetCharUnit = new CharUnit[this.jdField_a_of_type_JavaLangString.length()];
    while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetCharUnit.length)
    {
      String str = this.jdField_a_of_type_JavaLangString.substring(i, i + 1);
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setColor(-9223146);
      localPaint.setTextSize(this.jdField_a_of_type_Float);
      float f1 = 0.0F;
      float f3 = localPaint.measureText(str);
      Object localObject = localPaint.getFontMetrics();
      float f4 = (float)Math.ceil(((Paint.FontMetrics)localObject).descent - ((Paint.FontMetrics)localObject).ascent);
      if (i > 0)
      {
        localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetCharUnit[(i - 1)];
        f1 = ((CharUnit)localObject).d;
        f1 = ((CharUnit)localObject).g + f1;
      }
      float f5 = f2 / 2.0F;
      float f6 = this.jdField_a_of_type_Float / 2.0F;
      localObject = new CharUnit();
      ((CharUnit)localObject).jdField_a_of_type_JavaLangString = str;
      ((CharUnit)localObject).jdField_a_of_type_AndroidGraphicsPaint = localPaint;
      ((CharUnit)localObject).d = f1;
      ((CharUnit)localObject).e = (f5 + f6);
      ((CharUnit)localObject).f = this.jdField_a_of_type_Float;
      ((CharUnit)localObject).g = f3;
      ((CharUnit)localObject).h = f4;
      this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetCharUnit[i] = localObject;
      i += 1;
    }
  }
  
  public void a() {}
  
  public void a(long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetCharUnit != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetCharUnit.length > 0))
    {
      paramLong2 /= this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetCharUnit.length;
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetCharUnit.length)
      {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetCharUnit[i].a(i, paramLong1, paramLong2);
        i += 1;
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetCharUnit != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetCharUnit[(this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetCharUnit.length - 1)].i != 1.0F);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int j = this.jdField_a_of_type_JavaLangString.length();
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetCharUnit[i].a(paramCanvas);
      i += 1;
    }
  }
  
  public void setText(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    setText(paramInt);
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = paramAnimationListener;
    this.b = 0L;
    postDelayed(this.jdField_a_of_type_JavaLangRunnable, 20L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CharJumpAnimView
 * JD-Core Version:    0.7.0.1
 */