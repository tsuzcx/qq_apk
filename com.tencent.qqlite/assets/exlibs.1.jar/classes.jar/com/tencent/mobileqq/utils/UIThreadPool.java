package com.tencent.mobileqq.utils;

import ewa;

public class UIThreadPool
{
  private static ewa a;
  
  public static void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (a == null) {
      a = new ewa(3, 10L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.UIThreadPool
 * JD-Core Version:    0.7.0.1
 */