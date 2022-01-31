package com.tencent.mobileqq.activity.recent;

import android.view.View;

public class Banner
{
  public static final int a = -1;
  public static final int b = 0;
  public static final int c = 2;
  public View a;
  public boolean a;
  public int d;
  public int e;
  
  public Banner(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt >= 2;
  }
  
  public boolean a()
  {
    return this.e >= 2;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(20);
    localStringBuffer.append("[").append(this.d).append(",").append(this.e).append(",").append(this.jdField_a_of_type_Boolean).append(",").append(this.jdField_a_of_type_AndroidViewView).append("]");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.Banner
 * JD-Core Version:    0.7.0.1
 */