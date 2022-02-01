package com.tencent.mobileqq.utils;

import hee;

public class UIThreadPool
{
  private static hee a;
  
  public static void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (a == null) {
      a = new hee(3, 10L);
    }
    a.execute(paramRunnable);
  }
  
  public static void b(Runnable paramRunnable)
  {
    if (paramRunnable == null) {}
    while (a == null) {
      return;
    }
    a.remove(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.UIThreadPool
 * JD-Core Version:    0.7.0.1
 */