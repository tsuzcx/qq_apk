package com.tencent.mobileqq.fpsreport;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import com.tencent.mobileqq.utils.PerformanceReportUtils;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class FPSSlideDetectListView
  extends SlideDetectListView
{
  private FPSCalculator jdField_a_of_type_ComTencentMobileqqFpsreportFPSCalculator;
  private String jdField_a_of_type_JavaLangString;
  private boolean c = false;
  private long g = 0L;
  
  public FPSSlideDetectListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSCalculator != null) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSCalculator.a();
    }
  }
  
  protected void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSCalculator != null) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSCalculator.a(paramInt);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSCalculator != null) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSCalculator.b();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.c)
    {
      this.c = false;
      PerformanceReportUtils.a(this.jdField_a_of_type_JavaLangString, SystemClock.uptimeMillis());
    }
  }
  
  public void setActTAG(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSCalculator = new FPSCalculator();
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSCalculator.a(paramString);
    setStartTime(SystemClock.uptimeMillis());
  }
  
  public void setStartTime(long paramLong)
  {
    this.c = true;
    this.g = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.fpsreport.FPSSlideDetectListView
 * JD-Core Version:    0.7.0.1
 */