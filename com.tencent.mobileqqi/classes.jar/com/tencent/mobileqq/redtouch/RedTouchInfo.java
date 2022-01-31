package com.tencent.mobileqq.redtouch;

public class RedTouchInfo
{
  public static final int a = -1;
  public static final String a = "redTouch";
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public int f;
  public int g;
  public int h;
  public int i;
  
  public static RedTouchInfo a()
  {
    return new RedTouchInfo();
  }
  
  public int a()
  {
    if (this.h > 0) {
      return 2;
    }
    if (this.g > 0) {
      return 1;
    }
    if (this.i > 0) {
      return 3;
    }
    if (this.f > 0) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchInfo
 * JD-Core Version:    0.7.0.1
 */