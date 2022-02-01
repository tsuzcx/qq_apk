package com.tencent.mobileqq.fpsreport;

import android.view.animation.AnimationUtils;
import com.tencent.mobileqq.utils.PerformanceReportUtils;
import com.tencent.qphone.base.util.QLog;
import fzd;
import java.util.concurrent.CopyOnWriteArrayList;

public class FPSCalculator
{
  public static final String a;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = -1L;
  private StringBuffer jdField_a_of_type_JavaLangStringBuffer = new StringBuffer();
  private final CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private String b = null;
  
  static
  {
    jdField_a_of_type_JavaLangString = FPSCalculator.class.getSimpleName();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() < 1) {
      return;
    }
    new fzd(this).execute(new Void[0]);
  }
  
  public void a(int paramInt)
  {
    if (this.b != null)
    {
      if (paramInt == 2)
      {
        this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
        this.jdField_a_of_type_Int = 0;
      }
    }
    else {
      return;
    }
    if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_Int > 0))
    {
      long l = AnimationUtils.currentAnimationTimeMillis() - this.jdField_a_of_type_Long;
      if (l > 1000L)
      {
        paramInt = (int)Math.floor(this.jdField_a_of_type_Int * 1000 / ((float)l * 1.0F));
        this.jdField_a_of_type_JavaLangStringBuffer.setLength(0);
        this.jdField_a_of_type_JavaLangStringBuffer.append("FPSCalculator ").append(this.b).append(" frameCount :").append(this.jdField_a_of_type_Int).append(",diffTime :").append(l).append(" fps:").append(paramInt);
        if (QLog.isDevelopLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 4, this.jdField_a_of_type_JavaLangStringBuffer.toString());
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_JavaLangStringBuffer.toString());
        if ((paramInt > 0) && (this.b != null) && (!"".equals(this.b))) {
          PerformanceReportUtils.a(this.b, paramInt);
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 100) {
          a();
        }
      }
    }
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void b()
  {
    if (this.b != null) {
      this.jdField_a_of_type_Int += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.fpsreport.FPSCalculator
 * JD-Core Version:    0.7.0.1
 */