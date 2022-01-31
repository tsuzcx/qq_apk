package com.tencent.mobileqq.app;

public class AutomatorObserver
  implements BusinessObserver
{
  public static final int a = 0;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  
  protected void a() {}
  
  protected void a(int paramInt) {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    case 0: 
      a(paramBoolean, paramObject);
      return;
    case 2: 
      b();
      return;
    case 3: 
      a(((Integer)paramObject).intValue());
      return;
    }
    a();
  }
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.AutomatorObserver
 * JD-Core Version:    0.7.0.1
 */