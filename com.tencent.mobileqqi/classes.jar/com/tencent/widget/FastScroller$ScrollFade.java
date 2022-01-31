package com.tencent.widget;

import android.os.SystemClock;

public class FastScroller$ScrollFade
  implements Runnable
{
  static final int jdField_a_of_type_Int = 208;
  static final long c = 200L;
  long jdField_a_of_type_Long;
  long b;
  
  public FastScroller$ScrollFade(FastScroller paramFastScroller) {}
  
  int a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetFastScroller.b() != 4) {
      return 208;
    }
    long l = SystemClock.uptimeMillis();
    if (l > this.jdField_a_of_type_Long + this.b) {
      return 0;
    }
    return (int)(208L - (l - this.jdField_a_of_type_Long) * 208L / this.b);
  }
  
  void a()
  {
    this.b = 200L;
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_ComTencentWidgetFastScroller.b(4);
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentWidgetFastScroller.b() != 4)
    {
      a();
      return;
    }
    if (a() > 0)
    {
      this.jdField_a_of_type_ComTencentWidgetFastScroller.a.invalidate();
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetFastScroller.b(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.widget.FastScroller.ScrollFade
 * JD-Core Version:    0.7.0.1
 */