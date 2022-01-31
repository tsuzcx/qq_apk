package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;

public class TipsLinearLayout
  extends LinearLayout
{
  private static final int jdField_a_of_type_Int = 300;
  private static final String jdField_a_of_type_JavaLangString = "TipsLinearLayout";
  private static final int jdField_b_of_type_Int = 0;
  private static final int c = 1;
  private static final int d = 2;
  private float jdField_a_of_type_Float = 0.0F;
  private long jdField_a_of_type_Long;
  private TipsLinearLayout.TipsLayoutAnimListener jdField_a_of_type_ComTencentWidgetTipsLinearLayout$TipsLayoutAnimListener;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean jdField_b_of_type_Boolean;
  private int e;
  private int f = 0;
  
  public TipsLinearLayout(Context paramContext)
  {
    super(paramContext);
    this.b = true;
  }
  
  public TipsLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = true;
  }
  
  @TargetApi(11)
  public TipsLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = true;
  }
  
  @Deprecated
  private float a(long paramLong)
  {
    float f2 = 0.003333333F * (float)paramLong;
    float f1 = f2;
    if (f2 > 1.0F) {
      f1 = 1.0F;
    }
    switch (this.f)
    {
    case 0: 
    default: 
      return 1.0F;
    case 1: 
      return f1;
    }
    return 1.0F - f1;
  }
  
  private int a(long paramLong)
  {
    float f2 = getMeasuredHeight();
    float f3 = f2 / 300.0F * (float)paramLong;
    float f1 = f3;
    if (f3 > f2) {
      f1 = f2;
    }
    switch (this.f)
    {
    default: 
      f1 = 0.0F;
    }
    for (;;)
    {
      return (int)f1;
      f1 = 0.0F;
      continue;
      f1 -= f2;
      continue;
      f1 = -f1;
    }
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.b = true;
    this.f = paramInt;
    invalidate();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentWidgetTipsLinearLayout$TipsLayoutAnimListener == null) {
      return;
    }
    if (this.f == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TipsLinearLayout", 2, "ANIM_IN end.");
      }
      this.jdField_a_of_type_ComTencentWidgetTipsLinearLayout$TipsLayoutAnimListener.a();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TipsLinearLayout", 2, "ANIM_OUT end.");
    }
    this.jdField_a_of_type_ComTencentWidgetTipsLinearLayout$TipsLayoutAnimListener.b();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsLinearLayout", 2, "startInAnimation");
    }
    a(1);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsLinearLayout", 2, "startOutAnimation");
    }
    a(2);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsLinearLayout", 2, "Draw....");
    }
    if ((this.jdField_a_of_type_Boolean) && (this.b))
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.b = false;
    }
    long l = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
    if ((this.jdField_a_of_type_Boolean) && (!this.b) && (l >= 300L))
    {
      this.jdField_a_of_type_Boolean = false;
      this.b = true;
      c();
    }
    if ((this.jdField_a_of_type_Boolean) && (!this.b)) {
      this.e = a(l);
    }
    for (;;)
    {
      int i = paramCanvas.save();
      paramCanvas.translate(0.0F, this.e);
      super.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
      if (!this.b) {
        invalidate();
      }
      return;
      if (this.f == 2) {
        this.e = (0 - getMeasuredHeight());
      } else {
        this.e = 0;
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void setmTipsLayoutAnimListener(TipsLinearLayout.TipsLayoutAnimListener paramTipsLayoutAnimListener)
  {
    this.jdField_a_of_type_ComTencentWidgetTipsLinearLayout$TipsLayoutAnimListener = paramTipsLayoutAnimListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.widget.TipsLinearLayout
 * JD-Core Version:    0.7.0.1
 */